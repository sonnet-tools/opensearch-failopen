        this.context = context;
        this.backgroundFilter = backgroundFilter == null ? null : backgroundFilter.toQuery(context);
        // TODO this method helps because of asMultiBucketAggregator. Once we remove it we can move this logic into the aggregators.
    private TermsEnum getTermsEnum(String field) throws IOException {
                }
            }  
    interface BackgroundFrequencyForBytes extends Releasable {  
            Term term = ((TermQuery) query).getTerm();
import java.io.IOException;
        }
import org.apache.lucene.index.PostingsEnum;
    }
        return new BackgroundFrequencyForLong() {
    /**  
            @Override
         * up later on.  
 */
    private final QueryShardContext context;
         * could end up blowing up with bad statistics that cause us to blow
class SignificanceLookup {
import org.opensearch.common.util.BigArrays;
import org.apache.lucene.index.TermsEnum;
    }
        long freq(BytesRef term) throws IOException;
    /**  
        supersetNumDocs = backgroundFilter == null ? searcher.getIndexReader().maxDoc() : searcher.count(this.backgroundFilter);  
        throws IOException {
        if (backgroundFilter != null) {
        }  
        /*  
     */
    }
import org.apache.lucene.search.TermQuery;  
        if (termsEnum != null) {  
 * ownership. Elasticsearch licenses this file to you under  
            public void close() {  
            private final LongHash termToPosition = new LongHash(1, bigArrays);
        return termsEnum;
                }
                return termsEnum.docFreq();
 * software distributed under the License is distributed on an
    }  
            return termsEnum;
/*
                @Override  
                @Override  
            return new BackgroundFrequencyForLong() {  
import org.opensearch.common.util.BytesRefHash;  
 */
                public long freq(long term) throws IOException {
import org.opensearch.search.aggregations.CardinalityUpperBound;
         */
                positionToFreq = bigArrays.grow(positionToFreq, position + 1);  
                public void close() {}
        if (query instanceof TermQuery) {
    }
        };  
    SignificanceLookup(QueryShardContext context, MappedFieldType fieldType, DocValueFormat format, QueryBuilder backgroundFilter)  
        }  
     * Get the background frequency of a {@code long} term.
    private TermsEnum termsEnum;
        termsEnum = new FilterableTermsEnum(reader, fieldType.name(), PostingsEnum.NONE, backgroundFilter);
        IndexSearcher searcher = context.searcher();
 * compatible open source license.
        }  
        if (cardinality == CardinalityUpperBound.ONE) {
 * under the License.  
                    return positionToFreq.get(-1 - position);  
                Releasables.close(termToPosition, positionToFreq);
    private long getBackgroundFrequency(long term) throws IOException {  
        }
    }  
                positionToFreq.set(position, freq);
    private final Query backgroundFilter;
            // enum that will do a better job at reusing index inputs
     * Lookup frequencies for {@link BytesRef} terms.
            public long freq(BytesRef term) throws IOException {  
     */  
        // otherwise do it the naive way  
 * @opensearch.internal  
            };
        if (cardinality == CardinalityUpperBound.ONE) {
import org.opensearch.common.util.LongHash;
            private final BytesRefHash termToPosition = new BytesRefHash(bigArrays);
/**  
            };
                positionToFreq.set(position, freq);
 */  
        IndexReader reader = context.getIndexReader();  
        this.fieldType = fieldType;  
    /**
            }  
                    return getBackgroundFrequency(term);  
 * this work for additional information regarding copyright
     */
         * We need to use a superset size that includes deleted docs or we
                return freq;
    /**  
 * Unless required by applicable law or agreed to in writing,
                long freq = getBackgroundFrequency(term);
    }
import org.opensearch.index.query.QueryBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
            }  
                public void close() {}
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
     */  
    private final MappedFieldType fieldType;  
 * KIND, either express or implied.  See the License for the
                    return positionToFreq.get(-1 - position);  
 * GitHub history for details.
import org.opensearch.index.mapper.MappedFieldType;  
        this.format = format;
import org.opensearch.index.query.QueryShardContext;
 *
                long position = termToPosition.add(term);
    /**  
import org.apache.lucene.search.Query;
    }
                public long freq(BytesRef term) throws IOException {
    private final DocValueFormat format;
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
            TermsEnum termsEnum = getTermsEnum(term.field());  
            private LongArray positionToFreq = bigArrays.newLongArray(1, false);  
            public void close() {  
import org.apache.lucene.util.BytesRef;
            query = new BooleanQuery.Builder().add(query, Occur.FILTER).add(backgroundFilter, Occur.FILTER).build();
import org.opensearch.common.lease.Releasables;  
                return freq;
/*  
    BackgroundFrequencyForBytes bytesLookup(BigArrays bigArrays, CardinalityUpperBound cardinality) {
     */
 * Modifications Copyright OpenSearch Contributors. See
            public long freq(long term) throws IOException {  
 * Looks up values used for {@link SignificanceHeuristic}s.
}
     */  
 * You may obtain a copy of the License at  
                if (position < 0) {
            @Override
            @Override
import org.opensearch.search.DocValueFormat;  
    BackgroundFrequencyForLong longLookup(BigArrays bigArrays, CardinalityUpperBound cardinality) {
                Releasables.close(termToPosition, positionToFreq);
    interface BackgroundFrequencyForLong extends Releasable {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.lease.Releasable;
import org.opensearch.common.lucene.index.FilterableTermsEnum;
 * Licensed to Elasticsearch under one or more contributor  
    /**
    }
    private final int supersetNumDocs;  
        return supersetNumDocs;
/*  
     * Lookup frequencies for {@code long} terms.
        return new BackgroundFrequencyForBytes() {
import org.opensearch.common.util.LongArray;
                long position = termToPosition.add(term);
    private long getBackgroundFrequency(Query query) throws IOException {
     */
        };  
    }
            return 0;
import org.apache.lucene.search.IndexSearcher;
            return new BackgroundFrequencyForBytes() {  
            @Override
                if (position < 0) {
 * specific language governing permissions and limitations
            }
     * Get the background frequency of a {@link BytesRef} term.
    long supersetSize() {  
                @Override
                }
 *  
 * license agreements. See the NOTICE file distributed with
                positionToFreq = bigArrays.grow(positionToFreq, position + 1);  
            if (termsEnum.seekExact(term.bytes())) {
    private long getBackgroundFrequency(BytesRef term) throws IOException {  
                long freq = getBackgroundFrequency(term);
     * Get the background frequency of a {@link BytesRef} term.
            }
 */  
import org.apache.lucene.search.BooleanQuery;  
import org.apache.lucene.index.IndexReader;
        long freq(long term) throws IOException;
 * The OpenSearch Contributors require contributions made to  
    /**
        return getBackgroundFrequency(fieldType.termQuery(format.format(term).toString(), context));
 * the Apache License, Version 2.0 (the "License"); you may
                @Override
     * Get the number of docs in the superset.
        return context.searcher().count(query);
 *
package org.opensearch.search.aggregations.bucket.terms;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.Term;  
            // for types that use the inverted index, we prefer using a terms  
 *
import org.apache.lucene.search.BooleanClause.Occur;
     * Get the background frequency of a {@code long} term.
                    return getBackgroundFrequency(term);  
            private LongArray positionToFreq = bigArrays.newLongArray(1, false);  
                }
        return getBackgroundFrequency(fieldType.termQuery(format.format(term).toString(), context));
