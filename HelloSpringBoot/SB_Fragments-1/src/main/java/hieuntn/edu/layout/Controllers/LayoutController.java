package hieuntn.edu.layout.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LayoutController {
	@GetMapping("/")
	public String homePage() {
		return "home";
	}
}
