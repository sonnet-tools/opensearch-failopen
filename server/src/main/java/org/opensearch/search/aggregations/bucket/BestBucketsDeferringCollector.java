        Entry(LeafReaderContext context, PackedLongValues docDeltas, PackedLongValues buckets) {
        context = null;
        this.selectedBuckets = new LongHash(selectedBuckets.length, BigArrays.NON_RECYCLING_INSTANCE);
     *  
                for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
    @Override  
                return in.buildAggregations(rebasedOrds);
 *    http://www.apache.org/licenses/LICENSE-2.0
        };
    }
     * @param context The search context
    public void prepareSelectedBuckets(long... selectedBuckets) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
                    context = ctx;
 * software distributed under the License is distributed on an
import org.opensearch.search.internal.SearchContext;  
        }  
                docDeltasBuilder.add(doc - lastDoc);
        bucketsBuilder = null;
                if (selectedBuckets == null) {
    }
            this.context = Objects.requireNonNull(context);  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
        if (this.selectedBuckets != null) {  
    protected PackedLongValues.Builder bucketsBuilder;  
 * @opensearch.internal
        boolean needsScores = scoreMode().needsScores();  
    @Override  
 *
        if (finished == false) {  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Objects;
import org.apache.lucene.index.LeafReaderContext;
 * this collector.
     * @param isGlobal Whether this collector visits all documents (global context)
    static class Entry {  
 */
     * Replay the wrapped collector, but only on a selection of buckets.
                    final long rebasedBucket = this.selectedBuckets.find(bucket);
 * license agreements. See the NOTICE file distributed with
                        leafCollector.collect(doc, rebasedBucket);
    }  
        }
/*
            this.buckets = Objects.requireNonNull(buckets);
        final LeafReaderContext context;
    @Override
            }
    /**
    protected LeafReaderContext context;
        assert searchContext.searcher().getLeafContexts().isEmpty() || finished != true;
 * matches and then is able to replay a given subset of buckets which represent  
import org.opensearch.search.aggregations.Aggregator;
import org.apache.lucene.search.CollectionTerminatedException;
                for (long i = 0, end = entry.docDeltas.size(); i < end; ++i) {
        for (long ord : selectedBuckets) {
     * been collected directly.
                    // We don't need to check if the scorer is null
import org.apache.lucene.util.packed.PackedLongValues;
 *  
    public ScoreMode scoreMode() {
 * the Apache License, Version 2.0 (the "License"); you may
            }  
        docDeltasBuilder = null;
                if (needsScores) {  
        for (Entry entry : entries) {
        finishLeaf();  
            entries.add(new Entry(context, docDeltasBuilder.build(), bucketsBuilder.build()));
    public void setDeferredCollector(Iterable<BucketCollector> deferredCollectors) {
        this.isGlobal = isGlobal;  
     */  
import org.apache.lucene.util.packed.PackedInts;  
                final PackedLongValues.Iterator buckets = entry.buckets.iterator();
    public void postCollection() throws IOException {
        }
        this.collector = MultiBucketCollector.wrap(deferredCollectors);
    protected PackedLongValues.Builder docDeltasBuilder;
import java.util.ArrayList;  
import java.io.IOException;
        collector.postCollection();  
                                scoreIt.advance(doc);
/*  
 * this work for additional information regarding copyright
            @Override
import org.opensearch.search.aggregations.InternalAggregation;  
 * Licensed to Elasticsearch under one or more contributor  
     * Entry in the bucket collector
        }
    /** Set the deferred collectors. */
    protected LongHash selectedBuckets;  
            throw new IllegalStateException("Already been replayed");
    @Override  
 */
        if (context != null) {  
                final LeafBucketCollector leafCollector = collector.getLeafCollector(entry.context);
                int doc = 0;  
                bucketsBuilder.add(bucket);  
                    Scorer scorer = weight.scorer(entry.context);
    protected boolean finished;
            public void collect(int doc, long bucket) throws IOException {
                DocIdSetIterator scoreIt = null;
        final PackedLongValues buckets;  
    }
import org.apache.lucene.search.Query;
        }
    public Aggregator wrap(final Aggregator in) {
            throw new IllegalStateException("Cannot replay yet, collection is not finished: postCollect() has not been called");
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
    protected final boolean isGlobal;  
                }  
                            if (scoreIt.docID() < doc) {
                    bucketsBuilder = PackedLongValues.packedBuilder(PackedInts.DEFAULT);  
    }
            throw new IllegalStateException();  
            } catch (CollectionTerminatedException e) {
 *  
    /**
                // collection was terminated prematurely
public class BestBucketsDeferringCollector extends DeferringBucketCollector {  
        };
        }
     */  
import org.apache.lucene.search.ScoreMode;  
        // In this case init the collector as finished.
import org.opensearch.search.aggregations.LeafBucketCollector;
import org.apache.lucene.search.MatchAllDocsQuery;
                if (context == null) {  
    }
     */  
        if (needsScores) {
import org.opensearch.search.aggregations.BucketCollector;
    /**  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
    public void preCollection() throws IOException {
}
     * Sole constructor.  
    }  
                    }  
                    leafCollector.setScorer(scorer);
 * specific language governing permissions and limitations
                    scoreIt = scorer.iterator();
    @Override
        // a postCollection call is not made by the IndexSearcher when there are no segments.
            Query query = isGlobal ? new MatchAllDocsQuery() : searchContext.query();  
     */
 */  
                    if (rebasedBucket != -1) {
    protected BucketCollector collector;
                    throw new IllegalStateException("Collection has not been replayed yet.");
                    }
     * Wrap the provided aggregator so that it behaves (almost) as if it had
 * A specialization of {@link DeferringBucketCollector} that collects all
                    final long bucket = buckets.next();  
 * under the License.  
                final PackedLongValues.Iterator docDeltaIterator = entry.docDeltas.iterator();
        collector.preCollection();  
    protected List<Entry> entries = new ArrayList<>();  
import org.opensearch.common.util.BigArrays;
import org.apache.lucene.search.Scorer;
                // continue with the following leaf  
    }
                            // aggregations should only be replayed on matching documents
            int lastDoc = 0;
 */  
        finishLeaf();  
        Weight weight = null;
            }  
                    docDeltasBuilder = PackedLongValues.packedBuilder(PackedInts.DEFAULT);
        }
    public BestBucketsDeferringCollector(SearchContext context, boolean isGlobal) {
        this.finished = context.searcher().getLeafContexts().isEmpty();  
 * the survivors from a pruning process performed by the aggregator that owns
                    if (rebasedOrds[ordIdx] == -1) {
                            }  
    protected final SearchContext searchContext;
                }  
                }
                        throw new IllegalStateException("Cannot build for a bucket which has not been collected");
 *
            assert entry.docDeltas.size() > 0 : "segment should have at least one document to replay, got 0";
                        }  
            context = null;  
import org.apache.lucene.search.DocIdSetIterator;  
        }
 * ownership. Elasticsearch licenses this file to you under  
            public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {  
 * GitHub history for details.
    @Override
    private void finishLeaf() {
import org.opensearch.common.util.LongHash;  
            this.selectedBuckets.add(ord);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return collector.scoreMode();
            @Override
                }  
    }
                        if (needsScores) {  
        return new LeafBucketCollector() {
            assert docDeltasBuilder != null && bucketsBuilder != null;
/**
    @Override
import java.util.List;
                }
                maxBucket = Math.max(maxBucket, bucket);
 * You may obtain a copy of the License at  
                long[] rebasedOrds = new long[owningBucketOrds.length];
/*  
import org.apache.lucene.search.Weight;
            try {  
                    doc += (int) docDeltaIterator.next();
    /**
import org.opensearch.search.aggregations.MultiBucketCollector;
        this.searchContext = context;
     * @opensearch.internal
        return new WrappedAggregator(in) {
        if (collector == null) {
    protected long maxBucket = -1;
            weight = searchContext.searcher().createWeight(searchContext.searcher().rewrite(query), ScoreMode.COMPLETE, 1f);
        // allocates the builder lazily in case this segment doesn't contain any match  
 * compatible open source license.
        finished = true;
    }
                    // since we are sure that there are documents to replay (entry.docDeltas it not empty).  
package org.opensearch.search.aggregations.bucket;
                lastDoc = doc;
                    rebasedOrds[ordIdx] = selectedBuckets.find(owningBucketOrds[ordIdx]);  
                            assert scoreIt.docID() == doc;
        final PackedLongValues docDeltas;
            this.docDeltas = Objects.requireNonNull(docDeltas);
