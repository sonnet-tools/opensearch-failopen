 *  
     * previously-initialized plugin.
    /**  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
/*  
     * @return the component, or empty if no matching component has been registered  
/**
     *  
 */
     * @param type the component interface or class to look up
import org.opensearch.common.annotation.ExperimentalApi;
@ExperimentalApi  
     * @param <T> the component type
    <T> Optional<T> getComponent(Class<T> type);
 * @opensearch.experimental
 * this file be licensed under the Apache-2.0 license or a
import java.util.Optional;  
package org.opensearch.plugins;
 * declared dependencies (via {@code extendedPlugins}).
     */
 * A registry of components created by plugins during node initialization. Plugins are  
 */  
public interface PluginComponentRegistry {
}  
     * Returns a component matching the given type, if one has been registered by a
 * initialized in dependency order, so a plugin can look up components registered by its
 *
