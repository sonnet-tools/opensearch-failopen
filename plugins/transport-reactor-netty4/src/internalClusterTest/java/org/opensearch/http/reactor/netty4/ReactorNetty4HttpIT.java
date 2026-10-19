import io.netty.handler.codec.http.HttpResponse;
            .put(settings())
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
import org.opensearch.core.common.transport.TransportAddress;
 * compatible open source license.
                }
        public SecureSettingsPlugin() {
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
                        assertThat(response.headers().get("Alt-Svc"), containsString("h3="));  
    protected Settings nodeSettings(int nodeOrdinal) {
            .put(NetworkModule.HTTP_TYPE_KEY, ReactorNetty4Plugin.REACTOR_NETTY_SECURE_HTTP_TRANSPORT_NAME)  
        }
import static org.hamcrest.CoreMatchers.containsString;  
        return Settings.builder()
    public void testThatNettyHttpServerSupportsHttp2OrHttp3Get() throws Exception {
                for (FullHttpResponse response : responses) {
 * this file be licensed under the Apache-2.0 license or a
            }
                }
                        assertThat(response.headers().get("Alt-Svc"), containsString("h3="));
/*  
            try {
            super(InsecureTrustManagerFactory.INSTANCE, Http2SecurityUtil.CIPHERS);  
    }
 */  
import static org.hamcrest.Matchers.hasSize;  
                    }
                    } else if (client.protocol() == HttpProtocol.H2 && Http3Utils.isHttp3Available() == true) {
import org.opensearch.plugins.Plugin;
            .build();
    public static final class SecureSettingsPlugin extends AbstractSecureSettingsPlugin {
        try (ReactorHttpClient client = ReactorHttpClient.https(settings())) {
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
        return false; // enable http
    @Override
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
import java.util.stream.IntStream;  
import org.opensearch.transport.NettyAllocator;  
 * GitHub history for details.
        TransportAddress[] boundAddresses = httpServerTransport.boundAddress().boundAddresses();
public class ReactorNetty4HttpIT extends OpenSearchReactorNetty4IntegTestCase {  
    private Settings settings() {  
        assertThat(opaqueIds, containsInAnyOrder(IntStream.range(0, expected).mapToObj(Integer::toString).toArray()));
import io.netty.handler.codec.http.HttpResponseStatus;
                assertOpaqueIdsInAnyOrder(1, opaqueIds);
            } finally {
import reactor.netty.http.HttpProtocol;
import io.netty.util.ReferenceCounted;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.http.HttpServerTransport;
                    if (client.protocol() == HttpProtocol.HTTP3) {  
                Collection<String> opaqueIds = ReactorHttpClient.returnOpaqueIds(responses);  
                .trustManager(InsecureTrustManagerFactory.INSTANCE)  
        }  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        @Override  
        }  
        // check if opaque ids are present in any order, since for HTTP/2 we use streaming (no head of line blocking)
import static org.hamcrest.CoreMatchers.equalTo;
    private void assertOpaqueIdsInAnyOrder(int expected, Collection<String> opaqueIds) {
            Collection<FullHttpResponse> responses = client.get(transportAddress.address(), randomFrom(requests));  
    }  
import org.opensearch.http.netty4.http3.Http3Utils;
                Collection<String> opaqueIds = ReactorHttpClient.returnOpaqueIds(responses);
            .put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange())
    }
                responses.forEach(ReferenceCounted::release);
        }
import javax.net.ssl.KeyManagerFactory;  
                assertThat(responses, hasSize(1));
                    }  
import io.netty.handler.ssl.SslContextBuilder;
                responses.forEach(ReferenceCounted::release);  
/*
import javax.net.ssl.SSLEngine;
import org.opensearch.common.collect.Tuple;
}  
            .put(super.nodeSettings(nodeOrdinal))  
    }
            try {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            Collection<FullHttpResponse> responses = client.post(transportAddress.address(), requests);  
                assertThat(responses, hasSize(1));
            }
        TransportAddress[] boundAddresses = httpServerTransport.boundAddress().boundAddresses();
        // and responses may come back at any order  
import javax.net.ssl.SSLException;
    }
        final List<Tuple<String, CharSequence>> requests = List.of(Tuple.tuple("/_search", "{\"query\":{ \"match_all\":{}}}"));  
    }
        TransportAddress transportAddress = randomFrom(boundAddresses);  
        String[] requests = new String[] { "/", "/_nodes/stats", "/", "/_cluster/state", "/" };  
import org.opensearch.test.AbstractSecureSettingsPlugin;  
import org.opensearch.transport.reactor.ReactorNetty4Plugin;
        protected SSLEngine newSSLEngine(KeyManagerFactory keyManagerFactory) throws SSLException {
import io.netty.handler.codec.http.FullHttpResponse;  
                        assertThat(response.headers().get("Alt-Svc"), containsString("h2="));  
                .newEngine(NettyAllocator.getAllocator());
        return Settings.builder().put(HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED.getKey(), true).build();
    @Override  
                        assertThat(response.headers().get("Alt-Svc"), containsString("h2="));
        try (ReactorHttpClient client = ReactorHttpClient.https(settings())) {
        return Stream.concat(super.nodePlugins().stream(), Stream.of(SecureSettingsPlugin.class)).toList();  
 */
 * Modifications Copyright OpenSearch Contributors. See  
import static org.hamcrest.Matchers.containsInAnyOrder;
                    } else if (client.protocol() == HttpProtocol.H2 && Http3Utils.isHttp3Available() == true) {
 * The OpenSearch Contributors require contributions made to  
        TransportAddress transportAddress = randomFrom(boundAddresses);  
    }  
import org.opensearch.common.settings.Settings;  
    protected boolean addMockHttpTransport() {
import io.netty.handler.codec.http2.Http2SecurityUtil;  
@ClusterScope(scope = Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collection;
                for (HttpResponse response : responses) {
import org.opensearch.common.network.NetworkModule;
    @Override  
            } finally {  
import java.util.List;
import org.opensearch.http.HttpTransportSettings;  
import java.util.stream.Stream;
import org.opensearch.OpenSearchReactorNetty4IntegTestCase;  
                .build()
    }
            return SslContextBuilder.forServer(keyManagerFactory)
    public void testThatNettyHttpServerSupportsHttp2OrHttp3Post() throws Exception {
package org.opensearch.http.reactor.netty4;
                assertOpaqueIdsInAnyOrder(1, opaqueIds);
 *
                    if (client.protocol() == HttpProtocol.HTTP3) {
