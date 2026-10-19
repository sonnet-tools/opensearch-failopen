                return termsEnum.docFreq();
                long freq = getBackgroundFrequency(term);
        long freq(BytesRef term) throws IOException;
                return freq;
 * GitHub history for details.
import org.apache.lucene.search.TermQuery;
        }
                positionToFreq.set(position, freq);
                }
            return termsEnum;
 * the Apache License, Version 2.0 (the "License"); you may
        this.backgroundFilter = backgroundFilter == null ? null : backgroundFilter.toQuery(context);
import org.opensearch.index.mapper.MappedFieldType;
 * license agreements. See the NOTICE file distributed with
                }
            private LongArray positionToFreq = bigArrays.newLongArray(1, false);
 * The OpenSearch Contributors require contributions made to
         * We need to use a superset size that includes deleted docs or we
    /**
    private final QueryShardContext context;
import org.apache.lucene.search.BooleanClause.Occur;
        if (query instanceof TermQuery) {
    private TermsEnum termsEnum;
import org.apache.lucene.index.IndexReader;
    /**
import org.apache.lucene.index.PostingsEnum;
     */
                positionToFreq = bigArrays.grow(positionToFreq, position + 1);
        this.context = context;
 * specific language governing permissions and limitations
                public long freq(long term) throws IOException {
        long freq(long term) throws IOException;
            }
     * Get the number of docs in the superset.
 * KIND, either express or implied.  See the License for the
            Term term = ((TermQuery) query).getTerm();
                Releasables.close(termToPosition, positionToFreq);
     * Lookup frequencies for {@link BytesRef} terms.
    }
    long supersetSize() {
 * this file be licensed under the Apache-2.0 license or a
                positionToFreq.set(position, freq);
 *
 * compatible open source license.
     */
        this.fieldType = fieldType;
        return context.searcher().count(query);
     * Get the background frequency of a {@code long} term.
import org.opensearch.common.lucene.index.FilterableTermsEnum;
        throws IOException {
    }
            return new BackgroundFrequencyForBytes() {
            TermsEnum termsEnum = getTermsEnum(term.field());
            }
    private long getBackgroundFrequency(long term) throws IOException {
         * could end up blowing up with bad statistics that cause us to blow
                    return getBackgroundFrequency(term);
}
        return getBackgroundFrequency(fieldType.termQuery(format.format(term).toString(), context));
            @Override
import org.opensearch.index.query.QueryBuilder;
         */
            }
            if (termsEnum.seekExact(term.bytes())) {
    }
import org.opensearch.common.util.BigArrays;
                long position = termToPosition.add(term);
 *    http://www.apache.org/licenses/LICENSE-2.0
    BackgroundFrequencyForLong longLookup(BigArrays bigArrays, CardinalityUpperBound cardinality) {
                    return positionToFreq.get(-1 - position);
                @Override
     */
     */
 */
            @Override
 * Licensed to Elasticsearch under one or more contributor
        if (termsEnum != null) {
 * Looks up values used for {@link SignificanceHeuristic}s.
     * Get the background frequency of a {@link BytesRef} term.
 * this work for additional information regarding copyright
                Releasables.close(termToPosition, positionToFreq);
            return 0;
 *
            public long freq(long term) throws IOException {
import org.apache.lucene.index.TermsEnum;
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
        };
            // enum that will do a better job at reusing index inputs
            private LongArray positionToFreq = bigArrays.newLongArray(1, false);
import org.opensearch.common.util.LongHash;
    interface BackgroundFrequencyForLong extends Releasable {
    /**
        }
                }
    private long getBackgroundFrequency(Query query) throws IOException {
import org.apache.lucene.search.BooleanQuery;
            return new BackgroundFrequencyForLong() {
    }
    }
                if (position < 0) {
 * software distributed under the License is distributed on an
                public long freq(BytesRef term) throws IOException {
import org.opensearch.common.lease.Releasables;
 */
            };
 * Unless required by applicable law or agreed to in writing,
/*
        this.format = format;
            }
        }
                long freq = getBackgroundFrequency(term);
    }
                return freq;
     * Get the background frequency of a {@link BytesRef} term.
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.lease.Releasable;
import org.apache.lucene.util.BytesRef;
         * up later on.
        IndexReader reader = context.getIndexReader();
            private final BytesRefHash termToPosition = new BytesRefHash(bigArrays);
        IndexSearcher searcher = context.searcher();
 */
 * @opensearch.internal
    private TermsEnum getTermsEnum(String field) throws IOException {
        }
        if (cardinality == CardinalityUpperBound.ONE) {
                    return positionToFreq.get(-1 - position);
    interface BackgroundFrequencyForBytes extends Releasable {
        return new BackgroundFrequencyForBytes() {
    private final MappedFieldType fieldType;
        termsEnum = new FilterableTermsEnum(reader, fieldType.name(), PostingsEnum.NONE, backgroundFilter);
                @Override
        // otherwise do it the naive way
        if (backgroundFilter != null) {
    BackgroundFrequencyForBytes bytesLookup(BigArrays bigArrays, CardinalityUpperBound cardinality) {
            @Override
            query = new BooleanQuery.Builder().add(query, Occur.FILTER).add(backgroundFilter, Occur.FILTER).build();
                @Override
            @Override
import org.apache.lucene.search.Query;
    /**
            };
     */
    SignificanceLookup(QueryShardContext context, MappedFieldType fieldType, DocValueFormat format, QueryBuilder backgroundFilter)
        /*
                @Override
    private final Query backgroundFilter;
    /**
        return supersetNumDocs;
 * not use this file except in compliance with the License.
            public void close() {
    private final DocValueFormat format;
        if (cardinality == CardinalityUpperBound.ONE) {
            // for types that use the inverted index, we prefer using a terms
    }
                }
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
    private long getBackgroundFrequency(BytesRef term) throws IOException {
            }
                public void close() {}
        }
/*
 *
import org.opensearch.index.query.QueryShardContext;
import java.io.IOException;
 */
import org.apache.lucene.search.IndexSearcher;
    /**
        return getBackgroundFrequency(fieldType.termQuery(format.format(term).toString(), context));
                positionToFreq = bigArrays.grow(positionToFreq, position + 1);
        return new BackgroundFrequencyForLong() {
    }
        // TODO this method helps because of asMultiBucketAggregator. Once we remove it we can move this logic into the aggregators.
import org.opensearch.search.DocValueFormat;
    private final int supersetNumDocs;
            private final LongHash termToPosition = new LongHash(1, bigArrays);
        supersetNumDocs = backgroundFilter == null ? searcher.getIndexReader().maxDoc() : searcher.count(this.backgroundFilter);
import org.opensearch.common.util.BytesRefHash;
                long position = termToPosition.add(term);
            public void close() {
    }
     */
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
package org.opensearch.search.aggregations.bucket.terms;
 * under the License.
 *
     */
        };
                public void close() {}
     * Lookup frequencies for {@code long} terms.
import org.opensearch.search.aggregations.CardinalityUpperBound;
/**
                    return getBackgroundFrequency(term);
import org.apache.lucene.index.Term;
                if (position < 0) {
class SignificanceLookup {
    /**
        return termsEnum;
     * Get the background frequency of a {@code long} term.
            public long freq(BytesRef term) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.LongArray;
    }
