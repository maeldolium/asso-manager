package com.assoManager.asso_manager.repository;

import models.Task;
import models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByProjectTitle(String title);

    List<Task> findByCompletedFalse();
}
