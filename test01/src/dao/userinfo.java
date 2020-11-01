package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class userinfo {
	private String dburl = "jdbc:mysql://127.0.0.1:3306/excise";
	private String dbuser = "root";
	private String dbpass = "123456";
	
	public String getinfo() throws ClassNotFoundException, SQLException{
		String result = null;
		Connection con;
		Statement stm;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dburl,dbuser,dbpass);
		stm = con.createStatement();
		String sql = "select userName,charName,email,sf,cs from t_user;";
		ResultSet rs = stm.executeQuery(sql);
		JsonArray info = new JsonArray();
		if(rs.next() == false) {
			result = null;
		}else {
			while (true) {
				if(rs.next() != false) {
					JsonObject json = new JsonObject();
					json.addProperty("userName", rs.getString(1));
					json.addProperty("charName", rs.getString(2));
					json.addProperty("email", rs.getString(3));
					json.addProperty("sf", rs.getString(4));
					json.addProperty("cs", rs.getString(5));
					info.add(json);
				}else {
					break;
				}
			}
			result = info.toString();
		}
		
		return result;
	}
	public String adduser(String userName,String charName,String email,String sf,String cs) {
		String result=null;
		
		return result;
	}
	public String reuser(String userName,String charName,String email,String sf,String cs) {
		String result=null;
		
		return result;
	}
	public String deluser(String userName) {
		String result=null;
		
		return result;
	}
}
