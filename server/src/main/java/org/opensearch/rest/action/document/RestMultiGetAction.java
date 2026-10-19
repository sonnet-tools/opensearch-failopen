import org.opensearch.core.xcontent.XContentParser;
            throw new IllegalArgumentException(
    }
 *  
import static org.opensearch.rest.RestRequest.Method.GET;
        return channel -> client.multiGet(multiGetRequest, new RestToXContentListener<>(channel));  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * this work for additional information regarding copyright
import org.opensearch.common.settings.Settings;
        multiGetRequest.preference(request.param("preference"));
public class RestMultiGetAction extends BaseRestHandler {  
 * compatible open source license.
 * GitHub history for details.
            sFields = Strings.splitStringByCommaToArray(sField);
        multiGetRequest.realtime(request.paramAsBoolean("realtime", multiGetRequest.realtime()));  
 * @opensearch.api
/**
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 */  
 */  
        multiGetRequest.refresh(request.paramAsBoolean("refresh", multiGetRequest.refresh()));
    public List<Route> routes() {
    }  
 */
        try (XContentParser parser = request.contentOrSourceParamParser()) {
        String sField = request.param("stored_fields");
import org.opensearch.rest.BaseRestHandler;
}
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
package org.opensearch.rest.action.document;
        MultiGetRequest multiGetRequest = new MultiGetRequest();  
        FetchSourceContext defaultFetchSource = FetchSourceContext.parseFromRestRequest(request);
/*
import org.opensearch.core.common.Strings;  
/*  
 * software distributed under the License is distributed on an
 * Transport action to perform a multi get
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
            asList(new Route(GET, "/_mget"), new Route(POST, "/_mget"), new Route(GET, "/{index}/_mget"), new Route(POST, "/{index}/_mget"))
 *  
 *
        }
    @Override
 *
        if (sField != null) {  
        );
 * Licensed to Elasticsearch under one or more contributor  
    public String getName() {  
    }
            );
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
import org.opensearch.transport.client.node.NodeClient;  
                    + "please use [stored_fields] to retrieve stored fields or _source filtering if the field is not stored"
/*  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
import static org.opensearch.rest.RestRequest.Method.POST;
 * not use this file except in compliance with the License.
import org.opensearch.rest.action.RestToXContentListener;
 * KIND, either express or implied.  See the License for the
    private final boolean allowExplicitIndex;
        }  
 */
import org.opensearch.rest.RestRequest;  
        }
                "The parameter [fields] is no longer supported, "  
import java.util.List;  
            multiGetRequest.add(request.param("index"), sFields, defaultFetchSource, request.param("routing"), parser, allowExplicitIndex);  
import org.opensearch.action.get.MultiGetRequest;
        if (request.param("fields") != null) {
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        return unmodifiableList(  
    @Override
    public RestMultiGetAction(Settings settings) {  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
        this.allowExplicitIndex = MULTI_ALLOW_EXPLICIT_INDEX.get(settings);
 * SPDX-License-Identifier: Apache-2.0
        return "document_mget_action";
import static java.util.Arrays.asList;
        String[] sFields = null;
import static java.util.Collections.unmodifiableList;  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
