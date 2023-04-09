package adapter;

// Adapter class that adapts NewDatabase to LegacyDatabase
public class DatabaseAdapter implements LegacyDatabase {
    private final NewDatabase newDatabase;

    public DatabaseAdapter(NewDatabase newDatabase) {
        this.newDatabase = newDatabase;
    }

    @Override
    public void saveData(String data) {
        newDatabase.insertData(data);
    }
}
