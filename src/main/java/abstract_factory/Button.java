package abstract_factory;

// Abstract product interface
public interface Button {
    void paint();
    default void click() {
        System.out.println("button clicked");
    }
}
