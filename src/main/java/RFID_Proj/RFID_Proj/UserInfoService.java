package RFID_Proj.RFID_Proj;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan()
public class UserInfoService {

	@Autowired
	UserInfo userInfo;

	@Autowired
	UserDao userDao;

	boolean status = false;
	List<UserInfo> userInfoList = new ArrayList<UserInfo>();

	public List<UserInfo> getUserDetails(String fname, String lname)
			throws Exception {

		userInfoList = userDao.getUserDetails(fname, lname);

		return userInfoList;
	}

	public boolean insertUserInfo(UserInfo user) throws Exception {

		status = userDao.insertUSerInfo(user);
		return status;
	}

	public boolean loginUser(UserInfo loginInfo) {

		status = userDao.loginUser(loginInfo);
		return status;
	}

	public List<UserInfo> viewAllUsers() throws Exception {

		userInfoList = userDao.viewAllUsers();
		return userInfoList;
	}

	public boolean deleteUser(UserInfo userInfo2) throws UnknownHostException {
		status = userDao.deleteUser(userInfo2);
		return status;
	}

	public boolean updateUser(UserInfo userInfo2) throws UnknownHostException {
		
		status = userDao.updateUser(userInfo2);
		return status;
	}

}
