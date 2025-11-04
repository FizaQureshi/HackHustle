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
    @Column(name = "TeacherID", nullable = false)
    private String teacherID;

    @Column(name = "TeacherName", nullable = false)
    private String teacherName;

    @Column(name = "Email", nullable = false, unique = true)
    private String email_id;

    @Column(name = "Rating", nullable = false, columnDefinition = "long default 0")
    private Long rating;

    @Column(name = "SubjectAssociated", nullable = false)
    private String subjectAssociated;   //a teacher handles only one subject

    @Column(name = "Institute", nullable = false)
    private String institute;
}
