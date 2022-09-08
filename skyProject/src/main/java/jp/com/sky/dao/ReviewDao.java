package jp.com.sky.dao;

import java.util.List;

import jp.com.sky.shopdto.ReviewDto;

public interface ReviewDao {

	public List<ReviewDto> reviewInsert(String userId, String review, String tittle, String goodsName) throws Exception;

	public List<ReviewDto> getReviewList(String goodsName) throws Exception;

	public ReviewDto getReviewItem(String reviewItem, String userId) throws Exception;

	public void reviewDel(String del) throws Exception;

//	public ReviewDto getReviewList(String riviewItem, String userId) throws Exception;

}