        ShardFragmentStageExecution exec = buildExecution(new CapturingSink(), sortSpec, new AtomicReference<>());
        noBounds.setupSortGate(sortSpec, CanMatchPreFilterPhase.ShardCheckResult.keepAll(List.of(target(0))));
        final List<VectorSchemaRoot> fed = new ArrayList<>();
    ) {
    /**
            }
    @Override
     */
    private static void scheduleAndDispatch(ShardFragmentStageExecution exec) {
    /**
/*
     * With a gate set up, every row of every batch reaches it and the batch is still fed downstream
     */
import org.apache.arrow.vector.TimeStampMilliVector;
import org.opensearch.analytics.planner.dag.ExecutionTarget;
        }
 *
import java.util.concurrent.atomic.AtomicReference;
    private ShardFragmentStageExecution buildExecution(
        assertFalse("a retired gate eliminates nothing", exec.topNGate().canEliminate(millisBounds(0L, 1L)));
        when(node.getId()).thenReturn("test-node-" + ordinal);
     * no bounds, and a limit past {@code TopNGate.MAX_CAPACITY}.
        ShardFragmentStageExecution exec = buildExecution(sink, sortSpec, capturedListener);
        SortSpec sortSpec = new SortSpec(SORT_COLUMN, true, 3);
                task.transitionTo(StageTaskState.FAILED);
    }
        DiscoveryNode node = mock(DiscoveryNode.class);
        scheduleAndDispatch(exec);
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
    }
import org.apache.arrow.vector.IntVector;
import org.opensearch.analytics.exec.canmatch.CanMatchPreFilterPhase;
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
import static org.mockito.Mockito.mock;
        exec.setupSortGate(sortSpec, checkResult(target, bounds));
     * untouched. Observation must precede the feed, since the sink takes ownership of the batch.
        assertEquals("batch still fed", 1, sink.fed.size());
        scheduleAndDispatch(exec);
        super.tearDown();
        ShardFragmentStageExecution noSpec = buildExecution(new CapturingSink(), null, new AtomicReference<>());
        Map<ExecutionTarget, ShardSortBounds> bounds = new IdentityHashMap<>();
     * Bounds in one agreed value domain set up a gate with the spec's limit, and the bounds are retained
    /**
            for (VectorSchemaRoot batch : fed) {
        sink.close();
import org.opensearch.cluster.node.DiscoveryNode;
    }
import java.nio.charset.StandardCharsets;
    public void testGatedStreamObservesEveryRowAndStillFeedsTheBatch() {
        noSpec.setupSortGate(null, checkResult(target(0), millisBounds(10L, 20L)));
    /** Same column name, a type {@code TopNGate.readInto} has no arm for. */
public class SortGateWiringTests extends OpenSearchTestCase {
        ExecutionTarget target = target(0);
            vector.setSafe(i, values[i].getBytes(StandardCharsets.UTF_8));
        assertFalse("a type the feeder can't read is not a reason to retire", exec.topNGate().isDisabled());
    private static CanMatchPreFilterPhase.ShardCheckResult checkResult(ExecutionTarget target, ShardSortBounds bounds) {
 * SPDX-License-Identifier: Apache-2.0
        }
        TopNGate gate = exec.topNGate();
import org.opensearch.analytics.exec.task.TaskRunner;
        return new ShardExecutionTarget(node, new ShardId("idx", "_na_", ordinal), ordinal);
     */
        SortSpec oversized = new SortSpec(SORT_COLUMN, true, 1_000_000);
        Map<ExecutionTarget, ShardSortBounds> byTarget = new IdentityHashMap<>();
            t.shardId(),
        assertNull("no sort spec on the stage means no gate", exec.topNGate());
import org.apache.arrow.vector.types.pojo.Field;
        assertNull("no sort spec, no gate", noSpec.topNGate());
        capturedListener.get().onStreamResponse(new FragmentExecutionArrowResponse(root), true);
        CapturingSink sink = new CapturingSink();
import org.opensearch.test.OpenSearchTestCase;
    }
        when(stage.getSortSpec()).thenReturn(sortSpec);
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
        assertTrue("and no bounds are published", exec.sortBounds().isEmpty());
        SortSpec sortSpec = new SortSpec(SORT_COLUMN, true, 3);
        assertSame(second, sink.fed.get(1));
        SortSpec sortSpec = new SortSpec(SORT_COLUMN, true, 1);
    /**
        assertEquals("capacity is the spec's limit", 3, exec.topNGate().capacity());
        assertFalse("but nothing was observed, so nothing can be eliminated", exec.topNGate().isArmed());
                exec.onTaskTerminal(task, cause);
        VectorSchemaRoot root = VectorSchemaRoot.create(new Schema(List.of(field)), allocator);
        scheduleAndDispatch(exec);
        assertTrue("all four keys observed across both batches", gate.isArmed());
import org.apache.arrow.vector.VectorSchemaRoot;
        return root;
import org.apache.arrow.memory.BufferAllocator;
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        allocator = new RootAllocator();
        ExecutionTarget nanosShard = target(1);
import org.opensearch.analytics.planner.dag.TargetResolver;
                FragmentExecutionArrowResponse>) invocation.getArgument(2);
    /** A batch with no {@code @timestamp} column at all — the projected-away shape. */
import static org.mockito.Mockito.doAnswer;
    /** Mirrors {@code QueryExecution.scheduleStage}: start, then run each task through the runner. */
        assertEquals("the query is unaffected", 1, sink.fed.size());
import org.opensearch.analytics.exec.canmatch.TopNGate;
import java.util.function.Function;
        root.setRowCount(values.length);
import org.apache.arrow.vector.types.pojo.FieldType;
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
        AnalyticsQueryTask parentTask = mock(AnalyticsQueryTask.class);
        SortSpec sortSpec = new SortSpec(SORT_COLUMN, true, 1);
import org.opensearch.analytics.exec.QueryContext;
    }
     * identity-keyed by the check's own target instances for the dispatch-side lookup.
        assertFalse("two keys is not yet K=3", exec.topNGate().isArmed());
        CapturingSink sink = new CapturingSink();
            0,
    }
     * Stage execution over one shard target, with {@code sortSpec} on the stage (null for the un-gated
        SortSpec sortSpec = new SortSpec(SORT_COLUMN, true, 3);
        Field field = new Field("value", FieldType.nullable(new ArrowType.Int(32, true)), null);
        VectorSchemaRoot root = VectorSchemaRoot.create(new Schema(List.of(field)), allocator);
import org.opensearch.analytics.exec.stage.StageTaskState;
        capturedListener.get().onStreamResponse(new FragmentExecutionArrowResponse(varCharBatch("not a timestamp")), true);
    // ── what sets up a gate, and what refuses to ──────────────────────────
    public void testNoGateLeavesTheStreamPathUnchanged() {
        ExecutionTarget millisShard = target(0);
        assertNull("a limit past MAX_CAPACITY refuses the gate", tooBig.topNGate());
    private static final String SORT_COLUMN = "@timestamp";
    private static ShardSortBounds millisBounds(long min, long max) {
        scheduleAndDispatch(exec);
        vector.setValueCount(values.length);
import static org.mockito.ArgumentMatchers.any;
        bounds.put(nanosShard, new ShardSortBounds(10L, 20L, false, ShardSortBounds.VALUE_KIND_INT64_NANOS));
    /**
    private static final class CapturingSink implements ExchangeSink {
import org.opensearch.analytics.exec.stage.StageTask;
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;
     * A shard target on its own fake node. Never call inside a {@code when(...)} argument — it stubs a
    /** With no gate — most query shapes — the batch is fed unmodified and the stage succeeds. */
    }
        for (int i = 0; i < values.length; i++) {
        return new ShardSortBounds(min, max, false, ShardSortBounds.VALUE_KIND_INT64_MILLIS);
import org.opensearch.analytics.exec.canmatch.SortSpec;
        Field field = new Field(SORT_COLUMN, FieldType.nullable(new ArrowType.Utf8()), null);
        return root;
            return null;
            vector.setSafe(i, values[i]);
     */
        TimeStampMilliVector vector = (TimeStampMilliVector) root.getVector(0);
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
        vector.setValueCount(values.length);
                batch.close();
import org.opensearch.analytics.planner.dag.Stage;
    /**
        CapturingSink sink = new CapturingSink();
import org.opensearch.cluster.service.ClusterService;
    /**
        capturedListener.get().onStreamResponse(new FragmentExecutionArrowResponse(intBatch(1, 2, 3)), true);
        assertTrue("a missing sort column retires the gate", exec.topNGate().isDisabled());
import org.opensearch.analytics.spi.ShardSortBounds;
 *
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
        public void close() {
        VarCharVector vector = (VarCharVector) root.getVector(0);
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
    }
        QueryContext config = mock(QueryContext.class);
     */
        when(config.parentTask()).thenReturn(parentTask);
    }
    public void testUngateableShapesLeaveTheQueryUngated() {
        assertEquals("bar is the 3rd-best of {100,98,95,12}", 95L, gate.bottom());
    public void testAbsentSortColumnDisablesTheGateWithoutAffectingTheQuery() {
     */
 * Stage-level wiring for the top-N gate: which can-match results set up a gate, which refuse to, and
        root.setRowCount(values.length);
import org.apache.arrow.vector.types.TimeUnit;
}
        exec.setupSortGate(sortSpec, checkResult(target(0), millisBounds(10L, 100L)));
        assertNull("mixed value kinds must not set up a gate", exec.topNGate());
        VectorSchemaRoot second = millisBatch(95L, 12L);
import java.util.ArrayList;
    }
     * shape) and the streaming listener captured for the test to drive.
        allocator.close();
        capturedListener.get().onStreamResponse(new FragmentExecutionArrowResponse(first), false);
        TargetResolver resolver = mock(TargetResolver.class);
    }
        super.setUp();
    private VectorSchemaRoot millisBatch(long... values) {
        assertEquals("bounds are retained for the dispatch-side lookup", 1, exec.sortBounds().size());
        return root;
        ShardFragmentStageExecution exec = buildExecution(new CapturingSink(), sortSpec, new AtomicReference<>());
        ShardSortBounds bounds = millisBounds(10L, 20L);
        assertFalse("a fresh gate cannot eliminate until K keys land", exec.topNGate().isArmed());
 * compatible open source license.
        }
        sink.close();
        when(stage.getTargetResolver()).thenReturn(resolver);
        when(clusterService.state()).thenReturn(clusterState);
        assertNull("no bounds, no gate", noBounds.topNGate());
        return new CanMatchPreFilterPhase.ShardCheckResult(List.of(target), byTarget);
            dispatcher.run(task, ActionListener.wrap(v -> {
        }
import org.opensearch.analytics.exec.StreamingResponseListener;
        @Override
    }
 */
        AnalyticsSearchTransportService dispatcher = mock(AnalyticsSearchTransportService.class);
        root.setRowCount(values.length);
        );
/**
        doAnswer(invocation -> {
        SortSpec sortSpec,
     * Bounds at different scales (millis vs nanos) aren't comparable, so no gate is built and no bounds
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
     */
        return new ShardFragmentStageExecution(stage, config, sink, clusterService, requestBuilder, dispatcher);
import java.util.IdentityHashMap;
        assertTrue("and no bounds to consult", exec.sortBounds().isEmpty());
        Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = t -> new FragmentExecutionRequest(
import org.opensearch.core.action.ActionListener;
            StreamingResponseListener<FragmentExecutionArrowResponse> listener = (StreamingResponseListener<
        tooBig.setupSortGate(oversized, checkResult(target(0), millisBounds(10L, 20L)));
import org.opensearch.analytics.exec.stage.StageExecution;
        assertTrue(noBounds.sortBounds().isEmpty());
    public void setUp() throws Exception {
    }
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> listenerCapture
        CapturingSink sink,
        Field field = new Field(SORT_COLUMN, FieldType.nullable(new ArrowType.Timestamp(TimeUnit.MILLISECOND, null)), null);
        assertSame("bounds are reachable by the check's own target instance", bounds, exec.sortBounds().get(target));
    @Override
        }
    private VectorSchemaRoot varCharBatch(String... values) {
            @SuppressWarnings("unchecked")
    private static ExecutionTarget target(int ordinal) {
        CapturingSink sink = new CapturingSink();
        assertNull("and not by an equal-but-distinct target", exec.sortBounds().get(target(0)));
        sink.close();
        VectorSchemaRoot first = millisBatch(100L, 98L);
import org.opensearch.cluster.ClusterState;
            fed.add(batch);
        SortSpec sortSpec = new SortSpec(SORT_COLUMN, true, 3);
        ClusterService clusterService = mock(ClusterService.class);
        VectorSchemaRoot root = millisBatch(100L, 98L, 95L);
    }
                task.transitionTo(StageTaskState.FINISHED);
        ShardFragmentStageExecution tooBig = buildExecution(new CapturingSink(), oversized, new AtomicReference<>());
    /**
        for (int i = 0; i < values.length; i++) {
        Stage stage = mock(Stage.class);
        exec.setupSortGate(sortSpec, checkResult(target(0), millisBounds(10L, 100L)));
    // ── the response path with, and without, a gate ───────────────────────
    // ── helpers ──────────────────────────────────────────────────────────
        ShardFragmentStageExecution exec = buildExecution(sink, sortSpec, capturedListener);
        ShardFragmentStageExecution noBounds = buildExecution(new CapturingSink(), sortSpec, new AtomicReference<>());
        capturedListener.get().onStreamResponse(new FragmentExecutionArrowResponse(second), true);
        @Override
     * The sort column arrives as a type the feeder can't read: nothing is observed, so the gate stays
import java.util.List;
            }, cause -> {
    }
            task.transitionTo(StageTaskState.RUNNING);
     * mock, and Mockito reads a nested stubbing as an unfinished one.
            List.of(new FragmentExecutionRequest.PlanAlternative("test-backend", new byte[0], List.of()))
            "test-query",
        sink.close();
        assertSame("and fed unmodified", first, sink.fed.get(0));
     * The other three un-gated shapes, one per remaining branch of {@code setupSortGate}: no sort spec,
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
        IntVector vector = (IntVector) root.getVector(0);
import org.opensearch.core.index.shard.ShardId;
    /** MILLISECOND-typed {@code @timestamp} column — what a gated query sorts on. */
        ShardFragmentStageExecution exec = buildExecution(sink, null, capturedListener);
    private VectorSchemaRoot intBatch(int... values) {
        assertNotNull("bounds in one agreed domain set up the gate", exec.topNGate());
        when(config.bufferAllocator()).thenReturn(allocator);
        exec.setupSortGate(sortSpec, new CanMatchPreFilterPhase.ShardCheckResult(List.of(millisShard, nanosShard), bounds));
import org.opensearch.analytics.spi.ExchangeSink;
    public void tearDown() throws Exception {
 * The OpenSearch Contributors require contributions made to
 * <p>Lives in the {@code shard} package because the gate accessors are package-private.
    }
    public void testShardCheckBoundsSetUpTheGate() {
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
package org.opensearch.analytics.exec.stage.shard;
     * The sort column is projected away, so there is nothing to observe: retire the gate and leave the
            vector.setSafe(i, values[i]);
        for (int i = 0; i < values.length; i++) {
import org.apache.arrow.vector.types.pojo.ArrowType;
                exec.onTaskTerminal(task, null);
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
        vector.setValueCount(values.length);
        @SuppressWarnings("unchecked")
        // Built before any when(...) — target() stubs a mock, which can't be nested in a stubbing.
    public void testUnreadableVectorTypeLeavesTheGateUnarmedButTheQueryIntact() {
     * unarmed and eliminates nothing — fail-open without retiring.
import org.apache.arrow.memory.RootAllocator;
        ClusterState clusterState = mock(ClusterState.class);
    }
 * that observing sort keys on the response path leaves the query otherwise unchanged.
        public void feed(VectorSchemaRoot batch) {
import org.apache.arrow.vector.VarCharVector;
        for (StageTask task : exec.tasks()) {
    public void testMixedValueKindsRefuseTheGate() {
            }));
        ShardFragmentStageExecution exec = buildExecution(sink, sortSpec, capturedListener);
        when(resolver.resolve(any(ClusterState.class), any())).thenReturn(resolved);
     * query untouched rather than letting a missing-column lookup fail it.
        TaskRunner<StageTask> dispatcher = (TaskRunner<StageTask>) exec.taskRunner();
        assertEquals("both batches still fed", 2, sink.fed.size());
        bounds.put(millisShard, millisBounds(10L, 20L));
        List<ExecutionTarget> resolved = List.of(target(0));
        when(stage.getStageId()).thenReturn(0);
import java.util.Map;
        exec.setupSortGate(sortSpec, checkResult(target(0), millisBounds(10L, 100L)));
    }
 */
    private BufferAllocator allocator;
import static org.mockito.Mockito.when;
        byTarget.put(target, bounds);
        VectorSchemaRoot root = VectorSchemaRoot.create(new Schema(List.of(field)), allocator);
        }).when(dispatcher).dispatchFragmentStreaming(any(), any(), any(), any(), any(), any());
        assertEquals("the query is unaffected: batch fed", 1, sink.fed.size());
import org.apache.arrow.vector.types.pojo.Schema;
        when(config.maxConcurrentShardRequestsPerNode()).thenReturn(5);
            listenerCapture.set(listener);
        }
     * are published. Getting this wrong costs a wrong result, not just a lost optimisation.
 * this file be licensed under the Apache-2.0 license or a
        assertSame("and fed unmodified", root, sink.fed.get(0));
     */
