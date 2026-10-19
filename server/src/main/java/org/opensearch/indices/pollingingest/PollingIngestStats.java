            pointerBasedLag = in.readLong();
 * Stats for pull-based ingestion
        this.messageProcessorStats = new MessageProcessorStats(
         */
        out.writeLong(messageProcessorStats.totalProcessedCount);
import org.opensearch.Version;
     */
            this.pipelineExecutionCount = stats.totalExecutionCount();  
            return this;
            this.totalInvalidMessageCount = totalInvalidMessageCount;
        long totalProcessedCount = in.readLong();
 */
    }
        return builder;  
            out.writeLong(pipelineStats.totalExecutionCount);
                lagInMillis,  
        public Builder setTotalProcessorFailedCount(long totalFailedCount) {
     * @return a new {@code Builder} instance
            this.pipelineStats = new PipelineStats(in.readLong(), in.readLong(), in.readLong(), in.readLong());  
            out.writeLong(pipelineStats.totalFailedCount);
        this(messageProcessorStats, consumerStats, new PipelineStats(0, 0, 0, 0));
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.Writeable;
    public ConsumerStats getConsumerStats() {
     * Stats for pipeline execution in pull-based ingestion.
        }  
     */  
        long totalPollerMessageDroppedCount = in.readLong();
     */  
        builder.field("total_invalid_message_count", messageProcessorStats.totalInvalidMessageCount);
     * Returns a new builder for creating a {@link PollingIngestStats} instance.  
            return this;  
        builder.field("total_poller_message_dropped_count", consumerStats.totalPollerMessageDroppedCount);  
     */  
            );  
        builder.endObject();
        private long pipelineDroppedCount;
        builder.startObject("message_processor_stats");  
            this.totalProcessedCount = totalProcessedCount;  
    }
            return this;
            this.pipelineStats = new PipelineStats(0, 0, 0, 0);
import org.opensearch.core.xcontent.ToXContentFragment;  
    }
    }
    }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    public static class Builder {
    private final MessageProcessorStats messageProcessorStats;
        long totalProcessorFailuresDroppedCount = in.readLong();  
        private long totalProcessedCount;  
        );  
            totalInvalidMessageCount,
            && Objects.equals(consumerStats, that.consumerStats)  
     * Stats for message processor
        builder.field("lag_in_millis", consumerStats.lagInMillis);
        public Builder setTotalProcessorFailuresDroppedCount(long totalFailuresDroppedCount) {  
            return this;  
        long pointerBasedLag = 0;
                pipelineDroppedCount
import org.opensearch.core.common.io.stream.StreamInput;  
        if (out.getVersion().onOrAfter(Version.V_3_4_0)) {  
        }
        );  
        builder.startObject("pipeline_stats");
        private long totalPollerMessageFailureCount;  
        builder.field("total_failures_dropped_count", messageProcessorStats.totalFailuresDroppedCount);
    }
            this.pipelineDroppedCount = stats.totalDroppedCount();  
        long totalProcessorVersionConflictsCount = in.readLong();
        out.writeLong(consumerStats.totalPollerMessageDroppedCount);  
        }
        builder.field("total_polled_count", consumerStats.totalPolledCount);  
            PipelineStats pipelineStats = new PipelineStats(
        public Builder setTotalDuplicateMessageSkippedCount(long totalDuplicateMessageSkippedCount) {
        public PollingIngestStats build() {
            this.totalFailedCount = totalFailedCount;
    }
        private long lagInMillis;
            this.lagInMillis = lagInMillis;
     * totalDuplicateMessageSkippedCount has been deprecated as of version 3.4  and will be removed in a future version.
            totalProcessedCount,  
        out.writeLong(consumerStats.totalPolledCount);
        }  
            out.writeLong(pipelineStats.totalExecutionTimeInMillis);  
    public record PipelineStats(long totalExecutionCount, long totalExecutionTimeInMillis, long totalFailedCount, long totalDroppedCount) {
            return this;  
import java.util.Objects;
        }
        out.writeLong(messageProcessorStats.totalProcessorThreadInterruptCount);
package org.opensearch.indices.pollingingest;
                totalProcessedCount,  
        public Builder setPipelineStats(PipelineStats stats) {
                pipelineExecutionCount,
    @PublicApi(since = "3.6.0")
        }
        }
        long totalFailedCount, long totalFailuresDroppedCount, long totalProcessorThreadInterruptCount) {
        private long totalPollerMessageDroppedCount;
        private long totalPolledCount;
            this.totalDuplicateMessageSkippedCount = totalDuplicateMessageSkippedCount;
         * @deprecated As of 3.4, this field is no longer used and will be removed in a future version.
        }
    /**  
            );  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }  
        }
            return this;  
        out.writeLong(consumerStats.totalConsumerErrorCount);
        if (in.getVersion().onOrAfter(Version.V_3_4_0)) {  
        private long totalInvalidMessageCount;
        this.pipelineStats = pipelineStats;
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
                totalInvalidMessageCount,
            this.totalPolledCount = totalPolledCount;
        long totalPollerMessageFailureCount = in.readLong();
            this.pipelineFailedCount = stats.totalFailedCount();
        builder.field("total_execution_time_in_millis", pipelineStats.totalExecutionTimeInMillis);
    /**  
                totalPollerMessageFailureCount,
        out.writeLong(messageProcessorStats.totalFailuresDroppedCount);  
        long totalInvalidMessageCount = in.readLong();  
        long totalConsumerErrorCount = in.readLong();  
    }
        private long totalConsumerErrorCount;
        PollingIngestStats that = (PollingIngestStats) o;
                totalDuplicateMessageSkippedCount,
            out.writeLong(consumerStats.pointerBasedLag);
    }  
        public Builder setTotalProcessorVersionConflictsCount(long totalVersionConflictsCount) {
        long lagInMillis = in.readLong();
 */  
            return this;
    }
        builder.field("total_processed_count", messageProcessorStats.totalProcessedCount);
    }  
        return pipelineStats;  
        }
            return this;
        public Builder setTotalPollerMessageFailureCount(long totalPollerMessageFailureCount) {
        return new Builder();
    /**
        builder.field("total_processor_thread_interrupt_count", messageProcessorStats.totalProcessorThreadInterruptCount);  
        }  
        out.writeLong(messageProcessorStats.totalFailedCount);
            totalProcessorFailuresDroppedCount,
            totalPolledCount,
        private long totalDuplicateMessageSkippedCount;
            this.totalPollerMessageDroppedCount = totalPollerMessageDroppedCount;
            this.totalFailuresDroppedCount = totalFailuresDroppedCount;
            return new PollingIngestStats(messageProcessorStats, consumerStats, pipelineStats);
    @PublicApi(since = "3.7.0")  
        out.writeLong(consumerStats.totalDuplicateMessageSkippedCount);
        if (!(o instanceof PollingIngestStats)) return false;  
        long totalPollerMessageDroppedCount, long totalDuplicateMessageSkippedCount, long pointerBasedLag) {  
import org.opensearch.common.annotation.PublicApi;
            totalDuplicateMessageSkippedCount,
                pipelineExecutionTimeInMillis,  
        public Builder setLagInMillis(long lagInMillis) {
        long totalProcessorFailedCount = in.readLong();
        builder.startObject("polling_ingest_stats");
    /**
        }
                totalPolledCount,
        return Objects.hash(messageProcessorStats, consumerStats, pipelineStats);  
            totalProcessorThreadInterruptCount
 * compatible open source license.
    }  
    public MessageProcessorStats getMessageProcessorStats() {  
        return consumerStats;
        }
            totalProcessorVersionConflictsCount,
                totalFailedCount,  
        builder.field("total_poller_message_failure_count", consumerStats.totalPollerMessageFailureCount);
            return this;
        builder.field("total_failed_count", pipelineStats.totalFailedCount);
            return this;
        builder.field("total_consumer_error_count", consumerStats.totalConsumerErrorCount);
    private final ConsumerStats consumerStats;  
        private long pipelineExecutionCount;
        }  
            totalPollerMessageFailureCount,
                pipelineFailedCount,
        return messageProcessorStats;
            totalProcessorFailedCount,  
            return this;
            lagInMillis,  
        builder.endObject();
        }
        long totalPolledCount = in.readLong();
        private long totalFailedCount;
}
    public boolean equals(Object o) {
    public int hashCode() {
        private long pointerBasedLag;  
    @PublicApi(since = "3.6.0")
        } else {
        private long totalVersionConflictsCount;  
 * SPDX-License-Identifier: Apache-2.0
        builder.field("pointer_based_lag", consumerStats.pointerBasedLag);  
    public PollingIngestStats(MessageProcessorStats messageProcessorStats, ConsumerStats consumerStats) {  
            ConsumerStats consumerStats = new ConsumerStats(
        public Builder setPointerBasedLag(long pointerBasedLag) {  
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
        if (this == o) return true;
                totalVersionConflictsCount,
    /**
        long totalProcessorThreadInterruptCount = in.readLong();
        builder.field("total_version_conflicts_count", messageProcessorStats.totalVersionConflictsCount);  
import org.opensearch.core.xcontent.XContentBuilder;
public class PollingIngestStats implements Writeable, ToXContentFragment {
        out.writeLong(messageProcessorStats.totalInvalidMessageCount);  
    public PipelineStats getPipelineStats() {
@PublicApi(since = "3.6.0")  
            );  
                totalProcessorThreadInterruptCount
        this.consumerStats = new ConsumerStats(
            totalPollerMessageDroppedCount,  
        builder.startObject("consumer_stats");
            && Objects.equals(pipelineStats, that.pipelineStats);
        builder.endObject();
        out.writeLong(messageProcessorStats.totalVersionConflictsCount);
        public Builder setTotalConsumerErrorCount(long totalConsumerErrorCount) {  
            pointerBasedLag
    @Override  
            return this;
    public PollingIngestStats(MessageProcessorStats messageProcessorStats, ConsumerStats consumerStats, PipelineStats pipelineStats) {
     * Builder for {@link PollingIngestStats}
    @Override  
            MessageProcessorStats messageProcessorStats = new MessageProcessorStats(
     * Stats for consumer (poller).  
    }
            this.pipelineExecutionTimeInMillis = stats.totalExecutionTimeInMillis();
            totalConsumerErrorCount,
        private long pipelineFailedCount;  
                pointerBasedLag
        }
            this.totalConsumerErrorCount = totalConsumerErrorCount;
        this.consumerStats = consumerStats;  
        private long totalProcessorThreadInterruptCount;  
    private final PipelineStats pipelineStats;
    public PollingIngestStats(StreamInput in) throws IOException {
    public record MessageProcessorStats(long totalProcessedCount, long totalInvalidMessageCount, long totalVersionConflictsCount,
import java.io.IOException;  
     *
                totalFailuresDroppedCount,
     *
        this.messageProcessorStats = messageProcessorStats;
        public Builder setTotalProcessedCount(long totalProcessedCount) {
        }
/*  
        out.writeLong(consumerStats.totalPollerMessageFailureCount);
/**  
            this.totalPollerMessageFailureCount = totalPollerMessageFailureCount;  
        return Objects.equals(messageProcessorStats, that.messageProcessorStats)
        private long totalFailuresDroppedCount;
        out.writeLong(consumerStats.lagInMillis);  
        builder.field("total_dropped_count", pipelineStats.totalDroppedCount);  
    public record ConsumerStats(long totalPolledCount, long lagInMillis, long totalConsumerErrorCount, long totalPollerMessageFailureCount,
            out.writeLong(pipelineStats.totalDroppedCount);
        public Builder setTotalInvalidMessageCount(long totalInvalidMessageCount) {  
        builder.field("total_failed_count", messageProcessorStats.totalFailedCount);
            this.totalProcessorThreadInterruptCount = totalProcessorThreadInterruptCount;  
        long totalDuplicateMessageSkippedCount = in.readLong();  
    @Override
            this.pointerBasedLag = pointerBasedLag;
        public Builder setTotalProcessorThreadInterruptCount(long totalProcessorThreadInterruptCount) {
            return this;  
        @Deprecated(since = "3.4", forRemoval = true)  
        builder.endObject();
        }  
        /**  
     */
    @Override  
        public Builder setTotalPollerMessageDroppedCount(long totalPollerMessageDroppedCount) {
        public Builder setTotalPolledCount(long totalPolledCount) {
        }  
        public Builder() {}  
 *
        private long pipelineExecutionTimeInMillis;
    }
                totalConsumerErrorCount,
            return this;
        builder.field("total_duplicate_message_skipped_count", consumerStats.totalDuplicateMessageSkippedCount);
                totalPollerMessageDroppedCount,  
    public void writeTo(StreamOutput out) throws IOException {
    public static Builder builder() {
        builder.field("total_execution_count", pipelineStats.totalExecutionCount);  
    @PublicApi(since = "3.6.0")  
            this.totalVersionConflictsCount = totalVersionConflictsCount;  
