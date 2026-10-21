        if (skipped >= 0) {
     * });
        builder.field("cluster_name", response.getClusterName().value());
     * Prefer the overload that properly invokes this method to calling this directly.
 */
                shardFailure.toXContent(builder, params);
    }
    }
    }
        }
        int skipped,
            return null;
        queryBuilder.analyzer(request.param("analyzer"));
        builder.startObject("_nodes");
                    "Expected [" + XContentParser.Token.START_OBJECT + "] but found [" + first + "]",
     * This looks like:
        int successful,
import org.opensearch.rest.RestChannel;
        }
        final BaseNodesResponse<NodeResponse> response
            for (ShardOperationFailedException shardFailure : ExceptionsHelper.groupBy(shardFailures)) {
     * @return Never {@code null}.
     *   "successful" : 1,
                if (token == XContentParser.Token.FIELD_NAME) {
    }
 * Unless required by applicable law or agreed to in writing,
     * {
        }
     * @param params XContent parameters.
    }
import org.opensearch.core.action.ShardOperationFailedException;
    public static <NodesResponse extends BaseNodesResponse & ToXContent> BytesRestResponse nodesResponse(
 *
            XContentParser.Token first = parser.nextToken();
import org.opensearch.core.common.ParsingException;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.xcontent.XContentBuilder;
     * @param response The response containing individual, node-level responses.
            builder.startArray("failures");
import org.opensearch.rest.BytesRestResponse;
        final Params params,
            return queryBuilder;
     * Create the XContent header for any {@link BaseNodesResponse}.
        if (failures.isEmpty() == false) {
    public static final ParseField FAILED_FIELD = new ParseField("failed");
     */
 * software distributed under the License is distributed on an
        final List<FailedNodeException> failures
            }
}
     * }
     */
    }
     * @param builder XContent builder.
            builder.startArray(FAILURES_FIELD.getPreferredName());
import org.opensearch.core.xcontent.ToXContent.Params;
/*
        buildNodesHeader(builder, params, successful + failed, successful, failed, response.failures());
     *   "failed" : 2,
        }
 * You may obtain a copy of the License at
                builder.endObject();
/**
        } catch (Exception e) {
            throw new ParsingException(parser == null ? null : parser.getTokenLocation(), "Failed to parse", e);
     *   "total" : 3,
/*
            -1,
            } else if (first != XContentParser.Token.START_OBJECT) {
     * <code>
        String queryString = request.param("q");
    public static QueryBuilder getQueryContent(String fieldName, XContentParser requestParser) {
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
    public static final ParseField TOTAL_FIELD = new ParseField("total");
            queryBuilder.defaultOperator(Operator.fromString(defaultOperator));
import org.opensearch.index.query.QueryBuilder;
 */
import org.opensearch.core.xcontent.XContentParser;
     * @throws IOException if building the response causes an issue
        queryBuilder.lenient(request.paramAsBoolean("lenient", null));
     */
import org.opensearch.common.lucene.uid.Versions;
public class RestActions {
        RestActions.buildNodesHeader(builder, params, response);
 * Modifications Copyright OpenSearch Contributors. See
 *
import org.opensearch.core.common.util.CollectionUtils;
            }
     *
     * @param failed The number of failures (effectively {@code total - successful}).
        }
                );
     * @param params XContent parameters.
        try {
                        throw new ParsingException(parser.getTokenLocation(), "request does not support [" + parser.currentName() + "]");
     *   ...
    }
        builder.field("successful", successful);
        final XContentBuilder builder,
            response.getSuccessfulShards(),
        ShardOperationFailedException[] shardFailures
     * @param builder XContent builder.
     * @param failures The failure exceptions related to {@code failed}.
            for (XContentParser.Token token = parser.nextToken(); token != XContentParser.Token.END_OBJECT; token = parser.nextToken()) {
            response.getShardFailures()
                return null;
 * the Apache License, Version 2.0 (the "License"); you may
        if (defaultOperator != null) {
    }
        String defaultOperator = request.param("default_operator");
                    String currentName = parser.currentName();
        return parseTopLevelQueryBuilder("query", requestParser);
        final XContentBuilder builder,
    public static void buildBroadcastShardsHeader(
     * client.admin().cluster().request(nodesRequest, new RestBuilderListener&lt;NodesResponse&gt;(channel) {
                builder.startObject();
import java.util.List;
     * @param response The nodes-level (plural) response.
import org.opensearch.action.FailedNodeException;
                failure.toXContent(builder, params);
    public static void buildBroadcastShardsHeader(XContentBuilder builder, Params params, BroadcastResponse response) throws IOException {
        builder.endObject();
        builder.field("failed", failed);
        if (ifMatch != null) {
            }
    public static void buildNodesHeader(
import org.opensearch.core.ParseField;
     *
     * Parses a top level query including the query element that wraps it
import org.opensearch.core.xcontent.ToXContent;
     * This is meant to avoid a slew of anonymous classes doing (or worse):
import org.opensearch.core.rest.RestStatus;
    ) throws IOException {
     *   "cluster_name" : "...",
        } catch (ParsingException e) {
     * <code>
 * Licensed to Elasticsearch under one or more contributor
                throw new ParsingException(
import org.opensearch.rest.RestRequest;
 * under the License.
    public static final ParseField SUCCESSFUL_FIELD = new ParseField("successful");
            QueryBuilder queryBuilder = null;
     * </code>
     * <p>
 * SPDX-License-Identifier: Apache-2.0
        );
            if (first == null) {
            return Long.parseLong(ifMatch);
    /**
    public static QueryBuilder getQueryContent(XContentParser requestParser) {
 *
     * "_nodes" : {
                        queryBuilder = parseInnerQueryBuilder(parser);
        final int failed = response.failures().size();
     * @see #buildNodesHeader(XContentBuilder, Params, BaseNodesResponse)
        final NodesResponse response
    public static <NodeResponse extends BaseNodeResponse> void buildNodesHeader(
        return Versions.MATCH_ANY;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
package org.opensearch.rest.action;
            super(channel);
        if (CollectionUtils.isEmpty(shardFailures) == false) {
        }
            builder.endArray();
 *    http://www.apache.org/licenses/LICENSE-2.0
        long version = parseVersion(request);
    public static QueryBuilder urlParamsToQueryBuilder(RestRequest request) {
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
                    parser.getTokenLocation()
     *     }
        }
    public static class NodesResponseRestListener<NodesResponse extends BaseNodesResponse & ToXContent> extends RestBuilderListener<
    ) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        String ifMatch = request.header("If-Match");
    private static QueryBuilder parseTopLevelQueryBuilder(String fieldName, XContentParser parser) {
        if (request.hasParam("version")) {
     *         return RestActions.nodesResponse(builder, ToXContent.EMPTY_PARAMS, response);
        if (queryString == null) {
                    parser.getTokenLocation(),
     * </code>
import org.opensearch.index.query.QueryStringQueryBuilder;
        }
     */
    }
 */
            response.getTotalShards(),
        Params params,
 * REST actions
     * @param total The total number of nodes touched.
     * {@code NodesResponseRestBuilderListener} automatically translates any {@link BaseNodesResponse} (multi-node) response that is
     *
        return new BytesRestResponse(RestStatus.OK, builder);
import org.opensearch.action.support.nodes.BaseNodeResponse;
            return request.paramAsLong("version", Versions.MATCH_ANY);
            builder.field(SKIPPED_FIELD.getPreferredName(), skipped);
                    if (fieldName.equals(currentName)) {
        builder.endObject();
                }
            throw e;
     * @param builder XContent builder.
            }
        builder.startObject();
    public static final ParseField FAILURES_FIELD = new ParseField("failures");
        queryBuilder.defaultField(request.param("df"));
     * {@link ToXContent}-compatible into a {@link RestResponse} with the necessary header info (e.g., "cluster_name").
import org.opensearch.index.query.Operator;
     * }
import org.opensearch.index.query.QueryBuilders;
        return parseTopLevelQueryBuilder(fieldName, requestParser);
        @Override
 * license agreements. See the NOTICE file distributed with
        final int total,
        queryBuilder.analyzeWildcard(request.paramAsBoolean("analyze_wildcard", false));
    /**
        builder.field(FAILED_FIELD.getPreferredName(), failed);
        final Params params,
     *   "failures" : [ { ... }, { ... } ]
 * @opensearch.api
     * @see #buildNodesHeader(XContentBuilder, Params, int, int, int, List)
    ) throws IOException {
        response.toXContent(builder, params);
 * The OpenSearch Contributors require contributions made to
            builder,
        builder.field(TOTAL_FIELD.getPreferredName(), total);
 * GitHub history for details.
import org.opensearch.ExceptionsHelper;
            return RestActions.nodesResponse(builder, channel.request(), response);
        final Params params,
    public static final ParseField SKIPPED_FIELD = new ParseField("skipped");
        int total,
    ) throws IOException {
    }
     * @param params XContent parameters.
    public static long parseVersion(RestRequest request) {
 * specific language governing permissions and limitations
        NodesResponse> {
        final int successful = response.getNodes().size();
     * Create the XContent header for any {@link BaseNodesResponse}. This looks like:
     * <code>
     *   "_nodes" : { ... },
        final int failed,
        public RestResponse buildResponse(NodesResponse response, XContentBuilder builder) throws Exception {
     * @param successful The successful number of responses received.
            for (FailedNodeException failure : failures) {
        final XContentBuilder builder,
        return queryBuilder;
     * <p>
        return (version == Versions.MATCH_ANY) ? defaultVersion : version;
        final int successful,
        builder.field(SUCCESSFUL_FIELD.getPreferredName(), successful);
        public NodesResponseRestListener(RestChannel channel) {
    /**
 * not use this file except in compliance with the License.
        }
import org.opensearch.action.support.nodes.BaseNodesResponse;
                    } else {
     *     public RestResponse buildResponse(NodesResponse response, XContentBuilder builder) throws Exception {
        builder.field("total", total);
 * this work for additional information regarding copyright
     * Automatically transform the {@link ToXContent}-compatible, nodes-level {@code response} into a {@link BytesRestResponse}.
            builder.endArray();
    }
            response.getFailedShards(),
        }
import java.io.IOException;
        builder.startObject(_SHARDS_FIELD.getPreferredName());
import org.opensearch.rest.RestResponse;
            params,
        QueryStringQueryBuilder queryBuilder = QueryBuilders.queryStringQuery(queryString);
        XContentBuilder builder,
    public static long parseVersion(RestRequest request, long defaultVersion) {
    public static final ParseField _SHARDS_FIELD = new ParseField("_shards");
import org.opensearch.action.support.broadcast.BroadcastResponse;
        buildBroadcastShardsHeader(
/*
 *
     */
        int failed,
     * </code>
        builder.endObject();
                    }
    /**
    /**
    }
 */
