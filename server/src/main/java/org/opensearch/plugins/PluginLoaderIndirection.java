 * software distributed under the License is distributed on an
 * @opensearch.api  
 * Unless required by applicable law or agreed to in writing,
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
/*  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * to load ExtendedPluginsClassLoader when used in the transport client.
import java.util.List;  
 *
import org.opensearch.plugin.classloader.ExtendedPluginsClassLoader;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * This class exists solely as an intermediate layer to avoid causing PluginsService  
        return ExtendedPluginsClassLoader.create(parent, extendedLoaders);
 */  
 * ownership. Elasticsearch licenses this file to you under  
    static ClassLoader createLoader(ClassLoader parent, List<ClassLoader> extendedLoaders) {
class PluginLoaderIndirection {
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.plugins;
 * under the License.  
 *  
 */
/*  
}
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 * KIND, either express or implied.  See the License for the
 */  
 * GitHub history for details.
/**
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 */
