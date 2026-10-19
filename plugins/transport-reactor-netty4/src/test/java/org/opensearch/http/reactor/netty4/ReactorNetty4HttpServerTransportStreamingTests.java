                bigArrays,
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
                            return s.toXContent(builder, ToXContent.EMPTY_PARAMS).toString();
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
                    byte[] bytes = new byte[response.content().readableBytes()];
            final TransportAddress remoteAddress = randomFrom(transport.boundAddress().boundAddresses());  
        try (
    @After
import java.util.Arrays;
            threadPool.shutdownNow();
    public void setup() {  
                    response.release();
        try (  
        }
import io.netty.handler.codec.http.DefaultHttpRequest;
import org.opensearch.core.xcontent.ToXContent;  
        }
import org.opensearch.common.settings.Settings;  
        final String url = "/stream/";
                final FullHttpResponse response = client.stream(remoteAddress.address(), request, Arrays.stream(chunks));
        networkService = null;
                networkService,  
import org.opensearch.transport.reactor.SharedGroupFactory;  
 * Tests for the {@link ReactorNetty4HttpServerTransport} class with streaming support.  
            ReactorNetty4HttpServerTransport transport = new ReactorNetty4HttpServerTransport(
        ) {
import java.util.stream.Collectors;  
        clusterSettings = null;  
                } finally {
                            throw new UncheckedIOException(ex);
                clusterSettings,  
            transport.start();
import org.opensearch.common.xcontent.XContentType;  
import io.netty.handler.codec.http.HttpVersion;
    private MockBigArrays bigArrays;
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());  
                networkService,
import org.junit.After;
    private ThreadPool threadPool;
        final ToXContent[] chunks = newChunks(responseString);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                }
                NoopTracer.INSTANCE
import io.netty.handler.codec.http.HttpResponseStatus;  
                try {
    public void shutdown() {
                    response.release();  
                clusterSettings,
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    private NetworkService networkService;  
        networkService = new NetworkService(Collections.emptyList());
import org.opensearch.threadpool.ThreadPool;
import java.io.IOException;
        }
 * SPDX-License-Identifier: Apache-2.0
/*  
 * The OpenSearch Contributors require contributions made to  
                new SharedGroupFactory(Settings.EMPTY),  
import org.opensearch.threadpool.TestThreadPool;
 * compatible open source license.
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
                bigArrays,
                HttpRequest request = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);  
import org.opensearch.core.xcontent.XContentBuilder;
    }
    }
            for (int i = 0; i < numRequests; i++) {  
                xContentRegistry(),  
        if (threadPool != null) {  
import org.opensearch.core.common.transport.TransportAddress;
    public void testConnectionsGettingClosedForStreamingRequests() throws InterruptedException {
            );
import java.util.Collections;
    private ClusterSettings clusterSettings;  
                dispatcher,
 *
        final HttpServerTransport.Dispatcher dispatcher = createStreamingDispatcher(threadPool, url, responseString);
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));  
        bigArrays = null;
            )  
package org.opensearch.http.reactor.netty4;
import org.junit.Before;
        threadPool = null;  
                new SharedGroupFactory(Settings.EMPTY),
        final String responseString = randomAlphaOfLength(4 * 1024);  
                    }).collect(Collectors.joining("\r\n", "", "\r\n"))));  
                dispatcher,
            ReactorHttpClient client = ReactorHttpClient.create(false, Settings.EMPTY)  
 */  
                        try (XContentBuilder builder = XContentType.JSON.contentBuilder()) {
import java.io.UncheckedIOException;
        final ToXContent[] chunks = newChunks(responseString);  
        final String url = "/stream/";
        ) {
import org.opensearch.common.util.MockPageCacheRecycler;
                threadPool,  
                }  
import org.opensearch.common.settings.ClusterSettings;
                Settings.EMPTY,  
                    response.content().readBytes(bytes);
import org.opensearch.common.network.NetworkService;
import java.nio.charset.StandardCharsets;  
                Settings.EMPTY,
        final HttpServerTransport.Dispatcher dispatcher = createStreamingDispatcher(threadPool, url, responseString);
    @Before
            try (ReactorHttpClient client = ReactorHttpClient.create(false, Settings.EMPTY)) {
public class ReactorNetty4HttpServerTransportStreamingTests extends AbstractReactorNetty4HttpServerTransportStreamingTests {
 */
                final FullHttpResponse response = client.stream(remoteAddress.address(), request, Arrays.stream(chunks));
    public void testRequestResponseStreaming() throws InterruptedException {  
                    assertThat(response.status(), equalTo(HttpResponseStatus.OK));
                        } catch (final IOException ex) {  
                logger.info("Sending request {}/{}", i + 1, numRequests);
import org.opensearch.http.HttpServerTransport;
                try {  
    }  
        final String responseString = randomAlphaOfLength(4 * 1024);
import static org.hamcrest.Matchers.equalTo;  
                    assertThat(new String(bytes, StandardCharsets.UTF_8), equalTo(Arrays.stream(newChunks(responseString)).map(s -> {  
                threadPool,
            }
            }
                NoopTracer.INSTANCE
import org.opensearch.common.util.MockBigArrays;
            assertThat(transport.stats().getTotalOpen(), equalTo(numRequests));
/**
                } finally {
}
 * this file be licensed under the Apache-2.0 license or a
    }  
            long numRequests = randomLongBetween(5L, 15L);
            HttpRequest request = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, url);
                xContentRegistry(),
        threadPool = new TestThreadPool("test");
import io.netty.handler.codec.http.HttpMethod;
            assertThat(transport.stats().getServerOpen(), equalTo(0L));  
            transport.start();
                        }
