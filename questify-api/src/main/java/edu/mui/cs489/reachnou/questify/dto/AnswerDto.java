package edu.mui.cs489.reachnou.questify.dto;

import lombok.Data;

@Data
public class AnswerDto {
    private Long id;
    private String content;
    private boolean isCorrect;
}
