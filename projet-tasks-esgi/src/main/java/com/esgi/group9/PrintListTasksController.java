package com.esgi.group9;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/tasks")
public class PrintListTasksController {

	@Autowired
    private IServiceListTasks service;

    @RequestMapping(method = RequestMethod.GET)
    public String afficher(ModelMap pModel) {
        final List<Task> lListeTasks = service.searchTasks();
        pModel.addAttribute("listTasks", lListeTasks);
        return "listTasks";
    }
    
    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public String supprimer(@RequestParam(value="idTask") final Integer pIdTask, final ModelMap pModel) {

        service.deleteTask(pIdTask);
        return afficher(pModel);
    }
    
}
