            Settings.builder()
        }
    private ClusterState initialClusterState;
                .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(concurrentRecoveries))
import org.openjdk.jmh.annotations.State;
    // need its own main method and we cannot execute more than one class with a main method per JAR.
        "       10|      2|        0|       1|      1|      1|",
import org.openjdk.jmh.annotations.Param;
                .put("cluster.routing.allocation.cluster_concurrent_recoveries", String.valueOf(clusterConcurrentRecoveries))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
        "       10|      3|        2|      50|     30|      1|",
            Settings.builder()
            .metadata(metadata)
            .routingTable(routingTable)
        Metadata metadata = mb.build();
        "      100|      3|        2|      13|     17|      5|",
            Settings.builder()
        "       10|      2|        1|      20|     20|      1|",
        "       50|      60|       1|     100|    100|      6|",
        );
    public ClusterState measureShardRelocationComplete() throws Exception {
import org.opensearch.cluster.routing.allocation.AllocationService;
        "      100|      1|        1|      40|     50|      2|",
    @Setup
import org.opensearch.cluster.routing.RoutingTable;
        clusterZoneAwareExcludeStrategy = Allocators.createAllocationService(
import org.openjdk.jmh.annotations.BenchmarkMode;
    private DiscoveryNodes.Builder setUpClusterNodes(int sourceNodes, int targetNodes) {
        }
        initialClusterStrategy = Allocators.createAllocationService(
        "      100|      3|        0|       1|      1|     10|",
        }
            mb.put(
    @Benchmark
        "       10|      2|        0|      10|     10|      1|",
 *
        for (ShardRouting startedShard : initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED)) {
        "       10|      3|        0|      10|      5|      2|",
 * under the License.
        "       500|     60|       1|     100|    100|     12|",
 * this file be licensed under the Apache-2.0 license or a
    public void setUp() throws Exception {
@Warmup(iterations = 10)
import org.openjdk.jmh.annotations.Scope;
            );
            Map<String, String> attributes = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
            );
    public int numZone = 3;
        "       10|     10|        0|      10|      5|      5|",
        return Integer.valueOf(v.trim());
    // http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/JMHSample_10_ConstantFold.java
        targetNodes = toInt(params[4]);
        }
    @Benchmark
            assert (initialClusterState.getRoutingNodes().node(startedShard.currentNodeId()).node().getAttributes().get("tag")).equals(
            );
        for (int j = 1; j <= targetNodes; j++) {
    public int sourceNodes;
        // Ensure all shards are started
        while (initialClusterState.getRoutingNodes().hasUnassignedShards()) {
import org.openjdk.jmh.annotations.Measurement;
        "      100|      3|        1|      20|     23|      6|",
                .put("cluster.routing.allocation.cluster_concurrent_recoveries", String.valueOf(clusterConcurrentRecoveries))
        "       10|     10|        2|      50|     40|      2|",
 * KIND, either express or implied.  See the License for the
        "       10|     10|        0|       1|      1|      5|",
                .build()
        initialClusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        "       10|     10|        1|      50|     33|      2|",
    }
        "      100|     10|        2|      10|     20|      8|",
            attributes.put("tag", "tag_" + 1);
        "      100|     10|        1|       8|     17|      8|",
        assert (initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size() == totalShardCount);
        ClusterState clusterState = initialClusterState;
        "      100|      1|        1|      10|     10|      6|",
                .build()
        "       500|     60|       1|      40|    100|     12|",
@Fork(3)
            initialClusterState = initialClusterStrategy.reroute(initialClusterState, "reroute");
        assert (initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size() == 0);
public class AllocationBenchmark {
    public int numTags = 2;
        clusterState = clusterZoneAwareExcludeStrategy.reroute(clusterState, "reroute");
        concurrentRecoveries = toInt(params[5]);
            );
 * The OpenSearch Contributors require contributions made to
        "      100|      3|        2|      50|     30|      6|",
        "      100|      3|        0|      10|      5|      5|",
    private AllocationService clusterExcludeStrategy;
            rb.addAsNew(metadata.index("test_" + i));
                .put("cluster.routing.allocation.awareness.attributes", "zone")
@Measurement(iterations = 10)
        "      100|      3|        1|      50|     70|      3|",
        }
        "       10|      3|        1|      20|     30|      1|",
        "       50|      60|       1|      40|    100|      6|" })
        "      100|      3|        1|      10|      5|      8|",
 * ownership. Elasticsearch licenses this file to you under
        );
        "       10|     10|        2|       5|     10|      5|",
        for (int i = 1; i <= numIndices; i++) {
import org.openjdk.jmh.annotations.Warmup;
        RoutingTable.Builder rb = RoutingTable.builder();
        }
        "      100|      1|        0|       1|      1|     10|",
        );
            );
        final String[] params = indicesShardsReplicasSourceTargetRecoveries.split("\\|");
        "       10|     10|        1|       5|     12|      5|",
            .build();
    }
 *
        "       10|      3|        0|       1|      1|      2|",
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.ClusterState;
        "      100|     10|        1|      40|     20|      8|",
import org.openjdk.jmh.annotations.OutputTimeUnit;
        "       10|     10|        2|      50|     50|      1|",
            nb.add(Allocators.newNode("node_s_" + i, attributes));
    // Do NOT make any field final (even if it is not annotated with @Param)! See also
@State(Scope.Benchmark)
        assert (initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() == 0);
                "tag_1"
        }
        // Start all unassigned shards
            nb.add(Allocators.newNode("node_t_" + j, attributes));
import org.opensearch.cluster.ClusterName;
                    .settings(Settings.builder().put("index.version.created", Version.CURRENT))
        initialClusterState = initialClusterStrategy.reroute(initialClusterState, "reroute");
        "       10|      3|        2|      50|     30|      1|",
        "      100|      1|        2|      40|     50|      2|",
 *
                .put("cluster.routing.allocation.node_concurrent_recoveries", String.valueOf(concurrentRecoveries))
    }
        while (initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() > 0) {
        "       10|      3|        1|      10|      3|      3|",
        // indices| shards| replicas| source| target| concurrentRecoveries
}
    // we cannot use individual @Params as some will lead to invalid combinations which do not let the benchmark terminate. JMH offers no
                .put("cluster.routing.allocation.exclude.tag", "tag_0")
            initialClusterState = initialClusterStrategy.applyStartedShards(
 * compatible open source license.
    private int toInt(String v) {
        while (clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() > 0) {
        "       500|     60|       1|     100|     40|     12|",
                    .numberOfReplicas(numReplicas)
                IndexMetadata.builder("test_" + i)
        return clusterState;
        numReplicas = toInt(params[2]);
                .put("cluster.routing.allocation.exclude.tag", "tag_1")
        "      100|      1|        0|       5|     10|      5|",
        "      100|     10|        0|       1|      1|     10|",
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at
/*
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        // make sure shards are only allocated on tag1
        for (int i = 1; i <= numIndices; i++) {
import org.openjdk.jmh.annotations.Benchmark;
        return clusterState;
            .nodes(setUpClusterNodes(sourceNodes, targetNodes))
 */
                .put("cluster.routing.allocation.exclude.tag", "tag_1")
            attributes.put("zone", "zone_" + (j % numZone));
    // support to constrain the combinations of benchmark parameters and we do not want to rely on OptionsBuilder as each benchmark would
import org.opensearch.Version;
 */
        sourceNodes = toInt(params[3]);
    public int clusterConcurrentRecoveries;
 * the Apache License, Version 2.0 (the "License"); you may
    public int concurrentRecoveries;
 * SPDX-License-Identifier: Apache-2.0
        DiscoveryNodes.Builder nb = DiscoveryNodes.builder();
    public ClusterState measureExclusionOnZoneAwareStartedShard() throws Exception {
        "       10|      3|        2|      50|     25|      1|",
        "      100|     10|        0|      10|     20|      6|",
/*
import java.util.Map;
                .put("cluster.routing.allocation.awareness.attributes", "zone")
import org.opensearch.cluster.routing.ShardRoutingState;
import org.opensearch.cluster.node.DiscoveryNodes;
            attributes.put("zone", "zone_" + (i % numZone));
        "      100|      1|        2|      10|      8|      7|",
            Map<String, String> attributes = new HashMap<>();
        // We'll try to move nodes from tag_1 to tag_0
 * not use this file except in compliance with the License.
        "      100|      1|        1|      20|      5|      5|",
                    .numberOfShards(numShards)
@SuppressWarnings("unused") // invoked by benchmarking framework
        numShards = toInt(params[1]);
                initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Metadata.Builder mb = Metadata.builder();
    public int numIndices;
import org.opensearch.common.settings.Settings;
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.concurrent.TimeUnit;
        for (ShardRouting startedShard : clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED)) {
                initialClusterState,
    @Param({
        }
@BenchmarkMode(Mode.AverageTime)
import org.opensearch.cluster.metadata.Metadata;
    public int numReplicas;
                .build()
        for (int i = 1; i <= sourceNodes; i++) {
        "       50|      60|       1|     100|     40|      6|",
 * software distributed under the License is distributed on an
            initialClusterState = initialClusterStrategy.applyStartedShards(
        "       10|      1|        1|      10|     10|      1|",
        return nb;
        "      100|     10|        1|      60|     50|      3|",
    public int numShards;
        "       10|      3|        2|      10|      5|      3|",
        RoutingTable routingTable = rb.build();
        ClusterState clusterState = initialClusterState;
                clusterState,
            attributes.put("tag", "tag_" + 0);
package org.opensearch.benchmark.routing.allocation;
    public String indicesShardsReplicasSourceTargetRecoveries = "10|1|0|1|1|1";
            clusterState = clusterZoneAwareExcludeStrategy.applyStartedShards(
/*
 * specific language governing permissions and limitations
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Setup;
        clusterState = clusterZoneAwareExcludeStrategy.reroute(clusterState, "reroute");
                clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING)
        clusterConcurrentRecoveries = Math.min(sourceNodes, targetNodes) * concurrentRecoveries;
import org.opensearch.cluster.routing.ShardRouting;
    }
        "       10|      1|        2|      10|     10|      1|",
    private AllocationService clusterZoneAwareExcludeStrategy;
 */
        }
 * Licensed to Elasticsearch under one or more contributor
        "       10|     10|        1|      20|     10|      3|",
        "      100|     10|        2|      33|     55|      6|",
        clusterZoneAwareExcludeStrategy = Allocators.createAllocationService(
    private AllocationService initialClusterStrategy;
        numIndices = toInt(params[0]);
                initialClusterState,
        int totalShardCount = (numReplicas + 1) * numShards * numIndices;
                initialClusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING)
 * this work for additional information regarding copyright
import java.util.HashMap;
                .put("cluster.routing.allocation.awareness.attributes", "zone")
            assert (clusterState.getRoutingNodes().node(startedShard.currentNodeId()).node().getAttributes().get("tag")).equals("tag_0");
import org.openjdk.jmh.annotations.Mode;
    public int targetNodes;
                .put("cluster.routing.allocation.node_concurrent_recoveries", "20")
