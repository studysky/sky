package jp.com.sky.shopdto;

import java.util.Collection;

import flexjson.JSONSerializer;

public class GoodsDto {

	private int goodsNum;
	private String goodsName;
	private String goodsContent;
	private int goodsStock;
	private int goodsPrice;
	private String goodsKinds;
	private String photo;
	private String searchName;

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
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

	public String getGoodsContent() {
		return goodsContent;
	}

	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}

	public int getGoodsStock() {
		return goodsStock;
	}

	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsKinds() {
		return goodsKinds;
	}

	public void setGoodsKinds(String goodsKinds) {
		this.goodsKinds = goodsKinds;
	}

	@Override
	public String toString() {
		return "GoodsDto [goodsNum=" + goodsNum + ", goodsName=" + goodsName + ", goodsContent=" + goodsContent
				+ ", goodsStock=" + goodsStock + ", goodsPrice=" + goodsPrice + ", goodsKinds=" + goodsKinds
				+ ", photo=" + photo + "]";
	}

	public static String toJsonArray(Collection<GoodsDto> collection) {
		return new JSONSerializer().exclude("*.class").serialize(collection);
	}

}
