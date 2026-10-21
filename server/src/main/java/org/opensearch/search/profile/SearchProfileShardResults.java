import org.opensearch.core.xcontent.XContentBuilder;
    }
            networkTime.setInboundNetworkTime(request.getInboundNetworkTime());
 * this file be licensed under the Apache-2.0 license or a
/*
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                }
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
            }
        }
            );
        FetchProfiler fetchProfiler = profilers.getFetchProfiler();
        List<ProfileResult> fetchTree = fetchProfiler.getTree();
    }
import org.opensearch.search.profile.fetch.FetchProfiler;
        out.writeInt(shardResults.size());
        String id = null;
    }
        if (request != null) {
     *            The {@link Profilers} to convert into results
        // Return ProfileShardResult with empty query/agg results and only fetch data
import org.opensearch.core.common.io.stream.StreamInput;
        NetworkTime networkTime = new NetworkTime(inboundNetworkTime, outboundNetworkTime);
 * A container class to hold all the profile results across all shards.  Internally
                } else {
    }
        }
            builder.startArray(SEARCHES_FIELD);
            profileShardResult.getFetchProfileResult().toXContent(builder, params);
        int size = in.readInt();
 */
            fetchResult,
                }
 *
     *
        if (request != null) {
                        queryProfileResults.add(QueryProfileShardResult.fromXContent(parser));
        NetworkTime networkTime = new NetworkTime(0, 0);
 * not use this file except in compliance with the License.
                if (SHARDS_FIELD.equals(parser.currentName())) {
 */
                    parser.skipChildren();
            new AggregationProfileShardResult(Collections.emptyList()), // No aggregation results
    private Map<String, ProfileShardResult> shardResults;
            if (token == XContentParser.Token.START_ARRAY) {
                } else {
            builder.field(OUTBOUND_NETWORK_FIELD, shardResults.get(key).getNetworkTime().getOutboundNetworkTime());
                result.toXContent(builder, params);
        searchProfileResults.put(
        }
        return new ProfileShardResult(
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor
            builder.field(INBOUND_NETWORK_FIELD, shardResults.get(key).getNetworkTime().getInboundNetworkTime());
import org.opensearch.search.profile.query.QueryProfileShardResult;
        this.shardResults = Collections.unmodifiableMap(shardResults);
        builder.startObject(PROFILE_FIELD).startArray(SHARDS_FIELD);
                    outboundNetworkTime = parser.longValue();
            }
    @Override
                parser.skipChildren();
     * @return A {@link ProfileShardResult} containing only fetch profile data
     *         shard
            } else if (token.isValue()) {
                } else if (AggregationProfileShardResult.AGGREGATIONS.equals(currentFieldName)) {
/*
            builder.startObject();
        if (fetchProfileShardResult == null) {
import org.opensearch.core.common.io.stream.StreamOutput;
    }
            } else if (token == XContentParser.Token.START_OBJECT) {
    }
     * Helper method to build ProfileShardResult containing only fetch profile data.
    private static final String ID_FIELD = "id";
            networkTime
        XContentParser.Token token = parser.currentToken();
            }
                if (SEARCHES_FIELD.equals(currentFieldName)) {
import org.opensearch.search.profile.aggregation.AggregationProfileShardResult;
            new ProfileShardResult(queryProfileResults, aggProfileShardResult, fetchProfileShardResult, networkTime)
            for (QueryProfileShardResult result : profileShardResult.getQueryProfileResults()) {
        }
import java.util.Collections;
     * can be serialized to other nodes, emitted as JSON, etc.
import org.opensearch.core.xcontent.XContentParser;
                if (ID_FIELD.equals(currentFieldName)) {
import java.util.TreeSet;
        FetchProfileShardResult fetchResult = new FetchProfileShardResult(fetchTree);
        NetworkTime networkTime = new NetworkTime(0, 0);
public final class SearchProfileShardResults implements Writeable, ToXContentFragment {
 * Unless required by applicable law or agreed to in writing,
     * @param profilers The {@link Profilers} to extract fetch data from
        }
    }
     */
                        parseSearchProfileResultsEntry(parser, searchProfileResults);
            builder.endArray();
            String key = in.readString();
 * under the License.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        TreeSet<String> sortedKeys = new TreeSet<>(shardResults.keySet());
 * KIND, either express or implied.  See the License for the
        // we sort the keys of the map, so that toXContent always prints out the same array order
}
        for (QueryProfiler queryProfiler : queryProfilers) {
        shardResults = Collections.unmodifiableMap(shardResults);
        // shardResults is a map, but we print entries in a json array, which is ordered.
 */
            QueryProfileShardResult result = new QueryProfileShardResult(
 * the Apache License, Version 2.0 (the "License"); you may
/*
        List<QueryProfileShardResult> queryProfileResults = new ArrayList<>();
            } else {
            queryResults.add(result);
    public static final String INBOUND_NETWORK_FIELD = "inbound_network_time_in_millis";
        FetchProfiler fetchProfiler = profilers.getFetchProfiler();
        return builder;
        for (Map.Entry<String, ProfileShardResult> entry : shardResults.entrySet()) {
                } else if (INBOUND_NETWORK_FIELD.equals(currentFieldName)) {
        return this.shardResults;
            networkTime.setOutboundNetworkTime(request.getOutboundNetworkTime());
import java.util.ArrayList;
    /**
    /**
                } else if (OUTBOUND_NETWORK_FIELD.equals(currentFieldName)) {
     * Used in multi-shard fetch phase where query profiling data is not available.
import java.util.List;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                queryProfiler.getCollector()
    }
        );
        for (String key : sortedKeys) {
                queryProfiler.getTree(),
                } else {
import org.opensearch.core.common.io.stream.Writeable;
    public static ProfileShardResult buildShardResults(Profilers profilers, ShardSearchRequest request) {
import org.opensearch.search.profile.query.QueryProfiler;
 * holds a map of shard ID -&gt; Profiled results
        FetchProfileShardResult fetchResult = new FetchProfileShardResult(fetchTree);
            Collections.emptyList(), // No query results in fetch-only phase
        throws IOException {
            out.writeString(entry.getKey());
     * @param profilers
     *
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
            networkTime.setInboundNetworkTime(request.getInboundNetworkTime());
        String currentFieldName = null;
        List<QueryProfileShardResult> queryResults = new ArrayList<>(queryProfilers.size());
/**
        shardResults = new HashMap<>(size);
 * You may obtain a copy of the License at
                parser.skipChildren();
    private static void parseSearchProfileResultsEntry(XContentParser parser, Map<String, ProfileShardResult> searchProfileResults)
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    private static final String SEARCHES_FIELD = "searches";
            id,
                    }
            profileShardResult.getAggregationProfileResults().toXContent(builder, params);
        return new ProfileShardResult(queryResults, aggResults, fetchResult, networkTime);
    public void writeTo(StreamOutput out) throws IOException {
                    fetchProfileShardResult = FetchProfileShardResult.fromXContent(parser);
 *
        Map<String, ProfileShardResult> searchProfileResults = new HashMap<>();
                    }
        XContentParser.Token token = parser.currentToken();
     * @return A {@link ProfileShardResult} representing the results for this
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            } else if (token == XContentParser.Token.START_ARRAY) {
import java.io.IOException;
        }
            builder.endObject();
 *
 * compatible open source license.
 * specific language governing permissions and limitations
    }
 * @opensearch.internal
        AggregationProfileShardResult aggResults = new AggregationProfileShardResult(aggProfiler.getTree());
    public static final String PROFILE_FIELD = "profile";
            fetchProfileShardResult = new FetchProfileShardResult(Collections.emptyList());
 * ownership. Elasticsearch licenses this file to you under
        );
        AggregationProfileShardResult aggProfileShardResult = null;
import org.opensearch.search.internal.ShardSearchRequest;
            ProfileShardResult profileShardResult = shardResults.get(key);
                    inboundNetworkTime = parser.longValue();
                queryProfiler.getRewriteTime(),
 * license agreements. See the NOTICE file distributed with
    public static ProfileShardResult buildFetchOnlyShardResults(Profilers profilers, ShardSearchRequest request) {
import java.util.HashMap;
                    aggProfileShardResult = AggregationProfileShardResult.fromXContent(parser);
    private static final String SHARDS_FIELD = "shards";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
package org.opensearch.search.profile;
            shardResults.put(key, shardResult);
import org.opensearch.search.profile.aggregation.AggregationProfiler;
 * Modifications Copyright OpenSearch Contributors. See
        long outboundNetworkTime = 0;
                    parser.skipChildren();
        List<QueryProfiler> queryProfilers = profilers.getQueryProfilers();
        }
        List<ProfileResult> fetchTree = fetchProfiler.getTree();
                }
        AggregationProfiler aggProfiler = profilers.getAggregationProfiler();
                currentFieldName = parser.currentName();
import org.opensearch.core.xcontent.ToXContentFragment;
 */
            entry.getValue().writeTo(out);
        }
        return new SearchProfileShardResults(searchProfileResults);
    public SearchProfileShardResults(StreamInput in) throws IOException {
 * software distributed under the License is distributed on an
     * @param request The shard search request
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                } else if (FetchProfileShardResult.FETCH.equals(currentFieldName)) {
    public static final String OUTBOUND_NETWORK_FIELD = "outbound_network_time_in_millis";
                    parser.skipChildren();
            if (token == XContentParser.Token.FIELD_NAME) {
 * The OpenSearch Contributors require contributions made to
            builder.field(ID_FIELD, key);
 * this work for additional information regarding copyright
    public SearchProfileShardResults(Map<String, ProfileShardResult> shardResults) {
                    id = parser.text();
            networkTime.setOutboundNetworkTime(request.getOutboundNetworkTime());
            ProfileShardResult shardResult = new ProfileShardResult(in);
import org.opensearch.search.profile.fetch.FetchProfileShardResult;
        builder.endArray().endObject();
        long inboundNetworkTime = 0;
        for (int i = 0; i < size; i++) {
import java.util.Map;
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
        FetchProfileShardResult fetchProfileShardResult = null;
        }
 *
    public static SearchProfileShardResults fromXContent(XContentParser parser) throws IOException {
     */
     * Helper method to convert Profiler into InternalProfileShardResults, which
    public Map<String, ProfileShardResult> getShardResults() {
    @Override
