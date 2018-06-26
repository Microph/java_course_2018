package testException;

import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptionDemo.IllegalDivisionException;
import exceptionDemo.ExceptionDemoMain;

public class TestException {
    @Test (expected = IllegalDivisionException.class)
    public void test1() {
        ExceptionDemoMain dbTest = new ExceptionDemoMain();
        dbTest.testDiv(1, 0);
    }
    
    @Test
    public void test2() {
        ExceptionDemoMain dbTest = new ExceptionDemoMain();
        try {
            dbTest.testDiv(1, 0);
            fail("should not be here!");
        } catch(IllegalDivisionException e) {
            
        }
        
    }
    
    @Rule
    public ExpectedException expected = ExpectedException.none();
    
    @Test
    public void test3() {
        ExceptionDemoMain dbTest = new ExceptionDemoMain();
        expected.expect(IllegalDivisionException.class);
        dbTest.testDiv(1, 0);
    }
}
