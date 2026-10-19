        IndexRequest doc2 = new IndexRequest(TEST_INDEX).id("doc2").source(Map.of("field", "something else"));
            .actionGet();
        assertTrue(updateSettingsResponse.isAcknowledged());
        assertEquals(1, initialRsp.getHits().getTotalHits().value());
        SearchResponse initialRsp = client().search(req).actionGet();  
        );  
        assertEquals(1, rspWithTempPipeline.getHits().getTotalHits().value());  
        AcknowledgedResponse updateSettingsResponse = client().admin().indices().updateSettings(updateSettingsRequest).actionGet();  
        AcknowledgedResponse ackRsp = client().admin().cluster().putSearchPipeline(putSearchPipelineRequest).actionGet();
import org.opensearch.action.search.PutSearchPipelineRequest;  
            PIPELINE_NAME,
                    + "}"  
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
import java.util.HashMap;  
                    + "\"filter_query\" : {"  
    }  
            ),
 * this file be licensed under the Apache-2.0 license or a
                    + "}"
        ir = client().index(doc2).actionGet();  
        assertTrue(ackRsp.isAcknowledged());
    }
    }  
                    + "{"
        updateSettingsRequest.settings(Settings.builder().putNull("index.search.default_pipeline"));  
        createPipeline();
                    + "}"
                + "}"
        // Search with temporary pipeline
        // Search with the pipeline. Should only see document with "field":"value".  
import org.opensearch.action.search.DeleteSearchPipelineRequest;  
            .deleteSearchPipeline(new DeleteSearchPipelineRequest(PIPELINE_NAME))
import org.opensearch.search.builder.SearchSourceBuilder;  
    public void cleanup() throws Exception {
    @After
        requestProcessorConfig.put("filter_query", filterQuery);
        internalCluster().wipeIndices(TEST_INDEX);  
    private void createPipeline() {
        assertSame(RestStatus.CREATED, ir.status());
            new BytesArray(
import org.opensearch.common.settings.Settings;
        GetSearchPipelineResponse getPipelineResponse = client().admin()
                + "\"field\" : \"something else\""
import org.opensearch.ingest.PipelineConfiguration;
        // Create pipeline
        rsp = client().search(req).actionGet();
        pipelineSourceMap.put("request_processors", List.of(requestProcessorConfig));
        SearchResponse rsp = client().search(req).actionGet();  
        );  
        deletePipeline();
        PipelineConfiguration pipeline = new PipelineConfiguration(PIPELINE_NAME, pipelineConfig, MediaTypeRegistry.JSON);
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;  
import org.opensearch.action.search.SearchResponse;
        // Clean up.
                    + "\"request_processors\": ["
import java.util.List;
@OpenSearchIntegTestCase.SuiteScopeTestCase
/*  
import org.opensearch.action.index.IndexRequest;
    private void deletePipeline() {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                + "\"filter_query\" : {"
        BytesReference pipelineConfig = new BytesArray(  
        // Clean up: Remove default pipeline setting
        // Verify pipeline description  
import org.opensearch.core.rest.RestStatus;
        assertTrue(ackRsp.isAcknowledged());
        SearchRequest req = new SearchRequest(TEST_INDEX).source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));
 * SPDX-License-Identifier: Apache-2.0
}  
import org.opensearch.index.query.MatchAllQueryBuilder;  
                    + "\"query\": {"
import java.util.Map;
    }  
    }
        Map<String, Object> filterQuery = new HashMap<>();
    public void testUpdateSearchPipeline() throws Exception {
        filterQuery.put("query", Map.of("term", Map.of("field", "value")));  
import org.opensearch.action.search.GetSearchPipelineRequest;
        PutSearchPipelineRequest updateRequest = new PutSearchPipelineRequest(pipeline.getId(), pipelineConfig, MediaTypeRegistry.JSON);
        rsp = client().search(req).actionGet();
import org.opensearch.test.OpenSearchIntegTestCase;
                "{"  
    @Before  
import org.junit.After;
                + "]"
    public void testSearchWithTemporaryPipeline() throws Exception {  
import org.opensearch.action.search.GetSearchPipelineResponse;
    }
                    + "}"
        deletePipeline();  
        req.pipeline(PIPELINE_NAME);
        // Search without the pipeline. Should see both documents.
        assertEquals(2, rsp.getHits().getTotalHits().value());
                + "\"description\": \"Updated pipeline\","
        req.pipeline(PIPELINE_NAME);
        SearchRequest req = new SearchRequest(TEST_INDEX).source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));
    @Override
            "{"
        IndexResponse ir = client().index(doc1).actionGet();
        SearchResponse rsp = client().search(req).actionGet();  
                + "{"
        SearchRequest req = new SearchRequest(TEST_INDEX).source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
            .cluster()
import org.opensearch.core.common.bytes.BytesReference;  
    }
                    + "}"  
 */  
    }
                    + "]"
        Map<String, Object> pipelineSourceMap = new HashMap<>();
                + "}"  
        RefreshResponse refRsp = client().admin().indices().refresh(new RefreshRequest(TEST_INDEX)).actionGet();  
 * compatible open source license.
        updateSettingsResponse = client().admin().indices().updateSettings(updateSettingsRequest).actionGet();
        // Search with the default pipeline. Should only see document with "field":"value".  
                + "\"term\" : {"
                    + "\"term\" : {"
 *
        assertSame(RestStatus.OK, refRsp.getStatus());
            .cluster()
        assertTrue(updateSettingsResponse.isAcknowledged());
    public void testSearchWithDefaultPipeline() throws Exception {  
                + "}"
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(TEST_INDEX);
        AcknowledgedResponse ackRsp = client().admin().cluster().putSearchPipeline(updateRequest).actionGet();  
        // Set pipeline as default for the index  
        deletePipeline();
        // Create a pipeline with a filter_query processor.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.bytes.BytesArray;
        // Clean up.
        );  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                + "}"
    private static final String PIPELINE_NAME = "test_pipeline";
        assertSame(RestStatus.CREATED, ir.status());
        SearchResponse rsp = client().search(req).actionGet();
import org.opensearch.action.search.SearchRequest;
        assertEquals(1, rsp.getHits().getTotalHits().value());
import org.opensearch.plugins.Plugin;
                + "\"request_processors\": ["  
        createIndex(TEST_INDEX);
        assertTrue(ackRsp.isAcknowledged());
        // Verify initial pipeline  
package org.opensearch.search.pipeline.common;
        // Update pipeline
            new SearchSourceBuilder().query(new MatchAllQueryBuilder()).searchPipelineSource(pipelineSourceMap)
            MediaTypeRegistry.JSON
        AcknowledgedResponse ackRsp = client().admin()  
        IndexRequest doc1 = new IndexRequest(TEST_INDEX).id("doc1").source(Map.of("field", "value"));
    public void setup() throws Exception {
        // Search without the pipeline. Should see both documents.
        PutSearchPipelineRequest putSearchPipelineRequest = new PutSearchPipelineRequest(  
import org.junit.Before;  
        assertEquals(PIPELINE_NAME, getPipelineResponse.pipelines().get(0).getId());
import org.opensearch.action.index.IndexResponse;
import java.util.Collection;
        // Create initial pipeline  
        // Search without the pipeline. Should see both documents.
                    + "\"field\" : \"value\""  
        createPipeline();
            .getSearchPipeline(new GetSearchPipelineRequest(PIPELINE_NAME))  
        updateSettingsRequest = new UpdateSettingsRequest(TEST_INDEX);
        return List.of(SearchPipelineCommonModulePlugin.class);  
    private static final String TEST_INDEX = "myindex";
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
        assertEquals(1, rsp.getHits().getTotalHits().value());  
        createPipeline();
                + "\"query\": {"  
            .actionGet();  
        SearchRequest req = new SearchRequest(TEST_INDEX).source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));
    public void testFilterQuery() {  
        req = new SearchRequest(TEST_INDEX).source(
        assertEquals(2, rsp.getHits().getTotalHits().value());
        assertEquals(2, rsp.getHits().getTotalHits().value());
    }
public class SearchPipelineCommonIT extends OpenSearchIntegTestCase {
        SearchResponse rspWithTempPipeline = client().search(req).actionGet();
        // Clean up.
        updateSettingsRequest.settings(Settings.builder().put("index.search.default_pipeline", PIPELINE_NAME));
                + "}"  
        assertEquals(pipeline.getConfigAsMap(), getPipelineResponse.pipelines().get(0).getConfigAsMap());  
        Map<String, Object> requestProcessorConfig = new HashMap<>();  
