package abstract_factory;

// Abstract factory interface
public interface GUIFactory {
    Button createButton();
    TextField createTextField();
    Label createLabel();
}