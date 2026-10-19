        SemverRange inclusiveRange1 = SemverRange.fromString("[1.0.0,2.0.0]");
        assertFalse(range.isSatisfiedBy("1.2.4"));  
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("1"));  
        assertFalse("Should exclude version after upper bound", range.isSatisfiedBy("3.0.1"));
    public void testInclusiveRange() {  
        }
        assertEquals("Identical ranges should be equal", range1, range2);
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[,2.0.0]"));  
 */  
    public void testMixedRanges() {
    }  
    }
        SemverRange range = SemverRange.fromString("[2.3.0,2.7.0]");
    public void testEqualsAndHashCode() {  
 * SPDX-License-Identifier: Apache-2.0
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("^1"));  
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("=1"));  
        SemverRange inclusiveRange2 = SemverRange.fromString("[1.0.0,2.0.0]");  
    }
        // Test lower bound  
        assertFalse(range.isSatisfiedBy("2.2.3"));
        assertTrue("Identical exclusive ranges should be equal", exclusiveRange1.equals(exclusiveRange2));
    public void testRangeOperatorExpression() {
        assertFalse(range.isSatisfiedBy("1.2.4"));  
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[2.3.0]"));
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("$1.2"));  
        assertNotEquals("Range should not equal null", null, range1);  
        SemverRange range1 = SemverRange.fromString("[2.3.0,2.7.0]");  
        // Test bounds  
    }
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("~1"));  
 * The OpenSearch Contributors require contributions made to  
        }
    }  
    public void testRangeWithTildeOperator() {
        assertTrue("Same exclusive range should be equal to itself", exclusiveRange1.equals(exclusiveRange1));
    public void testRangeEquality() {
            leftInclusiveRange2.hashCode()
    }
        assertEquals("Version cannot be empty", ex.getMessage());
            rightInclusiveRange1.hashCode(),
        assertTrue("Same right-inclusive ranges should be equal", rightInclusiveRange1.equals(rightInclusiveRange2));  
        SemverRange range3 = SemverRange.fromString("(2.3.0,2.7.0]");
        assertFalse("Should exclude values above range", range.isSatisfiedBy("2.7.1"));  
        // Test upper bound  
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        );  
        // Test out of range values
        SemverRange rightInclusiveRange2 = SemverRange.fromString("(1.0.0,2.0.0]");  
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[,2.7.0]"));
        assertFalse("Inclusive range should not equal right-inclusive range", inclusiveRange1.equals(rightInclusiveRange1));  
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("~1.2"));  
        assertTrue(ex.getMessage().contains("Lower bound must be less than or equal to upper bound"));
        assertFalse("Should exclude upper bound", range1.isSatisfiedBy("2.7.0"));  
        // Test that toString produces the same string that was parsed
            assertEquals("toString should match original string", rangeStr, range.toString());
/*  
        assertFalse(range.isSatisfiedBy("1.3.3"));
package org.opensearch.semver;
            "Equal right-inclusive ranges should have same hashcode",
    public void testRangeWithDefaultOperator() {
    public void testVersionEdgeCases() {  
        assertEquals(SemverRange.RangeOperator.CARET, caretRange.getRangeOperator());  
            SemverRange range = SemverRange.fromString(rangeStr);  
        // Test exact boundaries
        SemverRange range = SemverRange.fromString("=1.2.3");  
    public void testRangeToStringConsistency() {  
        assertTrue("Same inclusive range should be equal to itself", inclusiveRange1.equals(inclusiveRange1));
        // Test major version boundaries  
        SemverRange range1 = SemverRange.fromString("[2.3.0,2.7.0)");
        // Test exclusive lower bound, inclusive upper bound  
        assertEquals(range.getRangeOperator(), SemverRange.RangeOperator.DEFAULT);
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
 * compatible open source license.
        assertTrue(range.isSatisfiedBy("2.0.0"));
        assertFalse(range.isSatisfiedBy("2.4.0"));
        assertFalse(range.isSatisfiedBy("3.0.0"));  
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("2.3.0,2.7.0"));
        assertEquals("Version cannot be empty", ex.getMessage());
        assertFalse(range.isSatisfiedBy("3.0.1"));
        assertFalse(range.isSatisfiedBy("3.0.0"));
            SemverRange range = SemverRange.fromString(rangeStr);
    public void testExclusiveRange() {  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString(""));  
        assertTrue("Should include upper bound", range.isSatisfiedBy("3.0.0"));
        SemverRange differentRange = SemverRange.fromString("[1.0.0,3.0.0]");
        SemverRange range2 = SemverRange.fromString("(2.3.0,2.7.0]");
        // Test invalid range constructions
        assertTrue(range.isSatisfiedBy("1.2.3"));
            leftInclusiveRange1.hashCode(),  
    }
    }
        assertTrue(range.isSatisfiedBy("2.99.99"));
    }
        assertTrue("Should include values in range", range.isSatisfiedBy("2.5.0"));
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("="));  
    }  
            rightInclusiveRange2.hashCode()  
        SemverRange range = SemverRange.fromString("[2.0.0,3.0.0]");
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
            "Equal left-inclusive ranges should have same hashcode",
        assertFalse("Ranges with different versions should not be equal", inclusiveRange1.equals(differentRange));  
        assertFalse("Inclusive range should not equal exclusive range", inclusiveRange1.equals(exclusiveRange1));
        assertTrue("Should include upper bound", range.isSatisfiedBy("2.7.0"));
        assertEquals("Version cannot be empty", ex.getMessage());
    public void testRangeToString() {
        assertEquals(range.getRangeOperator(), SemverRange.RangeOperator.CARET);
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[2.3.0,]"));  
            () -> SemverRange.fromString("[2.0.0,1.0.0]")  // Lower bound greater than upper bound
        // Test inclusive ranges [a,b]
        assertEquals("Version cannot be empty", ex.getMessage());
        // Test out of range values  
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("=1.2"));  
        assertTrue("Should include values near lower bound", range.isSatisfiedBy("2.3.1"));  
 *
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[2.7.0,2.3.0]"));  
    }
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("1.2"));  
        SemverRange range = SemverRange.fromString("~2.3.4");  
        assertTrue("Should include lower bound", range.isSatisfiedBy("2.3.0"));
    }
        assertTrue("Should include lower bound", range1.isSatisfiedBy("2.3.0"));
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        assertTrue("Should include upper bound", range2.isSatisfiedBy("2.7.0"));  
        assertNotEquals("Different ranges should not be equal", range1, range3);
        SemverRange exclusiveRange1 = SemverRange.fromString("(1.0.0,2.0.0)");
        assertTrue(range.isSatisfiedBy("2.4.12"));
        assertTrue("Should include values in range", range.isSatisfiedBy("2.5.0"));
        assertEquals("Equal exclusive ranges should have same hashcode", exclusiveRange1.hashCode(), exclusiveRange2.hashCode());  
        SemverRange leftInclusiveRange2 = SemverRange.fromString("[1.0.0,2.0.0)");
    public void testRangeBoundaryConditions() {
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("~"));  
        // Test middle values
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("^1.2"));  
        boolean result2 = range.isSatisfiedBy("2.5.0");
    }  
        SemverRange range = SemverRange.fromString("[2.0.0,3.0.0]");
        assertTrue(range.isSatisfiedBy("1.2.3"));
        SemverRange caretRange = SemverRange.fromString("^2.0.0");
        // Test malformed ranges  
    }
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[2.0.0]"));
        SemverRange range2 = SemverRange.fromString("[2.3.0,2.7.0]");
        assertEquals("Equal inclusive ranges should have same hashcode", inclusiveRange1.hashCode(), inclusiveRange2.hashCode());
        assertEquals(  
        assertFalse("Should exclude lower bound", range2.isSatisfiedBy("2.3.0"));
        assertFalse(range.isSatisfiedBy("1.3.3"));
        assertEquals("Same version should evaluate consistently", result1, result2);  
    public void testRangeWithCaretOperator() {  
        assertFalse("Exclusive range should not equal left-inclusive range", exclusiveRange1.equals(leftInclusiveRange1));
        // Test different version ranges
        expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("$1.2.3"));  
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(range.isSatisfiedBy("2.2.3"));
        assertFalse("Range should not equal null", inclusiveRange1.equals(null));  
        assertTrue(range.isSatisfiedBy("2.3.4"));  
            assertEquals("toString should match original string", rangeStr, range.toString());  
        // Test inequality between different range types  
        String[] ranges = { "[2.3.0,2.7.0]", "(2.3.0,2.7.0)", "[2.3.0,2.7.0)", "(2.3.0,2.7.0]" };  
        assertFalse(range.isSatisfiedBy("1.99.99"));
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[2.0.0,]"));
        // Test inclusive lower bound, exclusive upper bound  
        assertFalse("Inclusive range should not equal left-inclusive range", inclusiveRange1.equals(leftInclusiveRange1));
        assertTrue(range.isSatisfiedBy("2.3.4"));
 * this file be licensed under the Apache-2.0 license or a
        // Test null and different types
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("^"));  
        for (String rangeStr : ranges) {
    }
        assertEquals(
        assertTrue("Should include lower bound", range.isSatisfiedBy("2.0.0"));  
public class SemverRangeTests extends OpenSearchTestCase {  
        assertEquals(SemverRange.RangeOperator.EQ, eqRange.getRangeOperator());
        assertFalse("Should exclude upper bound", range.isSatisfiedBy("2.7.0"));
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        // Test edge cases for range boundaries
        assertFalse("Should exclude version before lower bound", range.isSatisfiedBy("1.9.99"));
        SemverRange range = SemverRange.fromString("[2.0.0,3.0.0]");  
        assertFalse(range.isSatisfiedBy("2.3.3"));
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
}  
        );
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        assertFalse(range.isSatisfiedBy("2.3.0"));  
        IllegalArgumentException ex = expectThrows(  
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        SemverRange range = SemverRange.fromString("1.2.3");  
        assertEquals(SemverRange.RangeOperator.TILDE, tildeRange.getRangeOperator());
    public void testInvalidRangeConstructions() {
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        // Test mixed ranges [a,b) and (a,b]
        assertFalse("Range should not equal different type", inclusiveRange1.equals("not a range"));
        boolean result1 = range.isSatisfiedBy("2.5.0");
        SemverRange exclusiveRange2 = SemverRange.fromString("(1.0.0,2.0.0)");
    public void testRangeWithEqualsOperator() {
        SemverRange rightInclusiveRange1 = SemverRange.fromString("(1.0.0,2.0.0]");
        assertTrue("Should include patch versions", range.isSatisfiedBy("2.4.1"));
    public void testRangeEvaluationConsistency() {
        String[] testRanges = { "[2.0.0,3.0.0]", "(2.0.0,3.0.0)", "[2.0.0,3.0.0)", "(2.0.0,3.0.0]", "^2.0.0", "~2.0.0", "=2.0.0" };
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("$"));  
        for (String rangeStr : testRanges) {
        SemverRange tildeRange = SemverRange.fromString("~2.0.0");
    }  
        // Test just outside boundaries  
        // Test that range evaluation is consistent  
        assertTrue(range.isSatisfiedBy("2.3.5"));  
        assertFalse(range.isSatisfiedBy("2.3.3"));
        // Test same version evaluation  
        // Test middle values  
        assertTrue("Should include values in range", range1.isSatisfiedBy("2.6.9"));
    public void testInvalidRanges() {
            IllegalArgumentException.class,
        assertTrue(range.isSatisfiedBy("2.3.5"));
        SemverRange range = SemverRange.fromString("^2.3.4");
        assertTrue("Should include values in range", range2.isSatisfiedBy("2.3.1"));
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("$1"));  
        assertEquals(range.getRangeOperator(), SemverRange.RangeOperator.EQ);
        assertFalse("Left-inclusive range should not equal right-inclusive range", leftInclusiveRange1.equals(rightInclusiveRange1));
        assertFalse("Should exclude values below range", range.isSatisfiedBy("2.2.9"));
        assertFalse("Should exclude values above range", range.isSatisfiedBy("2.7.1"));
        // Test that expressions are properly assigned for different operators
        // Test exclusive ranges (a,b)  
        );
        // Test that toString produces consistent output
        assertTrue(range.isSatisfiedBy("2.3.12"));
        assertEquals(range.getRangeOperator(), SemverRange.RangeOperator.TILDE);
        assertFalse("Should exclude lower bound", range.isSatisfiedBy("2.3.0"));
        SemverRange eqRange = SemverRange.fromString("=2.0.0");  
        assertTrue("Same left-inclusive ranges should be equal", leftInclusiveRange1.equals(leftInclusiveRange2));
        SemverRange range = SemverRange.fromString("(2.3.0,2.7.0)");
        assertTrue("Should include values near upper bound", range.isSatisfiedBy("2.6.9"));
    }  
        assertTrue("Identical inclusive ranges should be equal", inclusiveRange1.equals(inclusiveRange2));  
        assertFalse("Should exclude values below range", range.isSatisfiedBy("2.2.9"));
        assertTrue(range.isSatisfiedBy("3.0.0"));  
        SemverRange leftInclusiveRange1 = SemverRange.fromString("[1.0.0,2.0.0)");  
