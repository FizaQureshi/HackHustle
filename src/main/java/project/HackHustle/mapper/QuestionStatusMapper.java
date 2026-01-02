package project.HackHustle.mapper;

import project.HackHustle.dto.QuestionStatusDto;
import project.HackHustle.entity.Question;
import project.HackHustle.entity.QuestionStatus;
import project.HackHustle.entity.QuestionStatusKey;
import project.HackHustle.entity.Student;

public class QuestionStatusMapper {

    public static QuestionStatus maptoQuestionStatus(QuestionStatusDto questionStatusDto)
    {
        //return new QuestionStatus(new QuestionStatusKey(questionStatusDto.getQuestionID(),questionStatusDto.getStudentID()),"true");
        QuestionStatusKey key = new QuestionStatusKey(questionStatusDto.getQuestionID(), questionStatusDto.getStudentID());

        // Create minimal Question and Student objects with only ID set
        Question question = new Question();
        question.setQuestionID(questionStatusDto.getQuestionID());

        Student student = new Student();
        student.setStudentId(questionStatusDto.getStudentID());

        // Create QuestionStatus entity
        QuestionStatus status = new QuestionStatus();
        status.setId(key);
        status.setQuestion(question);
        status.setStudent(student);
        status.setStatus("true"); // or handle dynamically

        return status;
    }
}
