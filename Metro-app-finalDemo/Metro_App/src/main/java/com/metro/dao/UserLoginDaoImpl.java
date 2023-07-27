package com.metro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metro.modal.User;

public class UserLoginDaoImpl implements UserLoginDao {

	public static String PERSON_STORE_ID = null;

	@Override
	public User userLogin(String username, String password) throws ClassNotFoundException {

		// Logic for jdbc connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		User user = new User();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/metrostore", "root",
				"metro@2411");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from users where uname = ? and password = ? ")) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				user.setName(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				user.setStoreNumber(rs.getInt("store_id"));
				// store Id person
				PERSON_STORE_ID = rs.getString("store_id");
			}

			System.out.println(preparedStatement);
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public void invoiceDetails(String invoicenumber, String customerid, int storenumber, String date) {
		// TODO Auto-generated method stub

	}

}
