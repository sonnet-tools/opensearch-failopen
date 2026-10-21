        Optional<StageTask> attempt1 = exec.retargetForRetry(initial, new NodeDisconnectedException(primaryNode, "boom"));
import org.opensearch.cluster.metadata.Metadata;
        }
    }
        List<org.opensearch.analytics.planner.dag.ExecutionTarget> targets = new ArrayList<>(n);
        exec.cancel("test");
                public void onResponse(Void unused) {
        ClusterState clusterState = mock(ClusterState.class);
                public void onFailure(Exception cause) {
    }
        assertTrue("second retry must be present", attempt2.isPresent());
        ShardStageTask failed = new ShardStageTask(new StageTaskId(0, 0), primaryTarget);
import static org.mockito.ArgumentMatchers.any;
        when(r2.currentNodeId()).thenReturn("node-replica-2");
        when(primaryNode.getId()).thenReturn("node-primary");
package org.opensearch.analytics.exec.stage;
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
        boolean closed = false;
        ShardIterator shardIt = mock(ShardIterator.class);
     * When the downstream consumer is already done, the shard listener feeds the in-hand batch, settles
            List.of(new FragmentExecutionRequest.PlanAlternative("test-backend", new byte[0], List.of()))
        assertEquals("retry preserves the StageTaskId slot", failed.id(), retriedTask.id());
    public void testArrowResponseClosedWhenStageAlreadyCancelled() {
                @Override
        Optional<StageTask> attempt2 = exec.retargetForRetry(task1, new NodeDisconnectedException(replica1, "boom"));
        for (StageTask task : exec.tasks()) {
        ShardStageTask failed = new ShardStageTask(new StageTaskId(0, 0), legacyTarget);
        }).when(dispatcher).dispatchFragmentStreaming(any(), any(), any(), any(), any(), any());
public class ShardFragmentStageExecutionTests extends OpenSearchTestCase {
        assertEquals("setup: one task per target", 3, exec.tasks().size());
    public void testArrowResponseFedToSinkOnHappyPath() {
 * SPDX-License-Identifier: Apache-2.0
        when(nodes.get("node-replica")).thenReturn(replicaNode);
    /** On the happy path, batches are fed into the sink and the stage succeeds. */
        Optional<StageTask> retry = exec.retargetForRetry(nonShardTask, new NodeDisconnectedException(mock(DiscoveryNode.class), "test"));
        assertEquals("setup: stage transitions to RUNNING", StageExecution.State.RUNNING, exec.getState());
    ) {
    }
                    exec.onTaskTerminal(task, null);
        assertSame("captured failure must be the original cause", injected, exec.getFailure());
    public void testRetargetForRetryAdvancesToNextReplica() {
import org.opensearch.analytics.exec.StreamingResponseListener;
        when(r1.currentNodeId()).thenReturn("node-replica-1");
}
        ClusterState clusterState = mock(ClusterState.class);
        CapturingSink sink = new CapturingSink();
    /**
        ShardFragmentStageExecution exec = buildExecution(sink, capturedListener);
import org.opensearch.transport.NodeDisconnectedException;
        );
        assertSame("original failure cause is retained", injected, exec.getFailure());
    }
        }
        ShardFragmentStageExecution exec = buildExecution(sink, capturedListener);
        ShardId shardId = new ShardId(new Index("idx", "uuid"), 0);
import org.opensearch.core.index.Index;
        Stage stage = mockStageWithTargets(n);
        DiscoveryNode replica2 = mock(DiscoveryNode.class);
        QueryContext config = mockQueryContext();
    }
        assertEquals("stage must fail-fast on first task failure", StageExecution.State.FAILED, exec.getState());
        when(clusterState.nodes()).thenReturn(nodes);
        ShardFragmentStageExecution exec = buildExecutionWithTargets(new CapturingSink(), 1);
    }
        assertNotNull("listener should have been captured by dispatch", capturedListener.get());
        assertEquals("StageTaskId preserved on attempt 2", initial.id(), task2.id());
     * its task as success, and returns {@code false} to stop the stream early (proven by isLast=false).
        DiscoveryNode primaryNode = mock(DiscoveryNode.class);
        if (dispatcher == null) return;
        ShardIterator shardIt = mock(ShardIterator.class);
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
        when(stage.getStageId()).thenReturn(0);
                FragmentExecutionArrowResponse>) invocation.getArgument(2);
import java.util.Optional;
    public void testFastFailsOnFirstTaskFailureWithoutWaitingForSiblings() {
        FragmentExecutionArrowResponse response = new FragmentExecutionArrowResponse(root);
    }
        ShardId shardId = new ShardId(new Index("idx", "uuid"), 0);
import java.util.concurrent.atomic.AtomicReference;
        when(replica1.getId()).thenReturn("node-replica-1");
    public void setUp() throws Exception {
            "test-query",
        VectorSchemaRoot root = createTestBatch(3);
    /** When the iterator has no more copies, retargetForRetry returns empty and the failure is terminal. */
            t.shardId(),
        when(nodes.get("node-replica-1")).thenReturn(replica1);
 */
     */
                }
        assertFalse("non-ShardStageTask must return empty", retry.isPresent());
    public void testRetargetForRetryReturnsEmptyWhenNextCopyNodeMissingFromClusterState() {
        ShardStageTask task1 = (ShardStageTask) attempt1.get();
 * this file be licensed under the Apache-2.0 license or a
        return config;
        when(primaryNode.getId()).thenReturn("node-primary");
    public void testStreamStopsAndTaskSucceedsWhenConsumerDone() {
import org.opensearch.core.action.ActionListener;
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        final List<VectorSchemaRoot> fed = new ArrayList<>();
        Optional<StageTask> retry = exec.retargetForRetry(failed, new NodeDisconnectedException(primaryNode, "test"));
        when(clusterState.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
        exec.onTaskTerminal(exec.tasks().get(2), new RuntimeException("late second failure"));
                    task.transitionTo(StageTaskState.FINISHED);
import org.opensearch.analytics.spi.ExchangeSink;
import org.apache.arrow.vector.types.pojo.ArrowType;
    public void tearDown() throws Exception {
            closed = true;
        // Attempt 3 → exhausted
        assertEquals("stage stays FAILED across late terminals", StageExecution.State.FAILED, exec.getState());
        AnalyticsSearchTransportService dispatcher = mock(AnalyticsSearchTransportService.class);
        when(clusterState.metadata()).thenReturn(Metadata.EMPTY_METADATA);
        ShardFragmentStageExecution exec = buildExecutionWithTargets(new CapturingSink(), 1);
        ShardStageTask initial = new ShardStageTask(new StageTaskId(0, 0), primaryTarget);
        return stage;
import org.apache.arrow.vector.types.pojo.FieldType;
 */
        sink.consumerDone = true; // consumer already satisfied before this batch arrives
            when(node.getId()).thenReturn("test-node-" + i);
            return consumerDone;
        ShardExecutionTarget primaryTarget = new ShardExecutionTarget(primaryNode, shardId, 0, shardIt, clusterState);
                }
        CapturingSink sink = new CapturingSink();
        when(clusterState.nodes()).thenReturn(nodes);
        // isLast=false: there are more batches upstream, but the consumer is done — we stop anyway.
        VectorSchemaRoot root = createTestBatch(3);
        when(primaryNode.getId()).thenReturn("node-primary");
        DiscoveryNode primaryNode = mock(DiscoveryNode.class);
 * compatible open source license.
        ShardId shardId = new ShardId(new Index("idx", "uuid"), 0);
import java.util.List;
        assertEquals("retry preserves the shardId", shardId, retriedTarget.shardId());
        doAnswer(invocation -> {
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
        Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = target -> new FragmentExecutionRequest(
        ClusterState clusterState = mock(ClusterState.class);
        ShardStageTask failed = new ShardStageTask(new StageTaskId(0, 0), target);
        when(replicaRouting.currentNodeId()).thenReturn("node-replica");
        when(shardIt.nextOrNull()).thenReturn(orphanReplicaRouting).thenReturn(null);
        assertEquals("Arrow buffers must be released after cancellation", 0, allocator.getAllocatedMemory());
    private ShardFragmentStageExecution buildExecution(
 * The OpenSearch Contributors require contributions made to
    private QueryContext mockQueryContext() {
        Optional<StageTask> retry = exec.retargetForRetry(failed, new NodeDisconnectedException(node, "test"));
        assertFalse("retry must be empty when no further copies exist", retry.isPresent());
        for (int i = 0; i < rows; i++) {
import org.opensearch.test.OpenSearchTestCase;
    /** Arrow batches arriving after the stage is cancelled must be closed (no buffer leak). */
import org.opensearch.analytics.planner.dag.TargetResolver;
        ShardExecutionTarget singletonTarget = new ShardExecutionTarget(primaryNode, shardId, 0, shardIt, clusterState);
        ShardId shardId = new ShardId(new Index("idx", "uuid"), 0);
import org.opensearch.analytics.exec.task.TaskRunner;
        // Later terminals must not overwrite the captured failure or trigger a spurious transition.
        when(clusterService.state()).thenReturn(mock(ClusterState.class));
        ShardFragmentStageExecution exec = buildExecutionWithTargets(sink, 3);
        when(config.parentTask()).thenReturn(mock(AnalyticsQueryTask.class));
        Optional<StageTask> retry = exec.retargetForRetry(failed, new NodeDisconnectedException(primaryNode, "test"));
import org.opensearch.cluster.ClusterState;
        when(shardIt.nextOrNull()).thenReturn(replicaRouting).thenReturn(null);
    }
        DiscoveryNode replica1 = mock(DiscoveryNode.class);
            return null;
            listenerCapture.set(listener);
        // Three copies total: primary already popped at resolve(), two replicas remain.
import org.apache.arrow.memory.RootAllocator;
import org.opensearch.analytics.exec.QueryContext;
    /** When the next copy's node has left the cluster state, retargetForRetry returns empty. */
                @Override
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
        assertTrue("retry target must be a ShardExecutionTarget", retriedTask.target() instanceof ShardExecutionTarget);
import org.opensearch.cluster.routing.ShardIterator;
        StageTask nonShardTask = new StageTask(new StageTaskId(0, 0)) {
        vec.setValueCount(rows);
            targets.add(new ShardExecutionTarget(node, new ShardId("idx", "_na_", i), i));
        Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = t -> new FragmentExecutionRequest(
    private ShardFragmentStageExecution buildExecutionWithTargets(CapturingSink sink, int n) {
import org.apache.arrow.vector.types.pojo.Schema;
        ShardStageTask task2 = (ShardStageTask) attempt2.get();
        return root;
     * Retry on shard failure advances to the next copy in the shard iterator and preserves the original
        @SuppressWarnings("unchecked")
            "test-query",
        Stage stage = mockStage();
import static org.mockito.Mockito.when;
        when(clusterState.metadata()).thenReturn(Metadata.EMPTY_METADATA);
        ShardRouting r2 = mock(ShardRouting.class);
     */
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> listenerCapture
        allocator.close();
        Stage stage = mock(Stage.class);
        when(nodes.get("node-replica-2")).thenReturn(replica2);
        // Attempt 2 → replica 2 (chained off the previous retry task — the iterator advances)
    private ClusterService mockClusterService() {
    private Stage mockStage() {
        @Override
            for (VectorSchemaRoot batch : fed) {
            fed.add(batch);
    }
        assertNotNull("listener should have been captured by dispatch", capturedListener.get());
        assertFalse("retry must be empty when the iterator's next copy points at a vanished node", retry.isPresent());
        ShardIterator shardIt = mock(ShardIterator.class);
import org.apache.arrow.vector.types.pojo.Field;
        ClusterService cs = mockClusterService();
        assertEquals("retry must dispatch to the next copy (replica)", "node-replica", retriedTarget.node().getId());
    /**
        ShardExecutionTarget retriedTarget = (ShardExecutionTarget) retriedTask.target();
                    exec.onTaskTerminal(task, cause);
        public void close() {
    private static final class CapturingSink implements ExchangeSink {
        // Iterator state: primary already consumed at resolve() time, replica is next.
        assertFalse("retry must be empty for legacy targets without iterator state", retry.isPresent());
        ShardRouting r1 = mock(ShardRouting.class);
     * slot, and the chain returns empty once copies are exhausted.
        scheduleAndDispatch(exec);
        CapturingSink sink,
        ShardFragmentStageExecution exec = buildExecutionWithTargets(new CapturingSink(), 1);
        scheduleAndDispatch(exec);
     * {@link StageTaskId} slot, so the scheduler treats it as a retry of the same partition.
        @Override
        ShardExecutionTarget target = new ShardExecutionTarget(primaryNode, shardId, 0, shardIt, clusterState);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
    /** Mirrors {@code QueryExecution.scheduleStage}: start, then run each task through the dispatcher. */
        when(primaryRouting.currentNodeId()).thenReturn("node-primary");
        assertTrue("batch should have allocated memory", allocatedBefore > 0);
        when(stage.getTargetResolver()).thenReturn(resolver);
    @Override
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
import org.opensearch.analytics.exec.stage.shard.ShardStageTask;
    }
     * The stage fails on the first failing task without waiting for siblings, and later terminals are
        for (int i = 0; i < n; i++) {
        ClusterState clusterState = mock(ClusterState.class);
        assertTrue("first retry must be present", attempt1.isPresent());
        when(shardIt.nextOrNull()).thenReturn(r1).thenReturn(r2).thenReturn(null);
    /** Builds a stage execution with N tasks; dispatcher is a no-op stub since the test invokes onTaskTerminal directly. */
        TaskRunner<StageTask> dispatcher = (TaskRunner<StageTask>) exec.taskRunner();
        scheduleAndDispatch(exec);
        // Attempt 1 → replica 1
        );
    /**
        Schema schema = new Schema(List.of(new Field("value", FieldType.nullable(new ArrowType.Int(32, true)), null)));
        assertEquals("sink should have received the batch", 1, sink.fed.size());
            }
        when(config.bufferAllocator()).thenReturn(allocator);
        root.setRowCount(rows);
            @SuppressWarnings("unchecked")
        AnalyticsSearchTransportService dispatcher = mock(AnalyticsSearchTransportService.class);
import org.opensearch.cluster.node.DiscoveryNodes;
        assertEquals("task completes as SUCCESS (not cancelled/failed)", StageExecution.State.SUCCEEDED, exec.getState());
/*
        when(orphanReplicaRouting.currentNodeId()).thenReturn("node-gone");
        assertEquals("attempt 1 routes to replica 1", "node-replica-1", ((ShardExecutionTarget) task1.target()).node().getId());
import java.util.function.Function;
        public void feed(VectorSchemaRoot batch) {
        assertEquals("attempt 2 routes to replica 2", "node-replica-2", ((ShardExecutionTarget) task2.target()).node().getId());
        }
import org.apache.arrow.vector.IntVector;
        when(nodes.get("node-gone")).thenReturn(null);  // node left the cluster
        assertFalse("third retry must be empty — all copies exhausted", attempt3.isPresent());
            List.of(new FragmentExecutionRequest.PlanAlternative("test-backend", new byte[0], List.of()))
        when(clusterState.metadata()).thenReturn(Metadata.EMPTY_METADATA);
        assertFalse("listener must signal stop when the consumer is done", keepReading);
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
        }
    }
        ClusterService clusterService = mock(ClusterService.class);
    /**
        ShardFragmentStageExecution exec = buildExecutionWithTargets(new CapturingSink(), 1);
    }
        super.setUp();
    public void testRetargetForRetryReturnsEmptyWhenTargetCarriesNoIterator() {
            0,
    // ── helpers ──────────────────────────────────────────────────────────
 *
        ClusterService clusterService = mockClusterService();
        when(nodes.get("node-primary")).thenReturn(primaryNode);
        sink.close();
        assertEquals("StageTaskId preserved on attempt 1", initial.id(), task1.id());
     */
        assertTrue("sink should not have received any batch", sink.fed.isEmpty());
        when(r1.shardId()).thenReturn(shardId);
        }
        capturedListener.get().onStreamResponse(response, true);
        when(nodes.get("node-primary")).thenReturn(primaryNode);
        when(shardIt.nextOrNull()).thenReturn(null);  // primary already consumed; no replicas
        when(primaryRouting.shardId()).thenReturn(shardId);
        allocator = new RootAllocator();
        ShardExecutionTarget primaryTarget = new ShardExecutionTarget(primaryNode, shardId, 0, shardIt, clusterState);
    }
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
        IntVector vec = (IntVector) root.getVector(0);
        return new ShardFragmentStageExecution(stage, config, sink, cs, requestBuilder, dispatcher);
    }
        CapturingSink sink = new CapturingSink();
     */
        ShardRouting orphanReplicaRouting = mock(ShardRouting.class);
        FragmentExecutionArrowResponse response = new FragmentExecutionArrowResponse(root);
    }
        when(clusterState.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
        when(primaryNode.getId()).thenReturn("node-primary");
import org.opensearch.cluster.node.DiscoveryNode;
        DiscoveryNode replicaNode = mock(DiscoveryNode.class);
        @Override
        };
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
import static org.mockito.Mockito.doAnswer;
        return mockStageWithTargets(1);
        when(replicaNode.getId()).thenReturn("node-replica");
import org.opensearch.core.index.shard.ShardId;
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
            });
        when(r2.shardId()).thenReturn(shardId);
        boolean keepReading = capturedListener.get().onStreamResponse(response, false);
        DiscoveryNode node = mock(DiscoveryNode.class);
        assertEquals("the in-hand batch is still fed before stopping", 1, sink.fed.size());
        ShardFragmentStageExecution exec = buildExecutionWithTargets(new CapturingSink(), 1);
        ShardFragmentStageExecution exec = buildExecution(sink, capturedListener);
    public void testRetargetForRetryChainAdvancesEachAttemptUntilExhausted() {
                    task.transitionTo(StageTaskState.FAILED);
import org.opensearch.analytics.exec.stage.shard.ShardFragmentStageExecution;
import org.apache.arrow.vector.VectorSchemaRoot;
        when(config.maxConcurrentShardRequestsPerNode()).thenReturn(5);
import org.opensearch.cluster.routing.ShardRouting;
        when(clusterState.nodes()).thenReturn(nodes);
        long allocatedBefore = allocator.getAllocatedMemory();
        when(clusterState.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
    /** A target with no iterator state (legacy constructor) returns empty rather than NPE — no failover. */
            dispatcher.run(task, new ActionListener<>() {
        Optional<StageTask> attempt3 = exec.retargetForRetry(task2, new NodeDisconnectedException(replica2, "boom"));
    private Stage mockStageWithTargets(int n) {
            StreamingResponseListener<FragmentExecutionArrowResponse> listener = (StreamingResponseListener<
        when(clusterState.metadata()).thenReturn(Metadata.EMPTY_METADATA);
        ShardRouting primaryRouting = mock(ShardRouting.class);
        FragmentExecutionArrowResponse response = new FragmentExecutionArrowResponse(root);
    }
            task.transitionTo(StageTaskState.RUNNING);
    public void testRetargetForRetryReturnsEmptyWhenCopiesExhausted() {
    /** A task that isn't a {@code ShardStageTask} returns empty rather than crashing — non-retryable. */
    private BufferAllocator allocator;
        return new ShardFragmentStageExecution(stage, config, sink, clusterService, requestBuilder, dispatcher);
        ShardExecutionTarget legacyTarget = new ShardExecutionTarget(node, shardId, 0);  // no iterator wired
        RuntimeException injected = new RuntimeException("first task failure");
        root.allocateNew();
/**
import static org.mockito.Mockito.mock;
        when(clusterState.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
        QueryContext config = mock(QueryContext.class);
            0,
    /** Mock stage whose resolver returns {@code n} distinct shard targets (one per fake node). */
        Optional<StageTask> retry = exec.retargetForRetry(failed, new NodeDisconnectedException(primaryNode, "test"));
import org.apache.arrow.memory.BufferAllocator;
        exec.onTaskTerminal(exec.tasks().get(0), injected);
        DiscoveryNode primaryNode = mock(DiscoveryNode.class);
        public boolean isConsumerDone() {
        ShardId shardId = new ShardId(new Index("idx", "uuid"), 0);
        }
        return clusterService;
        CapturingSink sink = new CapturingSink();
import java.util.ArrayList;
        ShardFragmentStageExecution exec = buildExecutionWithTargets(new CapturingSink(), 1);
 * and replica failover via {@code retargetForRetry}.
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
import org.opensearch.cluster.service.ClusterService;
        ShardRouting replicaRouting = mock(ShardRouting.class);
        capturedListener.get().onStreamResponse(response, true);
            vec.setSafe(i, i);
        VectorSchemaRoot root = createTestBatch(5);
        QueryContext config = mockQueryContext();
    }
    }
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
        volatile boolean consumerDone = false;
            DiscoveryNode node = mock(DiscoveryNode.class);
     * Across consecutive failures each retry advances exactly one copy, preserves the {@link StageTaskId}
        when(resolver.resolve(any(ClusterState.class), any())).thenReturn(targets);
        when(node.getId()).thenReturn("node-only");
    public void testRetargetForRetryReturnsEmptyForNonShardStageTask() {
        assertTrue("retry must be present when replica copies remain", retry.isPresent());
        ShardIterator shardIt = mock(ShardIterator.class);
    }
        sink.close();
        ShardStageTask retriedTask = (ShardStageTask) retry.get();
            target.shardId(),
    private VectorSchemaRoot createTestBatch(int rows) {
        ShardStageTask failed = new ShardStageTask(new StageTaskId(0, 0), singletonTarget);
import org.opensearch.analytics.planner.dag.Stage;
    }
                batch.close();
     * no-ops that don't overwrite the original cause.
        assertTrue("retry must be a ShardStageTask", retry.get() instanceof ShardStageTask);
        when(replicaRouting.shardId()).thenReturn(shardId);
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
 * Tests for {@link ShardFragmentStageExecution}: Arrow resource cleanup, terminal state transitions,
    }
        when(orphanReplicaRouting.shardId()).thenReturn(shardId);
    private static void scheduleAndDispatch(ShardFragmentStageExecution exec) {
        exec.onTaskTerminal(exec.tasks().get(1), null);
        when(replica2.getId()).thenReturn("node-replica-2");
        TargetResolver resolver = mock(TargetResolver.class);
        DiscoveryNode primaryNode = mock(DiscoveryNode.class);
        when(clusterState.nodes()).thenReturn(mock(DiscoveryNodes.class));
        super.tearDown();
    @Override
