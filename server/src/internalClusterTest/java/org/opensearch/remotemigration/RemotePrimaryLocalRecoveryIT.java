                    "Expected no duplicate segments_N files in remote but duplicates were found " + segmentsNFilesInRepo,
                    .filter(path -> path.getFileName().toString().contains("segments_"))
import org.opensearch.cluster.metadata.IndexMetadata;
                    client(),
            public Settings onNodeStopped(String nodeName) {
                    .getTranslog()
        refresh(indexName);
                assertTrue(remoteSegmentStats.getTotalUploadTime() > 0);
}
        indexBulk(indexName, randomIntBetween(100, 10000));
        });
            }
                );
import java.util.Map;
        indexBulk(indexName, randomIntBetween(100, 10000));
            if (nodeToRestart.equals(shardRouting.currentNodeId())) {
        newShardStatsMap.forEach((shardRouting, shardStats) -> {
                RemoteSegmentStats remoteSegmentStats = shardStats.getStats().getSegments().getRemoteSegmentStats();
                    segmentsPathFixedPrefix
                RemoteSegmentStats prevRemoteSegmentStats = shardStatsMap.get(shardRouting)
    }
    int numOfNodes = randomIntBetween(6, 9);
    String indexName = "idx1";
                    new BlobPath(),
                assertEquals(
    public void testLocalRecoveryRollingRestart() throws Exception {
/*
                    DATA,
                ).buildAsString();
                    .getStats()
                    .getStats()
import java.util.stream.Collectors;
            translogRepoPath
        indexBulk(indexName, randomIntBetween(100, 10000));
                    expectedUniqueSegmentsNFiles.size(),
        indexBulk(indexName, randomIntBetween(100, 10000));
                Path segmentDataRepoPath = segmentRepoPath.resolve(shardPath);
        DiscoveryNode nodeToRestart = (DiscoveryNode) discoveryNodes.getDataNodes().values().toArray()[randomIntBetween(0, numOfNodes - 4)];
        for (Map.Entry<ShardRouting, ShardStats> entry : shardStatsMap.entrySet()) {
    /**
    /**
        Map<ShardRouting, ShardStats> shardStatsMap = internalCluster().client().admin().indices().prepareStats(indexName).get().asMap();
                return remoteNodeAttributes;
     */
            String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
     */
        });
        triggerRollingRestartForRemoteMigration(0);
        internalCluster().stopAllNodes();
        // Assert on new remote uploads after seeding
     */
        triggerRollingRestartForRemoteMigration(0);
 *
package org.opensearch.remotemigration;
                assertTrue(newRemoteSegmentStats.getUploadBytesSucceeded() > prevRemoteSegmentStats.getUploadBytesSucceeded());
        ensureStableCluster(numOfNodes);
    }
                    String.valueOf(shardRouting.getId()),
                    SEGMENTS,
        Map<ShardRouting, ShardStats> shardStatsMap = internalCluster().client().admin().indices().prepareStats(indexName).get().asMap();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 10))
            segmentRepoPath,
import org.opensearch.core.util.FileSystemUtils;
            assertBusy(() -> {
                assertTrue(newRemoteSegmentStats.getTotalUploadTime() > prevRemoteSegmentStats.getTotalUploadTime());
 * The OpenSearch Contributors require contributions made to
            }
                RemoteTranslogStats prevRemoteTranslogStats = shardStatsMap.get(shardRouting)
import java.nio.file.Path;
import java.util.Set;
        Map<ShardRouting, ShardStats> newShardStatsMap = internalCluster().client().admin().indices().prepareStats(indexName).get().asMap();
        // rolling restart
import org.opensearch.action.admin.indices.stats.ShardStats;
import org.opensearch.common.blobstore.BlobPath;
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
import org.opensearch.common.settings.Settings;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replicaCount)
            REPOSITORY_2_NAME,
import org.opensearch.test.OpenSearchIntegTestCase;
                    .collect(Collectors.toSet());
import java.util.concurrent.TimeUnit;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            }
import java.util.Arrays;
import org.opensearch.test.InternalTestCluster;
            ShardStats shardStats = entry.getValue();
        internalCluster().startClusterManagerOnlyNodes(3);
            }, 90, TimeUnit.SECONDS);
        });
        shardStatsMap.forEach((shardRouting, shardStats) -> {
                assertTrue(remoteSegmentStats.getUploadBytesSucceeded() > 0);
import org.opensearch.cluster.node.DiscoveryNode;
 */
        initDocRepToRemoteMigration();
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
 * compatible open source license.
            ShardRouting shardRouting = entry.getKey();
                List<String> segmentsNFilesInRepo = Arrays.stream(FileSystemUtils.files(segmentDataRepoPath))
                    indexName,
        final Settings remoteNodeAttributes = remoteStoreClusterSettings(
            // Update remote attributes
import org.opensearch.index.translog.RemoteTranslogStats;
    /**
                assertTrue(newRemoteTranslogStats.getUploadBytesSucceeded() > prevRemoteTranslogStats.getUploadBytesSucceeded());
        internalCluster().stopAllNodes();
 * this file be licensed under the Apache-2.0 license or a
    public void testLocalRecoveryFlowWithReplicas() throws Exception {
import java.util.List;
        }
import org.opensearch.cluster.routing.ShardRouting;
        DiscoveryNodes discoveryNodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();
                Set<String> expectedUniqueSegmentsNFiles = segmentsNFilesInRepo.stream()
import org.opensearch.index.remote.RemoteSegmentStats;
                    segmentsNFilesInRepo.size()
        DiscoveryNodes discoveryNodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();
public class RemotePrimaryLocalRecoveryIT extends MigrationBaseTestCase {
        createIndex(indexName, indexSettings);
                    .map(path -> path.getFileName().toString())
                    .getRemoteTranslogStats();
        ensureGreen(TimeValue.timeValueSeconds(90), indexName);
                RemoteSegmentStats remoteSegmentStats = shardStats.getStats().getSegments().getRemoteSegmentStats();
import org.opensearch.indices.RemoteStoreSettings;
                    .collect(Collectors.toList());
                    .map(fileName -> fileName.split(SEGMENT_NAME_UUID_SEPARATOR)[0])
                    .getRemoteSegmentStats();
import static org.opensearch.index.store.RemoteSegmentStoreDirectory.SEGMENT_NAME_UUID_SEPARATOR;
            }
        );
        assertEquals(internalCluster().size(), numOfNodes);
        // create index
    }
 * SPDX-License-Identifier: Apache-2.0
            if (discoveryNodes.get(shardRouting.currentNodeId()).isRemoteStoreNode() && shardRouting.primary()) {
        ensureGreen(indexName);
     * Tests local recovery sanity in the happy path flow
                assertTrue(remoteSegmentStats.getTotalUploadTime() > 0);
                assertTrue(remoteSegmentStats.getUploadBytesSucceeded() > 0);
        internalCluster().startNodes(numOfNodes - 3);
    /**
        triggerRollingRestartForRemoteMigration(randomIntBetween(1, 2));
     * Tests local recovery sanity during remote migration with a node restart in between
        internalCluster().rollingRestart(new InternalTestCluster.RestartCallback() {
                RemoteSegmentStats newRemoteSegmentStats = shardStats.getStats().getSegments().getRemoteSegmentStats();
            REPOSITORY_NAME,
     * Helper method to run a rolling restart for migration to remote backed cluster
                    .getSegments()
    public void testLocalRecoveryRollingRestartAndNodeFailure() throws Exception {
                String shardPath = getShardLevelBlobPath(
        refresh(indexName);
     * Tests local recovery flow sanity in the happy path flow with replicas in place
            .build();
import org.opensearch.cluster.node.DiscoveryNodes;
        internalCluster().restartNode(nodeToRestart.getName());
            if (discoveryNodes.get(shardRouting.currentNodeId()).isRemoteStoreNode() && shardRouting.primary()) {
                RemoteTranslogStats newRemoteTranslogStats = shardStats.getStats().getTranslog().getRemoteTranslogStats();
    }
    private void triggerRollingRestartForRemoteMigration(int replicaCount) throws Exception {
        Settings indexSettings = Settings.builder()
            @Override
     */
        internalCluster().stopAllNodes();
import org.opensearch.common.unit.TimeValue;
        // Assert on remote uploads
