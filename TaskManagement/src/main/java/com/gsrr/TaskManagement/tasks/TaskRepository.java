package com.gsrr.TaskManagement.tasks;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gsrr.TaskManagement.tasks.Task.Status;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>, JpaSpecificationExecutor<Task> {

	Task getByStatus(Status status);

	List<Task> findByUserId(Integer id);

	List<Task> findByProjectId(Integer id);


}
