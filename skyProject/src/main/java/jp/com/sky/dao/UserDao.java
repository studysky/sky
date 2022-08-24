package jp.com.sky.dao;

import java.util.List;

import jp.com.sky.shopdto.UserDto;

public interface UserDao { // DB?�� ??�근���기 ?����? ?��체

	public List<UserDto> getUserList() throws Exception;

	public void userInsert(String userName, String userId, String userPw, String email, String managerId, int userNum)
			throws Exception;

	public boolean isUserId(String userId) throws Exception;

	public boolean loginUserId(String userId, String userPw) throws Exception;

//	public boolean isManager(String manager) throws Exception;

}



















//	public void add(UserDto userDto) throws ClassNotFoundException, SQLException {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection c = DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:orcl", "c##sky123", "1111");
//
//		PreparedStatement ps = c
//				.prepareStatement("insert into userdb(username, userid, userpw,e_mail,manager) values(?,?,?,?,?)");
//
//		ps.setString(1, userDto.getuserName());
//		ps.setString(2, userDto.getuserId());
//		ps.setString(3, userDto.getuserPw());
//		ps.setString(4, userDto.getemail());
//		ps.setString(5, userDto.getmanagerId());
//
//		ps.executeUpdate();
//
//		ps.close();
//		c.close();
//
//	}
//
//	public UserDto get(String id) throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection c = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/spring?autoReconnect=true&amp;useSSL=false\";", "root", "@min753951");
//
//		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
//		ps.setString(1, id);
//
//		ResultSet rs = ps.executeQuery();
//		rs.next();
//		UserDto userDto = new UserDto();
//		userDto.setUserId(rs.getString("id"));
//		userDto.setUserName(rs.getString("name"));
//		userDto.setUserPw(rs.getString("password"));
//
//		rs.close();
//		ps.close();
//		c.close();
//
//		return user;
//	}
//
//}