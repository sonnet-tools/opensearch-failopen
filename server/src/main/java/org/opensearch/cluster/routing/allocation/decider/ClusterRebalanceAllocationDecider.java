import org.opensearch.common.settings.Setting.Property;
                    CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE,
    public ClusterRebalanceAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
            }
                    "the cluster has unassigned shards and cluster setting [%s] is set to [%s]",
         * Re-balancing is allowed once a shard replication group is active
    private volatile ClusterRebalanceType type;
    }
 */
import org.opensearch.common.settings.Setting;
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * specific language governing permissions and limitations
        // type == Type.ALWAYS
    public static final String NAME = "cluster_rebalance";
        public static ClusterRebalanceType parseString(String typeString) {
                    NAME,
 * GitHub history for details.
            if (allocation.routingNodes().hasUnassignedPrimaries()) {
                );
 * <li>{@code indices_all_active} - Re-balancing is allowed only once all
                return allocation.decision(
        INDICES_PRIMARIES_ACTIVE,
        if (type == ClusterRebalanceType.INDICES_ALL_ACTIVE) {
     *
                    type
                    Decision.NO,
    /**
 *
 * Licensed to Elasticsearch under one or more contributor
    }
        logger.debug("using [{}] with [{}]", CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE, type);
 * this file be licensed under the Apache-2.0 license or a
                    CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE,
 * KIND, either express or implied.  See the License for the
            }
        /**
/*
    private void setType(ClusterRebalanceType type) {
    public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
import java.util.Locale;
 * this work for additional information regarding copyright
 *
 *
    private static final String CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE = "cluster.routing.allocation.allow_rebalance";
    }
 * </ul>
        /**
                return ClusterRebalanceType.INDICES_ALL_ACTIVE;
package org.opensearch.cluster.routing.allocation.decider;
 */
 * <li>{@code indices_primaries_active} - Re-balancing is allowed only once all
        }
 * primary shards on all indices are active.</li>
    @Override
        return allocation.decision(Decision.YES, NAME, "all shards are active");
 * software distributed under the License is distributed on an
            } else if ("indices_primaries_active".equalsIgnoreCase(typeString) || "indicesPrimariesActive".equalsIgnoreCase(typeString)) {
                    CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE,
    private static final Logger logger = LogManager.getLogger(ClusterRebalanceAllocationDecider.class);
        Property.NodeScope
 */
 * under the License.
/*
                    "the cluster has inactive primary shards and cluster setting [%s] is set to [%s]",
        ALWAYS,
            if (allocation.routingNodes().hasUnassignedShards()) {
 * <li>{@code always} - Re-balancing is allowed once a shard replication group
         * Re-balancing is allowed only once all primary shards on all indices are active.
        }
        return canRebalance(allocation);
 * real-time and should be pre-cluster start via
/**
                    Decision.NO,
                return allocation.decision(
     */
    public Decision canRebalance(RoutingAllocation allocation) {
        CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE,
import org.apache.logging.log4j.LogManager;
         */
                    NAME,
 * shards on all indices are active.</li>
    public static final Setting<ClusterRebalanceType> CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING = new Setting<>(
                return ClusterRebalanceType.ALWAYS;
public class ClusterRebalanceAllocationDecider extends AllocationDecider {
        this.type = type;
                    NAME,
 * @opensearch.internal
         */
            }
            }
        public String toString() {
 * You may obtain a copy of the License at
     * An enum representation for the configured re-balance type.
 * cluster wide active shard state. This decided can not be configured in
        }
                "Illegal value for " + CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING + ": " + typeString
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return name().toLowerCase(Locale.ROOT);
            } else if ("indices_all_active".equalsIgnoreCase(typeString) || "indicesAllActive".equalsIgnoreCase(typeString)) {
 * SPDX-License-Identifier: Apache-2.0
                    type
    }
                );
 * {@code cluster.routing.allocation.allow_rebalance}. This setting respects the following
         */
 * license agreements. See the NOTICE file distributed with
                    type
 * This {@link AllocationDecider} controls re-balancing operations based on the
         * Re-balancing is allowed only once all shards on all indices are active.
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        ClusterRebalanceType.INDICES_ALL_ACTIVE.toString(),
                    CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE,
import org.apache.logging.log4j.Logger;
/*
}
                );
    }
                    Decision.NO,
            if (allocation.routingNodes().hasInactiveShards()) {
                return allocation.decision(
import org.opensearch.common.settings.Settings;
            // check if there are unassigned primaries.
                return ClusterRebalanceType.INDICES_PRIMARIES_ACTIVE;
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING, this::setType);
        /**
                    "the cluster has inactive shards and cluster setting [%s] is set to [%s]",
        ClusterRebalanceType::parseString,
            // check if there are unassigned shards.
                return allocation.decision(
            return allocation.decision(Decision.YES, NAME, "all primary shards are active");
            // check if there are initializing primaries that don't have a relocatingNodeId entry.
            // in case all indices are assigned, are there initializing shards which
            if (allocation.routingNodes().hasInactivePrimaries()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
 * <ul>
 * The OpenSearch Contributors require contributions made to
 *
 * values:
        @Override
 * Unless required by applicable law or agreed to in writing,
                );
        INDICES_ALL_ACTIVE;
            // are not relocating?
                    "the cluster has unassigned primary shards and cluster setting [%s] is set to [%s]",
                    Decision.NO,
    );
                    type
 * is active</li>
 * compatible open source license.
    public enum ClusterRebalanceType {
            throw new IllegalArgumentException(
 * not use this file except in compliance with the License.
            }
            if ("always".equalsIgnoreCase(typeString)) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.routing.ShardRouting;
        type = CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.get(settings);
                    NAME,
        if (type == ClusterRebalanceType.INDICES_PRIMARIES_ACTIVE) {
    @Override
        }
 * ownership. Elasticsearch licenses this file to you under
            );
        Property.Dynamic,
     * @opensearch.internal
import org.opensearch.common.settings.ClusterSettings;
