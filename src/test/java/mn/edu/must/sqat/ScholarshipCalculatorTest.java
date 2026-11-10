package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calculator = new ScholarshipCalculator();

    // Section A: Happy-path tests

    @Test
    void testLetterGradeA() {
        assertEquals("A", calculator.letterGrade(95));
    }

    @Test
    void testLetterGradeB() {
        assertEquals("B", calculator.letterGrade(85));
    }

    @Test
    void testLetterGradeC() {
        assertEquals("C", calculator.letterGrade(75));
    }

    @Test
    void testGpaAverage() {
        assertEquals(3.5, calculator.gpa(new double[]{95, 85}), 0.001);
    }

    @Test
    void testFullScholarship() {
        assertEquals(100, calculator.scholarship(3.9, 16, false));
    }
}
