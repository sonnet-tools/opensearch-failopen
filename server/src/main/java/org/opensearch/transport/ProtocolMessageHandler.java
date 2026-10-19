        long startTime,  
     * Sets the message listener to be used by the handler.  
 * @opensearch.internal  
     */
    public void setMessageListener(TransportMessageListener listener);  
     * @param message the message received
 */  
    public void messageReceived(  
 */
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.transport;
        ProtocolInboundMessage message,
     * Handles the message received on the channel.
        TcpChannel channel,
 * compatible open source license.
     * @param channel the channel on which the message was received  
     * @param slowLogThresholdMs the threshold for slow logs  
}
 *
/*  
    /**
        long slowLogThresholdMs,
     * @param startTime the start time
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
        TransportMessageListener messageListener
     * @param messageListener the message listener
    /**
    ) throws IOException;  
 * Interface for message handlers based on transport protocol.
     */
public interface ProtocolMessageHandler {
 * The OpenSearch Contributors require contributions made to  
     * @param listener the message listener
/**  
 *
