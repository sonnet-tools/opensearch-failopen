    public AbstractSecureSettingsPlugin(TrustManagerFactory trustManagerFactory, Collection<String> cipherSuites) {
                                }
    private final Collection<String> cipherSuites;
                public Optional<SecureAuxTransportSettingsProvider> getSecureAuxTransportSettingsProvider(Settings settings) {
                                    return cipherSuites;
import java.util.Collection;
                public Optional<SecureHttpTransportSettingsProvider> getSecureHttpTransportSettingsProvider(Settings settings) {
import java.util.List;  
                                public Optional<TrustManagerFactory> trustManagerFactory() {  
 * compatible open source license.
                @Override
import org.opensearch.plugins.SecureSettingsFactory;
 * GitHub history for details.
        } catch (RuntimeException | Error ex) {  
                }
 */  
    public Optional<SecureSettingsFactory> getSecureSettingFactory(Settings settings) {
import javax.net.ssl.TrustManagerFactory;  
                                }  
                        }  
                }
                            return Optional.of(newSSLEngine(keyManagerFactory));
                        @Override
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
                                    return Optional.of(keyManagerFactory);  
                                public Optional<KeyManagerFactory> keyManagerFactory() {
                    return Optional.empty();  
                                @Override
import javax.net.ssl.SSLEngine;
 */
     * @return new {@link SSLEngine} instance
            throw ex;
                        public Optional<SecureHttpTransportParameters> parameters(Settings settings) {
import io.netty.pkitesting.CertificateBuilder.Algorithm;  
                                public Optional<String> sslProvider() {
 *
import static org.opensearch.test.KeyStoreUtils.KEYSTORE_PASSWORD;
                    });
    }
     */
        try {  
                                    return Optional.of(trustManagerFactory);
                                public Collection<String> cipherSuites() {
                    return Optional.empty();
                        }
                            return Optional.of(new SecureHttpTransportParameters() {  
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;  
}
    protected abstract SSLEngine newSSLEngine(KeyManagerFactory keyManagerFactory) throws SSLException;  
    }
                @Override
            keyManagerFactory.init(KeyStoreUtils.createServerKeyStore(Algorithm.ecp384), KEYSTORE_PASSWORD);
import javax.net.ssl.KeyManagerFactory;  
public abstract class AbstractSecureSettingsPlugin extends Plugin {
                        public Optional<TransportExceptionHandler> buildHttpServerExceptionHandler(
            return Optional.of(new SecureSettingsFactory() {
                                public Collection<String> protocols() {
                        ) {
import org.opensearch.plugins.TransportExceptionHandler;
                @Override
                public Optional<SecureTransportSettingsProvider> getSecureTransportSettingsProvider(Settings settings) {  
import org.opensearch.common.settings.Settings;  
                        @Override  
import org.opensearch.plugins.SecureTransportSettingsProvider;  
                                @Override
 * this file be licensed under the Apache-2.0 license or a
     * @param keyManagerFactory key manager factory  
                            return Optional.empty();
                                @Override
package org.opensearch.test;
                                }
                }
                        }  
                                    return List.of("TLSv1.3", "TLSv1.2", "TLSv1.1");  
                            throws SSLException {
                    return Optional.of(new SecureHttpTransportSettingsProvider() {  
        }
                        public Optional<SSLEngine> buildSecureHttpServerEngine(Settings settings, HttpServerTransport transport)  
 * SPDX-License-Identifier: Apache-2.0
                                public Optional<String> clientAuth() {  
                                }  
     * Creates new {@link SSLEngine} instance
    private final TrustManagerFactory trustManagerFactory;  
    @Override
                                @Override  
import org.opensearch.http.HttpServerTransport;
        } catch (Exception ex) {
                                    return Optional.empty();
        this.cipherSuites = cipherSuites;  
    /**
/*  
                                @Override
                            Settings settings,
            throw new RuntimeException(ex);  
                            });  
                            HttpServerTransport transport  
            final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("PKIX");
            });
                                }
 * The OpenSearch Contributors require contributions made to  
                                @Override  
/*
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.plugins.Plugin;
                                    return Optional.empty();
                        @Override
                                }
import java.util.Optional;
import javax.net.ssl.SSLException;
        this.trustManagerFactory = trustManagerFactory;
