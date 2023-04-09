# Factory Design Pattern

### Problem:
Consider the scenario where we have an interface, Vehicle, with multiple implementations, such as Car, Bus, and Truck.
Each implementation has its own specific implementation details. For example, Car has 4 wheels, Bus has 6 wheels, 
and Truck has 10 wheels.

Now, we want to create instances of these implementations based on a certain type, but we don't want the client to 
be aware of the implementation details or the logic for creating these instances. We also want to make it easy to add 
new implementations in the future without modifying existing code.

### Definition
The Factory design pattern is a creational pattern that provides an interface or abstract class to create objects in 
a superclass, but allows subclasses to alter the type of objects that will be created. It encapsulates the object 
creation logic in a separate class, which is known as the factory, and provides an interface for clients to create 
objects. This pattern provides a way to create objects without exposing the creation logic to the client.

### Solution
In the context of the Vehicle example, we can create a VehicleFactory class to create instances of the Vehicle 
interface. The client can simply use the factory class to create the required vehicle without worrying about the 
underlying implementation.

```java
public interface Vehicle {
    void start();
}

public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started.");
    }
}

public class Bus implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bus started.");
    }
}

public class Truck implements Vehicle {
    @Override
    public void start() {
        System.out.println("Truck started.");
    }
}

public class VehicleFactory {
    public Vehicle createVehicle(String type) {
        switch (type) {
            case "car":
                return new Car();
            case "bus":
                return new Bus();
            case "truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Invalid vehicle type.");
        }
    }
}
```

Now, the client can simply use the VehicleFactory to create instances of the Vehicle interface without worrying 
about the underlying implementation:

```java
VehicleFactory factory = new VehicleFactory();

Vehicle car = factory.getVehicleOfType(VehicleType.CAR);
car.wheels();

Vehicle bus = factory.getVehicleOfType(VehicleType.BUS);
bus.wheels();
```
### Consider using when:
A super class has multiple sub-classes and based on input, need to return one of the sub-class.