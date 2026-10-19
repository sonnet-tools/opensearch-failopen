package org.opensearch.search.pipeline.common;
 *
 * The OpenSearch Contributors require contributions made to  
     * @param cause The cause of the exception.
    }
import org.opensearch.OpenSearchWrapperException;
 * SPDX-License-Identifier: Apache-2.0
     */
}
     * @param msg   The error message.
        super(msg, cause, args);  
    public SearchRequestMapProcessingException(String msg, Throwable cause, Object... args) {
    /**
/**
     */
     * @param msg  The error message.  
import org.opensearch.OpenSearchException;
     * Constructs a new SearchRequestMapProcessingException with the specified message.
     *
 * compatible open source license.
 */  
     * @param args  Arguments to substitute in the error message.  
     * Constructs a new SearchRequestMapProcessingException with the specified message and cause.
    }
/*  
     *  
 * An exception that indicates an error occurred while processing a {@link SearchRequestMap}.
 */  
    /**  
    public SearchRequestMapProcessingException(String msg, Object... args) {  
class SearchRequestMapProcessingException extends OpenSearchException implements OpenSearchWrapperException {
     * @param args Arguments to substitute in the error message.
 * this file be licensed under the Apache-2.0 license or a
        super(msg, args);
