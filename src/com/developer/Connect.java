package com.developer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect {

    public int contact(Contactinfo conti) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO contactinfo" +
            "  (name, email, subject, message) VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        //Step 1: Established the connection with database
      try (Connection connection = DriverManager
     .getConnection("jdbc:mysql://localhost:3306/developerapp? useSSL=false", "root", "Root");

        // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement =  connection.prepareStatement(INSERT_USERS_SQL)) 
            { 
    	  preparedStatement.setString(1,conti.getname());
    	  preparedStatement.setString(2,conti.getemail());
    	  preparedStatement.setString(3,conti.getsubject());
    	  preparedStatement.setString(4,conti.getmessage());
            
            

        // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

	
}