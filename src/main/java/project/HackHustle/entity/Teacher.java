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
@Table(name = "teacher")

public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "teacher_id", nullable = false)
    private String teacherID;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email_id;

    @Column(name = "rating", nullable = false, columnDefinition = "long default 0")
    private Long rating;

    @Column(name = "subject_associated", nullable = false)
    private String subjectAssociated;   //a teacher handles only one subject

    @Column(name = "institute", nullable = false)
    private String institute;
}
