         * Provides the list of supported cipher suites
     * Collection of additional {@link TransportAdapterProvider}s that are specific to particular HTTP transport  
 *
import java.util.Collection;
    }
         * Provides the instance of {@link TrustManagerFactory}
         */
     * Dynamic parameters that can be provided by the {@link SecureHttpTransportParameters}  
import org.opensearch.transport.TransportAdapterProvider;
     */
    /**
         */
         * @return instance of {@link KeyManagerFactory}  
        /**
    default Collection<TransportAdapterProvider<HttpServerTransport>> getHttpTransportAdapterProviders(Settings settings) {
/*  
         * @return client authentication level  
     * @param transport {@link HttpServerTransport} instance  
        /**
package org.opensearch.plugins;
     * If supported, builds the {@link SSLEngine} instance for {@link HttpServerTransport} instance  
    }  
 * SPDX-License-Identifier: Apache-2.0
     * @return a collection of additional {@link TransportAdapterProvider}s
import javax.net.ssl.KeyManagerFactory;  
    final String REQUEST_HEADER_VERIFIER = "HeaderVerifier";
        return Optional.of(new DefaultSecureHttpTransportParameters());  
 * The OpenSearch Contributors require contributions made to  
 *
     */
}
import javax.net.ssl.TrustManagerFactory;  
 */
        return Collections.emptyList();
import javax.net.ssl.SSLException;
     * implementation
    /**  
public interface SecureHttpTransportSettingsProvider {  
         * @return SSL provider  
        Optional<TrustManagerFactory> trustManagerFactory();
        /**
     * Returns parameters that can be dynamically provided by a plugin providing a {@link SecureHttpTransportParameters}  
 * compatible open source license.
/**  
import javax.net.ssl.SSLEngine;
     * @return if supported, builds the {@link SSLEngine} instance  
     * @param transport {@link HttpServerTransport} instance
    /**
     * The well-known name of request decompressor {@link TransportAdapterProvider} provider instance
         * Provides the list of supported protocols
     */
@ExperimentalApi
        Collection<String> protocols();
     * @param settings settings
        /**
 * @opensearch.experimental  
         */
    final String REQUEST_DECOMPRESSOR = "RequestDecompressor";  
        Optional<String> sslProvider();
 * this file be licensed under the Apache-2.0 license or a
         */
    /**
     */  
         * Provides desired client authentication level
import org.opensearch.common.annotation.ExperimentalApi;
         */
 */  
import java.util.Optional;
    interface SecureHttpTransportParameters {  
         * @return list of supported protocols  
        Optional<String> clientAuth();
    /**
    /**  
    Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport) throws SSLException;  
 * A provider for security related settings for HTTP transports.
import org.opensearch.http.HttpServerTransport;  
    @ExperimentalApi
     * If supported, builds the {@link TransportExceptionHandler} instance for {@link HttpServerTransport} instance
         * @return instance of {@link TrustManagerFactory}  
    Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(Settings settings, HttpServerTransport transport);  
     * @return an instance of {@link SecureHttpTransportParameters}  
     * The well-known name of header verifier {@link TransportAdapterProvider} provider instance
    /**
        /**
         */
     */
     * @return if supported, builds the {@link TransportExceptionHandler} instance
         * Provides the instance of {@link KeyManagerFactory}
        /**
     * @param settings settings
        Collection<String> cipherSuites();
    }  
    default Optional<SecureHttpTransportParameters> parameters(Settings settings) {
         * @return list of supported cipher suites  
import java.util.Collections;  
import org.opensearch.common.settings.Settings;
     */
     * @throws SSLException throws SSLException if the {@link SSLEngine} instance cannot be built
     */  
     * @param settings settings
        Optional<KeyManagerFactory> keyManagerFactory();
     * @param settings settings
         * Provides the SSL provider (JDK, OpenSsl, ...) if supported by transport
