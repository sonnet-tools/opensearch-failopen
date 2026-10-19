        assertTrue("JSON should contain search_task", json.contains("\"search_task\""));
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertTrue("JSON should contain analytics_search_task", json.contains("\"analytics_search_task\""));  
    /**  
    protected Writeable.Reader<TaskCancellationStats> instanceReader() {
        return TaskCancellationStats::new;
public class TaskCancellationStatsTests extends AbstractWireSerializingTestCase<TaskCancellationStats> {
        builder.startObject();
     * deserialize, verify nativeStats is null.
            original.writeTo(out);  
            assertEquals("Round-trip without native stats failed for instance " + i, original, deserialized);  
        String json = BytesReference.bytes(builder).utf8ToString();
        // Verify search_task is present
            out.setVersion(Version.V_3_7_0);
 */  
    }
    @Override
     */
            );
    // -----------------------------------------------------------------------
    /**
        builder.startObject();
import org.opensearch.test.AbstractWireSerializingTestCase;
            randomNonNegativeLong(),
import java.io.IOException;  
     * Validates: Requirements 9.2  
     */
        builder.endObject();  
            TaskCancellationStats original = new TaskCancellationStats(
        assertTrue("JSON should contain analytics_search_shard_task", json.contains("\"analytics_search_shard_task\""));
        TaskCancellationStats original = new TaskCancellationStats(searchStats, shardStats, nativeStats);
        );  
     * Test serialization backward compatibility: serialize with version before V_3_7_0,
import org.opensearch.core.common.io.stream.Writeable;
            TaskCancellationStats deserialized = new TaskCancellationStats(in);
    public void testSerializationBackwardCompatibility() throws IOException {  
        );  
     */
    }
        // Native stats should be null after round-trip through older version
     *
        TaskCancellationStats deserialized = new TaskCancellationStats(in);  
}
     *  
        assertFalse("JSON should NOT contain analytics_search_shard_task", json.contains("\"analytics_search_shard_task\""));  
     * Test toXContent without native stats produces unchanged output (no native fields).
        assertTrue("JSON should contain native shard task total count", json.contains("\"total_count_post_cancel\":892"));
        // Verify search_shard_task is present  
        AnalyticsBackendTaskCancellationStats nativeStats = new AnalyticsBackendTaskCancellationStats(2, 147, 5, 892);  
        assertTrue("JSON should contain search_shard_task", json.contains("\"search_shard_task\""));  
        assertEquals(shardStats, deserialized.getSearchShardTaskCancellationStats());  
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;  
        // Verify analytics_search_shard_task is present
     *
                SearchShardTaskCancellationStatsTests.randomInstance(),
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);  
    // Validates: Requirements 9.4, 9.5, 9.6
        out.setVersion(Version.V_3_6_0);  
        assertEquals(searchStats, deserialized.getSearchTaskCancellationStats());
 * compatible open source license.
     * Property test: For any valid TaskCancellationStats instance (with native stats),  
        return new AnalyticsBackendTaskCancellationStats(
        return randomInstance();
     *  
                    randomNonNegativeLong()  
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);  
        // Verify analytics_search_task is present
        SearchTaskCancellationStats searchStats = new SearchTaskCancellationStats(3, 10);
    // -----------------------------------------------------------------------  
        BytesStreamOutput out = new BytesStreamOutput();
        }
        assertTrue("JSON should contain search_task", json.contains("\"search_task\""));
    // Property 5: TaskCancellationStats round-trip (with and without native stats)
        for (int i = 0; i < 100; i++) {
import org.opensearch.core.common.io.stream.StreamInput;
     * produces an equal instance.
     */
    private static AnalyticsBackendTaskCancellationStats randomNativeStats() {  
        for (int i = 0; i < 100; i++) {  
 * this file be licensed under the Apache-2.0 license or a
        // Verify native fields are NOT present
    // Validates: Requirements 9.2, 9.3, 9.4, 9.5  
            TaskCancellationStats original = new TaskCancellationStats(
            SearchTaskCancellationStatsTests.randomInstance(),  
        SearchShardTaskCancellationStats shardStats = new SearchShardTaskCancellationStats(5, 20);
        // Verify native counter values  
                SearchTaskCancellationStatsTests.randomInstance(),  
package org.opensearch.tasks;
    }
            StreamInput in = out.bytes().streamInput();
        String json = BytesReference.bytes(builder).utf8ToString();
                    randomNonNegativeLong(),
            BytesStreamOutput out = new BytesStreamOutput();
     * serializing via writeTo and deserializing via the StreamInput constructor  
                )
    }
            assertEquals("Round-trip with native stats failed for instance " + i, original, deserialized);  
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
 *
                new AnalyticsBackendTaskCancellationStats(
    /**
                    randomNonNegativeLong(),  
            randomNonNegativeLong(),
    public void testRoundTripPropertyWithNativeStats() throws IOException {  
        SearchTaskCancellationStats searchStats = new SearchTaskCancellationStats(3, 10);
import org.opensearch.core.common.bytes.BytesReference;  
            out.setVersion(Version.V_3_7_0);
            randomNonNegativeLong(),  
            );
    }
        assertTrue("JSON should contain search_shard_task", json.contains("\"search_shard_task\""));
        // But the other stats should still be correct
        SearchTaskCancellationStats searchStats = new SearchTaskCancellationStats(3, 10);  
     * Property test: For any valid TaskCancellationStats instance (without native stats),
     * Test toXContent with native stats renders analytics_search_task and analytics_search_shard_task.
 * The OpenSearch Contributors require contributions made to  
            SearchShardTaskCancellationStatsTests.randomInstance(),
            randomBoolean() ? randomNativeStats() : null
     *  
        // Serialize with a version before V_3_7_0 (native stats should be omitted)
        TaskCancellationStats stats = new TaskCancellationStats(searchStats, shardStats, nativeStats);
        return new TaskCancellationStats(
        assertTrue("JSON should contain native search task total count", json.contains("\"total_count_post_cancel\":147"));
/*  
import org.opensearch.Version;
        AnalyticsBackendTaskCancellationStats nativeStats = new AnalyticsBackendTaskCancellationStats(2, 147, 5, 892);
    }
        SearchShardTaskCancellationStats shardStats = new SearchShardTaskCancellationStats(5, 20);
        // Deserialize with the same older version  
        assertFalse("JSON should NOT contain analytics_search_task", json.contains("\"analytics_search_task\""));
        in.setVersion(Version.V_3_6_0);
                    randomNonNegativeLong(),
     */
    // Unit tests for extended TaskCancellationStats
            original.writeTo(out);  
    /**  
    public static TaskCancellationStats randomInstance() {
    /**
        original.writeTo(out);
    protected TaskCancellationStats createTestInstance() {  
            BytesStreamOutput out = new BytesStreamOutput();
    // -----------------------------------------------------------------------
                null
     * serializing via writeTo and deserializing via the StreamInput constructor
            in.setVersion(Version.V_3_7_0);  
    public void testToXContentWithNativeStats() throws IOException {
     * Validates: Requirements 9.4, 9.5
        }
        assertTrue("JSON should contain native search task current count", json.contains("\"current_count_post_cancel\":2"));
        // Verify search_task and search_shard_task are present
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    }
    public void testRoundTripPropertyWithoutNativeStats() throws IOException {
                SearchShardTaskCancellationStatsTests.randomInstance(),  
    public void testToXContentWithoutNativeStats() throws IOException {  
        assertNull("Native stats should be null when deserialized from older version", deserialized.getNativeStats());  
            TaskCancellationStats deserialized = new TaskCancellationStats(in);
        TaskCancellationStats stats = new TaskCancellationStats(searchStats, shardStats);
        StreamInput in = out.bytes().streamInput();
                SearchTaskCancellationStatsTests.randomInstance(),
    }
        assertTrue("JSON should contain native shard task current count", json.contains("\"current_count_post_cancel\":5"));  
            in.setVersion(Version.V_3_7_0);  
import org.opensearch.core.xcontent.XContentBuilder;
     * produces an equal instance.
     * Validates: Requirements 9.3
     * **Validates: Requirements 9.4, 9.5, 9.6**  
    // -----------------------------------------------------------------------  
            StreamInput in = out.bytes().streamInput();
import org.opensearch.core.xcontent.ToXContent;
 * SPDX-License-Identifier: Apache-2.0
        builder.endObject();  
        SearchShardTaskCancellationStats shardStats = new SearchShardTaskCancellationStats(5, 20);
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
    @Override  
            randomNonNegativeLong()
    }  
     * **Validates: Requirements 9.4, 9.5, 9.6**
