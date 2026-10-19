        searchRequest.pipeline(pipelineId);  
        SearchRequest searchRequest = new SearchRequest(indexName);
}  
            );
        // Index a document  
        searchRequest.source(  
            Map<String, Object> source = searchResponse.getHits().getAt(i).getSourceAsMap();
import org.opensearch.plugins.Plugin;  
        // Search with bool query
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        String team1 = "team-alpha";  
        assertTrue("Pipeline creation should succeed", putResponse.isAcknowledged());
                + "  \"request_processors\": [\n"
                + "      }\n"  
    }  
        SearchResponse searchResponse = client().search(searchRequest).get();
        SearchRequest searchRequest = new SearchRequest(indexName);
import java.util.Collection;
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
                + "      }\n"
    @Override
import org.opensearch.core.common.bytes.BytesArray;  
    }
import org.opensearch.action.index.IndexRequest;
                + "        \"extract_from_query\": true\n"
                .routing(team1Routing)
        assertAcked(prepareCreate(indexName).setSettings(Settings.builder().put("number_of_shards", 2)));  
                + "        \"extract_from_query\": false\n"  
                    "acl_field": "team",  
            .mapping(
public class AclRoutingSearchProcessorIT extends OpenSearchIntegTestCase {
                + "  ]\n"
                + "    {\n"  
                QueryBuilders.boolQuery().must(QueryBuilders.termQuery("department", dept)).filter(QueryBuilders.existsQuery("title"))
              "request_processors": [  
                + "}"
        BytesArray pipelineConfig = new BytesArray("""
        ).get();
                + "    {\n"  
    public void testSearchProcessorWithoutAclInQuery() throws Exception {
        return BASE64_ENCODER.encodeToString(hashBytes);
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
        String pipelineId = "acl-disabled-pipeline";
                + "      \"acl_routing_search\": {\n"  
        System.arraycopy(longToBytes(hash.h1), 0, hashBytes, 0, 8);
        doc.put("content", "engineering content");
import org.opensearch.core.xcontent.MediaTypeRegistry;
                + "  ]\n"  
import java.nio.charset.StandardCharsets;
        client().index(  
        assertTrue("Pipeline creation should succeed", putResponse.isAcknowledged());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        System.arraycopy(longToBytes(hash.h2), 0, hashBytes, 8, 8);
        String dept = "engineering";
        byte[] hashBytes = new byte[16];  
 * compatible open source license.
        SearchResponse searchResponse = client().search(searchRequest).get();
        client().index(indexRequest).get();  
        String team1Routing = generateRoutingValue(team1);
        BytesArray pipelineConfig = new BytesArray(  
import java.util.Base64;  
    }
                }  
        MurmurHash3.Hash128 hash = MurmurHash3.hash128(bytes, 0, bytes.length, 0, new MurmurHash3.Hash128());  
        String pipelineId = "acl-bool-search-pipeline";
        client().admin().indices().prepareRefresh(indexName).get();
                    .endObject()
                + "}"  
        assertHitCount(searchResponse, 1);  
    }
        assertTrue("Pipeline creation should succeed", putResponse.isAcknowledged());
    public void testSearchProcessorWithBoolQuery() throws Exception {  
                + "  \"request_processors\": [\n"
    }
            new IndexRequest(indexName).id("1")
                .source(jsonBuilder().startObject().field("team", team2).field("content", "beta content").endObject())
        AcknowledgedResponse putResponse = client().admin().cluster().putSearchPipeline(putRequest).actionGet();
import java.util.Arrays;
                    .startObject("properties")
        byte[] bytes = aclValue.getBytes(StandardCharsets.UTF_8);
        // Alpha team documents
        searchRequest.pipeline(pipelineId);
import java.util.HashMap;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
                    .startObject("team")
            result[i] = (byte) (value & 0xFF);
        SearchResponse searchResponse = client().search(searchRequest).get();
        Map<String, Object> doc = new HashMap<>();  
        String indexName = "test-search-disabled";
package org.opensearch.search.pipeline.common;
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);  
        );
        assertAcked(prepareCreate(indexName).setSettings(Settings.builder().put("number_of_shards", 2)));  
        assertHitCount(searchResponse, 1);  
        searchRequest.pipeline(pipelineId);  
        doc.put("team", team);
                + "  ]\n"  
            Map<String, Object> doc = new HashMap<>();
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        searchRequest.pipeline(pipelineId);  
        String team = "engineering";
        byte[] result = new byte[8];
        // Index a document
            new IndexRequest(indexName).id("2")
        assertTrue("Pipeline creation should succeed", putResponse.isAcknowledged());
        // Search without team filter  
        String team2Routing = generateRoutingValue(team2);  
        // Index test documents with explicit routing
 */  
        assertHitCount(searchResponse, 2);  
        IndexRequest indexRequest = new IndexRequest(indexName).id("doc-1").source(doc);
        SearchRequest searchRequest = new SearchRequest(indexName);
                jsonBuilder().startObject()  
 *
        String indexName = "test-search-no-acl";  
        BytesArray pipelineConfig = new BytesArray(  
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
        client().admin().indices().prepareRefresh(indexName).get();
import org.opensearch.action.search.PutSearchPipelineRequest;  
        String pipelineId = "acl-no-match-pipeline";
        // Verify all results are from team alpha
        }  
            new IndexRequest(indexName).id("3")
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.search.builder.SearchSourceBuilder;
            assertEquals("All documents should be from team alpha", team1, source.get("team"));
    public void testSearchProcessorExtractsRouting() throws Exception {
                + "    }\n"
 * SPDX-License-Identifier: Apache-2.0
                .routing(team1Routing)
            )  
        for (int i = 7; i >= 0; i--) {  
        ).get();
            new SearchSourceBuilder().query(
        return result;
import java.util.Map;  
                    .startObject("content")
            doc.put("department", dept);  
        }  
                .source(jsonBuilder().startObject().field("team", team1).field("content", "alpha content 1").endObject())  
        client().index(indexRequest).get();  
                + "        \"acl_field\": \"team\",\n"
        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
                  }
        AcknowledgedResponse putResponse = client().admin().cluster().putSearchPipeline(putRequest).actionGet();
        String team2 = "team-beta";
        for (int i = 0; i < 2; i++) {
        // Beta team document  
            {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        // Convert to base64 for routing value
        ).get();
        Map<String, Object> doc = new HashMap<>();
import org.opensearch.test.OpenSearchIntegTestCase;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)  
                + "        \"acl_field\": \"team\",\n"
                .source(jsonBuilder().startObject().field("team", team1).field("content", "alpha content 2").endObject())  
import org.opensearch.common.hash.MurmurHash3;
        return Arrays.asList(SearchPipelineCommonModulePlugin.class);
                + "    {\n"
    private String generateRoutingValue(String aclValue) {  
import org.opensearch.action.search.SearchRequest;
            IndexRequest indexRequest = new IndexRequest(indexName).id("eng-doc-" + i).source(doc).routing(deptRouting);  
        String pipelineId = "acl-search-pipeline";  
            Settings.builder().put("number_of_shards", 2).put("number_of_replicas", 0).build()  
                    .endObject()
                + "    }\n"
        PutSearchPipelineRequest putRequest = new PutSearchPipelineRequest(pipelineId, pipelineConfig, MediaTypeRegistry.JSON);
            "{\n"
        // Create index with multiple shards  
                    "extract_from_query": true
        // Test search with pipeline - should find only alpha team docs  
            """);  
                    .field("type", "text")  
            "{\n"
        assertAcked(prepareCreate(indexName).setSettings(Settings.builder().put("number_of_shards", 2)));
        client().admin().indices().prepareRefresh(indexName).get();
        // Index documents
                + "        \"extract_from_query\": true\n"  
import org.opensearch.action.search.SearchResponse;
                    .endObject()  
        doc.put("content", "some content");
        // Create search pipeline first
                {
        client().index(
                  "acl_routing_search": {
    private static final Base64.Encoder BASE64_ENCODER = Base64.getUrlEncoder().withoutPadding();  
        // Use MurmurHash3 for consistent hashing (same as processors)
                + "  \"request_processors\": [\n"
        SearchRequest searchRequest = new SearchRequest(indexName);
                + "      }\n"
            value >>= 8;
        // Search with team filter but extraction disabled  
                + "      \"acl_routing_search\": {\n"
        String indexName = "test-acl-search-routing";
        assertHitCount(searchResponse, 2);
            }
/*  
        SearchResponse searchResponse = client().search(searchRequest).get();
        AcknowledgedResponse putResponse = client().admin().cluster().putSearchPipeline(putRequest).actionGet();  
import org.opensearch.common.settings.Settings;
        );
    private byte[] longToBytes(long value) {
        client().admin().indices().prepareRefresh(indexName).get();
    }
            doc.put("title", "Engineer " + i);
        );
        String indexName = "test-search-bool-query";
            client().index(indexRequest).get();
                + "        \"acl_field\": \"department\",\n"
                    .field("type", "keyword")  
        client().index(  
        IndexRequest indexRequest = new IndexRequest(indexName).id("doc-1").source(doc).routing(generateRoutingValue(team));
              ]
        AcknowledgedResponse putResponse = client().admin().cluster().putSearchPipeline(putRequest).actionGet();  
                .routing(team2Routing)  
    }
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {  
                + "}"
                + "      \"acl_routing_search\": {\n"
            "{\n"  
        client().admin().indices().create(createIndexRequest).get();  
        String deptRouting = generateRoutingValue(dept);  
        )
        }  
    public void testSearchProcessorDisabled() throws Exception {  
        );
                + "    }\n"
                    .endObject()
        BytesArray pipelineConfig = new BytesArray(
        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("team", team1)));
        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("team", "engineering")));
