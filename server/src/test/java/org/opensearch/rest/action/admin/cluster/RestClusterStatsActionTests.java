        for (ClusterStatsRequest.Metric metric : ClusterStatsRequest.Metric.values()) {
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
        assertFalse(clusterStatsRequest.indicesMetrics().isEmpty());
 * this file be licensed under the Apache-2.0 license or a
        final IllegalArgumentException e = expectThrows(
    public void setUp() throws Exception {
import org.opensearch.transport.client.node.NodeClient;
            ClusterStatsRequest.Metric.INDICES
        );
        assertFalse(clusterStatsRequest.computeAllMetrics());
        assertEquals(3, clusterStatsRequest.requestedMetrics().size());
package org.opensearch.rest.action.admin.cluster;
        assertTrue(clusterStatsRequest.useAggregatedNodeLevelResponses());
            hasToString(containsString("request [/_cluster/stats] contains _all and individual index metrics [_all," + indexMetric + "]"))
    }
import static org.hamcrest.object.HasToString.hasToString;
import org.opensearch.test.OpenSearchTestCase;
    public void testUnrecognizedIndexMetric() {
        Set<ClusterStatsRequest.Metric> metricsRequested = Set.of(ClusterStatsRequest.Metric.OS, ClusterStatsRequest.Metric.FS);
    }
    }
        final IllegalArgumentException e = expectThrows(
        assertNotNull(clusterStatsRequest.indicesMetrics());
/*
    }
        final IllegalArgumentException e = expectThrows(
        assertFalse(clusterStatsRequest.requestedMetrics().isEmpty());
        assertTrue(clusterStatsRequest.useAggregatedNodeLevelResponses());
    }
        assertFalse(clusterStatsRequest.computeAllMetrics());
        params.put("metric", "_all,");
        action = new RestClusterStatsAction();
    public void testAllIndexMetricsRequestWithOtherIndicesMetric() {
        ClusterStatsRequest clusterStatsRequest = RestClusterStatsAction.fromRequest(request);
        params.put("metric", "_all,");
            IllegalArgumentException.class,
    public void testUnrecognizedMetric() {
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
        assertThat(e, hasToString(containsString("request [/_cluster/stats] contains unrecognized index metric: [" + indexMetric + "]")));
    public void testFromRequestWithIndicesStatsMetricsFilter() {
        );
        final IllegalArgumentException e = expectThrows(
import static org.mockito.Mockito.mock;
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
        assertThat(
    public void testAllMetricsRequestWithOtherMetric() {
            e,
        assertEquals(2, clusterStatsRequest.requestedMetrics().size());
        assertTrue(clusterStatsRequest.useAggregatedNodeLevelResponses());
public class RestClusterStatsActionTests extends OpenSearchTestCase {
        params.put("index_metric", indexMetric);
            () -> action.prepareRequest(request, mock(NodeClient.class))
        assertTrue(clusterStatsRequest.indicesMetrics().isEmpty());
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
    public void testFromRequestBasePath() {
            ClusterStatsRequest.Metric.OS,
        );
        );
            .collect(Collectors.joining(","));
        assertFalse(clusterStatsRequest.computeAllMetrics());
            hasToString(
        params.put("metric", "os");
        params.put("metric", metric);
        super.setUp();
        final HashMap<String, String> params = new HashMap<>();
        ClusterStatsRequest clusterStatsRequest = RestClusterStatsAction.fromRequest(request);
        String indicesMetricParam = indicesMetricsRequested.stream()
            () -> action.prepareRequest(request, mock(NodeClient.class))
            ClusterStatsRequest.IndexMetric.SEGMENTS
 *
        params.put("metric", metricParam);
    private RestClusterStatsAction action;
        assertNotNull(clusterStatsRequest);
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
            ClusterStatsRequest.Metric.FS,
        assertThat(e, hasToString(containsString("request [/_cluster/stats] contains unrecognized metric: [" + metric + "]")));
        final HashMap<String, String> params = new HashMap<>();
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
        }
        final HashMap<String, String> params = new HashMap<>();
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest;
            .map(ClusterStatsRequest.IndexMetric::metricName)
        params.put("index_metric", indexMetric);
                containsString("request [/_cluster/stats] contains index metrics [" + indexMetric + "] but indices stats not requested")
        final String metric = randomAlphaOfLength(64);
        assertEquals(indicesMetricsRequested, clusterStatsRequest.indicesMetrics());
        Set<ClusterStatsRequest.Metric> metricsRequested = Set.of(
            assertTrue(clusterStatsRequest.indicesMetrics().contains(indexMetric));
        final String indexMetric = randomSubsetOf(1, RestClusterStatsAction.INDEX_METRIC_TO_REQUEST_CONSUMER_MAP.keySet()).get(0);
 * SPDX-License-Identifier: Apache-2.0
        final HashMap<String, String> params = new HashMap<>();
        String metricParam = metricsRequested.stream().map(ClusterStatsRequest.Metric::metricName).collect(Collectors.joining(","));
            IllegalArgumentException.class,
import org.opensearch.test.rest.FakeRestRequest;
        assertThat(e, hasToString(containsString("request [/_cluster/stats] contains _all and individual metrics [_all," + metric + "]")));
    }
        assertEquals(metricsRequested, clusterStatsRequest.requestedMetrics());
    }
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
        final IllegalArgumentException e = expectThrows(
        assertFalse(clusterStatsRequest.requestedMetrics().isEmpty());
        assertEquals(2, clusterStatsRequest.indicesMetrics().size());
    }
import java.util.HashMap;
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_cluster/stats").withParams(params).build();
            () -> action.prepareRequest(request, mock(NodeClient.class))
            )
        assertNotNull(clusterStatsRequest.requestedMetrics());
        );
        params.put("metric", "_all," + metric);
        assertNotNull(clusterStatsRequest);
        params.put("index_metric", "_all," + indexMetric);
            e,
    public void testIndexMetricsRequestWithoutMetricIndices() {
        params.put("index_metric", indicesMetricParam);
            ClusterStatsRequest.IndexMetric.SHARDS,
        String metricParam = metricsRequested.stream().map(ClusterStatsRequest.Metric::metricName).collect(Collectors.joining(","));
            IllegalArgumentException.class,
}
        assertFalse(clusterStatsRequest.requestedMetrics().isEmpty());
        for (ClusterStatsRequest.IndexMetric indexMetric : ClusterStatsRequest.IndexMetric.values()) {
        final HashMap<String, String> params = new HashMap<>();
            IllegalArgumentException.class,
import org.opensearch.rest.RestRequest;
import java.util.Set;
        final HashMap<String, String> params = new HashMap<>();
 * compatible open source license.
 */
        assertNotNull(clusterStatsRequest);
        final String indexMetric = randomAlphaOfLength(64);
        assertThat(
        ClusterStatsRequest clusterStatsRequest = RestClusterStatsAction.fromRequest(request);
        );
    public void testFromRequestWithNodeStatsMetricsFilter() {
        );
        assertFalse(clusterStatsRequest.indicesMetrics().isEmpty());
        final String metric = randomSubsetOf(1, RestClusterStatsAction.METRIC_REQUEST_CONSUMER_MAP.keySet()).get(0);
            IllegalArgumentException.class,
        final String indexMetric = randomSubsetOf(1, RestClusterStatsAction.INDEX_METRIC_TO_REQUEST_CONSUMER_MAP.keySet()).get(0);
            () -> action.prepareRequest(request, mock(NodeClient.class))
        Set<ClusterStatsRequest.IndexMetric> indicesMetricsRequested = Set.of(
 * The OpenSearch Contributors require contributions made to
            assertTrue(clusterStatsRequest.requestedMetrics().contains(metric));
import java.util.stream.Collectors;
        );
        final HashMap<String, String> params = new HashMap<>();
        );
        params.put("metric", metricParam);
        assertEquals(metricsRequested, clusterStatsRequest.requestedMetrics());
    }
    @Override
import static org.hamcrest.CoreMatchers.containsString;
        final HashMap<String, String> params = new HashMap<>();
            () -> action.prepareRequest(request, mock(NodeClient.class))
        }
