package RFID_Proj.RFID_Proj;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@EnableAutoConfiguration
@Configuration
@ComponentScan()
public class BedDao {

	boolean status = false;

	public boolean addBed() {

		try {
			String textUri = "mongodb://raina:raina@ds053370.mongolab.com:53370/socialservicedb";
			MongoClientURI uri = new MongoClientURI(textUri);
			MongoClient m = new MongoClient(uri);
			DB db = m.getDB("socialservicedb");
			DBCollection table = db.getCollection("beds");
			BasicDBObject document = new BasicDBObject();
			// get all bed Ids and then insert
			document.put("status", "available");

			table.insert(document);
			status = true;
		} catch (Exception e) {

			status = false;
		}

		return false;
	}

}
