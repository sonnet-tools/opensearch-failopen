            for (int i = 0; i < remoteNodes; i++) {
                }
        Settings settings = Settings.builder().put("cluster.routing.allocation.exclude._id", excludeNodes).build();
import org.opensearch.common.settings.Settings;
            createShardAllocator(settings),
        return randomAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, random());  
        }
    }
        return createInitialCluster(localOnlyNodes, remoteNodes, false, localIndices, remoteIndices, false);  
            .put(
                    .numberOfShards(PRIMARIES)
            SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES  
    protected static final String REMOTE_IDX_PREFIX = "remote-idx";
            .build();
    );  
                );
        for (int i = 0; i < remoteIndices; i++) {  
    /**  
import org.opensearch.cluster.metadata.Metadata;
        return clusterState;
    }
                return throttle ? Decision.THROTTLE : Decision.YES;  
 * compatible open source license.
    protected static final String REMOTE_NODE_PREFIX = "remote-capable-node";  
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import java.util.List;  
    protected static final Set<DiscoveryNodeRole> MANAGER_DATA_ROLES = Set.of(  
            null,  
import java.util.ArrayList;
    public int totalShards(int indices) {
import org.opensearch.cluster.metadata.IndexMetadata;  
                        .numberOfReplicas(REPLICAS)
    protected ClusterState createRemoteIndex(ClusterState state, String indexName) {  
        });
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.gateway.TestGatewayAllocator;
import org.opensearch.cluster.routing.allocation.decider.Decision;
        }
        if (remoteRoleOnly) {  
 * SPDX-License-Identifier: Apache-2.0
        public DevNullClusterInfo(
                    )
        Settings settings = Settings.Builder.EMPTY_SETTINGS;
        return new OpenSearchAllocationTestCase.MockAllocationService(  
import org.opensearch.cluster.node.DiscoveryNodeRole;
            nb.add(newNode(name, name, MANAGER_DATA_ROLES));
                IndexMetadata.builder(indexName)  
        Settings settings = Settings.Builder.EMPTY_SETTINGS;  
    protected static final int PRIMARIES = 5;
        Settings settings = Settings.Builder.EMPTY_SETTINGS;
                            settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0")
        return ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).routingTable(routingTable).nodes(nodes).build();  
        );
            ClusterModule.createAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, Collections.emptyList())
            createShardAllocator(settings),
                        .numberOfShards(PRIMARIES)  
        DiscoveryNodeRole.CLUSTER_MANAGER_ROLE,
        );  
        return LOCAL_IDX_PREFIX + "-" + prefix + "-" + id;
/*  
        DiscoveryNodeRole.DATA_ROLE
            SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES
    }
        return LOCAL_NODE_PREFIX + "-" + prefix + "-" + id;  
    public AllocationService createRemoteCapableAllocationService(String excludeNodes) {  
import org.opensearch.Version;
                        settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "5m")
import java.util.Collections;
        }
                mb.put(  
            routingNodes,  
    protected static final Set<DiscoveryNodeRole> WARM_DATA_ROLES = Set.of(
}  
        int iterations = 0;
            final Map<String, Long> shardSizes
        for (int i = 0; i < remoteIndices; i++) {
        DiscoveryNodes.Builder nb = DiscoveryNodes.builder();
    protected static final String LOCAL_IDX_PREFIX = "local-idx";
            for (int i = 0; i < remoteNodes; i++) {  
import org.opensearch.common.settings.ClusterSettings;
    }  
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        RoutingTable routingTable = rb.build();
            @Override
            return "/dev/null";  
            System.nanoTime()
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;  
        int remoteNodes,
            SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES
    }
        );
        }
    public static class DevNullClusterInfo extends ClusterInfo {  
        } while (!clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() && iterations < MAX_REROUTE_ITERATIONS);
        return getIndexName(id, isRemote, "");  
        List<AllocationDecider> deciders = new ArrayList<>(  
                    IndexMetadata.builder(getIndexName(i, true))  
        return new RoutingAllocation(
    }
import java.util.Map;
    public String getNodeId(int id, boolean isRemote, String prefix) {
    }
    public AllocationService createRemoteCapableAllocationService() {
            super(leastAvailableSpaceUsage, mostAvailableSpaceUsage, shardSizes, null, Map.of(), Map.of(), nodeResourceUsages);
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
    protected static final int REPLICAS = 1;  
    }
            clusterState = service.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
 * The OpenSearch Contributors require contributions made to  
        Settings settings = Settings.Builder.EMPTY_SETTINGS;
     * ClusterInfo that always reports /dev/null for the shards' data paths.
     */
    public String getIndexName(int id, boolean isRemote, String prefix) {
public abstract class RemoteShardsBalancerBaseTestCase extends OpenSearchAllocationTestCase {
    }
        );
            EmptyClusterInfoService.INSTANCE,
        return new MockAllocationService(
            EmptyClusterInfoService.INSTANCE,
            }
    public AllocationDeciders createRejectRemoteAllocationDeciders(boolean throttle) {
                    .numberOfShards(PRIMARIES)
                                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        if (isRemote) {  
            randomAllocationDeciders(Settings.Builder.EMPTY_SETTINGS, EMPTY_CLUSTER_SETTINGS, random()),
                        )
    }
                } else {
            );  
            }  
import org.opensearch.cluster.ClusterInfo;
                        .numberOfReplicas(REPLICAS)  
    public ClusterState allocateShardsAndBalance(ClusterState clusterState, AllocationService service) {
            final Map<String, NodeResourceUsageStats> nodeResourceUsages,
        for (int i = 0; i < localIndices; i++) {
    public AllocationDeciders createAllocationDeciders() {
        );
        return indices * PRIMARIES * (REPLICAS + 1);  
            randomAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, random()),  
import org.opensearch.cluster.routing.RoutingNode;
            rb.addAsNew(metadata.index(getIndexName(i, true)));  
import org.opensearch.cluster.ClusterModule;  
        deciders.add(new AllocationDecider() {  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
import org.opensearch.cluster.routing.ShardRouting;
    public String getIndexName(int id, boolean isRemote) {
                        .settings(
import org.opensearch.cluster.ClusterName;
            new TestGatewayAllocator(),
        boolean remoteRoleOnly,  
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0"))  
    );
import org.opensearch.cluster.ClusterState;
            @Override
                IndexMetadata.builder(getIndexName(i, false))
        } else {
            }
        return new AllocationDeciders(deciders);
                nb.add(newNode(name, name, WARM_ONLY_ROLE));  
            rb.addAsNew(metadata.index(getIndexName(i, false)));  
        return indices * PRIMARIES;
        int localOnlyNodes,
    protected static final String LOCAL_NODE_PREFIX = "local-only-node";
    public AllocationService createRejectRemoteAllocationService(boolean throttle) {
import java.util.Set;
                            settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0")  
import org.opensearch.node.NodeResourceUsageStats;
import org.opensearch.common.SuppressForbidden;  
    public ClusterState createInitialCluster(int localOnlyNodes, int remoteNodes, int localIndices, int remoteIndices) {
import org.opensearch.cluster.routing.UnassignedInfo;  
        }
        do {  
            new TestGatewayAllocator(),
        DiscoveryNodeRole.WARM_ROLE
                            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())  
                        .numberOfShards(PRIMARIES)
        if (isRemote) {
                        .settings(
                String name = getNodeId(i, true);
            }
    public String getNodeId(int id, boolean isRemote) {  
                        )
                    .numberOfReplicas(REPLICAS)  
        }
            return REMOTE_IDX_PREFIX + "-" + prefix + "-" + id;  
                    .numberOfReplicas(REPLICAS)
        @Override
                mb.put(
        DiscoveryNodeRole.CLUSTER_MANAGER_ROLE,
        return ClusterState.builder(state).metadata(metadata).routingTable(routingTable).build();
import org.opensearch.cluster.routing.RoutingTable;
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
    public ClusterState createInitialCluster(  
    private static final int MAX_REROUTE_ITERATIONS = 1000;
    public ShardsAllocator createShardAllocator(Settings settings) {
            new TestGatewayAllocator(),  
        Collections.shuffle(deciders, random());  
            iterations++;  
        DiscoveryNodes nodes = nb.build();
        return getNodeId(id, isRemote, "");
    protected ClusterSettings EMPTY_CLUSTER_SETTINGS = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        }
            public Decision canAllocateAnyShardToNode(RoutingNode node, RoutingAllocation allocation) {
                String name = getNodeId(i, true);
                if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shardRouting, allocation))) {  
            clusterState = service.reroute(clusterState, "reroute");
@SuppressForbidden(reason = "feature flag overrides")  
        public String getDataPath(ShardRouting shardRouting) {
        return new BalancedShardsAllocator(settings, clusterSettings);  
            createShardAllocator(settings),  
        ) {  
    }
        int remoteIndices,
                    return Decision.ALWAYS;  
import org.opensearch.cluster.routing.RoutingNodes;
    }  
            clusterState,
            EmptyClusterInfoService.INSTANCE,  
                nb.add(newNode(name, name, WARM_DATA_ROLES));
        }
    }  
    protected static final Set<DiscoveryNodeRole> WARM_ONLY_ROLE = Set.of(DiscoveryNodeRole.WARM_ROLE);  
import org.opensearch.cluster.EmptyClusterInfoService;
    }
import org.opensearch.cluster.OpenSearchAllocationTestCase;
    }
            final Map<String, DiskUsage> leastAvailableSpaceUsage,
        for (int i = 0; i < localOnlyNodes; i++) {
                    .settings(
        RoutingTable.Builder rb = RoutingTable.builder();
        int localIndices,
        DiscoveryNodeRole.DATA_ROLE,  
            } else {
            }  
    }
    }  
 *
                    IndexMetadata.builder(getIndexName(i, true))
            return REMOTE_NODE_PREFIX + "-" + prefix + "-" + id;
        }
import org.opensearch.index.IndexModule;  
                    return throttle ? Decision.THROTTLE : Decision.NO;
        Metadata metadata = mb.build();
        return new OpenSearchAllocationTestCase.MockAllocationService(
                );
import org.opensearch.cluster.DiskUsage;  
    }
        Metadata metadata = Metadata.builder(state.metadata())
            createRejectRemoteAllocationDeciders(throttle),
        for (int i = 0; i < localIndices; i++) {  
        RoutingTable routingTable = RoutingTable.builder(state.routingTable()).addAsNew(metadata.index(indexName)).build();  
            final Map<String, DiskUsage> mostAvailableSpaceUsage,  
 */  
            String name = getNodeId(i, false);  
            )
    public int totalPrimaries(int indices) {  
package org.opensearch.cluster.routing.allocation;
            EmptyClusterInfoService.INSTANCE.getClusterInfo(),
import org.opensearch.cluster.node.DiscoveryNodes;  
import org.opensearch.cluster.routing.RoutingPool;  
                                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())  
            if (remoteIndexIsWarm == false) {
    public RoutingAllocation getRoutingAllocation(ClusterState clusterState, RoutingNodes routingNodes) {  
            randomAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, random()),
    ) {
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
            mb.put(
        boolean remoteIndexIsWarm  
        Metadata.Builder mb = Metadata.builder();
        }
