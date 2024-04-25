package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.QuestionDto;
import edu.mui.cs489.reachnou.questify.dto.requests.QuestionRequest;

public interface QuestionService {
    QuestionDto createQuestion(QuestionRequest questionRequest);
}
