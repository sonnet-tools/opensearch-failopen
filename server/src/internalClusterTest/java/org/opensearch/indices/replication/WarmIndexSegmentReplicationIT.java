        );  
            Sets.intersection(latestCommitSegments, snapshottedSegments)
            waitForDocs(expectedHitCount, indexer);
                -1,
            refresh(INDEX_NAME);
        CountDownLatch latch = new CountDownLatch(1);
import static org.hamcrest.Matchers.equalTo;
            String id = ids.toArray()[0].toString();
        // realtime termvectors 1
        internalCluster().restartNode(replica);  
            .add(new MultiGetRequest.Item(INDEX_NAME, "2").routing(id))
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);  
    public void testRealtimeGetRequestsSuccessful() {
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);  
            indexer.start(additionalDocCount);
        final Path indicesCacheDataPath = node.getNodeEnvironment().fileCacheNodePath().indicesPath.resolve(index.getUUID());
            fail("FileCache did not initialise correctly");
            final int expectedHitCount = initialDocCount + additionalDocCount;
public class WarmIndexSegmentReplicationIT extends SegmentReplicationBaseIT {  
            replicaStats = replicaNode_service.nodeStats().getShardStats().get(primaryShard.shardId()).getReplicaStats();  
        waitForSearchableDocs(INDEX_NAME, 2 * searchCount, List.of(primary, replica));
            final SearchResponse response = client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get();
            if (exists) {
                INDEX_NAME,
                client(),
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        assertEquals(
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").get();  
        assertThat(mgetResponse.getResponses()[2].getIndex(), is("nonExistingIndex"));  
            );  
        client().prepareIndex(indexOrAlias()).setId("1").setSource("foo", "bar").get();
            Settings.builder()  
            assertAllocationIdsInReplicaShardStats(Set.of(second_replica_aid), replicaStats);
            )
                client(),
     * the replica will catch up to latest checkpoint once recovery completes without requiring an additional primary refresh/flush.
            // start another replica.  
            .setRequestCache(false)
        assertDocCounts(docCount, primaryNode);  
        ensureGreen(INDEX_NAME);
        // Force a merge here so that the in memory SegmentInfos does not reference old segments on disk.  
        );
import static org.hamcrest.Matchers.is;
            .addSort("field", SortOrder.ASC)
        AggregateFileCacheStats aggregateStats = replicaFileCache.fileCacheStats();  
        assertAcked(
            INDEX_NAME,
                    random().nextBoolean() ? Field.Store.YES : Field.Store.NO
            logger.debug("ShardPath is null for node: {}", nodeName);
        // index doc 2 with routing  
                        )
        ) {
        ));
        ensureGreen(INDEX_NAME);
    /**
     * Tests whether segment replication supports realtime MultiGet requests and reads and parses source from the translog to serve strong reads.
        // create new on-disk segments and copy them out.
        createIndex(INDEX_NAME);
        );
                .setSettings(  
            // Perform force merge only on the primary shards.
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(false).get();  
        client().admin().indices().prepareOpen(INDEX_NAME).get();  
        // index another doc.  
            .setSource(jsonBuilder().startObject().field("field", "the quick brown fox jumps over the lazy dog").endObject())
        mockTransportService.addSendBehavior(
        ensureGreen(INDEX_NAME);
     */  
        final IndexShard indexShard = getIndexShard(primary, INDEX_NAME);  
        assertAcked(
        final int initialDocCount = 1;
        final String nodeB = internalCluster().startDataAndWarmNodes(1).get(0);  
package org.opensearch.indices.replication;
        flush(INDEX_NAME);
        }
            .startObject("field")
            .setWaitForNoRelocatingShards(true)
                random()  
        ensureGreen(INDEX_NAME);
            indexer.start(initialDocCount);  
        });
        logger.info("--> Opening the index");
        client(replica).prepareClearScroll().addScrollId(searchResponse.getScrollId()).get();  
            .setRealtime(false)  
        primaryTransportService.addSendBehavior(  
            assertBusy(() -> {
    public void testRealtimeTermVectorRequestsSuccessful() throws IOException {  
            indexer.start(initialDocCount);
        for (int i = initialDocCount; i < initialDocCount + additionalDocs; i++) {  
            assertEquals("cache data path should not exists", false, Files.exists(cacheDataPath));  
        refresh(INDEX_NAME);
import java.util.Set;
import org.opensearch.common.lease.Releasable;  
        );  
        ) {
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
            refresh(INDEX_NAME);  
            primary.set(replica_1.routingEntry().primary() ? replica_1 : replica_2);  
        String nodeC = internalCluster().startDataAndWarmNodes(1).get(0);
    @Override
        waitForSearchableDocs(1, primary, replica);  
                random()
        forceMerge();
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        final IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
        );
            client(nodeA).prepareDelete(INDEX_NAME, id).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            waitForDocs(initialDocCount, indexer);
            .setQuery(matchAllQuery())  
            assertSearchHits(client(primary).prepareSearch(INDEX_NAME).setQuery(matchQuery("foo", "baz")).get(), id);  
            String id = ids.toArray()[0].toString();
                final SegmentReplicationShardStats stats = shardStatsSet.stream().findFirst().get();
        ensureYellow(INDEX_NAME);
        logger.info("Segments {}", snapshottedSegments);  
        });
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        ensureGreen(INDEX_NAME);
        final String nodeB = internalCluster().startDataAndWarmNodes(1).get(0);  
        List<String> nodes = new ArrayList<>();
            client().admin().indices().prepareGetSettings(INDEX_NAME).get().getIndexToSettings().get(INDEX_NAME)  
        refresh(INDEX_NAME);
    public void testPrimaryStopped_ReplicaPromoted() throws Exception {
        response = client(replica).prepareGet(indexOrAlias(), "1").setPreference(Preference.REPLICA.type()).get();  
        response = resp.execute().actionGet();
        final int expectedHitCount = initialDocCount + additionalDocCount;  
        createIndex(INDEX_NAME);  
import org.opensearch.node.Node;  
        SegmentInfos latestSegmentInfos = getLatestSegmentInfos(replicaShard);
            assertFalse(exists);  
            .setRealtime(true)
        response = client().prepareTermVectors(indexOrAlias(), Integer.toString(1)).setRealtime(false).get();
    public void testNodeDropWithOngoingReplication() throws Exception {
        // add some docs to the xlog and drop primary.
                        .put(indexSettings())
    public void testScrollWithConcurrentIndexAndSearch() throws Exception {
        waitForSearchableDocs(docCount, primaryNode, replicaNode);  
        return Settings.builder().put(super.indexSettings()).put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true).build();
        } while (searchResponse.getHits().getHits().length > 0);  
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
        assertAcked(
    }  
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()  
        assertEquals(currentAllocationID, replicaAllocationId);  
            flush(INDEX_NAME);  
        ensureGreen(INDEX_NAME);
        // realtime get 1 (preference = _replica)
        );
            .setPayloads(true)
            assertFalse(ids.isEmpty());  
        response = client().prepareGet(indexOrAlias(), "1").setRealtime(false).get();
        refresh(INDEX_NAME);
            .stream()  
            }))
    }
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", randomInt()).get();
            )
                            .should(  
        if (!warmIndexSegmentReplicationEnabled()) {  
                1,
            .endObject()
            .endObject()
        final SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(replicaShard.store().directory());
        for (int i = 0; i < docCount; i++) {  
import org.opensearch.test.OpenSearchIntegTestCase;
        final ShardId shardId = new ShardId(index, 0);
        // Index to create another segment  
            .cluster()
            .stream()
            .setPositions(true)  
        mgetResponse = client(replica).prepareMultiGet()
    public void testReplicaHasDiffFilesThanPrimary() throws Exception {
            .setPreference("_only_local")
        ensureGreen();  
        // replica now promoted as primary should have same allocation id
                    .setRefreshPolicy(refreshPolicy)  
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();  
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
import org.opensearch.cluster.health.ClusterHealthStatus;
            return;
import org.opensearch.common.util.FeatureFlags;  
            ensureYellow(INDEX_NAME);
            waitForDocs(expectedHitCount, indexer);
            .startObject("field")  
                    .get(replicaShard.shardId())
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        );  
     * @throws Exception when issue is encountered
        assertAcked(
                client(),
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        final SegmentReplicationSourceService segmentReplicationSourceService = internalCluster().getInstance(
                    fail("File copy should not happen for warm index replica shards");
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))
        assertWarmIndexDirectoryExistence(thirdWarmNode, index, false, customDataPath);
import org.opensearch.action.admin.indices.alias.Alias;
        ensureGreen(INDEX_NAME);
            .get();
            BackgroundIndexer indexer = new BackgroundIndexer(
        assertThat(fields.size(), equalTo(1));
                .prepareUpdateSettings(INDEX_NAME)
                .get();  
                .put("index.refresh_interval", -1)  
        internalCluster().startClusterManagerOnlyNode();
            final String second_replica_aid = secondReplicaShard.routingEntry().allocationId().getId();
            logger.info("Replica aid {}", replicaShard.routingEntry().allocationId());  
        assertThat(mgetResponse.getResponses()[1].getIndex(), is("nonExistingIndex"));
        // realtime multi get 1 (preference = _replica)  
                .setDoc(Requests.INDEX_CONTENT_TYPE, "foo", "baz")
        createIndex(INDEX_NAME);
            )  
 *
        ensureGreen(INDEX_NAME);
                    fail("File copy should not happen for warm index replica shards");
        assertFalse(response.isExists());  
    public Settings indexSettings() {  
    }
import org.opensearch.indices.replication.common.ReplicationType;
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);  
        ensureGreen(INDEX_NAME);
        // start a replica node, initially will be empty with no shard assignment.
        }
            .actionGet();
    }
        final String nodeA = internalCluster().startDataAndWarmNodes(1).get(0);
            assertEquals(0L, replicationStats.maxBytesBehind);
import org.opensearch.action.get.MultiGetResponse;
        response = client(replica).prepareGet(INDEX_NAME, "1").setRouting(routingOtherShard).get();
        logger.info("--> waiting for allocation to have shards assigned");
        Long currentSize = internalCluster().getInstance(Node.class, primary).fileCache().size();  
        // index doc 1  
        }
                false,
        assertBusy(() -> {  
                    .endObject()
        assertTrue(replicaShardRouting + " should be promoted as a primary", replicaShardRouting.primary());  
        );
    /**  
        logger.info("--> Closing the index ");
            flushAndRefresh(INDEX_NAME);  
                SegmentReplicationPressureService.class,
                assertTrue(Files.exists(shardStatePath));
        assertTrue(mgetResponse.getResponses()[1].isFailed());
            // Fetch pressure stats from the Replica's Node we will assert replica node returns nothing until it is promoted.  
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);  
        if (clusterHealthResponse.isTimedOut()) {
                    .endObject()
                    Settings.builder()
    }
import org.junit.Before;
        waitForSearchableDocs(4, nodeC, replica);
            logger.info("former primary aid {}", primaryShard.routingEntry().allocationId());
    }
        assertThat("doc id: " + 1 + " doesn't exists but should", response.isExists(), equalTo(true));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                    .field("type", "date")
                logger.debug("Verifying shard paths do not exist for node: {}", nodeName);
            .setPayloads(true)
            flush(INDEX_NAME);
        client().prepareIndex(INDEX_NAME)
        // index a doc.  
            Set<SegmentReplicationShardStats> replicaStats = groupStats.getReplicaStats();
        ensureGreen(INDEX_NAME);  
            .prepareReroute()
     * the new primary starts indexing from the correct maxSeqNo and replays the correct count of docs
            .setPayloads(true)
        final int initialDocCount = scaledRandomIntBetween(0, 10);
        TermVectorsResponse response = client().prepareTermVectors(indexOrAlias(), Integer.toString(1)).setRealtime(false).get();
            assertWarmIndexDirectoryExistence(secondWarmNode, index, false, customDataPath);
        }  
        MultiGetResponse mgetResponse = client(replica).prepareMultiGet()
        client().prepareIndex(INDEX_NAME).setId("2").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        nodes.add(primaryNode);  
                        .put("index.refresh_interval", -1)  
        final int replica_count = 6;  
                {
        assertFalse(response.isExists());  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
    public void testRealtimeMultiGetRequestsSuccessful() {
        for (int i = 0; i < searchCount; i++) {
        for (int i = 0; i < numDocs; i++) {  
        ensureGreen(INDEX_NAME);  
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
        ) {
        // randomly flush here after the force merge to wipe any old segments.
                assertEquals(0, stats.getCheckpointsBehindCount());  
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
            refresh(INDEX_NAME);
            .actionGet();
        if (absolutePath == null) {  
                "_doc",
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        final Path shardStatePath = shardPath.getShardStatePath();
        // index doc 1
                .setSettings(
            (connection, requestId, action, request, options) -> {
                .put("index.refresh_interval", -1)  
                Settings.builder().put("index.refresh_interval", -1).put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
        nodes.add(primaryNode);
        final List<String> nodes = new ArrayList<>();  
                new TextField(
                    .setSource("field", "value" + i)
            "Snapshotted files are no longer part of the latest commit",  
            pendingIndexResponses.add(
        int numDocs = 2 + random().nextInt(10);  
        createIndex(INDEX_NAME, indexSettings);  
                replicaShard.getLatestReplicationCheckpoint().getSegmentInfosVersion()  
        // block replication
            indexer.start(additionalDocCount);  
            forceMerge();
                false,
                "_doc",  
        client().prepareIndex(INDEX_NAME)  
        final Path shardDataPath = shardPath.getDataPath();
        client().prepareIndex(INDEX_NAME)  
            searchResponse = client(replica).prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueDays(1)).get();
        AtomicReference<IndexShard> primary = new AtomicReference<>();  
        refresh(INDEX_NAME);
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 3);
                }  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replica_count)  
        IndexShard replica_2 = getIndexShard(replicaNode2, INDEX_NAME);
            refresh(INDEX_NAME);  
            .setOffsets(true)
        // create a doc to index
        final String replica = internalCluster().startWarmOnlyNodes(1).get(0);
    }  
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                random()
        int initialDocCount = scaledRandomIntBetween(5, 10);
        assertDocCounts(1, primary);
        final String routingOtherShard = routingKeyForShard(INDEX_NAME, 1);
    }
import org.apache.lucene.util.BytesRef;
import java.util.concurrent.atomic.AtomicReference;
        if (randomBoolean()) {
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
        ensureYellow(INDEX_NAME);
        verifyStoreContent();  
    protected boolean warmIndexSegmentReplicationEnabled() {
        ensureGreen(INDEX_NAME);  
        refresh(INDEX_NAME);
    }
                .prepareUpdateSettings(INDEX_NAME)
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            }
                primaryNode  
            );
                .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)
import org.opensearch.common.settings.Settings;
        }
        return randomBoolean() ? INDEX_NAME : "alias";
        client().prepareIndex(INDEX_NAME)
        );
        assertHitCount(client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), expectedHitCount);
        // realtime get 1 (with routing set)
        assertThat(mgetResponse.getResponses()[0].getResponse().getSourceAsMap().get("foo").toString(), equalTo("bar"));  
            indexer.start(additionalDocCount);
        // index doc 2
                    .field("required", true)
        refresh(INDEX_NAME);
            // Index a second set of docs so we can merge into one segment.  
                }
        verifyStoreContent();  
                                boolQuery().must(rangeQuery("ts").lt(System.currentTimeMillis() - (15 * 1000))).must(termQuery("type", "s"))
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
import org.opensearch.cluster.routing.ShardRoutingState;
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
            .setSource(jsonBuilder().startObject().field("field", "the quick brown fox jumps over the lazy dog").endObject())  
        IndexShard replica_1 = getIndexShard(replicaNode, INDEX_NAME);  
            flush(INDEX_NAME);  
        // multi get realtime 1
    public void testReplicationAfterForceMergeOnPrimaryShardsOnly() throws Exception {  
            verifyStoreContent();
            waitForDocs(initialDocCount, indexer);  
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
            .startObject("properties")
        GetResponse response = client().prepareGet(indexOrAlias(), "1").setRealtime(false).get();
        ensureGreen(INDEX_NAME);  
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
        // assert we can index into the new primary.
            waitForDocs(expectedHitCount, indexer);
            assertEquals(  
            .setPositions(true)  
    }  
        assertAcked(  
        ensureYellow(INDEX_NAME);
        final int initialDocCount = 1;  
                            )
        createIndex(INDEX_NAME);  
            absolutePath = randomRepoPath().toAbsolutePath();
            waitForSearchableDocs(expectedHitCount - 1, nodeA, nodeB);
import java.util.concurrent.CountDownLatch;
                false,
            .setSize(100)
            .shardsWithState(ShardRoutingState.STARTED)
            for (Document d : docs) {  
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);  
        try (IndexWriter writer = new IndexWriter(replicaShard.store().directory(), iwc)) {
            .add(new MultiGetRequest.Item("nonExistingIndex", "1"))  
            waitForDocs(initialDocCount, indexer);
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
                false,
        ensureGreen(INDEX_NAME);  
        refresh(INDEX_NAME);
        // realtime get 1
            .execute()
        }
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
        ensureYellow(INDEX_NAME);
            final IndexShard secondReplicaShard = getIndexShard(replicaNode_2, INDEX_NAME);  
        ensureGreen(INDEX_NAME);
            .setWaitForEvents(Priority.LANGUID)
            waitForSearchableDocs(expectedHitCount, asList(primary, replica));
import org.opensearch.index.shard.IndexShard;
                false,
        logger.debug("Checking warm index directory existence for node: {}, expected exists: {}", nodeName, exists);
            .setPositions(true)
                .get();
     * This test validates the primary node drop does not result in shard failure on replica.
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());  
                -1,  
        final int deletedDocCount = randomIntBetween(1, initialDocCount);
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);  
            .build();  
import org.opensearch.test.InternalTestCluster;  
            .startObject("properties")  
    }  
        createIndex(INDEX_NAME);  
        resp = client().prepareTermVectors(indexOrAlias(), Integer.toString(2))  
        assertBusy(
    private void assertWarmIndexDirectoryExistence(String nodeName, Index index, boolean exists, String customDataPath) throws Exception {  
import java.nio.file.Path;  
            )  
            .get();
        }
            .add(new MultiGetRequest.Item(INDEX_NAME, "1"))
        final String replicaAllocationId = state.routingTable()
            .setRealtime(true)
        // start another node, index another doc and replicate.  
            final int expectedHitCount = initialDocCount + additionalDocCount;  
        final String nodeB = internalCluster().startDataAndWarmNodes(1).get(0);  
            .execute()
            pendingIndexResponses.add(  
                false,  
        }  
        response = resp.execute().actionGet();
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;
        assertNotNull(replicaShardRouting);
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);  
            // Refresh, this should trigger round of segment replication
            verifyStoreContent();
        final Set<String> filesAfterClearScroll = Arrays.stream(replicaShard.store().directory().listAll()).collect(Collectors.toSet());
import org.opensearch.action.support.WriteRequest;  
        assertFalse(mgetResponse.getResponses()[0].getResponse().isExists());
    }
                    .startObject("_routing")  
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
        final int initialDocCount = scaledRandomIntBetween(1, 10);  
    /**
                client().admin()
                    .startObject("online")
        // Flush segments to disk and create a new commit point (Primary: segments_3, _s1.si)
        // force merge and flush.  
        for (int i = 0; i < docCount; i++) {
                    .setSource("field", "value" + i)  
                -1,
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
        ) {
            waitForSearchableDocs(initialDocCount, replicaNode_2);
            );
import org.opensearch.index.SegmentReplicationShardStats;
            final int additionalDocCount = scaledRandomIntBetween(0, 5);
    public void testRealtimeTermVectorRequestsUnSuccessful() throws IOException {
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        client().admin().indices().prepareClose(INDEX_NAME).get();  
            .get()  
            .get();
        XContentBuilder mapping = jsonBuilder().startObject()
            .field("type", "text")
            // update to add replica, initiating recovery, this will get stuck at last step  
        createIndex(INDEX_NAME);
        return false;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .add(new CancelAllocationCommand(INDEX_NAME, indexShard.shardId().id(), primary, true))
            BackgroundIndexer indexer = new BackgroundIndexer(
        ensureGreen(INDEX_NAME);
            BackgroundIndexer indexer = new BackgroundIndexer(
        logger.info("---> restarting replica node");
            BackgroundIndexer indexer = new BackgroundIndexer(
                    .startObject("ts")
        // there should be no active readers, snapshots, or on-disk commits containing the snapshotted files, check that they have been
            .allocationId()  
                replica_1.getLatestReplicationCheckpoint().getSegmentInfosVersion(),  
        final String id = routingKeyForShard(INDEX_NAME, 0);
            final IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
            final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
    public void testDeleteOperations() throws Exception {
import org.opensearch.cluster.metadata.IndexMetadata;  
        assertBusy(() -> { assertDocCounts(docCount, replicaNode); });  
            .get();
    /**
    public void testCancelPrimaryAllocation() throws Exception {  
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
            )  
     */  
        waitForSearchableDocs(initialDocCount, replica, primary);
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/18157")  
import org.junit.After;
        );
            doc.add(new StringField("id", "" + i, random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        }
            Collections.emptySet(),
                assertEquals(1, replicaNode_service.nodeStats().getShardStats().size());
    }
        flushAndRefresh(INDEX_NAME);
        prepareCreate(
import java.util.stream.Collectors;
                -1,
        final int docCount = scaledRandomIntBetween(1, 10);  
        );  
        try (final Releasable ignored = blockReplication(List.of(replicaNode), latch)) {
        waitForSearchableDocs(initialDocCount, primary, replica);  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
            );
                    .field("format", "epoch_millis")
            logger.warn("Cluster health check timed out after relocation");
        blockFileCopy.countDown();  
            .setSource("online", true, "ts", System.currentTimeMillis() - 123123, "type", "bs")
        final IndexShard primaryShard = getIndexShard(primary, INDEX_NAME);
            .setId(String.valueOf(0))
        } else {
        TermVectorsRequestBuilder resp = client(replica).prepareTermVectors(indexOrAlias(), Integer.toString(1))  
            .build();
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);
            indexer.start(initialDocCount);
        createIndex(INDEX_NAME);  
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(false).get();
        createIndex(INDEX_NAME);
        FileCache replicaFileCache = internalCluster().getInstance(Node.class, replica).fileCache();  
        assertEquals(getNodeContainingPrimaryShard().getName(), primary);
            .build();
        // realtime get 2 (with routing)
                    .field("ignore_malformed", false)  
import org.apache.lucene.index.IndexWriter;
        resp = client(replica).prepareTermVectors(indexOrAlias(), Integer.toString(1))
        IndexWriterConfig iwc = newIndexWriterConfig().setOpenMode(IndexWriterConfig.OpenMode.APPEND);  
        internalCluster().restartNode(primary);
            verifyStoreContent();  
            )
import java.util.Map;  
        assertThat(mgetResponse.getResponses()[1].getIndex(), is("nonExistingIndex"));
        assertAcked(client().admin().indices().prepareClose(INDEX_NAME));  
            .setSelectedFields();  
                INDEX_NAME,  
        assertWarmIndexDirectoryExistence(thirdWarmNode, index, true, customDataPath);
    }  
        );
    }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            // index another doc while blocked, this would not get replicated to replica.
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
        try (  
            flush(INDEX_NAME);
        try (
import org.opensearch.test.junit.annotations.TestLogging;
import org.apache.lucene.index.IndexWriterConfig;
        assertAcked(
        });
            BackgroundIndexer indexer = new BackgroundIndexer(
            assertEquals(
        // Index a doc to create the first set of segments. _s1.si  
        // deleted.  
            scrollHits += searchResponse.getHits().getHits().length;  
            ).addAlias(new Alias("alias"))
/**
            indexer.start(initialDocCount);
            Collections.emptySet(),  
                .addAlias(new Alias("alias"))  
        assertTrue(replicaShardRouting + " should be promoted as a primary", replicaShardRouting.primary());
        final String replicaNode2 = internalCluster().startDataAndWarmNodes(1).get(0);  
    /**
            refresh(INDEX_NAME);
            final int expectedHitCount = initialDocCount + additionalDocCount;
    }
        // non realtime get 1
        final int initialDocCount = scaledRandomIntBetween(1, 10);  
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;  
        ensureGreen(INDEX_NAME);
            .field("type", "text")
    protected boolean addMockIndexStorePlugin() {
        });  
                .get();  
        assertFalse(response.isExists());  
            ReplicationStats replicationStats = clusterStatsResponse.getIndicesStats().getSegments().getReplicationStats();
        for (int i = 0; i < initialDocCount; i++) {
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
import org.opensearch.common.unit.TimeValue;
            .get();
    public void testReplicationAfterPrimaryRefreshAndFlush() throws Exception {
                verifyStoreContent();
        assertEquals(getNodeContainingPrimaryShard().getName(), replica);
                false,
        DiscoveryNode primaryDiscovery = state.nodes().resolveNode(primaryNode);
        assertEquals(expected, replicaStats.stream().map(SegmentReplicationShardStats::getAllocationId).collect(Collectors.toSet()));  
            final ForceMergeResponse forceMergeResponse = client().admin()  
import org.opensearch.action.get.GetResponse;  
        assertBusy(() -> {
        ensureGreen(INDEX_NAME);
            (connection, requestId, action, request, options) -> {  
    }  
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        createIndex(INDEX_NAME, settings);
        client().prepareIndex(INDEX_NAME)
        SearchResponse response = client().prepareSearch(INDEX_NAME)
        Fields fields = response.getFields();  
            .execute()
            .setOffsets(true)  
        final String id = routingKeyForShard(INDEX_NAME, 0);  
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime termvectors
            refresh(INDEX_NAME);
        flushAndRefresh(INDEX_NAME);  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        for (int i = 0; i < deletedDocCount; i++) {  
import java.util.List;
                .setPrimaryOnly(primaryOnly)  
import org.opensearch.index.IndexModule;
                client(),
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .setPreference(Preference.REPLICA.type())  
import java.util.ArrayList;
        }
import org.opensearch.core.index.shard.ShardId;
    }
                    add(CodecService.LUCENE_DEFAULT_CODEC);
        }, 1, TimeUnit.MINUTES);  
        ensureYellow(INDEX_NAME);
        }
        // wait until a replica is promoted & finishes engine flip, we don't care which one
import org.opensearch.action.admin.indices.flush.FlushRequest;
            assertEquals(
            SegmentReplicationPerGroupStats groupStats = shardStats.get(primaryShard.shardId());  
            prepareCreate(INDEX_NAME).setMapping(
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime get  
            .setRouting(id)  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
import org.opensearch.core.common.unit.ByteSizeUnit;
                INDEX_NAME,
        assertTrue(response.isExists());
        final String routingOtherShard = routingKeyForShard(INDEX_NAME, 1);
            waitForDocs(expectedHitCount, indexer);  
        nodes.add(replicaNode);
        int initialDocCount = scaledRandomIntBetween(10, 20);
                "_doc",
import org.opensearch.cluster.node.DiscoveryNode;
                client().prepareIndex(INDEX_NAME)
            .setOffsets(true)
            prepareCreate(INDEX_NAME).setSettings(
        // create some segments on the replica before copy.
            client().prepareIndex(INDEX_NAME).setId(docId).setSource("foo", "bar").get();
            refresh(INDEX_NAME);
        ));  
        assertEquals(expectedMaxSeqNo, replicaShard.seqNoStats().getMaxSeqNo());
                    Settings.builder()  
        refresh(INDEX_NAME);
    public void testUpdateOperations() throws Exception {
                INDEX_NAME,
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")  
import org.opensearch.transport.client.Client;
    public void testRealtimeGetRequestsUnsuccessful() {  
            ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        final String currentAllocationID = state.routingTable()  
        assertEquals(getNodeContainingPrimaryShard().getName(), replica);
            prepareCreate(INDEX_NAME).setSettings(
    public void testStartReplicaAfterPrimaryIndexesDocs() throws Exception {
            final SegmentReplicationShardStats replica_entry = replicaStats.stream().findFirst().get();
            .actionGet();
            .put(indexSettings())
    public void testRealtimeMultiGetRequestsUnsuccessful() {
            // index another doc and refresh - without this the new replica won't catch up.
        String primary = internalTestCluster.startWarmOnlyNodes(1).get(0);
    }  
import org.opensearch.action.get.MultiGetRequest;
        assertWarmIndexDirectoryExistence(primary, index, true, customDataPath);  
                assertEquals(false, Files.exists(shardDataPath));  
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").get();  
            internalCluster().getInstance(TransportService.class, replicaNode),
            final int additionalDocCount = scaledRandomIntBetween(0, 2);  
import org.apache.lucene.index.SegmentInfos;  
            assertAllSuccessful(searchResponse);
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);  
        refresh(INDEX_NAME);
    public void testShardPathDeletionWhenWarmIndexRelocate() throws Exception {
        ) {
        assertFalse(response.isExists());  
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
        }  
        assertBusy(() -> {
        primary.get().flush(request);
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            Document doc = new Document();
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
        performReplicationAfterForceMerge(false, SHARD_COUNT * (1 + REPLICA_COUNT));  
    protected Path absolutePath;  
        clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();
            .setId(Integer.toString(2))
        ensureYellow(INDEX_NAME);  
            .setSource("online", true, "bs", "X", "ts", System.currentTimeMillis() - 10000000, "type", "s")  
        CountDownLatch latch = new CountDownLatch(1);  
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {  
            assertTrue("replica should be promoted as a primary", replica_1.routingEntry().primary() || replica_2.routingEntry().primary());
        try (  
        final IndexShard replicaShard = getIndexShard(replica, INDEX_NAME);  
        ensureGreen(INDEX_NAME);
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/18157")  
    }
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", randomInt()).get();  
            final int additionalDocCount = scaledRandomIntBetween(0, 10);
import org.opensearch.action.search.SearchResponse;
        ensureGreen(INDEX_NAME);
        // expecting failure since we explicitly route request to a shard on which it doesn't exist
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
                        .put(indexSettings())
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
            .setVersion(true)
        // realtime termvectors (with routing set)  
        final int additionalDocCount = scaledRandomIntBetween(0, 10);
        refresh(INDEX_NAME);
        assertThat(mgetResponse.getResponses().length, is(3));  
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));
        final String nodeA = internalCluster().startDataAndWarmNodes(1).get(0);
    }
                assertAllocationIdsInReplicaShardStats(Set.of(second_replica_aid), shardStatsSet);
        ensureGreen(INDEX_NAME);
        waitForSearchableDocs(3, primaryNode, replicaNode);  
     * This tests that the max seqNo we send to replicas is accurate and that after failover  
            .setSource(jsonBuilder().startObject().field("field", "the quick brown fox jumps over the lazy dog").endObject())
            assertAcked(
        assertEquals(
            assertEquals("We should have stats returned for the replication group", 1, shardStats.size());
        ensureGreen(INDEX_NAME);
        assertTrue(blockFileStats.getTotal() > 0);
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
        // realtime termvectors (preference = _replica)
        client().prepareIndex(INDEX_NAME).setId("3").setSource("foo", "bar").get();
            .setId("2")
            .setRequestCache(false)
            primaryNode
        flushAndRefresh(INDEX_NAME);
        final String nodeA = internalCluster().startDataAndWarmNodes(1).get(0);
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
        assertWarmIndexDirectoryExistence(primary, index, false, customDataPath);  
        final String nodeB = internalCluster().startDataAndWarmNodes(1).get(0);
                .addAlias(new Alias("alias"))
                client().prepareIndex(INDEX_NAME)  
        GetResponse response = client(replica).prepareGet(indexOrAlias(), "1").get();
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
    }
            // drop the primary, this won't hand off pressure stats between old/new primary.  
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);  
            .actionGet();  
        });  
        assertTrue("FileCache should not be empty", replicaFileCache.size() > 0);
            client().prepareIndex(INDEX_NAME).setId(String.valueOf(i)).setSource("foo", "bar").get();  
            prepareCreate(INDEX_NAME).setMapping(mapping)  
        client().prepareIndex(INDEX_NAME).setId("4").setSource("baz", "baz").get();  
        createIndex(INDEX_NAME);
    public void testRestartPrimaryAndReplicaWithDocuments() throws Exception {
            ensureGreen(INDEX_NAME);
        Long initialSize = internalCluster().getInstance(Node.class, primary).fileCache().size();  
                1,  
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
        if (randomBoolean()) {  
        assertTrue(initialSize != 0);
            ClusterStatsResponse clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();  
        if (currentSize < initialSize) {
        assertBusy(() -> {
        assertThat(response.getSourceAsMap().get("foo").toString(), equalTo("bar"));  
            assertFalse("request shouldn't have forced a refresh", updateResponse.forcedRefresh());
                replica_2.getLatestReplicationCheckpoint().getSegmentInfosVersion()
    }  
        ensureGreen(INDEX_NAME);  
                Settings.builder().put("index.refresh_interval", -1).put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 1);
            .field("analyzer", "tv_test")  
        // index a doc.
            indexer.start(docCount);
                client(),
        ensureGreen(INDEX_NAME);  
        verifyStoreContent();
        FileCache fileCache = internalCluster().getInstance(Node.class, primary).fileCache();
            .setQuery(  
            // start another replica.  
            .field("term_vector", "with_positions_offsets_payloads")
                    "body",
            .field("analyzer", "tv_test")
import static org.opensearch.index.query.QueryBuilders.termQuery;
        nodes.add(replicaNode);  
                )  
        ensureYellow(INDEX_NAME);  
            .index(INDEX_NAME)
            .get();
import org.opensearch.cluster.ClusterState;
            final int additionalDocCount = scaledRandomIntBetween(0, 10);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
            );  
        nodes.add(internalCluster().startDataAndWarmNodes(1).get(0));
        for (int i = searchCount; i < searchCount * 2; i++) {
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
     * Tests a scroll query on the replica
            .setRouting(randomAlphaOfLength(2))  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;  
            .get();
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
        createIndex(INDEX_NAME);
                .setMaxNumSegments(1)
        XContentBuilder mapping = jsonBuilder().startObject()
    public void testClosedIndices() {
        }  
            .field("term_vector", "with_positions_offsets_payloads")  
            .cluster()
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        SearchResponse searchResponse = client(replica).prepareSearch()
    @Override  
     * This test verifies that segment replication does not fail for closed indices
                INDEX_NAME,
        if (randomBoolean()) {  
    }
            final int expectedHitCount = initialDocCount + additionalDocCount;  
        // opens a scrolled query before a flush is called.
                "_doc",  
                        .put(indexSettings())
                    .indices()  
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);  
import org.opensearch.action.termvectors.TermVectorsRequestBuilder;
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")  
                replicaNode_service.nodeStats().getShardStats().size()
            .get()
        assertThat(mgetResponse.getResponses()[1].getResponse().getSourceAsMap().get("foo2").toString(), equalTo("bar2"));
        // check replica is promoted to primary.
        // index another doc but don't refresh, we will ensure this is searchable once replica is promoted.
import org.apache.lucene.document.StringField;
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 2);
            client().admin()
                "_doc",
        createIndex(INDEX_NAME, settings);
            }
        ensureGreen(INDEX_NAME);  
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);  
            .put(EngineConfig.INDEX_CODEC_SETTING.getKey(), randomFrom(new ArrayList<>(CODECS) {  
 * This class runs Segment Replication Integ test suite with partial locality indices (warm indices).
        int expectedMaxSeqNo = initialDocCount + deletedDocCount + additionalDocs - 1;  
            .setRouting("Y")  
        client().prepareIndex(indexOrAlias()).setId("1").setSource("foo", "bar").setRouting(id).get();
            .endObject();  
        // index doc 1  
        final String primary = internalCluster().startWarmOnlyNodes(1).get(0);  
            waitForDocs(expectedHitCount, indexer);
        final List<String> nodes = new ArrayList<>();
            );
                client(),  
            .setRouting(routingOtherShard)
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);  
        ensureGreen(INDEX_NAME);
        waitForSearchableDocs(2, nodes);
                    .field("type", "keyword")
        }
                client(),
        logger.info("--> Collect all scroll query hits");  
        final String nodeA = internalCluster().startDataAndWarmNodes(1).get(0);
            .endObject()
import org.opensearch.action.update.UpdateResponse;  
            .setPayloads(true)
        waitForSearchableDocs(initialDocCount, replica, primary);  
        assertTrue(mgetResponse.getResponses()[1].isFailed());
import org.opensearch.search.sort.SortOrder;
        assertThat(fields.size(), equalTo(1));
        try (
        final int docCount = scaledRandomIntBetween(0, 10);
        // non realtime get 1
            waitForSearchableDocs(initialDocCount, dataNodes);  
import static org.opensearch.index.query.QueryBuilders.boolQuery;  
            .execute()
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
    }  
        refresh(INDEX_NAME);
        // Ingesting docs again before force merge  
                    .getShardStats()
    @Before
     * @throws Exception when issue is encountered
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
import org.opensearch.test.BackgroundIndexer;
            )  
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
            refresh(INDEX_NAME);  
                random()  
            doc.add(  
    public void testReplicaAlreadyAtCheckpoint() throws Exception {
        final long expectedHitCount = initialDocCount + additionalDocs - deletedDocCount;
            .setIndices(INDEX_NAME)  
                    .startObject("properties")  
                    .endObject()  
            .filter(routing -> routing.primary() == false)  
        logger.info("Local segments after force merge and commit {}", getLatestSegmentInfos(replicaShard).files(false));  
                assertTrue(Files.exists(shardDataPath));
                client(),
    }
        final IndexShard replicaAfterFailure = getIndexShard(replicaNode, INDEX_NAME);
    /**  
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
        }
            .getId();
            // fetch pressure stats from the Primary's Node.  
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
        // index doc 1
        }
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
    private void setup() {  
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
        final Index index = resolveIndex(INDEX_NAME);
import org.opensearch.common.action.ActionFuture;
            .setId(Integer.toString(1))
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/18157")
            .shardsWithState(ShardRoutingState.STARTED)
            .setId("3")  
                    .execute()
            .actionGet();  
        final ShardRouting replicaShardRouting = getShardRoutingForNodeName(replica);
            // get shard references.  
        assertFalse(mgetResponse.getResponses()[0].getResponse().isExists());  
            .setPreference(Preference.REPLICA.type())
import java.nio.file.Files;
                    .setId(Integer.toString(i))
        assertEquals(getNodeContainingPrimaryShard().getName(), primary);
        TermVectorsResponse response = client(replica).prepareTermVectors(indexOrAlias(), "1").get();  
            assertEquals(2, updateResponse.getVersion());
        );  
        // Drop the primary and wait until replica is promoted.  
            doc.add(new SortedDocValuesField("dv", new BytesRef(TestUtil.randomRealisticUnicodeString(random()))));
            flushAndRefresh(INDEX_NAME);
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        // this test cancels allocation on the primary - promoting the new replica and recreating the former primary as a replica.
            indexer.start(additionalDocCount);
            indexer.start(initialDocCount);
     * This tests that if a primary receives docs while a replica is performing round of segrep during recovery  
        final Settings settings = Settings.builder()
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
    public void testScrollCreatedOnReplica() throws Exception {
        assertBusy(() -> {
                false,
        assertFalse(response.isExists());
            client().prepareIndex(INDEX_NAME).setId("2").setSource("foo2", randomInt()).get();  
                connection.sendRequest(requestId, action, request, options);  
            )
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").get();
            );
            assertTrue("indices cache path should " + (exists ? "exist" : "not exist"), Files.exists(indicesCacheDataPath) == exists);
        client().prepareIndex(INDEX_NAME).setId("2").setSource("foo2", "bar2").setRouting(id).get();  
            flushAndRefresh(INDEX_NAME);
        assertFalse(mgetResponse.getResponses()[0].isFailed());
import org.opensearch.index.codec.CodecService;  
        final String id = routingKeyForShard(INDEX_NAME, 0);
                INDEX_NAME,
        assertDocCounts(2, secondWarmNode, thirdWarmNode);
        assertAcked(
                false,
/*  
        assertThat(mgetResponse.getResponses().length, is(2));  
            waitForDocs(initialDocCount, indexer);
            )
        // start 1st node so that it contains the primary  
            );  
        verifyStoreContent();  
                .indices()  
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build());  
            .build();
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            .setQuery(matchAllQuery())
            ensureYellow(INDEX_NAME);
                    .startObject("bs")  
        // create the cluster with one primary node containing primary shard and replica node containing replica shard
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
        response = client(replica).prepareGet(indexOrAlias(), "2").setRouting(id).get();  
            ensureYellowAndNoInitializingShards(INDEX_NAME);
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
        assertFalse(mgetResponse.getResponses()[0].getResponse().isExists());  
            .setSource(jsonBuilder().startObject().field("field", 0).endObject())
        client().prepareIndex(INDEX_NAME).setId("2").setSource("bar", "baz").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
        assertNotNull(replicaShardRouting);  
                    .execute()
        final int searchCount = randomIntBetween(1, 2);
    public void testMultipleShards() throws Exception {
            .setRouting(randomAlphaOfLength(2))
        ensureGreen(INDEX_NAME);  
                random()
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
    private void assertAllocationIdsInReplicaShardStats(Set<String> expected, Set<SegmentReplicationShardStats> replicaStats) {
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
        assertEquals(getNodeContainingPrimaryShard().getName(), primary);
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
            .get();
        // stop the primary node - we only have one shard on here.
                SegmentReplicationPressureService.class,
    }
        }, 30, TimeUnit.SECONDS);
            assertTrue(replicaNode_service.nodeStats().getShardStats().isEmpty());
        final String primary = internalCluster().startWarmOnlyNodes(1).get(0);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            .findFirst()
                    .endObject()
        ensureYellow(INDEX_NAME);
        for (int i = 1; i < 5; i++) {  
        ensureGreen(INDEX_NAME);
        assertTrue(mgetResponse.getResponses()[2].isFailed());
                .indices()
            .setSize(10)
        createIndex(INDEX_NAME);
            indexer.start(initialDocCount);  
            .setTimeout(new TimeValue(5, TimeUnit.MINUTES))  
                        .put("index.refresh_interval", -1)
                .setSource(jsonBuilder().startObject().field("field", i).endObject())  
        // Get replica allocation id
        CountDownLatch blockFileCopy = new CountDownLatch(1);
        Settings.Builder featureSettings = Settings.builder();
        assertBusy(() -> {
            .prepareReroute()  
        final Path cacheDataPath = node.getNodeEnvironment().fileCacheNodePath().fileCachePath.resolve(index.getUUID());
        // non realtime termvectors 1
    }
                    .setId(Integer.toString(i))
            client().admin()
            assertThat(forceMergeResponse.getFailedShards(), is(0));
        createIndex(INDEX_NAME, settings);
            prepareCreate(INDEX_NAME).setSettings(  
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        Set<String> latestCommitSegments = new HashSet<>(replicaShard.store().readLastCommittedSegmentsInfo().files(false));
            .put(super.indexSettings())
        internalCluster().restartNode(primary);
        );
                -1,  
                .setId(String.valueOf(i))
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            writer.flush();  
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);  
                random()
                RandomizedTest.scaledRandomIntBetween(2, 5),  
            writer.commit();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import org.apache.lucene.index.Fields;  
            flush(INDEX_NAME);
        client().prepareClearScroll().addScrollId(searchResponse.getScrollId()).get();  
            refresh(INDEX_NAME);
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 3);
        assertTrue(response.isExists());
        }  
        client().prepareIndex(INDEX_NAME).setId("2").setSource("foo", "bar").get();
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),  
            indexer.start(initialDocCount);  
        final Settings settings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build();  
        assertBusy(() -> {
    }
            .endObject();
        waitForSearchableDocs(1, primaryNode, replicaNode, replicaNode2);  
            .getId();
            .setScroll(TimeValue.timeValueDays(1))  
import org.opensearch.index.store.remote.filecache.FileCacheStats;
                        boolQuery().should(  
 */  
        final int initialDocCount = scaledRandomIntBetween(1, 5);
            }
        return true;  
        assertBusy(() -> {  
        waitForSearchableDocs(4, primaryNode, replicaNode);
            refresh(INDEX_NAME);
        }  
        createIndex(INDEX_NAME);
            assertEquals(0L, replicationStats.maxReplicationLag);  
        }
    @After  
        assertThat(response.getIndex(), equalTo(INDEX_NAME));
        final IndexShard replicaShard = getIndexShard(replica, INDEX_NAME);
     */  
        ensureGreen(INDEX_NAME);
        });
import org.apache.lucene.document.SortedDocValuesField;  
        // index doc 1
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.action.index.IndexResponse;  
        client().prepareIndex(indexOrAlias()).setId("2").setSource("foo2", "bar2").setRouting(id).get();  
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
            );
import org.apache.lucene.tests.util.TestUtil;
        // ToDo: verifyStoreContent() needs to be fixed for warm indices
            SegmentReplicationPressureService replicaNode_service = internalCluster().getInstance(
                .put(indexSettings())
        // start 2nd node so that it contains the replica
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
            final Map<ShardId, SegmentReplicationPerGroupStats> shardStats = pressureService.nodeStats().getShardStats();  
                .indices()  
        createIndex(  
                "We should have stats returned for the replication group",
        response = resp.execute().actionGet();  
                    .endObject()  
        logger.info("--> Close index");
        // realtime multi get 1 (routing set)
        client().prepareIndex(INDEX_NAME)
        waitForSearchableDocs(2, primary, replica);  
        assertAcked(  
    public void testReplicationPostDeleteAndForceMerge() throws Exception {
                    )  
        }
        ensureGreen(INDEX_NAME);
                    .must(
        ensureGreen(INDEX_NAME);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;  
        }
        assertEquals(1, scrollHits);
                -1,
            .allocationId()
                    .field("type", "boolean")
        final List<String> dataNodes = internalCluster().startDataAndWarmNodes(6);
import org.opensearch.core.xcontent.XContentBuilder;  
            .setFrom(0)  
            assertEquals(
        mgetResponse = client(replica).prepareMultiGet()  
            .execute()
            } else {  
            assertThat(forceMergeResponse.getSuccessfulShards(), is(expectedSuccessfulShards));
            // don't wait for replication to complete, stop the primary immediately.
            prepareCreate(INDEX_NAME).setSettings(Settings.builder().put("index.refresh_interval", -1).put(indexSettings()))
import org.opensearch.index.store.remote.filecache.FileCache;  
import org.opensearch.index.SegmentReplicationPerGroupStats;  
            verifyStoreContent();
        ).get();
            flush(INDEX_NAME);
        final int initialDocCount = scaledRandomIntBetween(1, 10);
                )
            .setId(Integer.toString(1))
    }
        // waitForSearchableDocs(initialDocCount, replica, primary);  
        client().admin()
     * Tests whether segment replication supports realtime get requests and reads and parses source from the translog to serve strong reads.
        } else {  
                RandomizedTest.scaledRandomIntBetween(2, 5),  
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
import static java.util.Arrays.asList;
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath))  
                "_doc",
            BackgroundIndexer indexer = new BackgroundIndexer(
        client().prepareIndex(INDEX_NAME).setId("2").setSource("foo", "bar").get();
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();  
        performReplicationAfterForceMerge(true, SHARD_COUNT);
                random()  
        assertBusy(  
            // empty.
        if (randomBoolean()) {
                    .setRefreshPolicy(refreshPolicy)
    public void testIndexReopenClose() throws Exception {  
        assertEquals(getNodeContainingPrimaryShard().getName(), replica);  
            .setRouting("X")
            indexer.start(initialDocCount);  
        segmentReplicationSourceService.beforeIndexShardClosed(primaryShard.shardId(), primaryShard, indexSettings());
        response = resp.execute().actionGet();  
        createIndex(INDEX_NAME, settings);  
            waitForSearchableDocs(initialDocCount, primary, replica);  
import org.opensearch.core.common.unit.ByteSizeValue;  
import org.opensearch.index.SegmentReplicationPressureService;
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        );
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        try (
        assertThat(mgetResponse.getResponses().length, is(2));  
        final int additionalDocs = randomIntBetween(1, 5);
        TermVectorsRequestBuilder resp = client().prepareTermVectors(indexOrAlias(), Integer.toString(1))  
        // wait for replication to complete
            String docId = String.valueOf(initialDocCount + 1);  
        logger.info("Relocating shard from {} to {}", primary, thirdWarmNode);
import org.apache.lucene.document.Document;
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/17526")  
        );  
            .execute()
            .setOffsets(true)
            refresh(INDEX_NAME);
            waitForDocs(initialDocCount, indexer);
                    TestUtil.randomRealisticUnicodeString(random()),  
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        ClusterHealthResponse clusterHealthResponse = client.admin()
        }  
        }  
        String secondWarmNode = internalTestCluster.startWarmOnlyNodes(1).get(0);
        fields = response.getFields();  
 * The OpenSearch Contributors require contributions made to  
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
    }  
                -1,  
    protected Settings nodeSettings(int nodeOrdinal) {
            });
     */
        final ShardPath shardPath = ShardPath.loadShardPath(logger, node.getNodeEnvironment(), shardId, customDataPath);  
            .setSelectedFields();
import org.opensearch.test.transport.MockTransportService;  
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        }  
            waitForDocs(docCount, indexer);  
            indexer.start(additionalDocCount);
        assertHitCount(client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 3);
 */  
        final Client client = client();
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));
        final WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());  
        latch.countDown();
import org.opensearch.transport.client.Requests;  
            .setSize(10)
        assertThat("doc id: " + 1 + " doesn't exists but should", response.isExists(), equalTo(true));
    }
        assertThat(response.getSourceAsMap().get("foo2").toString(), equalTo("bar2"));  
                            boolQuery().must(rangeQuery("ts").lt(System.currentTimeMillis() - (15 * 1000))).must(termQuery("type", "bs"))
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            ).addAlias(new Alias("alias"))
        long scrollHits = 0;
    private static String indexOrAlias() {
            () -> assertEquals(
        try (  
        response = client(replica).prepareGet(indexOrAlias(), "1").get();  
    public void testReplicationAfterForceMerge() throws Exception {
                primaryShard.getLatestReplicationCheckpoint().getSegmentInfosVersion(),
            }
        client().prepareIndex(indexOrAlias()).setId("1").setSource("foo", "bar").setRouting(id).get();
            flush(INDEX_NAME);
            )
        final SearchResponse searchResponse = client().prepareSearch()
        createIndex(INDEX_NAME);  
import java.util.HashSet;
            .setExplain(true)
        replicaShard.finalizeReplication(segmentInfos);
        MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(  
    }
        refresh();  
                -1,  
            refresh(INDEX_NAME);
        client().prepareIndex(INDEX_NAME).setId("3").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        // start a replica node, initially will be empty with no shard assignment.  
        assertTrue(currentSize != 0);  
        final Settings settings = Settings.builder()
            waitForSearchableDocs(expectedHitCount, nodeA, nodeB);
        final Set<String> snapshottedSegments = new HashSet<>(latestSegmentInfos.files(false));
     */
            .get();
            waitForSearchableDocs(initialDocCount, nodeA, nodeB);
        assertFalse(response.isExists());
                .build()
            // test a checkpoint without any new segments
        if (!warmIndexSegmentReplicationEnabled()) {
            .setRouting(id)  
                jsonBuilder().startObject()
            .setSource("online", false, "bs", "Y", "ts", System.currentTimeMillis() - 100, "type", "s")
        assertFalse(response.isExists());  
import org.opensearch.core.index.Index;
        );
            assertTrue(replicaStats.isEmpty());
            primaryNode  
import java.util.Arrays;
        assertThat(mgetResponse.getResponses()[2].getFailure().getMessage(), is("no such index [nonExistingIndex]"));
            if (!warmIndexSegmentReplicationEnabled()) {
    protected static final String REPOSITORY_NAME = "test-remote-store-repo";
import com.carrotsearch.randomizedtesting.RandomizedTest;
                "We should have stats returned for the replication group",  
import org.opensearch.common.Priority;
import java.util.concurrent.TimeUnit;  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2))
     * from xlog.
        MultiGetResponse mgetResponse = client().prepareMultiGet()  
                INDEX_NAME,  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
    public void testRestartPrimary_NoReplicas() throws Exception {
        refresh(INDEX_NAME);
                    .prepareUpdateSettings(INDEX_NAME)
        assertThat(mgetResponse.getResponses()[1].getIndex(), is(INDEX_NAME));
        );  
            .setScroll(TimeValue.timeValueDays(1))  
            assertEquals(replica_entry.getCheckpointsBehindCount(), 0);  
        internalTestCluster.startClusterManagerOnlyNode();
            assertTrue(response.getHits().getTotalHits().value() >= 1);
            String replicaNode_2 = internalCluster().startDataAndWarmNodes(1).get(0);
            docs.add(doc);
        return featureSettings.build();  
        assertFalse(mgetResponse.getResponses()[0].isFailed());
            refresh(INDEX_NAME);
            replicaStats = replicaNode_service.nodeStats().getShardStats().get(replicaShard.shardId()).getReplicaStats();  
            BackgroundIndexer indexer = new BackgroundIndexer(
        assertNotEquals(replicaAfterFailure.routingEntry().allocationId().getId(), replicaShard.routingEntry().allocationId().getId());  
        waitForSearchableDocs(3, primary, replica);  
            .get();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // index doc 1
        final String id = routingKeyForShard(INDEX_NAME, 0);
        ensureGreen(INDEX_NAME);  
        final ShardRouting replicaShardRouting = getShardRoutingForNodeName(replica);
        internalCluster().restartNode(primary);
            UpdateResponse updateResponse = client(primary).prepareUpdate(INDEX_NAME, id)  
                .put(indexSettings())  
        });
            Settings.builder()
            // after the primary is dropped and replica is promoted we won't have a replica assigned yet, so stats per replica should return
        ) {  
import org.opensearch.index.ReplicationStats;
    public void teardown() throws Exception {
import org.opensearch.index.engine.EngineConfig;
            assertWarmIndexDirectoryExistence(thirdWarmNode, index, false, customDataPath);
            Set<String> ids = indexer.getIds();
        return Settings.builder()
     */  
        Settings indexSettings = Settings.builder()  
    public void testPrimaryReceivesDocsDuringReplicaRecovery() throws Exception {  
        }
                RandomizedTest.scaledRandomIntBetween(2, 5),  
import org.opensearch.cluster.routing.ShardRouting;  
                    .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        ensureGreen(INDEX_NAME);  
                "_doc",
        final String primaryNode = internalCluster().startDataAndWarmNodes(1).get(0);
        // multi get non realtime 1
        // new primary should have at least the doc count from the first set of segments.
        String thirdWarmNode = internalTestCluster.startWarmOnlyNodes(1).get(0);
        ensureGreen(INDEX_NAME);  
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        InternalTestCluster internalTestCluster = internalCluster();  
        waitForSearchableDocs(initialDocCount, replica, primary);
    }  
            .cluster()
            ensureGreen(INDEX_NAME);
            );  
        // this is for testing scroll segment consistency between refresh and flush  
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);  
            .findFirst()
        client().prepareIndex(INDEX_NAME)  
            client().prepareIndex(INDEX_NAME)
        try (
                )
    public void testDropPrimaryDuringReplication() throws Exception {
        assertThat(mgetResponse.getResponses().length, is(2));
        FileCacheStats blockFileStats = aggregateStats.getBlockFileCacheStats();
            dataNodes.add(internalCluster().startDataAndWarmNodes(1).get(0));
                RandomizedTest.scaledRandomIntBetween(2, 5),
            .setSelectedFields();  
            .setSelectedFields();
                .prepareForceMerge(INDEX_NAME)
                RandomizedTest.scaledRandomIntBetween(2, 5),
        final int initialDocCount = scaledRandomIntBetween(0, 10);  
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
                boolQuery().must(termQuery("online", true))
            .index(INDEX_NAME)  
     * Tests whether segment replication supports realtime termvector requests and reads and parses source from the translog to serve strong reads.
        waitForSearchableDocs(initialDocCount, primary, replica);
            client().prepareIndex(INDEX_NAME).setId(String.valueOf(i)).setSource("foo", "bar").get();
import org.opensearch.common.util.set.Sets;
            "All snapshotted files should be deleted",
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.document.TextField;
        }
    }  
                -1,
                replicaNode_service.nodeStats().getShardStats().size()
        }  
            BackgroundIndexer indexer = new BackgroundIndexer(
                RandomizedTest.scaledRandomIntBetween(2, 5),
        FlushRequest request = new FlushRequest(INDEX_NAME);  
        ensureGreen(INDEX_NAME);  
            () -> assertEquals(
                random()
        nodes.add(internalCluster().startDataAndWarmNodes(1).get(0));
import org.opensearch.action.termvectors.TermVectorsResponse;
     */  
            .setPositions(true)  
            )
    private void performReplicationAfterForceMerge(boolean primaryOnly, int expectedSuccessfulShards) throws Exception {
                .setFlush(false)
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
    @Override
                random()  
            ).addAlias(new Alias("alias"))
        // realtime termvectors 2 with routing
        client().prepareIndex(INDEX_NAME).setId(String.valueOf(expectedMaxSeqNo + 1)).setSource("another", "doc").get();
    /**
        final String customDataPath = IndexMetadata.INDEX_DATA_PATH_SETTING.get(
        // non realtime termvectors 1
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);
        final List<ActionFuture<SearchResponse>> pendingSearchResponse = new ArrayList<>();
     */  
                RandomizedTest.scaledRandomIntBetween(2, 5),
import org.opensearch.cluster.routing.Preference;
        assertWarmIndexDirectoryExistence(secondWarmNode, index, true, customDataPath);
            .add(new MultiGetRequest.Item(INDEX_NAME, "1"))
        try (  
        final int initialDocCount = scaledRandomIntBetween(1, 5);
            assertEquals(
    public void testCancellation() throws Exception {  
        waitForRelocation(ClusterHealthStatus.GREEN);  
        ) {
            BackgroundIndexer indexer = new BackgroundIndexer(  
        assertThat(mgetResponse.getResponses()[0].getIndex(), is(INDEX_NAME));
            );  
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
            ensureGreen(INDEX_NAME);  
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);  
        final String replicaNode = internalCluster().startDataAndWarmNodes(1).get(0);
        ensureGreen(INDEX_NAME);
                final Set<SegmentReplicationShardStats> shardStatsSet = replicaNode_service.nodeStats()  
    public void testIndexWhileRecoveringReplica() throws Exception {
            .add(new MultiGetRequest.Item(INDEX_NAME, "1").routing(routingOtherShard))  
            if (!warmIndexSegmentReplicationEnabled()) {
                logger.debug("Verifying shard paths exist for node: {}", nodeName);  
        final String id = routingKeyForShard(INDEX_NAME, 0);  
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
        final Node node = internalCluster().getInstance(Node.class, nodeName);  
                Settings.builder().put("index.refresh_interval", -1).put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
import java.util.Collections;  
            refresh(INDEX_NAME);
        // index doc 2
            verifyStoreContent();  
            )
    protected Settings featureFlagSettings() {  
        assertFalse(response.isExists());  
            waitForDocs(initialDocCount, indexer);  
            Sets.intersection(filesAfterClearScroll, snapshottedSegments)
    }
        ensureYellow(INDEX_NAME);  
                    .getReplicaStats();  
        assertBusy(() -> {  
        final String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        assertFalse(mgetResponse.getResponses()[1].isFailed());  
        ensureGreen(INDEX_NAME);  
    }
import org.opensearch.action.search.SearchType;
        assertEquals(getNodeContainingPrimaryShard().getName(), primary);
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime termvectors
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));  
}
            }  
        final String replica = internalCluster().startDataAndWarmNodes(1).get(0);  
        assertNoFailures(response);
                client(),
            .add(new MultiGetRequest.Item(INDEX_NAME, "1"))
import org.apache.lucene.document.Field;
                // we want to control refreshes
        final String routingOtherShard = routingKeyForShard(INDEX_NAME, 1);  
            .get();
        assertFalse(response.isExists());  
            .setId("4")
        } else {  
        client.admin()  
    @Override
            .setId("1")
        try (
    public void testPressureServiceStats() throws Exception {
        client().prepareIndex(INDEX_NAME).setId("3").setSource("bar", "baz").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
        ) {
            INDEX_NAME,
            assertEquals(0L, replicationStats.totalBytesBehind);
        }
            waitForDocs(initialDocCount, indexer);  
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), 2);
        assertAcked(
            assertTrue("replica should be promoted as a primary", replicaShard.routingEntry().primary());
            ensureGreen(INDEX_NAME);
                "_doc",  
import java.io.IOException;
            }
    public void testRestartPrimary() throws Exception {  
        assertHitCount(client(replica).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), expectedHitCount + 1);  
            .actionGet();
                getIndexShard(primary, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        waitForSearchableDocs(initialDocCount, replica, primary);
        List<Document> docs = new ArrayList<>();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        assertFalse(response.isExists());
    }
        request.force(true);
        do {
        final Settings settings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build();
        ensureGreen(INDEX_NAME);  
    /**  
        // refresh interval disabled to ensure refresh rate of index (when data is ready for search) doesn't affect realtime multi get  
                assertEquals(false, Files.exists(shardStatePath));
            assertAllocationIdsInReplicaShardStats(Set.of(replicaShard.routingEntry().allocationId().getId()), replicaStats);
            assertSearchHits(client(replica).prepareSearch(INDEX_NAME).setQuery(matchQuery("foo", "baz")).get(), id);
        ensureYellow(INDEX_NAME);
        assertBusy(() -> {
            waitForDocs(initialDocCount, indexer);
            .add(new MoveAllocationCommand(INDEX_NAME, 0, primary, thirdWarmNode))  
                replicaNode  
        // index more docs and force merge down to 1 segment
            Set<String> ids = indexer.getIds();
            .setRouting(id)
            internalCluster().getInstance(TransportService.class, replicaNode),
            .setIndices(INDEX_NAME)
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            verifyStoreContent();
import static org.opensearch.index.query.QueryBuilders.rangeQuery;  
                INDEX_NAME,  
            .filter(routing -> routing.primary())
            assertTrue(pendingSearchResponse.stream().allMatch(ActionFuture::isDone));
    }  
            flush(INDEX_NAME);
import org.opensearch.transport.TransportService;
            client(primary).prepareDelete(INDEX_NAME, String.valueOf(i)).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
            refresh(INDEX_NAME);  
        // Test stats
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
    }  
    }  
        // Refresh, this should trigger round of segment replication
            SegmentReplicationSourceService.class,
                verifyStoreContent();  
            waitForSearchableDocs(initialDocCount, asList(primary, replica));
        }
        if (shardPath == null) {
        final int docCount = scaledRandomIntBetween(10, 20);
 * compatible open source license.
            waitForSearchableDocs(initialDocCount + 1, dataNodes);
            .get();  
            flush(INDEX_NAME);
            .put(indexSettings())
        logger.info("---> restarting primary node");
            TransportService.class,
            SegmentReplicationPressureService pressureService = internalCluster().getInstance(
            client().admin().indices().prepareRefresh().execute().actionGet();  
                "_doc",  
        verifyStoreContent();
            primaryNode
            )
            .endObject()  
        }, 1, TimeUnit.MINUTES);  
                .addAlias(new Alias("alias"))
    }  
        ensureYellow(INDEX_NAME);
        assertWarmIndexDirectoryExistence(secondWarmNode, index, true, customDataPath);
                }  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .setSource("online", false, "ts", System.currentTimeMillis() - 100, "type", "bs")
                RandomizedTest.scaledRandomIntBetween(2, 5),  
        final String id = routingKeyForShard(INDEX_NAME, 0);
                connection.sendRequest(requestId, action, request, options);
                writer.addDocument(d);
        ensureYellow(INDEX_NAME);
        }
        client().prepareIndex(INDEX_NAME)
            TransportService.class,  
                INDEX_NAME,  
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);
import org.opensearch.index.shard.ShardPath;  
            logger.info("Checking cache paths for node: {}", nodeName);
        createIndex(INDEX_NAME, super.indexSettings());
                RandomizedTest.scaledRandomIntBetween(2, 5),
                    .endObject()
            .prepareHealth()  
        ) {
    }
            prepareCreate(INDEX_NAME).setMapping(mapping)
        refresh(INDEX_NAME);
                getIndexShard(replica, INDEX_NAME).getLatestReplicationCheckpoint().getSegmentInfosVersion()
