package jp.com.sky.dao;

import java.util.List;

import jp.com.sky.shopdto.CartDto;

public interface CartDao {

	public void cartInsert(String userId, String goodsName, String cartCount) throws Exception;

	public void cartDel(String del) throws Exception;

	public List<CartDto> getCartList(String userId) throws Exception;

}