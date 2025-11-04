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
@Table(name = "interview")
public class Interview
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "InterviewID", nullable = false)
    private String interviewID;

    @Column(name = "Date", nullable = false)
    private LocalDateTime date;

    @Column(name = "StudentID", nullable = false)
    private String studentID;
}
