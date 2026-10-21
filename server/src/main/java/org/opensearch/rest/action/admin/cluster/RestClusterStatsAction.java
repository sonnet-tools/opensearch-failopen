    ) {
        INDEX_METRIC_TO_REQUEST_CONSUMER_MAP = Collections.unmodifiableMap(metricMap);
                ? INDEX_METRIC_TO_REQUEST_CONSUMER_MAP.keySet()
        if (!metrics.contains(Metric.INDICES.metricName()) && !metrics.contains("_all") && !indexMetrics.isEmpty()) {
        return false;
    @Override
    static final Map<String, Consumer<ClusterStatsRequest>> METRIC_REQUEST_CONSUMER_MAP;
 * license agreements. See the NOTICE file distributed with
        }
 * Transport action to get cluster stats
            if (clusterStatsRequestConsumer != null) {
 * compatible open source license.
    static final Map<String, Consumer<ClusterStatsRequest>> INDEX_METRIC_TO_REQUEST_CONSUMER_MAP;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.IndexMetric;
        METRIC_REQUEST_CONSUMER_MAP = Collections.unmodifiableMap(metricRequestConsumerMap);
                    request.path(),
        paramValidations(metrics, indexMetrics, request);
        if (indexMetrics.size() > 1 && indexMetrics.contains("_all")) {
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest;
        clusterStatsRequest.computeAllMetrics(false);
        final Set<String> invalidMetrics = new TreeSet<>();
 * Unless required by applicable law or agreed to in writing,
import java.util.TreeSet;
                    Locale.ROOT,
import java.util.Collections;
        String indicesMetricsDefaultValue = metrics.contains(Metric.INDICES.metricName()) || metrics.contains("_all") ? "_all" : null;
                )
        }
    }
        Map<String, Consumer<ClusterStatsRequest>> metricRequestConsumerMap = new HashMap<>();
import java.util.function.Consumer;
 * this file be licensed under the Apache-2.0 license or a
 *
                unrecognizedStrings(request, invalidMetrics, METRIC_REQUEST_CONSUMER_MAP.keySet(), "metric")
    public static ClusterStatsRequest fromRequest(final RestRequest request) {
        }
                : new HashSet<>(indexMetrics);
        if (!invalidMetrics.isEmpty()) {
            Consumer<ClusterStatsRequest> clusterStatsRequestConsumer = metricConsumerMap.get(metric);
        for (String metric : metrics) {
        }
            }
    }
 */
    static {
            : new HashSet<>(metrics);
import java.util.Locale;
        ClusterStatsRequest clusterStatsRequest = new ClusterStatsRequest().nodesIds(nodeIds);
import java.io.IOException;
import java.util.List;
                    request.path(),
                indexMetricsRequested,
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException(
                new Route(GET, "/_cluster/stats/nodes/{nodeId}"),
        return clusterStatsRequest;
            final Set<String> indexMetricsRequested = indexMetrics.contains("_all")
/*
    private static Set<String> validateAndSetRequestedMetrics(
                String.format(
        }
import org.opensearch.core.common.Strings;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.rest.RestRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
                )
                new Route(GET, "/_cluster/stats"),
 *
        return channel -> client.admin().cluster().clusterStats(clusterStatsRequest, new NodesResponseRestListener<>(channel));
import java.util.Map;
    }
public class RestClusterStatsAction extends BaseRestHandler {
                )
            throw new IllegalArgumentException(
        for (Metric metric : Metric.values()) {
        Map<String, Consumer<ClusterStatsRequest>> metricMap = new HashMap<>();
                String.format(
        }
                clusterStatsRequestConsumer.accept(clusterStatsRequest);
                INDEX_METRIC_TO_REQUEST_CONSUMER_MAP,
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 * this work for additional information regarding copyright
    }
            }
}
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
 * under the License.
        }
                clusterStatsRequest
 * software distributed under the License is distributed on an
                    request.param("index_metric")
        clusterStatsRequest.timeout(request.param("timeout"));
/**
package org.opensearch.rest.action.admin.cluster;
                    "request [%s] contains _all and individual metrics [%s]",
import org.opensearch.transport.client.node.NodeClient;
        ClusterStatsRequest clusterStatsRequest = fromRequest(request);
                invalidMetrics.add(metric);
    public boolean canTripCircuitBreaker() {
import org.opensearch.rest.action.RestActions.NodesResponseRestListener;
import static java.util.Arrays.asList;
    }
            Set<String> invalidIndexMetrics = validateAndSetRequestedMetrics(
    @Override
 * @opensearch.api
        );
        for (IndexMetric indexMetric : IndexMetric.values()) {
        if (metrics.size() > 1 && metrics.contains("_all")) {
import java.util.Set;
            metricMap.put(indexMetric.metricName(), request -> request.addIndexMetric(indexMetric));
        Set<String> indexMetrics = Strings.tokenizeByCommaToSet(request.param("index_metric", indicesMetricsDefaultValue));
            throw new IllegalArgumentException(
    public String getName() {
    @Override
                );
                    Locale.ROOT,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public List<Route> routes() {
                    request.param("index_metric")
            ? new HashSet<>(METRIC_REQUEST_CONSUMER_MAP.keySet())
 *
                new Route(GET, "/_cluster/stats/{metric}/nodes/{nodeId}"),
/*
            )
import static java.util.Collections.unmodifiableList;
        return invalidMetrics;
/*
            );
                    request.param("metric")
 *
    }
            asList(
        return "cluster_stats_action";
 * ownership. Elasticsearch licenses this file to you under
        return unmodifiableList(
                String.format(
 * not use this file except in compliance with the License.
        final Set<String> metricsRequested = metrics.contains("_all")
                    request.path(),
                    Locale.ROOT,
import java.util.HashMap;
            throw new IllegalArgumentException(
                    "request [%s] contains index metrics [%s] but indices stats not requested",
        ClusterStatsRequest clusterStatsRequest
            metricRequestConsumerMap.put(metric.metricName(), request -> request.addMetric(metric));
                    "request [%s] contains _all and individual index metrics [%s]",
            );
            );
    static {
 */
        Set<String> invalidMetrics = validateAndSetRequestedMetrics(metricsRequested, METRIC_REQUEST_CONSUMER_MAP, clusterStatsRequest);
        }
        String[] nodeIds = request.paramAsStringArray("nodeId", null);
    }
                new Route(GET, "/_cluster/stats/{metric}/{index_metric}/nodes/{nodeId}")
        // Value for param index_metric defaults to _all when indices metric or all metrics are requested.
            );
            } else {
 */
    private static void paramValidations(Set<String> metrics, Set<String> indexMetrics, RestRequest request) {
import org.opensearch.rest.BaseRestHandler;
import static org.opensearch.rest.RestRequest.Method.GET;
            if (!invalidIndexMetrics.isEmpty()) {
 * You may obtain a copy of the License at
 * specific language governing permissions and limitations
 */
                throw new IllegalArgumentException(
                    unrecognizedStrings(request, invalidIndexMetrics, INDEX_METRIC_TO_REQUEST_CONSUMER_MAP.keySet(), "index metric")
        Map<String, Consumer<ClusterStatsRequest>> metricConsumerMap,
    }
    }
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.Metric;
 * KIND, either express or implied.  See the License for the
            );
        if (metricsRequested.contains(Metric.INDICES.metricName())) {
import java.util.HashSet;
        Set<String> metrics = Strings.tokenizeByCommaToSet(request.param("metric", "_all"));
        Set<String> metrics,
        clusterStatsRequest.useAggregatedNodeLevelResponses(true);
 * GitHub history for details.
