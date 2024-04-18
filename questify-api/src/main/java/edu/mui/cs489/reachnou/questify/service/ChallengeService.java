package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.ChallengeDTO;
import edu.mui.cs489.reachnou.questify.dto.requests.ChallengeRequest;
import edu.mui.cs489.reachnou.questify.entity.Challenge;

import java.util.List;

public interface ChallengeService {
    ChallengeDTO createChallenge(ChallengeRequest ChallengeRequest, Long hostId, Long topicId);
    ChallengeDTO getChallengeById(Long id);
    List<ChallengeDTO> getAllChallenges();
    ChallengeDTO deleteChallengeById(Long id);
    ChallengeDTO updateChallengeById(ChallengeRequest challengeRequest, Long id);
}
