import database.DatabaseService;
import org.junit.jupiter.api.*;
import jakarta.persistence.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseServiceTest {

    private final DatabaseService databaseService = new DatabaseService();

    @Test
    public void testCreateAccount() {
        databaseService.createAccount("John Doe", 1000.0);
        databaseService.getAccountById(1L);
    }
}