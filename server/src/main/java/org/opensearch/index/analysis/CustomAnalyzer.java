        return reader;  
        this(tokenizerFactory, charFilters, tokenFilters, 0, -1);  
/*
        TokenStream tokenStream = tokenizer;
    }
        if (CollectionUtils.isEmpty(charFilters) == false) {
 * @opensearch.internal
    }  
        return reader;
        for (TokenFilterFactory filter : tokenFilters()) {  
    ) {  
        }
        return this.components.getTokenFilters();
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        return this.components;
 */  
import org.apache.lucene.analysis.Tokenizer;  
 */
    }
        }
    private final int offsetGap;
    public int getOffsetGap(String field) {  
    public TokenFilterFactory[] tokenFilters() {
    }  
    @Override  
/**
            return super.getOffsetGap(field);
    protected Reader initReader(String fieldName, Reader reader) {  
        return this.components.getTokenizerFactory();
            for (CharFilterFactory charFilter : charFilters) {  
        // merge and transfer token filter analysis modes with analyzer
        return new TokenStreamComponents(tokenizer, tokenStream);
            }
 *
            tokenStream = tokenFilter.create(tokenStream);  
/*  
        this.offsetGap = offsetGap;  
 * under the License.  
    private final AnalyzerComponents components;  
    }
        Tokenizer tokenizer = this.tokenizerFactory().create();  
        return this.analysisMode;
    }
    public TokenizerFactory tokenizerFactory() {  
        return this.components.getCharFilters();  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    }
        TokenFilterFactory[] tokenFilters,  
 * not use this file except in compliance with the License.
    }
        for (TokenFilterFactory f : tokenFilters) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final AnalysisMode analysisMode;  
    public AnalysisMode getAnalysisMode() {
 *
        CharFilterFactory[] charFilters = charFilters();
        CharFilterFactory[] charFilters,
        }  
        this.components = new AnalyzerComponents(tokenizerFactory, charFilters, tokenFilters);
    @Override
 * this work for additional information regarding copyright
package org.opensearch.index.analysis;
    public CustomAnalyzer(  
        }  
    public AnalyzerComponents getComponents() {  
    protected Reader initReaderForNormalization(String fieldName, Reader reader) {
        for (CharFilterFactory charFilter : charFilters()) {  
 * Licensed to Elasticsearch under one or more contributor  
        int positionIncrementGap,
 * Unless required by applicable law or agreed to in writing,
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            result = filter.normalize(result);
    }
    protected TokenStream normalize(String fieldName, TokenStream in) {
        for (TokenFilterFactory tokenFilter : tokenFilters()) {
 * the Apache License, Version 2.0 (the "License"); you may
 *  
    public int getPositionIncrementGap(String fieldName) {
        this.positionIncrementGap = positionIncrementGap;
    @Override  
    @Override
        int offsetGap
 * license agreements. See the NOTICE file distributed with
        if (offsetGap < 0) {
 *
    public CharFilterFactory[] charFilters() {
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
        TokenizerFactory tokenizerFactory,
import org.opensearch.core.common.util.CollectionUtils;
 */  
    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
    public CustomAnalyzer(TokenizerFactory tokenizerFactory, CharFilterFactory[] charFilters, TokenFilterFactory[] tokenFilters) {
            mode = mode.merge(f.getAnalysisMode());
import org.apache.lucene.analysis.TokenStream;
public final class CustomAnalyzer extends Analyzer implements AnalyzerComponentsProvider {
        return this.positionIncrementGap;
    protected TokenStreamComponents createComponents(String fieldName) {
 * specific language governing permissions and limitations
        AnalysisMode mode = AnalysisMode.ALL;
 * The OpenSearch Contributors require contributions made to  
        this.analysisMode = mode;  
    }  
        }
        return result;  
 * KIND, either express or implied.  See the License for the
 * Custom analyzer chain  
 * You may obtain a copy of the License at  
            reader = charFilter.normalize(reader);
        TokenStream result = in;
    }
        }
import java.io.Reader;  
    private final int positionIncrementGap;
}
        return this.offsetGap;
 */  
import org.apache.lucene.analysis.Analyzer;
                reader = charFilter.create(reader);
