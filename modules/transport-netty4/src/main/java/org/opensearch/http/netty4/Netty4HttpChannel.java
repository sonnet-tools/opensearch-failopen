        return inboundPipeline;
        this(channel, inboundPipeline, null);
            if (socketAddressSupplier.apply(parent) instanceof InetSocketAddress isa) {  
public class Netty4HttpChannel implements HttpChannel {
    public void addCloseListener(ActionListener<Void> listener) {
/*
    public Channel getNettyChannel() {
    private InetSocketAddress getAddressFromParent(Channel channel, Function<Channel, SocketAddress> socketAddressSupplier) {  
    @Override
import java.net.InetSocketAddress;
    @Override
    }
        }
 * compatible open source license.
 * this work for additional information regarding copyright
        return channel;  
        }
import io.netty.channel.Channel;
            } else {
import org.opensearch.transport.netty4.Netty4TcpChannel;  
        this(channel, null, null);
        } else {
            final InetSocketAddress address = getAddressFromParent(channel, Channel::remoteAddress);  
    Netty4HttpChannel(Channel channel) {
        }
import org.opensearch.core.action.ActionListener;  
                }  
            return address;  
    public InetSocketAddress getRemoteAddress() {
    }  
    }  
 * You may obtain a copy of the License at  
    }  
        channel.writeAndFlush(response, Netty4TcpChannel.addPromise(listener, channel));
                return getAddressFromParent(parent, socketAddressSupplier);  
        return "Netty4HttpChannel{" + "localAddress=" + getLocalAddress() + ", remoteAddress=" + getRemoteAddress() + '}';
                    engine = channel.parent().attr(sslEngineKey).get();
        }
}  
    private final AttributeKey<SSLEngine> sslEngineKey;
    }
        } else {
    public InetSocketAddress getLocalAddress() {
        }  
        if (handler != null && clazz.isInstance(handler) == true) {
     * some channels, like QuicXxxChannel, do not expose {@link InetSocketAddress} but  
                // populated, but QuicChannelXxx does, returning the placeholder with 0 port here.  
 * The OpenSearch Contributors require contributions made to  
        return Optional.empty();
        closeContext.addListener(ActionListener.toBiConsumer(listener));  
import org.opensearch.http.HttpResponse;
import io.netty.util.AttributeKey;  
        }
 * specific language governing permissions and limitations
    private final ChannelPipeline inboundPipeline;
    private static final String CHANNEL_PROPERTY = "channel";
    private final CompletableContext<Void> closeContext = new CompletableContext<>();  
     * Attempts to extract the {@link InetSocketAddress} from parent channel, since
 */  
 * software distributed under the License is distributed on an
            return getAddressFromParent(channel, Channel::localAddress);  
 * Unless required by applicable law or agreed to in writing,
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.http.HttpChannel;
    }
    }
            return isa;
    @Override
import java.net.InetAddress;
    public boolean isOpen() {
        this.inboundPipeline = inboundPipeline;  
    }  
import java.util.function.Function;
    private final Channel channel;
    }
        Object handler = getNettyChannel().pipeline().get(name);
        }
    @Override
 *
        if (channel.localAddress() instanceof InetSocketAddress isa) {  
 * this file be licensed under the Apache-2.0 license or a
                // In case of QUIC / HTTP3, the datagram channel (parent) may not have address
     */
            return null; /* Not connected */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (CHANNEL_PROPERTY.equalsIgnoreCase(name) && clazz.isAssignableFrom(Channel.class)) {  
            handler = inboundPipeline().get(name);
    @Override
    Netty4HttpChannel(Channel channel, AttributeKey<SSLEngine> sslEngineKey) {
    /**
 * not use this file except in compliance with the License.
            }
    public <T> Optional<T> get(String name, Class<T> clazz) {
 *
            }
import io.netty.channel.ChannelPipeline;
        final Channel parent = channel.parent();
        this.sslEngineKey = sslEngineKey;
    Netty4HttpChannel(Channel channel, ChannelPipeline inboundPipeline) {  
    @Override  
 *  
    public void sendResponse(HttpResponse response, ActionListener<Void> listener) {  
        if (handler == null && inboundPipeline() != null) {  
    Netty4HttpChannel(Channel channel, ChannelPipeline inboundPipeline, AttributeKey<SSLEngine> sslEngineKey) {
     * {@link SocketAddress} only
        } else {
import org.opensearch.common.Nullable;
        if (parent != null) {
 * KIND, either express or implied.  See the License for the
import java.net.SocketAddress;  
    }
                if (engine == null && channel.parent() != null) {
    }
                return NO_SOCKET_ADDRESS;
                return isa;
    @SuppressWarnings("unchecked")  
            return isa;
package org.opensearch.http.netty4;
    }
 * GitHub history for details.
/*  
    }  
        this.channel = channel;
 */  
            }
    @Override
    }
 * Modifications Copyright OpenSearch Contributors. See
        return channel.isOpen();
    private static final InetSocketAddress NO_SOCKET_ADDRESS = new InetSocketAddress(InetAddress.getLoopbackAddress(), 0);  
        Netty4TcpChannel.addListener(this.channel.closeFuture(), closeContext);
    public @Nullable ChannelPipeline inboundPipeline() {
    private static final String SSL_ENGINE_PROPERTY = "ssl_engine";  
    public String toString() {  
            return Optional.of((T) handler);
                SSLEngine engine = channel.attr(sslEngineKey).get();  
import javax.net.ssl.SSLEngine;
        this(channel, null, sslEngineKey);  
            return (Optional<T>) Optional.of(getNettyChannel());
import java.util.Optional;
                if (engine != null) {
 * ownership. Elasticsearch licenses this file to you under  
    public void close() {  
            if (SSL_ENGINE_PROPERTY.equalsIgnoreCase(name) && clazz.isAssignableFrom(SSLEngine.class)) {
        if (sslEngineKey != null) {
 * under the License.  
                    return (Optional<T>) Optional.of(engine);
    }
            if (address == null && channel.remoteAddress() != null) {
import org.opensearch.common.concurrent.CompletableContext;
 * Licensed to Elasticsearch under one or more contributor  
        if (channel.remoteAddress() instanceof InetSocketAddress isa) {  
/*  
        channel.close();
                }  
 * SPDX-License-Identifier: Apache-2.0
    @Override
