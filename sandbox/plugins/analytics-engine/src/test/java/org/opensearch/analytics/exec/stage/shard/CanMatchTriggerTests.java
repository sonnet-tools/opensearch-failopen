 * something to prune or order by <em>and</em> the fan-out exceeds  
import org.opensearch.cluster.ClusterState;  
     * A sorted query pre-filters from the second shard on, even though the configured threshold is far
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
import org.opensearch.threadpool.Scheduler;  
 * downstream of that is covered by {@code CanMatchPreFilterPhaseTests} and
    private BufferAllocator allocator;
            when(stage.getCanMatchFilters()).thenReturn(filters);
import static org.mockito.Mockito.never;  
/**
    public void testFanOutAtOrBelowThresholdSkipsCanMatch() {
    }
            // The probe arms a fail-open timeout before sending; the stubbed transport never answers,  
import org.opensearch.analytics.planner.dag.ExecutionTarget;  
        }  
import org.opensearch.analytics.exec.canmatch.LongRange;  
import org.opensearch.analytics.planner.dag.StagePlan;  
     */
            when(config.maxConcurrentShardRequestsPerNode()).thenReturn(5);
 */  
import org.opensearch.cluster.node.DiscoveryNode;
import static org.mockito.Mockito.when;  
            when(stage.getPlanAlternatives()).thenReturn(List.of(new StagePlan(null, "test-backend")));
            when(stage.getSortSpec()).thenReturn(sortSpec);
            AnalyticsSearchTransportService dispatcher = mock(AnalyticsSearchTransportService.class);
        f.start();
            exec.start(ActionListener.wrap(v -> {}, e -> {}));  
        Fixture f = new Fixture(2, List.of(), SORT, 128);  
import org.opensearch.analytics.planner.dag.TargetResolver;
 * {@code analytics.query.pre_filter_shard_size}.
        }
    // ── fixture ──────────────────────────────────────────────────────────
        void start() {
import org.opensearch.analytics.exec.canmatch.CanMatchFilter;
        return new ShardExecutionTarget(node, new ShardId("idx", "_na_", ordinal), ordinal);
 *
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;  
            );
        }
            StreamTransportService streamingTransportService = mock(StreamTransportService.class);
        public void feed(VectorSchemaRoot batch) {  
    }
            when(stage.getTargetResolver()).thenReturn(resolver);
import org.opensearch.analytics.spi.ExchangeSink;
            when(config.parentTask()).thenReturn(parentTask);
            // so the timer is created and then simply never fires within the test.
            // Targets are built before any when(...) — target() stubs a mock, and Mockito reads a
    /** Narrow fan-out: the probe would cost a round trip and could save at most a shard or two. */  
    }
import org.apache.arrow.memory.BufferAllocator;
            when(clusterService.state()).thenReturn(clusterState);
        verify(f.transportService, never()).sendRequest(any(), eq(AnalyticsCanMatchAction.NAME), any(), any());
import org.opensearch.test.OpenSearchTestCase;
            when(dispatcher.getStreamingTransportService()).thenReturn(streamingTransportService);  
                "test-query",  
            when(resolver.resolve(any(ClusterState.class), any())).thenReturn(resolved);  
import org.opensearch.core.action.ActionListener;  
        f.start();
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
        allocator = new RootAllocator();  
    }
 * ({@code TransportSearchAction.shouldPreFilterSearchShards}): run it only when the query has
        f.start();
        verify(f.transportService, never()).sendRequest(any(), eq(AnalyticsCanMatchAction.NAME), any(), any());
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.analytics.planner.dag.Stage;
        DiscoveryNode node = mock(DiscoveryNode.class);
            when(config.bufferAllocator()).thenReturn(allocator);
 * compatible open source license.
        Fixture f = new Fixture(4, FILTERS, null, 3);  
 * The OpenSearch Contributors require contributions made to  
            // nested stubbing as an unfinished one.  
    private static final SortSpec SORT = new SortSpec("@timestamp", true, 10);
    }
    /** Nothing to prune and nothing to order by — shard count is irrelevant, the probe has no question to ask. */
 */
            ClusterService clusterService = mock(ClusterService.class);  
import java.util.function.Function;
                t.shardId(),
    public void setUp() throws Exception {
import org.opensearch.analytics.exec.canmatch.SortSpec;
import static org.mockito.Mockito.times;
 * count the same way vanilla gates its pre-filter phase
 * <p>The observable is whether a can-match request reaches the transport at all; everything
 * this file be licensed under the Apache-2.0 license or a
            ClusterState clusterState = mock(ClusterState.class);  
        @Override
     * higher: bounds ordering and the top-N gate need only one other shard to be worth collecting.  
        super.tearDown();  
    /**
 * SPDX-License-Identifier: Apache-2.0
    private static final List<CanMatchFilter> FILTERS = List.of(new LongRange("total", 0L, 100L));
            when(dispatcher.getTransportService()).thenReturn(transportService);
    }  
            }
 * case — because shard ordering and the top-N gate pay for themselves as soon as there is a second
        Fixture(int shardCount, List<CanMatchFilter> filters, SortSpec sortSpec, int preFilterShardSize) {
public class CanMatchTriggerTests extends OpenSearchTestCase {
import static org.mockito.ArgumentMatchers.eq;
    public void tearDown() throws Exception {
    public void testSingleShardNeverPreFilters() {
        verify(f.transportService, never()).sendRequest(any(), eq(AnalyticsCanMatchAction.NAME), any(), any());  
            TargetResolver resolver = mock(TargetResolver.class);
            // resolveBackendId reads the first alternative; without one the phase bails before dispatch.  
/*  
            Stage stage = mock(Stage.class);
        allocator.close();
import static org.mockito.Mockito.mock;
        final TransportService transportService;
            Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = t -> new FragmentExecutionRequest(
    private static final class NoopSink implements ExchangeSink {
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
            when(config.preFilterShardSize()).thenReturn(preFilterShardSize);  
 * shard to order against.
        verify(f.transportService, times(4)).sendRequest(any(), eq(AnalyticsCanMatchAction.NAME), any(), any());
        f.start();
        assertEquals("every shard is still dispatched", 3, f.exec.tasks().size());
        Fixture f = new Fixture(3, FILTERS, null, 3);
    public void testSortPreFiltersBelowTheConfiguredThreshold() {
}
            List<ExecutionTarget> resolved = new ArrayList<>(shardCount);
        @Override
            AnalyticsQueryTask parentTask = mock(AnalyticsQueryTask.class);
import java.util.ArrayList;
    }
    /** One shard has nothing to be ordered against and nothing to prune against — not even for a sort. */
import java.util.List;  
import org.opensearch.core.index.shard.ShardId;
            when(threadPool.schedule(any(), any(), any())).thenReturn(mock(Scheduler.ScheduledCancellable.class));  
            ThreadPool threadPool = mock(ThreadPool.class);
            transportService = mock(TransportService.class);  
import org.opensearch.transport.StreamTransportService;
import org.opensearch.transport.TransportService;  
                resolved.add(target(i));  
    /** Wide fan-out with something to prune: the probe runs, one request per shard. */
import org.opensearch.threadpool.ThreadPool;
 * <p>A sorted query drops the threshold to 1 — mirroring vanilla's {@code hasPrimaryFieldSort}  
            when(stage.getStageId()).thenReturn(0);  
 *  
    }
            when(streamingTransportService.getThreadPool()).thenReturn(threadPool);
        f.start();
 * {@link SortGateWiringTests}.  
        public void close() {}
import org.opensearch.analytics.exec.QueryContext;
        Fixture f = new Fixture(1, FILTERS, SORT, 1);  
        when(node.getId()).thenReturn("test-node-" + ordinal);  
import org.opensearch.analytics.exec.canmatch.AnalyticsCanMatchAction;
    private static ExecutionTarget target(int ordinal) {
import org.apache.arrow.vector.VectorSchemaRoot;  
    }
            this.exec = new ShardFragmentStageExecution(stage, config, new NoopSink(), clusterService, requestBuilder, dispatcher);
                List.of(new FragmentExecutionRequest.PlanAlternative("test-backend", new byte[0], List.of()))  
import org.apache.arrow.memory.RootAllocator;
import static org.mockito.ArgumentMatchers.any;  
    }
            batch.close();
 * The can-match round trip is only worth its latency on a wide fan-out, so it is gated on shard  
import static org.mockito.Mockito.verify;
    private final class Fixture {  
    @Override  
package org.opensearch.analytics.exec.stage.shard;
    public void testNoFiltersAndNoSortNeverRunsCanMatch() {
        verify(f.transportService, times(2)).sendRequest(any(), eq(AnalyticsCanMatchAction.NAME), any(), any());
    public void testFanOutAboveThresholdRunsCanMatch() {
    @Override  
        Fixture f = new Fixture(500, List.of(), null, 3);  
        super.setUp();
 *
            for (int i = 0; i < shardCount; i++) {
                0,
        final ShardFragmentStageExecution exec;
            QueryContext config = mock(QueryContext.class);  
