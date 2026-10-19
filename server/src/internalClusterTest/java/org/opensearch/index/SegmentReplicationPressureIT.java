        }
        final CountDownLatch latch = new CountDownLatch(1);
import static org.opensearch.index.SegmentReplicationPressureService.MAX_INDEXING_CHECKPOINTS;
        assertReplicaCheckpointUpdated(primaryShard);
            // index again while we are stale.
                    .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 2))  
                    indexDoc();
    }
            assertBusy(() -> { assertFailedRequests(executeBulkRequest(nodes, randomIntBetween(1, 200))); });  
            .put(MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING.getKey(), TimeValue.timeValueMillis(1000))  
            }
            assertAcked(
            SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
            latch.await();
            // try and index again while we are stale.
                .allMatch((failure) -> failure.getStatus() == RestStatus.TOO_MANY_REQUESTS)
        final AtomicInteger totalDocs = new AtomicInteger(0);
            indexingThread.start();  
            indexingThread.start();  
            Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build()
            // Verify that replica shard is closed.
        List<String> replicaNodes = new ArrayList<>();
import java.util.concurrent.CountDownLatch;
        refresh(INDEX_NAME);
            final IndexShard replicaShard = getIndexShard(replicaName, INDEX_NAME);
            .build();
        final String primaryNode = internalCluster().startNode(settings);
import java.util.Collections;  
import java.util.concurrent.TimeUnit;  
            totalDocs.incrementAndGet();
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        totalDocs.getAndSet(indexUntilCheckpointCount());  
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
        assertReplicaCheckpointUpdated(primaryShard);
        Settings settings = Settings.builder()
    }  
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        final String coordinator = internalCluster().startCoordinatingOnlyNode(Settings.EMPTY);
    public void testBulkWritesRejected() throws Exception {
                expectThrows(OpenSearchRejectedExecutionException.class, () -> {
            Thread indexingThread = new Thread(() -> totalDocs.getAndSet(indexUntilCheckpointCount()));
    private void assertFailedRequests(BulkResponse response) {
        assertNotEquals(replicaAfterFailure.routingEntry().allocationId().getId(), replicaShard.routingEntry().allocationId().getId());
    public void testWritesRejected() throws Exception {  
}  
            totalDocs.getAndSet(indexUntilCheckpointCount());  
        final CountDownLatch latch = new CountDownLatch(1);
        verifyStoreContent();
        }
    }
        int docsPerBatch = randomIntBetween(1, 200);
        // index another doc showing there is no pressure enforced.
import org.opensearch.indices.replication.common.ReplicationType;
        final AtomicInteger totalDocs = new AtomicInteger(0);  
        final String replicaNode = internalCluster().startNode();  
        createIndex(INDEX_NAME);
            assertBusy(() -> {
            refresh(INDEX_NAME);  
            .put(super.nodeSettings(nodeOrdinal))
                    totalDocs.incrementAndGet();
            indexingThread.join();
import static java.util.Arrays.asList;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)
        createIndex(  
        int totalDocs = docsPerBatch * MAX_CHECKPOINTS_BEHIND;  
        refresh(INDEX_NAME);  
import org.opensearch.action.bulk.BulkRequest;  
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);  
                primaryShard.getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        assertTrue(Arrays.stream(response.getItems()).allMatch(BulkItemResponse::isFailed));  
        }  
        // wait for the replicas to catch up after block is released.  
            totalDocs.incrementAndGet();
import org.opensearch.action.index.IndexRequest;
    }
        try (final Releasable ignored = blockReplication(replicaNodes.subList(0, 1), latch)) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    private void indexDoc() {
    /**
        // Starts a primary and replica node.
            bulkRequest.add(request);
        refresh(INDEX_NAME);
                    totalDocs.incrementAndGet();
        try (final Releasable ignored = blockReplication(replicaNodes, latch)) {
            SegmentReplicationPerGroupStats perGroupStats = segmentReplicationStatsResponse.getReplicationStats().get(INDEX_NAME).get(0);
import org.opensearch.common.unit.TimeValue;
import java.util.Collection;
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    private void assertEqualSegmentInfosVersion(List<String> replicaNames, IndexShard primaryShard) {  
        verifyStoreContent();
                .execute()
        }  
            refresh(INDEX_NAME);
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), totalDocs.get());
    /**  
            .put(super.indexSettings())
 */  
                .actionGet();  
        final List<String> replicaNodes = asList(replicaNode);
            assertBusy(() -> {
        refresh(INDEX_NAME);
                indexDoc();  
    @Override
        }  
        final AtomicInteger totalDocs = new AtomicInteger(0);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
     * Index and Refresh in batches to force checkpoints behind.
                .prepareSegmentReplicationStats(INDEX_NAME)  
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
        return asList(MockTransportService.TestPlugin.class);  
import org.opensearch.test.transport.MockTransportService;
            // Verify the rejected doc count.  
        return Settings.builder()
        // only block a single replica, pressure should not get applied.  
                .setDetailed(true)
        waitForSearchableDocs(totalDocs.incrementAndGet(), replicaNodes.toArray(new String[] {}));
        final CountDownLatch latch = new CountDownLatch(1);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            indexingThread.start();  
        ensureGreen(INDEX_NAME);
            .put(MAX_INDEXING_CHECKPOINTS.getKey(), MAX_CHECKPOINTS_BEHIND)
        // Starts a primary and replica node.
    private int indexUntilCheckpointCount() {
public class SegmentReplicationPressureIT extends SegmentReplicationBaseIT {
            assertBusy(() -> { assertTrue(replicaShard.state().equals(IndexShardState.CLOSED)); }, 1, TimeUnit.MINUTES);
 * SPDX-License-Identifier: Apache-2.0
    }
            );
        final List<String> replicaNodes = asList(replicaNode);
                indexDoc();
            Arrays.stream(response.getItems())
            // Try to index one more doc.
            INDEX_NAME,
        return Settings.builder()  
    protected Settings nodeSettings(int nodeOrdinal) {  
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
        for (int j = 0; j < docsPerBatch; ++j) {
        final AtomicInteger totalDocs = new AtomicInteger(0);  
                refresh(INDEX_NAME);  
        // we want to control refreshes
        try (final Releasable ignored = blockReplication(replicaNodes, latch)) {
    @Override  
        ensureGreen(INDEX_NAME);  
            refresh(INDEX_NAME);  
    public void testAddReplicaWhileWritesBlocked() throws Exception {
                .indices()
        Settings settings = Settings.builder()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
    public void testWithDocumentReplicationEnabledIndex() throws Exception {
import org.opensearch.plugins.Plugin;
import static org.opensearch.index.SegmentReplicationPressureService.SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED;
        waitForSearchableDocs(totalDocs * 2L, replicaNodes.toArray(new String[] {}));
     * Ensuring that only write requests are blocked.  
        IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);  
            );  
    public void testFailStaleReplica() throws Exception {
        return total;
            final int numDocs = randomIntBetween(1, 5);
        // index another doc showing there is no pressure enforced.  
    }  
        // Verify that new replica shard after failure is different from old replica shard.
        }
        final String primaryNode = internalCluster().startNode();  
        final CountDownLatch latch = new CountDownLatch(1);
                    .indices()
     * This test ensures that a replica can be added while the index is under write block.
    }  
        verifyStoreContent();
            indexingThread.join();
        final String primaryNode = internalCluster().startNode();
        // wait for the replicas to catch up after block is released.
        for (String replicaName : replicaNames) {
        assertEqualSegmentInfosVersion(replicaNodes, primaryShard);  
            final String replica_2 = internalCluster().startNode();
        final String primaryNode = internalCluster().startNode();
import org.opensearch.action.bulk.BulkItemResponse;
    public void testBelowReplicaLimit() throws Exception {
            assertEquals(  
            });
            totalDocs.incrementAndGet();
        // Index docs until replica stale limit is reached.
        final BulkResponse bulkItemResponses = client(randomFrom(nodes)).bulk(bulkRequest).actionGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            for (int j = 0; j < numDocs; ++j) {
                totalDocs.incrementAndGet();
        final String primaryNode = internalCluster().startNode(settings);  
            total += numDocs;
                    executeBulkRequest(nodes, docsPerBatch);
            });
import org.opensearch.index.shard.IndexShardState;
     * Asserts that there are no stale replicas according to the primary until cp count is reached.
 * Copyright OpenSearch Contributors.
        assertEqualSegmentInfosVersion(replicaNodes, primaryShard);
        createIndex(INDEX_NAME);
            refresh(INDEX_NAME);
    private static final int MAX_CHECKPOINTS_BEHIND = 2;  
        createIndex(INDEX_NAME);
        int total = 0;
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
            });  
        indexDoc();
            latch.await();
            segmentReplicationWithRemoteEnabled()
    }
            refresh(INDEX_NAME);
            // index again while we are stale.  
        }
import java.util.ArrayList;  
import org.opensearch.common.settings.Settings;  
            "Skipping the test as its not compatible with segment replication with remote store. Cannot create DocRep indices with Remote store enabled",
        final String replicaNode = internalCluster().startNode();
            indexDoc();  
        List<String> nodes = List.of(primaryNode, replicaNode, coordinator);  
        refresh(INDEX_NAME);  
        final String replicaNode = internalCluster().startNode(settings);  
import java.util.concurrent.atomic.AtomicInteger;
        replicaNodes.add(replicaNode);
    private BulkResponse executeBulkRequest(List<String> nodes, int docsPerBatch) {  
        assumeFalse(  
     */  
        for (int i = 0; i < MAX_CHECKPOINTS_BEHIND; i++) {  
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
package org.opensearch.index;
     */
    }  
        final List<String> replicaNodes = asList(replicaNode);
        refresh(INDEX_NAME);
            replicaNodes.add(replica_2);
        );  
                });
            Thread indexingThread = new Thread(() -> { totalDocs.getAndSet(indexUntilCheckpointCount()); });
            .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueMillis(500))
        assertReplicaCheckpointUpdated(primaryShard);
    }
        verifyStoreContent();  
                    indexDoc();  
        executeBulkRequest(nodes, totalDocs);
                replicaShard.getLatestReplicationCheckpoint().getSegmentInfosVersion()
        );
    }
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        // index another doc showing there is no pressure enforced.
        // verify total doc count is same and docs are not rejected.
        indexDoc();
        ensureGreen(INDEX_NAME);
        final String replicaNode = internalCluster().startNode();  
            totalDocs.incrementAndGet();
        return bulkItemResponses;  
        final AtomicInteger totalDocs = new AtomicInteger(0);  
        client().prepareIndex(INDEX_NAME).setId(UUIDs.base64UUID()).setSource("{}", "{}").execute().actionGet();  
                client().admin()  
        for (int i = 0; i < 3; i++) {
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())  
            indexDoc();
            .build();  
            replicaNodes.add(internalCluster().startNode());  
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
            Thread indexingThread = new Thread(() -> { totalDocs.getAndSet(indexUntilCheckpointCount()); });
        indexDoc();
        createIndex(INDEX_NAME);
            .build();
    }  
        waitForSearchableDocs(totalDocs.incrementAndGet(), replicaNodes.toArray(new String[] {}));  
        totalDocs.incrementAndGet();
        // index another doc showing there is no pressure enforced.  
            indexingThread.start();
                .map(BulkItemResponse::getFailure)  
        ensureGreen(INDEX_NAME);
            indexDoc();  
            Thread indexingThread = new Thread(() -> {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            expectThrows(OpenSearchRejectedExecutionException.class, () -> {  
            .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueSeconds(1))
import org.opensearch.indices.replication.SegmentReplicationBaseIT;  
        final String replicaNode = internalCluster().startNode(settings);
        indexDoc();
            .build();  
            // Index docs until replicas are staled.
import org.opensearch.core.rest.RestStatus;  
import java.util.List;
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), totalDocs.get());  
    }  
        }
import org.opensearch.test.OpenSearchIntegTestCase;  
        final BulkRequest bulkRequest = new BulkRequest();
        ensureGreen(INDEX_NAME);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            indexDoc();  
            assertEquals(perGroupStats.getRejectedRequestCount(), 2L);  
    public Settings indexSettings() {
import org.opensearch.cluster.metadata.IndexMetadata;  
                expectThrows(OpenSearchRejectedExecutionException.class, () -> {  
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);  
            latch.await();
import org.opensearch.common.lease.Releasable;
            latch.await();
    }
        ensureGreen(INDEX_NAME);
            // index again while we are stale.
import org.opensearch.action.bulk.BulkResponse;
            latch.await();
        final CountDownLatch latch = new CountDownLatch(1);
        assertEqualSegmentInfosVersion(replicaNodes, primaryShard);  
        final IndexShard replicaAfterFailure = getIndexShard(replicaNode, INDEX_NAME);
        );  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)  
            indexingThread.join();  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        refresh(INDEX_NAME);  
        // wait for the replicas to catch up after block is released.
                for (int i = 0; i < MAX_CHECKPOINTS_BEHIND + 1; i++) {  
import org.opensearch.common.UUIDs;
import java.util.Arrays;
import static org.opensearch.index.SegmentReplicationPressureService.MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING;  
            .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)  
        assertEqualSegmentInfosVersion(replicaNodes, primaryShard);  
            indexingThread.join();
        // index again after stale limit.
        ensureGreen(INDEX_NAME);
            .put("index.refresh_interval", -1)  
        assertTrue(
        final String primaryNode = internalCluster().startNode();  
import static org.opensearch.index.SegmentReplicationPressureService.MAX_REPLICATION_TIME_BACKPRESSURE_SETTING;
        }  
        waitForSearchableDocs(totalDocs.get(), replicaNodes);
        try (final Releasable ignored = blockReplication(replicaNodes, latch)) {
    @Override
        refresh(INDEX_NAME);  
/*  
        assertEqualSegmentInfosVersion(replicaNodes, primaryShard);
        waitForSearchableDocs(totalDocs.incrementAndGet(), replicaNodes.toArray(new String[] {}));
        try (final Releasable ignored = blockReplication(replicaNodes, latch)) {
                });  
                    .prepareUpdateSettings(INDEX_NAME)
        createIndex(INDEX_NAME, settings);
                    refresh(INDEX_NAME);
            });
        final Settings settings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 3).build();  
        ensureGreen(INDEX_NAME);
            .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueMillis(500))
                }  
import org.opensearch.index.shard.IndexShard;
        final List<String> replicaNodes = new ArrayList<>();
