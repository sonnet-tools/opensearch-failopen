        // Verify processor is registered by attempting to create a pipeline
        System.arraycopy(longToBytes(hash.h2), 0, hashBytes, 8, 8);  
 * this file be licensed under the Apache-2.0 license or a
                .source(jsonBuilder().startObject().field("team", "team-beta").field("content", "Beta content").endObject())  
import org.opensearch.action.get.GetResponse;
                .endObject()
        String pipelineId = "test-acl-processor-registration";  
        )
    }
        // Index document
import org.opensearch.search.SearchHit;
 * The OpenSearch Contributors require contributions made to  
 */  
        assertNotNull("Custom routing field should be set", source.get("custom_routing"));  
            )
import java.util.Collection;  
            Settings.builder().put("number_of_shards", 2).put("number_of_replicas", 0).put("index.default_pipeline", pipelineId).build()  
            new IndexRequest(indexName).id("1")
        client().index(indexRequest).get();
        client().admin().indices().create(createIndexRequest).get();
import org.opensearch.search.builder.SearchSourceBuilder;  
                .field("acl_field", "team")  
            Settings.builder().put("number_of_shards", 2).put("number_of_replicas", 0).put("index.default_pipeline", pipelineId).build()
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
        // Check that custom routing field was set
                .startArray("processors")  
            value >>= 8;  
                .startObject()
        Map<String, Object> source = doc.getSource();
                .endObject()
        System.arraycopy(longToBytes(hash.h1), 0, hashBytes, 0, 8);
                .endObject()  
import org.opensearch.action.index.IndexRequest;  
        // Create pipeline with ignore_missing = true  
        // Create pipeline with custom target field
        GetResponse doc = client().prepareGet(indexName, "custom1").get();
import org.opensearch.index.query.TermQueryBuilder;  
                .endObject()
        );  
                .field("ignore_missing", true)  
                .startObject()
        // This should succeed if processor is properly registered
            String team = (String) hit.getSourceAsMap().get("team");  
        );
    @Override
        assertTrue("Document should exist", doc.isExists());
                    .startObject("team")  
                .endObject()
        BytesReference pipelineConfig = BytesReference.bytes(
        // Verify pipeline was created
        client().index(
        var getPipelineResponse = client().admin().cluster().prepareGetPipeline(pipelineId).get();
    }
        String indexName = "test-ignore-missing";  
import org.opensearch.core.common.bytes.BytesReference;
        for (SearchHit hit : searchResponse.getHits().getHits()) {
    }  
        // Index document without the ACL field
            .setPipeline(pipelineId);
import java.util.Map;
        GetResponse doc = client().prepareGet(indexName, "missing1").get();  
        IndexRequest indexRequest = new IndexRequest(indexName).id("custom1")  
        ).get();
                .startArray("processors")  
        // Test search functionality - documents should be searchable
        assertThat("Should find alpha team documents", searchResponse.getHits().getTotalHits().value(), equalTo(2L));  
                .startObject("acl_routing")
                    .startObject("properties")
        String pipelineId = "acl-routing-custom-target";  
                    .startObject("content")  
        }
    private String generateRoutingValue(String aclValue) {
        MurmurHash3.Hash128 hash = MurmurHash3.hash128(bytes, 0, bytes.length, 0, new MurmurHash3.Hash128());
                .field("acl_field", "nonexistent_field")
        client().index(
        return result;
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
                .endArray()
            .get();
        String indexName = "test-acl-routing";
        );  
        client().admin().cluster().prepareDeletePipeline(pipelineId).get();  
        client().admin().indices().prepareRefresh(indexName).get();
    public void testAclRoutingProcessor() throws Exception {
import static org.hamcrest.Matchers.equalTo;
        // Index documents with explicit pipeline parameter  
                .endObject()
        client().admin().indices().create(createIndexRequest).get();
                .startObject("acl_routing")  
        BytesReference pipelineConfig = BytesReference.bytes(
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.SearchResponse;
                .endArray()
        client().admin().indices().prepareRefresh(indexName).get();  
                .endObject()
                .field("target_field", "_routing")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                .setPipeline(pipelineId)
                .endObject()
                .field("target_field", "_routing")
        // Create ingest pipeline with ACL routing processor
        ).get();
                .setPipeline(pipelineId)
                .startArray("processors")
        assertTrue("Document should be indexed even with missing ACL field", doc.isExists());
            .mapping(  
            assertEquals("Found document should be from team alpha", "team-alpha", team);
        client().index(indexRequest).get();
import org.opensearch.core.xcontent.MediaTypeRegistry;
        String pipelineId = "acl-routing-test";  
        for (int i = 7; i >= 0; i--) {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
                .field("acl_field", "team")  
    private static final Base64.Encoder BASE64_ENCODER = Base64.getUrlEncoder().withoutPadding();  
                    .endObject()  
        byte[] result = new byte[8];  
                .endObject()
                .startObject("acl_routing")
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
                .source(jsonBuilder().startObject().field("team", "team-alpha").field("content", "Alpha content 2").endObject())  
import org.opensearch.plugins.Plugin;
                    .endObject()
            .setSource(new SearchSourceBuilder().query(new TermQueryBuilder("team", "team-alpha")))  
        client().admin().indices().create(createIndexRequest).get();  
        ).get();
        IndexRequest indexRequest = new IndexRequest(indexName).id("missing1")
    public void testAclRoutingWithIgnoreMissing() throws Exception {
            result[i] = (byte) (value & 0xFF);
                .startObject()
        // Convert to base64 for routing value  
        byte[] bytes = aclValue.getBytes(StandardCharsets.UTF_8);  
        // Use MurmurHash3 for consistent hashing (same as processor)
 * compatible open source license.
            jsonBuilder().startObject()
    // Helper method to generate routing value (mirrors processor logic)  
                .endObject()
                    .field("type", "text")
                    .endObject()
                .endArray()  
            );
    public void testAclRoutingWithCustomTargetField() throws Exception {
                    .endObject()
            jsonBuilder().startObject()
        String pipelineId = "acl-routing-ignore-missing";
        // Clean up
        );
                .startObject("acl_routing")
import org.opensearch.test.OpenSearchIntegTestCase;
            new IndexRequest(indexName).id("2")
        // Document should be indexed without routing since field was missing and ignored
import java.util.Arrays;
        // Refresh to make documents searchable
                .setPipeline(pipelineId)
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
            jsonBuilder().startObject()
public class AclRoutingProcessorIT extends OpenSearchIntegTestCase {
        byte[] hashBytes = new byte[16];
                .endArray()  
    }  
        return Arrays.asList(IngestCommonModulePlugin.class);
        );
import org.opensearch.common.hash.MurmurHash3;
        client().admin().indices().prepareRefresh(indexName).get();
            .source(jsonBuilder().startObject().field("department", "engineering").field("content", "Engineering document").endObject())
        return BASE64_ENCODER.encodeToString(hashBytes);
                .source(jsonBuilder().startObject().field("team", "team-alpha").field("content", "Alpha content 1").endObject())  
            .source(  
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
                jsonBuilder().startObject().field("other_field", "some value").field("content", "Document without ACL field").endObject()
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
        String indexName = "test-custom-target";
}
            new IndexRequest(indexName).id("3")
                .startArray("processors")  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)  
        );  
import java.util.Base64;
        // Create index with multiple shards - don't set default pipeline, use explicit pipeline parameter
    public void testAclRoutingProcessorRegistration() throws Exception {
    }
            .setPipeline(pipelineId);  
                .startObject()
            Settings.builder().put("number_of_shards", 3).put("number_of_replicas", 0).build()
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(  
        assertEquals("Custom routing should match expected value", generateRoutingValue("engineering"), source.get("custom_routing"));
                .endObject()
 *
    private byte[] longToBytes(long value) {
        BytesReference pipelineConfig = BytesReference.bytes(
                .endObject()  
    }  
package org.opensearch.ingest.common;
                jsonBuilder().startObject()
                    .field("type", "keyword")
        BytesReference pipelineConfig = BytesReference.bytes(
                .field("acl_field", "department")  
        }
                .field("target_field", "custom_routing")
import java.nio.charset.StandardCharsets;  
import org.opensearch.common.settings.Settings;  
        assertTrue("Pipeline should be created successfully", getPipelineResponse.isFound());  
        client().index(
            jsonBuilder().startObject()  
        SearchResponse searchResponse = client().prepareSearch(indexName)
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
    }
/*  
