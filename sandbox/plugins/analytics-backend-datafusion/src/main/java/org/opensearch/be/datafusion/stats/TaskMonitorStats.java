 * Three duration fields plus instrumented/dropped counts that enable computing alive task count client-side.
    /**
    /** Total time tasks spent idle between polls, in milliseconds. */  
        long instrumentedCount,
        return Objects.hash(totalPollDurationMs, totalScheduledDurationMs, totalIdleDurationMs, instrumentedCount, droppedCount);  
            && totalScheduledDurationMs == that.totalScheduledDurationMs
    public final long droppedCount;
 * this file be licensed under the Apache-2.0 license or a
        this.totalIdleDurationMs = in.readVLong();  
        builder.field("dropped_count", droppedCount);
        builder.field("total_scheduled_duration_ms", totalScheduledDurationMs);
    /**
    }  
/*  
     */
    /**  
     * Render all 5 fields as snake_case JSON fields.  
     */  
    }
 *
        long droppedCount  
    @Override
    ) {
    }
/**  
        if (o == null || getClass() != o.getClass()) return false;
public class TaskMonitorStats implements Writeable {
    @Override
        this.totalIdleDurationMs = totalIdleDurationMs;
 */  
     * @param totalScheduledDurationMs total scheduled duration in milliseconds
     * @throws IOException if deserialization fails
     * @param builder the XContent builder to write to
        this.droppedCount = droppedCount;  
    @Override
        long totalIdleDurationMs,
import java.util.Objects;
    /** Cumulative number of tasks instrumented by this monitor. */
        TaskMonitorStats that = (TaskMonitorStats) o;
            && droppedCount == that.droppedCount;
     * @param totalPollDurationMs      total poll duration in milliseconds
        out.writeVLong(totalPollDurationMs);
    public final long totalScheduledDurationMs;
     *
    public void toXContent(XContentBuilder builder) throws IOException {
     * Deserialize from stream.
 * SPDX-License-Identifier: Apache-2.0
        out.writeVLong(instrumentedCount);
    public void writeTo(StreamOutput out) throws IOException {  
        this.droppedCount = in.readVLong();
        out.writeVLong(totalIdleDurationMs);  
     * @param in the stream input  
    /** Total time spent polling instrumented futures, in milliseconds. */
 * 5 fields per operation type from {@code tokio_metrics::TaskMonitor::cumulative()}.
 */  
 * compatible open source license.
    public final long instrumentedCount;  
        builder.field("instrumented_count", instrumentedCount);  
    public TaskMonitorStats(StreamInput in) throws IOException {  
    public final long totalIdleDurationMs;
     * @param instrumentedCount        cumulative instrumented task count
     * @param totalIdleDurationMs      total idle duration in milliseconds  
        this.totalScheduledDurationMs = in.readVLong();
    }  
        this.instrumentedCount = instrumentedCount;
        long totalScheduledDurationMs,  
    }
            && totalIdleDurationMs == that.totalIdleDurationMs
        out.writeVLong(droppedCount);
}
    /** Total time tasks spent waiting in the scheduler queue, in milliseconds. */
        return totalPollDurationMs == that.totalPollDurationMs  
        this.totalScheduledDurationMs = totalScheduledDurationMs;  
    public boolean equals(Object o) {
        builder.field("total_poll_duration_ms", totalPollDurationMs);  
        this.totalPollDurationMs = in.readVLong();
        this.instrumentedCount = in.readVLong();
    public TaskMonitorStats(
     *  
package org.opensearch.be.datafusion.stats;
     * Construct from explicit field values.
import org.opensearch.core.common.io.stream.Writeable;  
            && instrumentedCount == that.instrumentedCount  
        long totalPollDurationMs,
    public int hashCode() {
    /** Cumulative number of instrumented tasks that have been dropped (completed). */
    public final long totalPollDurationMs;  
     * @throws IOException if writing fails  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;
        if (this == o) return true;  
     * @param droppedCount             cumulative dropped (completed) task count
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        out.writeVLong(totalScheduledDurationMs);
        this.totalPollDurationMs = totalPollDurationMs;
        builder.field("total_idle_duration_ms", totalIdleDurationMs);
import org.opensearch.core.xcontent.XContentBuilder;
     */
import java.io.IOException;  
     *
