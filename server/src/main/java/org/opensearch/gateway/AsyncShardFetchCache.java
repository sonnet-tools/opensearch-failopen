            return failure;
        for (BaseNodeEntry nodeEntry : getCache().values()) {
            || unwrappedCause instanceof OpenSearchTimeoutException;
import org.opensearch.ExceptionsHelper;
    }
    abstract Map<String, ? extends BaseNodeEntry> getCache();
        void doneFetching(Throwable failure) {
     * Are there any nodes that are fetching data?
            return valueSet || failure != null;
            this.valueSet = true;
            assert fetching : "setting value but not in fetching mode";
    abstract void putData(DiscoveryNode node, K response);
        boolean hasData() {
        }
    private final String type;
        }
     */
                type,
     * Actual metadata of shard is stored in child classes.
    private final ClusterManagerMetrics clusterManagerMetrics;
                nodeEntry.getNodeId(),
 * @opensearch.internal
import org.apache.logging.log4j.Logger;
            BaseNodeEntry nodeEntry = getCache().get(response.getNode().getId());
        }
        // verify that all current data nodes are there
        Map<DiscoveryNode, K> fetchData = new HashMap<>();
    boolean hasAnyNodeFetching() {
                    }
    List<String> findNodesToFetch() {
    }
                initData(node);
            this.failure = failure;
        return fetchData;
        return false;
/*
}
    boolean retryableException(Throwable unwrappedCause) {
    abstract void deleteShard(ShardId shardId);
        this.getCache().remove(nodeId);
            }
                    K nodeResponse = getData(node);
import org.apache.logging.log4j.message.ParameterizedMessage;
                    failedNodes.add(nodeEntry.getNodeId());
        private Throwable failure;
import java.util.ArrayList;
     *
        for (final DiscoveryNode node : nodes.getDataNodes().values()) {
                nodeEntry.getFetchingRound(),
        String getNodeId() {
     * different implementations may have different ways to populate the data from cache.
            assert fetching : "restarting fetching, but not in fetching mode";
     * Returns the number of fetches that are currently ongoing.
            this.fetching = true;
    private boolean validateNodeResponse(BaseNodeEntry nodeEntry, long fetchingRound) {
        }
                type,
import org.opensearch.OpenSearchTimeoutException;
            return fetching;
            if (nodeEntry != null) {
                        fetchData.put(node, nodeResponse);
     */
        }
        private long fetchingRound;
        return nodesToFetch;
     */
     * Fills the shard fetched data with new (data) nodes and a fresh NodeEntry, and removes from
 * SPDX-License-Identifier: Apache-2.0
                fetchingRound
                return true;
            return this.nodeId;
 * putData and getData needs to be called for all the nodes. This class is responsible for managing the flow for all
        getCache().keySet().removeIf(nodeId -> !nodes.nodeExists(nodeId));
        }
                    putData(response.getNode(), response);
        }
                    if (nodeResponse != null) {
 */
            this.fetching = false;
        for (Iterator<? extends Map.Entry<String, ? extends BaseNodeEntry>> it = getCache().entrySet().iterator(); it.hasNext();) {
 *
        for (BaseNodeEntry nodeEntry : getCache().values()) {
                logger.warn(() -> new ParameterizedMessage("failed to list shard for {} on node [{}]", type, failure.nodeId()), failure);
            return failure != null;
    void processResponses(List<K> responses, long fetchingRound) {
     * it nodes that are no longer part of the state.
     */
 * initData : how to initialize an entry of shard cache for a node.
            } else {
            // if the request got rejected or timed out, we need to try it again next time...
            this.nodeId = nodeId;
        }
     */
            BaseNodeEntry nodeEntry = getCache().get(failure.nodeId());
        }
    /**
    }
            if (retryableException(unwrappedCause)) {
 * The OpenSearch Contributors require contributions made to
     */
                if (nodeEntry.isFailed()) {
            || unwrappedCause instanceof ReceiveTimeoutTransportException
 * mark some node in fetching mode. All of these functionalities require checking the cache information and respond
     * @param nodes       Discovery nodes for which we need to return the cache data.
        }
    }
            // if the entry is there, for the right fetching round and not marked as failed already, process it
        if (nodeEntry.getFetchingRound() != fetchingRound) {
import java.util.Map;
import java.util.Set;
            if (nodeEntry.isFetching()) {
        void markAsFetching(long fetchingRound) {
     *
            );
 *
     * @param nodeId nodeId to be cleaned.
        long getFetchingRound() {
        boolean isFetching() {
    void processFailures(List<FailedNodeException> failures, long fetchingRound) {
     *
        }
    /**
    }
        }
        return count;
 * compatible open source license.
     * @return Map of cache data for every DiscoveryNode.
        }
            }
        // remove nodes that are not longer part of the data nodes set
        this.clusterManagerMetrics = clusterManagerMetrics;
            logger.trace("node {} has failed for [{}] (failure [{}])", nodeEntry.getNodeId(), type, nodeEntry.getFailure());
                    // if its failed, remove it from the list of nodes, so if this run doesn't work
        }
    /**
                    logger.trace("marking {} as done for [{}], result is [{}]", nodeEntry.getNodeId(), type, response);
            assert nodeEntry.getFetchingRound() > fetchingRound : "node entries only replaced by newer rounds";
        this.logger = logger;
                "received response for [{}] from node {} for an older fetching round (expected: {} but was: {})",
import org.opensearch.cluster.node.DiscoveryNodes;
        } else if (nodeEntry.isFailed()) {
            }
        private boolean fetching;
        boolean isFailed() {
                nodeEntry.getFetchingRound(),
        BaseNodeEntry(String nodeId) {
        void restartFetching() {
        return true;
                }
        this.type = type;
            }
            assert hasData() : "getting failure when data has not been fetched";
            if (nodeEntry.hasData() == false && nodeEntry.isFetching() == false) {
        private final String nodeId;
package org.opensearch.gateway;
     * Get the data from cache, ignore the failed entries. Use getData functional interface to get the data, as
            assert valueSet == false : "value can't be set when restarting fetching";
            assert valueSet == false : "setting failure when already set value";
                count++;
    @NonNull
    /**
import java.util.HashMap;
        List<String> nodesToFetch = new ArrayList<>();
import java.util.Iterator;
    /**
            assert failure != null : "setting failure can't be null";
 * AsyncShardFetchCache will operate on the node level cache which is map of String and BaseNodeEntry. initData,
        }
                handleNodeFailure(nodeEntry, failure, fetchingRound);
        if (nodeEntry.getFetchingRound() != fetchingRound) {
                nodeEntry.getNodeId(),
            this.fetching = false;
            assert nodeEntry.getFetchingRound() > fetchingRound : "node entries only replaced by newer rounds";
    /**
    abstract K getData(DiscoveryNode node);
 * getData : how to get the stored data for any shard allocators like {@link PrimaryShardAllocator} or
        } else if (nodeEntry.isFailed() == false) {
        return unwrappedCause instanceof OpenSearchRejectedExecutionException
        for (String nodeId : nodeIds) {
        Throwable getFailure() {
    }
        }
        }
            Map.Entry<String, BaseNodeEntry> entry = (Map.Entry<String, BaseNodeEntry>) it.next();
            getCache().get(nodeId).markAsFetching(fetchingRound);
    protected AsyncShardFetchCache(Logger logger, String type, ClusterManagerMetrics clusterManagerMetrics) {
                    it.remove();
            if (node != null) {
                "received failure for [{}] from node {} for an older fetching round (expected: {} but was: {})",
    /**
        }
            this.fetching = false;
    }
            }
 * this file be licensed under the Apache-2.0 license or a
     * A node entry, holding only node level fetching related information.
            );
            assert fetching : "setting value but not in fetching mode";
        int count = 0;
import java.util.List;
            }
 * putData : how to store the response of transport action in the cache.
    Map<DiscoveryNode, K> getCacheData(DiscoveryNodes nodes, Set<String> failedNodes) {
            logger.trace("processing failure {} for [{}]", failure, type);
        private boolean valueSet;
        void doneFetching() {
     * automatically be cleaned up once shards are assigned.
            logger.trace(
    int getInflightFetches() {
            }
            this.fetchingRound = fetchingRound;
     * Common function for removing whole node entry.
            assert fetching == false : "double marking a node as fetching";
            String nodeId = entry.getKey();
    }
        clusterManagerMetrics.incrementCounter(clusterManagerMetrics.asyncFetchSuccessCounter, Double.valueOf(responses.size()));
import org.opensearch.cluster.node.DiscoveryNode;
 * @param <K> Response type of transport action which has the data to be stored in the cache.
    static class BaseNodeEntry {
     */
            return fetchingRound;
import org.opensearch.core.index.shard.ShardId;
 * It'll also give useful insights like how many ongoing fetches are happening, how many nodes are left for fetch or
            DiscoveryNode node = nodes.get(nodeId);
    private final Logger logger;
    }
import reactor.util.annotation.NonNull;
            if (nodeEntry.isFetching()) {
 * accordingly.
 * the nodes.
import org.opensearch.cluster.ClusterManagerMetrics;
 */
import org.opensearch.action.support.nodes.BaseNodeResponse;
        for (K response : responses) {
            }
    }
        for (FailedNodeException failure : failures) {
                nodeEntry.doneFetching(failure.getCause());
                }
                nodeEntry.restartFetching();
    }
            if (getCache().containsKey(node.getId()) == false) {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            return false;
 *
     * Cleanup cached data for this shard once it's started. Cleanup only happens at shard level. Node entries will
import org.opensearch.transport.ReceiveTimeoutTransportException;
    void fillShardCacheWithDataNodes(DiscoveryNodes nodes) {
/**
     * data, and are not in fetch mode.
            BaseNodeEntry nodeEntry = entry.getValue();
            assert failure == null : "setting value when failure already set";
            assert failure == null : "failure can't be set when restarting fetching";
    /**
            Throwable unwrappedCause = ExceptionsHelper.unwrapCause(failure.getCause());
import org.opensearch.action.FailedNodeException;
        }
    }
            logger.trace(
    void markAsFetching(List<String> nodeIds, long fetchingRound) {
     * @param failedNodes return failedNodes with the nodes where fetch has failed.
        }
                fetchingRound
    abstract void initData(DiscoveryNode node);
 * deleteShard : how to clean up the stored data from cache for a shard.
                    // if the entry is there, for the right fetching round and not marked as failed already, process it
        for (BaseNodeEntry nodeEntry : getCache().values()) {
    private void handleNodeFailure(BaseNodeEntry nodeEntry, FailedNodeException failure, long fetchingRound) {
    }
                    // we try again next round to fetch it again
public abstract class AsyncShardFetchCache<K extends BaseNodeResponse> {
    void remove(String nodeId) {
    }
            if (nodeEntry != null) {
                nodesToFetch.add(nodeEntry.getNodeId());
                if (validateNodeResponse(nodeEntry, fetchingRound)) {
        clusterManagerMetrics.incrementCounter(clusterManagerMetrics.asyncFetchFailureCounter, Double.valueOf(failures.size()));
            return false;
     * @param shardId for which we need to free up the cached data.
 * <p>
     * Finds all the nodes that need to be fetched. Those are nodes that have no
        }
 * {@link ReplicaShardAllocator}
     */
                } else {
