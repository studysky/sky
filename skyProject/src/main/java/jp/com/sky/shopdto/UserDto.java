package jp.com.sky.shopdto;

public class UserDto { // ?��?����? ?�� ?��다 ??�성 ��? ??? ?��?��?�� ?��?�� ?��들?��?��?�� ���?��?��

	private String userName;
	private String userId;
	private String userPw;
	private String email;
	private String managerId;
	private int userNum;

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getManagerid() {
		return managerId;
	}

	public void setManagerid(String managerid) {
		this.managerId = managerid;
	}

	@Override
	public String toString() {
		return "UserDto [userName=" + userName + ", userId=" + userId + ", userPw=" + userPw + ", email=" + email
				+ ", managerId=" + managerId + ", userNum=" + userNum + "]";
	}

}
