import java.util.List;
        // The first index is a searchable snapshot index
import org.opensearch.common.settings.ClusterSettings;
            Version.CURRENT
                    position++;
        }
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
                        e,
            groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
                .settings(settings(Version.CURRENT))
        }
                ShardRouting shard;
        termToShard.put("yizTqyjuDn", 4);
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, null);
                    // Server-injected _primary preference applies to the remote snapshot index
        termToShard.put("schsINzlYB", 1);
        assertNotNull(secondChoice);
        routingIdToShard.put("a", routingA);
            null,
            }
        ClusterService clusterService = null;
        state = updateStatetoTestARS(indexNames, numShards, numReplicas, allNodes, state);
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata())
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
        assertThat(shardChoice.currentNodeId(), equalTo("node_2"));
            .settings(settings(Version.CURRENT))
        DiscoveryNode[] nodes,
                    .put(SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.test.ClusterServiceUtils;
            "node_b1",
                Settings.EMPTY,
                    Settings.builder()
        final String warmIndex = indexNames[0];
                    assertThat("Only the primary should be returned for the remote snapshot index", shardIterator.size(), equalTo(1));
                Settings.builder().build(),
                String id = idEntry.getKey();
        routingA.put("a_2", 2);
        state = ClusterState.builder(state)
    }
        outstandingRequests.put("node_0", 1L);
     * The following setup is created to test ARS
            final List<ShardRouting> expected = new ArrayList<>();
                        hasToString(
    public void testPartitionedIndexBWC() {
            ClusterServiceUtils.setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(indexName, true, randomInt(8)));
            terminate(threadPool);
            assertEquals(Arrays.toString(shardSplits), 1, shardIds.stream().filter((sid) -> sid.id() == shard).count());
                .settings(settings(Version.CURRENT))
        }
            // given a configuration with many nodes but the nature of hash
            for (Map.Entry<String, Integer> idEntry : routingIdEntry.getValue().entrySet()) {
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
                // Assign all the primary shards on nodes in zone-a (node_a0 or node_a1)
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
        termToShard.put("sEERfFzPSI", 1);
            ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(indexNames, numShards, numReplicas);
            String routing = routingIdEntry.getKey();
        outstandingRequests.put("node_1", 1L);
        List<ShardRouting> searchedShards = new ArrayList<>(numShards);
            );
                        .put(state.metadata().index(remoteSnapshotIndex).getSettings())
        assertThat(groupIterator.size(), equalTo(numIndices * numShards));
        termToShard.put("WFFWYBfnTb", 0);
                .build();
                        .put(SETTING_CREATION_DATE, System.currentTimeMillis())
            terminate(threadPool);
            assertEquals(1, shardIds.stream().filter((sid) -> sid.id() == shard).count());
            for (int i = 0; i < numberOfShards; i++) {
            IOUtils.close(clusterService);
        Map<String, Deployment> deployments = new HashMap<>();
 * software distributed under the License is distributed on an
        return clusterState.build();
import static org.hamcrest.CoreMatchers.containsString;
        ClusterService clusterService = null;
        termToShard.put("UOjiTugjNC", 7);
            for (ShardIterator it : groupIterator) {
import org.opensearch.core.index.shard.ShardId;
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        final int numShards = 3;
        termToShard.put("FYQRIBcNqz", 0);
                        shardRouting.isSearchOnly() || shardRouting.primary() || shardRouting.isSearchOnly() == false
                .numberOfReplicas(2)
            }
            }
    public void testSearchReplicaRoutingWhenSearchOnlyStrictSettingIsFalse() throws Exception {
            assertThat("One group per index shard", groupIterator.size(), equalTo(indexNames.length * numShards));
            IndexMetadata indexMetadata = IndexMetadata.builder(index)
            // tests no shards are assigned to nodes in zone c
        String[] indices,
                    Settings.builder()
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
            // Update the index config within the cluster state to modify the index to a searchable snapshot index
            IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
        routingIdToShard.put("d", routingD);
    public void testWeightedOperationRouting() throws Exception {
                    expected.add(shards.get(position));
        int i = 0;
            indexShardRoutingBuilder.addIndexShard(indexShardRoutingTable);
        nodesZoneC.add(allNodes[4]);
            buildNewFakeTransportAddress(),
                    Settings.builder()
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, null);
                        assertTrue("Initializing shard should appear last", shardRouting.initializing());
        routingA.put("a_1", 2);
        termToShard.put("bGEIEBLATe", 6);
        selectedNodes.add(thirdChoice.currentNodeId());
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        for (Map.Entry<String, Map<String, Integer>> routingIdEntry : routingIdToShard.entrySet()) {
        DiscoveryNode clusterManager = new DiscoveryNode(
                for (int replica = 0; replica < numberOfReplicas; replica++) {
                    selectedNodes.add(shardRouting.currentNodeId());
            // randomized tests in my experiments over thousands of iterations.
import java.util.ArrayList;
    /**
            Version.CURRENT
                    indexShardRoutingBuilder.addShard(
        return allNodes;
    ) {
        termToShard.put("FAIcSmmNXq", 5);
        }
        Map<String, Integer> routingB = new HashMap<>();
                .settings(
            ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(
                shard = it.nextOrNull();
                int shard = idEntry.getValue();
            builder = ClusterState.builder(state);
    }
                        "Only search replicas should exist with preference SEARCH_REPLICA",
                    Settings.builder()
                Settings.builder()
            final Index index = clusterService.state().metadata().index(indexName).getIndex();
    public void testSearchReplicaDefaultRouting() throws Exception {
                final ShardId shardId = new ShardId(index, "_na_", i);
            allNodes[i++] = node;
        DiscoveryNode nodeA0 = new DiscoveryNode(
                buildNewFakeTransportAddress(),
        termToShard.put("ElSVuJQQuw", 7);
            );
        termToShard.put("OutXGRQUja", 5);
        }
        OperationRouting opRouting = new OperationRouting(
                    IllegalArgumentException.class,
            );
        termToShard.put("WRjUoZwtUz", 3);
                }
        try {
        termToShard.put("eDItImYWTS", 1);
            }
        assertNotNull(thirdChoice);
            IndexMetadata searchableSnapshotIndexMetadata = IndexMetadata.builder(searchableSnapshotIndex)
                .build();
            routingTableBuilder.add(indexRoutingTableBuilder.build());
        assertTrue(nodeIds.contains(nodeB0.getId()));
        searchedShards.add(firstChoice);
                    ).getShards(cs.state(), indexName, 0, "_only_nodes:" + String.join(",", nodes))
        Map<String, Long> outstandingRequests = new HashMap<>();
        termToShard.put("vdnUhGLFtl", 0);
            for (ShardIterator shardIterator : groupIterator) {
            terminate(threadPool);
 * specific language governing permissions and limitations
                    }
            }
                    ShardRouting shardRouting = it.nextOrNull();
            assertNotNull(shardId);
                        .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
        termToShard.put("lmvAaEPflK", 7);
        termToShard.put("QrklDfvEJU", 6);
                int i = 0;
        termToShard.put("rSjLZHCDfT", 5);
            }
        termToShard.put("EyCVeiCouA", 1);
        termToShard.put("aAMXnamRJg", 7);
            null,
            final List<String> nodes = new ArrayList<>();
            DiscoveryNode node = new DiscoveryNode(
            singletonMap("zone", "b"),
    private DiscoveryNode[] setupNodes() {
        termToShard.put("GRIueBeIyL", 7);
            )
            }
            // add a search replica in initializing state:
    }
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
            buildNewFakeTransportAddress(),
        termToShard.put("yDCCPVBiCm", 7);
        clusterState.metadata(metadataBuilder);
import java.io.IOException;
            DiscoveryNode node = new DiscoveryNode(
        collector.addNodeStatistics("node_a1", 20, TimeValue.timeValueMillis(100).nanos(), TimeValue.timeValueMillis(150).nanos());
                .build();
        routingC.put("c_3", 0);
            shardBuilder.addShard(TestShardRouting.newShardRouting(index, i, nodeB0.getId(), null, false, ShardRoutingState.STARTED));
            DiscoveryNode node = new DiscoveryNode(
            setting = Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone").build();
            threadPool = new TestThreadPool("testSearchReplicaDefaultRouting");
import org.opensearch.cluster.service.ClusterService;
                for (ShardRouting shardRouting : shardRoutings) {
        List<String> zones = Arrays.asList("a", "a", "b", "b", "c", "c");
            threadPool = new TestThreadPool("testPartialIndexPrimaryDefault");
            for (ShardIterator shardIterator : groupIterator) {
                if (nodeID.contains("c")) {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        Metadata.Builder metadataBuilder = Metadata.builder(state.metadata());
    }
        try {
        }
        // Test that the shards use a round-robin pattern when there are no stats
    public void testPartitionedIndex() {
                Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
            indexRoutingTableBuilder.addIndexShard(shardBuilder.build());
                final ShardId shardId = new ShardId(index, "_na_", i);
                    );
            .settings(settings(Version.CURRENT))
        OperationRouting routing = new OperationRouting(
            // collisions means we can't always rely on optimal node usage in
        termToShard.put("qoZALVcite", 7);
                assertThat("Sessions must reuse same replica choices", searchedShards, equalTo(sessionsfirstSearch));
                .build();
                ShardRouting firstChoice = shardIterator.nextOrNull();
            state = ClusterState.builder(state).metadata(metadataBuilder.build()).build();
        routingC.put("c_0", 1);
            .numberOfShards(4)
            final int count = randomIntBetween(1, shards.size());
        }
                    TestShardRouting.newShardRouting(index, i, nodes[randomInt(1)].getId(), null, true, ShardRoutingState.STARTED)
            );
            indexShardRoutingBuilder.addIndexShard(indexShardRoutingTable);
 * You may obtain a copy of the License at
        final String[] indexNames = new String[] { indexName };
        ThreadPool threadPool = null;
                        .put(SETTING_CREATION_DATE, System.currentTimeMillis())
                .generateClusterUuidIfNeeded();
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
        } finally {
            .routingPartitionSize(2)
                indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
                        .put(SETTING_VERSION_CREATED, Version.CURRENT)
    }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                        .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)
        routingC.put("c_3", 4);
        termToShard.put("DifcuqSsKk", 1);
                .settings(Settings.builder().put(state.metadata().index(indexName).getSettings()).build())
                    );
import org.opensearch.threadpool.ThreadPool;
        }
            singletonMap("zone", "a"),
 *
        Metadata.Builder metadataBuilder = Metadata.builder();
                        nodesZoneA.get(randomInt(nodesZoneA.size() - 1)).getId(),
                .numberOfSearchReplicas(3)
                collector,
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, null);
        searchedShards.add(thirdChoice);
        ShardRouting secondChoice = groupIterator.get(0).nextOrNull();
            state = ClusterState.builder(state).metadata(metadataBuilder.build()).build();
        termToShard.put("yCdyocKWou", 1);
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)
                assertFalse(nodeID.contains("a"));
        termToShard.put("yhZhzCPQby", 1);
            .settings(
        final String[] indexNames = new String[] { indexName };
        ClusterService clusterService = null;
        routingD.put("d_0", 3);
            // Verify default preference is primary only
        termToShard.put("oDdHJxGxja", 7);
        DiscoveryNode[] allNodes = new DiscoveryNode[] { nodeA0, nodeA1, nodeB0, nodeB1, clusterManager };
                while ((shard = it.nextOrNull()) != null) {
                    String nodeId = "";
        final int numReplicas = 2;
                for (ShardRouting shardRouting : shardIterator) {
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
            indexShardRoutingBuilder.addShard(
    public void testPartitionedIndexShrunk() {
        termToShard.put("YOhahLSzzE", 5);
        collector.addNodeStatistics("node_1", 4, TimeValue.timeValueMillis(300).nanos(), TimeValue.timeValueMillis(250).nanos());
                        )
        collector.addNodeStatistics("node_a0", 100, TimeValue.timeValueMillis(300).nanos(), TimeValue.timeValueMillis(250).nanos());
            IndexMetadata indexMetadata = IndexMetadata.builder(index)
        DiscoveryNode[] allNodes = setupNodes();
                .build();
                indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
            // the preferred shards should be at the front of the list
        assertThat(shardChoice.currentNodeId(), equalTo("node_1"));
                assertThat("Regression test failure", duelFirst, equalTo(firstChoice));
        termToShard.put("pezPtTQAAm", 7);
        termToShard.put("hswhrppvDH", 0);
            indexNames[i] = "test" + i;
        Settings awarenessSetting = Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone").build();
                .put("cluster.routing.allocation.awareness.attributes", "zone")
                .numberOfReplicas(1)
        opRouting.checkPreferenceBasedRoutingAllowed(Preference.PREFER_NODES, weightedRoutingMetadata, true);
            String term = randomAlphaOfLength(10);
        // A caller-supplied restricted preference must be rejected under strict weighted routing
                .settings(Settings.builder().put(state.metadata().index(indexName).getSettings()).build())
        for (int shards = 1; shards < 5; shards++) {
        }
        TestThreadPool threadPool = null;
        for (ShardIterator it : groupIterator) {
                assertEquals("We should have 3 shards returned", shardIterator.size(), 3);
            }
            Version.CURRENT
 * GitHub history for details.
        // The same preference must be allowed when it was injected by the server itself
        final String indexName = "test";
import java.util.Map;
    private ClusterState clusterStateForWeightedRouting(String[] indexNames, int numShards, int numReplicas) {
import org.opensearch.cluster.metadata.IndexMetadata;
                numShards,
        try {
        }
            ClusterState state = clusterStateForWeightedRouting(indexNames, numShards, numReplicas);
        DiscoveryNode clusterManager = new DiscoveryNode(
        // The first index is a remote snapshot index, for which the server injects the _primary preference
        termToShard.put("hOkpeQqTDF", 3);
            outstandingRequests,
            for (ShardIterator shardIterator : groupIterator) {
                .numberOfShards(shardSplits[2])
                        index,
    // on nodes in one zone to test if Adapative Replica Selection smartly routes the request to a node in different zone
                null
                }
        for (Map.Entry<String, Map<String, Integer>> routingIdEntry : routingIdToShard.entrySet()) {
        metadataBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
        nodesZoneA.add(allNodes[1]);
        nodesZoneB.add(allNodes[3]);
                new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
            null
            assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
            ClusterServiceUtils.setState(clusterService, ClusterState.builder(state));
    }
            );
    private ClusterState updateStatetoTestWeightedRouting(
        routingB.put("b_4", 3);
            }
                assertTrue("Only primary should exist with no preference", shardIterator.nextOrNull().primary());
        termToShard.put("iWswCilUaT", 1);
                    // Assign all the replicas on nodes in zone-b (node_b2)
        termToShard.put("cNRiIrjzYd", 7);
            shrunkShard = OperationRouting.generateShardId(split, term, null);
                state,
        clusterState = ClusterState.builder(clusterState).metadata(metadataBuilder).build();
            Collections.emptyMap(),
                    )
 * ownership. Elasticsearch licenses this file to you under
        allNodes[i] = clusterManager;
        GroupShardsIterator<ShardIterator> drainedIterator = opRouting.searchShards(state, new String[] { index }, null, null);
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
                        Settings.EMPTY,
        Map<String, Map<String, Integer>> routingIdToShard = new HashMap<>();
            while (shard != null) {
                List<ShardRouting> shardRoutings = Collections.singletonList(it.nextOrNull());
        );
            final int count = randomIntBetween(1, shards.size());
                        true,
            ShardRouting shard = it.nextOrNull();
        final int numShards = 3;
                        String id = randomUnicodeOfLengthBetween(1, 50);
                while (it.remaining() > 0) {
        final String[] indexNames = new String[numIndices];
            .build();
            IOUtils.close(clusterService);
        final int numReplicas = 2;
            int shrunkShard = OperationRouting.generateShardId(split, term, null);
                selectedNodes.add(firstChoice.currentNodeId());
                    );
            }
            assertThat(preferred, containsInAnyOrder(expected.toArray()));
                    selectedNodes.add(shardRouting.currentNodeId());
            );
                }
        // Now let's start adding node metrics, since that will affect which node is chosen
        termToShard.put("nGzpgwsSBc", 4);
        for (int i = 0; i < numIndices; i++) {
        return clusterState;
        collector.addNodeStatistics("node_a0", 10, TimeValue.timeValueMillis(200).nanos(), TimeValue.timeValueMillis(150).nanos());
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
                        assertFalse("Initializing shard should appear last", shardRouting.active());
            assertFalse(weighAwayNodesInUndefinedZone);
        // The first index is a writable warm index, for which the server injects the _primary_first preference
                        .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
            Settings.EMPTY,
        // Sets up two data nodes in zone-a and one data node in zone-b
            final ShardIterator it = new OperationRouting(
    }
        ClusterState state = ClusterStateCreationUtils.state(nodeA0, clusterManager, allNodes);
        Map<String, Integer> routingD = new HashMap<>();
            Settings.EMPTY,
                .build();
                .routingTable(RoutingTable.builder().add(indexShardRoutingBuilder).build())
            Set<ShardId> shardIds = IndexMetadata.selectShrinkShards(shrunkShard, metadata, shrunk.getNumberOfShards());
            ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(
                }
 */
        discoveryNodeMap.put("a", nodesZoneA);
            terminate(threadPool);
            // Weighted shard routing is active with a zero-weight zone (e.g. Multi-AZ with Standby)
        termToShard.put("nyeRYDnDQr", 6);
            // tests that no shards are assigned to zone with weight zero
                Version.CURRENT
                .numberOfReplicas(1)
        ClusterState.Builder clusterState = ClusterState.builder(state);
            Collections.emptyMap(),
            .build();
                Settings.EMPTY,
        List<DiscoveryNode> nodesZoneC = discoveryNodeMap.get("c");
        Map<String, List<DiscoveryNode>> discoveryNodeMap = new HashMap<>();
            }
                numReplicas,
                .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        IOUtils.close(clusterService);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
                "node_initializing",
            Version.CURRENT
            terminate(threadPool);
                int shard = idEntry.getValue();
                        "Any shard can exist with when cluster.routing.search_replica.strict is set as false",
            .metadata(Metadata.builder(state.getMetadata()).putCustom(DeploymentMetadata.TYPE, new DeploymentMetadata(deployments)).build())
                "node_initializing",
            ShardId shardId = indexShardRoutingTable.searchOnlyReplicas().get(0).shardId();
            "cluster-manager",
                    Set<Integer> shardSet = new HashSet<>();
        ThreadPool threadPool = null;
            IndexShardRoutingTable indexShardRoutingTable = state.getRoutingTable().index(indexName).getShards().get(0);
            assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
            terminate(threadPool);
                }
            buildNewFakeTransportAddress(),
            ClusterServiceUtils.setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(indexName, true, randomInt(8)));
 * this work for additional information regarding copyright
        assertThat(searchedShards.size(), equalTo(3));
            // add a search replica in initializing state:
        termToShard.put("BSiWvDOsNE", 5);
            }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            int[] shardSplits = randomFrom(possibleValues);
        collector.addNodeStatistics("node_1", 2, TimeValue.timeValueMillis(200).nanos(), TimeValue.timeValueMillis(150).nanos());
            null,
        OperationRouting opRouting = new OperationRouting(
                        null,
        outstandingRequests.put("node_b2", 1L);
        termToShard.put("QnFjcpcZUT", 4);
                        nodeId = nodesZoneB.get(randomInt(nodesZoneB.size() - 1)).getId();
                        .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)
                .settings(settings(Version.CURRENT))
            .numberOfShards(6)
        searchedShards.add(firstChoice);
            final List<ShardRouting> all = new ArrayList<>();
            // routing preference check, even though the server injects _primary_first for the warm index
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(
                singletonMap("zone", zone),
            ClusterServiceUtils.setState(clusterService, builder);
        DiscoveryNode[] allNodes = new DiscoveryNode[7];
    public void testGenerateShardId() {
        Map<String, Integer> routingA = new HashMap<>();
        final int numRepeatedSearches = 4;
    public void testSearchShardsExcludesDrainedNodes() {
            Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
                    nodes.add(shards.get(position).currentNodeId());
                searchedShards.add(firstChoice);
        ShardRouting firstChoice = groupIterator.get(0).nextOrNull();
                            containsString("no data nodes with criteria [" + String.join(",", nodes) + "] found for shard: [test][0]")
    public void testBWC() {
        IndexMetadata metadata = IndexMetadata.builder("test")
                    } else {
                }
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
import java.util.Arrays;
 * Unless required by applicable law or agreed to in writing,
 */
                    assertThat(
                indexNames,
                        hasToString(
                : OperationRouting.generateShardId(metadata, "foobar", key);
 * The OpenSearch Contributors require contributions made to
                .build();
        ClusterService clusterService = null;
            IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
                    assertTrue(
        ClusterService clusterService = null;
            final String indexName = "test";
            for (ShardIterator shardIterator : groupIterator) {
    }
                for (ShardRouting shardRouting : shardIterator) {
    }
            assertEquals(shardSplits[0], (shardSplits[0] / shardSplits[1]) * shardSplits[1]);
    }
            } else {
    }
        assertNotNull(firstChoice);
        termToShard.put("DGJOYrpESx", 4);
            Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
    public void testSearchableSnapshotPrimaryDefault() throws Exception {
            }
            IndexRoutingTable.Builder indexShardRoutingBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
                .setRoutingNumShards(shardSplits[0])
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
            ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(indexNames, numShards, numReplicas);
            .routingPartitionSize(3)
        try {
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertThat("one group per shard", groupIterator.size(), equalTo(numShards));
                Version.CURRENT
                Collections.emptyMap(),
        termToShard.put("IKuOwPjKCx", 5);
        final int numIndices = 2;
                    );
        Set<String> selectedNodes = new HashSet<>(numShards);
                        .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        int[][] possibleValues = new int[][] { { 2, 4, 8 }, { 2, 10, 20 }, { 3, 12, 36 }, { 1, 5, 15 } };
        }
            // search shards call
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
        for (int i = 0; i < numIndices; i++) {
        assertTrue(selectedNodes.contains("node_b2"));
        routingB.put("b_0", 0);
            }
            terminate(threadPool);
            ).getShards(clusterService.state(), indexName, 0, "_prefer_nodes:" + String.join(",", nodes));
                .build(),
                .settings(
                }
        final IndexShardRoutingTable indexShard = clusterState.getRoutingTable().shardRoutingTable(shardId.getIndexName(), shardId.getId());
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata())
        }
                shard = it.nextOrNull();
        terminate(threadPool);
            singletonMap("zone", "a"),
/*
                )
                .build();
            Version.CURRENT
            assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
            while ((shard = it.nextOrNull()) != null) {
        for (int i = 0; i < numberOfShards; i++) {
        clusterState.routingTable(routingTableBuilder.build());
        try {
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
            String term = randomAlphaOfLength(10);
        for (Map.Entry<String, Integer> entry : termToShard.entrySet()) {
 * not use this file except in compliance with the License.
                } else {
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
                "node_" + zone + i,
        }
        discoveryNodeMap.put("b", nodesZoneB);
import org.opensearch.cluster.deployment.DeploymentMetadata;
                        .build()
            // Verify default preference is primary only
        shardChoice = groupIterator.get(0).nextOrNull();
        try {
        routingC.put("c_2", 3);
            threadPool = new TestThreadPool("testSearchReplicaDefaultRouting");
                        shardSet.add(OperationRouting.generateShardId(metadata, id, routing));
        // Adding more load to node_a0 and node_a1 from zone-a
            PreferenceBasedSearchNotAllowedException.class,
            IndexShardRoutingTable indexShardRoutingTable = state.getRoutingTable().index(indexName).getShards().get(0);
        final int numShards = 3;
                assertTrue("Only primary should exist with no preference", shardIterator.nextOrNull().primary());
import org.opensearch.common.settings.Settings;
            indexNames[i] = "test" + i;
        nodesZoneA.add(allNodes[0]);
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
        final int numShards = 1;
                .build();
                    position++;
        routingC.put("c_4", 0);
            indexNames,
                .build();
        }
                    );
            state,
            state = setWeightedRoutingWeights(state, weights);
                } else {
        // Now let's start adding node metrics, since that will affect which node is chosen. Adding more load to node_b2
        ThreadPool threadPool = null;
            int shrunkShard = OperationRouting.generateShardId(shrunk, term, null);
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
        );
    }
                .settings(
                assertNotEquals("Shard should not be on drained node", nodeA0.getId(), shard.currentNodeId());
            "node_a1",
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
                } else {
        TestThreadPool threadPool = null;
        );
            // Update the index config within the cluster state to modify the index to a partial index
        }
            IOUtils.close(clusterService);
        routingC.put("c_5", 1);
        nodesZoneB.add(allNodes[2]);
            List<ShardRouting> searchedShards = new ArrayList<>(numShards);
                if (warmIndex.equals(shardIterator.shardId().getIndexName())) {
        ThreadPool threadPool = null;
        List<DiscoveryNode> nodesZoneB = discoveryNodeMap.get("b");
        try {
        routingA.put("a_1", 2);
        termToShard.put("EquPtdKaBZ", 4);
        discoveryNodeMap.put("c", nodesZoneC);
        Map<String, Integer> routingC = new HashMap<>();
            for (int i = 0; i < count; i++) {
            if (sessionsfirstSearch == null) {
        int numberOfReplicas,
                    assertEquals(partitionSize, shardSet.size());
        // The first index is a partial index
        );
    }
        List<DiscoveryNode> nodesZoneC = new ArrayList<>();
        termToShard.put("wRZXPSoEgd", 3);
        termToShard.put("mFohLeFRvF", 4);
        GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(
        routingIdToShard.put("c", routingC);
            terminate(threadPool);
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                    nodes.add(shards.get(position).currentNodeId());
        );
        }
        selectedNodes.add(secondChoice.currentNodeId());
            );
        final int numReplicas = 2;
        routingD.put("d_3", 4);
        ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(indexNames, numShards, numReplicas);
                OpenSearchTestCase.buildNewFakeTransportAddress(),
            allNodes[i++] = node;
        for (String zone : zones) {
        final String[] indexNames = new String[numIndices];
        Map<String, List<DiscoveryNode>> discoveryNodeMap
        ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(indexNames, numShards, numReplicas);
    }
            final List<ShardRouting> shards = clusterService.state().getRoutingNodes().assignedShards(new ShardId(index, 0));
            IndexMetadata remoteSnapshotIndexMetadata = IndexMetadata.builder(remoteSnapshotIndex)
            routingTableBuilder.add(indexRoutingTableBuilder.build());
            ClusterServiceUtils.setState(clusterService, builder);
                .put(searchableSnapshotIndexMetadata, false)
        routingB.put("b_1", 0);
                    .numberOfReplicas(1)
                setting,
        TestThreadPool threadPool = new TestThreadPool("testThatOnlyNodesSupportNodeIds");
            boolean weighAwayNodesInUndefinedZone = true;
            for (int i = 0; i < numberOfShards; i++) {
        selectedNodes.add(firstChoice.currentNodeId());
            for (String nodeID : selectedNodes) {
        for (int i = 0; i < numIndices; i++) {
            .settings(settings(Version.CURRENT))
            // all cases.
        // node_a0 or node_a1 should be the lowest ranked node to start
        } finally {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
        final int numReplicas = 1;
        ClusterState.Builder clusterState = ClusterState.builder(state);
            IndexMetadata metadata = IndexMetadata.builder("test")
import java.util.TreeMap;
            }
                    weighAwayNodesInUndefinedZone = false;
            assertNotNull(shardId);
                final List<ShardRouting> only = new ArrayList<>();
        }
        final String[] indexNames = { "test0", "test1" };
        searchedShards.add(secondChoice);
        TestThreadPool threadPool = null;
            ClusterServiceUtils.setState(clusterService, ClusterState.builder(state));
        );
        // each shard ID doesn't pick the same node.
import java.util.Set;
        routingA.put("a_5", 2);
                );
    }
        }
                    assertTrue(
                assertFalse("Returned shard should be a replica", shardIterator.nextOrNull().primary());
            split = IndexMetadata.builder("test")
        assertThat(groupIterator.size(), equalTo(numIndices * numShards));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        termToShard.put("chZXraUPBH", 7);
        final String indexName = "test";
                    .build();
        List<ShardRouting> searchedShards = new ArrayList<>(numShards);
                        ShardRoutingState.STARTED
                ).getShards(clusterService.state(), indexName, 0, "_only_nodes:" + String.join(",", nodes));
                indexNames,
    public void testPartialIndexPrimaryDefault() throws Exception {
            for (ShardIterator shardIterator : groupIterator) {
                assertEquals("We should have all 6 shards returned", shardIterator.size(), 6);
            "node_b0",
        clusterState.routingTable(routingTableBuilder.build());
                        .put(SETTING_VERSION_CREATED, Version.CURRENT)
 * under the License.
            // Ideally we would test for greater levels of machine utilisation
        opRouting.setUseAdaptiveReplicaSelection(true);
        termToShard.put("YePigbXgKb", 1);
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, null);
        Set<String> nodeIds = new HashSet<>();
        routingB.put("b_2", 0);
                    Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
        termToShard.put("EZmDicyayC", 0);
 * Modifications Copyright OpenSearch Contributors. See
                    assertNotNull(shardRouting);
        ShardRouting thirdChoice = groupIterator.get(0).nextOrNull();
    }
        terminate(threadPool);
                ? OperationRouting.generateShardId(metadata, key, null)
            IndexRoutingTable.Builder indexShardRoutingBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
                while (it.remaining() > 0) {
        termToShard.put("agYhXYUUpl", 7);
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
        termToShard.put("CEmLmljpXe", 5);
        Map<String, Integer> termToShard = new TreeMap<>();
            // A search with no caller-supplied preference must not be rejected by the strict weighted
        termToShard.put("VLxKRKdLbx", 4);
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        ShardRouting firstChoice = groupIterator.get(0).nextOrNull();
        // and even more
                .setRoutingNumShards(shardSplits[2])
                Version.CURRENT
        ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);
            shrunkShard = OperationRouting.generateShardId(shrunk, term, null);
        final int numSearchReplicas = 2;
                .numberOfShards(shardSplits[0])
            buildNewFakeTransportAddress(),
        routingA.put("a_4", 1);
                assertFalse("Returned shard should be a replica", shardIterator.nextOrNull().primary());
            Set<String> selectedNodes = new HashSet<>();
                        .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
                "node_" + zone + "_" + i,
        DiscoveryNode clusterManager = new DiscoveryNode(
            final int shard = OperationRouting.generateShardId(metadata, term, null);
            );
            "cluster-manager",
        // node 1 starts getting more loaded...
                .numberOfReplicas(1)
        }
        }
        for (String zone : zones) {
            outstandingRequests,
                .metadata(metadataBuilder.build())
            threadPool = new TestThreadPool("testWarmIndexSearchNotBlockedByStrictWeightedRouting");
            );
            ClusterState.Builder builder = ClusterState.builder(state);
            IOUtils.close(clusterService);
            }
            assertTrue(opRouting.ignoreAwarenessAttributes());
        termToShard.put("cnepjZhQnb", 3);
                .numberOfReplicas(1)
    public void testFairSessionIdPreferences() throws InterruptedException, IOException {
                Settings.builder().build(),
        routingC.put("c_2", 0);
        termToShard.put("PGgHcLNPYX", 7);
     */
        Map<String, Integer> routingB = new HashMap<>();
        );
        routingTableBuilder.add(indexRoutingTableBuilder.build());
                    // The injected preference must not leak into the other indices of the same request:
        final int numIndices = 1;
            .numberOfReplicas(1)
        return indexShard.activeInitializingShardsIt(routingHash);
import static org.hamcrest.Matchers.greaterThan;
        List<DiscoveryNode> nodesZoneA = new ArrayList<>();
        } finally {
        termToShard.put("zKBMYJDmBI", 0);
                .build();
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
        final int numReplicas = 2;
        int numberOfShards = 2;
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
import org.opensearch.cluster.node.DiscoveryNode;
        routingD.put("d_3", 3);
        routingA.put("a_0", 3);
                    );
                    expected.add(shards.get(position));
                indexShardRoutingBuilder.addShard(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
            Settings.EMPTY,
            IOUtils.close(clusterService);
                    indexShardRoutingBuilder.addShard(
        routingB.put("b_0", 5);
    }
    // Regression test to ignore awareness attributes. This test creates shards in different zones and simulates stress
                    assertTrue("Primary should be returned first for the warm index", shardIterator.nextOrNull().primary());
        routingA.put("a_3", 2);
        termToShard.put("KXuNWWNgVj", 2);
        Metadata.Builder metadataBuilder = Metadata.builder();
        termToShard.put("YmscwrKSpB", 0);
        ShardRouting shardChoice = groupIterator.get(0).nextOrNull();
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
            metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
            // search shards call
        ClusterService clusterService = null;
        IOUtils.close(clusterService);
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata())
        termToShard.put("OqbFNxrKrF", 2);
                .build();
        termToShard.put("LnqSYezXbr", 5);
        opRouting.setUseAdaptiveReplicaSelection(true);
            ClusterState state = clusterStateForWeightedRouting(indexNames, numShards, numReplicas);
    }
        }
                        .put(state.metadata().index(searchableSnapshotIndex).getSettings())
        // Test that the shards use a round-robin pattern when there are no stats
        state = updateStatetoTestWeightedRouting(indexNames, numShards, numReplicas, state, discoveryNodeMap);
            state = ClusterState.builder(state).metadata(metadataBuilder.build()).build();
        WeightedRouting weightedRouting = new WeightedRouting("zone", Map.of("a", 1.0, "b", 1.0, "c", 0.0));
            );
            for (String nodeID : selectedNodes) {
        termToShard.put("nbZWPWJsIM", 0);
            // Setting up weights for weighted round-robin in cluster state
            weights = Map.of("a", 0.0, "b", 1.0);
            final int shard = OperationRouting.generateShardId(metadata, term, null);
            threadPool = new TestThreadPool("testThatOnlyNodesSupportNodeIds");
        ClusterState state = ClusterStateCreationUtils.state(allNodes[0], allNodes[3], allNodes);
                // shard from nodes in zone a is not selected since its weight is 0
        routingIdToShard.put("a", routingA);
            IndexShardRoutingTable.Builder shardBuilder = new IndexShardRoutingTable.Builder(new ShardId(index, "_na_", i));
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "foo")
        routingHash = 31 * routingHash + indexShard.shardId.hashCode();
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
            IndexMetadata metadata = IndexMetadata.builder("test")
                )
                assertThat(shardIterator.size(), equalTo(numReplicas + 1));
    }
                    // Assign all the replicas on nodes in zone-b (node_b2)
                    weighAwayNodesInUndefinedZone = false;
        assertThat(groupIterator.get(0).size(), equalTo(numReplicas + 1));
                    .settings(settings(Version.CURRENT))
                        TestShardRouting.newShardRouting(index, i, nodeId, null, false, ShardRoutingState.STARTED)
    private ClusterState setWeightedRoutingWeights(ClusterState clusterState, Map<String, Double> weights) {
        routingC.put("c_1", 4);
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
        routingA.put("a_0", 1);
        // All three shards should have been separate, because there are no stats yet so they're all ranked equally.
    public void testWarmIndexSearchNotBlockedByStrictWeightedRouting() throws Exception {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        DiscoveryNode[] allNodes = new DiscoveryNode[4];
        );
        termToShard.put("NrnSmcnUVF", 2);
            state = setWeightedRoutingWeights(state, weights);
        routingIdToShard.put("b", routingB);
        OperationRouting opRouting = new OperationRouting(
                        .put(state.metadata().index(warmIndex).getSettings())
                .put("cluster.routing.weighted.fail_open", false)
 * the Apache License, Version 2.0 (the "License"); you may
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
 * this file be licensed under the Apache-2.0 license or a
            state,
            }
 *
            collector,
        );
                collector,
                    if (i == shardIterator.size()) {
        termToShard.put("XhfGWwNlng", 1);
                    selectedNodes.add(shardRouting.currentNodeId());
                numShards,
        for (int i = 0; i < numIndices; i++) {
        );
        );
            Settings setting = Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone").build();
            ShardRouting shard;
                .numberOfShards(shardSplits[0])
        Map<String, Integer> routingA = new HashMap<>();
            // Updating weighted round robin weights in cluster state
            final List<ShardRouting> expected = new ArrayList<>();
            ClusterServiceUtils.setState(clusterService, ClusterState.builder(state));
        }
import org.opensearch.cluster.deployment.Deployment;
        shardChoice = groupIterator.get(0).nextOrNull();
            );
                        nodeId = nodesZoneC.get(randomInt(nodesZoneC.size() - 1)).getId();
                new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
        // given identically sorted lists of nodes across all shard IDs
        routingC.put("c_0", 4);
                }
import static org.hamcrest.Matchers.equalTo;
            for (ShardIterator shardIterator : groupIterator) {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        // Updating cluster state with node, index and shard details
                .numberOfReplicas(1)
        ThreadPool threadPool = null;
                .generateClusterUuidIfNeeded();
    }
        termToShard.put("BgfLBXUyWT", 5);
        final String[] indexNames = new String[numIndices];
                setting,
                .build();
                null,
            int[] shardSplits = randomFrom(possibleValues);
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                )
                .settings(settings(Version.CURRENT))
                if (nodeID.contains("b")) {
                .settings(settings(Version.CURRENT))
                Version.CURRENT
                        .put(state.metadata().index(indexName).getSettings())
        }
            for (String nodeID : selectedNodes) {
        assertNotNull(secondChoice);
        routingB.put("b_3", 0);
        collector.addNodeStatistics("node_a0", 1, TimeValue.timeValueMillis(50).nanos(), TimeValue.timeValueMillis(50).nanos());
        for (int i = 0; i < numIndices; i++) {
            shardIds = IndexMetadata.selectShrinkShards(shrunkShard, metadata, shrunk.getNumberOfShards());
            IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        );
            final Index index = clusterService.state().metadata().index(indexName).getIndex();
        assertTrue(opRouting.ignoreAwarenessAttributes());
            buildNewFakeTransportAddress(),
            groupIterator = opRouting.searchShards(state, indexNames, null, "_replica");
                TestShardRouting.newShardRouting(shardId, node.getId(), null, false, true, ShardRoutingState.INITIALIZING, null)
                }
            .build();
        ResponseCollectorService collector = new ResponseCollectorService(clusterService);
        }
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
        assertThat(groupIterator.get(0).size(), equalTo(numReplicas + 1));
        outstandingRequests.put("node_a1", 1L);
        // Without drain: shards on both zones
                .numberOfShards(shardSplits[2])
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
            state = ClusterState.builder(state)
        final int numReplicas = 2;
                .settings(settings(Version.CURRENT))
            shrunk = IndexMetadata.builder("test")
                    }
                assertThat("Replica shards will be returned", shardIterator.size(), equalTo(numReplicas));
        termToShard.put("xpRkJPWVpu", 2);
            for (Map.Entry<String, Integer> idEntry : routingIdEntry.getValue().entrySet()) {
    public void testPreferNodes() throws InterruptedException, IOException {
        metadataBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
                Settings.EMPTY,
import org.opensearch.common.SuppressForbidden;
            String routing = routingIdEntry.getKey();
        deployments.put("dep-1", new Deployment(DeploymentState.DRAIN, Map.of("zone", "a")));
                .generateClusterUuidIfNeeded();
                indexShardRoutingBuilder.addShard(
                    .numberOfShards(shards)
    // Regression test for the routing logic - implements same hashing logic
        for (int i = 0; i < 10; i++) {
        final int numShards = 1;
            "node_a0",
        termToShard.put("xkWaPcCmpT", 0);
        int numberOfShards,
        termToShard.put("imoydNTZhV", 1);
        routingD.put("d_0", 2);
}
                for (int replica = 0; replica < numberOfReplicas; replica++) {
                        i,
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        int numberOfReplicas,
                .numberOfReplicas(1)
        metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
                    assertThat("All shard copies should be returned for a regular index", shardIterator.size(), equalTo(1 + numReplicas));
            buildNewFakeTransportAddress(),
                // No shards are assigned to nodes in zone c since its weight is 0
        }
     */
        termToShard.put("RuLzobYixn", 2);
        final int numShards = 2;
        ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG;
            threadPool = new TestThreadPool("testSearchableSnapshotPreference");
            opRouting = new OperationRouting(setting, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
                .settings(
            awarenessSetting,
    }
                numSearchReplicas
        termToShard.put("AITyyoyLLs", 4);
import org.opensearch.cluster.node.DiscoveryNodeRole;
        termToShard.put("ZSzFcbpDqP", 3);
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        routingB.put("b_3", 0);
        final int numShards = 2;
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
            .build();
            null
                        .build()
        final int numReplicas = 2;
 *
        termToShard.put("yIEfZrYfRk", 5);
        routingB.put("b_2", 0);
        TestThreadPool threadPool = null;
                all.add(shard);
            Settings setting = Settings.builder()
            Settings.builder()
            ShardRouting shard = it.nextOrNull();
                );
                    nodes.add("missing_" + i);
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            OperationRouting opRouting = new OperationRouting(
            Version.CURRENT
                }
            ResponseCollectorService collector = new ResponseCollectorService(clusterService);
                .build();
                .metadata(metadataBuilder.build())
        routingIdToShard.put("c", routingC);
            null,
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
                if (randomBoolean() && !shards.get(position).initializing()) {
        final int numSearchReplicas = 2;
        try {
        routingB.put("b_5", 3);
        termToShard.put("zBjjNEjAex", 2);
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            }
            Set<String> selectedNodes = new HashSet<>(numShards);
            // Verify default preference is primary only
            IndexMetadata partialIndexMetadata = IndexMetadata.builder(indexName)
        }
    public void testGenerateShardIdSplit() {
            }
        termToShard.put("wsNavvIcdk", 7);
            groupIterator = opRouting.searchShards(state, indexNames, null, "_replica");
    }
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata()).put(indexMetadata, false).generateClusterUuidIfNeeded();
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
        collector.addNodeStatistics("node_b2", 40, TimeValue.timeValueMillis(250).nanos(), TimeValue.timeValueMillis(250).nanos());
        String sessionKey = randomAlphaOfLength(10);
                .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final int numIndices = randomIntBetween(1, 3);
            assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
        termToShard.put("nICGuWTdfV", 0);
        final int numIndices = 2;
                setting,
     * Ensures that all changes to the hash-function / shard selection are BWC
import org.opensearch.cluster.metadata.Metadata;
    public void testAdaptiveReplicaSelection() throws Exception {
        assertThat(groupIterator.size(), equalTo(numIndices * numShards));
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata())
            ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(indexNames, numShards, numReplicas);
import java.util.Collections;
        assertNotNull(firstChoice);
            Set<String> selectedNodes = new HashSet<>();
        assertTrue(selectedNodes.contains("node_a0") || selectedNodes.contains("node_a1"));
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        int i = 0;
                assertThat("Only single shard will be returned with no preference", shardIterator.size(), equalTo(1));
import org.opensearch.common.unit.TimeValue;
        ClusterService clusterService = null;
package org.opensearch.cluster.routing;
    // by ignoring the zone awareness attributes.
        termToShard.put("qCChjGZYLp", 3);
            ShardId shardId = IndexMetadata.selectSplitShard(shrunkShard, metadata, split.getNumberOfShards());
    }
            buildNewFakeTransportAddress(),
        }
            }
    public void testStrictWeightedRoutingExemptsOnlyServerInjectedPreferences() {
                    selectedNodes.add(shardRouting.currentNodeId());
import static java.util.Collections.singletonMap;
            IndexMetadata warmIndexMetadata = IndexMetadata.builder(warmIndex)
            collector,
                        e,
        termToShard.put("YHicpFBSaY", 1);
        } finally {
                assertNotNull(firstChoice);
            indexNames[i] = "test" + i;
        state = ClusterState.builder(state).metadata(metadataBuilder).routingTable(routingTableBuilder.build()).build();
                .put(remoteSnapshotIndexMetadata, false)
        termToShard.put("cyQIvDmyYD", 7);
                if (nodes.size() == 1) {
            final Set<ShardRouting> preferred = new HashSet<>();
        termToShard.put("eDzIfMKbvk", 1);
                numReplicas,
            terminate(threadPool);
                    if (replica == 0) {
        Map<String, Map<String, Integer>> routingIdToShard = new HashMap<>();
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
            }
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(
                .build();
                IndexMetadata metadata = IndexMetadata.builder("test")
        final String searchableSnapshotIndex = indexNames[0];
        termToShard.put("IsSZQwwnUT", 3);
                    nodes.add("missing_" + i);
            IOUtils.close(clusterService);
    public void testWeightedOperationRoutingWeightUndefinedForOneZone() throws Exception {
        ResponseCollectorService collector = new ResponseCollectorService(clusterService);
        ClusterState state
                        .put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
        List<DiscoveryNode> nodesZoneB = new ArrayList<>();
                    String routing = randomUnicodeOfLengthBetween(1, 50);
                nodeIds.add(shard.currentNodeId());
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            // tests shards are assigned to nodes in zone c
            indexNames,
            final List<String> nodes = new ArrayList<>();
                }
        Map<String, Integer> routingD = new HashMap<>();
            int shard = randomBoolean()
        // subsequent searches and that the nodes are selected fairly i.e.
        assertThat(groupIterator.size(), equalTo(numIndices * numShards));
            for (int i = 0; i < count; i++) {
            opRouting.setStrictSearchOnlyShardRouting(false);
        }
                )
        ShardRouting secondChoice = groupIterator.get(0).nextOrNull();
                OpenSearchTestCase.buildNewFakeTransportAddress(),
                .setRoutingNumShards(shardSplits[0])
                } else {
public class OperationRoutingTests extends OpenSearchTestCase {
                assertThat(new HashSet<>(only), equalTo(new HashSet<>(expected)));
        // add weighted routing weights in metadata
            // tests that no shards are assigned to zone with weight zero
            assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
        collector.addNodeStatistics("node_a1", 100, TimeValue.timeValueMillis(300).nanos(), TimeValue.timeValueMillis(250).nanos());
            }
        Map<String, Integer> routingC = new HashMap<>();
            terminate(threadPool);
            String key = entry.getKey();
        termToShard.put("zXAamKsRwj", 2);
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                buildNewFakeTransportAddress(),
            );
        } finally {
        final int numShards = 2;
        selectedNodes.add(secondChoice.currentNodeId());
        collector.addNodeStatistics("node_1", 1, TimeValue.timeValueMillis(100).nanos(), TimeValue.timeValueMillis(50).nanos());
    }
                if (randomBoolean() && !shards.get(position).initializing()) {
            opRouting = new OperationRouting(setting, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
            IndexMetadata shrunk = IndexMetadata.builder("test")
        return allNodes;
        termToShard.put("yNjiAnxAmt", 5);
            IndexMetadata split = IndexMetadata.builder("test")
            state = setWeightedRoutingWeights(state, weights);
            Map<String, Long> outstandingRequests = new HashMap<>();
                    Settings.builder()
            for (ShardIterator it : groupIterator) {
        GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(
        termToShard.put("cuNKtLtyJQ", 7);
            IOUtils.close(clusterService);
                    .routingPartitionSize(partitionSize)
    }
        collector.addNodeStatistics("node_1", 3, TimeValue.timeValueMillis(250).nanos(), TimeValue.timeValueMillis(200).nanos());
            ShardId shardId = indexShardRoutingTable.searchOnlyReplicas().get(0).shardId();
            IOUtils.close(clusterService);
                .numberOfReplicas(2)
    private DiscoveryNode[] setUpNodesForWeightedRouting() {
            ResponseCollectorService collector = new ResponseCollectorService(clusterService);
            Map<String, Double> weights = Map.of("a", 1.0, "c", 0.0);
                .put(partialIndexMetadata, false)
            IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
                .put("cluster.routing.allocation.awareness.attributes", "zone")
            .numberOfShards(8)
            }
        );
import org.opensearch.node.ResponseCollectorService;
            () -> opRouting.checkPreferenceBasedRoutingAllowed(Preference.PREFER_NODES, weightedRoutingMetadata, false)
        nodesZoneC.add(allNodes[5]);
            indexShardRoutingBuilder.addShard(
            assertFalse(weighAwayNodesInUndefinedZone);
        final String[] indexNames = new String[numIndices];
        allNodes[i] = clusterManager;
        } finally {
            );
            OperationRouting opRouting = new OperationRouting(
            OperationRouting opRouting = new OperationRouting(
                singletonMap("zone", zone),
                );
            int position = 0;
            OperationRouting opRouting = new OperationRouting(
        IndexMetadata metadata = IndexMetadata.builder("test")
        termToShard.put("xvIGbRiGJF", 3);
                .put(warmIndexMetadata, false)
                            containsString("no data nodes with criterion [" + String.join(",", nodes) + "] found for shard: [test][0]")
            DiscoveryNode node = new DiscoveryNode(
                assertThat("Replica shards will be returned", shardIterator.size(), equalTo(numReplicas));
        for (String index : indices) {
        final int numReplicas = 2;
        termToShard.put("ngizYtQgGK", 5);
            Version.CURRENT
    private ShardIterator duelGetShards(ClusterState clusterState, ShardId shardId, String sessionId) {
                    TestShardRouting.newShardRouting(
                .build();
        final String[] indexNames = new String[numIndices];
            indexNames[i] = "test" + i;
        termToShard.put("JAYDZMRcpW", 4);
            singletonMap("zone", "b"),
                assertNotEquals("Shard should not be on drained node", nodeA1.getId(), shard.currentNodeId());
        String[] indices,
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
            metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
            weights = Map.of("a", 1.0, "b", 0.0, "c", 1.0);
        termToShard.put("EzHgydDCSR", 3);
                )
        OperationRouting opRouting = new OperationRouting(
        termToShard.put("EBzEDAPODe", 2);
            final List<ShardRouting> shards = clusterService.state().getRoutingNodes().assignedShards(new ShardId(index, 0));
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
            // tests no shards are assigned to nodes in zone c
        List<ShardRouting> sessionsfirstSearch = null;
                .settings(
            assertEquals(shard, shardId.getId());
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        termToShard.put("ZSKjhJlcpn", 1);
        termToShard.put("czSljcjMop", 5);
        final int numIndices = 4;
        clusterState.metadata(metadataBuilder);
            OperationRouting opRouting = new OperationRouting(
        ClusterService clusterService = null;
import org.opensearch.cluster.ClusterState;
                final ShardIterator it = new OperationRouting(
                Settings.EMPTY,
 */
        termToShard.put("kTwZnPEeIi", 2);
        assertThat(groupIterator.get(0).size(), equalTo(numReplicas + 1));
                .put(OperationRouting.STRICT_WEIGHTED_SHARD_ROUTING_ENABLED.getKey(), true)
        // Updates cluster state by assigning shard copies on nodes
            preferred.addAll(all.subList(0, expected.size()));
        } finally {
            // tests shards are assigned to nodes in zone b
            selectedNodes = new HashSet<>();
        // finally, node 2 is chosen instead
    @SuppressForbidden(reason = "feature flag overrides")
        collector.addNodeStatistics("node_2", 1, TimeValue.timeValueMillis(200).nanos(), TimeValue.timeValueMillis(200).nanos());
        routingC.put("c_1", 1);
/*
            shardId = IndexMetadata.selectSplitShard(shrunkShard, metadata, split.getNumberOfShards());
            assertTrue(opRouting.ignoreAwarenessAttributes());
        final int numShards = randomIntBetween(2, 10);
        ClusterService clusterService = null;
            for (int partitionSize = 1; partitionSize == 1 || partitionSize < shards; partitionSize++) {
        outstandingRequests.put("node_a0", 1L);
        final int numIndices = 1;
    }
import org.opensearch.threadpool.TestThreadPool;
        // Drain zone-a
            } else {
        assertTrue(nodeIds.contains(nodeA0.getId()));
            Collections.emptyMap(),
        termToShard.put("tFyVdQauWR", 6);
        return clusterState.build();
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
import java.util.HashSet;
                        )
        Map<String, Long> outstandingRequests = new HashMap<>();
            assertEquals(shardSplits[1], (shardSplits[1] * shardSplits[2]) / shardSplits[2]);
        termToShard.put("aqGsrUPHFq", 5);
        termToShard.put("rPIdESYaAO", 5);
        termToShard.put("upLDybdTGs", 5);
            indexNames[i] = "test" + i;
        }
                assertFalse(nodeID.contains("b"));
            final String indexName = "test";
        termToShard.put("FKKTOnJMDy", 7);
 * license agreements. See the NOTICE file distributed with
                null,
        termToShard.put("cWpKJjlzgj", 7);
        routingIdToShard.put("d", routingD);
        termToShard.put("bVDJDCeaFm", 2);
                }
    }
                // No shards are assigned to nodes in zone b since its weight is 0
import java.util.HashMap;
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    public void testServerInjectedPreferenceDoesNotLeakAcrossIndices() throws Exception {
        }
        for (int i = 0; i < numIndices; i++) {
            indexNames[i] = "test" + i;
        ThreadPool threadPool = null;
            OperationRouting opRouting = new OperationRouting(
    /**
        routingD.put("d_4", 3);
            state = setWeightedRoutingWeights(state, weights);
                .build();
        } finally {
                .setRoutingNumShards(shardSplits[2])
            }
        expectThrows(
        termToShard.put("KWimwsREPf", 4);
                String id = idEntry.getKey();
        // Since the primary shards are divided randomly between node_a0 and node_a1
            int position = 0;
import org.opensearch.common.util.io.IOUtils;
        // node 1 should be the lowest ranked node to start
    ) {
        groupIterator.forEach(shardRoutings -> assertThat(shardRoutings.nextOrNull().currentNodeId(), containsString("node_b")));
        List<String> zones = Arrays.asList("a", "a", "b");
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            }
            // Updating weighted round-robin weights in cluster state
            assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
            state = ClusterState.builder(state)
        termToShard.put("MGlxLFyyCK", 3);
        assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
                null,
        collector.addNodeStatistics("node_0", 2, TimeValue.timeValueMillis(200).nanos(), TimeValue.timeValueMillis(150).nanos());
                .settings(
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
                    ShardRouting shardRouting = it.nextOrNull();
                }
        TestThreadPool threadPool = new TestThreadPool("testThatOnlyNodesSupport");
            // Verify alternative preference can be applied to a searchable snapshot index
        routingD.put("d_2", 3);
                }
        String index = "test_drain";
        final int numReplicas = randomIntBetween(1, 3);
        for (ShardIterator it : drainedIterator) {
import static org.hamcrest.object.HasToString.hasToString;
import org.opensearch.test.OpenSearchTestCase;
        final String indexName = indexNames[0];
            weighAwayNodesInUndefinedZone = true;
                final ClusterService cs = clusterService;
        routingB.put("b_1", 0);
            shardBuilder.addShard(TestShardRouting.newShardRouting(index, i, nodeA0.getId(), null, true, ShardRoutingState.STARTED));
import org.opensearch.cluster.deployment.DeploymentState;
                    Settings.EMPTY,
        termToShard.put("uFZyTyOMRO", 4);
            assertEquals(shard, entry.getValue().intValue());
        OperationRouting opRouting = new OperationRouting(
        ClusterService clusterService = null;
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
                assertFalse(nodeID.contains("c"));
    private ClusterState updateStatetoTestARS(
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata()).put(indexMetadata, false).generateClusterUuidIfNeeded();
        Set<String> selectedNodes = new HashSet<>(numShards);
import org.opensearch.index.IndexModule;
        final int numShards = 1;
        routingD.put("d_1", 2);
        termToShard.put("kblouyFUbu", 7);
                state,
                        shardIterator.nextOrNull().isSearchOnly()
        routingD.put("d_1", 4);
        // setting up indices
            for (ShardIterator shardIterator : groupIterator) {
        for (String index : indices) {
        int numberOfShards,
                for (int i = 0; i < 20; i++) {
                assertEquals(shard, OperationRouting.generateShardId(metadata, id, routing));
                .setRoutingNumShards(shardSplits[2])
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
            // 2 is the bare minimum number of nodes we can reliably expect from
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, null);
                final IllegalArgumentException e = expectThrows(
            }
import static org.hamcrest.Matchers.containsInAnyOrder;
            indexNames[i] = "test" + i;
            );
        final int numIndices = 1;
                }
                TestShardRouting.newShardRouting(shardId, node.getId(), null, false, true, ShardRoutingState.INITIALIZING, null)
        // make sure the same routing value always has each _id fall within the configured partition size
    }
        outstandingRequests.put("node_2", 1L);
                for (ShardRouting shardRouting : shardRoutings) {
        } finally {
    public void testAllocationAwarenessDeprecation() {
        final String[] indexNames = new String[numIndices];
import org.opensearch.core.index.Index;
            for (ShardIterator shardIterator : groupIterator) {
            threadPool = new TestThreadPool("testPreferNodes");
            for (String nodeID : selectedNodes) {
        DiscoveryNode[] allNodes = setUpNodesForWeightedRouting();
            .build();
        final int numShards = 1;
                .numberOfShards(shardSplits[1])
        for (int i = 0; i < 10; i++) {
            OperationRouting opRouting = new OperationRouting(
        return state;
                    () -> new OperationRouting(
                        .build()
                if (remoteSnapshotIndex.equals(shardIterator.shardId().getIndexName())) {
            OperationRouting opRouting = new OperationRouting(
            // search shards call
                null,
                indexNames,
        // setting up indices
        termToShard.put("OKCmuYkeCK", 6);
                )
                }
            while (shard != null) {
        final String remoteSnapshotIndex = indexNames[0];
            final GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, sessionKey);
                }
            for (ShardIterator it : groupIterator) {
        ClusterState state,
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                    for (int k = 0; k < 150; k++) {
        assertThat(shardChoice.currentNodeId(), equalTo("node_1"));
        termToShard.put("PDOQQqgIKE", 1);
            .setRoutingNumShards(8)
            for (ShardIterator shardIterator : groupIterator) {
        final int numIndices = 2;
        int routingHash = Murmur3HashFunction.hash(sessionId);
            groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
        // Adding more load to node_a0
            }
        termToShard.put("PeGJjomyik", 3);
        final String[] indexNames = new String[numIndices];
        routingA.put("a_2", 2);
            }
        routingA.put("a_3", 3);
            // Setting up weights for weighted round-robin in cluster state, weight for nodes in zone b is not set
                ShardRouting duelFirst = duelGetShards(state, firstChoice.shardId(), sessionKey).nextOrNull();
        ClusterState state = ClusterStateCreationUtils.state(allNodes[0], allNodes[6], allNodes);
                List<ShardRouting> shardRoutings = Collections.singletonList(it.nextOrNull());
                    // they should route across all active shard copies
        );
                // Assign all the primary shards on nodes in zone-a (node_a0 or node_a1)
        for (int i = 0; i < numIndices; i++) {
                    assertNotNull(shardRouting);
                numSearchReplicas
        for (int i = 0; i < numIndices; i++) {
                null
            indexNames[i] = "test" + i;
 * Licensed to Elasticsearch under one or more contributor
        termToShard.put("RiBbcCdIgk", 4);
        }
            state = setWeightedRoutingWeights(state, weights);
                    only.add(shard);
                .numberOfSearchReplicas(3)
        termToShard.put("nVAZVMPNNx", 3);
            );
            threadPool = new TestThreadPool("testServerInjectedPreferenceDoesNotLeakAcrossIndices");
        final String[] indexNames = new String[numIndices];
            Map<String, Long> outstandingRequests = new HashMap<>();
            assertThat(all.size(), equalTo(shards.size()));
        try {
        );
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            ClusterState state = clusterStateForWeightedRouting(indexNames, numShards, numReplicas);
            // verify all the shards are there
                        .build()
            assertEquals(shardSplits[0], (shardSplits[0] * shardSplits[1]) / shardSplits[1]);
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            for (ShardIterator it : groupIterator) {
                    assertThat(
        }
            // Verify alternative preference can be applied to a partial index
    public void testThatOnlyNodesSupportNodeIds() throws InterruptedException, IOException {
        DiscoveryNode nodeB1 = new DiscoveryNode(
            IOUtils.close(clusterService);
        // and more loaded...
                // shard from nodes in zone c is not selected since its weight is 0
        int[][] possibleValues = new int[][] { { 8, 4, 2 }, { 20, 10, 2 }, { 36, 12, 3 }, { 15, 5, 1 } };
            if (expected.size() > 0) {
                    }
        for (int i = 0; i < numRepeatedSearches; i++) {
            assertThat("Search should use more than one of the nodes", selectedNodes.size(), greaterThan(1));
        DiscoveryNode nodeB0 = new DiscoveryNode(
        List<DiscoveryNode> nodesZoneA = discoveryNodeMap.get("a");
        assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
/*
            );
        IndexMetadata metadata = IndexMetadata.builder("test")
            Settings setting = Settings.builder()
            .numberOfReplicas(1)
            "cluster-manager",
        // All the shards should be ranked equally since there are no stats yet
                assertFalse(nodeID.contains("c"));
                .generateClusterUuidIfNeeded();
            selectedNodes = new HashSet<>();
                assertEquals(shard, OperationRouting.generateShardId(metadata, id, routing));
                        .put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
    public void testAdaptiveReplicaSelectionWithZoneAwarenessIgnored() throws Exception {
        // ARS should pick node_b2 from zone-b since both node_a0 and node_a1 are overloaded
        routingD.put("d_2", 4);
                indexNames,
                Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
            assertEquals(shard, shardId.getId());
        assertThat(shardChoice.currentNodeId(), equalTo("node_1"));
        try {
            Settings.builder().put(OperationRouting.STRICT_WEIGHTED_SHARD_ROUTING_ENABLED.getKey(), true).build(),
    }
                        TestShardRouting.newShardRouting(index, i, nodes[2].getId(), null, false, ShardRoutingState.STARTED)
                .routingTable(RoutingTable.builder().add(indexShardRoutingBuilder).build())
            // search shards call
import org.opensearch.Version;
            }
        DiscoveryNode nodeA1 = new DiscoveryNode(
        groupIterator.forEach(shardRoutings -> assertThat(shardRoutings.nextOrNull().currentNodeId(), containsString("node_a")));
                sessionsfirstSearch = searchedShards;
        routingIdToShard.put("b", routingB);
            );
        } finally {
                .numberOfShards(shardSplits[1])
            .numberOfReplicas(1)
        selectedNodes.add(firstChoice.currentNodeId());
                outstandingRequests,
            state = ClusterState.builder(state).metadata(metadataBuilder.build()).build();
        shardChoice = groupIterator.get(0).nextOrNull();
        routingD.put("d_5", 3);
        GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, new String[] { index }, null, null);
            assertThat("one group per shard", groupIterator.size(), equalTo(numShards));
                outstandingRequests,
        // Ensure that a user session is re-routed back to same nodes for
            );
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, null);
        final int numReplicas = 2;
        searchedShards.add(secondChoice);
    @SuppressForbidden(reason = "feature flag overrides")
            assertEquals(shardSplits[1], (shardSplits[1] / shardSplits[2]) * shardSplits[2]);
                Collections.emptyMap(),
                    assertTrue("Returned shard should be the primary", shardIterator.nextOrNull().primary());
        final int numReplicas = 2;
            IOUtils.close(clusterService);
        );
