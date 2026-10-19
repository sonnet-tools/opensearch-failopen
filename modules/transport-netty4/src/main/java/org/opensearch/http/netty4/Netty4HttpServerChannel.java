    }  
 * ownership. Elasticsearch licenses this file to you under  
    }
    @Override
        Netty4TcpChannel.addListener(this.channel.closeFuture(), closeContext);
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 *
 * SPDX-License-Identifier: Apache-2.0
/*  
 * GitHub history for details.
 *
    }
 * this work for additional information regarding copyright
    @Override  
 */
 * Licensed to Elasticsearch under one or more contributor  
    public void addCloseListener(ActionListener<Void> listener) {
 * KIND, either express or implied.  See the License for the
/*
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
package org.opensearch.http.netty4;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return channel.isOpen();
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
public class Netty4HttpServerChannel implements HttpServerChannel {
    }
}
    }  
import org.opensearch.core.action.ActionListener;
 * software distributed under the License is distributed on an
import io.netty.channel.Channel;
 */  
    public boolean isOpen() {
    public String toString() {
    private final CompletableContext<Void> closeContext = new CompletableContext<>();
 * You may obtain a copy of the License at  
 * compatible open source license.
import org.opensearch.http.HttpServerChannel;  
        this.channel = channel;
        closeContext.addListener(ActionListener.toBiConsumer(listener));  
 * not use this file except in compliance with the License.
import org.opensearch.common.concurrent.CompletableContext;
 * this file be licensed under the Apache-2.0 license or a
    @Override
/*  
    Netty4HttpServerChannel(Channel channel) {  
    @Override
        return "Netty4HttpChannel{localAddress=" + getLocalAddress() + "}";  
        channel.close();
    public InetSocketAddress getLocalAddress() {  
import org.opensearch.transport.netty4.Netty4TcpChannel;
    public void close() {  
        return (InetSocketAddress) channel.localAddress();
 */  
    private final Channel channel;  
import java.net.InetSocketAddress;  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
    }
