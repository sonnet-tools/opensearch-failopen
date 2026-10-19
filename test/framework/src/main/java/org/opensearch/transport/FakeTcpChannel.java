 * KIND, either express or implied.  See the License for the
    }
        AtomicReference<BytesReference> messageCaptor
 *  
    public void close() {
        return messageCaptor;
import java.net.InetSocketAddress;
    @Override  
 * GitHub history for details.
import org.opensearch.core.common.bytes.BytesReference;
    public boolean isOpen() {
 * this file be licensed under the Apache-2.0 license or a
    public ChannelStats getChannelStats() {  
        this.localAddress = localAddress;
package org.opensearch.transport;
import org.opensearch.common.concurrent.CompletableContext;  
        return localAddress;  
        listenerCaptor.set(listener);
 * under the License.  
    private final CompletableContext<Void> closeContext = new CompletableContext<>();  
    private final InetSocketAddress localAddress;
    public InetSocketAddress getLocalAddress() {
    }  
    private final boolean isServer;
        this.profile = profile;
        this.listenerCaptor = new AtomicReference<>();  
    public FakeTcpChannel(boolean isServer, String profile, AtomicReference<BytesReference> messageCaptor) {
        this(isServer, localAddress, remoteAddress, "profile", new AtomicReference<>());
    }
    }
/*
    }  
 * specific language governing permissions and limitations
    public boolean isServerChannel() {
        this.messageCaptor = messageCaptor;
    private final InetSocketAddress remoteAddress;  
    }  
        this(isServer, null, null, profile, messageCaptor);  
    @Override  
    }
        return stats;
        this.remoteAddress = remoteAddress;  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public FakeTcpChannel(  
        this(isServer, "profile", messageCaptor);
import java.util.concurrent.atomic.AtomicReference;
        this.isServer = isServer;
        InetSocketAddress localAddress,
    @Override
    }
    }  
/*  
    @Override
    public void sendMessage(BytesReference reference, ActionListener<Void> listener) {  
        return isServer;
    private final AtomicReference<BytesReference> messageCaptor;
        this(false, "profile", new AtomicReference<>());
 * You may obtain a copy of the License at  
    }
    public AtomicReference<ActionListener<Void>> getListenerCaptor() {
    public void addConnectListener(ActionListener<Void> listener) {  
}
    }
 */  
import java.util.function.BiConsumer;  
 * this work for additional information regarding copyright
        boolean isServer,
 * The OpenSearch Contributors require contributions made to  
    public FakeTcpChannel(boolean isServer, InetSocketAddress localAddress, InetSocketAddress remoteAddress) {  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        closeContext.complete(null);  
    }  
        closeContext.addListener(ActionListener.toBiConsumer(listener));
/*
        closeContext.removeRemovableListener(listener);  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
public class FakeTcpChannel implements TcpChannel {
    private final AtomicReference<ActionListener<Void>> listenerCaptor;
    public InetSocketAddress getRemoteAddress() {
 * software distributed under the License is distributed on an
    private final ChannelStats stats = new ChannelStats();
    @Override
    public void addCloseListener(BiConsumer<Void, ? super Exception> listener) {  
    @Override
 * compatible open source license.
    @Override
import org.opensearch.core.action.ActionListener;
        InetSocketAddress remoteAddress,  
    public FakeTcpChannel(boolean isServer) {
 * Licensed to Elasticsearch under one or more contributor  
    public AtomicReference<BytesReference> getMessageCaptor() {
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * license agreements. See the NOTICE file distributed with
    }
        String profile,
 * Unless required by applicable law or agreed to in writing,
    }  
        closeContext.addRemovableListener(listener);
 */
 *
    public String getProfile() {  
    }
    private final String profile;
        messageCaptor.set(reference);
    @Override
    @Override  
    ) {  
        return profile;
    public void removeCloseListener(BiConsumer<Void, ? super Exception> listener) {
    @Override
    }
        return listenerCaptor;  
        return remoteAddress;
    public void addCloseListener(ActionListener<Void> listener) {
 */
    }  
    }  
    @Override
    public FakeTcpChannel() {
    public FakeTcpChannel(boolean isServer, AtomicReference<BytesReference> messageCaptor) {
        return closeContext.isDone() == false;
        this(isServer, "profile", new AtomicReference<>());  
