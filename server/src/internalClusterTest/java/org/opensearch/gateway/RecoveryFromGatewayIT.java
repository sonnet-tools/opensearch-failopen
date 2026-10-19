        );
 * under the License.  
                );
        prepareIndex(indexName, numOfShards);  
            for (Path path : internalCluster().getInstance(NodeEnvironment.class, nodeName).availableShardPaths(shardId)) {  
            new String[] { indexName1, indexName2 },
import org.opensearch.cluster.metadata.IndexMetadata;
        int numberOfShards = numberOfShards();
        final ShardId shardId = new ShardId(index, 0);  
                for (int i = 0; i < moreDocs; i++) {  
        ensureStableCluster(4);
        response = ActionTestUtils.executeBlocking(
        assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("appAccountIds", 179)).execute().actionGet(), 2);  
import org.opensearch.indices.recovery.RecoveryState;
            TimeUnit.MINUTES
        for (int i = 0; i < 1 + randomInt(100); i++) {  
        assertEquals(1, gatewayAllocator.getNumberOfStartedShardBatches());
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, numberOfShards()).put(SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, 1))
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(1)));  
        ensureStableCluster(5);
        internalCluster().startNode();
    }
        // shard should have decision NO because there is no valid node for the extra replica to go to
        ensureGreen();  
        internalCluster().fullRestart();
        for (int i = 0; i < 10; i++) {  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            internalCluster().getInstance(TransportNodesListGatewayStartedShards.class),
            // insert a two docs, some shards will not have anything
            1,
        final ShardId shardId = new ShardId(index, 0);
        String indexName2 = "test2";
        // We don't store exception in case of corrupt index, rather just return an empty response  
            // insert enough docs so all shards will have a doc
            1,  
        );
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(0)));
    public void testCulpritShardInBatch() throws Exception {  
            assertNotNull(shardStats.getCommitStats().getUserData().get(Engine.SYNC_COMMIT_ID));  
            }
            .setPrimary(false)
            1,  
                assertThat(  
            "test2",
            ShardsBatchGatewayAllocator.class,  
            .isSoftDeleteEnabled();
    }
        ClusterSearchShardsResponse searchShardsResponse = client().admin().cluster().prepareSearchShards(index1Name).get();
                    .startObject("field2")
        ensureStableCluster(3);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodesWithReplicaShards.get(1)));  
        IndicesStatsResponse indicesStats = dataNodeClient().admin().indices().prepareStats().get();  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        assertTrue(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(0)).put(node0DataPathSettings).build());
            assertEquals(1, clusterSearchShardsGroup.getShards().length);
        internalCluster().stopRandomDataNode();
import org.opensearch.common.settings.Settings;
        this.allocationExplainReturnsNoWhenExtraReplicaShard(false);  
                    equalTo(filesRecovered)
        Map<ShardId, ShardAttributes> shardAttributesMap = null;
            new DiscoveryNode[] { nonExistingNode },
                .build()  
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), false).build()
                .build()
            .setSource(jsonBuilder().startObject().field("field", "value1").endObject())
            // index doc 2  
        }
        ensureStableCluster(5);
            .get()  
                .put(ShardsBatchGatewayAllocator.REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey(), "20s")  
 * compatible open source license.
            ShardsBatchGatewayAllocator.class,
        ensureYellow();
            .setId("10990695")
            .setSource(jsonBuilder().startObject().startArray("appAccountIds").value(14).endArray().endObject())
            .get(discoveryNodes[0].getId())
        assertEquals(0, gatewayAllocator.getNumberOfInFlightFetches());  
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);
    public void testSingleNodeWithFlush() throws Exception {
        internalCluster().startClusterManagerOnlyNode();
        assertEquals("cannot allocate because allocation is not permitted to any of the nodes", aud.getExplanation());  
        logger.info("--> one node is closed - start indexing data into the second one");
            Settings.builder().put(node2DataPathSettings).put(RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 2).build()
            .setSource(jsonBuilder().startObject().field("field", "value2").endObject())  
        // Now start cluster manager node and post that verify batches created  
        refresh();  
        health = client().admin().cluster().health(Requests.clusterHealthRequest().waitForGreenStatus().timeout("1m")).actionGet();
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(2);  
        );
        );
            .execute()
        assertAcked(prepareCreate("test").setMapping(mapping));
            .collect(Collectors.toList());  
                            }
            @Override
                assertThat("bytes should have been recovered", recoveryState.getIndex().recoveredBytes(), equalTo(recovered));
                assertThat("data should have been reused", recoveryState.getIndex().reusedBytes(), greaterThan(0L));
        assertEquals(1, response.failures().size());
/*
        assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 2);
        IndexStats indexStats = client().admin().indices().prepareStats("test").get().getIndex("test");
        ensureStableCluster(2);  
import static org.opensearch.cluster.health.ClusterHealthStatus.GREEN;  
        assertTrue(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));  
        ShardId shardId2 = new ShardId(index2, 0);  
        assertEquals(100, health.getActiveShards());
        );
/*  
                assertBusy(
            IndexShard shard = indexShards.getShard(0);
        // returning NO
            .actionGet();
        internalCluster().startClusterManagerOnlyNodes(
        );
import java.nio.file.Path;  
        assertEquals(1, health.getUnassignedShards());
                        client().admin().indices().prepareStats("test").get().getShards()[0].getRetentionLeaseStats()  
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());  
            new TransportNodesListGatewayStartedShardsBatch.Request(searchShardsResponse.getNodes(), shardIdShardAttributesMap)
            .getNodeGatewayStartedShardsBatch()
        ensureRed("test");
            .actionGet();
        ensureYellowAndNoInitializingShards("test2");
    }
            value2Docs = randomIntBetween(numberOfShards * 10, numberOfShards * 20);
        });  
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
    public void testShardStoreFetchCorruptedIndexUsingBatchAction() throws Exception {  
            flush(index);
                    );
            .endObject()  
        );
            // index doc2  
                return firstNode.equals(nodeName);  
        ensureGreen("test");
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        assertEquals(0, health.getRelocatingShards());  
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(1)).put(node1DataPathSettings).build());
        );
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
            .setPrimary(false)
                }
        assertTrue(gatewayStartedShard.primary());
        client().admin()
            .setId("11026351")  
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(  
        ensureYellow();
        }
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()  
        logger.info("--> Now do a protective reroute");
        assertTrue(clusterRerouteResponse.isAcknowledged());
            .getExplanation()
            Settings.builder()  
            .actionGet();
        IndicesStatsResponse indicesStats = dataNodeClient().admin().indices().prepareStats().get();
        client().prepareIndex("test")
            .setId("1")
        assertThat(metadataUuid, not(equalTo("_na_")));
import org.opensearch.index.IndexService;
 * KIND, either express or implied.  See the License for the
        AllocateUnassignedDecision aud = client().admin()  
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsRequest;  
        // Replica shard would be marked ineligible since there are no data nodes.
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(0)).put(node0DataPathSettings).build());
        for (int i = 0; i <= randomInt(10); i++) {
        internalCluster().restartNode(replicaNode, new RestartCallback() {
            1,
        internalCluster().restartNode(searchShardsResponse.getNodes()[0].getName());
        // Batch mode - This test is to validate that we don't return AWAITING_INFO in allocation explain API when the deciders are
        logger.info("--> refreshing all indices after indexing is complete");
            previousTerms = new HashMap<>();
import java.util.concurrent.ExecutionException;  
        assertTrue(response.hasFailures());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();  
import static org.hamcrest.Matchers.greaterThan;
        logger.info("--> calling reroute while cluster is yellow");
            public Settings onNodeStopped(String nodeName) throws Exception {
            .getAllocateDecision();  
            .cluster()
            "test",
        createNIndices(4, "test");  
        assertEquals(2, searchShardsResponse.getNodes().length);  
        Map<ShardId, ShardAttributes> shardAttributesMap = prepareRequestMap(new String[] { index1Name, index2Name }, 1);
        assertTrue(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));  
            .setSource(jsonBuilder().startObject().startArray("appAccountIds").value(14).value(179).endArray().endObject())
        ensureStableCluster(3);
        DiscoveryNode[] nodes,
                        "type1",
            .execute()  
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
        if (indexToAllShards) {
import org.opensearch.cluster.routing.ShardRouting;
        Settings node1DataPathSettings = internalCluster().dataPathSettings(nodes.get(0));
        assertFalse(health.isTimedOut());  
    }
        );
        ClusterSearchShardsResponse searchShardsResponse = client().admin().cluster().prepareSearchShards(indexName1, indexName2).get();
                assertThat(
    }
        );
import org.opensearch.index.engine.Engine;
        // We cannot directly create an index with replica = data node count because then the whole flow will get skipped due to
        assertTrue(clusterRerouteResponse.isAcknowledged());
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 2);
        String mapping = XContentFactory.jsonBuilder()
                        for (Path item : stream) {
            } else {  
                    .get(shardId);
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;
        ensureGreen("test");
        internalCluster().startNodes(2);
import java.util.Set;
        ensureStableCluster(1);
        String indexName = "test";
        assertFalse(health.isTimedOut());
        for (ClusterSearchShardsGroup clusterSearchShardsGroup : searchShardsResponse.getGroups()) {  
        assertEquals(0, health.getNumberOfInFlightFetch());  
                .setShard(0)  
            index(index, "type", "1", Collections.emptyMap());  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
    public void testTwoNodeFirstNodeCleared() throws Exception {  
        assertEquals(shardId, storeFileMetadata.shardId());  
            .getShardAllocationDecision()
        final String nodeName = internalCluster().startNode();  
            "test",
        // Stop one of the nodes to make the cluster yellow  
            long reused = 0;
            new TransportNodesListGatewayStartedShardsBatch.Request(getDiscoveryNodes(), shardIdShardAttributesMap)
            new String[] { indexName },
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
import org.opensearch.indices.IndicesService;  
            .execute()
        ensureStableCluster(6);
                    "--> replica shard {} recovered from {} to {}, recovered {}, reuse {}",  
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);  
                    filesRecovered++;
        ensureYellow("test");
        assertEquals("cannot allocate because allocation is not permitted to any of the nodes", aud.getExplanation());  
            ensureGreen(indices);
                    recoveryState.getIndex().recoveredBytes(),
            false
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(2);  
    }
                Settings.builder()
import static org.opensearch.gateway.GatewayRecoveryTestUtils.prepareRequestMap;  
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
            .getAllocateDecision();  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                            if (item.getFileName().toString().startsWith("segments_")) {
        ensureStableCluster(1);
import org.apache.lucene.index.CorruptIndexException;
        ensureStableCluster(1);  
        String mapping = XContentFactory.jsonBuilder()
        internalCluster().startDataOnlyNodes(1);
import java.util.HashMap;
                            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(), "0s")
        assertEquals(6, health.getActiveShards());
                    recoveryState.getIndex().recoveredFileCount(),  
        Map<ShardId, ShardAttributes> shardIdShardAttributesMap = prepareRequestMap(new String[] { indexName }, numOfShards);
        );
            "test",  
        aud = client().admin()  
                    .get(shardRouting.currentNodeId())  
                .get()
        assertFalse(health.isTimedOut());  
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();  
                .put(clusterManagerDataPathSettings)
        logger.info("--> restarting the stopped nodes");  
        String indexName = "test";
            1,
        health = client().admin().cluster().health(Requests.clusterHealthRequest().waitForGreenStatus().timeout("5m")).actionGet();  
            .actionGet();
            ShardId shardId = clusterSearchShardsGroup.getShardId();
            .startObject("field")
        flush(indexName);
        logger.info("--> indexing docs");
        List<ShardRouting> requiredStartedShards = startedShards.stream()
        logger.info("--> restarting the node 1");
        assertThat(response.getNodes(), hasSize(1));  
        assertTrue(clusterRerouteResponse.isAcknowledged());  
        refresh();
        for (int i = 0; i <= randomInt(10); i++) {  
        Map<String, long[]> primaryTerms = assertAndCapturePrimaryTerms(null);  
            2,
        assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("appAccountIds", 179)).execute().actionGet(), 2);  
                break;
            createIndex(
        assertEquals(YELLOW, health.getStatus());  
    public void testBatchModeEnabledWithDisabledTimeoutAndClusterGreen() throws Exception {  
        // It would then be removed from any batch and batches would get deleted, so we would have 0 replica batches  
        }
        clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
                    // disable merges to keep segments the same
            .toString();  
                if (id < value1Docs) {
    private void prepareIndices(String[] indices, int numberOfPrimaryShards, int numberOfReplicaShards) {  
            .actionGet();  
 * this file be licensed under the Apache-2.0 license or a
import static java.util.Collections.emptySet;
    }
import org.opensearch.test.store.MockFSIndexStore;
        Settings replicaNodeDataPathSettings = internalCluster().dataPathSettings(nodesWithReplicaShards.get(0));
        );
        );
                    recoveryState.getShardId().getId(),
            "test",  
            .get(nodes[0].getId())  
        // Now start cluster manager node and post that verify batches created  
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;
        ensureYellow("testg");
        ensureStableCluster(3);  
            .cluster()  
                    .build()
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        );
        client().prepareIndex("test")  
        prepareIndices(indices, 1, 1);
        internalCluster().startClusterManagerOnlyNodes(
 * Unless required by applicable law or agreed to in writing,
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("field", "value1")).get(), value1Docs);
        ensureYellow("test"); // wait for primary allocations here otherwise if we have a lot of shards we might have a
            .get(searchShardsResponse.getNodes()[0].getId())
        );
                    .indices()  
        assertTrue(clusterRerouteResponse.isAcknowledged());  
        );
import org.opensearch.action.admin.indices.stats.IndexStats;
        TransportNodesListGatewayStartedShardsBatch.NodesGatewayStartedShardsBatch response;
                    () -> assertThat(
        assertEquals(0, health.getInitializingShards());  
import java.nio.file.Files;
    public void testShardFetchMultiNodeMultiIndexesUsingBatchAction() {
                            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1")
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodesWithReplicaShards.get(0)));
/*  
        assertEquals(3, health.getNumberOfDataNodes());
            .setOrder(0)
                    files.add(file.name());  
        internalCluster().fullRestart(new RestartCallback() {
        );  
    }
        for (int i = 0; i < 10; i++) {
        assertNotNull(gatewayStartedShard.allocationId());  
        ensureYellow("test");
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        client().admin().indices().prepareRefresh().execute().actionGet();
                }
 *
    }  
        assertAcked(client().admin().indices().prepareCreate("test"));
            }
        if (previousTerms == null) {
        internalCluster().stopCurrentClusterManagerNode();
        ensureStableCluster(1);
        logger.info("Running Cluster Health (wait for the shards to startup)");
            .endObject()  
        assertEquals(10, gatewayAllocator.getNumberOfStartedShardBatches());  
        if (!indexToAllShards) {  
        for (int i = 0; i < 10; i++) {  
        Map<String, long[]> primaryTerms = assertAndCapturePrimaryTerms(null);
        final Set<String> files = new HashSet<>();
        ensureStableCluster(2);  
        assertEquals(2, health.getUnassignedShards());
        );
                }
import static org.hamcrest.Matchers.notNullValue;
        client().admin().indices().prepareRefresh().execute().actionGet();
        );
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(2);
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 2);
            assertThat(response.getNodes().get(0).getGatewayShardStarted().storeException(), notNullValue());  
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 2);  
                    );
        assertEquals(0, health.getInitializingShards());
                    .put(RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 2)
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        createIndex(  
        ensureGreen();
        );
        ensureStableCluster(6);
        DiscoveryNode[] nodes = getDiscoveryNodes();
        );
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper;
        assertEquals(0, health.getNumberOfDataNodes());
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(2)));
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
            .setSource(jsonBuilder().startObject().field("field", "value1").endObject())  
            Settings.builder().put(ElectionSchedulerFactory.ELECTION_INITIAL_TIMEOUT_SETTING.getKey(), "2ms").build()  
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
            Settings.builder().put(node1DataPathSettings).put(RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 2).build(),  
        logger.info("--> Now do a protective reroute"); // to avoid any race condition in test
        logger.info("--> explicitly triggering reroute");
        return ActionTestUtils.executeBlocking(
        BooleanSupplier delayedShardAllocationStatusVerificationSupplier = () -> AllocationDecision.ALLOCATION_DELAYED.equals(
            .setSource(jsonBuilder().startObject().field("field", "value2").endObject())
            .execute()
        final String firstNode = internalCluster().startNode();
        prepareIndex(indexName1, numShards);
        assertEquals(100, health.getUnassignedShards());
        // create the index with our mapping
import org.opensearch.action.admin.indices.stats.ShardStats;  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
            new TransportNodesListGatewayStartedShardsBatch.Request(searchShardsResponse.getNodes(), shardIdShardAttributesMap)
 * license agreements. See the NOTICE file distributed with
        final Map<String, long[]> result = new HashMap<>();
            .actionGet();
                    .field("store", true)
            );
        boolean softDeleteEnabled = internalCluster().getInstance(IndicesService.class, primaryNode)
        int numOfShards = 1;
        ClusterHealthResponse health = client().admin().cluster().health(Requests.clusterHealthRequest().timeout("5m")).actionGet();
        final RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries("test").get();
    }
            value1Docs = 1;
        assertThat(response.getNodes().get(0).getGatewayShardStarted().allocationId(), notNullValue());
        assertTrue(clusterRerouteResponse.isAcknowledged());  
        internalCluster().stopRandomDataNode();
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(
                for (final ReplicationLuceneIndex.FileMetadata file : recoveryState.getIndex().fileDetails()) {
            internalCluster().getClusterManagerName()
            client(primaryNode).prepareIndex("test").setSource("field", "value").execute().actionGet();
        internalCluster().startNode();
                .build()
                    .field("store", true)  
        Map<ShardId, ShardAttributes> shardIdShardAttributesMap = prepareRequestMap(new String[] { indexName1, indexName2 }, numShards);
        assertEquals(0, health.getNumberOfPendingTasks());
    }  
        assertTrue(clusterRerouteResponse.isAcknowledged());  
            createIndex(
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(
        health = client().admin().cluster().health(Requests.clusterHealthRequest().timeout("5m")).actionGet();
import static java.util.Collections.emptyMap;  
    public void testBatchModeEnabledWithoutTimeout() throws Exception {
        internalCluster().startNode();  
    private TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch prepareAndSendRequest(
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()  
                }  
        // shard that is still in post recovery when we restart and the ensureYellow() below will timeout
    public void testSingleShardStoreFetchUsingBatchAction() throws ExecutionException, InterruptedException {
            // we have to verify primaries are started for them to be restored
        // All replica shards would be marked ineligible since there are no data nodes.
        // start node
            logger.debug("--> failed shard [{}] on node [{}]", shardId, node);
        final RecoveryResponse initialRecoveryReponse = client().admin().indices().prepareRecoveries("test").get();
            .getExplanation()
        assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("appAccountIds", 179)).execute().actionGet(), 2);  
        assertTrue(clusterRerouteResponse.isAcknowledged());  
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(2)).put(node2DataPathSettings).build());
            internalCluster().getInstance(TransportNodesListShardStoreMetadataBatch.class),  
                assertThat(recoveryState.getIndex().recoveredFileCount(), equalTo(0));
            .startObject("num")
import org.opensearch.cluster.service.ClusterService;
        internalCluster().startClusterManagerOnlyNodes(
        );
                prefix + i,  
            "test",  
        );
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        List<ShardRouting> startedShards = state.routingTable().shardsWithState(ShardRoutingState.STARTED);  
 */  
        );
        IndicesExistsResponse indexExistResponse = client().admin().indices().prepareExists("test").get();
        createIndex(  
        }
                assertThat(
        Settings node0DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(0));
        assertTrue(clusterRerouteResponse.isAcknowledged());  
    }
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()  
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);  
        logger.info("--> restarting the node 0");
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsResponse;
        assertEquals(internalCluster().numDataNodes(), searchShardsResponse.getNodes().length);  
            if (recoveryState.getPrimary()) {
    private void assertNodeStoreFilesMetadataSuccessCase(
        client().admin().indices().prepareRefresh().execute().actionGet();
                Settings.builder()
            .endObject()  
        Settings replicaNode1DataPathSettings = internalCluster().dataPathSettings(nodesWithReplicaShards.get(1));
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);
        response = ActionTestUtils.executeBlocking(
        client(primaryNode).admin().indices().prepareFlush("test").setForce(true).get();
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
        AcknowledgedResponse deleteIndexResponse = client().admin().indices().prepareDelete("test").get();
                    )
            }
import org.opensearch.index.MergePolicyProvider;
            for (ShardRouting shardRouting : shardRoutings) {
            long recovered = 0;
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
        return Arrays.asList(MockFSIndexStore.TestPlugin.class, InternalSettingsPlugin.class);  
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(  
                return Settings.builder().put(RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 2).build();
        String[] indices,  
        client().prepareIndex("test")
            client().admin().indices().prepareGetSettings("test").get().getIndexToSettings().get("test")  
    public void testAllocationExplainReturnsNoWhenExtraReplicaShardInBatchMode() throws Exception {  
    }  
        ensureRed("test");
    }
        Map<String, long[]> primaryTerms = assertAndCapturePrimaryTerms(null);
                final Path indexPath = path.resolve(ShardPath.INDEX_FOLDER_NAME);
        }  
            ShardsBatchGatewayAllocator.class,  
import org.opensearch.cluster.routing.ShardRoutingState;
                                Files.delete(item);
        assertEquals(0, health.getRelocatingShards());
    public void testShardFetchCorruptedShardsUsingBatchAction() throws Exception {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
            .setSource(jsonBuilder().startObject().field("field", "value1").endObject())  
        ShardId shardId
        health = client(internalCluster().getClusterManagerName()).admin().cluster().health(Requests.clusterHealthRequest()).actionGet();
        ensureGreen();
            ShardRouting[] shardRoutings = clusterSearchShardsGroup.getShards();
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;  
        assertAcked(  
import java.util.stream.Collectors;  
        Index index1 = resolveIndex(index1Name);  
        // clean two nodes
            internalCluster().getInstance(TransportNodesListShardStoreMetadataBatch.class),  
        health = client(internalCluster().getClusterManagerName()).admin().cluster().health(Requests.clusterHealthRequest()).actionGet();
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);  
        );  
            .setId("1")
        logger.info("Running Cluster Health (wait for the shards to startup)");
                XContentFactory.jsonBuilder()
        // assign one primary shard each to the data nodes
        internalCluster().startClusterManagerOnlyNodes(
                    .field("type", "keyword")  
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), batchModeEnabled).build()
            } else {
            .execute()
        String index2Name = "test2";  
                .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true)  
import org.opensearch.index.shard.ShardPath;
        client().admin().indices().prepareRefresh().execute().actionGet();
        // Now start last data node and ensure batch mode is working and cluster goes green
        assertNull(nodeStoreFilesMetadata.getStoreFileFetchException());  
import java.util.Collection;
        assertEquals(0, health.getUnassignedShards());  
            .startObject("properties")  
        assertEquals(GREEN, health.getStatus());
        Collections.shuffle(requiredStartedShards, random());
            .setId("2")
        ensureStableCluster(7);
                            .size(),  
        }
        }  
import org.opensearch.env.NodeEnvironment;  
        // They would then be removed from any batch and batches would get deleted, so we would have 0 replica batches
        clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
import java.util.Arrays;
        for (int i = 0; i < 10; i++) {
    }
        logger.info("Running Cluster Health (wait for the shards to startup)");
                assertThat("no translog ops should be recovered", recoveryState.getTranslog().recoveredOperations(), equalTo(0));
        }
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "60m")  
        logger.info("--> running cluster_health (wait for the shards to startup)");
        ensureGreen("test");
                return super.onNodeStopped(nodeName);
                        "2_" + id,
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(1)).put(node1DataPathSettings).build());  
        createIndex(
            .actionGet();  
                            .retentionLeases()
        corruptShard(searchShardsResponse.getNodes()[0].getName(), shardId);
            }
        DiscoveryNode[] discoveryNodes = getDiscoveryNodes();  
                    reused += file.length();
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("field", "value2")).get(), value2Docs);  
            Integer shardId = 0;  
        Settings clusterManagerDataPathSettings = internalCluster().dataPathSettings(clusterManagerName);
        Settings node0DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(0));  
        Settings node0DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(0));  
        internalCluster().fullRestart();  
import org.opensearch.cluster.ClusterState;  
            .actionGet();
                    .startObject("field1")
            IndexService indexShards = indexServices.indexServiceSafe(idx);
        internalCluster().startNode();
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;  
    }
            for (final ReplicationLuceneIndex.FileMetadata file : recoveryState.getIndex().fileDetails()) {
            .setMapping(  
            .endObject()
        logger.info("--> Now do a protective reroute"); // to avoid any race condition in test
        assertEquals(0, health.getRelocatingShards());
        TransportNodesListGatewayStartedShardsBatch.NodesGatewayStartedShardsBatch response;
                .prepareAllocationExplain()
        ClusterHealthResponse health = client().admin()
        DiscoveryNode node = internalCluster().getInstance(ClusterService.class, nodeName).localNode();
            internalCluster().getClusterManagerName()
        assertEquals(0, health.getNumberOfDataNodes());
        for (final RecoveryState recoveryState : initialRecoveryReponse.shardRecoveryStates().get("test")) {  
            .setId("10990239")
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(1, gatewayAllocator.getNumberOfStartedShardBatches());
                    .endObject()  
        client().prepareIndex("test")
            .endObject()
            .actionGet();  
                .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true)
            internalCluster().getClusterManagerName()
        assertFalse(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));  
        // TODO: remove once refresh doesn't fail immediately if there a cluster-manager block:
            ShardsBatchGatewayAllocator.class,
                .setPrimary(false)
        TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata nodeStoreFilesMetadata = response.getNodesMap()
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(
            final long[] current = IntStream.range(0, indexMetadata.getNumberOfShards()).mapToLong(indexMetadata::primaryTerm).toArray();  
        assertTrue(clusterRerouteResponse.isAcknowledged());  
        logger.info("--> calling allocation explain API again");
        client().execute(ClearVotingConfigExclusionsAction.INSTANCE, new ClearVotingConfigExclusionsRequest()).get();
        // Now creating a new index with too many replicas and trying again
        assertEquals(AllocationDecision.NO, aud.getAllocationDecision());
        ensureStableCluster(3);  
            nodes,
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(1)).put(node1DataPathSettings).build());
        logger.info("--> starting the two nodes back");  
            .preparePutTemplate("template_1")  
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(0)).put(node0DataPathSettings).build());
            Settings.builder()  
        // They would then be removed from any batch and batches would get deleted, so we would have 0 replica batches  
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
        // All replica shards would be marked ineligible since there are no data nodes.
                    recoveryState.getIndex().reusedBytes()
        waitUntil(
            .prepareCreate("test")
            .actionGet();  
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 2);
                    assertThat(  
            .cluster()
        return requiredStartedShards.stream().map(shard -> state.nodes().get(shard.currentNodeId()).getName()).collect(Collectors.toList());
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
        ensureRed("test");
                client().admin().indices().prepareFlush("test").setForce(true).get();
        final String customDataPath = IndexMetadata.INDEX_DATA_PATH_SETTING.get(
            .execute()  
            .setShard(0)
            .get(shardId);
        internalCluster().startDataOnlyNodes(6);  
            .health(Requests.clusterHealthRequest().waitForGreenStatus().timeout("1m"))
            1,
            1,
                    index(
        int moreDocs = randomIntBetween(1, 1024);
        assertEquals(8, health.getUnassignedShards());
            .health(Requests.clusterHealthRequest().waitForGreenStatus().timeout("1m"))
            if (recoveryState.getTargetNode().getName().equals(replicaNode)) {
            internalCluster().getClusterManagerName()  
                .build()
        TransportNodesListGatewayStartedShards.NodesGatewayStartedShards response;  
    public void testAllocationExplainReturnsNoWhenExtraReplicaShardInNonBatchMode() throws Exception {  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                    client().admin().indices().prepareFlush("test").setForce(true).get();  
        assertTrue(clusterRerouteResponse.isAcknowledged());  
        logger.info("--> restarting the stopped nodes");
import org.opensearch.cluster.routing.UnassignedInfo;  
        // calling reroute and asserting on reroute response  
        internalCluster().startNode();  
        ShardId shardId = new ShardId(index, 0);
            assertThat(response.getNodes().get(0).getGatewayShardStarted().storeException(), nullValue());
        assertEquals(0, health.getRelocatingShards());
        assertEquals(YELLOW, health.getStatus());
        assertEquals("cannot allocate because allocation is not permitted to any of the nodes", aud.getExplanation());  
            .actionGet();
        internalCluster().startClusterManagerOnlyNodes(
}
                    equalTo(filesReused)  
        logger.info("--> running cluster_health (wait for the shards to startup)");  
                    "the segment from the last round of indexing should be recovered",
        int numShards = internalCluster().numDataNodes();  
            assertNodeGatewayStartedShardsHappyCase(gatewayStartedShard);
                assertThat(recoveryState.getIndex().reusedFileCount(), equalTo(recoveryState.getIndex().totalFileCount() - filesRecovered));
                    .get();  
        }
import static org.opensearch.gateway.GatewayRecoveryTestUtils.corruptShard;
        ensureYellow();
            .setId("2")
        internalCluster().startClusterManagerOnlyNodes(  
            1,
import java.util.HashSet;
        );
        TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch response;
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsAction;
        );  
    @Override
import java.util.List;  
        response = ActionTestUtils.executeBlocking(
                if (Files.exists(indexPath)) { // multi data path might only have one path in use
            .getShard(0)  
        logger.info("--> closing first node, and indexing more data to the second node");
        if (ensureGreen) {  
            logger.info("Ensure all primaries have been started");
                // we have to recover the segments file since we commit the translog ID on engine startup  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(0)));
        }
 */  
        assertEquals(GREEN, health.getStatus());
        int value2Docs;
            }
        ensureStableCluster(3);
        assertEquals(0, health.getActiveShards());  
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());  
        // It would then be removed from any batch and batches would get deleted, so we would have 0 replica batches  
import static org.opensearch.gateway.GatewayRecoveryTestUtils.getDiscoveryNodes;
        Index index2 = resolveIndex(index2Name);
        client().prepareIndex("test")  
import org.opensearch.test.InternalTestCluster.RestartCallback;  
        logger.info("--> restarting the second stopped node");  
import java.util.concurrent.TimeUnit;
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("num", 179)).get(), value1Docs);  
import org.opensearch.index.query.QueryBuilders;  
        logger.info("--> restarting the stopped nodes");  
                    .endObject()
        assertTrue(clusterRerouteResponse.isAcknowledged());
    public void testMultipleReplicaShardAssignmentWithDelayedAllocationAndDifferentNodeStartTimeInBatchMode() throws Exception {
                .put("node.name", clusterManagerName)
        assertNotNull(gatewayStartedShard.storeException());
            Settings.builder()  
    }
            .get()  
        refresh();
            if (previous == null) {
        prepareIndex(indexName, numOfShards);  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)  
            }  
            }  
        internalCluster().fullRestart(new RestartCallback() {  
                        greaterThan(previous[shard])  
 * ownership. Elasticsearch licenses this file to you under  
        final String replicaNode = internalCluster().startDataOnlyNode(nodeSettings(1));
        assertNull(nodeStoreFilesMetadata.get(shardId1).getStoreFileFetchException());
        Index idx = resolveIndex(culpritShardIndexName);
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(0, health.getInitializingShards());  
    }
        aud = client().admin()  
        for (int i = 0; i < 10; i++) {
        String index1Name = "test1";
        assertEquals(0, health.getUnassignedShards());
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
                assertNodeStoreFilesMetadataSuccessCase(nodeStoreFilesMetadata, shardId);  
    public void testLatestVersionLoaded() throws Exception {
        // client().admin().cluster().prepareHealth("test").setWaitForYellowStatus().get();  
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());  
        Settings node0DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(0));
            .startObject("properties")  
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(0)).put(node0DataPathSettings).build());
        createIndex(
            new TransportNodesListShardStoreMetadataBatch.Request(shardAttributesMap, nodes)
            Settings.builder().put("node.name", nodesWithReplicaShards.get(0)).put(replicaNode0DataPathSettings).build()  
            .execute()  
        internalCluster().fullRestart();  
            "testg",
        ClusterHealthResponse health = client().admin()
        } else {  
        createIndex(
        TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch response;
        waitUntil(delayedShardAllocationStatusVerificationSupplier, 2, TimeUnit.MINUTES);  
    }
        this.allocationExplainReturnsNoWhenExtraReplicaShard(true);  
        ensureYellow();  
            @Override
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(  
            internalCluster().getClusterManagerName()
        // calling reroute and asserting on reroute response  
        // corrupt test1 index shards
            }
        client().admin().indices().prepareFlush().execute().actionGet();
import java.util.stream.IntStream;
        logger.info("--> restarting the second stopped node");  
            )
        clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
            .setId("10990513")
        }
        response = ActionTestUtils.executeBlocking(
            .addAlias("test", "test_alias", QueryBuilders.termQuery("field", "value"))
        );  
            client().prepareIndex(prefix + i).setId("1").setSource("foo", "bar").get();
                            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0)  
                        "test",
        // nodes may need to report the shards they processed the initial recovered cluster state from the cluster-manager
        for (final IndexMetadata indexMetadata : state.metadata().indices().values()) {  
        );
        createIndex(
        // Now start cluster manager node and post that verify batches created
                        }  
        ensureStableCluster(2);
 * not use this file except in compliance with the License.
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(1)));  
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
                                logger.debug("--> deleting [{}]", item);  
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("field", "value2")).get(), value2Docs);
        logger.info("--> restarting the stopped node");
        if (corrupt) {
            for (int id = 0; id < Math.max(value1Docs, value2Docs); id++) {
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfPrimaryShards)
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 2);
        client().prepareIndex("test")
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(0, health.getRelocatingShards());
import org.opensearch.cluster.coordination.ElectionSchedulerFactory;
        }
            1,  
        internalCluster().startDataOnlyNode(
            3,
        );
            internalCluster().getClusterManagerName()
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(false).get();
            .field("type", "integer")
            .get(discoveryNodes[0].getId())
import org.opensearch.core.index.shard.ShardId;
                    .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")  
        String metadataUuid = client().admin().cluster().prepareState().execute().get().getState().getMetadata().clusterUUID();
        assertEquals(RED, health.getStatus());  
        createIndex("test", Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).build());
            .prepareAllocationExplain()
        logger.info("--> restarting the stopped nodes");
        Settings node1DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(1));  
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        ClusterSearchShardsResponse searchShardsResponse = client().admin().cluster().prepareSearchShards(indexName).get();
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
        Index index = resolveIndex(indexName);  
    }
        DiscoveryNode[] discoveryNodes = getDiscoveryNodes();  
        for (int i = 0; i < numDocs; i++) {  
import static org.opensearch.cluster.health.ClusterHealthStatus.RED;
        ShardId shardId1 = new ShardId(index1, 0);
 *    http://www.apache.org/licenses/LICENSE-2.0
        // INDEX_CREATED
        internalCluster().stopRandomDataNode();
                );  
    }
        if (corrupt) {
        assertTrue(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));
            .execute()
        assertEquals(0, health.getActiveShards());
            .indices()
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("field", "value1")).get(), value1Docs);
        for (int i = 0; i <= randomInt(10); i++) {  
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), value1Docs + value2Docs);  
import static org.hamcrest.Matchers.nullValue;
        // Now start one data nodes and ensure batch mode is working  
            .field("type", "text")
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("field", "value1")).get(), value1Docs);
 * GitHub history for details.
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        for (ShardStats shardStats : indexStats.getShards()) {
        assertThat(indicesStats.getSuccessfulShards(), equalTo(100));
            "test",
            public boolean clearData(String nodeName) {
                .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true)  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(0)));
                );
        createNIndices(50, "test");
        client().prepareIndex("test")
    }
        ClusterHealthResponse health = client().admin()  
        );  
        assertFalse(health.isTimedOut());
            .actionGet();
import org.opensearch.Version;
        assertTrue(gatewayStartedShard.primary());
        for (final RecoveryState recoveryState : recoveryResponse.shardRecoveryStates().get("test")) {  
        logger.info("--> calling reroute while cluster is yellow");
        // Total number of replica shards = 50 (50 indices*1)  
        assertEquals(AllocationDecision.NO, aud.getAllocationDecision());
        assertEquals(GREEN, health.getStatus());
        client().prepareIndex("test")
                    .put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicaShards)  
    private void prepareIndex(String indexName, int numberOfPrimaryShards) {
        // Total batches creation for primaries and replicas will be 10 each
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(1)));
                    .endObject()
        refresh();  
        // https://github.com/elastic/elasticsearch/issues/9997
        assertThat(indicesStats.getSuccessfulShards(), equalTo(100));
        ensureGreen("test");  
        ensureStableCluster(3);
                return Settings.builder()
        assertFalse(health.isTimedOut());  
                    .startObject()
        ShardsBatchGatewayAllocator gatewayAllocator = internalCluster().getInstance(
        internalCluster().startDataOnlyNodes(5);
            @Override
        ensureYellow("test");
                } else {  
        }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(0)));
import org.opensearch.index.IndexSettings;  
 * Modifications Copyright OpenSearch Contributors. See
        Settings node2DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(2));
        // start another node so cluster consistency checks won't time out due to the lack of state
    }
        for (int i = 0; i < 10; i++) {  
        final String primaryNode = internalCluster().startDataOnlyNode(nodeSettings(0));  
                for (int shard = 0; shard < current.length; shard++) {
import org.opensearch.action.support.ActionTestUtils;
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(  
                // index some more documents; we expect to reuse the files that already exist on the replica
                .getExplanation()  
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(1)).put(node1DataPathSettings).build());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    }
        ensureGreen("test");  
                    filesReused++;
                    recoveryState.getIndex().reusedFileCount(),
            prepareCreate("test").setSettings(
            1,  
        );
        assertEquals(0, gatewayAllocator.getNumberOfInFlightFetches());  
        // wait for cluster to turn green
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(2);
        Settings node1DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(1));
        assertEquals(1, gatewayAllocator.getNumberOfStartedShardBatches());
            .execute()
 *
        assertEquals(0, gatewayAllocator.getNumberOfInFlightFetches());
            .execute()
            logger.debug("--> failing shard [{}] on node [{}]", shardId, node);
        assertFalse(health.isTimedOut());
            .endObject()
        assertEquals(nonExistingNode.getId(), response.failures().get(0).nodeId());  
        GatewayStartedShard gatewayStartedShard = response.getNodesMap()  
        }  
        logger.info("--> calling allocation explain API 3rd time");
    }
        );  
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 3);  
    private void allocationExplainReturnsNoWhenExtraReplicaShard(boolean batchModeEnabled) throws Exception {
            .startObject()
        assertEquals(8, health.getActiveShards());
            .getShardAllocationDecision()
        assertFalse(storeFileMetadata.isEmpty());
        assertFalse(health.isTimedOut());  
        );
            final long[] previous = previousTerms.get(index);
        assertEquals(RED, health.getStatus());
import org.opensearch.cluster.routing.allocation.AllocationDecision;
        flush();  
                .put(ShardsBatchGatewayAllocator.GATEWAY_ALLOCATOR_BATCH_SIZE.getKey(), 5)  
        Settings node0DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(0));  
            .endObject()
            .setSource(jsonBuilder().startObject().startArray("appAccountIds").value(14).endArray().endObject())
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
                        jsonBuilder().startObject().field("field", "value2").startArray("num").value(14).endArray().endObject()  
            "test1",  
            public Settings onNodeStopped(String nodeName) {  
 * You may obtain a copy of the License at  
        }
                    "all existing files should be reused, file count mismatch",
            Settings.builder().put("node.name", nodesWithReplicaShards.get(1)).put(replicaNode1DataPathSettings).build()  
        assertThat(state.metadata().templates().get("template_1").patterns(), equalTo(Collections.singletonList("te*")));
        assertTrue(clusterRerouteResponse.isAcknowledged());
        assertThat(state.metadata().index("test").getAliases().get("test_alias"), notNullValue());  
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());  
        ensureYellow("test"); // wait for primary allocations here otherwise if we have a lot of shards we might have a
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());  
        assertNodeStoreFilesMetadataSuccessCase(nodeStoreFilesMetadata, shardId);  
        client().execute(AddVotingConfigExclusionsAction.INSTANCE, new AddVotingConfigExclusionsRequest(firstNode)).get();
            .indices()  
        ensureGreen("test");
            .setSource(jsonBuilder().startObject().startArray("appAccountIds").value(14).endArray().endObject())
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), value1Docs + value2Docs);
            .get(shardId);
public class RecoveryFromGatewayIT extends OpenSearchIntegTestCase {
            .setSource(jsonBuilder().startObject().startArray("appAccountIds").value(14).value(179).endArray().endObject())  
        ensureStableCluster(1);  
 *  
            .setSource(jsonBuilder().startObject().field("field", "value2").endObject())  
        Settings node2DataPathSettings = internalCluster().dataPathSettings(nodes.get(1));
            Settings.builder()  
        Settings node1DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(1));
            Settings.builder()
            Settings.builder().put(SETTING_NUMBER_OF_SHARDS, numberOfPrimaryShards).put(SETTING_NUMBER_OF_REPLICAS, 0).build()
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
        logger.info("--> checking if documents exist, there should be 3");
        index(indexName, "type", "1", Collections.emptyMap());  
            .cluster()
            ).setMapping(mapping)  
            IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 3)
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("field", "value2")).get(), value2Docs);  
        assertEquals(2, health.getNumberOfDataNodes());
                        "type1",
        assertEquals(100, health.getActiveShards());
        index("test", "type", "1");
            String nodeId = clusterSearchShardsGroup.getShards()[0].currentNodeId();  
            .actionGet();
import org.opensearch.test.InternalTestCluster;
            .indexSettings()
        logger.info("--> add some metadata and additional template");  
import static org.hamcrest.Matchers.equalTo;  
                            .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1")
    private List<String> findNodesWithShard(final boolean primary) {
            ensureGreen(prefix + i);
                // prevent a sequence-number-based recovery from being possible
                logger.info(
        client(primaryNode).admin()  
            Settings.builder()
        // we will reduce batch size to 5 to make sure we have enough batches to test assignment
import java.nio.file.DirectoryStream;
                }
        TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata storeFileMetadata = nodeStoreFilesMetadata.storeFilesMetadata();
        health = client().admin().cluster().health(Requests.clusterHealthRequest().waitForGreenStatus().timeout("5m")).actionGet();
        TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata nodeStoreFilesMetadata,  
                        "primary term didn't increase for [" + index + "][" + shard + "]",
        assertEquals(0, health.getRelocatingShards());
        flush();  
            .prepareAliases()
        // shard that is still in post recovery when we restart and the ensureYellow() below will timeout
        internalCluster().startNodes(
import static org.hamcrest.Matchers.hasSize;
        logger.info("--> Now do a protective reroute");
        Settings clusterManagerDataPathSettings = internalCluster().dataPathSettings(clusterManagerName);
        ensureGreen();
                assertThat(recoveryState.getIndex().recoveredBytes(), equalTo(0L));  
            .setIndex("test2")  
        internalCluster().startClusterManagerOnlyNodes(  
                client(primaryNode).admin()
        assertEquals(0, health.getNumberOfDataNodes());  
        assertNotNull(gatewayStartedShard.allocationId());  
        }  
        assertFalse(health.isTimedOut());  
            .prepareAllocationExplain()
            .getExplanation()
            ShardsBatchGatewayAllocator.class,  
            .cluster()
                if (id < value2Docs) {
@ClusterScope(numDataNodes = 0, scope = Scope.TEST)
        ensureGreen("test");
                result.put(index, current);  
        assertEquals(100, health.getUnassignedShards());
            .execute()
                    equalTo(reused)
                    .put("number_of_replicas", 1)  
        // shard should still have decision NO because there are 6 replicas and 5 data nodes
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(0, gatewayAllocator.getNumberOfInFlightFetches());
                .cluster()  
        });  
 * software distributed under the License is distributed on an
        String indexName = "test";
                }  
        Settings node1DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(1));  
            int filesReused = 0;
                assertThat(recoveryState.getIndex().reusedBytes(), equalTo(recoveryState.getIndex().totalBytes() - recovered));  
        final boolean corrupt = randomBoolean();
                            .leases()
            .setSource(jsonBuilder().startObject().field("field", "value3").endObject())
        logger.info("Running Cluster Health (wait for the shards to startup)");
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(0)));
import org.opensearch.cluster.node.DiscoveryNode;  
                .getShardAllocationDecision()
        primaryTerms = assertAndCapturePrimaryTerms(primaryTerms);
            new TransportNodesListGatewayStartedShards.Request(shardId, customDataPath, new DiscoveryNode[] { node })  
                .put(clusterManagerDataPathSettings)
        // Now start both data nodes and ensure batch mode is working
        assertEquals(AllocationDecision.NO, aud.getAllocationDecision());
            ShardsBatchGatewayAllocator.class,
                    recoveryState.getSourceNode().getName(),
                assertThat(recoveryState.getIndex().reusedBytes(), equalTo(recoveryState.getIndex().totalBytes()));
            .setPrimary(false)
            .setId("2")  
        assertEquals(RED, health.getStatus());  
        ensureYellow();
            final String index = indexMetadata.getIndex().getName();
    }  
                );
        assertEquals(shardId1, nodeStoreFilesMetadata.get(shardId1).storeFilesMetadata().shardId());
                assertThat("number of terms changed for index [" + index + "]", current.length, equalTo(previous.length));
        DiscoveryNode nonExistingNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(0)).put(node0DataPathSettings).build());  
        internalCluster().startClusterManagerOnlyNodes(
                    recoveryState.getIndex().reusedBytes(),  
            () -> client().admin().cluster().health(Requests.clusterHealthRequest().timeout("5m")).actionGet().getActiveShards() == 3,  
    public void testShardStoreFetchMultiNodeMultiIndexesUsingBatchAction() throws Exception {  
        logger.info("--> Now do a protective reroute"); // to avoid any race condition in test
                );  
            int filesRecovered = 0;  
            }
            .startObject("appAccountIds")
        Settings clusterManagerDataPathSettings = internalCluster().dataPathSettings(clusterManagerName);
        ensureGreen();  
        );
        Map<ShardId, TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata> nodeStoreFilesMetadata = response.getNodesMap()  
        TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch response = prepareAndSendRequest(  
            false
            .getNodeStoreFilesMetadataBatch()
        String clusterManagerName = internalCluster().getClusterManagerName();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        ensureStableCluster(4);
        assertFalse(health.isTimedOut());
        createIndex(
                    .getNodeStoreFilesMetadataBatch()
            .actionGet();
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
    public void testOneNodeRecoverFromGateway() throws Exception {  
        );
    }
        internalCluster().stopCurrentClusterManagerNode();  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodesWithReplicaShards.get(0)));
                        "test",  
            GatewayStartedShard gatewayStartedShard = response.getNodesMap().get(nodeId).getNodeGatewayStartedShardsBatch().get(shardId);
            .get()  
        // note: default replica settings are tied to #data nodes-1 which is 0 here. We can do with 1 in this test.
        } else {
        logger.info("Running Cluster Health (wait for the shards to startup)");
        logger.info("Running Cluster Health (wait for the shards to startup)");  
        // assert no batches created
        corruptShard(searchShardsResponse.getNodes()[1].getName(), shardId1);
                assertThat("> 0 files should be reused", recoveryState.getIndex().reusedFileCount(), greaterThan(0));  
        internalCluster().startNodes(
        internalCluster().fullRestart();
            assertEquals(2, shardRoutings.length);  
            .indexServiceSafe(resolveIndex("test"))
        List<String> nodes = internalCluster().startNodes(2, Settings.builder().put(RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 2).build());  
        });
import static org.hamcrest.Matchers.not;  
        // It would then be removed from any batch and batches would get deleted, so we would have 0 replica batches
            .actionGet();  
                    .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()) // disable bootstrapping  
        );  
        final Index index = resolveIndex(indexName);  
        ensureGreen();  
                .build()
            .setId("10990473")  
        ensureGreen("test2");
            .execute()
        internalCluster().startClusterManagerOnlyNodes(
            .execute()
        ensureStableCluster(6);
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;  
        int numOfShards = 1;
            ensureYellow();  
        final ShardId shardId = new ShardId(index, 0);
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch;
                if (files.contains(file.name()) == false) {  
        assertFalse(indexExistResponse.isExists());  
        ClusterSearchShardsResponse searchShardsResponse = client().admin().cluster().prepareSearchShards(indexName).get();  
        waitUntil(delayedShardAllocationStatusVerificationSupplier, 2, TimeUnit.MINUTES);
        internalCluster().startClusterManagerOnlyNodes(
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 5).build()
        assertFalse(health.isTimedOut());
                    .startObject("properties")  
        internalCluster().fullRestart();  
    }
                .getAllocationDecision()  
                        current[shard],
        String indexName1 = "test1";  
            public Settings onNodeStopped(String nodeName) throws Exception {
        Settings node0DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(0));  
            .get();
        }
            .setPatterns(Collections.singletonList("te*"))
        );
            .getNodeStoreFilesMetadataBatch();
            internalCluster().getClusterManagerName()
        );
        logger.info("--> Now do a reroute so batches are created"); // to avoid any race condition in test  
import java.util.function.BooleanSupplier;
            2,
        ensureGreen("test", "test1", "test2", "testg");  
 */
        );
        GatewayStartedShard gatewayStartedShard = response.getNodesMap()
                    recoveryState.getTargetNode().getName(),  
            .actionGet();
        client().prepareIndex("test")
    public void testSingleShardFetchUsingBatchAction() {  
        assertTrue(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));  
        // shard should have decision NO because there are 6 replicas and 4 data nodes
        assertEquals(0, gatewayAllocator.getNumberOfStoreShardBatches());
        internalCluster().fullRestart();
        ensureStableCluster(3);  
        final Index index = resolveIndex(indexName);
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
import org.opensearch.core.index.Index;
        int value1Docs;  
    public void testStartedShardFoundIfStateNotYetProcessed() throws Exception {
        logger.info("--> restarting the first stopped node");
        logger.info("Running Cluster Health (wait for the shards to startup)");
            .prepareAllocationExplain()
            );
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
        );
            client().prepareIndex(prefix + i).setId("2").setSource("foo2", "bar2").get();
        assertNodeStoreFilesMetadataSuccessCase(nodeStoreFilesMetadata.get(shardId2), shardId2);
                // make sure state is not recovered  
    public void testDeleteRedIndexInBatchMode() throws Exception {
        assertEquals(10, gatewayAllocator.getNumberOfStartedShardBatches());
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()  
                assertThat(recoveryState.getIndex().reusedFileCount(), equalTo(recoveryState.getIndex().totalFileCount()));  
import org.opensearch.common.xcontent.XContentFactory;  
        );  
package org.opensearch.gateway;
                    .endObject()
        assertEquals(0, health.getInitializingShards());  
        ensureGreen("test");  
            .getAllocateDecision();  
import java.util.Collections;  
        }
    }  
            )
    private void assertNodeGatewayStartedShardsHappyCase(GatewayStartedShard gatewayStartedShard) {
            .startObject()
        internalCluster().startClusterManagerOnlyNodes(  
            client().admin()
    public void testShardStoreFetchNodeNotConnectedUsingBatchAction() {
    ) {
                    recovered += file.length();
        // Total number of primary shards = 50 (50 indices*1)
        internalCluster().stopCurrentClusterManagerNode();
            ShardsBatchGatewayAllocator.class,
        assertNull(gatewayStartedShard.storeException());
        client().prepareIndex("test")
        );
            shard.failShard("test", new CorruptIndexException("test corrupted", ""));  
                .getAllocateDecision()
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(1)).put(node1DataPathSettings).build());
                .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true)
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 4).build()
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        assertEquals(0, gatewayAllocator.getNumberOfStartedShardBatches());
                index,  
        internalCluster().startDataOnlyNode(  
        // shard should be unassigned because of Allocation_Delayed  
        for (int i = 0; i < 10; i++) {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.plugins.Plugin;  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(1)));  
            value1Docs = randomIntBetween(numberOfShards * 10, numberOfShards * 20);  
        assertEquals(2, health.getUnassignedShards());
                    "all existing files should be reused, byte count mismatch",
        createNIndices(50, "test"); // this will create 50p, 50r shards
        // Non batch mode - This test is to validate that we don't return AWAITING_INFO in allocation explain API when the deciders are
        Settings node1DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(1));
                }
                    .prepareUpdateSettings("test")
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), value1Docs + value2Docs);
    }  
        // Now start last data node and ensure batch mode is working and cluster goes green
                    )
        assertThat(state.metadata().index("test").getAliases().get("test_alias").filter(), notNullValue());
            "test2",
    }
                .put(ShardsBatchGatewayAllocator.PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey(), "20s")
        assertEquals(RED, health.getStatus());  
                    try (DirectoryStream<Path> stream = Files.newDirectoryStream(indexPath)) {  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
                    );
import static org.opensearch.index.query.QueryBuilders.termQuery;  
            internalCluster().getInstance(TransportNodesListGatewayStartedShardsBatch.class),  
        health = client(internalCluster().getClusterManagerName()).admin().cluster().health(Requests.clusterHealthRequest()).actionGet();
                    // expire retention leases quickly
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
                .build()  
import org.opensearch.test.InternalSettingsPlugin;
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
            .setIndex("test2")  
    public void testReuseInFileBasedPeerRecovery() throws Exception {
            .filter(startedShard -> startedShard.primary() == primary)
        createIndex(
        response = ActionTestUtils.executeBlocking(  
        String clusterManagerName = internalCluster().getClusterManagerName();
        assertTrue(deleteIndexResponse.isAcknowledged());
                    client(primaryNode).prepareIndex("test").setSource("field", "value").execute().actionGet();
        prepareIndex(indexName2, numShards);  
        TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch response = prepareAndSendRequest(
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(1)).put(node1DataPathSettings).build());
        assertThat(client().admin().cluster().prepareState().execute().get().getState().getMetadata().clusterUUID(), equalTo(metadataUuid));
        // Replica shard would be marked ineligible since there are no data nodes.
        String clusterManagerName = internalCluster().getClusterManagerName();  
 * this work for additional information regarding copyright
                        equalTo(1)
            1,
                .setIndex("test")
                .put(clusterManagerDataPathSettings)  
                .put(ShardsBatchGatewayAllocator.PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey(), "-1")
        assertEquals(0, health.getInitializingShards());
                .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms")
            .execute()  
        assertEquals(0, health.getInitializingShards());
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();  
        }
        assertEquals(0, health.getActiveShards());  
        // wait for cluster to turn green
        internalCluster().startNodes(2);
        boolean ensureGreen
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("num", 179)).get(), value1Docs);
        logger.info("--> calling allocation explain API");
        assertNotNull(storeFileMetadata.peerRecoveryRetentionLeases());
            .actionGet();  
                }
        shardAttributesMap = prepareRequestMap(indices, 1);  
            }  
        assertTrue(nodeStoreFilesMetadata.get(shardId1).storeFilesMetadata().isEmpty());  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build()
import org.opensearch.index.shard.IndexShard;
        logger.info("--> restarting the first stopped node");
        ClusterState state = client().admin().cluster().prepareState().get().getState();
            new String[] { indexName },  
        internalCluster().startDataOnlyNode(
        client().admin()
            internalCluster().getInstance(TransportNodesListGatewayStartedShardsBatch.class),
        assertEquals(GREEN, health.getStatus());
        assertEquals(2, health.getNumberOfDataNodes());  
        client().prepareIndex("test")
    ) {  
import java.util.Map;
import org.opensearch.transport.client.Requests;
        assertNodeGatewayStartedShardsHappyCase(gatewayStartedShard);
        for (int i = 0; i < n; i++) {
        Map<String, long[]> primaryTerms = assertAndCapturePrimaryTerms(null);  
                    .field("type", "text")
        // Replica shard would be marked ineligible since there are no data nodes.  
        createIndex(
        }  
            ShardId shardId = clusterSearchShardsGroup.getShardId();
        ensureGreen("test");
            .indices()
    public void testNBatchesCreationAndAssignment() throws Exception {  
        );  
        ensureRed("test", "test1", "test2");
        }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(1)));
        int numDocs = randomIntBetween(1, 1024);
        ensureGreen("test");
        for (String node : internalCluster().nodesInclude(culpritShardIndexName)) {  
    }
        logger.info("--> stopping the second node");  
        final Index index = resolveIndex("test");
        String culpritShardIndexName = "test0";
        ClusterRerouteResponse clusterRerouteResponse = client().admin().cluster().prepareReroute().setRetryFailed(true).get();
        boolean indexToAllShards = randomBoolean();
            @Override  
            assertHitCount(client().prepareSearch().setSize(0).setQuery(termQuery("num", 179)).get(), value1Docs);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(0)));  
        internalCluster().startDataOnlyNode(Settings.builder().put("node.name", dataOnlyNodes.get(0)).put(node0DataPathSettings).build());
        return result;
            .setId("3")  
            true  
    }
        for (String index : indices) {
        TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch response = prepareAndSendRequest(
            .setIndex("test")  
        corruptShard(searchShardsResponse.getNodes()[0].getName(), shardId1);  
        // Now start one data node  
        internalCluster().startClusterManagerOnlyNodes(
        Map<ShardId, ShardAttributes> shardIdShardAttributesMap = prepareRequestMap(new String[] { indexName }, numOfShards);
            Settings.builder().put("node.name", nodesWithReplicaShards.get(0)).put(replicaNodeDataPathSettings).build()
        assertEquals(GREEN, health.getStatus());
                    .put("number_of_shards", 1)
        }
    }  
        }
        ensureStableCluster(2);
        }
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;  
                        jsonBuilder().startObject().field("field", "value1").startArray("num").value(14).value(179).endArray().endObject()
            .setShard(0)
                .put("node.name", clusterManagerName)
            .getNodeGatewayStartedShardsBatch()  
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true).build()
        String indexName = "test";
        assertTrue(health.isTimedOut());
                if (softDeleteEnabled) { // We need an extra flush to advance the min_retained_seqno of the SoftDeletesPolicy
            nodes,  
        ensureGreen("test");  
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(2);  
        flush("test");
        ensureYellow();  
        ClusterSearchShardsResponse searchShardsResponse = client().admin().cluster().prepareSearchShards(indexName1, indexName2).get();
        DiscoveryNode[] nodes = getDiscoveryNodes();  
import static org.opensearch.cluster.health.ClusterHealthStatus.YELLOW;
                        Settings.builder()  
        TransportNodesListGatewayStartedShardsBatch.NodesGatewayStartedShardsBatch response;  
        internalCluster().startNode();  
                        "1_" + id,  
        // start the replica node; we do this after indexing so a file-based recovery is triggered to ensure the files are identical  
        createIndex(
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).execute().actionGet(), 3);
            1,  
    public void testBatchModeEnabledWithSufficientTimeoutAndClusterGreen() throws Exception {  
        );  
                    .build();
        ensureStableCluster(1);  
        client().prepareIndex("test")
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(3);
 * specific language governing permissions and limitations
            internalCluster().getInstance(TransportNodesListGatewayStartedShardsBatch.class),  
            value2Docs = 1;  
            .setSettings(  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataOnlyNodes.get(1)));
        );
    public void assertSyncIdsNotNull() {  
 * SPDX-License-Identifier: Apache-2.0
    public void testMessyElectionsStillMakeClusterGoGreen() throws Exception {  
        prepareIndices(new String[] { index1Name, index2Name }, 1, 1);
                TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata nodeStoreFilesMetadata = response.getNodesMap()
            .setId("1")  
        internalCluster().fullRestart();
            .setShard(0)
    }
        assertTrue(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(internalCluster().clusterService().getSettings()));
        );
                .put(ShardsBatchGatewayAllocator.REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey(), "-1")
            "test",
            .getShardAllocationDecision()
    public void testSingleNodeNoFlush() throws Exception {
    private Map<String, long[]> assertAndCapturePrimaryTerms(Map<String, long[]> previousTerms) {  
        );  
        String indexName2 = "test2";
        String indexName1 = "test1";
        for (ClusterSearchShardsGroup clusterSearchShardsGroup : searchShardsResponse.getGroups()) {  
        logger.info("Running Cluster Health (wait for the shards to startup)");
            .health(Requests.clusterHealthRequest().waitForGreenStatus().timeout("5m"))
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()  
    }  
            .toString();  
        // Now start both data nodes and ensure batch mode is working
    private void createNIndices(int n, String prefix) {
        List<String> nodesWithReplicaShards = findNodesWithShard(false);  
import org.opensearch.indices.store.ShardAttributes;  
        ensureStableCluster(7);
    public void testBatchModeDisabled() throws Exception {
        }
        );  
        }  
        createIndex(
        logger.info("--> restart replica node");  
                    .setSettings(
            .field("type", "text")
            .cluster()  
            new TransportNodesListShardStoreMetadataBatch.Request(shardAttributesMap, discoveryNodes)
            .get(shardId);  
            indexName,  
                result.put(index, current);
        assertEquals(1, health.getDelayedUnassignedShards());
    }
        // returning NO
        createIndex(
        Settings replicaNode0DataPathSettings = internalCluster().dataPathSettings(nodesWithReplicaShards.get(0));  
        Settings node1DataPathSettings = internalCluster().dataPathSettings(dataOnlyNodes.get(1));
                .put("node.name", clusterManagerName)
        List<String> nodesWithReplicaShards = findNodesWithShard(false);
        ensureGreen("test");  
                .put(ShardsBatchGatewayAllocator.GATEWAY_ALLOCATOR_BATCH_SIZE.getKey(), 5)
        );
import static org.opensearch.gateway.GatewayService.RECOVER_AFTER_DATA_NODES_SETTING;
            }
                    index(  
        logger.info("--> Now do a protective reroute");
        }
