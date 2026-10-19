}  
            return content;
        @Override
            this.method = method;
        }
        }
 * not use this file except in compliance with the License.
    public FakeRestRequest(Map<String, String> params) {
        public void sendResponse(HttpResponse response, ActionListener<Void> listener) {
 *
        private final InetSocketAddress remoteAddress;  
 * this file be licensed under the Apache-2.0 license or a
        public Builder withContent(BytesReference content, MediaType mediaType) {
import java.util.HashMap;
            this.xContentRegistry = xContentRegistry;
            return headers;  
            this.uri = uri;
            };
        }
 * license agreements. See the NOTICE file distributed with
        public Builder withParams(Map<String, String> params) {  
        public boolean isOpen() {  
            return this;  
 * ownership. Elasticsearch licenses this file to you under  
    public static String requestToString(RestRequest restRequest) {  
        public HttpResponse createResponse(RestStatus status, BytesReference content) {
        HttpRequest httpRequest,
 * GitHub history for details.
            this.headers = headers;  
        private Method method = Method.GET;  
            return Collections.emptyList();
        }
            NamedXContentRegistry.EMPTY,
        }
        NamedXContentRegistry xContentRegistry,  
        public Builder withInboundException(Exception exception) {
            if (mediaType != null) {
        @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.MediaType;
 * You may obtain a copy of the License at  
        @Override
            return this;
        @Override
        @Override
        Map<String, String> params,
        public FakeRestRequest build() {  
        public Exception getInboundException() {
        private FakeHttpChannel(InetSocketAddress remoteAddress) {
        private final NamedXContentRegistry xContentRegistry;
    private FakeRestRequest(
 * KIND, either express or implied.  See the License for the
            new FakeHttpChannel(null)
            this(method, uri, content, headers, null);
        );
            new HashMap<>(),  
        public Builder(NamedXContentRegistry xContentRegistry) {  
        private Map<String, String> params = new HashMap<>();  
        this(  
        }  
        private final Map<String, List<String>> headers;
 * compatible open source license.
import org.opensearch.http.HttpChannel;
            this.method = method;  
            return new HttpResponse() {
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            this.content = content;  
        }  
                public boolean containsHeader(String name) {
                @Override
        }  
        @Override  
        private Map<String, List<String>> headers = new HashMap<>();
            params,  
        public InetSocketAddress getLocalAddress() {  
            return HttpVersion.HTTP_1_1;
            return new FakeRestRequest(xContentRegistry, fakeHttpRequest, params, new FakeHttpChannel(address));
            return method;  
        return "method=" + restRequest.method() + ",path=" + restRequest.rawPath();
                }
    public FakeRestRequest() {
 * Licensed to Elasticsearch under one or more contributor  
        }  
        public InetSocketAddress getRemoteAddress() {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.http.HttpRequest;
        private final String uri;
import org.opensearch.core.common.bytes.BytesReference;  
    }
    }  
            return this;
 * software distributed under the License is distributed on an
        }
        }  
                }
            this.address = address;  
            return inboundException;  
                headers.put("Content-Type", Collections.singletonList(mediaType.mediaType()));
        }
            return this;
    public static class Builder {
    private static class FakeHttpRequest implements HttpRequest {
        }
/*
        }
        public Builder withMethod(Method method) {  
        @Override
 * The OpenSearch Contributors require contributions made to  
        HttpChannel httpChannel  
import org.opensearch.core.common.bytes.BytesArray;
        this(  
            this.content = content;
import org.opensearch.core.rest.RestStatus;
        public Builder withHeaders(Map<String, List<String>> headers) {
        @Override
import java.net.InetSocketAddress;  
            return remoteAddress;  
                    headers.put(name, value);
        public HttpRequest releaseAndCopy() {  
 */  
        );
        }
    }
        }
        @Override
        private FakeHttpRequest(Method method, String uri, BytesReference content, Map<String, List<String>> headers) {
    }
        }
            Exception inboundException
 *  
 * specific language governing permissions and limitations
 */  
        }  
    }  
 *
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.action.ActionListener;
    }
            this.inboundException = inboundException;
        @Override  
        public HttpRequest removeHeader(String header) {
import java.util.Collections;
        public List<String> strictCookies() {
        public Method method() {
        }  
        @Override
        @Override  
        public Map<String, List<String>> getHeaders() {
        public void release() {}  
                public void addHeader(String name, String value) {  
            Method method,  
        }
            return this;
        public Builder withRemoteAddress(InetSocketAddress address) {
            headers.remove(header);  
            this.params = params;
        @Override
        }
/*  
        ) {
package org.opensearch.test.rest;
            BytesReference content,
        private FakeHttpRequest(
public class FakeRestRequest extends RestRequest {  
        private Exception inboundException;
 * under the License.  
import java.util.List;  
        public String uri() {
        }
        }
        private String path = "/";
    ) {
            return this;
            return null;
    private static class FakeHttpChannel implements HttpChannel {
        @Override
                @Override
            return this;  
        public Builder withPath(String path) {
        private BytesReference content = BytesArray.EMPTY;
        private InetSocketAddress address = null;
            this.headers = headers;
            return uri;
            NamedXContentRegistry.EMPTY,
            return this;  
            return this;
import org.opensearch.rest.RestRequest;
                    return headers.containsKey(name);  
            }  
            new FakeHttpChannel(null)
        }
        }
            this.path = path;
            Map<String, List<String>> headers,  
        }
            Map<String, String> headers = new HashMap<>();  
            this.inboundException = exception;
            FakeHttpRequest fakeHttpRequest = new FakeHttpRequest(method, path, content, headers, inboundException);
 * Unless required by applicable law or agreed to in writing,
        public void close() {
import org.opensearch.http.HttpResponse;  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    }  
        @Override
import java.util.Map;
        @Override  
        private final Method method;
        @Override
            new FakeHttpRequest(Method.GET, "", BytesArray.EMPTY, new HashMap<>()),
        public BytesReference content() {  
        }  
            this.remoteAddress = remoteAddress;  
        private final BytesReference content;  
        private final Exception inboundException;
        }  
        super(xContentRegistry, params, httpRequest.uri(), httpRequest.getHeaders(), httpRequest, httpChannel);
            String uri,
            new FakeHttpRequest(Method.GET, "", BytesArray.EMPTY, new HashMap<>()),
        public HttpVersion protocolVersion() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public void addCloseListener(ActionListener<Void> listener) {
 */
            return true;
