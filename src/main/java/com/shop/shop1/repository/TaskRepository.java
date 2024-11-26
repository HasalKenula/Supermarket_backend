package com.shop.shop1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.shop1.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    
}
