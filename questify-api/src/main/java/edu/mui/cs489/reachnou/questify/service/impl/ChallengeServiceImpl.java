package edu.mui.cs489.reachnou.questify.service.impl;

import edu.mui.cs489.reachnou.questify.dto.ChallengeDTO;
import edu.mui.cs489.reachnou.questify.dto.requests.ChallengeRequest;
import edu.mui.cs489.reachnou.questify.entity.Challenge;
import edu.mui.cs489.reachnou.questify.exception.ResourceNotFoundException;
import edu.mui.cs489.reachnou.questify.exception.UserNotFoundException;
import edu.mui.cs489.reachnou.questify.repository.ChallengeRepository;
import edu.mui.cs489.reachnou.questify.repository.TopicRepository;
import edu.mui.cs489.reachnou.questify.repository.UserRepository;
import edu.mui.cs489.reachnou.questify.service.ChallengeService;
import edu.mui.cs489.reachnou.questify.util.ModelMappingHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final ModelMappingHelper<Challenge, ChallengeDTO, ChallengeRequest> modelMappingHelper;

    @Override
    public ChallengeDTO createChallenge(ChallengeRequest ChallengeRequest, Long hostId, Long topicId) {
        var challenge = modelMappingHelper.convertRequestToEntity(ChallengeRequest, Challenge.class);
        var host = userRepository.findById(hostId).orElseThrow(() -> new UserNotFoundException("User ID " + hostId + " not found!"));
        var topic = topicRepository.findById(topicId).orElseThrow(()-> new ResourceNotFoundException("Topic ID " + topicId + " not found!"));

        challenge.setHost(host);
        challenge.setTopic(topic);
        challenge.setCompetitors(new ArrayList<>());

        var response = challengeRepository.save(challenge);
        return modelMappingHelper.convertEntityToDto(response, ChallengeDTO.class);
    }

    @Override
    public ChallengeDTO getChallengeById(Long id) {
        var challenge = simpleGetChallengeById(id);
        return modelMappingHelper.convertEntityToDto(challenge, ChallengeDTO.class);
    }

    @Override
    public List<ChallengeDTO> getAllChallenges() {
        var challenges = challengeRepository.findAll();
        return modelMappingHelper.convertEntityListToDtoList(challenges, ChallengeDTO.class);
    }

    @Override
    public ChallengeDTO deleteChallengeById(Long id) {
        var challenge = simpleGetChallengeById(id);
        challengeRepository.deleteById(id);
        return modelMappingHelper.convertEntityToDto(challenge, ChallengeDTO.class);
    }

    @Override
    public ChallengeDTO updateChallengeById(ChallengeRequest challengeRequest, Long id) {
        var oldChallenge = simpleGetChallengeById(id);

        oldChallenge.setChallengeName(challengeRequest.getChallengeName());
        oldChallenge.setDuration(challengeRequest.getDuration());
        oldChallenge.setChallengeType(challengeRequest.getChallengeType());
        oldChallenge.setDifficulty(challengeRequest.getDifficulty());
        oldChallenge.setChallengeStatus(challengeRequest.getChallengeStatus());

        var response = challengeRepository.save(oldChallenge);
        return modelMappingHelper.convertEntityToDto(response, ChallengeDTO.class);
    }

    private Challenge simpleGetChallengeById(Long id) {
        return challengeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Challenge ID: " + id + " not found!"));
    }
}
