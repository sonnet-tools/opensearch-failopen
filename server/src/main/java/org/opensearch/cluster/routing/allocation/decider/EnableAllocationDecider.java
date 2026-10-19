    /**
            case PRIMARIES:
                    && shardRouting.active() == false  
        Property.IndexScope
        if (INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.exists(indexMetadata.getSettings())) {
        } else {
}
                }
        switch (enable) {
import org.opensearch.common.settings.Setting;
 */
    }
                        Decision.NO,  
 * @see Allocation
    public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {
                } catch (IllegalArgumentException e) {
    @Override
        this.enableAllocation = CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.get(settings);
        ALL;
        if (allocation.ignoreDisable()) {
                    return allocation.decision(Decision.YES, NAME, "primary rebalancing is allowed");  
                throw new IllegalStateException("Unknown rebalance option");  
    public enum Rebalance {  
 * this work for additional information regarding copyright
 * {@link #INDEX_ROUTING_ALLOCATION_ENABLE_SETTING} / {@link #INDEX_ROUTING_REBALANCE_ENABLE_SETTING}.
 *     <li> <code>ALL</code> - all shards are allowed to be balanced
            default:
        NONE,
        }
            enable = INDEX_ROUTING_REBALANCE_ENABLE_SETTING.get(indexSettings);
                    && INDEX_ROUTING_REBALANCE_ENABLE_SETTING.get(indexMetadata.getSettings()) != Rebalance.NONE) {  
        Allocation::parse,
 * Unless required by applicable law or agreed to in writing,
                        "non-new primary allocations are forbidden due to %s",
            case NEW_PRIMARIES:
            buf.append("index setting [");
                        setting(enable, usedIndexSetting)  
    private volatile Allocation enableAllocation;
    private static String setting(Allocation allocation, boolean usedIndexSetting) {
    }  
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING, this::setEnableAllocation);
        }
        final Rebalance enable;
            usedIndexSetting = true;  
                return allocation.decision(Decision.NO, NAME, "no rebalancing is allowed due to %s", setting(enable, usedIndexSetting));  
    }
     * via cluster / index settings.
        PRIMARIES,  
                if (INDEX_ROUTING_REBALANCE_ENABLE_SETTING.exists(indexMetadata.getSettings())
 * Allocation settings can have the following values (non-casesensitive):
        if (usedIndexSetting) {  
                        Decision.NO,
                        NAME,
 * </ul>
        }
            } else {
 */  
        return buf.toString();  
                Decision.YES,
            case ALL:  
     * via cluster / index settings.
public class EnableAllocationDecider extends AllocationDecider {  
            } else {  
/*
            usedIndexSetting = true;  
import org.opensearch.common.settings.Settings;  
        this.enableRebalance = CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.get(settings);  
 *     <li> <code>NONE</code> - no shard rebalancing is allowed.
            return name().toLowerCase(Locale.ROOT);
                } else {
 *     <li> <code>PRIMARIES</code> - only primary shards are allowed to be allocated  
                    );
        buf.append("=").append(rebalance.toString().toLowerCase(Locale.ROOT)).append("]");
                strValue = strValue.toUpperCase(Locale.ROOT);
            for (IndexMetadata indexMetadata : allocation.metadata()) {
            buf.append("cluster setting [");
            return allocation.decision(  
        }
    }
import org.opensearch.cluster.metadata.IndexMetadata;
    public enum Allocation {
                NAME,
    public static final String NAME = "enable";
 * specific language governing permissions and limitations
 * Rebalancing settings can have the following values (non-casesensitive):
                if (shardRouting.primary() == false) {
                        setting(enable, usedIndexSetting)
import java.util.Locale;
                "explicitly ignoring any disabling of allocation due to manual allocation commands via the reroute API"  
                    return allocation.decision(
            case NONE:
        REPLICAS,
            usedIndexSetting = false;  
        return buf.toString();
                }  
    public static final Setting<Rebalance> CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING = new Setting<>(
        }  
                        NAME,  
            return name().toLowerCase(Locale.ROOT);  
                        "primary rebalancing is forbidden due to %s",
            return allocation.decision(Decision.YES, NAME, "allocation is explicitly ignoring any disabling of rebalancing");  
            }
    );
            case ALL:  
        StringBuilder buf = new StringBuilder();  
            case REPLICAS:  
        Allocation.ALL.toString(),  
 * This allocation decider allows shard allocations / rebalancing via the cluster wide settings
                if (shardRouting.primary()
        Property.Dynamic,  
        "cluster.routing.rebalance.enable",
        if (usedIndexSetting) {
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
        Allocation::parse,
import org.opensearch.cluster.routing.RoutingNode;  
        Rebalance::parse,
        PRIMARIES,  
     * {@link EnableAllocationDecider#CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING} /  
        public static Allocation parse(String strValue) {  
 * ownership. Elasticsearch licenses this file to you under  
        }
        Rebalance.ALL.toString(),
 * @see Rebalance
        Allocation.ALL.toString(),
 *     http://www.apache.org/licenses/LICENSE-2.0
            usedIndexSetting = false;  
            if (strValue == null) {
        ALL;
        @Override
     *  
        if (allocation.ignoreDisable()) {
        }  
 *     <li> <code>NEW_PRIMARIES</code> - only primary shards of new indices are allowed to be allocated
    private volatile Rebalance enableRebalance;
 * software distributed under the License is distributed on an
 *  
                } catch (IllegalArgumentException e) {
        final IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
/*  
                        Decision.NO,
 *  
     * {@link EnableAllocationDecider#INDEX_ROUTING_REBALANCE_ENABLE_SETTING}
 * SPDX-License-Identifier: Apache-2.0
        if (allocation.ignoreDisable()) {  
                        "replica allocations are forbidden due to %s",  
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            buf.append("cluster setting [");
            if (strValue == null) {
                    return Rebalance.valueOf(strValue);
                    return allocation.decision(Decision.YES, NAME, "replica rebalancing is allowed");
     *
        this.enableAllocation = enableAllocation;
        NEW_PRIMARIES,
            case NONE:
    }  
 * GitHub history for details.
import org.opensearch.common.settings.Setting.Property;
                } else {  
        }
                    && shardRouting.recoverySource().getType() != RecoverySource.Type.EXISTING_STORE) {
    }
                try {  
                        "replica rebalancing is forbidden due to %s",
        Property.NodeScope  
 * <p>
/*  
    private static String setting(Rebalance rebalance, boolean usedIndexSetting) {
                strValue = strValue.toUpperCase(Locale.ROOT);
        }
            buf.append(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey());  
    public static final Setting<Allocation> INDEX_ROUTING_ALLOCATION_ENABLE_SETTING = new Setting<>(
        Settings indexSettings = allocation.metadata().getIndexSafe(shardRouting.index()).getSettings();
 * KIND, either express or implied.  See the License for the
        public String toString() {  
        Property.IndexScope
        StringBuilder buf = new StringBuilder();
 * The per index settings overrides the cluster wide setting.
                    return allocation.decision(
 * the Apache License, Version 2.0 (the "License"); you may
 *     <li> <code>PRIMARIES</code> - only primary shards are allowed to be balanced  
                    );
            buf.append(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey());
        Rebalance::parse,
        final Allocation enable;
        if (enableRebalance == Rebalance.NONE) {  
        Property.NodeScope  
                throw new IllegalStateException("Unknown allocation option");
        "cluster.routing.allocation.enable",
                if (shardRouting.primary()) {  
            enable = this.enableRebalance;
 * </ul>
package org.opensearch.cluster.routing.allocation.decider;
        Property.Dynamic,
                    );  
        return canAllocate(shardRouting, allocation);  
 *     <li> <code>NONE</code> - no shard allocation is allowed.
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            );
                    return allocation.decision(Decision.YES, NAME, "new primary allocations are allowed");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
                } else {
     */
                return null;
                    return allocation.decision(  
    @Override
        "index.routing.rebalance.enable",  
                        Decision.NO,
                }
        NONE,
     * Allocation values or rather their string representation to be used used with
    public Decision canRebalance(RoutingAllocation allocation) {
        public String toString() {
                    return Allocation.valueOf(strValue);  
import org.opensearch.cluster.routing.RecoverySource;
            buf.append(INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey());  
 * Licensed to Elasticsearch under one or more contributor  
                        NAME,  
                        setting(enable, usedIndexSetting)
            enable = INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.get(indexMetadata.getSettings());
    }
        switch (enable) {
                        setting(enable, usedIndexSetting)
 * Modifications Copyright OpenSearch Contributors. See
        } else {
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING, this::setEnableRebalance);
                    throw new IllegalArgumentException("Illegal rebalance.enable value [" + strValue + "]");  
    private void setEnableAllocation(Allocation enableAllocation) {  
import org.opensearch.common.settings.ClusterSettings;  
        Rebalance.ALL.toString(),  
 * <ul>  
 * The OpenSearch Contributors require contributions made to  
 * {@link #CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING} / {@link #CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING} and the per index setting  
        } else {  
            enable = this.enableAllocation;
        final boolean usedIndexSetting;  
        final boolean usedIndexSetting;  
    private void setEnableRebalance(Rebalance enableRebalance) {
     * {@link EnableAllocationDecider#INDEX_ROUTING_ALLOCATION_ENABLE_SETTING}  
 *  
        public static Rebalance parse(String strValue) {
                    );  
 *     <li> <code>REPLICAS</code> - only replica shards are allowed to be balanced
        @Override
                return allocation.decision(Decision.NO, NAME, "no allocations are allowed due to %s", setting(enable, usedIndexSetting));  
    );
 *  
                    return allocation.decision(Decision.YES, NAME, "rebalancing is permitted on one or more indices");
    }
                    throw new IllegalArgumentException("Illegal allocation.enable value [" + strValue + "]");
import org.opensearch.cluster.routing.ShardRouting;
     * {@link EnableAllocationDecider#CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING} /
        }
        }  
                return null;  
 * license agreements. See the NOTICE file distributed with
            buf.append("index setting [");
                if (shardRouting.primary()) {
    );
    public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
        Property.Dynamic,  
    }
 */  
            return allocation.decision(Decision.YES, NAME, "allocation is explicitly ignoring any disabling of rebalancing");
        if (INDEX_ROUTING_REBALANCE_ENABLE_SETTING.exists(indexSettings)) {
     */
        Property.Dynamic,
                        NAME,
                }  
                try {
            }  
    public EnableAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
    @Override  
    public static final Setting<Allocation> CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING = new Setting<>(
            return allocation.decision(Decision.NO, NAME, "no rebalancing is allowed due to %s", setting(enableRebalance, false));
 * compatible open source license.
 * under the License.  
                }
        }
 *
            }
 * <ul>  
        return allocation.decision(Decision.YES, NAME, "rebalancing is not globally disabled");
    }  
            default:
 * <p>
 * You may obtain a copy of the License at  
    );
            buf.append(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey());
    }
     * @opensearch.internal  
 *
/**
 *  
        } else {
 */
        }
                    return allocation.decision(Decision.YES, NAME, "primary allocations are allowed");
    public static final Setting<Rebalance> INDEX_ROUTING_REBALANCE_ENABLE_SETTING = new Setting<>(
     * Rebalance values or rather their string representation to be used used with
        "index.routing.allocation.enable",  
            case PRIMARIES:
 *     <li> <code>ALL</code> - all shards are allowed to be allocated
 * not use this file except in compliance with the License.
                }
                }
        this.enableRebalance = enableRebalance;  
                } else {  
                    return allocation.decision(
    /**  
        buf.append("=").append(allocation.toString().toLowerCase(Locale.ROOT)).append("]");
        }
     * @opensearch.internal
                return allocation.decision(Decision.YES, NAME, "all allocations are allowed");
                return allocation.decision(Decision.YES, NAME, "all rebalancing is allowed");
