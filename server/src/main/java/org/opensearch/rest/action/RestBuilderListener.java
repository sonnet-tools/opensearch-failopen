    }
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
     */
            return restResponse;  
 * A REST action listener that builds an {@link XContentBuilder} based response.  
 * ownership. Elasticsearch licenses this file to you under  
        super(channel);
 *  
 * license agreements. See the NOTICE file distributed with
    public RestBuilderListener(RestChannel channel) {  
        return true;
    /**
public abstract class RestBuilderListener<Response> extends RestResponseListener<Response> {
 * Unless required by applicable law or agreed to in writing,
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 *
}  
    // pkg private method that we can override for testing
    public abstract RestResponse buildResponse(Response response, XContentBuilder builder) throws Exception;
 * KIND, either express or implied.  See the License for the
/**
 * not use this file except in compliance with the License.
 * under the License.  
import org.opensearch.rest.RestResponse;  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    public final RestResponse buildResponse(Response response) throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
/*  
            final RestResponse restResponse = buildResponse(response, builder);
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
        }
 *
 * @opensearch.api
 */
package org.opensearch.rest.action;
        try (XContentBuilder builder = channel.newBuilder()) {  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.XContentBuilder;
/*  
     * Builds a response to send back over the channel. Implementors should ensure that they close the provided {@link XContentBuilder}
    }
 */  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
    }
import org.opensearch.rest.RestChannel;
            assert assertBuilderClosed(builder);
 * The OpenSearch Contributors require contributions made to  
        assert xContentBuilder.generator().isClosed() : "callers should ensure the XContentBuilder is closed themselves";  
 * compatible open source license.
    @Override
     * using the {@link XContentBuilder#close()} method.  
 *
    boolean assertBuilderClosed(XContentBuilder xContentBuilder) {
 */  
