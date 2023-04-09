package abstract_factory;

// Client code
public class Main {
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