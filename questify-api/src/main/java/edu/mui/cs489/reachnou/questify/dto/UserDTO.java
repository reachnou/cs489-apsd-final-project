package edu.mui.cs489.reachnou.questify.dto;

import edu.mui.cs489.reachnou.questify.dto.requests.UserRequest;
import edu.mui.cs489.reachnou.questify.dto.responses.UserResponse;
import edu.mui.cs489.reachnou.questify.entity.User;
import lombok.Builder;
import lombok.Data;

public class UserDTO {
    public static UserResponse userResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }

    public static User userRequestToUser(UserRequest userRequest) {
        return User.builder()
                .fullName(userRequest.getFullName())
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .roles(userRequest.getRoles())
                .build();
    }
}
