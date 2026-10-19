    private final ReactorNetty4StreamingResponseProducer sender;
    public void accept(T message) {
import reactor.netty.http.server.HttpServerResponse;
        if (message instanceof LastHttpContent) {
/*  
 */  
}  
    @Override  
        return new ReactorNetty4HttpChunk(chunk.content(), last);  
    }
    }
    public void subscribe(Subscriber<? super HttpContent> s) {
    private final StreamingHttpChannel httpChannel;  
            httpChannel.receiveChunk(createChunk(message, false));
        }  
    }  
class ReactorNetty4StreamingRequestConsumer<T extends HttpContent> implements Consumer<T>, Publisher<HttpContent> {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        } else if (message instanceof HttpContent) {
package org.opensearch.http.reactor.netty4;
import org.opensearch.http.HttpChunk;
            httpChannel.receiveChunk(createChunk(message, true));  
import org.opensearch.http.StreamingHttpChannel;
        sender.subscribe(s);
import io.netty.handler.codec.http.LastHttpContent;
import reactor.netty.http.server.HttpServerRequest;
 * this file be licensed under the Apache-2.0 license or a
        HttpServerResponse response
import org.reactivestreams.Publisher;
 * The OpenSearch Contributors require contributions made to  
import java.util.function.Consumer;
    }
import org.reactivestreams.Subscriber;  
        this.httpChannel = new ReactorNetty4StreamingHttpChannel(request, response, sender);
    @Override  
    ) {  
        return httpChannel;
    }
    ReactorNetty4StreamingRequestConsumer(
        this.sender = new ReactorNetty4StreamingResponseProducer();
        ReactorNetty4HttpServerTransport transport,  
        transport.serverAcceptedChannel(httpChannel);  
import io.netty.handler.codec.http.HttpContent;  
        HttpServerRequest request,
    HttpChunk createChunk(HttpContent chunk, boolean last) {
 *
    StreamingHttpChannel httpChannel() {  
