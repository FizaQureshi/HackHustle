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
@Table(name = "user_assessment")
public class UserAssessment
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "assessment_id", nullable = false)
    private String assessmentID;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "subject_id", nullable = false)
    private String subjectID;

    @Column(name = "topic_id", nullable = false)
    private String topicID;

    @Column(name = "student_id", nullable = false)
    private String studentID;

    @Column(name = "assessment_score", nullable = false)
    private Long assessmentScore;
}
