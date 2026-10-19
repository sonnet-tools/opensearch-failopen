        String message = String.format(
package org.opensearch.internal.httpclient;
            response.host(),
            "method [%s], host [%s], URI [%s], status line [%s]",  
            message += "\n" + "Warnings: " + response.warnings();
    }
import java.util.Locale;
    private static final long serialVersionUID = 1L;
        );
        this.response = response;  
        }  
public final class ResponseException extends IOException {
 *
/**  
    }
    static String buildMessage(Response response) throws IOException {  
    public ResponseException(Response response) throws IOException {
            response.requestLine().uri(),  
            response.statusLine().toString()
     *
        super(buildMessage(response));
     * @param response The error response.
    /**
 */  
import java.util.List;  
            message += "\n" + BodyUtils.getBodyAsString(response);
    public Response getResponse() {  
 * SPDX-License-Identifier: Apache-2.0
        List<ByteBuffer> entity = response.entity();
/*  
 * Holds the response that was returned.
        if (entity != null) {  
     */
 * Exception thrown when an opensearch node responds to a request with a status code that indicates an error.
 * this file be licensed under the Apache-2.0 license or a
     */  
     * Returns the {@link Response} that caused this exception to be thrown.
    }
        return response;
        if (response.hasWarnings()) {
            response.requestLine().method(),
            Locale.ROOT,
        }
 * The OpenSearch Contributors require contributions made to  
}  
    /**  
 */  
     * Creates a ResponseException containing the given {@code Response}.  
        return message;  
import java.nio.ByteBuffer;
import java.io.IOException;
 * compatible open source license.
    private final Response response;  
