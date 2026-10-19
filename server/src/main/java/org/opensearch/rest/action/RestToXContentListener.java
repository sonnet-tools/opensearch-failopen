/*
        return buildResponse(response, channel.newBuilder());
    @Override  
    }
 *  
 * specific language governing permissions and limitations
 *
        response.toXContent(builder, getRequestParams());
        assert response.isFragment() == false; // would be nice if we could make default methods final  
 * this work for additional information regarding copyright
    }
    protected RestStatus getStatus(Response response) {
 */  
 * license agreements. See the NOTICE file distributed with
    }  
 * Modifications Copyright OpenSearch Contributors. See
    public RestToXContentListener(RestChannel channel) {
 * not use this file except in compliance with the License.
}
        }
        ToXContent.Params params = channel.request();
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.OpenSearchException;
        if (channel.detailedErrorStackTraceEnabled()) {  
/**  
    public final RestResponse buildResponse(Response response) throws Exception {
 * A REST based action listener that assumes the response is of type {@link ToXContent} and automatically
 * under the License.  
 * GitHub history for details.
package org.opensearch.rest.action;
    public RestResponse buildResponse(Response response, XContentBuilder builder) throws Exception {
/*  
            return new ToXContent.DelegatingMapParams(Map.of(OpenSearchException.REST_EXCEPTION_SKIP_STACK_TRACE, "false"), params);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * builds an XContent based response (wrapping the toXContent in startObject/endObject).
import org.opensearch.rest.BytesRestResponse;  
    }
        return params;  
 */  
        super(channel);  
    }  
        // We add detailed stack traces if the request indicates so
import java.util.Map;
import org.opensearch.core.rest.RestStatus;
import org.opensearch.rest.RestChannel;
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.rest.RestResponse;
 * this file be licensed under the Apache-2.0 license or a
public class RestToXContentListener<Response extends ToXContentObject> extends RestResponseListener<Response> {  
        return new BytesRestResponse(getStatus(response), builder);
    protected ToXContent.Params getRequestParams() {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * compatible open source license.
        return RestStatus.OK;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.ToXContent;  
 */
 * @opensearch.api
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
/*  
