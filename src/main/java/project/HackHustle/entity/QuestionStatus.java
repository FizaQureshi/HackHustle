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
@Table(name = "question_status")
public class QuestionStatus
{
    @EmbeddedId
    private QuestionStatusKey id;

    @Column(name = "question_status", nullable = false, columnDefinition = "varchar(255) default 'False'")
    private String status;
}
