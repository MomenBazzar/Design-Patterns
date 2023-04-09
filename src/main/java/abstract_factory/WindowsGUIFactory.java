package abstract_factory;

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
