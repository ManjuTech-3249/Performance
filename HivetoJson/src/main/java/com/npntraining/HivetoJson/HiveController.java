package com.npntraining.HivetoJson;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HiveController {
	
	 @SuppressWarnings("finally")
	@RequestMapping("/")
	 public List<Employee> getEmployee(){
		 
		 List<Employee> list = new ArrayList<Employee>();	
		 
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			Connection connection = DriverManager.getConnection("jdbc:hive2://localhost:10000/emp_m", "npntraining",
					"npntraining")  ;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from customer");
			
			while(rs.next()) {
				Employee e = new Employee();
				e.ename = rs.getString("name");
				e.age = rs.getInt("age");
				list.add(e);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			return list;
		}
		 
	 }
}
