 * Interface for factory to provide handler implementation for type {@link T}
/*  
/**
 * this file be licensed under the Apache-2.0 license or a
 * @param <T> The type of content to be read/written to stream  
 * The OpenSearch Contributors require contributions made to  
}  
     * @param version stream version
     */
package org.opensearch.common.io;
 *
 * compatible open source license.
     * @return Handler for reading/writing content streams to/from - {@link T}  
     * Implements logic to provide handler based on the stream versions
 * SPDX-License-Identifier: Apache-2.0
 */  
 */  
 * @opensearch.internal
    /**  
    IndexIOStreamHandler<T> getHandler(int version);
 *
public interface IndexIOStreamHandlerFactory<T> {
