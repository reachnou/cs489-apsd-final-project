package edu.mui.cs489.reachnou.questify.controller;

import edu.mui.cs489.reachnou.questify.dto.ChallengeDTO;
import edu.mui.cs489.reachnou.questify.dto.requests.ChallengeRequest;
import edu.mui.cs489.reachnou.questify.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questify/api/v1/challenges")
public class ChallengeController {
    private final ChallengeService challengeService;

    @PostMapping
    public ResponseEntity<?> createChallenge(
            @RequestBody ChallengeRequest challengeRequest,
            @RequestParam(name = "hostId") Long hostId,
            @RequestParam(name = "topicId") Long topicId) {
        return ResponseEntity.ok(challengeService.createChallenge(challengeRequest, hostId, topicId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getChallengeById(@PathVariable Long id) {
        return ResponseEntity.ok(challengeService.getChallengeById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllChallenges() {
        return ResponseEntity.ok(challengeService.getAllChallenges());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChallengeById(@PathVariable Long id){
        return ResponseEntity.ok(challengeService.deleteChallengeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTopicById(@RequestBody ChallengeRequest challengeRequest, @PathVariable Long id){
        return ResponseEntity.ok(challengeService.updateChallengeById(challengeRequest, id));
    }
}
