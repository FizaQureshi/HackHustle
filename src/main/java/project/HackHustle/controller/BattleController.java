//package project.HackHustle.controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//
//
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import project.HackHustle.battle.BattleManager;
//import project.HackHustle.battle.BattleRoom;
//import project.HackHustle.service.BattleManagerService;
//
////////@RestController
////////@RequestMapping("/api/battle")
////////@AllArgsConstructor
////////public class BattleController {
////////
////////
////////
////////        private final BattleManager battleManager;
////////
////////        @PostMapping("/create/{studentId}")
////////        public String createBattle(@PathVariable Long studentId) {
////////            return battleManager.createBattle(studentId);
////////        }
////////
////////        @PostMapping("/join/{code}/{studentId}")
////////        public BattleRoom joinBattle(@PathVariable String code,
////////                                     @PathVariable Long studentId) {
////////            return battleManager.joinBattle(code, studentId);
////////        }
////////
////////        @PostMapping("/start/{code}/{studentId}")
////////        public String startBattle(@PathVariable String code,
////////                                  @PathVariable Long studentId) {
////////
////////            battleManager.startBattle(code, studentId);
////////            return "Battle Started";
////////        }
////////    }
////////
////////
//////
//////
//////
//////@RestController
//////@RequestMapping("/api/battle")
//////@RequiredArgsConstructor
//////public class BattleController {
//////
//////    private final BattleManagerService battleManagerService;
//////
//////    @PostMapping("/create/{studentId}")
//////    public String createBattle(@PathVariable Long studentId) {
//////        return battleManagerService.createBattle(studentId);
//////    }
//////
//////    @PostMapping("/join/{code}/{studentId}")
//////    public BattleRoom joinBattle(@PathVariable String code,
//////                                 @PathVariable Long studentId) {
//////        return battleManagerService.joinBattle(code, studentId);
//////    }
//////
//////    @PostMapping("/start/{code}/{studentId}")
//////    public String startBattle(@PathVariable String code,
//////                              @PathVariable Long studentId) {
//////        battleManagerService.startBattle(code, studentId);
//////        return "Battle Started";
//////    }
//////}
////
////
////package project.HackHustle.controller;
////
////import lombok.RequiredArgsConstructor;
////import org.springframework.web.bind.annotation.*;
////import project.HackHustle.battle.BattleRoom;
////import project.HackHustle.service.BattleManagerService;
////
////@RestController
////@RequestMapping("/api/battle")
////@RequiredArgsConstructor
////public class BattleController {
////
////    private final BattleManagerService battleManagerService;
////
////    /**
////     * CREATE BATTLE
////     * Host creates battle and becomes first player
////     */
////    @PostMapping("/create/{studentId}")
////    public String createBattle(@PathVariable Long studentId) {
////        return battleManagerService.createBattle(studentId);
////    }
////
////    /**
////     * JOIN BATTLE
////     * Any student joins using battle code
////     */
////    @PostMapping("/join/{code}/{studentId}")
////    public BattleRoom joinBattle(@PathVariable String code,
////                                 @PathVariable Long studentId) {
////        return battleManagerService.joinBattle(code, studentId);
////    }
////
////    /**
////     * START BATTLE
////     * Only host can start
////     */
////    @PostMapping("/start/{code}/{studentId}")
////    public String startBattle(@PathVariable String code,
////                              @PathVariable Long studentId) {
////
////        battleManagerService.startBattle(code, studentId);
////        return "Battle Started Successfully";
////    }
////
////    /**
////     * GET BATTLE ROOM (optional but useful for frontend refresh)
////     */
////    @GetMapping("/{code}")
////    public BattleRoom getBattleRoom(@PathVariable String code) {
////        return battleManagerService.getRoom(code);
////    }
////}
//@RestController
//@RequestMapping("/api/battle")
//
//public class BattleController {
//
//    private final BattleManagerService battleManagerService;
//
//    public BattleController(BattleManagerService battleManagerService) {
//        this.battleManagerService = battleManagerService;
//    }
//
//    @PostMapping("/create/{studentId}")
//    public String createBattle(@PathVariable Long studentId) {
//        return battleManagerService.createBattle(studentId);
//    }
//
//    @PostMapping("/join/{code}/{studentId}")
//    public BattleRoom joinBattle(@PathVariable String code,
//                                 @PathVariable Long studentId) {
//        return battleManagerService.joinBattle(code, studentId);
//    }
//
//    @PostMapping("/start/{code}/{studentId}")
//    public String startBattle(@PathVariable String code,
//                              @PathVariable Long studentId) {
//        battleManagerService.startBattle(code, studentId);
//        return "Battle Started Successfully";
//    }
//
//    @GetMapping("/{code}")
//    public BattleRoom getBattleRoom(@PathVariable String code) {
//        return battleManagerService.getRoom(code);
//    }
//}

package project.HackHustle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.HackHustle.battle.BattleRoom;
import project.HackHustle.service.BattleManagerService;

@RestController
@RequestMapping("/api/battle")
@RequiredArgsConstructor
public class BattleController {

    private final BattleManagerService battleManagerService;

    /**
     * CREATE BATTLE
     * Host creates battle and becomes first player
     */
    @PostMapping("/create/{studentId}")
    public ResponseEntity<String> createBattle(@PathVariable Long studentId) {
        String battleCode = battleManagerService.createBattle(studentId);
        return ResponseEntity.ok(battleCode);
    }

    /**
     * JOIN BATTLE
     * Student joins using battle code
     */
    @PostMapping("/join/{code}/{studentId}")
    public ResponseEntity<BattleRoom> joinBattle(@PathVariable String code,
                                                 @PathVariable Long studentId) {
        BattleRoom room = battleManagerService.joinBattle(code, studentId);
        return ResponseEntity.ok(room);
    }

    /**
     * START BATTLE
     * Only host can start
     */
    @PostMapping("/start/{code}/{studentId}")
    public ResponseEntity<String> startBattle(@PathVariable String code,
                                              @PathVariable Long studentId) {
        battleManagerService.startBattle(code, studentId);
        return ResponseEntity.ok("Battle Started Successfully");
    }

    /**
     * GET BATTLE ROOM
     * Useful for frontend refresh or polling
     */
    @GetMapping("/{code}")
    public ResponseEntity<BattleRoom> getBattleRoom(@PathVariable String code) {
        BattleRoom room = battleManagerService.getRoom(code);
        return ResponseEntity.ok(room);
    }
}