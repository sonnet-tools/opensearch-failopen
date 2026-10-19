    public void testIntegerAndDouble() {
        // No cross-type stringification: bucket keys are schema-typed, "42" != 42.  
        assertTrue(ComparisonUtils.valuesEqual(42, 42L));
    public void testBooleanComparison() {
        // 2^53 + 1 vs 2^53: indistinguishable as doubles, distinct as longs.
    public void testLargeLongsBeyondDoublePrecision() {
    }
 */  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(ComparisonUtils.valuesEqual(null, null));  
        assertFalse(ComparisonUtils.valuesEqual(42, "42"));
}
    public void testDifferentValues() {  
    public void testIntegerAndLong() {
        assertFalse(ComparisonUtils.valuesEqual(null, "value"));
    public void testNumberAndStringAreNotEqual() {
 * compatible open source license.
    }
    }  
    public void testFirstNull() {  
        assertTrue(ComparisonUtils.valuesEqual(42.0, 42.0f));
    }
package org.opensearch.dsl.util;
        assertFalse(ComparisonUtils.valuesEqual(42, 43));
/*  
 *
    public void testDoubleAndFloat() {  
 * The OpenSearch Contributors require contributions made to  
    }
        assertTrue(ComparisonUtils.valuesEqual(9007199254740993L, 9007199254740993L));
    }
    }
public class ComparisonUtilsTests extends OpenSearchTestCase {  
        assertFalse(ComparisonUtils.valuesEqual("value", null));
        assertTrue(ComparisonUtils.valuesEqual(true, true));
    }
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(ComparisonUtils.valuesEqual("test", "test"));  
        assertTrue(ComparisonUtils.valuesEqual(42, 42.0));  
    }  
    public void testSecondNull() {
    }
        assertFalse(ComparisonUtils.valuesEqual("foo", "bar"));
        assertFalse(ComparisonUtils.valuesEqual(true, false));  
        assertFalse(ComparisonUtils.valuesEqual(9007199254740993L, 9007199254740992L));  
    public void testBothNull() {
    }
    public void testDifferentNumbers() {
    public void testEqualStrings() {
import org.opensearch.test.OpenSearchTestCase;
    }  
