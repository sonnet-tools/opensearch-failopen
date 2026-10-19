 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 */
    }
 * Maps to HTTP 400 (Bad Request) since this is a user error, not a server error.  
/*  
}  
 * SPDX-License-Identifier: Apache-2.0
    @Override
package org.opensearch.analytics.planner;
import org.opensearch.OpenSearchException;
    }  
public class UnsupportedFunctionException extends OpenSearchException {
import org.opensearch.core.rest.RestStatus;
 */  
    public RestStatus status() {  
        return RestStatus.BAD_REQUEST;
 *
/**
 * this file be licensed under the Apache-2.0 license or a
        super("Function [" + functionName + "] is not currently supported" + (context != null ? " " + context : ""));
    public UnsupportedFunctionException(String functionName, String context) {
 * Thrown when a query uses a function that is not currently supported by the analytics engine.
