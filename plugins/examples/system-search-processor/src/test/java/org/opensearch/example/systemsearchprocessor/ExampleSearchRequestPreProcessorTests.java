        ProcessorGenerationContext largeContext = new ProcessorGenerationContext(largeRequest, null);
        ExampleSearchRequestPreProcessor processor = (ExampleSearchRequestPreProcessor) factory.create(
}
        ExampleSearchRequestPreProcessor processor = new ExampleSearchRequestPreProcessor("tag1", true);
    }  
package org.opensearch.example.systemsearchprocessor;
        ExampleSearchRequestPreProcessor processor = new ExampleSearchRequestPreProcessor("tag1", false);
        boundaryRequest.source(new SearchSourceBuilder().size(5));  
        ProcessorGenerationContext nullContext = new ProcessorGenerationContext(null, null);
    public void testFactoryCreate() throws Exception {
        // original size > 5 => should not generate
 * The OpenSearch Contributors require contributions made to  
            "desc",
        // original size < 5 => should generate
        ExampleSearchRequestPreProcessor processor = new ExampleSearchRequestPreProcessor("tag1", false);
        assertNull(processed);
    public void testProcessRequestHandlesNullRequestOrSource() throws Exception {
        // original size = 5 => should not generate
    }
            null,  
        assertEquals("tag1", processor.getTag());
    public void testGettersAndExecutionStage() {  
import org.opensearch.search.pipeline.PipelineProcessingContext;  
    public void testProcessRequestThrowsUnsupported() {
        SearchRequest processed = processor.processRequest(null, context);  
        // null source  
    }
        largeRequest.source(new SearchSourceBuilder().size(6));  
        SearchRequest reqWithNullSource = new SearchRequest();
        assertEquals(3, context.getAttribute(ExampleSearchRequestPreProcessor.ORIGINAL_QUERY_SIZE_KEY));
public class ExampleSearchRequestPreProcessorTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;
        ExampleSearchRequestPreProcessor.Factory factory = new ExampleSearchRequestPreProcessor.Factory();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.pipeline.ProcessorGenerationContext;
        assertFalse(factory.shouldGenerate(nullContext));  
        assertFalse(factory.shouldGenerate(boundaryContext));
        UnsupportedOperationException ex = assertThrows(UnsupportedOperationException.class, () -> processor.processRequest(request));
        SearchRequest largeRequest = new SearchRequest();
        assertTrue(ex.getMessage().contains(ExampleSearchRequestPreProcessor.TYPE));
        SearchRequest smallRequest = new SearchRequest();
        PipelineProcessingContext context = new PipelineProcessingContext();  
        assertFalse(factory.shouldGenerate(largeContext));
import org.opensearch.action.search.SearchRequest;
    }
        assertTrue(processor.isIgnoreFailure());
            "tagX",
        PipelineProcessingContext context = new PipelineProcessingContext();  
            null
    }
        smallRequest.source(new SearchSourceBuilder().size(4));  
        // null source => should not generate
import java.util.Collections;
 * compatible open source license.
        assertNotNull(processor);
        assertEquals(ExampleSearchRequestPreProcessor.TYPE, processor.getType());  
        // null request
        assertEquals(ExampleSearchRequestPreProcessor.DESCRIPTION, processor.getDescription());
        ProcessorGenerationContext boundaryContext = new ProcessorGenerationContext(boundaryRequest, null);
    public void testFactoryShouldGenerate() {
import org.opensearch.search.builder.SearchSourceBuilder;
        assertNotNull(processed);
        assertSame(reqWithNullSource, processed);  
/*  
        assertFalse(factory.shouldGenerate(nullSourceContext));
        assertEquals(ExampleSearchRequestPreProcessor.ExecutionStage.PRE_USER_DEFINED, processor.getExecutionStage());
        assertTrue(processor.isIgnoreFailure());  
        SearchRequest boundaryRequest = new SearchRequest();
            true,  
        assertEquals(4, processed.source().size()); // original 3 + 1  
        assertTrue(factory.shouldGenerate(smallContext));
 */  
        ProcessorGenerationContext nullSourceContext = new ProcessorGenerationContext(nullSourceRequest, null);
        SearchRequest nullSourceRequest = new SearchRequest();  
        SearchRequest processed = processor.processRequest(request, context);  
        SearchRequest request = new SearchRequest();  
        assertEquals(ExampleSearchRequestPreProcessor.TYPE, processor.getType());
    }  
            Collections.emptyMap(),
        ExampleSearchRequestPreProcessor processor = new ExampleSearchRequestPreProcessor("tag1", false);
        request.source(source);
        ProcessorGenerationContext smallContext = new ProcessorGenerationContext(smallRequest, null);
        // null request => should not generate
        SearchSourceBuilder source = new SearchSourceBuilder().size(3);
        SearchRequest request = new SearchRequest();  
 * SPDX-License-Identifier: Apache-2.0
        );  
        processed = processor.processRequest(reqWithNullSource, context);
 *
        ExampleSearchRequestPreProcessor.Factory factory = new ExampleSearchRequestPreProcessor.Factory();  
        assertEquals("tagX", processor.getTag());  
    public void testProcessRequestWithContextIncrementsSizeAndStoresOriginal() throws Exception {
