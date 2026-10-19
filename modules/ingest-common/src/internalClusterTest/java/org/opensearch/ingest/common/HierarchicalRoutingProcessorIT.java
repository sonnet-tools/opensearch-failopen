                .field("anchor_depth", 2)  
                    .endObject()
                .field("path_field", "file_path")
                .startObject("hierarchical_routing")
        GetResponse doc = client().prepareGet(indexName, "win1").setRouting(windowsRouting).get();
import org.opensearch.index.query.PrefixQueryBuilder;
    }
                .endObject()
        String engineeringRouting = computeRouting("company/engineering");  
            anchorBytes,
                .source(
        DocumentField doc3Routing = doc3.getField("_routing");
        );
import org.opensearch.test.OpenSearchIntegTestCase;
                .endObject()  
import org.opensearch.action.bulk.BulkRequest;
        BytesReference pipelineConfig = BytesReference.bytes(
        // Index documents with same hierarchical prefix
        assertThat("Document 1 should have routing", doc1Routing, notNullValue());
            jsonBuilder().startObject()
        String pipelineId = "hierarchical-routing-test";
                )
        ).h1;  
        );  
        // Check that routing was applied
        assertThat("Documents with same anchor should have same routing", doc1Routing.getValue(), equalTo(doc2Routing.getValue()));  
                    .startObject("file_path")
        bulkRequest.add(
                        .endObject()  
            new IndexRequest(indexName).id("1")
                .endObject()
        // Clean up  
        BytesReference pipelineConfig = BytesReference.bytes(  
        DocumentField routing = doc.getField("_routing");
        BytesReference pipelineConfig = BytesReference.bytes(
            anchorBytes.length,  
                    .endObject()
        DocumentField doc1Routing = doc1.getField("_routing");  
                .endObject()  
        // Create pipeline with ignore_missing = true  
        );  
            new IndexRequest(indexName).id("2")
        // Documents 1 and 2 should have same routing (same anchor: /company/engineering)
        GetResponse doc = client().prepareGet(indexName, "missing1").get();
            jsonBuilder().startObject()  
        for (SearchHit hit : searchResponse.getHits().getHits()) {  
        );
    public void testHierarchicalRoutingProcessorRegistration() throws Exception {
        assertTrue("Document 2 should exist", doc2.isExists());
                .endArray()
            );
                        .field("content", "UI guidelines")  
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
                    .field("type", "text")  
                    .startObject("content")
                .endArray()
        String pipelineId = "test-processor-registration";  
        // Engineering documents (should get same routing)
                        .endObject()
        );
                .startArray("processors")
import org.opensearch.common.document.DocumentField;
                .endObject()
                .endObject()
        long hash = org.opensearch.common.hash.MurmurHash3.hash128(  
        client().admin().cluster().prepareDeletePipeline(pipelineId).get();
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();  
                        .field("file_path", "/company/engineering/frontend/ui.pdf")
        String indexName = "test-ignore-missing";  
                .source(
                )
                        .field("file_path", "/company/marketing/campaigns/q1.pdf")
    private String computeRouting(String anchor, String separator) {  
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
            .get();
        BytesReference pipelineConfig = BytesReference.bytes(
        var getPipelineResponse = client().admin().cluster().prepareGetPipeline(pipelineId).get();  
import static org.hamcrest.Matchers.notNullValue;
            assertTrue("Found document should be in engineering folder", filePath.startsWith("/company/engineering"));
    }  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                .field("ignore_missing", true)  
            jsonBuilder().startObject()  
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
import java.util.Collection;
            String filePath = (String) hit.getSourceAsMap().get("file_path");
        String windowsRouting = computeRouting("C:\\Users", "\\");  
        return Arrays.asList(IngestCommonModulePlugin.class);
                    jsonBuilder().startObject()  
import static org.hamcrest.Matchers.equalTo;  
        byte[] anchorBytes = anchor.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                .startObject("hierarchical_routing")  
                jsonBuilder().startObject()
    public void testHierarchicalRoutingProcessor() throws Exception {
}  
            );  
        IndexRequest indexRequest = new IndexRequest(indexName).id("win1")  
            Map.of("number_of_shards", 2, "number_of_replicas", 0, "index.default_pipeline", pipelineId)  
            0,
                .startArray("processors")  
 */  
 * The OpenSearch Contributors require contributions made to  
        // Marketing documents (should get different routing)
                .startObject()  
        client().admin().indices().prepareRefresh(indexName).get();  
                .source(  
        assertThat("Document should have routing", routing, notNullValue());
        // Verify documents were routed correctly
        client().admin().indices().create(createIndexRequest).get();
                .field("path_separator", "\\")
        client().admin().indices().prepareRefresh(indexName).get();
        );  
 * compatible open source license.
                .field("anchor_depth", 1)
        SearchResponse searchResponse = client().prepareSearch(indexName)  
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
    private String computeRouting(String anchor) {
                    .endObject()
        assertTrue("Document should exist", doc.isExists());  
import java.util.Map;  
                .endObject()
        // This mirrors the logic in HierarchicalRoutingProcessor
                    .field("windows_path", "C:\\Users\\admin\\Documents\\file.txt")  
                .field("anchor_depth", 2)
            .source(
import org.opensearch.action.search.SearchResponse;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .startObject()
import org.opensearch.plugins.Plugin;
        }  
                .endArray()  
            0,
            );
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)  
        client().index(indexRequest).get();
                .startObject("hierarchical_routing")
            Map.of("number_of_shards", 3, "number_of_replicas", 0, "index.default_pipeline", pipelineId)  
                .endObject()
                    .endObject()
        // Create ingest pipeline with hierarchical routing processor  
        assertNotEquals("Documents with different anchors should have different routing", doc1Routing.getValue(), doc3Routing.getValue());  
        // Index document without the required field
import org.opensearch.action.index.IndexRequest;
        String marketingRouting = computeRouting("company/marketing");
/*  
                .endObject()
        String pipelineId = "hierarchical-routing-ignore-missing";
        GetResponse doc1 = client().prepareGet(indexName, "1").setRouting(engineeringRouting).get();  
    }  
                        .field("content", "Q1 campaign")
        client().admin().indices().prepareRefresh(indexName).get();
 * SPDX-License-Identifier: Apache-2.0
        // Create index with multiple shards  
            .setSource(new SearchSourceBuilder().query(new PrefixQueryBuilder("file_path", "/company/engineering")))
                        .field("content", "API documentation")
        );  
                    .endObject()  
            new org.opensearch.common.hash.MurmurHash3.Hash128()
        assertThat("Should find engineering documents", searchResponse.getHits().getTotalHits().value(), equalTo(2L));
    public void testHierarchicalRoutingWithMissingField() throws Exception {
        IndexRequest indexRequest = new IndexRequest(indexName).id("missing1")
        // Index document with Windows-style path
import org.opensearch.action.bulk.BulkResponse;  
                .field("path_field", "windows_path")
                jsonBuilder().startObject()  
        client().admin().indices().create(createIndexRequest).get();  
            Map.of("number_of_shards", 2, "number_of_replicas", 0, "index.default_pipeline", pipelineId)
        // Routing should be null since field was missing and ignored
        );
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                .endArray()  
        return computeRouting(anchor, "/");  
        String indexName = "test-custom-separator";
        assertTrue("Document should be indexed even with missing field", doc.isExists());  
                    .field("type", "keyword")  
            .mapping(
            .source(  
import org.opensearch.search.SearchHit;  
        // Calculate expected routing for Windows path
                .field("path_field", "path")  
                    .field("content", "Windows document")
        // Document 3 should have different routing (different anchor: /company/marketing)
        assertTrue("Pipeline should be created successfully", getPipelineResponse.isFound());
                    .startObject("properties")
    @Override  
                .endObject()
        // Refresh to make documents searchable
        // Verify processor is registered by attempting to create a pipeline
        assertFalse("Bulk indexing should succeed", bulkResponse.hasFailures());
        client().index(indexRequest).get();
        GetResponse doc2 = client().prepareGet(indexName, "2").setRouting(engineeringRouting).get();
                jsonBuilder().startObject().field("other_field", "some value").field("content", "Document without path field").endObject()
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
public class HierarchicalRoutingProcessorIT extends OpenSearchIntegTestCase {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
        client().admin().indices().create(createIndexRequest).get();  
                .field("path_separator", "/")  
        // We need to calculate the expected routing values to retrieve the documents
    // Helper method to compute expected routing (mirrors processor logic)
 * this file be licensed under the Apache-2.0 license or a
import java.util.Arrays;
        assertTrue("Document 3 should exist", doc3.isExists());  
        // Test search functionality
        String indexName = "test-hierarchical-routing";
                        .endObject()  
        assertThat("Document 3 should have routing", doc3Routing, notNullValue());  
        assertThat("Document 2 should have routing", doc2Routing, notNullValue());
        String pipelineId = "hierarchical-routing-custom-sep";
        GetResponse doc3 = client().prepareGet(indexName, "3").setRouting(marketingRouting).get();
import org.opensearch.core.common.bytes.BytesReference;
        )
                        .field("file_path", "/company/engineering/backend/api.pdf")
                    jsonBuilder().startObject()  
        BulkRequest bulkRequest = new BulkRequest();  
                .startObject()
                .endObject()
import org.opensearch.action.get.GetResponse;
    }
    }
                )
                    jsonBuilder().startObject()
        DocumentField doc2Routing = doc2.getField("_routing");
 *
import org.opensearch.search.builder.SearchSourceBuilder;
        );
        // Create pipeline with custom separator
    }
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
        return String.valueOf(hash == Long.MIN_VALUE ? 0L : (hash < 0 ? -hash : hash));
                .startObject()
package org.opensearch.ingest.common;
                .startObject("hierarchical_routing")  
                .endObject()
        // This should succeed if processor is properly registered
    }
        // Verify pipeline was created
                .startArray("processors")
        BulkResponse bulkResponse = client().bulk(bulkRequest).get();
        bulkRequest.add(  
        bulkRequest.add(  
                .field("anchor_depth", 2)
                .field("path_field", "nonexistent_field")
    public void testHierarchicalRoutingWithCustomSeparator() throws Exception {  
            new IndexRequest(indexName).id("3")
        // Document without path field should not have routing, so no routing needed for get
                .startArray("processors")
            jsonBuilder().startObject()
        assertTrue("Document 1 should exist", doc1.isExists());
