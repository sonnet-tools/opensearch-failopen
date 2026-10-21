        public List<String> get(Object key) {
            io.netty.handler.codec.http.HttpVersion.valueOf(protocol),
        try {
    ReactorNetty4HttpRequest(
        }
        headersWithoutContentTypeHeader.remove(header);
                null,
                .map(k -> new AbstractMap.SimpleImmutableEntry<>(k, httpHeaders.getAll(k)))
        return Netty4Utils.toBytesReference(content);
import org.opensearch.core.common.bytes.BytesReference;
        }
        if (protocol.equals(io.netty.handler.codec.http.HttpVersion.HTTP_1_0.toString())) {
    /**
    private final HttpMethod method;
        }
    }
        @Override
        HttpServerRequest request,
            return HttpRequest.HttpVersion.HTTP_3_0;
            false,
        HttpHeadersMap headers,
    public HttpRequest releaseAndCopy() {
    public final Map<String, List<String>> getHeaders() {
            final ByteBuf copiedContent = Unpooled.copiedBuffer(content);
        private HttpHeadersMap(HttpHeaders httpHeaders) {
}
        }
        }
        public void putAll(Map<? extends String, ? extends List<String>> m) {
        this(
                responseHeadersFactory
    @Override
        this(request, new HttpHeadersMap(request.requestHeaders()), new AtomicBoolean(false), true, content, responseHeadersFactory);
        public Collection<List<String>> values() {
        ByteBuf content,
        String protocol,
        }
        AtomicBoolean released,
            return HttpRequest.HttpVersion.HTTP_1_0;
        HttpHeaders headersWithoutContentTypeHeader = new DefaultHttpHeaders();
            method,
        if (pooled && released.compareAndSet(false, true)) {
        @Override
                headers,
        }
            throw new UnsupportedOperationException("modifications are not supported");
        Exception inboundException,
    }
        );
            content.release();
        HttpServerRequest request,
            Unpooled.EMPTY_BUFFER,
        this.content = content;
        return new ReactorNetty4HttpRequest(
import io.netty.buffer.ByteBuf;
            return HttpRequest.HttpVersion.HTTP_2_0;
        } else {
        public int size() {
import java.util.Collection;
        headersWithoutContentTypeHeader.add(headers.httpHeaders);
import org.opensearch.core.rest.RestStatus;
            uri,
                .stream()
        @Override
        public List<String> put(String key, List<String> value) {
import java.util.Collections;
            new HttpHeadersMap(request.requestHeaders()),
    }
     * view of the underlying values.
        @Override
            return this;
                copiedContent,
            throw new UnsupportedOperationException("modifications are not supported");
            protocol,
            return value instanceof List && httpHeaders.names().stream().map(httpHeaders::getAll).anyMatch(value::equals);
        private final HttpHeaders httpHeaders;
    public Exception getInboundException() {
            throw new IllegalArgumentException("Unexpected http protocol version: " + protocol);
    }
    private ReactorNetty4HttpRequest(
    public HttpRequest removeHeader(String header) {
            return key instanceof String s ? httpHeaders.getAll(s) : null;
            pooled,
import java.util.Map;
        );
    @Override
            content
            new HttpHeadersMap(headersWithoutContentTypeHeader),
        @Override
import java.util.List;
    private final HttpHeadersMap headers;
    }
        if (cookieString != null) {
            Set<Cookie> cookies = ServerCookieDecoder.STRICT.decode(cookieString);
            released,
 *
        return response;
        final ReactorNetty4HttpResponse response = new ReactorNetty4HttpResponse(
    private final String uri;
            release();
        }
import io.netty.buffer.Unpooled;
        public boolean containsKey(Object key) {
            );
        }
    @Override
 * this file be licensed under the Apache-2.0 license or a
        HttpResponseHeadersFactory responseHeadersFactory
            return new ReactorNetty4HttpRequest(
    private final HttpResponseHeadersFactory responseHeadersFactory;
    @Override
            null,
        @Override
     * A wrapper of {@link HttpHeaders} that implements a map to prevent copying unnecessarily. This class does not support modifications
import io.netty.handler.codec.http.cookie.ServerCookieEncoder;
            true,
            return httpHeaders.isEmpty();
import reactor.netty.http.server.HttpServerRequest;
            responseHeadersFactory
        public boolean containsValue(Object value) {
        return headers;
    @Override
class ReactorNetty4HttpRequest implements HttpRequest {
package org.opensearch.http.reactor.netty4;
import org.opensearch.rest.RestRequest;
    }
        public Set<String> keySet() {
            status,
        } else if (protocol.equals(io.netty.handler.codec.http.HttpVersion.HTTP_1_1.toString())) {
        } else if (protocol.equals("HTTP/2.0")) {
        }
        public boolean isEmpty() {
        HttpResponseHeadersFactory responseHeadersFactory
            throw new UnsupportedOperationException("modifications are not supported");
import org.opensearch.transport.netty4.Netty4Utils;
    }
        public List<String> remove(Object key) {
        if (pooled == false) {
    private final ByteBuf content;
    ) {
        HttpResponseHeadersFactory responseHeadersFactory
    }
/*
    @Override
    private final String protocol;
import org.opensearch.http.HttpRequest;
            if (!cookies.isEmpty()) {
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.DefaultHttpHeaders;
        String uri,
            content,
     * and due to the underlying implementation, it performs case insensitive lookups of key to values.
     */
            request.method(),
        } finally {
    public ReactorNetty4HttpResponse createResponse(RestStatus status, BytesReference content) {
        }
                .collect(Collectors.toSet());
            content,
            return httpHeaders.names();
    private final boolean pooled;
            return HttpRequest.HttpVersion.HTTP_1_1;
            headers.httpHeaders,
            new AtomicBoolean(false),
        String cookieString = headers.httpHeaders.get(HttpHeaderNames.COOKIE);
    public BytesReference content() {
        boolean pooled,
            responseHeadersFactory
                method,
     *
        assert released.get() == false;
            throw new UnsupportedOperationException("modifications are not supported");
        Exception inboundException,
        this.headers = headers;
            request.uri(),
import java.util.stream.Collectors;
            this.httpHeaders = httpHeaders;
                protocol,
    private static class HttpHeadersMap implements Map<String, List<String>> {
            inboundException,
                new AtomicBoolean(false),
 * SPDX-License-Identifier: Apache-2.0
import java.util.AbstractMap;
 */
        this.inboundException = inboundException;
    }
        boolean pooled,
        @Override
        return uri;
    ReactorNetty4HttpRequest(HttpServerRequest request, ByteBuf content, HttpResponseHeadersFactory responseHeadersFactory) {
import java.util.concurrent.atomic.AtomicBoolean;
    @Override
        );
import io.netty.handler.codec.http.HttpMethod;
        responseHeadersFactory.headers(protocolVersion()).forEach(response::addHeader);
            }
    public List<String> strictCookies() {
    }
            new AtomicBoolean(false),
    }
        this.released = released;
            return httpHeaders.size();
            responseHeadersFactory
    private final AtomicBoolean released;
        public Set<Entry<String, List<String>>> entrySet() {
     * {@link #values()} and {@link #entrySet()} methods will perform a copy of the values in the HttpHeaders rather than returning a
    }
    private final Exception inboundException;
    ) {
            new HttpHeadersMap(request.requestHeaders()),
    }
        AtomicBoolean released,
        this(request.protocol(), request.method(), request.uri(), headers, released, pooled, content, null, responseHeadersFactory);
        public void clear() {
                uri,
        return HttpConversionUtil.convertMethod(method);
    ReactorNetty4HttpRequest(HttpServerRequest request, HttpResponseHeadersFactory responseHeadersFactory) {
        ByteBuf content,
        HttpHeadersMap headers,
    public String uri() {
    private ReactorNetty4HttpRequest(
        } else if (protocol.equals("HTTP/3.0")) {
        }
        @Override
        @Override
        this.method = method;
        @Override
            return httpHeaders.names().stream().map(k -> Collections.unmodifiableList(httpHeaders.getAll(k))).collect(Collectors.toList());
        this.uri = uri;
            request,
        this(
        );
    @Override
        ByteBuf content,
    @Override
            return key instanceof String s && httpHeaders.contains(s);
    }
    }
        this.pooled = pooled;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
        }
     * It is important to note that this implementation does have some downsides in that each invocation of the
            request.protocol(),
        return inboundException;
        }
        HttpMethod method,
    }
    public void release() {
import io.netty.handler.codec.http.HttpHeaderNames;
    ) {
        @Override
    @Override
        assert released.get() == false;
    }
    public RestRequest.Method method() {
        this.responseHeadersFactory = responseHeadersFactory;
    public HttpVersion protocolVersion() {
import io.netty.handler.codec.http.cookie.ServerCookieDecoder;
        @Override
        }
        }
                return ServerCookieEncoder.STRICT.encode(cookies);
        this.protocol = protocol;
    @Override
        }
import java.util.Set;
            return httpHeaders.names()
import io.netty.handler.codec.http.cookie.Cookie;
        return Collections.emptyList();
                false,
        }
