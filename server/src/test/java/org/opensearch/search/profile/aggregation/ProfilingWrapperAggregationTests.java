 * The OpenSearch Contributors require contributions made to  
/**  
        ProfilingAggregator profilingAggregator = new ProfilingAggregator(mockAggregator, profiler);
import org.opensearch.search.profile.ProfilingWrapper;  
package org.opensearch.search.profile.aggregation;
 * compatible open source license.
public class ProfilingWrapperAggregationTests extends OpenSearchTestCase {
        assertTrue("ProfilingLeafBucketCollector should implement ProfilingWrapper", profilingCollector instanceof ProfilingWrapper);  
        // Verify implements ProfilingWrapper
        assertTrue("ProfilingAggregator should implement ProfilingWrapper", profilingAggregator instanceof ProfilingWrapper);
}
 * Tests that ProfilingAggregator and ProfilingLeafBucketCollector
        ProfilingLeafBucketCollector profilingCollector = new ProfilingLeafBucketCollector(mockCollector, profileBreakdown);  
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testProfilingAggregatorImplementsProfilingWrapper() {  
/*  
 */  
        LeafBucketCollector mockCollector = mock(LeafBucketCollector.class);  
        // Verify getDelegate returns the original aggregator
 */  
        when(mockAggregator.name()).thenReturn("test_agg");
        assertSame("getDelegate() should return the original aggregator", mockAggregator, profilingAggregator.getDelegate());
 * this file be licensed under the Apache-2.0 license or a
        AggregationProfiler profiler = new AggregationProfiler();  
import org.opensearch.search.aggregations.LeafBucketCollector;
import org.opensearch.search.aggregations.Aggregator;
        // Verify getDelegate returns the original collector
    }  
        AggregationProfileBreakdown profileBreakdown = new AggregationProfileBreakdown();
        // Verify implements ProfilingWrapper
import static org.mockito.Mockito.when;
    public void testProfilingLeafBucketCollectorImplementsProfilingWrapper() {
 * correctly implement the ProfilingWrapper interface.
import static org.mockito.Mockito.mock;  
 *
        Aggregator mockAggregator = mock(Aggregator.class);
        assertSame("getDelegate() should return the original collector", mockCollector, profilingCollector.getDelegate());  
