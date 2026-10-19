        final Set<IndexShardRoutingTable> set = new HashSet<>();
            )
        return generateShardId(indexMetadata, id, routing, false);
    }
                        break;
        // caller-supplied preferences from bypassing weighted shard routing.
        true,
import org.opensearch.core.common.Strings;
    private static final Map<String, Set<String>> EMPTY_ROUTING = Collections.emptyMap();
                    }
        Setting.Property.NodeScope
    }
    }
    public GroupShardsIterator<ShardIterator> searchShards(
 * GitHub history for details.
        clusterSettings.addSettingsUpdateConsumer(STRICT_SEARCH_REPLICA_ROUTING_ENABLED, this::setStrictSearchOnlyShardRouting);
    void setStrictWeightedShardRouting(boolean strictWeightedShardRouting) {
        String localNodeId,
        @Nullable ResponseCollectorService collectorService,
            DeploymentState nodeState = drainedNodes.get(shardRouting.currentNodeId());
        this.isFailOpenEnabled = WEIGHTED_ROUTING_FAILOPEN_ENABLED.get(settings);
            }
        false,
        Setting.Property.Dynamic,
        @Nullable String preference,
/*
                nodes,
        String effectiveRouting,
    public boolean isIgnoreAwarenessAttr() {
        this.useAdaptiveReplicaSelection = USE_ADAPTIVE_REPLICA_SELECTION_SETTING.get(settings);
            clusterState.nodes().getLocalNodeId(),
        );
    }
    );
                collectorService,
 * under the License.
                    }
                    return indexShard.onlyNodeSelectorActiveInitializingShardsIt(nodeAttributes.split(","), nodes);
        @Nullable ResponseCollectorService collectorService,
        );
            clusterState.nodes(),
        IGNORE_AWARENESS_ATTRIBUTES,
            isStrictWeightedShardRouting,
    public OperationRouting(Settings settings, ClusterSettings clusterSettings) {
        DiscoveryNodes nodes,
        Setting.Property.NodeScope
            if (preferenceType == Preference.SHARDS) {
                effectivePreference = Preference.PRIMARY.type();
    private volatile boolean isStrictSearchOnlyShardRouting;
import org.opensearch.common.util.FeatureFlags;
                }
            if (effectiveRouting != null) {
        return shards(clusterState, index, id, routing).shardsIt();
            throw new IndexNotFoundException(index);
                        found = true;
                    return indexShard.primaryFirstActiveInitializingShardsIt();
        } else if (ignoreAwarenessAttributes()) {
        List<ShardIterator> allShardIterators = new ArrayList<>();
                    set.add(indexShard);
 *
        Setting.Property.Dynamic,
        DiscoveryNodes nodes,
    public double getWeightedRoutingDefaultWeight() {
        this.isStrictWeightedShardRouting = strictWeightedShardRouting;
    }
            );
            return shard;
    ) {
        }
            clusterState.metadata().weightedRoutingMetadata()
        clusterSettings.addSettingsUpdateConsumer(WEIGHTED_ROUTING_DEFAULT_WEIGHT, this::setWeightedRoutingDefaultWeight);
        DiscoveryNodes nodes,
        );
        this.isStrictWeightedShardRouting = STRICT_WEIGHTED_SHARD_ROUTING_ENABLED.get(settings);
        IndexMetadata indexMetadata = clusterState.metadata().index(index);
import java.util.Set;
        // for a different element in the list by also incorporating the
    }
            // Fall back to original if all shards were filtered out
        int routingHash = Murmur3HashFunction.hash(preference);
                getWeightedRoutingDefaultWeight(),
        @Nullable Map<String, Set<String>> routing,
            localNodeId,
        @Nullable WeightedRoutingMetadata weightedRoutingMetadata,
        } else {
        return set;
                isFailOpenEnabled,
        return indexMetadata;
    public static final Setting<Boolean> IGNORE_AWARENESS_ATTRIBUTES_SETTING = Setting.boolSetting(
    ) {
                    return indexShard.replicaFirstActiveInitializingShardsIt();
        )) {
            }
        int shardId = generateShardId(indexMetadata(clusterState, index), id, routing, true);
    }
 * software distributed under the License is distributed on an
        // we use set here and not list since we might get duplicates
        if (preference == null || preference.isEmpty()) {
    }
        Setting.Property.Dynamic,
            }
 *
 * the Apache License, Version 2.0 (the "License"); you may
        boolean includeInProgressChild
        return new ShardId(shardIndex, shardId);
import org.opensearch.core.index.Index;
        int rootShardId = Math.floorMod(hash, indexMetadata.getRoutingNumShards()) / indexMetadata.getRoutingFactor();
import org.opensearch.cluster.deployment.DeploymentState;
 * SPDX-License-Identifier: Apache-2.0
            IndexShardRoutingTable effectiveShard = shard;
                    return indexShard.searchReplicaActiveInitializingShardIt();
        1.0,
            weightedRoutingMetadata
                    if (slice.shardMatches(i, indexIterators.size())) {
            preference,
    public static final Setting<Boolean> STRICT_SEARCH_REPLICA_ROUTING_ENABLED = Setting.boolSetting(
    public GroupShardsIterator<ShardIterator> searchShards(
                // Filter the returned shards for the given slice
        int shardId = generateShardId(indexMetadata(clusterState, index), id, routing);
            );
    }
            // Server-injected preferences are scoped per index: compute the effective preference for each shard
        Setting.Property.Dynamic,
    private volatile boolean isStrictWeightedShardRouting;
                case LOCAL:
                    shards = preference.substring(Preference.SHARDS.type().length() + 1, index);
    public static final Setting<Boolean> WEIGHTED_ROUTING_FAILOPEN_ENABLED = Setting.boolSetting(
        }
        if (preference.charAt(0) == '_') {
                effectiveShard,
        return GroupShardsIterator.sortAndCreate(allShardIterators);
                serverInjectedPreference
    private volatile boolean ignoreWeightedRouting;
        return indexRouting;
                nodeCounts,
                for (String r : effectiveRouting) {
        } else {
                }
        @Nullable Map<String, Set<String>> routing
                getWeightedRoutingDefaultWeight(),
        Setting.Property.Dynamic,
                serverInjectedPreference = true;
            if (!drainedNodes.isEmpty()) {
        final String effectiveRouting;
    public static final Setting<Boolean> USE_ADAPTIVE_REPLICA_SELECTION_SETTING = Setting.boolSetting(
    }
            if (nodeState != DeploymentState.DRAIN) {
            preference,
            if (useAdaptiveReplicaSelection) {
        ClusterState clusterState,
        @Nullable String preference,
 * Routes cluster operations
        routingHash = 31 * routingHash + indexShard.shardId.hashCode();
        @Nullable Map<String, Set<String>> routing,
            indexShard,
        Setting.Property.NodeScope
        IndexShardRoutingTable indexShard,
    ) {
            // multi-index search request.
    public boolean ignoreAwarenessAttributes() {
            AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING,
        final Map<String, DeploymentState> drainedNodes = DeploymentStateService.getNodeDeploymentStates(clusterState);
        "cluster.routing.search_replica.strict",
    }
public class OperationRouting {
        Setting.Property.NodeScope
                // starts with _shards, so execute on specific ones
                case SEARCH_REPLICA:
                && (effectivePreference == null || effectivePreference.isEmpty())) {
        }
        if (WeightedRoutingUtils.shouldPerformStrictWeightedRouting(
    protected IndexMetadata indexMetadata(ClusterState clusterState, String index) {
    }
            boolean serverInjectedPreference = false;
import java.util.Collections;
    public static int generateShardId(IndexMetadata indexMetadata, @Nullable String id, @Nullable String routing) {
        return searchShards(clusterState, concreteIndices, routing, preference, null, null, null);
            }
                }
            if (effectivePreference == null || effectivePreference.isEmpty()) {
        return filtered;
        this.isStrictSearchOnlyShardRouting = strictSearchOnlyShardRouting;
        ClusterState clusterState,
        this.ignoreAwarenessAttr = ignoreAwarenessAttributes;
 * compatible open source license.
                effectivePreference = Preference.PRIMARY_FIRST.type();
        // indices) are the engine's own routing decision and are exempt from this check, which exists to stop
            shards(clusterState, index, id, routing),
import org.opensearch.index.IndexNotFoundException;
 * KIND, either express or implied.  See the License for the
                    return null;
    );
    public ShardIterator getShards(
        }
                // then ordinals and shard IDs are the same. This mimics the logic in
                for (int i = 0; i < indexIterators.size(); i++) {
        return awarenessAttributes;
 *    http://www.apache.org/licenses/LICENSE-2.0
        // Better overall balancing can be achieved if each shardId opts
        "cluster.routing.weighted.fail_open",
            if (indexMetadataForShard.isRemoteSnapshot() && (effectivePreference == null || effectivePreference.isEmpty())) {
        if (numVirtualShards != -1) {
 */
        @Nullable WeightedRoutingMetadata weightedRoutingMetadata
        this.isFailOpenEnabled = isFailOpenEnabled;
                    effectivePreference = Preference.SEARCH_REPLICA.type();
            clusterState.nodes(),
import org.opensearch.index.IndexModule;
        IndexShardRoutingTable indexShard,
import org.opensearch.common.Nullable;
        if (routing == null) {
    }
    }
import org.opensearch.common.settings.Setting;
        IndexMetadata indexMetadata = indexMetadata(clusterState, index);
            ignoreWeightedRouting,
    private ShardIterator preferenceActiveShardIterator(
            );
                isFailOpenEnabled,
                null
        // Preferences injected by the server for specific index types (e.g. remote snapshot or writable warm
        Preference.PREFER_NODES
    }
            false
    private void setAwarenessAttributes(List<String> awarenessAttributes) {
                    for (int partitionOffset = 0; partitionOffset < routingPartitionSize; partitionOffset++) {
        } else {
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.search.slice.SliceBuilder;
        @Nullable Map<String, Long> nodeCounts,
 */
                if (!found) {
            return indexShard.activeInitializingShardsWeightedIt(
                    throw new IllegalArgumentException("unknown preference [" + preferenceType + "]");
            checkPreferenceBasedRoutingAllowed(preferenceType, weightedRoutingMetadata, serverInjectedPreference);
    public static final Setting<Double> WEIGHTED_ROUTING_DEFAULT_WEIGHT = Setting.doubleSetting(
    }
        IndexMetadata indexMetadata,
import org.opensearch.node.ResponseCollectorService;
        this.awarenessAttributes = AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.get(settings);
            clusterState.getMetadata().weightedRoutingMetadata()
import org.opensearch.core.index.shard.ShardId;
            } else {
        IndexShardRoutingTable filtered = builder.build();
    ) {
                weightedRoutingMetadata.getWeightedRouting(),
        @Nullable String routing,
                // no more preference
        routing = routing == null ? EMPTY_ROUTING : routing; // just use an empty map
import org.opensearch.common.annotation.PublicApi;
    }
            return indexShard.activeInitializingShardsWeightedIt(
            effectiveRouting = routing;
                // specified. In that case, the set of routable shards is considered the full universe of available
            throw new PreferenceBasedSearchNotAllowedException(
    void setWeightedRoutingDefaultWeight(double weightedRoutingDefaultWeight) {
import org.opensearch.cluster.metadata.VirtualShardRoutingHelper;
            null,
                // shards for each index, when mapping shards to slices. If no routing parameter was specified,
/*
        if (indexMetadata.isRoutingPartitionedIndex()) {
    private Set<IndexShardRoutingTable> computeTargetedShards(
        if (WeightedRoutingUtils.shouldPerformWeightedRouting(ignoreWeightedRouting, weightedRoutingMetadata)) {
            );
        }
        @Nullable String preference
                    return indexShard.onlyNodeActiveInitializingShardsIt(localNodeId);
        clusterSettings.addSettingsUpdateConsumer(STRICT_WEIGHTED_SHARD_ROUTING_ENABLED, this::setStrictWeightedShardRouting);
                return indexShard.activeInitializingShardsRankedIt(collectorService, nodeCounts);
@PublicApi(since = "1.0.0")
            return indexShard.preferAttributesActiveInitializingShardsIt(awarenessAttributes, nodes);
                case PRIMARY_FIRST:
                        allShardIterators.add(indexIterators.get(i));
        // if not, then use it as the index
    ) {
            final Set<String> effectiveRouting = routing.get(index);
    private volatile boolean useAdaptiveReplicaSelection;
        "cluster.routing.weighted.strict",
    }
            }
 * this file be licensed under the Apache-2.0 license or a
                && indexMetadataForShard.getSettings().getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false)
        int numVirtualShards = indexMetadata.getNumberOfVirtualShards();
        this.weightedRoutingDefaultWeight = WEIGHTED_ROUTING_DEFAULT_WEIGHT.get(settings);
                clusterState.metadata().weightedRoutingMetadata(),
    ) {
        String localNodeId,
            }
    }
        true,
        ClusterState clusterState,
        Setting.Property.NodeScope
            return VirtualShardRoutingHelper.resolvePhysicalShardId(indexMetadata, vShardId);
 * not use this file except in compliance with the License.
        } else {
        clusterSettings.addSettingsUpdateConsumer(IGNORE_AWARENESS_ATTRIBUTES_SETTING, this::setIgnoreAwarenessAttributes);
            if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
        final IndexShardRoutingTable shard = clusterState.routingTable().shardRoutingTable(shardId);
    }
        if (slice != null) {
        Setting.Property.Dynamic,
        this.useAdaptiveReplicaSelection = useAdaptiveReplicaSelection;
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shard.shardId);
        // shard ID into the hash of the user-supplied preference key.
            }
                effectivePreference,
                CollectionUtil.timSort(indexIterators);
        @Nullable String id,
                }
            String effectivePreference = preference;
package org.opensearch.cluster.routing;
    private static int calculateShardIdOfChild(
            nodeCounts,
    private volatile List<String> awarenessAttributes;
        clusterSettings.addSettingsUpdateConsumer(WEIGHTED_ROUTING_FAILOPEN_ENABLED, this::setFailOpenEnabled);
        } else {
        );
                    return indexShard.replicaActiveInitializingShardIt();
        final int partitionOffset;
                if (index == -1) {
        final Set<IndexShardRoutingTable> shards = computeTargetedShards(clusterState, concreteIndices, routing);
 * @opensearch.api
    );
        String[] concreteIndices,
                }
        @Nullable Map<String, Long> nodeCounts,
        IndexShardRoutingTable indexShard,
import org.opensearch.cluster.deployment.DeploymentStateService;
 * ownership. Elasticsearch licenses this file to you under
        }
    private static int calculateScaledShardId(IndexMetadata indexMetadata, String effectiveRouting, int partitionOffset) {
        int partitionOffset,
        @Nullable String preference
            final IndexRoutingTable indexRouting = indexRoutingTable(clusterState, index);
 * license agreements. See the NOTICE file distributed with
    );
    public ShardIterator getShards(ClusterState clusterState, String index, int shardId, @Nullable String preference) {
    );
        this.awarenessAttributes = awarenessAttributes;
    }
        "cluster.routing.weighted.default_weight",
                    // update the preference and continue
/*
                if (index == -1 || index == preference.length() - 1) {
                    if (Integer.parseInt(id) == indexShard.shardId().id()) {
    private static IndexShardRoutingTable filterDrainedNodes(IndexShardRoutingTable shard, Map<String, DeploymentState> drainedNodes) {
                case ONLY_LOCAL:
    }
                } else {
            effectiveRouting = id;
    protected IndexShardRoutingTable shards(ClusterState clusterState, String index, String id, String routing) {
    public ShardIterator indexShards(ClusterState clusterState, String index, String id, @Nullable String routing) {
                    }
import java.util.stream.Collectors;
        if (filtered.size() == 0) {
    public static final Setting<Boolean> STRICT_WEIGHTED_SHARD_ROUTING_ENABLED = Setting.boolSetting(
    ) {
                effectiveShard = filterDrainedNodes(shard, drainedNodes);
        return ignoreAwarenessAttr;
    }
                clusterState.nodes(),
                case REPLICA_FIRST:
                    return indexShard.preferNodeActiveInitializingShardsIt(Collections.singleton(localNodeId));
        return calculateShardIdOfChild(indexMetadata, effectiveRouting, partitionOffset, includeInProgressChild);
    }
        Setting.Property.Dynamic,
import java.util.Arrays;
                case PREFER_NODES:
                        set.add(RoutingTable.shardRoutingTable(indexRouting, calculateScaledShardId(indexMetadata, r, partitionOffset)));
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
            weightedRoutingMetadata,
        @Nullable String routing,
            && WeightedRoutingUtils.shouldPerformStrictWeightedRouting(
        "cluster.routing.use_adaptive_replica_selection",
    public static final String IGNORE_AWARENESS_ATTRIBUTES = "cluster.search.ignore_awareness_attributes";
    ) {
            }
            final int hash = Murmur3HashFunction.hash(effectiveRouting) + partitionOffset;
                clusterState.nodes().getLocalNodeId(),
        return clusterState.getRoutingTable().shardRoutingTable(index, shardId);
                for (IndexShardRoutingTable indexShard : indexRouting) {
                } else {
        true,
    }
 *
            }
    public ShardId shardId(ClusterState clusterState, String index, String id, @Nullable String routing) {
        this.ignoreWeightedRouting = isWeightedRoundRobinEnabled;
                return indexShard.activeInitializingShardsRandomIt();
            for (List<ShardIterator> indexIterators : shardIterators.values()) {
 * You may obtain a copy of the License at
        for (IndexShardRoutingTable shard : shards) {
        true,
        Map<Index, List<ShardIterator>> shardIterators = new HashMap<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String[] concreteIndices,
            Preference preferenceType = Preference.parse(preference);
 * Modifications Copyright OpenSearch Contributors. See
        return indexMetadata.getSplitShardsMetadata().getShardIdOfHash(rootShardId, hash, includeInProgressChild);
                serverInjectedPreference = true;
        @Nullable WeightedRoutingMetadata weightedRoutingMetadata,
                shardIterators.computeIfAbsent(iterator.shardId().getIndex(), k -> new ArrayList<>()).add(iterator);
            && WEIGHTED_ROUTING_RESTRICTED_PREFERENCES.contains(preference)) {
        }
            collectorService,
        // we don't use IMD#getNumberOfShards since the index might have been shrunk such that we need to use the size
            IndexMetadata indexMetadataForShard = indexMetadata(clusterState, effectiveShard.shardId.getIndex().getName());
        return preferenceActiveShardIterator(
            partitionOffset = Math.floorMod(Murmur3HashFunction.hash(id), indexMetadata.getRoutingPartitionSize());
    }
                int index = preference.indexOf('|');
        if (indexMetadata == null) {
    public static int generateShardId(
                    preference = preference.substring(index + 1);
            assert (indexMetadata.isRoutingPartitionedIndex() == false) : "A routing value is required for gets from a partitioned index";
        this.ignoreAwarenessAttr = clusterSettings.get(IGNORE_AWARENESS_ATTRIBUTES_SETTING);
            nodes,
                String shards;
/**
                routingHash
}
        // select the same node across different shardIds.
        this.ignoreWeightedRouting = IGNORE_WEIGHTED_SHARD_ROUTING.get(settings);
import java.util.ArrayList;
        IndexMetadata indexMetadata,
                "Preference type based routing not allowed with strict weighted shard routing enabled"
        if (indexRouting == null) {
    public ShardId shardWithRecoveringChild(ClusterState clusterState, String index, String id, String routing, Index shardIndex) {
        boolean serverInjectedPreference
                    serverInjectedPreference = true;
        @Nullable WeightedRoutingMetadata weightedRoutingMetadata
                weightedRoutingMetadata
        clusterSettings.addSettingsUpdateConsumer(IGNORE_WEIGHTED_SHARD_ROUTING, this::setIgnoreWeightedRouting);
        }
                for (String id : ids) {
import org.opensearch.cluster.metadata.IndexMetadata;
        // The AllocationService lists shards in a fixed order based on nodes
        clusterSettings.addSettingsUpdateConsumer(
        return new ShardId(indexMetadata.getIndex(), generateShardId(indexMetadata, id, routing));
            if (iterator != null) {
            }
                builder.addShard(shardRouting);
                case REPLICA:
        return this.weightedRoutingDefaultWeight;
        }
        return preferenceActiveShardIterator(
 * this work for additional information regarding copyright
        // whether to ignore awareness attributes when routing requests
                    final Set<String> nodesIds = Arrays.stream(preference.substring(Preference.PREFER_NODES.type().length() + 1).split(","))
                default:
        boolean includeInProgressChild
        @Nullable String preference,
    }
            this::setAwarenessAttributes
                weightedRoutingMetadata.getWeightedRouting(),
    );
    void checkPreferenceBasedRoutingAllowed(
import java.util.Map;
        String id,
                isStrictWeightedShardRouting,
 *
                // computeTargetedShards may return a subset of shards for an index, if a routing parameter was
    }
                }
    void setStrictSearchOnlyShardRouting(boolean strictSearchOnlyShardRouting) {
import org.opensearch.common.settings.Settings;
        }
        }
    private ShardIterator shardRoutings(
        @Nullable Map<String, Long> nodeCounts,
                    return shardRoutings(indexShard, nodes, collectorService, nodeCounts, weightedRoutingMetadata);
        boolean serverInjectedPreference
        // of original index to hash documents
import java.util.List;
        return shard.activeInitializingShardsRandomIt();
    public static ShardIterator getShards(ClusterState clusterState, ShardId shardId) {
import org.apache.lucene.util.CollectionUtil;
        return calculateShardIdOfChild(indexMetadata, effectiveRouting, partitionOffset, false);
        String index,
import org.opensearch.cluster.ClusterState;
    void setUseAdaptiveReplicaSelection(boolean useAdaptiveReplicaSelection) {
                ignoreWeightedRouting,
    void setIgnoreAwarenessAttributes(boolean ignoreAwarenessAttributes) {
            switch (preferenceType) {
        this.weightedRoutingDefaultWeight = weightedRoutingDefaultWeight;
        }
            clusterState.nodes().getLocalNodeId(),
                }
    }
    );
        }
            null,
            indexShard,
        IndexRoutingTable indexRouting = clusterState.routingTable().index(index);
                case PRIMARY:
                }
    ) {
        }
    private volatile boolean isFailOpenEnabled;
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
 * specific language governing permissions and limitations
        if (serverInjectedPreference == false
                case ONLY_NODES:
            final IndexMetadata indexMetadata = indexMetadata(clusterState, index);
    }
                // We use the ordinal of the iterator in the group (after sorting) rather than the shard id, because
    }
    );
        for (String index : concreteIndices) {
                String[] ids = Strings.splitStringByCommaToArray(shards);
            throw new IndexNotFoundException(index);
            ShardIterator iterator = preferenceActiveShardIterator(
            null,
        @Nullable Map<String, Long> nodeCounts,
import java.util.HashMap;
        Setting.Property.NodeScope
            // instead of mutating the caller-supplied preference, so that a preference injected for one index
        "cluster.routing.ignore_weighted_routing",
        clusterSettings.addSettingsUpdateConsumer(USE_ADAPTIVE_REPLICA_SELECTION_SETTING, this::setUseAdaptiveReplicaSelection);
    }
        this.isStrictSearchOnlyShardRouting = STRICT_SEARCH_REPLICA_ROUTING_ENABLED.get(settings);
        ClusterState clusterState,
        Setting.Property.NodeScope
            partitionOffset = 0;
        return preferenceActiveShardIterator(
                    shards = preference.substring(Preference.SHARDS.type().length() + 1);
            null,
        final IndexShardRoutingTable indexShard = clusterState.getRoutingTable().shardRoutingTable(index, shardId);
                    final int routingPartitionSize = indexMetadata.getRoutingPartitionSize();
        true,
        }
            // (e.g. a remote snapshot or writable warm index) does not leak into other indices of the same
            shardIterators.values().forEach(allShardIterators::addAll);
        @Nullable ResponseCollectorService collectorService,
                if (indexMetadataForShard.getNumberOfSearchOnlyReplicas() > 0 && isStrictSearchOnlyShardRouting) {
    private volatile boolean ignoreAwarenessAttr;
    private volatile double weightedRoutingDefaultWeight;
 */
            } else {
        Preference preference,
            return shardRoutings(indexShard, nodes, collectorService, nodeCounts, weightedRoutingMetadata);
    }
        Preference.ONLY_NODES,
        @Nullable ResponseCollectorService collectorService,
 * Unless required by applicable law or agreed to in writing,
    protected IndexRoutingTable indexRoutingTable(ClusterState clusterState, String index) {
        String[] concreteIndices,
        // so earlier versions of this class would have a tendency to
            // we would have still got 0 above but this check just saves us an unnecessary hash calculation
    private ShardIterator preferenceActiveShardIterator(
            preference,
                boolean found = false;
    void setIgnoreWeightedRouting(boolean isWeightedRoundRobinEnabled) {
    private static final List<Preference> WEIGHTED_ROUTING_RESTRICTED_PREFERENCES = Arrays.asList(
import org.opensearch.cluster.node.DiscoveryNodes;
                    return indexShard.primaryActiveInitializingShardIt();
        1.0,
import java.util.HashSet;
    public static final Setting<Boolean> IGNORE_WEIGHTED_SHARD_ROUTING = Setting.boolSetting(
    ) {
            return indexShard.activeInitializingShardsIt(routingHash);
 */
            preferenceType = Preference.parse(preference);
            int vShardId = Math.floorMod(hash, numVirtualShards);
        final int hash = Murmur3HashFunction.hash(effectiveRouting) + partitionOffset;
    // package-private for testing
        @Nullable SliceBuilder slice
import org.opensearch.common.settings.ClusterSettings;
                    return indexShard.preferNodeActiveInitializingShardsIt(nodesIds);
                // org.opensearch.search.slice.SliceBuilder.toFilter.
        for (ShardRouting shardRouting : shard) {
                        .collect(Collectors.toSet());
 * The OpenSearch Contributors require contributions made to
            }
    }
        return this.awarenessAttributes.isEmpty() || this.ignoreAwarenessAttr;
    void setFailOpenEnabled(boolean isFailOpenEnabled) {
                nodes,
                    String nodeAttributes = preference.substring(Preference.ONLY_NODES.type().length() + 1);
    List<String> getAwarenessAttributes() {
