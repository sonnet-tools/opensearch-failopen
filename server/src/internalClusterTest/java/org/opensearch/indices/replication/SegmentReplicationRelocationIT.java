        indexingThread.start();
        assertEquals(clusterHealthResponse.isTimedOut(), false);
    @TestLogging(reason = "Enable trace logs from replication and recovery package", value = "org.opensearch.indices.recovery:TRACE,org.opensearch.indices.replication:TRACE")
 * SPDX-License-Identifier: Apache-2.0
            .setWaitForEvents(Priority.LANGUID)
        ensureGreen(INDEX_NAME);
import org.opensearch.transport.TransportService;
 */
        }, 1, TimeUnit.MINUTES);
import org.opensearch.cluster.routing.ShardRoutingState;
        }
        assertEquals(client().prepareSearch(INDEX_NAME).setSize(0).execute().actionGet().getHits().getTotalHits().value(), 20L);
                }
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
        );
                );
        mockTransportService.addSendBehavior(
        clusterHealthResponse = client().admin()
            client().admin().indices().prepareRefresh().execute().actionGet();
        prepareCreate(
            .actionGet();
     */
            .cluster()
            .setWaitForNoRelocatingShards(true)
            .prepareHealth()
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
                connection.sendRequest(requestId, action, request, options);
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
                    .execute()
        logger.info("--> flush so we have some segment files on disk");
            pendingIndexResponses.add(
            );
import java.util.List;
        }
        assertBusy(() -> assertTrue(indicesService.hasIndex(resolveIndex(INDEX_NAME))));
    @TestLogging(reason = "Getting trace logs from replication,shard and allocation package", value = "org.opensearch.indices.replication:TRACE, org.opensearch.index.shard:TRACE, org.opensearch.cluster.routing.allocation:TRACE")
     * This test verifies primary recovery behavior with continuous ingestion
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                    .setRefreshPolicy(refreshPolicy)
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
            ShardRoutingState.STARTED
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
     * This test verifies delayed operations during primary handoff are replayed and searchable. It does so by halting
    public void testRelocateWithQueuedOperationsDuringHandoff() throws Exception {
        final String oldPrimary = internalCluster().startNode();
        flush(INDEX_NAME);
            .prepareReroute()
            .cluster()
        flush(INDEX_NAME);
            .cluster()
            .execute()
                connection.sendRequest(requestId, action, request, options);
    }
        final WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());
            }
            pendingIndexResponses.add(
        assertBusy(() -> {
                client().prepareIndex(INDEX_NAME)
import org.opensearch.cluster.ClusterState;
        // parallel.
                    .execute()
        assertEquals(clusterHealthResponse.isTimedOut(), false);
        clusterHealthResponse = client().admin()
    public void testAddNewReplicaFailure() throws Exception {
            .execute()
/**
        logger.info("--> verifying count");
        assertEquals(clusterHealthResponse.isTimedOut(), false);
        ensureGreen(INDEX_NAME);
            } catch (InterruptedException e) {
        }
                        throw new RuntimeException(e);
            .actionGet();
        MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
            );
        final int totalDocCount = 1000;
            .setWaitForEvents(Priority.LANGUID)
            TransportService.class,
        prepareCreate(INDEX_NAME, Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
    public void testFlushAfterRelocation() throws Exception {
        assertEquals(clusterHealthResponse.isTimedOut(), false);
            .cluster()
        prepareCreate(
        refresh(INDEX_NAME);
        assertTrue(clusterHealthResponse.isTimedOut());
        }
        ).get();
            .cluster()
            try {
            TransportService.class,
            .cluster()
            .setWaitForNoRelocatingShards(true)
        ensureGreen(INDEX_NAME);
        }, 1, TimeUnit.MINUTES);
        final int totalDocCount = 2000;
            .setWaitForEvents(Priority.LANGUID)
        logger.info("--> verifying count");
            .actionGet();
                    .setSource("field", "value" + i)
            .actionGet();
        final String primary = internalCluster().startNode();
            }
        }
                // we want to control refreshes
        waitForSearchableDocs(2 * initialDocCount, newPrimary, replica);
            .get();
            .cluster()
        assertAcked(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        for (int i = initialDocCount; i < 2 * initialDocCount; i++) {
            .add(new MoveAllocationCommand(INDEX_NAME, 0, oldPrimary, newPrimary))
            Set.of(replicaShard.routingEntry().allocationId().getId()),
        client().admin().indices().prepareFlush().execute().actionGet();
                    .setRefreshPolicy(refreshPolicy)
        assertEquals(clusterHealthResponse.isTimedOut(), false);
        verifyStoreContent();
        clusterHealthResponse = client().admin()
        logger.info("--> relocate the shard from primary to replica");
        final String replica = internalCluster().startNode();
            pendingIndexResponses.add(
                    waitForRecovery.countDown();
            .setWaitForEvents(Priority.LANGUID)
        createIndex(1);
        final WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());
            .setWaitForNodes("3")
import org.opensearch.test.OpenSearchIntegTestCase;
        assertAcked(
public class SegmentReplicationRelocationIT extends SegmentReplicationBaseIT {
        );
        );
                    .setId(Integer.toString(i))
        MockTransportService mockTargetTransportService = ((MockTransportService) internalCluster().getInstance(
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
            .cluster()
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
                    .execute()
        final IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
        );
        assertBusy(() -> {
import org.opensearch.cluster.metadata.IndexMetadata;
        );
                .put("index.refresh_interval", -1)
        logger.info("--> index 10 docs");
                    .setSource("field", "value" + i)
        ensureGreen(INDEX_NAME);
        final String newPrimary = internalCluster().startNode();
        ensureGreen(INDEX_NAME);
        logger.info("--> start empty node to add replica shard");
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
                client().prepareIndex(INDEX_NAME)
        final String replica = internalCluster().startNode();
     */
import org.opensearch.common.settings.Settings;
        logger.info("--> flush to have segments on disk");
            .prepareReroute()
            .execute()
     */
        clusterHealthResponse = client().admin()
                    .setId(Integer.toString(i))
            .prepareHealth()
import java.util.concurrent.CountDownLatch;
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();
     * segment replication which is performed while holding primary indexing permits which results in queuing of
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));
            .add(new MoveAllocationCommand(INDEX_NAME, 0, primary, newPrimary))
            .add(new MoveAllocationCommand(INDEX_NAME, 0, primaryNode, newPrimary))
            pendingIndexResponses.add(
                pendingIndexResponses.add(
        ActionFuture<ClusterRerouteResponse> relocationListener = client().admin()
        logger.info("--> starting [Primary Node] ...");
        mockTransportService.addSendBehavior(
            .add(new MoveAllocationCommand(INDEX_NAME, 0, primary, newPrimary))
            (connection, requestId, action, request, options) -> {
        for (int i = initialDocCount; i < 2 * initialDocCount; i++) {
        assertEquals(clusterHealthResponse.isTimedOut(), false);
        // This thread first waits for recovery to halt during segment replication. After which it ingests data to ensure
import org.opensearch.test.transport.MockTransportService;
            client().admin().indices().prepareRefresh().execute().actionGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.common.Priority;
            state.getRoutingNodes().node(state.nodes().resolveNode(newPrimary).getId()).iterator().next().state(),
        }
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)
        logger.info("--> get the state, verify shard 1 primary moved from node1 to node2");
        waitForRecovery.await();
        // Verify segment replication event never happened on replica shard other than recovery.
    /**
    private void createIndex(int replicaCount) {
        waitForSearchableDocs(totalDocCount, newPrimary, replica);
                    throw new OpenSearchCorruptionException("expected");
                    .setSource("field", "value" + i)
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));
        ClusterHealthResponse clusterHealthResponse = client().admin()
                    .setSource("field", "value" + i)
            .prepareHealth()
     * This test verifies the primary relocation behavior when segment replication round fails during recovery. Post
        verifyStoreContent();
            .execute()
            .cluster()
            .setWaitForNoRelocatingShards(true)
        for (int i = 10; i < 20; i++) {
            .cluster()
        flushAndRefresh(INDEX_NAME);
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
        }, 2, TimeUnit.MINUTES);
            .setWaitForEvents(Priority.LANGUID)
        ActionFuture<ClusterRerouteResponse> relocationListener = client().admin()
        indexingThread.join();
            .setWaitForNodes("3")
import org.opensearch.indices.IndicesService;
    /**
import org.opensearch.action.index.IndexResponse;
        prepareCreate(INDEX_NAME, Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, replicaCount)).get();
        MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
import java.util.Set;
    }
        assertEquals(0, replicaStats.stream().findFirst().get().getCheckpointsBehindCount());
            );
            .cluster()
            client().admin().indices().prepareRefresh().execute().actionGet();
                    .setSource("field", "value" + i)
        for (int i = 0; i < 10; i++) {
        logger.info("--> flush to have segments on disk");
            .actionGet();
            INDEX_NAME,
                    .setRefreshPolicy(refreshPolicy)
                client().prepareIndex(INDEX_NAME)
    /**
    }
    public void testRelocateWhileContinuouslyIndexingAndWaitingForRefresh() throws Exception {
            newPrimary
        relocationListener.actionGet();
        }
    public void testPrimaryRelocationWithSegRepFailure() throws Exception {
        CountDownLatch waitForIndexingLatch = new CountDownLatch(1);
        client().admin()
                    .setId(Integer.toString(i))
            .setTimeout(TimeValue.timeValueSeconds(2))
                client().prepareIndex(INDEX_NAME)
import java.util.stream.Collectors;
            .prepareReroute()
        }
            .execute()
        logger.info("--> flush so we have some segment files on disk");
        mockTargetTransportService.addSendBehavior(
            .get(0)
                    .setRefreshPolicy(refreshPolicy)
        for (int i = 10; i < 20; i++) {
            assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setPreference("_only_local").setSize(0).get(), initialDocCount);
     * This test verifies that adding a new node which results in peer recovery as replica; also bring replica's
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            .get(INDEX_NAME)
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();
            (connection, requestId, action, request, options) -> {
        assertEquals(clusterHealthResponse.isTimedOut(), false);
        logger.info("--> start empty node to add replica shard");
import org.opensearch.test.junit.annotations.TestLogging;
        logger.info("--> start another node");
        for (int i = 0; i < initialDocCount; i++) {
        final String newPrimary = internalCluster().startNode();
            .actionGet();
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
            .actionGet();
 */
    public void testNewlyAddedReplicaIsUpdated() throws Exception {
        ensureGreen(INDEX_NAME);
     *
            client().admin().indices().prepareUpdateSettings(INDEX_NAME).setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 1))
        for (int i = 10; i < 20; i++) {
        }
            .setWaitForEvents(Priority.LANGUID)
            .cluster()
        final String newPrimary = internalCluster().startNode();
            .prepareHealth()
        client().admin().indices().prepareFlush().execute().actionGet();
        for (int i = 0; i < 10; i++) {
            .execute()
        // Relocate primary to new primary. When new primary starts it does perform a flush.
                    .execute()
            .setWaitForNodes("3")
        final String replica = internalCluster().startNode();
                    .execute()
            .actionGet();
            .execute();
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
            pendingIndexResponses.add(
            pendingIndexResponses.add(
        // the primary still has not refreshed to update its checkpoint, so our replica is not yet behind.
import org.opensearch.common.unit.TimeValue;
        ensureGreen(INDEX_NAME);
            TransportService.class,
     * operations during handoff. The test verifies all docs ingested are searchable on new primary.
     *
            .prepareHealth()
            .execute()
            .prepareHealth()
            .setWaitForNodes("3")
        // Mock transport service to add behaviour of throwing corruption exception during segment replication process.
        for (int i = 0; i < initialDocCount; i++) {
        logger.info("Verify older primary is still refreshing replica nodes");
        logger.info("--> verifying count");
            }
        final String replica = internalCluster().startNode();
        final String oldPrimary = internalCluster().startNode();
            .setWaitForEvents(Priority.LANGUID)
        logger.info("--> relocate the shard");
                    .setId(Integer.toString(i))
        // Get mock transport service from newPrimary, halt recovery during segment replication (during handoff) to allow indexing in
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();
                connection.sendRequest(requestId, action, request, options);
        ClusterHealthResponse clusterHealthResponse = client().admin()
        refresh(INDEX_NAME);
            .prepareHealth()
            .prepareHealth()
        assertEquals(
        CountDownLatch blockSegRepLatch = new CountDownLatch(1);
            Settings.builder()
}
            client().admin().indices().prepareRefresh().execute().actionGet();
        final WriteRequest.RefreshPolicy refreshPolicy = randomFrom(WriteRequest.RefreshPolicy.values());
                if (action.equals(SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES)) {
    /**
                    .execute()
            // Wait for relocation to halt at SegRep. Ingest docs at that point.
        final String primaryNode = internalCluster().startNode();
    }
     * replication checkpoint upto the primary's by performing a round of segment replication.
            primaryNode
        assertEquals(clusterHealthResponse.isTimedOut(), false);
        }
            .setWaitForEvents(Priority.LANGUID)
        ensureGreen(INDEX_NAME);
        client().admin()
        createIndex(1);
                client().prepareIndex(INDEX_NAME)
            internalCluster().getInstance(TransportService.class, replica),
        for (int i = 10; i < 20; i++) {
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));
        assertEquals(clusterHealthResponse.isTimedOut(), false);
            }
            .getReplicaStats();
            .prepareHealth()
        for (int i = 0; i < 10; i++) {
        }
                    .setSource("field", "value" + i)
import java.util.concurrent.TimeUnit;
        final String replica = internalCluster().startNode();
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));
import org.opensearch.index.SegmentReplicationShardStats;
import org.opensearch.index.shard.IndexShard;
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;
            .actionGet();
        final String primaryNode = internalCluster().startNode();
        ));
        ActionFuture<ClusterRerouteResponse> relocationListener = client().admin()
        final String replica = internalCluster().startNode();
        assertEquals(client().prepareSearch(INDEX_NAME).setSize(0).execute().actionGet().getHits().getTotalHits().value(), 20L);
        assertHitCount(client(replicaNode).prepareSearch(INDEX_NAME).setPreference("_only_local").setSize(0).get(), 0);
        waitForSearchableDocs(20, primary, replica);
        final int initialDocCount = scaledRandomIntBetween(10, 100);
    }
            .cluster()
     */
package org.opensearch.indices.replication;
        ensureYellow(INDEX_NAME);
            .cluster()
            .setWaitForGreenStatus()
                client().prepareIndex(INDEX_NAME)
     */
        ClusterHealthResponse clusterHealthResponse = client().admin()
        assertHitCount(client(primaryNode).prepareSearch(INDEX_NAME).setPreference("_only_local").setSize(0).get(), 0);
        ).get();
        assertBusy(() -> {
            .execute()
        final String replicaNode = internalCluster().startNode();
                    .setSource("field", "value" + i)
            .cluster()
            .execute()
            .prepareHealth()
        logger.info("--> relocate the shard from primary to newPrimary");
        flushAndRefresh(INDEX_NAME);
            .actionGet();
    }
        createIndex(1);
            .prepareSegmentReplicationStats(INDEX_NAME)
        logger.info("--> start another node");
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
        assertEquals(
        final Set<SegmentReplicationShardStats> replicaStats = segmentReplicationStatsResponse.getReplicationStats()
            .setWaitForEvents(Priority.LANGUID)
        logger.info("--> index more docs so we have something in the translog");
 * compatible open source license.
            .setWaitForNodes("2")
        }, 1, TimeUnit.MINUTES);
            .setWaitForEvents(Priority.LANGUID)
        ));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                        waitForIndexingLatch.await();
        // Start indexing docs
        final int initialDocCount = scaledRandomIntBetween(2000, 3000);
            waitForIndexingLatch.countDown();
        flushAndRefresh(INDEX_NAME);
                blockSegRepLatch.await();
        // Update replica count settings to 1 so that peer recovery triggers and recover replica
        for (int i = 0; i < 10; i++) {
 * The OpenSearch Contributors require contributions made to
                    .setId(Integer.toString(i))
        logger.info("--> index more docs so we have something in the translog");
                    blockSegRepLatch.countDown();
 * This test class verifies primary shard relocation with segment replication as replication strategy.
import org.opensearch.OpenSearchCorruptionException;
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
            .indices()
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0)
        // Verify if all docs are present in replica after relocation, if new relocated primary doesn't flush after relocation the below
                throw new RuntimeException(e);
            .prepareReroute()
    public void testPrimaryRelocation() throws Exception {
                    try {
/*
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, replica);
import org.opensearch.common.action.ActionFuture;
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
            );
            .setWaitForNodes("3")
        SegmentReplicationStatsResponse segmentReplicationStatsResponse = client().admin()
        logger.info("--> index more docs so there are ops in the transaction log");
        logger.info("--> relocate the shard");
        relocationListener.actionGet();
     * failure, more documents are ingested and verified on replica; which confirms older primary still refreshing the
        flushAndRefresh(INDEX_NAME);
            .execute();
     * replicas.
        Thread indexingThread = new Thread(() -> {
    /**
        flushAndRefresh(INDEX_NAME);
        for (int i = 0; i < initialDocCount; i++) {
        logger.info("--> index more docs so there are ops in the transaction log");
                    }
        waitForSearchableDocs(2 * initialDocCount, oldPrimary, replica);
                    .setId(Integer.toString(i))
        // assert will fail.
                    throw new OpenSearchCorruptionException("expected");
                    } catch (InterruptedException e) {
            .actionGet();
            pendingIndexResponses.add(
        logger.info("--> relocate the shard from primary to newPrimary");
        verifyStoreContent();
            replicaStats.stream().map(SegmentReplicationShardStats::getAllocationId).collect(Collectors.toSet())
            }
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)
            );
 *
        // Add Replica shard to the new empty replica node
        final CountDownLatch waitForRecovery = new CountDownLatch(1);
        ClusterHealthResponse clusterHealthResponse = client().admin()
                    .setId(Integer.toString(i))
        logger.info("--> verify count again {}", 2 * initialDocCount);
            .execute();
            .actionGet();
        });
    private final TimeValue ACCEPTABLE_RELOCATION_TIME = new TimeValue(5, TimeUnit.MINUTES);
     * relocation and after relocation documents are indexed and documents are verified
            .cluster()
                    .execute()
        ClusterHealthResponse clusterHealthResponse = client().admin()
            (connection, requestId, action, request, options) -> {
        final String primary = internalCluster().startNode();
 * this file be licensed under the Apache-2.0 license or a
        final int initialDocCount = scaledRandomIntBetween(10, 100);
        }
     */
            .execute()
            .setWaitForNoRelocatingShards(true)
        ensureGreen(INDEX_NAME);
        verifyStoreContent();
        }
                }
        waitForSearchableDocs(totalDocCount, replica, newPrimary);
            .actionGet();
            client().admin().indices().prepareUpdateSettings(INDEX_NAME).setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 1))
        for (int i = 20; i < totalDocCount; i++) {
                    .setRefreshPolicy(refreshPolicy)
                    client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute()
     * This test verifies happy path when primary shard is relocated newly added node (target) in the cluster. Before
     * This test verifies that replica shard is not added to the cluster when doing a round of segment replication fails during peer recovery.
        // Start another empty node for relocation
            for (int i = 20; i < totalDocCount; i++) {
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        assertBusy(() -> {
        );
            .add(new MoveAllocationCommand(INDEX_NAME, 0, oldPrimary, newPrimary))
        ));
        logger.info("--> creating test index ...");
                }
        ClusterHealthResponse clusterHealthResponse = client().admin()
        });
        // documents are queued.
        }
        clusterHealthResponse = client().admin()
            .prepareReroute()
            .execute()
        // Starting two nodes with primary and replica shards respectively.
            );
import org.opensearch.action.support.WriteRequest;
            .execute()
            .setWaitForNoRelocatingShards(true)
        final String primary = internalCluster().startNode();
            .execute()
            .execute()
    /**
            .actionGet();
        createIndex(1);
            .setWaitForEvents(Priority.LANGUID)
            INDEX_NAME,
    }
        verifyStoreContent();
        assertBusy(() -> {
        final String newPrimary = internalCluster().startNode();
        ensureGreen(INDEX_NAME);
        assertEquals(clusterHealthResponse.isTimedOut(), false);
        // Mock transport service to add behaviour of throwing corruption exception during segment replication process.
            internalCluster().getInstance(TransportService.class, newPrimary),
            oldPrimary
        );
import java.util.ArrayList;
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
            );
        // Verify that cluster state is not green and replica shard failed during a round of segment replication is not added to the cluster
    }
                client().prepareIndex(INDEX_NAME)
        final String newPrimary = internalCluster().startNode();
            internalCluster().getInstance(TransportService.class, primary),
            .prepareHealth()
