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
@Table(name = "userassessment")
public class UserAssessment
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "AssessmentID", nullable = false)
    private String assessmentID;

    @Column(name = "Date", nullable = false)
    private LocalDateTime date;

    @Column(name = "SubjectID", nullable = false)
    private String subjectID;

    @Column(name = "TopicID", nullable = false)
    private String topicID;

    @Column(name = "StudentID", nullable = false)
    private String studentID;

    @Column(name = "AssessmentScore", nullable = false)
    private Long assessmentScore;
}
