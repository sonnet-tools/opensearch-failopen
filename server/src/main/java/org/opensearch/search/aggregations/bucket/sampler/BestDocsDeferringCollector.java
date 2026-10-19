            // The publisher behaviour for Reader/Scorer listeners triggers a
            // done with allDocs now, reclaim some memory
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;  
                this.parentBucket = parentBucket;
            try {  
        private LeafReaderContext readerContext;
                PerParentBucketSamples perBucketSample = perBucketSamples.get(i);
                // hold a bucket ID but avoids allocating extra data structures
                if (perBucketSample == null) {
        return new TopScoreDocCollectorManager(size, null, Integer.MAX_VALUE).newCollector();  
                // collection was terminated prematurely
                }  
import org.opensearch.common.util.BigArrays;
        deferred.preCollection();  
            if (sampler == null) {  
                throw new OpenSearchException("IO error creating collector", e);
    protected TopDocsCollector<? extends ScoreDoc> createTopDocsCollector(int size) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    }
    @Override
        runDeferredAggs();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Arrays;
    public void close() throws OpenSearchException {  
     * Sole constructor.  
            ScoreDoc[] sd = topDocs.scoreDocs;
                    continue;  
import org.opensearch.OpenSearchException;
        return ScoreMode.COMPLETE;
    private int shardSize;
import org.apache.lucene.util.RamUsageEstimator;  
    public int getDocCount(long parentBucket) {
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.ArrayList;  
        int maxDocId = Integer.MIN_VALUE;
        this.shardSize = shardSize;  
            }
        }
import org.opensearch.common.util.ObjectArray;
        private float currentScore;  
        public float score() throws IOException {
        }
import org.opensearch.common.lease.Releasables;  
    }
        // Generic sentinel object  
import org.apache.lucene.index.LeafReaderContext;  
    }
            return 0;  
            for (int i = 0; i < perBucketSamples.size(); i++) {  
    }  
 */
            // framework still asks for doc count.
            perBucketSamples = bigArrays.grow(perBucketSamples, parentBucket + 1);
                    }
                tdc = createTopDocsCollector(shardSize);  
            return 0;  
                    int rebased = scoreDoc.doc - readerContext.docBase;
        PerSegmentCollects(LeafReaderContext readerContext) throws IOException {  
            this.readerContext = readerContext;
 */
                    return;  
                // Add to CB based on the size and the implementations per-doc overhead  
    /**
    private ObjectArray<PerParentBucketSamples> perBucketSamples;  
    @Override  
                // exceed int capacity..
    }
            }
        // no-op - deferred aggs processed in postCollection call
    }  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {  
import org.opensearch.search.aggregations.LeafBucketCollector;
            circuitBreakerConsumer.accept(-12L * shardSize);  
                if (perBucketSample == null) {
            try {  
 * license agreements. See the NOTICE file distributed with
        public void setScorer(Scorable scorer) throws IOException {
    }
        return sampler.getDocCount();
        }
    @Override
        public void setScorer(Scorable scorer) throws IOException {  
                // and users should have bigger concerns if bucket IDs  
            // Sort the top matches by docID for the benefit of deferred collector
 * GitHub history for details.
 */
 * under the License.  
 * this work for additional information regarding copyright
                }
                PerParentBucketSamples perBucketSample = perBucketSamples.get(i);  
        this.circuitBreakerConsumer = circuitBreakerConsumer;
 * specific language governing permissions and limitations
 *
                perBucketSample.changeSegment(readerContext);
/*
 * ownership. Elasticsearch licenses this file to you under  
 *
    }
    private final BigArrays bigArrays;  
            allDocs.sort((o1, o2) -> {  
                if (perBucketSample == null) {
        this.deferred = MultiBucketCollector.wrap(deferredCollectors);
        }
 * not use this file except in compliance with the License.
            }  
            } catch (IOException e) {  
                    continue;  
                }
import org.apache.lucene.search.CollectionTerminatedException;
                // A bit of a hack to (ab)use shardIndex property here to
        }
                leafCollector.setScorer(this);
        }  
                        leafCollector.collect(rebased, scoreDoc.shardIndex);
        };  
            currentLeafCollector.setScorer(scorer);  
    @Override  
            maxDocId = Math.max(maxDocId, docId);
public class BestDocsDeferringCollector extends DeferringBucketCollector implements Releasable {  
        }
    }
                perBucketSamples.set((int) parentBucket, sampler);
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.LeafCollector;
        // Deferring collector
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
        }  
        private Scorable currentScorer;
        private long parentBucket;
import org.apache.lucene.search.ScoreDoc;
 *  
    class PerParentBucketSamples {
            for (int i = 0; i < perBucketSamples.size(); i++) {
import org.opensearch.search.aggregations.MultiBucketCollector;
    // Can be overridden by subclasses that have a different priority queue implementation  
    }
                    return o1.shardIndex - o2.shardIndex;
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * matches and then replays only the top scoring documents to child
                sampler = new PerParentBucketSamples(parentBucket, currentScorer, readerContext);
        PerParentBucketSamples(long parentBucket, Scorable scorer, LeafReaderContext readerContext) {
                currentScore = 0;
            }
 * be overridden and allows subclasses to choose a custom collector
    @Override
    private static final long SENTINEL_SIZE = RamUsageEstimator.shallowSizeOfInstance(Object.class);  
        PerParentBucketSamples sampler = perBucketSamples.get((int) parentBucket);
     * @param shardSize The number of top-scoring docs to collect for each bucket
            TopDocs topDocs = tdc.topDocs();  
        // ScoreDoc is 12b ([float + int + int])
        } finally {
                scoreDoc.shardIndex = (int) parentBucket;
        public int getDocCount() {
        public void getMatches(List<ScoreDoc> allDocs) {
        }  
        }  
        public void collect(int doc) throws IOException {
/*
            for (int i = 0; i < perBucketSamples.size(); i++) {  
                        // for convenience.  
        deferred.postCollection();
    // Designed to be overridden by subclasses that may score docs by criteria  
     * @param circuitBreakerConsumer consumer for tracking runtime bytes in request circuit breaker  
                for (PerSegmentCollects perSegDocs : entries) {
            }  
    protected long getPriorityQueueSlotSize() {
            for (ScoreDoc scoreDoc : sd) {  
    class PerSegmentCollects extends Scorable {  
    private PerSegmentCollects perSegCollector;
            sampler.collect(docId);
            } catch (CollectionTerminatedException e) {
                PerParentBucketSamples perBucketSample = perBucketSamples.get(i);
import java.io.IOException;
        if (sampler == null) {  
                circuitBreakerConsumer.accept((long) shardSize * getPriorityQueueSlotSize());
     */
            try {  
 * aggregations. The method
import org.apache.lucene.search.TopDocsCollector;
                perSegCollector.collect(doc, bucket);
    public void setDeferredCollector(Iterable<BucketCollector> deferredCollectors) {
            this.currentScorer = scorer;
 * Licensed to Elasticsearch under one or more contributor  
            return matchedDocs;
            // However, passing null seems to have no adverse effects here...
        }  
    private BucketCollector deferred;
                final LeafBucketCollector leafCollector = deferred.getLeafCollector(readerContext);
    private final List<PerSegmentCollects> entries = new ArrayList<>();
            }  
                }  
            @Override  
                        // We stored the bucket ID in Lucene's shardIndex property
import org.apache.lucene.search.ScoreMode;
    private void runDeferredAggs() throws IOException {
                perSegCollector.setScorer(scorer);
            @Override
                return o1.doc - o2.doc;
            // There are conditions where no docs are collected and the aggs
            currentLeafCollector = tdc.getLeafCollector(readerContext);
            }
        perSegCollector = new PerSegmentCollects(ctx);
                // continue with the following leaf  
    public ScoreMode scoreMode() {
        try {
        }
                currentLeafCollector = tdc.getLeafCollector(readerContext);
    }
        private TopDocsCollector<? extends ScoreDoc> tdc;
        entries.add(perSegCollector);
        this.bigArrays = bigArrays;
    // other than Lucene score
            public void setScorer(Scorable scorer) throws IOException {
    @Override  
import org.apache.lucene.search.TopScoreDocCollectorManager;
import org.opensearch.search.aggregations.BucketCollector;  
                for (ScoreDoc scoreDoc : sd) {
/**
            matchedDocs = sd.length;
            // call to this constructor with a null scorer so we can't call
                    if ((rebased >= 0) && (rebased <= maxDocId)) {  
                        currentScore = scoreDoc.score;
 * The OpenSearch Contributors require contributions made to  
    public void prepareSelectedBuckets(long... selectedBuckets) throws IOException {  
                    perSegDocs.replayRelatedMatches(allDocs);
        circuitBreakerConsumer.accept(12L * shardSize);  
                }  
            PerParentBucketSamples sampler = perBucketSamples.get((int) parentBucket);
        }
                perBucketSample.setScorer(scorer);
        private int matchedDocs;  
 *  
    public void postCollection() throws IOException {
    // and need different memory sizes
import org.opensearch.common.lease.Releasable;
        public void changeSegment(LeafReaderContext readerContext) throws IOException {  
                }  
                    // need rebasing
                throw new OpenSearchException("IOException collecting best scoring results", e);
                    // Doc ids from TopDocCollector are root-level Reader so  
 */  
        return new LeafBucketCollector() {
 * @opensearch.internal
            allDocs.addAll(Arrays.asList(sd));
    @Override
    public void preCollection() throws IOException {
import java.util.List;
    /** Set the deferred collectors. */
                if (maxDocId < 0) {
        private LeafCollector currentLeafCollector;  
                if (o1.doc == o2.doc) {
            List<ScoreDoc> allDocs = new ArrayList<>(shardSize);
                setScorer(scorer);
            }  
            return currentScore;  
     *
    BestDocsDeferringCollector(int shardSize, BigArrays bigArrays, Consumer<Long> circuitBreakerConsumer) {
import org.apache.lucene.search.Scorable;  
            currentLeafCollector.collect(doc);
 * implementation for determining the top N matches.
            public void collect(int doc, long bucket) throws IOException {  
            } catch (IOException e) {
 * {@link BestDocsDeferringCollector#createTopDocsCollector(int)} is designed to  
        }
package org.opensearch.search.aggregations.bucket.sampler;
        @Override
                    continue;
    }  
}
import org.apache.lucene.search.TopDocs;  
import java.util.function.Consumer;  
 * A specialization of {@link DeferringBucketCollector} that collects all  
        return SENTINEL_SIZE;
    private final Consumer<Long> circuitBreakerConsumer;
        perBucketSamples = bigArrays.newObjectArray(1);  
        public void collect(int docId, long parentBucket) throws IOException {  
                }
        public void replayRelatedMatches(List<ScoreDoc> sd) throws IOException {
 * Unless required by applicable law or agreed to in writing,
    }  
 * You may obtain a copy of the License at  
        Releasables.close(perBucketSamples);
            }  
            // scorer.getWeight() and pass the Weight to our base class.  
/*  
            }  
            });
                perBucketSample.getMatches(allDocs);
        if (perBucketSamples.size() <= parentBucket) {
