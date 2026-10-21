            expectThrows(OpenSearchRejectedExecutionException.class, () -> {
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        ensureGreen(INDEX_NAME);
            // Try to index one more doc.
        ensureYellowAndNoInitializingShards(INDEX_NAME);
                    totalDocs.incrementAndGet();
        // index another doc showing there is no pressure enforced.
            Thread indexingThread = new Thread(() -> {
import org.opensearch.test.OpenSearchIntegTestCase;
        IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    private int indexUntilCheckpointCount() {
            // Verify that replica shard is closed.
import static org.opensearch.index.SegmentReplicationPressureService.SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED;
        // wait for the replicas to catch up after block is released.
    private static final int MAX_CHECKPOINTS_BEHIND = 2;
            indexingThread.start();
        assertReplicaCheckpointUpdated(primaryShard);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertEqualSegmentInfosVersion(replicaNodes, primaryShard);
            final IndexShard replicaShard = getIndexShard(replicaName, INDEX_NAME);
        return Settings.builder()
        // index another doc showing there is no pressure enforced.
        refresh(INDEX_NAME);
import org.opensearch.core.rest.RestStatus;
        assertTrue(Arrays.stream(response.getItems()).allMatch(BulkItemResponse::isFailed));
        final String primaryNode = internalCluster().startNode();
            }
    public Settings indexSettings() {
            // index again while we are stale.
        }
            indexDoc();
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        try (final Releasable ignored = blockReplication(replicaNodes, latch)) {
        int totalDocs = docsPerBatch * MAX_CHECKPOINTS_BEHIND;
import org.opensearch.action.index.IndexRequest;
        );
        final AtomicInteger totalDocs = new AtomicInteger(0);
    @Override
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
        // we want to control refreshes
        try (final Releasable ignored = blockReplication(replicaNodes.subList(0, 1), latch)) {
        }
    public void testWithDocumentReplicationEnabledIndex() throws Exception {
        List<String> replicaNodes = new ArrayList<>();
        assertTrue(
        final AtomicInteger totalDocs = new AtomicInteger(0);
            indexDoc();
                expectThrows(OpenSearchRejectedExecutionException.class, () -> {
        final String replicaNode = internalCluster().startNode(settings);
        for (String replicaName : replicaNames) {
    private void assertEqualSegmentInfosVersion(List<String> replicaNames, IndexShard primaryShard) {
            // Index docs until replicas are staled.
    /**
            final int numDocs = randomIntBetween(1, 5);
import org.opensearch.action.bulk.BulkItemResponse;
        totalDocs.incrementAndGet();
            .put("index.refresh_interval", -1)
        createIndex(INDEX_NAME);
            assertEquals(
    private BulkResponse executeBulkRequest(List<String> nodes, int docsPerBatch) {
     * This test ensures that a replica can be added while the index is under write block.
        replicaNodes.add(replicaNode);
            SegmentReplicationPerGroupStats perGroupStats = segmentReplicationStatsResponse.getReplicationStats().get(INDEX_NAME).get(0);
    }
        refresh(INDEX_NAME);
        return Settings.builder()
        final String replicaNode = internalCluster().startNode();
    }
            indexingThread.join();
                indexDoc();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        final CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.action.bulk.BulkRequest;
        createIndex(INDEX_NAME);
        // wait for the replicas to catch up after block is released.
        waitForSearchableDocs(totalDocs.incrementAndGet(), replicaNodes.toArray(new String[] {}));
        // verify total doc count is same and docs are not rejected.
            assertAcked(
        final String coordinator = internalCluster().startCoordinatingOnlyNode(Settings.EMPTY);
            .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueSeconds(1))
import java.util.concurrent.atomic.AtomicInteger;
 * SPDX-License-Identifier: Apache-2.0
            });
import org.opensearch.indices.replication.common.ReplicationType;
        Settings settings = Settings.builder()
        assertEqualSegmentInfosVersion(replicaNodes, primaryShard);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
        // wait for the replicas to catch up after block is released.
            .build();
        indexDoc();
/*
    }
 */
        refresh(INDEX_NAME);
            segmentReplicationWithRemoteEnabled()
                indexDoc();
        }
    }
        // Starts a primary and replica node.
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public void testFailStaleReplica() throws Exception {
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
            // try and index again while we are stale.
                }
                .allMatch((failure) -> failure.getStatus() == RestStatus.TOO_MANY_REQUESTS)
    protected Settings nodeSettings(int nodeOrdinal) {
}
        refresh(INDEX_NAME);
                    .prepareUpdateSettings(INDEX_NAME)
        final CountDownLatch latch = new CountDownLatch(1);
            bulkRequest.add(request);
        for (int i = 0; i < 3; i++) {
        verifyStoreContent();
        final String primaryNode = internalCluster().startNode();
                .setDetailed(true)
import static org.opensearch.index.SegmentReplicationPressureService.MAX_REPLICATION_TIME_BACKPRESSURE_SETTING;
        verifyStoreContent();
                refresh(INDEX_NAME);
        }
        final CountDownLatch latch = new CountDownLatch(1);
        ensureGreen(INDEX_NAME);
    public void testWritesRejected() throws Exception {
            // index again while we are stale.
                for (int i = 0; i < MAX_CHECKPOINTS_BEHIND + 1; i++) {
                .map(BulkItemResponse::getFailure)
 * Copyright OpenSearch Contributors.
     * Ensuring that only write requests are blocked.
import static org.opensearch.index.SegmentReplicationPressureService.MAX_INDEXING_CHECKPOINTS;
    public void testAddReplicaWhileWritesBlocked() throws Exception {
                expectThrows(OpenSearchRejectedExecutionException.class, () -> {
    }
        // Verify that new replica shard after failure is different from old replica shard.
        ensureGreen(INDEX_NAME);
            indexingThread.start();
            totalDocs.getAndSet(indexUntilCheckpointCount());
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
            refresh(INDEX_NAME);
package org.opensearch.index;
            latch.await();
            indexingThread.start();
            indexingThread.start();
import org.opensearch.common.lease.Releasable;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        refresh(INDEX_NAME);
import org.opensearch.cluster.metadata.IndexMetadata;
            totalDocs.incrementAndGet();
        // Index docs until replica stale limit is reached.
        try (final Releasable ignored = blockReplication(replicaNodes, latch)) {
    private void indexDoc() {
        createIndex(INDEX_NAME, settings);
            Arrays.stream(response.getItems())
            });
import org.opensearch.indices.replication.SegmentReplicationBaseIT;
import java.util.List;
            Thread indexingThread = new Thread(() -> { totalDocs.getAndSet(indexUntilCheckpointCount()); });
    }
        final AtomicInteger totalDocs = new AtomicInteger(0);
            });
import static java.util.Arrays.asList;
            .put(super.indexSettings())
            indexDoc();
        client().prepareIndex(INDEX_NAME).setId(UUIDs.base64UUID()).setSource("{}", "{}").execute().actionGet();
        ensureGreen(INDEX_NAME);
            totalDocs.incrementAndGet();
        for (int i = 0; i < MAX_CHECKPOINTS_BEHIND; i++) {
        final List<String> replicaNodes = asList(replicaNode);
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), totalDocs.get());
        // index another doc showing there is no pressure enforced.
                });
import java.util.concurrent.CountDownLatch;
        indexDoc();
            .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueMillis(500))
            });
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
                    executeBulkRequest(nodes, docsPerBatch);
        assumeFalse(
                .execute()
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setSize(0).setPreference("_only_local").get(), totalDocs.get());
        waitForSearchableDocs(totalDocs.incrementAndGet(), replicaNodes.toArray(new String[] {}));
import java.util.Collection;
            // index again while we are stale.
            Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build()
        // index again after stale limit.
        }
import org.opensearch.plugins.Plugin;
        final List<String> replicaNodes = asList(replicaNode);
        final String replicaNode = internalCluster().startNode();
            indexingThread.join();
    }
                    .indices()
        return total;
        assertEqualSegmentInfosVersion(replicaNodes, primaryShard);
            latch.await();
        createIndex(
        final IndexShard replicaAfterFailure = getIndexShard(replicaNode, INDEX_NAME);
            .build();
import org.opensearch.index.shard.IndexShard;
            refresh(INDEX_NAME);
        refresh(INDEX_NAME);
                .indices()
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
            refresh(INDEX_NAME);
        );
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
                .actionGet();
import org.opensearch.common.settings.Settings;
            latch.await();
        try (final Releasable ignored = blockReplication(replicaNodes, latch)) {
                .prepareSegmentReplicationStats(INDEX_NAME)
import java.util.ArrayList;
        verifyStoreContent();
        final CountDownLatch latch = new CountDownLatch(1);
        totalDocs.getAndSet(indexUntilCheckpointCount());
            .put(super.nodeSettings(nodeOrdinal))
        // index another doc showing there is no pressure enforced.
import static org.opensearch.index.SegmentReplicationPressureService.MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING;
    }
    }
            indexDoc();
     * Asserts that there are no stale replicas according to the primary until cp count is reached.
            assertBusy(() -> { assertTrue(replicaShard.state().equals(IndexShardState.CLOSED)); }, 1, TimeUnit.MINUTES);
        final String primaryNode = internalCluster().startNode();
        );
            totalDocs.incrementAndGet();
            for (int j = 0; j < numDocs; ++j) {
        createIndex(INDEX_NAME);
            total += numDocs;
        final String replicaNode = internalCluster().startNode();
        final BulkRequest bulkRequest = new BulkRequest();
        for (int j = 0; j < docsPerBatch; ++j) {
                totalDocs.incrementAndGet();
            assertEquals(perGroupStats.getRejectedRequestCount(), 2L);
        assertReplicaCheckpointUpdated(primaryShard);
                client().admin()
        // only block a single replica, pressure should not get applied.
        final IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
    public void testBelowReplicaLimit() throws Exception {
import java.util.concurrent.TimeUnit;
            Thread indexingThread = new Thread(() -> totalDocs.getAndSet(indexUntilCheckpointCount()));
        try (final Releasable ignored = blockReplication(replicaNodes, latch)) {
                    indexDoc();
        refresh(INDEX_NAME);
        indexDoc();
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.UUIDs;
        }
        int total = 0;
            assertBusy(() -> { assertFailedRequests(executeBulkRequest(nodes, randomIntBetween(1, 200))); });
            assertBusy(() -> {
        return asList(MockTransportService.TestPlugin.class);
import java.util.Collections;
        assertEqualSegmentInfosVersion(replicaNodes, primaryShard);
        verifyStoreContent();
        assertEqualSegmentInfosVersion(replicaNodes, primaryShard);
import org.opensearch.index.shard.IndexShardState;
    /**
        ensureGreen(INDEX_NAME);
     * Index and Refresh in batches to force checkpoints behind.
        }
            assertBusy(() -> {
    @Override
        int docsPerBatch = randomIntBetween(1, 200);
        waitForSearchableDocs(totalDocs * 2L, replicaNodes.toArray(new String[] {}));
            refresh(INDEX_NAME);
            latch.await();
            .put(SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED.getKey(), true)
import java.util.Arrays;
public class SegmentReplicationPressureIT extends SegmentReplicationBaseIT {
            latch.await();
            totalDocs.incrementAndGet();
    }
            .put(MAX_INDEXING_CHECKPOINTS.getKey(), MAX_CHECKPOINTS_BEHIND)
        final String primaryNode = internalCluster().startNode(settings);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            INDEX_NAME,
            .put(MAX_REPLICATION_TIME_BACKPRESSURE_SETTING.getKey(), TimeValue.timeValueMillis(500))
        waitForSearchableDocs(totalDocs.get(), replicaNodes);
        }
                primaryShard.getLatestReplicationCheckpoint().getSegmentInfosVersion(),
    private void assertFailedRequests(BulkResponse response) {
     */
        Settings settings = Settings.builder()
    public void testBulkWritesRejected() throws Exception {
        List<String> nodes = List.of(primaryNode, replicaNode, coordinator);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        final List<String> replicaNodes = asList(replicaNode);
        // Starts a primary and replica node.
                replicaShard.getLatestReplicationCheckpoint().getSegmentInfosVersion()
            IndexRequest request = new IndexRequest(INDEX_NAME).id(UUIDs.base64UUID())
        final String replicaNode = internalCluster().startNode(settings);
    }
            );
     */
            Thread indexingThread = new Thread(() -> { totalDocs.getAndSet(indexUntilCheckpointCount()); });
        return bulkItemResponses;
            .put(MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING.getKey(), TimeValue.timeValueMillis(1000))
    }
                });
            SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
            .build();
                    refresh(INDEX_NAME);
        createIndex(INDEX_NAME);
        final CountDownLatch latch = new CountDownLatch(1);
        final AtomicInteger totalDocs = new AtomicInteger(0);
        }
    @Override
            final String replica_2 = internalCluster().startNode();
        final AtomicInteger totalDocs = new AtomicInteger(0);
        assertNotEquals(replicaAfterFailure.routingEntry().allocationId().getId(), replicaShard.routingEntry().allocationId().getId());
        final String primaryNode = internalCluster().startNode();
                    indexDoc();
            indexingThread.join();
        assertReplicaCheckpointUpdated(primaryShard);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)
        final Settings settings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 3).build();
            replicaNodes.add(internalCluster().startNode());
                    totalDocs.incrementAndGet();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            replicaNodes.add(replica_2);
    }
        refresh(INDEX_NAME);
        waitForSearchableDocs(totalDocs.incrementAndGet(), replicaNodes.toArray(new String[] {}));
            "Skipping the test as its not compatible with segment replication with remote store. Cannot create DocRep indices with Remote store enabled",
        final String primaryNode = internalCluster().startNode(settings);
        final List<String> replicaNodes = new ArrayList<>();
            refresh(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        indexDoc();
                    .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 2))
        final BulkResponse bulkItemResponses = client(randomFrom(nodes)).bulk(bulkRequest).actionGet();
            // Verify the rejected doc count.
import org.opensearch.test.transport.MockTransportService;
        executeBulkRequest(nodes, totalDocs);
                .source(Collections.singletonMap("key", randomAlphaOfLength(50)));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            indexingThread.join();
            .build();
            );
