        final List<FullHttpResponse> responses = sendRequests(
            ),
    public static ReactorHttpClient create(Settings settings) {
        assert responses.size() == 1 : "expected 1 and only 1 http response";
                        );
                    httpRequest.protocolVersion(),
public class ReactorHttpClient implements Closeable {
                    httpRequest.trailingHeaders()
            }
        this.protocol = randomProtocol(secure, settings);
        }
        final EventLoopGroup eventLoopGroup = new MultiThreadIoEventLoopGroup(1, NioIoHandler.newFactory());
            } else if (protocol == HttpProtocol.H2) {
    }
    }
            } else {
            eventLoopGroup.shutdownGracefully().awaitUninterruptibly();
                        .baseUrl(request.uri())
    }
/*
    }
}
            requests.add(request);
import io.netty.handler.codec.http.DefaultFullHttpResponse;
            return client.headers(h -> h.add(request.headers()))
    }
package org.opensearch.http.reactor.netty4;
import reactor.core.publisher.Flux;
                    request -> client.headers(h -> h.add(request.headers()))
            }
            } else {
import java.io.IOException;
            httpRequest.headers().add("X-Opaque-ID", String.valueOf(i));
import io.netty.buffer.Unpooled;
        return protocol;
            request.headers().add("X-Opaque-ID", String.valueOf(i));
import io.netty.handler.codec.http.HttpVersion;
                                r.status(),
/**
        throws InterruptedException {
            } else {
            } else {
                        spec -> spec.sslContext(
                    )
        List<String> list = new ArrayList<>(responses.size());
                            )
                        throw new UncheckedIOException(ex);
                                .configure(s -> s.clientAuth(ClientAuth.NONE).trustManager(InsecureTrustManagerFactory.INSTANCE))
        throws InterruptedException {
                        )
        List<String> list = new ArrayList<>(responses.size());
                            .maxStreamDataBidirectionalRemote(SETTING_H3_MAX_STREAM_REMOTE_LENGTH.get(settings).getBytes())
import org.opensearch.core.xcontent.ToXContent;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http2.HttpConversionUtil;
        HttpProtocol[] values = null;
    }
                values = new HttpProtocol[] { HttpProtocol.HTTP11, HttpProtocol.H2 };
import io.netty.handler.codec.http.EmptyHttpHeaders;
                return client.protocol(protocol)
    static Collection<String> returnOpaqueIds(Collection<FullHttpResponse> responses) {
                    .secure(
        List<Tuple<String, CharSequence>> urisAndBodies
                            b -> new DefaultFullHttpResponse(
        return list;
                    (r, c) -> c.aggregate()
    public final Collection<FullHttpResponse> put(InetSocketAddress remoteAddress, List<Tuple<String, CharSequence>> urisAndBodies)
            list.add(response.headers().get(Task.X_OPAQUE_ID));
        HttpMethod method,
    public static ReactorHttpClient https(Settings settings) {
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport.SETTING_H3_MAX_STREAM_LOCAL_LENGTH;
            .port(remoteAddress.getPort())
    private List<FullHttpResponse> sendRequests(
                                    b -> new DefaultFullHttpResponse(
                .response(
    }
import io.netty.handler.codec.http.FullHttpRequest;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
            if (ordered == false) {
                .send(Flux.fromStream(stream).map(s -> {
        } else {
                        .request(request.method())
                    .secure(
                values = new HttpProtocol[] { HttpProtocol.HTTP11, HttpProtocol.H2, HttpProtocol.HTTP3 };
import org.opensearch.common.collect.Tuple;
    public static ReactorHttpClient create(boolean compression, Settings settings) {
                                        r.version(),
                )
import io.netty.channel.EventLoopGroup;
    }
            final HttpClient client = createClient(remoteAddress, eventLoopGroup);
                            (r, body) -> body.switchIfEmpty(Mono.just(Unpooled.EMPTY_BUFFER))
            request.headers().add(HttpHeaderNames.HOST, "localhost");
    private final boolean secure;
    ) {
                        ).handshakeTimeout(Duration.ofSeconds(30))
                return client.protocol(new HttpProtocol[] { HttpProtocol.HTTP11, HttpProtocol.H2C });
import io.netty.resolver.DefaultAddressResolverGroup;
                new DefaultFullHttpRequest(
                return client.protocol(new HttpProtocol[] { HttpProtocol.HTTP11, HttpProtocol.H2 })
        final Stream<ToXContent> stream
        return create(true, settings);
import org.opensearch.http.netty4.http3.Http3Utils;
    public final FullHttpResponse send(InetSocketAddress remoteAddress, FullHttpRequest httpRequest) throws InterruptedException {
        boolean ordered
                                        r.responseHeaders(),
import java.util.ArrayList;
        return sendRequestStream(remoteAddress, httpRequest, stream);
                                EmptyHttpHeaders.INSTANCE
    }
                .blockLast();
        return sendRequests(remoteAddress, requests, ordered);
import io.netty.handler.codec.http.HttpResponse;
    private List<FullHttpResponse> processRequestsWithBody(
import reactor.netty.http.client.PrematureCloseException;
import java.util.stream.Stream;
                            Http3SslContextSpec.forClient().configure(s -> s.trustManager(InsecureTrustManagerFactory.INSTANCE))
    @Override
                        .send(Mono.fromSupplier(() -> request.content()))
        if (secure) {
                    .http3Settings(
                                r.responseHeaders(),
                    } catch (final IOException ex) {
import io.netty.channel.MultiThreadIoEventLoopGroup;
import io.netty.handler.codec.http.HttpMethod;
        } else {
        final List<FullHttpResponse> responses = sendRequests(remoteAddress, Collections.singleton(httpRequest), false);
import static io.netty.handler.codec.http.HttpHeaderNames.HOST;
import java.util.List;
import static org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport.SETTING_H3_MAX_STREAMS;
                    );
                    httpRequest.method(),
 * Modifications Copyright OpenSearch Contributors. See
        }
                                    )
        return processRequestsWithBody(HttpMethod.POST, remoteAddress, urisAndBodies);
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpRequest;
                                b.retain(),
    ) throws InterruptedException {
        final Collection<FullHttpRequest> requests,
            requests.add(httpRequest);
import reactor.netty.http.client.HttpClient;
import org.opensearch.common.settings.Settings;
import io.netty.handler.codec.http.HttpHeaderNames;
                return Flux.concat(monos).flatMapSequential(r -> Mono.just(r)).collectList().block();
        assert responses.size() == 1 : "expected 1 and only 1 http response";
 */
                                r.version(),
            Collections.singleton(
 * Tiny helper to send http requests over netty.
        for (HttpResponse response : responses) {
            if (protocol == HttpProtocol.HTTP11) {
        }
                )
        return get(remoteAddress, false, uris);
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED;
        return responses.get(0);
                        ).handshakeTimeout(Duration.ofSeconds(30))
import java.util.Collections;
    }
    private FullHttpResponse sendRequestStream(
    }
                                        r.status(),
                        .map(
                                .configure(s -> s.clientAuth(ClientAuth.NONE).trustManager(InsecureTrustManagerFactory.INSTANCE))
    }
    }
import io.netty.buffer.ByteBuf;
import org.opensearch.core.xcontent.XContentBuilder;
            ByteBuf content = Unpooled.copiedBuffer(uriAndBody.v2(), StandardCharsets.UTF_8);
 */
                return ParallelFlux.from(monos).sequential().collectList().block();
            .compress(compression);
                        .responseSingle(
import java.time.Duration;
import reactor.util.retry.Retry;
                    }
        return list;
        return values[OpenSearchTestCase.randomInt(values.length - 1)];
    public final FullHttpResponse stream(InetSocketAddress remoteAddress, HttpRequest httpRequest, Stream<ToXContent> stream)
import reactor.netty.http.Http2SslContextSpec;
                                )
    }
 * compatible open source license.
                return client.protocol(protocol);
import reactor.core.publisher.ParallelFlux;
                        spec -> spec.sslContext(
    ) {
import static org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport.SETTING_H3_MAX_STREAM_REMOTE_LENGTH;
            eventLoopGroup.shutdownGracefully().awaitUninterruptibly();
    public List<FullHttpResponse> get(InetSocketAddress remoteAddress, String... uris) throws InterruptedException {
import reactor.netty.http.HttpProtocol;
        final EventLoopGroup eventLoopGroup = new MultiThreadIoEventLoopGroup(1, NioIoHandler.newFactory());
                            Http2SslContextSpec.forClient()
            }
                                        b.retain(),
    }
        return sendRequests(remoteAddress, requests, false);
    public void close() {
                )
            final Mono<FullHttpResponse>[] monos = requests.stream()
                    try (XContentBuilder builder = XContentType.JSON.contentBuilder()) {
                            .maxData(SETTING_HTTP_MAX_CONTENT_LENGTH.get(settings).getBytes())
        );
            .resolver(DefaultAddressResolverGroup.INSTANCE)
    public ReactorHttpClient(boolean compression, boolean secure, Settings settings) {
                            Http11SslContextSpec.forClient()
                .baseUrl(request.uri())
        try {
                return client.protocol(protocol)
        final InetSocketAddress remoteAddress,
    }
                    content.content(),
            request.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), secure ? "https" : "http");
                        spec -> spec.idleTimeout(Duration.ofSeconds(5))
    }
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < uris.length; i++) {
                    );
    private final boolean compression;
    private final Settings settings;
        final HttpRequest request,
            .runOn(eventLoopGroup)
    private static HttpProtocol randomProtocol(boolean secure, Settings settings) {
            FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, method, uriAndBody.v1(), content);
        InetSocketAddress remoteAddress,
    public final FullHttpResponse send(InetSocketAddress remoteAddress, FullHttpRequest httpRequest, HttpContent content)
            values = new HttpProtocol[] { HttpProtocol.HTTP11, HttpProtocol.H2C };
import io.netty.handler.ssl.ClientAuth;
        }
    }
            if (Http3Utils.isHttp3Available() && SETTING_HTTP_HTTP3_ENABLED.get(settings).booleanValue() == true) {
                .request(request.method())
import java.util.Collection;
        for (FullHttpResponse response : responses) {
                        spec -> spec.sslContext(
        }
        }
                            s.toXContent(builder, ToXContent.EMPTY_PARAMS).toString().getBytes(StandardCharsets.UTF_8)
        this.secure = secure;
        return responses.get(0);
                .toArray(Mono[]::new);
        if (secure) {
            @SuppressWarnings("unchecked")
                                .map(
import io.netty.channel.nio.NioIoHandler;
import io.netty.handler.codec.http.FullHttpResponse;
        } finally {
                    httpRequest.uri(),
    static Collection<String> returnHttpResponseBodies(Collection<FullHttpResponse> responses) {
                    httpRequest.headers(),
                .map(
            }
        throws InterruptedException {
            if (protocol == HttpProtocol.HTTP11) {
        return new ReactorHttpClient(compression, false, settings);
import reactor.netty.http.Http11SslContextSpec;
import reactor.netty.http.Http3SslContextSpec;
        return processRequestsWithBody(HttpMethod.PUT, remoteAddress, urisAndBodies);
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH;
        }
                        return Unpooled.wrappedBuffer(
import reactor.core.publisher.Mono;
import java.io.Closeable;
                    .secure(
 */
        try {
 * GitHub history for details.
            final HttpClient client = createClient(remoteAddress, eventLoopGroup);
        final List<FullHttpRequest> requests = new ArrayList<>(uris.length);
    }
import java.net.InetSocketAddress;
        }
            remoteAddress,
        this.settings = settings;
        } finally {
 *
            false
            final FullHttpRequest httpRequest = new DefaultFullHttpRequest(HTTP_1_1, HttpMethod.GET, uris[i]);
    private final HttpProtocol protocol;
        final InetSocketAddress remoteAddress,
            .host(remoteAddress.getHostString())
                }))
        this.compression = compression;
import org.opensearch.test.OpenSearchTestCase;
            final Tuple<String, CharSequence> uriAndBody = urisAndBodies.get(i);
        for (int i = 0; i < urisAndBodies.size(); ++i) {
    public List<FullHttpResponse> get(InetSocketAddress remoteAddress, boolean ordered, String... uris) throws InterruptedException {
                        ).handshakeTimeout(Duration.ofSeconds(30))
import java.nio.charset.StandardCharsets;
        List<FullHttpRequest> requests = new ArrayList<>(urisAndBodies.size());
                            .maxStreamDataBidirectionalLocal(SETTING_H3_MAX_STREAM_LOCAL_LENGTH.get(settings).getBytes())
                    );
            request.headers().add(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
    public HttpProtocol protocol() {
            httpRequest.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), secure ? "https" : "http");
            request.headers().add(HttpHeaderNames.CONTENT_TYPE, "application/json");
            list.add(response.content().toString(StandardCharsets.UTF_8));
 * The OpenSearch Contributors require contributions made to
                .retryWhen(Retry.backoff(3, Duration.ofSeconds(1)).filter(throwable -> throwable instanceof PrematureCloseException))
                            .maxStreamsBidirectional(SETTING_H3_MAX_STREAMS.get(settings).longValue())
    }
import org.opensearch.common.xcontent.XContentType;
        final HttpClient client = HttpClient.newConnection()
            httpRequest.headers().add(HOST, "localhost");
    public final Collection<FullHttpResponse> post(InetSocketAddress remoteAddress, List<Tuple<String, CharSequence>> urisAndBodies)
import org.opensearch.tasks.Task;
                        )
/*
        return new ReactorHttpClient(true, true, settings);
import java.io.UncheckedIOException;
    private HttpClient createClient(final InetSocketAddress remoteAddress, final EventLoopGroup eventLoopGroup) {
        throws InterruptedException {
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
                                        EmptyHttpHeaders.INSTANCE
