package project.HackHustle.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.HackHustle.battle.BattleRoom;
import project.HackHustle.battle.BattleStatus;
import java.util.UUID;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class BattleManagerService {

    private Map<String, BattleRoom> activeBattles = new ConcurrentHashMap<>();
    private final SimpMessagingTemplate messagingTemplate;


    public String createBattle(Long hostId) {

        String code = generateCode();

        BattleRoom room = new BattleRoom();
        room.setBattleCode(code);
        room.setHostId(hostId);
        room.getPlayers().add(hostId);
        room.getScores().put(hostId, 0);

        activeBattles.put(code, room);

        return code;
    }

    public BattleRoom joinBattle(String code, Long studentId) {

        BattleRoom room = activeBattles.get(code);

        if (room == null)
            throw new RuntimeException("Invalid Code");

        if (room.getPlayers().size() >= 5)
            throw new RuntimeException("Battle Full");

        if (room.getStatus() != BattleStatus.WAITING)
            throw new RuntimeException("Already Started");

        if (room.getPlayers().contains(studentId))
            throw new RuntimeException("Already Joined");

        room.getPlayers().add(studentId);
        room.getScores().put(studentId, 0);

        return room;
    }

    public void startBattle(String code, Long studentId) {

        BattleRoom room = activeBattles.get(code);

        if (!room.getHostId().equals(studentId))
            throw new RuntimeException("Only Host Can Start");

        if (room.getPlayers().size() < 2)
            throw new RuntimeException("Minimum 2 Players Required");

        room.setStatus(BattleStatus.LIVE);
    }
    public void handleJoin(project.HackHustle.socket.SocketMessage message) {

        BattleRoom room = activeBattles.get(message.getCode());
        if (room == null) return;

        messagingTemplate.convertAndSend(
                "/topic/" + message.getCode(),
                "Player " + message.getStudentId() + " joined"
        );
    }

    public void handleAnswer(project.HackHustle.socket.SocketMessage message) {

        BattleRoom room = activeBattles.get(message.getCode());

        if (room == null || room.getStatus() != BattleStatus.LIVE)
            return;

        if ("A".equalsIgnoreCase(message.getAnswer())) {
            room.getScores().merge(message.getStudentId(), 10, Integer::sum);
        }

        messagingTemplate.convertAndSend(
                "/topic/" + message.getCode(),
                room.getScores()
        );
    }

    private String generateCode() {
        return UUID.randomUUID().toString().substring(0,6).toUpperCase();
    }

    public BattleRoom getRoom(String code) {
        return activeBattles.get(code);
    }
}

