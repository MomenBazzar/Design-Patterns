package abstract_factory;

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
