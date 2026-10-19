import org.reactivestreams.Publisher;
/**
     * @return {@code true} is this channel is ready for streaming response data, {@code false} otherwise
 * A streaming channel used to prepare response and sending the response in chunks.
    void prepareResponse(RestStatus status, Map<String, List<String>> headers);
    /**  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
     * Returns {@code true} is this channel is ready for streaming request data, {@code false} otherwise
package org.opensearch.rest;
     */  
    boolean isReadable();
 * compatible open source license.
     */  
     * Returns {@code true} is this channel is ready for streaming response data, {@code false} otherwise
 *
     * @return {@code true} is this channel is ready for streaming request data, {@code false} otherwise
 *  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.http.HttpChunk;  
 * @opensearch.experimental
     */  
import java.util.Map;  
    /**
/*  
import org.opensearch.common.annotation.ExperimentalApi;
     * Sends the next {@link HttpChunk} to the response stream  
     * @param headers response headers
public interface StreamingRestChannel extends RestChannel, Publisher<HttpChunk> {
@ExperimentalApi  
 */  
     */
     * @param status response status
}
    boolean isWritable();
    /**  
import java.util.List;
    /**
 */
    void sendChunk(HttpChunk chunk);  
     * @param chunk response chunk
import org.opensearch.core.rest.RestStatus;
     * Prepares response before kicking of content streaming  
