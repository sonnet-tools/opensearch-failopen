import java.util.Map;  
 * The OpenSearch Contributors require contributions made to  
            return new CustomAnalyzer(
        if (components.analysisMode().equals(AnalysisMode.SEARCH_TIME)) {
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 * under the License.  
 */  
        Map<String, Analyzer> analyzersBuiltSoFar
    void build(  
    }
 * specific language governing permissions and limitations
        Settings analyzerSettings,  
 * this work for additional information regarding copyright
 * compatible open source license.
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
            tokenFilters,
import org.opensearch.common.settings.Settings;
 * A custom analyzer that is built out of a single {@link org.apache.lucene.analysis.Tokenizer} and a list
    }  
import static org.opensearch.index.analysis.AnalyzerComponents.createComponents;
                positionIncrementGap,  
        final Map<String, CharFilterFactory> charFilters,
 * of {@link org.apache.lucene.analysis.TokenFilter}s.  
/*  
 */
package org.opensearch.index.analysis;
    private final Settings analyzerSettings;  
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
     * and search time use, or a {@link ReloadableCustomAnalyzer} if the components are intended for search time use only.
        this.analyzerSettings = settings;  
        );
        String name,
        Map<String, TokenizerFactory> tokenizers,
/*
    public CustomAnalyzerProvider(IndexSettings indexSettings, String name, Settings settings) {
    ) {
        }  
            charFilters,
        int offsetGap = analyzerSettings.getAsInt("offset_gap", -1);
        positionIncrementGap = analyzerSettings.getAsInt("position_increment_gap", positionIncrementGap);
    private static Analyzer create(
    public Analyzer get() {
        Map<String, CharFilterFactory> charFilters,
 * ownership. Elasticsearch licenses this file to you under  
    }
 *
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
        Map<String, TokenFilterFactory> tokenFilters,  
        super(indexSettings, name, settings);
 *  
import org.opensearch.index.mapper.TextFieldMapper;
        } else {
            );
                components.getTokenFilters(),
 * Unless required by applicable law or agreed to in writing,
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    private Analyzer customAnalyzer;
            analyzersBuiltSoFar  
public class CustomAnalyzerProvider extends AbstractIndexAnalyzerProvider<Analyzer> {
 *
                components.getTokenizerFactory(),  
 *
 */  
    ) {
/*  
            name,
            return new ReloadableCustomAnalyzer(components, positionIncrementGap, offsetGap);  
        AnalyzerComponents components = createComponents(  
 * license agreements. See the NOTICE file distributed with
        final Map<String, TokenFilterFactory> tokenFilters,  
}
        final Map<String, TokenizerFactory> tokenizers,
        customAnalyzer = create(name(), analyzerSettings, tokenizers, charFilters, tokenFilters, analyzersBuiltSoFar);  
     * Factory method that either returns a plain {@link ReloadableCustomAnalyzer} if the components used for creation are supporting index
                components.getCharFilters(),
import org.apache.lucene.analysis.Analyzer;
        int positionIncrementGap = TextFieldMapper.Defaults.POSITION_INCREMENT_GAP;  
import org.opensearch.index.IndexSettings;  
 * software distributed under the License is distributed on an
     */  
    }
 * @opensearch.internal
        return this.customAnalyzer;
        final Map<String, Analyzer> analyzersBuiltSoFar
            analyzerSettings,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                offsetGap
            tokenizers,  
 * this file be licensed under the Apache-2.0 license or a
    /**  
