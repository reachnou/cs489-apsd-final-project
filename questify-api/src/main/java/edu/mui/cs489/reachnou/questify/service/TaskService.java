package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.requests.TaskRequest;
import edu.mui.cs489.reachnou.questify.dto.responses.TaskResponse;
import edu.mui.cs489.reachnou.questify.entity.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    ResponseEntity<Task> createTask(TaskRequest taskRequest, Long userId);
    ResponseEntity<Task> getById(Long id);
    ResponseEntity<Task> deleteById(Long id);
    ResponseEntity<List<TaskResponse>> getAllTasks();
}
