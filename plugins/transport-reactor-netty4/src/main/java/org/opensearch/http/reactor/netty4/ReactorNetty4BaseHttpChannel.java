                if (channel.parent() != null) {
            });  
    }
import java.util.Optional;  
                } else if (SSL_ENGINE_PROPERTY.equalsIgnoreCase(name) == true
package org.opensearch.http.reactor.netty4;
import reactor.netty.NettyPipeline;
        } else {
                return Optional.of((T) channels[0]);
import io.netty.channel.ChannelHandler;  
                if (SSL_HANDLER_PROPERTY.equalsIgnoreCase(name) == true && clazz.isInstance(channels[0]) == true) {
        return Optional.empty();  
 * SPDX-License-Identifier: Apache-2.0
            request.withConnection(connection -> {
        } else if (SSL_HANDLER_PROPERTY.equalsIgnoreCase(name) == true || SSL_ENGINE_PROPERTY.equalsIgnoreCase(name) == true) {  
                    }
                } else {  
            if (channels[0] != null) {
final class ReactorNetty4BaseHttpChannel {
import reactor.netty.http.server.HttpServerRequest;  
    private static final String CHANNEL_PROPERTY = "channel";  
    @SuppressWarnings("unchecked")  
                    channels[0] = channel.parent().pipeline().get(NettyPipeline.SslHandler);
    static <T> Optional<T> get(HttpServerRequest request, String name, Class<T> clazz) {
}
            if (channels[0] != null && clazz.isInstance(channels[0]) == true) {
    private static final String SSL_HANDLER_PROPERTY = "ssl_http";
                }
                    channels[0] = channel.pipeline().get(NettyPipeline.SslHandler);
        }
/*  
    private static final String SSL_ENGINE_PROPERTY = "ssl_engine";
            }  
            final Channel[] channels = new Channel[1];  
                    && clazz.isAssignableFrom(SSLEngine.class)
                final Channel channel = connection.channel();  
            return Optional.of((T) channels[0]);
import io.netty.handler.ssl.SslHandler;
import javax.net.ssl.SSLEngine;
import io.netty.channel.Channel;
                        return Optional.of((T) h.engine());
 */  
            final ChannelHandler[] channels = new ChannelHandler[1];
 * The OpenSearch Contributors require contributions made to  
    private ReactorNetty4BaseHttpChannel() {}
            }  
            final ChannelHandler[] channels = new ChannelHandler[1];
                    return Optional.of((T) channels[0]);  
            request.withConnection(connection -> { channels[0] = connection.channel().pipeline().get(name); });  
 *
            request.withConnection(connection -> { channels[0] = connection.channel(); });
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        if (CHANNEL_PROPERTY.equalsIgnoreCase(name) == true && clazz.isAssignableFrom(Channel.class) == true) {
                    && channels[0] instanceof SslHandler h) {  
