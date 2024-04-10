package edu.mui.cs489.reachnou.questify.dto.requests;

import edu.mui.cs489.reachnou.questify.constants.TaskPriority;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequest {
    private String name;
    private String description;
    private LocalDateTime deadline;
    private TaskPriority priority;
}
