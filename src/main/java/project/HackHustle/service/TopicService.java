package project.HackHustle.service;

import project.HackHustle.dto.TopicDto;
import java.util.List;

public interface TopicService {

    List<TopicDto> getTopicsBySubjectId(Long subjectID);

    long countTopicsBySubjectId(Long subjectID);
}
