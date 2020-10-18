package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tools.jdbcUtil;
import vo.Download;

public class DownloadDao {
	public String fileinfo(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		String result="";
		
		HttpSession sec = request.getSession();
		String user = (String)sec.getAttribute("loginuser");
		if(user.equals("null")) {
			Download dl = new Download();	
			result = dl.error();
		}else {
			jdbcUtil jdcl = new jdbcUtil();
			//ResultSet data = jdcl.getfile();
			result=jdcl.getfile();
			//result = dl.vfo(data);
			//System.out.println(result);
			
		}
		
		return result;
	}
}
