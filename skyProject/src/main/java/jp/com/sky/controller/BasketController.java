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

		// �J�[�g���l�擾�̂���
		List<BasketDto> basketList = new ArrayList<BasketDto>();

		// ���[�U�[�敪�̂���
		String userId = null;

		userId = (String) session.getAttribute("userId");

		if (userId == null) { // �d������
			model.addAttribute("errorMessage", "Login���Ă��������B");
			return "goodsInfor";
		} else {

			return "basket";
		}
	}
}