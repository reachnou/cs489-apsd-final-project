package edu.mui.cs489.reachnou.questify.constants;

public enum TaskStatus {
    TODO("TODO"), IN_PROGRESS("IN_PROGRESS"), COMPLETED("COMPLETED"), CANCELLED("CANCELLED"), ON_HOLD("ON_HOLD");

    private String status;

    TaskStatus(String status) {
        this.status = status;
    }
}
