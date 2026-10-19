import org.opensearch.index.query.QueryBuilders;  
            assertEquals(wrapper.getType(), detail.getProcessorName());
        ActionListener<SearchRequest> listener = ActionListener.wrap(response -> {
import static org.mockito.ArgumentMatchers.any;
        }, e -> fail("Unexpected exception: " + e.getMessage()));  
    private PipelineProcessingContext context;
        doAnswer(invocation -> {
            assertEquals(outputRequest, response);
import org.opensearch.core.action.ActionListener;
        SearchRequest outputRequest = new SearchRequest();
import static org.mockito.ArgumentMatchers.eq;
    private SearchRequestProcessor mockProcessor;  
import org.mockito.Mockito;
        }).when(mockProcessor).processRequestAsync(any(SearchRequest.class), eq(context), any());
}
        SearchRequest inputRequest = new SearchRequest();
        mockProcessor = Mockito.mock(SearchRequestProcessor.class);
            ProcessorExecutionDetail detail = context.getProcessorExecutionDetails().get(0);  
            listener.onResponse(outputRequest);  
 */  
    }  
import static org.mockito.Mockito.doAnswer;  
        super.setUp();  
            ActionListener<SearchRequest> listener = invocation.getArgument(2);
        outputRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("field", "value")));
import org.opensearch.test.OpenSearchTestCase;
/*  
import org.junit.Before;  
            assertEquals(ProcessorExecutionDetail.ProcessorStatus.SUCCESS, detail.getStatus());
 * this file be licensed under the Apache-2.0 license or a
        context = new PipelineProcessingContext();  
        wrapper.processRequestAsync(inputRequest, context, listener);
    public void testProcessRequestAsyncSuccess() {  
            return null;
    private TrackingSearchRequestProcessorWrapper wrapper;
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    }
        wrapper = new TrackingSearchRequestProcessorWrapper(mockProcessor);
import org.opensearch.action.search.SearchRequest;
    @Before
 * compatible open source license.
package org.opensearch.search.pipeline;
 *
    public void setUp() throws Exception {
        inputRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
import org.opensearch.search.builder.SearchSourceBuilder;
public class TrackingSearchRequestProcessorWrapperTests extends OpenSearchTestCase {
