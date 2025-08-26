package com.daniel.tasks.service;

import com.daniel.tasks.config.RabbitConfig;
import com.daniel.tasks.enums.EnumStatus;
import com.daniel.tasks.model.Task;
import com.daniel.tasks.repository.TaskRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final RabbitTemplate rabbitTemplate;

    public TaskService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        Task taskCreated = taskRepository.save(task);
        //rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, "testing rabbitMq service-stop-start");
        return taskCreated;
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByStatus(String status) {
        EnumStatus enumStatus;
        try {
            enumStatus = EnumStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status inválido: " + status);
        }
        return taskRepository.findByStatus(enumStatus);
    }
}
