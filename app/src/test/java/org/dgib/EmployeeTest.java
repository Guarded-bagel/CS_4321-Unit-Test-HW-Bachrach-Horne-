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

    @Test
    @DisplayName("Worked 12 hours on 4 week days")
    void testGetPay_under40_4WDW_0WEDW() {
        Employee emp = new Employee("emp",10.0);
        emp.setHours(0, 3);
        emp.setHours(1, 1);
        emp.setHours(3, 3);
        emp.setHours(4, 5);
        double expectedPay = 120.0;
        double actualPay = emp.getPay();
        assertEquals(expectedPay, actualPay);
    }

    @Test
    @DisplayName("Worked 41 hours on 4 week days")
    void testGetPay_over40_4WDW_0WEDW() {
        Employee emp = new Employee("emp",10.0);
        emp.setHours(0, 10);
        emp.setHours(1, 10);
        emp.setHours(2, 10);
        emp.setHours(3, 11);
        double expectedPay = 415.0;
        double actualPay = emp.getPay();
        assertEquals(expectedPay, actualPay);
    }

    @Test
    @DisplayName("Worked 20 hours on 4 week days, 5 hours on the weekend")
    void testGetPay_under40_4WDW_1WEDW() {
        Employee emp = new Employee("emp",10.0);
        emp.setHours(0, 5);
        emp.setHours(2, 5);
        emp.setHours(3, 5);
        emp.setHours(4, 5);
        emp.setHours(5, 5);
        double expectedPay = 300.0;
        double actualPay = emp.getPay();
        assertEquals(expectedPay, actualPay);
    }

    @Test
    @DisplayName("Worked 40 hours on 4 week days, 11 hours on the weekend")
    void testGetPay_over40_4WDW_1WEDW() {
        Employee emp = new Employee("emp",10.0);
        emp.setHours(1, 10);
        emp.setHours(2, 10);
        emp.setHours(3, 10);
        emp.setHours(4, 10);
        emp.setHours(5, 11);
        double expectedPay = 620.0;
        double actualPay = emp.getPay();
        assertEquals(expectedPay, actualPay);
    }

    @Test
    @DisplayName("Worked 39 hours on 5 week days")
    void testGetPay_under40_5WDW_0WEDW() {
        Employee emp = new Employee("emp",10.0);
        emp.setHours(0, 7);
        emp.setHours(1, 8);
        emp.setHours(2, 8);
        emp.setHours(3, 8);
        emp.setHours(4, 8);
        double expectedPay = 390.0;
        double actualPay = emp.getPay();
        assertEquals(expectedPay, actualPay);
    }
}
