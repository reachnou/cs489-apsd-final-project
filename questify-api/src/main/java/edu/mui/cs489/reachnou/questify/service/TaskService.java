package edu.mui.cs489.reachnou.questify.service;

import edu.mui.cs489.reachnou.questify.dto.TaskDTO;
import edu.mui.cs489.reachnou.questify.dto.requests.TaskRequest;
import edu.mui.cs489.reachnou.questify.dto.responses.TaskResponse;
import edu.mui.cs489.reachnou.questify.entity.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(TaskRequest taskRequest, Long userId);
    TaskDTO getTaskById(Long id);
    TaskDTO deleteTaskById(Long id);
    List<TaskDTO> getAllTasks();
    List<TaskDTO> getTasksByUserId(Long userId);
    TaskDTO updateTaskById(TaskRequest taskRequest, Long id);
}
