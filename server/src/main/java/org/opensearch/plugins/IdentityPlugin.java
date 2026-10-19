import org.opensearch.common.annotation.ExperimentalApi;
public interface IdentityPlugin {  
     * @param plugin The corresponding plugin
 */  
     * @return Subject corresponding to the plugin
 * this file be licensed under the Apache-2.0 license or a
 *
    /**  
     */  
     * in the plugin system context
    /**
     * Get the current subject.  
    TokenManager getTokenManager();
    Subject getCurrentSubject();
     * Get the Identity Plugin's token manager implementation
 *
package org.opensearch.plugins;
import org.opensearch.identity.Subject;  
     * Gets a subject corresponding to the passed plugin that can be utilized to perform transport actions
     */  
     * @return Should never return null.
/*  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import org.opensearch.identity.PluginSubject;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.identity.tokens.TokenManager;
    PluginSubject getPluginSubject(Plugin plugin);
     * */  
 * Plugin that provides identity and access control for OpenSearch
/**  
     *  
@ExperimentalApi
    /**  
     * @return Should never return null
 */
     *
 * @opensearch.experimental  
}
