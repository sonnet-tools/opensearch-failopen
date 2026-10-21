                new AnalyticsStats.StageBucket(
        }
        Map<Integer, String> out = new HashMap<>();
     *              for per-stage-type bucketing. May be {@code null} when graph is null.
        return out;
                    c.failed.sum(),
import java.util.concurrent.ConcurrentMap;
        // Track the earliest start / latest end across all stages to derive end-to-end
     * @param dag   the DAG that produced the graph; used to resolve each
 * SPDX-License-Identifier: Apache-2.0
            stageMap.put(
    }
                    c.elapsed.snapshot()
        void record(long valueMs) {
 * — the metrics backend derives those from interval diffs of the cumulative
            switch (exec.getState()) {
                case CANCELLED -> c.cancelled.increment();
            StageCounters c = bucket(execType);
            );
    private final LongAdder fragmentsFailed = new LongAdder();
        if (executionTimeMs > 0) {
            }
    }
        out.put(stage.getStageId(), stage.getExecutionType().name());
        addStage(out, dag.rootStage());
            sumMs.add(valueMs);
import org.opensearch.analytics.exec.stage.StageMetrics;
     * intermediate {@code QueryProfile}, no plan stringification, no per-stage
    private final LongAdder fragmentsSucceeded = new LongAdder();
        }
        private final LongAdder count = new LongAdder();
 * {@link ConcurrentHashMap}.
                case FAILED -> c.failed.increment();
            if (elapsed > 0) {
                        // CREATED / RUNNING / CANCELLED — counted in total only.
 * payload still uses {@code QueryProfileBuilder.snapshot()}; the stats path
 *
import java.util.Map;
 * intentionally avoids it so the hot path stays allocation-free.
            if (valueMs < 0) return;
 * REST endpoint to render. Recording is wait-free: counters and latency totals
    private static void addStage(Map<Integer, String> out, Stage stage) {
        }
 * are {@link LongAdder}s, the per-stage-type bucket map is a
     */
        return new AnalyticsStats(queries, stageMap, fragments);
     * Folds a completed query's execution into the rollup. Called once per query
                if (taskElapsed > 0) {
    public AnalyticsStats snapshot() {
 * without allocating an intermediate
                    case FINISHED -> fragmentsSucceeded.increment();
            if (end > 0) latestEnd = Math.max(latestEnd, end);
        final LongAdder failed = new LongAdder();
    /**
        final LongAdder rowsProcessedTotal = new LongAdder();
     * Wait-free count + sum of millisecond elapsed times. Negative recordings
    private static Map<Integer, String> buildStageTypeIndex(QueryDAG dag) {
                switch (task.state()) {
            addStage(out, child);
import org.opensearch.analytics.planner.dag.Stage;
    }
                    c.succeeded.sum(),
 */
import java.util.concurrent.ConcurrentHashMap;
                    c.rowsProcessedTotal.sum(),
                long taskEnd = task.finishedAtMs();
 *
        final LatencyTotals elapsed = new LatencyTotals();
import java.util.HashMap;
/*
                    default -> {
 * compatible open source license.
public final class AnalyticsStatsCollector {
        for (Stage child : stage.getChildStages()) {
                    fragmentsElapsed.record(taskElapsed);
                )
import java.util.TreeMap;
                long taskElapsed = (taskStart > 0 && taskEnd > 0) ? taskEnd - taskStart : 0L;
     *
import java.util.concurrent.atomic.LongAdder;
        final LongAdder started = new LongAdder();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.planner.dag.QueryDAG;
 * {@code DefaultPlanExecutor} calls {@link #recordExecution} once per query
            c.started.increment();
            fragmentsTotal.sum(),
 * analytics DataFusion backend's stats endpoint.
    private final LatencyTotals queriesElapsed = new LatencyTotals();
        private final LongAdder sumMs = new LongAdder();
            queriesPlanning.record(planningTimeMs);
     *              failed before execution started
                default -> {
     * recording only the planning time.
    }
            long end = m.getEndTimeMs();
        // does per-stage.
     *              {@link StageExecution} to its {@link Stage#getExecutionType()}
            StageMetrics m = exec.getMetrics();
        final LongAdder cancelled = new LongAdder();
    private static final class LatencyTotals {
package org.opensearch.analytics.stats;
        }
     * stream filters.
    private final LongAdder fragmentsTotal = new LongAdder();
        );
                case SUCCEEDED -> c.succeeded.increment();
 * {@code count} / {@code sum_ms} totals. Mirrors the contract of the
        AnalyticsStats.LatencyStats snapshot() {
     * @param graph the post-execution graph; may be {@code null} if the query
 * {@link org.opensearch.analytics.exec.profile.QueryProfile}. The {@code _explain}
    private static final class StageCounters {
        for (StageExecution exec : graph.allExecutions()) {
        Map<String, AnalyticsStats.StageBucket> stageMap = new TreeMap<>();
            fragmentsFailed.sum(),
            queriesElapsed.record(executionTimeMs);
        for (Map.Entry<String, StageCounters> e : byStageType.entrySet()) {
 * Node-local rollup of analytics-engine query, stage, and fragment timings.
                    c.started.sum(),
            for (StageTask task : exec.tasks()) {
        // so a flat HashMap is faster than the recursive findStageById walk QueryProfileBuilder
     *
        }
        final LongAdder succeeded = new LongAdder();
            long start = m.getStartTimeMs();
    /**
import org.opensearch.analytics.exec.ExecutionGraph;
            count.increment();
     * {@code total_*_count} pattern used by the DataFusion backend's stats.
        Map<Integer, String> stageTypeById = dag != null ? buildStageTypeIndex(dag) : Map.of();
 */
 * The OpenSearch Contributors require contributions made to
        if (graph == null) return;
        AnalyticsStats.Fragments fragments = new AnalyticsStats.Fragments(
    }
        }
                    c.cancelled.sum(),
     * @param planningTimeMs Calcite planning duration in ms
                e.getKey(),
        long executionTimeMs = (earliestStart != Long.MAX_VALUE && latestEnd > 0) ? latestEnd - earliestStart : 0L;
    private final LatencyTotals fragmentsElapsed = new LatencyTotals();
                }
            return new AnalyticsStats.LatencyStats(count.sum(), sumMs.sum());
/**
            }
                    // CREATED / RUNNING — stage didn't reach terminal; don't count toward terminal buckets.
        // Build a stageId -> executionType lookup once. The DAG is small (handful of stages)
    public void recordExecution(ExecutionGraph graph, QueryDAG dag, long planningTimeMs) {
            fragmentsElapsed.snapshot()
            if (start > 0) earliestStart = Math.min(earliestStart, start);
            String execType = stageTypeById.getOrDefault(exec.getStageId(), exec.getClass().getSimpleName());
 * <p>{@link #snapshot()} returns an immutable {@link AnalyticsStats} for the
        AnalyticsStats.Queries queries = new AnalyticsStats.Queries(queriesElapsed.snapshot(), queriesPlanning.snapshot());
            StageCounters c = e.getValue();
                fragmentsTotal.increment();
import org.opensearch.analytics.exec.stage.StageExecution;
        return byStageType.computeIfAbsent(stageType != null ? stageType : "unknown", k -> new StageCounters());
     */
import org.opensearch.analytics.exec.stage.StageTask;
                }
            fragmentsSucceeded.sum(),
     * are dropped. Mirrors the cumulative {@code total_*_duration_ms} /
     * Walks the {@link ExecutionGraph} directly and feeds {@link LongAdder}s; no
            long elapsed = (start > 0 && end > 0) ? end - start : 0L;
 * terminal — feeding the raw counters straight off the {@link ExecutionGraph}
        if (planningTimeMs > 0) {
    private final LatencyTotals queriesPlanning = new LatencyTotals();
        // execution wall time without a second pass over the graph.
        long earliestStart = Long.MAX_VALUE;
 *
    private StageCounters bucket(String stageType) {
}
            }
        }
                c.elapsed.record(elapsed);
                long taskStart = task.startedAtMs();
            c.rowsProcessedTotal.add(m.getRowsProcessed());
                }
        long latestEnd = 0L;
 * <p>We intentionally don't compute averages, percentiles, or histograms here
                    case FAILED -> fragmentsFailed.increment();
     * <p>Tolerates a null graph (e.g. failures upstream of execution) by
    }
    /** Builds an immutable snapshot of all counters at this instant. */
     * from {@code DefaultPlanExecutor} at terminal — success, failure, or cancellation.
    }
    private final ConcurrentMap<String, StageCounters> byStageType = new ConcurrentHashMap<>();
                    }
