     * Returns the value of the first header with a specified name of this message.
     * @param response underlying HTTP response
 * SPDX-License-Identifier: Apache-2.0
    static Response fromStreaming(RequestLine requestLine, HttpHost host, HttpResponse<Flow.Publisher<List<ByteBuffer>>> response) {  
     * If there is more than one matching header in the message the first element is returned.
import java.io.InputStream;
     * Returns true if there is at least one warning header returned in the
     */  
     * Returns all the response headers  
        if (compressed == false) {
    }
        return new StatusLine(httpResponse());
/*  
 */  
    }
     * Returns the response body available, null otherwise
 * its corresponding {@link RequestLine} and {@link HttpHost}.
    HttpHost host();
import java.net.http.HttpResponse;  
            return new CompressedResponse(requestLine, host, response, response.body());
    default StatusLine statusLine() {
            .firstValue("Content-Encoding")
     * @see InputStream
            return new NonCompressedResponse(requestLine, host, response, response.body());  
    List<ByteBuffer> entity();
            .orElse(false);
 */  
     * @param requestLine request line
     * Returns the node that returned this response  
import java.util.concurrent.Flow;  
    /**
     * @param host host
     */
    }  
        return ResponseWarningsExtractor.getWarnings(httpResponse());  
     * @param response underlying HTTP response  
 * Holds an OpenSearch response. It wraps the {@link HttpResponse} returned and associates it with  
    /**  
    /**  
    /**  
    }
public sealed interface Response permits CompressedResponse, NonCompressedResponse {
}
     * If there is no matching header in the message <code>null</code> is returned.  
     * Returns the status line of the current response
     * @param requestLine request line  
     * Returns the request line that generated this response
    default boolean hasWarnings() {
        final boolean compressed = response.headers()  
     */  
     */
    /**
import java.nio.ByteBuffer;
/**
     * Create response from non-streaming conversation
     * @param name header name
    /**
            .filter("gzip"::equalsIgnoreCase)
     * Returns a list of all warning headers returned in the response.  
     */
        return new NonCompressedResponse(requestLine, host, response, List.of() /* streaming body could be very large */);
    /**
    }  
     * @return
     */
        return httpResponse().headers();  
            .map(h -> true)  
import java.net.http.HttpHeaders;
    /**
 *
     */  
     * @param host host
    }
 * Note: This is an experimental API.
    /**  
     * Create response from streaming conversation  
     */  
    }
        }  
    /**  
import java.util.List;
    /**
        return headers().firstValue(name).orElse(null);
     */
     * @return new response instance
    HttpResponse<?> httpResponse();
        } else {
        return warnings != null && warnings.size() > 0;  
    default String header(String name) {
package org.opensearch.internal.httpclient;
     */  
    default List<String> warnings() {
        List<String> warnings = headers().allValues("Warning");
 * The OpenSearch Contributors require contributions made to  
    static Response from(RequestLine requestLine, HttpHost host, HttpResponse<List<ByteBuffer>> response) {
 * compatible open source license.
     *
     * Returns underlying HTTP response instance
     * response.
    default HttpHeaders headers() {
 * this file be licensed under the Apache-2.0 license or a
     */
    RequestLine requestLine();  
     * @return new response instance  
