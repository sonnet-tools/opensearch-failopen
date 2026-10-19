import org.opensearch.common.annotation.PublicApi;
    @PublicApi(since = "1.0.0")  
    /**
     * @param requestId request Id  
     * Sends a tcp message to the channel. The listener will be executed once the send process has been  
     *
            lastAccessedTime = TimeValue.nsecToMSec(System.nanoTime());  
    void addConnectListener(ActionListener<Void> listener);
 * the Apache License, Version 2.0 (the "License"); you may
     * @return the value of the property
/**
 * @opensearch.api  
 * Licensed to Elasticsearch under one or more contributor  
        private volatile long lastAccessedTime;  
     * @param listener to be executed
 * KIND, either express or implied.  See the License for the
     * Returns the remote address for this channel. Can be null if channel does not have a remote address.
     * Returns stats about this channel
 * license agreements. See the NOTICE file distributed with
@PublicApi(since = "1.0.0")
     *  
     */
        }
     * @opensearch.api
    /**
     * @param reference to send to channel  
/*  
     * Channel statistics
    }
package org.opensearch.transport;
import java.net.InetSocketAddress;
 * ownership. Elasticsearch licenses this file to you under  
/*  
     */  
 */  
     * Returns the local address for this channel.
            lastAccessedTime = relativeMillisTime;
    String getProfile();
     * completed.
    /**  
        sendMessage(reference, listener);
    }  
    /**  
        }  
import org.opensearch.core.action.ActionListener;
     * @param name the name of the property
    default void sendMessage(long requestId, BytesReference reference, ActionListener<Void> listener) {
     * Sends a tcp message to the channel. The listener will be executed once the send process has been  
     * @param listener to execute upon send completion
     */  
 * software distributed under the License is distributed on an
 */
 *
    /**
     * transport engine).
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 *
import org.opensearch.common.network.CloseableChannel;
     * @return the local address of this channel.  
 * abstraction used by the {@link TcpTransport} and {@link TransportService}. All tcp transport  
 * specific language governing permissions and limitations
 * GitHub history for details.
     *
            return lastAccessedTime;
     * This returns the profile for this channel.
     *  
     *  
    /**
 */  
/*
    /**
     * finishes the channel connection. If the channel is already connected when the listener is added the
     */
    }
 * this file be licensed under the Apache-2.0 license or a
     * completed.
     * Returns the contextual property associated with this specific TCP channel (the  
 * SPDX-License-Identifier: Apache-2.0
     *
 * This is a tcp channel representing a single channel connection to another node. It is the base channel
    InetSocketAddress getRemoteAddress();  
     */
     */
    /**
 */
     * @param listener to execute upon send completion
    ChannelStats getChannelStats();  
    boolean isServerChannel();
 * Unless required by applicable law or agreed to in writing,
        long lastAccessedTime() {
     *
     * unconnected when this listener is added, the listener will be executed by the thread that eventually
 *    http://www.apache.org/licenses/LICENSE-2.0
     *  
     * @param clazz the expected type of the property
 *  
    default <T> Optional<T> get(String name, Class<T> clazz) {  
     * listener will immediately be executed by the thread that is attempting to add the listener.  
     * Indicates if the channel is an inbound server channel.  
import org.opensearch.common.unit.TimeValue;  
     */  
 * Modifications Copyright OpenSearch Contributors. See
    InetSocketAddress getLocalAddress();
 * this work for additional information regarding copyright
        void markAccessed(long relativeMillisTime) {  
 * The OpenSearch Contributors require contributions made to  
     * @param reference to send to channel
     */
     * implementation of how such properties are managed depends on the particular
    /**
        }
    /**
     * Adds a listener that will be executed when the channel is connected. If the channel is still  
public interface TcpChannel extends CloseableChannel {  
    class ChannelStats {
 * under the License.  
 * not use this file except in compliance with the License.
 * compatible open source license.
 * You may obtain a copy of the License at  
        public ChannelStats() {
import java.util.Optional;
import org.opensearch.core.common.bytes.BytesReference;
}
     */
 * implementations must return channels that adhere to the required method contracts.
        return Optional.empty();
     * @return the remote address of this channel.
    void sendMessage(BytesReference reference, ActionListener<Void> listener);  
     */
