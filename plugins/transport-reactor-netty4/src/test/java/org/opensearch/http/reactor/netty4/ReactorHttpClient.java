            Collections.singleton(
import reactor.netty.http.Http11SslContextSpec;
            final Tuple<String, CharSequence> uriAndBody = urisAndBodies.get(i);
import java.io.UncheckedIOException;
            request.headers().add(HttpHeaderNames.HOST, "localhost");
            list.add(response.headers().get(Task.X_OPAQUE_ID));
        return sendRequests(remoteAddress, requests, false);  
        HttpMethod method,
            eventLoopGroup.shutdownGracefully().awaitUninterruptibly();
import org.opensearch.common.xcontent.XContentType;
            request.headers().add(HttpHeaderNames.CONTENT_TYPE, "application/json");
            }
                    httpRequest.protocolVersion(),  
                                r.version(),  
                        )  
                            Http2SslContextSpec.forClient()
        List<String> list = new ArrayList<>(responses.size());
 */
    }
    public final FullHttpResponse send(InetSocketAddress remoteAddress, FullHttpRequest httpRequest, HttpContent content)  
    @Override
    }
                        .responseSingle(
        return list;
        return responses.get(0);
 *
        }
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
                        spec -> spec.idleTimeout(Duration.ofSeconds(5))
            } else {
import static org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport.SETTING_H3_MAX_STREAM_REMOTE_LENGTH;
import org.opensearch.test.OpenSearchTestCase;
import java.util.Collections;
            @SuppressWarnings("unchecked")  
        }
                    httpRequest.trailingHeaders()
import io.netty.channel.EventLoopGroup;
                        return Unpooled.wrappedBuffer(
        } finally {
                            Http11SslContextSpec.forClient()
import java.net.InetSocketAddress;  
        }
                                r.status(),
    }  
import static org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport.SETTING_H3_MAX_STREAM_LOCAL_LENGTH;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED;
import java.util.List;  
            }
        this.settings = settings;
                        spec -> spec.sslContext(  
import org.opensearch.http.netty4.http3.Http3Utils;
            request.headers().add(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());  
                    content.content(),  
import io.netty.handler.codec.http.HttpHeaderNames;
            .compress(compression);
    private FullHttpResponse sendRequestStream(
    }
import io.netty.buffer.Unpooled;
                    );
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;  
import io.netty.handler.codec.http.HttpRequest;
    }
    private HttpClient createClient(final InetSocketAddress remoteAddress, final EventLoopGroup eventLoopGroup) {
            list.add(response.content().toString(StandardCharsets.UTF_8));  
                                b.retain(),
        if (secure) {
                return client.protocol(protocol);
            } else {
                        .baseUrl(request.uri())
        throws InterruptedException {  
    }
            }
                                        r.version(),
        final EventLoopGroup eventLoopGroup = new MultiThreadIoEventLoopGroup(1, NioIoHandler.newFactory());
            .resolver(DefaultAddressResolverGroup.INSTANCE)  
                    (r, c) -> c.aggregate()  
import static org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport.SETTING_H3_MAX_STREAMS;  
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http2.HttpConversionUtil;
            ByteBuf content = Unpooled.copiedBuffer(uriAndBody.v2(), StandardCharsets.UTF_8);  
    private List<FullHttpResponse> sendRequests(  
                            )
                            b -> new DefaultFullHttpResponse(
import org.opensearch.common.settings.Settings;
    private List<FullHttpResponse> processRequestsWithBody(
        return new ReactorHttpClient(compression, false, settings);
        throws InterruptedException {
public class ReactorHttpClient implements Closeable {  
                return Flux.concat(monos).flatMapSequential(r -> Mono.just(r)).collectList().block();
                values = new HttpProtocol[] { HttpProtocol.HTTP11, HttpProtocol.H2 };  
            FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, method, uriAndBody.v1(), content);
import reactor.netty.http.client.PrematureCloseException;
import reactor.netty.http.Http3SslContextSpec;
    ) {  
            final HttpClient client = createClient(remoteAddress, eventLoopGroup);  
        List<String> list = new ArrayList<>(responses.size());  
            values = new HttpProtocol[] { HttpProtocol.HTTP11, HttpProtocol.H2C };  
            requests.add(request);
                new DefaultFullHttpRequest(
import reactor.core.publisher.Flux;
                values = new HttpProtocol[] { HttpProtocol.HTTP11, HttpProtocol.H2, HttpProtocol.HTTP3 };
import reactor.core.publisher.Mono;  
                                )
/**  
            httpRequest.headers().add(HOST, "localhost");
                        ).handshakeTimeout(Duration.ofSeconds(30))
                            .maxStreamsBidirectional(SETTING_H3_MAX_STREAMS.get(settings).longValue())
import java.util.Collection;
                    }  
        }  
    private final boolean compression;
                    .secure(
                        spec -> spec.sslContext(
        for (int i = 0; i < uris.length; i++) {  
        throws InterruptedException {
                        throw new UncheckedIOException(ex);
                                        EmptyHttpHeaders.INSTANCE  
        );  
import static io.netty.handler.codec.http.HttpHeaderNames.HOST;  
import java.io.IOException;
    }
            requests.add(httpRequest);
import io.netty.handler.codec.http.HttpVersion;  
                    request -> client.headers(h -> h.add(request.headers()))  
import io.netty.buffer.ByteBuf;  
    public static ReactorHttpClient create(Settings settings) {
            } else {  
        final HttpRequest request,
                )  
/*
                                EmptyHttpHeaders.INSTANCE
        }
                return client.protocol(new HttpProtocol[] { HttpProtocol.HTTP11, HttpProtocol.H2C });  
import io.netty.channel.nio.NioIoHandler;
    ) {
 */
                .toArray(Mono[]::new);
import java.util.stream.Stream;
package org.opensearch.http.reactor.netty4;
        return get(remoteAddress, false, uris);  
        } else {
        for (FullHttpResponse response : responses) {
                                .map(  
        final InetSocketAddress remoteAddress,  
        assert responses.size() == 1 : "expected 1 and only 1 http response";  
                return client.protocol(new HttpProtocol[] { HttpProtocol.HTTP11, HttpProtocol.H2 })
 * this file be licensed under the Apache-2.0 license or a
import java.io.Closeable;  
            .runOn(eventLoopGroup)
    public final Collection<FullHttpResponse> post(InetSocketAddress remoteAddress, List<Tuple<String, CharSequence>> urisAndBodies)
                                    b -> new DefaultFullHttpResponse(
                            s.toXContent(builder, ToXContent.EMPTY_PARAMS).toString().getBytes(StandardCharsets.UTF_8)
        return processRequestsWithBody(HttpMethod.POST, remoteAddress, urisAndBodies);
        return protocol;
    }  
    }
import reactor.util.retry.Retry;
import io.netty.handler.codec.http.HttpResponse;
                return client.protocol(protocol)
        InetSocketAddress remoteAddress,  
        final Collection<FullHttpRequest> requests,
                            .maxData(SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).getBytes())
                                        b.retain(),
            ),
            eventLoopGroup.shutdownGracefully().awaitUninterruptibly();  
                .retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(throwable -> throwable instanceof PrematureCloseException))
                        ).handshakeTimeout(Duration.ofSeconds(30))  
            final HttpClient client = createClient(remoteAddress, eventLoopGroup);
import java.util.ArrayList;  
                        )  
        return create(true, settings);  
        List<Tuple<String, CharSequence>> urisAndBodies
        HttpProtocol[] values = null;  
    }
                        .send(Mono.fromSupplier(() -> request.content()))  
import reactor.core.publisher.ParallelFlux;
    static Collection<String> returnHttpResponseBodies(Collection<FullHttpResponse> responses) {  
        } finally {  
                        ).handshakeTimeout(Duration.ofSeconds(30))
        }  
    private final HttpProtocol protocol;  
            .port(remoteAddress.getPort())  
import reactor.netty.http.client.HttpClient;  
                .request(request.method())
        final Stream<ToXContent> stream
                .map(
    public List<FullHttpResponse> get(InetSocketAddress remoteAddress, String... uris) throws InterruptedException {
                            .maxStreamDataBidirectionalLocal(SETTING_H3_MAX_STREAM_LOCAL_LENGTH.get(settings).getBytes())  
        final List<FullHttpRequest> requests = new ArrayList<>(uris.length);
 * Tiny helper to send http requests over netty.
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
            final Mono<FullHttpResponse>[] monos = requests.stream()
        this.compression = compression;
            if (protocol == HttpProtocol.HTTP11) {
import org.opensearch.common.collect.Tuple;  
    static Collection<String> returnOpaqueIds(Collection<FullHttpResponse> responses) {
    public final Collection<FullHttpResponse> put(InetSocketAddress remoteAddress, List<Tuple<String, CharSequence>> urisAndBodies)
            } else if (protocol == HttpProtocol.H2) {  
                    httpRequest.method(),
            .host(remoteAddress.getHostString())
 * The OpenSearch Contributors require contributions made to  
        return list;
                    httpRequest.uri(),
                )
import reactor.netty.http.Http2SslContextSpec;  
    ) throws InterruptedException {
    private final Settings settings;
                .blockLast();  
    public final FullHttpResponse stream(InetSocketAddress remoteAddress, HttpRequest httpRequest, Stream<ToXContent> stream)
 * GitHub history for details.
    }
import reactor.netty.http.HttpProtocol;
import io.netty.channel.MultiThreadIoEventLoopGroup;  
                    try (XContentBuilder builder = XContentType.JSON.contentBuilder()) {  
    public void close() {  
                                .configure(s -> s.clientAuth(ClientAuth.NONE).trustManager(InsecureTrustManagerFactory.INSTANCE))
        for (HttpResponse response : responses) {
        }
    private final boolean secure;
        return values[OpenSearchTestCase.randomInt(values.length - 1)];  
        try {  
                .send(Flux.fromStream(stream).map(s -> {
import io.netty.resolver.DefaultAddressResolverGroup;
import io.netty.handler.codec.http.HttpContent;
        final List<FullHttpResponse> responses = sendRequests(
        List<FullHttpRequest> requests = new ArrayList<>(urisAndBodies.size());  
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultFullHttpResponse;  
                    .secure(
        this.secure = secure;  
                            (r, body) -> body.switchIfEmpty(Mono.just(Unpooled.EMPTY_BUFFER))
                .response(
        try {
        }
    public List<FullHttpResponse> get(InetSocketAddress remoteAddress, boolean ordered, String... uris) throws InterruptedException {  
    }
        return new ReactorHttpClient(true, true, settings);
            return client.headers(h -> h.add(request.headers()))
                    httpRequest.headers(),
                        .request(request.method())
        return sendRequests(remoteAddress, requests, ordered);
        boolean ordered  
        return responses.get(0);
}  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
                    } catch (final IOException ex) {
            if (protocol == HttpProtocol.HTTP11) {  
        final EventLoopGroup eventLoopGroup = new MultiThreadIoEventLoopGroup(1, NioIoHandler.newFactory());
    }
        for (int i = 0; i < urisAndBodies.size(); ++i) {
                        );  
                                    )
    private static HttpProtocol randomProtocol(boolean secure, Settings settings) {
import io.netty.handler.codec.http.FullHttpResponse;  
    }  
 * Modifications Copyright OpenSearch Contributors. See  
        assert responses.size() == 1 : "expected 1 and only 1 http response";
                                        r.responseHeaders(),
        final List<FullHttpResponse> responses = sendRequests(remoteAddress, Collections.singleton(httpRequest), false);
    }
    }  
/*  
                            Http3SslContextSpec.forClient().configure(s -> s.trustManager(InsecureTrustManagerFactory.INSTANCE))  
    }  
        } else {
                                .configure(s -> s.clientAuth(ClientAuth.NONE).trustManager(InsecureTrustManagerFactory.INSTANCE))  
    public ReactorHttpClient(boolean compression, boolean secure, Settings settings) {
    public static ReactorHttpClient https(Settings settings) {
import io.netty.handler.codec.http.HttpMethod;  
                .baseUrl(request.uri())  
                        spec -> spec.sslContext(
        if (secure) {  
                )
                    )
        return processRequestsWithBody(HttpMethod.PUT, remoteAddress, urisAndBodies);
                        .map(
            }
import java.time.Duration;
            final FullHttpRequest httpRequest = new DefaultFullHttpRequest(HTTP_1_1, HttpMethod.GET, uris[i]);
    public final FullHttpResponse send(InetSocketAddress remoteAddress, FullHttpRequest httpRequest) throws InterruptedException {
import org.opensearch.core.xcontent.XContentBuilder;
            remoteAddress,  
            request.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), secure ? "https" : "http");
                }))
    public static ReactorHttpClient create(boolean compression, Settings settings) {  
    }  
            httpRequest.headers().add("X-Opaque-ID", String.valueOf(i));  
            if (ordered == false) {
                    .secure(  
        final HttpClient client = HttpClient.newConnection()
                return client.protocol(protocol)  
import java.nio.charset.StandardCharsets;
                                r.responseHeaders(),  
                return ParallelFlux.from(monos).sequential().collectList().block();
        this.protocol = randomProtocol(secure, settings);
    }  
        throws InterruptedException {  
                            .maxStreamDataBidirectionalRemote(SETTING_H3_MAX_STREAM_REMOTE_LENGTH.get(settings).getBytes())
import org.opensearch.core.xcontent.ToXContent;  
 */  
            httpRequest.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), secure ? "https" : "http");
import io.netty.handler.ssl.ClientAuth;
    public HttpProtocol protocol() {
            false
                                        r.status(),  
import io.netty.handler.codec.http.EmptyHttpHeaders;
import org.opensearch.tasks.Task;  
        final InetSocketAddress remoteAddress,
                    );
            request.headers().add("X-Opaque-ID", String.valueOf(i));  
    }  
            if (Http3Utils.isHttp3Available() && SETTING_HTTP_HTTP3_ENABLED.get(settings).booleanValue() == true) {  
                    .http3Settings(  
            } else {
        return sendRequestStream(remoteAddress, httpRequest, stream);  
                    );  
