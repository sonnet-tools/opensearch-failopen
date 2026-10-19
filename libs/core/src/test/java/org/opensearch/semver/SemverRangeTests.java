        assertTrue("Should include upper bound", range.isSatisfiedBy("2.7.0"));
    public void testRangeWithDefaultOperator() {
        for (String rangeStr : ranges) {
        // Test lower bound
        assertTrue("Should include values in range", range1.isSatisfiedBy("2.6.9"));
        // Test that toString produces the same string that was parsed
        assertFalse(range.isSatisfiedBy("2.2.3"));
        // Test exact boundaries
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("~"));
        assertFalse("Exclusive range should not equal left-inclusive range", exclusiveRange1.equals(leftInclusiveRange1));
    public void testRangeEquality() {
        SemverRange range = SemverRange.fromString("1.2.3");
        expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("$1.2.3"));
        IllegalArgumentException ex = expectThrows(
    public void testInclusiveRange() {
        assertEquals(
        assertEquals("Version cannot be empty", ex.getMessage());
        // Test inclusive ranges [a,b]
    public void testRangeToStringConsistency() {
        // Test malformed ranges
    public void testVersionEdgeCases() {
    public void testRangeBoundaryConditions() {
        assertFalse("Should exclude values above range", range.isSatisfiedBy("2.7.1"));
        assertTrue("Identical inclusive ranges should be equal", inclusiveRange1.equals(inclusiveRange2));
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("^"));
        // Test major version boundaries
    }
    public void testInvalidRangeConstructions() {
        SemverRange range = SemverRange.fromString("[2.0.0,3.0.0]");
        assertFalse(range.isSatisfiedBy("2.3.3"));
        SemverRange range = SemverRange.fromString("(2.3.0,2.7.0)");
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("1"));
        assertTrue("Should include values near lower bound", range.isSatisfiedBy("2.3.1"));
        SemverRange inclusiveRange1 = SemverRange.fromString("[1.0.0,2.0.0]");
    }
            SemverRange range = SemverRange.fromString(rangeStr);
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[2.3.0]"));
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        // Test different version ranges
public class SemverRangeTests extends OpenSearchTestCase {
        assertTrue(range.isSatisfiedBy("2.0.0"));
            leftInclusiveRange1.hashCode(),
        // Test bounds
        assertEquals(SemverRange.RangeOperator.EQ, eqRange.getRangeOperator());
        // Test just outside boundaries
        assertTrue(range.isSatisfiedBy("2.3.5"));
        assertFalse(range.isSatisfiedBy("3.0.1"));
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("^1"));
        assertFalse("Should exclude values above range", range.isSatisfiedBy("2.7.1"));
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        assertTrue("Should include values in range", range.isSatisfiedBy("2.5.0"));
        assertFalse("Should exclude lower bound", range.isSatisfiedBy("2.3.0"));
        assertTrue("Should include lower bound", range.isSatisfiedBy("2.3.0"));
        boolean result1 = range.isSatisfiedBy("2.5.0");
        // Test edge cases for range boundaries
        assertFalse("Should exclude upper bound", range.isSatisfiedBy("2.7.0"));
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        SemverRange rightInclusiveRange2 = SemverRange.fromString("(1.0.0,2.0.0]");
    }
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[,2.7.0]"));
        assertEquals(range.getRangeOperator(), SemverRange.RangeOperator.DEFAULT);
        assertFalse("Should exclude version after upper bound", range.isSatisfiedBy("3.0.1"));
        assertFalse(range.isSatisfiedBy("2.4.0"));
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        // Test that expressions are properly assigned for different operators
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[2.3.0,]"));
        // Test that range evaluation is consistent
 * compatible open source license.
        SemverRange range1 = SemverRange.fromString("[2.3.0,2.7.0]");
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(range.isSatisfiedBy("2.2.3"));
        assertTrue("Same inclusive range should be equal to itself", inclusiveRange1.equals(inclusiveRange1));
        SemverRange differentRange = SemverRange.fromString("[1.0.0,3.0.0]");
        assertTrue("Should include upper bound", range.isSatisfiedBy("3.0.0"));
        assertTrue("Should include upper bound", range2.isSatisfiedBy("2.7.0"));
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        SemverRange range2 = SemverRange.fromString("(2.3.0,2.7.0]");
 * The OpenSearch Contributors require contributions made to
        assertFalse("Left-inclusive range should not equal right-inclusive range", leftInclusiveRange1.equals(rightInclusiveRange1));
        assertFalse("Range should not equal null", inclusiveRange1.equals(null));
        assertFalse(range.isSatisfiedBy("1.2.4"));
        SemverRange range3 = SemverRange.fromString("(2.3.0,2.7.0]");
        // Test out of range values
            IllegalArgumentException.class,
        assertTrue("Should include lower bound", range.isSatisfiedBy("2.0.0"));
        String[] ranges = { "[2.3.0,2.7.0]", "(2.3.0,2.7.0)", "[2.3.0,2.7.0)", "(2.3.0,2.7.0]" };
        SemverRange range1 = SemverRange.fromString("[2.3.0,2.7.0)");
        assertTrue(range.isSatisfiedBy("1.2.3"));
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("$"));
        assertEquals(range.getRangeOperator(), SemverRange.RangeOperator.EQ);
        assertFalse("Inclusive range should not equal right-inclusive range", inclusiveRange1.equals(rightInclusiveRange1));
        assertEquals("Identical ranges should be equal", range1, range2);
        // Test same version evaluation
        // Test that toString produces consistent output
    }
    }
            leftInclusiveRange2.hashCode()
    }
        assertFalse(range.isSatisfiedBy("1.3.3"));
    public void testRangeEvaluationConsistency() {
        assertTrue(range.isSatisfiedBy("2.3.12"));
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("2.3.0,2.7.0"));
        assertFalse(range.isSatisfiedBy("1.2.4"));
            rightInclusiveRange1.hashCode(),
        for (String rangeStr : testRanges) {
        SemverRange exclusiveRange1 = SemverRange.fromString("(1.0.0,2.0.0)");
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[2.0.0]"));
    }
    }
        assertTrue("Same right-inclusive ranges should be equal", rightInclusiveRange1.equals(rightInclusiveRange2));
        assertEquals("Equal inclusive ranges should have same hashcode", inclusiveRange1.hashCode(), inclusiveRange2.hashCode());
        assertFalse("Inclusive range should not equal exclusive range", inclusiveRange1.equals(exclusiveRange1));
        assertTrue("Should include patch versions", range.isSatisfiedBy("2.4.1"));
        assertFalse(range.isSatisfiedBy("2.3.3"));
        assertEquals("Version cannot be empty", ex.getMessage());
        // Test inequality between different range types
        assertEquals(SemverRange.RangeOperator.TILDE, tildeRange.getRangeOperator());
        SemverRange range = SemverRange.fromString("^2.3.4");
        assertFalse(range.isSatisfiedBy("3.0.0"));
        boolean result2 = range.isSatisfiedBy("2.5.0");
        SemverRange rightInclusiveRange1 = SemverRange.fromString("(1.0.0,2.0.0]");
        // Test null and different types
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("~1"));
    public void testRangeWithTildeOperator() {
            SemverRange range = SemverRange.fromString(rangeStr);
 */
        assertFalse("Should exclude values below range", range.isSatisfiedBy("2.2.9"));
}
        assertFalse("Should exclude values below range", range.isSatisfiedBy("2.2.9"));
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("$1.2"));
        String[] testRanges = { "[2.0.0,3.0.0]", "(2.0.0,3.0.0)", "[2.0.0,3.0.0)", "(2.0.0,3.0.0]", "^2.0.0", "~2.0.0", "=2.0.0" };
        assertTrue("Should include lower bound", range1.isSatisfiedBy("2.3.0"));
        assertTrue("Should include values in range", range.isSatisfiedBy("2.5.0"));
        // Test exclusive ranges (a,b)
        assertEquals(range.getRangeOperator(), SemverRange.RangeOperator.CARET);
/*
        assertNotEquals("Different ranges should not be equal", range1, range3);
        assertFalse("Should exclude lower bound", range2.isSatisfiedBy("2.3.0"));
        assertEquals(SemverRange.RangeOperator.CARET, caretRange.getRangeOperator());
    public void testRangeWithEqualsOperator() {
    public void testEqualsAndHashCode() {
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        SemverRange range = SemverRange.fromString("[2.3.0,2.7.0]");
        assertTrue(range.isSatisfiedBy("1.2.3"));
            rightInclusiveRange2.hashCode()
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("~1.2"));
        assertTrue("Identical exclusive ranges should be equal", exclusiveRange1.equals(exclusiveRange2));
        );
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString(""));
        SemverRange range = SemverRange.fromString("=1.2.3");
        // Test middle values
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
    public void testRangeOperatorExpression() {
        assertFalse(range.isSatisfiedBy("3.0.0"));
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[2.7.0,2.3.0]"));
        assertTrue(ex.getMessage().contains("Lower bound must be less than or equal to upper bound"));
        // Test inclusive lower bound, exclusive upper bound
        assertFalse("Range should not equal different type", inclusiveRange1.equals("not a range"));
        assertTrue("Should include values in range", range2.isSatisfiedBy("2.3.1"));
            assertEquals("toString should match original string", rangeStr, range.toString());
        );
            "Equal left-inclusive ranges should have same hashcode",
        assertTrue(range.isSatisfiedBy("2.3.4"));
        SemverRange range = SemverRange.fromString("[2.0.0,3.0.0]");
        SemverRange caretRange = SemverRange.fromString("^2.0.0");
        assertEquals(
        // Test exclusive lower bound, inclusive upper bound
    public void testExclusiveRange() {
            "Equal right-inclusive ranges should have same hashcode",
    public void testRangeWithCaretOperator() {
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("$1"));
        assertTrue("Should include values near upper bound", range.isSatisfiedBy("2.6.9"));
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        SemverRange range = SemverRange.fromString("[2.0.0,3.0.0]");
        assertFalse("Should exclude version before lower bound", range.isSatisfiedBy("1.9.99"));
    }
        assertFalse("Inclusive range should not equal left-inclusive range", inclusiveRange1.equals(leftInclusiveRange1));
        }
        assertEquals(range.getRangeOperator(), SemverRange.RangeOperator.TILDE);
        }
    }
    }
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
    }
    public void testInvalidRanges() {
        assertTrue(range.isSatisfiedBy("2.3.4"));
        SemverRange exclusiveRange2 = SemverRange.fromString("(1.0.0,2.0.0)");
            assertEquals("toString should match original string", rangeStr, range.toString());
            () -> SemverRange.fromString("[2.0.0,1.0.0]")  // Lower bound greater than upper bound
    }
        assertFalse(range.isSatisfiedBy("1.99.99"));
        // Test mixed ranges [a,b) and (a,b]
        assertFalse("Should exclude upper bound", range1.isSatisfiedBy("2.7.0"));
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        assertTrue(range.isSatisfiedBy("2.99.99"));
        // Test out of range values
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("1.2"));
        assertTrue(range.isSatisfiedBy("2.3.5"));
    public void testMixedRanges() {
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[,2.0.0]"));
        assertTrue("Same exclusive range should be equal to itself", exclusiveRange1.equals(exclusiveRange1));
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("=1"));
 *
        assertTrue(ex.getMessage().contains("the version needs to contain major, minor, and revision, and optionally the build"));
        assertEquals("Version cannot be empty", ex.getMessage());
        assertThrows(IllegalArgumentException.class, () -> SemverRange.fromString("[2.0.0,]"));
    public void testRangeToString() {
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("^1.2"));
        assertTrue(range.isSatisfiedBy("3.0.0"));
        assertEquals("Same version should evaluate consistently", result1, result2);
        // Test invalid range constructions
        SemverRange tildeRange = SemverRange.fromString("~2.0.0");
package org.opensearch.semver;
        );
        // Test middle values
        SemverRange leftInclusiveRange1 = SemverRange.fromString("[1.0.0,2.0.0)");
        SemverRange range = SemverRange.fromString("~2.3.4");
        SemverRange inclusiveRange2 = SemverRange.fromString("[1.0.0,2.0.0]");
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("=1.2"));
        ex = expectThrows(IllegalArgumentException.class, () -> SemverRange.fromString("="));
        SemverRange eqRange = SemverRange.fromString("=2.0.0");
    }
 * this file be licensed under the Apache-2.0 license or a
        SemverRange range2 = SemverRange.fromString("[2.3.0,2.7.0]");
    }
        assertEquals("Equal exclusive ranges should have same hashcode", exclusiveRange1.hashCode(), exclusiveRange2.hashCode());
        assertFalse(range.isSatisfiedBy("2.3.0"));
        assertNotEquals("Range should not equal null", null, range1);
import org.opensearch.test.OpenSearchTestCase;
    }
        assertFalse("Ranges with different versions should not be equal", inclusiveRange1.equals(differentRange));
        SemverRange leftInclusiveRange2 = SemverRange.fromString("[1.0.0,2.0.0)");
        // Test upper bound
        assertFalse(range.isSatisfiedBy("1.3.3"));
    }
        assertTrue("Same left-inclusive ranges should be equal", leftInclusiveRange1.equals(leftInclusiveRange2));
        assertEquals("Version cannot be empty", ex.getMessage());
        assertTrue(range.isSatisfiedBy("2.4.12"));
