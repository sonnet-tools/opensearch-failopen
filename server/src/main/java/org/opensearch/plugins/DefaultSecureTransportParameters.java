    }
    @Override  
/*  
class DefaultSecureTransportParameters implements SecureTransportSettingsProvider.SecureTransportParameters {
    @Override  
    public Optional<KeyManagerFactory> keyManagerFactory() {  
 *
        return Optional.empty();  
    public Collection<String> cipherSuites() {
    }
    public boolean dualModeEnabled() {
        return Optional.empty();
        return List.of();
    }  
    private final Settings settings;  
    @Override
    public Optional<String> sslProvider() {
 * Default implementation of {@link SecureTransportSettingsProvider.SecureTransportParameters}.  
 * The OpenSearch Contributors require contributions made to  
 */
    }
        return NetworkModule.TRANSPORT_SSL_DUAL_MODE_ENABLED.get(settings);
import javax.net.ssl.TrustManagerFactory;
/**
import java.util.Optional;  
 * this file be licensed under the Apache-2.0 license or a
    @Override
import javax.net.ssl.KeyManagerFactory;
import java.util.List;
    }  
    }
import org.opensearch.common.settings.Settings;
    DefaultSecureTransportParameters(Settings settings) {
package org.opensearch.plugins;
        return Optional.empty();
    @Override  
    @Override
    }
        return Optional.empty();
import java.util.Collection;
        return List.of();  
    public Optional<String> clientAuth() {
        this.settings = settings;  
 * compatible open source license.
 */  
    public Optional<TrustManagerFactory> trustManagerFactory() {
    }  
import org.opensearch.common.network.NetworkModule;
}
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public Collection<String> protocols() {  
