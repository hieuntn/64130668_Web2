package giaiGK.ntu64130668.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import giaiGK.ntu64130668.Model.Student;

@Controller
public class StudentControllers {
	static List<Student> students = new ArrayList<Student>();

    static {
        students.add(new Student("1", "Nguyễn Văn An", "G1"));
        students.add(new Student("2", "Nguyễn Thị Ngọc Huyền", "G1"));
        students.add(new Student("3", "Đinh Trọng Vũ", "G2"));
        students.add(new Student("4", "Hồ Nhật Nam", "G2"));
        students.add(new Student("5", "Đinh Văn Thanh", "G3"));
    }

    @GetMapping("/student/all")
    public String listStudents(Model model) {
        model.addAttribute("listST", students);
        return "dsStudent";
    }
}
