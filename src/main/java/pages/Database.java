package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String columnValue;
	List<String> valAsList;

	public String getDataFromDb(String columnName) {

//		set properties for mySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sqlUsername = "root";
			String sqlPassword = "root";
			String sqlUrl = "jdbc:mysql://localhost:3306/august2023";
			String sqlQuery = "select * from users;";

//			Create connection to the local database must close the connection at the e
			connection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);

//			Empowering connection reference variable to execute queries
			statement = connection.createStatement();

//			Delivering query
			resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				columnValue = resultSet.getString(columnName);
				return columnValue;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return columnValue;
	}

	public List<String> getDataFromDbAsList(String columnName) {
		valAsList = new ArrayList<String>();
		// set the properties of mySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sqlUrl = "jdbc:mysql://localhost:3306/august2023";
		String sqlUsername = "root";
		String sqlPassword = "root";
		String sqlQuery = "select * from users;";
//		create connection to the local database
		try {
			connection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		empower the connection reference variable to execute queries
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		deliver the query
		try {
			resultSet = statement.executeQuery(sqlQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				columnValue = resultSet.getString(columnName);
				valAsList.add(columnValue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return valAsList;
	}

}
