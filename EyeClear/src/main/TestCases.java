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

    // Test cases for addPrescription
    @Test
    public void testAddPrescription_ValidData() {
        // Test with valid data
        boolean result = prescription.addPrescription(
                "Johnathan", // First name (valid: 4-15 characters)
                "Anderson",  // Last name (valid: 4-15 characters)
                "1234 Elm Street, Springfield, 12345 USA", // Address (valid: >20 characters)
                2.50,  // Sphere (valid: between -20.00 and +20.00)
                -1.50, // Cylinder (valid: between -4.00 and +4.00)
                90,    // Axis (valid: between 0 and 180)
                "22/10/23", // Date of exam (valid format: DD/MM/YY)
                "Dr. Nicholas" // Optometrist name (valid: 8-25 characters)
        );
        assertTrue(result); // Expecting true because all data is valid
    }

    @Test
    public void testAddPrescription_InvalidFirstName() {
        // Test with invalid first name (too short)
        boolean result = prescription.addPrescription(
                "Jon",  // Invalid first name (less than 4 characters)
                "Anderson",  
                "1234 Elm Street, Springfield, 12345 USA",
                2.50,
                -1.50,
                90,
                "22/10/23",
                "Dr. Nicholas"
        );
        assertFalse(result); // Expecting false due to invalid first name
    }

    @Test
    public void testAddPrescription_InvalidLastName() {
        // Test with invalid last name (too long)
        boolean result = prescription.addPrescription(
                "Johnathan",
                "Anderson-Williams-Jones-Benjamin", // Invalid last name (>15 characters)
                "1234 Elm Street, Springfield, 12345 USA",
                2.50,
                -1.50,
                90,
                "22/10/23",
                "Dr. Nicholas"
        );
        assertFalse(result); // Expecting false due to invalid last name
    }

    @Test
    public void testAddPrescription_InvalidAddress() {
        // Test with invalid address (too short)
        boolean result = prescription.addPrescription(
                "Johnathan",
                "Anderson",
                "Short Addr", // Invalid address (less than 20 characters)
                2.50,
                -1.50,
                90,
                "22/10/23",
                "Dr. Nicholas"
        );
        assertFalse(result); // Expecting false due to invalid address
    }

    @Test
    public void testAddPrescription_InvalidSphere() {
        // Test with invalid sphere value
        boolean result = prescription.addPrescription(
                "Johnathan",
                "Anderson",
                "1234 Elm Street, Springfield, 12345 USA",
                25.00, // Invalid sphere (>20.00)
                -1.50,
                90,
                "22/10/23",
                "Dr. Nicholas"
        );
        assertFalse(result); // Expecting false due to invalid sphere value
    }

    @Test
    public void testAddPrescription_InvalidCylinder() {
        // Test with invalid cylinder value
        boolean result = prescription.addPrescription(
                "Johnathan",
                "Anderson",
                "1234 Elm Street, Springfield, 12345 USA",
                2.50,
                -5.00, // Invalid cylinder (<-4.00)
                90,
                "22/10/23",
                "Dr. Nicholas"
        );
        assertFalse(result); // Expecting false due to invalid cylinder value
    }

    @Test
    public void testAddPrescription_InvalidAxis() {
        // Test with invalid axis value
        boolean result = prescription.addPrescription(
                "Johnathan",
                "Anderson",
                "1234 Elm Street, Springfield, 12345 USA",
                2.50,
                -1.50,
                200, // Invalid axis (>180)
                "22/10/23",
                "Dr. Nicholas"
        );
        assertFalse(result); // Expecting false due to invalid axis value
    }

    @Test
    public void testAddPrescription_InvalidDateFormat() {
        // Test with invalid exam date format
        boolean result = prescription.addPrescription(
                "Johnathan",
                "Anderson",
                "1234 Elm Street, Springfield, 12345 USA",
                2.50,
                -1.50,
                90,
                "2023-10-22", // Invalid date format
                "Dr. Nicholas"
        );
        assertFalse(result); // Expecting false due to invalid date format
    }


    // Test cases for addRemark
    @Test
    public void testAddRemark_ValidData() {
        // Test with valid remark
        boolean result = prescription.addRemark(
                "This is a valid remark by client.", // Valid remark: 6 words, first word capitalized
                "client" // Valid category
        );
        assertTrue(result); // Expecting true since it's valid
    }

    @Test
    public void testAddRemark_InvalidRemarkText() {
        // Test with too few words in remark
        boolean result = prescription.addRemark(
                "Too short", // Invalid remark: less than 6 words
                "client"
        );
        assertFalse(result); // Expecting false due to too few words
    }

    @Test
    public void testAddRemark_InvalidFirstWordCapitalization() {
        // Test with first word not capitalized
        boolean result = prescription.addRemark(
                "this is a valid remark by client.", // First word not capitalized
                "client"
        );
        assertFalse(result); // Expecting false due to capitalization
    }

    @Test
    public void testAddRemark_InvalidCategory() {
        // Test with invalid category
        boolean result = prescription.addRemark(
                "This is a valid remark by client.",
                "doctor" // Invalid category (not "client" or "optometrist")
        );
        assertFalse(result); // Expecting false due to invalid category
    }

}
