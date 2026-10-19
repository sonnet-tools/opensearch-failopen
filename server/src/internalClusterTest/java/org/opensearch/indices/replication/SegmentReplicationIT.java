import org.opensearch.action.index.IndexResponse;  
            .setPayloads(true)
        assertTrue(replicaShardRouting + " should be promoted as a primary", replicaShardRouting.primary());  
    public void testIndexWhileRecoveringReplica() throws Exception {
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        logger.info("primaryFilesBeforeMerge {}: {}", primaryFilesBeforeMerge.size(), primaryFilesBeforeMerge);  
                .setFlush(false)
                "We should have stats returned for the replication group",  
        ensureGreen(INDEX_NAME);
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 3);  
                RandomizedTest.scaledRandomIntBetween(2, 5),
        ) {
            .actionGet();  
                            blockFileCopy.await();
                        } catch (InterruptedException e) {  
            .allocationId()
            waitForDocs(initialDocCount, indexer);
        }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // catch up replica with primary
        final String primaryNode = internalCluster().startDataOnlyNode();
            Sets.intersection(latestCommitSegments, snapshottedSegments)
            .endObject()
        cancelDuringReplicaAction(SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES);
        assertAcked(client().admin().indices().prepareClose(INDEX_NAME));  
            .setSource("foo2", "bar2")
        final int deletedDocCount = randomIntBetween(1, initialDocCount);
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
                "_doc",
        TermVectorsResponse response = client(replica).prepareTermVectors(indexOrAlias(), "1").get();
                .get();
        assertBusy(() -> assertTrue(client(replica).prepareGet(INDEX_NAME, "2").setRealtime(true).get().isExists()));
        logger.info("--> Opening the index");
            .get();
        assertBusy(() -> {  
        });
            .get();
            replicaFilesBeforeMerge.stream().anyMatch(s -> s.startsWith("_0"))
        ensureGreen(INDEX_NAME);  
import org.opensearch.action.search.CreatePitResponse;  
        XContentBuilder mapping = jsonBuilder().startObject()
    public void testRealtimeMultiGetRequestsSuccessful() {  
        createIndex(INDEX_NAME);  
        assertThat(fields.size(), equalTo(1));  
        client().prepareIndex(INDEX_NAME).setId("3").setSource("foo", "bar").get();  
        );
        }  
            () -> assertEquals(
            .build();
            .endObject();  
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(false).get();  
        assertTrue(response.getHits().getTotalHits().value() >= 1);
            assertEquals(0L, replicationStats.maxBytesBehind);
        SearchResponse resp = client(replica).prepareSearch(INDEX_NAME)
        ensureGreen(INDEX_NAME);
            "Snapshotted files are no longer part of the latest commit",  
                INDEX_NAME,
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));  
        List<String> temporaryFilesPostClear = Arrays.stream(replicaShard.store().directory().listAll())  
import org.opensearch.index.ReplicationStats;  
        );
    public void testPrimaryReceivesDocsDuringReplicaRecovery() throws Exception {
        request.setIndices(new String[] { INDEX_NAME });  
        client().prepareIndex(INDEX_NAME)
        );
        );
            assertEquals(0L, replicationStats.totalBytesBehind);  
                    .endObject()
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);  
    }
public class SegmentReplicationIT extends SegmentReplicationBaseIT {
        );
        final Settings settings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build();
            flush(INDEX_NAME);
            ensureGreen(INDEX_NAME);
        // index doc 1  
        refresh(INDEX_NAME);
        ensureYellow(INDEX_NAME);
        int numDocs = 2 + random().nextInt(10);
            // don't wait for replication to complete, stop the primary immediately.
        GatedCloseable<IndexCommit> replicaIndexCommit = replicaShard.acquireLastIndexCommit(false);
                client(),  
    public void testRealtimeTermVectorRequestsSuccessful() throws IOException {
        AtomicBoolean mockReplicaReceivePublishCheckpointException = new AtomicBoolean(true);  
            waitForDocs(expectedHitCount, indexer);
        resp = client().prepareTermVectors(indexOrAlias(), Integer.toString(2))
        }
            .addSort("field", SortOrder.ASC)  
            }))
            internalCluster().getInstance(TransportService.class, replicaNode),
        final String primary = internalCluster().startDataOnlyNode();
    public void testRealtimeMultiGetRequestsUnsuccessful() {
        logger.info("replica {} acquire last IndexCommit", replicaShard.shardId());  
import java.util.concurrent.CountDownLatch;
        assertDocCounts(docCount, primaryNode);
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
        });  
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        client().prepareIndex(indexOrAlias()).setId("1").setSource("foo", "bar").setRouting(id).get();  
            .setRealtime(false)
            Collections.emptySet(),
    }
            doc.add(
        ) {  
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
import org.apache.lucene.store.Directory;
import static org.opensearch.indices.replication.SegmentReplicationTarget.REPLICATION_PREFIX;
            .add(new CancelAllocationCommand(INDEX_NAME, indexShard.shardId().id(), primary, true))
                    .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))  
    public void testScrollWithConcurrentIndexAndSearch() throws Exception {
                INDEX_NAME,  
        assertEquals(getNodeContainingPrimaryShard().getName(), primary);  
            .setId(Integer.toString(1))
        logger.info("primary {} acquire last IndexCommit", primaryShard.shardId());  
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));  
        );  
                        .put(indexSettings())
            replica_2.set(replicaShard2);  
        logger.info(
                    mockException.set(false);
            .setPreference(Preference.REPLICA.type())  
        refresh(INDEX_NAME);
        ensureYellow(INDEX_NAME);
                assertEquals(1, replicaNode_service.nodeStats().getShardStats().size());  
            .getId();
        assertThat(response.getSourceAsMap().get("foo2").toString(), equalTo("bar2"));
                -1,  
                    .endObject()  
        // start 2nd node so that it contains the replica
        waitForSearchableDocs(initialDocCount, replica, primary);  
        assertFalse(response.isExists());  
            .setId(String.valueOf(1))
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
                .setPrimaryOnly(primaryOnly)
        final Set<String> snapshottedSegments = new HashSet<>(latestSegmentInfos.files(false));  
            assertThat(forceMergeResponse.getSuccessfulShards(), is(expectedSuccessfulShards));
            indexer.start(additionalDocCount);
 *
            assertEquals(  
            .get();
        final String primary = internalCluster().startDataOnlyNode();  
        createIndex(INDEX_NAME, settings);  
                Settings.builder().put("index.refresh_interval", -1).put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
        final int initialDocCount = scaledRandomIntBetween(0, 10);  
        assertTrue(mgetResponse.getResponses()[2].isFailed());  
        CountDownLatch waitForFileCopy = new CountDownLatch(1);
            PublishCheckpointAction.ACTION_NAME + TransportReplicationAction.REPLICA_ACTION_SUFFIX,
        waitForSegmentCount(INDEX_NAME, 1, logger);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                    .field("type", "date")  
            ).addAlias(new Alias("alias"))  
        assertAcked(
        );  
        // verify temporary files still exist
        List<String> currentFiles = List.of(replicaShard.store().directory().listAll());
    }  
            SegmentReplicationTargetService.class,
        IndicesStatsResponse indicesStatsResponse = client().admin().indices().stats(indicesStatsRequest).get();  
            final SegmentInfos infos = standardDirectoryReader.getSegmentInfos();
        final String primary = internalCluster().startDataOnlyNode();  
            indexer.start(initialDocCount);
import org.junit.Before;
            // Index a second set of docs so we can merge into one segment.
                random()  
                .setId(String.valueOf(i))
        );
            .setScroll(TimeValue.timeValueDays(1))
                    FileChunkRequest req = (FileChunkRequest) request;
            (connection, requestId, action, request, options) -> {
        final int initialDocCount = scaledRandomIntBetween(1, 5);  
            .searchAfter(new Object[] { 30 })  
        final String replica = internalCluster().startDataOnlyNode();  
        // expecting failure since we explicitly route request to a shard on which it doesn't exist
        assertEquals(1, scrollHits);
        ));  
                random()  
    }  
            ensureGreen(INDEX_NAME);  
        XContentBuilder mapping = jsonBuilder().startObject()  
    public void testRealtimeGetRequestsSuccessful() {  
            verifyStoreContent();
        latch1.await();
        if (randomBoolean()) {
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
        ensureYellow(INDEX_NAME);  
            assertFalse("request shouldn't have forced a refresh", updateResponse.forcedRefresh());
            .setRouting("Y")
import static org.hamcrest.Matchers.is;
                        }
        ensureGreen(INDEX_NAME);
            .setRouting(id)
                .prepareUpdateSettings(INDEX_NAME)  
        // Block file copy operation to ensure replica has few temporary replication files  
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));  
            assertTrue(replicaStats.isEmpty());
            indexer.start(initialDocCount);  
import org.opensearch.test.InternalTestCluster;
import org.opensearch.index.store.StoreFileMetadata;  
                random()
                    FileChunkRequest req = (FileChunkRequest) request;
    public void testStartReplicaAfterPrimaryIndexesDocs() throws Exception {  
        ).get();
        flushAndRefresh(INDEX_NAME);
            .stream()  
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime get
                assertEquals(0, stats.getCheckpointsBehindCount());
            waitForSearchableDocs(initialDocCount + 1, dataNodes);  
    private void setup() {
                "_doc",
     */  
                        throw new NodeClosedException(primaryDiscovery);  
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        }
            final int additionalDocCount = scaledRandomIntBetween(0, 5);
        response = client(replica).prepareGet(indexOrAlias(), "2").setRouting(id).get();
        SegmentReplicationTarget target = targetService.get(replicaShard.shardId());
        // add some docs to the xlog and drop primary.
        }
        mockReplicaReceivePublishCheckpointException.set(false);
            .get();
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(1));  
                    .startObject("online")
        logger.info("Verify that before merge, primary and replica contain _0.si and _1.si");  
                && replicaFilesAfterIndexCommitClose.stream().anyMatch(s -> s.startsWith("_2"))
            .endObject();
        ) {
            INDEX_NAME,  
        logger.info("replicaFilesAfterMerge {}: {}", replicaFilesAfterMerge.size(), replicaFilesAfterMerge);  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
            pendingIndexResponses.add(  
            // start another replica.
        response = client().prepareTermVectors(indexOrAlias(), Integer.toString(1)).setRealtime(false).get();
            .setPreference("_only_local")
        nodes.add(internalCluster().startDataOnlyNode());
import org.apache.lucene.index.IndexWriterConfig;
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
        });  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
        assertTrue(mgetResponse.getResponses()[1].isFailed());
import org.opensearch.core.index.shard.ShardId;  
                connection.sendRequest(requestId, action, request, options);  
        int initialDocCount = scaledRandomIntBetween(10, 20);  
                false,  
        );
                "_doc",
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
                replicaNode_service.nodeStats().getShardStats().size()
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
                replica_2.get().getLatestReplicationCheckpoint().getSegmentInfosVersion()  
                .put("index.refresh_interval", -1)
    }  
        for (int i = 0; i < deletedDocCount; i++) {  
            .setOffsets(true)
        final String primary = internalCluster().startDataOnlyNode();  
import org.opensearch.test.OpenSearchIntegTestCase;
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        // multi get realtime 1
        assumeFalse(
        ensureGreen(INDEX_NAME);
                    TestUtil.randomRealisticUnicodeString(random()),
                    .endObject()
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {  
            verifyStoreContent();  
        final String id = routingKeyForShard(INDEX_NAME, 0);
        NamedWriteableRegistry registry = internalCluster().getInstance(NamedWriteableRegistry.class, replica);
            doc.add(new StringField("id", "" + i, random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
                .setSource(jsonBuilder().startObject().field("field", i).endObject())  
        FlushRequest flushRequest = Requests.flushRequest(INDEX_NAME);
import org.opensearch.cluster.routing.Preference;  
        // index doc 1  
            .add(new MultiGetRequest.Item(INDEX_NAME, "1"))  
                        .put("index.refresh_interval", -1)
        // realtime multi get 1 (preference = _replica)
            .get();
import org.opensearch.core.xcontent.XContentBuilder;
        assertAcked(  
        assertThat(mgetResponse.getResponses()[0].getResponse().getSourceAsMap().get("foo").toString(), equalTo("bar"));
            client().prepareIndex(INDEX_NAME)
        final String nodeA = internalCluster().startDataOnlyNode();
            .setPositions(true)
            .field("type", "text")
            BackgroundIndexer indexer = new BackgroundIndexer(
            .setId(String.valueOf(0))
                -1,
        refresh(INDEX_NAME);
            .filter(fileName -> fileName.startsWith(REPLICATION_PREFIX))
            replicaStats = replicaNode_service.nodeStats().getShardStats().get(primaryShard.shardId()).getReplicaStats();
                {
        final Settings settings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build();
        waitForSearchableDocs(initialDocCount, replica, primary);  
        final int additionalDocCount = scaledRandomIntBetween(0, 10);
            assertEquals("We should have stats returned for the replication group", 1, shardStats.size());
    /**  
            // index another doc and refresh - without this the new replica won't catch up.
                    .setId(Integer.toString(i))
        assertBusy(() -> {
        // index a doc and trigger replication
        );
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
                -1,
            .setId("2")
            assertEquals(
            prepareCreate(INDEX_NAME).setSettings(
    }
        // this is for testing scroll segment consistency between refresh and flush
        final String routingOtherShard = routingKeyForShard(INDEX_NAME, 1);
            .setQuery(matchAllQuery())
                List.of(replicaShard.store().directory().listAll()).containsAll(snapshottedSegments)
                replicaShard.getLatestReplicationCheckpoint().getSegmentInfosVersion()  
                    Settings.builder()
import org.opensearch.indices.replication.common.ReplicationType;  
            ReplicationStats replicationStats = clusterStatsResponse.getIndicesStats().getSegments().getReplicationStats();  
            );  
                && primaryFilesAfterIndexCommitClose.stream().anyMatch(s -> s.startsWith("_2"))  
            .actionGet();
                final Set<SegmentReplicationShardStats> shardStatsSet = replicaNode_service.nodeStats()
import org.opensearch.index.codec.CodecService;
            );
                && replicaFilesAfterIndexCommitClose.stream().noneMatch(s -> s.startsWith("_1"))  
        // new primary should have at least the doc count from the first set of segments.  
        // index more docs and force merge down to 1 segment  
/*  
        createIndex(INDEX_NAME, super.indexSettings());
            assertTrue(replicaNode_service.nodeStats().getShardStats().isEmpty());
                random()
                            )  
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime termvectors
            ensureGreen(INDEX_NAME);
                    .endObject()  
        // mock network exception
        final String primaryNode = internalCluster().startDataOnlyNode(mockNodeSetting);
            Set<SegmentReplicationShardStats> replicaStats = groupStats.getReplicaStats();
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2))
                .prepareUpdateSettings(INDEX_NAME)
                    .execute()
            .setSource("foo3", "bar3")  
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
                            throw new RuntimeException(e);
        ));  
        DeletePitRequest deletePITRequest = new DeletePitRequest(pitResponse.getId());
            .get();  
import org.opensearch.cluster.node.DiscoveryNode;
                "replica should be promoted as a primary",
        client().prepareIndex(indexOrAlias()).setId("1").setSource("foo", "bar").get();
            .prepareUpdateSettings()
            .setSize(10)
                    logger.debug("file chunk [{}] lastChunk: {}", req, req.lastChunk());  
        createIndex(INDEX_NAME);  
                    .field("format", "epoch_millis")
                        boolQuery().should(
        Set<String> latestCommitSegments = new HashSet<>(replicaShard.store().readLastCommittedSegmentsInfo().files(false));
            .setId(String.valueOf(1))
            // empty.  
            .findFirst()
            .get();
                    }  
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),  
                INDEX_NAME,  
            waitForSearchableDocs(initialDocCount, dataNodes);
            BackgroundIndexer indexer = new BackgroundIndexer(  
        do {
                client(),
                client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replica_count)
        internalCluster().restartNode(primary);
            TransportService.class,
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);  
        primaryShard.flush(new FlushRequest(INDEX_NAME));
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
import org.opensearch.index.engine.Engine;
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));  
            .shardsWithState(ShardRoutingState.STARTED)
            .get();
        AtomicReference<IndexShard> replica_1 = new AtomicReference<>();  
            replicaStats = replicaNode_service.nodeStats().getShardStats().get(replicaShard.shardId()).getReplicaStats();
                            boolQuery().must(rangeQuery("ts").lt(System.currentTimeMillis() - (15 * 1000))).must(termQuery("type", "bs"))
                    .endObject()  
     */  
            indexer.start(initialDocCount);  
        // Index a doc to create the first set of segments. _s1.si
    public void testDropPrimaryDuringReplication() throws Exception {
            final int expectedHitCount = initialDocCount + additionalDocCount;
        verifyStoreContent();  
        ensureYellow(INDEX_NAME);  
        final String replicaAllocationId = state.routingTable()
        final String replica = internalCluster().startDataOnlyNode();
        request.force(true);  
            .setSource("online", true, "bs", "X", "ts", System.currentTimeMillis() - 10000000, "type", "s")
        client().admin().indices().prepareOpen(INDEX_NAME).get();  
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),  
            ClusterStatsResponse clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();
        final String replica = internalCluster().startDataOnlyNode();
                && primaryFilesAfterMerge.stream().anyMatch(s -> s.startsWith("_2"))
                replicaNode_service.nodeStats().getShardStats().size()  
        MockTransportService replicaTransportService = ((MockTransportService) internalCluster().getInstance(  
                    .setId(Integer.toString(i))
            refresh(INDEX_NAME);
        ensureGreen(INDEX_NAME);  
                    random().nextBoolean() ? Field.Store.YES : Field.Store.NO  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            waitForDocs(expectedHitCount, indexer);  
            indexer.start(initialDocCount);  
import org.opensearch.indices.replication.checkpoint.PublishCheckpointAction;
import org.apache.lucene.tests.util.TestUtil;  
        // index another doc.
        assertThat(mgetResponse.getResponses()[2].getIndex(), is("nonExistingIndex"));
                && primaryFilesAfterIndexCommitClose.stream().noneMatch(s -> s.startsWith("_1"))
        ensureGreen(INDEX_NAME);
            .startObject("properties")
    }
            // get shard references.
            .stream()
import org.opensearch.indices.recovery.FileChunkRequest;
        final String routingOtherShard = routingKeyForShard(INDEX_NAME, 1);
                    .field("ignore_malformed", false)
        assertFalse(mgetResponse.getResponses()[0].isFailed());
        assumeFalse(  
        assertBusy(() -> {
            .get();
        String nodeC = internalCluster().startDataOnlyNode();  
                "_doc",
        verifyStoreContent();
        final String primary = internalCluster().startDataOnlyNode();
        } else {  
        assertFalse(response.isExists());
        // generate _0.si
        client().admin().indices().flush(flushRequest).get();
                client().admin()  
        final IndexShard replicaShard = getIndexShard(replica, INDEX_NAME);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;  
            flushAndRefresh(INDEX_NAME);
            final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
        final SearchResponse searchResponse = client().prepareSearch()
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
        for (int i = 0; i < initialDocCount; i++) {
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            }  
        assertFalse(response.isExists());
        // index doc 2
            segmentReplicationWithRemoteEnabled()
        MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(  
            .index(INDEX_NAME)
            .setScroll(TimeValue.timeValueDays(1))
        SearchResponse searchResponse = client(replica).prepareSearch()
        assertFalse(response.isExists());  
                INDEX_NAME,  
            waitForDocs(initialDocCount, indexer);
        final List<String> nodes = new ArrayList<>();
        ensureGreen(INDEX_NAME);
                    .setSource("field", "value" + i)  
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);  
            }
        // force merge and flush.
    }  
        // Clear scroll query, this should clean up files on replica
            .setId(Integer.toString(1))  
        ensureGreen(INDEX_NAME);
            indexer.start(initialDocCount);
        final String id = routingKeyForShard(INDEX_NAME, 0);
                handler.messageReceived(request, channel, task);  
            );  
                    if (req.name().endsWith("cfs") && req.lastChunk()) {
        waitForSearchableDocs(initialDocCount, replica, primary);
import org.opensearch.action.support.WriteRequest;  
import org.opensearch.index.engine.EngineConfig;  
        int expectedMaxSeqNo = initialDocCount + deletedDocCount + additionalDocs - 1;
                    logger.info("mock remote transport exception");
        ensureYellow(INDEX_NAME);
            assertThat(forceMergeResponse.getFailedShards(), is(0));  
                    .startObject("ts")
            refresh(INDEX_NAME);
     * from xlog.  
    public void testRestartPrimary() throws Exception {
                false,
        ensureGreen(INDEX_NAME);  
            waitForDocs(expectedHitCount, indexer);
        for (int i = searchCount; i < searchCount * 2; i++) {
        assertTrue("Files should be preserved", currentFiles.containsAll(snapshottedSegments));
            .add(new MultiGetRequest.Item(INDEX_NAME, "1"))  
        assertThat(response.getIndex(), equalTo(INDEX_NAME));  
        final String replica = internalCluster().startDataOnlyNode();
            assertSearchHits(client(primary).prepareSearch(INDEX_NAME).setQuery(matchQuery("foo", "baz")).get(), id);
        assertFalse(mgetResponse.getResponses()[0].getResponse().isExists());
                random()  
        assertEquals(getNodeContainingPrimaryShard().getName(), replica);
        AtomicReference<IndexShard> primary = new AtomicReference<>();  
import org.apache.lucene.document.StringField;  
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
        segmentReplicationSourceService.beforeIndexShardClosed(primaryShard.shardId(), primaryShard, indexSettings());  
            .put(indexSettings())
            replicaFilesAfterIndexCommitClose
        }  
            client().admin()  
import org.opensearch.core.common.breaker.CircuitBreakingException;  
        assertTrue(mgetResponse.getResponses()[1].isFailed());
        createIndex(INDEX_NAME);
        Settings mockNodeSetting = Settings.builder()
            .setSource("foo", "bar")
        // realtime termvectors (with routing set)
            Document doc = new Document();  
        }
        createIndex(INDEX_NAME);  
            .setOffsets(true)
        FlushRequest request = new FlushRequest(INDEX_NAME);
        // index doc 2 with routing
            () -> assertFalse(
        final PitReaderContext pitReaderContext = searchService.getPitReaderContext(  
            .setRouting(routingOtherShard)
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(false).get();  
                        }  
                    throw new RemoteTransportException("mock remote transport exception", new OpenSearchRejectedExecutionException());  
        refresh(INDEX_NAME);
        final IndexShard replicaShard = getIndexShard(replica, INDEX_NAME);  
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();  
        ensureGreen(INDEX_NAME);
            .setRequestCache(false)
            refresh(INDEX_NAME);
     */  
                    .field("type", "boolean")  
        blockFileCopy.countDown();  
        client().admin()
        client().prepareIndex(INDEX_NAME)
                && replicaFilesAfterMerge.stream().anyMatch(s -> s.startsWith("_1"))  
        assertThat(mgetResponse.getResponses().length, is(2));
        final String primary = internalCluster().startDataOnlyNode();  
                -1,
        createIndex(INDEX_NAME);
            TransportService.class,
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        final IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
        final int initialDocCount = 1;
            refresh(INDEX_NAME);
        createIndex(INDEX_NAME);  
        ensureGreen(INDEX_NAME);  
        client().prepareIndex(INDEX_NAME).setId("2").setSource("foo", "bar").get();  
        latch.countDown();  
            // start another replica.
        assertEquals(
        ensureGreen(INDEX_NAME);  
        final int searchCount = randomIntBetween(1, 2);
        final String replicaNode = internalCluster().startDataOnlyNode();
        assertFalse(response.isExists());
            indexer.start(initialDocCount);  
        final String replicaNode2 = internalCluster().startDataOnlyNode();
                    ((GetSegmentFilesRequest) request).getFilesToFetch().stream().map(StoreFileMetadata::name).collect(Collectors.toList())
import static org.opensearch.index.query.QueryBuilders.termQuery;  
                .setDoc(Requests.INDEX_CONTENT_TYPE, "foo", "baz")
        try (  
import org.opensearch.search.SearchService;
                client(),
     * Tests a scroll query on the replica
        client().prepareIndex(INDEX_NAME).setId(String.valueOf(expectedMaxSeqNo + 1)).setSource("another", "doc").get();  
            assertTrue("replica should be promoted as a primary", replicaShard.routingEntry().primary());
        assertHitCount(client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 3);  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import java.util.List;
        refresh(INDEX_NAME);  
        // delete the PIT
                .indices()  
        final IndexShard indexShard = getIndexShard(primary, INDEX_NAME);  
            Set<String> ids = indexer.getIds();
import org.opensearch.cluster.routing.ShardRoutingState;
                latch2.countDown();  
            waitForDocs(expectedHitCount, indexer);
        );  
        // non realtime termvectors 1  
        assertThat(mgetResponse.getResponses().length, is(2));
 * The OpenSearch Contributors require contributions made to  
                .indices()
}  
        assertEquals(
                Arrays.stream(replicaShard.store().directory().listAll())  
        });
            .prepareReroute()  
            .collect(Collectors.toList());
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
                "_doc",
                random()
            prepareCreate(INDEX_NAME).setMapping(mapping)
        client(replica).prepareClearScroll().addScrollId(searchResponse.getScrollId()).get();  
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            primaryNode  
        final String primaryNode = internalCluster().startDataOnlyNode();  
        verifyStoreContent();
            .execute()  
            indexer.start(initialDocCount);
    }
        assertThat(fields.size(), equalTo(1));  
        final String replica = internalCluster().startDataOnlyNode();
        response = resp.execute().actionGet();
        // multi get non realtime 1
            ensureYellow(INDEX_NAME);
     */
            client().prepareIndex(INDEX_NAME).setId(docId).setSource("foo", "bar").get();  
        final String replica = internalCluster().startDataOnlyNode();
        // replica now promoted as primary should have same allocation id
                .setMaxNumSegments(1)  
                .put(indexSettings())
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
                    .must(  
            .get();
        // generate _1.si  
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
        assertTrue("Files should be preserved", filesBeforeClearScroll.containsAll(snapshottedSegments));  
            .endObject()  
            .setSize(10)
        for (int i = 1; i < 5; i++) {
        assertBusy(
        client().prepareIndex(INDEX_NAME)  
        assertBusy(
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")
            prepareCreate(INDEX_NAME).setMapping(
    }  
        AtomicReference<IndexShard> replica_2 = new AtomicReference<>();
    public void testReplicaHasDiffFilesThanPrimary() throws Exception {  
            .setRouting("X")  
        flushAndRefresh(INDEX_NAME);
        }
        TermVectorsResponse response = client().prepareTermVectors(indexOrAlias(), Integer.toString(1)).setRealtime(false).get();
        CountDownLatch latch = new CountDownLatch(1);
        ensureYellow(INDEX_NAME);
                new TextField(  
                    logger.debug("file chunk [{}] lastChunk: {}", req, req.lastChunk());  
            .setId("3")
            .setPayloads(true)  
        for (int i = 0; i < docCount; i++) {
            .setOffsets(true)
        blockFileCopy.countDown();  
            );  
                            blockFileCopy.await();
                    .prepareUpdateSettings(INDEX_NAME)
                false,  
        // wait for segrep to start and copy temporary files  
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")
            dataNodes.add(internalCluster().startDataOnlyNode());  
            prepareCreate(INDEX_NAME).setSettings(
        // index doc 1
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
            BackgroundIndexer indexer = new BackgroundIndexer(
        // index a doc.  
            temporaryFiles.addAll(
        Collection<String> snapshottedSegments;  
                    .startObject("bs")
                .setId(String.valueOf(i))  
        ) {
        // stop the replica, this will do additional checks on shutDown to ensure the replica and its store are closed properly
import org.opensearch.action.search.DeletePitRequest;
            "Skipping the test as its not compatible with segment replication with remote store.",
        waitForSearchableDocs(1, primary, replica);
                flush(INDEX_NAME);  
            final int expectedHitCount = initialDocCount + additionalDocCount;  
        assertThat(response.getSourceAsMap().get("foo").toString(), equalTo("bar"));
        createIndex(INDEX_NAME);
            assertAllSuccessful(searchResponse);
    public void testPressureServiceStats() throws Exception {
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))  
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
        ensureGreen(INDEX_NAME);  
            logger.info("--> temporaryFiles {}", temporaryFiles);
                jsonBuilder().startObject()  
            waitForDocs(initialDocCount, indexer);
        createIndex(INDEX_NAME);
        assertAcked(
        );
        final Settings settings = Settings.builder()  
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        primary.get().flush(request);
import org.opensearch.common.action.ActionFuture;
        ensureGreen(INDEX_NAME);
            flush(INDEX_NAME);
        createIndex(INDEX_NAME, settings);  
        refresh(INDEX_NAME);  
import org.apache.lucene.document.Field;
                    .setRefreshPolicy(refreshPolicy)
        replicaTransportService.addRequestHandlingBehavior(
        waitForSearchableDocs(initialDocCount, primary, replica);  
        latch.countDown();
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        nodes.add(replicaNode);
import org.opensearch.action.get.GetResponse;  
        final String primaryNode = internalCluster().startDataOnlyNode();
            .get();
    public void testReplicationAfterForceMergeOnPrimaryShardsOnly() throws Exception {
        // generate _1.si
            )
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()  
                "Files should be cleaned up",  
        waitForSearchableDocs(2, primaryNode, replicaNode);
                } else {  
    }
            .startObject("field")
        for (int i = 0; i < docCount; i++) {
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").get();
            waitForSearchableDocs(initialDocCount, asList(primary, replica));  
                RandomizedTest.scaledRandomIntBetween(2, 5),
            .setSize(100)
        final String primary = internalCluster().startDataOnlyNode();
            assertTrue(
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build());
        assertTrue(  
import org.opensearch.action.get.MultiGetResponse;
        final String primaryNode = internalCluster().startDataOnlyNode();
            // update to add replica, initiating recovery, this will get stuck at last step
        final String nodeA = internalCluster().startDataOnlyNode();
        nodes.add(internalCluster().startDataOnlyNode());
        ensureGreen(INDEX_NAME);  
            .setSize(10)  
        assertBusy(() -> {  
        try (
            )
            .setPositions(true)  
                .get();
                    if (req.name().endsWith("cfs") && req.lastChunk()) {  
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);  
            Settings.builder()
                client(),  
            assertAllocationIdsInReplicaShardStats(Set.of(replicaShard.routingEntry().allocationId().getId()), replicaStats);  
        assertBusy(() -> {
        }  
        final String primaryNode = internalCluster().startDataOnlyNode();
        try (IndexWriter writer = new IndexWriter(replicaShard.store().directory(), iwc)) {
        verifyStoreContent();  
            .endObject()
        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest();  
        final String replica = internalCluster().startDataOnlyNode();  
            .setRouting(randomAlphaOfLength(2))
                    .filter(fileName -> fileName.startsWith(REPLICATION_PREFIX))
                            .should(
        final SegmentReplicationSourceService segmentReplicationSourceService = internalCluster().getInstance(
import org.opensearch.common.settings.Settings;
                .setSettings(
import org.opensearch.cluster.ClusterState;
            }
        DiscoveryNode primaryDiscovery = state.nodes().resolveNode(primaryNode);
            .get();  
import org.opensearch.cluster.routing.ShardRouting;
        for (int i = 0; i < initialDocCount; i++) {
                    .endObject()
                }
    }
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();  
        Set<String> replicaFilesAfterMerge = Sets.newHashSet(replicaDirectory.listAll());
        // generate _0.si  
                INDEX_NAME,  
    /**
            .field("term_vector", "with_positions_offsets_payloads")
        ensureGreen(INDEX_NAME);
            waitForDocs(initialDocCount, indexer);
        assertNotNull(replicaShardRouting);  
            .get();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    /**  
        final String id = routingKeyForShard(INDEX_NAME, 0);
        // create the cluster with one primary node containing primary shard and replica node containing replica shard  
            ).addAlias(new Alias("alias"))  
        assertFalse(response.isExists());
            .setIndices(INDEX_NAME)
        );
        IndexWriterConfig iwc = newIndexWriterConfig().setOpenMode(IndexWriterConfig.OpenMode.APPEND);
            // Perform force merge only on the primary shards.
        // start a replica node, initially will be empty with no shard assignment.
                .build()
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        final int docCount = scaledRandomIntBetween(0, 10);
            final StandardDirectoryReader standardDirectoryReader = NRTReplicationReaderManager.unwrapStandardReader(
            .setId("4")  
        // realtime get 1
     * This tests that if a primary receives docs while a replica is performing round of segrep during recovery
        internalCluster().restartNode(primary);
            replicaFilesAfterIndexCommitClose.size(),
        assertFalse(mgetResponse.getResponses()[0].isFailed());
                random()
        assertNoFailures(response);
        assertBusy(() -> {
        final String nodeB = internalCluster().startDataOnlyNode();
            assertNotNull("Replica shard 2 should not be null", replicaShard2);  
    }
        CountDownLatch blockFileCopy = new CountDownLatch(1);
        );
        );
            .get();
            client().prepareIndex(INDEX_NAME).setId("2").setSource("foo2", randomInt()).get();
        // deleted.  
            .put(PublishCheckpointAction.PUBLISH_CHECK_POINT_RETRY_TIMEOUT.getKey(), TimeValue.timeValueSeconds(0))
            assertEquals(2, updateResponse.getVersion());  
        ensureGreen(INDEX_NAME);
            primaryFilesAfterMerge.stream().anyMatch(s -> s.startsWith("_0"))  
import org.opensearch.cluster.health.ClusterHealthStatus;  
            Settings.builder()
        GatedCloseable<IndexCommit> primaryIndexCommit = primaryShard.acquireLastIndexCommit(false);
                        )  
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
        final String replicaNode = internalCluster().startDataOnlyNode();  
            assertEquals(0L, replicationStats.maxReplicationLag);
                            logger.info("--> Waiting for file copy");
        createIndex(INDEX_NAME);
                        } catch (InterruptedException e) {
        refresh(INDEX_NAME);
import org.opensearch.search.internal.PitReaderContext;
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            logger.info("former primary aid {}", primaryShard.routingEntry().allocationId());
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), false);
        assertTrue(replicaShardRouting + " should be promoted as a primary", replicaShardRouting.primary());
            indexer.start(additionalDocCount);  
            .index(INDEX_NAME)  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", randomInt()).get();  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
        assertSegments(false, INDEX_NAME, 1, client(replica), pitResponse.getId());
            );
                .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)  
        // Test stats
        final String primary = internalCluster().startDataOnlyNode();
import org.opensearch.action.termvectors.TermVectorsResponse;  
        mgetResponse = client(replica).prepareMultiGet()
            // Refresh, this should trigger round of segment replication
        primaryTransportService.addRequestHandlingBehavior(actionToblock, (handler, request, channel, task) -> {
        final String primaryNode = internalCluster().startDataOnlyNode();
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        client().prepareIndex(INDEX_NAME).setId("2").setSource("bar", "baz").setRefreshPolicy(WriteRequest.RefreshPolicy.NONE).get();
            // fetch pressure stats from the Primary's Node.
            primary
            .setRequestCache(false)
                && replicaFilesBeforeMerge.stream().anyMatch(s -> s.startsWith("_1"))
        createIndex(INDEX_NAME, settings);  
    }  
        logger.info("Verify that after merge, primary and replica contain _0.si, _1.si and _2.si");
    }
        // index doc 2
                replica_1.get().getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        createIndex(INDEX_NAME);  
            // Fetch pressure stats from the Replica's Node we will assert replica node returns nothing until it is promoted.
            refresh(INDEX_NAME);
        // create a doc to index
        refresh(INDEX_NAME);  
            .setRequestCache(false)  
        assertEquals("Replication not closed: " + target.getId(), 0, target.refCount());
        final String id = routingKeyForShard(INDEX_NAME, 0);  
            BackgroundIndexer indexer = new BackgroundIndexer(
            indexer.start(initialDocCount);  
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")
        final String primary = internalCluster().startDataOnlyNode();
        assertAcked(  
        TermVectorsRequestBuilder resp = client().prepareTermVectors(indexOrAlias(), Integer.toString(1))
            .setId(String.valueOf(2))  
import java.util.Map;
        final String primaryNode = internalCluster().startDataOnlyNode();  
            primaryFilesAfterIndexCommitClose.size(),  
            final int additionalDocCount = scaledRandomIntBetween(0, 10);
            )
    }
        // Test stats
                replicaNode
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
        try (
            .setId(String.valueOf(3))
        }
        final String nodeB = internalCluster().startDataOnlyNode();  
        }  
            .startObject("properties")
        assertThat(mgetResponse.getResponses()[1].getIndex(), is("nonExistingIndex"));  
        assertThat(mgetResponse.getResponses()[1].getResponse().getSourceAsMap().get("foo2").toString(), equalTo("bar2"));  
                false,
        CountDownLatch blockFileCopy = new CountDownLatch(1);
        // wait for replica to catch up and verify doc count
            .setScroll(TimeValue.timeValueDays(1))  
        try (
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
        assertFalse(response.isExists());
                .put("index.refresh_interval", -1)  
import org.opensearch.index.engine.NRTReplicationReaderManager;
        final SearchResponse response = client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get();
        client().prepareIndex(INDEX_NAME)  
            waitForDocs(initialDocCount, indexer);
            .get();
    public void testIndexReopenClose() throws Exception {  
            "primaryFilesAfterIndexCommitClose {}: {}",
import org.apache.lucene.index.IndexCommit;  
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
        ensureGreen(INDEX_NAME);
    }
                "_doc",  
        });  
        waitForSearchableDocs(initialDocCount, replica, primary);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            // test a checkpoint without any new segments  
        );
            client(nodeA).prepareDelete(INDEX_NAME, id).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            .setSource(jsonBuilder().startObject().field("field", 0).endObject())  
            assertBusy(() -> {
        TermVectorsRequestBuilder resp = client(replica).prepareTermVectors(indexOrAlias(), Integer.toString(1))
            .get();  
            .setSource("online", false, "bs", "Y", "ts", System.currentTimeMillis() - 100, "type", "s")
            prepareCreate(INDEX_NAME).setMapping(mapping)  
     * the replica will catch up to latest checkpoint once recovery completes without requiring an additional primary refresh/flush.
                    ((GetSegmentFilesRequest) request).getReplicationId(),
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(
        );  
            // drop the primary, this won't hand off pressure stats between old/new primary.
        final int initialDocCount = scaledRandomIntBetween(1, 10);
        // Reproduce the case where the replica shard cannot synchronize data from the primary shard when there is a network exception.  
        ensureGreen(INDEX_NAME);
        assertHitCount(client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), expectedHitCount + 1);
            .setQuery(matchAllQuery())  
        assertThat(mgetResponse.getResponses().length, is(3));
            replica_1.set(replicaShard1);
        // index doc 1
        long openContexts = indicesStatsResponse.getIndex(INDEX_NAME).getTotal().search.getOpenContexts();
        assertFalse(response.isExists());
            .add(new MultiGetRequest.Item(INDEX_NAME, "2").routing(id))
                logger.info(
        Directory replicaDirectory = replicaShard.store().directory();  
            final int expectedHitCount = initialDocCount + additionalDocCount;  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
        final String nodeB = internalCluster().startDataOnlyNode();  
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
        refresh(INDEX_NAME);  
        assertBusy(() -> {
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
            .setPositions(true)
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
    }
        MultiGetResponse mgetResponse = client(replica).prepareMultiGet()  
            String id = ids.toArray()[0].toString();  
            .setQuery(
        // wait until a replica is promoted & finishes engine flip, we don't care which one
            TransportService.class,  
                client(),
            .setVersion(true)  
        final String replicaNode = internalCluster().startDataOnlyNode();
        final String replica = internalCluster().startDataOnlyNode();  
        // Flush segments to disk and create a new commit point (Primary: segments_3, _s1.si)
            segmentReplicationWithRemoteEnabled()
        ));  
            client().prepareIndex(INDEX_NAME)  
        final String primary = internalCluster().startDataOnlyNode();
        final String primary = internalCluster().startDataOnlyNode();
package org.opensearch.indices.replication;
        flush(INDEX_NAME);
        logger.info("--> temporaryFilesPostClear {}", temporaryFilesPostClear);  
        long pitCurrent = indicesStatsResponse.getIndex(INDEX_NAME).getTotal().search.getTotal().getPitCurrent();
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
    }
            waitForDocs(docCount, indexer);
        final String nodeA = internalCluster().startDataOnlyNode();
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
            verifyStoreContent();
            );
        assertAcked(
import org.opensearch.index.SegmentReplicationPerGroupStats;
        final int initialDocCount = scaledRandomIntBetween(0, 10);  
        logger.info("--> Collect all scroll query hits");  
import java.util.concurrent.atomic.AtomicBoolean;  
            primaryFilesAfterIndexCommitClose.stream().noneMatch(s -> s.startsWith("_0"))
        client().prepareIndex(indexOrAlias()).setId("1").setSource("foo", "bar").setRouting(id).get();
        for (int i = 0; i < 10; i++) {
        replicaShard.finalizeReplication(segmentInfos);
        );
        client().prepareIndex(INDEX_NAME).setId("4").setSource("baz", "baz").get();
            .get()
            TransportService.class,
            )
                handler.messageReceived(request, channel, task);
        assertEquals(1, pitCurrent);  
            String id = ids.toArray()[0].toString();  
        // wait until replication finishes, then make the pit request.  
        List<String> temporaryFiles = new ArrayList<>();
     * the new primary starts indexing from the correct maxSeqNo and replays the correct count of docs
import org.opensearch.action.admin.indices.flush.FlushRequest;
            );
        try (
        client().prepareIndex(INDEX_NAME)
        );  
                1,
        assertAcked(  
            assertTrue(pendingSearchResponse.stream().allMatch(ActionFuture::isDone));
        }
        waitForSearchableDocs(1, primaryNode, replicaNode);  
                SegmentReplicationPressureService.class,  
                    .setRefreshPolicy(refreshPolicy)  
                    .indices()
            TransportService.class,
        final String primary = internalCluster().startDataOnlyNode();  
                false,
    public void testCancellationDuringGetSegments() throws Exception {  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        client().admin().indices().prepareClose(INDEX_NAME).get();  
        });
            .setRouting(id)
        }  
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
    }
            .setSelectedFields();
    public void testLocalSegmentReplicationWithException() throws Exception {
        internalCluster().startClusterManagerOnlyNode();  
        ));
            flush(INDEX_NAME);
        for (int i = 0; i < searchCount; i++) {
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
     */
        assertThat("doc id: " + 1 + " doesn't exists but should", response.isExists(), equalTo(true));
    public void testUpdateOperations() throws Exception {
                    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)  
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
                    throw new CircuitBreakingException("mock circuit break exception", CircuitBreaker.Durability.TRANSIENT);
import com.carrotsearch.randomizedtesting.RandomizedTest;
        // non realtime get 1  
                client(),  
            .searchAfter(new Object[] { 30 })
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
            .put(super.indexSettings())
                    handler.messageReceived(request, channel, task);
        );
    /**
                .indices()
                -1,
                false,
import org.opensearch.common.lease.Releasable;  
        // generate _2.si
            .add(new MultiGetRequest.Item(INDEX_NAME, "1").routing(routingOtherShard))
    public void testCancelPrimaryAllocation() throws Exception {  
            primaryNode
            for (Document d : docs) {
            } catch (InterruptedException e) {  
                Settings.builder().put("index.refresh_interval", -1).put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            .setPreference(Preference.REPLICA.type())
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", randomInt()).get();
    public void testMultipleShards() throws Exception {  
                logger.info("replica receive publish checkpoint request");
            replicaFilesAfterIndexCommitClose.stream().noneMatch(s -> s.startsWith("_0"))
        refresh(INDEX_NAME);
            );  
            );
            .setId("3")
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
    public void testReplicationAfterPrimaryRefreshAndFlush() throws Exception {
        client(replica).prepareIndex(INDEX_NAME)
        // start a replica node, initially will be empty with no shard assignment.
        ));
        // Index more documents
                .setId(String.valueOf(i))
    /**  
        PitTestsUtil.assertUsingGetAllPits(client(replica), pitResponse.getId(), pitResponse.getCreationTime(), TimeValue.timeValueDays(1));
            // verify replica contains temporary files
        primaryTransportService.addSendBehavior(
        }
            .cluster()
                    .execute()
            IndexShard replicaShard1 = getIndexShard(replicaNode, INDEX_NAME);
        client().prepareIndex(INDEX_NAME)
        assertBusy(
            .setRouting(id)  
        primaryTransportService.addSendBehavior(  
        }
import org.opensearch.transport.RemoteTransportException;
            .setIndices(INDEX_NAME)
                "_doc",
            );
            .setPositions(true)
            (handler, request, channel, task) -> {  
            waitForSearchableDocs(expectedHitCount - 1, nodeA, nodeB);
        );
        assertThat(mgetResponse.getResponses()[1].getIndex(), is(INDEX_NAME));
    }
        int initialDocCount = scaledRandomIntBetween(5, 10);
        // non realtime termvectors 1  
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;  
                .get();
            .setPreference("_only_local")
        client().prepareIndex(INDEX_NAME).setId("2").setSource("foo2", "bar2").setRouting(id).get();
                client().prepareIndex(INDEX_NAME)
        // make sure doc 2 is on the replica realtime GET reads from translog, not search
            }
        Directory primaryDirectory = primaryShard.store().directory();
        final String replica = internalCluster().startDataOnlyNode();
        ensureGreen(INDEX_NAME);
            .setRealtime(true)  
            .get()  
        // non realtime get 1  
import org.opensearch.action.search.CreatePitAction;
        }, 60, TimeUnit.SECONDS);  
                && primaryFilesBeforeMerge.stream().anyMatch(s -> s.startsWith("_1"))  
            .addSort("foo", SortOrder.ASC)
                replica_1.get().routingEntry().primary() || replica_2.get().routingEntry().primary()  
            .build();
            .allocationId()  
        GetResponse response = client(replica).prepareGet(indexOrAlias(), "1").get();  
        performReplicationAfterForceMerge(false, SHARD_COUNT * (1 + REPLICA_COUNT));
     * @throws Exception when issue is encountered  
        Set<String> primaryFilesAfterIndexCommitClose = Sets.newHashSet(primaryDirectory.listAll());  
                logger.info("replica receive publish checkpoint request");
        // Unblock segment replication
            refresh(INDEX_NAME);
        logger.info("replicaFilesBeforeMerge {}: {}", replicaFilesBeforeMerge.size(), replicaFilesBeforeMerge);
        ).get();
            )  
import org.opensearch.action.admin.indices.alias.Alias;  
                -1,  
        waitForSearchableDocs(1, primaryNode, replicaNode, replicaNode2);
                boolQuery().must(termQuery("online", true))
                client(),
        assertThat("doc id: " + 1 + " doesn't exists but should", response.isExists(), equalTo(true));
        refresh(INDEX_NAME);
        indicesStatsRequest.indices(INDEX_NAME);
            scrollHits += searchResponse.getHits().getHits().length;  
            INDEX_NAME,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            (connection, requestId, action, request, options) -> {  
        );
        assertTrue(
                            waitForFileCopy.countDown();  
                RandomizedTest.scaledRandomIntBetween(2, 5),
            .shardsWithState(ShardRoutingState.STARTED)
            SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES,  
        }
        waitForRelocation(ClusterHealthStatus.GREEN);  
            client().admin()
        // create new on-disk segments and copy them out.
        Set<String> primaryFilesBeforeMerge = Sets.newHashSet(primaryDirectory.listAll());
        refresh();
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),  
                    .collect(Collectors.toList())
                connection.sendRequest(requestId, action, request, options);
        client().prepareIndex(INDEX_NAME)
        ensureGreen(INDEX_NAME);
                        .put("index.refresh_interval", -1)  
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 2);  
        // index doc 1
        CountDownLatch startCancellationLatch = new CountDownLatch(1);  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;  
        // there should be no active readers, snapshots, or on-disk commits containing the snapshotted files, check that they have been
                    .startObject("properties")
        assertEquals("Store has a positive refCount", 0, replicaShard.store().refCount());  
                .prepareUpdateSettings(INDEX_NAME)  
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testReplicaAlreadyAtCheckpoint() throws Exception {
            assertEquals(  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));
                .setId(String.valueOf(i))
        final WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());  
     */
            assertTrue(temporaryFiles.size() > 0);
        assertAcked(  
        forceMerge();
            replicaNode
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 3);
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put("index.refresh_interval", -1).build());
                "We should have stats returned for the replication group",
        }, 1, TimeUnit.MINUTES);  
        final int initialDocCount = scaledRandomIntBetween(1, 5);  
import org.opensearch.action.support.replication.TransportReplicationAction;
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
    }
import java.util.HashSet;  
        }  
        final String primaryNode = internalCluster().startDataOnlyNode();
            .endObject()
            .add(new MultiGetRequest.Item(INDEX_NAME, "1"))
    public void testReplicationAfterForceMerge() throws Exception {
            waitForSearchableDocs(initialDocCount, replicaNode_2);  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                .setSettings(
        // Drop the primary and wait until replica is promoted.  
                }
        cancelDuringReplicaAction(SegmentReplicationSourceService.Actions.GET_CHECKPOINT_INFO);  
        final String replicaNode = internalCluster().startDataOnlyNode();  
        // Index to create another segment
            )
                    logger.debug("file chunk [{}] lastChunk: {}", req, req.lastChunk());
            assertSearchHits(client(replica).prepareSearch(INDEX_NAME).setQuery(matchQuery("foo", "baz")).get(), id);  
            final SegmentReplicationShardStats replica_entry = replicaStats.stream().findFirst().get();  
        final int initialDocCount = 1;
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        waitForFileCopy.await();
        IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
        });
        final String primary = internalCluster().startDataOnlyNode();
        final String routingOtherShard = routingKeyForShard(INDEX_NAME, 1);  
                random()  
        final IndexShard replicaShard = getIndexShard(replica, INDEX_NAME);
import org.apache.lucene.document.TextField;
        assertBusy(() -> { assertDocCounts(docCount, replicaNode); });  
        replicaShard.flush(new FlushRequest(INDEX_NAME));  
            .setId(String.valueOf(2))
        // this test stubs transport calls specific to node-node replication.
            .execute()
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))  
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);  
        } while (searchResponse.getHits().getHits().length > 0);  
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
import org.opensearch.action.search.PitTestsUtil;  
    }  
            () -> assertEquals(
            verifyStoreContent();  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        CreatePitResponse pitResponse = execute.get();
        try (
     * @throws Exception when issue is encountered
            .get();  
        // block replication
     * This test verifies that segment replication does not fail for closed indices
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
        assertTrue(response.isExists());  
        waitForSearchableDocs(3, primaryNode, replicaNode);
            client().prepareIndex(INDEX_NAME)
        final String primary = internalCluster().startDataOnlyNode();
    }  
        createIndex(INDEX_NAME);
        );  
            flush(INDEX_NAME);
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        SearchResponse response = client().prepareSearch(INDEX_NAME)
        // force call flush
        MultiGetResponse mgetResponse = client().prepareMultiGet()
        assertAcked(
        assertHitCount(client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), expectedHitCount);  
    public void testDeleteOperations() throws Exception {  
    }
import org.opensearch.action.get.MultiGetRequest;
        primaryIndexCommit.close();
        client().execute(DeletePitAction.INSTANCE, deletePITRequest).actionGet();  
                "_doc",
            );  
            .get();  
            (handler, request, channel, task) -> {  
        SearchResponse searchResponse = client(replica).prepareSearch(INDEX_NAME)  
            .setRealtime(true)
        GetResponse response = client().prepareGet(indexOrAlias(), "1").setRealtime(false).get();
        try (
                        } catch (InterruptedException e) {  
        );
                RandomizedTest.scaledRandomIntBetween(2, 5),
        response = client().prepareGet(indexOrAlias(), "1").setRealtime(false).get();
                .indices()
            .execute()  
                && replicaFilesAfterMerge.stream().anyMatch(s -> s.startsWith("_2"))
import org.opensearch.common.concurrent.GatedCloseable;
            waitForDocs(expectedHitCount, indexer);
                if (mockException.get()) {
     */
        client().prepareIndex(INDEX_NAME)
    }
import org.opensearch.test.junit.annotations.TestLogging;  
        final String replicaNode = internalCluster().startDataOnlyNode();
                -1,  
            assertEquals(
        // this test stubs transport calls specific to node-node replication.
        // Force a merge here so that the in memory SegmentInfos does not reference old segments on disk.
            logger.info("action {}", actionToblock);
        // realtime multi get 1 (routing set)  
        CountDownLatch latch1 = new CountDownLatch(1);
        ensureGreen(INDEX_NAME);  
                    .field("type", "keyword")
            if (randomBoolean()) {
            refresh(INDEX_NAME);  
                )
            assertEquals(
        );  
    public void testRealtimeTermVectorRequestsUnSuccessful() throws IOException {
        // index another doc but don't refresh, it should become searchable once the replica is promoted and refreshed there.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;  
            indexer.start(additionalDocCount);
        });
                SegmentReplicationPressureService.class,  
            refresh(INDEX_NAME);  
            assertFalse(ids.isEmpty());
            primary.set(replica_1.get().routingEntry().primary() ? replica_1.get() : replica_2.get());
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            SegmentReplicationPressureService replicaNode_service = internalCluster().getInstance(
            assertEquals(
                INDEX_NAME,
import java.util.ArrayList;
            }
        ActionFuture<CreatePitResponse> execute = client(replica).execute(CreatePitAction.INSTANCE, request);
        final String replicaNode = internalCluster().startDataOnlyNode();  
        logger.info("primaryFilesAfterMerge {}: {}", primaryFilesAfterMerge.size(), primaryFilesAfterMerge);
        request.setPreference("_only_local");
                Settings.builder().put(PublishCheckpointAction.PUBLISH_CHECK_POINT_RETRY_TIMEOUT.getKey(), TimeValue.timeValueMinutes(10))  
import org.opensearch.search.builder.PointInTimeBuilder;  
        final int initialDocCount = scaledRandomIntBetween(1, 10);  
        assertNotEquals(replicaAfterFailure.routingEntry().allocationId().getId(), replicaShard.routingEntry().allocationId().getId());
        try (final Releasable ignored = blockReplication(List.of(replicaNode), latch)) {  
        final IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
                .addAlias(new Alias("alias"))
        ensureGreen(INDEX_NAME);  
     */
        assertBusy(() -> {  
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 1);  
        createIndex(INDEX_NAME);
                        .put(indexSettings())
        // primary and replica generate index commit  
        final Settings settings = Settings.builder()
            .getId();
        logger.info("--> Create scroll query");
                    }
    public void testCancellation() throws Exception {  
            primaryNode
    }
    }  
        CountDownLatch latch = new CountDownLatch(1);
        final int initialDocCount = scaledRandomIntBetween(1, 10);
                )
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        }
        assertEquals(getNodeContainingPrimaryShard().getName(), replica);  
            SegmentReplicationPressureService pressureService = internalCluster().getInstance(
        final ShardRouting replicaShardRouting = getShardRoutingForNodeName(replica);
        // Wait until replica has written a tmp file to disk.
        final int initialDocCount = 10;  
        );
        verifyStoreContent();
        // create the cluster with one primary node containing primary shard and replica node containing replica shard  
            prepareCreate(INDEX_NAME).setSettings(Settings.builder().put("index.refresh_interval", -1).put(indexSettings()))
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        refresh(INDEX_NAME);
            // after the primary is dropped and replica is promoted we won't have a replica assigned yet, so stats per replica should return
    private void assertAllocationIdsInReplicaShardStats(Set<String> expected, Set<SegmentReplicationShardStats> replicaStats) {  
    }  
        assertTrue(  
        final String replica = internalCluster().startDataOnlyNode();
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(
            .actionGet();
            .build();
            BackgroundIndexer indexer = new BackgroundIndexer(
                        try {
                RandomizedTest.scaledRandomIntBetween(2, 5),  
        SegmentInfos latestSegmentInfos = getLatestSegmentInfos(replicaShard);
    public void testClosedIndices() {
        // opens a scrolled query before a flush is called.  
        // index a doc.
            .startObject("field")  
        response = resp.execute().actionGet();
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        createIndex(  
        );
                INDEX_NAME,
import org.apache.lucene.index.StandardDirectoryReader;
        assertThat(mgetResponse.getResponses()[2].getFailure().getMessage(), is("no such index [nonExistingIndex]"));
    public void testPrimaryStopped_ReplicaPromoted() throws Exception {
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").get();  
        assertTrue(
                            throw new RuntimeException(e);
        ) {  
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()  
    }  
            }  
        // realtime get 1 (preference = _replica)
        Set<String> replicaFilesAfterIndexCommitClose = Sets.newHashSet(replicaDirectory.listAll());
            .setOffsets(true)
            pendingIndexResponses.add(
            refresh(INDEX_NAME);  
import static org.opensearch.action.search.SearchContextId.decode;  
        );  
        final SegmentReplicationTargetService targetService = internalCluster().getInstance(
        ensureGreen(INDEX_NAME);  
import org.opensearch.common.unit.TimeValue;  
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            searchResponse = client(replica).prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueDays(1)).get();
                }
    public void testNodeDropWithOngoingReplication() throws Exception {
        final int replica_count = 6;
            assertNotNull("Replica shard 1 should not be null", replicaShard1);
        waitForSearchableDocs(0, replicaNode);
        final String replica = internalCluster().startDataOnlyNode();
            }
                    latch1.countDown();  
import org.opensearch.test.BackgroundIndexer;  
import org.opensearch.action.update.UpdateResponse;
            Collections.emptySet(),  
        indicesStatsRequest.all();
        replicaTransportService.clearAllRules();
            Settings.builder()
            TransportService.class,  
        ensureGreen(INDEX_NAME);
        for (int i = 0; i < numDocs; i++) {
        List<Document> docs = new ArrayList<>();
        prepareCreate(
        waitForSearchableDocs(4, primaryNode, replicaNode);  
import static org.opensearch.action.search.PitTestsUtil.assertSegments;
            )  
                    "body",
            replicaNode
        Fields fields = response.getFields();
                        }
        waitForSearchableDocs(3, primaryNode, replicaNode);
            }
        assertDocCounts(1, primary);  
            .addSort("field", SortOrder.ASC)
            )
        ensureGreen(INDEX_NAME);  
        logger.info(
        nodes.add(primaryNode);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        response = client(replica).prepareGet(INDEX_NAME, "1").setRouting(routingOtherShard).get();
            assertAcked(
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")  
        replicaShard.flush(new FlushRequest(INDEX_NAME));
                    latch2.await();
                false,
            indexer.start(additionalDocCount);
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime multi get
        assertFalse(mgetResponse.getResponses()[1].isFailed());
        waitForSearchableDocs(finalDocCount, primary, replica);  
        final String primary = internalCluster().startDataOnlyNode();
            refresh(INDEX_NAME);
                RandomizedTest.scaledRandomIntBetween(2, 5),
        mgetResponse = client(replica).prepareMultiGet()
    public void testCancellationDuringGetCheckpointInfo() throws Exception {
        createIndex(INDEX_NAME);  
        );  
                (OpenSearchDirectoryReader) searcher.getDirectoryReader()
            final ForceMergeResponse forceMergeResponse = client().admin()
            indexer.start(docCount);
                false,  
            )
            UpdateResponse updateResponse = client(primary).prepareUpdate(INDEX_NAME, id)
                }  
     * This tests that the max seqNo we send to replicas is accurate and that after failover
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                if (mockReplicaReceivePublishCheckpointException.get()) {
        // index doc 1
    }
        });
        final int docCount = scaledRandomIntBetween(1, 10);  
            verifyStoreContent();
        createIndex(INDEX_NAME, indexSettings);
                writer.addDocument(d);  
            primaryFilesBeforeMerge.stream().anyMatch(s -> s.startsWith("_0"))
        }  
        flushAndRefresh(INDEX_NAME);
            replicaFilesAfterMerge.stream().anyMatch(s -> s.startsWith("_0"))
            final IndexShard secondReplicaShard = getIndexShard(replicaNode_2, INDEX_NAME);
        }
        client().prepareIndex(INDEX_NAME)
            .setRequestCache(false)  
            )
     * @throws Exception when issue is encountered  
        final String replica = internalCluster().startDataOnlyNode();  
            );  
            .execute()
import java.util.Set;  
        assertFalse(response.isExists());
            final String second_replica_aid = secondReplicaShard.routingEntry().allocationId().getId();
                .prepareForceMerge(INDEX_NAME)
            .setIndices(INDEX_NAME)
            verifyStoreContent();
                .put("index.refresh_interval", -1)  
import static java.util.Arrays.asList;
        Settings indexSettings = Settings.builder()
                )  
        assertEquals(1, openContexts);
     * Tests that when scroll query is cleared, it does not delete the temporary replication files, which are part of  
            refresh(INDEX_NAME);  
            client().admin()
            client(primary).prepareDelete(INDEX_NAME, String.valueOf(i)).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            )  
                .setSource("foo", randomInt())
import org.opensearch.index.SegmentReplicationPressureService;
                primaryNode
            .setSelectedFields();
        flush(INDEX_NAME);  
        prepareCreate(
        final String id = routingKeyForShard(INDEX_NAME, 0);  
    public void testRestartPrimary_NoReplicas() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        final String currentAllocationID = state.routingTable()  
            .field("term_vector", "with_positions_offsets_payloads")
    }  
            .setId("1")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .setSelectedFields();
            .setSize(10)  
        primaryTransportService.addRequestHandlingBehavior(
                // we want to control refreshes
            "Skipping the test as its not compatible with segment replication with remote store.",
        waitForSearchableDocs(initialDocCount, primary, replica);  
                            latch.await();  
        logger.info("--> waiting for allocation to have shards assigned");
            .setSource("online", true, "ts", System.currentTimeMillis() - 123123, "type", "bs")
            try {  
    @Before
                    "replicationId {}, get segment files {}",  
            BackgroundIndexer indexer = new BackgroundIndexer(
        assertTrue(
                INDEX_NAME,
        ensureYellow(INDEX_NAME);
            .field("type", "text")  
            flushAndRefresh(INDEX_NAME);
    }  
        replicaTransportService.addRequestHandlingBehavior(
        // Test update of configuration PublishCheckpointAction#PUBLISH_CHECK_POINT_RETRY_TIMEOUT.
        final String nodeA = internalCluster().startDataOnlyNode();
            .setSource(jsonBuilder().startObject().field("field", "the quick brown fox jumps over the lazy dog").endObject())
            indexer.start(additionalDocCount);
            client().prepareIndex(INDEX_NAME)
    public void testRealtimeGetRequestsUnsuccessful() {
        }
        final String replicaNode = internalCluster().startDataOnlyNode(mockNodeSetting);
        }
            .filter(routing -> routing.primary() == false)  
import java.util.concurrent.atomic.AtomicReference;
        assertEquals(getNodeContainingPrimaryShard().getName(), primary);
            internalCluster().getInstance(TransportService.class, replica),
        assertBusy(  
        final String id = routingKeyForShard(INDEX_NAME, 0);
        if (randomBoolean()) {  
        refresh(INDEX_NAME);
                INDEX_NAME,  
        ensureGreen(INDEX_NAME);
            waitForDocs(initialDocCount, indexer);  
            refresh(INDEX_NAME);
        assertBusy(() -> {
import org.opensearch.node.NodeClosedException;
    }
        replicaIndexCommit.close();  
        waitForSearchableDocs(4, nodeC, replica);
            );
        final String replicaNode = internalCluster().startDataOnlyNode();  
                .setId(String.valueOf(i))  
        client().prepareIndex(INDEX_NAME)
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
        ensureGreen(INDEX_NAME);
            .setQuery(matchAllQuery())  
            ensureGreen(INDEX_NAME);
                .addAlias(new Alias("alias"))
        // stop the primary node - we only have one shard on here.
        final String primaryNode = internalCluster().startDataOnlyNode();  
import org.opensearch.test.transport.MockTransportService;
            .setRouting(randomAlphaOfLength(2))
                    .startObject("_routing")
        }
import static org.opensearch.index.query.QueryBuilders.boolQuery;
                    FileChunkRequest req = (FileChunkRequest) request;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            flushAndRefresh(INDEX_NAME);
        assertEquals(1, searchResponse.getSuccessfulShards());
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            );
        );  
        );
                    )
        final ShardRouting replicaShardRouting = getShardRoutingForNodeName(replica);
            PublishCheckpointAction.ACTION_NAME + TransportReplicationAction.REPLICA_ACTION_SUFFIX,
        ensureGreen(INDEX_NAME);
            assertEquals(  
            snapshottedSegments = infos.files(false);
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
import org.opensearch.index.shard.IndexShard;
import org.opensearch.search.sort.SortOrder;
import java.util.Arrays;  
            });
        verifyStoreContent();
        final String primaryNode = internalCluster().startDataOnlyNode();
import org.opensearch.core.common.breaker.CircuitBreaker;
            .actionGet();
            Sets.intersection(filesAfterClearScroll, snapshottedSegments)
     * Tests whether segment replication supports realtime MultiGet requests and reads and parses source from the translog to serve strong reads.
        final String replica = internalCluster().startDataOnlyNode();
            prepareCreate(INDEX_NAME).setSettings(
        assertTrue(temporaryFilesPostClear.containsAll(temporaryFiles));
        );  
     * Tests whether segment replication supports realtime get requests and reads and parses source from the translog to serve strong reads.
                startCancellationLatch.countDown();
        waitForSearchableDocs(INDEX_NAME, 2 * searchCount, List.of(primary, replica));
            .setSize(10)
            .field("analyzer", "tv_test")
            primaryNode
        assertThat(response.getIndex(), equalTo(INDEX_NAME));  
            primaryNode
import org.apache.lucene.document.SortedDocValuesField;
    }
        for (int i = 11; i < 20; i++) {  
        client(replica).prepareClearScroll().addScrollId(searchResponse.getScrollId()).get();  
            waitForSearchableDocs(expectedHitCount, asList(primary, replica));  
            .setSource(jsonBuilder().startObject().field("field", "the quick brown fox jumps over the lazy dog").endObject())  
                }
            forceMerge();
        // realtime termvectors 2 with routing
            internalCluster().getInstance(TransportService.class, replicaNode),
            doc.add(new SortedDocValuesField("dv", new BytesRef(TestUtil.randomRealisticUnicodeString(random()))));  
            ensureGreen(INDEX_NAME);
        List<String> filesBeforeClearScroll = List.of(replicaShard.store().directory().listAll());
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime termvectors  
        client().prepareIndex(INDEX_NAME)  
        ) {
            .setSelectedFields();
        waitForSearchableDocs(docCount, primaryNode, replicaNode);
        try (
            .setSource("bar", "baz")  
        resp = client(replica).prepareTermVectors(indexOrAlias(), Integer.toString(1))  
    }
            ensureYellow(INDEX_NAME);  
            assertEquals(replica_entry.getCheckpointsBehindCount(), 0);
        final int docCount = scaledRandomIntBetween(10, 20);
            BackgroundIndexer indexer = new BackgroundIndexer(  
            .get();  
        assertAcked(
                random()  
        // realtime termvectors 1
        final String replicaNode = internalCluster().startDataOnlyNode();
        AtomicBoolean mockException = new AtomicBoolean(true);
        // this test cancels allocation on the primary - promoting the new replica and recreating the former primary as a replica.
        // fetch the segments snapshotted when the reader context was created.
        response = resp.execute().actionGet();  
        ensureYellow(INDEX_NAME);  
        // Get replica allocation id
                .get();  
            () -> assertEquals(
        ensureYellow(INDEX_NAME);  
        client().prepareIndex(INDEX_NAME)  
            .setSource("foo", "bar")  
    private static String indexOrAlias() {  
                    .getReplicaStats();
        ensureGreen(INDEX_NAME);  
        assertFalse(response.isExists());
        // this test stubs transport calls specific to node-node replication.  
        ensureGreen(INDEX_NAME);
    /**  
                client(),
        final String primary = internalCluster().startDataOnlyNode();
import org.opensearch.action.termvectors.TermVectorsRequestBuilder;
import org.apache.lucene.document.Document;  
        assertAcked(  
                    .field("required", true)
        }
                                boolQuery().must(rangeQuery("ts").lt(System.currentTimeMillis() - (15 * 1000))).must(termQuery("type", "s"))
            assertAllocationIdsInReplicaShardStats(Set.of(second_replica_aid), replicaStats);
        final String replica = internalCluster().startDataOnlyNode();  
        final String primary = internalCluster().startDataOnlyNode();  
        refresh(INDEX_NAME);
    public void testAcquireLastIndexCommit() throws Exception {
            BackgroundIndexer indexer = new BackgroundIndexer(  
        final long expectedHitCount = initialDocCount + additionalDocs - deletedDocCount;
     * Tests whether segment replication supports realtime termvector requests and reads and parses source from the translog to serve strong reads.  
            TransportService.class,  
        // realtime get 1 (with routing set)  
        final String replica = internalCluster().startDataOnlyNode();
import java.util.Collections;
        );
import org.opensearch.common.util.set.Sets;
import org.opensearch.action.search.SearchResponse;
                && primaryFilesAfterMerge.stream().anyMatch(s -> s.startsWith("_1"))
        final String replicaNode = internalCluster().startDataOnlyNode();
            primaryFilesAfterIndexCommitClose
        final String replicaNode = internalCluster().startDataOnlyNode();  
        assertEquals(expectedMaxSeqNo, replicaShard.seqNoStats().getMaxSeqNo());  
        // opens a scrolled query before a flush is called.
        Set<String> primaryFilesAfterMerge = Sets.newHashSet(primaryDirectory.listAll());  
                false,
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .get();
        assertTrue(response.isExists());  
        final int additionalDocs = randomIntBetween(1, 5);
            )
            flush(INDEX_NAME);
        }  
            .setSource("online", false, "ts", System.currentTimeMillis() - 100, "type", "bs")  
        assertThat(response.getIndex(), equalTo(INDEX_NAME));  
        // perform refresh to start round of segment replication  
        long scrollHits = 0;
            client().prepareIndex(INDEX_NAME).setId(String.valueOf(i)).setSource("foo", "bar").get();  
            .filter(routing -> routing.primary())
                .put(indexSettings())  
        final String primaryNode = internalCluster().startDataOnlyNode();  
            );
            (connection, requestId, action, request, options) -> {  
        nodes.add(primaryNode);
        );
            refresh(INDEX_NAME);  
            "replicaFilesAfterIndexCommitClose {}: {}",  
        logger.info("Verify that after close index commit, primary and replica only contain _2.si");
        assertTrue(
import org.opensearch.index.IndexModule;
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(  
            .setPayloads(true)  
                .addAlias(new Alias("alias"))  
            .cluster()  
            replicaNode  
        );
            refresh(INDEX_NAME);
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 2);
        startCancellationLatch.await();  
        final String nodeB = internalCluster().startDataOnlyNode();
        SearchResponse searchResponse = client(replica).prepareSearch()  
        createIndex(INDEX_NAME, settings);  
                client(),
        logger.info("Local segments after force merge and commit {}", getLatestSegmentInfos(replicaShard).files(false));
import org.opensearch.transport.TransportService;  
            client().prepareIndex(INDEX_NAME)
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))  
     *
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
        mockTransportService.addSendBehavior(
        // Refresh, this should trigger round of segment replication
        ensureGreen(INDEX_NAME);  
                "_doc",
                .get();
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();  
        response = client(replica).prepareGet(indexOrAlias(), "1").get();
        fields = response.getFields();
import org.opensearch.action.search.SearchType;
        // realtime get 2 (with routing)
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import org.opensearch.transport.client.Requests;
    public void testScrollCreatedOnReplica() throws Exception {
        SearchService searchService = internalCluster().getInstance(SearchService.class, replica);
        assertThat(response.getIndex(), equalTo(INDEX_NAME));  
        ));
                }
        response = client(replica).prepareGet(indexOrAlias(), "1").setPreference(Preference.REPLICA.type()).get();
            final Map<ShardId, SegmentReplicationPerGroupStats> shardStats = pressureService.nodeStats().getShardStats();
            .addSort("foo", SortOrder.ASC)
import org.apache.lucene.index.Fields;
        ) {
            writer.commit();  
        performReplicationAfterForceMerge(true, SHARD_COUNT);  
import org.apache.lucene.index.SegmentInfos;  
        // create some segments on the replica before copy.  
        for (int i = initialDocCount; i < finalDocCount; i++) {  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        response = resp.execute().actionGet();  
                RandomizedTest.scaledRandomIntBetween(2, 5),
            )
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
            logger.info("Replica aid {}", replicaShard.routingEntry().allocationId());
            ensureYellowAndNoInitializingShards(INDEX_NAME);  
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
            "Skipping the test as its not compatible with segment replication with remote store.",
    /**
        logger.info("ensure publish checkpoint request can be process");  
                Settings.builder().put("index.refresh_interval", -1).put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            SegmentReplicationSourceService.class,
        assertEquals(1, searchResponse.getTotalShards());  
 */  
import java.util.Collection;
                    .get(replicaShard.shardId())  
            flush(INDEX_NAME);
            .put(EngineConfig.INDEX_CODEC_SETTING.getKey(), randomFrom(new ArrayList<>(CODECS) {  
        final IndexShard primaryShard = getIndexShard(primary, INDEX_NAME);
                .get();
                    .setSource("field", "value" + i)
        CountDownLatch latch2 = new CountDownLatch(1);  
                final SegmentReplicationShardStats stats = shardStatsSet.stream().findFirst().get();  
            refresh(INDEX_NAME);
     */
                latch.await();
        );
    }
            String docId = String.valueOf(initialDocCount + 1);
    }
import org.opensearch.action.search.DeletePitAction;
 * SPDX-License-Identifier: Apache-2.0
    private void cancelDuringReplicaAction(String actionToblock) throws Exception {
    /**
            SegmentReplicationPerGroupStats groupStats = shardStats.get(primaryShard.shardId());
    private void performReplicationAfterForceMerge(boolean primaryOnly, int expectedSuccessfulShards) throws Exception {  
            String replicaNode_2 = internalCluster().startDataOnlyNode();
        ensureYellow(INDEX_NAME);
        try (
        // start 1st node so that it contains the primary  
                RandomizedTest.scaledRandomIntBetween(2, 5),
        verifyStoreContent();
     * This test validates the primary node drop does not result in shard failure on replica.
        final List<String> nodes = new ArrayList<>();
        assertFalse(mgetResponse.getResponses()[0].getResponse().isExists());
    }
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
        ensureGreen(INDEX_NAME);
    public void testScrollWithOngoingSegmentReplication() throws Exception {
        nodes.add(replicaNode);
            BackgroundIndexer indexer = new BackgroundIndexer(
        assertThat(mgetResponse.getResponses().length, is(2));
import static org.hamcrest.Matchers.equalTo;
            ).addAlias(new Alias("alias"))
        refresh(INDEX_NAME);
        waitForSearchableDocs(2, primaryNode, replicaNode);
            final IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);  
        assertBusy(
        final int finalDocCount = 20;
            .field("analyzer", "tv_test")  
        Set<String> replicaFilesBeforeMerge = Sets.newHashSet(replicaDirectory.listAll());
            .put(indexSettings())
        // remove the replica and ensure it is cleaned up.
        client().admin()
                    Settings.builder()  
    public void testRetryPublishCheckPoint() throws Exception {
        assertBusy(() -> {  
        for (int i = initialDocCount; i < initialDocCount + additionalDocs; i++) {  
                client().prepareIndex(INDEX_NAME)  
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            }
        client().prepareClearScroll().addScrollId(searchResponse.getScrollId()).get();  
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)  
        flush(INDEX_NAME);
        }  
            );
        verifyStoreContent();
        final SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(replicaShard.store().directory());  
            segmentReplicationWithRemoteEnabled()  
            () -> assertEquals(  
            .setPayloads(true)  
            .setRequestCache(false)
            )
        final List<ActionFuture<SearchResponse>> pendingSearchResponse = new ArrayList<>();
                1,
            flush(INDEX_NAME);
            .setPreference("_only_local")
            .setPreference("_only_local")  
            // index another doc while blocked, this would not get replicated to replica.  
                // we want to control refreshes  
            waitForDocs(initialDocCount, indexer);
        client().prepareIndex(indexOrAlias()).setId("2").setSource("foo2", "bar2").setRouting(id).get();
    /**  
            client().prepareIndex(INDEX_NAME).setId(String.valueOf(i)).setSource("foo", "bar").get();
        try (final Engine.Searcher searcher = pitReaderContext.acquireSearcher("test")) {  
                .setSource("foo", randomInt())  
        final String replica = internalCluster().startDataOnlyNode();
import org.apache.lucene.util.BytesRef;
            )
            .setFrom(0)
            .get();
        primaryShard.flush(new FlushRequest(INDEX_NAME));
        logger.info("--> Close index");
                    add(CodecService.LUCENE_DEFAULT_CODEC);
import org.opensearch.action.search.CreatePitRequest;
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
        );
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
            assertEquals(
    public void testPitCreatedOnReplica() throws Exception {  
            )
        // randomly flush here after the force merge to wipe any old segments.
            final int expectedHitCount = initialDocCount + additionalDocCount;  
    }
            );
 * this file be licensed under the Apache-2.0 license or a
                .get();  
        assumeFalse(  
            IndexShard replicaShard2 = getIndexShard(replicaNode2, INDEX_NAME);  
        assertEquals(currentAllocationID, replicaAllocationId);  
                RandomizedTest.scaledRandomIntBetween(2, 5),
            (handler, request, channel, task) -> {
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
                            throw new RuntimeException(e);
                connection.sendRequest(requestId, action, request, options);  
        final String replicaNode = internalCluster().startDataOnlyNode();
import java.util.concurrent.TimeUnit;
        final String primaryNode = internalCluster().startDataOnlyNode();
        );  
import org.opensearch.index.SegmentReplicationShardStats;  
            final int additionalDocCount = scaledRandomIntBetween(0, 2);
                primaryShard.getLatestReplicationCheckpoint().getSegmentInfosVersion(),
     * ongoing round of segment replication
            decode(registry, pitResponse.getId()).shards().get(replicaShard.routingEntry().shardId()).getSearchContextId()
        );
            .setSource("foo2", "bar2")  
        final Set<String> filesAfterClearScroll = Arrays.stream(replicaShard.store().directory().listAll()).collect(Collectors.toSet());
        ensureGreen(INDEX_NAME);
        // realtime termvectors (preference = _replica)
            .findFirst()
    }  
        client().prepareIndex(INDEX_NAME)
    }
            .setPersistentSettings(
        List<String> nodes = new ArrayList<>();
        // wait for replication to complete  
        ensureGreen(INDEX_NAME);
                );  
        assertNotNull(replicaShardRouting);
        // update publish checkpoint retry time out
    public void testReplicationPostDeleteAndForceMerge() throws Exception {
                        try {
            .setId(Integer.toString(2))
        ) {  
        return randomBoolean() ? INDEX_NAME : "alias";
import java.util.stream.Collectors;
        assertThat(response.getIndex(), equalTo(INDEX_NAME));  
        }
        ) {
        final int expectedHitCount = initialDocCount + additionalDocCount;
                -1,  
 * compatible open source license.
            .build();
                        .put(indexSettings())  
        logger.info("Segments {}", snapshottedSegments);
            docs.add(doc);
            "All snapshotted files should be deleted",
        assertFalse(mgetResponse.getResponses()[0].getResponse().isExists());
import java.io.IOException;
            )
import org.apache.lucene.index.IndexWriter;
            .put(TransportReplicationAction.REPLICATION_RETRY_TIMEOUT.getKey(), TimeValue.timeValueSeconds(0))  
        IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);  
        logger.info("--> Closing the index ");
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
        final IndexShard replicaShard = getIndexShard(replica, INDEX_NAME);
                throw new RuntimeException(e);
        ensureYellow(INDEX_NAME);
        MockTransportService primaryTransportService = (MockTransportService) internalCluster().getInstance(  
            writer.flush();
        ensureGreen(INDEX_NAME);
            waitForDocs(initialDocCount, indexer);
        // start another node, index another doc and replicate.
            .setSource(jsonBuilder().startObject().field("field", "the quick brown fox jumps over the lazy dog").endObject())
            Set<String> ids = indexer.getIds();
            client().admin().indices().prepareRefresh().execute().actionGet();  
        assertEquals(expected, replicaStats.stream().map(SegmentReplicationShardStats::getAllocationId).collect(Collectors.toSet()));
            final int additionalDocCount = scaledRandomIntBetween(0, 10);  
                -1,  
                        try {
            waitForSearchableDocs(initialDocCount, primary, replica);  
        MockTransportService replicaTransportService = ((MockTransportService) internalCluster().getInstance(
        final IndexShard replicaAfterFailure = getIndexShard(replicaNode, INDEX_NAME);
            .setExplain(true)  
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(6);
                    if (req.name().endsWith("cfs") && req.lastChunk()) {
            INDEX_NAME,  
        // assert we can index into the new primary and refresh there, making doc2 searchable too.  
        assertThat(mgetResponse.getResponses()[1].getIndex(), is("nonExistingIndex"));  
                    .getShardStats()
            .get();  
        createIndex(INDEX_NAME);
        waitForSearchableDocs(2, nodes);
                assertAllocationIdsInReplicaShardStats(Set.of(second_replica_aid), shardStatsSet);
