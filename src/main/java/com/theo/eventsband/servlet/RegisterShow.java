package com.theo.eventsband.servlet;

import java.io.IOException;
import java.util.List;

import com.theo.eventsband.dao.BandDao;
import com.theo.eventsband.model.Band;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register-show")
public class RegisterShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	public void destroy() {
		super.destroy();
	}
	
	@Override
	protected void service (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
	      
		super.service(request, response);
	}
	
	@Override
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
			BandDao dao = new BandDao();
			List<Band> bands = dao.getAll();
			
			request.setAttribute( "bands", bands );
			
			RequestDispatcher rd = request
					.getRequestDispatcher("/register-show.jsp");
			rd.forward(request,response);
	}
	
	@Override
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("Chamou o método post.");
	}
}