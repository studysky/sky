package jp.com.sky.shopdaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.com.sky.dao.ReviewDao;
import jp.com.sky.shopdto.ReviewDto;
import jp.com.sky.utils.DbUtil;

@Service
public class ReviewDaoImp implements ReviewDao {

	@Override
	public List<ReviewDto> reviewInsert(String userId, String review, String tittle, String goodsName)
			throws Exception {
		List<ReviewDto> reviewList = new ArrayList<ReviewDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String SQL = "INSERT INTO REVIEW (REVIEWNUM,USERID,REVIEW, TITTEL,GOODSNAME) VALUES (REVIEW_SEQ.NEXTVAL , ? , ? , ? , ?)";

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, userId);
			ps.setString(2, review);
			ps.setString(3, tittle);
			ps.setString(4, goodsName);
			rs = ps.executeQuery();

			while (rs.next()) {
				ReviewDto reviewDto = new ReviewDto();
				reviewDto.setReviewNum(rs.getInt("REVIEWNUM"));
				reviewDto.setUserId(rs.getString("USERID"));
				reviewDto.setReview(rs.getString("REVIEW"));
				reviewDto.setTittle(rs.getString("TITTEL"));
				reviewDto.setGoodsName(rs.getString("GOODSNAME"));
				reviewList.add(reviewDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				conn.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		}
		return reviewList;
	}

	@Override
	public List<ReviewDto> getReviewList(String goodsName) throws Exception {
//	public ReviewDto getReviewList(String riviewItem, String userId) throws Exception {
		List<ReviewDto> comment = new ArrayList<ReviewDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
//		ReviewDto reviewDto = new ReviewDto();
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT R.USERID, R.TITTEL, R.REVIEW,R.GOODSNAME, R.REVIEWNUM FROM REVIEW R  WHERE R.GOODSNAME = ?");
//		sb.append(" SELECT C.USERID,");
//		sb.append(" C.GOODSNAME,");
//		sb.append(" GD.PHOTO ");
//		sb.append(" FROM ");
//		sb.append(" CART C ");
//		sb.append(" INNER JOIN GOODS GD ON GD.GOODSNAME = C.GOODSNAME");
//		sb.append(" WHERE ");
//		sb.append(" C.GOODSNAME = ? ");

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, goodsName);
			rs = ps.executeQuery();

			while (rs.next()) {
				ReviewDto reviewDto = new ReviewDto();
				reviewDto.setUserId(rs.getString("USERID"));
				reviewDto.setTittle(rs.getString("TITTEL"));
				reviewDto.setReview(rs.getString("REVIEW"));
				reviewDto.setReviewNum(rs.getInt("REVIEWNUM"));
				reviewDto.setGoodsName(rs.getString("GOODSNAME"));
				comment.add(reviewDto);
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

		return comment;
	}

	@Override
	public ReviewDto getReviewItem(String riviewItem, String userId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReviewDto reviewDto = new ReviewDto();

		final String SQL = "SELECT ? AS USERID, GD.GOODSNAME,GD.PHOTO FROM GOODS GD WHERE GD.GOODSNAME = ?";

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, userId);
			ps.setString(2, riviewItem);
			rs = ps.executeQuery();

			while (rs.next()) {
				reviewDto.setGoodsName(rs.getString("GOODSNAME"));
				reviewDto.setUserId(rs.getString("USERID"));
				reviewDto.setPhoto(rs.getString("PHOTO"));
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

		return reviewDto;
	}

	@Override
	public void reviewDel(String del) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String SQL = "DELETE FROM REVIEW WHERE REVIEWNUM = ?";

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
}