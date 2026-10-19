 *
import java.net.http.HttpClient.Version;
 * compatible open source license.
        this(Objects.requireNonNull(response, "Response").version(), Objects.requireNonNull(response, "Response").statusCode());
 * The OpenSearch Contributors require contributions made to  
    /**
     */  
 * this file be licensed under the Apache-2.0 license or a
import java.net.http.HttpResponse;
        protoVersion = protoVersion != null ? protoVersion : Version.HTTP_1_1;
     * Creates a new status line with the given version and status.
     */  
package org.opensearch.internal.httpclient;
    }  
import java.util.Objects;  
 * Response status line (protocol, status code)  
    public StatusLine(final HttpResponse<?> response) {
     * @param protoVersion      the protocol version of the response
     *  
     * Creates a new status line from the response  
 */  
     * @param response HTTP response
 * Note: This is an experimental API.
    /**
    public StatusLine {
/**
    }  
 * SPDX-License-Identifier: Apache-2.0
/*  
     * @param statusCode   the status code of the response
     *
 */
public record StatusLine(Version protoVersion, int statusCode) {  
}
