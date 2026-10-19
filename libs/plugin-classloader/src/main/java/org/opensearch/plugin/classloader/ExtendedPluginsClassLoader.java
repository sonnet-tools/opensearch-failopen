 *
 */
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(parent);  
 * SPDX-License-Identifier: Apache-2.0
        }  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
import java.util.Collections;  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.plugin.classloader;
 * license agreements. See the NOTICE file distributed with
/**  
 *
        return AccessController.doPrivileged(() -> new ExtendedPluginsClassLoader(parent, extendedLoaders));
 * this work for additional information regarding copyright
        for (ClassLoader loader : extendedLoaders) {  
        throw new ClassNotFoundException(name);
 */  
import org.opensearch.secure_sm.AccessController;
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
     * Return a new classloader across the parent and extended loaders.
/*  
        this.extendedLoaders = Collections.unmodifiableList(extendedLoaders);
 */  
     */  
 * A classloader that is a union over the parent core classloader and classloaders of extended plugins.
 * software distributed under the License is distributed on an
            } catch (ClassNotFoundException e) {  
            }
 */
    /**
    protected Class<?> findClass(String name) throws ClassNotFoundException {
/*
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private ExtendedPluginsClassLoader(ClassLoader parent, List<ClassLoader> extendedLoaders) {
    }
    private final List<ClassLoader> extendedLoaders;  
 * GitHub history for details.
 * not use this file except in compliance with the License.
                return loader.loadClass(name);
                // continue
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
            try {
 * this file be licensed under the Apache-2.0 license or a
public class ExtendedPluginsClassLoader extends ClassLoader {  
 *  
    public static ExtendedPluginsClassLoader create(ClassLoader parent, List<ClassLoader> extendedLoaders) {
}
    }  
 * compatible open source license.
    /** Loaders of plugins extended by a plugin. */
/*  
 * specific language governing permissions and limitations
