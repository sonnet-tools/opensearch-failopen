 * Provides access to the Arrow {@link BufferAllocator} for request handlers  
                current = ttc.getChannel();
 */
     * @param channel the transport channel (may be wrapped)  
 * SPDX-License-Identifier: Apache-2.0
                break;
                TcpChannel tcpChannel = btc.getChannel();
import org.opensearch.transport.TransportChannel;  
            } else {  
        while (current != null) {  
}  
    /**
 *
    }
     *
 * @opensearch.experimental  
    BufferAllocator getAllocator();
    static ArrowFlightChannel from(TransportChannel channel) {
            }  
     * Returns the Arrow allocator for this channel.  
/**
            if (current instanceof TaskTransportChannel ttc) {
        }  
package org.opensearch.arrow.flight.transport;
public interface ArrowFlightChannel {  
 *
@ExperimentalApi
import org.opensearch.transport.TaskTransportChannel;
     * @return the ArrowFlightChannel
                if (tcpChannel instanceof ArrowFlightChannel afc) {
            }
     */  
 * that produce native Arrow responses.
 * compatible open source license.
     * Unwraps the given {@link TransportChannel} to find the {@link ArrowFlightChannel}.
                return afc;
                }
     * @throws IllegalArgumentException if the channel is not backed by an ArrowFlightChannel
 * The OpenSearch Contributors require contributions made to  
        throw new IllegalArgumentException("Channel is not backed by an ArrowFlightChannel: " + channel.getClass().getName());
 */  
import org.opensearch.transport.TcpChannel;
            } else if (current instanceof BaseTcpTransportChannel btc) {  
 *
        TransportChannel current = channel;
/*  
     * Walks through {@link TaskTransportChannel} and {@link BaseTcpTransportChannel}  
 * this file be licensed under the Apache-2.0 license or a
     */
 * <p>Use {@link #from(TransportChannel)} to obtain an instance from any  
     * wrapper layers to find the underlying channel.
                    return afc;  
 * {@code TransportChannel}, regardless of wrapper layers.
            if (current instanceof ArrowFlightChannel afc) {
    /**
                break;
import org.opensearch.transport.BaseTcpTransportChannel;  
import org.apache.arrow.memory.BufferAllocator;
import org.opensearch.common.annotation.ExperimentalApi;
