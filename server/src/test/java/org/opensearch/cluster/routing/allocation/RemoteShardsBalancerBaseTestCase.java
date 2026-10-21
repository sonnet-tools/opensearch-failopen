        return new RoutingAllocation(
        deciders.add(new AllocationDecider() {
                                .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        );
            @Override
        int iterations = 0;
    protected ClusterState createRemoteIndex(ClusterState state, String indexName) {
            createShardAllocator(settings),
            final Map<String, Long> shardSizes
    }
        for (int i = 0; i < localIndices; i++) {
        Settings settings = Settings.Builder.EMPTY_SETTINGS;
    }
                        .numberOfReplicas(REPLICAS)
import java.util.Map;
            clusterState,
            EmptyClusterInfoService.INSTANCE,
        RoutingTable routingTable = rb.build();
    }
    public int totalPrimaries(int indices) {
public abstract class RemoteShardsBalancerBaseTestCase extends OpenSearchAllocationTestCase {
        public String getDataPath(ShardRouting shardRouting) {
        });
        List<AllocationDecider> deciders = new ArrayList<>(
                String name = getNodeId(i, true);
        } while (!clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() && iterations < MAX_REROUTE_ITERATIONS);
        DiscoveryNodeRole.DATA_ROLE,
                );
                    .numberOfReplicas(REPLICAS)
            final Map<String, DiskUsage> leastAvailableSpaceUsage,
import org.opensearch.Version;
    );
        return new AllocationDeciders(deciders);
        return ClusterState.builder(state).metadata(metadata).routingTable(routingTable).build();
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
        if (isRemote) {
                    .settings(
            randomAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, random()),
            ClusterModule.createAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, Collections.emptyList())
 * this file be licensed under the Apache-2.0 license or a
        return getNodeId(id, isRemote, "");
        int localOnlyNodes,
            randomAllocationDeciders(Settings.Builder.EMPTY_SETTINGS, EMPTY_CLUSTER_SETTINGS, random()),
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            nb.add(newNode(name, name, MANAGER_DATA_ROLES));
            createRejectRemoteAllocationDeciders(throttle),
        return new OpenSearchAllocationTestCase.MockAllocationService(
 * The OpenSearch Contributors require contributions made to
                IndexMetadata.builder(indexName)
        for (int i = 0; i < remoteIndices; i++) {
            public Decision canAllocateAnyShardToNode(RoutingNode node, RoutingAllocation allocation) {
    }
        for (int i = 0; i < remoteIndices; i++) {
    public String getIndexName(int id, boolean isRemote, String prefix) {
    public RoutingAllocation getRoutingAllocation(ClusterState clusterState, RoutingNodes routingNodes) {
            String name = getNodeId(i, false);
        }
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            randomAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, random()),
                return throttle ? Decision.THROTTLE : Decision.YES;
        }
        Settings settings = Settings.Builder.EMPTY_SETTINGS;
                                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
            new TestGatewayAllocator(),
            .put(
            EmptyClusterInfoService.INSTANCE,
    }
                    return throttle ? Decision.THROTTLE : Decision.NO;
        Metadata metadata = Metadata.builder(state.metadata())
                        settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "5m")
import org.opensearch.cluster.routing.RoutingNode;
    }
    }
        return createInitialCluster(localOnlyNodes, remoteNodes, false, localIndices, remoteIndices, false);
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.routing.RoutingTable;
        return ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).routingTable(routingTable).nodes(nodes).build();
                    IndexMetadata.builder(getIndexName(i, true))
import java.util.List;
        Settings settings = Settings.Builder.EMPTY_SETTINGS;
    public AllocationService createRemoteCapableAllocationService() {
        }
import java.util.Collections;
}
    }
    }
import org.opensearch.cluster.OpenSearchAllocationTestCase;
    protected static final Set<DiscoveryNodeRole> WARM_ONLY_ROLE = Set.of(DiscoveryNodeRole.WARM_ROLE);
        }
import org.opensearch.index.IndexModule;
        do {
import org.opensearch.cluster.ClusterName;
        DiscoveryNodeRole.WARM_ROLE
    /**
    }
    public ClusterState createInitialCluster(
            .build();
    ) {
    public String getNodeId(int id, boolean isRemote) {
        }
            for (int i = 0; i < remoteNodes; i++) {
    protected static final int PRIMARIES = 5;
        Settings settings = Settings.builder().put("cluster.routing.allocation.exclude._id", excludeNodes).build();
            SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES
            rb.addAsNew(metadata.index(getIndexName(i, false)));
            SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES
     * ClusterInfo that always reports /dev/null for the shards' data paths.
        );
        );
/*
        public DevNullClusterInfo(
                    IndexMetadata.builder(getIndexName(i, true))
            if (remoteIndexIsWarm == false) {
            )
import org.opensearch.cluster.node.DiscoveryNodes;
            clusterState = service.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
    public String getNodeId(int id, boolean isRemote, String prefix) {
        return randomAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, random());
 */
    public ClusterState createInitialCluster(int localOnlyNodes, int remoteNodes, int localIndices, int remoteIndices) {
                );
            createShardAllocator(settings),
            return REMOTE_IDX_PREFIX + "-" + prefix + "-" + id;
        if (isRemote) {
        int localIndices,
                IndexMetadata.builder(getIndexName(i, false))
            );
            System.nanoTime()
            rb.addAsNew(metadata.index(getIndexName(i, true)));
import org.opensearch.cluster.metadata.Metadata;
    protected static final Set<DiscoveryNodeRole> MANAGER_DATA_ROLES = Set.of(
    protected static final String LOCAL_IDX_PREFIX = "local-idx";
package org.opensearch.cluster.routing.allocation;
        Metadata.Builder mb = Metadata.builder();
import org.opensearch.common.settings.Settings;
    protected static final String REMOTE_IDX_PREFIX = "remote-idx";
                if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shardRouting, allocation))) {
import org.opensearch.cluster.routing.UnassignedInfo;
        }
                    .numberOfShards(PRIMARIES)
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import java.util.ArrayList;
            new TestGatewayAllocator(),
import org.opensearch.cluster.node.DiscoveryNodeRole;
        return getIndexName(id, isRemote, "");
    }
import org.opensearch.cluster.ClusterInfo;
import org.opensearch.node.NodeResourceUsageStats;
     */
        return new MockAllocationService(
        DiscoveryNodes nodes = nb.build();
                nb.add(newNode(name, name, WARM_ONLY_ROLE));
                        .numberOfReplicas(REPLICAS)
    }
    }
        DiscoveryNodeRole.CLUSTER_MANAGER_ROLE,
    }
    public ClusterState allocateShardsAndBalance(ClusterState clusterState, AllocationService service) {
import org.opensearch.cluster.metadata.IndexMetadata;
    );
        int remoteNodes,
                        .settings(
                        .settings(
        return LOCAL_NODE_PREFIX + "-" + prefix + "-" + id;
    public AllocationDeciders createAllocationDeciders() {
        }
    protected static final String REMOTE_NODE_PREFIX = "remote-capable-node";
        if (remoteRoleOnly) {
        Collections.shuffle(deciders, random());
            }
 * compatible open source license.
                            settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0")
            final Map<String, NodeResourceUsageStats> nodeResourceUsages,
import org.opensearch.test.gateway.TestGatewayAllocator;
import org.opensearch.cluster.routing.ShardRouting;
            } else {
                    .numberOfShards(PRIMARIES)
                            settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0")
    public static class DevNullClusterInfo extends ClusterInfo {
                mb.put(
        );
                            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
            }
    protected static final String LOCAL_NODE_PREFIX = "local-only-node";
            createShardAllocator(settings),
                    )
    public int totalShards(int indices) {
        }
                mb.put(
            return "/dev/null";
                        .numberOfShards(PRIMARIES)
        Metadata metadata = mb.build();
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
@SuppressForbidden(reason = "feature flag overrides")
                        .numberOfShards(PRIMARIES)
                    return Decision.ALWAYS;
                nb.add(newNode(name, name, WARM_DATA_ROLES));
            super(leastAvailableSpaceUsage, mostAvailableSpaceUsage, shardSizes, null, Map.of(), Map.of(), nodeResourceUsages);
            final Map<String, DiskUsage> mostAvailableSpaceUsage,
    }
        } else {
        int remoteIndices,
import org.opensearch.cluster.routing.RoutingPool;
import org.opensearch.common.SuppressForbidden;
        return new OpenSearchAllocationTestCase.MockAllocationService(
                }
        for (int i = 0; i < localIndices; i++) {
    public AllocationService createRejectRemoteAllocationService(boolean throttle) {
import org.opensearch.cluster.routing.RoutingNodes;
import org.opensearch.cluster.DiskUsage;
            }
            return REMOTE_NODE_PREFIX + "-" + prefix + "-" + id;
            }
    protected static final Set<DiscoveryNodeRole> WARM_DATA_ROLES = Set.of(
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
import org.opensearch.cluster.ClusterModule;
        }
import org.opensearch.common.settings.ClusterSettings;
            for (int i = 0; i < remoteNodes; i++) {
            clusterState = service.reroute(clusterState, "reroute");
        DiscoveryNodeRole.DATA_ROLE
import org.opensearch.cluster.routing.allocation.decider.Decision;
            EmptyClusterInfoService.INSTANCE.getClusterInfo(),
    protected ClusterSettings EMPTY_CLUSTER_SETTINGS = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        return indices * PRIMARIES;
        }
        return LOCAL_IDX_PREFIX + "-" + prefix + "-" + id;
    private static final int MAX_REROUTE_ITERATIONS = 1000;
            @Override
import org.opensearch.cluster.EmptyClusterInfoService;
    public ShardsAllocator createShardAllocator(Settings settings) {
        RoutingTable routingTable = RoutingTable.builder(state.routingTable()).addAsNew(metadata.index(indexName)).build();
            routingNodes,
        boolean remoteIndexIsWarm
        Settings settings = Settings.Builder.EMPTY_SETTINGS;
    protected static final int REPLICAS = 1;
                } else {
        DiscoveryNodeRole.CLUSTER_MANAGER_ROLE,
        @Override
    public AllocationDeciders createRejectRemoteAllocationDeciders(boolean throttle) {
            iterations++;
        return indices * PRIMARIES * (REPLICAS + 1);
                        )
            null,
        ) {
    }
        boolean remoteRoleOnly,
            EmptyClusterInfoService.INSTANCE,
                        )
                    .numberOfReplicas(REPLICAS)
    public AllocationService createRemoteCapableAllocationService(String excludeNodes) {
                String name = getNodeId(i, true);
import java.util.Set;
 * SPDX-License-Identifier: Apache-2.0
            new TestGatewayAllocator(),
        );
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0"))
    public String getIndexName(int id, boolean isRemote) {
            }
    }
            mb.put(
        return new BalancedShardsAllocator(settings, clusterSettings);
        return clusterState;
        DiscoveryNodes.Builder nb = DiscoveryNodes.builder();
    }
        RoutingTable.Builder rb = RoutingTable.builder();
 *
            SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES
        for (int i = 0; i < localOnlyNodes; i++) {
