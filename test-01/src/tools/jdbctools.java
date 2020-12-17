package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.catalina.Manager;
import org.apache.catalina.startup.Tomcat.ExistingStandardWrapper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class jdbctools {
	private String url="jdbc:mysql://127.0.0.1/list";
	private String dbuser = "root";
	private String dbpassword = "123456";
	
	public String getlist() throws ClassNotFoundException, SQLException {
		String result = null;
		Statement statement;
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url,dbuser,dbpassword);
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from ztree;");
		JsonArray ja = new JsonArray();
		while(true) {
			if(rs.next()) {
				JsonObject js = new JsonObject();
				js.addProperty("id", rs.getString(1));
				js.addProperty("pId", rs.getString(2));
				js.addProperty("name", rs.getString(3));
				if(("0".equals(rs.getString(1))) && ("0".equals(rs.getString(2)))) {
					js.addProperty("open", true);
				}else {
					js.addProperty("open", false);
				}
				ja.add(js);
			}else {
				break;
			}
			result = ja.toString();
		}
		
		connection.close();
		statement.close();
		
		return result;
		
	}
	
	public int updata(int id,String name) throws ClassNotFoundException, SQLException{
		int sw = 0;
		Statement statement;
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url,dbuser,dbpassword);
		statement = connection.createStatement();
		int rs = statement.executeUpdate(" update ztree set name=\""+name+"\" where id="+id+";");
		sw = rs;
		
		connection.close();
		statement.close();
		return sw;
		
	}
	public int delinfo(int id) throws ClassNotFoundException, SQLException{
		int sw = 0;
		Statement statement;
		Connection connection;
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url,dbuser,dbpassword);
		statement = connection.createStatement();
		int rs = statement.executeUpdate("delete from ztree where id="+id+";");
		sw = rs;
		connection.close();
		statement.close();
		return sw;
	}

}
