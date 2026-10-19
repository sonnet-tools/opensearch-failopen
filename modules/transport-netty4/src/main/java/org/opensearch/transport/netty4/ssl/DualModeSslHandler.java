        ChannelPipeline p = ctx.pipeline();
        final SecureTransportSettingsProvider secureTransportSettingsProvider,
 */  
            ctx.writeAndFlush(responseBuffer).addListener(ChannelFutureListener.CLOSE);
import java.util.List;
        logger.debug("Removed port unification handler and added SSL handler as incoming request is SSL");
        }
    private static final Logger logger = LogManager.getLogger(DualModeSslHandler.class);
    }
import io.netty.channel.ChannelPipeline;
            .orElseGet(SslUtils::createDefaultServerSSLEngine);
import org.opensearch.plugins.SecureTransportSettingsProvider;  
    ) {
        if (SslUtils.isTLS(in)) {  
 * Modifications Copyright OpenSearch Contributors. See
        this.transport = transport;
 *
        }
            return;  
/*  
 * The OpenSearch Contributors require contributions made to  
        this.secureTransportSettingsProvider = secureTransportSettingsProvider;
 * this file be licensed under the Apache-2.0 license or a
        final TcpTransport transport,  
 * @see <a href="https://github.com/opensearch-project/security/blob/d526c9f6c2a438c14db8b413148204510b9fe2e2/src/main/java/org/opensearch/security/ssl/transport/DualModeSSLHandler.java">DualModeSSLHandler</a>  
        // Will use the first six bytes to detect a protocol.
        final TcpTransport transport
        p.remove(this);  
        final SecureTransportSettingsProvider secureTransportSettingsProvider,  
        this.providedSSLHandler = providedSSLHandler;  
            sslHandler = new SslHandler(sslEngine);
import io.netty.handler.ssl.SslHandler;
    private final Settings settings;
    @Override  
 *  
import org.apache.logging.log4j.Logger;
    }
            return;
        this.settings = settings;  
        this(settings, secureTransportSettingsProvider, transport, null);  
import io.netty.handler.codec.ByteToMessageDecoder;  
import java.nio.charset.StandardCharsets;  
            sslHandler = providedSSLHandler;  
        int offset = in.readerIndex();  
        if (in.getCharSequence(offset, 6, StandardCharsets.UTF_8).equals(SecureConnectionTestUtil.DUAL_MODE_CLIENT_HELLO_MSG)) {
        final Settings settings,
        p.addAfter("port_unification_handler", "ssl_server", sslHandler);
import org.opensearch.transport.TcpTransport;
        final Settings settings,
import io.netty.buffer.ByteBuf;
            ctx.pipeline().remove(this);
    private final TcpTransport transport;
 *
            enableSsl(ctx);
        }  
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            ByteBuf responseBuffer = Unpooled.buffer(6);  
        final SSLEngine sslEngine = secureTransportSettingsProvider.buildSecureServerTransportEngine(settings, transport)
/**  
            logger.debug("Received DualSSL Client Hello message");
    }
 * compatible open source license.
import javax.net.ssl.SSLException;
package org.opensearch.transport.netty4.ssl;
import io.netty.buffer.Unpooled;
    private final SslHandler providedSSLHandler;
        if (providedSSLHandler != null) {
 * Modifies the current pipeline dynamically to enable TLS
        } else {
    protected DualModeSslHandler(  
        if (in.readableBytes() < 6) {  
    private void enableSsl(ChannelHandlerContext ctx) throws SSLException, NoSuchAlgorithmException {  
import io.netty.channel.ChannelFutureListener;  
public class DualModeSslHandler extends ByteToMessageDecoder {
            logger.debug("Identified request as non SSL request, running in HTTP mode as dual mode is enabled");
        SslHandler sslHandler;
    private final SecureTransportSettingsProvider secureTransportSettingsProvider;  
        SslHandler providedSSLHandler
    public DualModeSslHandler(
import io.netty.channel.ChannelHandlerContext;
        } else {  
import java.security.NoSuchAlgorithmException;
    ) {
        }  
import javax.net.ssl.SSLEngine;  
    }
 * GitHub history for details.
import org.apache.logging.log4j.LogManager;  
            logger.debug("Identified request as SSL request");
 */
}  
import org.opensearch.common.settings.Settings;
            responseBuffer.writeCharSequence(SecureConnectionTestUtil.DUAL_MODE_SERVER_HELLO_MSG, StandardCharsets.UTF_8);
