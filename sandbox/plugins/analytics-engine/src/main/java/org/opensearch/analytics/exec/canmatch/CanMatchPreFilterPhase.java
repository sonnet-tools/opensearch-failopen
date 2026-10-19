     * Dispatches one can-match request per target in parallel and hands back the survivors in
        void keep(ExecutionTarget target, ShardSortBounds bounds, AtomicInteger pending) {
                            logger.error(
     * <p>Returns without a round-trip when there is nothing to learn — no targets, or neither
                            );
            }
    public void checkShards(
     *                    empty prunes nothing, which is the normal shape for a bare sort
 * parallel and uses each reply for two independent things:
import org.opensearch.core.common.io.stream.StreamInput;
     *
        AtomicInteger pending = new AtomicInteger(targets.size());
    public CanMatchPreFilterPhase(TransportService transportService) {
                completion.keep(target, null, pending);
            } catch (Exception e) {
    }
     * Collects survivors and their bounds as responses land, then orders them and fires the listener
        for (ExecutionTarget target : targets) {
                        public void handleResponse(AnalyticsCanMatchResponse response) {
                    node,
        Map<ExecutionTarget, ShardSortBounds> boundsByTarget,
        }
     * once the last one is in.
                            // Fail-open: include this target on any transport error
        if (targets.isEmpty()) {
            return;
    /**
        List<ExecutionTarget> targets,
                        }
        if (hasFilters == false && sortSpec == null) {
 *   <li><b>Ordering</b> (needs a bounded field sort) — sorts the survivors by the sort column's
                        }
    /**
 * compatible open source license.
 *       min/max so the most promising shard is dispatched first.</li>
     *
            // DESC wants the largest max first; ASC wants the smallest min first.
 *
            return descending ? Long.compare(b.max(), a.max()) : Long.compare(a.min(), b.min());
                            return "same";
 * @opensearch.internal
        boolean descending = sortSpec.descending();
     * @param sortSpec    primary sort key + direction, or {@code null} to skip bounds collection
                    request,
            listener.onResponse(ShardCheckResult.keepAll(Collections.emptyList()));
 * The OpenSearch Contributors require contributions made to
        SortSpec sortSpec
                                completion.drop(pending);
 *
            if (matching.isEmpty() && originalTargets.isEmpty() == false) {
    public record ShardCheckResult(List<ExecutionTarget> targets, Map<ExecutionTarget, ShardSortBounds> boundsByTarget) {
 * <p>Neither needs the other: a query may have filters, a sort, or both. They share one phase
 *
        }
/*
     */
                                logger.debug("can-match: shard {} pruned", shardTarget.shardId());
                        @Override
                            completion.keep(target, null, pending);
                return a == b ? 0 : (a == null ? 1 : -1);
            }
     */
            ShardSortBounds b = boundsByTarget.get(right);
 *
import org.opensearch.transport.TransportResponseHandler;
        }
        }
                                completion.keep(target, response.bounds(), pending);
        }
        Map<ExecutionTarget, ShardSortBounds> boundsByTarget = new IdentityHashMap<>();
    private static void orderByBounds(
     * filters nor a sort spec.
            try {
            return;
                transportService.sendRequest(
import java.util.IdentityHashMap;
        survivors.sort((left, right) -> {
        List<ExecutionTarget> matching = new ArrayList<>(targets.size());
            listener.onResponse(ShardCheckResult.keepAll(targets));
            return;
            }
                }
                    AnalyticsCanMatchAction.NAME,
                    }
 * serves both. Ordering only changes dispatch sequence, never results.
            if (!(target instanceof ShardExecutionTarget shardTarget)) {
                            if (response.canMatch()) {
        }
                        }
            AnalyticsCanMatchRequest request = new AnalyticsCanMatchRequest(shardTarget.shardId(), effectiveFilters, backendId, sortColumn);
        }
    private static final byte[] EMPTY_FILTERS = new byte[0];
 */
                        @Override
    ) {
     *
                if (bounds != null) {
 * (never prunes it) with no bounds. Missing bounds are also normal for a healthy shard whose sort
                                exp
        });
public class CanMatchPreFilterPhase {
        List<ExecutionTarget> survivors,
     * @param targets     resolved execution targets
        ActionListener<ShardCheckResult> listener
    }
 *   <li><b>Pruning</b> (needs range filters) — drops shards that provably cannot match the
        SortSpec sortSpec,
     * @param boundsByTarget shard-wide min/max, for the subset of targets that reported any
        ExecutionTarget> originalTargets, SortSpec sortSpec, ActionListener<ShardCheckResult> listener) {
 */
                        }
        private void maybeComplete(AtomicInteger pending) {
                continue;
}
 * <p>Fail-open throughout: a transport failure, timeout, or unexpected exception keeps the target
 * SPDX-License-Identifier: Apache-2.0
                            return new AnalyticsCanMatchResponse(in);
import java.util.Collections;
    private record Completion(List<ExecutionTarget> matching, Map<ExecutionTarget, ShardSortBounds> boundsByTarget, List<
     * @param targets        survivors in dispatch order — most promising first when ordering applied
import org.apache.logging.log4j.LogManager;
                return;
        /** Fail-open result: every target kept, nothing learned about bounds. */
            }
     * @param filterBytes serialized filter list (from {@link CanMatchFilterSerializer}); null or
 *       {@code WHERE} predicates.</li>
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
        if (survivors.size() < 2 || boundsByTarget.isEmpty()) {
            listener.onResponse(new ShardCheckResult(matching, Collections.unmodifiableMap(boundsByTarget)));
import java.util.ArrayList;
     * dispatch order plus each one's bounds.
            DiscoveryNode node = shardTarget.node();
import org.opensearch.transport.TransportException;
 * this file be licensed under the Apache-2.0 license or a
        this.transportService = transportService;
        byte[] effectiveFilters = hasFilters ? filterBytes : EMPTY_FILTERS;
        String backendId,
                // Fail-open: connection failure or other exception
            if (sortSpec != null) {
                // nulls last; equal when both unknown
 * column has no usable statistics — those shards just sort last.
 * <ol>
 * Coordinator-side shard-metadata check. Sends one lightweight request per shard target in
import org.opensearch.analytics.planner.dag.ExecutionTarget;
                    boundsByTarget.put(target, bounds);
        byte[] filterBytes,
import org.opensearch.cluster.node.DiscoveryNode;
                        public AnalyticsCanMatchResponse read(StreamInput in) throws IOException {
import java.util.List;
    /** Sent for a sort with no filters: the data node prunes nothing but still folds bounds. */
        logger.debug("can-match: ordered {} shards by {} {}", survivors.size(), sortSpec.column(), descending ? "DESC(max)" : "ASC(min)");
    }
            if (a == null || b == null) {
                                () -> "can-match: transport error for shard " + shardTarget.shardId() + ", keeping (fail-open)",
                            } else {
        Completion completion = new Completion(matching, boundsByTarget, targets, sortSpec, listener);
        }
                        @Override
            maybeComplete(pending);
    private static final Logger logger = LogManager.getLogger(CanMatchPreFilterPhase.class);
                        public String executor() {
import org.apache.logging.log4j.Logger;
                orderByBounds(matching, boundsByTarget, sortSpec);
            ShardSortBounds a = boundsByTarget.get(left);
/**
                            }
import org.opensearch.analytics.spi.ShardSortBounds;
import java.io.IOException;
    /** Sorts {@code survivors} most-promising-first: by {@code max} for DESC, {@code min} for ASC, unbounded shards last. */
 * </ol>
import java.util.Map;
        public static ShardCheckResult keepAll(List<ExecutionTarget> targets) {
        boolean hasFilters = filterBytes != null && filterBytes.length > 0;
        void drop(AtomicInteger pending) {
            return new ShardCheckResult(targets, Collections.emptyMap());
import java.util.concurrent.atomic.AtomicInteger;
                        public void handleException(TransportException exp) {
            }
                logger.error("can-match: dispatch failed for shard {}, keeping (fail-open): {}", shardTarget.shardId(), e.getMessage());
            synchronized (matching) {
    }
    ) {
                // Non-shard targets pass through unconditionally
package org.opensearch.analytics.exec.canmatch;
            }
    private final TransportService transportService;
    }
                );
                matching.add(target);
        String sortColumn = sortSpec != null ? sortSpec.column() : null;
                matching.add(originalTargets.get(0));
import org.opensearch.transport.TransportService;
 * because both answers come from the same shard reader and parquet footers, so one round-trip
            }
import org.opensearch.core.action.ActionListener;
    /**
                        @Override
                completion.keep(target, null, pending);
                    new TransportResponseHandler<AnalyticsCanMatchResponse>() {
 *
     * Result of a {@link #checkShards} call: the surviving targets and their sort-column ranges.
            if (pending.decrementAndGet() != 0) {
     */
            maybeComplete(pending);
