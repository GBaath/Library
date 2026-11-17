package se.imperialpg.bat;

import org.junit.jupiter.api.Test;
import se.imperialpg.bat.models.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {
		Book b1 = new Book(1,"book","author","1111111111111", "branch",100);
		Book b2 = new Book(1,"book","author","1111111111111", "branch",100);
		assertEquals(b1,b2);
	}

	//G
	@Test
	public void test2NonEqualBooks() {
		Book b1 = new Book(1,"book","author","1111111111111", "branch",100);
		Book b2 = new Book(2,"book2","auther","1111111111", "branh",10);
		assertNotEquals(b1,b2);
	}

	//G
	@Test
	void booksWithSameIdAndTitleShouldBeEqual() {
		Book b1 = new Book(1,"book","author","1111111111", "branch",10);
		Book b2 = new Book(1,"book","auther","1111111111111", "bran",100);
		assertEquals(b1,b2);
	}

	//G
	@Test
	void booksWithDifferentIdsShouldNotBeEqual() {
		Book b1 = new Book(1,"book","author","1111111111111", "branch",100);
		Book b2 = new Book(2,"book","author","1111111111111", "branch",100);
		assertNotEquals(b1,b2);
	}


	//G
	@Test
	void booksWithSameIdButDifferentTitlesShouldNotBeEqual() {
		Book b1 = new Book(1,"book","author","1111111111111", "branch",100);
		Book b2 = new Book(1,"book2","author","1111111111111", "branch",100);
		assertNotEquals(b1,b2);
	}
}
