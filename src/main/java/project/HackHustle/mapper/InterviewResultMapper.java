package project.HackHustle.mapper;

import project.HackHustle.dto.InterviewResultDto;
import project.HackHustle.entity.InterviewResult;

import java.util.Optional;

public class InterviewResultMapper {

    public static InterviewResult mapToInterviewResult(InterviewResultDto interviewResultDto)
    {
        return new InterviewResult(interviewResultDto.getInterviewResultID(), interviewResultDto.getQuestion_1(), interviewResultDto.getProvidedAns_1(), interviewResultDto.getBetterAns_1(), interviewResultDto.getQuestion_2(),
                interviewResultDto.getProvidedAns_2(), interviewResultDto.getBetterAns_2(), interviewResultDto.getQuestion_3(), interviewResultDto.getProvidedAns_3(),
                interviewResultDto.getBetterAns_3(), interviewResultDto.getInterviewScore(), interviewResultDto.getInterviewID());
    }

    public static InterviewResultDto mapToInterviewResultDto(InterviewResult interviewResult)
    {
        return new InterviewResultDto(interviewResult.getInterviewID(), interviewResult.getQuestion_1(), interviewResult.getProvidedAns_1(),
                interviewResult.getBetterAns_1(), interviewResult.getQuestion_2(), interviewResult.getProvidedAns_2(), interviewResult.getBetterAns_2(),
                interviewResult.getQuestion_3(), interviewResult.getProvidedAns_3(), interviewResult.getBetterAns_3(), interviewResult.getInterviewScore(), interviewResult.getInterviewID());
    }
}
