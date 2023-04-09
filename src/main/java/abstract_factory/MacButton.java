package abstract_factory;

// Concrete product for Mac button
public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac button painted");
    }

}
