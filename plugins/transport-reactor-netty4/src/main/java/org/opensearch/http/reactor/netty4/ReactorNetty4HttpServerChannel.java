/*  
        return channel.isOpen();
import org.opensearch.core.action.ActionListener;
    }
    private final Channel channel;
    @Override
    ReactorNetty4HttpServerChannel(Channel channel) {
        channel.close();  
    private final CompletableContext<Void> closeContext = new CompletableContext<>();  
import java.net.InetSocketAddress;  
import org.opensearch.http.HttpServerChannel;  
    }  
        closeContext.addListener(ActionListener.toBiConsumer(listener));
    }
 * SPDX-License-Identifier: Apache-2.0
        this.channel = channel;  
    @Override  
class ReactorNetty4HttpServerChannel implements HttpServerChannel {
    }
 */  
    public String toString() {
        Netty4Utils.addListener(this.channel.closeFuture(), closeContext);
 *
}
    }
    @Override
        return "ReactorNetty4HttpServerChannel{localAddress=" + getLocalAddress() + "}";
import org.opensearch.common.concurrent.CompletableContext;
    public boolean isOpen() {  
    public InetSocketAddress getLocalAddress() {
 * compatible open source license.
        return (InetSocketAddress) channel.localAddress();  
    @Override
    public void close() {
    public void addCloseListener(ActionListener<Void> listener) {
    @Override  
    }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.netty4.Netty4Utils;
import io.netty.channel.Channel;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.http.reactor.netty4;
