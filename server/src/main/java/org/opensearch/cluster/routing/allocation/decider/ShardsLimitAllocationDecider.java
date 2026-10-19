    private volatile int clusterRemoteCapableShardLimit;
        }
import java.util.function.BiPredicate;
        this.clusterShardLimit = CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.get(settings);
        -1,
     */
    @Override
 */
                Decision.YES,
            clusterShardLimit,
            );
        clusterSettings.addSettingsUpdateConsumer(
        this.settings = settings;
 * <p>
 * Unless required by applicable law or agreed to in writing,
        "index.routing.allocation.total_remote_capable_shards_per_node",
        }
     * node. Negative values are interpreted as unlimited.
        Property.NodeScope
     * node. Negative values are interpreted as unlimited.
    private Decision doDecide(
                    indexPrimaryShardLimit
        "index.routing.allocation.total_remote_capable_primary_shards_per_node",
        RoutingPool nodeRoutingPool = RoutingPool.getNodePool(node);
        if (indexShardLimit > 0) {
                );
        final int clusterShardLimit;
        "cluster.routing.allocation.total_primary_shards_per_node",
    }
        BiPredicate<Integer, Integer> decider
     * Negative values are interpreted as unlimited.
                        : INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(),
        Property.NodeScope
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
    /**
import org.opensearch.common.settings.Setting.Property;
        this.clusterRemoteCapableShardLimit = clusterRemoteCapableShardLimit;
        Property.Dynamic,
        final int indexShardLimit;
 * under the License.
            Decision.YES,
     * Controls the maximum number of primary shards per node on a cluster level.
            clusterPrimaryShardLimit
 */
        return doDecide(shardRouting, node, allocation, (count, limit) -> count > limit);
        Property.Dynamic,
import org.opensearch.cluster.metadata.IndexMetadata;
 * this file be licensed under the Apache-2.0 license or a
        if (shardRoutingPool != nodeRoutingPool) {
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
 *
import org.opensearch.common.settings.Settings;
    /**
            "the shard count [%d] for this node is under the index limit [%d], index primary limit [%d], cluster level node limit [%d] and cluster level primary node limit [%d]",
import org.opensearch.common.settings.ClusterSettings;
/*
     */
        -1,
package org.opensearch.cluster.routing.allocation.decider;
        "cluster.routing.allocation.total_remote_capable_shards_per_node",
        "index.routing.allocation.total_shards_per_node",
    ) {
import org.opensearch.cluster.routing.ShardRouting;
 * this work for additional information regarding copyright
        RoutingNode node,
import org.opensearch.cluster.routing.RoutingNode;
 * index settings API.
    }
        -1,
 * not use this file except in compliance with the License.
     * Controls the maximum number of shards per node on a cluster level.
            indexPrimaryShardLimit,
    );
        return allocation.decision(
import org.opensearch.common.settings.Setting;
        Property.Dynamic,
                    ? CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.getKey()
    );
            CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING,
}
 * software distributed under the License is distributed on an
        final int nodeShardCount = node.numberOfOwningShards();
    );
            if (decider.test(indexPrimaryShardCount, indexPrimaryShardLimit)) {
            clusterPrimaryShardLimit = -1; // No primary shard limit for remote capable nodes
        Property.IndexScope
        "cluster.routing.allocation.total_shards_per_node",
    }
    public static final Setting<Integer> INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING = Setting.intSetting(
 * KIND, either express or implied.  See the License for the
    private volatile int clusterShardLimit;
                "too many shards [%d] allocated to this node, cluster setting [%s=%d]",
    public static final String NAME = "shards_limit";
                    Decision.NO,
        -1,
 * @opensearch.internal
 * index or node-wide basis. The allocator prevents a single node to hold more
 *
    );
 * </p>
        -1,
    private void setClusterPrimaryShardLimit(int clusterPrimaryShardLimit) {
 * Licensed to Elasticsearch under one or more contributor
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING, this::setClusterPrimaryShardLimit);
 * {@link ShardRoutingState#INITIALIZING inializing} or
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                    NAME,
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING, this::setClusterShardLimit);
        Property.IndexScope
    /**
                NAME,
        // Capture the limit here in case it changes during this method's execution
                clusterShardLimit
 * per index are unlimited per node or primary shards per index are unlimited per node respectively. Shards currently in the
    /**
import org.opensearch.cluster.routing.RoutingPool;
 * ownership. Elasticsearch licenses this file to you under
        this.clusterPrimaryShardLimit = CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.get(settings);
        return doDecide(shardRouting, node, allocation, (count, limit) -> count >= limit);
    }
        this.clusterRemoteCapableShardLimit = CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.get(settings);
                indexPrimaryShardLimit,
        if (shardRouting.primary() && clusterPrimaryShardLimit > 0) {
        }
            indexShardLimit = indexMetadata.getIndexTotalShardsPerNodeLimit();
        "index.routing.allocation.total_primary_shards_per_node",
        );
            indexShardLimit,
 *
            final int indexShardCount = node.numberOfOwningShardsForIndex(shardRouting.index());
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                    : CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(),
        }
                Decision.NO,
            nodeShardCount,
 * {@link ShardRoutingState#UNASSIGNED unassigned}
                NAME,
/*
            }
 * GitHub history for details.
                        ? INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING.getKey()
        }
            }
        RoutingPool shardRoutingPool = RoutingPool.getShardPool(shardRouting, allocation);
            return allocation.decision(
    public static final Setting<Integer> INDEX_TOTAL_SHARDS_PER_NODE_SETTING = Setting.intSetting(
                "total shard limits are disabled: [index: %d, index primary: %d, cluster: %d, cluster primary: %d] <= 0",
 *
    /**
            );
                    shardRoutingPool == RoutingPool.REMOTE_CAPABLE
                    clusterPrimaryShardLimit
        -1,
    public static final Setting<Integer> INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING = Setting.intSetting(
        -1,
 * This {@link AllocationDecider} limits the number of shards per node on a per
                    "too many shards [%d] allocated to this node for index [%s], index setting [%s=%d]",
                    "too many primary shards [%d] allocated to this node, cluster setting [%s=%d]",
                );
     * Controls the maximum number of remote capable primary shards per index on a single OpenSearch
     * Controls the maximum number of primary shards per index on a single OpenSearch
                return allocation.decision(
        final int clusterPrimaryShardLimit;
 * <p>
/*
 * {@link ShardRoutingState#STARTED started},
 * {@link ShardRoutingState#RELOCATING relocating} state are ignored by this
            if (decider.test(indexShardCount, indexShardLimit)) {
 * specific language governing permissions and limitations
        final int indexPrimaryShardLimit;
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
    private void setClusterShardLimit(int clusterShardLimit) {
    private void setClusterRemoteCapableShardLimit(int clusterRemoteCapableShardLimit) {
    }
                );
 * than {@code index.routing.allocation.total_shards_per_node} per index, {@code index.routing.allocation.total_primary_shards_per_node} per index,
                    indexPrimaryShardCount,
        -1,
                    NAME,
        );
                    shardRouting.getIndexName(),
    private final Settings settings;
                nodeShardCount,
 * license agreements. See the NOTICE file distributed with
        -1,
    );
        -1,
 * {@code cluster.routing.allocation.total_primary_shards_per_node} globally during the allocation
    public static final Setting<Integer> CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING = Setting.intSetting(
        Property.IndexScope
 * {@code cluster.routing.allocation.total_shards_per_node} globally and
            indexPrimaryShardLimit = indexMetadata.getIndexTotalPrimaryShardsPerNodeLimit();
    /**
     * node for segment replication enabled indices. Negative values are interpreted as unlimited.
        // TargetPoolAllocationDecider will handle for this case, hence short-circuiting from here
        IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
     * Negative values are interpreted as unlimited.
        if (clusterShardLimit > 0 && decider.test(nodeShardCount, clusterShardLimit)) {
        if (nodeRoutingPool == RoutingPool.REMOTE_CAPABLE) {
    }
        -1,
 * Note: Reducing the number of shards per node via the index update API can
                    CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(),
            final int nodePrimaryShardCount = node.numberOfOwningPrimaryShards();
        this.clusterPrimaryShardLimit = clusterPrimaryShardLimit;
                indexShardLimit,
                    NAME,
            return Decision.ALWAYS;
            }
     * node. Negative values are interpreted as unlimited.
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
        -1,
     * Controls the maximum number of remote capable shards per index on a single OpenSearch
            final int indexPrimaryShardCount = node.numberOfOwningPrimaryShardsForIndex(shardRouting.index());
                    indexShardLimit
        RoutingAllocation allocation,
        Property.Dynamic,
 * compatible open source license.
    }
            return allocation.decision(
        Property.Dynamic,
                    shardRouting.getIndexName(),
        }
                clusterPrimaryShardLimit
 * {@link AllocationDecider} until the shard changed its state to either
        } else {
                    "too many primary shards [%d] allocated to this node for index [%s], index setting [%s=%d]",
            if (decider.test(nodePrimaryShardCount, clusterPrimaryShardLimit)) {
        ShardRouting shardRouting,
    public ShardsLimitAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
            clusterPrimaryShardLimit = this.clusterPrimaryShardLimit;
 * You may obtain a copy of the License at
        Property.Dynamic,
            clusterShardLimit = this.clusterRemoteCapableShardLimit;
                return allocation.decision(
                    Decision.NO,
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        this.clusterShardLimit = clusterShardLimit;
 * trigger relocation and significant additional load on the clusters nodes.
            indexPrimaryShardLimit = indexMetadata.getIndexTotalRemoteCapablePrimaryShardsPerNodeLimit();
     */
            NAME,
        if (indexShardLimit <= 0 && indexPrimaryShardLimit <= 0 && clusterShardLimit <= 0 && clusterPrimaryShardLimit <= 0) {
            clusterShardLimit = this.clusterShardLimit;
 */
     */
    /**
                    indexShardCount,
/**
 * If {@code index.routing.allocation.total_shards_per_node} or {@code index.routing.allocation.total_primary_shards_per_node}is reset to a negative value shards
public class ShardsLimitAllocationDecider extends AllocationDecider {
        }
        Property.Dynamic,
    public static final Setting<Integer> CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING = Setting.intSetting(
        Property.IndexScope
    private volatile int clusterPrimaryShardLimit;
     */
                    nodePrimaryShardCount,
     */
                        ? INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.getKey()
                    shardRoutingPool == RoutingPool.REMOTE_CAPABLE
     * Controls the maximum number of shards per index on a single OpenSearch
                        : INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey(),
            this::setClusterRemoteCapableShardLimit
                    Decision.NO,
        -1,
        Property.NodeScope
    @Override
     * Negative values are interpreted as unlimited.
                nodeRoutingPool == RoutingPool.REMOTE_CAPABLE
    public static final Setting<Integer> INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING = Setting.intSetting(
 * process. The limits of this decider can be changed in real-time via a the
        -1,
    );
import org.opensearch.cluster.routing.ShardRoutingState;
    public static final Setting<Integer> CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING = Setting.intSetting(
        if (indexPrimaryShardLimit > 0 && shardRouting.primary()) {
                clusterShardLimit,
    );
     * Controls the maximum number of remote capable shards per node on a cluster level.
            indexShardLimit = indexMetadata.getIndexTotalRemoteCapableShardsPerNodeLimit();
                return allocation.decision(
