        long expectedTotal = asLong(goldenHits.get("total"));
import java.util.TreeMap;
            );
    private static String compareSource(Map<String, Object> expected, Map<String, Object> actual, String label) {  
            return true;
            return label + ": no golden file at " + goldenPath;  
import java.util.Locale;
}
            }
        }
            List<String> parts = new ArrayList<>();  
        try {
                    e.getKey(),
                expectedSources.size(),  
 * <p><b>The expected answer is the TRUE answer, not parquet's answer.</b> Expected answers are generated  
import java.util.Map;  
 * SPDX-License-Identifier: Apache-2.0
                "%s: hit count mismatch - expected %d sources, got %d",
        if (total instanceof Map) {  
        return org.opensearch.common.xcontent.XContentHelper.convertToMap(
                );
            out.add(src instanceof Map ? (Map<String, Object>) src : Map.of());
            org.opensearch.common.xcontent.XContentType.JSON.xContent(),
import java.util.Comparator;  
        );
 * The OpenSearch Contributors require contributions made to  
            return String.format(
                new TreeMap<>(expected).keySet(),  
        if (o instanceof List) {
            return String.format(Locale.ROOT, "%s: total mismatch - expected %d, got %d", label, expectedTotal, actualTotal);
        if (expected.size() != actual.size()) {
 *     "hits": {
    // ── extraction from a live response ────────────────────────────────────────  
                }
            List<Object> expectedList = (List<Object>) expected;
            return sb.append("}").toString();  
                    e.getValue(),
            }
        if (expectedSources.size() != actualSources.size()) {
    private static String canonical(Object o) {  
        }
    }
                return false;
/*  
                label,
            if (diff != null) {
        return out;
            return Math.abs(((Number) expected).doubleValue() - ((Number) actual).doubleValue()) < NUMERIC_TOLERANCE;
 *
 * query that legitimately matches nothing.
            }  
            return '"' + (String) o + '"';  
 * <p>Golden files live at {@code datasets/<type>/dsl/expected/q<N>.json} and capture the meaningful
 * parquet response against the committed expected answer, so any place parquet deviates (null text  
                sb.append('"').append(e.getKey()).append("\":").append(canonical(e.getValue()));
            TreeMap<String, Object> sorted = new TreeMap<>((Map<String, Object>) o);
        }
                parts.add(canonical(e));
    // ── helpers ──────────────────────────────────────────────────────────────
                if (!valuesEqual(expectedList.get(i), actualList.get(i))) {  
        if (expectedTotal != actualTotal) {  
 * empty (or absent) {@code sources} is a perfectly valid golden — e.g. an aggregation-only query or a  
            }
import java.util.ArrayList;
     */  
        }
        List<Map<String, Object>> out = new ArrayList<>();
            if (!valuesEqual(e.getValue(), actual.get(e.getKey()))) {
        List<Map<String, Object>> actualSources = extractSources(actual);
        exp.sort(byCanonical);  
    private static String compare(Map<String, Object> golden, Map<String, Object> actual, String label) {
 *       "sources": [ { ... _source ... }, ... ]   // hit ordering ignored; array values within a _source are not
        return Objects.equals(expected, actual);  
    /** Canonical string form of a source map: keys sorted recursively, for order-independent compare. */
 *     }
    }
                Locale.ROOT,  
            return String.format(
            // are not collapsed during hit pairing. Hit *list* ordering is still ignored — see compare().
            Object src = hit.get("_source");
            // Preserve element order so that array-order differences yield distinct canonical keys and
        }
                new TreeMap<>(actual).keySet()
     * @return {@code null} when validation passes; otherwise a human-readable failure message
        Object total = hits.get("total");
    private DslResponseValidator() {}  
import java.util.Objects;
        if (expected instanceof Number && actual instanceof Number) {  
    }
                "%s: field count mismatch - expected %s, got %s",
            return label + ": failed to load/parse golden " + goldenPath + ": " + e.getMessage();
    private static long extractTotal(Map<String, Object> response) {  
    @SuppressWarnings("unchecked")  
        return null;
    }  
    @SuppressWarnings("unchecked")
        return null;  
 * (hit ordering is ignored), but values <i>within</i> a {@code _source} — including array fields such as
        }
                    Locale.ROOT,
        if (o instanceof String) {
        } catch (Exception e) {  
        List<Map<String, Object>> out = new ArrayList<>();  
            // must match element-for-element in the same order. Compare positionally; do not sort.
        }
    }
                return String.format(  
            String diff = compareSource(exp.get(i), act.get(i), label + " source " + i);
        return String.valueOf(o);
 * </pre>
    }
/**
        return compare(golden, actual, label);
                    sb.append(",");
    private static long asLong(Object o) {
 * {@code _source}, multi-valued keyword / custom-id / geo / nested failures) correctly shows red. This
    private static List<Map<String, Object>> extractSources(Map<String, Object> response) {
            for (Object e : (List<Object>) o) {
            false
        Map<String, Object> hits = (Map<String, Object>) response.get("hits");
            return asLong(((Map<String, Object>) total).get("value"));
 * this file be licensed under the Apache-2.0 license or a
            StringBuilder sb = new StringBuilder("{");  
import java.util.List;
        List<Map<String, Object>> expectedSources = asSourceList(goldenHits.get("sources"));
 * Validates a parquet DSL {@code _search} response against a committed golden file.
        // Older/typed responses may carry a bare number.  
     * Validate {@code actual} against the golden for {@code dataset}/q{@code queryNumber}.  
 *       "total": 3,  
 * mirrors the PPL/SQL suite in {@code analytics-engine-rest}, whose expected files are known-correct
 * compatible open source license.
    private static Map<String, Object> parseJson(String json) throws IOException {  
package org.opensearch.dsl.types;
    @SuppressWarnings("unchecked")
            return out;
                    return false;
                if (!first) {  
        }
        }  
                label,
                    label,  
    @SuppressWarnings("unchecked")
            }
                return diff;  
    // ── comparison ───────────────────────────────────────────────────────────
        return out;
        }
    private static boolean valuesEqual(Object expected, Object actual) {
        List<Map<String, Object>> exp = new ArrayList<>(expectedSources);  
        Map<String, Object> golden;  
        if (o instanceof List) {  
            );
 *   }  
                }
        return o instanceof Number ? ((Number) o).longValue() : 0L;  
        List<Map<String, Object>> hitList = (List<Map<String, Object>>) hits.get("hits");
        String label = "DSL " + dataset.name + " Q" + queryNumber;
import java.io.IOException;
 * parts of a search response:
        String goldenPath = dataset.expectedResponseResourcePath("dsl", queryNumber);  
        if (expected instanceof List && actual instanceof List) {  
        }  
            if (expectedList.size() != actualList.size()) {  
                    out.add((Map<String, Object>) e);  
        for (Map.Entry<String, Object> e : expected.entrySet()) {
        List<Map<String, Object>> act = new ArrayList<>(actualSources);
            return 0;  
 * answers, never the engine's own output.  
    private static final double NUMERIC_TOLERANCE = 1e-9;
        if (o instanceof Map) {
        }  
            golden = parseJson(DatasetProvisioner.loadResource(goldenPath));
        }  
                actualSources.size()
 */  
        }
    @SuppressWarnings("unchecked")  
        }  
            // _source array order is significant — unlike hit ordering, an array field such as `tags`  
        if (hits == null) {
        Map<String, Object> hits = (Map<String, Object>) response.get("hits");
 *  
    /**
        if (DslResponseValidator.class.getClassLoader().getResource(goldenPath) == null) {
            List<Object> actualList = (List<Object>) actual;
    private static List<Map<String, Object>> asSourceList(Object o) {
 * {@code total} is compared against {@code hits.total.value}; {@code sources} is compared against each
 *   {
                if (e instanceof Map) {
        Map<String, Object> goldenHits = (Map<String, Object>) golden.get("hits");
                    actual.get(e.getKey())  
        for (int i = 0; i < exp.size(); i++) {  
            return "[" + String.join(",", parts) + "]";  
    public static String validate(Dataset dataset, int queryNumber, Map<String, Object> actual) {
                    "%s field [%s]: value mismatch - expected %s, got %s",
        }
                Locale.ROOT,  
        act.sort(byCanonical);
        }
            json,  
            boolean first = true;
    }
            for (int i = 0; i < expectedList.size(); i++) {
        if (hitList == null) {  
 * out-of-band by running each dataset on a vanilla OpenSearch index (default Lucene backend, no parquet
    @SuppressWarnings("unchecked")
                return String.format(Locale.ROOT, "%s: missing field [%s]", label, e.getKey());  
                }
            }
            if (!actual.containsKey(e.getKey())) {
    }
 *
        if (hits == null) {
 */
public final class DslResponseValidator {
            return out;  
 * <pre>  
 * settings) — the reference implementation — and committed. This suite only ever <i>validates</i> the
        for (Map<String, Object> hit : hitList) {  
            }
        }
 * {@code tags} — are compared in order, so a reordered array is a mismatch. A {@code total} of 0 with an
            return label + ": golden has no \"hits\" block";
            return compareSource((Map<String, Object>) expected, (Map<String, Object>) actual, "nested") == null;
     *
import org.opensearch.analytics.qa.Dataset;
 * hit's {@code _source} with numeric tolerance. The {@code sources} list itself is order-independent  
        if (expected instanceof Map && actual instanceof Map) {  
        if (goldenHits == null) {  
            }  
        }
            for (Object e : (List<Object>) o) {
                first = false;  
import org.opensearch.analytics.qa.DatasetProvisioner;
        return asLong(total);
    }  
        }
    }
            for (Map.Entry<String, Object> e : sorted.entrySet()) {
        long actualTotal = extractTotal(actual);
        // Order-independent: sort both by canonical string form, then compare element-wise.
        Comparator<Map<String, Object>> byCanonical = Comparator.comparing(DslResponseValidator::canonical);
