            when(threadPool.schedule(any(), any(), any())).thenReturn(mock(Scheduler.ScheduledCancellable.class));
            // so the timer is created and then simply never fires within the test.
/**
 * count the same way vanilla gates its pre-filter phase
 *
import static org.mockito.Mockito.times;
        allocator = new RootAllocator();
import java.util.ArrayList;
}
import static org.mockito.Mockito.mock;
 * ({@code TransportSearchAction.shouldPreFilterSearchShards}): run it only when the query has
            exec.start(ActionListener.wrap(v -> {}, e -> {}));
        }
import org.apache.arrow.memory.RootAllocator;
        Fixture f = new Fixture(500, List.of(), null, 3);
    }
    private static final SortSpec SORT = new SortSpec("@timestamp", true, 10);
 * shard to order against.
import org.opensearch.analytics.exec.canmatch.SortSpec;
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
 * compatible open source license.
 * something to prune or order by <em>and</em> the fan-out exceeds
import static org.mockito.Mockito.verify;
import org.opensearch.analytics.exec.canmatch.LongRange;
            when(streamingTransportService.getThreadPool()).thenReturn(threadPool);
    }
import org.opensearch.analytics.exec.QueryContext;
import org.apache.arrow.memory.BufferAllocator;
            when(stage.getCanMatchFilters()).thenReturn(filters);
            when(dispatcher.getTransportService()).thenReturn(transportService);
            when(config.maxConcurrentShardRequestsPerNode()).thenReturn(5);
import org.opensearch.threadpool.ThreadPool;
            // nested stubbing as an unfinished one.
            when(clusterService.state()).thenReturn(clusterState);
package org.opensearch.analytics.exec.stage.shard;
import org.opensearch.cluster.ClusterState;
     */
            when(stage.getTargetResolver()).thenReturn(resolver);
        verify(f.transportService, times(2)).sendRequest(any(), eq(AnalyticsCanMatchAction.NAME), any(), any());
            for (int i = 0; i < shardCount; i++) {
        f.start();
        Fixture(int shardCount, List<CanMatchFilter> filters, SortSpec sortSpec, int preFilterShardSize) {
import org.opensearch.analytics.exec.canmatch.AnalyticsCanMatchAction;
            when(config.parentTask()).thenReturn(parentTask);
import org.opensearch.analytics.exec.canmatch.CanMatchFilter;
    public void testFanOutAtOrBelowThresholdSkipsCanMatch() {
        Fixture f = new Fixture(3, FILTERS, null, 3);
            when(stage.getStageId()).thenReturn(0);
    public void testSortPreFiltersBelowTheConfiguredThreshold() {
     * higher: bounds ordering and the top-N gate need only one other shard to be worth collecting.
/*
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
    @Override
    }
                t.shardId(),
        verify(f.transportService, never()).sendRequest(any(), eq(AnalyticsCanMatchAction.NAME), any(), any());
                List.of(new FragmentExecutionRequest.PlanAlternative("test-backend", new byte[0], List.of()))
        DiscoveryNode node = mock(DiscoveryNode.class);
    private final class Fixture {
                "test-query",
import static org.mockito.ArgumentMatchers.any;
        @Override
 */
    }
     * A sorted query pre-filters from the second shard on, even though the configured threshold is far
 * <p>The observable is whether a can-match request reaches the transport at all; everything
import org.opensearch.test.OpenSearchTestCase;
    /** One shard has nothing to be ordered against and nothing to prune against — not even for a sort. */
                resolved.add(target(i));
 * <p>A sorted query drops the threshold to 1 — mirroring vanilla's {@code hasPrimaryFieldSort}
 * SPDX-License-Identifier: Apache-2.0
            batch.close();
 *
    /**
        final TransportService transportService;
import java.util.function.Function;
            QueryContext config = mock(QueryContext.class);
            ClusterService clusterService = mock(ClusterService.class);
    }
    }
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
            AnalyticsQueryTask parentTask = mock(AnalyticsQueryTask.class);
import org.opensearch.analytics.planner.dag.ExecutionTarget;
        Fixture f = new Fixture(4, FILTERS, null, 3);
        when(node.getId()).thenReturn("test-node-" + ordinal);
        Fixture f = new Fixture(2, List.of(), SORT, 128);
    }
import org.opensearch.cluster.node.DiscoveryNode;
            when(stage.getSortSpec()).thenReturn(sortSpec);
        verify(f.transportService, never()).sendRequest(any(), eq(AnalyticsCanMatchAction.NAME), any(), any());
 * downstream of that is covered by {@code CanMatchPreFilterPhaseTests} and
    public void tearDown() throws Exception {
    // ── fixture ──────────────────────────────────────────────────────────
        verify(f.transportService, times(4)).sendRequest(any(), eq(AnalyticsCanMatchAction.NAME), any(), any());
            TargetResolver resolver = mock(TargetResolver.class);
    @Override
 * The can-match round trip is only worth its latency on a wide fan-out, so it is gated on shard
import static org.mockito.Mockito.when;
            when(dispatcher.getStreamingTransportService()).thenReturn(streamingTransportService);
        }
        verify(f.transportService, never()).sendRequest(any(), eq(AnalyticsCanMatchAction.NAME), any(), any());
            transportService = mock(TransportService.class);
            ThreadPool threadPool = mock(ThreadPool.class);
            Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = t -> new FragmentExecutionRequest(
    public void testSingleShardNeverPreFilters() {
import static org.mockito.Mockito.never;
        f.start();
 * this file be licensed under the Apache-2.0 license or a
        f.start();
    private static final class NoopSink implements ExchangeSink {
            StreamTransportService streamingTransportService = mock(StreamTransportService.class);
    private static ExecutionTarget target(int ordinal) {
        super.setUp();
    public void setUp() throws Exception {
            }
import org.apache.arrow.vector.VectorSchemaRoot;
            List<ExecutionTarget> resolved = new ArrayList<>(shardCount);
        f.start();
    /** Wide fan-out with something to prune: the probe runs, one request per shard. */
    }
    public void testFanOutAboveThresholdRunsCanMatch() {
    }
import org.opensearch.transport.TransportService;
            AnalyticsSearchTransportService dispatcher = mock(AnalyticsSearchTransportService.class);
    private BufferAllocator allocator;
    /** Narrow fan-out: the probe would cost a round trip and could save at most a shard or two. */
 * case — because shard ordering and the top-N gate pay for themselves as soon as there is a second
        super.tearDown();
    private static final List<CanMatchFilter> FILTERS = List.of(new LongRange("total", 0L, 100L));
        void start() {
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
import org.opensearch.cluster.service.ClusterService;
            when(config.preFilterShardSize()).thenReturn(preFilterShardSize);
 * The OpenSearch Contributors require contributions made to
            when(resolver.resolve(any(ClusterState.class), any())).thenReturn(resolved);
            this.exec = new ShardFragmentStageExecution(stage, config, new NoopSink(), clusterService, requestBuilder, dispatcher);
        f.start();
 * {@code analytics.query.pre_filter_shard_size}.
import org.opensearch.core.action.ActionListener;
        final ShardFragmentStageExecution exec;
            ClusterState clusterState = mock(ClusterState.class);
import org.opensearch.analytics.spi.ExchangeSink;
        Fixture f = new Fixture(1, FILTERS, SORT, 1);
import org.opensearch.core.index.shard.ShardId;
            // resolveBackendId reads the first alternative; without one the phase bails before dispatch.
        allocator.close();
 */
    }
import static org.mockito.ArgumentMatchers.eq;
            when(stage.getPlanAlternatives()).thenReturn(List.of(new StagePlan(null, "test-backend")));
        }
    /** Nothing to prune and nothing to order by — shard count is irrelevant, the probe has no question to ask. */
import org.opensearch.analytics.planner.dag.Stage;
    public void testNoFiltersAndNoSortNeverRunsCanMatch() {
        assertEquals("every shard is still dispatched", 3, f.exec.tasks().size());
public class CanMatchTriggerTests extends OpenSearchTestCase {
import org.opensearch.transport.StreamTransportService;
        public void close() {}
            Stage stage = mock(Stage.class);
        return new ShardExecutionTarget(node, new ShardId("idx", "_na_", ordinal), ordinal);
            when(config.bufferAllocator()).thenReturn(allocator);
        @Override
import org.opensearch.analytics.planner.dag.StagePlan;
 * {@link SortGateWiringTests}.
            // The probe arms a fail-open timeout before sending; the stubbed transport never answers,
            );
        public void feed(VectorSchemaRoot batch) {
 *
import org.opensearch.threadpool.Scheduler;
                0,
import org.opensearch.analytics.planner.dag.TargetResolver;
import java.util.List;
            // Targets are built before any when(...) — target() stubs a mock, and Mockito reads a
