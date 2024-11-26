package com.shop.shop1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.shop1.entity.Task;

@Service
public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTask();
    Task getTaskById(Long id);
    Task updateTask(Long id,Task task);
    void deleteTask(Long id);

}
