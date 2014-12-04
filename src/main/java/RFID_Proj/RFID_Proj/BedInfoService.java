package RFID_Proj.RFID_Proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@EnableAutoConfiguration
@Configuration
@ComponentScan()
public class BedInfoService {

	@Autowired
	BedInfo bedInfo;
	
	@Autowired
	BedDao bedDao;
	
	boolean status = false;
	public boolean assignBed(UserInfo userInfo) {
		
		return false;
	}

	public boolean bedInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteBed(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addBed() {
	
		status = bedDao.addBed();
		return status;
	}

}
