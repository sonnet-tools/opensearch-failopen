        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();  
            );
        );
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
import static org.mockito.Mockito.times;
package org.opensearch.analytics.exec.canmatch;
import org.opensearch.transport.TransportRequest;
    public void testOriginalOrderPreserved() {  
        );
    public void testNoShardHasBoundsKeepsInputOrder() {  
        survivorsOf(phase, targets, filterBytes, backendId, null, listener);  
    }  
            any(DiscoveryNode.class),
        mockCanMatchBoundsSequence(bounds(0L, 50L), bounds(0L, 80L), bounds(0L, 100L));
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
        assertSame(t0, result.get().get(0));
            any(),
        return new ShardSortBounds(min, max, false, ShardSortBounds.VALUE_KIND_INT64);
            List.of(failing, healthy),
            new Reply(true, bounds(0L, 70L))
        verify(transportService, never()).sendRequest(  
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            }  
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(List.of(measured, noStats), result.get());
        assertEquals(List.of(high, low, withoutBounds), result.get());
            filterBytes,
    }
                any(TransportRequest.class),  
    private static ShardSortBounds bounds(long min, long max) {
    public void testNullFilterBytesPassesAllTargets() {
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))  
            List.of(millisShard, nanosShard),
    }  
        mockCanMatchResponse(false);
import static org.mockito.ArgumentMatchers.any;  
        mockCanMatchResponse(true);
    }
    }  
        ExecutionTarget t0 = target("idx", 0);  
    /** Fail-open shards have no bounds, so they must not be promoted ahead of measured ones. */  
        assertSame(first, result.get().get(0));  
            callCount[0]++;
        assertEquals("@timestamp", sent.getSortColumn());
        assertEquals("ASC orders by min ascending", List.of(t1, t2, t0), result.get());
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();  
            new byte[] { 1 },
            phase,
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();  
        List<ExecutionTarget> targets = List.of(target("idx", 0), target("idx", 1));  
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            phase,
        );
            captor.capture(),  
            boolean match = callCount[0] < responses.length && responses[callCount[0]];
        }).when(transportService)
     * same instants sort by scale alone. Harmless: {@code setupSortGate} builds no gate when kinds  
    private void mockCanMatchResponseWithBounds(boolean canMatch, ShardSortBounds bounds) {
    public void testTransportFailureKeepsTarget() {
            .sendRequest(  
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        // The same instant range, expressed at two scales.  
        verify(transportService, times(2)).sendRequest(
        );  
    private void mockCanMatchBoundsSequence(ShardSortBounds... boundsPerShard) {
            return null;
        );
            new byte[] { 1 },
    }  
            new byte[] { 1, 2, 3 },
            List.of(t0, t1, t2),  
    /** {@link CanMatchPreFilterPhase#checkShards} with only the survivor list kept — what most tests assert on. */
        ExecutionTarget t2 = target("idx", 2);
        );
    }  
    }
        ExecutionTarget t1 = target("idx", 1);
    public void testNoFiltersAndNoSortSpecSkipsTheRoundTrip() {
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))  
                eq(AnalyticsCanMatchAction.NAME),
        ExecutionTarget t2 = target("idx", 2);  
        );
        mockCanMatchResponse(true);  
        survivorsOf(
            "datafusion",
        survivorsOf(phase, List.of(only), new byte[] { 1 }, "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));
        return new ShardExecutionTarget(node, shardId, shardNum);
    }
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        mockCanMatchException(new TransportException("connection lost"));
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
            any(String.class),
        assertSame(only, result.get().get(0));
        return new SortSpec("@timestamp", false, 10);
    public void testPrunedShardsExcludedAndSurvivorsOrdered() {  
            any(TransportRequest.class),
        survivorsOf(phase, targets, new byte[] { 1 }, "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));  
        survivorsOf(
            "datafusion",  
            List.of(first, target("idx", 1)),
    }
        }  
import org.opensearch.transport.TransportException;
        assertEquals(targets, result.get());  
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();  
    }  
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        mockCanMatchResponse(true);
            backendId,
            handler.handleResponse(new AnalyticsCanMatchResponse(canMatch));  
    /**
        assertEquals(targets, result.get());
        survivorsOf(  
            handler.handleResponse(new AnalyticsCanMatchResponse(canMatch, bounds));
            "datafusion",
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
            "datafusion",  
    }
        mockCanMatchResponse(true);  
        assertNotNull(result.get());  
            List.of(t0, t1, t2),
    private static void survivorsOf(  
    /** The backendId is forwarded on the request to the data node. */
    public void testTransportFailureKeepsTargetAndSortsItLast() {
    public void testSingleTargetPrunedIsStillKept() {  
        mockCanMatchBoundsSequence(
/*  
            new byte[] { 1 },
import org.opensearch.Version;
            List.of(target("idx", 0)),
        ExecutionTarget withoutBounds = target("idx", 0);  
            new byte[] { 1 },
    }  
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        List<ExecutionTarget> targets = List.of(target("idx", 0));  
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);  
    public void testAllTargetsMatch() {  
        List<ExecutionTarget> targets = List.of(first, target("idx", 1));
        survivorsOf(phase, targets, new byte[] { 1 }, "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));  
        final int[] callCount = { 0 };
        survivorsOf(
        List<ExecutionTarget> targets = List.of(target("idx", 0), target("idx", 1));  
    }  
    private record Reply(boolean canMatch, ShardSortBounds bounds, TransportException failure) {  
        assertNotNull(result.get());
        assertSame(t4, result.get().get(2));  
            );
            phase,
    @SuppressWarnings("unchecked")
            descending(),
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        String backendId,
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            targets,  
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
import org.opensearch.test.OpenSearchTestCase;  
            return null;
public class CanMatchPreFilterPhaseTests extends OpenSearchTestCase {
        assertNotNull(result.get());  
            TransportResponseHandler<AnalyticsCanMatchResponse> handler = inv.getArgument(3);
            phase,
        AnalyticsCanMatchRequest sent = (AnalyticsCanMatchRequest) captor.getValue();  
            "datafusion",  
    private static SortSpec ascending() {  
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            .sendRequest(
        }).when(transportService)
            any(),  
    public void testMixedValueKindsOrderByRawValue() {  
            any(TransportResponseHandler.class)  
    /** Shards without bounds can never be eliminated, so they sort last (like vanilla's nullsLast). */
        List<ExecutionTarget> targets = List.of(target("idx", 0));
    public void testShardsWithoutBoundsSortLast() {
     * A sort spec with no filters must still check the shards: nothing is pruned, but the round-trip
        doAnswer(inv -> {
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
        mockCanMatchBoundsSequence(null, bounds(0L, 40L), bounds(0L, 90L));  
    }
            new byte[] { 1 },  
    /** The sort column has to reach the data node or it cannot fold anything. */
        survivorsOf(phase, targets, new byte[0], "datafusion", null, ActionListener.wrap(result::set, e -> fail(e.getMessage())));  
            List.of(t0, t1, t2, t3, t4),  
        ExecutionTarget t2 = target("idx", 2);  
        mockCanMatchBoundsSequence(null, null, null);
    }
    /** Responses may arrive out of order; survivors must keep input order. */
                any(TransportResponseHandler.class)
    /** With no sort spec, no column is requested — the data node skips the fold entirely. */
        ExecutionTarget t1 = target("idx", 1);
            phase,  
        mockCanMatchResponseWithBounds(true, bounds(10L, 20L));
        assertEquals(1, result.get().size());  
        survivorsOf(
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            phase,
    /** A single target that prunes is force-kept — there must always be at least one shard. */
        assertEquals(2, result.get().size());  
    public void testNoSortColumnWhenSpecAbsent() {
        assertSame("the kept target is the first in original order", first, result.get().get(0));
            phase,  
        assertEquals(3, result.get().size());  
        survivorsOf(
import org.opensearch.analytics.spi.ShardSortBounds;
    // --- helpers ---
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))  
        assertEquals(1, result.get().size());
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
    public void testSortSpecWithoutFiltersStillChecksShards() {
    /** Every shard lacking bounds (e.g. a keyword sort) → no reorder, all kept, correct results. */
            TransportResponseHandler<AnalyticsCanMatchResponse> handler = inv.getArgument(3);  
        ExecutionTarget healthy = target("idx", 1);  
            any(),  
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
    public void testFiveShardsThreeMatchTwoPruned() {  
        survivorsOf(
            new Reply(true, bounds(0L, 30L)),
    }
            any(TransportResponseHandler.class)
        survivorsOf(
    }  
        assertEquals("nothing may be pruned when there are no filters", 2, result.get().size());  
            any(DiscoveryNode.class),
        doAnswer(inv -> {
    @SuppressWarnings("unchecked")
 * compatible open source license.
    private void mockCanMatchException(TransportException exception) {  
            descending(),  
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();  
            new ShardSortBounds(1_700_000_000_000_000_000L, 1_700_000_060_000_000_000L, false, ShardSortBounds.VALUE_KIND_INT64_NANOS)  
        ArgumentCaptor<TransportRequest> captor = ArgumentCaptor.forClass(TransportRequest.class);
            new byte[] { 1 },
     */
            new byte[] { 1 },
        assertSame(first, result.get().get(0));
        verify(transportService).sendRequest(  
    }  
            descending(),
            "datafusion",  
            return null;
    private void mockCanMatchResponse(boolean canMatch) {  
        );
            List.of(first, second),  
        survivorsOf(
        );  
        assertTrue(result.get().isEmpty());
    }
        );  
        assertEquals(1, result.get().size());
                eq(AnalyticsCanMatchAction.NAME),
            this(canMatch, bounds, null);
        // Transport failure → fail-open → target kept  
            phase,  
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        ExecutionTarget t0 = target("idx", 0);  
        CanMatchPreFilterPhase phase,
        verify(transportService, never()).sendRequest(  
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
import java.util.List;
    }
            List.of(t0, t1, t2),
            phase,  
                any(DiscoveryNode.class),
import org.opensearch.analytics.planner.dag.ExecutionTarget;
    /** One scripted can-match reply: either a response pair, or a transport failure. */
import static org.mockito.Mockito.mock;  
        Reply[] replies = new Reply[boundsPerShard.length];  
    @SuppressWarnings("unchecked")
        );
            TransportResponseHandler<AnalyticsCanMatchResponse> handler = inv.getArgument(3);
            new byte[] { 1 },
     * Ordering compares raw longs and ignores {@code valueKind}, so a millis and a nanos shard over the
        );
import java.util.Collections;  
                any(DiscoveryNode.class),  
        ExecutionTarget high = target("idx", 2);
        }).when(transportService)
        );  
    public void testSingleTargetMatch() {
    public void testAscendingOrdersByMinAscending() {
        }).when(transportService)
            new Reply(false, null),          // pruned — bounds must not influence anything  
            Collections.emptyList(),  
        assertEquals("nothing to order by → input order preserved", List.of(t0, t1, t2), result.get());
            );
                any(TransportResponseHandler.class)  
 *
            captor.capture(),
    }
        ExecutionTarget low = target("idx", 1);
            if (reply.failure() != null) {
        for (int i = 0; i < boundsPerShard.length; i++) {
        );
            "datafusion",  
        ExecutionTarget noStats = target("idx", 0);
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
            "datafusion",
}
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
        byte[] filterBytes,
                any(TransportRequest.class),  
            phase,
                handler.handleException(reply.failure());  
            Reply reply = callCount[0] < replies.length ? replies[callCount[0]] : new Reply(true, null);  
        ExecutionTarget second = target("idx", 1);
    /** A matching shard with no statistics is kept but sorted after every measured shard. */  
        DiscoveryNode node = new DiscoveryNode("node-" + shardNum, buildNewFakeTransportAddress(), Version.CURRENT);  
 * this file be licensed under the Apache-2.0 license or a
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
import static org.mockito.ArgumentMatchers.eq;
            any(TransportResponseHandler.class)
    ) {
            new byte[] { 1 },
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
        ExecutionTarget t3 = target("idx", 3);  
        ExecutionTarget t1 = target("idx", 1);
        );
            "datafusion",  
        survivorsOf(phase, targets, null, "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        survivorsOf(phase, targets, new byte[0], "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));  
import org.opensearch.transport.TransportResponseHandler;  
     * runs to collect the bounds that order the dispatch.
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();  
            any(DiscoveryNode.class),  
            "datafusion",
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
    /** Scripts per-shard bounds in dispatch order; all shards match. */
        ExecutionTarget t1 = target("idx", 1);
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();  
        assertEquals("nanos sorts first on scale alone — same instants", List.of(nanosShard, millisShard), result.get());
        mockCanMatchSequence(replies);
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
import org.opensearch.core.index.Index;
            List.of(noStats, measured),
    public void setUp() throws Exception {
        final int[] callCount = { 0 };  
                any(DiscoveryNode.class),
        survivorsOf(
        survivorsOf(phase, targets, new byte[] { 1 }, "my-backend", ActionListener.wrap(result::set, e -> fail(e.getMessage())));
        ExecutionTarget t1 = target("idx", 1);
        ExecutionTarget failing = target("idx", 0);
            any(DiscoveryNode.class),
            this(false, null, failure);  
                any(TransportResponseHandler.class)
        assertEquals(targets, result.get());
    }
            any(String.class),
        doAnswer(inv -> {  
        Reply(TransportException failure) {
        doAnswer(inv -> {
    public void testAllTargetsPrunedKeepsFirstTarget() {  
            "datafusion",
        );  
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
            new ShardSortBounds(1_700_000_000_000L, 1_700_000_060_000L, false, ShardSortBounds.VALUE_KIND_INT64_MILLIS),
        ExecutionTarget nanosShard = target("logs-nanos", 1);
            .sendRequest(  
    @Override  
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        ExecutionTarget t2 = target("idx", 2);
            new byte[] { 1 },
            sortSpec,  
import org.opensearch.transport.TransportService;
                any(DiscoveryNode.class),
                any(DiscoveryNode.class),
    }
            descending(),
            any(TransportResponseHandler.class)
        ExecutionTarget only = target("idx", 0);
    }  
        super.setUp();
    }  
        mockCanMatchSequence(new Reply(true, null), new Reply(true, bounds(0L, 10L)));
            any(TransportResponseHandler.class)
    }  
    // --- sort-bounds ordering (stage 2) ---
    public void testDescendingOrdersByMaxDescending() {
            any(TransportResponseHandler.class)
                eq(AnalyticsCanMatchAction.NAME),
        ExecutionTarget t2 = target("idx", 2);
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            "datafusion",  
    private void mockCanMatchSequence(Reply... replies) {
            .sendRequest(  
            phase,
            .sendRequest(  
            TransportResponseHandler<AnalyticsCanMatchResponse> handler = inv.getArgument(3);
        survivorsOf(
    }  
    /**  
        survivorsOf(
                eq(AnalyticsCanMatchAction.NAME),
            return null;
        assertEquals(2, result.get().size());
        );
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
import static org.mockito.Mockito.never;
    /** Pruning and ordering are independent: pruned shards drop out, survivors get ordered. */
    }
        ExecutionTarget t0 = target("idx", 0);
    }
                handler.handleResponse(new AnalyticsCanMatchResponse(reply.canMatch(), reply.bounds()));
            any(DiscoveryNode.class),
            phase,  
        verify(transportService, never()).sendRequest(
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        }
 * SPDX-License-Identifier: Apache-2.0
        doAnswer(inv -> {
            any(String.class),
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();  
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;  
     * disagree, so dispatch order never changes results.
        ActionListener<List<ExecutionTarget>> listener  
            eq(AnalyticsCanMatchAction.NAME),
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
        mockCanMatchResponse(false);
        assertEquals(List.of(t2, t0), result.get());  
    /** Shards 0,2,4 match and 1,3 prune; survivors are [0,2,4] in order. */
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();  
        }).when(transportService)
        transportService = mock(TransportService.class);  
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
        );  
    }  
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
    private ShardExecutionTarget target(String indexName, int shardNum) {
    }  
        List<ExecutionTarget> targets,
import static org.mockito.Mockito.doAnswer;
            );
        assertEquals(1, result.get().size());
            phase,  
            replies[i] = new Reply(true, boundsPerShard[i]);
        assertSame(only, result.get().get(0));
    ) {
    public void testBackendIdPassedInRequest() {
            descending(),
            phase,  
    }  
            new byte[] { 1 },
        );
    }  
        ExecutionTarget first = target("idx", 0);  
        assertNull(((AnalyticsCanMatchRequest) captor.getValue()).getSortColumn());
            handler.handleException(exception);  
import org.mockito.ArgumentCaptor;
        ExecutionTarget t0 = target("idx", 0);  
        assertSame(second, result.get().get(1));
            handler.handleResponse(new AnalyticsCanMatchResponse(match));  
            } else {
        survivorsOf(
        List<ExecutionTarget> targets = List.of(target("idx", 0));
        String backendId,  
        SortSpec sortSpec,
        survivorsOf(phase, targets, new byte[0], "datafusion", descending(), ActionListener.wrap(result::set, e -> fail(e.getMessage())));
        );  
        ExecutionTarget t0 = target("idx", 0);
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);  
    }
    public void testEmptyTargetsReturnsEmpty() {  
        AtomicReference<List<ExecutionTarget>> result = new AtomicReference<>();
            List.of(withoutBounds, low, high),  
        List<ExecutionTarget> targets = List.of(target("idx", 0), target("idx", 1));
            callCount[0]++;
            descending(),
        ExecutionTarget only = target("idx", 0);  
import static org.mockito.Mockito.verify;  
            eq(AnalyticsCanMatchAction.NAME),  
        ExecutionTarget first = target("idx", 0);  
        );  
        survivorsOf(
        mockCanMatchResponseWithBounds(false, null);
            List.of(t0, t1, t2),
        ArgumentCaptor<TransportRequest> captor = ArgumentCaptor.forClass(TransportRequest.class);  
    }  
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))  
            any(DiscoveryNode.class),
        return new SortSpec("@timestamp", true, 10);  
        survivorsOf(phase, targets, new byte[] { 1 }, "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));
            "datafusion",
                any(TransportResponseHandler.class)
        mockCanMatchSequence(new Reply(new TransportException("connection lost")), new Reply(true, bounds(0L, 5L)));
    @SuppressWarnings("unchecked")
            return null;  
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
import org.opensearch.core.index.shard.ShardId;
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))  
        // DESC orders by max, so t2 (highest max) runs first.  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(List.of(t2, t1, t0), result.get());
            ActionListener.map(listener, CanMatchPreFilterPhase.ShardCheckResult::targets)
            );
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
    /** All pruned → force-keep still applies, and ordering must not disturb it. */
            new byte[] { 1 },
            descending(),
        mockCanMatchResponseWithBounds(true, bounds(1L, 2L));
                any(TransportRequest.class),  
     */  
            ascending(),  
        }  
    private TransportService transportService;
        assertEquals(List.of(healthy, failing), result.get());
            descending(),
import java.util.concurrent.atomic.AtomicReference;
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
    }
        assertSame(t2, result.get().get(1));
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        ExecutionTarget measured = target("idx", 1);  
        ExecutionTarget t4 = target("idx", 4);
        assertEquals("all pruned → keep exactly one", 1, result.get().size());
    @SuppressWarnings("unchecked")
            "datafusion",
        List<ExecutionTarget> targets,
            new byte[] { 1 },
        verify(transportService).sendRequest(
        byte[] filterBytes,  
import org.opensearch.core.action.ActionListener;  
 */  
        ActionListener<List<ExecutionTarget>> listener
    private static SortSpec descending() {
        assertEquals(1, result.get().size());
                eq(AnalyticsCanMatchAction.NAME),
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
        ExecutionTarget millisShard = target("logs-millis", 0);
        Reply(boolean canMatch, ShardSortBounds bounds) {
        ExecutionTarget first = target("idx", 0);  
        CanMatchPreFilterPhase phase,  
        ShardId shardId = new ShardId(new Index(indexName, "_na_"), shardNum);
    private void mockCanMatchResponseSequence(boolean... responses) {  
            eq(AnalyticsCanMatchAction.NAME),  
            List.of(target("idx", 0)),  
            TransportResponseHandler<AnalyticsCanMatchResponse> handler = inv.getArgument(3);
    private static void survivorsOf(
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);  
            descending(),
        mockCanMatchBoundsSequence(bounds(300L, 999L), bounds(100L, 999L), bounds(200L, 999L));  
    public void testSortColumnForwardedInRequest() {  
        CanMatchPreFilterPhase phase = new CanMatchPreFilterPhase(transportService);
                any(TransportRequest.class),
    public void testEmptyFilterBytesPassesAllTargets() {
    public void testAllPrunedWithSortSpecStillKeepsFirstTarget() {
            ActionListener.wrap(result::set, e -> fail(e.getMessage()))
        );  
        survivorsOf(phase, List.of(only), new byte[] { 1 }, "datafusion", ActionListener.wrap(result::set, e -> fail(e.getMessage())));  
                any(TransportResponseHandler.class)
        mockCanMatchResponseSequence(true, false, true, false, true);
                any(TransportRequest.class),  
        );
        mockCanMatchResponse(true);  
    /** No filters AND no sort spec — nothing to learn, so the round-trip must be skipped. */  
    public void testShardWithoutStatisticsIsKeptAndSortedLast() {
    }
        mockCanMatchSequence(
        phase.checkShards(
        List<ExecutionTarget> targets = List.of(target("idx", 0));  
