package edu.mui.cs489.reachnou.questify.service.impl;

import edu.mui.cs489.reachnou.questify.entity.User;
import edu.mui.cs489.reachnou.questify.exception.UserNotFoundException;
import edu.mui.cs489.reachnou.questify.repository.UserRepository;
import edu.mui.cs489.reachnou.questify.service.CRUDService;
import edu.mui.cs489.reachnou.questify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<User> save(User entity) {
        var result = userRepository.save(entity);
        return ResponseEntity.ok(userRepository.save(result));
    }

    @Override
    public ResponseEntity<User> getById(Long id) {
        var result = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("ID " + id + " not found!"));
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<User> deleteById(Long id) {
        var result = getById(id);
        userRepository.deleteById(id);
        return result;
    }
}
