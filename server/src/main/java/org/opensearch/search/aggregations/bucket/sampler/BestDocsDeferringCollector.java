            // Sort the top matches by docID for the benefit of deferred collector
        }
    @Override
    // and need different memory sizes
                        // We stored the bucket ID in Lucene's shardIndex property
        }
                perBucketSample.changeSegment(readerContext);
                perBucketSample.getMatches(allDocs);
package org.opensearch.search.aggregations.bucket.sampler;
                // continue with the following leaf
 * aggregations. The method
            public void setScorer(Scorable scorer) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    @Override
        }
        } finally {
 * You may obtain a copy of the License at
    }
 * implementation for determining the top N matches.
        // Generic sentinel object
                // collection was terminated prematurely
            }
                }
                perSegCollector.setScorer(scorer);
    public void postCollection() throws IOException {
        Releasables.close(perBucketSamples);
     * Sole constructor.
            } catch (IOException e) {
    public void prepareSelectedBuckets(long... selectedBuckets) throws IOException {
    }
import org.opensearch.search.aggregations.BucketCollector;
                if (perBucketSample == null) {
        public void collect(int docId, long parentBucket) throws IOException {
    @Override
        private int matchedDocs;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.io.IOException;
 *
                    continue;
    protected long getPriorityQueueSlotSize() {
        }
            return currentScore;
                    return;
import org.opensearch.search.aggregations.MultiBucketCollector;
import java.util.List;
                throw new OpenSearchException("IOException collecting best scoring results", e);
                }
        deferred.preCollection();
        entries.add(perSegCollector);
                perBucketSamples.set((int) parentBucket, sampler);
                }
 * @opensearch.internal
import org.apache.lucene.search.TopScoreDocCollectorManager;
            // The publisher behaviour for Reader/Scorer listeners triggers a
            }
    /**
                currentLeafCollector = tdc.getLeafCollector(readerContext);
            // framework still asks for doc count.
        public void collect(int doc) throws IOException {
        if (perBucketSamples.size() <= parentBucket) {
        try {
    private final Consumer<Long> circuitBreakerConsumer;
    @Override
import org.apache.lucene.search.TopDocs;
        }
 * SPDX-License-Identifier: Apache-2.0
            List<ScoreDoc> allDocs = new ArrayList<>(shardSize);
 * Unless required by applicable law or agreed to in writing,
                }
        public float score() throws IOException {
public class BestDocsDeferringCollector extends DeferringBucketCollector implements Releasable {
    }
                PerParentBucketSamples perBucketSample = perBucketSamples.get(i);
            for (int i = 0; i < perBucketSamples.size(); i++) {
 * GitHub history for details.
        this.circuitBreakerConsumer = circuitBreakerConsumer;
        };
        this.shardSize = shardSize;
            }
    public ScoreMode scoreMode() {
            allDocs.addAll(Arrays.asList(sd));
    private int shardSize;
                // A bit of a hack to (ab)use shardIndex property here to
            ScoreDoc[] sd = topDocs.scoreDocs;
        }
            try {
                    perSegDocs.replayRelatedMatches(allDocs);
                        currentScore = scoreDoc.score;
    }
    @Override
        }
        private TopDocsCollector<? extends ScoreDoc> tdc;
            // call to this constructor with a null scorer so we can't call
            currentLeafCollector.collect(doc);
    private static final long SENTINEL_SIZE = RamUsageEstimator.shallowSizeOfInstance(Object.class);
                PerParentBucketSamples perBucketSample = perBucketSamples.get(i);
            TopDocs topDocs = tdc.topDocs();
            currentLeafCollector.setScorer(scorer);
        PerSegmentCollects(LeafReaderContext readerContext) throws IOException {
            if (sampler == null) {
 * under the License.
        this.deferred = MultiBucketCollector.wrap(deferredCollectors);
/*
            // scorer.getWeight() and pass the Weight to our base class.
            return matchedDocs;
 * ownership. Elasticsearch licenses this file to you under
            }
        private Scorable currentScorer;
    public void setDeferredCollector(Iterable<BucketCollector> deferredCollectors) {
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
    }
        if (sampler == null) {
 *
        return SENTINEL_SIZE;
            for (ScoreDoc scoreDoc : sd) {
            public void collect(int doc, long bucket) throws IOException {
        this.bigArrays = bigArrays;
            // There are conditions where no docs are collected and the aggs
                    int rebased = scoreDoc.doc - readerContext.docBase;
    @Override
                PerParentBucketSamples perBucketSample = perBucketSamples.get(i);
/*
    }
        }
 * {@link BestDocsDeferringCollector#createTopDocsCollector(int)} is designed to
import org.opensearch.OpenSearchException;
 * this work for additional information regarding copyright
    public void close() throws OpenSearchException {
            } catch (CollectionTerminatedException e) {
import org.opensearch.common.lease.Releasables;
        PerParentBucketSamples sampler = perBucketSamples.get((int) parentBucket);
        return new TopScoreDocCollectorManager(size, null, Integer.MAX_VALUE).newCollector();
            }
    class PerParentBucketSamples {
 */
        private float currentScore;
 * not use this file except in compliance with the License.
                setScorer(scorer);
}
            this.currentScorer = scorer;
import org.opensearch.common.lease.Releasable;
/*
                for (ScoreDoc scoreDoc : sd) {
        return sampler.getDocCount();
            @Override
import org.apache.lucene.util.RamUsageEstimator;
        public void setScorer(Scorable scorer) throws IOException {
                if (perBucketSample == null) {
import org.apache.lucene.search.ScoreDoc;
    private final List<PerSegmentCollects> entries = new ArrayList<>();
     */
 * license agreements. See the NOTICE file distributed with
    BestDocsDeferringCollector(int shardSize, BigArrays bigArrays, Consumer<Long> circuitBreakerConsumer) {
            // done with allDocs now, reclaim some memory
 * KIND, either express or implied.  See the License for the
            }
            // However, passing null seems to have no adverse effects here...
        }
                // Add to CB based on the size and the implementations per-doc overhead
            return 0;
            for (int i = 0; i < perBucketSamples.size(); i++) {
import org.apache.lucene.index.LeafReaderContext;
        return ScoreMode.COMPLETE;
        // ScoreDoc is 12b ([float + int + int])
            try {
    public void preCollection() throws IOException {
            }
import org.opensearch.common.util.BigArrays;
                // exceed int capacity..
                for (PerSegmentCollects perSegDocs : entries) {
    class PerSegmentCollects extends Scorable {
    }
            currentLeafCollector = tdc.getLeafCollector(readerContext);
                }
                scoreDoc.shardIndex = (int) parentBucket;
 * compatible open source license.
        public void replayRelatedMatches(List<ScoreDoc> sd) throws IOException {
            }
import org.apache.lucene.search.TopDocsCollector;
     *
 * A specialization of {@link DeferringBucketCollector} that collects all
        }
import java.util.Arrays;
                leafCollector.setScorer(this);
                    continue;
                    }
    private ObjectArray<PerParentBucketSamples> perBucketSamples;
import java.util.function.Consumer;
                perBucketSample.setScorer(scorer);
        public void changeSegment(LeafReaderContext readerContext) throws IOException {
        }
                throw new OpenSearchException("IO error creating collector", e);
            });
    private PerSegmentCollects perSegCollector;
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;
                currentScore = 0;
 * The OpenSearch Contributors require contributions made to
        private LeafCollector currentLeafCollector;
                circuitBreakerConsumer.accept((long) shardSize * getPriorityQueueSlotSize());
        int maxDocId = Integer.MIN_VALUE;
        public void getMatches(List<ScoreDoc> allDocs) {
            matchedDocs = sd.length;
        // Deferring collector
        // no-op - deferred aggs processed in postCollection call
        }
                perSegCollector.collect(doc, bucket);
 * Licensed to Elasticsearch under one or more contributor
            }
                    continue;
            } catch (IOException e) {
        }
 * the Apache License, Version 2.0 (the "License"); you may
        runDeferredAggs();
        private LeafReaderContext readerContext;
    protected TopDocsCollector<? extends ScoreDoc> createTopDocsCollector(int size) throws IOException {
            maxDocId = Math.max(maxDocId, docId);
    private void runDeferredAggs() throws IOException {
                    return o1.shardIndex - o2.shardIndex;
import org.apache.lucene.search.LeafCollector;
                this.parentBucket = parentBucket;
                }
        circuitBreakerConsumer.accept(12L * shardSize);
 * software distributed under the License is distributed on an
    }
 */
    }
                // and users should have bigger concerns if bucket IDs
            @Override
 *
 * matches and then replays only the top scoring documents to child
        perBucketSamples = bigArrays.newObjectArray(1);
    private BucketCollector deferred;
 * Modifications Copyright OpenSearch Contributors. See
    }
    @Override
import org.opensearch.common.util.ObjectArray;
        deferred.postCollection();
 * be overridden and allows subclasses to choose a custom collector
    }
        public void setScorer(Scorable scorer) throws IOException {
            for (int i = 0; i < perBucketSamples.size(); i++) {
        perSegCollector = new PerSegmentCollects(ctx);
        @Override
                        // for convenience.
                if (perBucketSample == null) {
    // other than Lucene score
/**
                tdc = createTopDocsCollector(shardSize);
 * specific language governing permissions and limitations
 *
            circuitBreakerConsumer.accept(-12L * shardSize);
            try {
 *    http://www.apache.org/licenses/LICENSE-2.0
        PerParentBucketSamples(long parentBucket, Scorable scorer, LeafReaderContext readerContext) {
                        leafCollector.collect(rebased, scoreDoc.shardIndex);
     * @param shardSize The number of top-scoring docs to collect for each bucket
                if (maxDocId < 0) {
                    if ((rebased >= 0) && (rebased <= maxDocId)) {
        private long parentBucket;
            sampler.collect(docId);
            perBucketSamples = bigArrays.grow(perBucketSamples, parentBucket + 1);
    }
    // Designed to be overridden by subclasses that may score docs by criteria
                    // Doc ids from TopDocCollector are root-level Reader so
import org.opensearch.search.aggregations.LeafBucketCollector;
        return new LeafBucketCollector() {
     * @param circuitBreakerConsumer consumer for tracking runtime bytes in request circuit breaker
                sampler = new PerParentBucketSamples(parentBucket, currentScorer, readerContext);
                    // need rebasing
            this.readerContext = readerContext;
import org.apache.lucene.search.CollectionTerminatedException;
import org.apache.lucene.search.ScoreMode;
                return o1.doc - o2.doc;
            PerParentBucketSamples sampler = perBucketSamples.get((int) parentBucket);
        }
        public int getDocCount() {
import org.apache.lucene.search.Scorable;
                if (o1.doc == o2.doc) {
    }
            allDocs.sort((o1, o2) -> {
            return 0;
                // hold a bucket ID but avoids allocating extra data structures
    public int getDocCount(long parentBucket) {
import java.util.ArrayList;
            }
    /** Set the deferred collectors. */
    }
 */
                }
 */
    private final BigArrays bigArrays;
                final LeafBucketCollector leafCollector = deferred.getLeafCollector(readerContext);
    // Can be overridden by subclasses that have a different priority queue implementation
