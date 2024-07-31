package com.jsp.jdbc.productdb;
import java.util.Scanner;

public class JDBC_Productdb_App {
	public static void main( String[] args )
    {
        System.out.println("PRODUCT  Database");
        System.out.println("1.Add Product\n2.Find Product By ID\n3.Find Product By Name\n4.Find ALL Product ");
        Scanner sc=new Scanner(System.in);
        JDBC_ProductDB_Service ps=new JDBC_ProductDB_Service();
        switch(sc.nextInt()) {
        	case 1:ps.addProduct();
        		break;
        	case 2:ps.findProductById();
        		break;
        	case 3:ps.findProductByName();
        		break;
        	case 4:ps.findAllProducts();
        		break;
        	
        	default:
        		System.out.println("Invalid input");
        }
    }

}