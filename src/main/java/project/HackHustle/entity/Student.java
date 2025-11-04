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
@Table(name = "student")

public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "StudentID", nullable = false)
    private String studentID;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "Email", nullable = false, unique = true)
    private String email_id;

    @Column(name = "Points", nullable = false, columnDefinition = "long default 0")
    private Long points;

    @Column(name = "QuizAttempted", nullable = false, columnDefinition = "long default 0")
    private Long quizAttempted;
}
