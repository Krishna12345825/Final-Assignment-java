package Assignment;


/*
3. Write a Java programme that takes an integer from the user and throws an exception
if it is negative.Demonstrate Exception handling of same program as solution.


*/


import java.util.Scanner;
public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();

            if (number < 0) {
                throw new NegativeNumberException("Negative numbers are not allowed.");
            }

            System.out.println("Entered number: " + number);
        } catch (NegativeNumberException ex) {
            System.out.println("Exception: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }
}

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}




/*
 * In this program, we create a custom exception class called
 * NegativeNumberException that extends the base Exception class. This class
 * represents the exception thrown when a negative number is encountered.
 * 
 * Inside the main method, we use a Scanner to read an integer from the user. If
 * the entered number is negative, we throw a NegativeNumberException.
 * 
 * We handle the exception using a try-catch block. If a NegativeNumberException
 * is caught, we print the corresponding error message. If any other exception
 * occurs, we print a generic error message.
 * 
 * The finally block is used to close the Scanner object, ensuring proper
 * resource cleanup.
 */





