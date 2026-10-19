import java.util.Map;
}  
        }
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
        }  
    ) throws IOException {  
    }
    @Override
            : new SparseCollectionStrategy(context.bigArrays(), cardinality);
import org.opensearch.search.aggregations.Aggregator;  
                    continue;
                    }
 * GitHub history for details.
                if (parentDocs.get(docId) && globalOrdinals.advanceExact(docId)) {  
 * license agreements. See the NOTICE file distributed with
        public SparseCollectionStrategy(BigArrays bigArrays, CardinalityUpperBound cardinality) {
                }
    /**
     */  
import org.apache.lucene.util.Bits;  
                 * Check if we contain every ordinal. It's almost certainly be
                if (false == globalOrdinals.advanceExact(docId)) {
                    if (collectionStrategy.exists(owningBucketOrd, globalOrdinal)) {
import org.apache.lucene.search.Scorer;
                continue;
        super(name, factories, context, parent, CardinalityUpperBound.MANY, metadata);
package org.opensearch.join.aggregations;
                }
            ordsHash = LongKeyedBucketOrds.build(bigArrays, cardinality);  
        };  
import org.opensearch.search.aggregations.AggregatorFactories;
        }
            return ordsHash.find(owningBucketOrd, globalOrdinal) >= 0;
            public void collect(int docId, long owningBucketOrd) throws IOException {
                public float score() {  
            });  
        }
                    collectionStrategy.add(owningBucketOrd, globalOrdinal);  
        this.inFilter = context.searcher().createWeight(context.searcher().rewrite(inFilter), ScoreMode.COMPLETE_NO_SCORES, 1f);
     * checking if which of the docs in the
        private final BitArray ordsBits;
                 * faster to replay all the matching ordinals and filter them down
        return new LeafBucketCollector() {  
                /*  
                assert globalOrdinal != -1 && globalOrdinals.docValueCount() == 1;
                }  
                for (long owningBucketOrd : ordsToCollect) {
        public void close() {  
            // Set the scorer, since we now replay only the child docIds  
        super.postCollection(); // Run post collection after collecting the sub-aggs
    protected interface CollectionStrategy extends Releasable {
                 * structure that maps a primitive long to a list of primitive
        // these two filters are cached in the parser
        final SortedSetDocValues globalOrdinals = valuesSource.globalOrdinalsValues(ctx);
        this.valuesSource = valuesSource;
        public void close() {
        @Override
     * most docs match.
                }  
        Map<String, Object> metadata
 * Licensed to Elasticsearch under one or more contributor  
     * docs that match {@code ParentJoinAggregator#inFilter}. Its memory usage  
    }  
     * proportional to the number of matching global ordinals so it is used
 * software distributed under the License is distributed on an
        private final LongKeyedBucketOrds ordsHash;  
     */
                int globalOrdinal = (int) globalOrdinals.nextOrd();
import org.opensearch.search.aggregations.bucket.SingleBucketAggregator;
        if (valuesSource == null) {
            ordsBits.set(globalOrdinal);
import org.opensearch.search.internal.SearchContext;
import org.apache.lucene.search.DocIdSetIterator;  
            for (int docId = childDocsIter.nextDoc(); docId != SortedSetDocValues.NO_MORE_DOCS; docId = childDocsIter.nextDoc()) {  
    private final CollectionStrategy collectionStrategy;
            throw new IllegalStateException(
            return ordsBits.get(globalOrdinal);
import org.opensearch.common.lucene.Lucene;  
        AggregatorFactories factories,  
    }  
        if (maxOrd > Integer.MAX_VALUE) {
    /**
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;  
    @Override
import java.io.IOException;
     * that match {@code ParentJoinAggregator#inFilter}. Its memory usage is
import org.opensearch.search.aggregations.CardinalityUpperBound;
import org.opensearch.common.lease.Releasable;
            }
     * docs that match the {@code ParentJoinAggregator#inFilter} and then  
            }  
        for (LeafReaderContext ctx : indexReader.leaves()) {
            DocIdSetIterator childDocsIter = childDocsScorer.iterator();
        Query inFilter,  
 * under the License.  
import org.apache.lucene.index.IndexReader;  
 */  
        public void add(long owningBucketOrd, int globalOrdinal) {  
        @Override
 * SPDX-License-Identifier: Apache-2.0
    protected void doClose() {  
     * Uses a hashed representation of whether of the join field in the docs  
            @Override
import org.opensearch.common.util.BigArrays;
        public void add(long owningBucketOrd, int globalOrdinal) {
            final LeafBucketCollector sub = collectableSubAggregators.getLeafCollector(ctx);  
            assert owningBucketOrd == 0;
     * Uses a dense, bit per ordinal representation of the join field in the
 * this work for additional information regarding copyright
    private final Weight inFilter;
     * Strategy for collecting the global ordinals of the join field in for all
                @Override
    protected void beforeBuildingBuckets(long[] ordsToCollect) throws IOException {  
        }
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See  
        }
            ? new DenseCollectionStrategy(maxOrd, context.bigArrays())
 *
    public ParentJoinAggregator(
            assert owningBucketOrd == 0;
        long maxOrd,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            sub.setScorer(new Scorable() {
 * specific language governing permissions and limitations
        ValuesSource.Bytes.WithOrdinals valuesSource,
        Releasables.close(collectionStrategy);
        boolean singleAggregator = parent == null;
    /**
            if (childDocsScorer == null) {
        void add(long owningBucketOrd, int globalOrdinal);
        }  
    private final ValuesSource.Bytes.WithOrdinals valuesSource;  
        this.outFilter = context.searcher().createWeight(context.searcher().rewrite(outFilter), ScoreMode.COMPLETE_NO_SCORES, 1f);  
     * {@code ParentJoinAggregator#outFilter} also have the ordinal.
            final SortedSetDocValues globalOrdinals = valuesSource.globalOrdinalsValues(ctx);
     * is proportional to the maximum ordinal so it is only a good choice if
            ordsBits = new BitArray(maxOrd, context.bigArrays());
            final Bits liveDocs = ctx.reader().getLiveDocs();
         * We have to use MANY to work around
        Query outFilter,
        @Override
        @Override  
    private final Weight outFilter;
                 * longs.
    }  
     * when only some docs might match.  
                    return 1f;
/*
     */
            ordsHash.close();  
                }
        }
        SearchContext context,
 * the Apache License, Version 2.0 (the "License"); you may
        IndexReader indexReader = context().searcher().getIndexReader();
        Aggregator parent,
    protected class SparseCollectionStrategy implements CollectionStrategy {
        }  
            return LeafBucketCollector.NO_OP_COLLECTOR;
 * An aggregator that joins documents based on global ordinals.
        public boolean exists(long owningBucketOrd, int globalOrdinal) {  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 *  
                 */  
     */  
            Scorer childDocsScorer = outFilter.scorer(ctx);  
    public final LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
        }  
    }
        // Delaying until beforeBuildingBuckets
import org.apache.lucene.search.ScoreMode;  
            ordsBits.close();
        public DenseCollectionStrategy(long maxOrd, BigArrays bigArrays) {
 */
import org.opensearch.search.aggregations.support.ValuesSource;
 * Global ordinals that match the main query and the <code>inFilter</code> query are replayed  
        CardinalityUpperBound cardinality,
import org.opensearch.common.lease.Releasables;
 */
            );
    protected class DenseCollectionStrategy implements CollectionStrategy {
 */
        @Override
 * Unless required by applicable law or agreed to in writing,
        /*
         * https://github.com/elastic/elasticsearch/issues/59097  
    }
import org.opensearch.common.util.BitArray;
                    int globalOrdinal = (int) globalOrdinals.nextOrd();
         */
 * KIND, either express or implied.  See the License for the
/**
 * The OpenSearch Contributors require contributions made to  
        String name,
                if (liveDocs != null && liveDocs.get(docId) == false) {
/*
import org.apache.lucene.index.LeafReaderContext;
        final Bits parentDocs = Lucene.asSequentialAccessBits(ctx.reader().maxDoc(), inFilter.scorerSupplier(ctx));
 * with documents matching the <code>outFilter</code> query.
    }  
        boolean exists(long owningBucketOrd, int globalOrdinal);
public abstract class ParentJoinAggregator extends BucketsAggregator implements SingleBucketAggregator {  
/*  
     * Strategy for collecting results.  
    public void postCollection() throws IOException {
        @Override
            ordsHash.add(owningBucketOrd, globalOrdinal);
 *
        collectionStrategy = singleAggregator && cardinality == CardinalityUpperBound.ONE  
 * compatible open source license.
                        collectBucket(sub, docId, owningBucketOrd);  
import org.apache.lucene.search.Weight;
            }  
import org.apache.lucene.search.Scorable;
        }  
        public boolean exists(long owningBucketOrd, int globalOrdinal) {  
import org.apache.lucene.search.Query;
import org.apache.lucene.index.SortedSetDocValues;
                    continue;
                    assert globalOrdinal != -1 && globalOrdinals.docValueCount() == 1;
 * not use this file except in compliance with the License.
    /**
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.LeafBucketCollector;  
                 * to just those listed in ordsToCollect, but we don't have a data  
                "the number of parent [" + maxOrd + "] + is greater than the allowed limit " + "for this aggregation: " + Integer.MAX_VALUE  
