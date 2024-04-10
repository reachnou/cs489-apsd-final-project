package edu.mui.cs489.reachnou.questify.controller;

import edu.mui.cs489.reachnou.questify.service.TaskService;
import edu.mui.cs489.reachnou.questify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

}
