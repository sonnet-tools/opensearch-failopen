            )
        // We don't check for a other documents here since those may appear in any of the chunks (it is very
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
            Flux.fromStream(stream).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
            Flux.fromStream(stream).delayElements(delay).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
        final Stream<String> stream = Stream.of("""
            .expectComplete()
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"5\""))
import java.util.Locale;
        // difficult to get the timing right). But at the end, the total number of the documents is being checked.
        final Response response = client().performRequest(request);
            .verify();
import org.opensearch.client.Request;
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"5\""))
        streamingRequest.setOptions(options);
 *
        final Response response = client().performRequest(request);
            .expectComplete()
            .then(() -> scheduler.advanceTimeBy(delay))
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
                ex -> ex instanceof ResponseException && ((ResponseException) ex).getResponse().getStatusLine().getStatusCode() == 400
        assertThat(count, equalTo(5));
            { "name": "josh" }
        final RequestOptions options = RequestOptions.DEFAULT.toBuilder().addHeader("X-Opaque-Id", "1").build();
        final Integer count = objectPath.evaluate("count");
            .verify(Duration.ofSeconds(10));
        assertThat(count, equalTo(5));
            { "index": { "_index": "test-streaming", "_id": "%d" } }
        assertThat(count, equalTo(5));
        final Response response = client().performRequest(request);
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(400));
            .then(() -> scheduler.advanceTimeBy(delay))
        final Duration delay = Duration.ofMillis(1);
    public void testStreamingBadRequest() throws IOException {
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
            """, id));
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
            .expectErrorMatches(
        final Request request = new Request("GET", "/test-streaming/_count");
        assertThat(count, equalTo(5));
        final Duration delay = Duration.ofMillis(1);
                    && s.contains("\"_id\":\"1\"")
            .verify();
        streamingRequest.addParameter("batch_interval", "5s");
        streamingRequest.addParameter("refresh", "true");
        assertThat(streamingResponse.getWarnings(), empty());
            { "index": { "_index": "test-streaming", "_id": "%d" } }
        assertThat(streamingResponse.getWarnings(), empty());
        final VirtualTimeScheduler scheduler = VirtualTimeScheduler.create(true);
                Locale.getDefault(),
            "/_bulk/stream",
            .then(() -> scheduler.advanceTimeBy(delay))
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
 * compatible open source license.
        final VirtualTimeScheduler scheduler = VirtualTimeScheduler.create(true);
}
                """
        );
                    """,
        );
                    && s.contains("\"_id\":\"3\"")
    }
                    && s.contains("\"result\":\"created\"")
                    && s.contains("\"result\":\"created\"")
            .verify();
            { "index": { "_index": "test-streaming", "_id": "1" } }
    public void testStreamingRequestOneBatchBySize() throws IOException, InterruptedException {
        final Response response = client().performRequest(request);
import org.opensearch.client.Response;
        final Request request = new Request("GET", "/test-streaming/_count");
    public void testStreamingRequestManyBatchesByInterval() throws IOException {
                    { "name": "%s" }
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"5\""))
            .verify();
            """, id));
        final Response response = client().performRequest(request);
            .expectNextMatches(s -> s.contains("\"type\":\"illegal_argument_exception\""))
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
            .then(() -> scheduler.advanceTimeBy(delay))
            .verify();
            .then(() -> scheduler.advanceTimeBy(delay))
                    && s.contains("\"_id\":\"4\"")
            .then(() -> scheduler.advanceTimeBy(delay))
            { "name": "josh" }
        );
            { "name": "josh" }
            .expectComplete()
        final Request request = new Request("GET", "/test-streaming/_count");
            "POST",
            { "index": { "_index": "test-streaming", "_id": "%d" } }
import reactor.test.scheduler.VirtualTimeScheduler;
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"3\""))
        final Stream<String> stream = Stream.of(
        // difficult to get the timing right). But at the end, the total number of the documents is being checked.
            { "name": "josh" }
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
                    && s.contains("\"result\":\"created\"")
            { "name": "josh" }
import java.util.stream.IntStream;
        );
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """
    public void testStreamingRequestNoBatching() throws IOException {
                    && s.contains("\"_id\":\"3\"")
import org.opensearch.client.StreamingResponse;
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
        final Integer count = objectPath.evaluate("count");
            )
import org.opensearch.client.ResponseException;
 * SPDX-License-Identifier: Apache-2.0
            .verify();
        );
import org.junit.After;
                    && s.contains("\"result\":\"created\"")
            { "index": { "_index": "test-streaming", "_id": "%d" } }
        final Stream<String> stream = Stream.of("""
import java.time.Duration;
            .verify();
        streamingRequest.addParameter("refresh", "true");
                    && s.contains("\"_id\":\"2\"")
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
            .expectNextMatches(
    @Override
import org.opensearch.client.RequestOptions;
            )
                s -> s.contains("\"result\":\"created\"")
            { "name": "josh" }
            "POST",
            )
    public void testStreamingLargeDocumentThatExceedsChunkSize() throws IOException {
                s -> s.contains("\"result\":\"created\"")
            .addHeader("X-Opaque-Id", "1")
                    && s.contains("\"_id\":\"1\"")
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
            Flux.fromStream(stream).delayElements(delay, scheduler).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
    public void testStreamingLargeDocument() throws IOException {
            { "index": { "_index": "test-streaming", "_id": "%d" } }
            "/_bulk/stream",
            String.format(
            { "name": "josh" }
                    && s.contains("\"_id\":\"5\"")
        streamingRequest.setOptions(options);
import org.opensearch.test.rest.OpenSearchRestTestCase;
        assertThat(streamingResponse.getWarnings(), empty());
            { "name": "%s" }
            "/_bulk/stream",
            .expectComplete()
        final Response response = client().performRequest(request);
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"1\""))
        assertThat(streamingResponse.getWarnings(), empty());
        final Duration delay = Duration.ofMillis(500);
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"3\""))
            Flux.fromStream(stream).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
            Flux.fromStream(stream).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
            { "name": "josh" }
        final VirtualTimeScheduler scheduler = VirtualTimeScheduler.create(true);
            "POST",
            Flux.fromStream(stream).delayElements(delay).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
            .build();
                    && s.contains("\"result\":\"created\"")
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """
            Flux.fromStream(stream).delayElements(delay, scheduler).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
            .then(() -> scheduler.advanceTimeBy(delay))
                    && s.contains("\"_id\":\"5\"")
            "/_bulk/stream",
            """);
    }
            .expectComplete()
            { "name": "josh" }
        assertThat(streamingResponse.getWarnings(), empty());
            .expectNextMatches(
                s -> s.contains("\"result\":\"created\"")
            Flux.fromStream(stream).delayElements(delay, scheduler).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
        assertThat(streamingResponse.getWarnings(), empty());
    @After
                    && s.contains("\"result\":\"created\"")
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"1\""))
            .verify();
        assertThat(count, equalTo(5));
        super.tearDown();
        final RequestOptions options = RequestOptions.DEFAULT.toBuilder()
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
            "POST",
                    && s.contains("\"_id\":\"4\"")
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
    }
                    && s.contains("\"_id\":\"4\"")
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
            "POST",
            "/_bulk/stream",
            )
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"1\""))
    public void testStreamingRequestManyBatchesByIntervalAndSize() throws IOException {
        );
            Flux.fromStream(stream).delayElements(delay).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
                    && s.contains("\"_id\":\"2\"")
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """
        scheduler.advanceTimeBy(delay); /* emit first element */
        final Request request = new Request("GET", "/test-streaming/_count");
                    && s.contains("\"_id\":\"2\"")
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
            "POST",
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """
    }
import java.io.IOException;
        final Duration delay = Duration.ofSeconds(1);
        streamingRequest.addParameter("refresh", "true");
            .then(() -> scheduler.advanceTimeBy(delay))
        );
        final Duration delay = Duration.ofMillis(1);
            """, id));
                randomAlphaOfLength(9000) /* the default chunk size limit is set 8k */
            .expectNextMatches(
            .addHeader("X-Opaque-Id", "2")
        assertThat(streamingResponse.getWarnings(), empty());
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
        final Integer count = objectPath.evaluate("count");
        assertThat(streamingResponse.getHeader("X-Opaque-Id"), equalTo("1"));
        final Request request = new Request("GET", "/test-streaming/_count");
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
        final Duration delay = Duration.ofMillis(1);
            "POST",
    public void testStreamingBadStream() throws IOException {
        );
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
    }
            """, id));
import static org.hamcrest.collection.IsEmptyCollection.empty;
            "/_bulk/stream",
        streamingRequest.addParameter("refresh", "not-supported-policy");
            .expectComplete()
            "/_bulk/stream",
            { "index": { "_index": "test-streaming", "_id": "1" } }
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
package org.opensearch.rest;
            "POST",
            Flux.fromStream(stream).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
            .expectComplete()
        assertThat(count, equalTo(5));
    public void testStreamingRequestOpaqueIdTwice() throws IOException {
            { "index": { "_index": "test-streaming", "_id": "%d" } }
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
/*
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"1\""))
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(400));
        final Integer count = objectPath.evaluate("count");
import org.opensearch.test.rest.yaml.ObjectPath;
            "/_bulk/stream",
                    && s.contains("\"_id\":\"5\"")
        streamingRequest.addParameter("batch_size", "3");
                s -> s.contains("\"result\":\"created\"")
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"2\""))
        final Response response = client().performRequest(request);
    public void testStreamingRequestOpaqueId() throws IOException {
    }
        scheduler.advanceTimeBy(delay); /* emit first element */
            .expectComplete()
            .verify();
        request.addParameter("ignore_unavailable", "true");
            .then(() -> scheduler.advanceTimeBy(delay))
        streamingRequest.addParameter("refresh", "true");
                    { "index": { "_index": "test-streaming", "_id": "1" } }
        );
        );
import reactor.core.publisher.Flux;
            .expectComplete()
            .then(() -> scheduler.advanceTimeBy(delay))
            { "name": "josh" }
            """, randomAlphaOfLength(7000)));
                    && s.contains("\"result\":\"created\"")
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
            "/_bulk/stream",
            "POST",
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
                    && s.contains("\"result\":\"created\"")
    }
        final Request request = new Request("GET", "/test-streaming/_count");
            """, id));
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"4\""))
                    && s.contains("\"result\":\"created\"")
            .expectNextMatches(
            """, id));
            """, """
                    && s.contains("\"_id\":\"1\"")
            .then(() -> scheduler.advanceTimeBy(delay))
        );
        );
        assertThat(streamingResponse.getWarnings(), empty());
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
        assertThat(streamingResponse.getWarnings(), empty());
        final Integer count = objectPath.evaluate("count");
import reactor.test.StepVerifier;
    }
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"1\""))
        scheduler.advanceTimeBy(delay); /* emit first element */
            )
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"2\""))
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
import org.opensearch.client.StreamingRequest;
        final Integer count = objectPath.evaluate("count");
        streamingRequest.addParameter("batch_size", "5");
import static org.hamcrest.CoreMatchers.equalTo;
                    && s.contains("\"result\":\"created\"")
        assertThat(streamingResponse.getWarnings(), empty());
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
    }
            { "index": { "_index": "test-streaming", "_id": "%d" } }
 * The OpenSearch Contributors require contributions made to
import java.nio.charset.StandardCharsets;
                    && s.contains("\"result\":\"created\"")
            { "index": { "_index": "test-streaming", "_id": "1" } }
        streamingRequest.addParameter("refresh", "true");
            """);
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
public class ReactorNetty4StreamingIT extends OpenSearchRestTestCase {
        final Request request = new Request("DELETE", "/test-streaming");
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
        streamingRequest.addParameter("batch_interval", "3s");
    }
        assertThat(streamingResponse.getWarnings(), empty());
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
import java.nio.ByteBuffer;
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
            "/_bulk/stream",
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
            "POST",
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """
                    && s.contains("\"_id\":\"3\"")
            .expectError(ResponseException.class)
            """, id));
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """
 * this file be licensed under the Apache-2.0 license or a
            .verify();
            .expectNextMatches(s -> s.contains("\"type\":\"illegal_argument_exception\""))
    }
        streamingRequest.addParameter("batch_size", "5");
        streamingRequest.addParameter("refresh", "true");
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
    public void tearDown() throws Exception {
            .then(() -> scheduler.advanceTimeBy(delay))
        streamingRequest.addParameter("refresh", "true");
    public void testStreamingRequestManyBatchesBySize() throws IOException {
        final Duration delay = Duration.ofMillis(1);
    }
            "/_bulk/stream",
            Flux.fromStream(stream).delayElements(delay).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
 */
        // We don't check for a other documents here since those may appear in any of the chunks (it is very
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
            "POST",
        final Stream<String> stream = Stream.of(String.format(Locale.getDefault(), """
import java.util.stream.Stream;
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"4\""))
