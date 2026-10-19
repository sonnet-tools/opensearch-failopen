        this.channel = channel;
            channel.sendResponse(e);  
 * - onFailure(): Handle errors and complete the stream
            channel.completeStream();  
     *
        try {
        this.request = request;  
    @Override  
        }
    @Override
    }
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
     * @param isLastBatch whether this response is the last one  
    private final Request request;
    private final String actionName;
     */
    }
    }
        }
import org.opensearch.transport.TransportChannel;
        channel.sendResponseBatch(response);
import org.opensearch.common.annotation.ExperimentalApi;
        if (isLastBatch) {
/*  
@ExperimentalApi
        assert response != null;  
    /**
        } catch (IOException exc) {
     */  
import org.opensearch.transport.TransportRequest;
 */  
import org.opensearch.core.action.ActionListener;
package org.opensearch.action.support;
     * @param response the response to send
        ActionListener<Response> {
     * This maintains compatibility on data node side  
import java.io.IOException;
 * A listener that sends the response back to the channel in streaming fashion.
 * this file be licensed under the Apache-2.0 license or a
        onStreamResponse(response, true);  
    private final TransportChannel channel;  
    implements  
    public final void onResponse(Response response) {
    public StreamSearchChannelListener(TransportChannel channel, String actionName, Request request) {
 * - onStreamResponse(): Send streaming responses  
 * The OpenSearch Contributors require contributions made to  
}  
     * This allows multiple responses to be sent for a single request.  
    public void onStreamResponse(Response response, boolean isLastBatch) {
 *
import org.opensearch.core.transport.TransportResponse;  
 * - onResponse(): Standard ActionListener method that send last stream response
public class StreamSearchChannelListener<Response extends TransportResponse, Request extends TransportRequest>
/**  
    /**
            throw new RuntimeException(exc);  
 */  
            channel.completeStream();
    }
    public void onFailure(Exception e) {
     *
     * Send streaming responses
     * @param response    the intermediate response to send
     * Reuse ActionListener method to send the last stream response
 *
        this.actionName = actionName;
