    public boolean isOpen() {
     */
     */  
 * specific language governing permissions and limitations
 *
 * GitHub history for details.
    public abstract NetworkChannel getRawChannel();
 * <p>
     * Schedules channel for close. This process is asynchronous.
        getContext().addCloseListener(listener);
 * Unless required by applicable law or agreed to in writing,
 * A channel is open once it is constructed. The channel remains open and {@link #isOpen()} will return
 * SPDX-License-Identifier: Apache-2.0
/*  
    /**
 * KIND, either express or implied.  See the License for the
}
 */  
 * The OpenSearch Contributors require contributions made to  
import java.net.InetSocketAddress;
public abstract class NioChannel {
     * @param listener to be called at close
     * about the order in which close listeners will be executed. If the channel is already closed, the
     * Adds a close listener to the channel. Multiple close listeners can be added. There is no guarantee  
import java.nio.channels.NetworkChannel;
        return getContext().isOpen();
 * software distributed under the License is distributed on an
        getContext().closeChannel();
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
    }  
 * compatible open source license.
 */  
    public abstract ChannelContext<?> getContext();  
    /**
 * You may obtain a copy of the License at  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * This is a basic channel abstraction used by the {@link NioSelector}.  
 * under the License.  
/*
 */
import java.util.function.BiConsumer;  
 * true until the channel is explicitly closed.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.nio;
/*  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 *
     *  
    public void addCloseListener(BiConsumer<Void, Exception> listener) {  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
/**
     * listener is executed immediately.
    public abstract InetSocketAddress getLocalAddress();
    public void close() {
