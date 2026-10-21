import java.util.concurrent.atomic.AtomicReference;
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
    }
        final String replica = internalCluster().startDataOnlyNode();
        assertBusy(() -> {
            assertEquals(
import org.opensearch.core.index.shard.ShardId;
        // generate _2.si
            .build();
            waitForDocs(initialDocCount, indexer);
            BackgroundIndexer indexer = new BackgroundIndexer(
        GatedCloseable<IndexCommit> primaryIndexCommit = primaryShard.acquireLastIndexCommit(false);
        assertDocCounts(1, primary);
        MockTransportService primaryTransportService = (MockTransportService) internalCluster().getInstance(
    public void testRetryPublishCheckPoint() throws Exception {
            )
        }
            .setId("2")
        waitForSearchableDocs(1, primary, replica);
                -1,
        // create a doc to index
            .setSource("foo2", "bar2")
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
                && replicaFilesBeforeMerge.stream().anyMatch(s -> s.startsWith("_1"))
            waitForDocs(initialDocCount, indexer);
        }
                                boolQuery().must(rangeQuery("ts").lt(System.currentTimeMillis() - (15 * 1000))).must(termQuery("type", "s"))
        primaryShard.flush(new FlushRequest(INDEX_NAME));
import java.util.Arrays;
                .get();
            .setSelectedFields();
        NamedWriteableRegistry registry = internalCluster().getInstance(NamedWriteableRegistry.class, replica);
import org.opensearch.common.lease.Releasable;
            .addSort("foo", SortOrder.ASC)
                1,
import static org.opensearch.index.query.QueryBuilders.matchQuery;
import org.opensearch.action.search.CreatePitRequest;
            "Skipping the test as its not compatible with segment replication with remote store.",
        // start a replica node, initially will be empty with no shard assignment.
            BackgroundIndexer indexer = new BackgroundIndexer(
        ensureGreen(INDEX_NAME);
        assertEquals(getNodeContainingPrimaryShard().getName(), primary);
    /**
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
    }
        ensureGreen(INDEX_NAME);
            final int expectedHitCount = initialDocCount + additionalDocCount;
            replicaNode
                List.of(replicaShard.store().directory().listAll()).containsAll(snapshottedSegments)
        // Force a merge here so that the in memory SegmentInfos does not reference old segments on disk.
        prepareCreate(
        CreatePitResponse pitResponse = execute.get();
        final Settings settings = Settings.builder()
        }
        );
            .build();
        final String primaryNode = internalCluster().startDataOnlyNode();
            .add(new MultiGetRequest.Item(INDEX_NAME, "2").routing(id))
        final SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(replicaShard.store().directory());
        assertEquals(1, openContexts);
        final IndexShard replicaShard = getIndexShard(replica, INDEX_NAME);
import org.opensearch.transport.RemoteTransportException;
            client().prepareIndex(INDEX_NAME)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .setSource(jsonBuilder().startObject().field("field", "the quick brown fox jumps over the lazy dog").endObject())
import org.opensearch.action.support.WriteRequest;
    public void testPressureServiceStats() throws Exception {
            "All snapshotted files should be deleted",
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
import org.opensearch.common.concurrent.GatedCloseable;
        // index doc 1
            indexer.start(initialDocCount);
        assertEquals(1, scrollHits);
        final IndexShard replicaAfterFailure = getIndexShard(replicaNode, INDEX_NAME);
        refresh(INDEX_NAME);
            // Perform force merge only on the primary shards.
    /**
        // Index a doc to create the first set of segments. _s1.si
            assertEquals(
                    .endObject()
}
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            );
import org.opensearch.search.internal.PitReaderContext;
                    .field("format", "epoch_millis")
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
            flush(INDEX_NAME);
import com.carrotsearch.randomizedtesting.RandomizedTest;
                    handler.messageReceived(request, channel, task);
                .setId(String.valueOf(i))
            final SegmentInfos infos = standardDirectoryReader.getSegmentInfos();
            }
import org.opensearch.common.unit.TimeValue;
            // drop the primary, this won't hand off pressure stats between old/new primary.
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
        int initialDocCount = scaledRandomIntBetween(5, 10);
            assertEquals(
                replicaNode_service.nodeStats().getShardStats().size()
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
                false,
            TransportService.class,
     * Tests whether segment replication supports realtime termvector requests and reads and parses source from the translog to serve strong reads.
    public void testScrollCreatedOnReplica() throws Exception {
                    .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        long pitCurrent = indicesStatsResponse.getIndex(INDEX_NAME).getTotal().search.getTotal().getPitCurrent();
        }
        final String primary = internalCluster().startDataOnlyNode();
        final String nodeB = internalCluster().startDataOnlyNode();
    }
        ensureGreen(INDEX_NAME);
            .setSize(100)
        try (
                "_doc",
        // Reproduce the case where the replica shard cannot synchronize data from the primary shard when there is a network exception.
        ensureYellow(INDEX_NAME);
            .setPayloads(true)
                random()
        assertThat(mgetResponse.getResponses().length, is(2));
        client().prepareIndex(INDEX_NAME)
            .actionGet();
        }
        }
    }
import org.apache.lucene.index.Fields;
            // don't wait for replication to complete, stop the primary immediately.
            .setRealtime(false)
                .setDoc(Requests.INDEX_CONTENT_TYPE, "foo", "baz")
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
                -1,
        refresh(INDEX_NAME);
                throw new RuntimeException(e);
            client().admin()
                    }
        // index a doc.
        Collection<String> snapshottedSegments;
            .setRequestCache(false)
        final String replicaNode = internalCluster().startDataOnlyNode();
            .setScroll(TimeValue.timeValueDays(1))
    public void testReplicaAlreadyAtCheckpoint() throws Exception {
        TermVectorsResponse response = client(replica).prepareTermVectors(indexOrAlias(), "1").get();
            final int additionalDocCount = scaledRandomIntBetween(0, 10);
            client().admin()
            .setSource("online", false, "bs", "Y", "ts", System.currentTimeMillis() - 100, "type", "s")
        client().prepareIndex(INDEX_NAME).setId("4").setSource("baz", "baz").get();
            .get();
        logger.info("Local segments after force merge and commit {}", getLatestSegmentInfos(replicaShard).files(false));
            () -> assertEquals(
import org.opensearch.core.common.breaker.CircuitBreaker;
                INDEX_NAME,
            .field("term_vector", "with_positions_offsets_payloads")
    public void testCancellationDuringGetSegments() throws Exception {
import org.opensearch.action.get.MultiGetRequest;
            TransportService.class,
                false,
        );
        verifyStoreContent();
                .put("index.refresh_interval", -1)
        // this test stubs transport calls specific to node-node replication.
        assertThat(response.getSourceAsMap().get("foo").toString(), equalTo("bar"));
                primaryShard.getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        // opens a scrolled query before a flush is called.
            .setId(String.valueOf(3))
        // wait for replication to complete
        logger.info("Verify that before merge, primary and replica contain _0.si and _1.si");
                } else {
            client().prepareIndex(INDEX_NAME).setId(String.valueOf(i)).setSource("foo", "bar").get();
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
            ensureYellowAndNoInitializingShards(INDEX_NAME);
            .setSource(jsonBuilder().startObject().field("field", "the quick brown fox jumps over the lazy dog").endObject())
            .setOffsets(true)
            .searchAfter(new Object[] { 30 })
        logger.info("replica {} acquire last IndexCommit", replicaShard.shardId());
            client().prepareIndex(INDEX_NAME).setId(docId).setSource("foo", "bar").get();
            primaryFilesAfterIndexCommitClose
        assertEquals(
        );
                    if (req.name().endsWith("cfs") && req.lastChunk()) {
        // wait for segrep to start and copy temporary files
        // realtime get 1
        refresh(INDEX_NAME);
        createIndex(
                RandomizedTest.scaledRandomIntBetween(2, 5),
            .put(super.indexSettings())
        ensureYellow(INDEX_NAME);
            );
        assertAcked(
        // start a replica node, initially will be empty with no shard assignment.
        final String replica = internalCluster().startDataOnlyNode();
    private void cancelDuringReplicaAction(String actionToblock) throws Exception {
        }
        assertNotNull(replicaShardRouting);
        final IndexShard primaryShard = getIndexShard(primary, INDEX_NAME);
import org.opensearch.action.admin.indices.alias.Alias;
            logger.info("former primary aid {}", primaryShard.routingEntry().allocationId());
                    add(CodecService.LUCENE_DEFAULT_CODEC);
                false,
                    .must(
                .indices()
    }
                .indices()
            SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES,
            replicaStats = replicaNode_service.nodeStats().getShardStats().get(replicaShard.shardId()).getReplicaStats();
    public void testReplicationPostDeleteAndForceMerge() throws Exception {
        assertEquals(getNodeContainingPrimaryShard().getName(), replica);
        final String nodeB = internalCluster().startDataOnlyNode();
        );
                RandomizedTest.scaledRandomIntBetween(2, 5),
        // force merge and flush.
            .setPayloads(true)
    public void testLocalSegmentReplicationWithException() throws Exception {
        int initialDocCount = scaledRandomIntBetween(10, 20);
        createIndex(INDEX_NAME);
        request.setPreference("_only_local");
            .getId();
        assertTrue(
            PublishCheckpointAction.ACTION_NAME + TransportReplicationAction.REPLICA_ACTION_SUFFIX,
                    .setId(Integer.toString(i))
        for (int i = initialDocCount; i < finalDocCount; i++) {
     * ongoing round of segment replication
            .setExplain(true)
        final List<ActionFuture<SearchResponse>> pendingSearchResponse = new ArrayList<>();
            TransportService.class,
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        flush(INDEX_NAME);
        // stop the primary node - we only have one shard on here.
                .get();
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);
        }
        refresh(INDEX_NAME);
        );
        logger.info("Segments {}", snapshottedSegments);
            prepareCreate(INDEX_NAME).setSettings(Settings.builder().put("index.refresh_interval", -1).put(indexSettings()))
            .get();
        MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
            BackgroundIndexer indexer = new BackgroundIndexer(
        blockFileCopy.countDown();
            .setRouting(routingOtherShard)
                    .startObject("_routing")
        indicesStatsRequest.indices(INDEX_NAME);
            assertAllocationIdsInReplicaShardStats(Set.of(replicaShard.routingEntry().allocationId().getId()), replicaStats);
        // index doc 1
        int expectedMaxSeqNo = initialDocCount + deletedDocCount + additionalDocs - 1;
        );
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
            .setQuery(matchAllQuery())
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(1));
        // remove the replica and ensure it is cleaned up.
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        List<String> currentFiles = List.of(replicaShard.store().directory().listAll());
        final String replicaNode = internalCluster().startDataOnlyNode();
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            // after the primary is dropped and replica is promoted we won't have a replica assigned yet, so stats per replica should return
        assertThat(mgetResponse.getResponses()[2].getFailure().getMessage(), is("no such index [nonExistingIndex]"));
            BackgroundIndexer indexer = new BackgroundIndexer(
        response = resp.execute().actionGet();
        client().prepareIndex(indexOrAlias()).setId("2").setSource("foo2", "bar2").setRouting(id).get();
        createIndex(INDEX_NAME, settings);
                (OpenSearchDirectoryReader) searcher.getDirectoryReader()
            .get();
        Set<String> primaryFilesAfterIndexCommitClose = Sets.newHashSet(primaryDirectory.listAll());
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
            .addSort("field", SortOrder.ASC)
        assertAcked(client().admin().indices().prepareClose(INDEX_NAME));
        final IndexShard replicaShard = getIndexShard(replica, INDEX_NAME);
    }
        client().prepareIndex(INDEX_NAME)
    public void testReplicaHasDiffFilesThanPrimary() throws Exception {
        ensureGreen(INDEX_NAME);
                replica_2.get().getLatestReplicationCheckpoint().getSegmentInfosVersion()
        cancelDuringReplicaAction(SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES);
                    .execute()
        primary.get().flush(request);
        prepareCreate(
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
import org.opensearch.cluster.node.DiscoveryNode;
        createIndex(INDEX_NAME);
        // index a doc and trigger replication
            .get();
        final int initialDocCount = 10;
                    .endObject()
     * This test verifies that segment replication does not fail for closed indices
        final int expectedHitCount = initialDocCount + additionalDocCount;
    public void testAcquireLastIndexCommit() throws Exception {
        IndicesStatsResponse indicesStatsResponse = client().admin().indices().stats(indicesStatsRequest).get();
        ensureGreen(INDEX_NAME);
        final String primaryNode = internalCluster().startDataOnlyNode();
        // primary and replica generate index commit
            indexer.start(initialDocCount);
            forceMerge();
            .put(TransportReplicationAction.REPLICATION_RETRY_TIMEOUT.getKey(), TimeValue.timeValueSeconds(0))
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        final int initialDocCount = scaledRandomIntBetween(0, 10);
            primary.set(replica_1.get().routingEntry().primary() ? replica_1.get() : replica_2.get());
        // index more docs and force merge down to 1 segment
                false,
            .setRequestCache(false)
        List<Document> docs = new ArrayList<>();
        ensureYellow(INDEX_NAME);
            .setId(Integer.toString(1))
        // index doc 2 with routing
            replicaFilesAfterIndexCommitClose.stream().noneMatch(s -> s.startsWith("_0"))
            final int expectedHitCount = initialDocCount + additionalDocCount;
            BackgroundIndexer indexer = new BackgroundIndexer(
                "We should have stats returned for the replication group",
            waitForDocs(expectedHitCount, indexer);
            ensureYellow(INDEX_NAME);
    /**
    public void testDeleteOperations() throws Exception {
            }
                .get();
                -1,
                    logger.info("mock remote transport exception");
    public void testCancellationDuringGetCheckpointInfo() throws Exception {
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            logger.info("action {}", actionToblock);
            final SegmentReplicationShardStats replica_entry = replicaStats.stream().findFirst().get();
        flushAndRefresh(INDEX_NAME);
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
            );
            .setSource(jsonBuilder().startObject().field("field", 0).endObject())
            indexer.start(initialDocCount);
            INDEX_NAME,
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
        client().admin().indices().prepareClose(INDEX_NAME).get();
        ensureGreen(INDEX_NAME);
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
        client().prepareIndex(INDEX_NAME)
        assertTrue(
    }
        waitForSearchableDocs(INDEX_NAME, 2 * searchCount, List.of(primary, replica));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        // there should be no active readers, snapshots, or on-disk commits containing the snapshotted files, check that they have been
        final String primaryNode = internalCluster().startDataOnlyNode();
        Set<String> latestCommitSegments = new HashSet<>(replicaShard.store().readLastCommittedSegmentsInfo().files(false));
            .endObject();
        assertFalse(mgetResponse.getResponses()[0].getResponse().isExists());
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
            dataNodes.add(internalCluster().startDataOnlyNode());
            BackgroundIndexer indexer = new BackgroundIndexer(
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(
        performReplicationAfterForceMerge(true, SHARD_COUNT);
        ensureGreen(INDEX_NAME);
                client(),
        mockTransportService.addSendBehavior(
import org.opensearch.indices.replication.checkpoint.PublishCheckpointAction;
        final String primary = internalCluster().startDataOnlyNode();
            final ForceMergeResponse forceMergeResponse = client().admin()
        assertFalse(mgetResponse.getResponses()[0].getResponse().isExists());
import java.util.HashSet;
        for (int i = 0; i < docCount; i++) {
            final int additionalDocCount = scaledRandomIntBetween(0, 2);
            SegmentReplicationPerGroupStats groupStats = shardStats.get(primaryShard.shardId());
    }
        client().prepareIndex(INDEX_NAME)
            verifyStoreContent();
            .get();
        final String nodeB = internalCluster().startDataOnlyNode();
                handler.messageReceived(request, channel, task);
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", randomInt()).get();
            prepareCreate(INDEX_NAME).setMapping(mapping)
            .setIndices(INDEX_NAME)
     * @throws Exception when issue is encountered
            .setSource("online", true, "ts", System.currentTimeMillis() - 123123, "type", "bs")
import org.apache.lucene.index.StandardDirectoryReader;
        waitForSearchableDocs(4, nodeC, replica);
        // index doc 1
import java.util.List;
        // create some segments on the replica before copy.
            String id = ids.toArray()[0].toString();
            indexer.start(initialDocCount);
                INDEX_NAME,
        assertFalse(response.isExists());
    public void testPrimaryReceivesDocsDuringReplicaRecovery() throws Exception {
                RandomizedTest.scaledRandomIntBetween(2, 5),
            );
            .get();
            ).addAlias(new Alias("alias"))
import org.apache.lucene.document.SortedDocValuesField;
        final Settings settings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build();
        // realtime termvectors (preference = _replica)
            String id = ids.toArray()[0].toString();
            indexer.start(docCount);
        client().prepareIndex(INDEX_NAME)
    public void testRestartPrimary() throws Exception {
                    .setSource("field", "value" + i)
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);
            waitForSearchableDocs(expectedHitCount, asList(primary, replica));
                        }
import org.apache.lucene.document.StringField;
            client().prepareIndex(INDEX_NAME).setId("2").setSource("foo2", randomInt()).get();
            );
            .add(new MultiGetRequest.Item(INDEX_NAME, "1"))
                client(),
        });
            ensureYellow(INDEX_NAME);
            .get()
                && replicaFilesAfterMerge.stream().anyMatch(s -> s.startsWith("_2"))
            waitForDocs(initialDocCount, indexer);
        ensureYellow(INDEX_NAME);
                        try {
            assertBusy(() -> {
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
                SegmentReplicationPressureService.class,
                RandomizedTest.scaledRandomIntBetween(2, 5),
        for (int i = 0; i < searchCount; i++) {
        ensureGreen(INDEX_NAME);
            Settings.builder()
        // force call flush
            flushAndRefresh(INDEX_NAME);
        createIndex(INDEX_NAME);
                handler.messageReceived(request, channel, task);
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
                client().admin()
            waitForDocs(initialDocCount, indexer);
        assertFalse(response.isExists());
    /**
                assertEquals(0, stats.getCheckpointsBehindCount());
import static org.opensearch.indices.replication.SegmentReplicationTarget.REPLICATION_PREFIX;
        logger.info("--> waiting for allocation to have shards assigned");
        final String id = routingKeyForShard(INDEX_NAME, 0);
        assertDocCounts(docCount, primaryNode);
        );
        final String replicaNode = internalCluster().startDataOnlyNode();
                Settings.builder().put("index.refresh_interval", -1).put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            .setId("3")
        verifyStoreContent();
            ClusterStatsResponse clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();
import org.opensearch.action.search.PitTestsUtil;
            // index another doc and refresh - without this the new replica won't catch up.
        final int initialDocCount = scaledRandomIntBetween(1, 5);
        final int replica_count = 6;
import org.opensearch.transport.client.Requests;
        waitForSearchableDocs(2, primaryNode, replicaNode);
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        assertAcked(
                RandomizedTest.scaledRandomIntBetween(2, 5),
                "_doc",
        assertThat("doc id: " + 1 + " doesn't exists but should", response.isExists(), equalTo(true));
        assertTrue(response.getHits().getTotalHits().value() >= 1);
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").get();
                            throw new RuntimeException(e);
                client(),
            .startObject("properties")
        client().admin().indices().prepareOpen(INDEX_NAME).get();
        final IndexShard indexShard = getIndexShard(primary, INDEX_NAME);
        assertThat(mgetResponse.getResponses()[2].getIndex(), is("nonExistingIndex"));
                    TestUtil.randomRealisticUnicodeString(random()),
            .setSize(10)
                );
        try (final Releasable ignored = blockReplication(List.of(replicaNode), latch)) {
    }
            )
                random()
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testReplicationAfterForceMergeOnPrimaryShardsOnly() throws Exception {
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        }, 1, TimeUnit.MINUTES);
        waitForSearchableDocs(1, primaryNode, replicaNode, replicaNode2);
            );
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        final String primaryNode = internalCluster().startDataOnlyNode();
import org.opensearch.index.engine.EngineConfig;
        // index a doc.
        ensureGreen(INDEX_NAME);
    /**
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
        for (int i = 11; i < 20; i++) {
        });
    }
        final String primaryNode = internalCluster().startDataOnlyNode();
            .stream()
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
            primaryNode
        final Settings settings = Settings.builder()
                    )
            flush(INDEX_NAME);
        assertBusy(() -> {
            client().prepareIndex(INDEX_NAME)
                "We should have stats returned for the replication group",
        AtomicReference<IndexShard> replica_1 = new AtomicReference<>();
        response = client().prepareGet(indexOrAlias(), "1").setRealtime(false).get();
        performReplicationAfterForceMerge(false, SHARD_COUNT * (1 + REPLICA_COUNT));
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
            refresh(INDEX_NAME);
            assertThat(forceMergeResponse.getSuccessfulShards(), is(expectedSuccessfulShards));
        logger.info("--> temporaryFilesPostClear {}", temporaryFilesPostClear);
        ensureYellow(INDEX_NAME);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        response = resp.execute().actionGet();
        final String replicaNode = internalCluster().startDataOnlyNode();
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 2);
        PitTestsUtil.assertUsingGetAllPits(client(replica), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueDays(1));
    public void testRealtimeGetRequestsSuccessful() {
                replicaNode_service.nodeStats().getShardStats().size()
import org.opensearch.test.BackgroundIndexer;
            replicaNode
    }
        final WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
        waitForSearchableDocs(initialDocCount, replica, primary);
                    .field("type", "date")
                            latch.await();
import org.opensearch.search.SearchService;
        ) {
                    .endObject()
            .add(new MultiGetRequest.Item(INDEX_NAME, "1").routing(routingOtherShard))
            segmentReplicationWithRemoteEnabled()
import org.apache.lucene.document.TextField;
                    logger.debug("file chunk [{}] lastChunk: {}", req, req.lastChunk());
        assertNotNull(replicaShardRouting);
    public void testScrollWithConcurrentIndexAndSearch() throws Exception {
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
        assertTrue("Files should be preserved", currentFiles.containsAll(snapshottedSegments));
                replica_1.get().routingEntry().primary() || replica_2.get().routingEntry().primary()
            client(nodeA).prepareDelete(INDEX_NAME, id).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        response = client(replica).prepareGet(indexOrAlias(), "2").setRouting(id).get();
import org.opensearch.index.SegmentReplicationShardStats;
        try (
                .setSettings(
        latch.countDown();
        assertFalse(response.isExists());
            .setRequestCache(false)
        ensureGreen(INDEX_NAME);
        client().admin()
import org.apache.lucene.document.Document;
                "_doc",
        // Drop the primary and wait until replica is promoted.
        for (int i = 0; i < docCount; i++) {
        SegmentReplicationTarget target = targetService.get(replicaShard.shardId());
            .setPositions(true)
            .get();
                    "body",
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime get
        );
            )
            .setRealtime(true)
            replica_2.set(replicaShard2);
import org.opensearch.index.IndexModule;
        CountDownLatch blockFileCopy = new CountDownLatch(1);
        primaryTransportService.addSendBehavior(
        final ShardRouting replicaShardRouting = getShardRoutingForNodeName(replica);
        // Flush segments to disk and create a new commit point (Primary: segments_3, _s1.si)
        // make sure doc 2 is on the replica realtime GET reads from translog, not search
import org.opensearch.action.search.CreatePitResponse;
            "primaryFilesAfterIndexCommitClose {}: {}",
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
            primaryNode
        waitForSearchableDocs(docCount, primaryNode, replicaNode);
                            .should(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        // wait for replica to catch up and verify doc count
            docs.add(doc);
            assertEquals(
            )
        });
        final int additionalDocs = randomIntBetween(1, 5);
            prepareCreate(INDEX_NAME).setSettings(
            .setSource("foo3", "bar3")
            client(primary).prepareDelete(INDEX_NAME, String.valueOf(i)).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        latch.countDown();
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(false).get();
                    throw new CircuitBreakingException("mock circuit break exception", CircuitBreaker.Durability.TRANSIENT);
        client(replica).prepareClearScroll().addScrollId(searchResponse.getScrollId()).get();
import org.opensearch.action.search.SearchResponse;
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            String docId = String.valueOf(initialDocCount + 1);
        assertThat(mgetResponse.getResponses()[1].getIndex(), is("nonExistingIndex"));
        ensureYellowAndNoInitializingShards(INDEX_NAME);
                && replicaFilesAfterIndexCommitClose.stream().anyMatch(s -> s.startsWith("_2"))
            replicaFilesBeforeMerge.stream().anyMatch(s -> s.startsWith("_0"))
            (handler, request, channel, task) -> {
        internalCluster().startClusterManagerOnlyNode();
            .setRouting(randomAlphaOfLength(2))
            .get();
            }
            .setId("3")
                        } catch (InterruptedException e) {
import org.opensearch.common.action.ActionFuture;
                1,
        ensureGreen(INDEX_NAME);
            verifyStoreContent();
        // delete the PIT
            .put(indexSettings())
            internalCluster().getInstance(TransportService.class, replicaNode),
        );
            .get();
        final String nodeA = internalCluster().startDataOnlyNode();
    }
        );
        assertNoFailures(response);
        refresh(INDEX_NAME);
        waitForSearchableDocs(initialDocCount, primary, replica);
            )
            decode(registry, pitResponse.getId()).shards().get(replicaShard.routingEntry().shardId()).getSearchContextId()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            pendingIndexResponses.add(
            }
        assertEquals("Replication not closed: " + target.getId(), 0, target.refCount());
            assertTrue(pendingSearchResponse.stream().allMatch(ActionFuture::isDone));
            )
import org.apache.lucene.store.Directory;
                client(),
        logger.info("Verify that after merge, primary and replica contain _0.si, _1.si and _2.si");
        final String primary = internalCluster().startDataOnlyNode();
                && replicaFilesAfterIndexCommitClose.stream().noneMatch(s -> s.startsWith("_1"))
                    .endObject()
            TransportService.class,
        logger.info("replicaFilesAfterMerge {}: {}", replicaFilesAfterMerge.size(), replicaFilesAfterMerge);
        ensureGreen(INDEX_NAME);
        } else {
    }
        ));
                assertAllocationIdsInReplicaShardStats(Set.of(second_replica_aid), shardStatsSet);
            .setVersion(true)
        // Clear scroll query, this should clean up files on replica
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import org.opensearch.index.SegmentReplicationPressureService;
            .setIndices(INDEX_NAME)
        Fields fields = response.getFields();
        assertTrue(response.isExists());
            flush(INDEX_NAME);
            waitForDocs(docCount, indexer);
        final int finalDocCount = 20;
            .setQuery(matchAllQuery())
    private static String indexOrAlias() {
        final String primary = internalCluster().startDataOnlyNode();
        verifyStoreContent();
            }
        // Test update of configuration PublishCheckpointAction#PUBLISH_CHECK_POINT_RETRY_TIMEOUT.
                    latch2.await();
import static org.opensearch.index.query.QueryBuilders.termQuery;
                }
        // realtime get 1 (with routing set)
                {
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        // replica now promoted as primary should have same allocation id
            .get();
    }
        final String primary = internalCluster().startDataOnlyNode();
        createIndex(INDEX_NAME, indexSettings);
            final IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
                    random().nextBoolean() ? Field.Store.YES : Field.Store.NO
                .setSettings(
                && replicaFilesAfterMerge.stream().anyMatch(s -> s.startsWith("_1"))
        );
            .allocationId()
                .prepareUpdateSettings(INDEX_NAME)
        primaryTransportService.addRequestHandlingBehavior(
        for (int i = initialDocCount; i < initialDocCount + additionalDocs; i++) {
            indexer.start(initialDocCount);
            UpdateResponse updateResponse = client(primary).prepareUpdate(INDEX_NAME, id)
            // test a checkpoint without any new segments
        // deleted.
            .setSize(10)
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                INDEX_NAME,
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();
        assumeFalse(
     * Tests that when scroll query is cleared, it does not delete the temporary replication files, which are part of
import org.opensearch.search.sort.SortOrder;
                if (mockReplicaReceivePublishCheckpointException.get()) {
        final String nodeB = internalCluster().startDataOnlyNode();
            flushAndRefresh(INDEX_NAME);
        TermVectorsRequestBuilder resp = client(replica).prepareTermVectors(indexOrAlias(), Integer.toString(1))
    public void testPitCreatedOnReplica() throws Exception {
        ensureGreen(INDEX_NAME);
        // start 2nd node so that it contains the replica
        final String primary = internalCluster().startDataOnlyNode();
            .collect(Collectors.toList());
            .setPreference("_only_local")
                INDEX_NAME,
        client().prepareIndex(INDEX_NAME)
        );
            .setSize(10)
        response = client(replica).prepareGet(indexOrAlias(), "1").setPreference(Preference.REPLICA.type()).get();
                && primaryFilesAfterMerge.stream().anyMatch(s -> s.startsWith("_1"))
            INDEX_NAME,
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
        ensureGreen(INDEX_NAME);
            refresh(INDEX_NAME);
            // start another replica.
            .prepareReroute()
        final String replicaNode = internalCluster().startDataOnlyNode();
                false,
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
                primaryNode
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                    .startObject("online")
import java.util.Collection;
        ) {
        assertBusy(
        }
                            throw new RuntimeException(e);
            )
            .actionGet();
                -1,
                        }
            .setOffsets(true)
        waitForSearchableDocs(3, primaryNode, replicaNode);
            assertSearchHits(client(primary).prepareSearch(INDEX_NAME).setQuery(matchQuery("foo", "baz")).get(), id);
        }
        flushAndRefresh(INDEX_NAME);
            .startObject("field")
        ensureGreen(INDEX_NAME);
        client().admin()
            flush(INDEX_NAME);
                RandomizedTest.scaledRandomIntBetween(2, 5),
        client().prepareIndex(INDEX_NAME)
                final SegmentReplicationShardStats stats = shardStatsSet.stream().findFirst().get();
        try (
        assertHitCount(client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), expectedHitCount + 1);
        if (randomBoolean()) {
            assertEquals(0L, replicationStats.maxReplicationLag);
                connection.sendRequest(requestId, action, request, options);
        ensureGreen(INDEX_NAME);
            indexer.start(additionalDocCount);
        ));
        client().prepareIndex(INDEX_NAME).setId("2").setSource("bar", "baz").setRefreshPolicy(WriteRequest.RefreshPolicy.NONE).get();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        ));
        final String primary = internalCluster().startDataOnlyNode();
        ensureGreen(INDEX_NAME);
        assertAcked(
     * This tests that if a primary receives docs while a replica is performing round of segrep during recovery
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        client().prepareIndex(INDEX_NAME).setId(String.valueOf(expectedMaxSeqNo + 1)).setSource("another", "doc").get();
        Set<String> replicaFilesAfterIndexCommitClose = Sets.newHashSet(replicaDirectory.listAll());
            .setPreference(Preference.REPLICA.type())
        MultiGetResponse mgetResponse = client(replica).prepareMultiGet()
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
                .put("index.refresh_interval", -1)
        assertFalse(response.isExists());
                .setFlush(false)
        ) {
            verifyStoreContent();
        List<String> filesBeforeClearScroll = List.of(replicaShard.store().directory().listAll());
        internalCluster().restartNode(primary);
            TransportService.class,
     * Tests whether segment replication supports realtime MultiGet requests and reads and parses source from the translog to serve strong reads.
        MultiGetResponse mgetResponse = client().prepareMultiGet()
        }
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
    }
    /**
        replicaTransportService.addRequestHandlingBehavior(
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);
            writer.commit();
            }
            indexer.start(initialDocCount);
            }))
import org.opensearch.cluster.routing.Preference;
                    .getShardStats()
            "Skipping the test as its not compatible with segment replication with remote store.",
        client().prepareIndex(INDEX_NAME).setId("3").setSource("foo", "bar").get();
            .index(INDEX_NAME)
                random()
    }
        );
        );
            )
        // index doc 1
        // Unblock segment replication
            .cluster()
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 3);
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime termvectors
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
            .get();
        createIndex(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        refresh(INDEX_NAME);
                RandomizedTest.scaledRandomIntBetween(2, 5),
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2))
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;
        nodes.add(internalCluster().startDataOnlyNode());
            .setSource("foo", "bar")
                INDEX_NAME,
                    .endObject()
        final String replica = internalCluster().startDataOnlyNode();
     */
                .get();
        mgetResponse = client(replica).prepareMultiGet()
        createIndex(INDEX_NAME);
        );
                    }
    public void testIndexReopenClose() throws Exception {
                .indices()
            .execute()
                replicaShard.getLatestReplicationCheckpoint().getSegmentInfosVersion()
        final String replica = internalCluster().startDataOnlyNode();
                connection.sendRequest(requestId, action, request, options);
            client().admin()
        });
        assertThat(fields.size(), equalTo(1));
                false,
        assertTrue("Files should be preserved", filesBeforeClearScroll.containsAll(snapshottedSegments));
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        // index doc 1
            );
            .setQuery(
                        try {
        assertBusy(
            .setQuery(matchAllQuery())
                    FileChunkRequest req = (FileChunkRequest) request;
        final String replica = internalCluster().startDataOnlyNode();
            .setId(String.valueOf(0))
        assertEquals(getNodeContainingPrimaryShard().getName(), primary);
            );
            .setPersistentSettings(
        assertSegments(false, INDEX_NAME, 1, client(replica), pitResponse.getId());
                        }
                .setSource("foo", randomInt())
        final String replica = internalCluster().startDataOnlyNode();
                    .prepareUpdateSettings(INDEX_NAME)
            refresh(INDEX_NAME);
            primary
        final int docCount = scaledRandomIntBetween(10, 20);
        final String replica = internalCluster().startDataOnlyNode();
        // perform refresh to start round of segment replication
    }
            Document doc = new Document();
                random()
            .setPositions(true)
        try (
        logger.info("--> Opening the index");
    /**
                "_doc",
            waitForDocs(initialDocCount, indexer);
            verifyStoreContent();
    }
        ensureGreen(INDEX_NAME);
     */
            .setPositions(true)
        // non realtime get 1
            .setRouting(id)
import java.util.Map;
        );
            .filter(fileName -> fileName.startsWith(REPLICATION_PREFIX))
        request.force(true);
            .put(EngineConfig.INDEX_CODEC_SETTING.getKey(), randomFrom(new ArrayList<>(CODECS) {
                .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)
        waitForSearchableDocs(2, nodes);
        // expecting failure since we explicitly route request to a shard on which it doesn't exist
import org.apache.lucene.index.IndexCommit;
                writer.addDocument(d);
import org.opensearch.action.termvectors.TermVectorsRequestBuilder;
    }
                )
    }
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));
        startCancellationLatch.await();
        }
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", randomInt()).get();
import org.opensearch.search.builder.PointInTimeBuilder;
        replicaShard.flush(new FlushRequest(INDEX_NAME));
        Set<String> primaryFilesBeforeMerge = Sets.newHashSet(primaryDirectory.listAll());
            IndexShard replicaShard2 = getIndexShard(replicaNode2, INDEX_NAME);
        // mock network exception
        ensureGreen(INDEX_NAME);
            waitForDocs(expectedHitCount, indexer);
        FlushRequest request = new FlushRequest(INDEX_NAME);
        try (
import org.opensearch.transport.TransportService;
        CountDownLatch latch = new CountDownLatch(1);
        final String replica = internalCluster().startDataOnlyNode();
        // realtime get 2 (with routing)
            refresh(INDEX_NAME);
        createIndex(INDEX_NAME, settings);
import java.util.Set;
        assertThat(mgetResponse.getResponses()[1].getIndex(), is(INDEX_NAME));
        assertThat(mgetResponse.getResponses().length, is(3));
        assertBusy(() -> {
            .actionGet();
        ensureYellow(INDEX_NAME);
            assertEquals(0L, replicationStats.maxBytesBehind);
            SegmentReplicationPressureService replicaNode_service = internalCluster().getInstance(
        // opens a scrolled query before a flush is called.
    }
    public void testRestartPrimary_NoReplicas() throws Exception {
        FlushRequest flushRequest = Requests.flushRequest(INDEX_NAME);
            .get();
        );
        MockTransportService replicaTransportService = ((MockTransportService) internalCluster().getInstance(
            internalCluster().getInstance(TransportService.class, replicaNode),
        final IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
                .build()
        response = client(replica).prepareGet(indexOrAlias(), "1").get();
                random()
                -1,
        refresh();
        final long expectedHitCount = initialDocCount + additionalDocs - deletedDocCount;
            primaryNode
        ));
            final IndexShard secondReplicaShard = getIndexShard(replicaNode_2, INDEX_NAME);
import static java.util.Arrays.asList;
        primaryTransportService.addSendBehavior(
                    .field("type", "keyword")
        assertFalse(response.isExists());
        client().prepareIndex(INDEX_NAME).setId("2").setSource("foo2", "bar2").setRouting(id).get();
                -1,
    public void testRealtimeGetRequestsUnsuccessful() {
        final String replicaNode = internalCluster().startDataOnlyNode();
            logger.info("Replica aid {}", replicaShard.routingEntry().allocationId());
            assertEquals(replica_entry.getCheckpointsBehindCount(), 0);
        client().prepareClearScroll().addScrollId(searchResponse.getScrollId()).get();
        try (
 *
        logger.info("primary {} acquire last IndexCommit", primaryShard.shardId());
 * The OpenSearch Contributors require contributions made to
                }
        createIndex(INDEX_NAME);
            // empty.
            .get()
        final ShardRouting replicaShardRouting = getShardRoutingForNodeName(replica);
        waitForSearchableDocs(initialDocCount, primary, replica);
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
                logger.info("replica receive publish checkpoint request");
                    .field("ignore_malformed", false)
    }
        assertEquals(expectedMaxSeqNo, replicaShard.seqNoStats().getMaxSeqNo());
            }
        flushAndRefresh(INDEX_NAME);
                INDEX_NAME,
     */
            .add(new MultiGetRequest.Item(INDEX_NAME, "1"))
     * from xlog.
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
import org.opensearch.cluster.health.ClusterHealthStatus;
        }
        refresh(INDEX_NAME);
            client().admin().indices().prepareRefresh().execute().actionGet();
        final String routingOtherShard = routingKeyForShard(INDEX_NAME, 1);
                            boolQuery().must(rangeQuery("ts").lt(System.currentTimeMillis() - (15 * 1000))).must(termQuery("type", "bs"))
        assertAcked(
                false,
            segmentReplicationWithRemoteEnabled()
        Set<String> replicaFilesAfterMerge = Sets.newHashSet(replicaDirectory.listAll());
    public void testClosedIndices() {
        logger.info("--> Collect all scroll query hits");
    public void testCancellation() throws Exception {
                    FileChunkRequest req = (FileChunkRequest) request;
        ensureGreen(INDEX_NAME);
            .endObject()
        refresh(INDEX_NAME);
        );
            verifyStoreContent();
        createIndex(INDEX_NAME);
        SearchResponse response = client().prepareSearch(INDEX_NAME)
        SearchResponse resp = client(replica).prepareSearch(INDEX_NAME)
    public void testScrollWithOngoingSegmentReplication() throws Exception {
        final int initialDocCount = 1;
                .prepareUpdateSettings(INDEX_NAME)
        final String id = routingKeyForShard(INDEX_NAME, 0);
            "Snapshotted files are no longer part of the latest commit",
    }
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        assertHitCount(client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 3);
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));
        client().admin().indices().flush(flushRequest).get();
            .setScroll(TimeValue.timeValueDays(1))
            for (Document d : docs) {
        client().prepareIndex(indexOrAlias()).setId("1").setSource("foo", "bar").setRouting(id).get();
        final String replicaNode = internalCluster().startDataOnlyNode();
        final String primaryNode = internalCluster().startDataOnlyNode();
                latch2.countDown();
            // verify replica contains temporary files
            .put(indexSettings())
            .get();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        assertBusy(() -> {
        replicaShard.flush(new FlushRequest(INDEX_NAME));
    }
        // this test cancels allocation on the primary - promoting the new replica and recreating the former primary as a replica.
        assertAcked(
            waitForDocs(initialDocCount, indexer);
        }
        CountDownLatch latch = new CountDownLatch(1);
        waitForSearchableDocs(3, primaryNode, replicaNode);
            .setSelectedFields();
            // index another doc while blocked, this would not get replicated to replica.
            refresh(INDEX_NAME);
import org.opensearch.index.codec.CodecService;
    public void testStartReplicaAfterPrimaryIndexesDocs() throws Exception {
     * Tests a scroll query on the replica
            final int additionalDocCount = scaledRandomIntBetween(0, 5);
        SearchResponse searchResponse = client(replica).prepareSearch(INDEX_NAME)
            .index(INDEX_NAME)
        // index doc 2
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
                    mockException.set(false);
            assertTrue(
        assertTrue(mgetResponse.getResponses()[2].isFailed());
        final String primaryNode = internalCluster().startDataOnlyNode();
            flush(INDEX_NAME);
        // generate _1.si
        SearchResponse searchResponse = client(replica).prepareSearch()
        ));
            ReplicationStats replicationStats = clusterStatsResponse.getIndicesStats().getSegments().getReplicationStats();
        assertThat("doc id: " + 1 + " doesn't exists but should", response.isExists(), equalTo(true));
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
        do {
            .setOffsets(true)
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
            // Fetch pressure stats from the Replica's Node we will assert replica node returns nothing until it is promoted.
        ));
            .setRouting("Y")
                        boolQuery().should(
        ) {
import org.apache.lucene.document.Field;
                "_doc",
                .put("index.refresh_interval", -1)
            if (randomBoolean()) {
                logger.info(
    }
        assumeFalse(
            .setSize(10)
        client().prepareIndex(indexOrAlias()).setId("1").setSource("foo", "bar").get();
        logger.info("Verify that after close index commit, primary and replica only contain _2.si");
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .get();
        CountDownLatch blockFileCopy = new CountDownLatch(1);
    }
        createIndex(INDEX_NAME);
            primaryFilesAfterIndexCommitClose.size(),
        final String replicaNode = internalCluster().startDataOnlyNode();
        createIndex(INDEX_NAME);
import org.opensearch.index.engine.NRTReplicationReaderManager;
                    latch1.countDown();
        waitForSearchableDocs(initialDocCount, replica, primary);
        verifyStoreContent();
        int numDocs = 2 + random().nextInt(10);
            .setSelectedFields();
            .field("analyzer", "tv_test")
            }
        );
        flush(INDEX_NAME);
                RandomizedTest.scaledRandomIntBetween(2, 5),
import org.apache.lucene.index.IndexWriterConfig;
        assertBusy(() -> { assertDocCounts(docCount, replicaNode); });
            .get();
            (handler, request, channel, task) -> {
            Set<SegmentReplicationShardStats> replicaStats = groupStats.getReplicaStats();
import org.opensearch.action.index.IndexResponse;
            .setPayloads(true)
import static org.hamcrest.Matchers.equalTo;
                    .getReplicaStats();
            .endObject()
        internalCluster().restartNode(primary);
            .setScroll(TimeValue.timeValueDays(1))
            .get();
            .setId(Integer.toString(2))
        assertEquals(1, pitCurrent);
                        )
        long openContexts = indicesStatsResponse.getIndex(INDEX_NAME).getTotal().search.getOpenContexts();
        client().prepareIndex(indexOrAlias()).setId("1").setSource("foo", "bar").setRouting(id).get();
        CountDownLatch latch2 = new CountDownLatch(1);
                .prepareUpdateSettings(INDEX_NAME)
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .setRouting("X")
            );
        // verify temporary files still exist
        // assert we can index into the new primary and refresh there, making doc2 searchable too.
                boolQuery().must(termQuery("online", true))
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
                        .put("index.refresh_interval", -1)
            (connection, requestId, action, request, options) -> {
     */
            );
            assertEquals(
            ensureGreen(INDEX_NAME);
            });
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);
                        throw new NodeClosedException(primaryDiscovery);
        final IndexShard replicaShard = getIndexShard(replica, INDEX_NAME);
        final String primary = internalCluster().startDataOnlyNode();
        );
        ).get();
        Settings indexSettings = Settings.builder()
        for (int i = 0; i < 10; i++) {
                .get();
        String nodeC = internalCluster().startDataOnlyNode();
            internalCluster().getInstance(TransportService.class, replica),
            );
            .setId("1")
        client().prepareIndex(INDEX_NAME).setId("2").setSource("foo", "bar").get();
                random()
        ensureGreen(INDEX_NAME);
        final int deletedDocCount = randomIntBetween(1, initialDocCount);
        final String replica = internalCluster().startDataOnlyNode();
            "Skipping the test as its not compatible with segment replication with remote store.",
        Set<String> primaryFilesAfterMerge = Sets.newHashSet(primaryDirectory.listAll());
            .prepareUpdateSettings()
    public void testCancelPrimaryAllocation() throws Exception {
        );
            )
import org.opensearch.core.common.breaker.CircuitBreakingException;
                    .execute()
        SearchResponse searchResponse = client(replica).prepareSearch()
    public void testRealtimeTermVectorRequestsSuccessful() throws IOException {
        // stop the replica, this will do additional checks on shutDown to ensure the replica and its store are closed properly
            waitForSearchableDocs(initialDocCount, primary, replica);
            ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        // non realtime get 1
    }
            () -> assertEquals(
            .execute()
                INDEX_NAME,
        waitForRelocation(ClusterHealthStatus.GREEN);
        replicaIndexCommit.close();
        // multi get realtime 1
                        .put("index.refresh_interval", -1)
            .shardsWithState(ShardRoutingState.STARTED)
            assertTrue(temporaryFiles.size() > 0);
        // update publish checkpoint retry time out
                -1,
        }
import org.opensearch.index.SegmentReplicationPerGroupStats;
                )
        verifyStoreContent();
            .findFirst()
            waitForDocs(expectedHitCount, indexer);
        List<String> temporaryFilesPostClear = Arrays.stream(replicaShard.store().directory().listAll())
        createIndex(INDEX_NAME);
import org.opensearch.cluster.ClusterState;
import static org.opensearch.index.query.QueryBuilders.boolQuery;
            final StandardDirectoryReader standardDirectoryReader = NRTReplicationReaderManager.unwrapStandardReader(
        ActionFuture<CreatePitResponse> execute = client(replica).execute(CreatePitAction.INSTANCE, request);
            TransportService.class,
            try {
            .filter(routing -> routing.primary())
        assertNotEquals(replicaAfterFailure.routingEntry().allocationId().getId(), replicaShard.routingEntry().allocationId().getId());
        final String replica = internalCluster().startDataOnlyNode();
        }
            .filter(routing -> routing.primary() == false)
        final IndexShard replicaShard = getIndexShard(replica, INDEX_NAME);
            // Index a second set of docs so we can merge into one segment.
        // create the cluster with one primary node containing primary shard and replica node containing replica shard
        mgetResponse = client(replica).prepareMultiGet()
        );
            primaryNode
     * This tests that the max seqNo we send to replicas is accurate and that after failover
        assertBusy(() -> assertTrue(client(replica).prepareGet(INDEX_NAME, "2").setRealtime(true).get().isExists()));
        ensureGreen(INDEX_NAME);
    }
                .setId(String.valueOf(i))
            .searchAfter(new Object[] { 30 })
            // update to add replica, initiating recovery, this will get stuck at last step
            // start another replica.
        waitForSearchableDocs(finalDocCount, primary, replica);
        ) {
        waitForSearchableDocs(2, primaryNode, replicaNode);
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(
                client(),
        final String primary = internalCluster().startDataOnlyNode();
            waitForSearchableDocs(initialDocCount, dataNodes);
        final String replicaNode = internalCluster().startDataOnlyNode(mockNodeSetting);
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
        assertEquals(currentAllocationID, replicaAllocationId);
                .addAlias(new Alias("alias"))
                            throw new RuntimeException(e);
            )
        final String primary = internalCluster().startDataOnlyNode();
import org.opensearch.indices.replication.common.ReplicationType;
        final String primary = internalCluster().startDataOnlyNode();
            indexer.start(additionalDocCount);
            .setPreference("_only_local")
        try (final Engine.Searcher searcher = pitReaderContext.acquireSearcher("test")) {
    }
                    ((GetSegmentFilesRequest) request).getReplicationId(),
        final String replicaNode = internalCluster().startDataOnlyNode();
            assertAcked(
        ) {
import org.opensearch.action.search.SearchType;
import java.util.stream.Collectors;
            replicaStats = replicaNode_service.nodeStats().getShardStats().get(primaryShard.shardId()).getReplicaStats();
    public void testMultipleShards() throws Exception {
        assertTrue(
            .findFirst()
        waitForSearchableDocs(0, replicaNode);
        ) {
            client().prepareIndex(INDEX_NAME).setId(String.valueOf(i)).setSource("foo", "bar").get();
        SearchService searchService = internalCluster().getInstance(SearchService.class, replica);
        final String primaryNode = internalCluster().startDataOnlyNode();
        try (
        XContentBuilder mapping = jsonBuilder().startObject()
                    .startObject("ts")
 * this file be licensed under the Apache-2.0 license or a
        primaryTransportService.addRequestHandlingBehavior(actionToblock, (handler, request, channel, task) -> {
    }
        final String primary = internalCluster().startDataOnlyNode();
        AtomicBoolean mockReplicaReceivePublishCheckpointException = new AtomicBoolean(true);
            .shardsWithState(ShardRoutingState.STARTED)
        assertThat(response.getSourceAsMap().get("foo2").toString(), equalTo("bar2"));
        client().prepareIndex(INDEX_NAME)
        client().prepareIndex(INDEX_NAME)
            Settings.builder()
import org.opensearch.test.transport.MockTransportService;
        refresh(INDEX_NAME);
        client().prepareIndex(INDEX_NAME)
import java.util.concurrent.CountDownLatch;
        assertBusy(() -> {
        );
    public void testReplicationAfterPrimaryRefreshAndFlush() throws Exception {
            }
                }
        );
        assertFalse(response.isExists());
            .setRequestCache(false)
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
        // generate _1.si
                .setSource("foo", randomInt())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            .setIndices(INDEX_NAME)
            .stream()
        assertEquals(getNodeContainingPrimaryShard().getName(), replica);
        request.setIndices(new String[] { INDEX_NAME });
        // this test stubs transport calls specific to node-node replication.
        final String nodeA = internalCluster().startDataOnlyNode();
            client().prepareIndex(INDEX_NAME)
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        // start another node, index another doc and replicate.
        nodes.add(internalCluster().startDataOnlyNode());
            .get();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            doc.add(new SortedDocValuesField("dv", new BytesRef(TestUtil.randomRealisticUnicodeString(random()))));
    }
        IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
            String replicaNode_2 = internalCluster().startDataOnlyNode();
        final String primaryNode = internalCluster().startDataOnlyNode();
            waitForDocs(expectedHitCount, indexer);
import static org.opensearch.action.search.PitTestsUtil.assertSegments;
                }
            () -> assertEquals(
        ensureGreen(INDEX_NAME);
        // generate _0.si
        assertEquals(expected, replicaStats.stream().map(SegmentReplicationShardStats::getAllocationId).collect(Collectors.toSet()));
        );
import org.opensearch.action.get.GetResponse;
            refresh(INDEX_NAME);
    }
        // this is for testing scroll segment consistency between refresh and flush
                    if (req.name().endsWith("cfs") && req.lastChunk()) {
            )
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
                .setPrimaryOnly(primaryOnly)
            .put(PublishCheckpointAction.PUBLISH_CHECK_POINT_RETRY_TIMEOUT.getKey(), TimeValue.timeValueSeconds(0))
                INDEX_NAME,
                    .setSource("field", "value" + i)
            .allocationId()
        assertBusy(() -> {
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        final String replica = internalCluster().startDataOnlyNode();
        client().execute(DeletePitAction.INSTANCE, deletePITRequest).actionGet();
        final List<String> nodes = new ArrayList<>();
        assertBusy(() -> {
    }
            } catch (InterruptedException e) {
            assertThat(forceMergeResponse.getFailedShards(), is(0));
            searchResponse = client(replica).prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueDays(1)).get();
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        final String replicaNode2 = internalCluster().startDataOnlyNode();
        nodes.add(primaryNode);
        final String primaryNode = internalCluster().startDataOnlyNode(mockNodeSetting);
        });
    public void testReplicationAfterForceMerge() throws Exception {
import org.opensearch.cluster.routing.ShardRouting;
        // non realtime termvectors 1
        final String id = routingKeyForShard(INDEX_NAME, 0);
        final int searchCount = randomIntBetween(1, 2);
        ensureGreen(INDEX_NAME);
            refresh(INDEX_NAME);
        for (int i = 0; i < initialDocCount; i++) {
        }
            .setSource(jsonBuilder().startObject().field("field", "the quick brown fox jumps over the lazy dog").endObject())
        createIndex(INDEX_NAME);
            INDEX_NAME,
        assertTrue(mgetResponse.getResponses()[1].isFailed());
                }
            indexer.start(initialDocCount);
        });
                client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
            refresh(INDEX_NAME);
                client(),
            .field("type", "text")
        final int initialDocCount = scaledRandomIntBetween(1, 10);
            replicaFilesAfterIndexCommitClose
import org.opensearch.common.settings.Settings;
    }
            final int expectedHitCount = initialDocCount + additionalDocCount;
                // we want to control refreshes
        // index doc 2
    @Before
        client(replica).prepareIndex(INDEX_NAME)
            assertEquals(0L, replicationStats.totalBytesBehind);
        // fetch the segments snapshotted when the reader context was created.
        final String replica = internalCluster().startDataOnlyNode();
        AtomicReference<IndexShard> replica_2 = new AtomicReference<>();
        replicaTransportService.addRequestHandlingBehavior(
            ).addAlias(new Alias("alias"))
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitResponse.getId());
            Collections.emptySet(),
        }
        waitForSearchableDocs(4, primaryNode, replicaNode);
import static org.hamcrest.Matchers.is;
            .setSize(10)
     *
        createIndex(INDEX_NAME);
            assertAllSuccessful(searchResponse);
        final int docCount = scaledRandomIntBetween(1, 10);
            doc.add(
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
            BackgroundIndexer indexer = new BackgroundIndexer(
                .put(indexSettings())
import org.opensearch.action.support.replication.TransportReplicationAction;
                "_doc",
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            primaryFilesBeforeMerge.stream().anyMatch(s -> s.startsWith("_0"))
        createIndex(INDEX_NAME);
    public void testRealtimeMultiGetRequestsSuccessful() {
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
        );
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
                    .setRefreshPolicy(refreshPolicy)
        verifyStoreContent();
    }
                -1,
            final Map<ShardId, SegmentReplicationPerGroupStats> shardStats = pressureService.nodeStats().getShardStats();
            .setPreference("_only_local")
            indexer.start(additionalDocCount);
        );
        logger.info("primaryFilesAfterMerge {}: {}", primaryFilesAfterMerge.size(), primaryFilesAfterMerge);
        fields = response.getFields();
                    "replicationId {}, get segment files {}",
            (handler, request, channel, task) -> {
 */
            flush(INDEX_NAME);
        assertEquals(1, searchResponse.getTotalShards());
            replicaFilesAfterMerge.stream().anyMatch(s -> s.startsWith("_0"))
import java.util.concurrent.atomic.AtomicBoolean;
     */
import org.apache.lucene.tests.util.TestUtil;
     * @throws Exception when issue is encountered
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
                startCancellationLatch.countDown();
            assertFalse(ids.isEmpty());
        nodes.add(replicaNode);
            assertEquals(
        for (int i = 0; i < numDocs; i++) {
            BackgroundIndexer indexer = new BackgroundIndexer(
            .addSort("foo", SortOrder.ASC)
            assertAllocationIdsInReplicaShardStats(Set.of(second_replica_aid), replicaStats);
        ensureGreen(INDEX_NAME);
                flush(INDEX_NAME);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            Sets.intersection(filesAfterClearScroll, snapshottedSegments)
    public void testUpdateOperations() throws Exception {
            (connection, requestId, action, request, options) -> {
        indicesStatsRequest.all();
        refresh(INDEX_NAME);
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
            .setId("4")
            assertSearchHits(client(replica).prepareSearch(INDEX_NAME).setQuery(matchQuery("foo", "baz")).get(), id);
            .setSource("bar", "baz")
            prepareCreate(INDEX_NAME).setSettings(
        assertFalse(response.isExists());
        } while (searchResponse.getHits().getHits().length > 0);
        });
            assertNotNull("Replica shard 1 should not be null", replicaShard1);
        waitForFileCopy.await();
        List<String> temporaryFiles = new ArrayList<>();
        CountDownLatch waitForFileCopy = new CountDownLatch(1);
        final String replicaNode = internalCluster().startDataOnlyNode();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
                SegmentReplicationPressureService.class,
        ensureYellow(INDEX_NAME);
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            Sets.intersection(latestCommitSegments, snapshottedSegments)
            assertNotNull("Replica shard 2 should not be null", replicaShard2);
            .field("term_vector", "with_positions_offsets_payloads")
     * This test validates the primary node drop does not result in shard failure on replica.
            ensureGreen(INDEX_NAME);
    }
            refresh(INDEX_NAME);
        final int initialDocCount = scaledRandomIntBetween(0, 10);
        List<String> nodes = new ArrayList<>();
        assertBusy(
import static org.opensearch.action.search.SearchContextId.decode;
 * SPDX-License-Identifier: Apache-2.0
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    public void testDropPrimaryDuringReplication() throws Exception {
        IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
        ensureGreen(INDEX_NAME);
        assertTrue(temporaryFilesPostClear.containsAll(temporaryFiles));
import java.util.ArrayList;
        // index another doc.
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(false).get();
        createIndex(INDEX_NAME, super.indexSettings());
                replicaNode
                .setId(String.valueOf(i))
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
        logger.info("--> Create scroll query");
        blockFileCopy.countDown();
        final String currentAllocationID = state.routingTable()
        assertEquals(
        // Refresh, this should trigger round of segment replication
        assertTrue(
            "replicaFilesAfterIndexCommitClose {}: {}",
        Directory replicaDirectory = replicaShard.store().directory();
        final Settings settings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build();
        ).get();
                    .indices()
            BackgroundIndexer indexer = new BackgroundIndexer(
        // Get replica allocation id
        nodes.add(primaryNode);
        Directory primaryDirectory = primaryShard.store().directory();
     */
        logger.info("primaryFilesBeforeMerge {}: {}", primaryFilesBeforeMerge.size(), primaryFilesBeforeMerge);
        return randomBoolean() ? INDEX_NAME : "alias";
                        } catch (InterruptedException e) {
package org.opensearch.indices.replication;
            SegmentReplicationPressureService pressureService = internalCluster().getInstance(
            .get();
        refresh(INDEX_NAME);
        }, 60, TimeUnit.SECONDS);
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put("index.refresh_interval", -1).build());
            primaryFilesAfterMerge.stream().anyMatch(s -> s.startsWith("_0"))
        }
     */
            );
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
        final String primaryNode = internalCluster().startDataOnlyNode();
            assertEquals(
        assertTrue(mgetResponse.getResponses()[1].isFailed());
/*
    /**
        long scrollHits = 0;
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
        final int initialDocCount = scaledRandomIntBetween(1, 5);
            indexer.start(additionalDocCount);
        assertBusy(
        // realtime get 1 (preference = _replica)
        ensureGreen(INDEX_NAME);
            )
        if (randomBoolean()) {
        final String id = routingKeyForShard(INDEX_NAME, 0);
            refresh(INDEX_NAME);
public class SegmentReplicationIT extends SegmentReplicationBaseIT {
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
    public void testRealtimeMultiGetRequestsUnsuccessful() {
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));
        logger.info("--> Closing the index ");
                    .setId(Integer.toString(i))
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));
        // index another doc but don't refresh, it should become searchable once the replica is promoted and refreshed there.
        verifyStoreContent();
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
            .getId();
                "_doc",
    private void setup() {
import org.opensearch.core.xcontent.XContentBuilder;
            .actionGet();
                    .startObject("bs")
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
import org.opensearch.index.engine.Engine;
import java.io.IOException;
        });
                .get();
            .endObject()
        final Set<String> snapshottedSegments = new HashSet<>(latestSegmentInfos.files(false));
        // realtime multi get 1 (routing set)
                client().prepareIndex(INDEX_NAME)
        final String id = routingKeyForShard(INDEX_NAME, 0);
            )
        final String replica = internalCluster().startDataOnlyNode();
        GetResponse response = client(replica).prepareGet(indexOrAlias(), "1").get();
            .execute()
            () -> assertEquals(
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        final String routingOtherShard = routingKeyForShard(INDEX_NAME, 1);
        final SearchResponse searchResponse = client().prepareSearch()
                Settings.builder().put("index.refresh_interval", -1).put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
 * compatible open source license.
        GatedCloseable<IndexCommit> replicaIndexCommit = replicaShard.acquireLastIndexCommit(false);
                    .filter(fileName -> fileName.startsWith(REPLICATION_PREFIX))
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")
        assertAcked(
                .put(indexSettings())
        createIndex(INDEX_NAME, settings);
        try (IndexWriter writer = new IndexWriter(replicaShard.store().directory(), iwc)) {
            .setRouting(id)
    /**
        GetResponse response = client().prepareGet(indexOrAlias(), "1").setRealtime(false).get();
        // Wait until replica has written a tmp file to disk.
        );
        XContentBuilder mapping = jsonBuilder().startObject()
            primaryFilesAfterIndexCommitClose.stream().noneMatch(s -> s.startsWith("_0"))
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
            replicaNode
    public void testRealtimeTermVectorRequestsUnSuccessful() throws IOException {
                RandomizedTest.scaledRandomIntBetween(2, 5),
            .setSource("online", true, "bs", "X", "ts", System.currentTimeMillis() - 10000000, "type", "s")
    }
                logger.info("replica receive publish checkpoint request");
                    .collect(Collectors.toList())
import org.opensearch.index.ReplicationStats;
                    .get(replicaShard.shardId())
import org.opensearch.common.util.set.Sets;
        IndexWriterConfig iwc = newIndexWriterConfig().setOpenMode(IndexWriterConfig.OpenMode.APPEND);
        final String routingOtherShard = routingKeyForShard(INDEX_NAME, 1);
        resp = client().prepareTermVectors(indexOrAlias(), Integer.toString(2))
        // generate _0.si
        assertBusy(() -> {
import org.opensearch.action.search.CreatePitAction;
        ) {
        replicaShard.finalizeReplication(segmentInfos);
        );
        TermVectorsRequestBuilder resp = client().prepareTermVectors(indexOrAlias(), Integer.toString(1))
                client(),
import org.opensearch.indices.recovery.FileChunkRequest;
        );
        assertFalse(mgetResponse.getResponses()[1].isFailed());
        assertTrue(replicaShardRouting + " should be promoted as a primary", replicaShardRouting.primary());
        );
            final int additionalDocCount = scaledRandomIntBetween(0, 10);
        logger.info("replicaFilesBeforeMerge {}: {}", replicaFilesBeforeMerge.size(), replicaFilesBeforeMerge);
import org.opensearch.action.search.DeletePitAction;
        primaryIndexCommit.close();
            (connection, requestId, action, request, options) -> {
            waitForSearchableDocs(initialDocCount + 1, dataNodes);
            primaryNode
        final String primaryNode = internalCluster().startDataOnlyNode();
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
                && primaryFilesBeforeMerge.stream().anyMatch(s -> s.startsWith("_1"))
            .setSelectedFields();
        assertBusy(() -> {
                    .endObject()
        AtomicBoolean mockException = new AtomicBoolean(true);
            .setId(String.valueOf(2))
            replicaFilesAfterIndexCommitClose.size(),
        assertBusy(() -> {
                    if (req.name().endsWith("cfs") && req.lastChunk()) {
        final int initialDocCount = scaledRandomIntBetween(1, 10);
        final PitReaderContext pitReaderContext = searchService.getPitReaderContext(
import org.opensearch.action.search.DeletePitRequest;
            .get();
        final String replicaNode = internalCluster().startDataOnlyNode();
        final SearchResponse response = client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get();
            waitForDocs(initialDocCount, indexer);
                    logger.debug("file chunk [{}] lastChunk: {}", req, req.lastChunk());
        final String id = routingKeyForShard(INDEX_NAME, 0);
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        assertThat(fields.size(), equalTo(1));
        }
        final int initialDocCount = 1;
        assertThat(mgetResponse.getResponses()[0].getResponse().getSourceAsMap().get("foo").toString(), equalTo("bar"));
        refresh(INDEX_NAME);
            );
                        .put(indexSettings())
                && primaryFilesAfterIndexCommitClose.stream().anyMatch(s -> s.startsWith("_2"))
            .build();
        // catch up replica with primary
        final String replica = internalCluster().startDataOnlyNode();
import org.apache.lucene.index.IndexWriter;
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
            refresh(INDEX_NAME);
                final Set<SegmentReplicationShardStats> shardStatsSet = replicaNode_service.nodeStats()
        final String replicaAllocationId = state.routingTable()
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(
            .setPayloads(true)
        assertFalse(response.isExists());
                    ((GetSegmentFilesRequest) request).getFilesToFetch().stream().map(StoreFileMetadata::name).collect(Collectors.toList())
                            logger.info("--> Waiting for file copy");
        // Test stats
        primaryShard.flush(new FlushRequest(INDEX_NAME));
                random()
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));
            refresh(INDEX_NAME);
            replica_1.set(replicaShard1);
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime termvectors
        ensureGreen(INDEX_NAME);
        final Set<String> filesAfterClearScroll = Arrays.stream(replicaShard.store().directory().listAll()).collect(Collectors.toSet());
        assertAcked(
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
            .field("analyzer", "tv_test")
            ensureGreen(INDEX_NAME);
            waitForSearchableDocs(expectedHitCount - 1, nodeA, nodeB);
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            () -> assertFalse(
import org.opensearch.action.get.MultiGetResponse;
            assertEquals(
            .setId(String.valueOf(2))
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
        try (
                .indices()
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 2);
        assertTrue(response.isExists());
        assertFalse(response.isExists());
        // index doc 1
                .prepareForceMerge(INDEX_NAME)
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));
        // this test stubs transport calls specific to node-node replication.
            .get();
    }
        final String primary = internalCluster().startDataOnlyNode();
        }
            SegmentReplicationSourceService.class,
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
            scrollHits += searchResponse.getHits().getHits().length;
        assertFalse(mgetResponse.getResponses()[0].isFailed());
            .startObject("field")
                    .field("type", "boolean")
            doc.add(new StringField("id", "" + i, random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
            .endObject()
        mockReplicaReceivePublishCheckpointException.set(false);
                Arrays.stream(replicaShard.store().directory().listAll())
            .addSort("field", SortOrder.ASC)
        );
            )
                && primaryFilesAfterIndexCommitClose.stream().noneMatch(s -> s.startsWith("_1"))
        final IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
                connection.sendRequest(requestId, action, request, options);
            flushAndRefresh(INDEX_NAME);
        assertAcked(
            .setPositions(true)
        ensureGreen(INDEX_NAME);
                .addAlias(new Alias("alias"))
        ensureGreen(INDEX_NAME);
        assertFalse(mgetResponse.getResponses()[0].isFailed());
            .setPreference(Preference.REPLICA.type())
        // Test stats
            pendingIndexResponses.add(
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
                "replica should be promoted as a primary",
            client().prepareIndex(INDEX_NAME)
            .setSource("foo2", "bar2")
        assertBusy(
                "Files should be cleaned up",
        assertFalse(response.isExists());
            .field("type", "text")
                false,
            assertTrue(replicaStats.isEmpty());
        refresh(INDEX_NAME);
            waitForSearchableDocs(initialDocCount, asList(primary, replica));
        for (int i = 0; i < deletedDocCount; i++) {
            snapshottedSegments = infos.files(false);
        // block replication
import org.opensearch.action.termvectors.TermVectorsResponse;
        // Index to create another segment
                client(),
                    throw new RemoteTransportException("mock remote transport exception", new OpenSearchRejectedExecutionException());
            .endObject();
        ensureGreen(INDEX_NAME);
            );
        forceMerge();
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
import org.opensearch.action.admin.indices.flush.FlushRequest;
            .setRouting(id)
                    .setRefreshPolicy(refreshPolicy)
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 1);
                            blockFileCopy.await();
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        ensureYellow(INDEX_NAME);
        ensureYellow(INDEX_NAME);
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
        // create new on-disk segments and copy them out.
            prepareCreate(INDEX_NAME).setMapping(
                random()
        assertTrue(
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        final String replica = internalCluster().startDataOnlyNode();
        // realtime termvectors 1
            .get();
import org.opensearch.test.OpenSearchIntegTestCase;
            .setSource("foo", "bar")
                            blockFileCopy.await();
    private void performReplicationAfterForceMerge(boolean primaryOnly, int expectedSuccessfulShards) throws Exception {
        refresh(INDEX_NAME);
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(6);
    public void testIndexWhileRecoveringReplica() throws Exception {
            temporaryFiles.addAll(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
                && primaryFilesAfterMerge.stream().anyMatch(s -> s.startsWith("_2"))
        final int additionalDocCount = scaledRandomIntBetween(0, 10);
        // new primary should have at least the doc count from the first set of segments.
        response = client(replica).prepareGet(INDEX_NAME, "1").setRouting(routingOtherShard).get();
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        );
                "_doc",
        assertEquals("Store has a positive refCount", 0, replicaShard.store().refCount());
     * @throws Exception when issue is encountered
            // get shard references.
            .setId(Integer.toString(1))
        // Index more documents
        final String primary = internalCluster().startDataOnlyNode();
            refresh(INDEX_NAME);
        assertThat(mgetResponse.getResponses().length, is(2));
            ensureGreen(INDEX_NAME);
import org.opensearch.test.junit.annotations.TestLogging;
        for (int i = 0; i < initialDocCount; i++) {
        final String primary = internalCluster().startDataOnlyNode();
            assertTrue("replica should be promoted as a primary", replicaShard.routingEntry().primary());
    public void testNodeDropWithOngoingReplication() throws Exception {
        // realtime termvectors (with routing set)
                    FileChunkRequest req = (FileChunkRequest) request;
            assertEquals(2, updateResponse.getVersion());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        assertThat(mgetResponse.getResponses()[1].getResponse().getSourceAsMap().get("foo2").toString(), equalTo("bar2"));
        assertThat(mgetResponse.getResponses().length, is(2));
            );
            )
        logger.info("--> Close index");
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), false);
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")
                    logger.debug("file chunk [{}] lastChunk: {}", req, req.lastChunk());
            prepareCreate(INDEX_NAME).setMapping(mapping)
            waitForSearchableDocs(initialDocCount, replicaNode_2);
        );
import org.opensearch.test.InternalTestCluster;
            refresh(INDEX_NAME);
                .get();
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
     * Tests whether segment replication supports realtime get requests and reads and parses source from the translog to serve strong reads.
            .add(new CancelAllocationCommand(INDEX_NAME, indexShard.shardId().id(), primary, true))
            .setSource("online", false, "ts", System.currentTimeMillis() - 100, "type", "bs")
        logger.info("ensure publish checkpoint request can be process");
            .setId(String.valueOf(1))
     */
import org.apache.lucene.util.BytesRef;
            writer.flush();
                            )
     * the new primary starts indexing from the correct maxSeqNo and replays the correct count of docs
                INDEX_NAME,
    }
                assertEquals(1, replicaNode_service.nodeStats().getShardStats().size());
                    Settings.builder()
        final List<String> nodes = new ArrayList<>();
    public void testPrimaryStopped_ReplicaPromoted() throws Exception {
        SegmentInfos latestSegmentInfos = getLatestSegmentInfos(replicaShard);
    }
        assertTrue(
        final String primary = internalCluster().startDataOnlyNode();
            IndexShard replicaShard1 = getIndexShard(replicaNode, INDEX_NAME);
            logger.info("--> temporaryFiles {}", temporaryFiles);
        ensureYellow(INDEX_NAME);
                latch.await();
        response = client().prepareTermVectors(indexOrAlias(), Integer.toString(1)).setRealtime(false).get();
import java.util.Collections;
        client().prepareIndex(INDEX_NAME)
            verifyStoreContent();
            ).addAlias(new Alias("alias"))
                // we want to control refreshes
    private void assertAllocationIdsInReplicaShardStats(Set<String> expected, Set<SegmentReplicationShardStats> replicaStats) {
        Set<String> replicaFilesBeforeMerge = Sets.newHashSet(replicaDirectory.listAll());
            segmentReplicationWithRemoteEnabled()
            waitForDocs(initialDocCount, indexer);
     * the replica will catch up to latest checkpoint once recovery completes without requiring an additional primary refresh/flush.
            // Refresh, this should trigger round of segment replication
        final String primary = internalCluster().startDataOnlyNode();
        logger.info(
        assertAcked(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replica_count)
        logger.info(
        }
import org.opensearch.node.NodeClosedException;
            .setRouting(randomAlphaOfLength(2))
                        } catch (InterruptedException e) {
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        nodes.add(replicaNode);
import org.opensearch.cluster.routing.ShardRoutingState;
        segmentReplicationSourceService.beforeIndexShardClosed(primaryShard.shardId(), primaryShard, indexSettings());
            .setId(String.valueOf(1))
        );
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 3);
                jsonBuilder().startObject()
        TermVectorsResponse response = client().prepareTermVectors(indexOrAlias(), Integer.toString(1)).setRealtime(false).get();
            Collections.emptySet(),
import org.opensearch.index.shard.IndexShard;
        assertHitCount(client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), expectedHitCount);
                )
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime multi get
            .setPreference("_only_local")
        client().prepareIndex(INDEX_NAME)
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
        response = resp.execute().actionGet();
        // non realtime termvectors 1
            client().prepareIndex(INDEX_NAME)
        });
        }
        waitForSearchableDocs(1, primaryNode, replicaNode);
        // realtime multi get 1 (preference = _replica)
        );
            TransportService.class,
            );
                .setMaxNumSegments(1)
        flush(INDEX_NAME);
        cancelDuringReplicaAction(SegmentReplicationSourceService.Actions.GET_CHECKPOINT_INFO);
        }
        // Block file copy operation to ensure replica has few temporary replication files
                client(),
                }
            Set<String> ids = indexer.getIds();
        final int docCount = scaledRandomIntBetween(0, 10);
                new TextField(
                false,
        DiscoveryNode primaryDiscovery = state.nodes().resolveNode(primaryNode);
            .add(new MultiGetRequest.Item(INDEX_NAME, "1"))
        assertAcked(
import org.junit.Before;
        AtomicReference<IndexShard> primary = new AtomicReference<>();
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
        assertTrue(replicaShardRouting + " should be promoted as a primary", replicaShardRouting.primary());
import org.apache.lucene.index.SegmentInfos;
                .setId(String.valueOf(i))
            flush(INDEX_NAME);
                .addAlias(new Alias("alias"))
            .setRealtime(true)
            assertEquals("We should have stats returned for the replication group", 1, shardStats.size());
        createIndex(INDEX_NAME);
            Set<String> ids = indexer.getIds();
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")
        ensureGreen(INDEX_NAME);
                if (mockException.get()) {
        replicaTransportService.clearAllRules();
            .setRequestCache(false)
        for (int i = searchCount; i < searchCount * 2; i++) {
        waitForSegmentCount(INDEX_NAME, 1, logger);
                Settings.builder().put(PublishCheckpointAction.PUBLISH_CHECK_POINT_RETRY_TIMEOUT.getKey(), TimeValue.timeValueMinutes(10))
     */
        final String replica = internalCluster().startDataOnlyNode();
            )
            .startObject("properties")
        waitForSearchableDocs(initialDocCount, replica, primary);
        final String primaryNode = internalCluster().startDataOnlyNode();
    }
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            final int expectedHitCount = initialDocCount + additionalDocCount;
        latch1.await();
        assertThat(mgetResponse.getResponses()[1].getIndex(), is("nonExistingIndex"));
        client(replica).prepareClearScroll().addScrollId(searchResponse.getScrollId()).get();
            assertTrue(replicaNode_service.nodeStats().getShardStats().isEmpty());
            .execute()
        response = resp.execute().actionGet();
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build());
            .build();
            Settings.builder()
            .setFrom(0)
        CountDownLatch startCancellationLatch = new CountDownLatch(1);
        }
            .get();
            PublishCheckpointAction.ACTION_NAME + TransportReplicationAction.REPLICA_ACTION_SUFFIX,
        // create the cluster with one primary node containing primary shard and replica node containing replica shard
        // realtime termvectors 2 with routing
        // randomly flush here after the force merge to wipe any old segments.
        ) {
        assertFalse(mgetResponse.getResponses()[0].getResponse().isExists());
                .setId(String.valueOf(i))
            // fetch pressure stats from the Primary's Node.
                "_doc",
        }
        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest();
                    .field("required", true)
                    Settings.builder()
        resp = client(replica).prepareTermVectors(indexOrAlias(), Integer.toString(1))
                Settings.builder().put("index.refresh_interval", -1).put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            refresh(INDEX_NAME);
            waitForDocs(expectedHitCount, indexer);
        }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        // wait until replication finishes, then make the pit request.
        refresh(INDEX_NAME);
        final String nodeA = internalCluster().startDataOnlyNode();
                replica_1.get().getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        client().prepareIndex(INDEX_NAME)
        final int initialDocCount = scaledRandomIntBetween(1, 10);
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
                        try {
        // wait until a replica is promoted & finishes engine flip, we don't care which one
        verifyStoreContent();
        final SegmentReplicationTargetService targetService = internalCluster().getInstance(
        for (int i = 1; i < 5; i++) {
        assertEquals(1, searchResponse.getSuccessfulShards());
        CountDownLatch latch1 = new CountDownLatch(1);
        assumeFalse(
        final SegmentReplicationSourceService segmentReplicationSourceService = internalCluster().getInstance(
            indexer.start(additionalDocCount);
        ensureGreen(INDEX_NAME);
import org.opensearch.index.store.StoreFileMetadata;
            .setOffsets(true)
        ensureGreen(INDEX_NAME);
            .cluster()
        ensureYellow(INDEX_NAME);
                            waitForFileCopy.countDown();
                -1,
                    }
                        .put(indexSettings())
        ensureGreen(INDEX_NAME);
        MockTransportService replicaTransportService = ((MockTransportService) internalCluster().getInstance(
            SegmentReplicationTargetService.class,
            )
import org.opensearch.action.update.UpdateResponse;
            final String second_replica_aid = secondReplicaShard.routingEntry().allocationId().getId();
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").get();
                client().prepareIndex(INDEX_NAME)
        // add some docs to the xlog and drop primary.
import java.util.concurrent.TimeUnit;
    }
            indexer.start(initialDocCount);
        final String nodeA = internalCluster().startDataOnlyNode();
            );
        CountDownLatch latch = new CountDownLatch(1);
        // start 1st node so that it contains the primary
        createIndex(INDEX_NAME, settings);
        try (
        );
                    .startObject("properties")
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        Settings mockNodeSetting = Settings.builder()
        // multi get non realtime 1
                random()
            prepareCreate(INDEX_NAME).setSettings(
                        .put(indexSettings())
            assertFalse("request shouldn't have forced a refresh", updateResponse.forcedRefresh());
        waitForSearchableDocs(initialDocCount, replica, primary);
