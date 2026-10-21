        mockCanMatchBoundsSequence(bounds(300L, 999L), bounds(100L, 999L), bounds(200L, 999L));
    }
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        survivorsOf(phase, targets, filterBytes, backendId, null, listener);
        survivorsOf(phase, targets, new byte[] { 1 }, "my-backend", ActionListener.wrap(result::set, e -> fail(e.getMessage())));
 * compatible open source license.
    }
        Reply[] replies = new Reply[boundsPerShard.length];
            Reply reply = callCount[0] < replies.length ? replies[callCount[0]] : new Reply(true, null);
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            TransportResponseHandler<AnalyticsCanMatchResponse> handler = inv.getArgument(3);
        List<ExecutionTarget> targets = List.of(first, target("idx", 1));
 */
        mockCanMatchResponse(true);
}
            filterBytes,
    public void testSingleTargetMatch() {
                any(DiscoveryNode.class),
            "datafusion",
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
                any(TransportResponseHandler.class)
    }
    public void testAllTargetsMatch() {
        assertEquals("@timestamp", sent.getSortColumn());
            any(DiscoveryNode.class),
import static org.mockito.Mockito.verify;
        );
     * disagree, so dispatch order never changes results.
        mockCanMatchResponse(true);
        List<ExecutionTarget> targets = List.of(target("idx", 0));
        List<ExecutionTarget> targets = List.of(target("idx", 0), target("idx", 1));
    private ShardExecutionTarget target(String indexName, int shardNum) {
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
import static org.mockito.ArgumentMatchers.eq;
                any(TransportRequest.class),
        );
                eq(AnalyticsCanMatchAction.NAME),
        doAnswer(inv -> {
    public void testPrunedShardsExcludedAndSurvivorsOrdered() {
            new byte[] { 1 },
        ExecutionTarget t3 = target("idx", 3);
        );
        assertEquals(3, result.get().size());
            new byte[] { 1 },
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
    }
            boolean match = callCount[0] < responses.length && responses[callCount[0]];
            phase,
                eq(AnalyticsCanMatchAction.NAME),
        assertEquals("nanos sorts first on scale alone — same instants", List.of(nanosShard, millisShard), result.get());
            this(false, null, failure);
        ExecutionTarget low = target("idx", 1);
            List.of(withoutBounds, low, high),
    }
        mockCanMatchBoundsSequence(null, null, null);
        assertEquals("nothing to order by → input order preserved", List.of(t0, t1, t2), result.get());
        );
                any(TransportResponseHandler.class)
        mockCanMatchResponse(true);
            List.of(t0, t1, t2),
            any(TransportResponseHandler.class)
import java.util.Collections;
    @SuppressWarnings("unchecked")
    }
            any(DiscoveryNode.class),
            handler.handleResponse(new AnalyticsCanMatchResponse(canMatch));
            "datafusion",
        doAnswer(inv -> {
            handler.handleResponse(new AnalyticsCanMatchResponse(match));
        ExecutionTarget t2 = target("idx", 2);
        assertNull(((AnalyticsCanMatchRequest) captor.getValue()).getSortColumn());
        assertSame("the kept target is the first in original order", first, result.get().get(0));
        // DESC orders by max, so t2 (highest max) runs first.
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        assertSame(only, result.get().get(0));
        survivorsOf(phase, List.of(only), new byte[] { 1 }, "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));
        );
        ExecutionTarget withoutBounds = target("idx", 0);
    // --- sort-bounds ordering (stage 2) ---
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
            List.of(millisShard, nanosShard),
            }
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
    private static SortSpec ascending() {
        List<ExecutionTarget> targets = List.of(target("idx", 0), target("idx", 1));
    @SuppressWarnings("unchecked")
            "datafusion",
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
            handler.handleResponse(new AnalyticsCanMatchResponse(canMatch, bounds));
        );
            "datafusion",
        mockCanMatchSequence(new Reply(true, null), new Reply(true, bounds(0L, 10L)));
            } else {
    }
        mockCanMatchResponseWithBounds(true, bounds(10L, 20L));
            phase,
    private void mockCanMatchBoundsSequence(ShardSortBounds... boundsPerShard) {
            new byte[] { 1 },
        ExecutionTarget t0 = target("idx", 0);
    }
            descending(),
            List.of(first, second),
        ExecutionTarget first = target("idx", 0);
    private TransportService transportService;
            any(TransportResponseHandler.class)
    }
    // --- helpers ---
        assertEquals("all pruned → keep exactly one", 1, result.get().size());
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        transportService = mock(TransportService.class);
                any(DiscoveryNode.class),
        CanMatchPreFilterPhase phase,
        ExecutionTarget healthy = target("idx", 1);
        ExecutionTarget t1 = target("idx", 1);
        assertEquals(List.of(high, low, withoutBounds), result.get());
            "datafusion",
            any(TransportResponseHandler.class)
        assertEquals(targets, result.get());
                any(TransportResponseHandler.class)
            new byte[] { 1 },
    }
    }
        ExecutionTarget t1 = target("idx", 1);
        ShardId shardId = new ShardId(new Index(indexName, "_na_"), shardNum);
import static org.mockito.Mockito.times;
import org.opensearch.Version;
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
            Collections.emptyList(),
            descending(),
    }
        List<ExecutionTarget> targets = List.of(target("idx", 0), target("idx", 1));
        );
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
    public void testAllPrunedWithSortSpecStillKeepsFirstTarget() {
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
 * this file be licensed under the Apache-2.0 license or a
    }
    public void testEmptyFilterBytesPassesAllTargets() {
            List.of(target("idx", 0)),
    /** Every shard lacking bounds (e.g. a keyword sort) → no reorder, all kept, correct results. */
        assertSame(second, result.get().get(1));
        survivorsOf(
        assertEquals(1, result.get().size());
 * The OpenSearch Contributors require contributions made to
    }
            if (reply.failure() != null) {
        survivorsOf(
    public void testNoShardHasBoundsKeepsInputOrder() {
            any(String.class),
            new byte[] { 1 },
     * runs to collect the bounds that order the dispatch.
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        ExecutionTarget t0 = target("idx", 0);
        // The same instant range, expressed at two scales.
            "datafusion",
        assertEquals(1, result.get().size());
    /** Shards 0,2,4 match and 1,3 prune; survivors are [0,2,4] in order. */
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
     * A sort spec with no filters must still check the shards: nothing is pruned, but the round-trip
        ExecutionTarget millisShard = target("logs-millis", 0);
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        assertTrue(result.get().isEmpty());
            descending(),
        mockCanMatchSequence(
    }
        // Transport failure → fail-open → target kept
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        survivorsOf(
            backendId,
            new byte[] { 1 },
            return null;
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        assertEquals(1, result.get().size());
    /** No filters AND no sort spec — nothing to learn, so the round-trip must be skipped. */
import static org.mockito.Mockito.never;
        doAnswer(inv -> {
            captor.capture(),
            phase,
            any(DiscoveryNode.class),
        );
        return new ShardExecutionTarget(node, shardId, shardNum);
        );
        assertEquals(targets, result.get());
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
    }
            "datafusion",
        assertSame(t0, result.get().get(0));
        mockCanMatchResponse(true);
            this(canMatch, bounds, null);
        assertEquals(List.of(measured, noStats), result.get());
    }
import org.opensearch.analytics.spi.ShardSortBounds;
        verify(transportService).sendRequest(
        }).when(transportService)
        survivorsOf(
    }
        assertEquals("nothing may be pruned when there are no filters", 2, result.get().size());
            any(DiscoveryNode.class),
        return new ShardSortBounds(min, max, false, ShardSortBounds.VALUE_KIND_INT64);
            List.of(target("idx", 0)),
    private record Reply(boolean canMatch, ShardSortBounds bounds, TransportException failure) {
            List.of(failing, healthy),
            .sendRequest(
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        survivorsOf(phase, targets, new byte[] { 1 }, "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));
            phase,
        survivorsOf(
        verify(transportService, never()).sendRequest(
        assertSame(first, result.get().get(0));
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
    }
import org.opensearch.core.action.ActionListener;
            List.of(noStats, measured),
    private void mockCanMatchSequence(Reply... replies) {
                eq(AnalyticsCanMatchAction.NAME),
            List.of(t0, t1, t2),
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
    }
            List.of(t0, t1, t2),
import org.opensearch.analytics.planner.dag.ExecutionTarget;
            );
        mockCanMatchBoundsSequence(bounds(0L, 50L), bounds(0L, 80L), bounds(0L, 100L));
            descending(),
            );
    }
        );
import org.opensearch.cluster.node.DiscoveryNode;
    /** With no sort spec, no column is requested — the data node skips the fold entirely. */
            descending(),
     * same instants sort by scale alone. Harmless: {@code setupSortGate} builds no gate when kinds
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        DiscoveryNode node = new DiscoveryNode("node-" + shardNum, buildNewFakeTransportAddress(), Version.CURRENT);
            return null;
                any(TransportRequest.class),
        ExecutionTarget t2 = target("idx", 2);
package org.opensearch.analytics.exec.canmatch;
        survivorsOf(phase, targets, new byte[0], "datafusion", descending(), ActionListener.wrap(result::set, e -> fail(e.getMessage())));
    }
            new byte[] { 1 },
    /** The sort column has to reach the data node or it cannot fold anything. */
            "datafusion",
            sortSpec,
        mockCanMatchSequence(replies);
        );
        survivorsOf(
        ExecutionTarget t2 = target("idx", 2);
        ActionListener<List<ExecutionTarget>> listener
        ExecutionTarget t4 = target("idx", 4);
        survivorsOf(phase, targets, new byte[0], "datafusion", null, ActionListener.wrap(result::set, e -> fail(e.getMessage())));
import org.opensearch.core.index.Index;
            );
            descending(),
        );
            return null;
        );
import org.opensearch.test.OpenSearchTestCase;
        byte[] filterBytes,
    public void testDescendingOrdersByMaxDescending() {
        ExecutionTarget t1 = target("idx", 1);
    /** Shards without bounds can never be eliminated, so they sort last (like vanilla's nullsLast). */
                any(DiscoveryNode.class),
        final int[] callCount = { 0 };
    public void testNoSortColumnWhenSpecAbsent() {
        List<ExecutionTarget> targets = List.of(target("idx", 0));
    /**
    private static SortSpec descending() {
        ExecutionTarget noStats = target("idx", 0);
        SortSpec sortSpec,
        ActionListener<List<ExecutionTarget>> listener
/*
    }
    /** A matching shard with no statistics is kept but sorted after every measured shard. */
        verify(transportService, times(2)).sendRequest(
    }
    private void mockCanMatchResponseWithBounds(boolean canMatch, ShardSortBounds bounds) {
    public void setUp() throws Exception {
            any(TransportResponseHandler.class)
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        mockCanMatchResponseWithBounds(true, bounds(1L, 2L));
            "datafusion",
                any(TransportResponseHandler.class)
            .sendRequest(
            phase,
        verify(transportService, never()).sendRequest(
            phase,
            );
            "datafusion",
    public void testAllTargetsPrunedKeepsFirstTarget() {
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        assertSame(only, result.get().get(0));
            TransportResponseHandler<AnalyticsCanMatchResponse> handler = inv.getArgument(3);
        return new SortSpec("@timestamp", true, 10);
        survivorsOf(
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            "datafusion",
            any(),
    }
    ) {
    public void testEmptyTargetsReturnsEmpty() {
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            TransportResponseHandler<AnalyticsCanMatchResponse> handler = inv.getArgument(3);
    public void testBackendIdPassedInRequest() {
            phase,
import static org.mockito.Mockito.doAnswer;
        Reply(boolean canMatch, ShardSortBounds bounds) {
    @Override
            new byte[] { 1 },
        }
        mockCanMatchResponseSequence(true, false, true, false, true);
                any(TransportRequest.class),
            targets,
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
    /** All pruned → force-keep still applies, and ordering must not disturb it. */
            any(),
        survivorsOf(phase, targets, new byte[] { 1 }, "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));
     * Ordering compares raw longs and ignores {@code valueKind}, so a millis and a nanos shard over the
        survivorsOf(phase, targets, null, "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));
            replies[i] = new Reply(true, boundsPerShard[i]);
        survivorsOf(
        doAnswer(inv -> {
            return null;
        Reply(TransportException failure) {
        survivorsOf(phase, targets, new byte[0], "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
    /** Scripts per-shard bounds in dispatch order; all shards match. */
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
            "datafusion",
            new byte[] { 1 },
            captor.capture(),
        byte[] filterBytes,
        verify(transportService).sendRequest(
        ExecutionTarget t0 = target("idx", 0);
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            "datafusion",
        mockCanMatchResponse(true);
            new byte[] { 1, 2, 3 },
public class CanMatchPreFilterPhaseTests extends OpenSearchTestCase {
                handler.handleException(reply.failure());
import org.opensearch.transport.TransportRequest;
    /** Responses may arrive out of order; survivors must keep input order. */
        );
     */
        List<ExecutionTarget> targets,
        for (int i = 0; i < boundsPerShard.length; i++) {
        ExecutionTarget only = target("idx", 0);
            any(String.class),
        assertEquals(List.of(t2, t0), result.get());
            phase,
                any(TransportRequest.class),
        }
            .sendRequest(
        assertEquals(List.of(healthy, failing), result.get());
        ExecutionTarget t0 = target("idx", 0);
        assertNotNull(result.get());
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        ExecutionTarget first = target("idx", 0);
        String backendId,
        ExecutionTarget first = target("idx", 0);
import static org.mockito.Mockito.mock;
    @SuppressWarnings("unchecked")
            phase,
        }).when(transportService)
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
    private static void survivorsOf(
        ArgumentCaptor<TransportRequest> captor = ArgumentCaptor.forClass(TransportRequest.class);
        );
        ExecutionTarget second = target("idx", 1);
        phase.checkShards(
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        List<ExecutionTarget> targets = List.of(target("idx", 0));
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        mockCanMatchResponse(false);
    }
        assertSame(t2, result.get().get(1));
    /** {@link CanMatchPreFilterPhase#checkShards} with only the survivor list kept — what most tests assert on. */
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        final int[] callCount = { 0 };
     */
        survivorsOf(
            TransportResponseHandler<AnalyticsCanMatchResponse> handler = inv.getArgument(3);
    public void testFiveShardsThreeMatchTwoPruned() {
        ExecutionTarget nanosShard = target("logs-nanos", 1);
            return null;
        mockCanMatchResponse(false);
        );
    }
            handler.handleException(exception);
        mockCanMatchSequence(new Reply(new TransportException("connection lost")), new Reply(true, bounds(0L, 5L)));
    public void testAscendingOrdersByMinAscending() {
        );
            ascending(),
            TransportResponseHandler<AnalyticsCanMatchResponse> handler = inv.getArgument(3);
        ExecutionTarget t1 = target("idx", 1);
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
    }
            );
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        assertNotNull(result.get());
        doAnswer(inv -> {
        }).when(transportService)
            any(DiscoveryNode.class),
                any(DiscoveryNode.class),
 *
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        return new SortSpec("@timestamp", false, 10);
    private static ShardSortBounds bounds(long min, long max) {
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            new byte[] { 1 },
        assertEquals(1, result.get().size());
    public void testMixedValueKindsOrderByRawValue() {
    public void testTransportFailureKeepsTarget() {
        ExecutionTarget t2 = target("idx", 2);
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
            any(DiscoveryNode.class),
            phase,
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
    public void testSortColumnForwardedInRequest() {
            new ShardSortBounds(1_700_000_000_000L, 1_700_000_060_000L, false, ShardSortBounds.VALUE_KIND_INT64_MILLIS),
                eq(AnalyticsCanMatchAction.NAME),
        survivorsOf(
            phase,
        List<ExecutionTarget> targets,
import static org.mockito.ArgumentMatchers.any;
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
    public void testSingleTargetPrunedIsStillKept() {
    public void testSortSpecWithoutFiltersStillChecksShards() {
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
        String backendId,
        );
        assertEquals(2, result.get().size());
        mockCanMatchBoundsSequence(null, bounds(0L, 40L), bounds(0L, 90L));
        assertSame(first, result.get().get(0));
            phase,
    }
            any(String.class),
        }
    public void testShardWithoutStatisticsIsKeptAndSortedLast() {
import org.opensearch.transport.TransportException;
import org.mockito.ArgumentCaptor;
    public void testShardsWithoutBoundsSortLast() {
    public void testNoFiltersAndNoSortSpecSkipsTheRoundTrip() {
            callCount[0]++;
    }
        }).when(transportService)
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
            new Reply(true, bounds(0L, 30L)),
        ExecutionTarget high = target("idx", 2);
        }).when(transportService)
            descending(),
    }
            List.of(t0, t1, t2),
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            "datafusion",
    private static void survivorsOf(
        );
        mockCanMatchBoundsSequence(
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
            ActionListener.map(listener, CanMatchPreFilterPhase.ShardCheckResult::targets)
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
                eq(AnalyticsCanMatchAction.NAME),
            eq(AnalyticsCanMatchAction.NAME),
            any(TransportResponseHandler.class)
            any(TransportRequest.class),
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        CanMatchPreFilterPhase phase,
    /** A single target that prunes is force-kept — there must always be at least one shard. */
        survivorsOf(phase, List.of(only), new byte[] { 1 }, "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));
            new Reply(false, null),          // pruned — bounds must not influence anything
            descending(),
    public void testNullFilterBytesPassesAllTargets() {
                any(TransportResponseHandler.class)
        AnalyticsCanMatchRequest sent = (AnalyticsCanMatchRequest) captor.getValue();
    ) {
    }
    }
    }
        survivorsOf(
        );
        ArgumentCaptor<TransportRequest> captor = ArgumentCaptor.forClass(TransportRequest.class);
        );
        assertSame(t4, result.get().get(2));
        assertEquals(1, result.get().size());
            List.of(t0, t1, t2, t3, t4),
        ExecutionTarget failing = target("idx", 0);
            descending(),
            any(TransportResponseHandler.class)
        assertEquals(2, result.get().size());
        assertEquals(targets, result.get());
import org.opensearch.core.index.shard.ShardId;
            .sendRequest(
                any(DiscoveryNode.class),
        survivorsOf(
            new byte[] { 1 },
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        ExecutionTarget t0 = target("idx", 0);
        ExecutionTarget measured = target("idx", 1);
    /** Fail-open shards have no bounds, so they must not be promoted ahead of measured ones. */
    }
    /** One scripted can-match reply: either a response pair, or a transport failure. */
        mockCanMatchException(new TransportException("connection lost"));
            eq(AnalyticsCanMatchAction.NAME),
            phase,
    private void mockCanMatchException(TransportException exception) {
    }
            callCount[0]++;
        survivorsOf(phase, targets, new byte[] { 1 }, "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));
            eq(AnalyticsCanMatchAction.NAME),
    /**
        List<ExecutionTarget> targets = List.of(target("idx", 0));
    @SuppressWarnings("unchecked")
            .sendRequest(
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
    public void testTransportFailureKeepsTargetAndSortsItLast() {
            new ShardSortBounds(1_700_000_000_000_000_000L, 1_700_000_060_000_000_000L, false, ShardSortBounds.VALUE_KIND_INT64_NANOS)
        ExecutionTarget only = target("idx", 0);
        assertEquals("ASC orders by min ascending", List.of(t1, t2, t0), result.get());
        verify(transportService, never()).sendRequest(
    }
                handler.handleResponse(new AnalyticsCanMatchResponse(reply.canMatch(), reply.bounds()));
            phase,
            new byte[] { 1 },
            new Reply(true, bounds(0L, 70L))
    /** Pruning and ordering are independent: pruned shards drop out, survivors get ordered. */
    }
    private void mockCanMatchResponse(boolean canMatch) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.TransportResponseHandler;
            any(),
        ExecutionTarget t2 = target("idx", 2);
        assertEquals(List.of(t2, t1, t0), result.get());
    @SuppressWarnings("unchecked")
        ExecutionTarget t1 = target("idx", 1);
    public void testOriginalOrderPreserved() {
    private void mockCanMatchResponseSequence(boolean... responses) {
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
    /** The backendId is forwarded on the request to the data node. */
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
        survivorsOf(
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        );
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        super.setUp();
                any(TransportRequest.class),
import org.opensearch.transport.TransportService;
        survivorsOf(
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        mockCanMatchResponseWithBounds(false, null);
        );
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
            new byte[] { 1 },
            List.of(first, target("idx", 1)),
        assertNotNull(result.get());
