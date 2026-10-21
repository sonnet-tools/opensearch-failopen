public class FakeRestRequest extends RestRequest {
 * The OpenSearch Contributors require contributions made to
            this.method = method;
            return method;
 * Licensed to Elasticsearch under one or more contributor
        }
            this.address = address;
                }
            Map<String, List<String>> headers,
        }
                public void addHeader(String name, String value) {
            this.content = content;
            this.params = params;
                headers.put("Content-Type", Collections.singletonList(mediaType.mediaType()));
        public InetSocketAddress getRemoteAddress() {
    public static class Builder {
        @Override
        }
import org.opensearch.http.HttpRequest;
        public Builder withInboundException(Exception exception) {
            return uri;
        private final String uri;
        public String uri() {
import org.opensearch.core.action.ActionListener;
            return this;
import org.opensearch.core.rest.RestStatus;
            new HashMap<>(),
 *
        public HttpRequest removeHeader(String header) {
        public HttpResponse createResponse(RestStatus status, BytesReference content) {
        }
        }
            this.headers = headers;
            return this;
/*
 * specific language governing permissions and limitations
        @Override
            this.uri = uri;
        public List<String> strictCookies() {
    }
    }
        private final InetSocketAddress remoteAddress;
    }
            this.content = content;
        }
import org.opensearch.core.common.bytes.BytesArray;
            params,
            this.path = path;
 */
        }
        ) {
        }
        );
            new FakeHttpRequest(Method.GET, "", BytesArray.EMPTY, new HashMap<>()),
        private Map<String, String> params = new HashMap<>();
        @Override
            return this;
            this.remoteAddress = remoteAddress;
        public Builder(NamedXContentRegistry xContentRegistry) {
        @Override
        public void close() {
            return this;
 * not use this file except in compliance with the License.
        @Override
        return "method=" + restRequest.method() + ",path=" + restRequest.rawPath();
        }
        @Override
            new FakeHttpChannel(null)
        @Override
        }
        @Override
        private FakeHttpRequest(
    private FakeRestRequest(
        );
        }
 * software distributed under the License is distributed on an
        }
        private final BytesReference content;
            new FakeHttpRequest(Method.GET, "", BytesArray.EMPTY, new HashMap<>()),
        @Override
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
        private Map<String, List<String>> headers = new HashMap<>();
        private FakeHttpChannel(InetSocketAddress remoteAddress) {
            BytesReference content,
 * Modifications Copyright OpenSearch Contributors. See
        @Override
            return this;
        private Method method = Method.GET;
            return content;
            NamedXContentRegistry.EMPTY,
        }
        this(
        }
            };
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return headers;
}
 */
            FakeHttpRequest fakeHttpRequest = new FakeHttpRequest(method, path, content, headers, inboundException);
 *
                    return headers.containsKey(name);
import org.opensearch.core.common.bytes.BytesReference;
            if (mediaType != null) {
        private final Map<String, List<String>> headers;
    }
    public FakeRestRequest() {
import java.util.Map;
        private final Method method;
        }
    public static String requestToString(RestRequest restRequest) {
        @Override
        }
        HttpChannel httpChannel
package org.opensearch.test.rest;
        Map<String, String> params,
            return null;
        private FakeHttpRequest(Method method, String uri, BytesReference content, Map<String, List<String>> headers) {
            Map<String, String> headers = new HashMap<>();
            this.inboundException = inboundException;
        public Method method() {
            return this;
        public InetSocketAddress getLocalAddress() {
        public FakeRestRequest build() {
            return remoteAddress;
 * this file be licensed under the Apache-2.0 license or a
    public FakeRestRequest(Map<String, String> params) {
            return new FakeRestRequest(xContentRegistry, fakeHttpRequest, params, new FakeHttpChannel(address));
        this(
        public Exception getInboundException() {
 * You may obtain a copy of the License at
        }
        private Exception inboundException;
            this.headers = headers;
            return this;
        }
        NamedXContentRegistry xContentRegistry,
        private final Exception inboundException;
/*
            return Collections.emptyList();
                    headers.put(name, value);
 * under the License.
        }
        private String path = "/";
        }
        HttpRequest httpRequest,
    ) {
            return inboundException;
        }
        }
 *
 * ownership. Elasticsearch licenses this file to you under
 * this work for additional information regarding copyright
            new FakeHttpChannel(null)
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        public HttpVersion protocolVersion() {
        public boolean isOpen() {
import java.util.Collections;
        }
            Method method,
            Exception inboundException
 * KIND, either express or implied.  See the License for the
        private BytesReference content = BytesArray.EMPTY;
        @Override
import org.opensearch.rest.RestRequest;
        private InetSocketAddress address = null;
        }
        public Map<String, List<String>> getHeaders() {
        public Builder withMethod(Method method) {
                @Override
        public BytesReference content() {
        public HttpRequest releaseAndCopy() {
    private static class FakeHttpChannel implements HttpChannel {
            return true;
    }
            String uri,
        public Builder withParams(Map<String, String> params) {
        }
            this(method, uri, content, headers, null);
                @Override
 */
import java.util.HashMap;
            NamedXContentRegistry.EMPTY,
        public Builder withPath(String path) {
 * compatible open source license.
                }
/*
        @Override
import java.util.List;
        private final NamedXContentRegistry xContentRegistry;
        super(xContentRegistry, params, httpRequest.uri(), httpRequest.getHeaders(), httpRequest, httpChannel);
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.http.HttpResponse;
            return this;
        @Override
        @Override
 * GitHub history for details.
            }
            this.inboundException = exception;
            return HttpVersion.HTTP_1_1;
        public Builder withRemoteAddress(InetSocketAddress address) {
    private static class FakeHttpRequest implements HttpRequest {
    }
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
import java.net.InetSocketAddress;
            this.method = method;
import org.opensearch.core.xcontent.MediaType;
            this.xContentRegistry = xContentRegistry;
        public void addCloseListener(ActionListener<Void> listener) {
            return new HttpResponse() {
        }
        public void sendResponse(HttpResponse response, ActionListener<Void> listener) {
import org.opensearch.http.HttpChannel;
        public Builder withHeaders(Map<String, List<String>> headers) {
            headers.remove(header);
        }
        @Override
                public boolean containsHeader(String name) {
        public void release() {}
            return this;
        public Builder withContent(BytesReference content, MediaType mediaType) {
