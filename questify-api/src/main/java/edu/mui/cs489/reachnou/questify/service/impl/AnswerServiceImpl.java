package edu.mui.cs489.reachnou.questify.service.impl;

import edu.mui.cs489.reachnou.questify.dto.AnswerDto;
import edu.mui.cs489.reachnou.questify.dto.requests.AnswerRequest;
import edu.mui.cs489.reachnou.questify.entity.Answer;
import edu.mui.cs489.reachnou.questify.exception.ResourceNotFoundException;
import edu.mui.cs489.reachnou.questify.repository.AnswerRepository;
import edu.mui.cs489.reachnou.questify.repository.QuestionRepository;
import edu.mui.cs489.reachnou.questify.service.AnswerService;
import edu.mui.cs489.reachnou.questify.util.ModelMappingHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final ModelMappingHelper<Answer, AnswerDto, AnswerRequest> modelMappingHelper;
    @Override
    public AnswerDto createAnswer(AnswerRequest answerRequest) {
        var question = questionRepository.findById(answerRequest.getQuestionId()).orElseThrow(() -> new ResourceNotFoundException("Question not found"));
        var answer = Answer.builder()
                .content(answerRequest.getContent())
                .isCorrect(answerRequest.isCorrect())
                .question(question)
                .build();
        var response = answerRepository.save(answer);
        return modelMappingHelper.convertEntityToDto(response, AnswerDto.class);
    }
}
