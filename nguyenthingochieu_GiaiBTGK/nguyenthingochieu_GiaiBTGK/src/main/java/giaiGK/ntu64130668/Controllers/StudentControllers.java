package giaiGK.ntu64130668.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import giaiGK.ntu64130668.Model.Student;




@Controller
public class StudentControllers {
	static List<Student> listST = new ArrayList<Student>();

    static {
        listST.add(new Student("1", "Nguyễn Văn An", "G1"));
        listST.add(new Student("2", "Nguyễn Thị Ngọc Huyền", "G1"));
        listST.add(new Student("3", "Đinh Trọng Vũ", "G2"));
        listST.add(new Student("4", "Hồ Nhật Nam", "G2"));
        listST.add(new Student("5", "Đinh Văn Thanh", "G3"));
    }

    @GetMapping("/student/all")
    public String listStudents(Model model) {
        model.addAttribute("listST", listST);
        return "dsStudent";
    }
    @GetMapping("/student/new")
    public String formAddNew(Model m) {
        Student st = new Student();                     
        m.addAttribute("addStudent", st);            
        return "formStudent";                          
    }

    
	@PostMapping("/student/new")
	public String submitForm(@ModelAttribute("addStudent") Student st) {
		listST.add(st);
	    return "redirect:/student/all"; 
	}
	//xem chi tiết 1 student 
	 @GetMapping("/student/view/{id}")
	    public String viewStudent(@PathVariable String id, Model model) {
	        
	        Student st = listST.stream()
	                .filter(t -> t.getId().equals(id))
	                .findFirst()
	                .orElse(null);
	        if (st == null) {
	            return "redirect:/student/all"; // Không tìm thấy -> quay lại danh sách
	        }
	        
	        // Truyền dữ liệu vào view
	        model.addAttribute("student", st);
	       
	        return "student_detail"; 
	    }
	 // Sửa 1 hs
	 //hiện thị form hs
	 @GetMapping("/student/edit/{id}")
	 public String EditForm(@PathVariable String id, Model model) {
		    Student st = listST.stream()
		            .filter(t -> t.getId().equals(id))
		            .findFirst()
		            .orElse(null);

		    if (st == null) {
		        return "redirect:/student/all";
		    }

		    model.addAttribute("student", st);
		    return "stEdit"; // trang form để chỉnh sửa
		}
	 //Xử lí edit student
	 @PostMapping("/student/edit/{id}")
	 public String editStudent(@PathVariable String id, @ModelAttribute("student") Student updatedStudent) {
	     
	     // Tìm topic cũ
	     for (int i = 0; i < listST.size(); i++) {
	         if (listST.get(i).getId().equals(id)) {
	             // Cập nhật thông tin
	             listST.set(i, updatedStudent);
	             break;
	         }
	     }

	     return "redirect:/student/view/" + id;
	 }
	 @GetMapping("/student/delete/{id}")
	 public String deleteStudent(@PathVariable String id) {
	     listST.removeIf(t -> t.getId().equals(id));
	     return "redirect:/student/all";
	 }


}
