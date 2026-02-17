package project.HackHustle.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.HackHustle.battle.BattleManager;
import project.HackHustle.battle.BattleRoom;

@RestController
@RequestMapping("/api/battle")
@AllArgsConstructor
public class BattleController {



        private final BattleManager battleManager;

        @PostMapping("/create/{studentId}")
        public String createBattle(@PathVariable Long studentId) {
            return battleManager.createBattle(studentId);
        }

        @PostMapping("/join/{code}/{studentId}")
        public BattleRoom joinBattle(@PathVariable String code,
                                     @PathVariable Long studentId) {
            return battleManager.joinBattle(code, studentId);
        }

        @PostMapping("/start/{code}/{studentId}")
        public String startBattle(@PathVariable String code,
                                  @PathVariable Long studentId) {

            battleManager.startBattle(code, studentId);
            return "Battle Started";
        }
    }


