package com.theo.eventsband.servlet;

import java.io.IOException;
import java.util.List;

import com.theo.eventsband.dao.BandDao;
import com.theo.eventsband.model.Band;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list-bands")
public class ListBands extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
	      
		BandDao dao = new BandDao();
		List<Band> bands = dao.getAll();
		
		request.setAttribute( "bands", bands );
		
		RequestDispatcher rd = request
			     .getRequestDispatcher("/show-bands.jsp");
		rd.forward(request,response);
	}
}
