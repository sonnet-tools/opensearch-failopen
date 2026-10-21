 * SPDX-License-Identifier: Apache-2.0
    );
        Property.Dynamic,
 * cluster.routing.allocation.load_awareness.flat_skew: N
            return allocation.decision(
 *
 * cluster.routing.allocation.load_awareness.skew_factor: X
    public static final Setting<Double> CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING = Setting.doubleSetting(
        this.provisionedCapacity = provisionedCapacity;
import org.opensearch.common.settings.ClusterSettings;
 */
    }
    @Override
        Property.NodeScope
                    skewFactor,
        -1,
                provisionedCapacity
        Property.NodeScope
        this.flatSkew = flatSkew;
            );
 * compatible open source license.
        clusterSettings.addSettingsUpdateConsumer(
        ShardRouting shardRouting,
            this::setProvisionedCapacity
public class NodeLoadAwareAllocationDecider extends AllocationDecider {
 * cluster scale up and scale down operations.
        Metadata metadata = allocation.metadata();
        Property.Dynamic,
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 * @opensearch.internal
 * <p>
        Property.NodeScope
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_FLAT_SKEW_SETTING, this::setFlatSkew);
 * breaching the skew factor.
        Property.Dynamic,
 * based on overload factor defined as a percentage and flat skew as absolute allowed skewness by
import org.opensearch.cluster.routing.RoutingNode;
        return underCapacity(shardRouting, node, allocation, (count, limit) -> count >= limit);
        this.flatSkew = CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_FLAT_SKEW_SETTING.get(settings);
                    limit
 * Setting the value to true allows newly created primaries to get assigned while preventing the replica allocation
                CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey()
        -1,
            );
    private void setFlatSkew(int flatSkew) {
    }
    private static final Logger logger = LogManager.getLogger(NodeLoadAwareAllocationDecider.class);
                    node.nodeId(),
}
                "too many shards [%d] allocated to this node, limit per node [%d] considering"
/*
                NAME,
        int nodeShardCount = node.numberOfOwningShards();
                () -> new ParameterizedMessage(
package org.opensearch.cluster.routing.allocation.decider;
    );
 */
 * </p>
    );
            return allocation.decision(
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_FLAT_SKEW_SETTING = Setting.intSetting(
        );
        if (provisionedCapacity <= 0 || skewFactor < 0) {
    private volatile double skewFactor;
    public NodeLoadAwareAllocationDecider(Settings settings, ClusterSettings clusterSettings) {
            this::setAllowUnassignedPrimaries
import org.opensearch.common.settings.Settings;
        return underCapacity(shardRouting, node, allocation, (count, limit) -> count > limit);
import org.apache.logging.log4j.Logger;
                NAME,
        2,
        "cluster.routing.allocation.load_awareness.flat_skew",
                )
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING, this::setSkewFactor);
        BiPredicate<Integer, Integer> decider
        -1,
 * {@link AllocationDeciders#canForceAllocatePrimary(ShardRouting, RoutingNode, RoutingAllocation)}
        Setting.Property.Dynamic,
 * <pre>
        Property.NodeScope
 * <pre>
    private volatile int provisionedCapacity;
 * The total limit per node based on skew_factor and flat_skew doesn't limit primaries that previously
import org.opensearch.common.settings.Setting;
                nodeShardCount,
                "overload allocation awareness is allowed for unassigned primaries, set cluster setting [%s] to disable it",
        if (decider.test(nodeShardCount, limit)) {
    private void setAllowUnassignedPrimaries(boolean allowUnassignedPrimaries) {
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING = Setting.intSetting(
 * cluster.routing.allocation.load_awareness.allow_unassigned_primaries
    ) {
            );
import org.apache.logging.log4j.LogManager;
 * This {@link NodeLoadAwareAllocationDecider} controls shard over-allocation
        true,
 * <pre>
                Decision.YES,
        }
                Decision.NO,
    private void setSkewFactor(double skewFactor) {
                    "Too many shards [{}] allocated to this node [{}]. Expected average shards"
    private void setProvisionedCapacity(int provisionedCapacity) {
 * The OpenSearch Contributors require contributions made to
    }
 * Note that setting this to false can result in the primaries not get assigned and the cluster turning RED
import org.opensearch.common.settings.Setting.Property;
    }
            logger.debug(
                skewFactor,
 * </pre>
        this.skewFactor = skewFactor;
        "cluster.routing.allocation.load_awareness.skew_factor",
        50,
        RoutingNode node,
    public static final Setting<Boolean> CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING = Setting.boolSetting(
        if (shardRouting.unassigned() && shardRouting.primary() && allowUnassignedPrimaries) {
/**
                    nodeShardCount,
    }
        this.skewFactor = CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.get(settings);
                "overload awareness allocation is not enabled, set cluster setting [%s] and cluster setting [%s] to enable it",
    @Override
 * The provisioned capacity as defined by the below settings needs to be updated on every
                CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey()
                flatSkew,
    }
        int limit = flatSkew + (int) Math.ceil(expectedAvgShardsPerNode * (1 + skewFactor / 100.0));
 * and prevent allocation on the surviving nodes of the under capacity cluster
            CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING,
        this.allowUnassignedPrimaries = CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.get(settings);
import org.apache.logging.log4j.message.ParameterizedMessage;
        );
            );
                    + " overload factor [%.2f] and flat skew [%d] based on capacity [%d]",
                Decision.YES,
import org.opensearch.cluster.metadata.Metadata;
    }
        return allocation.decision(Decision.YES, NAME, "node meets all skew awareness attribute requirements");
            CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING,
        this.provisionedCapacity = CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.get(settings);
import java.util.function.BiPredicate;
                        + " per node [{}], overload factor [{}], node limit [{}]",
 * existed on the disk as those shards are force allocated by
        2,
        clusterSettings.addSettingsUpdateConsumer(
    }
 * </pre>
    private volatile int flatSkew;
 * however new primaries due to index creation, snapshot restore etc can be controlled via the below settings.
        "cluster.routing.allocation.load_awareness.provisioned_capacity",
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                limit,
 * are decided by the user provisioned capacity, to determine if there were lost nodes.
 * </pre>
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        RoutingAllocation allocation,
 * this file be licensed under the Apache-2.0 license or a
 *
    public static final String NAME = "load_awareness";
            return allocation.decision(
                NAME,
 * cluster.routing.allocation.overload_awareness.provisioned_capacity: N
    );
    private volatile boolean allowUnassignedPrimaries;
        this.allowUnassignedPrimaries = allowUnassignedPrimaries;
                CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        }
        float expectedAvgShardsPerNode = (float) metadata.getTotalNumberOfShards() / provisionedCapacity;
    private Decision underCapacity(
        "cluster.routing.allocation.load_awareness.allow_unassigned_primaries",
        }
import org.opensearch.cluster.routing.ShardRouting;
                    expectedAvgShardsPerNode,
 * due to node failures or otherwise on the surviving nodes. The allocation limits
