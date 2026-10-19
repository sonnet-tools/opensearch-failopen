    }
        clusterHealthResponse = client().admin()
            }
                    .setId(Integer.toString(i))
                    .setSource("field", "value" + i)
        }  
import org.opensearch.common.unit.TimeValue;
        final int totalDocCount = 2000;  
                if (action.equals(SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES)) {  
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
        assertBusy(() -> {
            .actionGet();
                    .execute()
            .cluster()
        for (int i = 0; i < 10; i++) {
                    .setId(Integer.toString(i))  
    /**
            .get(INDEX_NAME)  
    }
        ).get();
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)  
        final String primary = internalCluster().startNode();
                    .setRefreshPolicy(refreshPolicy)
        }  
            internalCluster().getInstance(TransportService.class, primary),
    public void testFlushAfterRelocation() throws Exception {
     *  
            .prepareReroute()
            .setWaitForEvents(Priority.LANGUID)
            .execute()
        CountDownLatch waitForIndexingLatch = new CountDownLatch(1);
        client().admin().indices().prepareFlush().execute().actionGet();  
            .execute()
            replicaStats.stream().map(SegmentReplicationShardStats::getAllocationId).collect(Collectors.toSet())
                    throw new OpenSearchCorruptionException("expected");
        assertEquals(
        client().admin()
                    .setId(Integer.toString(i))
import java.util.Set;
        mockTargetTransportService.addSendBehavior(  
 * This test class verifies primary shard relocation with segment replication as replication strategy.
            .execute()
            .cluster()  
        final String oldPrimary = internalCluster().startNode();
        });
        assertEquals(clusterHealthResponse.isTimedOut(), false);
                    waitForRecovery.countDown();  
        );  
            } catch (InterruptedException e) {  
            pendingIndexResponses.add(  
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);  
        ensureGreen(INDEX_NAME);
            .prepareReroute()
        final String replicaNode = internalCluster().startNode();  
    public void testNewlyAddedReplicaIsUpdated() throws Exception {
            .cluster()
                client().prepareIndex(INDEX_NAME)
        logger.info("--> verifying count");
        for (int i = 20; i < totalDocCount; i++) {
        flushAndRefresh(INDEX_NAME);
        );  
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();
            .prepareHealth()
            .execute()
import org.opensearch.common.settings.Settings;
     */  
    private final TimeValue ACCEPTABLE_RELOCATION_TIME = new TimeValue(5, TimeUnit.MINUTES);  
            .indices()
            .setWaitForEvents(Priority.LANGUID)
     * This test verifies primary recovery behavior with continuous ingestion
        }
            client().admin().indices().prepareUpdateSettings(INDEX_NAME).setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 1))
                    blockSegRepLatch.countDown();
        assertEquals(clusterHealthResponse.isTimedOut(), false);
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
            .actionGet();  
        final String replica = internalCluster().startNode();  
        final int initialDocCount = scaledRandomIntBetween(2000, 3000);
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();  
        logger.info("--> creating test index ...");
        }, 1, TimeUnit.MINUTES);
            .cluster()  
        logger.info("--> index more docs so we have something in the translog");  
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)  
            .cluster()  
            .prepareReroute()  
        ));  
        final String replica = internalCluster().startNode();
            .prepareHealth()
            client().admin().indices().prepareRefresh().execute().actionGet();
        assertEquals(clusterHealthResponse.isTimedOut(), false);
     *
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        final IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);  
        for (int i = 10; i < 20; i++) {  
    }
            newPrimary
    @TestLogging(reason = "Enable trace logs from replication and recovery package", value = "org.opensearch.indices.recovery:TRACE,org.opensearch.indices.replication:TRACE")
            .setWaitForNodes("3")  
        logger.info("--> relocate the shard from primary to newPrimary");
    }  
import org.opensearch.test.junit.annotations.TestLogging;
            internalCluster().getInstance(TransportService.class, replica),  
        assertBusy(() -> assertTrue(indicesService.hasIndex(resolveIndex(INDEX_NAME))));
 */  
    }
        verifyStoreContent();
import org.opensearch.cluster.metadata.IndexMetadata;
                client().prepareIndex(INDEX_NAME)  
            pendingIndexResponses.add(
        ActionFuture<ClusterRerouteResponse> relocationListener = client().admin()  
        prepareCreate(INDEX_NAME, Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
        for (int i = 10; i < 20; i++) {
                client().prepareIndex(INDEX_NAME)
                    throw new OpenSearchCorruptionException("expected");  
        ).get();
    @TestLogging(reason = "Getting trace logs from replication,shard and allocation package", value = "org.opensearch.indices.replication:TRACE, org.opensearch.index.shard:TRACE, org.opensearch.cluster.routing.allocation:TRACE")
        logger.info("--> index 10 docs");  
        assertEquals(clusterHealthResponse.isTimedOut(), false);
        flushAndRefresh(INDEX_NAME);
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        logger.info("--> start empty node to add replica shard");  
            INDEX_NAME,  
        mockTransportService.addSendBehavior(
     * failure, more documents are ingested and verified on replica; which confirms older primary still refreshing the
            waitForIndexingLatch.countDown();
     */  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        logger.info("--> flush so we have some segment files on disk");
        logger.info("--> relocate the shard from primary to newPrimary");
    /**
import org.opensearch.action.index.IndexResponse;
    public void testAddNewReplicaFailure() throws Exception {
            pendingIndexResponses.add(  
        }
            oldPrimary  
        assertEquals(clusterHealthResponse.isTimedOut(), false);
        ClusterHealthResponse clusterHealthResponse = client().admin()  
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
        for (int i = 0; i < initialDocCount; i++) {
        verifyStoreContent();
        createIndex(1);
            );
        }
        final String newPrimary = internalCluster().startNode();
            .getReplicaStats();
/**
        for (int i = initialDocCount; i < 2 * initialDocCount; i++) {
            TransportService.class,
        clusterHealthResponse = client().admin()
        assertBusy(() -> {
            }  
                    try {
     * This test verifies that adding a new node which results in peer recovery as replica; also bring replica's
            .prepareHealth()
        ClusterHealthResponse clusterHealthResponse = client().admin()
        flushAndRefresh(INDEX_NAME);
            .prepareReroute()
        final String newPrimary = internalCluster().startNode();
        assertTrue(clusterHealthResponse.isTimedOut());
            );  
                throw new RuntimeException(e);
        logger.info("--> verify count again {}", 2 * initialDocCount);  
        assertEquals(clusterHealthResponse.isTimedOut(), false);
        verifyStoreContent();
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, replica);
        verifyStoreContent();
                }
            .actionGet();
            .setWaitForNodes("3")
        final WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());
import org.opensearch.cluster.routing.ShardRoutingState;  
        // Verify segment replication event never happened on replica shard other than recovery.
    public void testPrimaryRelocationWithSegRepFailure() throws Exception {
        final int totalDocCount = 1000;
        ensureGreen(INDEX_NAME);
            .cluster()  
        MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
                    .setId(Integer.toString(i))
                connection.sendRequest(requestId, action, request, options);
            .cluster()
            INDEX_NAME,
/*  
        clusterHealthResponse = client().admin()
            pendingIndexResponses.add(
        prepareCreate(
        createIndex(1);  
import org.opensearch.common.Priority;
        // Start indexing docs  
     */
        clusterHealthResponse = client().admin()
        // Verify that cluster state is not green and replica shard failed during a round of segment replication is not added to the cluster  
        relocationListener.actionGet();
 * compatible open source license.
        logger.info("--> relocate the shard");
        );
            (connection, requestId, action, request, options) -> {
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
        logger.info("--> flush to have segments on disk");
        ClusterHealthResponse clusterHealthResponse = client().admin()
import org.opensearch.test.OpenSearchIntegTestCase;  
     * replicas.
            .execute()
            .execute()
                client().prepareIndex(INDEX_NAME)
        assertEquals(clusterHealthResponse.isTimedOut(), false);
import org.opensearch.index.SegmentReplicationShardStats;  
            .setWaitForNodes("3")
            .prepareReroute()
import org.opensearch.indices.IndicesService;
        // Get mock transport service from newPrimary, halt recovery during segment replication (during handoff) to allow indexing in
        logger.info("--> verifying count");  
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setPreference("_only_local").setSize(0).get(), 0);
        // the primary still has not refreshed to update its checkpoint, so our replica is not yet behind.
        mockTransportService.addSendBehavior(
            .actionGet();  
            .cluster()
            .actionGet();  
            .add(new MoveAllocationCommand(INDEX_NAME, 0, primary, newPrimary))  
        assertEquals(clusterHealthResponse.isTimedOut(), false);  
            );  
            Settings.builder()
            .prepareHealth()  
                    }  
        }, 1, TimeUnit.MINUTES);
            .cluster()
    public void testRelocateWithQueuedOperationsDuringHandoff() throws Exception {
                    .execute()  
        // Start another empty node for relocation  
        }, 2, TimeUnit.MINUTES);
        for (int i = 10; i < 20; i++) {
        flush(INDEX_NAME);
        // Starting two nodes with primary and replica shards respectively.  
            client().admin().indices().prepareRefresh().execute().actionGet();
    }
            .actionGet();  
        logger.info("--> get the state, verify shard 1 primary moved from node1 to node2");  
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();  
            .cluster()  
        ensureGreen(INDEX_NAME);
import org.opensearch.transport.TransportService;  
        assertBusy(() -> {
        for (int i = 0; i < 10; i++) {  
                    client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute()
            client().admin().indices().prepareRefresh().execute().actionGet();
            .setWaitForEvents(Priority.LANGUID)
        }
import org.opensearch.cluster.ClusterState;
            .prepareHealth()  
     */  
        // Verify if all docs are present in replica after relocation, if new relocated primary doesn't flush after relocation the below  
            );
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
                    .execute()
                    .setSource("field", "value" + i)
                    .setId(Integer.toString(i))
import org.opensearch.test.transport.MockTransportService;
        flushAndRefresh(INDEX_NAME);
        logger.info("--> relocate the shard");  
        // parallel.
        }  
import org.opensearch.OpenSearchCorruptionException;
            .setWaitForEvents(Priority.LANGUID)
            pendingIndexResponses.add(  
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));  
                    .setSource("field", "value" + i)  
        SegmentReplicationStatsResponse segmentReplicationStatsResponse = client().admin()  
        assertBusy(() -> {
        );
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
        refresh(INDEX_NAME);  
                    } catch (InterruptedException e) {
        }
            TransportService.class,
            .actionGet();  
     * This test verifies that replica shard is not added to the cluster when doing a round of segment replication fails during peer recovery.
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();
        logger.info("--> start another node");
     */  
            .add(new MoveAllocationCommand(INDEX_NAME, 0, primaryNode, newPrimary))  
            .setWaitForEvents(Priority.LANGUID)  
            }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        prepareCreate(  
        final Set<SegmentReplicationShardStats> replicaStats = segmentReplicationStatsResponse.getReplicationStats()
        assertAcked(
                pendingIndexResponses.add(
                    .setRefreshPolicy(refreshPolicy)
            state.getRoutingNodes().node(state.nodes().resolveNode(newPrimary).getId()).iterator().next().state(),  
        // documents are queued.
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();
    public void testRelocateWhileContinuouslyIndexingAndWaitingForRefresh() throws Exception {  
            client().admin().indices().prepareUpdateSettings(INDEX_NAME).setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 1))  
        );
        assertBusy(() -> {
    /**
            .execute()
            .cluster()
        }
                    .setId(Integer.toString(i))
            .prepareHealth()
        assertEquals(client().prepareSearch(INDEX_NAME).setSize(0).execute().actionGet().getHits().getTotalHits().value(), 20L);
                    .setRefreshPolicy(refreshPolicy)
        indexingThread.start();
            .setWaitForEvents(Priority.LANGUID)
    /**
                // we want to control refreshes
                    .setRefreshPolicy(refreshPolicy)  
            .actionGet();  
        assertEquals(clusterHealthResponse.isTimedOut(), false);  
        assertEquals(client().prepareSearch(INDEX_NAME).setSize(0).execute().actionGet().getHits().getTotalHits().value(), 20L);  
            );  
            .cluster()
import org.opensearch.common.action.ActionFuture;  
        for (int i = initialDocCount; i < 2 * initialDocCount; i++) {
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));  
 * The OpenSearch Contributors require contributions made to  
        logger.info("--> flush so we have some segment files on disk");  
        }  
        MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
            .setWaitForEvents(Priority.LANGUID)
            .setWaitForEvents(Priority.LANGUID)
        refresh(INDEX_NAME);
            .execute()  
            .execute()  
                    .execute()
 * this file be licensed under the Apache-2.0 license or a
            .cluster()
            .setWaitForNodes("3")
            for (int i = 20; i < totalDocCount; i++) {  
            .cluster()  
        final String primary = internalCluster().startNode();  
        final WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());
     * segment replication which is performed while holding primary indexing permits which results in queuing of  
            (connection, requestId, action, request, options) -> {
            .add(new MoveAllocationCommand(INDEX_NAME, 0, primary, newPrimary))
        MockTransportService mockTargetTransportService = ((MockTransportService) internalCluster().getInstance(  
        logger.info("--> flush to have segments on disk");  
     * This test verifies the primary relocation behavior when segment replication round fails during recovery. Post  
        ensureGreen(INDEX_NAME);
            .setWaitForEvents(Priority.LANGUID)  
                    .execute()
            .prepareHealth()  
        logger.info("--> starting [Primary Node] ...");
        // Mock transport service to add behaviour of throwing corruption exception during segment replication process.  
            .setWaitForNodes("2")
            Set.of(replicaShard.routingEntry().allocationId().getId()),
            );
            .setWaitForGreenStatus()  
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));  
                    .execute()
        final String replica = internalCluster().startNode();
    }
        client().admin().indices().prepareFlush().execute().actionGet();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
            .actionGet();
        final String replica = internalCluster().startNode();  
            .cluster()  
        waitForSearchableDocs(totalDocCount, newPrimary, replica);  
                    .setSource("field", "value" + i)  
     * This test verifies happy path when primary shard is relocated newly added node (target) in the cluster. Before
package org.opensearch.indices.replication;
        verifyStoreContent();
            .actionGet();
            .get();
        final int initialDocCount = scaledRandomIntBetween(10, 100);  
        // assert will fail.
            .prepareHealth()
        }  
import org.opensearch.index.shard.IndexShard;
        for (int i = 0; i < 10; i++) {
        relocationListener.actionGet();
        prepareCreate(INDEX_NAME, Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, replicaCount)).get();  
import java.util.concurrent.TimeUnit;  
        flushAndRefresh(INDEX_NAME);
        logger.info("--> start another node");
        for (int i = 0; i < initialDocCount; i++) {  
        ensureGreen(INDEX_NAME);
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0)
                    .setRefreshPolicy(refreshPolicy)  
        final String newPrimary = internalCluster().startNode();  
            primaryNode  
            .execute();
            assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setPreference("_only_local").setSize(0).get(), initialDocCount);  
        });  
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setPreference("_only_local").setSize(0).get(), 0);  
            .get(0)
        waitForSearchableDocs(2 * initialDocCount, newPrimary, replica);
            .setWaitForNoRelocatingShards(true)  
        waitForSearchableDocs(20, primary, replica);  
        assertEquals(  
            .execute()  
        indexingThread.join();  
            .execute()
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        waitForRecovery.await();  
            .setWaitForNoRelocatingShards(true)  
                        waitForIndexingLatch.await();  
        flush(INDEX_NAME);
            .execute()
            pendingIndexResponses.add(
                connection.sendRequest(requestId, action, request, options);
            .actionGet();
                connection.sendRequest(requestId, action, request, options);  
            pendingIndexResponses.add(
 */  
            .actionGet();  
        CountDownLatch blockSegRepLatch = new CountDownLatch(1);
        final CountDownLatch waitForRecovery = new CountDownLatch(1);
        final WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());
                client().prepareIndex(INDEX_NAME)  
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));  
            .cluster()
    }  
                blockSegRepLatch.await();
            .execute();
        ClusterHealthResponse clusterHealthResponse = client().admin()  
 * SPDX-License-Identifier: Apache-2.0
    /**
        // Add Replica shard to the new empty replica node
            }
        final String oldPrimary = internalCluster().startNode();  
public class SegmentReplicationRelocationIT extends SegmentReplicationBaseIT {
        clusterHealthResponse = client().admin()
                    .setSource("field", "value" + i)  
        createIndex(1);  
            .add(new MoveAllocationCommand(INDEX_NAME, 0, oldPrimary, newPrimary))
            internalCluster().getInstance(TransportService.class, newPrimary),  
                }
        }, 1, TimeUnit.MINUTES);
        }
        logger.info("--> verifying count");  
            .actionGet();
        ensureGreen(INDEX_NAME);
            try {
        final String primaryNode = internalCluster().startNode();
        // Mock transport service to add behaviour of throwing corruption exception during segment replication process.  
 *
            );
            .setWaitForEvents(Priority.LANGUID)
            .setTimeout(TimeValue.timeValueSeconds(2))
        );
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
        ActionFuture<ClusterRerouteResponse> relocationListener = client().admin()  
                        throw new RuntimeException(e);
            ShardRoutingState.STARTED
        for (int i = 10; i < 20; i++) {
        final String replica = internalCluster().startNode();
            .execute()  
            .setWaitForNoRelocatingShards(true)  
        );
        ClusterHealthResponse clusterHealthResponse = client().admin()
            .execute();  
        logger.info("--> index more docs so there are ops in the transaction log");  
                }
                    .setSource("field", "value" + i)
            .setWaitForNoRelocatingShards(true)
        }
        // Relocate primary to new primary. When new primary starts it does perform a flush.
    /**  
            (connection, requestId, action, request, options) -> {
        assertEquals(clusterHealthResponse.isTimedOut(), false);
        client().admin()
import java.util.ArrayList;
    public void testPrimaryRelocation() throws Exception {
        createIndex(1);
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
        ensureGreen(INDEX_NAME);  
        final String primaryNode = internalCluster().startNode();  
            .add(new MoveAllocationCommand(INDEX_NAME, 0, oldPrimary, newPrimary))
            .setWaitForEvents(Priority.LANGUID)
                client().prepareIndex(INDEX_NAME)  
        logger.info("--> index more docs so there are ops in the transaction log");  
            TransportService.class,
            .setWaitForNodes("3")
                    .setId(Integer.toString(i))
        logger.info("Verify older primary is still refreshing replica nodes");  
            .prepareHealth()
        ));
        logger.info("--> index more docs so we have something in the translog");
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)
     * operations during handoff. The test verifies all docs ingested are searchable on new primary.
            .actionGet();  
        ensureYellow(INDEX_NAME);
        ClusterHealthResponse clusterHealthResponse = client().admin()
            .prepareHealth()  
     * This test verifies delayed operations during primary handoff are replayed and searchable. It does so by halting
            // Wait for relocation to halt at SegRep. Ingest docs at that point.  
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;  
import java.util.List;  
import java.util.stream.Collectors;
        for (int i = 0; i < initialDocCount; i++) {
        final String replica = internalCluster().startNode();
        waitForSearchableDocs(2 * initialDocCount, oldPrimary, replica);  
        final String newPrimary = internalCluster().startNode();  
                    .setSource("field", "value" + i)
     */
            .prepareSegmentReplicationStats(INDEX_NAME)
        waitForSearchableDocs(totalDocCount, replica, newPrimary);  
        // Update replica count settings to 1 so that peer recovery triggers and recover replica  
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
                    .execute()
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();  
            client().admin().indices().prepareRefresh().execute().actionGet();
        assertEquals(0, replicaStats.stream().findFirst().get().getCheckpointsBehindCount());
        logger.info("--> relocate the shard from primary to replica");
        ensureGreen(INDEX_NAME);
        ActionFuture<ClusterRerouteResponse> relocationListener = client().admin()
            .execute()
        ));
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
import java.util.concurrent.CountDownLatch;
                .put("index.refresh_interval", -1)  
        final String primary = internalCluster().startNode();
        final int initialDocCount = scaledRandomIntBetween(10, 100);
        // This thread first waits for recovery to halt during segment replication. After which it ingests data to ensure  
        Thread indexingThread = new Thread(() -> {
            }  
        final String newPrimary = internalCluster().startNode();
        }
import org.opensearch.action.support.WriteRequest;  
        logger.info("--> start empty node to add replica shard");
            .setWaitForNoRelocatingShards(true)  
                );  
     * relocation and after relocation documents are indexed and documents are verified
}  
        for (int i = 0; i < 10; i++) {  
            .prepareHealth()
     * replication checkpoint upto the primary's by performing a round of segment replication.  
        assertAcked(
    private void createIndex(int replicaCount) {
                client().prepareIndex(INDEX_NAME)
