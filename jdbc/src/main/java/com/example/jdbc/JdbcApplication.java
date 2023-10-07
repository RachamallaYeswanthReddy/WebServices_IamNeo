package com.example.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {
			// Establish the connection
			String url = "jdbc:mysql://localhost:3306/studentdata";
			connection = DriverManager.getConnection(url, "root", "Yeswanth@123");

			//create a prepared statement
//			String insertQuery = "insert into _student(id,name,email,dept) values(?,?,?,?)";
//			PreparedStatement in = connection.prepareStatement(insertQuery);
//			in.setLong(1,78);
//			in.setString(2,"Amulya");
//			in.setString(3,"amulyaanad@gmail.com");
//			in.setString(4,"CSE core");
//			int noofrowsupdated = in.executeUpdate();

			String selectQuery = "select * from _student";
			PreparedStatement ps= connection.prepareStatement(selectQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				System.out.println(rs.getLong("id")+" "+rs.getString("name")+
						" "+rs.getString("email")+" "+rs.getString("dept"));
			}

			// clean all the resources
			rs.close();
			ps.close();

		}catch (SQLException e){
			System.out.println(e);
		}finally {
			connection.close();
		}
	}
}