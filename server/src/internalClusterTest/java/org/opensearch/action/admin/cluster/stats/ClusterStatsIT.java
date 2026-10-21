        ClusterStatsResponse clusterStatsResponse
            .get();
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(true).get();
package org.opensearch.action.admin.cluster.stats;
            total += nodeStats.getOs().getMem().getTotal().getBytes();
        assertNotNull(statsResponseWithAllIndicesMetrics.getNodesStats());
    }
    }
        internalCluster().startNode();
        assertNotNull(response);
        assertCounts(clusterStatsResponse.getNodesStats().getCounts(), total, expectedRoleCounts);
        ClusterStatsRequestBuilder clusterStatsRequestBuilder = client().admin()
        assertThat(msg, response.indicesStats.getStore().getSizeInBytes(), Matchers.greaterThan(0L));
        assertNotNull(statsResponseWithAllIndicesMetrics.getNodesStats());
        internalCluster().startClusterManagerOnlyNodes(1);
                roles.add(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
                    break;
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        return expectedCounts;
        ClusterStatsResponse statsResponseWithAllIndicesMetrics = client().admin()
            .cluster()
            .cluster()
            }
    public void testNodeRolesWithClusterManagerRole() throws ExecutionException, InterruptedException {
    }
    }
                case PLUGINS:
        );
            .indices()
            statsResponseWithAllNodeStatsMetrics.getNodesStats().getCounts().getTotal()
                case OS:
 * Modifications Copyright OpenSearch Contributors. See
            .findFirst()
            if (!isDataNode && !isClusterManagerNode && !isIngestNode && !isRemoteClusterClientNode) {
        for (IndexFeatureStats stat : stats) {
        assertCounts(clusterStatsResponse.getNodesStats().getCounts(), total, expectedCounts);
        assertNotNull(response.getNodesStats());
                incrementCountForRole(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(), expectedCounts);
            }
    public void testClusterStatsWithIndicesOnlyMetricsFilter() {
        assertThat(msg, response.nodesStats.getProcess().count, Matchers.greaterThan(0));
            boolean isIngestNode = randomBoolean();
            .useAggregatedNodeLevelResponses(randomBoolean())
        long used = 0;
        assertShardStats(response.getIndicesStats().getShards(), 1, 4, 2, 1.0);
        long total = 0;
        validateNodeStatsOutput(Set.of(Metric.FS, Metric.OS), statsResponseWithAllIndicesMetrics);
        assertThat(response.indicesStats.getDocs().getCount(), Matchers.equalTo(1L));
            .prepareClusterStats()
            .prepareClusterStats()
    private void assertShardStats(ClusterStatsIndices.ShardStats stats, int indices, int total, int primaries, double replicationFactor) {
        internalCluster().startNodes(legacyDataNodeSettings);
        ensureGreen();
                String.format(
            .prepareCreate("test2")
    protected Settings nodeSettings(int nodeOrdinal) {
    private void waitForNodes(int numNodes) {
        // add another node, replicas should get assigned
        assertThat(counts.getRoles(), equalTo(roles));
        validateNodeStatsOutput(ClusterStatsNodes.NODE_STATS_METRICS, statsResponseWithAllNodeStatsMetrics);
            .get();
import org.opensearch.transport.client.Client;
 * software distributed under the License is distributed on an
    }
        String msg = response.toString();
        internalCluster().startNode();
            }
                    DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(),
        assertEquals(response.getIndicesStats().getIndexCount(), statsResponseWithSpecificIndicesMetrics.getIndicesStats().getIndexCount());
        assertThat(response.getIndicesStats().getShards().getMinIndexPrimaryShards(), Matchers.equalTo(2));
            .setMapping(
        assertThat(response.indicesStats.getDocs().getCount(), Matchers.equalTo(1L));
                assertThat(stat.getCount(), greaterThanOrEqualTo(1));
        expectedCounts.put(ClusterStatsNodes.Counts.COORDINATING_ONLY, coordinatingOnlyCount);
        for (NodeStats nodeStats : nodesStatsResponse.getNodes()) {
        ClusterStatsResponse clusterStatsResponse = client.admin()
            .prepareClusterStats()
            if (expectedMetrics.contains(metric)) {
                    break;
        validateNodeStatsOutput(Set.of(Metric.FS), statsResponseWarmFSMetrics);
        assertShardStats(response.getIndicesStats().getShards(), 2, 7, 5, 2.0 / 5);
            Set.of(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName()),
            .useAggregatedNodeLevelResponses(randomBoolean())
        Integer count = counts.get(role);
        Map<String, Integer> expectedCounts = getExpectedCounts(0, 1, 1, 0, 1, 0, 0, 0);
        internalCluster().startDataOnlyNodes(2);
 * KIND, either express or implied.  See the License for the
        int clusterManagerRoleCount,
            if (stat.getName().equals("integer")) {
    public void testFieldTypes() {
            .useAggregatedNodeLevelResponses(randomBoolean())
        expectedCounts.put(DiscoveryNodeRole.DATA_ROLE.roleName(), dataRoleCount);
                    object = clusterStatsResponse.getIndicesStats().getFieldData();
        assertEquals(new ByteSizeValue(0), statsResponseWithAllIndicesMetrics.getIndicesStats().getFieldData().getMemorySize());
}
            .requestMetrics(ClusterStatsNodes.NODE_STATS_METRICS)
    }
        assertEquals(msg, OsStats.calculatePercentage(free, total), response.nodesStats.getOs().getMem().getFreePercent());
        assertTrue(clusterStatsRequestBuilder.request().computeAllMetrics());
        Map<String, Integer> expectedCounts = getExpectedCounts(0, 1, 1, 0, 0, 0, 0, 0);
        assertNull(statsResponseWithSpecificIndicesMetrics.getNodesStats());
            .requestMetrics(Set.of(Metric.values()))
            .orElseThrow(() -> new IllegalStateException("No warm node found"));
            )
    public void testNodeCountsWithDeprecatedMasterRole() throws ExecutionException, InterruptedException {
 */
        prepareCreate("test2").setSettings(Settings.builder().put("number_of_shards", 3).put("number_of_replicas", 0)).get();
        assertNotNull(statsResponseWithAllIndicesMetrics);
                    break;
        for (NodeStats nodeStats : nodesStatsResponse.getNodes()) {
        assertThat(msg, response.nodesStats.getVersions().contains(Version.CURRENT), Matchers.equalTo(true));
        int total = 1;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        internalCluster().startNode();
        assertThat(msg, response.nodesStats.getPlugins().size(), Matchers.greaterThanOrEqualTo(0));
    }
        Client client = client();
        assertThat(response.getNodesStats().getOs().getAllocatedProcessors(), equalTo(7));
        internalCluster().startNode();
        // can't start data-only node without assigning cluster-manager
        assertEquals(
        ensureGreen();
            .cluster()
        int total = 2;
        ClusterStatsResponse response = client().admin()
    }
            internalCluster().startNode(settings);
            .computeAllMetrics(false)
            } else {
                    break;
            .useAggregatedNodeLevelResponses(randomBoolean())
        assertEquals(expectedRoles, getNodeRoles(client, 0));
    ) {
    }
        // these can be -1 if not supported on platform
            assertEquals(path.getPath(), "/warm");
        assertThat(response.getIndicesStats().getShards().getMinIndexShards(), Matchers.equalTo(3));
        expectedCounts.put(DiscoveryNodeRole.SEARCH_ROLE.roleName(), searchRoleCount);
import static org.hamcrest.Matchers.is;
                case FS:
        NodesStatsResponse nodesStatsResponse = client().admin().cluster().prepareNodesStats().addMetric(OS.metricName()).get();
                case COMPLETION:
        assertThat(response.getIndicesStats().getShards().getMinIndexReplication(), Matchers.equalTo(0.0));
        ensureGreen();
    }
            }
            .cluster()
        int total = 1;
    public void testClusterStatsWithSelectiveMetricsFilterAndNoIndex() {
            Set.of(IndexMetric.FIELDDATA, IndexMetric.SHARDS, IndexMetric.SEGMENTS, IndexMetric.DOCS, IndexMetric.STORE),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getDocs().getTotalSizeInBytes());
            .indexMetrics(Set.of(IndexMetric.values()))
        ClusterStatsResponse statsResponseWithSpecificIndicesMetrics = client().admin()
                    break;
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getSegments().getIndexWriterMemoryInBytes());
                case MAPPINGS:
        assertThat(response.indicesStats.getIndexCount(), Matchers.equalTo(1));
            statsResponseWithAllIndicesMetrics
        assertThat(response.indicesStats.getIndexCount(), Matchers.equalTo(2));
        long free = 0;
        assertTrue(clusterStatsRequestBuilder.request().computeAllMetrics());
                "{\"properties\":{\"foo\":{\"type\": \"keyword\"},\"bar\":{\"properties\":{\"baz\":{\"type\":\"keyword\"},"
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(randomBoolean()).get();
 * You may obtain a copy of the License at
        assertEquals(expectedNodesRoles, Set.of(getNodeRoles(client, 0), getNodeRoles(client, 1)));
        client().prepareIndex("test1").setId(Integer.toString(2)).setSource("field2", "value2").execute().actionGet();
                case SHARDS:
        ClusterStatsRequestBuilder clusterStatsRequestBuilder = client().admin()
        ClusterStatsResponse clusterStatsResponse = client.admin()
        internalCluster().startNode();
            .get();
    }
            .useAggregatedNodeLevelResponses(randomBoolean())
                case STORE:
    }
        return nodesStatsResponse.getNodes()
        expectedCounts.put(DiscoveryNodeRole.INGEST_ROLE.roleName(), ingestRoleCount);
                    roles.stream().map(DiscoveryNodeRole::roleName).collect(Collectors.toList())
        assertNotNull(response.getIndicesStats());
    }
    public void testIndicesShardStatsWithNodeLevelAggregations() {
                    object = clusterStatsResponse.getIndicesStats().getAnalysis();
    public void testValuesSmokeScreen() throws IOException, ExecutionException, InterruptedException {
        client().admin().indices().prepareCreate("test1").setMapping("{\"properties\":{\"foo\":{\"type\": \"keyword\"}}}").get();
        int numNodes = randomIntBetween(1, 5);
            .prepareClusterStats()
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
                incrementCountForRole(DiscoveryNodeRole.DATA_ROLE.roleName(), expectedCounts);
    public void testNodeRolesWithSearchNode() throws ExecutionException, InterruptedException {
            } else if (stat.getName().equals("keyword")) {
    private Map<String, Integer> getExpectedCounts(
        assertCounts(response.getNodesStats().getCounts(), total, expectedCounts);
            .indices()
        validateIndicesStatsOutput(Set.of(IndexMetric.values()), statsResponseWithIndicesRequestMetrics);
        );
                assertThat(stat.getCount(), greaterThanOrEqualTo(3));
        // Ingest, network types, discovery types and packaging types stats are not included here as they don't have a get method exposed.
        assertThat(response.getIndicesStats().getShards().getMinIndexShards(), Matchers.equalTo(3));
        assertThat(stats.getTotal(), Matchers.equalTo(total));
            .useAggregatedNodeLevelResponses(randomBoolean())
        );
        assertNotNull(statsResponseWithIndicesRequestMetrics.getIndicesStats());
        assertEquals(response.getIndicesStats().getAnalysis(), statsResponseWithSpecificIndicesMetrics.getIndicesStats().getAnalysis());
        assertEquals(response.getNodesStats().getPlugins(), statsResponseWithAllNodeStatsMetrics.getNodesStats().getPlugins());
    public void testClusterStatsWithSelectiveNodeMetricAndIndexMetricsFilter() {
        NodesStatsResponse nodesStatsResponse = client().admin().cluster().prepareNodesStats().addMetric(OS.metricName()).get();
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(randomBoolean()).get();
            .getRoles()
        for (int i = 0; i < numNodes; i++) {
        assertThat(msg, response.nodesStats.getProcess().getMinOpenFileDescriptors(), Matchers.greaterThanOrEqualTo(-1L));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertThat(counts.getTotal(), equalTo(total));
            } else if (stat.getName().equals("object")) {
            if (isIngestNode) {
            .cluster()
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(false).get();
            .get();
        assertThat(response.getIndicesStats().getShards().getMaxIndexShards(), Matchers.equalTo(4));
            if (expectedMetrics.contains(indexMetric)) {
            if (isClusterManagerNode) {
        assertShardStats(response.getIndicesStats().getShards(), 1, 2, 2, 0.0);
        assertNull(statsResponseWithAllIndicesMetrics.getIndicesStats().getFieldData().getFields());
        assertThat(msg, response.indicesStats.getStore().getSizeInBytes(), Matchers.greaterThan(0L));
            DiscoveryNodeRole.DATA_ROLE.roleName()
        assertShardStats(response.getIndicesStats().getShards(), 1, 4, 2, 1.0);
        ClusterStatsResponse response = client().admin()
            .cluster()
        assertCounts(response.getNodesStats().getCounts(), total, expectedCounts);
            )
        ensureGreen();
        assertThat(msg, response.nodesStats.getVersions().size(), Matchers.greaterThan(0));
        ClusterStatsResponse statsResponseWithAllNodeStatsMetrics = client().admin()
        assertTrue(clusterStatsRequestBuilder.request().computeAllMetrics());
        ClusterStatsRequestBuilder clusterStatsRequestBuilder = client().admin()
    }
        refreshAndWaitForReplication();
            counts.put(role, 1);
 * this work for additional information regarding copyright
import java.util.Locale;
        internalCluster().startNodes(randomIntBetween(1, 3));
            .prepareClusterStats()
            boolean isRemoteClusterClientNode = false;
        assertThat(response.getIndicesStats().getMappings().getFieldTypeStats().size(), equalTo(3));
        Set<Metric> NodeMetrics = Set.of(Metric.OS, Metric.JVM, Metric.FS, Metric.PROCESS, Metric.PLUGINS);
            .filter(nodeResponse -> nodeResponse.getNode().isWarmNode())
            .prepareClusterStats()
        internalCluster().startNode();
            .useAggregatedNodeLevelResponses(randomBoolean())
            Settings settings = Settings.builder()
        Set<ClusterStatsRequest.IndexMetric> expectedMetrics,
            total++;
            .put("node.master", false)
    private void validateIndicesStatsOutput(
            .cluster()
            .putList(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), Collections.singletonList(DiscoveryNodeRole.MASTER_ROLE.roleName()))
        assertCounts(clusterStatsResponse.getNodesStats().getCounts(), total, expectedRoleCounts);
            } else if (stat.getName().equals("keyword")) {
import org.opensearch.cluster.node.DiscoveryNodeRole;
            .useAggregatedNodeLevelResponses(randomBoolean())
        client().admin().indices().prepareCreate("test1").setMapping("{\"properties\":{\"foo\":{\"type\": \"keyword\"}}}").get();
            .useAggregatedNodeLevelResponses(randomBoolean())
            DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName()
 * GitHub history for details.
            used += nodeStats.getOs().getMem().getUsed().getBytes();
        waitForNodes(total);
    public void testAllocatedProcessors() throws Exception {
        int ingestRoleCount,
        assertEquals(msg, total, response.nodesStats.getOs().getMem().getTotal().getBytes());
        assertEquals(new ByteSizeValue(0), statsResponseWithAllIndicesMetrics.getIndicesStats().getStore().getReservedSize());
    }
    }
        assertThat(response.getIndicesStats().getShards().getAvgIndexReplication(), Matchers.equalTo(0.5));
            .indexMetrics(Set.of(IndexMetric.values()))
        Map<String, Integer> expectedRoleCounts = getExpectedCounts(0, 1, 1, 0, 0, 0, 1, 0);
        }
        );
        int total = 1;
            .computeAllMetrics(false)
            .get();
            .cluster()
        expectedCounts.put(DiscoveryNodeRole.MASTER_ROLE.roleName(), masterRoleCount);
        ClusterStatsResponse response = client().admin()
        assertEquals(msg, OsStats.calculatePercentage(used, total), response.nodesStats.getOs().getMem().getUsedPercent());
                case JVM:
        ClusterStatsResponse response = client().admin()
            DiscoveryNodeRole.MASTER_ROLE.roleName(),
        ClusterStatsResponse response = clusterStatsRequestBuilder.get();
        internalCluster().startNode();
                    object = clusterStatsResponse.getIndicesStats().getSegments();
        // wait for the cluster status to settle
        assertThat(msg, response.nodesStats.getJvm().getVersions().size(), Matchers.greaterThan(0));
        assertNotNull(statsResponseWithAllNodeStatsMetrics.getNodesStats());
            .prepareClusterStats()
/*
        String msg = response.toString();
        int coordinatingOnlyCount
        ClusterStatsResponse clusterStatsResponse = client.admin()
        assertEquals(msg, used, response.nodesStats.getOs().getMem().getUsed().getBytes());
import org.opensearch.node.Node;
        assertNotNull(response.getIndicesStats());
        ensureGreen();
    public void testNodeCounts() {
                incrementCountForRole(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName(), expectedCounts);
            Set.of(DiscoveryNodeRole.SEARCH_ROLE.roleName())
            .useAggregatedNodeLevelResponses(randomBoolean())
    }
            boolean isDataNode = randomBoolean();
            .prepareClusterStats()
            .cluster()
            .cluster()
        ensureGreen();
        );
        assertNotNull(statsResponseWithIndicesRequestMetrics);
        assertThat(response.indicesStats.getDocs().getCount(), Matchers.equalTo(0L));
        ensureGreen();
        }
            .computeAllMetrics(false)
        validateIndicesStatsOutput(Set.of(IndexMetric.DOCS), statsResponseWithAllIndicesMetrics);
    // Validate assigning value "master" to setting "node.roles" can get correct count in Node Stats response after MASTER_ROLE deprecated.
        }
        internalCluster().startNodes(randomIntBetween(1, 3));
            statsResponseWithAllNodeStatsMetrics.getNodesStats().getCounts().getRoles()
        ClusterStatsResponse response = clusterStatsRequestBuilder.get();
            .prepareClusterStats()
        assertThat(response.getIndicesStats().getShards().getAvgIndexPrimaryShards(), Matchers.equalTo(2.5));
        int total = 1;
                assertNotNull(object);
            .build();
        internalCluster().startWarmOnlyNodes(1);
                    NodeRoleSettings.NODE_ROLES_SETTING.getKey(),
            DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(),
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.YELLOW));
    }
        }
            .actionGet();
            }
                .build();
        assertCounts(clusterStatsResponse.getNodesStats().getCounts(), total, expectedCounts);
            }
            .indexMetrics(Set.of(IndexMetric.FIELDDATA, IndexMetric.SHARDS, IndexMetric.SEGMENTS, IndexMetric.DOCS, IndexMetric.STORE))
                    + "\"eggplant\":{\"type\":\"integer\"}}}}}"
            .cluster()
            .indexMetrics(Set.of(IndexMetric.DOCS))
            Set.of(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName()),
        assertEquals(expectedNodesRoles, Set.of(getNodeRoles(client, 0), getNodeRoles(client, 1)));
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(randomBoolean()).get();
                case ANALYSIS:
        assertShardStats(response.getIndicesStats().getShards(), 1, 2, 2, 0.0);
        // these can be -1 if not supported on platform
    public void testValuesSmokeScreenWithNodeStatsAndIndicesStatsMetricsFilter() throws IOException, ExecutionException,
                )
        int masterRoleCount,
            .build();
        }
public class ClusterStatsIT extends OpenSearchIntegTestCase {
    }
                    DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName()
        long used = 0;
        expectedCounts.put(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(), clusterManagerRoleCount);
            .useAggregatedNodeLevelResponses(randomBoolean())
        assertThat(response.getIndicesStats().getShards().getMaxIndexReplication(), Matchers.equalTo(1.0));
            waitForNodes(total);
                case FIELDDATA:
            .computeAllMetrics(false)
        assertEquals(
 * under the License.
            if (isRemoteClusterClientNode) {
            .cluster()
import org.opensearch.common.settings.Settings;
        assertThat(msg, response.nodesStats.getFs().getTotal().getBytes(), Matchers.greaterThan(0L));
            .indexMetrics(Set.of(IndexMetric.FIELDDATA, IndexMetric.SHARDS, IndexMetric.SEGMENTS, IndexMetric.DOCS, IndexMetric.STORE))
/*
        Client client = client();
        assertEquals(expectedRoles, getNodeRoles(client, 0));
import org.opensearch.test.OpenSearchIntegTestCase;
            .put("node.ingest", false)
            DiscoveryNodeRole.MASTER_ROLE.roleName(),
            assertEquals(path.getFileCacheReserved(), new ByteSizeValue(16, ByteSizeUnit.GB));
        assertNotNull(statsResponseWithSpecificIndicesMetrics);
        ClusterStatsResponse response = client().admin()
            if (isDataNode) {
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
        assertThat(response.indicesStats.getIndexCount(), Matchers.equalTo(1));
        Set<String> expectedRoles = Set.of(
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
    }
            .useAggregatedNodeLevelResponses(randomBoolean())
import org.opensearch.Version;
    public void testNodeRolesWithMasterLegacySettings() throws ExecutionException, InterruptedException {
        // 0 happens when not supported on platform
        int total = 2;
                "{\"properties\":{\"foo\":{\"type\": \"keyword\"},\"bar\":{\"properties\":{\"baz\":{\"type\":\"keyword\"},"
            .requestMetrics(Set.of(Metric.FS))
                    break;
            } else {
        long total = 0;
            .requestMetrics(Set.of(Metric.INDICES))
                assertNotNull(object);
        index("test1", "type", "1", "f", "f");
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getDocs().getCount());
                    object = clusterStatsResponse.getNodesStats().getProcess();
        assertNotNull(statsResponseWarmFSMetrics.getNodesStats());
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
                incrementCountForRole(DiscoveryNodeRole.MASTER_ROLE.roleName(), expectedCounts);
        ensureGreen();
            .put("node.master", true)
            .get();
 *
    public void testClusterStatsWithIndexMetricWithDocsFilter() throws IOException {
        validateIndicesStatsOutput(
        waitForNodes(total);
        prepareCreate("test2").setSettings(Settings.builder().put("number_of_shards", 3).put("number_of_replicas", 0)).get();
 * not use this file except in compliance with the License.
                case SEGMENTS:
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        internalCluster().startNode();
                    break;
        assertThat(response.indicesStats.getIndexCount(), Matchers.equalTo(2));
        refresh(); // make the doc visible
            .cluster()
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
 */
        internalCluster().startNodes(legacySeedDataNodeSettings);
    }
            .build();
            .requestMetrics(Set.of(Metric.INDICES))
        expectedCounts.put(DiscoveryNodeRole.WARM_ROLE.roleName(), warmRoleCount);
                    break;
        client().admin().indices().prepareCreate("test1").setMapping("{\"properties\":{\"foo\":{\"type\": \"keyword\"}}}").get();
            .computeAllMetrics(false)
        assertThat(stats.getPrimaries(), Matchers.equalTo(primaries));
            .requestMetrics(Set.of(Metric.OS, Metric.FS, Metric.INDICES))
        assertThat(msg, response.getTimestamp(), Matchers.greaterThan(946681200000L)); // 1 Jan 2000
        ClusterStatsResponse response = client().admin()
        assertEquals(msg, OsStats.calculatePercentage(free, total), response.nodesStats.getOs().getMem().getFreePercent());
        Set<IndexFeatureStats> stats = response.getIndicesStats().getMappings().getFieldTypeStats();
        FsInfo warmFsInfo = statsResponseWarmFSMetrics.getNodes()
            if (isIngestNode) {
        assertNotNull(statsResponseWithAllIndicesMetrics.getIndicesStats());
                    break;
            .getNode()
                    object = clusterStatsResponse.getIndicesStats().getShards();
            } else if (stat.getName().equals("object")) {
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getShards().getIndices());
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getDocs().getDeleted());
                    "%s, %s",
            response.getNodesStats().getCounts().getRoles(),
        assertNotNull(response.getNodesStats());
            .get();
        assertNotNull(statsResponseWithAllIndicesMetrics);
            }
        ensureGreen();
            DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName(),
            .map(DiscoveryNodeRole::roleName)
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getStore().getSizeInBytes());
        internalCluster().startNodes(legacyMasterSettings);
        assertEquals(expectedRoles, getNodeRoles(client, 0));
        ensureGreen();
            boolean isClusterManagerNode = randomBoolean();
                    object = clusterStatsResponse.getIndicesStats().getDocs();
    public void testClusterStatsWithNodeMetricsFilter() {
            }
        int total = 1;
        assertNull(statsResponseWithAllNodeStatsMetrics.getIndicesStats());
                assertThat(stat.getCount(), greaterThanOrEqualTo(1));
        internalCluster().startNode();
            .computeAllMetrics(false)
            .get();
    protected boolean addMockIndexStorePlugin() {
        index("test1", "type", "1", "f", "f");
 * Licensed to Elasticsearch under one or more contributor
        assertShardStats(response.getIndicesStats().getShards(), 2, 7, 5, 2.0 / 5);
        assertNotNull(statsResponseWithAllNodeStatsMetrics);
            statsResponseWithAllIndicesMetrics
        ClusterStatsResponse clusterStatsResponse = client.admin()
        assertEquals(expectedRoles, getNodeRoles(client, 0));
        internalCluster().startClusterManagerOnlyNodes(1);
    }
    }
            .get();
 * Unless required by applicable law or agreed to in writing,
                )
        assertThat(response.getIndicesStats().getShards().getAvgIndexShards(), Matchers.equalTo(3.5));
            .useAggregatedNodeLevelResponses(randomBoolean())
            .setMapping(
        internalCluster().startNode();
 *
        assertThat(msg, response.nodesStats.getProcess().getAvgOpenFileDescriptors(), Matchers.greaterThanOrEqualTo(0L));
        assertEquals(response.getIndicesStats().getMappings(), statsResponseWithSpecificIndicesMetrics.getIndicesStats().getMappings());
                case QUERY_CACHE:
        );
        InterruptedException {
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
        Set<Set<String>> expectedNodesRoles = Set.of(
import java.util.HashMap;
            .useAggregatedNodeLevelResponses(randomBoolean());
            assertEquals(path.getTotal(), new ByteSizeValue(16 * 5, ByteSizeUnit.GB));
        client().admin().indices().prepareCreate("test1").setMapping("{\"properties\":{\"foo\":{\"type\": \"keyword\"}}}").get();
            .put("node.data", true)
        internalCluster().startClusterManagerOnlyNode(
        waitForNodes(total);
    }
        assertThat(msg, response.nodesStats.getVersions().contains(Version.CURRENT), Matchers.equalTo(true));
        ensureGreen();
            }
        waitForNodes(1);
            .prepareClusterStats()
            .stream()
            .prepareClusterStats()
            if (isDataNode) {
            .get();
 * this file be licensed under the Apache-2.0 license or a
            .useAggregatedNodeLevelResponses(randomBoolean())
                    break;
        assertThat(msg, response.nodesStats.getJvm().getVersions().size(), Matchers.greaterThan(0));
            }
            }
        waitForNodes(total);
            .prepareClusterStats()
    public void testFieldTypesWithMappingsFilter() {
                roles.add(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE);
        assertThat(msg, response.nodesStats.getProcess().count, Matchers.greaterThan(0));
            .stream()
        assertThat(msg, response.nodesStats.getProcess().getMinOpenFileDescriptors(), Matchers.greaterThanOrEqualTo(-1L));
    }
    ) {
                assertThat(stat.getCount(), greaterThanOrEqualTo(1));
        );
        Settings legacyMasterSettings = Settings.builder()
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.Metric;
        assertThat(msg, response.nodesStats.getFs().getTotal().getBytes(), Matchers.greaterThan(0L));
                roles.add(DiscoveryNodeRole.INGEST_ROLE);
                assertNull(object);
import org.opensearch.gateway.GatewayService;
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, Integer> expectedCounts = getExpectedCounts(0, 1, 1, 0, 1, 0, 0, 0);
        Map<String, Integer> expectedCounts = getExpectedCounts(1, 1, 1, 1, 1, 0, 0, 0);
            .put("node.ingest", false)
        assertEquals(response.getIndicesStats().getIndexCount(), statsResponseWithAllIndicesMetrics.getIndicesStats().getIndexCount());
import org.opensearch.monitor.fs.FsInfo;
        assertTrue(clusterStatsRequestBuilder.request().computeAllMetrics());
            }
        assertNotNull(response);
    @Override
        Settings legacySeedDataNodeSettings = Settings.builder()
        assertNotNull(response.getNodesStats());
    }
 * ownership. Elasticsearch licenses this file to you under
            .cluster()
        assertNull(statsResponseWithIndicesRequestMetrics.getNodesStats());
        Set<IndexFeatureStats> stats = response.getIndicesStats().getMappings().getFieldTypeStats();
        assertThat(response.getIndicesStats().getMappings().getFieldTypeStats().size(), equalTo(3));
        ClusterStatsResponse response = clusterStatsRequestBuilder.get();
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(false).get();
            .get(nodeNumber)
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
    private void validateNodeStatsOutput(Set<ClusterStatsRequest.Metric> expectedMetrics, ClusterStatsResponse clusterStatsResponse) {
            .get();
        if (count == null) {
            .prepareClusterStats()
            .get();
            .put("node.data", true)
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
        prepareCreate("test1").setSettings(Settings.builder().put("number_of_shards", 2).put("number_of_replicas", 1)).get();
        int warmRoleCount,
        internalCluster().startNode();
        ensureGreen();
            if (isRemoteClusterClientNode) {
                assertThat(stat.getCount(), greaterThanOrEqualTo(1));
            .useAggregatedNodeLevelResponses(randomBoolean())
        ClusterStatsResponse statsResponseWithAllIndicesMetrics = client().admin()
        client().admin()
 */
        assertNotNull(response.getIndicesStats());
        Client client = client();
        Map<String, Integer> expectedRoleCounts = getExpectedCounts(1, 1, 1, 0, 1, 0, 0, 0);
            .get();
                    + "\"eggplant\":{\"type\":\"integer\"}}}}}"
import java.util.Set;
        } else {
            free += nodeStats.getOs().getMem().getFree().getBytes();
        assertThat(actionGet.isTimedOut(), is(false));
        ensureGreen();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
            response = client().admin().cluster().prepareClusterStats().get();
        assertThat(response.getIndicesStats().getShards().getAvgIndexShards(), Matchers.equalTo(3.5));
        assertEquals(msg, OsStats.calculatePercentage(used, total), response.nodesStats.getOs().getMem().getUsedPercent());
            .prepareClusterStats()
        ensureGreen();
        assertNotNull(response.getNodesStats());
        assertNotNull(statsResponseWithSpecificIndicesMetrics.getIndicesStats());
import org.opensearch.monitor.os.OsStats;
        client().index(indexRequest);
 * The OpenSearch Contributors require contributions made to
    private void assertCounts(ClusterStatsNodes.Counts counts, int total, Map<String, Integer> roles) {
        ClusterHealthResponse actionGet = client().admin()
        assertEquals(
            .put(super.nodeSettings(nodeOrdinal))
        assertCounts(clusterStatsResponse.getNodesStats().getCounts(), total, expectedRoleCounts);
            .collect(Collectors.toSet());
        assertNotNull(response);
        assertThat(response.indicesStats.getDocs().getCount(), Matchers.equalTo(0L));
    }
            .cluster()
            assertCounts(response.getNodesStats().getCounts(), total, expectedCounts);
            }
            .get();
            .prepareClusterStats()
import java.util.stream.Collectors;
        IndexRequest indexRequest = new IndexRequest("test1").id("doc_id").source(Map.of("test_type", "metrics_filter"));
import org.opensearch.core.common.unit.ByteSizeUnit;
            .cluster()
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.IndexMetric;
        for (Metric metric : NodeMetrics) {
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getSegments().getVersionMapMemoryInBytes());
        ClusterStatsResponse response = clusterStatsRequestBuilder.get();
        assertNotNull(statsResponseWithAllIndicesMetrics.getIndicesStats());
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
        internalCluster().startNode();
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            .get();
                    object = clusterStatsResponse.getNodesStats().getFs();
        Set<String> expectedRoles = Set.of(
            .cluster()
            .cluster()
        for (FsInfo.Path path : warmFsInfo) {
            .useAggregatedNodeLevelResponses(randomBoolean())
        validateIndicesStatsOutput(
        assertThat(response.getIndicesStats().getShards().getMinIndexReplication(), Matchers.equalTo(0.0));
            .get();
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        waitForNodes(total);
            .prepareClusterStats()
import static org.hamcrest.Matchers.equalTo;
        assertNotNull(response.getIndicesStats());
        );
    }
            response.getIndicesStats().getShards().getPrimaries(),
                    break;
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.RED));
        assertThat(stats.getReplication(), Matchers.equalTo(replicationFactor));
    }
            .cluster()
        ensureGreen();
        expectedCounts.put(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName(), remoteClusterClientRoleCount);
        ClusterStatsResponse response = client.admin()
        refresh(); // make the doc visible
            .prepareCreate("test2")
            .get();
            .build();
            .get();
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(true).get();
        Set<String> expectedRoles = Set.of(DiscoveryNodeRole.MASTER_ROLE.roleName());
            .prepareClusterStats()
        Map<String, Integer> expectedCounts = new HashMap<>();
        internalCluster().startNodes(clusterManagerNodeRoleSettings);
        index("test1", "type", "1", "f", "f");
    }
        assertNotNull(response);
    public void testClusterStatusWhenStateNotRecovered() throws Exception {
        assertEquals(response.getNodesStats().getVersions(), statsResponseWithAllNodeStatsMetrics.getNodesStats().getVersions());
        Map<String, Integer> expectedRoleCounts = getExpectedCounts(1, 1, 1, 0, 1, 0, 0, 0);
    public void testWarmNodeFSStats() {
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(false).get();
        assertEquals(response.getIndicesStats().getFieldData(), statsResponseWithAllIndicesMetrics.getIndicesStats().getFieldData());
            .useAggregatedNodeLevelResponses(randomBoolean())
                    object = clusterStatsResponse.getNodesStats().getOs();
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        }
        client().index(indexRequest);
    @Override
        NodesStatsResponse nodesStatsResponse = client.admin().cluster().nodesStats(new NodesStatsRequest()).get();
        assertThat(response.getIndicesStats().getShards().getAvgIndexReplication(), Matchers.equalTo(0.5));
            Object object = null;
        internalCluster().startNode();
        assertNull(statsResponseWithAllIndicesMetrics.getNodesStats());
    private static void incrementCountForRole(String role, Map<String, Integer> counts) {
        assertTrue(response.getIndicesStats().getMappings().getFieldTypeStats().isEmpty());
            .prepareClusterStats()
            counts.put(role, ++count);
import java.util.Map;
                    object = clusterStatsResponse.getNodesStats().getJvm();
            .get();
            response.getIndicesStats().getShards().getTotal(),
    public void testIndicesShardStatsWithoutNodeLevelAggregations() {
            .put("node.master", true)
        assertThat(msg, response.getTimestamp(), Matchers.greaterThan(946681200000L)); // 1 Jan 2000
        client().admin()
import java.util.Collections;
        prepareCreate("test1").setSettings(Settings.builder().put("number_of_shards", 2).put("number_of_replicas", 1)).get();
        Client client = client();
            .get();
        Client client = client();
            .get();
            .useAggregatedNodeLevelResponses(randomBoolean())
        long free = 0;
            .map(nodeResponse -> nodeResponse.nodeStats().getFs())
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getDocs().getDeleted());
        ClusterStatsRequestBuilder clusterStatsRequestBuilder = client().admin()
        for (IndexMetric indexMetric : IndexMetric.values()) {
        Set<Set<String>> expectedNodesRoles = Set.of(
import org.opensearch.common.Priority;
            .requestMetrics(Set.of(Metric.INDICES))
            .prepareClusterStats()
        assertEquals(msg, free, response.nodesStats.getOs().getMem().getFree().getBytes());
        assertThat(response.getIndicesStats().getShards().getMinIndexPrimaryShards(), Matchers.equalTo(2));
import org.opensearch.action.index.IndexRequest;
        assertThat(msg, response.nodesStats.getProcess().getMaxOpenFileDescriptors(), Matchers.greaterThanOrEqualTo(-1L));
            .prepareClusterStats()
        client().admin().indices().prepareCreate("test1").setMapping("{\"properties\":{\"foo\":{\"type\": \"keyword\"}}}").get();
        validateNodeStatsOutput(Set.of(Metric.FS, Metric.OS), statsResponseWithAllIndicesMetrics);
                    break;
            statsResponseWithAllIndicesMetrics.getIndicesStats().getShards().getTotal()
 * license agreements. See the NOTICE file distributed with
        assertThat(msg, response.nodesStats.getPlugins().size(), Matchers.greaterThanOrEqualTo(0));
            .useAggregatedNodeLevelResponses(randomBoolean())
                    break;
        // add another node, replicas should get assigned
            .prepareClusterStats()
        );
        Client client = client();
            response.getNodesStats().getCounts().getTotal(),
        );
            DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName()
            final Set<DiscoveryNodeRole> roles = new HashSet<>();
 * SPDX-License-Identifier: Apache-2.0
                roles.add(DiscoveryNodeRole.DATA_ROLE);
        internalCluster().startSearchOnlyNode();
        );
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getShards().getPrimaries());
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getSegments().getCount());
            .health(Requests.clusterHealthRequest().waitForEvents(Priority.LANGUID).waitForNodes(Integer.toString(numNodes)))
        Settings clusterManagerNodeRoleSettings = Settings.builder()
        int dataRoleCount,
            .cluster()
        assertThat(msg, response.nodesStats.getProcess().getAvgOpenFileDescriptors(), Matchers.greaterThanOrEqualTo(0L));
 *
                    object = clusterStatsResponse.getIndicesStats().getStore();
import org.hamcrest.Matchers;
                .putList(
        IndexRequest indexRequest = new IndexRequest("test1").id("doc_id").source(Map.of("test_type", "metrics_filter"));
        // start one node with 7 processors.
            .put("node.ingest", false)
        assertEquals(
            .useAggregatedNodeLevelResponses(randomBoolean());
            .cluster()
        Settings settings = Settings.builder()
            statsResponseWithAllIndicesMetrics.getIndicesStats().getShards().getPrimaries()
            .prepareClusterStats()
            .prepareClusterStats()
        assertNotNull(statsResponseWithAllIndicesMetrics);
import org.opensearch.core.common.unit.ByteSizeValue;
            .put(
        assertThat(response.getIndicesStats().getShards().getMaxIndexShards(), Matchers.equalTo(4));
            switch (metric) {
        client().admin().indices().prepareCreate("test1").setMapping("{\"properties\":{\"foo\":{\"type\": \"keyword\"}}}").get();
        ClusterStatsResponse response = client().admin()
            )
        assertThat(stats.getIndices(), Matchers.equalTo(indices));
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.OS;
        client().prepareIndex("test1").setId(Integer.toString(1)).setSource("field1", "value1").execute().actionGet();
import java.io.IOException;
        Set<String> expectedRoles = Set.of(
/*
                assertThat(stat.getCount(), greaterThanOrEqualTo(3));
import java.util.concurrent.ExecutionException;
        assertEquals(msg, total, response.nodesStats.getOs().getMem().getTotal().getBytes());
            Set.of(DiscoveryNodeRole.DATA_ROLE.roleName(), DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName())
            Settings.builder().put(GatewayService.RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 2).build()
            switch (indexMetric) {
        createIndex("test1");
        validateIndicesStatsOutput(Set.of(IndexMetric.MAPPINGS, IndexMetric.ANALYSIS), statsResponseWithSpecificIndicesMetrics);
        internalCluster().startNode(Settings.builder().put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 7).build());
        ClusterStatsResponse response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(false).get();
        index("test1", "type", "1", "f", "f");
        internalCluster().startClusterManagerOnlyNode();
                    object = clusterStatsResponse.getIndicesStats().getMappings();
        }
        ClusterStatsResponse clusterStatsResponse = client.admin()
            .get();
        assertTrue(response.getIndicesStats().getMappings().getFieldTypeStats().isEmpty());
        assertThat(response.getIndicesStats().getShards().getMaxIndexReplication(), Matchers.equalTo(1.0));
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(true).get();
        assertNotNull(statsResponseWarmFSMetrics);
            used += nodeStats.getOs().getMem().getUsed().getBytes();
    }
        ClusterStatsResponse statsResponseWithAllIndicesMetrics = client().admin()
                case PROCESS:
        assertThat(msg, response.nodesStats.getVersions().size(), Matchers.greaterThan(0));
        // 0 happens when not supported on platform
import java.util.HashSet;
            .computeAllMetrics(randomBoolean())
    }
                    object = clusterStatsResponse.getIndicesStats().getCompletion();
            total += nodeStats.getOs().getMem().getTotal().getBytes();
    public void testNodeRolesWithSeedDataNodeLegacySettings() throws ExecutionException, InterruptedException {
        assertTrue(statsResponseWithAllIndicesMetrics.getIndicesStats().getDocs().getAverageSizeInBytes() > 0);
        assertThat(response.getIndicesStats().getShards().getMaxIndexPrimaryShards(), Matchers.equalTo(3));
        assertNotNull(statsResponseWithAllIndicesMetrics.getIndicesStats());
                "node.roles",
import org.opensearch.node.NodeRoleSettings;
        assertEquals(2, statsResponseWithAllIndicesMetrics.getIndicesStats().getDocs().getCount());
        Settings legacyDataNodeSettings = Settings.builder()
            .put("node.data", false)
            Set.of(IndexMetric.FIELDDATA, IndexMetric.SHARDS, IndexMetric.SEGMENTS, IndexMetric.DOCS, IndexMetric.STORE),
        int remoteClusterClientRoleCount,
import org.opensearch.transport.client.Requests;
            Object object = null;
        ClusterStatsResponse statsResponseWithIndicesRequestMetrics = client().admin()
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            .indexMetrics(Set.of(IndexMetric.MAPPINGS, IndexMetric.ANALYSIS))
        }
        for (IndexFeatureStats stat : stats) {
            .cluster()
                incrementCountForRole(DiscoveryNodeRole.INGEST_ROLE.roleName(), expectedCounts);
            if (stat.getName().equals("integer")) {
            .build();
        assertEquals(msg, free, response.nodesStats.getOs().getMem().getFree().getBytes());
                    break;
                assertNull(object);
            .indexMetrics(Set.of(IndexMetric.MAPPINGS))
            if (isClusterManagerNode) {
import org.opensearch.cluster.health.ClusterHealthStatus;
        assertThat(response.getIndicesStats().getShards().getAvgIndexPrimaryShards(), Matchers.equalTo(2.5));
            }
        internalCluster().startNode(settings);
            .cluster()
            free += nodeStats.getOs().getMem().getFree().getBytes();
            .prepareClusterStats()
                    Locale.ROOT,
                    object = clusterStatsResponse.getIndicesStats().getQueryCache();
            }
    public void testNodeRolesWithDataNodeLegacySettings() throws ExecutionException, InterruptedException {
            .computeAllMetrics(false)
                case DOCS:
        return Settings.builder()
            .useAggregatedNodeLevelResponses(randomBoolean())
        int searchRoleCount,
            .cluster()
    public void testClusterStatsWithMappingsAndAnalysisStatsIndexMetricsFilter() {
            .requestMetrics(Set.of(Metric.OS, Metric.FS, Metric.INDICES))
        ClusterStatsResponse statsResponseWarmFSMetrics = client().admin()
            .requestMetrics(Set.of(Metric.INDICES))
        return false;
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getShards().getTotal());
                incrementCountForRole(ClusterStatsNodes.Counts.COORDINATING_ONLY, expectedCounts);
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.YELLOW));
        ClusterStatsResponse response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(true).get();
            .cluster()
        waitForNodes(total);
        assertEquals(msg, used, response.nodesStats.getOs().getMem().getUsed().getBytes());
        assertThat(response.getIndicesStats().getShards().getMaxIndexPrimaryShards(), Matchers.equalTo(3));
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getFieldData().getEvictions());
                    object = clusterStatsResponse.getNodesStats().getPlugins();
            .computeAllMetrics(false)
            .useAggregatedNodeLevelResponses(randomBoolean());
 * compatible open source license.
    private Set<String> getNodeRoles(Client client, int nodeNumber) throws ExecutionException, InterruptedException {
 * specific language governing permissions and limitations
            .build();
            .useAggregatedNodeLevelResponses(randomBoolean());
        );
        assertThat(msg, response.nodesStats.getProcess().getMaxOpenFileDescriptors(), Matchers.greaterThanOrEqualTo(-1L));
