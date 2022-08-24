package jp.com.sky.shopdto;

public class ReviewDto {

	private int reviewNum;
	private String userId;
	private String goodsName;
	private String photo;
	private String review;
	private String tittle;

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodPhoto() {
		return goodPhoto;
	}

	public void setGoodPhoto(String goodPhoto) {
		this.goodPhoto = goodPhoto;
	}

	private String goodPhoto;

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
