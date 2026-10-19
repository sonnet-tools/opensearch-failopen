public interface HttpChannel extends CloseableChannel {  
import org.opensearch.core.action.ActionListener;
/*
     * transport engine).
 * license agreements. See the NOTICE file distributed with
    @Nullable
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @return the remote address of this channel.  
 */  
    /**
    InetSocketAddress getLocalAddress();
     */
    /**
     * @param clazz the expected type of the property
 * compatible open source license.
 */
     * @return the value of the property
 * SPDX-License-Identifier: Apache-2.0
import java.util.Optional;
 * Unless required by applicable law or agreed to in writing,
        return Optional.empty();
     *
     * @param ex the exception being raised  
    }
 * @opensearch.api  
    default void handleException(Exception ex) {}
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
    /**
 *
 * this work for additional information regarding copyright
 *
     * @param response to send to channel
 *  
 * Modifications Copyright OpenSearch Contributors. See
/*  
import java.net.InetSocketAddress;  
 * this file be licensed under the Apache-2.0 license or a
/*  
     *  
     * completed.  
     * @return the local address of this channel.
 * GitHub history for details.
 * Represents an HTTP comms channel
    @Nullable  
/**  
 * the Apache License, Version 2.0 (the "License"); you may
    InetSocketAddress getRemoteAddress();  
 * software distributed under the License is distributed on an
    default <T> Optional<T> get(String name, Class<T> clazz) {  
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
     */
     * Returns the remote address for this channel. Can be null if channel does not have a remote address.
 * specific language governing permissions and limitations
     * Notify HTTP channel that exception happens and the response may not be sent (for example, timeout)
 *
import org.opensearch.common.network.CloseableChannel;  
    /**  
import org.opensearch.common.Nullable;
import org.opensearch.common.annotation.PublicApi;
     * Sends an http response to the channel. The listener will be executed once the send process has been
     *  
     * Returns the local address for this channel.
     *
     * @param name the name of the property
 * KIND, either express or implied.  See the License for the
     * Returns the contextual property associated with this specific HTTP channel (the  
     *  
     */
     */
}  
     * implementation of how such properties are managed depends on the particular
 */  
 * Licensed to Elasticsearch under one or more contributor  
    /**
     */
package org.opensearch.http;
     * @param listener to execute upon send completion  
@PublicApi(since = "1.0.0")
 * The OpenSearch Contributors require contributions made to  
    void sendResponse(HttpResponse response, ActionListener<Void> listener);
