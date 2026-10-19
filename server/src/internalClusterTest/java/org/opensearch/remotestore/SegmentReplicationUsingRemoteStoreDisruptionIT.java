                .indices()
        assertEquals(clusterHealthResponse.isTimedOut(), false);  
    private String getNode(Set<String> dataNodeNames, boolean primary) {
        SlowClusterStateProcessing disruption = new SlowClusterStateProcessing(replicaNode, random(), 0, 0, 1000, 2000);
        disruption.startDisrupting();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .cluster()  
            .add(new MoveAllocationCommand(INDEX_NAME, 0, oldPrimary, newPrimary))
import java.util.Optional;
import org.opensearch.indices.replication.SegmentReplicationTargetService;  
        assertBusy(() -> {
        unblockNode(REPOSITORY_NAME, replicaNode);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            .setWaitForEvents(Priority.LANGUID)
import java.util.Set;  
        final Optional<Integer> shardId = indexService.shardIds().stream().findFirst();  
        final IndexShard indexShard = getIndexShard(replicaNode, INDEX_NAME);  
            ClusterStatsResponse clusterStatsResponse = client().admin().cluster().prepareClusterStats().get();  
            .prepareReroute()  
        assertAcked(
            .cluster()
        logger.info("--> relocate the shard");  
        cleanupRepo();
 * compatible open source license.
        for (String name : dataNodeNames) {
public class SegmentReplicationUsingRemoteStoreDisruptionIT extends AbstractRemoteStoreMockRepositoryIntegTestCase {  
        assertEquals("Target should be closed", 0, segmentReplicationTarget.refCount());  
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
        assertTrue(segmentReplicationTarget.refCount() > 0);
        setup(location, 0d, "metadata", Long.MAX_VALUE, 1);
        assertBusy(() -> {
        ensureGreen(INDEX_NAME);  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))  
            .get();
    public Settings indexSettings() {  
import org.opensearch.test.disruption.SlowClusterStateProcessing;
 *
        disableRepoConsistencyCheck("Remote Store Creates System Repository");
        final String primaryNode = getNode(dataNodeNames, true);
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);  
        IndexShard replica = getIndexShard(replicaNode, INDEX_NAME);  
                .indices()
}  
            .execute()
        client().admin()
        SegmentReplicationTargetService targetService = internalCluster().getInstance(SegmentReplicationTargetService.class, replicaNode);  
    private IndexShard getIndexShard(String node, String indexName) {
        assertTrue(segmentReplicationTarget.refCount() > 0);
        ClusterHealthResponse clusterHealthResponse = client().admin()
        internalCluster().setDisruptionScheme(disruption);
import org.opensearch.indices.replication.SegmentReplicationState;
    public void testCancelReplicationWhileSyncingSegments() throws Exception {
        createIndex(INDEX_NAME, indexSettings);
    }  
    }
import org.opensearch.common.settings.Settings;  
            client().admin()  
        blockNodeOnAnySegmentFile(REPOSITORY_NAME, replicaNode);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchIntegTestCase;
        final String oldPrimary = getNode(dataNodeNames, true);  
        });  
        assertEquals(clusterHealthResponse.isTimedOut(), false);
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            .setWaitForNoRelocatingShards(true)
        IndexShard newPrimary_shard = getIndexShard(newPrimary, INDEX_NAME);
        Settings nodeSettings = Settings.builder().put(buildRemoteStoreNodeAttributes(location, 0d, "metadata", Long.MAX_VALUE)).build();
            );
            .prepareHealth()
            .actionGet();  
        assertEquals(SegmentReplicationState.Stage.GET_FILES, segmentReplicationTarget.state().getStage());  
        final Index index = resolveIndex(indexName);
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))  
        Path location = randomRepoPath().toAbsolutePath();
import org.opensearch.cluster.metadata.IndexMetadata;  
    }
        waitForBlock(replicaNode, REPOSITORY_NAME, TimeValue.timeValueSeconds(10));  
        // index a doc.
        assertEquals("Target should be closed", 0, segmentReplicationTarget.refCount());  
        disruption.stopDisrupting();  
    public void testCancelReplicationWhileFetchingMetadata() throws Exception {
        assertNull(targetService.get(indexShard.shardId()));
        blockNodeOnAnyFiles(REPOSITORY_NAME, replicaNode);
            final IndexShard indexShard = getIndexShard(name, INDEX_NAME);
        });
                replica.getLatestReplicationCheckpoint().getSegmentInfosVersion()
        indexSingleDoc();
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        indexSingleDoc();
        }  
            .execute()
            .setWaitForEvents(Priority.LANGUID)
        assertNotNull(indexService);
        refresh(INDEX_NAME);
    }  
        SegmentReplicationTarget segmentReplicationTarget = targetService.get(indexShard.shardId());
        final Set<String> dataNodeNames = internalCluster().getDataNodeNames();
            }
        assertEquals(2, dataNodeNames.size());  
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;
import org.opensearch.common.unit.TimeValue;
        final Set<String> dataNodeNames = internalCluster().getDataNodeNames();
        );
import org.opensearch.indices.IndicesService;  
            .actionGet();
            client().admin()  
                return name;
            .setWaitForNodes("4")  
            assertEquals(
 */
        clusterHealthResponse = client().admin()
    @Override
        SegmentReplicationTarget segmentReplicationTarget = targetService.get(indexShard.shardId());
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull(segmentReplicationTarget);
/**
        final String replicaNode = getNode(dataNodeNames, false);  
        refresh(INDEX_NAME);
        assertEquals(SegmentReplicationState.Stage.GET_CHECKPOINT_INFO, segmentReplicationTarget.state().getStage());  
                .prepareUpdateSettings(INDEX_NAME)
        client().prepareIndex(INDEX_NAME).setId("1").setSource("foo", randomInt()).get();  
        // relocate the primary
        IndexService indexService = indicesService.indexService(index);
            assertEquals(0L, replicationStats.maxReplicationLag);  
 */  
import org.opensearch.index.IndexService;  
        assertAcked(
/*  
        final String replicaNode = getNode(dataNodeNames, false);
        assertNull(targetService.getOngoingEventSegmentReplicationState(indexShard.shardId()));
        unblockNode(REPOSITORY_NAME, replicaNode);
        cleanupRepo();
        final Settings indexSettings = Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build();
            ReplicationStats replicationStats = clusterStatsResponse.getIndicesStats().getSegments().getReplicationStats();
        final Set<String> dataNodeNames = internalCluster().getDataNodeNames();  
        internalCluster().startDataOnlyNodes(2, nodeSettings);  
        return remoteStoreIndexSettings(1);
            if (indexShard.routingEntry().primary() == primary) {  
        refresh(INDEX_NAME);
import org.opensearch.core.index.Index;
            .setTimeout(new TimeValue(5, TimeUnit.MINUTES))  
    public void testUpdateVisibleCheckpointWithLaggingClusterStateUpdates_primaryRelocation() throws Exception {
        logger.info("--> start another node");  
    }  
        SegmentReplicationTargetService targetService = internalCluster().getInstance(SegmentReplicationTargetService.class, replicaNode);  
        setup(location, 0d, "metadata", Long.MAX_VALUE, 1);  
        return null;
            .cluster()
        Path location = randomRepoPath().toAbsolutePath();  
        final String newPrimary = internalCluster().startDataOnlyNode(nodeSettings);
        return shardId.map(indexService::getShard).orElse(null);
import org.opensearch.index.shard.IndexShard;
        ensureGreen(INDEX_NAME);
                .prepareUpdateSettings(INDEX_NAME)
import org.opensearch.index.ReplicationStats;
    }
            assertEquals(0L, replicationStats.maxBytesBehind);
            assertEquals(0L, replicationStats.totalBytesBehind);
        cleanupRepo();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.indices.replication.SegmentReplicationTarget;
package org.opensearch.remotestore;
import org.opensearch.common.Priority;
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        final String replicaNode = getNode(dataNodeNames, false);
        );
        final IndexShard indexShard = getIndexShard(replicaNode, INDEX_NAME);  
                newPrimary_shard.getLatestReplicationCheckpoint().getSegmentInfosVersion(),  
            .prepareHealth()  
        waitForBlock(replicaNode, REPOSITORY_NAME, TimeValue.timeValueSeconds(10));  
 * This class runs tests with remote store + segRep while blocking file downloads  
        ensureGreen(INDEX_NAME);
        Path location = randomRepoPath().toAbsolutePath();  
        assertNotNull(segmentReplicationTarget);
