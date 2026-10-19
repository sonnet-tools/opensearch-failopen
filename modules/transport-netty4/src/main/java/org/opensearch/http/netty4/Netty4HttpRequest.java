            release();
            return HttpRequest.HttpVersion.HTTP_2_0;
            request.uri(),
/*
            return this;
        @Override
     */
            new AtomicBoolean(false),
     * <p>
                new DefaultFullHttpRequest(
        public List<String> remove(Object key) {
                headers,
        }
import io.netty.handler.codec.http.FullHttpRequest;
    }
 * ownership. Elasticsearch licenses this file to you under
        if (httpMethod == HttpMethod.CONNECT) {
        BytesReference content,
        } else {
        try {
 * this work for additional information regarding copyright
        }
            return key instanceof String keyString ? httpHeaders.getAll(keyString) : null;
import io.netty.handler.codec.http.cookie.ServerCookieDecoder;
            throw new UnsupportedOperationException("modifications are not supported");
    }
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
import java.util.AbstractMap;
        }
    }
import io.netty.handler.codec.http.cookie.Cookie;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Set;
        if (httpMethod == HttpMethod.DELETE) return RestRequest.Method.DELETE;
    Netty4HttpRequest(FullHttpRequest request, Exception inboundException, HttpResponseHeadersFactory responseHeadersFactory) {
            Netty4Utils.toBytesReference(request.content()),
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
        }
 */
            return HttpRequest.HttpVersion.HTTP_1_0;
        this.content = content;
        return Collections.emptyList();
        } else if (request.protocolVersion().equals("HTTP/3.0")) {
        );
        @Override
        assert released.get() == false;
    @Override
        @Override
        public Set<String> keySet() {
     * view of the underlying values.
            responseHeadersFactory
import io.netty.handler.codec.http.HttpHeaderNames;
    }
        }
        }
    @Override
    public void release() {
        FullHttpRequest request,
    public Netty4HttpResponse createResponse(RestStatus status, BytesReference content) {
 *
    }
import java.util.stream.Collectors;
        }
    public String uri() {
 * compatible open source license.
 * not use this file except in compliance with the License.
        if (httpMethod == HttpMethod.GET) return RestRequest.Method.GET;
        assert released.get() == false;
            new HttpHeadersMap(requestWithoutHeader.headers()),
        return new Netty4HttpRequest(
            return httpHeaders.isEmpty();
    @Override
        @Override
            return httpHeaders.names().stream().map(k -> Collections.unmodifiableList(httpHeaders.getAll(k))).collect(Collectors.toList());
        } else if (request.protocolVersion().equals("HTTP/2.0")) {
            );
import io.netty.handler.codec.http.cookie.ServerCookieEncoder;
                    request.trailingHeaders()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            return HttpRequest.HttpVersion.HTTP_3_0;
public class Netty4HttpRequest implements HttpRequest {
    @Override
import io.netty.handler.codec.http.HttpHeaders;
        return request.uri();
        trailingHeaders.add(request.trailingHeaders());
        }
        public boolean containsKey(Object key) {
        @Override
    private final Exception inboundException;
        if (httpMethod == HttpMethod.TRACE) {
                    request.protocolVersion(),
        }
    private final BytesReference content;
        this.pooled = pooled;
        );
import java.util.Collection;
    @Override
    private final HttpHeadersMap headers;
    private final AtomicBoolean released;
        responseHeadersFactory.headers(protocolVersion()).forEach(response::addHeader);
     * {@link #values()} and {@link #entrySet()} methods will perform a copy of the values in the HttpHeaders rather than returning a
    }
import io.netty.handler.codec.http.HttpMethod;
            }
}
    }
import io.netty.handler.codec.http.DefaultFullHttpRequest;
            return RestRequest.Method.OPTIONS;
     * A wrapper of {@link HttpHeaders} that implements a map to prevent copying unnecessarily. This class does not support modifications
        final Netty4HttpResponse response = new Netty4HttpResponse(request.headers(), request.protocolVersion(), status, content);
        if (httpMethod == HttpMethod.PUT) return RestRequest.Method.PUT;
            return key instanceof String string && httpHeaders.contains(string);
        this.released = released;
        Exception inboundException,
        private final HttpHeaders httpHeaders;
        }
        if (pooled == false) {
        HttpHeadersMap headers,
            true,
        HttpResponseHeadersFactory responseHeadersFactory
        this.inboundException = inboundException;
 * SPDX-License-Identifier: Apache-2.0
        }
        } finally {
            final ByteBuf copiedContent = Unpooled.copiedBuffer(request.content());
        if (httpMethod == HttpMethod.HEAD) {
        @Override
            request.content(),
        @Override
        public void clear() {
            requestWithoutHeader,
    }
    public HttpRequest releaseAndCopy() {
            throw new IllegalArgumentException("Unexpected http protocol version: " + request.protocolVersion());
        @Override
    @Override
        if (cookieString != null) {
    @Override
    @Override
        if (pooled && released.compareAndSet(false, true)) {
 */
            content,
            new AtomicBoolean(false),
 * The OpenSearch Contributors require contributions made to
            released,
        boolean pooled,
        if (request.protocolVersion().equals(io.netty.handler.codec.http.HttpVersion.HTTP_1_0)) {
    }
        );
        headersWithoutContentTypeHeader.remove(header);
    }
                false,
package org.opensearch.http.netty4;
 * Unless required by applicable law or agreed to in writing,
    public Exception getInboundException() {
 * GitHub history for details.
                ),
            true,
    @Override
    public HttpVersion protocolVersion() {
            pooled,
            Netty4Utils.toBytesReference(request.content()),
        HttpHeaders trailingHeaders = new DefaultHttpHeaders();
import org.opensearch.rest.RestRequest;
        HttpHeaders headersWithoutContentTypeHeader = new DefaultHttpHeaders();
 * Modifications Copyright OpenSearch Contributors. See
    public FullHttpRequest nettyRequest() {
    private final FullHttpRequest request;
        public boolean isEmpty() {
import io.netty.handler.codec.http.DefaultHttpHeaders;
        public int size() {
        HttpMethod httpMethod = request.method();
        if (httpMethod == HttpMethod.PATCH) {
        this.request = request;
                responseHeadersFactory
 * Licensed to Elasticsearch under one or more contributor
        boolean pooled,
        return inboundException;
                .stream()
    }
    }
                .map(k -> new AbstractMap.SimpleImmutableEntry<>(k, httpHeaders.getAll(k)))
        return headers;
    public List<String> strictCookies() {
 *
 * specific language governing permissions and limitations
        String cookieString = request.headers().get(HttpHeaderNames.COOKIE);
        public void putAll(Map<? extends String, ? extends List<String>> m) {
import org.opensearch.transport.netty4.Netty4Utils;
/*
        @Override
            request,
import io.netty.buffer.Unpooled;
            new HttpHeadersMap(request.headers()),
        }
        FullHttpRequest request,
        public List<String> get(Object key) {
    private static class HttpHeadersMap implements Map<String, List<String>> {
        AtomicBoolean released,
            this.httpHeaders = httpHeaders;
        }
            request.release();
        return content;
            trailingHeaders
        } else if (request.protocolVersion().equals(io.netty.handler.codec.http.HttpVersion.HTTP_1_1)) {
    public HttpRequest removeHeader(String header) {
        private HttpHeadersMap(HttpHeaders httpHeaders) {
        );
    private final boolean pooled;
            new HttpHeadersMap(request.headers()),
    public final Map<String, List<String>> getHeaders() {
            throw new UnsupportedOperationException("modifications are not supported");
import io.netty.buffer.ByteBuf;
        }
        return response;
        }
            responseHeadersFactory
        this(request, headers, released, pooled, content, null, responseHeadersFactory);
            inboundException,
        public List<String> put(String key, List<String> value) {
import org.opensearch.core.rest.RestStatus;
            if (!cookies.isEmpty()) {
        headersWithoutContentTypeHeader.add(request.headers());
    Netty4HttpRequest(FullHttpRequest request, HttpResponseHeadersFactory responseHeadersFactory) {
        if (httpMethod == HttpMethod.POST) return RestRequest.Method.POST;
            return RestRequest.Method.HEAD;
            throw new UnsupportedOperationException("modifications are not supported");
import java.util.Collections;
                    copiedContent,
                new AtomicBoolean(false),
            return new Netty4HttpRequest(
        }
            return httpHeaders.names();
        }
        trailingHeaders.remove(header);
    ) {
        FullHttpRequest requestWithoutHeader = new DefaultFullHttpRequest(
            return RestRequest.Method.CONNECT;
/*
            return RestRequest.Method.TRACE;
    private Netty4HttpRequest(
                Netty4Utils.toBytesReference(copiedContent),
        @Override
     * and due to the underlying implementation, it performs case insensitive lookups of key to values.
    }
 *
                    request.headers(),
    @Override
        this.headers = headers;
import org.opensearch.core.common.bytes.BytesReference;
            return RestRequest.Method.PATCH;
    }
    @Override
        this(
    /**
        BytesReference content,
        this.responseHeadersFactory = responseHeadersFactory;
import org.opensearch.http.HttpRequest;
 * license agreements. See the NOTICE file distributed with
        this(
        throw new IllegalArgumentException("Unexpected http method: " + httpMethod);
        HttpHeadersMap headers,
        }
        }
import java.util.concurrent.atomic.AtomicBoolean;
            return HttpRequest.HttpVersion.HTTP_1_1;
    ) {
            responseHeadersFactory
            return httpHeaders.names()
        return request;
                    request.uri(),
    public RestRequest.Method method() {
import java.util.Map;
        @Override
 * under the License.
            request,
        }
            request.protocolVersion(),
                return ServerCookieEncoder.STRICT.encode(cookies);
        public Collection<List<String>> values() {
        }
    }
        @Override
    private final HttpResponseHeadersFactory responseHeadersFactory;
        if (httpMethod == HttpMethod.OPTIONS) {
    public BytesReference content() {
    }
                .collect(Collectors.toSet());
            request.method(),
        HttpResponseHeadersFactory responseHeadersFactory
            return value instanceof List<?> && httpHeaders.names().stream().map(httpHeaders::getAll).anyMatch(value::equals);
                    request.method(),
    }
            return httpHeaders.size();
        public Set<Entry<String, List<String>>> entrySet() {
 * You may obtain a copy of the License at
            headersWithoutContentTypeHeader,
     * It is important to note that this implementation does have some downsides in that each invocation of the
        public boolean containsValue(Object value) {
        AtomicBoolean released,
 */
            throw new UnsupportedOperationException("modifications are not supported");
    private Netty4HttpRequest(
 * software distributed under the License is distributed on an
        }
            Set<Cookie> cookies = ServerCookieDecoder.STRICT.decode(cookieString);
