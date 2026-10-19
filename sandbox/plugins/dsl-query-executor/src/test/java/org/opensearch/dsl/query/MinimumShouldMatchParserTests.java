        assertEquals(7, MinimumShouldMatchParser.calculateRequiredMatches("3 < 75%", 10, false));
        ConversionException ex = expectThrows(  
    public void testCombinationAboveThreshold() throws ConversionException {  
    }
    public void testInfinityPercentageThrows() {
            ConversionException.class,
    }
 * compatible open source license.
        assertTrue(ex.getMessage().contains("\"\""));  
        );
    public void testNullWithoutRequired() throws ConversionException {
            () -> MinimumShouldMatchParser.calculateRequiredMatches("5<<3", 6, false)
        assertTrue(ex.getMessage().contains("abc"));  
    }
        assertTrue(ex.getMessage().contains("5<"));
            () -> MinimumShouldMatchParser.calculateRequiredMatches("Infinity%", 4, false)
import org.opensearch.test.OpenSearchTestCase;
            ConversionException.class,
    }
        ConversionException ex = expectThrows(
/*  
        );  
    // --- Malformed specs: ConversionException ---
    }
    public void testCombinationBelowThreshold() throws ConversionException {
    public void testNegativePercentage() throws ConversionException {  
        ConversionException ex = expectThrows(
        assertEquals(2, MinimumShouldMatchParser.calculateRequiredMatches("70%", 4, false));  
    // --- Single combination specs ---  
    }
        ConversionException ex = expectThrows(  
    public void testDoubleLessThanThrows() {
        assertEquals(6, MinimumShouldMatchParser.calculateRequiredMatches("6", 4, false));
    }  
    }  
            () -> MinimumShouldMatchParser.calculateRequiredMatches("5<", 6, false)
    // --- Multiple combination specs ---  
        assertTrue(ex.getMessage().contains("70.5%"));  
        assertEquals(2, MinimumShouldMatchParser.calculateRequiredMatches("2<75%", 2, false));  
        // Legacy parity: "" is not equivalent to null; legacy throws NumberFormatException on "".
    }  
            () -> MinimumShouldMatchParser.calculateRequiredMatches("", 4, false)
        // Legacy does NOT upper-clamp: "6" on total=4 returns 6.  
public class MinimumShouldMatchParserTests extends OpenSearchTestCase {
        assertEquals(3, MinimumShouldMatchParser.calculateRequiredMatches("-30%", 4, false));
        assertEquals(4, MinimumShouldMatchParser.calculateRequiredMatches("5<50%", 4, false));  
        assertEquals(1, MinimumShouldMatchParser.calculateRequiredMatches(null, 3, false));  
        // "-10" on total=4 -> 4 + (-10) = -6 -> floor clamp to 0.
            ConversionException.class,  
        ConversionException ex = expectThrows(
        // "5<<3" throws NumberFormatException in legacy (recursive call with "" from empty split part).
        ConversionException ex = expectThrows(  
        );
        assertTrue(ex.getMessage().contains("5<<3"));
    // --- Percentage specs ---  
    }  
    }
        assertEquals(2, MinimumShouldMatchParser.calculateRequiredMatches("2", 5, false));
            () -> MinimumShouldMatchParser.calculateRequiredMatches("abc", 4, false)
 * this file be licensed under the Apache-2.0 license or a
    }
        );  
            ConversionException.class,  
            () -> MinimumShouldMatchParser.calculateRequiredMatches("70.5%", 4, false)
        );  
 * The OpenSearch Contributors require contributions made to  
        ConversionException ex = expectThrows(  
            () -> MinimumShouldMatchParser.calculateRequiredMatches("<5", 4, false)
    public void testIntegerExceedingTotal_noUpperClamp() throws ConversionException {
        assertEquals(3, MinimumShouldMatchParser.calculateRequiredMatches("3<-1 5<50%", 4, false));
    public void testSpaceAroundOperator() throws ConversionException {  
    }
    public void testLeadingLessThanThrows() {
}
        );  
    }
        // "<5" throws NumberFormatException in legacy (Integer.parseInt("") on empty parts[0]).
    public void testNaNPercentageThrows() {  
        assertEquals(0, MinimumShouldMatchParser.calculateRequiredMatches(null, 3, true));
            ConversionException.class,
        // "3 < 75%" on total=10 returns 7 (spaces around < are normalized by legacy).
    public void testMultipleCombinationsLow() throws ConversionException {
        assertTrue(ex.getMessage().contains("Infinity%"));
        assertEquals(3, MinimumShouldMatchParser.calculateRequiredMatches("3<-1 5<50%", 3, false));  
        // "5<50%" on total=4 -> total <= 5 -> return total (4).
    }
        assertEquals(7, MinimumShouldMatchParser.calculateRequiredMatches(" 75% ", 10, false));  
    }
    }
    }
            ConversionException.class,
    public void testCombinationSingleEntry() throws ConversionException {
    public void testMultipleCombinationsFromTestTable() throws ConversionException {
            ConversionException.class,
    public void testTrailingLessThanThrows() {
    }
        // "5<" throws ArrayIndexOutOfBoundsException in legacy when total > threshold (parts[1] after split).
    public void testMultipleCombinationsMid() throws ConversionException {  
    // --- Space-around-operator normalization (legacy parity) ---
            ConversionException.class,  
    public void testPositivePercentage() throws ConversionException {
        assertEquals(3, MinimumShouldMatchParser.calculateRequiredMatches("3<-1 5<50%", 6, false));
    public void testLargeNegativeFloorClamp() throws ConversionException {
        ConversionException ex = expectThrows(
    public void testNegativeInteger() throws ConversionException {
    }
        assertEquals(4, MinimumShouldMatchParser.calculateRequiredMatches("3<-1 5<50%", 8, false));
 * SPDX-License-Identifier: Apache-2.0
        // "3<-1 5<50%" on total=8 returns 4.  
        assertEquals(3, MinimumShouldMatchParser.calculateRequiredMatches("2<75%", 4, false));
    }
        );
 */  
        assertEquals(0, MinimumShouldMatchParser.calculateRequiredMatches("-10", 4, false));  
import org.opensearch.dsl.converter.ConversionException;
    }
    public void testPaddedPercentage() throws ConversionException {
    public void testFractionalPercentageThrows() {
            () -> MinimumShouldMatchParser.calculateRequiredMatches("NaN%", 4, false)  
    }
    public void testPositiveInteger() throws ConversionException {  
package org.opensearch.dsl.query;
        // " 75% " on total=10 returns 7 (legacy trims whitespace).
    }
        assertTrue(ex.getMessage().contains("NaN%"));
        );
    public void testAlphabeticSpecThrows() {
    public void testMultipleCombinationsHigh() throws ConversionException {
        assertTrue(ex.getMessage().contains("<5"));
        assertEquals(4, MinimumShouldMatchParser.calculateRequiredMatches("-1", 5, false));
    // --- Integer specs ---
    // --- Default behavior (null spec) ---  
    public void testNullWithRequired() throws ConversionException {  
 *
    }
    public void testEmptyStringThrows() {  
