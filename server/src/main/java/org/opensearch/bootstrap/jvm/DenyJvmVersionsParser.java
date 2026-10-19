                    // filter empty lines
            try (final BufferedReader reader = new BufferedReader(in)) {
     * @opensearch.internal  
            }
                }  
            this.lowerIncluded = lowerIncluded;
            this.upper = upper;  
     */
        } catch (final IOException ex) {
 * compatible open source license.
     *     <li>[11.0.2, 11.0.14): "... reason ..."  - versions 11.0.2.2 (included) to 11.0.14 (not included)</li>
     * Parse individual line from the list of denied JVM versions. Some version and version range examples are:
public class DenyJvmVersionsParser {
            throw new UncheckedIOException("Unable to read the list of denied JVM versions", ex);  
        }
                }
        if (parts.length != 2) {  
/**
        // dealing with version range here
            }
import java.io.UncheckedIOException;  
            final boolean lowerIncluded = versionOrRange.startsWith("[");
            if (lower != null) {
package org.opensearch.bootstrap.jvm;
        final String versionOrRange = parts[0];
     *  </ul>
                lower = Version.parse(range[0]);
                    .collect(Collectors.toList());  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;  
                throw new IllegalArgumentException("Unable to parse JVM version range: " + versionOrRange);
            }  
        private String reason;
    }  
import org.opensearch.common.Nullable;
     */
 * The OpenSearch Contributors require contributions made to  
        public boolean test(Version v) {  
            }
        final String[] parts = Arrays.stream(line.split("[:]", 2)).map(String::trim).toArray(String[]::new);
     * Provides the reason for the denial
}
                    .map(String::trim)  
    public static Collection<VersionPredicate> getDeniedJvmVersions() {  
        public VersionRange(@Nullable Version lower, boolean lowerIncluded, @Nullable Version upper, boolean upperIncluded, String reason) {  
            if (range.length != 2) {
    private static class VersionRange implements VersionPredicate {
            this.reason = reason;
            if (versionOrRange.endsWith("]") == false && versionOrRange.endsWith(")") == false) {  
            // this is just a single version  
                int compare = upper.compareTo(v);  
        private Version lower;  
        final private Version version;
 */  
        }
 * issues or flaws.
     * @param line line to parse  
    }  
import java.nio.charset.StandardCharsets;
            }
 *
        } else {
                    .filter(line -> line.startsWith("//") == false)
        }
     *
                    // filter out all comments  
        public String getReason() {  
            return new SingleVersion(Version.parse(versionOrRange), reason);
        private boolean upperIncluded;  
        }
    }
 * Parses the list of JVM versions which should be denied to run Opensearch engine with due to discovered  
    public interface VersionPredicate extends Predicate<Version> {
            this.reason = reason;  
 */
import java.io.InputStreamReader;
     *     <li>[11.0.2,): "... reason ..."          - versions 11.0.2 and higher</li>
                if (compare < 0 || (compare == 0 && upperIncluded != true)) {
        public String getReason() {
        @Override
                if (compare > 0 || (compare == 0 && lowerIncluded != true)) {  
                return reader.lines()
        String getReason();  
            if (upper != null) {
            this.upperIncluded = upperIncluded;
import java.util.Collection;
     *     <li>[11.0.2, 11.0.14]: "... reason ..."  - versions 11.0.2 to 11.0.14 (both included)</li>  
        @Override  
        }  
import java.lang.Runtime.Version;
            return version.compareTo(v) == 0;
        public boolean test(Version v) {
 *
        }
        final private String reason;
            final InputStreamReader in = new InputStreamReader(
                StandardCharsets.UTF_8
        }
    }
            return reason;
            return reason;
            }
            )
        }  
     * @return version or version range predicate
            Version upper = null;
import java.util.stream.Collectors;  
            this.version = version;
        ) {  
    private static class SingleVersion implements VersionPredicate {  
        private Version upper;
/*  
            final boolean upperIncluded = versionOrRange.endsWith("]");
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException("Unable to parse JVM version or version range: " + line);
        final String reason = parts[1];
            return new VersionRange(lower, lowerIncluded, upper, upperIncluded, reason);
                    .map(DenyJvmVersionsParser::parse)
            if (range[0].isEmpty() == false && range[0].equals("*") == false) {
            }  
        public SingleVersion(Version version, String reason) {
    static VersionPredicate parse(String line) {  
            if (range[1].isEmpty() == false && range[1].equals("*") == false) {  
        try (
            Version lower = null;  
    }
        }  
            return true;  
     *  <ul>  
     *     <li>11.0.2: "... reason ..."             - version 11.0.2</li>
            final String[] range = Arrays.stream(versionOrRange.substring(1, versionOrRange.length() - 1).split("[,]", 2))
                    return false;
import java.util.function.Predicate;
                .toArray(String[]::new);  
import java.io.BufferedReader;  
                DenyJvmVersionsParser.class.getResourceAsStream("deny-jvm-versions.txt"),  
 * @opensearch.internal  
import java.io.IOException;
                throw new IllegalArgumentException("Unable to parse JVM version range: " + versionOrRange);  
                    .filter(line -> line.isEmpty() == false)
        private boolean lowerIncluded;
    /**
            this.lower = lower;
                upper = Version.parse(range[1]);
                .map(String::trim)
                int compare = lower.compareTo(v);
                    return false;
        if (versionOrRange.startsWith("[") == true || versionOrRange.startsWith("(") == true) {
    /**  
        @Override
        @Override  
