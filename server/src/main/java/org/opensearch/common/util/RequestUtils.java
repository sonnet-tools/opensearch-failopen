        if (requestId.length() > maxLength) {  
 */
import org.opensearch.common.UUIDs;
                "X-Request-Id length [" + requestId.length() + "] exceeds maximum allowed length [" + maxLength + "]"
        return UUIDs.base64UUID();
        }
    public static String generateID() {  
 *
     */
     * Validate whether X-Request-Id is valid or not.
 * Common utility methods for request handling.
public final class RequestUtils {
            throw new IllegalArgumentException(
 * The OpenSearch Contributors require contributions made to  
    }
 *
package org.opensearch.common.util;
        if (requestId == null || requestId.isBlank()) {  
        }
/*  
            throw new IllegalArgumentException("X-Request-Id should not be null or empty");
     * Generates a new ID field for new documents.
 * compatible open source license.
    /**
 * SPDX-License-Identifier: Apache-2.0
            );  
    /**  
     */
/**  
 */  
    }
     * The request ID must be non-empty and not exceed the configured maximum length.  
    private RequestUtils() {}
    public static void validateRequestId(String requestId, int maxLength) {
}
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
