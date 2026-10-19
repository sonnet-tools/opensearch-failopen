     * @opensearch.internal  
                // that the merging of topdocs will fail later for the same reason ?
            .collect(Collectors.toList());  
        }  
        Map<String, AliasFilter> aliasFilter,
            aliasFilter,
        if (shouldSortShards(results.minAndMaxes) == false) {
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
        @Override
        return clazz != null;  
        FixedBitSet possibleMatches = results.getPossibleMatches();  
import org.opensearch.telemetry.tracing.Tracer;
        Tracer tracer  
        SearchTransportService searchTransportService,  
 * this work for additional information regarding copyright
            shardsIts,
    private static final class CanMatchSearchPhaseResults extends SearchPhaseResults<CanMatchResponse> {
package org.opensearch.action.search;
        this.shardsIts = shardsIts;
import java.util.List;  
        TransportSearchAction.SearchTimeProvider timeProvider,  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Inner class for determining if canMatch search phase results
 *
        }
        synchronized int getNumPossibleMatches() {  
             * CanMatchPreFilterSearchPhase applies possibleMatches back onto the original
        }  
        BiFunction<String, String, Transport.Connection> nodeIdToConnection,  
        Function<GroupShardsIterator<SearchShardIterator>, SearchPhase> phaseFactory,  
        for (int i = 0; i < shardsIts.size(); i++) {
            timeProvider,  
 */
    ) {
    ) {
            if (shardsIts.get(i).skip() == false) {  
import org.opensearch.search.sort.MinAndMax;
            }
        return comparator.thenComparing(index -> shardsIts.get(index).shardId());  
                        + activeShardIndex
                shardIndexes[activeShardCount++] = i;
        Map<String, Float> concreteIndexBoosts,  
            listener
import java.util.stream.IntStream;
import org.opensearch.search.internal.AliasFilter;  
            }
                numPossibleMatches++;
        int cardinality = results.getNumPossibleMatches();
                // we don't support sort values that mix different types (e.g.: long/double, numeric/keyword).  
        Logger logger,
            if (activeShardIndex < 0 || activeShardIndex >= activeShardIndexToOriginalShardIndex.length) {
                        + ")"
 * ownership. Elasticsearch licenses this file to you under  
        GroupShardsIterator<SearchShardIterator> shardsIts  
             * GroupShardsIterator so skipped shard groups remain in their original positions  
        SearchTask task,
        MinAndMax<?>[] minAndMaxes,
            listener,
            return activeShardIndexToOriginalShardIndex[activeShardIndex];
                consumeResult(originalShardIndex(result.getShardIndex()), result.canMatch(), result.estimatedMinAndMax());
        int[] shardIndexes = new int[shardsIts.size()];  
        );
    private final GroupShardsIterator<SearchShardIterator> shardsIts;
            if (results.hasActiveShards()) {
                );  
 * from the search. The extra round trip to the search shards is very cheap and is not subject to rejections
import java.util.stream.Stream;
            logger,
 * KIND, either express or implied.  See the License for the
        ClusterState clusterState,
    }
             *
        GroupShardsIterator<SearchShardIterator> shardsIts,
    }  
        private final FixedBitSet possibleMatches;  
 * the Apache License, Version 2.0 (the "License"); you may
            // to produce a valid search result with all the aggs etc.  
            SearchPhaseName.CAN_MATCH.getName(),
        private final int[] activeShardIndexToOriginalShardIndex;
            return activeShardIndexToOriginalShardIndex.length > 0;
            .map(shardsIts::get)
 * data are executed first when sorting by descending timestamp.
            consumeResult(originalShardIndex(shardIndex), true, null);
            getConnection(shard.getClusterAlias(), shard.getNodeId()),
        for (SearchShardIterator iter : shardsIts) {
        SearchRequestContext searchRequestContext,
        return IntStream.range(0, shardsIts.size())
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
    }
            searchRequestContext,
        }
        }
        BiFunction<String, String, Transport.Connection> nodeIdToConnection,
    private static boolean shouldSortShards(MinAndMax<?>[] minAndMaxes) {  
    }  
        boolean hasResult(int shardIndex) {  
        Map<String, Float> concreteIndexBoosts,
        Tracer tracer  
    private GroupShardsIterator<SearchShardIterator> getIterator(
    CanMatchPreFilterSearchPhase(
        MinAndMax<?>[] minAndMaxes,
            concreteIndexBoosts,
/**
}
        SearchSourceBuilder source = getRequest().source();
            nodeIdToConnection,
            aliasFilter,  
            searchTransportService,  
        void consumeResult(CanMatchResponse result, Runnable next) {  
        }
    private static List<SearchShardIterator> sortShards(  
            indexRoutings,
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
import org.opensearch.search.builder.SearchSourceBuilder;
        final Comparator<Integer> comparator = Comparator.comparing(index -> minAndMaxes[index], MinAndMax.getComparator(order));
            concreteIndexBoosts,  
            return firstActiveShardIndex;  
            clusterState,  
        SearchRequestContext searchRequestContext,
 * compatible open source license.
import java.util.Arrays;
        SortOrder order  
            listener,
        private final int firstActiveShardIndex;  
        }
            .boxed()  
    private static Comparator<Integer> shardComparator(  
                iter.resetAndSkip();
import java.util.Set;
import java.util.function.BiFunction;
import org.opensearch.search.sort.FieldSortBuilder;
        return new GroupShardsIterator<>(sortShards(shardsIts, results.minAndMaxes, fieldSort.order()));  
        SearchTask task,
 *
            this.activeShardIndexToOriginalShardIndex = activeShardIndexToOriginalShardIndex;
    /**  
            minAndMaxes[shardIndex] = minAndMax;  
        int getFirstActiveShardIndex() {
             * for accounting and downstream phases.
            try {
        @Override
        }  
    private final Function<GroupShardsIterator<SearchShardIterator>, SearchPhase> phaseFactory;
 * This search phase can be used as an initial search phase to pre-filter search shards based on query rewriting.
            shardsIts,  
        }  
             * compacts the shard indexes observed by can_match responses: response index 0
             * group indexes.
            new CanMatchSearchPhaseResults(shardsIts.size(), activeShardIndexLookup),  
        super(  
        }
            } else {
        ActionListener<SearchResponse> listener,
        throw new RuntimeException("cannot add releasable in " + getName() + " phase");  
        }
    }
        ActionListener<SearchResponse> listener,  
            }
        Class<?> clazz = null;
    }
            request,
    }
 * specific language governing permissions and limitations
            // we have to carry over shard failures in order to account for them in the response.  
        );
import java.util.Comparator;
 * The OpenSearch Contributors require contributions made to  
        Executor executor,
        this.phaseFactory = phaseFactory;  
 * GitHub history for details.
            // this is a special case where we have no hit but we need to get at least one search response in order
        SearchRequest request,
            super(originalShardCount);
             * refers to the first active shard, not necessarily shardsIts.get(0).  
import java.util.concurrent.Executor;  
                return false;  
        ClusterState clusterState,
        }  
                    "invalid can_match shard index ["
                        + "] for active shard index range [0, "  
    @Override
 * When the query primary sort is perform on a field, this phase extracts the min/max value in each shard and
            timeProvider,
        // Use the active shard count so can_match is effectively unthrottled without over-sizing the concurrency budget.
        this(
/*  
 * under the License.  
        SearchTransportService searchTransportService,
import java.util.function.Function;
            if (canMatch) {
        TransportSearchAction.SearchTimeProvider timeProvider,  
 *  
            clusters,
        SearchShardTarget shard,  
            }  
            .sorted(shardComparator(shardsIts, minAndMaxes, order))
        for (MinAndMax<?> minAndMax : minAndMaxes) {
        SearchActionListener<CanMatchResponse> listener
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            buildActiveShardIndexLookup(shardsIts),
        int[] activeShardIndexLookup,
            activeShardIndexLookup.length,
import org.opensearch.common.lease.Releasable;
 * large portion of the clusters indices.  
        CanMatchSearchPhaseResults results,
 * license agreements. See the NOTICE file distributed with
 * which allows to fan out to more shards at the same time without running into rejections even if we are hitting a
    @Override  
        Function<GroupShardsIterator<SearchShardIterator>, SearchPhase> phaseFactory,  
    ) {
                throw new IllegalStateException(  
            return Stream.empty();
import org.opensearch.transport.Transport;
    protected void executePhaseOnShard(
        boolean hasActiveShards() {  
        SearchShardIterator shardIt,
             * This lookup translates compacted active shard indexes back to original shard  
        return Arrays.copyOf(shardIndexes, activeShardCount);
            clusters,  
        Map<String, AliasFilter> aliasFilter,
        Executor executor,
            executor,  
            nodeIdToConnection,
            return shardsIts;  
        Map<String, Set<String>> indexRoutings,
        synchronized void consumeResult(int shardIndex, boolean canMatch, MinAndMax<?> minAndMax) {
/*
            } else if (minAndMax != null && clazz != minAndMax.getMin().getClass()) {
        private final MinAndMax<?>[] minAndMaxes;
 * The queries are rewritten against the shards and based on the rewrite result shards might be able to be excluded  
 */
            possibleMatches = new FixedBitSet(originalShardCount);
            indexRoutings,
    }
import org.opensearch.core.action.ActionListener;
                possibleMatches.set(results.getFirstActiveShardIndex());
            }
        GroupShardsIterator<SearchShardIterator> shardsIts,
    private static int[] buildActiveShardIndexLookup(GroupShardsIterator<SearchShardIterator> shardsIts) {
            return numPossibleMatches;
import org.apache.logging.log4j.Logger;  
import org.opensearch.search.SearchShardTarget;
             * AbstractSearchAsyncAction executes only non-skipped shard iterators. This
            if (possibleMatches.get(i++)) {
            }
import java.util.stream.Collectors;  
        Stream<CanMatchResponse> getSuccessfulResults() {  
        @Override
             */
 */  
/*
        GroupShardsIterator<SearchShardIterator> shardsIts,
        Logger logger,
            if (clazz == null) {  
        getSearchTransport().sendCanMatch(  
            clusterState,
    }
            /*  
            logger,  
            searchRequestContext,  
                clazz = minAndMax == null ? null : minAndMax.getMin().getClass();
            firstActiveShardIndex = activeShardIndexToOriginalShardIndex.length == 0 ? 0 : activeShardIndexToOriginalShardIndex[0];
                possibleMatches.set(shardIndex);  
            phaseFactory,
    }
     */
                        + activeShardIndexToOriginalShardIndex.length
    ) {
 * This phase can also be used to pre-sort shards based on min/max values in each shard of the provided primary sort.
    ) {
    protected SearchPhase getNextPhase(SearchPhaseResults<CanMatchResponse> results, SearchPhaseContext context) {  
final class CanMatchPreFilterSearchPhase extends AbstractSearchAsyncAction<CanMatchResponse> {
            getTask(),  
            tracer
        SearchRequest request,  
import java.util.Map;
import org.opensearch.search.SearchService.CanMatchResponse;  
    private CanMatchPreFilterSearchPhase(  
                next.run();
        }
                // TODO: we could fail the request because there is a high probability
        return phaseFactory.apply(getIterator((CanMatchSearchPhaseResults) results, shardsIts));
import org.opensearch.search.sort.SortOrder;  
        void consumeShardFailure(int shardIndex) {
     *
        SearchResponse.Clusters clusters,
        int i = 0;  
import org.apache.lucene.util.FixedBitSet;
 * SPDX-License-Identifier: Apache-2.0
        @Override
        CanMatchSearchPhaseResults(int originalShardCount, int[] activeShardIndexToOriginalShardIndex) {  
        synchronized FixedBitSet getPossibleMatches() {
        private int originalShardIndex(int activeShardIndex) {
            searchTransportService,
    public void addReleasable(Releasable releasable) {
    }  
            return possibleMatches;
            } finally {  
            return false; // unneeded
            buildShardSearchRequest(shardIt),
 */
        SearchResponse.Clusters clusters,
        }
 * sort them according to the provided order. This can be useful for instance to ensure that shards that contain recent  
        FieldSortBuilder fieldSort = FieldSortBuilder.getPrimaryFieldSortOrNull(source);
import org.opensearch.cluster.ClusterState;
             *
 * Modifications Copyright OpenSearch Contributors. See  
    ) {
        int activeShardCount = 0;
            }  
        }
        Map<String, Set<String>> indexRoutings,  
import org.opensearch.cluster.routing.GroupShardsIterator;  
                iter.reset();  
        );  
 *
            tracer
    @Override
            request,  
        SortOrder order  
 * @opensearch.internal  
            task,
        if (cardinality == 0) {
            minAndMaxes = new MinAndMax[originalShardCount];  
            task,
        }
        private int numPossibleMatches;
        GroupShardsIterator<SearchShardIterator> shardsIts,
            executor,
