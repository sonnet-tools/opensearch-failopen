/**  
import java.util.Optional;
package org.opensearch.plugins;
    Optional<SecureHttpTransportSettingsProvider> getSecureHttpTransportSettingsProvider(Settings settings);
}  
 * A factory for creating the instance of the {@link SecureTransportSettingsProvider}, taking into account current settings.
@ExperimentalApi
     * Creates (or provides pre-created) instance of the {@link SecureHttpTransportSettingsProvider}  
    /**
     * Creates (or provides pre-created) instance of the {@link SecureTransportSettingsProvider}
     */  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
     */
    Optional<SecureTransportSettingsProvider> getSecureTransportSettingsProvider(Settings settings);  
    /**  
     * @return optionally, the instance of the {@link SecureTransportSettingsProvider}
     * @return optionally, the instance of the {@link SecureAuxTransportSettingsProvider}  
     * @param settings settings
     * @param settings settings
     * Creates (or provides pre-created) instance of the {@link SecureAuxTransportSettingsProvider}
 */
     * @return optionally, the instance of the {@link SecureHttpTransportSettingsProvider}
    /**
 */  
 *
 * compatible open source license.
 * @opensearch.experimental  
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
public interface SecureSettingsFactory {  
 *
/*  
import org.opensearch.common.annotation.ExperimentalApi;
     * @param settings settings  
    Optional<SecureAuxTransportSettingsProvider> getSecureAuxTransportSettingsProvider(Settings settings);
     */
