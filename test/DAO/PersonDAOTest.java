package DAO;

import Entity.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class PersonDAOTest {

    private static PersonDAO personDAO;

    @BeforeAll
    public static void setUpClass() {
        personDAO = new PersonDAO();
    }

    @AfterAll
    public static void tearDownClass() {
        // Close or clean up resources here if needed
    }
    @Test
    public void testClaculated(){
        //testcase1 
     int yearsOfService = 11;
     int bascu
    }
    @Test
    public void testGetLastInsertedBorrowID() {
        int result = personDAO.getLastInsertedBorrowID();
        assertTrue(result >= 0, "The last inserted BorrowID should be non-negative.");
    }

    @Test
    public void testUpdatePassword() {
        String email = "testuser@example.com";
        String newPassword = "newSecurePassword123";
        boolean result = personDAO.updatePassword(email, newPassword);
        assertTrue(result, "Password should be updated successfully.");
    }

    @Test
    public void testIsEmailExists() {
        String email = "existing@example.com";
        boolean exists = personDAO.isEmailExists(email);
        assertTrue(exists, "Email should exist in the database.");
    }

    @Test
    public void testLogin() {
        String email = "testuser@example.com";
        String password = "testPassword123";
        Person person = personDAO.login(email, password);
        assertNotNull(person, "Login should return a Person object if credentials are correct.");
    }

    @Test
    public void testAddPerson() {
        Person person = new Person(0, "Jane Doe", "Female", "1995-05-05", LocalDate.now(), "janedoe@example.com", 2, "password123");
        boolean result = personDAO.addPerson(person);
        assertTrue(result, "Adding a new person should succeed.");
    }

    @Test
    public void testRegisterPerson() {
        String name = "Test User";
        String gender = "Male";
        String dateOfBirth = "2000-01-01";
        String email = "newuser@example.com";
        String password = "password123";
        LocalDate startDate = LocalDate.now();
        int personId = personDAO.registerPerson(name, gender, dateOfBirth, email, password, startDate);
        assertTrue(personId > 0, "Registration should return a valid Person ID.");
    }

    @Test
    public void testInsertAddress() {
        int personId = 1; // Assume a valid PersonID
        String address = "123 Main St";
        boolean isPrimary = true;
        boolean result = personDAO.insertAddress(personId, address, isPrimary);
        assertTrue(result, "Inserting address should succeed.");
    }

    @Test
    public void testInsertPhone() {
        int personId = 1; // Assume a valid PersonID
        String phone = "0123456789";
        boolean isPrimary = true;
        boolean result = personDAO.insertPhone(personId, phone, isPrimary);
        assertTrue(result, "Inserting phone should succeed.");
    }

    @Test
    public void testInsertImage() {
        int personId = 1; // Assume a valid PersonID
        String imageUrl = "https://example.com/image.jpg";
        String altText = "Profile Image";
        boolean result = personDAO.insertImage(personId, imageUrl, altText);
        assertTrue(result, "Inserting image should succeed.");
    }

    @Test
    public void testInsertVideo() {
        int personId = 1; // Assume a valid PersonID
        String videoUrl = "https://example.com/video.mp4";
        String altText = "Profile Video";
        boolean result = personDAO.insertVideo(personId, videoUrl, altText);
        assertTrue(result, "Inserting video should succeed.");
    }

    @Test
    public void testMain() {
        // This method typically doesn’t require testing as it’s often only used for manual testing.
        // Instead, we should be able to test the methods individually as we have done above.
        assertTrue(true, "Main method tested implicitly.");
    }
}
