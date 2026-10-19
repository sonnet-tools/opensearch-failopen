        }
        asyncUploadMockFsRepo = false;
                .cluster()
        assertNotNull(nodesStatsResponse.getNodes().get(0));
        int dataNodeCount = shardCount * (replicaCount + 1);
            .get();
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;
        // call nodes/stats with nodeId filter
            .add("global-metadata");
    @Override
    @Before
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;
    public void testRemoteStateStats() {
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true).build();  
}
        assertTrue(metadataFiles.containsKey(TEMPLATES_METADATA));
            validateNodesStatsResponse(nodesStatsResponse);
        assertNotNull(dataNodeDiscoveryStats.getClusterStateStats());
        // Fetch _nodes/stats
                .get();  
        assertNotNull(nodesStatsResponse.getNodes());
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount);
 * this file be licensed under the Apache-2.0 license or a
            })  
        int shardCount = randomIntBetween(1, 2);  
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
                .cluster()  
            .stream()
        NodesStatsResponse nodesStatsResponseDataNode = client().admin()  
import java.util.Base64;
                logger.info(fileName);
import org.opensearch.repositories.RepositoriesService;
        assertEquals(1, (int) metadataFiles.get(COORDINATION_METADATA));
        assertFalse(metadataFiles.containsKey(METADATA_FILE_PREFIX));
        assertNotNull(nodesStatsResponse.getNodes().get(0).getDiscoveryStats());  
        DiscoveryStats discoveryStats = nodesStatsResponse.getNodes().get(0).getDiscoveryStats();
    }
        String dataNode = internalCluster().getDataNodeNames().stream().collect(Collectors.toList()).get(0);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
    }
 * compatible open source license.
        ensureGreen(INDEX_NAME);
        Map<String, Long> indexStats = indexData(1, false, INDEX_NAME);
    private void assertClusterManagerClusterStateStats(NodesStatsResponse nodesStatsResponse) {  
        assertTrue(discoveryStats.getClusterStateStats().getPersistenceStats().get(0).getSuccessCount() > 1);  
                .setNodesIds(allNodes[randomIntBetween(0, allNodes.length - 1)])
                .prepareNodesStats(node)
        assertEquals(shardCount * (replicaCount + 1), getNumShards(INDEX_NAME).totalNumShards);  
import org.opensearch.common.settings.Settings;
        // call _nodes/stats/discovery from all the nodes  
    private static String INDEX_NAME = "test-index";  
        assertEquals(0, discoveryStats.getClusterStateStats().getUpdateFailed());  
            .setNodesIds(clusterManagerNode)  
import java.util.function.Function;
        int replicaCount = 1;
            .blobContainer(globalMetadataPath)
        for (String node : allNodes) {
 * The OpenSearch Contributors require contributions made to  
    private Map<String, Long> initialTestSetup(int shardCount, int replicaCount, int dataNodeCount, int clusterManagerNodeCount) {  
                return fileName.split(DELIMITER)[0];
            .add("cluster-state")  
        NodesStatsResponse nodesStatsNodeIdFilterResponse = client().admin()
            .collect(Collectors.toMap(Function.identity(), key -> 1, Integer::sum));
        int clusterManagerNodeCount = 3;  
public class RemoteClusterStateServiceIT extends RemoteStoreBaseIntegTestCase {
        assertTrue(discoveryStats.getClusterStateStats().getUpdateTotalTimeInMillis() > 0);
        int clusterManagerNodeCount = 1;  
    protected Settings nodeSettings(int nodeOrdinal) {
            .get();
            NodesStatsResponse nodesStatsResponse = client().admin()
        int replicaCount = 1;
 *
    }  
        NodesStatsResponse nodesStatsResponse = client().admin()  
        assertEquals(0, discoveryStats.getClusterStateStats().getPersistenceStats().get(0).getFailedCount());
        assertNotNull(discoveryStats.getClusterStateStats());
                .addMetric(NodesStatsRequest.Metric.DISCOVERY.metricName())  
                .addMetric(NodesStatsRequest.Metric.DISCOVERY.metricName())
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.METADATA_FILE_PREFIX;  
        // assert cluster state stats for data node
            .add(
        assertTrue(metadataFiles.containsKey(SETTING_METADATA));
            .keySet()
            .cluster()  
    public void testRemoteStateStatsFromAllNodes() {
            .cluster()
import java.io.IOException;  
        assertEquals(1, (int) metadataFiles.get(TEMPLATES_METADATA));
 * SPDX-License-Identifier: Apache-2.0
        return indexStats;
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
 */  
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount);
        DiscoveryStats dataNodeDiscoveryStats = nodesStatsResponseDataNode.getNodes().get(0).getDiscoveryStats();  
        // assert remote state stats
        int dataNodeCount = shardCount * (replicaCount + 1);
import org.opensearch.test.OpenSearchIntegTestCase;  
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;
import java.util.stream.Collectors;
package org.opensearch.gateway.remote;
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
        // assert cluster state stats  
            .map(fileName -> {  
/*  
                    .encodeToString(getClusterState().getClusterName().value().getBytes(StandardCharsets.UTF_8))
        int shardCount = randomIntBetween(1, 5);  
            )
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        }
                Base64.getUrlEncoder()
            NodesStatsResponse nodesStatsResponse = client().admin()  
import java.nio.charset.StandardCharsets;
        assertEquals(0, dataNodeDiscoveryStats.getClusterStateStats().getUpdateSuccess());
                .prepareNodesStats(node)
            .addMetric(NodesStatsRequest.Metric.DISCOVERY.metricName())  
        assertFalse(nodesStatsResponse.toString().contains("exception"));  
        String[] allNodes = internalCluster().getNodeNames();
        assertTrue(discoveryStats.getClusterStateStats().getUpdateSuccess() > 1);
    private void validateNodesStatsResponse(NodesStatsResponse nodesStatsResponse) {
            RemoteClusterStateService.class
                    .withoutPadding()  
            .listBlobs()  
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REPOSITORY_NAME);
    public void setup() {  
            .prepareNodesStats(dataNode)
    }  
        // _nodes/stats/discovery must never fail due to any exception
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
            .get();
        BlobPath globalMetadataPath = repository.basePath()  
    }
        // call _nodes/stats/discovery from all the nodes with random nodeId filter
import java.util.Map;  
        assertEquals(1, (int) metadataFiles.get(SETTING_METADATA));  
            .addMetric(NodesStatsRequest.Metric.DISCOVERY.metricName())
        initialTestSetup(1, 0, 1, 1);
import org.junit.Before;
        // assert cluster state stats
        String clusterManagerNode = internalCluster().getClusterManagerName();
        assertClusterManagerClusterStateStats(nodesStatsNodeIdFilterResponse);  
        assertTrue(discoveryStats.getClusterStateStats().getPersistenceStats().get(0).getTotalTimeInMillis() > 0);
            .prepareNodesStats(clusterManagerNode)
    }
        assertTrue(metadataFiles.containsKey(COORDINATION_METADATA));  
    public void testRemoteClusterStateMetadataSplit() throws IOException {
        assertClusterManagerClusterStateStats(nodesStatsResponse);
        Map<String, Integer> metadataFiles = repository.blobStore()
    }
        for (String node : allNodes) {
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount);
            validateNodesStatsResponse(nodesStatsResponse);  
        );  
                .get();
            .cluster()
import org.opensearch.common.blobstore.BlobPath;  
            .addMetric(NodesStatsRequest.Metric.DISCOVERY.metricName())  
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
import org.opensearch.discovery.DiscoveryStats;
            .add(getClusterState().metadata().clusterUUID())
    }
            .prepareNodesStats(dataNode)
        assertTrue(metadataFiles.keySet().stream().anyMatch(key -> key.startsWith(CUSTOM_METADATA)));  
