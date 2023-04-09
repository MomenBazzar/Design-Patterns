package abstract_factory;

// Concrete product for Windows text field
public class WindowsTextField implements TextField {
    @Override
    public void paint() {
        System.out.println("Windows text field painted");
    }
}
