package com.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JdbcTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
		//to load the driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=mars;"+  "encrypt= true; trustServerCertificate = true";
		String user = "sa";
		String password = "19Lmar71";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		//String query = "select * from product";
		//Statement stmt = con.createStatement();		
		//for dynamic query
		String query = "select * from product where prod_desc = ? and price > ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, "SAMSUNG");
		pstmt.setInt(2, 500);
		
		//ResultSet rs = stmt.executeQuery(query);
		ResultSet rs = pstmt.executeQuery();
		List <Product> productSet = new ArrayList<Product>();
		
		if(con !=null) {
			System.out.println("Connection established successfully");
	
		while (rs.next()) {
//			System.out.println("Prod_id: " + rs.getString("prod_id"));
//			System.out.println("Prod_name: " + rs.getString("prod_name"));
//			System.out.println("Prod_desc: " + rs.getString("prod_desc"));
//			System.out.println("Price: " + rs.getDouble("price"));
			
			Product prod1= new Product(rs.getString("prod_id"), rs.getString("prod_name"), rs.getString("prod_desc"), rs.getDouble("price"));
			productSet.add(prod1);
		}
		
		Collections.sort(productSet, new PriceComparator());
		System.out.println("---Products Listed from Least to Most Expensive----");
		for (Product product: productSet) {
			
			System.out.println("Id: " + product.getProd_id()+ "   Name: " + product.getProd_name() +
					"     Desc: " + product.getProd_desc() + "  Price: $" +  product.getPrice());
		}
		}
		else {
			System.out.println("Connection refused!!");
		}

	}

	
	
}
