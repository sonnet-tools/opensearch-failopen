import java.util.List;
        AsyncIndexingService asyncIndexingService = new AsyncIndexingService("test");
        logger.info("Create remote backed index");
    - Excludes docrep nodes.
                .put(CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), maximumNumberOfShards())
        internalCluster().startNode();
        updateSettingsRequest.persistentSettings(
 * compatible open source license.
        addRemote = true;
                )
    protected Settings featureFlagSettings() {
        createRepository(shallowSnapshotRepoName, "fs", settings);
     */
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
}
        assertEquals(1, getRepositoriesResponse.repositories().size());
        OpenSearchAssertions.assertHitCount(
        Path shallowSnapshotRepoPath = randomRepoPath();
        );
        Settings.Builder badSettings = Settings.builder()
        int indexedAfterFailover = randomIntBetween(10, 50);
        internalCluster().validateClusterFormed();
    }
        asyncIndexingService.startIndexing();
        internalCluster().startNodes(2);
        assertTrue(client.admin().cluster().prepareClusterStats().get().getNodes().size() < internalCluster().getNodeNames().length);
        String promotedPrimaryNode = replicaNodeName(indexName);
        logger.info("Create shallow snapshot setting enabled repo");
        internalCluster().startNode();
                        .put("index.routing.allocation.exclude._name", String.join(",", docRepNodes))
            .get()
        // add incompatible remote node in remote mixed cluster
        String oldPrimaryNode = primaryNodeName(indexName);
        setAddRemote(true);
        // add remote node in mixed mode cluster
        assertRuntimeRemoteStoreSettings("test", primaryNodeName("test"));
        OpenSearchAssertions.assertHitCount(
        assertBusy(() -> assertEquals(promotedPrimaryNode, primaryNodeName(indexName)), 30, TimeUnit.SECONDS);
        logger.info("Add remote node");
        );
            docsBeforeFailover + indexedAfterFailover
    }
        return 1;
import org.opensearch.test.InternalTestCluster;
            asyncIndexingService.getIndexedDocs()
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), Boolean.TRUE);
        RemoteStoreMigrationShardAllocationBaseTestCase.createIndex("test", 0);
 * The OpenSearch Contributors require contributions made to
        Client client = internalCluster().client(cmNodes.get(0));
        assertEquals(snapshotInfo2.isRemoteStoreIndexShallowCopyEnabled(), false);
        setAddRemote(true);
            .setTrackTotalHits(true)
        ensureGreen("test");
        setAddRemote(true);
        assertThat("node0 has 0 shards", shardCountByNodeId.get(docRepNodes.get(0)), equalTo(null));
import org.opensearch.cluster.metadata.IndexMetadata;
            .put("location", shallowSnapshotRepoPath)
        return 5;
import static org.hamcrest.Matchers.equalTo;
        refresh(indexName);
        );
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        indexBulk(indexName, indexedAfterFailover);
        internalCluster().validateClusterFormed();
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
        assertRuntimeRemoteStoreSettings(indexName, promotedPrimaryNode);
        assertTrue(indexShard.indexSettings().isSegRepEnabledOrRemoteNode());
        });
                .get(),
/*
    public void testRemoteSettingPropagatedToIndexShardAfterMigration() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchIntegTestCase;
        logger.info("Set MIXED compatibility mode");
        final String indexName = "test";
        );
        return 1;
        List<String> cmNodes = internalCluster().startNodes(1);
    }
        assertEquals(MigrationBaseTestCase.REPOSITORY_NAME, indexShard.indexSettings().getRemoteStoreRepository());
            .put("discovery.initial_state_timeout", "500ms");
        );
        internalCluster().stopRandomNode(settings -> settings.get("node.name").equals(badNode));
import java.util.Map;
        );
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store"));
                .setSettings(
import java.util.concurrent.TimeUnit;
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
    protected int minimumNumberOfReplicas() {
        SnapshotInfo snapshotInfo1 = RemoteStoreMigrationShardAllocationBaseTestCase.createSnapshot(
public class RemoteStoreMigrationTestCase extends MigrationBaseTestCase {
            client().prepareSearch("test")
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            client().prepareSearch("test").setTrackTotalHits(true).get(),
    /*
        waitForReplication("test");
        // assert repo gets registered
                .get()
                .indices()
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
 *
        waitForRelocation(TimeValue.timeValueSeconds(90));
    public void testMixedModeAddRemoteNodes() throws Exception {
package org.opensearch.remotemigration;
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(oldPrimaryNode));
        assertBusy(() -> {
                .setIndices("test")
                .admin()
        logger.info("Initialize remote cluster");
        logger.info("---> Indexing {} docs on promoted remote primary", indexedAfterFailover);
            "test"
                .setQuery(QueryBuilders.termQuery("auto", true))
    @Override
        asyncIndexingService.stopIndexing();
        IndexShard indexShard = getIndexShard(nodeName, indexName);
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "random"));
    - Asserts all shards are migrated to remote store
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    public void testNoShallowSnapshotInMixedMode() throws Exception {
        updateSettingsRequest.persistentSettings(
        OpenSearchAssertions.assertHitCount(
        ensureStableCluster(3);
            Settings.builder()
    }
    }
        client().admin().indices().prepareCreate("test").setSettings(indexSettings()).setMapping("field", "type=text").get();
import org.opensearch.common.util.FeatureFlags;
        assertTrue(indexShard.indexSettings().isRemoteStoreEnabled());
        // add docrep mode in mixed mode cluster
        String badNode = internalCluster().startNode(badSettings);
 * SPDX-License-Identifier: Apache-2.0
        initDocRepToRemoteMigration();
        assertFalse(indexShard.indexSettings().isDocumentReplication());
        internalCluster().startNode();
        assertRuntimeRemoteStoreSettings(indexName, promotedPrimaryNode);
        ensureYellowAndNoInitializingShards(indexName);
        // add remote node in docrep cluster
        assertRuntimeRemoteStoreSettings(indexName, oldPrimaryNode);
        testEndToEndRemoteMigration();
    public void testRemoteMigrationPrimaryFailoverKeepsRemoteStoreActive() throws Exception {
        SnapshotInfo snapshotInfo2 = RemoteStoreMigrationShardAllocationBaseTestCase.createSnapshot(shallowSnapshotRepoName, snapshot2);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            assertEquals(client.admin().cluster().prepareClusterStats().get().getNodes().size(), internalCluster().getNodeNames().length);
        final long docsBeforeFailover = client().prepareSearch(indexName)
                        .build()
        assertAcked(
        assertThat("node1 has 0 shards", shardCountByNodeId.get(docRepNodes.get(1)), equalTo(null));
    }
            Settings.builder()
        final String snapshot1 = "snapshot1";
            .getHits()
import org.opensearch.transport.client.Client;
                    Settings.builder()
            .setSize(0)
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed"));
    }
        Client client = internalCluster().client(cmNodes.get(0));
        logger.info("Verify that new snapshot is not shallow");
    - Asserts doc count across all shards
        assertEquals(MigrationBaseTestCase.REPOSITORY_2_NAME, indexShard.indexSettings().getRemoteStoreTranslogRepository());
        String shallowSnapshotRepoName = "shallow-snapshot-repo-name";
    public void testMigrationDirections() {
        List<String> cmNodes = internalCluster().startNodes(1);
import org.opensearch.snapshots.SnapshotInfo;
    - Continuos indexing with refresh/flush happening
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
import org.opensearch.common.unit.TimeValue;
        List<String> docRepNodes = internalCluster().startNodes(2);
        logger.info("---> Stopping indexing thread");
import org.opensearch.common.settings.Settings;
import java.nio.file.Path;
    protected int maximumNumberOfReplicas() {
            shallowSnapshotRepoName,
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING;
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        updateSettingsRequest.persistentSettings(Settings.builder().put(MIGRATION_DIRECTION_SETTING.getKey(), "docrep"));
        GetRepositoriesResponse getRepositoriesResponse = client.admin().cluster().getRepositories(gr).actionGet();
import org.opensearch.index.query.QueryBuilders;
    protected int maximumNumberOfShards() {
        Map<String, Integer> shardCountByNodeId = getShardCountByNodeId();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { REPOSITORY_NAME });
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
 */
        assertEquals(snapshotInfo1.isRemoteStoreIndexShallowCopyEnabled(), true);
        Settings.Builder settings = Settings.builder()
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        return Settings.builder().put(super.featureFlagSettings()).put(FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL, "true").build();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
    }
            client().prepareSearch(indexName).setTrackTotalHits(true).get(),
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        final String snapshot2 = "snapshot2";
    public void testEndToEndRemoteMigration() throws Exception {
    }
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
    private void assertRuntimeRemoteStoreSettings(String indexName, String nodeName) throws Exception {
            snapshot1,
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, segmentRepoPath, "REPOSITORY_2_NAME", translogRepoPath))
        logger.info("---> Stopping remote primary [{}] so remote replica [{}] is promoted", oldPrimaryNode, promotedPrimaryNode);
    - Starts docrep nodes with multiple nodes, indices, replicas copies
    - Adds remote nodes to cluster
                .setTrackTotalHits(true)// extra paranoia ;)
        testEndToEndRemoteMigration();
        logger.info("---> Starting doc ingestion in parallel thread");
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        refresh("test");
                .prepareUpdateSettings()
import org.opensearch.index.shard.IndexShard;
        assertThrows(IllegalArgumentException.class, () -> client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
    }
    }
            .value();
            .getTotalHits()
            asyncIndexingService.getIndexedDocs()
    Tests end to end remote migration via Blue Green mechanism
            internalCluster().client()
        logger.info("Verify shallow snapshot creation");
        );
        RemoteStoreMigrationShardAllocationBaseTestCase.assertRemoteStoreBackedIndex("test");
        internalCluster().startNode();
