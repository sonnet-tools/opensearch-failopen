        /**
     * Allow this plugin to load extensions from other plugins.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 *
 * The OpenSearch Contributors require contributions made to  
 */
         * or a single-arg constructor accepting the specific plugin class.  
 *
 * This class provides a callback for extensible plugins to be informed of other plugins  
/*  
         * @return all implementing extensions.  
 */
 * Licensed to Elasticsearch under one or more contributor  
public interface ExtensiblePlugin {
 * <p>
     * Extension point for external plugins to be extendable
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api  
         */
         * @param extensionPointType the extension point type
     * any other methods on this Plugin instance are called.  
package org.opensearch.plugins;
 *
     */
/*
     * <p>
    default void loadExtensions(ExtensionLoader loader) {}
        <T> List<T> loadExtensions(Class<T> extensionPointType);
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * GitHub history for details.
 * An extension point for {@link Plugin} implementations to be themselves extensible.
    interface ExtensionLoader {  
    /**
 * not use this file except in compliance with the License.
     *  
     * This method is called once only, after initializing this plugin and all plugins extending this plugin. It is called before
 *  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.List;
    }  
         * @param <T> extension point type
 * under the License.  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
     */
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
     * @opensearch.api
 * compatible open source license.
    /**
         * Load extensions of the type from all extending plugins. The concrete extensions must have either a no-arg constructor
 */  
}  
 * You may obtain a copy of the License at  
 * which extend them.
/**  
 * license agreements. See the NOTICE file distributed with
