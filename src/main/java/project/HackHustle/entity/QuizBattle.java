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
@Table(name = "quizbattle")
public class QuizBattle
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "QuizID", nullable = false)
    private String quizID;

    @Column(name = "Date", nullable = false)
    private LocalDateTime date;

    @Column(name = "StudentID", nullable = false)
    private String studentID;

    @Column(name = "QuizScore", nullable = false)
    private Long quizScore;

    @Column(name = "Status", nullable = false)
    private String status;

    @Column(name = "SubjectName", nullable = false)
    private String subjectName;
}
