        final Pipeline pipeline = Pipeline.createSystemIngestPipeline("my-index", Map.of("factory", factory), config);  
    }
        assertTrue(pipeline.getProcessors().isEmpty());
        assertNotNull(pipeline);
        final Map<String, Object> config = Map.of("key", "value");
            RuntimeException.class,
        assertNotNull(pipeline);
        final RuntimeException e = assertThrows(  
import static org.mockito.Mockito.when;
}  
        assertSame(processor, pipeline.getProcessors().get(0));
 *
 * compatible open source license.
import static org.mockito.Mockito.times;
    public void testCreatePipelineWithOneProcessor() throws Exception {
    public void testCreatePipelineWithEmptyConfig() {
        final Map<String, Object> config = Map.of("key", "value");
/*  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(1, pipeline.getProcessors().size());
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
        final Processor.Factory faultyFactory = mock(Processor.Factory.class);  
        when(faultyFactory.create(any(), any(), any(), any())).thenThrow(new RuntimeException("Factory failed"));
            () -> Pipeline.createSystemIngestPipeline("my-index", Map.of("factory", faultyFactory), config)
        when(processor.isSystemGenerated()).thenReturn(true);
import java.util.Collections;  
        when(factory.isSystemGenerated()).thenReturn(true);  
import static org.mockito.Mockito.verify;  
        assertEquals("test-index_system_generated_ingest_pipeline", pipeline.getId());  
        assertTrue(e.getMessage().contains("Factory failed"));
        final Processor processor = mock(Processor.class);
package org.opensearch.ingest;
        );  
    public void testCreatePipelineWithFactoryException() throws Exception {
 */  
 * SPDX-License-Identifier: Apache-2.0
        final Pipeline pipeline = Pipeline.createSystemIngestPipeline("test-index", Collections.emptyMap(), Collections.emptyMap());  
import static org.mockito.ArgumentMatchers.any;  
    }
        when(factory.create(any(), any(), any(), any())).thenReturn(processor);
import static org.mockito.Mockito.mock;
import org.opensearch.test.OpenSearchTestCase;
        final Processor.Factory factory = mock(Processor.Factory.class);  
public class PipelineTests extends OpenSearchTestCase {  
        assertEquals("my-index_system_generated_ingest_pipeline", pipeline.getId());  
        verify(factory, times(1)).create(any(), any(), any(), any());
    }
