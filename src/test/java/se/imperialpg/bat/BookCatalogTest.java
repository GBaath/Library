package se.imperialpg.bat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import se.imperialpg.bat.models.Book;
import se.imperialpg.bat.models.BookCatalog;
import se.imperialpg.bat.models.BookNotFoundException;

import java.util.Arrays;


public class BookCatalogTest {

    private BookCatalog bc;
    private Book book1;

    public BookCatalogTest() {
        bc = new BookCatalog();
        book1 = new Book(1, "Learning Java", "", "", "", 0);
        bc.addBook(book1);
    }

    //G
    @Test
    public void testAddABook() {
        assertTrue(Arrays.stream(bc.getBookArray()).toList().contains(book1));
    }

    //G
    @Test
    public void testFindBook() {
		try{
        	assertEquals(book1, bc.findBook("Learning Java"));
		}
		catch(BookNotFoundException e){
			fail();
		}
    }

    //G
    @Test
    public void testFindBookIgnoringCase() {
		try{
			assertEquals(book1, bc.findBook(book1.getTitle().toUpperCase()));
		}
		catch(BookNotFoundException e){
			fail();
		}
    }

    //G
    @Test
    public void testFindBookWithExtraSpaces() {
		try{
			assertEquals(book1, bc.findBook("    "+ book1.getTitle().toUpperCase() +"    "));
		}
		catch(BookNotFoundException e){
			fail();
		}
    }

    //G
    @Test
    public void shouldThrowExceptionWhenCatalogIsEmpty() {
		assertThrows(BookNotFoundException.class, () -> bc.findBook("book"));
    }

    //VG
    // This test should throw BookNotFoundException in order to pass.
    @Test
    public void testFindBookThatDoesntExist() throws BookNotFoundException {
		try{
			bc.findBook("");
			fail(); //should not exec this
		}
		catch(BookNotFoundException e){
			// expected
		}
    }

    //VG
    //Skriv ett parameteriserat test som verifierar att metoden findBook(String title)
    // hittar samma bok oavsett hur titeln skrivs med stora och små bokstäver.
    //Du kan testa med
    // "Learning Java"
    //"learning java"
    //"LEARNING JAVA"
	@ParameterizedTest
	@ValueSource(strings = {"Learning Java", "learning java", "LEARNING JAVA"})
    public void shouldFindBookRegardlessOfCase(String title) throws BookNotFoundException {
		try{
			assertEquals(book1, bc.findBook(title));
		}
		catch(BookNotFoundException e){
			fail();
		}
    }

}
