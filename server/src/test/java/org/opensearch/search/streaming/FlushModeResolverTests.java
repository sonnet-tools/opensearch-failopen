        assertEquals(FlushMode.PER_SHARD, result);
        // topN=100_000 == maxBucketCount=100_000, should stream (<=)
    public void testDecideFlushModeStreamable() {
 * compatible open source license.
        FlushMode result = FlushModeResolver.decideFlushMode(streamable, FlushMode.PER_SHARD, 100_000);
        assertEquals(FlushMode.PER_SEGMENT, result);
        FlushMode result = FlushModeResolver.decideFlushMode(highTopN, FlushMode.PER_SHARD, 100_000);
    }
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 */  
        StreamingCostMetrics neutral = StreamingCostMetrics.neutral();  
public class FlushModeResolverTests extends OpenSearchTestCase {
package org.opensearch.search.streaming;
        assertEquals(1000L, FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT.getDefault(Settings.EMPTY).longValue());  
 *
        assertEquals(FlushMode.PER_SHARD, result);  
        assertEquals(FlushMode.PER_SEGMENT, result);  
    }  
        assertEquals(FlushMode.PER_SEGMENT, result);
        assertEquals(1000, FlushModeResolver.STREAMING_AGGREGATION_MIN_SEGMENT_SIZE_SETTING.getDefault(Settings.EMPTY).intValue());
    public void testDecideFlushModeTopNExactlyAtMax() {  
        StreamingCostMetrics streamable = new StreamingCostMetrics(true, 10);  
import org.opensearch.test.OpenSearchTestCase;
    public void testDecideFlushModeTopNExceedsMax() {
 * Tests for FlushModeResolver settings and decideFlushMode logic.
    public void testDecideFlushModeNonStreamable() {
        FlushMode result = FlushModeResolver.decideFlushMode(nonStreamable, FlushMode.PER_SHARD, 100_000);  
        assertEquals(0.01, FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO.getDefault(Settings.EMPTY).doubleValue(), 0.001);
        StreamingCostMetrics smallTopN = new StreamingCostMetrics(true, 1);
        // topN=10 <= maxBucketCount=100_000, should stream
        assertEquals(100_000L, FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT.getDefault(Settings.EMPTY).longValue());
        // topN=200_000 > maxBucketCount=100_000, should not stream  
    public void testSettingsDefaults() {  
    public void testDecideFlushModeNeutralMetrics() {
 */  
/*  
    }  
        FlushMode result = FlushModeResolver.decideFlushMode(exactMatch, FlushMode.PER_SHARD, 100_000);  
    }
        // Very small topN (cardinality case), should stream  
        StreamingCostMetrics highTopN = new StreamingCostMetrics(true, 200_000);
 * The OpenSearch Contributors require contributions made to  
        // Neutral metrics have topN=1, which is <= any reasonable max, so should stream
        FlushMode result = FlushModeResolver.decideFlushMode(neutral, FlushMode.PER_SHARD, 100_000);
        assertEquals(FlushMode.PER_SEGMENT, result);
import org.opensearch.common.settings.Settings;
    }
/**
        FlushMode result = FlushModeResolver.decideFlushMode(smallTopN, FlushMode.PER_SHARD, 100_000);
    public void testDecideFlushModeSmallTopN() {
    }
    }
}
        StreamingCostMetrics nonStreamable = StreamingCostMetrics.nonStreamable();
        StreamingCostMetrics exactMatch = new StreamingCostMetrics(true, 100_000);
