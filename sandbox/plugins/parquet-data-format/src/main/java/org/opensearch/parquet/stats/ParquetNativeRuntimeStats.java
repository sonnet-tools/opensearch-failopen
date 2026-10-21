     *   [3]  rayon_merge_tasks_completed
            "merge_tasks_in_flight",
 *
        this.tokioWorkersBusyMillisTotal = tokioWorkersBusyMillisTotal;
        );
        this.rayonMergeTasksFailed = in.readVLong();
    private final long tokioGlobalQueueDepth;
     *   [10] tokio_global_queue_depth
 * <p>The wire format encodes {@value #FIELD_COUNT} values; the JNI bridge in
 * wrapper runs (FFM bridge throws, Java-side validation fails, IO task panics, etc.)
        this.rayonConfiguredThreads = rayonConfiguredThreads;
     *   [8]  tokio_num_blocking_threads
        );
        b.field("merge_tasks_submitted", rayonMergeTasksSubmitted);
        b.field("local_queue_depth_total", tokioLocalQueueDepthTotal);
    private final long tokioPollsCountTotal;
        long tokioLocalQueueDepthTotal,
     *   [5]  rayon_merge_tasks_panicked
    public void writeTo(StreamOutput out) throws IOException {
        b.startObject("parquet_io");
    private final long rayonMergeTasksSubmitted;
        this.tokioBlockingQueueDepth = in.readVLong();
    }
    }
import java.io.IOException;
                    + (arr == null ? "null" : Integer.toString(arr.length))
        long tokioWorkersBusyMillisTotal
        b.field("num_blocking_threads", tokioNumBlockingThreads);
            arr[8],
        b.endObject();
    private final long tokioLocalQueueDepthTotal;
        long rayonMergeTasksPanicked,
    private final long tokioOverflowCountTotal;
            arr[5],
            );
    private final long rayonMergeWallMillis;
     *   [6]  rayon_merge_wall_millis
     * </pre>
     *   [13] tokio_polls_count_total
 *
        b.field("num_workers", tokioNumWorkers);
    public static ParquetNativeRuntimeStats fromArray(long[] arr) {
            arr[12],
 * compatible open source license.
    private final long tokioBlockingQueueDepth;
        this.rayonMergeTasksSubmitted = in.readVLong();
 * <p><b>parquet_merge.merge_tasks_failed</b> counts logical errors that occur INSIDE
        this.tokioActiveTasks = tokioActiveTasks;
    public XContentBuilder toXContent(XContentBuilder b, Params p) throws IOException {
                "native runtime stats array must have at least "
    private final long rayonMergeTasksStarted;
 * increment the per-shard {@code parquet.merge.merge_failures} counter but NOT
     *   [7]  tokio_num_workers
import org.opensearch.common.annotation.ExperimentalApi;
    private final long tokioActiveTasks;
        this.rayonMergeWallMillis = rayonMergeWallMillis;
        out.writeVLong(tokioGlobalQueueDepth);
    ) {
import org.opensearch.core.common.io.stream.StreamInput;
            arr[3],
        long tokioNumWorkers,
@ExperimentalApi
 * {@link org.opensearch.parquet.bridge.RustBridge#collectRuntimeMetrics()} returns
            arr[6],
 * SPDX-License-Identifier: Apache-2.0
     * {@code RustBridge.collectRuntimeMetrics()}, in order:
        b.field("workers_busy_millis_total", tokioWorkersBusyMillisTotal);
     *   [1]  rayon_merge_tasks_submitted
        this.tokioLocalQueueDepthTotal = tokioLocalQueueDepthTotal;
        this.tokioPollsCountTotal = tokioPollsCountTotal;
 *
            arr[7],
            arr[0],
        b.field("global_queue_depth", tokioGlobalQueueDepth);
 */
        out.writeVLong(tokioOverflowCountTotal);
    private final long tokioNumBlockingThreads;
import org.opensearch.core.xcontent.ToXContentFragment;
        long tokioGlobalQueueDepth,
    private final long rayonMergeTasksCompleted;
 * the rayon-wrapped column-encoding pass only. Logical errors that occur before this
 * this file be licensed under the Apache-2.0 license or a
        b.field("polls_count_total", tokioPollsCountTotal);
            arr[15],
        out.writeVLong(rayonMergeTasksStarted);
import org.opensearch.core.common.io.stream.Writeable;
        this.tokioPollsCountTotal = in.readVLong();
        b.field("spawned_tasks_total", tokioSpawnedTasksTotal);
        b.field("merge_wall_millis", rayonMergeWallMillis);
        this.tokioNumBlockingThreads = tokioNumBlockingThreads;
        // Derived: tasks currently executing (started but not yet completed/failed/panicked).
        b.startObject("native_runtime");
     *   [12] tokio_local_queue_depth_total
        // Clamped to 0 to handle racy reads where started briefly exceeds submitted.
        this.tokioOverflowCountTotal = tokioOverflowCountTotal;
     * Builds an instance from the {@link #FIELD_COUNT}-element long array returned by
        b.field("merge_tasks_completed", rayonMergeTasksCompleted);
        b.field("overflow_count_total", tokioOverflowCountTotal);
 *
        long rayonMergeWallMillis,
        out.writeVLong(rayonMergeWallMillis);
                    + FIELD_COUNT
 * The OpenSearch Contributors require contributions made to
        long rayonMergeTasksFailed,
     *   [0]  rayon_configured_threads
    // Rayon merge pool state
        b.field("configured_threads", rayonConfiguredThreads);
    private final long tokioSpawnedTasksTotal;
        b.field(
        out.writeVLong(rayonMergeTasksSubmitted);
     *   [9]  tokio_active_tasks
        out.writeVLong(tokioBlockingQueueDepth);
        b.field("blocking_queue_depth", tokioBlockingQueueDepth);
        b.endObject();
            arr[2],
        out.writeVLong(rayonMergeTasksFailed);
        this.rayonMergeTasksStarted = in.readVLong();
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
        long rayonConfiguredThreads,
        return b;
        out.writeVLong(tokioPollsCountTotal);
        this.rayonMergeTasksPanicked = rayonMergeTasksPanicked;
        this.tokioNumBlockingThreads = in.readVLong();
        long tokioPollsCountTotal,
        b.startObject("parquet_merge");
        this.rayonMergeWallMillis = in.readVLong();
        out.writeVLong(tokioLocalQueueDepthTotal);
        b.field("merge_tasks_panicked", rayonMergeTasksPanicked);
 * an array of the same length in the order documented in {@link #fromArray}.
        out.writeVLong(rayonMergeTasksPanicked);
    private final long tokioNumWorkers;
 * usage and tokio IO runtime state. Populated only at the per-node aggregate scope
        long tokioNumBlockingThreads,
     *   [15] tokio_spawned_tasks_total
 * (never on individual shard trackers) and dropped during cross-node aggregation
 * @opensearch.experimental
        this.rayonMergeTasksStarted = rayonMergeTasksStarted;
        this.tokioSpawnedTasksTotal = tokioSpawnedTasksTotal;
        b.field("merge_tasks_failed", rayonMergeTasksFailed);
        this.tokioGlobalQueueDepth = tokioGlobalQueueDepth;
    public ParquetNativeRuntimeStats(StreamInput in) throws IOException {
        this.rayonMergeTasksCompleted = in.readVLong();
        this.tokioLocalQueueDepthTotal = in.readVLong();
package org.opensearch.parquet.stats;
        long tokioBlockingQueueDepth,
    private final long rayonMergeTasksFailed;
        }
            arr[9],
        this.tokioWorkersBusyMillisTotal = in.readVLong();
            arr[13],
    public ParquetNativeRuntimeStats(
            arr[14],
        b.field("active_tasks", tokioActiveTasks);
     */
        this.tokioSpawnedTasksTotal = in.readVLong();
     *   [2]  rayon_merge_tasks_started
        this.tokioNumWorkers = in.readVLong();
        return new ParquetNativeRuntimeStats(
        this.rayonMergeTasksSubmitted = rayonMergeTasksSubmitted;
     *   [4]  rayon_merge_tasks_failed
            Math.max(0L, rayonMergeTasksStarted - rayonMergeTasksCompleted - rayonMergeTasksFailed - rayonMergeTasksPanicked)
 * Process-wide native runtime metrics for the parquet merge path: rayon thread pool
        this.tokioBlockingQueueDepth = tokioBlockingQueueDepth;
    // Tokio IO runtime state
        this.tokioActiveTasks = in.readVLong();
        out.writeVLong(tokioNumWorkers);
        b.field("merge_tasks_queue_depth", Math.max(0L, rayonMergeTasksSubmitted - rayonMergeTasksStarted));
/*
        // Derived: tasks queued but not yet picked up by a worker.
public final class ParquetNativeRuntimeStats implements Writeable, ToXContentFragment {
    }
        if (arr == null || arr.length < FIELD_COUNT) {
    }
        long rayonMergeTasksStarted,
        this.rayonMergeTasksPanicked = in.readVLong();
        this.rayonMergeTasksCompleted = rayonMergeTasksCompleted;
    private final long rayonMergeTasksPanicked;
        out.writeVLong(rayonMergeTasksCompleted);
     *   [14] tokio_overflow_count_total
        this.tokioGlobalQueueDepth = in.readVLong();
    /**
 */
            arr[4],
        long tokioSpawnedTasksTotal,
        long tokioOverflowCountTotal,
                    + " elements, got: "
    /** Number of long values in the FFM array returned by {@code RustBridge.collectRuntimeMetrics()}. */
    private final long rayonConfiguredThreads;
            arr[11],
 * {@code merge_tasks_failed}. The two populations overlap but intentionally measure
        this.rayonMergeTasksFailed = rayonMergeTasksFailed;
        this.rayonConfiguredThreads = in.readVLong();
        out.writeVLong(tokioNumBlockingThreads);
        b.endObject();
        this.tokioNumWorkers = tokioNumWorkers;
 * so it never appears in cluster-wide /{idx}/_stats responses.
     *   [16] tokio_workers_busy_millis_total
        b.field("merge_tasks_started", rayonMergeTasksStarted);
            arr[1],
        out.writeVLong(tokioSpawnedTasksTotal);
        long tokioActiveTasks,
            arr[16]
    public static final int FIELD_COUNT = 17;
            arr[10],
        long rayonMergeTasksCompleted,
    @Override
        out.writeVLong(tokioActiveTasks);
 * different scopes — they are not expected to be equal.
     *   [11] tokio_blocking_queue_depth
    }
            throw new IllegalArgumentException(
    private final long tokioWorkersBusyMillisTotal;
     * <pre>
/**
import org.opensearch.core.common.io.stream.StreamOutput;
        this.tokioOverflowCountTotal = in.readVLong();
        long rayonMergeTasksSubmitted,
        out.writeVLong(tokioWorkersBusyMillisTotal);
}
        out.writeVLong(rayonConfiguredThreads);
