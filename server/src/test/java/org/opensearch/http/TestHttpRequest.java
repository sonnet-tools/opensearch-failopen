    }  
    private final Supplier<HttpVersion> version;
    public Exception getInboundException() {  
    }  
    @Override
import java.util.List;
 */
 * You may obtain a copy of the License at  
 */  
        return Arrays.asList("cookie", "cookie2");  
import java.util.Arrays;  
    @Override  
 *
 * license agreements. See the NOTICE file distributed with
    }
 *
 * not use this file except in compliance with the License.
        throw new UnsupportedOperationException("Do not support removing header on test request.");
        return version.get();
import org.opensearch.core.common.bytes.BytesArray;
    @Override  
 */  
    }  
        this(() -> version, method, uri);
    public String uri() {
 * software distributed under the License is distributed on an
    }
    @Override
    @Override
        this.method = method;  
    private final String uri;
import org.opensearch.core.rest.RestStatus;  
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
    public HttpVersion protocolVersion() {
    TestHttpRequest(HttpVersion version, RestRequest.Method method, String uri) {
    }
import java.util.function.Supplier;
    }  
 * under the License.  
    }
    @Override  
        return method;
        return this;
 * GitHub history for details.
    public RestRequest.Method method() {  
    TestHttpRequest(Supplier<HttpVersion> versionSupplier, RestRequest.Method method, String uri) {
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
/*  
import org.opensearch.core.common.bytes.BytesReference;
 * Modifications Copyright OpenSearch Contributors. See
        this.uri = uri;
    public Map<String, List<String>> getHeaders() {  
 * SPDX-License-Identifier: Apache-2.0
}  
    }
    private final HashMap<String, List<String>> headers = new HashMap<>();
    public BytesReference content() {
/*  
    @Override  
        return uri;  
 * ownership. Elasticsearch licenses this file to you under  
        return BytesArray.EMPTY;
import java.util.Map;  
 *  
import org.opensearch.rest.RestRequest;
import java.util.HashMap;
    public HttpRequest releaseAndCopy() {
    public void release() {}
    @Override
        this.version = versionSupplier;
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.http;
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
        return null;
        return headers;
    public HttpResponse createResponse(RestStatus status, BytesReference content) {
    @Override
        return new TestHttpResponse(status, content);  
    public List<String> strictCookies() {
/*
class TestHttpRequest implements HttpRequest {  
 * KIND, either express or implied.  See the License for the
    }
    public HttpRequest removeHeader(String header) {  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
    }
    }
 * specific language governing permissions and limitations
    private final RestRequest.Method method;  
