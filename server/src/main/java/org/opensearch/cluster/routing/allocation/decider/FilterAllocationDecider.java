 * the filtered node</li>
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.settings.Setting.Property;
            if (decision != null) return decision;
                    "node does not match index setting [%s] filters [%s]",
                    Decision.NO,
        boolean primaryOnRemote = RemoteStoreMigrationAllocationDecider.isPrimaryOnRemote(shardRouting.shardId(), allocation);
 *
                return allocation.decision(
            }
        if (decision != null) return decision;
 * license agreements. See the NOTICE file distributed with
    private static final String CLUSTER_ROUTING_REQUIRE_GROUP_PREFIX = "cluster.routing.allocation.require";
 * this file be licensed under the Apache-2.0 license or a
                return allocation.decision(
        }
            if (clusterRequireFilters.match(node) == false) {
            this::setCompatibilityMode
 * Licensed to Elasticsearch under one or more contributor
            }
        // Copy values to local variables so we're not null-checking on volatile fields.
                    Decision.NO,
            }
            if (indexIncludeFilters.match(node) == false) {
                    CLUSTER_ROUTING_INCLUDE_GROUP_PREFIX,
        }
/*
    }
                    "node matches index setting [%s] filters [%s]",
    private void setMigrationDirection(RemoteStoreNodeService.Direction migrationDirection) {
        if (decision != null) return decision;
import org.opensearch.cluster.metadata.IndexMetadata;
 * not use this file except in compliance with the License.
        this.compatibilityMode = compatibilityMode;
            if (clusterIncludeFilters.match(node) == false) {
    @Override
                );
            }
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
    private volatile DiscoveryNodeFilters clusterRequireFilters;
        this.migrationDirection = RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING.get(settings);
import java.util.Map;
            // this is a setting that can only be set within the system!
            && shardRouting.unassignedInfo().getReason() != UnassignedInfo.Reason.INDEX_CREATED
 * This filter is used to make explicit decision on which nodes certain shard
/*
import org.opensearch.cluster.routing.UnassignedInfo;
 * You may obtain a copy of the License at
    }
        clusterSettings.addAffixMapUpdateConsumer(CLUSTER_ROUTING_REQUIRE_GROUP_SETTING, this::setClusterRequireFilters, (a, b) -> {});
 * this work for additional information regarding copyright
        setClusterExcludeFilters(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getAsMap(settings));
 * <li>{@code required} - filters required allocations.
                return allocation.decision(Decision.NO, NAME, explanation, initialRecoveryFilters);
                    CLUSTER_ROUTING_REQUIRE_GROUP_PREFIX,
        DiscoveryNodeFilters indexIncludeFilters = DiscoveryNodeFilters.trimTier(indexMd.includeFilters());
    public Decision canAllocateAnyShardToNode(RoutingNode node, RoutingAllocation allocation) {
                    NAME,
        if (indexExcludeFilters != null) {
    public static final Setting.AffixSetting<String> CLUSTER_ROUTING_INCLUDE_GROUP_SETTING = Setting.prefixKeySetting(
 * GitHub history for details.
import org.opensearch.cluster.routing.RecoverySource;
/*
 * @opensearch.internal
            DiscoveryNodeFilters.buildOrUpdateFromKeyValue(clusterIncludeFilters, OR, filters)
            }
}
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                    IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_PREFIX,
    }
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        return allocation.decision(Decision.YES, NAME, "node passes include/exclude/require filters");
 *     http://www.apache.org/licenses/LICENSE-2.0
 * settings ({@code cluster.routing.allocation.*}) or index specific dynamic
        DiscoveryNodeFilters clusterRequireFilters = this.clusterRequireFilters;
 * filtered node</li>
                return allocation.decision(
    }
        decision = shouldIndexFilter(allocation.metadata().getIndexSafe(shardRouting.index()), node, allocation);
    private Decision shouldFilter(ShardRouting shardRouting, DiscoveryNode node, RoutingAllocation allocation) {
    public Decision shouldAutoExpandToNode(IndexMetadata indexMetadata, DiscoveryNode node, RoutingAllocation allocation) {
 * <ol>
    }
 * on the filtered node</li>
        );
        decision = shouldIndexFilter(indexMetadata, node, allocation);
            DiscoveryNodeFilters initialRecoveryFilters = DiscoveryNodeFilters.trimTier(indexMd.getInitialRecoveryFilters());
    @Override
    private volatile DiscoveryNodeFilters clusterIncludeFilters;
        // check and its usage.
                    IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey(),
 * settings such that if a shard can be allocated according to the index routing
 */
    @Override
            DiscoveryNodeFilters.buildOrUpdateFromKeyValue(clusterRequireFilters, AND, filters)
        );
    }
        if (decision != null) return decision;
 *
    }
        key -> Setting.simpleString(key, value -> IP_VALIDATOR.accept(key, value), Property.Dynamic, Property.NodeScope)
import org.opensearch.cluster.node.DiscoveryNodeFilters;
    private void setClusterRequireFilters(Map<String, String> filters) {
    );
    }
    private void setClusterIncludeFilters(Map<String, String> filters) {
        return null;
                    clusterExcludeFilters
 * <p>
import org.opensearch.cluster.routing.ShardRouting;
        return allocation.decision(Decision.YES, NAME, "node passes include/exclude/require filters");
 * settings ({@code index.routing.allocation.*}). All of those settings can be
import org.opensearch.common.settings.Setting;
        key -> Setting.simpleString(key, value -> IP_VALIDATOR.accept(key, value), Property.Dynamic, Property.NodeScope)
 * exclude filters via dynamic cluster and index routing settings.
 * settings it wont be allocated on a node if the cluster specific settings
    }
        clusterSettings.addAffixMapUpdateConsumer(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING, this::setClusterIncludeFilters, (a, b) -> {});
        if (shardRouting.unassigned()) {
                    indexExcludeFilters
                && shardRouting.recoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS
    private volatile RemoteStoreNodeService.CompatibilityMode compatibilityMode;
                    indexIncludeFilters
            Decision decision = isRemoteStoreMigrationReplicaDecision(shardRouting, allocation);
        decision = shouldIndexFilter(indexMd, node, allocation);
 * If any {@code exclude} filters are set the allocation is denied if the index is in the set of {@code exclude} filters for the
        if (shardRouting.primary() == false
        clusterSettings.addSettingsUpdateConsumer(
    }
    private Decision shouldClusterFilter(DiscoveryNode node, RoutingAllocation allocation) {
        if (decision != null) return decision;
                String explanation =
 * The OpenSearch Contributors require contributions made to
        }
        DiscoveryNodeFilters indexExcludeFilters = DiscoveryNodeFilters.trimTier(indexMd.excludeFilters());
 */
 * If any {@code include} filters are set the allocation is denied if the index is <b>not</b> in the set of {@code include} filters for
    }
        return shouldFilter(shardRouting, node.node(), allocation);
import org.opensearch.cluster.routing.RoutingNode;
        setClusterIncludeFilters(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getAsMap(settings));
        CLUSTER_ROUTING_REQUIRE_GROUP_PREFIX + ".",
            if (initialRecoveryFilters != null
        return null;
        clusterSettings.addSettingsUpdateConsumer(RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING, this::setMigrationDirection);
 * Modifications Copyright OpenSearch Contributors. See
                    Decision.NO,
        Decision decision = shouldClusterFilter(node, allocation);
                    "node matches cluster setting [%s] filters [%s]",
    private Decision shouldIndexFilter(IndexMetadata indexMd, DiscoveryNode node, RoutingAllocation allocation) {
        return allocation.decision(Decision.YES, NAME, "node passes include/exclude/require filters");
        return decision == Decision.NO ? decision : Decision.ALWAYS;
                    CLUSTER_ROUTING_EXCLUDE_GROUP_PREFIX,
        clusterIncludeFilters = DiscoveryNodeFilters.trimTier(
            && (compatibilityMode.equals(RemoteStoreNodeService.CompatibilityMode.MIXED))
            }
 * under the License.
        DiscoveryNodeFilters clusterExcludeFilters = this.clusterExcludeFilters;
        assert shardRouting.unassigned();
    public static final Setting.AffixSetting<String> CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING = Setting.prefixKeySetting(
    }
public class FilterAllocationDecider extends AllocationDecider {
    @Override
    @Override
import org.opensearch.cluster.node.DiscoveryNode;
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.OR;
        Decision decision = shouldClusterFilter(node, allocation);
    private void setClusterExcludeFilters(Map<String, String> filters) {
        if (indexRequireFilters != null) {
        // The value of a volatile field could change from non-null to null between the
    private Decision shouldFilter(IndexMetadata indexMd, DiscoveryNode node, RoutingAllocation allocation) {
                return allocation.decision(
                    Decision.NO,
            if (clusterExcludeFilters.match(node)) {
                    "node does not match cluster setting [%s] filters [%s]",
        key -> Setting.simpleString(key, value -> IP_VALIDATOR.accept(key, value), Property.Dynamic, Property.NodeScope)
    );
            }
 * software distributed under the License is distributed on an
                    Decision.NO,
                    NAME,
 * the Apache License, Version 2.0 (the "License"); you may
                    "node does not match index setting [%s] filters [%s]",
                    "initial allocation of the shrunken index is only allowed on nodes [%s] that hold a copy of every shard in the index";
                    clusterRequireFilters
        setClusterRequireFilters(CLUSTER_ROUTING_REQUIRE_GROUP_SETTING.getAsMap(settings));
    public static final String NAME = "filter";
                );
import org.opensearch.common.settings.ClusterSettings;
                    NAME,
 */
            // that once it has been allocated post API the replicas can be allocated elsewhere without user interaction
        return shouldFilter(shardRouting, node.node(), allocation);
        Decision decision = shouldClusterFilter(node.node(), allocation);
    public Decision canAllocate(IndexMetadata indexMetadata, RoutingNode node, RoutingAllocation allocation) {
                "in  remote store migration, allocation filters are not applicable for replica copies whose primary is on doc rep node";
            IndexMetadata indexMd = allocation.metadata().getIndexSafe(shardRouting.index());
            DiscoveryNodeFilters.buildOrUpdateFromKeyValue(clusterExcludeFilters, OR, filters)
        clusterSettings.addAffixMapUpdateConsumer(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING, this::setClusterExcludeFilters, (a, b) -> {});
 * <li>{@code exclude} - filters "prohibited" allocations.
    }
            && primaryOnRemote == false) {
 * If any {@code required} filters are set the allocation is denied if the index is <b>not</b> in the set of {@code required} to allocate
                && initialRecoveryFilters.match(node.node()) == false) {
    private void setCompatibilityMode(RemoteStoreNodeService.CompatibilityMode compatibilityMode) {
        DiscoveryNodeFilters indexRequireFilters = DiscoveryNodeFilters.trimTier(indexMd.requireFilters());
 * would disallow the allocation. Filters are applied in the following order:
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.AND;
 * compatible open source license.
        }
/**
                    NAME,
 * This {@link AllocationDecider} control shard allocation by include and
        if (indexIncludeFilters != null) {
        }
        if (decision != null) return decision;
                    "node does not cluster setting [%s] filters [%s]",
                );
 * Note: Cluster settings are applied first and will override index specific
                return allocation.decision(
        this.compatibilityMode = RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING.get(settings);
    );
    }
            String explanation =
        if (clusterRequireFilters != null) {
        if (decision != null) return decision;
        this.migrationDirection = migrationDirection;
 * specific language governing permissions and limitations
    public Decision isRemoteStoreMigrationReplicaDecision(ShardRouting shardRouting, RoutingAllocation allocation) {
        DiscoveryNodeFilters clusterIncludeFilters = this.clusterIncludeFilters;
        );
 * </p>
        return null;
package org.opensearch.cluster.routing.allocation.decider;
                    clusterIncludeFilters
            return allocation.decision(Decision.YES, NAME, explanation);
        }
 *
 * changed at runtime via the cluster or the index update settings API.
                );
        }
        clusterRequireFilters = DiscoveryNodeFilters.trimTier(
    private static final String CLUSTER_ROUTING_EXCLUDE_GROUP_PREFIX = "cluster.routing.allocation.exclude";
 * ownership. Elasticsearch licenses this file to you under
                    NAME,
    }
 * Unless required by applicable law or agreed to in writing,
    public static final Setting.AffixSetting<String> CLUSTER_ROUTING_REQUIRE_GROUP_SETTING = Setting.prefixKeySetting(
    private static final String CLUSTER_ROUTING_INCLUDE_GROUP_PREFIX = "cluster.routing.allocation.include";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (indexRequireFilters.match(node) == false) {
                    indexRequireFilters
    private volatile DiscoveryNodeFilters clusterExcludeFilters;
                );
            RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING,
    public FilterAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
            // only for unassigned - we filter allocation right after the index creation (for shard shrinking) to ensure
 * can / should be allocated. The decision if a shard can be allocated, must not
 * <li>{@code include} - filters "allowed" allocations.
        return shouldFilter(indexMetadata, node.node(), allocation);
        );
        Decision decision = shouldClusterFilter(node, allocation);
                    NAME,
        clusterExcludeFilters = DiscoveryNodeFilters.trimTier(
        if (clusterIncludeFilters != null) {
 *
        CLUSTER_ROUTING_EXCLUDE_GROUP_PREFIX + ".",
        CLUSTER_ROUTING_INCLUDE_GROUP_PREFIX + ".",
                );
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            && (migrationDirection.equals(RemoteStoreNodeService.Direction.REMOTE_STORE))
                    Decision.NO,
        if (clusterExcludeFilters != null) {
 * </ol>
    private volatile RemoteStoreNodeService.Direction migrationDirection;
    }
import org.opensearch.common.settings.Settings;
                    IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_PREFIX,
 * be allocated or should be allocated is based on either cluster wide dynamic
            if (indexExcludeFilters.match(node)) {
 */
import static org.opensearch.cluster.node.DiscoveryNodeFilters.IP_VALIDATOR;
 * SPDX-License-Identifier: Apache-2.0
                return allocation.decision(
        }
