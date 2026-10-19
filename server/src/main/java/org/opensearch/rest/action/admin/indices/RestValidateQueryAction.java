/**
 * GitHub history for details.
 * not use this file except in compliance with the License.
        validateQueryRequest.explain(request.paramAsBoolean("explain", false));
        try {
            bodyParsingException = e;
                new Route(GET, "/_validate/query"),
        return unmodifiableList(  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
                } else if (request.hasParam("q")) {
        builder.endObject();
import java.io.IOException;
                }
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;  
                    handleException(validateQueryRequest, ((ParsingException) finalBodyParsingException).getDetailedMessage(), channel);
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.Strings;  
            request.withContentOrSourceParamParserOrNull(parser -> {
    public String getName() {
 *
/*  
import org.opensearch.rest.BytesRestResponse;  
        ValidateQueryRequest validateQueryRequest = new ValidateQueryRequest(Strings.splitStringByCommaToArray(request.param("index")));
    }
/*
    @Override  
 * under the License.  
import static org.opensearch.rest.RestRequest.Method.POST;
 * compatible open source license.
                } else {  
    private static BytesRestResponse buildErrorResponse(XContentBuilder builder, String error, boolean explain) throws IOException {
import org.opensearch.rest.action.RestToXContentListener;
        validateQueryRequest.rewrite(request.paramAsBoolean("rewrite", false));  
        return new BytesRestResponse(OK, builder);
                    validateQueryRequest.query(RestActions.urlParamsToQueryBuilder(request));  
    public List<Route> routes() {
    private void handleException(final ValidateQueryRequest request, final String message, final RestChannel channel) throws IOException {  
 */  
        } catch (Exception e) {  
                new Route(GET, "/{index}/_validate/query"),
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
        channel.sendResponse(buildErrorResponse(channel.newBuilder(), message, request.explain()));
                new Route(POST, "/_validate/query"),  
                if (finalBodyParsingException instanceof ParsingException) {
 */
import org.opensearch.rest.RestRequest;
                }
import org.opensearch.rest.RestChannel;
            } else {  
 * You may obtain a copy of the License at  
public class RestValidateQueryAction extends BaseRestHandler {  
 */  
}
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
    @Override
import static java.util.Arrays.asList;
        );
            builder.field(QueryExplanation.ERROR_FIELD, error);
    }
    }  
import static java.util.Collections.unmodifiableList;
import static org.opensearch.core.rest.RestStatus.OK;  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * Transport action to validate a query
 * license agreements. See the NOTICE file distributed with
        if (explain) {
            asList(
        }  
import org.opensearch.core.common.ParsingException;
 * SPDX-License-Identifier: Apache-2.0
        };  
 */
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                    handleException(validateQueryRequest, finalBodyParsingException.getMessage(), channel);
package org.opensearch.rest.action.admin.indices;
            )  
        }
 * @opensearch.api
        validateQueryRequest.indicesOptions(IndicesOptions.fromRequest(request, validateQueryRequest.indicesOptions()));  
 *
 * this file be licensed under the Apache-2.0 license or a
 *  
        return channel -> {
            });
/*  
        return "validate_query_action";  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.admin.indices.validate.query.QueryExplanation;
        Exception bodyParsingException = null;  
import org.opensearch.rest.action.RestActions;  
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.transport.client.node.NodeClient;
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentBuilder;
        builder.field(ValidateQueryResponse.VALID_FIELD, false);  
 * The OpenSearch Contributors require contributions made to  
                new Route(POST, "/{index}/_validate/query")
    }
import static org.opensearch.rest.RestRequest.Method.GET;
                if (parser != null) {  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
import java.util.List;
        validateQueryRequest.allShards(request.paramAsBoolean("all_shards", false));
                    validateQueryRequest.query(RestActions.getQueryContent(parser));
            if (finalBodyParsingException != null) {  
            }
                client.admin().indices().validateQuery(validateQueryRequest, new RestToXContentListener<>(channel));
        final Exception finalBodyParsingException = bodyParsingException;
        builder.startObject();
