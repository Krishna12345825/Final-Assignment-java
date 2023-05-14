package Assignment;


/*
2. Write a Java program to invoke parent class constructor from a child class. Create
Child class object and parent class constructor must be invoked. Demonstrate by
writing a program. Also explain key points about Constructor.
*/


class Parent {
    public Parent() {
        System.out.println("Parent constructor invoked");
    }
}

class Child extends Parent {
    public Child() {
        super(); // Invoking the parent class constructor
        System.out.println("Child constructor invoked");
    }
}

public class Question2 {
    public static void main(String[] args) {
        Child child = new Child(); // Creating Child class object
    }
}




/*
 * Explanation:
 * 
 * In Java, a constructor is a special method that is used to initialize an
 * object of a class. It has the same name as the class and does not have a
 * return type. Here are some key points about constructors in Java:
 * 
 * 1. Constructors are automatically invoked when an object of a class is
 * created using the new keyword. 2. Constructors can be overloaded, meaning a
 * class can have multiple constructors with different parameters. 3. If a class
 * does not define any constructors, a default constructor with no parameters is
 * automatically provided by the compiler. 4. To explicitly invoke a superclass
 * constructor from a subclass, the super() keyword is used. It must be the
 * first statement in the subclass constructor. If the super() keyword is not
 * used, the default superclass constructor (with no arguments) is invoked
 * implicitly. 5. If a superclass does not have a no-argument constructor, the
 * subclass must explicitly call one of the existing constructors using super().
 * In this case, the subclass constructor should provide the necessary arguments
 * to match one of the superclass constructors. 6. The super() keyword can also
 * be used to access superclass methods and variables.
 * 
 * 
 */
