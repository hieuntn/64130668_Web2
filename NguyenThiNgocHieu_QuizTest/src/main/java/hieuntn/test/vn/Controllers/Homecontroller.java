package hieuntn.test.vn.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Homecontroller {
	@GetMapping("/home")
	public String homePage() {
		return "homePage";
	}
	
		
	

}
