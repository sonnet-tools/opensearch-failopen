            assertTrue(indexReplicationStats.getMaxReplicationLag() > 0);
        assertBusy(() -> {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    }  
}
            .setActiveOnly(true)
        assertTrue(index_2_primary.routingEntry().primary());
        }
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
        }  
            waitForReplication.await();
        ensureYellow();
            ReplicationStats indexReplicationStats = stats.getIndex(INDEX_NAME).getTotal().getSegments().getReplicationStats();  
import java.util.Map;
                .actionGet();
        final IndexShard indexShard = getIndexShard(primaryNode, INDEX_NAME);
import org.opensearch.test.OpenSearchIntegTestCase;
                    assertTrue(replicationStats.getTotalBytesBehind() > 0);
                        waitForAssertions.await();
            final SegmentReplicationPerGroupStats perGroupStats = replicationPerGroupStats.get(0);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .indices()  
import org.opensearch.index.shard.IndexShard;  
        replicationPerGroupStats = replicationStats.get(INDEX_NAME);
    }  
import org.opensearch.indices.replication.common.ReplicationType;
        for (int i = 0; i < numDocs; i++) {
        assertAcked(prepareCreate(INDEX_NAME, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)));
            assertEquals(1, replicaStats.size());  
                .prepareSegmentReplicationStats(INDEX_NAME)
        } catch (InterruptedException e) {  
        nodes.add(internalCluster().startNode());  
            index(INDEX_NAME, "doc", Integer.toString(i));
            assertTrue(indexReplicationStats.getMaxBytesBehind() > 0);
            assertEquals(1, replicationPerGroupStats.size());
            latch.await();
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
            SegmentReplicationPerGroupStats perGroupStats = replicationPerGroupStats.get(0);  
        final String primaryNode = internalCluster().startDataOnlyNode();  
                .execute()
            replicationPerGroupStats = replicationStats.get(index_2);
        final IndexShard indexShard = getIndexShard(primaryNode, INDEX_NAME);
            perGroupStats = replicationPerGroupStats.get(0);
                    assertTrue(replicationStats.getMaxBytesBehind() > 0);  
        internalCluster().startClusterManagerOnlyNode();  
            }  
            assertTrue(currentReplicationState.getIndex().recoveredFileCount() > 0);
            .getStage();  
        waitForSearchableDocs(numDocs, nodes);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    public void testMultipleIndices() throws Exception {
        Map<String, List<SegmentReplicationPerGroupStats>> replicationStats = segmentReplicationStatsResponse.getReplicationStats();  
        // block replication
    }
        logger.info("--> start first replica node");
                if (action.equals(SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES)) {
                INDEX_NAME,  
        // index 10 docs  
        final long numDocs = scaledRandomIntBetween(50, 100);  
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        try (final Releasable ignored = blockReplication(List.of(replicaNode1, replicaNode2), latch)) {
            .execute()  
            assertEquals(1, replicaStats.size());
                .actionGet();  
            .indices()
                .put(indexSettings())
        // Mock transport service to add behaviour of waiting in GET_SEGMENT_FILES Stage of a segment replication event.
import java.util.concurrent.TimeUnit;
            .indices()  
        ensureYellowAndNoInitializingShards(INDEX_NAME, index_2);
        SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
                client().prepareIndex(INDEX_NAME).setId("2").setSource("foo2", randomInt()).get();
        assertEquals(1, replicationPerGroupStats.size());  
        waitForSearchableDocs(INDEX_NAME, numDocs, nodes);
        final String index_2 = "tst-index-2";
            .actionGet();
        List<SegmentReplicationPerGroupStats> replicationPerGroupStats = replicationStats.get(INDEX_NAME);
                .getReplicationStats();  
 * The OpenSearch Contributors require contributions made to  
        createIndex(
        refresh(INDEX_NAME);
        // index 10 more docs  
import org.opensearch.common.settings.Settings;
        final long numDocs = scaledRandomIntBetween(50, 100);
                .build()  
            SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
            assertEquals(1, replicationPerGroupStats.size());  
                .indices()  
        ensureGreen(INDEX_NAME, index_2);  
        for (int i = 10; i < 20; i++) {
        nodes.add(primaryNode);
            Map<String, List<SegmentReplicationPerGroupStats>> replicationStats = segmentReplicationStatsResponse.getReplicationStats();
            assertTrue(indexReplicationStats.getTotalBytesBehind() > 0);  
        final String replicaNode = internalCluster().startNode();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        segmentReplicationStatsResponse = client().admin()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        assertEquals(1, segmentReplicationStatsResponse.getReplicationStats().size());
                .prepareNodesStats()  
                    assertTrue(replicationStats.getTotalBytesBehind() == 0);
        nodes.add(primaryNode);  
                // primary node - do not have any replication statistics
        internalCluster().startClusterManagerOnlyNode();  
                assertNotNull(replica.getCurrentReplicationState());
                    .put("number_of_replicas", 1)
        );
            SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
            INDEX_NAME,  
        }
                .clear()
            .setIndices(index_2)
        ensureYellow(INDEX_NAME);
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
                .indices()  
import java.util.ArrayList;  
            index(INDEX_NAME, "doc", Integer.toString(i));  
                .build()
        assertTrue(segmentReplicationStatsResponse.getReplicationStats().containsKey(index_2));  
        ensureSearchable(INDEX_NAME);
                    assertTrue(replicationStats.getMaxReplicationLag() > 0);
                .prepareSegmentReplicationStats()
        assertEquals(SegmentReplicationState.Stage.GET_FILES, stage);
                }  
        }  
        SegmentReplicationStatsResponse activeOnlyResponse = client().admin()
            nodes.add(internalCluster().startNode());  
                    try {  
            // stats should be of non-zero value when aggregated at index level
        List<String> nodes = new ArrayList<>();
            index(INDEX_NAME, "doc", Integer.toString(i));
            List<SegmentReplicationPerGroupStats> replicationPerGroupStats = replicationStats.get(INDEX_NAME);
import org.opensearch.test.transport.MockTransportService;  
        assertEquals(2, replicationPerGroupStats.size());  
        }
        for (int i = 0; i < 10; i++) {
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;  
            throw new RuntimeException(e);
        waitForAssertions.countDown();
                .indices()  
                // replica nodes - should hold replication statistics
        List<String> nodes = new ArrayList<>();
        final IndexShard index_1_primary = getIndexShard(primaryNode, INDEX_NAME);  
            Set<SegmentReplicationShardStats> replicaStats = perGroupStats.getReplicaStats();
                    .put("number_of_shards", numShards)  
    public void testQueryAgainstDocRepIndex() {  
public class SegmentReplicationStatsIT extends SegmentReplicationBaseIT {
        }, 1, TimeUnit.MINUTES);
    public void testSegmentReplicationStatsResponse() throws Exception {
            assertEquals(segmentReplicationStatsResponse.getSuccessfulShards(), numShards * 2);
            .indices()
                assertNotNull(replica.getCurrentReplicationState());  
            assertEquals(1, group.getReplicaStats().size());  
            for (SegmentReplicationShardStats replica : replicaStats) {
        for (int i = 0; i < numDocs; i++) {
                0,
        );
                .put(indexSettings())
            assertEquals(1, group.getReplicaStats().size());
package org.opensearch.indices.replication;
        MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(  
        ensureGreen();
        final long numDocs = scaledRandomIntBetween(50, 100);
        createIndex(
        createIndex(
        ensureGreen(INDEX_NAME);
                }  
        }
            for (NodeStats nodeStats : nodesStatsResponse.getNodes()) {
            assertEquals(1, replicationStats.size());
            .actionGet();
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            // get replication statistics at index level
            assertEquals(currentReplicationState.getStage(), SegmentReplicationState.Stage.DONE);  
                .get()  
        }  
    public void testGetSpecificShard() throws Exception {
                    waitForReplication.countDown();
            NodesStatsResponse nodesStatsResponse = client().admin()
            assertEquals(perGroupStats.getShardId(), indexShard.shardId());
            INDEX_NAME,
        refresh(INDEX_NAME);
        final String primaryNode = internalCluster().startNode();  
        SegmentReplicationPerGroupStats perGroupStats = activeOnlyResponse.getReplicationStats().get(INDEX_NAME).get(0);  
        );
        createIndex(INDEX_NAME, index_2);
            .prepareSegmentReplicationStats(INDEX_NAME)
        internalCluster().startClusterManagerOnlyNode();  
        assertBusy(() -> {  
        // search for all
            assertNotNull(currentReplicationState);
        nodes.add(primaryNode);
                if (nodeStats.getNode().getName().equals(replicaNode1) || nodeStats.getNode().getName().equals(replicaNode2)) {
        CountDownLatch latch = new CountDownLatch(1);  
        assertTrue(segmentReplicationStatsResponse.getReplicationStats().isEmpty());  
            SegmentReplicationPerGroupStats perGroupStats = segmentReplicationStatsResponse.getReplicationStats().get(INDEX_NAME).get(0);
            // test both indices are returned in the response.
        mockTransportService.addSendBehavior(
            replicaNode
                .findFirst()
        nodes.add(internalCluster().startNode());
        internalCluster().startClusterManagerOnlyNode();
        final String replicaNode2 = internalCluster().startNode();  
            indexingThread.start();  
                .build()
    }
        refresh(INDEX_NAME, index_2);
            SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
        final String primaryNode = internalCluster().startNode();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
    }
            Thread indexingThread = new Thread(() -> {
        assertAcked(
        internalCluster().startClusterManagerOnlyNode();
            .actionGet();
            .findFirst()  
        try {
        int numShards = 4;  
            prepareCreate(
 * compatible open source license.
            .execute()  
        });
        refresh(INDEX_NAME);  
        assertTrue(index_1_primary.routingEntry().primary());  
        assertBusy(() -> {
                .prepareSegmentReplicationStats(INDEX_NAME)
            .actionGet();
                    }
/*  
            // index another doc while blocked, this would not get replicated to the replicas.  
    public void testSegmentReplicationNodeAndIndexStats() throws Exception {  
            final Set<SegmentReplicationShardStats> replicaStats = perGroupStats.getReplicaStats();  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Segments))
        ensureGreen(INDEX_NAME);
            .execute()
            }
            }
    public void testSegmentReplicationStatsResponseForActiveOnly() throws Exception {
        waitForSearchableDocs(numDocs, nodes);  
        // test only single index queried.
            .actionGet();
                connection.sendRequest(requestId, action, request, options);  
            final Map<String, List<SegmentReplicationPerGroupStats>> replicationStats = segmentReplicationStatsResponse
        logger.info("--> create index on node: {}", primaryNode);
import org.opensearch.common.lease.Releasable;
        final long numDocs = scaledRandomIntBetween(50, 100);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        final int id = indexShard.shardId().getId();  
                .setDetailed(true)
            TransportService.class,
        );
        refresh(INDEX_NAME);
        final String primaryNode = internalCluster().startNode();  
                        throw new RuntimeException(e);  
            IndicesStatsResponse stats = client().admin().indices().prepareStats().execute().actionGet();  
            assertEquals(perGroupStats.getShardId(), index_1_primary.shardId());
                ReplicationStats replicationStats = nodeStats.getIndices().getSegments().getReplicationStats();  
            .prepareSegmentReplicationStats(INDEX_NAME)  
                Settings.builder()
import java.util.List;
            }
 *
import static java.util.Arrays.asList;
            assertNotNull(indexReplicationStats);
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        for (int i = 0; i < numDocs; i++) {  
            }
            assertEquals(group.getShardId(), indexShard.shardId());
import java.util.Set;  
                    assertTrue(replicationStats.getMaxReplicationLag() == 0);
            .setDetailed(true)  
    }  
            for (SegmentReplicationShardStats replica : replicaStats) {
        }
                    assertTrue(replicationStats.getMaxBytesBehind() == 0);  
        SegmentReplicationState.Stage stage = perGroupStats.getReplicaStats()
            .getCurrentReplicationState()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
        final String primaryNode = internalCluster().startNode();
        final long numDocs = scaledRandomIntBetween(50, 100);  
                refresh(INDEX_NAME);  
            assertEquals(perGroupStats.getShardId(), index_2_primary.shardId());
        List<String> nodes = new ArrayList<>();
            index(index_2, "doc", Integer.toString(i));
            assertEquals(segmentReplicationStatsResponse.getReplicationStats().size(), 1);
    public void testNonDetailedResponse() throws Exception {
        createIndex(INDEX_NAME);
            assertEquals(2, replicationStats.size());  
        }  
        for (SegmentReplicationPerGroupStats group : replicationPerGroupStats) {
        ensureGreen(INDEX_NAME);
            .execute()  
        for (int i = 0; i < numDocs; i++) {
        logger.info("--> start primary node");
import org.opensearch.index.SegmentReplicationShardStats;
import org.opensearch.index.ReplicationStats;  
                .getCurrentReplicationState();
        waitForSearchableDocs(index_2, numDocs, nodes);  
import java.util.concurrent.CountDownLatch;
                .stream()
            .get()
            final List<SegmentReplicationPerGroupStats> replicationPerGroupStats = replicationStats.get(INDEX_NAME);
        ensureGreen();
            .setActiveOnly(true)
            .execute()
        for (SegmentReplicationPerGroupStats group : replicationPerGroupStats) {
                if (nodeStats.getNode().getName().equals(primaryNode)) {
        // now search for one shard.
            .stream()
        // verifying active_only by checking if current stage is GET_FILES STAGE
            .setActiveOnly(true)
        nodes.add(internalCluster().startDataOnlyNode());
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();  
            final SegmentReplicationState currentReplicationState = perGroupStats.getReplicaStats()  
        waitForSearchableDocs(10L, asList(primaryNode, replicaNode));
            INDEX_NAME,  
            for (SegmentReplicationShardStats replica : replicaStats) {
        // search for all  
            index(INDEX_NAME, "doc", Integer.toString(i));
            Settings.builder()
            .prepareSegmentReplicationStats(INDEX_NAME)
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.TransportService;
            });
                .get();  
                .put(indexSettings())
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        ensureYellowAndNoInitializingShards(INDEX_NAME);
                .execute()  
                    .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            )  
            index(INDEX_NAME, "doc", Integer.toString(i));  
            internalCluster().getInstance(TransportService.class, primaryNode),
        ensureSearchable(INDEX_NAME, index_2);
        final CountDownLatch waitForAssertions = new CountDownLatch(1);
        assertEquals(1, replicationStats.size());
            .indices()  
        final String primaryNode = internalCluster().startNode();  
        final String replicaNode1 = internalCluster().startNode();  
    }  
 */  
        for (int i = 0; i < numReplicas; i++) {
        int numReplicas = 4;
        String anotherDataNode = internalCluster().startDataOnlyNode();
        final CountDownLatch waitForReplication = new CountDownLatch(1);
        }  
            .shards(String.valueOf(id))
            Settings.builder()  
            assertEquals(2 * indexReplicationStats.getMaxBytesBehind(), indexReplicationStats.getTotalBytesBehind());
import org.opensearch.index.SegmentReplicationPerGroupStats;
        );  
        String dataNode = internalCluster().startDataOnlyNode();  
        List<String> nodes = new ArrayList<>();
                assertNotNull(replica.getCurrentReplicationState());  
                .cluster()
        assertEquals(1, replicationStats.size());
        }
            indexingThread.join();
import org.opensearch.cluster.metadata.IndexMetadata;  
            assertEquals(4, replicaStats.size());
        logger.info("--> start second replica node");
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(1, replicationPerGroupStats.size());  
        for (int i = 0; i < numDocs; i++) {
        }  
        replicationStats = segmentReplicationStatsResponse.getReplicationStats();  
            assertEquals(segmentReplicationStatsResponse.getTotalShards(), numShards * 2);  
        nodes.add(primaryNode);
        refresh(INDEX_NAME);
        ));  
        ensureGreen(INDEX_NAME);
            replicaStats = perGroupStats.getReplicaStats();  
        SegmentReplicationStatsResponse segmentReplicationStatsResponse = client().admin()
            Settings.builder()
        }, 30, TimeUnit.SECONDS);
            .prepareSegmentReplicationStats(INDEX_NAME)  
                .actionGet();  
        refresh(INDEX_NAME);
                .execute()
                }
        final IndexShard index_2_primary = getIndexShard(primaryNode, index_2);
        SegmentReplicationStatsResponse segmentReplicationStatsResponse = client().admin()
            (connection, requestId, action, request, options) -> {  
            .prepareSegmentReplicationStats()
                    } catch (InterruptedException e) {
