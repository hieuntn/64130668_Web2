package thiGK.ntu64130668.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllers {
	@GetMapping("/")
	public String homePage() {
		return "home";
	}
}
