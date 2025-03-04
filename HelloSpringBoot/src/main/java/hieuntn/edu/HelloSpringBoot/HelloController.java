package hieuntn.edu.HelloSpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller// đây là controller 
public class HelloController {
	// action method
	// Url gọi action này??
	@GetMapping("/hello")// request tới địa chỉ 
	public String Hello(/*Các tham số đầu vào, đầu ra */) {
		return "helloView";// trả về file index.html
	}

}
