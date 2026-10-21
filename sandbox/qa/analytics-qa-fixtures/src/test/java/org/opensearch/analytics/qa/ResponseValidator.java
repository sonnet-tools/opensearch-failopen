            false
        expectedRows.sort(new RowComparator());
     * {@code label}.
            case "%%DATETIME%%":
        return org.opensearch.common.xcontent.XContentHelper.convertToMap(
    private static String matchSentinel(String expected, Object actual) {
        }
     * are within 1e-9 absolutely OR within 1e-9 relative to the larger magnitude.
        }
    /**
    }
                    return cmp;
    /**
        if (expected instanceof List && actual instanceof List) {
    }
            double exp = ((Number) expected).doubleValue();
    }
    @SuppressWarnings("unchecked")
        double scale = Math.max(Math.abs(exp), Math.abs(act));
        );
            if (v1 instanceof Number && v2 instanceof Number) {
        }
        private int compareValues(Object v1, Object v2) {
            return numbersClose(exp, act);
            return Integer.compare(row1.size(), row2.size());
     *   <li>{@code "%%DATE%%"} — actual matches {@code yyyy-MM-dd}</li>
            List<?> a = new java.util.ArrayList<>((List<?>) actual);
        }
        }
                return null;
    /**
                return String.format(java.util.Locale.ROOT, "%s row %d: Column count mismatch - expected %d, got %d",
                return ((Boolean) v1).compareTo((Boolean) v2);
     * Extract datarows from response. Handles both PPL and DSL response formats.
            return v1.toString().compareTo(v2.toString());
                return String.format(java.util.Locale.ROOT, "%s Q%d: Expected response file missing: %s",
        // gather decides element order, so compare them order-insensitively.
     */
     *   <li>{@code "%%RAND%%"} — actual is a number in [0, 1)</li>
        }
     * @param actual the actual response from the query
            if (v1 == null) return -1;
            // PASS_ON_MISSING or SKIP_VALIDATION - pass when file doesn't exist
            if (strategy == ExpectedResponseStrategy.FAIL_ON_MISSING) {
        // utility class
            case "%%DATE%%":
                return false;
package org.opensearch.analytics.qa;
     *   <li>{@code "%%ANY%%"} — actual is non-null (existence check)</li>
     * value drifts by ~1e-8 — larger than 1e-9 yet semantically identical. Accept when the values
    /**
            return null;
        switch (expected) {
        // Compare row by row after sorting
            if (v2 == null) return 1;
            if (expectedRow.size() != actualRow.size()) {
                    // Convert hits to row format (simplified)
            }
        // For PASS_ON_MISSING and FAIL_ON_MISSING: validate since file exists
    }
        boolean expectedExists = ResponseValidator.class.getClassLoader().getResource(expectedPath) != null;
     *
            }
        if (response.containsKey("rows")) {
    /**
    @SuppressWarnings("unchecked")
        return diff <= 1e-9 * scale;
     *
                }
            if (e.size() != a.size()) {
        // Expected response exists - validate it (unless SKIP_VALIDATION)
     * numeric {@code q{N}} scheme and for differential checks (comparing a 1-shard result
import java.util.List;
        }
     * can't assert an exact golden. The golden may instead use a sentinel that matches by <em>shape</em>:
            // Fallback to string comparison
 * compatible open source license.
 *
 * Validates actual query responses against expected responses loaded from dataset resources.
    public static String validate(Dataset dataset, String language, int queryNumber,
     * @param language the query language (e.g., "ppl", "dsl")
                int cmp = compareValues(row1.get(i), row2.get(i));
        }
     * @param strategy the strategy for handling missing expected responses
                return sentinel.equals("true");
        // Handle numeric comparison with tolerance
        for (int i = 0; i < expectedRows.size(); i++) {
     * Compare expected and actual responses, focusing on data rows.
        // Copy before sorting so we never reorder the caller's lists.
                }
        if (strategy == ExpectedResponseStrategy.SKIP_VALIDATION) {
            if (sentinel != null) {
     * floating-point summation reorders across shards and runs, so the last ULP of a ~1e7 magnitude
                    return null; // DSL validation can be added later
                        label, i, j, expectedRow.get(j), actualRow.get(j));
        }
        }
        // PPL format: response.datarows or response.rows
                    return (d >= 0.0 && d < 1.0) ? "true" : "false";
/*
        public int compare(List<Object> row1, List<Object> row2) {
            a.sort(byStr);
     * Returns null if validation passes or expected response doesn't exist.
            case "%%RAND%%":
        }
            }
            return true;
        // Extract datarows from both responses
        if (expectedRows == null && actualRows == null) {
        return null; // validation passed
            case "%%ANY%%":
            return (List<List<Object>>) response.get("datarows");
    public static String compareData(Map<String, Object> expected, Map<String, Object> actual, String label) {
                }
                language.toUpperCase(java.util.Locale.ROOT), queryNumber);
import java.util.Map;
     * Rows are compared in an unordered fashion - both sets are sorted before comparison.
            json,
            }
    }
        String label = language.toUpperCase(java.util.Locale.ROOT) + " Q" + queryNumber;
            }
        actualRows.sort(new RowComparator());
            Map<String, Object> expected = parseSimpleJson(expectedJson);
import java.io.IOException;
            return (List<List<Object>>) response.get("rows");
        List<List<Object>> actualRows = extractDataRows(actual);
                if (cmp != 0) {
 * this file be licensed under the Apache-2.0 license or a
                return "false";
import java.util.Objects;
            return null; // both empty
import org.apache.logging.log4j.Logger;
            case "%%TIME%%":
        double diff = Math.abs(exp - act);
        if (Objects.equals(expected, actual)) {
    private static boolean valuesEqual(Object expected, Object actual) {
    }
     */
        String expectedPath = dataset.expectedResponseResourcePath(language, queryNumber);
                    label, i, expectedRow.size(), actualRow.size());
     * @param dataset the dataset descriptor
     * Returns {@code null} when equal, otherwise a human-readable diff prefixed with
            // Compare strings
/**
            return compareResponses(expected, actual, language, queryNumber);
        if (response.containsKey("datarows")) {
            return null;
            // Parse JSON manually - simple approach for test data
            if (v1 instanceof Boolean && v2 instanceof Boolean) {
 * The OpenSearch Contributors require contributions made to
        if (expectedRows.size() != actualRows.size()) {
        // Multi-value cells (collection aggs like values()/list()) are an unordered multiset; the
    }
     */
     * Validate actual response against expected response if it exists.
                    return String.format(java.util.Locale.ROOT, "%s row %d col %d: Value mismatch - expected %s, got %s",
     * Compare two values with numeric tolerance for floating point.
            java.util.Comparator<Object> byStr = java.util.Comparator.comparing(o -> o == null ? "" : o.toString());
import org.apache.logging.log4j.LogManager;
            String expectedJson = DatasetProvisioner.loadResource(expectedPath);
 */
     *   <li>{@code "%%TIME%%"} — actual matches {@code HH:mm:ss} (optional fractional seconds)</li>
            return "Failed to load/parse expected response: " + e.getMessage();
        }
            List<?> e = new java.util.ArrayList<>((List<?>) expected);
            for (int i = 0; i < minSize; i++) {
    /**
        return null;
        }
        // DSL format: response.hits.hits[].fields or _source
        if (!expectedExists) {
        expectedRows = new java.util.ArrayList<>(expectedRows);
     * @param queryNumber the query number
            return String.format(java.util.Locale.ROOT, "%s: Expected %d rows but got empty response", label, expectedRows.size());
    private static List<List<Object>> extractDataRows(Map<String, Object> response) {
     * Compare two response maps by their data rows, unordered and numeric-tolerant.
     *   <li>{@code "%%DATETIME%%"} — actual matches {@code yyyy-MM-dd HH:mm:ss} (optional fraction)</li>
        actualRows = new java.util.ArrayList<>(actualRows);
        if (expected instanceof String) {
        }
        if (response.containsKey("hits")) {
                                   Map<String, Object> actual, ExpectedResponseStrategy strategy) {
                return String.valueOf(actual).matches("\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?") ? "true" : "false";
            // Compare booleans
    private static boolean numbersClose(double exp, double act) {
                if (actual instanceof Number) {
            return null;
            if (v1 instanceof String && v2 instanceof String) {
                    language.toUpperCase(java.util.Locale.ROOT), queryNumber, expectedPath);
     * against a 2-shard result rather than against a golden file).
            return String.format(java.util.Locale.ROOT, "%s: Row count mismatch - expected %d, got %d",
            double act = ((Number) actual).doubleValue();
            logger.debug("No expected response for {} Q{}, strategy={}",
                return ((String) v1).compareTo((String) v2);
     */
        if (diff < 1e-9) {
            for (int j = 0; j < expectedRow.size(); j++) {
    private static String compareResponses(Map<String, Object> expected, Map<String, Object> actual, String language, int queryNumber) {
                }
     * Compares two doubles with a hybrid absolute + relative tolerance. A purely absolute {@code
            }
                List<Map<String, Object>> hitsList = (List<Map<String, Object>>) hits.get("hits");
     * Comparator for sorting rows lexicographically.
            String sentinel = matchSentinel((String) expected, actual);
public final class ResponseValidator {
                    double d = ((Number) actual).doubleValue();
    }
     */
        }
            e.sort(byStr);
        try {
    private static class RowComparator implements java.util.Comparator<List<Object>> {
        if (response == null) {
    /** Returns "true"/"false" if {@code expected} is a known property sentinel, else null. */
}
        return false;
                language.toUpperCase(java.util.Locale.ROOT), queryNumber, strategy);
     * 1e-9} is too strict for large aggregate sums (e.g. TPC-H q1's {@code sum_base_price ~ 3.7e7}):
    @SuppressWarnings("unchecked")
            List<Object> expectedRow = expectedRows.get(i);
            org.opensearch.common.xcontent.XContentType.JSON.xContent(),
                return actual != null ? "true" : "false";
            return e.equals(a);
                if (hitsList != null && !hitsList.isEmpty()) {
        } catch (Exception e) {
     */
            }
            return String.format(java.util.Locale.ROOT, "%s: Expected empty response but got %d rows", label, actualRows.size());
        // Check if expected response exists
    }
                return String.valueOf(actual).matches("\\d{4}-\\d{2}-\\d{2}") ? "true" : "false";
            }
        @Override
        if (actualRows == null) {
    private static final Logger logger = LogManager.getLogger(ResponseValidator.class);
     */
     * <p>Exposed for name-keyed suites (e.g. the 2-shard reduce suite) that don't use the
 * SPDX-License-Identifier: Apache-2.0
    }
            List<Object> actualRow = actualRows.get(i);
     *
                return Double.compare(((Number) v1).doubleValue(), ((Number) v2).doubleValue());
        List<List<Object>> expectedRows = extractDataRows(expected);
                return String.valueOf(actual).matches("\\d{4}-\\d{2}-\\d{2}[ T]\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?") ? "true" : "false";
            }
 */
            default:
        @SuppressWarnings("unchecked")
            Map<String, Object> hits = (Map<String, Object>) response.get("hits");
        }
            if (hits != null && hits.containsKey("hits")) {
                if (!valuesEqual(expectedRow.get(j), actualRow.get(j))) {
    /**
        if (expectedRows == null) {
        }
            if (v1 == null && v2 == null) return 0;
     * <p>Property-match sentinels: a query whose value is non-deterministic (wall-clock or random)
    private ResponseValidator() {
    /**
     * <ul>
        }
            int minSize = Math.min(row1.size(), row2.size());
            }
     * Returns error message if validation fails.
            return true;
        if (expected instanceof Number && actual instanceof Number) {
        }
    private static Map<String, Object> parseSimpleJson(String json) throws IOException {
     * @return null if validation passes, error message if validation fails
     * Simple JSON parser for expected response files using OpenSearch's XContent parser.
     * </ul>
     */
                label, expectedRows.size(), actualRows.size());
            logger.debug("Skipping validation for {} Q{} (SKIP_VALIDATION strategy)",
            // Compare numbers
        return compareData(expected, actual, label);
        }
