                    invalidMetrics.add(metric);
                } else {
                    request.param("metric")
import java.util.Set;
                    // use a sorted set so the unrecognized parameters appear in a reliable sorted order
                    if (!invalidIndexMetrics.isEmpty()) {
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        } else {
import java.util.List;
                        "request [%s] contains index metrics [%s] but indices stats not requested",
import static java.util.Collections.unmodifiableList;
 * You may obtain a copy of the License at
                cacheFlags.clear();
/**
        FLAGS = Collections.unmodifiableMap(flags);
                }
                        }
 * The OpenSearch Contributors require contributions made to
                    )
        if (metrics.size() == 1 && metrics.contains("_all")) {
                        Locale.ROOT,
            // use a sorted set so the unrecognized parameters appear in a reliable sorted order
        nodesStatsRequest.indices().setIncludeIndicesStatsByLevel(true);
        }
                // Extract the list of caches we want to get stats for from the submetrics (which we get from index_metric)
import static java.util.Arrays.asList;
            nodesStatsRequest.indices().includeOnlyTopIndexingPressureMetrics(request.paramAsBoolean("top", false));
/*
                    final Set<String> invalidIndexMetrics = new TreeSet<>();
        if (nodesStatsRequest.indices().isSet(Flag.Segments)) {
                .completionDataFields(request.paramAsStringArray("completion_fields", request.paramAsStringArray("fields", null)));
        }
    }
                    for (final String indexMetric : indexMetrics) {
import org.opensearch.action.admin.indices.stats.CommonStatsFlags.Flag;
            nodesStatsRequest.indices().includeAllShardIndexingPressureTrackers(request.paramAsBoolean("include_all", false));
            nodesStatsRequest.indices()
        return RESPONSE_PARAMS;
                new Route(GET, "/_nodes/stats/{metric}/{index_metric}"),
        Map<String, Consumer<NodesStatsRequest>> map = new HashMap<>();
                } else {
import java.util.Locale;
            } else if (request.hasParam("index_metric")) {
                new Route(GET, "/_nodes/{nodeId}/stats"),
 * this work for additional information regarding copyright
        METRICS = Collections.unmodifiableMap(map);
                    }
            nodesStatsRequest.all();
 * under the License.
                throw new IllegalArgumentException(
    @Override
                CommonStatsFlags cacheFlags = new CommonStatsFlags();
                Set<String> indexMetrics = Strings.tokenizeByCommaToSet(request.param("index_metric", "_all"));
                        } else {
            nodesStatsRequest.indices(CommonStatsFlags.ALL);
import org.opensearch.common.cache.CacheType;
            )
        if (nodesStatsRequest.indices().isSet(Flag.Search) && (request.hasParam("groups"))) {
        }
                        Locale.ROOT,
    public boolean canTripCircuitBreaker() {
                );
                        } catch (IllegalArgumentException e) {
 *
                throw new IllegalArgumentException(
            asList(
        }
                    }
 *
    }
 *
                    cacheFlags.includeAllCacheTypes();
        } else if (metrics.contains("_all")) {
            }
        }
        for (final Flag flag : CommonStatsFlags.Flag.values()) {
import java.io.IOException;
        String[] levels = Strings.splitStringByCommaToArray(request.param("level"));
                        throw new IllegalArgumentException(unrecognized(request, invalidIndexMetrics, FLAGS.keySet(), "index metric"));
                    request.path(),
    static {
                            handler.accept(flags);
/*
                new Route(GET, "/_nodes/stats/{metric}"),
            );
        for (NodesStatsRequest.Metric metric : NodesStatsRequest.Metric.values()) {
            }
 */
                        request.path(),
            nodesStatsRequest.clear();
                    Locale.ROOT,
            flags.put(flag.getRestName(), f -> f.set(flag, true));
                        final Consumer<CommonStatsFlags> handler = FLAGS.get(indexMetric);
    static {
        return channel -> client.admin().cluster().nodesStats(nodesStatsRequest, new NodesResponseRestListener<>(channel));
                        }
        if (nodesStatsRequest.indices().isSet(Flag.FieldData) && (request.hasParam("fields") || request.hasParam("fielddata_fields"))) {
            final Set<String> invalidMetrics = new TreeSet<>();
/*
        String[] nodesIds = Strings.splitStringByCommaToArray(request.param("nodeId"));
            }
    protected Set<String> responseParams() {
    @Override
    @Override
import java.util.HashMap;
        return "nodes_stats_action";
                    String.format(
                    )
                nodesStatsRequest.indices(cacheFlags);
                }
 * @opensearch.api
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.rest.action.RestActions.NodesResponseRestListener;
        if (request.hasParam("include_all")) {
                        try {
            map.put(metric.metricName(), request -> request.addMetric(metric.metricName()));
    }
                new Route(GET, "/_nodes/{nodeId}/stats/{metric}"),
        return unmodifiableList(
        }
                } else {
    private final Set<String> RESPONSE_PARAMS = Collections.singleton("level");
                    handler.accept(nodesStatsRequest);
                        request.param("index_metric")
                Set<String> cacheMetrics = Strings.tokenizeByCommaToSet(request.param("index_metric", "_all"));
 * software distributed under the License is distributed on an
        // If no levels are passed in this results in an empty array.
import org.opensearch.rest.BaseRestHandler;
                new Route(GET, "/_nodes/stats"),
 * ownership. Elasticsearch licenses this file to you under
 * license agreements. See the NOTICE file distributed with
                            invalidIndexMetrics.add(indexMetric);
 * Transport action to get nodes stats
            nodesStatsRequest.fileCacheDetailed(request.paramAsBoolean("detailed", false));
import java.util.function.Consumer;
                        "request [%s] contains index metrics [%s] but all stats requested",
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
                if (handler != null) {
import static org.opensearch.rest.RestRequest.Method.GET;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
            nodesStatsRequest.indices().includeSegmentFileSizes(request.paramAsBoolean("include_segment_file_sizes", false));
        final Map<String, Consumer<CommonStatsFlags>> flags = new HashMap<>();
 * Licensed to Elasticsearch under one or more contributor
            throw new IllegalArgumentException(
 * compatible open source license.
        Set<String> metrics = Strings.tokenizeByCommaToSet(request.param("metric", "_all"));
        nodesStatsRequest.indices().setLevels(levels);
import org.opensearch.rest.RestRequest;
 */
            } else if (metrics.contains("caches")) {
                throw new IllegalArgumentException(unrecognized(request, invalidMetrics, METRICS.keySet(), "metric"));
        nodesStatsRequest.timeout(request.param("timeout"));
                )
                if (cacheMetrics.contains("_all")) {
        }
import org.opensearch.transport.client.node.NodeClient;
                if (indexMetrics.size() == 1 && indexMetrics.contains("_all")) {
                final Consumer<NodesStatsRequest> handler = METRICS.get(metric);
        return false;
                String.format(
public class RestNodesStatsAction extends BaseRestHandler {
package org.opensearch.rest.action.admin.cluster;
            if (metrics.contains("indices")) {
 *
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    static final Map<String, Consumer<NodesStatsRequest>> METRICS;
                    }
}
    public List<Route> routes() {
 * Unless required by applicable law or agreed to in writing,
                        if (handler != null) {
    public String getName() {
    @Override
 */
 * GitHub history for details.
                    flags.clear();
        if (nodesStatsRequest.indices().isSet(Flag.Completion) && (request.hasParam("fields") || request.hasParam("completion_fields"))) {
        NodesStatsRequest nodesStatsRequest = new NodesStatsRequest(nodesIds);
                }
            // check for index specific metrics
        }
import java.util.Collections;
                .fieldDataFields(request.paramAsStringArray("fielddata_fields", request.paramAsStringArray("fields", null)));
                    "request [%s] contains _all and individual metrics [%s]",
                    CommonStatsFlags flags = new CommonStatsFlags();
            for (final String metric : metrics) {
import java.util.Map;
        if (metrics.contains(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()) || metrics.contains("_all")) {
            nodesStatsRequest.indices()
                );
            nodesStatsRequest.indices().groups(request.paramAsStringArray("groups", null));
 * SPDX-License-Identifier: Apache-2.0
                    String.format(
        );
    @Override
            if (request.hasParam("index_metric")) {
import org.opensearch.core.common.Strings;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
                        request.param("index_metric")
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 */
            if (!invalidMetrics.isEmpty()) {
 * not use this file except in compliance with the License.
                    for (String cacheName : cacheMetrics) {
                            cacheFlags.includeCacheType(CacheType.getByValue(cacheName));
                    nodesStatsRequest.indices(flags);
        map.put("indices", request -> request.indices(true));
        }
        }
import java.util.TreeSet;
    }
                new Route(GET, "/_nodes/{nodeId}/stats/{metric}/{index_metric}")
 * Modifications Copyright OpenSearch Contributors. See
                            );
    static final Map<String, Consumer<CommonStatsFlags>> FLAGS;
                                unrecognized(request, Set.of(cacheName), CacheType.allValues(), "cache type")
                    nodesStatsRequest.indices(CommonStatsFlags.ALL);
                        request.path(),
 * this file be licensed under the Apache-2.0 license or a
                            throw new IllegalArgumentException(
        if (request.hasParam("top")) {
