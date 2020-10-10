package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.Filter.Chain;

import vo.Download;

public class loginfilter implements Filter {

	private String notcheckpath;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession sec = ((HttpServletRequest) request).getSession();
		String path = ((HttpServletRequest)request).getServletPath();
		if(notcheckpath.indexOf(path) == -1) {
			if(sec.getAttribute("loginuser")== "null" ) {
				
				if(path.indexOf("GetDownloadListController") != -1) {
					Download dl = new Download();
					String data = dl.error();
					PrintWriter pw = response.getWriter();
					pw.append(data);
					pw.close();
					
				}
			}else {
				chain.doFilter(request, response);
			}
			
			
		}else {
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		notcheckpath = config.getInitParameter("notcheckpath");
	}

}
