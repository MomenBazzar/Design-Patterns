package adapter;

// New Database implementation
public class NewDatabaseImpl implements NewDatabase {
    @Override
    public void insertData(String data) {
        System.out.println("Inserting data to new database: " + data);
    }
}
