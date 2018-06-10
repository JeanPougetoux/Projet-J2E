package com.esgi.group9;


import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import com.esgi.group9.Task;

public interface IServiceListTasks {
	<T> List<Task> searchTasks(boolean ascending, SingularAttribute<Task, T> attribute);
	void createTask(final String pDescription, final Integer pPriority);
	void deleteTask(final Integer pIdTask);
	void modifyTask(final Integer pIdTask, final String pDescription, final Integer pPriority);
	List<Task> searchUgentTasks();
}
