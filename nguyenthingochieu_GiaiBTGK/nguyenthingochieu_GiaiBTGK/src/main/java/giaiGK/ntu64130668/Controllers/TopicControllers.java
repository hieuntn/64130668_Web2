package giaiGK.ntu64130668.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import giaiGK.ntu64130668.Model.Topic;

@Controller
public class TopicControllers {
	 static List<Topic> dsTopic = new ArrayList<>();

	    static {
	        dsTopic.add(new Topic("T001", "Nghiên cứu AI", "Nghiên cứu về trí tuệ nhân tạo", "S001", "Nghiên cứu"));
	        dsTopic.add(new Topic("T002", "Blockchain", "Khám phá công nghệ Blockchain", "S002", "Công nghệ"));
	        dsTopic.add(new Topic("T003", "An ninh mạng", "Chiến lược bảo mật mạng", "S003", "Bảo mật"));
	        dsTopic.add(new Topic("T004", "Machine Learning", "Thuật toán & Ứng dụng ML", "S004", "AI"));
	        dsTopic.add(new Topic("T005", "Khoa học dữ liệu", "Phân tích dữ liệu lớn", "S005", "Phân tích"));
	    }
	    
	    @GetMapping("/topic/all")
	    public String danhSachDeTai(Model model) {
	        model.addAttribute("topics", dsTopic);
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
			dsTopic.add(tp);
		    return "redirect:/topic/all"; 
		}
//		xem chi tiết 1 topic 
		 @GetMapping("/topic/view/{id}")
		    public String viewTopic(@PathVariable String id, Model model) {
		        
		        Topic topic = dsTopic.stream()
		                .filter(t -> t.getId().equals(id))
		                .findFirst()
		                .orElse(null);
		        if (topic == null) {
		            return "redirect:/topic/all"; // Không tìm thấy -> quay lại danh sách
		        }
		        
		        // Truyền dữ liệu vào view
		        model.addAttribute("topic", topic);
		       
		        return "topic_detail"; 
		    }
		 // Sửa 1 topic 
		 //hiện thị form topic 
		 @GetMapping("/topic/edit/{id}")
		 public String EditForm(@PathVariable String id, Model model) {
			    Topic topic = dsTopic.stream()
			            .filter(t -> t.getId().equals(id))
			            .findFirst()
			            .orElse(null);

			    if (topic == null) {
			        return "redirect:/topic/all";
			    }

			    model.addAttribute("topic", topic);
			    return "topicEdit"; // trang form để chỉnh sửa
			}
		 //Xử lí edit Topic 
		 @PostMapping("/topic/edit/{id}")
		 public String editTopic(@PathVariable String id, @ModelAttribute("topic") Topic updatedTopic) {
		     
		     // Tìm topic cũ
		     for (int i = 0; i < dsTopic.size(); i++) {
		         if (dsTopic.get(i).getId().equals(id)) {
		             // Cập nhật thông tin
		             dsTopic.set(i, updatedTopic);
		             break;
		         }
		     }

		     return "redirect:/topic/view/" + id;
		 }
		 @GetMapping("/topic/delete/{id}")
		 public String deleteTopic(@PathVariable String id) {
		     dsTopic.removeIf(t -> t.getId().equals(id));
		     return "redirect:/topic/all";
		 }



		 
		 
		
}
