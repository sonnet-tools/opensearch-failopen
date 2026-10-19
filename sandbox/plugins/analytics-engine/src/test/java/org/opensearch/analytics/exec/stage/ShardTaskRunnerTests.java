        assertEquals(4, captured.size());  
 * The OpenSearch Contributors require contributions made to  
    public void testTasksOnDifferentNodesGetSeparatePendingQueues() {
        assertSame(captured.get(1), captured.get(2));
 */  
        assertEquals("both tasks dispatched", 2, captured.size());
    public void testPendingQueueIsLazilyCreatedAndCached() {
        ShardStageTask onB = shardTask(1, "node-B");
        runner.run(shardTask(2, "node-A"), noopHandle());
        assertNotSame("tasks on different nodes get distinct queues", captured.get(0), captured.get(1));  
        ShardTaskRunner runner = newRunner(captured);  
            pending.tryRun(() -> captured.add(pending)); // holds a permit; never finished
        List<PendingExecutions> captured = new ArrayList<>();  
        ShardFragmentStageExecution stage = mock(ShardFragmentStageExecution.class);  
package org.opensearch.analytics.exec.stage;
        AnalyticsSearchTransportService transport = mock(AnalyticsSearchTransportService.class);
        }).when(transport).dispatchFragmentStreaming(any(), any(), any(), any(), any(), any());  
        assertEquals("third task runs once a permit frees", 3, captured.size());
        runner.run(onB, noopHandle());  
import org.opensearch.analytics.exec.stage.shard.ShardStageTask;  
        captured.get(0).finishAndRunNext();
/**  
    private static ShardStageTask shardTask(int partitionId, String nodeId) {  
        ShardStageTask t1 = shardTask(1, "node-A");  
/*  
        when(config.maxConcurrentShardRequestsPerNode()).thenReturn(5);
            capturedQueues.add(inv.getArgument(4));  // 5th arg is PendingExecutions
    }
        runner.run(shardTask(2, "node-A"), noopHandle());  
        // Release one permit → the queued third task runs.  
public class ShardTaskRunnerTests extends OpenSearchTestCase {
        // First three dispatches on node-A reuse the same queue; the fourth on node-B is fresh.  
        when(config.parentTask()).thenReturn(mock(AnalyticsQueryTask.class));  
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
 *
        ShardTaskRunner runner = newRunner(captured);
        Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = t -> mock(FragmentExecutionRequest.class);
        return new ShardStageTask(new StageTaskId(0, partitionId), target);
import java.util.function.Function;
        assertSame("tasks on same node reuse the same pending queue", captured.get(0), captured.get(1));
import static org.mockito.Mockito.when;
     * same-node task is held until a permit frees.
        }).when(transport).dispatchFragmentStreaming(any(), any(), any(), any(), any(), any());  
        runner.run(onA, noopHandle());
        // Three tasks on the same node share one queue (limit 2) — the third is held in the queue.
            return null;
        return new ActionListener<Void>() {
        return new ShardTaskRunner(stage, config, transport, requestBuilder);  
 * {@link PendingExecutions}, tasks on different nodes get separate ones, and the shared queue enforces
     */  
        runner.run(t0, noopHandle());
        // (never finish) so the limit is observable.  
import java.util.List;
     * The queue is built from {@code maxConcurrentShardRequestsPerNode}: at a limit of 2, a third
    }
import static org.mockito.ArgumentMatchers.any;
 * compatible open source license.
    }
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;  
        runner.run(shardTask(1, "node-A"), noopHandle());
        ShardExecutionTarget target = new ShardExecutionTarget(node, new ShardId("idx", "_na_", partitionId), partitionId);  
    public void testRespectsConfiguredPerNodeConcurrencyLimit() {
import org.opensearch.cluster.node.DiscoveryNode;
        when(node.getId()).thenReturn(nodeId);
            PendingExecutions pending = inv.getArgument(4);  
        ShardFragmentStageExecution stage = mock(ShardFragmentStageExecution.class);  
    }
    }  
            public void onResponse(Void unused) {}
import org.opensearch.core.action.ActionListener;
        ShardStageTask t0 = shardTask(0, "node-A");
        doAnswer(inv -> {
        runner.run(shardTask(0, "node-A"), noopHandle());  
        runner.run(t1, noopHandle());
            @Override  
        assertEquals(2, captured.size());
import org.opensearch.analytics.exec.PendingExecutions;
import java.util.ArrayList;  
            return null;
    /**  
        assertNotSame(captured.get(2), captured.get(3));  
        DiscoveryNode node = mock(DiscoveryNode.class);
 * SPDX-License-Identifier: Apache-2.0
 * the configured per-node concurrency limit.  
 * Tests {@link ShardTaskRunner}'s per-node admission queues: tasks on the same node share one
        List<PendingExecutions> captured = new ArrayList<>();  
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
    private ShardTaskRunner newRunner(List<PendingExecutions> capturedQueues) {
        assertEquals("only 2 of 3 same-node tasks run while at the per-node limit", 2, captured.size());
import static org.mockito.Mockito.mock;  
 * this file be licensed under the Apache-2.0 license or a
        runner.run(shardTask(1, "node-A"), noopHandle());
import static org.mockito.Mockito.doAnswer;
        QueryContext config = mock(QueryContext.class);
        AnalyticsSearchTransportService transport = mock(AnalyticsSearchTransportService.class);
import org.opensearch.test.OpenSearchTestCase;
        runner.run(shardTask(0, "node-A"), noopHandle());
            public void onFailure(Exception cause) {}
        when(config.maxConcurrentShardRequestsPerNode()).thenReturn(2);
    }  
}
            @Override  
 */
        List<PendingExecutions> captured = new ArrayList<>();
import org.opensearch.core.index.shard.ShardId;  
        runner.run(shardTask(3, "node-B"), noopHandle());
        assertSame(captured.get(0), captured.get(1));
import org.opensearch.analytics.exec.QueryContext;  
    // ── helpers ──────────────────────────────────────────────────────────  
        QueryContext config = mock(QueryContext.class);
        ShardStageTask onA = shardTask(0, "node-A");  
        Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = t -> mock(FragmentExecutionRequest.class);
import org.opensearch.analytics.exec.stage.shard.ShardFragmentStageExecution;
        doAnswer(inv -> {  
import org.opensearch.analytics.exec.stage.shard.ShardTaskRunner;
    public void testTasksOnSameNodeShareSinglePendingQueue() {
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
    }  
        ShardTaskRunner runner = new ShardTaskRunner(stage, config, transport, requestBuilder);  
        // Gating lives in the transport's pending.tryRun call; emulate it here and hold the permit
        List<PendingExecutions> captured = new ArrayList<>();
        };
        when(config.parentTask()).thenReturn(mock(AnalyticsQueryTask.class));  
        ShardTaskRunner runner = newRunner(captured);
    private static ActionListener<Void> noopHandle() {
