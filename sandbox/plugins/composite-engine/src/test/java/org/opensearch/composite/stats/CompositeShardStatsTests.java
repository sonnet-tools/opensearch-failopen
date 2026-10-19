import org.opensearch.common.xcontent.XContentFactory;
        assertEquals(0L, get(json, "refresh.refresh_total"));  
        }  
import org.opensearch.common.io.stream.BytesStreamOutput;
}  
    public void testAddSumsAllCounters() {  
        CompositeShardStats original = new CompositeShardStats(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    }
import org.opensearch.core.xcontent.ToXContent;  
        assertEquals(1L, get(json, "merge.merge_total"));
        BytesStreamOutput out = new BytesStreamOutput();
    public void testTrackerCountersFlowIntoSnapshot() {
    private static long get(Map<String, Object> json, String dotted) {
import org.opensearch.common.xcontent.XContentHelper;  
        tracker.incRefreshMergeFailures();
        tracker.incMergeTotal();  
        tracker.incRefreshMergeTotal();  
        try (StreamInput in = out.bytes().streamInput()) {
 */  
        assertEquals(0L, get(json, "merge.merge_failures"));
        tracker.incWritePrimaryFailures();
    private static Map<String, Object> toMap(CompositeShardStats stats) {
 */
        Map<String, Object> json = toMap(CompositeShardStats.empty());
        return ((Number) cur).longValue();
            stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
            var builder = XContentFactory.jsonBuilder().startObject();  
 * compatible open source license.
        assertEquals(1L, get(json, "write.write_primary_failures"));
        assertEquals(1L, get(json, "write.write_secondary_failures"));  
        Map<String, Object> json = toMap(s);  
import java.util.Map;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.json.JsonXContent;
        assertEquals(1L, get(json, "write.write_total"));
        } catch (Exception e) {
 * Unit tests for {@link CompositeShardStats} and {@link CompositeShardStatsTracker}:  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(1L, get(json, "refresh.refresh_merge_failures"));  
        assertEquals(4L, get(json, "refresh.refresh_merge_time_millis"));
        assertEquals(110L, get(json, "write.write_primary_failures"));
        tracker.addRefreshMergeTimeMillis(4);
            return XContentHelper.convertToMap(JsonXContent.jsonXContent, builder.toString(), true);  
        assertEquals(1L, get(json, "mapping.mapping_update_executed_total"));
        assertEquals(33L, get(json, "refresh.refresh_merge_total"));  
        tracker.incMappingUpdateExecutedTotal();  
        CompositeShardStats a = new CompositeShardStats(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        assertEquals(1L, get(json, "refresh.refresh_merge_total"));
            cur = ((Map<String, Object>) cur).get(p);
        for (String p : parts) {
    }
        assertEquals(132L, get(json, "mapping.mapping_update_executed_total"));  
        assertEquals(0L, get(json, "mapping.mapping_update_executed_total"));  
        assertEquals(88L, get(json, "merge.merge_failures"));  
        Map<String, Object> json = toMap(a.add(b));  
    @SuppressWarnings("unchecked")  
 * The OpenSearch Contributors require contributions made to  
            throw new AssertionError(e);
    public void testEmptyIsAllZero() {
        }
        tracker.incWriteSecondaryFailures();
/**
        original.writeTo(out);  
        tracker.incMergeFailures();
        assertEquals(66L, get(json, "merge.merge_total"));
        assertEquals(7L, get(json, "merge.merge_time_millis"));
        assertEquals(55L, get(json, "refresh.refresh_merge_failures"));
        assertEquals(10L, get(json, "refresh.refresh_time_millis"));  
        tracker.incWriteTotal();  
        tracker.addMergeTimeMillis(7);
        assertEquals(1L, get(json, "refresh.refresh_total"));
    }
    }
        assertEquals(11L, get(json, "refresh.refresh_total"));
            CompositeShardStats restored = new CompositeShardStats(in);
import org.opensearch.core.common.io.stream.StreamInput;
    }
        tracker.incRefreshTotal();
    public void testStreamRoundTrip() throws Exception {  
/*  
            builder.endObject();
        try {
            assertEquals(toMap(original), toMap(restored));  
        Object cur = json;  
        assertEquals(0L, get(json, "write.write_primary_failures"));
        }  
public class CompositeShardStatsTests extends OpenSearchTestCase {  
 *
        CompositeShardStats s = tracker.stats();
 * counter increments, snapshot fidelity, aggregation, and wire/XContent round-trips.
        tracker.addRefreshTimeMillis(10);
        String[] parts = dotted.split("\\.");
        assertEquals(1L, get(json, "merge.merge_failures"));  
package org.opensearch.composite.stats;
    }
        CompositeShardStatsTracker tracker = new CompositeShardStatsTracker();  
        CompositeShardStats b = new CompositeShardStats(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(99L, get(json, "write.write_total"));
