        if (indexToAllShards) {
        assertEquals(GREEN, health.getStatus());
        assertTrue(clusterRerouteResponse.isAcknowledged());
        prepareIndices(indices, 1, 1);
        boolean ensureGreen
            Settings.builder().put(SETTING_NUMBER_OF_SHARDS, numberOfPrimaryShards).put(SETTING_NUMBER_OF_REPLICAS, 0).build()
        ensureGreen();
            ensureYellow();
                    .build()
 * the Apache License, Version 2.0 (the "License"); you may
            .execute()
                .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true)
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(0)).put(node0DataPathSettings).build());
        assertNotNull(storeFileMetadata.peerRecoveryRetentionLeases());
            .setPrimary(false)
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
                .put(clusterManagerDataPathSettings)
        );
            .startObject("appAccountIds")
        for (int i = 0; i < 10; i++) {
                .getAllocationDecision()
            IndexService indexShards = indexServices.indexServiceSafe(idx);
        assertEquals(GREEN, health.getStatus());
            .health(Requests.clusterHealthRequest().waitForGreenStatus().timeout("1m"))
        logger.info("--> Now do a protective reroute");
    public void testDeleteRedIndexInBatchMode() throws Exception {
            .setSource(jsonBuilder().startObject().startArray("appAccountIds").value(14).value(179).endArray().endObject())
            .health(Requests.clusterHealthRequest().waitForGreenStatus().timeout("5m"))
 * Unless required by applicable law or agreed to in writing,
        );
            .actionGet();
            .setShard(0)
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("num", 179)).get(), value1Docs);
                        jsonBuilder().startObject().field("field", "value1").startArray("num").value(14).value(179).endArray().endObject()
        assertEquals("cannot allocate because allocation is not permitted to any of the nodes", aud.getExplanation());
                .getAllocateDecision()
            internalCluster().getClusterManagerName()
        logger.info("Running Cluster Health (wait for the shards to startup)");
        refresh();
        assertEquals(100, health.getActiveShards());
                .put("node.name", clusterManagerName)
        createIndex(
import org.opensearch.env.NodeEnvironment;
        String[] indices,
        createIndex(
        Settings node1DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(1));
                result.put(index, current);
        logger.info("Running Cluster Health (wait for the shards to startup)");
        // note: default replica settings are tied to #data nodes-1 which is 0 here. We can do with 1 in this test.
            .indexServiceSafe(resolveIndex("test"))
        ensureStableCluster(3);
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            ShardsBatchGatewayAllocator.class,
        internalCluster().startNode();
import org.opensearch.cluster.service.ClusterService;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 3)
        }
            ).setMapping(mapping)
                    assertThat(
                        equalTo(1)
        internalCluster().startDataOnlyNodes(6);
                    .endObject()
        client(primaryNode).admin().indices().prepareFlush("test").setForce(true).get();
            .execute()
                for (int shard = 0; shard < current.length; shard++) {
import org.opensearch.Version;
        final String firstNode = internalCluster().startNode();
        ensureGreen();
        internalCluster().startClusterManagerOnlyNodes(
        internalCluster().startNode();
            .startObject()
            previousTerms = new HashMap<>();
        TransportNodesListGatewayStartedShardsBatch.NodesGatewayStartedShardsBatch response;
            .getAllocateDecision();
        Settings node1DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(1));
            "testg",
import org.opensearch.indices.IndicesService;
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
        assertEquals(0, health.getUnassignedShards());
        }
import java.util.Collection;
        client().admin().indices().prepareRefresh().execute().actionGet();
        );
    }
        assertAcked(prepareCreate("test").setMapping(mapping));
            .getShardAllocationDecision()
        if (corrupt) {
                .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true)
    public void testLatestVersionLoaded() throws Exception {
            .setSource(jsonBuilder().startObject().field("field", "value3").endObject())
 * compatible open source license.
            "test2",
            long recovered = 0;
        ensureGreen();
        String index2Name = "test2";
            .actionGet();
        );
        // Batch mode - This test is to validate that we don't return AWAITING_INFO in allocation explain API when the deciders are
        for (String index : indices) {
            false
        ensureStableCluster(2);
        // wait for cluster to turn green
        ensureYellow("test");
            .execute()
        ensureYellow("testg");
            .addAlias("test", "test_alias", QueryBuilders.termQuery("field", "value"))
package org.opensearch.gateway;
        assertEquals(0, health.getUnassignedShards());
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("field", "value2")).get(), value2Docs);
    public void testBatchModeDisabled() throws Exception {
        ensureStableCluster(1);
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
        assertTrue(gatewayStartedShard.primary());
            // index doc2
            .actionGet();
            Settings.builder()
                        client().admin().indices().prepareStats("test").get().getShards()[0].getRetentionLeaseStats()
    private void createNIndices(int n, String prefix) {
    public void testShardStoreFetchMultiNodeMultiIndexesUsingBatchAction() throws Exception {
                            }
        ensureStableCluster(1);
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
        client().prepareIndex("test")
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
    public void testCulpritShardInBatch() throws Exception {
            .setId("10990239")
        // Now start cluster manager node and post that verify batches created
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        }
            }
        assertTrue(clusterRerouteResponse.isAcknowledged());
        );
                    );
        // https://github.com/elastic/elasticsearch/issues/9997
            .startObject()
 * license agreements. See the NOTICE file distributed with
        );
        client().prepareIndex("test")
        logger.info("--> one node is closed - start indexing data into the second one");
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("field", "value1")).get(), value1Docs);
            @Override
 * this file be licensed under the Apache-2.0 license or a
        ensureGreen();
        Settings node1DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(1));
    public void testBatchModeEnabledWithDisabledTimeoutAndClusterGreen() throws Exception {
                    client().admin().indices().prepareFlush("test").setForce(true).get();
        aud = client().admin()
        assertNotNull(gatewayStartedShard.storeException());
import org.opensearch.cluster.routing.ShardRoutingState;
            1,
        // It would then be removed from any batch and batches would get deleted, so we would have 0 replica batches
                        }
                } else {
                    .put("number_of_shards", 1)
    public void testSingleNodeNoFlush() throws Exception {
            .setSource(jsonBuilder().startObject().field("field", "value1").endObject())
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("field", "value2")).get(), value2Docs);
                    .getNodeStoreFilesMetadataBatch()
    }
        assertEquals(0, gatewayAllocator.getNumberOfInFlightFetches());
        internalCluster().startDataOnlyNodes(5);
        Map<ShardId, ShardAttributes> shardAttributesMap = null;
            value2Docs = 1;
        index("test", "type", "1");
                assertThat(recoveryState.getIndex().reusedFileCount(), equalTo(recoveryState.getIndex().totalFileCount()));
        );
        ensureGreen("test");
        assertEquals(0, health.getRelocatingShards());
import static org.hamcrest.Matchers.hasSize;
            nodes,
        assertEquals(RED, health.getStatus());
                    )
        prepareIndex(indexName1, numShards);
        clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        }
            .prepareAllocationExplain()
                    recoveryState.getSourceNode().getName(),
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        assertEquals(0, health.getInitializingShards());
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Index index1 = resolveIndex(index1Name);
            client().admin()
    }
        createIndex("test", Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).build());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), value1Docs + value2Docs);
        for (String node : internalCluster().nodesInclude(culpritShardIndexName)) {
            Integer shardId = 0;
        createIndex(
    }
import static org.hamcrest.Matchers.not;
 *
 * SPDX-License-Identifier: Apache-2.0
        Map<String, long[]> primaryTerms = assertAndCapturePrimaryTerms(null);
        );
            .getShard(0)
            Settings.builder()
                        "2_" + id,
                for (int i = 0; i < moreDocs; i++) {
import org.opensearch.cluster.routing.allocation.AllocationDecision;
                return Settings.builder().put(RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 2).build();
        // wait for cluster to turn green
            final long[] previous = previousTerms.get(index);
        internalCluster().fullRestart();
                }
            ShardsBatchGatewayAllocator.class,
        clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        Map<String, long[]> primaryTerms = assertAndCapturePrimaryTerms(null);
                .getExplanation()
        assertThat(metadataUuid, not(equalTo("_na_")));
        return Arrays.asList(MockFSIndexStore.TestPlugin.class, InternalSettingsPlugin.class);
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(1)).put(node1DataPathSettings).build());
import java.util.Arrays;
import java.util.function.BooleanSupplier;
            .setId("3")
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
            .setId("2")
import org.opensearch.cluster.routing.UnassignedInfo;
        Settings replicaNodeDataPathSettings = internalCluster().dataPathSettings(nodesWithReplicaShards.get(0));
        assertFalse(health.isTimedOut());
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(
        logger.info("--> calling reroute while cluster is yellow");
            .getNodeStoreFilesMetadataBatch()
        client().execute(ClearVotingConfigExclusionsAction.INSTANCE, new ClearVotingConfigExclusionsRequest()).get();
        internalCluster().startClusterManagerOnlyNodes(
                .put(ShardsBatchGatewayAllocator.GATEWAY_ALLOCATOR_BATCH_SIZE.getKey(), 5)
        ensureRed("test", "test1", "test2");
            .indices()
        assertEquals(0, health.getNumberOfDataNodes());
            value1Docs = 1;
        IndicesExistsResponse indexExistResponse = client().admin().indices().prepareExists("test").get();
    }
        TransportNodesListGatewayStartedShardsBatch.NodesGatewayStartedShardsBatch response;
                    .endObject()
import org.opensearch.index.query.QueryBuilders;
        ensureStableCluster(6);
    }
        Settings node0DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(0));
        flush(indexName);
        logger.info("--> calling reroute while cluster is yellow");
            .collect(Collectors.toList());
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
        int numDocs = randomIntBetween(1, 1024);
        );
            for (Path path : internalCluster().getInstance(NodeEnvironment.class, nodeName).availableShardPaths(shardId)) {
        // INDEX_CREATED
    public void testShardFetchMultiNodeMultiIndexesUsingBatchAction() {
            IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
                    recoveryState.getIndex().recoveredBytes(),
        final RecoveryResponse initialRecoveryReponse = client().admin().indices().prepareRecoveries("test").get();
import org.opensearch.indices.store.ShardAttributes;
                    // expire retention leases quickly
            public boolean clearData(String nodeName) {
        ensureStableCluster(5);
            .actionGet();
        final Index index = resolveIndex(indexName);
            .execute()
import org.opensearch.test.InternalTestCluster;
        }
            if (recoveryState.getPrimary()) {
        ensureYellowAndNoInitializingShards("test2");
            new String[] { indexName1, indexName2 },
        ensureGreen("test");
                    recoveryState.getIndex().reusedBytes(),
                .getShardAllocationDecision()
            .getAllocateDecision();
            value1Docs = randomIntBetween(numberOfShards * 10, numberOfShards * 20);
            createIndex(
                    equalTo(reused)
        }
import static java.util.Collections.emptySet;
import org.apache.lucene.index.CorruptIndexException;
        logger.info("--> restarting the stopped node");
        Map<ShardId, TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata> nodeStoreFilesMetadata = response.getNodesMap()
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("field", "value1")).get(), value1Docs);
            GatewayStartedShard gatewayStartedShard = response.getNodesMap().get(nodeId).getNodeGatewayStartedShardsBatch().get(shardId);
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(
        internalCluster().fullRestart();
        }
            .setId("2")
                );
            ShardsBatchGatewayAllocator.class,
        ClusterHealthResponse health = client().admin().cluster().health(Requests.clusterHealthRequest().timeout("5m")).actionGet();
        assertFalse(health.isTimedOut());
 * GitHub history for details.
    public void testShardStoreFetchNodeNotConnectedUsingBatchAction() {
            2,
        );
            .setPatterns(Collections.singletonList("te*"))
import org.opensearch.common.xcontent.XContentFactory;
        ensureGreen("test");
    private void prepareIndices(String[] indices, int numberOfPrimaryShards, int numberOfReplicaShards) {
import org.opensearch.test.OpenSearchIntegTestCase;
        client().admin()
            new TransportNodesListShardStoreMetadataBatch.Request(shardAttributesMap, discoveryNodes)
            .endObject()
            new TransportNodesListGatewayStartedShards.Request(shardId, customDataPath, new DiscoveryNode[] { node })
                        "type1",
        );
        );
            .setOrder(0)
            .execute()
            @Override
        logger.info("--> restarting the first stopped node");
        client().prepareIndex("test")
    }
        );
        // They would then be removed from any batch and batches would get deleted, so we would have 0 replica batches
            .actionGet();
        assertTrue(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));
        logger.info("Running Cluster Health (wait for the shards to startup)");
        internalCluster().startClusterManagerOnlyNodes(
        String indexName = "test";
        assertTrue(clusterRerouteResponse.isAcknowledged());
            String nodeId = clusterSearchShardsGroup.getShards()[0].currentNodeId();
        createIndex(
        prepareIndex(indexName, numOfShards);
            .get(shardId);
        client().prepareIndex("test")
        assertNull(gatewayStartedShard.storeException());
        internalCluster().startNode();
        // It would then be removed from any batch and batches would get deleted, so we would have 0 replica batches
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
                            if (item.getFileName().toString().startsWith("segments_")) {
            new TransportNodesListGatewayStartedShardsBatch.Request(searchShardsResponse.getNodes(), shardIdShardAttributesMap)
            () -> client().admin().cluster().health(Requests.clusterHealthRequest().timeout("5m")).actionGet().getActiveShards() == 3,
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 3);
                }
                    filesRecovered++;
        assertEquals(shardId, storeFileMetadata.shardId());
                .put(ShardsBatchGatewayAllocator.PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey(), "20s")
import org.opensearch.cluster.node.DiscoveryNode;
        // corrupt test1 index shards
            Settings.builder().put("node.name", nodesWithReplicaShards.get(0)).put(replicaNodeDataPathSettings).build()
            3,
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "60m")
            for (int id = 0; id < Math.max(value1Docs, value2Docs); id++) {
            .actionGet();
        ensureStableCluster(2);
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);
        health = client(internalCluster().getClusterManagerName()).admin().cluster().health(Requests.clusterHealthRequest()).actionGet();
            assertThat(response.getNodes().get(0).getGatewayShardStarted().storeException(), notNullValue());
            }
                Settings.builder()
        // create the index with our mapping
import org.opensearch.test.store.MockFSIndexStore;
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 2);
        response = ActionTestUtils.executeBlocking(
    }
                        jsonBuilder().startObject().field("field", "value2").startArray("num").value(14).endArray().endObject()
                .put(ShardsBatchGatewayAllocator.PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey(), "-1")
            .toString();
                    () -> assertThat(
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 2);
                TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata nodeStoreFilesMetadata = response.getNodesMap()
        // It would then be removed from any batch and batches would get deleted, so we would have 0 replica batches
    public void testStartedShardFoundIfStateNotYetProcessed() throws Exception {
                    index(
        ensureGreen("test");
        );
            client(primaryNode).prepareIndex("test").setSource("field", "value").execute().actionGet();
        assertFalse(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));
import org.opensearch.index.IndexService;
                    .field("store", true)
        TransportNodesListGatewayStartedShards.NodesGatewayStartedShards response;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        Settings clusterManagerDataPathSettings = internalCluster().dataPathSettings(clusterManagerName);
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(2);
            .actionGet();
                    .startObject("field2")
            .prepareAllocationExplain()
        String indexName1 = "test1";
        ShardId shardId1 = new ShardId(index1, 0);
        ensureGreen();
        for (int i = 0; i < 1 + randomInt(100); i++) {
        logger.info("--> refreshing all indices after indexing is complete");
            }
        assertEquals(0, health.getInitializingShards());
            ShardId shardId = clusterSearchShardsGroup.getShardId();
        List<ShardRouting> requiredStartedShards = startedShards.stream()
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
        }
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
        Settings node0DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(0));
                assertThat("number of terms changed for index [" + index + "]", current.length, equalTo(previous.length));
        if (corrupt) {
        logger.info("--> starting the two nodes back");
            internalCluster().getInstance(TransportNodesListShardStoreMetadataBatch.class),
        );
                            .retentionLeases()
            .execute()
            prepareCreate("test").setSettings(
                assertThat(
        logger.info("--> restarting the stopped nodes");
    }
        assertThat(indicesStats.getSuccessfulShards(), equalTo(100));
import java.util.HashMap;
        assertTrue(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));
        final ShardId shardId = new ShardId(index, 0);
import org.opensearch.cluster.routing.ShardRouting;
            .setSource(jsonBuilder().startObject().field("field", "value1").endObject())
    }
        logger.info("--> restarting the node 0");
            }
                .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true)
        }
        logger.info("--> restarting the node 1");
        internalCluster().fullRestart();
        );
        Settings clusterManagerDataPathSettings = internalCluster().dataPathSettings(clusterManagerName);
            ShardRouting[] shardRoutings = clusterSearchShardsGroup.getShards();
            Settings.builder()
        );
            new DiscoveryNode[] { nonExistingNode },
    public void assertSyncIdsNotNull() {
        assertTrue(clusterRerouteResponse.isAcknowledged());
        ClusterHealthResponse health = client().admin()
        final String customDataPath = IndexMetadata.INDEX_DATA_PATH_SETTING.get(
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(3);
            shard.failShard("test", new CorruptIndexException("test corrupted", ""));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.gateway.GatewayRecoveryTestUtils.getDiscoveryNodes;
        refresh();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(1)));
        assertEquals(0, gatewayAllocator.getNumberOfInFlightFetches());
    }
        client().prepareIndex("test")
            .setId("1")
    private void prepareIndex(String indexName, int numberOfPrimaryShards) {
            ShardsBatchGatewayAllocator.class,
    private List<String> findNodesWithShard(final boolean primary) {
        );
            value2Docs = randomIntBetween(numberOfShards * 10, numberOfShards * 20);
        String clusterManagerName = internalCluster().getClusterManagerName();
            internalCluster().getClusterManagerName()
            ensureGreen(prefix + i);
            .endObject()
        logger.info("--> restarting the stopped nodes");
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 2);
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(0)).put(node0DataPathSettings).build());
            indexName,
                .build()
import org.opensearch.index.shard.ShardPath;
        health = client().admin().cluster().health(Requests.clusterHealthRequest().waitForGreenStatus().timeout("1m")).actionGet();
                        for (Path item : stream) {
            .actionGet();
        // shard should have decision NO because there are 6 replicas and 4 data nodes
                .get()
            }
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;
                    .build();
        Map<ShardId, ShardAttributes> shardIdShardAttributesMap = prepareRequestMap(new String[] { indexName }, numOfShards);
                result.put(index, current);
        int numberOfShards = numberOfShards();
        ensureStableCluster(7);
        assertEquals(0, health.getActiveShards());
            .cluster()
                    filesReused++;
                    );
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            true
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(0)));
        }
        Settings replicaNode1DataPathSettings = internalCluster().dataPathSettings(nodesWithReplicaShards.get(1));
            .startObject("field")
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
        for (final RecoveryState recoveryState : initialRecoveryReponse.shardRecoveryStates().get("test")) {
            .actionGet();
            .prepareCreate("test")
        internalCluster().fullRestart();
    public void testAllocationExplainReturnsNoWhenExtraReplicaShardInBatchMode() throws Exception {
            "test",
        client().admin().indices().prepareRefresh().execute().actionGet();
        internalCluster().startNode();
            client().prepareIndex(prefix + i).setId("1").setSource("foo", "bar").get();
        client().prepareIndex("test")
            .setSource(jsonBuilder().startObject().field("field", "value2").endObject())
        ensureYellow();
        assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 2);
        // Total number of primary shards = 50 (50 indices*1)
        } else {
            1,
        for (int i = 0; i <= randomInt(10); i++) {
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        assertFalse(health.isTimedOut());
        logger.info("--> calling allocation explain API 3rd time");
        ensureStableCluster(4);
        refresh();
        assertTrue(response.hasFailures());
        String clusterManagerName = internalCluster().getClusterManagerName();
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), value1Docs + value2Docs);
        Settings replicaNode0DataPathSettings = internalCluster().dataPathSettings(nodesWithReplicaShards.get(0));
        assertNotNull(gatewayStartedShard.allocationId());
        String mapping = XContentFactory.jsonBuilder()
            .setId("10990695")
    ) {
        Settings node1DataPathSettings = internalCluster().dataPathSettings(nodes.get(0));
            .getShardAllocationDecision()
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
        assertEquals(0, health.getInitializingShards());
        final String nodeName = internalCluster().startNode();
        Settings node0DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(0));
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), value1Docs + value2Docs);
        assertTrue(gatewayStartedShard.primary());
            }
        });
        flush();
        client().prepareIndex("test")
            .getNodeGatewayStartedShardsBatch()
        );
        assertTrue(clusterRerouteResponse.isAcknowledged());
        assertTrue(health.isTimedOut());
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
            .cluster()
                assertThat(
    public void testBatchModeEnabledWithoutTimeout() throws Exception {
                        "1_" + id,
        ensureStableCluster(3);
        GatewayStartedShard gatewayStartedShard = response.getNodesMap()
        ensureYellow("test");
            .setSource(jsonBuilder().startObject().field("field", "value1").endObject())
        assertEquals(AllocationDecision.NO, aud.getAllocationDecision());
        internalCluster().startClusterManagerOnlyNodes(
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);
        AllocateUnassignedDecision aud = client().admin()
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("field", "value2")).get(), value2Docs);
                .put("node.name", clusterManagerName)
                    .field("type", "text")
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
                assertThat("data should have been reused", recoveryState.getIndex().reusedBytes(), greaterThan(0L));
        internalCluster().restartNode(replicaNode, new RestartCallback() {
 * not use this file except in compliance with the License.
            ShardsBatchGatewayAllocator.class,
        // We don't store exception in case of corrupt index, rather just return an empty response
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(
        DiscoveryNode nonExistingNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        internalCluster().fullRestart();
            Settings.builder().put(node2DataPathSettings).put(RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 2).build()
        int numShards = internalCluster().numDataNodes();
                // prevent a sequence-number-based recovery from being possible
            .get();
        Settings clusterManagerDataPathSettings = internalCluster().dataPathSettings(clusterManagerName);
        ensureGreen("test");
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodesWithReplicaShards.get(0)));
        assertEquals("cannot allocate because allocation is not permitted to any of the nodes", aud.getExplanation());
        assertEquals(nonExistingNode.getId(), response.failures().get(0).nodeId());
        assertEquals(0, health.getNumberOfPendingTasks());
                    .field("store", true)
        String indexName2 = "test2";
        logger.info("--> restarting the first stopped node");
        ensureStableCluster(7);
            1,
        }
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(2)).put(node2DataPathSettings).build());
        ShardId shardId
                }
        if (!indexToAllShards) {
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        List<ShardRouting> startedShards = state.routingTable().shardsWithState(ShardRoutingState.STARTED);
            new String[] { indexName },
        ensureGreen("test");
        ensureStableCluster(3);
                return Settings.builder()
        assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("appAccountIds", 179)).execute().actionGet(), 2);
import static org.opensearch.gateway.GatewayRecoveryTestUtils.prepareRequestMap;
        return requiredStartedShards.stream().map(shard -> state.nodes().get(shard.currentNodeId()).getName()).collect(Collectors.toList());
        assertEquals(GREEN, health.getStatus());
            .setSource(jsonBuilder().startObject().startArray("appAccountIds").value(14).endArray().endObject())
                    "all existing files should be reused, byte count mismatch",
        ensureStableCluster(2);
            // insert a two docs, some shards will not have anything
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        Collections.shuffle(requiredStartedShards, random());
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 5).build()
        assertTrue(deleteIndexResponse.isAcknowledged());
        internalCluster().stopRandomDataNode();
import org.opensearch.index.MergePolicyProvider;
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        logger.info("Running Cluster Health (wait for the shards to startup)");
            .setIndex("test2")
        String clusterManagerName = internalCluster().getClusterManagerName();
        refresh();
    }
            .get(discoveryNodes[0].getId())
            .getAllocateDecision();
    }
        assertEquals(2, health.getUnassignedShards());
            public Settings onNodeStopped(String nodeName) {
                    .startObject()
            )
        ensureStableCluster(3);
        TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch response = prepareAndSendRequest(
        ensureYellow("test"); // wait for primary allocations here otherwise if we have a lot of shards we might have a
        final String replicaNode = internalCluster().startDataOnlyNode(nodeSettings(1));
            .setIndex("test")
        assertEquals(1, gatewayAllocator.getNumberOfStartedShardBatches());
                }
                        "type1",
            .toString();
            Settings.builder().put("node.name", nodesWithReplicaShards.get(0)).put(replicaNode0DataPathSettings).build()
        // shard should still have decision NO because there are 6 replicas and 5 data nodes
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
        assertEquals(0, health.getRelocatingShards());
import static org.opensearch.cluster.health.ClusterHealthStatus.GREEN;
        );
import static org.opensearch.cluster.health.ClusterHealthStatus.YELLOW;
                .build()
import org.opensearch.test.InternalSettingsPlugin;
        ensureYellow();
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            internalCluster().getClusterManagerName()
        health = client().admin().cluster().health(Requests.clusterHealthRequest().waitForGreenStatus().timeout("5m")).actionGet();
        assertEquals(YELLOW, health.getStatus());
            .getNodeGatewayStartedShardsBatch()
                        greaterThan(previous[shard])
        // TODO: remove once refresh doesn't fail immediately if there a cluster-manager block:
        client().admin()
                .setShard(0)
    }
        assertTrue(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));
        ensureStableCluster(1);
        final ShardId shardId = new ShardId(index, 0);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.admin.indices.stats.ShardStats;
    public void testAllocationExplainReturnsNoWhenExtraReplicaShardInNonBatchMode() throws Exception {
            .get(nodes[0].getId())
import org.opensearch.test.InternalTestCluster.RestartCallback;
import java.util.Map;
                    .prepareUpdateSettings("test")
            if (recoveryState.getTargetNode().getName().equals(replicaNode)) {
        assertTrue(clusterRerouteResponse.isAcknowledged());
            .getNodeStoreFilesMetadataBatch();
        assertTrue(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(2);
    }
            .execute()
            .indices()
        ensureStableCluster(6);
        waitUntil(delayedShardAllocationStatusVerificationSupplier, 2, TimeUnit.MINUTES);
        internalCluster().startNodes(2);
        Map<ShardId, ShardAttributes> shardIdShardAttributesMap = prepareRequestMap(new String[] { indexName1, indexName2 }, numShards);
        );
    }
            .endObject()
            public Settings onNodeStopped(String nodeName) throws Exception {
                if (softDeleteEnabled) { // We need an extra flush to advance the min_retained_seqno of the SoftDeletesPolicy
        ensureYellow("test"); // wait for primary allocations here otherwise if we have a lot of shards we might have a
                    .put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicaShards)
        // Now start one data nodes and ensure batch mode is working
        // assert no batches created
            .get(shardId);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(2)));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        logger.info("--> restarting the second stopped node");
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        int value1Docs;
        logger.info("--> Now do a reroute so batches are created"); // to avoid any race condition in test
import org.opensearch.indices.recovery.RecoveryState;
        assertAcked(client().admin().indices().prepareCreate("test"));
        ensureGreen("test");
        createNIndices(50, "test"); // this will create 50p, 50r shards
                // index some more documents; we expect to reuse the files that already exist on the replica
            "test",
            int filesRecovered = 0;
        assertEquals(YELLOW, health.getStatus());
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodesWithReplicaShards.get(0)));
        assertEquals(0, gatewayAllocator.getNumberOfInFlightFetches());
            internalCluster().getInstance(TransportNodesListGatewayStartedShards.class),
        internalCluster().startClusterManagerOnlyNodes(
        ensureStableCluster(1);
            1,
        ensureStableCluster(5);
        assertTrue(clusterRerouteResponse.isAcknowledged());
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(1)));
        assertTrue(clusterRerouteResponse.isAcknowledged());
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(0)).put(node0DataPathSettings).build());
            ShardsBatchGatewayAllocator.class,
                return firstNode.equals(nodeName);
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 3);
            1,
        }
        // We cannot directly create an index with replica = data node count because then the whole flow will get skipped due to
                    .put("number_of_replicas", 1)
        }
import static org.hamcrest.Matchers.nullValue;
        logger.info("--> indexing docs");
        assertEquals(RED, health.getStatus());
                if (Files.exists(indexPath)) { // multi data path might only have one path in use
import org.opensearch.index.IndexSettings;
        assertEquals(1, gatewayAllocator.getNumberOfStartedShardBatches());
                    equalTo(filesReused)
        Index index2 = resolveIndex(index2Name);
/*
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
            .setMapping(
            "test",
        logger.info("Running Cluster Health (wait for the shards to startup)");
        List<String> nodesWithReplicaShards = findNodesWithShard(false);
/*
        Settings node1DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(1));
        Map<String, long[]> primaryTerms = assertAndCapturePrimaryTerms(null);
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(0)).put(node0DataPathSettings).build());
            "test",
            assertThat(response.getNodes().get(0).getGatewayShardStarted().storeException(), nullValue());
    public void testMessyElectionsStillMakeClusterGoGreen() throws Exception {
        String indexName = "test";
 *    http://www.apache.org/licenses/LICENSE-2.0
public class RecoveryFromGatewayIT extends OpenSearchIntegTestCase {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(1)));
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(
            client().prepareIndex(prefix + i).setId("2").setSource("foo2", "bar2").get();
        // Replica shard would be marked ineligible since there are no data nodes.
                );
        assertEquals(internalCluster().numDataNodes(), searchShardsResponse.getNodes().length);
        // shard should be unassigned because of Allocation_Delayed
            // we have to verify primaries are started for them to be restored
                index,
        TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch response = prepareAndSendRequest(
        boolean indexToAllShards = randomBoolean();
        Settings node1DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(1));
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
    public void testReuseInFileBasedPeerRecovery() throws Exception {
            .prepareAliases()
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata storeFileMetadata = nodeStoreFilesMetadata.storeFilesMetadata();
        ensureYellow();
            .get()
        assertNodeStoreFilesMetadataSuccessCase(nodeStoreFilesMetadata, shardId);
    }
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), batchModeEnabled).build()
import static org.opensearch.gateway.GatewayService.RECOVER_AFTER_DATA_NODES_SETTING;
        // nodes may need to report the shards they processed the initial recovered cluster state from the cluster-manager
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(
        );
            1,
        for (int i = 0; i < numDocs; i++) {
                .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true)
            "test",
                    .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()) // disable bootstrapping
                    .get();
            .cluster()
                            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1")
            logger.info("Ensure all primaries have been started");
        TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch response;
        ensureGreen();
        final String primaryNode = internalCluster().startDataOnlyNode(nodeSettings(0));
        logger.info("--> add some metadata and additional template");
        assertNull(nodeStoreFilesMetadata.getStoreFileFetchException());
            internalCluster().getClusterManagerName()
                assertNodeStoreFilesMetadataSuccessCase(nodeStoreFilesMetadata, shardId);
        // returning NO
                    .startObject("field1")
import java.util.concurrent.TimeUnit;
    }
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
        Map<ShardId, ShardAttributes> shardIdShardAttributesMap = prepareRequestMap(new String[] { indexName }, numOfShards);
    }
        ShardId shardId = new ShardId(index, 0);
        assertEquals(GREEN, health.getStatus());
        assertFalse(health.isTimedOut());
                for (final ReplicationLuceneIndex.FileMetadata file : recoveryState.getIndex().fileDetails()) {
        // Replica shard would be marked ineligible since there are no data nodes.
                                logger.debug("--> deleting [{}]", item);
        ensureYellow("test");
        for (int i = 0; i < 10; i++) {
                            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(), "0s")
        // Total number of replica shards = 50 (50 indices*1)
        logger.info("--> restarting the second stopped node");
        String metadataUuid = client().admin().cluster().prepareState().execute().get().getState().getMetadata().clusterUUID();
            @Override
                }
            .endObject()
    ) {
        internalCluster().startClusterManagerOnlyNodes(
        internalCluster().startDataOnlyNodes(1);
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;
                assertBusy(
            "test2",
        corruptShard(searchShardsResponse.getNodes()[0].getName(), shardId);
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(1)).put(node1DataPathSettings).build());
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 4).build()
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);
                            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0)
    }
                assertThat("> 0 files should be reused", recoveryState.getIndex().reusedFileCount(), greaterThan(0));
        ClusterSearchShardsResponse searchShardsResponse = client().admin().cluster().prepareSearchShards(indexName).get();
                    equalTo(filesRecovered)
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("field", "value1")).get(), value1Docs);
    private void assertNodeStoreFilesMetadataSuccessCase(
                logger.info(
        ensureGreen("test", "test1", "test2", "testg");
        ensureStableCluster(3);
                );
            .cluster()
        response = ActionTestUtils.executeBlocking(
                assertThat(recoveryState.getIndex().reusedBytes(), equalTo(recoveryState.getIndex().totalBytes()));
        createIndex(
                    }
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
            1,
            .setShard(0)
        List<String> nodes = internalCluster().startNodes(2, Settings.builder().put(RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 2).build());
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(1)));
        logger.info("--> Now do a protective reroute"); // to avoid any race condition in test
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsAction;
        internalCluster().startNodes(2);
        );
import static org.opensearch.cluster.health.ClusterHealthStatus.RED;
        ensureStableCluster(3);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodesWithReplicaShards.get(1)));
 * ownership. Elasticsearch licenses this file to you under
                client(primaryNode).admin()
            }
                    .indices()
import org.opensearch.action.support.ActionTestUtils;
    }
            final String index = indexMetadata.getIndex().getName();
        assertEquals("cannot allocate because allocation is not permitted to any of the nodes", aud.getExplanation());
import static org.hamcrest.Matchers.notNullValue;
 * Modifications Copyright OpenSearch Contributors. See
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(false).get();
                .cluster()
                }
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
            .getShardAllocationDecision()
                .build()
            .execute()
            assertNotNull(shardStats.getCommitStats().getUserData().get(Engine.SYNC_COMMIT_ID));
        Index index = resolveIndex(indexName);
        final boolean corrupt = randomBoolean();
            new TransportNodesListShardStoreMetadataBatch.Request(shardAttributesMap, nodes)
        ensureYellow();
        Settings node2DataPathSettings = internalCluster().dataPathSettings(nodes.get(1));
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("num", 179)).get(), value1Docs);
        assertEquals(RED, health.getStatus());
 * this work for additional information regarding copyright
        assertThat(state.metadata().templates().get("template_1").patterns(), equalTo(Collections.singletonList("te*")));
        ensureStableCluster(1);
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(1)).put(node1DataPathSettings).build());
        logger.info("--> Now do a protective reroute");
        );
        internalCluster().startDataOnlyNode(
import static org.hamcrest.Matchers.greaterThan;
        assertFalse(health.isTimedOut());
            .actionGet();
            .setSource(jsonBuilder().startObject().startArray("appAccountIds").value(14).value(179).endArray().endObject())
            1,
        Settings node2DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(2));
        // Stop one of the nodes to make the cluster yellow
import org.opensearch.cluster.coordination.ElectionSchedulerFactory;
        // Now start last data node and ensure batch mode is working and cluster goes green
        );
        // start node
        assertEquals(1, response.failures().size());
        health = client(internalCluster().getClusterManagerName()).admin().cluster().health(Requests.clusterHealthRequest()).actionGet();
                    )
        shardAttributesMap = prepareRequestMap(indices, 1);
        );
        for (int i = 0; i <= randomInt(10); i++) {
            .actionGet();
        // Now start one data node
            assertEquals(2, shardRoutings.length);
        createIndex(
    private void assertNodeGatewayStartedShardsHappyCase(GatewayStartedShard gatewayStartedShard) {
        assertEquals(AllocationDecision.NO, aud.getAllocationDecision());
                .build()
            internalCluster().getInstance(TransportNodesListShardStoreMetadataBatch.class),
        List<String> nodesWithReplicaShards = findNodesWithShard(false);
        return ActionTestUtils.executeBlocking(
        assertNull(nodeStoreFilesMetadata.get(shardId1).getStoreFileFetchException());
    }
        ClusterSearchShardsResponse searchShardsResponse = client().admin().cluster().prepareSearchShards(indexName1, indexName2).get();
            .setPrimary(false)
        assertFalse(health.isTimedOut());
    public void testTwoNodeFirstNodeCleared() throws Exception {
        Settings node1DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(1));
        int numOfShards = 1;
                return super.onNodeStopped(nodeName);
            .startObject("num")
            .startObject("properties")
        // assign one primary shard each to the data nodes
        ClusterHealthResponse health = client().admin()
        internalCluster().fullRestart(new RestartCallback() {
        IndicesStatsResponse indicesStats = dataNodeClient().admin().indices().prepareStats().get();
        internalCluster().startNode();
import org.opensearch.cluster.metadata.IndexMetadata;
        GatewayStartedShard gatewayStartedShard = response.getNodesMap()
        assertTrue(clusterRerouteResponse.isAcknowledged());
        logger.info("Running Cluster Health (wait for the shards to startup)");
            .execute()
        final ShardId shardId = new ShardId(index, 0);
    }
            .execute()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(1)));
            .setPrimary(false)
            index(index, "type", "1", Collections.emptyMap());
        logger.info("--> running cluster_health (wait for the shards to startup)");
        assertNodeStoreFilesMetadataSuccessCase(nodeStoreFilesMetadata.get(shardId2), shardId2);
    }
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfPrimaryShards)
        String index1Name = "test1";
        createIndex(
        if (previousTerms == null) {
            .get(shardId);
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(2);
        for (int i = 0; i < 10; i++) {
        );
        );
        );
        );
        Settings node0DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(0));
        health = client().admin().cluster().health(Requests.clusterHealthRequest().timeout("5m")).actionGet();
        logger.info("--> explicitly triggering reroute");
            // insert enough docs so all shards will have a doc
        // shard should have decision NO because there is no valid node for the extra replica to go to
        DiscoveryNode[] nodes,
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);
        }
            );
        client().prepareIndex("test")
                    .field("type", "keyword")
                    );
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(2);
        assertEquals(GREEN, health.getStatus());
            }
        TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata nodeStoreFilesMetadata,
        assertEquals(shardId1, nodeStoreFilesMetadata.get(shardId1).storeFilesMetadata().shardId());
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(0)));
            )
        IndexStats indexStats = client().admin().indices().prepareStats("test").get().getIndex("test");
                Settings.builder()
        DiscoveryNode[] nodes = getDiscoveryNodes();
 * You may obtain a copy of the License at
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
        ensureGreen("test");
import org.opensearch.action.admin.indices.stats.IndexStats;
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
                        "primary term didn't increase for [" + index + "][" + shard + "]",
                .build()
        createIndex(
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
        assertThat(state.metadata().index("test").getAliases().get("test_alias"), notNullValue());
            long reused = 0;
import java.nio.file.Files;
        ensureRed("test");
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
        corruptShard(searchShardsResponse.getNodes()[1].getName(), shardId1);
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(0)).put(node0DataPathSettings).build());
            @Override
        for (ClusterSearchShardsGroup clusterSearchShardsGroup : searchShardsResponse.getGroups()) {
                        "test",
        createNIndices(50, "test");
                assertThat(recoveryState.getIndex().reusedFileCount(), equalTo(recoveryState.getIndex().totalFileCount() - filesRecovered));
        );
        client().prepareIndex("test")
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        internalCluster().stopRandomDataNode();
            Settings.builder()
import org.opensearch.core.index.Index;
        }
            2,
        assertTrue(clusterRerouteResponse.isAcknowledged());
                assertThat(recoveryState.getIndex().reusedBytes(), equalTo(recoveryState.getIndex().totalBytes() - recovered));
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
            .isSoftDeleteEnabled();
        assertEquals(1, gatewayAllocator.getNumberOfStartedShardBatches());
        }
                                Files.delete(item);
    private TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch prepareAndSendRequest(
        assertEquals(0, health.getRelocatingShards());
        ClusterSearchShardsResponse searchShardsResponse = client().admin().cluster().prepareSearchShards(indexName).get();
        logger.info("--> Now do a protective reroute"); // to avoid any race condition in test
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
            .setSource(jsonBuilder().startObject().startArray("appAccountIds").value(14).endArray().endObject())
        for (int i = 0; i < 10; i++) {
        }
        for (ClusterSearchShardsGroup clusterSearchShardsGroup : searchShardsResponse.getGroups()) {
            .setId("10990473")
                    index(
        assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("appAccountIds", 179)).execute().actionGet(), 2);
            // index doc 2
        assertEquals(0, health.getRelocatingShards());
            internalCluster().getInstance(TransportNodesListGatewayStartedShardsBatch.class),
        );
        internalCluster().stopCurrentClusterManagerNode();
 *
        }
        String culpritShardIndexName = "test0";
                // we have to recover the segments file since we commit the translog ID on engine startup
            .prepareAllocationExplain()
            public Settings onNodeStopped(String nodeName) throws Exception {
            } else {
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
@ClusterScope(numDataNodes = 0, scope = Scope.TEST)
                    "the segment from the last round of indexing should be recovered",
    }
 */
        // start another node so cluster consistency checks won't time out due to the lack of state
                }
    }
            .setId("1")
            Settings.builder().put(ElectionSchedulerFactory.ELECTION_INITIAL_TIMEOUT_SETTING.getKey(), "2ms").build()
        }
        internalCluster().fullRestart();
import static org.opensearch.index.query.QueryBuilders.termQuery;
        String indexName = "test";
    public void testOneNodeRecoverFromGateway() throws Exception {
            }
        internalCluster().stopCurrentClusterManagerNode();
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(
        );
                        Settings.builder()
        // Replica shard would be marked ineligible since there are no data nodes.
        );
        );
        ensureStableCluster(6);
        assertFalse(health.isTimedOut());
        Map<ShardId, ShardAttributes> shardAttributesMap = prepareRequestMap(new String[] { index1Name, index2Name }, 1);
        response = ActionTestUtils.executeBlocking(
        // Now start cluster manager node and post that verify batches created
        response = ActionTestUtils.executeBlocking(
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
            .field("type", "text")
        for (int i = 0; i <= randomInt(10); i++) {
                    .endObject()
        assertEquals(0, gatewayAllocator.getNumberOfInFlightFetches());
            .get()
    }
        flush("test");
            .getExplanation()
        internalCluster().startClusterManagerOnlyNodes(
            }
        TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch response;
            .execute()
            IndexShard shard = indexShards.getShard(0);
        assertEquals(0, health.getInitializingShards());
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(0)));
    }
                    .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
    }
        // returning NO
            .endObject()
            .cluster()
import static java.util.Collections.emptyMap;
 * software distributed under the License is distributed on an
                .put(ShardsBatchGatewayAllocator.REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey(), "20s")
            .cluster()
        assertEquals(AllocationDecision.NO, aud.getAllocationDecision());
        createIndex(
                assertThat("no translog ops should be recovered", recoveryState.getTranslog().recoveredOperations(), equalTo(0));
            new TransportNodesListGatewayStartedShardsBatch.Request(getDiscoveryNodes(), shardIdShardAttributesMap)
                if (id < value2Docs) {
        );
        // calling reroute and asserting on reroute response
                prefix + i,
        );
        );
            .actionGet();
        int numOfShards = 1;
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), false).build()
        assertAcked(
        assertEquals(0, health.getActiveShards());
/*
                    // disable merges to keep segments the same
                if (id < value1Docs) {
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
import static org.opensearch.gateway.GatewayRecoveryTestUtils.corruptShard;
        internalCluster().startClusterManagerOnlyNodes(
            .setIndex("test2")
        logger.info("--> restarting the stopped nodes");
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
        }
        assertEquals(8, health.getUnassignedShards());
        );
        createIndex(
                    recoveryState.getShardId().getId(),
            .indexSettings()
        DiscoveryNode node = internalCluster().getInstance(ClusterService.class, nodeName).localNode();
        assertTrue(clusterRerouteResponse.isAcknowledged());
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsResponse;
        });
        internalCluster().startDataOnlyNode(
        assertEquals(2, health.getNumberOfDataNodes());
import org.opensearch.index.engine.Engine;
            final long[] current = IntStream.range(0, indexMetadata.getNumberOfShards()).mapToLong(indexMetadata::primaryTerm).toArray();
        createIndex(
        ensureGreen("test");
import java.util.Collections;
        for (int i = 0; i < 10; i++) {
        TransportNodesListGatewayStartedShardsBatch.NodesGatewayStartedShardsBatch response;
        logger.info("--> running cluster_health (wait for the shards to startup)");
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        ensureStableCluster(1);
        AcknowledgedResponse deleteIndexResponse = client().admin().indices().prepareDelete("test").get();
            .get(discoveryNodes[0].getId())
        }
        boolean softDeleteEnabled = internalCluster().getInstance(IndicesService.class, primaryNode)
        for (ShardStats shardStats : indexStats.getShards()) {
        }
        // Now start both data nodes and ensure batch mode is working
        internalCluster().startDataOnlyNode(
import java.nio.file.Path;
                    .setSettings(
            .get()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        );
        IndicesStatsResponse indicesStats = dataNodeClient().admin().indices().prepareStats().get();
        ensureGreen("test");
        String mapping = XContentFactory.jsonBuilder()
        }
        );
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(0)));
            nodes,
        ShardId shardId2 = new ShardId(index2, 0);
    public void testSingleShardFetchUsingBatchAction() {
        logger.info("--> stopping the second node");
                .put(clusterManagerDataPathSettings)
    }
        aud = client().admin()
import org.opensearch.transport.client.Requests;
        logger.info("--> restarting the stopped nodes");
        return result;
import java.util.HashSet;
        flush();
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, numberOfShards()).put(SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, 1))
        logger.info("--> calling allocation explain API");
        client().prepareIndex("test")
    public void testMultipleReplicaShardAssignmentWithDelayedAllocationAndDifferentNodeStartTimeInBatchMode() throws Exception {
        TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch response = prepareAndSendRequest(
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(
        ensureStableCluster(3);
        ensureStableCluster(2);
        // Now start cluster manager node and post that verify batches created
            .filter(startedShard -> startedShard.primary() == primary)
            .field("type", "text")
        client().admin().indices().prepareRefresh().execute().actionGet();
        for (final RecoveryState recoveryState : recoveryResponse.shardRecoveryStates().get("test")) {
            ShardId shardId = clusterSearchShardsGroup.getShardId();
            client().admin().indices().prepareGetSettings("test").get().getIndexToSettings().get("test")
        internalCluster().startClusterManagerOnlyNodes(
        client().prepareIndex("test")
            internalCluster().getClusterManagerName()
            .endObject()
            .preparePutTemplate("template_1")
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);
        // Non batch mode - This test is to validate that we don't return AWAITING_INFO in allocation explain API when the deciders are
                .put(ShardsBatchGatewayAllocator.GATEWAY_ALLOCATOR_BATCH_SIZE.getKey(), 5)
        assertEquals(0, health.getNumberOfInFlightFetch());
        // Now creating a new index with too many replicas and trying again
        assertNodeGatewayStartedShardsHappyCase(gatewayStartedShard);
        assertEquals(10, gatewayAllocator.getNumberOfStartedShardBatches());
 */
        ensureStableCluster(4);
        assertFalse(health.isTimedOut());
        assertFalse(indexExistResponse.isExists());
        for (final IndexMetadata indexMetadata : state.metadata().indices().values()) {
    private Map<String, long[]> assertAndCapturePrimaryTerms(Map<String, long[]> previousTerms) {
        assertFalse(storeFileMetadata.isEmpty());
        ensureYellow();
import org.opensearch.index.shard.IndexShard;
            .startObject("properties")
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(2);
        // All replica shards would be marked ineligible since there are no data nodes.
        logger.info("--> checking if documents exist, there should be 3");
                .put(clusterManagerDataPathSettings)
            .actionGet();
        // start the replica node; we do this after indexing so a file-based recovery is triggered to ensure the files are identical
            ensureGreen(indices);
            .actionGet();
            assertEquals(1, clusterSearchShardsGroup.getShards().length);
        final Set<String> files = new HashSet<>();
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(1)).put(node1DataPathSettings).build());
                    "all existing files should be reused, file count mismatch",
                    .endObject()
            .setSource(jsonBuilder().startObject().field("field", "value2").endObject())
        Settings node0DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(0));
        assertEquals(100, health.getActiveShards());
        this.allocationExplainReturnsNoWhenExtraReplicaShard(true);
    public void testSingleNodeWithFlush() throws Exception {
                .build()
        );
        assertEquals(3, health.getNumberOfDataNodes());
        assertEquals(0, health.getRelocatingShards());
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
        Settings node0DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(0));
        ClusterSearchShardsResponse searchShardsResponse = client().admin().cluster().prepareSearchShards(index1Name).get();
    }
        prepareIndex(indexName2, numShards);
                }
        internalCluster().startNodes(
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
            int filesReused = 0;
            internalCluster().getClusterManagerName()
import static org.hamcrest.Matchers.equalTo;
                    recoveryState.getIndex().recoveredFileCount(),
        // shard that is still in post recovery when we restart and the ensureYellow() below will timeout
        assertEquals(0, health.getInitializingShards());
                            .size(),
        assertEquals(2, health.getNumberOfDataNodes());
        ensureRed("test");
        );
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 *
            .execute()
            TimeUnit.MINUTES
        ensureYellow();
            .setId("2")
        DiscoveryNode[] discoveryNodes = getDiscoveryNodes();
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
import org.opensearch.common.settings.Settings;
        internalCluster().startClusterManagerOnlyNodes(
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(1)).put(node1DataPathSettings).build());
        for (int i = 0; i < 10; i++) {
        logger.info("--> restart replica node");
                .setIndex("test")
        createIndex(
            ShardsBatchGatewayAllocator.class,
            );
    }
    @Override
    public void testShardStoreFetchCorruptedIndexUsingBatchAction() throws Exception {
        assertEquals(0, health.getNumberOfDataNodes());
                // make sure state is not recovered
            .execute()
            1,
            .setSettings(
                    .get(shardRouting.currentNodeId())
        } else {
            .indices()
        assertEquals(8, health.getActiveShards());
        final Index index = resolveIndex(indexName);
            internalCluster().getInstance(TransportNodesListGatewayStartedShardsBatch.class),
        createNIndices(4, "test");
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;
        assertFalse(health.isTimedOut());
                );
    public void testShardFetchCorruptedShardsUsingBatchAction() throws Exception {
        );
        assertEquals(0, health.getNumberOfDataNodes());
        );
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper;
            .setShard(0)
            flush(index);
        client().admin().indices().prepareFlush().execute().actionGet();
        DiscoveryNode[] nodes = getDiscoveryNodes();
                assertThat("bytes should have been recovered", recoveryState.getIndex().recoveredBytes(), equalTo(recovered));
        logger.info("--> closing first node, and indexing more data to the second node");
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(1)));
        // calling reroute and asserting on reroute response
                assertThat(
        for (int i = 0; i < 10; i++) {
        final Map<String, long[]> result = new HashMap<>();
        assertEquals(100, health.getUnassignedShards());
                client().admin().indices().prepareFlush("test").setForce(true).get();
            if (previous == null) {
            .endObject()
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        assertEquals(10, gatewayAllocator.getNumberOfStartedShardBatches());
            .setSource(jsonBuilder().startObject().startArray("appAccountIds").value(14).endArray().endObject())
            assertNodeGatewayStartedShardsHappyCase(gatewayStartedShard);
import java.nio.file.DirectoryStream;
        assertThat(response.getNodes(), hasSize(1));
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
                if (files.contains(file.name()) == false) {
                    reused += file.length();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(
        ClusterHealthResponse health = client().admin()
            Settings.builder()
        assertThat(state.metadata().index("test").getAliases().get("test_alias").filter(), notNullValue());
            .setId("11026351")
            .actionGet();
            Settings.builder()
            1,
        internalCluster().startClusterManagerOnlyNodes(
        logger.info("Running Cluster Health (wait for the shards to startup)");
        final RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries("test").get();
            .get(searchShardsResponse.getNodes()[0].getId())
            internalCluster().getClusterManagerName()
                    recovered += file.length();
                break;
        client(primaryNode).admin()
        assertEquals(100, health.getUnassignedShards());
            .execute()
                    "--> replica shard {} recovered from {} to {}, recovered {}, reuse {}",
        internalCluster().restartNode(searchShardsResponse.getNodes()[0].getName());
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsRequest;
    }
        // They would then be removed from any batch and batches would get deleted, so we would have 0 replica batches
                        current[shard],
            .getExplanation()
                    client(primaryNode).prepareIndex("test").setSource("field", "value").execute().actionGet();
        assertEquals(2, health.getUnassignedShards());
        }
}
 * Licensed to Elasticsearch under one or more contributor
        health = client(internalCluster().getClusterManagerName()).admin().cluster().health(Requests.clusterHealthRequest()).actionGet();
            .field("type", "integer")
            .actionGet();
    private void allocationExplainReturnsNoWhenExtraReplicaShard(boolean batchModeEnabled) throws Exception {
            } else {
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 2);
                XContentFactory.jsonBuilder()
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        internalCluster().startClusterManagerOnlyNode();
        clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
                    recoveryState.getIndex().reusedFileCount(),
        assertTrue(clusterRerouteResponse.isAcknowledged());
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch;
        ensureGreen("test");
        internalCluster().stopRandomDataNode();
                .put("node.name", clusterManagerName)
        );
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
        assertEquals(1, health.getUnassignedShards());
        // Total batches creation for primaries and replicas will be 10 each
            new String[] { indexName },
        client().admin().indices().prepareRefresh().execute().actionGet();
        client().prepareIndex("test")
        ensureGreen("test");
        logger.info("--> Now do a protective reroute"); // to avoid any race condition in test
        assertEquals(0, health.getActiveShards());
                        "test",
        );
        });
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            internalCluster().getInstance(TransportNodesListGatewayStartedShardsBatch.class),
                .put(ShardsBatchGatewayAllocator.REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey(), "-1")
        BooleanSupplier delayedShardAllocationStatusVerificationSupplier = () -> AllocationDecision.ALLOCATION_DELAYED.equals(
        );
        }
                    .put(RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 2)
        assertThat(response.getNodes().get(0).getGatewayShardStarted().allocationId(), notNullValue());
 * KIND, either express or implied.  See the License for the
        assertNotNull(gatewayStartedShard.allocationId());
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 2);
        this.allocationExplainReturnsNoWhenExtraReplicaShard(false);
        TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata nodeStoreFilesMetadata = response.getNodesMap()
            Settings.builder().put(node1DataPathSettings).put(RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 2).build(),
        // Now start both data nodes and ensure batch mode is working
                    .startObject("properties")
        internalCluster().fullRestart(new RestartCallback() {
        corruptShard(searchShardsResponse.getNodes()[0].getName(), shardId1);
        String indexName = "test";
        assertEquals(0, health.getInitializingShards());
        for (int i = 0; i < n; i++) {
            }
        // client().admin().cluster().prepareHealth("test").setWaitForYellowStatus().get();
            .setId("10990513")
import org.opensearch.plugins.Plugin;
                    files.add(file.name());
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("appAccountIds", 179)).execute().actionGet(), 2);
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        assertTrue(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));
import java.util.List;
            new TransportNodesListGatewayStartedShardsBatch.Request(searchShardsResponse.getNodes(), shardIdShardAttributesMap)
            logger.debug("--> failing shard [{}] on node [{}]", shardId, node);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .prepareAllocationExplain()
    }
                            .leases()
        // Now start last data node and ensure batch mode is working and cluster goes green
import java.util.stream.Collectors;
 */
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
        }
            "test",
    }
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("num", 179)).get(), value1Docs);
        logger.info("--> calling allocation explain API again");
    public void testSingleShardStoreFetchUsingBatchAction() throws ExecutionException, InterruptedException {
        int value2Docs;
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        internalCluster().startClusterManagerOnlyNodes(
        prepareIndex(indexName, numOfShards);
import java.util.stream.IntStream;
        );
            1,
            .setId("1")
        client().execute(AddVotingConfigExclusionsAction.INSTANCE, new AddVotingConfigExclusionsRequest(firstNode)).get();
        ensureRed("test");
                );
        logger.info("Running Cluster Health (wait for the shards to startup)");
        internalCluster().fullRestart();
            false
 * under the License.
                    try (DirectoryStream<Path> stream = Files.newDirectoryStream(indexPath)) {
        final Index index = resolveIndex("test");
        internalCluster().startNodes(
        internalCluster().stopCurrentClusterManagerNode();
        String indexName2 = "test2";
        assertFalse(health.isTimedOut());
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(0)).put(node0DataPathSettings).build());
            .actionGet();
        assertTrue(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));
            1,
            "test",
        internalCluster().startNode();
        // shard that is still in post recovery when we restart and the ensureYellow() below will timeout
        // All replica shards would be marked ineligible since there are no data nodes.
            Settings.builder().put("node.name", nodesWithReplicaShards.get(1)).put(replicaNode1DataPathSettings).build()
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
                assertThat(recoveryState.getIndex().recoveredBytes(), equalTo(0L));
                    recoveryState.getTargetNode().getName(),
        assertEquals(2, searchShardsResponse.getNodes().length);
        ClusterSearchShardsResponse searchShardsResponse = client().admin().cluster().prepareSearchShards(indexName1, indexName2).get();
        assertTrue(nodeStoreFilesMetadata.get(shardId1).storeFilesMetadata().isEmpty());
        index(indexName, "type", "1", Collections.emptyMap());
                    recoveryState.getIndex().reusedBytes()
            "test1",
        // we will reduce batch size to 5 to make sure we have enough batches to test assignment
 * specific language governing permissions and limitations
        logger.info("--> Now do a protective reroute");
        ensureGreen("test2");
                .setPrimary(false)
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(1)).put(node1DataPathSettings).build());
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
            createIndex(
            logger.debug("--> failed shard [{}] on node [{}]", shardId, node);
        health = client().admin().cluster().health(Requests.clusterHealthRequest().waitForGreenStatus().timeout("5m")).actionGet();
        String indexName1 = "test1";
        assertEquals(RED, health.getStatus());
    public void testNBatchesCreationAndAssignment() throws Exception {
import java.util.Set;
        waitUntil(
        DiscoveryNode[] discoveryNodes = getDiscoveryNodes();
        prepareIndices(new String[] { index1Name, index2Name }, 1, 1);
    public void testBatchModeEnabledWithSufficientTimeoutAndClusterGreen() throws Exception {
        );
        // clean two nodes
            .getExplanation()
                final Path indexPath = path.resolve(ShardPath.INDEX_FOLDER_NAME);
                    .get(shardId);
        assertEquals(1, health.getDelayedUnassignedShards());
            for (final ReplicationLuceneIndex.FileMetadata file : recoveryState.getIndex().fileDetails()) {
        assertEquals(0, health.getRelocatingShards());
            for (ShardRouting shardRouting : shardRoutings) {
        int moreDocs = randomIntBetween(1, 1024);
    }
        if (ensureGreen) {
                assertThat(recoveryState.getIndex().recoveredFileCount(), equalTo(0));
        Map<String, long[]> primaryTerms = assertAndCapturePrimaryTerms(null);
import java.util.concurrent.ExecutionException;
        Index idx = resolveIndex(culpritShardIndexName);
        assertThat(indicesStats.getSuccessfulShards(), equalTo(100));
                            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1")
        assertThat(client().admin().cluster().prepareState().execute().get().getState().getMetadata().clusterUUID(), equalTo(metadataUuid));
        assertEquals(6, health.getActiveShards());
        waitUntil(delayedShardAllocationStatusVerificationSupplier, 2, TimeUnit.MINUTES);
            .setSource(jsonBuilder().startObject().field("field", "value2").endObject())
        }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(0)));
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.cluster.ClusterState;
        response = ActionTestUtils.executeBlocking(
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(0)));
            .health(Requests.clusterHealthRequest().waitForGreenStatus().timeout("1m"))
