package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class jdbcUtil {
	private String dburl = "jdbc:mysql://127.0.0.1:3306/excise";
	private String dbuser = "root";
	private String dbpass = "123456";

	
	public int seluser(String user,String pass) throws ClassNotFoundException, SQLException {
		int result;
		Connection con;
		Statement stm;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dburl,dbuser,dbpass);
		stm = con.createStatement();
		String sql = "select password from t_user where userName=\""+user+"\";";
		ResultSet rs = stm.executeQuery(sql);
		if(rs.next()) {
			if((rs.getString(1)).equals(pass)) {
				//用户名密码验证成功
				result = 1;
			}else {
				//密码错误
				result = 0;
			}
			
		}else {
			//用户不存在
			result = -1;
		}
		rs.close();
		con.close();
		stm.close();
		return result;
	}
	
	public String selname(String user,String pass) throws ClassNotFoundException, SQLException {
		String result;
		Connection con;
		Statement stm;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dburl,dbuser,dbpass);
		stm = con.createStatement();
		String sql = "select charName from t_user where userName=\""+user+"\" and password=\""+pass+"\";";
		ResultSet rs = stm.executeQuery(sql);
		if(rs.next()) {
			result = rs.getString(1);
		}else {
			result = "未设置";
		}
		
		rs.close();
		con.close();
		stm.close();
		return result;
		
	}
	
	public String getfile() throws SQLException, ClassNotFoundException {
//		ResultSet result;
		Connection con;
		Statement stm;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dburl,dbuser,dbpass);
		stm = con.createStatement();
		String sql = "select name,path,description,size,star,image from t_downloadlist;";
//		result = stm.executeQuery(sql);
		ResultSet rs = stm.executeQuery(sql);
		JsonArray info = new JsonArray();
		while (true){
			if(rs.next()) {
				JsonObject json = new JsonObject();
				json.addProperty("name", rs.getString(1));
				json.addProperty("path", rs.getString(2));
				json.addProperty("description", rs.getString(3));
				json.addProperty("size", rs.getString(4));
				json.addProperty("star", rs.getString(5));
				json.addProperty("image", rs.getString(6));
				info.add(json);
			}else {
				break;
			}
			
		}
		JsonObject input = new JsonObject();
		input.add("info",info);
		input.addProperty("status", "1");
		con.close();
		stm.close();
		return input.toString();
	}
	
}
