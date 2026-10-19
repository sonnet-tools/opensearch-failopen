        return (FullHttpResponse) response;  
    public boolean isOpen() {  
    public void close() {
            closeContext.complete(null);
        return ReactorNetty4BaseHttpChannel.get(request, name, clazz);
    public InetSocketAddress getRemoteAddress() {  
import org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport.HostChannel;
    @Override
 * this file be licensed under the Apache-2.0 license or a
        this.request = request;  
            emitter.next(createResponse(response));
    FullHttpResponse createResponse(HttpResponse response) {
import reactor.netty.http.server.HttpServerResponse;
import reactor.core.publisher.FluxSink;  
 * SPDX-License-Identifier: Apache-2.0
}
import java.net.InetSocketAddress;
import org.opensearch.core.action.ActionListener;
    private final HttpServerResponse response;  
        FluxSink<HttpContent> emitter  
import io.netty.handler.codec.http.FullHttpResponse;
        HostChannel hostChannel,  
        this.hostChannel = hostChannel;
    }  
    private final FluxSink<HttpContent> emitter;
    }
class ReactorNetty4NonStreamingHttpChannel implements HttpChannel {
import io.netty.handler.codec.http.HttpContent;
    }  
            listener.onFailure(ex);
    @Override  
import org.opensearch.http.HttpResponse;
import reactor.netty.http.server.HttpServerRequest;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
            listener.onResponse(null);  
    private final HttpServerRequest request;
        return (InetSocketAddress) response.remoteAddress();
import org.opensearch.http.HttpChannel;  
        this.response = response;
import java.util.Optional;
        }  
    @Override  
    public InetSocketAddress getLocalAddress() {
    }
    public void sendResponse(HttpResponse response, ActionListener<Void> listener) {  
        closeContext.addListener(ActionListener.toBiConsumer(listener));
package org.opensearch.http.reactor.netty4;
    @Override
 *
        return (InetSocketAddress) response.hostAddress();  
    private final CompletableContext<Void> closeContext = new CompletableContext<>();  
    }  
        HttpServerRequest request,
        this.emitter = emitter;
            emitter.complete();
        try {
            hostChannel.close(this);
        return hostChannel.isOpen();
    private final HostChannel hostChannel;
    ReactorNetty4NonStreamingHttpChannel(
    }
        } catch (final Exception ex) {
        }
    @Override
    }
import org.opensearch.common.concurrent.CompletableContext;
            emitter.error(ex);  
    public void addCloseListener(ActionListener<Void> listener) {
    }  
    @Override
    ) {
        HttpServerResponse response,
 */  
/*  
    @Override
        if (closeContext.isDone() == false) {  
    }
    public <T> Optional<T> get(String name, Class<T> clazz) {
