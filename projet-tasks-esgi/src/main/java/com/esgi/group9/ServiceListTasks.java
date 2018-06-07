package com.esgi.group9;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceListTasks implements IServiceListTasks {
	
	@Autowired
	private IListTasksDAO dao;

	@Transactional(readOnly=true)
	public List<Task> searchTasks() {
		return dao.searchTasks();
	}

	@Transactional
	public void createTask(String pDescription, Boolean pUrgent) {
		final Task lTask = new Task();
		lTask.setDescription(pDescription);
		lTask.setUrgent(pUrgent);
		dao.createTask(lTask);
	}
	
	@Transactional
	public void deleteTask(final Integer pIdTask) {
		final Task lTask = new Task();
        lTask.setId(pIdTask);

        dao.deleteTask(lTask);
	}
}
