        assertEquals(60, planning.sumMs());  
        AnalyticsStats stats = c.snapshot();
        c.recordExecution(graphOf(execOf(0, StageExecution.State.SUCCEEDED, 100L, 130L, 0L, List.of())), dag, 15L);  
    }
        when(exec.tasks()).thenReturn(tasks);
            dag,
            dag,
    public void testFragmentCountersFromTasks() {
        assertEquals(3, f.elapsedMs().count());  
                execOf(0, StageExecution.State.SUCCEEDED, 100L, 101L, 0L, List.of()),
        AnalyticsStats second = c.snapshot();
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();
        ExecutionGraph graph = mock(ExecutionGraph.class);  
        // we just assert the bucket is populated rather than asserting on the specific key.  
package org.opensearch.analytics.stats;
        return graph;  
        assertEquals(8, shard.elapsedMs().sumMs());
        assertEquals(0, stats.fragments().total());  
        assertEquals(1, shard.failed());  
        int stageId,
        when(m.getRowsProcessed()).thenReturn(rows);  
 * SPDX-License-Identifier: Apache-2.0
        long rows,
import org.opensearch.analytics.exec.stage.StageTaskState;
        StageTask t = mock(StageTask.class);
        assertEquals(1, shard.succeeded());
        QueryDAG dag = dag(stageOf(0, StageExecutionType.SHARD_FRAGMENT, List.of()));
    private static QueryDAG dag(Stage rootStage) {
import org.opensearch.analytics.planner.dag.Stage;
        when(stage.getStageId()).thenReturn(id);
public class AnalyticsStatsCollectorTests extends OpenSearchTestCase {  
        Stage stage = mock(Stage.class);
        assertEquals(1, shard.succeeded());
        when(stage.getChildStages()).thenReturn(children);
            1L  
            10L
        assertEquals(2, planning.count());
        when(m.getStartTimeMs()).thenReturn(startMs);
            1L
        long startMs,  
    }  
    public void testStageStatesRouteToCorrectCounter() {
        when(t.startedAtMs()).thenReturn(startMs);  
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals(1, shard.cancelled());
        List<StageTask> tasks  
 */
    public void testRecordsQueryAndPlanningElapsed() {
import static org.mockito.Mockito.mock;
        // StageMetrics records nanoTime internally; mock it so tests can drive exact ms values.
        assertEquals(3, reduce.elapsedMs().sumMs());
        c.recordExecution(graphOf(exec), dag, 1L);  
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();  
        AnalyticsStats.StageBucket reduce = c.snapshot().stagesByType().get("COORDINATOR_REDUCE");
        AnalyticsStats.StageBucket shard = c.snapshot().stagesByType().get("SHARD_FRAGMENT");  
                execOf(0, StageExecution.State.CANCELLED, 100L, 101L, 0L, List.of())  
    }
        );  
        assertEquals(50, reduce.rowsProcessedTotal());
        assertEquals(200, shard.rowsProcessedTotal());
    }
        assertEquals(1, first.queries().elapsedMs().count());
        );  
                        taskOf(StageTaskState.FINISHED, 100L, 106L),
        c.recordExecution(
 * {@link ExecutionGraph}s into {@link AnalyticsStatsCollector#recordExecution} and  
        StageExecution exec = execOf(99, StageExecution.State.SUCCEEDED, 100L, 105L, 0L, List.of());
        return exec;  
        assertEquals(0, shard.failed());  
        // Graph has a stage with id=99 that the DAG doesn't know about — fall back to the
        c.recordExecution(graphOf(execOf(0, StageExecution.State.SUCCEEDED, 200L, 260L, 0L, List.of())), dag, 45L);
    }
        AnalyticsStats.StageBucket shard = c.snapshot().stagesByType().get("SHARD_FRAGMENT");
    public void testStageBucketsKeyedByExecutionType() {  
        long endMs,
        QueryDAG dag = dag(
            ),
        AnalyticsStats first = c.snapshot();  
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();
    }
                )
        StageExecution.State state,
        QueryDAG dag = dag(stageOf(0, StageExecutionType.SHARD_FRAGMENT, List.of()));
        assertEquals(1, shard.started());
import java.util.List;
        assertEquals(3, shard.started());
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.analytics.exec.stage.StageExecution;
    private static StageTask taskOf(StageTaskState state, long startMs, long endMs) {  
    }
    public void testSnapshotIsCumulative() {
import org.opensearch.analytics.planner.dag.StageExecutionType;
            ),  
 *
 * The OpenSearch Contributors require contributions made to  
            graphOf(  
        assertNotNull(shard);  
        assertEquals(90, elapsed.sumMs());
        when(exec.getStageId()).thenReturn(stageId);  
    }
            stageOf(0, StageExecutionType.COORDINATOR_REDUCE, List.of(stageOf(1, StageExecutionType.SHARD_FRAGMENT, List.of())))  
        StageMetrics m = mock(StageMetrics.class);  
        when(t.state()).thenReturn(state);
    public void testNullGraphRecordsOnlyPlanning() {  
                    0,
        QueryDAG dag = dag(stageOf(0, StageExecutionType.SHARD_FRAGMENT, List.of()));  
    }  
    }  
        assertEquals("sum cumulative across snapshots", 40, second.queries().elapsedMs().sumMs());  
                    110L,
/*  
        assertEquals(5, stats.queries().planningMs().sumMs());  
        assertEquals(1, reduce.started());  
        // The default exec mock's getClass().getSimpleName() is the Mockito-generated proxy name;
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();  
        assertEquals(1, f.failed());
    }
import org.opensearch.analytics.exec.stage.StageMetrics;  
        when(exec.getMetrics()).thenReturn(m);
 * asserts the rollup at {@link AnalyticsStatsCollector#snapshot} reflects them.
                    100L,  
            dag,
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();
    private static ExecutionGraph graphOf(StageExecution... execs) {
    public void testStageWithUnknownTypeIdRoutesToFallback() {  
        assertEquals(1, stats.queries().planningMs().count());
        when(exec.getState()).thenReturn(state);
}
                    5L,
                    List.of(  
            graphOf(
        c.recordExecution(
        when(stage.getExecutionType()).thenReturn(type);  
import org.opensearch.analytics.exec.ExecutionGraph;
                execOf(0, StageExecution.State.SUCCEEDED, 100L, 103L, 50L, List.of()),
        assertEquals(2, elapsed.count());
        QueryDAG dag = dag(stageOf(0, StageExecutionType.SHARD_FRAGMENT, List.of()));
        assertTrue(stats.stagesByType().isEmpty());
    ) {
                execOf(0, StageExecution.State.FAILED, 100L, 101L, 0L, List.of()),
        assertNotNull(reduce);
        when(t.finishedAtMs()).thenReturn(endMs);
        StageExecution exec = mock(StageExecution.class);
        when(m.getEndTimeMs()).thenReturn(endMs);
        return stage;
                        taskOf(StageTaskState.FAILED, 100L, 102L)  
        );
        assertEquals(12, f.elapsedMs().sumMs());
        c.recordExecution(graphOf(execOf(0, StageExecution.State.SUCCEEDED, 100L, 110L, 0L, List.of())), dag, 1L);
        return new QueryDAG("q-test", rootStage);  
import org.opensearch.analytics.planner.dag.QueryDAG;  
        AnalyticsStats.Fragments f = c.snapshot().fragments();
        AnalyticsStats.LatencyStats elapsed = c.snapshot().queries().elapsedMs();  
                execOf(1, StageExecution.State.SUCCEEDED, 100L, 108L, 200L, List.of())
    private static StageExecution execOf(  
        assertEquals(0, stats.queries().elapsedMs().count());
                    )
        c.recordExecution(null, null, 5L);
                    StageExecution.State.SUCCEEDED,
        assertEquals(2, f.succeeded());
 * compatible open source license.
    // ── helpers ──────────────────────────────────────────────────────────────
        when(graph.queryId()).thenReturn("q-test");
            ),  
        );
        c.recordExecution(graphOf(execOf(0, StageExecution.State.SUCCEEDED, 200L, 230L, 0L, List.of())), dag, 1L);  
 * Unit tests for {@link AnalyticsStatsCollector}. Feeds synthetic
        assertEquals(1, c.snapshot().stagesByType().size());
                execOf(  
    private static Stage stageOf(int id, StageExecutionType type, List<Stage> children) {  
        // StageExecution implementation class name rather than dropping the record.
        AnalyticsStats.LatencyStats planning = c.snapshot().queries().planningMs();
 */  
        assertEquals(3, f.total());  
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();  
        assertEquals("count cumulative across snapshots", 2, second.queries().elapsedMs().count());
            graphOf(  
/**
        c.recordExecution(
import static org.mockito.Mockito.when;
        AnalyticsStatsCollector c = new AnalyticsStatsCollector();
                        taskOf(StageTaskState.FINISHED, 100L, 104L),
import org.opensearch.analytics.exec.stage.StageTask;
        QueryDAG dag = dag(stageOf(0, StageExecutionType.SHARD_FRAGMENT, List.of()));  
        when(graph.allExecutions()).thenReturn(List.of(execs));
        return t;
