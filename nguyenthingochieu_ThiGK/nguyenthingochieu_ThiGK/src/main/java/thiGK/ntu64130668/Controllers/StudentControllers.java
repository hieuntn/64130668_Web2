package thiGK.ntu64130668.Controllers;


import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import thiGK.ntu64130668.models.Student;

@Controller
public class StudentControllers {

    static List<Student> students = new ArrayList<Student>();

    static {
        students.add(new Student("1", "Alice", "G1"));
        students.add(new Student("2", "Bob", "G1"));
        students.add(new Student("3", "Charlie", "G2"));
        students.add(new Student("4", "David", "G2"));
        students.add(new Student("5", "Eve", "G3"));
    }

    @GetMapping("/student/all")
    public String listStudents(Model model) {
        model.addAttribute("students", students);
        return "studentList";
    }
}