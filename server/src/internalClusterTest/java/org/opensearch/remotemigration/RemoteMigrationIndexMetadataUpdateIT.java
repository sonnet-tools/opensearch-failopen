        logger.info("---> Creating index with 1 primary and 1 replica");  
            .getState()
        logger.info("---> Stop indexing and assert remote enabled index settings have been applied");
        ensureGreen(indexName);
     */  
        waitNoPendingTasksOnAll();  
        waitNoPendingTasksOnAll();
        logger.info("---> Moving over primary to remote store enabled nodes");
        String primaryNodeName = primaryNodeName(indexName);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    public void testIndexSettingsUpdateAfterIndexMovedToRemoteThroughAllocationExclude() throws Exception {  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        internalCluster().startClusterManagerOnlyNode();
        assertRemoteProperties(indexName);
        createIndex(index, settings);  
        changeReplicaCountAndEnsureGreen(0, indexName);
        assertRemoteProperties(indexName1);
 * compatible open source license.
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;
    }
     * Creates an index with 1 primary, 2 replicas on 2 docrep nodes. Since the replica  
        AsyncIndexingService indexingService = new AsyncIndexingService(indexName);
                .prepareState()
            .build();
        indexOne.startIndexing();
        }
        assertNotNull(iMd.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY).get(IndexMetadata.TRANSLOG_METADATA_KEY));
        initDocRepToRemoteMigration();
        assertFalse(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(settings));
        Function<String, ClusterHealthStatus> ensureState
        indexingService.startIndexing();  
        );
    /**  
     * Scenario:
        createIndexAndAssertDocrepProperties(indexName1, oneReplica);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                .add(new MoveAllocationCommand(indexName1, 0, primaryNode, remoteNodeNames.get(0)))
        internalCluster().validateClusterFormed();  
     * make the cluster mixed, add remote cluster-manager and data nodes.
        logger.info("---> Asserting remote index settings");
            .admin()  
     * After shard relocation completes, shuts down the docrep nodes and asserts remote  
        String indexName = "migration-index";
        assertTrue(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(settings));
        List<String> remoteNodeNames = internalCluster().startDataOnlyNodes(2);
    /**
     * while the other one is created after remote nodes are added.  
        assertFalse(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(settings));  
        internalCluster().validateClusterFormed();
            client().admin()  
        setAddRemote(true);  
     * Creates an index with 1 primary, 2 replicas on 2 docrep nodes.  
        internalCluster().startDataOnlyNodes(3, Settings.builder().put("node.attr._type", "docrep").build());  
            internalCluster().client()  
        );  
                .cluster()
        excludeNodeSet("type", null);
        assertRemoteProperties(indexName);
        indexBulk(secondIndex, 100);
            .prepareGetSettings(indexName)
        String indexName = "migration-index-allocation-exclude";  
        assertDocrepProperties(indexName);  
/*  
        String indexUUID = internalCluster().client()
     * when shards start relocating to the remote nodes.
        indexTwo.stopIndexing();
import java.util.Arrays;  
        stopShardRebalancing();
     * Scenario:  
     * - index.remote_store.enabled == true
        createIndexAndAssertDocrepProperties(indexName, oneReplica);
import java.util.List;
        createIndexAndAssertDocrepProperties(indexName, oneReplica);  
        initDocRepToRemoteMigration();
     * to remote through _cluster/reroute. Asserts that the remote store path based metadata
        logger.info("---> Moving over both shard copies for the first index to remote enabled nodes");  
        asyncIndexingService.stopIndexing();  
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "remote").build());
                .prepareReroute()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        String docrepClusterManager = internalCluster().startClusterManagerOnlyNode();  
     * and conclude migration. Remote store index settings should be applied to the index at this point.
    /**
                .actionGet()
                .prepareReroute()  
            .getVersion();
            .metadata()  
        logger.info("---> Asserting remote index path file exists");
     * <p>
     * Performs a manual _cluster/reroute to move shards from docrep to remote enabled nodes.  
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "docrep").build());
            .cluster()
        logger.info("---> Moving primary copy to remote enabled node");  
        waitNoPendingTasksOnAll();
        assertAcked(
        createIndexAssertHealthAndDocrepProperties(indexName, oneReplica, this::ensureYellowAndNoInitializingShards);
        assertDocrepProperties(index);  
     * Asserts that remote based index settings are only applied for indices whose shards
        refresh(secondIndex);
        logger.info("---> Stopping indexing");  
        for (String node : docrepNodeNames) {  
        logger.info("---> Starting indexing in parallel");
        assertRemoteProperties(secondIndex);
        assertRemoteProperties(indexName);  
        ClusterState clusterState = internalCluster().client().admin().cluster().prepareState().get().getState();
        List<String> remoteEnabledNodes = internalCluster().startDataOnlyNodes(
        addRemote = true;  
            .get(0);
        waitForRelocation();
     */  
                .actionGet()  
     * exclude docrep nodes, assert that remote index path file exists
        logger.info("---> Starting 2 docrep nodes");
        String indexName2 = "migration-index-manual-reroute-2";
     * creates an index on docrep node with non-remote cluster-manager.
     * Adds 3 more remote nodes to the cluster and moves over the primary copy from docrep  
    private void createIndexAndAssertDocrepProperties(String index, Settings settings) {  
            "---> Stopping shard rebalancing to ensure shards do not automatically move over to newer nodes after they are launched"  
        internalCluster().validateClusterFormed();
                .add(new MoveAllocationCommand(indexName1, 0, replicaNode, remoteNodeNames.get(1)))  
import org.opensearch.test.OpenSearchIntegTestCase;  
    }
        asyncIndexingService.stopIndexing();  
     * Asserts that remote based index settings are applied after all shards move over
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService(indexName);
    public void testIndexSettingsUpdatedOnlyForMigratingIndex() throws Exception {  
        assertEquals(1, files.length);  
        Settings oneReplica = Settings.builder()
                .prepareReroute()
        IndexMetadata iMd = internalCluster().client().admin().cluster().prepareState().get().getState().metadata().index(index);  
        waitNoPendingTasksOnAll();  
            .build();  
            .index(indexName)
        asyncIndexingService.stopIndexing();
        logger.info("---> Starting 2 remote store enabled nodes");  
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
    }
     * Asserts index metadata customs has the <code>remote_store</code> key
        logger.info("---> Starting 2 docrep nodes");
    ) {
        String indexName1 = "migration-index-manual-reroute-1";  
            Settings.builder().put("node.attr._type", "remote").build()  
        internalCluster().validateClusterFormed();
        logger.info("---> Storing current index metadata version");
    public void testIndexSettingsUpdateDuringReplicaCountDecrement() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        List<String> docrepNodeNames = internalCluster().startDataOnlyNodes(2);
        logger.info("---> Starting 3 docrep nodes");
            .index(secondIndex)  
        internalCluster().validateClusterFormed();
        asyncIndexingService.startIndexing();
        logger.info("---> Starting indexing in parallel");  
            .build();
        logger.info("---> Assert index still has dcorep settings since replica copies are still on docrep nodes");
        internalCluster().validateClusterFormed();
        initalMetadataVersion = internalCluster().client()
        // validate remote index path file exists
                    Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.HASHED_PREFIX)
        logger.info("---> Moving over one replica copy to remote enabled node");
            client().admin()  
            .get()  
        String docrepReplicaNodeName = "";
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "remote").build());
        addRemote = true;
import java.util.stream.Collectors;  
        createIndexAndAssertDocrepProperties(indexName, oneReplica);  
        waitForRelocation();  
     * configuration is incorrect, the index stays YELLOW.
        AsyncIndexingService indexingService = new AsyncIndexingService(indexName);
        String index,
import org.opensearch.common.settings.Settings;  
        logger.info("---> Asserting docrep index settings");
        stopShardRebalancing();
        assertTrue(
import org.opensearch.core.util.FileSystemUtils;
    }
        internalCluster().validateClusterFormed();  
            secondIndex,
            if (nodes.get(shardRouting.currentNodeId()).isRemoteStoreNode() == false) {  
        addRemote = true;  
        assertDocrepProperties(indexName);  
        createIndexAndAssertDocrepProperties(indexName2, oneReplica);
                .add(new MoveAllocationCommand(indexName2, 0, primaryNodeName(indexName2), remoteNodeNames.get(0)))
    }  
        assertTrue(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(settings));
     * After the primary shard copy is relocated, decrease replica count to 0, stop all docrep nodes
     * Performs a blue/green type migration from docrep to remote enabled cluster.  
        initDocRepToRemoteMigration();
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService(indexName);  
        logger.info("---> Creates an index with 1 primary and 1 replica");
            .get();
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "remote").build());  
        }
import java.nio.file.Path;
        logger.info("---> Excluding docrep nodes from allocation");  
        logger.info("---> Stopping docrep nodes");
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(docrepClusterManager));
import org.opensearch.indices.replication.common.ReplicationType;
     * have been relocated.
        Settings settings = iMd.getSettings();
            "---> Stopping shard rebalancing to ensure shards do not automatically move over to newer nodes after they are launched"
        assertTrue(
        logger.info("---> Excluding docrep nodes from allocation");
        waitForRelocation();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    /**
            .getSetting(indexName, IndexMetadata.SETTING_INDEX_UUID);
     * have been applied to the index.
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
        logger.info("---> Starting 2 docrep nodes");  
     * Assert current index settings have:
     * - index.replication.type == SEGMENT
            .collect(Collectors.toList())  
            client().admin()
        waitForRelocation();
    public void testIndexSettingsUpdatedEvenForMisconfiguredReplicas() throws Exception {  
        logger.info(
            initalMetadataVersion < internalCluster().client()
        internalCluster().startClusterManagerOnlyNode();
        excludeNodeSet("type", "docrep");  
                .add(new MoveAllocationCommand(indexName, 0, primaryNode, remoteNodeNames.get(0)))  
        logger.info("---> Assert metadata version is not changed");  
     */
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService(indexName);
                .execute()
    private void assertDocrepProperties(String index) {
        String primaryNode = primaryNodeName(indexName1);  
        initDocRepToRemoteMigration();
        waitNoPendingTasksOnAll();
     * Moves over the first replica copy and asserts that the remote store based settings has not been applied  
    /**
        for (ShardRouting shardRouting : clusterState.routingTable().index(indexName).shard(0).getShards()) {
        indexTwo.startIndexing();
        logger.info("---> Starting 2 docrep nodes");  
        DiscoveryNodes nodes = clusterState.nodes();
        initDocRepToRemoteMigration();  
        logger.info("---> Assert index still has dcorep settings since replica copies are still on docrep nodes");
        Settings settings = iMd.getSettings();
        assertTrue(FileSystemUtils.exists(segmentRepoPath.resolve(RemoteIndexPath.DIR)));
        excludeNodeSet("type", "docrep");
     * - index.replication.type == DOCUMENT
        );  
     * - index.remote_store.translog.repository != null  
        assertCustomIndexMetadata(indexName);
        waitForRelocation();
     * Scenario:
        initDocRepToRemoteMigration();
        logger.info("---> Assert index still has docrep settings");
     * Creates a mixed mode cluster. One index gets created before remote nodes are introduced,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    private void assertRemoteProperties(String index) {
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "docrep").build());
        assertTrue(Arrays.stream(files).anyMatch(file -> file.toString().contains(indexUUID)));
        Path[] files = FileSystemUtils.files(translogRepoPath.resolve(RemoteIndexPath.DIR));
        long initalMetadataVersion = internalCluster().client()  
                .cluster()  
        logger.info("---> Start indexing in parallel thread");
        logger.info("---> Assert remote settings are applied");  
        internalCluster().validateClusterFormed();
    private void assertCustomIndexMetadata(String index) {  
        for (String node : docrepNodes) {  
 * this file be licensed under the Apache-2.0 license or a
        waitForRelocation();  
        indexingService.startIndexing();
                .actionGet()
            client().admin()  
        waitNoPendingTasksOnAll();
        logger.info("---> Adding 2 remote enabled nodes to the cluster & cluster manager");
                .prepareReroute()
     * Starts 2 more remote nodes and initiates shard relocation through allocation exclusion.
            .filter(nodeName -> nodeName.equals(primaryNodeName(indexName1)) == false)
        logger.info("---> Creating index with 1 primary and 2 replicas");
        internalCluster().startClusterManagerOnlyNode();  
        String indexName = "migration-index";  
        logger.info("---> Adding 3 remote enabled nodes");
    }
        addRemote = true;  
        logger.info("---> Starts 2 remote enabled nodes");
                .get()
        indexOne.stopIndexing();
                .get()  
        internalCluster().validateClusterFormed();  
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node));
        logger.info("---> Starting 3 remote store enabled nodes");
            .getVersion();
     * - index.remote_store.segment.repository == null  
            .indices()
                .cluster()  
        assertTrue(FileSystemUtils.exists(translogRepoPath.resolve(RemoteIndexPath.DIR)));
        String indexName = "index-1";
            .getState()
        addRemote = false;
        assertAcked(
        Settings oneReplica = Settings.builder()
                .execute()  
        assertNotNull(iMd.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY));  
        assertEquals(ReplicationType.DOCUMENT, IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(settings));
        internalCluster().startClusterManagerOnlyNode();
     * For the first index, asserts docrep settings at first, excludes docrep nodes from
     * store settings has been applied as all shards have moved over
        internalCluster().validateClusterFormed();
                .execute()
}  
                .getState()
                .prepareReroute()
     * and asserts remote index settings are applied as soon as the docrep replica copy is unassigned  
        ensureStableCluster(5);  
        logger.info("---> Creating index with 1 primary and 1 replica");  
        String replicaNodeName = replicaNodeName(indexName);
        Settings oneReplica = Settings.builder()
        indexingService.stopIndexing();  
     * Scenario:
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        waitForRelocation();
     * only primary shard copy of the index  
     * Assert current index settings have:  
        String indexName = "migration-index-allocation-exclude";  
        excludeNodeSet("type", "docrep");  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
     * - index.remote_store.enabled == false
import org.opensearch.test.InternalTestCluster;
        internalCluster().validateClusterFormed();  
        assertTrue(Arrays.stream(files).anyMatch(file -> file.toString().contains(indexUUID)));
        internalCluster().validateClusterFormed();  
public class RemoteMigrationIndexMetadataUpdateIT extends MigrationBaseTestCase {  
        ensureGreen(indexName);  
    /**
        internalCluster().validateClusterFormed();  
        logger.info("---> Starting indexing in parallel");
        IndexMetadata iMd = internalCluster().client().admin().cluster().prepareState().get().getState().metadata().index(index);
     * have completely moved over to remote enabled nodes
        AsyncIndexingService indexOne = new AsyncIndexingService(indexName1);
            .execute(AddVotingConfigExclusionsAction.INSTANCE, new AddVotingConfigExclusionsRequest(docrepClusterManager))
                .execute()
        );
import org.opensearch.index.remote.RemoteStoreEnums;  
     */
            .admin()  
            initalMetadataVersion,
        AsyncIndexingService indexTwo = new AsyncIndexingService(indexName2);
                )  
    /**  
        logger.info("---> Assert remote settings are applied for index one but not for index two");
        internalCluster().validateClusterFormed();  
                .actionGet()
        Settings oneReplica = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build();
        logger.info("---> Assert remote index settings have been applied");  
                .cluster()
     * For the second index, asserts that it already has remote enabled settings.  
     * Scenario:
        assertAcked(
     */  
        List<String> docrepNodes = internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "docrep").build());
        logger.info("---> Assert cluster is yellow since remote index settings have been applied");
     * allocation and asserts that remote index settings are applied after all shards  
        internalCluster().validateClusterFormed();
        waitForRelocation();  
     * - index.remote_store.segment.repository != null
        );
                .prepareUpdateSettings()  
     * - index.remote_store.translog.repository == null
        logger.info("---> Starting indexing in parallel");  
     * Starts 2 more remote nodes and initiates shard relocation through allocation exclusion.
        assertFalse(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(settings));
                .actionGet()
import org.opensearch.cluster.metadata.IndexMetadata;
        Settings oneReplica = Settings.builder()  
import org.opensearch.index.remote.RemoteIndexPath;
        IndexMetadata iMd = internalCluster().client().admin().cluster().prepareState().get().getState().metadata().index(index);  
     * Scenario:
    public void testIndexSettingsUpdateAfterIndexMovedToRemoteThroughManualReroute() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .actionGet()
        waitNoPendingTasksOnAll();
        completeDocRepToRemoteMigration();
        String primaryNode = primaryNodeName(indexName);
        waitForRelocation();
        waitForRelocation();
            internalCluster().client().admin().cluster().prepareState().get().getState().metadata().index(secondIndex).getVersion()  
        logger.info("---> Excluding docrep nodes from allocation");  
            .metadata()
            3,
     * Asserts index metadata customs has the <code>remote_store</code> key
        internalCluster().validateClusterFormed();
    public void testRemotePathMetadataAddedWithFirstPrimaryMovingToRemote() throws Exception {
                .add(new MoveAllocationCommand(indexName, 0, replicaNodeName, remoteEnabledNodes.get(1)))
        createIndexAndAssertDocrepProperties(indexName, oneReplica);
        String docrepClusterManager = internalCluster().startClusterManagerOnlyNode();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        logger.info("---> Creating index with 1 primary and 2 replicas");  
    /**
        internalCluster().startClusterManagerOnlyNode();
                .isAcknowledged()
        List<String> docrepNodes = internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "docrep").build());
            .build();
        addRemote = true;  
        ensureYellowAndNoInitializingShards(indexName);  
        internalCluster().validateClusterFormed();  
     * Indexes some more docs and asserts that the index metadata version does not increment
        excludeNodeSet("type", "docrep");
     * Creates an index with 1 pri 1 rep setup with 3 docrep nodes (1 cluster manager + 2 data nodes),
                .execute()
        logger.info("---> Stopping all docrep nodes");
        internalCluster().startClusterManagerOnlyNode();  
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertRemoteProperties(indexName);
        );
        assertRemoteProperties(indexName);
        addRemote = true;
        ensureGreen(secondIndex);  
        addRemote = true;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        Settings oneReplica = Settings.builder()
        List<String> remoteNodeNames = internalCluster().startDataOnlyNodes(2);  
     */  
 * The OpenSearch Contributors require contributions made to  
        );  
            .get()  
                .getVersion()
                .metadata()
        logger.info("---> Asserts index still has docrep index settings");
        createIndex(  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).build()
        }
            .build();
        waitNoPendingTasksOnAll();
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "docrep").build());  
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "remote").build());
        logger.info("---> Moving only primary for the second index to remote enabled nodes");  
import org.opensearch.cluster.health.ClusterHealthStatus;
     * index settings are applied even when the index is in YELLOW state
        int docsToIndex = randomIntBetween(10, 100);
     * <p>
     * Creates a docrep cluster with 3 nodes and an index with 1 primary and 2 replicas.
        logger.info(
     */
        String indexName = "migration-index-replica-decrement";
        // elect cluster manager with remote-cluster state enabled
        assertAcked(  
            }  
            .prepareState()
        waitNoPendingTasksOnAll();
        assertEquals(
        internalCluster().client()  
        files = FileSystemUtils.files(segmentRepoPath.resolve(RemoteIndexPath.DIR));
        initDocRepToRemoteMigration();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        logger.info("---> Creating 2 indices with 1 primary and 1 replica");
        refresh(index);
        waitNoPendingTasksOnAll();
        logger.info("---> Creating a new index on remote enabled nodes");
        assertAcked(
package org.opensearch.remotemigration;
        excludeNodeSet("type", "docrep");
        waitNoPendingTasksOnAll();  
 */  
     * <p>  
        asyncIndexingService.startIndexing();  
        Settings oneReplica = Settings.builder()
import org.opensearch.cluster.ClusterState;  
        String replicaNode = docrepNodeNames.stream()
                .setPersistentSettings(
        assertDocrepProperties(indexName2);  
            .admin()
        createIndexAssertHealthAndDocrepProperties(indexName, oneReplica, this::ensureYellowAndNoInitializingShards);
        assertTrue(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(settings));  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        createIndexAndAssertDocrepProperties(indexName, oneReplica);
        internalCluster().startClusterManagerOnlyNode();
     * Scenario:
                .cluster()
            client().admin()
        createIndexAssertHealthAndDocrepProperties(index, settings, this::ensureGreen);
    }
        assertEquals(1, files.length);  
        logger.info("---> Excluding docrep nodes from allocation");
    }
        logger.info("---> Starting 2 docrep nodes");  
        logger.info("---> Assert custom remote path based metadata is applied");
        logger.info("---> Assert cluster has turned green since more nodes are added to the cluster");
    public void testIndexSettingsUpdatedWhenDocrepNodeIsRestarted() throws Exception {
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        logger.info("---> Stopping docrep node holding the replica copy");
        );  
    }
        logger.info("---> Starting 2 docrep nodes");
        assertDocrepProperties(indexName);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
import org.opensearch.cluster.node.DiscoveryNodes;  
     * Scenario:  
        String indexName = "migration-index-allocation-exclude";
        );
        logger.info("---> Starts 2 remote enabled nodes");
        logger.info("---> Adding 2 remote enabled nodes to the cluster");
     */
        addRemote = false;
        );  
                .add(new MoveAllocationCommand(indexName, 0, primaryNodeName, remoteEnabledNodes.get(0)))  
        internalCluster().restartNode(docrepReplicaNodeName);
                .index(indexName)  
        addRemote = false;
    /**  
                .admin()  
                .execute()  
        ensureState.apply(index);
        logger.info("---> Starting 2 docrep nodes");
        ensureYellowAndNoInitializingShards(indexName);
        addRemote = false;
                break;
    }
 *
            client().admin()
        String secondIndex = "remote-index";
        assertAcked(
                docrepReplicaNodeName = nodes.get(shardRouting.currentNodeId()).getName();
        logger.info("---> Assert cluster has turned green since more nodes are added to the cluster");
        logger.info("---> Creating index with 1 primary and 2 replicas");
                .cluster()
                .cluster()
            .build();
        );  
        indexBulk(indexName, docsToIndex);  
    }  
        List<String> docrepNodeNames = internalCluster().startDataOnlyNodes(2);  
            .cluster()
                .prepareReroute()
        logger.info("---> Creating the first index with 1 primary and 1 replica");
     */  
        assertNotNull(iMd.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY));  
        addRemote = false;  
import java.util.function.Function;
     * Excludes docrep nodes from allocation to force migration of the 3rd replica copy and asserts remote
    }
        logger.info(files[0].toString());
        Settings oneReplica = Settings.builder()
        logger.info("---> Reducing replica count to 0 for the index");
        logger.info("---> Indexing {} on both indices", docsToIndex);
        logger.info("---> Adding 2 remote enabled nodes to the cluster");
        logger.info("---> Excluding docrep nodes from allocation");
     */
        assertEquals(ReplicationType.SEGMENT, IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(settings));
            .get()
        initDocRepToRemoteMigration();
    private void createIndexAssertHealthAndDocrepProperties(
        internalCluster().startDataOnlyNodes(2, Settings.builder().put("node.attr._type", "remote").build());
        waitForRelocation();
        Settings settings,  
            .build();
        logger.info("---> Excluding docrep nodes from allocation");
        asyncIndexingService.startIndexing();
     * After shard relocation completes, restarts the docrep node holding extra replica shard copy
                .cluster()
        internalCluster().startClusterManagerOnlyNode();
        logger.info("---> Asserting custom index metadata");
        logger.info("---> Starting parallel indexing on both indices");  
            .prepareState()  
import org.opensearch.cluster.routing.ShardRouting;
        excludeNodeSet("type", "docrep");
    /**
        indexingService.stopIndexing();
     */  
        waitNoPendingTasksOnAll();
        assertRemoteProperties(indexName);  
    }  
        logger.info("---> Assert remote settings are applied");
        waitNoPendingTasksOnAll();
    public void testRemoteIndexPathFileExistsAfterMigration() throws Exception {
    /**  
                .admin()
        waitForRelocation();  
        logger.info("---> Assert index has remote store settings");
        );
        );
     * initiate migration and create 3 remote nodes (1 cluster manager + 2 data nodes) and moves over
        waitNoPendingTasksOnAll();
        logger.info(files[0].toString());
