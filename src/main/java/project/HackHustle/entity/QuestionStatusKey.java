package project.HackHustle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class QuestionStatusKey implements Serializable
{
    @Column(name = "question_id", nullable = false)
    private Long questionID;

    @Column(name = "student_id", nullable = false)
    private Long studentID;

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!(obj instanceof QuestionStatusKey))
            return false;
        QuestionStatusKey qsk = (QuestionStatusKey) obj;
        return questionID.equals(qsk.questionID) && studentID.equals(qsk.studentID);
    }

    @Override
    public int hashCode()
    {
        return java.util.Objects.hash(questionID, studentID);
    }
}
