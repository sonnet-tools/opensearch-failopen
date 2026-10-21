        }
                    .startObject("team")
        String team1Routing = generateRoutingValue(team1);
        byte[] bytes = aclValue.getBytes(StandardCharsets.UTF_8);
            {
                + "}"
        client().admin().indices().prepareRefresh(indexName).get();
                + "  \"request_processors\": [\n"
                .routing(team1Routing)
                + "      \"acl_routing_search\": {\n"
        // Search with bool query
            """);
                + "      }\n"
                    .field("type", "text")
        // Use MurmurHash3 for consistent hashing (same as processors)
        BytesArray pipelineConfig = new BytesArray(
                QueryBuilders.boolQuery().must(QueryBuilders.termQuery("department", dept)).filter(QueryBuilders.existsQuery("title"))
        String team2Routing = generateRoutingValue(team2);
        searchRequest.pipeline(pipelineId);
            new SearchSourceBuilder().query(
                + "      }\n"
                + "        \"acl_field\": \"team\",\n"
        client().admin().indices().create(createIndexRequest).get();
        MurmurHash3.Hash128 hash = MurmurHash3.hash128(bytes, 0, bytes.length, 0, new MurmurHash3.Hash128());
        SearchRequest searchRequest = new SearchRequest(indexName);
        assertHitCount(searchResponse, 2);
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
        String deptRouting = generateRoutingValue(dept);
import org.opensearch.core.common.bytes.BytesArray;
        String team1 = "team-alpha";
                + "    }\n"
        client().index(indexRequest).get();
        );
        byte[] result = new byte[8];
import org.opensearch.plugins.Plugin;
        System.arraycopy(longToBytes(hash.h1), 0, hashBytes, 0, 8);
        // Index test documents with explicit routing
    }
        for (int i = 7; i >= 0; i--) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        for (int i = 0; i < 2; i++) {
    private String generateRoutingValue(String aclValue) {
        String pipelineId = "acl-disabled-pipeline";
                .source(jsonBuilder().startObject().field("team", team1).field("content", "alpha content 1").endObject())
                    .endObject()
        // Index a document
                    .endObject()
                + "    {\n"
        SearchResponse searchResponse = client().search(searchRequest).get();
        searchRequest.pipeline(pipelineId);
                + "}"
                + "    }\n"
        // Verify all results are from team alpha
                  "acl_routing_search": {
        IndexRequest indexRequest = new IndexRequest(indexName).id("doc-1").source(doc).routing(generateRoutingValue(team));
            new IndexRequest(indexName).id("3")
                .source(jsonBuilder().startObject().field("team", team1).field("content", "alpha content 2").endObject())
    private static final Base64.Encoder BASE64_ENCODER = Base64.getUrlEncoder().withoutPadding();
                jsonBuilder().startObject()
        return Arrays.asList(SearchPipelineCommonModulePlugin.class);
                + "    }\n"
import org.opensearch.search.builder.SearchSourceBuilder;
    }
        // Search without team filter
        SearchResponse searchResponse = client().search(searchRequest).get();
        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("team", "engineering")));
 * this file be licensed under the Apache-2.0 license or a
                + "        \"acl_field\": \"team\",\n"
import java.util.Map;
import org.opensearch.action.search.PutSearchPipelineRequest;
        // Index a document
        assertTrue("Pipeline creation should succeed", putResponse.isAcknowledged());
        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("team", team1)));
            Settings.builder().put("number_of_shards", 2).put("number_of_replicas", 0).build()
                .routing(team1Routing)
        SearchResponse searchResponse = client().search(searchRequest).get();
        AcknowledgedResponse putResponse = client().admin().cluster().putSearchPipeline(putRequest).actionGet();
import java.util.Arrays;
        // Create search pipeline first
            doc.put("title", "Engineer " + i);
            result[i] = (byte) (value & 0xFF);
            "{\n"
    }
        String pipelineId = "acl-no-match-pipeline";
        doc.put("content", "some content");
        BytesArray pipelineConfig = new BytesArray("""
                + "    {\n"
            new IndexRequest(indexName).id("2")
import java.util.Base64;
        String indexName = "test-search-disabled";
        // Convert to base64 for routing value
        );
 *
                }
        AcknowledgedResponse putResponse = client().admin().cluster().putSearchPipeline(putRequest).actionGet();
import org.opensearch.action.index.IndexRequest;
        assertHitCount(searchResponse, 1);
                {
                + "      \"acl_routing_search\": {\n"
        doc.put("content", "engineering content");
                + "    {\n"
        assertAcked(prepareCreate(indexName).setSettings(Settings.builder().put("number_of_shards", 2)));
        AcknowledgedResponse putResponse = client().admin().cluster().putSearchPipeline(putRequest).actionGet();
            )
            "{\n"
        String dept = "engineering";
        IndexRequest indexRequest = new IndexRequest(indexName).id("doc-1").source(doc);
        searchRequest.source(
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
        AcknowledgedResponse putResponse = client().admin().cluster().putSearchPipeline(putRequest).actionGet();
                    .endObject()
        String pipelineId = "acl-bool-search-pipeline";
import org.opensearch.common.settings.Settings;
        client().admin().indices().prepareRefresh(indexName).get();
import org.opensearch.action.search.SearchResponse;
            assertEquals("All documents should be from team alpha", team1, source.get("team"));
                + "        \"acl_field\": \"department\",\n"
            value >>= 8;
        String indexName = "test-search-bool-query";
 * SPDX-License-Identifier: Apache-2.0
        assertHitCount(searchResponse, 2);
        }
        )
        String indexName = "test-acl-search-routing";
import org.opensearch.test.OpenSearchIntegTestCase;
        BytesArray pipelineConfig = new BytesArray(
    public void testSearchProcessorWithBoolQuery() throws Exception {
        // Alpha team documents
                    .startObject("properties")
        Map<String, Object> doc = new HashMap<>();
        SearchRequest searchRequest = new SearchRequest(indexName);
 */
                  }
                + "  \"request_processors\": [\n"
                + "  ]\n"
        assertTrue("Pipeline creation should succeed", putResponse.isAcknowledged());
        client().admin().indices().prepareRefresh(indexName).get();
        searchRequest.pipeline(pipelineId);
        // Search with team filter but extraction disabled
import java.nio.charset.StandardCharsets;
package org.opensearch.search.pipeline.common;
              "request_processors": [
            );
 * compatible open source license.
    }
    public void testSearchProcessorExtractsRouting() throws Exception {
            client().index(indexRequest).get();
    private byte[] longToBytes(long value) {
                .source(jsonBuilder().startObject().field("team", team2).field("content", "beta content").endObject())
              ]
                    .startObject("content")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        }
                    .endObject()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import org.opensearch.index.query.QueryBuilders;
        // Create index with multiple shards
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        SearchRequest searchRequest = new SearchRequest(indexName);
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
        String indexName = "test-search-no-acl";
        );
        String team2 = "team-beta";
        doc.put("team", team);
        ).get();
                .routing(team2Routing)
        BytesArray pipelineConfig = new BytesArray(
                + "}"
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {
        client().admin().indices().prepareRefresh(indexName).get();
    }
        return BASE64_ENCODER.encodeToString(hashBytes);
        byte[] hashBytes = new byte[16];
                + "      }\n"
    @Override
    public void testSearchProcessorDisabled() throws Exception {
            new IndexRequest(indexName).id("1")
        // Beta team document
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            "{\n"
                + "        \"extract_from_query\": true\n"
        assertAcked(prepareCreate(indexName).setSettings(Settings.builder().put("number_of_shards", 2)));
    public void testSearchProcessorWithoutAclInQuery() throws Exception {
            doc.put("department", dept);
        ).get();
        client().index(
        client().index(
        assertTrue("Pipeline creation should succeed", putResponse.isAcknowledged());
        // Index documents
                    "acl_field": "team",
        System.arraycopy(longToBytes(hash.h2), 0, hashBytes, 8, 8);
                + "        \"extract_from_query\": true\n"
import org.opensearch.action.search.SearchRequest;
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
        String pipelineId = "acl-search-pipeline";
        ).get();
import org.opensearch.core.xcontent.MediaTypeRegistry;
                + "        \"extract_from_query\": false\n"
        String team = "engineering";
        Map<String, Object> doc = new HashMap<>();
import java.util.Collection;
        // Test search with pipeline - should find only alpha team docs
            }
        client().index(
import org.opensearch.common.hash.MurmurHash3;
        SearchResponse searchResponse = client().search(searchRequest).get();
        client().index(indexRequest).get();
    }
            Map<String, Object> doc = new HashMap<>();
                    .field("type", "keyword")
                + "  ]\n"
        );
        searchRequest.pipeline(pipelineId);
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
 * The OpenSearch Contributors require contributions made to
            Map<String, Object> source = searchResponse.getHits().getAt(i).getSourceAsMap();
        assertTrue("Pipeline creation should succeed", putResponse.isAcknowledged());
        SearchRequest searchRequest = new SearchRequest(indexName);
/*
        assertAcked(prepareCreate(indexName).setSettings(Settings.builder().put("number_of_shards", 2)));
            .mapping(
                + "  ]\n"
    }
        return result;
public class AclRoutingSearchProcessorIT extends OpenSearchIntegTestCase {
import java.util.HashMap;
                + "      \"acl_routing_search\": {\n"
}
                    "extract_from_query": true
                + "  \"request_processors\": [\n"
        assertHitCount(searchResponse, 1);
            IndexRequest indexRequest = new IndexRequest(indexName).id("eng-doc-" + i).source(doc).routing(deptRouting);
