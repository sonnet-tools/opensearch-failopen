package org.opensearch.index.query;
import org.opensearch.action.IndicesRequest;
        final PipelinedRequest searchRequest = createDummyPipelinedRequest();  
        return searchPipelineService.resolvePipeline(searchRequest, null, indexNameExpressionResolver);
        when(threadPool.generic()).thenReturn(executorService);  
public class QueryCoordinatorContextTests extends OpenSearchTestCase {
        );
        final QueryCoordinatorContext queryCoordinatorContext = new QueryCoordinatorContext(mock(QueryRewriteContext.class), searchRequest);  
        assertEquals(Map.of("key", "value"), queryCoordinatorContext.getContextVariables());
import org.opensearch.common.util.concurrent.ThreadContext;
        final Client client = mock(Client.class);  
import static org.mockito.Mockito.mock;
    }  
import java.util.Map;
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
                }  
import org.opensearch.action.search.SearchRequest;
    }  
    public void testGetContextVariables_whenPipelinedSearchRequest_thenReturnVariables() throws Exception {
            null,  
import java.util.concurrent.ExecutorService;
import static org.mockito.ArgumentMatchers.anyString;
    }
    private PipelinedRequest createDummyPipelinedRequest() throws Exception {
                @Override  
    }
 *
import org.opensearch.plugins.SearchPipelinePlugin;  
    private IndexNameExpressionResolver indexNameExpressionResolver;
        final SearchPipelineService searchPipelineService = new SearchPipelineService(  
 * this file be licensed under the Apache-2.0 license or a
                public Map<String, Processor.Factory<SearchPhaseResultsProcessor>> getSearchPhaseResultsProcessors(Parameters parameters) {
        indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
                }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        assertTrue(queryCoordinatorContext.getContextVariables().isEmpty());  
import org.opensearch.threadpool.ThreadPool;
                @Override
        );
import java.util.Collections;  
                public Map<String, Processor.Factory<SearchRequestProcessor>> getRequestProcessors(Parameters parameters) {
    }  
import org.opensearch.transport.client.Client;  
import org.opensearch.search.pipeline.SearchPhaseResultsProcessor;  
import org.opensearch.search.pipeline.Processor;
import org.opensearch.common.settings.Settings;  
        final QueryCoordinatorContext queryCoordinatorContext = new QueryCoordinatorContext(mock(QueryRewriteContext.class), searchRequest);  
        final ThreadPool threadPool = mock(ThreadPool.class);
                    return Collections.emptyMap();
/*  
        final SearchRequest searchRequest = new SearchRequest();  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
 */  
 * SPDX-License-Identifier: Apache-2.0
}
 * The OpenSearch Contributors require contributions made to  
                public Map<String, Processor.Factory<SearchResponseProcessor>> getResponseProcessors(Parameters parameters) {  
            Collections.singletonList(new SearchPipelinePlugin() {
            clusterService,
import static org.mockito.Mockito.when;  
                @Override
            null,  
        searchRequest.getPipelineProcessingContext().setAttribute("key", "value");
        assertEquals(searchRequest, queryCoordinatorContext.getSearchRequest());
                }
import org.opensearch.search.pipeline.PipelinedRequest;
            this.writableRegistry(),
        final IndicesRequest searchRequest = mock(IndicesRequest.class);
    public void testGetSearchRequest() {  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        final IndicesRequest searchRequest = mock(IndicesRequest.class);
        ClusterService clusterService = mock(ClusterService.class);
import org.opensearch.cluster.service.ClusterService;
                    return Collections.emptyMap();
import org.opensearch.common.settings.ClusterSettings;
import org.junit.Before;
import org.opensearch.search.pipeline.SearchRequestProcessor;
            threadPool,
        final ExecutorService executorService = OpenSearchExecutors.newDirectExecutorService();
    @Before  
        when(clusterService.getClusterSettings()).thenReturn(  
            }),  
    public void setup() {
            client
            null,
                    return Collections.emptyMap();  
import org.opensearch.search.pipeline.SearchResponseProcessor;  
    public void testGetContextVariables_whenNotPipelinedSearchRequest_thenReturnEmpty() {
        final QueryCoordinatorContext queryCoordinatorContext = new QueryCoordinatorContext(mock(QueryRewriteContext.class), searchRequest);
        when(threadPool.executor(anyString())).thenReturn(executorService);
            null,
import org.opensearch.search.pipeline.SearchPipelineService;
