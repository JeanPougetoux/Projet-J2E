package com.esgi.group9;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/add")
public class AddTaskController {
	
	@Autowired
    private IServiceListTasks service;

	@RequestMapping(method = RequestMethod.GET)
    public String afficher(final ModelMap pModel) {
        if (pModel.get("creation") == null) {
            pModel.addAttribute("creation", new CreationForm());
        }
        return "addTask";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String creer(@Valid @ModelAttribute(value="creation") final CreationForm pCreation, 
            final BindingResult pBindingResult, final ModelMap pModel) {
        if (!pBindingResult.hasErrors()) {
            service.createTask(pCreation.getDescription(), true);
        }
        return afficher(pModel);
    }
    
}