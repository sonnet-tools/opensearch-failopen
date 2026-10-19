}
        out.writeString(name);  
 * The OpenSearch Contributors require contributions made to  
        out.writeVLong(pendingAcquirePermits);
        builder.field("active_permits", activePermits);  
 *  
    ) {
 */
    }  
     * @param targetMaxPermits      target max permits during resize
     * @param name                  JSON key for this gate (e.g. "fragment_executor_gate")
        return builder;
import java.util.Objects;
        this.name = name;
        out.writeVLong(activePermits);
 * compatible open source license.
    }
            pendingAcquireBatches
    }
 * <p>One instance exists at runtime for the datanode gate (shard-scan partitions).
        return name;
            && pendingAcquirePermits == that.pendingAcquirePermits  
        out.writeVLong(totalWaitDurationMs);  
        return Objects.hash(
    }  
    public void writeTo(StreamOutput out) throws IOException {
    public final long totalBatchesStarted;  
    public final long pendingAcquireBatches;  
        return maxPermits == that.maxPermits  
        if (this == o) return true;  
    public final long poisonPermits;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        long poisonPermits,  
     * Deserialize from stream.
     * @param totalBatchesStarted   cumulative batches started  
        this.maxPermits = in.readVLong();  
    public PartitionGateStats(StreamInput in) throws IOException {
    public final long targetMaxPermits;  
     * @param pendingAcquireBatches number of batches currently waiting to acquire permits
     * Construct from explicit field values.  
            activePermits,
public class PartitionGateStats implements Writeable, ToXContentFragment {  
            maxPermits,  
        this.activePermits = in.readVLong();
        this.poisonPermits = in.readVLong();
    /** Total semaphore capacity (immutable after initialization). */
        out.writeVLong(targetMaxPermits);  
/*  
        this.totalWaitDurationMs = in.readVLong();
 * the number of tasks currently waiting to acquire permits, and the number of
 *
import org.opensearch.core.common.io.stream.StreamInput;
            && targetMaxPermits == that.targetMaxPermits
    @Override
    }  
        out.writeVLong(maxPermits);
 * this file be licensed under the Apache-2.0 license or a
            && pendingAcquireBatches == that.pendingAcquireBatches
        long maxPermits,
        this.maxPermits = maxPermits;  
        out.writeVLong(poisonPermits);
     *
 * batches currently waiting to acquire permits.
        builder.field("total_batches_started", totalBatchesStarted);
    /** JSON key used when serializing this gate's stats. */
            && poisonPermits == that.poisonPermits
        if (o == null || getClass() != o.getClass()) return false;
    /**
 *
        builder.field("pending_acquire_batches", pendingAcquireBatches);
        builder.field("total_wait_duration_ms", totalWaitDurationMs);
package org.opensearch.be.datafusion.stats;
    @Override
 * wait time, cumulative batch count, poison permits held, target max permits,  
import org.opensearch.core.xcontent.ToXContentFragment;
     * @param in the stream input
     * @param activePermits         currently held permits
        this.pendingAcquireBatches = pendingAcquireBatches;
    /** Number of permits currently held (point-in-time). */
     *  
        this.activePermits = activePermits;
        this.pendingAcquirePermits = pendingAcquirePermits;  
        long totalBatchesStarted,
        builder.field("target_max_permits", targetMaxPermits);  
            && Objects.equals(name, that.name);
            && activePermits == that.activePermits
        long pendingAcquirePermits,
 */  
        builder.field("poison_permits", poisonPermits);
        out.writeVLong(pendingAcquireBatches);
import org.opensearch.core.common.io.stream.StreamOutput;
            name,
     * @param maxPermits            total semaphore capacity  
    private final String name;  
    public int hashCode() {  
        this.pendingAcquirePermits = in.readVLong();  
    /** Cumulative milliseconds partitions spent waiting for permits. */
            pendingAcquirePermits,  
    }  
            totalWaitDurationMs,
        );
        PartitionGateStats that = (PartitionGateStats) o;
     * @param totalWaitDurationMs   cumulative wait time in milliseconds
            targetMaxPermits,
            && totalBatchesStarted == that.totalBatchesStarted  
            totalBatchesStarted,  
        long targetMaxPermits,
     * @param poisonPermits         number of poison permits held
        out.writeVLong(totalBatchesStarted);
        this.poisonPermits = poisonPermits;
 * concurrent {@code stream_next} batch fetches across all active queries.  
        long pendingAcquireBatches  
        this.totalBatchesStarted = totalBatchesStarted;  
    public final long activePermits;  
        long totalWaitDurationMs,
    /**
    @Override
    }
/**
        String name,
import java.io.IOException;
        this.totalWaitDurationMs = totalWaitDurationMs;
        builder.endObject();
    public final long pendingAcquirePermits;  
    public final long maxPermits;  
        this.totalBatchesStarted = in.readVLong();  
 * SPDX-License-Identifier: Apache-2.0
    /** Cumulative count of batches started (permits granted) since startup. */
    /** Number of poison permits currently held to reduce effective capacity. */
    @Override
    /** Target max permits during an in-progress resize; equals maxPermits when idle. */
        this.pendingAcquireBatches = in.readVLong();
    public String getName() {  
        builder.startObject(name);
 * Stats for a partition budget gate — a node-level semaphore that limits
import org.opensearch.core.common.io.stream.Writeable;  
    public PartitionGateStats(  
    /** Number of batches currently waiting to acquire permits from this gate. */
    /** Number of tasks currently waiting to acquire permits from this gate. */
            && totalWaitDurationMs == that.totalWaitDurationMs
        long activePermits,  
        this.targetMaxPermits = targetMaxPermits;
     */
        this.targetMaxPermits = in.readVLong();
     */  
        this.name = in.readString();
import org.opensearch.core.xcontent.XContentBuilder;
     * @throws IOException if deserialization fails
    /** Returns the JSON key for this gate. */
        builder.field("max_permits", maxPermits);
            poisonPermits,
 * <p>Contains 8 metrics: the semaphore capacity, current utilization, cumulative
    public final long totalWaitDurationMs;  
    public boolean equals(Object o) {
        builder.field("pending_acquire_permits", pendingAcquirePermits);  
     * @param pendingAcquirePermits number of tasks currently waiting to acquire permits  
