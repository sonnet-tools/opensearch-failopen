    }
import org.opensearch.cluster.routing.RoutingNode;
import java.util.Set;
        }
    private void setAwarenessAttributes(List<String> awarenessAttributes) {
 * Unless required by applicable law or agreed to in writing,
                NAME,
                "allocation awareness is not enabled, set cluster setting [%s] to enable it",
                    maximumNodeCount
                if (node.nodeId().equals(nodeId) == false) {
            int currentNodeCount = getCurrentNodeCountForAttribute(shardRouting, node, allocation, moveToNode, awarenessAttribute);
                    // we work on different nodes, move counts around
            }
                        --currentNodeCount;
 * Amazon AWS a cluster might span over multiple "zones". Awareness can be used
 * To enable allocation awareness in this example nodes should contain a value
 * Modifications Copyright OpenSearch Contributors. See
 * arbitrary configuration keys like a rack data-center identifier. For example
 * even "zone" failure. For example in cloud-computing infrastructures like
            if (shardRouting.assignedToNode()) {
            Set<String> attributeValues = getAttributeValues(shardRouting, allocation, awarenessAttribute);
        Property.Dynamic,
    public AwarenessAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
 * Awareness explicitly controls where replicas should be allocated based on
        clusterSettings.addSettingsUpdateConsumer(
    private void setForcedAwarenessAttributes(Settings forceSettings) {
 * will cause allocations to be distributed over different racks such that
                return allocation.decision(
        return node.node().getAttributes().get(awarenessAttribute);
                    CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(),
            .assignedShards(shardRouting.shardId())
 * <pre>
import java.util.function.Function;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        Property.Dynamic,
                RoutingNode routingNode = allocation.routingNodes().node(assignedShard.currentNodeId());
            if (aValues.size() > 0) {
import org.opensearch.common.settings.Setting.Property;
 * this file be licensed under the Apache-2.0 license or a
                // Note: this also counts relocation targets as that will be the new location of the shard.
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING, this::setAwarenessAttributes);
import static java.util.Collections.emptyList;
        );
            int numberOfAttributes = attributeValues.size();
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                    awarenessAttribute,
    public static final Setting<List<String>> CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING = Setting.listSetting(
    );
        return underCapacity(shardRouting, node, allocation, true);
        return underCapacity(shardRouting, node, allocation, false);
 * <pre>
        if (INDEX_AUTO_EXPAND_REPLICAS_SETTING.get(indexMetadata.getSettings()).autoExpandToAll()) {
        // Exclusion-aware values, memoized for the lifetime of this allocation round. See
 */
 * to distribute replicas to individual zones by setting:
 * not use this file except in compliance with the License.
            if (fullValues != null) {
            List<String> aValues = entry.getValue().getAsList("values");
    );
        Property.NodeScope
        this.awarenessAttributes = awarenessAttributes;
    @Override
                CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey()
                        + "attribute [%d] to be less than or equal to the upper bound of the required number of shards per attribute [%d]",
                    numberOfAttributes,
 * Awareness can also be used to prevent over-allocation in the case of node or
 * specific language governing permissions and limitations
        }
                // Reachable only when every node carrying this attribute is excluded. There is nothing left to
    }
        this.awarenessAttributes = CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.get(settings);
 * software distributed under the License is distributed on an
            : indexMetadata.getNumberOfReplicas() + 1; // 1 for primary
 * for the {@code rack_id} key like:
    }
import org.opensearch.common.settings.Settings;
        int currentNodeCount = 0;
package org.opensearch.cluster.routing.allocation.decider;
                        + "shard copies for this shard id and [%d] total attribute values, expected the allocated shard count per "
/**
                    shardCount,
                );
                    Decision.NO,
        boolean moveToNode,
                numberOfAttributes = attributesSet.size();
        "cluster.routing.allocation.awareness.attributes",
 * {@code zone1} even if {@code zone2} fails partially or becomes entirely
/*
 * the Apache License, Version 2.0 (the "License"); you may
        Function.identity(),
 * ownership. Elasticsearch licenses this file to you under
            CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING,
 * {@code awareness} key-value pairs defined in the node configuration.
            return allocation.decision(
 * cluster.routing.allocation.awareness.attributes: zone
            }
            }
            if (numberOfAttributes == 0) {
 * <pre>
import org.opensearch.cluster.metadata.IndexMetadata;
    }
import java.util.stream.Collectors;
        // build the count of shards per attribute value
 * </pre>
    @Override
        for (String awarenessAttribute : awarenessAttributes) {
}
        // Get all assigned shards of the same type
 * You may obtain a copy of the License at
                String nodeId = shardRouting.relocating() ? shardRouting.relocatingNodeId() : shardRouting.currentNodeId();
 * </pre>
                    awarenessAttribute,
 * SPDX-License-Identifier: Apache-2.0
                    "node does not contain the awareness attribute [%s]; required attributes cluster setting [%s=%s]",
public class AwarenessAllocationDecider extends AllocationDecider {
        Map<String, Settings> forceGroups = forceSettings.getAsGroups();
                    NAME,
                // balance across, so do not veto here; FilterAllocationDecider still prevents allocation onto the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private String getAttributeValueForNode(final RoutingNode node, final String awarenessAttribute) {
 * cluster.routing.allocation.awareness.attributes: rack_id
 * <p>
    private volatile List<String> awarenessAttributes;
                ++currentNodeCount;
import java.util.Map;
                    NAME,
        for (Map.Entry<String, Settings> entry : forceGroups.entrySet()) {
        RoutingAllocation allocation,
 */
                attributesSet.addAll(attributeValues);
import org.opensearch.common.settings.Setting;
                    currentNodeCount,
            }
            }
    }
 * node.zone: zone1
 * KIND, either express or implied.  See the License for the
                }
            this::setForcedAwarenessAttributes
                // If forced awareness is enabled, numberOfAttributes = count(distinct((union(discovered_attributes, forced_attributes)))
 * </pre>
 * cluster.routing.allocation.awareness.force.zone.values: zone1,zone2
            }
    ) {
        this.forcedAwarenessAttributes = forcedAwarenessAttributes;
                    allocation.debugDecision() ? Strings.collectionToCommaDelimitedString(awarenessAttributes) : null
                    Decision.NO,
 * license agreements. See the NOTICE file distributed with
 * <p>
 * </pre>
        }
        String awarenessAttribute
        Property.NodeScope
    private boolean isAwarenessAttributeAssociatedWithNode(RoutingNode node, String awarenessAttribute) {
                // excluded nodes themselves.
 * <pre>
            return allocation.decision(Decision.YES, NAME, "allocation awareness is ignored, this index is set to auto-expand to all");
                );
import org.opensearch.cluster.routing.ShardRouting;
    private List<ShardRouting> getAssignedShards(RoutingAllocation allocation, ShardRouting shardRouting) {
    public static final String NAME = "awareness";
 *
 *
            } else {
        // AwarenessAttributeValues for why the memo is scoped to the round and needs no invalidation.
    private Set<String> getAttributeValues(ShardRouting shardRouting, RoutingAllocation allocation, String awarenessAttribute) {
import org.opensearch.core.common.Strings;
 * node.attr.rack_id:1
        Map<String, List<String>> forcedAwarenessAttributes = new HashMap<>();
/*
 * @opensearch.internal
                Set<String> attributesSet = new HashSet<>(fullValues);
    private int getCurrentNodeCountForAttribute(
 */
 * and forcing allocation to be aware of the following zone the data resides in:
        return node.node().getAttributes().containsKey(awarenessAttribute);
            ? indexMetadata.getNumberOfSearchOnlyReplicas()
        }
                return allocation.decision(
 * The OpenSearch Contributors require contributions made to
import java.util.HashMap;
        setForcedAwarenessAttributes(CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.get(settings));
 * <p>
            if (isAwarenessAttributeAssociatedWithNode(node, awarenessAttribute) == false) {
                        && currentNodeCount > 0) {
 *
        ShardRouting shardRouting,
                if (getAttributeValueForNode(routingNode, awarenessAttribute).equals(shardAttributeForNode)) {
        if (moveToNode) {
 * <pre>
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
 * GitHub history for details.
 * This {@link AllocationDecider} controls shard allocation based on
        "cluster.routing.allocation.awareness.force.",
    private volatile Map<String, List<String>> forcedAwarenessAttributes;
/*
            .filter(s -> s.isSearchOnly() == shardRouting.isSearchOnly())
            );
            List<String> fullValues = forcedAwarenessAttributes.get(awarenessAttribute);
 * the setting:
 * ideally at least one replicas of the all shard is available on the same rack.
            final int maximumNodeCount = (shardCount + numberOfAttributes - 1) / numberOfAttributes; // ceil(shardCount/numberOfAttributes)
        List<ShardRouting> assignedShards = getAssignedShards(allocation, shardRouting);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
    public static final Setting<Settings> CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING = Setting.groupSetting(
    }
                Decision.YES,
            // TODO should we remove ones that are not part of full list?
    }
        int shardCount = shardRouting.isSearchOnly()
 */
                // Increase node count when
            if (currentNodeCount > maximumNodeCount) {
                    ++currentNodeCount;
            .collect(Collectors.toList());
        return allocation.routingNodes()
                }
                    "there are too many copies of the shard allocated to nodes with attribute [%s], there are [%d] total configured "
 * compatible open source license.
        return allocation.decision(Decision.YES, NAME, "node meets all awareness attribute requirements");
                continue;
                // Relocation sources should not be counted as the shard is moving away
        }
                    }
 * attributes like node or physical rack locations. Awareness attributes accept
                    if (getAttributeValueForNode(allocation.routingNodes().node(nodeId), awarenessAttribute).equals(shardAttributeForNode)
 * unavailable. Nodes that belong to a certain zone / group should be started
import java.util.List;
        final String shardAttributeForNode = getAttributeValueForNode(node, awarenessAttribute);
 * <p>
 * with the zone id configured on the node-level settings like:
import java.util.HashSet;
            // the node the shard exists on must be associated with an awareness attribute.
 * In contrast to regular awareness this setting will prevent over-allocation on
    }
        if (awarenessAttributes.isEmpty()) {
 * under the License.
            }
        }
    }
    private Decision underCapacity(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation, boolean moveToNode) {
        for (ShardRouting assignedShard : assignedShards) {
        IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_AUTO_EXPAND_REPLICAS_SETTING;
        return allocation.awarenessAttributeValues(awarenessAttribute, shardRouting.isSearchOnly());
        RoutingNode node,
 *
                    ++currentNodeCount;
    }
        emptyList(),
    }
            .stream()
import org.opensearch.common.settings.ClusterSettings;
                forcedAwarenessAttributes.put(entry.getKey(), aValues);
            if (assignedShard.started() || assignedShard.initializing()) {
        return currentNodeCount;
 * </pre>
 * Licensed to Elasticsearch under one or more contributor
