package com.theo.eventsband.servlet;

import java.io.IOException;

import com.theo.eventsband.dao.BandDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete-band")
public class DeleteBand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
	    
		BandDao dao = new BandDao();
		
		int bandId = Integer.parseInt(request.getParameter("bandId"));
		dao.remove(bandId);
		
		response.sendRedirect("list-bands");
	}
}

