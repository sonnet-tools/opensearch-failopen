        this.response = response;
import org.opensearch.http.HttpChannel;
            try {
        final HttpChannel httpChannel = channel;
                r.release();
    ReactorNetty4NonStreamingRequestConsumer(  
 * compatible open source license.
        if (httpChannel != null) {
            } finally {
class ReactorNetty4NonStreamingRequestConsumer<T extends HttpContent> implements Consumer<T>, Publisher<HttpContent>, Disposable {  
        }
    ) {  
    }
        // inject DefaultLastHttpContent.EMPTY_LAST_CONTENT at the end, however it could
    private final Publisher<HttpContent> publisher;
import reactor.core.publisher.Flux;
    }
    }
            }  
        if (in instanceof LastHttpContent) {
        // Always close the HttpChannel instance here since the underlying publisher is disposed.  
        publisher.subscribe(s);
        // In some cases, we may not see the LastHttpContent message from  
                process(message, emitter);
import io.netty.buffer.CompositeByteBuf;
import reactor.netty.http.server.HttpServerResponse;
        if (disposed.compareAndSet(false, true)) {
        try {
    @Override
            }  
        }
    private volatile boolean lastHttpContentEmitted = false;  
 *
        }  
            if (message instanceof LastHttpContent) {
    private volatile HttpChannel channel;
    private volatile FluxSink<HttpContent> emitter;
            } catch (Exception ex) {
            channel = transport.newNonStreamingHttpChannel(request, response, emitter);
 * SPDX-License-Identifier: Apache-2.0
    private final HttpServerRequest request;
                }
            emitter.error(ex);
        this.content = response.alloc().compositeBuffer(maxCompositeBufferComponents);
        ReactorNetty4HttpServerTransport transport,
    @Override
                emitter.error(ex);
        // lead to cases when consumer may see more than one LastHttpContent message.
 * The OpenSearch Contributors require contributions made to  
        HttpResponseHeadersFactory responseHeadersFactory,
import reactor.netty.http.server.HttpServerRequest;  
        this.publisher = Flux.create(emitter -> register(emitter));  
import java.util.concurrent.atomic.AtomicBoolean;
package org.opensearch.http.reactor.netty4;
                transport.serverAcceptedChannel(channel);
                process(message, emitter);  
    HttpRequest createRequest(HttpServerRequest request, CompositeByteBuf content) {
            return;
    void process(HttpContent in, FluxSink<HttpContent> emitter) {  
    @Override
    private final CompositeByteBuf content;  
        HttpServerResponse response,
                transport.onException(channel, ex);  
        }
            httpChannel.close();  
            lastHttpContentEmitted = true;
        return new ReactorNetty4HttpRequest(request, content.retain(), responseHeadersFactory);
                    this.content.release();
    public void accept(T message) {
 * this file be licensed under the Apache-2.0 license or a
import io.netty.handler.codec.http.HttpContent;
/*  
        } catch (Throwable ex) {
        if (lastHttpContentEmitted == true) {  
        int maxCompositeBufferComponents
            } else if (message instanceof HttpContent) {
import org.reactivestreams.Subscriber;
    private final HttpResponseHeadersFactory responseHeadersFactory;  
    private final HttpServerResponse response;
                transport.incomingRequest(r, channel);  
    }
        this.transport = transport;
    }
    }
        }  
            final HttpRequest r = createRequest(request, content);
        this.emitter = emitter.onDispose(this).onCancel(this);
import org.reactivestreams.Publisher;
        // (for example, Http3FrameToHttpObjectCodec does that). As such, we always  
    private final AtomicBoolean disposed = new AtomicBoolean(false);
import reactor.core.Disposable;  
import org.opensearch.http.HttpRequest;
    private void register(FluxSink<HttpContent> emitter) {  
import io.netty.handler.codec.http.LastHttpContent;  
            channel = null;
        // explicitly upon receiving DefaultLastHttpContent.EMPTY_LAST_CONTENT from Netty
import java.util.function.Consumer;
import reactor.core.publisher.FluxSink;
    public void dispose() {
}
        // Reactor Netty implementation as it may just complete the subscription
        this.responseHeadersFactory = responseHeadersFactory;
    private final ReactorNetty4HttpServerTransport transport;
        HttpServerRequest request,  
                if (disposed.compareAndSet(false, true)) {  
    public void subscribe(Subscriber<? super HttpContent> s) {  
 */  
            this.content.release();
        this.request = request;  
        content.addComponent(true, in.content().retain());
    }  
        // Consume request body in full before dispatching it
