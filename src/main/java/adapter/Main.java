package adapter;

public class Main {
    public static void main(String[] args) {
        // Create a new instance of the NewDatabase implementation
        NewDatabase newDatabase = new NewDatabaseImpl();

        // Create an adapter object that adapts NewDatabase to LegacyDatabase
        LegacyDatabase legacyDatabase = new DatabaseAdapter(newDatabase);

        // Call the saveData method on the LegacyDatabase interface using the adapter object
        legacyDatabase.saveData("Some data to save");
    }
}
