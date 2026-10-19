            if (!actual.containsKey(e.getKey())) {
import org.opensearch.analytics.qa.DatasetProvisioner;
     */
public final class DslResponseValidator {
    private static List<Map<String, Object>> asSourceList(Object o) {
        return null;
            }
            // Preserve element order so that array-order differences yield distinct canonical keys and
        return o instanceof Number ? ((Number) o).longValue() : 0L;
 * Validates a parquet DSL {@code _search} response against a committed golden file.
            if (diff != null) {
    private static String compare(Map<String, Object> golden, Map<String, Object> actual, String label) {
 * out-of-band by running each dataset on a vanilla OpenSearch index (default Lucene backend, no parquet
        // Order-independent: sort both by canonical string form, then compare element-wise.
    }
    }
    private DslResponseValidator() {}
                actualSources.size()
            }
            return '"' + (String) o + '"';
        } catch (Exception e) {
                    e.getKey(),
 * </pre>
            golden = parseJson(DatasetProvisioner.loadResource(goldenPath));
                parts.add(canonical(e));
        exp.sort(byCanonical);
            }
 * parts of a search response:
    private static long extractTotal(Map<String, Object> response) {
                label,
        List<Map<String, Object>> hitList = (List<Map<String, Object>>) hits.get("hits");
                    out.add((Map<String, Object>) e);
                "%s: hit count mismatch - expected %d sources, got %d",
            return asLong(((Map<String, Object>) total).get("value"));
}
        Comparator<Map<String, Object>> byCanonical = Comparator.comparing(DslResponseValidator::canonical);
                if (!valuesEqual(expectedList.get(i), actualList.get(i))) {
    public static String validate(Dataset dataset, int queryNumber, Map<String, Object> actual) {
        Map<String, Object> golden;
        }
        try {
            }
            return compareSource((Map<String, Object>) expected, (Map<String, Object>) actual, "nested") == null;
        return Objects.equals(expected, actual);
        return out;
                Locale.ROOT,
        List<Map<String, Object>> actualSources = extractSources(actual);
            // are not collapsed during hit pairing. Hit *list* ordering is still ignored — see compare().
                Locale.ROOT,
    @SuppressWarnings("unchecked")
 * (hit ordering is ignored), but values <i>within</i> a {@code _source} — including array fields such as
            // _source array order is significant — unlike hit ordering, an array field such as `tags`
 * compatible open source license.
            return String.format(
    @SuppressWarnings("unchecked")
 * hit's {@code _source} with numeric tolerance. The {@code sources} list itself is order-independent
            return true;
    }
        }
        if (DslResponseValidator.class.getClassLoader().getResource(goldenPath) == null) {
        long expectedTotal = asLong(goldenHits.get("total"));
                    e.getValue(),
        }
        long actualTotal = extractTotal(actual);
            for (Object e : (List<Object>) o) {
            out.add(src instanceof Map ? (Map<String, Object>) src : Map.of());
        List<Map<String, Object>> out = new ArrayList<>();
    }
    }
        if (goldenHits == null) {
            return 0;
                "%s: field count mismatch - expected %s, got %s",
        List<Map<String, Object>> expectedSources = asSourceList(goldenHits.get("sources"));
            for (int i = 0; i < expectedList.size(); i++) {
                    Locale.ROOT,
        if (hitList == null) {
     *
        }
    private static List<Map<String, Object>> extractSources(Map<String, Object> response) {
    private static final double NUMERIC_TOLERANCE = 1e-9;
 *   {
                    "%s field [%s]: value mismatch - expected %s, got %s",
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> hits = (Map<String, Object>) response.get("hits");
        String goldenPath = dataset.expectedResponseResourcePath("dsl", queryNumber);
 * The OpenSearch Contributors require contributions made to
    }
            return sb.append("}").toString();
        }
        }
            json,
    private static String canonical(Object o) {
                return false;
import java.io.IOException;
    /**
 * query that legitimately matches nothing.
                return diff;
        List<Map<String, Object>> act = new ArrayList<>(actualSources);
            false
                );
                expectedSources.size(),
            List<Object> expectedList = (List<Object>) expected;
    }
import java.util.ArrayList;
     * @return {@code null} when validation passes; otherwise a human-readable failure message
        }
 * answers, never the engine's own output.
            String diff = compareSource(exp.get(i), act.get(i), label + " source " + i);
import java.util.Map;
        if (expected instanceof Map && actual instanceof Map) {
                if (e instanceof Map) {
                if (!first) {
        Map<String, Object> hits = (Map<String, Object>) response.get("hits");
import java.util.Objects;
 * mirrors the PPL/SQL suite in {@code analytics-engine-rest}, whose expected files are known-correct
            if (!valuesEqual(e.getValue(), actual.get(e.getKey()))) {
            return String.format(
                return String.format(Locale.ROOT, "%s: missing field [%s]", label, e.getKey());
            boolean first = true;
            }
        Object total = hits.get("total");
        }
            return out;
                sb.append('"').append(e.getKey()).append("\":").append(canonical(e.getValue()));
                new TreeMap<>(actual).keySet()
    @SuppressWarnings("unchecked")
/*
                    label,
            for (Object e : (List<Object>) o) {
        Map<String, Object> goldenHits = (Map<String, Object>) golden.get("hits");
        }
        act.sort(byCanonical);
        if (expectedTotal != actualTotal) {
    // ── extraction from a live response ────────────────────────────────────────
 *     "hits": {
                label,
        if (expected.size() != actual.size()) {
            if (expectedList.size() != actualList.size()) {
    }
        if (hits == null) {
        if (expected instanceof Number && actual instanceof Number) {
            return out;
        if (expectedSources.size() != actualSources.size()) {
        if (expected instanceof List && actual instanceof List) {
    @SuppressWarnings("unchecked")
            TreeMap<String, Object> sorted = new TreeMap<>((Map<String, Object>) o);
                    actual.get(e.getKey())
            return label + ": no golden file at " + goldenPath;
 * SPDX-License-Identifier: Apache-2.0
 * <p>Golden files live at {@code datasets/<type>/dsl/expected/q<N>.json} and capture the meaningful
    }
    // ── comparison ───────────────────────────────────────────────────────────
                }
            // must match element-for-element in the same order. Compare positionally; do not sort.
            for (Map.Entry<String, Object> e : sorted.entrySet()) {
            return "[" + String.join(",", parts) + "]";
        return out;
        if (o instanceof Map) {
    // ── helpers ──────────────────────────────────────────────────────────────
/**
            return Math.abs(((Number) expected).doubleValue() - ((Number) actual).doubleValue()) < NUMERIC_TOLERANCE;
    private static long asLong(Object o) {
        return org.opensearch.common.xcontent.XContentHelper.convertToMap(
            return String.format(Locale.ROOT, "%s: total mismatch - expected %d, got %d", label, expectedTotal, actualTotal);
 */
 * empty (or absent) {@code sources} is a perfectly valid golden — e.g. an aggregation-only query or a
 * <pre>
        if (o instanceof List) {
    @SuppressWarnings("unchecked")
            );
        if (total instanceof Map) {
 */
        }
 *
 *     }
        }
 * settings) — the reference implementation — and committed. This suite only ever <i>validates</i> the
                }
 * <p><b>The expected answer is the TRUE answer, not parquet's answer.</b> Expected answers are generated
        return null;
                }
            }
import java.util.Locale;
        if (o instanceof String) {
                return String.format(
            return label + ": golden has no \"hits\" block";
        }
                    return false;
            List<Object> actualList = (List<Object>) actual;
 * parquet response against the committed expected answer, so any place parquet deviates (null text
    }
            List<String> parts = new ArrayList<>();
            }
package org.opensearch.dsl.types;
        if (hits == null) {
        List<Map<String, Object>> out = new ArrayList<>();
        }
        }
 *
        }
 *
                new TreeMap<>(expected).keySet(),
    /** Canonical string form of a source map: keys sorted recursively, for order-independent compare. */
 *       "sources": [ { ... _source ... }, ... ]   // hit ordering ignored; array values within a _source are not
    private static Map<String, Object> parseJson(String json) throws IOException {
        if (o instanceof List) {
            org.opensearch.common.xcontent.XContentType.JSON.xContent(),
            }
 * {@code total} is compared against {@code hits.total.value}; {@code sources} is compared against each
import java.util.List;
        String label = "DSL " + dataset.name + " Q" + queryNumber;
 * {@code tags} — are compared in order, so a reordered array is a mismatch. A {@code total} of 0 with an
    private static boolean valuesEqual(Object expected, Object actual) {
        }
        for (int i = 0; i < exp.size(); i++) {
        return asLong(total);
            StringBuilder sb = new StringBuilder("{");
    @SuppressWarnings("unchecked")
        return compare(golden, actual, label);
import java.util.TreeMap;
 *   }
                    sb.append(",");
        for (Map.Entry<String, Object> e : expected.entrySet()) {
 *       "total": 3,
        List<Map<String, Object>> exp = new ArrayList<>(expectedSources);
        }
        return String.valueOf(o);
    private static String compareSource(Map<String, Object> expected, Map<String, Object> actual, String label) {
import java.util.Comparator;
        }
import org.opensearch.analytics.qa.Dataset;
     * Validate {@code actual} against the golden for {@code dataset}/q{@code queryNumber}.
        );
                first = false;
        }
            );
 * {@code _source}, multi-valued keyword / custom-id / geo / nested failures) correctly shows red. This
        // Older/typed responses may carry a bare number.
        for (Map<String, Object> hit : hitList) {
            return label + ": failed to load/parse golden " + goldenPath + ": " + e.getMessage();
            Object src = hit.get("_source");
        }
