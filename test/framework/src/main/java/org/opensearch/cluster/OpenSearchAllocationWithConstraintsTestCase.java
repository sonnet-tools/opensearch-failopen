                boolean limitBreachedOnAllNodes = true;
            assert movesToBalance <= MAX_REROUTE_STEPS_ALLOWED : "Could not balance cluster in max allowed moves";
    }
        for (RoutingNode rn : clusterState.getRoutingNodes()) {
            }
    }  
                int count = nodeShardsByIndex.get(node).get(index);
import static java.util.Collections.singletonMap;  
        clusterState = allocateShardsAndBalance(clusterState);
        for (String zone : nodesPerZone.keySet()) {
        initialClusterState = clusterState;
        }
    }  
                    if (peerCount < limit) {
    public RoutingTable buildRoutingTable(RoutingTable.Builder rb, Metadata metadata, String indexPrefix, int numberOfIndices) {  
            nodeShardsByIndex.put(node, new HashMap<>());
                }
    public boolean isIndexHotSpotPresent(int nodes, List<String> nodeList) {
                    }  
        initialClusterState = allocateShardsAndBalance(initialClusterState);  
            );
            return;
        }
    public void resetCluster() {
 * Copyright OpenSearch Contributors.
        clusterState = initialClusterState;  
                  allocation algorithm, when nodes get throttled, shards are added to
        buildAllocationService(sb);
        buildAllocationService();
    }
            indexShardCount.put(index_prefix + i, shards * (replicas + 1));
                  all peer nodes have {@link count} > {@link limit}, or if even one node is
        for (int i = 0; i < numberOfIndices; i++) {
                    ShardRouting sameIdShardOnPeer = peerNode.getByShardId(shard.shardId());
        initialClusterState = ClusterState.builder(ClusterName.DEFAULT).nodes(nb.build()).build();
        DiscoveryNodes.Builder nb = DiscoveryNodes.builder();
}  
    private HashMap<String, Integer> indexShardCount;  
                /*
    public void buildAllocationService(String excludeNodes) {
        do {
 */  
        assertEquals(expected, hasHotSpot);
                    continue;
        final String NEW_INDEX_PREFIX = "new_index_";  
        Settings.Builder sb = Settings.builder().put("cluster.routing.allocation.exclude._node_id", excludeNodes);  
        Metadata metadata = buildMetadata(Metadata.builder(), DEFAULT_INDEX_PREFIX, indices, shards, replicas);  
                    }
    public void setupInitialCluster(int nodeCount, int indices, int shards, int replicas) {
    }
        buildNodeShardsByIndex();  
                    nodeShardsByIndex.get(node).merge(shard.getIndexName(), 1, Integer::sum);
        allocation = null;  
        clusterState = ClusterState.builder(clusterState).metadata(md).routingTable(rb).build();
        boolean hasHotSpot = false;  
        Arrays.asList(nodesToTerminate).forEach(node -> nb.remove(node));
        do {
        }
        }  
        }  
    }  
        logger.info("HotSpot: [{}], Moves to balance: [{}]", hasHotSpot, movesToBalance);  
                  Given the way {@link limit} is defined, we should not have hot spots if *all*
                  Hot spots can occur due to the order in which shards get allocated to nodes.
        logger.info("Creating zone aware cluster");  
            indexShardCount.put(DEFAULT_INDEX_PREFIX + i, shards * (replicas + 1));
                if (count <= limit) {  
            iterations++;
        if (CollectionUtils.isEmpty(nodesToValidate)) {
            }
        return movesToBalance;  
                    int peerCount = nodeShardsByIndex.get(peerNode.nodeId()).getOrDefault(index, 0);
        return rb.build();
                    .numberOfReplicas(numberOfReplicas)  
            indexShardCount.put(NEW_INDEX_PREFIX + i, shards * (replicas + 1));  
    public Metadata buildMetadata(Metadata.Builder mb, String indexPrefix, int numberOfIndices, int numberOfShards, int numberOfReplicas) {  
    protected MockAllocationService allocation;  
        int nodeId = 0;  
                  other nodes.
        }
    }
        Metadata md = buildMetadata(Metadata.builder(clusterState.getMetadata()), NEW_INDEX_PREFIX, indices, shards, replicas);
    public List<String> getNodeList(String... nodesToValidate) {  
        DiscoveryNodes nodes = addNodes(DiscoveryNodes.builder(), DEFAULT_NODE_PREFIX, nodeCount);
                IndexMetadata.builder(indexPrefix + i)  
        logger.info("Initial cluster created...");  
        return false;  
        sb.put("cluster.routing.allocation.node_concurrent_recoveries", 1);
            mb.put(
        List<String> nodeList = getNodeList(nodesToValidate);
                    }
            for (int i = 0; i < nodesPerZone.get(zone); i++) {
        if (indexShardCount == null) {  
import org.opensearch.Version;
    }
    public void buildAllocationService() {
                    continue;
    @Before
    public void updateInitialCluster() {  
        buildNodeShardsByIndex();
            initShards = clusterState.getRoutingNodes().shardsWithState(INITIALIZING);  
                }
                  function. We hence use the following alternate check --  
                  ModelNodes without adding them to actual cluster (RoutingNodes). As a result,
                // If any node is ineligible to accept the shard, this hot spot is acceptable
        sb.put("cluster.routing.allocation.cluster_concurrent_rebalance", 1);
import org.opensearch.cluster.metadata.Metadata;  
                  nodes are eligible to accept the shard. A hot spot is acceptable, if either  
                for (RoutingNode peerNode : clusterState.getRoutingNodes()) {  
    public void clearState() {
    }
        Settings.Builder sb = Settings.builder();  
        initialClusterState = null;
    private HashMap<String, HashMap<String, Integer>> nodeShardsByIndex;
    }
                    continue;
                  leads to a chain of events that breach IndexShardsPerNode constraint on all  
        assertForIndexShardHotSpots(false, nodes); // Post re-balancing, cluster should always be hot spot free.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexMetadata;
            for (String index : nodeShardsByIndex.get(node).keySet()) {
    private ClusterState initialClusterState;
        logger.info("Excluding nodes: [{}]", excludeNodes);
    }
    }  
        initialClusterState = ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).routingTable(routingTable).nodes(nodes).build();  
    }
        List<ShardRouting> initShards;
    public void buildNodeShardsByIndex() {  
        Metadata md = buildMetadata(Metadata.builder(clusterState.getMetadata()), index_prefix, indices, shards, replicas);
        DiscoveryNodes nodes = addNodes(DiscoveryNodes.builder(clusterState.nodes()), node_prefix, nodeCount);
                 */
                int count = nodeShardsByIndex.get(node).get(index);
        if (CollectionUtils.isEmpty(nodesToTerminate)) {
    }
    }
        int movesToBalance = 0;  
        assertForIndexShardHotSpots(false, nodeCount); // Initial cluster should be balanced
        }  
                }
    }
        RoutingTable routingTable = buildRoutingTable(RoutingTable.builder(), metadata, DEFAULT_INDEX_PREFIX, indices);
        List<String> nodeList = getNodeList(nodesToValidate);
        for (int i = 0; i < indices; i++) {
        }
    protected ClusterState clusterState;
                }  
        clusterState = null;
    public static String shardIdentifierFromRouting(ShardRouting shardRouting) {
import org.opensearch.cluster.node.DiscoveryNodes;
                    if (peerNode.nodeId().equals(node)) {
                for (RoutingNode peerNode : clusterState.getRoutingNodes()) {  
                hasHotSpot = true;
package org.opensearch.cluster;
import org.junit.Before;
    private static final int MAX_REROUTE_STEPS_ALLOWED = 1500;
        indexShardCount = null;  
        int iterations = 0;
/*  
    }
    public void addNodesWithoutIndexing(int nodeCount, String node_prefix) {
                  may not have had the same count in the corresponding ModelNode seen by weight
    public void addNodesWithIndexing(int nodeCount, String node_prefix, int indices, int shards, int replicas) {
        assertEquals(expected, isIndexHotSpotPresent(nodes, nodeList));
                String node = shard.currentNodeId();
                  allocation limit, that can accept current shard. However, in current  
            String node = rn.nodeId();  
                        peerHasSameShard = true;  
        return Arrays.asList(nodesToValidate);
        } while (!initShards.isEmpty());
    public DiscoveryNodes addNodes(DiscoveryNodes.Builder nb, String nodePrefix, int nodesAdded) {
                  A node with fewer shards may not be able to accept current shard due to  
import java.util.Map;
import org.opensearch.cluster.routing.RoutingNode;
                }
                        continue;
        for (int i = 0; i < numberOfIndices; i++) {
                        continue;
                }  
        RoutingTable rb = buildRoutingTable(RoutingTable.builder(clusterState.getRoutingTable()), md, NEW_INDEX_PREFIX, indices);
        }  
            clusterState = allocation.reroute(clusterState, "reroute");
                    continue;
    }
        nodeShardsByIndex = null;
        buildAllocationService(sb);  
        DiscoveryNodes.Builder nb = DiscoveryNodes.builder(clusterState.nodes());
    public ClusterState allocateShardsAndBalance(ClusterState clusterState) {  
                if (shard.state() == INITIALIZING || shard.state() == STARTED) {
                String index = shard.getIndexName();  
                }
                  the shards per node we see here, are different from the ones observed by  
        return nb.build();
import org.opensearch.core.common.util.CollectionUtils;
    public void buildZoneAwareAllocationService() {
public abstract class OpenSearchAllocationWithConstraintsTestCase extends OpenSearchAllocationTestCase {
        final String DEFAULT_INDEX_PREFIX = "index_";  
        for (int i = 0; i < nodesAdded; i++) {
        clusterState = ClusterState.builder(clusterState).metadata(md).routingTable(rb).nodes(nodes).build();
                  spots.  
        clusterState = initialClusterState;
                  ineligible to accept the shard due to SameShardAllocationDecider, as this
import org.opensearch.cluster.routing.ShardRouting;
            return Arrays.asList(clusterState.getNodes().resolveNodes());
            for (ShardRouting shard : rn) {
    public void createEmptyZoneAwareCluster(Map<String, Integer> nodesPerZone) {
        indexShardCount = new HashMap<>();  
                    }  
    }  
                int limit = (int) Math.ceil(indexShardCount.get(index) / (float) nodes);
    }  
    public void buildAllocationService(Settings.Builder sb) {  
            indexShardCount = new HashMap<>();
        }  
        } while (!clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() && iterations < MAX_REROUTE_STEPS_ALLOWED);  
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "node-terminated");
            movesToBalance++;  
                // If all peer nodes have count >= limit, hotspot is acceptable
                    .numberOfShards(numberOfShards)
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0"))
        allocation = createAllocationService(sb.build());  
                if (count > limit) {
        clusterState = initialClusterState;
import org.opensearch.cluster.routing.RoutingTable;  
                        limitBreachedOnAllNodes = false;  
                  another node. We need to differentiate between such hot spots v/s actual hot
    }
        Settings.Builder sb = Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone");
    public void assertForIndexShardHotSpots(boolean expected, int nodes, String... nodesToValidate) {
    }
                int limit = (int) Math.ceil(indexShardCount.get(index) / (float) nodes);  
            clusterState = allocation.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
                nb.add(newNode("node_" + nodeId, singletonMap("zone", zone)));  
                  weight function in balancer. RoutingNodes with {@link count} < {@link limit}
            }
import org.opensearch.common.settings.Settings;  
                    if (sameIdShardOnPeer != null && sameIdShardOnPeer.getIndexName().equals(index)) {
                  SameShardAllocationDecider, causing it to breach allocation constraint on
        }  
        RoutingTable rb = buildRoutingTable(RoutingTable.builder(clusterState.getRoutingTable()), md, index_prefix, indices);  
                if (!nodeList.contains(node)) {  
        }
            clusterState = allocation.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));  
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
            nb.add(newNode(nodePrefix + i, singletonMap("_node_id", nodePrefix + i)));  
        nodeShardsByIndex = new HashMap<>();
                }
        DiscoveryNodes nodes = addNodes(DiscoveryNodes.builder(clusterState.nodes()), node_prefix, nodeCount);  
        return shardRouting.shardId().toString() + "[" + (shardRouting.primary() ? "p" : "r") + "]";
                    return true;
                nodeShardsByIndex.get(node).merge(index, 1, Integer::sum);
            }
        buildAllocationService(sb);
        return mb.build();  
        for (int i = 0; i < indices; i++) {
            rb.addAsNew(metadata.index(indexPrefix + i));
import java.util.HashMap;
                    if (peerNode.nodeId().equals(node)) {
        clusterState = ClusterState.builder(clusterState).nodes(nb.build()).build();  
                  A simple check could be to ensure there is no node with shards less than
            clusterState = allocation.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));  
                assert shard.currentNodeId().equals(node);  
        final String DEFAULT_NODE_PREFIX = "node_";
            for (ShardRouting shard : initShards) {
                nodeId++;
        clusterState = ClusterState.builder(clusterState).nodes(nodes).build();  
        return clusterState;
                if (limitBreachedOnAllNodes) {  
    public int allocateAndCheckIndexShardHotSpots(boolean expected, int nodes, String... nodesToValidate) {
        for (int i = 0; i < indices; i++) {
        for (String node : nodeList) {  
    public void terminateNodes(String... nodesToTerminate) {  
    public void addIndices(String index_prefix, int indices, int shards, int replicas) {
                boolean peerHasSameShard = false;
                if (peerHasSameShard) {  
import java.util.List;  
import org.opensearch.cluster.routing.UnassignedInfo;
import java.util.Arrays;
    }
