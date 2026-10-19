        SearchShardTaskCancellationStats shardStats = new SearchShardTaskCancellationStats(5, 20);
     */
     *
        assertTrue("JSON should contain analytics_search_task", json.contains("\"analytics_search_task\""));
    // Unit tests for extended TaskCancellationStats
 * this file be licensed under the Apache-2.0 license or a
        // Verify native counter values
            assertEquals("Round-trip without native stats failed for instance " + i, original, deserialized);
    /**
    public void testToXContentWithoutNativeStats() throws IOException {
            in.setVersion(Version.V_3_7_0);
        assertFalse("JSON should NOT contain analytics_search_task", json.contains("\"analytics_search_task\""));
    /**
        assertTrue("JSON should contain native search task current count", json.contains("\"current_count_post_cancel\":2"));
        assertEquals(searchStats, deserialized.getSearchTaskCancellationStats());
    public void testSerializationBackwardCompatibility() throws IOException {
     * Validates: Requirements 9.3
        return randomInstance();
        // Verify search_task and search_shard_task are present
 *
        SearchShardTaskCancellationStats shardStats = new SearchShardTaskCancellationStats(5, 20);
            original.writeTo(out);
                null
                )
        assertTrue("JSON should contain search_task", json.contains("\"search_task\""));
     * Property test: For any valid TaskCancellationStats instance (without native stats),
    /**
        assertTrue("JSON should contain search_shard_task", json.contains("\"search_shard_task\""));
        TaskCancellationStats stats = new TaskCancellationStats(searchStats, shardStats, nativeStats);
        builder.endObject();
    private static AnalyticsBackendTaskCancellationStats randomNativeStats() {
     * Test toXContent without native stats produces unchanged output (no native fields).
        // Verify native fields are NOT present
            randomNonNegativeLong(),
 */
            TaskCancellationStats original = new TaskCancellationStats(
     * Test serialization backward compatibility: serialize with version before V_3_7_0,
    public void testRoundTripPropertyWithNativeStats() throws IOException {
        return TaskCancellationStats::new;
        SearchTaskCancellationStats searchStats = new SearchTaskCancellationStats(3, 10);
        assertEquals(shardStats, deserialized.getSearchShardTaskCancellationStats());
        String json = BytesReference.bytes(builder).utf8ToString();
        assertTrue("JSON should contain search_shard_task", json.contains("\"search_shard_task\""));
public class TaskCancellationStatsTests extends AbstractWireSerializingTestCase<TaskCancellationStats> {
     * Property test: For any valid TaskCancellationStats instance (with native stats),
        original.writeTo(out);
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        builder.endObject();
     */
    // Validates: Requirements 9.2, 9.3, 9.4, 9.5
    }
    // -----------------------------------------------------------------------
        assertTrue("JSON should contain native search task total count", json.contains("\"total_count_post_cancel\":147"));
            assertEquals("Round-trip with native stats failed for instance " + i, original, deserialized);
        assertFalse("JSON should NOT contain analytics_search_shard_task", json.contains("\"analytics_search_shard_task\""));
package org.opensearch.tasks;
        builder.startObject();
        );
            randomBoolean() ? randomNativeStats() : null
        String json = BytesReference.bytes(builder).utf8ToString();
import org.opensearch.core.common.io.stream.Writeable;
    }
    }
        return new AnalyticsBackendTaskCancellationStats(
     * produces an equal instance.
        for (int i = 0; i < 100; i++) {
        builder.startObject();
            randomNonNegativeLong(),
    }
 * SPDX-License-Identifier: Apache-2.0
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    public void testToXContentWithNativeStats() throws IOException {
    // -----------------------------------------------------------------------
            TaskCancellationStats deserialized = new TaskCancellationStats(in);
            original.writeTo(out);
 * compatible open source license.
            TaskCancellationStats deserialized = new TaskCancellationStats(in);
     *
    // Property 5: TaskCancellationStats round-trip (with and without native stats)
                new AnalyticsBackendTaskCancellationStats(
        // Serialize with a version before V_3_7_0 (native stats should be omitted)
        // Verify analytics_search_task is present
        return new TaskCancellationStats(
    // -----------------------------------------------------------------------
        // Native stats should be null after round-trip through older version
            out.setVersion(Version.V_3_7_0);
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
    }
    protected TaskCancellationStats createTestInstance() {
                SearchTaskCancellationStatsTests.randomInstance(),
    }
                    randomNonNegativeLong(),
import org.opensearch.Version;
    @Override
     * **Validates: Requirements 9.4, 9.5, 9.6**
 * The OpenSearch Contributors require contributions made to
        SearchTaskCancellationStats searchStats = new SearchTaskCancellationStats(3, 10);
                    randomNonNegativeLong()
import org.opensearch.test.AbstractWireSerializingTestCase;
        // Verify analytics_search_shard_task is present
    }
     * serializing via writeTo and deserializing via the StreamInput constructor
     * **Validates: Requirements 9.4, 9.5, 9.6**
import org.opensearch.core.common.io.stream.StreamInput;
        }
        TaskCancellationStats deserialized = new TaskCancellationStats(in);
     * produces an equal instance.
                SearchShardTaskCancellationStatsTests.randomInstance(),
            randomNonNegativeLong(),
import org.opensearch.core.xcontent.MediaTypeRegistry;
     */
     * Validates: Requirements 9.4, 9.5
        // Deserialize with the same older version
import org.opensearch.common.io.stream.BytesStreamOutput;
        out.setVersion(Version.V_3_6_0);
        BytesStreamOutput out = new BytesStreamOutput();
        );
import java.io.IOException;
import org.opensearch.core.common.bytes.BytesReference;
    }
        }
        TaskCancellationStats stats = new TaskCancellationStats(searchStats, shardStats);
            SearchShardTaskCancellationStatsTests.randomInstance(),
     */
        SearchShardTaskCancellationStats shardStats = new SearchShardTaskCancellationStats(5, 20);
        assertTrue("JSON should contain analytics_search_shard_task", json.contains("\"analytics_search_shard_task\""));
        assertTrue("JSON should contain native shard task total count", json.contains("\"total_count_post_cancel\":892"));
            BytesStreamOutput out = new BytesStreamOutput();
        for (int i = 0; i < 100; i++) {
        assertNull("Native stats should be null when deserialized from older version", deserialized.getNativeStats());
    // -----------------------------------------------------------------------
        // Verify search_task is present
    protected Writeable.Reader<TaskCancellationStats> instanceReader() {
                    randomNonNegativeLong(),
        AnalyticsBackendTaskCancellationStats nativeStats = new AnalyticsBackendTaskCancellationStats(2, 147, 5, 892);
            TaskCancellationStats original = new TaskCancellationStats(
        TaskCancellationStats original = new TaskCancellationStats(searchStats, shardStats, nativeStats);
    public void testRoundTripPropertyWithoutNativeStats() throws IOException {
        in.setVersion(Version.V_3_6_0);
     *
            );
            randomNonNegativeLong()
        // Verify search_shard_task is present
     * Validates: Requirements 9.2
     * deserialize, verify nativeStats is null.
     * Test toXContent with native stats renders analytics_search_task and analytics_search_shard_task.
     */
            StreamInput in = out.bytes().streamInput();
     * serializing via writeTo and deserializing via the StreamInput constructor
        SearchTaskCancellationStats searchStats = new SearchTaskCancellationStats(3, 10);
        // But the other stats should still be correct
    /**
        assertTrue("JSON should contain native shard task current count", json.contains("\"current_count_post_cancel\":5"));
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
    }
     *
     *
            in.setVersion(Version.V_3_7_0);
/*
        AnalyticsBackendTaskCancellationStats nativeStats = new AnalyticsBackendTaskCancellationStats(2, 147, 5, 892);
            StreamInput in = out.bytes().streamInput();
            out.setVersion(Version.V_3_7_0);
    public static TaskCancellationStats randomInstance() {
                SearchShardTaskCancellationStatsTests.randomInstance(),
import org.opensearch.core.xcontent.ToXContent;
                    randomNonNegativeLong(),
            BytesStreamOutput out = new BytesStreamOutput();
        assertTrue("JSON should contain search_task", json.contains("\"search_task\""));
            );
        StreamInput in = out.bytes().streamInput();
            SearchTaskCancellationStatsTests.randomInstance(),
}
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
    // Validates: Requirements 9.4, 9.5, 9.6
    /**
                SearchTaskCancellationStatsTests.randomInstance(),
