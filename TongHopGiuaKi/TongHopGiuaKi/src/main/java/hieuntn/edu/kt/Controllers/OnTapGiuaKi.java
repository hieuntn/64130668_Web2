package hieuntn.edu.kt.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@ Controller
public class OnTapGiuaKi {
	@GetMapping("/")
	public String homePage() {
		return "home";
	}
}
