                            + searchTaskTotal
        assertNotEquals(stats1, new AnalyticsBackendTaskCancellationStats(1, 99, 3, 4));
        AnalyticsBackendTaskCancellationStats stats1 = new AnalyticsBackendTaskCancellationStats(1, 2, 3, 4);
import org.opensearch.common.io.stream.BytesStreamOutput;
     * Test equals: reflexive property.
                    );  
        // While not strictly required by the contract, different values should produce different hashes
        assertEquals(40, stats.getSearchShardTaskTotal());
     * serializing via writeTo, and deserializing via the StreamInput constructor SHALL produce
     * Validates: Requirement 6.7  
     */
     * Validates: Requirement 6.7
    }
     * Test equals: null and different type.
     *  
    /**  
            AnalyticsBackendTaskCancellationStats original = new AnalyticsBackendTaskCancellationStats(
     * Test hashCode: equal objects have equal hash codes.
import org.opensearch.core.xcontent.ToXContent;
 * Tests for {@link AnalyticsBackendTaskCancellationStats} covering serialization round-trip (property test),
    /**
    // ─── Property Test: Serialization Round-Trip (Property 3) ───────────────────
                shardTaskTotal
        builder.startObject();  
    public void testEqualsReflexive() {
     * Validates: Requirement 6.3  
     *
            long shardTaskCurrent = randomNonNegativeLong();
                            + ", "
    public void testHashCodeConsistentWithEquals() {
     * Test that toXContent handles zero values correctly.
     */
        AnalyticsBackendTaskCancellationStats stats = new AnalyticsBackendTaskCancellationStats(1, 2, 3, 4);
            );  
            }  
     */
 * compatible open source license.
    }  
        AnalyticsBackendTaskCancellationStats stats = new AnalyticsBackendTaskCancellationStats(5, 10, 15, 20);  
                original.writeTo(out);  
     */
     *  
import org.opensearch.test.OpenSearchTestCase;  
        // Differ in each field  
        assertEquals(stats, stats);
                            + shardTaskCurrent  
        assertNotEquals(stats1, new AnalyticsBackendTaskCancellationStats(99, 2, 3, 4));
        // Verify the JSON contains the expected structure  
    /**
    /**  
                            + ", "  
 * The OpenSearch Contributors require contributions made to  
                searchTaskCurrent,
        assertEquals(10, stats.getSearchTaskCurrent());
        assertNotEquals(stats1, new AnalyticsBackendTaskCancellationStats(1, 2, 3, 99));
        assertNotEquals(stats1.hashCode(), stats2.hashCode());
                    assertEquals("hashCode mismatch after round-trip", original.hashCode(), deserialized.hashCode());
                            + searchTaskCurrent
            long searchTaskTotal = randomNonNegativeLong();  
        assertEquals(30, stats.getSearchShardTaskCurrent());
        AnalyticsBackendTaskCancellationStats stats1 = new AnalyticsBackendTaskCancellationStats(1, 2, 3, 4);
import org.opensearch.core.xcontent.XContentBuilder;
     */
     * Validates: Requirement 6.7
        assertEquals(stats2, stats1);  
/**
    }
     * Validates: Requirement 6.7  
    public void testSerializationRoundTrip() throws IOException {  
        String json = builder.toString();
        assertNotEquals(stats1, new AnalyticsBackendTaskCancellationStats(1, 2, 99, 4));  
        XContentBuilder builder = XContentFactory.jsonBuilder();
     * Validates: Requirements 6.4, 6.5, 6.8
        AnalyticsBackendTaskCancellationStats stats = new AnalyticsBackendTaskCancellationStats(10, 20, 30, 40);  
    }
     * an equal instance.
    public void testEqualsWithSameValues() {
public class AnalyticsBackendTaskCancellationStatsTests extends OpenSearchTestCase {
                            + "]",  
        assertEquals(stats1.hashCode(), stats2.hashCode());
     * Test equals: same values produce equal instances.  
    public void testConstructorStoresFieldsCorrectly() {
 * SPDX-License-Identifier: Apache-2.0
    public void testToXContentWithZeroValues() throws IOException {
    // ─── Unit Tests ─────────────────────────────────────────────────────────────
 */  
                        deserialized
                }
    }
     */  
package org.opensearch.plugin.stats;
     *
    /**  
     * Test equals: different values produce non-equal instances.
        }
     * Test hashCode: different objects likely have different hash codes.
                searchTaskTotal,  
     * Validates: Requirement 6.7
     */
     *  
     *
    /**  
        XContentBuilder builder = XContentFactory.jsonBuilder();
                shardTaskCurrent,
        String expected = "{\"analytics_search_task\":{\"current_count_post_cancel\":0,\"total_count_post_cancel\":0},"  
        assertEquals(expected, json);
    }  
        AnalyticsBackendTaskCancellationStats stats2 = new AnalyticsBackendTaskCancellationStats(1, 2, 3, 4);  
        assertEquals(20, stats.getSearchTaskTotal());  
    public void testEqualsNullAndDifferentType() {  
     * Uses non-negative longs since the implementation uses writeVLong (variable-length encoding
        String json = builder.toString();
            + "\"analytics_search_shard_task\":{\"current_count_post_cancel\":5,\"total_count_post_cancel\":892}}";
     * Validates: Requirement 6.6  
     *  
        AnalyticsBackendTaskCancellationStats stats2 = new AnalyticsBackendTaskCancellationStats(5, 6, 7, 8);
        builder.endObject();
import org.opensearch.common.xcontent.XContentFactory;
    }
                    assertEquals(  
                        original,
            try (BytesStreamOutput out = new BytesStreamOutput()) {
            + "\"analytics_search_shard_task\":{\"current_count_post_cancel\":0,\"total_count_post_cancel\":0}}";
     */
    /**  
 * this file be licensed under the Apache-2.0 license or a
        AnalyticsBackendTaskCancellationStats stats = new AnalyticsBackendTaskCancellationStats(2, 147, 5, 892);  
     * for non-negative values) and these fields represent counters which are always >= 0.
    /**
        assertEquals(stats1, stats2);  
        assertNotEquals(null, stats);
     *  
    }  
    /**
        builder.startObject();  
        assertNotEquals("not a stats object", stats);  
        for (int i = 0; i < 100; i++) {
                    AnalyticsBackendTaskCancellationStats deserialized = new AnalyticsBackendTaskCancellationStats(in);
     * Property 3: AnalyticsBackendTaskCancellationStats serialization round-trip.
                        "Round-trip failed for values: ["
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
import java.io.IOException;
            long shardTaskTotal = randomNonNegativeLong();
        builder.endObject();
                try (StreamInput in = out.bytes().streamInput()) {
/*  
     *
        AnalyticsBackendTaskCancellationStats stats1 = new AnalyticsBackendTaskCancellationStats(7, 14, 21, 28);  
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
     * Validates: Requirement 6.6  
     * Validates: Requirement 6.7
                            + shardTaskTotal
 */
        assertEquals(stats1, stats2);
    public void testHashCodeDiffersForDifferentValues() {  
        String expected = "{\"analytics_search_task\":{\"current_count_post_cancel\":2,\"total_count_post_cancel\":147},"
     * and analytics_search_shard_task sub-objects.
    /**
     *
    }
     */
import org.opensearch.core.common.io.stream.StreamInput;  
                            + ", "
     * Test that the constructor stores all 4 fields correctly.
        AnalyticsBackendTaskCancellationStats stats2 = new AnalyticsBackendTaskCancellationStats(7, 14, 21, 28);
        AnalyticsBackendTaskCancellationStats stats1 = new AnalyticsBackendTaskCancellationStats(1, 2, 3, 4);
    public void testToXContentProducesExpectedJsonStructure() throws IOException {
    public void testEqualsWithDifferentValues() {  
     *
     * Test that toXContent produces the expected JSON structure with analytics_search_task  
 * constructor correctness, XContent output, and equals/hashCode contract.  
        AnalyticsBackendTaskCancellationStats stats = new AnalyticsBackendTaskCancellationStats(0, 0, 0, 0);  
}
     *
     * For any valid long values for all 4 fields, constructing a AnalyticsBackendTaskCancellationStats,  
            long searchTaskCurrent = randomNonNegativeLong();
    }
        assertEquals(expected, json);  
     */
 *
