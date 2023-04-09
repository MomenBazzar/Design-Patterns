package abstract_factory;

// Abstract product interface
public interface Label {
    void paint();

    default void setText(String text) {
        System.out.println("Default label setText implementation: " + text);
    }
}
