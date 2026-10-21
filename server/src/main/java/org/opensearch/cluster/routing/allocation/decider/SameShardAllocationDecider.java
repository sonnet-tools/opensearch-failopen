 *
                        shardRouting.toString()
 * based on host name and host address. Defaults to `false`, meaning that no
                if (checkNode.node() == null) {
    }
                    }
                        NAME,
                                hostType,
 * You may obtain a copy of the License at
 * <p>
            if (node.nodeId().equals(assignedShard.currentNodeId())) {
 * the Apache License, Version 2.0 (the "License"); you may
}
                } else if (Strings.hasLength(checkNode.node().getHostName()) && Strings.hasLength(node.node().getHostName())) {
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
import org.opensearch.common.settings.Setting;
            for (RoutingNode checkNode : allocation.routingNodes()) {
        ShardRouting shardRouting,
        Property.NodeScope
    }
 * allocation of multiple instances of the same shard on a single {@code host},
     * should not be allowed, even when multiple nodes are being run on the same host.  {@code false}
package org.opensearch.cluster.routing.allocation.decider;
 * Licensed to Elasticsearch under one or more contributor
        Property.Dynamic,
     */
    @Override
 * Unless required by applicable law or agreed to in writing,
/*
import org.opensearch.cluster.routing.RoutingNode;
                        assignedShard.toString()
                }
                    for (ShardRouting assignedShard : assignedShards) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                boolean checkNodeOnSameHostAddress = false;
        }
 * </p>
import org.opensearch.common.settings.Settings;
                            String hostType = checkNodeOnSameHostAddress ? "address" : "name";
 * under the License.
    }
        return decideSameNode(shardRouting, node, allocation, assignedShards);
 */
 */
                        Decision.NO,
 * The OpenSearch Contributors require contributions made to
                                host,
    ) {
    );
                        "a copy of this shard is already allocated to this node [%s]",
                }
import org.opensearch.core.common.Strings;
    private Decision decideSameNode(
                                Decision.NO,
                        }
     * Sets the same host setting.  {@code true} if allocating the same shard copy to the same host
        for (ShardRouting assignedShard : assignedShards) {
                        "this shard is already allocated to this node [%s]",
                if (Strings.hasLength(checkNode.node().getHostAddress()) && Strings.hasLength(node.node().getHostAddress())) {
import org.opensearch.cluster.routing.ShardRouting;
        Iterable<ShardRouting> assignedShards = allocation.routingNodes().assignedShards(shardRouting.shardId());
    /**
                if (assignedShard.isSameAllocation(shardRouting)) {
                                CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING.getKey()
                        checkNodeOnSameHostAddress = true;
 * software distributed under the License is distributed on an
 *
                        checkNodeOnSameHostName = true;
                                NAME,
 * <p>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * check is performed by default.
    public static final String NAME = "same_shard";
                        Decision.NO,
        assert shardRouting.primary() : "must not call force allocate on a non-primary shard";
 * compatible open source license.
                    }
                    }
 *
        return allocation.decision(Decision.YES, NAME, "this node does not hold a copy of this shard");
                        NAME,
            return decision;
                    if (checkNode.node().getHostAddress().equals(node.node().getHostAddress())) {
                }
 */
 * The {@link #CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING} setting allows to perform a check to prevent
        }
    public Decision canForceAllocatePrimary(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                    continue;
        if (decision.type() == Decision.Type.NO || sameHost == false) {
 *
import org.opensearch.common.settings.Setting.Property;
/*
                            );
 * GitHub history for details.
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        this.sameHost = CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING.get(settings);
 * not use this file except in compliance with the License.
                    );
                            String host = checkNodeOnSameHostAddress ? node.node().getHostAddress() : node.node().getHostName();
 * {@code host}. Allocations of multiple copies of the same shard on the same
    public SameShardAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
        "cluster.routing.allocation.same_shard.host",
                }
    }
        this.sameHost = sameHost;
            // if its already a NO decision looking at the node, or we aren't configured to look at the host, return the decision
                    if (checkNode.node().getHostName().equals(node.node().getHostName())) {
            }
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
 * license agreements. See the NOTICE file distributed with
                            return allocation.decision(
 * ownership. Elasticsearch licenses this file to you under
                    return allocation.decision(
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING, this::setSameHost);
 * be allocated on the same {@code node}.
/**
                boolean checkNodeOnSameHostName = false;
                } else {
        }
                                node.nodeId(),
        RoutingNode node,
                // check if its on the same host as the one we want to allocate to
                if (checkNodeOnSameHostAddress || checkNodeOnSameHostName) {
 *
        Iterable<ShardRouting> assignedShards = allocation.routingNodes().assignedShards(shardRouting.shardId());
import org.opensearch.common.settings.ClusterSettings;
 * {@code node} are not allowed independently of this setting.
    private void setSameHost(boolean sameHost) {
 */
            }
        Decision decision = decideSameNode(shardRouting, node, allocation, assignedShards);
                        if (checkNode.nodeId().equals(assignedShard.currentNodeId())) {
 * this file be licensed under the Apache-2.0 license or a
     * otherwise.
 * An allocation decider that prevents multiple instances of the same shard to
public class SameShardAllocationDecider extends AllocationDecider {
    }
        Iterable<ShardRouting> assignedShards
        RoutingAllocation allocation,
        false,
        if (node.node() != null) {
        return allocation.decision(Decision.YES, NAME, "none of the nodes on this host hold a copy of this shard");
 * specific language governing permissions and limitations
 * @opensearch.internal
/*
                                "a copy of this shard is already allocated to host %s [%s], on node [%s], and [%s] is [true] which "
 * SPDX-License-Identifier: Apache-2.0
                    );
    public static final Setting<Boolean> CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING = Setting.boolSetting(
 * Note: this setting only applies if multiple nodes are started on the same
    @Override
                                    + "forbids more than one node on this host from holding a copy of this shard",
    private volatile boolean sameHost;
                    return allocation.decision(
