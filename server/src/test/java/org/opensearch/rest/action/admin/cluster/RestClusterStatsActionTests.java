            IllegalArgumentException.class,
        String metricParam = metricsRequested.stream().map(ClusterStatsRequest.Metric::metricName).collect(Collectors.joining(","));
        params.put("metric", "_all," + metric);
        assertFalse(clusterStatsRequest.requestedMetrics().isEmpty());  
            IllegalArgumentException.class,  
            ClusterStatsRequest.Metric.FS,  
        final HashMap<String, String> params = new HashMap<>();
            () -> action.prepareRequest(request, mock(NodeClient.class))
import static org.mockito.Mockito.mock;
        for (ClusterStatsRequest.Metric metric : ClusterStatsRequest.Metric.values()) {
import java.util.HashMap;
    }
        final HashMap<String, String> params = new HashMap<>();  
        final IllegalArgumentException e = expectThrows(
        Set<ClusterStatsRequest.Metric> metricsRequested = Set.of(
        );  
        final HashMap<String, String> params = new HashMap<>();
    }
        assertEquals(2, clusterStatsRequest.requestedMetrics().size());
    public void testFromRequestBasePath() {
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
    }  
        params.put("metric", "_all,");
        assertEquals(metricsRequested, clusterStatsRequest.requestedMetrics());
        params.put("metric", "_all,");  
 * The OpenSearch Contributors require contributions made to  
        assertFalse(clusterStatsRequest.indicesMetrics().isEmpty());
        assertFalse(clusterStatsRequest.computeAllMetrics());
 *
import static org.hamcrest.object.HasToString.hasToString;  
            e,
        assertFalse(clusterStatsRequest.indicesMetrics().isEmpty());
        Set<ClusterStatsRequest.IndexMetric> indicesMetricsRequested = Set.of(  
        action = new RestClusterStatsAction();
        final IllegalArgumentException e = expectThrows(  
import org.opensearch.test.rest.FakeRestRequest;
        assertThat(
            ClusterStatsRequest.IndexMetric.SHARDS,
        assertNotNull(clusterStatsRequest.indicesMetrics());
        }
    public void testFromRequestWithIndicesStatsMetricsFilter() {  
        assertNotNull(clusterStatsRequest);
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();  
        );
        params.put("index_metric", indexMetric);
    @Override
            hasToString(
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
}
            () -> action.prepareRequest(request, mock(NodeClient.class))
        assertThat(e, hasToString(containsString("request [/_cluster/stats] contains unrecognized metric: [" + metric + "]")));  
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
        assertFalse(clusterStatsRequest.computeAllMetrics());
        final HashMap<String, String> params = new HashMap<>();
        final HashMap<String, String> params = new HashMap<>();
            ClusterStatsRequest.Metric.INDICES
        final String metric = randomAlphaOfLength(64);
        final String indexMetric = randomAlphaOfLength(64);  
 * this file be licensed under the Apache-2.0 license or a
        final IllegalArgumentException e = expectThrows(
    public void testFromRequestWithNodeStatsMetricsFilter() {
                containsString("request [/_cluster/stats] contains index metrics [" + indexMetric + "] but indices stats not requested")  
        }  
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest;
 * compatible open source license.
        ClusterStatsRequest clusterStatsRequest = RestClusterStatsAction.fromRequest(request);  
import org.opensearch.test.OpenSearchTestCase;  
        final HashMap<String, String> params = new HashMap<>();
        );
        final String indexMetric = randomSubsetOf(1, RestClusterStatsAction.INDEX_METRIC_TO_REQUEST_CONSUMER_MAP.keySet()).get(0);
package org.opensearch.rest.action.admin.cluster;
        final String metric = randomSubsetOf(1, RestClusterStatsAction.METRIC_REQUEST_CONSUMER_MAP.keySet()).get(0);  
        );
        assertNotNull(clusterStatsRequest);  
        assertFalse(clusterStatsRequest.computeAllMetrics());  
            () -> action.prepareRequest(request, mock(NodeClient.class))  
        );
            () -> action.prepareRequest(request, mock(NodeClient.class))
            ClusterStatsRequest.IndexMetric.SEGMENTS
        String indicesMetricParam = indicesMetricsRequested.stream()
        assertThat(  
            ClusterStatsRequest.Metric.OS,
        assertNotNull(clusterStatsRequest);
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();  
import java.util.Set;
    public void testUnrecognizedMetric() {  
        super.setUp();  
            assertTrue(clusterStatsRequest.requestedMetrics().contains(metric));
public class RestClusterStatsActionTests extends OpenSearchTestCase {  
            IllegalArgumentException.class,
        final HashMap<String, String> params = new HashMap<>();
            hasToString(containsString("request [/_cluster/stats] contains _all and individual index metrics [_all," + indexMetric + "]"))
        params.put("index_metric", indicesMetricParam);
    public void testUnrecognizedIndexMetric() {  
        final IllegalArgumentException e = expectThrows(  
    }  
            IllegalArgumentException.class,
        ClusterStatsRequest clusterStatsRequest = RestClusterStatsAction.fromRequest(request);
            e,  
        );  
        params.put("metric", "os");
import org.opensearch.rest.RestRequest;
        Set<ClusterStatsRequest.Metric> metricsRequested = Set.of(ClusterStatsRequest.Metric.OS, ClusterStatsRequest.Metric.FS);  
        String metricParam = metricsRequested.stream().map(ClusterStatsRequest.Metric::metricName).collect(Collectors.joining(","));
        assertEquals(metricsRequested, clusterStatsRequest.requestedMetrics());  
            assertTrue(clusterStatsRequest.indicesMetrics().contains(indexMetric));
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
        assertNotNull(clusterStatsRequest.requestedMetrics());
        assertTrue(clusterStatsRequest.useAggregatedNodeLevelResponses());  
            () -> action.prepareRequest(request, mock(NodeClient.class))
        assertTrue(clusterStatsRequest.useAggregatedNodeLevelResponses());
 * SPDX-License-Identifier: Apache-2.0
    }
    public void setUp() throws Exception {
        assertTrue(clusterStatsRequest.indicesMetrics().isEmpty());  
        params.put("metric", metric);  
        final String indexMetric = randomSubsetOf(1, RestClusterStatsAction.INDEX_METRIC_TO_REQUEST_CONSUMER_MAP.keySet()).get(0);
        params.put("metric", metricParam);  
        final IllegalArgumentException e = expectThrows(
        assertFalse(clusterStatsRequest.requestedMetrics().isEmpty());
        assertEquals(3, clusterStatsRequest.requestedMetrics().size());
import static org.hamcrest.CoreMatchers.containsString;
        );
        params.put("index_metric", "_all," + indexMetric);
    }
            .collect(Collectors.joining(","));
    }
 */  
        for (ClusterStatsRequest.IndexMetric indexMetric : ClusterStatsRequest.IndexMetric.values()) {  
        );  
        );
    public void testAllMetricsRequestWithOtherMetric() {
        final HashMap<String, String> params = new HashMap<>();
            .map(ClusterStatsRequest.IndexMetric::metricName)  
    public void testIndexMetricsRequestWithoutMetricIndices() {
    }
            )
    public void testAllIndexMetricsRequestWithOtherIndicesMetric() {
        assertThat(e, hasToString(containsString("request [/_cluster/stats] contains _all and individual metrics [_all," + metric + "]")));
        ClusterStatsRequest clusterStatsRequest = RestClusterStatsAction.fromRequest(request);
        params.put("metric", metricParam);  
    private RestClusterStatsAction action;
        assertEquals(2, clusterStatsRequest.indicesMetrics().size());
        assertThat(e, hasToString(containsString("request [/_cluster/stats] contains unrecognized index metric: [" + indexMetric + "]")));
    }  
        assertTrue(clusterStatsRequest.useAggregatedNodeLevelResponses());
        params.put("index_metric", indexMetric);  
/*  
        assertFalse(clusterStatsRequest.requestedMetrics().isEmpty());  
            IllegalArgumentException.class,  
        assertEquals(indicesMetricsRequested, clusterStatsRequest.indicesMetrics());  
import java.util.stream.Collectors;  
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
import org.opensearch.transport.client.node.NodeClient;
