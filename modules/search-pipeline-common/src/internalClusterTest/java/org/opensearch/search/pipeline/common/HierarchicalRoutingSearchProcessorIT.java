        client().index(
        assertTrue("Found document should be in marketing folder", filePath.startsWith("/company/marketing"));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
/*
                    .should(new PrefixQueryBuilder("file_path", "/company/marketing"))
            }
                        .endObject()
                )
        var getResponse = client().admin()
                    "anchor_depth": 2
    private String computeRouting(String anchor) {
                )
        return String.valueOf(hash == Long.MIN_VALUE ? 0L : (hash < 0 ? -hash : hash));
            new org.opensearch.common.hash.MurmurHash3.Hash128()
        BytesArray pipelineConfig = new BytesArray("""
            )
        SearchResponse searchResponse = client().search(searchRequest).get();
        );
import org.opensearch.index.query.PrefixQueryBuilder;
                        .field("file_path", "/company/engineering/backend/api.pdf")
    }
        // Sales documents
                        .endObject()
        // Index document with Windows-style path
                    .startObject("properties")
                    "enable_auto_detection": true
        client().admin().indices().prepareRefresh(indexName).get();
        SearchRequest searchRequest = new SearchRequest(indexName).source(
                    jsonBuilder().startObject()
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
                  "hierarchical_routing_search": {
            }
                  }
                }
        searchRequest = new SearchRequest(indexName).source(
    }
        searchRequest = new SearchRequest(indexName).source(
        client().index(
}
                    .endObject()
        // Test Windows path search
            0,
            new SearchSourceBuilder().query(new TermQueryBuilder("content", "test"))
        ).h1;
                .put("number_of_shards", 2)
            .mapping(
        );
        assertThat("Should find document", searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                }
        // Create index with multiple shards
 */
            .actionGet();
        String indexName = "test-custom-search-routing";
            {
    public void testNoRoutingWithoutPathField() throws Exception {
                  }
        // Create search pipeline
        AcknowledgedResponse putResponse = client().admin().cluster().putSearchPipeline(putRequest).actionGet();
            """);
                .build()
        // Test 5: Multiple path prefixes should result in multiple routing values
                    .endObject()
                .source(
    }
        // Create search pipeline with hierarchical routing search processor
import org.opensearch.index.query.BoolQueryBuilder;
        // Test 2: Wildcard query should automatically add routing
        assertThat("Should find documents from both departments", searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    jsonBuilder().startObject()
        String pipelineId = "hierarchical-search-routing";
                        .endObject()
                .routing(salesRouting)
import org.opensearch.search.SearchHit;
    public void testHierarchicalRoutingSearchProcessorWithCustomSeparator() throws Exception {
                  }
                }
                .source(
                {
                    .endObject()
                {
              "request_processors": [
        // Test 1: Prefix query should automatically add routing
              ]
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.hamcrest.Matchers.equalTo;
              ]
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
    private String computeRouting(String anchor, String separator) {
        ).get();
            new IndexRequest(indexName).id("4")
                {
        client().index(new IndexRequest(indexName).id("1").source(Map.of("content", "test document"))).get();
        assertThat("Should find marketing documents", searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            new IndexRequest(indexName).id("win1")
import org.opensearch.action.index.IndexRequest;
        );
                    "path_separator": "\\\\",
                        .field("file_path", "/company/sales/proposals/deal.pdf")
                {
                .put("number_of_replicas", 0)
import org.opensearch.common.settings.Settings;
                .put("number_of_shards", 3)
            new SearchSourceBuilder().query(new TermQueryBuilder("content", "documentation"))
            0,
            new IndexRequest(indexName).id("3")
            }
        // No routing should be added since no path field in query
import org.opensearch.core.xcontent.MediaTypeRegistry;
                        .field("file_path", "/company/engineering/frontend/ui.pdf")
        String marketingRouting = computeRouting("company/marketing");
public class HierarchicalRoutingSearchProcessorIT extends OpenSearchIntegTestCase {
        // Test 4: Query without path filter should search all shards (no routing added)
              "request_processors": [
                        .field("content", "UI guidelines")
import org.opensearch.search.builder.SearchSourceBuilder;
                new BoolQueryBuilder().must(new TermQueryBuilder("content", "proposal"))
        ).get();
        searchRequest = new SearchRequest(indexName).source(
                .routing(engineeringRouting)
import org.opensearch.index.query.TermQueryBuilder;
            );
        BytesArray pipelineConfig = new BytesArray("""
            new SearchSourceBuilder().query(
        // Create search pipeline with custom separator
            Settings.builder()
        searchResponse = client().search(searchRequest).get();
                    jsonBuilder().startObject()
        client().index(
                    "anchor_depth": 2,
        );
            anchorBytes.length,
                    .filter(new PrefixQueryBuilder("file_path", "/company/sales"))
        ).get();
        // Test that the processor is properly registered by creating a pipeline
        return computeRouting(anchor, "/");
        long hash = org.opensearch.common.hash.MurmurHash3.hash128(
                    .startObject("content")
                .build()
                .source(
                  "hierarchical_routing_search": {
                    "path_field": "path",
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
    @Override
                    .startObject("file_path")
        // Simple routing computation for tests
            anchorBytes,
                .put("number_of_replicas", 0)
        searchResponse = client().search(searchRequest).get();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
                .put("number_of_replicas", 0)
            new IndexRequest(indexName).id("1")
              "request_processors": [
        client().admin().indices().prepareRefresh(indexName).get();
import org.opensearch.index.query.WildcardQueryBuilder;
                }
        searchResponse = client().search(searchRequest).get();
            String filePath = (String) hit.getSourceAsMap().get("file_path");
import org.opensearch.action.search.PutSearchPipelineRequest;
            }
            new SearchSourceBuilder().query(new PrefixQueryBuilder("file_path", "/company/engineering"))
            new SearchSourceBuilder().query(
        )
        String indexName = "test-no-path-routing";
                    "anchor_depth": 2,
                        .field("file_path", "/company/marketing/campaigns/q1.pdf")
    public void testHierarchicalRoutingSearchProcessorRegistration() throws Exception {
                new BoolQueryBuilder().should(new PrefixQueryBuilder("file_path", "/company/engineering"))
            .cluster()
        assertTrue("Pipeline creation should succeed", putResponse.isAcknowledged());
import org.opensearch.action.search.SearchResponse;
        assertEquals("Pipeline ID should match", pipelineId, getResponse.pipelines().get(0).getId());
import org.opensearch.plugins.Plugin;
 * this file be licensed under the Apache-2.0 license or a
    public void testHierarchicalRoutingSearchProcessor() throws Exception {
                        .field("content", "API documentation")
        searchResponse = client().search(searchRequest).get();
 *
            new SearchSourceBuilder().query(new PrefixQueryBuilder("windows_path", "C:\\Users"))
        ).get();
import org.opensearch.action.search.SearchRequest;
import org.opensearch.test.OpenSearchIntegTestCase;
        );
        SearchRequest searchRequest = new SearchRequest(indexName).source(
        client().admin().cluster().putSearchPipeline(putRequest).actionGet();
                )
        client().index(
                .source(
        assertTrue("Pipeline creation should succeed", response.isAcknowledged());
import java.util.Map;
                  }
import java.util.List;
        assertThat("Should find documents across all shards", searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                  "hierarchical_routing_search": {
        SearchResponse searchResponse = client().search(searchRequest).get();
        // Marketing documents
        searchRequest = new SearchRequest(indexName).source(
        // Index document
                .routing(engineeringRouting)
        // This should succeed if processor is properly registered
                        .field("content", "Sales proposal")
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
        String engineeringRouting = computeRouting("company/engineering");
                    "enable_auto_detection": true
        String salesRouting = computeRouting("company/sales");
        // Test 3: Bool query with path filter should add routing
            """);
                        .field("windows_path", "C:\\Users\\admin\\Documents\\file.txt")
            new SearchSourceBuilder().query(new WildcardQueryBuilder("file_path", "/company/marketing/*"))
        String pipelineId = "test-search-processor-registration";
                .build()
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
 * SPDX-License-Identifier: Apache-2.0
                    "anchor_depth": 1
        client().admin().indices().create(createIndexRequest).get();
              ]
                    .field("type", "text")
        client().admin().indices().prepareRefresh(indexName).get();
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
        assertThat("Should find Windows documents", searchResponse.getHits().getTotalHits().value(), equalTo(1L));
    // Helper method to compute expected routing (mirrors processor logic)
                    "path_field": "file_path",
        // Engineering documents
            """);
        client().admin().indices().create(createIndexRequest).get();
        assertThat("Should find sales documents", searchResponse.getHits().getTotalHits().value(), equalTo(1L));
    }
                    "path_field": "file_path",
        AcknowledgedResponse response = client().admin().cluster().putSearchPipeline(putRequest).actionGet();
            )
        SearchRequest searchRequest = new SearchRequest(indexName).source(
                    jsonBuilder().startObject()
                .put("number_of_shards", 2)
        );
        String indexName = "test-search-routing";
        assertFalse("Pipeline should exist", getResponse.pipelines().isEmpty());
import java.util.Collection;
        );
                )
        client().admin().indices().create(createIndexRequest).get();
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
        BytesArray pipelineConfig = new BytesArray("""
                    "path_separator": "/",
        return List.of(SearchPipelineCommonModulePlugin.class);
            assertTrue("Found document should be in engineering folder", filePath.startsWith("/company/engineering"));
package org.opensearch.search.pipeline.common;
    }
        for (SearchHit hit : searchResponse.getHits().getHits()) {
        );
        // Search without path field - should not add routing
        String pipelineId = "hierarchical-search-routing-no-path";
                        .field("content", "Windows document")
        }
                        .field("content", "Q1 campaign strategy")
                jsonBuilder().startObject()
            {
                    .endObject()
            Settings.builder()
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
        ).get();
 * The OpenSearch Contributors require contributions made to
        String filePath = (String) searchResponse.getHits().getHits()[0].getSourceAsMap().get("file_path");
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            """);
        BytesArray pipelineConfig = new BytesArray("""
                .routing(marketingRouting)
        client().index(
            .getSearchPipeline(new org.opensearch.action.search.GetSearchPipelineRequest(pipelineId))
                .put("index.search.default_pipeline", pipelineId)
                .put("index.search.default_pipeline", pipelineId)
            {
            new IndexRequest(indexName).id("2")
        client().admin().cluster().putSearchPipeline(putRequest).actionGet();
 * compatible open source license.
                        .endObject()
    }
                )
                    "path_field": "windows_path",
                .put("index.search.default_pipeline", pipelineId)
                        .endObject()
            Settings.builder()
        assertThat("Should find engineering documents", searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                .source(
            {
import org.opensearch.core.common.bytes.BytesArray;
                    jsonBuilder().startObject()
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/TBD")
              "request_processors": [
        // Index test documents with explicit routing to simulate ingest pipeline behavior
        SearchResponse searchResponse = client().search(searchRequest).get();
              ]
    }
        byte[] anchorBytes = anchor.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        // Verify pipeline exists
                  "hierarchical_routing_search": {
        String pipelineId = "hierarchical-search-routing-custom";
                    .field("type", "keyword")
        );
