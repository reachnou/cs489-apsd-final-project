package edu.mui.cs489.reachnou.questify.service.impl;

import edu.mui.cs489.reachnou.questify.dto.QuestionDto;
import edu.mui.cs489.reachnou.questify.dto.requests.QuestionRequest;
import edu.mui.cs489.reachnou.questify.entity.Question;
import edu.mui.cs489.reachnou.questify.exception.ResourceNotFoundException;
import edu.mui.cs489.reachnou.questify.repository.QuestionRepository;
import edu.mui.cs489.reachnou.questify.repository.TopicRepository;
import edu.mui.cs489.reachnou.questify.service.QuestionService;
import edu.mui.cs489.reachnou.questify.util.ModelMappingHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final TopicRepository topicRepository;
    private final ModelMappingHelper<Question, QuestionDto, QuestionRequest> modelMappingHelper;
    @Override
    public QuestionDto createQuestion(QuestionRequest questionRequest) {
        var topic = topicRepository.findById(questionRequest.getTopicId()).orElseThrow(() -> new ResourceNotFoundException("Topic not found"));
        var question = Question.builder()
                        .content(questionRequest.getContent())
                                .difficulty(questionRequest.getDifficulty())
                                        .topic(topic)
                                                .build();
        var response = questionRepository.save(question);
        return modelMappingHelper.convertEntityToDto(response, QuestionDto.class);
    }
}
