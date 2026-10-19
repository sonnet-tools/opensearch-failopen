        largeRequest.source(largeSource);
        SearchSourceBuilder source = new SearchSourceBuilder();
        assertTrue(processor.isIgnoreFailure());  
            "tagX",  
        assertSame(request, processed);
        assertNotNull(processed);
    public void testProcessRequestHandlesNullSource() {
public class ExampleSearchRequestPostProcessorTests extends OpenSearchTestCase {
        assertFalse(factory.shouldGenerate(new ProcessorGenerationContext(null, null)));
            "desc",
            null,
        ProcessorGenerationContext largeContext = new ProcessorGenerationContext(largeRequest, null);
import java.util.Collections;  
    public void testFactoryCreate() throws Exception {
 * compatible open source license.
            true,
/*  
        assertEquals("tag1", processor.getTag());
        SearchRequest request = new SearchRequest(); // source is null  
        assertEquals(ExampleSearchRequestPostProcessor.TYPE, processor.getType());  
        ExampleSearchRequestPostProcessor.Factory factory = new ExampleSearchRequestPostProcessor.Factory();  
 *
        assertEquals(5, processed.source().size()); // size + 2
}
        ExampleSearchRequestPostProcessor.Factory factory = new ExampleSearchRequestPostProcessor.Factory();
            null
 * this file be licensed under the Apache-2.0 license or a
        SearchRequest request = new SearchRequest();
        assertEquals("tagX", processor.getTag());
        ExampleSearchRequestPostProcessor processor = new ExampleSearchRequestPostProcessor("tag1", false);
        assertNotNull(processor);
import org.opensearch.action.search.SearchRequest;
        SearchRequest processed = processor.processRequest(request);
        assertFalse(factory.shouldGenerate(largeContext));
        SearchRequest processed = processor.processRequest(request);
import org.opensearch.search.pipeline.ProcessorGenerationContext;  
        source.size(3); // initial size
        assertEquals(ExampleSearchRequestPostProcessor.ExecutionStage.POST_USER_DEFINED, processor.getExecutionStage());
        SearchSourceBuilder largeSource = new SearchSourceBuilder().size(6);
    public void testProcessRequestIncreasesSize() {  
        smallRequest.source(smallSource);
    }
import org.opensearch.test.OpenSearchTestCase;
        SearchSourceBuilder smallSource = new SearchSourceBuilder().size(3);  
    public void testFactoryShouldGenerate() {
 * The OpenSearch Contributors require contributions made to  
        request.source(source);
    public void testGetters() {
package org.opensearch.example.systemsearchprocessor;
 */  
 * SPDX-License-Identifier: Apache-2.0
        ProcessorGenerationContext smallContext = new ProcessorGenerationContext(smallRequest, null);  
        assertTrue(factory.shouldGenerate(smallContext));  
        ExampleSearchRequestPostProcessor processor = new ExampleSearchRequestPostProcessor("tag1", true);
    }  
    }  
    }
        SearchRequest largeRequest = new SearchRequest();  
        assertEquals(ExampleSearchRequestPostProcessor.DESCRIPTION, processor.getDescription());
        ExampleSearchRequestPostProcessor processor = new ExampleSearchRequestPostProcessor("tag1", false);
        ExampleSearchRequestPostProcessor processor = (ExampleSearchRequestPostProcessor) factory.create(
            Collections.emptyMap(),  
    }
        );
        assertTrue(processor.isIgnoreFailure());  
import org.opensearch.search.builder.SearchSourceBuilder;
        SearchRequest smallRequest = new SearchRequest();
