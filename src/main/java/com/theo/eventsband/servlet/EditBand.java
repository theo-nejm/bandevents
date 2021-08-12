package com.theo.eventsband.servlet;

import java.io.IOException;

import com.theo.eventsband.dao.BandDao;
import com.theo.eventsband.model.Band;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit-band")
public class EditBand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
	    
		BandDao dao = new BandDao();
		Band band = new Band();
		
		band.setName(request.getParameter("bandName"));
		
		System.out.println(request.getParameter("bandId"));
		
		int bandId = Integer.parseInt((String)request.getParameter("bandId"));
		dao.edit(bandId, band);
		
		response.sendRedirect("list-bands");
	}
}
