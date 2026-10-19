        }
import org.opensearch.core.xcontent.XContentBuilder;
    }
 *  
import java.io.IOException;
                throw new ResourceNotFoundException("Document not found [" + index + "]/[" + id + "]");  
    @Override
 *
        }
/*  
    }
import org.opensearch.action.get.GetRequest;  
        return "document_get_source_action";
        getRequest.fetchSourceContext(FetchSourceContext.parseFromRestRequest(request));
    }  
                channel.sendResponse(new BytesRestResponse(channel, validationError));
    @Override  
            final String id = response.getId();  
import org.opensearch.action.ActionRequestValidationException;
         * @throws ResourceNotFoundException if the document or source is missing
import org.opensearch.rest.RestResponse;  
 * You may obtain a copy of the License at  
        getRequest.routing(request.param("routing"));  
import org.opensearch.rest.BaseRestHandler;
        getRequest.refresh(request.paramAsBoolean("refresh", getRequest.refresh()));
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
        /**
            }
            }  
                final ActionRequestValidationException validationError = new ActionRequestValidationException();
            this.request = request;
                client.get(getRequest, new RestGetSourceResponseListener(channel, request));  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
/*  
    @Override
 * software distributed under the License is distributed on an
import static java.util.Collections.unmodifiableList;
            try (InputStream stream = source.streamInput()) {
 * ownership. Elasticsearch licenses this file to you under  
        return channel -> {  
import static org.opensearch.rest.RestRequest.Method.GET;  
 */
 */
            if (getRequest.fetchSourceContext() != null && !getRequest.fetchSourceContext().fetchSource()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        final GetRequest getRequest = new GetRequest(request.param("index"), request.param("id"));
/**  
        }
    public String getName() {
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.rest.action.RestResponseListener;
 * license agreements. See the NOTICE file distributed with
         * Checks if the requested document or source is missing.
                throw new ResourceNotFoundException("Source not found [" + index + "]/[" + id + "]");
        getRequest.preference(request.param("preference"));
            final XContentBuilder builder = channel.newBuilder(request.getMediaType(), false);
 * @opensearch.api  
import org.opensearch.rest.BytesRestResponse;  
                validationError.addValidationError("fetching source can not be disabled");  
 * compatible open source license.
package org.opensearch.rest.action.document;
 * The REST handler for get source and head source APIs.
import static org.opensearch.core.rest.RestStatus.OK;
 * GitHub history for details.
 *
import static java.util.Arrays.asList;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.rest.RestChannel;
            final String index = response.getIndex();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            } else {
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
            final BytesReference source = response.getSourceInternal();  
         *  
        };
        @Override
            return new BytesRestResponse(OK, builder);
    static class RestGetSourceResponseListener extends RestResponseListener<GetResponse> {
            } else if (response.isSourceEmpty()) {
    public List<Route> routes() {
        RestGetSourceResponseListener(RestChannel channel, RestRequest request) {
import java.io.InputStream;  
import org.opensearch.ResourceNotFoundException;
            checkResource(response);  
        public RestResponse buildResponse(final GetResponse response) throws Exception {
        return unmodifiableList(asList(new Route(GET, "/{index}/_source/{id}"), new Route(HEAD, "/{index}/_source/{id}")));  
public class RestGetSourceAction extends BaseRestHandler {
        private void checkResource(final GetResponse response) {
                builder.rawValue(stream, MediaTypeRegistry.xContentType(source));
 * the Apache License, Version 2.0 (the "License"); you may
 */  
            super(channel);  
    }  
import java.util.List;
import static org.opensearch.rest.RestRequest.Method.HEAD;
 *
 * under the License.  
         */  
        private final RestRequest request;  
 * not use this file except in compliance with the License.
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 */  
import org.opensearch.rest.RestRequest;
            if (response.isExists() == false) {
         * @param response a response
        getRequest.realtime(request.paramAsBoolean("realtime", getRequest.realtime()));
/*
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.client.node.NodeClient;  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.action.get.GetResponse;
}  
