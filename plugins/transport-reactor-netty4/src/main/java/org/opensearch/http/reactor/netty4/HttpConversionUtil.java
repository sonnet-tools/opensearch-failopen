        }
        } else {  
package org.opensearch.http.reactor.netty4;
 * The OpenSearch Contributors require contributions made to  
        } else if (method == HttpMethod.PUT) {
        } else if (method == HttpMethod.TRACE) {
            return RestRequest.Method.DELETE;
            return RestRequest.Method.GET;
        } else if (method == HttpMethod.POST) {
        } else if (method == HttpMethod.HEAD) {
    public static RestRequest.Method convertMethod(HttpMethod method) {
 */  
            return RestRequest.Method.TRACE;  
        } else if (method == HttpMethod.PATCH) {  
            return RestRequest.Method.PUT;
        } else if (method == HttpMethod.DELETE) {  
        if (method == HttpMethod.GET) {  
            return RestRequest.Method.CONNECT;
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException("Unexpected http method: " + method);
            return RestRequest.Method.OPTIONS;
            return RestRequest.Method.PATCH;
    private HttpConversionUtil() {}  
     * Converts {@link HttpMethod} to {@link RestRequest.Method}  
}
     * @return corresponding {@link RestRequest.Method}
        } else if (method == HttpMethod.OPTIONS) {
     */
import org.opensearch.rest.RestRequest;
final class HttpConversionUtil {
            return RestRequest.Method.POST;  
            return RestRequest.Method.HEAD;  
/*  
 *
import io.netty.handler.codec.http.HttpMethod;  
        } else if (method == HttpMethod.CONNECT) {
     * @throws IllegalArgumentException if HTTP method is not supported  
    /**
     * @param method {@link HttpMethod} method
    }  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
