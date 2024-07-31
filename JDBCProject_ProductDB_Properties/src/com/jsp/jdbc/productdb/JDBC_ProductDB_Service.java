package com.jsp.jdbc.productdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_ProductDB_Service {
	
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_productdb?user=root&password=root");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	public void addProduct() {

		Connection con = getConnection();

		Scanner sc = new Scanner(System.in);

		try {
			PreparedStatement prepareStatement = con.prepareStatement("INSERT INTO product VALUES(?,?,?,?)");
			System.out.println("Enter your Product Id :");

			int productId = sc.nextInt();
			
			System.out.println("Enter your Product Name :");
			String productName = sc.next();
			
			System.out.println("Enter your Product Brand :");
			String productBrand = sc.next();
			
			System.out.println("Enter your Product Price");
			int productPrice = sc.nextInt();

			prepareStatement.setInt(1, productId);
			prepareStatement.setString(2, productName);
			prepareStatement.setString(3, productBrand);
			prepareStatement.setInt(4, productPrice);

			int rows = prepareStatement.executeUpdate();

			if (rows >= 0) {
				System.out.println("Product successfully inserted into the DB");
			} else {
				System.out.println("Not inserted ");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			sc.close();
		}

	}

	public void findProductById() {

		Connection con = getConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the product Id");
		
		int pId=sc.nextInt();
		try {
			PreparedStatement prepareStatement = con.prepareStatement("Select * from product where productId=?");
			prepareStatement.setInt(1, pId);
			
			ResultSet rs=prepareStatement.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
			rs.close();
			prepareStatement.close();
		} catch (SQLException e) {
		}
		sc.close();
		
	}

	public void findProductByName() {
		Connection con = getConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the product Name");
		
		String pName=sc.next();
		try {
			PreparedStatement prepareStatement = con.prepareStatement("Select * from product where productName=?");
			prepareStatement.setString(1, pName);
			
			ResultSet rs=prepareStatement.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
			
			rs.close();
			prepareStatement.close();
		} catch (SQLException e) {
		}
		sc.close();
	}

	
	public void findAllProducts() {
		Connection con = getConnection();
		try {
			PreparedStatement prepareStatement = con.prepareStatement("Select * from product");
			
			ResultSet rs=prepareStatement.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
			
			rs.close();
			prepareStatement.close();
		} catch (SQLException e) {
		}
	}
	
	
}


