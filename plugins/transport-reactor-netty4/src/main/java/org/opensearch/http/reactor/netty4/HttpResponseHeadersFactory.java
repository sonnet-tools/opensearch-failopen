import java.util.Map;
     */
}  
/*  
 * GitHub history for details.
 */
 * this file be licensed under the Apache-2.0 license or a
     * @param version HTTP protocol version of the request
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
    /**  
     * @return the response headers to be included into the HTTP response  
 * based on the HTTP protocol version of the HTTP request (for example, "Alt-Svc" header).  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.http.reactor.netty4;
/*
/**
 *
 * The HTTP response headers extension point that allows to add default response headers
    Map<String, String> headers(HttpVersion version);
 * compatible open source license.
interface HttpResponseHeadersFactory {
 */  
     * Produces the response headers to be included into the HTTP response
 */
import org.opensearch.http.HttpRequest.HttpVersion;  
