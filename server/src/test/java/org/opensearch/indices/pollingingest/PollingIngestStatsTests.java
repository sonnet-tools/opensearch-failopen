                PollingIngestStats deserialized = new PollingIngestStats(input);
/*  
            try (StreamInput input = output.bytes().streamInput()) {
            + "},\"pipeline_stats\":{\"total_execution_count\":"
                randomNonNegativeLong(),
        }
            + ",\"total_failed_count\":"  
                PollingIngestStats deserialized = new PollingIngestStats(input);
            + ",\"total_poller_message_dropped_count\":"  
            + stats.getConsumerStats().pointerBasedLag()
package org.opensearch.indices.pollingingest;
            + stats.getPipelineStats().totalExecutionTimeInMillis()
        PollingIngestStats original = createTestInstance();
            + ",\"total_duplicate_message_skipped_count\":"
import org.opensearch.core.xcontent.XContentBuilder;  
            + stats.getPipelineStats().totalExecutionCount()  
                randomNonNegativeLong(),
                input.setVersion(Version.V_3_5_0);  
    public void testSerializationToOlderNode() throws IOException {
        String expected = "{\"polling_ingest_stats\":{\"message_processor_stats\":{\"total_processed_count\":"  
            + ",\"pointer_based_lag\":"  
    /**
            ),
        try (BytesStreamOutput output = new BytesStreamOutput()) {
            + stats.getMessageProcessorStats().totalFailuresDroppedCount()  
            + ",\"total_execution_time_in_millis\":"
            }
                assertEquals(0, deserialized.getPipelineStats().totalDroppedCount());
     * Test deserialization from a pre-3.7.0 node — pipeline stats should default to zero.
            + ",\"total_processor_thread_interrupt_count\":"
                randomNonNegativeLong()
            + stats.getMessageProcessorStats().totalVersionConflictsCount()
    }
                randomNonNegativeLong(),
    public void testSerialization() throws IOException {  
            + ",\"total_poller_message_failure_count\":"
            + stats.getMessageProcessorStats().totalProcessedCount()
import org.opensearch.common.io.stream.BytesStreamOutput;
 * SPDX-License-Identifier: Apache-2.0
        PollingIngestStats original = createTestInstance();
                randomNonNegativeLong(),
                assertEquals(original.getMessageProcessorStats(), deserialized.getMessageProcessorStats());
    public void testToXContent() throws IOException {
                randomNonNegativeLong(),  
            + stats.getPipelineStats().totalFailedCount()
                randomNonNegativeLong(),  
     */  
            + stats.getMessageProcessorStats().totalProcessorThreadInterruptCount()
import org.opensearch.core.common.io.stream.StreamInput;  
            + ",\"lag_in_millis\":"
                randomNonNegativeLong(),
import org.opensearch.Version;
    }  
                randomNonNegativeLong(),
            + stats.getMessageProcessorStats().totalFailedCount()
            + "},\"consumer_stats\":{\"total_polled_count\":"  
 *
            new PollingIngestStats.PipelineStats(  
                randomNonNegativeLong()
        return new PollingIngestStats(  
            + ",\"total_version_conflicts_count\":"
            output.setVersion(Version.V_3_6_0);  
                randomNonNegativeLong()
                randomNonNegativeLong(),  
                assertEquals(original.getConsumerStats(), deserialized.getConsumerStats());
            + stats.getConsumerStats().totalConsumerErrorCount()  
            output.setVersion(Version.V_3_5_0);
                // Message processor and consumer stats should match  
public class PollingIngestStatsTests extends OpenSearchTestCase {
            + stats.getConsumerStats().totalDuplicateMessageSkippedCount()  
            ),
            new PollingIngestStats.MessageProcessorStats(
            + ",\"total_consumer_error_count\":"
                randomNonNegativeLong(),
            + stats.getConsumerStats().lagInMillis()
    /**
                assertEquals(original, deserialized);
            try (StreamInput input = output.bytes().streamInput()) {
            + stats.getConsumerStats().totalPolledCount()
    }
                randomNonNegativeLong(),  
    public void testDeserializationFromOlderNode() throws IOException {
                randomNonNegativeLong(),
                assertEquals(original.getMessageProcessorStats(), deserialized.getMessageProcessorStats());
 * The OpenSearch Contributors require contributions made to  
                randomNonNegativeLong(),
    }
            // Read back as a 3.6.0 node  
 * this file be licensed under the Apache-2.0 license or a
            + stats.getConsumerStats().totalPollerMessageDroppedCount()
            try (StreamInput input = output.bytes().streamInput()) {  
        }
        builder.startObject();
     */  
                input.setVersion(Version.V_3_6_0);
            + ",\"total_failures_dropped_count\":"
 * compatible open source license.
        );  
    }
        // Simulate a pre-3.6.0 node writing stats without pipeline fields
                randomNonNegativeLong(),  
            )
            }  
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        builder.endObject();
            + stats.getConsumerStats().totalPollerMessageFailureCount()
}
                PollingIngestStats deserialized = new PollingIngestStats(input);  
            + stats.getMessageProcessorStats().totalInvalidMessageCount()  
import org.opensearch.core.xcontent.ToXContent;
        try (BytesStreamOutput output = new BytesStreamOutput()) {  
        PollingIngestStats original = createTestInstance();  
                assertEquals(0, deserialized.getPipelineStats().totalExecutionCount());
                assertEquals(0, deserialized.getPipelineStats().totalExecutionCount());  
                // Pipeline stats should be zeroed out (not serialized to older nodes)
            original.writeTo(output);
        }
            + stats.getPipelineStats().totalDroppedCount()  
        assertEquals(expected, builder.toString());  
            + ",\"total_invalid_message_count\":"
            + "}}}";
                assertEquals(0, deserialized.getPipelineStats().totalExecutionTimeInMillis());  
        PollingIngestStats stats = createTestInstance();
import java.io.IOException;  
    private PollingIngestStats createTestInstance() {
import org.opensearch.test.OpenSearchTestCase;
            + ",\"total_dropped_count\":"
 */  
     * Test serialization to a pre-3.7.0 node — pipeline stats should be omitted.
            }  
            original.writeTo(output);
            new PollingIngestStats.ConsumerStats(  
            original.writeTo(output);  
                assertEquals(0, deserialized.getPipelineStats().totalFailedCount());
import org.opensearch.core.xcontent.MediaTypeRegistry;
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        try (BytesStreamOutput output = new BytesStreamOutput()) {
            + ",\"total_failed_count\":"  
