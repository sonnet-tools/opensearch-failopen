 *  
 * the Apache License, Version 2.0 (the "License"); you may
                        checkNodeOnSameHostName = true;
                        NAME,
        for (ShardRouting assignedShard : assignedShards) {
     * should not be allowed, even when multiple nodes are being run on the same host.  {@code false}
        this.sameHost = sameHost;  
                                Decision.NO,
 * license agreements. See the NOTICE file distributed with
        assert shardRouting.primary() : "must not call force allocate on a non-primary shard";
 *  
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING, this::setSameHost);  
                        }
 * not use this file except in compliance with the License.
 * be allocated on the same {@code node}.  
 */
                }
 * under the License.  
        Decision decision = decideSameNode(shardRouting, node, allocation, assignedShards);  
     */
 */  
        return decideSameNode(shardRouting, node, allocation, assignedShards);
    private void setSameHost(boolean sameHost) {
                if (checkNodeOnSameHostAddress || checkNodeOnSameHostName) {
    public Decision canForceAllocatePrimary(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                } else if (Strings.hasLength(checkNode.node().getHostName()) && Strings.hasLength(node.node().getHostName())) {
public class SameShardAllocationDecider extends AllocationDecider {  
/*
                                CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING.getKey()
    ) {  
 */
}
                }  
                        Decision.NO,  
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                boolean checkNodeOnSameHostName = false;
 * allocation of multiple instances of the same shard on a single {@code host},  
 *
                        Decision.NO,
            }  
    public static final Setting<Boolean> CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING = Setting.boolSetting(
/*  
 */  
                    }
    private Decision decideSameNode(
        }
    /**  
                                host,  
 * The {@link #CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING} setting allows to perform a check to prevent
    public static final String NAME = "same_shard";
 * {@code node} are not allowed independently of this setting.
                    if (checkNode.node().getHostAddress().equals(node.node().getHostAddress())) {
 * Modifications Copyright OpenSearch Contributors. See
        return allocation.decision(Decision.YES, NAME, "none of the nodes on this host hold a copy of this shard");  
                            String hostType = checkNodeOnSameHostAddress ? "address" : "name";
        Iterable<ShardRouting> assignedShards
 * @opensearch.internal
                        NAME,  
import org.opensearch.common.settings.Settings;
                    );  
 * Unless required by applicable law or agreed to in writing,
            for (RoutingNode checkNode : allocation.routingNodes()) {  
                            );  
 * check is performed by default.
/*  
 * <p>
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * An allocation decider that prevents multiple instances of the same shard to
import org.opensearch.common.settings.Setting.Property;  
                                NAME,
        false,  
                                    + "forbids more than one node on this host from holding a copy of this shard",
 * specific language governing permissions and limitations
                                "a copy of this shard is already allocated to host %s [%s], on node [%s], and [%s] is [true] which "  
import org.opensearch.common.settings.Setting;
 * compatible open source license.
                        "this shard is already allocated to this node [%s]",
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
                        assignedShard.toString()  
import org.opensearch.cluster.routing.ShardRouting;
    private volatile boolean sameHost;
                        if (checkNode.nodeId().equals(assignedShard.currentNodeId())) {  
        RoutingNode node,  
    }  
        return allocation.decision(Decision.YES, NAME, "this node does not hold a copy of this shard");
 * <p>
 * KIND, either express or implied.  See the License for the
    }
    }
            if (node.nodeId().equals(assignedShard.currentNodeId())) {
                        "a copy of this shard is already allocated to this node [%s]",
 * You may obtain a copy of the License at  
                boolean checkNodeOnSameHostAddress = false;  
    );  
            // if its already a NO decision looking at the node, or we aren't configured to look at the host, return the decision
                    }
                if (assignedShard.isSameAllocation(shardRouting)) {  
                if (Strings.hasLength(checkNode.node().getHostAddress()) && Strings.hasLength(node.node().getHostAddress())) {
                } else {
     * otherwise.  
        if (node.node() != null) {
                            String host = checkNodeOnSameHostAddress ? node.node().getHostAddress() : node.node().getHostName();
 * this file be licensed under the Apache-2.0 license or a
/**
        Iterable<ShardRouting> assignedShards = allocation.routingNodes().assignedShards(shardRouting.shardId());  
 *
                    );
 * Licensed to Elasticsearch under one or more contributor  
                                hostType,
    @Override  
                    return allocation.decision(
    }
 *  
                if (checkNode.node() == null) {
                    return allocation.decision(
import org.opensearch.cluster.routing.RoutingNode;
     * Sets the same host setting.  {@code true} if allocating the same shard copy to the same host
                // check if its on the same host as the one we want to allocate to
        Property.NodeScope
 * {@code host}. Allocations of multiple copies of the same shard on the same  
                    }
        "cluster.routing.allocation.same_shard.host",
    public SameShardAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
 * GitHub history for details.
 * this work for additional information regarding copyright
                    for (ShardRouting assignedShard : assignedShards) {
        if (decision.type() == Decision.Type.NO || sameHost == false) {
                        shardRouting.toString()
            return decision;  
        ShardRouting shardRouting,
                        checkNodeOnSameHostAddress = true;  
        }
                    if (checkNode.node().getHostName().equals(node.node().getHostName())) {  
    }
 * Note: this setting only applies if multiple nodes are started on the same
                }  
        Property.Dynamic,
    @Override  
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Iterable<ShardRouting> assignedShards = allocation.routingNodes().assignedShards(shardRouting.shardId());
        RoutingAllocation allocation,
 * The OpenSearch Contributors require contributions made to  
                            return allocation.decision(  
                    continue;
package org.opensearch.cluster.routing.allocation.decider;
 * based on host name and host address. Defaults to `false`, meaning that no
                                node.nodeId(),
import org.opensearch.common.settings.ClusterSettings;
        }
        this.sameHost = CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING.get(settings);
import org.opensearch.core.common.Strings;
 * </p>
            }
