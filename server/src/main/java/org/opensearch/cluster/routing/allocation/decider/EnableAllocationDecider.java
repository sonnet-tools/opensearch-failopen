 *
 * The OpenSearch Contributors require contributions made to
        Rebalance.ALL.toString(),
 * specific language governing permissions and limitations
                if (shardRouting.primary()) {
            buf.append(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey());
            return allocation.decision(Decision.YES, NAME, "allocation is explicitly ignoring any disabling of rebalancing");
    private static String setting(Allocation allocation, boolean usedIndexSetting) {
import org.opensearch.common.settings.Setting;
                }
                    );
    }
                    return allocation.decision(Decision.YES, NAME, "replica rebalancing is allowed");
                if (shardRouting.primary() == false) {
 * Rebalancing settings can have the following values (non-casesensitive):
    @Override
                Decision.YES,
        StringBuilder buf = new StringBuilder();
        buf.append("=").append(allocation.toString().toLowerCase(Locale.ROOT)).append("]");
                    return allocation.decision(Decision.YES, NAME, "new primary allocations are allowed");
        return canAllocate(shardRouting, allocation);
    }
    );
            );
                if (shardRouting.primary()) {
        final boolean usedIndexSetting;
            buf.append("index setting [");
 *
            enable = this.enableRebalance;
import org.opensearch.common.settings.ClusterSettings;
     * {@link EnableAllocationDecider#CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING} /
                        "primary rebalancing is forbidden due to %s",
        }
import org.opensearch.cluster.metadata.IndexMetadata;
        public static Rebalance parse(String strValue) {
                        setting(enable, usedIndexSetting)
    public static final Setting<Allocation> INDEX_ROUTING_ALLOCATION_ENABLE_SETTING = new Setting<>(
        Property.Dynamic,
 *
/*
        return buf.toString();
 */
            }
                } else {
    /**
 * <p>
        this.enableAllocation = CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.get(settings);
        }
            usedIndexSetting = false;
 *     <li> <code>NONE</code> - no shard rebalancing is allowed.
 * GitHub history for details.
     * @opensearch.internal
 * not use this file except in compliance with the License.
        @Override
 * Modifications Copyright OpenSearch Contributors. See
        public String toString() {
        Property.IndexScope
                    return Allocation.valueOf(strValue);
    );
 * the Apache License, Version 2.0 (the "License"); you may
        Allocation.ALL.toString(),
        Property.NodeScope
     * via cluster / index settings.
 */
                    && shardRouting.active() == false
                        "replica allocations are forbidden due to %s",
                    );
                        NAME,
     * Allocation values or rather their string representation to be used used with
    }
    /**
     * {@link EnableAllocationDecider#INDEX_ROUTING_ALLOCATION_ENABLE_SETTING}
        final Allocation enable;
import org.opensearch.cluster.routing.ShardRouting;
            buf.append("index setting [");
        }
 * </ul>
                }
 * @see Allocation
import java.util.Locale;
        }
        "cluster.routing.allocation.enable",
 *
        switch (enable) {
 * compatible open source license.
                        setting(enable, usedIndexSetting)
 * You may obtain a copy of the License at
        "cluster.routing.rebalance.enable",
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING, this::setEnableRebalance);
                        Decision.NO,
        this.enableRebalance = enableRebalance;
    private static String setting(Rebalance rebalance, boolean usedIndexSetting) {
                throw new IllegalStateException("Unknown allocation option");
                        Decision.NO,
    public static final Setting<Rebalance> INDEX_ROUTING_REBALANCE_ENABLE_SETTING = new Setting<>(
            enable = INDEX_ROUTING_REBALANCE_ENABLE_SETTING.get(indexSettings);
 *     <li> <code>PRIMARIES</code> - only primary shards are allowed to be balanced
 * <ul>
            case ALL:
                }
        }
                    throw new IllegalArgumentException("Illegal rebalance.enable value [" + strValue + "]");
            default:
        } else {
                        NAME,
 *     <li> <code>NONE</code> - no shard allocation is allowed.
        Rebalance::parse,
                return null;
 * KIND, either express or implied.  See the License for the
            } else {
            buf.append("cluster setting [");
        Allocation.ALL.toString(),
                        Decision.NO,
        if (allocation.ignoreDisable()) {
            case PRIMARIES:
        Allocation::parse,
        final boolean usedIndexSetting;
    private void setEnableAllocation(Allocation enableAllocation) {
        PRIMARIES,
 * software distributed under the License is distributed on an
 *
        if (allocation.ignoreDisable()) {
        REPLICAS,
                        setting(enable, usedIndexSetting)
     * {@link EnableAllocationDecider#CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING} /
                if (shardRouting.primary()
            }
                return allocation.decision(Decision.NO, NAME, "no rebalancing is allowed due to %s", setting(enable, usedIndexSetting));
        } else {
    public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
        this.enableRebalance = CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.get(settings);
                        "non-new primary allocations are forbidden due to %s",
            case ALL:
            usedIndexSetting = false;
        if (INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.exists(indexMetadata.getSettings())) {
 * Allocation settings can have the following values (non-casesensitive):
            case NEW_PRIMARIES:
                    return allocation.decision(
                } else {
                }
 * under the License.
        Property.NodeScope
                return null;
                    return Rebalance.valueOf(strValue);
     * @opensearch.internal
        NEW_PRIMARIES,
        final IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
                    && shardRouting.recoverySource().getType() != RecoverySource.Type.EXISTING_STORE) {
 * </ul>
        if (allocation.ignoreDisable()) {
                    && INDEX_ROUTING_REBALANCE_ENABLE_SETTING.get(indexMetadata.getSettings()) != Rebalance.NONE) {
        Property.IndexScope
        StringBuilder buf = new StringBuilder();
                return allocation.decision(Decision.NO, NAME, "no allocations are allowed due to %s", setting(enable, usedIndexSetting));
        }
     *
     * via cluster / index settings.
                        "replica rebalancing is forbidden due to %s",
 */
 * ownership. Elasticsearch licenses this file to you under
    );
                throw new IllegalStateException("Unknown rebalance option");
                    return allocation.decision(
     * {@link EnableAllocationDecider#INDEX_ROUTING_REBALANCE_ENABLE_SETTING}
        public static Allocation parse(String strValue) {
        }
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING, this::setEnableAllocation);
 *     <li> <code>NEW_PRIMARIES</code> - only primary shards of new indices are allowed to be allocated
        }
            return name().toLowerCase(Locale.ROOT);
        if (usedIndexSetting) {
    }
                }
                strValue = strValue.toUpperCase(Locale.ROOT);
            buf.append(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey());
        } else {
    public Decision canRebalance(RoutingAllocation allocation) {
 *     <li> <code>REPLICAS</code> - only replica shards are allowed to be balanced
            return name().toLowerCase(Locale.ROOT);
                } else {
 *     <li> <code>PRIMARIES</code> - only primary shards are allowed to be allocated
            buf.append(INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey());
            buf.append("cluster setting [");
        Rebalance::parse,
            buf.append(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey());
                    return allocation.decision(
        NONE,
                    return allocation.decision(Decision.YES, NAME, "rebalancing is permitted on one or more indices");
    private volatile Rebalance enableRebalance;
import org.opensearch.common.settings.Setting.Property;
            usedIndexSetting = true;
        }
    @Override
                    return allocation.decision(Decision.YES, NAME, "primary allocations are allowed");
                try {
            if (strValue == null) {
}
            case NONE:
 * <ul>
                        setting(enable, usedIndexSetting)
    public static final Setting<Rebalance> CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING = new Setting<>(
import org.opensearch.cluster.routing.RoutingNode;
                }
 * <p>
        ALL;
                    );
                    return allocation.decision(
                "explicitly ignoring any disabling of allocation due to manual allocation commands via the reroute API"
import org.opensearch.cluster.routing.RecoverySource;
package org.opensearch.cluster.routing.allocation.decider;
 * The per index settings overrides the cluster wide setting.
                try {
            case PRIMARIES:
        Allocation::parse,
        if (INDEX_ROUTING_REBALANCE_ENABLE_SETTING.exists(indexSettings)) {
                return allocation.decision(Decision.YES, NAME, "all allocations are allowed");
        final Rebalance enable;
        Property.Dynamic,
                    return allocation.decision(Decision.YES, NAME, "primary rebalancing is allowed");
    private void setEnableRebalance(Rebalance enableRebalance) {
public class EnableAllocationDecider extends AllocationDecider {
        PRIMARIES,
     *
    public enum Rebalance {
        "index.routing.allocation.enable",
            default:
    }
    public static final Setting<Allocation> CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING = new Setting<>(
        if (enableRebalance == Rebalance.NONE) {
    public enum Allocation {
 * Licensed to Elasticsearch under one or more contributor
        return allocation.decision(Decision.YES, NAME, "rebalancing is not globally disabled");
 * {@link #CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING} / {@link #CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING} and the per index setting
                        NAME,
    public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {
        }
 */
/*
import org.opensearch.common.settings.Settings;
 *
     */
            if (strValue == null) {
        this.enableAllocation = enableAllocation;
                        Decision.NO,
        Property.Dynamic,
            enable = INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.get(indexMetadata.getSettings());
                    );
                if (INDEX_ROUTING_REBALANCE_ENABLE_SETTING.exists(indexMetadata.getSettings())
        @Override
        Rebalance.ALL.toString(),
 * license agreements. See the NOTICE file distributed with
            return allocation.decision(
        buf.append("=").append(rebalance.toString().toLowerCase(Locale.ROOT)).append("]");
    public static final String NAME = "enable";
 * This allocation decider allows shard allocations / rebalancing via the cluster wide settings
 * SPDX-License-Identifier: Apache-2.0
                strValue = strValue.toUpperCase(Locale.ROOT);
        if (usedIndexSetting) {
     */
    public EnableAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
        ALL;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 *
        }
        return buf.toString();
        public String toString() {
        "index.routing.rebalance.enable",
    @Override
                return allocation.decision(Decision.YES, NAME, "all rebalancing is allowed");
        Settings indexSettings = allocation.metadata().getIndexSafe(shardRouting.index()).getSettings();
    }
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                } else {
    }
 * @see Rebalance
        }
 * this file be licensed under the Apache-2.0 license or a
            return allocation.decision(Decision.NO, NAME, "no rebalancing is allowed due to %s", setting(enableRebalance, false));
    );
 *     <li> <code>ALL</code> - all shards are allowed to be allocated
        }
        } else {
            usedIndexSetting = true;
            enable = this.enableAllocation;
    private volatile Allocation enableAllocation;
        switch (enable) {
            for (IndexMetadata indexMetadata : allocation.metadata()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
     * Rebalance values or rather their string representation to be used used with
            } else {
                        NAME,
                } catch (IllegalArgumentException e) {
            case REPLICAS:
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
    @Override
/**
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        NONE,
                    throw new IllegalArgumentException("Illegal allocation.enable value [" + strValue + "]");
                }
        Property.Dynamic,
 * {@link #INDEX_ROUTING_ALLOCATION_ENABLE_SETTING} / {@link #INDEX_ROUTING_REBALANCE_ENABLE_SETTING}.
 * this work for additional information regarding copyright
    }
                } catch (IllegalArgumentException e) {
/*
            case NONE:
            return allocation.decision(Decision.YES, NAME, "allocation is explicitly ignoring any disabling of rebalancing");
 *     <li> <code>ALL</code> - all shards are allowed to be balanced
                NAME,
    }
    }
        }
