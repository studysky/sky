package jp.com.sky.shopdto;

public class CartDto {

	private String userId;
	private int cartNum;
	private String goodsName;
	private String goodPhoto;
	private int goodsPrice;
	private int cartCount;
	

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCartNum() {
		return cartNum;
	}

	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
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

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

}
