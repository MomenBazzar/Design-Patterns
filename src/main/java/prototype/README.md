# Prototype Design Pattern
### Problem:
Suppose you have an application that creates a lot of objects that are similar, but not identical. Creating these 
objects from scratch every time can be expensive and time-consuming, especially if the objects require complex 
computations or database access.

### Definition:
The Prototype Design Pattern is a creational design pattern that allows you to create new objects based on an existing 
object. The existing object is called the prototype, and new objects are created by copying the prototype. This pattern 
allows you to create new objects quickly and efficiently by reusing existing objects.

### Solution:
In the prototype pattern, an existing object serves as a prototype for creating new objects. The new object is created 
by copying the existing object.

In the following example, we have a class called Person that contains personal information such as name, age, gender, 
and address. We also have a PersonRegistry class that stores a list of pre-configured Person objects. We can use the 
clone() method to create a new Person object by copying the properties of an existing Person object.

```java
public class Person implements Cloneable {
private String name;
private int age;
private String gender;
private String address;

    public Person(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    // Copy constructor
    public Person(Person person) {
        this.name = person.name;
        this.age = person.age;
        this.gender = person.gender;
        this.address = person.address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return new Person(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

public class PersonRegistry {
private Map<String, Person> registry = new HashMap<>();

    public PersonRegistry() {
        loadPersons();
    }

    private void loadPersons() {
        registry.put("John", new Person("John", 25, "Male", "123 Main St"));
        registry.put("Jane", new Person("Jane", 30, "Female", "456 Elm St"));
        registry.put("Bob", new Person("Bob", 40, "Male", "789 Oak St"));
    }

    public Person getPerson(String name) throws CloneNotSupportedException {
        return registry.get(name).clone();
    }
}
```

In this example, the Person class implements the Cloneable interface, which allows us to create a copy of an existing Person object. The PersonRegistry class contains a list of pre-configured Person objects. We can retrieve a Person object from the registry by calling the getPerson method, which returns a clone of the existing Person object.

###Consider using when:
- Creating new objects from scratch is expensive or time-consuming.
- You want to create new objects that are similar to existing objects.
- You want to hide the complexity of object creation from the client code.