package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Course;
import mk.finki.ukim.mk.lab.model.Teacher;
import mk.finki.ukim.mk.lab.model.enumerations.Type;
import mk.finki.ukim.mk.lab.service.CourseService;
import mk.finki.ukim.mk.lab.service.StudentService;
import mk.finki.ukim.mk.lab.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public CourseController(CourseService courseService, StudentService studentService, TeacherService teacherService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model)
    {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Course> courses = this.courseService.listAll();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        if(this.courseService.findById(id).isPresent()){
            Course course = this.courseService.findById(id).get();
            List<Teacher> teachers = this.teacherService.findAll();
            model.addAttribute("teachers", teachers);
            model.addAttribute("course", course);
            return "add-course";
        }
        return "redirect:/courses?error=ProductNotFound";
    }


    @GetMapping("/add-course")
    public String addProductPage(Model model) {
        List<Teacher> teachers = this.teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "add-course";
    }

    @PostMapping("/add")
    public String saveCourse(String name, String description, Long teacherId, Type type)
    {
        Teacher teacher = teacherService.findById(teacherId).get();
        this.courseService.save(name, description, teacher, type);
        return "redirect:/courses";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id)
    {
        this.courseService.deleteById(id);
        return "redirect:/courses";
    }
}
