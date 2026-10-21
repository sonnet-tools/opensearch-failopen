        f.exec.cancel("test");
        assertEquals("max == bar is kept; max < bar is dropped", List.of(0), f.sent);
        }
    }
                if (perShardBounds.get(i) != null) {
import org.opensearch.analytics.exec.stage.StageTaskState;
        assertEquals(StageExecution.State.SUCCEEDED, f.exec.getState());
    }
            AnalyticsQueryTask parentTask = mock(AnalyticsQueryTask.class);
                exec.onTaskTerminal(task, cause);
            assertNotNull("shard " + shard + " was never sent, so it holds no permit to release", pending);
            for (int i = 0; i < sortSpec.limit(); i++) {
                task.transitionTo(StageTaskState.FAILED);
            Stage stage = mock(Stage.class);
            // tests can set up the gate by hand.
            when(clusterService.state()).thenReturn(clusterState);
            throw new AssertionError("no task for shard " + shard);
     */
        f.dispatchAll();
    }
            for (StageTask task : exec.tasks()) {
import org.opensearch.analytics.spi.ShardSortBounds;
        assertEquals("a part-skipped stage succeeds", StageExecution.State.SUCCEEDED, f.exec.getState());
    }
import java.util.Map;
            @SuppressWarnings("unchecked")
            when(stage.getStageId()).thenReturn(0);
import org.opensearch.cluster.service.ClusterService;
                return null;
        f.dispatchAll();
import org.opensearch.core.action.ActionListener;
 *
            });
            when(stage.getSortSpec()).thenReturn(sortSpec);
        Fixture f = new Fixture(2, 2, bounds(millis(10, 20), millis(10, 20)));
            PendingExecutions pending = permitByShard.remove(shard);
        f.complete(4);
        assertNull(f.exec.getFailure());
        assertEquals("cancel settled it first, so the skip left it alone", StageTaskState.CANCELLED, f.taskState(1));
        assertEquals(StageTaskState.SKIPPED, f.taskState(3));
        assertEquals(StageExecution.State.CANCELLED, f.exec.getState());
    /**
    }
        private final Map<Integer, ActionListener<Void>> handleByShard = new LinkedHashMap<>();
     * Per-shard bounds in shard order; a {@code null} entry means no statistics for that shard.
/**
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
        assertEquals(StageTaskState.SKIPPED, f.taskState(2));
     * follows the production admission sequence and holds each permit until {@link Fixture#complete}.
    @Override
        assertNull("setup: no gate", f.exec.topNGate());
    }
                    return true;
        f.dispatchAll();
        }
        private final List<ExecutionTarget> targets = new ArrayList<>();
import org.opensearch.cluster.ClusterState;
public class SortVetoDispatchTests extends OpenSearchTestCase {
 *
            AnalyticsSearchTransportService dispatcher = mock(AnalyticsSearchTransportService.class);
            assertNotNull("setup: the fixture's bounds must set up a gate", exec.topNGate());
import org.opensearch.analytics.exec.PendingExecutions;
            TaskRunner<StageTask> runner = (TaskRunner<StageTask>) exec.taskRunner();
        }
        allocator = new RootAllocator();
import java.util.function.Function;
                targets.add(target);
                t.shardId(),
        f.exec.topNGate().offer(50L);   // one key against K = 2
        /** Sets up a gate over the fixture's bounds, as the can-match completion would. */
    private BufferAllocator allocator;
        Fixture f = new Fixture(1, 2, bounds(millis(10, 20), millis(10, 20)));
    /** A shard the check learned nothing about is unjudgeable, so it is kept. */
     * The shards the gate rules out never reach the wire and are settled {@code SKIPPED} — a request
            pending.finishAndRunNext();
                if (task.id().partitionId() == shard) {
        return Arrays.asList(perShard);
        }
    /** No bounded sort — the common shape — means no gate, and the dispatch path is untouched. */
        assertEquals(StageTaskState.SKIPPED, f.taskState(0));
 * The pre-send veto: a shard whose whole range sits outside the top-{@code K} the coordinator holds is
import org.opensearch.core.index.shard.ShardId;
    private static List<ShardSortBounds> bounds(ShardSortBounds... perShard) {
        void armWithBar(long bar) {
    private static void assertNoneSkipped(Fixture f) {
                PendingExecutions pending = invocation.getArgument(4);
import org.apache.arrow.memory.BufferAllocator;
        void complete(int shard) {
        f.armWithBar(50L);
    }
        private final SortSpec sortSpec;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.opensearch.analytics.exec.stage.StageExecution;
        }
import org.opensearch.analytics.spi.ExchangeSink;
        public void feed(VectorSchemaRoot batch) {
     * {@code Arrays.asList} because {@code List.of} rejects nulls.
import java.util.function.BooleanSupplier;
            when(config.parentTask()).thenReturn(parentTask);
 *
    public void testVerdictUsesTheBarAtSlotFreeTimeNotAtSubmissionTime() {
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(StageTaskState.SKIPPED, f.taskState(0));
            this.sortSpec = sortSpec;
        assertEquals("three skips forwarded the permit to the shard behind them", List.of(0, 4), f.sent);
 * follows the production admission sequence (take a permit, ask the veto, send only if it says yes).
import org.opensearch.analytics.planner.dag.Stage;
            when(config.bufferAllocator()).thenReturn(allocator);
    private static final String SORT_COLUMN = "@timestamp";
    public void testShardWithoutBoundsIsDispatched() {
        assertNoneSkipped(f);
    }
                        return false;   // vetoed: the permit moves to the next queued task
                FragmentExecutionRequest request = invocation.getArgument(0);
            }
     * A veto firing after cancel must not re-settle a task cancel already settled: whichever terminal
        /** Mirrors {@code QueryScheduler.scheduleStage}: publish, then run every task through the runner. */
        private ActionListener<Void> handleFor(StageTask task) {
 * SPDX-License-Identifier: Apache-2.0
        super.setUp();
    }
        assertEquals(List.of(0, 1), f.sent);
                handleByShard.put(task.id().partitionId(), handleFor(task));
        /** Shard ids that reached the send path, in send order. */
            return ActionListener.wrap(v -> {
                });
     */
    public void testShardTyingTheBarIsStillDispatched() {
import org.opensearch.analytics.exec.canmatch.CanMatchPreFilterPhase;
        assertEquals(StageTaskState.SKIPPED, f.taskState(1));
import org.opensearch.analytics.exec.stage.StageTask;
     * queued ahead of one the gate keeps, the kept shard still gets sent. A leaked permit hangs the query.
     */
            ClusterService clusterService = mock(ClusterService.class);
        Fixture f = new Fixture(1, 3, bounds(millis(10, 20), millis(90, 100), millis(10, 20)));
        f.armWithBar(50L);
        f.complete(0);
                0,
        assertEquals(List.of(0, 1), f.sent);
        f.complete(0);                    // its slot frees, and the queued task is judged now
        f.exec.topNGate().offer(50L);
        f.dispatchAll();
    public void testUngatedQueryDispatchesEveryShard() {
            DiscoveryNode node = mock(DiscoveryNode.class);
            this(new SortSpec(SORT_COLUMN, true, limit), permitsPerNode, perShardBounds);
import org.apache.arrow.memory.RootAllocator;
        f.exec.topNGate().offer(50L);   // the first shard's rows set the bar
            throw new AssertionError("no batch should reach the sink in a dispatch-only test");
        StageTaskState taskState(int shard) {
package org.opensearch.analytics.exec.stage.shard;
        f.complete(1);
            when(resolver.resolve(any(ClusterState.class), any())).thenReturn(targets);
        assertEquals(StageExecution.State.SUCCEEDED, f.exec.getState());
                task.transitionTo(StageTaskState.FINISHED);
    }
        assertEquals(StageTaskState.SKIPPED, f.taskState(1));
    /** Nothing is fed on the dispatch path these tests drive — the streams never produce a batch. */
    /**
            );
            QueryContext config = mock(QueryContext.class);
        f.dispatchAll();
                    if (stillNeeded != null && stillNeeded.getAsBoolean() == false) {
                int shard = request.getShardId().id();
        }
    /**
        f.setupSortGate();
        void dispatchAll() {
                    sent.add(shard);
        assertEquals(StageTaskState.SKIPPED, f.taskState(1));
        private final Map<Integer, PendingExecutions> permitByShard = new LinkedHashMap<>();
import static org.mockito.Mockito.doAnswer;
        assertTrue("nothing on the wire", f.sent.isEmpty());
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
 */
    }
 * compatible open source license.
            exec.setupSortGate(sortSpec, new CanMatchPreFilterPhase.ShardCheckResult(targets, boundsByTarget));
    public void testGateWithFewerThanKKeysDispatchesEveryShard() {
    private final class Fixture {
            // Built before any when(...) — a stubbing can't be nested inside another's arguments.
                    permitByShard.put(shard, pending);   // held until complete(shard)
                pending.tryRun(() -> {
import org.opensearch.cluster.node.DiscoveryNode;
        Fixture f = new Fixture(1, 1, bounds(millis(90, 100), millis(10, 20), millis(10, 20), millis(10, 20), millis(95, 200)));
        assertEquals("only the shard that can still contribute was sent", List.of(1), f.sent);
        assertNull("skipping is not a failure", f.exec.getFailure());
        assertFalse("setup: the gate is not armed", f.exec.topNGate().isArmed());
        f.armWithBar(50L);
        final ShardFragmentStageExecution exec;
                BooleanSupplier stillNeeded = invocation.getArgument(5);
     * that was never sent has no transport callback, so an unsettled task would hang the stage.
            assertNotSame("no task should have been skipped here", StageTaskState.SKIPPED, task.state());
        assertNull(f.exec.getFailure());
        assertEquals(List.of(0), f.sent);
        f.setupSortGate();
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
    }
import java.util.Arrays;
        final List<Integer> sent = new ArrayList<>();
        f.dispatchAll();
            this.exec = new ShardFragmentStageExecution(stage, config, new NoopSink(), clusterService, requestBuilder, dispatcher);
 * <p>Lives in the {@code shard} package because the gate accessors are package-private.
                runner.run(task, handleByShard.get(task.id().partitionId()));
    public void testEliminatedShardsAreNeverSentAndAreSettledSkipped() {
    @Override
        f.setupSortGate();
        f.dispatchAll();
            }
        assertEquals("the queued task has not been judged yet", StageTaskState.RUNNING, f.taskState(1));
            }, cause -> {
        Fixture f = new Fixture(null, 2, bounds(millis(10, 20), millis(10, 20)));
            Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = t -> new FragmentExecutionRequest(
        Fixture f = new Fixture(1, 1, bounds(millis(90, 100), millis(10, 20)));
                task.transitionTo(StageTaskState.RUNNING);
 * <p>Runs against the real {@link ShardTaskRunner}, {@link PendingExecutions} and
        private final Map<ExecutionTarget, ShardSortBounds> boundsByTarget = new IdentityHashMap<>();
import static org.mockito.Mockito.mock;
        assertEquals("no keys yet, so nothing is eliminable — first sent, second queued", List.of(0), f.sent);
        Fixture f = new Fixture(1, 2, bounds(millis(10, 20), null));
        assertEquals(StageTaskState.SKIPPED, f.taskState(2));
        }
                }
 * this file be licensed under the Apache-2.0 license or a
            setupSortGate();
                exec.onTaskTerminal(task, null);
        return new ShardSortBounds(min, max, false, ShardSortBounds.VALUE_KIND_INT64_MILLIS);
import org.opensearch.analytics.exec.task.TaskRunner;
        Fixture f = new Fixture(1, 2, bounds(millis(10, 50), millis(10, 49)));
import static org.mockito.ArgumentMatchers.any;
    /**
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
    }
import static org.mockito.Mockito.when;
     */
import java.util.List;
        for (StageTask task : f.exec.tasks()) {
     */
            when(stage.getTargetResolver()).thenReturn(resolver);
        f.dispatchAll();
    }
     * second waits, the first raises the bar past it — so it is dropped, though at submission it wasn't.
    private static ShardSortBounds millis(long min, long max) {
    /**
            for (int i = 0; i < perShardBounds.size(); i++) {
            assertEquals("setup: the bar is what the test says it is", bar, exec.topNGate().bottom());
    /**
    /** Every shard eliminated: the stage succeeds on skips alone, with nothing left to wait for. */
            exec.start(ActionListener.wrap(v -> {}, e -> {}));
            // No plan alternatives → no can-match round-trip; targets are published as-is so these
        assertEquals("one permit, so only the first is in flight", List.of(0), f.sent);
     * lands first owns the counter decrement, or the stage's bookkeeping goes wrong.
        assertEquals("still only one send", List.of(0), f.sent);
    /** A shard whose max exactly ties the bar may hold a tying row, so it is still dispatched. */
            }
    /** Fewer than {@code K} keys collected means there is no bar yet, so every shard is still needed. */
     * One stage over N shard targets on a single node, its real runner, and a transport stub that
        f.complete(0);   // frees the slot, so the queued task is judged and vetoed
        Fixture(int limit, int permitsPerNode, List<ShardSortBounds> perShardBounds) {
import org.opensearch.analytics.planner.dag.ExecutionTarget;
                ExecutionTarget target = new ShardExecutionTarget(node, new ShardId("idx", "_na_", i), i);
     * The verdict is taken when the slot frees, not at submission. Two shards, one permit: while the
        /** A shard's stream finishes: its task settles and its permit frees, popping the next queued task. */
        super.tearDown();
            handleByShard.get(shard).onResponse(null);
        }
        allocator.close();
        /** Sets up the gate and fills it to {@code K} with {@code bar}, making that value the bar. */
        void setupSortGate() {
 * The permit hand-off is most of what can break here, so it is deliberately real.
                    boundsByTarget.put(target, perShardBounds.get(i));
/*
            doAnswer(invocation -> {
        assertEquals("the vetoed shard is still never sent", List.of(0), f.sent);
 * never dispatched, and its task is settled {@code SKIPPED} so the stage still completes.
        f.armWithBar(50L);
            ClusterState clusterState = mock(ClusterState.class);
     */
            when(node.getId()).thenReturn("test-node");
        assertEquals("the shard with no statistics is kept", List.of(1), f.sent);
 */
        public void close() {}
                "test-query",
    private static final class NoopSink implements ExchangeSink {
    public void testSkipDoesNotResettleATaskCancelAlreadyTook() {
        }
            TargetResolver resolver = mock(TargetResolver.class);
                    }
    public void testRunOfSkipsStillLetsALaterKeptShardThrough() {
 * {@link org.opensearch.analytics.exec.canmatch.TopNGate}; only the transport is stubbed, and the stub
        f.dispatchAll();
 * The OpenSearch Contributors require contributions made to
            assertEquals("setup: the stage published one task per target", targets.size(), exec.tasks().size());
        }
    public void tearDown() throws Exception {
                }
        @Override
    public void testStageWithEveryShardSkippedStillSucceeds() {
import org.opensearch.analytics.exec.QueryContext;
        assertNoneSkipped(f);
    public void setUp() throws Exception {
        f.setupSortGate();
import org.opensearch.analytics.planner.dag.TargetResolver;
        Fixture(SortSpec sortSpec, int permitsPerNode, List<ShardSortBounds> perShardBounds) {
    }
        f.exec.topNGate().offer(50L);
import java.util.LinkedHashMap;
        assertEquals(StageExecution.State.SUCCEEDED, f.exec.getState());
import java.util.IdentityHashMap;
import java.util.ArrayList;
     * A skip must forward its permit, not consume it: with one permit and three eliminable shards
                List.of(new FragmentExecutionRequest.PlanAlternative("test-backend", new byte[0], List.of()))
}
    }
    // ── helpers ──────────────────────────────────────────────────────────
            }
                    return task.state();
import org.opensearch.analytics.exec.canmatch.SortSpec;
        Fixture f = new Fixture(1, 1, bounds(millis(90, 100), millis(10, 20)));
        @Override
            for (StageTask task : exec.tasks()) {
     * All targets share one node, so {@code permitsPerNode} is the queue depth these tests drive.
            }).when(dispatcher).dispatchFragmentStreaming(any(), any(), any(), any(), any(), any());
                exec.topNGate().offer(bar);
            assertTrue("setup: the gate must be armed", exec.topNGate().isArmed());
            when(config.maxConcurrentShardRequestsPerNode()).thenReturn(permitsPerNode);
