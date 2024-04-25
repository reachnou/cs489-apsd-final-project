package edu.mui.cs489.reachnou.questify.dto.requests;

import lombok.Data;

@Data
public class AnswerRequest {
    private String content;
    private boolean isCorrect;
    private Long questionId;
}
