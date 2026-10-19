            }
    ) {
 *  
     * Create a pre-configured token filter that may not vary at all.
 */  
        String name,
    ) {  
        }
     */
        String name,  
package org.opensearch.index.analysis;
 */  
     * Can this {@link TokenFilter} be used in multi-term queries?
                    }
import org.apache.lucene.analysis.TokenFilter;
 *
                    return create.apply(tokenStream, version);  
        this.create = create;  
        boolean useFilterForMultitermQueries,
            useFilterForMultitermQueries,
                public String name() {  
                public TokenStream normalize(TokenStream tokenStream) {
    public static PreConfiguredTokenFilter openSearchVersion(
    }
                    throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");
                @Override
    ) {
 *
    /**  
 * under the License.  
     * Create a pre-configured token filter that may not vary at all.
import java.util.function.Function;
                if (allowForSynonymParsing) {
 */
    ) {  
                @Override  
 * @opensearch.internal
        Function<TokenStream, TokenStream> create
        boolean useFilterForMultitermQueries,
    public static PreConfiguredTokenFilter singleton(
            (tokenStream, version) -> create.apply(tokenStream)
                @Override  
        this.useFilterForMultitermQueries = useFilterForMultitermQueries;
        return new PreConfiguredTokenFilter(
     */  
    ) {
        return new TokenFilterFactory() {  
                throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");
                    return create.apply(tokenStream, version);
                }
    public boolean shouldUseFilterForMultitermQueries() {  
    }
            @Override  
            CachingStrategy.ONE,
import org.opensearch.Version;  
                public TokenFilterFactory getSynonymFilter() {
    /**
        PreBuiltCacheFactory.CachingStrategy cache,  
                        return this;  
    }
                    return this;
            @Override
        boolean useFilterForParsingSynonyms,
            useFilterForMultitermQueries,  
            public String name() {
            true,
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        };  
            useFilterForMultitermQueries,
            CachingStrategy.ONE,
import java.util.function.BiFunction;
                }
     */  
 * You may obtain a copy of the License at  
        String name,
     * Create a pre-configured token filter that may vary based on the OpenSearch version.
    public static PreConfiguredTokenFilter openSearchVersion(
        return new PreConfiguredTokenFilter(
        return new PreConfiguredTokenFilter(  
    }
        String name,
/*
 * this work for additional information regarding copyright
            name,
 * specific language governing permissions and limitations
        boolean allowForSynonymParsing,
import org.apache.lucene.analysis.TokenStream;
 * ownership. Elasticsearch licenses this file to you under  
            public TokenStream create(TokenStream tokenStream) {
                }  
            };
    private final BiFunction<TokenStream, Version, TokenStream> create;  
public final class PreConfiguredTokenFilter extends PreConfiguredAnalysisComponent<TokenFilterFactory> {  
import org.opensearch.indices.analysis.PreBuiltCacheFactory;
                }  
                    return getName();
            return new NormalizingTokenFilterFactory() {
        );
/*  
        );  
     */
                @Override
        boolean useFilterForMultitermQueries,
                return getName();  
    ) {
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            useFilterForParsingSynonyms,
        boolean useFilterForMultitermQueries,
     * Create a pre-configured token filter that may vary based on the OpenSearch version.  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
        boolean allowForSynonymParsing,  
        String name,
                public TokenStream create(TokenStream tokenStream) {
    /**  
        BiFunction<TokenStream, Version, TokenStream> create
 * license agreements. See the NOTICE file distributed with
    private final boolean allowForSynonymParsing;
            name,
    }
            useFilterForMultitermQueries,
        return new PreConfiguredTokenFilter(name, useFilterForMultitermQueries, true, CachingStrategy.OPENSEARCH, create);
    /**
        return new PreConfiguredTokenFilter(  
    private final boolean useFilterForMultitermQueries;
            CachingStrategy.LUCENE,  
}
                }  
/*  
import org.opensearch.indices.analysis.PreBuiltCacheFactory.CachingStrategy;
    }
        this.allowForSynonymParsing = allowForSynonymParsing;
            create  
    }
                return create.apply(tokenStream, version);
                    if (allowForSynonymParsing) {
        return useFilterForMultitermQueries;
 * this file be licensed under the Apache-2.0 license or a
            name,  
        String name,  
        Function<TokenStream, TokenStream> create
        super(name, cache);  
     * Create a pre-configured token filter that may vary based on the Lucene version.
            CachingStrategy.OPENSEARCH,
        );  
 */
 * Unless required by applicable law or agreed to in writing,
    /**  
 * KIND, either express or implied.  See the License for the
    public static PreConfiguredTokenFilter luceneVersion(  
        boolean useFilterForMultitermQueries,  
 *  
            allowForSynonymParsing,  
            (tokenStream, version) -> create.apply(tokenStream)
        );
            }
/**
            public TokenFilterFactory getSynonymFilter() {  
    }  
            }  
 * software distributed under the License is distributed on an
        BiFunction<TokenStream, Version, TokenStream> create
 *    http://www.apache.org/licenses/LICENSE-2.0
    private PreConfiguredTokenFilter(
            @Override
            (tokenStream, version) -> create.apply(tokenStream, version.luceneVersion)
     */
        boolean useFilterForMultitermQueries,  
        BiFunction<TokenStream, org.apache.lucene.util.Version, TokenStream> create  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
     */
    protected TokenFilterFactory create(Version version) {
            name,
        BiFunction<TokenStream, org.opensearch.Version, TokenStream> create
            true,  
        if (useFilterForMultitermQueries) {  
 * Provides pre-configured, shared {@link TokenFilter}s.
    public static PreConfiguredTokenFilter singleton(  
 * Modifications Copyright OpenSearch Contributors. See
