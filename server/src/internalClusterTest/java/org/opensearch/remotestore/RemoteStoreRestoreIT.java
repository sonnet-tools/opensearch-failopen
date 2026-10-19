                new RestoreRemoteStoreRequest().indices("*", "-remote-store-test-index-*").restoreAllShards(restoreAllShards),  
            if (ClusterHealthStatus.RED.equals(indexHealth)) {  
            .restoreRemoteStore(
        testRestoreFlow(1, true, true, randomIntBetween(1, 5));
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(index)));
            buildRemoteStoreNodeAttributes(REPOSITORY_NAME, segmentRepoPath, REPOSITORY_2_NAME, tlogRepoPath, true)
        int shardCount = randomIntBetween(1, 5);
        client().admin()  
     * @param invokeFlush If true, a flush is invoked. Otherwise, a refresh is invoked.  
        prepareCluster(1, 3, INDEX_NAME, 0, shardCount);  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNodeName(INDEX_NAME)));
        restore(indices);  
            if (ClusterHealthStatus.RED.equals(ensureRed(index))) {
        );  
        IndexShard indexShard = indexService.getShard(0);
     * @throws IOException IO Exception.
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreResponse;
            assertEquals(shardCount, getNumShards(index).totalNumShards);
        flushAndRefresh(INDEX_NAME);
        assertEquals(shardCount, getNumShards(INDEX_NAME).totalNumShards);
import org.opensearch.repositories.fs.ReloadableFsRepository;
        }, 30, TimeUnit.SECONDS);
     * @param numberOfIterations Number of times a refresh/flush should be invoked, followed by indexing some data.
                client(replicaNodeName(INDEX_NAME)).prepareSearch(INDEX_NAME).setSize(0).get(),  
     */
        }  
        testRestoreFlowBothPrimaryReplicasDown(1, false, true, randomIntBetween(1, 5));  
            .cluster()  
    public void testRTSRestoreWithCommittedDataMultipleIndicesPatterns() throws Exception {
            .cluster()
    public void testRTSRestoreWithCommittedDataNotAllRedRemoteIndices() throws Exception {  
        PlainActionFuture<RestoreRemoteStoreResponse> future = PlainActionFuture.newFuture();
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class);
    /**  
        int shardCount = randomIntBetween(1, 5);
        String[] indices = INDEX_NAMES.split(",");  
                internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNodeName(index)));
            () -> assertHitCount(  
            indicesStats.put(index, indexStats);
        createRepository(REPOSITORY_NAME, ReloadableFsRepository.TYPE, settings);
                PlainActionFuture.newFuture()
        ensureRed(indices);  
        flushAndRefresh(INDEX_NAME);
            // If the request goes to co-ordinator, e.getCause() can be RemoteTransportException  
            if (ClusterHealthStatus.GREEN.equals(ensureRed(index))) {
     * @throws IOException IO Exception.
                PlainActionFuture.newFuture()
 * SPDX-License-Identifier: Apache-2.0
        boolean restoreAllShards = randomBoolean();
            verifyRestoredData(indicesStats.get(index), index);
            Map<String, Long> indexStats = indexData(2, true, index);  
     * Helper function to test restoring an index having replicas from remote store when all the nodes housing the primary/replica drop.
        ensureGreen(INDEX_NAME);
                new RestoreRemoteStoreRequest().indices(INDEX_NAMES_WILDCARD.split(",")).restoreAllShards(restoreAllShards),  
        Settings.Builder settings = Settings.builder();
        );
            Repository segmentRepo = repositoriesService.repository(REPOSITORY_NAME);
        }
        assertEquals(shardCount, getNumShards(indices[0]).totalNumShards);  
        prepareCluster(1, 3, INDEX_NAME, 0, shardCount);
     * and unrefreshed data restored using Remote Translog Store.
     * @throws IOException IO Exception.  
        testRestoreFlow(0, true, false, randomIntBetween(1, 5));
        testRestoreFlowBothPrimaryReplicasDown(1, true, true, randomIntBetween(1, 5));  
     * @param numberOfIterations Number of times a refresh/flush should be invoked, followed by indexing some data.
        testRestoreFlowBothPrimaryReplicasDown(randomIntBetween(2, 5), true, false, randomIntBetween(1, 5));  
            assertEquals(shardCount * (replicaCount + 1), getNumShards(index).totalNumShards);
        if (restoreAllShards) {  
        // This is required to get updated number from already active shards which were not restored  
    public void testRTSRestoreWithNoDataPostCommitPrimaryReplicaDown() throws Exception {
        } catch (ExecutionException e) {
        testRestoreFlow(randomIntBetween(2, 5), true, false, randomIntBetween(1, 5));
            long downloadPauseTime = 0L;  
        testRestoreFlowBothPrimaryReplicasDown(randomIntBetween(2, 5), false, false, randomIntBetween(1, 5));  
        }  
        String[] indices = INDEX_NAMES.split(",");  
        }
        prepareCluster(1, 3, INDEX_NAMES, replicaCount, shardCount);
     * Simulates refreshed data restored using Remote Segment Store
            Locale.getDefault(),
        int replicaCount = 1;
                continue;
        assertEquals(shardCount, getNumShards(indices[1]).totalNumShards);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));
        client().admin()
import org.opensearch.cluster.node.DiscoveryNode;
        prepareCluster(1, 2, INDEX_NAME, 1, 1);
                downloadPauseTime += repositoriesService.repository(REPOSITORY_NAME).getRemoteDownloadThrottleTimeInNanos();
     * Simulates refreshed data restored using Remote Segment Store
package org.opensearch.remotestore;
    public void testMultipleWriters() throws Exception {
        prepareCluster(1, 2, INDEX_NAME, 1, shardCount);  
        ensureRed(INDEX_NAME);  
        indexShard = indexService.getShard(0);
        RemoteSegmentMetadata remoteSegmentMetadataBeforeFailover = indexShard.getRemoteDirectory().readLatestMetadataFile();
            .stream()
            .collect(Collectors.toMap(key -> key.replace(settingsAttributeKeyPrefix, ""), key -> node.getAttributes().get(key)));
    public void testRestoreFlowAllShardsNoRedIndex() throws InterruptedException {
            ),
     * @throws IOException IO Exception.
            if (ClusterHealthStatus.RED.equals(ensureRed(index))) {  
        ensureRed(INDEX_NAME);
        prepareCluster(1, 3, INDEX_NAME, 0, shardCount);
        ensureYellow(INDEX_NAME);  
        restoreAndVerify(shardCount, 0, indexStats);
        verifyRestoredData(indicesStats.get(indices[0]), indices[0]);
            indicesStats.put(index, indexStats);
import org.opensearch.indices.IndicesService;
        assertBusy(
        for (String index : indices) {
 * this file be licensed under the Apache-2.0 license or a
     * @throws IOException IO Exception.  
     * with all remote-enabled red indices being considered for the restore
     * @throws IOException IO Exception.
        // ensure replica has latest checkpoint  
    public void testRemoteTranslogRestoreWithRefreshedData() throws Exception {  
        assertEquals(shardCount, getNumShards(INDEX_NAME).totalNumShards);  
        indicesService = internalCluster().getInstance(IndicesService.class, newPrimaryNodeName);
            }
    public void testRemoteTranslogRestoreWithNoDataPostCommit() throws Exception {
     */
        settings.put("location", segmentRepoPath).put("max_remote_download_bytes_per_sec", 4, ByteSizeUnit.KB);
        restore(INDEX_NAME);
        verifyRestoredData(indexStats, INDEX_NAME);
                internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNodeName(index)));  
     * @throws IOException IO Exception.
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        // validate inplace repository metadata update
            REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,  
        for (String index : indices) {
        }  
            if (ClusterHealthStatus.GREEN.equals(ensureRed(index))) {
        String settingsAttributeKeyPrefix = String.format(
            0,
        Map<String, Map<String, Long>> indicesStats = new HashMap<>();  
        testRestoreFlow(randomIntBetween(2, 5), false, false, randomIntBetween(1, 5));
import org.opensearch.test.InternalTestCluster;  
        }
        );
        for (String index : indices) {  
        assertEquals(shardCount * (replicaCount + 1), getNumShards(indices[0]).totalNumShards);
import java.util.stream.Collectors;
        indexData(randomIntBetween(2, 5), true, INDEX_NAME);
import java.nio.file.Path;
        Map<String, Map<String, Long>> indicesStats = new HashMap<>();
        ensureRed(indices);
import org.opensearch.repositories.Repository;
import static org.hamcrest.Matchers.greaterThan;
     * Simulates refreshed data restored using Remote Segment Store
 *
import java.util.HashMap;  
        verifyRestoredData(indicesStats.get(indices[1]), indices[1]);  
}  
     * @throws IOException IO Exception.
            .cluster()
    }
                new RestoreRemoteStoreRequest().indices(indices[0], indices[1]).restoreAllShards(restoreAllShards),
    /**
    /**
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(index)));
        internalCluster().startDataOnlyNodes(3);  
     */  
 * The OpenSearch Contributors require contributions made to  
    /**
            Map<String, Long> indexStats = indexData(2, true, index);  
     * Simulates refreshed data restored using Remote Segment Store
            assertEquals(shardCount * 2, getNumShards(index).totalNumShards);
            3,  
        ensureGreen(indices[0], indices[1]);  
    }
        verifyRestoredData(indexStats, INDEX_NAME);
    public void testRTSRestoreWithCommittedDataPrimaryReplicaDown() throws Exception {
        IndexShard finalIndexShard = indexShard;
        throws Exception {
        clusterSettingsSuppliedByTest = true;  
import org.opensearch.core.common.unit.ByteSizeUnit;  
        for (String index : indices) {
     * when the index has no data.
     */
    }
     * and unrefreshed data restored using Remote Translog Store.
        createRepository(REPOSITORY_NAME, ReloadableFsRepository.TYPE, settings);
import org.opensearch.common.settings.Settings;
        boolean restoreAllShards = randomBoolean();
        // This is required to get updated number from already active shards which were not restored
        ensureGreen(indices);  
            .keySet()
import org.opensearch.index.shard.IndexShard;  
        for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));
        internalCluster().startDataOnlyNodes(3);
        prepareCluster(1, 3, INDEX_NAMES, replicaCount, shardCount);  
        ensureRed(INDEX_NAME);  
            30,  
        String newPrimaryNodeName = replicaNodeName(INDEX_NAME);
            );
    }  
    /**
        assertEquals(
    /**  
import org.opensearch.core.index.Index;
        Map<String, Long> indexStats = indexData(numberOfIterations, invokeFlush, emptyTranslog, INDEX_NAME);
/*  
     * for multiple indices matching a wildcard name pattern.
        Map<String, Map<String, Long>> indicesStats = new HashMap<>();
            .restoreRemoteStore(
import org.opensearch.common.unit.TimeValue;
        for (String index : indices) {  
        assertEquals(shardCount * 2, getNumShards(INDEX_NAME).totalNumShards);
    }
    }
     * Helper function to test restoring an index with no replication from remote store. Only primary node is dropped.
    /**  
            }  
     */  
        }
            assertNull(segmentRepo.getMetadata().settings().get("max_remote_download_bytes_per_sec"));
     * and unrefreshed data restored using Remote Translog Store.  
        assertEquals(shardCount * (replicaCount + 1), getNumShards(indices[1]).totalNumShards);  
            INDEX_NAME,
        internalCluster().startDataOnlyNodes(3);  
     * @throws IOException IO Exception.  
    public void testRemoteTranslogRestoreWithCommittedData() throws Exception {  
            .restoreRemoteStore(
        restore(INDEX_NAME);
import java.util.Locale;
        assertEquals(shardCount, getNumShards(INDEX_NAME).totalNumShards);
        }
        assertEquals(shardCount, getNumShards(INDEX_NAME).totalNumShards);  
            assertAcked(client().admin().indices().prepareClose(indices[0], indices[1]));  
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 5), true, INDEX_NAME);
        testRestoreFlow(1, false, true, randomIntBetween(1, 5));
     * @throws IOException IO Exception.  
        assertEquals(0, getNumShards(INDEX_NAME).numReplicas);
            if (ClusterHealthStatus.GREEN.equals(indexHealth)) {
     * and unrefreshed data restored using Remote Translog Store,
     */  
    }
            Map<String, Long> indexStats = indexData(numberOfIterations, invokeFlush, index);
     * @throws IOException IO Exception.
    private void testRestoreFlowMultipleIndices(int numberOfIterations, boolean invokeFlush, int shardCount) throws Exception {  
            Map<String, Long> indexStats = indexData(2, true, index);
        }
import java.util.Map;
                continue;
import org.opensearch.repositories.RepositoriesService;  
     */
        for (String index : indices) {  
        // Waiting for extended period for green state so that rate limit does not cause flakiness  
            assertEquals(shardCount * (replicaCount + 1), getNumShards(index).totalNumShards);
     */
     * Simulates refreshed data restored using Remote Segment Store
            assertAcked(client().admin().indices().prepareClose(indices));
    }  
        for (String index : indices) {
     */
    public void testRTSRestoreWithCommittedDataExcludeIndicesPatterns() throws Exception {
            }
     * @param invokeFlush If true, a flush is invoked. Otherwise, a refresh is invoked.
    }
        DiscoveryNode node = clusterService.localNode();  
            }  
    /**  
    }
     */
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(index)));  
        for (String index : indices) {
            if (ClusterHealthStatus.RED.equals(ensureRed(index))) {  
            );
    /**
        verifyRestoredData(indexStats, INDEX_NAME);  
            1,
import org.opensearch.cluster.service.ClusterService;  
 * compatible open source license.
        Map<String, String> settingsMap = node.getAttributes()  
import org.opensearch.index.IndexService;
    }
import java.util.concurrent.TimeUnit;
        Index indexObj = clusterService().state().metadata().indices().get(INDEX_NAME).getIndex();
        assertEquals(shardCount, getNumShards(INDEX_NAME).totalNumShards);
            Repository segmentRepo = repositoriesService.repository(REPOSITORY_NAME);  
     * Simulates refreshed data restored using Remote Segment Store
        IndexService indexService = indicesService.indexService(indexObj);  
     * @param invokeFlush If true, a flush is invoked. Otherwise, a refresh is invoked.  
            }  
import org.opensearch.test.junit.annotations.TestIssueLogging;
     */
    }
            }  
        if (restoreAllShards) {
     */
                continue;
    }  
        ensureGreen(INDEX_NAME);  
     * Helper function to test restoring multiple indices from remote store when all the nodes housing the primary/replica drop.
     * and unrefreshed data restored using Remote Translog Store,  
            ),  
        }
        internalCluster().startDataOnlyNodes(3);
        int replicaCount = 1;
    /**
        // ensure all segments synced to replica
     * and unrefreshed data restored using Remote Translog Store
            assertTrue(e.getCause() instanceof IllegalStateException || e.getCause().getCause() instanceof IllegalStateException);
    }
    public void testRTSRestoreWithCommittedDataDefaultAllIndices() throws Exception {  
        // https://github.com/opensearch-project/OpenSearch/pull/9569#discussion_r1345668700
            TimeUnit.SECONDS
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
            TimeUnit.SECONDS
            .filter(key -> key.startsWith(settingsAttributeKeyPrefix))  
            for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
        verifyRestoredData(indicesStats.get(indices[1]), indices[1]);
            REPOSITORY_NAME
        client().admin()  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, primaryNodeName(INDEX_NAME));
import java.io.IOException;
            () -> assertHitCount(
    }
    @TestIssueLogging(value = "_root:TRACE", issueUrl = "https://github.com/opensearch-project/OpenSearch/issues/11085")
     * @param numberOfIterations Number of times a refresh/flush should be invoked, followed by indexing some data.  
        boolean restoreAllShards = randomBoolean();
        for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
     */  
    public void testRTSRestoreDataOnlyInTranslog() throws Exception {
        int shardCount = randomIntBetween(1, 5);  
        int shardCount = randomIntBetween(1, 5);
    }  
            finalIndexShard.getLatestSegmentInfosAndCheckpoint().v2().getPrimaryTerm(),
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(false), PlainActionFuture.newFuture());
        assertBusy(() -> assertTrue(finalIndexShard.isStartedPrimary() && finalIndexShard.isPrimaryMode()));  
    private void testRestoreFlowBothPrimaryReplicasDown(int numberOfIterations, boolean invokeFlush, boolean emptyTranslog, int shardCount)
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(index)));
        indexService = indicesService.indexService(indexObj);  
        testRestoreFlowMultipleIndices(2, true, randomIntBetween(1, 5));  
    /**
    /**  
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(REFRESHED_OR_FLUSHED_OPERATIONS));
    }  
        int shardCount = randomIntBetween(1, 5);  
            assertEquals(shardCount * (replicaCount + 1), getNumShards(index).totalNumShards);  
     * @throws IOException IO Exception.
        assertEquals(shardCount, getNumShards(INDEX_NAME).totalNumShards);  
        prepareCluster(1, 3, INDEX_NAMES, 1, shardCount);
        );
            indicesStats.put(index, indexStats);
    private void restoreAndVerify(int shardCount, int replicaCount, Map<String, Long> indexStats) throws Exception {  
     * and unrefreshed data restored using Remote Translog Store,
            future.get();
                continue;
        );
        ensureRed(indices[2], indices[3]);
     * @throws IOException IO Exception.
     * @throws IOException IO Exception.  
        }  
     * Simulates all data restored using Remote Translog Store.
     * Simulates no-op restore from remote store,  
     * @throws IOException IO Exception.
    }  
        ensureGreen(indices);
    public void testRestoreFlowNoRedIndex() throws Exception {
            assertEquals(shardCount * 2, getNumShards(index).totalNumShards);
        Path segmentRepoPath = randomRepoPath();
        prepareCluster(1, 3, INDEX_NAMES, 0, shardCount);
     * Simulates all data restored using Remote Translog Store.  
        assertEquals(shardCount * (1 + replicaCount), getNumShards(INDEX_NAME).totalNumShards);
        try {  
        ensureRed(indices[2], indices[3]);
                internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNodeName(index)));
        }
        Map<String, Map<String, Long>> indicesStats = new HashMap<>();
import java.util.concurrent.ExecutionException;  
            30,
    /**
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
            verifyRestoredData(indicesStats.get(index), index);  
            }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        ensureRed(indices);
        }  
        verifyRestoredData(indicesStats.get(indices[0]), indices[0]);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));
                indexStats.get(TOTAL_OPERATIONS)
    // TODO: Restore flow - index aliases
     * Simulates refreshed data restored using Remote Segment Store
        Path tlogRepoPath = randomRepoPath();  
     * @throws IOException IO Exception.
     */
        ensureGreen(TimeValue.timeValueSeconds(120), INDEX_NAME);
import org.opensearch.action.support.PlainActionFuture;  
            shardCount,  
    }
    /**  
            indicesStats.put(index, indexStats);  
        if (restoreAllShards) {  
        prepareCluster(
            remoteSegmentMetadataBeforeFailover.getPrimaryTerm() + 1  
    public void testRTSRestoreWithRefreshedDataPrimaryReplicaDown() throws Exception {
        Map<String, Long> indexStats = indexData(5, false, INDEX_NAME);  
        }
    }
        }
        // revert repo metadata to pass asserts on repo metadata vs. node attrs during teardown
            .cluster()  
            assertEquals("4096b", segmentRepo.getMetadata().settings().get("max_remote_download_bytes_per_sec"));  
     * and unrefreshed data restored using Remote Translog Store.  
        client().admin().cluster().restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), future);
 */  
        assertBusy(() -> {
     * Simulates all data restored using Remote Translog Store.
            ClusterHealthStatus indexHealth = ensureRed(index);
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
     * except those matching the specified exclusion pattern.
        for (String index : indices) {
        assertBusy(
        Map<String, Long> indexStats = indexData(numberOfIterations, invokeFlush, emptyTranslog, INDEX_NAME);
        String[] indices = INDEX_NAMES.split(",");
        client().admin()
        int shardCount = randomIntBetween(1, 3);
    /**  
        assertEquals(replicaCount, getNumShards(INDEX_NAME).numReplicas);
            }
import org.opensearch.cluster.health.ClusterHealthStatus;
        }
    }
        settingsMap.entrySet().forEach(entry -> settings.put(entry.getKey(), entry.getValue()));  
        for (String index : indices) {
        settings.remove("max_remote_download_bytes_per_sec");  
    public void testRTSRestoreWithNoDataPostRefreshPrimaryReplicaDown() throws Exception {
     * Simulates refreshed data restored using Remote Segment Store  
    private void testRestoreFlow(int numberOfIterations, boolean invokeFlush, boolean emptyTranslog, int shardCount) throws Exception {  
        internalCluster().startDataOnlyNodes(2);
        String[] indices = INDEX_NAMES.split(",");
     * Simulates all data restored using Remote Translog Store.
     */
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));
     */
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 5), true, true, INDEX_NAME);  
    public void testRemoteTranslogRestoreWithNoDataPostRefresh() throws Exception {  
                client(primaryNodeName(INDEX_NAME)).prepareSearch(INDEX_NAME).setSize(0).get(),
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
    /**  
        ensureGreen(indices[0], indices[1]);
    public void testRateLimitedRemoteDownloads() throws Exception {
        assertEquals(2, getNumShards(INDEX_NAME).totalNumShards);
                indexStats.get(TOTAL_OPERATIONS)
                PlainActionFuture.newFuture()  
        restoreAndVerify(shardCount, 1, indexStats);  
            assertThat(downloadPauseTime, greaterThan(TimeValue.timeValueSeconds(randomIntBetween(3, 5)).nanos()));
     * with only some of the remote-enabled red indices requested for the restore.  
import org.opensearch.test.OpenSearchIntegTestCase;
            assertAcked(client().admin().indices().prepareClose(indices[0], indices[1]));
        ensureRed(indices);
     * with all remote-enabled red indices considered for the restore by default.  
public class RemoteStoreRestoreIT extends BaseRemoteStoreRestoreIT {
            );
