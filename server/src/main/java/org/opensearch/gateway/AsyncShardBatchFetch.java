        static class NodeEntry<V> extends BaseNodeEntry {
                super.doneFetching();
            ShardBatchResponseFactory<T, V> responseFactory,
                fillShardData(shardDataFromNode, shardIdKey);  
                emptyShardResponse,  
 *  
                if (emptyResponses[arrIndex]) {
            // actually needed in allocation/explain API response. So instead of storing full empty response object
                clazz,
import org.opensearch.core.index.shard.ShardId;
        this.cache.deleteShard(shardId);
            nodeEntry.doneFetching(batchResponse, shardIdToArray);
                emptyShardResponsePredicate,
                this.shardData = (V[]) Array.newInstance(clazz, batchSize);  
                clusterManagerMetrics  
                    }
                Integer arrIndex = shardIdEntry.getValue();  
        private final Predicate<V> emptyShardResponsePredicate;
        public T getData(DiscoveryNode node) {
package org.opensearch.gateway;
         * Get shard level data from batch, then filter out if any shards received failures.  
        String batchId,
         */
            }
        }  
        Logger logger,
                responseFactory,
 * part using the base class {@link AsyncShardFetch}. Other functionalities needed for a batch are only written here.
                logger,
        public Map<String, ? extends BaseNodeEntry> getCache() {  
            batchId,
                ShardId shardId = shardIdEntry.getKey();
            NodeEntry<V> nodeEntry = cache.get(node.getId());
            new ShardBatchCache<>(  
     * Remove a shard from the cache maintaining a full batch of shards. This is needed to clear the shard once it's  
 * @param <T> Response type of the transport action.
 * {@link org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch}.
import java.util.Set;
                    shardData.put(shardId, nodeShardEntries[arrIndex]);
    public synchronized void clearShard(ShardId shardId) {
            Map<ShardId, V> batchResponse = responseFactory.getShardBatchData(response);  
 * This separation also takes care of the extra generic type V which is only needed for batch  
     */  
        private final ShardBatchResponseFactory<T, V> responseFactory;  
 * compatible open source license.
            this.batchSize = shardAttributesMap.size();
 */  
     * approach. This cache class is not thread safe, all of its methods are being called from
            logger,
         * Put the response received from data nodes into the cache.
            }
                this.emptyShardResponsePredicate = emptyShardResponsePredicate;
        );
 * transport actions like {@link TransportNodesListGatewayStartedShardsBatch} and
        super(  
                "BatchID=[" + batchId + "]",
            return shardData;
        public ShardBatchCache(
    }  
                for (Map.Entry<ShardId, V> shardData : shardDataFromNode.entrySet()) {  
     */
            int shardIdIndex = 0;  
                this.shardIdToArray.putIfAbsent(shardId, shardIdIndex++);
                                this.shardData[shardIdKey.get(shardId)] = null;  
            for (Map.Entry<ShardId, Integer> shardIdEntry : shardIdToArray.entrySet()) {
            }  
        /**
            }
        String type,
import org.opensearch.cluster.node.DiscoveryNode;
                    if (shardData.getValue() != null) {
            cache.put(node.getId(), new NodeEntry<>(node.getId(), shardResponseClass, batchSize, emptyShardResponsePredicate));
        public void putData(DiscoveryNode node, T response) {
import org.opensearch.action.support.nodes.BaseNodesResponse;  
            super(Loggers.getLogger(logger, "_" + logKey), type, clusterManagerMetrics);
    AsyncShardBatchFetch(  
                this.shardData[shardIdIndex] = null;
                        if (shardIdKey.get(shardId) != null) {// the response might be for shard which is no longer present in cache  
        @Override
            ClusterManagerMetrics clusterManagerMetrics
/*  
     * @param <T> Response type of transport action.
            fillShardIdKeys(shardAttributesMap.keySet());  
    ) {
                this.emptyShardResponse = new boolean[batchSize];
            // in cache, it's better to just store a boolean and create that object on the fly just before  
import org.opensearch.common.logging.Loggers;  
                    cache.get(nodeId).clearShard(shardIdIndex);  
        ) {  
        private final Logger logger;  
        public void deleteShard(ShardId shardId) {
        Map<ShardId, ShardAttributes> shardAttributesMap,  
        }
            private final Predicate<V> emptyShardResponsePredicate;
        }
                return emptyShardResponse;
         * After that complete storing the data at node level and mark fetching as done.
                        ShardId shardId = shardData.getKey();
         * A node entry, holding the state of the fetched data for a specific shard
        ClusterManagerMetrics clusterManagerMetrics
            Class<V> clazz,
    @SuppressWarnings("unchecked")
            }  
        public void initData(DiscoveryNode node) {  
        }
    public AsyncShardFetchCache<T> getCache() {
            action,
            return cache;
            if (shardIdToArray.containsKey(shardId)) {  
        AsyncShardFetch.Lister<? extends BaseNodesResponse<T>, T> action,
            }
            shardIdToArray = new HashMap<>();
            }  
     *
        @Override
            String logKey,  
                    shardData.put(shardId, emptyResponse);
            void clearShard(Integer shardIdIndex) {
                } else if (nodeShardEntries[arrIndex] != null) {  
            Logger logger,  
/**  
        ShardBatchResponseFactory<T, V> responseFactory,  
        }
            for (ShardId shardId : shardIds) {
                type,
     * @param shardId shardId to be removed from the batch.  
         * @param node     node from which we got the response.  
        private final Class<V> shardResponseClass;
     * assigned or failed.
            }
        }
            // decision-making.
            this.emptyShardResponsePredicate = emptyShardResponsePredicate;  
                                this.emptyShardResponse[shardIdKey.get(shardId)] = true;
import org.opensearch.cluster.ClusterManagerMetrics;
                return this.shardData;
            Map<ShardId, ShardAttributes> shardAttributesMap,
        return this.cache.getCache().isEmpty();
            private void fillShardData(Map<ShardId, V> shardDataFromNode, Map<ShardId, Integer> shardIdKey) {
import java.util.HashMap;
 * @opensearch.internal
                super(nodeId);
                emptyShardResponse[shardIdIndex] = false;  
                shardAttributesMap,  
            boolean[] getEmptyShardResponse() {
     * {@link org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch} with memory efficient caching  
    static class ShardBatchCache<T extends BaseNodeResponse, V> extends AsyncShardFetchCache<T> {
            private final V[] shardData;
     * Store node level responses of transport actions like {@link TransportNodesListGatewayStartedShardsBatch} or
     *  
         * for a giving node.
            cache = new HashMap<>();
            this.emptyResponse = emptyResponse;
                for (String nodeId : cache.keySet()) {
     * Cache implementation of transport actions returning batch of shards related data in the response.
        private final V emptyResponse;
                }  
            boolean[] emptyResponses = nodeEntry.getEmptyShardResponse();
            }
    /**  
 * @param <V> Data type of shard level response.
        @NonNull
 *
         * @param response shard metadata coming from node.
 *  
        V emptyShardResponse,
import java.lang.reflect.Array;
import java.util.Map;  
         *
        return this.cache;  
            // those null entries means that we need to ignore those entries. Empty responses on the other hand are
                }  
            V emptyResponse,
    /**
        }
    }  
public abstract class AsyncShardBatchFetch<T extends BaseNodeResponse, V> extends AsyncShardFetch<T> {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.indices.store.ShardAttributes;
            V[] getData() {  
            )
            NodeEntry(String nodeId, Class<V> clazz, int batchSize, Predicate<V> emptyShardResponsePredicate) {
                        }
                            } else {
            private final boolean[] emptyShardResponse; // we can not rely on null entries of the shardData array,  
                            if (emptyShardResponsePredicate.test(shardData.getValue())) {
                Integer shardIdIndex = shardIdToArray.remove(shardId);
        private HashMap<ShardId, V> getBatchData(NodeEntry<V> nodeEntry) {  
 * The OpenSearch Contributors require contributions made to  
            shardAttributesMap,  
 * Implementation of AsyncShardFetch with batching support. This class is responsible for executing the fetch
     * @param <V> Data type of shard level response.
        }  
        Predicate<V> emptyShardResponsePredicate,
import org.opensearch.action.support.nodes.BaseNodeResponse;
import reactor.util.annotation.NonNull;
    }
            this.responseFactory = responseFactory;
     * {@link AsyncShardFetch} class which has synchronized blocks present to handle multiple threads.
        private void fillShardIdKeys(Set<ShardId> shardIds) {
    }
         */  
        /**  
        this.shardAttributesMap.remove(shardId);  
                                this.shardData[shardIdKey.get(shardId)] = shardData.getValue();
            HashMap<ShardId, V> shardData = new HashMap<>();  
        }
                    // ignore null responses here
 */
        @Override
            this.shardResponseClass = clazz;
    public boolean hasEmptyCache() {
            String type,
                }
        private final int batchSize;
        private final Map<ShardId, Integer> shardIdToArray;  
            this.logger = logger;  
import org.apache.logging.log4j.Logger;
    }  
            V[] nodeShardEntries = nodeEntry.getData();
        @Override  
        @Override
            return this.responseFactory.getNewResponse(node, getBatchData(cache.get(node.getId())));  
            type,
import java.util.function.Predicate;
                            }  
}
 * this file be licensed under the Apache-2.0 license or a
            void doneFetching(Map<ShardId, V> shardDataFromNode, Map<ShardId, Integer> shardIdKey) {
            Predicate<V> emptyShardResponsePredicate,  
        Class<V> clazz,  
        private final Map<String, NodeEntry<V>> cache;
