    public void testUpdateVisibleCheckpointWithLaggingClusterStateUpdates_primaryRelocation() throws Exception {
    public void testCancelReplicationWhileFetchingMetadata() throws Exception {
import java.util.Optional;
        Settings nodeSettings = Settings.builder().put(buildRemoteStoreNodeAttributes(location, 0d, "metadata", Long.MAX_VALUE)).build();
                .indices()
            assertEquals(0L, replicationStats.totalBytesBehind);
import org.opensearch.indices.replication.SegmentReplicationTargetService;
        ClusterHealthResponse clusterHealthResponse = client().admin()
                newPrimary_shard.getLatestReplicationCheckpoint().getSegmentInfosVersion(),
        refresh(INDEX_NAME);
            .setWaitForEvents(Priority.LANGUID)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
        final IndexShard indexShard = getIndexShard(replicaNode, INDEX_NAME);
    @Override
        assertNotNull(indexService);
        assertBusy(() -> {
        internalCluster().setDisruptionScheme(disruption);
    private String getNode(Set<String> dataNodeNames, boolean primary) {
 */
    public void testCancelReplicationWhileSyncingSegments() throws Exception {
        assertEquals(clusterHealthResponse.isTimedOut(), false);
        waitForBlock(replicaNode, REPOSITORY_NAME, TimeValue.timeValueSeconds(10));
                .prepareUpdateSettings(INDEX_NAME)
public class SegmentReplicationUsingRemoteStoreDisruptionIT extends AbstractRemoteStoreMockRepositoryIntegTestCase {
        }
            ClusterStatsResponse clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();
        IndexShard replica = getIndexShard(replicaNode, INDEX_NAME);
import org.opensearch.indices.IndicesService;
        assertEquals("Target should be closed", 0, segmentReplicationTarget.refCount());
        SegmentReplicationTargetService targetService = internalCluster().getInstance(SegmentReplicationTargetService.class, replicaNode);
import java.util.Set;
        final String primaryNode = getNode(dataNodeNames, true);
        final String newPrimary = internalCluster().startDataOnlyNode(nodeSettings);
        final String replicaNode = getNode(dataNodeNames, false);
        assertAcked(
        assertEquals("Target should be closed", 0, segmentReplicationTarget.refCount());
import org.opensearch.index.IndexService;
 * The OpenSearch Contributors require contributions made to
        assertBusy(() -> {
            assertEquals(0L, replicationStats.maxBytesBehind);
        assertEquals(clusterHealthResponse.isTimedOut(), false);
            .cluster()
        blockNodeOnAnyFiles(REPOSITORY_NAME, replicaNode);
        assertEquals(SegmentReplicationState.Stage.GET_CHECKPOINT_INFO, segmentReplicationTarget.state().getStage());
        });
        );
import org.opensearch.test.OpenSearchIntegTestCase;
            .actionGet();
        return remoteStoreIndexSettings(1);
import org.opensearch.common.Priority;
import org.opensearch.index.shard.IndexShard;
        return shardId.map(indexService::getShard).orElse(null);
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", randomInt()).get();
        final Set<String> dataNodeNames = internalCluster().getDataNodeNames();
            .get();
        ensureGreen(INDEX_NAME);
        disruption.stopDisrupting();
            .prepareHealth()
        Path location = randomRepoPath().toAbsolutePath();
        assertEquals(SegmentReplicationState.Stage.GET_FILES, segmentReplicationTarget.state().getStage());
        assertNull(targetService.get(indexShard.shardId()));
        internalCluster().startDataOnlyNodes(2, nodeSettings);
            .add(new MoveAllocationCommand(INDEX_NAME, 0, oldPrimary, newPrimary))
        indexSingleDoc();
    }
        unblockNode(REPOSITORY_NAME, replicaNode);
            .cluster()
        final Index index = resolveIndex(indexName);
            .execute()
        client().admin()
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
            .actionGet();
    }
    }
        final String replicaNode = getNode(dataNodeNames, false);
        clusterHealthResponse = client().admin()
import org.opensearch.test.disruption.SlowClusterStateProcessing;
            .setWaitForNoRelocatingShards(true)
        ensureGreen(INDEX_NAME);
    }
        Path location = randomRepoPath().toAbsolutePath();
        assertEquals(2, dataNodeNames.size());
        return null;
        IndexService indexService = indicesService.indexService(index);
 * this file be licensed under the Apache-2.0 license or a
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        cleanupRepo();
import org.opensearch.common.unit.TimeValue;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            .cluster()
import org.opensearch.cluster.metadata.IndexMetadata;
            .setTimeout(new TimeValue(5, TimeUnit.MINUTES))
            if (indexShard.routingEntry().primary() == primary) {
        final Settings indexSettings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build();
        final String replicaNode = getNode(dataNodeNames, false);
        SegmentReplicationTarget segmentReplicationTarget = targetService.get(indexShard.shardId());
        // index a doc.
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
        logger.info("--> start another node");
    private IndexShard getIndexShard(String node, String indexName) {
import org.opensearch.index.ReplicationStats;
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        unblockNode(REPOSITORY_NAME, replicaNode);
        indexSingleDoc();
            client().admin()
    public Settings indexSettings() {
                .prepareUpdateSettings(INDEX_NAME)
            .setWaitForNodes("4")
        SlowClusterStateProcessing disruption = new SlowClusterStateProcessing(replicaNode, random(), 0, 0, 1000, 2000);
        setup(location, 0d, "metadata", Long.MAX_VALUE, 1);
        // relocate the primary
        logger.info("--> relocate the shard");
import org.opensearch.core.index.Index;
            assertEquals(0L, replicationStats.maxReplicationLag);
        createIndex(INDEX_NAME, indexSettings);
            .execute()
        disableRepoConsistencyCheck("Remote Store Creates System Repository");
        final Set<String> dataNodeNames = internalCluster().getDataNodeNames();
    }
        SegmentReplicationTargetService targetService = internalCluster().getInstance(SegmentReplicationTargetService.class, replicaNode);
 * SPDX-License-Identifier: Apache-2.0
/**
 *
        IndexShard newPrimary_shard = getIndexShard(newPrimary, INDEX_NAME);
        assertNull(targetService.getOngoingEventSegmentReplicationState(indexShard.shardId()));
                replica.getLatestReplicationCheckpoint().getSegmentInfosVersion()
        ensureGreen(INDEX_NAME);
            }
            .prepareReroute()
            final IndexShard indexShard = getIndexShard(name, INDEX_NAME);
        final Set<String> dataNodeNames = internalCluster().getDataNodeNames();
 */
                return name;
            .setWaitForEvents(Priority.LANGUID)
        final IndexShard indexShard = getIndexShard(replicaNode, INDEX_NAME);
        refresh(INDEX_NAME);
        setup(location, 0d, "metadata", Long.MAX_VALUE, 1);
/*
import java.util.concurrent.TimeUnit;
package org.opensearch.remotestore;
        waitForBlock(replicaNode, REPOSITORY_NAME, TimeValue.timeValueSeconds(10));
            ReplicationStats replicationStats = clusterStatsResponse.getIndicesStats().getSegments().getReplicationStats();
        cleanupRepo();
    }
import java.nio.file.Path;
import org.opensearch.indices.replication.SegmentReplicationState;
        );
        blockNodeOnAnySegmentFile(REPOSITORY_NAME, replicaNode);
            );
import org.opensearch.common.settings.Settings;
                .indices()
        refresh(INDEX_NAME);
        assertNotNull(segmentReplicationTarget);
            assertEquals(
}
            client().admin()
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
        cleanupRepo();
 * compatible open source license.
        final String oldPrimary = getNode(dataNodeNames, true);
        SegmentReplicationTarget segmentReplicationTarget = targetService.get(indexShard.shardId());
import org.opensearch.indices.replication.SegmentReplicationTarget;
        assertTrue(segmentReplicationTarget.refCount() > 0);
        assertTrue(segmentReplicationTarget.refCount() > 0);
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        assertAcked(
        assertNotNull(segmentReplicationTarget);
        disruption.startDisrupting();
        final Optional<Integer> shardId = indexService.shardIds().stream().findFirst();
        for (String name : dataNodeNames) {
        });
            .prepareHealth()
 * This class runs tests with remote store + segRep while blocking file downloads
        Path location = randomRepoPath().toAbsolutePath();
