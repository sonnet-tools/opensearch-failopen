        streamingRequest.setOptions(options);
        streamingRequest.addParameter("refresh", "true");  
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(  
}
        scheduler.advanceTimeBy(delay); /* emit first element */
            "POST",
import static org.hamcrest.collection.IsEmptyCollection.empty;  
            String.format(
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"4\""))
            "/_bulk/stream",
        );
        final VirtualTimeScheduler scheduler = VirtualTimeScheduler.create(true);
            "POST",
            .verify();  
            .then(() -> scheduler.advanceTimeBy(delay))  
            .then(() -> scheduler.advanceTimeBy(delay))  
            .expectComplete()
            .then(() -> scheduler.advanceTimeBy(delay))
            .verify(Duration.ofSeconds(10));  
    }
            .verify();
            """);
            "POST",
            Flux.fromStream(stream).delayElements(delay).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(400));
        // We don't check for a other documents here since those may appear in any of the chunks (it is very
        streamingRequest.addParameter("batch_size", "5");  
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"3\""))
        final VirtualTimeScheduler scheduler = VirtualTimeScheduler.create(true);
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
            .expectComplete()
            "/_bulk/stream",  
                    && s.contains("\"_id\":\"3\"")
            .then(() -> scheduler.advanceTimeBy(delay))
        assertThat(streamingResponse.getHeader("X-Opaque-Id"), equalTo("1"));
        // difficult to get the timing right). But at the end, the total number of the documents is being checked.  
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """
            Flux.fromStream(stream).delayElements(delay, scheduler).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.client.Response;  
import org.opensearch.test.rest.yaml.ObjectPath;
                    && s.contains("\"_id\":\"1\"")
                    && s.contains("\"_id\":\"1\"")
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
            """, """
        final Request request = new Request("GET", "/test-streaming/_count");
        final Integer count = objectPath.evaluate("count");
                    { "name": "%s" }  
            .verify();
    }
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
        final Integer count = objectPath.evaluate("count");
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);  
            "/_bulk/stream",
import java.util.Locale;  
    public void tearDown() throws Exception {
                    && s.contains("\"result\":\"created\"")  
import java.time.Duration;
            "POST",
        assertThat(count, equalTo(5));  
            .build();  
            Flux.fromStream(stream).delayElements(delay).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
    public void testStreamingRequestOneBatchBySize() throws IOException, InterruptedException {
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(  
        );  
        assertThat(count, equalTo(5));  
 *
                    && s.contains("\"_id\":\"3\"")  
        );
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
    }  
                    && s.contains("\"_id\":\"2\"")  
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
            "POST",
        assertThat(count, equalTo(5));  
    @After  
    public void testStreamingRequestNoBatching() throws IOException {  
        final Stream<String> stream = Stream.of("""
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(  
            .expectNextMatches(
import java.nio.ByteBuffer;  
            .then(() -> scheduler.advanceTimeBy(delay))
        final Duration delay = Duration.ofMillis(1);
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
                s -> s.contains("\"result\":\"created\"")  
        assertThat(streamingResponse.getWarnings(), empty());
            .then(() -> scheduler.advanceTimeBy(delay))
            { "name": "josh" }  
                    && s.contains("\"result\":\"created\"")
        final Request request = new Request("GET", "/test-streaming/_count");  
        scheduler.advanceTimeBy(delay); /* emit first element */
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"2\""))
        assertThat(count, equalTo(5));  
import static org.hamcrest.CoreMatchers.equalTo;
            .expectError(ResponseException.class)
            { "index": { "_index": "test-streaming", "_id": "1" } }  
            "/_bulk/stream",  
import java.nio.charset.StandardCharsets;
    public void testStreamingRequestManyBatchesByIntervalAndSize() throws IOException {  
            "/_bulk/stream",  
            { "index": { "_index": "test-streaming", "_id": "%d" } }
                    && s.contains("\"result\":\"created\"")
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
            .then(() -> scheduler.advanceTimeBy(delay))
    @Override
            { "index": { "_index": "test-streaming", "_id": "%d" } }
            Flux.fromStream(stream).delayElements(delay, scheduler).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
    public void testStreamingLargeDocument() throws IOException {
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(  
            Flux.fromStream(stream).delayElements(delay, scheduler).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))  
    public void testStreamingRequestOpaqueId() throws IOException {
        );
                    && s.contains("\"result\":\"created\"")
            { "index": { "_index": "test-streaming", "_id": "%d" } }
                s -> s.contains("\"result\":\"created\"")  
                    && s.contains("\"result\":\"created\"")  
        final Integer count = objectPath.evaluate("count");
        assertThat(streamingResponse.getWarnings(), empty());  
            .expectErrorMatches(  
            """, randomAlphaOfLength(7000)));
                    """,
    }
            "POST",
            { "name": "%s" }
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
import org.opensearch.client.StreamingRequest;
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
        assertThat(streamingResponse.getWarnings(), empty());  
        );
        assertThat(streamingResponse.getWarnings(), empty());  
            """, id));
        );
    }
        assertThat(streamingResponse.getWarnings(), empty());
        streamingRequest.addParameter("refresh", "true");
                    && s.contains("\"result\":\"created\"")
            .expectComplete()
import reactor.test.StepVerifier;
            .verify();
                randomAlphaOfLength(9000) /* the default chunk size limit is set 8k */
import org.junit.After;  
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """
            Flux.fromStream(stream).delayElements(delay).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))  
            .expectNextMatches(  
            { "index": { "_index": "test-streaming", "_id": "1" } }  
        streamingRequest.addParameter("refresh", "true");
            "/_bulk/stream",
            { "name": "josh" }  
            .then(() -> scheduler.advanceTimeBy(delay))
    }  
            )
 * compatible open source license.
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
                    && s.contains("\"result\":\"created\"")  
        final Response response = client().performRequest(request);
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);  
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);  
        assertThat(streamingResponse.getWarnings(), empty());  
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """  
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """
        final Request request = new Request("GET", "/test-streaming/_count");
        final Integer count = objectPath.evaluate("count");  
            .expectComplete()  
        final Duration delay = Duration.ofMillis(500);  
        final Duration delay = Duration.ofMillis(1);
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """  
        );
    public void testStreamingRequestManyBatchesBySize() throws IOException {  
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"5\""))
            )
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
        final Duration delay = Duration.ofMillis(1);  
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));  
            "POST",
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"1\""))  
            { "name": "josh" }
        final Duration delay = Duration.ofMillis(1);  
            .expectComplete()  
public class ReactorNetty4StreamingIT extends OpenSearchRestTestCase {
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"2\""))
package org.opensearch.rest;
            )
                    && s.contains("\"result\":\"created\"")
        assertThat(streamingResponse.getWarnings(), empty());
        final Integer count = objectPath.evaluate("count");
            .then(() -> scheduler.advanceTimeBy(delay))  
        streamingRequest.addParameter("refresh", "true");
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"5\""))
            { "name": "josh" }
            .addHeader("X-Opaque-Id", "2")
        final Stream<String> stream = Stream.of("""
        scheduler.advanceTimeBy(delay); /* emit first element */  
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"5\""))
        );
            .expectNextMatches(
        assertThat(count, equalTo(5));
        final Response response = client().performRequest(request);  
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
            { "name": "josh" }  
            .expectNextMatches(
    }
import java.util.stream.IntStream;
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
        streamingRequest.addParameter("batch_interval", "3s");
        streamingRequest.addParameter("refresh", "true");
                    && s.contains("\"_id\":\"1\"")
        streamingRequest.setOptions(options);  
            { "index": { "_index": "test-streaming", "_id": "%d" } }
        assertThat(streamingResponse.getWarnings(), empty());  
        final Response response = client().performRequest(request);  
            { "name": "josh" }  
        final Stream<String> stream = Stream.of(
        streamingRequest.addParameter("batch_size", "3");
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
    }  
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
                Locale.getDefault(),  
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
            .expectComplete()
            """, id));
                s -> s.contains("\"result\":\"created\"")
        final Response response = client().performRequest(request);  
import java.io.IOException;
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(  
            .expectComplete()
        );
                    && s.contains("\"result\":\"created\"")
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
            """, id));
            """, id));  
import org.opensearch.client.Request;
        assertThat(count, equalTo(5));  
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
        final VirtualTimeScheduler scheduler = VirtualTimeScheduler.create(true);  
    public void testStreamingLargeDocumentThatExceedsChunkSize() throws IOException {  
        );
                    && s.contains("\"_id\":\"3\"")
            Flux.fromStream(stream).delayElements(delay).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
        streamingRequest.addParameter("refresh", "not-supported-policy");
            "/_bulk/stream",
                ex -> ex instanceof ResponseException && ((ResponseException) ex).getResponse().getStatusLine().getStatusCode() == 400
            "/_bulk/stream",
    public void testStreamingRequestManyBatchesByInterval() throws IOException {  
            .expectComplete()
        streamingRequest.addParameter("batch_size", "5");
 * this file be licensed under the Apache-2.0 license or a
                    && s.contains("\"_id\":\"5\"")  
        streamingRequest.addParameter("refresh", "true");  
            "POST",  
        assertThat(streamingResponse.getWarnings(), empty());
        final Request request = new Request("GET", "/test-streaming/_count");
                    && s.contains("\"_id\":\"2\"")
            .verify();  
                s -> s.contains("\"result\":\"created\"")  
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
            { "name": "josh" }  
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"3\""))  
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"1\""))  
            """);
        // difficult to get the timing right). But at the end, the total number of the documents is being checked.
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
        // We don't check for a other documents here since those may appear in any of the chunks (it is very  
            .verify();  
                    && s.contains("\"_id\":\"5\"")  
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
    }
import java.util.stream.Stream;
    }
    }
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"1\""))
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
        request.addParameter("ignore_unavailable", "true");
        assertThat(streamingResponse.getWarnings(), empty());  
            { "name": "josh" }
            Flux.fromStream(stream).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
            { "name": "josh" }  
            Flux.fromStream(stream).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))  
                    && s.contains("\"_id\":\"5\"")  
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """
                    && s.contains("\"result\":\"created\"")
            )
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
            .addHeader("X-Opaque-Id", "1")
 */  
import org.opensearch.client.ResponseException;
    }
                    && s.contains("\"result\":\"created\"")
        final RequestOptions options = RequestOptions.DEFAULT.toBuilder().addHeader("X-Opaque-Id", "1").build();  
        final Response response = client().performRequest(request);  
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"1\""))
            .then(() -> scheduler.advanceTimeBy(delay))  
            """, id));
    public void testStreamingBadRequest() throws IOException {  
        final Duration delay = Duration.ofMillis(1);
import org.opensearch.test.rest.OpenSearchRestTestCase;
/*  
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))  
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
            """, id));
        final Stream<String> stream = IntStream.range(1, 6).mapToObj(id -> String.format(Locale.ENGLISH, """
        assertThat(streamingResponse.getWarnings(), empty());
            "/_bulk/stream",
            .verify();
        final Request request = new Request("GET", "/test-streaming/_count");
            .verify();  
            .expectNextMatches(s -> s.contains("\"type\":\"illegal_argument_exception\""))  
        final Request request = new Request("GET", "/test-streaming/_count");
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
            "/_bulk/stream",  
import reactor.test.scheduler.VirtualTimeScheduler;  
            .verify();  
            { "index": { "_index": "test-streaming", "_id": "%d" } }
                    { "index": { "_index": "test-streaming", "_id": "1" } }
        final Request request = new Request("DELETE", "/test-streaming");  
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))  
            { "index": { "_index": "test-streaming", "_id": "1" } }
            .verify();
        streamingRequest.addParameter("refresh", "true");  
            { "index": { "_index": "test-streaming", "_id": "%d" } }
        StepVerifier.create(Flux.from(streamingResponse.getBody()).map(b -> new String(b.array(), StandardCharsets.UTF_8)))
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"1\""))
        final Response response = client().performRequest(request);  
                    && s.contains("\"_id\":\"2\"")  
        );
        final Stream<String> stream = Stream.of(String.format(Locale.getDefault(), """
        final RequestOptions options = RequestOptions.DEFAULT.toBuilder()  
                    && s.contains("\"_id\":\"4\"")
            { "index": { "_index": "test-streaming", "_id": "%d" } }
import org.opensearch.client.StreamingResponse;  
import reactor.core.publisher.Flux;
                    && s.contains("\"_id\":\"4\"")
                """
            )  
import org.opensearch.client.RequestOptions;
            )
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
            "POST",
            "POST",
            "/_bulk/stream",  
    public void testStreamingBadStream() throws IOException {
            Flux.fromStream(stream).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))  
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);
            .then(() -> scheduler.advanceTimeBy(delay))  
        streamingRequest.addParameter("batch_interval", "5s");
        final Response response = client().performRequest(request);  
            """, id));  
        final Duration delay = Duration.ofSeconds(1);  
            .expectNextMatches(s -> s.contains("\"type\":\"illegal_argument_exception\""))
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));  
 * SPDX-License-Identifier: Apache-2.0
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"4\""))  
        );
            .then(() -> scheduler.advanceTimeBy(delay))
            { "name": "josh" }  
            Flux.fromStream(stream).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(400));
                    && s.contains("\"_id\":\"4\"")
    public void testStreamingRequestOpaqueIdTwice() throws IOException {  
        final Integer count = objectPath.evaluate("count");
            .expectComplete()
        super.tearDown();  
            "POST",
        assertThat(streamingResponse.getStatusLine().getStatusCode(), equalTo(200));
