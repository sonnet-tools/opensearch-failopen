package org.opensearch.indices.replication;
        waitForSearchableDocs(numDocs, nodes);
            .actionGet();
        SegmentReplicationStatsResponse activeOnlyResponse = client().admin()
        final long numDocs = scaledRandomIntBetween(50, 100);
        segmentReplicationStatsResponse = client().admin()
            assertEquals(group.getShardId(), indexShard.shardId());
        createIndex(
            .getCurrentReplicationState()
        logger.info("--> create index on node: {}", primaryNode);
    }
            assertEquals(1, replicaStats.size());
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        assertEquals(1, replicationStats.size());
import org.opensearch.common.settings.Settings;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
import org.opensearch.test.OpenSearchIntegTestCase;
            }
        internalCluster().startClusterManagerOnlyNode();
                    assertTrue(replicationStats.getMaxReplicationLag() > 0);
        }
            assertNotNull(currentReplicationState);
                    .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                .getReplicationStats();
        createIndex(
            .actionGet();
        }, 30, TimeUnit.SECONDS);
                .setDetailed(true)
        List<String> nodes = new ArrayList<>();
        Map<String, List<SegmentReplicationPerGroupStats>> replicationStats = segmentReplicationStatsResponse.getReplicationStats();
            .findFirst()
                .actionGet();
        assertAcked(
        final String primaryNode = internalCluster().startNode();
                    .put("number_of_replicas", 1)
        final IndexShard index_1_primary = getIndexShard(primaryNode, INDEX_NAME);
                .prepareSegmentReplicationStats(INDEX_NAME)
    public void testQueryAgainstDocRepIndex() {
        }, 1, TimeUnit.MINUTES);
        ensureGreen(INDEX_NAME);
import org.opensearch.index.SegmentReplicationShardStats;
        }
        assertTrue(segmentReplicationStatsResponse.getReplicationStats().isEmpty());
        final String primaryNode = internalCluster().startNode();
            prepareCreate(
                        throw new RuntimeException(e);
        final String replicaNode1 = internalCluster().startNode();
                    assertTrue(replicationStats.getMaxBytesBehind() == 0);
            .prepareSegmentReplicationStats(INDEX_NAME)
            .execute()
            assertEquals(perGroupStats.getShardId(), index_1_primary.shardId());
            // index another doc while blocked, this would not get replicated to the replicas.
        String dataNode = internalCluster().startDataOnlyNode();
            .setDetailed(true)
        final int id = indexShard.shardId().getId();
            .actionGet();
                .clear()
                refresh(INDEX_NAME);
            assertEquals(perGroupStats.getShardId(), indexShard.shardId());
        List<SegmentReplicationPerGroupStats> replicationPerGroupStats = replicationStats.get(INDEX_NAME);
                .findFirst()
        logger.info("--> start first replica node");
            .setActiveOnly(true)
            for (SegmentReplicationShardStats replica : replicaStats) {
        // index 10 more docs
        nodes.add(internalCluster().startDataOnlyNode());
        final IndexShard indexShard = getIndexShard(primaryNode, INDEX_NAME);
import org.opensearch.common.lease.Releasable;
            for (SegmentReplicationShardStats replica : replicaStats) {
                        waitForAssertions.await();
        assertBusy(() -> {
            assertEquals(perGroupStats.getShardId(), index_2_primary.shardId());
                    assertTrue(replicationStats.getTotalBytesBehind() > 0);
            assertEquals(1, group.getReplicaStats().size());
        for (SegmentReplicationPerGroupStats group : replicationPerGroupStats) {
        ensureYellowAndNoInitializingShards(INDEX_NAME, index_2);
                .indices()
        SegmentReplicationPerGroupStats perGroupStats = activeOnlyResponse.getReplicationStats().get(INDEX_NAME).get(0);
    public void testSegmentReplicationNodeAndIndexStats() throws Exception {
 * The OpenSearch Contributors require contributions made to
            INDEX_NAME,
            .actionGet();
        }
        assertEquals(2, replicationPerGroupStats.size());
        refresh(INDEX_NAME);
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
        final String primaryNode = internalCluster().startNode();
                Settings.builder()
                    assertTrue(replicationStats.getTotalBytesBehind() == 0);
        waitForSearchableDocs(INDEX_NAME, numDocs, nodes);
            .execute()
            .indices()
                    assertTrue(replicationStats.getMaxBytesBehind() > 0);
        assertTrue(index_2_primary.routingEntry().primary());
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
            .prepareSegmentReplicationStats(INDEX_NAME)
                .getCurrentReplicationState();
            .indices()
        try (final Releasable ignored = blockReplication(List.of(replicaNode1, replicaNode2), latch)) {
                    assertTrue(replicationStats.getMaxReplicationLag() == 0);
            });
            )
            SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
                }
        refresh(INDEX_NAME);
            assertEquals(4, replicaStats.size());
        internalCluster().startClusterManagerOnlyNode();
            SegmentReplicationPerGroupStats perGroupStats = segmentReplicationStatsResponse.getReplicationStats().get(INDEX_NAME).get(0);
        createIndex(
            SegmentReplicationPerGroupStats perGroupStats = replicationPerGroupStats.get(0);
        }
        for (SegmentReplicationPerGroupStats group : replicationPerGroupStats) {
                    }
        createIndex(INDEX_NAME, index_2);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            TransportService.class,
import java.util.ArrayList;
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            assertEquals(2, replicationStats.size());
        waitForSearchableDocs(index_2, numDocs, nodes);
                    waitForReplication.countDown();
        // Mock transport service to add behaviour of waiting in GET_SEGMENT_FILES Stage of a segment replication event.
        mockTransportService.addSendBehavior(
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            }
                }
        replicationStats = segmentReplicationStatsResponse.getReplicationStats();
        // test only single index queried.
        assertBusy(() -> {
        refresh(INDEX_NAME);
            .setIndices(index_2)
import org.opensearch.test.transport.MockTransportService;
            .indices()
            assertTrue(currentReplicationState.getIndex().recoveredFileCount() > 0);
import java.util.List;
                if (nodeStats.getNode().getName().equals(primaryNode)) {
        final CountDownLatch waitForReplication = new CountDownLatch(1);
        nodes.add(primaryNode);
        for (int i = 0; i < numDocs; i++) {
            Settings.builder()
            }
                0,
            // test both indices are returned in the response.
                .stream()
            .indices()
        ensureYellowAndNoInitializingShards(INDEX_NAME);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            assertEquals(segmentReplicationStatsResponse.getSuccessfulShards(), numShards * 2);
                connection.sendRequest(requestId, action, request, options);
            replicaNode
        int numShards = 4;
            index(INDEX_NAME, "doc", Integer.toString(i));
            SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
                    .put("number_of_shards", numShards)
 * this file be licensed under the Apache-2.0 license or a
                .indices()
                .build()
                    } catch (InterruptedException e) {
            ReplicationStats indexReplicationStats = stats.getIndex(INDEX_NAME).getTotal().getSegments().getReplicationStats();
            index(INDEX_NAME, "doc", Integer.toString(i));
            assertTrue(indexReplicationStats.getMaxReplicationLag() > 0);
public class SegmentReplicationStatsIT extends SegmentReplicationBaseIT {
        );
            .execute()
            nodes.add(internalCluster().startNode());
        for (int i = 0; i < numReplicas; i++) {
        final String primaryNode = internalCluster().startNode();
        final IndexShard index_2_primary = getIndexShard(primaryNode, index_2);
        for (int i = 10; i < 20; i++) {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
/*
        String anotherDataNode = internalCluster().startDataOnlyNode();
    public void testMultipleIndices() throws Exception {
            for (SegmentReplicationShardStats replica : replicaStats) {
            .execute()
        ensureGreen();
            SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
            assertEquals(1, group.getReplicaStats().size());
        refresh(INDEX_NAME, index_2);
        internalCluster().startClusterManagerOnlyNode();
        for (int i = 0; i < numDocs; i++) {
            assertEquals(1, replicationPerGroupStats.size());
                    try {
                .execute()
            index(INDEX_NAME, "doc", Integer.toString(i));
        ensureGreen();
        assertTrue(index_1_primary.routingEntry().primary());
        }
                .build()
        SegmentReplicationStatsResponse segmentReplicationStatsResponse = client().admin()
        int numReplicas = 4;
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
        // now search for one shard.
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
        final String primaryNode = internalCluster().startNode();
                .prepareSegmentReplicationStats()
            NodesStatsResponse nodesStatsResponse = client().admin()
            List<SegmentReplicationPerGroupStats> replicationPerGroupStats = replicationStats.get(INDEX_NAME);
        );
        nodes.add(primaryNode);
        final long numDocs = scaledRandomIntBetween(50, 100);
            // get replication statistics at index level
            Thread indexingThread = new Thread(() -> {
    }
        ensureGreen(INDEX_NAME);
            .actionGet();
            IndicesStatsResponse stats = client().admin().indices().prepareStats().execute().actionGet();
        SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
                // replica nodes - should hold replication statistics
                ReplicationStats replicationStats = nodeStats.getIndices().getSegments().getReplicationStats();
import static java.util.Arrays.asList;
        final long numDocs = scaledRandomIntBetween(50, 100);
            assertTrue(indexReplicationStats.getMaxBytesBehind() > 0);
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.Map;
        SegmentReplicationState.Stage stage = perGroupStats.getReplicaStats()
        waitForAssertions.countDown();
    }
        } catch (InterruptedException e) {
        final String index_2 = "tst-index-2";
        List<String> nodes = new ArrayList<>();
            assertEquals(1, replicaStats.size());
import org.opensearch.transport.TransportService;
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
            indexingThread.start();
        final long numDocs = scaledRandomIntBetween(50, 100);
        assertTrue(segmentReplicationStatsResponse.getReplicationStats().containsKey(index_2));
            Map<String, List<SegmentReplicationPerGroupStats>> replicationStats = segmentReplicationStatsResponse.getReplicationStats();
import org.opensearch.indices.replication.common.ReplicationType;
                .execute()
    }
        ));
                .put(indexSettings())
        createIndex(INDEX_NAME);
import java.util.Set;
            assertEquals(1, replicationStats.size());
                // primary node - do not have any replication statistics
        refresh(INDEX_NAME);
        // block replication
        waitForSearchableDocs(10L, asList(primaryNode, replicaNode));
            waitForReplication.await();
            index(INDEX_NAME, "doc", Integer.toString(i));
        waitForSearchableDocs(numDocs, nodes);
            .setActiveOnly(true)
        nodes.add(primaryNode);
        MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
        );
        }
                .indices()
        // search for all
        ensureYellow();
        }
        for (int i = 0; i < numDocs; i++) {
    }
            Settings.builder()
            final Set<SegmentReplicationShardStats> replicaStats = perGroupStats.getReplicaStats();
            final Map<String, List<SegmentReplicationPerGroupStats>> replicationStats = segmentReplicationStatsResponse
                client().prepareIndex(INDEX_NAME).setId("2").setSource("foo2", randomInt()).get();
            assertEquals(1, replicationPerGroupStats.size());
            .setActiveOnly(true)
        final long numDocs = scaledRandomIntBetween(50, 100);
        assertAcked(prepareCreate(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)));
                assertNotNull(replica.getCurrentReplicationState());
        }
        for (int i = 0; i < numDocs; i++) {
                .actionGet();
        CountDownLatch latch = new CountDownLatch(1);
 * compatible open source license.
        );
        }
                .build()
        List<String> nodes = new ArrayList<>();
    public void testNonDetailedResponse() throws Exception {
        }
            (connection, requestId, action, request, options) -> {
        );
 */
import java.util.concurrent.TimeUnit;
            INDEX_NAME,
            latch.await();
        logger.info("--> start second replica node");
        // index 10 docs
            }
            index(INDEX_NAME, "doc", Integer.toString(i));
            INDEX_NAME,
            indexingThread.join();
import org.opensearch.index.shard.IndexShard;
            final SegmentReplicationPerGroupStats perGroupStats = replicationPerGroupStats.get(0);
            throw new RuntimeException(e);
    public void testGetSpecificShard() throws Exception {
                .cluster()
        assertEquals(1, replicationPerGroupStats.size());
                if (action.equals(SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES)) {
                assertNotNull(replica.getCurrentReplicationState());
        final IndexShard indexShard = getIndexShard(primaryNode, INDEX_NAME);
            assertEquals(segmentReplicationStatsResponse.getTotalShards(), numShards * 2);
 *
        final String replicaNode = internalCluster().startNode();
            assertEquals(currentReplicationState.getStage(), SegmentReplicationState.Stage.DONE);
            .shards(String.valueOf(id))
        for (int i = 0; i < 10; i++) {
                .get()
        assertEquals(SegmentReplicationState.Stage.GET_FILES, stage);
        }
                .prepareNodesStats()
        }
        ensureSearchable(INDEX_NAME, index_2);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();
                if (nodeStats.getNode().getName().equals(replicaNode1) || nodeStats.getNode().getName().equals(replicaNode2)) {
                .execute()
        assertEquals(1, replicationStats.size());
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        final CountDownLatch waitForAssertions = new CountDownLatch(1);
        refresh(INDEX_NAME);
    public void testSegmentReplicationStatsResponseForActiveOnly() throws Exception {
                .put(indexSettings())
            assertEquals(segmentReplicationStatsResponse.getReplicationStats().size(), 1);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        try {
    public void testSegmentReplicationStatsResponse() throws Exception {
            .getStage();
        logger.info("--> start primary node");
            assertEquals(2 * indexReplicationStats.getMaxBytesBehind(), indexReplicationStats.getTotalBytesBehind());
            replicationPerGroupStats = replicationStats.get(index_2);
            // stats should be of non-zero value when aggregated at index level
            .prepareSegmentReplicationStats()
            replicaStats = perGroupStats.getReplicaStats();
        ensureGreen(INDEX_NAME);
                .actionGet();
            perGroupStats = replicationPerGroupStats.get(0);
        refresh(INDEX_NAME);
import java.util.concurrent.CountDownLatch;
        ensureSearchable(INDEX_NAME);
        assertBusy(() -> {
}
            }
            final SegmentReplicationState currentReplicationState = perGroupStats.getReplicaStats()
        // verifying active_only by checking if current stage is GET_FILES STAGE
        assertEquals(1, segmentReplicationStatsResponse.getReplicationStats().size());
import org.opensearch.index.ReplicationStats;
            Set<SegmentReplicationShardStats> replicaStats = perGroupStats.getReplicaStats();
        // search for all
import org.opensearch.index.SegmentReplicationPerGroupStats;
                INDEX_NAME,
            index(index_2, "doc", Integer.toString(i));
                .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Segments))
                }
            .get()
            .execute()
    }
        final String primaryNode = internalCluster().startDataOnlyNode();
            assertNotNull(indexReplicationStats);
            assertEquals(1, replicationPerGroupStats.size());
                .put(indexSettings())
            .prepareSegmentReplicationStats(INDEX_NAME)
        internalCluster().startClusterManagerOnlyNode();
            .prepareSegmentReplicationStats(INDEX_NAME)
            final List<SegmentReplicationPerGroupStats> replicationPerGroupStats = replicationStats.get(INDEX_NAME);
        ensureYellow(INDEX_NAME);
                .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
            .indices()
    }
        nodes.add(internalCluster().startNode());
            internalCluster().getInstance(TransportService.class, primaryNode),
        ensureGreen(INDEX_NAME, index_2);
                .prepareSegmentReplicationStats(INDEX_NAME)
        final String replicaNode2 = internalCluster().startNode();
        SegmentReplicationStatsResponse segmentReplicationStatsResponse = client().admin()
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        });
        nodes.add(primaryNode);
        List<String> nodes = new ArrayList<>();
        replicationPerGroupStats = replicationStats.get(INDEX_NAME);
            Settings.builder()
            for (NodeStats nodeStats : nodesStatsResponse.getNodes()) {
        nodes.add(internalCluster().startNode());
            assertTrue(indexReplicationStats.getTotalBytesBehind() > 0);
                assertNotNull(replica.getCurrentReplicationState());
            .stream()
