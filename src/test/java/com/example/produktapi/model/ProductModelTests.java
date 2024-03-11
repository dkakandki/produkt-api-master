package com.example.produktapi.model;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ProductModelTests {
    // Samuel
    @Test
    @DisplayName("Product title get-method")
    void getTitleTest() {
        Product product = new Product("Test Title", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("Test Title", product.getTitle());
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with correct value")
    void setTitleCorrectValue(){
        Product product = new Product("Test Title", 99.99, "Test Category", "This is a test description","image.jpg");
        product.setTitle("New value");
        Assertions.assertEquals("New value", product.getTitle());
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with extra white spaces")
    void setTitleWithExtraWhiteSpaces(){
        Product product = new Product("  Test Title   ", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("  Test Title   ", product.getTitle()); // Method should be updated to remove extra white spaces
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with special characters")
    void setTitleWithSpecialCharacters(){
        Product product = new Product("!#¤%=?@£$€", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("!#¤%=?@£$€", product.getTitle()); // Method should be updated to only allow certain characters
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with empty string")
    void setTitleWithEmptyString(){
        Product product = new Product("", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("", product.getTitle()); // Method should be updated to not allow empty string as title
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with too long string")
    void setTitleWithLongString(){
        Product product = new Product("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", 99.99, "Test Category", "This is a test description","image.jpg");
        Assertions.assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", product.getTitle()); // Method should be updated to only allow a set string length
    }

    // Samuel
    @Test
    @DisplayName("Product title set-method with null")
    void setTitleWithNull() {
        Product product = new Product(null, 99.99, "Test Category", "This is a test description", "image.jpg");
        Assertions.assertNull(product.getTitle()); // Method should be updated to not allow title as null
    }

    @Test //Mia:
    public void testGetPrice_with_correct_value() {
        // Skapa en produkt med ett känt pris
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        assertEquals(19.99, product.getPrice(), 0.01);// Anropa getPrice och verifiera att det returnerar det förväntade priset, använder en tolerans (delta) för att hantera flyttalsprecision
    }

    @Test //Mia
    public void testSetPrice_with_correct_value() {
        Product product = new Product();// Skapa en produkt
        product.setPrice(29.99);  // Anropa setPrice med ett nytt pris
        assertEquals(29.99, product.getPrice(), 0.01); // Verifiera att getPrice nu returnerar det uppdaterade priset
    }

    @Test
    public void testSetPrice_with_negative_value() { //Mia
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        product.setPrice(-5.0);// Försök sätta ett negativt pris. jag borde inte kunna sätta ett neg pris, o därför borde ursprungspriset vara kvar
        assertEquals(19.99, product.getPrice(), 0.01);// Verifiera att getPrice returnerar det förväntade värdet (bör fortfarande vara det tidigare priset)
    }

    @Test
    public void testSetPrice_with_supersmall_value() { //Mia
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        product.setPrice(0.01);// Försök sätta ett jättelitet pris. vill ju eg inte kunna göra det
        assertEquals(19.99, product.getPrice(), 0.01); // Verifiera att getPrice returnerar det förväntade värdet (bör fortfarande vara det tidigare priset)
    }

    @Test
    public void testSetPrice_with_superbig_value() { //Mia.
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        product.setPrice(100000.0); // Försök sätta ett jättehögt pris. vill ju eg inte kunna göra det
        assertEquals(19.99, product.getPrice(), 0.01);  // Verifiera att getPrice returnerar det förväntade värdet (bör fortfarande vara det tidigare priset)
    }

    @Test
    public void testSetPrice_with_zero_value() { //Mia
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");
        product.setPrice(0.0); // Försök sätta priset till ogiltigt värde (t.ex. noll)
        assertEquals(19.99, product.getPrice(), 0.01);   // Verifiera att getPrice fortfarande returnerar det tidigare priset (inget ändrat pris)
    }

    @Test
    public void testConstructor_with_correct_values() { //Mia

        // Skapa produkt med konstruktorn
        Product product = new Product("Product Title", 19.99, "Test Category", "Test Description", "test_image.jpg");

        // Verifiera att de returnerade värdena matchar de förväntade värdena. använder sig av attributen i klassen
        assertEquals("Product Title", product.getTitle());
        assertEquals(19.99, product.getPrice(), 0.01);
        assertEquals("Test Category", product.getCategory());
        assertEquals("Test Description", product.getDescription());
        assertEquals("test_image.jpg", product.getImage());
    }

    // Adding a test method just for testing imports and packages
    @Test
    @DisplayName("Testing")
    void testMethod(){
        Assertions.assertTrue(true);
    }
}
