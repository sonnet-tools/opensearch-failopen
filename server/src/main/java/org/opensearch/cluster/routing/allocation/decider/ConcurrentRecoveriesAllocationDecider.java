            CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_RECOVERIES_SETTING,  
import org.opensearch.cluster.routing.ShardRouting;  
    }  
import org.opensearch.common.settings.Setting;  
        );
                CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_RECOVERIES_SETTING.getKey(),
    }
        if (clusterConcurrentRecoveries == -1) {
 * re-balance (relocation) operations and restricts node allocations if the  
    @Override
 * GitHub history for details.
    );
/**
 *
    }
    private static final Logger logger = LogManager.getLogger(ConcurrentRecoveriesAllocationDecider.class);  
 * setting is set to <code>-1</code> the number of cluster concurrent recoveries operations
 * this file be licensed under the Apache-2.0 license or a
            return allocation.decision(
        }
            Decision.YES,  
            relocatingShards
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_RECOVERIES_SETTING = Setting.intSetting(
    private volatile int clusterConcurrentRecoveries;  
                relocatingShards,
 *
import org.opensearch.common.settings.Setting.Property;
 */
package org.opensearch.cluster.routing.allocation.decider;
                "too many shards are concurrently relocating [%d], limit: [%d] cluster setting [%s=%d]",
            "below threshold [%d] for concurrent recoveries, current relocating shard count [%d]",
        return canMoveAnyShard(allocation);
        int relocatingShards = allocation.routingNodes().getRelocatingShardCount();
 * The OpenSearch Contributors require contributions made to  
 * configured threshold is reached.
        logger.debug("using [cluster_concurrent_rebalance] with [{}]", clusterConcurrentRecoveries);
    @Override  
import org.opensearch.common.settings.ClusterSettings;
        Property.Dynamic,
                clusterConcurrentRecoveries,  
            return allocation.decision(Decision.YES, NAME, "undefined cluster concurrent recoveries");  
        );
 * Modifications Copyright OpenSearch Contributors. See  
 */  
 */  
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
 * Re-balance operations can be controlled in real-time via the cluster update API using  
        clusterSettings.addSettingsUpdateConsumer(
        }
import org.apache.logging.log4j.Logger;
            );  
 * SPDX-License-Identifier: Apache-2.0
    public ConcurrentRecoveriesAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
        return allocation.decision(
        "cluster.routing.allocation.cluster_concurrent_recoveries",
public class ConcurrentRecoveriesAllocationDecider extends AllocationDecider {
 * are unlimited.  
/*  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 * compatible open source license.
    public Decision canMoveAnyShard(RoutingAllocation allocation) {
        this.clusterConcurrentRecoveries = CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_RECOVERIES_SETTING.get(settings);  
 * This {@link AllocationDecider} controls the number of currently in-progress
 * @opensearch.internal
        this.clusterConcurrentRecoveries = clusterConcurrentRecoveries;  
                NAME,  
            clusterConcurrentRecoveries,  
                Decision.THROTTLE,
import org.apache.logging.log4j.LogManager;  
/*
}
        -1,  
    public static final String NAME = "cluster_concurrent_recoveries";
        -1,
import org.opensearch.common.settings.Settings;
 * <code>cluster.routing.allocation.cluster_concurrent_recoveries</code>. Iff this
 * <p>
    }  
                clusterConcurrentRecoveries
            NAME,
    private void setClusterConcurrentRebalance(int clusterConcurrentRecoveries) {
            this::setClusterConcurrentRebalance
        Property.NodeScope  
        if (relocatingShards >= clusterConcurrentRecoveries) {  
import org.opensearch.cluster.routing.RoutingNode;
