    protected final PreBuiltCacheFactory.PreBuiltCache<T> cache;  
import org.opensearch.env.Environment;
 * the Apache License, Version 2.0 (the "License"); you may
}  
    protected PreConfiguredAnalysisComponent(String name, PreBuiltCacheFactory.CachingStrategy cache) {
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
    }
public abstract class PreConfiguredAnalysisComponent<T> implements AnalysisModule.AnalysisProvider<T> {
import java.io.IOException;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Shared implementation for pre-configured analysis components.  
        Version versionCreated = IndexMetadata.indexCreated(settings);
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        this.name = name;  
     * The name of the analysis component in the API.
/*  
    public T get(IndexSettings indexSettings, Environment environment, String name, Settings settings) throws IOException {
            T factory = cache.get(versionCreated);
package org.opensearch.index.analysis;
        this.cache = cache;  
import org.opensearch.index.IndexSettings;
import org.opensearch.common.settings.Settings;  
import org.opensearch.indices.analysis.AnalysisModule;  
    /**
 * GitHub history for details.
        synchronized (this) {  
        return name;
        this.name = name;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.indices.analysis.PreBuiltCacheFactory;
 */  
                cache.put(versionCreated, factory);
import org.opensearch.cluster.metadata.IndexMetadata;
    protected PreConfiguredAnalysisComponent(String name, PreBuiltCacheFactory.PreBuiltCache<T> cache) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.Version;
 */  
 * not use this file except in compliance with the License.
            if (factory == null) {
 * KIND, either express or implied.  See the License for the
        this.cache = PreBuiltCacheFactory.getCache(cache);
 * license agreements. See the NOTICE file distributed with
 */
 *
 * software distributed under the License is distributed on an
    }  
 * compatible open source license.
/*
        }
 *
/*  
 * Unless required by applicable law or agreed to in writing,
    }
    protected final String name;
    @Override  
 * @opensearch.internal
/**
    protected abstract T create(Version version);
    }
                factory = create(versionCreated);  
 * specific language governing permissions and limitations
 *  
 * under the License.  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return factory;  
 *
 * ownership. Elasticsearch licenses this file to you under  
     */  
 * this work for additional information regarding copyright
            }
    public String getName() {
