package Builder;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new
                Pizza.Builder()
                .addCheese()
                .addTomato()
                .setSize(Size.MEDIUM)
                .build();

        System.out.println(pizza);

    }
}
