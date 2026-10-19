 *
 * SPDX-License-Identifier: Apache-2.0
/*  
 * this file be licensed under the Apache-2.0 license or a
@ExperimentalApi
    boolean isLast();
import org.opensearch.common.annotation.ExperimentalApi;
 *
import org.opensearch.core.common.bytes.BytesReference;  
 */  
    BytesReference content();
    */  
public interface HttpChunk extends Releasable {
import org.opensearch.common.lease.Releasable;
 * compatible open source license.
 * @opensearch.experimental
     * Signals this is the last chunk of the stream.
 * Represents a chunk of the HTTP request / response stream  
}
 */  
/**
    /**  
    /**  
    * Returns the content of this chunk
 * The OpenSearch Contributors require contributions made to  
     */  
    * @return the content of this chunk
package org.opensearch.http;
     * @return "true" if this is the last chunk of the stream, "false" otherwise
