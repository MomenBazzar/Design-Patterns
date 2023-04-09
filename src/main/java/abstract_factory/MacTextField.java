package abstract_factory;

// Concrete product for Mac text field
public class MacTextField implements TextField {
    @Override
    public void paint() {
        System.out.println("Mac text field painted");
    }
}
