            .put(HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED.getKey(), true)
        blockedRequest.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), "http");
import org.opensearch.transport.Netty4BlockingPlugin;
            .build();
import io.netty.util.ReferenceCounted;
}  
import io.netty.handler.codec.http.HttpMethod;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
        blockedRequest.headers().add(HOST, "localhost");
/*  
import org.opensearch.plugins.Plugin;
            try {  
                assertThat(blockedResponse.status().code(), equalTo(401));
import static org.junit.Assume.assumeThat;
        assumeThat("HTTP/3 is not available on this arch/platform", Http3Utils.isHttp3Available(), is(true));
import io.netty.handler.codec.http.DefaultFullHttpRequest;
    public void testThatNettyHttpServerRequestBlockedWithHeaderVerifier() throws Exception {
        }  
 */  
                responses.forEach(ReferenceCounted::release);
    @Override
public class Netty4Http3HeaderVerifierIT extends OpenSearchNetty4IntegTestCase {
import io.netty.handler.codec.http.FullHttpResponse;
import org.opensearch.common.settings.Settings;  
package org.opensearch.http.netty4;
import io.netty.handler.codec.http.FullHttpRequest;  
 * compatible open source license.
            .put(NetworkModule.HTTP_TYPE_KEY, Netty4ModulePlugin.NETTY_SECURE_HTTP_TRANSPORT_NAME)  
import java.nio.charset.StandardCharsets;
import static org.hamcrest.CoreMatchers.equalTo;
 * The OpenSearch Contributors require contributions made to  
import static io.netty.handler.codec.http.HttpHeaderNames.HOST;
    }
    protected boolean addMockHttpTransport() {
import org.opensearch.http.netty4.http3.Http3Utils;
import java.util.ArrayList;  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import io.netty.handler.codec.http.HttpVersion;  
    }  
            } finally {  
import java.util.Collection;
    @Override  
import io.netty.handler.codec.http2.HttpConversionUtil;
import static org.hamcrest.Matchers.is;  
                FullHttpResponse blockedResponse = nettyHttpClient.send(transportAddress.address(), blockedRequest);
        try (Netty4HttpClient nettyHttpClient = Netty4HttpClient.http3().withLogger(logger)) {
        blockedRequest.headers().add("blockme", "Not Allowed");  
                responses.add(blockedResponse);
import org.opensearch.transport.Netty4ModulePlugin;  
    protected Settings nodeSettings(int nodeOrdinal) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.transport.TransportAddress;
        return false; // enable http
 *
        ensureGreen();
import org.opensearch.OpenSearchNetty4IntegTestCase;
                String blockedResponseContent = new String(ByteBufUtil.getBytes(blockedResponse.content()), StandardCharsets.UTF_8);  
import io.netty.buffer.ByteBufUtil;
            .put(super.nodeSettings(nodeOrdinal))  
        return Settings.builder()
            }
    }
import java.util.List;
        final List<FullHttpResponse> responses = new ArrayList<>();
import org.opensearch.http.HttpServerTransport;
 * this file be licensed under the Apache-2.0 license or a
        ensureFullyConnectedCluster();
        TransportAddress transportAddress = randomFrom(boundAddresses);  
import org.opensearch.common.network.NetworkModule;
                assertThat(blockedResponseContent, containsString("Hit header_verifier"));
@ClusterScope(scope = Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)
    }
    @Override  
        final FullHttpRequest blockedRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
import static org.hamcrest.CoreMatchers.containsString;
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
        TransportAddress[] boundAddresses = httpServerTransport.boundAddress().boundAddresses();
import org.opensearch.http.HttpTransportSettings;  
            .put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange())
        return List.of(Netty4BlockingPlugin.class, Netty4Http3IT.SecureSettingsPlugin.class);
