import java.util.List;
    public void testFilterQuery() {
 *
import org.opensearch.action.search.SearchRequest;
                    + "}"
import org.junit.Before;
        SearchRequest req = new SearchRequest(TEST_INDEX).source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    + "}"
                    + "\"filter_query\" : {"
        assertEquals(pipeline.getConfigAsMap(), getPipelineResponse.pipelines().get(0).getConfigAsMap());
    private static final String TEST_INDEX = "myindex";
    @After
                + "}"
        AcknowledgedResponse ackRsp = client().admin().cluster().putSearchPipeline(putSearchPipelineRequest).actionGet();
import org.opensearch.core.common.bytes.BytesArray;
import java.util.Map;
            .getSearchPipeline(new GetSearchPipelineRequest(PIPELINE_NAME))
        AcknowledgedResponse ackRsp = client().admin()
            ),
        // Clean up: Remove default pipeline setting
        IndexRequest doc1 = new IndexRequest(TEST_INDEX).id("doc1").source(Map.of("field", "value"));
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        BytesReference pipelineConfig = new BytesArray(
                + "\"query\": {"
        SearchResponse initialRsp = client().search(req).actionGet();
        // Search without the pipeline. Should see both documents.
        deletePipeline();
        PutSearchPipelineRequest putSearchPipelineRequest = new PutSearchPipelineRequest(
    }
        );
                    + "\"request_processors\": ["
import org.junit.After;
public class SearchPipelineCommonIT extends OpenSearchIntegTestCase {
    }
        IndexRequest doc2 = new IndexRequest(TEST_INDEX).id("doc2").source(Map.of("field", "something else"));
        RefreshResponse refRsp = client().admin().indices().refresh(new RefreshRequest(TEST_INDEX)).actionGet();
    private void createPipeline() {
                + "}"
        // Search with the default pipeline. Should only see document with "field":"value".
import org.opensearch.test.OpenSearchIntegTestCase;
            .actionGet();
            .deleteSearchPipeline(new DeleteSearchPipelineRequest(PIPELINE_NAME))
        ir = client().index(doc2).actionGet();
        assertEquals(1, rsp.getHits().getTotalHits().value());
        // Search without the pipeline. Should see both documents.
                    + "\"field\" : \"value\""
 */
    private void deletePipeline() {
        // Clean up.
import java.util.Collection;
        // Verify pipeline description
import org.opensearch.ingest.PipelineConfiguration;
        assertSame(RestStatus.OK, refRsp.getStatus());
 * this file be licensed under the Apache-2.0 license or a
        SearchResponse rsp = client().search(req).actionGet();
        SearchResponse rspWithTempPipeline = client().search(req).actionGet();
    }
        SearchResponse rsp = client().search(req).actionGet();
    public void testSearchWithTemporaryPipeline() throws Exception {
        // Verify initial pipeline
        AcknowledgedResponse updateSettingsResponse = client().admin().indices().updateSettings(updateSettingsRequest).actionGet();
    private static final String PIPELINE_NAME = "test_pipeline";
        updateSettingsRequest.settings(Settings.builder().put("index.search.default_pipeline", PIPELINE_NAME));
        // Update pipeline
        SearchRequest req = new SearchRequest(TEST_INDEX).source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));
        assertSame(RestStatus.CREATED, ir.status());
import org.opensearch.action.search.SearchResponse;
package org.opensearch.search.pipeline.common;
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
        SearchRequest req = new SearchRequest(TEST_INDEX).source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));
import org.opensearch.core.rest.RestStatus;
        assertTrue(ackRsp.isAcknowledged());
        assertSame(RestStatus.CREATED, ir.status());
        // Search with temporary pipeline
    public void testSearchWithDefaultPipeline() throws Exception {
            .cluster()
                    + "}"
import org.opensearch.common.settings.Settings;
        req = new SearchRequest(TEST_INDEX).source(
        Map<String, Object> pipelineSourceMap = new HashMap<>();
        filterQuery.put("query", Map.of("term", Map.of("field", "value")));
        req.pipeline(PIPELINE_NAME);
        rsp = client().search(req).actionGet();
                    + "]"
        return List.of(SearchPipelineCommonModulePlugin.class);
        pipelineSourceMap.put("request_processors", List.of(requestProcessorConfig));
@OpenSearchIntegTestCase.SuiteScopeTestCase
        createPipeline();
        SearchRequest req = new SearchRequest(TEST_INDEX).source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));
            PIPELINE_NAME,
        // Create initial pipeline
                    + "}"
        // Create a pipeline with a filter_query processor.
        Map<String, Object> filterQuery = new HashMap<>();
/*
                + "}"
                + "\"description\": \"Updated pipeline\","
        PutSearchPipelineRequest updateRequest = new PutSearchPipelineRequest(pipeline.getId(), pipelineConfig, MediaTypeRegistry.JSON);
import org.opensearch.action.search.DeleteSearchPipelineRequest;
    @Before
                    + "{"
    }
 * SPDX-License-Identifier: Apache-2.0
        // Search without the pipeline. Should see both documents.
                + "\"term\" : {"
        deletePipeline();
        updateSettingsRequest = new UpdateSettingsRequest(TEST_INDEX);
        createIndex(TEST_INDEX);
        // Search with the pipeline. Should only see document with "field":"value".
        SearchResponse rsp = client().search(req).actionGet();
        IndexResponse ir = client().index(doc1).actionGet();
    public void testUpdateSearchPipeline() throws Exception {
            "{"
            MediaTypeRegistry.JSON
 * compatible open source license.
        // Clean up.
        assertTrue(ackRsp.isAcknowledged());
import org.opensearch.action.search.PutSearchPipelineRequest;
                + "}"
        assertTrue(updateSettingsResponse.isAcknowledged());
        req.pipeline(PIPELINE_NAME);
}
    }
        // Set pipeline as default for the index
        // Create pipeline
        assertEquals(2, rsp.getHits().getTotalHits().value());
        requestProcessorConfig.put("filter_query", filterQuery);
        Map<String, Object> requestProcessorConfig = new HashMap<>();
        createPipeline();
                + "\"field\" : \"something else\""
                + "{"
        assertEquals(1, initialRsp.getHits().getTotalHits().value());
    @Override
                + "]"
import org.opensearch.plugins.Plugin;
            .cluster()
        AcknowledgedResponse ackRsp = client().admin().cluster().putSearchPipeline(updateRequest).actionGet();
        createPipeline();
        assertEquals(PIPELINE_NAME, getPipelineResponse.pipelines().get(0).getId());
        assertEquals(1, rspWithTempPipeline.getHits().getTotalHits().value());
        assertEquals(1, rsp.getHits().getTotalHits().value());
                    + "\"term\" : {"
        updateSettingsResponse = client().admin().indices().updateSettings(updateSettingsRequest).actionGet();
        assertEquals(2, rsp.getHits().getTotalHits().value());
    }
        assertEquals(2, rsp.getHits().getTotalHits().value());
import org.opensearch.action.index.IndexResponse;
    public void setup() throws Exception {
 * The OpenSearch Contributors require contributions made to
        PipelineConfiguration pipeline = new PipelineConfiguration(PIPELINE_NAME, pipelineConfig, MediaTypeRegistry.JSON);
    }
import org.opensearch.index.query.MatchAllQueryBuilder;
import org.opensearch.action.search.GetSearchPipelineRequest;
        GetSearchPipelineResponse getPipelineResponse = client().admin()
import java.util.HashMap;
        );
import org.opensearch.action.search.GetSearchPipelineResponse;
                + "\"request_processors\": ["
                + "}"
        // Clean up.
            new BytesArray(
import org.opensearch.action.index.IndexRequest;
                + "\"filter_query\" : {"
import org.opensearch.search.builder.SearchSourceBuilder;
                "{"
        deletePipeline();
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        updateSettingsRequest.settings(Settings.builder().putNull("index.search.default_pipeline"));
        assertTrue(ackRsp.isAcknowledged());
            new SearchSourceBuilder().query(new MatchAllQueryBuilder()).searchPipelineSource(pipelineSourceMap)
                    + "\"query\": {"
        rsp = client().search(req).actionGet();
        assertTrue(updateSettingsResponse.isAcknowledged());
            .actionGet();
    public void cleanup() throws Exception {
    }
    }
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(TEST_INDEX);
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
        internalCluster().wipeIndices(TEST_INDEX);
        );
                    + "}"
