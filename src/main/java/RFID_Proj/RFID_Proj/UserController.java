package RFID_Proj.RFID_Proj;


import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

	@Autowired
	UserInfo userInfo;

	@Autowired
	BedInfo bedInfo;

	@Autowired
	UserInfoService userService;

	@Autowired
	BedInfoService bedInfoService;

	List<UserInfo> userInfoList = new ArrayList<UserInfo>();

	// Login --> Get

//	@RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
//	public boolean loginUser(@PathVariable String username,
//			@PathVariable String password) {
//
//		boolean status = false;
//		status = userService.loginUser(userInfo);
//
//		return status;
//	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String loginUser() {

//		boolean status = false;
//		status = userService.loginUser(userInfo);

		return "index";
	}

	
	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public String searchUser() {

//		boolean status = false;
//		status = userService.loginUser(userInfo);

		return "searchUser";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {

//		boolean status = false;
//		status = userService.loginUser(userInfo);

		return "register";
	}
	
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser() {

//		boolean status = false;
//		status = userService.loginUser(userInfo);

		return "deleteUser";
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public String updateUser() {

//		boolean status = false;
//		status = userService.loginUser(userInfo);

		return "updateUser";
	}
	
	
	
	
	// search based on first name and last name
	@RequestMapping(value = "/userDetails/{fname}/{lname}", method = RequestMethod.GET)
	@ResponseBody
	public List<UserInfo> getUserDetails(@PathVariable String fname,
			@PathVariable String lname) throws Exception {

		userInfoList = userService.getUserDetails(fname, lname);

		return userInfoList;

	}

/*	// view all users
	@RequestMapping(value = "/viewAllUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<UserInfo> viewAllUsers() throws Exception {

		userInfoList = userService.viewAllUsers();

		return userInfoList;

	}*/
	
	
	// view all users
		@RequestMapping(value = "/viewAllUsers", method = RequestMethod.GET)
		@ResponseBody
		public UserResp viewAllUsers() throws Exception {
			userInfoList = userService.viewAllUsers();
			UserResp reponseStr = new UserResp();
		//	reponseStr.setStartString("{\"items\":");
			reponseStr.setItems(userInfoList);
		//	reponseStr.setEndOfString("}");
			reponseStr.setTotalPages(40);
			reponseStr.setCurrPage(4);
	     	//String userListStr = 	JSON.serialize(o, buf);(userInfoList);
			//System.out.println("The json String is " + userListStr );
			return reponseStr;

		}

	// sign In or Add user --> get
	@RequestMapping(value = "/register/{fname}/{lname}/{address}/{state}/{city}/{zipCode}/{phone}/{email}/{tagNo}/{bedId}", method = RequestMethod.GET)
	@ResponseBody
	public void registerUSer(@PathVariable String fname,
			@PathVariable String lname, @PathVariable String address,
			@PathVariable String state, @PathVariable String city,
			@PathVariable String zipCode, @PathVariable long phone,
			@PathVariable String email, @PathVariable int tagNo,
			@PathVariable int bedId) throws Exception {

		boolean status = false;
		userInfo.setFirstName(fname);
		userInfo.setLastName(lname);
		userInfo.setAddress(address);
		userInfo.setState(state);
		userInfo.setCity(city);
		userInfo.setZipCode(zipCode);
		userInfo.setPhoneNumber(phone);
		userInfo.setEmail(email);
		userInfo.setTagNo(tagNo);
		userInfo.setBedId(bedId);

		//status = 
				userService.insertUserInfo(userInfo);

		//return status;
	}

	// del user
	@RequestMapping(value = "/deleteUser/{fname}/{lname}/{id}", method = RequestMethod.GET)
	@ResponseBody
	public boolean deleteUser(@PathVariable String fname,
			@PathVariable String lname, @PathVariable int id) throws Exception {

		boolean status = false;
		userInfo.setFirstName(fname);
		userInfo.setLastName(lname);
		userInfo.set_id(id);
		status = userService.deleteUser(userInfo);

		return status;
	}

	// update User Info

	@RequestMapping(value = "/updateUserInfo/{id}/{fname}/{lname}/{address}/{state}/{city}/{zipCode}/{phone}/{email}/{bedId}", method = RequestMethod.GET)
	@ResponseBody
	public void updateUserInfo(@PathVariable int id,
			@PathVariable String fname, @PathVariable String lname,
			@PathVariable String address, @PathVariable String state,
			@PathVariable String city, @PathVariable String zipCode,
			@PathVariable Long phone, @PathVariable String email,
			@PathVariable int bedId) throws UnknownHostException {

		boolean status = false;
		userInfo.set_id(id);
		userInfo.setFirstName(fname);
		userInfo.setLastName(lname);
		userInfo.setAddress(address);
		userInfo.setState(state);
		userInfo.setCity(city);
		userInfo.setZipCode(zipCode);
		userInfo.setPhoneNumber(phone);
		userInfo.setEmail(email);
		userInfo.setBedId(bedId);

		status = userService.updateUser(userInfo);

	}

	// **********************************
	// Add a bed

	@RequestMapping(value = "/addBed", method = RequestMethod.POST)
	@ResponseBody
	public boolean addBed(@PathVariable int bedId,
			@PathVariable String bedStatus) {

		boolean status = false;
		status = bedInfoService.addBed();

		return status;
	}

	// del a bed

	@RequestMapping(value = "/deleteBed/{bedId}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteBed(@PathVariable int bedId,
			@PathVariable String bedStatus) {

		boolean status = false;
		status = bedInfoService.deleteBed(userInfo);

		return status;
	}

	// View all Beds
	@RequestMapping(value = "/viewAllBeds", method = RequestMethod.GET)
	@ResponseBody
	public boolean bedInfo() {

		boolean status = false;
		status = bedInfoService.bedInfo(userInfo);

		return status;
	}

	// Assign a bed

	@RequestMapping(value = "/assignBed/{userId}/{bedId}", method = RequestMethod.POST)
	@ResponseBody
	public boolean assignBed(@PathVariable int userId, @PathVariable int bedId) {

		boolean status = false;
		status = bedInfoService.assignBed(userInfo);

		return status;
	}

	
	//updateBedStatus
	
	
	
	
	
	// Contact us
	public boolean contactUs(@PathVariable int userId, @PathVariable int bedId) {

		boolean status = false;

		return status;
	}
	

}
