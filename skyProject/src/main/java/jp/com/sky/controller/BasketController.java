package jp.com.sky.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.com.sky.shopdto.BasketDto;
import jp.com.sky.shopdto.UserDto;

@Controller
public class BasketController {

	@RequestMapping(value = "/basket", method = { RequestMethod.GET, RequestMethod.POST })
	public String basket(Locale locale, Model model, HttpSession session, UserDto userDto,
			HttpServletRequest httpServletRequest) throws Exception {

		// カート情報値取得のため
		List<BasketDto> basketList = new ArrayList<BasketDto>();

		// ユーザー区分のため
		String userId = null;

		userId = (String) session.getAttribute("userId");

		if (userId == null) { // 重複処理
			model.addAttribute("errorMessage", "Loginしてください。");
			return "goodsInfor";
		} else {

			return "basket";
		}
	}
}