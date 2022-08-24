package jp.com.sky.shopdaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.com.sky.dao.GoodsDao;
import jp.com.sky.shopdto.GoodsDto;
import jp.com.sky.utils.DbUtil;

@Service
public class GoodsDaoImp implements GoodsDao {

	@Override
	public void newGoods(int goodsNum, String goodsName, String goodsContent, int goodsStock, int goodsPrice,
			String goodsKinds, String photo) throws Exception {

		Connection conn = null;
		PreparedStatement ps = null; // sql??��?��??��?�� ??��?��?��?��?��?��?��?��?��??��?�� ??��?��??��?��??��?��
		// ??��?��?�� ??��?��?��

		final String SQL = "INSERT INTO GOODS (GOODSNUM,GOODSNAME,GOODSCONTENT,GOODSSTOCK,GOODSPRICE,GOODSKINDS,PHOTO) VALUES(?,?,?,?,?,?,?)";

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, goodsNum);
			ps.setString(2, goodsName);
			ps.setString(3, goodsContent);
			ps.setInt(4, goodsStock);
			ps.setInt(5, goodsPrice);
			ps.setString(6, goodsKinds);
			ps.setString(7, photo);
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
	public List<GoodsDto> getGoodsList(String goodDiv) throws Exception {
		List<GoodsDto> goods = new ArrayList<GoodsDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String SQL = "SELECT GOODSNUM,GOODSNAME,GOODSCONTENT,GOODSSTOCK,GOODSPRICE,GOODSKINDS,PHOTO FROM GOODS WHERE GOODSKINDS = ?";

		try {
			conn = DbUtil.DbConnection();
			// ps = conn.prepareStatement(SQL);
			// ps.setString(1, );
			// rs = ps.executeQuery();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, goodDiv);
			rs = ps.executeQuery();

			while (rs.next()) {
				GoodsDto goodsDto = new GoodsDto();
				goodsDto.setGoodsNum(rs.getInt("GOODSNUM")); // SQLのコードと合わせる
				goodsDto.setGoodsName(rs.getString("GOODSNAME"));
				goodsDto.setGoodsContent(rs.getString("GOODSCONTENT"));
				goodsDto.setGoodsStock(rs.getInt("GOODSSTOCK"));
				goodsDto.setGoodsPrice(rs.getInt("GOODSPRICE"));
				goodsDto.setGoodsKinds(rs.getString("GOODSKINDS"));
				goodsDto.setPhoto(rs.getString("PHOTO"));
				goods.add(goodsDto);

				// String goodsName = rs.getString("goodsName");
				// String goodsContent = rs.getString("goodsContent");
				// int goodsStock = rs.getInt("goodsStock");
				// int goodsPrice = rs.getInt("goodsPrice");
				// String goodsKinds = rs.getString("goodsKinds");
				// String photo = rs.getString("photo");

				// ps.setString(1, goodDiv);
			}

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
		return goods;
	}

	@Override
	public List<GoodsDto> getGoodsInforList(String goods) throws Exception {
		List<GoodsDto> goodsInfor = new ArrayList<GoodsDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String SQL = "SELECT GOODSNUM,GOODSNAME,GOODSCONTENT,GOODSSTOCK,GOODSPRICE,GOODSKINDS,PHOTO FROM GOODS WHERE PHOTO = ?";

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, goods);
			rs = ps.executeQuery();

			while (rs.next()) {
				GoodsDto inforDto = new GoodsDto();
				inforDto.setGoodsNum(rs.getInt("GOODSNUM")); // SQLのコードと合わせる
				inforDto.setGoodsName(rs.getString("GOODSNAME"));
				inforDto.setGoodsContent(rs.getString("GOODSCONTENT"));
				inforDto.setGoodsStock(rs.getInt("GOODSSTOCK"));
				inforDto.setGoodsPrice(rs.getInt("GOODSPRICE"));
				inforDto.setGoodsKinds(rs.getString("GOODSKINDS"));
				inforDto.setPhoto(rs.getString("PHOTO"));
				goodsInfor.add(inforDto);
			}
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
		return goodsInfor;
	}

	@Override
	public List<GoodsDto> getGoodsLineup(String btn, String search) throws Exception {
		List<GoodsDto> goodsInfor = new ArrayList<GoodsDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String SQL = "SELECT GOODSNUM,GOODSNAME,GOODSCONTENT,GOODSSTOCK,GOODSPRICE,GOODSKINDS,PHOTO FROM GOODS WHERE GOODSNAME LIKE  ?";

		if ("asc".equals(btn)) {
			SQL = "SELECT GOODSNUM,GOODSNAME,GOODSCONTENT,GOODSSTOCK,GOODSPRICE,GOODSKINDS,PHOTO FROM GOODS ORDER BY GOODSPRICE";
		} else if ("DESC".equals(btn)) {
			SQL = "SELECT GOODSNUM,GOODSNAME,GOODSCONTENT,GOODSSTOCK,GOODSPRICE,GOODSKINDS,PHOTO FROM GOODS ORDER BY GOODSPRICE DESC";
		}

		if (null == (search)) {
			search = " ";
		}

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, ("%" + search + "%"));
			rs = ps.executeQuery();

			while (rs.next()) {
				GoodsDto inforDto = new GoodsDto();
				inforDto.setGoodsNum(rs.getInt("GOODSNUM")); // SQLのコードと合わせる
				inforDto.setGoodsName(rs.getString("GOODSNAME"));
				inforDto.setGoodsContent(rs.getString("GOODSCONTENT"));
				inforDto.setGoodsStock(rs.getInt("GOODSSTOCK"));
				inforDto.setGoodsPrice(rs.getInt("GOODSPRICE"));
				inforDto.setGoodsKinds(rs.getString("GOODSKINDS"));
				inforDto.setPhoto(rs.getString("PHOTO"));
				goodsInfor.add(inforDto);
			}
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

		return goodsInfor;
	}

	@Override
	public List<GoodsDto> getGoodsOrderBy(String orderbyFlg, String goodsKinds) throws Exception {
		List<GoodsDto> goods = new ArrayList<GoodsDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String orderByStr = null;

		if ("1".equals(orderbyFlg)) {
			orderByStr = "ASC";
		} else {
			orderByStr = "DESC";
		}

		String SQL = "SELECT GOODSNUM,GOODSNAME,GOODSCONTENT,GOODSSTOCK,GOODSPRICE,GOODSKINDS,PHOTO FROM GOODS WHERE GOODSKINDS = ? ORDER BY GOODSPRICE " + orderByStr;

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, goodsKinds);
			rs = ps.executeQuery();

			while (rs.next()) {
				GoodsDto goodsDto = new GoodsDto();
				goodsDto.setGoodsNum(rs.getInt("GOODSNUM")); // SQLのコードと合わせる
				goodsDto.setGoodsName(rs.getString("GOODSNAME"));
				goodsDto.setGoodsContent(rs.getString("GOODSCONTENT"));
				goodsDto.setGoodsStock(rs.getInt("GOODSSTOCK"));
				goodsDto.setGoodsPrice(rs.getInt("GOODSPRICE"));
				goodsDto.setGoodsKinds(rs.getString("GOODSKINDS"));
				goodsDto.setPhoto(rs.getString("PHOTO"));
				goods.add(goodsDto);
			}

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
		return goods;
	}

	@Override
	public GoodsDto getSearchName(String searchName) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		GoodsDto search = new GoodsDto();

		final String SQL = "SELECT GOODSNUM,GOODSNAME,GOODSCONTENT,GOODSSTOCK,GOODSPRICE,GOODSKINDS,PHOTO FROM GOODS WHERE GOODSNAME LIKE  ?";

		if (null == (searchName)) {
			searchName = " ";
		}

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, ("%" + searchName + "%"));
			rs = ps.executeQuery();

			while (rs.next()) {
				search.setSearchName(rs.getString("GOODSNAME"));
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

		return search;
	}
}