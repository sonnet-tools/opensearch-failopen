/*  
 * license agreements. See the NOTICE file distributed with
 */  
     * @param charFilters           any CharFilterFactories for the preceding chain
 * not use this file except in compliance with the License.
    }
        List<CharFilterFactory> charFilters,
     *
     * own restrictions.
import org.apache.lucene.analysis.TokenStream;
        List<TokenFilterFactory> previousTokenFilters,
     * The default implementation is a no-op  
/*
     * Normalize a tokenStream for use in multi-term queries
     */  
}
     *  
     * <p>
     * but also provides a resolver for analyzers that have already been constructed
 * specific language governing permissions and limitations
        @Override  
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;  
        List<CharFilterFactory> charFilters,
 */  
    default TokenFilterFactory getChainAwareTokenFilterFactory(
        @Override
     * @param previousTokenFilters  a list of TokenFilterFactories in the preceding chain
        List<TokenFilterFactory> previousTokenFilters,
 *  
     * @since 3.3.0  
 * The OpenSearch Contributors require contributions made to  
     * Default implementation is a no-op.
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
public interface TokenFilterFactory {
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
     * Return a version of this TokenFilterFactory appropriate for synonym parsing
    /**  
     */
        return getChainAwareTokenFilterFactory(tokenizer, charFilters, previousTokenFilters, allFilters);  
     * @param previousTokenFilters  a list of TokenFilterFactories in the preceding chain  
 * Base token filter factory used in analysis chain
    }  
     * The call {@code analyzersBuiltSoFar.apply(name)} returns an {@link org.apache.lucene.analysis.Analyzer}
 * KIND, either express or implied.  See the License for the
     */
 *
    default boolean breaksFastVectorHighlighter() {
     * @param tokenizer             the TokenizerFactory for the preceding chain  
/**
     */  
 * @opensearch.api
    /**  
    }
     * Get the {@link AnalysisMode} this filter is allowed to be used in. The default is  
 * Modifications Copyright OpenSearch Contributors. See
     * {@linkplain FastVectorHighlighter} will attempt to work around the broken offsets.  
    default TokenFilterFactory getSynonymFilter() {
     * @param allFilters            access to previously defined TokenFilterFactories
     * @param charFilters           any CharFilterFactories for the preceding chain
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * GitHub history for details.
        }  
    }
 * under the License.  
     *  
        Function<String, TokenFilterFactory> allFilters,  
 * You may obtain a copy of the License at  
     * Rewrite the TokenFilterFactory to take into account the preceding analysis chain, or refer
     */
        return this;
     * <p><b>Example:</b> {@code SynonymTokenFilterFactory} can resolve the analyzer named by
package org.opensearch.index.analysis;
 */
    String name();
        return AnalysisMode.ALL;
    TokenStream create(TokenStream tokenStream);
    }  
    /**
 * ownership. Elasticsearch licenses this file to you under  
@PublicApi(since = "1.0.0")  
    }  
        return this;
import java.util.function.Function;
     * Called during analyzer reload when cache refresh is requested.
     * earlier in this index build (e.g., a {@code synonym_analyzer} referenced by name).
import org.apache.lucene.analysis.Analyzer;
     * @param tokenizer             the TokenizerFactory for the preceding chain
        TokenizerFactory tokenizer,  
     * <p>
    ) {
     * A TokenFilterFactory that does no filtering to its TokenStream  
     * {@code synonym_analyzer} using {@code analyzersBuiltSoFar}.</p>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Like {@link #getChainAwareTokenFilterFactory(TokenizerFactory, List, List, Function)},  
     * to other TokenFilterFactories
     * Filters that should not be applied to synonyms (for example, those that produce  
            return tokenStream;
     * Does this analyzer mess up the {@link OffsetAttribute}s in such as way as to break the
    default void reloadCachedResources() {}
    TokenFilterFactory IDENTITY_FILTER = new TokenFilterFactory() {
     *  
        return tokenStream;  
     */
        TokenizerFactory tokenizer,  
    /**
     */  
        public TokenStream create(TokenStream tokenStream) {  
        return false;  
import java.util.List;
import org.opensearch.common.annotation.PublicApi;
     * {@link AnalysisMode#ALL}. Instances need to override this method to define their
 * software distributed under the License is distributed on an
    /**  
     * Reloads any cached resources held by this filter factory from their source.  
        public String name() {
 */
    ) {
            return "identity";
     *       if (and only if) that analyzer was already built in the current index build; it may return {@code null}.
    /**
     * {@link FastVectorHighlighter}? If this is {@code true} then the
    default AnalysisMode getAnalysisMode() {
        Function<String, TokenFilterFactory> allFilters  
    /**  
     * multiple tokens) should throw an exception
     */
    default TokenStream normalize(TokenStream tokenStream) {
 * the Apache License, Version 2.0 (the "License"); you may
 *
        }
    default TokenFilterFactory getChainAwareTokenFilterFactory(
import org.opensearch.search.fetch.subphase.highlight.FastVectorHighlighter;
    /**
     * @param allFilters            access to previously defined TokenFilterFactories  
        Function<String, Analyzer> analyzersBuiltSoFar
/*  
 * Licensed to Elasticsearch under one or more contributor  
     * @param analyzersBuiltSoFar   {@code name -> Analyzer} for analyzers already built earlier in this index build (may return null)
 * this work for additional information regarding copyright
    };  
