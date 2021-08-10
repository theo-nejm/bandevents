package com.theo.eventsband.jbdc;

import java.sql.*;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/bandevents", "bandevents", "bandaspass.0.1");
		} catch(SQLException exc) {
			throw new RuntimeException(exc);
		}
	}
}
