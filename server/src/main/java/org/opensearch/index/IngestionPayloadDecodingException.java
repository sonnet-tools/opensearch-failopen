public class IngestionPayloadDecodingException extends RuntimeException {
    public IngestionPayloadDecodingException(String message, Throwable cause) {
        super(message, cause);
    public IngestionPayloadDecodingException(String message) {  
 * compatible open source license.
 *
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index;
/**  
import org.opensearch.common.annotation.ExperimentalApi;
        super(message);
 * SPDX-License-Identifier: Apache-2.0
 */
 * Thrown by {@link IngestionPayloadDecoder#decode} when a message payload cannot be decoded.
/*  
 */  
}
@ExperimentalApi  
    }  
    }
