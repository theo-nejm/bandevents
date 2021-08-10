package com.theo.eventsband.test;

import java.sql.*;

import com.theo.eventsband.jbdc.ConnectionFactory;

public class TestConnection {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		
		connection.close();
	}
}
