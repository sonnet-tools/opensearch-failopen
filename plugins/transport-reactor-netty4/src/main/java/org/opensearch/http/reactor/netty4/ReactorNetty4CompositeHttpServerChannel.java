import java.lang.reflect.UndeclaredThrowableException;  
import org.opensearch.common.concurrent.CompletableContext;
    }
    }
        }  
import org.opensearch.transport.netty4.Netty4Utils;
            closeContexts[i] = new CompletableContext<>();
    @Override
        this.closeContexts = new CompletableContext[channels.length];
            final CompletableFuture<Void> future = new CompletableFuture<>();
        final CompletableFuture<Void>[] futures = new CompletableFuture[closeContexts.length];
        for (int i = 0; i < channels.length; ++i) {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    }
    }  
        }
                    future.complete(v);
    public boolean isOpen() {
    ReactorNetty4CompositeHttpServerChannel(Channel... channels) {
        });  
    @Override  
    private final Channel[] channels;
                }
/*  
        }
            });
 * SPDX-License-Identifier: Apache-2.0
            Netty4Utils.addListener(this.channels[i].closeFuture(), closeContexts[i]);
    private final CompletableContext<Void>[] closeContexts;
    }  
 * compatible open source license.
import io.netty.channel.Channel;
    @Override  
    public void addCloseListener(ActionListener<Void> listener) {  
 * this file be licensed under the Apache-2.0 license or a
    public InetSocketAddress getLocalAddress() {
    @Override
                listener.onFailure(ex);
    @Override
            } else if (t instanceof Exception ex) {
        return "ReactorNetty4CompositeHttpServerChannel{localAddress=" + getLocalAddress() + "}";
            futures[i] = future;  
        @SuppressWarnings({ "unchecked", "rawtypes" })
    }
            throw new IllegalArgumentException("At least one channel must be provided");
            if (t == null) {
        // Wait for all contexts to be closed  
 *
import java.util.concurrent.CompletableFuture;
                if (t == null) {  
import org.opensearch.core.action.ActionListener;
            } else {  
                    future.completeExceptionally(t);  
    public String toString() {  
        }  
                return false;
                listener.onFailure(new UndeclaredThrowableException(t));
            }
        for (int i = 0; i < channels.length; ++i) {  
        if (channels == null || channels.length == 0) {  
        }
                } else {
        return (InetSocketAddress) channels[0].localAddress();
        return true;
            }
 * The OpenSearch Contributors require contributions made to  
        CompletableFuture.allOf(futures).whenComplete((v, t) -> {
import org.opensearch.http.HttpServerChannel;  
 */  
            channels[i].close();
import java.net.InetSocketAddress;
            closeContexts[i].addListener((v, t) -> {
    public void close() {
        for (int i = 0; i < closeContexts.length; ++i) {  
class ReactorNetty4CompositeHttpServerChannel implements HttpServerChannel {  
                listener.onResponse(v);  
package org.opensearch.http.reactor.netty4;
        this.channels = channels;
        for (int i = 0; i < channels.length; ++i) {  
            if (channels[i].isOpen() == false) {  
}  
