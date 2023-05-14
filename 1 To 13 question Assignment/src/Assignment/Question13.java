package Assignment;

/*
13. Create a Java program that connects to a PostgreSQL database and executes a
batch update. The program should read the input data from a file and insert it into the
database using JDBC batch updates.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question13 {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql:///mydatabase";
        String username = "root";
        String password = "root";
        String inputFile = "data.txt"; // Path to the input file

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Disable auto-commit to enable batch updates
            connection.setAutoCommit(false);

            // Prepare the SQL statement for batch update
            String sql = "INSERT INTO mytable (column1, column2) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Read data from the input file
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Split the line into columns (assuming comma-separated values)
                    String[] columns = line.split(",");

                    // Set the values for the prepared statement
                    statement.setString(1, columns[0]);
                    statement.setString(2, columns[1]);

                    // Add the statement to the batch
                    statement.addBatch();
                }

                // Execute the batch update
                int[] updateCounts = statement.executeBatch();

                // Commit the transaction
                connection.commit();

                System.out.println("Batch update completed. Rows affected: " + updateCounts.length);
            } catch (Exception e) {
                // Rollback the transaction if an error occurs
                connection.rollback();
                e.printStackTrace();
            } finally {
                // Close the statement
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
