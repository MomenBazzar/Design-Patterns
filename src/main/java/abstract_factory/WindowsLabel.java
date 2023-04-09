package abstract_factory;

// Concrete product for Windows label
public class WindowsLabel implements Label {
    @Override
    public void paint() {
        System.out.println("Windows label painted");
    }
}
