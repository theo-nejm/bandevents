package com.theo.eventsband.test;

import com.theo.eventsband.dao.BandDao;
import com.theo.eventsband.model.Band;

public class TestBandDao {
	public static void main(String[] args) {		
		BandDao dao = new BandDao();

		Band band = new Band();
		
		band.setName("AC&DC");
		
		dao.register(band);
		System.out.println("A banda de nome " + band.getName() + " foi adicionada com sucesso.");
	}
}
