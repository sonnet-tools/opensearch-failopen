            transitionTo(State.SUCCEEDED);
import org.opensearch.analytics.exec.stage.coordinator.LocalStageTask;
 * SPDX-License-Identifier: Apache-2.0
            "q-test",
        when(transportService.getTaskManager()).thenReturn(mock(TaskManager.class));
    }
        void doCancel() {
            transitionTo(State.CANCELLED);
        stageRef.get().doSucceed();
    /**
        }
        stageRef.get().doCancel();
            stageRef.set(exec);
    /**
    @Override
 */
        List<AnalyticsOperationListener> listeners,
        @Override
        when(stage.getStageId()).thenReturn(id);
        public void onStageCancelled(String queryId, int stageId, String reason) {
        @SuppressWarnings({ "unchecked", "rawtypes" })
        new QueryScheduler(builder, transportService).execute(ctx, userListener);
        stageRef.get().doFail(new RuntimeException("stage failed"));
        executeViaScheduler(rootStage, List.of(recording), ActionListener.wrap(r -> fail("unexpected success"), e -> {}));
        @Override
            return exec;
        });
        }
        assertEquals(List.of("onQueryStart:1", "onStageStart:0", "onQuerySuccess", "onStageSuccess:0"), recording.events);
        AtomicReference<TestableRootExecution> stageRef = new AtomicReference<>();
            return new TestableRootExecution(stage, new NoopSink(), cfg) {
    private StageExecutionBuilder builder;
            events.add("onStageStart:" + stageId);
        @Override
            events.add("onStageCancelled:" + stageId);
        public void close() {}
 * {@link QueryContext#operationListeners()}, drives the full {@link QueryScheduler} →
        AtomicReference<TestableRootExecution> stageRef = new AtomicReference<>();
        builder = new StageExecutionBuilder(mock(ClusterService.class), null);
        @Override
        ActionListener<Iterable<VectorSchemaRoot>> userListener
        assertEquals(List.of("onQueryStart:1", "onStageStart:0", "onQueryFailure", "onStageFailure:0"), recording.events);
import org.opensearch.test.OpenSearchTestCase;
        public ExchangeSource outputSource() {
     * the QueryExecution root-state mirror that drives the query terminal inline) before
}
import org.opensearch.analytics.planner.dag.Stage;
            this.source = source;
        @Override
            TestableRootExecution exec = new TestableRootExecution(stage, new NoopSink(), cfg);
        }
 * compatible open source license.
    private static final class NoopSink implements org.opensearch.analytics.spi.ExchangeSink, ExchangeSource {
        public void onStageFailure(String queryId, int stageId, Exception cause) {
        });
        QueryContext ctx = QueryContext.forTest(dag, task, listeners);
        }
        @Override
        }
        @Override
import static org.mockito.Mockito.mock;
 * End-to-end coverage of {@link AnalyticsOperationListener} coordinator-side callbacks
        }
public class OperationListenerCoverageTests extends OpenSearchTestCase {
        }
    private static final class RecordingListener implements AnalyticsOperationListener {
        public void feed(VectorSchemaRoot batch) {
 * The OpenSearch Contributors require contributions made to
        }
            return exec;
            return List.of(new LocalStageTask(new StageTaskId(getStageId(), 0), l -> l.onResponse(null)));
     * ({@code fireOperationListeners}). {@link #materializeTasks} returns one no-op task so
        Stage rootStage = stageWithId(0);
    public void testListenerFailurePath() {
import static org.mockito.Mockito.when;
 * See the TODO in {@code AnalyticsOperationListener}.
        @Override
        }
        final List<String> events = new ArrayList<>();
    /**
            return Collections.emptyList();
    }
        public void onStageSuccess(String queryId, int stageId, String stageType, long tookInNanos, long rowsProcessed) {
        public void onQueryFailure(String queryId, Exception cause) {
import org.opensearch.analytics.planner.dag.QueryDAG;
 * {@link AbstractStageExecution} and exercise its real listener-firing wiring.
     * fired-set + ordering against a single {@code List<String>}.
     * {@link #start} transitions to RUNNING (not the empty-list short-circuit to SUCCEEDED);
    public void setUp() throws Exception {
     * fires onQueryFailure (cancellation is an abnormal termination from the user-facing
                }
    private static Stage stageWithId(int id) {
import org.opensearch.analytics.planner.dag.StageExecutionType;
            events.add("onQueryStart:" + stageCount);
            super(stage, cfg.queryId(), cfg.operationListeners(), cfg.parentTask());
                    return List.of();
     * Direct {@code CREATED → terminal} (e.g. empty target resolution skipping RUNNING)
            events.add("onStageSuccess:" + stageId);
    // ── helpers ─────────────────────────────────────────────────────────
        Stage rootStage = stageWithId(0);
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, sink, cfg) -> {
/*
            TaskId.EMPTY_TASK_ID,
     * because {@code AbstractStageExecution.transitionTo} fires state listeners (which include
 * <p>Lives in the {@code .stage} package so the test stage can extend the package-private
    }
        );
    private static class TestableRootExecution extends AbstractStageExecution implements DataProducer {
import org.opensearch.analytics.exec.QueryContext;
        void doSucceed() {
        TestableRootExecution(Stage stage, ExchangeSource source, QueryContext cfg) {
        RecordingListener recording = new RecordingListener();
    /** Empty terminal sink that doubles as a row-producing source — read returns empty. */
import org.opensearch.tasks.TaskManager;
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, sink, cfg) -> {
            transitionTo(State.FAILED);
        }
        RecordingListener recording = new RecordingListener();
        }
     * update it explicitly rather than silently.
     * Test stage that extends {@link AbstractStageExecution} so its state transitions
        super.setUp();
     * Records every fired callback as a short {@code name[:detail]} label so tests assert
                @Override
            this.runner = (org.opensearch.analytics.exec.task.TaskRunner) (task, listener) -> {};
     */
     * firing operation listeners. The test pins this order — if the order ever changes,
 *
 * across happy / failure / cancellation paths. Wires a {@link RecordingListener} through
    /**
            };
            1L,
package org.opensearch.analytics.exec.stage;
        public void onQuerySuccess(String queryId, long tookInNanos, long totalRows) {
 * <p>Out of scope: data-node fragment callbacks ({@code onPreFragmentExecution} etc.) —
            events.add("onQueryFailure");
        }
            captureFailure(cause);
 * those need a plugin SPI to inject a fragment listener into {@code AnalyticsSearchService}.
        assertEquals(List.of("onQueryStart:1", "onQuerySuccess", "onStageStart:0", "onStageSuccess:0"), recording.events);
    private void executeViaScheduler(
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, sink, cfg) -> {
        Stage stage = mock(Stage.class);
        TransportService transportService = mock(TransportService.class);
        public void onStageStart(String queryId, int stageId, String stageType) {
                protected List<StageTask> materializeTasks() {
import org.opensearch.core.tasks.TaskId;
 *
import java.util.Map;
 * {@link AbstractStageExecution} pipeline, and asserts the fired-set + ordering for each
     *
        Stage rootStage = stageWithId(0);
    ) {
            return 0;
     */
/**
        when(stage.getChildStages()).thenReturn(List.of());
import org.opensearch.analytics.exec.QueryScheduler;
        }
import java.util.concurrent.atomic.AtomicReference;
        @Override
    public void testListenerSynthesisesStageStartForDirectCreatedToTerminal() {
        AtomicReference<TestableRootExecution> stageRef = new AtomicReference<>();
        Stage rootStage = stageWithId(0);
            TestableRootExecution exec = new TestableRootExecution(stage, new NoopSink(), cfg);
 */
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
     * fire {@code AnalyticsOperationListener} callbacks through the real production wiring
 *
    }
     * Cancellation path: stage CANCELLED surfaces as onStageCancelled. The wrapper-listener
        }
            return exec;
        public void onQueryStart(String queryId, int stageCount) {
import java.util.List;
     */
        executeViaScheduler(rootStage, List.of(recording), ActionListener.wrap(r -> {}, e -> {}));
        public Iterable<VectorSchemaRoot> readResult() {
     * listener's perspective) — same query-terminal-before-stage-terminal ordering.
        when(stage.getExecutionType()).thenReturn(StageExecutionType.LOCAL_PASSTHROUGH);
import org.opensearch.transport.TransportService;
        private final ExchangeSource source;
        RecordingListener recording = new RecordingListener();
        }
        @Override
        }
        @Override
     * Happy path: {@code onQueryStart → onStageStart → onQuerySuccess → onStageSuccess}.
        assertEquals(List.of("onQueryStart:1", "onStageStart:0", "onQueryFailure", "onStageCancelled:0"), recording.events);
        AnalyticsQueryTask task = new AnalyticsQueryTask(
            // Stage whose start() goes CREATED → SUCCEEDED directly (no RUNNING): materialise
     * terminal event for a stage they didn't see start.
     */
import java.util.Collections;
            TestableRootExecution exec = new TestableRootExecution(stage, new NoopSink(), cfg);
        executeViaScheduler(rootStage, List.of(recording), ActionListener.wrap(r -> fail("unexpected success"), e -> {}));
     */
 * lifecycle.
        return stage;
     * tests then drive terminal transitions via {@code doSucceed}/{@code doFail}.
    }
            "transport",
        QueryDAG dag = new QueryDAG("q-test", rootStage);
    }
    }
        Stage rootStage,
        });
import java.util.ArrayList;
            stageRef.set(exec);
import org.opensearch.analytics.backend.AnalyticsOperationListener;
    }
            events.add("onStageFailure:" + stageId);
        executeViaScheduler(rootStage, List.of(recording), ActionListener.wrap(r -> {}, e -> {}));
    /** Failure path: same ordering invariant — query terminal fires inline before stage operation callback. */
import org.opensearch.core.action.ActionListener;
            stageRef.set(exec);
     * <p>The query terminal callback fires <i>before</i> the stage's own operation callback
import org.opensearch.cluster.service.ClusterService;
    public void testListenerHappyPath() {
        public long getRowCount() {
import org.opensearch.analytics.backend.ExchangeSource;
     * still surfaces an {@code onStageStart} synthetically — observers never see a
import org.apache.arrow.vector.VectorSchemaRoot;
            batch.close();
            Map.of(),
    public void testListenerCancellationPath() {
            // an empty task list, which the base short-circuits to SUCCEEDED.
            // transitions via doSucceed/doFail; dispatch must not race them.
    }
            // Park runner: accept the task but never signal terminal. Tests drive
    /**
            "analytics_query",
            return source;
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, sink, cfg) -> {
            null
        @Override
    }
        });
        protected List<StageTask> materializeTasks() {
        void doFail(Exception cause) {
        RecordingListener recording = new RecordingListener();
 * this file be licensed under the Apache-2.0 license or a
        @Override
            events.add("onQuerySuccess");
