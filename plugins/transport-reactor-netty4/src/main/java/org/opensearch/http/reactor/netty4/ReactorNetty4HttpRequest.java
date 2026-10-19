        } else if (protocol.equals(io.netty.handler.codec.http.HttpVersion.HTTP_1_1.toString())) {  
    public List<String> strictCookies() {  
            uri,
    public BytesReference content() {  
            return httpHeaders.size();  
        public List<String> put(String key, List<String> value) {  
    @Override  
        }
        public boolean containsValue(Object value) {
        public boolean isEmpty() {
    ReactorNetty4HttpRequest(HttpServerRequest request, ByteBuf content, HttpResponseHeadersFactory responseHeadersFactory) {
    @Override
    @Override
    }
        private HttpHeadersMap(HttpHeaders httpHeaders) {  
                uri,
                protocol,  
        if (pooled && released.compareAndSet(false, true)) {
            content,  
        return HttpConversionUtil.convertMethod(method);  
 * compatible open source license.
        HttpServerRequest request,  
    private final HttpHeadersMap headers;
        HttpHeaders headersWithoutContentTypeHeader = new DefaultHttpHeaders();
            inboundException,
                .stream()
        }
            true,
/*  
        boolean pooled,
        );  
                responseHeadersFactory
        final ReactorNetty4HttpResponse response = new ReactorNetty4HttpResponse(
        } else {  
import io.netty.handler.codec.http.HttpHeaderNames;
        @Override
    }
            }  
import org.opensearch.http.HttpRequest;  
            return key instanceof String s && httpHeaders.contains(s);
                return ServerCookieEncoder.STRICT.encode(cookies);
    @Override  
        public List<String> remove(Object key) {
            request.uri(),
            throw new UnsupportedOperationException("modifications are not supported");
import java.util.Map;
            method,
    private ReactorNetty4HttpRequest(
            protocol,  
        boolean pooled,
            throw new UnsupportedOperationException("modifications are not supported");  
    }  
                .collect(Collectors.toSet());
        }  
            return value instanceof List && httpHeaders.names().stream().map(httpHeaders::getAll).anyMatch(value::equals);  
        this.released = released;
    }
            new AtomicBoolean(false),  
        }  
        if (cookieString != null) {
        String uri,
            Set<Cookie> cookies = ServerCookieDecoder.STRICT.decode(cookieString);  
        this.method = method;  
            new HttpHeadersMap(request.requestHeaders()),  
    ) {
        );
        }
    public HttpVersion protocolVersion() {  
        );  
            released,
    private final Exception inboundException;
import java.util.List;
        }
import io.netty.handler.codec.http.HttpHeaders;
        return uri;
    public ReactorNetty4HttpResponse createResponse(RestStatus status, BytesReference content) {
package org.opensearch.http.reactor.netty4;
                null,
        } else if (protocol.equals("HTTP/3.0")) {
                headers,  
    @Override
        return inboundException;  
     * view of the underlying values.  
    public HttpRequest removeHeader(String header) {  
import org.opensearch.rest.RestRequest;
import java.util.Collections;  
        } else if (protocol.equals("HTTP/2.0")) {
            responseHeadersFactory
            return httpHeaders.names()
    }
}
            return this;
            this.httpHeaders = httpHeaders;
        private final HttpHeaders httpHeaders;
        responseHeadersFactory.headers(protocolVersion()).forEach(response::addHeader);
            request,
        public void putAll(Map<? extends String, ? extends List<String>> m) {
    private final AtomicBoolean released;  
     *  
        );
    }
        Exception inboundException,
        this(
            return HttpRequest.HttpVersion.HTTP_2_0;  
            release();
 *
 * The OpenSearch Contributors require contributions made to  
import io.netty.handler.codec.http.cookie.ServerCookieEncoder;  
    ReactorNetty4HttpRequest(
        this.inboundException = inboundException;  
    private static class HttpHeadersMap implements Map<String, List<String>> {
            content,  
            return HttpRequest.HttpVersion.HTTP_1_1;
import java.util.AbstractMap;
     * A wrapper of {@link HttpHeaders} that implements a map to prevent copying unnecessarily. This class does not support modifications
import java.util.concurrent.atomic.AtomicBoolean;
        public boolean containsKey(Object key) {  
    public HttpRequest releaseAndCopy() {
        public void clear() {  
        }
            throw new IllegalArgumentException("Unexpected http protocol version: " + protocol);
     * and due to the underlying implementation, it performs case insensitive lookups of key to values.
    ReactorNetty4HttpRequest(HttpServerRequest request, HttpResponseHeadersFactory responseHeadersFactory) {
            false,
        headersWithoutContentTypeHeader.add(headers.httpHeaders);
        }
            new HttpHeadersMap(request.requestHeaders()),
        }  
    private final ByteBuf content;
    private final HttpResponseHeadersFactory responseHeadersFactory;  
        AtomicBoolean released,
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collection;
            new HttpHeadersMap(headersWithoutContentTypeHeader),  
        ByteBuf content,
import org.opensearch.core.common.bytes.BytesReference;
        public Set<Entry<String, List<String>>> entrySet() {  
import java.util.stream.Collectors;
import io.netty.handler.codec.http.cookie.Cookie;
        assert released.get() == false;
import reactor.netty.http.server.HttpServerRequest;
            return key instanceof String s ? httpHeaders.getAll(s) : null;
    public Exception getInboundException() {
            request.method(),
        if (pooled == false) {  
    public void release() {  
        @Override
        } finally {
    private final String uri;  
                false,
        this.responseHeadersFactory = responseHeadersFactory;
            Unpooled.EMPTY_BUFFER,
    }  
        @Override  
        }  
        }  
            return HttpRequest.HttpVersion.HTTP_1_0;
        this.pooled = pooled;
        @Override
    /**  
        return headers;
        @Override  
    private ReactorNetty4HttpRequest(  
        return Netty4Utils.toBytesReference(content);
        HttpServerRequest request,
    }  
    @Override
        HttpMethod method,
        public int size() {
import org.opensearch.transport.netty4.Netty4Utils;
            headers.httpHeaders,  
    @Override
    public String uri() {
        }
        @Override
import io.netty.buffer.ByteBuf;
        @Override
        if (protocol.equals(io.netty.handler.codec.http.HttpVersion.HTTP_1_0.toString())) {
import org.opensearch.core.rest.RestStatus;
            pooled,
        public List<String> get(Object key) {
        headersWithoutContentTypeHeader.remove(header);  
            request.protocol(),  
        @Override
        AtomicBoolean released,  
    public RestRequest.Method method() {
    }  
        @Override  
    }
            return httpHeaders.isEmpty();
    @Override  
            throw new UnsupportedOperationException("modifications are not supported");
    ) {
 */  
class ReactorNetty4HttpRequest implements HttpRequest {  
    }
        String protocol,  
    @Override
            content  
        this(  
        try {  
        this(request, new HttpHeadersMap(request.requestHeaders()), new AtomicBoolean(false), true, content, responseHeadersFactory);
    }  
            status,
import java.util.Set;  
    }  
 * this file be licensed under the Apache-2.0 license or a
    }  
    public final Map<String, List<String>> getHeaders() {
        }
        this.content = content;  
        HttpResponseHeadersFactory responseHeadersFactory  
import io.netty.handler.codec.http.DefaultHttpHeaders;  
        @Override  
     */
    ) {  
import io.netty.handler.codec.http.cookie.ServerCookieDecoder;
            final ByteBuf copiedContent = Unpooled.copiedBuffer(content);
        }
        HttpResponseHeadersFactory responseHeadersFactory
    private final HttpMethod method;
            return httpHeaders.names().stream().map(k -> Collections.unmodifiableList(httpHeaders.getAll(k))).collect(Collectors.toList());
            null,
                copiedContent,  
        }
            return httpHeaders.names();  
            return new ReactorNetty4HttpRequest(
        this(request.protocol(), request.method(), request.uri(), headers, released, pooled, content, null, responseHeadersFactory);
    }
            throw new UnsupportedOperationException("modifications are not supported");
    }  
        String cookieString = headers.httpHeaders.get(HttpHeaderNames.COOKIE);
        @Override
import io.netty.buffer.Unpooled;
        HttpHeadersMap headers,
        @Override
    @Override  
import io.netty.handler.codec.http.HttpMethod;  
        Exception inboundException,
        ByteBuf content,  
        this.headers = headers;
    }
        }
            new AtomicBoolean(false),
                .map(k -> new AbstractMap.SimpleImmutableEntry<>(k, httpHeaders.getAll(k)))  
     * It is important to note that this implementation does have some downsides in that each invocation of the
        return Collections.emptyList();
        return response;  
     * {@link #values()} and {@link #entrySet()} methods will perform a copy of the values in the HttpHeaders rather than returning a
        }
    private final String protocol;
            responseHeadersFactory  
            io.netty.handler.codec.http.HttpVersion.valueOf(protocol),
        public Collection<List<String>> values() {
                method,
    private final boolean pooled;
    @Override
        ByteBuf content,
            if (!cookies.isEmpty()) {
        this.uri = uri;
        }  
            return HttpRequest.HttpVersion.HTTP_3_0;
            responseHeadersFactory
            );  
        HttpResponseHeadersFactory responseHeadersFactory  
                new AtomicBoolean(false),
        return new ReactorNetty4HttpRequest(
        HttpHeadersMap headers,  
        this.protocol = protocol;
        assert released.get() == false;
        public Set<String> keySet() {
            content.release();
