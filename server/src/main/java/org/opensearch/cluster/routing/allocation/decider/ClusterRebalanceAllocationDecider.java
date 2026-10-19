 * <li>{@code indices_all_active} - Re-balancing is allowed only once all
            // in case all indices are assigned, are there initializing shards which
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.routing.ShardRouting;  
        CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE,
         */
                    NAME,  
 * not use this file except in compliance with the License.
 *  
         */  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                return allocation.decision(  
 * Unless required by applicable law or agreed to in writing,
 * {@code cluster.routing.allocation.allow_rebalance}. This setting respects the following
import org.apache.logging.log4j.Logger;
    public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {  
 *  
                return ClusterRebalanceType.ALWAYS;  
                    NAME,
import java.util.Locale;
     * An enum representation for the configured re-balance type.
                    Decision.NO,
 * under the License.  
import org.opensearch.common.settings.Settings;
        logger.debug("using [{}] with [{}]", CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE, type);  
                    "the cluster has inactive primary shards and cluster setting [%s] is set to [%s]",
                    CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE,
         * Re-balancing is allowed only once all shards on all indices are active.  
 * ownership. Elasticsearch licenses this file to you under  
/*  
    private void setType(ClusterRebalanceType type) {
 * GitHub history for details.
                );
     */
                );  
    public static final String NAME = "cluster_rebalance";
 */  
            if (allocation.routingNodes().hasUnassignedShards()) {
/*
                    CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE,
    }  
            } else if ("indices_primaries_active".equalsIgnoreCase(typeString) || "indicesPrimariesActive".equalsIgnoreCase(typeString)) {
                return ClusterRebalanceType.INDICES_ALL_ACTIVE;
                    type
                return allocation.decision(
            // check if there are unassigned primaries.
 * this file be licensed under the Apache-2.0 license or a
                return ClusterRebalanceType.INDICES_PRIMARIES_ACTIVE;
            } else if ("indices_all_active".equalsIgnoreCase(typeString) || "indicesAllActive".equalsIgnoreCase(typeString)) {  
     * @opensearch.internal  
            return allocation.decision(Decision.YES, NAME, "all primary shards are active");
import org.opensearch.common.settings.Setting;  
 * specific language governing permissions and limitations
import org.opensearch.common.settings.ClusterSettings;
 * The OpenSearch Contributors require contributions made to  
 * real-time and should be pre-cluster start via  
        /**
 * software distributed under the License is distributed on an
        return canRebalance(allocation);
}
            }
        ClusterRebalanceType::parseString,
    private static final Logger logger = LogManager.getLogger(ClusterRebalanceAllocationDecider.class);  
            return name().toLowerCase(Locale.ROOT);
        public String toString() {  
                    type
    public static final Setting<ClusterRebalanceType> CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING = new Setting<>(
    public Decision canRebalance(RoutingAllocation allocation) {
            }
            if ("always".equalsIgnoreCase(typeString)) {
    private static final String CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE = "cluster.routing.allocation.allow_rebalance";  
 * SPDX-License-Identifier: Apache-2.0
 * primary shards on all indices are active.</li>
        INDICES_PRIMARIES_ACTIVE,
                    "the cluster has unassigned primary shards and cluster setting [%s] is set to [%s]",  
 *  
    }
 * You may obtain a copy of the License at  
                    NAME,
 * shards on all indices are active.</li>
import org.apache.logging.log4j.LogManager;
                    Decision.NO,  
import org.opensearch.common.settings.Setting.Property;
 * Licensed to Elasticsearch under one or more contributor  
            );
        ClusterRebalanceType.INDICES_ALL_ACTIVE.toString(),  
    );
 *
                return allocation.decision(
        @Override
         */
    }
 * cluster wide active shard state. This decided can not be configured in
                    Decision.NO,
 * <li>{@code always} - Re-balancing is allowed once a shard replication group
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
            // check if there are initializing primaries that don't have a relocatingNodeId entry.
 * values:
package org.opensearch.cluster.routing.allocation.decider;
    public ClusterRebalanceAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
        // type == Type.ALWAYS
            }  
        if (type == ClusterRebalanceType.INDICES_ALL_ACTIVE) {  
        if (type == ClusterRebalanceType.INDICES_PRIMARIES_ACTIVE) {  
/*  
        this.type = type;
                    "the cluster has inactive shards and cluster setting [%s] is set to [%s]",
                );  
        public static ClusterRebalanceType parseString(String typeString) {
            throw new IllegalArgumentException(  
            }
public class ClusterRebalanceAllocationDecider extends AllocationDecider {
            if (allocation.routingNodes().hasInactivePrimaries()) {  
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING, this::setType);
                    type  
                    type
    private volatile ClusterRebalanceType type;
    }
 * license agreements. See the NOTICE file distributed with
            if (allocation.routingNodes().hasInactiveShards()) {
        }
/**  
                    "the cluster has unassigned shards and cluster setting [%s] is set to [%s]",  
                "Illegal value for " + CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING + ": " + typeString
                return allocation.decision(  
    @Override
 * <ul>  
 * </ul>  
 *
 *
        Property.NodeScope  
 */
            }
         * Re-balancing is allowed once a shard replication group is active
        type = CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.get(settings);
    public enum ClusterRebalanceType {
        Property.Dynamic,
    }  
 */  
         * Re-balancing is allowed only once all primary shards on all indices are active.
                    CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE,
        }  
        /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *
        /**  
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (allocation.routingNodes().hasUnassignedPrimaries()) {
 * @opensearch.internal
                    Decision.NO,
 * this work for additional information regarding copyright
 * This {@link AllocationDecider} controls re-balancing operations based on the
        ALWAYS,  
            // are not relocating?  
    @Override
                    CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE,  
        }
        }
        return allocation.decision(Decision.YES, NAME, "all shards are active");  
                    NAME,
 * KIND, either express or implied.  See the License for the
            // check if there are unassigned shards.
 * is active</li>
        INDICES_ALL_ACTIVE;
    /**  
                );
 */  
 * <li>{@code indices_primaries_active} - Re-balancing is allowed only once all
