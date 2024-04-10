package edu.mui.cs489.reachnou.questify.dto;

import edu.mui.cs489.reachnou.questify.dto.requests.TaskRequest;
import edu.mui.cs489.reachnou.questify.dto.responses.TaskResponse;
import edu.mui.cs489.reachnou.questify.entity.Task;

import java.util.List;

public class TaskDTO {

    public static Task taskRequestToTask(TaskRequest taskRequest) {
        var task = Task.builder()
                .name(taskRequest.getName())
                .description(taskRequest.getDescription())
                .deadline(taskRequest.getDeadline())
                .priority(taskRequest.getPriority())
                .build();
        return task;
    }

    public static TaskResponse taskToTaskResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .deadline(task.getDeadline())
                .userId(task.getUser().getId())
                .username(task.getUser().getUsername())
                .build();
    }

    public static List<TaskResponse> taskListToTaskListResponse(List<Task> tasks) {
        return tasks.stream()
                .map(TaskDTO::taskToTaskResponse)
                .toList();
    }
}
