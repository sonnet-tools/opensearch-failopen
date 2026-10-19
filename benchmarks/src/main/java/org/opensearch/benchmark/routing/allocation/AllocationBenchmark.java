@Warmup(iterations = 10)
        concurrentRecoveries = toInt(params[5]);
                .put("cluster.routing.allocation.awareness.attributes", "zone")
 * compatible open source license.
 */  
import org.opensearch.cluster.routing.allocation.AllocationService;  
        int totalShardCount = (numReplicas + 1) * numShards * numIndices;  
        Metadata metadata = mb.build();
 * GitHub history for details.
@State(Scope.Benchmark)
        "      100|      3|        2|      13|     17|      5|",
    private AllocationService initialClusterStrategy;  
    @Benchmark
        for (ShardRouting startedShard : initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED)) {  
                initialClusterState,
    // support to constrain the combinations of benchmark parameters and we do not want to rely on OptionsBuilder as each benchmark would  
        for (int j = 1; j <= targetNodes; j++) {
                clusterState,
        assert (initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size() == 0);
                .put("cluster.routing.allocation.cluster_concurrent_recoveries", String.valueOf(clusterConcurrentRecoveries))  
    public int numTags = 2;
 * Licensed to Elasticsearch under one or more contributor  
        "      100|      3|        2|      50|     30|      6|",
        "      100|      3|        1|      20|     23|      6|",  
            Settings.builder()  
    private ClusterState initialClusterState;  
        "       10|      3|        0|       1|      1|      2|",
        clusterState = clusterZoneAwareExcludeStrategy.reroute(clusterState, "reroute");
                .put("cluster.routing.allocation.exclude.tag", "tag_1")
        }  
        "       500|     60|       1|      40|    100|     12|",
            );
import org.opensearch.cluster.node.DiscoveryNodes;
 * license agreements. See the NOTICE file distributed with
            Settings.builder()  
            .build();
/*
        "       10|     10|        1|      50|     33|      2|",
            rb.addAsNew(metadata.index("test_" + i));
        // Start all unassigned shards  
    // http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/JMHSample_10_ConstantFold.java  
        return clusterState;
 * this file be licensed under the Apache-2.0 license or a
        "      100|      1|        0|       5|     10|      5|",
                .put("cluster.routing.allocation.exclude.tag", "tag_0")  
    public int numReplicas;
import org.opensearch.cluster.routing.ShardRouting;
@Fork(3)  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.concurrent.TimeUnit;
import org.opensearch.common.settings.Settings;
public class AllocationBenchmark {
    public int targetNodes;  
        "      100|     10|        1|       8|     17|      8|",
            );  
        "      100|     10|        1|      40|     20|      8|",
        );  
                .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(concurrentRecoveries))  
@SuppressWarnings("unused") // invoked by benchmarking framework  
                initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING)
        for (ShardRouting startedShard : clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED)) {
        "      100|      1|        1|      40|     50|      2|",  
/*  
        for (int i = 1; i <= numIndices; i++) {
        while (initialClusterState.getRoutingNodes().hasUnassignedShards()) {
        sourceNodes = toInt(params[3]);
import org.openjdk.jmh.annotations.Mode;  
        numIndices = toInt(params[0]);
        initialClusterState = initialClusterStrategy.reroute(initialClusterState, "reroute");
        "       10|     10|        2|      50|     40|      2|",  
        "      100|     10|        2|      33|     55|      6|",  
    public ClusterState measureExclusionOnZoneAwareStartedShard() throws Exception {  
        // indices| shards| replicas| source| target| concurrentRecoveries  
        while (clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() > 0) {
import org.openjdk.jmh.annotations.Setup;
    @Benchmark
        ClusterState clusterState = initialClusterState;
        "       50|      60|       1|      40|    100|      6|" })
        "       10|      3|        2|      50|     25|      1|",
@BenchmarkMode(Mode.AverageTime)  
        return clusterState;
import org.openjdk.jmh.annotations.Scope;  
                .build()
        "       10|      3|        0|      10|      5|      2|",  
        targetNodes = toInt(params[4]);  
        initialClusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * software distributed under the License is distributed on an
        "       10|      2|        1|      20|     20|      1|",
        assert (initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() == 0);  
        );
        "       10|      3|        2|      10|      5|      3|",
            attributes.put("zone", "zone_" + (j % numZone));
import org.opensearch.cluster.ClusterName;
            mb.put(  
    public int numZone = 3;  
        "      100|      1|        1|      10|     10|      6|",  
        "      100|      1|        2|      10|      8|      7|",
import java.util.HashMap;
                IndexMetadata.builder("test_" + i)
    @Param({
                    .settings(Settings.builder().put("index.version.created", Version.CURRENT))
    // Do NOT make any field final (even if it is not annotated with @Param)! See also
                clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING)
            );  
        return Integer.valueOf(v.trim());
        "       10|      1|        2|      10|     10|      1|",
        "       10|     10|        2|       5|     10|      5|",  
/*
 */
import org.opensearch.cluster.metadata.IndexMetadata;  
        for (int i = 1; i <= sourceNodes; i++) {
    public ClusterState measureShardRelocationComplete() throws Exception {  
import org.opensearch.cluster.ClusterState;
    }  
        ClusterState clusterState = initialClusterState;
        "      100|      1|        2|      40|     50|      2|",
        }  
            );  
 * the Apache License, Version 2.0 (the "License"); you may
        "       50|      60|       1|     100|     40|      6|",
import org.opensearch.cluster.metadata.Metadata;
 * ownership. Elasticsearch licenses this file to you under  
        "       10|     10|        2|      50|     50|      1|",
    public void setUp() throws Exception {  
 * KIND, either express or implied.  See the License for the
        "      100|     10|        2|      10|     20|      8|",  
@Measurement(iterations = 10)
 * not use this file except in compliance with the License.
        "      100|      3|        0|       1|      1|     10|",
    public int numShards;  
 *
        "      100|      1|        0|       1|      1|     10|",
 * under the License.  
                    .numberOfReplicas(numReplicas)
                initialClusterState,  
    }
import org.openjdk.jmh.annotations.BenchmarkMode;  
import java.util.Map;  
 * this work for additional information regarding copyright
            .routingTable(routingTable)  
            Settings.builder()  
        "       10|     10|        1|      20|     10|      3|",
        "      100|     10|        0|       1|      1|     10|",  
        "       50|      60|       1|     100|    100|      6|",  
@OutputTimeUnit(TimeUnit.MILLISECONDS)
        assert (initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size() == totalShardCount);
        DiscoveryNodes.Builder nb = DiscoveryNodes.builder();  
 *  
        }
        "       10|      3|        2|      50|     30|      1|",  
 *
        "       10|      2|        0|      10|     10|      1|",
    // we cannot use individual @Params as some will lead to invalid combinations which do not let the benchmark terminate. JMH offers no
                .put("cluster.routing.allocation.awareness.attributes", "zone")
 */
        }
        "       10|      3|        1|      10|      3|      3|",
            attributes.put("tag", "tag_" + 1);  
    }
        }
        RoutingTable.Builder rb = RoutingTable.builder();
        "      100|     10|        0|      10|     20|      6|",
        }
import org.openjdk.jmh.annotations.Measurement;
        "       10|      1|        1|      10|     10|      1|",  
        "       10|      3|        1|      20|     30|      1|",  
}  
        "       500|     60|       1|     100|     40|     12|",  
            initialClusterState = initialClusterStrategy.applyStartedShards(
        "       10|     10|        1|       5|     12|      5|",
            nb.add(Allocators.newNode("node_t_" + j, attributes));
            attributes.put("zone", "zone_" + (i % numZone));
import org.openjdk.jmh.annotations.Fork;
        initialClusterStrategy = Allocators.createAllocationService(
    // need its own main method and we cannot execute more than one class with a main method per JAR.
                .put("cluster.routing.allocation.node_concurrent_recoveries", "20")
        clusterZoneAwareExcludeStrategy = Allocators.createAllocationService(
        // We'll try to move nodes from tag_1 to tag_0
            attributes.put("tag", "tag_" + 0);  
                .build()
        // Ensure all shards are started  
 * The OpenSearch Contributors require contributions made to  
    private AllocationService clusterZoneAwareExcludeStrategy;
        }  
package org.opensearch.benchmark.routing.allocation;
    public int clusterConcurrentRecoveries;
        numReplicas = toInt(params[2]);
        "      100|     10|        1|      60|     50|      3|",
            initialClusterState = initialClusterStrategy.reroute(initialClusterState, "reroute");
    public int sourceNodes;
        RoutingTable routingTable = rb.build();  
import org.opensearch.cluster.routing.ShardRoutingState;
            Map<String, String> attributes = new HashMap<>();
                .put("cluster.routing.allocation.exclude.tag", "tag_1")
        clusterConcurrentRecoveries = Math.min(sourceNodes, targetNodes) * concurrentRecoveries;
import org.openjdk.jmh.annotations.Benchmark;
                .put("cluster.routing.allocation.awareness.attributes", "zone")
    private DiscoveryNodes.Builder setUpClusterNodes(int sourceNodes, int targetNodes) {
        "      100|      3|        1|      10|      5|      8|",
            );
    }  
                "tag_1"
        "      100|      3|        1|      50|     70|      3|",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
    public int numIndices;
        while (initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() > 0) {
        for (int i = 1; i <= numIndices; i++) {  
        numShards = toInt(params[1]);  
        return nb;
 * You may obtain a copy of the License at  
    public String indicesShardsReplicasSourceTargetRecoveries = "10|1|0|1|1|1";  
    private int toInt(String v) {
        clusterZoneAwareExcludeStrategy = Allocators.createAllocationService(
            initialClusterState = initialClusterStrategy.applyStartedShards(  
        "      100|      3|        0|      10|      5|      5|",  
        }
            nb.add(Allocators.newNode("node_s_" + i, attributes));
            assert (initialClusterState.getRoutingNodes().node(startedShard.currentNodeId()).node().getAttributes().get("tag")).equals(
                .put("cluster.routing.allocation.cluster_concurrent_recoveries", String.valueOf(clusterConcurrentRecoveries))
        );  
        }  
            .metadata(metadata)
        "       10|     10|        0|       1|      1|      5|",  
    public int concurrentRecoveries;
            assert (clusterState.getRoutingNodes().node(startedShard.currentNodeId()).node().getAttributes().get("tag")).equals("tag_0");  
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.OutputTimeUnit;
            Map<String, String> attributes = new HashMap<>();
        "       10|      3|        2|      50|     30|      1|",
        // make sure shards are only allocated on tag1
                .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(concurrentRecoveries))
import org.opensearch.cluster.routing.RoutingTable;  
        "       10|     10|        0|      10|      5|      5|",
            .nodes(setUpClusterNodes(sourceNodes, targetNodes))
    }  
        final String[] params = indicesShardsReplicasSourceTargetRecoveries.split("\\|");
 * Unless required by applicable law or agreed to in writing,
        clusterState = clusterZoneAwareExcludeStrategy.reroute(clusterState, "reroute");
import org.openjdk.jmh.annotations.Param;
            clusterState = clusterZoneAwareExcludeStrategy.applyStartedShards(  
                initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING)
        "       10|      2|        0|       1|      1|      1|",
    private AllocationService clusterExcludeStrategy;
        "      100|      1|        1|      20|      5|      5|",
 * Modifications Copyright OpenSearch Contributors. See  
                    .numberOfShards(numShards)  
        "       500|     60|       1|     100|    100|     12|",
import org.openjdk.jmh.annotations.Warmup;  
 * SPDX-License-Identifier: Apache-2.0
                .build()
        Metadata.Builder mb = Metadata.builder();
import org.opensearch.Version;  
    @Setup
