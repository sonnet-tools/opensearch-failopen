            .put(indexSettings())
import org.opensearch.action.termvectors.TermVectorsRequestBuilder;
            .actionGet();
        assertEquals(
    public void testPrimaryStopped_ReplicaPromoted() throws Exception {
            .setId(Integer.toString(1))
                false,
            .setWaitForNoRelocatingShards(true)
    public void testRealtimeGetRequestsUnsuccessful() {
    public void testCancellation() throws Exception {
    }
            .setPositions(true)
        });
        // realtime termvectors (preference = _replica)
                    .startObject("properties")
        assertThat(mgetResponse.getResponses().length, is(3));
        );
import org.apache.lucene.index.IndexWriterConfig;
            waitForDocs(initialDocCount, indexer);
    }
            // update to add replica, initiating recovery, this will get stuck at last step
                final SegmentReplicationShardStats stats = shardStatsSet.stream().findFirst().get();
        });
    }
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertAcked(
        client().prepareIndex(INDEX_NAME)
            .add(new MultiGetRequest.Item(INDEX_NAME, "2").routing(id))
            .setRealtime(true)
import org.opensearch.common.util.FeatureFlags;
                RandomizedTest.scaledRandomIntBetween(2, 5),
        assertBusy(() -> {
            assertEquals(0L, replicationStats.maxReplicationLag);
        clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();
        assertBusy(() -> { assertDocCounts(docCount, replicaNode); });
                -1,
            .findFirst()
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
            assertEquals("We should have stats returned for the replication group", 1, shardStats.size());
        assertThat(mgetResponse.getResponses()[2].getFailure().getMessage(), is("no such index [nonExistingIndex]"));
                RandomizedTest.scaledRandomIntBetween(2, 5),
        assertThat(mgetResponse.getResponses()[1].getResponse().getSourceAsMap().get("foo2").toString(), equalTo("bar2"));
        logger.info("Local segments after force merge and commit {}", getLatestSegmentInfos(replicaShard).files(false));
            assertEquals(
            client().prepareIndex(INDEX_NAME).setId(String.valueOf(i)).setSource("foo", "bar").get();
        forceMerge();
                    Settings.builder()
            BackgroundIndexer indexer = new BackgroundIndexer(
            assertTrue("replica should be promoted as a primary", replica_1.routingEntry().primary() || replica_2.routingEntry().primary());
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
    public void testReplicationPostDeleteAndForceMerge() throws Exception {
    public void testReplicationAfterForceMerge() throws Exception {
            client().admin()
import org.opensearch.index.engine.EngineConfig;
            .add(new MultiGetRequest.Item(INDEX_NAME, "1").routing(routingOtherShard))
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
            .startObject("properties")
        assertEquals(getNodeContainingPrimaryShard().getName(), primary);
        ensureGreen(INDEX_NAME);
        assertThat(response.getSourceAsMap().get("foo").toString(), equalTo("bar"));
import org.apache.lucene.index.Fields;
        logger.info("--> Closing the index ");
        for (int i = 0; i < initialDocCount; i++) {
            waitForDocs(initialDocCount, indexer);
        assertTrue(mgetResponse.getResponses()[1].isFailed());
        ensureGreen(INDEX_NAME);
        assertTrue("FileCache should not be empty", replicaFileCache.size() > 0);
    }
        flushAndRefresh(INDEX_NAME);
        // add some docs to the xlog and drop primary.
                .setSettings(
                    .setId(Integer.toString(i))
        // Flush segments to disk and create a new commit point (Primary: segments_3, _s1.si)
        ensureGreen(INDEX_NAME);
     * Tests whether segment replication supports realtime MultiGet requests and reads and parses source from the translog to serve strong reads.
        assertAcked(
import org.opensearch.action.get.MultiGetResponse;
        // realtime multi get 1 (routing set)
            .setSource("online", false, "ts", System.currentTimeMillis() - 100, "type", "bs")
        );
            assertEquals("cache data path should not exists", false, Files.exists(cacheDataPath));
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
        // waitForSearchableDocs(initialDocCount, replica, primary);
        ensureGreen(INDEX_NAME);
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));
                .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)
                client(),
            .findFirst()
            flush(INDEX_NAME);
                    .prepareUpdateSettings(INDEX_NAME)
        } else {
        ensureGreen(INDEX_NAME);
        InternalTestCluster internalTestCluster = internalCluster();
            .actionGet();
    }
                INDEX_NAME,
            Collections.emptySet(),
        performReplicationAfterForceMerge(true, SHARD_COUNT);
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").get();
                -1,
            refresh(INDEX_NAME);
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime multi get
import org.opensearch.index.store.remote.filecache.FileCache;
        final Node node = internalCluster().getInstance(Node.class, nodeName);
        // Ingesting docs again before force merge
            .build();
            prepareCreate(INDEX_NAME).setMapping(
        client().prepareIndex(INDEX_NAME)
     */
        ensureGreen(INDEX_NAME);
                    .field("format", "epoch_millis")
        for (int i = initialDocCount; i < initialDocCount + additionalDocs; i++) {
    }
    }
            )
        ensureGreen(INDEX_NAME);
        try (
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
            Document doc = new Document();
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 1);
            .setRouting(routingOtherShard)
            refresh(INDEX_NAME);
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        // start another node, index another doc and replicate.
        assertThat(mgetResponse.getResponses().length, is(2));
        final String nodeA = internalCluster().startDataAndWarmNodes(1).get(0);
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
        assertThat(mgetResponse.getResponses()[1].getIndex(), is(INDEX_NAME));
            );
            indexer.start(initialDocCount);
                    .endObject()
        nodes.add(primaryNode);
            waitForDocs(initialDocCount, indexer);
        assertThat(fields.size(), equalTo(1));
            .get();
                random()
        final Settings settings = Settings.builder()
            .execute()
            internalCluster().getInstance(TransportService.class, replicaNode),
        assertThat(mgetResponse.getResponses()[2].getIndex(), is("nonExistingIndex"));
        assertTrue(replicaShardRouting + " should be promoted as a primary", replicaShardRouting.primary());
            .actionGet();
     * This tests that if a primary receives docs while a replica is performing round of segrep during recovery
                    .must(
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
        prepareCreate(
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
            BackgroundIndexer indexer = new BackgroundIndexer(
    public void testPrimaryReceivesDocsDuringReplicaRecovery() throws Exception {
        assertThat(fields.size(), equalTo(1));
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            INDEX_NAME,
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
        final Path shardDataPath = shardPath.getDataPath();
                false,
        Long currentSize = internalCluster().getInstance(Node.class, primary).fileCache().size();
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
        }
        mockTransportService.addSendBehavior(
            ensureYellow(INDEX_NAME);
            .get();
                -1,
        assertBusy(() -> {
        response = resp.execute().actionGet();
        createIndex(INDEX_NAME, settings);
            waitForDocs(expectedHitCount, indexer);
        final String replicaNode2 = internalCluster().startDataAndWarmNodes(1).get(0);
                    .indices()
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
                INDEX_NAME,
                "_doc",
            .get();
            flush(INDEX_NAME);
        }
            assertTrue(response.getHits().getTotalHits().value() >= 1);
        final Set<String> snapshottedSegments = new HashSet<>(latestSegmentInfos.files(false));
            pendingIndexResponses.add(
        final int deletedDocCount = randomIntBetween(1, initialDocCount);
    private void setup() {
            assertAcked(
            .put(indexSettings())
                        .put("index.refresh_interval", -1)
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);
            final IndexShard secondReplicaShard = getIndexShard(replicaNode_2, INDEX_NAME);
                .get();
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(false).get();
            ensureGreen(INDEX_NAME);
                .put("index.refresh_interval", -1)
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            ReplicationStats replicationStats = clusterStatsResponse.getIndicesStats().getSegments().getReplicationStats();
            BackgroundIndexer indexer = new BackgroundIndexer(
        assertNotNull(replicaShardRouting);
            .setSelectedFields();
                            boolQuery().must(rangeQuery("ts").lt(System.currentTimeMillis() - (15 * 1000))).must(termQuery("type", "bs"))
                assertAllocationIdsInReplicaShardStats(Set.of(second_replica_aid), shardStatsSet);
        );
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
/*
        }
     * This test validates the primary node drop does not result in shard failure on replica.
        final SearchResponse searchResponse = client().prepareSearch()
                    .field("type", "date")
        // non realtime get 1
import org.apache.lucene.document.Document;
            indexer.start(additionalDocCount);
        refresh(INDEX_NAME);
            assertEquals(0L, replicationStats.maxBytesBehind);
    public void testRealtimeTermVectorRequestsUnSuccessful() throws IOException {
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(
            assertEquals(0L, replicationStats.totalBytesBehind);
        });
import java.util.HashSet;
        final Client client = client();
            final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
        client(replica).prepareClearScroll().addScrollId(searchResponse.getScrollId()).get();
            UpdateResponse updateResponse = client(primary).prepareUpdate(INDEX_NAME, id)
        });
        final List<String> dataNodes = internalCluster().startDataAndWarmNodes(6);
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                        boolQuery().should(
            (connection, requestId, action, request, options) -> {
        ensureGreen(INDEX_NAME);
                1,
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            doc.add(new SortedDocValuesField("dv", new BytesRef(TestUtil.randomRealisticUnicodeString(random()))));
        assertBusy(
        assertEquals(1, scrollHits);
        response = resp.execute().actionGet();
            final int additionalDocCount = scaledRandomIntBetween(0, 5);
            assertTrue("indices cache path should " + (exists ? "exist" : "not exist"), Files.exists(indicesCacheDataPath) == exists);
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        if (randomBoolean()) {
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        waitForSearchableDocs(1, primary, replica);
        waitForSearchableDocs(3, primary, replica);
        createIndex(INDEX_NAME);
        final String id = routingKeyForShard(INDEX_NAME, 0);
            Set<String> ids = indexer.getIds();
        }
        final int docCount = scaledRandomIntBetween(0, 10);
            Settings.builder()
                .addAlias(new Alias("alias"))
        ensureGreen(INDEX_NAME);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            "Snapshotted files are no longer part of the latest commit",
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
            flush(INDEX_NAME);
        final String routingOtherShard = routingKeyForShard(INDEX_NAME, 1);
        final String routingOtherShard = routingKeyForShard(INDEX_NAME, 1);
            .setPositions(true)
        XContentBuilder mapping = jsonBuilder().startObject()
        }
        waitForSearchableDocs(initialDocCount, replica, primary);
        // index doc 1
            }
        client.admin()
import org.opensearch.action.support.WriteRequest;
        assertWarmIndexDirectoryExistence(thirdWarmNode, index, false, customDataPath);
            indexer.start(initialDocCount);
        segmentReplicationSourceService.beforeIndexShardClosed(primaryShard.shardId(), primaryShard, indexSettings());
            .setQuery(matchAllQuery())
        verifyStoreContent();
        response = resp.execute().actionGet();
        // create some segments on the replica before copy.
import org.opensearch.index.shard.IndexShard;
        final int docCount = scaledRandomIntBetween(1, 10);
        }
        }
            .execute()
        createIndex(INDEX_NAME, indexSettings);
            ClusterStatsResponse clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
                replicaShard.getLatestReplicationCheckpoint().getSegmentInfosVersion()
            indexer.start(additionalDocCount);
                INDEX_NAME,
        final int replica_count = 6;
        List<String> nodes = new ArrayList<>();
        }
            .setSource("online", false, "bs", "Y", "ts", System.currentTimeMillis() - 100, "type", "s")
                client(),
            )
import org.opensearch.index.shard.ShardPath;
                "_doc",
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replica_count)
        assertEquals(getNodeContainingPrimaryShard().getName(), replica);
        // Index to create another segment
                false,
        ensureGreen(INDEX_NAME);
            // index another doc and refresh - without this the new replica won't catch up.
import org.opensearch.index.SegmentReplicationPerGroupStats;
                                boolQuery().must(rangeQuery("ts").lt(System.currentTimeMillis() - (15 * 1000))).must(termQuery("type", "s"))
        assertBusy(() -> {
        assertFalse(response.isExists());
        blockFileCopy.countDown();
        return randomBoolean() ? INDEX_NAME : "alias";
    /**
                    .endObject()
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));
        logger.info("--> waiting for allocation to have shards assigned");
                    .field("type", "boolean")
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")
        String secondWarmNode = internalTestCluster.startWarmOnlyNodes(1).get(0);
                .addAlias(new Alias("alias"))
    @Override
        try (
    }
        final List<ActionFuture<SearchResponse>> pendingSearchResponse = new ArrayList<>();
        logger.info("--> Collect all scroll query hits");
        if (clusterHealthResponse.isTimedOut()) {
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
import org.opensearch.action.termvectors.TermVectorsResponse;
        ensureYellow(INDEX_NAME);
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        assertNotEquals(replicaAfterFailure.routingEntry().allocationId().getId(), replicaShard.routingEntry().allocationId().getId());
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            waitForDocs(expectedHitCount, indexer);
import java.util.concurrent.TimeUnit;
        refresh(INDEX_NAME);
        assertAcked(
                    add(CodecService.LUCENE_DEFAULT_CODEC);
            .prepareReroute()
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
            assertEquals(
        }
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath))
        // realtime termvectors (with routing set)
            absolutePath = randomRepoPath().toAbsolutePath();
                random()
        assertHitCount(client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), expectedHitCount);
            .stream()
            logger.debug("ShardPath is null for node: {}", nodeName);
            .add(new MultiGetRequest.Item(INDEX_NAME, "1"))
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
    }
        final String id = routingKeyForShard(INDEX_NAME, 0);
            .setSize(100)
                client(),
    public void testScrollWithConcurrentIndexAndSearch() throws Exception {
        SearchResponse response = client().prepareSearch(INDEX_NAME)
        final String id = routingKeyForShard(INDEX_NAME, 0);
        createIndex(
    protected static final String REPOSITORY_NAME = "test-remote-store-repo";
        final String replica = internalCluster().startWarmOnlyNodes(1).get(0);
        FlushRequest request = new FlushRequest(INDEX_NAME);
        MultiGetResponse mgetResponse = client(replica).prepareMultiGet()
            .put(super.indexSettings())
    /**
import static java.util.Arrays.asList;
import org.apache.lucene.document.SortedDocValuesField;
    }
        final Index index = resolveIndex(INDEX_NAME);
            doc.add(
            assertFalse("request shouldn't have forced a refresh", updateResponse.forcedRefresh());
        logger.debug("Checking warm index directory existence for node: {}, expected exists: {}", nodeName, exists);
        assertAcked(
            final int expectedHitCount = initialDocCount + additionalDocCount;
                            .should(
                        .put(indexSettings())
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
            refresh(INDEX_NAME);
        // wait for replication to complete
        client().prepareIndex(INDEX_NAME).setId("2").setSource("foo", "bar").get();
 * this file be licensed under the Apache-2.0 license or a
        }
            refresh(INDEX_NAME);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
    public Settings indexSettings() {
import org.junit.Before;
                client(),
        ) {
        assertFalse(mgetResponse.getResponses()[0].isFailed());
        response = client(replica).prepareGet(indexOrAlias(), "2").setRouting(id).get();
        final ShardRouting replicaShardRouting = getShardRoutingForNodeName(replica);
        AggregateFileCacheStats aggregateStats = replicaFileCache.fileCacheStats();
                .put("index.refresh_interval", -1)
        // stop the primary node - we only have one shard on here.
        AtomicReference<IndexShard> primary = new AtomicReference<>();
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
                .indices()
        request.force(true);
        DiscoveryNode primaryDiscovery = state.nodes().resolveNode(primaryNode);
    /**
                .prepareUpdateSettings(INDEX_NAME)
        try (
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        nodes.add(internalCluster().startDataAndWarmNodes(1).get(0));
                1,
                assertEquals(false, Files.exists(shardDataPath));
            refresh(INDEX_NAME);
        GetResponse response = client().prepareGet(indexOrAlias(), "1").setRealtime(false).get();
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
            "All snapshotted files should be deleted",
     * Tests a scroll query on the replica
        assertBusy(() -> {
        waitForSearchableDocs(initialDocCount, replica, primary);
import org.opensearch.common.Priority;
                -1,
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
                false,
        ensureGreen(INDEX_NAME);
            )
            .setRouting("X")
            .add(new MoveAllocationCommand(INDEX_NAME, 0, primary, thirdWarmNode))
            )
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            )
import org.opensearch.cluster.routing.Preference;
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        }
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
     * the replica will catch up to latest checkpoint once recovery completes without requiring an additional primary refresh/flush.
            )
        assertFalse(response.isExists());
            .setRouting(id)
            assertEquals(replica_entry.getCheckpointsBehindCount(), 0);
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        int initialDocCount = scaledRandomIntBetween(5, 10);
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
        response = client(replica).prepareGet(indexOrAlias(), "1").setPreference(Preference.REPLICA.type()).get();
        final int initialDocCount = scaledRandomIntBetween(1, 10);
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
            () -> assertEquals(
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build());
        ensureGreen(INDEX_NAME);
        final IndexShard indexShard = getIndexShard(primary, INDEX_NAME);
        ) {
        }
import org.opensearch.transport.TransportService;
        waitForSearchableDocs(initialDocCount, primary, replica);
            refresh(INDEX_NAME);
                RandomizedTest.scaledRandomIntBetween(2, 5),
            assertEquals(
            // Index a second set of docs so we can merge into one segment.
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
            .shardsWithState(ShardRoutingState.STARTED)
        createIndex(INDEX_NAME);
        // new primary should have at least the doc count from the first set of segments.
        );
        assertFalse(response.isExists());
        client().prepareIndex(indexOrAlias()).setId("1").setSource("foo", "bar").setRouting(id).get();
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")
        // assert we can index into the new primary.
            .actionGet();
        final Set<String> filesAfterClearScroll = Arrays.stream(replicaShard.store().directory().listAll()).collect(Collectors.toSet());
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        );
        logger.info("--> Close index");
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
        assertThat("doc id: " + 1 + " doesn't exists but should", response.isExists(), equalTo(true));
        // wait until a replica is promoted & finishes engine flip, we don't care which one
                primaryNode
            prepareCreate(INDEX_NAME).setSettings(
        client().admin().indices().prepareOpen(INDEX_NAME).get();
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
}
                Settings.builder().put("index.refresh_interval", -1).put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
        CountDownLatch latch = new CountDownLatch(1);
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
            .setRouting(randomAlphaOfLength(2))
            Settings.builder()
        // Refresh, this should trigger round of segment replication
        resp = client(replica).prepareTermVectors(indexOrAlias(), Integer.toString(1))
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
            .add(new MultiGetRequest.Item(INDEX_NAME, "1"))
            // get shard references.
            }
        try (
        ) {
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", randomInt()).get();
            );
        refresh();
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime termvectors
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
        assertEquals(expectedMaxSeqNo, replicaShard.seqNoStats().getMaxSeqNo());
        }
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
            ).addAlias(new Alias("alias"))
        assertFalse(response.isExists());
            ).addAlias(new Alias("alias"))
 */
        if (!warmIndexSegmentReplicationEnabled()) {
import org.opensearch.cluster.node.DiscoveryNode;
            .setSource("online", true, "bs", "X", "ts", System.currentTimeMillis() - 10000000, "type", "s")
            .get();
    }
    }
        try (IndexWriter writer = new IndexWriter(replicaShard.store().directory(), iwc)) {
        TermVectorsResponse response = client().prepareTermVectors(indexOrAlias(), Integer.toString(1)).setRealtime(false).get();
        assertFalse(response.isExists());
            .setPreference(Preference.REPLICA.type())
        final String id = routingKeyForShard(INDEX_NAME, 0);
                    .endObject()
            assertThat(forceMergeResponse.getFailedShards(), is(0));
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 3);
            waitForSearchableDocs(initialDocCount, replicaNode_2);
            .setOffsets(true)
        );
                -1,
        waitForSearchableDocs(initialDocCount, replica, primary);
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));
        final SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(replicaShard.store().directory());
            assertWarmIndexDirectoryExistence(secondWarmNode, index, false, customDataPath);
        refresh(INDEX_NAME);
            refresh(INDEX_NAME);
            .cluster()
        // opens a scrolled query before a flush is called.
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            assertAllocationIdsInReplicaShardStats(Set.of(second_replica_aid), replicaStats);
        Settings indexSettings = Settings.builder()
            replicaStats = replicaNode_service.nodeStats().getShardStats().get(replicaShard.shardId()).getReplicaStats();
            }
            ensureGreen(INDEX_NAME);
            .endObject()
            final Map<ShardId, SegmentReplicationPerGroupStats> shardStats = pressureService.nodeStats().getShardStats();
                random()
            refresh(INDEX_NAME);
     */
        assertTrue(response.isExists());
            assertFalse(exists);
                assertEquals(0, stats.getCheckpointsBehindCount());
                    fail("File copy should not happen for warm index replica shards");
            });
                    random().nextBoolean() ? Field.Store.YES : Field.Store.NO
        logger.info("--> Opening the index");
    /**
    }
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").get();
                        .put(indexSettings())
            waitForSearchableDocs(initialDocCount + 1, dataNodes);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
            indexer.start(additionalDocCount);
    public void teardown() throws Exception {
            INDEX_NAME,
        client().prepareIndex(INDEX_NAME).setId("3").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        assertThat(mgetResponse.getResponses()[1].getIndex(), is("nonExistingIndex"));
        response = resp.execute().actionGet();
            assertWarmIndexDirectoryExistence(thirdWarmNode, index, false, customDataPath);
                .prepareUpdateSettings(INDEX_NAME)
        primary.get().flush(request);
            client().admin()
            assertSearchHits(client(replica).prepareSearch(INDEX_NAME).setQuery(matchQuery("foo", "baz")).get(), id);
        assertDocCounts(1, primary);
import org.opensearch.test.OpenSearchIntegTestCase;
            .setPayloads(true)
            .setId("1")
        assertHitCount(client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), expectedHitCount + 1);
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
        final String nodeA = internalCluster().startDataAndWarmNodes(1).get(0);
                )
            .add(new MultiGetRequest.Item(INDEX_NAME, "1"))
        int numDocs = 2 + random().nextInt(10);
        assertEquals(getNodeContainingPrimaryShard().getName(), replica);
    public void testStartReplicaAfterPrimaryIndexesDocs() throws Exception {
            .build();
        final String nodeB = internalCluster().startDataAndWarmNodes(1).get(0);
                    .startObject("online")
        primaryTransportService.addSendBehavior(
        final int initialDocCount = scaledRandomIntBetween(1, 5);
            waitForDocs(initialDocCount, indexer);
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", randomInt()).get();
        if (shardPath == null) {
            .setPayloads(true)
        waitForSearchableDocs(docCount, primaryNode, replicaNode);
                random()
        } else {
                    .setSource("field", "value" + i)
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
            // test a checkpoint without any new segments
                "_doc",
        IndexShard replica_2 = getIndexShard(replicaNode2, INDEX_NAME);
        // start a replica node, initially will be empty with no shard assignment.
import org.opensearch.common.action.ActionFuture;
        createIndex(INDEX_NAME);
                .build()
            refresh(INDEX_NAME);
            forceMerge();
            .setPayloads(true)
        assertWarmIndexDirectoryExistence(secondWarmNode, index, true, customDataPath);
            client().admin().indices().prepareGetSettings(INDEX_NAME).get().getIndexToSettings().get(INDEX_NAME)
import org.opensearch.node.Node;
    protected boolean warmIndexSegmentReplicationEnabled() {
            final String second_replica_aid = secondReplicaShard.routingEntry().allocationId().getId();
        // force merge and flush.
            );
                .setId(String.valueOf(i))
            );
                "_doc",
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            client().prepareIndex(INDEX_NAME).setId(docId).setSource("foo", "bar").get();
                replicaNode
        flushAndRefresh(INDEX_NAME);
            Set<SegmentReplicationShardStats> replicaStats = groupStats.getReplicaStats();
                    .setSource("field", "value" + i)
        // start 2nd node so that it contains the replica
                RandomizedTest.scaledRandomIntBetween(2, 5),
        assertThat(mgetResponse.getResponses()[0].getResponse().getSourceAsMap().get("foo").toString(), equalTo("bar"));
        );
            final SearchResponse response = client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get();
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
                assertEquals(1, replicaNode_service.nodeStats().getShardStats().size());
            .execute()
        // block replication
        createIndex(INDEX_NAME);
        MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
            client(primary).prepareDelete(INDEX_NAME, String.valueOf(i)).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        fields = response.getFields();
        ensureGreen(INDEX_NAME);
        );
                    .startObject("ts")
            prepareCreate(INDEX_NAME).setSettings(
import org.opensearch.transport.client.Requests;
                .put(indexSettings())
            waitForDocs(expectedHitCount, indexer);
            prepareCreate(INDEX_NAME).setSettings(
        createIndex(INDEX_NAME, settings);
        client().prepareIndex(INDEX_NAME).setId(String.valueOf(expectedMaxSeqNo + 1)).setSource("another", "doc").get();
import static org.hamcrest.Matchers.equalTo;
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        final String id = routingKeyForShard(INDEX_NAME, 0);
                final Set<SegmentReplicationShardStats> shardStatsSet = replicaNode_service.nodeStats()
        }
        assertEquals(getNodeContainingPrimaryShard().getName(), replica);
            logger.info("former primary aid {}", primaryShard.routingEntry().allocationId());
        assertNoFailures(response);
import org.opensearch.common.settings.Settings;
                RandomizedTest.scaledRandomIntBetween(2, 5),
        assertThat("doc id: " + 1 + " doesn't exists but should", response.isExists(), equalTo(true));
        final String customDataPath = IndexMetadata.INDEX_DATA_PATH_SETTING.get(
        flushAndRefresh(INDEX_NAME);
        });
        assertTrue(mgetResponse.getResponses()[2].isFailed());
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.apache.lucene.tests.util.TestUtil;
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 2);
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        }, 1, TimeUnit.MINUTES);
                -1,
        assertTrue(replicaShardRouting + " should be promoted as a primary", replicaShardRouting.primary());
            .setId(String.valueOf(0))
            flushAndRefresh(INDEX_NAME);
        assertEquals(currentAllocationID, replicaAllocationId);
            .field("analyzer", "tv_test")
                    .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            primaryNode
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
    /**
        // create a doc to index
            .setId("4")
    }
        String thirdWarmNode = internalTestCluster.startWarmOnlyNodes(1).get(0);
        ensureGreen(INDEX_NAME);
        IndexWriterConfig iwc = newIndexWriterConfig().setOpenMode(IndexWriterConfig.OpenMode.APPEND);
            BackgroundIndexer indexer = new BackgroundIndexer(
        MultiGetResponse mgetResponse = client().prepareMultiGet()
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(false).get();
        }, 30, TimeUnit.SECONDS);
            )
    }
            // Fetch pressure stats from the Replica's Node we will assert replica node returns nothing until it is promoted.
        ) {
        if (absolutePath == null) {
            // don't wait for replication to complete, stop the primary immediately.
                .addAlias(new Alias("alias"))
 *
import org.opensearch.action.admin.indices.alias.Alias;
        final ShardId shardId = new ShardId(index, 0);
 * compatible open source license.
    protected Path absolutePath;
            .setSize(10)
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
            flush(INDEX_NAME);
import org.opensearch.action.index.IndexResponse;
        ensureGreen(INDEX_NAME);
            .startObject("field")
        assertThat(mgetResponse.getResponses().length, is(2));
import org.opensearch.action.search.SearchType;
            .endObject()
        // this is for testing scroll segment consistency between refresh and flush
        );
                random()
            .startObject("field")
                logger.debug("Verifying shard paths exist for node: {}", nodeName);
        ensureGreen(INDEX_NAME);
            indexer.start(additionalDocCount);
        // index doc 2 with routing
        FileCacheStats blockFileStats = aggregateStats.getBlockFileCacheStats();
        // realtime get 2 (with routing)
        // index doc 2
     */
                RandomizedTest.scaledRandomIntBetween(2, 5),
        final Path indicesCacheDataPath = node.getNodeEnvironment().fileCacheNodePath().indicesPath.resolve(index.getUUID());
        logger.info("---> restarting replica node");
        response = client(replica).prepareGet(INDEX_NAME, "1").setRouting(routingOtherShard).get();
        // realtime get 1 (with routing set)
        client().prepareIndex(indexOrAlias()).setId("1").setSource("foo", "bar").get();
    public void testDeleteOperations() throws Exception {
        internalTestCluster.startClusterManagerOnlyNode();
            .put(super.nodeSettings(nodeOrdinal))
    @Override
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
        });
        waitForSearchableDocs(4, nodeC, replica);
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
import org.opensearch.cluster.routing.ShardRouting;
        client().prepareIndex(INDEX_NAME)
                SegmentReplicationPressureService.class,
     * This tests that the max seqNo we send to replicas is accurate and that after failover
                INDEX_NAME,
            .field("type", "text")
            );
                client(),
        final int docCount = scaledRandomIntBetween(10, 20);
        ClusterHealthResponse clusterHealthResponse = client.admin()
package org.opensearch.indices.replication;
        assertTrue(currentSize != 0);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
                jsonBuilder().startObject()
import org.opensearch.cluster.metadata.IndexMetadata;
            TransportService.class,
                connection.sendRequest(requestId, action, request, options);
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);
                replicaNode_service.nodeStats().getShardStats().size()
        // expecting failure since we explicitly route request to a shard on which it doesn't exist
        // ToDo: verifyStoreContent() needs to be fixed for warm indices
            waitForSearchableDocs(expectedHitCount, asList(primary, replica));
            .get()
    @Override
    public void testNodeDropWithOngoingReplication() throws Exception {
        // start 1st node so that it contains the primary
        ensureYellow(INDEX_NAME);
        ensureYellow(INDEX_NAME);
            .endObject();
        try (
        if (randomBoolean()) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertTrue(blockFileStats.getTotal() > 0);
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        verifyStoreContent();
    public void testRestartPrimary() throws Exception {
import java.nio.file.Files;
        ensureYellow(INDEX_NAME);
        XContentBuilder mapping = jsonBuilder().startObject()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
                .setFlush(false)
                .get();
            indexer.start(initialDocCount);
    }
                -1,
            .execute()
import org.opensearch.test.BackgroundIndexer;
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
            .put(EngineConfig.INDEX_CODEC_SETTING.getKey(), randomFrom(new ArrayList<>(CODECS) {
        assertThat(mgetResponse.getResponses()[1].getIndex(), is("nonExistingIndex"));
            primaryNode
        }
    }
            waitForSearchableDocs(initialDocCount, primary, replica);
        ensureGreen();
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/18157")
        createIndex(INDEX_NAME);
import org.opensearch.core.xcontent.XContentBuilder;
                    )
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
        final String id = routingKeyForShard(INDEX_NAME, 0);
        assertBusy(() -> {
import org.opensearch.index.ReplicationStats;
        if (currentSize < initialSize) {
                    .setRefreshPolicy(refreshPolicy)
        final int initialDocCount = scaledRandomIntBetween(1, 10);
            searchResponse = client(replica).prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueDays(1)).get();
import java.util.concurrent.atomic.AtomicReference;
        ensureGreen(INDEX_NAME);
            .setQuery(matchAllQuery())
            .index(INDEX_NAME)
        assertEquals(getNodeContainingPrimaryShard().getName(), primary);
            BackgroundIndexer indexer = new BackgroundIndexer(
            assertEquals(
        refresh(INDEX_NAME);
        refresh(INDEX_NAME);
        ensureYellow(INDEX_NAME);
            assertTrue(replicaStats.isEmpty());
        createIndex(INDEX_NAME, settings);
            final int expectedHitCount = initialDocCount + additionalDocCount;
        waitForSearchableDocs(3, primaryNode, replicaNode);
        // index a doc.
    }
            final SegmentReplicationShardStats replica_entry = replicaStats.stream().findFirst().get();
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));
import org.opensearch.action.get.GetResponse;
import java.util.ArrayList;
        internalCluster().restartNode(replica);
        ensureGreen(INDEX_NAME);
            .setPreference("_only_local")
                    .getReplicaStats();
        ensureGreen(INDEX_NAME);
                        .put("index.refresh_interval", -1)
    protected Settings nodeSettings(int nodeOrdinal) {
        refresh(INDEX_NAME);
                }
    }
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        assertEquals(getNodeContainingPrimaryShard().getName(), primary);
                client().prepareIndex(INDEX_NAME)
                new TextField(
            )
                "_doc",
            .setSelectedFields();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    public void testRestartPrimary_NoReplicas() throws Exception {
        client().prepareIndex(indexOrAlias()).setId("2").setSource("foo2", "bar2").setRouting(id).get();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                Settings.builder().put("index.refresh_interval", -1).put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            .setRouting(randomAlphaOfLength(2))
            .setIndices(INDEX_NAME)
            .field("type", "text")
        assertTrue(mgetResponse.getResponses()[1].isFailed());
                    .setId(Integer.toString(i))
        nodes.add(replicaNode);
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
            assertSearchHits(client(primary).prepareSearch(INDEX_NAME).setQuery(matchQuery("foo", "baz")).get(), id);
    public void testReplicationAfterForceMergeOnPrimaryShardsOnly() throws Exception {
        assertFalse(response.isExists());
            .prepareReroute()
        ensureGreen(INDEX_NAME);
    public void testRealtimeMultiGetRequestsUnsuccessful() {
import org.apache.lucene.document.StringField;
            if (!warmIndexSegmentReplicationEnabled()) {
        assertAcked(
        // deleted.
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);
import java.util.stream.Collectors;
        for (int i = 1; i < 5; i++) {
                INDEX_NAME,
        verifyStoreContent();
            indexer.start(initialDocCount);
            .setPreference(Preference.REPLICA.type())
            internalCluster().getInstance(TransportService.class, replicaNode),
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        }
        // index a doc.
                    .execute()
        // check replica is promoted to primary.
    public void testReplicaAlreadyAtCheckpoint() throws Exception {
        int expectedMaxSeqNo = initialDocCount + deletedDocCount + additionalDocs - 1;
        final Settings settings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build();
        final String nodeB = internalCluster().startDataAndWarmNodes(1).get(0);
        assertFalse(mgetResponse.getResponses()[0].getResponse().isExists());
    }
        assertAcked(
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        createIndex(INDEX_NAME);
                RandomizedTest.scaledRandomIntBetween(2, 5),
            waitForDocs(initialDocCount, indexer);
        logger.info("Relocating shard from {} to {}", primary, thirdWarmNode);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
 * SPDX-License-Identifier: Apache-2.0
            )
                .indices()
                {
            .get();
            final int additionalDocCount = scaledRandomIntBetween(0, 2);
            Set<String> ids = indexer.getIds();
import java.util.Map;
import org.opensearch.core.common.unit.ByteSizeUnit;
            docs.add(doc);
                    .endObject()
                "We should have stats returned for the replication group",
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        client().prepareIndex(INDEX_NAME)
        final String routingOtherShard = routingKeyForShard(INDEX_NAME, 1);
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2))
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
                client().admin()
            .get();
        final long expectedHitCount = initialDocCount + additionalDocs - deletedDocCount;
            .actionGet();
        String primary = internalTestCluster.startWarmOnlyNodes(1).get(0);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            final ForceMergeResponse forceMergeResponse = client().admin()
        // create new on-disk segments and copy them out.
            ensureGreen(INDEX_NAME);
                }
        );
import org.opensearch.index.store.remote.filecache.FileCacheStats;
import org.opensearch.core.index.Index;
        assertAcked(
        // index doc 1
        // non realtime termvectors 1
        final int initialDocCount = scaledRandomIntBetween(0, 10);
                }
            );
        }
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
                INDEX_NAME,
        client().prepareIndex(indexOrAlias()).setId("1").setSource("foo", "bar").setRouting(id).get();
                assertTrue(Files.exists(shardDataPath));
        final String currentAllocationID = state.routingTable()
            assertBusy(() -> {
        assertWarmIndexDirectoryExistence(secondWarmNode, index, true, customDataPath);
        }
        assertFalse(response.isExists());
            flush(INDEX_NAME);
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
            .setRequestCache(false)
        createIndex(INDEX_NAME);
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
        do {
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
            )
        assertTrue(initialSize != 0);
        ensureGreen(INDEX_NAME);
            String id = ids.toArray()[0].toString();
                false,
                client().prepareIndex(INDEX_NAME)
    private static String indexOrAlias() {
            assertFalse(ids.isEmpty());
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
import org.opensearch.test.InternalTestCluster;
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
            client(nodeA).prepareDelete(INDEX_NAME, id).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
                writer.addDocument(d);
     */
                INDEX_NAME,
    }
        ensureGreen(INDEX_NAME);
                assertTrue(Files.exists(shardStatePath));
        });
        for (int i = 0; i < docCount; i++) {
                "_doc",
            flush(INDEX_NAME);
        assertTrue(response.isExists());
                .setDoc(Requests.INDEX_CONTENT_TYPE, "foo", "baz")
        ensureGreen(INDEX_NAME);
        assertWarmIndexDirectoryExistence(primary, index, true, customDataPath);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        // realtime get 1
            .get();
        response = client(replica).prepareGet(indexOrAlias(), "1").get();
            TransportService.class,
        TermVectorsResponse response = client(replica).prepareTermVectors(indexOrAlias(), "1").get();
        assertWarmIndexDirectoryExistence(primary, index, false, customDataPath);
            .build();
            flushAndRefresh(INDEX_NAME);
     * @throws Exception when issue is encountered
            prepareCreate(INDEX_NAME).setMapping(mapping)
            assertAllocationIdsInReplicaShardStats(Set.of(replicaShard.routingEntry().allocationId().getId()), replicaStats);
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
            primaryNode
        if (randomBoolean()) {
        final String primary = internalCluster().startWarmOnlyNodes(1).get(0);
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
    }
        FileCache fileCache = internalCluster().getInstance(Node.class, primary).fileCache();
        ));
        refresh(INDEX_NAME);
import org.opensearch.core.index.shard.ShardId;
    }
     * @throws Exception when issue is encountered
            .execute()
        refresh(INDEX_NAME);
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
import java.util.Collections;
    public void testReplicaHasDiffFilesThanPrimary() throws Exception {
            assertEquals(
            BackgroundIndexer indexer = new BackgroundIndexer(
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        // index another doc but don't refresh, we will ensure this is searchable once replica is promoted.
            }
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
            .setId("2")
     * the new primary starts indexing from the correct maxSeqNo and replays the correct count of docs
                .setSettings(
            .filter(routing -> routing.primary() == false)
            .setOffsets(true)
            .allocationId()
        );
            writer.commit();
            );
                Settings.builder().put("index.refresh_interval", -1).put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            refresh(INDEX_NAME);
            );
            assertAllSuccessful(searchResponse);
import org.apache.lucene.document.TextField;
import org.opensearch.search.sort.SortOrder;
import org.apache.lucene.index.SegmentInfos;
        return true;
                RandomizedTest.scaledRandomIntBetween(2, 5),
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
        ensureYellow(INDEX_NAME);
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);
        // Force a merge here so that the in memory SegmentInfos does not reference old segments on disk.
            ensureYellow(INDEX_NAME);
        internalCluster().restartNode(primary);
        // non realtime termvectors 1
        assertBusy(() -> {
        final Settings settings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build();
        ensureGreen(INDEX_NAME);
        Long initialSize = internalCluster().getInstance(Node.class, primary).fileCache().size();
        client().prepareClearScroll().addScrollId(searchResponse.getScrollId()).get();
        final IndexShard primaryShard = getIndexShard(primary, INDEX_NAME);
    /**
            verifyStoreContent();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime termvectors
            .field("term_vector", "with_positions_offsets_payloads")
        assertBusy(() -> {
        createIndex(INDEX_NAME, settings);
            replicaStats = replicaNode_service.nodeStats().getShardStats().get(primaryShard.shardId()).getReplicaStats();
        assertThat(response.getSourceAsMap().get("foo2").toString(), equalTo("bar2"));
            .get();
            );
            assertTrue(replicaNode_service.nodeStats().getShardStats().isEmpty());
import org.apache.lucene.document.Field;
    public void testUpdateOperations() throws Exception {
        // realtime get 1 (preference = _replica)
            );
import org.apache.lucene.util.BytesRef;
        );
            verifyStoreContent();
    }
        // there should be no active readers, snapshots, or on-disk commits containing the snapshotted files, check that they have been
                    .execute()
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
                        )
        client().prepareIndex(INDEX_NAME).setId("2").setSource("foo", "bar").get();
            .index(INDEX_NAME)
            waitForDocs(initialDocCount, indexer);
        }
        final String nodeA = internalCluster().startDataAndWarmNodes(1).get(0);
    @After
        waitForRelocation(ClusterHealthStatus.GREEN);
        }
        }
            .setScroll(TimeValue.timeValueDays(1))
        // randomly flush here after the force merge to wipe any old segments.
            .setSelectedFields();
        ensureYellow(INDEX_NAME);
            // Perform force merge only on the primary shards.
    public void testReplicationAfterPrimaryRefreshAndFlush() throws Exception {
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        final String primary = internalCluster().startWarmOnlyNodes(1).get(0);
        waitForSearchableDocs(INDEX_NAME, 2 * searchCount, List.of(primary, replica));
        ensureGreen(INDEX_NAME);
            if (exists) {
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
        FileCache replicaFileCache = internalCluster().getInstance(Node.class, replica).fileCache();
import org.opensearch.action.update.UpdateResponse;
     */
        ensureYellow(INDEX_NAME);
                assertEquals(false, Files.exists(shardStatePath));
            waitForSearchableDocs(initialDocCount, asList(primary, replica));
import static org.opensearch.index.query.QueryBuilders.matchQuery;
                "We should have stats returned for the replication group",
            .field("term_vector", "with_positions_offsets_payloads")
        waitForSearchableDocs(initialDocCount, replica, primary);
            flush(INDEX_NAME);
            final int additionalDocCount = scaledRandomIntBetween(0, 10);
            refresh(INDEX_NAME);
        assertWarmIndexDirectoryExistence(thirdWarmNode, index, true, customDataPath);
        final String nodeA = internalCluster().startDataAndWarmNodes(1).get(0);
                -1,
            )
                    "body",
        try (
            Collections.emptySet(),
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
            // drop the primary, this won't hand off pressure stats between old/new primary.
            SegmentReplicationPressureService replicaNode_service = internalCluster().getInstance(
                random()
        verifyStoreContent();
                )
                SegmentReplicationPressureService.class,
    protected Settings featureFlagSettings() {
        int initialDocCount = scaledRandomIntBetween(10, 20);
        assertFalse(mgetResponse.getResponses()[0].getResponse().isExists());
    }
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        client().prepareIndex(INDEX_NAME).setId("2").setSource("foo2", "bar2").setRouting(id).get();
            .setId(Integer.toString(2))
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
        ensureGreen(INDEX_NAME);
                client(),
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
            .setRealtime(true)
                INDEX_NAME,
    private void assertAllocationIdsInReplicaShardStats(Set<String> expected, Set<SegmentReplicationShardStats> replicaStats) {
            .cluster()
        // index doc 1
        }
        return featureSettings.build();
    public void testShardPathDeletionWhenWarmIndexRelocate() throws Exception {
     */
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
        client().prepareIndex(INDEX_NAME).setId("2").setSource("bar", "baz").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
public class WarmIndexSegmentReplicationIT extends SegmentReplicationBaseIT {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
            ensureGreen(INDEX_NAME);
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 3);
            .stream()
            .get()
    }
        List<Document> docs = new ArrayList<>();
                false,
        ensureGreen(INDEX_NAME);
                    .endObject()
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").get();
        }
    }
    @Override
            )
                    .startObject("bs")
            final IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
        createIndex(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        // replica now promoted as primary should have same allocation id
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));
        }
            refresh(INDEX_NAME);
            .getId();
        SearchResponse searchResponse = client(replica).prepareSearch()
            .setVersion(true)
        assertBusy(() -> {
        // realtime termvectors 2 with routing
        // Test stats
            .setRequestCache(false)
    /**
import org.opensearch.cluster.health.ClusterHealthStatus;
        ensureGreen(INDEX_NAME);
            ensureYellowAndNoInitializingShards(INDEX_NAME);
import java.io.IOException;
            .setRouting(id)
        }
            .setFrom(0)
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
            flush(INDEX_NAME);
        );
        refresh(INDEX_NAME);
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
        assertFalse(response.isExists());
                    TestUtil.randomRealisticUnicodeString(random()),
                .prepareForceMerge(INDEX_NAME)
            client().admin().indices().prepareRefresh().execute().actionGet();
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
import java.util.concurrent.CountDownLatch;
                false,
        client().prepareIndex(INDEX_NAME)
import org.opensearch.common.util.set.Sets;
        ensureGreen(INDEX_NAME);
            assertTrue(pendingSearchResponse.stream().allMatch(ActionFuture::isDone));
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
            verifyStoreContent();
        GetResponse response = client(replica).prepareGet(indexOrAlias(), "1").get();
        return Settings.builder()
        // index doc 2
            verifyStoreContent();
            .setSource(jsonBuilder().startObject().field("field", "the quick brown fox jumps over the lazy dog").endObject())
    }
            .setId("3")
    }
    protected boolean addMockIndexStorePlugin() {
    public void testCancelPrimaryAllocation() throws Exception {
                .indices()
            .setRouting("Y")
            final int expectedHitCount = initialDocCount + additionalDocCount;
        assertFalse(response.isExists());
import java.util.List;
        ) {
            ).addAlias(new Alias("alias"))
            String docId = String.valueOf(initialDocCount + 1);
        ensureGreen(INDEX_NAME);
                replica_1.getLatestReplicationCheckpoint().getSegmentInfosVersion(),
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
            waitForDocs(expectedHitCount, indexer);
            .add(new CancelAllocationCommand(INDEX_NAME, indexShard.shardId().id(), primary, true))
            .setExplain(true)
            // Refresh, this should trigger round of segment replication
        // realtime multi get 1 (preference = _replica)
        internalCluster().restartNode(primary);
        client().prepareIndex(INDEX_NAME)
        }
                RandomizedTest.scaledRandomIntBetween(2, 5),
                            )
        // multi get non realtime 1
            // start another replica.
import org.opensearch.index.IndexModule;
                    .field("type", "keyword")
import org.opensearch.cluster.ClusterState;
        waitForSearchableDocs(4, primaryNode, replicaNode);
                    .field("required", true)
            if (!warmIndexSegmentReplicationEnabled()) {
        nodes.add(primaryNode);
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
        waitForSearchableDocs(initialDocCount, primary, replica);
            SegmentReplicationSourceService.class,
                    .setRefreshPolicy(refreshPolicy)
            String replicaNode_2 = internalCluster().startDataAndWarmNodes(1).get(0);
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;
                INDEX_NAME,
        final int additionalDocCount = scaledRandomIntBetween(0, 10);
            client().prepareIndex(INDEX_NAME).setId("2").setSource("foo2", randomInt()).get();
            .prepareHealth()
    }
        createIndex(INDEX_NAME);
                boolQuery().must(termQuery("online", true))
                verifyStoreContent();
            .setSource(jsonBuilder().startObject().field("field", "the quick brown fox jumps over the lazy dog").endObject())
        assertHitCount(client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 3);
                // we want to control refreshes
        final int initialDocCount = scaledRandomIntBetween(0, 10);
        if (!warmIndexSegmentReplicationEnabled()) {
        performReplicationAfterForceMerge(false, SHARD_COUNT * (1 + REPLICA_COUNT));
        assertAcked(
        final Path cacheDataPath = node.getNodeEnvironment().fileCacheNodePath().fileCachePath.resolve(index.getUUID());
                -1,
        ensureGreen(INDEX_NAME);
                random()
        }
                "_doc",
            waitForDocs(initialDocCount, indexer);
    }
        );
        logger.info("Segments {}", snapshottedSegments);
            )
        refresh(INDEX_NAME);
        final String nodeB = internalCluster().startDataAndWarmNodes(1).get(0);
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        for (int i = 0; i < numDocs; i++) {
        final ShardRouting replicaShardRouting = getShardRoutingForNodeName(replica);
        mgetResponse = client(replica).prepareMultiGet()
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        try (
            .filter(routing -> routing.primary())
        final IndexShard replicaShard = getIndexShard(replica, INDEX_NAME);
            .setPositions(true)
        response = client().prepareGet(indexOrAlias(), "1").setRealtime(false).get();
import org.opensearch.action.admin.indices.flush.FlushRequest;
import java.nio.file.Path;
                random()
        // non realtime get 1
        for (int i = searchCount; i < searchCount * 2; i++) {
            .setQuery(
        final Settings settings = Settings.builder()
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
        TermVectorsRequestBuilder resp = client(replica).prepareTermVectors(indexOrAlias(), Integer.toString(1))
            flush(INDEX_NAME);
            prepareCreate(INDEX_NAME).setSettings(Settings.builder().put("index.refresh_interval", -1).put(indexSettings()))
        logger.info("---> restarting primary node");
                client(),
        final String nodeB = internalCluster().startDataAndWarmNodes(1).get(0);
    }
        assertAcked(
        refresh(INDEX_NAME);
            .setOffsets(true)
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
            verifyStoreContent();
            primary.set(replica_1.routingEntry().primary() ? replica_1 : replica_2);
import org.opensearch.index.SegmentReplicationShardStats;
                    Settings.builder()
import org.opensearch.test.junit.annotations.TestLogging;
        nodes.add(replicaNode);
import com.carrotsearch.randomizedtesting.RandomizedTest;
        refresh(INDEX_NAME);
            .endObject()
            .setTimeout(new TimeValue(5, TimeUnit.MINUTES))
                    fail("File copy should not happen for warm index replica shards");
        ).get();
        SegmentInfos latestSegmentInfos = getLatestSegmentInfos(replicaShard);
        }, 1, TimeUnit.MINUTES);
            String id = ids.toArray()[0].toString();
            Sets.intersection(latestCommitSegments, snapshottedSegments)
import static org.hamcrest.Matchers.is;
        createIndex(INDEX_NAME);
            .endObject();
import org.opensearch.core.common.unit.ByteSizeValue;
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
        return Settings.builder().put(super.indexSettings()).put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true).build();
        ensureYellow(INDEX_NAME);
import java.util.Arrays;
        client().prepareIndex(INDEX_NAME)
            .addSort("field", SortOrder.ASC)
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        assertBusy(
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .setSelectedFields();
                random()
            .execute()
        try (
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        // index doc 1
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import org.opensearch.test.transport.MockTransportService;
        long scrollHits = 0;
        assertEquals(expected, replicaStats.stream().map(SegmentReplicationShardStats::getAllocationId).collect(Collectors.toSet()));
import org.junit.After;
        // this test cancels allocation on the primary - promoting the new replica and recreating the former primary as a replica.
            .endObject()
        ));
        flush(INDEX_NAME);
            doc.add(new StringField("id", "" + i, random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        // index another doc.
            .get();
        );
        assertDocCounts(docCount, primaryNode);
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 2);
        internalCluster().restartNode(primary);
            () -> assertEquals(
            refresh(INDEX_NAME);
        }
        // Index a doc to create the first set of segments. _s1.si
/**
            assertThat(forceMergeResponse.getSuccessfulShards(), is(expectedSuccessfulShards));
        // multi get realtime 1
                .put(indexSettings())
        // index more docs and force merge down to 1 segment
            (connection, requestId, action, request, options) -> {
                    .get(replicaShard.shardId())
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();
     * from xlog.
import org.opensearch.action.get.MultiGetRequest;
    /**
            .actionGet();
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
    }
        } else {
                    .field("ignore_malformed", false)
        final IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
    }
        response = client().prepareTermVectors(indexOrAlias(), Integer.toString(1)).setRealtime(false).get();
     * Tests whether segment replication supports realtime get requests and reads and parses source from the translog to serve strong reads.
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);
            .get();
        // index doc 1
    }
        assertBusy(() -> {
        // start a replica node, initially will be empty with no shard assignment.
        ensureYellow(INDEX_NAME);
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
                    .startObject("_routing")
                verifyStoreContent();
        createIndex(INDEX_NAME);
        final IndexShard replicaShard = getIndexShard(replica, INDEX_NAME);
            refresh(INDEX_NAME);
        } while (searchResponse.getHits().getHits().length > 0);
            .setRouting(id)
        final IndexShard replicaAfterFailure = getIndexShard(replicaNode, INDEX_NAME);
                client(),
        client().prepareIndex(INDEX_NAME).setId("3").setSource("foo", "bar").get();
            fail("FileCache did not initialise correctly");
        CountDownLatch blockFileCopy = new CountDownLatch(1);
        assertBusy(() -> {
        final Path shardStatePath = shardPath.getShardStatePath();
        final SegmentReplicationSourceService segmentReplicationSourceService = internalCluster().getInstance(
            .build();
                replicaNode_service.nodeStats().getShardStats().size()
            BackgroundIndexer indexer = new BackgroundIndexer(
        try (final Releasable ignored = blockReplication(List.of(replicaNode), latch)) {
        try (
    private void assertWarmIndexDirectoryExistence(String nodeName, Index index, boolean exists, String customDataPath) throws Exception {
    public void testScrollCreatedOnReplica() throws Exception {
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
            );
    public void testClosedIndices() {
        final int initialDocCount = 1;
 * This class runs Segment Replication Integ test suite with partial locality indices (warm indices).
            refresh(INDEX_NAME);
                replica_2.getLatestReplicationCheckpoint().getSegmentInfosVersion()
        final int expectedHitCount = initialDocCount + additionalDocCount;
            // after the primary is dropped and replica is promoted we won't have a replica assigned yet, so stats per replica should return
            .setId(Integer.toString(1))
        Set<String> latestCommitSegments = new HashSet<>(replicaShard.store().readLastCommittedSegmentsInfo().files(false));
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
            .setSource(jsonBuilder().startObject().field("field", 0).endObject())
import java.util.Set;
                "_doc",
            logger.warn("Cluster health check timed out after relocation");
            .setRealtime(false)
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime get
 * The OpenSearch Contributors require contributions made to
    }
        assertAcked(client().admin().indices().prepareClose(INDEX_NAME));
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
        resp = client().prepareTermVectors(indexOrAlias(), Integer.toString(2))
        createIndex(INDEX_NAME);
    public void testRealtimeTermVectorRequestsSuccessful() throws IOException {
            .setSource(jsonBuilder().startObject().field("field", "the quick brown fox jumps over the lazy dog").endObject())
            indexer.start(initialDocCount);
    public void testDropPrimaryDuringReplication() throws Exception {
        ensureGreen(INDEX_NAME);
        if (randomBoolean()) {
        mgetResponse = client(replica).prepareMultiGet()
        assertEquals(
            // fetch pressure stats from the Primary's Node.
import org.opensearch.action.search.SearchResponse;
        client().prepareIndex(INDEX_NAME)
        );
            .cluster()
    private void performReplicationAfterForceMerge(boolean primaryOnly, int expectedSuccessfulShards) throws Exception {
        Fields fields = response.getFields();
        client().prepareIndex(INDEX_NAME).setId("3").setSource("bar", "baz").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            logger.info("Checking cache paths for node: {}", nodeName);
        TermVectorsRequestBuilder resp = client().prepareTermVectors(indexOrAlias(), Integer.toString(1))
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
        ensureGreen(INDEX_NAME);
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/18157")
        ) {
            ensureGreen(INDEX_NAME);
        // index doc 1
                "_doc",
        assertThat(mgetResponse.getResponses().length, is(2));
        final String replicaAllocationId = state.routingTable()
            assertTrue("replica should be promoted as a primary", replicaShard.routingEntry().primary());
            .setScroll(TimeValue.timeValueDays(1))
        final int initialDocCount = scaledRandomIntBetween(1, 5);
        refresh(INDEX_NAME);
            pendingIndexResponses.add(
    public void testRealtimeMultiGetRequestsSuccessful() {
        final List<String> nodes = new ArrayList<>();
    }
    public void testIndexWhileRecoveringReplica() throws Exception {
            .setPayloads(true)
                false,
            verifyStoreContent();
                        .put(indexSettings())
        ensureGreen(INDEX_NAME);
        );
            .setSize(10)
     */
            .get();
        Settings.Builder featureSettings = Settings.builder();
        final int searchCount = randomIntBetween(1, 2);
        return false;
            Sets.intersection(filesAfterClearScroll, snapshottedSegments)
        for (int i = 0; i < deletedDocCount; i++) {
            scrollHits += searchResponse.getHits().getHits().length;
            indexer.start(docCount);
        replicaShard.finalizeReplication(segmentInfos);
                .setPrimaryOnly(primaryOnly)
                .get();
            .field("analyzer", "tv_test")
            indexer.start(additionalDocCount);
        createIndex(INDEX_NAME, super.indexSettings());
            .get();
        nodes.add(internalCluster().startDataAndWarmNodes(1).get(0));
        }
            return;
        final WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/18157")
     * Tests whether segment replication supports realtime termvector requests and reads and parses source from the translog to serve strong reads.
        assertDocCounts(2, secondWarmNode, thirdWarmNode);
            for (Document d : docs) {
     * This test verifies that segment replication does not fail for closed indices
            indexer.start(initialDocCount);
        verifyStoreContent();
    public void testPressureServiceStats() throws Exception {
            .setWaitForEvents(Priority.LANGUID)
            BackgroundIndexer indexer = new BackgroundIndexer(
                    .endObject()
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
            waitForSearchableDocs(initialDocCount, dataNodes);
        final ShardPath shardPath = ShardPath.loadShardPath(logger, node.getNodeEnvironment(), shardId, customDataPath);
            indexer.start(initialDocCount);
        ensureYellow(INDEX_NAME);
        createIndex(INDEX_NAME);
        final int initialDocCount = scaledRandomIntBetween(1, 10);
        IndexShard replica_1 = getIndexShard(replicaNode, INDEX_NAME);
import org.opensearch.transport.client.Client;
    }
            } else {
            client().prepareIndex(INDEX_NAME).setId(String.valueOf(i)).setSource("foo", "bar").get();
            }
            waitForDocs(initialDocCount, indexer);
            waitForDocs(docCount, indexer);
            .setPositions(true)
            prepareCreate(INDEX_NAME).setMapping(mapping)
        latch.countDown();
            final int expectedHitCount = initialDocCount + additionalDocCount;
            }))
            client().prepareIndex(INDEX_NAME)
    }
    }
                primaryShard.getLatestReplicationCheckpoint().getSegmentInfosVersion(),
                )
        client().prepareIndex(INDEX_NAME).setId("4").setSource("baz", "baz").get();
        ) {
            .setSource("online", true, "ts", System.currentTimeMillis() - 123123, "type", "bs")
    public void testMultipleShards() throws Exception {
            dataNodes.add(internalCluster().startDataAndWarmNodes(1).get(0));
            writer.flush();
            SegmentReplicationPressureService pressureService = internalCluster().getInstance(
            waitForDocs(expectedHitCount, indexer);
        // Drop the primary and wait until replica is promoted.
    @Before
            .setIndices(INDEX_NAME)
        assertNotNull(replicaShardRouting);
            flushAndRefresh(INDEX_NAME);
     */
        CountDownLatch latch = new CountDownLatch(1);
                connection.sendRequest(requestId, action, request, options);
import org.opensearch.cluster.routing.ShardRoutingState;
    }
        assertFalse(mgetResponse.getResponses()[0].getResponse().isExists());
        for (int i = 0; i < docCount; i++) {
        assertEquals(getNodeContainingPrimaryShard().getName(), primary);
        ensureGreen(INDEX_NAME);
            .getId();
            }
        waitForSearchableDocs(2, nodes);
                false,
 */
        client().admin().indices().prepareClose(INDEX_NAME).get();
        ensureYellow(INDEX_NAME);
            .startObject("properties")
        final int initialDocCount = 1;
            // start another replica.
            .shardsWithState(ShardRoutingState.STARTED)
        final int additionalDocs = randomIntBetween(1, 5);
            indexer.start(initialDocCount);
        ) {
import org.opensearch.common.lease.Releasable;
        // create the cluster with one primary node containing primary shard and replica node containing replica shard
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/17526")
import org.opensearch.index.codec.CodecService;
                    .getShardStats()
            final int additionalDocCount = scaledRandomIntBetween(0, 10);
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            .setOffsets(true)
            logger.info("Replica aid {}", replicaShard.routingEntry().allocationId());
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        // realtime termvectors 1
import org.opensearch.indices.replication.common.ReplicationType;
        assertFalse(mgetResponse.getResponses()[0].isFailed());
        ensureGreen(INDEX_NAME);
            BackgroundIndexer indexer = new BackgroundIndexer(
            assertEquals(2, updateResponse.getVersion());
            // index another doc while blocked, this would not get replicated to replica.
        waitForSearchableDocs(1, primaryNode, replicaNode, replicaNode2);
        );
        internalCluster().startClusterManagerOnlyNode();
        String nodeC = internalCluster().startDataAndWarmNodes(1).get(0);
        for (int i = 0; i < searchCount; i++) {
        client().admin()
    public void testRealtimeGetRequestsSuccessful() {
                client(),
import org.opensearch.index.SegmentReplicationPressureService;
        }
import org.opensearch.common.unit.TimeValue;
        // Get replica allocation id
        assertFalse(mgetResponse.getResponses()[1].isFailed());
        waitForSearchableDocs(2, primary, replica);
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
            SegmentReplicationPerGroupStats groupStats = shardStats.get(primaryShard.shardId());
    public void testRestartPrimaryAndReplicaWithDocuments() throws Exception {
                logger.debug("Verifying shard paths do not exist for node: {}", nodeName);
            // empty.
        ) {
                .setMaxNumSegments(1)
            waitForSearchableDocs(expectedHitCount - 1, nodeA, nodeB);
    public void testIndexReopenClose() throws Exception {
        assertFalse(response.isExists());
    }
            .allocationId()
        client().prepareIndex(INDEX_NAME).setId("2").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
import org.apache.lucene.index.IndexWriter;
        final List<String> nodes = new ArrayList<>();
