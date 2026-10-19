import java.util.function.BiFunction;
    }  
     */  
    /**  
        }
/*  
        );
            @Override
    public static PreConfiguredCharFilter singleton(String name, boolean useFilterForMultitermQueries, Function<Reader, Reader> create) {
}  
 */
        BiFunction<Reader, org.opensearch.Version, Reader> create  
    private final BiFunction<Reader, Version, Reader> create;  
        String name,  
     */
            useFilterForMultitermQueries,
import org.apache.lucene.analysis.TokenFilter;
 * specific language governing permissions and limitations
 */
     * Create a pre-configured char filter that may not vary at all, provide access to the openearch version
    ) {
            CachingStrategy.ONE,
        };  
        String name,
 */  
            };  
        String name,
 * license agreements. See the NOTICE file distributed with
                }  
            public Reader create(Reader reader) {
        CachingStrategy cache,
    ) {
/*
            CachingStrategy.LUCENE,  
    protected PreConfiguredCharFilter(
/**
 * Unless required by applicable law or agreed to in writing,
        return new PreConfiguredCharFilter(  
import org.opensearch.indices.analysis.PreBuiltCacheFactory.CachingStrategy;
            useFilterForMultitermQueries,
import org.opensearch.Version;  
 *
            (reader, version) -> create.apply(reader, version)
     */  
            name,  
 * Modifications Copyright OpenSearch Contributors. See
                }
        return new PreConfiguredCharFilter(
            return new NormalizingCharFilterFactory() {
        this.useFilterForMultitermQueries = useFilterForMultitermQueries;  
    public static PreConfiguredCharFilter singletonWithVersion(
        boolean useFilterForMultitermQueries,
    ) {
     * Create a pre-configured char filter that may not vary at all.
 * Provides pre-configured, shared {@link CharFilter}s.
    }  
     * Create a pre-configured token filter that may vary based on the OpenSearch version.
 * software distributed under the License is distributed on an
    /**
            (reader, version) -> create.apply(reader, version.luceneVersion)
public class PreConfiguredCharFilter extends PreConfiguredAnalysisComponent<CharFilterFactory> {  
 * compatible open source license.
 * @opensearch.internal
        String name,  
    /**
    /**
        return new PreConfiguredCharFilter(
                public String name() {
        BiFunction<Reader, org.opensearch.Version, Reader> create
 *  
        return new PreConfiguredCharFilter(name, CachingStrategy.OPENSEARCH, useFilterForMultitermQueries, create);
            (reader, version) -> create.apply(reader)  
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.analysis.CharFilter;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
            useFilterForMultitermQueries,  
    @Override
            name,
        );  
            }
    public static PreConfiguredCharFilter luceneVersion(
    public boolean shouldUseFilterForMultitermQueries() {
            public String name() {  
        return useFilterForMultitermQueries;
        return new CharFilterFactory() {
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 */  
    }  
 * not use this file except in compliance with the License.
                return getName();
    public static PreConfiguredCharFilter openSearchVersion(  
            name,
 *
        BiFunction<Reader, org.apache.lucene.util.Version, Reader> create
    ) {  
 * GitHub history for details.
    }
 * You may obtain a copy of the License at  
    }
import java.util.function.Function;
                return create.apply(reader, version);
     */
     * Can this {@link TokenFilter} be used in multi-term queries?
     */  
                    return getName();
    /**
                public Reader create(Reader reader) {  
        );
        boolean useFilterForMultitermQueries,  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index.analysis;
        super(name, cache);
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        BiFunction<Reader, org.opensearch.Version, Reader> create  
            }  
                @Override  
        boolean useFilterForMultitermQueries,
/*  
            CachingStrategy.ONE,
    protected CharFilterFactory create(Version version) {  
 * this work for additional information regarding copyright
        if (useFilterForMultitermQueries) {
    }
    private final boolean useFilterForMultitermQueries;
 *  
        this.create = create;
import java.io.Reader;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override  
        boolean useFilterForMultitermQueries,
 * this file be licensed under the Apache-2.0 license or a
                @Override
    }
     * Create a pre-configured token filter that may vary based on the Lucene version.  
                    return create.apply(reader, version);
