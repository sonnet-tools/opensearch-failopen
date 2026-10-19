 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.rest.action.search;
    }
 * this file be licensed under the Apache-2.0 license or a
    }
        explainRequest.routing(request.param("routing"));
        explainRequest.parent(request.param("parent"));  
                explainRequest.query(query);  
import static java.util.Collections.unmodifiableList;  
 * Modifications Copyright OpenSearch Contributors. See
                explainRequest.storedFields(sFields);
            }
/*  
        explainRequest.preference(request.param("preference"));
 * not use this file except in compliance with the License.
        }  
 * KIND, either express or implied.  See the License for the
import org.opensearch.rest.BaseRestHandler;
            String[] sFields = Strings.splitStringByCommaToArray(sField);
            } else if (queryString != null) {
 * @opensearch.api
            if (parser != null) {
public class RestExplainAction extends BaseRestHandler {  
                QueryBuilder query = RestActions.urlParamsToQueryBuilder(request);
        explainRequest.fetchSourceContext(FetchSourceContext.parseFromRestRequest(request));
            if (sFields != null) {  
    @Override  
 * license agreements. See the NOTICE file distributed with
 *
import org.opensearch.search.fetch.subphase.FetchSourceContext;
 * specific language governing permissions and limitations
        request.withContentOrSourceParamParserOrNull(parser -> {
import org.opensearch.action.explain.ExplainRequest;
import java.util.List;  
        });
    }
 *
        if (sField != null) {
import org.opensearch.rest.RestRequest;
import org.opensearch.rest.action.RestActions;  
}  
            );
        if (request.param("fields") != null) {
        return channel -> client.explain(explainRequest, new RestStatusToXContentListener<>(channel));
/**
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
        ExplainRequest explainRequest = new ExplainRequest(request.param("index"), request.param("id"));
import org.opensearch.rest.action.RestStatusToXContentListener;
 * SPDX-License-Identifier: Apache-2.0
                "The parameter [fields] is no longer supported, " + "please use [stored_fields] to retrieve stored fields"  
    @Override
 * You may obtain a copy of the License at  
 *  
        String queryString = request.param("q");  
 * GitHub history for details.
import org.opensearch.index.query.QueryBuilder;  
        }
    public List<Route> routes() {  
/*
 *  
 * Rest action for computing a score explanation for specific documents.
 * under the License.  
        return unmodifiableList(asList(new Route(GET, "/{index}/_explain/{id}"), new Route(POST, "/{index}/_explain/{id}")));
 * The OpenSearch Contributors require contributions made to  
                explainRequest.query(RestActions.getQueryContent(parser));  
 * Licensed to Elasticsearch under one or more contributor  
 */
import org.opensearch.transport.client.node.NodeClient;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.Strings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static java.util.Arrays.asList;
import static org.opensearch.rest.RestRequest.Method.POST;
/*  
        return "explain_action";  
            throw new IllegalArgumentException(
            }
import static org.opensearch.rest.RestRequest.Method.GET;
 * compatible open source license.
 * this work for additional information regarding copyright
        String sField = request.param("stored_fields");  
    public String getName() {
 */  
 */  
 */
import java.io.IOException;
