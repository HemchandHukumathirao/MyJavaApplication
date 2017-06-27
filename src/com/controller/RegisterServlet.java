package com.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dao.DataAccessService;
import com.dao.DataAccessServiceImple;
import com.entity.User;

public class RegisterServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User u = new User();
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setUsername(username);
		u.setPassword(password);
		
		DataAccessService service = new DataAccessServiceImple();
		service.saveUser(u);
		
		rd = req.getRequestDispatcher("login.html");
		rd.forward(req, res);

	}

}
