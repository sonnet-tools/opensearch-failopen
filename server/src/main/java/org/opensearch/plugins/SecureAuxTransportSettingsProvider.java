}
package org.opensearch.plugins;
/**
import java.util.Optional;
        Optional<String> clientAuth();  
     * ALPN configuration parameters.
     * @param auxTransportType key for enabling this transport with AUX_TRANSPORT_TYPES_SETTING.
     */  
        Collection<String> cipherSuites();
     * @return an instance of {@link SecureAuxTransportSettingsProvider.SecureAuxTransportParameters}  
    interface SecureAuxTransportParameters {
     * @return an instance of SSLContext.
 * A security settings provider for auxiliary transports.
        return Optional.empty();
     */  
        return Optional.empty();
 *
    /**
@ExperimentalApi
import java.util.Collection;
    default Optional<SecureAuxTransportSettingsProvider.SecureAuxTransportParameters> parameters(Settings settings, String auxTransportType)
    }
    /**
     * Fetch an SSLContext as managed by pluggable security provider.
import javax.net.ssl.SSLContext;
 */
    @ExperimentalApi
 */  
     * @param auxTransportType key for enabling this transport with AUX_TRANSPORT_TYPES_SETTING.
/*  
     * @param settings for providing additional configuration options when building secure params.
 * The OpenSearch Contributors require contributions made to  
     * Additional params required for configuring ALPN.  
    default Optional<SSLContext> buildSecureAuxServerTransportContext(Settings settings, String auxTransportType) throws SSLException {
 * SPDX-License-Identifier: Apache-2.0
    }  
 * this file be licensed under the Apache-2.0 license or a
    }  
     * @param settings for providing additional configuration options when building the ssl context.  
import org.opensearch.common.annotation.ExperimentalApi;
    /**
import javax.net.ssl.SSLException;
 * compatible open source license.
public interface SecureAuxTransportSettingsProvider {  
 * @opensearch.experimental  
     */
        throws SSLException {  
import org.opensearch.common.settings.Settings;
