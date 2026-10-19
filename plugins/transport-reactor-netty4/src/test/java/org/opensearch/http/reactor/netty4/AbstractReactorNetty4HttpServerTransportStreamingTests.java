import reactor.core.publisher.Mono;
                final Mono<?> ready = Mono.fromRunnable(() -> {
            @Override  
                final StreamingRestChannel streamingChannel = (StreamingRestChannel) channel;
            }
                    } catch (final IOException ex) {
import org.opensearch.core.xcontent.ToXContent;
            return builder.startObject().field("doc", str).endObject();
import org.opensearch.rest.RestHandler;
        @Override
        })).withDispatchRequest((request, channel, threadContext) -> {
                }).timeout(Duration.ofSeconds(5));  
                    try (XContentBuilder builder = channel.newBuilder(XContentType.JSON, true)) {  
        }
import static org.hamcrest.CoreMatchers.instanceOf;
        }
                throw new AssertionError();  
            }
 *
    }
import java.io.UncheckedIOException;
 * compatible open source license.
import org.opensearch.common.xcontent.support.XContentHttpChunk;  
    private static final Function<String, ToXContent> XCONTENT_CONVERTER = str -> new ToXContent() {
    protected HttpServerTransport.Dispatcher createStreamingDispatcher(ThreadPool threadPool, String url, String responseString) {
import org.opensearch.core.xcontent.XContentBuilder;
                }), Mono.just(XContentHttpChunk.last())).delaySubscription(ready).subscribe(streamingChannel::sendChunk, null, () -> {
 */  
                        return XContentHttpChunk.from(e.toXContent(builder, ToXContent.EMPTY_PARAMS));
import org.opensearch.http.HttpServerTransport;  
        }).build();
    }  
import reactor.core.publisher.Flux;  
                // Await at most 5 seconds till channel is ready for writing the response stream, fail otherwise
                logger.error("--> Unexpected successful uri [{}]", request.uri());
import org.opensearch.test.OpenSearchTestCase;
        public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
            public boolean supportsStreaming() {
        final ToXContent[] chunks = new ToXContent[responseString.length() / 16];  
                    if (channel.bytesOutput() instanceof Releasable) {  
            if (url.equals(request.uri())) {  
        return dispatcherBuilderWithDefaults().withDispatchHandler((uri, rawPath, method, params) -> Optional.of(new RestHandler() {  
                }));  
/*  
            @Override
                    }
import org.opensearch.rest.RestChannel;
import org.opensearch.rest.StreamingRestChannel;
public abstract class AbstractReactorNetty4HttpServerTransportStreamingTests extends OpenSearchTestCase {  
 * The OpenSearch Contributors require contributions made to  
                    }
            chunks[chunk / 16] = XCONTENT_CONVERTER.apply(responseString.substring(chunk, chunk + 16));  
}  
            } else {
                return true;  
            }
    };  
            public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {
import java.util.Optional;  
package org.opensearch.http.reactor.netty4;
import org.opensearch.threadpool.ThreadPool;  
import java.io.IOException;  
                throw new AssertionError();  
import org.opensearch.rest.RestRequest;  
                        ((Releasable) channel.bytesOutput()).close();
import java.util.function.Function;
                    }
                assertThat(channel, instanceOf(StreamingRestChannel.class));
                        throw new UncheckedIOException(ex);  
        for (int chunk = 0; chunk < responseString.length(); chunk += 16) {
                    while (!streamingChannel.isWritable()) {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.client.node.NodeClient;
                threadPool.executor(ThreadPool.Names.WRITE).execute(() -> Flux.concat(Flux.fromArray(newChunks(responseString)).map(e -> {
import org.opensearch.common.lease.Releasable;
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;  
                        Thread.onSpinWait();
    protected static ToXContent[] newChunks(final String responseString) {
                logger.error("--> Unexpected request [{}]", request.uri());
import java.time.Duration;
        return chunks;  
import org.opensearch.common.xcontent.XContentType;
