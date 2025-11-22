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
@Table(name = "doubt")
public class Doubt
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doubt_id", nullable = false)
    private Long doubtID;

    @Column(name = "doubt_status", nullable = false)
    private String  doubtStatus = "False";

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "query_asked", nullable = false)
    private String queryAsked;

    @Column(name = "answer_provided", nullable = false)
    private String answerProvided;

    @Column(name = "student_id", nullable = false)
    private String studentID;

    @Column(name = "question_id", nullable = false)
    private String questionID;

    @Column(name = "teacher_id", nullable = false)
    private String teacherID;
}
