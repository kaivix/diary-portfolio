package com.kaivix.iamjustleason.controllers;

import com.kaivix.iamjustleason.model.Subject;
import com.kaivix.iamjustleason.services.GradeService;
import com.kaivix.iamjustleason.services.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;
    private final GradeService gradeService;
    @Autowired
    public SubjectController(SubjectService diaryService, GradeService gradeService) {
        this.subjectService = diaryService;
        this.gradeService = gradeService;
    }



    //Показать список предметов
    @GetMapping("")
    public String getDiaries(Model model){
        model.addAttribute("sub", subjectService.getAllDiaries());
        return "lists/sublist";
    }



    @GetMapping("/add")
    public String addDiary(Model model){
        model.addAttribute("diary", new Subject());
        return "addsub";
    }

    @PostMapping()
    public String create(@ModelAttribute("diary") @Valid Subject subject, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "add";
        subjectService.saveDiary(subject);
        return "redirect:/";
    }


    //Показывает оценки учеников по одному предмету
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        System.out.println(gradeService.getOne(id));
        model.addAttribute("grades", gradeService.getOne(id));
        return "showdiary";
    }
}
