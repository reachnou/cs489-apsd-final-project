package edu.mui.cs489.reachnou.questify.controller;

import edu.mui.cs489.reachnou.questify.dto.requests.TaskRequest;
import edu.mui.cs489.reachnou.questify.entity.Task;
import edu.mui.cs489.reachnou.questify.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest, @RequestParam Long userId){
        return taskService.createTask(taskRequest, userId);
    }

    @GetMapping
    public ResponseEntity<?> getAllTask(){
        return taskService.getAllTasks();
    }
}
