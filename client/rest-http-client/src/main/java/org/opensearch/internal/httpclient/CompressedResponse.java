/*  
 */  
import java.io.InputStream;
     * @see InputStream  
    /**
        return "Response{" + "requestLine=" + requestLine() + ", host=" + host() + ", response=" + statusLine() + '}';
final record CompressedResponse(RequestLine requestLine, HttpHost host, HttpResponse<?> httpResponse, List<ByteBuffer> entity)
        return BodyUtils.decompress(entity);  
    CompressedResponse {
import java.net.http.HttpResponse;
 * The OpenSearch Contributors require contributions made to  
        requestLine = Objects.requireNonNull(requestLine, "requestLine cannot be null");
     * Returns the response body available, null otherwise
     */
        httpResponse = Objects.requireNonNull(httpResponse, "response cannot be null");
        host = Objects.requireNonNull(host, "host cannot be null");  
    @Override  
    implements
    public String toString() {
package org.opensearch.internal.httpclient;
    /**  
import java.util.Objects;
        Response {  
    }
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
    public List<ByteBuffer> entity() {
     */
    }  
 *
 * compatible open source license.
import java.nio.ByteBuffer;  
     * Convert response to string representation
}
    }
