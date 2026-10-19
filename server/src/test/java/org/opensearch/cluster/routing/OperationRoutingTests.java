            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata())
        final int numRepeatedSearches = 4;
                .settings(  
package org.opensearch.cluster.routing;
            IndexMetadata remoteSnapshotIndexMetadata = IndexMetadata.builder(remoteSnapshotIndex)
        );
     * The following setup is created to test ARS
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, null);  
        // All the shards should be ranked equally since there are no stats yet  
            state,
        DiscoveryNode[] allNodes = new DiscoveryNode[] { nodeA0, nodeA1, nodeB0, nodeB1, clusterManager };  
        routingA.put("a_0", 3);  
                .build();
import org.opensearch.cluster.deployment.DeploymentMetadata;
        ResponseCollectorService collector = new ResponseCollectorService(clusterService);
            while (shard != null) {  
            Settings.EMPTY,  
                numShards,
            assertEquals(shardSplits[0], (shardSplits[0] / shardSplits[1]) * shardSplits[1]);
                    expected.add(shards.get(position));
        termToShard.put("mFohLeFRvF", 4);
            }
        int i = 0;
                assertFalse("Returned shard should be a replica", shardIterator.nextOrNull().primary());  
                .put("cluster.routing.allocation.awareness.attributes", "zone")
            singletonMap("zone", "a"),
                new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
                shard = it.nextOrNull();
            // Ideally we would test for greater levels of machine utilisation
                .settings(settings(Version.CURRENT))
            // Verify default preference is primary only
                .settings(Settings.builder().put(state.metadata().index(indexName).getSettings()).build())  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
                numSearchReplicas
        Metadata.Builder metadataBuilder = Metadata.builder();
        termToShard.put("QnFjcpcZUT", 4);
            for (ShardIterator shardIterator : groupIterator) {  
        termToShard.put("bGEIEBLATe", 6);
        List<String> zones = Arrays.asList("a", "a", "b");
            groupIterator = opRouting.searchShards(state, indexNames, null, "_replica");  
                .put(OperationRouting.STRICT_WEIGHTED_SHARD_ROUTING_ENABLED.getKey(), true)
            DiscoveryNode node = new DiscoveryNode(  
            collector,
        ThreadPool threadPool = null;
            );  
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            state = setWeightedRoutingWeights(state, weights);
            // search shards call
            // the preferred shards should be at the front of the list  
                null,
        terminate(threadPool);
        return clusterState.build();  
                }
                .numberOfShards(shardSplits[0])
import org.opensearch.common.SuppressForbidden;
        ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(indexNames, numShards, numReplicas);  
        final String[] indexNames = new String[numIndices];
                if (warmIndex.equals(shardIterator.shardId().getIndexName())) {
        }
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata()).put(indexMetadata, false).generateClusterUuidIfNeeded();
        }  
        final int numIndices = 2;
            DiscoveryNode node = new DiscoveryNode(
        termToShard.put("cnepjZhQnb", 3);  
                // No shards are assigned to nodes in zone c since its weight is 0  
            terminate(threadPool);  
                nodeIds.add(shard.currentNodeId());
                    // Assign all the replicas on nodes in zone-b (node_b2)
                assertThat("Only single shard will be returned with no preference", shardIterator.size(), equalTo(1));
            .build();
        termToShard.put("agYhXYUUpl", 7);
            Set<String> selectedNodes = new HashSet<>(numShards);
            );
                        "Any shard can exist with when cluster.routing.search_replica.strict is set as false",  
                while ((shard = it.nextOrNull()) != null) {
            // Verify default preference is primary only
            ShardId shardId = indexShardRoutingTable.searchOnlyReplicas().get(0).shardId();  
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
        int numberOfShards,
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata())  
        routingD.put("d_2", 4);
        }
import org.opensearch.cluster.service.ClusterService;  
                    }  
                }
                        .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
    private DiscoveryNode[] setupNodes() {
                .build();  
        termToShard.put("aqGsrUPHFq", 5);
            int[] shardSplits = randomFrom(possibleValues);  
import java.util.Arrays;
        deployments.put("dep-1", new Deployment(DeploymentState.DRAIN, Map.of("zone", "a")));
                selectedNodes.add(firstChoice.currentNodeId());  
                        String id = randomUnicodeOfLengthBetween(1, 50);
        for (int i = 0; i < numIndices; i++) {
            // randomized tests in my experiments over thousands of iterations.  
            IndexMetadata warmIndexMetadata = IndexMetadata.builder(warmIndex)
        Map<String, Long> outstandingRequests = new HashMap<>();
            IOUtils.close(clusterService);
                .settings(settings(Version.CURRENT))
 * this file be licensed under the Apache-2.0 license or a
                assertTrue("Only primary should exist with no preference", shardIterator.nextOrNull().primary());  
            singletonMap("zone", "a"),  
                    // Assign all the replicas on nodes in zone-b (node_b2)
        termToShard.put("FKKTOnJMDy", 7);  
        routingD.put("d_5", 3);  
            IOUtils.close(clusterService);
        termToShard.put("nGzpgwsSBc", 4);
                        .put(state.metadata().index(searchableSnapshotIndex).getSettings())
    public void testSearchReplicaRoutingWhenSearchOnlyStrictSettingIsFalse() throws Exception {  
                .generateClusterUuidIfNeeded();
            terminate(threadPool);  
        assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
                List<ShardRouting> shardRoutings = Collections.singletonList(it.nextOrNull());
                        .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
        termToShard.put("wRZXPSoEgd", 3);  
        collector.addNodeStatistics("node_b2", 40, TimeValue.timeValueMillis(250).nanos(), TimeValue.timeValueMillis(250).nanos());  
        for (int i = 0; i < numberOfShards; i++) {
                .settings(
                        shardSet.add(OperationRouting.generateShardId(metadata, id, routing));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final int numIndices = 4;  
        final String[] indexNames = new String[numIndices];
                Version.CURRENT
                setting,  
                .settings(
 * under the License.  
            } else {  
            String term = randomAlphaOfLength(10);  
                    ShardRouting shardRouting = it.nextOrNull();
            OperationRouting opRouting = new OperationRouting(
                .put("cluster.routing.allocation.awareness.attributes", "zone")
        nodesZoneC.add(allNodes[4]);
                numSearchReplicas  
        nodesZoneC.add(allNodes[5]);  
        routingD.put("d_3", 3);
 * license agreements. See the NOTICE file distributed with
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, null);
        }
            final String indexName = "test";
            for (int i = 0; i < count; i++) {
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata()).put(indexMetadata, false).generateClusterUuidIfNeeded();
        // All three shards should have been separate, because there are no stats yet so they're all ranked equally.
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, null);
        List<ShardRouting> searchedShards = new ArrayList<>(numShards);  
            final Index index = clusterService.state().metadata().index(indexName).getIndex();
            final List<String> nodes = new ArrayList<>();
        final int numReplicas = 2;
        );  
                TestShardRouting.newShardRouting(shardId, node.getId(), null, false, true, ShardRoutingState.INITIALIZING, null)
                    for (int k = 0; k < 150; k++) {  
                        .put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
            );
            int shrunkShard = OperationRouting.generateShardId(split, term, null);
                    indexShardRoutingBuilder.addShard(
                outstandingRequests,  
                        nodesZoneA.get(randomInt(nodesZoneA.size() - 1)).getId(),  
        TestThreadPool threadPool = null;
        assertNotNull(secondChoice);
        // and even more  
        ClusterService clusterService = null;  
            for (ShardIterator shardIterator : groupIterator) {  
                .build();
            IOUtils.close(clusterService);  
    }  
            indexNames[i] = "test" + i;
        routingIdToShard.put("d", routingD);
        ClusterState state = ClusterStateCreationUtils.state(allNodes[0], allNodes[3], allNodes);  
            }
                OpenSearchTestCase.buildNewFakeTransportAddress(),
        termToShard.put("PDOQQqgIKE", 1);  
        }
                }
        return clusterState.build();
        DiscoveryNode[] allNodes = new DiscoveryNode[4];
                numReplicas,
            Collections.emptyMap(),
        ThreadPool threadPool = null;  
        termToShard.put("OqbFNxrKrF", 2);
        // The first index is a partial index
import java.util.List;  
                    .numberOfShards(shards)  
            // Weighted shard routing is active with a zero-weight zone (e.g. Multi-AZ with Standby)
        int numberOfShards,
                .numberOfReplicas(1)  
        termToShard.put("IKuOwPjKCx", 5);
                    );
        int numberOfReplicas,  
            IndexRoutingTable.Builder indexShardRoutingBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());  
            Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);  
                    );
            }  
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
                        e,  
        final int numIndices = 2;
            ResponseCollectorService collector = new ResponseCollectorService(clusterService);  
    }
    public void testThatOnlyNodesSupportNodeIds() throws InterruptedException, IOException {
        TestThreadPool threadPool = null;
        for (int i = 0; i < numIndices; i++) {  
                .settings(settings(Version.CURRENT))  
            );
                "node_" + zone + "_" + i,
                assertEquals("We should have 3 shards returned", shardIterator.size(), 3);
 * Modifications Copyright OpenSearch Contributors. See  
            .build();  
                    IllegalArgumentException.class,  
            indexNames[i] = "test" + i;
        );
        routingC.put("c_3", 4);
        termToShard.put("aAMXnamRJg", 7);  
            // search shards call
                } else {  
                Version.CURRENT
        routingB.put("b_5", 3);  
        state = ClusterState.builder(state).metadata(metadataBuilder).routingTable(routingTableBuilder.build()).build();  
            OperationRouting opRouting = new OperationRouting(  
            // 2 is the bare minimum number of nodes we can reliably expect from
                null,  
        }
                setting,
                    // The injected preference must not leak into the other indices of the same request:
            }  
                .put(searchableSnapshotIndexMetadata, false)
            Version.CURRENT
            }
        }
                state,
                } else {
        termToShard.put("wsNavvIcdk", 7);
        ClusterState state,
                        .put(state.metadata().index(indexName).getSettings())  
                .settings(Settings.builder().put(state.metadata().index(indexName).getSettings()).build())
        ClusterState.Builder clusterState = ClusterState.builder(state);  
                        "Only search replicas should exist with preference SEARCH_REPLICA",  
                .put(partialIndexMetadata, false)  
        termToShard.put("yCdyocKWou", 1);  
        termToShard.put("iWswCilUaT", 1);
import static org.hamcrest.Matchers.greaterThan;
     * Ensures that all changes to the hash-function / shard selection are BWC
     */  
                )  
        termToShard.put("eDzIfMKbvk", 1);  
                .numberOfReplicas(1)  
            indexShardRoutingBuilder.addIndexShard(indexShardRoutingTable);
    }
            terminate(threadPool);
        for (Map.Entry<String, Map<String, Integer>> routingIdEntry : routingIdToShard.entrySet()) {
                for (ShardRouting shardRouting : shardIterator) {
    private ClusterState updateStatetoTestARS(  
        termToShard.put("YePigbXgKb", 1);  
        termToShard.put("YmscwrKSpB", 0);
 * The OpenSearch Contributors require contributions made to  
        try {
        final int numShards = 3;
            ClusterServiceUtils.setState(clusterService, ClusterState.builder(state));
        ClusterService clusterService = null;
            threadPool = new TestThreadPool("testPartialIndexPrimaryDefault");
                    );  
        DiscoveryNode clusterManager = new DiscoveryNode(
        WeightedRouting weightedRouting = new WeightedRouting("zone", Map.of("a", 1.0, "b", 1.0, "c", 0.0));  
                .numberOfShards(shardSplits[2])
        selectedNodes.add(thirdChoice.currentNodeId());  
        routingA.put("a_5", 2);  
            state,
            ClusterServiceUtils.setState(clusterService, builder);  
            null
                .setRoutingNumShards(shardSplits[2])
    private DiscoveryNode[] setUpNodesForWeightedRouting() {
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
        assertThat(shardChoice.currentNodeId(), equalTo("node_2"));
import org.opensearch.common.settings.Settings;  
        for (int i = 0; i < numIndices; i++) {
 * compatible open source license.
        ShardRouting secondChoice = groupIterator.get(0).nextOrNull();
 * the Apache License, Version 2.0 (the "License"); you may
        termToShard.put("OutXGRQUja", 5);
                );
                indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());  
                ShardRouting shard;
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
            outstandingRequests,  
        final int numShards = 1;
        final int numIndices = randomIntBetween(1, 3);  
            for (String nodeID : selectedNodes) {
            IndexMetadata split = IndexMetadata.builder("test")
                    TestShardRouting.newShardRouting(  
                } else {
    @SuppressForbidden(reason = "feature flag overrides")
            .settings(settings(Version.CURRENT))
        DiscoveryNode nodeA0 = new DiscoveryNode(  
                while (it.remaining() > 0) {
        assertNotNull(secondChoice);
        termToShard.put("chZXraUPBH", 7);
        termToShard.put("imoydNTZhV", 1);
        assertTrue(selectedNodes.contains("node_b2"));
                Collections.emptyMap(),  
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);  
            int shrunkShard = OperationRouting.generateShardId(shrunk, term, null);
        routingD.put("d_0", 3);  
    public void testSearchableSnapshotPrimaryDefault() throws Exception {
            assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));  
        } finally {
            ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(indexNames, numShards, numReplicas);
 * this work for additional information regarding copyright
        discoveryNodeMap.put("c", nodesZoneC);  
import org.opensearch.test.OpenSearchTestCase;
        nodesZoneA.add(allNodes[0]);  
                    Settings.builder()
        termToShard.put("NrnSmcnUVF", 2);
                    Settings.builder()
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        termToShard.put("uFZyTyOMRO", 4);
        termToShard.put("vdnUhGLFtl", 0);  
            String term = randomAlphaOfLength(10);
        // ARS should pick node_b2 from zone-b since both node_a0 and node_a1 are overloaded
            Version.CURRENT
        // The first index is a remote snapshot index, for which the server injects the _primary preference
                    selectedNodes.add(shardRouting.currentNodeId());
                    }
                assertFalse(nodeID.contains("c"));
                    Set<Integer> shardSet = new HashSet<>();
            );  
                    assertTrue(
            "node_b1",
        collector.addNodeStatistics("node_a0", 1, TimeValue.timeValueMillis(50).nanos(), TimeValue.timeValueMillis(50).nanos());
        final int numReplicas = 2;
                        .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)  
                    // Server-injected _primary preference applies to the remote snapshot index
        routingB.put("b_0", 5);
            selectedNodes = new HashSet<>();
    }
                }  
        final int numShards = 1;  
        DiscoveryNode nodeA1 = new DiscoveryNode(
        routingIdToShard.put("c", routingC);
        String sessionKey = randomAlphaOfLength(10);
            assertTrue(opRouting.ignoreAwarenessAttributes());
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
        routingA.put("a_2", 2);
        searchedShards.add(secondChoice);  
            boolean weighAwayNodesInUndefinedZone = true;
        termToShard.put("FAIcSmmNXq", 5);
import org.opensearch.index.IndexModule;
        collector.addNodeStatistics("node_1", 2, TimeValue.timeValueMillis(200).nanos(), TimeValue.timeValueMillis(150).nanos());
        Map<String, Deployment> deployments = new HashMap<>();  
            null,
                    )
                Settings.builder().build(),  
                assertThat("Regression test failure", duelFirst, equalTo(firstChoice));  
            weights = Map.of("a", 0.0, "b", 1.0);
import org.opensearch.common.unit.TimeValue;
            .routingPartitionSize(3)
        routingC.put("c_2", 0);  
            // add a search replica in initializing state:
    /**
                    assertNotNull(shardRouting);
import java.util.Set;
    }  
                    assertEquals(partitionSize, shardSet.size());  
        for (int i = 0; i < numIndices; i++) {  
            ClusterState state = clusterStateForWeightedRouting(indexNames, numShards, numReplicas);  
        // Since the primary shards are divided randomly between node_a0 and node_a1  
            // tests shards are assigned to nodes in zone b
        termToShard.put("cWpKJjlzgj", 7);
    }
        }
import org.opensearch.cluster.deployment.DeploymentState;
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
                        .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        final String[] indexNames = new String[] { indexName };
        ClusterService clusterService = null;
                Settings.EMPTY,
                        .put(state.metadata().index(remoteSnapshotIndex).getSettings())
            Settings setting = Settings.builder()  
            );
                        .build()
            buildNewFakeTransportAddress(),
            metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
    public void testSearchShardsExcludesDrainedNodes() {
            .metadata(Metadata.builder(state.getMetadata()).putCustom(DeploymentMetadata.TYPE, new DeploymentMetadata(deployments)).build())  
            for (int i = 0; i < numberOfShards; i++) {
        }  
                .numberOfReplicas(2)  
                .settings(settings(Version.CURRENT))  
        Map<String, Integer> routingD = new HashMap<>();  
            null,
    private ClusterState setWeightedRoutingWeights(ClusterState clusterState, Map<String, Double> weights) {  
            IOUtils.close(clusterService);
            IndexMetadata shrunk = IndexMetadata.builder("test")
            Map<String, Double> weights = Map.of("a", 1.0, "c", 0.0);
                }  
import org.opensearch.common.util.io.IOUtils;
            Settings setting = Settings.builder()  
                        .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)
                .build();
            terminate(threadPool);
            IndexMetadata indexMetadata = IndexMetadata.builder(index)
import org.opensearch.cluster.node.DiscoveryNodeRole;
                        true,
        routingC.put("c_1", 1);
            indexShardRoutingBuilder.addShard(
            for (ShardIterator shardIterator : groupIterator) {
            );
        routingC.put("c_1", 4);  
import org.opensearch.Version;  
        nodesZoneB.add(allNodes[3]);
                }
            Settings.EMPTY,
            null
        for (int i = 0; i < 10; i++) {
     */
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(  
            // Verify alternative preference can be applied to a partial index  
        // A caller-supplied restricted preference must be rejected under strict weighted routing  
import org.opensearch.threadpool.ThreadPool;
        collector.addNodeStatistics("node_1", 4, TimeValue.timeValueMillis(300).nanos(), TimeValue.timeValueMillis(250).nanos());
        termToShard.put("xkWaPcCmpT", 0);
                .setRoutingNumShards(shardSplits[0])
                int shard = idEntry.getValue();  
            singletonMap("zone", "b"),  
            indexRoutingTableBuilder.addIndexShard(shardBuilder.build());  
            final List<ShardRouting> expected = new ArrayList<>();  
        final String indexName = indexNames[0];  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        int routingHash = Murmur3HashFunction.hash(sessionId);  
            Map<String, Long> outstandingRequests = new HashMap<>();
                Settings.EMPTY,
        termToShard.put("EyCVeiCouA", 1);
        routingB.put("b_3", 0);
            OperationRouting opRouting = new OperationRouting(
        termToShard.put("YOhahLSzzE", 5);
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        GroupShardsIterator<ShardIterator> drainedIterator = opRouting.searchShards(state, new String[] { index }, null, null);  
        final int numSearchReplicas = 2;  
                Collections.emptyMap(),
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        outstandingRequests.put("node_2", 1L);
        DiscoveryNode[] allNodes = setupNodes();
        routingC.put("c_2", 3);
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(  
        final int numIndices = 1;
        selectedNodes.add(secondChoice.currentNodeId());
            while ((shard = it.nextOrNull()) != null) {
                    position++;
        final int numSearchReplicas = 2;
        } finally {  
        expectThrows(
    ) {  
        TestThreadPool threadPool = null;  
                        Settings.EMPTY,
        Map<String, Integer> termToShard = new TreeMap<>();
        outstandingRequests.put("node_0", 1L);  
                .build();
        Map<String, Integer> routingB = new HashMap<>();  
            );
                assertThat(shardIterator.size(), equalTo(numReplicas + 1));
        String[] indices,
import org.opensearch.core.index.shard.ShardId;
                    Settings.builder()  
            )  
        return allNodes;
            ClusterServiceUtils.setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(indexName, true, randomInt(8)));  
                        .build()  
    }
                .numberOfSearchReplicas(3)
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
        collector.addNodeStatistics("node_2", 1, TimeValue.timeValueMillis(200).nanos(), TimeValue.timeValueMillis(200).nanos());
                indexShardRoutingBuilder.addShard(
            // routing preference check, even though the server injects _primary_first for the warm index
        TestThreadPool threadPool = null;  
        for (int i = 0; i < 10; i++) {
            DiscoveryNode node = new DiscoveryNode(
        List<DiscoveryNode> nodesZoneA = discoveryNodeMap.get("a");
        shardChoice = groupIterator.get(0).nextOrNull();  
                        .build()  
                String id = idEntry.getKey();
        termToShard.put("nICGuWTdfV", 0);
        metadataBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
            ShardId shardId = indexShardRoutingTable.searchOnlyReplicas().get(0).shardId();
        TestThreadPool threadPool = new TestThreadPool("testThatOnlyNodesSupport");
    public void testServerInjectedPreferenceDoesNotLeakAcrossIndices() throws Exception {
                if (randomBoolean() && !shards.get(position).initializing()) {
            groupIterator = opRouting.searchShards(state, indexNames, null, "_replica");
                    assertThat(
                    );
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");
            metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();  
    }
        assertThat(groupIterator.size(), equalTo(numIndices * numShards));
        // given identically sorted lists of nodes across all shard IDs
        ThreadPool threadPool = null;
            String routing = routingIdEntry.getKey();
        routingB.put("b_2", 0);  
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
            assertEquals(shard, shardId.getId());  
    public void testPartitionedIndexBWC() {
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        routingD.put("d_1", 2);
                .routingTable(RoutingTable.builder().add(indexShardRoutingBuilder).build())
        // Drain zone-a
        Map<String, Integer> routingD = new HashMap<>();
            // Setting up weights for weighted round-robin in cluster state
            for (Map.Entry<String, Integer> idEntry : routingIdEntry.getValue().entrySet()) {
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                        index,
        }  
    public void testPartialIndexPrimaryDefault() throws Exception {  
        // each shard ID doesn't pick the same node.
        termToShard.put("DGJOYrpESx", 4);
            threadPool = new TestThreadPool("testThatOnlyNodesSupportNodeIds");  
        // subsequent searches and that the nodes are selected fairly i.e.  
        // Ensure that a user session is re-routed back to same nodes for
        );
        allNodes[i] = clusterManager;  
        // node 1 should be the lowest ranked node to start  
            assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
 *     http://www.apache.org/licenses/LICENSE-2.0
                .generateClusterUuidIfNeeded();
 * SPDX-License-Identifier: Apache-2.0
                while (it.remaining() > 0) {
            "cluster-manager",
            if (sessionsfirstSearch == null) {
            );
        for (String index : indices) {
        termToShard.put("CEmLmljpXe", 5);
            }
        List<DiscoveryNode> nodesZoneA = new ArrayList<>();
            // tests shards are assigned to nodes in zone c  
        );
        termToShard.put("yNjiAnxAmt", 5);
        final int numReplicas = 2;
        routingIdToShard.put("d", routingD);
    }  
        ClusterService clusterService = null;  
        Map<String, Map<String, Integer>> routingIdToShard = new HashMap<>();
                        ShardRoutingState.STARTED  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;  
            final List<ShardRouting> shards = clusterService.state().getRoutingNodes().assignedShards(new ShardId(index, 0));
            final ShardIterator it = new OperationRouting(
            buildNewFakeTransportAddress(),  
        return indexShard.activeInitializingShardsIt(routingHash);
            preferred.addAll(all.subList(0, expected.size()));
                .put("cluster.routing.weighted.fail_open", false)  
            Map<String, Long> outstandingRequests = new HashMap<>();
            Collections.emptyMap(),
                        assertFalse("Initializing shard should appear last", shardRouting.active());
        groupIterator.forEach(shardRoutings -> assertThat(shardRoutings.nextOrNull().currentNodeId(), containsString("node_b")));  
        } finally {
                        .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        Set<String> selectedNodes = new HashSet<>(numShards);
            .routingPartitionSize(2)  
        try {
            }
                    weighAwayNodesInUndefinedZone = false;  
        termToShard.put("WRjUoZwtUz", 3);
                // Assign all the primary shards on nodes in zone-a (node_a0 or node_a1)
        termToShard.put("EzHgydDCSR", 3);
        Map<String, Integer> routingA = new HashMap<>();  
        }
                // shard from nodes in zone c is not selected since its weight is 0  
                if (remoteSnapshotIndex.equals(shardIterator.shardId().getIndexName())) {  
            IOUtils.close(clusterService);
            assertEquals(1, shardIds.stream().filter((sid) -> sid.id() == shard).count());
        routingC.put("c_4", 0);
                    Settings.builder()  
        DiscoveryNode[] allNodes = setUpNodesForWeightedRouting();
            IndexShardRoutingTable indexShardRoutingTable = state.getRoutingTable().index(indexName).getShards().get(0);  
            Settings.builder()
            }  
            );
                final IllegalArgumentException e = expectThrows(
                "node_" + zone + i,  
        routingB.put("b_1", 0);
                singletonMap("zone", zone),
                final ShardId shardId = new ShardId(index, "_na_", i);  
            }  
                            containsString("no data nodes with criteria [" + String.join(",", nodes) + "] found for shard: [test][0]")
    private ShardIterator duelGetShards(ClusterState clusterState, ShardId shardId, String sessionId) {
            Version.CURRENT  
        termToShard.put("xvIGbRiGJF", 3);
                        .build()  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
            for (Map.Entry<String, Integer> idEntry : routingIdEntry.getValue().entrySet()) {
                    .build();  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
import static org.hamcrest.object.HasToString.hasToString;  
        } finally {
            for (ShardIterator it : groupIterator) {
        termToShard.put("oDdHJxGxja", 7);
        // setting up indices
                        .put(SETTING_VERSION_CREATED, Version.CURRENT)
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)  
 * GitHub history for details.
        termToShard.put("nyeRYDnDQr", 6);
            state = ClusterState.builder(state).metadata(metadataBuilder.build()).build();  
            singletonMap("zone", "b"),
        List<ShardRouting> sessionsfirstSearch = null;  
        }
            shrunkShard = OperationRouting.generateShardId(shrunk, term, null);  
            .numberOfReplicas(1)
                .metadata(metadataBuilder.build())
        state = updateStatetoTestWeightedRouting(indexNames, numShards, numReplicas, state, discoveryNodeMap);  
                }
                "node_initializing",
        termToShard.put("WFFWYBfnTb", 0);
            assertThat("One group per index shard", groupIterator.size(), equalTo(indexNames.length * numShards));
                Collections.singleton(DiscoveryNodeRole.DATA_ROLE),  
                buildNewFakeTransportAddress(),
        discoveryNodeMap.put("a", nodesZoneA);
            Set<ShardId> shardIds = IndexMetadata.selectShrinkShards(shrunkShard, metadata, shrunk.getNumberOfShards());  
            }  
        final String indexName = "test";  
                .build();  
import org.opensearch.threadpool.TestThreadPool;  
        collector.addNodeStatistics("node_a0", 10, TimeValue.timeValueMillis(200).nanos(), TimeValue.timeValueMillis(150).nanos());
            null,  
    public void testGenerateShardId() {  
                        )
                .numberOfReplicas(1)
/*
                ShardRouting duelFirst = duelGetShards(state, firstChoice.shardId(), sessionKey).nextOrNull();
        }
            IndexMetadata metadata = IndexMetadata.builder("test")  
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
                    only.add(shard);  
            assertEquals(Arrays.toString(shardSplits), 1, shardIds.stream().filter((sid) -> sid.id() == shard).count());
import org.opensearch.cluster.deployment.Deployment;  
import java.util.HashMap;
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
                indexShardRoutingBuilder.addShard(  
        );
            .numberOfShards(6)
        termToShard.put("JAYDZMRcpW", 4);  
import java.io.IOException;  
        termToShard.put("rSjLZHCDfT", 5);  
            Set<String> selectedNodes = new HashSet<>();
        final int numIndices = 2;  
                    selectedNodes.add(shardRouting.currentNodeId());
            IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());  
        termToShard.put("hOkpeQqTDF", 3);  
            }
            threadPool = new TestThreadPool("testSearchReplicaDefaultRouting");  
    }
                        assertTrue("Initializing shard should appear last", shardRouting.initializing());
        clusterState.routingTable(routingTableBuilder.build());
                .generateClusterUuidIfNeeded();
        routingD.put("d_1", 4);
                        shardRouting.isSearchOnly() || shardRouting.primary() || shardRouting.isSearchOnly() == false
        collector.addNodeStatistics("node_0", 2, TimeValue.timeValueMillis(200).nanos(), TimeValue.timeValueMillis(150).nanos());  
            ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(  
            Collections.emptyMap(),
                    .numberOfReplicas(1)
    }
 * software distributed under the License is distributed on an
            buildNewFakeTransportAddress(),  
        ClusterService clusterService = null;
        for (String zone : zones) {
            groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
 *
            "cluster-manager",  
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "foo")  
            // tests that no shards are assigned to zone with weight zero
            indexNames[i] = "test" + i;
        routingC.put("c_0", 4);
        ClusterService clusterService = null;
                    nodes.add("missing_" + i);
        nodesZoneB.add(allNodes[2]);
            String routing = routingIdEntry.getKey();  
    // on nodes in one zone to test if Adapative Replica Selection smartly routes the request to a node in different zone  
    // Regression test for the routing logic - implements same hashing logic  
    public void testPreferNodes() throws InterruptedException, IOException {
        assertTrue(opRouting.ignoreAwarenessAttributes());
                        null,
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
        );
        collector.addNodeStatistics("node_a1", 100, TimeValue.timeValueMillis(300).nanos(), TimeValue.timeValueMillis(250).nanos());
            terminate(threadPool);  
        termToShard.put("AITyyoyLLs", 4);
            assertFalse(weighAwayNodesInUndefinedZone);  
 * ownership. Elasticsearch licenses this file to you under  
            for (ShardIterator it : groupIterator) {
        for (String zone : zones) {
            for (String nodeID : selectedNodes) {
import org.opensearch.cluster.metadata.Metadata;
            ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(indexNames, numShards, numReplicas);
        for (int i = 0; i < numRepeatedSearches; i++) {  
                )
        DiscoveryNode nodeB1 = new DiscoveryNode(  
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata())  
        shardChoice = groupIterator.get(0).nextOrNull();  
            terminate(threadPool);
        Set<String> nodeIds = new HashSet<>();  
                    nodes.add(shards.get(position).currentNodeId());  
                collector,
                }
                .settings(
    }
                    Settings.builder()
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
                .build();
import java.util.Map;
        routingA.put("a_1", 2);
        termToShard.put("YHicpFBSaY", 1);
                .build();
        state = ClusterState.builder(state)
        routingC.put("c_3", 0);
        routingB.put("b_0", 0);
                assertNotEquals("Shard should not be on drained node", nodeA0.getId(), shard.currentNodeId());
            for (int i = 0; i < count; i++) {
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
                assertFalse(nodeID.contains("b"));
                        .put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
            int position = 0;
            OperationRouting opRouting = new OperationRouting(
                }
            ).getShards(clusterService.state(), indexName, 0, "_prefer_nodes:" + String.join(",", nodes));
                // Assign all the primary shards on nodes in zone-a (node_a0 or node_a1)
        final int numReplicas = 2;  
        ThreadPool threadPool = null;
                indexNames,
                    selectedNodes.add(shardRouting.currentNodeId());
        } finally {
            assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));  
        );  
                .settings(
                assertEquals(shard, OperationRouting.generateShardId(metadata, id, routing));
        try {  
        routingA.put("a_0", 1);
        ThreadPool threadPool = null;
import org.opensearch.test.ClusterServiceUtils;
    @SuppressForbidden(reason = "feature flag overrides")
        }  
                    selectedNodes.add(shardRouting.currentNodeId());
        // The first index is a writable warm index, for which the server injects the _primary_first preference
                }
            .settings(settings(Version.CURRENT))
                }  
                for (int replica = 0; replica < numberOfReplicas; replica++) {  
        DiscoveryNode nodeB0 = new DiscoveryNode(
            OperationRouting opRouting = new OperationRouting(
                numReplicas,  
                TestShardRouting.newShardRouting(shardId, node.getId(), null, false, true, ShardRoutingState.INITIALIZING, null)  
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
                .setRoutingNumShards(shardSplits[2])  
        assertTrue(selectedNodes.contains("node_a0") || selectedNodes.contains("node_a1"));
            ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(
        for (Map.Entry<String, Map<String, Integer>> routingIdEntry : routingIdToShard.entrySet()) {
                // No shards are assigned to nodes in zone b since its weight is 0  
                int shard = idEntry.getValue();
/*  
        termToShard.put("XhfGWwNlng", 1);
        routingA.put("a_2", 2);  
        // Without drain: shards on both zones
            state = ClusterState.builder(state)
        collector.addNodeStatistics("node_a1", 20, TimeValue.timeValueMillis(100).nanos(), TimeValue.timeValueMillis(150).nanos());
        allNodes[i] = clusterManager;
        termToShard.put("cNRiIrjzYd", 7);
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
import static org.hamcrest.Matchers.equalTo;
                List<ShardRouting> shardRoutings = Collections.singletonList(it.nextOrNull());
        // node_a0 or node_a1 should be the lowest ranked node to start  
        Map<String, List<DiscoveryNode>> discoveryNodeMap
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
import org.opensearch.cluster.node.DiscoveryNode;  
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
            );  
        termToShard.put("RiBbcCdIgk", 4);
        try {
            .numberOfShards(4)  
            clusterService = ClusterServiceUtils.createClusterService(threadPool);  
            terminate(threadPool);
            // A search with no caller-supplied preference must not be rejected by the strict weighted
                    String routing = randomUnicodeOfLengthBetween(1, 50);  
        ClusterState state = ClusterStateCreationUtils.state(nodeA0, clusterManager, allNodes);
            assertEquals(shard, entry.getValue().intValue());
        assertThat(shardChoice.currentNodeId(), equalTo("node_1"));
            terminate(threadPool);  
        termToShard.put("OKCmuYkeCK", 6);
            for (ShardIterator shardIterator : groupIterator) {
        routingIdToShard.put("a", routingA);
            state = setWeightedRoutingWeights(state, weights);  
        DiscoveryNode clusterManager = new DiscoveryNode(
        Map<String, Integer> routingB = new HashMap<>();  
        List<DiscoveryNode> nodesZoneB = discoveryNodeMap.get("b");
                    Settings.builder()  
        ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(indexNames, numShards, numReplicas);
        }
            IndexMetadata indexMetadata = IndexMetadata.builder(index)  
                .put(remoteSnapshotIndexMetadata, false)
                assertFalse("Returned shard should be a replica", shardIterator.nextOrNull().primary());
    /**  
            );
                setting,
            IOUtils.close(clusterService);
        try {  
                final List<ShardRouting> only = new ArrayList<>();  
                    indexShardRoutingBuilder.addShard(
                .routingTable(RoutingTable.builder().add(indexShardRoutingBuilder).build())  
            IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        // make sure the same routing value always has each _id fall within the configured partition size
            assertThat("Search should use more than one of the nodes", selectedNodes.size(), greaterThan(1));
        List<DiscoveryNode> nodesZoneC = new ArrayList<>();
        final int numReplicas = 2;  
                int i = 0;  
                outstandingRequests,  
        groupIterator.forEach(shardRoutings -> assertThat(shardRoutings.nextOrNull().currentNodeId(), containsString("node_a")));
                Settings.EMPTY,  
        routingA.put("a_4", 1);
            indexNames[i] = "test" + i;  
    public void testGenerateShardIdSplit() {  
import org.opensearch.cluster.ClusterState;
        ShardRouting firstChoice = groupIterator.get(0).nextOrNull();
            IndexMetadata indexMetadata = IndexMetadata.builder(indexName)  
        assertTrue(nodeIds.contains(nodeB0.getId()));  
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, null);
        termToShard.put("MGlxLFyyCK", 3);
            .numberOfReplicas(1)
            IOUtils.close(clusterService);
                assertNotNull(firstChoice);
    ) {  
                )  
            // search shards call
        termToShard.put("upLDybdTGs", 5);  
import static org.hamcrest.Matchers.containsInAnyOrder;  
        termToShard.put("PGgHcLNPYX", 7);
        try {
            final int shard = OperationRouting.generateShardId(metadata, term, null);
        assertThat(groupIterator.size(), equalTo(numIndices * numShards));
            // Verify alternative preference can be applied to a searchable snapshot index
                .build();
        termToShard.put("bVDJDCeaFm", 2);
        );  
        }  
            threadPool = new TestThreadPool("testThatOnlyNodesSupport");  
                .build();
                );
                if (nodes.size() == 1) {  
        opRouting.setUseAdaptiveReplicaSelection(true);  
            assertTrue(opRouting.ignoreAwarenessAttributes());
                state,
            .setRoutingNumShards(8)
                new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
                Settings.builder()
            clusterService = ClusterServiceUtils.createClusterService(threadPool);  
                .numberOfShards(shardSplits[1])  
                final ShardIterator it = new OperationRouting(
        terminate(threadPool);  
            Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            final int count = randomIntBetween(1, shards.size());  
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
        // Now let's start adding node metrics, since that will affect which node is chosen
    }
        termToShard.put("PeGJjomyik", 3);
        final int numReplicas = 2;
 */
        // add weighted routing weights in metadata
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
            threadPool = new TestThreadPool("testServerInjectedPreferenceDoesNotLeakAcrossIndices");
                    .put(SETTING_NUMBER_OF_REPLICAS, 1)
            Version.CURRENT  
        assertThat(groupIterator.size(), equalTo(numIndices * numShards));
            // Verify default preference is primary only
            IOUtils.close(clusterService);
        routingIdToShard.put("a", routingA);
                for (int replica = 0; replica < numberOfReplicas; replica++) {  
        );
            .build();
                assertThat(new HashSet<>(only), equalTo(new HashSet<>(expected)));
        Map<String, Long> outstandingRequests = new HashMap<>();
            Version.CURRENT  
            String key = entry.getKey();  
                // shard from nodes in zone a is not selected since its weight is 0  
            }  
            IOUtils.close(clusterService);  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        termToShard.put("schsINzlYB", 1);  
                    expected.add(shards.get(position));
        return allNodes;  
    }  
        }  
                assertEquals("We should have all 6 shards returned", shardIterator.size(), 6);  
        termToShard.put("lmvAaEPflK", 7);
                            containsString("no data nodes with criterion [" + String.join(",", nodes) + "] found for shard: [test][0]")
                assertFalse(nodeID.contains("a"));
        GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, new String[] { index }, null, null);
    public void testWarmIndexSearchNotBlockedByStrictWeightedRouting() throws Exception {  
        int[][] possibleValues = new int[][] { { 8, 4, 2 }, { 20, 10, 2 }, { 36, 12, 3 }, { 15, 5, 1 } };
            .build();
            final int shard = OperationRouting.generateShardId(metadata, term, null);  
            int shard = randomBoolean()
        }
        routingB.put("b_4", 3);
import org.opensearch.cluster.metadata.IndexMetadata;  
        assertThat(groupIterator.get(0).size(), equalTo(numReplicas + 1));  
        for (int i = 0; i < numIndices; i++) {  
        );  
    public void testAllocationAwarenessDeprecation() {  
            }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;  
                assertEquals(shard, OperationRouting.generateShardId(metadata, id, routing));  
        termToShard.put("nbZWPWJsIM", 0);
        // Now let's start adding node metrics, since that will affect which node is chosen. Adding more load to node_b2  
        final int numShards = 1;  
            for (ShardIterator shardIterator : groupIterator) {  
        final IndexShardRoutingTable indexShard = clusterState.getRoutingTable().shardRoutingTable(shardId.getIndexName(), shardId.getId());
        final String[] indexNames = new String[numIndices];
            "node_a1",
        termToShard.put("kTwZnPEeIi", 2);  
        routingB.put("b_2", 0);  
 * not use this file except in compliance with the License.
            );
            shardBuilder.addShard(TestShardRouting.newShardRouting(index, i, nodeA0.getId(), null, true, ShardRoutingState.STARTED));
        } finally {  
        final String[] indexNames = { "test0", "test1" };  
    }
                    assertThat(
                }
                .metadata(metadataBuilder.build())  
            state = ClusterState.builder(state).metadata(metadataBuilder.build()).build();
            // given a configuration with many nodes but the nature of hash
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        outstandingRequests.put("node_a0", 1L);
            "node_b0",  
                .build();
        termToShard.put("KXuNWWNgVj", 2);
            split = IndexMetadata.builder("test")
                ShardRouting firstChoice = shardIterator.nextOrNull();  
        List<DiscoveryNode> nodesZoneC = discoveryNodeMap.get("c");  
            state = ClusterState.builder(state).metadata(metadataBuilder.build()).build();  
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),  
        termToShard.put("ZSzFcbpDqP", 3);  
        }
            final GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, sessionKey);  
            // Update the index config within the cluster state to modify the index to a searchable snapshot index  
        }  
        outstandingRequests.put("node_1", 1L);
        ResponseCollectorService collector = new ResponseCollectorService(clusterService);
    public void testAdaptiveReplicaSelection() throws Exception {
            ShardRouting shard = it.nextOrNull();
        GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(  
        collector.addNodeStatistics("node_1", 3, TimeValue.timeValueMillis(250).nanos(), TimeValue.timeValueMillis(200).nanos());
                        .put(state.metadata().index(warmIndex).getSettings())
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        outstandingRequests.put("node_b2", 1L);  
                buildNewFakeTransportAddress(),
            buildNewFakeTransportAddress(),
            IndexShardRoutingTable indexShardRoutingTable = state.getRoutingTable().index(indexName).getShards().get(0);
            selectedNodes = new HashSet<>();
                all.add(shard);
        final String[] indexNames = new String[numIndices];  
        for (int shards = 1; shards < 5; shards++) {
 *  
        routingC.put("c_0", 1);
            }  
            assertEquals(shardSplits[0], (shardSplits[0] * shardSplits[1]) / shardSplits[1]);
                null,  
        OperationRouting opRouting = new OperationRouting(
    }  
        termToShard.put("BSiWvDOsNE", 5);  
            opRouting = new OperationRouting(setting, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
                    } else {
        termToShard.put("ZSKjhJlcpn", 1);  
        outstandingRequests.put("node_a1", 1L);
            }  
            indexNames[i] = "test" + i;
            for (ShardIterator it : groupIterator) {  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        }
import java.util.TreeMap;  
    }  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    }
                } else {  
        final int numReplicas = randomIntBetween(1, 3);
}
    }  
        routingD.put("d_0", 2);
            for (ShardIterator shardIterator : groupIterator) {
                    assertTrue("Primary should be returned first for the warm index", shardIterator.nextOrNull().primary());
                        hasToString(
            indexNames[i] = "test" + i;
            // Update the index config within the cluster state to modify the index to a partial index
            clusterService = ClusterServiceUtils.createClusterService(threadPool);  
        for (ShardIterator it : groupIterator) {
        }  
        // Test that the shards use a round-robin pattern when there are no stats  
                assertNotEquals("Shard should not be on drained node", nodeA1.getId(), shard.currentNodeId());
        IndexMetadata metadata = IndexMetadata.builder("test")  
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        routingTableBuilder.add(indexRoutingTableBuilder.build());
            while (shard != null) {  
        final int numShards = 2;
                    .routingPartitionSize(partitionSize)
            weights = Map.of("a", 1.0, "b", 0.0, "c", 1.0);
            ClusterServiceUtils.setState(clusterService, ClusterState.builder(state));  
        ClusterState state = ClusterStateCreationUtils.state(allNodes[0], allNodes[6], allNodes);
        for (int i = 0; i < numIndices; i++) {
            ShardId shardId = IndexMetadata.selectSplitShard(shrunkShard, metadata, split.getNumberOfShards());
            allNodes[i++] = node;  
        termToShard.put("qoZALVcite", 7);
            }
            "cluster-manager",
 * KIND, either express or implied.  See the License for the
                    assertTrue(
    }
            DiscoveryNode node = new DiscoveryNode(  
                assertFalse(nodeID.contains("c"));
            Version.CURRENT
 */  
            }
        final String searchableSnapshotIndex = indexNames[0];
        ClusterState state
        termToShard.put("ElSVuJQQuw", 7);
                }
    // Regression test to ignore awareness attributes. This test creates shards in different zones and simulates stress
                .numberOfReplicas(1)  
                    nodes.add("missing_" + i);
            final List<ShardRouting> expected = new ArrayList<>();  
 * You may obtain a copy of the License at  
            int position = 0;
    public void testStrictWeightedRoutingExemptsOnlyServerInjectedPreferences() {
            buildNewFakeTransportAddress(),
            assertThat(all.size(), equalTo(shards.size()));  
        termToShard.put("yIEfZrYfRk", 5);  
                null
                sessionsfirstSearch = searchedShards;  
            for (String nodeID : selectedNodes) {
        termToShard.put("BgfLBXUyWT", 5);
                    // they should route across all active shard copies  
                .build();
        selectedNodes.add(firstChoice.currentNodeId());
        termToShard.put("DifcuqSsKk", 1);
        assertTrue(nodeIds.contains(nodeA0.getId()));
            Settings setting = Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone").build();
        int numberOfShards = 2;
            }
                .numberOfReplicas(1)
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
import org.opensearch.node.ResponseCollectorService;  
            if (expected.size() > 0) {
        try {  
        }  
            ClusterState.Builder builder = ClusterState.builder(state);
            for (ShardIterator shardIterator : groupIterator) {
        DiscoveryNode clusterManager = new DiscoveryNode(
        termToShard.put("nVAZVMPNNx", 3);  
            );
        }
        termToShard.put("sEERfFzPSI", 1);  
        termToShard.put("tFyVdQauWR", 6);  
    public void testPartitionedIndexShrunk() {  
                collector,
        routingHash = 31 * routingHash + indexShard.shardId.hashCode();
        // The same preference must be allowed when it was injected by the server itself  
        routingA.put("a_3", 2);
        termToShard.put("hswhrppvDH", 0);
                .setRoutingNumShards(shardSplits[0])
        ClusterState.Builder clusterState = ClusterState.builder(state);  
        final int numReplicas = 2;  
                    );
        metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
            .settings(settings(Version.CURRENT))
            }
            );
            // Updating weighted round robin weights in cluster state
        termToShard.put("cuNKtLtyJQ", 7);  
            for (int i = 0; i < numberOfShards; i++) {
            "node_a0",
            shrunk = IndexMetadata.builder("test")  
            weighAwayNodesInUndefinedZone = true;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                indexNames,
    public void testFairSessionIdPreferences() throws InterruptedException, IOException {
            final String indexName = "test";
    }
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
        for (Map.Entry<String, Integer> entry : termToShard.entrySet()) {
            final List<ShardRouting> all = new ArrayList<>();
            buildNewFakeTransportAddress(),  
        // Adding more load to node_a0  
        }
        clusterState.routingTable(routingTableBuilder.build());
        } finally {
                        hasToString(  
        routingIdToShard.put("b", routingB);
        // setting up indices
    // by ignoring the zone awareness attributes.
                .put(warmIndexMetadata, false)
        // finally, node 2 is chosen instead
                Version.CURRENT
        nodesZoneA.add(allNodes[1]);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
        final int numShards = 2;
                assertTrue("Only primary should exist with no preference", shardIterator.nextOrNull().primary());
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
                indexNames,
            IOUtils.close(clusterService);  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                    assertThat("All shard copies should be returned for a regular index", shardIterator.size(), equalTo(1 + numReplicas));
        Map<String, Map<String, Integer>> routingIdToShard = new HashMap<>();  
            for (String nodeID : selectedNodes) {
                null
        try {
        Metadata.Builder metadataBuilder = Metadata.builder();
import java.util.HashSet;
        ShardRouting thirdChoice = groupIterator.get(0).nextOrNull();  
                }
                for (int i = 0; i < 20; i++) {
        Map<String, List<DiscoveryNode>> discoveryNodeMap = new HashMap<>();
            IndexMetadata metadata = IndexMetadata.builder("test")  
            IndexMetadata searchableSnapshotIndexMetadata = IndexMetadata.builder(searchableSnapshotIndex)
    public void testWeightedOperationRoutingWeightUndefinedForOneZone() throws Exception {  
                        shardIterator.nextOrNull().isSearchOnly()
        ShardRouting shardChoice = groupIterator.get(0).nextOrNull();
        collector.addNodeStatistics("node_1", 1, TimeValue.timeValueMillis(100).nanos(), TimeValue.timeValueMillis(50).nanos());
            ClusterServiceUtils.setState(clusterService, ClusterState.builder(state));
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
            .numberOfShards(8)
                        i,
import static java.util.Collections.singletonMap;
        routingIdToShard.put("c", routingC);  
        GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(
        Map<String, Integer> routingA = new HashMap<>();
            final List<String> nodes = new ArrayList<>();
            // add a search replica in initializing state:  
        final String[] indexNames = new String[numIndices];
 */
        shardChoice = groupIterator.get(0).nextOrNull();  
        }
            shardBuilder.addShard(TestShardRouting.newShardRouting(index, i, nodeB0.getId(), null, false, ShardRoutingState.STARTED));
            // verify all the shards are there
                .numberOfSearchReplicas(3)
                Settings.builder().build(),
        IndexMetadata metadata = IndexMetadata.builder("test")  
        searchedShards.add(firstChoice);
        Metadata.Builder metadataBuilder = Metadata.builder(state.metadata());
                for (ShardRouting shardRouting : shardRoutings) {  
                .generateClusterUuidIfNeeded();
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, null);  
                final ShardId shardId = new ShardId(index, "_na_", i);
        IndexMetadata metadata = IndexMetadata.builder("test")  
        routingIdToShard.put("b", routingB);
        final String warmIndex = indexNames[0];
        // node 1 starts getting more loaded...  
        ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);  
                .setRoutingNumShards(shardSplits[2])  
            assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        final String[] indexNames = new String[numIndices];  
            assertThat("one group per shard", groupIterator.size(), equalTo(numShards));  
    }  
            ShardRouting shard;  
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
                Settings.EMPTY,
        ThreadPool threadPool = null;
        final int numIndices = 1;
        WeightedRoutingMetadata weightedRoutingMetadata = new WeightedRoutingMetadata(weightedRouting, 0);
        termToShard.put("IsSZQwwnUT", 3);  
            threadPool = new TestThreadPool("testSearchReplicaDefaultRouting");
        termToShard.put("QrklDfvEJU", 6);
                    position++;
        assertNotNull(firstChoice);  
                IndexMetadata metadata = IndexMetadata.builder("test")
            IndexMetadata partialIndexMetadata = IndexMetadata.builder(indexName)  
        ShardRouting firstChoice = groupIterator.get(0).nextOrNull();
            Set<String> selectedNodes = new HashSet<>();  
                    if (i == shardIterator.size()) {  
        routingB.put("b_1", 0);
        termToShard.put("KWimwsREPf", 4);  
        return clusterState;  
        searchedShards.add(thirdChoice);
            indexNames[i] = "test" + i;
                }
            terminate(threadPool);
            GroupShardsIterator<ShardIterator> groupIterator = opRouting.searchShards(state, indexNames, null, null);  
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        routingD.put("d_3", 4);  
            }
        final String indexName = "test";
        termToShard.put("yhZhzCPQby", 1);
        assertNotNull(thirdChoice);
        final int numShards = 1;
                : OperationRouting.generateShardId(metadata, "foobar", key);  
 * Unless required by applicable law or agreed to in writing,
            indexShardRoutingBuilder.addIndexShard(indexShardRoutingTable);  
            // tests no shards are assigned to nodes in zone c
        for (int i = 0; i < numIndices; i++) {  
            threadPool = new TestThreadPool("testSearchableSnapshotPreference");  
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);  
        assertThat(groupIterator.size(), equalTo(numIndices * numShards));  
        termToShard.put("czSljcjMop", 5);  
            .numberOfReplicas(1)  
        final String remoteSnapshotIndex = indexNames[0];
                )
        DiscoveryNode[] allNodes = new DiscoveryNode[7];  
            ClusterState state = clusterStateForWeightedRouting(indexNames, numShards, numReplicas);
        termToShard.put("xpRkJPWVpu", 2);
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            }
        );
                assertThat("Replica shards will be returned", shardIterator.size(), equalTo(numReplicas));
            for (ShardIterator shardIterator : groupIterator) {
                .build();
                .numberOfShards(shardSplits[2])
            .settings(  
        } finally {
            assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
        searchedShards.add(firstChoice);  
                        TestShardRouting.newShardRouting(index, i, nodes[2].getId(), null, false, ShardRoutingState.STARTED)  
            state = ClusterState.builder(state).metadata(metadataBuilder.build()).build();  
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
        OperationRouting opRouting = new OperationRouting(
        return state;
            // Updating weighted round-robin weights in cluster state
            assertThat(preferred, containsInAnyOrder(expected.toArray()));
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);  
        collector.addNodeStatistics("node_a0", 100, TimeValue.timeValueMillis(300).nanos(), TimeValue.timeValueMillis(250).nanos());  
        termToShard.put("rPIdESYaAO", 5);
        TestThreadPool threadPool = new TestThreadPool("testThatOnlyNodesSupportNodeIds");
            // tests no shards are assigned to nodes in zone c  
        // Sets up two data nodes in zone-a and one data node in zone-b  
    }  
            );
        // and more loaded...  
                .numberOfReplicas(2)
        );
            }  
                for (ShardRouting shardRouting : shardRoutings) {  
        final int numShards = 3;
            awarenessSetting,  
    public void testBWC() {
                .settings(settings(Version.CURRENT))
                        .put(SETTING_CREATION_DATE, System.currentTimeMillis())
            List<ShardRouting> searchedShards = new ArrayList<>(numShards);
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata())  
        for (ShardIterator it : drainedIterator) {
import org.opensearch.common.settings.ClusterSettings;
                }
                    () -> new OperationRouting(
            ShardRouting shard = it.nextOrNull();
            }  
                assertThat("Sessions must reuse same replica choices", searchedShards, equalTo(sessionsfirstSearch));
                    weighAwayNodesInUndefinedZone = false;  
public class OperationRoutingTests extends OpenSearchTestCase {
        final int numShards = randomIntBetween(2, 10);
                    String nodeId = "";
        termToShard.put("zKBMYJDmBI", 0);
            null,
        Map<String, Integer> routingC = new HashMap<>();
        }
            groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
        final String[] indexNames = new String[numIndices];  
                shard = it.nextOrNull();  
        opRouting.setUseAdaptiveReplicaSelection(true);
    }
                String id = idEntry.getKey();  
                ).getShards(clusterService.state(), indexName, 0, "_only_nodes:" + String.join(",", nodes));
                        e,
        ClusterService clusterService = null;  
                .settings(
                indexNames,  
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
        Set<String> selectedNodes = new HashSet<>(numShards);  
        int numberOfReplicas,  
        selectedNodes.add(firstChoice.currentNodeId());
        assertThat(searchedShards.size(), equalTo(3));  
            assertEquals(shardSplits[1], (shardSplits[1] * shardSplits[2]) / shardSplits[2]);
                final ClusterService cs = clusterService;
                    ShardRouting shardRouting = it.nextOrNull();  
                )
        clusterState.metadata(metadataBuilder);
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
        // Test that the shards use a round-robin pattern when there are no stats  
        for (String index : indices) {
            routingTableBuilder.add(indexRoutingTableBuilder.build());
        selectedNodes.add(secondChoice.currentNodeId());
            );  
        String[] indices,
                if (nodeID.contains("c")) {
            PreferenceBasedSearchNotAllowedException.class,
    private ClusterState updateStatetoTestWeightedRouting(  
                indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());  
                .build();
        );
            assertEquals(shard, shardId.getId());
                assertThat("Replica shards will be returned", shardIterator.size(), equalTo(numReplicas));
        termToShard.put("RuLzobYixn", 2);
            for (int partitionSize = 1; partitionSize == 1 || partitionSize < shards; partitionSize++) {  
        );
            Settings.EMPTY,
                Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
            IndexRoutingTable.Builder indexShardRoutingBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
            assertFalse(weighAwayNodesInUndefinedZone);  
                .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
import org.opensearch.core.index.Index;  
        searchedShards.add(secondChoice);  
                .build();  
                    assertThat("Only the primary should be returned for the remote snapshot index", shardIterator.size(), equalTo(1));
            threadPool = new TestThreadPool("testPreferNodes");  
            // search shards call  
            OperationRouting opRouting = new OperationRouting(  
        // Adding more load to node_a0 and node_a1 from zone-a
        final int numReplicas = 1;
                singletonMap("zone", zone),  
        termToShard.put("GRIueBeIyL", 7);
            threadPool = new TestThreadPool("testWarmIndexSearchNotBlockedByStrictWeightedRouting");
            state = ClusterState.builder(state)
                OpenSearchTestCase.buildNewFakeTransportAddress(),  
            state = setWeightedRoutingWeights(state, weights);  
    public void testPartitionedIndex() {  
        assertThat(shardChoice.currentNodeId(), equalTo("node_1"));
            final Set<ShardRouting> preferred = new HashSet<>();
            ResponseCollectorService collector = new ResponseCollectorService(clusterService);
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
        termToShard.put("pezPtTQAAm", 7);  
        try {  
        termToShard.put("EZmDicyayC", 0);  
                        )  
        );
        opRouting.checkPreferenceBasedRoutingAllowed(Preference.PREFER_NODES, weightedRoutingMetadata, true);
                searchedShards.add(firstChoice);
            final int count = randomIntBetween(1, shards.size());  
        try {
            indexNames,  
        termToShard.put("zBjjNEjAex", 2);
            }
            assertThat("one group per shard", groupIterator.size(), equalTo(numShards));
        termToShard.put("eDItImYWTS", 1);
            allNodes[i++] = node;
        state = updateStatetoTestARS(indexNames, numShards, numReplicas, allNodes, state);
        assertNotNull(firstChoice);
                    nodes.add(shards.get(position).currentNodeId());  
            // collisions means we can't always rely on optimal node usage in  
        routingA.put("a_3", 3);  
            } else {
        final int numShards = 2;  
    public void testWeightedOperationRouting() throws Exception {  
        termToShard.put("zXAamKsRwj", 2);  
    public void testSearchReplicaDefaultRouting() throws Exception {
        termToShard.put("VLxKRKdLbx", 4);  
        final int numShards = 3;
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
            }
        for (int i = 0; i < numIndices; i++) {
            assertNotNull(shardId);
        final String[] indexNames = new String[numIndices];
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());  
                Version.CURRENT  
        String index = "test_drain";  
    }
                null,
                .build();
                if (nodeID.contains("b")) {
                        nodeId = nodesZoneB.get(randomInt(nodesZoneB.size() - 1)).getId();
                        .put(SETTING_VERSION_CREATED, Version.CURRENT)  
            }
        int[][] possibleValues = new int[][] { { 2, 4, 8 }, { 2, 10, 20 }, { 3, 12, 36 }, { 1, 5, 15 } };
            indexNames[i] = "test" + i;
            assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
                );
                )
        final int numReplicas = 2;
import java.util.ArrayList;
                .settings(settings(Version.CURRENT))
            for (ShardIterator shardIterator : groupIterator) {  
        List<String> zones = Arrays.asList("a", "a", "b", "b", "c", "c");
                "node_initializing",
    }
        assertThat(groupIterator.get(0).size(), equalTo(numReplicas + 1));
            final Index index = clusterService.state().metadata().index(indexName).getIndex();
            final List<ShardRouting> shards = clusterService.state().getRoutingNodes().assignedShards(new ShardId(index, 0));
        List<ShardRouting> searchedShards = new ArrayList<>(numShards);
            setting = Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone").build();
            indexShardRoutingBuilder.addShard(
        }
            builder = ClusterState.builder(state);
    }
                .numberOfReplicas(1)
        final int numReplicas = 2;
            int[] shardSplits = randomFrom(possibleValues);  
            ClusterServiceUtils.setState(clusterService, builder);  
        termToShard.put("EBzEDAPODe", 2);
            assertNotNull(shardId);
        ClusterService clusterService = null;
        termToShard.put("UOjiTugjNC", 7);  
                        TestShardRouting.newShardRouting(index, i, nodeId, null, false, ShardRoutingState.STARTED)  
        routingA.put("a_1", 2);
        }
 *
            opRouting.setStrictSearchOnlyShardRouting(false);  
            }  
        routingC.put("c_5", 1);  
    }
        OperationRouting routing = new OperationRouting(
            // Setting up weights for weighted round-robin in cluster state, weight for nodes in zone b is not set  
        OperationRouting opRouting = new OperationRouting(
                    assertTrue("Returned shard should be the primary", shardIterator.nextOrNull().primary());  
            // all cases.
            routingTableBuilder.add(indexRoutingTableBuilder.build());
            }  
    }
        termToShard.put("cyQIvDmyYD", 7);
        List<DiscoveryNode> nodesZoneB = new ArrayList<>();  
        // Updating cluster state with node, index and shard details
        int i = 0;  
/*
        ClusterService clusterService = ClusterServiceUtils.createClusterService(threadPool);  
                    ).getShards(cs.state(), indexName, 0, "_only_nodes:" + String.join(",", nodes))
        assertThat(shardChoice.currentNodeId(), equalTo("node_1"));
        termToShard.put("EquPtdKaBZ", 4);
                numShards,
            Version.CURRENT
        clusterState = ClusterState.builder(clusterState).metadata(metadataBuilder).build();
        Map<String, Integer> routingC = new HashMap<>();  
                    if (replica == 0) {  
        } finally {
                .build(),
        termToShard.put("qCChjGZYLp", 3);
                    }
        }  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        metadataBuilder.putCustom(WeightedRoutingMetadata.TYPE, weightedRoutingMetadata);
        Settings awarenessSetting = Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone").build();
            OperationRouting opRouting = new OperationRouting(
            Settings.builder().put(OperationRouting.STRICT_WEIGHTED_SHARD_ROUTING_ENABLED.getKey(), true).build(),  
            OperationRouting opRouting = new OperationRouting(
                .build();
            terminate(threadPool);  
        termToShard.put("yDCCPVBiCm", 7);
        termToShard.put("kblouyFUbu", 7);
    private ClusterState clusterStateForWeightedRouting(String[] indexNames, int numShards, int numReplicas) {  
        OperationRouting opRouting = new OperationRouting(
        DiscoveryNode[] nodes,
            opRouting = new OperationRouting(setting, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
            clusterService = ClusterServiceUtils.createClusterService(threadPool);
        termToShard.put("LnqSYezXbr", 5);
import java.util.Collections;  
                ? OperationRouting.generateShardId(metadata, key, null)
 * Licensed to Elasticsearch under one or more contributor  
                for (ShardRouting shardRouting : shardIterator) {
            outstandingRequests,
        }
            collector,  
            // tests that no shards are assigned to zone with weight zero
                .numberOfShards(shardSplits[0])
                .build();
 * specific language governing permissions and limitations
        routingD.put("d_4", 3);
        assertThat(groupIterator.get(0).size(), equalTo(numReplicas + 1));
        final String[] indexNames = new String[] { indexName };
    public void testAdaptiveReplicaSelectionWithZoneAwarenessIgnored() throws Exception {
        OperationRouting opRouting = new OperationRouting(
        termToShard.put("FYQRIBcNqz", 0);
        termToShard.put("yizTqyjuDn", 4);  
            state = setWeightedRoutingWeights(state, weights);
            shrunkShard = OperationRouting.generateShardId(split, term, null);
        } finally {
        clusterState.metadata(metadataBuilder);  
                        .put(SETTING_CREATION_DATE, System.currentTimeMillis())  
            assertEquals(shardSplits[1], (shardSplits[1] / shardSplits[2]) * shardSplits[2]);
                    assertNotNull(shardRouting);  
                }
            state = setWeightedRoutingWeights(state, weights);
        assertThat("One group per index shard", groupIterator.size(), equalTo(numIndices * numShards));
import static org.hamcrest.CoreMatchers.containsString;
            () -> opRouting.checkPreferenceBasedRoutingAllowed(Preference.PREFER_NODES, weightedRoutingMetadata, false)  
        }  
            ClusterState state = ClusterStateCreationUtils.stateWithAssignedPrimariesAndReplicas(indexNames, numShards, numReplicas);  
                        nodeId = nodesZoneC.get(randomInt(nodesZoneC.size() - 1)).getId();  
            );  
        ClusterService clusterService = null;
        ShardRouting secondChoice = groupIterator.get(0).nextOrNull();
        final int numIndices = 1;
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);  
                .numberOfShards(shardSplits[1])
            shardId = IndexMetadata.selectSplitShard(shrunkShard, metadata, split.getNumberOfShards());  
            ClusterState state = clusterStateForWeightedRouting(indexNames, numShards, numReplicas);
        // Updates cluster state by assigning shard copies on nodes
            indexNames,
        ClusterService clusterService = null;  
            IndexShardRoutingTable.Builder shardBuilder = new IndexShardRoutingTable.Builder(new ShardId(index, "_na_", i));  
                if (randomBoolean() && !shards.get(position).initializing()) {
            .build();
        groupIterator = opRouting.searchShards(state, indexNames, null, null, collector, outstandingRequests, null);
            ClusterServiceUtils.setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(indexName, true, randomInt(8)));  
        IOUtils.close(clusterService);
                    TestShardRouting.newShardRouting(index, i, nodes[randomInt(1)].getId(), null, true, ShardRoutingState.STARTED)
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG;
                    );
            for (ShardIterator it : groupIterator) {
        IOUtils.close(clusterService);
        termToShard.put("ngizYtQgGK", 5);  
            }  
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
                    .settings(settings(Version.CURRENT))
            shardIds = IndexMetadata.selectShrinkShards(shrunkShard, metadata, shrunk.getNumberOfShards());
        // The first index is a searchable snapshot index  
        discoveryNodeMap.put("b", nodesZoneB);
        routingB.put("b_3", 0);
            IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
        routingD.put("d_2", 3);  
            buildNewFakeTransportAddress(),
                    Settings.EMPTY,  
