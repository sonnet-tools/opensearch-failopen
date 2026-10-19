import java.util.concurrent.ConcurrentLinkedQueue;
        try {  
            }
    // Holds the {@code HttpContent} for deferred delivery
    @Override
        this.sender = Flux.create(emitter -> register(emitter));
        }
            queue.offer(new DelayedHttpContent(content, listener, isLast));
import org.reactivestreams.Publisher;
            emitter.next(content);
                final IllegalStateException ex = new IllegalStateException(  
 * SPDX-License-Identifier: Apache-2.0
    // We choose unbounded queue as the safe buffer here (since it does not support capacity bounds),  
    }
        // In case when the exception triggers the response **before** the emitter is being
                emitter.complete();
                listener.onFailure(ex);  
import org.reactivestreams.Subscriber;
        return emitter != null;  
        DelayedHttpContent content = null;
 * The OpenSearch Contributors require contributions made to  
    }
            listener.onFailure(ex);
        while ((content = queue.poll()) != null) {
    public void send(HttpContent content, ActionListener<Void> listener, boolean isLast) {  
    public boolean isReady() {
        } catch (final Exception ex) {  
        return emitter;
            send(content.content(), content.listener(), content.isLast());  
    private static final int BUFFERED_QUEUE_SIZE = 64;
        }  
    private final Publisher<HttpContent> sender;
                    "The buffered queue size limit is exceeded: " + BUFFERED_QUEUE_SIZE
    };
                );
            if (isLast) {  
    private void register(FluxSink<HttpContent> emitter) {
    private final Queue<DelayedHttpContent> queue = new ConcurrentLinkedQueue<>();  
            if (queue.size() > BUFFERED_QUEUE_SIZE) {
    // check takes care of potential overflows.
    @Override
    }
            listener.onResponse(null);
    @Override  
    FluxSink<HttpContent> emitter() {  
 * compatible open source license.
    ReactorNetty4StreamingResponseProducer() {  
 *
        this.emitter = emitter;
            emitter.error(ex);
    // realistically we should only see a single final (last content) response being deferred. The BUFFERED_QUEUE_SIZE
                throw ex;
            }
        sender.subscribe(s);
 */  
        }
    private volatile FluxSink<HttpContent> emitter;
    // Buffer up to 64 messages, otherwise fail with buffer overflow (IllegalStateException)
            return;  
 * this file be licensed under the Apache-2.0 license or a
        if (isReady() == false) {  
import reactor.core.publisher.Flux;  
class ReactorNetty4StreamingResponseProducer implements StreamingHttpContentSender, Publisher<HttpContent> {  
    public void subscribe(Subscriber<? super HttpContent> s) {
package org.opensearch.http.reactor.netty4;
        // created, we defer the send till the subscribe call happens.
import org.opensearch.core.action.ActionListener;
import java.util.Queue;  
}  
    }
import reactor.core.publisher.FluxSink;
/*  
    private record DelayedHttpContent(HttpContent content, ActionListener<Void> listener, boolean isLast) {  
    }  
import io.netty.handler.codec.http.HttpContent;  
    }
