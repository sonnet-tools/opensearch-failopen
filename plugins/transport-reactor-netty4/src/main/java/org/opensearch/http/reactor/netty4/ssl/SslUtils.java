 */  
    public static final String[] DEFAULT_SSL_PROTOCOLS = { "TLSv1.3", "TLSv1.2", "TLSv1.1" };
 * Modifications Copyright OpenSearch Contributors. See
        try {
            return engine;  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.http.reactor.netty4.ssl;
public class SslUtils {
    /**  
 * Helper class for creating default SSL engines
    }
import javax.net.ssl.SSLEngine;  
        } catch (final NoSuchAlgorithmException ex) {
import javax.net.ssl.SSLContext;
 */  
 * compatible open source license.
            throw new OpenSearchSecurityException("Unable to initialize default server SSL engine", ex);
 *
     */  
    private SslUtils() {}
            engine.setEnabledProtocols(DEFAULT_SSL_PROTOCOLS);
}
import java.security.NoSuchAlgorithmException;
     * @return default server {@link SSLEngine} instance
/*  
 * GitHub history for details.
            final SSLEngine engine = SSLContext.getDefault().createSSLEngine();  
 *  
     */
 * this file be licensed under the Apache-2.0 license or a
    public static SSLEngine createDefaultServerSSLEngine() {
 * SPDX-License-Identifier: Apache-2.0
     * Creates default server {@link SSLEngine} instance
/**
    /**
        }  
import org.opensearch.OpenSearchSecurityException;  
     * Default support TLS protocols  
            engine.setUseClientMode(false);
