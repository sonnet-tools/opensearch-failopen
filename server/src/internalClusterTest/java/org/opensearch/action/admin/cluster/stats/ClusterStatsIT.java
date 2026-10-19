 * specific language governing permissions and limitations
            }  
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));  
        assertThat(msg, response.nodesStats.getFs().getTotal().getBytes(), Matchers.greaterThan(0L));  
            if (!isDataNode && !isClusterManagerNode && !isIngestNode && !isRemoteClusterClientNode) {
            .prepareClusterStats()  
        ClusterStatsResponse statsResponseWithAllIndicesMetrics = client().admin()  
            } else {  
        assertEquals(
            .prepareClusterStats()
            .cluster()
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        assertEquals(msg, OsStats.calculatePercentage(free, total), response.nodesStats.getOs().getMem().getFreePercent());
        ClusterStatsRequestBuilder clusterStatsRequestBuilder = client().admin()
        );
    }
                    object = clusterStatsResponse.getNodesStats().getPlugins();
import org.opensearch.transport.client.Client;  
        assertEquals(msg, total, response.nodesStats.getOs().getMem().getTotal().getBytes());
        ClusterStatsResponse response = clusterStatsRequestBuilder.get();
            .put("node.ingest", false)
    private Map<String, Integer> getExpectedCounts(
        assertNotNull(response.getNodesStats());  
            Set.of(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName()),
    }
            response.getNodesStats().getCounts().getTotal(),
        internalCluster().startNodes(legacyDataNodeSettings);
        assertShardStats(response.getIndicesStats().getShards(), 1, 4, 2, 1.0);  
        assertThat(msg, response.nodesStats.getVersions().contains(Version.CURRENT), Matchers.equalTo(true));
    }
        assertNotNull(statsResponseWithSpecificIndicesMetrics);
                incrementCountForRole(ClusterStatsNodes.Counts.COORDINATING_ONLY, expectedCounts);
            assertEquals(path.getTotal(), new ByteSizeValue(16 * 5, ByteSizeUnit.GB));
 *
        assertThat(response.getIndicesStats().getMappings().getFieldTypeStats().size(), equalTo(3));
        ClusterStatsResponse response = client().admin()
        assertThat(response.getIndicesStats().getShards().getAvgIndexShards(), Matchers.equalTo(3.5));  
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.YELLOW));
        internalCluster().startNode(Settings.builder().put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 7).build());
            .cluster()  
    public void testClusterStatsWithNodeMetricsFilter() {  
            .prepareClusterStats()
/*  
        assertNotNull(statsResponseWithAllIndicesMetrics);
            .useAggregatedNodeLevelResponses(randomBoolean())
            if (isDataNode) {
            statsResponseWithAllIndicesMetrics
        assertThat(msg, response.nodesStats.getProcess().getMinOpenFileDescriptors(), Matchers.greaterThanOrEqualTo(-1L));
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getSegments().getIndexWriterMemoryInBytes());  
        assertThat(msg, response.nodesStats.getProcess().getMaxOpenFileDescriptors(), Matchers.greaterThanOrEqualTo(-1L));  
        ensureGreen();
            .prepareClusterStats()
        return nodesStatsResponse.getNodes()
        assertEquals(expectedNodesRoles, Set.of(getNodeRoles(client, 0), getNodeRoles(client, 1)));
                assertNotNull(object);
        );  
            .get();
            .useAggregatedNodeLevelResponses(randomBoolean());  
        expectedCounts.put(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName(), remoteClusterClientRoleCount);
        assertEquals(
            .put("node.ingest", false)
        assertEquals(2, statsResponseWithAllIndicesMetrics.getIndicesStats().getDocs().getCount());  
                case PROCESS:  
        // Ingest, network types, discovery types and packaging types stats are not included here as they don't have a get method exposed.
    }
        // these can be -1 if not supported on platform  
            .get();
            boolean isClusterManagerNode = randomBoolean();
        Map<String, Integer> expectedRoleCounts = getExpectedCounts(0, 1, 1, 0, 0, 0, 1, 0);
        client().index(indexRequest);
        ClusterStatsResponse response = client().admin()  
        // 0 happens when not supported on platform
            Object object = null;
            if (stat.getName().equals("integer")) {
            .computeAllMetrics(randomBoolean())  
        assertThat(response.indicesStats.getIndexCount(), Matchers.equalTo(2));  
                    object = clusterStatsResponse.getNodesStats().getProcess();
            response.getIndicesStats().getShards().getPrimaries(),
        // 0 happens when not supported on platform
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
        Set<String> expectedRoles = Set.of(DiscoveryNodeRole.MASTER_ROLE.roleName());
        assertThat(response.getIndicesStats().getShards().getMaxIndexPrimaryShards(), Matchers.equalTo(3));
        assertEquals(new ByteSizeValue(0), statsResponseWithAllIndicesMetrics.getIndicesStats().getFieldData().getMemorySize());
        refresh(); // make the doc visible
        int ingestRoleCount,
        assertEquals(msg, free, response.nodesStats.getOs().getMem().getFree().getBytes());
        assertNotNull(statsResponseWithAllNodeStatsMetrics.getNodesStats());
            .prepareClusterStats()
        assertEquals(
    public void testClusterStatsWithMappingsAndAnalysisStatsIndexMetricsFilter() {
        ClusterStatsResponse response = client().admin()
    public void testClusterStatsWithIndicesOnlyMetricsFilter() {
 */  
            .requestMetrics(Set.of(Metric.INDICES))  
        assertThat(msg, response.nodesStats.getPlugins().size(), Matchers.greaterThanOrEqualTo(0));
        ClusterStatsResponse statsResponseWithAllNodeStatsMetrics = client().admin()
        assertThat(response.getNodesStats().getOs().getAllocatedProcessors(), equalTo(7));  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            .computeAllMetrics(false)
        internalCluster().startNode();
            .useAggregatedNodeLevelResponses(randomBoolean())
            .requestMetrics(Set.of(Metric.FS))
import java.util.Set;
            }
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getDocs().getCount());  
            if (expectedMetrics.contains(metric)) {
            .indexMetrics(Set.of(IndexMetric.DOCS))
    private static void incrementCountForRole(String role, Map<String, Integer> counts) {  
    }  
            .actionGet();  
                roles.add(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE);  
 * KIND, either express or implied.  See the License for the
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getStore().getSizeInBytes());  
        internalCluster().startClusterManagerOnlyNode(
            } else if (stat.getName().equals("object")) {
        // start one node with 7 processors.  
        ClusterStatsResponse response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(false).get();
        );
            total += nodeStats.getOs().getMem().getTotal().getBytes();
            .prepareCreate("test2")
            .get();  
        assertThat(response.getIndicesStats().getShards().getAvgIndexReplication(), Matchers.equalTo(0.5));
            response.getNodesStats().getCounts().getRoles(),  
        assertThat(msg, response.indicesStats.getStore().getSizeInBytes(), Matchers.greaterThan(0L));
            .get();  
            .prepareClusterStats()  
        expectedCounts.put(DiscoveryNodeRole.WARM_ROLE.roleName(), warmRoleCount);
        internalCluster().startWarmOnlyNodes(1);  
        int warmRoleCount,
                incrementCountForRole(DiscoveryNodeRole.MASTER_ROLE.roleName(), expectedCounts);
        assertEquals(response.getIndicesStats().getMappings(), statsResponseWithSpecificIndicesMetrics.getIndicesStats().getMappings());  
import org.opensearch.monitor.os.OsStats;  
            }  
        String msg = response.toString();
        long used = 0;
        ClusterStatsResponse response = clusterStatsRequestBuilder.get();
            .prepareClusterStats()  
        assertEquals(msg, OsStats.calculatePercentage(used, total), response.nodesStats.getOs().getMem().getUsedPercent());
import java.util.Collections;
            .get();
        ClusterStatsResponse statsResponseWarmFSMetrics = client().admin()  
                case SEGMENTS:
            .get();
        // these can be -1 if not supported on platform
import org.opensearch.core.common.unit.ByteSizeValue;  
        assertNotNull(response.getNodesStats());  
            .useAggregatedNodeLevelResponses(randomBoolean())  
        client().admin()
            .prepareClusterStats()
                case SHARDS:
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.YELLOW));
        ensureGreen();  
        );  
 * compatible open source license.
        assertNotNull(statsResponseWithAllIndicesMetrics.getNodesStats());
            .get();
            total += nodeStats.getOs().getMem().getTotal().getBytes();  
        assertEquals(msg, used, response.nodesStats.getOs().getMem().getUsed().getBytes());  
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getSegments().getVersionMapMemoryInBytes());
        if (count == null) {
            DiscoveryNodeRole.DATA_ROLE.roleName()
        validateNodeStatsOutput(Set.of(Metric.FS), statsResponseWarmFSMetrics);  
                assertThat(stat.getCount(), greaterThanOrEqualTo(3));
            .get();
        assertThat(msg, response.getTimestamp(), Matchers.greaterThan(946681200000L)); // 1 Jan 2000
        assertThat(msg, response.getTimestamp(), Matchers.greaterThan(946681200000L)); // 1 Jan 2000  
        assertThat(counts.getRoles(), equalTo(roles));
import org.opensearch.common.settings.Settings;  
            .cluster()
                )  
        assertNotNull(response);
 * not use this file except in compliance with the License.
        assertThat(msg, response.nodesStats.getProcess().getMinOpenFileDescriptors(), Matchers.greaterThanOrEqualTo(-1L));
        assertShardStats(response.getIndicesStats().getShards(), 1, 2, 2, 0.0);
        client().admin().indices().prepareCreate("test1").setMapping("{\"properties\":{\"foo\":{\"type\": \"keyword\"}}}").get();  
            .computeAllMetrics(false)  
        internalCluster().startNode();
import java.io.IOException;
            .indices()  
            }  
        IndexRequest indexRequest = new IndexRequest("test1").id("doc_id").source(Map.of("test_type", "metrics_filter"));  
        // can't start data-only node without assigning cluster-manager  
                case FS:  
        validateNodeStatsOutput(ClusterStatsNodes.NODE_STATS_METRICS, statsResponseWithAllNodeStatsMetrics);  
            boolean isRemoteClusterClientNode = false;  
            .useAggregatedNodeLevelResponses(randomBoolean());
        assertEquals(response.getIndicesStats().getFieldData(), statsResponseWithAllIndicesMetrics.getIndicesStats().getFieldData());
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
        int numNodes = randomIntBetween(1, 5);
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getSegments().getCount());
        ensureGreen();
        assertThat(response.indicesStats.getIndexCount(), Matchers.equalTo(2));
        internalCluster().startNodes(legacyMasterSettings);
            Object object = null;
        internalCluster().startNode();
            .cluster()
        assertEquals(response.getNodesStats().getVersions(), statsResponseWithAllNodeStatsMetrics.getNodesStats().getVersions());  
    }
            .cluster()
        );  
            }
import org.opensearch.node.Node;
 *  
            }
        assertThat(msg, response.nodesStats.getVersions().size(), Matchers.greaterThan(0));  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            }  
                case ANALYSIS:
        refreshAndWaitForReplication();
        Set<String> expectedRoles = Set.of(
        );
        assertNotNull(statsResponseWithAllIndicesMetrics.getIndicesStats());
            .prepareClusterStats()
        String msg = response.toString();
            .collect(Collectors.toSet());
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(false).get();  
        int coordinatingOnlyCount  
            .cluster()
        internalCluster().startNodes(randomIntBetween(1, 3));
        return expectedCounts;
        ClusterStatsRequestBuilder clusterStatsRequestBuilder = client().admin()  
            .indexMetrics(Set.of(IndexMetric.MAPPINGS, IndexMetric.ANALYSIS))
            .prepareClusterStats()
                    object = clusterStatsResponse.getNodesStats().getJvm();
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                case COMPLETION:
            .prepareClusterStats()
            if (isIngestNode) {
        for (IndexFeatureStats stat : stats) {  
                    object = clusterStatsResponse.getIndicesStats().getFieldData();
        int total = 1;  
        ClusterStatsResponse response = client.admin()
        assertThat(response.indicesStats.getIndexCount(), Matchers.equalTo(1));
        client().index(indexRequest);
            Settings.builder().put(GatewayService.RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 2).build()
        assertThat(response.getIndicesStats().getShards().getMinIndexPrimaryShards(), Matchers.equalTo(2));  
        InterruptedException {
        Settings clusterManagerNodeRoleSettings = Settings.builder()  
        assertThat(msg, response.nodesStats.getJvm().getVersions().size(), Matchers.greaterThan(0));
            waitForNodes(total);
    public void testClusterStatsWithSelectiveMetricsFilterAndNoIndex() {
            .build();  
            .get();
        waitForNodes(total);
                case QUERY_CACHE:
        );
    }
        validateIndicesStatsOutput(Set.of(IndexMetric.DOCS), statsResponseWithAllIndicesMetrics);
        int remoteClusterClientRoleCount,  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 *
                )
                    object = clusterStatsResponse.getIndicesStats().getAnalysis();
        assertNull(statsResponseWithSpecificIndicesMetrics.getNodesStats());
    public void testNodeCountsWithDeprecatedMasterRole() throws ExecutionException, InterruptedException {
    public void testIndicesShardStatsWithoutNodeLevelAggregations() {
            .requestMetrics(Set.of(Metric.INDICES))
        ClusterStatsRequestBuilder clusterStatsRequestBuilder = client().admin()
    protected Settings nodeSettings(int nodeOrdinal) {
    }
            )
        for (NodeStats nodeStats : nodesStatsResponse.getNodes()) {
            statsResponseWithAllIndicesMetrics.getIndicesStats().getShards().getPrimaries()  
        prepareCreate("test2").setSettings(Settings.builder().put("number_of_shards", 3).put("number_of_replicas", 0)).get();
        internalCluster().startNodes(clusterManagerNodeRoleSettings);  
                    break;
                case JVM:  
        assertEquals(response.getNodesStats().getPlugins(), statsResponseWithAllNodeStatsMetrics.getNodesStats().getPlugins());
            .findFirst()
    private void waitForNodes(int numNodes) {
import org.opensearch.Version;
        ClusterStatsResponse clusterStatsResponse = client.admin()  
        client().prepareIndex("test1").setId(Integer.toString(2)).setSource("field2", "value2").execute().actionGet();  
            .computeAllMetrics(false)  
        }  
        assertEquals(response.getIndicesStats().getIndexCount(), statsResponseWithSpecificIndicesMetrics.getIndicesStats().getIndexCount());
            }
        Map<String, Integer> expectedCounts = getExpectedCounts(0, 1, 1, 0, 0, 0, 0, 0);
            .computeAllMetrics(false)
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));  
        expectedCounts.put(DiscoveryNodeRole.INGEST_ROLE.roleName(), ingestRoleCount);  
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(true).get();  
        int total = 2;
                    object = clusterStatsResponse.getIndicesStats().getQueryCache();
            counts.put(role, 1);  
        assertThat(response.getIndicesStats().getShards().getMaxIndexReplication(), Matchers.equalTo(1.0));
            used += nodeStats.getOs().getMem().getUsed().getBytes();  
        ClusterStatsRequestBuilder clusterStatsRequestBuilder = client().admin()  
        ClusterStatsResponse statsResponseWithIndicesRequestMetrics = client().admin()  
        expectedCounts.put(DiscoveryNodeRole.MASTER_ROLE.roleName(), masterRoleCount);
                incrementCountForRole(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName(), expectedCounts);
            .useAggregatedNodeLevelResponses(randomBoolean())  
    public void testClusterStatusWhenStateNotRecovered() throws Exception {  
        for (int i = 0; i < numNodes; i++) {
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        client().admin().indices().prepareCreate("test1").setMapping("{\"properties\":{\"foo\":{\"type\": \"keyword\"}}}").get();
        assertThat(response.indicesStats.getDocs().getCount(), Matchers.equalTo(0L));  
        assertThat(response.getIndicesStats().getShards().getAvgIndexReplication(), Matchers.equalTo(0.5));
                incrementCountForRole(DiscoveryNodeRole.DATA_ROLE.roleName(), expectedCounts);
        assertThat(msg, response.nodesStats.getPlugins().size(), Matchers.greaterThanOrEqualTo(0));
            statsResponseWithAllIndicesMetrics
            .prepareClusterStats()
                assertThat(stat.getCount(), greaterThanOrEqualTo(1));
        int total = 1;
            .get();  
            switch (indexMetric) {  
        assertThat(msg, response.nodesStats.getProcess().getAvgOpenFileDescriptors(), Matchers.greaterThanOrEqualTo(0L));  
                    object = clusterStatsResponse.getIndicesStats().getCompletion();
    @Override
        client().admin().indices().prepareCreate("test1").setMapping("{\"properties\":{\"foo\":{\"type\": \"keyword\"}}}").get();  
        validateIndicesStatsOutput(  
                    object = clusterStatsResponse.getIndicesStats().getSegments();
        Map<String, Integer> expectedRoleCounts = getExpectedCounts(1, 1, 1, 0, 1, 0, 0, 0);
    public void testFieldTypes() {
        expectedCounts.put(DiscoveryNodeRole.DATA_ROLE.roleName(), dataRoleCount);  
            .get(nodeNumber)
import java.util.concurrent.ExecutionException;
/*  
    public void testClusterStatsWithSelectiveNodeMetricAndIndexMetricsFilter() {
                "{\"properties\":{\"foo\":{\"type\": \"keyword\"},\"bar\":{\"properties\":{\"baz\":{\"type\":\"keyword\"},"  
            boolean isDataNode = randomBoolean();  
            if (isRemoteClusterClientNode) {
    private void assertCounts(ClusterStatsNodes.Counts counts, int total, Map<String, Integer> roles) {  
        assertThat(response.getIndicesStats().getShards().getMinIndexReplication(), Matchers.equalTo(0.0));
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(randomBoolean()).get();  
        Settings legacySeedDataNodeSettings = Settings.builder()
 * GitHub history for details.
        assertNotNull(statsResponseWithAllIndicesMetrics);
        assertTrue(response.getIndicesStats().getMappings().getFieldTypeStats().isEmpty());
            .cluster()
            .useAggregatedNodeLevelResponses(randomBoolean())  
        assertEquals(msg, total, response.nodesStats.getOs().getMem().getTotal().getBytes());  
            .get();
        assertThat(counts.getTotal(), equalTo(total));
            .cluster()
        assertThat(response.indicesStats.getDocs().getCount(), Matchers.equalTo(0L));
        internalCluster().startNode();  
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(false).get();
        Set<ClusterStatsRequest.IndexMetric> expectedMetrics,
                assertNull(object);
        waitForNodes(total);
                    break;
        assertEquals(msg, OsStats.calculatePercentage(used, total), response.nodesStats.getOs().getMem().getUsedPercent());
        } else {
    public void testFieldTypesWithMappingsFilter() {
            .useAggregatedNodeLevelResponses(randomBoolean())  
        assertThat(stats.getTotal(), Matchers.equalTo(total));
                    break;  
            if (stat.getName().equals("integer")) {
    }
        assertThat(msg, response.nodesStats.getJvm().getVersions().size(), Matchers.greaterThan(0));  
        assertThat(response.indicesStats.getIndexCount(), Matchers.equalTo(1));  
        assertThat(response.getIndicesStats().getShards().getMaxIndexPrimaryShards(), Matchers.equalTo(3));
            .stream()
            free += nodeStats.getOs().getMem().getFree().getBytes();
    }
            .orElseThrow(() -> new IllegalStateException("No warm node found"));  
        client().prepareIndex("test1").setId(Integer.toString(1)).setSource("field1", "value1").execute().actionGet();
        internalCluster().startNode();
    }
        int dataRoleCount,
            assertEquals(path.getFileCacheReserved(), new ByteSizeValue(16, ByteSizeUnit.GB));
    }
        validateNodeStatsOutput(Set.of(Metric.FS, Metric.OS), statsResponseWithAllIndicesMetrics);
        expectedCounts.put(DiscoveryNodeRole.SEARCH_ROLE.roleName(), searchRoleCount);  
                assertThat(stat.getCount(), greaterThanOrEqualTo(1));
        assertNotNull(statsResponseWarmFSMetrics.getNodesStats());
            .health(Requests.clusterHealthRequest().waitForEvents(Priority.LANGUID).waitForNodes(Integer.toString(numNodes)))
        assertThat(response.getIndicesStats().getShards().getMaxIndexReplication(), Matchers.equalTo(1.0));  
                .build();
            )
        internalCluster().startNode();  
            Set.of(DiscoveryNodeRole.DATA_ROLE.roleName(), DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName())
        assertThat(msg, response.nodesStats.getFs().getTotal().getBytes(), Matchers.greaterThan(0L));
        ClusterStatsResponse clusterStatsResponse = client.admin()
            .useAggregatedNodeLevelResponses(randomBoolean())
            .prepareClusterStats()
            .get();
    }
        assertEquals(new ByteSizeValue(0), statsResponseWithAllIndicesMetrics.getIndicesStats().getStore().getReservedSize());
        assertThat(response.getIndicesStats().getShards().getMinIndexReplication(), Matchers.equalTo(0.0));  
 */
            .requestMetrics(Set.of(Metric.OS, Metric.FS, Metric.INDICES))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        ensureGreen();
            }
        internalCluster().startNode();
            DiscoveryNodeRole.MASTER_ROLE.roleName(),
        long total = 0;  
            .useAggregatedNodeLevelResponses(randomBoolean())  
    }
    }  
        waitForNodes(total);  
        internalCluster().startNode();
                case FIELDDATA:
            .put("node.master", true)  
    }  
            .cluster()
        assertNotNull(statsResponseWithAllIndicesMetrics);
            .cluster()
import org.opensearch.action.index.IndexRequest;
        ensureGreen();
                    DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(),  
        assertEquals(expectedRoles, getNodeRoles(client, 0));
        int total = 2;
        int searchRoleCount,
            .requestMetrics(ClusterStatsNodes.NODE_STATS_METRICS)  
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getDocs().getDeleted());
 * this work for additional information regarding copyright
        waitForNodes(total);
        assertThat(response.getIndicesStats().getMappings().getFieldTypeStats().size(), equalTo(3));
            statsResponseWithAllIndicesMetrics.getIndicesStats().getShards().getTotal()
                    NodeRoleSettings.NODE_ROLES_SETTING.getKey(),
}  
        assertThat(msg, response.nodesStats.getVersions().size(), Matchers.greaterThan(0));
/*
                assertThat(stat.getCount(), greaterThanOrEqualTo(1));  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            .cluster()  
                    break;
        assertThat(response.getIndicesStats().getShards().getMinIndexPrimaryShards(), Matchers.equalTo(2));
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(true).get();
            .prepareClusterStats()
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
            .stream()
            .get();  
        ensureGreen();
        assertEquals(expectedRoles, getNodeRoles(client, 0));
                assertNull(object);
                    break;
    public void testIndicesShardStatsWithNodeLevelAggregations() {
                    Locale.ROOT,
        assertEquals(msg, OsStats.calculatePercentage(free, total), response.nodesStats.getOs().getMem().getFreePercent());  
        assertEquals(msg, used, response.nodesStats.getOs().getMem().getUsed().getBytes());
    @Override  
            used += nodeStats.getOs().getMem().getUsed().getBytes();
            .prepareClusterStats()  
            .cluster()
    public void testClusterStatsWithIndexMetricWithDocsFilter() throws IOException {
        ensureGreen();  
import org.opensearch.gateway.GatewayService;
import java.util.Locale;
        FsInfo warmFsInfo = statsResponseWarmFSMetrics.getNodes()
        internalCluster().startSearchOnlyNode();
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getShards().getTotal());
import org.opensearch.transport.client.Requests;
            .put(
        assertThat(response.getIndicesStats().getShards().getAvgIndexPrimaryShards(), Matchers.equalTo(2.5));  
                    DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName()
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
        ClusterStatsResponse response = clusterStatsRequestBuilder.get();  
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getDocs().getTotalSizeInBytes());
    }
        long free = 0;
        Map<String, Integer> expectedRoleCounts = getExpectedCounts(1, 1, 1, 0, 1, 0, 0, 0);
        internalCluster().startNode();
    public void testNodeCounts() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        internalCluster().startClusterManagerOnlyNodes(1);
        assertThat(response.getIndicesStats().getShards().getMinIndexShards(), Matchers.equalTo(3));
        long free = 0;  
        waitForNodes(total);  
        assertShardStats(response.getIndicesStats().getShards(), 2, 7, 5, 2.0 / 5);
            } else {
        assertEquals(response.getIndicesStats().getIndexCount(), statsResponseWithAllIndicesMetrics.getIndicesStats().getIndexCount());
        Set<String> expectedRoles = Set.of(
        for (Metric metric : NodeMetrics) {  
            Set.of(IndexMetric.FIELDDATA, IndexMetric.SHARDS, IndexMetric.SEGMENTS, IndexMetric.DOCS, IndexMetric.STORE),  
                    + "\"eggplant\":{\"type\":\"integer\"}}}}}"
        prepareCreate("test2").setSettings(Settings.builder().put("number_of_shards", 3).put("number_of_replicas", 0)).get();
    }
    private Set<String> getNodeRoles(Client client, int nodeNumber) throws ExecutionException, InterruptedException {
 * SPDX-License-Identifier: Apache-2.0
        index("test1", "type", "1", "f", "f");  
        }  
                    break;  
        assertNotNull(statsResponseWithIndicesRequestMetrics);
        NodesStatsResponse nodesStatsResponse = client().admin().cluster().prepareNodesStats().addMetric(OS.metricName()).get();
        validateIndicesStatsOutput(
        validateNodeStatsOutput(Set.of(Metric.FS, Metric.OS), statsResponseWithAllIndicesMetrics);
 * under the License.  
                    break;  
        IndexRequest indexRequest = new IndexRequest("test1").id("doc_id").source(Map.of("test_type", "metrics_filter"));
            .put("node.data", true)  
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.OS;
        internalCluster().startClusterManagerOnlyNode();
        assertNotNull(statsResponseWithAllIndicesMetrics.getNodesStats());  
            .get();
        ClusterHealthResponse actionGet = client().admin()  
        expectedCounts.put(ClusterStatsNodes.Counts.COORDINATING_ONLY, coordinatingOnlyCount);
import java.util.Map;  
        Map<String, Integer> expectedCounts = getExpectedCounts(1, 1, 1, 1, 1, 0, 0, 0);
            assertCounts(response.getNodesStats().getCounts(), total, expectedCounts);  
        index("test1", "type", "1", "f", "f");
            .indexMetrics(Set.of(IndexMetric.MAPPINGS))
        for (NodeStats nodeStats : nodesStatsResponse.getNodes()) {  
        assertNotNull(response.getIndicesStats());  
        int total = 1;  
            Set.of(DiscoveryNodeRole.SEARCH_ROLE.roleName())
            .cluster()
        assertThat(msg, response.indicesStats.getStore().getSizeInBytes(), Matchers.greaterThan(0L));  
        for (FsInfo.Path path : warmFsInfo) {
        assertShardStats(response.getIndicesStats().getShards(), 2, 7, 5, 2.0 / 5);  
        // wait for the cluster status to settle
        assertEquals(expectedRoles, getNodeRoles(client, 0));  
        Settings settings = Settings.builder()
            }
            .filter(nodeResponse -> nodeResponse.getNode().isWarmNode())  
        ClusterStatsResponse response = client().admin()
 * license agreements. See the NOTICE file distributed with
                    object = clusterStatsResponse.getIndicesStats().getDocs();
                    roles.stream().map(DiscoveryNodeRole::roleName).collect(Collectors.toList())
        );  
        assertCounts(clusterStatsResponse.getNodesStats().getCounts(), total, expectedCounts);
        internalCluster().startNode();
            assertEquals(path.getPath(), "/warm");  
        assertThat(response.getIndicesStats().getShards().getAvgIndexPrimaryShards(), Matchers.equalTo(2.5));
        internalCluster().startNodes(legacySeedDataNodeSettings);
        assertShardStats(response.getIndicesStats().getShards(), 1, 4, 2, 1.0);
            DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName()  
        }  
        Set<Metric> NodeMetrics = Set.of(Metric.OS, Metric.JVM, Metric.FS, Metric.PROCESS, Metric.PLUGINS);
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.IndexMetric;  
    private void validateIndicesStatsOutput(  
        Client client = client();  
            .cluster()
import org.hamcrest.Matchers;
        assertThat(response.getIndicesStats().getShards().getMaxIndexShards(), Matchers.equalTo(4));
        waitForNodes(total);
        internalCluster().startNode();  
            counts.put(role, ++count);
        Client client = client();
            .cluster()
        prepareCreate("test1").setSettings(Settings.builder().put("number_of_shards", 2).put("number_of_replicas", 1)).get();
            .prepareCreate("test2")  
import static org.hamcrest.Matchers.equalTo;  
            .useAggregatedNodeLevelResponses(randomBoolean())
    public void testNodeRolesWithSeedDataNodeLegacySettings() throws ExecutionException, InterruptedException {
        ClusterStatsResponse response = client().admin()
            .get();  
            .map(DiscoveryNodeRole::roleName)  
        assertNotNull(statsResponseWithAllNodeStatsMetrics);  
            DiscoveryNodeRole.MASTER_ROLE.roleName(),  
            .indexMetrics(Set.of(IndexMetric.FIELDDATA, IndexMetric.SHARDS, IndexMetric.SEGMENTS, IndexMetric.DOCS, IndexMetric.STORE))
        ensureGreen();
        assertNotNull(response.getNodesStats());
            statsResponseWithAllNodeStatsMetrics.getNodesStats().getCounts().getRoles()
    }
                    break;  
        assertTrue(clusterStatsRequestBuilder.request().computeAllMetrics());
            .put("node.data", false)
        assertTrue(statsResponseWithAllIndicesMetrics.getIndicesStats().getDocs().getAverageSizeInBytes() > 0);
            free += nodeStats.getOs().getMem().getFree().getBytes();
            .map(nodeResponse -> nodeResponse.nodeStats().getFs())
        assertEquals(msg, free, response.nodesStats.getOs().getMem().getFree().getBytes());
                String.format(  
        assertEquals(expectedRoles, getNodeRoles(client, 0));
                    break;
        ClusterStatsResponse statsResponseWithSpecificIndicesMetrics = client().admin()
            .indexMetrics(Set.of(IndexMetric.values()))
        }
        ClusterStatsResponse response = client().admin()
import java.util.stream.Collectors;  
        assertNotNull(response);
            DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(),
        assertTrue(clusterStatsRequestBuilder.request().computeAllMetrics());
                incrementCountForRole(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(), expectedCounts);
        long total = 0;
            Set.of(IndexMetric.FIELDDATA, IndexMetric.SHARDS, IndexMetric.SEGMENTS, IndexMetric.DOCS, IndexMetric.STORE),
        Set<Set<String>> expectedNodesRoles = Set.of(  
    public void testAllocatedProcessors() throws Exception {
            .useAggregatedNodeLevelResponses(randomBoolean())
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.Metric;
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(stats.getPrimaries(), Matchers.equalTo(primaries));  
    }
        assertThat(stats.getIndices(), Matchers.equalTo(indices));
        assertTrue(response.getIndicesStats().getMappings().getFieldTypeStats().isEmpty());
        assertNull(statsResponseWithAllIndicesMetrics.getNodesStats());  
        assertNull(statsResponseWithAllIndicesMetrics.getIndicesStats().getFieldData().getFields());
        assertEquals(response.getIndicesStats().getAnalysis(), statsResponseWithSpecificIndicesMetrics.getIndicesStats().getAnalysis());
        ensureGreen();  
        );
                "node.roles",
                case PLUGINS:  
                    break;  
        assertThat(response.indicesStats.getDocs().getCount(), Matchers.equalTo(1L));
    public void testNodeRolesWithMasterLegacySettings() throws ExecutionException, InterruptedException {  
        ensureGreen();
        client().admin().indices().prepareCreate("test1").setMapping("{\"properties\":{\"foo\":{\"type\": \"keyword\"}}}").get();
        assertShardStats(response.getIndicesStats().getShards(), 1, 2, 2, 0.0);
                incrementCountForRole(DiscoveryNodeRole.INGEST_ROLE.roleName(), expectedCounts);
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
            .useAggregatedNodeLevelResponses(randomBoolean())
import org.opensearch.cluster.health.ClusterHealthStatus;  
            }
            .computeAllMetrics(false)
            .cluster()
        assertThat(msg, response.nodesStats.getProcess().count, Matchers.greaterThan(0));  
            .get();  
            .computeAllMetrics(false)
            .getNode()  
                assertThat(stat.getCount(), greaterThanOrEqualTo(3));
    }  
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        assertNotNull(statsResponseWithSpecificIndicesMetrics.getIndicesStats());  
 * the Apache License, Version 2.0 (the "License"); you may
            .requestMetrics(Set.of(Metric.values()))
        Set<IndexFeatureStats> stats = response.getIndicesStats().getMappings().getFieldTypeStats();  
            .build();
        assertThat(response.indicesStats.getDocs().getCount(), Matchers.equalTo(1L));
        assertCounts(clusterStatsResponse.getNodesStats().getCounts(), total, expectedCounts);
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getDocs().getDeleted());
        assertNotNull(response.getIndicesStats());  
        Map<String, Integer> expectedCounts = getExpectedCounts(0, 1, 1, 0, 1, 0, 0, 0);
                case MAPPINGS:
        ensureGreen();
            .cluster()
        assertNotNull(statsResponseWithAllIndicesMetrics.getIndicesStats());  
import org.opensearch.common.Priority;
        assertNull(statsResponseWithIndicesRequestMetrics.getNodesStats());  
        assertThat(msg, response.nodesStats.getProcess().count, Matchers.greaterThan(0));
            if (isDataNode) {  
        internalCluster().startNode(settings);
            .cluster()  
        Integer count = counts.get(role);
        NodesStatsResponse nodesStatsResponse = client.admin().cluster().nodesStats(new NodesStatsRequest()).get();  
                    object = clusterStatsResponse.getNodesStats().getOs();
            .prepareClusterStats()
                    object = clusterStatsResponse.getIndicesStats().getMappings();
import org.opensearch.test.OpenSearchIntegTestCase;  
    ) {  
 * this file be licensed under the Apache-2.0 license or a
            boolean isIngestNode = randomBoolean();
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
                    break;  
                    "%s, %s",
            .build();
        client().admin()
            .prepareClusterStats()  
        validateIndicesStatsOutput(Set.of(IndexMetric.values()), statsResponseWithIndicesRequestMetrics);
        ensureGreen();  
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getFieldData().getEvictions());  
        prepareCreate("test1").setSettings(Settings.builder().put("number_of_shards", 2).put("number_of_replicas", 1)).get();
            .cluster()  
            .useAggregatedNodeLevelResponses(randomBoolean())
                    + "\"eggplant\":{\"type\":\"integer\"}}}}}"  
        assertTrue(clusterStatsRequestBuilder.request().computeAllMetrics());
            .cluster()  
        Set<IndexFeatureStats> stats = response.getIndicesStats().getMappings().getFieldTypeStats();
        internalCluster().startNode();  
            .computeAllMetrics(false)  
                "{\"properties\":{\"foo\":{\"type\": \"keyword\"},\"bar\":{\"properties\":{\"baz\":{\"type\":\"keyword\"},"
                    object = clusterStatsResponse.getIndicesStats().getShards();
    }
        Settings legacyDataNodeSettings = Settings.builder()  
            .setMapping(
            .build();
                    break;  
            } else if (stat.getName().equals("keyword")) {  
                roles.add(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);  
        assertCounts(clusterStatsResponse.getNodesStats().getCounts(), total, expectedRoleCounts);  
        ClusterStatsResponse clusterStatsResponse = client.admin()
import static org.hamcrest.Matchers.is;
        return Settings.builder()  
        assertNotNull(response.getIndicesStats());
            .cluster()
        internalCluster().startDataOnlyNodes(2);
import org.opensearch.cluster.node.DiscoveryNodeRole;
        Map<String, Integer> expectedCounts = new HashMap<>();
    ) {
    private void validateNodeStatsOutput(Set<ClusterStatsRequest.Metric> expectedMetrics, ClusterStatsResponse clusterStatsResponse) {  
            .cluster()
            response.getIndicesStats().getShards().getTotal(),
            .prepareClusterStats()
        ClusterStatsResponse clusterStatsResponse = client.admin()
        }  
        assertThat(msg, response.nodesStats.getProcess().getMaxOpenFileDescriptors(), Matchers.greaterThanOrEqualTo(-1L));
    }  
        expectedCounts.put(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(), clusterManagerRoleCount);
            DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName(),
    protected boolean addMockIndexStorePlugin() {
        ClusterStatsResponse response = clusterStatsRequestBuilder.get();  
        assertCounts(response.getNodesStats().getCounts(), total, expectedCounts);  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(false).get();  
        createIndex("test1");  
            .indexMetrics(Set.of(IndexMetric.values()))
                case STORE:
            .build();  
            .prepareClusterStats()  
        internalCluster().startClusterManagerOnlyNodes(1);  
        assertNull(statsResponseWithAllNodeStatsMetrics.getIndicesStats());
            .useAggregatedNodeLevelResponses(randomBoolean());  
            .put("node.data", true)
        ClusterStatsResponse statsResponseWithAllIndicesMetrics = client().admin()
        Set<Set<String>> expectedNodesRoles = Set.of(
    public void testValuesSmokeScreenWithNodeStatsAndIndicesStatsMetricsFilter() throws IOException, ExecutionException,  
            .requestMetrics(Set.of(Metric.INDICES))
            .put("node.master", false)
                .putList(  
            .prepareClusterStats()  
            switch (metric) {
        assertThat(response.getStatus(), equalTo(ClusterHealthStatus.RED));  
 */  
            .useAggregatedNodeLevelResponses(randomBoolean())
            .computeAllMetrics(false)  
            Settings settings = Settings.builder()
        assertCounts(clusterStatsResponse.getNodesStats().getCounts(), total, expectedRoleCounts);  
            .getRoles()
            .indices()
        assertThat(response.getIndicesStats().getShards().getMinIndexShards(), Matchers.equalTo(3));
    }  
        assertNotNull(statsResponseWarmFSMetrics);
            } else if (stat.getName().equals("keyword")) {
    // Validate assigning value "master" to setting "node.roles" can get correct count in Node Stats response after MASTER_ROLE deprecated.
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            }
    private void assertShardStats(ClusterStatsIndices.ShardStats stats, int indices, int total, int primaries, double replicationFactor) {  
import org.opensearch.node.NodeRoleSettings;
            }
        int total = 1;
            .get();
        index("test1", "type", "1", "f", "f");  
            .prepareClusterStats()  
        int masterRoleCount,  
        assertNotNull(response.getIndicesStats());
        assertThat(msg, response.nodesStats.getProcess().getAvgOpenFileDescriptors(), Matchers.greaterThanOrEqualTo(0L));
            .putList(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), Collections.singletonList(DiscoveryNodeRole.MASTER_ROLE.roleName()))
            .cluster()  
            .useAggregatedNodeLevelResponses(randomBoolean())  
        assertThat(response.getIndicesStats().getShards().getAvgIndexShards(), Matchers.equalTo(3.5));
                    object = clusterStatsResponse.getIndicesStats().getStore();
    }
        }
        return false;  
                    break;  
                case DOCS:
            .useAggregatedNodeLevelResponses(randomBoolean())
        Settings legacyMasterSettings = Settings.builder()
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        // add another node, replicas should get assigned  
        ClusterStatsResponse clusterStatsResponse = client.admin()
        assertThat(actionGet.isTimedOut(), is(false));
        Set<String> expectedRoles = Set.of(  
    }  
                roles.add(DiscoveryNodeRole.DATA_ROLE);  
    }
            } else if (stat.getName().equals("object")) {  
            Set.of(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName()),  
            .get();  
            if (expectedMetrics.contains(indexMetric)) {
            response = client().admin().cluster().prepareClusterStats().get();
        assertThat(response.getIndicesStats().getShards().getMaxIndexShards(), Matchers.equalTo(4));  
        assertCounts(clusterStatsResponse.getNodesStats().getCounts(), total, expectedRoleCounts);
            .prepareClusterStats()
            statsResponseWithAllNodeStatsMetrics.getNodesStats().getCounts().getTotal()  
            .get();  
            }
            .build();  
        ClusterStatsResponse response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(true).get();
            .useAggregatedNodeLevelResponses(randomBoolean());
        }
        assertNotNull(statsResponseWithIndicesRequestMetrics.getIndicesStats());
            }  
        Map<String, Integer> expectedCounts = getExpectedCounts(0, 1, 1, 0, 1, 0, 0, 0);  
                    object = clusterStatsResponse.getNodesStats().getFs();
 * Unless required by applicable law or agreed to in writing,
                assertThat(stat.getCount(), greaterThanOrEqualTo(1));  
        );  
            .requestMetrics(Set.of(Metric.INDICES))
        ensureGreen();
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getShards().getIndices());  
        Client client = client();  
import java.util.HashSet;
import org.opensearch.monitor.fs.FsInfo;
                assertNotNull(object);  
        Client client = client();
    public void testNodeRolesWithClusterManagerRole() throws ExecutionException, InterruptedException {
        for (IndexMetric indexMetric : IndexMetric.values()) {
        refresh(); // make the doc visible
            .put(super.nodeSettings(nodeOrdinal))
                    break;  
            .useAggregatedNodeLevelResponses(randomBoolean())
        assertEquals(expectedNodesRoles, Set.of(getNodeRoles(client, 0), getNodeRoles(client, 1)));  
        internalCluster().startNodes(randomIntBetween(1, 3));  
        assertNotNull(response);
            .put("node.ingest", false)  
            if (isClusterManagerNode) {  
            DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE.roleName()
package org.opensearch.action.admin.cluster.stats;
    }
        client().admin().indices().prepareCreate("test1").setMapping("{\"properties\":{\"foo\":{\"type\": \"keyword\"}}}").get();
        );  
        ClusterStatsResponse statsResponseWithAllIndicesMetrics = client().admin()  
        internalCluster().startNode();  
            .requestMetrics(Set.of(Metric.OS, Metric.FS, Metric.INDICES))  
        long used = 0;
            .get();
            .cluster()  
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));  
import java.util.HashMap;  
            if (isRemoteClusterClientNode) {
        }  
            .useAggregatedNodeLevelResponses(randomBoolean())
        index("test1", "type", "1", "f", "f");
    }
    }
            .indexMetrics(Set.of(IndexMetric.FIELDDATA, IndexMetric.SHARDS, IndexMetric.SEGMENTS, IndexMetric.DOCS, IndexMetric.STORE))
    }  
        Client client = client();  
            if (isClusterManagerNode) {
        assertThat(msg, response.nodesStats.getVersions().contains(Version.CURRENT), Matchers.equalTo(true));  
 * You may obtain a copy of the License at  
            .prepareClusterStats()  
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(true).get();
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(response.getStatus(), Matchers.equalTo(ClusterHealthStatus.GREEN));
        assertNotNull(statsResponseWithAllIndicesMetrics.getIndicesStats());
            .get();
    public void testValuesSmokeScreen() throws IOException, ExecutionException, InterruptedException {
            .put("node.master", true)
        assertCounts(response.getNodesStats().getCounts(), total, expectedCounts);  
    public void testWarmNodeFSStats() {
        NodesStatsResponse nodesStatsResponse = client().admin().cluster().prepareNodesStats().addMetric(OS.metricName()).get();
            total++;  
        for (IndexFeatureStats stat : stats) {
            .useAggregatedNodeLevelResponses(randomBoolean())
import org.opensearch.core.common.unit.ByteSizeUnit;
        waitForNodes(1);
        assertTrue(clusterStatsRequestBuilder.request().computeAllMetrics());
        ensureGreen();  
        assertThat(stats.getReplication(), Matchers.equalTo(replicationFactor));
            internalCluster().startNode(settings);
        assertNotNull(response);
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(randomBoolean()).get();
        int total = 1;
        // add another node, replicas should get assigned
            )  
        validateIndicesStatsOutput(Set.of(IndexMetric.MAPPINGS, IndexMetric.ANALYSIS), statsResponseWithSpecificIndicesMetrics);
            .cluster()
        }
            .setMapping(
                roles.add(DiscoveryNodeRole.INGEST_ROLE);  
        ensureGreen();  
 * The OpenSearch Contributors require contributions made to  
public class ClusterStatsIT extends OpenSearchIntegTestCase {
        ClusterStatsResponse response = client().admin()
            .get();
                case OS:  
            .useAggregatedNodeLevelResponses(randomBoolean())
        );
        int clusterManagerRoleCount,
            .useAggregatedNodeLevelResponses(randomBoolean())
        client().admin().indices().prepareCreate("test1").setMapping("{\"properties\":{\"foo\":{\"type\": \"keyword\"}}}").get();
        assertNotNull(response.getNodesStats());
        response = client().admin().cluster().prepareClusterStats().useAggregatedNodeLevelResponses(randomBoolean()).get();  
            final Set<DiscoveryNodeRole> roles = new HashSet<>();
    public void testNodeRolesWithSearchNode() throws ExecutionException, InterruptedException {
        ClusterStatsResponse clusterStatsResponse
    public void testNodeRolesWithDataNodeLegacySettings() throws ExecutionException, InterruptedException {
        assertEquals(  
        Client client = client();
            .prepareClusterStats()
            if (isIngestNode) {  
        assertEquals(0, statsResponseWithAllIndicesMetrics.getIndicesStats().getShards().getPrimaries());
