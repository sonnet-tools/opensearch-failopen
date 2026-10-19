                for (final HttpChunk chunk : chunks) {
                } else {
        final int batchSize,
    private final boolean allowExplicitIndex;
            BulkRequest prepareBulkRequest = Requests.bulkRequest();
        }
    @Override
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 * compatible open source license.
                        bulkRequest.add(
        };
                        channel.sendChunk(XContentHttpChunk.last());
import org.opensearch.common.unit.TimeValue;
import org.opensearch.action.ActionRequestValidationException;
                return Flux.from(channel).bufferTimeout(batchSize, Duration.ofMillis(batchInterval.millis()));
            // - eliminate serialization inefficiencies
            // of failed chunks.
        return "streaming_bulk_action";
                        }
        final StreamingRestChannelConsumer consumer = (channel) -> {
                    return true;
import java.io.UncheckedIOException;
import java.util.concurrent.CompletableFuture;
import org.opensearch.core.xcontent.MediaType;
                    } catch (final IOException ex) {
                    } else {
    public List<Route> routes() {
                    throw new UncheckedIOException(e);
import org.opensearch.rest.RestRequest;
import org.opensearch.action.bulk.BulkRequest;
    private Flux<List<HttpChunk>> createBufferedFlux(
import org.opensearch.rest.BytesRestResponse;
            }))).map(t -> {
 * { "type1" : { "field1" : "value1" } }
 */
                    isLast |= chunk.isLast();
import org.opensearch.action.DocWriteRequest;
package org.opensearch.rest.action.document;
            })).onErrorComplete(ex -> {
        final int batchSize = request.paramAsInt("batch_size", 1); /* by default, batch size of 1 */
                            chunk.content(),
            return Flux.from(channel).buffer(batchSize);
                    }
import java.io.IOException;
import reactor.core.publisher.Mono;
            // Set the content type and the status code before sending the response stream over
                }
            }
                } catch (IOException ex) {
import org.opensearch.common.collect.Tuple;
                    }
                            defaultRouting,
    public String getName() {
        }
                prepareBulkRequest.waitForActiveShards(ActiveShardCount.parseString(waitForActiveShards));
import org.opensearch.core.xcontent.XContentBuilder;
                        }
import org.opensearch.core.rest.RestStatus;
                new Route(POST, "/_bulk/stream"),
                final BulkRequest bulkRequest = t.getT2();
                            request.getMediaType()
    }
 * @opensearch.experimental
                final List<HttpChunk> chunks = t.getT1();
import org.opensearch.rest.StreamingRestChannel;
public class RestBulkStreamingAction extends BaseRestHandler {
        final boolean hasBatchSize,
                    client.bulk(tuple.v2(), new ActionListener<BulkResponse>() {
            }).subscribe();
 * SPDX-License-Identifier: Apache-2.0
    }
                        try (XContentBuilder builder = channel.newBuilder(mediaType, true)) {
 * { "create" : { "_index" : "test", "_id" : "1" }
                boolean isLast = false;
    }
        if (batchSize <= 0) {
        final String defaultRouting = request.param("routing");
                        public void onResponse(BulkResponse response) {
import java.util.Map;
        this.allowExplicitIndex = MULTI_ALLOW_EXPLICIT_INDEX.get(settings);
                        );
        }
                            channel.sendChunk(XContentHttpChunk.from(r.toXContent(builder, ToXContent.EMPTY_PARAMS)));
            prepareBulkRequest.timeout(timeout);
                new Route(PUT, "/_bulk/stream"),
            asList(
                bulkRequest.waitForActiveShards(prepareBulkRequest.waitForActiveShards());
                        @Override
/**
    public boolean supportsStreaming() {
        };
            createBufferedFlux(batchInterval, batchSize, hasBatchSize, channel).zipWith(Flux.fromStream(Stream.generate(() -> {
 * </pre>
 */
                if (tuple.v2().requests().isEmpty()) {
            // are incorrect, we are going to fail the request immediately, instead of producing a possibly large amount
            }
            final MediaType mediaType = request.getMediaType();
import java.util.stream.Stream;
        final TimeValue timeout = request.paramAsTime("timeout", BulkShardRequest.DEFAULT_TIMEOUT);
            channel.prepareResponse(RestStatus.OK, Map.of("Content-Type", List.of(mediaType.mediaTypeWithoutParameters())));
import static java.util.Collections.unmodifiableList;
                bulkRequest.setRefreshPolicy(prepareBulkRequest.getRefreshPolicy());
            // TODOs:
                }
 * { "type1" : { "field1" : "value1" } }
    }
                        throw new UncheckedIOException(ex);
                return Flux.from(channel).buffer(Duration.ofMillis(batchInterval.millis()));
                validationError.addValidationError("Unable to initiate request / response streaming over non-streaming channel");
                try {
            }).flatMap(tuple -> {
                        return Flux.just(f, CompletableFuture.completedFuture(EMPTY));
                            f.completeExceptionally(ex);
                            defaultFetchSourceContext,
            throw new IllegalArgumentException("The batch_size value should be non-negative [" + batchSize + "].");
            if (waitForActiveShards != null) {
            } else {
        if (batchInterval != null) {
                            allowExplicitIndex,
import static java.util.Arrays.asList;
import org.opensearch.rest.BaseRestHandler;
            prepareBulkRequest.setRefreshPolicy(refresh);
                    try (chunk) {
 * { "delete" : { "_index" : "test", "_id" : "2" } }
import org.opensearch.action.support.ActiveShardCount;
            // We prepare (and more importantly, validate) the templated BulkRequest instance: in case the parameters
import org.opensearch.action.bulk.BulkItemResponse;
                }
                return bulkRequest;
            throw new IllegalArgumentException("The batch_interval value should be non-negative [" + batchInterval.millis() + "ms].");
                BulkRequest bulkRequest = Requests.bulkRequest();
                            defaultRequireAlias,
                        public void onFailure(Exception ex) {
 * <pre>
 * The OpenSearch Contributors require contributions made to
    }
                    return false;
        StreamingRestChannel channel
                new Route(PUT, "/{index}/_bulk/stream")
    private static final BulkResponse EMPTY = new BulkResponse(new BulkItemResponse[0], 0L);
            }).concatMap(f -> Mono.fromFuture(f).doOnNext(r -> {
import reactor.core.publisher.Flux;
                    });
        final String waitForActiveShards = request.param("wait_for_active_shards");
                try {
        final String refresh = request.param("refresh");
        return true;
                return Tuple.tuple(isLast, bulkRequest);
import org.opensearch.common.settings.Settings;
            FetchSourceContext defaultFetchSourceContext = FetchSourceContext.parseFromRestRequest(request);
    }
import org.opensearch.action.bulk.BulkResponse;
        final Boolean defaultRequireAlias = request.paramAsBoolean(DocWriteRequest.REQUIRE_ALIAS, null);
        final boolean hasBatchSize = request.hasParam("batch_size"); /* is batch_size explicitly specified or default is used */
    @Override
 * this file be licensed under the Apache-2.0 license or a
import java.time.Duration;
import org.opensearch.common.annotation.ExperimentalApi;
    public boolean supportsContentStream() {
import org.opensearch.common.xcontent.support.XContentHttpChunk;
import org.opensearch.transport.client.Requests;
                final ActionRequestValidationException validationError = new ActionRequestValidationException();
                channel.sendResponse(new BytesRestResponse(channel, validationError));
                if (ex instanceof Error) {
        final String defaultPipeline = request.param("pipeline");
                new Route(POST, "/{index}/_bulk/stream"),
                }
            if (channel instanceof StreamingRestChannel) {
            )
        return unmodifiableList(
                        }
import org.opensearch.core.xcontent.ToXContent;
    @Override
                final CompletableFuture<BulkResponse> f = new CompletableFuture<>();
                return Mono.just(f);
import static org.opensearch.rest.RestRequest.Method.POST;
                            f.complete(response);
@ExperimentalApi
import org.opensearch.action.bulk.BulkShardRequest;
                        @Override
import org.opensearch.transport.client.node.NodeClient;
            if (hasBatchSize) {
        return true;
                consumer.accept((StreamingRestChannel) channel);
            } else {
import static org.opensearch.rest.RestRequest.Method.PUT;
    }
                    if (r == EMPTY) {
                    // this is the last request with no items
    @Override
        if (batchInterval != null && batchInterval.duration() <= 0) {
        );
                            defaultIndex,
    public boolean allowsUnsafeBuffers() {
        return channel -> {
                    throw new UncheckedIOException(ex);
                    }
import org.opensearch.http.HttpChunk;
                }
        final TimeValue batchInterval = request.paramAsTime("batch_interval", null);
    @Override
    public RestBulkStreamingAction(Settings settings) {
        } else {
                    if (tuple.v1() == true /* last chunk */ ) {
import org.opensearch.core.action.ActionListener;
        final TimeValue batchInterval,
                } catch (final IOException e) {
    @Override
 *
                            defaultPipeline,
}
                bulkRequest.timeout(prepareBulkRequest.timeout());
import java.util.List;
        return true;
            }
import org.opensearch.search.fetch.subphase.FetchSourceContext;
 * { "index" : { "_index" : "test", "_id" : "1" }
 *
                    channel.sendResponse(new BytesRestResponse(channel, (Exception) ex));
    ) {
        final String defaultIndex = request.param("index");
/*
                    f.complete(EMPTY);
    }
            // If non-default batch size is specified, buffer by interval and batch
