# Observer Design Pattern

### Problem:

In software design, sometimes we need to have a way to notify multiple objects about the changes that occur in an
object's state. For example, in a weather monitoring application, we need to notify multiple objects such as the display
unit, mobile application, or website, whenever the temperature or humidity changes. One approach to handle this is to
define an interface for each of the objects that we want to notify and call the methods of these objects whenever a
state change occurs. But this approach has several drawbacks, including tightly coupling the objects, hard to maintain,
and inefficient.

### Definition:

The observer design pattern is a behavioral pattern that defines a one-to-many dependency between objects so that when
one object changes state, all its dependents are notified and updated automatically. It provides a way to notify
multiple objects about the changes that occur in an object's state without coupling the sender and receivers tightly.

The observer pattern consists of two types of objects: the subject and the observers. The subject is the object that is
being observed, while the observers are the objects that are interested in the state of the subject. The subject
maintains a list of all its observers and notifies them automatically whenever a state change occurs.

### Solution:

Here is an example of implementing the observer pattern in Java. We will create a WeatherStation class that acts as a
subject and a WeatherDisplay class that acts as an observer.

```java
import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private List<WeatherDisplay> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    public void addObserver(WeatherDisplay observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherDisplay observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (WeatherDisplay observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void measurementsChanged() {
        notifyObservers();
    }
}

public interface WeatherDisplay {
    public void update(float temperature, float humidity, float pressure);
}

public class CurrentConditionsDisplay implements WeatherDisplay {
    private float temperature;
    private float humidity;

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}

public class WeatherStationTest {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        weatherStation.addObserver(currentDisplay);
        weatherStation.setMeasurements(80, 65, 30.4f);
    }
}
```

In this example, the WeatherStation class acts as a subject that maintains a list of observers and notifies them
whenever a state change occurs. The WeatherDisplay interface defines the update method that the observers implement to
receive notifications from the subject. The CurrentConditionsDisplay class acts as an observer that implements the
update method to receive and display the updated weather information. The WeatherStationTest class demonstrates how to
use these classes to observe changes in the weather station.

###Consider using when:
- You need to notify multiple objects about the changes that occur in an object's state. 
- You want to decouple the sender and receivers of the notification. 
- You want to maintain consistency between related objects without making them tightly
coupled.