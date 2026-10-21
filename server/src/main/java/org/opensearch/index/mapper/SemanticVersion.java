     */
        if (version == null || version.isEmpty()) {
     *
        } catch (NumberFormatException e) {
        sb.append(padWithZeros(major, 20)).append('.').append(padWithZeros(minor, 20)).append('.').append(padWithZeros(patch, 20));
        }
    @Override
            if (isNum1 && isNum2) {
                Integer.parseInt(matcher.group(1)),
            version = version.replaceAll("\\s+", ".");
    public String getNormalizedComparableString() {
        if (minorComparison != 0) return minorComparison;
            String part1 = parts1[i];
        }
        this.major = major;
        StringBuilder sb = new StringBuilder();
     * </ul>
 * compatible open source license.
        sb.append(padWithZeros(patch, 20));
        if (preRelease == null || preRelease.isEmpty()) {
     * Returns a normalized string representation of the semantic version.
    public String getNormalizedString() {
        return Integer.compare(parts1.length, parts2.length);
     * which lexically sorts after any pre-release versions to ensure stable
    public int getMajor() {
        return patch;
        sb.append(padWithZeros(major, 20)).append(".");
 * The OpenSearch Contributors require contributions made to
            );
            throw new IllegalArgumentException("Version numbers cannot be negative");
            }
    public SemanticVersion(int major, int minor, int patch, String preRelease, String build) {
 *
    private final int minor;
                matcher.group(5)
/*
        }
        int patchComparison = Integer.compare(this.patch, other.patch);
/**
        StringBuilder sb = new StringBuilder();
 * It provides methods to parse, compare, and manipulate semantic version numbers.
    private final int major;
        if (other == null) {
     *
     * @return normalized string representation of the version
        this.preRelease = preRelease;
        try {
    public String getPreRelease() {
            } else {
        // Pre-release versions have lower precedence
            sb.append('+').append(build);
        if (major < 0 || minor < 0 || patch < 0) {
     * <p>
        sb.append(major).append('.').append(minor).append('.').append(patch);
        this.build = build;
                Integer.parseInt(matcher.group(2)),
     * - Build metadata is appended with a "+" prefix if present
            boolean isNum2 = part2.matches("\\d+");
    private final int patch;
     */
            String part2 = parts2[i];
        }
     *   <li>1.0.0-alpha → 00000000000000000001.00000000000000000000.00000000000000000000-alpha</li>
 * Primarily used in {@link SemanticVersionFieldMapper} for mapping and sorting purposes.
            return new String(zeros) + str;
    }
    }
        String[] parts2 = pre2.split("\\.");
            throw new IllegalArgumentException("Version string cannot be null or empty");
            throw new IllegalArgumentException("Invalid semantic version format: [" + version + "]");
            // Stable release: append '~' to sort AFTER any pre-release
        if (this.preRelease != null && other.preRelease != null) {
        if (build != null) {
    public int compareTo(SemanticVersion other) {
                int num2 = Integer.parseInt(part2);
    }
}
        return build;
     * Example: "1.2.3-alpha+build.123" becomes "00000000000000000001.00000000000000000002.00000000000000000003-alpha+build.123"
        if (this.preRelease == null && other.preRelease != null) return 1;
        sb.append(padWithZeros(minor, 20)).append(".");
     * versions.
import java.util.Arrays;
        this.patch = patch;
        // Handle encoded byte format
        if (preRelease != null) {
        // Zero-pad major, minor, patch
        // Pad numbers to 20 digits for consistent lexicographical sorting
 * This class implements semantic versioning (SemVer) according to the specification at semver.org.
        if (patchComparison != 0) return patchComparison;
        String[] parts1 = pre1.split("\\.");
     *
    /**
        return minor;
 */
    }
     * <p>
        if (version.matches(".*\\s+.*")) {
        int minorComparison = Integer.compare(this.minor, other.minor);
     * Examples:
        if (this.preRelease != null && other.preRelease == null) return -1;
     * Returns a normalized comparable string representation of the semantic version.
    }
            sb.append('+').append(build);
        return preRelease;
    }
    public static SemanticVersion parse(String version) {
    }
 * @see <a href="https://semver.org/">Semantic Versioning 2.0.0</a>
            throw new IllegalArgumentException("Invalid version numbers in: " + version, e);
    private static String padWithZeros(long value, int width) {
        int padding = width - str.length();
     * <ul>
     * Ordering: 1.0.0-alpha &lt; 1.0.0-beta &lt; 1.0.0
 * this file be licensed under the Apache-2.0 license or a
        "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$";
            sb.append("~");
        if (preRelease != null) {
        version = version.replaceAll("\\[|\\]", ""); // Remove square brackets
 */
     * - Major, minor, and patch numbers are padded to 20 digits
    /**
import java.util.regex.Matcher;
        return sb.toString();
            Arrays.fill(zeros, '0');
     * This format ensures proper lexicographical ordering of versions.
    }
    private final String preRelease;
     * as per SemVer specification.
    public String toString() {
     * separated by dots, to ensure correct lexical sorting of numeric components.
        // Add build metadata if present
        // This allows for very large version numbers while maintaining proper order
        } else {
            boolean isNum1 = part1.matches("\\d+");
    }
        }
 *
            // Pre-release: append '-' plus normalized pre-release string (lowercase, trimmed)
        if (majorComparison != 0) return majorComparison;
                int comparison = Integer.compare(num1, num2);
                int comparison = part1.compareTo(part2);
 * Represents a semantic version number (major.minor.patch-preRelease+build).
     *
        }
        }
    }
import java.util.regex.Pattern;
        if (!matcher.matches()) {
    public int getMinor() {
        }
        // Add pre-release version if present
     * <p>
        version = version.trim();
        if (padding > 0) {
     * For stable releases (no pre-release), a tilde character (`~`) is appended,
     * @return normalized string for lexicographical comparison of semantic versions
     * hyphen (`-`) in lowercase, preserving lexicographical order among pre-release
    public int getPatch() {
        return 0;
     * <p>
    // Regex used to check SemVer string. Source: https://semver.org/#is-there-a-suggested-regular-expression-regex-to-check-a-semver-string
        String str = Long.toString(value);
    }
    private int comparePreRelease(String pre1, String pre2) {
            return 1;
            sb.append('-').append(preRelease);
    private final String build;
            char[] zeros = new char[padding];
     * <p>
        return major;
     * Note: Build metadata is included for completeness but does not affect version precedence
        }
            sb.append("-").append(preRelease.trim().toLowerCase(Locale.ROOT));
                Integer.parseInt(matcher.group(3)),
            sb.append('-').append(preRelease);
        StringBuilder sb = new StringBuilder();
        }
        }
        Matcher matcher = pattern.matcher(version);
        // Note: Build metadata does not affect version precedence
                if (comparison != 0) return comparison;
    @Override
package org.opensearch.index.mapper;
            return comparePreRelease(this.preRelease, other.preRelease);
     * - Pre-release version is appended with a "-" prefix if present
        }
                int num1 = Integer.parseInt(part1);
     * For pre-release versions, the pre-release label is appended with a leading
        int length = Math.min(parts1.length, parts2.length);
        return sb.toString();
        this.minor = minor;
    }
    private static final String SEMANTIC_VERSION_REGEX =
                matcher.group(4),
public class SemanticVersion implements Comparable<SemanticVersion> {
                if (comparison != 0) return comparison;
     * The format zero-pads major, minor, and patch versions to 20 digits each,
        // Pre-release versions have lower precedence than the associated normal version
        if (build != null) {
        for (int i = 0; i < length; i++) {
        }
    }
 * @see <a href="https://github.com/opensearch-project/OpenSearch/issues/16814">OpenSearch github issue</a>
        Pattern pattern = Pattern.compile(SEMANTIC_VERSION_REGEX);
 * SPDX-License-Identifier: Apache-2.0
     *   <li>1.0.0      → 00000000000000000001.00000000000000000000.00000000000000000000~</li>
     * releases are ordered last.
import java.util.Locale;
        }
        int majorComparison = Integer.compare(this.major, other.major);
            return new SemanticVersion(
     *   <li>1.0.0-beta  → 00000000000000000001.00000000000000000000.00000000000000000000-beta</li>
        // Clean up the input string
        return sb.toString();
     * The format is:
        return str;
    public String getBuild() {
