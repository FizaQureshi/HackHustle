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
    @Column(name = "student_id", nullable = false)
    private String studentID;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email_id;

    @Column(name = "points", nullable = false, columnDefinition = "long default 0")
    private Long points;

    @Column(name = "quiz_attempted", nullable = false, columnDefinition = "long default 0")
    private Long quizAttempted;
}
