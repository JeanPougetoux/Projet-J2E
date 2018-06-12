package com.esgi.group9.models;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import com.esgi.group9.business.Task;

/**
 * The Interface IListTasksDAO.
 */
public interface IListTasksDAO {
	
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
	 * @param pTask the task to create
	 */
	void createTask(final Task pTask);
	
	/**
	 * Delete task.
	 *
	 * @param pTask the task to delete
	 */
	void deleteTask(final Task pTask);
	
	/**
	 * Modify task.
	 *
	 * @param pTask the task to modify
	 */
	void modifyTask(final Task pTask);
	
	/**
	 * Search urgent tasks.
	 *
	 * @return the list of urgent tasks
	 */
	List<Task> searchUrgentTasks();
}
