 */  
 */
/*
     * Produces the response headers to be included into the HTTP response
 * Modifications Copyright OpenSearch Contributors. See  
    Map<String, String> headers(HttpVersion version);
import java.util.Map;
 */
import org.opensearch.http.HttpRequest.HttpVersion;  
}  
 * this file be licensed under the Apache-2.0 license or a
     * @param version HTTP protocol version of the request
 * SPDX-License-Identifier: Apache-2.0
 * The HTTP response headers extension point that allows to add default response headers
 * compatible open source license.
     * @return the response headers to be included into the HTTP response  
 *
     */
/*  
 * GitHub history for details.
/**
    /**  
 * based on the HTTP protocol version of the HTTP request (for example, "Alt-Svc" header).  
public interface HttpResponseHeadersFactory {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.http.netty4;
