            for (int j = 0; j < er.size(); j++) {
    protected abstract Map<String, Boolean> tiers();
            return null;  
            StringBuilder sb = new StringBuilder();
            @SuppressWarnings("unchecked")  
        try {  
            String template = DatasetProvisioner.loadResource(queryDir + "/" + name + ".ppl").trim();
        return sb.toString();
            DatasetProvisioner.provision(client(), new Dataset("merge_coverage_lookup", "merge_coverage_lookup"), 1);  
            // multiset, not the gather order.  
        while (r.getCause() != null && r.getCause() != r) {  
 *
    /** Discover {@code <name>.ppl} base names under a classpath resource directory (sorted). */
                }  
    /**
        }
        }  
                // r1 == r2, so 2-shard-vs-golden alone would catch a regression transitively — but  
                            label, i, j, ev, av, tol);
        if (expected.size() != actual.size()) {  
            logger.info("[2shard-val] {}/{} | THREW {}", dir, name, rootMessage(e));
            return name + " [" + dir + "] threw: " + rootMessage(e);
                }  
            }  
            if (golden != null) {  
            sb.append(failures.size()).append(" of ").append(total).append(" 2-shard reduce checks failed:\n");
            for (int i = 0; i < row.size(); i++) {
        // Reset the cluster-wide MPP transient a forceMpp() subclass applied, so it does not leak onto
        if (response.containsKey("datarows")) {
    }  
        List<String> failures = new ArrayList<>();  
    protected static final String INDEX_2SHARD = "merge_coverage_2shard";
        if (TwoShardReduceTestCase.class.getClassLoader().getResource(resourcePath) == null) {
        if (forceMpp()) {  
        for (Object o : r2) {
                    double tol = Math.max(APPROX_ABS_TOL, APPROX_REL_TOL * Math.abs(ed));
    @Override  
            }
import java.util.Map;  
                });  
    protected boolean forceMpp() {
            }  
     * distribution-enforcement pass + reduce-stage substrait emit, guarding the MPP-reduce shapes
    /** Dataset subdirectories this suite covers, mapped to {@code true} when the tier is approximate  
    private static List<String> discoverQueryNames(String resourceDir) throws IOException {
     *  result to it too. Returns null on pass, else a one-line failure. */
            normalizeArrayCells(r1);
        } catch (Exception e) {
    private static final Dataset BASELINE = new Dataset(DATASET_NAME, INDEX_1SHARD);
import org.opensearch.client.Response;
     * The single registry of muted queries: {@code <name>.ppl} base-name → reason. Listed queries are
            sb.append(",…");
        }
    private static String compareWithinTolerance(List<List<Object>> expected, List<List<Object>> actual, String label) {
     *  (golden-with-tolerance) rather than exact (differential). Use an ordered map for stable logs. */
    }
        super.tearDown();  
     * reports them together so one broken query doesn't hide the rest.
        }
    @SuppressWarnings("unchecked")  
                    }
                    failures.add(dir + "/" + err);
            }
            Map<String, Object> golden = loadGolden(queryDir + "/expected/" + name + ".json");  
        TreeSet<String> names = new TreeSet<>();
        if (rows == null) {
        try {
        List<List<Object>> a = new ArrayList<>(actual);
        for (Map.Entry<String, Boolean> tier : tiers().entrySet()) {
 * within tolerance of a required golden instead. See {@code datasets/merge_coverage/README.md}.
                dir = PathUtils.get(uri);
        logger.info("[2-shard reduce] {} passed, {} failed, {} muted (of {} across tiers {})",
            Map<String, Object> shard = (Map<String, Object>) o;
            return name + " [" + dir + "] threw: " + rootMessage(e);  
    /** Assert the index spreads its docs across at least {@code minPopulated} primary shards. */  
        StringBuilder sb = new StringBuilder();
        List<Object> shards = entityAsList(resp);  
    // ── subclass contract ─────────────────────────────────────────────────────────
            boolean approx = tier.getValue();
     * Runs every {@code <name>.ppl} in this subclass's {@link #tiers()} against both the 1-shard and  
            DatasetProvisioner.provision(client(), BASELINE, 1);  
     *  result is asserted within tolerance of a REQUIRED golden truth. Returns null on pass. */
        FileSystem fs = null;
        for (int i = 0; i < show; i++) {
    /**
        if (forceMpp()) {
            Map<String, Object> golden = loadGolden(queryDir + "/expected/" + name + ".json");
import java.nio.file.FileSystem;
            if ("jar".equals(uri.getScheme())) {  
    /** Log compact 1-shard and 2-shard result rows for the report (parsed out of the log). */
            populated >= minPopulated  
                String pin1 = ResponseValidator.compareData(golden, r1, name + " [1-shard vs golden]");  
        if (url == null) {
     * non-numeric cells (group keys) must match exactly. Rows are aligned by their non-numeric cells.  
        return XContentHelper.convertToMap(XContentType.JSON.xContent(), json, false);
        int populated = 0;
        }
 * (oracle) and 2 shards. Exact tier: the two results must be equal (unordered, numeric-tolerant,
        a.sort(TwoShardReduceTestCase::byGroupKeys);  
 * this file be licensed under the Apache-2.0 license or a
        }
            return;
    private static List<List<Object>> extractRows(Map<String, Object> response) {
            sb.append(rows.get(i));
            return (List<List<Object>>) response.get("rows");  
    }  
        } catch (Exception e) {  
    @Override
            if (fs != null) {
                    continue;
    }  
    }
                fs.close();  
                    }
        List<List<Object>> rows = extractRows(response);
import java.io.IOException;
            for (String name : discoverQueryNames("datasets/" + DATASET_NAME + "/" + dir)) {
import org.opensearch.common.xcontent.XContentType;
    private void logValues(String tier, String name, Map<String, Object> r1, Map<String, Object> r2) {  
        }  
import java.util.Locale;
        } catch (Exception e) {
            String diff = ResponseValidator.compareData(r1, r2, name + " [1-shard vs 2-shard]");
                total++;  
                // Pin BOTH shard counts to the golden. The differential above already proves
        return false;
        return null;
        int skipped = 0;
import java.util.List;
    /** Exact tier: 1-shard result must equal 2-shard result; if a golden exists, pin the 2-shard  
            }
            r = r.getCause();
 */
        if (provisioned == false) {
        }
                // relaxed, and a baseline-vs-coordinator regression surfaces on the right side.
            Request reset = new Request("PUT", "/_cluster/settings");
            reset.setJsonEntity("{\"transient\":{\"analytics.mpp.enabled\": null, \"analytics.mpp.distribute.min_rows\": null}}");  
            logger.info("[2shard-val] {}/{} | 2s={} | golden={}", dir, name,  
        if (expected == null || actual == null) {  
        Request req = new Request("GET", "/_cat/shards/" + index);
        return new ArrayList<>(names);  
        }
                    String fileName = p.getFileName().toString();
     * required because some entries crash the data node, which would break unrelated tests.  
            throw new IOException("Failed to discover queries in [" + resourceDir + "]", e);  
            return Collections.emptyList();
        req.addParameter("format", "json");  
            }  
        StringBuilder k2 = new StringBuilder();
 * multi-value cells as multisets); a {@code <dir>/expected/<name>.json} golden additionally pins the
     * (percentile literal, HLL partial-state typing, computed-column type drift).
            logValues(dir, name, r1, r2);
     * there is no separate annotation or directory. Skipping (rather than running-and-tolerating) is
    protected void onBeforeQuery() throws IOException {
    // ── provisioning ────────────────────────────────────────────────────────────
import java.util.stream.Stream;
        sb.append('(').append(rows.size()).append(" rows) ");  
    }
    }
        for (int i = 0; i < e.size(); i++) {
    private void assertShardsPopulated(String index, int minPopulated) throws IOException {
    /** Approx tier: differential equality is not used (sketches drift across a merge) — the 2-shard
            }
                String pin2 = ResponseValidator.compareData(golden, r2, name + " [2-shard vs golden]");
        for (List<Object> row : rows) {  
                }
                }
    private static Map<String, Object> loadGolden(String resourcePath) throws IOException {  
        }
                if (row.get(i) instanceof List) {
        return null;
        try {
                Object av = ar.get(j);  
        int show = Math.min(8, rows.size());
                + "(else the 2-shard reduce is never exercised); populated primaries=" + populated,
            if ((o instanceof Number) == false) {  
        }  
            } else {  
     * the coordinator-centric multi-shard reduce. A subclass returning {@code true} (with the tiny
    public void tearDown() throws Exception {
            normalizeArrayCells(r2);
            return compareWithinTolerance(extractRows(golden), extractRows(r2), name + " [2-shard vs truth ~]");
                dir = fs.getPath(resourceDir);
            if (er.size() != ar.size()) {
        }
 * 2-shard result. Approximate tier: sketches drift across a merge, so the 2-shard result is asserted  
import org.opensearch.client.Request;
            }
        Response resp = client().performRequest(req);
            passed, failures.size(), skipped, total, tiers().keySet());
        } finally {
        }
import java.util.Collections;  
            return "<none>";
                normalizeArrayCells(golden);
                    skipped++;
            if (i < show - 1) {  
        );
        StringBuilder k1 = new StringBuilder();
    }  
package org.opensearch.analytics.qa;
    private static void normalizeArrayCells(Map<String, Object> response) {
    public void testReduceCorrectnessAcrossTwoShards() throws IOException {
        if (rows == null) {  
    }  
                compact(extractRows(r2)), compact(extractRows(golden)));
        String json = DatasetProvisioner.loadResource(resourcePath);
                    if (fileName.endsWith(".ppl")) {  
    /**  
            }
                stream.forEach(p -> {
        if (response == null) {
                sb.append(',');
                        names.add(fileName.substring(0, fileName.length() - ".ppl".length()));
        Throwable r = t;
        }
import java.nio.file.FileSystems;
public abstract class TwoShardReduceTestCase extends AnalyticsRestTestCase {  
                if (muted.containsKey(name)) {
        }
        }  
        String queryDir = "datasets/" + DATASET_NAME + "/" + dir;
        return r.getClass().getSimpleName() + ": " + r.getMessage();  
                    passed++;
            URI uri = url.toURI();
                // pinning 1-shard directly guards the baseline even if the differential is ever
                } else {  
     */  
                fs = FileSystems.newFileSystem(uri, Collections.emptyMap());
        return Collections.emptyMap();  
        }
     * Whether to force the MPP distributed path on every query. Default {@code false} — the suite verifies
    protected static final String DATASET_NAME = "merge_coverage";
import java.util.TreeSet;
                }
                    logger.warn("[2-shard reduce] MUTED {}/{} — {}", dir, name, muted.get(name));  
import java.net.URI;
            String dir = tier.getKey();  
     * {@code analytics.mpp.distribute.min_rows} floor) drives the same query families through the  
    private String runDifferential(String dir, String name) {
            Map<String, Object> r2 = executePpl(template.replace(INDEX_TOKEN, INDEX_2SHARD));
    }
     * 2-shard index and asserts the reduce did not change the answer. Collects all failures and
            Request mpp = new Request("PUT", "/_cluster/settings");
    // ── tolerance comparison (approximate tier) ──────────────────────────────────
        }
                k1.append(o).append(' ');
            // Dimension index for the `lookup` command (shard count irrelevant — it's broadcast).
    }
            assertShardsPopulated(INDEX_2SHARD, 2);
        if (failures.isEmpty() == false) {  
            List<Object> ar = a.get(i);  
import java.nio.file.Files;  
            return expected == actual ? null : label + ": one side empty";
        logger.info("[2shard-val] {}/{} | 1s={} | 2s={}", tier, name, compact(extractRows(r1)), compact(extractRows(r2)));
                if (ev instanceof Number && av instanceof Number) {
            if (golden == null) {
            mpp.setJsonEntity("{\"transient\":{\"analytics.mpp.enabled\": true, \"analytics.mpp.distribute.min_rows\": 1}}");
            }
 */  
        }
    }
    private String runApprox(String dir, String name) {  
                }  
            return null;
     * runs and must pass. This is the one place to look for "what's currently broken at 2 shards" —
    /** Relative tolerance for the approximate (HLL / t-digest) tier. */
        // sibling test classes on the shared cluster (see TpchPplIT for the same hygiene).  
    }
    private static int byGroupKeys(List<Object> r1, List<Object> r2) {  
            Map<String, Object> r2 = executePpl(template.replace(INDEX_TOKEN, INDEX_2SHARD));
    }
        req.addParameter("h", "prirep,docs,state");
        int passed = 0;
        assertTrue(  
            if ((o instanceof Number) == false) {
 * differential / approximate runners, and reporting. Subclasses declare only their dataset tiers  
    }  
                if (err == null) {
                    row.set(i, cell);
            for (String f : failures) {  
            }
                }
 * compatible open source license.
    private static String rootMessage(Throwable t) {
            try (Stream<Path> stream = Files.list(dir)) {  
                    return pin1;
            provisioned = true;
        }
 * SPDX-License-Identifier: Apache-2.0
     * <b>skipped entirely</b> (never executed) and logged as {@code MUTED: <reason>}; everything else  
            }
import org.opensearch.common.io.PathUtils;  
    private static boolean provisioned = false;
    /** Order rows by their non-numeric cells (the group keys) so tolerant compare can align them. */
import java.nio.file.Path;
     *  compare treats {@code values(...)} / {@code list(...)} output as an unordered multiset. */
 * The OpenSearch Contributors require contributions made to  
    /** Sort any list-valued (multi-value / collection-aggregation) cell in place, so a differential
    // ── per-query runners ────────────────────────────────────────────────────────
                sb.append("  - ").append(f).append('\n');
        return k1.toString().compareTo(k2.toString());
    private static final double APPROX_ABS_TOL = 1.0;  
            List<Object> er = e.get(i);
                if (pin2 != null) {
     */  
    protected static final String INDEX_1SHARD = "merge_coverage_1shard";  
        if (response.containsKey("rows")) {
            // Collection aggregations (values/list) return a multi-value cell whose element order
/**
            Map<String, Object> r1 = executePpl(template.replace(INDEX_TOKEN, INDEX_1SHARD));  
            client().performRequest(mpp);  
     */
        URL url = TwoShardReduceTestCase.class.getClassLoader().getResource(resourceDir);  
    /** Render up to the first 8 rows compactly so the log line stays readable. */
            }
                return name + " [" + dir + "] has no golden truth file — approximate queries must ship one";
        }
                Object docs = shard.get("docs");  
import java.net.URL;  
                return String.format(Locale.ROOT, "%s row %d: column count mismatch", label, i);
                String err = approx ? runApprox(dir, name) : runDifferential(dir, name);  
    private static String compact(List<List<Object>> rows) {  
}
    }
                    double ad = ((Number) av).doubleValue();  
        for (Object o : r1) {  
 *
            }  
                Object ev = er.get(j);
    }
import org.opensearch.common.xcontent.XContentHelper;
            return null;  
            "Index [" + index + "] must spread docs across >= " + minPopulated + " primary shards "
import java.util.ArrayList;
            client().performRequest(reset);
    @SuppressWarnings("unchecked")  
                if (docs != null && Integer.parseInt(docs.toString()) > 0) {
 * Shared machinery for the 2-shard reduce-correctness suite — provisioning, query discovery, the
        List<List<Object>> e = new ArrayList<>(expected);  
                return diff;  
            String template = DatasetProvisioner.loadResource(queryDir + "/" + name + ".ppl").trim();
    private static final Dataset SHARDED = new Dataset(DATASET_NAME, INDEX_2SHARD);  
            return (List<List<Object>>) response.get("datarows");  
                    populated++;
                    return String.format(Locale.ROOT, "%s row %d col %d: %s vs %s", label, i, j, ev, av);
        }
/*  
    private static final double APPROX_REL_TOL = 0.15;
    protected Map<String, String> knownIssues() {
    /**
            // depends on the gather; sort those array cells so the differential tests the merged
                    double ed = ((Number) ev).doubleValue();
                    List<Object> cell = new ArrayList<>((List<Object>) row.get(i));  
     */
                k2.append(o).append(' ');
            if ("p".equals(shard.get("prirep"))) {
    protected static final String INDEX_TOKEN = "%INDEX%";
        String queryDir = "datasets/" + DATASET_NAME + "/" + dir;  
        for (Object o : shards) {
            DatasetProvisioner.provision(client(), SHARDED, 2);
                    cell.sort(java.util.Comparator.comparing(o -> o == null ? "" : o.toString()));
        Map<String, String> muted = knownIssues();
     * Unordered compare where numeric cells need only match within a relative tolerance and
                } else if (java.util.Objects.equals(ev, av) == false) {  
    // ── helpers ──────────────────────────────────────────────────────────────────
        }  
 * ({@link #tiers()}) and known-broken queries ({@link #knownIssues()}).
    // ── the test ──────────────────────────────────────────────────────────────────  
        int total = 0;  
            fail(sb.toString());  
        e.sort(TwoShardReduceTestCase::byGroupKeys);
 * <p>Each {@code <name>.ppl} (source = {@code %INDEX%}) runs against {@code merge_coverage} at 1 shard  
                if (pin1 != null) {
            }  
            return String.format(Locale.ROOT, "%s: row count mismatch - expected %d, got %d", label, expected.size(), actual.size());
            if (diff != null) {
        assertTrue("No queries discovered for tiers " + tiers().keySet() + " — dataset resources missing?", total > 0);
        if (rows.size() > show) {
                    if (Math.abs(ed - ad) > tol) {
                        return String.format(Locale.ROOT, "%s row %d col %d: %s vs %s exceeds tolerance %.3f",  
        }  
    /** Load a golden {@code {"rows": [...]}} file as a Map, or null if it doesn't exist. */
                    return pin2;  
            Path dir;
        }  
