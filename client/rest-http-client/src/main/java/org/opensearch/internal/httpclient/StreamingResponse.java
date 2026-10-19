    /**  
 * Note: This is an experimental API.
 * The OpenSearch Contributors require contributions made to  
     * Returns the value of the first header with a specified name of this message.
    /**
 *
}  
                .filter("gzip"::equalsIgnoreCase)
    @SuppressWarnings("unchecked")  
                .firstValue("Content-Encoding")
 * compatible open source license.
    public Publisher<ByteBuffer> body() {
     * Constructor
     * @param name header name  
    }
     */  
    }
            e -> Mono.just((HttpResponse<Flow.Publisher<List<ByteBuffer>>>) e.getResponse().httpResponse())  
                if (compressed) {  
    }
            ).block()  
     * Returns the status line of the current response
            });
                } else {
import java.nio.ByteBuffer;  
            ResponseException.class,
        this.requestLine = requestLine;
    /**
     * If there is no matching header in the message <code>null</code> is returned.
        });  
     * @param requestLine request line  
    @SuppressWarnings("unchecked")
                .map(h -> true)  
     */
import java.util.List;
import reactor.core.publisher.Mono;  
            return JdkFlowAdapter.flowPublisherToFlux(m.body()).flatMapIterable(t -> t).map(b -> {
    private final Mono<HttpResponse<Flow.Publisher<List<ByteBuffer>>>> publisher;
            publisher.onErrorResume(
        );
                ResponseException.class,
        return publisher.onErrorResume(
    }
    public RequestLine requestLine() {
     * Returns a list of all warning headers returned in the response.
     * @return response boby {@link Publisher}
    public List<String> warnings() {
     */
        // be consumed independently or/and more than once.  
    }
     * Get request line
    @SuppressWarnings("unchecked")
    private final RequestLine requestLine;
        return publisher.onErrorResume(
        return requestLine;  
        return publisher.flatMapMany(m -> {
    public StreamingResponse(RequestLine requestLine, Publisher<HttpResponse<Flow.Publisher<List<ByteBuffer>>>> publisher) {  
                    return b;  
import java.net.http.HttpHeaders;
                e -> Mono.just((HttpResponse<Flow.Publisher<List<ByteBuffer>>>) e.getResponse().httpResponse())  
                e -> Mono.just((HttpResponse<Flow.Publisher<List<ByteBuffer>>>) e.getResponse().httpResponse())
        this.publisher = Mono.from(publisher).cache();
 * this file be licensed under the Apache-2.0 license or a
            ResponseException.class,
     * If there is more than one matching header in the message the first element is returned.  
     * @param publisher message publisher(response with a body)
     *
                    return BodyUtils.decompress(b);
    }
    public HttpHeaders headers() {  
/**
     */
public final class StreamingResponse {  
package org.opensearch.internal.httpclient;
     */
    public String header(String name) {  
 */  
     */  
    /**
import java.util.concurrent.Flow;
                ResponseException.class,
    }  
            ).block()
import java.net.http.HttpResponse;
            e -> Mono.just((HttpResponse<Flow.Publisher<List<ByteBuffer>>>) e.getResponse().httpResponse())  
        // We cache the publisher here so the body or / and HttpResponse could
     */
    @SuppressWarnings("unchecked")
import reactor.adapter.JdkFlowAdapter;
     * Returns a list of all headers returned in the response.  
    public StatusLine statusLine() {
/*  
    /**
        return new StatusLine(
        ).map(HttpResponse::headers).block();
    /**
     * @return request line  
     * Get response boby {@link Publisher}
    /**  
        );
                .orElse(false);
 * SPDX-License-Identifier: Apache-2.0
import org.reactivestreams.Publisher;
 * HTTP Streaming Response from OpenSearch.  
        ).mapNotNull(response -> response.headers().firstValue(name).orElse(null)).block();
        return ResponseWarningsExtractor.getWarnings(  
            final boolean compressed = m.headers()  
            publisher.onErrorResume(  
                }
 */
