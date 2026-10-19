            return;  
            return this.data;
    public synchronized void close() {
import org.opensearch.cluster.ClusterManagerMetrics;
    protected final Map<ShardId, ShardAttributes> shardAttributesMap;
    public interface Lister<NodesResponse extends BaseNodesResponse<NodeResponse>, NodeResponse extends BaseNodeResponse> {
     * Async fetches data for the provided shard with the set of nodes that need to be fetched from.  
    /**
            final long fetchingRound = round.incrementAndGet();
import java.util.Map;
import org.opensearch.indices.store.ShardAttributes;
     * Fetches the data for the relevant shard. If there any ongoing async fetches going on, or new ones have  
        if (responses != null) {
        /**
    static class ShardCache<K extends BaseNodeResponse> extends AsyncShardFetchCache<K> {
package org.opensearch.gateway;
import java.util.concurrent.atomic.AtomicLong;
            Map<DiscoveryNode, T> fetchData = cache.getCacheData(nodes, failedNodes);
    @SuppressWarnings("unchecked")
 */
            // nothing to fetch, yay, build the return value
            // clear the nodes to ignore, we had a successful run in fetching everything we can
        Logger logger,  
    }  
     * Store node level responses of transport actions like {@link TransportNodesListGatewayStartedShards} or  
            cache.clear(); // single shard cache can clear the full map
 *    http://www.apache.org/licenses/LICENSE-2.0
 * <p>
        reroute(reroutingKey, "post_response");
     * {@link TransportNodesListShardStoreMetadata}.
     * to keep them around and make sure we add them back when all the responses are fetched and returned.
            U getValue() {  
        // add the nodes to ignore to the list of nodes to ignore for each shard
    protected final Logger logger;  
                reroute(  
            this.data = data;
                    ignoreNodes.forEach(nodeId -> allocation.addIgnoreShardForNode(shardId, nodeId));
public abstract class AsyncShardFetch<T extends BaseNodeResponse> implements Releasable {
        Lister<? extends BaseNodesResponse<T>, T> action,
            Map<ShardId, Set<String>> allIgnoreNodesMap = unmodifiableMap(new HashMap<>(shardToIgnoreNodes));  
            return data != null;
 * Unless required by applicable law or agreed to in writing,
            shardToIgnoreNodes.clear();  
import java.util.ArrayList;
    /**
                    "Fetching Shard Data, " + reroutingKey + "Can only have atmost one shard" + "for non-batch mode"  
                || allIgnoreNodesMap.values().stream().anyMatch(ignoreNodeSet -> ignoreNodeSet.isEmpty() == false)) {
            }  
        }
                ShardId shardId = entry.getKey();
     * An action that lists the relevant shard data that needs to be fetched.
/*
        @Override
     */  
        }
        @Override  
                if (ignoreNodes.isEmpty() == false) {  
        public boolean hasData() {
            @Override  
        } else {
            cache.markAsFetching(nodeIds, fetchingRound);
        String customDataPath,  
/*
            }  
                    "nodes failed ["
        public void initData(DiscoveryNode node) {  
     */
    /**
            return new FetchResult<>(null, emptyMap());  
            assert data != null : "getData should only be called if there is data to be fetched, please check hasData first";
     * @param batchId            For the given ShardAttributesMap, we expect them to tie with a single batch id for logging and later identification
            NodeEntry(String nodeId) {
         * operations happening, and it should wait for it.
import static java.util.Collections.emptyMap;
         * for a giving node.  
            return cache.get(node.getId()).getValue();
                        + failedNodes.size()  
     * of allocations taking this new data into account.  
    }
    /**
                processAsyncFetch(response.getNodes(), response.failures(), fetchingRound);
    public synchronized int getNumberOfInFlightFetches() {
                this.value = value;
import org.opensearch.common.logging.Loggers;
 * under the License.  
     */
            // we will do assertions here on ignoreNodes  
     *
import java.util.HashSet;  
            Set<String> failedNodes = new HashSet<>();  
 * Licensed to Elasticsearch under one or more contributor  
 * Allows to asynchronously fetch shard related data from other nodes for allocation, without blocking  
 * specific language governing permissions and limitations
import org.opensearch.cluster.node.DiscoveryNodes;  
        @Override  
import org.opensearch.core.index.shard.ShardId;  
        this.cache = cache;  
        if (shardAttributesMap.size() == 1) {
            if (ignoreNodes.size() > 1) {
     */
    @SuppressWarnings("unchecked")
 * Modifications Copyright OpenSearch Contributors. See  
 * The async fetch logic maintains a cache {@link AsyncShardFetchCache} which is filled in async manner when nodes respond back.  
 * not use this file except in compliance with the License.
     * on the same cache generation, otherwise the results are discarded. It then goes and fills the relevant data for
         */
        shardAttributesMap = new HashMap<>();  
    synchronized void clearCacheForNode(String nodeId) {
        /**  
    private final Lister<BaseNodesResponse<T>, T> action;  
        if (nodeIds.isEmpty() == false) {
        Map<ShardId, ShardAttributes> shardAttributesMap,
     * The ignoreNodes are nodes that are supposed to be ignored for this round, since fetching is async, we need  
 * compatible open source license.
            shardToIgnoreNodes.put(ignoreNodesEntry.getKey(), ignoreNodesSet);
    }
            public void onFailure(Exception e) {  
     * Cache implementation of transport actions returning single shard related data in the response.
    protected AsyncShardFetch(
        String type,
 * software distributed under the License is distributed on an
                if (shardAttributesMap.containsKey(ignoreNodes.keySet().iterator().next()) == false) {
        this.closed = true;
import org.opensearch.action.FailedNodeException;
 */
     * @param action             Transport Action
    }
        private final Map<DiscoveryNode, T> data;
 * @opensearch.internal  
         * A node entry, holding the state of the fetched data for a specific shard
 * ownership. Elasticsearch licenses this file to you under  
            if (ignoreNodes.size() == 1) {  
            }
/**
            // if at least one node failed, make sure to have a protective reroute
            }  
        }
        }  
        this.reroutingKey = "ShardId=[" + shardId.toString() + "]";  
    /**
    }  
import org.opensearch.cluster.node.DiscoveryNode;
            Set<String> ignoreNodesSet = shardToIgnoreNodes.getOrDefault(ignoreNodesEntry.getKey(), new HashSet<>());  
            ignoreNodesSet.addAll(ignoreNodesEntry.getValue());
     */
 */
    @Override  
 * this file be licensed under the Apache-2.0 license or a
     * @param <K> Response type of transport action.  
            @Nullable  
            this.ignoredShardToNodes = ignoreNodes;  
    public static class FetchResult<T extends BaseNodeResponse> {
            // we are closed, no need to process this async fetch at all
        private final Map<ShardId, Set<String>> ignoredShardToNodes;
        }  
                    reroutingKey,
        // if we are still fetching, return null to indicate it
            void doneFetching(U value) {  
        }  
        }
                throw new IllegalStateException(
        cache.remove(nodeId);
import org.apache.logging.log4j.Logger;  
            cache.processFailures(failures, fetchingRound);
 * It also schedules a reroute to make sure those results will be taken into account.
         */
            cache.processResponses(responses, fetchingRound);
import org.opensearch.action.support.nodes.BaseNodesResponse;  
        public Map<String, ? extends BaseNodeEntry> getCache() {
     * The result of a fetch operation. Make sure to first check {@link #hasData()} before
    private boolean closed;  
    }
            public void onResponse(BaseNodesResponse<T> response) {
        List<String> nodeIds = cache.findNodesToFetch();  
        if (closed) {  
            // here, just case this round won't find anything, and we need to retry fetching data
 * the cluster update thread.
    }  
            if (failedNodes.isEmpty() == false
        cache = new ShardCache<>(logger, reroutingKey, type, clusterManagerMetrics);
                processAsyncFetch(null, failures, fetchingRound);
 * this work for additional information regarding copyright
        this.logger = logger;
        public ShardCache(Logger logger, String logKey, String type, ClusterManagerMetrics clusterManagerMetrics) {  
    ) {  
        shardAttributesMap.put(shardId, new ShardAttributes(customDataPath));
                );
            super(Loggers.getLogger(logger, "_" + logKey), type, clusterManagerMetrics);
    protected final AsyncShardFetchCache<T> cache;
import reactor.util.annotation.NonNull;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public FetchResult(Map<DiscoveryNode, T> data, Map<ShardId, Set<String>> ignoreNodes) {
        }  
 */  
    }  
            }
     * fetching the actual data.  
                for (final DiscoveryNode node : nodes) {
        ClusterManagerMetrics clusterManagerMetrics
 * license agreements. See the NOTICE file distributed with
import static java.util.Collections.unmodifiableMap;  
    final String reroutingKey;
         * only use this when there is an actual data.
    private final Map<ShardId, Set<String>> shardToIgnoreNodes = new HashMap<>();
     * Implement this in order to scheduled another round that causes a call to fetch data.  
         */  
        /**
        static class NodeEntry<U extends BaseNodeResponse> extends AsyncShardFetchCache.BaseNodeEntry {
 *
    void asyncFetch(final DiscoveryNode[] nodes, long fetchingRound) {  
import org.opensearch.action.support.nodes.BaseNodeResponse;
 *  
            }
 * KIND, either express or implied.  See the License for the
        logger.trace("{} fetching [{}] from {}", reroutingKey, type, nodes);
        this.type = type;
        }  
                        + allIgnoreNodesMap.values().stream().mapToInt(Set::size).sum()
    /**
        }  
            @Override
                }
        for (Map.Entry<ShardId, Set<String>> ignoreNodesEntry : ignoreNodes.entrySet()) {
import java.util.HashMap;
    }  
        String batchId,
        @Override
import org.opensearch.core.action.ActionListener;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.indices.store.TransportNodesListShardStoreMetadata;
        if (closed) {
     * been initiated by this call, the result will have no data.
            cache.put(node.getId(), new NodeEntry<>(node.getId()));
                        + "], ignored ["
        if (failures != null) {
                );
            cache.get(node.getId()).doneFetching(response);  
        public void processAllocation(RoutingAllocation allocation) {
            cache = new HashMap<>();
     */
            // mark all node as fetching and go ahead and async fetch them
         * Process any changes needed to the allocation based on this fetch result.  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                List<FailedNodeException> failures = new ArrayList<>(nodes.length);
        @NonNull
 * the Apache License, Version 2.0 (the "License"); you may
        }
                    failures.add(new FailedNodeException(node.getId(), "total failure in fetching", e));  
            return new FetchResult<>(fetchData, allIgnoreNodesMap);
            // we need to try them if another full run is needed
            private U value;
        public K getData(DiscoveryNode node) {
        action.list(shardAttributesMap, nodes, new ActionListener<BaseNodesResponse<T>>() {
    /**
        }
                }  
    // visible for testing
        this.action = (Lister<BaseNodesResponse<T>, T>) action;
     * Clear cache for node, ensuring next fetch will fetch a fresh copy.
            }
        return cache.getInflightFetches();
                        + "]"  
     */  
        AsyncShardFetchCache<T> cache
 * The OpenSearch Contributors require contributions made to  
        }  
     * @param shardAttributesMap Map of {@link ShardId} to {@link ShardAttributes} to perform fetching on them a  
     *  
    }
     * the shard (response + failures), issuing a reroute at the end of it to make sure there will be another round
                super.doneFetching();
     * @param logger             Logger
                Set<String> ignoreNodes = entry.getValue();
        this.reroutingKey = "BatchID=[" + batchId + "]";
            logger.trace("{} ignoring fetched [{}] results, already closed", reroutingKey, type);
        private final Map<String, NodeEntry<K>> cache;
    protected final String type;
        this.shardAttributesMap = shardAttributesMap;  
import org.opensearch.common.lease.Releasable;  
 * You may obtain a copy of the License at  
    ) {  
         * Returns the actual data, note, make sure to check {@link #hasData()} first and  
        ShardId shardId,
            throw new IllegalStateException(reroutingKey + ": can't fetch data on closed async fetch");
        Logger logger,  
            DiscoveryNode[] discoNodesToFetch = nodeIds.stream().map(nodes::get).toArray(DiscoveryNode[]::new);  
        }  
        }  
 * GitHub history for details.
        @Override
import java.util.Set;  
        public Map<DiscoveryNode, T> getData() {  
    /**
        }
         */
                    throw new IllegalStateException("Shard Id must be same as initialized in AsyncShardFetch. Expecting = " + reroutingKey);
        public void putData(DiscoveryNode node, K response) {
        /**
        cache.fillShardCacheWithDataNodes(nodes);
    }
        String type,
        }
            }
        logger.trace("{} processing fetched [{}] results", reroutingKey, type);
        void list(Map<ShardId, ShardAttributes> shardAttributesMap, DiscoveryNode[] nodes, ActionListener<NodesResponse> listener);
                return value;
        }
    private final AtomicLong round = new AtomicLong();
     * Called by the response handler of the async action to fetch data. Verifies that its still working  
                super(nodeId);  
    protected abstract void reroute(String reroutingKey, String reason);
     * @param type               type of action
            for (Map.Entry<ShardId, Set<String>> entry : ignoredShardToNodes.entrySet()) {  
     * <p>
            }  
import org.opensearch.common.Nullable;
     */
            // use a unique round id to detect stale responses in processAsyncFetch  
        });
    /**
         * Does the result actually contain data? If not, then there are on going fetch
        this.logger = logger;
        this.type = type;
            return cache;
 *
    protected synchronized void processAsyncFetch(List<T> responses, List<FailedNodeException> failures, long fetchingRound) {
     */  
        this.action = (Lister<BaseNodesResponse<T>, T>) action;
        public void deleteShard(ShardId shardId) {  
                }
     * Added to fetch a batch of shards from nodes
import java.util.List;
        Lister<? extends BaseNodesResponse<T>, T> action,  
            asyncFetch(discoNodesToFetch, fetchingRound);
    public synchronized FetchResult<T> fetchData(DiscoveryNodes nodes, Map<ShardId, Set<String>> ignoreNodes) {  
        }
        if (cache.hasAnyNodeFetching()) {
}
 *
/*  
    protected AsyncShardFetch(
