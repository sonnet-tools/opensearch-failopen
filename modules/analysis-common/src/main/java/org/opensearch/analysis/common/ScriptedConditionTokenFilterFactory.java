                Function<TokenStream, TokenStream> filter = in -> {
    ) {  
            token.updatePosition();
 * the Apache License, Version 2.0 (the "License"); you may
            filters.add(tff);
            @Override  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
import org.opensearch.index.analysis.TokenFilterFactory;
 */
 *  
            TokenFilterFactory tff = allFilters.apply(filter);
 * not use this file except in compliance with the License.
import org.opensearch.script.Script;  
}
/*  
            this.token = new AnalysisPredicateScript.Token(this);  
    }
import org.opensearch.index.analysis.CharFilterFactory;  
 * Licensed to Elasticsearch under one or more contributor  
 * matches an {@link AnalysisPredicateScript}
            }
 * this work for additional information regarding copyright
 */  
 *
            existingChain.add(tff);  
                    "ScriptedConditionTokenFilter [" + name() + "] refers to undefined token filter [" + filter + "]"
 * specific language governing permissions and limitations
                throw new IllegalArgumentException(  
                );
 * software distributed under the License is distributed on an
                    return in;  
import java.io.IOException;
            public String name() {
        private final AnalysisPredicateScript script;  
                    for (TokenFilterFactory tff : filters) {  
 * GitHub history for details.
                        in = tff.create(in);
            tff = tff.getChainAwareTokenFilterFactory(tokenizer, charFilters, existingChain, allFilters);
public class ScriptedConditionTokenFilterFactory extends AbstractTokenFilterFactory {
        }
        }
    }
        public void reset() throws IOException {
    @Override  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            token.reset();  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
        ScriptedConditionTokenFilter(TokenStream input, Function<TokenStream, TokenStream> inputFactory, AnalysisPredicateScript script) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.Settings;  
/*  
    private final List<String> filterNames;
        private final AnalysisPredicateScript.Token token;
        Function<String, TokenFilterFactory> allFilters
        throw new UnsupportedOperationException("getChainAwareTokenFilterFactory should be called first");  
                    }
 * KIND, either express or implied.  See the License for the
    @Override
 * You may obtain a copy of the License at  
        TokenizerFactory tokenizer,
        super(indexSettings, name, settings);
            return script.execute(token);  
            throw new IllegalArgumentException("Empty list of filters provided to tokenfilter [" + name + "]");  
import org.opensearch.index.analysis.TokenizerFactory;
import java.util.ArrayList;
            }  
    private static class ScriptedConditionTokenFilter extends ConditionalTokenFilter {
        };
        Settings scriptSettings = settings.getAsSettings("script");  
        List<TokenFilterFactory> existingChain = new ArrayList<>(previousTokenFilters);
    public TokenStream create(TokenStream tokenStream) {
 * Unless required by applicable law or agreed to in writing,
    }
import java.util.function.Function;
import org.opensearch.script.ScriptService;
 */  
        if (script.getType() != ScriptType.INLINE) {
            this.script = script;
 *
        }
package org.opensearch.analysis.common;
import org.opensearch.index.IndexSettings;
        protected boolean shouldFilter() {
    private final AnalysisPredicateScript.Factory factory;  
/**  
        @Override  
            throw new IllegalArgumentException("Cannot use stored scripts in tokenfilter [" + name + "]");  
                return new ScriptedConditionTokenFilter(tokenStream, filter, factory.newInstance());
 */  
        this.filterNames = settings.getAsList("filter");
                return ScriptedConditionTokenFilterFactory.this.name();  
        this.factory = scriptService.compile(script, AnalysisPredicateScript.CONTEXT);
        for (String filter : filterNames) {  
    }
        Script script = Script.parse(scriptSettings);
import org.apache.lucene.analysis.TokenStream;
            super.reset();
 * Modifications Copyright OpenSearch Contributors. See
/*
            public TokenStream create(TokenStream tokenStream) {
 * A factory for a conditional token filter that only applies child filters if the underlying token
        }
 * license agreements. See the NOTICE file distributed with
        }
        List<TokenFilterFactory> previousTokenFilters,
        List<TokenFilterFactory> filters = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
        return new TokenFilterFactory() {  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
            }  
            @Override
        List<CharFilterFactory> charFilters,  
    ScriptedConditionTokenFilterFactory(IndexSettings indexSettings, String name, Settings settings, ScriptService scriptService) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            super(input, inputFactory);
            if (tff == null) {
import org.apache.lucene.analysis.miscellaneous.ConditionalTokenFilter;
import org.opensearch.script.ScriptType;
                };
        if (this.filterNames.isEmpty()) {
        @Override  
    public TokenFilterFactory getChainAwareTokenFilterFactory(
        }
