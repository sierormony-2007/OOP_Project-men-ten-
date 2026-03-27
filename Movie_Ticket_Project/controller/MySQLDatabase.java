package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDatabase {
    private static Connection connection = null;
    private static final String URL = 
    "jdbc:mysql://localhost:3306/hr_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2007";

    // public static Connection getConnection(){
    //     if(connection == null) {
            
    //         connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    //         System.out.println("success");{
           
    //     }
    //     return connection;
    // }
    public static Connection getConnection(){
        if(connection == null){
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("success");

                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
                connection = null;
                System.out.println("closed");
            } catch (SQLException e) {
                System.out.println();
                e.printStackTrace();
            }
        }
    }
    public static ResultSet executeQuery(String query){
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static int execuUpdate(String query){
        try {
            Statement statement = getConnection().createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Update");
            e.printStackTrace();
        }
        return 0;
    }
    public static void main(String[] args) {
        Connection c = getConnection();
        closeConnection();
        ResultSet resultSet = executeQuery("select * from departments;");
            try {
                while(resultSet.next()){
                    System.out.println(resultSet.getString("MANAGER_ID"));
                    resultSet.getString(3);
                    // System.out.println(resultSet.getString());
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            
        }
        
    }
    
}
