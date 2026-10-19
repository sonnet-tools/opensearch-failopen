    /**
/*  
 * this file be licensed under the Apache-2.0 license or a
     * Receives the next {@link HttpChunk} from the request stream
import java.util.Map;
     * @param chunk response chunk to send to channel  
    void receiveChunk(HttpChunk chunk);
     * Returns {@code true} is this channel is ready for streaming response data, {@code false} otherwise  
 * Represents an HTTP communication channel with streaming capabilities.
import org.opensearch.common.annotation.ExperimentalApi;
 * SPDX-License-Identifier: Apache-2.0
    /**
    boolean isWritable();  
    /**
package org.opensearch.http;
     * @return {@code true} is this channel is ready for streaming response data, {@code false} otherwise
    void sendChunk(HttpChunk chunk, ActionListener<Void> listener);
     */
    boolean isReadable();  
 * The OpenSearch Contributors require contributions made to  
@ExperimentalApi
 *
    void prepareResponse(int status, Map<String, List<String>> headers);  
     * @param status response status  
 * compatible open source license.
}
     * @return {@code true} is this channel is ready for streaming request data, {@code false} otherwise
     * Sends the next {@link HttpChunk} to the response stream
public interface StreamingHttpChannel extends HttpChannel, Publisher<HttpChunk> {  
 */  
     */
 */
 * @opensearch.experimental  
     * @param chunk next {@link HttpChunk}  
     * Prepares response before kicking of content streaming
 *
     * @param headers response headers
     * Returns {@code true} is this channel is ready for streaming request data, {@code false} otherwise  
     */
    /**
     */
import org.reactivestreams.Publisher;
     */
import org.opensearch.core.action.ActionListener;
import java.util.List;
/**  
    /**
