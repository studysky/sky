package jp.com.sky.dao;

import java.util.List;

import jp.com.sky.shopdto.CartDto;

public interface CartDao {

	public void cartInsert(String userId, String goodsName) throws Exception;
	
	public List<CartDto> cartItem(String del) throws Exception;

	public List<CartDto> getCartList(String userId) throws Exception;

}