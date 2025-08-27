package com.daniel.tasks.controller;

import com.daniel.tasks.enums.EnumStatus;
import com.daniel.tasks.model.Task;
import com.daniel.tasks.repository.TaskRepository;
import com.daniel.tasks.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/tasks")
public class TaskViewController {

    private final TaskRepository taskRepository;
    private final TaskService taskService;

    public TaskViewController(TaskRepository taskRepository, TaskService taskService) {
        this.taskRepository = taskRepository;
        this.taskService = taskService;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("task", new Task()); // For form binding
        model.addAttribute("statuses", EnumStatus.values()); // For dropdown
        return "tasks";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        task.setCreatedAt(LocalDateTime.now());
        taskService.createTask(task);
        return "redirect:/tasks";
    }
}
