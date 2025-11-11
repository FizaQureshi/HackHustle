package project.HackHustle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "student")

public class Student
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "student_id", nullable = false)
//    private UUID studentID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;


    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;

    @Column(name = "points", nullable = false)
    private Long points = 0L;

    @Column(name = "quiz_attempted", nullable = false)
    private Long quizAttempted = 0L;
}
