package com.gsrr.TaskManagement.tasks;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class DeadLineScheduler {
	private TaskRepository taskRepository;

    public void DeadlineScheduler(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // runs once per day at midnight
    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void decrementDailyDeadlines() {
        List<Task> tasks = taskRepository.findAll();

        for (Task task : tasks) {
            Integer deadline = task.getCompleteWithin();
            // only decrement if > 0 and task not already completed
            if (deadline != null && deadline > 0 && !task.getStatus().equals("COMPLETED")) {
                task.setCompleteWithin(deadline - 1);
            }
        }

        taskRepository.saveAll(tasks);
    }
}
