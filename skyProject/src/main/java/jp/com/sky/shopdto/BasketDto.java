package jp.com.sky.shopdto;

public class BasketDto {

	private String userId;
	private String basketName;
	private int basketPrice;
	private String basketPhoto;
	private int basketCouunt;
	private int basketNum;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBasketName() {
		return basketName;
	}

	public void setBasketName(String basketName) {
		this.basketName = basketName;
	}

	public int getBasketPrice() {
		return basketPrice;
	}

	public void setBasketPrice(int basketPrice) {
		this.basketPrice = basketPrice;
	}

	public String getBasketPhoto() {
		return basketPhoto;
	}

	public void setBasketPhoto(String basketPhoto) {
		this.basketPhoto = basketPhoto;
	}

	public int getBasketCouunt() {
		return basketCouunt;
	}

	public void setBasketCouunt(int basketCouunt) {
		this.basketCouunt = basketCouunt;
	}

	public int getBasketNum() {
		return basketNum;
	}

	public void setBasketNum(int basketNum) {
		this.basketNum = basketNum;
	}

}
