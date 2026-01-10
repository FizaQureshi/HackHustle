package project.HackHustle.mapper;

import project.HackHustle.dto.QuestionStatusDto;
import project.HackHustle.entity.Question;
import project.HackHustle.entity.QuestionStatus;
import project.HackHustle.entity.QuestionStatusKey;
import project.HackHustle.entity.Student;

//public class QuestionStatusMapper {
//
//    public static QuestionStatus maptoQuestionStatus(QuestionStatusDto questionStatusDto)
//    {
//        //return new QuestionStatus(new QuestionStatusKey(questionStatusDto.getQuestionID(),questionStatusDto.getStudentID()),"true");
//        QuestionStatusKey key = new QuestionStatusKey(questionStatusDto.getQuestionID(), questionStatusDto.getStudentId());
//
//        // Create minimal Question and Student objects with only ID set
//        Question question = new Question();
//        question.setQuestionID(questionStatusDto.getQuestionID());
//
//        Student student = new Student();
//        student.setStudentId(questionStatusDto.getStudentId());
//
//        // Create QuestionStatus entity
//        QuestionStatus status = new QuestionStatus();
//        status.setId(key);
//        status.setQuestion(question);
//        status.setStudent(student);
//        status.setStatus("true"); // or handle dynamically
//
//        return status;
//    }
//}
public class QuestionStatusMapper {

    public static QuestionStatus toEntity(
            Question question,
            Student student,
            String status
    ) {
        QuestionStatusKey key = new QuestionStatusKey(
                question.getQuestionID(),
                student.getStudentId()
        );

        QuestionStatus qs = new QuestionStatus();
        qs.setId(key);
        qs.setQuestion(question);
        qs.setStudent(student);
        qs.setStatus(status);

        return qs;
    }
}
