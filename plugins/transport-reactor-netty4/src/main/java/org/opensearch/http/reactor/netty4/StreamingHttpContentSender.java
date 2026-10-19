     */
     * @param isLast {@code true} if this is the last chunk, {@code false} otherwise
 * The OpenSearch Contributors require contributions made to  
     * @param content next {@link HttpContent}
/**
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
}
 */  
    /**  
package org.opensearch.http.reactor.netty4;
 */
     * @param listener action listener  
     * Sends the next {@link HttpContent} over the wire
import org.opensearch.core.action.ActionListener;
import io.netty.handler.codec.http.HttpContent;  
 * this file be licensed under the Apache-2.0 license or a
     * Returns {@code true} is this channel is ready for streaming response data, {@code false} otherwise  
/*  
     */
    boolean isReady();  
    void send(HttpContent content, ActionListener<Void> listener, boolean isLast);  
    /**
     * @return {@code true} is this channel is ready for streaming response data, {@code false} otherwise
interface StreamingHttpContentSender {
 * The generic interface for chunked {@link HttpContent} producers (response streaming).  
 *
