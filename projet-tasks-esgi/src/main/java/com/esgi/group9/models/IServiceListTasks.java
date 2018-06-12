package com.esgi.group9.models;


import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import com.esgi.group9.business.Task;


/**
 * The Interface IServiceListTasks.
 */
public interface IServiceListTasks {
	
	/**
	 * Search tasks.
	 *
	 * @param <T> the generic type, string for description, int for priority
	 * @param ascending true if list is ascending, else false
	 * @param attribute meta-model for priority of description for the column to order
	 * @return the list ordered
	 */
	<T> List<Task> searchTasks(boolean ascending, SingularAttribute<Task, T> attribute);
	
	/**
	 * Creates the task.
	 *
	 * @param pDescription the description of the new task
	 * @param pPriority the priority of the new task
	 */
	void createTask(final String pDescription, final Integer pPriority);
	
	/**
	 * Delete task.
	 *
	 * @param pIdTask the id of the task to delete
	 */
	void deleteTask(final Integer pIdTask);
	
	/**
	 * Modify task.
	 *
	 * @param pIdTask the id of the task to modify
	 * @param pDescription the new description for the task
	 * @param pPriority the new priority for the task
	 */
	void modifyTask(final Integer pIdTask, final String pDescription, final Integer pPriority);
	
	/**
	 * Search ugent tasks.
	 *
	 * @return the list of urgent tasks
	 */
	List<Task> searchUgentTasks();
}
