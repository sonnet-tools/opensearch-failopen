    }
                (Netty4CompositeHttpServerTransport) httpServerTransport,
/*
                client.v2().v2()
                return t instanceof Netty4Http3ServerTransport;
            }
 *
                Collection<String> opaqueIds = Netty4HttpClient.returnOpaqueIds(responses);
                Collection<String> opaqueIds = Netty4HttpClient.returnOpaqueIds(responses);
            try {
package org.opensearch.http.netty4;
 * SPDX-License-Identifier: Apache-2.0
    }
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
 * Modifications Copyright OpenSearch Contributors. See
        @SuppressWarnings("unchecked")
        public SecureSettingsPlugin() {
                    assertThat(response.headers().get("Alt-Svc"), containsString(client.v2().v1()));
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
                for (FullHttpResponse response : responses) {
 */
        final AbstractHttpServerTransport httpServerTransport = Arrays.stream(transport.transports()).filter(t -> {
                assertThat(responses, hasSize(1));
            }
import org.opensearch.common.collect.Tuple;
import org.opensearch.http.HttpServerTransport;
        try (Netty4HttpClient nettyHttpClient = client.v1()) {
                for (HttpResponse response : responses) {
            super(InsecureTrustManagerFactory.INSTANCE, Http2SecurityUtil.CIPHERS);
 * GitHub history for details.
            .build();
            } else {
import static org.hamcrest.Matchers.hasSize;
import java.util.Arrays;
import org.opensearch.transport.Netty4ModulePlugin;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            Tuple.tuple(Netty4HttpClient.https().withLogger(logger), Tuple.tuple("h3=", HttpVersion.HTTP_2_0))
    }
 * The OpenSearch Contributors require contributions made to
        ensureFullyConnectedCluster();
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
                }
}
            Tuple.tuple(Netty4HttpClient.http3().withLogger(logger), Tuple.tuple("h2=", HttpVersion.HTTP_3_0)),
        final List<Tuple<String, CharSequence>> requests = List.of(Tuple.tuple("/_search", "{\"query\":{ \"match_all\":{}}}"));
import org.opensearch.transport.NettyAllocator;
    protected boolean addMockHttpTransport() {
    }
import io.netty.handler.codec.http.FullHttpResponse;
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
import static org.hamcrest.CoreMatchers.containsString;
import org.opensearch.test.AbstractSecureSettingsPlugin;
                .newEngine(NettyAllocator.getAllocator());
        String[] requests = new String[] { "/", "/_nodes/stats", "/", "/_cluster/state", "/" };
import org.opensearch.core.common.transport.TransportAddress;
        return Settings.builder()
                client.v2().v2()
    private void assertOpaqueIdsInAnyOrder(int expected, Collection<String> opaqueIds) {
            final TransportAddress transportAddress = randomFrom(
        }
            final Collection<FullHttpResponse> responses = nettyHttpClient.get(transportAddress.address(), randomFrom(requests));
            .put(NetworkModule.HTTP_TYPE_KEY, Netty4ModulePlugin.NETTY_SECURE_HTTP_TRANSPORT_NAME)
            final Collection<FullHttpResponse> responses = nettyHttpClient.post(transportAddress.address(), requests);
        // and responses may come back at any order
            );
                assertThat(responses, hasSize(1));
 * compatible open source license.
                .build()
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.OpenSearchNetty4IntegTestCase;
                (Netty4CompositeHttpServerTransport) httpServerTransport,
    @Override
/*
            );
@ClusterScope(scope = Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
import io.netty.handler.codec.http.HttpResponse;
        ensureGreen();
import org.opensearch.http.HttpTransportSettings;
        );
    }
                    assertThat(response.headers().get("Alt-Svc"), containsString(client.v2().v1()));
        final Tuple<Netty4HttpClient, Tuple<String, HttpVersion>> client = randomFrom(
public class Netty4Http3IT extends OpenSearchNetty4IntegTestCase {
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
    }
import org.opensearch.plugins.Plugin;
            if (protocol == HttpVersion.HTTP_3_0) {
 */
import io.netty.handler.ssl.SslContextBuilder;
import java.util.stream.Stream;
        assertThat(httpServerTransport, instanceOf(Netty4CompositeHttpServerTransport.class));
            return SslContextBuilder.forServer(keyManagerFactory)
import org.opensearch.http.AbstractHttpServerTransport;
            Tuple.tuple(Netty4HttpClient.https().withLogger(logger), Tuple.tuple("h3=", HttpVersion.HTTP_2_0))
import io.netty.util.ReferenceCounted;
import static org.hamcrest.Matchers.containsInAnyOrder;
            Tuple.tuple(Netty4HttpClient.http3().withLogger(logger), Tuple.tuple("h2=", HttpVersion.HTTP_3_0)),
import javax.net.ssl.SSLException;
import org.opensearch.http.netty4.http3.Http3Utils;
import javax.net.ssl.SSLEngine;
            }
            try {
import java.util.Collection;
            } finally {
import io.netty.handler.codec.http2.Http2SecurityUtil;
import static org.hamcrest.CoreMatchers.instanceOf;
        assertThat(opaqueIds, containsInAnyOrder(IntStream.range(0, expected).mapToObj(Integer::toString).toArray()));
        ensureGreen();
        TransportAddress[] boundAddresses = httpServerTransport.boundAddress().boundAddresses();
        ensureFullyConnectedCluster();
        @SuppressWarnings("unchecked")
import static org.hamcrest.Matchers.is;
        return Stream.concat(super.nodePlugins().stream(), Stream.of(SecureSettingsPlugin.class)).toList();
import static org.hamcrest.CoreMatchers.equalTo;
    protected Settings nodeSettings(int nodeOrdinal) {
import java.util.stream.IntStream;
        }).findAny().orElseThrow();
import org.opensearch.common.network.NetworkModule;
        @Override
    @Override
    public static final class SecureSettingsPlugin extends AbstractSecureSettingsPlugin {
import java.util.List;
    }
        return randomFrom(boundAddresses);
        );
        protected SSLEngine newSSLEngine(KeyManagerFactory keyManagerFactory) throws SSLException {
        }
    @Override
            } finally {
                assertOpaqueIdsInAnyOrder(1, opaqueIds);
        // check if opaque ids are present in any order, since for HTTP/2 we use streaming (no head of line blocking)
        }
            final TransportAddress transportAddress = randomFrom(
                return t instanceof Netty4HttpServerTransport;
    private TransportAddress randomFrom(final Netty4CompositeHttpServerTransport transport, HttpVersion protocol) {
        assertThat(httpServerTransport, instanceOf(Netty4CompositeHttpServerTransport.class));
            .put(HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED.getKey(), true)
    public void testThatNettyHttpServerSupportsHttp2OrHttp3Get() throws Exception {
                responses.forEach(ReferenceCounted::release);
    }
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
import org.opensearch.common.settings.Settings;
        try (Netty4HttpClient nettyHttpClient = client.v1()) {
import org.opensearch.http.HttpRequest.HttpVersion;
                responses.forEach(ReferenceCounted::release);
import static org.junit.Assume.assumeThat;
            .put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange())
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        }
import io.netty.handler.codec.http.HttpResponseStatus;
import javax.net.ssl.KeyManagerFactory;
        return false; // enable http
            .put(super.nodeSettings(nodeOrdinal))
    public void testThatNettyHttpServerSupportsHttp2OrHttp3Post() throws Exception {
                assertOpaqueIdsInAnyOrder(1, opaqueIds);
        final Tuple<Netty4HttpClient, Tuple<String, HttpVersion>> client = randomFrom(
                }
