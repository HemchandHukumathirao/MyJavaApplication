package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.bean.LoginBean;
import com.dao.DataAccessService;
import com.dao.DataAccessServiceImple;

public class LoginServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		RequestDispatcher rd = null;
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		LoginBean lb = new LoginBean();
		lb.setUsername(username);
		lb.setPassword(password);

		DataAccessService service = new DataAccessServiceImple();
		boolean flag = service.Authenticate(lb);

		if (flag) {
			rd = req.getRequestDispatcher("home.html");
			rd.forward(req, res);
		} else {
			
			pw.println("please try again ");
				

		}

	}

}
