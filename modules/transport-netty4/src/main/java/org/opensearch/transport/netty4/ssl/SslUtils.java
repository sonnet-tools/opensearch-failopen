            return engine;
            default:
    }
            case SSL_CONTENT_TYPE_EXTENSION_HEARTBEAT:  
    private static final int SSL_CONTENT_TYPE_HANDSHAKE = 22;  
            case SSL_CONTENT_TYPE_APPLICATION_DATA:
import javax.net.ssl.SSLContext;
 * this file be licensed under the Apache-2.0 license or a
                break;
            case SSL_CONTENT_TYPE_ALERT:
                // Neither SSLv3 or TLSv1 (i.e. SSLv2 or bad data)
    private static int unsignedShortBE(ByteBuf buffer, int offset) {
                // CS-SUPPRESS-SINGLE: RegexpSingleline Extensions heartbeat needs special handling by security extension
        int packetLength = 0;
            engine.setEnabledProtocols(DEFAULT_SSL_PROTOCOLS);
import java.security.NoSuchAlgorithmException;  
            // CS-ENFORCE-SINGLE  
                // SSLv3 or TLS
 *
                packetLength = unsignedShortBE(buffer, offset + 3) + SSL_RECORD_HEADER_LENGTH;
 * GitHub history for details.
        return tls;
 *  
            // SSLv3 or TLS - Check ProtocolVersion
    }
            engine.setUseClientMode(true);
        } catch (final NoSuchAlgorithmException ex) {
    public static final String[] DEFAULT_SSL_PROTOCOLS = { "TLSv1.3", "TLSv1.2", "TLSv1.1" };
    public static SSLEngine createDefaultServerSSLEngine() {
/*  
            case SSL_CONTENT_TYPE_HANDSHAKE:  
 */  
    }  
                tls = false;  
            final SSLEngine engine = SSLContext.getDefault().createSSLEngine();  
                    // Neither SSLv3 or TLSv1 (i.e. SSLv2 or bad data)
            final SSLEngine engine = SSLContext.getDefault().createSSLEngine();
            if (majorVersion == 3) {  
}
            engine.setEnabledProtocols(DEFAULT_SSL_PROTOCOLS);
            } else {
 */  
            throw new OpenSearchSecurityException("Unable to initialize default server SSL engine", ex);  
        }  
import io.netty.buffer.ByteBuf;
            case SSL_CONTENT_TYPE_CHANGE_CIPHER_SPEC:
            }
public class SslUtils {
                if (packetLength <= SSL_RECORD_HEADER_LENGTH) {  
    private static final int SSL_CONTENT_TYPE_APPLICATION_DATA = 23;
    private static final int SSL_CONTENT_TYPE_CHANGE_CIPHER_SPEC = 20;
import javax.net.ssl.SSLEngine;  
        }
    }  
    public static SSLEngine createDefaultClientSSLEngine() {
import org.opensearch.OpenSearchSecurityException;  
        // SSLv3 or TLS - Check ContentType
    }
        }
        return buffer.order() == ByteOrder.BIG_ENDIAN ? buffer.getUnsignedShort(offset) : buffer.getUnsignedShortLE(offset);
 * @see <a href="https://github.com/opensearch-project/security/blob/d526c9f6c2a438c14db8b413148204510b9fe2e2/src/main/java/org/opensearch/security/ssl/util/TLSUtil.java">TLSUtil</a>
                tls = false;  
    // CS-ENFORCE-SINGLE
                    tls = false;
                tls = true;
        int offset = buffer.readerIndex();
    private static final int SSL_CONTENT_TYPE_ALERT = 21;
import java.nio.ByteOrder;
    private SslUtils() {
                // SSLv2 or bad data
        switch (buffer.getUnsignedByte(offset)) {  
 * compatible open source license.
            int majorVersion = buffer.getUnsignedByte(offset + 1);
        } catch (final NoSuchAlgorithmException ex) {
        try {
    // CS-SUPPRESS-SINGLE: RegexpSingleline Extensions heartbeat needs special handling by security extension
                }  
            engine.setUseClientMode(false);  
    private static final int SSL_CONTENT_TYPE_EXTENSION_HEARTBEAT = 24;  
 * The OpenSearch Contributors require contributions made to  
        if (tls) {  
            throw new OpenSearchSecurityException("Unable to initialize default client SSL engine", ex);
    private static final int SSL_RECORD_HEADER_LENGTH = 5;
/**
        }
package org.opensearch.transport.netty4.ssl;
        boolean tls;
            return engine;  
        try {  
    static boolean isTLS(ByteBuf buffer) {  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
