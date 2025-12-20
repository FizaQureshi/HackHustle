package project.HackHustle.mapper;

import project.HackHustle.dto.QuestionStatusDto;
import project.HackHustle.entity.QuestionStatus;
import project.HackHustle.entity.QuestionStatusKey;

public class QuestionStatusMapper {

    public static QuestionStatus maptoQuestionStatus(QuestionStatusDto questionStatusDto)
    {
        return new QuestionStatus(new QuestionStatusKey(questionStatusDto.getQuestionID(),questionStatusDto.getStudentID()),"true");
    }
}
