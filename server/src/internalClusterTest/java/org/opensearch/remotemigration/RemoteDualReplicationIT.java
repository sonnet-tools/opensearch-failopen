            .getNode()
            .setDocs(true)  
    private final String FAILOVER_REMOTE_TO_REMOTE = "failover-remote-to-remote";  
                .get()  
                .cluster()  
        }
            internalCluster().client()
            .prepareStats(FAILOVER_REMOTE_TO_REMOTE)
package org.opensearch.remotemigration;
                .size(),
    - Creates an index with 1 replica  
            .admin()
        assertReplicaAndPrimaryConsistency(FAILOVER_REMOTE_TO_REMOTE, 100, 0);
        docrep enabled shard copy and (GlobalCkp) for a remote enabled shard copy.
        internalCluster().validateClusterFormed();  
    */
        internalCluster().startDataOnlyNodes(2);
                .repositories()
                .cluster()  
import java.util.Collection;
                .indices()
            internalCluster().client()
                RetentionLeases retentionLeases = shardStats.getRetentionLeaseStats().retentionLeases();
            .admin()
        internalCluster().startDataOnlyNodes(2);
                    } else {  
        String primaryShardHostingNode = primaryNodeName(REMOTE_PRI_DOCREP_REP);
import org.opensearch.cluster.node.DiscoveryNodes;  
    private final String REMOTE_PRI_DOCREP_REMOTE_REP = "remote-primary-docrep-remote-replica";
        setAddRemote(true);
                .prepareUpdateSettings()  
    At this stage, segrep lag computation shouldn't consider the docrep shard copy while calculating bytes lag
    - Creates index with 1 replica
        }
                    assertRetentionLeaseConsistency(shardStats, retentionLeases);
        });
        assertAcked(
            .filter(nodeStats -> nodeStats.getNode().isRemoteStoreNode())
                .admin()
            .get()  
        logger.info("---> Starting 2 docrep data nodes");  
        assertBusy(() -> {
        String primaryNodeName = primaryNodeName(FAILOVER_REMOTE_TO_REMOTE);
        internalCluster().validateClusterFormed();  
                    RemoteSegmentStats remoteSegmentStats = shardStats.getSegments().getRemoteSegmentStats();  
    public void testMissingRetentionLeaseCreatedOnFailedOverRemoteReplica() throws Exception {  
                return false;  
        logger.info("---> Moving primary copy from {} to remote enabled node {}", primaryShardHostingNode, firstRemoteNode);  
    - Starts 1 remote backed data node
    - Index some more docs to ensure working of failed-over primary
        assertAcked(
            }  
import org.opensearch.index.remote.RemoteSegmentStats;  
                .admin()
                .indices()
                .prepareUpdateSettings()  
                        .put("index.routing.allocation.exclude._name", primaryNodeName)  
        shardStatsMap = internalCluster().client().admin().indices().prepareStats(FAILOVER_REMOTE_TO_REMOTE).setDocs(true).get().asMap();
    - Move primary copy from docrep to remote through _cluster/reroute
                .cluster()
            .currentNodeId();
                .prepareUpdateSettings(FAILOVER_REMOTE_TO_DOCREP)  
            Stream.of(InternalSettingsPlugin.class, MockFsRepositoryPlugin.class, MockTransportService.TestPlugin.class)
                .prepareGetRepositories(REPOSITORY_NAME, REPOSITORY_2_NAME)
     */
        });  
                .cluster()  
                .get()
    - Index some docs  
                .prepareReroute()
        );
        String secondRemoteNode = internalCluster().startDataOnlyNode();  
import java.util.List;  
        int secondBatch = randomIntBetween(1, 10);
            if (shardRouting.primary()) {  
                .admin()
        assertEquals(
                .indices()  
        for (ShardRouting shardRouting : shardStatsMap.keySet()) {
        internalCluster().validateClusterFormed();
        assertEquals(2, shardStatsMap.size());
            .findFirst()
        logger.info("---> Creating index with 1 replica");
        createIndex(REMOTE_PRI_DOCREP_REP, oneReplica);
        Settings excludeRemoteNode = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build();
        );
                .admin()  
        internalCluster().validateClusterFormed();
                    }  
                .prepareGetRepositories(REPOSITORY_NAME, REPOSITORY_2_NAME)
        String firstRemoteNode = internalCluster().startDataOnlyNode();
        logger.info("---> Starting 2 docrep data nodes");  
        internalCluster().startClusterManagerOnlyNode();  
        return Stream.concat(
     */  
        ensureGreen(FAILOVER_REMOTE_TO_REMOTE);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    - Starts another remote backed data node
        ).collect(Collectors.toList());
        );  
                }
        logger.info("---> Indexing {} more docs", secondBatch);
        assertReplicaAndPrimaryConsistency(REMOTE_PRI_DOCREP_REMOTE_REP, firstBatch, secondBatch);  
            .shard(0)  
                    // Checkpoints and Retention Leases are not synced to remote replicas  
        testFailoverRemotePrimaryToDocrepReplica();
    }  
        long maxSeqNo = shardStats.getSeqNoStats().getMaxSeqNo();
                if (shardRouting.primary()) {  
        indexBulk(REMOTE_PRI_DOCREP_REP, secondBatch);
         */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        pollAndCheckRetentionLeases(REMOTE_PRI_DOCREP_REMOTE_REP);  
        /* Reducing indices.memory.shard_inactive_time to force a flush and trigger translog sync,
            internalCluster().client()
                assertTrue(nodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());
        indexBulk(FAILOVER_REMOTE_TO_REMOTE, secondBatch);
import java.util.stream.Collectors;
import java.util.Map;
        instead of relying on Global CKP Sync action which doesn't run on remote enabled copies
            DiscoveryNodes nodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();  
    - Assert primary-replica consistency
            .prepareStats(FAILOVER_REMOTE_TO_DOCREP)  
                .setSettings(twoReplicas)
            .asMap();
    public void testFailoverRemotePrimaryToDocrepReplicaReseedToRemotePrimary() throws Exception {
        DiscoveryNodes nodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();  
        Map<ShardRouting, ShardStats> shardStatsMap = internalCluster().client()
    private static void assertRetentionLeaseConsistency(ShardStats shardStats, RetentionLeases retentionLeases) {
        String primaryShardHostingNodeId = clusterState.getRoutingTable()
                if (shardRouting.primary()) {  
        internalCluster().startDataOnlyNode();  
        ClusterState clusterState = internalCluster().client().admin().cluster().prepareState().get().getState();  
        internalCluster().startClusterManagerOnlyNode();  
            if (discoveryNodes.get(shardRouting.currentNodeId()).isRemoteStoreNode()) {  
                    Settings.builder()  
        String primaryShardHostingNode = primaryNodeName(REMOTE_PRI_DOCREP_REMOTE_REP);
        - InternalSettingsPlugin : To override default intervals of retention lease and global ckp sync
            } else {
        shardStatsMap = internalCluster().client().admin().indices().prepareStats(FAILOVER_REMOTE_TO_DOCREP).setDocs(true).get().asMap();
                if (shardRouting.unassigned() == false && shardRouting.primary() == false) {
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
        String remoteNodeName = internalCluster().startDataOnlyNode();
    - Index some more docs
        Settings twoReplicas = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build();
                .get()  
        pollAndCheckRetentionLeases(FAILOVER_REMOTE_TO_REMOTE);
        int firstBatch = (int) asyncIndexingService.getIndexedDocs();
                .get()
        assertBusy(() -> {
                .add(new MoveAllocationCommand(FAILOVER_REMOTE_TO_DOCREP, 0, primaryShardHostingNode, remoteNodeName))
                .repositories()
    }
    public void testFailoverRemotePrimaryToDocrepReplica() throws Exception {
        for (ShardRouting shardRouting : shardStatsMap.keySet()) {
        assertEquals(maxSeqNo, localCkp);
            internalCluster().client()
     * For a docrep enabled shard copy or a primary shard copy,
    - Starts 2 docrep backed data node  
            .get()
    - Move primary copy from docrep to remote through _cluster/reroute
                .setSettings(twoReplicas)  
    }
        asyncIndexingService.stopIndexing();
        refreshAndWaitForReplication(FAILOVER_REMOTE_TO_DOCREP);
    - Starts 1 remote backed data node  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(remoteNodeName));  
        );
        assertAcked(  
        int secondBatch = randomIntBetween(1, 10);  
                .get()  
        ClusterState clusterState = internalCluster().client().admin().cluster().prepareState().get().getState();
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService(FAILOVER_REMOTE_TO_REMOTE);
        long primaryDocCountAfterFailover = 0;
        logger.info("---> Starting another remote enabled node");
}
        - MockFsRepositoryPlugin and MockTransportService.TestPlugin: To ensure remote interactions are not no-op and retention leases are properly propagated  
                .add(new MoveAllocationCommand(FAILOVER_REMOTE_TO_REMOTE, 0, primaryShardHostingNode, firstRemoteNode))  
            .get()
        ensureGreen(FAILOVER_REMOTE_TO_REMOTE);
                    if (remoteNode) {  
import org.opensearch.cluster.ClusterState;  
                    assertTrue(nodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());
        internalCluster().validateClusterFormed();
        ensureGreen(FAILOVER_REMOTE_TO_REMOTE);  
        long initialPrimaryDocCount = 0;
        assertAcked(
        assertAcked(
            }
            }
        initDocRepToRemoteMigration();  
 * compatible open source license.
                .admin()
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "1s")
                .prepareGetRepositories(REPOSITORY_NAME, REPOSITORY_2_NAME)
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;
    - Starts 1 more remote backed data node
            .indices()
        Settings zeroReplicasAndOverridenSyncIntervals = Settings.builder()  
        int secondBatch = randomIntBetween(1, 10);
        logger.info("---> Moving primary copy from {} to remote enabled node {}", primaryShardHostingNode, remoteNodeName);
        logger.info("---> Moving primary copy from {} to remote enabled node {}", primaryShardHostingNode, remoteNodeName);  
    public void testRetentionLeasePresentOnDocrepReplicaButNotRemote() throws Exception {  
        for (ShardRouting shardRouting : shardStatsMap.keySet()) {
    - Stops remote enabled node
     * For a docrep enabled shard copy or a primary shard copy,  
                .admin()  
        }  
        List<String> docrepNodeNames = internalCluster().startDataOnlyNodes(2);  
        indexBulk(REMOTE_PRI_DOCREP_REMOTE_REP, secondBatch);  
            2  
        );
        Under steady state, RetentionLeases would be on (GlobalCkp + 1) on a
    - Ensure doc count is same after failover
            .prepareNodesStats()  
            }  
                        assertEquals(0, remoteSegmentStats.getTotalUploadTime());
                .add(new MoveAllocationCommand(REMOTE_PRI_DOCREP_REP, 0, primaryShardHostingNode, remoteNodeName))  
                .cluster()
            .index(REMOTE_PRI_DOCREP_REMOTE_REP)
            }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        logger.info("---> Moving primary copy from docrep node {} to remote enabled node {}", primaryNodeName, remoteNodeName1);
    Scenario:
     *
        );  
 * SPDX-License-Identifier: Apache-2.0
    - Move primary copy from docrep to remote through _cluster/reroute  
    private final String REMOTE_PRI_DOCREP_REP = "remote-primary-docrep-replica";  
                .repositories()  
     * asserts that the stored Retention Leases equals to 1 + maxSeqNo ingested on the node
            if (shardRouting.primary()) {
 * The OpenSearch Contributors require contributions made to  
            ClusterState clusterState = client().admin().cluster().prepareState().get().getState();  
        ensureGreen(REMOTE_PRI_DOCREP_REP);  
        logger.info("---> Starting first remote node");
    public void testZeroSegrepLagForShardsWithMixedReplicationGroup() throws Exception {
        logger.info("---> Creating index with 1 replica");
            if (shardRouting.primary()) {
        assertEquals(primaryNodeName(FAILOVER_REMOTE_TO_REMOTE), remoteNodeName1);
        assertTrue(clusterState.getNodes().get(primaryShardHostingNodeId).isRemoteStoreNode());  
            assertEquals(maxSeqNo + 1, rl.retainingSequenceNumber());
        for (RetentionLease rl : retentionLeases.leases()) {  
    - Assert retention lease consistency
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                        // Replica copy on docrep node should have retention leases
        logger.info("---> Expanding index to 2 replica copies, on docrepNode and remoteNode2");
    /*  
        ReplicationStats replicationStats = internalCluster().client()  
                .admin()
            .index(REMOTE_PRI_DOCREP_REP)  
            2  
        ensureGreen(FAILOVER_REMOTE_TO_DOCREP);
        logger.info("---> Creating index with 0 replica");
            internalCluster().client()  
                .setIndices(FAILOVER_REMOTE_TO_REMOTE)
        );
            Map<ShardRouting, ShardStats> shardStatsMap = internalCluster().client()
                    RemoteSegmentStats remoteSegmentStats = shardStats.getSegments().getRemoteSegmentStats();
    - Index some more docs  
    }
    - Stops remote enabled node hosting the primary  
            .get(0)  
        indexBulk(REMOTE_PRI_DOCREP_REMOTE_REP, firstBatch);
    Scenario:
            .indices()
            if (shardRouting.primary()) {  
                .prepareReroute()
    - Move primary copy from docrep to remote through _cluster/reroute
        Flush triggers a force sync of translog which bumps the RetentionLease sequence number along with it
            .setDocs(true)  
        internalCluster().startClusterManagerOnlyNode();
        assertAcked(  
        logger.info("---> Starting 2 docrep data nodes");
    - Starts another remote node  
                        assertTrue(shardStats.getRetentionLeaseStats().retentionLeases().leases().isEmpty());
                DiscoveryNode discoveryNode = nodes.get(shardRouting.currentNodeId());
 *
        createIndex(REMOTE_PRI_DOCREP_REMOTE_REP, zeroReplicas);
                .cluster()
        assertReplicaAndPrimaryConsistency(REMOTE_PRI_DOCREP_REP, initialBatch, secondBatch);
        long initialPrimaryDocCount = 0;
    private void pollAndCheckRetentionLeases(String indexName) throws Exception {
        ensureGreen(REMOTE_PRI_DOCREP_REMOTE_REP);
        for (ShardRouting shardRouting : shardStatsMap.keySet()) {  
            .indices()
        ensureYellow(FAILOVER_REMOTE_TO_DOCREP);
        internalCluster().validateClusterFormed();
import org.opensearch.cluster.node.DiscoveryNode;
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
            .prepareNodesStats(remoteNodeName)  
    }
    /*
                assertEquals(finalNodes.get(nodeId).getName(), remoteNodeName2);
                .asMap();
        // Defensive check to ensure that doc count in replica shard catches up to the primary copy
                .get()
        ensureStableCluster(3);
        ensureGreen(FAILOVER_REMOTE_TO_REMOTE);  
        setAddRemote(true);  
    This ensures that the primary shard for the index has moved over to remote
                assertTrue(remoteSegmentStats.getTotalUploadTime() > 0);
        testRemotePrimaryDocRepReplica();
                .prepareUpdateSettings()
        internalCluster().validateClusterFormed();  
            .get()
                .admin()  
        logger.info("---> Removing replica copy");
        refreshAndWaitForReplication(FAILOVER_REMOTE_TO_REMOTE);  
            internalCluster().client()
            (shardRouting, shardStats) -> { assertEquals(firstBatch + secondBatch, shardStats.getStats().getDocs().getCount()); }  
                .add(new MoveAllocationCommand(FAILOVER_REMOTE_TO_REMOTE, 0, primaryNodeName, remoteNodeName1))
        logger.info("---> Expanding index to 2 replica copies");
                    assertEquals(  
        logger.info("---> Index some more docs to ensure that the failed over primary is ingesting new docs");  
                .admin()
        int firstBatch = (int) asyncIndexingService.getIndexedDocs();
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")  
            if (nodeId == null) {
    - Creates an index with 1 replica
        });
                .cluster()
     * @param shardStats ShardStats object from NodesStats API
        assertEquals(
     * @param shardStats ShardStats object from NodesStats API  
            .getNodes()
        );
        assertEquals(
        assertEquals(
                    // Primary copy should be on remote node and should have retention leases
        logger.info("---> Indexing {} more docs", secondBatch);
        assertAcked(
        );
    Scenario:
                    assertTrue(discoveryNode.isRemoteStoreNode());
import org.opensearch.test.OpenSearchIntegTestCase;
            .shard(0)
                .setIndices(FAILOVER_REMOTE_TO_DOCREP)
        int firstBatch = randomIntBetween(1, 100);  
        */  
        asyncIndexingService.startIndexing();
        assertEquals(  
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService(FAILOVER_REMOTE_TO_DOCREP);
        String remoteNodeName = internalCluster().startDataOnlyNode();
                .admin()  
            .currentNodeId();  
        }
        int secondBatch = randomIntBetween(1, 10);  
        String remoteNodeName = internalCluster().startDataOnlyNode();
            .getIndices()
    /*
                .setSettings(
        assertAcked(  
    @Override
        assertEquals(internalCluster().client().admin().cluster().prepareGetRepositories().get().repositories().size(), 0);  
        createIndex(FAILOVER_REMOTE_TO_DOCREP, excludeRemoteNode);  
import org.opensearch.index.IndexService;
        internalCluster().startClusterManagerOnlyNode();  
                initialPrimaryDocCount = shardStatsMap.get(shardRouting).getStats().getDocs().getCount();
                .admin()
    }  
        assertAcked(
                .prepareReroute()  
                .cluster()  
        });
        setAddRemote(true);  
        createIndex(FAILOVER_REMOTE_TO_REMOTE, Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
/*  
    - Ensure doc count is same after failover
            .admin()  
     *  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(remoteNodeName1));  
        initDocRepToRemoteMigration();  
                .indices()
     * asserts that local and global checkpoints are up-to-date with maxSeqNo of doc operations
        ensureGreen(REMOTE_PRI_DOCREP_REMOTE_REP);
    - Starts 1 remote backed data node
        logger.info("---> Expanding index to 2 replica copies");  
        String primaryShardHostingNode = primaryNodeName(FAILOVER_REMOTE_TO_DOCREP);  
    - Assert primary-replica consistency  
    - Expands index to 2 replicas, one each on new remote node and docrep node
    }  
            .get()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        );  
                .prepareReroute()
                    assertTrue(remoteSegmentStats.getUploadBytesSucceeded() > 0);
                .get()
        ensureStableCluster(4);
        assertEquals(0, replicationStats.getTotalBytesBehind());
                .get()
    private static void assertCheckpointsConsistency(ShardStats shardStats) {
            .prepareStats(FAILOVER_REMOTE_TO_DOCREP)
                .admin()
                RemoteSegmentStats remoteSegmentStats = shardStats.getStats().getSegments().getRemoteSegmentStats();
    - Ensure that remote store is seeded in the new remote node by asserting remote uploads from that node > 0
        createIndex(FAILOVER_REMOTE_TO_REMOTE, zeroReplicasAndOverridenSyncIntervals);
            2
        // Defensive check to ensure that doc count in replica shard catches up to the primary copy  
                .size(),
    - Expands index to 2 replicas. One replica copy lies in remote backed node and other in docrep backed node
        logger.info("---> Checking retention leases");
        logger.info("---> Starting 1 remote enabled data node");
                .repositories()
                    }
                assertTrue(remoteSegmentStats.getUploadBytesSucceeded() > 0);  
        logger.info("---> Starting doc ingestion in parallel thread");  
    Scenario:
        logger.info("---> Starting 1 more remote enabled data node");  
import org.opensearch.action.admin.indices.stats.CommonStats;
        extraSettings = Settings.builder().put(IndexingMemoryController.SHARD_INACTIVE_TIME_SETTING.getKey(), "3s").build();
    /**  
public class RemoteDualReplicationIT extends MigrationBaseTestCase {
                .prepareReroute()
            (shardRouting, shardStats) -> { assertEquals(firstBatch + secondBatch, shardStats.getStats().getDocs().getCount()); }
                .setDocs(true)  
        logger.info("---> Indexing another {} docs", secondBatch);
                } else {
                    boolean remoteNode = nodes.get(shardRouting.currentNodeId()).isRemoteStoreNode();
            .asMap();
import org.opensearch.test.transport.MockTransportService;  
     */
    - Starts 2 docrep backed data nodes  
                return finalNodes.get(nodeId).isRemoteStoreNode();  
        logger.info("---> Stop remote store enabled node hosting the primary");
            .asMap();
import org.opensearch.index.seqno.RetentionLeases;
        ensureGreen(REMOTE_PRI_DOCREP_REMOTE_REP);
                .cluster()
        setAddRemote(true);
     */  
        refreshAndWaitForReplication(REMOTE_PRI_DOCREP_REP);
import java.util.stream.Stream;  
        assertEquals(internalCluster().client().admin().cluster().prepareGetRepositories().get().repositories().size(), 0);
            2  
        Map<ShardRouting, ShardStats> shardStatsMap = internalCluster().client()  
    - Starts 2 docrep backed data node
                .prepareStats(indexName)
    - Move primary copy from docrep to remote through _cluster/reroute
                .prepareGetRepositories(REPOSITORY_NAME, REPOSITORY_2_NAME)
                .admin()  
    Performs the same experiment as testRemotePrimaryDocRepReplica.  
                .size(),
                    );
    Scenario:  
                .admin()  
                .admin()  
        assertAcked(  
    - Starts 1 docrep backed data node
        logger.info("---> Creating index with 1 replica");
    public void testFailoverRemotePrimaryToRemoteReplica() throws Exception {
        assertReplicaAndPrimaryConsistency(FAILOVER_REMOTE_TO_DOCREP, firstBatch, 0);  
import org.opensearch.index.seqno.RetentionLease;
            .get()
                assertTrue(nodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());
                .get()  
    - Ensures remote replica gets promoted to primary
        Settings twoReplicas = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build();
        logger.info("---> Starting 2 docrep data nodes");
        Settings twoReplicas = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build();
        initDocRepToRemoteMigration();
                        "Mismatched doc count. Is this on remote node ? " + remoteNode,
        logger.info("---> Stop remote store enabled node");
    - Starts 2 docrep backed node
            internalCluster().client()
                        // prevent replica copy from being allocated to the extra docrep node
    }
    }
            }  
            for (ShardRouting shardRouting : shardStatsMap.keySet()) {
                .add(new MoveAllocationCommand(FAILOVER_REMOTE_TO_DOCREP, 0, primaryShardHostingNode, remoteNodeName))
        logger.info("---> Stopping indexing thread");
        int initialBatch = randomIntBetween(1, 1000);
        addRemote = true;
        initDocRepToRemoteMigration();
        testRemotePrimaryDocRepAndRemoteReplica();
        logger.info("---> Index some more docs to ensure that the failed over primary is ingesting new docs");
                .setIndices(REMOTE_PRI_DOCREP_REMOTE_REP)
                }  
        ensureGreen(REMOTE_PRI_DOCREP_REP);  
    - Creates an index with 1 replica
        internalCluster().validateClusterFormed();  
        ensureGreen(FAILOVER_REMOTE_TO_DOCREP);
            .primaryShard()
        indexBulk(REMOTE_PRI_DOCREP_REP, initialBatch);
                assertTrue(finalNodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());
            .admin()
                .size(),
    Checks if retention leases are published on primary shard and it's docrep copies, but not on remote copies
        indexBulk(FAILOVER_REMOTE_TO_REMOTE, 100);
        ensureGreen(FAILOVER_REMOTE_TO_REMOTE);
        );
        String remoteNodeName = internalCluster().client()  
            .cluster()
                .setSettings(twoReplicas)
    - Indexes some more docs to ensure working of failed-over primary  
        Settings oneReplica = Settings.builder()  
                .prepareReroute()
        logger.info("---> Moving primary copy from {} to remote enabled node {}", primaryShardHostingNode, remoteNodeName);
                .prepareUpdateSettings()  
            .build();
        logger.info("---> Starting 1 remote enabled data node");  
        );
            internalCluster().client()
                        assertRetentionLeaseConsistency(shardStats, retentionLeases);  
     */  
        DiscoveryNodes finalNodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();  
        assertEquals(2, shardStatsMap.size());  
        indexBulk(FAILOVER_REMOTE_TO_DOCREP, secondBatch);  
        ensureGreen(FAILOVER_REMOTE_TO_DOCREP);
                .get()  
                .get()  
        refreshAndWaitForReplication(REMOTE_PRI_DOCREP_REMOTE_REP);
            internalCluster().client()  
                .admin()
            2  
                .indices()
        RLs on remote enabled copies are brought up to (GlobalCkp + 1) upon a flush request issued by IndexingMemoryController
        assertEquals(initialPrimaryDocCount, primaryDocCountAfterFailover);  
import org.opensearch.action.admin.indices.stats.ShardStats;
import org.opensearch.cluster.metadata.IndexMetadata;
 * this file be licensed under the Apache-2.0 license or a
        logger.info("---> Indexing {} docs", firstBatch);
     */
    /*
                    if (discoveryNode.isRemoteStoreNode()) {
                primaryDocCountAfterFailover = shardStatsMap.get(shardRouting).getStats().getDocs().getCount();  
        internalCluster().validateClusterFormed();
    - Start 1 remote backed node
                .repositories()
            .getReplicationStats();  
                assertFalse(nodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());  
    - Index some docs
        logger.info("---> Moving primary copy from {} to remote enabled node {}", primaryShardHostingNode, remoteNodeName);
        internalCluster().validateClusterFormed();
        String remoteNodeName = internalCluster().startDataOnlyNode();
    /*  
     */
    enabled node whereas the replica copy is still left behind on the docrep nodes  
                .cluster()
        logger.info("---> Indexing another {} docs", secondBatch);
                .get()  
        );
    /*
        logger.info("---> Indexing {} docs", initialBatch);  
                .size(),
        );
import org.opensearch.test.InternalSettingsPlugin;  
            internalCluster().client()  
    - Index some more docs  
                        shardStats.getDocs().getCount()  
            .getNodes()
                .get()  
        String primaryShardHostingNode = primaryNodeName(FAILOVER_REMOTE_TO_REMOTE);
            .cluster()
import org.opensearch.index.ReplicationStats;
    }  
        internalCluster().startDataOnlyNodes(2);  
        assertAcked(
    /**
    - Creates an index with 0 replica  
        assertReplicaAndPrimaryConsistency(FAILOVER_REMOTE_TO_REMOTE, firstBatch, 0);  
        String remoteNodeName2 = internalCluster().startDataOnlyNode();
                .get()  
            .stream()  
        assertEquals(maxSeqNo, globalCkp);
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "1s")
    public void testRemotePrimaryDocRepAndRemoteReplica() throws Exception {
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                        firstBatch + secondBatch,
        asyncIndexingService.startIndexing();
     */
                .get()  
     * @param retentionLeases RetentionLeases from NodesStats API
        ensureGreen(FAILOVER_REMOTE_TO_REMOTE);  
        );
                primaryDocCountAfterFailover = shardStatsMap.get(shardRouting).getStats().getDocs().getCount();
    - Starts 2 docrep backed data node
        assertEquals(1, shardStatsMap.size());
        );
            .admin()  
        shardStatsMap.forEach(
            internalCluster().client()
    - Starts 1 remote backed data node
    - Move primary copy from docrep to remote through _cluster/reroute  
                    assertTrue(remoteSegmentStats.getTotalUploadTime() > 0);
    - Starts another remote backed data node  
                        assertTrue(remoteSegmentStats.getTotalDownloadTime() > 0);
        logger.info("---> Starting 1 remote enabled data node");
            internalCluster().client()  
                initialPrimaryDocCount = shardStatsMap.get(shardRouting).getStats().getDocs().getCount();
        logger.info("---> Starting a new remote enabled node");  
                )
    - Ensures doc count is same after failover
                    assertCheckpointsConsistency(shardStats);  
        assertEquals(internalCluster().client().admin().cluster().prepareGetRepositories().get().repositories().size(), 0);
    Scenario:  
            }
            internalCluster().client()
import org.opensearch.common.settings.Settings;  
        );  
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "1s")
            .getSegments()
                .admin()
    - Index some docs
    - Expands index to 2 replicas. One replica copy lies in remote backed node and other in docrep backed node
        /* Adding the following mock plugins:
                .get()
        }
        ensureGreen(FAILOVER_REMOTE_TO_DOCREP);  
            internalCluster().client()
                .add(new MoveAllocationCommand(REMOTE_PRI_DOCREP_REMOTE_REP, 0, primaryShardHostingNode, remoteNodeName))
        long maxSeqNo = shardStats.getSeqNoStats().getMaxSeqNo();  
                .indices()
        );
        assertTrue(clusterState.getNodes().get(primaryShardHostingNodeId).isRemoteStoreNode());
                .cluster()
        String remoteNodeName1 = internalCluster().startDataOnlyNode();
        shardStatsMap = internalCluster().client().admin().indices().prepareStats(FAILOVER_REMOTE_TO_DOCREP).setDocs(true).get().asMap();  
        shardStatsMap.forEach((shardRouting, shardStats) -> {
                    assertEquals(firstBatch + secondBatch, shardStats.getDocs().getCount());
    - Starts 1 remote backed data node
        DiscoveryNodes discoveryNodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();  
        DiscoveryNodes nodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();  
        refreshAndWaitForReplication(FAILOVER_REMOTE_TO_REMOTE);
        Settings zeroReplicas = Settings.builder()
        long localCkp = shardStats.getSeqNoStats().getLocalCheckpoint();
        long globalCkp = shardStats.getSeqNoStats().getGlobalCheckpoint();
        assertEquals(internalCluster().client().admin().cluster().prepareGetRepositories().get().repositories().size(), 0);
import org.opensearch.plugins.Plugin;
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        assertEquals(0, replicationStats.getMaxReplicationLag());  
            .getName();
        String primaryShardHostingNodeId = clusterState.getRoutingTable()
                .prepareGetRepositories(REPOSITORY_NAME, REPOSITORY_2_NAME)
        ensureGreen(FAILOVER_REMOTE_TO_DOCREP);
    - Creates an index with 1 replica
        when the shard becomes inactive after SHARD_INACTIVE_TIME_SETTING interval.  
    - Stops remote enabled node  
                    } else {  
                CommonStats shardStats = shardStatsMap.get(shardRouting).getStats();
    private void assertReplicaAndPrimaryConsistency(String indexName, int firstBatch, int secondBatch) throws Exception {  
import org.opensearch.test.InternalTestCluster;
        logger.info("---> Stopping indexing thread");
        internalCluster().startClusterManagerOnlyNode();
    /*
            for (ShardStats shardStats : internalCluster().client().admin().indices().prepareStats(indexName).get().getShards()) {
import org.opensearch.indices.IndexingMemoryController;  
        assertEquals(0, replicationStats.getMaxBytesBehind());
            internalCluster().client()
            .build();  
        logger.info("---> Starting 1 remote enabled data node");  
    }  
        asyncIndexingService.stopIndexing();
            internalCluster().client()  
                .get()
                ShardRouting shardRouting = shardStats.getShardRouting();  
 */  
            super.nodePlugins().stream(),  
    public void testRemotePrimaryDocRepReplica() throws Exception {  
        shardStatsMap.forEach(
                        assertTrue(remoteSegmentStats.getDownloadBytesStarted() > 0);
import org.opensearch.cluster.routing.ShardRouting;
        internalCluster().startDataOnlyNodes(2);  
                .setIndices(FAILOVER_REMOTE_TO_REMOTE)
        DiscoveryNodes nodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();  
        logger.info("---> Starting doc ingestion in parallel thread");  
        internalCluster().validateClusterFormed();
            .build();
        addRemote = true;  
        shardStatsMap = internalCluster().client().admin().indices().prepareStats(FAILOVER_REMOTE_TO_REMOTE).setDocs(true).get().asMap();
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "1s")  
        nodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();
    private final String FAILOVER_REMOTE_TO_DOCREP = "failover-remote-to-docrep";
        waitUntil(() -> {
     */
    - Moves primary copy from docrep to remote through _cluster/reroute  
            .primaryShard()
            }
    - Index some more docs to ensure working of failed-over primary  
        initDocRepToRemoteMigration();
        ensureYellowAndNoInitializingShards(FAILOVER_REMOTE_TO_REMOTE);
                }
                        assertCheckpointsConsistency(shardStats);
                        assertEquals(0, remoteSegmentStats.getUploadBytesSucceeded());
        waitForRelocation();
    }  
                        .build()
        logger.info("---> Starting 2 docrep data nodes");
        assertEquals(initialPrimaryDocCount, primaryDocCountAfterFailover);
    /*  
        long primaryDocCountAfterFailover = 0;  
        refreshAndWaitForReplication(FAILOVER_REMOTE_TO_DOCREP);
        Map<ShardRouting, ShardStats> shardStatsMap = internalCluster().client()
            String nodeId = clusterState.getRoutingTable().index(FAILOVER_REMOTE_TO_REMOTE).shard(0).primaryShard().currentNodeId();
        This is because we block translog sync on remote enabled shard copies during the GlobalCkpSync background task.  
        String primaryShardHostingNode = primaryNodeName(FAILOVER_REMOTE_TO_DOCREP);
