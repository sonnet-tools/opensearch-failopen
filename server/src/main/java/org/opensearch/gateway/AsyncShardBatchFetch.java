     *
        this.shardAttributesMap.remove(shardId);
        Logger logger,
                super(nodeId);
                this.shardData[shardIdIndex] = null;
        }
            this.batchSize = shardAttributesMap.size();
            Class<V> clazz,
            ShardBatchResponseFactory<T, V> responseFactory,
         * Put the response received from data nodes into the cache.
                fillShardData(shardDataFromNode, shardIdKey);
            )
 *
     *
         * @param response shard metadata coming from node.
        private final Map<ShardId, Integer> shardIdToArray;
            logger,
                Integer shardIdIndex = shardIdToArray.remove(shardId);
                return emptyShardResponse;
 * @param <T> Response type of the transport action.
 */
 * @opensearch.internal
                                this.emptyShardResponse[shardIdKey.get(shardId)] = true;
        @Override
    ) {
        return this.cache;
        public Map<String, ? extends BaseNodeEntry> getCache() {
                    shardData.put(shardId, emptyResponse);
 * The OpenSearch Contributors require contributions made to
            if (shardIdToArray.containsKey(shardId)) {
                    }
     * {@link AsyncShardFetch} class which has synchronized blocks present to handle multiple threads.
            String logKey,
            HashMap<ShardId, V> shardData = new HashMap<>();
                        if (shardIdKey.get(shardId) != null) {// the response might be for shard which is no longer present in cache
     * approach. This cache class is not thread safe, all of its methods are being called from
            return cache;
        static class NodeEntry<V> extends BaseNodeEntry {
import java.lang.reflect.Array;
            new ShardBatchCache<>(
        private final Class<V> shardResponseClass;
                        ShardId shardId = shardData.getKey();
 * SPDX-License-Identifier: Apache-2.0
        ShardBatchResponseFactory<T, V> responseFactory,
                    if (shardData.getValue() != null) {
        String type,
                }
        /**
                logger,
        public T getData(DiscoveryNode node) {
            }
import org.opensearch.common.logging.Loggers;
     */
 * Implementation of AsyncShardFetch with batching support. This class is responsible for executing the fetch
            }
     */
 */
                super.doneFetching();
        return this.cache.getCache().isEmpty();
            this.emptyShardResponsePredicate = emptyShardResponsePredicate;
            type,
        public void putData(DiscoveryNode node, T response) {
            cache.put(node.getId(), new NodeEntry<>(node.getId(), shardResponseClass, batchSize, emptyShardResponsePredicate));
     * @param <T> Response type of transport action.
        public ShardBatchCache(
 *
            for (Map.Entry<ShardId, Integer> shardIdEntry : shardIdToArray.entrySet()) {
        private final V emptyResponse;
package org.opensearch.gateway;
         * @param node     node from which we got the response.
            // actually needed in allocation/explain API response. So instead of storing full empty response object
            }
            shardAttributesMap,
            }
        /**
import org.opensearch.action.support.nodes.BaseNodesResponse;
                shardAttributesMap,
                this.emptyShardResponsePredicate = emptyShardResponsePredicate;
                if (emptyResponses[arrIndex]) {
            boolean[] emptyResponses = nodeEntry.getEmptyShardResponse();
         */
                emptyShardResponse[shardIdIndex] = false;
            this.responseFactory = responseFactory;
public abstract class AsyncShardBatchFetch<T extends BaseNodeResponse, V> extends AsyncShardFetch<T> {
                    shardData.put(shardId, nodeShardEntries[arrIndex]);
        @Override
                responseFactory,
        @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.indices.store.ShardAttributes;
        Map<ShardId, ShardAttributes> shardAttributesMap,
 * compatible open source license.
        ClusterManagerMetrics clusterManagerMetrics
        private final Predicate<V> emptyShardResponsePredicate;
                    cache.get(nodeId).clearShard(shardIdIndex);
         * A node entry, holding the state of the fetched data for a specific shard
         *
import org.opensearch.cluster.node.DiscoveryNode;
/**
     * @param <V> Data type of shard level response.
    }
                for (String nodeId : cache.keySet()) {
            nodeEntry.doneFetching(batchResponse, shardIdToArray);
                            }
         * After that complete storing the data at node level and mark fetching as done.
import java.util.function.Predicate;
                type,
            String type,
        ) {
     * Store node level responses of transport actions like {@link TransportNodesListGatewayStartedShardsBatch} or
            this.shardResponseClass = clazz;
                                this.shardData[shardIdKey.get(shardId)] = shardData.getValue();
                emptyShardResponse,
 * part using the base class {@link AsyncShardFetch}. Other functionalities needed for a batch are only written here.
    /**
                } else if (nodeShardEntries[arrIndex] != null) {
            }
        }
                this.shardIdToArray.putIfAbsent(shardId, shardIdIndex++);
    public synchronized void clearShard(ShardId shardId) {
     * @param shardId shardId to be removed from the batch.
import java.util.Map;
                emptyShardResponsePredicate,
        private HashMap<ShardId, V> getBatchData(NodeEntry<V> nodeEntry) {
        this.cache.deleteShard(shardId);
        }
            cache = new HashMap<>();
    static class ShardBatchCache<T extends BaseNodeResponse, V> extends AsyncShardFetchCache<T> {
            Map<ShardId, ShardAttributes> shardAttributesMap,
            Logger logger,
     * assigned or failed.
     * Cache implementation of transport actions returning batch of shards related data in the response.
 * This separation also takes care of the extra generic type V which is only needed for batch
            boolean[] getEmptyShardResponse() {
        private final Logger logger;
            V emptyResponse,
                for (Map.Entry<ShardId, V> shardData : shardDataFromNode.entrySet()) {
import org.opensearch.core.index.shard.ShardId;
                this.emptyShardResponse = new boolean[batchSize];
    @SuppressWarnings("unchecked")
        );
                "BatchID=[" + batchId + "]",
        V emptyShardResponse,
    }
        private void fillShardIdKeys(Set<ShardId> shardIds) {
        public void deleteShard(ShardId shardId) {
         */
            this.emptyResponse = emptyResponse;
import reactor.util.annotation.NonNull;
        String batchId,
                ShardId shardId = shardIdEntry.getKey();
        private final ShardBatchResponseFactory<T, V> responseFactory;
        }
            }
 * transport actions like {@link TransportNodesListGatewayStartedShardsBatch} and
                return this.shardData;
            void doneFetching(Map<ShardId, V> shardDataFromNode, Map<ShardId, Integer> shardIdKey) {
            Predicate<V> emptyShardResponsePredicate,
            // in cache, it's better to just store a boolean and create that object on the fly just before
            ClusterManagerMetrics clusterManagerMetrics
            NodeEntry<V> nodeEntry = cache.get(node.getId());
        }
            }
     * Remove a shard from the cache maintaining a full batch of shards. This is needed to clear the shard once it's
                }
                clazz,
 *
         * for a giving node.
                            if (emptyShardResponsePredicate.test(shardData.getValue())) {
                            } else {
    }
         * Get shard level data from batch, then filter out if any shards received failures.
            private void fillShardData(Map<ShardId, V> shardDataFromNode, Map<ShardId, Integer> shardIdKey) {
        @Override
            void clearShard(Integer shardIdIndex) {
            // decision-making.
/*
        Predicate<V> emptyShardResponsePredicate,
    }
import org.apache.logging.log4j.Logger;
                this.shardData = (V[]) Array.newInstance(clazz, batchSize);
                    // ignore null responses here
import java.util.HashMap;
        }
                clusterManagerMetrics
        }
                }
import org.opensearch.cluster.ClusterManagerMetrics;
import org.opensearch.action.support.nodes.BaseNodeResponse;
            NodeEntry(String nodeId, Class<V> clazz, int batchSize, Predicate<V> emptyShardResponsePredicate) {
     * {@link org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch} with memory efficient caching
 * {@link org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch}.
        Class<V> clazz,
            V[] nodeShardEntries = nodeEntry.getData();
    AsyncShardBatchFetch(
            V[] getData() {
            private final V[] shardData;
import java.util.Set;
            shardIdToArray = new HashMap<>();
            fillShardIdKeys(shardAttributesMap.keySet());
        }
            for (ShardId shardId : shardIds) {
            return this.responseFactory.getNewResponse(node, getBatchData(cache.get(node.getId())));
            this.logger = logger;
            super(Loggers.getLogger(logger, "_" + logKey), type, clusterManagerMetrics);
            return shardData;
                                this.shardData[shardIdKey.get(shardId)] = null;
            action,
                        }
            private final Predicate<V> emptyShardResponsePredicate;
        AsyncShardFetch.Lister<? extends BaseNodesResponse<T>, T> action,
 * @param <V> Data type of shard level response.
        private final Map<String, NodeEntry<V>> cache;
            }
}
    public AsyncShardFetchCache<T> getCache() {
        super(
        @Override
        private final int batchSize;
        @NonNull
    /**
        public void initData(DiscoveryNode node) {
            batchId,
    public boolean hasEmptyCache() {
            int shardIdIndex = 0;
                Integer arrIndex = shardIdEntry.getValue();
    }
            // those null entries means that we need to ignore those entries. Empty responses on the other hand are
            Map<ShardId, V> batchResponse = responseFactory.getShardBatchData(response);
        }
            private final boolean[] emptyShardResponse; // we can not rely on null entries of the shardData array,
            }
