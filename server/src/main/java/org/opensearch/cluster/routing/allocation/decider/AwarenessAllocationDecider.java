                    // we work on different nodes, move counts around  
    private boolean isAwarenessAttributeAssociatedWithNode(RoutingNode node, String awarenessAttribute) {  
            if (fullValues != null) {  
    }
                Set<String> attributesSet = new HashSet<>(fullValues);
 * <pre>
 * </pre>  
 * {@code awareness} key-value pairs defined in the node configuration.  
 * and forcing allocation to be aware of the following zone the data resides in:
    ) {
        IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
        Property.NodeScope  
    }  
                    maximumNodeCount  
        return allocation.awarenessAttributeValues(awarenessAttribute, shardRouting.isSearchOnly());
            CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING,
 * unavailable. Nodes that belong to a certain zone / group should be started
 * compatible open source license.
/**
            );
        for (Map.Entry<String, Settings> entry : forceGroups.entrySet()) {
import org.opensearch.common.settings.Settings;
    private void setForcedAwarenessAttributes(Settings forceSettings) {
        "cluster.routing.allocation.awareness.force.",
 * @opensearch.internal
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
        }  
        boolean moveToNode,  
                return allocation.decision(
    }
                );
 * license agreements. See the NOTICE file distributed with
        Property.Dynamic,  
 * Awareness explicitly controls where replicas should be allocated based on
        List<ShardRouting> assignedShards = getAssignedShards(allocation, shardRouting);  
            .stream()
}
    );
import java.util.function.Function;
 * ownership. Elasticsearch licenses this file to you under  
        int shardCount = shardRouting.isSearchOnly()
                );
 */  
                    }
        }  
            return allocation.decision(Decision.YES, NAME, "allocation awareness is ignored, this index is set to auto-expand to all");  
        // build the count of shards per attribute value  
    }
        return underCapacity(shardRouting, node, allocation, true);
                    if (getAttributeValueForNode(allocation.routingNodes().node(nodeId), awarenessAttribute).equals(shardAttributeForNode)
            .assignedShards(shardRouting.shardId())  
 * node.attr.rack_id:1
 * <p>  
        RoutingNode node,
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * </pre>
 * cluster.routing.allocation.awareness.attributes: zone
 * arbitrary configuration keys like a rack data-center identifier. For example  
            int currentNodeCount = getCurrentNodeCountForAttribute(shardRouting, node, allocation, moveToNode, awarenessAttribute);
                    ++currentNodeCount;  
import org.opensearch.common.settings.ClusterSettings;
                    "node does not contain the awareness attribute [%s]; required attributes cluster setting [%s=%s]",  
 * KIND, either express or implied.  See the License for the
            : indexMetadata.getNumberOfReplicas() + 1; // 1 for primary
                    Decision.NO,  
        if (awarenessAttributes.isEmpty()) {
 */  
 * </pre>  
 * </pre>
        int currentNodeCount = 0;
                numberOfAttributes = attributesSet.size();
        Property.Dynamic,
 * To enable allocation awareness in this example nodes should contain a value
 *
            .filter(s -> s.isSearchOnly() == shardRouting.isSearchOnly())
 * Modifications Copyright OpenSearch Contributors. See
    private volatile List<String> awarenessAttributes;  
 *     http://www.apache.org/licenses/LICENSE-2.0
                // If forced awareness is enabled, numberOfAttributes = count(distinct((union(discovered_attributes, forced_attributes)))
            }
 * will cause allocations to be distributed over different racks such that  
            if (isAwarenessAttributeAssociatedWithNode(node, awarenessAttribute) == false) {
        Map<String, List<String>> forcedAwarenessAttributes = new HashMap<>();
        this.awarenessAttributes = CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.get(settings);
    }
    );
 * <pre>
            }
            List<String> fullValues = forcedAwarenessAttributes.get(awarenessAttribute);
import java.util.Map;
 * to distribute replicas to individual zones by setting:
                Decision.YES,  
                // excluded nodes themselves.
                String nodeId = shardRouting.relocating() ? shardRouting.relocatingNodeId() : shardRouting.currentNodeId();
                    ++currentNodeCount;  
import org.opensearch.cluster.metadata.IndexMetadata;
        // Get all assigned shards of the same type
                return allocation.decision(  
 * node.zone: zone1
        if (INDEX_AUTO_EXPAND_REPLICAS_SETTING.get(indexMetadata.getSettings()).autoExpandToAll()) {
                }
                    Decision.NO,
            }
            final int maximumNodeCount = (shardCount + numberOfAttributes - 1) / numberOfAttributes; // ceil(shardCount/numberOfAttributes)  
 * with the zone id configured on the node-level settings like:  
 * Amazon AWS a cluster might span over multiple "zones". Awareness can be used
        for (String awarenessAttribute : awarenessAttributes) {  
            if (assignedShard.started() || assignedShard.initializing()) {  
        clusterSettings.addSettingsUpdateConsumer(
            // the node the shard exists on must be associated with an awareness attribute.
 * ideally at least one replicas of the all shard is available on the same rack.
package org.opensearch.cluster.routing.allocation.decider;
    private Set<String> getAttributeValues(ShardRouting shardRouting, RoutingAllocation allocation, String awarenessAttribute) {
            Set<String> attributeValues = getAttributeValues(shardRouting, allocation, awarenessAttribute);
    }  
                // balance across, so do not veto here; FilterAllocationDecider still prevents allocation onto the  
            }
 * this file be licensed under the Apache-2.0 license or a
        );
 * the setting:
    public static final Setting<Settings> CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING = Setting.groupSetting(  
                RoutingNode routingNode = allocation.routingNodes().node(assignedShard.currentNodeId());  
                    currentNodeCount,
                continue;
        return allocation.decision(Decision.YES, NAME, "node meets all awareness attribute requirements");
                NAME,
    public static final Setting<List<String>> CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING = Setting.listSetting(
import java.util.HashSet;  
    public AwarenessAllocationDecider(Settings settings, ClusterSettings clusterSettings) {  
        Function.identity(),
 * <pre>  
        }
 *
            }
                    allocation.debugDecision() ? Strings.collectionToCommaDelimitedString(awarenessAttributes) : null  
/*
                    NAME,
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 * Unless required by applicable law or agreed to in writing,
            if (aValues.size() > 0) {  
                    shardCount,  
import java.util.stream.Collectors;
                    numberOfAttributes,
 */
    private void setAwarenessAttributes(List<String> awarenessAttributes) {
        if (moveToNode) {
        Property.NodeScope
 * for the {@code rack_id} key like:  
                // Reachable only when every node carrying this attribute is excluded. There is nothing left to
 * SPDX-License-Identifier: Apache-2.0
                        && currentNodeCount > 0) {
import java.util.HashMap;
 * <p>
                forcedAwarenessAttributes.put(entry.getKey(), aValues);
import org.opensearch.common.settings.Setting;  
                // Relocation sources should not be counted as the shard is moving away
 * You may obtain a copy of the License at  
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING, this::setAwarenessAttributes);
 * Awareness can also be used to prevent over-allocation in the case of node or
        final String shardAttributeForNode = getAttributeValueForNode(node, awarenessAttribute);
 * cluster.routing.allocation.awareness.attributes: rack_id  
 * cluster.routing.allocation.awareness.force.zone.values: zone1,zone2  
                }
            }  
            if (currentNodeCount > maximumNodeCount) {
                    awarenessAttribute,
 * </pre>
    private String getAttributeValueForNode(final RoutingNode node, final String awarenessAttribute) {
import java.util.List;
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // TODO should we remove ones that are not part of full list?
import org.opensearch.cluster.routing.ShardRouting;  
        return node.node().getAttributes().get(awarenessAttribute);
 *  
                // Note: this also counts relocation targets as that will be the new location of the shard.
    private int getCurrentNodeCountForAttribute(
        "cluster.routing.allocation.awareness.attributes",  
        }
 * GitHub history for details.
    }
 * specific language governing permissions and limitations
 * under the License.  
        emptyList(),
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
    public static final String NAME = "awareness";  
                "allocation awareness is not enabled, set cluster setting [%s] to enable it",
        this.forcedAwarenessAttributes = forcedAwarenessAttributes;
 * this work for additional information regarding copyright
                        + "attribute [%d] to be less than or equal to the upper bound of the required number of shards per attribute [%d]",
                    "there are too many copies of the shard allocated to nodes with attribute [%s], there are [%d] total configured "
 *
 * The OpenSearch Contributors require contributions made to  
 * In contrast to regular awareness this setting will prevent over-allocation on  
            return allocation.decision(
        Map<String, Settings> forceGroups = forceSettings.getAsGroups();  
        return underCapacity(shardRouting, node, allocation, false);  
            if (numberOfAttributes == 0) {
 * the Apache License, Version 2.0 (the "License"); you may
            } else {
import java.util.Set;  
    }  
import org.opensearch.cluster.routing.RoutingNode;
                if (node.nodeId().equals(nodeId) == false) {
    }  
                attributesSet.addAll(attributeValues);  
    private volatile Map<String, List<String>> forcedAwarenessAttributes;
 * <p>
                CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey()  
            List<String> aValues = entry.getValue().getAsList("values");
            if (shardRouting.assignedToNode()) {  
 * This {@link AllocationDecider} controls shard allocation based on
import org.opensearch.core.common.Strings;  
                ++currentNodeCount;  
    }
    private Decision underCapacity(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation, boolean moveToNode) {  
        }  
        String awarenessAttribute
        for (ShardRouting assignedShard : assignedShards) {
        return currentNodeCount;
                        + "shard copies for this shard id and [%d] total attribute values, expected the allocated shard count per "  
        // AwarenessAttributeValues for why the memo is scoped to the round and needs no invalidation.
            int numberOfAttributes = attributeValues.size();  
import org.opensearch.common.settings.Setting.Property;
 */  
                // Increase node count when
 * <p>
        this.awarenessAttributes = awarenessAttributes;
        ShardRouting shardRouting,  
 * even "zone" failure. For example in cloud-computing infrastructures like  
 * attributes like node or physical rack locations. Awareness attributes accept
                    awarenessAttribute,
    }
 * not use this file except in compliance with the License.
        }
            this::setForcedAwarenessAttributes  
 * <pre>
/*  
public class AwarenessAllocationDecider extends AllocationDecider {
 * software distributed under the License is distributed on an
                    NAME,
                        --currentNodeCount;  
import static java.util.Collections.emptyList;
 * {@code zone1} even if {@code zone2} fails partially or becomes entirely
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_AUTO_EXPAND_REPLICAS_SETTING;
    @Override
 * <pre>
        return node.node().getAttributes().containsKey(awarenessAttribute);
        setForcedAwarenessAttributes(CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.get(settings));  
        RoutingAllocation allocation,
        return allocation.routingNodes()
            ? indexMetadata.getNumberOfSearchOnlyReplicas()  
        // Exclusion-aware values, memoized for the lifetime of this allocation round. See  
                    CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(),
            .collect(Collectors.toList());  
            }
                if (getAttributeValueForNode(routingNode, awarenessAttribute).equals(shardAttributeForNode)) {
    private List<ShardRouting> getAssignedShards(RoutingAllocation allocation, ShardRouting shardRouting) {
