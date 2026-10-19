        @Override  
            setupSortGate();  
            exec.setupSortGate(sortSpec, new CanMatchPreFilterPhase.ShardCheckResult(targets, boundsByTarget));  
import org.opensearch.analytics.exec.stage.StageTask;
        f.exec.topNGate().offer(50L);  
 */
     * queued ahead of one the gate keeps, the kept shard still gets sent. A leaked permit hangs the query.  
    public void testStageWithEveryShardSkippedStillSucceeds() {
        assertEquals("only the shard that can still contribute was sent", List.of(1), f.sent);  
    private BufferAllocator allocator;  
        Fixture f = new Fixture(null, 2, bounds(millis(10, 20), millis(10, 20)));
package org.opensearch.analytics.exec.stage.shard;
        }
        f.setupSortGate();
            assertTrue("setup: the gate must be armed", exec.topNGate().isArmed());
                exec.onTaskTerminal(task, cause);
                pending.tryRun(() -> {
 * The pre-send veto: a shard whose whole range sits outside the top-{@code K} the coordinator holds is
import org.opensearch.analytics.exec.QueryContext;  
        private ActionListener<Void> handleFor(StageTask task) {
        void complete(int shard) {
        assertEquals("three skips forwarded the permit to the shard behind them", List.of(0, 4), f.sent);  
 * this file be licensed under the Apache-2.0 license or a
        f.dispatchAll();  
    }
    /** A shard whose max exactly ties the bar may hold a tying row, so it is still dispatched. */
                });  
        f.dispatchAll();
        }
    public void testShardWithoutBoundsIsDispatched() {
    public void testSkipDoesNotResettleATaskCancelAlreadyTook() {
        /** Mirrors {@code QueryScheduler.scheduleStage}: publish, then run every task through the runner. */
import java.util.Arrays;
    /** Fewer than {@code K} keys collected means there is no bar yet, so every shard is still needed. */  
            when(stage.getStageId()).thenReturn(0);  
 *
        assertEquals(StageTaskState.SKIPPED, f.taskState(0));  
import org.opensearch.analytics.planner.dag.TargetResolver;  
        assertEquals(StageTaskState.SKIPPED, f.taskState(1));  
    private static final class NoopSink implements ExchangeSink {
    }  
                if (task.id().partitionId() == shard) {
        }  
            for (StageTask task : exec.tasks()) {  
 * {@link org.opensearch.analytics.exec.canmatch.TopNGate}; only the transport is stubbed, and the stub
    /**  
        assertEquals(StageExecution.State.SUCCEEDED, f.exec.getState());  
     * The verdict is taken when the slot frees, not at submission. Two shards, one permit: while the  
     * follows the production admission sequence and holds each permit until {@link Fixture#complete}.
     * A skip must forward its permit, not consume it: with one permit and three eliminable shards
import java.util.List;
 */  
    public void testVerdictUsesTheBarAtSlotFreeTimeNotAtSubmissionTime() {  
    private static final String SORT_COLUMN = "@timestamp";
        super.tearDown();
    }  
        f.dispatchAll();
        assertEquals(StageExecution.State.SUCCEEDED, f.exec.getState());
                    return task.state();
        assertNull("skipping is not a failure", f.exec.getFailure());
public class SortVetoDispatchTests extends OpenSearchTestCase {
                ExecutionTarget target = new ShardExecutionTarget(node, new ShardId("idx", "_na_", i), i);  
        Fixture f = new Fixture(1, 2, bounds(millis(10, 20), millis(10, 20)));  
            exec.start(ActionListener.wrap(v -> {}, e -> {}));
        f.dispatchAll();  
        assertNoneSkipped(f);
            when(config.bufferAllocator()).thenReturn(allocator);  
        assertEquals("a part-skipped stage succeeds", StageExecution.State.SUCCEEDED, f.exec.getState());  
        /** Sets up the gate and fills it to {@code K} with {@code bar}, making that value the bar. */
 *  
        f.complete(4);
        assertFalse("setup: the gate is not armed", f.exec.topNGate().isArmed());
        assertEquals(List.of(0, 1), f.sent);  
import org.apache.arrow.vector.VectorSchemaRoot;  
        Fixture f = new Fixture(1, 3, bounds(millis(10, 20), millis(90, 100), millis(10, 20)));
import org.opensearch.cluster.ClusterState;  
            Stage stage = mock(Stage.class);
import org.opensearch.cluster.node.DiscoveryNode;
    /**
        assertNoneSkipped(f);
                if (perShardBounds.get(i) != null) {
import static org.mockito.Mockito.doAnswer;
                handleByShard.put(task.id().partitionId(), handleFor(task));  
    }
            // Built before any when(...) — a stubbing can't be nested inside another's arguments.
        public void feed(VectorSchemaRoot batch) {
        assertEquals(StageExecution.State.SUCCEEDED, f.exec.getState());  
import org.opensearch.analytics.exec.canmatch.CanMatchPreFilterPhase;
            ClusterService clusterService = mock(ClusterService.class);
                    if (stillNeeded != null && stillNeeded.getAsBoolean() == false) {  
        super.setUp();
import java.util.function.Function;
        f.setupSortGate();  
            for (int i = 0; i < sortSpec.limit(); i++) {
                "test-query",
    public void tearDown() throws Exception {  
        f.complete(0);
        f.exec.topNGate().offer(50L);   // the first shard's rows set the bar
     * lands first owns the counter decrement, or the stage's bookkeeping goes wrong.  
            }
        f.complete(0);   // frees the slot, so the queued task is judged and vetoed
            // No plan alternatives → no can-match round-trip; targets are published as-is so these  
import org.opensearch.analytics.exec.canmatch.SortSpec;  
import org.opensearch.cluster.service.ClusterService;
        Fixture f = new Fixture(2, 2, bounds(millis(10, 20), millis(10, 20)));
                    boundsByTarget.put(target, perShardBounds.get(i));  
            AnalyticsSearchTransportService dispatcher = mock(AnalyticsSearchTransportService.class);
        assertEquals("the queued task has not been judged yet", StageTaskState.RUNNING, f.taskState(1));  
     * second waits, the first raises the bar past it — so it is dropped, though at submission it wasn't.
            TaskRunner<StageTask> runner = (TaskRunner<StageTask>) exec.taskRunner();
        }  
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
                targets.add(target);
     */  
    public void testRunOfSkipsStillLetsALaterKeptShardThrough() {
        private final SortSpec sortSpec;
     */  
import static org.mockito.Mockito.mock;  
                0,  
        assertEquals("cancel settled it first, so the skip left it alone", StageTaskState.CANCELLED, f.taskState(1));
        private final List<ExecutionTarget> targets = new ArrayList<>();
    public void testUngatedQueryDispatchesEveryShard() {
            Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = t -> new FragmentExecutionRequest(
        assertNull(f.exec.getFailure());
        /** A shard's stream finishes: its task settles and its permit frees, popping the next queued task. */  
    private static void assertNoneSkipped(Fixture f) {
                t.shardId(),
    public void setUp() throws Exception {  
            QueryContext config = mock(QueryContext.class);  
                FragmentExecutionRequest request = invocation.getArgument(0);
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.analytics.exec.stage.StageTaskState;  
            when(config.maxConcurrentShardRequestsPerNode()).thenReturn(permitsPerNode);
                }  
        assertEquals("the vetoed shard is still never sent", List.of(0), f.sent);
     * A veto firing after cancel must not re-settle a task cancel already settled: whichever terminal
        assertEquals("the shard with no statistics is kept", List.of(1), f.sent);
            when(stage.getTargetResolver()).thenReturn(resolver);
            assertEquals("setup: the stage published one task per target", targets.size(), exec.tasks().size());
        for (StageTask task : f.exec.tasks()) {  
            for (int i = 0; i < perShardBounds.size(); i++) {
            when(resolver.resolve(any(ClusterState.class), any())).thenReturn(targets);  
        f.exec.topNGate().offer(50L);   // one key against K = 2
    }
/*  
                }
                exec.onTaskTerminal(task, null);
     * The shards the gate rules out never reach the wire and are settled {@code SKIPPED} — a request  
    /**
import java.util.ArrayList;
    private final class Fixture {
 * compatible open source license.
            assertEquals("setup: the bar is what the test says it is", bar, exec.topNGate().bottom());
            throw new AssertionError("no task for shard " + shard);
 * <p>Runs against the real {@link ShardTaskRunner}, {@link PendingExecutions} and
    private static ShardSortBounds millis(long min, long max) {
            when(node.getId()).thenReturn("test-node");
                return null;
        allocator = new RootAllocator();
import org.opensearch.core.action.ActionListener;  
    public void testGateWithFewerThanKKeysDispatchesEveryShard() {
    /** Every shard eliminated: the stage succeeds on skips alone, with nothing left to wait for. */
 * The OpenSearch Contributors require contributions made to  
        assertTrue("nothing on the wire", f.sent.isEmpty());
    }
    @Override
        assertEquals(StageTaskState.SKIPPED, f.taskState(1));
        @Override
            PendingExecutions pending = permitByShard.remove(shard);
import org.opensearch.analytics.planner.dag.Stage;
        assertEquals(StageTaskState.SKIPPED, f.taskState(1));  
 * The permit hand-off is most of what can break here, so it is deliberately real.
        assertEquals(StageTaskState.SKIPPED, f.taskState(2));
import java.util.LinkedHashMap;
                runner.run(task, handleByShard.get(task.id().partitionId()));
    @Override
            }  
        f.exec.topNGate().offer(50L);  
    private static List<ShardSortBounds> bounds(ShardSortBounds... perShard) {
        final ShardFragmentStageExecution exec;  
            }).when(dispatcher).dispatchFragmentStreaming(any(), any(), any(), any(), any(), any());
    }
        f.exec.cancel("test");
        f.armWithBar(50L);
        return new ShardSortBounds(min, max, false, ShardSortBounds.VALUE_KIND_INT64_MILLIS);  
            }, cause -> {  
import static org.mockito.Mockito.when;
            assertNotSame("no task should have been skipped here", StageTaskState.SKIPPED, task.state());
import org.opensearch.test.OpenSearchTestCase;
                task.transitionTo(StageTaskState.FAILED);
        assertEquals(List.of(0), f.sent);
    public void testEliminatedShardsAreNeverSentAndAreSettledSkipped() {  
    /**
            });  
        }
        assertEquals("no keys yet, so nothing is eliminable — first sent, second queued", List.of(0), f.sent);
            throw new AssertionError("no batch should reach the sink in a dispatch-only test");
        assertEquals("one permit, so only the first is in flight", List.of(0), f.sent);
        Fixture f = new Fixture(1, 1, bounds(millis(90, 100), millis(10, 20), millis(10, 20), millis(10, 20), millis(95, 200)));  
        assertEquals("max == bar is kept; max < bar is dropped", List.of(0), f.sent);
import java.util.function.BooleanSupplier;
import org.opensearch.analytics.exec.task.TaskRunner;
        assertEquals(StageTaskState.SKIPPED, f.taskState(2));
     * All targets share one node, so {@code permitsPerNode} is the queue depth these tests drive.
        f.dispatchAll();  
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
            TargetResolver resolver = mock(TargetResolver.class);
        f.dispatchAll();  
            }  
                    }
        f.setupSortGate();
        Fixture(int limit, int permitsPerNode, List<ShardSortBounds> perShardBounds) {
            DiscoveryNode node = mock(DiscoveryNode.class);  
        }
     */
            this.exec = new ShardFragmentStageExecution(stage, config, new NoopSink(), clusterService, requestBuilder, dispatcher);
        }
            doAnswer(invocation -> {  
import org.opensearch.analytics.planner.dag.ExecutionTarget;  
                    sent.add(shard);  
    }  
        f.dispatchAll();
                int shard = request.getShardId().id();
import org.opensearch.analytics.exec.PendingExecutions;
        void setupSortGate() {
    /** A shard the check learned nothing about is unjudgeable, so it is kept. */
import org.opensearch.analytics.exec.stage.StageExecution;
        private final Map<ExecutionTarget, ShardSortBounds> boundsByTarget = new IdentityHashMap<>();  
        }  
            return ActionListener.wrap(v -> {  
import static org.mockito.ArgumentMatchers.any;
        /** Shard ids that reached the send path, in send order. */
        final List<Integer> sent = new ArrayList<>();
        Fixture f = new Fixture(1, 2, bounds(millis(10, 20), null));  
     * that was never sent has no transport callback, so an unsettled task would hang the stage.
 * never dispatched, and its task is settled {@code SKIPPED} so the stage still completes.
        private final Map<Integer, ActionListener<Void>> handleByShard = new LinkedHashMap<>();
                        return false;   // vetoed: the permit moves to the next queued task
    }
import java.util.IdentityHashMap;  
     */
        f.complete(1);
            pending.finishAndRunNext();
            when(stage.getSortSpec()).thenReturn(sortSpec);
     */
    }
            );  
        }  
                List.of(new FragmentExecutionRequest.PlanAlternative("test-backend", new byte[0], List.of()))
        assertNull("setup: no gate", f.exec.topNGate());  
        f.armWithBar(50L);
        assertEquals(StageTaskState.SKIPPED, f.taskState(0));
 * <p>Lives in the {@code shard} package because the gate accessors are package-private.  
                exec.topNGate().offer(bar);
        f.armWithBar(50L);
        assertEquals(List.of(0, 1), f.sent);
    }
            AnalyticsQueryTask parentTask = mock(AnalyticsQueryTask.class);  
        f.complete(0);                    // its slot frees, and the queued task is judged now  
                task.transitionTo(StageTaskState.RUNNING);
    }
        Fixture f = new Fixture(1, 2, bounds(millis(10, 50), millis(10, 49)));  
                    permitByShard.put(shard, pending);   // held until complete(shard)
 *
    // ── helpers ──────────────────────────────────────────────────────────  
        /** Sets up a gate over the fixture's bounds, as the can-match completion would. */
     */
 * follows the production admission sequence (take a permit, ask the veto, send only if it says yes).  
        Fixture f = new Fixture(1, 1, bounds(millis(90, 100), millis(10, 20)));  
import org.apache.arrow.memory.BufferAllocator;
            when(clusterService.state()).thenReturn(clusterState);  
     * Per-shard bounds in shard order; a {@code null} entry means no statistics for that shard.
        allocator.close();
import java.util.Map;  
            // tests can set up the gate by hand.
 * SPDX-License-Identifier: Apache-2.0
        }  
        void armWithBar(long bar) {
            assertNotNull("setup: the fixture's bounds must set up a gate", exec.topNGate());
            this(new SortSpec(SORT_COLUMN, true, limit), permitsPerNode, perShardBounds);
        f.dispatchAll();  
import org.apache.arrow.memory.RootAllocator;
            }
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
                BooleanSupplier stillNeeded = invocation.getArgument(5);  
     * One stage over N shard targets on a single node, its real runner, and a transport stub that  
/**  
            ClusterState clusterState = mock(ClusterState.class);
import org.opensearch.analytics.spi.ExchangeSink;
            for (StageTask task : exec.tasks()) {
        assertEquals(StageTaskState.SKIPPED, f.taskState(3));  
            handleByShard.get(shard).onResponse(null);
                PendingExecutions pending = invocation.getArgument(4);
        assertNull(f.exec.getFailure());
            when(config.parentTask()).thenReturn(parentTask);
    /** No bounded sort — the common shape — means no gate, and the dispatch path is untouched. */  
            assertNotNull("shard " + shard + " was never sent, so it holds no permit to release", pending);  
        assertEquals(StageExecution.State.CANCELLED, f.exec.getState());  
    }  
    /** Nothing is fed on the dispatch path these tests drive — the streams never produce a batch. */
import org.opensearch.analytics.spi.ShardSortBounds;
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
    /**
    }  
        f.dispatchAll();  
                task.transitionTo(StageTaskState.FINISHED);
        f.armWithBar(50L);
    }
        Fixture f = new Fixture(1, 1, bounds(millis(90, 100), millis(10, 20)));
                    return true;
}
    public void testShardTyingTheBarIsStillDispatched() {
            this.sortSpec = sortSpec;  
    }
        f.setupSortGate();
     * {@code Arrays.asList} because {@code List.of} rejects nulls.
        Fixture(SortSpec sortSpec, int permitsPerNode, List<ShardSortBounds> perShardBounds) {
        void dispatchAll() {  
    /**
            @SuppressWarnings("unchecked")  
        assertEquals("still only one send", List.of(0), f.sent);
        return Arrays.asList(perShard);
        private final Map<Integer, PendingExecutions> permitByShard = new LinkedHashMap<>();
        StageTaskState taskState(int shard) {
        public void close() {}  
