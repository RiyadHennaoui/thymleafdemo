package com.luv2code.springboot.thymleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.luv2code.springboot.thymleafdemo.model.Employee;
import com.luv2code.springboot.thymleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);

        return "employee-form";
    }





    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<Employee> employees = employeeService.findAll();
        // add to the spring model
        theModel.addAttribute("employees", employees);

        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employee-form";

    }


}
