package dao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import tools.jdbcUtil;

public class adduser {
	public String adduser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		String result = "";
		jdbcUtil ju = new jdbcUtil();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int sf = Integer.parseInt(request.getParameter("sf"));
		int cs = Integer.parseInt(request.getParameter("cs"));
		HttpSession sec = request.getSession();
		int rs = ju.createuser(user, pass, name, email, sf, cs);
		if (rs == 0) {
			JsonObject json = new JsonObject();
			json.addProperty("code", 0);
			json.addProperty("tips", "用户创建成功");
			json.addProperty("path", "main.jsp");
			sec.setAttribute("loginuser", name);
			result = json.toString();
		}else if(rs == 1) {
			JsonObject json = new JsonObject();
			json.addProperty("code", 1);
			json.addProperty("tips", "用户已存在");
			result = json.toString();
		}else {
			JsonObject json = new JsonObject();
			json.addProperty("code", -1);
			json.addProperty("tips", "新用户创建失败");
			result = json.toString();
		}
		return result;
	}
}
