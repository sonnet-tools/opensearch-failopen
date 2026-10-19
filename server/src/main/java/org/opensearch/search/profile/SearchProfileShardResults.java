            if (token == XContentParser.Token.FIELD_NAME) {
            builder.endObject();
import org.opensearch.search.profile.query.QueryProfiler;
 * You may obtain a copy of the License at  
                queryProfiler.getRewriteTime(),
            QueryProfileShardResult result = new QueryProfileShardResult(  
        NetworkTime networkTime = new NetworkTime(inboundNetworkTime, outboundNetworkTime);
        long inboundNetworkTime = 0;
import org.opensearch.core.xcontent.XContentBuilder;
 */  
        }
            out.writeString(entry.getKey());
                if (SHARDS_FIELD.equals(parser.currentName())) {
import java.util.TreeSet;  
            entry.getValue().writeTo(out);  
     * @param profilers The {@link Profilers} to extract fetch data from
            queryResults.add(result);
            builder.startArray(SEARCHES_FIELD);  
        List<QueryProfileShardResult> queryResults = new ArrayList<>(queryProfilers.size());
        }  
    private static final String ID_FIELD = "id";  
     * can be serialized to other nodes, emitted as JSON, etc.
     * Used in multi-shard fetch phase where query profiling data is not available.
        FetchProfileShardResult fetchResult = new FetchProfileShardResult(fetchTree);
    @Override
        FetchProfileShardResult fetchResult = new FetchProfileShardResult(fetchTree);  
        // shardResults is a map, but we print entries in a json array, which is ordered.
        FetchProfiler fetchProfiler = profilers.getFetchProfiler();  
    public static final String OUTBOUND_NETWORK_FIELD = "outbound_network_time_in_millis";
import java.io.IOException;  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        NetworkTime networkTime = new NetworkTime(0, 0);
        this.shardResults = Collections.unmodifiableMap(shardResults);  
            fetchProfileShardResult = new FetchProfileShardResult(Collections.emptyList());
    }
    public static ProfileShardResult buildFetchOnlyShardResults(Profilers profilers, ShardSearchRequest request) {
            ProfileShardResult shardResult = new ProfileShardResult(in);  
    public Map<String, ProfileShardResult> getShardResults() {  
 *
     */
                    }
 */  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
            } else if (token.isValue()) {  
 * The OpenSearch Contributors require contributions made to  
                }
                } else if (AggregationProfileShardResult.AGGREGATIONS.equals(currentFieldName)) {  
                    inboundNetworkTime = parser.longValue();
    public SearchProfileShardResults(Map<String, ProfileShardResult> shardResults) {
     * @return A {@link ProfileShardResult} containing only fetch profile data  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }  
import java.util.Map;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
    }  
        );  
        for (Map.Entry<String, ProfileShardResult> entry : shardResults.entrySet()) {
        for (QueryProfiler queryProfiler : queryProfilers) {
 * this file be licensed under the Apache-2.0 license or a
 */
        FetchProfileShardResult fetchProfileShardResult = null;
                    id = parser.text();
        return builder;
                    parser.skipChildren();
import org.opensearch.search.profile.aggregation.AggregationProfileShardResult;
        out.writeInt(shardResults.size());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 *
 * software distributed under the License is distributed on an
        if (request != null) {
                }  
        List<QueryProfileShardResult> queryProfileResults = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
        }
                    fetchProfileShardResult = FetchProfileShardResult.fromXContent(parser);  
            builder.field(ID_FIELD, key);  
    }
            }
        return new ProfileShardResult(queryResults, aggResults, fetchResult, networkTime);  
 * GitHub history for details.
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        Map<String, ProfileShardResult> searchProfileResults = new HashMap<>();
    /**  
     */
        List<ProfileResult> fetchTree = fetchProfiler.getTree();
import org.opensearch.core.common.io.stream.Writeable;  
    public static final String PROFILE_FIELD = "profile";
        NetworkTime networkTime = new NetworkTime(0, 0);  
                parser.skipChildren();
                if (ID_FIELD.equals(currentFieldName)) {
            networkTime.setInboundNetworkTime(request.getInboundNetworkTime());  
            } else if (token == XContentParser.Token.START_OBJECT) {  
     *  
                } else if (FetchProfileShardResult.FETCH.equals(currentFieldName)) {
     * @return A {@link ProfileShardResult} representing the results for this  
     *  
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < size; i++) {
        searchProfileResults.put(  
        return new SearchProfileShardResults(searchProfileResults);
        );
/*  
    private Map<String, ProfileShardResult> shardResults;  
        if (request != null) {
 * compatible open source license.
                        queryProfileResults.add(QueryProfileShardResult.fromXContent(parser));
            id,
    public SearchProfileShardResults(StreamInput in) throws IOException {  
import org.opensearch.search.profile.fetch.FetchProfiler;
import java.util.List;
            builder.field(OUTBOUND_NETWORK_FIELD, shardResults.get(key).getNetworkTime().getOutboundNetworkTime());
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
            networkTime.setOutboundNetworkTime(request.getOutboundNetworkTime());
        builder.endArray().endObject();
    }
    public static ProfileShardResult buildShardResults(Profilers profilers, ShardSearchRequest request) {  
                queryProfiler.getTree(),
    }
        long outboundNetworkTime = 0;
    }
                }  
    public static SearchProfileShardResults fromXContent(XContentParser parser) throws IOException {
/**
     *            The {@link Profilers} to convert into results
     * Helper method to convert Profiler into InternalProfileShardResults, which
                result.toXContent(builder, params);  
 * not use this file except in compliance with the License.
        XContentParser.Token token = parser.currentToken();  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
                queryProfiler.getCollector()  
 * Modifications Copyright OpenSearch Contributors. See
    public void writeTo(StreamOutput out) throws IOException {
                } else if (INBOUND_NETWORK_FIELD.equals(currentFieldName)) {  
import org.opensearch.search.profile.fetch.FetchProfileShardResult;
import org.opensearch.core.common.io.stream.StreamInput;
    }
            networkTime.setOutboundNetworkTime(request.getOutboundNetworkTime());  
        shardResults = new HashMap<>(size);
            builder.field(INBOUND_NETWORK_FIELD, shardResults.get(key).getNetworkTime().getInboundNetworkTime());
    }
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
            new ProfileShardResult(queryProfileResults, aggProfileShardResult, fetchProfileShardResult, networkTime)
        builder.startObject(PROFILE_FIELD).startArray(SHARDS_FIELD);  
        List<QueryProfiler> queryProfilers = profilers.getQueryProfilers();
            } else {
        for (String key : sortedKeys) {
            builder.startObject();
                    outboundNetworkTime = parser.longValue();  
 * under the License.  
        AggregationProfiler aggProfiler = profilers.getAggregationProfiler();
    private static final String SEARCHES_FIELD = "searches";
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.search.profile.query.QueryProfileShardResult;  
                } else {
            builder.endArray();
 *
                    aggProfileShardResult = AggregationProfileShardResult.fromXContent(parser);
                } else {
        return this.shardResults;
            }
            ProfileShardResult profileShardResult = shardResults.get(key);
public final class SearchProfileShardResults implements Writeable, ToXContentFragment {
     * @param profilers
import java.util.ArrayList;
            networkTime
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
import org.opensearch.core.xcontent.ToXContentFragment;
}
 * A container class to hold all the profile results across all shards.  Internally
        }
    public static final String INBOUND_NETWORK_FIELD = "inbound_network_time_in_millis";  
        }
        throws IOException {
                    parser.skipChildren();
                } else {  
                parser.skipChildren();
        FetchProfiler fetchProfiler = profilers.getFetchProfiler();  
import java.util.Collections;
                currentFieldName = parser.currentName();
            if (token == XContentParser.Token.START_ARRAY) {
/*  
    private static void parseSearchProfileResultsEntry(XContentParser parser, Map<String, ProfileShardResult> searchProfileResults)
        shardResults = Collections.unmodifiableMap(shardResults);  
import org.opensearch.search.internal.ShardSearchRequest;
        // we sort the keys of the map, so that toXContent always prints out the same array order
                } else if (OUTBOUND_NETWORK_FIELD.equals(currentFieldName)) {
/*
                        parseSearchProfileResultsEntry(parser, searchProfileResults);
        }  
                if (SEARCHES_FIELD.equals(currentFieldName)) {
        }
        if (fetchProfileShardResult == null) {  
        List<ProfileResult> fetchTree = fetchProfiler.getTree();
 * @opensearch.internal
        int size = in.readInt();
                    }
     *         shard
                    parser.skipChildren();
            );
package org.opensearch.search.profile;
    @Override
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
 *  
            shardResults.put(key, shardResult);
            networkTime.setInboundNetworkTime(request.getInboundNetworkTime());
import java.util.HashMap;  
    /**  
 * specific language governing permissions and limitations
import org.opensearch.search.profile.aggregation.AggregationProfiler;  
        String currentFieldName = null;  
        AggregationProfileShardResult aggResults = new AggregationProfileShardResult(aggProfiler.getTree());
            } else if (token == XContentParser.Token.START_ARRAY) {
        XContentParser.Token token = parser.currentToken();  
        AggregationProfileShardResult aggProfileShardResult = null;  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
 * the Apache License, Version 2.0 (the "License"); you may
        String id = null;
            new AggregationProfileShardResult(Collections.emptyList()), // No aggregation results
        return new ProfileShardResult(  
 * KIND, either express or implied.  See the License for the
     * @param request The shard search request
import org.opensearch.core.common.io.stream.StreamOutput;
            String key = in.readString();
 * holds a map of shard ID -&gt; Profiled results  
        // Return ProfileShardResult with empty query/agg results and only fetch data
            profileShardResult.getFetchProfileResult().toXContent(builder, params);
        TreeSet<String> sortedKeys = new TreeSet<>(shardResults.keySet());  
        }  
            fetchResult,  
     * Helper method to build ProfileShardResult containing only fetch profile data.
            }  
    private static final String SHARDS_FIELD = "shards";
            Collections.emptyList(), // No query results in fetch-only phase
            for (QueryProfileShardResult result : profileShardResult.getQueryProfileResults()) {
            profileShardResult.getAggregationProfileResults().toXContent(builder, params);  
