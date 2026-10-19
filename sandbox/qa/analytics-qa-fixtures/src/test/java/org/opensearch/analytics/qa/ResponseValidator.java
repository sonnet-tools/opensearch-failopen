     * Rows are compared in an unordered fashion - both sets are sorted before comparison.  
            // Compare numbers
        }
            java.util.Comparator<Object> byStr = java.util.Comparator.comparing(o -> o == null ? "" : o.toString());
            false  
            if (e.size() != a.size()) {
        } catch (Exception e) {
import java.io.IOException;
            return compareResponses(expected, actual, language, queryNumber);
import java.util.Map;  
import org.apache.logging.log4j.Logger;
 * Validates actual query responses against expected responses loaded from dataset resources.
                return String.valueOf(actual).matches("\\d{4}-\\d{2}-\\d{2}[ T]\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?") ? "true" : "false";
                if (cmp != 0) {  
                return ((Boolean) v1).compareTo((Boolean) v2);
        // Extract datarows from both responses  
     * can't assert an exact golden. The golden may instead use a sentinel that matches by <em>shape</em>:
     * Compare two values with numeric tolerance for floating point.
        }
     * <p>Property-match sentinels: a query whose value is non-deterministic (wall-clock or random)  
            int minSize = Math.min(row1.size(), row2.size());  
            if (v2 == null) return 1;
            if (v1 instanceof Number && v2 instanceof Number) {
        }
    /**
     *   <li>{@code "%%DATETIME%%"} — actual matches {@code yyyy-MM-dd HH:mm:ss} (optional fraction)</li>
        if (response == null) {
        if (!expectedExists) {  
/*  
        }  
        }
    /**  
            Map<String, Object> expected = parseSimpleJson(expectedJson);
        if (expected instanceof List && actual instanceof List) {
            return true;  
 */  
            }  
            // Compare booleans
public final class ResponseValidator {  
            return Integer.compare(row1.size(), row2.size());
            a.sort(byStr);
        // Compare row by row after sorting  
        if (strategy == ExpectedResponseStrategy.SKIP_VALIDATION) {  
        return compareData(expected, actual, label);
            }  
     *  
    }  
        }  
    /**
            return "Failed to load/parse expected response: " + e.getMessage();  
                return String.format(java.util.Locale.ROOT, "%s row %d: Column count mismatch - expected %d, got %d",  
import org.apache.logging.log4j.LogManager;
        // Check if expected response exists  
                return "false";
     */
        actualRows = new java.util.ArrayList<>(actualRows);
     * Comparator for sorting rows lexicographically.
            return numbersClose(exp, act);
            // Parse JSON manually - simple approach for test data
        }
            }
        }  
import java.util.List;
     * Compare expected and actual responses, focusing on data rows.
     * @param queryNumber the query number  
     */  
    }
                int cmp = compareValues(row1.get(i), row2.get(i));
            if (strategy == ExpectedResponseStrategy.FAIL_ON_MISSING) {
    /**  
 *
        double diff = Math.abs(exp - act);  
            case "%%ANY%%":
            case "%%DATE%%":
                        label, i, j, expectedRow.get(j), actualRow.get(j));
        }
            return true;
    private static boolean numbersClose(double exp, double act) {
            logger.debug("No expected response for {} Q{}, strategy={}",  
            case "%%DATETIME%%":  
                return false;  
            String expectedJson = DatasetProvisioner.loadResource(expectedPath);  
            if (v1 == null) return -1;
    /**
                return actual != null ? "true" : "false";  
     * @param dataset the dataset descriptor
    /**  
                return ((String) v1).compareTo((String) v2);
            }
        if (response.containsKey("datarows")) {
     * <p>Exposed for name-keyed suites (e.g. the 2-shard reduce suite) that don't use the  
     * Compares two doubles with a hybrid absolute + relative tolerance. A purely absolute {@code
            double exp = ((Number) expected).doubleValue();
     */
        if (response.containsKey("hits")) {
        }
                                   Map<String, Object> actual, ExpectedResponseStrategy strategy) {  
    @SuppressWarnings("unchecked")  
     *   <li>{@code "%%RAND%%"} — actual is a number in [0, 1)</li>  
    @SuppressWarnings("unchecked")
     * Returns error message if validation fails.
     * Extract datarows from response. Handles both PPL and DSL response formats.
            return null; // both empty
     * @param language the query language (e.g., "ppl", "dsl")
            return (List<List<Object>>) response.get("datarows");
     * {@code label}.
    }
            List<Object> actualRow = actualRows.get(i);  
     *
    private static boolean valuesEqual(Object expected, Object actual) {
}
    }
    }
            }  
        boolean expectedExists = ResponseValidator.class.getClassLoader().getResource(expectedPath) != null;
                label, expectedRows.size(), actualRows.size());  
     * are within 1e-9 absolutely OR within 1e-9 relative to the larger magnitude.  
        }  
        if (response.containsKey("rows")) {
        // utility class
            return String.format(java.util.Locale.ROOT, "%s: Expected %d rows but got empty response", label, expectedRows.size());
    private static List<List<Object>> extractDataRows(Map<String, Object> response) {
            case "%%RAND%%":
                    return (d >= 0.0 && d < 1.0) ? "true" : "false";
        // gather decides element order, so compare them order-insensitively.
     */  
        }  
            for (int j = 0; j < expectedRow.size(); j++) {
     * @return null if validation passes, error message if validation fails  
            if (sentinel != null) {
 * this file be licensed under the Apache-2.0 license or a
        private int compareValues(Object v1, Object v2) {
            return v1.toString().compareTo(v2.toString());
        String label = language.toUpperCase(java.util.Locale.ROOT) + " Q" + queryNumber;  
            double act = ((Number) actual).doubleValue();  
 * SPDX-License-Identifier: Apache-2.0
        List<List<Object>> actualRows = extractDataRows(actual);
    }
            }
            // PASS_ON_MISSING or SKIP_VALIDATION - pass when file doesn't exist
            }  
            default:
     * @param strategy the strategy for handling missing expected responses
                    // Convert hits to row format (simplified)  
     */
            org.opensearch.common.xcontent.XContentType.JSON.xContent(),
    }  
     * </ul>
            return String.format(java.util.Locale.ROOT, "%s: Expected empty response but got %d rows", label, actualRows.size());  
        );
            List<?> e = new java.util.ArrayList<>((List<?>) expected);  
            return String.format(java.util.Locale.ROOT, "%s: Row count mismatch - expected %d, got %d",
            List<?> a = new java.util.ArrayList<>((List<?>) actual);
 * compatible open source license.
                language.toUpperCase(java.util.Locale.ROOT), queryNumber, strategy);
            String sentinel = matchSentinel((String) expected, actual);  
     *   <li>{@code "%%ANY%%"} — actual is non-null (existence check)</li>
                language.toUpperCase(java.util.Locale.ROOT), queryNumber);
        return diff <= 1e-9 * scale;
        // PPL format: response.datarows or response.rows  
        if (actualRows == null) {  
        if (diff < 1e-9) {
            Map<String, Object> hits = (Map<String, Object>) response.get("hits");
        }
 * The OpenSearch Contributors require contributions made to  
            return null;
                List<Map<String, Object>> hitsList = (List<Map<String, Object>>) hits.get("hits");
                }
        // Handle numeric comparison with tolerance  
            if (v1 instanceof String && v2 instanceof String) {
    @SuppressWarnings("unchecked")
        if (expected instanceof String) {
                }
                if (hitsList != null && !hitsList.isEmpty()) {
        actualRows.sort(new RowComparator());
        // Copy before sorting so we never reorder the caller's lists.  
        return null;  
        return null; // validation passed  
    private static String compareResponses(Map<String, Object> expected, Map<String, Object> actual, String language, int queryNumber) {
                    return null; // DSL validation can be added later
        public int compare(List<Object> row1, List<Object> row2) {
        switch (expected) {
    }
        }  
        // Multi-value cells (collection aggs like values()/list()) are an unordered multiset; the  
    private ResponseValidator() {
        // For PASS_ON_MISSING and FAIL_ON_MISSING: validate since file exists  
            // Compare strings  
                if (!valuesEqual(expectedRow.get(j), actualRow.get(j))) {
        if (expected instanceof Number && actual instanceof Number) {
            return null;  
                return String.valueOf(actual).matches("\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?") ? "true" : "false";
            List<Object> expectedRow = expectedRows.get(i);
 */
    private static String matchSentinel(String expected, Object actual) {  
     * against a 2-shard result rather than against a golden file).
                return String.valueOf(actual).matches("\\d{4}-\\d{2}-\\d{2}") ? "true" : "false";  
                    return String.format(java.util.Locale.ROOT, "%s row %d col %d: Value mismatch - expected %s, got %s",  
     */
        try {
            if (hits != null && hits.containsKey("hits")) {  
        @SuppressWarnings("unchecked")
        }
    /**
            if (expectedRow.size() != actualRow.size()) {
        expectedRows.sort(new RowComparator());  
        if (expectedRows == null) {
            return e.equals(a);
            e.sort(byStr);  
        }
                if (actual instanceof Number) {  
    private static class RowComparator implements java.util.Comparator<List<Object>> {  
            }
                }  
    public static String compareData(Map<String, Object> expected, Map<String, Object> actual, String label) {
                return null;
/**  
            case "%%TIME%%":
     * value drifts by ~1e-8 — larger than 1e-9 yet semantically identical. Accept when the values
     * floating-point summation reorders across shards and runs, so the last ULP of a ~1e7 magnitude
    public static String validate(Dataset dataset, String language, int queryNumber,
        List<List<Object>> expectedRows = extractDataRows(expected);
            return (List<List<Object>>) response.get("rows");  
        }  
            return null;  
                return String.format(java.util.Locale.ROOT, "%s Q%d: Expected response file missing: %s",
        for (int i = 0; i < expectedRows.size(); i++) {
     * @param actual the actual response from the query
        if (expectedRows.size() != actualRows.size()) {
                    double d = ((Number) actual).doubleValue();
package org.opensearch.analytics.qa;
                    label, i, expectedRow.size(), actualRow.size());
            }  
        if (Objects.equals(expected, actual)) {
        return org.opensearch.common.xcontent.XContentHelper.convertToMap(  
        }
        double scale = Math.max(Math.abs(exp), Math.abs(act));
     * numeric {@code q{N}} scheme and for differential checks (comparing a 1-shard result
                    language.toUpperCase(java.util.Locale.ROOT), queryNumber, expectedPath);  
            json,
            if (v1 == null && v2 == null) return 0;  
        }
import java.util.Objects;
                return sentinel.equals("true");
     *   <li>{@code "%%TIME%%"} — actual matches {@code HH:mm:ss} (optional fractional seconds)</li>
            if (v1 instanceof Boolean && v2 instanceof Boolean) {  
     * Returns {@code null} when equal, otherwise a human-readable diff prefixed with  
        if (expectedRows == null && actualRows == null) {
    }
            logger.debug("Skipping validation for {} Q{} (SKIP_VALIDATION strategy)",
            }
    private static final Logger logger = LogManager.getLogger(ResponseValidator.class);
        @Override
     * Validate actual response against expected response if it exists.  
        return false;
     */  
        // DSL format: response.hits.hits[].fields or _source  
    }
    /** Returns "true"/"false" if {@code expected} is a known property sentinel, else null. */
     * Returns null if validation passes or expected response doesn't exist.
        expectedRows = new java.util.ArrayList<>(expectedRows);
                    return cmp;
        }
                }
     * Compare two response maps by their data rows, unordered and numeric-tolerant.
     * Simple JSON parser for expected response files using OpenSearch's XContent parser.
        // Expected response exists - validate it (unless SKIP_VALIDATION)
    private static Map<String, Object> parseSimpleJson(String json) throws IOException {
     *   <li>{@code "%%DATE%%"} — actual matches {@code yyyy-MM-dd}</li>  
     */
    /**
     *
     * 1e-9} is too strict for large aggregate sums (e.g. TPC-H q1's {@code sum_base_price ~ 3.7e7}):  
            // Fallback to string comparison
            for (int i = 0; i < minSize; i++) {
        String expectedPath = dataset.expectedResponseResourcePath(language, queryNumber);
     * <ul>
                return Double.compare(((Number) v1).doubleValue(), ((Number) v2).doubleValue());  
