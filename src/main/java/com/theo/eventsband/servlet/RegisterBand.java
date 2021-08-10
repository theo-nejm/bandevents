package com.theo.eventsband.servlet;

import java.io.IOException;

import com.theo.eventsband.dao.BandDao;
import com.theo.eventsband.model.Band;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerBand")
public class RegisterBand extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	public void destroy() {
		super.destroy();
	}
	
	protected void service (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
	      
		BandDao dao = new BandDao();
		Band band = new Band();
		
		String newBandName = request.getParameter("bandName");
		band.setName(newBandName);
		dao.register(band);
		
		RequestDispatcher rd = request
			     .getRequestDispatcher("/show-bands.jsp");
		rd.forward(request,response);
	}
}
