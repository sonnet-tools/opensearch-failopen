        return consumerStats;
            return this;
        }
     * Builder for {@link PollingIngestStats}
     *
            this.totalDuplicateMessageSkippedCount = totalDuplicateMessageSkippedCount;
            this.pointerBasedLag = pointerBasedLag;
        this.consumerStats = new ConsumerStats(
        private long totalProcessedCount;
    }
            this.totalInvalidMessageCount = totalInvalidMessageCount;
        private long totalConsumerErrorCount;
            totalPollerMessageFailureCount,
     *
                pipelineFailedCount,
        }
        long totalFailedCount, long totalFailuresDroppedCount, long totalProcessorThreadInterruptCount) {
            this.totalProcessedCount = totalProcessedCount;
        builder.field("total_poller_message_dropped_count", consumerStats.totalPollerMessageDroppedCount);
            return this;
        builder.field("total_version_conflicts_count", messageProcessorStats.totalVersionConflictsCount);
     * Stats for message processor
    @PublicApi(since = "3.6.0")
        return Objects.hash(messageProcessorStats, consumerStats, pipelineStats);
        builder.field("total_poller_message_failure_count", consumerStats.totalPollerMessageFailureCount);
        builder.field("total_failed_count", messageProcessorStats.totalFailedCount);
     * @return a new {@code Builder} instance
                lagInMillis,
        } else {
        /**
            this.pipelineFailedCount = stats.totalFailedCount();
                pointerBasedLag
        private long lagInMillis;
        if (this == o) return true;
        }
                totalPollerMessageFailureCount,
        public Builder() {}
public class PollingIngestStats implements Writeable, ToXContentFragment {
        public Builder setTotalConsumerErrorCount(long totalConsumerErrorCount) {
    public static class Builder {
@PublicApi(since = "3.6.0")
        this.pipelineStats = pipelineStats;
            this.totalConsumerErrorCount = totalConsumerErrorCount;
            PipelineStats pipelineStats = new PipelineStats(
    }
        private long totalPollerMessageDroppedCount;
            );
    }
        private long totalFailedCount;
        long totalProcessedCount = in.readLong();
        public Builder setTotalProcessorFailuresDroppedCount(long totalFailuresDroppedCount) {
    @Override
        this(messageProcessorStats, consumerStats, new PipelineStats(0, 0, 0, 0));
            return this;
        public Builder setTotalProcessorVersionConflictsCount(long totalVersionConflictsCount) {
        builder.startObject("pipeline_stats");
            this.pipelineDroppedCount = stats.totalDroppedCount();
                pipelineExecutionTimeInMillis,
            out.writeLong(pipelineStats.totalExecutionCount);
        builder.startObject("message_processor_stats");
/*
            this.totalFailedCount = totalFailedCount;
        out.writeLong(messageProcessorStats.totalProcessedCount);
        long totalDuplicateMessageSkippedCount = in.readLong();
        builder.endObject();
            totalInvalidMessageCount,
    }
 */
    private final ConsumerStats consumerStats;
    public record PipelineStats(long totalExecutionCount, long totalExecutionTimeInMillis, long totalFailedCount, long totalDroppedCount) {
        }
                totalInvalidMessageCount,
            return this;
     * Returns a new builder for creating a {@link PollingIngestStats} instance.
    @PublicApi(since = "3.6.0")
        builder.field("total_duplicate_message_skipped_count", consumerStats.totalDuplicateMessageSkippedCount);
            this.totalVersionConflictsCount = totalVersionConflictsCount;
import org.opensearch.core.common.io.stream.Writeable;
        public Builder setTotalPollerMessageDroppedCount(long totalPollerMessageDroppedCount) {
    public PollingIngestStats(MessageProcessorStats messageProcessorStats, ConsumerStats consumerStats) {
        public Builder setTotalPolledCount(long totalPolledCount) {
            this.pipelineStats = new PipelineStats(0, 0, 0, 0);
        @Deprecated(since = "3.4", forRemoval = true)
 * Stats for pull-based ingestion
        public Builder setTotalProcessorFailedCount(long totalFailedCount) {
     */
            totalProcessorThreadInterruptCount
            out.writeLong(pipelineStats.totalExecutionTimeInMillis);
    }
            MessageProcessorStats messageProcessorStats = new MessageProcessorStats(
        }
            this.pipelineExecutionCount = stats.totalExecutionCount();
        }
        PollingIngestStats that = (PollingIngestStats) o;
            return this;
        out.writeLong(consumerStats.totalConsumerErrorCount);
        private long pipelineDroppedCount;
                totalPolledCount,
 * The OpenSearch Contributors require contributions made to
        out.writeLong(messageProcessorStats.totalInvalidMessageCount);
            totalConsumerErrorCount,
        out.writeLong(messageProcessorStats.totalFailuresDroppedCount);
        out.writeLong(consumerStats.lagInMillis);
    }
        long lagInMillis = in.readLong();
    public PipelineStats getPipelineStats() {
            out.writeLong(consumerStats.pointerBasedLag);
        }
        private long totalProcessorThreadInterruptCount;
import org.opensearch.common.annotation.PublicApi;
         */
     * Stats for pipeline execution in pull-based ingestion.
            return this;
        }
 * this file be licensed under the Apache-2.0 license or a
        return new Builder();
import java.io.IOException;
            return this;
        private long totalVersionConflictsCount;
        builder.field("total_execution_count", pipelineStats.totalExecutionCount);
            );
 *
            this.pipelineExecutionTimeInMillis = stats.totalExecutionTimeInMillis();
        }
            pointerBasedLag
            totalProcessorFailuresDroppedCount,
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.Version;
        long totalProcessorFailuresDroppedCount = in.readLong();
    }
            totalProcessedCount,
        long totalConsumerErrorCount = in.readLong();
        out.writeLong(consumerStats.totalPollerMessageDroppedCount);
        }
        public Builder setPipelineStats(PipelineStats stats) {
        out.writeLong(messageProcessorStats.totalVersionConflictsCount);
        long totalInvalidMessageCount = in.readLong();
        long totalPollerMessageFailureCount = in.readLong();
    }
                pipelineExecutionCount,
        if (in.getVersion().onOrAfter(Version.V_3_4_0)) {
        public Builder setTotalPollerMessageFailureCount(long totalPollerMessageFailureCount) {
        builder.endObject();
        private long totalFailuresDroppedCount;
        public Builder setPointerBasedLag(long pointerBasedLag) {
            totalDuplicateMessageSkippedCount,
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private long totalPollerMessageFailureCount;
 */
    private final PipelineStats pipelineStats;
        builder.endObject();
        return builder;
    public boolean equals(Object o) {
        builder.field("total_consumer_error_count", consumerStats.totalConsumerErrorCount);
            return this;
    public PollingIngestStats(MessageProcessorStats messageProcessorStats, ConsumerStats consumerStats, PipelineStats pipelineStats) {
        private long totalInvalidMessageCount;
     */
        this.messageProcessorStats = new MessageProcessorStats(
        builder.field("total_polled_count", consumerStats.totalPolledCount);
            this.totalFailuresDroppedCount = totalFailuresDroppedCount;
    public ConsumerStats getConsumerStats() {
}
            && Objects.equals(pipelineStats, that.pipelineStats);
    }
     */
    @Override
    }
    @PublicApi(since = "3.6.0")
    /**
        return messageProcessorStats;
            return this;
            && Objects.equals(consumerStats, that.consumerStats)
    public static Builder builder() {
        out.writeLong(messageProcessorStats.totalProcessorThreadInterruptCount);
            return this;
import org.opensearch.core.xcontent.ToXContentFragment;
 * SPDX-License-Identifier: Apache-2.0
                pipelineDroppedCount
            out.writeLong(pipelineStats.totalDroppedCount);
    public record ConsumerStats(long totalPolledCount, long lagInMillis, long totalConsumerErrorCount, long totalPollerMessageFailureCount,
            ConsumerStats consumerStats = new ConsumerStats(
        builder.field("pointer_based_lag", consumerStats.pointerBasedLag);
        public Builder setLagInMillis(long lagInMillis) {
    public void writeTo(StreamOutput out) throws IOException {
/**
     */
        out.writeLong(consumerStats.totalDuplicateMessageSkippedCount);
    /**
        long totalProcessorFailedCount = in.readLong();
        if (!(o instanceof PollingIngestStats)) return false;
        public Builder setTotalInvalidMessageCount(long totalInvalidMessageCount) {
        long pointerBasedLag = 0;
    public PollingIngestStats(StreamInput in) throws IOException {
    @Override
        private long pipelineFailedCount;
import org.opensearch.core.xcontent.XContentBuilder;
            pointerBasedLag = in.readLong();
        }
        builder.field("total_invalid_message_count", messageProcessorStats.totalInvalidMessageCount);
        return pipelineStats;
            lagInMillis,
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
                totalVersionConflictsCount,
        );
            totalProcessorFailedCount,
                totalPollerMessageDroppedCount,
        }
package org.opensearch.indices.pollingingest;
            return this;
import org.opensearch.core.common.io.stream.StreamOutput;
            return this;
    /**
 * compatible open source license.
    }
        private long pipelineExecutionCount;
        long totalProcessorVersionConflictsCount = in.readLong();
        if (out.getVersion().onOrAfter(Version.V_3_4_0)) {
        }
            this.totalPollerMessageDroppedCount = totalPollerMessageDroppedCount;
            totalPollerMessageDroppedCount,
        long totalPolledCount = in.readLong();
        builder.field("lag_in_millis", consumerStats.lagInMillis);
        long totalPollerMessageDroppedCount = in.readLong();
            totalPolledCount,
        this.messageProcessorStats = messageProcessorStats;
        builder.field("total_execution_time_in_millis", pipelineStats.totalExecutionTimeInMillis);
        private long totalPolledCount;
        }
                totalProcessorThreadInterruptCount
        public Builder setTotalProcessedCount(long totalProcessedCount) {
    }
         * @deprecated As of 3.4, this field is no longer used and will be removed in a future version.
                totalDuplicateMessageSkippedCount,
        private long pipelineExecutionTimeInMillis;
     * Stats for consumer (poller).
        public Builder setTotalProcessorThreadInterruptCount(long totalProcessorThreadInterruptCount) {
        public Builder setTotalDuplicateMessageSkippedCount(long totalDuplicateMessageSkippedCount) {
    /**
        out.writeLong(messageProcessorStats.totalFailedCount);
        }
        builder.field("total_failures_dropped_count", messageProcessorStats.totalFailuresDroppedCount);
            this.totalPollerMessageFailureCount = totalPollerMessageFailureCount;
    public record MessageProcessorStats(long totalProcessedCount, long totalInvalidMessageCount, long totalVersionConflictsCount,
    @Override
            this.totalPolledCount = totalPolledCount;
            totalProcessorVersionConflictsCount,
    public MessageProcessorStats getMessageProcessorStats() {
        private long pointerBasedLag;
        public PollingIngestStats build() {
        out.writeLong(consumerStats.totalPolledCount);
    }
        builder.endObject();
    public int hashCode() {
            out.writeLong(pipelineStats.totalFailedCount);
        this.consumerStats = consumerStats;
        long totalPollerMessageDroppedCount, long totalDuplicateMessageSkippedCount, long pointerBasedLag) {
                totalProcessedCount,
                totalFailedCount,
        out.writeLong(consumerStats.totalPollerMessageFailureCount);
        builder.field("total_dropped_count", pipelineStats.totalDroppedCount);
    /**
import java.util.Objects;
            return this;
    }
        builder.field("total_processed_count", messageProcessorStats.totalProcessedCount);
    }
            this.lagInMillis = lagInMillis;
        long totalProcessorThreadInterruptCount = in.readLong();
                totalConsumerErrorCount,
            this.pipelineStats = new PipelineStats(in.readLong(), in.readLong(), in.readLong(), in.readLong());
        return Objects.equals(messageProcessorStats, that.messageProcessorStats)
        builder.startObject("polling_ingest_stats");
    @PublicApi(since = "3.7.0")
        private long totalDuplicateMessageSkippedCount;
        builder.field("total_failed_count", pipelineStats.totalFailedCount);
            );
        );
        }
            return this;
    private final MessageProcessorStats messageProcessorStats;
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
            this.totalProcessorThreadInterruptCount = totalProcessorThreadInterruptCount;
        builder.startObject("consumer_stats");
        }
        }
        builder.field("total_processor_thread_interrupt_count", messageProcessorStats.totalProcessorThreadInterruptCount);
                totalFailuresDroppedCount,
     */
        }
     * totalDuplicateMessageSkippedCount has been deprecated as of version 3.4  and will be removed in a future version.
            return new PollingIngestStats(messageProcessorStats, consumerStats, pipelineStats);
