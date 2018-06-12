package com.esgi.group9.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.esgi.group9.business.Task;
import com.esgi.group9.business.Task_;

/**
 * The Class PrintListTasksController. Controller of the main servlet.
 */
@Controller
@RequestMapping(value = "/tasks")
public class PrintListTasksController {

	/** The service that allow to CRUD tasks. */
	@Autowired
	private com.esgi.group9.models.IServiceListTasks service;

	/**
	 * Print the page, correspond to url/tasks.
	 *
	 * @param orderType the order type, ascending or descending (default ascending)
	 * @param orderColumn the order column, description or priority (default priority)
	 * @param pModel the model
	 * @return the name of the .jsp (here listTasks.jsp)
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String afficher(@RequestParam(value = "orderType", defaultValue = "ascending") final String orderType,
			@RequestParam(value = "orderColumn", defaultValue = "description") final String orderColumn,
			ModelMap pModel) {

		List<Task> lListeTasks;
		List<Task> lUrgentListeTasks;
		boolean ascending = (!(orderType.compareTo("descending") == 0));
		if (orderColumn.compareTo("priority") == 0) {
			lListeTasks = service.searchTasks(ascending, Task_.priority);
			pModel.addAttribute("forOrderPriority",
					(orderType.compareTo("descending") == 0) ? "ascending" : "descending");
			pModel.addAttribute("forOrderDescription", "ascending");
			pModel.addAttribute("iconPriority",
					(orderType.compareTo("descending") == 0) ? "arrow_drop_up" : "arrow_drop_down");
			pModel.addAttribute("iconDescription", "arrow_drop_down");
		} else {
			lListeTasks = service.searchTasks(ascending, Task_.description);
			pModel.addAttribute("forOrderDescription",
					(orderType.compareTo("descending") == 0) ? "ascending" : "descending");
			pModel.addAttribute("forOrderPriority", "ascending");
			pModel.addAttribute("iconDescription",
					(orderType.compareTo("descending") == 0) ? "arrow_drop_up" : "arrow_drop_down");
			pModel.addAttribute("iconPriority", "arrow_drop_down");
		}
		
		lUrgentListeTasks = service.searchUgentTasks();
		pModel.addAttribute("listTasks", lListeTasks);
		pModel.addAttribute("urgentTasks", lUrgentListeTasks);
		return "listTasks";
	}

	/**
	 * Delete a task page, correspond to url/tasks/delete
	 *
	 * @param pIdTask the id of the task which to delete
	 * @param pModel the model
	 * @return the name of the .jsp (here listTasks.jsp)
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String supprimer(@RequestParam(value = "idTask") final Integer pIdTask, final ModelMap pModel) {
		try {
			service.deleteTask(pIdTask);
		} catch (Exception e) {
			pModel.addAttribute("error", "Impossible de supprimer la tâche ! Celle-ci n'existe probablement pas.");
		}
		return afficher("ascending", "description", pModel);
	}

	/**
	 * Modify a task page, correspond to url/tasks/modify
	 *
	 * @param pIdTask the id of the task which to modify
	 * @param pDescription the new description of the task
	 * @param pPriority the new priority of the task
	 * @param pModel the model
	 * @return the name of the .jsp (here listTasks.jsp)
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifier(@RequestParam(value = "idTask") final Integer pIdTask,
			@RequestParam(value = "description") final String pDescription,
			@RequestParam(value = "priority") final Integer pPriority, final ModelMap pModel) {
		try {
			service.modifyTask(pIdTask, pDescription, pPriority);
		} catch (Exception e) {
			pModel.addAttribute("error", "Impossible de modifier la tâche !");
		}
		return afficher("ascending", "description", pModel);
	}

	/**
	 * Create a task page, correspond to url/tasks, but post
	 *
	 * @param description the description of the new task
	 * @param priority the priority of the new task
	 * @param pModel the model
	 * @return the name of the .jsp (here listTasks.jsp)
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String creer(@RequestParam(value = "description") final String description,
			@RequestParam(value = "priority") final Integer priority, final ModelMap pModel) {
		service.createTask(description, priority);
		return afficher("ascending", "description", pModel);
	}

}
