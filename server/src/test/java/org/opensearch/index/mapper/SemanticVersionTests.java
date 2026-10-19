        // Pre-release with uppercase (should be lowercased in normalized)
    }
    }
        version = SemanticVersion.parse("1.2.3-x.7.z.92");
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            e = expectThrows(IllegalArgumentException.class, () -> SemanticVersion.parse(invalid));
        String normalized2 = version2.getNormalizedString();  
            assertTrue(e.getMessage().contains("Invalid version numbers"));
        assertTrue(stableNorm.endsWith("~"));  
        assertEquals("1.2.3-alpha.1+build.123", version.toString());  
import java.util.List;  
        // Test numeric vs non-numeric identifiers
        SemanticVersion version = SemanticVersion.parse("1.0.0");
        assertEquals(betaNorm, preReleaseWithBuildNorm);  
    public void testInvalidVersions() {  
        // Create versions with non-numeric pre-release identifiers  
    public void testPreReleaseComparison() {
            SemanticVersion v2 = SemanticVersion.parse(orderedVersions.get(i + 1));  
        assertNull(versionNoBuild.getBuild());
            "1.2.-3"  
        String preReleaseWithBuildNorm = preReleaseWithBuild.getNormalizedComparableString();
            "1.2.3+@invalid",
        SemanticVersion version1 = SemanticVersion.parse("[1.2.3]");
        assertThat(SemanticVersion.parse("1.1.2").compareTo(SemanticVersion.parse("1.1.1")), greaterThan(0));
        for (int i = 0; i < orderedVersions.size() - 1; i++) {
            "1.2",  
    }  
        try {
        // Pre-release beta - should end with '-beta'
        // Check padding  
    public void testPreReleaseVersionParsing() {  
    }
        assertEquals("1.2.3", version2.toString());  
        // Test different lengths
        SemanticVersion version2 = SemanticVersion.parse("[1.2.3-alpha]");
        SemanticVersion v2 = SemanticVersion.parse("1.0.0-beta");
        // Test invalid formats  
    /**  
    }
        assertThat(SemanticVersion.parse("1.0.0-alpha").compareTo(SemanticVersion.parse("1.0.0-beta")), lessThan(0));
    public void testNullComparison() {  
        assertThat(SemanticVersion.parse("2.0.0").compareTo(SemanticVersion.parse("1.0.0")), greaterThan(0));
        assertEquals("999999999.999999999.999999999", version.toString());
        assertThat(SemanticVersion.parse("1.0.0-alpha.1").compareTo(SemanticVersion.parse("1.0.0-alpha.2")), lessThan(0));
    }
        version = SemanticVersion.parse("1.0.0+build.123.456.789.abc.def");
        // Pre-release alpha - should end with '-alpha' (lowercase)
        // Test mixed numeric and string
        assertThat(v3.compareTo(v4), lessThan(0));
        SemanticVersion beta = SemanticVersion.parse("1.0.0-beta");  
        assertTrue(normalized.contains("+build.123"));
    public void testCompleteVersionParsing() {
            "1.2.3-",
        assertEquals("1.2.3+build.123", version3.toString());  
            "1.2.3.4",
        // Test without build metadata
        // Test with mixed case to ensure case sensitivity is handled
        // Test major version comparison  
        String preReleaseCapsNorm = preReleaseCaps.getNormalizedComparableString();
        SemanticVersion preReleaseWithBuild = SemanticVersion.parse("1.0.0-beta+build.456");
        version = SemanticVersion.parse("1.2.3-0.3.7");
    public void testNegativeNumbers() {  
        SemanticVersion version4 = SemanticVersion.parse("[1.2.3-alpha+build.123]");
        assertThat(SemanticVersion.parse("1.2.0").compareTo(SemanticVersion.parse("1.1.0")), greaterThan(0));
        assertThat(v2.compareTo(v1), greaterThan(0));  
import org.opensearch.test.OpenSearchTestCase;  
        assertThat(version.compareTo(null), greaterThan(0));
        SemanticVersion version = SemanticVersion.parse("1.2.3+build.123");  
        // Test mixed whitespace
            "a.b.c",  
            // Verify that the exception message contains the expected text
        assertEquals(0, SemanticVersion.parse("1.0.0+build.1").compareTo(SemanticVersion.parse("1.0.0+build.2")));
        assertThat(SemanticVersion.parse("1.0.0-alpha").compareTo(SemanticVersion.parse("1.0.0-alpha.1")), lessThan(0));  
        assertEquals("1.2.3-x.7.z.92", version.toString());
        // Test string comparison  
        String alphaNorm = alpha.getNormalizedComparableString();
    public void testGetNormalizedComparableString() {
        SemanticVersion v3 = SemanticVersion.parse("1.0.0-Alpha");  
            "1.0.0-beta",  
        );
        // Test that whitespace is converted to dots during parsing
        assertEquals("1.2.3+build.123", version.toString());
        SemanticVersion version2 = SemanticVersion.parse("123.456.789");
        // Check pre-release and build metadata
        SemanticVersion version = SemanticVersion.parse("1.2.3");
import static org.hamcrest.Matchers.lessThan;  
        }  
            "1.0.0-rc.1",  
    /**
    }
        assertTrue(betaNorm.endsWith("-beta"));  
        assertTrue(normalized.contains("00000000000000000002"));
            "1.0.0"
        SemanticVersion version = SemanticVersion.parse("1.2.3-alpha.1+build.123");
            "1",
        String normalized = version.getNormalizedString();
     */
        assertTrue(e.getMessage().contains("Invalid semantic version format"));  
        assertThat(SemanticVersion.parse("1.0.0-alpha.1").compareTo(SemanticVersion.parse("1.0.0-alpha.2")), lessThan(0));
        SemanticVersion stableWithBuild = SemanticVersion.parse("1.0.0+build.123");
import java.util.Arrays;
        List<String> orderedVersions = Arrays.asList(
    }  
        SemanticVersion version1 = SemanticVersion.parse("1 2 3");
    }  
            "1.02.3",
        assertEquals("1.2.3", version.toString());  
        assertEquals("build.123", version.getBuild());  
        String normalized1 = version1.getNormalizedString();
        assertEquals("Version string cannot be null or empty", e.getMessage());  
        assertTrue(stableNorm.startsWith("00000000000000000001.00000000000000000000.00000000000000000000"));
     */
            "1.0.0-alpha.1",
        // alpha comes before beta lexically
        e = expectThrows(IllegalArgumentException.class, () -> SemanticVersion.parse(""));  
    public void testComplexPreReleaseComparison() {
        assertEquals("1.0.0+build.123.456.789.abc.def", version.toString());  
        assertEquals("00000000000000000123.00000000000000000456.00000000000000000789", normalized2);
        // Numeric identifiers have lower precedence than non-numeric  
        // Numeric identifiers  
        String normalized3 = version3.getNormalizedString();
 * SPDX-License-Identifier: Apache-2.0
        String stableWithBuildNorm = stableWithBuild.getNormalizedComparableString();  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> SemanticVersion.parse(null));
            "1.0.0-alpha.beta",
    public void testNumberFormatExceptionInParse() {
    }
        SemanticVersion versionNoBuild = SemanticVersion.parse("1.2.3");  
        assertTrue(alphaNorm.endsWith("-alpha"));  
            SemanticVersion.parse("2147483648.0.0"); // Integer.MAX_VALUE + 1
    }  
        SemanticVersion version = SemanticVersion.parse("1.2.3-alpha");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> SemanticVersion.parse("01.02.03"));
 * The OpenSearch Contributors require contributions made to  
        assertEquals("1.2.3-0.3.7", version.toString());
        assertEquals("1.2.3+build.123.xyz", version.toString());
        SemanticVersion version4 = SemanticVersion.parse("0.0.0");  
            assertThat(v1.compareTo(v2), lessThan(0));
        SemanticVersion version = SemanticVersion.parse("999999999.999999999.999999999");  
        } catch (IllegalArgumentException e) {  
        assertThat(SemanticVersion.parse("1.0.0-beta").compareTo(SemanticVersion.parse("1.0.0-alpha")), greaterThan(0));
    public void testVersionComparison() {
            SemanticVersion v1 = SemanticVersion.parse(orderedVersions.get(i));
    public void testBasicVersionParsing() {
        assertThat(SemanticVersion.parse("1.0.0-alpha").compareTo(SemanticVersion.parse("1.0.0-beta")), lessThan(0));
        List<String> invalidVersions = Arrays.asList(
        assertEquals("1.2.3", version1.toString());  
import static org.hamcrest.Matchers.greaterThan;
            // This should throw IllegalArgumentException with a NumberFormatException cause  
        assertTrue(normalized.startsWith("00000000000000000001"));
        version = SemanticVersion.parse("1.2.3-alpha.1");
        // Long build metadata
        // Test with build metadata
    /**
public class SemanticVersionTests extends OpenSearchTestCase {
        String str = "9999999999";
        assertEquals("00000000000000000000.00000000000000000000.00000000000000000000", normalized4);
     * Test to cover the else branch in comparePreRelease method  
        String betaNorm = beta.getNormalizedComparableString();
        assertThat(SemanticVersion.parse("1.0.0").compareTo(SemanticVersion.parse("2.0.0")), lessThan(0));
        assertTrue(normalized.contains("-alpha"));  
    public void testComparePreReleaseMethod() {  
        // Longer pre-release version has higher precedence  
    public void testBuildMetadataParsing() {
    public void testNormalizedString() {
            "1.2.3-@invalid",
            "-1.2.3",
    public void testPadWithZerosMethod() {
        // Test patch version comparison
        String stableNorm = stable.getNormalizedComparableString();
 * Test class for SemanticVersion  
        assertEquals("1.2.3", version1.toString());  
        version = SemanticVersion.parse("1.0.0-alpha.beta.gamma.delta.epsilon");
        assertThat(SemanticVersion.parse("1.0.0-1").compareTo(SemanticVersion.parse("1.0.0-2")), lessThan(0));  
        // Test with very large numbers  
/*  
        assertEquals("1.2.3", version5.toString());
            "1.0.0-beta.2",
        assertThat(SemanticVersion.parse("1.0.0-1").compareTo(SemanticVersion.parse("1.0.0-alpha")), lessThan(0));
    }  
    }
        SemanticVersion version1 = SemanticVersion.parse("1.2.3");  
        // Pre-release with build metadata (build metadata ignored)  
        SemanticVersion preReleaseCaps = SemanticVersion.parse("1.0.0-ALPHA.BETA");  
        for (String invalid : invalidVersions) {  
        version = SemanticVersion.parse("1.2.3+build.123.xyz");  
        SemanticVersion version3 = SemanticVersion.parse("999999999.999999999.999999999");
        SemanticVersion version = SemanticVersion.parse("1.2.3-alpha+build.123");  
        assertThat(v1.compareTo(v2), lessThan(0));
/**
        assertThat(SemanticVersion.parse("1.0.0-alpha").compareTo(SemanticVersion.parse("1.0.0")), lessThan(0));
        }
        // Test empty string
 */  
        assertEquals("1.2.3", version3.toString());  
    }
    public void testComparePreReleaseElseBranch() {
        // Test null
        SemanticVersion version3 = SemanticVersion.parse("[1.2.3+build.123]");
    public void testGetBuild() {  
        String padded = SemanticVersion.parse("1.0.0").toString();  
        assertTrue(alphaNorm.startsWith("00000000000000000001.00000000000000000000.00000000000000000000"));
    }  
    public void testSquareBracketRemoval() {  
        // Alphanumeric identifiers  
        // Test with a value that doesn't need padding
package org.opensearch.index.mapper;
        String normalized4 = version4.getNormalizedString();
}  
        assertEquals("1.2.3", version4.toString());  
        assertEquals(stableNorm, stableWithBuildNorm);
    public void testWhitespaceHandling() {  
        assertThat(SemanticVersion.parse("1.0.0-1").compareTo(SemanticVersion.parse("1.0.0-alpha")), lessThan(0));
        // Test minor version comparison
        assertThat(SemanticVersion.parse("1.0.0-alpha.1").compareTo(SemanticVersion.parse("1.0.0-alpha")), greaterThan(0));
        assertEquals("1.0.0-alpha.beta.gamma.delta.epsilon", version.toString());
            "1.-2.3",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new SemanticVersion(-1, 0, 0, null, null));
    public void testNumberFormatExceptionHandling() {
    }
    }  
    }
     * Test to cover getBuild() method
        SemanticVersion version4 = SemanticVersion.parse("1 2 3");
        assertTrue(betaNorm.startsWith("00000000000000000001.00000000000000000000.00000000000000000000"));
            "01.2.3",
            // Verify that the cause is a NumberFormatException  
        assertTrue(preReleaseCapsNorm.endsWith("-alpha.beta"));
        }
            "1.2.3+",  
        assertEquals("1.2.3-alpha", version.toString());
    }
            "1.0.0-alpha",  
    }
        SemanticVersion version3 = SemanticVersion.parse("1\t2\t3");
 */
        // Pre-release versions have lower precedence  
        // Test with zero values
        // Stable release with build metadata (build metadata ignored in normalized string)
        assertThat(SemanticVersion.parse("1.0.0-alpha.2").compareTo(SemanticVersion.parse("1.0.0-alpha.10")), lessThan(0));  
        SemanticVersion version5 = SemanticVersion.parse("1 \t 2 \t 3");  
        assertEquals("Version numbers cannot be negative", e.getMessage());
        assertEquals("00000000000000000001.00000000000000000002.00000000000000000003", normalized1);
     */  
        // Very large version numbers
        // Test numeric comparison
            fail("Should have thrown an exception");
        assertEquals("1.2.3-alpha.1", version.toString());
        // Uppercase comes before lowercase in ASCII  
        assertThat(SemanticVersion.parse("1.0.0-10").compareTo(SemanticVersion.parse("1.0.0-2")), greaterThan(0));
        assertEquals("00000000000999999999.00000000000999999999.00000000000999999999", normalized3);  
        // Test with small numbers that need padding
    public void testEdgeCases() {
            assertTrue(e.getCause() instanceof NumberFormatException);
            assertTrue(e.getMessage().contains("Invalid semantic version format"));
        // Build metadata should be ignored in precedence  
        SemanticVersion v1 = SemanticVersion.parse("1.0.0-alpha");
        SemanticVersion v4 = SemanticVersion.parse("1.0.0-alpha");
        // Stable release - should end with '~'
        assertThat(SemanticVersion.parse("1.0.0-alpha").compareTo(SemanticVersion.parse("1.0.0-1")), greaterThan(0));  
        // Long pre-release string  
    public void testPreReleaseIdentifierComparison() {
            "1.2.03",  
    public void testBuildMetadataComparison() {
    }
        SemanticVersion version = SemanticVersion.parse("1.2.3+build.123");
        // Test with larger numbers that need less padding
            "1.0.0-beta.11",
    }
    }
        SemanticVersion stable = SemanticVersion.parse("1.0.0");  
        SemanticVersion alpha = SemanticVersion.parse("1.0.0-alpha");  
 *
        assertEquals("1.2.3-alpha+build.123", version4.toString());  
        assertEquals("1.2.3-alpha", version2.toString());  
        assertThat(SemanticVersion.parse("1.0.0-alpha").compareTo(SemanticVersion.parse("1.0.0-alpha.1")), lessThan(0));
        );
        // Test that square brackets are removed during parsing
        assertEquals("Version string cannot be null or empty", e.getMessage());
        SemanticVersion version2 = SemanticVersion.parse("1  2  3");
        assertEquals(0, SemanticVersion.parse("1.0.0").compareTo(SemanticVersion.parse("1.0.0+build")));
     * Test to cover NumberFormatException handling in parse method
        assertTrue(normalized.contains("00000000000000000003"));  
