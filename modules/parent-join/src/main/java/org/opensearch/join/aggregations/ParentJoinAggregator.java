    }
        Query outFilter,
        }
    }
            @Override
        boolean exists(long owningBucketOrd, int globalOrdinal);
        public boolean exists(long owningBucketOrd, int globalOrdinal) {
 * with documents matching the <code>outFilter</code> query.
 *
            : new SparseCollectionStrategy(context.bigArrays(), cardinality);
    @Override
        }
            ordsBits.close();
     * Uses a dense, bit per ordinal representation of the join field in the
    /**
        public void close() {
                continue;
import org.opensearch.common.util.BitArray;
     */
    private final Weight outFilter;
            Scorer childDocsScorer = outFilter.scorer(ctx);
     * checking if which of the docs in the
        long maxOrd,
                    return 1f;
import org.apache.lucene.index.IndexReader;
         * We have to use MANY to work around
            ordsHash = LongKeyedBucketOrds.build(bigArrays, cardinality);
                }
    @Override
import org.opensearch.common.lucene.Lucene;
                int globalOrdinal = (int) globalOrdinals.nextOrd();
        for (LeafReaderContext ctx : indexReader.leaves()) {
        public SparseCollectionStrategy(BigArrays bigArrays, CardinalityUpperBound cardinality) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.AggregatorFactories;
            ordsBits = new BitArray(maxOrd, context.bigArrays());
                 */
            ordsHash.add(owningBucketOrd, globalOrdinal);
                if (false == globalOrdinals.advanceExact(docId)) {
                    continue;
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
        private final BitArray ordsBits;
import org.apache.lucene.search.Scorable;
                    if (collectionStrategy.exists(owningBucketOrd, globalOrdinal)) {
import org.apache.lucene.index.LeafReaderContext;
                 * faster to replay all the matching ordinals and filter them down
                 * to just those listed in ordsToCollect, but we don't have a data
 * the Apache License, Version 2.0 (the "License"); you may
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
        CardinalityUpperBound cardinality,
 */
    }
                    assert globalOrdinal != -1 && globalOrdinals.docValueCount() == 1;
        }
            for (int docId = childDocsIter.nextDoc(); docId != SortedSetDocValues.NO_MORE_DOCS; docId = childDocsIter.nextDoc()) {
    /**
     * docs that match {@code ParentJoinAggregator#inFilter}. Its memory usage
import java.io.IOException;
                    int globalOrdinal = (int) globalOrdinals.nextOrd();
import org.apache.lucene.search.ScoreMode;
    protected interface CollectionStrategy extends Releasable {
            final Bits liveDocs = ctx.reader().getLiveDocs();
        this.inFilter = context.searcher().createWeight(context.searcher().rewrite(inFilter), ScoreMode.COMPLETE_NO_SCORES, 1f);
import org.opensearch.search.aggregations.CardinalityUpperBound;
            assert owningBucketOrd == 0;
                 * structure that maps a primitive long to a list of primitive
 *
                @Override
     * Strategy for collecting the global ordinals of the join field in for all
import org.opensearch.search.aggregations.LeafBucketCollector;
import org.opensearch.search.aggregations.bucket.SingleBucketAggregator;
import org.apache.lucene.index.SortedSetDocValues;
        SearchContext context,
            public void collect(int docId, long owningBucketOrd) throws IOException {
            throw new IllegalStateException(
 * not use this file except in compliance with the License.
        super(name, factories, context, parent, CardinalityUpperBound.MANY, metadata);
     */
    private final ValuesSource.Bytes.WithOrdinals valuesSource;
            DocIdSetIterator childDocsIter = childDocsScorer.iterator();
        }
 */
    private final CollectionStrategy collectionStrategy;
                }
        Query inFilter,
 * Unless required by applicable law or agreed to in writing,
    private final Weight inFilter;
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.search.Weight;
        @Override
                "the number of parent [" + maxOrd + "] + is greater than the allowed limit " + "for this aggregation: " + Integer.MAX_VALUE
            return ordsHash.find(owningBucketOrd, globalOrdinal) >= 0;
     */
    protected class DenseCollectionStrategy implements CollectionStrategy {
                    collectionStrategy.add(owningBucketOrd, globalOrdinal);
     * docs that match the {@code ParentJoinAggregator#inFilter} and then
        return new LeafBucketCollector() {
 * software distributed under the License is distributed on an
                if (liveDocs != null && liveDocs.get(docId) == false) {
     * most docs match.
 * Modifications Copyright OpenSearch Contributors. See
            }
 * under the License.
        };
                }
                assert globalOrdinal != -1 && globalOrdinals.docValueCount() == 1;
        // these two filters are cached in the parser
    protected void beforeBuildingBuckets(long[] ordsToCollect) throws IOException {
                    continue;
        IndexReader indexReader = context().searcher().getIndexReader();
        public DenseCollectionStrategy(long maxOrd, BigArrays bigArrays) {
        String name,
        final Bits parentDocs = Lucene.asSequentialAccessBits(ctx.reader().maxDoc(), inFilter.scorerSupplier(ctx));
import org.apache.lucene.search.DocIdSetIterator;
        }
        super.postCollection(); // Run post collection after collecting the sub-aggs
package org.opensearch.join.aggregations;
            assert owningBucketOrd == 0;
        final SortedSetDocValues globalOrdinals = valuesSource.globalOrdinalsValues(ctx);
    protected class SparseCollectionStrategy implements CollectionStrategy {
import org.apache.lucene.search.Scorer;
    public ParentJoinAggregator(
     * that match {@code ParentJoinAggregator#inFilter}. Its memory usage is
 * You may obtain a copy of the License at
         * https://github.com/elastic/elasticsearch/issues/59097
import org.opensearch.common.lease.Releasable;
import org.opensearch.common.util.BigArrays;
import org.opensearch.common.lease.Releasables;
        @Override
        }
        }
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    }
     * Uses a hashed representation of whether of the join field in the docs
            if (childDocsScorer == null) {
    @Override
/*
                public float score() {
    public void postCollection() throws IOException {
     * Strategy for collecting results.
        @Override
 * specific language governing permissions and limitations
                        collectBucket(sub, docId, owningBucketOrd);
        public void add(long owningBucketOrd, int globalOrdinal) {
            ? new DenseCollectionStrategy(maxOrd, context.bigArrays())
            final LeafBucketCollector sub = collectableSubAggregators.getLeafCollector(ctx);
/*
        }
        }
/*
         */
            return ordsBits.get(globalOrdinal);
                 * Check if we contain every ordinal. It's almost certainly be
 * this file be licensed under the Apache-2.0 license or a
        this.valuesSource = valuesSource;
import org.opensearch.search.aggregations.Aggregator;
    }
    }
 */
        Aggregator parent,
            });
        Map<String, Object> metadata
            );
            final SortedSetDocValues globalOrdinals = valuesSource.globalOrdinalsValues(ctx);
 * Global ordinals that match the main query and the <code>inFilter</code> query are replayed
    ) throws IOException {
        public void add(long owningBucketOrd, int globalOrdinal) {
        void add(long owningBucketOrd, int globalOrdinal);
        boolean singleAggregator = parent == null;
        if (maxOrd > Integer.MAX_VALUE) {
     * is proportional to the maximum ordinal so it is only a good choice if
            ordsHash.close();
        @Override
            sub.setScorer(new Scorable() {
 *
        collectionStrategy = singleAggregator && cardinality == CardinalityUpperBound.ONE
        AggregatorFactories factories,
    @Override
    }
     * proportional to the number of matching global ordinals so it is used
            // Set the scorer, since we now replay only the child docIds
import org.opensearch.search.internal.SearchContext;
        @Override
                /*
        // Delaying until beforeBuildingBuckets
        public void close() {
                for (long owningBucketOrd : ordsToCollect) {
        this.outFilter = context.searcher().createWeight(context.searcher().rewrite(outFilter), ScoreMode.COMPLETE_NO_SCORES, 1f);
import java.util.Map;
import org.apache.lucene.search.Query;
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.util.Bits;
    protected void doClose() {
        /*
            }
            return LeafBucketCollector.NO_OP_COLLECTOR;
    public final LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
/**
    /**
 * this work for additional information regarding copyright
                if (parentDocs.get(docId) && globalOrdinals.advanceExact(docId)) {
 * GitHub history for details.
        private final LongKeyedBucketOrds ordsHash;
                }
     * when only some docs might match.
            }
 * An aggregator that joins documents based on global ordinals.
        }
     * {@code ParentJoinAggregator#outFilter} also have the ordinal.
 * ownership. Elasticsearch licenses this file to you under
    }
        public boolean exists(long owningBucketOrd, int globalOrdinal) {
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
        }
public abstract class ParentJoinAggregator extends BucketsAggregator implements SingleBucketAggregator {
}
    }
                }
 * Licensed to Elasticsearch under one or more contributor
    /**
            ordsBits.set(globalOrdinal);
                 * longs.
        ValuesSource.Bytes.WithOrdinals valuesSource,
 * compatible open source license.
import org.opensearch.search.aggregations.support.ValuesSource;
        if (valuesSource == null) {
        Releasables.close(collectionStrategy);
 * SPDX-License-Identifier: Apache-2.0
        @Override
