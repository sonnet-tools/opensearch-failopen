                captured++;
 */  
    public void testTpchPplQueries() throws Exception {  
    /** The eight TPC-H tables, each provisioned from its own {@code mapping_<index>.json} +
    }
                XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
    public void testCaptureExpected() throws Exception {
 */  
    }  
        List<Integer> queryNumbers = DatasetQueryRunner.discoverQueryNumbers(getDataset(), "ppl");  
    private void applySetting(String key, String value) throws IOException {  
 * <p>The eight TPC-H tables are provisioned from the {@code tpch} dataset; the 22
     * capture dir. Per-query failures are collected and logged, not thrown, so one run
package org.opensearch.analytics.qa;
     *  (broadcast / hash-shuffle / coordinator-centric), not the trivial single-shard reduce.
    }
import java.nio.charset.StandardCharsets;
        return UNSUPPORTED;
        if (!tpchProvisioned) {
 * this file be licensed under the Apache-2.0 license or a
        // HASH_SHUFFLE_AGG paths these tests are written to validate.  
     * Capture-mode helper: only does work when {@code -Dtests.tpch.capture.dir} is set.
                failures.add(msg);
            try {
        client().performRequest(request);  
            logger.info("  FAILED {}", f);
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
import java.util.ArrayList;
    protected void onBeforeQuery() throws IOException {
 * trivial single-shard reduce. Expected values were captured from a real 2-shard parquet run on
    /**
            }  
}
        }
        "partsupp",
            return;  
        Files.createDirectories(outDir);
                String msg = "q" + n + ": " + e.getMessage().replaceAll("\\s+", " ");  
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
    private static boolean tpchProvisioned = false;
import java.util.Map;
 * against {@code datasets/tpch/ppl/expected/q{N}.json} by {@link ResponseValidator}  
 * to provision the dataset, execute all 22 queries, and write each successful response to  
    );
        Path outDir = Path.of(captureDir);  
                Response response = client().performRequest(request);
     * inventories the full pass/fail split across all 22 queries.  
 *  
        if (captureDir == null || captureDir.isBlank()) {
    protected Dataset getDataset() {
    @Override
        "customer",  
        Request request = new Request("PUT", "/_cluster/settings");
 * <p><b>Backend difference vs. the source IT.</b> The source runs Calcite over the  
        List<String> failures = new ArrayList<>();
    }
    @Override
 * The OpenSearch Contributors require contributions made to  
    @Override  
            logger.info("tests.tpch.capture.dir not set — skipping TPC-H expected capture");
    @Override
 * canonical TPC-H queries live under {@code datasets/tpch/ppl/q{N}.ppl} and are validated
import org.opensearch.client.Request;
    }
     *  {@code bulk_<index>.json} under {@code resources/datasets/tpch/}. */  
    protected Set<Integer> getSkipQueries() {  
 * <em>Lucene</em> backend with a pushdown-enabled/disabled value fork. This test runs
            String ppl = loadResource(getDataset().queryResourcePath("ppl", "ppl", n)).trim();
        String captureDir = System.getProperty("tests.tpch.capture.dir");  
                Request request = new Request("POST", "/_plugins/_ppl");  
        "part",
            } catch (Exception e) {
 * this backend (see {@link #testCaptureExpected}), not transcribed from the source's Lucene  
        client().performRequest(request);  
    private void resetSetting(String key) throws IOException {  
 * <p><b>Capturing expected files.</b> Run with {@code -Dtests.tpch.capture.dir=<abs path>}
     *  Overrides {@link BasePplIT#onBeforeQuery} (whose {@code dataProvisioned} flag is private)  
 * {@code org.opensearch.sql.calcite.tpch.CalcitePPLTpchIT}.
                builder.map(body);  
            tpchProvisioned = true;
            DatasetProvisioner.provision(client(), getDataset(), 2);  
 *
        for (String f : failures) {  
 * actually exercise the MPP path (broadcast / hash-shuffle / coordinator-centric) rather than a
    }
 *
        // value may change). Self-enabling keeps the TPC-H queries on the BROADCAST / HASH_SHUFFLE /
        // TwoShard* reduce tests — onto the MPP distributed path they are not written for).
        "nation",  
        super.tearDown();  
 * cross-checked against the source SQL plugin's {@code CalcitePPLTpchIT} assertions.  
        onBeforeQuery(); // provision dataset (idempotent, gated in BasePplIT)
        }
     * cluster, and snapshots each <em>successful</em> response as {@code q{N}.json} into the
    }  
 * through {@link DatasetProvisioner}, which forces {@code primary_data_format=parquet}, and
     */
     * Runs the TPC-H queries against their captured expected files.
        // This IT exists to exercise the MPP path; enable it explicitly rather than relying on the  
        // analytics.mpp.enabled is applied cluster-wide (transient) in onBeforeQuery; reset it so the
 * TPC-H PPL integration test, migrated from the SQL plugin's
        // cluster default (production defaults analytics.mpp.enabled=false, and the QA build.gradle
                Map<String, Object> body = assertOkAndParse(response, "TPC-H capture q" + n);  
 * verified ones into {@code src/test/resources/datasets/tpch/ppl/expected/}.
    }
 * <p><b>Coverage on this backend (2 shards).</b> All 22 canonical TPC-H queries run and  
        // setting does not leak onto subsequent test classes (the shared 2-node cluster persists across
     * Provisions the dataset, runs every discovered query against the real parquet-backed  
        }
        for (int n : queryNumbers) {  
public class TpchPplIT extends BasePplIT {
        "supplier",  
/*  
    protected ExpectedResponseStrategy getStrategy() {
    }  
import org.opensearch.common.xcontent.XContentFactory;  
import java.nio.file.Files;
    public void tearDown() throws Exception {  
import java.util.Set;  
    private static final Dataset DATASET = new Dataset(
        applySetting("analytics.mpp.enabled", "true");
 *
     *  with a local once-per-JVM guard. */
        return DATASET;  
 * SPDX-License-Identifier: Apache-2.0
        "orders",
                logger.warn("TPC-H capture FAILED {}", msg);
     */
import java.util.List;
        "lineitem",
                logger.info("Captured TPC-H q{} -> {}", n, outDir.resolve("q" + n + ".json"));  
 * assertions.
 * {@code <dir>/q{N}.json} in the canonical {schema, datarows, total, size} shape. Copy the
import org.opensearch.core.xcontent.XContentBuilder;
 * including multi-broadcast queries, is genuinely covered). Every captured value was
        return ExpectedResponseStrategy.FAIL_ON_MISSING;
        Request request = new Request("PUT", "/_cluster/settings");
    /** Provision each TPC-H index with 2 shards so multi-table joins exercise the MPP path
import java.nio.file.Path;  
        logger.info("TPC-H capture summary: {} captured, {} failed", captured, failures.size());
        "tpch",
 * compatible open source license.
 * match captured expected files (most are multi-table joins, so the MPP join path,
    private static final Set<Integer> UNSUPPORTED = Set.of();  
 * provisions each index with <b>2 shards</b> (see {@link #onBeforeQuery}) so multi-table joins  
        // ITs, and an un-reset mpp.enabled=true would route later coord-centric suites — e.g. the  
import java.io.IOException;  
import org.opensearch.client.Response;
 *
    @Override
                String json = builder.toString();
                request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
/**  
        runPplQueries();
                Files.write(outDir.resolve("q" + n + ".json"), (json + "\n").getBytes(StandardCharsets.UTF_8));
        "region"
        }
        resetSetting("analytics.mpp.enabled");
        int captured = 0;
 * (row-multiset comparison, 1e-9 float tolerance).
    /**  
