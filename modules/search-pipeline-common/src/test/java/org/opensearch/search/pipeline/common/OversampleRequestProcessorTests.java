import org.opensearch.search.pipeline.PipelineProcessingContext;  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(10, context.getAttribute("foo.original_size"));
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(10);  
    public void testEmptySource() {
        PipelineProcessingContext context = new PipelineProcessingContext();
    public void testBasicBehavior() {
    }  
        SearchRequest transformedRequest = processor.processRequest(request, context);  
import org.opensearch.test.OpenSearchTestCase;
        PipelineProcessingContext context = new PipelineProcessingContext();
        Map<String, Object> config = new HashMap<>(Map.of(OversampleRequestProcessor.SAMPLE_FACTOR, 3.0));  
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder().size(10);  
        SearchRequest transformedRequest = processor.processRequest(request, context);  
 */  
import org.opensearch.action.search.SearchRequest;
    }  
        assertEquals(10, context.getAttribute("original_size"));
        OversampleRequestProcessor processor = factory.create(Collections.emptyMap(), null, null, false, config, null);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.builder.SearchSourceBuilder;
import java.util.HashMap;
        OversampleRequestProcessor processor = factory.create(Collections.emptyMap(), null, null, false, config, null);
    public void testContextPrefix() {
 *
        PipelineProcessingContext context = new PipelineProcessingContext();
        SearchRequest request = new SearchRequest().source(sourceBuilder);
            Map.of(OversampleRequestProcessor.SAMPLE_FACTOR, 3.0, ContextUtils.CONTEXT_PREFIX_PARAMETER, "foo")
import org.opensearch.search.pipeline.common.helpers.ContextUtils;
import java.util.Map;  
        Map<String, Object> config = new HashMap<>(
/*  
}
    }
        SearchRequest transformedRequest = processor.processRequest(request, context);
        OversampleRequestProcessor.Factory factory = new OversampleRequestProcessor.Factory();
        Map<String, Object> config = new HashMap<>(Map.of(OversampleRequestProcessor.SAMPLE_FACTOR, 3.0));  
public class OversampleRequestProcessorTests extends OpenSearchTestCase {
        OversampleRequestProcessor.Factory factory = new OversampleRequestProcessor.Factory();  
        );  
        assertNull(context.getAttribute("original_size"));
        SearchRequest request = new SearchRequest().source(sourceBuilder);
        OversampleRequestProcessor.Factory factory = new OversampleRequestProcessor.Factory();
        OversampleRequestProcessor processor = factory.create(Collections.emptyMap(), null, null, false, config, null);
        assertEquals(30, transformedRequest.source().size());
package org.opensearch.search.pipeline.common;
        SearchRequest request = new SearchRequest();  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(request, transformedRequest);  
        assertEquals(30, transformedRequest.source().size());
import java.util.Collections;
 * compatible open source license.
