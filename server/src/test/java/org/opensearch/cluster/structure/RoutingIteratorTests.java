            assertEquals(startedNodes[1], shardIterator.nextOrNull().currentNodeId());
        assertThat(shardIterator.remaining(), equalTo(0));
package org.opensearch.cluster.structure;
     */
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, 1);
/*
        clusterState = strategy.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
            clusterState = ClusterState.builder(clusterState)
import java.util.Collections;
        routing = iter.nextOrNull();
        ShardRouting shardRouting6 = shardIterator.nextOrNull();
        assertThat(shardIterator.remaining(), equalTo(0));
        assertThat(shardRouting1, notNullValue());
            .shard(0)
        assertThat(shardRouting1, not(sameInstance(shardRouting3)));
import org.opensearch.cluster.routing.RotationShardShuffler;
                .metadata(metadata)
            .onlyNodeSelectorActiveInitializingShardsIt(new String[] { "disk:*", "invalid_name" }, clusterState.nodes());
            AllocationService strategy = createAllocationService(settings.build());
        assertThat(shardIterator.nextOrNull(), nullValue());
            Map<String, Double> weights3 = Map.of("zone1", 0.0, "zone2", 1.0, "zone3", 1.0);
            node1Attributes.put("zone", "zone1");
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
        shardIterator = new PlainShardIterator(new ShardId("test1", "_na_", 0), shuffler.shuffle(Collections.<ShardRouting>emptyList()));
        Settings.Builder settings = Settings.builder()
            assertEquals("node3", shardIterator.nextOrNull().currentNodeId());
import org.opensearch.cluster.ClusterState;
            clusterState = ClusterState.builder(clusterState)
                .shard(0)
            }
            assertEquals(3, shardIterator.size());
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            node3Attributes.put("zone", "zone3");
        try {
            ShardIterator shardIterator = clusterState.routingTable()
                .localNodeId("node1")
    }
                    .index("test")
                        .add(newNode("node3", unmodifiableMap(node3Attributes)))
    }
        assertThat(iter.size(), equalTo(1)); // one potential candidate (primary) for the shard
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_shards:0");
            Map<String, String> node3Attributes = new HashMap<>();
            .build();
                .put("cluster.routing.allocation.awareness.attributes", "zone");
            ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);
        assertThat(shardIterators.size(), equalTo(1));
        assertThat(shardRouting9, notNullValue());
 */
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
        assertFalse(routing.primary());
    }
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        assertThat(shardRouting1, notNullValue());
            .metadata(metadata)
            .routingTable(routingTable)
        }
            .onlyNodeSelectorActiveInitializingShardsIt(new String[] { "disk:*", "disk:*" }, clusterState.nodes());
            .build();
        assertThat(shardIterator.nextOrNull(), nullValue());
                WeightedRouting weightedRouting = new WeightedRouting("zone", weightsList.get(i));
            node3Attributes.put("zone", "zone3");
            weights = Map.of("zone1", 3.0, "zone2", 2.0, "zone3", 0.0);
            assertEquals(startedNodes[0], shardIterator.nextOrNull().currentNodeId());
        } finally {
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_replica_first");
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            );
 * KIND, either express or implied.  See the License for the
     * Test to validate that shard routing state is maintained across requests
            assertEquals("node3", shardIterator.nextOrNull().currentNodeId());
import static java.util.Collections.unmodifiableMap;
        }
            assertEquals(startedNodes[0], shardIterator.nextOrNull().currentNodeId());
            AllocationService strategy = createAllocationService(settings.build());
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));
            assertEquals(2, shardIterator.size());
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node1"));
            Metadata metadata = Metadata.builder()
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
    }
                .add(newNode("node2", unmodifiableMap(node2Attributes)))
        GroupShardsIterator<ShardIterator> shardIterators = operationRouting.searchShards(
        Metadata metadata = Metadata.builder()
                .nodes(
            node1Attributes.put("zone", "zone1");
                    DiscoveryNodes.builder()
import static org.hamcrest.Matchers.notNullValue;
        assertThat(shardIterator.remaining(), equalTo(0));
        assertThat(shardRouting.currentNodeId(), equalTo("node1"));
import org.opensearch.cluster.routing.ShardShuffler;
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * ownership. Elasticsearch licenses this file to you under
 * specific language governing permissions and limitations
            .shard(0)
                    .add(newNode("node1", Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)))
        shardIterator = new PlainShardIterator(new ShardId("test1", "_na_", 0), shuffler.shuffle(Collections.<ShardRouting>emptyList()));
                    .localNodeId("node1")
                .build();
            .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            assertEquals(startedNodes[0], shardIterator.nextOrNull().currentNodeId());
        // When replicas haven't initialized, it comes back with the primary first, then initializing replicas
                    .add(newNode("node2", Collections.singleton(DiscoveryNodeRole.WARM_ROLE)))
 *
        clusterState = ClusterState.builder(clusterState)
            .shard(0)
        assertThat(shardRouting3, notNullValue());
        assertThat(shardIterator.remaining(), equalTo(0));
            RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(shardIterator.remaining(), equalTo(0));
            assertEquals(2, shardIterator.size());
            assertEquals(1, shardIterator.size());
        assertThat(shardIterator.remaining(), equalTo(0));
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    initializingZone = nodes.resolveNode(shard.currentNodeId()).getAttributes().get("zone");
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
                ShardRouting shardRouting2 = shardIterator.nextOrNull();
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
        assertThat(shardRouting6, sameInstance(shardRouting2));
        assertThat(firstNodeId, anyOf(equalTo("node1"), equalTo("node2")));
        assertThat(shardIterator.remaining(), equalTo(0));
                .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
            .onlyNodeSelectorActiveInitializingShardsIt("bar*", clusterState.nodes());
            ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);
        assertFalse(routing.primary());
            settings.put("cluster.routing.allocation.awareness.attributes", " rack_id, zone  ");
import java.util.Map;
        );
            assertEquals(2, requestCount.get("node2").intValue());
import org.opensearch.cluster.service.ClusterService;
        assertTrue(routing.started());
        Metadata metadata = Metadata.builder()
            .index("test")
            Metadata metadata = Metadata.builder()
    public void testRandomRouting() {
        assertNotNull(routing);
                .routingTable(routingTable)
import static org.hamcrest.Matchers.not;
        routing = iter.nextOrNull();
                .index("test")
            node2Attributes.put("zone", "zone2");
                .metadata(metadata)
                )
        ShardRouting routing = iter.nextOrNull();
        ShardRouting shardRouting1 = shardIterator.nextOrNull();
            null,
                .build();
            .preferAttributesActiveInitializingShardsIt(Arrays.asList("rack_id"), clusterState.nodes());
            Settings.Builder settings = Settings.builder()
        String firstRoundNodeId = shardIterators.iterator().next().nextOrNull().currentNodeId();
            Map<String, Integer> requestCount = new HashMap<>();
        assertThat(iter.size(), equalTo(3)); // three potential candidates for the shard
        AllocationService strategy = createAllocationService(settings.build());
        }
                    .add(newNode("node2", unmodifiableMap(node2Attributes)))
            terminate(threadPool);
                .add(newNode("node1", unmodifiableMap(node1Attributes)))
        Metadata metadata = Metadata.builder()
            RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
import org.opensearch.Version;
                .index("test")
                .build();
        TestThreadPool threadPool = null;
        assertThat(shardRouting9, sameInstance(shardRouting5));
 * under the License.
            shardRouting = shardIterator.nextOrNull();
        assertNotNull(routing);
        }
            Map<String, String> node3Attributes = new HashMap<>();
                .shard(0)
                    .shard(0)
            ShardRouting shardRouting;
                        .add(newNode("node2", unmodifiableMap(node2Attributes)))
            assertEquals("node3", shardIterator.nextOrNull().currentNodeId());
                    .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
        assertThat(shardRouting1, sameInstance(shardRouting4));
            .onlyNodeSelectorActiveInitializingShardsIt("fred", clusterState.nodes());
            .build();
            shardRouting = shardIterator.nextOrNull();
            Map<String, String> node3Attributes = new HashMap<>();
        assertThat(shardIterators.iterator().next().nextOrNull().currentNodeId(), equalTo("node1"));
            assertNotEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());
 *     http://www.apache.org/licenses/LICENSE-2.0
                shardIterator = clusterState.routingTable()
                        .add(newNode("node3", unmodifiableMap(node3Attributes)))
            assertEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());
        try {
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_shards:1");
                        .add(newNode("node1", unmodifiableMap(node1Attributes)))
        assertThat(shardIterators.iterator().next().shardId().id(), equalTo(1));
        assertThat(shardRouting2, notNullValue());
            new String[] { "test" },
    public void testWeightedRoutingWithDifferentWeights() {
            AllocationService strategy = createAllocationService(settings.build());
            }
            Settings.Builder settings = Settings.builder()
        clusterState = strategy.reroute(clusterState, "reroute");
                shardRouting = shardIterator.nextOrNull();
            .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always");
                    .index("test")
                IndexMetadata.builder("test")
        );
        assertThat(shardRouting10, sameInstance(shardRouting6));
        ShardRouting shardRouting2 = shardIterator.nextOrNull();
            int i = 0;
            assertEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());
     */
            ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);
                .build();
                        .add(newNode("node1", unmodifiableMap(node1Attributes)))
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                DiscoveryNodes.builder()
        ShardRouting shardRouting2 = shardIterator.nextOrNull();
            shardIterator = clusterState.routingTable()
        } else {
            Map<String, Double> weights = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 0.0);
import java.util.List;
            weightsList.add(weights2);
        assertThat(shardIterators.size(), equalTo(1));
                ShardRouting shardRouting2 = shardIterator.nextOrNull();
            node3Attributes.put("zone", "zone3");
            RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(shardIterator.nextOrNull(), nullValue());
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            .index("test")
                )
        shardIterator = routingTable.index("test1").shard(0).shardsIt(2);
 *
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node2"));
        assertThat(shardIterator.remaining(), equalTo(0));
            clusterState,
            assertFalse(Arrays.asList("node3").contains(shardRouting.currentNodeId()));
            );
                .shard(0)
        routing = iter.nextOrNull();
            .routingTable(routingTable)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(2))
import org.opensearch.common.settings.Settings;
            weights = Map.of(initializingZone, 1.0, startedZones[0], 0.0, startedZones[1], 0.0);
    }
            assertEquals(1, shardIterator.size());
import java.util.Iterator;
                .onlyNodeSelectorActiveInitializingShardsIt("welma", clusterState.nodes());
            RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                .index("test")
        try {
        Iterator<ShardIterator> iterator = shardIterators.iterator();
        assertThat(shardIterators.iterator().next().shardId().id(), equalTo(0));
                .build();
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
     * according to assigned routing weights
        assertThat(iter.size(), equalTo(2)); // two potential replicas for the shard
            weights = Map.of("zone1", -1.0, "zone2", 0.0, "zone3", 1.0);
                .shard(0)
            RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        AllocationService strategy = createAllocationService(
                .index("test")
    public void testReplicaShardPreferenceIters() {
                        .localNodeId("node1")
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        ShardIterator shardIterator = new PlainShardIterator(
            Map<String, String> node2Attributes = new HashMap<>();
        assertThat(shardIterators.size(), equalTo(1));
            assertNotEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());
        ShardRouting shardRouting3 = shardIterator.nextOrNull();
                .shard(0)
            .build();
        routing = iter.nextOrNull();
import static java.util.Collections.singletonMap;
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
    public void testEmptyIterator() {
            WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            shardIterator = clusterState.routingTable()
                .index("test")
                ShardRouting shardRouting3 = shardIterator.nextOrNull();
    public void testWeightedRoutingInMemoryStore() {
 */
    }
                .build();
    }
            Map<String, String> node3Attributes = new HashMap<>();
            settings.putList("cluster.routing.allocation.awareness.attributes", "rack_id", "zone");
                .nodes(
            new ShardId("test1", "_na_", 0),
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
        shardIterator = routingTable.index("test1").shard(0).shardsIt(4);
                    .numberOfShards(2)
        ShardRouting shardRouting7 = shardIterator.nextOrNull();
                .metadata(metadata)
                )
                .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        clusterState = strategy.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
            shardRouting = shardIterator.nextOrNull();
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(shardIterator.remaining(), equalTo(0));
        assertFalse(routing.primary());
        Metadata metadata = Metadata.builder()
import org.opensearch.cluster.routing.WeightedRouting;
                .put("cluster.routing.allocation.awareness.attributes", "zone");
        assertThat(shardIterator.nextOrNull(), nullValue());
            terminate(threadPool);
            .onlyNodeSelectorActiveInitializingShardsIt("dis*:eph*", clusterState.nodes());
            assertNotNull(shardRouting);
        iter = shardIterators.iterator().next();
                        Settings.builder()
            Map<String, String> node1Attributes = new HashMap<>();
import org.opensearch.cluster.ClusterName;
    public void testActiveInitializingShardsWeightedItWithCustomSeed() {
        }
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
            .routingTable(routingTable)
            Map<String, String> node1Attributes = new HashMap<>();
        ShardRouting shardRouting = shardIterator.nextOrNull();
        assertNotNull(routing);
        if ("node1".equals(firstNodeId)) {
            .build();
        ShardIterator iter = shardIterators.iterator().next();
        ShardRouting shardRouting3 = shardIterator.nextOrNull();
            shuffler.shuffle(Collections.<ShardRouting>emptyList())
        shardIterator = new PlainShardIterator(new ShardId("test1", "_na_", 0), shuffler.shuffle(Collections.<ShardRouting>emptyList()));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
    }
                .build();
            shardRouting = shardIterator.nextOrNull();
    public void testNodeSelectorRouting() {
            Settings.Builder settings = Settings.builder()
                    .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
                assertEquals(3, shardIterator.size());
        assertNotNull(routing);
                .metadata(metadata)
            AllocationService strategy = createAllocationService(settings.build());
            assertEquals(3, shardIterator.size());
            .index("test")
        final String firstNodeId = it.nextOrNull().currentNodeId();
            assertEquals(3, requestCount.get("node1").intValue());
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
                assertNotNull(shardRouting);
                .index("test")
            clusterState = strategy.reroute(clusterState, "reroute");
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            ShardIterator shardIterator = clusterState.routingTable()
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
    /**
import org.opensearch.test.ClusterServiceUtils;
        assertThat(shardsIterator.size(), equalTo(1));
            .build();
            // Making the second shard as active
            Map<String, Double> weights = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 0.0);
            .index("test")
            weightedRouting = new WeightedRouting("zone", weights);
            ShardIterator shardIterator = clusterState.routingTable()
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                .build();
                    .shard(0)
        assertThat(shardRouting2, not(sameInstance(shardRouting1)));
        GroupShardsIterator<ShardIterator> shardIterators = operationRouting.searchShards(
            .shard(0)
            clusterState = startRandomInitializingShard(clusterState, strategy);
            assertEquals(3, shardIterator.size());
        assertThat(shardIterator.nextOrNull(), nullValue());
                        .localNodeId("node1")
        assertTrue(routing.primary()); // replicas haven't initialized yet, so primary is first
        Metadata metadata = Metadata.builder()
        ShardIterator iter = shardIterators.iterator().next();
            shardIterator = clusterState.routingTable()
        assertThat(shardIterator.remaining(), equalTo(1));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
                            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
        assertThat(shardRouting8, not(sameInstance(shardRouting7)));
import org.opensearch.common.settings.ClusterSettings;
        assertThat(shardIterator.nextOrNull(), nullValue());
        ShardRouting shardRouting9 = shardIterator.nextOrNull();
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
            .metadata(metadata)
 * GitHub history for details.
                    .shard(0)
import org.opensearch.cluster.node.DiscoveryNodes;
        ShardIterator shardIterator = routingTable.index("test1").shard(0).shardsIt(0);
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            // With fail open enabled set to false, we expect 2 shard routing, first one started, followed by initializing
        assertFalse(routing.primary());
    public void testIterator1() {
            assertEquals(3, shardIterator.size());
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node1"));
        OperationRouting operationRouting = new OperationRouting(
            .shard(0)
            .routingTable(routingTable)
        ShardIterator shardIterator = routingTable.index("test1").shard(0).shardsIt(0);
        assertThat(shardRouting1, notNullValue());
            DiscoveryNodes nodes = DiscoveryNodes.builder()
            assertNotEquals("node3", shardIterator.nextOrNull().currentNodeId());
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build();
        assertThat(shardIterator.remaining(), equalTo(0));
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_replica");
            .index("test")
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node1"));
        assertThat(shardsIterator.size(), equalTo(2));
            assertEquals(2, shardIterator.size());
        shardRouting = shardIterator.nextOrNull();
        assertThat(shardIterator.nextOrNull(), nullValue());
            shardIterator = clusterState.routingTable()
            assertNotEquals("node3", shardIterator.nextOrNull().currentNodeId());
import java.util.HashMap;
            Map<String, Double> weights4 = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 0.0);
                    .localNodeId("node1")
        assertFalse(routing.primary());
    }
        OperationRouting operationRouting = new OperationRouting(
                    initializingNode = shard.currentNodeId();
 * SPDX-License-Identifier: Apache-2.0
        assertThat(shardIterator.nextOrNull(), nullValue());
        if (randomBoolean()) {
                .shard(0)
        } finally {
        try {
                shardIterator = clusterState.routingTable()
            .index("test")
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).localNodeId("node1"))
            ShardRouting shardRouting1 = shardIterator.nextOrNull();
            )
                .shard(0)
            node3Attributes.put("zone", "zone3");
                        .add(newNode("node2", unmodifiableMap(node2Attributes)))
        AllocationService strategy = createAllocationService(
        assertThat(shardIterators.iterator().next().shardId().id(), equalTo(0));
            String initializingNode = null;
                .build();
            weights = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 1.0);
            String[] startedNodes = new String[2];
import org.opensearch.core.index.shard.ShardId;
            clusterState,
        clusterState = strategy.reroute(clusterState, "reroute");
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
        shardsIterator = clusterState.routingTable()
            ShardIterator shardIterator = clusterState.routingTable()
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
                .build();
                assertEquals(shardRouting1.currentNodeId(), shardRouting3.currentNodeId());
    }
import org.opensearch.cluster.routing.ShardsIterator;
                ShardRouting shardRouting;
        assertThat(shardIterator.nextOrNull(), nullValue());
                .routingTable(routingTable)
 * Unless required by applicable law or agreed to in writing,
            // only initializing shard has weight with fail open false
                .build();
        assertThat(iter.size(), equalTo(3)); // three potential candidates for the shard
            node1Attributes.put("zone", "zone1");
                .nodes(
        TestThreadPool threadPool = null;
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(shardRouting1, sameInstance(shardRouting3));
        assertThat(shardRouting2, notNullValue());
                    .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, 1);
                    .index("test")
            for (int i = 0; i < 5; i++) {
        assertTrue(routing.primary()); // Default preference is primary
        assertThat(shardIterator.remaining(), equalTo(0));
            weightsList.add(weights1);
                        .add(newNode("node2", unmodifiableMap(node2Attributes)))
                        .add(newNode("node2", unmodifiableMap(node2Attributes)))
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
            null,
        shardRouting = shardIterator.nextOrNull();
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node2"));
            clusterState = strategy.reroute(clusterState, "reroute");
            clusterState = ClusterState.builder(clusterState)
 * Licensed to Elasticsearch under one or more contributor
                .put("cluster.routing.allocation.awareness.attributes", "zone");
            );
            .index("test")
        clusterState = strategy.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
                .build();
                        .localNodeId("node1")
            assertFalse(Arrays.asList("node3").contains(shardRouting.currentNodeId()));
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build();
/*
            assertFalse(Arrays.asList("node3").contains(shardRouting.currentNodeId()));
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node1"));
        );
        assertThat(shardRouting5, sameInstance(shardRouting1));
            RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(shardIterator.remaining(), equalTo(0));
        node1Attributes.put("rack_id", "rack_1");
                    .shard(0)
            Map<String, String> node1Attributes = new HashMap<>();
                .shard(0)
        );
            Metadata metadata = Metadata.builder()
    }
            clusterState = strategy.reroute(clusterState, "reroute");
import org.opensearch.index.IndexModule;
            Settings.EMPTY,
        GroupShardsIterator<ShardIterator> shardIterators = operationRouting.searchShards(
import static org.hamcrest.Matchers.equalTo;
                    .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * You may obtain a copy of the License at
            .index("test")
            terminate(threadPool);
        shardsIterator = clusterState.routingTable()
            .nodes(
            .metadata(metadata)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        shardIterator = routingTable.index("test1").shard(0).shardsRandomIt();
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            weightedRouting = new WeightedRouting("zone", weights);
        clusterState = ClusterState.builder(clusterState)
        assertThat(shardIterator.remaining(), equalTo(0));
        ShardRouting shardRouting1 = shardIterator.nextOrNull();
            .build();
            weightedRouting = new WeightedRouting("zone", weights);
            .build();
                .put("cluster.routing.allocation.awareness.attributes", "zone");
import org.opensearch.cluster.routing.GroupShardsIterator;
            assertFalse(Arrays.asList("node3").contains(shardRouting.currentNodeId()));
                    .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
        assertThat(shardRouting.currentNodeId(), equalTo("node1"));
            assertEquals(startedNodes[0], shardIterator.nextOrNull().currentNodeId());
            Map<String, String> node2Attributes = new HashMap<>();
                    .add(newNode("fred", "node1", singletonMap("disk", "ebs")))
        assertThat(shardIterator.size(), equalTo(2));
        assertThat(shardIterator.nextOrNull(), nullValue());
        shardIterator = clusterState.routingTable()
public class RoutingIteratorTests extends OpenSearchAllocationTestCase {
            Map<String, String> node2Attributes = new HashMap<>();
        assertThat(shardIterators.size(), equalTo(1));
        assertTrue(routing.initializing());
        assertThat(shardIterator.nextOrNull(), nullValue());
    }
        node2Attributes.put("rack_id", "rack_2");
        }
        assertThat(shardIterators.size(), equalTo(2)); // two potential shards
                .shard(0)
                    DiscoveryNodes.builder()
            Map<String, String> node1Attributes = new HashMap<>();
                .build();
            weightedRouting = new WeightedRouting("zone", weights1);
            Map<String, Double> weights1 = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 0.0);
            assertEquals(1, shardIterator.size());
        }
            clusterState = ClusterState.builder(clusterState)
            .build();
        assertThat(shardIterator.nextOrNull(), nullValue());
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
        }
        assertThat(shardRouting, notNullValue());
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        shardsIterator = clusterState.routingTable()
            .shard(0)
                .routingTable(routingTable)
            .build();
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    .add(newNode("node3", Collections.singleton(DiscoveryNodeRole.WARM_ROLE)))
        ShardShuffler shuffler = new RotationShardShuffler(0);
        routing = iter.nextOrNull();
            weightsList.add(weights1);
                    .numberOfReplicas(2)
import static org.hamcrest.Matchers.sameInstance;
            new String[] { "test" },
 */
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
            assertEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());
            assertNotNull(shardRouting);
     * Test to validate that simple weighted shard routing with seed return same shard routing on each call
    }
        assertThat(shardRouting3, notNullValue());
        } catch (IllegalArgumentException illegal) {
        clusterState = strategy.reroute(clusterState, "reroute"); // Move replicas to initializing
        assertThat(shardIterator.nextOrNull(), nullValue());
                        .add(newNode("node2", unmodifiableMap(node2Attributes)))
        assertThat(shardIterators.iterator().next().shardId().id(), equalTo(0));
        assertThat(shardsIterator.size(), equalTo(2));
                .shard(0)
                    .add(newNode("barney", "node2", singletonMap("disk", "ephemeral")))
import org.opensearch.cluster.routing.PlainShardIterator;
                    startedNodes[i] = shard.currentNodeId();
        assertThat(it.shardId().id(), equalTo(0));
            .preferAttributesActiveInitializingShardsIt(Arrays.asList("rack_id"), clusterState.nodes());
        );
                        .add(newNode("node1", unmodifiableMap(node1Attributes)))
        assertThat(shardRouting3, not(sameInstance(shardRouting2)));
                .index("test")
            "_shards:0"
        Metadata metadata = Metadata.builder()
                indexShardRoutingTable.getActiveShardsByWeight().get(new IndexShardRoutingTable.WeightedRoutingKey(weightedRouting))
        assertThat(shardRouting2, not(sameInstance(shardRouting4)));
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
            Map<String, String> node1Attributes = new HashMap<>();
        routing = iter.nextOrNull();
                requestCount.put(shardRouting.currentNodeId(), requestCount.getOrDefault(shardRouting.currentNodeId(), 0) + 1);
 * Modifications Copyright OpenSearch Contributors. See
        ShardRouting shardRouting2 = shardIterator.nextOrNull();
    public void testWeightedRoutingWithInitializingShards() {
            Metadata metadata = Metadata.builder()
            Map<String, Double> weights2 = Map.of("zone1", 1.0, "zone2", 0.0, "zone3", 1.0);
        AllocationService strategy = createAllocationService(
            .build();
        OperationRouting operationRouting = new OperationRouting(
        assertThat(shardIterator.nextOrNull(), nullValue());
            shardRouting = shardIterator.nextOrNull();
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
        // Modify the index to be a searchable snapshot index
                .add(newNode("node3", unmodifiableMap(node3Attributes)))
            node1Attributes.put("zone", "zone1");
                    .localNodeId("node1")
                    .index("test")
        assertThat(shardRouting2, sameInstance(shardRouting3));
            clusterState = strategy.reroute(clusterState, "reroute");
            .shard(0)
            assertThat(it.nextOrNull().currentNodeId(), equalTo("node1"));
            shardIterator = clusterState.routingTable()
                .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
                .index("test")
            terminate(threadPool);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                assertNotEquals(shardRouting1.currentNodeId(), shardRouting2.currentNodeId());
import org.opensearch.cluster.routing.OperationRouting;
        TestThreadPool threadPool = null;
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        assertThat(shardIterator.remaining(), equalTo(2));
        assertThat(shardRouting1, notNullValue());
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
            .build();
        assertTrue(routing.initializing());
                .put("cluster.routing.allocation.awareness.attributes", "zone");
            shardIterator = clusterState.routingTable()
     * Test to validate that shard routing state is maintained across requests, requests are assigned to nodes
                .index("test")
            List<Map<String, Double>> weightsList = new ArrayList<>();
            assertNotEquals("node3", shardIterator.nextOrNull().currentNodeId());
 *
                .nodes(
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
            }
        ShardRouting shardRouting1 = shardIterator.nextOrNull();
                .routingTable(routingTable)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .index("test")
        );
        assertThat(shardIterator.nextOrNull(), nullValue());
import org.opensearch.cluster.node.DiscoveryNodeRole;
            ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);
        assertThat(shardRouting.currentNodeId(), equalTo("node2"));
            .index("test")
                    DiscoveryNodes.builder()
            assertEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());
            assertNotNull(shardRouting);
        // finally the primary
            terminate(threadPool);
            assertNotNull(shardRouting);
            assertEquals(3, shardIterator.size());
    }
            .shard(0)
import static org.hamcrest.Matchers.anyOf;
import java.util.ArrayList;
        } finally {
        assertFalse(routing.primary());
        );
    public void testShardsAndPreferNodeRouting() {
            node2Attributes.put("zone", "zone2");
        ShardRouting routing = iter.nextOrNull();
 * this file be licensed under the Apache-2.0 license or a
        } else {
        shardsIterator = clusterState.routingTable()
        assertThat(shardRouting, notNullValue());
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node2"));
import org.opensearch.cluster.metadata.IndexMetadata;
        try {
            assertNotNull(shardRouting);
                ShardIterator shardIterator = clusterState.routingTable()
        routing = iter.nextOrNull();
            WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            clusterState = ClusterState.builder(clusterState).nodes(nodes).build();
                .index("test")
        );
 * the Apache License, Version 2.0 (the "License"); you may
                .metadata(metadata)
            WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
                .metadata(metadata)
                .build();
                    .settings(
                .index("test")
                            .put(settings(Version.CURRENT).build())
                    startedZones[i++] = nodes.resolveNode(shard.currentNodeId()).getAttributes().get("zone");
                .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        ShardIterator shardIterator = routingTable.index("test1").shard(0).shardsRandomIt();
import static org.hamcrest.Matchers.nullValue;
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
            assertEquals(3, shardIterator.size());
            weights = Map.of(initializingZone, 0.0, startedZones[0], 1.0, startedZones[1], 0.0);
    public void testSearchableSnapshotPreference() {
            weightedRouting = new WeightedRouting("zone", weights);
            Map<String, String> node2Attributes = new HashMap<>();
        shardsIterator = clusterState.routingTable()
                .build();
        assertThat(shardIterators.size(), equalTo(1));
            weightedRouting = new WeightedRouting("zone", weights);
            String initializingZone = null;
            shardsIterator = clusterState.routingTable()
                .index("test")
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node2"));
        ShardRouting shardRouting8 = shardIterator.nextOrNull();
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));
            .index("test")
            Map<String, String> node3Attributes = new HashMap<>();
                .shard(0)
            ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);
            node1Attributes.put("zone", "zone1");
                .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
                .build();
            assertNull(
            shardIterator = clusterState.routingTable()
            for (ShardRouting shard : clusterState.routingTable().allShards()) {
        );
        }
        Metadata metadata = Metadata.builder()
        );
        assertThat(shardRouting2, not(sameInstance(shardRouting1)));
            Settings.builder()
            .onlyNodeSelectorActiveInitializingShardsIt(new String[] { "disk:eph*", "disk:ebs" }, clusterState.nodes());
        assertThat(shardIterators.size(), equalTo(2)); // two potential shards
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertEquals(startedNodes[1], shardIterator.nextOrNull().currentNodeId());
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")).localNodeId("node1"))
        routing = iter.nextOrNull();
        assertThat(shardIterator.size(), equalTo(2));
        clusterState = ClusterState.builder(clusterState)
            ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);
                .build()
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .onlyNodeSelectorActiveInitializingShardsIt("fred", clusterState.nodes());
        assertThat(shardIterator.remaining(), equalTo(0));
            for (int i = 0; i < weightsList.size(); i++) {
            .nodes(
            Settings.EMPTY,
        clusterState = strategy.reroute(clusterState, "reroute"); // Move primaries to initializing
        node1Attributes.put("zone", "zone1");
    /**
            .build();
import org.opensearch.cluster.routing.RoutingTable;
        assertThat(shardIterator.nextOrNull(), nullValue());
        assertThat(shardRouting7, sameInstance(shardRouting3));
        Map<String, String> node1Attributes = new HashMap<>();
        assertThat(shardIterators.size(), equalTo(2)); // two potential shards
        shardRouting = shardIterator.nextOrNull();
            weightedRouting = new WeightedRouting("zone", weights2);
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                .nodes(
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            Map<String, String> node1Attributes = new HashMap<>();
        assertThat(shardRouting10, notNullValue());
                indexShardRoutingTable.getActiveShardsByWeight().get(new IndexShardRoutingTable.WeightedRoutingKey(weightedRouting))
                indexShardRoutingTable.getActiveShardsByWeight().get(new IndexShardRoutingTable.WeightedRoutingKey(weightedRouting))
                    )
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            ShardRouting shardRouting;
        assertThat(shardRouting6, not(sameInstance(shardRouting5)));
                .routingTable(routingTable)
            Settings.EMPTY,
/*
        iter = shardIterators.iterator().next();
            node3Attributes.put("zone", "zone3");
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertTrue(routing.started());
        assertTrue(routing.primary());
        assertThat(shardRouting8, sameInstance(shardRouting4));
            weights = Map.of("zone1", -1.0, "zone2", 0.0, "zone3", 1.0);
        ShardRouting shardRouting10 = shardIterator.nextOrNull();
            // Make iterator call with same WeightedRouting instance
            assertEquals(2, shardIterator.size());
        assertThat(shardIterator.nextOrNull(), nullValue());
            clusterState = ClusterState.builder(clusterState)
                .index("test")
        assertThat(shardRouting8, notNullValue());
            terminate(threadPool);
        assertThat(shardRouting, notNullValue());
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
            Map<String, Double> weights = Map.of(startedZones[0], 1.0, initializingZone, 1.0, startedZones[1], 0.0);
            Map<String, String> node2Attributes = new HashMap<>();
        AllocationService strategy = createAllocationService(
            )
            String[] startedZones = new String[2];
 * this work for additional information regarding copyright
            assertEquals(2, shardIterator.size());
        );
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_shards:0|");
        assertThat(shardIterator.remaining(), equalTo(1));
            clusterState = strategy.reroute(clusterState, "reroute");
                .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        shardsIterator = clusterState.routingTable()
                    .shard(0)
        clusterState = ClusterState.builder(clusterState)
                DiscoveryNodes.builder()
                )
            clusterState,
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                .build();
            Map<String, String> node2Attributes = new HashMap<>();
                        .localNodeId("node1")
            shardIterator = clusterState.routingTable()
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            Metadata metadata = Metadata.builder()
        ShardIterator shardIterator = clusterState.routingTable()
            .metadata(metadata)
}
            AllocationService strategy = createAllocationService(settings.build());
                .index("test")
        assertThat(shardsIterator.size(), equalTo(1));
            shardIterator = clusterState.routingTable()
        } finally {
            clusterState = strategy.reroute(clusterState, "reroute");
            for (int i = 0; i < 50; i++) {
                ShardRouting shardRouting1 = shardIterator.nextOrNull();
            assertEquals(initializingNode, shardIterator.nextOrNull().currentNodeId());
        assertThat(shardIterators.size(), equalTo(2)); // two potential shards
            weightsList.add(weights4);
            node3Attributes.put("zone", "zone3");
 * license agreements. See the NOTICE file distributed with
        assertThat(shardRouting10, not(sameInstance(shardRouting9)));
        clusterState = strategy.reroute(clusterState, "reroute");
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        assertThat(shardIterators.iterator().next().nextOrNull().currentNodeId(), not(equalTo(firstRoundNodeId)));
                .shard(0)
                indexShardRoutingTable.getActiveShardsByWeight().get(new IndexShardRoutingTable.WeightedRoutingKey(weightedRouting))
import org.opensearch.cluster.metadata.Metadata;
        } finally {
            shardIterator = clusterState.routingTable()
            fail("should have raised illegalArgumentException");
                } else {
        clusterState = strategy.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
            .build();
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));
import org.opensearch.cluster.routing.ShardIterator;
        assertThat(shardsIterator.size(), equalTo(1));
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node1"));
            node1Attributes.put("zone", "zone1");
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
import org.opensearch.threadpool.TestThreadPool;
    /**
                DiscoveryNodes.builder()
                .shard(0)
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_shards:0|_prefer_nodes:node1");
        clusterState = ClusterState.builder(clusterState)
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .shard(0)
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        ShardsIterator shardsIterator = clusterState.routingTable()
            assertEquals(2, shardIterator.size());
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        assertThat(shardRouting1, not(sameInstance(shardRouting2)));
        try {
            .build();
            .put(
            Settings.Builder settings = Settings.builder()
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));
        final ShardIterator it = iterator.next();
            Map<String, String> node3Attributes = new HashMap<>();
            .build();
 * software distributed under the License is distributed on an
                        .add(newNode("node3", unmodifiableMap(node3Attributes)))
                .index("test")
        assertThat(shardIterator.nextOrNull(), nullValue());
                        .add(newNode("node1", unmodifiableMap(node1Attributes)))
            List<Map<String, Double>> weightsList = new ArrayList<>();
        assertThat(shardIterator.nextOrNull(), nullValue());
        assertNull(routing); // No other candidate apart from primary
 * compatible open source license.
            AllocationService strategy = createAllocationService(settings.build());
            );
            WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        } finally {
        assertThat(shardRouting2, not(sameInstance(shardRouting1)));
            assertThat(it.nextOrNull().currentNodeId(), equalTo("node2"));
            // only initializing shard has weight with fail open true
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));
            // with zero weight
            assertNotEquals("node3", shardIterator.nextOrNull().currentNodeId());
        node2Attributes.put("zone", "zone2");
        assertThat(shardIterator.remaining(), equalTo(0));
        ShardRouting shardRouting4 = shardIterator.nextOrNull();
                shardIterator = clusterState.routingTable()
            "_replica_first"
                .shard(0)
                .routingTable(routingTable)
            WeightedRouting weightedRouting = new WeightedRouting("zone", weights1);
            Metadata metadata = Metadata.builder()
            node2Attributes.put("zone", "zone2");
            null,
            shardIterator = clusterState.routingTable()
        shardIterators = operationRouting.searchShards(clusterState, new String[] { "test" }, null, "_shards:0|_prefer_nodes:node1,node2");
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, true, null);
        // When replicas haven't initialized, it comes back with the primary first, then initializing replicas
            // Making the first shard as active
    public void testWeightedRoutingShardStateWithDifferentWeights() {
            .build();
                .shard(0)
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(shardIterator.size(), equalTo(2));
            .shard(0)
                ShardIterator shardIterator = clusterState.routingTable()
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node1"));
            IndexShardRoutingTable indexShardRoutingTable = clusterState.routingTable().index("test").shard(0);
            assertNotNull(
                        .add(newNode("node3", unmodifiableMap(node3Attributes)))
            node2Attributes.put("zone", "zone2");
    }
import java.util.Arrays;
            shardIterator = clusterState.routingTable()
            // Make iterator call with different weights
        assertThat(shardRouting2, notNullValue());
        TestThreadPool threadPool = new TestThreadPool("testActiveInitializingShardsWeightedItWithCustomSeed");
            Map<String, Double> weights1 = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 0.0);
import org.opensearch.cluster.routing.allocation.AllocationService;
            .routingTable(routingTable)
            assertNull(
        assertThat(shardIterator.size(), equalTo(2));
                .shard(0)
        assertThat(shardRouting2, notNullValue());
                assertEquals(shardRouting1.currentNodeId(), shardRouting2.currentNodeId());
        assertThat(shardRouting5, notNullValue());
        assertThat(shardIterator.size(), equalTo(3));
    public void testWeightedRoutingShardState() {
            )
            new String[] { "test" },
        assertThat(shardIterator.nextOrNull(), nullValue());
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        clusterState = strategy.applyStartedShards(clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
        assertThat(shardIterator.remaining(), equalTo(0));
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));
            // With fail open enabled set to true, we expect 3 shard routing, first one started, followed by initializing, third one started
                )
    public void testIterator2() {
        assertThat(shardIterators.iterator().next().shardId().id(), equalTo(0));
import org.opensearch.cluster.routing.ShardRouting;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    .add(newNode("node1", unmodifiableMap(node1Attributes)))
            null
        assertThat(shardRouting3, not(sameInstance(shardRouting1)));
        shardsIterator = clusterState.routingTable()
        shardIterator = routingTable.index("test1").shard(0).shardsIt(3);
            weightedRouting = new WeightedRouting("zone", weights);
 * not use this file except in compliance with the License.
                    .index("test")
        ShardRouting shardRouting3 = shardIterator.nextOrNull();
        TestThreadPool threadPool = null;
        assertThat(shardRouting7, notNullValue());
        assertThat(shardsIterator.size(), equalTo(2));
        // after all are started, check routing iteration
    public void testAttributePreferenceRouting() {
        clusterState = strategy.reroute(clusterState, "reroute"); // Move replicas to initializing
                        .localNodeId("node1")
        // check node preference, first without preference to see they switch
        assertThat(shardRouting6, notNullValue());
                .shard(0)
                .activeInitializingShardsWeightedIt(weightedRouting, clusterState.nodes(), 1, false, null);
        assertThat(shardIterator.size(), equalTo(2));
 * The OpenSearch Contributors require contributions made to
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test1")).build();
        assertThat(shardsIterator.nextOrNull().currentNodeId(), equalTo("node2"));
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(shardsIterator.size(), equalTo(1));
        assertThat(shardRouting.currentNodeId(), equalTo("node2"));
        assertThat(shardIterator.remaining(), equalTo(0));
        ShardRouting shardRouting5 = shardIterator.nextOrNull();
            assertFalse(Arrays.asList("node2").contains(shardRouting.currentNodeId()));
        assertThat(routing.shardId().id(), anyOf(equalTo(0), equalTo(1)));
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            node2Attributes.put("zone", "zone2");
        assertThat(shardIterators.size(), equalTo(1));
            weightsList.add(weights3);
                .index("test")
        assertThat(shardIterator.nextOrNull(), notNullValue());
            node2Attributes.put("zone", "zone2");
        TestThreadPool threadPool = null;
        Map<String, String> node2Attributes = new HashMap<>();
            .build();
        try {
            Map<String, Double> weights1 = Map.of("zone1", 1.0, "zone2", 1.0, "zone3", 0.0);
        clusterState = strategy.reroute(clusterState, "reroute");
            assertNotNull(
        assertThat(shardIterator.nextOrNull(), nullValue());
            ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .nodes(
                    DiscoveryNodes.builder()
                .build();
            .metadata(metadata)
     */
            // expected exception
                        .add(newNode("node1", unmodifiableMap(node1Attributes)))
                if (shard.initializing()) {
            }
            .onlyNodeSelectorActiveInitializingShardsIt("disk:ebs", clusterState.nodes());
        assertThat(shardsIterator.size(), equalTo(1));
                    DiscoveryNodes.builder()
            // Make iterator call with new instance of WeightedRouting but same weights
            Map<String, Double> weights2 = Map.of("zone1", 1.0, "zone2", 0.0, "zone3", 1.0);
            Map<String, Double> weights = Map.of("zone1", 3.0, "zone2", 2.0, "zone3", 0.0);
        assertThat(shardRouting, notNullValue());
            Settings.Builder settings = Settings.builder()
                        .add(newNode("node3", unmodifiableMap(node3Attributes)))
            )
        Metadata metadata = Metadata.builder()
                .put("cluster.routing.allocation.awareness.attributes", "zone");
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        shardIterator = routingTable.index("test1").shard(0).shardsIt(1);
        assertThat(shardIterator.nextOrNull(), nullValue());
            Settings.Builder settings = Settings.builder()
