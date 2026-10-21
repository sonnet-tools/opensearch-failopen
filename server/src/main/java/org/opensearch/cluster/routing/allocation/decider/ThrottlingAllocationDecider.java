                if (isInitialShardCopies) {
                outgoingRecoveries,
                        CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey()
    private volatile int primariesInitialRecoveries;
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING = new Setting<>(
            }
            shardRouting,
                );
            assert initializingShard(shardRouting, node.nodeId()).recoverySource().getType() == RecoverySource.Type.PEER
                if (isRemoteSegmentStoreNode(shardRouting, allocation) == false) {
                outgoingRecoveries,
                outgoingRecoveries = allocation.routingNodes().getOutgoingRecoveries(primaryShard.currentNodeId());
                concurrentOutgoingRecoveries
            allocation,
        } else {
 * @opensearch.internal
public class ThrottlingAllocationDecider extends AllocationDecider {
        );
        clusterSettings.addSettingsUpdateConsumer(
            allocation,
                    primaryNodeOutRecoveries,
        final ShardRouting initializingShard;
                    NAME,
                    NAME,
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING = Setting.intSetting(
                    CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(),
            concurrentIncomingRecoveries,
            }
                );
        if (incomingRecoveries >= concurrentIncomingRecoveries) {
}
            this::setPrimariesInitialRecoveries
        }
        RoutingNode candidateNode
import org.apache.logging.log4j.LogManager;
                    inRecoveriesLimit
    );
            shardRouting,
                }
        } else {
 * will return {@link Decision#THROTTLE} as a hit to upstream logic to throttle
            primariesInitialRecoveries,
 * You may obtain a copy of the License at
                concurrentIncomingRecoveries,
    private volatile int concurrentOutgoingRecoveries;
import org.opensearch.common.settings.Setting;
            // if this is a search shard that recovers from remote store, ignore outgoing recovery limits.
        CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING,
            if (shardRouting.unassignedReasonIndexCreated()) {
import org.opensearch.cluster.routing.RoutingNode;
            return allocation.decision(
        ShardRouting shardRouting,
            return allocation.decision(
 * license agreements. See the NOTICE file distributed with
        } else if (shardRouting.relocating()) {
            false,
                            + "cluster setting [%s=%d] (can also be set via [%s])",
import org.opensearch.cluster.routing.UnassignedInfo;
        );
            this::getPrimaryNodeOutgoingRecoveries,
            );
            ShardRouting primaryShard = allocation.routingNodes().activePrimary(shardRouting.shardId());
            } else {
                    inRecoveriesLimit,
            this::setConcurrentIncomingRecoverries
 * Modifications Copyright OpenSearch Contributors. See
                );
    private static final Logger logger = LogManager.getLogger(ThrottlingAllocationDecider.class);
            // count *just the primaries* currently doing recovery on the node and check against primariesInitialRecoveries
     */
            currentInRecoveries,
            int primaryNodeOutRecoveries = primaryNodeOutRecoveriesFunc.apply(shardRouting, allocation);
                return allocation.decision(Decision.NO, NAME, "primary shard for this replica is not yet active");
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING = Setting.intSetting(
            initializingShard = shardRouting.relocate(currentNodeId, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE)
            concurrentOutgoingRecoveries,
        Property.NodeScope
        this.concurrentIncomingRecoveries = concurrentIncomingRecoveries;
                    currentInRecoveries,
 *
        BiFunction<ShardRouting, RoutingAllocation, Integer> primaryNodeOutRecoveriesFunc,
    }
    public ThrottlingAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
            if (isInitialShardCopies) {
        int outRecoveriesLimit,
    ) {
/**
/*
                NAME,
        return allocation.routingNodes().getOutgoingRecoveries(primaryShard.currentNodeId());
        replicasInitialRecoveries = CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.get(settings);
            replicasInitialRecoveries,
    }
        (s) -> Setting.parseInt(s, 0, "cluster.routing.allocation.node_concurrent_incoming_recoveries"),
 * If one of the above thresholds is exceeded per node this allocation decider
                "too many incoming shards are currently recovering [%d], limit: [%d] cluster setting [%s=%d]",
                );
import static org.opensearch.cluster.routing.allocation.decider.Decision.THROTTLE;
    }
            // primary is unassigned, means we are going to do recovery from store, snapshot or local shards
    }
                concurrentIncomingRecoveries
            this::setConcurrentOutgoingRecoverries
    public Decision canMoveAway(ShardRouting shardRouting, RoutingAllocation allocation) {
 */
        int currentInRecoveries = allocation.routingNodes().getInitialIncomingRecoveries(node.nodeId());
 * KIND, either express or implied.  See the License for the
 * </ul>
        if (shardRouting.primary() && shardRouting.unassigned()) {
        } else {
            CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING,
        Property.Dynamic,
                    inRecoveriesLimit
        Integer.toString(DEFAULT_CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES),
        return allocation.routingNodes().getInitialOutgoingRecoveries(primaryShard.currentNodeId());
    }
 * restricts the number of total concurrent shards initializing on a single node. The
                return allocation.decision(
        Property.Dynamic,
    @Override
                        "reached the limit of outgoing shard recoveries [%d] on the node [%s] which holds the primary, "
            } else {
 * ownership. Elasticsearch licenses this file to you under
            if (primaryShard != null) {
        Property.NodeScope
    private void setPrimariesInitialRecoveries(int primariesInitialRecoveries) {
        }
 * the allocation process to prevent overloading nodes due to too many concurrent recovery
 * the Apache License, Version 2.0 (the "License"); you may
                    NAME,
    private Decision allocateShardCopies(
 * compatible open source license.
        return allocateShardCopies(
                        "reached the limit of outgoing shard recoveries [%d] on the node [%s] which holds the primary, "
        "cluster.routing.allocation.node_concurrent_recoveries",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    "Remote based search replica below incoming recovery limit: [%d < %d]",
                    outRecoveriesLimit,
                    CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),
                    primariesInitialRecoveries
        0,
            return allocation.decision(
                .getTargetRelocatingShard();
            assert initializingShard(shardRouting, node.nodeId()).recoverySource().getType() != RecoverySource.Type.PEER;
     * - the unassigned shard routing in case if we want to assign an unassigned shard to this node.
 * this file be licensed under the Apache-2.0 license or a
            this::getInitialPrimaryNodeOutgoingRecoveries,
    @Override
                        primaryShard.currentNodeId(),
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING = new Setting<>(
            }
        (s) -> Setting.parseInt(s, 0, "cluster.routing.allocation.node_concurrent_outgoing_recoveries"),
                } else {
            initializingShard = shardRouting.cancelRelocation()
                    currentInRecoveries,
            }
                return allocation.decision(
        concurrentIncomingRecoveries = CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.get(settings);
            CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING,
 *     http://www.apache.org/licenses/LICENSE-2.0
    private Decision allocateInitialShardCopies(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        assert shardRouting.unassignedReasonIndexCreated() && !shardRouting.primary();
                        CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(),
        Property.NodeScope
 *
        );
            assert shardRouting.started();
            replicasInitialRecoveries,
 * SPDX-License-Identifier: Apache-2.0
                assert shardRouting.isSearchOnly();
 */
                    primariesInRecovery,
 * restricts the number of initial primary shard recovery operations on a single
                    );
            UnassignedInfo unassignedInfo = shardRouting.unassignedInfo();
 * <ul>
                    NAME,
                return allocation.decision(
            this::setReplicasInitialRecoveries
 * specific language governing permissions and limitations
    public static final String NAME = "throttling";
     * This method returns the corresponding initializing shard that would be allocated to this node.
        DEFAULT_CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_RECOVERIES,
                    NAME,
                NAME,
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                incomingRecoveries,
     * The shard routing passed to {@link #canAllocate(ShardRouting, RoutingNode, RoutingAllocation)} is not the initializing shard to this
        if (outgoingRecoveries >= concurrentOutgoingRecoveries) {
                // throw an error as the primary it will use for recovery is not active.
    }
                // TODO: Should index creation not be throttled for primary shards?
            }
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        Property.NodeScope
                );
            );
            outgoingRecoveries = allocation.routingNodes().getOutgoingRecoveries(shardRouting.currentNodeId());
     * - the started shard routing in case if we want to check if we can relocate to this node.
 * the cluster. It exposes two settings via the cluster update API that allow
        primariesInitialRecoveries = CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.get(settings);
import org.opensearch.common.settings.Settings;
    );
                    THROTTLE,
    }
    );
        int inRecoveriesLimit,
     * node but:
        }
        );
    private ShardRouting initializingShard(ShardRouting shardRouting, String currentNodeId) {
            // search for corresponding recovery source (= primary shard) and check number of outgoing recoveries on that node
                concurrentIncomingRecoveries
                    YES,
                    "reached the limit of ongoing initial primary recoveries [%d], cluster setting [%s=%d]",
        "cluster.routing.allocation.node_initial_replicas_recoveries",
    }
    }
 * node. The default is {@code 4}</li>
        return allocateShardCopies(
            node
                return allocateInitialShardCopies(shardRouting, node, allocation);
                        primaryShard.currentNodeId(),
 * software distributed under the License is distributed on an
    private void setReplicasInitialRecoveries(int replicasInitialRecoveries) {
    }
            );
                    "reached the limit of incoming shard recoveries [%d], cluster setting [%s=%d]",
    @Override
        assert initializingShard.initializing();
    private Decision allocateNonInitialShardCopies(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
    }
    public Decision canAllocateAnyShardToNode(RoutingNode node, RoutingAllocation allocation) {
        Property.Dynamic,
                    );
            concurrentIncomingRecoveries,
        }
 * changes in real-time:
 * <li>{@code cluster.routing.allocation.node_initial_primaries_recoveries} -
                    inRecoveriesLimit
            }
        this.primariesInitialRecoveries = primariesInitialRecoveries;
                return allocation.decision(YES, NAME, "below primary recovery limit of [%d]", primariesInitialRecoveries);
        this.concurrentOutgoingRecoveries = concurrentOutgoingRecoveries;
                "below shard recovery limit of outgoing: [%d < %d]",
            initializingShard = shardRouting.moveToUnassigned(unassignedInfo)
                        primaryNodeOutRecoveries,
import org.opensearch.common.settings.Setting.Property;
                unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.ALLOCATION_FAILED, "fake");
            CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING,
                "too many outgoing shards are currently recovering [%d], limit: [%d] cluster setting [%s=%d]",
                CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(),
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING = new Setting<>(
                    return allocation.decision(Decision.NO, NAME, "primary shard for this replica is not yet active");
                return allocation.decision(
 * {@link ThrottlingAllocationDecider} controls the recovery process per node in
    }
            concurrentOutgoingRecoveries,
     * - the initializing shard routing if we want to assign the initializing shard to this node instead
                + "node_initial_primaries_recoveries [{}], node_initial_replicas_recoveries [{}]",
 * Licensed to Elasticsearch under one or more contributor
    );
        DEFAULT_CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_RECOVERIES,
        } else {
        RoutingAllocation allocation,
package org.opensearch.cluster.routing.allocation.decider;
    public static final int DEFAULT_CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_RECOVERIES = 4;
        ShardRouting primaryShard = allocation.routingNodes().activePrimary(shardRouting.shardId());
        } else {
            int primariesInRecovery = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node.nodeId());
 * not use this file except in compliance with the License.
import org.apache.logging.log4j.Logger;
                return allocateNonInitialShardCopies(shardRouting, node, allocation);
            } else {
        this.replicasInitialRecoveries = replicasInitialRecoveries;
                        CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),
        if (currentInRecoveries >= inRecoveriesLimit) {
import static org.opensearch.cluster.routing.allocation.decider.Decision.YES;
 * GitHub history for details.
                THROTTLE,
 * recovery operations per node.</li>
    }
        Property.Dynamic,
 * default is {@code 2}. Please note that this limit excludes the initial primaries
/*
                        inRecoveriesLimit
            } else {
                    YES,
        concurrentOutgoingRecoveries = CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.get(settings);
        } else if (shardRouting.initializing()) {
import org.opensearch.common.settings.ClusterSettings;
            } else {
                    THROTTLE,
 *
        ShardRouting primaryShard = allocation.routingNodes().activePrimary(shardRouting.shardId());
            }
                    THROTTLE,
        int currentInRecoveries,
        assert !shardRouting.unassignedReasonIndexCreated();
    private void setConcurrentOutgoingRecoverries(int concurrentOutgoingRecoveries) {
        if (shardRouting.unassigned()) {
                        NAME,
            if (unassignedInfo == null) {
                concurrentOutgoingRecoveries,
            true,
                "below shard recovery limit of incoming: [%d < %d]",
            if (primariesInRecovery >= primariesInitialRecoveries) {
    );
        } else {
                    return allocation.decision(
        Property.NodeScope
        "cluster.routing.allocation.node_initial_primaries_recoveries",
        int currentInRecoveries = allocation.routingNodes().getIncomingRecoveries(node.nodeId());
                        primaryNodeOutRecoveries,
                YES,
        }
        CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING,
    }
    }
        );
                    CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(),
        0,
            }
        Property.Dynamic,
                }
/*
                    CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey()
                        THROTTLE,
 * processes.
     * - the relocating shard routing if we want to relocate to this node now instead.
                || shardRouting.isSearchOnly();
import org.opensearch.cluster.routing.RecoverySource;
            currentInRecoveries,
    private static boolean isRemoteSegmentStoreNode(ShardRouting shardRouting, RoutingAllocation allocation) {
        "cluster.routing.allocation.node_concurrent_incoming_recoveries",
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to
                // check if the moving away search replica is using remote store, if not
                        NAME,
    private volatile int replicasInitialRecoveries;
        clusterSettings.addSettingsUpdateConsumer(
        }
    private volatile int concurrentIncomingRecoveries;
        );
        "cluster.routing.allocation.node_concurrent_outgoing_recoveries",
                NAME,
        // Allocating a shard to this node will increase the incoming recoveries
import org.opensearch.cluster.routing.ShardRouting;
                    "below shard recovery limit of outgoing: [%d < %d] incoming: [%d < %d]",
                incomingRecoveries,
 *
     * <p>
                .getTargetRelocatingShard();
        logger.debug(
                NAME,
    public static final int DEFAULT_CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES = 2;
 * <p>
            // Peer recovery
                concurrentOutgoingRecoveries
 */
        boolean isInitialShardCopies,
        clusterSettings.addSettingsUpdateConsumer(
                        outRecoveriesLimit,
            if (primaryShard == null) {
                            + "cluster setting [%s=%d]",
                .relocate(currentNodeId, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE)
                CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(),
                YES,
            ShardRouting primaryShard = allocation.routingNodes().activePrimary(shardRouting.shardId());
        );
            initializingShard = shardRouting.initialize(currentNodeId, null, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
            CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING,
 */
            );
        (s) -> Setting.parseInt(s, 0, "cluster.routing.allocation.node_concurrent_recoveries"),
        clusterSettings.addSettingsUpdateConsumer(
    private void setConcurrentIncomingRecoverries(int concurrentIncomingRecoveries) {
            if (primaryNodeOutRecoveries >= outRecoveriesLimit) {
                THROTTLE,
                        THROTTLE,
        return initializingShard;
            node
        int outgoingRecoveries = 0;
 * under the License.
import java.util.function.BiFunction;
            replicasInitialRecoveries
                .initialize(currentNodeId, null, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
                    currentInRecoveries,
            "using node_concurrent_outgoing_recoveries [{}], node_concurrent_incoming_recoveries [{}], "
    private Integer getPrimaryNodeOutgoingRecoveries(ShardRouting shardRouting, RoutingAllocation allocation) {
    private Integer getInitialPrimaryNodeOutgoingRecoveries(ShardRouting shardRouting, RoutingAllocation allocation) {
 * this work for additional information regarding copyright
    /**
        return allocation.nodes().getNodes().get(shardRouting.currentNodeId()).isRemoteSegmentStoreNode();
        if (!shardRouting.primary()) {
            if (shardRouting.isSearchOnly() && candidateNode.node().isRemoteSegmentStoreNode()) {
                    "reached the limit of incoming shard recoveries [%d], cluster setting [%s=%d] (can also be set via [%s])",
        int incomingRecoveries = allocation.routingNodes().getIncomingRecoveries(node.nodeId());
 * <li>{@code cluster.routing.allocation.node_concurrent_recoveries} -
                return allocation.decision(
                // unassigned shards must have unassignedInfo (initializing shards might not)
                    currentInRecoveries,
            return allocation.decision(
                    return allocation.decision(
