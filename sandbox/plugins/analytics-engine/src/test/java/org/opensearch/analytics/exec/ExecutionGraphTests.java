    }
        Stage grandchild = stageOf(2, StageExecutionType.SHARD_FRAGMENT, List.of());
 * compatible open source license.
        public void addStateListener(org.opensearch.analytics.exec.stage.StageStateListener listener) {}
        builder.registerFactory(StageExecutionType.SHARD_FRAGMENT, (stage, sink, cfg) -> { throw buildFailure; });
    private static Stage stageOf(int id, StageExecutionType type, List<Stage> children) {
    /** Minimal stage stub that counts cancel() calls and implements DataProducer + DataConsumer
import java.util.List;
 * Tests for {@link ExecutionGraph} build / cleanup paths — focused on
            List.of(stageOf(1, StageExecutionType.SHARD_FRAGMENT, List.of()))
            }
     * still get a chance to cancel. The first cancel failure is rethrown with later
        when(stage.getStageId()).thenReturn(id);
        RuntimeException buildFailure = new RuntimeException("child build failure");
            return state;
            return new org.opensearch.analytics.exec.stage.StageMetrics();
                @Override
        Stage child = stageOf(1, StageExecutionType.SHARD_FRAGMENT, List.of(grandchild));
        @Override
            0,
        }
            StageExecutionType.LOCAL_PASSTHROUGH,
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, sink, cfg) -> {
        public State getState() {
    }
     * must have {@code cancel(...)} called exactly once (cleanup) and the original failure
        @Override
        StageExecutionBuilder builder = new StageExecutionBuilder(mock(org.opensearch.cluster.service.ClusterService.class), null);
        QueryContext ctx = newContext(root);
import static org.mockito.Mockito.mock;
        // Child factory throws — simulates a backend init failure during recursive build.
import java.util.Map;
        }
            return new CountingCancelStage(stage.getStageId(), goodStageCancels);
                public void cancel(String reason) {
        // build failure NOT in the chain — build's `finally` reruns cleanup which throws.
        }
import org.opensearch.analytics.planner.dag.QueryDAG;
 */
import static org.mockito.Mockito.when;
        private final AtomicInteger cancelCounter;
     * cancelPartialBuild's contract: if one stage's cancel() throws, subsequent stages
 *
        CountingCancelStage(int stageId, AtomicInteger cancelCounter) {
        public org.opensearch.analytics.exec.stage.StageMetrics getMetrics() {
    private static class CountingCancelStage implements org.opensearch.analytics.exec.stage.SinkProvidingStageExecution {
            1L,
        return stage;
 * {@link ExecutionGraph#build} failure handling that's otherwise reached only via integration.
        Stage rootStage = stageOf(
        });
        AtomicInteger rootCancels = new AtomicInteger();
        when(stage.getExecutionType()).thenReturn(type);
        @Override
import org.opensearch.analytics.planner.dag.StageExecutionType;
        AnalyticsQueryTask task = new AnalyticsQueryTask(
            "analytics_query",
        private State state = State.CREATED;
            if (stage.getStageId() == 2) throw new RuntimeException("late build failure");
        RuntimeException thrown = expectThrows(RuntimeException.class, () -> ExecutionGraph.build(ctx, builder, s -> {}));
     * must propagate to the caller.
        assertNotNull(thrown);
        @Override
        }
        );
 */
                }
        Throwable thrown = expectThrows(Throwable.class, () -> ExecutionGraph.build(ctx, builder, s -> {}));
        StageExecutionBuilder builder = new StageExecutionBuilder(mock(org.opensearch.cluster.service.ClusterService.class), null);
            return new CountingCancelStage(stage.getStageId(), rootCancels);
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.atomic.AtomicInteger;
            return sink;
        assertEquals("sibling stage 1 was cancelled despite root's cancel throwing", 1, goodStageCancels.get());
        builder.registerFactory(
                    throw new IllegalStateException("root cancel failure");
        Stage root = stageOf(0, StageExecutionType.LOCAL_PASSTHROUGH, List.of(child));
            if (cancelCounter != null) cancelCounter.incrementAndGet();
    /**
        // First child builds; second-level child throws to trigger cancelPartialBuild.
     * failures attached as suppressed.
        @Override
     */
/*
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.planner.dag.Stage;
        public Exception getFailure() {
     */
        QueryDAG dag = new QueryDAG("q-test", rootStage);
     * When a child-stage factory throws during recursive build, every already-built stage
            StageExecutionType.LOCAL_PASSTHROUGH,
            state = State.CANCELLED;
        builder.registerFactory(StageExecutionType.SHARD_FRAGMENT, (stage, sink, cfg) -> {
            Map.of(),
        public void cancel(String reason) {
    }
        }
        }
}
        private final org.opensearch.analytics.exec.RowProducingSink sink = new org.opensearch.analytics.exec.RowProducingSink();
import org.opensearch.core.tasks.TaskId;
package org.opensearch.analytics.exec;
        // cancelPartialBuild rethrows the first cancel failure (root's ISE), with the
        QueryContext ctx = newContext(rootStage);
        );
            (stage, sink, cfg) -> new CountingCancelStage(stage.getStageId(), null) {
        Stage stage = mock(Stage.class);
        // Either the build RuntimeException OR the cancel ISE may surface — both indicate
     *  so the builder can wire child sinks off it. */
        // Root factory returns a stage that records cancel() calls.
            this.cancelCounter = cancelCounter;
        }
    // ── helpers ──────────────────────────────────────────────────────────
            onStarted.onResponse(null);
 * The OpenSearch Contributors require contributions made to
/**
        @Override
    }
        AtomicInteger goodStageCancels = new AtomicInteger();
    private static QueryContext newContext(Stage rootStage) {
    }
            // Second SHARD_FRAGMENT throws on construction (simulating mid-recursion failure)
            this.stageId = stageId;
            "transport",
            null
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
        }
        private final int stageId;
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
            "q-test",
        }
        public void start(ActionListener<Void> onStarted) {
    public void testCancelPartialBuildCancelsAlreadyBuiltStagesAndPropagatesOriginalFailure() {
        public int getStageId() {
    /**
        @Override
    public void testCancelPartialBuildSweepsAllStagesEvenWhenOneCancelThrows() {
        public org.opensearch.analytics.spi.ExchangeSink inputSink(int childStageId) {
        return QueryContext.forTest(dag, task);
        // partial-build cleanup ran. The important contract: the good sibling was cancelled.
        when(stage.getChildStages()).thenReturn(children);
        public org.opensearch.analytics.backend.ExchangeSource outputSource() {
        assertSame("original build failure propagated", buildFailure, thrown);
        // Root: a stage whose cancel() throws ISE — should not block sibling cleanup.
        @Override
        });
            TaskId.EMPTY_TASK_ID,
            return null;
            return sink;
public class ExecutionGraphTests extends OpenSearchTestCase {
        assertEquals("partial-build cleanup invoked cancel() on already-built root stage", 1, rootCancels.get());
        @Override
        );
import org.opensearch.core.action.ActionListener;
            return stageId;
import org.opensearch.test.OpenSearchTestCase;
