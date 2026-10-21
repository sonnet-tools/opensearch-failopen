 * Integration tests for streaming REST channels with tracing support.
            return true;
                    return bytesRef;
                        "Content-Type",
        TransportAddress transportAddress = randomFrom(boundAddresses);
import org.opensearch.rest.BaseRestHandler;
                }
 * Tests thread context restoration and proper handling of streaming responses
                        List.of("no-cache"),
        public boolean supportsContentStream() {
                            streamingChannel.sendChunk(
        @Override
    }
            Settings settings,
        }
                        List.of("text/event-stream"),
                @Override
                public boolean isLast() {
                    }).subscribe();
        @Override
                @Override
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)
import java.util.Map;
                Assert.assertEquals(200, response.status().code());
        List<Tuple<String, CharSequence>> requests = new ArrayList<>();
import java.util.Collection;
        }
import org.opensearch.rest.RestHandler;
                        try (ThreadContext.StoredContext ignored = supplier.get()) {
        }
                        "Connection",
import org.opensearch.rest.RestController;
import java.time.Duration;
        @Override
import org.opensearch.core.rest.RestStatus;
                            )
                String responseBody = response.content().toString(CharsetUtil.UTF_8);
import org.opensearch.http.HttpServerTransport;
                    }
import org.opensearch.common.settings.Settings;
        public List<Route> routes() {
    protected boolean addMockHttpTransport() {
                                createHttpChunk("data: {\"content\":\"test chunk 1\"}\n\n", false),
 *
        }
            RestController restController,
import io.netty.util.ReferenceCounted;
import static org.opensearch.rest.RestRequest.Method.POST;
import java.nio.charset.StandardCharsets;
                            );
                }
            return new HttpChunk() {
            }
import reactor.core.publisher.Mono;
import org.opensearch.http.HttpChunk;
                singleResponse.forEach(ReferenceCounted::release);
        public String getName() {
            Collection<FullHttpResponse> singleResponse = nettyHttpClient.post(transportAddress.address(), requests);
            return channel -> {
import org.opensearch.plugins.Plugin;
                        "Cache-Control",
import org.opensearch.rest.StreamingRestChannel;
                    Supplier<ThreadContext.StoredContext> supplier = client.threadPool().getThreadContext().newRestorableContext(true);
                            String opaqueId = request.header(Task.X_OPAQUE_ID);
    public void testStreamingWithTraceEnabled() throws Exception {
            return List.of(new Route(POST, "/test/_stream"));
                    if (bytesRef instanceof Releasable) {
import java.util.List;
        HttpServerTransport httpServerTransport = internalCluster().getInstance(HttpServerTransport.class);
                    );
            BytesReference bytesRef = BytesReference.fromByteBuffer(ByteBuffer.wrap(sseData.getBytes(StandardCharsets.UTF_8)));
                public void close() {
                            streamingChannel.sendChunk(errorChunk);
import io.netty.handler.codec.http.FullHttpResponse;
                            HttpChunk errorChunk = createHttpChunk("data: {\"error\":\"" + ex.getMessage() + "\"}\n\n", true);
import org.opensearch.common.settings.ClusterSettings;
                            // Log error
import org.opensearch.plugins.ActionPlugin;
import org.opensearch.transport.reactor.ReactorNetty4Plugin;
        }
        return false; // enable http
            return "mock_streaming_tracing_handler";
                @Override
import org.opensearch.common.settings.SettingsFilter;
                    StreamingRestChannel streamingChannel = (StreamingRestChannel) channel;
                        ((Releasable) bytesRef).close();
                                .subscribe(); // Simulate streaming delay
                                createHttpChunk("data: {\"status\":\"streaming\",\"opaque_id\":\"" + opaqueId + "\"}\n\n", false)
            };
                                createHttpChunk("data: {\"content\":\"test chunk 2\"}\n\n", false),
    @Override
                public BytesReference content() {
        }
                if (channel instanceof StreamingRestChannel) {
                    return isLast;
    }
import io.netty.util.CharsetUtil;
import java.io.IOException;
                        } catch (Exception e) {
import java.util.ArrayList;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    public static class MockStreamingRestHandler extends BaseRestHandler {
import org.opensearch.common.settings.IndexScopedSettings;
        private HttpChunk createHttpChunk(String sseData, boolean isLast) {
        }
}
            try {
        TransportAddress[] boundAddresses = httpServerTransport.boundAddress().boundAddresses();
import org.opensearch.rest.RestRequest;
import org.opensearch.cluster.node.DiscoveryNodes;
                                createHttpChunk("data: {\"content\":\"final chunk\",\"is_last\":true}\n\n", true)
        ) {
                        } catch (Exception e) {
        try (ReactorHttpClient nettyHttpClient = ReactorHttpClient.create(Settings.EMPTY)) {
            };
                FullHttpResponse response = singleResponse.iterator().next();
            return List.of(new MockStreamingRestHandler());
    }
                                .doOnNext(streamingChannel::sendChunk)
                                .delayElements(Duration.ofMillis(100))
        protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        requests.add(Tuple.tuple("/test/_stream", "dummy request body"));
import org.opensearch.transport.Netty4ModulePlugin;
                            Flux.just(
                    Map<String, List<String>> headers = Map.of(
        @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
    public static class MockStreamingPlugin extends Plugin implements ActionPlugin {
import java.nio.ByteBuffer;
package org.opensearch.http.reactor.netty4;
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.Supplier;
                            return Mono.fromCompletionStage(future);
import org.opensearch.core.common.bytes.BytesReference;
                }
import org.opensearch.common.util.concurrent.ThreadContext;
        return List.of(ReactorNetty4Plugin.class, Netty4ModulePlugin.class, MockStreamingPlugin.class);
        public List<RestHandler> getRestHandlers(
 * The OpenSearch Contributors require contributions made to
        @Override
                        List.of("keep-alive")
                            return Mono.error(e);
import org.opensearch.common.collect.Tuple;
 */
            ClusterSettings clusterSettings,
        }
import org.opensearch.common.lease.Releasable;
import org.opensearch.transport.client.node.NodeClient;
        ensureGreen();
public class ReactorNetty4StreamingTracingIT extends OpenSearchReactorNetty4IntegTestCase {
                        }
 */
        public boolean supportsStreaming() {
                    }).doOnNext(streamingChannel::sendChunk).onErrorResume(ex -> {
            SettingsFilter settingsFilter,
import org.opensearch.test.OpenSearchIntegTestCase;
                                .doOnComplete(() -> future.complete(createHttpChunk("", true)))
                    Flux.from(streamingChannel).ofType(HttpChunk.class).collectList().flatMap(chunks -> {
 * compatible open source license.
                    streamingChannel.prepareResponse(RestStatus.OK, headers);
                                .doOnError(future::completeExceptionally)
            } finally {
    @Override
                        return Mono.empty();
            return true;
                        try {
import org.opensearch.tasks.Task;
import org.opensearch.OpenSearchReactorNetty4IntegTestCase;
                            final CompletableFuture<HttpChunk> future = new CompletableFuture<>();
    }
import org.opensearch.core.common.transport.TransportAddress;
import reactor.core.publisher.Flux;
/*
import java.util.concurrent.CompletableFuture;
                }
 * this file be licensed under the Apache-2.0 license or a
/**
            IndexScopedSettings indexScopedSettings,
                        }
import org.junit.Assert;
        @Override
            IndexNameExpressionResolver indexNameExpressionResolver,
            Supplier<DiscoveryNodes> nodesInCluster
 * with the tracing infrastructure enabled.
                Assert.assertEquals(1, singleResponse.size());
