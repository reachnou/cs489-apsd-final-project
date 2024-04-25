package edu.mui.cs489.reachnou.questify.controller;

import edu.mui.cs489.reachnou.questify.dto.QuestionDto;
import edu.mui.cs489.reachnou.questify.dto.requests.QuestionRequest;
import edu.mui.cs489.reachnou.questify.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questify/api/v1/questions")
@CrossOrigin
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<?> createQuestion(@RequestBody QuestionRequest questionRequest) {
        var question = questionService.createQuestion(questionRequest);
        return ResponseEntity.ok(question);
    }
}
