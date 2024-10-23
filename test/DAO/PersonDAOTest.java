package DAO;

import Entity.Person;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonDAOTest {

    // Initialize the PersonDAO to be used in the tests
    PersonDAO personDAO = new PersonDAO();

    @Test
    public void testUpdatePassword() {
        String email = "nam@gmail.com";
        String newPassword = "123";

        boolean result = personDAO.updatePassword(email, newPassword);
        assertTrue(result); // Ensure that the password update was successful
    }

    @Test
    public void testIsEmailExists() {
        String email = "nam@gmail.com";

        boolean result = personDAO.isEmailExists(email);
        assertTrue(result); // Ensure the email exists
    }

    @Test
    public void testLogin() {
        String email = "user";
        String password = "234";
        
        Person person = personDAO.login(email, password);
        assertNotNull(person); // Ensure a person object is returned on successful login
        assertEquals(email, person.getEmail()); // Check if the returned email matches
    }
  
    

    @Test
    public void testAddPerson() {
        // Create a new Person object
        Person newPerson = new Person(10, "Test Name", "Male", "1990-01-01", 
            LocalDate.now(), "123 Test Street", "newemail@gmail.com", "1234567890", 2, "password123");

        boolean result = personDAO.addPerson(newPerson);
        assertTrue(result); // Ensure the person was successfully added
    }

   
  
}
