@OutputTimeUnit(TimeUnit.MILLISECONDS)
        while (clusterState.getRoutingNodes().hasUnassignedShards()) {
/*  
import org.opensearch.cluster.routing.allocation.AllocationService;  
import org.opensearch.common.logging.LogConfigurator;
        }
            );  
    private DiscoveryNodes.Builder setUpClusterNodes(int nodes) {
        return clusterState;
@BenchmarkMode(Mode.AverageTime)
        Metadata metadata = mb.build();  
            Map<String, String> attributes = new HashMap<>();
import org.openjdk.jmh.annotations.State;  
    @Benchmark
                IndexMetadata.builder("test_" + i)
    @Param({  
            .build();
                .put("cluster.routing.allocation.load_awareness.skew_factor", "50")
import org.opensearch.cluster.ClusterName;
        int totalShardCount = (numReplicas + 1) * numShards * numIndices;
        allocationService = Allocators.createAllocationService(
    public int numShards = 10;  
    public int numIndices;
        }
    }
    }
        List<ShardRouting> initializingShards
                .put("cluster.routing.allocation.load_awareness.provisioned_capacity", numNodes)
@Warmup(iterations = 3)
            rb.addAsNew(metadata.index("test_" + i));  
                .put("cluster.routing.allocation.node_concurrent_recoveries", "2")  
 * this file be licensed under the Apache-2.0 license or a
                .build()
            .metadata(metadata)
import org.openjdk.jmh.annotations.OutputTimeUnit;
        RoutingTable.Builder rb = RoutingTable.builder();
}
import org.opensearch.cluster.metadata.Metadata;
import org.openjdk.jmh.annotations.BenchmarkMode;
        for (int i = 1; i <= numIndices; i++) {  
        Metadata.Builder mb = Metadata.builder();
        for (int i = 1; i <= numIndices; i++) {
import org.openjdk.jmh.annotations.Fork;
        numIndices = toInt(params[0]);
        return nb;  
            mb.put(
    private int toInt(String v) {
        }
        return allocationService.reroute(allocationService.applyStartedShards(clusterState, initializingShards), "reroute after starting");  
import org.opensearch.common.settings.Settings;
import org.openjdk.jmh.annotations.Measurement;  
        for (int i = 1; i <= nodes; i++) {
    }
                .put("cluster.routing.allocation.awareness.attributes", "zone")  
    public int numNodes;
            .nodes(setUpClusterNodes(numNodes))  
import org.opensearch.cluster.metadata.IndexMetadata;
        RoutingTable routingTable = rb.build();
                    .numberOfReplicas(numReplicas)
        LogConfigurator.setNodeName("test");
import java.util.HashMap;  
            attributes.put("zone", "zone_" + (i % 3));  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
        // indices| nodes
        return startShardsAndReroute(allocationService, clusterState, clusterState.routingTable().shardsWithState(INITIALIZING));
import org.opensearch.cluster.ClusterState;  
            clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
import org.opensearch.cluster.routing.RoutingTable;
    private AllocationService allocationService;  
        ClusterState clusterState = initialClusterState;  
@SuppressWarnings("unused") // invoked by benchmarking framework
import org.opensearch.cluster.node.DiscoveryNodes;  
    public void setUp() throws Exception {
import org.openjdk.jmh.annotations.Scope;
    private static ClusterState startInitializingShardsAndReroute(AllocationService allocationService, ClusterState clusterState) {  
    }
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
 * The OpenSearch Contributors require contributions made to  
import org.openjdk.jmh.annotations.Warmup;
        }  
import java.util.concurrent.TimeUnit;  
        AllocationService allocationService,
package org.opensearch.benchmark.routing.allocation;
import java.util.Map;
    ) {
import org.openjdk.jmh.annotations.Mode;
        return Integer.valueOf(v.trim());
 *
            Settings.builder()
            .routingTable(routingTable)
        );
    public String indicesNodes = "1|1";  
    }
    @Setup  
        numNodes = toInt(params[1]);
        DiscoveryNodes.Builder nb = DiscoveryNodes.builder();  
        initialClusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        clusterState = allocationService.reroute(clusterState, "reroute");  
public class RerouteBenchmark {
 */  
 * compatible open source license.
import org.opensearch.Version;
import org.openjdk.jmh.annotations.Param;  
import org.openjdk.jmh.annotations.Benchmark;  
        "    10000|  500|", })
@State(Scope.Benchmark)  
                    .numberOfShards(numShards)
            nb.add(Allocators.newNode("node_0_" + i, attributes));
    private static ClusterState startShardsAndReroute(
    public ClusterState measureShardAllocationEmptyCluster() throws Exception {
@Measurement(iterations = 3)  
        ClusterState clusterState,  
    public int numReplicas = 1;
    }  
import org.openjdk.jmh.annotations.Setup;
    private ClusterState initialClusterState;
        final String[] params = indicesNodes.split("\\|");  
@Fork(1)
                    .settings(Settings.builder().put("index.version.created", Version.CURRENT))  
import org.opensearch.cluster.routing.ShardRouting;
