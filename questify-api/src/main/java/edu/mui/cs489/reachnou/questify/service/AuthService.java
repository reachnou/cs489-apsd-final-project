package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.UserDTO;
import edu.mui.cs489.reachnou.questify.dto.requests.LoginRequest;
import edu.mui.cs489.reachnou.questify.dto.requests.UserRequest;
import edu.mui.cs489.reachnou.questify.dto.responses.UserResponse;
import edu.mui.cs489.reachnou.questify.entity.User;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    UserResponse login(LoginRequest loginRequest);
    UserDTO registerUser(UserRequest userRequest) throws Exception;
}
