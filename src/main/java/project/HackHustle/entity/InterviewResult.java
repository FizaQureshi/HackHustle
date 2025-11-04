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
@Table(name = "interviewresult")
public class InterviewResult
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "InterviewResultID", nullable = false)
    private String interviewResultID;

    @Column(name = "Question_1", nullable = false)
    private String question_1;

    @Column(name = "ProvidedAns_1", nullable = false)
    private String providedAns_1;

    @Column(name = "BetterAns_1", nullable = false)
    private String betterAns_1;

    @Column(name = "Question_2", nullable = false)
    private String question_2;

    @Column(name = "ProvidedAns_2", nullable = false)
    private String providedAns_2;

    @Column(name = "BetterAns_2", nullable = false)
    private String betterAns_2;

    @Column(name = "Question_3", nullable = false)
    private String question_3;

    @Column(name = "ProvidedAns_3", nullable = false)
    private String providedAns_3;

    @Column(name = "BetterAns_3", nullable = false)
    private String betterAns_3;

    @Column(name = "InterviewScore", nullable = false)
    private Long interviewScore;

    @Column(name = "InterviewID", nullable = false)
    private String interviewID;
}
