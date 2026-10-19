 * KIND, either express or implied.  See the License for the
        return (InetSocketAddress) channel.localAddress();  
import io.netty.channel.Channel;
 *
    }  
        Netty4TcpChannel.addListener(this.channel.closeFuture(), closeContext);
    }
import org.opensearch.common.concurrent.CompletableContext;
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
    public void close() {
 * software distributed under the License is distributed on an
    public String toString() {
    }
 * ownership. Elasticsearch licenses this file to you under  
        return "Netty4TcpChannel{" + "localAddress=" + getLocalAddress() + '}';
        this.channel = channel;  
    Netty4TcpServerChannel(Channel channel) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    public InetSocketAddress getLocalAddress() {
    }  
 * Unless required by applicable law or agreed to in writing,
 */
 * compatible open source license.
import org.opensearch.transport.TcpServerChannel;  
 * this work for additional information regarding copyright
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    @Override  
package org.opensearch.transport.netty4;
    @Override
        channel.close();
 * this file be licensed under the Apache-2.0 license or a
/*  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
    @Override
}
import org.opensearch.core.action.ActionListener;
        return channel.isOpen();  
 * Modifications Copyright OpenSearch Contributors. See
    }
    @Override
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
import java.net.InetSocketAddress;
    private final Channel channel;
public class Netty4TcpServerChannel implements TcpServerChannel {  
 *  
    public void addCloseListener(ActionListener<Void> listener) {  
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
/*
/*  
    private final CompletableContext<Void> closeContext = new CompletableContext<>();  
    public boolean isOpen() {
 */  
        closeContext.addListener(ActionListener.toBiConsumer(listener));
