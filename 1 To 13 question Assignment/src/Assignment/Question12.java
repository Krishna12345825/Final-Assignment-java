package Assignment;

/*
12. Write a Java program that uses JDBC to implement a simple CRUD (create, read,
update, delete) application. The program should allow users to add, view, update,
and delete records in a MySQL database table.
*/


import java.sql.*;
public class Question12 {
    private static final String DB_URL = "jdbc:mysql:///mydatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create table if it doesn't exist
            createTable(connection);

            // Insert a record
            int recordId = insertRecord(connection, "krishna kumar", "krishna@gmail.com");

            // Display all records
            displayAllRecords(connection);

            // Update the inserted record
            updateRecord(connection, recordId, "Rani Kumari", "rani@gmail.com");

            // Display all records
            displayAllRecords(connection);

            // Delete the inserted record
            deleteRecord(connection, recordId);

            // Display all records
            displayAllRecords(connection);

            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String createTableQuery = "CREATE TABLE IF NOT EXISTS records (id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(100) NOT NULL, email VARCHAR(100) NOT NULL)";
        statement.executeUpdate(createTableQuery);
        statement.close();
    }

    private static int insertRecord(Connection connection, String name, String email) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO records (name, email) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        int recordId = -1;
        if (generatedKeys.next()) {
            recordId = generatedKeys.getInt(1);
        }

        generatedKeys.close();
        preparedStatement.close();

        return recordId;
    }

    private static void displayAllRecords(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM records");
        System.out.println("Records:");
        System.out.println("ID\tName\tEmail");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println(id + "\t" + name + "\t" + email);
        }
        resultSet.close();
        statement.close();
        System.out.println();
    }

    private static void updateRecord(Connection connection, int id, String name, String email) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE records SET name = ?, email = ? WHERE id = ?");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static void deleteRecord(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM records WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
