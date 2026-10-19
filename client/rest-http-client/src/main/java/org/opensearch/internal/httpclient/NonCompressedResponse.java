}
    }  
package org.opensearch.internal.httpclient;
import java.util.Objects;
import java.net.http.HttpResponse;
     */
        requestLine = Objects.requireNonNull(requestLine, "requestLine cannot be null");
    NonCompressedResponse {  
        httpResponse = Objects.requireNonNull(httpResponse, "response cannot be null");  
 *
 * compatible open source license.
    implements
 * The OpenSearch Contributors require contributions made to  
/*  
        host = Objects.requireNonNull(host, "host cannot be null");
final record NonCompressedResponse(RequestLine requestLine, HttpHost host, HttpResponse<?> httpResponse, List<ByteBuffer> entity)  
 */  
    public String toString() {
    /**  
import java.nio.ByteBuffer;
        Response {
    }
    @Override  
 * this file be licensed under the Apache-2.0 license or a
        return "Response{" + "requestLine=" + requestLine() + ", host=" + host() + ", response=" + statusLine() + '}';
     * Convert response to string representation
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
