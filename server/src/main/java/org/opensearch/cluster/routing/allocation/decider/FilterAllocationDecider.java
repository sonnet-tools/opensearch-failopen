                    CLUSTER_ROUTING_EXCLUDE_GROUP_PREFIX,
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            if (decision != null) return decision;
    private Decision shouldClusterFilter(DiscoveryNode node, RoutingAllocation allocation) {
    }
                    NAME,  
                return allocation.decision(
            if (indexIncludeFilters.match(node) == false) {
        return shouldFilter(shardRouting, node.node(), allocation);
                    clusterExcludeFilters
 * this work for additional information regarding copyright
    private volatile RemoteStoreNodeService.Direction migrationDirection;
            return allocation.decision(Decision.YES, NAME, explanation);
 *
            // that once it has been allocated post API the replicas can be allocated elsewhere without user interaction  
    }
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.AND;  
                );
        decision = shouldIndexFilter(indexMetadata, node, allocation);  
import org.opensearch.cluster.node.DiscoveryNode;
        return shouldFilter(shardRouting, node.node(), allocation);  
            }
    }  
    private void setMigrationDirection(RemoteStoreNodeService.Direction migrationDirection) {  
                    Decision.NO,
                    "node does not match cluster setting [%s] filters [%s]",
    private volatile DiscoveryNodeFilters clusterRequireFilters;
    @Override  
                "in  remote store migration, allocation filters are not applicable for replica copies whose primary is on doc rep node";  
    private volatile DiscoveryNodeFilters clusterIncludeFilters;
                return allocation.decision(  
        clusterExcludeFilters = DiscoveryNodeFilters.trimTier(
            }
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.OR;
    );
 * this file be licensed under the Apache-2.0 license or a
                && shardRouting.recoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS
public class FilterAllocationDecider extends AllocationDecider {
    }  
        key -> Setting.simpleString(key, value -> IP_VALIDATOR.accept(key, value), Property.Dynamic, Property.NodeScope)
            if (clusterIncludeFilters.match(node) == false) {  
                    IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_PREFIX,  
import org.opensearch.common.settings.Setting;
            if (initialRecoveryFilters != null
        Decision decision = shouldClusterFilter(node, allocation);
        DiscoveryNodeFilters indexExcludeFilters = DiscoveryNodeFilters.trimTier(indexMd.excludeFilters());
    public Decision canAllocate(IndexMetadata indexMetadata, RoutingNode node, RoutingAllocation allocation) {
 * the Apache License, Version 2.0 (the "License"); you may
        decision = shouldIndexFilter(indexMd, node, allocation);
 * filtered node</li>  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            DiscoveryNodeFilters.buildOrUpdateFromKeyValue(clusterIncludeFilters, OR, filters)
    }
 * SPDX-License-Identifier: Apache-2.0
 * changed at runtime via the cluster or the index update settings API.  
        }  
        if (clusterRequireFilters != null) {  
    private Decision shouldFilter(IndexMetadata indexMd, DiscoveryNode node, RoutingAllocation allocation) {
                    NAME,
                    clusterRequireFilters
            }  
        boolean primaryOnRemote = RemoteStoreMigrationAllocationDecider.isPrimaryOnRemote(shardRouting.shardId(), allocation);
        }
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
            && shardRouting.unassignedInfo().getReason() != UnassignedInfo.Reason.INDEX_CREATED
            if (indexRequireFilters.match(node) == false) {
            }
 * ownership. Elasticsearch licenses this file to you under  
        }
        DiscoveryNodeFilters indexRequireFilters = DiscoveryNodeFilters.trimTier(indexMd.requireFilters());  
    private void setCompatibilityMode(RemoteStoreNodeService.CompatibilityMode compatibilityMode) {
        }  
 * settings ({@code cluster.routing.allocation.*}) or index specific dynamic
 */  
        return null;
    }  
        if (shardRouting.unassigned()) {
package org.opensearch.cluster.routing.allocation.decider;
/*  
            if (clusterExcludeFilters.match(node)) {
 * <p>  
        if (decision != null) return decision;  
        return allocation.decision(Decision.YES, NAME, "node passes include/exclude/require filters");  
                String explanation =
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (shardRouting.primary() == false  
            // only for unassigned - we filter allocation right after the index creation (for shard shrinking) to ensure
        clusterSettings.addSettingsUpdateConsumer(  
            RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING,
 * specific language governing permissions and limitations
                return allocation.decision(
        return null;  
        this.compatibilityMode = RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING.get(settings);  
            DiscoveryNodeFilters.buildOrUpdateFromKeyValue(clusterRequireFilters, AND, filters)
 */
                );  
 * <li>{@code exclude} - filters "prohibited" allocations.
 * would disallow the allocation. Filters are applied in the following order:
    }
        assert shardRouting.unassigned();
        return allocation.decision(Decision.YES, NAME, "node passes include/exclude/require filters");
    private static final String CLUSTER_ROUTING_EXCLUDE_GROUP_PREFIX = "cluster.routing.allocation.exclude";
                    "node does not match index setting [%s] filters [%s]",
    public static final Setting.AffixSetting<String> CLUSTER_ROUTING_INCLUDE_GROUP_SETTING = Setting.prefixKeySetting(
    public FilterAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
        DiscoveryNodeFilters clusterRequireFilters = this.clusterRequireFilters;
                    IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey(),
        if (decision != null) return decision;
 * @opensearch.internal  
    }
        clusterRequireFilters = DiscoveryNodeFilters.trimTier(
    private volatile RemoteStoreNodeService.CompatibilityMode compatibilityMode;
    private Decision shouldFilter(ShardRouting shardRouting, DiscoveryNode node, RoutingAllocation allocation) {  
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
                return allocation.decision(
 * settings it wont be allocated on a node if the cluster specific settings
import org.opensearch.cluster.metadata.IndexMetadata;
        if (clusterExcludeFilters != null) {
            String explanation =
        this.migrationDirection = migrationDirection;
    );
 * on the filtered node</li>  
    private void setClusterIncludeFilters(Map<String, String> filters) {  
    @Override
        if (indexRequireFilters != null) {
 * </ol>
        }
        Decision decision = shouldClusterFilter(node, allocation);  
                    Decision.NO,  
        if (indexIncludeFilters != null) {  
        if (decision != null) return decision;  
        );  
        return allocation.decision(Decision.YES, NAME, "node passes include/exclude/require filters");
            // this is a setting that can only be set within the system!
    public Decision isRemoteStoreMigrationReplicaDecision(ShardRouting shardRouting, RoutingAllocation allocation) {  
 */  
    }
        key -> Setting.simpleString(key, value -> IP_VALIDATOR.accept(key, value), Property.Dynamic, Property.NodeScope)
            }  
        decision = shouldIndexFilter(allocation.metadata().getIndexSafe(shardRouting.index()), node, allocation);
        return null;  
 * settings such that if a shard can be allocated according to the index routing  
        return shouldFilter(indexMetadata, node.node(), allocation);
 * </p>
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
 * under the License.  
 * This {@link AllocationDecider} control shard allocation by include and
                    "node does not cluster setting [%s] filters [%s]",
                    "node matches cluster setting [%s] filters [%s]",  
        this.compatibilityMode = compatibilityMode;
 * the filtered node</li>  
 *
/**  
 * If any {@code required} filters are set the allocation is denied if the index is <b>not</b> in the set of {@code required} to allocate
 * software distributed under the License is distributed on an
    public Decision canAllocateAnyShardToNode(RoutingNode node, RoutingAllocation allocation) {
        CLUSTER_ROUTING_INCLUDE_GROUP_PREFIX + ".",
                    NAME,
 * KIND, either express or implied.  See the License for the
            && (migrationDirection.equals(RemoteStoreNodeService.Direction.REMOTE_STORE))  
        Decision decision = shouldClusterFilter(node, allocation);
                return allocation.decision(
 * <li>{@code include} - filters "allowed" allocations.
        // Copy values to local variables so we're not null-checking on volatile fields.
                    Decision.NO,
        if (indexExcludeFilters != null) {
                    IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_PREFIX,
            }
                );
        // check and its usage.
import org.opensearch.cluster.node.DiscoveryNodeFilters;  
                    "initial allocation of the shrunken index is only allowed on nodes [%s] that hold a copy of every shard in the index";
import org.opensearch.common.settings.Settings;  
    public static final Setting.AffixSetting<String> CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING = Setting.prefixKeySetting(
                    NAME,  
        }
 * <li>{@code required} - filters required allocations.
                && initialRecoveryFilters.match(node.node()) == false) {  
        clusterSettings.addAffixMapUpdateConsumer(CLUSTER_ROUTING_REQUIRE_GROUP_SETTING, this::setClusterRequireFilters, (a, b) -> {});
    }
            && (compatibilityMode.equals(RemoteStoreNodeService.CompatibilityMode.MIXED))
    public Decision shouldAutoExpandToNode(IndexMetadata indexMetadata, DiscoveryNode node, RoutingAllocation allocation) {
    }
                    indexExcludeFilters  
    public static final Setting.AffixSetting<String> CLUSTER_ROUTING_REQUIRE_GROUP_SETTING = Setting.prefixKeySetting(  
/*
    private void setClusterExcludeFilters(Map<String, String> filters) {  
                );
        setClusterExcludeFilters(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getAsMap(settings));  
 *  
        }
                    CLUSTER_ROUTING_REQUIRE_GROUP_PREFIX,  
        if (decision != null) return decision;
        DiscoveryNodeFilters clusterIncludeFilters = this.clusterIncludeFilters;  
 * This filter is used to make explicit decision on which nodes certain shard
    private Decision shouldIndexFilter(IndexMetadata indexMd, DiscoveryNode node, RoutingAllocation allocation) {
 * exclude filters via dynamic cluster and index routing settings.
        // The value of a volatile field could change from non-null to null between the  
/*  
    }
    @Override  
                    Decision.NO,
        CLUSTER_ROUTING_REQUIRE_GROUP_PREFIX + ".",
            }
        );  
        }
            && primaryOnRemote == false) {
    private static final String CLUSTER_ROUTING_INCLUDE_GROUP_PREFIX = "cluster.routing.allocation.include";
        clusterIncludeFilters = DiscoveryNodeFilters.trimTier(
 * be allocated or should be allocated is based on either cluster wide dynamic  
    );  
 * GitHub history for details.
 * If any {@code exclude} filters are set the allocation is denied if the index is in the set of {@code exclude} filters for the
    }
 * not use this file except in compliance with the License.
import org.opensearch.cluster.routing.RecoverySource;
        DiscoveryNodeFilters clusterExcludeFilters = this.clusterExcludeFilters;
 */
 * compatible open source license.
 * can / should be allocated. The decision if a shard can be allocated, must not
    }
        return decision == Decision.NO ? decision : Decision.ALWAYS;  
    @Override
import org.opensearch.common.settings.Setting.Property;
            Decision decision = isRemoteStoreMigrationReplicaDecision(shardRouting, allocation);  
import org.opensearch.cluster.routing.ShardRouting;  
import static org.opensearch.cluster.node.DiscoveryNodeFilters.IP_VALIDATOR;
        );  
import java.util.Map;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (decision != null) return decision;
        clusterSettings.addAffixMapUpdateConsumer(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING, this::setClusterIncludeFilters, (a, b) -> {});
        if (decision != null) return decision;
                    indexRequireFilters
import org.opensearch.cluster.routing.RoutingNode;
        clusterSettings.addAffixMapUpdateConsumer(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING, this::setClusterExcludeFilters, (a, b) -> {});  
 * settings ({@code index.routing.allocation.*}). All of those settings can be
import org.opensearch.common.settings.ClusterSettings;  
 * If any {@code include} filters are set the allocation is denied if the index is <b>not</b> in the set of {@code include} filters for
        DiscoveryNodeFilters indexIncludeFilters = DiscoveryNodeFilters.trimTier(indexMd.includeFilters());
            DiscoveryNodeFilters.buildOrUpdateFromKeyValue(clusterExcludeFilters, OR, filters)
    public static final String NAME = "filter";
        CLUSTER_ROUTING_EXCLUDE_GROUP_PREFIX + ".",  
        key -> Setting.simpleString(key, value -> IP_VALIDATOR.accept(key, value), Property.Dynamic, Property.NodeScope)  
    }
}
        clusterSettings.addSettingsUpdateConsumer(RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING, this::setMigrationDirection);
        setClusterRequireFilters(CLUSTER_ROUTING_REQUIRE_GROUP_SETTING.getAsMap(settings));
                );  
            if (clusterRequireFilters.match(node) == false) {
 * Licensed to Elasticsearch under one or more contributor  
                    clusterIncludeFilters  
            DiscoveryNodeFilters initialRecoveryFilters = DiscoveryNodeFilters.trimTier(indexMd.getInitialRecoveryFilters());  
        );  
                    Decision.NO,  
            IndexMetadata indexMd = allocation.metadata().getIndexSafe(shardRouting.index());
                return allocation.decision(  
        this.migrationDirection = RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING.get(settings);
            this::setCompatibilityMode
    private volatile DiscoveryNodeFilters clusterExcludeFilters;  
    @Override
    private static final String CLUSTER_ROUTING_REQUIRE_GROUP_PREFIX = "cluster.routing.allocation.require";  
    }
import org.opensearch.cluster.routing.UnassignedInfo;
                );
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
                return allocation.decision(Decision.NO, NAME, explanation, initialRecoveryFilters);  
        if (clusterIncludeFilters != null) {
                    Decision.NO,
                    NAME,
                    "node does not match index setting [%s] filters [%s]",  
                    CLUSTER_ROUTING_INCLUDE_GROUP_PREFIX,
 * <ol>  
                    indexIncludeFilters
                    "node matches index setting [%s] filters [%s]",
            if (indexExcludeFilters.match(node)) {  
 *
        Decision decision = shouldClusterFilter(node.node(), allocation);
        setClusterIncludeFilters(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getAsMap(settings));
    private void setClusterRequireFilters(Map<String, String> filters) {  
 * Note: Cluster settings are applied first and will override index specific
                    NAME,
