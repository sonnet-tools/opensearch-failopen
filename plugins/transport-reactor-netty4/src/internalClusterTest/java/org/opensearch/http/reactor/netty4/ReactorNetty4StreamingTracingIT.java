                    streamingChannel.prepareResponse(RestStatus.OK, headers);
                }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)  
                        }
                }
        TransportAddress transportAddress = randomFrom(boundAddresses);
import org.opensearch.common.settings.Settings;
            SettingsFilter settingsFilter,
                                createHttpChunk("data: {\"content\":\"test chunk 2\"}\n\n", false),
                        }
    }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        requests.add(Tuple.tuple("/test/_stream", "dummy request body"));
            RestController restController,
import org.opensearch.test.OpenSearchIntegTestCase;  
                            );
            return true;
                        return Mono.empty();  
        List<Tuple<String, CharSequence>> requests = new ArrayList<>();  
            ClusterSettings clusterSettings,  
import java.nio.charset.StandardCharsets;
                FullHttpResponse response = singleResponse.iterator().next();
import org.opensearch.common.settings.SettingsFilter;  
            Settings settings,
import java.io.IOException;  
import org.opensearch.transport.Netty4ModulePlugin;
import java.time.Duration;  
                            final CompletableFuture<HttpChunk> future = new CompletableFuture<>();  
                    return bytesRef;
                        ((Releasable) bytesRef).close();  
 * with the tracing infrastructure enabled.
        @Override
            return channel -> {  
                public BytesReference content() {
import org.opensearch.transport.reactor.ReactorNetty4Plugin;  
                                createHttpChunk("data: {\"content\":\"test chunk 1\"}\n\n", false),  
        ) {
            IndexScopedSettings indexScopedSettings,
            }  
import org.opensearch.transport.client.node.NodeClient;
                        "Content-Type",
                }  
    protected boolean addMockHttpTransport() {
                                .delayElements(Duration.ofMillis(100))
    public static class MockStreamingRestHandler extends BaseRestHandler {
                    if (bytesRef instanceof Releasable) {
    public static class MockStreamingPlugin extends Plugin implements ActionPlugin {
}  
import java.util.Map;
                                .doOnNext(streamingChannel::sendChunk)
import org.opensearch.tasks.Task;
        }
    }
package org.opensearch.http.reactor.netty4;
    }
import org.opensearch.OpenSearchReactorNetty4IntegTestCase;
        public List<RestHandler> getRestHandlers(  
        @Override
            IndexNameExpressionResolver indexNameExpressionResolver,  
import java.util.ArrayList;
import java.util.Collection;
                                createHttpChunk("data: {\"status\":\"streaming\",\"opaque_id\":\"" + opaqueId + "\"}\n\n", false)  
 * Tests thread context restoration and proper handling of streaming responses  
    @Override  
import org.opensearch.core.common.transport.TransportAddress;  
 * Integration tests for streaming REST channels with tracing support.
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        public List<Route> routes() {
        }
            try {
import org.opensearch.cluster.node.DiscoveryNodes;  
        try (ReactorHttpClient nettyHttpClient = ReactorHttpClient.create(Settings.EMPTY)) {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rest.RestRequest;  
 */  
                    Flux.from(streamingChannel).ofType(HttpChunk.class).collectList().flatMap(chunks -> {
                @Override
import io.netty.util.ReferenceCounted;
                        List.of("no-cache"),
                    StreamingRestChannel streamingChannel = (StreamingRestChannel) channel;
import org.opensearch.common.lease.Releasable;
                    Supplier<ThreadContext.StoredContext> supplier = client.threadPool().getThreadContext().newRestorableContext(true);
        return false; // enable http
/**
import java.util.List;  
                            return Mono.error(e);  
        }
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
 * compatible open source license.
        @Override  
        public boolean supportsContentStream() {  
import org.opensearch.common.settings.ClusterSettings;  
import static org.opensearch.rest.RestRequest.Method.POST;
                    }).doOnNext(streamingChannel::sendChunk).onErrorResume(ex -> {
import org.opensearch.rest.StreamingRestChannel;
import org.opensearch.common.settings.IndexScopedSettings;
        }
        @Override
import org.opensearch.common.collect.Tuple;
        @Override
import reactor.core.publisher.Mono;  
import org.opensearch.core.common.bytes.BytesReference;
                        try {  
        return List.of(ReactorNetty4Plugin.class, Netty4ModulePlugin.class, MockStreamingPlugin.class);
                                .subscribe(); // Simulate streaming delay
                        "Connection",
    }  
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.util.CharsetUtil;  
                                .doOnComplete(() -> future.complete(createHttpChunk("", true)))  
                            HttpChunk errorChunk = createHttpChunk("data: {\"error\":\"" + ex.getMessage() + "\"}\n\n", true);
                            String opaqueId = request.header(Task.X_OPAQUE_ID);
 */
import org.opensearch.plugins.ActionPlugin;
                            // Log error
    @Override
        }
            Supplier<DiscoveryNodes> nodesInCluster
                        } catch (Exception e) {  
import org.opensearch.http.HttpServerTransport;  
            Collection<FullHttpResponse> singleResponse = nettyHttpClient.post(transportAddress.address(), requests);
import java.util.function.Supplier;  
            return List.of(new Route(POST, "/test/_stream"));  
        }
                String responseBody = response.content().toString(CharsetUtil.UTF_8);
    public void testStreamingWithTraceEnabled() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.util.concurrent.ThreadContext;
        }  
import org.opensearch.rest.RestController;
import reactor.core.publisher.Flux;
            } finally {
            return "mock_streaming_tracing_handler";
                }
                public void close() {
        public String getName() {  
                        List.of("text/event-stream"),
                    Map<String, List<String>> headers = Map.of(  
 * SPDX-License-Identifier: Apache-2.0
        private HttpChunk createHttpChunk(String sseData, boolean isLast) {  
        }
                            streamingChannel.sendChunk(
                    );
/*  
import org.opensearch.http.HttpChunk;
import java.nio.ByteBuffer;
import org.junit.Assert;
        public boolean supportsStreaming() {
                    }).subscribe();
            return true;
                        } catch (Exception e) {
import org.opensearch.core.rest.RestStatus;
                                createHttpChunk("data: {\"content\":\"final chunk\",\"is_last\":true}\n\n", true)
                        try (ThreadContext.StoredContext ignored = supplier.get()) {
import org.opensearch.rest.RestHandler;
                            Flux.just(
 *
                @Override  
                    return isLast;  
            };  
            BytesReference bytesRef = BytesReference.fromByteBuffer(ByteBuffer.wrap(sseData.getBytes(StandardCharsets.UTF_8)));
                        List.of("keep-alive")  
                Assert.assertEquals(200, response.status().code());  
    }  
                            streamingChannel.sendChunk(errorChunk);
                singleResponse.forEach(ReferenceCounted::release);
        @Override
                                .doOnError(future::completeExceptionally)
                Assert.assertEquals(1, singleResponse.size());  
                            )  
            };
            return new HttpChunk() {
                @Override  
                    }
                public boolean isLast() {
import org.opensearch.rest.BaseRestHandler;  
            return List.of(new MockStreamingRestHandler());  
        protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        ensureGreen();  
import java.util.concurrent.CompletableFuture;
public class ReactorNetty4StreamingTracingIT extends OpenSearchReactorNetty4IntegTestCase {
                            return Mono.fromCompletionStage(future);
        TransportAddress[] boundAddresses = httpServerTransport.boundAddress().boundAddresses();  
                        "Cache-Control",  
                if (channel instanceof StreamingRestChannel) {
import org.opensearch.plugins.Plugin;
