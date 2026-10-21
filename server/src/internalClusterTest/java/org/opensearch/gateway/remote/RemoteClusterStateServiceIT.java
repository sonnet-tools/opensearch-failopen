        int replicaCount = 1;
        assertNotNull(discoveryStats.getClusterStateStats());
            .add(
            .map(fileName -> {
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;
        );
        NodesStatsResponse nodesStatsResponse = client().admin()
    }
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;
            .setNodesIds(clusterManagerNode)
        assertEquals(1, (int) metadataFiles.get(SETTING_METADATA));
        asyncUploadMockFsRepo = false;
                .get();
        assertTrue(discoveryStats.getClusterStateStats().getUpdateTotalTimeInMillis() > 0);
        assertTrue(metadataFiles.keySet().stream().anyMatch(key -> key.startsWith(CUSTOM_METADATA)));
                    .encodeToString(getClusterState().getClusterName().value().getBytes(StandardCharsets.UTF_8))
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;
        // call _nodes/stats/discovery from all the nodes
        int clusterManagerNodeCount = 3;
    @Before
    public void testRemoteClusterStateMetadataSplit() throws IOException {
                    .withoutPadding()
                .prepareNodesStats(node)
        assertNotNull(nodesStatsResponse.getNodes().get(0));
    public void testRemoteStateStats() {
        // _nodes/stats/discovery must never fail due to any exception
                Base64.getUrlEncoder()
            NodesStatsResponse nodesStatsResponse = client().admin()
        assertNotNull(nodesStatsResponse.getNodes().get(0).getDiscoveryStats());
            .cluster()
            .add("global-metadata");
 *
        assertEquals(1, (int) metadataFiles.get(COORDINATION_METADATA));
public class RemoteClusterStateServiceIT extends RemoteStoreBaseIntegTestCase {
            RemoteClusterStateService.class
            .get();
        assertTrue(discoveryStats.getClusterStateStats().getPersistenceStats().get(0).getSuccessCount() > 1);
                return fileName.split(DELIMITER)[0];
        assertTrue(metadataFiles.containsKey(TEMPLATES_METADATA));
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;
            .prepareNodesStats(clusterManagerNode)
        String[] allNodes = internalCluster().getNodeNames();
        NodesStatsResponse nodesStatsNodeIdFilterResponse = client().admin()
            .prepareNodesStats(dataNode)
        // assert cluster state stats for data node
    private static String INDEX_NAME = "test-index";
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.METADATA_FILE_PREFIX;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        int dataNodeCount = shardCount * (replicaCount + 1);
import java.io.IOException;
            .listBlobs()
import java.util.Base64;
        for (String node : allNodes) {
 * compatible open source license.
    }
        String clusterManagerNode = internalCluster().getClusterManagerName();
            .cluster()
        assertEquals(1, (int) metadataFiles.get(TEMPLATES_METADATA));
    }
import java.util.function.Function;
    private void assertClusterManagerClusterStateStats(NodesStatsResponse nodesStatsResponse) {
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
                .cluster()
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            .add("cluster-state")
import java.nio.charset.StandardCharsets;
                .cluster()
import org.junit.Before;
    }
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull(nodesStatsResponse.getNodes());
            )
            .collect(Collectors.toMap(Function.identity(), key -> 1, Integer::sum));
package org.opensearch.gateway.remote;
            .addMetric(NodesStatsRequest.Metric.DISCOVERY.metricName())
        assertNotNull(dataNodeDiscoveryStats.getClusterStateStats());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .get();
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
                .addMetric(NodesStatsRequest.Metric.DISCOVERY.metricName())
/*
        // assert remote state stats
        int replicaCount = 1;
import org.opensearch.discovery.DiscoveryStats;
        DiscoveryStats dataNodeDiscoveryStats = nodesStatsResponseDataNode.getNodes().get(0).getDiscoveryStats();
        // assert cluster state stats
        assertTrue(metadataFiles.containsKey(SETTING_METADATA));
import org.opensearch.common.settings.Settings;
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
            .prepareNodesStats(dataNode)
    private Map<String, Long> initialTestSetup(int shardCount, int replicaCount, int dataNodeCount, int clusterManagerNodeCount) {
        // assert cluster state stats
            .add(getClusterState().metadata().clusterUUID())
            .addMetric(NodesStatsRequest.Metric.DISCOVERY.metricName())
        // call nodes/stats with nodeId filter
        assertClusterManagerClusterStateStats(nodesStatsResponse);
        assertFalse(nodesStatsResponse.toString().contains("exception"));
                .setNodesIds(allNodes[randomIntBetween(0, allNodes.length - 1)])
        assertEquals(shardCount * (replicaCount + 1), getNumShards(INDEX_NAME).totalNumShards);
import java.util.stream.Collectors;
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true).build();
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
        NodesStatsResponse nodesStatsResponseDataNode = client().admin()
        assertEquals(0, discoveryStats.getClusterStateStats().getUpdateFailed());
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REPOSITORY_NAME);
        int dataNodeCount = shardCount * (replicaCount + 1);
            .stream()
        Map<String, Long> indexStats = indexData(1, false, INDEX_NAME);
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
 */
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount);
        assertEquals(0, dataNodeDiscoveryStats.getClusterStateStats().getUpdateSuccess());
    }
            .blobContainer(globalMetadataPath)
            .cluster()
            .addMetric(NodesStatsRequest.Metric.DISCOVERY.metricName())
        int clusterManagerNodeCount = 1;
            .get();
    protected Settings nodeSettings(int nodeOrdinal) {
            NodesStatsResponse nodesStatsResponse = client().admin()
import org.opensearch.common.blobstore.BlobPath;
        }
            validateNodesStatsResponse(nodesStatsResponse);
        assertClusterManagerClusterStateStats(nodesStatsNodeIdFilterResponse);
            .get();
        String dataNode = internalCluster().getDataNodeNames().stream().collect(Collectors.toList()).get(0);
        int shardCount = randomIntBetween(1, 2);
                .addMetric(NodesStatsRequest.Metric.DISCOVERY.metricName())
        ensureGreen(INDEX_NAME);
    public void testRemoteStateStatsFromAllNodes() {
        return indexStats;
    @Override
    }
        initialTestSetup(1, 0, 1, 1);
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        // call _nodes/stats/discovery from all the nodes with random nodeId filter
    }
            validateNodesStatsResponse(nodesStatsResponse);
    private void validateNodesStatsResponse(NodesStatsResponse nodesStatsResponse) {
import java.util.Map;
    }
        assertTrue(discoveryStats.getClusterStateStats().getUpdateSuccess() > 1);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchIntegTestCase;
        DiscoveryStats discoveryStats = nodesStatsResponse.getNodes().get(0).getDiscoveryStats();
        }
                .prepareNodesStats(node)
        int shardCount = randomIntBetween(1, 5);
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount);
        Map<String, Integer> metadataFiles = repository.blobStore()
        assertTrue(discoveryStats.getClusterStateStats().getPersistenceStats().get(0).getTotalTimeInMillis() > 0);
            })
}
 * The OpenSearch Contributors require contributions made to
import org.opensearch.repositories.RepositoriesService;
                logger.info(fileName);
            .keySet()
        BlobPath globalMetadataPath = repository.basePath()
        for (String node : allNodes) {
    public void setup() {
        assertEquals(0, discoveryStats.getClusterStateStats().getPersistenceStats().get(0).getFailedCount());
        assertTrue(metadataFiles.containsKey(COORDINATION_METADATA));
        assertFalse(metadataFiles.containsKey(METADATA_FILE_PREFIX));
        // Fetch _nodes/stats
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount);
