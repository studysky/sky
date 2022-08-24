package jp.com.sky.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.com.sky.dao.UserDao;
import jp.com.sky.shopdto.UserDto;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserDao userDao; /*
								 * @Service를 등록한 class는 Daoimo인데 @Autowired를 userDao에 붙여준 이유는 DaoImo은 Dao라는
								 * 인터페이스의 구현체이기때문에 스프링은 @Autowired를 Dao라는 인터페이스를 상ㅎ속한 class를 자동으로 등록시켜준다
								 */

//	private UserService 
	@RequestMapping(value = "/signupOk", method = { RequestMethod.GET, RequestMethod.POST }) // 会員登録画面
	public String signup(Locale locale, Model model, UserDto userDto, HttpSession session) throws Exception {

		session.setAttribute("userId", userDto.getUserId());
		if (userDao.isUserId(userDto.getUserId())) { // 重複処理
			model.addAttribute("errorMessage", "既に登録されているIDです。！");
			return "signup";
		}

		userDao.userInsert(userDto.getUserName(), userDto.getUserId(), userDto.getUserPw(), userDto.getEmail(),
				userDto.getManagerid(), userDto.getUserNum());

//		if(userDao.userInsert(userDto.getUserName(), userDto.getUserId(), userDto.getUserPw(), userDto.getEmail(),
//				userDto.getManagerid(), userDto.getUserNum()));
//		model.addAttribute("successMessage", userDto.getUserId() + "会員登録ありがとう！");
//		session.setAttribute("userId", userDto.getUserId());

		return "clear";
	}

	@RequestMapping(value = "/doLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Locale locale, Model model, UserDto userDto, HttpSession session) throws Exception {

		if (userDao.loginUserId(userDto.getUserId(), userDto.getUserPw())) {
			session.setAttribute("userId", userDto.getUserId());
			return "top_ok";
		} else {
			model.addAttribute("loginError", "IDかパスワードに誤りがあります。");

			return "login";
		}

	}

	@RequestMapping(value = "/doLogout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpServletRequest request) throws Exception {

		logger.info("");

		HttpSession session = request.getSession();

		session.invalidate();

		return "top";

	}

//	@RequestMapping(value = "/doManagerLogin", method = { RequestMethod.GET, RequestMethod.POST })
//	public String managerLogin(Locale locale, Model model, UserDto userDto, HttpSession session) throws Exception {
//
//		if (userDao.isManager(userDto.getUserId())) {
//			session.setAttribute("userId", userDto.getUserId());
//			return "cart";
//		} else {
//
//			return "login";
//		}
//
//	}
}
