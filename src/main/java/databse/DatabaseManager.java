package databse;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseManager {

    private static EntityManagerFactory factory;

    private DatabaseManager() {
    }

    public static EntityManagerFactory getFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("Library");
            return factory;
        } else return factory;
    }
}