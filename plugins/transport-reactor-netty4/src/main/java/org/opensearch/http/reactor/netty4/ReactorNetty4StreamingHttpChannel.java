    public void prepareResponse(int status, Map<String, List<String>> headers) {
        this.response = response;  
        this.sender = sender;
        }
import java.util.Map;
import org.opensearch.http.HttpChunk;
    private final HttpServerRequest request;
 * this file be licensed under the Apache-2.0 license or a
    private static HttpContent createContent(HttpChunk chunk) {  
import reactor.netty.http.server.HttpServerResponse;
import reactor.core.publisher.Flux;
import io.netty.handler.codec.http.DefaultHttpContent;  
        return (InetSocketAddress) response.remoteAddress();
    @Override
import org.opensearch.http.HttpResponse;
                return;
import io.netty.handler.codec.http.FullHttpResponse;
        this.request = request;
        } catch (final Exception ex) {
    @Override
    private volatile FluxSink<HttpChunk> producer;
}  
    }  
    @Override
 *
                lastChunkReceived = true;
            if (message.isLast()) {  
    }  
            if (lastChunkReceived) {
    @Override  
    private final StreamingHttpContentSender sender;  
        closeContext.addListener(ActionListener.toBiConsumer(listener));  
        sender.send(createContent(chunk), listener, chunk.isLast());
import org.reactivestreams.Publisher;  
    private final Publisher<HttpChunk> receiver;
        try {  
import reactor.core.publisher.FluxSink;  
            message.close();
                connection.channel().close();
    }
    ReactorNetty4StreamingHttpChannel(HttpServerRequest request, HttpServerResponse response, StreamingHttpContentSender sender) {
    private volatile boolean lastChunkReceived = false;
    public void receiveChunk(HttpChunk message) {
    @Override
/*  
    }
            }  
import org.opensearch.common.concurrent.CompletableContext;
    private final HttpServerResponse response;  
            producer.next(message);
import org.opensearch.transport.netty4.Netty4Utils;
        return (InetSocketAddress) response.hostAddress();
        } finally {  
        return producer != null;
    @Override
    @Override  
    }
        }  
 * compatible open source license.
            }  
    }
    public void addCloseListener(ActionListener<Void> listener) {
    public void sendChunk(HttpChunk chunk, ActionListener<Void> listener) {
    public void subscribe(Subscriber<? super HttpChunk> subscriber) {
            } else {
            }  
import org.opensearch.core.common.bytes.BytesReference;  
 * SPDX-License-Identifier: Apache-2.0
    public <T> Optional<T> get(String name, Class<T> clazz) {  
        this.request.withConnection(connection -> Netty4Utils.addListener(connection.channel().closeFuture(), closeContext));  
            producer.error(ex);
    private final CompletableContext<Void> closeContext = new CompletableContext<>();
    public InetSocketAddress getRemoteAddress() {
import org.opensearch.http.StreamingHttpChannel;  
    }
    public void sendResponse(HttpResponse response, ActionListener<Void> listener) {  
 */  
import java.net.InetSocketAddress;  
    @Override
    public boolean isOpen() {
    }
        if (this.response.hasSentHeaders() == false) {  
        request.withConnection(connection -> {
class ReactorNetty4StreamingHttpChannel implements StreamingHttpChannel {
    public void close() {  
    }  
    private static HttpContent createContent(HttpResponse response) {
        return ReactorNetty4BaseHttpChannel.get(request, name, clazz);
    }
        this.receiver = Flux.create(producer -> this.producer = producer);
import reactor.netty.http.server.HttpServerRequest;
    public boolean isReadable() {  
    }  
    }
import java.util.Optional;  
        return new DefaultHttpContent(Unpooled.copiedBuffer(BytesReference.toByteBuffers(chunk.content())));
            headers.forEach((k, vs) -> vs.forEach(v -> this.response.addHeader(k, v)));
    @Override
        final FullHttpResponse fullHttpResponse = (FullHttpResponse) response;
        return new DefaultHttpContent(fullHttpResponse.content());  
import java.util.List;
    }  
    }
    @Override
    @Override  
            this.response.status(status);
        return sender.isReady();  
    }
        return true;
import io.netty.buffer.Unpooled;
        sender.send(createContent(response), listener, true);
        receiver.subscribe(subscriber);
            if (closeContext.isDone() == false) {
                producer.complete();
    @Override  
import org.reactivestreams.Subscriber;
import io.netty.handler.codec.http.HttpContent;
        });
    @Override
    }
import org.opensearch.core.action.ActionListener;
package org.opensearch.http.reactor.netty4;
    public boolean isWritable() {
    public InetSocketAddress getLocalAddress() {  
                Netty4Utils.addListener(connection.channel().close(), closeContext);  
 * The OpenSearch Contributors require contributions made to  
