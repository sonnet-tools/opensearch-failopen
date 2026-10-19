    public RuntimeMetrics(StreamInput in) throws IOException {
 * 8 fields from {@code tokio_metrics::RuntimeMonitor} describing
            totalPollsCount,
        if (this == o) return true;
            blockingQueueDepth,  
        builder.field("total_busy_duration_ms", totalBusyDurationMs);  
 * The OpenSearch Contributors require contributions made to  
        out.writeVLong(totalOverflowCount);
    /**  
    public final long totalOverflowCount;  
            && totalLocalQueueDepth == that.totalLocalQueueDepth;
        out.writeVLong(totalLocalQueueDepth);  
    ) {
     * @param numAliveTasks       tasks currently alive  
    /**
    @Override
        this.spawnedTasksCount = spawnedTasksCount;
import java.util.Objects;
    }
import org.opensearch.core.common.io.stream.StreamInput;
            && totalPollsCount == that.totalPollsCount  
        builder.field("workers_count", workersCount);
public class RuntimeMetrics implements Writeable {
        this.workersCount = in.readVLong();  
        if (o == null || getClass() != o.getClass()) return false;  
    }  
        this.totalOverflowCount = in.readVLong();  
    public final long workersCount;  
        this.totalLocalQueueDepth = totalLocalQueueDepth;
        this.globalQueueDepth = in.readVLong();
        this.totalBusyDurationMs = totalBusyDurationMs;
        long spawnedTasksCount,  
        long blockingQueueDepth,
     * @param totalLocalQueueDepth     sum of per-worker local queue depths
    /**  
        this.workersCount = workersCount;  
        this.blockingQueueDepth = in.readVLong();
    }
        builder.field("global_queue_depth", globalQueueDepth);
        this.totalOverflowCount = totalOverflowCount;  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        long totalOverflowCount,
    /** Total number of task polls across all workers. */
    }
    /** Total number of tasks spawned on this runtime since creation. */
            globalQueueDepth,
        long workersCount,
    public final long blockingQueueDepth;
     * @param in the stream input
            totalLocalQueueDepth  
            workersCount,
        );
            spawnedTasksCount,
    /** Current depth of the blocking thread pool queue. */  
    @Override  
     * @param blockingQueueDepth  current blocking thread pool queue depth
     * @throws IOException if writing fails
        this.blockingQueueDepth = blockingQueueDepth;
        long totalLocalQueueDepth
     *
import org.opensearch.core.common.io.stream.Writeable;  
/**  
    /** Sum of all per-worker local queue depths (tasks queued on worker-local run queues). */  
        out.writeVLong(blockingQueueDepth);  
     * @param totalBusyDurationMs total busy time in milliseconds
     * @throws IOException if deserialization fails  
        this.totalPollsCount = in.readVLong();
    public final long totalBusyDurationMs;
        out.writeVLong(numAliveTasks);
        long globalQueueDepth,  
}  
        builder.field("num_alive_tasks", numAliveTasks);
import org.opensearch.core.common.io.stream.StreamOutput;
            && totalBusyDurationMs == that.totalBusyDurationMs
        builder.field("total_polls_count", totalPollsCount);
     *
    public final long globalQueueDepth;
        out.writeVLong(globalQueueDepth);
        this.numAliveTasks = in.readVLong();  
 */  
        return Objects.hash(  
     * @param totalOverflowCount  total overflow queue pushes  
     */
    public final long numAliveTasks;  
     */  
        builder.field("spawned_tasks_count", spawnedTasksCount);
            totalBusyDurationMs,  
        out.writeVLong(totalBusyDurationMs);  
 * per-worker thread pool behavior for a single Tokio runtime.
        long totalPollsCount,  
     */
    /** Current depth of the global injection queue. */
    public final long spawnedTasksCount;
    public boolean equals(Object o) {
            && numAliveTasks == that.numAliveTasks
     * @param totalPollsCount     total task polls across all workers
    public RuntimeMetrics(
        return workersCount == that.workersCount
     * @param globalQueueDepth    current global injection queue depth
        this.globalQueueDepth = globalQueueDepth;
            && totalOverflowCount == that.totalOverflowCount
        out.writeVLong(spawnedTasksCount);
     * @param builder the XContent builder to write to  
    public void writeTo(StreamOutput out) throws IOException {  
     * @param spawnedTasksCount   total tasks spawned since creation
import org.opensearch.core.xcontent.XContentBuilder;
        builder.field("total_local_queue_depth", totalLocalQueueDepth);  
        this.totalLocalQueueDepth = in.readVLong();
    public int hashCode() {
        out.writeVLong(workersCount);
     * Render all 8 fields as snake_case JSON fields.
    public void toXContent(XContentBuilder builder) throws IOException {  
        this.totalBusyDurationMs = in.readVLong();
    }  
package org.opensearch.be.datafusion.stats;
/*  
            totalOverflowCount,
        this.totalPollsCount = totalPollsCount;
    @Override
 *
        RuntimeMetrics that = (RuntimeMetrics) o;
     *
    public final long totalLocalQueueDepth;
     * @param workersCount        number of worker threads  
    public final long totalPollsCount;
     * Construct from explicit field values.
    /** Number of worker threads in the runtime. */
import java.io.IOException;  
 */  
        long totalBusyDurationMs,
    /** Total number of times tasks were pushed to the overflow queue. */
            && globalQueueDepth == that.globalQueueDepth  
            && spawnedTasksCount == that.spawnedTasksCount  
        builder.field("blocking_queue_depth", blockingQueueDepth);  
 * compatible open source license.
        this.spawnedTasksCount = in.readVLong();
            numAliveTasks,
    }
    /** Number of tasks currently alive (spawned but not yet completed) on this runtime. */
        long numAliveTasks,
        out.writeVLong(totalPollsCount);
    /** Total time workers spent executing tasks, in milliseconds. */  
     * Deserialize from stream.  
            && blockingQueueDepth == that.blockingQueueDepth
        this.numAliveTasks = numAliveTasks;  
        builder.field("total_overflow_count", totalOverflowCount);
