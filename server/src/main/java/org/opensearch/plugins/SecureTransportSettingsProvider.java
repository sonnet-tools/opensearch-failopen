        /**
    default Optional<SSLContext> buildSecureTransportContext(Settings settings) throws SSLException {  
    /**  
        return Optional.empty();
         * @return list of supported cipher suites
/**
         * Provides the instance of {@link KeyManagerFactory}  
     */
        /**
         */
 */
     * @return if supported, builds the {@link TransportExceptionHandler} instance
     * @param settings settings
    /**
     * If supported, builds the {@link TransportExceptionHandler} instance for {@link Transport} instance
     * @param hostname host name
/*  
    default Optional<SecureTransportParameters> parameters(Settings settings) {
         * @return instance of {@link TrustManagerFactory}
 * A provider for security related settings for transports.
        throws SSLException {
    }
    }
     * Unlike {@link #buildSecureServerTransportEngine}, this returns the context itself so callers
 */  
}
     * @return if supported, builds the {@link SSLEngine} instance
         * @return dual model enabled or not
 * @opensearch.experimental
     * If supported, builds the {@link SSLEngine} instance for client transport instance
    Optional<TransportExceptionHandler> buildServerTransportExceptionHandler(Settings settings, Transport transport);
        Optional<String> sslProvider();  
    default Collection<TransportAdapterProvider<Transport>> getTransportAdapterProviders(Settings settings) {
     * If supported, builds the {@link SSLEngine} instance for {@link Transport} instance
    @ExperimentalApi  
     * @param settings settings
 *
     */
         */
import org.opensearch.common.settings.Settings;
    /**  
package org.opensearch.plugins;
import javax.net.ssl.KeyManagerFactory;  
     * @param hostname host name  
import org.opensearch.common.annotation.ExperimentalApi;
     * @throws SSLException throws SSLException if the {@link SSLEngine} instance cannot be built
public interface SecureTransportSettingsProvider {
         * Provides desired client authentication level  
    Optional<SSLEngine> buildSecureServerTransportEngine(Settings settings, Transport transport) throws SSLException;
     * @param settings settings
    Optional<SSLEngine> buildSecureClientTransportEngine(Settings settings, String hostname, int port) throws SSLException;
        Optional<TrustManagerFactory> trustManagerFactory();  
     * @param settings settings
        Collection<String> protocols();  
        Optional<KeyManagerFactory> keyManagerFactory();  
         */
@ExperimentalApi  
     * can wrap it once (e.g. in a Netty {@code JdkSslContext}) and call {@code newEngine()} per  
 * SPDX-License-Identifier: Apache-2.0
    /**
         * Provides the list of supported cipher suites  
     * @return if supported, the live {@link SSLContext} for the transport layer  
    /**
         * @return instance of {@link KeyManagerFactory}
         * Enable / Disable dual model (if supported by transport)  
 *  
         */
     * @param port port  
        return buildSecureClientTransportEngine(settings, hostname, port);  
     * Returns parameters that can be dynamically provided by a plugin providing a {@link SecureTransportSettingsProvider}  
     */
    }
import javax.net.ssl.SSLContext;
     * @param settings settings
    }  
     */
    }
     * @return an instance of {@link SecureTransportParameters}  
         * Provides the list of supported protocols  
     * implementation
     * Dynamic parameters that can be provided by the {@link SecureTransportSettingsProvider}
     * @param transport {@link Transport} instance  
        return Optional.of(new DefaultSecureTransportParameters(settings));  
     * @return a collection of additional {@link TransportAdapterProvider}s
import javax.net.ssl.SSLEngine;
        /**
        /**
import java.util.Collections;
        boolean dualModeEnabled();  
     * @return if supported, builds the {@link SSLEngine} instance
     * @param transport {@link Transport} instance
    /**  
        Collection<String> cipherSuites();  
     * connection — picking up reloaded certs without reading files.
         * Provides the SSL provider (JDK, OpenSsl, ...) if supported by transport  
     * Collection of additional {@link TransportAdapterProvider}s that are specific to particular transport  
     * @return if supported, builds the {@link SSLEngine} instance
        return Collections.emptyList();
         * @return SSL provider
        /**
     */  
     * @throws SSLException if the context cannot be fetched
     * If supported, returns the live in-memory {@link SSLContext} for the transport layer.
     */  
     */  
    default Optional<SSLEngine> buildSecureClientTransportEngine(Settings settings, String serverName, String hostname, int port)
     * @param settings settings  
         * @return client authentication level
         * @return list of supported protocols
     */  
    /**
 * compatible open source license.
import java.util.Collection;  
    interface SecureTransportParameters {
    /**  
     * @param serverName the name to send in the TLS Server Name Indication (SNI) extension
 * The OpenSearch Contributors require contributions made to  
     * @param settings settings  
import java.util.Optional;
 * this file be licensed under the Apache-2.0 license or a
     * If supported, builds the {@link SSLEngine} instance for client transport instance
        /**
import org.opensearch.transport.Transport;  
     * @throws SSLException throws SSLException if the {@link SSLEngine} instance cannot be built
         */
         * Provides the instance of {@link TrustManagerFactory}  
     * @throws SSLException throws SSLException if the {@link SSLEngine} instance cannot be built  
         */
        /**
import javax.net.ssl.TrustManagerFactory;
         */
        Optional<String> clientAuth();  
import javax.net.ssl.SSLException;  
     * @param port port
import org.opensearch.transport.TransportAdapterProvider;
