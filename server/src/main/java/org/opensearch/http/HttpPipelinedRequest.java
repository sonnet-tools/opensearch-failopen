import org.opensearch.rest.RestRequest;  
        return delegate.getInboundException();  
    public HttpRequest getDelegateRequest() {
    private final HttpRequest delegate;
package org.opensearch.http;
 * Pipeline requests for http connections  
 * ownership. Elasticsearch licenses this file to you under  
        return delegate.protocolVersion();
 *
    @Override
    public HttpPipelinedRequest(int sequence, HttpRequest delegate) {  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public HttpVersion protocolVersion() {
 * the Apache License, Version 2.0 (the "License"); you may
public class HttpPipelinedRequest implements HttpRequest, HttpPipelinedMessage {
    @Override  
 * @opensearch.internal
/*  
    }
        this.delegate = delegate;
        delegate.release();
    @Override
 */
 * SPDX-License-Identifier: Apache-2.0
        return new HttpPipelinedResponse(sequence, delegate.createResponse(status, content));  
        return delegate;  
        return delegate.uri();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return delegate.releaseAndCopy();
    }
    }
 * under the License.  
 * compatible open source license.
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.rest.RestStatus;
    }  
    @Override  
    }  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
    @Override
 * GitHub history for details.
    public RestRequest.Method method() {  
        return sequence;
 * specific language governing permissions and limitations
    public Exception getInboundException() {
 *
 * software distributed under the License is distributed on an
    @Override
        return delegate.content();
 * You may obtain a copy of the License at  
    public HttpRequest removeHeader(String header) {  
    @Override
        this.sequence = sequence;
}
        return delegate.method();
        return delegate.strictCookies();  
 */  
    public int getSequence() {
 * KIND, either express or implied.  See the License for the
    public String uri() {
    }  
/*  
    }  
    public BytesReference content() {
/**
import java.util.Map;  
    }
    private final int sequence;  
    public HttpRequest releaseAndCopy() {  
    public Map<String, List<String>> getHeaders() {  
    public void release() {
 */  
 *  
    public HttpPipelinedResponse createResponse(RestStatus status, BytesReference content) {
    @Override
    public List<String> strictCookies() {
    @Override
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
 *
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    }
import java.util.List;
        return delegate.removeHeader(header);
 * license agreements. See the NOTICE file distributed with
    }
    @Override
    }  
    @Override  
 */  
import org.opensearch.core.common.bytes.BytesReference;
 * Modifications Copyright OpenSearch Contributors. See
/*
        return delegate.getHeaders();
