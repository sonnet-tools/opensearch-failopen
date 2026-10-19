        for (int i = 0; i < 3; i++) {
        }  
            ? Set.of(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.WARM_ROLE)
    }  
        final String indexLimitKey = remote
/**  
     * @param remote true for remote-capable nodes/indices (RemoteShardsBalancer), false for local (LocalShardsBalancer)
     * RemoteShardsBalancer may settle at 16 assigned shards because its balance() only rebalances
        assertEquals("RemoteShardsBalancer should converge to 17 assigned shards", 17, assignedShards);
     */  
    /**
import org.opensearch.cluster.routing.RoutingTable;
     */
        clusterState = service.reroute(clusterState, "reroute");
 * The OpenSearch Contributors require contributions made to  
            clusterState = startInitializingShardsAndReroute(service, clusterState);
            nb.add(newNode(id, id, roles));  
import java.util.stream.StreamSupport;
        Metadata metadata = mb.build();
        final Set<DiscoveryNodeRole> roles = remote  
    private Settings.Builder indexSettings(boolean remote) {
 * compatible open source license.
            ? ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.getKey()
     * @return number of assigned shards after allocation converges  
            iterations++;  
     * by primary count, not total shard count. When this is fixed, remove the {@code @AwaitsFix}.
        int assignedShards = runTightCapacityScenario(true);  
            .addAsNew(metadata.index("test3"))  
        }
    /**  
            ? ShardsLimitAllocationDecider.CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING.getKey()
        final Metadata.Builder mb = Metadata.builder();  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/19726#issuecomment-4049069484")
    private ClusterState allocateToConvergence(AllocationService service, ClusterState clusterState) {
        mb.put(IndexMetadata.builder("test3").settings(indexSettings(remote)).numberOfShards(3).numberOfReplicas(1));  
        return sb;
            .addAsNew(metadata.index("test2"))
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        while (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false && iterations < 10) {
        }
        final AllocationService strategy = createAllocationService(settings, clusterSettings, random());
            .build();  
            .build();
}
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.metadata.IndexMetadata;
 * Tests allocation convergence in a tight-capacity scenario: 3 nodes, cluster limit of 6 shards/node
 * weight-based rebalancing. RemoteShardsBalancer's balance() only considers primary counts, so it  
        int assignedShards = runTightCapacityScenario(false);
import org.opensearch.cluster.node.DiscoveryNodeRole;
        final String clusterLimitKey = remote  
import org.opensearch.cluster.routing.RoutingNode;  
    public void testTightCapacityConvergenceWithLocalShards() {
 *
import org.opensearch.cluster.ClusterName;
 */
 */  
    }
package org.opensearch.cluster.routing.allocation;
        return StreamSupport.stream(clusterState.getRoutingNodes().spliterator(), false).mapToInt(RoutingNode::numberOfOwningShards).sum();
            .routingTable(routingTable)
    }
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)  
 * <p>
            .build();
        final Settings settings = Settings.builder()  
            .addAsNew(metadata.index("test1"))
            .metadata(metadata)
 * cannot always converge.
import org.opensearch.cluster.ClusterState;  
import java.util.Set;
/*  
 * (18 total slots), 3 indices totaling 20 shards where one index has an index-level limit of 1 shard/node.
            : Set.of(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE);
        assertTrue("Expected no shards to be INITIALIZING", clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty());
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        if (remote) {
    /**
        assertEquals("LocalShardsBalancer should converge to 17 assigned shards", 17, assignedShards);  
 * Expected result: 17 assigned shards, 3 unassigned (the constrained index's replicas).  
 * this file be licensed under the Apache-2.0 license or a
        mb.put(IndexMetadata.builder("test2").settings(indexSettings(remote)).numberOfShards(4).numberOfReplicas(1));
import org.opensearch.common.settings.Settings;
            : ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey();
import org.opensearch.Version;
            : ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey();  
    }
import org.opensearch.cluster.metadata.Metadata;  
    public void testTightCapacityConvergenceWithRemoteShards() {
            String id = "node-" + i;
        final Settings.Builder sb = settings(Version.CURRENT);  
        int iterations = 0;  
            .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            sb.put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey());
    private int runTightCapacityScenario(boolean remote) {
     * LocalShardsBalancer converges to 17 assigned shards via weight-based total-shard rebalancing.
        // test1: 3p+3r with index limit 1/node, test2: 4p+4r, test3: 3p+3r = 20 total, 17 assignable
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
public class ShardsBalancerTightCapacityTests extends OpenSearchAllocationTestCase {  
        final RoutingTable routingTable = RoutingTable.builder()  
            .nodes(nb)  
    }
        return clusterState;  
        mb.put(IndexMetadata.builder("test1").settings(indexSettings(remote).put(indexLimitKey, 1)).numberOfShards(3).numberOfReplicas(1));
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;
        final DiscoveryNodes.Builder nb = DiscoveryNodes.builder();  
 * SPDX-License-Identifier: Apache-2.0
     */  
 * This requires the balancer to redistribute shards optimally. LocalShardsBalancer handles this via
            .put(clusterLimitKey, 6)
import org.opensearch.index.IndexModule;
        clusterState = allocateToConvergence(strategy, clusterState);  
import org.opensearch.common.settings.ClusterSettings;  
