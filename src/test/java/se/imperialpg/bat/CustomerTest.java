package se.imperialpg.bat;

import org.junit.jupiter.api.Test;
import se.imperialpg.bat.models.Customer;
import se.imperialpg.bat.utilities.GenderType;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    //G
    @Test
    void testGetGender() {
        Customer cfemale = new Customer("Title","FirstName", "LastName","adress","00-0000 0000","email@example.com",1, GenderType.FEMALE);
        Customer cmale = new Customer("Title","FirstName", "LastName","adress","00-0000 0000","email@example.com",1, GenderType.MALE);
        assertSame(GenderType.MALE,cmale.getGender());
        assertSame(GenderType.FEMALE,cfemale.getGender());
    }

    //G
    @Test
    void testGetMailingName() {
        Customer c = new Customer("Title","FirstName", "LastName","adress","00-0000 0000","email@example.com",1, GenderType.FEMALE);
        assertEquals("Title F LastName",c.getMailingName());
    }


}
