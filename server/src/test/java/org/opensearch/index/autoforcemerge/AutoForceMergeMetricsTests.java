        metricsRegistry = mock(MetricsRegistry.class);  
        Optional<Tags> tagsOptional = Optional.of(tags);
        // Verify histogram creation
    public void testGetTagsWithOnlyShardId() {
        verify(metricsRegistry).createCounter(
            eq("1")
    public void testMetricsInitialization() {
        assertNotNull("Tags should not be null", tagsOptional.get());
        super.setUp();
            eq("Counter for tracking segment count during force merge operations."),  
        verify(metricsRegistry).createCounter(
        assertEquals("node_id", AutoForceMergeMetrics.NODE_ID);
    }  
            eq("auto_force_merge.shard.size"),  
    public void testGetTagsWithBothIds() {  
        // Verify counter creation
        );  
        );  
        metrics.recordInHistogram(mockHistogram, value, Optional.empty());
        Optional<Tags> tagsOptional = metrics.getTags(Optional.empty(), Optional.empty());
        );
        verify(metricsRegistry).createCounter(
    }  
import org.opensearch.test.OpenSearchTestCase;
    private Counter mockCounter;
            eq("1")
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        );  
    public void testConstantValues() {
            eq("auto_force_merge.merges.triggered"),
        Tags tags = Tags.create();
public class AutoForceMergeMetricsTests extends OpenSearchTestCase {
        metrics.incrementCounter(mockCounter, value, Optional.empty());
import org.opensearch.telemetry.metrics.Counter;
        assertNotNull("Tags should not be null", tagsOptional.get());  
    }  
            eq("1")  
import org.opensearch.telemetry.metrics.tags.Tags;
        metrics.incrementCounter(mockCounter, value, null);
        Optional<Tags> tagsOptional = Optional.of(tags);
        Optional<Tags> tagsOptional = metrics.getTags(Optional.empty(), Optional.of(shardId));  
        );
            eq("Histogram for tracking time taken by force merge on individual shards."),
            eq("Counter for number of force merges triggered."),
        String nodeId = "node1";
        Double value = 1.0;  
    public void testIncrementCounterWithNullTags() {
    }
        Optional<Tags> tagsOptional = metrics.getTags(Optional.of(nodeId), Optional.empty());
 * compatible open source license.
import static org.mockito.ArgumentMatchers.anyString;
        verify(metricsRegistry).createCounter(
        );
    }
    }
        verify(mockHistogram, times(1)).record(value);
    }  
        assertNotNull("Tags should not be null", tagsOptional.get());  
            eq("1")  
    }
            eq("auto_force_merge.merges.skipped.node_validator"),
    }
import org.opensearch.telemetry.metrics.Histogram;
        String nodeId = "node1";  
    public void testRecordInHistogramWithTags() {
 *
        assertTrue("Tags should be present", tagsOptional.isPresent());
import java.util.Optional;
        Double value = 100.0;  
            eq("auto_force_merge.merges.skipped.config_validator"),  
            eq("auto_force_merge.scheduler.execution_time"),
            eq("Counter for number of force merges skipped due to Node Validator."),  
import static org.mockito.Mockito.times;
        Double value = 100.0;  
            eq("auto_force_merge.shard.segment_count"),
    private AutoForceMergeMetrics metrics;
    private Histogram mockHistogram;  
        mockHistogram = mock(Histogram.class);
        Double value = 1.0;  
        );
        Tags tags = Tags.create();
            eq("1")
        );
        when(metricsRegistry.createHistogram(anyString(), anyString(), anyString())).thenReturn(mockHistogram);
 * SPDX-License-Identifier: Apache-2.0
    public void testRecordInHistogramWithNullTags() {
/*  
        String shardId = "shard1";
        verify(metricsRegistry).createCounter(  
    }  
            eq("Counter for number of force merges failed."),
        assertTrue("Tags should be present", tagsOptional.isPresent());  
    public void testGetTagsWithOnlyNodeId() {
        metrics.recordInHistogram(mockHistogram, value, tagsOptional);
        verify(metricsRegistry).createHistogram(  
        assertTrue("Tags should be present", tagsOptional.isPresent());  
    public void testIncrementCounterWithTags() {
    }  
            eq("Counter for tracking shard size during force merge operations."),
        metrics.recordInHistogram(mockHistogram, value, null);
        when(metricsRegistry.createCounter(anyString(), anyString(), anyString())).thenReturn(mockCounter);
    public void testGetTagsWithEmptyOptionals() {  
        assertNotNull("Tags should not be null", tagsOptional.get());
        verify(mockCounter, times(1)).add(value);
        verify(metricsRegistry).createCounter(  
    public void testRecordInHistogramWithEmptyTags() {
        verify(metricsRegistry).createHistogram(
            eq("bytes")
        Double value = 1.0;  
import static org.mockito.Mockito.mock;  
        verify(mockHistogram, times(1)).record(value);
        Optional<Tags> tagsOptional = metrics.getTags(Optional.of(nodeId), Optional.of(shardId));  
        String shardId = "shard1";
            eq("Counter for number of force merges skipped due to Configuration Validator."),
            eq("auto_force_merge.merges.failed"),
    @Before  
    public void setUp() throws Exception {
 */  
            eq("Histogram for tracking total scheduler execution time."),
            eq("auto_force_merge.shard.merge_latency"),  
import static org.mockito.Mockito.verify;
    }  
        verify(mockHistogram, times(1)).record(eq(value), eq(tags));
            eq("ms")
        Double value = 100.0;  
import org.opensearch.telemetry.metrics.MetricsRegistry;  
        metrics.incrementCounter(mockCounter, value, tagsOptional);
            eq("ms")  
        mockCounter = mock(Counter.class);
import static org.mockito.Mockito.when;  
        verify(mockCounter, times(1)).add(value);
    private MetricsRegistry metricsRegistry;
        verify(mockCounter, times(1)).add(eq(value), eq(tags));
import static org.mockito.ArgumentMatchers.eq;
package org.opensearch.index.autoforcemerge;
        assertEquals("shard_id", AutoForceMergeMetrics.SHARD_ID);  
    public void testIncrementCounterWithEmptyTags() {
    }
}
        metrics = new AutoForceMergeMetrics(metricsRegistry);
import org.junit.Before;  
        assertTrue("Tags should be present", tagsOptional.isPresent());
