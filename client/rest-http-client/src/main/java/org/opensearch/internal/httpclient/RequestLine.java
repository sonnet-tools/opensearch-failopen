 * this file be licensed under the Apache-2.0 license or a
        );
/*  
import java.net.http.HttpClient.Version;  
        method = Objects.requireNonNull(method, "Method");  
        final StringBuilder buf = new StringBuilder();  
        this(  
     * Create a new instance from the request
 * Request line (protocol, method, uri)
     */
     * @param uri request uri
 */
 */  
        }
    @Override
     * Converts the request line to string
     * @param version HTTP protocol  
 * Note: This is an experimental API.  
    public RequestLine(final String method, final URI uri, final Version version) {
     * @param request HTTP request
            Objects.requireNonNull(method, "Method"),
     */  
    public String toString() {
     */  
            return uri.getPath();
            Objects.requireNonNull(uri, "URI").getPath(),
public record RequestLine(String method, String uri, Version protocolVersion) implements Serializable {
     * @param method request HTTP method
import java.util.Objects;
import java.net.http.HttpRequest;
import java.net.URI;
    }
    }  
/**
    /**  
        return buf.toString();
        if (query != null && query.isBlank() == false) {
    }
    /**
import java.io.Serializable;
        this(Objects.requireNonNull(request, "Request").method(), buildUri(request.uri()), request.version().orElse(Version.HTTP_1_1));
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.internal.httpclient;
     * Creates new request line instance  
 *
        } else {  
    }  
}
            version != null ? version : Version.HTTP_1_1  
    private static final long serialVersionUID = 2810581718468737193L;  
        buf.append(this.method).append(" ").append(this.uri).append(" ").append(this.protocolVersion);
    private static String buildUri(URI uri) {
        final String query = uri.getQuery();  
    public RequestLine {
 * compatible open source license.
    public RequestLine(final HttpRequest request) {
    /**
    }  
            return uri.getPath() + "?" + query;
