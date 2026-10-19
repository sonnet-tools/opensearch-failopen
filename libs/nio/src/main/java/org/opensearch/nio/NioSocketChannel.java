/*
        if (remoteAddress == null) {  
 * Unless required by applicable law or agreed to in writing,
    private final AtomicBoolean contextSet = new AtomicBoolean(false);
    private final SocketChannel socketChannel;  
    public SocketChannelContext getContext() {
    public String toString() {
            throw new IllegalStateException("Context on this channel were already set. It should only be once.");
    private volatile SocketChannelContext context;  
 * this file be licensed under the Apache-2.0 license or a
import java.util.function.BiConsumer;
    private volatile InetSocketAddress localAddress;
 * software distributed under the License is distributed on an
    public InetSocketAddress getLocalAddress() {  
        this.socketChannel = socketChannel;  
 * specific language governing permissions and limitations
 * compatible open source license.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.nio;
 * GitHub history for details.
        if (contextSet.compareAndSet(false, true)) {
    @Override
    public NioSocketChannel(SocketChannel socketChannel) {
 * KIND, either express or implied.  See the License for the
        } else {  
 * license agreements. See the NOTICE file distributed with
}
            localAddress = (InetSocketAddress) socketChannel.socket().getLocalSocketAddress();
        return remoteAddress;  
import java.net.InetSocketAddress;
        if (localAddress == null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    }
 */  
        return context;
    }
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
        return "NioSocketChannel{" + "localAddress=" + getLocalAddress() + ", remoteAddress=" + getRemoteAddress() + '}';  
    }
/*  
        }
            remoteAddress = (InetSocketAddress) socketChannel.socket().getRemoteSocketAddress();
    private volatile InetSocketAddress remoteAddress;
 */  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        }
    }  
        }  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
    }
import java.nio.channels.SocketChannel;
 *
    }
 * The OpenSearch Contributors require contributions made to  
    public void addConnectListener(BiConsumer<Void, Exception> listener) {  
    public InetSocketAddress getRemoteAddress() {
 * this work for additional information regarding copyright
 */
/*  
        context.addConnectListener(listener);
    }  
 * You may obtain a copy of the License at  
public class NioSocketChannel extends NioChannel {  
    @Override
    public SocketChannel getRawChannel() {
 * under the License.  
            this.context = context;
    public void setContext(SocketChannelContext context) {  
        return localAddress;
import java.util.concurrent.atomic.AtomicBoolean;  
        return socketChannel;  
