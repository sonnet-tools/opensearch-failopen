import org.opensearch.cluster.ClusterManagerMetrics;
/*
    private final AtomicLong round = new AtomicLong();
            }
     */
import java.util.concurrent.atomic.AtomicLong;
 */
        @NonNull
import org.opensearch.common.Nullable;
        @Override
/**
     * of allocations taking this new data into account.
        @Override
        }
            cache = new HashMap<>();
     */
                }
        this.action = (Lister<BaseNodesResponse<T>, T>) action;
        this.shardAttributesMap = shardAttributesMap;
            final long fetchingRound = round.incrementAndGet();
            }
        }
     * @param type               type of action
            // we need to try them if another full run is needed
            // clear the nodes to ignore, we had a successful run in fetching everything we can
 * GitHub history for details.
            return data != null;
 * It also schedules a reroute to make sure those results will be taken into account.
    }
            return new FetchResult<>(null, emptyMap());
            }
         */
                processAsyncFetch(response.getNodes(), response.failures(), fetchingRound);
     * An action that lists the relevant shard data that needs to be fetched.
package org.opensearch.gateway;
        }
            }
     */
        ClusterManagerMetrics clusterManagerMetrics
        // add the nodes to ignore to the list of nodes to ignore for each shard
                        + allIgnoreNodesMap.values().stream().mapToInt(Set::size).sum()
            Set<String> failedNodes = new HashSet<>();
                    failures.add(new FailedNodeException(node.getId(), "total failure in fetching", e));
        });
        }
            throw new IllegalStateException(reroutingKey + ": can't fetch data on closed async fetch");
 * under the License.
import java.util.ArrayList;
 * compatible open source license.
    /**
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
    public synchronized FetchResult<T> fetchData(DiscoveryNodes nodes, Map<ShardId, Set<String>> ignoreNodes) {
 * this work for additional information regarding copyright
        /**
            cache.clear(); // single shard cache can clear the full map
                    reroutingKey,
import java.util.Set;
 * the cluster update thread.
import org.opensearch.indices.store.ShardAttributes;
        void list(Map<ShardId, ShardAttributes> shardAttributesMap, DiscoveryNode[] nodes, ActionListener<NodesResponse> listener);
            return cache.get(node.getId()).getValue();
            // use a unique round id to detect stale responses in processAsyncFetch
 * this file be licensed under the Apache-2.0 license or a
            super(Loggers.getLogger(logger, "_" + logKey), type, clusterManagerMetrics);
 * SPDX-License-Identifier: Apache-2.0
        this.type = type;
        if (closed) {
        public void initData(DiscoveryNode node) {
        reroute(reroutingKey, "post_response");
                || allIgnoreNodesMap.values().stream().anyMatch(ignoreNodeSet -> ignoreNodeSet.isEmpty() == false)) {
            for (Map.Entry<ShardId, Set<String>> entry : ignoredShardToNodes.entrySet()) {
                reroute(
         * A node entry, holding the state of the fetched data for a specific shard
         * operations happening, and it should wait for it.
            assert data != null : "getData should only be called if there is data to be fetched, please check hasData first";
        }
        if (nodeIds.isEmpty() == false) {
 * Licensed to Elasticsearch under one or more contributor
    void asyncFetch(final DiscoveryNode[] nodes, long fetchingRound) {
        public ShardCache(Logger logger, String logKey, String type, ClusterManagerMetrics clusterManagerMetrics) {
            if (ignoreNodes.size() == 1) {
                throw new IllegalStateException(
        for (Map.Entry<ShardId, Set<String>> ignoreNodesEntry : ignoreNodes.entrySet()) {
    protected AsyncShardFetch(
            }
                        + "], ignored ["
 * ownership. Elasticsearch licenses this file to you under
        }
    protected final AsyncShardFetchCache<T> cache;
        cache.remove(nodeId);
            }
        }
     * @param <K> Response type of transport action.
         * for a giving node.
            logger.trace("{} ignoring fetched [{}] results, already closed", reroutingKey, type);
         * only use this when there is an actual data.
    /**
        cache = new ShardCache<>(logger, reroutingKey, type, clusterManagerMetrics);
        private final Map<ShardId, Set<String>> ignoredShardToNodes;
        }
        }
            U getValue() {
            shardToIgnoreNodes.clear();
     * been initiated by this call, the result will have no data.
        String type,
            return new FetchResult<>(fetchData, allIgnoreNodesMap);
            DiscoveryNode[] discoNodesToFetch = nodeIds.stream().map(nodes::get).toArray(DiscoveryNode[]::new);
            this.data = data;
        // if we are still fetching, return null to indicate it
    static class ShardCache<K extends BaseNodeResponse> extends AsyncShardFetchCache<K> {
        String batchId,
                this.value = value;
    synchronized void clearCacheForNode(String nodeId) {
        this.closed = true;
            return this.data;
        }
            if (failedNodes.isEmpty() == false
                super(nodeId);
     * Store node level responses of transport actions like {@link TransportNodesListGatewayStartedShards} or
import org.opensearch.indices.store.TransportNodesListShardStoreMetadata;
 */
            shardToIgnoreNodes.put(ignoreNodesEntry.getKey(), ignoreNodesSet);
                        + failedNodes.size()
import static java.util.Collections.emptyMap;
        /**
        /**
        Map<ShardId, ShardAttributes> shardAttributesMap,
    /**
        shardAttributesMap = new HashMap<>();
                    throw new IllegalStateException("Shard Id must be same as initialized in AsyncShardFetch. Expecting = " + reroutingKey);
 * @opensearch.internal
        Logger logger,
        ShardId shardId,
        }
import org.opensearch.cluster.node.DiscoveryNode;
/*
    }
     */
         */
                if (ignoreNodes.isEmpty() == false) {
import org.apache.logging.log4j.Logger;
/*
 * Modifications Copyright OpenSearch Contributors. See
    }
     *
        @Override
     * Clear cache for node, ensuring next fetch will fetch a fresh copy.
        public K getData(DiscoveryNode node) {
import org.opensearch.core.action.ActionListener;
        AsyncShardFetchCache<T> cache
 */
    protected synchronized void processAsyncFetch(List<T> responses, List<FailedNodeException> failures, long fetchingRound) {
                    "nodes failed ["
import org.opensearch.action.support.nodes.BaseNodesResponse;
    ) {
    // visible for testing
            // here, just case this round won't find anything, and we need to retry fetching data
            return;
    /**
     * @param action             Transport Action
        if (failures != null) {
        }
        }
        private final Map<DiscoveryNode, T> data;
import org.opensearch.common.lease.Releasable;
        shardAttributesMap.put(shardId, new ShardAttributes(customDataPath));
            @Override
            cache.get(node.getId()).doneFetching(response);
            NodeEntry(String nodeId) {
                );
     * <p>
        this.type = type;
            }
    private boolean closed;
        public void putData(DiscoveryNode node, K response) {
            if (ignoreNodes.size() > 1) {
     * Fetches the data for the relevant shard. If there any ongoing async fetches going on, or new ones have
        public FetchResult(Map<DiscoveryNode, T> data, Map<ShardId, Set<String>> ignoreNodes) {
 * The OpenSearch Contributors require contributions made to
     */
     * @param batchId            For the given ShardAttributesMap, we expect them to tie with a single batch id for logging and later identification
     * on the same cache generation, otherwise the results are discarded. It then goes and fills the relevant data for
        String customDataPath,
        }
    }
            asyncFetch(discoNodesToFetch, fetchingRound);
    final String reroutingKey;
import java.util.HashMap;
                processAsyncFetch(null, failures, fetchingRound);
            public void onResponse(BaseNodesResponse<T> response) {
            Map<DiscoveryNode, T> fetchData = cache.getCacheData(nodes, failedNodes);
        this.reroutingKey = "ShardId=[" + shardId.toString() + "]";
    /**
            void doneFetching(U value) {
            private U value;
     * the shard (response + failures), issuing a reroute at the end of it to make sure there will be another round
            @Nullable
        List<String> nodeIds = cache.findNodesToFetch();
     * Called by the response handler of the async action to fetch data. Verifies that its still working
                }
        }
 * license agreements. See the NOTICE file distributed with
                    "Fetching Shard Data, " + reroutingKey + "Can only have atmost one shard" + "for non-batch mode"
        logger.trace("{} fetching [{}] from {}", reroutingKey, type, nodes);
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.logger = logger;
            cache.put(node.getId(), new NodeEntry<>(node.getId()));
    protected final Map<ShardId, ShardAttributes> shardAttributesMap;
        static class NodeEntry<U extends BaseNodeResponse> extends AsyncShardFetchCache.BaseNodeEntry {
        public void deleteShard(ShardId shardId) {
import java.util.Map;
        if (cache.hasAnyNodeFetching()) {
        return cache.getInflightFetches();
            Set<String> ignoreNodesSet = shardToIgnoreNodes.getOrDefault(ignoreNodesEntry.getKey(), new HashSet<>());
         */
import reactor.util.annotation.NonNull;
        if (responses != null) {
    public static class FetchResult<T extends BaseNodeResponse> {
         * Does the result actually contain data? If not, then there are on going fetch
    }
     */
            cache.processResponses(responses, fetchingRound);
                }
            // mark all node as fetching and go ahead and async fetch them
    }
import org.opensearch.cluster.node.DiscoveryNodes;
     * @param logger             Logger
        this.cache = cache;
        Lister<? extends BaseNodesResponse<T>, T> action,
        logger.trace("{} processing fetched [{}] results", reroutingKey, type);
     * The result of a fetch operation. Make sure to first check {@link #hasData()} before
    protected final Logger logger;
                Set<String> ignoreNodes = entry.getValue();
                        + "]"
    }
        public Map<DiscoveryNode, T> getData() {
            }
    private final Map<ShardId, Set<String>> shardToIgnoreNodes = new HashMap<>();
        this.logger = logger;
    public interface Lister<NodesResponse extends BaseNodesResponse<NodeResponse>, NodeResponse extends BaseNodeResponse> {
        public void processAllocation(RoutingAllocation allocation) {
    protected AsyncShardFetch(
    }
     *
            // we will do assertions here on ignoreNodes
            // if at least one node failed, make sure to have a protective reroute
            Map<ShardId, Set<String>> allIgnoreNodesMap = unmodifiableMap(new HashMap<>(shardToIgnoreNodes));
    }
        this.reroutingKey = "BatchID=[" + batchId + "]";
                if (shardAttributesMap.containsKey(ignoreNodes.keySet().iterator().next()) == false) {
    public synchronized void close() {
        public Map<String, ? extends BaseNodeEntry> getCache() {
            this.ignoredShardToNodes = ignoreNodes;
 * You may obtain a copy of the License at
    /**
        }
import java.util.HashSet;
        private final Map<String, NodeEntry<K>> cache;
 */
import org.opensearch.core.index.shard.ShardId;
                return value;
     * Implement this in order to scheduled another round that causes a call to fetch data.
        public boolean hasData() {
            // nothing to fetch, yay, build the return value
import org.opensearch.common.logging.Loggers;
        Lister<? extends BaseNodesResponse<T>, T> action,
        } else {
    private final Lister<BaseNodesResponse<T>, T> action;
        if (shardAttributesMap.size() == 1) {
        }
            }
                for (final DiscoveryNode node : nodes) {
    protected abstract void reroute(String reroutingKey, String reason);
                );
            // we are closed, no need to process this async fetch at all
 * The async fetch logic maintains a cache {@link AsyncShardFetchCache} which is filled in async manner when nodes respond back.
                ShardId shardId = entry.getKey();
    protected final String type;
         * Process any changes needed to the allocation based on this fetch result.
 * software distributed under the License is distributed on an
    @SuppressWarnings("unchecked")
                    ignoreNodes.forEach(nodeId -> allocation.addIgnoreShardForNode(shardId, nodeId));
        action.list(shardAttributesMap, nodes, new ActionListener<BaseNodesResponse<T>>() {
     * The ignoreNodes are nodes that are supposed to be ignored for this round, since fetching is async, we need
import org.opensearch.action.FailedNodeException;
     * fetching the actual data.
        if (closed) {
import static java.util.Collections.unmodifiableMap;
            ignoreNodesSet.addAll(ignoreNodesEntry.getValue());
 * <p>
 *
            public void onFailure(Exception e) {
                List<FailedNodeException> failures = new ArrayList<>(nodes.length);
     * Added to fetch a batch of shards from nodes
    ) {
    @SuppressWarnings("unchecked")
}
 * KIND, either express or implied.  See the License for the
        @Override
            return cache;
 *
    /**
     * to keep them around and make sure we add them back when all the responses are fetched and returned.
        cache.fillShardCacheWithDataNodes(nodes);
        this.action = (Lister<BaseNodesResponse<T>, T>) action;
     * Async fetches data for the provided shard with the set of nodes that need to be fetched from.
     */
     */
public abstract class AsyncShardFetch<T extends BaseNodeResponse> implements Releasable {
 * Allows to asynchronously fetch shard related data from other nodes for allocation, without blocking
    public synchronized int getNumberOfInFlightFetches() {
        String type,
 * Unless required by applicable law or agreed to in writing,
     * {@link TransportNodesListShardStoreMetadata}.
        @Override
 * not use this file except in compliance with the License.
            cache.markAsFetching(nodeIds, fetchingRound);
     * @param shardAttributesMap Map of {@link ShardId} to {@link ShardAttributes} to perform fetching on them a
     */
    /**
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        /**
         */
 * specific language governing permissions and limitations
 *
 * the Apache License, Version 2.0 (the "License"); you may
        Logger logger,
import org.opensearch.action.support.nodes.BaseNodeResponse;
            @Override
    }
    }
        }
import java.util.List;
                super.doneFetching();
     * Cache implementation of transport actions returning single shard related data in the response.
            cache.processFailures(failures, fetchingRound);
    @Override
         * Returns the actual data, note, make sure to check {@link #hasData()} first and
