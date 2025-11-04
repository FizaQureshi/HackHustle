package project.HackHustle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "question")
public class Question
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "QuestionID", nullable = false)
    private String questionID;

    @Column(name = "QuestionText", nullable = false)
    private String questionText;

    @Column(name = "Option1", nullable = false)
    private String option1;

    @Column(name = "Option2", nullable = false)
    private String option2;

    @Column(name = "Option3", nullable = false)
    private String option3;

    @Column(name = "Option4", nullable = false)
    private String option4;

    @Column(name = "CorrectAnswer", nullable = false)
    private String correctAnswer;

    @Column(name = "TopicID", nullable = false)
    private String topicID;
}
