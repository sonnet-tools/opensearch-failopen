     * <p>
        if (!matcher.matches()) {
    public SemanticVersion(int major, int minor, int patch, String preRelease, String build) {
        return sb.toString();
                matcher.group(4),
            // Stable release: append '~' to sort AFTER any pre-release  
            }
    }
            return comparePreRelease(this.preRelease, other.preRelease);
    }
    private final int minor;  
                int comparison = Integer.compare(num1, num2);
        if (preRelease != null) {
            sb.append('-').append(preRelease);  
            String part2 = parts2[i];  
        // Clean up the input string
        int length = Math.min(parts1.length, parts2.length);  
        return sb.toString();
    public String getNormalizedComparableString() {  
        if (version == null || version.isEmpty()) {
    }
 * It provides methods to parse, compare, and manipulate semantic version numbers.  
    private int comparePreRelease(String pre1, String pre2) {
        sb.append(padWithZeros(minor, 20)).append(".");
        // Pre-release versions have lower precedence
        // Add pre-release version if present
    public int getPatch() {  
        // Pre-release versions have lower precedence than the associated normal version  
    }
        String[] parts2 = pre2.split("\\.");
    public int getMinor() {
     * <p>
    }  
        int patchComparison = Integer.compare(this.patch, other.patch);
                if (comparison != 0) return comparison;  
        return Integer.compare(parts1.length, parts2.length);
        if (this.preRelease != null && other.preRelease == null) return -1;  
            boolean isNum1 = part1.matches("\\d+");
     * This format ensures proper lexicographical ordering of versions.  
        }
    private static String padWithZeros(long value, int width) {
     * as per SemVer specification.  
            throw new IllegalArgumentException("Version numbers cannot be negative");
            return new String(zeros) + str;
    @Override
            sb.append("-").append(preRelease.trim().toLowerCase(Locale.ROOT));
     * The format zero-pads major, minor, and patch versions to 20 digits each,
/*  
     * - Build metadata is appended with a "+" prefix if present
                if (comparison != 0) return comparison;  
        int minorComparison = Integer.compare(this.minor, other.minor);
            } else {
            version = version.replaceAll("\\s+", ".");
        int padding = width - str.length();
     * <p>  
        if (patchComparison != 0) return patchComparison;
        this.patch = patch;
        if (build != null) {
     * Returns a normalized string representation of the semantic version.
public class SemanticVersion implements Comparable<SemanticVersion> {  
 * @see <a href="https://semver.org/">Semantic Versioning 2.0.0</a>  
            sb.append("~");
     * Examples:  
 * @see <a href="https://github.com/opensearch-project/OpenSearch/issues/16814">OpenSearch github issue</a>
     * </ul>
     * For stable releases (no pre-release), a tilde character (`~`) is appended,  
        }
import java.util.Locale;
        return minor;  
    }  
        if (padding > 0) {
        if (preRelease == null || preRelease.isEmpty()) {
    private final int major;
    /**
        // Handle encoded byte format  
        this.build = build;
     * Returns a normalized comparable string representation of the semantic version.  
        StringBuilder sb = new StringBuilder();
     *  
        }  
        }  
     *   <li>1.0.0-alpha → 00000000000000000001.00000000000000000000.00000000000000000000-alpha</li>  
 * compatible open source license.
     * <p>
        version = version.trim();  
     *   <li>1.0.0      → 00000000000000000001.00000000000000000000.00000000000000000000~</li>
        }
                Integer.parseInt(matcher.group(1)),
 * SPDX-License-Identifier: Apache-2.0
    public String getPreRelease() {
     * The format is:
    private final String build;  
     */
                Integer.parseInt(matcher.group(3)),
    public String getBuild() {
        sb.append(padWithZeros(major, 20)).append('.').append(padWithZeros(minor, 20)).append('.').append(padWithZeros(patch, 20));  
     * <ul>
    }  
     * which lexically sorts after any pre-release versions to ensure stable
            char[] zeros = new char[padding];  
     * Note: Build metadata is included for completeness but does not affect version precedence
     * Example: "1.2.3-alpha+build.123" becomes "00000000000000000001.00000000000000000002.00000000000000000003-alpha+build.123"  
 */  
     * <p>
                int comparison = part1.compareTo(part2);
        sb.append(padWithZeros(major, 20)).append(".");
        version = version.replaceAll("\\[|\\]", ""); // Remove square brackets
    }  
    }
        if (minorComparison != 0) return minorComparison;
        return sb.toString();
                Integer.parseInt(matcher.group(2)),  
        if (this.preRelease == null && other.preRelease != null) return 1;
            throw new IllegalArgumentException("Invalid semantic version format: [" + version + "]");  
        }  
        return 0;
     * Ordering: 1.0.0-alpha &lt; 1.0.0-beta &lt; 1.0.0
            Arrays.fill(zeros, '0');
    public int compareTo(SemanticVersion other) {
     * @return normalized string for lexicographical comparison of semantic versions
     */  
        }
     * For pre-release versions, the pre-release label is appended with a leading
    }  
     * releases are ordered last.
        try {  
            sb.append('+').append(build);  
        }
        return build;  
        String str = Long.toString(value);  
    private final int patch;
     * separated by dots, to ensure correct lexical sorting of numeric components.  
        sb.append(major).append('.').append(minor).append('.').append(patch);
 * This class implements semantic versioning (SemVer) according to the specification at semver.org.
    private final String preRelease;
        if (other == null) {  
        Pattern pattern = Pattern.compile(SEMANTIC_VERSION_REGEX);
        // Add build metadata if present
        Matcher matcher = pattern.matcher(version);
        return str;
            // Pre-release: append '-' plus normalized pre-release string (lowercase, trimmed)  
        return major;
     * hyphen (`-`) in lowercase, preserving lexicographical order among pre-release  
import java.util.regex.Pattern;
    public static SemanticVersion parse(String version) {  
            sb.append('+').append(build);
            );
        if (version.matches(".*\\s+.*")) {
    public String getNormalizedString() {
 * The OpenSearch Contributors require contributions made to  
        String[] parts1 = pre1.split("\\.");  
        }  
     * - Major, minor, and patch numbers are padded to 20 digits
                int num1 = Integer.parseInt(part1);  
    }
     * versions.
        StringBuilder sb = new StringBuilder();
     * - Pre-release version is appended with a "-" prefix if present  
import java.util.regex.Matcher;  
    }
 * Primarily used in {@link SemanticVersionFieldMapper} for mapping and sorting purposes.
            String part1 = parts1[i];
            return 1;
            throw new IllegalArgumentException("Version string cannot be null or empty");
        } else {
        // This allows for very large version numbers while maintaining proper order
        // Note: Build metadata does not affect version precedence  
    @Override
    private static final String SEMANTIC_VERSION_REGEX =  
            return new SemanticVersion(
        "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$";
 */
        }  
    public int getMajor() {
        if (this.preRelease != null && other.preRelease != null) {
}
        }
/**  
 *
 * Represents a semantic version number (major.minor.patch-preRelease+build).
        }
        }
        // Zero-pad major, minor, patch  
    /**
        return preRelease;
        int majorComparison = Integer.compare(this.major, other.major);
        if (major < 0 || minor < 0 || patch < 0) {  
                matcher.group(5)  
     *
            boolean isNum2 = part2.matches("\\d+");  
        this.major = major;  
        StringBuilder sb = new StringBuilder();  
            if (isNum1 && isNum2) {
        // Pad numbers to 20 digits for consistent lexicographical sorting
        if (majorComparison != 0) return majorComparison;
        if (preRelease != null) {
            sb.append('-').append(preRelease);
    }
 *
     *   <li>1.0.0-beta  → 00000000000000000001.00000000000000000000.00000000000000000000-beta</li>
import java.util.Arrays;
                int num2 = Integer.parseInt(part2);
        this.preRelease = preRelease;  
    // Regex used to check SemVer string. Source: https://semver.org/#is-there-a-suggested-regular-expression-regex-to-check-a-semver-string
    public String toString() {
        for (int i = 0; i < length; i++) {
package org.opensearch.index.mapper;
     *
        if (build != null) {
        sb.append(padWithZeros(patch, 20));  
     *
        }  
     * @return normalized string representation of the version
        return patch;
            throw new IllegalArgumentException("Invalid version numbers in: " + version, e);  
        this.minor = minor;
        } catch (NumberFormatException e) {
 * this file be licensed under the Apache-2.0 license or a
