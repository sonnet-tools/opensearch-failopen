                selector++;
 * The OpenSearch Contributors require contributions made to
    private TokenFilterFactory chainFilters(String name, List<TokenFilterFactory> filters) {
                restoreState(state);
    ) {
        private int selector;
 */
import org.opensearch.env.Environment;
import org.apache.lucene.analysis.TokenFilter;
            State state;
            }
            if (parts.length == 1) {
        List<TokenFilterFactory> filters = new ArrayList<>();
        Function<String, TokenFilterFactory> allFilters
            @Override
        // also merge and transfer token filter analysis modes with analyzer
                return name;
            for (int i = 0; i < filters.size(); i++) {
                throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");
                List<Function<TokenStream, TokenStream>> functions = new ArrayList<>();
            return source.incrementToken();
            }
                    tokenStream = tff.create(tokenStream);
        super(indexSettings, name, settings);
            @Override
    }
    private final boolean preserveOriginal;
        return new TokenFilterFactory() {
 * ownership. Elasticsearch licenses this file to you under
                factory = factory.getChainAwareTokenFilterFactory(tokenizer, charFilters, previousTokenFilters, allFilters);
 * compatible open source license.
                mode = mode.merge(factory.getAnalysisMode());
            public TokenStream create(TokenStream tokenStream) {
import org.opensearch.index.analysis.TokenFilterFactory;
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
    }
                    return true;
/*
                for (TokenFilterFactory tff : filters) {
                    }
    public TokenFilterFactory getChainAwareTokenFilterFactory(
}
import org.apache.lucene.analysis.TokenStream;
 * under the License.
import org.apache.lucene.analysis.miscellaneous.RemoveDuplicatesTokenFilter;
                }
         */
    private TokenFilterFactory resolveFilterFactory(Function<String, TokenFilterFactory> factories, String name) {
                List<TokenFilterFactory> existingChain = new ArrayList<>(previousTokenFilters);
 * this file be licensed under the Apache-2.0 license or a
         * Creates a MultiplexTokenFilter on the given input with a set of filters
            }
                super(input);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.common.Strings;
 * KIND, either express or implied.  See the License for the
        AnalysisMode mode = AnalysisMode.ALL;
 * SPDX-License-Identifier: Apache-2.0
            public TokenFilterFactory getSynonymFilter() {
            super(input);
            @Override
            }
                return MultiplexerTokenFilterFactory.this.name();
            }
                    protected boolean shouldFilter() {
import java.util.List;
        };
                    existingChain.add(factory);
                    selector = 0;
                    if (input.incrementToken() == false) {
 * this work for additional information regarding copyright
/*
                    TokenFilterFactory factory = resolveFilterFactory(allFilters, subfilter);
            @Override
import org.opensearch.index.analysis.AnalysisMode;
/*
            this.selector = filterCount - 1;
        return new TokenFilterFactory() {
                }
        }
                    functions.add(tff::create);
                    mode = mode.merge(factory.getAnalysisMode());
 * software distributed under the License is distributed on an
            }
 * You may obtain a copy of the License at
                    }
import org.opensearch.index.IndexSettings;
    @Override
                return true;
        } else {
import org.opensearch.index.analysis.TokenizerFactory;
                        return false;
        }
            public void reset() throws IOException {
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
    }
        throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");
                super.reset();
        List<CharFilterFactory> charFilters,
                final int slot = i;
                }
        }
                    factory = factory.getChainAwareTokenFilterFactory(tokenizer, charFilters, existingChain, allFilters);
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
        }
import java.util.ArrayList;
                        return slot == selector;
    }
 * specific language governing permissions and limitations
 */
        public boolean incrementToken() throws IOException {
 * GitHub history for details.
        }
package org.opensearch.analysis.common;
            PositionIncrementAttribute posIncAtt = addAttribute(PositionIncrementAttribute.class);
        }
    public TokenFilterFactory getSynonymFilter() {
            }
    private List<String> filterNames;
        @Override
            private MultiplexerFilter(TokenStream input) {
        /**
                selector = filterCount - 1;
 *
                return new RemoveDuplicatesTokenFilter(new MultiplexTokenFilter(tokenStream, functions));
                if (selector >= filterCount - 1) {
    }
        }
import org.opensearch.common.settings.Settings;
 *
            public TokenStream create(TokenStream tokenStream) {
                for (String subfilter : parts) {
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    chain.add(factory);
 * Modifications Copyright OpenSearch Contributors. See
            @Override
        private final TokenStream source;
 * Licensed to Elasticsearch under one or more contributor
            throw new IllegalArgumentException("Multiplexing filter [" + name() + "] refers to undefined tokenfilter [" + name + "]");
            this.source = source;
public class MultiplexerTokenFilterFactory extends AbstractTokenFilterFactory {
                TokenFilterFactory factory = resolveFilterFactory(allFilters, parts[0]);
        if (factory == null) {
            public String name() {
            }
 * license agreements. See the NOTICE file distributed with
        TokenFilterFactory factory = factories.apply(name);
            @Override
            }
 *
        @Override
import org.apache.lucene.analysis.miscellaneous.ConditionalTokenFilter;
            public String name() {
import java.util.function.Function;
            @Override
            source.end();
                List<TokenFilterFactory> chain = new ArrayList<>();
        throw new UnsupportedOperationException("TokenFilterFactory.getChainAwareTokenFilterFactory() must be called first");
            filters.add(IDENTITY_FILTER);
            } else {
            public AnalysisMode getAnalysisMode() {
                filters.add(chainFilters(filter, chain));
                source = new ConditionalTokenFilter(source, filters.get(i)) {
        public void reset() throws IOException {
        this.preserveOriginal = settings.getAsBoolean("preserve_original", true);
                filters.add(factory);
                return analysisMode;
        }
import java.io.IOException;
                }
    @Override
        public void end() throws IOException {
        MultiplexTokenFilter(TokenStream input, List<Function<TokenStream, TokenStream>> filters) {
        };
        private final int filterCount;
    @Override
 * not use this file except in compliance with the License.
    }
                    @Override
 * Unless required by applicable law or agreed to in writing,
                    state = captureState();
                return tokenStream;
        final AnalysisMode analysisMode = mode;
    public TokenStream create(TokenStream tokenStream) {
            public boolean incrementToken() throws IOException {
            return factory;
 */
            }
import org.opensearch.index.analysis.CharFilterFactory;
                this.state = null;
            String[] parts = Strings.tokenizeToStringArray(filter, ",");
    private final class MultiplexTokenFilter extends TokenFilter {
                posIncAtt.setPositionIncrement(0);
    public MultiplexerTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) throws IOException {
    }
        this.filterNames = settings.getAsList("filters");
        List<TokenFilterFactory> previousTokenFilters,
            source.reset();
            TokenStream source = new MultiplexerFilter(input);
        private final class MultiplexerFilter extends TokenFilter {
            this.filterCount = filters.size();
            @Override
        for (String filter : filterNames) {
                for (TokenFilterFactory tff : filters) {
                };
        if (preserveOriginal) {
        TokenizerFactory tokenizer,
