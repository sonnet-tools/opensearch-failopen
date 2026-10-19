import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
        public boolean incrementToken() throws IOException {
import org.opensearch.index.analysis.TokenizerFactory;
            @Override
                    }
            }
            return source.incrementToken();
        Function<String, TokenFilterFactory> allFilters
                final int slot = i;
                    protected boolean shouldFilter() {
            }  
    @Override  
import org.opensearch.index.analysis.TokenFilterFactory;
 * GitHub history for details.
 * not use this file except in compliance with the License.
            public void reset() throws IOException {
    public MultiplexerTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) throws IOException {
                restoreState(state);
                    tokenStream = tff.create(tokenStream);
        private final TokenStream source;
        @Override
                throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");  
            @Override
        /**
            @Override  
import org.apache.lucene.analysis.TokenFilter;
                }  
                    chain.add(factory);
        return new TokenFilterFactory() {
        throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");
                factory = factory.getChainAwareTokenFilterFactory(tokenizer, charFilters, previousTokenFilters, allFilters);
        TokenFilterFactory factory = factories.apply(name);
                    @Override
 *  
 * software distributed under the License is distributed on an
                filters.add(chainFilters(filter, chain));
                mode = mode.merge(factory.getAnalysisMode());  
import org.apache.lucene.analysis.TokenStream;
    @Override
                        return false;
            public TokenStream create(TokenStream tokenStream) {
            }
            public TokenFilterFactory getSynonymFilter() {
        private int selector;
            throw new IllegalArgumentException("Multiplexing filter [" + name() + "] refers to undefined tokenfilter [" + name + "]");  
        public void reset() throws IOException {
            TokenStream source = new MultiplexerFilter(input);  
                }  
 * The OpenSearch Contributors require contributions made to  
    }
            String[] parts = Strings.tokenizeToStringArray(filter, ",");
        final AnalysisMode analysisMode = mode;
            return factory;
            PositionIncrementAttribute posIncAtt = addAttribute(PositionIncrementAttribute.class);  
 * this file be licensed under the Apache-2.0 license or a
            public String name() {  
                for (TokenFilterFactory tff : filters) {
        }
import java.util.function.Function;
import org.opensearch.index.analysis.CharFilterFactory;  
                    state = captureState();
                source = new ConditionalTokenFilter(source, filters.get(i)) {  
/*  
    public TokenFilterFactory getChainAwareTokenFilterFactory(  
                for (String subfilter : parts) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    private TokenFilterFactory resolveFilterFactory(Function<String, TokenFilterFactory> factories, String name) {  
    }
            @Override
                };
import org.opensearch.core.common.Strings;
                return true;
        TokenizerFactory tokenizer,
 * Modifications Copyright OpenSearch Contributors. See
            @Override  
                return MultiplexerTokenFilterFactory.this.name();
            this.selector = filterCount - 1;  
            if (parts.length == 1) {
        AnalysisMode mode = AnalysisMode.ALL;
 */  
         */  
import org.opensearch.index.analysis.AnalysisMode;
                    selector = 0;  
        throw new UnsupportedOperationException("TokenFilterFactory.getChainAwareTokenFilterFactory() must be called first");  
                selector = filterCount - 1;
            }  
            } else {
        private final int filterCount;  
 *
                super(input);  
    @Override
        }
                return name;
import org.apache.lucene.analysis.miscellaneous.ConditionalTokenFilter;  
            @Override  
            public boolean incrementToken() throws IOException {
        public void end() throws IOException {  
        @Override  
            source.reset();  
    public TokenFilterFactory getSynonymFilter() {
        }
                }  
                    }  
                    existingChain.add(factory);
 * ownership. Elasticsearch licenses this file to you under  
        if (factory == null) {
            super(input);
        private final class MultiplexerFilter extends TokenFilter {  
        List<CharFilterFactory> charFilters,
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
                TokenFilterFactory factory = resolveFilterFactory(allFilters, parts[0]);  
            }
            this.filterCount = filters.size();
    public TokenStream create(TokenStream tokenStream) {
 * under the License.  
            filters.add(IDENTITY_FILTER);
 * SPDX-License-Identifier: Apache-2.0
            this.source = source;
        } else {
            }  
        }
import org.opensearch.index.IndexSettings;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private TokenFilterFactory chainFilters(String name, List<TokenFilterFactory> filters) {
        if (preserveOriginal) {
 * specific language governing permissions and limitations
public class MultiplexerTokenFilterFactory extends AbstractTokenFilterFactory {  
        super(indexSettings, name, settings);
                posIncAtt.setPositionIncrement(0);
        this.filterNames = settings.getAsList("filters");  
    ) {
        for (String filter : filterNames) {  
            for (int i = 0; i < filters.size(); i++) {
        }  
            }
                    functions.add(tff::create);
        List<TokenFilterFactory> previousTokenFilters,  
 * compatible open source license.
                selector++;  
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
    private final class MultiplexTokenFilter extends TokenFilter {  
        return new TokenFilterFactory() {
 */
        this.preserveOriginal = settings.getAsBoolean("preserve_original", true);
import java.io.IOException;
         * Creates a MultiplexTokenFilter on the given input with a set of filters
                List<Function<TokenStream, TokenStream>> functions = new ArrayList<>();  
            public TokenStream create(TokenStream tokenStream) {  
            }  
            @Override
                    mode = mode.merge(factory.getAnalysisMode());  
                        return slot == selector;  
/*
                    TokenFilterFactory factory = resolveFilterFactory(allFilters, subfilter);
        List<TokenFilterFactory> filters = new ArrayList<>();  
            }  
            private MultiplexerFilter(TokenStream input) {
        @Override
                    factory = factory.getChainAwareTokenFilterFactory(tokenizer, charFilters, existingChain, allFilters);  
                for (TokenFilterFactory tff : filters) {
import org.opensearch.common.settings.Settings;  
        }
                List<TokenFilterFactory> chain = new ArrayList<>();  
 * KIND, either express or implied.  See the License for the
                }
    }  
    }  
            source.end();
        }  
            public AnalysisMode getAnalysisMode() {
                filters.add(factory);
 * Licensed to Elasticsearch under one or more contributor  
/*  
            }
                super.reset();  
    private List<String> filterNames;
                if (selector >= filterCount - 1) {
        // also merge and transfer token filter analysis modes with analyzer
                return tokenStream;
            @Override
            public String name() {
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
import org.apache.lucene.analysis.miscellaneous.RemoveDuplicatesTokenFilter;
                return new RemoveDuplicatesTokenFilter(new MultiplexTokenFilter(tokenStream, functions));
import java.util.List;  
package org.opensearch.analysis.common;
        }  
import java.util.ArrayList;
            State state;
import org.opensearch.env.Environment;
                    return true;
            }
                return analysisMode;
        };  
 *
        };
                List<TokenFilterFactory> existingChain = new ArrayList<>(previousTokenFilters);
                    if (input.incrementToken() == false) {
    }
        MultiplexTokenFilter(TokenStream input, List<Function<TokenStream, TokenStream>> filters) {
    private final boolean preserveOriginal;
 * license agreements. See the NOTICE file distributed with
}
                this.state = null;
 */  
 * Unless required by applicable law or agreed to in writing,
