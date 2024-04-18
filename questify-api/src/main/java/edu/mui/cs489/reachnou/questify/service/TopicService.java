package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.TopicDTO;
import edu.mui.cs489.reachnou.questify.dto.requests.TopicRequest;
import edu.mui.cs489.reachnou.questify.dto.responses.TopicResponse;
import edu.mui.cs489.reachnou.questify.entity.Topic;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TopicService {
    TopicDTO createTopic(TopicRequest topicRequest);
    TopicDTO getTopicById(Long id);
    List<TopicDTO> getAllTopics();
    TopicDTO deleteTopicById(Long id);
    TopicDTO updateTopicById(TopicRequest topicRequest, Long id);
}
