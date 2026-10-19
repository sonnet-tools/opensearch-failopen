            );
            {
                }
                    "path_separator": "\\\\",
                }  
                )
        client().index(
            .actionGet();  
        searchRequest = new SearchRequest(indexName).source(
        String indexName = "test-search-routing";  
        // No routing should be added since no path field in query
            new IndexRequest(indexName).id("3")
        );
            """);  
                    "anchor_depth": 2
        String salesRouting = computeRouting("company/sales");
        long hash = org.opensearch.common.hash.MurmurHash3.hash128(
        // Marketing documents  
              ]
                    .endObject()
                }
                    .endObject()
                new BoolQueryBuilder().must(new TermQueryBuilder("content", "proposal"))
        searchResponse = client().search(searchRequest).get();  
        // Test 4: Query without path filter should search all shards (no routing added)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertTrue("Pipeline creation should succeed", response.isAcknowledged());  
                .put("index.search.default_pipeline", pipelineId)
                .put("index.search.default_pipeline", pipelineId)  
        // Test that the processor is properly registered by creating a pipeline
                {
                .build()  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        );
                  }
                        .field("content", "API documentation")
import org.opensearch.search.SearchHit;  
            Settings.builder()  
 *
                        .field("content", "Sales proposal")
              "request_processors": [  
            """);
                    "path_field": "file_path",  
                  }  
        BytesArray pipelineConfig = new BytesArray("""
            """);
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
import org.opensearch.plugins.Plugin;
    private String computeRouting(String anchor) {  
        searchResponse = client().search(searchRequest).get();
        // Search without path field - should not add routing
        client().admin().indices().create(createIndexRequest).get();  
        client().admin().indices().create(createIndexRequest).get();
        assertThat("Should find document", searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        SearchRequest searchRequest = new SearchRequest(indexName).source(  
              ]
        // Create index with multiple shards
                new BoolQueryBuilder().should(new PrefixQueryBuilder("file_path", "/company/engineering"))  
                    "enable_auto_detection": true  
    }
                {
import org.opensearch.index.query.BoolQueryBuilder;
public class HierarchicalRoutingSearchProcessorIT extends OpenSearchIntegTestCase {  
import org.opensearch.common.settings.Settings;
                    .startObject("file_path")
            """);
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
            0,
        assertFalse("Pipeline should exist", getResponse.pipelines().isEmpty());
    public void testHierarchicalRoutingSearchProcessorRegistration() throws Exception {
    public void testNoRoutingWithoutPathField() throws Exception {
            new SearchSourceBuilder().query(
                )
            new IndexRequest(indexName).id("4")
            new SearchSourceBuilder().query(
        client().index(
            String filePath = (String) hit.getSourceAsMap().get("file_path");
        BytesArray pipelineConfig = new BytesArray("""
import org.opensearch.action.search.SearchRequest;
                .put("number_of_shards", 3)  
        );
        SearchRequest searchRequest = new SearchRequest(indexName).source(
                        .endObject()
        SearchResponse searchResponse = client().search(searchRequest).get();  
    }
 * compatible open source license.
                    .endObject()
                  "hierarchical_routing_search": {
 * The OpenSearch Contributors require contributions made to  
            }  
        assertThat("Should find Windows documents", searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        // Test Windows path search
        // Create search pipeline  
                    "anchor_depth": 2,
 * SPDX-License-Identifier: Apache-2.0
        client().index(
        ).h1;
import org.opensearch.action.index.IndexRequest;
        assertThat("Should find sales documents", searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            )
                        .field("content", "Windows document")  
import org.opensearch.action.search.PutSearchPipelineRequest;  
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
            {
import org.opensearch.index.query.PrefixQueryBuilder;
    // Helper method to compute expected routing (mirrors processor logic)
                .routing(marketingRouting)  
                jsonBuilder().startObject()  
        // Create search pipeline with custom separator
    }
    }
                    "anchor_depth": 1
                        .field("content", "Q1 campaign strategy")
                    .startObject("properties")
        searchResponse = client().search(searchRequest).get();
        // Verify pipeline exists
        return List.of(SearchPipelineCommonModulePlugin.class);
        assertTrue("Found document should be in marketing folder", filePath.startsWith("/company/marketing"));  
                {
            new IndexRequest(indexName).id("1")  
                .source(
        searchRequest = new SearchRequest(indexName).source(
                        .field("content", "UI guidelines")
        // Create search pipeline with hierarchical routing search processor
            anchorBytes.length,
                .routing(engineeringRouting)
                        .field("file_path", "/company/marketing/campaigns/q1.pdf")  
            }
        assertTrue("Pipeline creation should succeed", putResponse.isAcknowledged());  
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
 */  
                .put("number_of_shards", 2)  
        for (SearchHit hit : searchResponse.getHits().getHits()) {
        BytesArray pipelineConfig = new BytesArray("""
import org.opensearch.index.query.WildcardQueryBuilder;
        // Test 1: Prefix query should automatically add routing
                .put("number_of_shards", 2)
        AcknowledgedResponse response = client().admin().cluster().putSearchPipeline(putRequest).actionGet();
                  }
                    .should(new PrefixQueryBuilder("file_path", "/company/marketing"))
        client().index(
                }
                )  
                    "path_field": "path",  
        return computeRouting(anchor, "/");
                    .field("type", "text")  
                    jsonBuilder().startObject()
    }  
                    "path_field": "windows_path",  
        );
        )
            .getSearchPipeline(new org.opensearch.action.search.GetSearchPipelineRequest(pipelineId))
                    "path_field": "file_path",
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.search.builder.SearchSourceBuilder;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
            new SearchSourceBuilder().query(new TermQueryBuilder("content", "test"))  
                        .field("file_path", "/company/engineering/frontend/ui.pdf")  
        String indexName = "test-custom-search-routing";
            new SearchSourceBuilder().query(new PrefixQueryBuilder("file_path", "/company/engineering"))
        // Index test documents with explicit routing to simulate ingest pipeline behavior
        client().admin().cluster().putSearchPipeline(putRequest).actionGet();
        String pipelineId = "hierarchical-search-routing-custom";  
        SearchResponse searchResponse = client().search(searchRequest).get();  
        assertThat("Should find documents from both departments", searchResponse.getHits().getTotalHits().value(), equalTo(3L));  
                        .field("file_path", "/company/sales/proposals/deal.pdf")  
                  "hierarchical_routing_search": {  
    }  
                .source(
              "request_processors": [  
        ).get();
        // Simple routing computation for tests
            0,  
                .source(  
            {  
    public void testHierarchicalRoutingSearchProcessor() throws Exception {
                    .endObject()  
/*  
                )  
                .routing(engineeringRouting)  
            new SearchSourceBuilder().query(new WildcardQueryBuilder("file_path", "/company/marketing/*"))
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);  
                    "path_separator": "/",
package org.opensearch.search.pipeline.common;
            new SearchSourceBuilder().query(new PrefixQueryBuilder("windows_path", "C:\\Users"))  
        }
import org.opensearch.index.query.TermQueryBuilder;  
import java.util.Collection;
                    .startObject("content")
                .source(
        ).get();
                    jsonBuilder().startObject()
        client().admin().indices().prepareRefresh(indexName).get();  
        // Test 2: Wildcard query should automatically add routing  
    @Override
        String marketingRouting = computeRouting("company/marketing");
                  "hierarchical_routing_search": {
        );
        return String.valueOf(hash == Long.MIN_VALUE ? 0L : (hash < 0 ? -hash : hash));
                        .endObject()
            new IndexRequest(indexName).id("2")
        );
            .mapping(
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
              "request_processors": [  
        assertThat("Should find documents across all shards", searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        String pipelineId = "hierarchical-search-routing-no-path";
                        .endObject()
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
            )
        client().index(
        );  
import java.util.Map;  
        // Engineering documents
            new SearchSourceBuilder().query(new TermQueryBuilder("content", "documentation"))  
                .put("number_of_replicas", 0)
        assertThat("Should find engineering documents", searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        client().admin().indices().prepareRefresh(indexName).get();
                    .field("type", "keyword")  
        assertThat("Should find marketing documents", searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
            new org.opensearch.common.hash.MurmurHash3.Hash128()  
        BytesArray pipelineConfig = new BytesArray("""
                .routing(salesRouting)  
                        .field("file_path", "/company/engineering/backend/api.pdf")
            {
        // Test 3: Bool query with path filter should add routing
        // Index document with Windows-style path  
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
        String filePath = (String) searchResponse.getHits().getHits()[0].getSourceAsMap().get("file_path");
                    jsonBuilder().startObject()  
        var getResponse = client().admin()  
                .put("index.search.default_pipeline", pipelineId)
            assertTrue("Found document should be in engineering folder", filePath.startsWith("/company/engineering"));  
                    "anchor_depth": 2,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
    }  
                .source(
                        .endObject()  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/TBD")  
                .put("number_of_replicas", 0)
import java.util.List;
        );
        // This should succeed if processor is properly registered
import org.opensearch.core.common.bytes.BytesArray;
        String engineeringRouting = computeRouting("company/engineering");  
        // Sales documents  
                .build()
}
                        .endObject()
                    .filter(new PrefixQueryBuilder("file_path", "/company/sales"))  
                  }
        ).get();  
                .build()  
    private String computeRouting(String anchor, String separator) {
                )  
                .put("number_of_replicas", 0)
            anchorBytes,
import org.opensearch.test.OpenSearchIntegTestCase;
                        .field("windows_path", "C:\\Users\\admin\\Documents\\file.txt")
                    jsonBuilder().startObject()
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        String pipelineId = "hierarchical-search-routing";  
            }
        // Test 5: Multiple path prefixes should result in multiple routing values  
              "request_processors": [
        client().admin().indices().prepareRefresh(indexName).get();
        assertEquals("Pipeline ID should match", pipelineId, getResponse.pipelines().get(0).getId());
        searchResponse = client().search(searchRequest).get();
                {
        AcknowledgedResponse putResponse = client().admin().cluster().putSearchPipeline(putRequest).actionGet();
                  "hierarchical_routing_search": {
import org.opensearch.action.search.SearchResponse;
              ]  
              ]  
            Settings.builder()
        SearchResponse searchResponse = client().search(searchRequest).get();
        searchRequest = new SearchRequest(indexName).source(  
            }
            .cluster()
        client().admin().indices().create(createIndexRequest).get();  
        String pipelineId = "test-search-processor-registration";  
        searchRequest = new SearchRequest(indexName).source(
        ).get();
        SearchRequest searchRequest = new SearchRequest(indexName).source(
        client().admin().cluster().putSearchPipeline(putRequest).actionGet();
    public void testHierarchicalRoutingSearchProcessorWithCustomSeparator() throws Exception {
        byte[] anchorBytes = anchor.getBytes(java.nio.charset.StandardCharsets.UTF_8);  
        client().index(new IndexRequest(indexName).id("1").source(Map.of("content", "test document"))).get();  
            Settings.builder()
            new IndexRequest(indexName).id("win1")
        ).get();
                    jsonBuilder().startObject()
        String indexName = "test-no-path-routing";  
        // Index document
        );  
                    "enable_auto_detection": true  
