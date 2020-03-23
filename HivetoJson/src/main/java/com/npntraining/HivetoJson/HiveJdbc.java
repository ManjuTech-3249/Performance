package com.npntraining.HivetoJson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveJdbc {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/emp_m", "npntraining", "npntraining");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from customer");
		
		while(rs.next()) {
			System.out.println("CUstomer name is:"+rs.getString("name"));
			System.out.println("Customer Age is:"+rs.getInt("AGE"));
		}
	}
		
}
