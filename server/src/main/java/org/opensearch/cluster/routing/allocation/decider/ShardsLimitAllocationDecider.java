import org.opensearch.cluster.routing.ShardRouting;
 * {@code cluster.routing.allocation.total_primary_shards_per_node} globally during the allocation
        return doDecide(shardRouting, node, allocation, (count, limit) -> count > limit);
    private void setClusterPrimaryShardLimit(int clusterPrimaryShardLimit) {
        Property.NodeScope  
 *  
        Property.Dynamic,
     */  
 * compatible open source license.
import org.opensearch.cluster.routing.ShardRoutingState;
     * Controls the maximum number of primary shards per index on a single OpenSearch
        "index.routing.allocation.total_shards_per_node",
                    NAME,
/*  
        }  
        "cluster.routing.allocation.total_remote_capable_shards_per_node",
    public static final Setting<Integer> INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING = Setting.intSetting(
                    "too many shards [%d] allocated to this node for index [%s], index setting [%s=%d]",
import org.opensearch.cluster.routing.RoutingNode;
 * {@link ShardRoutingState#INITIALIZING inializing} or
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        -1,
    private final Settings settings;  
        return allocation.decision(
 * The OpenSearch Contributors require contributions made to  
        IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
        Property.Dynamic,
    );
        final int nodeShardCount = node.numberOfOwningShards();
    /**  
        -1,  
        if (clusterShardLimit > 0 && decider.test(nodeShardCount, clusterShardLimit)) {
     * node. Negative values are interpreted as unlimited.
        -1,
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING, this::setClusterShardLimit);
        -1,  
     */  
 *
        Property.NodeScope  
    /**  
                Decision.YES,
                nodeShardCount,  
                    Decision.NO,
            indexShardLimit = indexMetadata.getIndexTotalRemoteCapableShardsPerNodeLimit();  
 *
                    shardRoutingPool == RoutingPool.REMOTE_CAPABLE  
     * Controls the maximum number of remote capable shards per node on a cluster level.
    );
        Property.IndexScope  
                clusterPrimaryShardLimit
            clusterPrimaryShardLimit  
 * index or node-wide basis. The allocator prevents a single node to hold more
        RoutingPool shardRoutingPool = RoutingPool.getShardPool(shardRouting, allocation);
    private volatile int clusterRemoteCapableShardLimit;
 */  
        return doDecide(shardRouting, node, allocation, (count, limit) -> count >= limit);
    );
 * software distributed under the License is distributed on an
import org.opensearch.cluster.routing.RoutingPool;  
    public static final Setting<Integer> CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING = Setting.intSetting(
     * Controls the maximum number of shards per index on a single OpenSearch
    }
    public static final Setting<Integer> CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING = Setting.intSetting(
            }  
    private void setClusterShardLimit(int clusterShardLimit) {  
                    NAME,  
/*
                        ? INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()
                indexPrimaryShardLimit,
                return allocation.decision(
                "too many shards [%d] allocated to this node, cluster setting [%s=%d]",
        -1,  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
    ) {  
        // Capture the limit here in case it changes during this method's execution
        -1,  
        if (indexPrimaryShardLimit > 0 && shardRouting.primary()) {  
        RoutingPool nodeRoutingPool = RoutingPool.getNodePool(node);
import java.util.function.BiPredicate;  
            if (decider.test(indexShardCount, indexShardLimit)) {
    }
            }
            );
        "cluster.routing.allocation.total_shards_per_node",
    public static final Setting<Integer> INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING = Setting.intSetting(
        if (nodeRoutingPool == RoutingPool.REMOTE_CAPABLE) {
                    clusterPrimaryShardLimit
    private void setClusterRemoteCapableShardLimit(int clusterRemoteCapableShardLimit) {
        Property.Dynamic,
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
                nodeRoutingPool == RoutingPool.REMOTE_CAPABLE
                Decision.NO,  
        "cluster.routing.allocation.total_primary_shards_per_node",
                        : INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(),
        Property.Dynamic,
    );
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
    /**  
                    : CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(),  
     * Negative values are interpreted as unlimited.
                    ? CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.getKey()
        final int indexPrimaryShardLimit;
        Property.Dynamic,
        }  
        "index.routing.allocation.total_primary_shards_per_node",
                    shardRoutingPool == RoutingPool.REMOTE_CAPABLE
        this.clusterPrimaryShardLimit = clusterPrimaryShardLimit;
}
            indexShardLimit,  
 * </p>  
                );
        // TargetPoolAllocationDecider will handle for this case, hence short-circuiting from here  
    private volatile int clusterPrimaryShardLimit;  
 * per index are unlimited per node or primary shards per index are unlimited per node respectively. Shards currently in the  
        -1,
     * Negative values are interpreted as unlimited.
 * If {@code index.routing.allocation.total_shards_per_node} or {@code index.routing.allocation.total_primary_shards_per_node}is reset to a negative value shards
 * {@link ShardRoutingState#UNASSIGNED unassigned}
 * ownership. Elasticsearch licenses this file to you under  
 */  
            clusterShardLimit,
     * node for segment replication enabled indices. Negative values are interpreted as unlimited.
 * license agreements. See the NOTICE file distributed with
    }
        "index.routing.allocation.total_remote_capable_shards_per_node",
    private Decision doDecide(
                    "too many primary shards [%d] allocated to this node for index [%s], index setting [%s=%d]",  
/**
            if (decider.test(indexPrimaryShardCount, indexPrimaryShardLimit)) {
 * <p>
 * @opensearch.internal
 * This {@link AllocationDecider} limits the number of shards per node on a per  
            return allocation.decision(
 */  
        this.clusterShardLimit = clusterShardLimit;
        "index.routing.allocation.total_remote_capable_primary_shards_per_node",
 * trigger relocation and significant additional load on the clusters nodes.
            );
            final int indexPrimaryShardCount = node.numberOfOwningPrimaryShardsForIndex(shardRouting.index());
        Property.Dynamic,
    @Override
        -1,  
    /**  
     */  
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
 * Note: Reducing the number of shards per node via the index update API can
 * specific language governing permissions and limitations
 * {@code cluster.routing.allocation.total_shards_per_node} globally and  
                return allocation.decision(
 * {@link AllocationDecider} until the shard changed its state to either
 * Unless required by applicable law or agreed to in writing,
 * index settings API.  
        }
 * Licensed to Elasticsearch under one or more contributor  
        RoutingAllocation allocation,
    private volatile int clusterShardLimit;
 */
        if (shardRoutingPool != nodeRoutingPool) {
            clusterPrimaryShardLimit = this.clusterPrimaryShardLimit;
            indexPrimaryShardLimit = indexMetadata.getIndexTotalPrimaryShardsPerNodeLimit();  
                );  
                        ? INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.getKey()  
        if (indexShardLimit > 0) {
        -1,
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
        final int indexShardLimit;  
 * process. The limits of this decider can be changed in real-time via a the
                    indexPrimaryShardCount,
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING, this::setClusterPrimaryShardLimit);
            indexPrimaryShardLimit = indexMetadata.getIndexTotalRemoteCapablePrimaryShardsPerNodeLimit();
            "the shard count [%d] for this node is under the index limit [%d], index primary limit [%d], cluster level node limit [%d] and cluster level primary node limit [%d]",
        final int clusterPrimaryShardLimit;  
                    indexShardLimit
                    CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(),  
        }  
        -1,
    public static final String NAME = "shards_limit";  
                indexShardLimit,
        clusterSettings.addSettingsUpdateConsumer(  
        if (shardRouting.primary() && clusterPrimaryShardLimit > 0) {
package org.opensearch.cluster.routing.allocation.decider;
 * {@link ShardRoutingState#STARTED started},  
        );  
            indexPrimaryShardLimit,
     * node. Negative values are interpreted as unlimited.
     */  
                    shardRouting.getIndexName(),
 *     http://www.apache.org/licenses/LICENSE-2.0
    );
            clusterPrimaryShardLimit = -1; // No primary shard limit for remote capable nodes  
                NAME,
 * You may obtain a copy of the License at  
            final int nodePrimaryShardCount = node.numberOfOwningPrimaryShards();
                clusterShardLimit,  
                "total shard limits are disabled: [index: %d, index primary: %d, cluster: %d, cluster primary: %d] <= 0",  
        ShardRouting shardRouting,
            CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING,
    }  
        }  
    public static final Setting<Integer> INDEX_TOTAL_SHARDS_PER_NODE_SETTING = Setting.intSetting(
    }
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.cluster.metadata.IndexMetadata;
    public static final Setting<Integer> INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING = Setting.intSetting(
        this.settings = settings;  
                        : INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey(),
    }
        BiPredicate<Integer, Integer> decider
        }
    public ShardsLimitAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
            final int indexShardCount = node.numberOfOwningShardsForIndex(shardRouting.index());  
                    Decision.NO,  
                    NAME,
            NAME,  
        Property.NodeScope  
     * Controls the maximum number of primary shards per node on a cluster level.
    public static final Setting<Integer> CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING = Setting.intSetting(
            if (decider.test(nodePrimaryShardCount, clusterPrimaryShardLimit)) {  
 * <p>  
            clusterShardLimit = this.clusterShardLimit;
     * node. Negative values are interpreted as unlimited.
        this.clusterShardLimit = CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.get(settings);
        );
        -1,  
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
        Property.IndexScope  
            return Decision.ALWAYS;
        this.clusterRemoteCapableShardLimit = clusterRemoteCapableShardLimit;  
    /**  
                    "too many primary shards [%d] allocated to this node, cluster setting [%s=%d]",
        final int clusterShardLimit;
     * Controls the maximum number of remote capable primary shards per index on a single OpenSearch
     */  
        if (indexShardLimit <= 0 && indexPrimaryShardLimit <= 0 && clusterShardLimit <= 0 && clusterPrimaryShardLimit <= 0) {
        -1,  
    @Override  
    /**  
                    Decision.NO,
        this.clusterPrimaryShardLimit = CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(settings);
                return allocation.decision(  
                    nodePrimaryShardCount,
        Property.Dynamic,
     * Controls the maximum number of shards per node on a cluster level.
        } else {
            this::setClusterRemoteCapableShardLimit
 * this work for additional information regarding copyright
                clusterShardLimit
     * Controls the maximum number of remote capable shards per index on a single OpenSearch
        }  
    );
    );
 * under the License.  
public class ShardsLimitAllocationDecider extends AllocationDecider {
                    shardRouting.getIndexName(),
            nodeShardCount,
        -1,
        this.clusterRemoteCapableShardLimit = CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.get(settings);  
        -1,
            Decision.YES,
            clusterShardLimit = this.clusterRemoteCapableShardLimit;
                    indexPrimaryShardLimit  
        RoutingNode node,  
        Property.IndexScope  
            return allocation.decision(  
import org.opensearch.common.settings.Setting.Property;  
            indexShardLimit = indexMetadata.getIndexTotalShardsPerNodeLimit();
 *
 * {@link ShardRoutingState#RELOCATING relocating} state are ignored by this
                    indexShardCount,  
import org.opensearch.common.settings.Setting;
        Property.IndexScope  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
/*  
     * Negative values are interpreted as unlimited.
     */  
    }  
                NAME,
     */  
                );
 * than {@code index.routing.allocation.total_shards_per_node} per index, {@code index.routing.allocation.total_primary_shards_per_node} per index,
            }
import org.opensearch.common.settings.Settings;
