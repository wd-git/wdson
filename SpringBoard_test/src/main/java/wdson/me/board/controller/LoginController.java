package wdson.me.board.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import wdson.me.board.domain.UserVO;
import wdson.me.board.service.UserService;

@Controller
public class LoginController {
	
	@Inject
	private UserService service;

	@RequestMapping(value="/goLogin", method=RequestMethod.POST)
	public String login(@RequestParam String u_id, @RequestParam String u_pw, Model model) throws Exception {
		boolean result = service.getPw(u_id).equals(u_pw);
		if(result) {
			model.addAttribute("loginStatus", true);
			model.addAttribute("loginId", u_id);
			
			return "loginSuccess";
		}else {
			model.addAttribute("msg", "아이디 혹은 비밀번호가 틀렸습니다."); 
			model.addAttribute("url", "./"); 
			
			return "alert";
		}
		
	}
	
}
