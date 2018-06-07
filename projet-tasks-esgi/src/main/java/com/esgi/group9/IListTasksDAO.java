package com.esgi.group9;

import java.util.List;

public interface IListTasksDAO {
	List<Task> searchTasks();
	void createTask(final Task pTask);
	void deleteTask(final Task pTask);
}
