            arr[13],
        this.tokioPollsCountTotal = tokioPollsCountTotal;
        this.rayonMergeTasksStarted = rayonMergeTasksStarted;
    @Override  
     *   [2]  rayon_merge_tasks_started  
    private final long tokioLocalQueueDepthTotal;
        this.tokioActiveTasks = in.readVLong();
        b.field("merge_tasks_failed", rayonMergeTasksFailed);
        this.tokioActiveTasks = tokioActiveTasks;  
 * wrapper runs (FFM bridge throws, Java-side validation fails, IO task panics, etc.)
        b.field("merge_wall_millis", rayonMergeWallMillis);
    public static ParquetNativeRuntimeStats fromArray(long[] arr) {
        b.field("merge_tasks_started", rayonMergeTasksStarted);  
            arr[15],  
        return b;  
        }
        this.rayonConfiguredThreads = in.readVLong();
        b.field("merge_tasks_queue_depth", Math.max(0L, rayonMergeTasksSubmitted - rayonMergeTasksStarted));
        b.field("active_tasks", tokioActiveTasks);
        this.rayonMergeTasksPanicked = rayonMergeTasksPanicked;
        b.startObject("parquet_merge");  
                    + " elements, got: "
 * <p>The wire format encodes {@value #FIELD_COUNT} values; the JNI bridge in
        this.rayonMergeTasksCompleted = rayonMergeTasksCompleted;  
public final class ParquetNativeRuntimeStats implements Writeable, ToXContentFragment {  
        b.field("merge_tasks_panicked", rayonMergeTasksPanicked);  
            arr[6],  
 * the rayon-wrapped column-encoding pass only. Logical errors that occur before this  
        this.tokioNumWorkers = in.readVLong();  
        out.writeVLong(tokioNumWorkers);  
        // Clamped to 0 to handle racy reads where started briefly exceeds submitted.  
        long rayonMergeTasksStarted,
    private final long rayonMergeWallMillis;  
 * The OpenSearch Contributors require contributions made to  
        this.rayonConfiguredThreads = rayonConfiguredThreads;  
     *   [3]  rayon_merge_tasks_completed
        b.field("merge_tasks_completed", rayonMergeTasksCompleted);
        out.writeVLong(tokioSpawnedTasksTotal);
        this.tokioPollsCountTotal = in.readVLong();  
        );  
        long tokioOverflowCountTotal,
        out.writeVLong(rayonMergeTasksFailed);  
        b.field("blocking_queue_depth", tokioBlockingQueueDepth);
        long rayonConfiguredThreads,  
    private final long tokioSpawnedTasksTotal;
 * {@link org.opensearch.parquet.bridge.RustBridge#collectRuntimeMetrics()} returns
 * @opensearch.experimental  
 *  
            arr[4],
        );
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;  
/*  
     *   [14] tokio_overflow_count_total  
    private final long tokioActiveTasks;
}
     * Builds an instance from the {@link #FIELD_COUNT}-element long array returned by
        long rayonMergeTasksPanicked,
    private final long tokioWorkersBusyMillisTotal;  
        b.field("polls_count_total", tokioPollsCountTotal);  
        long tokioBlockingQueueDepth,
            arr[12],  
        this.tokioWorkersBusyMillisTotal = tokioWorkersBusyMillisTotal;
import org.opensearch.core.common.io.stream.Writeable;
    private final long tokioNumWorkers;  
        long rayonMergeWallMillis,  
     *   [16] tokio_workers_busy_millis_total
        out.writeVLong(tokioActiveTasks);
        b.endObject();
            );  
            arr[14],
                    + (arr == null ? "null" : Integer.toString(arr.length))
     *   [8]  tokio_num_blocking_threads  
        out.writeVLong(tokioGlobalQueueDepth);  
        out.writeVLong(tokioPollsCountTotal);  
                    + FIELD_COUNT  
        this.rayonMergeTasksPanicked = in.readVLong();
 * so it never appears in cluster-wide /{idx}/_stats responses.
     *   [13] tokio_polls_count_total
import java.io.IOException;
        long tokioPollsCountTotal,
 * <p><b>parquet_merge.merge_tasks_failed</b> counts logical errors that occur INSIDE
        this.tokioGlobalQueueDepth = tokioGlobalQueueDepth;
import org.opensearch.core.xcontent.XContentBuilder;  
    public static final int FIELD_COUNT = 17;  
        this.rayonMergeTasksFailed = in.readVLong();  
@ExperimentalApi
        long tokioActiveTasks,  
        // Derived: tasks currently executing (started but not yet completed/failed/panicked).
        if (arr == null || arr.length < FIELD_COUNT) {  
        this.tokioOverflowCountTotal = tokioOverflowCountTotal;
        long tokioNumWorkers,
    }
        out.writeVLong(rayonConfiguredThreads);
        out.writeVLong(tokioBlockingQueueDepth);
        out.writeVLong(tokioNumBlockingThreads);
            arr[1],
 * an array of the same length in the order documented in {@link #fromArray}.  
 * increment the per-shard {@code parquet.merge.merge_failures} counter but NOT
    public XContentBuilder toXContent(XContentBuilder b, Params p) throws IOException {
    }
            arr[11],
 * usage and tokio IO runtime state. Populated only at the per-node aggregate scope  
        long rayonMergeTasksSubmitted,
            "merge_tasks_in_flight",
 * Process-wide native runtime metrics for the parquet merge path: rayon thread pool
 *
        this.rayonMergeTasksSubmitted = in.readVLong();  
        b.field("overflow_count_total", tokioOverflowCountTotal);
            arr[10],
        b.endObject();
        out.writeVLong(rayonMergeTasksPanicked);
        out.writeVLong(rayonMergeWallMillis);
        return new ParquetNativeRuntimeStats(
        b.field("global_queue_depth", tokioGlobalQueueDepth);  
        b.field("num_blocking_threads", tokioNumBlockingThreads);
            throw new IllegalArgumentException(
import org.opensearch.common.annotation.ExperimentalApi;
 *
    private final long tokioGlobalQueueDepth;  
            arr[2],
            arr[5],
        this.rayonMergeWallMillis = in.readVLong();
    private final long tokioBlockingQueueDepth;
        long tokioSpawnedTasksTotal,  
 * this file be licensed under the Apache-2.0 license or a
        out.writeVLong(tokioWorkersBusyMillisTotal);  
     *   [10] tokio_global_queue_depth
    private final long rayonMergeTasksPanicked;
            arr[8],
        this.tokioBlockingQueueDepth = tokioBlockingQueueDepth;
    }  
import org.opensearch.core.xcontent.ToXContentFragment;
        this.rayonMergeTasksCompleted = in.readVLong();
     *   [1]  rayon_merge_tasks_submitted
    public ParquetNativeRuntimeStats(StreamInput in) throws IOException {
    private final long rayonMergeTasksStarted;
            arr[3],  
    // Tokio IO runtime state
     *   [7]  tokio_num_workers
 * compatible open source license.
        out.writeVLong(rayonMergeTasksCompleted);
        // Derived: tasks queued but not yet picked up by a worker.
     *   [15] tokio_spawned_tasks_total
    private final long rayonMergeTasksCompleted;  
 */
        this.rayonMergeTasksFailed = rayonMergeTasksFailed;
        this.tokioNumBlockingThreads = tokioNumBlockingThreads;
     */
    private final long tokioOverflowCountTotal;
package org.opensearch.parquet.stats;
        b.field(  
     * </pre>  
        this.tokioGlobalQueueDepth = in.readVLong();  
        b.endObject();
    ) {
    public ParquetNativeRuntimeStats(
/**
     *   [5]  rayon_merge_tasks_panicked  
 */  
        b.field("workers_busy_millis_total", tokioWorkersBusyMillisTotal);  
        this.tokioNumWorkers = tokioNumWorkers;
    private final long rayonConfiguredThreads;  
    /** Number of long values in the FFM array returned by {@code RustBridge.collectRuntimeMetrics()}. */
    @Override  
        b.field("num_workers", tokioNumWorkers);  
        this.tokioLocalQueueDepthTotal = tokioLocalQueueDepthTotal;  
        out.writeVLong(rayonMergeTasksSubmitted);  
    private final long rayonMergeTasksSubmitted;
            arr[16]
    private final long tokioPollsCountTotal;  
    }
    // Rayon merge pool state
            arr[9],  
                "native runtime stats array must have at least "
        long tokioGlobalQueueDepth,
        b.field("configured_threads", rayonConfiguredThreads);
        this.rayonMergeTasksSubmitted = rayonMergeTasksSubmitted;
        long rayonMergeTasksFailed,
 * different scopes — they are not expected to be equal.
        b.startObject("native_runtime");
        b.field("local_queue_depth_total", tokioLocalQueueDepthTotal);
     *   [9]  tokio_active_tasks
        out.writeVLong(rayonMergeTasksStarted);
        long tokioNumBlockingThreads,
        out.writeVLong(tokioLocalQueueDepthTotal);
     * <pre>  
    public void writeTo(StreamOutput out) throws IOException {
        long tokioLocalQueueDepthTotal,  
        b.startObject("parquet_io");
        long tokioWorkersBusyMillisTotal
            arr[7],
        this.rayonMergeWallMillis = rayonMergeWallMillis;  
 * SPDX-License-Identifier: Apache-2.0
            arr[0],  
        this.tokioNumBlockingThreads = in.readVLong();
        this.tokioOverflowCountTotal = in.readVLong();
        this.rayonMergeTasksStarted = in.readVLong();
        this.tokioSpawnedTasksTotal = in.readVLong();
 * {@code merge_tasks_failed}. The two populations overlap but intentionally measure  
     *   [6]  rayon_merge_wall_millis
        out.writeVLong(tokioOverflowCountTotal);
     * {@code RustBridge.collectRuntimeMetrics()}, in order:
 * (never on individual shard trackers) and dropped during cross-node aggregation
 *
    /**  
    private final long rayonMergeTasksFailed;
     *   [4]  rayon_merge_tasks_failed
        this.tokioWorkersBusyMillisTotal = in.readVLong();  
        long rayonMergeTasksCompleted,  
        b.field("spawned_tasks_total", tokioSpawnedTasksTotal);
        this.tokioSpawnedTasksTotal = tokioSpawnedTasksTotal;  
    }
    private final long tokioNumBlockingThreads;
     *   [11] tokio_blocking_queue_depth  
     *   [12] tokio_local_queue_depth_total
        b.field("merge_tasks_submitted", rayonMergeTasksSubmitted);
            Math.max(0L, rayonMergeTasksStarted - rayonMergeTasksCompleted - rayonMergeTasksFailed - rayonMergeTasksPanicked)
        this.tokioBlockingQueueDepth = in.readVLong();
        this.tokioLocalQueueDepthTotal = in.readVLong();
     *   [0]  rayon_configured_threads
