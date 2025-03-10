import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.Y_LAB.bazan.model.User.User;
import ru.Y_LAB.bazan.view.ConsoleUI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {
    private ConsoleUI consoleUI;
    private Map<String, User> userMap;
    private PrintStream originalOut;
    private InputStream originalIn;

    @Before
    public void setUp() {
        userMap = new HashMap<>();
        consoleUI = new ConsoleUI();
        originalOut = System.out; // Сохраняем оригинальный PrintStream
        originalIn = System.in;   // Сохраняем оригинальный InputStream
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testRegisterUserSuccess() {
        String input = "test@example.com\npassword\nusername\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        consoleUI.registerUser();

        assertEquals("Registration is complete!", outContent.toString().trim());
        assertEquals(1, userMap.size());
        assertEquals("test@example.com", userMap.keySet().iterator().next());
    }

    @Test
    public void testRegisterUserWithExistingEmail() {
        userMap.put("existing@example.com", new User("existing@example.com", "password", "username"));

        String input = "existing@example.com\npassword\nusername\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        consoleUI.registerUser();

        assertEquals("This email already exists!", outContent.toString().trim());
        assertEquals(1, userMap.size()); // Пользователь не должен добавляться
    }

    @Test
    public void testRegisterUserWithInvalidEmail() {
        String input = "invalid-email\npassword\nusername\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        consoleUI.registerUser();

        assertEquals("Invalid email!", outContent.toString().trim());
        assertEquals(0, userMap.size()); // Пользователь не должен добавляться
    }
}