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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "DoubtID", nullable = false)
    private String doubtID;

    @Column(name = "Status", nullable = false, columnDefinition = "varchar(255) default 'False'")
    private String  status;

    @Column(name = "Date", nullable = false)
    private LocalDateTime date;

    @Column(name = "QueryAsked", nullable = false)
    private String queryAsked;

    @Column(name = "AnswerProvided", nullable = false)
    private String answerProvided;

    @Column(name = "StudentID", nullable = false)
    private String studentID;

    @Column(name = "QuestionID", nullable = false)
    private String questionID;

    @Column(name = "TeacherID", nullable = false)
    private String teacherID;
}
