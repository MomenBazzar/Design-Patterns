package abstract_factory;

// Concrete product for Windows button
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Windows button painted");
    }

}
