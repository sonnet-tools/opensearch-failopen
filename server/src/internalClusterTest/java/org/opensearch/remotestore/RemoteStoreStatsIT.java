                    } else {
            assertNonZeroTranslogUploadStatsNoFailures(translogStats);
        while (currentTimeNs == System.nanoTime()) {
        ensureGreen(INDEX_NAME);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, stats.totalDownloadTimeInMillis);
        for (int i = 1; i <= randomIntBetween(5, 10); i++) {
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 1));
            RemoteSegmentTransferTracker.Stats primaryStats = Arrays.stream(zeroStateResponse.getRemoteStoreStats())
                flush(INDEX_NAME);
                } else {
                r -> (r.currentNodeId().equals(routing.currentNodeId())
            RemoteSegmentTransferTracker.Stats segmentStats = matches.get(0).getSegmentStats();
            assertTrue(response.getSuccessfulShards() > 0);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .collect(Collectors.toList());
 *
                assertNonZeroTranslogUploadStatsNoFailures(translogStats);
        assertTrue(stats.totalUploadsSucceeded > 0);
                        .get().uploadBytesSucceeded >= replicaStats.directoryFileTransferTrackerStats.transferredBytesSucceeded
import java.util.Arrays;
                .get()
        // - Assert that remote store stats reflects the new node ID
import org.opensearch.index.IndexSettings;
                .filter(stat -> indexShardId.equals(stat.getSegmentStats().shardId.toString()))
}
            zeroStateReplicaStats.forEach(stats -> {
        // Step 2 - We find all the nodes that are present in the cluster. We make the remote store stats api call from
        // Assert that remote store stats reflect the new shard state
            RemoteStoreStatsResponse response = remoteStoreStatsRequestBuilder.get();
        createIndex(INDEX_NAME, remoteStoreIndexSettings(2, 1));
        refresh(INDEX_NAME);
            flushAndRefresh(INDEX_NAME);
            assertEquals(1, response.getSuccessfulShards());
        // Start network disruption - primary node will be isolated
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
        ensureStableCluster(nodeCount - 1);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, dataNodeCount));
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, numOfShards));
                .cluster()
                RemoteStoreStatsResponse response = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get();
                RemoteTranslogTransferTracker.Stats translogStats = stat.getTranslogStats();
        // Index some docs and refresh
                            && segmentStats.directoryFileTransferTrackerStats.transferredBytesSucceeded == 0
        );
                    assertEquals(0, segmentStats.totalUploadsStarted);
                .getRemoteStoreStats();
                List<Long> downloadBytesStarted = new ArrayList<>();
                assertTrue(
                .get();
        // Get number of data nodes
    }
                validateShardRouting(routing);
    }
                // Collect stats for primary and replica shards
    private void validateSegmentUploadStats(RemoteSegmentTransferTracker.Stats stats) {
            waitForReplication();
        createIndex(INDEX_NAME, additionalSettings.build());
        // Scenario:
            indexSingleDoc(INDEX_NAME);
        RemoteStoreStatsResponse response = remoteStoreStatsRequestBuilder.get();
        // TODO: Need to simulate a delay for this assertion to avoid flakiness
        refresh(INDEX_NAME);
            validateShardRouting(routing);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    assertEquals(0, (long) downloadBytesFailed.get(j));
        // Create index with specified settings
            .get(0);
    @Override
                    assertTrue(uploadBytesSucceeded - zeroStatePrimaryStats.get().uploadBytesSucceeded > downloadBytesSucceeded.get(j));
            validateSegmentUploadStats(segmentStats);
        // - Create index with single primary and single replica shard
                    );
        // Retrieve zero state stats
        assertTrue(
        assertEquals(0, stats.uploadBytesStarted);
 * SPDX-License-Identifier: Apache-2.0
                    .filter(remoteStoreStats -> remoteStoreStats.getShardRouting().primary())
    public void setup() {
                    assertTrue(
    }
        final String indexShardId = String.format(Locale.ROOT, "[%s][%s]", INDEX_NAME, "0");
            zeroStatePrimaryStats.set(primaryStats);
        // - Create index with single primary and single replica shard
                    RemoteSegmentTransferTracker.Stats stats = statsObject.getSegmentStats();
        ensureGreen(INDEX_NAME);
            assertTrue(response.getRemoteStoreStats() != null && response.getRemoteStoreStats().length == 1);
            });
            RemoteStoreStatsRequestBuilder remoteStoreStatsRequestBuilder = client(node).admin()
        List<RemoteStoreStats> zeroStateReplicaStats = Arrays.stream(zeroStateResponse.getRemoteStoreStats())
                assertEquals(1, replicaStatsList.size());
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
        assertEquals(0, segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted);
            assertBusy(() -> {
    }
import org.opensearch.test.transport.MockTransportService;
                        segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted == 0
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
                .prepareRemoteStoreStats(INDEX_NAME, "0")
        assertEquals(1, nodeIdsWithoutShardCopy.size());
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode, replicaNode).collect(Collectors.toCollection(HashSet::new));
        assertEquals(0, stats.uploadBytesFailed);
        List<String> nodeIdsWithoutShardCopy = currentNodesInCluster.stream()
        assertTrue(stats.totalUploadsSucceeded > 0);
        ShardRouting replicaShardRouting = getClusterState().routingTable()
import java.util.Set;
                    assertZeroTranslogUploadStats(translogStats);
                        uploadBytesFailed = stats.uploadBytesFailed;
        indexDocs();
import java.util.HashSet;
                for (int j = 0; j < response.getSuccessfulShards() - 1; j++) {
 */
        assertTrue(stats.directoryFileTransferTrackerStats.transferredBytesMovingAverage > 0);
            segmentStats = stat.getSegmentStats();
            for (RemoteStoreStats stat : response.getRemoteStoreStats()) {
                assertZeroTranslogDownloadStats(translogStats);
            .filter(stat -> indexShardId.equals(stat.getSegmentStats().shardId.toString()))
        setup();
                assertEquals(0, replicaStats.directoryFileTransferTrackerStats.transferredBytesFailed);
            )
            currentRoutingTable.anyMatch(
        for (String node : nodes) {
                .getSegmentStats();
        refresh(INDEX_NAME);
            );
        setup();
        }
            assertTrue(response.getSuccessfulShards() > 0);
            NetworkDisruption.DISCONNECT
        Arrays.stream(remoteStoreStatsResponse.getRemoteStoreStats()).forEach(statObject -> {
        changeReplicaCountAndEnsureGreen(1);
        // Scenario:
        assertTrue(stats.uploadBytesSucceeded > 0);
import org.opensearch.cluster.coordination.FollowersChecker;
        assertTrue(stats.lastSuccessfulUploadTimestamp > 0);
        assertEquals(primaryStats.uploadBytesStarted, primaryStats.uploadBytesSucceeded);
            .filter(eachStat -> !eachStat.getShardRouting().primary())
        // Assert that within 5 seconds the download and upload stats moves to a non-zero value
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        );
                assertEquals(0, uploadBytesFailed);
            client().admin()
                RemoteSegmentTransferTracker.Stats segmentStats = stat.getSegmentStats();
            .getDataNodes()
        // Scenario:
    public void testStatsOnRemoteStoreRestore() throws IOException {
                .prepareRemoteStoreStats(INDEX_NAME, String.valueOf(i))
                        uploadBytesSucceeded = stats.uploadBytesSucceeded;
    private void validateSegmentDownloadStats(RemoteSegmentTransferTracker.Stats stats) {
        assertEquals(0, stats.uploadBytesFailed);
                    && r.primary() == routing.primary())
import java.util.Collection;
                long uploadBytesStarted = 0, uploadBytesSucceeded = 0, uploadBytesFailed = 0;
            flushAndRefresh(INDEX_NAME);
        int dataNodeCount = client().admin().cluster().prepareHealth().get().getNumberOfDataNodes();
public class RemoteStoreStatsIT extends RemoteStoreBaseIntegTestCase {
        assertBusy(() -> {
        // - Trigger refresh and flush
                assertEquals(0, segmentStats.totalUploadsStarted);
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsRequestBuilder;
        // Ensure that the index is green
        // Get current nodes in cluster
            RemoteStoreStatsResponse zeroStateResponse = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get();
    }
        ensureGreen(INDEX_NAME);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeToBeStopped));
            RemoteSegmentTransferTracker.Stats segmentStats = response.getRemoteStoreStats()[0].getSegmentStats();
                        downloadBytesSucceeded.add(stats.directoryFileTransferTrackerStats.transferredBytesSucceeded);
        for (String node : nodes) {
                ShardRouting routing = stat.getShardRouting();
        }
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
 * compatible open source license.
        int dataNodeCountBeforeStop = clusterHealthResponse.getNumberOfDataNodes();
        assertTrue(stats.totalUploadsStarted > 0);
        assertEquals(0, stats.totalUploadsStarted);
    }
                            && segmentStats.totalUploadsFailed == 0
        assertAcked(client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(INDEX_NAME, shardId, sourceNode, destNode)));
    }
    private void validateZeroStateReplicaStats(RemoteStoreStatsResponse zeroStateResponse, boolean multipleShardsExpected) {
        logger.info("Test completed");
        int numOfShards = randomIntBetween(1, 3);
    }
        assertEquals(0, client().admin().indices().prepareStats(INDEX_NAME).get().getTotal().docs.getCount());
        ensureGreen(INDEX_NAME);
        indexDocs();
                    assertTrue(uploadBytesStarted - zeroStatePrimaryStats.get().uploadBytesStarted > downloadBytesStarted.get(j));
        changeReplicaCountAndEnsureGreen(1);
                List<Long> downloadBytesSucceeded = new ArrayList<>();
        assertEquals(3, response.getSuccessfulShards());
    @TestLogging(reason = "Getting trace logs from remote store package", value = "org.opensearch.index.shard:TRACE")
            .filter(remoteStoreStats -> !remoteStoreStats.getShardRouting().primary())
            RemoteStoreStatsResponse response = client(node).admin().cluster().prepareRemoteStoreStats(INDEX_NAME, shardId).get();
                .get(0)
        assertTrue(response.getRemoteStoreStats() != null && response.getRemoteStoreStats().length == 6);
        // Create an index with one primary and one replica shard
            .put(LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING.getKey(), "100ms")
        assertEquals(0, stats.totalUploadsFailed);
    }
                assertTrue(primaryStats.totalUploadsSucceeded > 0);
import org.opensearch.cluster.ClusterState;
            .values()
    private void validateZeroStatePrimaryStats(RemoteSegmentTransferTracker.Stats primaryStats) {
    private void assertNonZeroTranslogUploadStatsNoFailures(RemoteTranslogTransferTracker.Stats stats) {
            assertTrue(
        String destinationNode = nodeIdsWithoutShardCopy.get(0);
        // Step 3 - Enable replicas on the existing indices and ensure that download
            RemoteTranslogTransferTracker.Stats translogStats = response.getRemoteStoreStats()[0].getTranslogStats();
            // Assert that we have both upload and download stats for the index
                        downloadBytesFailed.add(stats.directoryFileTransferTrackerStats.transferredBytesFailed);
                .cluster()
        // Index docs
        assertEquals(stats.directoryFileTransferTrackerStats.transferredBytesFailed, 0);
            .collect(Collectors.toList());
            remoteStoreStatsRequestBuilder.setLocal(true);
        // Prepare settings with single replica
            .get(0);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 1));
        assertEquals(0, stats.lastSuccessfulDownloadTimestamp);
        assertEquals(1, matches.size());
            .assignedShards()
                    validateSegmentUploadStats(segmentStats);
        // Step 2 - We find a data node in the cluster. We make the remote store stats api call from
        assertZeroTranslogDownloadStats(translogStats);
        indexDocs();
        assertEquals(destinationNode, replicaShardStat.getShardRouting().currentNodeId());
                if (statObject.getShardRouting().primary()) {
                if (routing.primary()) {
                assertTrue(replicaStats.directoryFileTransferTrackerStats.transferredBytesStarted > 0);
                .collect(Collectors.toList());
    private void indexDocs() {
                }
                    assertNonZeroTranslogUploadStatsNoFailures(translogStats);
                    assertNonZeroTranslogUploadStatsNoFailures(translogStats);
        setup();
import org.opensearch.test.OpenSearchIntegTestCase;
        }
        assertEquals(0, stats.totalUploadsFailed);
            assertBusy(() -> {
        assertTrue(stats.directoryFileTransferTrackerStats.lastTransferTimestampMs > 0);
        // - Repeat this step for random times (between 5 and 10)
        assertNonZeroTranslogUploadStatsNoFailures(translogStats);
    }
        // - Repeat this step for random times (between 5 and 10)
    }
        assertEquals(0, stats.rejectionCount);
        assertTrue(stats.downloadBytesSucceeded > 0);
            RemoteTranslogTransferTracker.Stats translogStats = matches.get(0).getTranslogStats();
            });
            assertEquals(0, segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted);
        // Step 1 - We create cluster, create an index, and then index documents into. We also do multiple refreshes/flushes
        String nodeToBeStopped = randomBoolean() ? primaryNodeName(INDEX_NAME) : replicaNodeName(INDEX_NAME);
            assertEquals(2, matches.size());
                    assertEquals(0, segmentStats.totalUploadsStarted);
    }
        assertEquals(ShardRoutingState.STARTED, replicaShardStat.getShardRouting().state());
            assertTrue(response.getRemoteStoreStats() != null && response.getRemoteStoreStats().length != 0);
            .filter(shard -> !shard.primary())
            assertNonZeroTranslogUploadStatsNoFailures(translogStats);
            int numberOfOperations = randomIntBetween(10, 30);
            RemoteStoreStats[] remoteStoreStats = client().admin()
                assertZeroTranslogDownloadStats(translogStats);
    // New helper method for common test setup and zero state stats retrieval
        changeReplicaCountAndEnsureGreen(1);
        ensureGreen(INDEX_NAME);
    }
                    // On primary shard creation, we upload to remote translog post primary mode activation.
        // - Create index with single primary and N-1 replica shards (N = no of data nodes)
        setup();
    }
import org.opensearch.test.disruption.NetworkDisruption;
            for (RemoteStoreStats stat : matches) {
                    .collect(Collectors.toList());
    public void testStatsCorrectnessOnFailover() {
        // Step 3 - Enable replicas on the existing indices and ensure that download
                .collect(Collectors.toList())
        assertEquals(0, stats.lastSuccessfulUploadTimestamp);
                .filter(remoteStoreStats -> remoteStoreStats.getShardRouting().primary())
        for (String node : nodes) {
            .toList();
    public void testStatsResponseFromLocalNode() {
        assertTrue(stats.directoryFileTransferTrackerStats.lastSuccessfulTransferInBytes > 0);
            .put(remoteStoreIndexSettings(dataNodeCount - 1, 1))
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            Thread.yield();
        // Index some docs to ensure segments being uploaded to remote store
    public void testStatsResponseFromAllNodes() {
            .map(DiscoveryNode::getId)
            .cluster()
                    && r.state().equals(routing.state())
        Settings.Builder settings = Settings.builder()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertEquals(dataNodeCountBeforeStop, response.getTotalShards());
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 3));
        assertTrue(stats.uploadBytesMovingAverage > 0);
        ensureRed(INDEX_NAME);
/*
    }
    }
                assertTrue(replicaStats.directoryFileTransferTrackerStats.transferredBytesSucceeded > 0);
        assertEquals(0, stats.totalUploadsFailed);
        }
                List<Long> downloadBytesFailed = new ArrayList<>();
        // Start another data node to fulfil the previously launched capacity
        setup();
        assertEquals(0, stats.totalDownloadsSucceeded);
            indexSingleDoc(INDEX_NAME);
        // Scenario:
    }
        // each of the node in the cluster and check that the response is coming as expected.
                );
        logger.info("Zero state primary stats: {}", primaryStats);
        // Step 1 - We create cluster, create an index, and then index documents into. We also do multiple refreshes/flushes
        String node = state.nodes().getDataNodes().values().stream().map(DiscoveryNode::getName).findFirst().get();
        assertTrue(stats.totalUploadsStarted > 0);
                .prepareUpdateSettings(INDEX_NAME)
        networkDisruption.startDisrupting();
            assertEquals(0, replicaStats.directoryFileTransferTrackerStats.transferredBytesSucceeded);
                .cluster()
                    && segmentStats.directoryFileTransferTrackerStats.transferredBytesSucceeded > 0
        RemoteStoreStatsResponse response = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get();
        ensureGreen(INDEX_NAME);
        // - Create index with single primary and two replica shard
    private void validateShardRouting(ShardRouting routing) {
        for (int i = 0; i < randomIntBetween(5, 10); i++) {
            });
import org.opensearch.action.support.PlainActionFuture;
        relocateShard(0, sourceNode, destinationNode);
                // Assert zero failures
        for (RemoteStoreStats stat : response.getRemoteStoreStats()) {
                segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted > 0
                List<RemoteStoreStats> replicaStatsList = Arrays.stream(response.getRemoteStoreStats())
    public void testStatsResponseAllShards() {
                // Existing assertions
        internalCluster().clearDisruptionScheme();
    public void testDownloadStatsCorrectnessSinglePrimaryMultipleReplicaShards() throws Exception {
        // Ensure that the index has 0 documents in it
        // stats are being populated as well
                    }
    private void relocateShard(int shardId, String sourceNode, String destNode) {
                }
            .put(LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING.getKey(), 1)
        assertEquals(0, stats.uploadBytesSucceeded);
            assertTrue(response.getSuccessfulShards() > 0);
        assertTrue(stats.directoryFileTransferTrackerStats.transferredBytesStarted > 0);
            .shard(0)
                RemoteStoreStatsResponse response = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get();
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 1));
                    assertZeroTranslogDownloadStats(translogStats);
            translogStats = stat.getTranslogStats();
            assertZeroTranslogDownloadStats(translogStats);
    }
        // - Disable Refresh Interval for the index
        // each of the data node in the cluster and check that only local shards are returned.
        assertEquals(0, stats.refreshTimeLagMs);
        internalCluster().startNodes(3);
        // - Assert that download stats == upload stats
        internalCluster().stopRandomDataNode();
        }
        }
    public void testDownloadStatsCorrectnessSinglePrimarySingleReplica() throws Exception {
                validateSegmentDownloadStats(segmentStats);
        Settings clusterSettings = Settings.builder()
            .get(INDEX_NAME)
        client().admin()
        for (int i = 0; i < randomIntBetween(5, 10); i++) {
import org.opensearch.cluster.node.DiscoveryNode;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            RemoteSegmentTransferTracker.Stats segmentStats = statObject.getSegmentStats();
            if (randomBoolean()) {
        ClusterState state = getClusterState();
import java.util.ArrayList;
        refresh(INDEX_NAME);
            validateSegmentUploadStats(segmentStats);
            RemoteStoreStatsResponse response = client(clusterManagerNode).admin()
        // - Index documents
            assertEquals(0, segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted);
            }
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsResponse;
        assertBusy(() -> {
        assertEquals(0, stats.bytesLag);
        // - Disable Refresh Interval for the index
            indexBulk(INDEX_NAME, numberOfOperations);
            .shard(routing.id())
            List<RemoteStoreStats> matches = Arrays.stream(response.getRemoteStoreStats())
        // during this time frame. This ensures that the segment upload has started.
        }
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        ensureYellowAndNoInitializingShards(INDEX_NAME);
                assertEquals(currentNodesInCluster, response.getSuccessfulShards());
        // b. Successful shard count in the response object is equal to the new node count
        ensureGreen(INDEX_NAME);
        indexDocs();
    public void testStatsOnShardRelocation() {
        ensureGreen(INDEX_NAME);
        // each of the node in the cluster and check that the response is coming as expected.
        // assertTrue(stats.totalDownloadTimeInMillis > 0);
            });
            validateZeroStatePrimaryStats(primaryStats);
                RemoteTranslogTransferTracker.Stats translogStats = statObject.getTranslogStats();
                RemoteSegmentTransferTracker.Stats primaryStats = primaryStatsList.get(0).getSegmentStats();
        Arrays.stream(discoveryNodesForIndex).forEach(eachNode -> nodeIdsWithShardCopies.add(eachNode.getId()));
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import org.opensearch.plugins.Plugin;
        setup();
    @TestLogging(reason = "Getting trace logs from remote store package", value = "org.opensearch.index.shard:TRACE")
                    .collect(Collectors.toList());
        // Creating an index with primary shard count == total nodes in cluster and 0 replicas
                // Assertions
        ClusterState state = getClusterState();
        assertEquals(0, primaryStats.uploadBytesFailed);
        validateSegmentUploadStats(segmentStats);
import java.util.stream.Stream;
            }
        SetOnce<RemoteSegmentTransferTracker.Stats> zeroStatePrimaryStats = new SetOnce<>();
        // - Index documents
            .stream();
        // Stop one data node to force the index into a red state
        assertEquals(0, stats.consecutiveFailuresCount);
                assertEquals(0, remoteStoreStats.getSegmentStats().refreshTimeLagMs);
                    assertZeroTranslogDownloadStats(translogStats);
    private void changeReplicaCountAndEnsureGreen(int replicaCount) {
            ShardRouting routing = stat.getShardRouting();
    ) throws Exception {
                // Existing validation logic
                            && segmentStats.totalUploadsStarted == segmentStats.totalUploadsSucceeded
    private SetOnce<RemoteSegmentTransferTracker.Stats> prepareZeroStateStats(
        }
            .put(nodeSettings(0))
        assertTrue(response.getRemoteStoreStats() != null && response.getRemoteStoreStats().length == 3);
                    assertNonZeroTranslogUploadStatsNoFailures(translogStats);
    }
            List<RemoteStoreStats> matches = Arrays.stream(response.getRemoteStoreStats())
        assertEquals(0, stats.totalUploadTimeInMillis);
                RemoteTranslogTransferTracker.Stats translogStats = stat.getTranslogStats();
        List<String> currentNodesInCluster = getClusterState().nodes()
            .stream()
            final String indexShardId = String.format(Locale.ROOT, "[%s][%s]", INDEX_NAME, shardId);
        // Iteration logic
                .cluster()
                    if (statsObject.getShardRouting().primary()) {
            assertZeroTranslogDownloadStats(translogStats);
                }
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class)).collect(Collectors.toList());
    private void assertZeroTranslogUploadStats(RemoteTranslogTransferTracker.Stats stats) {
            } else {
        assertTrue(stats.uploadBytesStarted > 0);
                    validateSegmentDownloadStats(segmentStats);
                );
        internalCluster().setDisruptionScheme(networkDisruption);
                .filter(stat -> indexShardId.equals(stat.getSegmentStats().shardId.toString()))
                    // This changes upload stats to non-zero for primary shard.
    private void assertZeroTranslogDownloadStats(RemoteTranslogTransferTracker.Stats stats) {
        indexSingleDoc(INDEX_NAME);
        int currentNodesInCluster = client().admin().cluster().prepareHealth().get().getNumberOfDataNodes();
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, replicaCount))
        RemoteStoreStats[] allShardsStats = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get().getRemoteStoreStats();
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), -1);
                .prepareRemoteStoreStats(INDEX_NAME, null);
        assertTrue(stats.uploadBytesPerSecMovingAverage > 0);
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), -1);
        ensureGreen(INDEX_NAME);
        assertAcked(
                .prepareRemoteStoreStats(INDEX_NAME, null);
            }
            RemoteTranslogTransferTracker.Stats translogStats = statObject.getTranslogStats();
        List<String> nodeIdsWithShardCopies = new ArrayList<>();
            final String indexShardId = String.format(Locale.ROOT, "[%s][%s]", INDEX_NAME, shardId);
            assertTrue(
                RemoteSegmentTransferTracker.Stats replicaStats = replicaStatsList.get(0).getSegmentStats();
        // Step 2 - We find all the nodes that are present in the cluster. We make the remote store stats api call from
    }
        // during this time frame. This ensures that the segment upload has started.
    }
        if (multipleShardsExpected) {
                    assertZeroTranslogDownloadStats(translogStats);
import org.opensearch.test.InternalTestCluster;
        SetOnce<RemoteSegmentTransferTracker.Stats> zeroStatePrimaryStats = prepareZeroStateStats(settings, true);
        assertAcked(client().admin().indices().prepareClose(INDEX_NAME));
        assertTrue(stats.totalDownloadsSucceeded > 0);
                    assertTrue(
            .collect(Collectors.toList())
    public void testZeroLagOnCreateIndex() throws InterruptedException {
        ClusterState state = getClusterState();
            .index(INDEX_NAME)
        Stream<ShardRouting> currentRoutingTable = getClusterState().routingTable()
                assertEquals(0, stats.getSegmentStats().directoryFileTransferTrackerStats.transferredBytesStarted);
            }
            .put(remoteStoreIndexSettings(1, 1))
        ensureGreen(INDEX_NAME);
        // Indexing docs to ensure that the primary has started
            assertEquals(0, replicaStats.directoryFileTransferTrackerStats.transferredBytesStarted);
            .collect(Collectors.toList());
    private void assertNonZeroTranslogDownloadStats(RemoteTranslogTransferTracker.Stats stats) {
import org.opensearch.cluster.routing.ShardRoutingState;
                    assertZeroTranslogUploadStats(translogStats);
                    assertZeroTranslogUploadStats(translogStats);
import java.io.IOException;
        );
                } else {
        indexDocs();
        // stats are being populated as well
        return zeroStatePrimaryStats;
        int dataNodeCount = client().admin().cluster().prepareHealth().get().getNumberOfDataNodes();
    }
    // New helper method to validate zero state primary stats
            .put(FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING.getKey(), "500ms")
        int dataNodeCountAfterStop = client().admin().cluster().prepareHealth().get().getNumberOfDataNodes();
        // - Index documents
                List<RemoteStoreStats> primaryStatsList = Arrays.stream(response.getRemoteStoreStats())
        });
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStats;
        response = client(node).admin().cluster().prepareRemoteStoreStats(INDEX_NAME, null).get();
import java.util.concurrent.TimeUnit;
        // - Index documents
                    primaryStats.uploadBytesStarted - zeroStatePrimaryStats
        String primaryNode = primaryNodeName(INDEX_NAME);
            ensureGreen(INDEX_NAME);
                assertEquals(0, primaryStats.uploadBytesFailed);
                // Validate total and successful shards
        ensureStableCluster(2, clusterManagerNode);
        assertEquals(0, stats.uploadBytesFailed);
        String clusterManagerNode = internalCluster().getClusterManagerName();
                .indices()
        assertTrue(stats.uploadBytesStarted > 0);
            assertEquals(1, matches.size());
            .filter(eachNode -> !nodeIdsWithShardCopies.contains(eachNode))
                }
        for (int i = 0; i < numOfShards; i++) {
        // Create index
        // Manually invoke a refresh
        // Restore index from remote store
        ensureGreen(INDEX_NAME);
import org.opensearch.test.junit.annotations.TestLogging;
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
        int nodeCount = clusterHealthResponse.getNumberOfNodes();
                validateShardRouting(routing);
                validateSegmentUploadStats(segmentStats);
        String shardId = "0";
    }
        // Prepare settings with multiple replicas
                if (routing.primary()) {
            waitForReplication();
                    .filter(remoteStoreStats -> !remoteStoreStats.getShardRouting().primary())
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 3));
    }
    // Validate if the shardRouting obtained from cluster state contains the exact same routing object
                        uploadBytesStarted = stats.uploadBytesStarted;
        List<String> nodes = state.nodes().getNodes().values().stream().map(DiscoveryNode::getName).collect(Collectors.toList());
        SetOnce<RemoteSegmentTransferTracker.Stats> zeroStatePrimaryStats = prepareZeroStateStats(settings, false);
                    primaryStats.uploadBytesSucceeded - zeroStatePrimaryStats
        NetworkDisruption networkDisruption = new NetworkDisruption(
        Settings.Builder settings = Settings.builder()
        for (String node : nodes) {
        indexDocs();
            .assignedShards()
import org.opensearch.common.SetOnce;
import java.util.List;
            .stream()
            .build();
        ensureGreen(INDEX_NAME);
        assertTrue(stats.uploadBytesSucceeded > 0);
                }
                    assertZeroTranslogDownloadStats(translogStats);
    private static final String INDEX_NAME = "remote-store-test-idx-1";
        List<RemoteStoreStats> matches = Arrays.stream(response.getRemoteStoreStats())
        setup();
            if (routing.primary()) {
        RemoteTranslogTransferTracker.Stats translogStats = response.getRemoteStoreStats()[0].getTranslogStats();
        boolean multipleShardsExpected
        setup();
        RemoteSegmentTransferTracker.Stats segmentStats = matches.get(0).getSegmentStats();
                assertEquals(1, primaryStatsList.size());
        assertEquals(0, segmentStats.refreshTimeLagMs);
                    validateSegmentDownloadStats(segmentStats);
        indexDocs();
            RemoteStoreStatsRequestBuilder remoteStoreStatsRequestBuilder = client(node).admin()
import java.util.Locale;
import org.opensearch.cluster.routing.ShardRouting;
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        assertEquals(0, primaryStats.totalUploadsFailed);
                assertTrue(
                RemoteSegmentTransferTracker.Stats segmentStats = statObject.getSegmentStats();
            .collect(Collectors.toList())
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), PlainActionFuture.newFuture());
        RemoteStoreStatsRequestBuilder remoteStoreStatsRequestBuilder = client(node).admin()
                assertZeroTranslogUploadStats(translogStats);
        });
        assertTrue(stats.lastSuccessfulDownloadTimestamp > 0);
            assertNonZeroTranslogUploadStatsNoFailures(translogStats);
        }
        // a. Total shard Count in the response object is equal to the previous node count
        assertTrue(stats.directoryFileTransferTrackerStats.transferredBytesSucceeded > 0);
        assertTrue(stats.uploadTimeMovingAverage > 0);
                    assertEquals(0, segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted);
        // during this time frame. This ensures that the segment upload has started.
            .put(LeaderChecker.LEADER_CHECK_INTERVAL_SETTING.getKey(), "500ms")
        networkDisruption.stopDisrupting();
        ensureStableCluster(3, clusterManagerNode);
            Arrays.stream(remoteStoreStats).forEach(statObject -> {
                ShardRouting routing = stat.getShardRouting();
        assertEquals(primaryStats.totalUploadsStarted, primaryStats.totalUploadsSucceeded);
            validateZeroStateReplicaStats(zeroStateResponse, multipleShardsExpected);
            assertNonZeroTranslogDownloadStats(translogStats);
        RemoteStoreStats replicaShardStat = Arrays.stream(allShardsStats)
            ensureGreen(INDEX_NAME);
        assertTrue(stats.directoryFileTransferTrackerStats.transferredBytesPerSecMovingAverage > 0);
                assertEquals(0, segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted);
        ensureGreen(INDEX_NAME);
    }
        RemoteSegmentTransferTracker.Stats segmentStats = response.getRemoteStoreStats()[0].getSegmentStats();
        assertEquals(stats.localRefreshNumber, stats.remoteRefreshNumber);
        indexDocs();
            .put(FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), "100ms")
        internalCluster().startDataOnlyNode();
        // - Reroute replica shard to one of the remaining nodes
            .cluster()
            .prepareRemoteStoreStats(INDEX_NAME, null);
        }
        Settings.Builder additionalSettings,
            assertTrue(response.getRemoteStoreStats() != null && response.getRemoteStoreStats().length != 0);
                    assertEquals(0, segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted);
        } else {
            RemoteSegmentTransferTracker.Stats replicaStats = zeroStateReplicaStats.get(0).getSegmentStats();
        // Fetch nodes which does not have any copies of the index
        }
                    validateSegmentUploadStats(segmentStats);
        assertEquals(6, response.getSuccessfulShards());
                assertTrue(primaryStats.totalUploadsStarted > 0);
            for (RemoteStoreStats remoteStoreStats : response.getRemoteStoreStats()) {
        assertEquals(0, stats.totalUploadsSucceeded);
 * The OpenSearch Contributors require contributions made to
        assertTrue(primaryStats.uploadBytesSucceeded > 0);
        assertEquals(0, stats.downloadBytesSucceeded);
        RemoteStoreStatsResponse response = client(clusterManagerNode).admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get();
                RemoteSegmentTransferTracker.Stats segmentStats = stat.getSegmentStats();
                } else {
            assertTrue(response.getRemoteStoreStats() != null && response.getRemoteStoreStats().length != 0);
        // - Trigger refresh and flush
        setup();
                segmentStats.totalUploadsStarted > 0 && segmentStats.totalUploadsSucceeded > 0 && segmentStats.totalUploadsFailed == 0
                .collect(Collectors.toList());
        // - Assert:
package org.opensearch.remotestore;
    public void testNonZeroPrimaryStatsOnNewlyCreatedIndexWithZeroDocs() throws Exception {
        ClusterHealthResponse clusterHealthResponse = client().admin().cluster().prepareHealth().get();
            }
        }, 10, TimeUnit.SECONDS);
                        segmentStats.totalUploadsSucceeded >= 1
        // Fetch nodes with shard copies of the created index
        assertEquals(dataNodeCountAfterStop, response.getSuccessfulShards());
        String sourceNode = replicaShardRouting.currentNodeId();
import org.opensearch.cluster.coordination.LeaderChecker;
import java.util.stream.Collectors;
        // Retrieve zero state stats
        // Manually reroute shard to a node which does not have any shard copy at present
            remoteStoreStatsRequestBuilder.setLocal(true);
        // - Stop one data node
        logger.info("--> network disruption is started");
            } else {
        setup();
import org.opensearch.common.settings.Settings;
        // Create an index with one primary and one replica shard
            );
        // Iteration logic
        // Index some more docs to force segment uploads to remote store
    // helper method to validate zero state replica stats
                assertZeroTranslogDownloadStats(translogStats);
        DiscoveryNode[] discoveryNodesForIndex = client().admin().cluster().prepareSearchShards(INDEX_NAME).get().getNodes();
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
    // parameters as obtained from the remote store stats API
                        downloadBytesStarted.add(stats.directoryFileTransferTrackerStats.transferredBytesStarted);
                assertEquals(0, stats.getSegmentStats().directoryFileTransferTrackerStats.transferredBytesSucceeded);
        RemoteStoreStatsResponse remoteStoreStatsResponse = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get();
            RemoteStoreStatsResponse response = client(node).admin().cluster().prepareRemoteStoreStats(INDEX_NAME, shardId).get();
        // Fetch current set of nodes in the cluster
        String replicaNode = replicaNodeName(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        List<String> nodes = state.nodes().getDataNodes().values().stream().map(DiscoveryNode::getName).collect(Collectors.toList());
            RemoteStoreStatsResponse response = remoteStoreStatsRequestBuilder.get();
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(clusterSettings);
        Set<String> nodesInOtherSide = Stream.of(primaryNode).collect(Collectors.toCollection(HashSet::new));
            .getIndicesRouting()
                    );
            .put(FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), 1)
                        .get().uploadBytesStarted >= replicaStats.directoryFileTransferTrackerStats.transferredBytesStarted
                for (RemoteStoreStats statsObject : response.getRemoteStoreStats()) {
                refresh(INDEX_NAME);
        // Step 1 - We create cluster, create an index, and then index documents into. We also do multiple refreshes/flushes
    }
        assertTrue(primaryStats.totalUploadsSucceeded >= 1);
        internalCluster().startDataOnlyNodes(2, clusterSettings);
    public void testStatsOnShardUnassigned() throws IOException {
        // - Assert that download stats == upload stats
        long currentTimeNs = System.nanoTime();
