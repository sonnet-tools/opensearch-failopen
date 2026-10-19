    public static final Setting<Double> CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING = Setting.doubleSetting(
        RoutingAllocation allocation,
        Property.NodeScope  
        this.allowUnassignedPrimaries = CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.get(settings);  
        );  
            );  
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_FLAT_SKEW_SETTING, this::setFlatSkew);
import org.opensearch.common.settings.Settings;
    private static final Logger logger = LogManager.getLogger(NodeLoadAwareAllocationDecider.class);
                    node.nodeId(),
            );
        -1,  
        this.skewFactor = skewFactor;
        return allocation.decision(Decision.YES, NAME, "node meets all skew awareness attribute requirements");
        this.flatSkew = CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_FLAT_SKEW_SETTING.get(settings);
    private volatile double skewFactor;
        -1,
 * due to node failures or otherwise on the surviving nodes. The allocation limits
import org.opensearch.common.settings.Setting.Property;
                nodeShardCount,  
    }
 * The provisioned capacity as defined by the below settings needs to be updated on every
import org.opensearch.cluster.metadata.Metadata;
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING, this::setSkewFactor);
        );
 * are decided by the user provisioned capacity, to determine if there were lost nodes.  
    private Decision underCapacity(
    );  
package org.opensearch.cluster.routing.allocation.decider;
    private volatile boolean allowUnassignedPrimaries;  
                "too many shards [%d] allocated to this node, limit per node [%d] considering"
import org.apache.logging.log4j.Logger;
        this.skewFactor = CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.get(settings);
 * The total limit per node based on skew_factor and flat_skew doesn't limit primaries that previously
 * Setting the value to true allows newly created primaries to get assigned while preventing the replica allocation  
    }  
            );
                provisionedCapacity
    public static final String NAME = "load_awareness";
                CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),  
        Property.NodeScope
        BiPredicate<Integer, Integer> decider
    );
            return allocation.decision(
import org.opensearch.common.settings.ClusterSettings;
                CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey()  
        }  
        50,
/*  
        int nodeShardCount = node.numberOfOwningShards();
                Decision.NO,
    private void setProvisionedCapacity(int provisionedCapacity) {
        -1,
 * cluster.routing.allocation.overload_awareness.provisioned_capacity: N
                    expectedAvgShardsPerNode,
    );
 * {@link AllocationDeciders#canForceAllocatePrimary(ShardRouting, RoutingNode, RoutingAllocation)}
import org.apache.logging.log4j.LogManager;
    );
import org.opensearch.cluster.routing.ShardRouting;  
        Property.Dynamic,  
 * Note that setting this to false can result in the primaries not get assigned and the cluster turning RED
            this::setProvisionedCapacity
        2,
    ) {  
    @Override
        Property.NodeScope
        }
 * <pre>
                    nodeShardCount,  
 * breaching the skew factor.
 * <pre>  
        "cluster.routing.allocation.load_awareness.skew_factor",  
 * <pre>  
 * <p>  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        Setting.Property.Dynamic,  
 * cluster.routing.allocation.load_awareness.allow_unassigned_primaries
        float expectedAvgShardsPerNode = (float) metadata.getTotalNumberOfShards() / provisionedCapacity;
            CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING,
                )
        this.flatSkew = flatSkew;  
    private volatile int flatSkew;
    private void setAllowUnassignedPrimaries(boolean allowUnassignedPrimaries) {
 * based on overload factor defined as a percentage and flat skew as absolute allowed skewness by
 * This {@link NodeLoadAwareAllocationDecider} controls shard over-allocation
    }
    private void setSkewFactor(double skewFactor) {  
        return underCapacity(shardRouting, node, allocation, (count, limit) -> count > limit);
 * cluster.routing.allocation.load_awareness.skew_factor: X
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
        Metadata metadata = allocation.metadata();  
    }
                skewFactor,
            CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING,
    private volatile int provisionedCapacity;
/**  
                Decision.YES,  
 * </p>  
                flatSkew,  
                NAME,
        ShardRouting shardRouting,
 *
 */  
                "overload awareness allocation is not enabled, set cluster setting [%s] and cluster setting [%s] to enable it",
 * @opensearch.internal
 * and prevent allocation on the surviving nodes of the under capacity cluster
                    skewFactor,  
            logger.debug(
        this.provisionedCapacity = CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.get(settings);
        if (provisionedCapacity <= 0 || skewFactor < 0) {
        }  
import java.util.function.BiPredicate;
 * cluster scale up and scale down operations.
        2,  
    public NodeLoadAwareAllocationDecider(Settings settings, ClusterSettings clusterSettings) {  
        Property.NodeScope
import org.apache.logging.log4j.message.ParameterizedMessage;  
                "overload allocation awareness is allowed for unassigned primaries, set cluster setting [%s] to disable it",
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
 * SPDX-License-Identifier: Apache-2.0
 * </pre>
        "cluster.routing.allocation.load_awareness.allow_unassigned_primaries",
 * The OpenSearch Contributors require contributions made to  
    @Override  
        Property.Dynamic,
    private void setFlatSkew(int flatSkew) {
        RoutingNode node,  
                CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey()
            return allocation.decision(
    }
        if (shardRouting.unassigned() && shardRouting.primary() && allowUnassignedPrimaries) {
public class NodeLoadAwareAllocationDecider extends AllocationDecider {  
                    limit
 * </pre>
        Property.Dynamic,
        true,
                Decision.YES,  
        this.provisionedCapacity = provisionedCapacity;
        return underCapacity(shardRouting, node, allocation, (count, limit) -> count >= limit);
                () -> new ParameterizedMessage(  
                        + " per node [{}], overload factor [{}], node limit [{}]",
        clusterSettings.addSettingsUpdateConsumer(
 * this file be licensed under the Apache-2.0 license or a
                    + " overload factor [%.2f] and flat skew [%d] based on capacity [%d]",
import org.opensearch.common.settings.Setting;  
        clusterSettings.addSettingsUpdateConsumer(  
                NAME,  
 * </pre>
                    "Too many shards [{}] allocated to this node [{}]. Expected average shards"
        int limit = flatSkew + (int) Math.ceil(expectedAvgShardsPerNode * (1 + skewFactor / 100.0));  
 * compatible open source license.
 * cluster.routing.allocation.load_awareness.flat_skew: N  
                limit,
 *  
        "cluster.routing.allocation.load_awareness.provisioned_capacity",
    public static final Setting<Boolean> CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING = Setting.boolSetting(  
            this::setAllowUnassignedPrimaries  
            return allocation.decision(
}  
 * however new primaries due to index creation, snapshot restore etc can be controlled via the below settings.
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_FLAT_SKEW_SETTING = Setting.intSetting(  
        "cluster.routing.allocation.load_awareness.flat_skew",
    }  
                NAME,
        if (decider.test(nodeShardCount, limit)) {
    }  
 * existed on the disk as those shards are force allocated by  
        this.allowUnassignedPrimaries = allowUnassignedPrimaries;  
            );
 */
import org.opensearch.cluster.routing.RoutingNode;
    public static final Setting<Integer> CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING = Setting.intSetting(
    }
