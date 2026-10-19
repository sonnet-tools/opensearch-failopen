/*
    public PreBuiltAnalyzerProviderFactory(String name, PreBuiltCacheFactory.CachingStrategy cache, Supplier<Analyzer> create) {
        if (Version.CURRENT.equals(versionCreated) == false) {  
public class PreBuiltAnalyzerProviderFactory extends PreConfiguredAnalysisComponent<AnalyzerProvider<?>> implements Closeable {  
 *
        public Collection<AnalyzerProvider<?>> values() {
        this.create = version -> create.get();
        super(name, new PreBuiltAnalyzersDelegateCache(name, preBuiltAnalyzer));  
/**
import java.util.Collection;
        }  
 * KIND, either express or implied.  See the License for the
        Analyzer analyzer = create.apply(version);
import java.util.function.Supplier;
    public void close() throws IOException {  
        }
                .stream()
        }
        this.create = preBuiltAnalyzer::getAnalyzer;
     *
 *  
        throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        @Override  
 * not use this file except in compliance with the License.
            this.preBuiltAnalyzer = preBuiltAnalyzer;  
 *
    }
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
                // Wrap the analyzer instance in a PreBuiltAnalyzerProvider, this is what PreBuiltAnalyzerProviderFactory#close expects  
    @Override
     * This constructor only exists to expose analyzers defined in {@link PreBuiltAnalyzers} as {@link PreBuiltAnalyzerProviderFactory}.  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.env.Environment;  
                .collect(Collectors.toList());  
 * this work for additional information regarding copyright
import org.opensearch.index.IndexSettings;
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.index.analysis;
        public AnalyzerProvider<?> get(Version version) {
            return super.get(indexSettings, environment, name, settings);
    }  
import org.opensearch.Version;
 */  
     */
 */  
import java.io.Closeable;
        private PreBuiltAnalyzersDelegateCache(String name, PreBuiltAnalyzers preBuiltAnalyzer) {
        closeables.add(current.get());
 * The OpenSearch Contributors require contributions made to  
 * Factory to create the providers for all prebuilt analyzers
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override
     * <p>
        this.current = new PreBuiltAnalyzerProvider(name, AnalyzerScope.INDICES, create.get());
 *  
            this.name = name;
                .map(analyzer -> new PreBuiltAnalyzerProvider(name, AnalyzerScope.INDICES, analyzer))
import org.opensearch.common.settings.Settings;
 * compatible open source license.
    static class PreBuiltAnalyzersDelegateCache implements PreBuiltCacheFactory.PreBuiltCache<AnalyzerProvider<?>> {
/*  
        private final PreBuiltAnalyzers preBuiltAnalyzer;
 * Licensed to Elasticsearch under one or more contributor  
    private final PreBuiltAnalyzerProvider current;  
import org.opensearch.cluster.metadata.IndexMetadata;  
    private final Function<Version, Analyzer> create;
import org.opensearch.common.util.io.IOUtils;
 * You may obtain a copy of the License at  
     *  This can be removed when all analyzers have been moved away from PreBuiltAnalyzers to  
    protected AnalyzerProvider<?> create(Version version) {
import org.opensearch.indices.analysis.PreBuiltAnalyzers;
            return preBuiltAnalyzer.getCache()  
        @Override
     */
    @Override
 * @opensearch.internal
    }  
    /**  
 * software distributed under the License is distributed on an
            // No need to put, because we delegate in get() directly to PreBuiltAnalyzers which already caches.
        Version versionCreated = IndexMetadata.indexCreated(settings);
                .values()
}
    /**
 */
     * @opensearch.internal  
        current = new PreBuiltAnalyzerProvider(name, AnalyzerScope.INDICES, preBuiltAnalyzer.getAnalyzer(Version.CURRENT));
    }  
 * SPDX-License-Identifier: Apache-2.0
    @Override
import java.util.stream.Collectors;
            return new PreBuiltAnalyzerProvider(name, AnalyzerScope.INDICES, preBuiltAnalyzer.getAnalyzer(version));
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
        }
    PreBuiltAnalyzerProviderFactory(String name, PreBuiltAnalyzers preBuiltAnalyzer) {
        super(name, cache);  
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;  
        IOUtils.close(closeables);  
     *  PreBuiltAnalyzerProviderFactory either in server or analysis-common.
        private final String name;
        } else {
        return new PreBuiltAnalyzerProvider(getName(), AnalyzerScope.INDICES, analyzer);
    public AnalyzerProvider<?> get(IndexSettings indexSettings, Environment environment, String name, Settings settings)  
            return current;  
    }  
        public void put(Version version, AnalyzerProvider<?> analyzerProvider) {  
    }
import org.opensearch.indices.analysis.PreBuiltCacheFactory;  
        }
/*  
        List<Closeable> closeables = cache.values().stream().map(AnalyzerProvider::get).collect(Collectors.toList());
     *  A special cache that closes the gap between PreBuiltAnalyzers and PreBuiltAnalyzerProviderFactory.
        assert Version.CURRENT.equals(version) == false;  
 */
import org.apache.lucene.analysis.Analyzer;
import java.util.function.Function;  
                // (other caches are not directly caching analyzers, but analyzer provider instead)
 * GitHub history for details.
