package jp.com.sky.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.com.sky.dao.ReviewDao;
import jp.com.sky.shopdto.ReviewDto;

@Controller
public class ReviewController {

	@Autowired
	private ReviewDao reviewDao;

	@RequestMapping(value = "/reviewItem", method = { RequestMethod.GET, RequestMethod.POST })
	public String reviewItem(Model model, HttpSession session, @RequestParam String riviewItem) throws Exception {

		String userId = null;

//		List<ReviewDto> reviewList = new ArrayList<ReviewDto>();
		ReviewDto reviewDto = new ReviewDto();

		userId = (String) session.getAttribute("userId");

		reviewDto = reviewDao.getReviewItem(riviewItem, userId);

//		if ((String) session.getAttribute("userId") == null) {
//			model.addAttribute("errorMessage", "ä˘Ç…ìoò^Ç≥ÇÍÇƒÇ¢ÇÈIDÇ≈Ç∑ÅBÅI");
//		}

		model.addAttribute("reviewDto", reviewDto);

		return "review";
	}

	/*
	 * @RequestMapping(value = "/review", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String review(Model model, HttpSession session)
	 * throws Exception { return "review";
	 * 
	 * }
	 */
	@RequestMapping(value = "/review", method = { RequestMethod.GET, RequestMethod.POST })
	public String review(Model model, HttpSession session, @RequestParam String tittle, @RequestParam String review)
			throws Exception {

		String goodsName = null;
		String userId = null;

		userId = (String) session.getAttribute("userId");

		List<ReviewDto> reviewList = new ArrayList<ReviewDto>();

		reviewDao.reviewInsert(userId, review, tittle, goodsName);

		reviewList = reviewDao.getReviewList(userId, tittle, review);

		model.addAttribute("reviewList", reviewList);

		return "review";
	}
}
