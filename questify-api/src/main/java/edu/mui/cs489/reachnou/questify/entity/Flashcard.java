package edu.mui.cs489.reachnou.questify.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flashcard {
    private Long id;
    private Question question;
    private Topic topic;
}
