package com.shop.shop1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.shop1.entity.Task;
import com.shop.shop1.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id ){
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task updateTask(Long id,Task task){
        Task ID=taskRepository.findById(id).orElse(null);

        if(ID==null){
            return null;
        }else{
            ID.setTaskName(task.getTaskName());
            ID.setPriorty(task.getPriorty());
            ID.setDuDateTime(task.getDuDateTime());

            return taskRepository.save(ID);
        }
    }

    @Override
    public void deleteTask(Long id){
         taskRepository.deleteById(id);
    }
}
