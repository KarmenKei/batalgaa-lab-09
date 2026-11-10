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


    // Section B: Branch coverage tests

    @Test
    void testLetterGradeF() {
        assertEquals("F", calculator.letterGrade(50));
    }

    @Test
    void testGpaDefaultSwitchCase() {
        assertEquals(0.0, calculator.gpa(new double[]{50}), 0.001);
    }

    @Test
    void testScholarshipViolation() {
        assertEquals(0, calculator.scholarship(4.0, 20, true));
    }

    @Test
    void testFullScholarshipCreditsBelow15() {
        assertEquals(70, calculator.scholarship(3.9, 14, false));
    }

    @Test
    void testPartialScholarshipGpaBelow34() {
        assertEquals(50, calculator.scholarship(3.3, 15, false));
    }

    @Test
    void testPartialScholarshipBelow30() {
        assertEquals(0, calculator.scholarship(2.9, 15, false));
    }

    @Test
    void testPartialScholarshipCreditsBelow12() {
        assertEquals(50, calculator.scholarship(3.5, 11, false));
    }

    @Test
    void testInvalidGpaBelowZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(-0.1, 15, false));
    }

    @Test
    void testInvalidGpaAboveFour() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(4.1, 15, false));
    }

    @Test
    void testInvalidCreditsBelowZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(3.5, -1, false));
    }

        // Additional Section B: Missing branch coverage

    @Test
    void testLetterGradeD() {
        assertEquals("D", calculator.letterGrade(65));
    }

    @Test
    void testLetterGradeBelowZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(-1));
    }

    @Test
    void testLetterGradeAbove100() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(101));
    }

    @Test
    void testGpaNullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(null));
    }

    @Test
    void testGpaEmptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(new double[]{}));
    }

        @Test
    void testGpaCGrade() {
        assertEquals(2.0, calculator.gpa(new double[]{75}), 0.001);
    }

    @Test
    void testGpaDGrade() {
        assertEquals(1.0, calculator.gpa(new double[]{65}), 0.001);
    }

        // Section C: GPA loop boundary tests

    @Test
    void testGpaSingleElement() {
        assertEquals(4.0, calculator.gpa(new double[]{95}), 0.001);
    }

    @Test
    void testGpaMultipleElements() {
        assertEquals(2.5,
                calculator.gpa(new double[]{95, 85, 75, 65}), 0.001);
    }
}
