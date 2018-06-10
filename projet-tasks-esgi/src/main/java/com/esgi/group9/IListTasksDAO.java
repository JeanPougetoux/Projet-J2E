package com.esgi.group9;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

public interface IListTasksDAO {
	<T> List<Task> searchTasks(boolean ascending, SingularAttribute<Task, T> attribute);
	void createTask(final Task pTask);
	void deleteTask(final Task pTask);
	void modifyTask(final Task pTask);
	List<Task> searchUrgentTasks();
}
