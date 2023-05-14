package Assignment;

/*
5. Demonstrate the difference between abstract class and interface by writing programs
as well as in keypoints.

*/




/*
 * 
 * In Java, both abstract classes and interfaces are used to define abstract
 * types that cannot be instantiated directly. They serve as blueprints for
 * derived classes to inherit from and provide a way to define common behavior
 * and contracts for classes. However, there are some key differences between
 * abstract classes and interfaces. Let's demonstrate these differences through
 * example programs and highlight the key points:
 * 
 * Abstract Class: An abstract class is a class that cannot be instantiated and
 * may contain abstract methods, concrete methods, and member variables. Here's
 * an example:
 * 
 */




//                           example 
/*

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void sound();

    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void sound() {
        System.out.println(name + " says woof!");
    }
}

public class Question5 {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");
        dog.sound(); // Output: Buddy says woof!
        dog.sleep(); // Output: Buddy is sleeping
    }
}

*/


/*
 * Key Points:
 * 
 * 1. Abstract classes can have member variables, constructor(s), and concrete
 * methods in addition to abstract methods. Abstract methods declared in an
 * 2. abstract class must be implemented by any concrete class that extends it.   3. An
 * abstract class can be extended by a single class only.  4.  An abstract class can
 * be used to provide default implementation and common functionality to its
 * subclasses. 
 * 
 * 2Interface:
 *    An interface is a reference type that contains only
 * abstract method declarations, default methods, static methods, and constant
 * fields. Here's an example:
 * 
 */






interface Animal {
    void sound();
    default void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Dog says woof!");
    }
}

public class Question5 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound(); // Output: Dog says woof!
        dog.sleep(); // Output: Animal is sleeping
    }
}






/*
 * 
 * Key Points:
 * 
 * 1. Interfaces can only declare abstract methods, which must be implemented by
 * any class that implements the interface. 
 * 2. An interface can provide default  method implementations, which can be overridden in 
 * implementing classes.
 * 3. Multiple interfaces can be implemented by a single class, allowing for
 * multiple inheritance of behavior. 
 * 4. Interfaces are used to define contracts that classes must adhere to, 
 * without specifying any implementation details.
 * 
 * 
 * 
 * In summary, abstract classes are used when we want to provide a common base
 * implementation along with abstract methods, while interfaces are used to
 * define contracts without any implementation details. Abstract classes allow
 * for single inheritance, while interfaces allow for multiple inheritance.
 * 
 */
