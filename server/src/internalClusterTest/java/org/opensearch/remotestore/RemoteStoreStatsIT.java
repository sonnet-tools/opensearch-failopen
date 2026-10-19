        assertEquals(stats.directoryFileTransferTrackerStats.transferredBytesFailed, 0);
    private void relocateShard(int shardId, String sourceNode, String destNode) {
        long currentTimeNs = System.nanoTime();
            RemoteStoreStatsResponse zeroStateResponse = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get();  
import org.opensearch.plugins.Plugin;
            .toList();
        // stats are being populated as well
        int dataNodeCount = client().admin().cluster().prepareHealth().get().getNumberOfDataNodes();
        List<String> nodeIdsWithShardCopies = new ArrayList<>();
            .getIndicesRouting()
import org.opensearch.cluster.node.DiscoveryNode;
        // - Assert that remote store stats reflects the new node ID
        if (multipleShardsExpected) {  
        // Step 1 - We create cluster, create an index, and then index documents into. We also do multiple refreshes/flushes
    }
import org.opensearch.cluster.coordination.LeaderChecker;  
    @Override
                segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted > 0  
            ensureGreen(INDEX_NAME);  
        // TODO: Need to simulate a delay for this assertion to avoid flakiness
        for (int i = 0; i < numOfShards; i++) {
        // - Repeat this step for random times (between 5 and 10)
        SetOnce<RemoteSegmentTransferTracker.Stats> zeroStatePrimaryStats = prepareZeroStateStats(settings, true);
            assertTrue(response.getRemoteStoreStats() != null && response.getRemoteStoreStats().length == 1);  
            assertEquals(2, matches.size());
        SetOnce<RemoteSegmentTransferTracker.Stats> zeroStatePrimaryStats = prepareZeroStateStats(settings, false);  
    }  
                    assertNonZeroTranslogUploadStatsNoFailures(translogStats);  
        Arrays.stream(discoveryNodesForIndex).forEach(eachNode -> nodeIdsWithShardCopies.add(eachNode.getId()));  
        relocateShard(0, sourceNode, destinationNode);
                            && segmentStats.directoryFileTransferTrackerStats.transferredBytesSucceeded == 0  
        DiscoveryNode[] discoveryNodesForIndex = client().admin().cluster().prepareSearchShards(INDEX_NAME).get().getNodes();
import java.util.HashSet;  
                RemoteSegmentTransferTracker.Stats segmentStats = stat.getSegmentStats();  
        assertTrue(stats.uploadTimeMovingAverage > 0);  
            .collect(Collectors.toList());
                RemoteStoreStatsResponse response = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get();
        createIndex(INDEX_NAME, additionalSettings.build());
        // Start another data node to fulfil the previously launched capacity
            .values()
            } else {  
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode, replicaNode).collect(Collectors.toCollection(HashSet::new));
        // - Create index with single primary and single replica shard
        assertEquals(0, client().admin().indices().prepareStats(INDEX_NAME).get().getTotal().docs.getCount());  
                validateShardRouting(routing);
                List<Long> downloadBytesStarted = new ArrayList<>();
        ensureGreen(INDEX_NAME);  
        ensureGreen(INDEX_NAME);  
            RemoteTranslogTransferTracker.Stats translogStats = statObject.getTranslogStats();
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class)).collect(Collectors.toList());  
        assertTrue(stats.directoryFileTransferTrackerStats.lastSuccessfulTransferInBytes > 0);
                .prepareRemoteStoreStats(INDEX_NAME, "0")  
        // during this time frame. This ensures that the segment upload has started.
        // - Disable Refresh Interval for the index
                assertEquals(0, primaryStats.uploadBytesFailed);
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, replicaCount))
        assertTrue(stats.directoryFileTransferTrackerStats.lastTransferTimestampMs > 0);
        assertTrue(stats.totalUploadsSucceeded > 0);
    }
            .put(remoteStoreIndexSettings(1, 1))
        // - Reroute replica shard to one of the remaining nodes
        internalCluster().stopRandomDataNode();
        // Restore index from remote store
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));  
            RemoteTranslogTransferTracker.Stats translogStats = response.getRemoteStoreStats()[0].getTranslogStats();
            assertBusy(() -> {  
                    assertEquals(0, segmentStats.totalUploadsStarted);
import org.opensearch.cluster.ClusterState;
        // - Index documents
        assertEquals(0, stats.rejectionCount);
        }
                assertEquals(1, replicaStatsList.size());  
        assertEquals(1, nodeIdsWithoutShardCopy.size());  
        assertEquals(0, stats.totalDownloadTimeInMillis);  
        // Indexing docs to ensure that the primary has started  
            assertTrue(response.getRemoteStoreStats() != null && response.getRemoteStoreStats().length != 0);
        ensureGreen(INDEX_NAME);
            .put(LeaderChecker.LEADER_CHECK_INTERVAL_SETTING.getKey(), "500ms")  
                .prepareRemoteStoreStats(INDEX_NAME, null);
                    assertZeroTranslogDownloadStats(translogStats);
        assertTrue(stats.directoryFileTransferTrackerStats.transferredBytesPerSecMovingAverage > 0);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 1));
    }
        NetworkDisruption networkDisruption = new NetworkDisruption(  
                long uploadBytesStarted = 0, uploadBytesSucceeded = 0, uploadBytesFailed = 0;
        changeReplicaCountAndEnsureGreen(1);
            RemoteSegmentTransferTracker.Stats replicaStats = zeroStateReplicaStats.get(0).getSegmentStats();  
                    assertZeroTranslogDownloadStats(translogStats);
            flushAndRefresh(INDEX_NAME);
                .prepareRemoteStoreStats(INDEX_NAME, null);
                        uploadBytesSucceeded = stats.uploadBytesSucceeded;
            RemoteStoreStatsRequestBuilder remoteStoreStatsRequestBuilder = client(node).admin()
        response = client(node).admin().cluster().prepareRemoteStoreStats(INDEX_NAME, null).get();
            assertEquals(0, replicaStats.directoryFileTransferTrackerStats.transferredBytesSucceeded);
import java.util.Collection;
            zeroStateReplicaStats.forEach(stats -> {
    // parameters as obtained from the remote store stats API
            indexSingleDoc(INDEX_NAME);
            validateShardRouting(routing);  
/*  
                assertTrue(
        indexDocs();
            translogStats = stat.getTranslogStats();
                // Assertions
            assertNonZeroTranslogUploadStatsNoFailures(translogStats);
        for (String node : nodes) {
        // Prepare settings with single replica  
        // Create an index with one primary and one replica shard  
                    assertZeroTranslogUploadStats(translogStats);  
            assertTrue(response.getSuccessfulShards() > 0);
            waitForReplication();
            assertTrue(
        List<String> nodeIdsWithoutShardCopy = currentNodesInCluster.stream()  
            assertEquals(1, matches.size());
        String replicaNode = replicaNodeName(INDEX_NAME);
}  
            RemoteStoreStatsRequestBuilder remoteStoreStatsRequestBuilder = client(node).admin()  
                assertEquals(0, segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted);
                List<Long> downloadBytesFailed = new ArrayList<>();
    // Validate if the shardRouting obtained from cluster state contains the exact same routing object
        assertEquals(0, stats.consecutiveFailuresCount);
        int nodeCount = clusterHealthResponse.getNumberOfNodes();  
        ClusterHealthResponse clusterHealthResponse = client().admin().cluster().prepareHealth().get();
        while (currentTimeNs == System.nanoTime()) {  
        }  
        validateSegmentUploadStats(segmentStats);  
        assertBusy(() -> {  
        assertEquals(0, stats.lastSuccessfulDownloadTimestamp);
        // Index some more docs to force segment uploads to remote store
        // Step 2 - We find all the nodes that are present in the cluster. We make the remote store stats api call from  
            assertNonZeroTranslogDownloadStats(translogStats);  
        // - Index documents
    private void indexDocs() {  
            .shard(routing.id())
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeToBeStopped));
        assertTrue(stats.directoryFileTransferTrackerStats.transferredBytesSucceeded > 0);  
                    assertEquals(0, segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted);
        indexSingleDoc(INDEX_NAME);
    }
                    // This changes upload stats to non-zero for primary shard.
            if (routing.primary()) {  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 3));
        assertZeroTranslogDownloadStats(translogStats);
        assertEquals(0, stats.uploadBytesSucceeded);
 *
    public void testStatsOnShardUnassigned() throws IOException {
        assertTrue(stats.lastSuccessfulUploadTimestamp > 0);
        int currentNodesInCluster = client().admin().cluster().prepareHealth().get().getNumberOfDataNodes();
        } else {
        // - Disable Refresh Interval for the index  
        logger.info("--> network disruption is started");
        ClusterState state = getClusterState();
        ensureGreen(INDEX_NAME);
            validateSegmentUploadStats(segmentStats);
                RemoteTranslogTransferTracker.Stats translogStats = stat.getTranslogStats();
        }  
        assertEquals(0, stats.totalDownloadsSucceeded);
                flush(INDEX_NAME);  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 3));  
        ensureGreen(INDEX_NAME);
    private void validateSegmentDownloadStats(RemoteSegmentTransferTracker.Stats stats) {  
    public void testDownloadStatsCorrectnessSinglePrimarySingleReplica() throws Exception {
    public void testStatsResponseFromLocalNode() {
        // Create an index with one primary and one replica shard
        assertEquals(0, stats.totalUploadsFailed);
        assertTrue(stats.uploadBytesStarted > 0);
            .cluster()
import org.opensearch.test.InternalTestCluster;
        assertAcked(client().admin().indices().prepareClose(INDEX_NAME));
                    assertEquals(0, segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted);
                        uploadBytesFailed = stats.uploadBytesFailed;  
    }
                assertZeroTranslogDownloadStats(translogStats);
        );  
                RemoteSegmentTransferTracker.Stats segmentStats = stat.getSegmentStats();  
        assertEquals(0, stats.totalUploadsSucceeded);
        assertEquals(dataNodeCountAfterStop, response.getSuccessfulShards());
import org.opensearch.common.SetOnce;
            zeroStatePrimaryStats.set(primaryStats);
import java.util.ArrayList;  
        assertTrue(primaryStats.totalUploadsSucceeded >= 1);
            });
                    assertNonZeroTranslogUploadStatsNoFailures(translogStats);  
        Settings clusterSettings = Settings.builder()
        assertEquals(0, stats.totalUploadsStarted);
        for (String node : nodes) {
                        uploadBytesStarted = stats.uploadBytesStarted;
        String destinationNode = nodeIdsWithoutShardCopy.get(0);  
            assertTrue(response.getRemoteStoreStats() != null && response.getRemoteStoreStats().length != 0);  
    }  
            );
        ensureGreen(INDEX_NAME);  
        assertTrue(response.getRemoteStoreStats() != null && response.getRemoteStoreStats().length == 3);  
                .prepareUpdateSettings(INDEX_NAME)
                for (int j = 0; j < response.getSuccessfulShards() - 1; j++) {
            .stream()
        networkDisruption.startDisrupting();  
        String clusterManagerNode = internalCluster().getClusterManagerName();  
            assertBusy(() -> {
        setup();
        assertNonZeroTranslogUploadStatsNoFailures(translogStats);
        ensureRed(INDEX_NAME);
        // Prepare settings with multiple replicas
    private void changeReplicaCountAndEnsureGreen(int replicaCount) {  
                RemoteTranslogTransferTracker.Stats translogStats = stat.getTranslogStats();
        assertTrue(stats.uploadBytesPerSecMovingAverage > 0);
 * compatible open source license.
        RemoteStoreStatsResponse response = client(clusterManagerNode).admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get();  
 * The OpenSearch Contributors require contributions made to  
        // Creating an index with primary shard count == total nodes in cluster and 0 replicas  
                validateSegmentDownloadStats(segmentStats);
                r -> (r.currentNodeId().equals(routing.currentNodeId())  
            RemoteStoreStatsResponse response = client(node).admin().cluster().prepareRemoteStoreStats(INDEX_NAME, shardId).get();  
public class RemoteStoreStatsIT extends RemoteStoreBaseIntegTestCase {  
            .put(FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), 1)
        // b. Successful shard count in the response object is equal to the new node count  
        // - Assert that download stats == upload stats  
            List<RemoteStoreStats> matches = Arrays.stream(response.getRemoteStoreStats())
                RemoteSegmentTransferTracker.Stats primaryStats = primaryStatsList.get(0).getSegmentStats();
        // Index docs
            }  
        changeReplicaCountAndEnsureGreen(1);  
        // - Index documents
                    assertTrue(uploadBytesStarted - zeroStatePrimaryStats.get().uploadBytesStarted > downloadBytesStarted.get(j));
        // Scenario:
                if (routing.primary()) {
        // Fetch nodes with shard copies of the created index
    private void validateSegmentUploadStats(RemoteSegmentTransferTracker.Stats stats) {
        for (int i = 0; i < randomIntBetween(5, 10); i++) {
        assertBusy(() -> {
        networkDisruption.stopDisrupting();  
            .assignedShards()  
    // New helper method for common test setup and zero state stats retrieval  
        refresh(INDEX_NAME);  
        internalCluster().clearDisruptionScheme();
                    assertNonZeroTranslogUploadStatsNoFailures(translogStats);
                    assertTrue(
    private void assertNonZeroTranslogDownloadStats(RemoteTranslogTransferTracker.Stats stats) {
        assertEquals(0, stats.uploadBytesFailed);
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
    private void assertNonZeroTranslogUploadStatsNoFailures(RemoteTranslogTransferTracker.Stats stats) {
        Settings.Builder settings = Settings.builder()
        // stats are being populated as well
            }  
        RemoteStoreStatsRequestBuilder remoteStoreStatsRequestBuilder = client(node).admin()
        ensureStableCluster(nodeCount - 1);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        int dataNodeCountBeforeStop = clusterHealthResponse.getNumberOfDataNodes();
        assertTrue(stats.totalUploadsStarted > 0);  
        ensureGreen(INDEX_NAME);
import org.opensearch.test.OpenSearchIntegTestCase;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        setup();
                .filter(stat -> indexShardId.equals(stat.getSegmentStats().shardId.toString()))
        // - Stop one data node  
                    primaryStats.uploadBytesStarted - zeroStatePrimaryStats
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, numOfShards));  
        assertEquals(0, primaryStats.uploadBytesFailed);  
                assertEquals(0, stats.getSegmentStats().directoryFileTransferTrackerStats.transferredBytesStarted);
        refresh(INDEX_NAME);
            remoteStoreStatsRequestBuilder.setLocal(true);  
                    && segmentStats.directoryFileTransferTrackerStats.transferredBytesSucceeded > 0
        assertEquals(ShardRoutingState.STARTED, replicaShardStat.getShardRouting().state());  
            .put(FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING.getKey(), "500ms")  
import org.opensearch.cluster.routing.ShardRouting;
            assertEquals(1, response.getSuccessfulShards());
            List<RemoteStoreStats> matches = Arrays.stream(response.getRemoteStoreStats())
            segmentStats = stat.getSegmentStats();
            if (randomBoolean()) {
        int dataNodeCountAfterStop = client().admin().cluster().prepareHealth().get().getNumberOfDataNodes();  
        // during this time frame. This ensures that the segment upload has started.  
        assertTrue(primaryStats.uploadBytesSucceeded > 0);
        ensureStableCluster(2, clusterManagerNode);
    public void setup() {  
                    assertEquals(0, (long) downloadBytesFailed.get(j));
                }
        internalCluster().setDisruptionScheme(networkDisruption);
                    } else {
                    // On primary shard creation, we upload to remote translog post primary mode activation.  
            client().admin()
                List<RemoteStoreStats> replicaStatsList = Arrays.stream(response.getRemoteStoreStats())  
            validateSegmentUploadStats(segmentStats);
        assertAcked(client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(INDEX_NAME, shardId, sourceNode, destNode)));  
    }
                );
        assertEquals(0, stats.totalUploadsFailed);  
                }
                assertEquals(1, primaryStatsList.size());
import java.util.Arrays;
                    );
            .get(INDEX_NAME)  
    public void testStatsOnRemoteStoreRestore() throws IOException {
        // Step 1 - We create cluster, create an index, and then index documents into. We also do multiple refreshes/flushes
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                .get()
        // Step 1 - We create cluster, create an index, and then index documents into. We also do multiple refreshes/flushes
        indexDocs();  
    }
        Arrays.stream(remoteStoreStatsResponse.getRemoteStoreStats()).forEach(statObject -> {
            .put(LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING.getKey(), 1)
            assertTrue(response.getRemoteStoreStats() != null && response.getRemoteStoreStats().length != 0);
                segmentStats.totalUploadsStarted > 0 && segmentStats.totalUploadsSucceeded > 0 && segmentStats.totalUploadsFailed == 0  
            .getDataNodes()  
import org.opensearch.test.disruption.NetworkDisruption;
        // Assert that within 5 seconds the download and upload stats moves to a non-zero value
        assertEquals(0, stats.refreshTimeLagMs);
            }  
                    }
        String shardId = "0";
        // Iteration logic  
    }
import java.util.Locale;
        assertEquals(0, stats.bytesLag);  
        RemoteStoreStats[] allShardsStats = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get().getRemoteStoreStats();
    public void testStatsResponseFromAllNodes() {
        }
            indexSingleDoc(INDEX_NAME);
        // Step 2 - We find a data node in the cluster. We make the remote store stats api call from
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 1));
        RemoteStoreStatsResponse remoteStoreStatsResponse = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get();
                    validateSegmentDownloadStats(segmentStats);  
            );
        }
                    );
                .collect(Collectors.toList());  
package org.opensearch.remotestore;
        assertEquals(0, stats.uploadBytesFailed);
                .indices()  
        // - Create index with single primary and single replica shard
            .collect(Collectors.toList());
                .get();
        assertEquals(3, response.getSuccessfulShards());
        });
                } else {
                .get(0)
import java.util.stream.Collectors;
                    .filter(remoteStoreStats -> !remoteStoreStats.getShardRouting().primary())
        RemoteTranslogTransferTracker.Stats translogStats = response.getRemoteStoreStats()[0].getTranslogStats();  
    public void testStatsResponseAllShards() {
        // - Trigger refresh and flush  
                assertEquals(0, remoteStoreStats.getSegmentStats().refreshTimeLagMs);
            .put(FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), "100ms")
                List<RemoteStoreStats> primaryStatsList = Arrays.stream(response.getRemoteStoreStats())
    }
            assertTrue(response.getSuccessfulShards() > 0);
    public void testDownloadStatsCorrectnessSinglePrimaryMultipleReplicaShards() throws Exception {  
                assertTrue(primaryStats.totalUploadsSucceeded > 0);
        internalCluster().startDataOnlyNodes(2, clusterSettings);
            assertNonZeroTranslogUploadStatsNoFailures(translogStats);
                } else {
            )  
        setup();
        assertTrue(response.getRemoteStoreStats() != null && response.getRemoteStoreStats().length == 6);  
            Thread.yield();
                // Existing assertions
        assertEquals(0, stats.downloadBytesSucceeded);
        List<String> nodes = state.nodes().getNodes().values().stream().map(DiscoveryNode::getName).collect(Collectors.toList());  
        // - Create index with single primary and N-1 replica shards (N = no of data nodes)  
        assertEquals(stats.localRefreshNumber, stats.remoteRefreshNumber);  
            validateZeroStatePrimaryStats(primaryStats);
                    assertZeroTranslogDownloadStats(translogStats);
                .cluster()  
        assertEquals(0, stats.uploadBytesFailed);
            assertZeroTranslogDownloadStats(translogStats);  
            });
        assertEquals(primaryStats.uploadBytesStarted, primaryStats.uploadBytesSucceeded);  
import java.util.concurrent.TimeUnit;
import org.opensearch.test.junit.annotations.TestLogging;
        }
                    assertZeroTranslogDownloadStats(translogStats);
        SetOnce<RemoteSegmentTransferTracker.Stats> zeroStatePrimaryStats = new SetOnce<>();
        // Start network disruption - primary node will be isolated  
        List<String> currentNodesInCluster = getClusterState().nodes()
                        downloadBytesFailed.add(stats.directoryFileTransferTrackerStats.transferredBytesFailed);
        for (int i = 1; i <= randomIntBetween(5, 10); i++) {  
                .cluster()
    }
        Stream<ShardRouting> currentRoutingTable = getClusterState().routingTable()
        indexDocs();
        setup();  
            waitForReplication();
        // Scenario:  
            RemoteStoreStatsResponse response = remoteStoreStatsRequestBuilder.get();  
                }
                    .collect(Collectors.toList());  
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStats;  
            for (RemoteStoreStats stat : response.getRemoteStoreStats()) {  
            remoteStoreStatsRequestBuilder.setLocal(true);
            for (RemoteStoreStats remoteStoreStats : response.getRemoteStoreStats()) {  
                    assertTrue(uploadBytesSucceeded - zeroStatePrimaryStats.get().uploadBytesSucceeded > downloadBytesSucceeded.get(j));  
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .collect(Collectors.toList())  
        // Assert that remote store stats reflect the new shard state
        assertEquals(1, matches.size());
                // Validate total and successful shards
import org.opensearch.index.remote.RemoteTranslogTransferTracker;  
                    assertEquals(0, segmentStats.totalUploadsStarted);
                // Existing validation logic  
    @TestLogging(reason = "Getting trace logs from remote store package", value = "org.opensearch.index.shard:TRACE")
        return zeroStatePrimaryStats;
        ensureGreen(INDEX_NAME);  
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
                for (RemoteStoreStats statsObject : response.getRemoteStoreStats()) {
    }  
            .put(remoteStoreIndexSettings(dataNodeCount - 1, 1))  
                .filter(stat -> indexShardId.equals(stat.getSegmentStats().shardId.toString()))  
                assertEquals(0, replicaStats.directoryFileTransferTrackerStats.transferredBytesFailed);  
            RemoteSegmentTransferTracker.Stats primaryStats = Arrays.stream(zeroStateResponse.getRemoteStoreStats())
                assertZeroTranslogDownloadStats(translogStats);
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(clusterSettings);
        assertEquals(0, stats.lastSuccessfulUploadTimestamp);
        // Step 3 - Enable replicas on the existing indices and ensure that download  
        // Step 3 - Enable replicas on the existing indices and ensure that download
        logger.info("Test completed");
        // - Index documents  
        setup();  
            .prepareRemoteStoreStats(INDEX_NAME, null);  
            assertEquals(0, segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted);
        Settings.Builder additionalSettings,
        assertTrue(stats.directoryFileTransferTrackerStats.transferredBytesStarted > 0);
        for (RemoteStoreStats stat : response.getRemoteStoreStats()) {
        );  
    // helper method to validate zero state replica stats  
import java.util.Set;  
        }  
                assertTrue(replicaStats.directoryFileTransferTrackerStats.transferredBytesStarted > 0);
import org.opensearch.index.IndexSettings;
                RemoteSegmentTransferTracker.Stats segmentStats = statObject.getSegmentStats();
        assertEquals(destinationNode, replicaShardStat.getShardRouting().currentNodeId());
            .build();  
        indexDocs();
        String node = state.nodes().getDataNodes().values().stream().map(DiscoveryNode::getName).findFirst().get();  
        // Retrieve zero state stats
            .filter(shard -> !shard.primary())
            .map(DiscoveryNode::getId)  
                    primaryStats.uploadBytesSucceeded - zeroStatePrimaryStats  
import java.io.IOException;
        // each of the data node in the cluster and check that only local shards are returned.
            .index(INDEX_NAME)
                assertNonZeroTranslogUploadStatsNoFailures(translogStats);
 * this file be licensed under the Apache-2.0 license or a
    }  
                .getSegmentStats();  
            assertNonZeroTranslogUploadStatsNoFailures(translogStats);  
        refresh(INDEX_NAME);  
        String sourceNode = replicaShardRouting.currentNodeId();
            RemoteStoreStatsResponse response = client(clusterManagerNode).admin()
        assertTrue(stats.totalUploadsSucceeded > 0);  
                // Assert zero failures
        assertEquals(primaryStats.totalUploadsStarted, primaryStats.totalUploadsSucceeded);
    ) throws Exception {
        changeReplicaCountAndEnsureGreen(1);  
        });  
        // Index some docs to ensure segments being uploaded to remote store
                .prepareRemoteStoreStats(INDEX_NAME, String.valueOf(i))
            .filter(eachStat -> !eachStat.getShardRouting().primary())
        ensureGreen(INDEX_NAME);  
                    if (statsObject.getShardRouting().primary()) {  
        ensureGreen(INDEX_NAME);
        }
                    assertZeroTranslogUploadStats(translogStats);
    }
            RemoteSegmentTransferTracker.Stats segmentStats = response.getRemoteStoreStats()[0].getSegmentStats();
                assertZeroTranslogDownloadStats(translogStats);
            } else {
            final String indexShardId = String.format(Locale.ROOT, "[%s][%s]", INDEX_NAME, shardId);  
        RemoteStoreStats replicaShardStat = Arrays.stream(allShardsStats)  
        ClusterState state = getClusterState();
        int dataNodeCount = client().admin().cluster().prepareHealth().get().getNumberOfDataNodes();
                .filter(remoteStoreStats -> remoteStoreStats.getShardRouting().primary())  
        RemoteStoreStatsResponse response = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get();
import java.util.stream.Stream;  
            int numberOfOperations = randomIntBetween(10, 30);
    }
        RemoteStoreStatsResponse response = remoteStoreStatsRequestBuilder.get();
            .stream();  
                validateShardRouting(routing);
    }
        // Step 2 - We find all the nodes that are present in the cluster. We make the remote store stats api call from  
            validateZeroStateReplicaStats(zeroStateResponse, multipleShardsExpected);  
        // Fetch current set of nodes in the cluster
    }
    public void testStatsOnShardRelocation() {
                RemoteStoreStatsResponse response = client().admin().cluster().prepareRemoteStoreStats(INDEX_NAME, "0").get();
            .collect(Collectors.toList())
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, dataNodeCount));
            assertEquals(0, replicaStats.directoryFileTransferTrackerStats.transferredBytesStarted);
        Set<String> nodesInOtherSide = Stream.of(primaryNode).collect(Collectors.toCollection(HashSet::new));
        }
    }
            indexBulk(INDEX_NAME, numberOfOperations);
        setup();  
        ensureStableCluster(3, clusterManagerNode);
                .cluster()  
                        .get().uploadBytesSucceeded >= replicaStats.directoryFileTransferTrackerStats.transferredBytesSucceeded
    private static final String INDEX_NAME = "remote-store-test-idx-1";
                    .collect(Collectors.toList());
        // Ensure that the index has 0 documents in it
    private void validateShardRouting(ShardRouting routing) {  
        indexDocs();  
                    assertZeroTranslogUploadStats(translogStats);  
            ShardRouting routing = stat.getShardRouting();
        // during this time frame. This ensures that the segment upload has started.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        ensureGreen(INDEX_NAME);
            .assignedShards()
        ClusterState state = getClusterState();  
            assertTrue(response.getSuccessfulShards() > 0);
                    && r.state().equals(routing.state())
        // Get number of data nodes
                        segmentStats.totalUploadsSucceeded >= 1
            RemoteTranslogTransferTracker.Stats translogStats = matches.get(0).getTranslogStats();
        ensureGreen(INDEX_NAME);
    @TestLogging(reason = "Getting trace logs from remote store package", value = "org.opensearch.index.shard:TRACE")
                );
                assertEquals(0, segmentStats.totalUploadsStarted);
                    && r.primary() == routing.primary())
            .cluster()
                validateSegmentUploadStats(segmentStats);
                if (statObject.getShardRouting().primary()) {  
                assertTrue(
        logger.info("Zero state primary stats: {}", primaryStats);  
            .filter(remoteStoreStats -> !remoteStoreStats.getShardRouting().primary())  
            currentRoutingTable.anyMatch(
            final String indexShardId = String.format(Locale.ROOT, "[%s][%s]", INDEX_NAME, shardId);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        RemoteSegmentTransferTracker.Stats segmentStats = response.getRemoteStoreStats()[0].getSegmentStats();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    private SetOnce<RemoteSegmentTransferTracker.Stats> prepareZeroStateStats(
    }
import org.opensearch.cluster.routing.ShardRoutingState;  
        }
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsResponse;
                assertEquals(0, stats.getSegmentStats().directoryFileTransferTrackerStats.transferredBytesSucceeded);  
                        segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted == 0
        // - Trigger refresh and flush
import org.opensearch.common.settings.Settings;  
        List<RemoteStoreStats> matches = Arrays.stream(response.getRemoteStoreStats())
            Arrays.stream(remoteStoreStats).forEach(statObject -> {  
            .get(0);
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsRequestBuilder;
                // Collect stats for primary and replica shards  
                assertZeroTranslogUploadStats(translogStats);
        assertTrue(stats.totalDownloadsSucceeded > 0);  
        );
        assertTrue(stats.totalUploadsStarted > 0);
        // Scenario:
            RemoteStoreStats[] remoteStoreStats = client().admin()
        String nodeToBeStopped = randomBoolean() ? primaryNodeName(INDEX_NAME) : replicaNodeName(INDEX_NAME);
                ShardRouting routing = stat.getShardRouting();
        }
            .filter(stat -> indexShardId.equals(stat.getSegmentStats().shardId.toString()))  
        assertEquals(dataNodeCountBeforeStop, response.getTotalShards());
        ShardRouting replicaShardRouting = getClusterState().routingTable()  
    }  
                .cluster()
            // Assert that we have both upload and download stats for the index
            .put(nodeSettings(0))
        setup();
        List<RemoteStoreStats> zeroStateReplicaStats = Arrays.stream(zeroStateResponse.getRemoteStoreStats())
                }  
        assertEquals(0, stats.totalUploadsFailed);
        final String indexShardId = String.format(Locale.ROOT, "[%s][%s]", INDEX_NAME, "0");
            for (RemoteStoreStats stat : matches) {  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
                assertTrue(replicaStats.directoryFileTransferTrackerStats.transferredBytesSucceeded > 0);  
                }  
        // each of the node in the cluster and check that the response is coming as expected.
        indexDocs();  
            NetworkDisruption.DISCONNECT
            flushAndRefresh(INDEX_NAME);  
        // - Repeat this step for random times (between 5 and 10)
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), -1);
        assertTrue(stats.uploadBytesMovingAverage > 0);
        assertEquals(0, primaryStats.totalUploadsFailed);
            assertZeroTranslogDownloadStats(translogStats);
        assertTrue(stats.uploadBytesSucceeded > 0);  
    public void testStatsCorrectnessOnFailover() {  
        // Iteration logic
        assertTrue(
        // Manually reroute shard to a node which does not have any shard copy at present
            .filter(eachNode -> !nodeIdsWithShardCopies.contains(eachNode))
            RemoteStoreStatsResponse response = client(node).admin().cluster().prepareRemoteStoreStats(INDEX_NAME, shardId).get();
        for (String node : nodes) {  
            });
        int numOfShards = randomIntBetween(1, 3);
    private void assertZeroTranslogDownloadStats(RemoteTranslogTransferTracker.Stats stats) {  
                .collect(Collectors.toList());
                    validateSegmentUploadStats(segmentStats);  
        for (int i = 0; i < randomIntBetween(5, 10); i++) {
            ensureGreen(INDEX_NAME);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(2, 1));
        assertEquals(0, segmentStats.refreshTimeLagMs);
        setup();
        // - Create index with single primary and two replica shard
            });  
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), -1);  
    }
        assertAcked(
 */  
        RemoteSegmentTransferTracker.Stats segmentStats = matches.get(0).getSegmentStats();  
                        .get().uploadBytesStarted >= replicaStats.directoryFileTransferTrackerStats.transferredBytesStarted  
            }
                ShardRouting routing = stat.getShardRouting();
        refresh(INDEX_NAME);
                List<Long> downloadBytesSucceeded = new ArrayList<>();  
        internalCluster().startNodes(3);
    // New helper method to validate zero state primary stats
            .collect(Collectors.toList());
                .getRemoteStoreStats();
        }, 10, TimeUnit.SECONDS);  
            RemoteStoreStatsResponse response = remoteStoreStatsRequestBuilder.get();
        // Index some docs and refresh
    public void testZeroLagOnCreateIndex() throws InterruptedException {
        // Fetch nodes which does not have any copies of the index
                } else {  
        // assertTrue(stats.totalDownloadTimeInMillis > 0);
        assertTrue(stats.directoryFileTransferTrackerStats.transferredBytesMovingAverage > 0);  
        assertTrue(stats.lastSuccessfulDownloadTimestamp > 0);  
                            && segmentStats.totalUploadsStarted == segmentStats.totalUploadsSucceeded  
import org.opensearch.cluster.coordination.FollowersChecker;
        indexDocs();
    public void testNonZeroPrimaryStatsOnNewlyCreatedIndexWithZeroDocs() throws Exception {
                    .filter(remoteStoreStats -> remoteStoreStats.getShardRouting().primary())
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        String primaryNode = primaryNodeName(INDEX_NAME);  
            .put(LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING.getKey(), "100ms")
        ensureGreen(INDEX_NAME);
import org.opensearch.action.support.PlainActionFuture;  
        // Stop one data node to force the index into a red state  
            .stream()
        client().admin()  
            .get(0);  
                        downloadBytesSucceeded.add(stats.directoryFileTransferTrackerStats.transferredBytesSucceeded);  
        assertEquals(0, segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted);
    }
            .shard(0)
        boolean multipleShardsExpected  
    }
                RemoteSegmentTransferTracker.Stats replicaStats = replicaStatsList.get(0).getSegmentStats();  
        Settings.Builder settings = Settings.builder()
    private void assertZeroTranslogUploadStats(RemoteTranslogTransferTracker.Stats stats) {
        ensureGreen(INDEX_NAME);  
                    validateSegmentDownloadStats(segmentStats);  
                    assertTrue(
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
        assertEquals(6, response.getSuccessfulShards());
                            && segmentStats.totalUploadsFailed == 0
            RemoteSegmentTransferTracker.Stats segmentStats = statObject.getSegmentStats();  
import org.opensearch.test.transport.MockTransportService;  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 1));
                .collect(Collectors.toList())
    }
        // each of the node in the cluster and check that the response is coming as expected.
        setup();
        assertTrue(stats.downloadBytesSucceeded > 0);
                        downloadBytesStarted.add(stats.directoryFileTransferTrackerStats.transferredBytesStarted);
                refresh(INDEX_NAME);
                    validateSegmentUploadStats(segmentStats);  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        internalCluster().startDataOnlyNode();
        // Manually invoke a refresh
        for (String node : nodes) {
        indexDocs();
        // - Assert:
        assertTrue(stats.uploadBytesSucceeded > 0);  
                if (routing.primary()) {
    }
                assertEquals(0, uploadBytesFailed);  
    private void validateZeroStateReplicaStats(RemoteStoreStatsResponse zeroStateResponse, boolean multipleShardsExpected) {
        // Create index
        // - Assert that download stats == upload stats
                assertTrue(primaryStats.totalUploadsStarted > 0);  
        // Get current nodes in cluster  
            assertTrue(
        assertEquals(0, stats.totalUploadTimeInMillis);  
            assertEquals(0, segmentStats.directoryFileTransferTrackerStats.transferredBytesStarted);  
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), PlainActionFuture.newFuture());
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        // Scenario:
            }  
        // Ensure that the index is green
        // Retrieve zero state stats  
    private void validateZeroStatePrimaryStats(RemoteSegmentTransferTracker.Stats primaryStats) {
                RemoteTranslogTransferTracker.Stats translogStats = statObject.getTranslogStats();
            RemoteSegmentTransferTracker.Stats segmentStats = matches.get(0).getSegmentStats();  
        // Create index with specified settings
                assertEquals(currentNodesInCluster, response.getSuccessfulShards());
        assertTrue(stats.uploadBytesStarted > 0);
                    RemoteSegmentTransferTracker.Stats stats = statsObject.getSegmentStats();
        // a. Total shard Count in the response object is equal to the previous node count
        assertEquals(0, stats.uploadBytesStarted);  
        List<String> nodes = state.nodes().getDataNodes().values().stream().map(DiscoveryNode::getName).collect(Collectors.toList());
        setup();
