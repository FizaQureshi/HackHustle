package project.HackHustle.mapper;

import project.HackHustle.dto.DoubtDto;
import project.HackHustle.entity.Doubt;

public class DoubtMapper {

    public static DoubtDto mapToDoubtDto(Doubt doubt)
    {
        return new DoubtDto(doubt.getDoubtID(),
                doubt.getDoubtStatus(), doubt.getDate(),
                doubt.getQueryAsked(), doubt.getAnswerProvided(),
                doubt.getStudentID(), doubt.getQuestionID(),
                doubt.getTeacherID());
    }

    public static Doubt mapToDoubt(DoubtDto doubtDto)
    {
        return new Doubt(doubtDto.getDoubtID(), doubtDto.getDoubtStatus(),
                doubtDto.getDate(), doubtDto.getQueryAsked(), doubtDto.getAnswerProvided(),
                doubtDto.getStudentID(), doubtDto.getQuestionID(),
                doubtDto.getTeacherID()

        );
    }
}
