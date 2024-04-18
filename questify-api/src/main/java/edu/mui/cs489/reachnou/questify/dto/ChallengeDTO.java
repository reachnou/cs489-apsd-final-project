package edu.mui.cs489.reachnou.questify.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.mui.cs489.reachnou.questify.constants.ChallengeStatus;
import edu.mui.cs489.reachnou.questify.constants.ChallengeType;
import edu.mui.cs489.reachnou.questify.constants.Difficulty;
import edu.mui.cs489.reachnou.questify.entity.Challenge;
import edu.mui.cs489.reachnou.questify.entity.Topic;
import edu.mui.cs489.reachnou.questify.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class ChallengeDTO {
    private Long id;
    private String challengeName;
    private int duration;
    private TopicDTO topic;
    private UserDTO host;
    private List<UserDTO> competitors;
    private ChallengeType challengeType;
    private Difficulty difficulty;
    private ChallengeStatus challengeStatus;

}
