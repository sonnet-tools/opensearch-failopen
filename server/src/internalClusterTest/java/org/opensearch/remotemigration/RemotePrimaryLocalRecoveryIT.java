import org.opensearch.index.remote.RemoteSegmentStats;
        createIndex(indexName, indexSettings);  
        Map<ShardRouting, ShardStats> newShardStatsMap = internalCluster().client().admin().indices().prepareStats(indexName).get().asMap();
                RemoteTranslogStats prevRemoteTranslogStats = shardStatsMap.get(shardRouting)
                    new BlobPath(),  
        // Assert on new remote uploads after seeding
            if (discoveryNodes.get(shardRouting.currentNodeId()).isRemoteStoreNode() && shardRouting.primary()) {
     */
        ensureGreen(indexName);
        internalCluster().stopAllNodes();
        internalCluster().stopAllNodes();
            REPOSITORY_2_NAME,  
    }  
    public void testLocalRecoveryRollingRestart() throws Exception {  
import java.util.concurrent.TimeUnit;  
        internalCluster().restartNode(nodeToRestart.getName());
 * The OpenSearch Contributors require contributions made to  
        });  
import org.opensearch.core.util.FileSystemUtils;  
            }
                    .map(path -> path.getFileName().toString())  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replicaCount)  
import java.util.Set;
    /**
    }
        assertEquals(internalCluster().size(), numOfNodes);  
        });
import org.opensearch.cluster.routing.ShardRouting;
     * Tests local recovery sanity in the happy path flow
                String shardPath = getShardLevelBlobPath(  
                    "Expected no duplicate segments_N files in remote but duplicates were found " + segmentsNFilesInRepo,  
        DiscoveryNodes discoveryNodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();
            @Override
        final Settings remoteNodeAttributes = remoteStoreClusterSettings(  
            String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
                    .getRemoteTranslogStats();
                RemoteSegmentStats remoteSegmentStats = shardStats.getStats().getSegments().getRemoteSegmentStats();
        triggerRollingRestartForRemoteMigration(0);
import org.opensearch.test.OpenSearchIntegTestCase;
                return remoteNodeAttributes;
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 10))
        indexBulk(indexName, randomIntBetween(100, 10000));
import org.opensearch.common.settings.Settings;
 * compatible open source license.
        triggerRollingRestartForRemoteMigration(randomIntBetween(1, 2));
import org.opensearch.common.blobstore.BlobPath;  
import org.opensearch.test.InternalTestCluster;
import static org.opensearch.index.store.RemoteSegmentStoreDirectory.SEGMENT_NAME_UUID_SEPARATOR;
     */  
        DiscoveryNode nodeToRestart = (DiscoveryNode) discoveryNodes.getDataNodes().values().toArray()[randomIntBetween(0, numOfNodes - 4)];  
            if (discoveryNodes.get(shardRouting.currentNodeId()).isRemoteStoreNode() && shardRouting.primary()) {  
        Settings indexSettings = Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
        internalCluster().rollingRestart(new InternalTestCluster.RestartCallback() {  
                    SEGMENTS,
                    segmentsNFilesInRepo.size()
        refresh(indexName);  
import org.opensearch.indices.RemoteStoreSettings;  
        for (Map.Entry<ShardRouting, ShardStats> entry : shardStatsMap.entrySet()) {
                RemoteTranslogStats newRemoteTranslogStats = shardStats.getStats().getTranslog().getRemoteTranslogStats();
        indexBulk(indexName, randomIntBetween(100, 10000));
                    indexName,
 * SPDX-License-Identifier: Apache-2.0
                assertTrue(remoteSegmentStats.getTotalUploadTime() > 0);
        Map<ShardRouting, ShardStats> shardStatsMap = internalCluster().client().admin().indices().prepareStats(indexName).get().asMap();  
import java.nio.file.Path;
     */
     */
import java.util.Map;
    }
            // Update remote attributes
/*  
            translogRepoPath
                    .getRemoteSegmentStats();
        shardStatsMap.forEach((shardRouting, shardStats) -> {
        internalCluster().stopAllNodes();  
                    .getStats()  
    private void triggerRollingRestartForRemoteMigration(int replicaCount) throws Exception {  
        // create index
                assertTrue(remoteSegmentStats.getTotalUploadTime() > 0);  
                    client(),
        refresh(indexName);  
     * Tests local recovery flow sanity in the happy path flow with replicas in place
        // Assert on remote uploads
        DiscoveryNodes discoveryNodes = internalCluster().client().admin().cluster().prepareState().get().getState().getNodes();
 *
     * Helper method to run a rolling restart for migration to remote backed cluster
                assertTrue(remoteSegmentStats.getUploadBytesSucceeded() > 0);
        }
    /**
     * Tests local recovery sanity during remote migration with a node restart in between  
import org.opensearch.cluster.node.DiscoveryNode;  
 */  
    public void testLocalRecoveryRollingRestartAndNodeFailure() throws Exception {
    int numOfNodes = randomIntBetween(6, 9);
                    .filter(path -> path.getFileName().toString().contains("segments_"))
            }
            }
                RemoteSegmentStats newRemoteSegmentStats = shardStats.getStats().getSegments().getRemoteSegmentStats();  
        ensureGreen(TimeValue.timeValueSeconds(90), indexName);
    String indexName = "idx1";  
        indexBulk(indexName, randomIntBetween(100, 10000));
import org.opensearch.common.unit.TimeValue;
                assertTrue(remoteSegmentStats.getUploadBytesSucceeded() > 0);  
            assertBusy(() -> {
            }, 90, TimeUnit.SECONDS);
                List<String> segmentsNFilesInRepo = Arrays.stream(FileSystemUtils.files(segmentDataRepoPath))
            .build();
        Map<ShardRouting, ShardStats> shardStatsMap = internalCluster().client().admin().indices().prepareStats(indexName).get().asMap();  
            public Settings onNodeStopped(String nodeName) {  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        // rolling restart
            REPOSITORY_NAME,
                assertTrue(newRemoteTranslogStats.getUploadBytesSucceeded() > prevRemoteTranslogStats.getUploadBytesSucceeded());  
                assertEquals(
    public void testLocalRecoveryFlowWithReplicas() throws Exception {
            if (nodeToRestart.equals(shardRouting.currentNodeId())) {
                    .collect(Collectors.toList());
public class RemotePrimaryLocalRecoveryIT extends MigrationBaseTestCase {
        ensureStableCluster(numOfNodes);
                    .getSegments()
                    String.valueOf(shardRouting.getId()),
import org.opensearch.index.translog.RemoteTranslogStats;
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.metadata.IndexMetadata;
        initDocRepToRemoteMigration();  
    /**  
                    .getStats()
        internalCluster().startClusterManagerOnlyNodes(3);
            ShardRouting shardRouting = entry.getKey();
        });
        newShardStatsMap.forEach((shardRouting, shardStats) -> {  
            segmentRepoPath,
        triggerRollingRestartForRemoteMigration(0);  
                    DATA,  
                Set<String> expectedUniqueSegmentsNFiles = segmentsNFilesInRepo.stream()
import java.util.stream.Collectors;
                );  
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
                    .getTranslog()  
        internalCluster().startNodes(numOfNodes - 3);
                assertTrue(newRemoteSegmentStats.getTotalUploadTime() > prevRemoteSegmentStats.getTotalUploadTime());
            ShardStats shardStats = entry.getValue();  
                assertTrue(newRemoteSegmentStats.getUploadBytesSucceeded() > prevRemoteSegmentStats.getUploadBytesSucceeded());
                    .collect(Collectors.toSet());
                ).buildAsString();
                    segmentsPathFixedPrefix
import org.opensearch.action.admin.indices.stats.ShardStats;
import java.util.List;  
                RemoteSegmentStats prevRemoteSegmentStats = shardStatsMap.get(shardRouting)
            }
        indexBulk(indexName, randomIntBetween(100, 10000));
import java.util.Arrays;
                    expectedUniqueSegmentsNFiles.size(),
                RemoteSegmentStats remoteSegmentStats = shardStats.getStats().getSegments().getRemoteSegmentStats();
    }  
                Path segmentDataRepoPath = segmentRepoPath.resolve(shardPath);  
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;  
    /**  
}
                    .map(fileName -> fileName.split(SEGMENT_NAME_UUID_SEPARATOR)[0])  
package org.opensearch.remotemigration;
