package jp.com.sky.dao;

import java.util.List;

import jp.com.sky.shopdto.GoodsDto;

public interface GoodsDao {

	public void newGoods(int goodsNum, String goodsName, String goodsCount, int goodsStock, int goodsPrice,
			String goodsKinds, String photo) throws Exception;

//	public List<GoodsDto> getGoodsList() throws Exception;

	public List<GoodsDto> getGoodsList(String kinds) throws Exception;

	public List<GoodsDto> getGoodsInforList(String goods) throws Exception;

	public List<GoodsDto> getGoodsLineup(String btn, String search) throws Exception;

	public List<GoodsDto> getGoodsOrderBy(String orderbyFlg, String goodsKinds) throws Exception;

	public GoodsDto getSearchName(String searchName) throws Exception;

}
