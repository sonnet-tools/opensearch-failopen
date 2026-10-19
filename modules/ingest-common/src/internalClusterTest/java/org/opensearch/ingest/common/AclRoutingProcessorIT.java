                    .endObject()
                .endArray()
                    .endObject()
import org.opensearch.test.OpenSearchIntegTestCase;
                .endObject()
        client().admin().indices().prepareRefresh(indexName).get();
            Settings.builder().put("number_of_shards", 2).put("number_of_replicas", 0).put("index.default_pipeline", pipelineId).build()
                .source(jsonBuilder().startObject().field("team", "team-alpha").field("content", "Alpha content 2").endObject())
        client().admin().indices().create(createIndexRequest).get();
 */
                .setPipeline(pipelineId)
            .source(jsonBuilder().startObject().field("department", "engineering").field("content", "Engineering document").endObject())
            .setPipeline(pipelineId);
    public void testAclRoutingProcessorRegistration() throws Exception {
                .startObject("acl_routing")
        client().admin().indices().prepareRefresh(indexName).get();
                .startObject()
                jsonBuilder().startObject()
        );
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
        GetResponse doc = client().prepareGet(indexName, "missing1").get();
                .startArray("processors")
    public void testAclRoutingProcessor() throws Exception {
            .source(
                .field("target_field", "_routing")
import java.util.Map;
        var getPipelineResponse = client().admin().cluster().prepareGetPipeline(pipelineId).get();
        // Verify processor is registered by attempting to create a pipeline
    }
}
 * SPDX-License-Identifier: Apache-2.0
            jsonBuilder().startObject()
                .startObject()
                .field("target_field", "_routing")
                .startObject()
                .endObject()
                .endArray()
/*
        String pipelineId = "test-acl-processor-registration";
    private String generateRoutingValue(String aclValue) {
        client().index(indexRequest).get();
                .endObject()
        String indexName = "test-acl-routing";
            .setSource(new SearchSourceBuilder().query(new TermQueryBuilder("team", "team-alpha")))
 * compatible open source license.
            Settings.builder().put("number_of_shards", 2).put("number_of_replicas", 0).put("index.default_pipeline", pipelineId).build()
        assertThat("Should find alpha team documents", searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                    .endObject()
        // Clean up
            String team = (String) hit.getSourceAsMap().get("team");
    private byte[] longToBytes(long value) {
                .startArray("processors")
                .endObject()
import java.util.Base64;
                .endObject()
        System.arraycopy(longToBytes(hash.h1), 0, hashBytes, 0, 8);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
    }
            new IndexRequest(indexName).id("1")
import org.opensearch.common.hash.MurmurHash3;
                .field("acl_field", "team")
        IndexRequest indexRequest = new IndexRequest(indexName).id("missing1")
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
                jsonBuilder().startObject().field("other_field", "some value").field("content", "Document without ACL field").endObject()
        // Test search functionality - documents should be searchable
            .get();
import org.opensearch.core.common.bytes.BytesReference;
        // Create index with multiple shards - don't set default pipeline, use explicit pipeline parameter
                .field("target_field", "custom_routing")
        client().admin().indices().create(createIndexRequest).get();
        client().admin().indices().prepareRefresh(indexName).get();
        GetResponse doc = client().prepareGet(indexName, "custom1").get();
        assertEquals("Custom routing should match expected value", generateRoutingValue("engineering"), source.get("custom_routing"));
        // Verify pipeline was created
        return Arrays.asList(IngestCommonModulePlugin.class);
    public void testAclRoutingWithCustomTargetField() throws Exception {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        byte[] bytes = aclValue.getBytes(StandardCharsets.UTF_8);
                    .startObject("content")
                .field("acl_field", "nonexistent_field")
        BytesReference pipelineConfig = BytesReference.bytes(
                .endObject()
        // This should succeed if processor is properly registered
        ).get();
import java.util.Arrays;
        // Use MurmurHash3 for consistent hashing (same as processor)
                    .startObject("properties")
        }
        for (SearchHit hit : searchResponse.getHits().getHits()) {
 * this file be licensed under the Apache-2.0 license or a
        );
        // Index documents with explicit pipeline parameter
        // Create ingest pipeline with ACL routing processor
        );
                    .endObject()
            new IndexRequest(indexName).id("2")
        byte[] result = new byte[8];
 * The OpenSearch Contributors require contributions made to
                .endObject()
                .startArray("processors")
import static org.hamcrest.Matchers.equalTo;
        ).get();
        SearchResponse searchResponse = client().prepareSearch(indexName)
        );
    }
        client().index(
                .startObject("acl_routing")
        client().index(indexRequest).get();
import org.opensearch.search.builder.SearchSourceBuilder;
        // Index document
        )
import org.opensearch.index.query.TermQueryBuilder;
        client().admin().indices().create(createIndexRequest).get();
        System.arraycopy(longToBytes(hash.h2), 0, hashBytes, 8, 8);
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
    private static final Base64.Encoder BASE64_ENCODER = Base64.getUrlEncoder().withoutPadding();
            Settings.builder().put("number_of_shards", 3).put("number_of_replicas", 0).build()
        assertTrue("Document should exist", doc.isExists());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // Refresh to make documents searchable
    // Helper method to generate routing value (mirrors processor logic)
        assertTrue("Pipeline should be created successfully", getPipelineResponse.isFound());
                .field("ignore_missing", true)
                .startObject("acl_routing")
                    .field("type", "keyword")
                .setPipeline(pipelineId)
        BytesReference pipelineConfig = BytesReference.bytes(
 *
                .endObject()
            .setPipeline(pipelineId);
        String pipelineId = "acl-routing-test";
import org.opensearch.plugins.Plugin;
                .field("acl_field", "team")
public class AclRoutingProcessorIT extends OpenSearchIntegTestCase {
            )
import org.opensearch.action.index.IndexRequest;
        String indexName = "test-custom-target";
        for (int i = 7; i >= 0; i--) {
            result[i] = (byte) (value & 0xFF);
            new IndexRequest(indexName).id("3")
        IndexRequest indexRequest = new IndexRequest(indexName).id("custom1")
                .endObject()
        String pipelineId = "acl-routing-custom-target";
import org.opensearch.common.settings.Settings;
        // Create pipeline with ignore_missing = true
            jsonBuilder().startObject()
        assertNotNull("Custom routing field should be set", source.get("custom_routing"));
                .startObject()
    }
                .endObject()
package org.opensearch.ingest.common;
        client().admin().cluster().prepareDeletePipeline(pipelineId).get();
        );
        // Convert to base64 for routing value
import org.opensearch.search.SearchHit;
        // Check that custom routing field was set
                .endObject()
            );
        assertTrue("Document should be indexed even with missing ACL field", doc.isExists());
            jsonBuilder().startObject()
        byte[] hashBytes = new byte[16];
                .source(jsonBuilder().startObject().field("team", "team-alpha").field("content", "Alpha content 1").endObject())
import java.nio.charset.StandardCharsets;
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
                .field("acl_field", "department")
        client().index(
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
        // Create pipeline with custom target field
        return result;
        return BASE64_ENCODER.encodeToString(hashBytes);
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName).settings(
    public void testAclRoutingWithIgnoreMissing() throws Exception {
        // Document should be indexed without routing since field was missing and ignored
        MurmurHash3.Hash128 hash = MurmurHash3.hash128(bytes, 0, bytes.length, 0, new MurmurHash3.Hash128());
        BytesReference pipelineConfig = BytesReference.bytes(
                .startArray("processors")
        BytesReference pipelineConfig = BytesReference.bytes(
                .endArray()
                .setPipeline(pipelineId)
        // Index document without the ACL field
                    .field("type", "text")
                .source(jsonBuilder().startObject().field("team", "team-beta").field("content", "Beta content").endObject())
        client().admin().cluster().preparePutPipeline(pipelineId, pipelineConfig, MediaTypeRegistry.JSON).get();
            assertEquals("Found document should be from team alpha", "team-alpha", team);
                    .startObject("team")
            value >>= 8;
            jsonBuilder().startObject()
                .startObject("acl_routing")
        Map<String, Object> source = doc.getSource();
        }
import org.opensearch.action.search.SearchResponse;
import java.util.Collection;
        );
                .endObject()
        String pipelineId = "acl-routing-ignore-missing";
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
        client().index(
    }
        ).get();
            .mapping(
                .endArray()
import org.opensearch.action.get.GetResponse;
    @Override
    }
        String indexName = "test-ignore-missing";
