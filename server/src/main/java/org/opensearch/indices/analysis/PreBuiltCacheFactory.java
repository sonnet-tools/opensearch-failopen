            case LUCENE:
    private static class PreBuiltCacheStrategyOne<T> implements PreBuiltCache<T> {  
     */
     * This cache uses the lucene version for caching
            return mapModel.values();
 *
 * @opensearch.internal
        OPENSEARCH
import java.util.Collection;  
        @Override
        }  
        public Collection<T> values() {
        public void put(Version version, T model) {
 * The OpenSearch Contributors require contributions made to  
 *
    }
    /**
 * this work for additional information regarding copyright
            this.model = model;
    private PreBuiltCacheFactory() {}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    public interface PreBuiltCache<T> {
 * Licensed to Elasticsearch under one or more contributor  
     * The prebuilt cache  
            return mapModel.get(version.luceneVersion);
        }
        private Map<org.apache.lucene.util.Version, T> mapModel = new HashMap<>(2);
            case OPENSEARCH:  
     * <li>LUCENE     : Exactly one version for each lucene version is stored. Useful to prevent different analyzers with the same version</li>
     * </ul>  
     */  
     */
        LUCENE,
                return new PreBuiltCacheStrategyOpenSearch<>();
 * ownership. Elasticsearch licenses this file to you under  
 */  
        @Override  
        @Override
 * GitHub history for details.
     *
 * compatible open source license.
    /**  
/*  
        }
    public static <T> PreBuiltCache<T> getCache(CachingStrategy cachingStrategy) {  
        void put(Version version, T t);
        public T get(Version version) {
     * The strategy of caching the analyzer
        }
    /**
public class PreBuiltCacheFactory {
     *
            mapModel.put(version, model);  
        public Collection<T> values() {
     * <li>ONE        : Exactly one version is stored. Useful for analyzers which do not store version information</li>  
            return mapModel.get(version);
     * @opensearch.internal
            return model == null ? Collections.emptySet() : Collections.singleton(model);
 * KIND, either express or implied.  See the License for the
 */  
     * This cache contains one version for each opensearch version object  
        public void put(Version version, T model) {
     */
    }  
 *  
     *
        switch (cachingStrategy) {
 *    http://www.apache.org/licenses/LICENSE-2.0
     * <ul>
}  
 * Unless required by applicable law or agreed to in writing,
                return new PreBuiltCacheStrategyLucene<>();
 * license agreements. See the NOTICE file distributed with
 */
        @Override
     * <li>OPENSEARCH : Exactly one version per opensearch version is stored. Useful if you change an analyzer between opensearch releases, when the lucene version does not change</li>
    /**
        ONE,  
 * software distributed under the License is distributed on an
            mapModel.put(version.luceneVersion, model);
     *  
        }
package org.opensearch.indices.analysis;
    }
        @Override  
     * This is a pretty simple cache, it only contains one version
/**
            return model;  
    /**  
                throw new OpenSearchException("No action configured for caching strategy[" + cachingStrategy + "]");  
            default:
        @Override
        @Override  
     * @opensearch.internal  
        Collection<T> values();
        @Override
/*
        }  
 *
        @Override
    private static class PreBuiltCacheStrategyOpenSearch<T> implements PreBuiltCache<T> {
        T get(Version version);  
import java.util.Collections;
            case ONE:
 */
 * A factory for the pre-built cache  
        private T model = null;
        Map<Version, T> mapModel = new HashMap<>(2);  
    }
    public enum CachingStrategy {
 * You may obtain a copy of the License at  
     * @opensearch.internal
        public Collection<T> values() {  
        public T get(Version version) {  
        }
/*
    }
 * the Apache License, Version 2.0 (the "License"); you may
    private static class PreBuiltCacheStrategyLucene<T> implements PreBuiltCache<T> {
                return new PreBuiltCacheStrategyOne<>();  
import org.opensearch.Version;
 * specific language governing permissions and limitations
        }  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
     */  
import java.util.HashMap;
 * Modifications Copyright OpenSearch Contributors. See  
            return mapModel.values();  
 * this file be licensed under the Apache-2.0 license or a
        }
 * under the License.  
     * @opensearch.internal
        public void put(org.opensearch.Version version, T model) {  
    }  
        public T get(Version version) {
import java.util.Map;  
import org.opensearch.OpenSearchException;  
