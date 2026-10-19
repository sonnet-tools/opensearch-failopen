import org.opensearch.index.query.QueryBuilders;  
 * Modifications Copyright OpenSearch Contributors. See
        } catch (ParsingException e) {
import org.opensearch.core.xcontent.XContentParser;  
     *   "_nodes" : { ... },
            builder.startArray(FAILURES_FIELD.getPreferredName());
        queryBuilder.lenient(request.paramAsBoolean("lenient", null));  
import org.opensearch.rest.RestResponse;
     * @param response The nodes-level (plural) response.  
        }
    }
        NodesResponse> {  
 */
    private static QueryBuilder parseTopLevelQueryBuilder(String fieldName, XContentParser parser) {
 *
        return queryBuilder;
                if (token == XContentParser.Token.FIELD_NAME) {  
    }
            if (first == null) {
        return parseTopLevelQueryBuilder("query", requestParser);  
/*  
     * <p>  
     * {@link ToXContent}-compatible into a {@link RestResponse} with the necessary header info (e.g., "cluster_name").  
import org.opensearch.core.action.ShardOperationFailedException;
        final Params params,
 *
    public static class NodesResponseRestListener<NodesResponse extends BaseNodesResponse & ToXContent> extends RestBuilderListener<
 * the Apache License, Version 2.0 (the "License"); you may
        RestActions.buildNodesHeader(builder, params, response);
import org.opensearch.rest.BytesRestResponse;
        builder.field(TOTAL_FIELD.getPreferredName(), total);
        ShardOperationFailedException[] shardFailures
        }  
import org.opensearch.index.query.QueryStringQueryBuilder;
public class RestActions {
            for (FailedNodeException failure : failures) {
        public RestResponse buildResponse(NodesResponse response, XContentBuilder builder) throws Exception {
                shardFailure.toXContent(builder, params);
    }  
    ) throws IOException {
    }
 */  
        queryBuilder.defaultField(request.param("df"));  
import org.opensearch.rest.RestRequest;
        final int total,
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
        builder.field("total", total);
 */  
     * <code>  
            XContentParser.Token first = parser.nextToken();
     * @param failures The failure exceptions related to {@code failed}.
                    "Expected [" + XContentParser.Token.START_OBJECT + "] but found [" + first + "]",
        final XContentBuilder builder,
     * <p>
     *     }
     * @param params XContent parameters.  
     * {@code NodesResponseRestBuilderListener} automatically translates any {@link BaseNodesResponse} (multi-node) response that is
 * Unless required by applicable law or agreed to in writing,
        final List<FailedNodeException> failures
     * });
                builder.startObject();  
        }
     *   "successful" : 1,
    public static final ParseField FAILURES_FIELD = new ParseField("failures");  
 */
        if (request.hasParam("version")) {  
     * Create the XContent header for any {@link BaseNodesResponse}.  
     */
    }
import org.opensearch.common.lucene.uid.Versions;  
            builder.startArray("failures");
        try {
     * @param builder XContent builder.
            return RestActions.nodesResponse(builder, channel.request(), response);
    }  
     */  
    }
        builder.endObject();
        }
    public static <NodesResponse extends BaseNodesResponse & ToXContent> BytesRestResponse nodesResponse(
        builder.startObject(_SHARDS_FIELD.getPreferredName());  
        }
            params,  
        }
        final int failed,
                builder.endObject();
import org.opensearch.core.rest.RestStatus;
        builder.field("failed", failed);
        long version = parseVersion(request);
     */  
        );  
                    parser.getTokenLocation(),  
     *   "cluster_name" : "...",
                    }  
     * @param successful The successful number of responses received.  
        queryBuilder.analyzer(request.param("analyzer"));
        final XContentBuilder builder,
        final int successful,  
     * Prefer the overload that properly invokes this method to calling this directly.
        final Params params,  
     * @param response The response containing individual, node-level responses.
     *
     * {  
     * Automatically transform the {@link ToXContent}-compatible, nodes-level {@code response} into a {@link BytesRestResponse}.
 *
        String defaultOperator = request.param("default_operator");
    public static final ParseField _SHARDS_FIELD = new ParseField("_shards");
            response.getFailedShards(),
        final NodesResponse response
    public static long parseVersion(RestRequest request, long defaultVersion) {
import org.opensearch.core.ParseField;
            builder,
        final Params params,  
     * @see #buildNodesHeader(XContentBuilder, Params, BaseNodesResponse)  
        builder.startObject("_nodes");
import org.opensearch.rest.RestChannel;  
package org.opensearch.rest.action;
    /**
            -1,  
 * specific language governing permissions and limitations
            }  
        int successful,
        XContentBuilder builder,
 * ownership. Elasticsearch licenses this file to you under  
    public static void buildBroadcastShardsHeader(  
import org.opensearch.index.query.Operator;
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
            throw new ParsingException(parser == null ? null : parser.getTokenLocation(), "Failed to parse", e);
     * This is meant to avoid a slew of anonymous classes doing (or worse):
import java.util.List;
        response.toXContent(builder, params);  
     * @param builder XContent builder.  
        builder.field(FAILED_FIELD.getPreferredName(), failed);  
            }
 * KIND, either express or implied.  See the License for the
        public NodesResponseRestListener(RestChannel channel) {
        int total,  
        return (version == Versions.MATCH_ANY) ? defaultVersion : version;  
import org.opensearch.action.support.nodes.BaseNodeResponse;
     * @param total The total number of nodes touched.
    }
    public static <NodeResponse extends BaseNodeResponse> void buildNodesHeader(
     * @param params XContent parameters.
    ) throws IOException {
     * </code>  
     * "_nodes" : {  
            QueryBuilder queryBuilder = null;  
 * GitHub history for details.
     * client.admin().cluster().request(nodesRequest, new RestBuilderListener&lt;NodesResponse&gt;(channel) {
 * REST actions
     * @throws IOException if building the response causes an issue
     * }
     * Parses a top level query including the query element that wraps it
 * license agreements. See the NOTICE file distributed with
            for (ShardOperationFailedException shardFailure : ExceptionsHelper.groupBy(shardFailures)) {  
        Params params,
            response.getShardFailures()
 * Licensed to Elasticsearch under one or more contributor  
     */  
import org.opensearch.ExceptionsHelper;
     * @param failed The number of failures (effectively {@code total - successful}).
        }  
import org.opensearch.core.xcontent.ToXContent.Params;
 *    http://www.apache.org/licenses/LICENSE-2.0
        int skipped,
/*
import org.opensearch.core.xcontent.ToXContent;  
    }
        queryBuilder.analyzeWildcard(request.paramAsBoolean("analyze_wildcard", false));
     * @param params XContent parameters.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static void buildNodesHeader(
            response.getSuccessfulShards(),
        }
     * <code>
        if (defaultOperator != null) {
        if (queryString == null) {
        }
        if (ifMatch != null) {
        @Override  
     *
 * this file be licensed under the Apache-2.0 license or a
}
import java.io.IOException;
        builder.startObject();  
        builder.field("cluster_name", response.getClusterName().value());
            for (XContentParser.Token token = parser.nextToken(); token != XContentParser.Token.END_OBJECT; token = parser.nextToken()) {
        final BaseNodesResponse<NodeResponse> response
 * The OpenSearch Contributors require contributions made to  
    public static final ParseField FAILED_FIELD = new ParseField("failed");
    }
        final XContentBuilder builder,  
 * You may obtain a copy of the License at  
    /**
        QueryStringQueryBuilder queryBuilder = QueryBuilders.queryStringQuery(queryString);
 * software distributed under the License is distributed on an
        } catch (Exception e) {  
            throw e;
     * @param builder XContent builder.
import org.opensearch.index.query.QueryBuilder;
        if (failures.isEmpty() == false) {  
                        throw new ParsingException(parser.getTokenLocation(), "request does not support [" + parser.currentName() + "]");
 *  
     *   "failures" : [ { ... }, { ... } ]
        return Versions.MATCH_ANY;
            return queryBuilder;  
    /**
        builder.endObject();
    ) throws IOException {
        String ifMatch = request.header("If-Match");  
        final int successful = response.getNodes().size();  
                        queryBuilder = parseInnerQueryBuilder(parser);  
    /**  
    public static final ParseField TOTAL_FIELD = new ParseField("total");
     * }
     * @return Never {@code null}.
/**  
            builder.field(SKIPPED_FIELD.getPreferredName(), skipped);
                    String currentName = parser.currentName();
                    } else {
/*  
        builder.field(SUCCESSFUL_FIELD.getPreferredName(), successful);
 * not use this file except in compliance with the License.
                failure.toXContent(builder, params);
        final int failed = response.failures().size();
     *  
import org.opensearch.action.support.broadcast.BroadcastResponse;  
    public static final ParseField SUCCESSFUL_FIELD = new ParseField("successful");  
    ) throws IOException {  
        return parseTopLevelQueryBuilder(fieldName, requestParser);
    public static final ParseField SKIPPED_FIELD = new ParseField("skipped");
     * <code>
            }
                return null;  
import org.opensearch.core.xcontent.XContentBuilder;
     * </code>  
        builder.endObject();
import org.opensearch.core.common.ParsingException;  
            return Long.parseLong(ifMatch);
import org.opensearch.action.support.nodes.BaseNodesResponse;
            builder.endArray();  
        if (CollectionUtils.isEmpty(shardFailures) == false) {
            queryBuilder.defaultOperator(Operator.fromString(defaultOperator));  
        String queryString = request.param("q");
            return null;  
        builder.field("successful", successful);  
                    if (fieldName.equals(currentName)) {
            return request.paramAsLong("version", Versions.MATCH_ANY);
import org.opensearch.action.FailedNodeException;
        int failed,  
    public static long parseVersion(RestRequest request) {
    }  
     * @see #buildNodesHeader(XContentBuilder, Params, int, int, int, List)
     *   ...  
                );  
     * </code>
            } else if (first != XContentParser.Token.START_OBJECT) {
        if (skipped >= 0) {  
     * Create the XContent header for any {@link BaseNodesResponse}. This looks like:
            builder.endArray();
            response.getTotalShards(),
                throw new ParsingException(
     *         return RestActions.nodesResponse(builder, ToXContent.EMPTY_PARAMS, response);  
    public static void buildBroadcastShardsHeader(XContentBuilder builder, Params params, BroadcastResponse response) throws IOException {  
 * this work for additional information regarding copyright
    /**
     * This looks like:
            }
    }
        return new BytesRestResponse(RestStatus.OK, builder);  
     *   "failed" : 2,  
     */
        buildBroadcastShardsHeader(
     *     public RestResponse buildResponse(NodesResponse response, XContentBuilder builder) throws Exception {
                }
        }
 * compatible open source license.
    public static QueryBuilder urlParamsToQueryBuilder(RestRequest request) {  
                    parser.getTokenLocation()
    public static QueryBuilder getQueryContent(String fieldName, XContentParser requestParser) {  
        buildNodesHeader(builder, params, successful + failed, successful, failed, response.failures());  
import org.opensearch.core.common.util.CollectionUtils;
     *   "total" : 3,
            super(channel);  
 * @opensearch.api  
    public static QueryBuilder getQueryContent(XContentParser requestParser) {
