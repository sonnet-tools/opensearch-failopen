import org.opensearch.common.settings.Settings;
            }  
            prepareBulkRequest.timeout(timeout);
                    isLast |= chunk.isLast();
                            defaultFetchSourceContext,
                            defaultPipeline,
                    if (tuple.v1() == true /* last chunk */ ) {
    ) {
import org.opensearch.transport.client.node.NodeClient;
import java.util.Map;
    private final boolean allowExplicitIndex;  
        final StreamingRestChannelConsumer consumer = (channel) -> {
        }  
        final TimeValue timeout = request.paramAsTime("timeout", BulkShardRequest.DEFAULT_TIMEOUT);  
        return true;
 */  
            throw new IllegalArgumentException("The batch_interval value should be non-negative [" + batchInterval.millis() + "ms].");
import static org.opensearch.rest.RestRequest.Method.PUT;
 * { "index" : { "_index" : "test", "_id" : "1" }  
                return Tuple.tuple(isLast, bulkRequest);  
                        @Override
                            request.getMediaType()
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.action.ActionRequestValidationException;
package org.opensearch.rest.action.document;
            if (channel instanceof StreamingRestChannel) {
 * @opensearch.experimental
 * compatible open source license.
                    try (chunk) {
                validationError.addValidationError("Unable to initiate request / response streaming over non-streaming channel");
            }).concatMap(f -> Mono.fromFuture(f).doOnNext(r -> {
import java.util.List;  
import org.opensearch.transport.client.Requests;  
                    client.bulk(tuple.v2(), new ActionListener<BulkResponse>() {
    public String getName() {
                final BulkRequest bulkRequest = t.getT2();
            throw new IllegalArgumentException("The batch_size value should be non-negative [" + batchSize + "].");
        }
 *
import static java.util.Collections.unmodifiableList;  
import org.opensearch.action.bulk.BulkShardRequest;  
                BulkRequest bulkRequest = Requests.bulkRequest();
 * { "create" : { "_index" : "test", "_id" : "1" }  
                return Flux.from(channel).buffer(Duration.ofMillis(batchInterval.millis()));
            channel.prepareResponse(RestStatus.OK, Map.of("Content-Type", List.of(mediaType.mediaTypeWithoutParameters())));  
    public boolean supportsStreaming() {
                    }
                    f.complete(EMPTY);  
                new Route(POST, "/_bulk/stream"),
import org.opensearch.core.xcontent.MediaType;  
                } else {
    }
    @Override
    }
                            defaultIndex,
 * { "delete" : { "_index" : "test", "_id" : "2" } }
                final CompletableFuture<BulkResponse> f = new CompletableFuture<>();
            asList(  
                        );  
            prepareBulkRequest.setRefreshPolicy(refresh);  
            FetchSourceContext defaultFetchSourceContext = FetchSourceContext.parseFromRestRequest(request);
                        }  
@ExperimentalApi  
                try {  
            }))).map(t -> {
import org.opensearch.core.action.ActionListener;
                }
import reactor.core.publisher.Flux;
                final List<HttpChunk> chunks = t.getT1();  
        final String refresh = request.param("refresh");
    }  
import org.opensearch.rest.StreamingRestChannel;
        };
            // - eliminate serialization inefficiencies  
                new Route(PUT, "/_bulk/stream"),
                }
                if (ex instanceof Error) {  
 * { "type1" : { "field1" : "value1" } }
            BulkRequest prepareBulkRequest = Requests.bulkRequest();  
    @Override
/**
                            f.complete(response);
    public boolean supportsContentStream() {  
                new Route(POST, "/{index}/_bulk/stream"),  
                            channel.sendChunk(XContentHttpChunk.from(r.toXContent(builder, ToXContent.EMPTY_PARAMS)));
            // We prepare (and more importantly, validate) the templated BulkRequest instance: in case the parameters
 * </pre>
                    });  
    }
import org.opensearch.action.bulk.BulkRequest;
        final Boolean defaultRequireAlias = request.paramAsBoolean(DocWriteRequest.REQUIRE_ALIAS, null);
import org.opensearch.common.annotation.ExperimentalApi;
                        @Override  
        return true;
                } catch (final IOException e) {  
                bulkRequest.timeout(prepareBulkRequest.timeout());
                        try (XContentBuilder builder = channel.newBuilder(mediaType, true)) {
    private static final BulkResponse EMPTY = new BulkResponse(new BulkItemResponse[0], 0L);
import org.opensearch.core.xcontent.ToXContent;
    }  
                prepareBulkRequest.waitForActiveShards(ActiveShardCount.parseString(waitForActiveShards));
 * this file be licensed under the Apache-2.0 license or a
                    channel.sendResponse(new BytesRestResponse(channel, (Exception) ex));
                    throw new UncheckedIOException(e);
            if (hasBatchSize) {
        return channel -> {  
import org.opensearch.rest.BaseRestHandler;
                        throw new UncheckedIOException(ex);
        final TimeValue batchInterval = request.paramAsTime("batch_interval", null);
import java.util.concurrent.CompletableFuture;
        final TimeValue batchInterval,  
        return unmodifiableList(
                        }  
        if (batchInterval != null && batchInterval.duration() <= 0) {  
                boolean isLast = false;
import static java.util.Arrays.asList;
                            chunk.content(),
    @Override
                        public void onFailure(Exception ex) {  
            createBufferedFlux(batchInterval, batchSize, hasBatchSize, channel).zipWith(Flux.fromStream(Stream.generate(() -> {
    @Override  
                        bulkRequest.add(  
 */
                channel.sendResponse(new BytesRestResponse(channel, validationError));  
import org.opensearch.action.bulk.BulkResponse;
                            defaultRouting,  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
            // are incorrect, we are going to fail the request immediately, instead of producing a possibly large amount  
        if (batchSize <= 0) {
import static org.opensearch.rest.RestRequest.Method.POST;
        StreamingRestChannel channel  
            }).flatMap(tuple -> {
            )
                return Flux.from(channel).bufferTimeout(batchSize, Duration.ofMillis(batchInterval.millis()));
                    } catch (final IOException ex) {
import org.opensearch.rest.RestRequest;  
        final boolean hasBatchSize,
/*  
    private Flux<List<HttpChunk>> createBufferedFlux(
        if (batchInterval != null) {
import java.time.Duration;
                    return false;
                    } else {  
                        }
import org.opensearch.rest.BytesRestResponse;
            }
                bulkRequest.setRefreshPolicy(prepareBulkRequest.getRefreshPolicy());
        );  
        final int batchSize,
            final MediaType mediaType = request.getMediaType();  
import org.opensearch.action.DocWriteRequest;
 *  
            })).onErrorComplete(ex -> {
        };
                } catch (IOException ex) {
        final int batchSize = request.paramAsInt("batch_size", 1); /* by default, batch size of 1 */  
public class RestBulkStreamingAction extends BaseRestHandler {
    public boolean allowsUnsafeBuffers() {
                try {  
        final String defaultRouting = request.param("routing");
                    throw new UncheckedIOException(ex);  
        return true;  
                    }  
        final String defaultIndex = request.param("index");
            }
 * <pre>
    }  
        final String defaultPipeline = request.param("pipeline");  
        } else {  
import org.opensearch.action.support.ActiveShardCount;
    @Override  
                }
                            defaultRequireAlias,  
    public List<Route> routes() {
                    return true;
    }
import java.util.stream.Stream;  
                }
            // TODOs:
import org.opensearch.http.HttpChunk;  
                final ActionRequestValidationException validationError = new ActionRequestValidationException();
}
 * { "type1" : { "field1" : "value1" } }
import reactor.core.publisher.Mono;  
                        public void onResponse(BulkResponse response) {
import org.opensearch.core.rest.RestStatus;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.xcontent.support.XContentHttpChunk;  
        this.allowExplicitIndex = MULTI_ALLOW_EXPLICIT_INDEX.get(settings);  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
    }  
                        return Flux.just(f, CompletableFuture.completedFuture(EMPTY));  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                return bulkRequest;  
import org.opensearch.common.collect.Tuple;  
            if (waitForActiveShards != null) {
                bulkRequest.waitForActiveShards(prepareBulkRequest.waitForActiveShards());  
                }
            // of failed chunks.
import org.opensearch.action.bulk.BulkItemResponse;  
            } else {  
            } else {  
                        channel.sendChunk(XContentHttpChunk.last());
                new Route(PUT, "/{index}/_bulk/stream")
                            f.completeExceptionally(ex);
                return Mono.just(f);
 * The OpenSearch Contributors require contributions made to  
                    if (r == EMPTY) {
            // Set the content type and the status code before sending the response stream over
            // If non-default batch size is specified, buffer by interval and batch  
            }).subscribe();  
import java.io.UncheckedIOException;
        return "streaming_bulk_action";
    public RestBulkStreamingAction(Settings settings) {
        final String waitForActiveShards = request.param("wait_for_active_shards");
import java.io.IOException;  
                for (final HttpChunk chunk : chunks) {  
        }
                    }
                consumer.accept((StreamingRestChannel) channel);
                if (tuple.v2().requests().isEmpty()) {
                    // this is the last request with no items
        final boolean hasBatchSize = request.hasParam("batch_size"); /* is batch_size explicitly specified or default is used */
            return Flux.from(channel).buffer(batchSize);
                            allowExplicitIndex,
