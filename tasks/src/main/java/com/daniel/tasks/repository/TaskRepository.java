package com.daniel.tasks.repository;

import com.daniel.tasks.enums.EnumStatus;
import com.daniel.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(EnumStatus status);

}
