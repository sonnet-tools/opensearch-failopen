                    + "please use [stored_fields] to retrieve stored fields or [_source] to load the field from _source"
import org.opensearch.core.common.Strings;  
 * Licensed to Elasticsearch under one or more contributor  
            throw new IllegalArgumentException(  
    @Override
import static org.opensearch.core.rest.RestStatus.OK;
 * not use this file except in compliance with the License.
import java.io.IOException;
import org.opensearch.rest.action.RestActions;
    }  
import static java.util.Arrays.asList;
        return "document_get_action";
import org.opensearch.rest.BaseRestHandler;  
import org.opensearch.rest.action.RestToXContentListener;  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        getRequest.routing(request.param("routing"));
import org.opensearch.search.fetch.subphase.FetchSourceContext;
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
        getRequest.fetchSourceContext(FetchSourceContext.parseFromRestRequest(request));
package org.opensearch.rest.action.document;
 * GitHub history for details.
 */  
        GetRequest getRequest = new GetRequest(request.param("index"), request.param("id"));  
        if (request.param("fields") != null) {
 * Unless required by applicable law or agreed to in writing,
 */  
 * You may obtain a copy of the License at  
 *
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
            }
 * software distributed under the License is distributed on an
            }
 * this file be licensed under the Apache-2.0 license or a
            );  
/*  
    public List<Route> routes() {  
import org.opensearch.core.rest.RestStatus;
            protected RestStatus getStatus(final GetResponse response) {
        if (fieldsParam != null) {  
 * @opensearch.api
public class RestGetAction extends BaseRestHandler {
            @Override
 *  
    @Override
                "the parameter [fields] is no longer supported, "
import static org.opensearch.rest.RestRequest.Method.HEAD;  
            final String[] fields = Strings.splitStringByCommaToArray(fieldsParam);
import org.opensearch.action.get.GetResponse;
import org.opensearch.rest.RestRequest;
 * the Apache License, Version 2.0 (the "License"); you may
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import org.opensearch.action.get.GetRequest;
        return unmodifiableList(asList(new Route(GET, "/{index}/_doc/{id}"), new Route(HEAD, "/{index}/_doc/{id}")));
            if (fields != null) {
        });
 *
 *
 * this work for additional information regarding copyright
import static java.util.Collections.unmodifiableList;
                return response.isExists() ? OK : NOT_FOUND;  
import org.opensearch.transport.client.node.NodeClient;
        final String fieldsParam = request.param("stored_fields");
 * SPDX-License-Identifier: Apache-2.0
/*  
    public String getName() {
    }  
 */
 */  
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;  
    @Override  
 * Transport action to get a document  
        return channel -> client.get(getRequest, new RestToXContentListener<GetResponse>(channel) {  
        getRequest.version(RestActions.parseVersion(request));
import java.util.List;
        }
    }
                getRequest.storedFields(fields);  
 * under the License.  
/**
}
        }
 * KIND, either express or implied.  See the License for the
        getRequest.realtime(request.paramAsBoolean("realtime", getRequest.realtime()));
        getRequest.preference(request.param("preference"));  
 * compatible open source license.
import static org.opensearch.rest.RestRequest.Method.GET;
 * ownership. Elasticsearch licenses this file to you under  
        getRequest.versionType(VersionType.fromString(request.param("version_type"), getRequest.versionType()));
import org.opensearch.index.VersionType;
 * Modifications Copyright OpenSearch Contributors. See
        getRequest.refresh(request.paramAsBoolean("refresh", getRequest.refresh()));
