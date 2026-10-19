        List<String> cmNodes = internalCluster().startNodes(1);
        logger.info("---> Stopping remote primary [{}] so remote replica [{}] is promoted", oldPrimaryNode, promotedPrimaryNode);
import java.util.concurrent.TimeUnit;
import org.opensearch.test.OpenSearchIntegTestCase;
        setAddRemote(true);  
    public void testEndToEndRemoteMigration() throws Exception {
    public void testRemoteSettingPropagatedToIndexShardAfterMigration() throws Exception {
        assertRuntimeRemoteStoreSettings(indexName, promotedPrimaryNode);
                        .put("index.routing.allocation.exclude._name", String.join(",", docRepNodes))
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;  
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING;
        IndexShard indexShard = getIndexShard(nodeName, indexName);
        // add incompatible remote node in remote mixed cluster
        assertBusy(() -> {
            .put("location", shallowSnapshotRepoPath)
            asyncIndexingService.getIndexedDocs()
            internalCluster().client()  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
            shallowSnapshotRepoName,
import org.opensearch.cluster.metadata.IndexMetadata;
        String badNode = internalCluster().startNode(badSettings);  
            Settings.builder()  
        logger.info("Verify that new snapshot is not shallow");
        createRepository(shallowSnapshotRepoName, "fs", settings);  
        internalCluster().startNode();
        logger.info("---> Indexing {} docs on promoted remote primary", indexedAfterFailover);  
 *
        logger.info("Set MIXED compatibility mode");
        return 1;
            client().prepareSearch(indexName).setTrackTotalHits(true).get(),
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
        return 1;
        SnapshotInfo snapshotInfo2 = RemoteStoreMigrationShardAllocationBaseTestCase.createSnapshot(shallowSnapshotRepoName, snapshot2);  
                )
        SnapshotInfo snapshotInfo1 = RemoteStoreMigrationShardAllocationBaseTestCase.createSnapshot(
        internalCluster().setBootstrapClusterManagerNodeIndex(0);  
import java.util.List;  
        asyncIndexingService.startIndexing();
        List<String> docRepNodes = internalCluster().startNodes(2);  
        waitForReplication("test");
        testEndToEndRemoteMigration();
 * compatible open source license.
                .setSettings(
    protected int minimumNumberOfReplicas() {
        assertAcked(
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
    protected int maximumNumberOfShards() {
    - Asserts doc count across all shards
        indexBulk(indexName, indexedAfterFailover);
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
            snapshot1,  
        );  
 */  
    public void testMixedModeAddRemoteNodes() throws Exception {
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
            .get()  
    }  
            client().prepareSearch("test")
        return Settings.builder().put(super.featureFlagSettings()).put(FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL, "true").build();
        GetRepositoriesResponse getRepositoriesResponse = client.admin().cluster().getRepositories(gr).actionGet();
    - Starts docrep nodes with multiple nodes, indices, replicas copies  
        );
        // add remote node in mixed mode cluster
            docsBeforeFailover + indexedAfterFailover  
    - Adds remote nodes to cluster
        ensureYellowAndNoInitializingShards(indexName);
        assertTrue(indexShard.indexSettings().isRemoteStoreEnabled());  
        Client client = internalCluster().client(cmNodes.get(0));
    public void testRemoteMigrationPrimaryFailoverKeepsRemoteStoreActive() throws Exception {  
        logger.info("---> Stopping indexing thread");
        client().admin().indices().prepareCreate("test").setSettings(indexSettings()).setMapping("field", "type=text").get();
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
            .getHits()
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
    }  
    private void assertRuntimeRemoteStoreSettings(String indexName, String nodeName) throws Exception {
        setAddRemote(true);  
        assertFalse(indexShard.indexSettings().isDocumentReplication());
                        .build()  
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService("test");  
        logger.info("Verify shallow snapshot creation");
        internalCluster().startNodes(2);  
        OpenSearchAssertions.assertHitCount(  
    }
        // assert repo gets registered
                .admin()
    /*
import org.opensearch.common.unit.TimeValue;  
        final long docsBeforeFailover = client().prepareSearch(indexName)  
import org.opensearch.common.util.FeatureFlags;
        assertRuntimeRemoteStoreSettings(indexName, oldPrimaryNode);
 * this file be licensed under the Apache-2.0 license or a
    }
        return 5;
        assertThat("node0 has 0 shards", shardCountByNodeId.get(docRepNodes.get(0)), equalTo(null));
                    Settings.builder()  
                .get(),
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
        final String snapshot2 = "snapshot2";
        assertEquals(MigrationBaseTestCase.REPOSITORY_NAME, indexShard.indexSettings().getRemoteStoreRepository());  
    }
        // add docrep mode in mixed mode cluster
        asyncIndexingService.stopIndexing();  
        logger.info("Add remote node");
        assertEquals(snapshotInfo2.isRemoteStoreIndexShallowCopyEnabled(), false);
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store"));
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed"));
        logger.info("Create remote backed index");
        int indexedAfterFailover = randomIntBetween(10, 50);
import org.opensearch.snapshots.SnapshotInfo;
            .setTrackTotalHits(true)
        internalCluster().stopRandomNode(settings -> settings.get("node.name").equals(badNode));
        internalCluster().validateClusterFormed();  
            Settings.builder()  
    - Continuos indexing with refresh/flush happening
    }  
            asyncIndexingService.getIndexedDocs()  
        Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();
        OpenSearchAssertions.assertHitCount(
    }
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, segmentRepoPath, "REPOSITORY_2_NAME", translogRepoPath))
        refresh("test");
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
 * SPDX-License-Identifier: Apache-2.0
                .prepareUpdateSettings()  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.client.Client;  
    protected Settings featureFlagSettings() {  
        assertEquals(1, getRepositoriesResponse.repositories().size());
    public void testNoShallowSnapshotInMixedMode() throws Exception {  
        final String indexName = "test";
/*  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertThrows(IllegalArgumentException.class, () -> client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
        RemoteStoreMigrationShardAllocationBaseTestCase.assertRemoteStoreBackedIndex("test");
import java.util.Map;
        String promotedPrimaryNode = replicaNodeName(indexName);  
import org.opensearch.common.settings.Settings;
        Settings.Builder settings = Settings.builder()  
                .setIndices("test")
            .put("discovery.initial_state_timeout", "500ms");
        OpenSearchAssertions.assertHitCount(
        ensureStableCluster(3);  
    }
            assertEquals(client.admin().cluster().prepareClusterStats().get().getNodes().size(), internalCluster().getNodeNames().length);
                .setQuery(QueryBuilders.termQuery("auto", true))
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        logger.info("Create shallow snapshot setting enabled repo");  
        );  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
    }
        refresh(indexName);  
import static org.hamcrest.Matchers.equalTo;
     */  
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { REPOSITORY_NAME });  
        internalCluster().validateClusterFormed();  
    - Asserts all shards are migrated to remote store  
        updateSettingsRequest.persistentSettings(
        assertTrue(indexShard.indexSettings().isSegRepEnabledOrRemoteNode());
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "random"));
        setAddRemote(true);
    }
        updateSettingsRequest.persistentSettings(
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        assertRuntimeRemoteStoreSettings(indexName, promotedPrimaryNode);  
        internalCluster().startNode();  
        );  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE);
        internalCluster().setBootstrapClusterManagerNodeIndex(0);  
        addRemote = true;
        );
        waitForRelocation(TimeValue.timeValueSeconds(90));
            .getTotalHits()
    - Excludes docrep nodes.
        RemoteStoreMigrationShardAllocationBaseTestCase.createIndex("test", 0);  
        internalCluster().startNode();
        String oldPrimaryNode = primaryNodeName(indexName);
        Path shallowSnapshotRepoPath = randomRepoPath();
                .put(CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), maximumNumberOfShards())
    protected int maximumNumberOfReplicas() {  
        );
        assertEquals(MigrationBaseTestCase.REPOSITORY_2_NAME, indexShard.indexSettings().getRemoteStoreTranslogRepository());
    @Override
    }
        Client client = internalCluster().client(cmNodes.get(0));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(oldPrimaryNode));
    Tests end to end remote migration via Blue Green mechanism
        List<String> cmNodes = internalCluster().startNodes(1);
            .value();  
        final String snapshot1 = "snapshot1";  
        String shallowSnapshotRepoName = "shallow-snapshot-repo-name";
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
        assertBusy(() -> assertEquals(promotedPrimaryNode, primaryNodeName(indexName)), 30, TimeUnit.SECONDS);
        );  
        testEndToEndRemoteMigration();
                .indices()
            .setSize(0)
                .setTrackTotalHits(true)// extra paranoia ;)  
        assertRuntimeRemoteStoreSettings("test", primaryNodeName("test"));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        ensureGreen("test");  
        initDocRepToRemoteMigration();  
        });  
import org.opensearch.index.query.QueryBuilders;
    public void testMigrationDirections() {
            client().prepareSearch("test").setTrackTotalHits(true).get(),
            "test"
public class RemoteStoreMigrationTestCase extends MigrationBaseTestCase {
import org.opensearch.index.shard.IndexShard;  
import java.nio.file.Path;
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "docrep"));
        // add remote node in docrep cluster
        Settings.Builder badSettings = Settings.builder()  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
        logger.info("---> Starting doc ingestion in parallel thread");
        assertTrue(client.admin().cluster().prepareClusterStats().get().getNodes().size() < internalCluster().getNodeNames().length);
        assertThat("node1 has 0 shards", shardCountByNodeId.get(docRepNodes.get(1)), equalTo(null));  
        assertEquals(snapshotInfo1.isRemoteStoreIndexShallowCopyEnabled(), true);  
        internalCluster().startNode();
}  
package org.opensearch.remotemigration;
                .get()
        logger.info("Initialize remote cluster");
import org.opensearch.test.InternalTestCluster;  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
