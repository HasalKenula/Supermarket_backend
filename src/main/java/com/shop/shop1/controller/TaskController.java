package com.shop.shop1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.shop1.entity.Task;
import com.shop.shop1.service.TaskService;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
        public ResponseEntity<?> createTask(@RequestBody Task task){
            if(task.getTaskName()==null||task.getTaskName()==""){
                return ResponseEntity.status(400).body("please enter the name");

            }

            if(task.getPriorty()==null){
                return ResponseEntity.status(400).body("please enter the priority");

            }

            try {
                Task createTask=taskService.createTask(task);
                return ResponseEntity.status(201).body(createTask);
            } catch (Exception e) {
                return ResponseEntity.status(400).body(e.getMessage());
            }
        }

    
    @GetMapping("/task")
        public ResponseEntity<List<Task>> getAllTask(){
            List<Task> getAllTask=taskService.getAllTask();
            return ResponseEntity.status(201).body(getAllTask);
        }


    @GetMapping("/task/{taskId}")
        public ResponseEntity<Task> getTaskById(@PathVariable Long taskId){
            Task getTaskById=taskService.getTaskById(taskId);

            if(getTaskById==null){
                return ResponseEntity.status(404).body(null);

            }else{
                return ResponseEntity.status(201).body(getTaskById);
            }
        }

    @PutMapping("/task/{taskId}")
        public ResponseEntity<Task> updateTask(@PathVariable Long taskId,@RequestBody Task task){
            Task updateTask=taskService.updateTask(taskId, task);

            if(updateTask==null){
                return ResponseEntity.status(404).body(null);
            }else{
                return ResponseEntity.status(201).body(updateTask);
            }
        }

    @DeleteMapping("/task/{taskId}")
        public void deleteTask(@PathVariable Long taskId){
            taskService.deleteTask(taskId);
        }
}
