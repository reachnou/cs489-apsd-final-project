package edu.mui.cs489.reachnou.questify.service.impl;

import edu.mui.cs489.reachnou.questify.constants.TaskStatus;
import edu.mui.cs489.reachnou.questify.dto.TaskDTO;
import edu.mui.cs489.reachnou.questify.dto.requests.TaskRequest;
import edu.mui.cs489.reachnou.questify.dto.responses.TaskResponse;
import edu.mui.cs489.reachnou.questify.entity.Task;
import edu.mui.cs489.reachnou.questify.exception.UserNotFoundException;
import edu.mui.cs489.reachnou.questify.repository.TaskRepository;
import edu.mui.cs489.reachnou.questify.repository.UserRepository;
import edu.mui.cs489.reachnou.questify.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<Task> createTask(TaskRequest taskRequest, Long userId) {
        var user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found!"));

        var task = TaskDTO.taskRequestToTask(taskRequest);
        task.setUser(user);
        task.setStatus(TaskStatus.TODO);

        var result = taskRepository.save(task);

        // Task response

        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Task> getById(Long id) {
        var result = taskRepository.findById(id).orElseThrow(() -> new UserNotFoundException("ID " + id + " not found!"));
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Task> deleteById(Long id) {
        var result = getById(id);
        taskRepository.deleteById(id);
        return result;
    }

    @Override
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        var tasks = taskRepository.findAll();
        var result = TaskDTO.taskListToTaskListResponse(tasks);
        return ResponseEntity.ok(result);
    }

}
