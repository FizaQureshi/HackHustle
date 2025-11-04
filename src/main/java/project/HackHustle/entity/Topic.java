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
@Table(name = "topic")
public class Topic
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "TopicID", nullable = false)
    private String topicID;

    @Column(name = "TopicName", nullable = false)
    private String topicName;

    @Column(name = "SubjectID", nullable = false)
    private String subjectID;
}
