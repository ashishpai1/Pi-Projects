package RFID_Proj.RFID_Proj;

import java.io.Serializable;
import java.util.List;


public class UserResp implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5669410667132310412L;
	//private String startString;
	private List<UserInfo> items;
	private int totalPages;
	private int currPage;

	
	public UserResp(){
		
		
	}
	
	

	public List<UserInfo> getItems() {
		return items;
	}
	public void setItems(List<UserInfo> userInfo) {
		this.items = userInfo;
	}



	public int getTotalPages() {
		return totalPages;
	}



	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}



	public int getCurrPage() {
		return currPage;
	}



	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	
	
	
	
}
