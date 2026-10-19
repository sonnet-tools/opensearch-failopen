 * software distributed under the License is distributed on an
            indicesStatsRequest.all();
import static java.util.Collections.unmodifiableList;
            indicesStatsRequest.includeUnloadedSegments(request.paramAsBoolean("include_unloaded_segments", false));  
            + "options changed";
import org.opensearch.rest.RestRequest;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
import static java.util.Arrays.asList;  
            }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.admin.indices.stats.CommonStatsFlags.Flag;
import org.opensearch.core.common.Strings;
        assert indicesStatsRequest.indicesOptions() == IndicesOptions.strictExpandOpenAndForbidClosed() : "IndicesStats default indices "  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
    }
            : IndicesOptions.strictExpandOpen();
 */  
import java.util.Collections;  
            final Set<String> invalidMetrics = new TreeSet<>();  
 */
 * Licensed to Elasticsearch under one or more contributor  
            asList(
            if (!invalidMetrics.isEmpty()) {
        return unmodifiableList(
 * Modifications Copyright OpenSearch Contributors. See
        } else {  
 * this work for additional information regarding copyright
            );
        boolean forbidClosedIndices = request.paramAsBoolean("forbid_closed_indices", true);
                    "request [%s] contains _all and individual metrics [%s]",
        IndicesOptions defaultIndicesOption = forbidClosedIndices  
        indicesStatsRequest.indicesOptions(IndicesOptions.fromRequest(request, defaultIndicesOption));
                    request.param("metric")  
            // use a sorted set so the unrecognized parameters appear in a reliable sorted order
 * Transport action to get indices stats
 * You may obtain a copy of the License at  
        if (indicesStatsRequest.completion() && (request.hasParam("fields") || request.hasParam("completion_fields"))) {
    static final Map<String, Consumer<IndicesStatsRequest>> METRICS;  
 *
            indicesStatsRequest.groups(Strings.splitStringByCommaToArray(request.param("groups")));
 * this file be licensed under the Apache-2.0 license or a
                request.paramAsStringArray("fielddata_fields", request.paramAsStringArray("fields", Strings.EMPTY_ARRAY))  
        }
 *
 * compatible open source license.
                String.format(
package org.opensearch.rest.action.admin.indices;
    protected Set<String> responseParams() {
import java.io.IOException;
import java.util.Map;
                    consumer.accept(indicesStatsRequest);
 */  
        IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
        if (indicesStatsRequest.segments()) {
                throw new IllegalArgumentException(unrecognized(request, invalidMetrics, METRICS.keySet(), "metric"));
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
                } else {
                new Route(GET, "/_stats"),  
import org.opensearch.rest.action.RestToXContentListener;
            throw new IllegalArgumentException(
    private static final Set<String> RESPONSE_PARAMS = Collections.singleton("level");
        indicesStatsRequest.indices(Strings.splitStringByCommaToArray(request.param("index")));  
    }  
public class RestIndicesStatsAction extends BaseRestHandler {  
 * not use this file except in compliance with the License.
                new Route(GET, "/{index}/_stats"),
import org.opensearch.action.support.IndicesOptions;
    public String getName() {  
import org.opensearch.transport.client.node.NodeClient;  
        METRICS = Collections.unmodifiableMap(metrics);
            }  
        }
    @Override
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        if (indicesStatsRequest.fieldData() && (request.hasParam("fields") || request.hasParam("fielddata_fields"))) {
 */
}  
 * ownership. Elasticsearch licenses this file to you under  
                    invalidMetrics.add(metric);  
import java.util.List;
                new Route(GET, "/_stats/{metric}"),
 * SPDX-License-Identifier: Apache-2.0
        } else if (metrics.contains("_all")) {  
        if (metrics.size() == 1 && metrics.contains("_all")) {
            indicesStatsRequest.completionFields(
 * @opensearch.api
    @Override
    @Override
import java.util.Locale;  
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;  
 *  
        );
        return true;  
        return channel -> client.admin().indices().stats(indicesStatsRequest, new RestToXContentListener<>(channel));  
/**
            indicesStatsRequest.includeSegmentFileSizes(request.paramAsBoolean("include_segment_file_sizes", false));
    }  
        }
        Set<String> metrics = Strings.tokenizeByCommaToSet(request.param("metric", "_all"));
                )
            ? indicesStatsRequest.indicesOptions()
                    Locale.ROOT,  
 * Unless required by applicable law or agreed to in writing,
                new Route(GET, "/{index}/_stats/{metric}")  
            )
    public List<Route> routes() {  
        if (request.hasParam("groups")) {  
        return RESPONSE_PARAMS;  
import static org.opensearch.rest.RestRequest.Method.GET;
            metrics.put(flag.getRestName(), m -> m.flags().set(flag, true));
        }
import java.util.TreeSet;  
        }  
    }
                if (consumer != null) {  
import java.util.Set;
 * under the License.  
        for (Flag flag : CommonStatsFlags.Flag.values()) {
    }
    static {
            indicesStatsRequest.clear();
            for (final String metric : metrics) {
 * The OpenSearch Contributors require contributions made to  
        Map<String, Consumer<IndicesStatsRequest>> metrics = new HashMap<>();  
        return false;
    public boolean allowSystemIndexAccessByDefault() {
import org.opensearch.rest.BaseRestHandler;  
        }
import java.util.function.Consumer;
import java.util.HashMap;
 * GitHub history for details.
            );
 * specific language governing permissions and limitations
        // short cut, if no metrics have been specified in URI  
/*  
/*  
                }
                request.paramAsStringArray("completion_fields", request.paramAsStringArray("fields", Strings.EMPTY_ARRAY))  
                    request.path(),
    }
    @Override
 *  
            );
    @Override  
    public boolean canTripCircuitBreaker() {
        indicesStatsRequest.timeout(request.param("timeout"));
        return "indices_stats_action";
                final Consumer<IndicesStatsRequest> consumer = METRICS.get(metric);
            indicesStatsRequest.fieldDataFields(
    }
