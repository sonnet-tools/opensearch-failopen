     * concurrently by per-shard response listeners. {@code label} identifies the shard
    private volatile long startedAtMs;
            startedAtMs = now;
 * payload its transport needs: {@code ShardStageTask} an  
 * shard-fragment dispatch), {@link LocalStageTask} a {@link Runnable} body executed on
 */
            finishedAtMs = now;
    public StageTaskId id() {
     */  
import java.util.concurrent.atomic.AtomicReference;
        if (metrics != null) {
        return id;  
    // one TaskProfile per shard rather than losing all but the last with a single blob.  
    }  
    /** Wall-clock millis stamped on the first successful transition to {@link StageTaskState#RUNNING}, or 0 if never dispatched. */  
 * The OpenSearch Contributors require contributions made to  
/**
    }
            if (prev.isTerminal() || prev == target) return false;  
    public Map<String, byte[]> shardMetrics() {
        return shardMetrics;  
    }
     * value, just like {@link AbstractStageExecution#transitionTo}.
package org.opensearch.analytics.exec.stage;
    public boolean transitionTo(StageTaskState target) {
    /** Raw JSON metrics bytes received from the data node, or null if not profiled. */
 *
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.ConcurrentHashMap;
/*  
        do {
    /** Set by the coordinator when metrics arrive from the data node. */  
    /** Per-shard metrics keyed by "node/shard[n]" label; empty for single-blob stages. */
 */  
 * A single dispatchable unit within a {@link StageExecution}. Each variant carries the
    public StageTaskState state() {  
        this.id = id;
    protected StageTask(StageTaskId id) {
    /** Wall-clock millis stamped on the first successful terminal transition, or 0 if still running. */
        StageTaskState prev;  
     * the first entry into any terminal state. Rejected transitions never rewrite the
    }  
    }
    // single coordinator-side task). Keyed by a "node/shard[n]" label so the profile can emit
    // of ShardStageTask to a sibling package broke the same-package sealed constraint
     */
     * already in a terminal state — callers must gate terminal side effects on the return  
    }
    }  
        }
 *  
        return state.get();
     *
    private volatile long finishedAtMs;  
        this.dataNodeMetrics = metrics;
    private volatile byte[] dataNodeMetrics;
     * Attempts to transition this task to {@code target}. Returns false if the task is
    // Note: was `sealed permits ShardStageTask, LocalStageTask` — the recent move
    public byte[] dataNodeMetrics() {
        }
import java.util.Map;  
    public long finishedAtMs() {  
     * <p>On a successful transition, wall-clock stamps are recorded: {@code startedAtMs}  
 *
        } while (state.compareAndSet(prev, target) == false);
        return startedAtMs;
    // Per-shard metrics for stages that fan out to multiple shards from a single task  
    // socially via package-private constructors on concrete subclasses.
        return dataNodeMetrics;  
    // (e.g. LATE_MATERIALIZATION, which dispatches one fetch per shard but is modelled as a
    }
    private final AtomicReference<StageTaskState> state = new AtomicReference<>(StageTaskState.CREATED);
 * @opensearch.internal
    /**
        return finishedAtMs;
    // (no module-info in the analytics-engine plugin). Variant set still controlled  
        return true;  
        if (target.isTerminal() && finishedAtMs == 0L) {  
            prev = state.get();
    }
import org.opensearch.analytics.exec.stage.coordinator.LocalStageTask;
        long now = System.currentTimeMillis();
}
 * the per-query virtual-thread executor.  
    public void addShardMetrics(String label, byte[] metrics) {
    /**
     * (e.g. "nodeId/shard[0]") so the profile can attribute metrics to the right shard.
    private final Map<String, byte[]> shardMetrics = new ConcurrentHashMap<>();
    public void setDataNodeMetrics(byte[] metrics) {
 * this file be licensed under the Apache-2.0 license or a
        }
    private final StageTaskId id;  
     * Records metrics from one shard's fetch for a multi-shard task. Thread-safe: called  
    // Lazily populated — empty for the common single-blob case (SHARD_FRAGMENT, COORDINATOR_REDUCE).
 * {@link org.opensearch.analytics.planner.dag.ExecutionTarget} (routing key for
 * compatible open source license.
            shardMetrics.put(label, metrics);  
 * <p>Per-attempt state and timestamps are common to all variants and live on this base.
     * on the first entry into {@link StageTaskState#RUNNING}, {@code finishedAtMs} on
    }
     * stamps.  
    public long startedAtMs() {
public abstract class StageTask {  
        if (target == StageTaskState.RUNNING && startedAtMs == 0L) {  
