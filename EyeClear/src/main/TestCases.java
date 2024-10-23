package main;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestCases {

    private Prescription prescription;

    @Before
    public void setUp() throws Exception {
        // Initialize Prescription instance before each test
        prescription = new Prescription();
    }

    // Test cases for addPrescription (with two sets of data per test case)

    @Test
    public void testAddPrescription_ValidData() {
        // Test Data 1: Valid data
        boolean result1 = prescription.addPrescription(
                "Johnathan", // First name (valid: 4-15 characters)
                "Anderson",  // Last name (valid: 4-15 characters)
                "1234 Elm Street, Springfield, 12345 USA", // Address (valid: >20 characters)
                2.50,  // Sphere (valid: between -20.00 and +20.00)
                -1.50, // Cylinder (valid: between -4.00 and +4.00)
                90,    // Axis (valid: between 0 and 180)
                "22/10/23", // Date of exam (valid format: DD/MM/YY)
                "Dr. Nicholas" // Optometrist name (valid: 8-25 characters)
        );
        assertTrue(result1); // Expecting true

        // Test Data 2: Another valid data
        boolean result2 = prescription.addPrescription(
                "Sarah", 
                "Conner", 
                "5678 Oak Avenue, Metropolis, 67890 USA", 
                -2.00,  
                1.00,   
                75,     
                "01/05/24", 
                "Dr. James"  
        );
        assertTrue(result2); // Expecting true
    }

    @Test
    public void testAddPrescription_InvalidFirstName() {
        // Test Data 1: Invalid first name (too short)
        boolean result1 = prescription.addPrescription(
                "Jon",  
                "Anderson",  
                "1234 Elm Street, Springfield, 12345 USA",
                2.50,
                -1.50,
                90,
                "22/10/23",
                "Dr. Nicholas"
        );
        assertFalse(result1); // Expecting false

        // Test Data 2: Another invalid first name
        boolean result2 = prescription.addPrescription(
                "J",  
                "Smith",  
                "5678 Oak Avenue, Metropolis, 67890 USA",
                1.75,
                -0.75,
                60,
                "14/03/22",
                "Dr. Gregory"
        );
        assertFalse(result2); // Expecting false
    }

    @Test
    public void testAddPrescription_InvalidLastName() {
        // Test Data 1: Invalid last name (too long)
        boolean result1 = prescription.addPrescription(
                "Johnathan",
                "Anderson-Williams-Jones-Benjamin", // Invalid last name (>15 characters)
                "1234 Elm Street, Springfield, 12345 USA",
                2.50,
                -1.50,
                90,
                "22/10/23",
                "Dr. Nicholas"
        );
        assertFalse(result1); // Expecting false

        // Test Data 2: Another invalid last name (too long)
        boolean result2 = prescription.addPrescription(
                "Michael",
                "Jackson-12345678901234", 
                "8765 Pine Road, Gotham City, 54321 USA", 
                3.00,
                1.25,
                120,
                "12/04/24",
                "Dr. Watson"
        );
        assertFalse(result2); // Expecting false
    }

    @Test
    public void testAddPrescription_InvalidAddress() {
        // Test Data 1: Invalid address (too short)
        boolean result1 = prescription.addPrescription(
                "Johnathan",
                "Anderson",
                "Short Addr", // Invalid address (less than 20 characters)
                2.50,
                -1.50,
                90,
                "22/10/23",
                "Dr. Nicholas"
        );
        assertFalse(result1); // Expecting false

        // Test Data 2: Another invalid address
        boolean result2 = prescription.addPrescription(
                "Lucy",
                "Brown",
                "Too Short Addr", // Invalid address
                2.75,
                -2.00,
                70,
                "15/08/24",
                "Dr. Reed"
        );
        assertFalse(result2); // Expecting false
    }

    @Test
    public void testAddPrescription_InvalidSphere() {
        // Test Data 1: Invalid sphere value
        boolean result1 = prescription.addPrescription(
                "Johnathan",
                "Anderson",
                "1234 Elm Street, Springfield, 12345 USA",
                25.00, // Invalid sphere (>20.00)
                -1.50,
                90,
                "22/10/23",
                "Dr. Nicholas"
        );
        assertFalse(result1); // Expecting false

        // Test Data 2: Another invalid sphere value
        boolean result2 = prescription.addPrescription(
                "Emily",
                "Clarke",
                "1357 Maple Blvd, Smallville, 67890 USA",
                -25.50, // Invalid sphere (< -20.00)
                0.50,
                80,
                "10/02/23",
                "Dr. Snow"
        );
        assertFalse(result2); // Expecting false
    }

    @Test
    public void testAddPrescription_InvalidDateFormat() {
        // Test Data 1: Invalid exam date format
        boolean result1 = prescription.addPrescription(
                "Johnathan",
                "Anderson",
                "1234 Elm Street, Springfield, 12345 USA",
                2.50,
                -1.50,
                90,
                "2023-10-22", // Invalid date format
                "Dr. Nicholas"
        );
        assertFalse(result1); // Expecting false

        // Test Data 2: Another invalid date format
        boolean result2 = prescription.addPrescription(
                "Sophia",
                "Williams",
                "9876 Birch Lane, Gotham, 54321 USA",
                0.00,
                -2.50,
                180,
                "13/45/24", // Invalid date format
                "Dr. Harris"
        );
        assertFalse(result2); // Expecting false
    }

    // Test cases for addRemark (with two sets of data per test case)

    @Test
    public void testAddRemark_ValidData() {
        // Test Data 1: Valid remark
        boolean result1 = prescription.addRemark(
                "This is a valid remark text by client.", // 7 words, first word capitalized
                "client" // Valid category
        );
        assertTrue(result1); // Expecting true

        // Test Data 2: Another valid remark
        boolean result2 = prescription.addRemark(
                "Another valid comment by the optometrist.", // 7 words, first word capitalized
                "optometrist" // Valid category
        );
        assertTrue(result2); // Expecting true
    }


    @Test
    public void testAddRemark_InvalidRemarkText() {
        // Test Data 1: Too few words in remark
        boolean result1 = prescription.addRemark(
                "Too short", // Invalid remark: less than 6 words
                "client"
        );
        assertFalse(result1); // Expecting false

        // Test Data 2: Another remark with too few words
        boolean result2 = prescription.addRemark(
                "Not enough", // Invalid remark
                "optometrist"
        );
        assertFalse(result2); // Expecting false
    }

    @Test
    public void testAddRemark_InvalidFirstWordCapitalization() {
        // Test Data 1: First word not capitalized
        boolean result1 = prescription.addRemark(
                "this is a valid remark by client.", // First word not capitalized
                "client"
        );
        assertFalse(result1); // Expecting false

        // Test Data 2: Another remark with improper capitalization
        boolean result2 = prescription.addRemark(
                "remark should start with capital.", 
                "optometrist"
        );
        assertFalse(result2); // Expecting false
    }

    @Test
    public void testAddRemark_InvalidCategory() {
        // Test Data 1: Invalid category
        boolean result1 = prescription.addRemark(
                "This is a valid remark by client.",
                "doctor" // Invalid category (not "client" or "optometrist")
        );
        assertFalse(result1); // Expecting false

        // Test Data 2: Another invalid category
        boolean result2 = prescription.addRemark(
                "This is another valid remark.",
                "assistant" // Invalid category
        );
        assertFalse(result2); // Expecting false
    }
    @Test
    public void testAddRemark_ExceedRemarkLimit() {
        // Adding two valid remarks first
        prescription.addRemark("This is the first valid remark.", "client");
        prescription.addRemark("This is the second valid remark.", "optometrist");

        // Test Data: Attempt to add a third remark
        boolean result = prescription.addRemark(
                "This should fail because we have already added two remarks.", 
                "client"
        );
        assertFalse(result); // Expecting false because the limit of 2 remarks is reached
    }
    
    @Test
    public void testAddRemark_InvalidRemarkText_TooManyWords() {
        // Test Data 1: Too many words in remark (exceeds expected limit)
        boolean result1 = prescription.addRemark(
                "This remark contains an excessive number of words and should not be valid as it exceeds the expected length limit set in the system.", 
                "client"
        );
        assertFalse(result1); // Expecting false

        // Test Data 2: Another remark with excessive length
        boolean result2 = prescription.addRemark(
                "This is another excessively long remark that should not be accepted because it clearly goes beyond the permissible limits set for remarks in the application.", 
                "optometrist"
        );
        assertFalse(result2); // Expecting false
    }

    @Test
    public void testAddRemark_EmptyRemarkText() {
        // Test Data 1: Empty remark text
        boolean result1 = prescription.addRemark(
                "", // Invalid remark: empty
                "client"
        );
        assertFalse(result1); // Expecting false

        // Test Data 2: Another empty remark
        boolean result2 = prescription.addRemark(
                "", // Invalid remark: empty
                "optometrist"
        );
        assertFalse(result2); // Expecting false
    }

    
}
