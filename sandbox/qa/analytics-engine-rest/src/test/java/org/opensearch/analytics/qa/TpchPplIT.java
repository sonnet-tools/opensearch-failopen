     * Provisions the dataset, runs every discovered query against the real parquet-backed
 * <p><b>Capturing expected files.</b> Run with {@code -Dtests.tpch.capture.dir=<abs path>}
 * provisions each index with <b>2 shards</b> (see {@link #onBeforeQuery}) so multi-table joins
            }
                logger.warn("TPC-H capture FAILED {}", msg);
    @Override
 *
        return DATASET;
                builder.map(body);
                logger.info("Captured TPC-H q{} -> {}", n, outDir.resolve("q" + n + ".json"));
            return;
 * to provision the dataset, execute all 22 queries, and write each successful response to
     *  (broadcast / hash-shuffle / coordinator-centric), not the trivial single-shard reduce.
        Request request = new Request("PUT", "/_cluster/settings");
        List<String> failures = new ArrayList<>();
import java.nio.charset.StandardCharsets;
public class TpchPplIT extends BasePplIT {
/**
    private static final Set<Integer> UNSUPPORTED = Set.of();
        // cluster default (production defaults analytics.mpp.enabled=false, and the QA build.gradle
        }
                String msg = "q" + n + ": " + e.getMessage().replaceAll("\\s+", " ");
        logger.info("TPC-H capture summary: {} captured, {} failed", captured, failures.size());
    }
 */
        // analytics.mpp.enabled is applied cluster-wide (transient) in onBeforeQuery; reset it so the
 * match captured expected files (most are multi-table joins, so the MPP join path,
            String ppl = loadResource(getDataset().queryResourcePath("ppl", "ppl", n)).trim();
        Path outDir = Path.of(captureDir);
import org.opensearch.core.xcontent.XContentBuilder;
    }
}
 * (row-multiset comparison, 1e-9 float tolerance).
     *  with a local once-per-JVM guard. */
 * <em>Lucene</em> backend with a pushdown-enabled/disabled value fork. This test runs
    protected void onBeforeQuery() throws IOException {
import org.opensearch.client.Response;
        }
                Response response = client().performRequest(request);
    private void applySetting(String key, String value) throws IOException {
    /**
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
        client().performRequest(request);
import java.util.ArrayList;
    }
 * verified ones into {@code src/test/resources/datasets/tpch/ppl/expected/}.
 * <p><b>Backend difference vs. the source IT.</b> The source runs Calcite over the
/*
        }
        // HASH_SHUFFLE_AGG paths these tests are written to validate.
    }
            tpchProvisioned = true;
 * against {@code datasets/tpch/ppl/expected/q{N}.json} by {@link ResponseValidator}
    /** Provision each TPC-H index with 2 shards so multi-table joins exercise the MPP path
                XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
        return UNSUPPORTED;
    }
                Request request = new Request("POST", "/_plugins/_ppl");
        }
            logger.info("  FAILED {}", f);
     */
 * <p>The eight TPC-H tables are provisioned from the {@code tpch} dataset; the 22
        "customer",
 * TPC-H PPL integration test, migrated from the SQL plugin's
 * {@code org.opensearch.sql.calcite.tpch.CalcitePPLTpchIT}.
    public void testCaptureExpected() throws Exception {
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
     * inventories the full pass/fail split across all 22 queries.
        int captured = 0;
        if (captureDir == null || captureDir.isBlank()) {
 * <p><b>Coverage on this backend (2 shards).</b> All 22 canonical TPC-H queries run and
import org.opensearch.common.xcontent.XContentFactory;
        Request request = new Request("PUT", "/_cluster/settings");
    private void resetSetting(String key) throws IOException {
    }
        // This IT exists to exercise the MPP path; enable it explicitly rather than relying on the
import java.io.IOException;
    @Override
        onBeforeQuery(); // provision dataset (idempotent, gated in BasePplIT)
import java.nio.file.Files;
            try {
package org.opensearch.analytics.qa;
    private static final Dataset DATASET = new Dataset(
        for (int n : queryNumbers) {
import java.util.Map;
 *
    protected ExpectedResponseStrategy getStrategy() {
            logger.info("tests.tpch.capture.dir not set — skipping TPC-H expected capture");
        runPplQueries();
     */
 * assertions.
    private static boolean tpchProvisioned = false;
 * including multi-broadcast queries, is genuinely covered). Every captured value was
        // value may change). Self-enabling keeps the TPC-H queries on the BROADCAST / HASH_SHUFFLE /
     * capture dir. Per-query failures are collected and logged, not thrown, so one run
 * The OpenSearch Contributors require contributions made to
                request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
     * Runs the TPC-H queries against their captured expected files.
        for (String f : failures) {
    );
    @Override
        return ExpectedResponseStrategy.FAIL_ON_MISSING;
import java.nio.file.Path;
        "nation",
            } catch (Exception e) {
        if (!tpchProvisioned) {
    /**
                failures.add(msg);
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
        String captureDir = System.getProperty("tests.tpch.capture.dir");
 *
 * canonical TPC-H queries live under {@code datasets/tpch/ppl/q{N}.ppl} and are validated
 */
import org.opensearch.client.Request;
    /** The eight TPC-H tables, each provisioned from its own {@code mapping_<index>.json} +
        super.tearDown();
 * through {@link DatasetProvisioner}, which forces {@code primary_data_format=parquet}, and
        // TwoShard* reduce tests — onto the MPP distributed path they are not written for).
 * trivial single-shard reduce. Expected values were captured from a real 2-shard parquet run on
 * SPDX-License-Identifier: Apache-2.0
    @Override
        List<Integer> queryNumbers = DatasetQueryRunner.discoverQueryNumbers(getDataset(), "ppl");
    protected Set<Integer> getSkipQueries() {
        // setting does not leak onto subsequent test classes (the shared 2-node cluster persists across
                Map<String, Object> body = assertOkAndParse(response, "TPC-H capture q" + n);
 * actually exercise the MPP path (broadcast / hash-shuffle / coordinator-centric) rather than a
        resetSetting("analytics.mpp.enabled");
 * cross-checked against the source SQL plugin's {@code CalcitePPLTpchIT} assertions.
 * {@code <dir>/q{N}.json} in the canonical {schema, datarows, total, size} shape. Copy the
                captured++;
        "orders",
    }
import java.util.Set;
        "lineitem",
    }
        "partsupp",
    @Override
        client().performRequest(request);
        "tpch",
     *  Overrides {@link BasePplIT#onBeforeQuery} (whose {@code dataProvisioned} flag is private)
        "region"
     * Capture-mode helper: only does work when {@code -Dtests.tpch.capture.dir} is set.
    }
 * compatible open source license.
     *  {@code bulk_<index>.json} under {@code resources/datasets/tpch/}. */
                String json = builder.toString();
    protected Dataset getDataset() {
        "part",
        "supplier",
    public void testTpchPplQueries() throws Exception {
                Files.write(outDir.resolve("q" + n + ".json"), (json + "\n").getBytes(StandardCharsets.UTF_8));
        Files.createDirectories(outDir);
    public void tearDown() throws Exception {
 *
 *
 * this backend (see {@link #testCaptureExpected}), not transcribed from the source's Lucene
     * cluster, and snapshots each <em>successful</em> response as {@code q{N}.json} into the
        applySetting("analytics.mpp.enabled", "true");
            DatasetProvisioner.provision(client(), getDataset(), 2);
        // ITs, and an un-reset mpp.enabled=true would route later coord-centric suites — e.g. the
