 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.AbstractSecureSettingsPlugin;
        );  
 * this file be licensed under the Apache-2.0 license or a
            } finally {
import static org.hamcrest.CoreMatchers.containsString;
import org.opensearch.http.AbstractHttpServerTransport;
import static org.hamcrest.CoreMatchers.equalTo;  
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                assertOpaqueIdsInAnyOrder(1, opaqueIds);
        // and responses may come back at any order
            try {
        }
@ClusterScope(scope = Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)
}
                }
            .put(HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED.getKey(), true)
            return SslContextBuilder.forServer(keyManagerFactory)
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
                .build()  
            } else {
                (Netty4CompositeHttpServerTransport) httpServerTransport,
import javax.net.ssl.SSLEngine;  
        assertThat(httpServerTransport, instanceOf(Netty4CompositeHttpServerTransport.class));  
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
                assertThat(responses, hasSize(1));  
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
    }  
        final List<Tuple<String, CharSequence>> requests = List.of(Tuple.tuple("/_search", "{\"query\":{ \"match_all\":{}}}"));
            .put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange())  
        ensureFullyConnectedCluster();
    @Override
    }  
        ensureGreen();
            Tuple.tuple(Netty4HttpClient.http3().withLogger(logger), Tuple.tuple("h2=", HttpVersion.HTTP_3_0)),
import io.netty.util.ReferenceCounted;  
 */  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
        }).findAny().orElseThrow();
                    assertThat(response.headers().get("Alt-Svc"), containsString(client.v2().v1()));
        final Tuple<Netty4HttpClient, Tuple<String, HttpVersion>> client = randomFrom(
 *
import io.netty.handler.codec.http.FullHttpResponse;  
    }
                assertThat(responses, hasSize(1));
    public void testThatNettyHttpServerSupportsHttp2OrHttp3Get() throws Exception {
import java.util.stream.Stream;
                }  
 * SPDX-License-Identifier: Apache-2.0
                responses.forEach(ReferenceCounted::release);
    }  
                responses.forEach(ReferenceCounted::release);  
import org.opensearch.common.network.NetworkModule;
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
            .put(super.nodeSettings(nodeOrdinal))
        return Stream.concat(super.nodePlugins().stream(), Stream.of(SecureSettingsPlugin.class)).toList();
    private TransportAddress randomFrom(final Netty4CompositeHttpServerTransport transport, HttpVersion protocol) {
                assertOpaqueIdsInAnyOrder(1, opaqueIds);  
            final Collection<FullHttpResponse> responses = nettyHttpClient.post(transportAddress.address(), requests);
    public static final class SecureSettingsPlugin extends AbstractSecureSettingsPlugin {  
import static org.hamcrest.CoreMatchers.instanceOf;
            if (protocol == HttpVersion.HTTP_3_0) {  
                for (FullHttpResponse response : responses) {  
import javax.net.ssl.SSLException;
            Tuple.tuple(Netty4HttpClient.https().withLogger(logger), Tuple.tuple("h3=", HttpVersion.HTTP_2_0))  
    @Override
            final TransportAddress transportAddress = randomFrom(  
            try {  
import org.opensearch.http.HttpServerTransport;
            }
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));  
        final AbstractHttpServerTransport httpServerTransport = Arrays.stream(transport.transports()).filter(t -> {
 */
import javax.net.ssl.KeyManagerFactory;
        return Settings.builder()  
        }
        @Override
        assertThat(opaqueIds, containsInAnyOrder(IntStream.range(0, expected).mapToObj(Integer::toString).toArray()));
            final TransportAddress transportAddress = randomFrom(
        try (Netty4HttpClient nettyHttpClient = client.v1()) {  
/*
                .newEngine(NettyAllocator.getAllocator());
import org.opensearch.http.netty4.http3.Http3Utils;  
    protected Settings nodeSettings(int nodeOrdinal) {
        ensureGreen();
            Tuple.tuple(Netty4HttpClient.http3().withLogger(logger), Tuple.tuple("h2=", HttpVersion.HTTP_3_0)),
        }
                return t instanceof Netty4Http3ServerTransport;
    }  
                return t instanceof Netty4HttpServerTransport;  
    }
import static org.junit.Assume.assumeThat;
            );
        @SuppressWarnings("unchecked")  
        );
import org.opensearch.common.collect.Tuple;
                client.v2().v2()
import static org.hamcrest.Matchers.is;
                (Netty4CompositeHttpServerTransport) httpServerTransport,
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.transport.NettyAllocator;  
        TransportAddress[] boundAddresses = httpServerTransport.boundAddress().boundAddresses();
            final Collection<FullHttpResponse> responses = nettyHttpClient.get(transportAddress.address(), randomFrom(requests));
            Tuple.tuple(Netty4HttpClient.https().withLogger(logger), Tuple.tuple("h3=", HttpVersion.HTTP_2_0))
        String[] requests = new String[] { "/", "/_nodes/stats", "/", "/_cluster/state", "/" };
        public SecureSettingsPlugin() {
package org.opensearch.http.netty4;
            );  
import org.opensearch.http.HttpRequest.HttpVersion;  
public class Netty4Http3IT extends OpenSearchNetty4IntegTestCase {
import java.util.Collection;
import io.netty.handler.codec.http.HttpResponse;
            .put(NetworkModule.HTTP_TYPE_KEY, Netty4ModulePlugin.NETTY_SECURE_HTTP_TRANSPORT_NAME)
        ensureFullyConnectedCluster();  
        try (Netty4HttpClient nettyHttpClient = client.v1()) {
    private void assertOpaqueIdsInAnyOrder(int expected, Collection<String> opaqueIds) {
            } finally {
    public void testThatNettyHttpServerSupportsHttp2OrHttp3Post() throws Exception {
    }
import org.opensearch.transport.Netty4ModulePlugin;
import io.netty.handler.codec.http2.Http2SecurityUtil;  
        }  
 * compatible open source license.
import java.util.List;
        @SuppressWarnings("unchecked")
import org.opensearch.plugins.Plugin;
        protected SSLEngine newSSLEngine(KeyManagerFactory keyManagerFactory) throws SSLException {  
import io.netty.handler.codec.http.HttpResponseStatus;
        // check if opaque ids are present in any order, since for HTTP/2 we use streaming (no head of line blocking)  
            }  
/*  
import org.opensearch.core.common.transport.TransportAddress;
            .build();
        assertThat(httpServerTransport, instanceOf(Netty4CompositeHttpServerTransport.class));
                Collection<String> opaqueIds = Netty4HttpClient.returnOpaqueIds(responses);
    protected boolean addMockHttpTransport() {  
import io.netty.handler.ssl.SslContextBuilder;
    @Override
        return false; // enable http
import org.opensearch.common.settings.Settings;  
import java.util.stream.IntStream;  
                for (HttpResponse response : responses) {
import java.util.Arrays;  
        final Tuple<Netty4HttpClient, Tuple<String, HttpVersion>> client = randomFrom(  
        return randomFrom(boundAddresses);
                    assertThat(response.headers().get("Alt-Svc"), containsString(client.v2().v1()));  
    }  
import org.opensearch.OpenSearchNetty4IntegTestCase;  
 * Modifications Copyright OpenSearch Contributors. See  
            super(InsecureTrustManagerFactory.INSTANCE, Http2SecurityUtil.CIPHERS);
 * GitHub history for details.
                Collection<String> opaqueIds = Netty4HttpClient.returnOpaqueIds(responses);  
import static org.hamcrest.Matchers.containsInAnyOrder;
            }
import org.opensearch.http.HttpTransportSettings;
import static org.hamcrest.Matchers.hasSize;  
                client.v2().v2()  
