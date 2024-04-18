package edu.mui.cs489.reachnou.questify.service.impl;

import edu.mui.cs489.reachnou.questify.dto.TopicDTO;
import edu.mui.cs489.reachnou.questify.dto.requests.TopicRequest;
import edu.mui.cs489.reachnou.questify.dto.responses.TopicResponse;
import edu.mui.cs489.reachnou.questify.entity.Topic;
import edu.mui.cs489.reachnou.questify.exception.ResourceNotFoundException;
import edu.mui.cs489.reachnou.questify.repository.TopicRepository;
import edu.mui.cs489.reachnou.questify.service.TopicService;
import edu.mui.cs489.reachnou.questify.util.ModelMappingHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;
    private final ModelMappingHelper<Topic, TopicDTO, TopicRequest> modelMappingHelper;

    @Override
    public TopicDTO createTopic(TopicRequest topicRequest) {
        var topic = modelMappingHelper.convertRequestToEntity(topicRequest, Topic.class);
        var response = topicRepository.save(topic);
        return modelMappingHelper.convertEntityToDto(response, TopicDTO.class);
    }

    @Override
    public TopicDTO getTopicById(Long id) {
        var topic = simpleFindTopicById(id);
        return modelMappingHelper.convertEntityToDto(topic, TopicDTO.class);
    }

    @Override
    public List<TopicDTO> getAllTopics() {
        var topics = topicRepository.findAll();
        return modelMappingHelper.convertEntityListToDtoList(topics, TopicDTO.class);
    }

    @Override
    public TopicDTO deleteTopicById(Long id) {
        var topic = simpleFindTopicById(id);
        topicRepository.deleteById(id);
        return modelMappingHelper.convertEntityToDto(topic, TopicDTO.class);
    }

    @Override
    public TopicDTO updateTopicById(TopicRequest topicRequest, Long id) {
        var oldTopic = simpleFindTopicById(id);
        oldTopic.setName(topicRequest.getName());
        var response = topicRepository.save(oldTopic);
        return modelMappingHelper.convertEntityToDto(response, TopicDTO.class);
    }

    private Topic simpleFindTopicById(Long id) {
        return topicRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Topic not found!"));
    }

}
