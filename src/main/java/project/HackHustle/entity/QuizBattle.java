package project.HackHustle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "quiz_battle")
public class QuizBattle
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "quiz_id", nullable = false)
    private String quizID;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "student_id", nullable = false)
    private String studentID;

    @Column(name = "quiz_score", nullable = false)
    private Long quizScore;

    @Column(name = "quiz_status", nullable = false)
    private String status;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;
}
