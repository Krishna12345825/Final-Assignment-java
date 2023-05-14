package Assignment;
/*
11. Write a Java program that connects to a MySQL database using JDBC. The program
should read data from a table and display the results in the console.
*/

import java.sql.*;

public class Question11 {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydatabase"; //  MySQL database URL
        String username = "root"; // Replace with your MySQL username
        String password = "root"; // Replace with your MySQL password

        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Create a SQL statement
            Statement statement = connection.createStatement();

            // Execute a query to retrieve data from a table
            String query = "SELECT * FROM mytable"; //  table name
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id"); // Assuming 'id' is an integer column
                String name = resultSet.getString("name"); // Assuming 'name' is a string column

                // Display the retrieved data
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
