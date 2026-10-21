        internalCluster().validateClusterFormed();
    - Starts 1 remote backed data node
                .size(),
            .getNodes()
                .indices()
        logger.info("---> Starting 1 more remote enabled data node");
            .get()
                .admin()
                .admin()
    */
        );
            }
        );
        logger.info("---> Moving primary copy from {} to remote enabled node {}", primaryShardHostingNode, remoteNodeName);
                .cluster()
        String primaryShardHostingNode = primaryNodeName(REMOTE_PRI_DOCREP_REP);
import java.util.Map;
        logger.info("---> Starting 2 docrep data nodes");
    - Index some docs
    /**
        long primaryDocCountAfterFailover = 0;
                .prepareReroute()
        DiscoveryNodes nodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();
            (shardRouting, shardStats) -> { assertEquals(firstBatch + secondBatch, shardStats.getStats().getDocs().getCount()); }
import org.opensearch.test.InternalSettingsPlugin;
            .asMap();
        refreshAndWaitForReplication(REMOTE_PRI_DOCREP_REP);
            Stream.of(InternalSettingsPlugin.class, MockFsRepositoryPlugin.class, MockTransportService.TestPlugin.class)
import org.opensearch.test.transport.MockTransportService;
        ensureGreen(FAILOVER_REMOTE_TO_REMOTE);
        indexBulk(REMOTE_PRI_DOCREP_REMOTE_REP, secondBatch);
                RetentionLeases retentionLeases = shardStats.getRetentionLeaseStats().retentionLeases();
                primaryDocCountAfterFailover = shardStatsMap.get(shardRouting).getStats().getDocs().getCount();
    Scenario:
        String remoteNodeName = internalCluster().client()
    - Index some docs
        logger.info("---> Stopping indexing thread");
                    }
                primaryDocCountAfterFailover = shardStatsMap.get(shardRouting).getStats().getDocs().getCount();
                .add(new MoveAllocationCommand(REMOTE_PRI_DOCREP_REMOTE_REP, 0, primaryShardHostingNode, remoteNodeName))
        testFailoverRemotePrimaryToDocrepReplica();
        addRemote = true;
        assertReplicaAndPrimaryConsistency(REMOTE_PRI_DOCREP_REMOTE_REP, firstBatch, secondBatch);
        testRemotePrimaryDocRepReplica();
    /*
    - Starts 1 remote backed data node
        String firstRemoteNode = internalCluster().startDataOnlyNode();
                assertTrue(nodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());
            if (nodeId == null) {
        String primaryShardHostingNodeId = clusterState.getRoutingTable()
    - Starts another remote backed data node
import org.opensearch.cluster.ClusterState;
            internalCluster().client()
        long maxSeqNo = shardStats.getSeqNoStats().getMaxSeqNo();
     *
                assertTrue(finalNodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());
    public void testFailoverRemotePrimaryToDocrepReplicaReseedToRemotePrimary() throws Exception {
        for (ShardRouting shardRouting : shardStatsMap.keySet()) {
        logger.info("---> Starting 2 docrep data nodes");
    At this stage, segrep lag computation shouldn't consider the docrep shard copy while calculating bytes lag
            .primaryShard()
            .indices()
        Settings oneReplica = Settings.builder()
                .admin()
        /* Reducing indices.memory.shard_inactive_time to force a flush and trigger translog sync,
        internalCluster().validateClusterFormed();
        for (ShardRouting shardRouting : shardStatsMap.keySet()) {
        DiscoveryNodes discoveryNodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();
    }
                .setIndices(REMOTE_PRI_DOCREP_REMOTE_REP)
        String primaryShardHostingNode = primaryNodeName(REMOTE_PRI_DOCREP_REMOTE_REP);
                } else {
import org.opensearch.action.admin.indices.stats.ShardStats;
import org.opensearch.index.seqno.RetentionLeases;
        indexBulk(FAILOVER_REMOTE_TO_REMOTE, secondBatch);
                    if (discoveryNode.isRemoteStoreNode()) {
                .prepareGetRepositories(REPOSITORY_NAME, REPOSITORY_2_NAME)
        internalCluster().validateClusterFormed();
                .prepareUpdateSettings()
        setAddRemote(true);
                .cluster()
                .admin()
        String secondRemoteNode = internalCluster().startDataOnlyNode();
        }
        assertEquals(
            }
                .get()
        logger.info("---> Indexing {} docs", firstBatch);
/*
        assertAcked(
                if (shardRouting.unassigned() == false && shardRouting.primary() == false) {
                ShardRouting shardRouting = shardStats.getShardRouting();
        String primaryShardHostingNodeId = clusterState.getRoutingTable()
    /*
                        assertCheckpointsConsistency(shardStats);
            .asMap();
            .shard(0)
        String remoteNodeName2 = internalCluster().startDataOnlyNode();
        logger.info("---> Index some more docs to ensure that the failed over primary is ingesting new docs");
import org.opensearch.test.InternalTestCluster;
                .cluster()
        logger.info("---> Starting doc ingestion in parallel thread");
            for (ShardRouting shardRouting : shardStatsMap.keySet()) {
        shardStatsMap.forEach(
                .prepareReroute()
            .getNodes()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            internalCluster().client()
 * SPDX-License-Identifier: Apache-2.0
        return Stream.concat(
                .setDocs(true)
                .get()
        testRemotePrimaryDocRepAndRemoteReplica();
        logger.info("---> Stop remote store enabled node hosting the primary");
    /*
        logger.info("---> Starting a new remote enabled node");
                .get()
 */
                .get()
        logger.info("---> Indexing another {} docs", secondBatch);
        ensureGreen(FAILOVER_REMOTE_TO_DOCREP);
        );
                .size(),
                .get()
                .size(),
        asyncIndexingService.startIndexing();
    private final String REMOTE_PRI_DOCREP_REMOTE_REP = "remote-primary-docrep-remote-replica";
        ensureGreen(FAILOVER_REMOTE_TO_REMOTE);
        internalCluster().validateClusterFormed();
            }
    public void testRemotePrimaryDocRepAndRemoteReplica() throws Exception {
     * @param shardStats ShardStats object from NodesStats API
    }
    - Creates an index with 0 replica
                .prepareGetRepositories(REPOSITORY_NAME, REPOSITORY_2_NAME)
                initialPrimaryDocCount = shardStatsMap.get(shardRouting).getStats().getDocs().getCount();
    - Expands index to 2 replicas. One replica copy lies in remote backed node and other in docrep backed node
                return false;
    }
            .get()
                    Settings.builder()
                .admin()
        String remoteNodeName = internalCluster().startDataOnlyNode();
        internalCluster().validateClusterFormed();
                assertFalse(nodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());
        assertEquals(
     */
                .repositories()
            String nodeId = clusterState.getRoutingTable().index(FAILOVER_REMOTE_TO_REMOTE).shard(0).primaryShard().currentNodeId();
        logger.info("---> Moving primary copy from {} to remote enabled node {}", primaryShardHostingNode, remoteNodeName);
                if (shardRouting.primary()) {
        Settings zeroReplicas = Settings.builder()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(remoteNodeName1));
            .findFirst()
                .admin()
        long initialPrimaryDocCount = 0;
            if (shardRouting.primary()) {
        String remoteNodeName1 = internalCluster().startDataOnlyNode();
        DiscoveryNodes nodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();
                        assertRetentionLeaseConsistency(shardStats, retentionLeases);
        }
                .add(new MoveAllocationCommand(REMOTE_PRI_DOCREP_REP, 0, primaryShardHostingNode, remoteNodeName))
            if (discoveryNodes.get(shardRouting.currentNodeId()).isRemoteStoreNode()) {
     * asserts that local and global checkpoints are up-to-date with maxSeqNo of doc operations
        long primaryDocCountAfterFailover = 0;
        Settings zeroReplicasAndOverridenSyncIntervals = Settings.builder()
        internalCluster().startDataOnlyNode();
    - Index some more docs to ensure working of failed-over primary
                .prepareReroute()
        logger.info("---> Creating index with 1 replica");
        waitForRelocation();
                        // prevent replica copy from being allocated to the extra docrep node
            }
        shardStatsMap = internalCluster().client().admin().indices().prepareStats(FAILOVER_REMOTE_TO_DOCREP).setDocs(true).get().asMap();
    private void assertReplicaAndPrimaryConsistency(String indexName, int firstBatch, int secondBatch) throws Exception {
        shardStatsMap = internalCluster().client().admin().indices().prepareStats(FAILOVER_REMOTE_TO_REMOTE).setDocs(true).get().asMap();
        assertAcked(
    /*
     */
        assertEquals(primaryNodeName(FAILOVER_REMOTE_TO_REMOTE), remoteNodeName1);
        internalCluster().validateClusterFormed();
                .prepareUpdateSettings()
    - Starts 2 docrep backed data node
                        assertTrue(remoteSegmentStats.getTotalDownloadTime() > 0);
            2
        ensureGreen(FAILOVER_REMOTE_TO_REMOTE);
                    // Primary copy should be on remote node and should have retention leases
        int firstBatch = randomIntBetween(1, 100);
        assertEquals(
                .get()
        assertAcked(
            DiscoveryNodes nodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();
                .repositories()
                .admin()
    }
     * @param shardStats ShardStats object from NodesStats API
    - Moves primary copy from docrep to remote through _cluster/reroute
                .setIndices(FAILOVER_REMOTE_TO_DOCREP)
import org.opensearch.common.settings.Settings;
            internalCluster().client()
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
    enabled node whereas the replica copy is still left behind on the docrep nodes
        );
        int secondBatch = randomIntBetween(1, 10);
                .prepareReroute()
                .get()
                if (shardRouting.primary()) {
        nodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();
            .prepareStats(FAILOVER_REMOTE_TO_DOCREP)
            internalCluster().client()
        internalCluster().startClusterManagerOnlyNode();
        int secondBatch = randomIntBetween(1, 10);
    - Starts another remote node
                        firstBatch + secondBatch,
            .get()
        createIndex(FAILOVER_REMOTE_TO_REMOTE, zeroReplicasAndOverridenSyncIntervals);
        asyncIndexingService.stopIndexing();
    - Stops remote enabled node hosting the primary
        pollAndCheckRetentionLeases(REMOTE_PRI_DOCREP_REMOTE_REP);
            .getName();
     * For a docrep enabled shard copy or a primary shard copy,
    This ensures that the primary shard for the index has moved over to remote
        );
            .build();
            }
    Checks if retention leases are published on primary shard and it's docrep copies, but not on remote copies
                .indices()
        assertReplicaAndPrimaryConsistency(REMOTE_PRI_DOCREP_REP, initialBatch, secondBatch);
    public void testRetentionLeasePresentOnDocrepReplicaButNotRemote() throws Exception {
        internalCluster().startClusterManagerOnlyNode();
        indexBulk(REMOTE_PRI_DOCREP_REMOTE_REP, firstBatch);
        shardStatsMap = internalCluster().client().admin().indices().prepareStats(FAILOVER_REMOTE_TO_REMOTE).setDocs(true).get().asMap();
                .get()
        int firstBatch = (int) asyncIndexingService.getIndexedDocs();
        indexBulk(FAILOVER_REMOTE_TO_REMOTE, 100);
package org.opensearch.remotemigration;
        initDocRepToRemoteMigration();
        indexBulk(FAILOVER_REMOTE_TO_DOCREP, secondBatch);
    Scenario:
    - Move primary copy from docrep to remote through _cluster/reroute
        when the shard becomes inactive after SHARD_INACTIVE_TIME_SETTING interval.
            super.nodePlugins().stream(),
        indexBulk(REMOTE_PRI_DOCREP_REP, secondBatch);
        Flush triggers a force sync of translog which bumps the RetentionLease sequence number along with it
        logger.info("---> Moving primary copy from {} to remote enabled node {}", primaryShardHostingNode, remoteNodeName);
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
                .admin()
                .admin()
    - Assert primary-replica consistency
    }
            }
    Scenario:
        logger.info("---> Expanding index to 2 replica copies");
            internalCluster().client()
            .primaryShard()
        assertAcked(
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService(FAILOVER_REMOTE_TO_DOCREP);
    /*
                .setIndices(FAILOVER_REMOTE_TO_REMOTE)
        initDocRepToRemoteMigration();
    }
        assertReplicaAndPrimaryConsistency(FAILOVER_REMOTE_TO_REMOTE, 100, 0);
        );
        assertEquals(0, replicationStats.getMaxReplicationLag());
    - Start 1 remote backed node
        assertAcked(
        long globalCkp = shardStats.getSeqNoStats().getGlobalCheckpoint();
                .cluster()
                .get()
     */
    - Starts 1 more remote backed data node
        Settings twoReplicas = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build();
            .get(0)
        logger.info("---> Starting first remote node");
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
        String remoteNodeName = internalCluster().startDataOnlyNode();
        createIndex(REMOTE_PRI_DOCREP_REMOTE_REP, zeroReplicas);
            .getSegments()
                .add(new MoveAllocationCommand(FAILOVER_REMOTE_TO_REMOTE, 0, primaryShardHostingNode, firstRemoteNode))
                    if (remoteNode) {
        ensureStableCluster(4);
    - Stops remote enabled node
                .prepareReroute()
        assertEquals(internalCluster().client().admin().cluster().prepareGetRepositories().get().repositories().size(), 0);
        refreshAndWaitForReplication(FAILOVER_REMOTE_TO_DOCREP);
            2
            .admin()
        internalCluster().validateClusterFormed();
    - Ensure doc count is same after failover
                .cluster()
            internalCluster().client()
                .indices()
        );
                .setSettings(twoReplicas)
        indexBulk(REMOTE_PRI_DOCREP_REP, initialBatch);
                        .build()
                .add(new MoveAllocationCommand(FAILOVER_REMOTE_TO_DOCREP, 0, primaryShardHostingNode, remoteNodeName))
                assertEquals(finalNodes.get(nodeId).getName(), remoteNodeName2);
        long localCkp = shardStats.getSeqNoStats().getLocalCheckpoint();
            ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        );
        initDocRepToRemoteMigration();
        ClusterState clusterState = internalCluster().client().admin().cluster().prepareState().get().getState();
        This is because we block translog sync on remote enabled shard copies during the GlobalCkpSync background task.
            .setDocs(true)
        internalCluster().startDataOnlyNodes(2);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(remoteNodeName));
            internalCluster().client()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            if (shardRouting.primary()) {
            .get()
        logger.info("---> Stopping indexing thread");
        });
        extraSettings = Settings.builder().put(IndexingMemoryController.SHARD_INACTIVE_TIME_SETTING.getKey(), "3s").build();
                CommonStats shardStats = shardStatsMap.get(shardRouting).getStats();
        assertEquals(initialPrimaryDocCount, primaryDocCountAfterFailover);
        logger.info("---> Starting 1 remote enabled data node");
        ensureStableCluster(3);
        String primaryShardHostingNode = primaryNodeName(FAILOVER_REMOTE_TO_REMOTE);
        logger.info("---> Stop remote store enabled node");
            internalCluster().client()
            }
        String remoteNodeName = internalCluster().startDataOnlyNode();
         */
    - Starts 2 docrep backed data node
 * this file be licensed under the Apache-2.0 license or a
                .get()
        Settings excludeRemoteNode = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build();
                .admin()
        Settings twoReplicas = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build();
        createIndex(FAILOVER_REMOTE_TO_DOCREP, excludeRemoteNode);
        assertTrue(clusterState.getNodes().get(primaryShardHostingNodeId).isRemoteStoreNode());
            .indices()
                .get()
    private void pollAndCheckRetentionLeases(String indexName) throws Exception {
        logger.info("---> Starting 1 remote enabled data node");
            .build();
    public void testFailoverRemotePrimaryToDocrepReplica() throws Exception {
        logger.info("---> Starting 1 remote enabled data node");
    - Move primary copy from docrep to remote through _cluster/reroute
    private static void assertRetentionLeaseConsistency(ShardStats shardStats, RetentionLeases retentionLeases) {
import org.opensearch.cluster.routing.ShardRouting;
public class RemoteDualReplicationIT extends MigrationBaseTestCase {
            if (shardRouting.primary()) {
        internalCluster().startClusterManagerOnlyNode();
            .getIndices()
        logger.info("---> Indexing {} more docs", secondBatch);
        ensureGreen(FAILOVER_REMOTE_TO_REMOTE);
    - Stops remote enabled node
        long maxSeqNo = shardStats.getSeqNoStats().getMaxSeqNo();
    /*
     *
                .cluster()
                .admin()
            } else {
     */
        internalCluster().startDataOnlyNodes(2);
        assertEquals(
                .cluster()
                .setSettings(twoReplicas)
        assertReplicaAndPrimaryConsistency(FAILOVER_REMOTE_TO_REMOTE, firstBatch, 0);
            .cluster()
        asyncIndexingService.startIndexing();
    public void testZeroSegrepLagForShardsWithMixedReplicationGroup() throws Exception {
     */
import org.opensearch.index.remote.RemoteSegmentStats;
        assertEquals(maxSeqNo, localCkp);
    - Index some docs
        ensureGreen(REMOTE_PRI_DOCREP_REMOTE_REP);
 * compatible open source license.
                        .put("index.routing.allocation.exclude._name", primaryNodeName)
        DiscoveryNodes finalNodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();
            .admin()
     * asserts that the stored Retention Leases equals to 1 + maxSeqNo ingested on the node
                    boolean remoteNode = nodes.get(shardRouting.currentNodeId()).isRemoteStoreNode();
                )
                .indices()
    - Starts 1 docrep backed data node
                    assertTrue(remoteSegmentStats.getTotalUploadTime() > 0);
    - Move primary copy from docrep to remote through _cluster/reroute
        }
            2
        logger.info("---> Moving primary copy from docrep node {} to remote enabled node {}", primaryNodeName, remoteNodeName1);
        }
        }
        int secondBatch = randomIntBetween(1, 10);
    - Ensure doc count is same after failover
        shardStatsMap.forEach(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.plugins.Plugin;
    private final String REMOTE_PRI_DOCREP_REP = "remote-primary-docrep-replica";
                    // Checkpoints and Retention Leases are not synced to remote replicas
        ).collect(Collectors.toList());
                }
                .get()
        assertEquals(maxSeqNo, globalCkp);
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.index.IndexService;
    - Starts 2 docrep backed data nodes
        logger.info("---> Indexing {} more docs", secondBatch);
                .repositories()
                .add(new MoveAllocationCommand(FAILOVER_REMOTE_TO_REMOTE, 0, primaryNodeName, remoteNodeName1))
     */
        Under steady state, RetentionLeases would be on (GlobalCkp + 1) on a
        setAddRemote(true);
import java.util.List;
        assertEquals(0, replicationStats.getTotalBytesBehind());
                .setSettings(twoReplicas)
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "1s")
                .size(),
        String primaryShardHostingNode = primaryNodeName(FAILOVER_REMOTE_TO_DOCREP);
        internalCluster().startDataOnlyNodes(2);
        );
    - Index some more docs
                    } else {
     */
        ensureYellowAndNoInitializingShards(FAILOVER_REMOTE_TO_REMOTE);
    }
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService(FAILOVER_REMOTE_TO_REMOTE);
                .cluster()
        logger.info("---> Starting another remote enabled node");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            2
    - Starts 2 docrep backed node
            .prepareStats(FAILOVER_REMOTE_TO_REMOTE)
                .indices()
        ensureGreen(FAILOVER_REMOTE_TO_DOCREP);
        });
                    RemoteSegmentStats remoteSegmentStats = shardStats.getSegments().getRemoteSegmentStats();
        DiscoveryNodes nodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();
    - Creates an index with 1 replica
            .build();
    - Creates an index with 1 replica
    }
        logger.info("---> Expanding index to 2 replica copies");
            .prepareNodesStats(remoteNodeName)
    - Creates an index with 1 replica
import java.util.stream.Collectors;
            .prepareStats(FAILOVER_REMOTE_TO_DOCREP)
                DiscoveryNode discoveryNode = nodes.get(shardRouting.currentNodeId());
                .prepareStats(indexName)
        ensureGreen(REMOTE_PRI_DOCREP_REP);
        assertEquals(2, shardStatsMap.size());
                    RemoteSegmentStats remoteSegmentStats = shardStats.getSegments().getRemoteSegmentStats();
                assertTrue(remoteSegmentStats.getUploadBytesSucceeded() > 0);
        setAddRemote(true);
import org.opensearch.index.seqno.RetentionLease;
            .prepareNodesStats()
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "1s")
                .admin()
                .prepareGetRepositories(REPOSITORY_NAME, REPOSITORY_2_NAME)
            .shard(0)
        );
        Map<ShardRouting, ShardStats> shardStatsMap = internalCluster().client()
        );
        addRemote = true;
        logger.info("---> Creating index with 0 replica");
        // Defensive check to ensure that doc count in replica shard catches up to the primary copy
    public void testFailoverRemotePrimaryToRemoteReplica() throws Exception {
                    assertEquals(
        int firstBatch = (int) asyncIndexingService.getIndexedDocs();
        asyncIndexingService.stopIndexing();
        logger.info("---> Indexing {} docs", initialBatch);
        initDocRepToRemoteMigration();
        logger.info("---> Starting 2 docrep data nodes");
        assertAcked(
        instead of relying on Global CKP Sync action which doesn't run on remote enabled copies
            internalCluster().client()
    - Creates an index with 1 replica
                        // Replica copy on docrep node should have retention leases
        String primaryNodeName = primaryNodeName(FAILOVER_REMOTE_TO_REMOTE);
                .prepareUpdateSettings(FAILOVER_REMOTE_TO_DOCREP)
    public void testRemotePrimaryDocRepReplica() throws Exception {
        assertEquals(initialPrimaryDocCount, primaryDocCountAfterFailover);
    private final String FAILOVER_REMOTE_TO_REMOTE = "failover-remote-to-remote";
                .admin()
                    );
        );
        logger.info("---> Removing replica copy");
            .indices()
        refreshAndWaitForReplication(FAILOVER_REMOTE_TO_REMOTE);
        ClusterState clusterState = internalCluster().client().admin().cluster().prepareState().get().getState();
        int initialBatch = randomIntBetween(1, 1000);
        logger.info("---> Moving primary copy from {} to remote enabled node {}", primaryShardHostingNode, remoteNodeName);
                return finalNodes.get(nodeId).isRemoteStoreNode();
        );
        logger.info("---> Starting 1 remote enabled data node");
            (shardRouting, shardStats) -> { assertEquals(firstBatch + secondBatch, shardStats.getStats().getDocs().getCount()); }
        );
import org.opensearch.cluster.node.DiscoveryNodes;
    Scenario:
        ensureGreen(FAILOVER_REMOTE_TO_DOCREP);
                .size(),
            .asMap();
            .setDocs(true)
                .prepareReroute()
            internalCluster().client()
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "1s")
        logger.info("---> Checking retention leases");
                .admin()
                .get()
                .indices()
    }
            .cluster()
    - Index some more docs to ensure working of failed-over primary
            internalCluster().client()
        assertEquals(1, shardStatsMap.size());
    @Override
            .currentNodeId();
    - Assert retention lease consistency
 *
                    } else {
        Map<ShardRouting, ShardStats> shardStatsMap = internalCluster().client()
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertEquals(0, replicationStats.getMaxBytesBehind());
        refreshAndWaitForReplication(FAILOVER_REMOTE_TO_DOCREP);
            internalCluster().client()
        logger.info("---> Indexing another {} docs", secondBatch);
        assertAcked(
    Scenario:
                }
                .admin()
                    assertEquals(firstBatch + secondBatch, shardStats.getDocs().getCount());
                .prepareUpdateSettings()
                .prepareUpdateSettings()
        Map<ShardRouting, ShardStats> shardStatsMap = internalCluster().client()
        );
        ensureGreen(FAILOVER_REMOTE_TO_REMOTE);
        ensureGreen(REMOTE_PRI_DOCREP_REMOTE_REP);
    - Ensure that remote store is seeded in the new remote node by asserting remote uploads from that node > 0
            .get()
    - Move primary copy from docrep to remote through _cluster/reroute
            .getReplicationStats();
    Scenario:
        assertBusy(() -> {
        createIndex(FAILOVER_REMOTE_TO_REMOTE, Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build());
                assertTrue(remoteSegmentStats.getTotalUploadTime() > 0);
    - Assert primary-replica consistency
    - Indexes some more docs to ensure working of failed-over primary
                        assertEquals(0, remoteSegmentStats.getTotalUploadTime());
        RLs on remote enabled copies are brought up to (GlobalCkp + 1) upon a flush request issued by IndexingMemoryController
        assertBusy(() -> {
    private final String FAILOVER_REMOTE_TO_DOCREP = "failover-remote-to-docrep";
        Settings twoReplicas = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build();
        pollAndCheckRetentionLeases(FAILOVER_REMOTE_TO_REMOTE);
        logger.info("---> Starting 2 docrep data nodes");
        logger.info("---> Starting 2 docrep data nodes");
            .index(REMOTE_PRI_DOCREP_REMOTE_REP)
     */
        ensureGreen(FAILOVER_REMOTE_TO_DOCREP);
                .get()
        logger.info("---> Expanding index to 2 replica copies, on docrepNode and remoteNode2");
            .stream()
                        assertEquals(0, remoteSegmentStats.getUploadBytesSucceeded());
    - Ensures doc count is same after failover
        logger.info("---> Moving primary copy from {} to remote enabled node {}", primaryShardHostingNode, firstRemoteNode);
        assertReplicaAndPrimaryConsistency(FAILOVER_REMOTE_TO_DOCREP, firstBatch, 0);
}
import org.opensearch.action.admin.indices.stats.CommonStats;
                .cluster()
                }
        assertAcked(
                .repositories()
                    assertTrue(nodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());
    /*
        waitUntil(() -> {
        logger.info("---> Starting doc ingestion in parallel thread");
            for (ShardStats shardStats : internalCluster().client().admin().indices().prepareStats(indexName).get().getShards()) {
            2
        );
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
    - Move primary copy from docrep to remote through _cluster/reroute
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .get()
        long initialPrimaryDocCount = 0;
        - MockFsRepositoryPlugin and MockTransportService.TestPlugin: To ensure remote interactions are not no-op and retention leases are properly propagated
    }
        ensureGreen(REMOTE_PRI_DOCREP_REMOTE_REP);
    /*
        shardStatsMap = internalCluster().client().admin().indices().prepareStats(FAILOVER_REMOTE_TO_DOCREP).setDocs(true).get().asMap();
    - Creates index with 1 replica
        List<String> docrepNodeNames = internalCluster().startDataOnlyNodes(2);
                .asMap();
        ensureGreen(FAILOVER_REMOTE_TO_REMOTE);
                    assertTrue(remoteSegmentStats.getUploadBytesSucceeded() > 0);
     */
        internalCluster().validateClusterFormed();
            Map<ShardRouting, ShardStats> shardStatsMap = internalCluster().client()
        String remoteNodeName = internalCluster().startDataOnlyNode();
            .admin()
                .prepareGetRepositories(REPOSITORY_NAME, REPOSITORY_2_NAME)
     * For a docrep enabled shard copy or a primary shard copy,
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        assertEquals(2, shardStatsMap.size());
        String primaryShardHostingNode = primaryNodeName(FAILOVER_REMOTE_TO_DOCREP);
                        assertTrue(shardStats.getRetentionLeaseStats().retentionLeases().leases().isEmpty());
            .index(REMOTE_PRI_DOCREP_REP)
import org.opensearch.test.OpenSearchIntegTestCase;
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().validateClusterFormed();
        int secondBatch = randomIntBetween(1, 10);
                .get()
    Performs the same experiment as testRemotePrimaryDocRepReplica.
     * @param retentionLeases RetentionLeases from NodesStats API
        initDocRepToRemoteMigration();
        /* Adding the following mock plugins:
                RemoteSegmentStats remoteSegmentStats = shardStats.getStats().getSegments().getRemoteSegmentStats();
        assertAcked(
    public void testMissingRetentionLeaseCreatedOnFailedOverRemoteReplica() throws Exception {
        ensureGreen(REMOTE_PRI_DOCREP_REP);
        });
        logger.info("---> Creating index with 1 replica");
        assertEquals(internalCluster().client().admin().cluster().prepareGetRepositories().get().repositories().size(), 0);
            internalCluster().client()
                .admin()
            .filter(nodeStats -> nodeStats.getNode().isRemoteStoreNode())
            internalCluster().client()
                assertTrue(nodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());
import java.util.stream.Stream;
    - Move primary copy from docrep to remote through _cluster/reroute
        internalCluster().startDataOnlyNodes(2);
 * The OpenSearch Contributors require contributions made to
        logger.info("---> Index some more docs to ensure that the failed over primary is ingesting new docs");
            .currentNodeId();
                .repositories()
                    assertTrue(discoveryNode.isRemoteStoreNode());
                .cluster()
    - Ensures remote replica gets promoted to primary
    - Starts 1 remote backed data node
            .admin()
    - Expands index to 2 replicas. One replica copy lies in remote backed node and other in docrep backed node
                    }
    - Index some more docs
import org.opensearch.index.ReplicationStats;
import org.opensearch.indices.IndexingMemoryController;
            .admin()
        assertEquals(internalCluster().client().admin().cluster().prepareGetRepositories().get().repositories().size(), 0);
                .setSettings(
                .cluster()
        );
                .add(new MoveAllocationCommand(FAILOVER_REMOTE_TO_DOCREP, 0, primaryShardHostingNode, remoteNodeName))
        createIndex(REMOTE_PRI_DOCREP_REP, oneReplica);
            internalCluster().client()
        refreshAndWaitForReplication(FAILOVER_REMOTE_TO_REMOTE);
    - Starts 2 docrep backed data node
    - Starts another remote backed data node
        });
        for (ShardRouting shardRouting : shardStatsMap.keySet()) {
    - Starts 1 remote backed data node
                .setIndices(FAILOVER_REMOTE_TO_REMOTE)
    private static void assertCheckpointsConsistency(ShardStats shardStats) {
                .prepareGetRepositories(REPOSITORY_NAME, REPOSITORY_2_NAME)
import org.opensearch.cluster.metadata.IndexMetadata;
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "1s")
        assertAcked(
            .get()
                .admin()
                .get()
            if (shardRouting.primary()) {
                        "Mismatched doc count. Is this on remote node ? " + remoteNode,
            .getNode()
        assertEquals(
        for (RetentionLease rl : retentionLeases.leases()) {
        internalCluster().validateClusterFormed();
    }
        - InternalSettingsPlugin : To override default intervals of retention lease and global ckp sync
            assertEquals(maxSeqNo + 1, rl.retainingSequenceNumber());
    - Index some more docs
    - Starts 1 remote backed data node
        shardStatsMap.forEach((shardRouting, shardStats) -> {
            internalCluster().client()
                        assertTrue(remoteSegmentStats.getDownloadBytesStarted() > 0);
    }
        ReplicationStats replicationStats = internalCluster().client()
    - Expands index to 2 replicas, one each on new remote node and docrep node
        setAddRemote(true);
        logger.info("---> Creating index with 1 replica");
                    assertRetentionLeaseConsistency(shardStats, retentionLeases);
        docrep enabled shard copy and (GlobalCkp) for a remote enabled shard copy.
        for (ShardRouting shardRouting : shardStatsMap.keySet()) {
        assertAcked(
import java.util.Collection;
        assertEquals(internalCluster().client().admin().cluster().prepareGetRepositories().get().repositories().size(), 0);
            }
        );
import org.opensearch.cluster.node.DiscoveryNode;
        refreshAndWaitForReplication(REMOTE_PRI_DOCREP_REMOTE_REP);
                        shardStats.getDocs().getCount()
                initialPrimaryDocCount = shardStatsMap.get(shardRouting).getStats().getDocs().getCount();
        internalCluster().validateClusterFormed();
        ensureYellow(FAILOVER_REMOTE_TO_DOCREP);
        // Defensive check to ensure that doc count in replica shard catches up to the primary copy
                    assertCheckpointsConsistency(shardStats);
    /**
        */
        ensureGreen(FAILOVER_REMOTE_TO_DOCREP);
        assertTrue(clusterState.getNodes().get(primaryShardHostingNodeId).isRemoteStoreNode());
