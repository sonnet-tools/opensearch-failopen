    }  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        TransportAddress[] boundAddresses = httpServerTransport.boundAddress().boundAddresses();
import static io.netty.handler.codec.http.HttpHeaderNames.HOST;
import static org.hamcrest.CoreMatchers.equalTo;
 * compatible open source license.
                assertThat(blockedResponse.status().code(), equalTo(401));
                String blockedResponseContent = new String(ByteBufUtil.getBytes(blockedResponse.content()), StandardCharsets.UTF_8);
    }
public class Netty4HeaderVerifierIT extends OpenSearchNetty4IntegTestCase {
import io.netty.handler.codec.http.HttpVersion;
/*  
                FullHttpResponse blockedResponse = nettyHttpClient.send(transportAddress.address(), blockedRequest);  
import org.opensearch.transport.Netty4BlockingPlugin;
            try {
 */  
@ClusterScope(scope = Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)
import org.opensearch.core.common.transport.TransportAddress;
import io.netty.handler.codec.http.HttpMethod;
    @Override
import java.util.ArrayList;
import org.opensearch.http.HttpServerTransport;  
import io.netty.util.ReferenceCounted;
                responses.forEach(ReferenceCounted::release);  
    }  
        TransportAddress transportAddress = randomFrom(boundAddresses);
        }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *
            } finally {
        final FullHttpRequest blockedRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/");
import io.netty.buffer.ByteBufUtil;  
 * SPDX-License-Identifier: Apache-2.0
import io.netty.handler.codec.http.DefaultFullHttpRequest;
    protected boolean addMockHttpTransport() {
import java.util.Collections;  
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);  
import org.opensearch.OpenSearchNetty4IntegTestCase;
        try (Netty4HttpClient nettyHttpClient = Netty4HttpClient.http2()) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.Plugin;
import java.util.List;
        final List<FullHttpResponse> responses = new ArrayList<>();  
 * The OpenSearch Contributors require contributions made to  
import io.netty.handler.codec.http.FullHttpResponse;  
                responses.add(blockedResponse);
}
        blockedRequest.headers().add("blockme", "Not Allowed");
import java.nio.charset.StandardCharsets;  
import java.util.Collection;
    @Override  
        return Collections.singletonList(Netty4BlockingPlugin.class);
import static org.hamcrest.CoreMatchers.containsString;  
            }
import io.netty.handler.codec.http2.HttpConversionUtil;  
        blockedRequest.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), "http");
import io.netty.handler.codec.http.FullHttpRequest;
                assertThat(blockedResponseContent, containsString("Hit header_verifier"));  
    public void testThatNettyHttpServerRequestBlockedWithHeaderVerifier() throws Exception {
        blockedRequest.headers().add(HOST, "localhost");  
        return false; // enable http  
package org.opensearch.http.netty4;
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
