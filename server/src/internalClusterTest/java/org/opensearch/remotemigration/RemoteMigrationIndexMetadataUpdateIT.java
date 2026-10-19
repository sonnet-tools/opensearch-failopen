        assertTrue(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(settings));
            .prepareState()
        ClusterState clusterState = internalCluster().client().admin().cluster().prepareState().get().getState();
        waitNoPendingTasksOnAll();
                docrepReplicaNodeName = nodes.get(shardRouting.currentNodeId()).getName();
        waitForRelocation();
        ensureGreen(indexName);
     * Performs a manual _cluster/reroute to move shards from docrep to remote enabled nodes.
        );
     * - index.remote_store.enabled == false
        createIndexAndAssertDocrepProperties(indexName, oneReplica);
        String replicaNodeName = replicaNodeName(indexName);
        String indexName = "migration-index-allocation-exclude";
            client().admin()
        logger.info("---> Assert index still has dcorep settings since replica copies are still on docrep nodes");
        logger.info("---> Starting 3 remote store enabled nodes");
     * have been applied to the index.
     * Asserts index metadata customs has the <code>remote_store</code> key
                    Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.HASHED_PREFIX)
     * Assert current index settings have:
        asyncIndexingService.stopIndexing();
        waitForRelocation();
                .actionGet()
     * Scenario:
     * have been relocated.
        IndexMetadata iMd = internalCluster().client().admin().cluster().prepareState().get().getState().metadata().index(index);
 */
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        internalCluster().startClusterManagerOnlyNode();
            .getVersion();
                .cluster()
        assertAcked(
     * exclude docrep nodes, assert that remote index path file exists
        logger.info("---> Stopping indexing");
        logger.info("---> Assert remote settings are applied");
        waitForRelocation();
        assertTrue(Arrays.stream(files).anyMatch(file -> file.toString().contains(indexUUID)));
     * and asserts remote index settings are applied as soon as the docrep replica copy is unassigned
                .prepareReroute()
                .add(new MoveAllocationCommand(indexName2, 0, primaryNodeName(indexName2), remoteNodeNames.get(0)))
                .prepareState()
                .prepareReroute()
import java.util.Arrays;
     * initiate migration and create 3 remote nodes (1 cluster manager + 2 data nodes) and moves over
        internalCluster().validateClusterFormed();
        internalCluster().validateClusterFormed();
    }
     * Creates an index with 1 primary, 2 replicas on 2 docrep nodes. Since the replica
            .get()
        waitForRelocation();
    public void testRemotePathMetadataAddedWithFirstPrimaryMovingToRemote() throws Exception {
        createIndexAndAssertDocrepProperties(indexName, oneReplica);
        assertEquals(1, files.length);
        );
    }
        assertRemoteProperties(indexName);
        initDocRepToRemoteMigration();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        AsyncIndexingService indexTwo = new AsyncIndexingService(indexName2);
        logger.info("---> Starting 2 remote store enabled nodes");
        Settings oneReplica = Settings.builder()
        assertRemoteProperties(indexName);
     * Creates an index with 1 primary, 2 replicas on 2 docrep nodes.
        waitNoPendingTasksOnAll();
        assertRemoteProperties(indexName);
        assertTrue(Arrays.stream(files).anyMatch(file -> file.toString().contains(indexUUID)));
                .actionGet()
        createIndexAndAssertDocrepProperties(indexName, oneReplica);
     * Assert current index settings have:
        // elect cluster manager with remote-cluster state enabled
        assertAcked(
        logger.info("---> Stopping docrep node holding the replica copy");
        String indexName = "migration-index";
        internalCluster().validateClusterFormed();
                .cluster()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        createIndexAssertHealthAndDocrepProperties(indexName, oneReplica, this::ensureYellowAndNoInitializingShards);
        String indexName = "migration-index-allocation-exclude";
import org.opensearch.core.util.FileSystemUtils;
import org.opensearch.common.settings.Settings;
        internalCluster().startClusterManagerOnlyNode();
    }
        addRemote = true;
     * - index.remote_store.enabled == true
        createIndexAndAssertDocrepProperties(indexName2, oneReplica);
                .metadata()
}
        internalCluster().startDataOnlyNodes(3, Settings.builder().put("node.attr._type", "docrep").build());
        String index,
            .getState()
            .execute(AddVotingConfigExclusionsAction.INSTANCE, new AddVotingConfigExclusionsRequest(docrepClusterManager))
     * only primary shard copy of the index
        String indexName = "migration-index-allocation-exclude";
        Settings oneReplica = Settings.builder()
                .isAcknowledged()
            .index(indexName)
        logger.info("---> Asserts index still has docrep index settings");
        assertEquals(1, files.length);
            .get();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        ensureGreen(indexName);
     * store settings has been applied as all shards have moved over
        logger.info(
        Settings oneReplica = Settings.builder()
        logger.info("---> Excluding docrep nodes from allocation");
        // validate remote index path file exists
        excludeNodeSet("type", "docrep");
            .getSetting(indexName, IndexMetadata.SETTING_INDEX_UUID);
    public void testIndexSettingsUpdatedOnlyForMigratingIndex() throws Exception {
        indexBulk(secondIndex, 100);
        logger.info("---> Creating index with 1 primary and 1 replica");
        logger.info("---> Assert remote settings are applied for index one but not for index two");
            .get()
        excludeNodeSet("type", null);
import org.opensearch.cluster.ClusterState;
        for (ShardRouting shardRouting : clusterState.routingTable().index(indexName).shard(0).getShards()) {
     * when shards start relocating to the remote nodes.
        waitForRelocation();
        indexTwo.stopIndexing();
        internalCluster().validateClusterFormed();
            .metadata()
    /**
        excludeNodeSet("type", "docrep");
     * Scenario:
    /**
     * Excludes docrep nodes from allocation to force migration of the 3rd replica copy and asserts remote
        logger.info("---> Creating the first index with 1 primary and 1 replica");
        logger.info("---> Moving only primary for the second index to remote enabled nodes");
        logger.info("---> Excluding docrep nodes from allocation");
        }
            .getState()
    /**
                .add(new MoveAllocationCommand(indexName, 0, primaryNode, remoteNodeNames.get(0)))
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "docrep").build());
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "remote").build());
        assertFalse(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(settings));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
            .get(0);
        List<String> remoteEnabledNodes = internalCluster().startDataOnlyNodes(
     * Moves over the first replica copy and asserts that the remote store based settings has not been applied
            }
        assertEquals(ReplicationType.DOCUMENT, IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(settings));
        internalCluster().validateClusterFormed();
        logger.info("---> Adding 3 remote enabled nodes");
     * Starts 2 more remote nodes and initiates shard relocation through allocation exclusion.
        logger.info("---> Indexing {} on both indices", docsToIndex);
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "docrep").build());
     * allocation and asserts that remote index settings are applied after all shards
        String indexName = "migration-index-replica-decrement";
    /**
                break;
        logger.info("---> Creating index with 1 primary and 2 replicas");
            internalCluster().client()
        logger.info("---> Excluding docrep nodes from allocation");
            .build();
        ensureState.apply(index);
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService(indexName);
        List<String> remoteNodeNames = internalCluster().startDataOnlyNodes(2);
        IndexMetadata iMd = internalCluster().client().admin().cluster().prepareState().get().getState().metadata().index(index);
        logger.info("---> Asserting remote index settings");
import org.opensearch.index.remote.RemoteIndexPath;
            client().admin()
     * Scenario:
        internalCluster().validateClusterFormed();
        logger.info("---> Assert custom remote path based metadata is applied");
     * - index.remote_store.translog.repository == null
    }
    private void assertDocrepProperties(String index) {
        assertRemoteProperties(secondIndex);
        createIndex(
     * - index.remote_store.translog.repository != null
     * - index.remote_store.segment.repository != null
        createIndexAssertHealthAndDocrepProperties(index, settings, this::ensureGreen);
        logger.info("---> Storing current index metadata version");
        String replicaNode = docrepNodeNames.stream()
        DiscoveryNodes nodes = clusterState.nodes();
        internalCluster().validateClusterFormed();
        );
            .cluster()
        List<String> docrepNodes = internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "docrep").build());
        logger.info("---> Excluding docrep nodes from allocation");
        internalCluster().startClusterManagerOnlyNode();
        logger.info("---> Starting indexing in parallel");
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        indexingService.stopIndexing();
    private void assertRemoteProperties(String index) {
                .admin()
        internalCluster().startClusterManagerOnlyNode();
                .execute()
            client().admin()
import org.opensearch.cluster.routing.ShardRouting;
    public void testIndexSettingsUpdateDuringReplicaCountDecrement() throws Exception {
        logger.info("---> Stop indexing and assert remote enabled index settings have been applied");
        assertEquals(ReplicationType.SEGMENT, IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(settings));
        indexOne.stopIndexing();
            initalMetadataVersion < internalCluster().client()
        logger.info("---> Starting 2 docrep nodes");
            3,
        );
        logger.info("---> Assert metadata version is not changed");
                .cluster()
        Settings oneReplica = Settings.builder()
                .cluster()
    /**
        initalMetadataVersion = internalCluster().client()
        excludeNodeSet("type", "docrep");
            .metadata()
                .prepareReroute()
                .actionGet()
     * For the second index, asserts that it already has remote enabled settings.
        List<String> remoteNodeNames = internalCluster().startDataOnlyNodes(2);
        indexingService.startIndexing();
        String primaryNode = primaryNodeName(indexName);
        logger.info("---> Moving over primary to remote store enabled nodes");
        );
        logger.info("---> Assert cluster has turned green since more nodes are added to the cluster");
        asyncIndexingService.stopIndexing();
import org.opensearch.cluster.node.DiscoveryNodes;
        String indexName2 = "migration-index-manual-reroute-2";
        logger.info(files[0].toString());
 * compatible open source license.
                .actionGet()
            .prepareState()
    }
                .get()
        for (String node : docrepNodes) {
        waitNoPendingTasksOnAll();
import java.util.stream.Collectors;
     * Asserts that remote based index settings are applied after all shards move over
                .execute()
        List<String> docrepNodeNames = internalCluster().startDataOnlyNodes(2);
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "remote").build());
        logger.info("---> Creating a new index on remote enabled nodes");
        assertCustomIndexMetadata(indexName);
        waitForRelocation();
                .getVersion()
        addRemote = true;
        internalCluster().validateClusterFormed();
import java.nio.file.Path;
                .cluster()
        logger.info("---> Adding 2 remote enabled nodes to the cluster");
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
                .execute()
            internalCluster().client().admin().cluster().prepareState().get().getState().metadata().index(secondIndex).getVersion()
        assertAcked(
     * Creates an index with 1 pri 1 rep setup with 3 docrep nodes (1 cluster manager + 2 data nodes),
            .build();
                .execute()
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "remote").build());
        waitNoPendingTasksOnAll();
        logger.info("---> Assert index still has docrep settings");
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        logger.info("---> Starts 2 remote enabled nodes");
        addRemote = true;
     */
            if (nodes.get(shardRouting.currentNodeId()).isRemoteStoreNode() == false) {
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
     * Scenario:
     */
    public void testIndexSettingsUpdateAfterIndexMovedToRemoteThroughAllocationExclude() throws Exception {
        waitForRelocation();
     */
        internalCluster().validateClusterFormed();
        indexOne.startIndexing();
     * After shard relocation completes, restarts the docrep node holding extra replica shard copy
        ensureGreen(secondIndex);
        String docrepClusterManager = internalCluster().startClusterManagerOnlyNode();
        );
        assertTrue(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(settings));
            client().admin()
        addRemote = false;
        waitNoPendingTasksOnAll();
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        waitForRelocation();
     * Scenario:
        logger.info(
import org.opensearch.index.remote.RemoteStoreEnums;
        logger.info("---> Starting indexing in parallel");
     * creates an index on docrep node with non-remote cluster-manager.
            .build();
        String indexUUID = internalCluster().client()
        logger.info("---> Creating 2 indices with 1 primary and 1 replica");
        internalCluster().startClusterManagerOnlyNode();
        waitNoPendingTasksOnAll();
        logger.info("---> Reducing replica count to 0 for the index");
                .cluster()
     * Scenario:
    /**
        List<String> docrepNodes = internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "docrep").build());
        logger.info("---> Starting 3 docrep nodes");
            Settings.builder().put("node.attr._type", "remote").build()
        AsyncIndexingService indexingService = new AsyncIndexingService(indexName);
    private void createIndexAssertHealthAndDocrepProperties(
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService(indexName);
        ensureYellowAndNoInitializingShards(indexName);
        assertTrue(
        logger.info("---> Assert cluster has turned green since more nodes are added to the cluster");
     * Scenario:
        assertFalse(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(settings));
     */
        );
     * Indexes some more docs and asserts that the index metadata version does not increment
            .filter(nodeName -> nodeName.equals(primaryNodeName(indexName1)) == false)
        String indexName = "index-1";
        files = FileSystemUtils.files(segmentRepoPath.resolve(RemoteIndexPath.DIR));
     */
        excludeNodeSet("type", "docrep");
     * - index.remote_store.segment.repository == null
        logger.info("---> Assert index has remote store settings");
        assertNotNull(iMd.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY));
                .actionGet()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        logger.info("---> Starting indexing in parallel");
        createIndexAssertHealthAndDocrepProperties(indexName, oneReplica, this::ensureYellowAndNoInitializingShards);
     */
     * Asserts index metadata customs has the <code>remote_store</code> key
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(docrepClusterManager));
    public void testRemoteIndexPathFileExistsAfterMigration() throws Exception {
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    }
        assertDocrepProperties(indexName);
        addRemote = true;
        );
        internalCluster().validateClusterFormed();
                .admin()
        logger.info("---> Assert index still has dcorep settings since replica copies are still on docrep nodes");
        addRemote = true;
        assertTrue(
        assertNotNull(iMd.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY));
        );
        waitNoPendingTasksOnAll();
     * index settings are applied even when the index is in YELLOW state
        indexBulk(indexName, docsToIndex);
            .build();
     * Adds 3 more remote nodes to the cluster and moves over the primary copy from docrep
        waitNoPendingTasksOnAll();
        internalCluster().restartNode(docrepReplicaNodeName);
    }
        Settings settings = iMd.getSettings();
        refresh(index);
                .index(indexName)
        createIndexAndAssertDocrepProperties(indexName1, oneReplica);
        internalCluster().client()
        Settings oneReplica = Settings.builder()
    private void assertCustomIndexMetadata(String index) {
        waitForRelocation();
        internalCluster().validateClusterFormed();
        logger.info("---> Starts 2 remote enabled nodes");
        for (String node : docrepNodeNames) {
        waitNoPendingTasksOnAll();
            .prepareGetSettings(indexName)
     * and conclude migration. Remote store index settings should be applied to the index at this point.
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * Creates a docrep cluster with 3 nodes and an index with 1 primary and 2 replicas.
public class RemoteMigrationIndexMetadataUpdateIT extends MigrationBaseTestCase {
        logger.info("---> Stopping all docrep nodes");
        logger.info("---> Starting 2 docrep nodes");
    }
        String docrepReplicaNodeName = "";
     */
                .add(new MoveAllocationCommand(indexName1, 0, primaryNode, remoteNodeNames.get(0)))
                .prepareReroute()
        logger.info("---> Assert remote settings are applied");
        initDocRepToRemoteMigration();
        logger.info("---> Moving over one replica copy to remote enabled node");
        internalCluster().validateClusterFormed();
            .admin()
     * configuration is incorrect, the index stays YELLOW.
            .collect(Collectors.toList())
        int docsToIndex = randomIntBetween(10, 100);
        );
        String primaryNode = primaryNodeName(indexName1);
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;
        Path[] files = FileSystemUtils.files(translogRepoPath.resolve(RemoteIndexPath.DIR));
        logger.info("---> Assert remote index settings have been applied");
        assertAcked(
        asyncIndexingService.stopIndexing();
        AsyncIndexingService indexOne = new AsyncIndexingService(indexName1);
                .getState()
        indexTwo.startIndexing();
        logger.info("---> Starting parallel indexing on both indices");
     * - index.replication.type == SEGMENT
        );
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "docrep").build());
        waitNoPendingTasksOnAll();
        }
        indexingService.startIndexing();
        indexingService.stopIndexing();
        IndexMetadata iMd = internalCluster().client().admin().cluster().prepareState().get().getState().metadata().index(index);
        assertRemoteProperties(indexName);
        internalCluster().validateClusterFormed();
            .indices()
        assertTrue(FileSystemUtils.exists(segmentRepoPath.resolve(RemoteIndexPath.DIR)));
        stopShardRebalancing();
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "remote").build());
        );
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "remote").build());
        excludeNodeSet("type", "docrep");
            .admin()
import org.opensearch.test.OpenSearchIntegTestCase;
        logger.info("---> Starting 2 docrep nodes");
     * <p>
        assertDocrepProperties(indexName2);
        ensureYellowAndNoInitializingShards(indexName);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        internalCluster().validateClusterFormed();
        assertTrue(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(settings));
    /**
        logger.info("---> Starting 2 docrep nodes");
        logger.info("---> Assert cluster is yellow since remote index settings have been applied");
        Settings oneReplica = Settings.builder()
    }
            .build();
            client().admin()
    }
        assertRemoteProperties(indexName1);
                )
        Settings settings,
        Function<String, ClusterHealthStatus> ensureState
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).build()
        setAddRemote(true);
        assertDocrepProperties(index);
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
        logger.info("---> Excluding docrep nodes from allocation");
                .add(new MoveAllocationCommand(indexName1, 0, replicaNode, remoteNodeNames.get(1)))
import java.util.function.Function;
        AsyncIndexingService indexingService = new AsyncIndexingService(indexName);
    public void testIndexSettingsUpdateAfterIndexMovedToRemoteThroughManualReroute() throws Exception {
        waitForRelocation();
                .cluster()
                .add(new MoveAllocationCommand(indexName, 0, primaryNodeName, remoteEnabledNodes.get(0)))
import org.opensearch.cluster.health.ClusterHealthStatus;
    /**
        internalCluster().validateClusterFormed();
        initDocRepToRemoteMigration();
        assertRemoteProperties(indexName);
import java.util.List;
        waitForRelocation();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.indices.replication.common.ReplicationType;
     * Starts 2 more remote nodes and initiates shard relocation through allocation exclusion.
import org.opensearch.test.InternalTestCluster;
        logger.info("---> Starting 2 docrep nodes");
                .add(new MoveAllocationCommand(indexName, 0, replicaNodeName, remoteEnabledNodes.get(1)))
        assertFalse(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(settings));
        }
        String secondIndex = "remote-index";
     * After the primary shard copy is relocated, decrease replica count to 0, stop all docrep nodes
                .execute()
            secondIndex,
        logger.info("---> Excluding docrep nodes from allocation");
        internalCluster().validateClusterFormed();
     * have completely moved over to remote enabled nodes
        assertRemoteProperties(indexName);
     */
package org.opensearch.remotemigration;
        initDocRepToRemoteMigration();
                .execute()
            .getVersion();
        waitNoPendingTasksOnAll();
                .cluster()
        Settings oneReplica = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build();
     * <p>
        internalCluster().startClusterManagerOnlyNode();
        logger.info("---> Asserting remote index path file exists");
        addRemote = false;
     */
     */
    }
     * - index.replication.type == DOCUMENT
        initDocRepToRemoteMigration();
        long initalMetadataVersion = internalCluster().client()
                .prepareReroute()
import org.opensearch.cluster.metadata.IndexMetadata;
                .get()
        addRemote = true;
    /**
        logger.info("---> Creating index with 1 primary and 2 replicas");
        assertNotNull(iMd.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY).get(IndexMetadata.TRANSLOG_METADATA_KEY));
            "---> Stopping shard rebalancing to ensure shards do not automatically move over to newer nodes after they are launched"
        assertAcked(
        createIndexAndAssertDocrepProperties(indexName, oneReplica);
     * while the other one is created after remote nodes are added.
        waitForRelocation();
        logger.info("---> Start indexing in parallel thread");
     * Performs a blue/green type migration from docrep to remote enabled cluster.
     * Scenario:
        internalCluster().startClusterManagerOnlyNode();
        completeDocRepToRemoteMigration();
                .setPersistentSettings(
        addRemote = false;
        initDocRepToRemoteMigration();
        addRemote = false;
     * For the first index, asserts docrep settings at first, excludes docrep nodes from
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        String primaryNodeName = primaryNodeName(indexName);
    public void testIndexSettingsUpdatedWhenDocrepNodeIsRestarted() throws Exception {
        refresh(secondIndex);
        logger.info("---> Creating index with 1 primary and 1 replica");
            client().admin()
        String indexName1 = "migration-index-manual-reroute-1";
        initDocRepToRemoteMigration();
        addRemote = false;
            .index(secondIndex)
        Settings settings = iMd.getSettings();
    }
        assertDocrepProperties(indexName);
        excludeNodeSet("type", "docrep");
        assertEquals(
        waitNoPendingTasksOnAll();
            .get()
        logger.info("---> Starting 2 docrep nodes");
        ensureStableCluster(5);
        stopShardRebalancing();
        logger.info("---> Stopping docrep nodes");
    /**
 * The OpenSearch Contributors require contributions made to
        waitNoPendingTasksOnAll();
        internalCluster().validateClusterFormed();
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node));
        asyncIndexingService.startIndexing();
     */
     * Creates a mixed mode cluster. One index gets created before remote nodes are introduced,
        logger.info("---> Starting 2 docrep nodes");
        logger.info("---> Creating index with 1 primary and 2 replicas");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        logger.info("---> Creates an index with 1 primary and 1 replica");
        asyncIndexingService.startIndexing();
        Settings oneReplica = Settings.builder()
                .prepareUpdateSettings()
        logger.info(files[0].toString());
            .build();
        logger.info("---> Adding 2 remote enabled nodes to the cluster");
     * to remote through _cluster/reroute. Asserts that the remote store path based metadata
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            .cluster()
    public void testIndexSettingsUpdatedEvenForMisconfiguredReplicas() throws Exception {
    private void createIndexAndAssertDocrepProperties(String index, Settings settings) {
        logger.info("---> Starting indexing in parallel");
        assertTrue(FileSystemUtils.exists(translogRepoPath.resolve(RemoteIndexPath.DIR)));
        assertDocrepProperties(indexName);
        initDocRepToRemoteMigration();
        logger.info("---> Adding 2 remote enabled nodes to the cluster & cluster manager");
        changeReplicaCountAndEnsureGreen(0, indexName);
     * make the cluster mixed, add remote cluster-manager and data nodes.
        asyncIndexingService.startIndexing();
/*
            initalMetadataVersion,
        createIndex(index, settings);
            .admin()
        logger.info("---> Asserting custom index metadata");
        List<String> docrepNodeNames = internalCluster().startDataOnlyNodes(2);
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService(indexName);
        assertAcked(
        logger.info("---> Asserting docrep index settings");
            "---> Stopping shard rebalancing to ensure shards do not automatically move over to newer nodes after they are launched"
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node));
        waitNoPendingTasksOnAll();
                .actionGet()
        addRemote = true;
     * Asserts that remote based index settings are only applied for indices whose shards
            .build();
        logger.info("---> Moving over both shard copies for the first index to remote enabled nodes");
    ) {
    /**
     * After shard relocation completes, shuts down the docrep nodes and asserts remote
                .prepareReroute()
        createIndexAndAssertDocrepProperties(indexName, oneReplica);
        logger.info("---> Moving primary copy to remote enabled node");
    }
        internalCluster().startClusterManagerOnlyNode();
        String docrepClusterManager = internalCluster().startClusterManagerOnlyNode();
 *
     * <p>
 * this file be licensed under the Apache-2.0 license or a
        String indexName = "migration-index";
