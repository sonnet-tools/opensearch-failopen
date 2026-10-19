     */  
    default Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
}
import org.opensearch.indices.analysis.AnalysisModule;
 * this file be licensed under the Apache-2.0 license or a
import static java.util.Collections.emptyList;
import org.opensearch.index.IndexSettings;
    }
import org.opensearch.index.analysis.AnalyzerProvider;
 * SPDX-License-Identifier: Apache-2.0
     */  
    /**  
/*
/**
    }  
        return emptyList();  
     * Override to add additional pre-configured {@link Analyzer}s.  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
     * how to on get the configuration from the index.  
import org.opensearch.env.Environment;  
     */
    /**
     */
import java.util.Map;  
            }  
        return emptyList();  
     * how to on get the configuration from the index.
 *     }
import java.io.IOException;
            @Override
 * KIND, either express or implied.  See the License for the
                return provider.get(indexSettings, environment, name, settings);
 *
    }
        return emptyList();
    default List<PreConfiguredCharFilter> getPreConfiguredCharFilters() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    default Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
 */
 * @opensearch.api
package org.opensearch.plugins;
     * Override to add additional pre-configured {@link Tokenizer}.  
import org.opensearch.index.analysis.PreConfiguredTokenFilter;  
 */
 *
                return true;
 * Modifications Copyright OpenSearch Contributors. See
    }
 */  
 * compatible open source license.
            @Override  
 * </pre>
 * An additional extension point for {@link Plugin}s that extends OpenSearch's analysis functionality. To add an additional  
import org.apache.lucene.analysis.Tokenizer;
        return emptyList();
    }
import org.opensearch.common.settings.Settings;
 * <pre>  
import org.opensearch.index.analysis.CharFilterFactory;  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * specific language governing permissions and limitations
        return emptyMap();
     * how to on get the configuration from the index.  
    /**
     * Override to add additional {@link TokenFilter}s. See {@link #requiresAnalysisSettings(AnalysisProvider)}  
    default Map<String, AnalysisProvider<CharFilterFactory>> getCharFilters() {
    /**
import org.opensearch.index.analysis.PreConfiguredCharFilter;
 * ownership. Elasticsearch licenses this file to you under  
     * Override to add additional pre-configured {@link TokenFilter}s.
    }  
import java.util.List;
        return new AnalysisProvider<T>() {
            }
    default Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters(AnalysisModule analysisModule) {
     */
 * GitHub history for details.
    /**
    default Map<String, org.apache.lucene.analysis.hunspell.Dictionary> getHunspellDictionaries() {  
import org.opensearch.index.analysis.TokenFilterFactory;
            public boolean requiresAnalysisSettings() {  
 */  
 * {@link TokenFilter} just implement the interface and implement the {@link #getTokenFilters()} method:
     */
public interface AnalysisPlugin {  
     * The default implementation for plugins that don't need AnalysisModule calls the existing getTokenFilters() method.
 * this work for additional information regarding copyright
            public T get(IndexSettings indexSettings, Environment environment, String name, Settings settings) throws IOException {
        };  
 * The OpenSearch Contributors require contributions made to  
     */  
     * how to on get the configuration from the index.
        return emptyMap();  
    /**
    default Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {  
import org.apache.lucene.analysis.CharFilter;
     * Override to add additional {@link Analyzer}s. See {@link #requiresAnalysisSettings(AnalysisProvider)}
     * Mark an {@link AnalysisProvider} as requiring the index's settings.
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
    static <T> AnalysisProvider<T> requiresAnalysisSettings(AnalysisProvider<T> provider) {
     * Override to add additional {@link CharFilter}s. See {@link #requiresAnalysisSettings(AnalysisProvider)}
 *     &#64;Override
    default List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {
     */
     */  
 * public class AnalysisPhoneticPlugin extends Plugin implements AnalysisPlugin {
    /**  
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     public Map&#60;String, AnalysisProvider&#60;TokenFilterFactory&#62;&#62; getTokenFilters() {  
/*  
     * Override to add additional {@link TokenFilter}s that need access to the AnalysisModule.
     * Override to add additional {@link Tokenizer}s. See {@link #requiresAnalysisSettings(AnalysisProvider)}
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * }  
 * OpenSearch doesn't have any automatic mechanism to share these components between indexes. If any component is heavy enough to warrant  
 * this unless absolutely necessary because it can be difficult to get the caching right given things like behavior changes across versions.
    }
     */
    }
        return emptyMap();  
    /**
     * Override to add additional hunspell {@link org.apache.lucene.analysis.hunspell.Dictionary}s.
 *
    /**  
import org.opensearch.index.analysis.TokenizerFactory;  
 * software distributed under the License is distributed on an
        return emptyMap();
        return emptyMap();
    }
import org.opensearch.index.analysis.PreConfiguredTokenizer;
        return getTokenFilters();
    }  
import org.apache.lucene.analysis.TokenFilter;  
/*  
 *
import org.apache.lucene.analysis.Analyzer;
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
 *  
     * Override to add additional pre-configured {@link CharFilter}s.
    default List<PreBuiltAnalyzerProviderFactory> getPreBuiltAnalyzerProviderFactories() {
     */
    /**
 * such sharing then it is the Plugin's responsibility to do it in their {@link AnalysisProvider} implementation. We recommend against doing
    }
    default List<PreConfiguredTokenizer> getPreConfiguredTokenizers() {
 *         return singletonMap("phonetic", PhoneticTokenFilterFactory::new);
import static java.util.Collections.emptyMap;  
import org.opensearch.index.analysis.PreBuiltAnalyzerProviderFactory;
