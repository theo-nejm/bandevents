package com.theo.eventsband.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.theo.eventsband.jbdc.ConnectionFactory;
import com.theo.eventsband.model.Band;

public class BandDao {
	private Connection connection;
	
	public BandDao () {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void register(Band band) throws SQLIntegrityConstraintViolationException {
		String sqlQuery = "INSERT INTO bands (name) values(?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setString(1, band.getName());
			
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException exc) {
			throw new RuntimeException(exc);
		}
	}
	
	public Band getOne(int id) {
		String sqlQuery = "SELECT * FROM bands WHERE id = ?";
		Band band = new Band();
		try {
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				band.setName(result.getString("name"));
				band.setId(result.getLong("id"));
			}
			
			result.close();
			statement.close();
			connection.close();
			
		} catch (SQLException exc) {
			throw new RuntimeException(exc);
		}
		
		return band;
	}
	
	public List<Band> getAll() {
		List<Band> bandsList = new ArrayList<Band>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM bands");	
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				Band band = new Band();
				band.setId(result.getLong("id"));
				band.setName(result.getString("name"));
				
				bandsList.add(band);
			}
			
			statement.close();
			result.close();
			connection.close();
			
		} catch (SQLException exc) {
			throw new RuntimeException(exc);
		}
		
		return bandsList;
	}
	
	public void remove(int id) {
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM bands WHERE id=" + id);
			
			statement.execute();
			
			statement.close();
			connection.close();
			
		} catch (SQLException exc) {
			throw new RuntimeException(exc);
		}
	}
	
	public void edit(int id, Band band) {
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE bands SET name = ? WHERE id = ?");
			
			statement.setString(1, band.getName());
			statement.setInt(2, id);
			
			statement.execute();
			
			statement.close();
			connection.close();
			
		} catch (SQLException exc) {
			throw new RuntimeException(exc);
		}
	}
}
