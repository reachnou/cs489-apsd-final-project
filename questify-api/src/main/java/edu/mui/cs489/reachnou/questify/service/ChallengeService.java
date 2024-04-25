package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.ChallengeDto;
import edu.mui.cs489.reachnou.questify.dto.requests.ChallengeRequest;

import java.util.List;

public interface ChallengeService {
    ChallengeDto createChallenge(ChallengeRequest ChallengeRequest, Long hostId, Long topicId);
    ChallengeDto getChallengeById(Long id);
    List<ChallengeDto> getAllChallenges();
    ChallengeDto deleteChallengeById(Long id);
    ChallengeDto updateChallengeById(ChallengeRequest challengeRequest, Long id);
}
