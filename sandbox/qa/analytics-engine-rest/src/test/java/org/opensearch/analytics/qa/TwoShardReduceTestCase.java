        if (response.containsKey("rows")) {
            }
            Path dir;
                + "(else the 2-shard reduce is never exercised); populated primaries=" + populated,
        );
    private static String rootMessage(Throwable t) {
            String template = DatasetProvisioner.loadResource(queryDir + "/" + name + ".ppl").trim();
        String json = DatasetProvisioner.loadResource(resourcePath);
                        return String.format(Locale.ROOT, "%s row %d col %d: %s vs %s exceeds tolerance %.3f",
        }
    private static final Dataset BASELINE = new Dataset(DATASET_NAME, INDEX_1SHARD);
    /** Approx tier: differential equality is not used (sketches drift across a merge) — the 2-shard
                    populated++;
                k2.append(o).append(' ');
        a.sort(TwoShardReduceTestCase::byGroupKeys);
        }
    private static final double APPROX_ABS_TOL = 1.0;
                }
    private static int byGroupKeys(List<Object> r1, List<Object> r2) {
 * Shared machinery for the 2-shard reduce-correctness suite — provisioning, query discovery, the
            String diff = ResponseValidator.compareData(r1, r2, name + " [1-shard vs 2-shard]");
import java.util.ArrayList;
    /** Relative tolerance for the approximate (HLL / t-digest) tier. */
    // ── helpers ──────────────────────────────────────────────────────────────────
            // Dimension index for the `lookup` command (shard count irrelevant — it's broadcast).
import java.io.IOException;
            Map<String, Object> r2 = executePpl(template.replace(INDEX_TOKEN, INDEX_2SHARD));
    }
     */
                }
                sb.append(',');
            DatasetProvisioner.provision(client(), SHARDED, 2);
                        names.add(fileName.substring(0, fileName.length() - ".ppl".length()));
    }
            assertShardsPopulated(INDEX_2SHARD, 2);
 * SPDX-License-Identifier: Apache-2.0
    }
                    double tol = Math.max(APPROX_ABS_TOL, APPROX_REL_TOL * Math.abs(ed));
        int show = Math.min(8, rows.size());
                }
     * reports them together so one broken query doesn't hide the rest.
    protected static final String INDEX_1SHARD = "merge_coverage_1shard";
                            label, i, j, ev, av, tol);
        int populated = 0;
        logger.info("[2shard-val] {}/{} | 1s={} | 2s={}", tier, name, compact(extractRows(r1)), compact(extractRows(r2)));
                fs = FileSystems.newFileSystem(uri, Collections.emptyMap());
            Map<String, Object> golden = loadGolden(queryDir + "/expected/" + name + ".json");
        try {
    }
                Object av = ar.get(j);
     * there is no separate annotation or directory. Skipping (rather than running-and-tolerating) is
        req.addParameter("format", "json");
    }
                    cell.sort(java.util.Comparator.comparing(o -> o == null ? "" : o.toString()));
                    }
    private static String compact(List<List<Object>> rows) {
        return null;
            // depends on the gather; sort those array cells so the differential tests the merged
    /** Load a golden {@code {"rows": [...]}} file as a Map, or null if it doesn't exist. */
        req.addParameter("h", "prirep,docs,state");
import java.nio.file.FileSystems;
            DatasetProvisioner.provision(client(), BASELINE, 1);
 * ({@link #tiers()}) and known-broken queries ({@link #knownIssues()}).
            Request reset = new Request("PUT", "/_cluster/settings");
    private void logValues(String tier, String name, Map<String, Object> r1, Map<String, Object> r2) {
            if (diff != null) {
import org.opensearch.common.io.PathUtils;
                    return pin1;
                Object docs = shard.get("docs");
            return name + " [" + dir + "] threw: " + rootMessage(e);
                if (ev instanceof Number && av instanceof Number) {
                fs.close();
import java.util.Locale;
            if (fs != null) {
    @SuppressWarnings("unchecked")
                    double ad = ((Number) av).doubleValue();
                return String.format(Locale.ROOT, "%s row %d: column count mismatch", label, i);
            }
        }
        if (rows == null) {
import java.net.URI;
                k1.append(o).append(' ');
                dir = PathUtils.get(uri);
            logger.info("[2shard-val] {}/{} | 2s={} | golden={}", dir, name,
    /**
    private static List<String> discoverQueryNames(String resourceDir) throws IOException {
    /**
        // sibling test classes on the shared cluster (see TpchPplIT for the same hygiene).
    /** Order rows by their non-numeric cells (the group keys) so tolerant compare can align them. */
                } else {
        return k1.toString().compareTo(k2.toString());
                    double ed = ((Number) ev).doubleValue();
            for (int i = 0; i < row.size(); i++) {
import java.nio.file.Path;
        try {
        Response resp = client().performRequest(req);
    // ── tolerance comparison (approximate tier) ──────────────────────────────────
            if (i < show - 1) {
            logger.info("[2shard-val] {}/{} | THREW {}", dir, name, rootMessage(e));
        for (Object o : r2) {
            }
        return XContentHelper.convertToMap(XContentType.JSON.xContent(), json, false);
            sb.append(rows.get(i));
        int total = 0;
        }
}
        for (Map.Entry<String, Boolean> tier : tiers().entrySet()) {
    @Override
        }
            List<Object> ar = a.get(i);
            URI uri = url.toURI();
                // pinning 1-shard directly guards the baseline even if the differential is ever
        return false;
/**
            return null;
    /** Render up to the first 8 rows compactly so the log line stays readable. */
                    skipped++;
                if (err == null) {
                if (pin2 != null) {
     * non-numeric cells (group keys) must match exactly. Rows are aligned by their non-numeric cells.
        Request req = new Request("GET", "/_cat/shards/" + index);
            return null;
        while (r.getCause() != null && r.getCause() != r) {
            return expected == actual ? null : label + ": one side empty";
    private static final double APPROX_REL_TOL = 0.15;
            return compareWithinTolerance(extractRows(golden), extractRows(r2), name + " [2-shard vs truth ~]");
 *
            Map<String, Object> r2 = executePpl(template.replace(INDEX_TOKEN, INDEX_2SHARD));
            boolean approx = tier.getValue();
    private static final Dataset SHARDED = new Dataset(DATASET_NAME, INDEX_2SHARD);
        for (Object o : shards) {
        for (int i = 0; i < show; i++) {
    private static List<List<Object>> extractRows(Map<String, Object> response) {
            return (List<List<Object>>) response.get("datarows");
                if (pin1 != null) {
                    logger.warn("[2-shard reduce] MUTED {}/{} — {}", dir, name, muted.get(name));
        return null;
     * the coordinator-centric multi-shard reduce. A subclass returning {@code true} (with the tiny
            return String.format(Locale.ROOT, "%s: row count mismatch - expected %d, got %d", label, expected.size(), actual.size());
        logger.info("[2-shard reduce] {} passed, {} failed, {} muted (of {} across tiers {})",
                    failures.add(dir + "/" + err);
     * runs and must pass. This is the one place to look for "what's currently broken at 2 shards" —
import org.opensearch.common.xcontent.XContentHelper;
            Map<String, Object> golden = loadGolden(queryDir + "/expected/" + name + ".json");
        for (Object o : r1) {
                if (row.get(i) instanceof List) {
     */
import java.util.Map;
            populated >= minPopulated
        List<List<Object>> rows = extractRows(response);
            }
    private static Map<String, Object> loadGolden(String resourcePath) throws IOException {
import java.util.Collections;
                String err = approx ? runApprox(dir, name) : runDifferential(dir, name);
        int skipped = 0;
            @SuppressWarnings("unchecked")
        }
                }
        }
    protected abstract Map<String, Boolean> tiers();
 * multi-value cells as multisets); a {@code <dir>/expected/<name>.json} golden additionally pins the
     * 2-shard index and asserts the reduce did not change the answer. Collects all failures and
        if (url == null) {
    /** Log compact 1-shard and 2-shard result rows for the report (parsed out of the log). */
            String dir = tier.getKey();
import java.net.URL;
                    passed++;
 *
    private String runApprox(String dir, String name) {
    @SuppressWarnings("unchecked")
                }
                normalizeArrayCells(golden);
        if (failures.isEmpty() == false) {
                    return pin2;
        }
        FileSystem fs = null;
     * {@code analytics.mpp.distribute.min_rows} floor) drives the same query families through the
    private static boolean provisioned = false;
            for (String name : discoverQueryNames("datasets/" + DATASET_NAME + "/" + dir)) {
            logValues(dir, name, r1, r2);
        }
        e.sort(TwoShardReduceTestCase::byGroupKeys);
 * this file be licensed under the Apache-2.0 license or a
                if (muted.containsKey(name)) {
        URL url = TwoShardReduceTestCase.class.getClassLoader().getResource(resourceDir);
            StringBuilder sb = new StringBuilder();
            return (List<List<Object>>) response.get("rows");
                // Pin BOTH shard counts to the golden. The differential above already proves
        }
        if (forceMpp()) {
    // ── subclass contract ─────────────────────────────────────────────────────────
    /** Dataset subdirectories this suite covers, mapped to {@code true} when the tier is approximate
        if (response.containsKey("datarows")) {
                });
    // ── provisioning ────────────────────────────────────────────────────────────
        }
     * (percentile literal, HLL partial-state typing, computed-column type drift).
        }
        StringBuilder k2 = new StringBuilder();
    /** Exact tier: 1-shard result must equal 2-shard result; if a golden exists, pin the 2-shard
            Request mpp = new Request("PUT", "/_cluster/settings");
        for (int i = 0; i < e.size(); i++) {
            for (int j = 0; j < er.size(); j++) {
                    List<Object> cell = new ArrayList<>((List<Object>) row.get(i));
        List<List<Object>> a = new ArrayList<>(actual);
                    return String.format(Locale.ROOT, "%s row %d col %d: %s vs %s", label, i, j, ev, av);
    }
    }
        if (expected.size() != actual.size()) {
     *  result to it too. Returns null on pass, else a one-line failure. */
    private static void normalizeArrayCells(Map<String, Object> response) {
            normalizeArrayCells(r1);
public abstract class TwoShardReduceTestCase extends AnalyticsRestTestCase {
    }
        }
        }
    }
 * differential / approximate runners, and reporting. Subclasses declare only their dataset tiers
    protected Map<String, String> knownIssues() {
        }
        return Collections.emptyMap();
            } else {
            provisioned = true;
        int passed = 0;
     */
    /**
 * compatible open source license.
                sb.append("  - ").append(f).append('\n');
        for (List<Object> row : rows) {
    /**
     *  (golden-with-tolerance) rather than exact (differential). Use an ordered map for stable logs. */
        if (rows.size() > show) {
    // ── the test ──────────────────────────────────────────────────────────────────
        if (response == null) {
            }
import java.util.stream.Stream;
    public void testReduceCorrectnessAcrossTwoShards() throws IOException {
                String pin1 = ResponseValidator.compareData(golden, r1, name + " [1-shard vs golden]");
 * The OpenSearch Contributors require contributions made to
        }
    }
        }
     * <b>skipped entirely</b> (never executed) and logged as {@code MUTED: <reason>}; everything else
            return null;
                    continue;
        }
                if (docs != null && Integer.parseInt(docs.toString()) > 0) {
        }
     * required because some entries crash the data node, which would break unrelated tests.
            }
    }
/*
            if (er.size() != ar.size()) {
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.client.Response;
            sb.append(failures.size()).append(" of ").append(total).append(" 2-shard reduce checks failed:\n");
            }
    protected static final String INDEX_2SHARD = "merge_coverage_2shard";
        if (provisioned == false) {
 */
                Object ev = er.get(j);
    }
            passed, failures.size(), skipped, total, tiers().keySet());
        } finally {
                    if (Math.abs(ed - ad) > tol) {
     * Whether to force the MPP distributed path on every query. Default {@code false} — the suite verifies
            sb.append(",…");
                String pin2 = ResponseValidator.compareData(golden, r2, name + " [2-shard vs golden]");
    }
 * 2-shard result. Approximate tier: sketches drift across a merge, so the 2-shard result is asserted
        sb.append('(').append(rows.size()).append(" rows) ");
            mpp.setJsonEntity("{\"transient\":{\"analytics.mpp.enabled\": true, \"analytics.mpp.distribute.min_rows\": 1}}");
import org.opensearch.client.Request;
import java.util.TreeSet;
            // multiset, not the gather order.
    // ── per-query runners ────────────────────────────────────────────────────────
    /** Discover {@code <name>.ppl} base names under a classpath resource directory (sorted). */
        return r.getClass().getSimpleName() + ": " + r.getMessage();
            client().performRequest(reset);
    protected static final String INDEX_TOKEN = "%INDEX%";
import java.util.List;
 * within tolerance of a required golden instead. See {@code datasets/merge_coverage/README.md}.
                    if (fileName.endsWith(".ppl")) {
                } else if (java.util.Objects.equals(ev, av) == false) {
                return name + " [" + dir + "] has no golden truth file — approximate queries must ship one";
        assertTrue("No queries discovered for tiers " + tiers().keySet() + " — dataset resources missing?", total > 0);
            return Collections.emptyList();
        if (expected == null || actual == null) {
        }
        Throwable r = t;
        }
            if (golden == null) {
    protected boolean forceMpp() {
        List<List<Object>> e = new ArrayList<>(expected);
                    row.set(i, cell);
        List<Object> shards = entityAsList(resp);
                    }
    }
        List<String> failures = new ArrayList<>();
            if (golden != null) {
        // Reset the cluster-wide MPP transient a forceMpp() subclass applied, so it does not leak onto
            throw new IOException("Failed to discover queries in [" + resourceDir + "]", e);
    protected void onBeforeQuery() throws IOException {
        super.tearDown();
            }
                total++;
            }
    }
     * Unordered compare where numeric cells need only match within a relative tolerance and
            Map<String, Object> shard = (Map<String, Object>) o;
        }
            return name + " [" + dir + "] threw: " + rootMessage(e);
 */
 * <p>Each {@code <name>.ppl} (source = {@code %INDEX%}) runs against {@code merge_coverage} at 1 shard
                // relaxed, and a baseline-vs-coordinator regression surfaces on the right side.
        return sb.toString();
                dir = fs.getPath(resourceDir);
        }
     * Runs every {@code <name>.ppl} in this subclass's {@link #tiers()} against both the 1-shard and
                // r1 == r2, so 2-shard-vs-golden alone would catch a regression transitively — but
import java.nio.file.FileSystem;
            try (Stream<Path> stream = Files.list(dir)) {
                compact(extractRows(r2)), compact(extractRows(golden)));
            }
            List<Object> er = e.get(i);
            return;
    @Override
        StringBuilder sb = new StringBuilder();
            }
     *  result is asserted within tolerance of a REQUIRED golden truth. Returns null on pass. */
        assertTrue(
            if ((o instanceof Number) == false) {
        return new ArrayList<>(names);
            Map<String, Object> r1 = executePpl(template.replace(INDEX_TOKEN, INDEX_1SHARD));
            if ("jar".equals(uri.getScheme())) {
import java.nio.file.Files;
            // Collection aggregations (values/list) return a multi-value cell whose element order
        } catch (Exception e) {
            if ("p".equals(shard.get("prirep"))) {
    public void tearDown() throws Exception {
     * The single registry of muted queries: {@code <name>.ppl} base-name → reason. Listed queries are
            "Index [" + index + "] must spread docs across >= " + minPopulated + " primary shards "
            normalizeArrayCells(r2);
        if (rows == null) {
            }
                }
    private String runDifferential(String dir, String name) {
                }
            fail(sb.toString());
    private void assertShardsPopulated(String index, int minPopulated) throws IOException {
    private static String compareWithinTolerance(List<List<Object>> expected, List<List<Object>> actual, String label) {
            reset.setJsonEntity("{\"transient\":{\"analytics.mpp.enabled\": null, \"analytics.mpp.distribute.min_rows\": null}}");
            return "<none>";
            }
            }
    }
        }
                return diff;
        } catch (Exception e) {
            String template = DatasetProvisioner.loadResource(queryDir + "/" + name + ".ppl").trim();
package org.opensearch.analytics.qa;
        } catch (Exception e) {
        String queryDir = "datasets/" + DATASET_NAME + "/" + dir;
        TreeSet<String> names = new TreeSet<>();
                    String fileName = p.getFileName().toString();
        if (forceMpp()) {
    /** Sort any list-valued (multi-value / collection-aggregation) cell in place, so a differential
        String queryDir = "datasets/" + DATASET_NAME + "/" + dir;
            }
     */
        if (TwoShardReduceTestCase.class.getClassLoader().getResource(resourcePath) == null) {
        Map<String, String> muted = knownIssues();
            if ((o instanceof Number) == false) {
     * distribution-enforcement pass + reduce-stage substrait emit, guarding the MPP-reduce shapes
        try {
        StringBuilder k1 = new StringBuilder();
                stream.forEach(p -> {
            DatasetProvisioner.provision(client(), new Dataset("merge_coverage_lookup", "merge_coverage_lookup"), 1);
     *  compare treats {@code values(...)} / {@code list(...)} output as an unordered multiset. */
 * (oracle) and 2 shards. Exact tier: the two results must be equal (unordered, numeric-tolerant,
            r = r.getCause();
    protected static final String DATASET_NAME = "merge_coverage";
            client().performRequest(mpp);
            for (String f : failures) {
        }
    /** Assert the index spreads its docs across at least {@code minPopulated} primary shards. */
    }
