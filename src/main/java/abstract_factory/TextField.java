package abstract_factory;

// Abstract product interface
public interface TextField {
    void paint();
    default void setText(String text) {
        System.out.println("Default TextField setText implementation: " + text);
    }
}
