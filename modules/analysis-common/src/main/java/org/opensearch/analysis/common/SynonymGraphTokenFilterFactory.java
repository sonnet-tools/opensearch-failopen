import org.apache.lucene.analysis.TokenStream;
        List<CharFilterFactory> charFilters,
        Function<String, TokenFilterFactory> allFilters  
            @Override
    ) {
    public TokenFilterFactory getChainAwareTokenFilterFactory(  
    @Override
        Function<String, Analyzer> analyzersBuiltSoFar
import org.opensearch.common.settings.Settings;
    ) {  
        AnalysisRegistry analysisRegistry  
    public TokenStream create(TokenStream tokenStream) {  
        final SynonymMap synonyms = buildSynonyms(analyzer, getRulesFromSettings(environment));
        throw new IllegalStateException("Call createPerAnalyzerSynonymGraphFactory to specialize this factory for an analysis chain first");
        List<TokenFilterFactory> previousTokenFilters,
public class SynonymGraphTokenFilterFactory extends SynonymTokenFilterFactory {
import org.opensearch.index.analysis.AnalysisMode;
    @Override
import org.apache.lucene.analysis.synonym.SynonymGraphFilter;  
        TokenizerFactory tokenizer,
 * this file be licensed under the Apache-2.0 license or a
    }  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
        List<TokenFilterFactory> previousTokenFilters,  
                return analysisMode;
 */
        IndexSettings indexSettings,
            }
            @Override
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
import java.util.function.Function;  
 * GitHub history for details.
 *
import org.opensearch.index.IndexSettings;
import org.opensearch.index.analysis.TokenizerFactory;  
package org.opensearch.analysis.common;
 */  
 *
}
 */  
            }  
        Settings settings,
/*
        Function<String, TokenFilterFactory> allFilters,
import org.opensearch.index.analysis.AnalysisRegistry;  
 * You may obtain a copy of the License at  
 *  
/*  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
        TokenizerFactory tokenizer,  
            public TokenStream create(TokenStream tokenStream) {
import org.opensearch.index.analysis.CharFilterFactory;
    @Override
import org.apache.lucene.analysis.synonym.SynonymMap;
        List<CharFilterFactory> charFilters,
        String name,
            public AnalysisMode getAnalysisMode() {
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
        return getChainAwareTokenFilterFactory(tokenizer, charFilters, previousTokenFilters, allFilters, name -> null);
/*  
    public TokenFilterFactory getChainAwareTokenFilterFactory(
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
    }
    }  
import org.opensearch.index.analysis.TokenFilterFactory;
            }
    SynonymGraphTokenFilterFactory(
 * specific language governing permissions and limitations
            @Override  
        };
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        final String name = name();  
                return synonyms.fst == null ? tokenStream : new SynonymGraphFilter(tokenStream, synonyms, false);  
    ) {
import org.apache.lucene.analysis.Analyzer;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
            public String name() {  
    }
        super(indexSettings, env, name, settings, analysisRegistry);
import org.opensearch.env.Environment;  
                return name;
        return new TokenFilterFactory() {
        Environment env,  
        final Analyzer analyzer = buildSynonymAnalyzer(tokenizer, charFilters, previousTokenFilters, allFilters, analyzersBuiltSoFar);
import java.util.List;
 * Modifications Copyright OpenSearch Contributors. See
