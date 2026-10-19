            weights = Map.of("zone1", -1.0, "zone2", 0.0, "zone3", 1.0);
        }
        }
            .routingTable(routingTable)
        clusterState = ClusterState.builder(clusterState)  
        Metadata metadata = Metadata.builder()
            .nodes(
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_shards:1");
        shardsIterator = clusterState.routingTable()
    public void testWeightedRoutingShardStateWithDifferentWeights() {  
            weightedRouting = new WeightedRouting("zone", weights);  
        assertThat(shardIterators.size(), equalTo(1));  
        );  
import org.opensearch.common.settings.Settings;  
        ShardIterator shardIterator = routingTable.index("test1").shard(0).shardsRandomIt();
                )  
            assertEquals(startedNodes[0], shardIterator.nextOrNull().currentNodeId());
        assertThat(shardIterator.remaining(), equalTo(0));
        assertTrue(routing.started());
     * Test to validate that shard routing state is maintained across requests, requests are assigned to nodes  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
            assertNotEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());
                .routingTable(routingTable)  
                .build();
        ShardIterator iter = shardIterators.iterator().next();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            "_replica_first"
                .shard(0)  
            // Make iterator call with different weights
        assertThat(shardIterator.remaining(), equalTo(0));
            assertEquals(3, requestCount.get("node1").intValue());  
        shardIterator = new PlainShardIterator(new ShardId("test1", "_na_", 0), shuffler.shuffle(Collections.<ShardRouting>emptyList()));
        assertThat(shardIterator.remaining(), equalTo(0));  
            .build();
                    .numberOfReplicas(2)  
                .build();
import org.opensearch.cluster.routing.ShardShuffler;
            Map<String, Double> weights2 = Map.of("zone1", 1.0, "zone2", 0.0, "zone3", 1.0);  
 *
package org.opensearch.cluster.structure;
            assertEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());
            ShardIterator shardIterator = clusterState.routingTable()
        assertThat(shardRouting1, not(sameInstance(shardRouting2)));
        iter = shardIterators.iterator().next();
            ShardRouting shardRouting;
        clusterState = strategy.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
                .put("cluster.routing.allocation.awareness.attributes", "zone");
                .shard(0)
        assertThat(shardsIterator.size(), equalTo(1));
            // Make iterator call with same WeightedRouting instance
        assertThat(shardIterator.size(), equalTo(2));
                .shard(0)
        } catch (IllegalArgumentException illegal) {
        shardRouting = shardIterator.nextOrNull();  
                .shard(0)  
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));
            clusterState = strategy.reroute(clusterState, "reroute");
        try {
            assertThat(it.nextOrNull().currentNodeId(), equalTo("node2"));
                .nodes(  
            clusterState = strategy.reroute(clusterState, "reroute");
            .nodes(
            terminate(threadPool);
                shardIterator = clusterState.routingTable()
                .build();  
            RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
        assertThat(shardIterators.size(), equalTo(1));
                .build()
        assertThat(shardIterator.nextOrNull(), nullValue());
        assertNotNull(routing);  
    }  
 * ownership. Elasticsearch licenses this file to you under  
                .index("test")
            WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        assertThat(shardRouting2, notNullValue());
import org.opensearch.cluster.ClusterState;  
            assertEquals(startedNodes[1], shardIterator.nextOrNull().currentNodeId());
 *  
            clusterState,
        assertThat(shardIterator.remaining(), equalTo(0));  
        Metadata metadata = Metadata.builder()  
                        .localNodeId("node1")
                        .localNodeId("node1")
            assertFalse(Arrays.asList("node3").contains(shardRouting.currentNodeId()));  
        );  
        assertThat(shardRouting3, notNullValue());
            assertFalse(Arrays.asList("node3").contains(shardRouting.currentNodeId()));  
                    .localNodeId("node1")  
                    .index("test")
            .build();  
                .index("test")
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_shards:0");
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node2"));
        assertThat(shardIterators.size(), equalTo(1));
                indexShardRoutingTable.getActiveShardsByWeight().get(new IndexShardRoutingTable.WeightedRoutingKey(weightedRouting))  
            String initializingZone = null;
            weightsList.add(weights2);
            Map<String, Double> weights = Map.of(startedZones[0], 1.0, initializingZone, 1.0, startedZones[1], 0.0);  
        iter = shardIterators.iterator().next();
                        .add(newNode("node2", unmodifiableMap(node2Attributes)))  
            node1Attributes.put("zone", "zone1");  
            WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        }
            clusterState = startRandomInitializingShard(clusterState, strategy);  
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                }  
            Map<String, String> node1Attributes = new HashMap<>();
                assertNotNull(shardRouting);  
            .onlyNodeSelectorActiveInitializingShardsIt("dis*:eph*", clusterState.nodes());
        assertThat(shardRouting.currentNodeId(), equalTo("node2"));
            // Making the first shard as active  
            Settings.Builder settings = Settings.builder()
import org.opensearch.threadpool.TestThreadPool;
}  
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            .onlyNodeSelectorActiveInitializingShardsIt(new String[] { "disk:*", "invalid_name" }, clusterState.nodes());
                .index("test")  
        // after all are started, check routing iteration
        routing = iter.nextOrNull();
        OperationRouting operationRouting = new OperationRouting(
            .preferAttributesActiveInitializingShardsIt(Arrays.asList("rack_id"), clusterState.nodes());
            .index("test")
            assertEquals(3, shardIterator.size());  
    public void testWeightedRoutingShardState() {
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            .onlyNodeSelectorActiveInitializingShardsIt(new String[] { "disk:eph*", "disk:ebs" }, clusterState.nodes());
            RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                .put("cluster.routing.allocation.awareness.attributes", "zone");  
        assertThat(shardIterator.remaining(), equalTo(0));
                .shard(0)
            node3Attributes.put("zone", "zone3");
    public void testSearchableSnapshotPreference() {
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        assertThat(shardIterator.nextOrNull(), nullValue());  
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;  
            Settings.Builder settings = Settings.builder()
            String[] startedZones = new String[2];  
                assertEquals(3, shardIterator.size());  
            RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .metadata(metadata)
            Map<String, String> node3Attributes = new HashMap<>();  
            assertEquals(3, shardIterator.size());
            clusterState = strategy.reroute(clusterState, "reroute");
            .index("test")  
        assertThat(shardRouting7, sameInstance(shardRouting3));  
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));
 * Modifications Copyright OpenSearch Contributors. See
            clusterState = strategy.reroute(clusterState, "reroute");
            AllocationService strategy = createAllocationService(settings.build());
        assertThat(shardsIterator.size(), equalTo(1));
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                    .index("test")
            weights = Map.of("zone1", -1.0, "zone2", 0.0, "zone3", 1.0);
            assertFalse(Arrays.asList("node2").contains(shardRouting.currentNodeId()));  
            Map<String, String> node3Attributes = new HashMap<>();  
            .onlyNodeSelectorActiveInitializingShardsIt(new String[] { "disk:*", "disk:*" }, clusterState.nodes());  
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
 * You may obtain a copy of the License at  
    }  
        final ShardIterator it = iterator.next();  
        );
            clusterState = ClusterState.builder(clusterState)
                    .add(newNode("node1", unmodifiableMap(node1Attributes)))
        shardIterator = routingTable.index("test1").shard(0).shardsRandomIt();
                .put("cluster.routing.allocation.awareness.attributes", "zone");
        assertThat(shardIterator.nextOrNull(), nullValue());
        AllocationService strategy = createAllocationService(settings.build());  
 * this work for additional information regarding copyright
    }
                    .index("test")  
            WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        assertThat(iter.size(), equalTo(1)); // one potential candidate (primary) for the shard  
            Map<String, String> node3Attributes = new HashMap<>();
import java.util.Map;  
/*
            );
        ShardRouting shardRouting4 = shardIterator.nextOrNull();
        assertThat(shardIterator.remaining(), equalTo(0));
        assertThat(shardRouting8, sameInstance(shardRouting4));
        Iterator<ShardIterator> iterator = shardIterators.iterator();
        TestThreadPool threadPool = null;
        ShardRouting shardRouting3 = shardIterator.nextOrNull();  
        assertThat(firstNodeId, anyOf(equalTo("node1"), equalTo("node2")));  
                .build();  
        assertThat(iter.size(), equalTo(3)); // three potential candidates for the shard  
import java.util.Iterator;
        assertThat(shardRouting, notNullValue());
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        AllocationService strategy = createAllocationService(  
    public void testNodeSelectorRouting() {
            .build();  
                    .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);  
        final String firstNodeId = it.nextOrNull().currentNodeId();
                assertEquals(shardRouting1.currentNodeId(), shardRouting2.currentNodeId());
        assertThat(shardsIterator.size(), equalTo(2));
            assertNotNull(
            weights = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 1.0);  
            shardRouting = shardIterator.nextOrNull();
            Map<String, String> node1Attributes = new HashMap<>();
                        .add(newNode("node3", unmodifiableMap(node3Attributes)))
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));  
        assertThat(shardIterator.nextOrNull(), nullValue());
        assertThat(shardIterator.size(), equalTo(2));
        clusterState = strategy.reroute(clusterState, "reroute"); // Move replicas to initializing  
        clusterState = strategy.reroute(clusterState, "reroute");  
                    .add(newNode("fred", "node1", singletonMap("disk", "ebs")))  
            Metadata metadata = Metadata.builder()  
        ShardRouting shardRouting9 = shardIterator.nextOrNull();
            node3Attributes.put("zone", "zone3");
            List<Map<String, Double>> weightsList = new ArrayList<>();  
                    .add(newNode("node1", Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)))
            shardIterator = clusterState.routingTable()
    public void testShardsAndPreferNodeRouting() {
        assertThat(shardRouting2, not(sameInstance(shardRouting1)));
                    DiscoveryNodes.builder()
                .shard(0)
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_shards:0|_prefer_nodes:node1");
            assertEquals(1, shardIterator.size());  
                assertEquals(shardRouting1.currentNodeId(), shardRouting3.currentNodeId());
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
        shardIterator = routingTable.index("test1").shard(0).shardsIt(2);
        assertThat(shardIterator.remaining(), equalTo(0));  
 * Unless required by applicable law or agreed to in writing,
            .index("test")  
            clusterState = ClusterState.builder(clusterState)
        Metadata metadata = Metadata.builder()
        clusterState = strategy.reroute(clusterState, "reroute"); // Move replicas to initializing
        assertTrue(routing.primary()); // replicas haven't initialized yet, so primary is first
                    .add(newNode("node2", unmodifiableMap(node2Attributes)))
        assertThat(shardRouting7, notNullValue());
        );
        assertThat(shardRouting.currentNodeId(), equalTo("node1"));
    }
                    .numberOfShards(2)
                    DiscoveryNodes.builder()  
                    .shard(0)  
            shardIterator = clusterState.routingTable()
            .build();
                .index("test")  
            .onlyNodeSelectorActiveInitializingShardsIt("fred", clusterState.nodes());  
            weightsList.add(weights1);
        shardIterator = new PlainShardIterator(new ShardId("test1", "_na_", 0), shuffler.shuffle(Collections.<ShardRouting>emptyList()));
            // expected exception  
                .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))  
                    initializingNode = shard.currentNodeId();  
        }
            assertNotNull(shardRouting);
            assertNull(  
                    startedZones[i++] = nodes.resolveNode(shard.currentNodeId()).getAttributes().get("zone");
            terminate(threadPool);  
            new String[] { "test" },  
            ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);  
            clusterState = strategy.reroute(clusterState, "reroute");
import static java.util.Collections.singletonMap;
                ShardIterator shardIterator = clusterState.routingTable()
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
            weightedRouting = new WeightedRouting("zone", weights);  
                    .add(newNode("node2", Collections.singleton(DiscoveryNodeRole.WARM_ROLE)))  
                .localNodeId("node1")
            Settings.Builder settings = Settings.builder()
import java.util.Arrays;
            assertEquals(startedNodes[1], shardIterator.nextOrNull().currentNodeId());
        ShardRouting routing = iter.nextOrNull();
                    DiscoveryNodes.builder()
        clusterState = strategy.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
        } else {
            shardIterator = clusterState.routingTable()
                        .add(newNode("node1", unmodifiableMap(node1Attributes)))
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);  
            assertEquals(startedNodes[0], shardIterator.nextOrNull().currentNodeId());  
    public void testIterator2() {  
            IndexShardRoutingTable indexShardRoutingTable = clusterState.routingTable().index("test").shard(0);
        ShardRouting shardRouting = shardIterator.nextOrNull();
        assertThat(shardIterators.iterator().next().shardId().id(), equalTo(1));  
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    DiscoveryNodes.builder()
        assertThat(shardIterators.size(), equalTo(1));
        );  
        ShardRouting shardRouting10 = shardIterator.nextOrNull();
        ShardRouting shardRouting2 = shardIterator.nextOrNull();
        // finally the primary
        assertThat(shardIterator.nextOrNull(), nullValue());
        assertThat(shardsIterator.size(), equalTo(2));  
            assertEquals(startedNodes[0], shardIterator.nextOrNull().currentNodeId());
            assertThat(it.nextOrNull().currentNodeId(), equalTo("node1"));
            Map<String, Double> weights4 = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 0.0);  
        assertFalse(routing.primary());
            weightedRouting = new WeightedRouting("zone", weights);
                DiscoveryNodes.builder()  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test1")).build();  
            Map<String, Double> weights = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 0.0);
                    .localNodeId("node1")
        assertThat(shardRouting3, not(sameInstance(shardRouting2)));
            Settings.Builder settings = Settings.builder()
import java.util.HashMap;  
     * Test to validate that shard routing state is maintained across requests
            node2Attributes.put("zone", "zone2");
        assertThat(shardRouting3, notNullValue());  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
        node1Attributes.put("rack_id", "rack_1");
            assertEquals(3, shardIterator.size());
        assertThat(shardIterator.nextOrNull(), nullValue());
        ShardShuffler shuffler = new RotationShardShuffler(0);
                .build();
            .preferAttributesActiveInitializingShardsIt(Arrays.asList("rack_id"), clusterState.nodes());  
 * license agreements. See the NOTICE file distributed with
            assertEquals(2, shardIterator.size());  
        // check node preference, first without preference to see they switch
        assertThat(shardRouting1, sameInstance(shardRouting3));
            .routingTable(routingTable)  
            ShardRouting shardRouting;
        assertThat(shardRouting.currentNodeId(), equalTo("node1"));  
import org.opensearch.common.settings.ClusterSettings;
        assertThat(shardRouting8, not(sameInstance(shardRouting7)));
                    .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
        assertThat(shardIterator.remaining(), equalTo(0));
            String initializingNode = null;
            Map<String, Double> weights2 = Map.of("zone1", 1.0, "zone2", 0.0, "zone3", 1.0);  
                .nodes(  
        assertTrue(routing.started());
        try {  
            assertEquals(2, requestCount.get("node2").intValue());
        }
                .shard(0)  
            weightedRouting = new WeightedRouting("zone", weights);
        String firstRoundNodeId = shardIterators.iterator().next().nextOrNull().currentNodeId();  
            assertEquals(1, shardIterator.size());
            null,
            .shard(0)
            }
            ShardIterator shardIterator = clusterState.routingTable()
        assertThat(shardRouting2, notNullValue());
import org.opensearch.cluster.ClusterName;
            AllocationService strategy = createAllocationService(settings.build());
        assertThat(shardsIterator.size(), equalTo(1));
                        .add(newNode("node3", unmodifiableMap(node3Attributes)))
            .routingTable(routingTable)
import static java.util.Collections.unmodifiableMap;  
        assertThat(shardRouting2, notNullValue());  
import org.opensearch.cluster.routing.PlainShardIterator;  
        try {  
import static org.hamcrest.Matchers.equalTo;  
    }  
        clusterState = strategy.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
            weightsList.add(weights1);
                .build();
        Metadata metadata = Metadata.builder()
        try {
                .metadata(metadata)
                        .add(newNode("node2", unmodifiableMap(node2Attributes)))  
        assertThat(shardIterators.iterator().next().nextOrNull().currentNodeId(), equalTo("node1"));
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(shardIterator.nextOrNull(), nullValue());
            clusterState = ClusterState.builder(clusterState)
        assertThat(shardIterator.size(), equalTo(2));  
    }  
            settings.putList("cluster.routing.allocation.awareness.attributes", "rack_id", "zone");  
        );  
        routing = iter.nextOrNull();  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .metadata(metadata)  
            Metadata metadata = Metadata.builder()
        assertThat(shardIterator.remaining(), equalTo(2));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .index("test")
import org.opensearch.Version;
            AllocationService strategy = createAllocationService(settings.build());
import org.opensearch.cluster.routing.ShardsIterator;  
            shardIterator = clusterState.routingTable()
    public void testWeightedRoutingInMemoryStore() {
                    .shard(0)
            weightedRouting = new WeightedRouting("zone", weights);
        } else {  
            terminate(threadPool);  
 *
        assertThat(shardIterator.nextOrNull(), nullValue());
            fail("should have raised illegalArgumentException");
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
            AllocationService strategy = createAllocationService(settings.build());  
        assertThat(shardIterators.size(), equalTo(2)); // two potential shards
            .build();
        clusterState = strategy.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
import org.opensearch.cluster.routing.ShardIterator;  
        assertThat(shardRouting6, notNullValue());  
    public void testReplicaShardPreferenceIters() {
                .build();  
        try {  
                indexShardRoutingTable.getActiveShardsByWeight().get(new IndexShardRoutingTable.WeightedRoutingKey(weightedRouting))  
            assertNull(
        shardsIterator = clusterState.routingTable()  
            assertEquals(3, shardIterator.size());  
    public void testRandomRouting() {
            ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);  
        Map<String, String> node2Attributes = new HashMap<>();
/*  
        assertThat(shardIterator.remaining(), equalTo(0));  
            new ShardId("test1", "_na_", 0),
            clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(shardIterator.remaining(), equalTo(1));  
                        Settings.builder()
            Metadata metadata = Metadata.builder()
            List<Map<String, Double>> weightsList = new ArrayList<>();
            Map<String, String> node2Attributes = new HashMap<>();
            for (int i = 0; i < 5; i++) {  
                .shard(0)  
        assertThat(iter.size(), equalTo(3)); // three potential candidates for the shard  
            .shard(0)  
        assertThat(shardRouting2, notNullValue());  
            .shard(0)
                .build();
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);  
        clusterState = ClusterState.builder(clusterState)  
        shardsIterator = clusterState.routingTable()
        assertThat(shardIterators.size(), equalTo(1));
        assertThat(shardIterators.size(), equalTo(1));
            weightedRouting = new WeightedRouting("zone", weights);
            clusterState = ClusterState.builder(clusterState).nodes(nodes).build();  
            .build();
            Settings.EMPTY,  
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        clusterState = strategy.reroute(clusterState, "reroute");
                ShardRouting shardRouting2 = shardIterator.nextOrNull();
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node1"));
                )  
            );
            shuffler.shuffle(Collections.<ShardRouting>emptyList())
            String[] startedNodes = new String[2];
            // Make iterator call with new instance of WeightedRouting but same weights
    public void testAttributePreferenceRouting() {
            node1Attributes.put("zone", "zone1");
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
                shardIterator = clusterState.routingTable()
                .metadata(metadata)
            shardRouting = shardIterator.nextOrNull();
        shardIterator = new PlainShardIterator(new ShardId("test1", "_na_", 0), shuffler.shuffle(Collections.<ShardRouting>emptyList()));  
            weightedRouting = new WeightedRouting("zone", weights1);
        AllocationService strategy = createAllocationService(  
        ShardRouting shardRouting3 = shardIterator.nextOrNull();
                .shard(0)  
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
            AllocationService strategy = createAllocationService(settings.build());
            .index("test")
        assertThat(shardIterator.nextOrNull(), nullValue());  
            assertEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            for (int i = 0; i < 50; i++) {  
import static org.hamcrest.Matchers.notNullValue;
            // With fail open enabled set to false, we expect 2 shard routing, first one started, followed by initializing  
                .shard(0)
                        .add(newNode("node3", unmodifiableMap(node3Attributes)))  
    /**
            weights = Map.of("zone1", 3.0, "zone2", 2.0, "zone3", 0.0);
                        .localNodeId("node1")
                .nodes(
            WeightedRouting weightedRouting = new WeightedRouting("zone", weights1);
        ShardRouting shardRouting7 = shardIterator.nextOrNull();
                        .add(newNode("node1", unmodifiableMap(node1Attributes)))
        );  
 * under the License.  
        node2Attributes.put("zone", "zone2");  
        node1Attributes.put("zone", "zone1");  
                .metadata(metadata)
            )  
 * compatible open source license.
        assertThat(shardRouting5, notNullValue());
        }
        } finally {
        clusterState = ClusterState.builder(clusterState)
        assertThat(shardIterator.nextOrNull(), nullValue());
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));  
/*  
                        .add(newNode("node3", unmodifiableMap(node3Attributes)))
            node3Attributes.put("zone", "zone3");
                            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())  
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
                ShardRouting shardRouting2 = shardIterator.nextOrNull();  
                ShardRouting shardRouting;
    }  
        assertThat(shardRouting.currentNodeId(), equalTo("node2"));  
        GroupShardsIterator<ShardIterator> shardIterators = operationRouting.searchShards(
                DiscoveryNodes.builder()
        assertThat(shardIterator.nextOrNull(), nullValue());  
        // Modify the index to be a searchable snapshot index
        assertThat(shardRouting2, sameInstance(shardRouting3));
            shardIterator = clusterState.routingTable()
                .build();
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node2"));  
                .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
            assertNotEquals("node3", shardIterator.nextOrNull().currentNodeId());
        } finally {
     * according to assigned routing weights
    public void testActiveInitializingShardsWeightedItWithCustomSeed() {
            shardIterator = clusterState.routingTable()
                    )
            assertNotNull(shardRouting);
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            shardsIterator = clusterState.routingTable()  
 * the Apache License, Version 2.0 (the "License"); you may
            .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always");
            Map<String, Double> weights1 = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 0.0);
        assertThat(shardRouting10, sameInstance(shardRouting6));
        );
            .shard(0)
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
                .index("test")
            Map<String, Double> weights1 = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 0.0);  
                        .add(newNode("node2", unmodifiableMap(node2Attributes)))
        ShardIterator shardIterator = clusterState.routingTable()  
            .build();
            clusterState,
            node1Attributes.put("zone", "zone1");  
     */
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            assertEquals(startedNodes[0], shardIterator.nextOrNull().currentNodeId());  
                        .add(newNode("node1", unmodifiableMap(node1Attributes)))
        clusterState = strategy.reroute(clusterState, "reroute");  
        if (randomBoolean()) {  
        shardsIterator = clusterState.routingTable()  
            shardIterator = clusterState.routingTable()
        shardsIterator = clusterState.routingTable()  
import org.opensearch.core.index.shard.ShardId;
    public void testWeightedRoutingWithInitializingShards() {
            .build();
            )
            Settings.EMPTY,
                    .shard(0)  
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));  
            .metadata(metadata)
        assertThat(shardIterator.nextOrNull(), nullValue());  
            .shard(0)  
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_shards:0|");  
            Map<String, Double> weights3 = Map.of("zone1", 0.0, "zone2", 1.0, "zone3", 1.0);  
            null
        ShardRouting routing = iter.nextOrNull();
        assertThat(shardRouting3, not(sameInstance(shardRouting1)));
            assertEquals(2, shardIterator.size());  
                .build();
        if ("node1".equals(firstNodeId)) {
            .index("test")  
            // Making the second shard as active
     */  
        } finally {
    public void testWeightedRoutingWithDifferentWeights() {
        try {
import static org.hamcrest.Matchers.anyOf;
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                .build();  
        assertThat(shardsIterator.size(), equalTo(1));
                .metadata(metadata)
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        Metadata metadata = Metadata.builder()
                    .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, 1);
                .index("test")  
                .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
                if (shard.initializing()) {
        assertFalse(routing.primary());
            node2Attributes.put("zone", "zone2");
        ShardIterator iter = shardIterators.iterator().next();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            }
                .build();
        routing = iter.nextOrNull();
            .shard(0)
            assertFalse(Arrays.asList("node3").contains(shardRouting.currentNodeId()));
        ShardRouting shardRouting8 = shardIterator.nextOrNull();  
                            .put(settings(Version.CURRENT).build())
                .nodes(  
        assertThat(shardIterator.size(), equalTo(2));  
                        .add(newNode("node2", unmodifiableMap(node2Attributes)))  
            shardIterator = clusterState.routingTable()  
import static org.hamcrest.Matchers.nullValue;  
                .shard(0)
        assertThat(shardsIterator.size(), equalTo(2));
        assertThat(shardIterator.remaining(), equalTo(1));  
            assertNotNull(shardRouting);
        } finally {
                .index("test")
            assertNotEquals("node3", shardIterator.nextOrNull().currentNodeId());
                indexShardRoutingTable.getActiveShardsByWeight().get(new IndexShardRoutingTable.WeightedRoutingKey(weightedRouting))
        ShardIterator shardIterator = routingTable.index("test1").shard(0).shardsIt(0);
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node2"));
                .shard(0)
        assertThat(shardIterator.nextOrNull(), nullValue());
            Settings.builder()
            shardRouting = shardIterator.nextOrNull();
        GroupShardsIterator<ShardIterator> shardIterators = operationRouting.searchShards(
                WeightedRouting weightedRouting = new WeightedRouting("zone", weightsList.get(i));
        }
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));
            assertEquals(2, shardIterator.size());
                .routingTable(routingTable)
 */  
        assertThat(shardIterator.remaining(), equalTo(0));
            // With fail open enabled set to true, we expect 3 shard routing, first one started, followed by initializing, third one started
            // with zero weight
                    .shard(0)  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            Settings.EMPTY,
        assertThat(shardRouting1, notNullValue());  
        Map<String, String> node1Attributes = new HashMap<>();
            .shard(0)
            ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);
                .put("cluster.routing.allocation.awareness.attributes", "zone");  
        assertThat(shardIterator.remaining(), equalTo(0));
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node1"));  
            .build();  
            node2Attributes.put("zone", "zone2");
        } finally {  
                shardRouting = shardIterator.nextOrNull();
 * GitHub history for details.
            Map<String, String> node1Attributes = new HashMap<>();
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
        assertThat(shardIterator.nextOrNull(), nullValue());
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .index("test")
            assertNotNull(shardRouting);
        TestThreadPool threadPool = null;
            .metadata(metadata)
                shardIterator = clusterState.routingTable()  
        assertThat(shardIterator.nextOrNull(), nullValue());
            terminate(threadPool);  
                .index("test")
                        .add(newNode("node3", unmodifiableMap(node3Attributes)))
        ShardRouting shardRouting2 = shardIterator.nextOrNull();
                DiscoveryNodes.builder()
        routing = iter.nextOrNull();  
            terminate(threadPool);  
import org.opensearch.cluster.node.DiscoveryNodes;
                )  
                ShardRouting shardRouting1 = shardIterator.nextOrNull();
        assertThat(shardIterators.size(), equalTo(2)); // two potential shards
    }
            .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        // When replicas haven't initialized, it comes back with the primary first, then initializing replicas  
        clusterState = ClusterState.builder(clusterState)
                        .add(newNode("node1", unmodifiableMap(node1Attributes)))
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
            .build();  
        AllocationService strategy = createAllocationService(  
import java.util.Collections;
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node1"));
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")).localNodeId("node1"))
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .shard(0)
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
import org.opensearch.cluster.routing.allocation.AllocationService;
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
        );
            for (int i = 0; i < weightsList.size(); i++) {  
public class RoutingIteratorTests extends OpenSearchAllocationTestCase {  
        routing = iter.nextOrNull();
            .routingTable(routingTable)
                        .add(newNode("node2", unmodifiableMap(node2Attributes)))  
        );
            Map<String, Double> weights1 = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 0.0);  
            new String[] { "test" },  
            .build();
    }
            Settings.Builder settings = Settings.builder()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            node2Attributes.put("zone", "zone2");
        routing = iter.nextOrNull();
            RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                .index("test")  
            assertNotEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());
        assertThat(shardIterators.size(), equalTo(2)); // two potential shards
                    .add(newNode("node3", Collections.singleton(DiscoveryNodeRole.WARM_ROLE)))
        shardsIterator = clusterState.routingTable()
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        ShardRouting shardRouting6 = shardIterator.nextOrNull();
            clusterState = ClusterState.builder(clusterState)
            }  
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);  
            Map<String, String> node1Attributes = new HashMap<>();
        assertThat(shardIterators.iterator().next().shardId().id(), equalTo(0));
        assertThat(shardRouting2, not(sameInstance(shardRouting4)));  
        assertThat(shardIterator.remaining(), equalTo(0));  
                .metadata(metadata)  
        assertThat(shardIterator.nextOrNull(), nullValue());  
        shardRouting = shardIterator.nextOrNull();  
        shardIterator = routingTable.index("test1").shard(0).shardsIt(1);
                    DiscoveryNodes.builder()
        assertThat(shardRouting2, not(sameInstance(shardRouting1)));
    public void testEmptyIterator() {
        assertThat(shardRouting, notNullValue());
            assertNotEquals("node3", shardIterator.nextOrNull().currentNodeId());
            node3Attributes.put("zone", "zone3");
        assertThat(shardIterators.iterator().next().shardId().id(), equalTo(0));
        assertThat(shardRouting5, sameInstance(shardRouting1));
        ShardIterator shardIterator = routingTable.index("test1").shard(0).shardsIt(0);
import java.util.List;
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);  
            assertFalse(Arrays.asList("node3").contains(shardRouting.currentNodeId()));
            Map<String, String> node2Attributes = new HashMap<>();  
        assertThat(shardRouting9, notNullValue());  
            RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        shardRouting = shardIterator.nextOrNull();
            terminate(threadPool);
        assertNull(routing); // No other candidate apart from primary
            )  
            shardIterator = clusterState.routingTable()
import org.opensearch.cluster.routing.ShardRouting;
            );
            // only initializing shard has weight with fail open true
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));  
            assertNotNull(
        clusterState = strategy.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node2"));
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
            .onlyNodeSelectorActiveInitializingShardsIt("fred", clusterState.nodes());  
            shardIterator = clusterState.routingTable()  
            assertEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());  
import org.opensearch.cluster.metadata.IndexMetadata;
        assertNotNull(routing);
                .index("test")  
        assertThat(shardRouting6, not(sameInstance(shardRouting5)));
        TestThreadPool threadPool = new TestThreadPool("testActiveInitializingShardsWeightedItWithCustomSeed");  
        assertThat(shardIterator.nextOrNull(), nullValue());  
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_replica");  
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
            assertEquals(1, shardIterator.size());
 */
        assertThat(shardIterator.nextOrNull(), nullValue());  
        ShardRouting shardRouting1 = shardIterator.nextOrNull();
                ShardRouting shardRouting3 = shardIterator.nextOrNull();  
                .build();  
            Metadata metadata = Metadata.builder()  
        } finally {  
                assertNotEquals(shardRouting1.currentNodeId(), shardRouting2.currentNodeId());  
import org.opensearch.cluster.service.ClusterService;
            .index("test")
        TestThreadPool threadPool = null;
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        clusterState = strategy.reroute(clusterState, "reroute"); // Move primaries to initializing  
        assertThat(shardIterators.iterator().next().shardId().id(), equalTo(0));  
            assertEquals(2, shardIterator.size());  
        assertThat(shardIterator.remaining(), equalTo(0));  
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, 1);
        assertThat(shardsIterator.size(), equalTo(1));  
            Map<String, String> node2Attributes = new HashMap<>();
            clusterState = ClusterState.builder(clusterState)
            assertEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());
            );
            .shard(0)
        assertThat(shardRouting2, not(sameInstance(shardRouting1)));
        assertThat(shardRouting1, notNullValue());
                .routingTable(routingTable)
        ShardRouting shardRouting1 = shardIterator.nextOrNull();
            shardRouting = shardIterator.nextOrNull();  
                requestCount.put(shardRouting.currentNodeId(), requestCount.getOrDefault(shardRouting.currentNodeId(), 0) + 1);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            Metadata metadata = Metadata.builder()  
                .shard(0)
 * KIND, either express or implied.  See the License for the
            shardIterator = clusterState.routingTable()
            node3Attributes.put("zone", "zone3");
        assertThat(shardIterator.size(), equalTo(3));  
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(shardIterator.remaining(), equalTo(0));  
                    initializingZone = nodes.resolveNode(shard.currentNodeId()).getAttributes().get("zone");
                .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        shardsIterator = clusterState.routingTable()
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                .build();  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            clusterState,
import org.opensearch.cluster.routing.RotationShardShuffler;
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
            node1Attributes.put("zone", "zone1");  
            "_shards:0"
                .index("test")
            Map<String, Double> weights = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 0.0);
            Map<String, String> node2Attributes = new HashMap<>();
        routing = iter.nextOrNull();
            .shard(0)  
        assertThat(shardIterator.remaining(), equalTo(0));
        ShardRouting shardRouting1 = shardIterator.nextOrNull();
            .build();
            assertEquals("node3", shardIterator.nextOrNull().currentNodeId());  
                .shard(0)  
            assertEquals(2, shardIterator.size());  
            ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);  
        assertThat(shardIterator.nextOrNull(), nullValue());
                .shard(0)
            ShardRouting shardRouting1 = shardIterator.nextOrNull();
                .put("cluster.routing.allocation.awareness.attributes", "zone");  
                .routingTable(routingTable)
import org.opensearch.cluster.node.DiscoveryNodeRole;
            AllocationService strategy = createAllocationService(settings.build());
        assertThat(shardIterator.remaining(), equalTo(0));
        ShardRouting shardRouting3 = shardIterator.nextOrNull();
            .metadata(metadata)  
        assertThat(shardIterator.size(), equalTo(2));
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build();  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
        assertFalse(routing.primary());
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
        ShardIterator shardIterator = new PlainShardIterator(  
            .build();
        assertThat(shardIterator.remaining(), equalTo(0));
            assertEquals("node3", shardIterator.nextOrNull().currentNodeId());
            null,
            assertEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());
                .build();
            int i = 0;  
            for (ShardRouting shard : clusterState.routingTable().allShards()) {
            ShardIterator shardIterator = clusterState.routingTable()  
                        .localNodeId("node1")
        assertThat(shardRouting1, notNullValue());
        ShardRouting shardRouting2 = shardIterator.nextOrNull();
            .routingTable(routingTable)  
        assertTrue(routing.initializing());  
            Map<String, String> node2Attributes = new HashMap<>();
        assertThat(shardIterators.size(), equalTo(2)); // two potential shards
                    .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
            .build();
            .build();
        assertThat(it.shardId().id(), equalTo(0));
                IndexMetadata.builder("test")
                } else {  
        assertThat(shardIterators.iterator().next().nextOrNull().currentNodeId(), not(equalTo(firstRoundNodeId)));
        OperationRouting operationRouting = new OperationRouting(  
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            node3Attributes.put("zone", "zone3");  
import org.opensearch.cluster.routing.WeightedRouting;
                )  
            .shard(0)
        clusterState = strategy.reroute(clusterState, "reroute");  
                .index("test")  
    }  
                        .localNodeId("node1")
                    .localNodeId("node1")
import org.opensearch.index.IndexModule;
                .add(newNode("node1", unmodifiableMap(node1Attributes)))
            // only initializing shard has weight with fail open false  
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node1"));  
 */  
            null,
import org.opensearch.cluster.routing.OperationRouting;
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node2"));  
import java.util.ArrayList;  
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build();
                .build();
            assertEquals(3, shardIterator.size());
        assertFalse(routing.primary());  
                .routingTable(routingTable)
            Map<String, String> node3Attributes = new HashMap<>();  
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_replica_first");  
        assertThat(shardRouting1, notNullValue());
    }  
        assertThat(shardIterators.iterator().next().shardId().id(), equalTo(0));
        Metadata metadata = Metadata.builder()  
        Metadata metadata = Metadata.builder()  
            .index("test")
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
        assertTrue(routing.initializing());
                .index("test")
            node2Attributes.put("zone", "zone2");
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        );  
            .index("test")
                .add(newNode("node2", unmodifiableMap(node2Attributes)))
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).localNodeId("node1"))
            RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
                    startedNodes[i] = shard.currentNodeId();
                    .index("test")
        assertNotNull(routing);
            node1Attributes.put("zone", "zone1");  
        assertThat(shardRouting1, not(sameInstance(shardRouting3)));
        assertTrue(routing.primary());
            Metadata metadata = Metadata.builder()  
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_shards:0|_prefer_nodes:node1,node2");  
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            assertNotEquals("node3", shardIterator.nextOrNull().currentNodeId());  
    public void testIterator1() {
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node1"));
                        .add(newNode("node1", unmodifiableMap(node1Attributes)))
            Map<String, String> node1Attributes = new HashMap<>();
    }
    }  
            assertEquals("node3", shardIterator.nextOrNull().currentNodeId());  
        assertThat(shardRouting, notNullValue());
                    .shard(0)
        assertTrue(routing.primary()); // Default preference is primary
        assertThat(shardRouting, notNullValue());
        AllocationService strategy = createAllocationService(  
                .index("test")
 * software distributed under the License is distributed on an
                    .index("test")
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        routing = iter.nextOrNull();  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            settings.put("cluster.routing.allocation.awareness.attributes", " rack_id, zone  ");
 * this file be licensed under the Apache-2.0 license or a
            Map<String, String> node3Attributes = new HashMap<>();  
                .add(newNode("node3", unmodifiableMap(node3Attributes)))  
            )
            weightedRouting = new WeightedRouting("zone", weights2);
            weightsList.add(weights3);
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            assertEquals(2, shardIterator.size());  
    }
        assertThat(shardIterator.nextOrNull(), nullValue());
                .nodes(  
import org.opensearch.cluster.metadata.Metadata;  
            .index("test")
            .onlyNodeSelectorActiveInitializingShardsIt("disk:ebs", clusterState.nodes());
            WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            weightsList.add(weights4);
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));  
        assertFalse(routing.primary());
            Map<String, String> node3Attributes = new HashMap<>();  
        assertThat(shardRouting1, sameInstance(shardRouting4));
            weights = Map.of(initializingZone, 1.0, startedZones[0], 0.0, startedZones[1], 0.0);
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
        OperationRouting operationRouting = new OperationRouting(  
            }
            .build();
     * Test to validate that simple weighted shard routing with seed return same shard routing on each call  
                .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        assertThat(shardRouting9, sameInstance(shardRouting5));
                .onlyNodeSelectorActiveInitializingShardsIt("welma", clusterState.nodes());  
        assertThat(shardRouting6, sameInstance(shardRouting2));  
            ShardIterator shardIterator = clusterState.routingTable()
        assertFalse(routing.primary());
    /**
        // When replicas haven't initialized, it comes back with the primary first, then initializing replicas  
import static org.hamcrest.Matchers.sameInstance;
            .build();  
        shardIterator = clusterState.routingTable()
        TestThreadPool threadPool = null;
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
import org.opensearch.test.ClusterServiceUtils;  
        assertThat(iter.size(), equalTo(2)); // two potential replicas for the shard  
            Map<String, Integer> requestCount = new HashMap<>();
            new String[] { "test" },  
import static org.hamcrest.Matchers.not;
            Map<String, String> node2Attributes = new HashMap<>();
            shardRouting = shardIterator.nextOrNull();
        assertNotNull(routing);
        }
            ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);  
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node1"));
        assertThat(shardIterator.nextOrNull(), notNullValue());
        ShardRouting shardRouting5 = shardIterator.nextOrNull();  
        assertThat(shardRouting10, not(sameInstance(shardRouting9)));  
        assertThat(shardIterator.nextOrNull(), nullValue());
        Settings.Builder settings = Settings.builder()  
                    .settings(  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            node2Attributes.put("zone", "zone2");
            assertEquals(3, shardIterator.size());
                .routingTable(routingTable)
                .build();
import org.opensearch.cluster.routing.GroupShardsIterator;  
    /**
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            .onlyNodeSelectorActiveInitializingShardsIt("bar*", clusterState.nodes());
        }
                .put("cluster.routing.allocation.awareness.attributes", "zone");  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(2))  
 * not use this file except in compliance with the License.
        assertThat(shardRouting10, notNullValue());
            Map<String, String> node1Attributes = new HashMap<>();
        assertThat(shardIterator.nextOrNull(), nullValue());
                    .add(newNode("barney", "node2", singletonMap("disk", "ephemeral")))
        GroupShardsIterator<ShardIterator> shardIterators = operationRouting.searchShards(
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
                .index("test")  
            node1Attributes.put("zone", "zone1");  
        shardIterator = routingTable.index("test1").shard(0).shardsIt(3);
                .index("test")
    }  
                )
                ShardIterator shardIterator = clusterState.routingTable()
                .shard(0)
import org.opensearch.cluster.routing.RoutingTable;
        node2Attributes.put("rack_id", "rack_2");
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
                    .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
                .metadata(metadata)
        TestThreadPool threadPool = null;
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
            .put(
            shardIterator = clusterState.routingTable()
 * Licensed to Elasticsearch under one or more contributor  
            .nodes(  
            Settings.Builder settings = Settings.builder()  
        clusterState = ClusterState.builder(clusterState)
                .build();
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            weights = Map.of(initializingZone, 0.0, startedZones[0], 1.0, startedZones[1], 0.0);
                indexShardRoutingTable.getActiveShardsByWeight().get(new IndexShardRoutingTable.WeightedRoutingKey(weightedRouting))  
 * SPDX-License-Identifier: Apache-2.0
        try {  
            DiscoveryNodes nodes = DiscoveryNodes.builder()  
        assertThat(shardRouting8, notNullValue());
        shardIterator = routingTable.index("test1").shard(0).shardsIt(4);  
        ShardsIterator shardsIterator = clusterState.routingTable()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            assertNotNull(shardRouting);  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        Metadata metadata = Metadata.builder()
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            Map<String, Double> weights = Map.of("zone1", 3.0, "zone2", 2.0, "zone3", 0.0);
