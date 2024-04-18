package edu.mui.cs489.reachnou.questify.service.impl;

import edu.mui.cs489.reachnou.questify.dto.TaskDTO;
import edu.mui.cs489.reachnou.questify.dto.requests.TaskRequest;
import edu.mui.cs489.reachnou.questify.entity.Task;
import edu.mui.cs489.reachnou.questify.exception.BadRequestException;
import edu.mui.cs489.reachnou.questify.exception.UserNotFoundException;
import edu.mui.cs489.reachnou.questify.repository.TaskRepository;
import edu.mui.cs489.reachnou.questify.repository.UserRepository;
import edu.mui.cs489.reachnou.questify.service.TaskService;
import edu.mui.cs489.reachnou.questify.util.ModelMappingHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ModelMappingHelper<Task, TaskDTO, TaskRequest> modelMappingHelper;

    @Override
    public TaskDTO createTask(TaskRequest taskRequest, Long userId) {
        var user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found!"));

        if (isDateTimeInputNotInThePast(taskRequest.getDeadline())) {
            var task = modelMappingHelper.convertRequestToEntity(taskRequest, Task.class);
            task.setUser(user);

            var result = taskRepository.save(task);

            return modelMappingHelper.convertEntityToDto(result, TaskDTO.class);
        }
        return null;
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        var task = simpleFindTaskById(id);
        return modelMappingHelper.convertEntityToDto(task, TaskDTO.class);
    }

    @Override
    public TaskDTO deleteTaskById(Long id) {
        var task = simpleFindTaskById(id);
        taskRepository.deleteById(id);
        return modelMappingHelper.convertEntityToDto(task, TaskDTO.class);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        var tasks = taskRepository.findAll();
        return modelMappingHelper.convertEntityListToDtoList(tasks, TaskDTO.class);
    }

    @Override
    public List<TaskDTO> getTasksByUserId(Long userId) {
        var tasks = taskRepository.findTasksByUserId(userId);
        return modelMappingHelper.convertEntityListToDtoList(tasks, TaskDTO.class);
    }

    @Override
    public TaskDTO updateTaskById(TaskRequest taskRequest, Long id) {
        LocalDateTime userDateTime = LocalDateTime.parse(taskRequest.getDeadline().toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        var oldTask = simpleFindTaskById(id);

        oldTask.setName(taskRequest.getName());
        oldTask.setDescription(taskRequest.getDescription());
        oldTask.setDeadline(userDateTime);
        oldTask.setPriority(taskRequest.getPriority());
        oldTask.setStatus(taskRequest.getStatus());

        var response = taskRepository.save(oldTask);
        return modelMappingHelper.convertEntityToDto(response, TaskDTO.class);
    }

    private Task simpleFindTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Task ID: " + id + " not found!"));
    }

    private boolean isDateTimeInputNotInThePast(LocalDateTime localDateTime) {
        try {
            LocalDateTime userDateTime = LocalDateTime.parse(localDateTime.toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            LocalDateTime now = LocalDateTime.now();

            if (userDateTime.isBefore(now)) {
                throw new IllegalArgumentException("User input date and time is less than the current date and time.");
            } else {
                return true;
            }
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date time format provided.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

}
