            }
        when(inputResponse.getHits()).thenReturn(SearchHits.empty());  
            }  
        when(outputResponse.getHits()).thenReturn(SearchHits.empty());
 */  
 * compatible open source license.
        super.setUp();
            () -> new TrackingSearchResponseProcessorWrapper(null)
 * The OpenSearch Contributors require contributions made to  
import static org.mockito.Mockito.when;
        });
}
        SearchResponse inputResponse = Mockito.mock(SearchResponse.class);  
                ProcessorExecutionDetail detail = context.getProcessorExecutionDetails().get(0);
import static org.mockito.ArgumentMatchers.any;
    private TrackingSearchResponseProcessorWrapper wrapper;
            @Override
                assertFalse(context.getProcessorExecutionDetails().isEmpty());
        SearchResponse outputResponse = Mockito.mock(SearchResponse.class);
    public void testConstructorThrowsExceptionWhenProcessorIsNull() {
public class TrackingSearchResponseProcessorWrapperTests extends OpenSearchTestCase {  
import org.opensearch.action.search.SearchResponse;
            @Override  
import static org.mockito.Mockito.verify;  
 * this file be licensed under the Apache-2.0 license or a
        context = new PipelineProcessingContext();
                assertEquals(wrapper.getType(), detail.getProcessorName());  
        IllegalArgumentException exception = expectThrows(
import static org.mockito.ArgumentMatchers.eq;
                assertEquals(ProcessorExecutionDetail.ProcessorStatus.SUCCESS, detail.getStatus());  
import org.opensearch.search.SearchHits;
        wrapper = new TrackingSearchResponseProcessorWrapper(mockProcessor);  
    }
import org.mockito.Mockito;
            public void onResponse(SearchResponse result) {
                assertNotNull(detail.getOutputData());
        SearchRequest mockRequest = new SearchRequest();
        wrapper.processResponseAsync(mockRequest, inputResponse, context, new ActionListener<>() {  
    private SearchResponseProcessor mockProcessor;
    public void setUp() throws Exception {  
 *
                fail("Should not trigger failure");
        );
        verify(mockProcessor).processResponseAsync(eq(mockRequest), eq(inputResponse), eq(context), any());  
        mockProcessor = Mockito.mock(SearchResponseProcessor.class);
    public void testProcessResponseAsync() {
/*  
                assertNotNull(detail.getInputData());
import org.opensearch.core.action.ActionListener;  
    }
import org.junit.Before;  
            IllegalArgumentException.class,  
                assertEquals(outputResponse, result);  
    @Before
package org.opensearch.search.pipeline;
 * SPDX-License-Identifier: Apache-2.0
    private PipelineProcessingContext context;  
        assertEquals("Wrapped processor cannot be null.", exception.getMessage());
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.action.search.SearchRequest;
            public void onFailure(Exception e) {
    }
