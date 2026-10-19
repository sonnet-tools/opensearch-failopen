        Version lowerBound = Version.fromString("2.3.0");
 * compatible open source license.
        Version upperBound = Version.fromString("2.7.0");
        assertFalse(inclusiveRange.evaluate(null, Version.fromString("2.7.1")));
        assertTrue(exclusiveRange.evaluate(null, Version.fromString("2.5.0")));  
/*  
            Version.fromString("2.0.0"),
 *
        Version lowerBound = Version.fromString("2.3.0");
        assertTrue(range.isIncludeUpper());
            true   // includeUpper
        assertTrue(mixedRange2.evaluate(null, Version.fromString("2.7.0")));  
        ex = expectThrows(IllegalArgumentException.class, () -> new Range(upperBound, lowerBound, true, true));  
    }
        Range mixedRange1 = new Range(lowerBound, upperBound, true, false);  
        assertEquals("Lower bound must be less than or equal to upper bound", ex.getMessage());
package org.opensearch.semver.expr;
        // Test exclusive range  
public class RangeTests extends OpenSearchTestCase {
        assertFalse(mixedRange1.evaluate(null, Version.fromString("2.7.0")));  
        Range mixedRange2 = new Range(lowerBound, upperBound, false, true);  
    public void testRangeEvaluation() {  
        Version upperBound = Version.fromString("2.7.0");
        assertTrue(inclusiveRange.evaluate(null, Version.fromString("2.3.0")));  
        // Test exclusive lower, inclusive upper
        assertFalse(exclusiveRange.evaluate(null, Version.fromString("2.7.1")));  
        Range range = new Range(lowerBound, upperBound, true, false);  
        assertFalse(exclusiveRange.evaluate(null, Version.fromString("2.2.9")));
        assertEquals("Upper bound cannot be null", ex.getMessage());  
        Version lowerBound = Version.fromString("2.3.0");
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> range.updateRange(null));
        assertEquals("Lower bound cannot be null", ex.getMessage());  
        assertFalse(inclusiveRange.evaluate(null, Version.fromString("2.2.9")));  
import org.opensearch.Version;
        Range range = new Range();
        assertEquals("Upper bound should match", upperBound, range.getUpperBound());  
        assertFalse("Should be exclusive upper", range.isIncludeUpper());
 */  
        Version upperBound = Version.fromString("2.7.0");
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(range.isIncludeLower());
        // Test invalid range (upper < lower)
        Range inclusiveRange = new Range(lowerBound, upperBound, true, true);
    public void testInvalidRanges() {  
        assertEquals("Range cannot be null", ex.getMessage());  
        assertTrue(mixedRange1.evaluate(null, Version.fromString("2.6.9")));
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> new Range(null, upperBound, true, true));
    public void testDefaultConstructor() {  
    }
            true,  // includeLower  
    }  
        );
        assertTrue(inclusiveRange.evaluate(null, Version.fromString("2.5.0")));
    }
    public void testUpdateRangeNullCheck() {
        Version lowerBound = Version.fromString("2.3.0");
}  
        Range exclusiveRange = new Range(lowerBound, upperBound, false, false);
        assertFalse(mixedRange2.evaluate(null, Version.fromString("2.3.0")));
    public void testMixedBoundTypes() {
        Version upperBound = Version.fromString("2.7.0");  
        Range range = new Range(  
        assertFalse(exclusiveRange.evaluate(null, Version.fromString("2.7.0")));
        ex = expectThrows(IllegalArgumentException.class, () -> new Range(lowerBound, null, true, true));
 * The OpenSearch Contributors require contributions made to  
        // Test inclusive range
        assertTrue(mixedRange2.evaluate(null, Version.fromString("2.3.1")));
        assertEquals(Version.fromString("99.99.99"), range.getUpperBound());  
        // Test null bounds
        // Test that updateRange throws IllegalArgumentException for null input
        assertTrue("Should be inclusive lower", range.isIncludeLower());
        assertTrue(mixedRange1.evaluate(null, Version.fromString("2.3.0")));
        assertEquals(Version.fromString("0.0.0"), range.getLowerBound());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(inclusiveRange.evaluate(null, Version.fromString("2.7.0")));
    }
        assertEquals("Lower bound should match", lowerBound, range.getLowerBound());
    }
        assertFalse(exclusiveRange.evaluate(null, Version.fromString("2.3.0")));
        // Test inclusive lower, exclusive upper
            Version.fromString("1.0.0"),
    public void testRangeAccessors() {  
