package abstract_factory;

// Concrete product for Mac label
public class MacLabel implements Label {
    @Override
    public void paint() {
        System.out.println("Mac label painted");
    }
}
