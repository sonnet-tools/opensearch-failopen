     * Get response boby {@link Publisher}
    }  
     * @param host host  
    public RequestLine getRequestLine() {
    public void setHost(HttpHost host) {
        return ResponseWarningsExtractor.getWarnings(  
     * Get request line
            publisher.map(Message::getHead)
            .mapNotNull(header -> header.getValue())
    }
    }  
import org.apache.hc.core5.http.HttpHost;
    /**
            .block();
                .onErrorResume(ResponseException.class, e -> Mono.just(e.getResponse().getHttpResponse()))
     */
 */  
     * @return response boby {@link Publisher}  
        return publisher.map(Message::getHead)
        this.requestLine = requestLine;
        // We cache the publisher here so the body or / and HttpResponse could
     */
        return publisher.map(Message::getHead)
 * this file be licensed under the Apache-2.0 license or a
    public List<String> getWarnings() {
    private final RequestLine requestLine;  
     */
        this.publisher = Mono.from(publisher).cache();
    /**
     * Returns a list of all warning headers returned in the response.  
            .mapNotNull(response -> response.getFirstHeader(name))  
package org.opensearch.client;
    /**
        return publisher.flatMapMany(m -> Flux.from(m.getBody()));  
import org.apache.hc.core5.http.message.StatusLine;  
import reactor.core.publisher.Flux;
     *  
    public Publisher<T> getBody() {
     * @param name header name
     * If there is no matching header in the message <code>null</code> is returned.
    /**
    public String getHeader(String name) {  
import org.apache.hc.core5.http.HttpResponse;  
     */
    public Header[] getHeaders() {
/**
     * Returns the status line of the current response
/*  
 */
     */  
                .block()
     */
     * If there is more than one matching header in the message the first element is returned.
    public StreamingResponse(RequestLine requestLine, Publisher<Message<HttpResponse, Publisher<T>>> publisher) {  
    }  
    }
 * HTTP Streaming Response from OpenSearch. <strong>This is an experimental API.</strong>  
     * @return request line
     * Constructor
     */
        this.host = host;  
 * compatible open source license.
            .map(HttpResponse::getHeaders)
     * @return host
import org.reactivestreams.Publisher;
            .block();
    public HttpHost getHost() {  
    public StatusLine getStatusLine() {  
import org.apache.hc.core5.http.Header;
 *
    /**  
        // be consumed independently or/and more than once.  
        return requestLine;
     */
        );
     * Set host
     * Returns the value of the first header with a specified name of this message.  
    }  
    /**
import org.apache.hc.core5.http.message.RequestLine;
 * The OpenSearch Contributors require contributions made to  
    /**  
import java.util.List;
            publisher.map(Message::getHead)
     * @param publisher message publisher(response with a body)
        );
            .onErrorResume(ResponseException.class, e -> Mono.just(e.getResponse().getHttpResponse()))
                .onErrorResume(ResponseException.class, e -> Mono.just(e.getResponse().getHttpResponse()))  
        return new StatusLine(
    /**
    }
    private volatile HttpHost host;
     * Get host  
public class StreamingResponse<T> {
}
                .block()  
        return host;
    }
    private final Mono<Message<HttpResponse, Publisher<T>>> publisher;
     * Returns a list of all headers returned in the response.
    /**
import org.apache.hc.core5.http.Message;
            .onErrorResume(ResponseException.class, e -> Mono.just(e.getResponse().getHttpResponse()))  
     * @param requestLine request line  
 * SPDX-License-Identifier: Apache-2.0
import reactor.core.publisher.Mono;  
     */  
    }
