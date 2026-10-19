            maybeComplete(pending);
 */
}
        AtomicInteger pending = new AtomicInteger(targets.size());  
            if (sortSpec != null) {
                    request,
        }
                completion.keep(target, null, pending);
                        @Override  
    /**
            }  
            ShardSortBounds a = boundsByTarget.get(left);
        void keep(ExecutionTarget target, ShardSortBounds bounds, AtomicInteger pending) {
 * <p>Neither needs the other: a query may have filters, a sort, or both. They share one phase
import org.opensearch.transport.TransportException;  
                matching.add(originalTargets.get(0));  
        /** Fail-open result: every target kept, nothing learned about bounds. */  
     */
 *  
            }
    private record Completion(List<ExecutionTarget> matching, Map<ExecutionTarget, ShardSortBounds> boundsByTarget, List<
    /**  
        Completion completion = new Completion(matching, boundsByTarget, targets, sortSpec, listener);
                        public void handleResponse(AnalyticsCanMatchResponse response) {
        if (hasFilters == false && sortSpec == null) {  
     * @param targets     resolved execution targets
import java.util.Collections;  
/*  
        }
import org.opensearch.core.action.ActionListener;
import org.opensearch.transport.TransportResponseHandler;
        List<ExecutionTarget> survivors,
import org.opensearch.core.common.io.stream.StreamInput;
 * <p>Fail-open throughout: a transport failure, timeout, or unexpected exception keeps the target  
            }
                        }
 *
    ) {
     * Collects survivors and their bounds as responses land, then orders them and fires the listener
                            return new AnalyticsCanMatchResponse(in);  
 * </ol>  
        Map<ExecutionTarget, ShardSortBounds> boundsByTarget = new IdentityHashMap<>();
     * dispatch order plus each one's bounds.
                logger.error("can-match: dispatch failed for shard {}, keeping (fail-open): {}", shardTarget.shardId(), e.getMessage());
     * @param sortSpec    primary sort key + direction, or {@code null} to skip bounds collection
                                logger.debug("can-match: shard {} pruned", shardTarget.shardId());
import org.apache.logging.log4j.Logger;
                return a == b ? 0 : (a == null ? 1 : -1);  
 * parallel and uses each reply for two independent things:
                completion.keep(target, null, pending);  
        }  
        this.transportService = transportService;
        SortSpec sortSpec,
 * (never prunes it) with no bounds. Missing bounds are also normal for a healthy shard whose sort
 *  
 * Coordinator-side shard-metadata check. Sends one lightweight request per shard target in
        }  
import org.opensearch.analytics.spi.ShardSortBounds;
    ) {  
                            if (response.canMatch()) {
    }  
 *
        public static ShardCheckResult keepAll(List<ExecutionTarget> targets) {
        SortSpec sortSpec
 * <ol>
    public CanMatchPreFilterPhase(TransportService transportService) {  
            listener.onResponse(ShardCheckResult.keepAll(targets));
     * @param filterBytes serialized filter list (from {@link CanMatchFilterSerializer}); null or
public class CanMatchPreFilterPhase {  
     */
                        }  
        }
                            }
            return descending ? Long.compare(b.max(), a.max()) : Long.compare(a.min(), b.min());  
     *  
    public record ShardCheckResult(List<ExecutionTarget> targets, Map<ExecutionTarget, ShardSortBounds> boundsByTarget) {
    /** Sorts {@code survivors} most-promising-first: by {@code max} for DESC, {@code min} for ASC, unbounded shards last. */  
    private static void orderByBounds(
    }
                                exp  
                    }  
        }
            } catch (Exception e) {
 */  
                matching.add(target);
                            // Fail-open: include this target on any transport error  
    public void checkShards(  
 * @opensearch.internal
            DiscoveryNode node = shardTarget.node();
        String sortColumn = sortSpec != null ? sortSpec.column() : null;
                        }
        String backendId,  
                        public void handleException(TransportException exp) {
            return;
            AnalyticsCanMatchRequest request = new AnalyticsCanMatchRequest(shardTarget.shardId(), effectiveFilters, backendId, sortColumn);
                            logger.error(
     * <p>Returns without a round-trip when there is nothing to learn — no targets, or neither
                        @Override
 * SPDX-License-Identifier: Apache-2.0
     *  
            synchronized (matching) {  
 *       min/max so the most promising shard is dispatched first.</li>
    /**
        boolean descending = sortSpec.descending();  
                        }
 * serves both. Ordering only changes dispatch sequence, never results.
        void drop(AtomicInteger pending) {  
        }  
            }
    private final TransportService transportService;
import org.opensearch.analytics.planner.dag.ExecutionTarget;  
            if (pending.decrementAndGet() != 0) {
        byte[] effectiveFilters = hasFilters ? filterBytes : EMPTY_FILTERS;
        boolean hasFilters = filterBytes != null && filterBytes.length > 0;
        List<ExecutionTarget> matching = new ArrayList<>(targets.size());
                transportService.sendRequest(
                            } else {
import org.apache.logging.log4j.LogManager;
        private void maybeComplete(AtomicInteger pending) {
import java.io.IOException;
 *
                if (bounds != null) {
 * The OpenSearch Contributors require contributions made to  
     * @param boundsByTarget shard-wide min/max, for the subset of targets that reported any
            listener.onResponse(ShardCheckResult.keepAll(Collections.emptyList()));
 * this file be licensed under the Apache-2.0 license or a
        List<ExecutionTarget> targets,
        byte[] filterBytes,
 *   <li><b>Ordering</b> (needs a bounded field sort) — sorts the survivors by the sort column's
 * because both answers come from the same shard reader and parquet footers, so one round-trip  
        logger.debug("can-match: ordered {} shards by {} {}", survivors.size(), sortSpec.column(), descending ? "DESC(max)" : "ASC(min)");
                        public String executor() {  
                return;  
                            return "same";
                        @Override
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
    }
            maybeComplete(pending);  
        if (survivors.size() < 2 || boundsByTarget.isEmpty()) {  
                        @Override
    }
package org.opensearch.analytics.exec.canmatch;
                continue;
import org.opensearch.cluster.node.DiscoveryNode;  
                            );
            listener.onResponse(new ShardCheckResult(matching, Collections.unmodifiableMap(boundsByTarget)));
 * compatible open source license.
        survivors.sort((left, right) -> {
        Map<ExecutionTarget, ShardSortBounds> boundsByTarget,  
                    new TransportResponseHandler<AnalyticsCanMatchResponse>() {  
     *  
import java.util.ArrayList;
/**  
            if (matching.isEmpty() && originalTargets.isEmpty() == false) {
import org.opensearch.transport.TransportService;
        if (targets.isEmpty()) {
import java.util.IdentityHashMap;
     *                    empty prunes nothing, which is the normal shape for a bare sort  
                    boundsByTarget.put(target, bounds);  
                // Fail-open: connection failure or other exception  
                                () -> "can-match: transport error for shard " + shardTarget.shardId() + ", keeping (fail-open)",
        ExecutionTarget> originalTargets, SortSpec sortSpec, ActionListener<ShardCheckResult> listener) {  
    private static final byte[] EMPTY_FILTERS = new byte[0];
 * column has no usable statistics — those shards just sort last.
                        public AnalyticsCanMatchResponse read(StreamInput in) throws IOException {
            return;
            }
 *   <li><b>Pruning</b> (needs range filters) — drops shards that provably cannot match the
    private static final Logger logger = LogManager.getLogger(CanMatchPreFilterPhase.class);
import java.util.List;
        }
     * Result of a {@link #checkShards} call: the surviving targets and their sort-column ranges.
            if (!(target instanceof ShardExecutionTarget shardTarget)) {
                );
            // DESC wants the largest max first; ASC wants the smallest min first.
            return new ShardCheckResult(targets, Collections.emptyMap());
                                completion.keep(target, response.bounds(), pending);  
     * @param targets        survivors in dispatch order — most promising first when ordering applied
import java.util.Map;  
     * once the last one is in.  
            }
                                completion.drop(pending);  
     * filters nor a sort spec.
            ShardSortBounds b = boundsByTarget.get(right);  
     */  
                    node,  
 *       {@code WHERE} predicates.</li>  
import java.util.concurrent.atomic.AtomicInteger;
    }
            try {
            return;  
            }
                            completion.keep(target, null, pending);
            if (a == null || b == null) {
        for (ExecutionTarget target : targets) {  
    /** Sent for a sort with no filters: the data node prunes nothing but still folds bounds. */
        ActionListener<ShardCheckResult> listener
                }
        });
                // Non-shard targets pass through unconditionally
     * Dispatches one can-match request per target in parallel and hands back the survivors in
                    AnalyticsCanMatchAction.NAME,
                // nulls last; equal when both unknown
                orderByBounds(matching, boundsByTarget, sortSpec);  
