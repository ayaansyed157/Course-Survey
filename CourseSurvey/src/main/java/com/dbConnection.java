/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

/**
 *
 * @author shaba
 */
import java.sql.*;
public class dbConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/course_survey";
        String user = "user";
        String password = "pass";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected!");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Connection failed!");
        }
    }
}



