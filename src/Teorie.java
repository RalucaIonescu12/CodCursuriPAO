public class Teorie
{
    /**
     * ABSTRACT CLASS
    In Java, an abstract class is a class that cannot be instantiated and is typically used as a base class for other classes. It serves as a blueprint for its subclasses, providing common fields, methods, and behavior. Here are some important rules and characteristics of abstract classes in Java:

    Abstract Keyword: An abstract class is declared using the "abstract" keyword in its class declaration. For example: abstract class AbstractClass { ... }

    Incomplete Implementation: An abstract class can have abstract methods, which are declared without a body and end with a semicolon. These methods are meant to be implemented by the subclasses. Abstract methods are defined using the "abstract" keyword. For example: abstract void methodName();

    Partial Implementation: An abstract class can also have regular methods with a complete implementation. These methods provide common functionality and can be used by the subclasses as-is. Subclasses are not required to override or implement these methods.

    Cannot Be Instantiated: Abstract classes cannot be instantiated directly using the "new" keyword. They are meant to be extended by subclasses, which provide the necessary implementations for abstract methods. However, you can create references of an abstract class type.

    Subclassing: Subclasses of an abstract class must either provide implementations for all the abstract methods of the superclass or be declared as abstract themselves. If a subclass does not implement all the abstract methods inherited from the abstract superclass, it must also be marked as abstract.

    Inheritance: An abstract class can extend another abstract class or a regular (concrete) class. It inherits all the non-private members (fields and methods) of its superclass, abstract or not. It can also provide additional methods and fields specific to its own behavior.

        Constructors: Abstract classes can have constructors, which are used to initialize the state of the abstract class or its fields. Constructors of an abstract class are invoked when creating an instance of a concrete subclass.

    Access Modifiers: Abstract classes and their members can have different access modifiers such as public, protected, or default (package-private). The choice of access modifier depends on the desired level of accessibility for the abstract class and its members.

    Remember that an abstract class can contain a mix of abstract and non-abstract methods, and it is not mandatory for an abstract class to have any abstract methods. The key aspect of an abstract class is that it provides a common interface and potential method implementations for its subclasses, while allowing subclasses to provide specific implementations for abstract methods.


     *FINAL CLASS

     In Java, a final class is a class that cannot be subclassed or extended by other classes. Once a class is declared as final, it cannot be inherited. Here are some important points to know about final classes:

     Final Keyword: The final keyword is used to mark a class as final. For example: final class FinalClass { ... }

     Prevents Inheritance: A final class cannot be extended or subclassed. This means that no other class can inherit from a final class using the extends keyword. Any attempt to create a subclass of a final class will result in a compilation error.

     Method Overriding: Methods in a final class cannot be overridden by subclasses. All methods declared in a final class are implicitly final as well. This ensures that the behavior of methods in the final class remains consistent and cannot be changed by subclasses.

     Constant Values: Final classes are often used to create utility classes or classes that provide constants. In such cases, the fields in a final class are typically declared as final, indicating that their values cannot be modified.

     Performance Optimization: Marking a class as final can provide performance benefits in some cases. The compiler can perform certain optimizations since it knows that the class cannot be overridden or extended.

     Immutable Objects: Final classes are often used to create immutable objects. By making a class final, you can ensure that the state of the object cannot be modified once it is created.

     Access Modifiers: Final classes and their members can have different access modifiers such as public, protected, or default (package-private). The choice of access modifier depends on the desired level of accessibility for the final class and its members.

     It's worth noting that while a class can be declared final, its fields and methods may have different access modifiers, allowing for different levels of visibility and accessibility.

     Overall, the use of final classes in Java provides a way to create classes that cannot be extended, ensuring their intended behavior and preventing modification by other classes.
     */
}
