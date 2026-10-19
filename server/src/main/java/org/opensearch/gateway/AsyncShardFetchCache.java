            || unwrappedCause instanceof OpenSearchTimeoutException;
            assert nodeEntry.getFetchingRound() > fetchingRound : "node entries only replaced by newer rounds";
        return unwrappedCause instanceof OpenSearchRejectedExecutionException  
        return true;  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
    /**
 * The OpenSearch Contributors require contributions made to  
        this.clusterManagerMetrics = clusterManagerMetrics;
            assert valueSet == false : "setting failure when already set value";  
     * @param failedNodes return failedNodes with the nodes where fetch has failed.  
    }  
     * Actual metadata of shard is stored in child classes.  
     * Are there any nodes that are fetching data?
    }
    }
    /**
 * this file be licensed under the Apache-2.0 license or a
     * data, and are not in fetch mode.
     * @param shardId for which we need to free up the cached data.  
 * AsyncShardFetchCache will operate on the node level cache which is map of String and BaseNodeEntry. initData,  
    /**
     * Finds all the nodes that need to be fetched. Those are nodes that have no  
        for (BaseNodeEntry nodeEntry : getCache().values()) {
        List<String> nodesToFetch = new ArrayList<>();
        boolean isFetching() {
import java.util.ArrayList;
 * @param <K> Response type of transport action which has the data to be stored in the cache.
import org.opensearch.ExceptionsHelper;  
            // if the request got rejected or timed out, we need to try it again next time...
        if (nodeEntry.getFetchingRound() != fetchingRound) {
        private boolean valueSet;
        }
import org.opensearch.cluster.ClusterManagerMetrics;
 * {@link ReplicaShardAllocator}
            DiscoveryNode node = nodes.get(nodeId);
        }  
        }  
        // verify that all current data nodes are there
            BaseNodeEntry nodeEntry = getCache().get(response.getNode().getId());
            assert fetching : "restarting fetching, but not in fetching mode";
            assert failure != null : "setting failure can't be null";
     *
     * different implementations may have different ways to populate the data from cache.  
/*  
    static class BaseNodeEntry {
                    }  
        for (Iterator<? extends Map.Entry<String, ? extends BaseNodeEntry>> it = getCache().entrySet().iterator(); it.hasNext();) {
            if (nodeEntry != null) {
                type,  
        this.getCache().remove(nodeId);
                    putData(response.getNode(), response);  
                    it.remove();  
            || unwrappedCause instanceof ReceiveTimeoutTransportException
            getCache().get(nodeId).markAsFetching(fetchingRound);  
    }
    private boolean validateNodeResponse(BaseNodeEntry nodeEntry, long fetchingRound) {  
        return nodesToFetch;
 * @opensearch.internal  
            this.valueSet = true;  
                "received failure for [{}] from node {} for an older fetching round (expected: {} but was: {})",
        this.logger = logger;  
        private long fetchingRound;
 *
                initData(node);
            this.fetching = false;  
    abstract K getData(DiscoveryNode node);  
    private void handleNodeFailure(BaseNodeEntry nodeEntry, FailedNodeException failure, long fetchingRound) {  
 * mark some node in fetching mode. All of these functionalities require checking the cache information and respond
    }
            if (retryableException(unwrappedCause)) {
            return this.nodeId;
    }
        return fetchData;
            assert failure == null : "failure can't be set when restarting fetching";  
            return fetching;  
        String getNodeId() {
    /**
            return failure;
 * <p>  
                "received response for [{}] from node {} for an older fetching round (expected: {} but was: {})",
            } else {
 * deleteShard : how to clean up the stored data from cache for a shard.
        void doneFetching(Throwable failure) {
            assert valueSet == false : "value can't be set when restarting fetching";
    }  
                } else {
 */  
 * getData : how to get the stored data for any shard allocators like {@link PrimaryShardAllocator} or  
    /**
            if (nodeEntry.isFetching()) {  
                nodeEntry.getNodeId(),
}  
            this.failure = failure;
            );  
        }  
        private Throwable failure;  
     */
     */  
    }
     */
     *
     * it nodes that are no longer part of the state.
    abstract Map<String, ? extends BaseNodeEntry> getCache();  
import org.opensearch.OpenSearchTimeoutException;
        for (String nodeId : nodeIds) {
            logger.trace("node {} has failed for [{}] (failure [{}])", nodeEntry.getNodeId(), type, nodeEntry.getFailure());  
        clusterManagerMetrics.incrementCounter(clusterManagerMetrics.asyncFetchFailureCounter, Double.valueOf(failures.size()));  
        private final String nodeId;  
                    // we try again next round to fetch it again
        }
            }  
            );  
 */
            return false;
            return fetchingRound;  
            Map.Entry<String, BaseNodeEntry> entry = (Map.Entry<String, BaseNodeEntry>) it.next();  
            }
        }  
 *
                count++;
package org.opensearch.gateway;
        for (FailedNodeException failure : failures) {
import java.util.HashMap;  
        }
                return true;
        this.type = type;
            this.nodeId = nodeId;
    }
            String nodeId = entry.getKey();
            BaseNodeEntry nodeEntry = entry.getValue();
    boolean retryableException(Throwable unwrappedCause) {
            assert fetching == false : "double marking a node as fetching";
            if (getCache().containsKey(node.getId()) == false) {  
                handleNodeFailure(nodeEntry, failure, fetchingRound);
import org.opensearch.transport.ReceiveTimeoutTransportException;  
 * accordingly.
        private boolean fetching;
        }
            if (nodeEntry.isFetching()) {
        // remove nodes that are not longer part of the data nodes set
     */
     */
            assert nodeEntry.getFetchingRound() > fetchingRound : "node entries only replaced by newer rounds";
        Throwable getFailure() {  
                nodesToFetch.add(nodeEntry.getNodeId());
import reactor.util.annotation.NonNull;  
    private final String type;
    }  
 * compatible open source license.
    private final Logger logger;
                    K nodeResponse = getData(node);  
        for (BaseNodeEntry nodeEntry : getCache().values()) {  
            }
                nodeEntry.restartFetching();  
            return failure != null;
            assert failure == null : "setting value when failure already set";
        }
                nodeEntry.doneFetching(failure.getCause());  
                logger.warn(() -> new ParameterizedMessage("failed to list shard for {} on node [{}]", type, failure.nodeId()), failure);
        return count;
                        fetchData.put(node, nodeResponse);
        }
            assert fetching : "setting value but not in fetching mode";
        }
                    if (nodeResponse != null) {
    private final ClusterManagerMetrics clusterManagerMetrics;  
                nodeEntry.getFetchingRound(),
    }
        return false;
                }
     * Fills the shard fetched data with new (data) nodes and a fresh NodeEntry, and removes from  
    void markAsFetching(List<String> nodeIds, long fetchingRound) {
            if (node != null) {
        for (BaseNodeEntry nodeEntry : getCache().values()) {
        void restartFetching() {  
            Throwable unwrappedCause = ExceptionsHelper.unwrapCause(failure.getCause());  
 * SPDX-License-Identifier: Apache-2.0
    int getInflightFetches() {
    List<String> findNodesToFetch() {  
import org.opensearch.core.index.shard.ShardId;
     * Cleanup cached data for this shard once it's started. Cleanup only happens at shard level. Node entries will  
import org.opensearch.cluster.node.DiscoveryNode;
        getCache().keySet().removeIf(nodeId -> !nodes.nodeExists(nodeId));
        }
import org.apache.logging.log4j.message.ParameterizedMessage;
                    failedNodes.add(nodeEntry.getNodeId());
            logger.trace(  
import org.opensearch.cluster.node.DiscoveryNodes;  
import java.util.Iterator;
 * putData : how to store the response of transport action in the cache.
        }  
import org.opensearch.action.FailedNodeException;
     */
    abstract void deleteShard(ShardId shardId);
/**
        clusterManagerMetrics.incrementCounter(clusterManagerMetrics.asyncFetchSuccessCounter, Double.valueOf(responses.size()));
        for (final DiscoveryNode node : nodes.getDataNodes().values()) {
            }
        if (nodeEntry.getFetchingRound() != fetchingRound) {
            }
        }  
        void doneFetching() {  
        BaseNodeEntry(String nodeId) {  
    }  
     * A node entry, holding only node level fetching related information.
            if (nodeEntry != null) {
        int count = 0;
        boolean isFailed() {
    abstract void initData(DiscoveryNode node);
     * @return Map of cache data for every DiscoveryNode.
            }  
    void processResponses(List<K> responses, long fetchingRound) {
import org.apache.logging.log4j.Logger;
     */  
    void fillShardCacheWithDataNodes(DiscoveryNodes nodes) {  
    @NonNull
    void processFailures(List<FailedNodeException> failures, long fetchingRound) {
     * automatically be cleaned up once shards are assigned.
 * the nodes.
import java.util.Set;
            logger.trace("processing failure {} for [{}]", failure, type);
    }  
                fetchingRound
                    logger.trace("marking {} as done for [{}], result is [{}]", nodeEntry.getNodeId(), type, response);
     * Get the data from cache, ignore the failed entries. Use getData functional interface to get the data, as
                if (validateNodeResponse(nodeEntry, fetchingRound)) {  
                nodeEntry.getFetchingRound(),
     * @param nodes       Discovery nodes for which we need to return the cache data.
            assert hasData() : "getting failure when data has not been fetched";
        void markAsFetching(long fetchingRound) {  
        }
    }
                }
            this.fetching = false;
                type,  
        }
    /**
            }
            this.fetchingRound = fetchingRound;  
            return valueSet || failure != null;  
        }
                nodeEntry.getNodeId(),
import java.util.List;
        } else if (nodeEntry.isFailed()) {
            if (nodeEntry.hasData() == false && nodeEntry.isFetching() == false) {  
        }  
        Map<DiscoveryNode, K> fetchData = new HashMap<>();
    /**
     * Common function for removing whole node entry.
        for (K response : responses) {  
                if (nodeEntry.isFailed()) {  
public abstract class AsyncShardFetchCache<K extends BaseNodeResponse> {
        }
     * Returns the number of fetches that are currently ongoing.
     */
            this.fetching = true;
import java.util.Map;  
            }
 * putData and getData needs to be called for all the nodes. This class is responsible for managing the flow for all
            BaseNodeEntry nodeEntry = getCache().get(failure.nodeId());  
 *  
 * initData : how to initialize an entry of shard cache for a node.
        boolean hasData() {
    boolean hasAnyNodeFetching() {
    abstract void putData(DiscoveryNode node, K response);
        }
import org.opensearch.action.support.nodes.BaseNodeResponse;  
 * It'll also give useful insights like how many ongoing fetches are happening, how many nodes are left for fetch or  
                    // if its failed, remove it from the list of nodes, so if this run doesn't work
            return false;
    void remove(String nodeId) {  
        }  
        long getFetchingRound() {
            this.fetching = false;
     * @param nodeId nodeId to be cleaned.
                    // if the entry is there, for the right fetching round and not marked as failed already, process it
            // if the entry is there, for the right fetching round and not marked as failed already, process it
            assert fetching : "setting value but not in fetching mode";
     *  
    Map<DiscoveryNode, K> getCacheData(DiscoveryNodes nodes, Set<String> failedNodes) {  
    /**
        } else if (nodeEntry.isFailed() == false) {
            logger.trace(  
    protected AsyncShardFetchCache(Logger logger, String type, ClusterManagerMetrics clusterManagerMetrics) {
                fetchingRound
