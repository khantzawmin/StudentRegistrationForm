package com.example.Student_Registration.controller;

import com.example.Student_Registration.model.Course;
import com.example.Student_Registration.model.Student;
import org.springframework.ui.Model;
import com.example.Student_Registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class StudentController {

    @Autowired
    StudentService studentService;

    private void populateModelAttributes(Model model) {
        model.addAttribute("courses", Course.values());
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
    }

    @GetMapping("/")
    public String homePage(Model model) {
        populateModelAttributes(model);
        model.addAttribute("student", new Student());
        return "index";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/editStudent/{id}")
    public String editStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        populateModelAttributes(model);
        return "index";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}



