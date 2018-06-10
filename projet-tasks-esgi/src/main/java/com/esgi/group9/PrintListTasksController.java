package com.esgi.group9;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.esgi.group9.IServiceListTasks;
import com.esgi.group9.Task;

@Controller
@RequestMapping(value = "/tasks")
public class PrintListTasksController {

	@Autowired
	private IServiceListTasks service;

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

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String supprimer(@RequestParam(value = "idTask") final Integer pIdTask, final ModelMap pModel) {
		try {
			service.deleteTask(pIdTask);
		} catch (Exception e) {
			pModel.addAttribute("error", "Impossible de supprimer la tâche ! Celle-ci n'existe probablement pas.");
		}
		return afficher("ascending", "description", pModel);
	}

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

	@RequestMapping(method = RequestMethod.POST)
	public String creer(@RequestParam(value = "description") final String description,
			@RequestParam(value = "priority") final Integer priority, final ModelMap pModel) {
		service.createTask(description, priority);
		return afficher("ascending", "description", pModel);
	}

}
