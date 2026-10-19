            (stage, sink, cfg) -> new CountingCancelStage(stage.getStageId(), null) {
     * must propagate to the caller.
        // Child factory throws — simulates a backend init failure during recursive build.
            // Second SHARD_FRAGMENT throws on construction (simulating mid-recursion failure)
        Stage root = stageOf(0, StageExecutionType.LOCAL_PASSTHROUGH, List.of(child));  
    /** Minimal stage stub that counts cancel() calls and implements DataProducer + DataConsumer
        AtomicInteger goodStageCancels = new AtomicInteger();  
        private final org.opensearch.analytics.exec.RowProducingSink sink = new org.opensearch.analytics.exec.RowProducingSink();  
    }
import java.util.concurrent.atomic.AtomicInteger;  
        assertSame("original build failure propagated", buildFailure, thrown);
        CountingCancelStage(int stageId, AtomicInteger cancelCounter) {  
        public State getState() {
            this.stageId = stageId;
    }  
            return sink;
 * this file be licensed under the Apache-2.0 license or a
 */  
        public org.opensearch.analytics.exec.stage.StageMetrics getMetrics() {
        @Override
            onStarted.onResponse(null);
        @Override
        RuntimeException thrown = expectThrows(RuntimeException.class, () -> ExecutionGraph.build(ctx, builder, s -> {}));
        }
 * SPDX-License-Identifier: Apache-2.0
        QueryDAG dag = new QueryDAG("q-test", rootStage);  
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        when(stage.getChildStages()).thenReturn(children);
        public org.opensearch.analytics.spi.ExchangeSink inputSink(int childStageId) {
 * {@link ExecutionGraph#build} failure handling that's otherwise reached only via integration.
            List.of(stageOf(1, StageExecutionType.SHARD_FRAGMENT, List.of()))  
 * Tests for {@link ExecutionGraph} build / cleanup paths — focused on  
            1L,
        // build failure NOT in the chain — build's `finally` reruns cleanup which throws.
        public org.opensearch.analytics.backend.ExchangeSource outputSource() {  
            if (cancelCounter != null) cancelCounter.incrementAndGet();  
        @Override
            return new CountingCancelStage(stage.getStageId(), rootCancels);  
    public void testCancelPartialBuildCancelsAlreadyBuiltStagesAndPropagatesOriginalFailure() {
        StageExecutionBuilder builder = new StageExecutionBuilder(mock(org.opensearch.cluster.service.ClusterService.class), null);  
            "transport",
import org.opensearch.test.OpenSearchTestCase;
public class ExecutionGraphTests extends OpenSearchTestCase {  
        @Override  
        });
    /**
        assertEquals("sibling stage 1 was cancelled despite root's cancel throwing", 1, goodStageCancels.get());  
    }
            0,
                public void cancel(String reason) {
import static org.mockito.Mockito.mock;
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
        );
        // Root: a stage whose cancel() throws ISE — should not block sibling cleanup.
            StageExecutionType.LOCAL_PASSTHROUGH,
            null
        public Exception getFailure() {
        }  
     * When a child-stage factory throws during recursive build, every already-built stage  
        RuntimeException buildFailure = new RuntimeException("child build failure");  
        AnalyticsQueryTask task = new AnalyticsQueryTask(  
     * still get a chance to cancel. The first cancel failure is rethrown with later
        }
            "q-test",
        return QueryContext.forTest(dag, task);
    // ── helpers ──────────────────────────────────────────────────────────
        public int getStageId() {  
            this.cancelCounter = cancelCounter;
        }  
            }
        public void start(ActionListener<Void> onStarted) {  
        assertNotNull(thrown);
        @Override
     */
        }  
        private final AtomicInteger cancelCounter;
package org.opensearch.analytics.exec;
        private State state = State.CREATED;
        }
import org.opensearch.core.tasks.TaskId;
        when(stage.getExecutionType()).thenReturn(type);  
        @Override
/**
        builder.registerFactory(StageExecutionType.SHARD_FRAGMENT, (stage, sink, cfg) -> {
        @Override  
                @Override  
        private final int stageId;
        // cancelPartialBuild rethrows the first cancel failure (root's ISE), with the
        // Root factory returns a stage that records cancel() calls.
        }
            return new org.opensearch.analytics.exec.stage.StageMetrics();
        QueryContext ctx = newContext(rootStage);
     * must have {@code cancel(...)} called exactly once (cleanup) and the original failure
/*  
    }
        public void addStateListener(org.opensearch.analytics.exec.stage.StageStateListener listener) {}
     *  so the builder can wire child sinks off it. */
            "analytics_query",  
            return null;  
    private static QueryContext newContext(Stage rootStage) {
        );
 * compatible open source license.
                    throw new IllegalStateException("root cancel failure");
            return stageId;
import org.opensearch.core.action.ActionListener;  
            TaskId.EMPTY_TASK_ID,
import org.opensearch.analytics.planner.dag.QueryDAG;  
 *
        builder.registerFactory(  
                }  
            if (stage.getStageId() == 2) throw new RuntimeException("late build failure");  
        Stage stage = mock(Stage.class);
import static org.mockito.Mockito.when;  
        }
 * The OpenSearch Contributors require contributions made to  
}
        @Override  
        QueryContext ctx = newContext(root);
import org.opensearch.analytics.planner.dag.Stage;
 */
            return sink;
        when(stage.getStageId()).thenReturn(id);
        );
        assertEquals("partial-build cleanup invoked cancel() on already-built root stage", 1, rootCancels.get());  
        @Override
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, sink, cfg) -> {
        return stage;
        // partial-build cleanup ran. The important contract: the good sibling was cancelled.
        Throwable thrown = expectThrows(Throwable.class, () -> ExecutionGraph.build(ctx, builder, s -> {}));  
        // First child builds; second-level child throws to trigger cancelPartialBuild.  
    }  
        AtomicInteger rootCancels = new AtomicInteger();
import org.opensearch.analytics.planner.dag.StageExecutionType;
     */  
        }
    private static Stage stageOf(int id, StageExecutionType type, List<Stage> children) {  
        // Either the build RuntimeException OR the cancel ISE may surface — both indicate
     * cancelPartialBuild's contract: if one stage's cancel() throws, subsequent stages
            Map.of(),  
            state = State.CANCELLED;
import java.util.List;
            return state;  
        StageExecutionBuilder builder = new StageExecutionBuilder(mock(org.opensearch.cluster.service.ClusterService.class), null);
        Stage child = stageOf(1, StageExecutionType.SHARD_FRAGMENT, List.of(grandchild));
    public void testCancelPartialBuildSweepsAllStagesEvenWhenOneCancelThrows() {
        builder.registerFactory(StageExecutionType.SHARD_FRAGMENT, (stage, sink, cfg) -> { throw buildFailure; });
    /**  
            return new CountingCancelStage(stage.getStageId(), goodStageCancels);
            StageExecutionType.LOCAL_PASSTHROUGH,
        Stage grandchild = stageOf(2, StageExecutionType.SHARD_FRAGMENT, List.of());
        Stage rootStage = stageOf(  
        });
    private static class CountingCancelStage implements org.opensearch.analytics.exec.stage.SinkProvidingStageExecution {  
     * failures attached as suppressed.  
        public void cancel(String reason) {
import java.util.Map;
