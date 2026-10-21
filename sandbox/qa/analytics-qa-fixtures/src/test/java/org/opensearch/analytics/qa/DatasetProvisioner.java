        createIndex.setJsonEntity(injectParquetSettings(mapping));
     * Inject parquet data format settings into the existing settings block.
                && body.contains("\"index.pluggable.dataformat.enabled\":\"true\"")
     */
        String bulkBody = new String(bulkResponse.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
     * boundaries. The bulk format alternates an action line ({@code {"index":{}}}) and a source
        Request flush = new Request("POST", "/" + indexName + "/_flush");
    /**
        // masquerade as a successful provision.
     * {@code "No backend can evaluate filter predicate [OTHER_FUNCTION] on fields [...:text]"}
        public final String suffix;
        provision(client, dataset, numberOfShards, null);
            ? dataset.mappingResourcePath()
            // index may not exist — ignore
    /**
        health.addParameter("wait_for_status", "yellow");
        );
        }
 * SPDX-License-Identifier: Apache-2.0
        // wouldn't match the golden. Fail loudly instead.
 * first if it already exists.
    }
        Request merge = new Request("POST", "/" + indexName + "/_forcemerge");
        if (chunk.length() > 0) {
            chunk.append(docLines.get(i)).append('\n');
import java.util.List;
    // with: parse mapping JSON -> merge a settings map (mapping defaults + parquet + combo.indexSettings)
        client.performRequest(flush);
    /**
     *
     * per-layout index name.
    /**
        assertEquals("Bulk insert failed", 200, bulkResponse.getStatusLine().getStatusCode());
        // Delete if exists
        // for green + all shards active + none initializing so the first query always finds them.
     * Split an ndjson bulk body into {@code parts} non-empty chunks at action/source line
    }
    /**
            // index may not exist — ignore
        for (String indexName : dataset.indexNames) {
            : "datasets/" + dataset.name + "/mapping_" + indexName + ".json";
        // Delete if it already exists — ignore "not found".
            client.performRequest(new Request("DELETE", "/" + indexName));
            client.performRequest(new Request("DELETE", "/" + dataset.indexName));
     */
            // Split the ndjson into MULTI_SEGMENT_COUNT parts at action/source boundaries; flush
 * <p>
    }
            if (!line.isEmpty()) {
        try {
        // can then race ahead of the shard becoming searchable and fail with "no such shard". Wait
         * Exactly {@link #MULTI_SEGMENT_COUNT} segments per shard: bulk in that many flushed parts.
        } else {
            // layout == null: leave segment count to the engine (legacy non-plan-shape callers).
         * Parquet flush→segment is 1:1, so N parts give exactly N segments — deterministically pinning
     * segment count (e.g. the scan's {@code input_partitions}). The {@code suffix} disambiguates the
import org.apache.logging.log4j.Logger;
            // exactly that many segments. No force-merge — it would only risk collapsing them
        List<String> docLines = new ArrayList<>();
     * {@code layout} pins the per-shard segment layout ({@code null} = single bulk + flush, engine-
import java.io.BufferedReader;
        MULTI_SEGMENT("nseg");
    }
        logger.info("Dataset [{}] provisioned into parquet index [{}]", dataset.name, dataset.indexName);
        /** Exactly one segment per shard: single bulk + flush, then force-merge to one segment. */
     *
        String mapping = loadResource(mappingPath);
    public static final int MULTI_SEGMENT_COUNT = 2;
    private static void assertParquetFormat(RestClient client, String indexName) throws IOException {
        int pairsPerPart = Math.max(1, (int) Math.ceil((double) pairCount / parts));
        Request flushRequest = new Request("POST", "/" + indexName + "/_flush");
    public static String loadResource(String path) throws IOException {
        String bulkBody = loadResource(bulkPath);
        /**
            if (++pairsInChunk == pairsPerPart && chunks.size() < parts - 1) {
    // it means a combo's SettingsCombo.indexSettings map can't drive arbitrary index knobs. Replace
     * settings back to assert parquet is in effect — guarding against a silent fall-back to plain
     */
            provisionIndex(client, dataset, indexName, numberOfShards, layout);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
        // that every shard copy is active and done initializing — on a multi-node cluster a search
                + "\"index.composite.primary_data_format\": \"parquet\", "
     * <p>Lucene is set as the secondary format so the Lucene analytics backend is available
        // Each part is flushed into its own segment, so we need at least one doc per part — otherwise
        );
        provision(client, dataset, 0);
            }
        if (numberOfShards > 0) {
        flush.addParameter("force", "true");
    public static void provision(RestClient client, Dataset dataset, int numberOfShards, SegmentLayout layout) throws IOException {
        flushRequest.addParameter("force", "true");
     * purpose is to surface such ingest rejections as findings rather than let them pass silently.
 * Reads {@code mapping.json} and {@code bulk.json} from the dataset's resource
    }
        if (layout == SegmentLayout.MULTI_SEGMENT) {
        client.performRequest(createIndex);
    private static String injectParquetSettings(String mappingBody) {
     */
import java.io.InputStream;
        List<String> chunks = new ArrayList<>();
            );
                String content = reader.lines().collect(Collectors.joining("\n"));
        // utility class
 * The OpenSearch Contributors require contributions made to
/*
        bulkRequest.setOptions(bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
import java.io.InputStreamReader;
     * <p>Unlike {@link #provision(RestClient, Dataset)}, this variant reads the created index's
        Request settings = new Request("GET", "/" + indexName + "/_settings");
 */
 * Generic provisioner that creates an index from a {@link Dataset} descriptor.
        Request createIndex = new Request("PUT", "/" + dataset.indexName);
        bulkRequest.addParameter("refresh", "true");
        // Confirm the index really came up as a parquet/composite index; fail loudly otherwise.
         */
            assertNotNull("Resource not found: " + path, is);
        // Wait for index health. wait_for_status=yellow only guarantees primaries are assigned, not
     * Provision one index. {@code numberOfShards} overrides the mapping's value ({@code 0} keeps it).
        // Wait for the primary to be active before the first query. YELLOW (not GREEN): these datasets
            "index [" + indexName + "] was not created with the parquet data format (settings: " + body + ")",
 * <p>
 * directory and ingests them into the cluster. Idempotent — deletes the index
            }
                "dataset has " + pairCount + " doc(s), too few for a " + parts + "-segment layout (need >= " + parts + ")"
                chunks.add(chunk.toString());
        health.addParameter("wait_for_no_initializing_shards", "true");
        client.performRequest(healthRequest);
        settings.addParameter("flat_settings", "true");
     * because the Lucene backend never gets enrolled as a candidate.
            body.contains("\"index.composite.primary_data_format\":\"parquet\"")
 * Applies parquet data format settings so the dataset is queryable via the
        bulkRequest.setJsonEntity(bulk);
     * ingest (e.g. a multi-valued keyword rejected by the parquet backend). Used by suites whose
     * Replace the {@code number_of_shards} value in the mapping body. Matches the form
        }
    private static List<String> splitNdjson(String ndjson, int parts) {
            for (String part : splitNdjson(bulkBody, MULTI_SEGMENT_COUNT)) {
        } catch (Exception e) {
        health.addParameter("timeout", "60s");
     */
 * compatible open source license.
        }
            "\"index.pluggable.dataformat.enabled\": true, "
            }
        }
        String bulk = loadResource(dataset.bulkResourcePath());
            ? dataset.bulkResourcePath()
        Response bulkResponse = client.performRequest(bulkRequest);
        }
            throw new IllegalArgumentException(
import java.util.ArrayList;
import org.opensearch.client.RestClient;
        flush.addParameter("force", "true");
        );
    // rewriting the raw mapping JSON — brittle (depends on the literal "number_of_shards" token) and
    /** Bulk-ingest one ndjson body (refresh=true) and force a flush so its segment is committed. */
        client.performRequest(createIndex);
            // (see SegmentLayout.MULTI_SEGMENT). Background merge leaves so few segments alone.
            chunks.add(chunk.toString());
        for (String line : ndjson.split("\n")) {
                docLines.add(line);
        try {
        // that would stay unassigned on a single-node dev server.
    public static void provision(RestClient client, Dataset dataset) throws IOException {
        String bulkPath = dataset.indexNames.size() == 1
            this.suffix = suffix;
        String mapping = loadResource(dataset.mappingResourcePath());
        Request createIndex = new Request("PUT", "/" + indexName);
            bulkAndFlush(client, indexName, bulkBody);
        String mappingPath = dataset.indexNames.size() == 1
    private static String overrideNumberOfShards(String mappingBody, int numberOfShards) {
    /**
    // -> re-serialize. Shared by ~15 ITs, so do it as its own change and re-verify them.
     * Lucene if the {@code number_of_shards} anchor is ever missing — and treats a bulk response with
    /** The per-shard segment count produced by {@link SegmentLayout#MULTI_SEGMENT} (one flush each). */
     */
        String responseBody = new String(bulkResponse.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
         * the scan's {@code input_partitions}. No force-merge: it caps "at most N" and could collapse
        SegmentLayout(String suffix) {
    private static void provisionIndex(RestClient client, Dataset dataset, String indexName, int numberOfShards, SegmentLayout layout)
        bulkRequest.setOptions(
    public static void provision(RestClient client, Dataset dataset, int numberOfShards) throws IOException {
     * Provision the dataset, optionally pinning the per-shard segment layout via {@code layout}
        createIndex.setJsonEntity(indexBody);
     * Read the created index's settings back and assert the parquet/composite data format is actually in
     * Each chunk, flushed on its own, becomes one parquet segment.
        }
    private static void forceMergeAndFlush(RestClient client, String indexName, int maxSegments) throws IOException {
            throw new IOException("bulk ingest reported item errors for " + dataset.indexName + ": " + bulkBody);
 * this file be licensed under the Apache-2.0 license or a
                chunk.append(docLines.get(i + 1)).append('\n');
            }
 */
    }
        assertTrue(
        healthRequest.addParameter("wait_for_no_initializing_shards", "true");
     * is left to the engine (single bulk + flush); pass a {@link SegmentLayout} to control it.
        if (bulkBody.contains("\"errors\":true")) {
        Response response = client.performRequest(settings);
        // use number_of_replicas=0, so a plain yellow wait is sufficient and never blocks on replicas
            // after each. Each flush is one parquet segment (1:1), so every shard ends up with
    /**
    /**
    /**
                chunk = new StringBuilder();
        int pairsInChunk = 0;
                return content.isEmpty() ? content : content + "\n";
        // we'd silently produce fewer segments than requested and the shard plan's input_partitions
        Request healthRequest = new Request("GET", "/_cluster/health/" + indexName);
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");
    private DatasetProvisioner() {
     * per-item errors ({@code "errors":true}) as a provisioning failure rather than a silent partial
        return mappingBody.replaceAll("\"number_of_shards\"\\s*:\\s*\\d+", "\"number_of_shards\": " + numberOfShards);
    /** Force-merge every shard to exactly {@code maxSegments} parquet segments, then flush. */
        String indexBody = injectParquetSettings(mapping);
public final class DatasetProvisioner {
     * line, so every cut must land on an even document boundary to keep each chunk self-contained.
}
        }
                // deterministic (no per-shard divergence from differing segment counts).
        /** Short tag for the per-layout index name (e.g. {@code parquet_hits_2s_1seg}). */
        bulkRequest.setJsonEntity(ndjson);
     * Provision the dataset into the cluster with parquet as the primary data format. Segment layout
        String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
package org.opensearch.analytics.qa;
     * Provision a single-index {@code dataset} as a parquet/composite index and verify the parquet
import org.opensearch.client.Request;
        return mappingBody.replace(
     * for text-search functions (match, match_phrase, query_string, ...). Without it those
    private static final Logger logger = LogManager.getLogger(DatasetProvisioner.class);
        healthRequest.addParameter("timeout", "60s");
    }
        logger.info("Bulk response for index [{}]: {}", indexName, responseBody);
        assertEquals("bulk ingest failed for " + dataset.indexName, 200, bulkResponse.getStatusLine().getStatusCode());
     * effect. Guards against a silent fall-back to plain Lucene (e.g. if the {@code injectParquetSettings}
        client.performRequest(flush);
            }
        // the parquet/composite backend). Fail loudly on per-item errors so a silent zero-ingest can't
            if (layout == SegmentLayout.SINGLE_SEGMENT) {
    // TODO(plan-shape): both this and injectParquetSettings mutate the index settings by string/regex
    }
        StringBuilder chunk = new StringBuilder();
     * ({@code null} = single bulk + flush, engine-decided segment count).
            : "datasets/" + dataset.name + "/bulk_" + indexName + ".json";
        } catch (Exception e) {
        // Bulk ingest. The segment layout decides how the rows are committed into parquet segments.
            "\"number_of_shards\"",
        Request bulkRequest = new Request("POST", "/" + dataset.indexName + "/_bulk");
        return chunks;
        assertParquetFormat(client, dataset.indexName);
        for (int i = 0; i < docLines.size(); i += 2) {
    public static void provisionAndVerifyParquet(RestClient client, Dataset dataset) throws IOException {
                + "\"number_of_shards\""
     * How the dataset's documents are laid out into parquet segments per shard — a controlled axis
    public enum SegmentLayout {
        SINGLE_SEGMENT("1seg"),
        merge.addParameter("max_num_segments", Integer.toString(maxSegments));
     */
    private static void bulkAndFlush(RestClient client, String indexName, String ndjson) throws IOException {
import org.opensearch.client.Response;
import java.nio.charset.StandardCharsets;
     * decided). Used by tests needing multi-shard / multi-segment coverage of planner paths.
    }
        throws IOException {
     * anchor token is ever missing), which would otherwise let the suite pass against the wrong backend.
        logger.info("Dataset [{}] provisioned into index [{}]", dataset.name, indexName);
import static org.junit.Assert.assertEquals;
    }
                forceMergeAndFlush(client, indexName, 1);
        }
import static org.junit.Assert.assertNotNull;
        Response bulkResponse = client.performRequest(bulkRequest);
    }
                + "\"index.pluggable.dataformat\": \"composite\", "
import java.util.stream.Collectors;
        healthRequest.addParameter("wait_for_active_shards", "all");
        Request flush = new Request("POST", "/" + dataset.indexName + "/_flush");
        client.performRequest(flushRequest);
     * {@code "number_of_shards": <int>} produced by the canonical dataset mappings.
        }
    /**
    }
     * Load a classpath resource as a UTF-8 string.
        client.performRequest(health);
        // Load mapping, inject parquet settings, create index
            indexBody = overrideNumberOfShards(indexBody, numberOfShards);
    }
     * data format actually took effect, failing loudly on any per-item bulk ingest error.
 *
        bulkRequest.addParameter("refresh", "true");
                + "\"index.composite.secondary_data_formats\": [\"lucene\"], "
import org.apache.logging.log4j.LogManager;
     */
/**
            if (i + 1 < docLines.size()) {
        int pairCount = docLines.size() / 2; // (action, source) pairs
        // The _bulk API returns HTTP 200 even when individual items fail (e.g. a document rejected by
        client.performRequest(merge);
                bulkAndFlush(client, indexName, part);
        try (InputStream is = DatasetProvisioner.class.getClassLoader().getResourceAsStream(path)) {
    }
     */
import static org.junit.Assert.assertTrue;
     * for plan-shape tests, where the shard DataFusion physical plan can legitimately differ with
            bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build()
        Request health = new Request("GET", "/_cluster/health/" + dataset.indexName);
        }
 * DataFusion backend.
import java.io.IOException;
        if (pairCount < parts) {
                pairsInChunk = 0;
                // Collapse every shard to exactly one parquet segment so the shard physical plan is
        healthRequest.addParameter("wait_for_status", "green");
         * tiny segments to 1; the default TieredMergePolicy won't auto-merge so few either.
        }
        healthRequest.addParameter("wait_for_no_relocating_shards", "true");
     * functions fail at planning time with
        }
     */
