        String indexName = "test-custom-separator";
            anchorBytes.length,
        // Document without path field should not have routing, so no routing needed for get
                        .field("content", "Q1 campaign")
import org.opensearch.search.SearchHit;
        BulkRequest bulkRequest = new BulkRequest();
import org.opensearch.index.query.PrefixQueryBuilder;
        // Document 3 should have different routing (different anchor: /company/marketing)
                        .endObject()
        // Create pipeline with ignore_missing = true
            );
    @Override
        var getPipelineResponse = client().admin().cluster().prepareGetPipeline(pipelineId).get();
        }
        );
                        .endObject()
        assertTrue("Document 2 should exist", doc2.isExists());
                .field("path_separator", "\\")
                    .startObject("properties")
        );
import static org.hamcrest.Matchers.equalTo;
        assertThat("Should find engineering documents", searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        BytesReference pipelineConfig = BytesReference.bytes(
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
        client().index(indexRequest).get();
        String engineeringRouting = computeRouting("company/engineering");
            Map.of("number_of_shards", 3, "number_of_replicas", 0, "index.default_pipeline", pipelineId)
        GetResponse doc2 = client().prepareGet(indexName, "2").setRouting(engineeringRouting).get();
        GetResponse doc = client().prepareGet(indexName, "missing1").get();
        IndexRequest indexRequest = new IndexRequest(indexName).id("win1")
        client().admin().indices().prepareRefresh(indexName).get();
    public void testHierarchicalRoutingProcessorRegistration() throws Exception {
import org.opensearch.action.bulk.BulkRequest;
        String pipelineId = "test-processor-registration";
        DocumentField routing = doc.getField("_routing");
                .endObject()
 * The OpenSearch Contributors require contributions made to
                .endObject()
                        .endObject()
    public void testHierarchicalRoutingProcessor() throws Exception {
    }
                .startArray("processors")
                .field("anchor_depth", 1)
                    jsonBuilder().startObject()
            jsonBuilder().startObject()
    }
import org.opensearch.action.bulk.BulkResponse;
        client().index(indexRequest).get();
        );
                .field("anchor_depth", 2)
}
        assertThat("Document 3 should have routing", doc3Routing, notNullValue());
        assertFalse("Bulk indexing should succeed", bulkResponse.hasFailures());
        client().admin().indices().create(createIndexRequest).get();
    public void testHierarchicalRoutingWithMissingField() throws Exception {
                .endObject()
import org.opensearch.search.builder.SearchSourceBuilder;
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
        String pipelineId = "hierarchical-routing-custom-sep";
        )
                .startObject()
        return Arrays.asList(IngestCommonModulePlugin.class);
        IndexRequest indexRequest = new IndexRequest(indexName).id("missing1")
            Map.of("number_of_shards", 2, "number_of_replicas", 0, "index.default_pipeline", pipelineId)
        // Documents 1 and 2 should have same routing (same anchor: /company/engineering)
                .endObject()
                    .startObject("content")
                .field("anchor_depth", 2)
    }
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
        return computeRouting(anchor, "/");
            new IndexRequest(indexName).id("2")
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.core.common.bytes.BytesReference;
                    .endObject()
        );
        assertTrue("Pipeline should be created successfully", getPipelineResponse.isFound());
            new org.opensearch.common.hash.MurmurHash3.Hash128()
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
                        .field("file_path", "/company/engineering/backend/api.pdf")
        client().admin().cluster().prepareDeletePipeline(pipelineId).get();
                .field("anchor_depth", 2)
import org.opensearch.common.document.DocumentField;
                .field("path_field", "path")
        assertTrue("Document 1 should exist", doc1.isExists());
        assertThat("Document 2 should have routing", doc2Routing, notNullValue());
                .startObject()
        assertThat("Documents with same anchor should have same routing", doc1Routing.getValue(), equalTo(doc2Routing.getValue()));
            .setSource(new SearchSourceBuilder().query(new PrefixQueryBuilder("file_path", "/company/engineering")))
        // Create ingest pipeline with hierarchical routing processor
 *
                .endArray()
                .endObject()
                .startObject("hierarchical_routing")
        // Marketing documents (should get different routing)
    }
        assertNotEquals("Documents with different anchors should have different routing", doc1Routing.getValue(), doc3Routing.getValue());
            String filePath = (String) hit.getSourceAsMap().get("file_path");
                )
        String windowsRouting = computeRouting("C:\\Users", "\\");
                .source(
                .startObject("hierarchical_routing")
        client().admin().indices().create(createIndexRequest).get();
        // Verify processor is registered by attempting to create a pipeline
            .mapping(
                )
        GetResponse doc1 = client().prepareGet(indexName, "1").setRouting(engineeringRouting).get();
            jsonBuilder().startObject()
            new IndexRequest(indexName).id("3")
            0,
                    .field("type", "keyword")
                    jsonBuilder().startObject()
                )
        );
        return String.valueOf(hash == Long.MIN_VALUE ? 0L : (hash < 0 ? -hash : hash));
        String indexName = "test-ignore-missing";
                .field("path_separator", "/")
    }
        client().admin().indices().create(createIndexRequest).get();
    // Helper method to compute expected routing (mirrors processor logic)
                    .field("windows_path", "C:\\Users\\admin\\Documents\\file.txt")
                .endObject()
        assertTrue("Document should exist", doc.isExists());
    }
    public void testHierarchicalRoutingWithCustomSeparator() throws Exception {
                    .field("type", "text")
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
    private String computeRouting(String anchor, String separator) {
        // Index document with Windows-style path
    }
        assertThat("Document should have routing", routing, notNullValue());
                .field("path_field", "nonexistent_field")
            .source(
        DocumentField doc1Routing = doc1.getField("_routing");
                .startArray("processors")
        String indexName = "test-hierarchical-routing";
                .field("ignore_missing", true)
        BytesReference pipelineConfig = BytesReference.bytes(
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
        // Clean up
        // Verify documents were routed correctly
                    .endObject()
        // Create index with multiple shards
        );
                .endObject()
            Map.of("number_of_shards", 2, "number_of_replicas", 0, "index.default_pipeline", pipelineId)
        // Check that routing was applied
import java.util.Map;
        // Engineering documents (should get same routing)
        bulkRequest.add(
                jsonBuilder().startObject()
        DocumentField doc3Routing = doc3.getField("_routing");
    private String computeRouting(String anchor) {
        // We need to calculate the expected routing values to retrieve the documents
        // Test search functionality
        // Refresh to make documents searchable
        assertThat("Document 1 should have routing", doc1Routing, notNullValue());
                    .endObject()
import java.util.Collection;
                .endArray()
                    .endObject()
                    .startObject("file_path")
        // Calculate expected routing for Windows path
        BulkResponse bulkResponse = client().bulk(bulkRequest).get();
                .startObject("hierarchical_routing")
        BytesReference pipelineConfig = BytesReference.bytes(
                .source(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                        .field("file_path", "/company/engineering/frontend/ui.pdf")
import org.opensearch.action.index.IndexRequest;
                .field("path_field", "windows_path")
        String pipelineId = "hierarchical-routing-ignore-missing";
        GetResponse doc = client().prepareGet(indexName, "win1").setRouting(windowsRouting).get();
public class HierarchicalRoutingProcessorIT extends OpenSearchIntegTestCase {
            assertTrue("Found document should be in engineering folder", filePath.startsWith("/company/engineering"));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    jsonBuilder().startObject()
        client().admin().indices().prepareRefresh(indexName).get();
                .endObject()
                jsonBuilder().startObject()
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
 * SPDX-License-Identifier: Apache-2.0
        SearchResponse searchResponse = client().prepareSearch(indexName)
        long hash = org.opensearch.common.hash.MurmurHash3.hash128(
        byte[] anchorBytes = anchor.getBytes(java.nio.charset.StandardCharsets.UTF_8);
import static org.hamcrest.Matchers.notNullValue;
        // Index documents with same hierarchical prefix
 * this file be licensed under the Apache-2.0 license or a
                .endObject()
import org.opensearch.action.search.SearchResponse;
        // Verify pipeline was created
            anchorBytes,
            jsonBuilder().startObject()
        BytesReference pipelineConfig = BytesReference.bytes(
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
                        .field("content", "API documentation")
        );
                    .field("content", "Windows document")
                jsonBuilder().startObject().field("other_field", "some value").field("content", "Document without path field").endObject()
import org.opensearch.action.get.GetResponse;
        ).h1;
                .startObject()
 * compatible open source license.
        DocumentField doc2Routing = doc2.getField("_routing");
        );
        bulkRequest.add(
        GetResponse doc3 = client().prepareGet(indexName, "3").setRouting(marketingRouting).get();
                        .field("content", "UI guidelines")
        assertTrue("Document should be indexed even with missing field", doc.isExists());
        // This mirrors the logic in HierarchicalRoutingProcessor
            0,
            jsonBuilder().startObject()
        // Routing should be null since field was missing and ignored
            .source(
        String pipelineId = "hierarchical-routing-test";
package org.opensearch.ingest.common;
                .endObject()
        // Index document without the required field
        String marketingRouting = computeRouting("company/marketing");
import org.opensearch.test.OpenSearchIntegTestCase;
                .endArray()
        bulkRequest.add(
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
                .field("path_field", "file_path")
            new IndexRequest(indexName).id("1")
        client().admin().indices().prepareRefresh(indexName).get();
                .endObject()
                .startArray("processors")
        );
                .source(
            );
        // Create pipeline with custom separator
import org.opensearch.plugins.Plugin;
            );
/*
import java.util.Arrays;
                .endArray()
 */
        // This should succeed if processor is properly registered
        assertTrue("Document 3 should exist", doc3.isExists());
                    .endObject()
                        .field("file_path", "/company/marketing/campaigns/q1.pdf")
            .get();
                .startObject("hierarchical_routing")
                .startObject()
                .startArray("processors")
                .endObject()
