package com.esgi.group9;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esgi.group9.IListTasksDAO;
import com.esgi.group9.IServiceListTasks;
import com.esgi.group9.Task;

@Service
public class ServiceListTasks implements IServiceListTasks {

	@Autowired
	private IListTasksDAO dao;

	@Transactional(readOnly = true)
	public <T> List<Task> searchTasks(boolean ascending, SingularAttribute<Task, T> attribute) {
		List<Task> tasks = dao.searchTasks(ascending, attribute);
		return tasks;
	}

	@Transactional
	public void createTask(String pDescription, Integer pPriority) {
		final Task lTask = new Task();
		lTask.setDescription(pDescription);
		lTask.setPriority(pPriority);
		lTask.setCreation(new Date());
		dao.createTask(lTask);
	}

	@Transactional
	public void deleteTask(final Integer pIdTask) {
		final Task lTask = new Task();
		lTask.setId(pIdTask);

		dao.deleteTask(lTask);
	}

	@Transactional
	public void modifyTask(Integer pIdTask, String pDescription, Integer pPriority) {
		final Task lTask = new Task();
		lTask.setId(pIdTask);
		lTask.setDescription(pDescription);
		lTask.setPriority(pPriority);
		
		dao.modifyTask(lTask);
	}

	@Transactional(readOnly = true)
	public List<Task> searchUgentTasks() {
		List<Task> tasks = dao.searchUrgentTasks();
		return tasks;
	}
}
