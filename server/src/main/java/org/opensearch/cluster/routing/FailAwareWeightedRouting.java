        Exception exception,  
     */
        if (exception instanceof OpenSearchException) {  
            return next;
        return false;
     *
 * This decides if retryable shard search requests can be tried on shard copies present in data
     * @param exception The underlying search exception
    }
                getWeightedRoutingStats().updateFailOpenCount();  
import org.apache.logging.log4j.Logger;
    private boolean hasInActiveShardCopies(ClusterState clusterState, ShardId shardId) {  
        while (next != null && WeightedRoutingUtils.isWeighedAway(next.currentNodeId(), clusterState)) {
     * @return the next shard copy
        RestStatus.INTERNAL_SERVER_ERROR,  
    );
    private boolean isInternalFailure(Exception exception) {
import org.apache.logging.log4j.LogManager;
import org.opensearch.cluster.ClusterState;  
            if (canFailOpen(nextShard.shardId(), shardsIt.size(), exception, clusterState)) {
        }  
 * This class contains logic to find next shard to retry search request in case of failure from other shard copy.
 * The OpenSearch Contributors require contributions made to  
                break;
            return next;
    }
 */
    }
/*  
            return internalErrorRestStatusList.contains(((OpenSearchException) exception).status());
        return false;
    }
    public ShardRouting findNext(final ShardsIterator shardsIt, ClusterState clusterState, Exception exception, Runnable onShardSkipped) {
import org.opensearch.action.search.SearchShardIterator;
     * @return true if exception is due to cluster availability issues  
            onShardSkipped.run();
        while (next != null && WeightedRoutingUtils.isWeighedAway(next.getNodeId(), clusterState)) {
 */  
     * @param shardIt Shard Iterator containing order in which shard copies for a shard need to be requested  
        RestStatus.SERVICE_UNAVAILABLE,
        Runnable onShardSkipped
     * This function returns next shard copy to retry search request in case of failure from previous copy returned
        if (ignoreWeightedRouting(clusterState)) {
     * *
        return next;  
        SearchShardTarget next = shardIt.nextOrNull();  
     */
            SearchShardTarget nextShard = next;  
        return WeightedRoutingStats.getInstance();  
    ) {
        if (ignoreWeightedRouting(clusterState)) {
import org.opensearch.core.index.shard.ShardId;
     * @return true if can fail open ie request shard copies present in nodes with weighted shard
        }
                getWeightedRoutingStats().updateFailOpenCount();  
            }
     * @param clusterState The current cluster state
        }  
            next = shardIt.nextOrNull();  
     * *
    }
    /**  
     * by the iterator. It has the logic to fail open ie request shard copies present in nodes with weighted shard
     * @return the next shard copy  
import org.opensearch.core.rest.RestStatus;
    public WeightedRoutingStats getWeightedRoutingStats() {
            onShardSkipped.run();
import org.apache.logging.log4j.message.ParameterizedMessage;  
    /**
        ShardRouting next = shardsIt.nextOrNull();  
    public static final FailAwareWeightedRouting INSTANCE = new FailAwareWeightedRouting();
     * @param shardsIt Shard Iterator containing order in which shard copies for a shard need to be requested
    /**  
        return shardItSize == 1 || isInternalFailure(exception) || hasInActiveShardCopies(clusterState, shardId);  
     */
/**  
     * @param clusterState The current cluster state  
        return next;  
 * SPDX-License-Identifier: Apache-2.0
            ShardRouting nextShard = next;  
        List<ShardRouting> shards = clusterState.routingTable().shardRoutingTable(shardId).shards();
    private boolean ignoreWeightedRouting(ClusterState clusterState) {
    }
     * @param onShardSkipped The runnable to execute once a shard is skipped
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            }
     * This function returns next shard copy to retry search request in case of failure from previous copy returned
                logger.info(() -> new ParameterizedMessage("{}: Fail open executed due to exception", nextShard.shardId()), exception);
            next = shardsIt.nextOrNull();  
                return true;
     * @param onShardSkipped The runnable to execute once a shard is skipped  
                logger.info(() -> new ParameterizedMessage("{}: Fail open executed due to exception", nextShard.getShardId()), exception);
    private static final Logger logger = LogManager.getLogger(FailAwareWeightedRouting.class);  
    }
            }
            // checking for 5xx failures
                break;
    public SearchShardTarget findNext(  
     * @param exception The underlying search exception
        }  
import org.opensearch.search.SearchShardTarget;  
import java.util.List;
        return INSTANCE;
        final SearchShardIterator shardIt,
}
public class FailAwareWeightedRouting {  
            if (canFailOpen(nextShard.getShardId(), shardIt.size(), exception, clusterState)) {
    public static FailAwareWeightedRouting getInstance() {  
        return IGNORE_WEIGHTED_SHARD_ROUTING.get(clusterState.getMetadata().settings());
        RestStatus.GATEWAY_TIMEOUT  
 * nodes whose attribute value weight for weighted shard routing is set to zero.  
            if (!shardRouting.active()) {  
        ClusterState clusterState,
    private boolean canFailOpen(ShardId shardId, int shardItSize, Exception exception, ClusterState clusterState) {
     */
     * by the iterator. It has the logic to fail open ie request shard copies present in nodes with weighted shard  
    private final static List<RestStatus> internalErrorRestStatusList = List.of(
        for (ShardRouting shardRouting : shards) {
import static org.opensearch.cluster.routing.OperationRouting.IGNORE_WEIGHTED_SHARD_ROUTING;
    /**
        }  
        RestStatus.BAD_GATEWAY,
     * routing weight set to zero  
     * routing weight set to zero
import org.opensearch.OpenSearchException;
        }
package org.opensearch.cluster.routing;
    }  
 *
     *
     * routing weight set to zero  
