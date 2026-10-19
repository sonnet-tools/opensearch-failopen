    }
        root.setRowCount(values.length);
        assertNull("and not by an equal-but-distinct target", exec.sortBounds().get(target(0)));
    }
        assertTrue(noBounds.sortBounds().isEmpty());
 *  
     * no bounds, and a limit past {@code TopNGate.MAX_CAPACITY}.
    }
        assertNull("mixed value kinds must not set up a gate", exec.topNGate());
    private VectorSchemaRoot varCharBatch(String... values) {  
import org.apache.arrow.vector.VectorSchemaRoot;  
    // ── what sets up a gate, and what refuses to ──────────────────────────  
        VectorSchemaRoot second = millisBatch(95L, 12L);
        assertSame("bounds are reachable by the check's own target instance", bounds, exec.sortBounds().get(target));  
        VarCharVector vector = (VarCharVector) root.getVector(0);  
import org.opensearch.analytics.planner.dag.TargetResolver;
 * The OpenSearch Contributors require contributions made to  
    /**  
        assertTrue("and no bounds to consult", exec.sortBounds().isEmpty());
        ShardFragmentStageExecution exec = buildExecution(sink, sortSpec, capturedListener);
        public void close() {
    /**
import org.opensearch.analytics.exec.stage.StageExecution;
        scheduleAndDispatch(exec);
        ShardSortBounds bounds = millisBounds(10L, 20L);
     * A shard target on its own fake node. Never call inside a {@code when(...)} argument — it stubs a
    private VectorSchemaRoot millisBatch(long... values) {
        TopNGate gate = exec.topNGate();
    public void testAbsentSortColumnDisablesTheGateWithoutAffectingTheQuery() {
        when(config.parentTask()).thenReturn(parentTask);
    public void testUngateableShapesLeaveTheQueryUngated() {  
        tooBig.setupSortGate(oversized, checkResult(target(0), millisBounds(10L, 20L)));
            vector.setSafe(i, values[i]);  
    /**  
import org.opensearch.cluster.service.ClusterService;  
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
    public void testShardCheckBoundsSetUpTheGate() {  
import org.opensearch.core.index.shard.ShardId;
        super.setUp();
import org.apache.arrow.vector.TimeStampMilliVector;
            for (VectorSchemaRoot batch : fed) {  
            t.shardId(),  
        capturedListener.get().onStreamResponse(new FragmentExecutionArrowResponse(first), false);
import java.util.Map;  
    /** Same column name, a type {@code TopNGate.readInto} has no arm for. */
                FragmentExecutionArrowResponse>) invocation.getArgument(2);
    public void setUp() throws Exception {
        assertSame("and fed unmodified", root, sink.fed.get(0));
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
        assertEquals("batch still fed", 1, sink.fed.size());  
        assertNull("no sort spec on the stage means no gate", exec.topNGate());  
     */
        vector.setValueCount(values.length);
     * shape) and the streaming listener captured for the test to drive.  
        scheduleAndDispatch(exec);
     */  
import static org.mockito.ArgumentMatchers.any;
            List.of(new FragmentExecutionRequest.PlanAlternative("test-backend", new byte[0], List.of()))
        Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = t -> new FragmentExecutionRequest(  
        when(clusterService.state()).thenReturn(clusterState);
 */  
        @SuppressWarnings("unchecked")  
        exec.setupSortGate(sortSpec, checkResult(target(0), millisBounds(10L, 100L)));
     * The other three un-gated shapes, one per remaining branch of {@code setupSortGate}: no sort spec,  
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
    private ShardFragmentStageExecution buildExecution(
            "test-query",
     * query untouched rather than letting a missing-column lookup fail it.
        SortSpec oversized = new SortSpec(SORT_COLUMN, true, 1_000_000);  
        ExecutionTarget nanosShard = target(1);
        scheduleAndDispatch(exec);
        sink.close();  
            @SuppressWarnings("unchecked")
        byTarget.put(target, bounds);  
import org.apache.arrow.memory.BufferAllocator;
import static org.mockito.Mockito.doAnswer;
        assertFalse("two keys is not yet K=3", exec.topNGate().isArmed());  
        TaskRunner<StageTask> dispatcher = (TaskRunner<StageTask>) exec.taskRunner();
        capturedListener.get().onStreamResponse(new FragmentExecutionArrowResponse(root), true);
        TimeStampMilliVector vector = (TimeStampMilliVector) root.getVector(0);
     * identity-keyed by the check's own target instances for the dispatch-side lookup.
                task.transitionTo(StageTaskState.FINISHED);
        ShardFragmentStageExecution noSpec = buildExecution(new CapturingSink(), null, new AtomicReference<>());  
        Map<ExecutionTarget, ShardSortBounds> byTarget = new IdentityHashMap<>();
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        SortSpec sortSpec = new SortSpec(SORT_COLUMN, true, 3);
import static org.mockito.Mockito.when;
import org.apache.arrow.vector.types.pojo.ArrowType;
        assertNull("a limit past MAX_CAPACITY refuses the gate", tooBig.topNGate());  
            }, cause -> {
 * SPDX-License-Identifier: Apache-2.0
    private static CanMatchPreFilterPhase.ShardCheckResult checkResult(ExecutionTarget target, ShardSortBounds bounds) {
    }
    @Override  
        @Override
     */
        VectorSchemaRoot first = millisBatch(100L, 98L);
        CapturingSink sink = new CapturingSink();  
        assertTrue("a missing sort column retires the gate", exec.topNGate().isDisabled());
import org.opensearch.test.OpenSearchTestCase;  
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
import java.util.List;
        }  
     * Stage execution over one shard target, with {@code sortSpec} on the stage (null for the un-gated
        SortSpec sortSpec,
import java.nio.charset.StandardCharsets;
    }  
    @Override  
     * Bounds at different scales (millis vs nanos) aren't comparable, so no gate is built and no bounds
import org.apache.arrow.vector.types.pojo.FieldType;
        when(resolver.resolve(any(ClusterState.class), any())).thenReturn(resolved);
        assertFalse("but nothing was observed, so nothing can be eliminated", exec.topNGate().isArmed());  
        VectorSchemaRoot root = VectorSchemaRoot.create(new Schema(List.of(field)), allocator);
        assertNull("no sort spec, no gate", noSpec.topNGate());
        when(stage.getSortSpec()).thenReturn(sortSpec);
        exec.setupSortGate(sortSpec, new CanMatchPreFilterPhase.ShardCheckResult(List.of(millisShard, nanosShard), bounds));
    public void testUnreadableVectorTypeLeavesTheGateUnarmedButTheQueryIntact() {
import org.opensearch.cluster.node.DiscoveryNode;
        sink.close();  
    // ── the response path with, and without, a gate ───────────────────────  
import org.opensearch.analytics.exec.canmatch.CanMatchPreFilterPhase;
        ShardFragmentStageExecution exec = buildExecution(sink, null, capturedListener);  
        noSpec.setupSortGate(null, checkResult(target(0), millisBounds(10L, 20L)));
        for (int i = 0; i < values.length; i++) {
     * mock, and Mockito reads a nested stubbing as an unfinished one.
    private static ShardSortBounds millisBounds(long min, long max) {
 */
    private static void scheduleAndDispatch(ShardFragmentStageExecution exec) {
        final List<VectorSchemaRoot> fed = new ArrayList<>();  
            task.transitionTo(StageTaskState.RUNNING);  
        bounds.put(nanosShard, new ShardSortBounds(10L, 20L, false, ShardSortBounds.VALUE_KIND_INT64_NANOS));
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
    /** With no gate — most query shapes — the batch is fed unmodified and the stage succeeds. */
    /**
        for (StageTask task : exec.tasks()) {
    }
        assertSame(second, sink.fed.get(1));
        ShardFragmentStageExecution exec = buildExecution(sink, sortSpec, capturedListener);
        return root;
        SortSpec sortSpec = new SortSpec(SORT_COLUMN, true, 3);  
            dispatcher.run(task, ActionListener.wrap(v -> {
import org.opensearch.analytics.exec.canmatch.SortSpec;  
    }
    private static final String SORT_COLUMN = "@timestamp";
        sink.close();  
     */
import org.opensearch.analytics.exec.task.TaskRunner;  
        VectorSchemaRoot root = VectorSchemaRoot.create(new Schema(List.of(field)), allocator);  
import org.opensearch.analytics.exec.StreamingResponseListener;
 *
        return new ShardFragmentStageExecution(stage, config, sink, clusterService, requestBuilder, dispatcher);  
    }
     * With a gate set up, every row of every batch reaches it and the batch is still fed downstream
        assertSame("and fed unmodified", first, sink.fed.get(0));  
        ShardFragmentStageExecution noBounds = buildExecution(new CapturingSink(), sortSpec, new AtomicReference<>());
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;  
    /** Mirrors {@code QueryExecution.scheduleStage}: start, then run each task through the runner. */  
}
import org.opensearch.analytics.exec.canmatch.TopNGate;
        root.setRowCount(values.length);
public class SortGateWiringTests extends OpenSearchTestCase {  
        capturedListener.get().onStreamResponse(new FragmentExecutionArrowResponse(intBatch(1, 2, 3)), true);  
            return null;  
import org.opensearch.analytics.exec.stage.StageTask;  
        Map<ExecutionTarget, ShardSortBounds> bounds = new IdentityHashMap<>();
    public void testMixedValueKindsRefuseTheGate() {
        }
        assertTrue("and no bounds are published", exec.sortBounds().isEmpty());
                batch.close();
import org.apache.arrow.vector.IntVector;  
            vector.setSafe(i, values[i]);
        assertEquals("capacity is the spec's limit", 3, exec.topNGate().capacity());  
        Field field = new Field(SORT_COLUMN, FieldType.nullable(new ArrowType.Utf8()), null);
        SortSpec sortSpec = new SortSpec(SORT_COLUMN, true, 1);
        assertEquals("the query is unaffected", 1, sink.fed.size());
import java.util.concurrent.atomic.AtomicReference;
     */
        exec.setupSortGate(sortSpec, checkResult(target, bounds));  
        return root;
    /** MILLISECOND-typed {@code @timestamp} column — what a gated query sorts on. */
        VectorSchemaRoot root = VectorSchemaRoot.create(new Schema(List.of(field)), allocator);
        for (int i = 0; i < values.length; i++) {
        allocator = new RootAllocator();  
        vector.setValueCount(values.length);  
        return root;  
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
        for (int i = 0; i < values.length; i++) {  
        }  
        Stage stage = mock(Stage.class);  
        }
    /**  
        when(config.bufferAllocator()).thenReturn(allocator);
        return new CanMatchPreFilterPhase.ShardCheckResult(List.of(target), byTarget);
        assertFalse("a fresh gate cannot eliminate until K keys land", exec.topNGate().isArmed());
        doAnswer(invocation -> {
import java.util.ArrayList;  
import org.apache.arrow.vector.types.pojo.Field;  
    }  
 * compatible open source license.
        public void feed(VectorSchemaRoot batch) {  
    }
        // Built before any when(...) — target() stubs a mock, which can't be nested in a stubbing.
     * are published. Getting this wrong costs a wrong result, not just a lost optimisation.  
        ShardFragmentStageExecution exec = buildExecution(sink, sortSpec, capturedListener);
        SortSpec sortSpec = new SortSpec(SORT_COLUMN, true, 1);
     * untouched. Observation must precede the feed, since the sink takes ownership of the batch.
        ShardFragmentStageExecution exec = buildExecution(new CapturingSink(), sortSpec, new AtomicReference<>());
/**  
        assertFalse("a type the feeder can't read is not a reason to retire", exec.topNGate().isDisabled());
        return new ShardSortBounds(min, max, false, ShardSortBounds.VALUE_KIND_INT64_MILLIS);  
        allocator.close();
        sink.close();  
                exec.onTaskTerminal(task, null);  
        QueryContext config = mock(QueryContext.class);
        ShardFragmentStageExecution exec = buildExecution(new CapturingSink(), sortSpec, new AtomicReference<>());
import org.opensearch.analytics.spi.ExchangeSink;
    }
        assertNull("no bounds, no gate", noBounds.topNGate());  
import java.util.IdentityHashMap;
        assertEquals("the query is unaffected: batch fed", 1, sink.fed.size());
import org.apache.arrow.vector.types.pojo.Schema;
        bounds.put(millisShard, millisBounds(10L, 20L));  
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> listenerCapture
        AnalyticsQueryTask parentTask = mock(AnalyticsQueryTask.class);  
        super.tearDown();  
        exec.setupSortGate(sortSpec, checkResult(target(0), millisBounds(10L, 100L)));
        SortSpec sortSpec = new SortSpec(SORT_COLUMN, true, 3);
        CapturingSink sink = new CapturingSink();  
 * <p>Lives in the {@code shard} package because the gate accessors are package-private.
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;  
    public void testNoGateLeavesTheStreamPathUnchanged() {  
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
        scheduleAndDispatch(exec);
        CapturingSink sink,  
        assertEquals("bounds are retained for the dispatch-side lookup", 1, exec.sortBounds().size());
    private static ExecutionTarget target(int ordinal) {
import java.util.function.Function;
        List<ExecutionTarget> resolved = List.of(target(0));
     */  
     */  
        assertNotNull("bounds in one agreed domain set up the gate", exec.topNGate());
            }));
            listenerCapture.set(listener);
 * that observing sort keys on the response path leaves the query otherwise unchanged.
        ShardFragmentStageExecution tooBig = buildExecution(new CapturingSink(), oversized, new AtomicReference<>());
        ClusterService clusterService = mock(ClusterService.class);  
    }
    }
/*  
     * Bounds in one agreed value domain set up a gate with the spec's limit, and the bounds are retained  
     * unarmed and eliminates nothing — fail-open without retiring.
    private VectorSchemaRoot intBatch(int... values) {
        AnalyticsSearchTransportService dispatcher = mock(AnalyticsSearchTransportService.class);  
 * Stage-level wiring for the top-N gate: which can-match results set up a gate, which refuse to, and
import org.opensearch.core.action.ActionListener;
    }  
import org.opensearch.analytics.exec.QueryContext;
    ) {  
        when(config.maxConcurrentShardRequestsPerNode()).thenReturn(5);  
        IntVector vector = (IntVector) root.getVector(0);
        ClusterState clusterState = mock(ClusterState.class);
        }
            }
    /**
        Field field = new Field("value", FieldType.nullable(new ArrowType.Int(32, true)), null);
    public void testGatedStreamObservesEveryRowAndStillFeedsTheBatch() {
                exec.onTaskTerminal(task, cause);  
        assertEquals("both batches still fed", 2, sink.fed.size());
    private BufferAllocator allocator;
                task.transitionTo(StageTaskState.FAILED);
    /**  
    }
import org.apache.arrow.vector.VarCharVector;
    public void tearDown() throws Exception {
        exec.setupSortGate(sortSpec, checkResult(target(0), millisBounds(10L, 100L)));
    // ── helpers ──────────────────────────────────────────────────────────  
     */  
    /** A batch with no {@code @timestamp} column at all — the projected-away shape. */  
import static org.mockito.Mockito.mock;  
        when(stage.getStageId()).thenReturn(0);
            0,
        );
        CapturingSink sink = new CapturingSink();
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
        noBounds.setupSortGate(sortSpec, CanMatchPreFilterPhase.ShardCheckResult.keepAll(List.of(target(0))));
        when(stage.getTargetResolver()).thenReturn(resolver);
    }
        assertEquals("bar is the 3rd-best of {100,98,95,12}", 95L, gate.bottom());
        TargetResolver resolver = mock(TargetResolver.class);  
        return new ShardExecutionTarget(node, new ShardId("idx", "_na_", ordinal), ordinal);
     * The sort column arrives as a type the feeder can't read: nothing is observed, so the gate stays
        DiscoveryNode node = mock(DiscoveryNode.class);
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
        when(node.getId()).thenReturn("test-node-" + ordinal);  
        assertFalse("a retired gate eliminates nothing", exec.topNGate().canEliminate(millisBounds(0L, 1L)));  
        assertTrue("all four keys observed across both batches", gate.isArmed());  
import org.opensearch.analytics.planner.dag.ExecutionTarget;
package org.opensearch.analytics.exec.stage.shard;
        capturedListener.get().onStreamResponse(new FragmentExecutionArrowResponse(varCharBatch("not a timestamp")), true);  
        Field field = new Field(SORT_COLUMN, FieldType.nullable(new ArrowType.Timestamp(TimeUnit.MILLISECOND, null)), null);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.exec.stage.StageTaskState;
    /**
        VectorSchemaRoot root = millisBatch(100L, 98L, 95L);  
        SortSpec sortSpec = new SortSpec(SORT_COLUMN, true, 3);
        root.setRowCount(values.length);  
        ExecutionTarget millisShard = target(0);  
            StreamingResponseListener<FragmentExecutionArrowResponse> listener = (StreamingResponseListener<  
import org.opensearch.analytics.spi.ShardSortBounds;  
        ExecutionTarget target = target(0);
import org.opensearch.cluster.ClusterState;
        @Override
        capturedListener.get().onStreamResponse(new FragmentExecutionArrowResponse(second), true);  
    private static final class CapturingSink implements ExchangeSink {
import org.apache.arrow.memory.RootAllocator;
    }
        }
            fed.add(batch);
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
    }
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
        }).when(dispatcher).dispatchFragmentStreaming(any(), any(), any(), any(), any(), any());
        vector.setValueCount(values.length);
import org.apache.arrow.vector.types.TimeUnit;
            vector.setSafe(i, values[i].getBytes(StandardCharsets.UTF_8));
import org.opensearch.analytics.planner.dag.Stage;  
     * The sort column is projected away, so there is nothing to observe: retire the gate and leave the
        CapturingSink sink = new CapturingSink();  
