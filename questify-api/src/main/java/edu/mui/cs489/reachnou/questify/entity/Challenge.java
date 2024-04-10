package edu.mui.cs489.reachnou.questify.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Challenge {
    private Long id;
    private User challengerId;
    private User friendId;
    private List<Question> questions;
}
