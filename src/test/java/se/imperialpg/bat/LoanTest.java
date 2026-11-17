package se.imperialpg.bat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.imperialpg.bat.models.Book;
import se.imperialpg.bat.models.Customer;
import se.imperialpg.bat.models.Loan;
import se.imperialpg.bat.utilities.GenderType;
import se.imperialpg.bat.utilities.LoanStatus;

import java.time.LocalDate;

public class LoanTest {


	private Book book;
	private Customer customer;
	private Loan loan;
	public LoanTest(){
		book = new Book(1,"book","author","1111111111111", "branch",100);
		customer = new Customer("Title", "FirstName", "LastName", "adress", "00-0000 0000", "email@example.com", 1, GenderType.FEMALE);
		loan = new Loan(1, customer, book);
	}


    @Test
    public void testDueDate() {
		assertEquals(LocalDate.now().plusDays(14),loan.getDueDate());
    }

    //VG
    @Test
    void newLoanShouldBeCurrent() {
		assertEquals(LoanStatus.CURRENT,loan.getStatus());
    }

    //VG
    @Test
    void endLoanShouldBeHistoric() {
		loan.endLoan();
		assertEquals(LoanStatus.HISTORIC, loan.getStatus());
    }
}