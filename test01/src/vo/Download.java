package vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Download {
	
	public String error() {
		JsonObject info = new JsonObject();
		JsonObject json = new JsonObject();
		json.addProperty("status", "0");
		json.addProperty("path", "login.jsp");
		info.add("info", json);
		return info.toString();
	}
}
