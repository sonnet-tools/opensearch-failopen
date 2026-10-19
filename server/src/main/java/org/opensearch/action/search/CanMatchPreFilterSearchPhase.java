            timeProvider,
    @Override
             * refers to the first active shard, not necessarily shardsIts.get(0).
import org.opensearch.core.action.ActionListener;
        Tracer tracer
        return Arrays.copyOf(shardIndexes, activeShardCount);
            }
        ClusterState clusterState,
        }
        synchronized int getNumPossibleMatches() {
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under
 * The OpenSearch Contributors require contributions made to
            searchRequestContext,
 * under the License.
            if (canMatch) {
            return false; // unneeded
 * You may obtain a copy of the License at
    private static boolean shouldSortShards(MinAndMax<?>[] minAndMaxes) {
            listener,
            possibleMatches = new FixedBitSet(originalShardCount);
 */
            logger,
        TransportSearchAction.SearchTimeProvider timeProvider,
        SearchTransportService searchTransportService,
            .map(shardsIts::get)
 */
            phaseFactory,
        super(
                    "invalid can_match shard index ["
        SearchRequestContext searchRequestContext,
        Class<?> clazz = null;
                // we don't support sort values that mix different types (e.g.: long/double, numeric/keyword).
        SearchShardIterator shardIt,
 * software distributed under the License is distributed on an
        ActionListener<SearchResponse> listener,
                        + activeShardIndex
            executor,
        }
        FixedBitSet possibleMatches = results.getPossibleMatches();
            if (activeShardIndex < 0 || activeShardIndex >= activeShardIndexToOriginalShardIndex.length) {
        SortOrder order
        return comparator.thenComparing(index -> shardsIts.get(index).shardId());
            task,
        synchronized void consumeResult(int shardIndex, boolean canMatch, MinAndMax<?> minAndMax) {
    }
        private final MinAndMax<?>[] minAndMaxes;
 * SPDX-License-Identifier: Apache-2.0
                iter.resetAndSkip();
        int[] shardIndexes = new int[shardsIts.size()];
final class CanMatchPreFilterSearchPhase extends AbstractSearchAsyncAction<CanMatchResponse> {
 * This phase can also be used to pre-sort shards based on min/max values in each shard of the provided primary sort.
        @Override
import org.opensearch.search.sort.MinAndMax;
        SearchRequest request,
import org.opensearch.transport.Transport;
import org.opensearch.search.sort.FieldSortBuilder;
 * from the search. The extra round trip to the search shards is very cheap and is not subject to rejections
            firstActiveShardIndex = activeShardIndexToOriginalShardIndex.length == 0 ? 0 : activeShardIndexToOriginalShardIndex[0];
    private static Comparator<Integer> shardComparator(
        SearchTask task,
import org.opensearch.search.SearchShardTarget;
    protected void executePhaseOnShard(
        SearchShardTarget shard,
 * this work for additional information regarding copyright
                // that the merging of topdocs will fail later for the same reason ?
            if (possibleMatches.get(i++)) {
        GroupShardsIterator<SearchShardIterator> shardsIts,
    ) {
            clusterState,
    }
        Map<String, Set<String>> indexRoutings,
import org.opensearch.telemetry.tracing.Tracer;
                        + ")"
            clusterState,
            searchRequestContext,
        }
 * sort them according to the provided order. This can be useful for instance to ensure that shards that contain recent
                next.run();
        ActionListener<SearchResponse> listener,
 * Licensed to Elasticsearch under one or more contributor
             */
        void consumeResult(CanMatchResponse result, Runnable next) {
     * Inner class for determining if canMatch search phase results
        ClusterState clusterState,
        }
import java.util.Map;
            // this is a special case where we have no hit but we need to get at least one search response in order
import org.opensearch.search.internal.AliasFilter;
            searchTransportService,
import org.apache.logging.log4j.Logger;
            executor,
        private final FixedBitSet possibleMatches;
            .collect(Collectors.toList());
        private final int firstActiveShardIndex;
    @Override
        );
            .boxed()
    ) {
        final Comparator<Integer> comparator = Comparator.comparing(index -> minAndMaxes[index], MinAndMax.getComparator(order));
             * GroupShardsIterator so skipped shard groups remain in their original positions
             * for accounting and downstream phases.
    private CanMatchPreFilterSearchPhase(
            getTask(),
        }
        this.phaseFactory = phaseFactory;
 * license agreements. See the NOTICE file distributed with
            activeShardIndexLookup.length,
            }
 * The queries are rewritten against the shards and based on the rewrite result shards might be able to be excluded
            request,
        private final int[] activeShardIndexToOriginalShardIndex;
 * This search phase can be used as an initial search phase to pre-filter search shards based on query rewriting.
        boolean hasResult(int shardIndex) {
        @Override
    }
            indexRoutings,
        FieldSortBuilder fieldSort = FieldSortBuilder.getPrimaryFieldSortOrNull(source);
 * GitHub history for details.
            return activeShardIndexToOriginalShardIndex.length > 0;
        Logger logger,
            // we have to carry over shard failures in order to account for them in the response.
 * this file be licensed under the Apache-2.0 license or a
            searchTransportService,
 * Unless required by applicable law or agreed to in writing,
            }
            try {
    ) {
        Map<String, Float> concreteIndexBoosts,
        GroupShardsIterator<SearchShardIterator> shardsIts,
            /*
 * which allows to fan out to more shards at the same time without running into rejections even if we are hitting a
    private GroupShardsIterator<SearchShardIterator> getIterator(
                return false;
    }
             * group indexes.
        this.shardsIts = shardsIts;
            return shardsIts;
/*
    @Override
            concreteIndexBoosts,
            aliasFilter,
                        + activeShardIndexToOriginalShardIndex.length
        Map<String, AliasFilter> aliasFilter,
            }
        private int originalShardIndex(int activeShardIndex) {
import java.util.function.BiFunction;
        Executor executor,
 * Modifications Copyright OpenSearch Contributors. See
            // to produce a valid search result with all the aggs etc.
        }
    private static int[] buildActiveShardIndexLookup(GroupShardsIterator<SearchShardIterator> shardsIts) {
            return numPossibleMatches;
        if (shouldSortShards(results.minAndMaxes) == false) {
        int activeShardCount = 0;
             * CanMatchPreFilterSearchPhase applies possibleMatches back onto the original
            clusters,
            shardsIts,
                shardIndexes[activeShardCount++] = i;
        SearchResponse.Clusters clusters,
import java.util.stream.Collectors;
        GroupShardsIterator<SearchShardIterator> shardsIts,
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.stream.Stream;
            concreteIndexBoosts,
        Stream<CanMatchResponse> getSuccessfulResults() {
        @Override
        }
import java.util.Comparator;
import java.util.Set;
        }
 * When the query primary sort is perform on a field, this phase extracts the min/max value in each shard and
 */
    ) {
            if (clazz == null) {
             *
            request,
import org.opensearch.search.builder.SearchSourceBuilder;
        void consumeShardFailure(int shardIndex) {
            } finally {
import java.util.List;
            aliasFilter,
                        + "] for active shard index range [0, "
     *
import org.opensearch.search.SearchService.CanMatchResponse;
            tracer
 *
        SortOrder order
            this.activeShardIndexToOriginalShardIndex = activeShardIndexToOriginalShardIndex;
        }
    private final Function<GroupShardsIterator<SearchShardIterator>, SearchPhase> phaseFactory;
    protected SearchPhase getNextPhase(SearchPhaseResults<CanMatchResponse> results, SearchPhaseContext context) {
                numPossibleMatches++;
             * This lookup translates compacted active shard indexes back to original shard
        SearchActionListener<CanMatchResponse> listener
 * data are executed first when sorting by descending timestamp.
    private static List<SearchShardIterator> sortShards(
             * AbstractSearchAsyncAction executes only non-skipped shard iterators. This
        return phaseFactory.apply(getIterator((CanMatchSearchPhaseResults) results, shardsIts));
            minAndMaxes = new MinAndMax[originalShardCount];
 *
            if (shardsIts.get(i).skip() == false) {
            nodeIdToConnection,
            listener,
    ) {
        GroupShardsIterator<SearchShardIterator> shardsIts,
/*
                clazz = minAndMax == null ? null : minAndMax.getMin().getClass();
        int cardinality = results.getNumPossibleMatches();
             *
            return firstActiveShardIndex;
            super(originalShardCount);
            consumeResult(originalShardIndex(shardIndex), true, null);
        }
            clusters,
        boolean hasActiveShards() {
            }
        SearchResponse.Clusters clusters,
            buildShardSearchRequest(shardIt),
    private final GroupShardsIterator<SearchShardIterator> shardsIts;
        GroupShardsIterator<SearchShardIterator> shardsIts
        synchronized FixedBitSet getPossibleMatches() {
     * @opensearch.internal
        }
             * compacts the shard indexes observed by can_match responses: response index 0
        );
        for (int i = 0; i < shardsIts.size(); i++) {
 * @opensearch.internal
            SearchPhaseName.CAN_MATCH.getName(),
        return clazz != null;
    CanMatchPreFilterSearchPhase(
        SearchSourceBuilder source = getRequest().source();
            nodeIdToConnection,
 * compatible open source license.
        throw new RuntimeException("cannot add releasable in " + getName() + " phase");
                consumeResult(originalShardIndex(result.getShardIndex()), result.canMatch(), result.estimatedMinAndMax());
        int[] activeShardIndexLookup,
        }
        return IntStream.range(0, shardsIts.size())
import java.util.stream.IntStream;
        MinAndMax<?>[] minAndMaxes,
        Map<String, AliasFilter> aliasFilter,
    public void addReleasable(Releasable releasable) {
 * not use this file except in compliance with the License.
        this(
        SearchTransportService searchTransportService,
        for (SearchShardIterator iter : shardsIts) {
    }
    }
        SearchRequest request,
import org.apache.lucene.util.FixedBitSet;
package org.opensearch.action.search;
 *
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
                possibleMatches.set(results.getFirstActiveShardIndex());
        Map<String, Set<String>> indexRoutings,
            return Stream.empty();
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.Executor;
    }
        }
                // TODO: we could fail the request because there is a high probability
        MinAndMax<?>[] minAndMaxes,
        Function<GroupShardsIterator<SearchShardIterator>, SearchPhase> phaseFactory,
        SearchTask task,
                possibleMatches.set(shardIndex);
            getConnection(shard.getClusterAlias(), shard.getNodeId()),
        CanMatchSearchPhaseResults results,
    private static final class CanMatchSearchPhaseResults extends SearchPhaseResults<CanMatchResponse> {
        private int numPossibleMatches;
        CanMatchSearchPhaseResults(int originalShardCount, int[] activeShardIndexToOriginalShardIndex) {
    ) {
        getSearchTransport().sendCanMatch(
            new CanMatchSearchPhaseResults(shardsIts.size(), activeShardIndexLookup),
            indexRoutings,
        int i = 0;
        TransportSearchAction.SearchTimeProvider timeProvider,
        BiFunction<String, String, Transport.Connection> nodeIdToConnection,
        Logger logger,
                iter.reset();
            } else if (minAndMax != null && clazz != minAndMax.getMin().getClass()) {
            shardsIts,
}
            logger,
        for (MinAndMax<?> minAndMax : minAndMaxes) {
            return activeShardIndexToOriginalShardIndex[activeShardIndex];
import org.opensearch.cluster.routing.GroupShardsIterator;
        if (cardinality == 0) {
            minAndMaxes[shardIndex] = minAndMax;
/*
            } else {
            task,
     */
                throw new IllegalStateException(
            timeProvider,
import org.opensearch.cluster.ClusterState;
            if (results.hasActiveShards()) {
            }
        int getFirstActiveShardIndex() {
        Tracer tracer
        @Override
        return new GroupShardsIterator<>(sortShards(shardsIts, results.minAndMaxes, fieldSort.order()));
        Map<String, Float> concreteIndexBoosts,
            }
import org.opensearch.common.lease.Releasable;
        }
import java.util.Arrays;
        }
            listener
            .sorted(shardComparator(shardsIts, minAndMaxes, order))
import org.opensearch.search.sort.SortOrder;
        Function<GroupShardsIterator<SearchShardIterator>, SearchPhase> phaseFactory,
            buildActiveShardIndexLookup(shardsIts),
        SearchRequestContext searchRequestContext,
 *
        Executor executor,
    }
            tracer
    /**
            return possibleMatches;
/**
                );
    }
        // Use the active shard count so can_match is effectively unthrottled without over-sizing the concurrency budget.
        BiFunction<String, String, Transport.Connection> nodeIdToConnection,
 * large portion of the clusters indices.
        );
    }
        }
import java.util.function.Function;
