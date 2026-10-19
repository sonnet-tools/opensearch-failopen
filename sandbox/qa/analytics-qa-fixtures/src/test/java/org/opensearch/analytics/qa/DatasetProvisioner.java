        // The _bulk API returns HTTP 200 even when individual items fail (e.g. a document rejected by
        int pairsPerPart = Math.max(1, (int) Math.ceil((double) pairCount / parts));  
     */
        if (layout == SegmentLayout.MULTI_SEGMENT) {
            }
        client.performRequest(flushRequest);
        }  
        public final String suffix;
                + "\"index.pluggable.dataformat\": \"composite\", "
    }
            // index may not exist — ignore
        client.performRequest(health);  
    }
        // utility class  
                "dataset has " + pairCount + " doc(s), too few for a " + parts + "-segment layout (need >= " + parts + ")"  
        // masquerade as a successful provision.
    }
            client.performRequest(new Request("DELETE", "/" + dataset.indexName));  
        try (InputStream is = DatasetProvisioner.class.getClassLoader().getResourceAsStream(path)) {
        }  
        for (String indexName : dataset.indexNames) {
        client.performRequest(healthRequest);  
        String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
     */
     * <p>Lucene is set as the secondary format so the Lucene analytics backend is available
        healthRequest.addParameter("wait_for_active_shards", "all");
        flush.addParameter("force", "true");
            chunk.append(docLines.get(i)).append('\n');
     * Provision one index. {@code numberOfShards} overrides the mapping's value ({@code 0} keeps it).  
        // Delete if exists  
        provision(client, dataset, numberOfShards, null);
            // index may not exist — ignore
}  
     *
        if (pairCount < parts) {
 * SPDX-License-Identifier: Apache-2.0
        /** Short tag for the per-layout index name (e.g. {@code parquet_hits_2s_1seg}). */  
import static org.junit.Assert.assertEquals;
     * per-layout index name.
        try {
        Request health = new Request("GET", "/_cluster/health/" + dataset.indexName);
        // use number_of_replicas=0, so a plain yellow wait is sufficient and never blocks on replicas  
        // wouldn't match the golden. Fail loudly instead.  
    /**
import org.apache.logging.log4j.Logger;
            assertNotNull("Resource not found: " + path, is);
            chunks.add(chunk.toString());
    private static void bulkAndFlush(RestClient client, String indexName, String ndjson) throws IOException {
                // deterministic (no per-shard divergence from differing segment counts).
     * line, so every cut must land on an even document boundary to keep each chunk self-contained.
 * directory and ingests them into the cluster. Idempotent — deletes the index  
     * purpose is to surface such ingest rejections as findings rather than let them pass silently.
        logger.info("Bulk response for index [{}]: {}", indexName, responseBody);  
    }  
        try {
                String content = reader.lines().collect(Collectors.joining("\n"));
import static org.junit.Assert.assertTrue;  
        return mappingBody.replaceAll("\"number_of_shards\"\\s*:\\s*\\d+", "\"number_of_shards\": " + numberOfShards);
     * functions fail at planning time with  
    }  
        Request createIndex = new Request("PUT", "/" + indexName);
         * tiny segments to 1; the default TieredMergePolicy won't auto-merge so few either.
        assertEquals("Bulk insert failed", 200, bulkResponse.getStatusLine().getStatusCode());
            // Split the ndjson into MULTI_SEGMENT_COUNT parts at action/source boundaries; flush  
 * The OpenSearch Contributors require contributions made to  
    public static void provision(RestClient client, Dataset dataset) throws IOException {  
        Request bulkRequest = new Request("POST", "/" + indexName + "/_bulk");  
        }
        String bulk = loadResource(dataset.bulkResourcePath());
        // Confirm the index really came up as a parquet/composite index; fail loudly otherwise.
            // (see SegmentLayout.MULTI_SEGMENT). Background merge leaves so few segments alone.  
                bulkAndFlush(client, indexName, part);
        bulkRequest.addParameter("refresh", "true");  
        for (String line : ndjson.split("\n")) {
            bulkAndFlush(client, indexName, bulkBody);
        flushRequest.addParameter("force", "true");  
     * is left to the engine (single bulk + flush); pass a {@link SegmentLayout} to control it.
        String mapping = loadResource(mappingPath);
        // for green + all shards active + none initializing so the first query always finds them.
    /**
        client.performRequest(flush);  
     * ({@code null} = single bulk + flush, engine-decided segment count).
    private static final Logger logger = LogManager.getLogger(DatasetProvisioner.class);
     * {@code "No backend can evaluate filter predicate [OTHER_FUNCTION] on fields [...:text]"}
        int pairCount = docLines.size() / 2; // (action, source) pairs  
        throws IOException {
        flush.addParameter("force", "true");
            "\"index.pluggable.dataformat.enabled\": true, "
        assertTrue(  
    /**
            if (++pairsInChunk == pairsPerPart && chunks.size() < parts - 1) {  
     * for plan-shape tests, where the shard DataFusion physical plan can legitimately differ with  
         * the scan's {@code input_partitions}. No force-merge: it caps "at most N" and could collapse
    // it means a combo's SettingsCombo.indexSettings map can't drive arbitrary index knobs. Replace
 * <p>
    public static void provision(RestClient client, Dataset dataset, int numberOfShards, SegmentLayout layout) throws IOException {  
            "\"number_of_shards\"",  
                // Collapse every shard to exactly one parquet segment so the shard physical plan is
     * Split an ndjson bulk body into {@code parts} non-empty chunks at action/source line  
        for (int i = 0; i < docLines.size(); i += 2) {
            throw new IOException("bulk ingest reported item errors for " + dataset.indexName + ": " + bulkBody);
            // layout == null: leave segment count to the engine (legacy non-plan-shape callers).
import java.util.List;
        Request createIndex = new Request("PUT", "/" + dataset.indexName);  
            // exactly that many segments. No force-merge — it would only risk collapsing them
import org.opensearch.client.RestClient;
    }  
        String mappingPath = dataset.indexNames.size() == 1
            : "datasets/" + dataset.name + "/bulk_" + indexName + ".json";
    /**
         * Exactly {@link #MULTI_SEGMENT_COUNT} segments per shard: bulk in that many flushed parts.
     * <p>Unlike {@link #provision(RestClient, Dataset)}, this variant reads the created index's
        }
        Response response = client.performRequest(settings);
         */  
     * for text-search functions (match, match_phrase, query_string, ...). Without it those
     * Provision the dataset, optionally pinning the per-shard segment layout via {@code layout}  
 * compatible open source license.
            "index [" + indexName + "] was not created with the parquet data format (settings: " + body + ")",
     */  
    private static void forceMergeAndFlush(RestClient client, String indexName, int maxSegments) throws IOException {
 */  
    private static void provisionIndex(RestClient client, Dataset dataset, String indexName, int numberOfShards, SegmentLayout layout)
        // can then race ahead of the shard becoming searchable and fail with "no such shard". Wait
 * <p>
            }
    private static List<String> splitNdjson(String ndjson, int parts) {
        }
        // Bulk ingest. The segment layout decides how the rows are committed into parquet segments.
     */  
     */  
        Response bulkResponse = client.performRequest(bulkRequest);  
     */
        );  
 * this file be licensed under the Apache-2.0 license or a
        return chunks;  
        );
        Request healthRequest = new Request("GET", "/_cluster/health/" + indexName);  
        logger.info("Dataset [{}] provisioned into parquet index [{}]", dataset.name, dataset.indexName);
        MULTI_SEGMENT("nseg");
import java.io.BufferedReader;
     * per-item errors ({@code "errors":true}) as a provisioning failure rather than a silent partial
            if (!line.isEmpty()) {
        if (numberOfShards > 0) {
    // TODO(plan-shape): both this and injectParquetSettings mutate the index settings by string/regex  
 */
            bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build()
        health.addParameter("wait_for_status", "yellow");  
    }
        client.performRequest(createIndex);  
        healthRequest.addParameter("timeout", "60s");
        createIndex.setJsonEntity(indexBody);
    /**  
            ? dataset.bulkResourcePath()
import java.util.ArrayList;  
        settings.addParameter("flat_settings", "true");  
            this.suffix = suffix;
        logger.info("Dataset [{}] provisioned into index [{}]", dataset.name, indexName);
        String responseBody = new String(bulkResponse.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
        provision(client, dataset, 0);
 * DataFusion backend.
    public static final int MULTI_SEGMENT_COUNT = 2;  
        createIndex.setJsonEntity(injectParquetSettings(mapping));
import java.io.IOException;
         * Parquet flush→segment is 1:1, so N parts give exactly N segments — deterministically pinning  
            if (layout == SegmentLayout.SINGLE_SEGMENT) {  
    // rewriting the raw mapping JSON — brittle (depends on the literal "number_of_shards" token) and
     *  
     */
        String bulkPath = dataset.indexNames.size() == 1  
        Request bulkRequest = new Request("POST", "/" + dataset.indexName + "/_bulk");
import java.io.InputStream;  
        healthRequest.addParameter("wait_for_no_initializing_shards", "true");  
            // after each. Each flush is one parquet segment (1:1), so every shard ends up with
        assertParquetFormat(client, dataset.indexName);
    // with: parse mapping JSON -> merge a settings map (mapping defaults + parquet + combo.indexSettings)  
                chunks.add(chunk.toString());
                forceMergeAndFlush(client, indexName, 1);  
    /** Force-merge every shard to exactly {@code maxSegments} parquet segments, then flush. */
        );
    private static String overrideNumberOfShards(String mappingBody, int numberOfShards) {  
     * data format actually took effect, failing loudly on any per-item bulk ingest error.  
     * anchor token is ever missing), which would otherwise let the suite pass against the wrong backend.
            }
        } else {
     */  
        SegmentLayout(String suffix) {  
        }  
    }
    private DatasetProvisioner() {
        }  
        assertEquals("bulk ingest failed for " + dataset.indexName, 200, bulkResponse.getStatusLine().getStatusCode());
     * How the dataset's documents are laid out into parquet segments per shard — a controlled axis
     * Provision a single-index {@code dataset} as a parquet/composite index and verify the parquet
        int pairsInChunk = 0;  
     * Each chunk, flushed on its own, becomes one parquet segment.  
import static org.junit.Assert.assertNotNull;
     */
    public static void provision(RestClient client, Dataset dataset, int numberOfShards) throws IOException {
        healthRequest.addParameter("wait_for_no_relocating_shards", "true");
     * segment count (e.g. the scan's {@code input_partitions}). The {@code suffix} disambiguates the
            : "datasets/" + dataset.name + "/mapping_" + indexName + ".json";
     */  
    /**  
    /**
import org.opensearch.client.Request;  
        }
                && body.contains("\"index.pluggable.dataformat.enabled\":\"true\"")  
        bulkRequest.setJsonEntity(bulk);
    }
            throw new IllegalArgumentException(
        bulkRequest.setOptions(bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        client.performRequest(merge);
        // we'd silently produce fewer segments than requested and the shard plan's input_partitions
            }
        return mappingBody.replace(
    private static String injectParquetSettings(String mappingBody) {
     * Inject parquet data format settings into the existing settings block.
            );
        healthRequest.addParameter("wait_for_status", "green");
import org.opensearch.client.Response;
        } catch (Exception e) {  
                chunk.append(docLines.get(i + 1)).append('\n');
        // that every shard copy is active and done initializing — on a multi-node cluster a search  
        Response bulkResponse = client.performRequest(bulkRequest);  
    /**
        health.addParameter("wait_for_no_initializing_shards", "true");
     * {@code layout} pins the per-shard segment layout ({@code null} = single bulk + flush, engine-
        client.performRequest(createIndex);
        // Delete if it already exists — ignore "not found".
                pairsInChunk = 0;  
     * settings back to assert parquet is in effect — guarding against a silent fall-back to plain  
     * effect. Guards against a silent fall-back to plain Lucene (e.g. if the {@code injectParquetSettings}
        /** Exactly one segment per shard: single bulk + flush, then force-merge to one segment. */
 * Applies parquet data format settings so the dataset is queryable via the  
     * Load a classpath resource as a UTF-8 string.
    private static void assertParquetFormat(RestClient client, String indexName) throws IOException {
        }
                + "\"index.composite.secondary_data_formats\": [\"lucene\"], "
    }  
    /**
 * first if it already exists.
                chunk = new StringBuilder();
        /**
 *
        // the parquet/composite backend). Fail loudly on per-item errors so a silent zero-ingest can't  
        Request settings = new Request("GET", "/" + indexName + "/_settings");
     * because the Lucene backend never gets enrolled as a candidate.
        String mapping = loadResource(dataset.mappingResourcePath());
    public enum SegmentLayout {
 * Reads {@code mapping.json} and {@code bulk.json} from the dataset's resource
import java.util.stream.Collectors;
            if (i + 1 < docLines.size()) {  
     * Read the created index's settings back and assert the parquet/composite data format is actually in  
            provisionIndex(client, dataset, indexName, numberOfShards, layout);
        // Wait for the primary to be active before the first query. YELLOW (not GREEN): these datasets
 * Generic provisioner that creates an index from a {@link Dataset} descriptor.  
        Request flushRequest = new Request("POST", "/" + indexName + "/_flush");
                return content.isEmpty() ? content : content + "\n";
    }
            for (String part : splitNdjson(bulkBody, MULTI_SEGMENT_COUNT)) {
            ? dataset.mappingResourcePath()  
            indexBody = overrideNumberOfShards(indexBody, numberOfShards);
    /** The per-shard segment count produced by {@link SegmentLayout#MULTI_SEGMENT} (one flush each). */
        }
        List<String> chunks = new ArrayList<>();
import java.io.InputStreamReader;
import org.apache.logging.log4j.LogManager;
     * decided). Used by tests needing multi-shard / multi-segment coverage of planner paths.
        health.addParameter("timeout", "60s");
    // -> re-serialize. Shared by ~15 ITs, so do it as its own change and re-verify them.
        // Each part is flushed into its own segment, so we need at least one doc per part — otherwise
/**
        if (bulkBody.contains("\"errors\":true")) {  
        Request merge = new Request("POST", "/" + indexName + "/_forcemerge");  
        if (chunk.length() > 0) {  
    }  
        String bulkBody = loadResource(bulkPath);  
        Request flush = new Request("POST", "/" + indexName + "/_flush");  
    /** Bulk-ingest one ndjson body (refresh=true) and force a flush so its segment is committed. */
        // that would stay unassigned on a single-node dev server.
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {  
        bulkRequest.setOptions(  
     * {@code "number_of_shards": <int>} produced by the canonical dataset mappings.
     * boundaries. The bulk format alternates an action line ({@code {"index":{}}}) and a source
                + "\"index.composite.primary_data_format\": \"parquet\", "  
            }  
    }
        // Wait for index health. wait_for_status=yellow only guarantees primaries are assigned, not
            }  
     * ingest (e.g. a multi-valued keyword rejected by the parquet backend). Used by suites whose  
            body.contains("\"index.composite.primary_data_format\":\"parquet\"")
package org.opensearch.analytics.qa;
    }
     * Replace the {@code number_of_shards} value in the mapping body. Matches the form  
        } catch (Exception e) {
        Request flush = new Request("POST", "/" + dataset.indexName + "/_flush");
     * Provision the dataset into the cluster with parquet as the primary data format. Segment layout
        SINGLE_SEGMENT("1seg"),  
        client.performRequest(flush);
        merge.addParameter("max_num_segments", Integer.toString(maxSegments));
        String bulkBody = new String(bulkResponse.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
                docLines.add(line);  
        }
        }
public final class DatasetProvisioner {  
        bulkRequest.addParameter("refresh", "true");
            client.performRequest(new Request("DELETE", "/" + indexName));
        StringBuilder chunk = new StringBuilder();
        // Load mapping, inject parquet settings, create index
import java.nio.charset.StandardCharsets;
        String indexBody = injectParquetSettings(mapping);  
/*  
    public static String loadResource(String path) throws IOException {  
        List<String> docLines = new ArrayList<>();  
                + "\"number_of_shards\""
        bulkRequest.setJsonEntity(ndjson);
     * Lucene if the {@code number_of_shards} anchor is ever missing — and treats a bulk response with
    public static void provisionAndVerifyParquet(RestClient client, Dataset dataset) throws IOException {  
    /**
