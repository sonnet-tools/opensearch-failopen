        ShardStageTask task1 = (ShardStageTask) attempt1.get();
        Schema schema = new Schema(List.of(new Field("value", FieldType.nullable(new ArrowType.Int(32, true)), null)));  
        };
        for (int i = 0; i < rows; i++) {
     * Retry on shard failure advances to the next copy in the shard iterator and preserves the original
        Optional<StageTask> retry = exec.retargetForRetry(failed, new NodeDisconnectedException(primaryNode, "test"));  
     * slot, and the chain returns empty once copies are exhausted.
        }
        boolean keepReading = capturedListener.get().onStreamResponse(response, false);
        when(r1.shardId()).thenReturn(shardId);
        public boolean isConsumerDone() {  
        StageTask nonShardTask = new StageTask(new StageTaskId(0, 0)) {
        }  
        TargetResolver resolver = mock(TargetResolver.class);
            when(node.getId()).thenReturn("test-node-" + i);  
    public void testRetargetForRetryReturnsEmptyWhenCopiesExhausted() {
        capturedListener.get().onStreamResponse(response, true);  
        assertTrue("batch should have allocated memory", allocatedBefore > 0);  
    }
        DiscoveryNode replica2 = mock(DiscoveryNode.class);  
        ShardStageTask failed = new ShardStageTask(new StageTaskId(0, 0), primaryTarget);
        Optional<StageTask> retry = exec.retargetForRetry(nonShardTask, new NodeDisconnectedException(mock(DiscoveryNode.class), "test"));
        when(stage.getStageId()).thenReturn(0);
            return null;
        when(config.bufferAllocator()).thenReturn(allocator);  
        for (int i = 0; i < n; i++) {
        }  
        exec.onTaskTerminal(exec.tasks().get(1), null);
        when(stage.getTargetResolver()).thenReturn(resolver);
        VectorSchemaRoot root = createTestBatch(3);
        RuntimeException injected = new RuntimeException("first task failure");  
    private static void scheduleAndDispatch(ShardFragmentStageExecution exec) {
     * Across consecutive failures each retry advances exactly one copy, preserves the {@link StageTaskId}  
        ShardRouting r1 = mock(ShardRouting.class);  
    }
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        }
     * When the downstream consumer is already done, the shard listener feeds the in-hand batch, settles
    @Override  
import org.opensearch.analytics.exec.stage.shard.ShardStageTask;  
        assertTrue("retry must be present when replica copies remain", retry.isPresent());  
 * compatible open source license.
    public void testStreamStopsAndTaskSucceedsWhenConsumerDone() {
        when(r2.currentNodeId()).thenReturn("node-replica-2");
     */  
        FragmentExecutionArrowResponse response = new FragmentExecutionArrowResponse(root);
                public void onFailure(Exception cause) {
    public void testFastFailsOnFirstTaskFailureWithoutWaitingForSiblings() {
        }
    }  
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;  
        Stage stage = mockStage();  
    private QueryContext mockQueryContext() {
        assertEquals("the in-hand batch is still fed before stopping", 1, sink.fed.size());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("StageTaskId preserved on attempt 2", initial.id(), task2.id());
        return config;
        @Override
        sink.close();  
 * SPDX-License-Identifier: Apache-2.0
    public void testRetargetForRetryReturnsEmptyWhenTargetCarriesNoIterator() {  
    /** A target with no iterator state (legacy constructor) returns empty rather than NPE — no failover. */
        when(orphanReplicaRouting.shardId()).thenReturn(shardId);  
        capturedListener.get().onStreamResponse(response, true);
    }
        AnalyticsSearchTransportService dispatcher = mock(AnalyticsSearchTransportService.class);  
        ClusterState clusterState = mock(ClusterState.class);
     * its task as success, and returns {@code false} to stop the stream early (proven by isLast=false).
import org.apache.arrow.memory.BufferAllocator;
    }
    public void testRetargetForRetryReturnsEmptyWhenNextCopyNodeMissingFromClusterState() {
    private Stage mockStageWithTargets(int n) {
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        ShardExecutionTarget primaryTarget = new ShardExecutionTarget(primaryNode, shardId, 0, shardIt, clusterState);
        Optional<StageTask> attempt3 = exec.retargetForRetry(task2, new NodeDisconnectedException(replica2, "boom"));
        ShardStageTask failed = new ShardStageTask(new StageTaskId(0, 0), target);  
import org.apache.arrow.vector.types.pojo.Field;  
    }
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
        Optional<StageTask> retry = exec.retargetForRetry(failed, new NodeDisconnectedException(primaryNode, "test"));
        when(clusterState.metadata()).thenReturn(Metadata.EMPTY_METADATA);  
    private ClusterService mockClusterService() {
                    task.transitionTo(StageTaskState.FINISHED);
    /**  
        // Attempt 3 → exhausted
        scheduleAndDispatch(exec);
        ShardId shardId = new ShardId(new Index("idx", "uuid"), 0);  
import org.opensearch.analytics.exec.stage.shard.ShardFragmentStageExecution;
        assertTrue("first retry must be present", attempt1.isPresent());
        when(primaryRouting.currentNodeId()).thenReturn("node-primary");  
/*  
    private static final class CapturingSink implements ExchangeSink {
        CapturingSink sink = new CapturingSink();
        assertEquals("setup: one task per target", 3, exec.tasks().size());
    public void testRetargetForRetryChainAdvancesEachAttemptUntilExhausted() {  
        allocator = new RootAllocator();  
    /**  
import org.opensearch.cluster.metadata.Metadata;
        return clusterService;
        }).when(dispatcher).dispatchFragmentStreaming(any(), any(), any(), any(), any(), any());
        assertTrue("second retry must be present", attempt2.isPresent());
        when(clusterState.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
     */  
        assertEquals("Arrow buffers must be released after cancellation", 0, allocator.getAllocatedMemory());
        public void close() {
        boolean closed = false;  
        when(nodes.get("node-replica")).thenReturn(replicaNode);
                    exec.onTaskTerminal(task, null);  
        DiscoveryNode node = mock(DiscoveryNode.class);
        assertFalse("listener must signal stop when the consumer is done", keepReading);  
            target.shardId(),
    public void setUp() throws Exception {
        ShardId shardId = new ShardId(new Index("idx", "uuid"), 0);
        QueryContext config = mockQueryContext();
        final List<VectorSchemaRoot> fed = new ArrayList<>();
        assertEquals("retry must dispatch to the next copy (replica)", "node-replica", retriedTarget.node().getId());  
        assertEquals("task completes as SUCCESS (not cancelled/failed)", StageExecution.State.SUCCEEDED, exec.getState());
            task.transitionTo(StageTaskState.RUNNING);
        );  
import org.opensearch.cluster.service.ClusterService;
    }
 */  
        ClusterState clusterState = mock(ClusterState.class);  
}  
        ShardIterator shardIt = mock(ShardIterator.class);  
    }  
        assertEquals("sink should have received the batch", 1, sink.fed.size());
    }  
    private BufferAllocator allocator;
        }  
        ClusterService clusterService = mock(ClusterService.class);
        TaskRunner<StageTask> dispatcher = (TaskRunner<StageTask>) exec.taskRunner();
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();  
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;  
        ShardFragmentStageExecution exec = buildExecutionWithTargets(new CapturingSink(), 1);  
        for (StageTask task : exec.tasks()) {  
        @Override  
    /** When the next copy's node has left the cluster state, retargetForRetry returns empty. */
        FragmentExecutionArrowResponse response = new FragmentExecutionArrowResponse(root);
import org.opensearch.cluster.ClusterState;
        ShardStageTask failed = new ShardStageTask(new StageTaskId(0, 0), singletonTarget);  
        assertTrue("sink should not have received any batch", sink.fed.isEmpty());  
        assertEquals("attempt 2 routes to replica 2", "node-replica-2", ((ShardExecutionTarget) task2.target()).node().getId());
        Optional<StageTask> retry = exec.retargetForRetry(failed, new NodeDisconnectedException(primaryNode, "test"));  
            vec.setSafe(i, i);
import org.opensearch.analytics.exec.StreamingResponseListener;
        when(nodes.get("node-replica-1")).thenReturn(replica1);
import static org.mockito.ArgumentMatchers.any;
/**
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
     * no-ops that don't overwrite the original cause.
        List<org.opensearch.analytics.planner.dag.ExecutionTarget> targets = new ArrayList<>(n);  
        ShardRouting replicaRouting = mock(ShardRouting.class);
                }
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;  
import org.apache.arrow.memory.RootAllocator;
        when(nodes.get("node-primary")).thenReturn(primaryNode);  
    }
        assertFalse("retry must be empty when no further copies exist", retry.isPresent());
        when(clusterState.nodes()).thenReturn(nodes);  
        ShardId shardId = new ShardId(new Index("idx", "uuid"), 0);  
        assertEquals("retry preserves the shardId", shardId, retriedTarget.shardId());
            }  
        // Iterator state: primary already consumed at resolve() time, replica is next.
    /** Mirrors {@code QueryExecution.scheduleStage}: start, then run each task through the dispatcher. */  
        assertFalse("retry must be empty when the iterator's next copy points at a vanished node", retry.isPresent());
        ShardStageTask retriedTask = (ShardStageTask) retry.get();
    }
        CapturingSink sink = new CapturingSink();  
                    exec.onTaskTerminal(task, cause);  
        assertFalse("non-ShardStageTask must return empty", retry.isPresent());
        CapturingSink sink,  
        ShardFragmentStageExecution exec = buildExecutionWithTargets(new CapturingSink(), 1);
            });
        Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = target -> new FragmentExecutionRequest(
import java.util.List;  
 */
        when(resolver.resolve(any(ClusterState.class), any())).thenReturn(targets);  
        when(replicaRouting.shardId()).thenReturn(shardId);
        ShardIterator shardIt = mock(ShardIterator.class);
        if (dispatcher == null) return;
        ShardFragmentStageExecution exec = buildExecution(sink, capturedListener);
        when(primaryNode.getId()).thenReturn("node-primary");  
     * The stage fails on the first failing task without waiting for siblings, and later terminals are
        CapturingSink sink = new CapturingSink();  
    }  
        assertFalse("retry must be empty for legacy targets without iterator state", retry.isPresent());
import org.opensearch.analytics.exec.QueryContext;
import static org.mockito.Mockito.doAnswer;  
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
import org.apache.arrow.vector.types.pojo.Schema;
        FragmentExecutionArrowResponse response = new FragmentExecutionArrowResponse(root);
        when(replicaNode.getId()).thenReturn("node-replica");  
    /** Builds a stage execution with N tasks; dispatcher is a no-op stub since the test invokes onTaskTerminal directly. */
public class ShardFragmentStageExecutionTests extends OpenSearchTestCase {
            listenerCapture.set(listener);  
    public void testRetargetForRetryReturnsEmptyForNonShardStageTask() {  
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            List.of(new FragmentExecutionRequest.PlanAlternative("test-backend", new byte[0], List.of()))  
import java.util.Optional;
        ShardRouting primaryRouting = mock(ShardRouting.class);
            List.of(new FragmentExecutionRequest.PlanAlternative("test-backend", new byte[0], List.of()))
        assertTrue("retry must be a ShardStageTask", retry.get() instanceof ShardStageTask);
        super.setUp();
        Optional<StageTask> attempt2 = exec.retargetForRetry(task1, new NodeDisconnectedException(replica1, "boom"));
import org.opensearch.analytics.spi.ExchangeSink;  
        scheduleAndDispatch(exec);
    }
        ShardStageTask task2 = (ShardStageTask) attempt2.get();  
        );
        assertEquals("setup: stage transitions to RUNNING", StageExecution.State.RUNNING, exec.getState());  
        when(nodes.get("node-gone")).thenReturn(null);  // node left the cluster  
        assertEquals("stage must fail-fast on first task failure", StageExecution.State.FAILED, exec.getState());  
    }
    private ShardFragmentStageExecution buildExecutionWithTargets(CapturingSink sink, int n) {  
        // Attempt 2 → replica 2 (chained off the previous retry task — the iterator advances)  
        vec.setValueCount(rows);
    public void testArrowResponseClosedWhenStageAlreadyCancelled() {
    private VectorSchemaRoot createTestBatch(int rows) {
        when(replicaRouting.currentNodeId()).thenReturn("node-replica");  
        // Later terminals must not overwrite the captured failure or trigger a spurious transition.  
import org.opensearch.cluster.node.DiscoveryNodes;
        when(replica2.getId()).thenReturn("node-replica-2");
import org.opensearch.transport.NodeDisconnectedException;  
                FragmentExecutionArrowResponse>) invocation.getArgument(2);
        assertEquals("stage stays FAILED across late terminals", StageExecution.State.FAILED, exec.getState());  
        assertSame("original failure cause is retained", injected, exec.getFailure());
        when(config.parentTask()).thenReturn(mock(AnalyticsQueryTask.class));
        ShardStageTask initial = new ShardStageTask(new StageTaskId(0, 0), primaryTarget);
        exec.onTaskTerminal(exec.tasks().get(0), injected);
        ShardFragmentStageExecution exec = buildExecutionWithTargets(sink, 3);  
        // Attempt 1 → replica 1
        when(primaryRouting.shardId()).thenReturn(shardId);
        allocator.close();
        assertEquals("retry preserves the StageTaskId slot", failed.id(), retriedTask.id());  
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
        VectorSchemaRoot root = createTestBatch(5);
                @Override  
        ClusterState clusterState = mock(ClusterState.class);
            targets.add(new ShardExecutionTarget(node, new ShardId("idx", "_na_", i), i));
    /** When the iterator has no more copies, retargetForRetry returns empty and the failure is terminal. */
import org.opensearch.cluster.routing.ShardRouting;  
        IntVector vec = (IntVector) root.getVector(0);  
    private Stage mockStage() {  
                public void onResponse(Void unused) {
        when(shardIt.nextOrNull()).thenReturn(null);  // primary already consumed; no replicas
        ShardId shardId = new ShardId(new Index("idx", "uuid"), 0);
import org.opensearch.analytics.planner.dag.Stage;
        Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = t -> new FragmentExecutionRequest(
                @Override  
        when(nodes.get("node-replica-2")).thenReturn(replica2);
        when(shardIt.nextOrNull()).thenReturn(orphanReplicaRouting).thenReturn(null);
import org.opensearch.cluster.node.DiscoveryNode;  
        ShardFragmentStageExecution exec = buildExecutionWithTargets(new CapturingSink(), 1);
        DiscoveryNode primaryNode = mock(DiscoveryNode.class);
    /** A task that isn't a {@code ShardStageTask} returns empty rather than crashing — non-retryable. */
        return new ShardFragmentStageExecution(stage, config, sink, cs, requestBuilder, dispatcher);
     */
    }  
        exec.cancel("test");
        when(replica1.getId()).thenReturn("node-replica-1");
import static org.mockito.Mockito.mock;
                }
        when(clusterState.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
        ClusterService cs = mockClusterService();  
        super.tearDown();  
        when(primaryNode.getId()).thenReturn("node-primary");
            closed = true;  
    ) {
            0,
import org.apache.arrow.vector.types.pojo.ArrowType;
        DiscoveryNode primaryNode = mock(DiscoveryNode.class);
        ShardExecutionTarget target = new ShardExecutionTarget(primaryNode, shardId, 0, shardIt, clusterState);
    }
        CapturingSink sink = new CapturingSink();
        ShardFragmentStageExecution exec = buildExecutionWithTargets(new CapturingSink(), 1);
        assertEquals(StageExecution.State.CANCELLED, exec.getState());
        ShardExecutionTarget singletonTarget = new ShardExecutionTarget(primaryNode, shardId, 0, shardIt, clusterState);
        QueryContext config = mock(QueryContext.class);  
        when(clusterState.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
            "test-query",  
        root.allocateNew();
        when(shardIt.nextOrNull()).thenReturn(replicaRouting).thenReturn(null);
     * {@link StageTaskId} slot, so the scheduler treats it as a retry of the same partition.
    /** Mock stage whose resolver returns {@code n} distinct shard targets (one per fake node). */
            "test-query",
        ShardFragmentStageExecution exec = buildExecutionWithTargets(new CapturingSink(), 1);
        @Override
import org.opensearch.analytics.exec.task.TaskRunner;
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> listenerCapture
        ShardStageTask failed = new ShardStageTask(new StageTaskId(0, 0), legacyTarget);  
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
import org.apache.arrow.vector.IntVector;  
        exec.onTaskTerminal(exec.tasks().get(2), new RuntimeException("late second failure"));
        DiscoveryNode primaryNode = mock(DiscoveryNode.class);  
import static org.mockito.Mockito.when;
        assertEquals("attempt 1 routes to replica 1", "node-replica-1", ((ShardExecutionTarget) task1.target()).node().getId());
    @Override  
        sink.close();  
        DiscoveryNode replica1 = mock(DiscoveryNode.class);
        ClusterState clusterState = mock(ClusterState.class);
        assertNotNull("listener should have been captured by dispatch", capturedListener.get());
     */  
                batch.close();
        @SuppressWarnings("unchecked")  
        DiscoveryNode replicaNode = mock(DiscoveryNode.class);
        when(config.maxConcurrentShardRequestsPerNode()).thenReturn(5);
        public void feed(VectorSchemaRoot batch) {
        VectorSchemaRoot root = createTestBatch(3);  
                    task.transitionTo(StageTaskState.FAILED);
        when(orphanReplicaRouting.currentNodeId()).thenReturn("node-gone");
        assertFalse("third retry must be empty — all copies exhausted", attempt3.isPresent());  
            return consumerDone;
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        // Three copies total: primary already popped at resolve(), two replicas remain.
    private ShardFragmentStageExecution buildExecution(
            DiscoveryNode node = mock(DiscoveryNode.class);
import org.opensearch.analytics.planner.dag.TargetResolver;
        when(clusterService.state()).thenReturn(mock(ClusterState.class));  
        ShardRouting r2 = mock(ShardRouting.class);  
        Optional<StageTask> attempt1 = exec.retargetForRetry(initial, new NodeDisconnectedException(primaryNode, "boom"));  
            @SuppressWarnings("unchecked")  
        when(clusterState.metadata()).thenReturn(Metadata.EMPTY_METADATA);
        when(clusterState.metadata()).thenReturn(Metadata.EMPTY_METADATA);
        ShardExecutionTarget primaryTarget = new ShardExecutionTarget(primaryNode, shardId, 0, shardIt, clusterState);  
        AnalyticsSearchTransportService dispatcher = mock(AnalyticsSearchTransportService.class);
        when(r2.shardId()).thenReturn(shardId);
    }
        // isLast=false: there are more batches upstream, but the consumer is done — we stop anyway.  
            0,  
            for (VectorSchemaRoot batch : fed) {
        ShardExecutionTarget retriedTarget = (ShardExecutionTarget) retriedTask.target();
        when(clusterState.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
        assertSame("captured failure must be the original cause", injected, exec.getFailure());
        when(r1.currentNodeId()).thenReturn("node-replica-1");
        when(nodes.get("node-primary")).thenReturn(primaryNode);  
        ShardIterator shardIt = mock(ShardIterator.class);  
        ShardFragmentStageExecution exec = buildExecution(sink, capturedListener);  
            t.shardId(),
        when(clusterState.metadata()).thenReturn(Metadata.EMPTY_METADATA);
        ShardFragmentStageExecution exec = buildExecution(sink, capturedListener);  
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to  
        ShardFragmentStageExecution exec = buildExecutionWithTargets(new CapturingSink(), 1);  
            dispatcher.run(task, new ActionListener<>() {
 * Tests for {@link ShardFragmentStageExecution}: Arrow resource cleanup, terminal state transitions,
    public void testRetargetForRetryAdvancesToNextReplica() {
import org.opensearch.cluster.routing.ShardIterator;
        return mockStageWithTargets(1);
    /**
    /** Arrow batches arriving after the stage is cancelled must be closed (no buffer leak). */  
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
 * and replica failover via {@code retargetForRetry}.  
        return stage;
        Stage stage = mock(Stage.class);  
        Stage stage = mockStageWithTargets(n);
        ShardIterator shardIt = mock(ShardIterator.class);
import org.apache.arrow.vector.types.pojo.FieldType;
        assertNotNull("listener should have been captured by dispatch", capturedListener.get());
            StreamingResponseListener<FragmentExecutionArrowResponse> listener = (StreamingResponseListener<
        when(clusterState.nodes()).thenReturn(nodes);  
    }  
        DiscoveryNode primaryNode = mock(DiscoveryNode.class);
        when(primaryNode.getId()).thenReturn("node-primary");
        when(primaryNode.getId()).thenReturn("node-primary");
    /**  
        Optional<StageTask> retry = exec.retargetForRetry(failed, new NodeDisconnectedException(node, "test"));  
    public void tearDown() throws Exception {
import org.opensearch.core.index.shard.ShardId;
 *
        return root;  
import org.opensearch.core.index.Index;  
    // ── helpers ──────────────────────────────────────────────────────────  
    }
        root.setRowCount(rows);
    }
import java.util.function.Function;  
            fed.add(batch);
        ShardId shardId = new ShardId(new Index("idx", "uuid"), 0);
import org.opensearch.core.action.ActionListener;
        ClusterService clusterService = mockClusterService();
        QueryContext config = mockQueryContext();
    /** On the happy path, batches are fed into the sink and the stage succeeds. */
        AtomicReference<StreamingResponseListener<FragmentExecutionArrowResponse>> capturedListener = new AtomicReference<>();
        when(clusterState.nodes()).thenReturn(mock(DiscoveryNodes.class));
import org.opensearch.test.OpenSearchTestCase;
import java.util.concurrent.atomic.AtomicReference;
        assertTrue("retry target must be a ShardExecutionTarget", retriedTask.target() instanceof ShardExecutionTarget);
        ShardRouting orphanReplicaRouting = mock(ShardRouting.class);
        long allocatedBefore = allocator.getAllocatedMemory();
        when(clusterState.nodes()).thenReturn(nodes);  
        sink.consumerDone = true; // consumer already satisfied before this batch arrives
        assertEquals("StageTaskId preserved on attempt 1", initial.id(), task1.id());  
        when(shardIt.nextOrNull()).thenReturn(r1).thenReturn(r2).thenReturn(null);
        when(node.getId()).thenReturn("node-only");  
        doAnswer(invocation -> {
        return new ShardFragmentStageExecution(stage, config, sink, clusterService, requestBuilder, dispatcher);
        scheduleAndDispatch(exec);  
    }
    public void testArrowResponseFedToSinkOnHappyPath() {
        volatile boolean consumerDone = false;
package org.opensearch.analytics.exec.stage;
        ShardExecutionTarget legacyTarget = new ShardExecutionTarget(node, shardId, 0);  // no iterator wired
import org.apache.arrow.vector.VectorSchemaRoot;
