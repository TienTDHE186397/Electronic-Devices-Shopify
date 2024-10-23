    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
     */
    package Email;

    import org.junit.jupiter.api.AfterEach;
    import org.junit.jupiter.api.AfterAll;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    /**
     *
     * @author admin
     */
    public class PasswordUtilsTest {

        public PasswordUtilsTest() {
        }
        @Test
    public void testShiftPassword_DecisionCoverage() {
        System.out.println("shiftPassword - Decision Coverage");

        // Case 1: Password is empty
        String password1 = "";
        PasswordUtils instance = new PasswordUtils();
        String result1 = instance.shiftPassword(password1);
        assertEquals("", result1);

        // Case 2: Password has only one character
        String password2 = "A";
        String result2 = instance.shiftPassword(password2);
        assertEquals("B", result2); // Assuming shift adds 1 to each char

        // Case 3: Password has multiple characters
        String password3 = "Test123";
        String result3 = instance.shiftPassword(password3);
        assertEquals("Uftu234", result3); // Assuming each char is shifted by 1
    }

    @Test
    public void testReverPassword_DecisionCoverage() {
        System.out.println("ReverPassword - Decision Coverage");

        // Case 1: Password is empty
        String password1 = "";
        PasswordUtils instance = new PasswordUtils();
        String result1 = instance.ReverPassword(password1);
        assertEquals("", result1);

        // Case 2: Password has only one character
        String password2 = "A";
        String result2 = instance.ReverPassword(password2);
        assertEquals("A", result2);

        // Case 3: Password has multiple characters
        String password3 = "abc123";
        String result3 = instance.ReverPassword(password3);
        assertEquals("321cba", result3);
    }
    @Test
    public void testShiftPassword_StatementCoverage() {
        System.out.println("shiftPassword - Statement Coverage");

        PasswordUtils instance = new PasswordUtils();

        // Case 1: Shift password with an empty string
        String password1 = "";
        String result1 = instance.shiftPassword(password1);
        assertEquals("", result1);

        // Case 2: Shift password with normal string
        String password2 = "ShiftTest";
        String result2 = instance.shiftPassword(password2);
        assertEquals("TijguUftu", result2); // Assuming each char is shifted by 1

        // Case 3: Shift password with numbers and symbols
        String password3 = "1234!@#";
        String result3 = instance.shiftPassword(password3);
        assertEquals("2345!@#", result3); // Assuming numbers are shifted by 1, symbols unchanged
    }

    @Test
    public void testReverPassword_StatementCoverage() {
        System.out.println("ReverPassword - Statement Coverage");

        PasswordUtils instance = new PasswordUtils();

        // Case 1: Reverse empty password
        String password1 = "";
        String result1 = instance.ReverPassword(password1);
        assertEquals("", result1);

        // Case 2: Reverse a short password
        String password2 = "AB";
        String result2 = instance.ReverPassword(password2);
        assertEquals("BA", result2);

        // Case 3: Reverse a complex password
        String password3 = "abc123!";
        String result3 = instance.ReverPassword(password3);
        assertEquals("!321cba", result3);
    }


        @BeforeAll
        public static void setUpClass() {
        }

        @AfterAll
        public static void tearDownClass() {
        }

        @BeforeEach
        public void setUp() {
        }

        @AfterEach
        public void tearDown() {
        }

        /**
         * Test of shiftPassword method, of class PasswordUtils.
         */
        @Test
        public void testShiftPassword() {
            System.out.println("shiftPassword");
            String password = "";
            PasswordUtils instance = new PasswordUtils();
            String expResult = "";
            String result = instance.shiftPassword(password);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }

        /**
         * Test of ReverPassword method, of class PasswordUtils.
         */
        @Test
        public void testReverPassword() {
            System.out.println("ReverPassword");
            String password = "";
            PasswordUtils instance = new PasswordUtils();
            String expResult = "";
            String result = instance.ReverPassword(password);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }

    }
