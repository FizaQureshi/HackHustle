package project.HackHustle.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.HackHustle.dto.DoubtDto;
import project.HackHustle.service.DoubtService;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/doubts")
public class DoubtController {

  private DoubtService doubtService;

  //saving the doubt
  @PostMapping
    public ResponseEntity<DoubtDto> createDoubt(@RequestBody  DoubtDto doubtDto)
  {
      DoubtDto saveddoubt = doubtService.saveDoubt(doubtDto);
      return new ResponseEntity<>(saveddoubt, HttpStatus.CREATED);
  }

  //updating the doubt
    @PutMapping("update")
   public ResponseEntity<DoubtDto> updateDoubt( @RequestBody DoubtDto  doubtDto)
    {
       DoubtDto updateDoubt = doubtService.updateDoubt(doubtDto);
       return new ResponseEntity<>(updateDoubt,HttpStatus.ACCEPTED);
    }

    @GetMapping("teacher/{id}")
  public ResponseEntity<?> teacherdoubtlist(@PathVariable Long id)
    {
        List<DoubtDto> list = doubtService.teacherdoubtlist(id);
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No doubts found for teacher ID " + id);
        }
        return ResponseEntity.ok(list);
    }
    @GetMapping("student/{id}")
    public ResponseEntity<?> studentdoubtlist(@PathVariable Long id)
    {
        List<DoubtDto> list = doubtService.studentdoubtlist(id);
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No doubts found for student ID " + id);
        }
        return ResponseEntity.ok(list);
    }

    //get permission for schedule cleanup from fiza
  @DeleteMapping
      public ResponseEntity<String> deleteDoubt()
      {
          doubtService.deleteDoubt();
          return ResponseEntity.ok("resolved doubts  deleted successfully");
      }

}
