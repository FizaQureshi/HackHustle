package project.HackHustle.mapper;

import project.HackHustle.dto.InterviewDto;
import project.HackHustle.entity.Interview;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class InterviewMapper {

    public static Interview mapToInterview(InterviewDto interviewDto)
    {
        return new Interview(interviewDto.getInterviewID(), LocalDateTime.now(), interviewDto.getStudentID());
    }

    public static InterviewDto mapToInterviewDto(Interview interview)
    {
        return new InterviewDto(interview.getInterviewID(), interview.getStudentID());
    }
}
