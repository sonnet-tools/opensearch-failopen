        } catch (Exception e) {
            + "}"
import java.util.Map;
 * Requires plugins: analytics-engine, analytics-backend-datafusion, analytics-backend-lucene,  
            + "},"  
        Map<String, Object> composite = (Map<String, Object>) index.get("composite");  
            + "    \"city\": { \"type\": \"keyword\" }"  
 * Requires feature flag: {@code opensearch.experimental.feature.pluggable.dataformat.enabled=true}  
        // Create index with parquet as primary data format  
        createIndex.setJsonEntity(body);  
 * compatible open source license.
            + "  }"
    public void testParquetIndexCreationAndIngestion() throws Exception {
        // Wait for green health
 */  
            bulkRequest.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build()
        healthRequest.addParameter("timeout", "30s");
        assertEquals("Bulk indexing should have no errors", false, bulkResponse.get("errors"));
            + "    \"age\": { \"type\": \"integer\" },"
    }
        logger.info("Verified index settings: primary_data_format = parquet");  
 * SPDX-License-Identifier: Apache-2.0
        Response settingsResponse = client().performRequest(new Request("GET", "/" + INDEX_NAME + "/_settings"));  
        bulk.append("{\"name\": \"alice\", \"age\": 30, \"score\": 95.5, \"city\": \"seattle\"}\n");
 * <p>
 * this file be licensed under the Apache-2.0 license or a
     * Creates a parquet-format index, verifies settings are persisted correctly,
 * <p>
        Map<String, Object> settings = (Map<String, Object>) indexSettings.get("settings");
import org.opensearch.client.Request;
        logger.info("Created parquet index [{}]", INDEX_NAME);  
        assertNotNull("Search response should contain hits", searchMap.get("hits"));  
        Request searchRequest = new Request("POST", "/" + INDEX_NAME + "/_search");
        Request createIndex = new Request("PUT", "/" + INDEX_NAME);
            + "    \"score\": { \"type\": \"double\" },"
package org.opensearch.analytics.qa;
 * created, documents can be ingested, and the index settings are correctly persisted.
        searchRequest.setJsonEntity("{\"size\": 0, \"track_total_hits\": true}");  
        try {  
        @SuppressWarnings("unchecked")  
            + "\"settings\": {"
        Request bulkRequest = new Request("POST", "/" + INDEX_NAME + "/_bulk");  
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        @SuppressWarnings("unchecked")
}  
            client().performRequest(new Request("DELETE", "/" + INDEX_NAME));
        Map<String, Object> index = (Map<String, Object>) settings.get("index");
        bulkRequest.setJsonEntity(bulk.toString());
        bulk.append("{\"index\": {}}\n");
        bulkRequest.addParameter("refresh", "true");
        // Simple search to verify index is functional
            + "  \"number_of_shards\": 1,"  
/*  
        );
        }
     * ingests documents, and runs a simple search to confirm the index is functional.
            // index may not exist  
        // Bulk index 5 documents
        bulk.append("{\"index\": {}}\n");
            + "}";  
 *
            + "  \"properties\": {"
        String body = "{"
    /**  
        Map<String, Object> settingsMap = assertOkAndParse(settingsResponse, "Get index settings");
        logger.info("Indexed 5 documents into parquet index [{}]", INDEX_NAME);
        assertEquals("Primary data format should be parquet", "parquet", composite.get("primary_data_format"));
        @SuppressWarnings("unchecked")
public class ParquetDataFusionIT extends AnalyticsRestTestCase {
 * The OpenSearch Contributors require contributions made to  
            + "  \"index.composite.primary_data_format\": \"parquet\","
        bulk.append("{\"index\": {}}\n");
        bulk.append("{\"index\": {}}\n");  
        healthRequest.addParameter("wait_for_status", "green");
        assertNotNull("Settings response should contain index", indexSettings);
        Map<String, Object> bulkResponse = assertOkAndParse(client().performRequest(bulkRequest), "Bulk index");  
        client().performRequest(healthRequest);  
            + "  \"index.pluggable.dataformat.enabled\": true,"
        Request healthRequest = new Request("GET", "/_cluster/health/" + INDEX_NAME);  
        // Clean up if exists from a previous run
        Map<String, Object> searchMap = assertOkAndParse(searchResponse, "Simple search");
/**  
        StringBuilder bulk = new StringBuilder();  
 * End-to-end integration test for pure Parquet indexing with DataFusion.
            + "    \"name\": { \"type\": \"keyword\" },"  
     */  
 * Validates that a composite index with parquet as primary data format can be  
        bulk.append("{\"index\": {}}\n");  
        Map<String, Object> indexSettings = (Map<String, Object>) settingsMap.get(INDEX_NAME);
        Response searchResponse = client().performRequest(searchRequest);
        // Verify index settings
    private static final String INDEX_NAME = "parquet_e2e_test";
        assertEquals("Index creation should be acknowledged", true, createResponse.get("acknowledged"));
 * dsl-query-executor, composite-engine, parquet-data-format.
        logger.info("Simple search completed successfully on parquet index [{}]", INDEX_NAME);
 * <p>
            + "  \"index.pluggable.dataformat\": \"composite\","  
        Map<String, Object> createResponse = assertOkAndParse(client().performRequest(createIndex), "Create parquet index");
            + "\"mappings\": {"
        @SuppressWarnings("unchecked")  
        bulkRequest.setOptions(  
        bulk.append("{\"name\": \"carol\", \"age\": 35, \"score\": 92.3, \"city\": \"seattle\"}\n");  
        bulk.append("{\"name\": \"eve\", \"age\": 32, \"score\": 91.0, \"city\": \"seattle\"}\n");
 */
        bulk.append("{\"name\": \"bob\", \"age\": 25, \"score\": 88.0, \"city\": \"portland\"}\n");
import org.opensearch.client.Response;
        bulk.append("{\"name\": \"dave\", \"age\": 28, \"score\": 76.8, \"city\": \"portland\"}\n");
            + "  \"number_of_replicas\": 0,"
