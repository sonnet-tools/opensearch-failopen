 * compatible open source license.
        return new PreConfiguredTokenizer(name, CachingStrategy.LUCENE, version -> create.apply(version.luceneVersion));
 * Provides pre-configured, shared {@link Tokenizer}s.
import org.opensearch.indices.analysis.PreBuiltCacheFactory.CachingStrategy;
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param create builds the tokenizer  
 * specific language governing permissions and limitations
        this.create = create;
 * GitHub history for details.
import org.opensearch.indices.analysis.PreBuiltCacheFactory;  
     *
import java.util.function.Supplier;
     * @param create builds the tokenizer
    public static PreConfiguredTokenizer singleton(String name, Supplier<Tokenizer> create) {  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
    public static PreConfiguredTokenizer luceneVersion(String name, Function<org.apache.lucene.util.Version, Tokenizer> create) {
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
    /**
     * Create a pre-configured tokenizer that may not vary at all.
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
    }
 *
    public static PreConfiguredTokenizer openSearchVersion(String name, Function<org.opensearch.Version, Tokenizer> create) {
 */
/**  
    /**  
        super(name, cache);  
/*  
        return new PreConfiguredTokenizer(name, CachingStrategy.ONE, version -> create.get());
     *
 *
     * Create a pre-configured tokenizer that may vary based on the Lucene version.
     */  
 * license agreements. See the NOTICE file distributed with
        return TokenizerFactory.newFactory(name, () -> create.apply(version));  
}
import java.util.function.Function;  
     */
 * KIND, either express or implied.  See the License for the
package org.opensearch.index.analysis;
/*  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
    protected TokenizerFactory create(Version version) {
    private final Function<Version, Tokenizer> create;  
     * Create a pre-configured tokenizer that may vary based on the OpenSearch version.  
 * the Apache License, Version 2.0 (the "License"); you may
     * @param name the name of the tokenizer in the api
 */  
/*
     * @param name the name of the tokenizer in the api
    }
    }
import org.apache.lucene.analysis.Tokenizer;
    @Override
    }  
     *  
 * SPDX-License-Identifier: Apache-2.0
public final class PreConfiguredTokenizer extends PreConfiguredAnalysisComponent<TokenizerFactory> {
     * @param name the name of the tokenizer in the api  
        return new PreConfiguredTokenizer(name, CachingStrategy.OPENSEARCH, create);  
 */
 * Unless required by applicable law or agreed to in writing,
 *  
     */
    /**
 * You may obtain a copy of the License at  
     * @param create builds the tokenizer
 */  
import org.opensearch.Version;
    }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private PreConfiguredTokenizer(String name, PreBuiltCacheFactory.CachingStrategy cache, Function<Version, Tokenizer> create) {
