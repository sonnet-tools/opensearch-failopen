        }
 * You may obtain a copy of the License at  
    }
 * {@link AllocationDecider} controls the number of currently in-progress  
import org.opensearch.common.settings.ClusterSettings;
 */  
            );
    private static final Logger logger = LogManager.getLogger(ConcurrentRebalanceAllocationDecider.class);
 * Similar to the {@link ClusterRebalanceAllocationDecider} this
 *  
import org.apache.logging.log4j.LogManager;
/*
    );  
    }
            relocatingShards  
        clusterConcurrentRebalance = concurrentRebalance;
            return allocation.decision(
import org.opensearch.common.settings.Setting;  
 * are unlimited.
        int relocatingShards = allocation.routingNodes().getRelocatingShardCount();
            return allocation.decision(Decision.YES, NAME, "unlimited concurrent rebalances are allowed");  
                relocatingShards,
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 * SPDX-License-Identifier: Apache-2.0
                Decision.THROTTLE,
 */
    public ConcurrentRebalanceAllocationDecider(Settings settings, ClusterSettings clusterSettings) {  
    }
            CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_REBALANCE_SETTING,
 * this work for additional information regarding copyright
                NAME,  
        "cluster.routing.allocation.cluster_concurrent_rebalance",
        -1,  
                CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_REBALANCE_SETTING.getKey(),  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 * configured threshold is reached. The default number of concurrent rebalance
/*  
    private void setClusterConcurrentRebalance(int concurrentRebalance) {  
 * operations is set to {@code 2}  
    public Decision canRebalance(RoutingAllocation allocation) {
    private volatile int clusterConcurrentRebalance;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Property.Dynamic,
 *
        if (relocatingShards >= clusterConcurrentRebalance) {  
        return canRebalance(allocation);  
/**
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.cluster.routing.allocation.decider;
 */
                "reached the limit of concurrently rebalancing shards [%d], cluster setting [%s=%d]",
 * Re-balance operations can be controlled in real-time via the cluster update API using
import org.opensearch.common.settings.Setting.Property;
 *     http://www.apache.org/licenses/LICENSE-2.0
        2,
        return allocation.decision(
    @Override
 * re-balance (relocation) operations and restricts node allocations if the
 * specific language governing permissions and limitations
}  
 * license agreements. See the NOTICE file distributed with
        this.clusterConcurrentRebalance = CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_REBALANCE_SETTING.get(settings);
            this::setClusterConcurrentRebalance
        logger.debug("using [cluster_concurrent_rebalance] with [{}]", clusterConcurrentRebalance);
 * <p>
 *  
 * compatible open source license.
            "below threshold [%d] for concurrent rebalances, current rebalance shard count [%d]",
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_REBALANCE_SETTING = Setting.intSetting(  
 * setting is set to {@code -1} the number of concurrent re-balance operations
        Property.NodeScope
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
        if (clusterConcurrentRebalance == -1) {
            Decision.YES,
import org.opensearch.common.settings.Settings;
        );
import org.opensearch.cluster.routing.ShardRouting;  
 */  
 * GitHub history for details.
    public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
    @Override  
    public static final String NAME = "concurrent_rebalance";
 * Licensed to Elasticsearch under one or more contributor  
        );  
            NAME,  
public class ConcurrentRebalanceAllocationDecider extends AllocationDecider {  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
/*  
import org.apache.logging.log4j.Logger;
        }  
 * {@code cluster.routing.allocation.cluster_concurrent_rebalance}. Iff this  
 *
                clusterConcurrentRebalance
 * Modifications Copyright OpenSearch Contributors. See
        clusterSettings.addSettingsUpdateConsumer(  
    }
 * under the License.  
            clusterConcurrentRebalance,
 * the Apache License, Version 2.0 (the "License"); you may
