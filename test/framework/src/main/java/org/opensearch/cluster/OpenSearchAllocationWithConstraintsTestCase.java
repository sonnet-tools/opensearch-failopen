        indexShardCount = new HashMap<>();
                hasHotSpot = true;
        RoutingTable rb = buildRoutingTable(RoutingTable.builder(clusterState.getRoutingTable()), md, NEW_INDEX_PREFIX, indices);
    private ClusterState initialClusterState;
                    if (peerNode.nodeId().equals(node)) {
                    return true;
    public void terminateNodes(String... nodesToTerminate) {
                for (RoutingNode peerNode : clusterState.getRoutingNodes()) {
    protected ClusterState clusterState;
        }
                }
    public static String shardIdentifierFromRouting(ShardRouting shardRouting) {
            movesToBalance++;
                    .numberOfReplicas(numberOfReplicas)
        buildAllocationService(sb);
            clusterState = allocation.reroute(clusterState, "reroute");
                  A simple check could be to ensure there is no node with shards less than
import org.opensearch.cluster.metadata.Metadata;
        RoutingTable rb = buildRoutingTable(RoutingTable.builder(clusterState.getRoutingTable()), md, index_prefix, indices);
                  ineligible to accept the shard due to SameShardAllocationDecider, as this
                if (shard.state() == INITIALIZING || shard.state() == STARTED) {
    }
    public void setupInitialCluster(int nodeCount, int indices, int shards, int replicas) {
    public void updateInitialCluster() {
            nodeShardsByIndex.put(node, new HashMap<>());
                if (limitBreachedOnAllNodes) {
                  leads to a chain of events that breach IndexShardsPerNode constraint on all
            iterations++;
        DiscoveryNodes.Builder nb = DiscoveryNodes.builder();
        return movesToBalance;
                    }
                  allocation limit, that can accept current shard. However, in current
    private static final int MAX_REROUTE_STEPS_ALLOWED = 1500;
            initShards = clusterState.getRoutingNodes().shardsWithState(INITIALIZING);
        initialClusterState = ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).routingTable(routingTable).nodes(nodes).build();
/*
                  nodes are eligible to accept the shard. A hot spot is acceptable, if either
        buildAllocationService(sb);
    }
        nodeShardsByIndex = null;
                assert shard.currentNodeId().equals(node);
                  ModelNodes without adding them to actual cluster (RoutingNodes). As a result,
                    .numberOfShards(numberOfShards)
        buildNodeShardsByIndex();
        final String DEFAULT_NODE_PREFIX = "node_";
            mb.put(
            return Arrays.asList(clusterState.getNodes().resolveNodes());
        List<ShardRouting> initShards;
        }
        DiscoveryNodes nodes = addNodes(DiscoveryNodes.builder(clusterState.nodes()), node_prefix, nodeCount);
        DiscoveryNodes nodes = addNodes(DiscoveryNodes.builder(), DEFAULT_NODE_PREFIX, nodeCount);
                  the shards per node we see here, are different from the ones observed by
                    int peerCount = nodeShardsByIndex.get(peerNode.nodeId()).getOrDefault(index, 0);
        final String NEW_INDEX_PREFIX = "new_index_";
        initialClusterState = ClusterState.builder(ClusterName.DEFAULT).nodes(nb.build()).build();
        RoutingTable routingTable = buildRoutingTable(RoutingTable.builder(), metadata, DEFAULT_INDEX_PREFIX, indices);
        }
            for (String index : nodeShardsByIndex.get(node).keySet()) {
    }
    }
        DiscoveryNodes.Builder nb = DiscoveryNodes.builder(clusterState.nodes());
        logger.info("Creating zone aware cluster");
        initialClusterState = null;
    }
    public boolean isIndexHotSpotPresent(int nodes, List<String> nodeList) {
        allocation = createAllocationService(sb.build());
        for (String node : nodeList) {
                        continue;
                }
    }
                    }
        return false;
                    nodeShardsByIndex.get(node).merge(shard.getIndexName(), 1, Integer::sum);
                nodeId++;
                    ShardRouting sameIdShardOnPeer = peerNode.getByShardId(shard.shardId());
        assertForIndexShardHotSpots(false, nodeCount); // Initial cluster should be balanced
    public List<String> getNodeList(String... nodesToValidate) {
    public int allocateAndCheckIndexShardHotSpots(boolean expected, int nodes, String... nodesToValidate) {
        int movesToBalance = 0;
                  A node with fewer shards may not be able to accept current shard due to
                int limit = (int) Math.ceil(indexShardCount.get(index) / (float) nodes);
    }
        return clusterState;
        int iterations = 0;
    }
    public void buildAllocationService() {
        for (int i = 0; i < indices; i++) {
            }
                }
    }
                }
        logger.info("Initial cluster created...");
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
    public void clearState() {
        buildNodeShardsByIndex();
        for (RoutingNode rn : clusterState.getRoutingNodes()) {
        clusterState = ClusterState.builder(clusterState).metadata(md).routingTable(rb).build();
        indexShardCount = null;
                }
        }
                int limit = (int) Math.ceil(indexShardCount.get(index) / (float) nodes);
        if (indexShardCount == null) {
    }
    }
        return nb.build();
        Metadata md = buildMetadata(Metadata.builder(clusterState.getMetadata()), index_prefix, indices, shards, replicas);
        clusterState = initialClusterState;
                    continue;
            nb.add(newNode(nodePrefix + i, singletonMap("_node_id", nodePrefix + i)));
        initialClusterState = clusterState;
 */
    public void buildNodeShardsByIndex() {
        clusterState = allocateShardsAndBalance(clusterState);
        clusterState = ClusterState.builder(clusterState).nodes(nb.build()).build();
        List<String> nodeList = getNodeList(nodesToValidate);
            rb.addAsNew(metadata.index(indexPrefix + i));
            for (int i = 0; i < nodesPerZone.get(zone); i++) {
        for (int i = 0; i < numberOfIndices; i++) {
        Settings.Builder sb = Settings.builder();
        Settings.Builder sb = Settings.builder().put("cluster.routing.allocation.exclude._node_id", excludeNodes);
    private HashMap<String, Integer> indexShardCount;
        clusterState = ClusterState.builder(clusterState).nodes(nodes).build();
                  allocation algorithm, when nodes get throttled, shards are added to
                  another node. We need to differentiate between such hot spots v/s actual hot
                // If all peer nodes have count >= limit, hotspot is acceptable
    public Metadata buildMetadata(Metadata.Builder mb, String indexPrefix, int numberOfIndices, int numberOfShards, int numberOfReplicas) {
    public void addIndices(String index_prefix, int indices, int shards, int replicas) {
        logger.info("Excluding nodes: [{}]", excludeNodes);
        assertEquals(expected, hasHotSpot);
            String node = rn.nodeId();
import org.junit.Before;
                    continue;
    }
            indexShardCount = new HashMap<>();
package org.opensearch.cluster;
                for (RoutingNode peerNode : clusterState.getRoutingNodes()) {
                    continue;
                        peerHasSameShard = true;
    }
        DiscoveryNodes nodes = addNodes(DiscoveryNodes.builder(clusterState.nodes()), node_prefix, nodeCount);
        Metadata md = buildMetadata(Metadata.builder(clusterState.getMetadata()), NEW_INDEX_PREFIX, indices, shards, replicas);
    public void buildAllocationService(String excludeNodes) {
            assert movesToBalance <= MAX_REROUTE_STEPS_ALLOWED : "Could not balance cluster in max allowed moves";
                int count = nodeShardsByIndex.get(node).get(index);
    }
    public ClusterState allocateShardsAndBalance(ClusterState clusterState) {
        return rb.build();
    public DiscoveryNodes addNodes(DiscoveryNodes.Builder nb, String nodePrefix, int nodesAdded) {
                  Given the way {@link limit} is defined, we should not have hot spots if *all*
    public void addNodesWithoutIndexing(int nodeCount, String node_prefix) {
        }
public abstract class OpenSearchAllocationWithConstraintsTestCase extends OpenSearchAllocationTestCase {
            clusterState = allocation.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
        clusterState = ClusterState.builder(clusterState).metadata(md).routingTable(rb).nodes(nodes).build();
                    if (sameIdShardOnPeer != null && sameIdShardOnPeer.getIndexName().equals(index)) {
    private HashMap<String, HashMap<String, Integer>> nodeShardsByIndex;
        allocation = null;
                    if (peerNode.nodeId().equals(node)) {
                boolean peerHasSameShard = false;
        sb.put("cluster.routing.allocation.cluster_concurrent_rebalance", 1);
            indexShardCount.put(DEFAULT_INDEX_PREFIX + i, shards * (replicas + 1));
    public void addNodesWithIndexing(int nodeCount, String node_prefix, int indices, int shards, int replicas) {
        do {
                  other nodes.
        buildAllocationService(sb);
    }
import org.opensearch.core.common.util.CollectionUtils;
            indexShardCount.put(index_prefix + i, shards * (replicas + 1));
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "node-terminated");
    public void assertForIndexShardHotSpots(boolean expected, int nodes, String... nodesToValidate) {
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        clusterState = null;
        for (int i = 0; i < indices; i++) {
}
                  spots.
                String index = shard.getIndexName();
                /*
                 */
import java.util.Arrays;
import org.opensearch.cluster.routing.RoutingNode;
    }
import org.opensearch.cluster.routing.UnassignedInfo;
        final String DEFAULT_INDEX_PREFIX = "index_";
        boolean hasHotSpot = false;
        if (CollectionUtils.isEmpty(nodesToTerminate)) {
        }
import java.util.HashMap;
    }
            }
            }
import static java.util.Collections.singletonMap;
                if (count > limit) {
import java.util.List;
                    }
        int nodeId = 0;
                  may not have had the same count in the corresponding ModelNode seen by weight
                  all peer nodes have {@link count} > {@link limit}, or if even one node is
            for (ShardRouting shard : initShards) {
                if (!nodeList.contains(node)) {
            clusterState = allocation.reroute(clusterState, "reroute");
    public void createEmptyZoneAwareCluster(Map<String, Integer> nodesPerZone) {
        for (int i = 0; i < numberOfIndices; i++) {
 * Copyright OpenSearch Contributors.
        }
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0"))
        }
        return Arrays.asList(nodesToValidate);
        clusterState = initialClusterState;
 * SPDX-License-Identifier: Apache-2.0
        }
    }
                  weight function in balancer. RoutingNodes with {@link count} < {@link limit}
    public RoutingTable buildRoutingTable(RoutingTable.Builder rb, Metadata metadata, String indexPrefix, int numberOfIndices) {
                int count = nodeShardsByIndex.get(node).get(index);
        }
            );
    public void buildZoneAwareAllocationService() {
        for (int i = 0; i < nodesAdded; i++) {
                nodeShardsByIndex.get(node).merge(index, 1, Integer::sum);
                  SameShardAllocationDecider, causing it to breach allocation constraint on
    }
            }
        initialClusterState = allocateShardsAndBalance(initialClusterState);
    }
            return;
import org.opensearch.cluster.routing.RoutingTable;
                // If any node is ineligible to accept the shard, this hot spot is acceptable
    }
        nodeShardsByIndex = new HashMap<>();
        clusterState = initialClusterState;
    public void resetCluster() {
            indexShardCount.put(NEW_INDEX_PREFIX + i, shards * (replicas + 1));
            for (ShardRouting shard : rn) {
                String node = shard.currentNodeId();
                }
                if (count <= limit) {
                    if (peerCount < limit) {
        do {
import org.opensearch.cluster.metadata.IndexMetadata;
        } while (!initShards.isEmpty());
import java.util.Map;
        buildAllocationService();
                nb.add(newNode("node_" + nodeId, singletonMap("zone", zone)));
        } while (!clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() && iterations < MAX_REROUTE_STEPS_ALLOWED);
                        limitBreachedOnAllNodes = false;
        sb.put("cluster.routing.allocation.node_concurrent_recoveries", 1);
    }
        List<String> nodeList = getNodeList(nodesToValidate);
        for (int i = 0; i < indices; i++) {
        return mb.build();
        assertEquals(expected, isIndexHotSpotPresent(nodes, nodeList));
                }
        logger.info("HotSpot: [{}], Moves to balance: [{}]", hasHotSpot, movesToBalance);
        if (CollectionUtils.isEmpty(nodesToValidate)) {
    public void buildAllocationService(Settings.Builder sb) {
    protected MockAllocationService allocation;
                  function. We hence use the following alternate check --
    }
        }
        Settings.Builder sb = Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone");
                boolean limitBreachedOnAllNodes = true;
import org.opensearch.common.settings.Settings;
        return shardRouting.shardId().toString() + "[" + (shardRouting.primary() ? "p" : "r") + "]";
        Metadata metadata = buildMetadata(Metadata.builder(), DEFAULT_INDEX_PREFIX, indices, shards, replicas);
        for (String zone : nodesPerZone.keySet()) {
                }
        }
import org.opensearch.cluster.routing.ShardRouting;
                    }
                  Hot spots can occur due to the order in which shards get allocated to nodes.
                        continue;
        assertForIndexShardHotSpots(false, nodes); // Post re-balancing, cluster should always be hot spot free.
                if (peerHasSameShard) {
        Arrays.asList(nodesToTerminate).forEach(node -> nb.remove(node));
            clusterState = allocation.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
import org.opensearch.Version;
                    continue;
                IndexMetadata.builder(indexPrefix + i)
import org.opensearch.cluster.node.DiscoveryNodes;
    @Before
