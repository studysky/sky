package jp.com.sky.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String mainTop(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "top";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/top", method = { RequestMethod.GET, RequestMethod.POST })
	public String top(Locale locale, Model model, HttpServletRequest httpServletRequest) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "top";
	}

	String userId = null;

	@RequestMapping(value = "/baby", method = { RequestMethod.GET, RequestMethod.POST })
	public String baby(Locale locale, Model model, HttpSession session) {

		userId = (String) session.getAttribute("userId");
		return "baby";
	}

	@RequestMapping(value = "/clear", method = { RequestMethod.GET, RequestMethod.POST })
	public String clear(Locale locale, Model model, HttpSession session) {

		userId = (String) session.getAttribute("userId");
		return "clear";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Locale locale, Model model, HttpServletRequest httpServletRequest, HttpSession session) {

		userId = (String) session.getAttribute("userId");
		return "login";
	}

	@RequestMapping(value = "/men", method = { RequestMethod.GET, RequestMethod.POST })
	public String men(Locale locale, Model model, HttpSession session) {

		userId = (String) session.getAttribute("userId");
		return "men";
	}

	@RequestMapping(value = "/signup", method = { RequestMethod.GET, RequestMethod.POST })
	public String signup(Locale locale, Model model, HttpSession session) {
		String userId = null;

		userId = (String) session.getAttribute("userId");

		return "signup";
	}

	@RequestMapping(value = "/qna", method = { RequestMethod.GET, RequestMethod.POST })
	public String qna(Locale locale, Model model, HttpSession session) {

		userId = (String) session.getAttribute("userId");
		return "qna";
	}

	@RequestMapping(value = "/women", method = { RequestMethod.GET, RequestMethod.POST })
	public String women(Locale locale, Model model, HttpSession session) {

		userId = (String) session.getAttribute("userId");
		return "women";
	}

	@RequestMapping(value = "/top_ok", method = { RequestMethod.GET, RequestMethod.POST })
	public String top_ok(Locale locale, Model model, HttpServletRequest httpServletRequest, HttpSession session) {

		userId = (String) session.getAttribute("userId");
		return "top_ok";
	}

//	@RequestMapping(value = "/cart", method = { RequestMethod.GET, RequestMethod.POST })
//	public String cart(Locale locale, Model model, HttpSession session) {
//
//		userId = (String) session.getAttribute("userId");
//		return "cart";
//	}

}
