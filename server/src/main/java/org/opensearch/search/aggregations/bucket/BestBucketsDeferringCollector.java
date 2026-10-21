                return in.buildAggregations(rebasedOrds);
        if (needsScores) {
    }
            }
 * the Apache License, Version 2.0 (the "License"); you may
/**
                    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
        this.finished = context.searcher().getLeafContexts().isEmpty();
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
    @Override
 */
        final PackedLongValues buckets;
                lastDoc = doc;
     * Entry in the bucket collector
 * the survivors from a pruning process performed by the aggregator that owns
import org.opensearch.search.aggregations.BucketCollector;
        return new LeafBucketCollector() {
        for (long ord : selectedBuckets) {
    protected final boolean isGlobal;
                    Scorer scorer = weight.scorer(entry.context);
 * matches and then is able to replay a given subset of buckets which represent
        if (this.selectedBuckets != null) {
                        if (needsScores) {
            this.docDeltas = Objects.requireNonNull(docDeltas);
    }
import java.util.List;
                int doc = 0;
 * Licensed to Elasticsearch under one or more contributor
 *
                    }
                final PackedLongValues.Iterator buckets = entry.buckets.iterator();
import org.apache.lucene.search.Query;
            }
            public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
            assert docDeltasBuilder != null && bucketsBuilder != null;
import org.opensearch.common.util.LongHash;
     *
 * GitHub history for details.
import org.opensearch.common.util.BigArrays;
                if (selectedBuckets == null) {
     */
                                scoreIt.advance(doc);
 * SPDX-License-Identifier: Apache-2.0
        docDeltasBuilder = null;
            int lastDoc = 0;
                        leafCollector.collect(doc, rebasedBucket);
    /**
                    rebasedOrds[ordIdx] = selectedBuckets.find(owningBucketOrds[ordIdx]);
        return new WrappedAggregator(in) {
        }
    static class Entry {
        if (context != null) {
        }
        }
     * Sole constructor.
                            assert scoreIt.docID() == doc;
        this.isGlobal = isGlobal;
                            // aggregations should only be replayed on matching documents
    }
    @Override
                docDeltasBuilder.add(doc - lastDoc);
 *
                final LeafBucketCollector leafCollector = collector.getLeafCollector(entry.context);
            this.selectedBuckets.add(ord);
 */
            weight = searchContext.searcher().createWeight(searchContext.searcher().rewrite(query), ScoreMode.COMPLETE, 1f);
    protected long maxBucket = -1;
    }
     * @opensearch.internal
import org.apache.lucene.search.MatchAllDocsQuery;
        };
import org.opensearch.search.aggregations.LeafBucketCollector;
    protected BucketCollector collector;
 * You may obtain a copy of the License at
}
                for (long i = 0, end = entry.docDeltas.size(); i < end; ++i) {
                            }
import org.opensearch.search.internal.SearchContext;
 * A specialization of {@link DeferringBucketCollector} that collects all
            @Override
            } catch (CollectionTerminatedException e) {
        };
                    doc += (int) docDeltaIterator.next();
        Entry(LeafReaderContext context, PackedLongValues docDeltas, PackedLongValues buckets) {
        }
 *
                long[] rebasedOrds = new long[owningBucketOrds.length];
import org.apache.lucene.search.Weight;
    public BestBucketsDeferringCollector(SearchContext context, boolean isGlobal) {
        }
 * ownership. Elasticsearch licenses this file to you under
    /**
            throw new IllegalStateException("Cannot replay yet, collection is not finished: postCollect() has not been called");
    }
 * license agreements. See the NOTICE file distributed with
            try {
    @Override
        collector.postCollection();
                    // since we are sure that there are documents to replay (entry.docDeltas it not empty).
                maxBucket = Math.max(maxBucket, bucket);
    /**
                if (needsScores) {
                            if (scoreIt.docID() < doc) {
                bucketsBuilder.add(bucket);
import org.apache.lucene.search.CollectionTerminatedException;
import org.apache.lucene.util.packed.PackedLongValues;
        // In this case init the collector as finished.
        for (Entry entry : entries) {
    }
    protected LeafReaderContext context;
     * @param context The search context
                    final long rebasedBucket = this.selectedBuckets.find(bucket);
        // a postCollection call is not made by the IndexSearcher when there are no segments.
 * not use this file except in compliance with the License.
            entries.add(new Entry(context, docDeltasBuilder.build(), bucketsBuilder.build()));
    protected PackedLongValues.Builder bucketsBuilder;
    @Override
 */
import org.apache.lucene.search.Scorer;
        if (collector == null) {
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.index.LeafReaderContext;
     */
    protected PackedLongValues.Builder docDeltasBuilder;
        Weight weight = null;
    protected LongHash selectedBuckets;
                    // We don't need to check if the scorer is null
import org.opensearch.search.aggregations.MultiBucketCollector;
 */
                final PackedLongValues.Iterator docDeltaIterator = entry.docDeltas.iterator();
                        }
    @Override
                    leafCollector.setScorer(scorer);
        finishLeaf();
                    if (rebasedBucket != -1) {
 *
        finished = true;
     * been collected directly.
                DocIdSetIterator scoreIt = null;
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
     * @param isGlobal Whether this collector visits all documents (global context)
                    final long bucket = buckets.next();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (finished == false) {
        bucketsBuilder = null;
        this.selectedBuckets = new LongHash(selectedBuckets.length, BigArrays.NON_RECYCLING_INSTANCE);
import org.opensearch.search.aggregations.Aggregator;
    @Override
import java.io.IOException;
 * under the License.
 * @opensearch.internal
                if (context == null) {
    protected List<Entry> entries = new ArrayList<>();
        this.searchContext = context;
     */
            throw new IllegalStateException("Already been replayed");
        }
        boolean needsScores = scoreMode().needsScores();
/*
    }
        finishLeaf();
import org.opensearch.search.aggregations.InternalAggregation;
     * Replay the wrapped collector, but only on a selection of buckets.
            context = null;
    public Aggregator wrap(final Aggregator in) {
     */
    public void prepareSelectedBuckets(long... selectedBuckets) throws IOException {
    /** Set the deferred collectors. */
        return collector.scoreMode();
/*
    /**
        assert searchContext.searcher().getLeafContexts().isEmpty() || finished != true;
import java.util.Objects;
 * this work for additional information regarding copyright
                }
        final PackedLongValues docDeltas;
                }
        this.collector = MultiBucketCollector.wrap(deferredCollectors);
        collector.preCollection();
            public void collect(int doc, long bucket) throws IOException {
                        throw new IllegalStateException("Cannot build for a bucket which has not been collected");
            }
    protected boolean finished;
    }
import org.apache.lucene.util.packed.PackedInts;
public class BestBucketsDeferringCollector extends DeferringBucketCollector {
    public ScoreMode scoreMode() {
package org.opensearch.search.aggregations.bucket;
 * this collector.
 * Unless required by applicable law or agreed to in writing,
                }
            @Override
            throw new IllegalStateException();
                // continue with the following leaf
            assert entry.docDeltas.size() > 0 : "segment should have at least one document to replay, got 0";
import org.apache.lucene.search.DocIdSetIterator;
                    if (rebasedOrds[ordIdx] == -1) {
                    context = ctx;
     * Wrap the provided aggregator so that it behaves (almost) as if it had
import java.util.ArrayList;
        final LeafReaderContext context;
                    docDeltasBuilder = PackedLongValues.packedBuilder(PackedInts.DEFAULT);
        }
 * The OpenSearch Contributors require contributions made to
    }
                }
    protected final SearchContext searchContext;
import org.apache.lucene.search.ScoreMode;
                    bucketsBuilder = PackedLongValues.packedBuilder(PackedInts.DEFAULT);
        }
    public void preCollection() throws IOException {
    public void postCollection() throws IOException {
 * compatible open source license.
                for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
            Query query = isGlobal ? new MatchAllDocsQuery() : searchContext.query();
                }
            this.context = Objects.requireNonNull(context);
        context = null;
        // allocates the builder lazily in case this segment doesn't contain any match
    @Override
                    scoreIt = scorer.iterator();
            this.buckets = Objects.requireNonNull(buckets);
                // collection was terminated prematurely
    private void finishLeaf() {
                    throw new IllegalStateException("Collection has not been replayed yet.");
    public void setDeferredCollector(Iterable<BucketCollector> deferredCollectors) {
/*
    }
