package giaiGK.ntu64130668.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import giaiGK.ntu64130668.Model.Topic;




@Controller
public class TopicControllers {
	 static List<Topic> danhSachDeTai = new ArrayList<>();

	    static {
	        danhSachDeTai.add(new Topic("T001", "Nghiên cứu AI", "Nghiên cứu về trí tuệ nhân tạo", "S001", "Nghiên cứu"));
	        danhSachDeTai.add(new Topic("T002", "Blockchain", "Khám phá công nghệ Blockchain", "S002", "Công nghệ"));
	        danhSachDeTai.add(new Topic("T003", "An ninh mạng", "Chiến lược bảo mật mạng", "S003", "Bảo mật"));
	        danhSachDeTai.add(new Topic("T004", "Machine Learning", "Thuật toán & Ứng dụng ML", "S004", "AI"));
	        danhSachDeTai.add(new Topic("T005", "Khoa học dữ liệu", "Phân tích dữ liệu lớn", "S005", "Phân tích"));
	    }
	    
	    @GetMapping("/topic/all")
	    public String danhSachDeTai(Model model) {
	        model.addAttribute("topics", danhSachDeTai);
	        return "dsTopic";
	    }
	    
	    @GetMapping("/topic/new")
	    public String formAddNew(Model m) {
	        Topic tp = new Topic();                     
	        m.addAttribute("addTopic", tp);            
	        return "formTopic";                          
	    }


		@PostMapping("/topic/new")
		public String submitForm(@ModelAttribute("addTopic") Topic tp) {
			danhSachDeTai.add(tp);
		    return "redirect:/topic/all"; 
		}
}
