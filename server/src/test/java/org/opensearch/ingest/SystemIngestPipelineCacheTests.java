 * SPDX-License-Identifier: Apache-2.0
public class SystemIngestPipelineCacheTests extends OpenSearchTestCase {
        try {  
        Mockito.when(largeProcessor.getProcessors()).thenReturn(new java.util.ArrayList<>(11));  
    public void testEvictionWhenCacheIsFull() {  
import static org.mockito.Mockito.mock;  
        assertNotNull(retrieved);
import org.opensearch.test.OpenSearchTestCase;
 *
import org.mockito.Mockito;
 * The OpenSearch Contributors require contributions made to  
    @Before  
        cache.cachePipeline(index, dummyPipeline, 10);
        // The cache should not exceed 100 entries
        for (int i = 0; i < 101; i++) {
    }
        cache.cachePipeline(index, dummyPipeline, 10);  
        assertEquals(dummyPipeline, retrieved);  
    public void testCachePipelineAndRetrieve() {  
    }
        }
    public void setup() {
        Pipeline largePipeline = new Pipeline("id", "description", null, largeProcessor);
        dummyPipeline = new Pipeline("id", "description", null, new CompoundProcessor());  
        }  
 */  
    }
import org.junit.Before;
        assertEquals(100, cache.size());  
    }
 * this file be licensed under the Apache-2.0 license or a
        Pipeline retrieved = cache.getSystemIngestPipeline(index);
    public void testCacheExceedMaxProcessorNumberThrowsException() {  
package org.opensearch.ingest;
        assertNull(cache.getSystemIngestPipeline(index));  
            cache.cachePipeline(index, largePipeline, 10);
/*  
 * compatible open source license.
}
        String index = "test_index";
    private SystemIngestPipelineCache cache;  
    public void testInvalidateCache() {
            cache.cachePipeline("index_" + i, dummyPipeline, 10);
        cache = new SystemIngestPipelineCache();
        String index = "test_index";
        cache.invalidateCacheForIndex(index);
        } catch (IllegalArgumentException e) {
    private Pipeline dummyPipeline;
    }
        CompoundProcessor largeProcessor = mock(CompoundProcessor.class);
        String index = "test_index";
            assertTrue(e.getMessage().contains("Too many system ingest processors"));  
