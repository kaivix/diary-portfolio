package com.kaivix.iamjustleason.controllers;

import com.kaivix.iamjustleason.model.Student;
import com.kaivix.iamjustleason.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("student", studentService.findAll());
        return "lists/studentlist";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("student", studentService.findOne(id));
        return "show";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "add";
    }
    @PostMapping()
    public String create(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "add";
        studentService.save(student);
        return "redirect:/student";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("student", studentService.findOne(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "edit";
        }
        studentService.update(id, student);
        return "redirect:/student";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        studentService.delete(id);
        return "redirect:/student";
    }
}
