package com.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.training.mars.MyException;

public class NECCharges {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//to load the driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=mars;"+  "encrypt= true; trustServerCertificate = true";
		String user = "sa";
		String password = "19Lmar71";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String query = "select * from consumer";
		PreparedStatement pstmt = con.prepareStatement(query);
	
		ResultSet rs = pstmt.executeQuery();
		List <MyConsumer> consumerSet = new ArrayList<MyConsumer>();
		
		if(con !=null) {
				System.out.println("Connection established successfully");
				Scanner scanner = new Scanner(System.in);
				//user input for number of bills to prepare
				System.out.println("Input number of bills to prepare: ");
				int noBills= scanner.nextInt();
				int i = 0;
				while (rs.next() && i < noBills) {	
					MyConsumer consum1= new MyConsumer(rs.getInt("consumer_number"), rs.getString("consumer_name"), rs.getInt("unit_consumption"));
					consumerSet.add(consum1);
					i++;
				}
		
				try {
					if(noBills> consumerSet.size()) {
						throw new MyException("---------------Error:  Requesting to print more records than exists.  Max number of records is " + consumerSet.size());
					}
				}
				catch(MyException e) {
					System.out.println(e.getMessage());
				}
				for (MyConsumer consumer: consumerSet) {
					double cost;
					try {
						if (consumer.getUnits() < 50) {
							throw new MyException("------ERROR: No of units can not be less than 50-----");
						}
						
					}
					catch(MyException e) {
						System.out.println(e.getMessage());
					}
				
					cost = consumer.CalcMonthlyCharge(consumer.getUnits());
					System.out.println("Id: " + consumer.getId()+ "   Name: " + consumer.getName()+
							"     Units: " + consumer.getUnits() + "  Cost: " + cost );
				}
				
			
				
		}
		else {
			System.out.println("Connection refused!!");
		}

	}

}