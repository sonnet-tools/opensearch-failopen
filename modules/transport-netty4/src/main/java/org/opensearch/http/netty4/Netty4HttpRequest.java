                .collect(Collectors.toSet());
        if (httpMethod == HttpMethod.GET) return RestRequest.Method.GET;  
            pooled,  
            throw new UnsupportedOperationException("modifications are not supported");
        this(request, headers, released, pooled, content, null, responseHeadersFactory);  
            return HttpRequest.HttpVersion.HTTP_1_1;  
            responseHeadersFactory
     * view of the underlying values.
     * {@link #values()} and {@link #entrySet()} methods will perform a copy of the values in the HttpHeaders rather than returning a  
            this.httpHeaders = httpHeaders;
        HttpMethod httpMethod = request.method();
        }
            new HttpHeadersMap(requestWithoutHeader.headers()),
package org.opensearch.http.netty4;
        this.content = content;
 * GitHub history for details.
            }
import io.netty.handler.codec.http.DefaultHttpHeaders;
            released,
        return Collections.emptyList();
 * specific language governing permissions and limitations
            requestWithoutHeader,  
        public Set<Entry<String, List<String>>> entrySet() {
            return RestRequest.Method.CONNECT;
            request.content(),
        @Override  
    public final Map<String, List<String>> getHeaders() {  
                return ServerCookieEncoder.STRICT.encode(cookies);
        this.inboundException = inboundException;
        private final HttpHeaders httpHeaders;
        throw new IllegalArgumentException("Unexpected http method: " + httpMethod);
        }  
    /**
        headersWithoutContentTypeHeader.add(request.headers());
        HttpHeadersMap headers,  
    @Override
        if (httpMethod == HttpMethod.TRACE) {
        if (pooled && released.compareAndSet(false, true)) {
        HttpHeaders headersWithoutContentTypeHeader = new DefaultHttpHeaders();  
        public boolean containsValue(Object value) {  
            Set<Cookie> cookies = ServerCookieDecoder.STRICT.decode(cookieString);
        );
        try {
        HttpResponseHeadersFactory responseHeadersFactory
        trailingHeaders.remove(header);
            true,
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        }  
        public void putAll(Map<? extends String, ? extends List<String>> m) {
        if (httpMethod == HttpMethod.PUT) return RestRequest.Method.PUT;
        }
            return httpHeaders.names();
        return request.uri();  
        }
            return this;
        HttpResponseHeadersFactory responseHeadersFactory
 * software distributed under the License is distributed on an
        if (pooled == false) {
        boolean pooled,
        }
                false,
        AtomicBoolean released,
            request.method(),
    private Netty4HttpRequest(  
    public RestRequest.Method method() {
                responseHeadersFactory
            new HttpHeadersMap(request.headers()),
        HttpHeadersMap headers,
        }
import java.util.List;
        @Override  
    private static class HttpHeadersMap implements Map<String, List<String>> {  
                    request.protocolVersion(),
    public HttpRequest removeHeader(String header) {
 * ownership. Elasticsearch licenses this file to you under  
        }
     * A wrapper of {@link HttpHeaders} that implements a map to prevent copying unnecessarily. This class does not support modifications
        } else if (request.protocolVersion().equals("HTTP/2.0")) {
        String cookieString = request.headers().get(HttpHeaderNames.COOKIE);  
    }
    ) {
import io.netty.handler.codec.http.FullHttpRequest;
            new AtomicBoolean(false),  
        public boolean isEmpty() {
        }  
        public List<String> remove(Object key) {  
 *
            return RestRequest.Method.OPTIONS;
            content,
 */  
        Exception inboundException,  
        } else if (request.protocolVersion().equals("HTTP/3.0")) {  
        @Override
 * Modifications Copyright OpenSearch Contributors. See
                new DefaultFullHttpRequest(
        this.pooled = pooled;  
        this(
            request,
        public List<String> get(Object key) {
import org.opensearch.transport.netty4.Netty4Utils;
        this(  
        boolean pooled,
            return key instanceof String keyString ? httpHeaders.getAll(keyString) : null;  
    }
import io.netty.handler.codec.http.cookie.ServerCookieEncoder;
                headers,  
        }
    ) {
import java.util.stream.Collectors;
        @Override
        }
        }
/*
import io.netty.handler.codec.http.cookie.Cookie;  
            request.protocolVersion(),
    public String uri() {
        }  
        }
        this.request = request;  
                    request.uri(),
                    copiedContent,
    }
import java.util.Map;
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        }  
    }
        );  
     * and due to the underlying implementation, it performs case insensitive lookups of key to values.  
            Netty4Utils.toBytesReference(request.content()),
            final ByteBuf copiedContent = Unpooled.copiedBuffer(request.content());
            return new Netty4HttpRequest(  
        }
/*  
            request.uri(),  
            responseHeadersFactory  
        return content;  
            throw new UnsupportedOperationException("modifications are not supported");
        headersWithoutContentTypeHeader.remove(header);
            trailingHeaders  
            Netty4Utils.toBytesReference(request.content()),
            return RestRequest.Method.PATCH;
            release();
import java.util.Collection;
        this.headers = headers;
}
        BytesReference content,
        this.released = released;
        HttpHeaders trailingHeaders = new DefaultHttpHeaders();  
            request,  
        }
    public HttpRequest releaseAndCopy() {
        }  
import org.opensearch.core.common.bytes.BytesReference;
            return httpHeaders.names()
        if (httpMethod == HttpMethod.CONNECT) {  
        return inboundException;  
    private final BytesReference content;
            return httpHeaders.isEmpty();  
        @Override
    private final FullHttpRequest request;  
 * Unless required by applicable law or agreed to in writing,
import io.netty.handler.codec.http.HttpMethod;
        if (httpMethod == HttpMethod.DELETE) return RestRequest.Method.DELETE;  
            return RestRequest.Method.TRACE;  
 * SPDX-License-Identifier: Apache-2.0
                .stream()  
    public List<String> strictCookies() {
    }
        return response;
            throw new IllegalArgumentException("Unexpected http protocol version: " + request.protocolVersion());  
        }
    @Override
            headersWithoutContentTypeHeader,
            return key instanceof String string && httpHeaders.contains(string);
            return httpHeaders.size();
    @Override
    private Netty4HttpRequest(
     * It is important to note that this implementation does have some downsides in that each invocation of the
    private final boolean pooled;
        AtomicBoolean released,  
                    request.headers(),  
import io.netty.handler.codec.http.HttpHeaderNames;  
            new AtomicBoolean(false),
            );
        FullHttpRequest requestWithoutHeader = new DefaultFullHttpRequest(  
    }
        if (cookieString != null) {
     * <p>
    }
    Netty4HttpRequest(FullHttpRequest request, Exception inboundException, HttpResponseHeadersFactory responseHeadersFactory) {
        } else {
        }
        return new Netty4HttpRequest(
    private final Exception inboundException;
        );
 * this file be licensed under the Apache-2.0 license or a
    public HttpVersion protocolVersion() {
        if (httpMethod == HttpMethod.POST) return RestRequest.Method.POST;
import io.netty.buffer.Unpooled;
    public FullHttpRequest nettyRequest() {  
        this.responseHeadersFactory = responseHeadersFactory;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        private HttpHeadersMap(HttpHeaders httpHeaders) {
            return value instanceof List<?> && httpHeaders.names().stream().map(httpHeaders::getAll).anyMatch(value::equals);
    }
    }
    }
import java.util.Collections;  
    public Exception getInboundException() {
 * compatible open source license.
 * You may obtain a copy of the License at  
        @Override
 *  
 * Licensed to Elasticsearch under one or more contributor  
        public Collection<List<String>> values() {
import org.opensearch.core.rest.RestStatus;
import java.util.AbstractMap;
        BytesReference content,  
    public BytesReference content() {
        @Override
 * The OpenSearch Contributors require contributions made to  
        @Override
    @Override  
 * KIND, either express or implied.  See the License for the
    @Override
import org.opensearch.http.HttpRequest;  
import io.netty.handler.codec.http.HttpHeaders;
 * the Apache License, Version 2.0 (the "License"); you may
        responseHeadersFactory.headers(protocolVersion()).forEach(response::addHeader);  
            throw new UnsupportedOperationException("modifications are not supported");
        return headers;
import io.netty.buffer.ByteBuf;
        if (httpMethod == HttpMethod.OPTIONS) {  
            request.release();  
import io.netty.handler.codec.http.cookie.ServerCookieDecoder;
            responseHeadersFactory  
import io.netty.handler.codec.http.DefaultFullHttpRequest;  
        FullHttpRequest request,
    @Override
        );
            true,  
            return HttpRequest.HttpVersion.HTTP_3_0;
    }  
    }
        return request;
    private final AtomicBoolean released;  
 * under the License.  
            return HttpRequest.HttpVersion.HTTP_1_0;
        @Override  
    }
    Netty4HttpRequest(FullHttpRequest request, HttpResponseHeadersFactory responseHeadersFactory) {
        public boolean containsKey(Object key) {
                ),
    }
            throw new UnsupportedOperationException("modifications are not supported");  
            inboundException,
    @Override
    }
                new AtomicBoolean(false),
 *
            new HttpHeadersMap(request.headers()),
        @Override
        public Set<String> keySet() {  
        public int size() {  
        public void clear() {
        trailingHeaders.add(request.trailingHeaders());
                    request.trailingHeaders()
        }  
    @Override  
        if (httpMethod == HttpMethod.PATCH) {
        }  
        @Override  
import org.opensearch.rest.RestRequest;
 * not use this file except in compliance with the License.
    private final HttpHeadersMap headers;
    private final HttpResponseHeadersFactory responseHeadersFactory;  
        @Override
            if (!cookies.isEmpty()) {  
    @Override
        if (httpMethod == HttpMethod.HEAD) {
import java.util.concurrent.atomic.AtomicBoolean;
        if (request.protocolVersion().equals(io.netty.handler.codec.http.HttpVersion.HTTP_1_0)) {  
                    request.method(),  
        } finally {  
            return httpHeaders.names().stream().map(k -> Collections.unmodifiableList(httpHeaders.getAll(k))).collect(Collectors.toList());  
        public List<String> put(String key, List<String> value) {
public class Netty4HttpRequest implements HttpRequest {
        final Netty4HttpResponse response = new Netty4HttpResponse(request.headers(), request.protocolVersion(), status, content);
     */
/*  
    }
        } else if (request.protocolVersion().equals(io.netty.handler.codec.http.HttpVersion.HTTP_1_1)) {
        }
import java.util.Set;  
        assert released.get() == false;
                .map(k -> new AbstractMap.SimpleImmutableEntry<>(k, httpHeaders.getAll(k)))
    public Netty4HttpResponse createResponse(RestStatus status, BytesReference content) {
 */
                Netty4Utils.toBytesReference(copiedContent),  
    public void release() {
    @Override  
            return RestRequest.Method.HEAD;  
            return HttpRequest.HttpVersion.HTTP_2_0;
    }
        FullHttpRequest request,
        assert released.get() == false;  
    @Override  
