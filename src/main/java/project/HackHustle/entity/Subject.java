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
@Table(name = "subject")
public class Subject
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subject_id", nullable = false)
    private String subjectID;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    @Column(name = "total_questions", nullable = false)
    private Long totalQuestions;
}
