# Adapter Design Pattern

### Problem:
Let's say we have a legacy system that uses a database with a specific interface to store data. However, we want to 
switch to a new database system with a different interface. Let's say we have a legacy system that uses a database with 
a specific interface to store data. However, we want to switch to a new database system with a different interface.

### Definition
The Adapter Design Pattern is a structural design pattern that allows incompatible interfaces to work together. 
This pattern converts the interface of an existing class into another interface that the client expects, without 
changing the original code.

### Solution
The Adapter Pattern solves the problem of incompatible interfaces by creating an intermediate object (the adapter) 
that translates requests from the client to the interface of the external module. The adapter implements the interface 
that the client expects, and delegates requests to the original module using its existing interface.

```java
// Legacy Database interface
public interface LegacyDatabase {
    void saveData(String data);
}

// Legacy Database implementation
public class LegacyDatabaseImpl implements LegacyDatabase {
    @Override
    public void saveData(String data) {
        System.out.println("Saving data to legacy database: " + data);
    }
}

// New Database interface
public interface NewDatabase {
    void insertData(String data);
}

// New Database implementation
public class NewDatabaseImpl implements NewDatabase {
    @Override
    public void insertData(String data) {
        System.out.println("Inserting data to new database: " + data);
    }
}

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

public class Client {
    public static void main(String[] args) {
        // Create a new instance of the NewDatabase implementation
        NewDatabase newDatabase = new NewDatabaseImpl();

        // Create an adapter object that adapts NewDatabase to LegacyDatabase
        LegacyDatabase legacyDatabase = new DatabaseAdapter(newDatabase);

        // Call the saveData method on the LegacyDatabase interface using the adapter object
        legacyDatabase.saveData("Some data to save");
    }
}
```

In this example, the LegacyDatabase interface represents the old database interface, and the NewDatabase interface 
represents the new database interface. The LegacyDatabaseImpl class implements the old database interface, and the 
NewDatabaseImpl class implements the new database interface.

The DatabaseAdapter class is the adapter that makes the new database interface compatible with the old database 
interface. It implements the LegacyDatabase interface, and it has a NewDatabase object as a member variable. The 
saveData method of the DatabaseAdapter class calls the insertData method of the NewDatabase object, effectively 
adapting the new interface to the old interface.

With this adapter in place, the rest of the code that interacts with the old database can continue to work without 
modification, even though the underlying implementation has changed.

### Consider using when:
- When you need to use an existing class that has an incompatible interface with your code.
- When you want to reuse existing code that can't be modified.
- When you want to decouple your code from external modules or systems.