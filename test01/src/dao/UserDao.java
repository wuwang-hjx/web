package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.google.gson.JsonObject;

import tools.jdbcUtil;
import vo.User;

public class UserDao {
	
	public String userauth(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException{
		String result= "";
		HttpSession sec = request.getSession();
		String user = request.getParameter("name");
		String pass = request.getParameter("pass");
		String auth = request.getParameter("auth");
		//System.out.println(user+"<-->"+pass+"<-->"+auth);//测试前端提交数据
		String yzm = (String)sec.getAttribute("reg01");
		User uvo = new User();
		if((yzm.toLowerCase()).equals(auth.toLowerCase())) {
			jdbcUtil jutl = new jdbcUtil();
			int us = jutl.seluser(user, pass);
			if(us==1) {
				//用户名密码验证成功，查询对应角色
				String name = jutl.selname(user,pass);
				//System.out.println(name);
				sec.setAttribute("loginuser", name);
				result = uvo.usersuce();
			}else if(us == 0){
				//密码验证失败
				result = uvo.userpasserror();
			}else {
				//用户不存在
				result = uvo.userdis();
			}
			
		}else {
			//System.out.println("图片验证失败");
			result = uvo.imgautherror();
		}
		return result;
	}
	
	public String getname(HttpServletRequest request, HttpServletResponse response) {
		String result = "";
		HttpSession sec = request.getSession();
		String name = (String)sec.getAttribute("loginuser");
		if(name.equals("null")) {
			result = "0";
		}else {
			result = name;
		}
		
		return result;
	}
	
	public void userexit(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sec = request.getSession();
		sec.setAttribute("loginuser", "null");
	}
}
