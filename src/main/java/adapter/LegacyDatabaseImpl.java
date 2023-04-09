package adapter;

// Legacy Database implementation
public class LegacyDatabaseImpl implements LegacyDatabase {
    @Override
    public void saveData(String data) {
        System.out.println("Saving data to legacy database: " + data);
    }
}
