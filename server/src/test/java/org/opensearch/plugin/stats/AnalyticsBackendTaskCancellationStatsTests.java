    /**
        // While not strictly required by the contract, different values should produce different hashes
        AnalyticsBackendTaskCancellationStats stats2 = new AnalyticsBackendTaskCancellationStats(5, 6, 7, 8);
            AnalyticsBackendTaskCancellationStats original = new AnalyticsBackendTaskCancellationStats(
 *
 */
    }
import java.io.IOException;
                    assertEquals("hashCode mismatch after round-trip", original.hashCode(), deserialized.hashCode());
     * Validates: Requirements 6.4, 6.5, 6.8
package org.opensearch.plugin.stats;
        XContentBuilder builder = XContentFactory.jsonBuilder();
                            + "]",
    // ─── Property Test: Serialization Round-Trip (Property 3) ───────────────────
                        deserialized
     */
     *
     * Test equals: same values produce equal instances.
            }
    public void testConstructorStoresFieldsCorrectly() {
        String json = builder.toString();
 * The OpenSearch Contributors require contributions made to
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
            long shardTaskTotal = randomNonNegativeLong();
     * serializing via writeTo, and deserializing via the StreamInput constructor SHALL produce
    }
            long searchTaskTotal = randomNonNegativeLong();
import org.opensearch.core.common.io.stream.StreamInput;
        assertNotEquals(stats1, new AnalyticsBackendTaskCancellationStats(1, 2, 99, 4));
                        "Round-trip failed for values: ["
 * constructor correctness, XContent output, and equals/hashCode contract.
        assertEquals(stats2, stats1);
 * Tests for {@link AnalyticsBackendTaskCancellationStats} covering serialization round-trip (property test),
    public void testEqualsReflexive() {
     *
        assertEquals(30, stats.getSearchShardTaskCurrent());
        builder.endObject();
        assertEquals(stats1.hashCode(), stats2.hashCode());
        AnalyticsBackendTaskCancellationStats stats1 = new AnalyticsBackendTaskCancellationStats(1, 2, 3, 4);
        AnalyticsBackendTaskCancellationStats stats = new AnalyticsBackendTaskCancellationStats(0, 0, 0, 0);
     */
     *
    public void testEqualsNullAndDifferentType() {
     */
     * Test that the constructor stores all 4 fields correctly.
    public void testToXContentWithZeroValues() throws IOException {
        assertEquals(stats, stats);
public class AnalyticsBackendTaskCancellationStatsTests extends OpenSearchTestCase {
            long shardTaskCurrent = randomNonNegativeLong();
        // Verify the JSON contains the expected structure
        AnalyticsBackendTaskCancellationStats stats1 = new AnalyticsBackendTaskCancellationStats(7, 14, 21, 28);
    // ─── Unit Tests ─────────────────────────────────────────────────────────────
        }
        AnalyticsBackendTaskCancellationStats stats2 = new AnalyticsBackendTaskCancellationStats(1, 2, 3, 4);
    }
        assertEquals(40, stats.getSearchShardTaskTotal());
     * Test equals: different values produce non-equal instances.
        assertEquals(stats1, stats2);
        assertEquals(stats1, stats2);
     * Validates: Requirement 6.6
    }
    public void testHashCodeConsistentWithEquals() {
    }
    public void testHashCodeDiffersForDifferentValues() {
        assertEquals(expected, json);
        assertNotEquals(stats1, new AnalyticsBackendTaskCancellationStats(1, 99, 3, 4));
        for (int i = 0; i < 100; i++) {
                        original,
    /**
                    assertEquals(
     * Validates: Requirement 6.7
    }
                            + ", "
     *
     */
     * Uses non-negative longs since the implementation uses writeVLong (variable-length encoding
        assertEquals(10, stats.getSearchTaskCurrent());
     * Validates: Requirement 6.7
        // Differ in each field
     */
                shardTaskTotal
        AnalyticsBackendTaskCancellationStats stats2 = new AnalyticsBackendTaskCancellationStats(7, 14, 21, 28);
    /**
    /**
                try (StreamInput in = out.bytes().streamInput()) {
                    AnalyticsBackendTaskCancellationStats deserialized = new AnalyticsBackendTaskCancellationStats(in);
     *
     */
                searchTaskCurrent,
     *
/**
     * Test that toXContent produces the expected JSON structure with analytics_search_task
        AnalyticsBackendTaskCancellationStats stats = new AnalyticsBackendTaskCancellationStats(1, 2, 3, 4);
            );
     * Test equals: reflexive property.
        assertEquals(20, stats.getSearchTaskTotal());
     */
     * Validates: Requirement 6.7
        String expected = "{\"analytics_search_task\":{\"current_count_post_cancel\":0,\"total_count_post_cancel\":0},"
 */
     *
        assertNotEquals(stats1.hashCode(), stats2.hashCode());
import org.opensearch.common.xcontent.XContentFactory;
            + "\"analytics_search_shard_task\":{\"current_count_post_cancel\":0,\"total_count_post_cancel\":0}}";
        assertNotEquals(null, stats);
        AnalyticsBackendTaskCancellationStats stats1 = new AnalyticsBackendTaskCancellationStats(1, 2, 3, 4);
     * Test equals: null and different type.
                original.writeTo(out);
 * compatible open source license.
                }
     * Property 3: AnalyticsBackendTaskCancellationStats serialization round-trip.
        String json = builder.toString();
     *
 * SPDX-License-Identifier: Apache-2.0
        AnalyticsBackendTaskCancellationStats stats = new AnalyticsBackendTaskCancellationStats(2, 147, 5, 892);
        builder.endObject();
     *
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertNotEquals(stats1, new AnalyticsBackendTaskCancellationStats(1, 2, 3, 99));
    }
     */
     *
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
                            + shardTaskCurrent
    }
     *
    /**
                    );
    public void testEqualsWithSameValues() {
/*
import org.opensearch.core.xcontent.XContentBuilder;
            try (BytesStreamOutput out = new BytesStreamOutput()) {
        String expected = "{\"analytics_search_task\":{\"current_count_post_cancel\":2,\"total_count_post_cancel\":147},"
    /**
        AnalyticsBackendTaskCancellationStats stats = new AnalyticsBackendTaskCancellationStats(5, 10, 15, 20);
    }
     * an equal instance.
}
     * Validates: Requirement 6.6
     * Test that toXContent handles zero values correctly.
        assertNotEquals("not a stats object", stats);
                            + ", "
    public void testEqualsWithDifferentValues() {
    public void testSerializationRoundTrip() throws IOException {
                            + ", "
     */
        assertEquals(expected, json);
                            + searchTaskCurrent
    /**
        XContentBuilder builder = XContentFactory.jsonBuilder();
                shardTaskCurrent,
     * Test hashCode: equal objects have equal hash codes.
     * For any valid long values for all 4 fields, constructing a AnalyticsBackendTaskCancellationStats,
        AnalyticsBackendTaskCancellationStats stats = new AnalyticsBackendTaskCancellationStats(10, 20, 30, 40);
        builder.startObject();
     * for non-negative values) and these fields represent counters which are always >= 0.
                            + shardTaskTotal
        AnalyticsBackendTaskCancellationStats stats1 = new AnalyticsBackendTaskCancellationStats(1, 2, 3, 4);
                            + searchTaskTotal
 * this file be licensed under the Apache-2.0 license or a
        assertNotEquals(stats1, new AnalyticsBackendTaskCancellationStats(99, 2, 3, 4));
     * Test hashCode: different objects likely have different hash codes.
     */
import org.opensearch.test.OpenSearchTestCase;
            long searchTaskCurrent = randomNonNegativeLong();
     * Validates: Requirement 6.7
                searchTaskTotal,
import org.opensearch.core.xcontent.ToXContent;
            + "\"analytics_search_shard_task\":{\"current_count_post_cancel\":5,\"total_count_post_cancel\":892}}";
    public void testToXContentProducesExpectedJsonStructure() throws IOException {
     * and analytics_search_shard_task sub-objects.
        builder.startObject();
     * Validates: Requirement 6.7
     *
    /**
     * Validates: Requirement 6.7
    /**
     * Validates: Requirement 6.3
    /**
