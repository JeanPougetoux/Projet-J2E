package com.esgi.group9;

import java.util.List;

public interface IServiceListTasks {
	List<Task> searchTasks();
	void createTask(final String pDescription, final Boolean pUrgent);
	void deleteTask(final Integer pIdTask);
}
