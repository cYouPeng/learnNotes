package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/manager")
public class SelectAllController {

	@RequestMapping("/all.do")
	public String selectAll(Model model) throws Exception {
		model.addAttribute("all", "alllllllllllllll");
        return "all";
	}
}
