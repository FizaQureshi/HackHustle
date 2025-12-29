package project.HackHustle.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.HackHustle.dto.TopicDto;
import project.HackHustle.entity.Topic;
import project.HackHustle.mapper.TopicMapper;
import project.HackHustle.repository.TopicRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Override
    public List<TopicDto> getTopicsBySubjectId(Long subjectID) {
        List<Topic> topics = topicRepository.findBySubject_SubjectID(subjectID);

        return topics.stream()
                .map(TopicMapper::mapToTopicDto)
                .collect(Collectors.toList());
    }

    @Override
    public long countTopicsBySubjectId(Long subjectID) {
        return topicRepository.countBySubject_SubjectID(subjectID);
    }
}
