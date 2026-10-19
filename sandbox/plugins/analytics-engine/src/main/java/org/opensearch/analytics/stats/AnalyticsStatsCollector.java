     *              for per-stage-type bucketing. May be {@code null} when graph is null.  
 *
 * Node-local rollup of analytics-engine query, stage, and fragment timings.
                }
import org.opensearch.analytics.exec.ExecutionGraph;
        AnalyticsStats.LatencyStats snapshot() {  
            switch (exec.getState()) {
            fragmentsTotal.sum(),
    private final LatencyTotals queriesPlanning = new LatencyTotals();
                switch (task.state()) {  
 * <p>{@link #snapshot()} returns an immutable {@link AnalyticsStats} for the  
        }
     * {@code total_*_count} pattern used by the DataFusion backend's stats.  
        final LongAdder started = new LongAdder();  
 */  
        private final LongAdder count = new LongAdder();  
import java.util.concurrent.ConcurrentMap;  
     *              {@link StageExecution} to its {@link Stage#getExecutionType()}
            long end = m.getEndTimeMs();
    public AnalyticsStats snapshot() {
    }
        }
            queriesPlanning.record(planningTimeMs);
                case FAILED -> c.failed.increment();
                    c.rowsProcessedTotal.sum(),
        return byStageType.computeIfAbsent(stageType != null ? stageType : "unknown", k -> new StageCounters());
                    c.failed.sum(),  
            }
        final LatencyTotals elapsed = new LatencyTotals();
            long start = m.getStartTimeMs();  
 * REST endpoint to render. Recording is wait-free: counters and latency totals
     * @param planningTimeMs Calcite planning duration in ms
     * Folds a completed query's execution into the rollup. Called once per query
            stageMap.put(
        for (Map.Entry<String, StageCounters> e : byStageType.entrySet()) {
                fragmentsTotal.increment();
            fragmentsElapsed.snapshot()
 * analytics DataFusion backend's stats endpoint.
     *
     * intermediate {@code QueryProfile}, no plan stringification, no per-stage
        if (executionTimeMs > 0) {
        Map<Integer, String> stageTypeById = dag != null ? buildStageTypeIndex(dag) : Map.of();  
 * without allocating an intermediate
import java.util.concurrent.atomic.LongAdder;
        if (planningTimeMs > 0) {
import org.opensearch.analytics.exec.stage.StageMetrics;  
        void record(long valueMs) {  
     * stream filters.  
                case CANCELLED -> c.cancelled.increment();
        for (StageExecution exec : graph.allExecutions()) {
            return new AnalyticsStats.LatencyStats(count.sum(), sumMs.sum());
                }  
 * — the metrics backend derives those from interval diffs of the cumulative  
    private StageCounters bucket(String stageType) {
     */
 * {@code DefaultPlanExecutor} calls {@link #recordExecution} once per query
                    c.cancelled.sum(),
 * {@link org.opensearch.analytics.exec.profile.QueryProfile}. The {@code _explain}
            if (valueMs < 0) return;
import java.util.Map;  
            if (end > 0) latestEnd = Math.max(latestEnd, end);
import org.opensearch.analytics.planner.dag.QueryDAG;
        AnalyticsStats.Fragments fragments = new AnalyticsStats.Fragments(
                    c.started.sum(),
        // so a flat HashMap is faster than the recursive findStageById walk QueryProfileBuilder
    /** Builds an immutable snapshot of all counters at this instant. */
        // Build a stageId -> executionType lookup once. The DAG is small (handful of stages)  
    }  
    private final ConcurrentMap<String, StageCounters> byStageType = new ConcurrentHashMap<>();  
/**  
                    c.elapsed.snapshot()  
        }
            sumMs.add(valueMs);  
    private static Map<Integer, String> buildStageTypeIndex(QueryDAG dag) {
 */  
                long taskEnd = task.finishedAtMs();
            c.started.increment();
            queriesElapsed.record(executionTimeMs);  
            StageMetrics m = exec.getMetrics();
        addStage(out, dag.rootStage());
     *              failed before execution started  
        if (graph == null) return;
                    case FAILED -> fragmentsFailed.increment();
     * from {@code DefaultPlanExecutor} at terminal — success, failure, or cancellation.  
                    // CREATED / RUNNING — stage didn't reach terminal; don't count toward terminal buckets.
                if (taskElapsed > 0) {
        AnalyticsStats.Queries queries = new AnalyticsStats.Queries(queriesElapsed.snapshot(), queriesPlanning.snapshot());  
        // does per-stage.
    private static void addStage(Map<Integer, String> out, Stage stage) {
import java.util.concurrent.ConcurrentHashMap;
        // execution wall time without a second pass over the graph.  
            fragmentsSucceeded.sum(),  
    }  
            StageCounters c = e.getValue();  
        Map<Integer, String> out = new HashMap<>();  
import org.opensearch.analytics.exec.stage.StageExecution;
     * are dropped. Mirrors the cumulative {@code total_*_duration_ms} /
                    c.succeeded.sum(),
                c.elapsed.record(elapsed);
    }
 * SPDX-License-Identifier: Apache-2.0
        );  
    private final LongAdder fragmentsTotal = new LongAdder();
        // Track the earliest start / latest end across all stages to derive end-to-end
 * terminal — feeding the raw counters straight off the {@link ExecutionGraph}  
/*  
        return out;
     */
 * are {@link LongAdder}s, the per-stage-type bucket map is a
            if (elapsed > 0) {  
        }  
        }
                case SUCCEEDED -> c.succeeded.increment();  
            String execType = stageTypeById.getOrDefault(exec.getStageId(), exec.getClass().getSimpleName());  
     * Walks the {@link ExecutionGraph} directly and feeds {@link LongAdder}s; no
            fragmentsFailed.sum(),
            count.increment();
        long earliestStart = Long.MAX_VALUE;
 * The OpenSearch Contributors require contributions made to  
        final LongAdder rowsProcessedTotal = new LongAdder();
        private final LongAdder sumMs = new LongAdder();
    private static final class StageCounters {
                long taskElapsed = (taskStart > 0 && taskEnd > 0) ? taskEnd - taskStart : 0L;  
    }  
     * @param dag   the DAG that produced the graph; used to resolve each
                    case FINISHED -> fragmentsSucceeded.increment();
    private final LatencyTotals queriesElapsed = new LatencyTotals();  
import org.opensearch.analytics.planner.dag.Stage;  
    private final LongAdder fragmentsFailed = new LongAdder();
            }  
                        // CREATED / RUNNING / CANCELLED — counted in total only.
            StageCounters c = bucket(execType);
     * recording only the planning time.  
        out.put(stage.getStageId(), stage.getExecutionType().name());  
        }  
 * compatible open source license.
                long taskStart = task.startedAtMs();
     * Wait-free count + sum of millisecond elapsed times. Negative recordings
}
                e.getKey(),
                }  
 * this file be licensed under the Apache-2.0 license or a
    }  
    private final LongAdder fragmentsSucceeded = new LongAdder();  
    private final LatencyTotals fragmentsElapsed = new LatencyTotals();
    private static final class LatencyTotals {
            }
            if (start > 0) earliestStart = Math.min(earliestStart, start);  
                    fragmentsElapsed.record(taskElapsed);
    public void recordExecution(ExecutionGraph graph, QueryDAG dag, long planningTimeMs) {  
     *
    /**
        final LongAdder failed = new LongAdder();
        }  
        return new AnalyticsStats(queries, stageMap, fragments);
            c.rowsProcessedTotal.add(m.getRowsProcessed());
 * intentionally avoids it so the hot path stays allocation-free.
import org.opensearch.analytics.exec.stage.StageTask;
 * <p>We intentionally don't compute averages, percentiles, or histograms here
            long elapsed = (start > 0 && end > 0) ? end - start : 0L;
            addStage(out, child);
        final LongAdder succeeded = new LongAdder();
package org.opensearch.analytics.stats;
 *
public final class AnalyticsStatsCollector {
                )
import java.util.HashMap;
        long latestEnd = 0L;
 * {@code count} / {@code sum_ms} totals. Mirrors the contract of the
                default -> {  
                    }
    }
     * @param graph the post-execution graph; may be {@code null} if the query
 * payload still uses {@code QueryProfileBuilder.snapshot()}; the stats path  
                new AnalyticsStats.StageBucket(  
 * {@link ConcurrentHashMap}.  
        Map<String, AnalyticsStats.StageBucket> stageMap = new TreeMap<>();
     * <p>Tolerates a null graph (e.g. failures upstream of execution) by
                    default -> {  
        for (Stage child : stage.getChildStages()) {
            );
import java.util.TreeMap;
            for (StageTask task : exec.tasks()) {
        final LongAdder cancelled = new LongAdder();  
    /**  
        long executionTimeMs = (earliestStart != Long.MAX_VALUE && latestEnd > 0) ? latestEnd - earliestStart : 0L;
 *
