package wdson.me.board.controller;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String login(@RequestParam String u_id, @RequestParam String u_pw, Model model, HttpServletRequest request)
			throws Exception {
		
		String pw = service.getPw(u_id);

		if (pw != null && pw.equals(u_pw)) {
			model.addAttribute("loginStatus", true);
			model.addAttribute("loginId", u_id);

			return "loginSuccess";
		}

		model.addAttribute("msg", "아이디 혹은 비밀번호가 틀렸습니다.");
		model.addAttribute("url", request.getContextPath());

		return "alert";
	}

	@RequestMapping(value = "/goSignUp", method = RequestMethod.GET)
	public String signUp() {

		return "signUp";
	}

	@RequestMapping(value = "/doSignUp", method = RequestMethod.POST)
	public String doSignUp(@RequestParam HashMap<String, String> paramMap) {
		int result = 0;
		// 비밀번호 틀린 경우 처리

		// 회원가입 처리
		try {
			result = service.insertUser(new UserVO(paramMap.get("u_id"), paramMap.get("u_pw"), paramMap.get("u_name"),
					paramMap.get("u_email")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result != 0) {
			return "success";
		} else {
			return "failed";
		}
	}

	@RequestMapping(value = "/loginGuest", method = RequestMethod.GET)
	public String loginGuest(Model model) {
		model.addAttribute("loginStatus", true);
		model.addAttribute("loginId", "guest");

		return "loginSuccess";
	}
}
