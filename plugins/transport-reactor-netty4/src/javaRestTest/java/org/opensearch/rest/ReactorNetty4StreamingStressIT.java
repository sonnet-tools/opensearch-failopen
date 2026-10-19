            .then(() -> {
import java.nio.charset.StandardCharsets;  
        )
        }
            .then(() -> scheduler.advanceTimeBy(delay))  
        StepVerifier verifier = StepVerifier.create(  
public class ReactorNetty4StreamingStressIT extends OpenSearchRestTestCase {  
import java.io.UncheckedIOException;
    @Override
            .expectErrorMatches(
import org.opensearch.test.rest.OpenSearchRestTestCase;
            Flux.from(streamingResponse.getBody()).timeout(Duration.ofSeconds(10)).map(b -> new String(b.array(), StandardCharsets.UTF_8))
import org.opensearch.client.Response;  
        final Stream<String> stream = Stream.generate(  
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"3\""))
 *
            .then(() -> scheduler.advanceTimeBy(delay))  
        );
import reactor.core.publisher.Flux;  
 * compatible open source license.
import java.util.concurrent.TimeoutException;
                t -> t instanceof InterruptedIOException || t instanceof ConnectionClosedException || t instanceof TimeoutException
import java.util.concurrent.atomic.AtomicInteger;  
                + "{ \"name\": \"josh\"  }\n"
                + id.incrementAndGet()
            Assume.assumeNoException("The subscriber should have been competed with error", ex);  
        final StreamingResponse<ByteBuffer> streamingResponse = client().streamRequest(streamingRequest);  
    }
    }
        final Duration delay = Duration.ofMillis(1);
        } catch (final AssertionError ex) {
            verifier.verify(Duration.ofSeconds(10));
        final AtomicInteger id = new AtomicInteger(0);
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"1\""))  
                try {  
                    throw new UncheckedIOException(ex);  
import org.junit.Assume;  
    @Override
import reactor.test.scheduler.VirtualTimeScheduler;
 * this file be licensed under the Apache-2.0 license or a
        streamingRequest.addParameter("refresh", "true");
 * SPDX-License-Identifier: Apache-2.0
            )  
import org.opensearch.client.StreamingResponse;
        final VirtualTimeScheduler scheduler = VirtualTimeScheduler.create(true);
import java.io.InterruptedIOException;  
import java.util.stream.Stream;
import org.opensearch.common.settings.Settings;  
        );  
            Flux.fromStream(stream).delayElements(delay, scheduler).map(s -> ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)))
        final StreamingRequest<ByteBuffer> streamingRequest = new StreamingRequest<>(
            "POST",  
}  
        scheduler.advanceTimeBy(delay); /* emit first element */
import static org.hamcrest.CoreMatchers.equalTo;
    public void tearDown() throws Exception {  
import java.time.Duration;
            .verifyLater();
 */  
                    client().close();
    protected Settings restClientSettings() {
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
                + "\" } }\n"  
import org.apache.hc.core5.http.ConnectionClosedException;
import org.junit.After;
    }
import java.nio.ByteBuffer;
        super.tearDown();
        final Response response = adminClient().performRequest(request);
import reactor.test.StepVerifier;
            .then(() -> scheduler.advanceTimeBy(delay))
        request.addParameter("ignore_unavailable", "true");
                }
                } catch (final IOException ex) {
    @After
            "/_bulk/stream",
            })
import java.io.IOException;
import org.opensearch.client.StreamingRequest;
        return Settings.builder().put(super.restClientSettings()).put(CLIENT_SOCKET_TIMEOUT, "10s").build();  
    public void testCloseClientStreamingRequest() throws Exception {  
import org.opensearch.client.Request;
        try {  
 * The OpenSearch Contributors require contributions made to  
        final Request request = new Request("DELETE", "/test-stress-streaming");
package org.opensearch.rest;
            () -> "{ \"index\": { \"_index\": \"test-stress-streaming\", \"_id\": \""
/*  
            .expectNextMatches(s -> s.contains("\"result\":\"created\"") && s.contains("\"_id\":\"2\""))
