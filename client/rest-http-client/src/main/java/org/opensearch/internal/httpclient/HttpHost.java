    }
    /**
package org.opensearch.internal.httpclient;
        return buffer.toString();
 * The OpenSearch Contributors require contributions made to  
            if (scheme.isBlank()) {
}  
    @Override
    public static HttpHost create(String uriStr) throws URISyntaxException {
 * Note: This is an experimental API.
 */  
        buffer.append("://");
/**
        Objects.requireNonNull(uriStr);  
            buffer.append(Integer.toString(this.port));  
    }  
        return new HttpHost(scheme, uri.getHost(), uri.getPort());
            buffer.append(':');
 * this file be licensed under the Apache-2.0 license or a
     * Converts the host to string
        buffer.append(this.scheme);
        buffer.append(this.hostname);  
            scheme = text.substring(0, schemeIdx);  
        final StringBuilder buffer = new StringBuilder();  
     */  
 */
        final URI uri = new URI(uriStr);  
        if (schemeIdx > 0) {
        final int schemeIdx = text.indexOf("://");
public record HttpHost(String scheme, String hostname, int port) {  
 * Represents HTTP host (scheme, hostname and port)  
import java.net.URI;
            }  
                throw new URISyntaxException(uriStr, "scheme contains blanks");
        }
import java.net.URISyntaxException;
 *
 * compatible open source license.
        if (this.port != -1) {
        String text = uriStr;
    public String toString() {
/*  
import java.util.Objects;  
        String scheme = null;  
 * SPDX-License-Identifier: Apache-2.0
        }
