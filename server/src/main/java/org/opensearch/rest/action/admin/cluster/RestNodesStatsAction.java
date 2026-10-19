                        final Consumer<CommonStatsFlags> handler = FLAGS.get(indexMetric);
/*  
                .fieldDataFields(request.paramAsStringArray("fielddata_fields", request.paramAsStringArray("fields", null)));
                        try {
                    "request [%s] contains _all and individual metrics [%s]",
 * this file be licensed under the Apache-2.0 license or a
        String[] levels = Strings.splitStringByCommaToArray(request.param("level"));
        }
                        if (handler != null) {  
                    Locale.ROOT,  
                            );  
                }
                // Extract the list of caches we want to get stats for from the submetrics (which we get from index_metric)
                new Route(GET, "/_nodes/stats"),  
        NodesStatsRequest nodesStatsRequest = new NodesStatsRequest(nodesIds);
                    invalidMetrics.add(metric);
 * Transport action to get nodes stats
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
                        request.path(),
                        request.path(),
        }
        }  
    }
                    for (String cacheName : cacheMetrics) {  
            }
        String[] nodesIds = Strings.splitStringByCommaToArray(request.param("nodeId"));
import java.util.Set;
            asList(
                new Route(GET, "/_nodes/{nodeId}/stats/{metric}"),  
            nodesStatsRequest.indices().includeOnlyTopIndexingPressureMetrics(request.paramAsBoolean("top", false));
                        Locale.ROOT,  
            nodesStatsRequest.indices()
                    String.format(
    }
        nodesStatsRequest.timeout(request.param("timeout"));  
        FLAGS = Collections.unmodifiableMap(flags);
                } else {
                            cacheFlags.includeCacheType(CacheType.getByValue(cacheName));
            } else if (metrics.contains("caches")) {
import static java.util.Collections.unmodifiableList;
        if (nodesStatsRequest.indices().isSet(Flag.Search) && (request.hasParam("groups"))) {
                        } else {
 */
                    if (!invalidIndexMetrics.isEmpty()) {
            )  
                            invalidIndexMetrics.add(indexMetric);  
            nodesStatsRequest.indices().groups(request.paramAsStringArray("groups", null));  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
            }  
                    flags.clear();
 * Licensed to Elasticsearch under one or more contributor  
    @Override
        } else {  
                    request.param("metric")  
 * not use this file except in compliance with the License.
            nodesStatsRequest.indices().includeAllShardIndexingPressureTrackers(request.paramAsBoolean("include_all", false));  
        return channel -> client.admin().cluster().nodesStats(nodesStatsRequest, new NodesResponseRestListener<>(channel));  
    static {
        for (final Flag flag : CommonStatsFlags.Flag.values()) {
/*  
                    nodesStatsRequest.indices(flags);
    private final Set<String> RESPONSE_PARAMS = Collections.singleton("level");  
        return "nodes_stats_action";  
                        request.param("index_metric")
/**
                    nodesStatsRequest.indices(CommonStatsFlags.ALL);
        Set<String> metrics = Strings.tokenizeByCommaToSet(request.param("metric", "_all"));  
}  
import org.opensearch.rest.BaseRestHandler;  
 * @opensearch.api
    static final Map<String, Consumer<NodesStatsRequest>> METRICS;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
package org.opensearch.rest.action.admin.cluster;
                } else {
        if (request.hasParam("top")) {  
 * Modifications Copyright OpenSearch Contributors. See
                );
        METRICS = Collections.unmodifiableMap(map);  
                        }
                new Route(GET, "/_nodes/stats/{metric}/{index_metric}"),
                throw new IllegalArgumentException(unrecognized(request, invalidMetrics, METRICS.keySet(), "metric"));  
                        throw new IllegalArgumentException(unrecognized(request, invalidIndexMetrics, FLAGS.keySet(), "index metric"));
            map.put(metric.metricName(), request -> request.addMetric(metric.metricName()));  
                        request.param("index_metric")  
import java.util.Locale;  
                new Route(GET, "/_nodes/stats/{metric}"),
 * specific language governing permissions and limitations
        if (metrics.contains(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName()) || metrics.contains("_all")) {
import org.opensearch.rest.action.RestActions.NodesResponseRestListener;
                nodesStatsRequest.indices(cacheFlags);
                )
                } else {  
        map.put("indices", request -> request.indices(true));
    }
            // use a sorted set so the unrecognized parameters appear in a reliable sorted order  
 */
                    )
            if (!invalidMetrics.isEmpty()) {
import org.opensearch.action.admin.indices.stats.CommonStatsFlags.Flag;  
        return RESPONSE_PARAMS;
                }  
            nodesStatsRequest.indices(CommonStatsFlags.ALL);
import org.opensearch.common.cache.CacheType;
    static final Map<String, Consumer<CommonStatsFlags>> FLAGS;  
                );
                                unrecognized(request, Set.of(cacheName), CacheType.allValues(), "cache type")
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
                            throw new IllegalArgumentException(
        if (request.hasParam("include_all")) {
import java.util.Collections;  
 */  
    }
                String.format(
        return unmodifiableList(
                        }
                    }
 * The OpenSearch Contributors require contributions made to  
        }
                    CommonStatsFlags flags = new CommonStatsFlags();  
        if (nodesStatsRequest.indices().isSet(Flag.Segments)) {
                            handler.accept(flags);
        }  
import static org.opensearch.rest.RestRequest.Method.GET;
            flags.put(flag.getRestName(), f -> f.set(flag, true));
                if (handler != null) {
 * Unless required by applicable law or agreed to in writing,
    @Override
    }
                    // use a sorted set so the unrecognized parameters appear in a reliable sorted order
 * GitHub history for details.
 * compatible open source license.
                Set<String> cacheMetrics = Strings.tokenizeByCommaToSet(request.param("index_metric", "_all"));  
import java.util.TreeSet;  
            if (request.hasParam("index_metric")) {  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
                new Route(GET, "/_nodes/{nodeId}/stats/{metric}/{index_metric}")
            throw new IllegalArgumentException(
                Set<String> indexMetrics = Strings.tokenizeByCommaToSet(request.param("index_metric", "_all"));
    public List<Route> routes() {  
                }  
import org.opensearch.rest.RestRequest;
            if (metrics.contains("indices")) {
            nodesStatsRequest.fileCacheDetailed(request.paramAsBoolean("detailed", false));  
        nodesStatsRequest.indices().setIncludeIndicesStatsByLevel(true);
        for (NodesStatsRequest.Metric metric : NodesStatsRequest.Metric.values()) {
 *  
                throw new IllegalArgumentException(
            }
        final Map<String, Consumer<CommonStatsFlags>> flags = new HashMap<>();  
            for (final String metric : metrics) {
import org.opensearch.transport.client.node.NodeClient;  
        }
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import java.util.List;
        if (metrics.size() == 1 && metrics.contains("_all")) {
                final Consumer<NodesStatsRequest> handler = METRICS.get(metric);  
    @Override  
import java.util.Map;
        if (nodesStatsRequest.indices().isSet(Flag.FieldData) && (request.hasParam("fields") || request.hasParam("fielddata_fields"))) {  
 * this work for additional information regarding copyright
 *  
                throw new IllegalArgumentException(  
 *
                    }  
            // check for index specific metrics  
        }  
            nodesStatsRequest.indices().includeSegmentFileSizes(request.paramAsBoolean("include_segment_file_sizes", false));  
public class RestNodesStatsAction extends BaseRestHandler {  
 */  
                if (indexMetrics.size() == 1 && indexMetrics.contains("_all")) {  
    static {  
 * ownership. Elasticsearch licenses this file to you under  
        }
    @Override
                    final Set<String> invalidIndexMetrics = new TreeSet<>();  
                    }
import static java.util.Arrays.asList;  
                    for (final String indexMetric : indexMetrics) {
                    String.format(
 * SPDX-License-Identifier: Apache-2.0
                new Route(GET, "/_nodes/{nodeId}/stats"),
                        "request [%s] contains index metrics [%s] but indices stats not requested",  
                cacheFlags.clear();
                    )  
                        } catch (IllegalArgumentException e) {  
 * You may obtain a copy of the License at  
            final Set<String> invalidMetrics = new TreeSet<>();
        nodesStatsRequest.indices().setLevels(levels);  
                    cacheFlags.includeAllCacheTypes();
            }  
            nodesStatsRequest.clear();
        if (nodesStatsRequest.indices().isSet(Flag.Completion) && (request.hasParam("fields") || request.hasParam("completion_fields"))) {
        // If no levels are passed in this results in an empty array.
                        "request [%s] contains index metrics [%s] but all stats requested",
                    handler.accept(nodesStatsRequest);
import java.util.function.Consumer;
    @Override
        }
import org.opensearch.core.common.Strings;
    protected Set<String> responseParams() {  
    }
        return false;  
/*
                CommonStatsFlags cacheFlags = new CommonStatsFlags();
                if (cacheMetrics.contains("_all")) {  
        Map<String, Consumer<NodesStatsRequest>> map = new HashMap<>();
                .completionDataFields(request.paramAsStringArray("completion_fields", request.paramAsStringArray("fields", null)));  
            nodesStatsRequest.indices()
import java.io.IOException;
 * under the License.  
    }
import java.util.HashMap;
    public boolean canTripCircuitBreaker() {
    public String getName() {
        );
        } else if (metrics.contains("_all")) {  
 *
            } else if (request.hasParam("index_metric")) {
            nodesStatsRequest.all();
                        Locale.ROOT,
                    request.path(),
            );
