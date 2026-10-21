            indicesStats.put(index, indexStats);
     * and unrefreshed data restored using Remote Translog Store
        Map<String, Map<String, Long>> indicesStats = new HashMap<>();
                PlainActionFuture.newFuture()
    }
            .restoreRemoteStore(
     * @param invokeFlush If true, a flush is invoked. Otherwise, a refresh is invoked.
        client().admin()
                internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNodeName(index)));
     * @param numberOfIterations Number of times a refresh/flush should be invoked, followed by indexing some data.
        // Waiting for extended period for green state so that rate limit does not cause flakiness
        DiscoveryNode node = clusterService.localNode();
    }
            Map<String, Long> indexStats = indexData(numberOfIterations, invokeFlush, index);
     * @throws IOException IO Exception.
                new RestoreRemoteStoreRequest().indices("*", "-remote-store-test-index-*").restoreAllShards(restoreAllShards),
            .keySet()
        verifyRestoredData(indicesStats.get(indices[1]), indices[1]);
        testRestoreFlow(1, true, true, randomIntBetween(1, 5));
        testRestoreFlowMultipleIndices(2, true, randomIntBetween(1, 5));
     */
    /**
     * and unrefreshed data restored using Remote Translog Store.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        verifyRestoredData(indexStats, INDEX_NAME);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));
        }
            }
        assertEquals(
     */
    }
            REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        prepareCluster(1, 2, INDEX_NAME, 1, shardCount);
        clusterSettingsSuppliedByTest = true;
            }
            Map<String, Long> indexStats = indexData(2, true, index);
     * Simulates refreshed data restored using Remote Segment Store
     * @throws IOException IO Exception.
import org.opensearch.common.unit.TimeValue;
    }
        prepareCluster(1, 3, INDEX_NAMES, 1, shardCount);
        ensureYellow(INDEX_NAME);
    public void testRTSRestoreWithCommittedDataNotAllRedRemoteIndices() throws Exception {
        assertEquals(shardCount, getNumShards(INDEX_NAME).totalNumShards);
        IndexShard finalIndexShard = indexShard;
     */
        ensureGreen(indices[0], indices[1]);
            assertEquals(shardCount * (replicaCount + 1), getNumShards(index).totalNumShards);
        internalCluster().startDataOnlyNodes(3);
    public void testRemoteTranslogRestoreWithNoDataPostCommit() throws Exception {
        assertEquals(shardCount * (replicaCount + 1), getNumShards(indices[1]).totalNumShards);
package org.opensearch.remotestore;
    public void testRemoteTranslogRestoreWithRefreshedData() throws Exception {
            future.get();
     * with all remote-enabled red indices being considered for the restore
        assertEquals(shardCount, getNumShards(INDEX_NAME).totalNumShards);
    @TestIssueLogging(value = "_root:TRACE", issueUrl = "https://github.com/opensearch-project/OpenSearch/issues/11085")
        assertEquals(shardCount, getNumShards(INDEX_NAME).totalNumShards);
        }
        assertEquals(shardCount * 2, getNumShards(INDEX_NAME).totalNumShards);
                indexStats.get(TOTAL_OPERATIONS)
    }
     * Simulates all data restored using Remote Translog Store.
    /**
    /**
 * The OpenSearch Contributors require contributions made to
                downloadPauseTime += repositoriesService.repository(REPOSITORY_NAME).getRemoteDownloadThrottleTimeInNanos();
import org.opensearch.cluster.health.ClusterHealthStatus;
     * @throws IOException IO Exception.
        prepareCluster(1, 3, INDEX_NAME, 0, shardCount);
            assertEquals(shardCount * (replicaCount + 1), getNumShards(index).totalNumShards);
                indexStats.get(TOTAL_OPERATIONS)
        assertEquals(replicaCount, getNumShards(INDEX_NAME).numReplicas);
        testRestoreFlow(randomIntBetween(2, 5), false, false, randomIntBetween(1, 5));
     * @throws IOException IO Exception.
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(index)));
     * with all remote-enabled red indices considered for the restore by default.
        }
            assertEquals(shardCount * (replicaCount + 1), getNumShards(index).totalNumShards);
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class);
    /**
        createRepository(REPOSITORY_NAME, ReloadableFsRepository.TYPE, settings);
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(index)));
    // TODO: Restore flow - index aliases
                continue;
        restoreAndVerify(shardCount, 0, indexStats);
        ensureRed(indices);
        // This is required to get updated number from already active shards which were not restored
     * Simulates no-op restore from remote store,
            ),
        assertEquals(shardCount, getNumShards(indices[1]).totalNumShards);
        if (restoreAllShards) {
                continue;
    /**
        ensureRed(indices);
        restoreAndVerify(shardCount, 1, indexStats);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
     * Simulates refreshed data restored using Remote Segment Store
import org.opensearch.indices.IndicesService;
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(index)));
        }
                internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNodeName(index)));
        // ensure all segments synced to replica
                client(primaryNodeName(INDEX_NAME)).prepareSearch(INDEX_NAME).setSize(0).get(),
     */
        for (String index : indices) {
}
    /**
    }
        client().admin().cluster().restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), future);
            Map<String, Long> indexStats = indexData(2, true, index);
        prepareCluster(1, 3, INDEX_NAMES, replicaCount, shardCount);
            assertThat(downloadPauseTime, greaterThan(TimeValue.timeValueSeconds(randomIntBetween(3, 5)).nanos()));
        indicesService = internalCluster().getInstance(IndicesService.class, newPrimaryNodeName);
        );
        );
     */
     */
     * @throws IOException IO Exception.
        testRestoreFlow(randomIntBetween(2, 5), true, false, randomIntBetween(1, 5));
 *
     * @throws IOException IO Exception.
        indexData(randomIntBetween(2, 5), true, INDEX_NAME);
import org.opensearch.repositories.RepositoriesService;
 * SPDX-License-Identifier: Apache-2.0
     * @throws IOException IO Exception.
     * Simulates refreshed data restored using Remote Segment Store
    }
            Map<String, Long> indexStats = indexData(2, true, index);
    public void testRTSRestoreWithRefreshedDataPrimaryReplicaDown() throws Exception {
    }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNodeName(INDEX_NAME)));
        internalCluster().startDataOnlyNodes(3);
     */
     * Simulates all data restored using Remote Translog Store.
            () -> assertHitCount(
            long downloadPauseTime = 0L;
     * @param numberOfIterations Number of times a refresh/flush should be invoked, followed by indexing some data.
        prepareCluster(1, 3, INDEX_NAME, 0, shardCount);
        assertBusy(() -> {
            assertNull(segmentRepo.getMetadata().settings().get("max_remote_download_bytes_per_sec"));
            .collect(Collectors.toMap(key -> key.replace(settingsAttributeKeyPrefix, ""), key -> node.getAttributes().get(key)));
     * Helper function to test restoring an index with no replication from remote store. Only primary node is dropped.
            assertEquals(shardCount * 2, getNumShards(index).totalNumShards);
        ensureRed(INDEX_NAME);
public class RemoteStoreRestoreIT extends BaseRemoteStoreRestoreIT {
        prepareCluster(1, 3, INDEX_NAME, 0, shardCount);
        Map<String, Long> indexStats = indexData(numberOfIterations, invokeFlush, emptyTranslog, INDEX_NAME);
            if (ClusterHealthStatus.RED.equals(ensureRed(index))) {
            }
                continue;
        String[] indices = INDEX_NAMES.split(",");
        }
    public void testRTSRestoreWithCommittedDataExcludeIndicesPatterns() throws Exception {
        assertBusy(() -> assertTrue(finalIndexShard.isStartedPrimary() && finalIndexShard.isPrimaryMode()));
     */
        Settings.Builder settings = Settings.builder();
        // This is required to get updated number from already active shards which were not restored
import org.opensearch.cluster.service.ClusterService;
        }
        client().admin()
    /**
        prepareCluster(
                new RestoreRemoteStoreRequest().indices(INDEX_NAMES_WILDCARD.split(",")).restoreAllShards(restoreAllShards),
import org.opensearch.common.settings.Settings;
            3,
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 5), true, true, INDEX_NAME);
        // https://github.com/opensearch-project/OpenSearch/pull/9569#discussion_r1345668700
        Map<String, Long> indexStats = indexData(5, false, INDEX_NAME);
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(false), PlainActionFuture.newFuture());
        prepareCluster(1, 2, INDEX_NAME, 1, 1);
            assertAcked(client().admin().indices().prepareClose(indices[0], indices[1]));
            REPOSITORY_NAME
    private void restoreAndVerify(int shardCount, int replicaCount, Map<String, Long> indexStats) throws Exception {
        RemoteSegmentMetadata remoteSegmentMetadataBeforeFailover = indexShard.getRemoteDirectory().readLatestMetadataFile();
            INDEX_NAME,
        assertBusy(
            indicesStats.put(index, indexStats);
     */
    }
     * Simulates refreshed data restored using Remote Segment Store
        }
     * for multiple indices matching a wildcard name pattern.
        if (restoreAllShards) {
    public void testRemoteTranslogRestoreWithNoDataPostRefresh() throws Exception {
            Repository segmentRepo = repositoriesService.repository(REPOSITORY_NAME);
        }, 30, TimeUnit.SECONDS);
        ensureRed(indices[2], indices[3]);
    }
        internalCluster().startDataOnlyNodes(3);
        }
            }
        flushAndRefresh(INDEX_NAME);
        }
                continue;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
     * @throws IOException IO Exception.
        }
import java.io.IOException;
        ensureGreen(indices);
            }
        settings.put("location", segmentRepoPath).put("max_remote_download_bytes_per_sec", 4, ByteSizeUnit.KB);
     * and unrefreshed data restored using Remote Translog Store,
        Path tlogRepoPath = randomRepoPath();
    }
        int shardCount = randomIntBetween(1, 5);
        String settingsAttributeKeyPrefix = String.format(
     */
 * this file be licensed under the Apache-2.0 license or a
     */
        internalCluster().startDataOnlyNodes(3);
        String newPrimaryNodeName = replicaNodeName(INDEX_NAME);
        ensureGreen(INDEX_NAME);
            TimeUnit.SECONDS
    public void testRTSRestoreWithNoDataPostCommitPrimaryReplicaDown() throws Exception {
            Repository segmentRepo = repositoriesService.repository(REPOSITORY_NAME);
        ensureRed(INDEX_NAME);
            // If the request goes to co-ordinator, e.getCause() can be RemoteTransportException
     */
        settings.remove("max_remote_download_bytes_per_sec");
import java.util.concurrent.ExecutionException;
    }
        Index indexObj = clusterService().state().metadata().indices().get(INDEX_NAME).getIndex();
    /**
        Map<String, String> settingsMap = node.getAttributes()
     * @param numberOfIterations Number of times a refresh/flush should be invoked, followed by indexing some data.
        verifyRestoredData(indicesStats.get(indices[1]), indices[1]);
        ensureRed(INDEX_NAME);
        for (String index : indices) {
    public void testRestoreFlowAllShardsNoRedIndex() throws InterruptedException {
        // validate inplace repository metadata update
     * @throws IOException IO Exception.
                internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNodeName(index)));
        for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
    public void testMultipleWriters() throws Exception {
import org.opensearch.core.common.unit.ByteSizeUnit;
    }
        boolean restoreAllShards = randomBoolean();
     * and unrefreshed data restored using Remote Translog Store.
    }
        verifyRestoredData(indicesStats.get(indices[0]), indices[0]);
        for (String index : indices) {
            }
     * Simulates refreshed data restored using Remote Segment Store
                PlainActionFuture.newFuture()
     * @throws IOException IO Exception.
import org.opensearch.index.shard.IndexShard;
    /**
        boolean restoreAllShards = randomBoolean();
    public void testRTSRestoreDataOnlyInTranslog() throws Exception {
    /**
        assertEquals(shardCount, getNumShards(indices[0]).totalNumShards);
        Map<String, Map<String, Long>> indicesStats = new HashMap<>();
     * @param invokeFlush If true, a flush is invoked. Otherwise, a refresh is invoked.
            );
        }
import org.opensearch.test.OpenSearchIntegTestCase;
     * Simulates refreshed data restored using Remote Segment Store
    }
            .cluster()
        PlainActionFuture<RestoreRemoteStoreResponse> future = PlainActionFuture.newFuture();
    public void testRemoteTranslogRestoreWithCommittedData() throws Exception {
        if (restoreAllShards) {
        int replicaCount = 1;
    private void testRestoreFlowMultipleIndices(int numberOfIterations, boolean invokeFlush, int shardCount) throws Exception {
        assertBusy(
        assertEquals(0, getNumShards(INDEX_NAME).numReplicas);
     * and unrefreshed data restored using Remote Translog Store,
            if (ClusterHealthStatus.RED.equals(ensureRed(index))) {
     */
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 5), true, INDEX_NAME);
            finalIndexShard.getLatestSegmentInfosAndCheckpoint().v2().getPrimaryTerm(),
        ensureGreen(indices[0], indices[1]);
     * Simulates all data restored using Remote Translog Store.
    private void testRestoreFlowBothPrimaryReplicasDown(int numberOfIterations, boolean invokeFlush, boolean emptyTranslog, int shardCount)
    /**
        int shardCount = randomIntBetween(1, 5);
     * @throws IOException IO Exception.
     * Simulates all data restored using Remote Translog Store.
     */
import org.opensearch.test.InternalTestCluster;
     */
import static org.hamcrest.Matchers.greaterThan;
    }
            () -> assertHitCount(
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));
        }
     * Helper function to test restoring multiple indices from remote store when all the nodes housing the primary/replica drop.
                new RestoreRemoteStoreRequest().indices(indices[0], indices[1]).restoreAllShards(restoreAllShards),
        testRestoreFlow(1, false, true, randomIntBetween(1, 5));
 * compatible open source license.
        Path segmentRepoPath = randomRepoPath();
                PlainActionFuture.newFuture()
     * Simulates refreshed data restored using Remote Segment Store
    public void testRTSRestoreWithCommittedDataMultipleIndicesPatterns() throws Exception {
        String[] indices = INDEX_NAMES.split(",");
    public void testRestoreFlowNoRedIndex() throws Exception {
            if (ClusterHealthStatus.RED.equals(indexHealth)) {
import java.util.stream.Collectors;
        restore(indices);
        for (String index : indices) {
        assertEquals(shardCount, getNumShards(INDEX_NAME).totalNumShards);
    }
import org.opensearch.action.support.PlainActionFuture;
    public void testRTSRestoreWithCommittedDataDefaultAllIndices() throws Exception {
            buildRemoteStoreNodeAttributes(REPOSITORY_NAME, segmentRepoPath, REPOSITORY_2_NAME, tlogRepoPath, true)
 */
            if (ClusterHealthStatus.GREEN.equals(ensureRed(index))) {
        // ensure replica has latest checkpoint
    /**
            if (ClusterHealthStatus.GREEN.equals(indexHealth)) {
        int shardCount = randomIntBetween(1, 3);
        testRestoreFlowBothPrimaryReplicasDown(1, true, true, randomIntBetween(1, 5));
        assertEquals(shardCount, getNumShards(INDEX_NAME).totalNumShards);
        verifyRestoredData(indexStats, INDEX_NAME);
import org.opensearch.core.index.Index;
        ensureRed(indices);
        assertEquals(shardCount * (replicaCount + 1), getNumShards(indices[0]).totalNumShards);
    /**
        testRestoreFlow(0, true, false, randomIntBetween(1, 5));
        boolean restoreAllShards = randomBoolean();
     * @param invokeFlush If true, a flush is invoked. Otherwise, a refresh is invoked.
        String[] indices = INDEX_NAMES.split(",");
        ensureGreen(indices);
        );
    private void testRestoreFlow(int numberOfIterations, boolean invokeFlush, boolean emptyTranslog, int shardCount) throws Exception {
        prepareCluster(1, 3, INDEX_NAMES, 0, shardCount);
        int shardCount = randomIntBetween(1, 5);
    public void testRTSRestoreWithCommittedDataPrimaryReplicaDown() throws Exception {
            assertAcked(client().admin().indices().prepareClose(indices[0], indices[1]));
        } catch (ExecutionException e) {
            .cluster()
            30,
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreResponse;
        indexService = indicesService.indexService(indexObj);
            assertEquals("4096b", segmentRepo.getMetadata().settings().get("max_remote_download_bytes_per_sec"));
        }
            ClusterHealthStatus indexHealth = ensureRed(index);
        flushAndRefresh(INDEX_NAME);
     * and unrefreshed data restored using Remote Translog Store,
        int replicaCount = 1;
            }
        for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
     * Simulates refreshed data restored using Remote Segment Store
import org.opensearch.index.IndexService;
        ensureRed(indices);
        prepareCluster(1, 3, INDEX_NAMES, replicaCount, shardCount);
    }
     * and unrefreshed data restored using Remote Translog Store.
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
        );
        createRepository(REPOSITORY_NAME, ReloadableFsRepository.TYPE, settings);
            shardCount,
            assertTrue(e.getCause() instanceof IllegalStateException || e.getCause().getCause() instanceof IllegalStateException);
        for (String index : indices) {
            }
        Map<String, Map<String, Long>> indicesStats = new HashMap<>();
import org.opensearch.repositories.Repository;
        indexShard = indexService.getShard(0);
     * @throws IOException IO Exception.
            indicesStats.put(index, indexStats);
import java.nio.file.Path;
        testRestoreFlowBothPrimaryReplicasDown(randomIntBetween(2, 5), false, false, randomIntBetween(1, 5));
            );
    /**
            if (ClusterHealthStatus.GREEN.equals(ensureRed(index))) {
            Locale.getDefault(),
        throws Exception {
        testRestoreFlowBothPrimaryReplicasDown(randomIntBetween(2, 5), true, false, randomIntBetween(1, 5));
        restore(INDEX_NAME);
import org.opensearch.test.junit.annotations.TestIssueLogging;
        ensureRed(indices[2], indices[3]);
            assertEquals(shardCount * 2, getNumShards(index).totalNumShards);
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
    /**
     * when the index has no data.
            remoteSegmentMetadataBeforeFailover.getPrimaryTerm() + 1
        for (String index : indices) {
    /**
    }
import java.util.Map;
            .restoreRemoteStore(
        assertEquals(shardCount * (1 + replicaCount), getNumShards(INDEX_NAME).totalNumShards);
        String[] indices = INDEX_NAMES.split(",");
            TimeUnit.SECONDS
            indicesStats.put(index, indexStats);
        Map<String, Map<String, Long>> indicesStats = new HashMap<>();
import org.opensearch.cluster.node.DiscoveryNode;
            verifyRestoredData(indicesStats.get(index), index);
            .filter(key -> key.startsWith(settingsAttributeKeyPrefix))
        testRestoreFlowBothPrimaryReplicasDown(1, false, true, randomIntBetween(1, 5));
    }
        }
import java.util.Locale;
        verifyRestoredData(indicesStats.get(indices[0]), indices[0]);
        assertEquals(2, getNumShards(INDEX_NAME).totalNumShards);
     * except those matching the specified exclusion pattern.
     * @throws IOException IO Exception.
        for (String index : indices) {
        try {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
        );
        ensureGreen(INDEX_NAME);
        internalCluster().startDataOnlyNodes(2);
            .cluster()
     * with only some of the remote-enabled red indices requested for the restore.
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));
import org.opensearch.repositories.fs.ReloadableFsRepository;
        int shardCount = randomIntBetween(1, 5);
            verifyRestoredData(indicesStats.get(index), index);
        verifyRestoredData(indexStats, INDEX_NAME);
            );
        }
        IndexShard indexShard = indexService.getShard(0);
            .cluster()
        client().admin()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(index)));
        Map<String, Long> indexStats = indexData(numberOfIterations, invokeFlush, emptyTranslog, INDEX_NAME);
            assertAcked(client().admin().indices().prepareClose(indices));
        }
            assertEquals(shardCount, getNumShards(index).totalNumShards);
            if (ClusterHealthStatus.RED.equals(ensureRed(index))) {
        for (String index : indices) {
    public void testRTSRestoreWithNoDataPostRefreshPrimaryReplicaDown() throws Exception {
     * and unrefreshed data restored using Remote Translog Store.
        for (String index : indices) {
        restore(INDEX_NAME);
import java.util.HashMap;
/*
    public void testRateLimitedRemoteDownloads() throws Exception {
        // revert repo metadata to pass asserts on repo metadata vs. node attrs during teardown
        for (String index : indices) {
            0,
     * @throws IOException IO Exception.
                client(replicaNodeName(INDEX_NAME)).prepareSearch(INDEX_NAME).setSize(0).get(),
     * Helper function to test restoring an index having replicas from remote store when all the nodes housing the primary/replica drop.
     */
     * @throws IOException IO Exception.
            .restoreRemoteStore(
            ),
    }
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, primaryNodeName(INDEX_NAME));
     * @throws IOException IO Exception.
        ensureGreen(TimeValue.timeValueSeconds(120), INDEX_NAME);
        int shardCount = randomIntBetween(1, 5);
        assertEquals(shardCount, getNumShards(INDEX_NAME).totalNumShards);
        IndexService indexService = indicesService.indexService(indexObj);
        client().admin()
            .stream()
            1,
            30,
import java.util.concurrent.TimeUnit;
        settingsMap.entrySet().forEach(entry -> settings.put(entry.getKey(), entry.getValue()));
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(REFRESHED_OR_FLUSHED_OPERATIONS));
