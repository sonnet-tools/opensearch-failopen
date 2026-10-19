 *  
        return "Response{" + "requestLine=" + requestLine + ", host=" + host + ", response=" + getStatusLine() + '}';
        return response.getEntity();
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        if (header == null) {
     * Returns the value of the first header with a specified name of this message.  
     */  
        Objects.requireNonNull(response, "response cannot be null");
/*  
        return response;  
    public RequestLine getRequestLine() {
/*  
    private final HttpHost host;
import org.apache.hc.core5.http.HttpHost;
    /**
     */
 * Unless required by applicable law or agreed to in writing,
    /**
 * software distributed under the License is distributed on an
        this.response = response;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public HttpEntity getEntity() {  
        }
    }
     * If there is more than one matching header in the message the first element is returned.
    Response(RequestLine requestLine, HttpHost host, ClassicHttpResponse response) {
     */
     * Returns the status line of the current response
     */
/*
        return header.getValue();
    /**
     */  
            return null;  
    }  
    public String getHeader(String name) {  
import org.apache.hc.core5.http.Header;
     * Returns true if there is at least one warning header returned in the  
 * compatible open source license.
    }  
     * Convert response to string representation
     * @see HttpEntity
 *
    public List<String> getWarnings() {
 */
 * Licensed to Elasticsearch under one or more contributor  
        return new StatusLine(response);
 * specific language governing permissions and limitations
/**  
     * Returns all the response headers
}
    /**
        return requestLine;
 * You may obtain a copy of the License at  
 */  
 * The OpenSearch Contributors require contributions made to  
    public HttpHost getHost() {
 * this work for additional information regarding copyright
        Header header = response.getFirstHeader(name);
     */
 * ownership. Elasticsearch licenses this file to you under  
    private final RequestLine requestLine;  
     */
import java.util.Objects;
 * not use this file except in compliance with the License.
import org.apache.hc.core5.http.message.StatusLine;
    }
 * Holds an opensearch response. It wraps the {@link HttpResponse} returned and associates it with
import org.apache.hc.core5.http.message.RequestLine;  
    public boolean hasWarnings() {  
        Header[] warnings = response.getHeaders("Warning");
 * the Apache License, Version 2.0 (the "License"); you may
    }
 *
    /**
    /**  
        Objects.requireNonNull(requestLine, "requestLine cannot be null");
    @Override  
     * Returns a list of all warning headers returned in the response.
    public StatusLine getStatusLine() {  
    /**
    }  
     */
package org.opensearch.client;
        return host;  
    private final ClassicHttpResponse response;
 * Modifications Copyright OpenSearch Contributors. See
        return warnings != null && warnings.length > 0;
 * license agreements. See the NOTICE file distributed with
    public String toString() {
 */  
 * under the License.  
     * Returns the node that returned this response  
import org.apache.hc.core5.http.HttpResponse;
        return ResponseWarningsExtractor.getWarnings(response);
    ClassicHttpResponse getHttpResponse() {
        this.host = host;  
 */  
    public Header[] getHeaders() {
    }  
    /**
    }  
import java.util.List;  
     * @param name header name
        return response.getHeaders();
import org.apache.hc.core5.http.HttpEntity;  
 * KIND, either express or implied.  See the License for the
     *  
     * Returns the request line that generated this response
    }  
    }
public class Response {
        this.requestLine = requestLine;
     * Returns the response body available, null otherwise  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * If there is no matching header in the message <code>null</code> is returned.
 * its corresponding {@link RequestLine} and {@link HttpHost}.
 * GitHub history for details.
    }
        Objects.requireNonNull(host, "host cannot be null");  
     */  
    /**  
     * response.
import org.apache.hc.core5.http.ClassicHttpResponse;
