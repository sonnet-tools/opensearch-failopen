            null,
        Setting.Property.Dynamic,  
    }
        return calculateShardIdOfChild(indexMetadata, effectiveRouting, partitionOffset, includeInProgressChild);  
            IndexMetadata indexMetadataForShard = indexMetadata(clusterState, effectiveShard.shardId.getIndex().getName());  
 * GitHub history for details.
                null  
        );
    }
    private ShardIterator preferenceActiveShardIterator(
        if (indexMetadata.isRoutingPartitionedIndex()) {
        } else if (ignoreAwarenessAttributes()) {
        IndexShardRoutingTable indexShard,  
                return indexShard.activeInitializingShardsRandomIt();  
        } else {
        // for a different element in the list by also incorporating the  
import org.opensearch.common.settings.Setting;
                    return indexShard.preferNodeActiveInitializingShardsIt(nodesIds);
        @Nullable ResponseCollectorService collectorService,
            } else {
import org.opensearch.node.ResponseCollectorService;  
        routingHash = 31 * routingHash + indexShard.shardId.hashCode();
            shardIterators.values().forEach(allShardIterators::addAll);
        @Nullable String routing,
import org.opensearch.cluster.deployment.DeploymentState;  
        this.ignoreWeightedRouting = IGNORE_WEIGHTED_SHARD_ROUTING.get(settings);
    public static final Setting<Boolean> USE_ADAPTIVE_REPLICA_SELECTION_SETTING = Setting.boolSetting(  
            return indexShard.activeInitializingShardsWeightedIt(
        this.useAdaptiveReplicaSelection = USE_ADAPTIVE_REPLICA_SELECTION_SETTING.get(settings);  
        IndexMetadata indexMetadata,
        return indexMetadata.getSplitShardsMetadata().getShardIdOfHash(rootShardId, hash, includeInProgressChild);
        if (WeightedRoutingUtils.shouldPerformWeightedRouting(ignoreWeightedRouting, weightedRoutingMetadata)) {  
            }
        if (numVirtualShards != -1) {  
        @Nullable String preference  
    }  
        this.ignoreWeightedRouting = isWeightedRoundRobinEnabled;  
    public static final String IGNORE_AWARENESS_ATTRIBUTES = "cluster.search.ignore_awareness_attributes";
        @Nullable String preference  
    private volatile List<String> awarenessAttributes;
            if (effectivePreference == null || effectivePreference.isEmpty()) {
        Setting.Property.NodeScope
            nodes,
import org.opensearch.common.settings.ClusterSettings;  
                ignoreWeightedRouting,
 * ownership. Elasticsearch licenses this file to you under  
                        set.add(RoutingTable.shardRoutingTable(indexRouting, calculateScaledShardId(indexMetadata, r, partitionOffset)));
 * compatible open source license.
    ) {  
    }
    public boolean ignoreAwarenessAttributes() {  
            // multi-index search request.
        // if not, then use it as the index  
        return indexRouting;  
 * not use this file except in compliance with the License.
                    preference = preference.substring(index + 1);
            clusterState.nodes(),
 * You may obtain a copy of the License at  
    public ShardId shardId(ClusterState clusterState, String index, String id, @Nullable String routing) {  
    public ShardId shardWithRecoveringChild(ClusterState clusterState, String index, String id, String routing, Index shardIndex) {
            preference,  
    }
        ClusterState clusterState,
                    return indexShard.replicaFirstActiveInitializingShardsIt();  
    public double getWeightedRoutingDefaultWeight() {
        String id,
    public static final Setting<Boolean> STRICT_SEARCH_REPLICA_ROUTING_ENABLED = Setting.boolSetting(  
        for (String index : concreteIndices) {
    public static ShardIterator getShards(ClusterState clusterState, ShardId shardId) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.Nullable;
        Setting.Property.Dynamic,
            partitionOffset = 0;
import java.util.Arrays;
import java.util.Set;
                nodeCounts,
                    if (Integer.parseInt(id) == indexShard.shardId().id()) {
 * The OpenSearch Contributors require contributions made to  
        String localNodeId,
        boolean includeInProgressChild
                }  
        Preference.ONLY_NODES,
        IndexShardRoutingTable indexShard,  
                // org.opensearch.search.slice.SliceBuilder.toFilter.
        }
        } else {  
        true,
        }
            String effectivePreference = preference;
        clusterSettings.addSettingsUpdateConsumer(STRICT_WEIGHTED_SHARD_ROUTING_ENABLED, this::setStrictWeightedShardRouting);
        final IndexShardRoutingTable indexShard = clusterState.getRoutingTable().shardRoutingTable(index, shardId);
        routing = routing == null ? EMPTY_ROUTING : routing; // just use an empty map
    );
                    }
import org.opensearch.common.annotation.PublicApi;
 * software distributed under the License is distributed on an
        this.isFailOpenEnabled = WEIGHTED_ROUTING_FAILOPEN_ENABLED.get(settings);
    private static final Map<String, Set<String>> EMPTY_ROUTING = Collections.emptyMap();  
        final IndexShardRoutingTable shard = clusterState.routingTable().shardRoutingTable(shardId);
        int rootShardId = Math.floorMod(hash, indexMetadata.getRoutingNumShards()) / indexMetadata.getRoutingFactor();
/*
        Setting.Property.NodeScope
        for (ShardRouting shardRouting : shard) {
/*  
        String[] concreteIndices,
                effectiveShard = filterDrainedNodes(shard, drainedNodes);  
        int numVirtualShards = indexMetadata.getNumberOfVirtualShards();
            );
    ) {
        1.0,
                        .collect(Collectors.toSet());
        IndexShardRoutingTable filtered = builder.build();
                        found = true;
    public OperationRouting(Settings settings, ClusterSettings clusterSettings) {
                default:
    }  
        final Set<IndexShardRoutingTable> shards = computeTargetedShards(clusterState, concreteIndices, routing);
import org.opensearch.index.IndexNotFoundException;
import org.opensearch.search.slice.SliceBuilder;
            clusterState.getMetadata().weightedRoutingMetadata()  
import org.opensearch.core.index.Index;
    private volatile boolean isFailOpenEnabled;
    public ShardIterator indexShards(ClusterState clusterState, String index, String id, @Nullable String routing) {  
    }
            }
        }
        List<ShardIterator> allShardIterators = new ArrayList<>();
                builder.addShard(shardRouting);
        } else {  
        if (serverInjectedPreference == false
            preference,  
            if (effectiveRouting != null) {  
import java.util.HashSet;
    List<String> getAwarenessAttributes() {
    }  
            IndexShardRoutingTable effectiveShard = shard;
            if (!drainedNodes.isEmpty()) {
        ClusterState clusterState,  
        int shardId = generateShardId(indexMetadata(clusterState, index), id, routing);  
            if (iterator != null) {  
            for (List<ShardIterator> indexIterators : shardIterators.values()) {  
        return preferenceActiveShardIterator(  
        "cluster.routing.weighted.strict",  
            final IndexMetadata indexMetadata = indexMetadata(clusterState, index);
    }  
                nodes,
            return indexShard.activeInitializingShardsIt(routingHash);
                // then ordinals and shard IDs are the same. This mimics the logic in
        Setting.Property.Dynamic,  
            weightedRoutingMetadata,  
                }  
        Setting.Property.Dynamic,  
            switch (preferenceType) {
        // caller-supplied preferences from bypassing weighted shard routing.  
    // package-private for testing
    }
            );
    ) {  
                CollectionUtil.timSort(indexIterators);
                collectorService,
            final int hash = Murmur3HashFunction.hash(effectiveRouting) + partitionOffset;
            // Server-injected preferences are scoped per index: compute the effective preference for each shard
                isFailOpenEnabled,
    }  
    public static final Setting<Double> WEIGHTED_ROUTING_DEFAULT_WEIGHT = Setting.doubleSetting(
        return preferenceActiveShardIterator(
        @Nullable WeightedRoutingMetadata weightedRoutingMetadata,
            // (e.g. a remote snapshot or writable warm index) does not leak into other indices of the same  
        "cluster.routing.ignore_weighted_routing",
        @Nullable WeightedRoutingMetadata weightedRoutingMetadata
            weightedRoutingMetadata  
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
    private ShardIterator preferenceActiveShardIterator(
            preferenceType = Preference.parse(preference);
            }
            if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)  
        clusterSettings.addSettingsUpdateConsumer(
                serverInjectedPreference
        }  
    protected IndexShardRoutingTable shards(ClusterState clusterState, String index, String id, String routing) {
    void setIgnoreAwarenessAttributes(boolean ignoreAwarenessAttributes) {
    public static final Setting<Boolean> STRICT_WEIGHTED_SHARD_ROUTING_ENABLED = Setting.boolSetting(
        this.useAdaptiveReplicaSelection = useAdaptiveReplicaSelection;
        // we don't use IMD#getNumberOfShards since the index might have been shrunk such that we need to use the size  
        boolean serverInjectedPreference
                clusterState.nodes().getLocalNodeId(),
    public static final Setting<Boolean> IGNORE_WEIGHTED_SHARD_ROUTING = Setting.boolSetting(  
        final int hash = Murmur3HashFunction.hash(effectiveRouting) + partitionOffset;
        IndexMetadata indexMetadata = indexMetadata(clusterState, index);
    private volatile boolean isStrictWeightedShardRouting;  
                return indexShard.activeInitializingShardsRankedIt(collectorService, nodeCounts);
/**
        clusterSettings.addSettingsUpdateConsumer(WEIGHTED_ROUTING_DEFAULT_WEIGHT, this::setWeightedRoutingDefaultWeight);
        }
    ) {
                    return indexShard.onlyNodeSelectorActiveInitializingShardsIt(nodeAttributes.split(","), nodes);
        return this.awarenessAttributes.isEmpty() || this.ignoreAwarenessAttr;
        if (indexRouting == null) {  
            null,
        this.weightedRoutingDefaultWeight = weightedRoutingDefaultWeight;  
                    shards = preference.substring(Preference.SHARDS.type().length() + 1, index);
import org.opensearch.core.index.shard.ShardId;  
            }
            clusterState.metadata().weightedRoutingMetadata()
 * this file be licensed under the Apache-2.0 license or a
            throw new PreferenceBasedSearchNotAllowedException(
        }
        if (indexMetadata == null) {
                if (index == -1 || index == preference.length() - 1) {
            AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING,  
        return searchShards(clusterState, concreteIndices, routing, preference, null, null, null);
        this.isFailOpenEnabled = isFailOpenEnabled;
                weightedRoutingMetadata.getWeightedRouting(),  
        }
        String localNodeId,
        "cluster.routing.use_adaptive_replica_selection",
        return clusterState.getRoutingTable().shardRoutingTable(index, shardId);
 * Modifications Copyright OpenSearch Contributors. See
            return indexShard.preferAttributesActiveInitializingShardsIt(awarenessAttributes, nodes);  
        this.weightedRoutingDefaultWeight = WEIGHTED_ROUTING_DEFAULT_WEIGHT.get(settings);
        true,  
    );
            DeploymentState nodeState = drainedNodes.get(shardRouting.currentNodeId());
        if (preference.charAt(0) == '_') {
        Setting.Property.NodeScope  
            }
import org.opensearch.common.settings.Settings;
                    for (int partitionOffset = 0; partitionOffset < routingPartitionSize; partitionOffset++) {  
        IGNORE_AWARENESS_ATTRIBUTES,  
        return calculateShardIdOfChild(indexMetadata, effectiveRouting, partitionOffset, false);
                    // update the preference and continue
 * the Apache License, Version 2.0 (the "License"); you may
        @Nullable Map<String, Set<String>> routing,
        // shard ID into the hash of the user-supplied preference key.
                for (String id : ids) {  
            nodeCounts,
    }
                "Preference type based routing not allowed with strict weighted shard routing enabled"  
            }  
        boolean serverInjectedPreference
            final Set<String> effectiveRouting = routing.get(index);
                weightedRoutingMetadata.getWeightedRouting(),
                    if (slice.shardMatches(i, indexIterators.size())) {
    }
                getWeightedRoutingDefaultWeight(),
        @Nullable Map<String, Set<String>> routing,
                serverInjectedPreference = true;  
        );
        Setting.Property.NodeScope
            throw new IndexNotFoundException(index);
                clusterState.metadata().weightedRoutingMetadata(),  
            boolean serverInjectedPreference = false;  
        String effectiveRouting,  
 * this work for additional information regarding copyright
    public ShardIterator getShards(
        int shardId = generateShardId(indexMetadata(clusterState, index), id, routing, true);
            ignoreWeightedRouting,
    }  
        return GroupShardsIterator.sortAndCreate(allShardIterators);
    }
                }
    }
            shards(clusterState, index, id, routing),  
            }
                } else {  
                effectivePreference = Preference.PRIMARY.type();
                    return indexShard.replicaActiveInitializingShardIt();
        ClusterState clusterState,
                }
        clusterSettings.addSettingsUpdateConsumer(IGNORE_WEIGHTED_SHARD_ROUTING, this::setIgnoreWeightedRouting);
                    return indexShard.primaryActiveInitializingShardIt();  
        clusterSettings.addSettingsUpdateConsumer(IGNORE_AWARENESS_ATTRIBUTES_SETTING, this::setIgnoreAwarenessAttributes);
            // we would have still got 0 above but this check just saves us an unnecessary hash calculation
            this::setAwarenessAttributes
        @Nullable SliceBuilder slice  
        return generateShardId(indexMetadata, id, routing, false);  
    void setStrictWeightedShardRouting(boolean strictWeightedShardRouting) {
            isStrictWeightedShardRouting,
    public static int generateShardId(IndexMetadata indexMetadata, @Nullable String id, @Nullable String routing) {
 * under the License.  
        if (WeightedRoutingUtils.shouldPerformStrictWeightedRouting(  
        @Nullable ResponseCollectorService collectorService,
            indexShard,  
        final Set<IndexShardRoutingTable> set = new HashSet<>();  
                case PRIMARY:
        Preference preference,  
        );
    private Set<IndexShardRoutingTable> computeTargetedShards(  
                    return indexShard.preferNodeActiveInitializingShardsIt(Collections.singleton(localNodeId));
    void setFailOpenEnabled(boolean isFailOpenEnabled) {  
        Map<Index, List<ShardIterator>> shardIterators = new HashMap<>();
        @Nullable String preference,  
    public GroupShardsIterator<ShardIterator> searchShards(
            ShardIterator iterator = preferenceActiveShardIterator(
                effectiveShard,  
            );
    private volatile boolean isStrictSearchOnlyShardRouting;
            null,  
import org.opensearch.cluster.metadata.VirtualShardRoutingHelper;  
        this.isStrictSearchOnlyShardRouting = strictSearchOnlyShardRouting;  
                && (effectivePreference == null || effectivePreference.isEmpty())) {
        }
    );
        for (IndexShardRoutingTable shard : shards) {  
    private volatile boolean ignoreWeightedRouting;
        return awarenessAttributes;
            null,
        String[] concreteIndices,
    void setWeightedRoutingDefaultWeight(double weightedRoutingDefaultWeight) {
                String[] ids = Strings.splitStringByCommaToArray(shards);
        }
        String[] concreteIndices,
        String index,  
        clusterSettings.addSettingsUpdateConsumer(USE_ADAPTIVE_REPLICA_SELECTION_SETTING, this::setUseAdaptiveReplicaSelection);  
                    String nodeAttributes = preference.substring(Preference.ONLY_NODES.type().length() + 1);  
    public boolean isIgnoreAwarenessAttr() {  
    private static int calculateShardIdOfChild(
        }
                case ONLY_NODES:
            assert (indexMetadata.isRoutingPartitionedIndex() == false) : "A routing value is required for gets from a partitioned index";
            return VirtualShardRoutingHelper.resolvePhysicalShardId(indexMetadata, vShardId);  
    }
        clusterSettings.addSettingsUpdateConsumer(WEIGHTED_ROUTING_FAILOPEN_ENABLED, this::setFailOpenEnabled);  
package org.opensearch.cluster.routing;
            } else {
    ) {
            && WEIGHTED_ROUTING_RESTRICTED_PREFERENCES.contains(preference)) {
    );
 */
            if (nodeState != DeploymentState.DRAIN) {  
                } else {
        );
        return this.weightedRoutingDefaultWeight;
        if (routing == null) {  
    private static IndexShardRoutingTable filterDrainedNodes(IndexShardRoutingTable shard, Map<String, DeploymentState> drainedNodes) {
        Setting.Property.NodeScope
        DiscoveryNodes nodes,
                    return null;
    }
            partitionOffset = Math.floorMod(Murmur3HashFunction.hash(id), indexMetadata.getRoutingPartitionSize());
            }
        return preferenceActiveShardIterator(
        // select the same node across different shardIds.
            checkPreferenceBasedRoutingAllowed(preferenceType, weightedRoutingMetadata, serverInjectedPreference);  
        IndexMetadata indexMetadata = clusterState.metadata().index(index);
    }  
                }
                    serverInjectedPreference = true;
}
        DiscoveryNodes nodes,
import java.util.Map;  
        this.awarenessAttributes = awarenessAttributes;  
    ) {
    }  
        }
 */  
    private static int calculateScaledShardId(IndexMetadata indexMetadata, String effectiveRouting, int partitionOffset) {  
        // of original index to hash documents
        @Nullable Map<String, Long> nodeCounts,
            collectorService,
            return shardRoutings(indexShard, nodes, collectorService, nodeCounts, weightedRoutingMetadata);
                    final Set<String> nodesIds = Arrays.stream(preference.substring(Preference.PREFER_NODES.type().length() + 1).split(","))  
    }
                    return indexShard.onlyNodeActiveInitializingShardsIt(localNodeId);
        @Nullable String preference,  
import java.util.stream.Collectors;
        }
        "cluster.routing.weighted.fail_open",
        boolean includeInProgressChild
    public static final Setting<Boolean> IGNORE_AWARENESS_ATTRIBUTES_SETTING = Setting.boolSetting(
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shard.shardId);  
 * specific language governing permissions and limitations
/*  
            }
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;  
                    set.add(indexShard);  
    );
            preference,
        } else {  
                weightedRoutingMetadata
        true,
                isStrictWeightedShardRouting,  
            }
                case REPLICA_FIRST:
    protected IndexRoutingTable indexRoutingTable(ClusterState clusterState, String index) {
import org.opensearch.common.util.FeatureFlags;  
        final Map<String, DeploymentState> drainedNodes = DeploymentStateService.getNodeDeploymentStates(clusterState);  
    public static final Setting<Boolean> WEIGHTED_ROUTING_FAILOPEN_ENABLED = Setting.boolSetting(
    void setUseAdaptiveReplicaSelection(boolean useAdaptiveReplicaSelection) {  
    );
                effectivePreference = Preference.PRIMARY_FIRST.type();  
        @Nullable String routing,  
        this.ignoreAwarenessAttr = clusterSettings.get(IGNORE_AWARENESS_ATTRIBUTES_SETTING);  
    }  
                    shards = preference.substring(Preference.SHARDS.type().length() + 1);  
                for (int i = 0; i < indexIterators.size(); i++) {  
        @Nullable Map<String, Set<String>> routing  
                if (!found) {  
            return indexShard.activeInitializingShardsWeightedIt(
            )  
    void setStrictSearchOnlyShardRouting(boolean strictSearchOnlyShardRouting) {
        }  
 *
        this.isStrictSearchOnlyShardRouting = STRICT_SEARCH_REPLICA_ROUTING_ENABLED.get(settings);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                case SEARCH_REPLICA:
                // Filter the returned shards for the given slice
        return ignoreAwarenessAttr;
@PublicApi(since = "1.0.0")  
 */
 *  
        @Nullable Map<String, Long> nodeCounts,  
    protected IndexMetadata indexMetadata(ClusterState clusterState, String index) {  
            localNodeId,
    }
        if (preference == null || preference.isEmpty()) {  
        return new ShardId(shardIndex, shardId);  
            if (useAdaptiveReplicaSelection) {  
                }
import java.util.List;
                // specified. In that case, the set of routable shards is considered the full universe of available
        return set;
                        break;  
        true,
                    throw new IllegalArgumentException("unknown preference [" + preferenceType + "]");  
            effectiveRouting = id;
import org.opensearch.cluster.deployment.DeploymentStateService;
                int index = preference.indexOf('|');
        DiscoveryNodes nodes,
    }
        Setting.Property.Dynamic,  
            && WeightedRoutingUtils.shouldPerformStrictWeightedRouting(
        int partitionOffset,
        clusterSettings.addSettingsUpdateConsumer(STRICT_SEARCH_REPLICA_ROUTING_ENABLED, this::setStrictSearchOnlyShardRouting);  
        return new ShardId(indexMetadata.getIndex(), generateShardId(indexMetadata, id, routing));
        @Nullable String preference,  
        // indices) are the engine's own routing decision and are exempt from this check, which exists to stop
 *
        return filtered;  
                    effectivePreference = Preference.SEARCH_REPLICA.type();  
                // shards for each index, when mapping shards to slices. If no routing parameter was specified,  
                && indexMetadataForShard.getSettings().getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false)
        @Nullable WeightedRoutingMetadata weightedRoutingMetadata  
        true,
import org.opensearch.index.IndexModule;
                isFailOpenEnabled,  
                    }
        "cluster.routing.weighted.default_weight",  
        @Nullable Map<String, Long> nodeCounts,
        // Preferences injected by the server for specific index types (e.g. remote snapshot or writable warm
    }
                case PREFER_NODES:
            effectiveRouting = routing;
                shardIterators.computeIfAbsent(iterator.shardId().getIndex(), k -> new ArrayList<>()).add(iterator);
    ) {
    private void setAwarenessAttributes(List<String> awarenessAttributes) {
                getWeightedRoutingDefaultWeight(),
    }  
        Preference.PREFER_NODES  
                boolean found = false;
        if (slice != null) {
import java.util.Collections;
    ) {
                    return indexShard.searchReplicaActiveInitializingShardIt();
                }  
 *  
        this.awarenessAttributes = AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.get(settings);
import org.opensearch.cluster.ClusterState;
                String shards;
    public static int generateShardId(  
        // whether to ignore awareness attributes when routing requests
        if (filtered.size() == 0) {
    private volatile double weightedRoutingDefaultWeight;
                // starts with _shards, so execute on specific ones
            throw new IndexNotFoundException(index);  
                clusterState.nodes(),
                effectivePreference,  
                nodes,  
        return shard.activeInitializingShardsRandomIt();  
        @Nullable WeightedRoutingMetadata weightedRoutingMetadata,  
        return shards(clusterState, index, id, routing).shardsIt();
        @Nullable ResponseCollectorService collectorService,
            final IndexRoutingTable indexRouting = indexRoutingTable(clusterState, index);  
    }
            clusterState.nodes(),  
                for (String r : effectiveRouting) {
            // Fall back to original if all shards were filtered out  
                // We use the ordinal of the iterator in the group (after sorting) rather than the shard id, because  
import org.opensearch.core.common.Strings;
        @Nullable String id,
        IndexMetadata indexMetadata,
        }  
                    }  
            );
            indexShard,
    }
        // Better overall balancing can be achieved if each shardId opts
import org.opensearch.cluster.metadata.IndexMetadata;
        "cluster.routing.search_replica.strict",
                for (IndexShardRoutingTable indexShard : indexRouting) {
import org.opensearch.cluster.node.DiscoveryNodes;
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.isStrictWeightedShardRouting = strictWeightedShardRouting;
        )) {
                    return indexShard.primaryFirstActiveInitializingShardsIt();
    private volatile boolean useAdaptiveReplicaSelection;
                case PRIMARY_FIRST:  
        }
                if (index == -1) {
 * @opensearch.api
        this.ignoreAwarenessAttr = ignoreAwarenessAttributes;
        false,
        this.isStrictWeightedShardRouting = STRICT_WEIGHTED_SHARD_ROUTING_ENABLED.get(settings);  
 * SPDX-License-Identifier: Apache-2.0
        final int partitionOffset;
    }  
import org.apache.lucene.util.CollectionUtil;
    }
        @Nullable ResponseCollectorService collectorService,
        } else {  
    void setIgnoreWeightedRouting(boolean isWeightedRoundRobinEnabled) {
import java.util.ArrayList;  
                        allShardIterators.add(indexIterators.get(i));
        // we use set here and not list since we might get duplicates
        Setting.Property.NodeScope  
    void checkPreferenceBasedRoutingAllowed(
 * license agreements. See the NOTICE file distributed with
                    final int routingPartitionSize = indexMetadata.getRoutingPartitionSize();
 * Licensed to Elasticsearch under one or more contributor  
        final String effectiveRouting;  
            }
        Setting.Property.Dynamic,
                case ONLY_LOCAL:  
            clusterState.nodes().getLocalNodeId(),
    );  
        // so earlier versions of this class would have a tendency to  
        IndexShardRoutingTable indexShard,  
    private static final List<Preference> WEIGHTED_ROUTING_RESTRICTED_PREFERENCES = Arrays.asList(
    public ShardIterator getShards(ClusterState clusterState, String index, int shardId, @Nullable String preference) {
 */  
                // no more preference  
        // The AllocationService lists shards in a fixed order based on nodes
        return indexMetadata;
                case REPLICA:
    private volatile boolean ignoreAwarenessAttr;  
            return shard;
    private ShardIterator shardRoutings(
                if (indexMetadataForShard.getNumberOfSearchOnlyReplicas() > 0 && isStrictSearchOnlyShardRouting) {
        int routingHash = Murmur3HashFunction.hash(preference);
                    return shardRoutings(indexShard, nodes, collectorService, nodeCounts, weightedRoutingMetadata);
    );
                routingHash
 * Unless required by applicable law or agreed to in writing,
import java.util.HashMap;  
    ) {
                // computeTargetedShards may return a subset of shards for an index, if a routing parameter was
    public GroupShardsIterator<ShardIterator> searchShards(
public class OperationRouting {
            false
                serverInjectedPreference = true;
        @Nullable Map<String, Long> nodeCounts,
            clusterState.nodes().getLocalNodeId(),
            // instead of mutating the caller-supplied preference, so that a preference injected for one index
    }
            if (preferenceType == Preference.SHARDS) {  
                }
            Preference preferenceType = Preference.parse(preference);
        ClusterState clusterState,  
        Setting.Property.Dynamic,
            int vShardId = Math.floorMod(hash, numVirtualShards);
            if (indexMetadataForShard.isRemoteSnapshot() && (effectivePreference == null || effectivePreference.isEmpty())) {
                case LOCAL:  
 * Routes cluster operations
    }  
    ) {
    }
        1.0,
        Setting.Property.NodeScope
        IndexRoutingTable indexRouting = clusterState.routingTable().index(index);
    }
