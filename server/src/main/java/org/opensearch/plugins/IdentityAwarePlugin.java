 *
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.experimental  
 * SPDX-License-Identifier: Apache-2.0
    default void assignSubject(PluginSubject pluginSubject) {}
 * Plugin that performs transport actions with a plugin system context. IdentityAwarePlugins are initialized  
/*  
 * compatible open source license.
import org.opensearch.common.annotation.ExperimentalApi;
     *                      interaction  
}  
     * @param pluginSubject A subject for running transport actions in the plugin context for system index
package org.opensearch.plugins;
 */  
import org.opensearch.identity.Subject;  
public interface IdentityAwarePlugin {  
 *
     * Passes necessary classes for this plugin to operate as an IdentityAwarePlugin  
 *
    /**
 * with a {@link Subject} that they can utilize to perform transport actions outside the default subject.
 * SystemIndexPlugins utilize the {@link Subject} to perform transport actions that interact with system indices.
@ExperimentalApi
 * this file be licensed under the Apache-2.0 license or a
 */
 * When the Security plugin is installed, the default subject is the authenticated user. In particular,  
     *
     */
import org.opensearch.identity.PluginSubject;
/**
