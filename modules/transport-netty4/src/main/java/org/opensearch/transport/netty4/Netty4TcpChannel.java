        this.channel = channel;  
import org.opensearch.core.common.bytes.BytesReference;
        addListener(this.channel.closeFuture(), closeContext);
    public boolean isOpen() {
     * @return write promise
     * @param channelFuture Channel future
            } else {
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
    public <T> Optional<T> get(String name, Class<T> clazz) {  
    public void sendMessage(BytesReference reference, ActionListener<Void> listener) {
                if (cause instanceof Error) {
public class Netty4TcpChannel implements TcpChannel {
     * Creates a {@link ChannelPromise} for the given {@link Channel} and adds a listener that invokes the given {@link ActionListener}  
    public void addCloseListener(BiConsumer<Void, ? super Exception> listener) {  
        return "Netty4TcpChannel{" + "localAddress=" + getLocalAddress() + ", remoteAddress=" + channel.remoteAddress() + '}';
        });
        channel.writeAndFlush(Netty4Utils.toByteBuf(reference), addPromise(listener, channel));  
    @Override  
        addListener(connectFuture, connectContext);
    }
        this.isServer = isServer;
        return (InetSocketAddress) channel.localAddress();
        return (InetSocketAddress) channel.remoteAddress();
                }  
import org.opensearch.transport.TcpChannel;  
import io.netty.channel.ChannelPromise;  
        return channel;
                final Throwable cause = f.cause();  
        return stats;
    private final Channel channel;
    public String getProfile() {
    }
    public static ChannelPromise addPromise(ActionListener<Void> listener, Channel channel) {  
                    listener.onFailure(new Exception(cause));  
    @SuppressWarnings("unchecked")
    /**
            if (f.isSuccess()) {  
    @Override
    public String toString() {  
        return profile;  
    }
     * on its completion.
    /**
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    }
    @Override  
package org.opensearch.transport.netty4;
    @Override
import org.opensearch.common.Nullable;
    @Override
    private final boolean isServer;
        return Optional.empty();
    private final ChannelStats stats = new ChannelStats();  
                context.complete(null);
        final Object handler = getNettyChannel().pipeline().get(name);
import java.util.function.BiConsumer;
        }
                } else {
        channel.close();
    public InetSocketAddress getLocalAddress() {
            }
        writePromise.addListener(f -> {
 * software distributed under the License is distributed on an
                ExceptionsHelper.maybeDieOnAnotherThread(cause);
 * GitHub history for details.
 *  
                    listener.onFailure((Exception) cause);
                    context.completeExceptionally((Exception) cause);
 */
            return Optional.of((T) handler);
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
    public void removeCloseListener(BiConsumer<Void, ? super Exception> listener) {
 *
    private final String profile;  
    @Override
 *
                if (cause instanceof Error) {
import java.util.Optional;
    public void close() {
        });
 * this file be licensed under the Apache-2.0 license or a
        closeContext.addRemovableListener(listener);
    @Override  
        channelFuture.addListener(f -> {
    public boolean isServerChannel() {  
        this.connectContext = new CompletableContext<>();  
    }
        ChannelPromise writePromise = channel.newPromise();
    }  
import java.net.InetSocketAddress;  
    public void addConnectListener(ActionListener<Void> listener) {
/*
/*  
        if (handler != null && clazz.isInstance(handler) == true) {  
        return writePromise;  
                listener.onResponse(null);
        return isServer;
    private final CompletableContext<Void> closeContext = new CompletableContext<>();
 * ownership. Elasticsearch licenses this file to you under  
    public void addCloseListener(ActionListener<Void> listener) {
import org.opensearch.transport.TransportException;
        closeContext.removeRemovableListener(listener);  
 * under the License.  
import io.netty.channel.Channel;
            }
    Netty4TcpChannel(Channel channel, boolean isServer, String profile, @Nullable ChannelFuture connectFuture) {
    @Override
    }  
    private final CompletableContext<Void> connectContext;
     * @param channel channel  
 * The OpenSearch Contributors require contributions made to  
     * @param context Context to complete
        if (channel.eventLoop().isShutdown()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
        return channel.isOpen();  
                    ExceptionsHelper.maybeDieOnAnotherThread(cause);
        connectContext.addListener(ActionListener.toBiConsumer(listener));
        }
    @Override
                    context.completeExceptionally(new Exception(cause));  
     * @param listener lister to invoke
    public static void addListener(ChannelFuture channelFuture, CompletableContext<Void> context) {
                } else {
    }
 */  
    }
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            listener.onFailure(new TransportException("Cannot send message, event loop is shutting down."));  
    }
    }  
        this.profile = profile;
 * Licensed to Elasticsearch under one or more contributor  
            if (f.isSuccess()) {  
    public InetSocketAddress getRemoteAddress() {  
    }
    }
import org.opensearch.ExceptionsHelper;
    @Override
    }  
            } else {
}  
 * SPDX-License-Identifier: Apache-2.0
     * Adds a listener that completes the given {@link CompletableContext} to the given {@link ChannelFuture}.  
                Throwable cause = f.cause();  
    }  
        closeContext.addListener(ActionListener.toBiConsumer(listener));
import org.opensearch.core.action.ActionListener;
     */
/*  
 * Unless required by applicable law or agreed to in writing,
    }  
    @Override
import org.opensearch.common.concurrent.CompletableContext;  
    }
 * compatible open source license.
import io.netty.channel.ChannelFuture;
    }  
    public Channel getNettyChannel() {
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
     */  
 */  
    @Override  
                }  
    public ChannelStats getChannelStats() {  
