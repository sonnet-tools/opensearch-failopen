     * objects back to the caller.
    public abstract void sendRequest(
/*  
 */
     */
        final boolean compressRequest,
        final Set<String> features,
        final String action,
    ) throws IOException;
    ) throws IOException, TransportException;  
    /**
 * Protocol based outbound data handler.  
        final boolean compress,  
    protected abstract void setMessageListener(TransportMessageListener listener);
    public abstract void sendErrorResponse(
        final boolean isHandshake
        final TcpChannel channel,
     * Sends back an error response to the caller via the given channel
     */  
import org.opensearch.core.transport.TransportResponse;  
     */
import org.opensearch.cluster.node.DiscoveryNode;
        final String action,  
/**
        final Set<String> features,  
 * SPDX-License-Identifier: Apache-2.0
        final String action,  
    /**
        final long requestId,
        final TransportRequestOptions options,
     *
        final Version nodeVersion,  
public abstract class ProtocolOutboundHandler {
    public abstract void sendResponse(
     * objects back to the caller.  
 *
        final long requestId,
        final Version nodeVersion,
}
        final long requestId,  
 * this file be licensed under the Apache-2.0 license or a
        final Version channelVersion,  
        final boolean isHandshake
    /**
import java.io.IOException;
 */  
import java.util.Set;  
 * The OpenSearch Contributors require contributions made to  
    ) throws IOException;
     * Sends the request to the given channel. This method should be used to send {@link TransportRequest}
        final Exception error
 * compatible open source license.
        final DiscoveryNode node,  
     * Sends the response to the given channel. This method should be used to send {@link TransportResponse}  
        final TransportResponse response,
 * Different transport protocols can have different implementations of this class.
        final TcpChannel channel,
        final TcpChannel channel,
 *
     * @see #sendErrorResponse(Version, Set, TcpChannel, long, String, Exception) for sending error responses  
 * @opensearch.internal  
package org.opensearch.transport;
        final TransportRequest request,
import org.opensearch.Version;
