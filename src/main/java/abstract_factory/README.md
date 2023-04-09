# Abstract Factory Design Pattern

### Problem:
In some cases, you need to create families of related objects, such as creating a GUI for an application. 
For example, you may need to create a GUI for a Windows or a Mac operating system. Each GUI has its own set of 
components, such as buttons, text fields, and labels. Creating a separate factory for each operating system is 
tedious and error-prone.

### Definition
The Abstract Factory pattern provides an interface for creating families of related objects without specifying their 
concrete classes. The Abstract Factory pattern is often used in conjunction with the Factory Method pattern.

### Solution
Let's assume that we want to create a GUI with different components, including buttons, text fields, and labels. 
We need to support different operating systems, such as Windows and Mac. Each operating system has its own set of 
GUI components. We can use the Abstract Factory pattern to create a factory for each operating system, which creates 
a family of related components.

```java
// Abstract factory interface
public interface GUIFactory {
    Button createButton();
    TextField createTextField();
    Label createLabel();
}

// Concrete factory for Windows GUI components
public class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }

    @Override
    public Label createLabel() {
        return new WindowsLabel();
    }
}

// Concrete factory for Mac GUI components
public class MacGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextField createTextField() {
        return new MacTextField();
    }

    @Override
    public Label createLabel() {
        return new MacLabel();
    }
}

// Abstract product interface
public interface Button {
    void paint();
}

// Concrete product for Windows button
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Windows button painted");
    }
}

// Concrete product for Mac button
public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac button painted");
    }
}

// Abstract product interface
public interface TextField {
    void paint();
}

// Concrete product for Windows text field
public class WindowsTextField implements TextField {
    @Override
    public void paint() {
        System.out.println("Windows text field painted");
    }
}

// Concrete product for Mac text field
public class MacTextField implements TextField {
    @Override
    public void paint() {
        System.out.println("Mac text field painted");
    }
}

// Abstract product interface
public interface Label {
    void paint();
}

// Concrete product for Windows label
public class WindowsLabel implements Label {
    @Override
    public void paint() {
        System.out.println("Windows label painted");
    }
}

// Concrete product for Mac label
public class MacLabel implements Label {
    @Override
    public void paint() {
        System.out.println("Mac label painted");
    }
}

// Client code
public class Application {
    public static void main(String[] args) {
        // Create a GUI factory for Windows
        GUIFactory windowsFactory = new WindowsGUIFactory();

        // Create a GUI factory for Mac
        GUIFactory macFactory = new MacGUIFactory();

        // Create Windows components
        Button windowsButton = windowsFactory.createButton();
        TextField windowsTextField = windowsFactory.createTextField();
        Label windowsLabel = windowsFactory.createLabel();

        // Create Mac components
        Button macButton = macFactory.createButton();
        TextField macTextField = macFactory.createTextField();
        Label macLabel = macFactory.createLabel();
        // Use Windows components
        windowsButton.click();
        windowsTextField.setText("Hello, Windows!");
        windowsLabel.setText("This is a Windows label.");

        // Use Mac components
        macButton.click();
        macTextField.setText("Hello, Mac!");
        macLabel.setText("This is a Mac label.");
    }
}
```

### Consider using when:
there is a family of factories and you need a super factory for related factories.