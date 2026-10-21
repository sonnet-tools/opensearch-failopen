                    )
                    List.of(
        when(m.getEndTimeMs()).thenReturn(endMs);
        // we just assert the bucket is populated rather than asserting on the specific key.
    }
        when(t.startedAtMs()).thenReturn(startMs);
        return stage;
        AnalyticsStats.StageBucket shard = c.snapshot().stagesByType().get("SHARD_FRAGMENT");
 * asserts the rollup at {@link AnalyticsStatsCollector#snapshot} reflects them.
        assertEquals(1, shard.cancelled());
        AnalyticsStats.StageBucket shard = c.snapshot().stagesByType().get("SHARD_FRAGMENT");
        long rows,
        assertEquals(1, first.queries().elapsedMs().count());
        QueryDAG dag = dag(stageOf(0, StageExecutionType.SHARD_FRAGMENT, List.of()));
        // StageMetrics records nanoTime internally; mock it so tests can drive exact ms values.
        QueryDAG dag = dag(stageOf(0, StageExecutionType.SHARD_FRAGMENT, List.of()));
    }
        ExecutionGraph graph = mock(ExecutionGraph.class);
import org.opensearch.analytics.exec.stage.StageExecution;
            graphOf(
        when(exec.getState()).thenReturn(state);
        return t;
                    0,
                    StageExecution.State.SUCCEEDED,
        StageMetrics m = mock(StageMetrics.class);
            graphOf(
        assertEquals(1, shard.started());
import org.opensearch.analytics.exec.ExecutionGraph;
    }
        long startMs,
    ) {
        // StageExecution implementation class name rather than dropping the record.
import org.opensearch.analytics.planner.dag.StageExecutionType;
    public void testStageStatesRouteToCorrectCounter() {
    public void testStageWithUnknownTypeIdRoutesToFallback() {
        when(exec.getMetrics()).thenReturn(m);
        long endMs,
    public void testFragmentCountersFromTasks() {
        AnalyticsStats.LatencyStats planning = c.snapshot().queries().planningMs();
        c.recordExecution(
        StageExecution.State state,
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();
            ),
 * SPDX-License-Identifier: Apache-2.0
    private static StageTask taskOf(StageTaskState state, long startMs, long endMs) {
            dag,
        assertEquals(50, reduce.rowsProcessedTotal());
 * The OpenSearch Contributors require contributions made to
        when(graph.queryId()).thenReturn("q-test");
    private static Stage stageOf(int id, StageExecutionType type, List<Stage> children) {
    private static ExecutionGraph graphOf(StageExecution... execs) {
        assertEquals(5, stats.queries().planningMs().sumMs());
    public void testStageBucketsKeyedByExecutionType() {
        assertEquals(12, f.elapsedMs().sumMs());
    public void testRecordsQueryAndPlanningElapsed() {
/*
 */
        c.recordExecution(graphOf(execOf(0, StageExecution.State.SUCCEEDED, 100L, 110L, 0L, List.of())), dag, 1L);
            ),
import org.opensearch.test.OpenSearchTestCase;
        QueryDAG dag = dag(stageOf(0, StageExecutionType.SHARD_FRAGMENT, List.of()));
        when(exec.getStageId()).thenReturn(stageId);
        assertEquals(60, planning.sumMs());
        assertEquals(3, shard.started());
        when(exec.tasks()).thenReturn(tasks);
    }
        assertEquals(1, f.failed());
        AnalyticsStats first = c.snapshot();
import org.opensearch.analytics.planner.dag.QueryDAG;
        assertEquals(90, elapsed.sumMs());
        AnalyticsStats second = c.snapshot();
import org.opensearch.analytics.planner.dag.Stage;
        when(stage.getChildStages()).thenReturn(children);
 * {@link ExecutionGraph}s into {@link AnalyticsStatsCollector#recordExecution} and
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();
            stageOf(0, StageExecutionType.COORDINATOR_REDUCE, List.of(stageOf(1, StageExecutionType.SHARD_FRAGMENT, List.of())))
    }
        StageExecution exec = mock(StageExecution.class);
        return graph;
    }
    }
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();
        assertTrue(stats.stagesByType().isEmpty());
    // ── helpers ──────────────────────────────────────────────────────────────
        assertEquals("sum cumulative across snapshots", 40, second.queries().elapsedMs().sumMs());
        int stageId,
 * compatible open source license.
        when(stage.getExecutionType()).thenReturn(type);
import java.util.List;
            graphOf(
    public void testNullGraphRecordsOnlyPlanning() {
        );
        );
            ),
        assertEquals(0, shard.failed());
        assertEquals(2, planning.count());
        assertEquals(1, reduce.started());
import org.opensearch.analytics.exec.stage.StageTask;
        Stage stage = mock(Stage.class);
        assertNotNull(shard);
        AnalyticsStats.StageBucket reduce = c.snapshot().stagesByType().get("COORDINATOR_REDUCE");
    }
        assertEquals("count cumulative across snapshots", 2, second.queries().elapsedMs().count());
        assertEquals(1, shard.succeeded());
        assertEquals(1, stats.queries().planningMs().count());
    private static QueryDAG dag(Stage rootStage) {
 * this file be licensed under the Apache-2.0 license or a
                execOf(0, StageExecution.State.SUCCEEDED, 100L, 103L, 50L, List.of()),
        when(stage.getStageId()).thenReturn(id);
import org.opensearch.analytics.exec.stage.StageMetrics;
                )
        assertEquals(2, f.succeeded());
}
        );
package org.opensearch.analytics.stats;
            1L
        when(t.state()).thenReturn(state);
        QueryDAG dag = dag(stageOf(0, StageExecutionType.SHARD_FRAGMENT, List.of()));
        c.recordExecution(
import static org.mockito.Mockito.when;
        assertEquals(8, shard.elapsedMs().sumMs());
                execOf(0, StageExecution.State.CANCELLED, 100L, 101L, 0L, List.of())
    }
        StageTask t = mock(StageTask.class);
        when(m.getStartTimeMs()).thenReturn(startMs);
        // The default exec mock's getClass().getSimpleName() is the Mockito-generated proxy name;
        assertEquals(0, stats.fragments().total());
        assertNotNull(reduce);
        c.recordExecution(null, null, 5L);
        AnalyticsStats.Fragments f = c.snapshot().fragments();
                execOf(0, StageExecution.State.SUCCEEDED, 100L, 101L, 0L, List.of()),
        when(m.getRowsProcessed()).thenReturn(rows);
                        taskOf(StageTaskState.FINISHED, 100L, 104L),
        assertEquals(1, shard.succeeded());
    }
        StageExecution exec = execOf(99, StageExecution.State.SUCCEEDED, 100L, 105L, 0L, List.of());
        when(graph.allExecutions()).thenReturn(List.of(execs));
        assertEquals(2, elapsed.count());
        c.recordExecution(graphOf(execOf(0, StageExecution.State.SUCCEEDED, 100L, 130L, 0L, List.of())), dag, 15L);
        );
        assertEquals(3, f.elapsedMs().count());
        assertEquals(1, shard.failed());
            1L
                    110L,
        assertEquals(3, f.total());
        assertEquals(3, reduce.elapsedMs().sumMs());
    }
        AnalyticsStats.LatencyStats elapsed = c.snapshot().queries().elapsedMs();
                execOf(
 * Unit tests for {@link AnalyticsStatsCollector}. Feeds synthetic
                    100L,
        assertEquals(1, c.snapshot().stagesByType().size());
        when(t.finishedAtMs()).thenReturn(endMs);
        QueryDAG dag = dag(stageOf(0, StageExecutionType.SHARD_FRAGMENT, List.of()));
 */
        QueryDAG dag = dag(
public class AnalyticsStatsCollectorTests extends OpenSearchTestCase {
        c.recordExecution(graphOf(execOf(0, StageExecution.State.SUCCEEDED, 200L, 230L, 0L, List.of())), dag, 1L);
            dag,
        return new QueryDAG("q-test", rootStage);
        return exec;
        List<StageTask> tasks
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();
import static org.mockito.Mockito.mock;
                        taskOf(StageTaskState.FAILED, 100L, 102L)
        assertEquals(0, stats.queries().elapsedMs().count());
        AnalyticsStats stats = c.snapshot();
                execOf(0, StageExecution.State.FAILED, 100L, 101L, 0L, List.of()),
            dag,
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();
                        taskOf(StageTaskState.FINISHED, 100L, 106L),
/**
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();
                execOf(1, StageExecution.State.SUCCEEDED, 100L, 108L, 200L, List.of())
        assertEquals(200, shard.rowsProcessedTotal());
        c.recordExecution(
        c.recordExecution(graphOf(exec), dag, 1L);
                    5L,
    public void testSnapshotIsCumulative() {
    }
            10L
    private static StageExecution execOf(
        c.recordExecution(graphOf(execOf(0, StageExecution.State.SUCCEEDED, 200L, 260L, 0L, List.of())), dag, 45L);
 *
        // Graph has a stage with id=99 that the DAG doesn't know about — fall back to the
import org.opensearch.analytics.exec.stage.StageTaskState;
