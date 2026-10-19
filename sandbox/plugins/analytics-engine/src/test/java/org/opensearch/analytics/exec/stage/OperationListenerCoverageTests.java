        });
        }
            "q-test",
    public void testListenerCancellationPath() {
        AtomicReference<TestableRootExecution> stageRef = new AtomicReference<>();
        }  
        when(stage.getStageId()).thenReturn(id);
            events.add("onQuerySuccess");  
            "transport",  
            return List.of(new LocalStageTask(new StageTaskId(getStageId(), 0), l -> l.onResponse(null)));
            // transitions via doSucceed/doFail; dispatch must not race them.
            return 0;
 */  
import org.opensearch.core.action.ActionListener;  
import org.opensearch.test.OpenSearchTestCase;  
            transitionTo(State.FAILED);
import org.opensearch.transport.TransportService;
    }
import org.opensearch.analytics.exec.stage.coordinator.LocalStageTask;  
    }
        @Override
     * Direct {@code CREATED → terminal} (e.g. empty target resolution skipping RUNNING)
            TestableRootExecution exec = new TestableRootExecution(stage, new NoopSink(), cfg);
        @Override
    /**  
        assertEquals(List.of("onQueryStart:1", "onStageStart:0", "onQuerySuccess", "onStageSuccess:0"), recording.events);
 * lifecycle.
 * <p>Out of scope: data-node fragment callbacks ({@code onPreFragmentExecution} etc.) —
     * firing operation listeners. The test pins this order — if the order ever changes,  
        stageRef.get().doFail(new RuntimeException("stage failed"));
     * ({@code fireOperationListeners}). {@link #materializeTasks} returns one no-op task so
        RecordingListener recording = new RecordingListener();
        stageRef.get().doSucceed();
        });
    private static class TestableRootExecution extends AbstractStageExecution implements DataProducer {  
    private static final class NoopSink implements org.opensearch.analytics.spi.ExchangeSink, ExchangeSource {
        executeViaScheduler(rootStage, List.of(recording), ActionListener.wrap(r -> {}, e -> {}));
            stageRef.set(exec);  
                }  
        @Override
        @Override
    @Override  
        void doSucceed() {
    }
        }
        stageRef.get().doCancel();
    /** Empty terminal sink that doubles as a row-producing source — read returns empty. */  
 *  
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, sink, cfg) -> {  
import org.opensearch.analytics.backend.AnalyticsOperationListener;
        executeViaScheduler(rootStage, List.of(recording), ActionListener.wrap(r -> {}, e -> {}));
}
        public void onQuerySuccess(String queryId, long tookInNanos, long totalRows) {
import java.util.ArrayList;  
import org.opensearch.analytics.planner.dag.QueryDAG;
     * Happy path: {@code onQueryStart → onStageStart → onQuerySuccess → onStageSuccess}.
    private void executeViaScheduler(
import org.opensearch.analytics.exec.QueryScheduler;
     * fire {@code AnalyticsOperationListener} callbacks through the real production wiring
        public void feed(VectorSchemaRoot batch) {  
 * See the TODO in {@code AnalyticsOperationListener}.  
                protected List<StageTask> materializeTasks() {
        when(stage.getChildStages()).thenReturn(List.of());
 * <p>Lives in the {@code .stage} package so the test stage can extend the package-private
        assertEquals(List.of("onQueryStart:1", "onQuerySuccess", "onStageStart:0", "onStageSuccess:0"), recording.events);  
            null
     *
     */
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
    }
    }
    public void testListenerSynthesisesStageStartForDirectCreatedToTerminal() {
    // ── helpers ─────────────────────────────────────────────────────────  
            // Stage whose start() goes CREATED → SUCCEEDED directly (no RUNNING): materialise  
        }
        Stage rootStage,  
        public void onStageSuccess(String queryId, int stageId, String stageType, long tookInNanos, long rowsProcessed) {
        public void close() {}
import org.opensearch.cluster.service.ClusterService;
 *
        QueryDAG dag = new QueryDAG("q-test", rootStage);
     * tests then drive terminal transitions via {@code doSucceed}/{@code doFail}.
        RecordingListener recording = new RecordingListener();  
     * still surfaces an {@code onStageStart} synthetically — observers never see a
            stageRef.set(exec);
            return source;
        @Override  
        }  
        }
 * across happy / failure / cancellation paths. Wires a {@link RecordingListener} through
        assertEquals(List.of("onQueryStart:1", "onStageStart:0", "onQueryFailure", "onStageCancelled:0"), recording.events);  
            return Collections.emptyList();  
     * listener's perspective) — same query-terminal-before-stage-terminal ordering.  
        public void onStageCancelled(String queryId, int stageId, String reason) {  
        Stage rootStage = stageWithId(0);
        return stage;
        public void onQueryFailure(String queryId, Exception cause) {
     * fired-set + ordering against a single {@code List<String>}.  
        builder = new StageExecutionBuilder(mock(ClusterService.class), null);  
 * SPDX-License-Identifier: Apache-2.0
        private final ExchangeSource source;
        Stage rootStage = stageWithId(0);  
            transitionTo(State.CANCELLED);
        void doCancel() {
        }
        @Override
     * because {@code AbstractStageExecution.transitionTo} fires state listeners (which include
        void doFail(Exception cause) {
     * Cancellation path: stage CANCELLED surfaces as onStageCancelled. The wrapper-listener
        super.setUp();
        Stage rootStage = stageWithId(0);
    }
        }
import org.opensearch.analytics.backend.ExchangeSource;  
            TaskId.EMPTY_TASK_ID,  
        }
            captureFailure(cause);  
        public Iterable<VectorSchemaRoot> readResult() {
    ) {  
import java.util.concurrent.atomic.AtomicReference;
            // an empty task list, which the base short-circuits to SUCCEEDED.
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, sink, cfg) -> {
        @Override
                @Override  
        public void onStageStart(String queryId, int stageId, String stageType) {  
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, sink, cfg) -> {  
 * those need a plugin SPI to inject a fragment listener into {@code AnalyticsSearchService}.
 * The OpenSearch Contributors require contributions made to  
    public void testListenerHappyPath() {  
 * {@link AbstractStageExecution} pipeline, and asserts the fired-set + ordering for each
/**  
 * this file be licensed under the Apache-2.0 license or a
        public long getRowCount() {
        executeViaScheduler(rootStage, List.of(recording), ActionListener.wrap(r -> fail("unexpected success"), e -> {}));  
/*  
    /**  
            // Park runner: accept the task but never signal terminal. Tests drive
import org.opensearch.analytics.planner.dag.Stage;  
        public void onQueryStart(String queryId, int stageCount) {  
                    return List.of();
import org.opensearch.tasks.TaskManager;
    }
import static org.mockito.Mockito.when;
        RecordingListener recording = new RecordingListener();  
            return exec;  
        @Override  
        });
            events.add("onStageSuccess:" + stageId);  
        ActionListener<Iterable<VectorSchemaRoot>> userListener
        List<AnalyticsOperationListener> listeners,
    }  
package org.opensearch.analytics.exec.stage;
            return exec;  
        @Override  
        @SuppressWarnings({ "unchecked", "rawtypes" })  
    private static final class RecordingListener implements AnalyticsOperationListener {
import java.util.List;
            return new TestableRootExecution(stage, new NoopSink(), cfg) {
     * the QueryExecution root-state mirror that drives the query terminal inline) before
        Stage stage = mock(Stage.class);  
     * fires onQueryFailure (cancellation is an abnormal termination from the user-facing
    }
import java.util.Map;  
     */
 *  
            TestableRootExecution exec = new TestableRootExecution(stage, new NoopSink(), cfg);
            this.runner = (org.opensearch.analytics.exec.task.TaskRunner) (task, listener) -> {};  
            events.add("onQueryStart:" + stageCount);
        TransportService transportService = mock(TransportService.class);  
        QueryContext ctx = QueryContext.forTest(dag, task, listeners);
        when(stage.getExecutionType()).thenReturn(StageExecutionType.LOCAL_PASSTHROUGH);  
 * End-to-end coverage of {@link AnalyticsOperationListener} coordinator-side callbacks
            "analytics_query",
        }  
        @Override
        executeViaScheduler(rootStage, List.of(recording), ActionListener.wrap(r -> fail("unexpected success"), e -> {}));  
        @Override
            1L,
            };
        public ExchangeSource outputSource() {  
            stageRef.set(exec);
        @Override
        protected List<StageTask> materializeTasks() {
     */
     * Test stage that extends {@link AbstractStageExecution} so its state transitions  
        );  
        }  
import static org.mockito.Mockito.mock;  
        RecordingListener recording = new RecordingListener();  
            events.add("onStageStart:" + stageId);
        @Override  
        new QueryScheduler(builder, transportService).execute(ctx, userListener);
            events.add("onStageFailure:" + stageId);
    private StageExecutionBuilder builder;
     * Records every fired callback as a short {@code name[:detail]} label so tests assert
 * {@link QueryContext#operationListeners()}, drives the full {@link QueryScheduler} →  
        }
            events.add("onStageCancelled:" + stageId);
import org.opensearch.analytics.exec.QueryContext;
            events.add("onQueryFailure");
        public void onStageFailure(String queryId, int stageId, Exception cause) {
    /**
        builder.registerFactory(StageExecutionType.LOCAL_PASSTHROUGH, (stage, sink, cfg) -> {
        assertEquals(List.of("onQueryStart:1", "onStageStart:0", "onQueryFailure", "onStageFailure:0"), recording.events);  
    /** Failure path: same ordering invariant — query terminal fires inline before stage operation callback. */
    }  
        }  
import java.util.Collections;
 * {@link AbstractStageExecution} and exercise its real listener-firing wiring.
        final List<String> events = new ArrayList<>();  
    /**  
    public void testListenerFailurePath() {
        when(transportService.getTaskManager()).thenReturn(mock(TaskManager.class));
    /**
            batch.close();
        }
    public void setUp() throws Exception {
            super(stage, cfg.queryId(), cfg.operationListeners(), cfg.parentTask());
        }
public class OperationListenerCoverageTests extends OpenSearchTestCase {
        AnalyticsQueryTask task = new AnalyticsQueryTask(
import org.opensearch.core.tasks.TaskId;
        AtomicReference<TestableRootExecution> stageRef = new AtomicReference<>();
        TestableRootExecution(Stage stage, ExchangeSource source, QueryContext cfg) {
     */
        });
     * terminal event for a stage they didn't see start.  
            this.source = source;  
            Map.of(),
 */
        Stage rootStage = stageWithId(0);
     */
     * {@link #start} transitions to RUNNING (not the empty-list short-circuit to SUCCEEDED);  
import org.apache.arrow.vector.VectorSchemaRoot;
            return exec;
        }  
            transitionTo(State.SUCCEEDED);
        AtomicReference<TestableRootExecution> stageRef = new AtomicReference<>();
     * update it explicitly rather than silently.
import org.opensearch.analytics.planner.dag.StageExecutionType;
    private static Stage stageWithId(int id) {
     * <p>The query terminal callback fires <i>before</i> the stage's own operation callback  
 * compatible open source license.
            TestableRootExecution exec = new TestableRootExecution(stage, new NoopSink(), cfg);
