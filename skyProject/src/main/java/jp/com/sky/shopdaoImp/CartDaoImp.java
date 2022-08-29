package jp.com.sky.shopdaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.com.sky.dao.CartDao;
import jp.com.sky.shopdto.CartDto;
import jp.com.sky.utils.DbUtil;

@Service
public class CartDaoImp implements CartDao {

	@Override
	public void cartInsert(String userId, String goodsName, String cartCount) throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;

		StringBuffer sb = new StringBuffer();
		sb.append(" MERGE INTO CART CT ");
		sb.append(" USING ( ");
		sb.append(" SELECT ");
		sb.append(" TO_NUMBER(?) AS CART_COUNT, ");
		sb.append(" ? AS USERID, ");
		sb.append(" ? AS GOODSNAME ");
		sb.append(" FROM ");
		sb.append(" DUAL ");
		sb.append(" ) ");
		sb.append(" DPC ON ( DPC.USERID = CT.USERID ");
		sb.append(" AND DPC.GOODSNAME = CT.GOODSNAME ) ");
		sb.append(" WHEN MATCHED THEN UPDATE ");
		sb.append(" SET CT.CART_COUNT = CT.CART_COUNT + DPC.CART_COUNT ");
		sb.append(" WHEN NOT MATCHED THEN ");
		sb.append(" INSERT ");
		sb.append(" VALUES ");
		sb.append(" ( DPC.USERID, ");
		sb.append(" CART_SEQ.NEXTVAL, ");
		sb.append(" DPC.GOODSNAME, ");
		sb.append(" DPC.CART_COUNT ) ");

// final String SQL = "INSERT INTO CART (USERID, CARTNUM, GOODSNAME) VALUES(?,CART_SEQ.NEXTVAL, ?)";

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, cartCount);
			ps.setString(2, userId);
			ps.setString(3, goodsName);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				conn.close();
			if (ps != null)
				ps.close();
		}
	}

	@Override
	public List<CartDto> getCartList(String userId) throws Exception {

		List<CartDto> cart = new ArrayList<CartDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		StringBuffer sb = new StringBuffer();

		sb.append("	SELECT	");
		sb.append("	    CR.CARTNUM,	");
		sb.append("	    GD.PHOTO,	");
		sb.append("	    GD.GOODSNAME,	");
		sb.append("	    GD.GOODSPRICE * CR.CART_COUNT AS GOODSPRICE,	");
		sb.append("	    CR.CART_COUNT	");
		sb.append("	FROM	");
		sb.append("	    CART    CR	");
		sb.append("	    INNER JOIN GOODS   GD ON GD.GOODSNAME = CR.GOODSNAME	");
		sb.append("	WHERE	");
		sb.append("	    CR.USERID = ?	");

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, userId);
			rs = ps.executeQuery();

			while (rs.next()) {

				CartDto cartDto = new CartDto();
				cartDto.setCartNum(rs.getInt("CARTNUM"));
				cartDto.setGoodsName(rs.getString("GOODSNAME"));
				cartDto.setGoodPhoto(rs.getString("PHOTO")); // dto 에 없던 걸 추가했음
				cartDto.setGoodsPrice(rs.getInt("GOODSPRICE"));
				cartDto.setCartCount(rs.getInt("CART_COUNT"));
				cart.add(cartDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
			ps.close();
			rs.close();
		}

		return cart;

	}

	@Override
	public void cartDel(String del) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String SQL = "DELETE FROM CART WHERE CARTNUM = ?";

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, del);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				conn.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();

		}
	}
// @Override
// public void deleteCart(String cartNum) throws Exception {
// Connection conn = null;
// PreparedStatement ps = null;
// StringBuffer sb = new StringBuffer();
// sb.append("DELETE FROM CART_LIST WHERE CART_NUMBER = ?");
//
// try {
// conn = DbUtil.DbConnection();
// ps = conn.prepareStatement(sb.toString());
// ps.setString(1, cartNum);
// ps.executeUpdate();
// } catch (SQLException e) {
// e.printStackTrace();
// } catch (Exception e) {
// e.printStackTrace();
// } finally {
// conn.close();
// ps.close();
// }
// }
}

//@Override
//public List<CartDto> cartList() throws Exception {
//List<CartDto> cart = new ArrayList<CartDto>();
//Connection conn = null;
//PreparedStatement ps = null;
//ResultSet rs = null;
//
//final String SQL = "INSERT INTO CART((USERID, CARTNUM, GOODSNAME)) VALUES (?, CART_SEQ.NEXTVAL, ?);"; // 시퀀스는??
//
//try {
//conn = DbUtil.DbConnection();
//ps = conn.prepareStatement(SQL);
//rs = ps.executeQuery();
//
//while (rs.next()) {
//CartDto cartDto = new CartDto();
//cartDto.setUserId(rs.getString("USERID"));
//cartDto.setCartNum(rs.getInt("CARTNUM"));
//cartDto.setGoodsName(rs.getString("GOODSNAME"));
//cart.add(cartDto);
//}
//
//} catch (SQLException e) {
//e.printStackTrace();
//} catch (Exception e) {
//e.printStackTrace();
//} finally {
//conn.close();
//ps.close();
//rs.close();
//}
//
//return cart;
//
//}
//}