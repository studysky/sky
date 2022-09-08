package jp.com.sky.shopdaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import jp.com.sky.dao.BasketDao;
import jp.com.sky.utils.DbUtil;

@Service
public class BasketDaoImp implements BasketDao {

	@Override
	public void baskeInsert(String goodsName, String userId, int basketCount) throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String SQL = "INSERT INTO BASKET VALUES (BASKET_SEQ.NEXTVAL, ?, ?, ?);";

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, userId);
			ps.setString(2, goodsName);
			ps.setInt(3, basketCount);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
			ps.close();
			rs.close();
		}

	}
}