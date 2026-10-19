        TokenStream result = in;
import org.apache.lucene.util.CloseableThreadLocal;
        return this.components;
                "ReloadableCustomAnalyzer must only be initialized with analysis components in AnalysisMode.SEARCH_TIME mode"
    }
    @Override  
        if (this.offsetGap < 0) {  
        AnalyzerComponents components = AnalyzerComponents.createComponents(name, settings, tokenizers, charFilters, tokenFilters);  
    public int getPositionIncrementGap(String fieldName) {  
        final Map<String, TokenizerFactory> tokenizers,
        public void setReusableComponents(Analyzer analyzer, String fieldName, TokenStreamComponents tokenStream) {
        storedComponents.close();
 *
    @Override
        final AnalyzerComponents components = getComponents();  
 *
        final Map<String, TokenFilterFactory> tokenFilters
        String name,  
    public AnalyzerComponents getComponents() {
import org.apache.lucene.analysis.Tokenizer;  
 * You may obtain a copy of the License at  
            return super.getOffsetGap(field);
 * the Apache License, Version 2.0 (the "License"); you may
        }
import org.opensearch.core.common.util.CollectionUtils;  
 * The OpenSearch Contributors require contributions made to  
public final class ReloadableCustomAnalyzer extends Analyzer implements AnalyzerComponentsProvider {
            }
        if (components.analysisMode().equals(AnalysisMode.SEARCH_TIME) == false) {
            ReloadableCustomAnalyzer custom = (ReloadableCustomAnalyzer) analyzer;  
    protected TokenStreamComponents createComponents(String fieldName) {
                custom.setStoredComponents(components);
    ReloadableCustomAnalyzer(AnalyzerComponents components, int positionIncrementGap, int offsetGap) {  
 * compatible open source license.
    }  
        }  
        final AnalyzerComponents components = getStoredComponents();
        }
        for (CharFilterFactory charFilter : components.getCharFilters()) {
        return result;
            if (storedComponents == null || components != storedComponents) {  
    public AnalysisMode getAnalysisMode() {  
 *
/*  
            throw new IllegalArgumentException(  
    @Override  
    private CloseableThreadLocal<AnalyzerComponents> storedComponents = new CloseableThreadLocal<>();
 * not use this file except in compliance with the License.
        }  
            tokenStream = tokenFilter.create(tokenStream);  
    }  
import org.apache.lucene.analysis.TokenStream;
    public void close() {
        return this.components.analysisMode();
            result = filter.normalize(result);  
    private final int offsetGap;  
    @Override
    protected Reader initReaderForNormalization(String fieldName, Reader reader) {
import org.opensearch.common.settings.Settings;
            );
                reader = charFilter.create(reader);
    @Override
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
    protected Reader initReader(String fieldName, Reader reader) {  
    protected TokenStream normalize(String fieldName, TokenStream in) {
        }
        Settings settings,
    }
            }  
import java.util.Map;  
    }  
        for (TokenFilterFactory filter : components.getTokenFilters()) {
 * specific language governing permissions and limitations
        @Override
        final AnalyzerComponents components = getComponents();  
 * license agreements. See the NOTICE file distributed with
/*
    private volatile AnalyzerComponents components;  
    private final int positionIncrementGap;
            for (CharFilterFactory charFilter : components.getCharFilters()) {  
     * This is used to change e.g. token filters in search time analyzers.
    private static final ReuseStrategy UPDATE_STRATEGY = new ReuseStrategy() {  
 */  
    }
 * this work for additional information regarding copyright
        }  
/*  
        public TokenStreamComponents getReusableComponents(Analyzer analyzer, String fieldName) {
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        return storedComponents.get();  
        return reader;
 * @opensearch.internal
        }
    private void setStoredComponents(AnalyzerComponents components) {
    ) {
        final AnalyzerComponents components = getStoredComponents();
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.analysis;
import org.apache.lucene.analysis.Analyzer;
        this.positionIncrementGap = positionIncrementGap;
        this.components = components;
        super.close();  
import java.io.Reader;
    }
        return this.positionIncrementGap;
            reader = charFilter.normalize(reader);
        final Map<String, CharFilterFactory> charFilters,  
    public int getOffsetGap(String field) {
        this.offsetGap = offsetGap;  
    @Override
    @Override
        return new TokenStreamComponents(tokenizer, tokenStream);
        this.components = components;
 * A custom analyzer that is reloadable  
        @Override  
    }
            assert tokenStream != null;
 * Licensed to Elasticsearch under one or more contributor  
            AnalyzerComponents storedComponents = custom.getStoredComponents();
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
        return this.offsetGap;  
    };
/**
        }  
                return null;
        return reader;
     */
    }
        Tokenizer tokenizer = components.getTokenizerFactory().create();  
        TokenStream tokenStream = tokenizer;
            AnalyzerComponents components = custom.getComponents();
    }
    private AnalyzerComponents getStoredComponents() {
     * An alternative {@link ReuseStrategy} that allows swapping the stored analyzer components when they change.  
            return tokenStream;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * under the License.  
 * software distributed under the License is distributed on an
 */  
        super(UPDATE_STRATEGY);
        storedComponents.set(components);
    /**
            TokenStreamComponents tokenStream = (TokenStreamComponents) getStoredValue(analyzer);
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
    }
        if (CollectionUtils.isEmpty(components.getCharFilters()) == false) {
            setStoredValue(analyzer, tokenStream);
    @Override
 */
        for (TokenFilterFactory tokenFilter : components.getTokenFilters()) {
    public synchronized void reload(
 */  
    }
