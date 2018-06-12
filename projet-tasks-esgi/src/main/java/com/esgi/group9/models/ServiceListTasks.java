package com.esgi.group9.models;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esgi.group9.business.Task;


/**
 * The Class ServiceListTasks.
 */
@Service
public class ServiceListTasks implements IServiceListTasks {

	/** The dao. */
	@Autowired
	private IListTasksDAO dao;

	/* (non-Javadoc)
	 * @see com.esgi.group9.models.IServiceListTasks#searchTasks(boolean, javax.persistence.metamodel.SingularAttribute)
	 */
	@Transactional(readOnly = true)
	public <T> List<Task> searchTasks(boolean ascending, SingularAttribute<Task, T> attribute) {
		List<Task> tasks = dao.searchTasks(ascending, attribute);
		return tasks;
	}

	/* (non-Javadoc)
	 * @see com.esgi.group9.models.IServiceListTasks#createTask(java.lang.String, java.lang.Integer)
	 */
	@Transactional
	public void createTask(String pDescription, Integer pPriority) {
		final Task lTask = new Task();
		lTask.setDescription(pDescription);
		lTask.setPriority(pPriority);
		lTask.setCreation(new Date());
		dao.createTask(lTask);
	}

	/* (non-Javadoc)
	 * @see com.esgi.group9.models.IServiceListTasks#deleteTask(java.lang.Integer)
	 */
	@Transactional
	public void deleteTask(final Integer pIdTask) {
		final Task lTask = new Task();
		lTask.setId(pIdTask);

		dao.deleteTask(lTask);
	}

	/* (non-Javadoc)
	 * @see com.esgi.group9.models.IServiceListTasks#modifyTask(java.lang.Integer, java.lang.String, java.lang.Integer)
	 */
	@Transactional
	public void modifyTask(Integer pIdTask, String pDescription, Integer pPriority) {
		final Task lTask = new Task();
		lTask.setId(pIdTask);
		lTask.setDescription(pDescription);
		lTask.setPriority(pPriority);
		
		dao.modifyTask(lTask);
	}

	/* (non-Javadoc)
	 * @see com.esgi.group9.models.IServiceListTasks#searchUgentTasks()
	 */
	@Transactional(readOnly = true)
	public List<Task> searchUgentTasks() {
		List<Task> tasks = dao.searchUrgentTasks();
		return tasks;
	}
}
