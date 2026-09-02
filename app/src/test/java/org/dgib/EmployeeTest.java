package org.dgib;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
	@Test
    @DisplayName("Worked 0 hours")
    void testGetPay_under40_0WDW_0WEDW() {
        Employee emp = new Employee("emp",10.0);
        double expectedPay = 0.0;
        double actualPay = emp.getPay();
        assertEquals(expectedPay, actualPay);
    }

    @Test
    @DisplayName("Worked 5 hours on saturday")
    void testGetPay_under40_0WDW_1WEDW() {
        Employee emp = new Employee("emp",10.0);
        emp.setHours(5, 5); //Note that this uses array logic. 5 and 6 are actually days 6 and 7 (Saturday and Sunday)
        double expectedPay = 100.0;
        double actualPay = emp.getPay();
        assertEquals(expectedPay, actualPay);
    }
}
