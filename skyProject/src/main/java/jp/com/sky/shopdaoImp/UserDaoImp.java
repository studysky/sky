package jp.com.sky.shopdaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.com.sky.dao.UserDao;
import jp.com.sky.shopdto.UserDto;
import jp.com.sky.utils.DbUtil;

@Service
public class UserDaoImp implements UserDao {

	@Override
	public void userInsert(String userName, String userId, String userPw, String email, String managerId, int userNum)
			throws Exception {

		Connection conn = null;
		PreparedStatement ps = null; // sql??��?��??��?�� ??��?��?��?��?��?��?��?��?��??��?�� ??��?��??��?��??��?��
										// ??��?��?�� ??��?��?��

		final String SQL = "INSERT INTO USERDB (USERNAME,USERID, USERPW,EMAIL,MANAGERID,USERNUM) VALUES(?,?,?,?,?,1)";

		try {
			conn = DbUtil.DbConnection();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, userName);
			ps.setString(2, userId);
			ps.setString(3, userPw);
			ps.setString(4, email);
			ps.setString(5, managerId);

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
	public List<UserDto> getUserList() throws Exception {
		Connection conn = null; // DB??��?��??��?��??��?��?��?��?��???
		PreparedStatement ps = null; // SQL??��?��??��?�� ??��?��??��?��??��?��?��?��?��???
		ResultSet rs = null; // ??��?��?��?��?����???��?�� ResultSet??��?��??��? ??��?��?��???
					
		// ???��?��??��?�� ?????��?��?��?��? ??��?��??��?��?��??�����??��?��
								// ??��?��??��?��??��?��?��?��?��?��?��
		List<UserDto> UserList = new ArrayList<UserDto>();

		final String SQL = "SELECT USERNAME,USERID, USERPW,EMAIL,MANAGERID,USERNUM FROM USERDB";

		try {
			conn = DbUtil.DbConnection(); // DbUtil ?��?��?��??��?��??��?��??��?�� ??��?��??��?��
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserDto dto = new UserDto();
				dto.setUserName(rs.getString("USERNAME"));
				dto.setUserId(rs.getString("USERID"));
				dto.setUserPw(rs.getString("USERPw"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setManagerid(rs.getString("MANAGERID"));
				dto.setUserNum(rs.getInt("USERNUM"));
				UserList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ??��?��??��?��??��?�� ??��?��???��?��??��?�� ??��?��??��?��??��???��?��
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		}

		return UserList;
	}

	@Override
	public boolean isUserId(String userId) throws Exception { // 会員登録
		boolean checkFlg = false;
		int userCnt = 0;
		Connection conn = null; // DB??��?��??��?��??��?��?��?��?��???
		PreparedStatement ps = null; // SQL??��?��??��?�� ??��?��??��?��??��?��?��?��?��???
		ResultSet rs = null; // ??��?��?��?��?����???��?�� ResultSet??��?��??��? ??��?��?��???
								// ???��?��??��?�� ?????��?��?��?��? ??��?��??��?��?��??�����??��?��
								// ??��?��??��?��??��?��?��?��?��?��?��

		final String SQL = "SELECT COUNT(1) AS CNT FROM USERDB WHERE USERID = ?";
		try {
			conn = DbUtil.DbConnection(); // DbUtil ?��?��?��??��?��??��?��??��?�� ??��?��??��?��
			ps = conn.prepareStatement(SQL);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				userCnt = rs.getInt("CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ??��?��??��?��??��?�� ??��?��???��?��??��?�� ??��?��??��?��??��???��?��
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		}

		if (userCnt > 0) {
			checkFlg = true;
		} else {
			checkFlg = false;
		}

		return checkFlg;
	}

	@Override
	public boolean loginUserId(String userId, String userPw) throws Exception { // ログイン
		boolean checkLogin = true;
		int userCnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // ??��?��?��?��?����???��?�� ResultSet??��?��??��? ??��?��?��???
								// ???��?��??��?�� ?????��?��?��?��? ??��?��??��?��?��??�����??��?��
								// ??��?��??��?��??��?��?��?��?��?��?��

		final String SQL = "SELECT COUNT(1) AS CNT FROM USERDB WHERE USERID = ? AND USERPW = ?";
		try {
			conn = DbUtil.DbConnection(); // DbUtil ?��?��?��??��?��??��?��??��?�� ??��?��??��?��
			ps = conn.prepareStatement(SQL);
			ps.setString(1, userId);
			ps.setString(2, userPw);
			rs = ps.executeQuery();
			while (rs.next()) {
				userCnt = rs.getInt("CNT"); // COUNT(1) AS CNT の CNT
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		}

		if (userCnt != 1) {
			checkLogin = false;
		}

		return checkLogin;

	}

//	@Override
//	public boolean isManager(String manager) throws Exception { // 会員登録
//		boolean checkFlg = false;
//		int managerCnt = 0;
//		Connection conn = null; // DB??��?��??��?��??��?��?��?��?��???
//		PreparedStatement ps = null; // SQL??��?��??��?�� ??��?��??��?��??��?��?��?��?��???
//		ResultSet rs = null; // ??��?��?��?��?����???��?�� ResultSet??��?��??��? ??��?��?��???
//								// ???��?��??��?�� ?????��?��?��?��? ??��?��??��?��?��??�����??��?��
//								// ??��?��??��?��??��?��?��?��?��?��?��
//
//		final String SQL = "SELECT COUNT(1) AS CNT FROM USERDB WHERE USERNUM = ?";
//		try {
//			conn = DbUtil.DbConnection(); // DbUtil ?��?��?��??��?��??��?��??��?�� ??��?��??��?��
//			ps = conn.prepareStatement(SQL);
//			ps.setString(1, manager);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				managerCnt = rs.getInt("CNT");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// ??��?��??��?��??��?�� ??��?��???��?��??��?�� ??��?��??��?��??��???��?��
//			if (conn != null)
//				conn.close();
//			if (ps != null)
//				ps.close();
//			if (rs != null)
//				rs.close();
//		}
//
//		if (managerCnt > 1) {
//			checkFlg = true;
//		} else {
//			checkFlg = false;
//		}
//
//		return checkFlg;
//	}
	
	
}
