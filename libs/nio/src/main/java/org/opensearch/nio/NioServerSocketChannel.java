     * @param context to call  
 * Unless required by applicable law or agreed to in writing,
        this.serverSocketChannel = serverSocketChannel;
        attemptToSetLocalAddress();
        return localAddress;
    public void addBindListener(BiConsumer<Void, Exception> listener) {
 * Modifications Copyright OpenSearch Contributors. See
    }
 *
 * The OpenSearch Contributors require contributions made to  
    private void attemptToSetLocalAddress() {
        return "NioServerSocketChannel{" + "localAddress=" + getLocalAddress() + '}';
        return context;  
            localAddress = (InetSocketAddress) serverSocketChannel.socket().getLocalSocketAddress();
    }  
 */  
 * license agreements. See the NOTICE file distributed with
    private final AtomicBoolean contextSet = new AtomicBoolean(false);  
    public String toString() {
 */
 *  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        } else {
}
 * under the License.  
        if (localAddress == null) {  
    }
    }  
        }
 * compatible open source license.
import java.nio.channels.ServerSocketChannel;
    /**
import java.util.concurrent.atomic.AtomicBoolean;  
    @Override  
/*
     */
     *
    private final ServerSocketChannel serverSocketChannel;
import java.util.function.BiConsumer;
        return serverSocketChannel;
        context.addBindListener(listener);
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalStateException("Context on this channel were already set. It should only be once.");  
    }
     * accepted, an exception occurs, or it is time to close the channel.
    public ServerSocketChannel getRawChannel() {  
    private volatile InetSocketAddress localAddress;
 */  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * GitHub history for details.
    public void setContext(ServerChannelContext context) {
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
        if (contextSet.compareAndSet(false, true)) {  
 * specific language governing permissions and limitations
        }
    public NioServerSocketChannel(ServerSocketChannel serverSocketChannel) {
    private ServerChannelContext context;
            this.context = context;
/*  
 *
public class NioServerSocketChannel extends NioChannel {  
import java.net.InetSocketAddress;
 * this work for additional information regarding copyright
/*  
    }  
    public InetSocketAddress getLocalAddress() {  
    @Override
    @Override
 * KIND, either express or implied.  See the License for the
    }  
     * This method sets the context for a server socket channel. The context is called when a new channel is  
 * ownership. Elasticsearch licenses this file to you under  
    public ServerChannelContext getContext() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
package org.opensearch.nio;
