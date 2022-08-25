package jp.com.sky.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.com.sky.dao.CartDao;
import jp.com.sky.shopdto.CartDto;

@Controller
public class CartController {
	@Autowired
	private CartDao cartDao;

	@RequestMapping(value = "/goodscart", method = { RequestMethod.GET, RequestMethod.POST })
//	public String cart(Locale locale, Model model, HttpSession session, CartDto cartDto,
//			@RequestParam String itemsDetail) throws Exception {
	public String cart(Locale locale, Model model, HttpSession session, @RequestParam String goodsName,
			@RequestParam String cartCount, HttpServletRequest httpServletRequest) throws Exception {

		String userId = null;
		List<CartDto> cartList = new ArrayList<CartDto>();
//		List<GoodsDto> goods = new ArrayList<GoodsDto>();

		userId = (String) session.getAttribute("userId");
//		List<CartDto> cartItem = new ArrayList<CartDto>();

		// String zero = httpServletRequest.getParameter("カートには何も入ってないです。");
		cartDao.cartInsert(userId, goodsName, cartCount);
		// userId 값을 가져온다

//		goods = goodDao.getGoodsList(goodsName);
		cartList = cartDao.getCartList(userId);

//		model.addAttribute("goodsList", goods);
		model.addAttribute("cartList", cartList);

		return "cart";// cartDao.cartInsert(cartDto.getUserId(), cartDto.getCartNum(),
						// cartDto.getGoodsName());
//		goods = goodDao.getGoodsList();
//		model.addAttribute("",cartDao); 見せない
	}

	@RequestMapping(value = "/cartDel", method = { RequestMethod.GET, RequestMethod.POST })
	public String reji(Locale locale, Model model, HttpSession session, @RequestParam String cartNum,
			HttpServletRequest httpServletRequest) throws Exception {
		String userId = null;
		userId = (String) session.getAttribute("userId");
		List<CartDto> cartList = new ArrayList<CartDto>();
		cartDao.cartDel(cartNum);
		cartList = cartDao.getCartList(userId);
		model.addAttribute("cartList", cartList);
		return "cart";
	}
}
