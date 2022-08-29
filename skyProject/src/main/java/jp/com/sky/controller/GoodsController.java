package jp.com.sky.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.com.sky.dao.GoodsDao;
import jp.com.sky.service.GoodsService;
import jp.com.sky.shopdto.GoodsDto;

@Controller
public class GoodsController {

	@Autowired
	private GoodsDao goodDao;
	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/dispGoods", method = { RequestMethod.GET, RequestMethod.POST }) // men画面から送った
	public String outer(Model model, HttpServletRequest httpServletRequest, @RequestParam String goodsItem, String btn,
			String search)// @RequestParamで送った値受け取る
			throws Exception {
		String headerName = null;
		List<GoodsDto> goods = new ArrayList<GoodsDto>();

		headerName = goodsService.getHeaderName(goodsItem);
		goods = goodDao.getGoodsList(goodsItem);

		model.addAttribute("goodsList", goods);
		model.addAttribute("headerName", headerName);
		model.addAttribute("goodsKind", goods.get(0).getGoodsKinds());

		return "goodsDetail";
	}

	@RequestMapping(value = "/goodsInfor", method = { RequestMethod.GET, RequestMethod.POST })
	public String infor(Model model, HttpServletRequest httpServletRequest, @RequestParam String itemsDetail, @RequestParam String goodsName)
			throws Exception {

		List<GoodsDto> goodsInfor = new ArrayList<GoodsDto>();

		goodsInfor = goodDao.getGoodsInforList(itemsDetail);

		model.addAttribute("goodsInfor", goodsInfor);
		model.addAttribute("goodsName", goodsInfor.get(0).getGoodsName());

		return "goodsInfor";
	}

	@RequestMapping(value = "/goodsSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public String search(Model model, @RequestParam String search) throws Exception {

		List<GoodsDto> goodsSearch = new ArrayList<GoodsDto>();
//		GoodsDto serachName = null;
//		List<GoodsDto> goods = new ArrayList<GoodsDto>();

		goodsSearch = goodDao.getGoodsLineup(search, search);
//		serachName = goodDao.getSearchName(searchName);
//		goods = goodDao.getGoodsList(goodsItem);

//		model.addAttribute("goodsKind", goods.get(0).getGoodsKinds());
		model.addAttribute("goodSearch", goodsSearch);

		return "goodsSearch";
	}

	@ResponseBody
	@RequestMapping(value = "/itemOderby", method = { RequestMethod.GET, RequestMethod.POST })
	public String itemOderby(Model model, @RequestParam String oderByVal, @RequestParam String goodsKind)
			throws Exception {

		List<GoodsDto> goodsSearch = new ArrayList<GoodsDto>();

		goodsSearch = goodDao.getGoodsOrderBy(oderByVal, goodsKind);

		return GoodsDto.toJsonArray(goodsSearch);
	}
}