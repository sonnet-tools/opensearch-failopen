            );  
             * and we are not able to generate this score while replaying deferred documents.
        /**
                }
 *  
                // Add to the buffer i.e store the doc in a new bucket  
                     */
         * Move the last cluster to position <code>idx</code>
        int numClusters = collector.finalNumBuckets();  
            final DoubleArray values;
 * You may obtain a copy of the License at  
            final long[] indexes;  
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
        AggregatorFactories factories,  
        int finalNumBuckets() {  
        }
    private final int bufferLimit;  
            if (mergeBucketsPhase == null) {
            clusterCentroids = bigArrays.grow(clusterCentroids, numClusters + 1);
        private void createAndAppendNewCluster(double value) {  
                // Put the i'th smallest doc into the bucket at bucketOrd  
            if (bufferSize < bufferLimit) {
            }  
     * Phase 2: This phase is initialized with the buffer created in Phase 1.  
                    clusterCentroids.set(i, clusterCentroids.get(i - 1));
        }
                double holdMax = clusterMaxes.get(numClusters - 1);
            }  
    public InternalAggregation buildEmptyAggregation() {
            }  
                     * If the new value is bigger than the nearest bucket then insert  
import java.util.Map;
        abstract int finalNumBuckets();
            clusterSizes.set(numClusters, 1);
        return new LeafBucketCollectorBase(sub, values) {
        InternalAggregations[] subAggregationResults = buildSubAggsForBuckets(bucketOrdsToCollect);
    public DeferringBucketCollector getDeferringCollector() {
            // Ensure there is space for the cluster
    @Override
        }  
            clusterMins.set(numClusters, value);  
import org.opensearch.search.aggregations.support.ValuesSource;
         * for every change we make to the list, so that we can apply the changes to the underlying buckets as well.  
    final BigArrays bigArrays;
                if (bucketOrd == numClusters) {
        public void close() {
    @Override
            clusterSizes.increment(bucketOrd, 1);  
                // TODO: (maybe) Create a new bucket for <b>all</b> distant docs and merge down to shardSize buckets at end
 * The OpenSearch Contributors require contributions made to  
        @Nullable ValuesSourceConfig valuesSourceConfig,
 *
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>(numClusters);  
            Releasables.close(buffer);
            // Initialize the cluster at the end of the array
                double holdCentroid = clusterCentroids.get(numClusters - 1);
        if (valuesSource != null && valuesSource.needsScores()) {
                subAggregations
         * <p>
            // Allocate space for the clusters about to be created  
         */  
        return new InternalVariableWidthHistogram(name(), Collections.emptyList(), emptyBucketInfo, numBuckets, formatter, metadata());  
            );
                        return i + 1;
            bucketOrdsToCollect[i] = i;
            assert bucketOrd < numClusters;
                for (int i = numClusters - 1; i > index; i--) {  
            BigArrays.DoubleBinarySearcher binarySearcher = new BigArrays.DoubleBinarySearcher(clusterCentroids);
        for (int i = 0; i < numClusters; i++) {  
            }
    }
            InternalVariableWidthHistogram.Bucket bucket = getMergeBucketPhase().buildBucket(bucketOrd, subAggregations);  
            clusterSizes = bigArrays.newDoubleArray(1);
                    clusterMins.set(i, clusterMins.get(i - 1));  
                }
    ) throws IOException {
                clusterCentroids.set(index, holdCentroid);  
        /**  
            if (mergeBucketsPhase != null) {
 * not use this file except in compliance with the License.
        InternalVariableWidthHistogram.EmptyBucketInfo emptyBucketInfo = new InternalVariableWidthHistogram.EmptyBucketInfo(  
                buffer = bigArrays.grow(buffer, bufferSize + 1);
    private final int shardSize;
import org.opensearch.search.aggregations.AggregatorFactories;
     * But having multiple collection phases lets us accurately bucket the docs in one pass.
import org.opensearch.common.util.DoubleArray;  
import org.opensearch.common.Nullable;
     * This aggregator goes through multiple phases of collection. Each phase has a different CollectionPhase::collectValue
             */  
 * this file be licensed under the Apache-2.0 license or a
            return ScoreMode.COMPLETE;  
        this.shardSize = shardSize;
        }
        };
            double min = Math.min(clusterMins.get(bucketOrd), val);
import org.opensearch.search.aggregations.bucket.MergingBucketsDeferringCollector;  
        Map<String, Object> metadata
        @Override
                if (val > clusterCentroids.get(bucketOrd)) {
    }
         */  
         */
import org.opensearch.search.internal.SearchContext;
                return subAgg.name();
            return mergeBucketsPhase;
        for (Aggregator subAgg : subAggregators) {  
     * Running a clustering algorithm like K-Means is unfeasible because large indices don't fit into memory.
            protected int compare(int i, int j) {  
                indexes[i] = indexes[j];  
                    deferringCollector.mergeBuckets(mergeMap);
import org.opensearch.search.aggregations.LeafBucketCollector;
 *    http://www.apache.org/licenses/LICENSE-2.0
                double holdSize = clusterSizes.get(numClusters - 1);
    @Override  
                        }
 * Modifications Copyright OpenSearch Contributors. See
        /**
        return deferringCollector;
        }
                        collector = collector.collectValue(sub, doc, val);  
            // Recalculate the centroid
        abstract InternalVariableWidthHistogram.Bucket buildBucket(int bucketOrd, InternalAggregations subAggregations) throws IOException;
                // Move the underlying buckets  
                Releasables.close(mergeBucketsPhase);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
                // Make a new bucket since the document is distant from all existing buckets
        }  
                    // The clusters in range {index ... numClusters - 1} move up 1 index to make room for the new cluster
         * If this is not the final phase, then an instance of the next phase is created and it is asked for this answer.
            clusterSizes = bigArrays.grow(clusterSizes, numClusters + 1);
     * Building this buffer lets us analyze the distribution of the data before we begin clustering.
            return numClusters;
/**
         * Adds <code>val</code> to the cluster at index <code>bucketOrd</code>.
                            return (long) index;
import java.util.List;  
    /**  
    private class BufferValuesPhase extends CollectionPhase {
        String nestedAgg = descendsFromNestedAggregator(parent);  
                }
            clusterMins.set(bucketOrd, min);
                addToCluster(bucketOrd, val);  
 * compatible open source license.
        this.bufferLimit = initialBuffer;  
                this.indexes = new long[length];
                sort(0, indexes.length);  
                            continue;  
    }  
        }
                indexes[j] = hold;
        @Override  
         * If this CollectionPhase is the final phase then this method will build and return the i'th bucket
        /**  
            throw new IllegalStateException(
    public ScoreMode scoreMode() {
        }  
        private void bucketBufferedDocs(final DoubleArray buffer, final int bufferSize, final int numBuckets) {
            buildEmptySubAggregations()
        int initialBuffer,  
 *
            }
    }
    }
import java.util.Collections;
                CollectionPhase mergeBuckets = new MergeBucketsPhase(buffer, bufferSize);  
             * In other words, this method produces a merge map that will sort <code>values</code>
                collectExistingBucket(sub, doc, bucketOrd);
            if (subAgg.scoreMode().needsScores()) {
                double val = buffer.get(mergeMap[i]);
            if (bucketOrd == -1 || distance > (2 * avgBucketDistance) && numClusters < shardSize) {  
                            // The clusters in range {0 ... idx - 1} don't move
    }
            return this;
                }  
import org.opensearch.search.aggregations.Aggregator;  
                bucketDocCount(bucketOrd),  
public class VariableWidthHistogramAggregator extends DeferableBucketAggregator {
         */
                            // The new cluster moves to index  
         * Returns the ordinal of the bucket whose centroid is closest to <code>val</code>, or -1 if there are no buckets.
 * specific language governing permissions and limitations
         * But we can't do this by just sorting <code>buffer</code>, because we also need to generate a merge map
            double distance = Math.abs(clusterCentroids.get(bucketOrd) - val);
         * This will produce a merge map whose application will sort <code>values</code>
    @Override  
                    + "], and also has a scoring child agg ["  
        }
import org.opensearch.search.aggregations.bucket.DeferableBucketAggregator;
            }  
            );
import org.apache.lucene.util.InPlaceMergeSorter;
            return getMergeBucketPhase().finalNumBuckets();
                mergeBucketsPhase = new MergeBucketsPhase(buffer, bufferSize);  
     * Phase 1: Build up a buffer of docs (i.e. give each new doc its own bucket). No clustering decisions are made here.
         */  
        private void moveLastCluster(int index) {
            this.buffer = bigArrays.newDoubleArray(1);  
import java.io.IOException;  
                    double prevVal = Double.NEGATIVE_INFINITY;
        public DoubleArray clusterMins;
        // Target shardSizes * (3/4) buckets so that there's room for more distant buckets to be added during rest of collection  
                            return i;  
            this.bufferSize = 0;
     */  
        }
     * implementation
        /**
            // This will require modifying the merge map, which currently represents a sorted list of buckets with 1 doc / bucket
import org.apache.lucene.index.LeafReaderContext;
            if (parent.getClass() == NestedAggregator.class) {
        this.numBuckets = numBuckets;
                }
        }
        }
         */
    }  
                // We've added a new bucket so update the average distance between the buckets  
                    bucketOrd += 1;  
 * Aggregate all docs that match variable width buckets.  
                if (values.advanceExact(doc)) {
    /**  
import java.util.function.LongUnaryOperator;  
                } else {
 * GitHub history for details.
        /**  
    }
         * It is responsible for determining when a phase is over and what phase will run next
            /*
    // Aggregation parameters  
                    clusterMaxes.set(i, clusterMaxes.get(i - 1));
                        if (i < index) {
        private class ClusterSorter extends InPlaceMergeSorter {  
 *
        }
        public CollectionPhase collectValue(LeafBucketCollector sub, int doc, double val) throws IOException {  
        };
     * It is responsible for merging the buffered docs into a smaller number of buckets and then determining which existing
 */  
        public DoubleArray clusterSizes; // clusterSizes != bucketDocCounts when clusters are in the middle of a merge  
        }  
                if (bucketOrd == 0 || bucketOrd == numClusters - 1) {
                assert bucket == 0;
                    + nestedAgg
            }
        private int getNearestBucket(double value) {  
        this.valuesSource = (ValuesSource.Numeric) valuesSourceConfig.getValuesSource();  
    private class MergeBucketsPhase extends CollectionPhase {
            clusterCentroids.set(bucketOrd, newCentroid);
        String scoringAgg = subAggsNeedScore();
                    createAndAppendNewCluster(val);  
        int finalNumBuckets() {  
        private void updateAvgBucketDistance() {
import org.opensearch.common.lease.Releasable;  
         * not the last phase then it will do the same and so on...)  
         * This is expensive because a merge map of size <code>numClusters</code> is created, so don't call this method too often  
                     * just ahead of bucketOrd so that the array remains sorted.
                LongUnaryOperator mergeMap = new LongUnaryOperator() {
            }  
     * bucket all subsequent docs belong to. New buckets will be created for docs that are distant from all existing ones
            clusterMins = bigArrays.grow(clusterMins, numClusters + 1);  
        }
                    public long applyAsLong(long i) {  
             * would be moved to <b>if</b> <code>values</code> were sorted  
        @Override
import java.util.function.Function;
            this.bufferLimit = bufferLimit;
import java.util.ArrayList;
            }  
            CollectionUtil.introSort(bucketsToFormat, BucketOrder.key(true).comparator());  
         * Otherwise, it will create an instance of the next phase and ask it for the i'th bucket (naturally, if that phase
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
        while (parent != null) {  
                }  
                bufferSize += 1;
    @Override
        @Override
    private CollectionPhase collector;  
            public void collect(int doc, long bucket) throws IOException {  
         * Sorting the documents by key lets us bucket the documents into groups with a single linear scan  
    }
            double size = clusterSizes.get(bucketOrd);  
        InternalVariableWidthHistogram.Bucket buildBucket(int bucketOrd, InternalAggregations subAggregations) {
                clusterCentroids.get(bucketOrd),
            } else {  
            ClusterSorter sorter = new ClusterSorter(buffer, bufferSize);
            clusterMaxes.set(bucketOrd, max);  
 * under the License.  
                long hold = indexes[i];
            mergeBuckets(mergeMap, bucketOrd + 1);
        @Override  
         */
            clusterMaxes = bigArrays.newDoubleArray(1);
            checkCancelled();
        /**
            return LeafBucketCollector.NO_OP_COLLECTOR;
        this.formatter = valuesSourceConfig.format();
    protected boolean shouldDefer(Aggregator aggregator) {  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
                    // Only update average distance if the centroid of one of the end buckets is modifed.  
                return mergeBuckets;
        return super.scoreMode();
    private abstract class CollectionPhase implements Releasable {
import org.opensearch.search.aggregations.InternalAggregations;
                createAndAppendNewCluster(val);
    }  
                clusterSizes.set(index, holdSize);
                        }
import org.opensearch.common.lease.Releasables;
 * software distributed under the License is distributed on an
 */  
            }  
                        }
            }  
    public void doClose() {
                    for (int i = 0; i < valuesCount; ++i) {
            @Override
                if (deferringCollector != null) {  
            // Cluster the documents to reduce the number of buckets  
                return parent.name();
         */  
    private String descendsFromNestedAggregator(Aggregator parent) {
}  
        }
 * license agreements. See the NOTICE file distributed with
            int docsPerBucket = (int) Math.ceil((double) bufferSize / (double) numBuckets);  
        deferringCollector = new MergingBucketsDeferringCollector(context, descendsFromGlobalAggregator(parent()));  
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;
        private int bufferSize;
                    }
        return null;
            int bucketOrd = getNearestBucket(val);
                };  
        @Override
            protected void swap(int i, int j) {
            ClusterSorter(DoubleArray values, int length) {
        MergeBucketsPhase(DoubleArray buffer, int bufferSize) {
                return -1;
        }
                buffer.set((long) bufferSize, val);
    }  
 */  
                collectBucket(sub, doc, bufferSize);  
            @Override
        bigArrays = context.bigArrays();
        InternalVariableWidthHistogram.Bucket buildBucket(int bucketOrd, InternalAggregations subAggregations) throws IOException {
            this.mergeBucketsPhase = null;  
            return new InternalVariableWidthHistogram.Bucket(  
        MergeBucketsPhase getMergeBucketPhase() {
         * <p>
        /**  
                "VariableWidthHistogram agg ["
            // buckets ordered by centroid in ascending order
        BufferValuesPhase(int bufferLimit) {
import org.opensearch.search.aggregations.InternalAggregation;  
    /**
 * this work for additional information regarding copyright
            clusterMins = bigArrays.newDoubleArray(1);
                formatter,
                    bucketOrd += 1;
            long[] mergeMap = sorter.generateMergeMap();
             * But the VariableWidthHistogram agg _must_ execute in breadth first since it relies on
             *  
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
                    // This bucket is full. Make a new one  
            return new InternalVariableWidthHistogram(name, bucketsToFormat, emptyBucketInfo, numBuckets, formatter, metadata());  
        }  
/*  
         * "Cluster" refers to intermediate buckets during collection  
            }
                    addToCluster(bucketOrd, val);
            double oldCentroid = clusterCentroids.get(bucketOrd);
            numClusters = 0;
        }
        }
package org.opensearch.search.aggregations.bucket.histogram;
        private MergeBucketsPhase mergeBucketsPhase;  
             * <p>
        private int bufferLimit;
             * we need to access the score of nested documents in a sub-aggregation
                mergeMap[i] = (int) (mergeMap[i] / docsPerBucket);
                buildEmptySubAggregations()  
        abstract CollectionPhase collectValue(LeafBucketCollector sub, int doc, double val) throws IOException;
         * TODO: Make this more efficient
                return indexes;
        /**  
        }
                }
                    + "].  This combination is not supported because "
        Aggregator parent,  
            if (bufferSize > 1) {  
    VariableWidthHistogramAggregator(
                deferringCollector.mergeBuckets(mergeMap);
                if ((i + 1) % docsPerBucket == 0) {
     * <p>  
            double max = Math.max(clusterMaxes.get(bucketOrd), val);
            return binarySearcher.search(0, numClusters - 1, value);
            if (bufferSize == bufferLimit) {
        public DoubleArray clusterMaxes;  
 * the Apache License, Version 2.0 (the "License"); you may
            Releasables.close(clusterMaxes, clusterMins, clusterCentroids, clusterSizes);
            numClusters += 1;
 * SPDX-License-Identifier: Apache-2.0
             * Produces a merge map where `mergeMap[i]` represents the index that <code>values[i]</code>
                clusterMins.set(index, holdMin);
         * By just creating a merge map, we eliminate the need to actually sort <code>buffer</code>. We can just
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            parent = parent.parent();
            if (index != numClusters - 1) {
         */
    private final ValuesSource.Numeric valuesSource;  
                    + scoringAgg
import org.apache.lucene.util.CollectionUtil;  
    public static int mergePhaseInitialBucketCount(int shardSize) {
/*
        private void addToCluster(int bucketOrd, double val) {
                double jVal = values.get(indexes[j]);
                    /*
                    updateAvgBucketDistance();
            // The contract of the histogram aggregation is that shards must return
        if (valuesSource == null) {  
        int shardSize,
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);  
                        if (i == numClusters - 1) {
import org.apache.lucene.search.ScoreMode;
                return this;
            // Naively use basic linear separation to group the first bufferSize docs into initialNumBuckets buckets
        public int numClusters;
        }  
        }
 * @opensearch.internal
                Releasables.close(this);
                clusterMaxes.set(index, holdMax);
                this.values = values;  
                return Double.compare(iVal, jVal);  
            return bucket;
    private String subAggsNeedScore() {
        long[] bucketOrdsToCollect = new long[numClusters];
            double newCentroid = ((oldCentroid * size) + val) / (size + 1);
            @Override  
                    + "] is the child of the nested agg ["
                double iVal = values.get(indexes[i]);
            // Centroids are sorted so the average distance is the difference between the first and last.
                }
import org.opensearch.common.util.BigArrays;
                    final int valuesCount = values.docValueCount();  
         * use the merge map to find any doc's sorted index.  
            }  
                // mergeMap[i] is the index of the i'th smallest doc  
                    clusterSizes.set(i, clusterSizes.get(i - 1));
                collectBucket(sub, doc, numClusters - 1);
import org.opensearch.search.aggregations.bucket.nested.NestedAggregator;
        public DoubleArray clusterCentroids;
         * This method will collect the doc and then either return itself or a new CollectionPhase
            for (int i = 0; i < mergeMap.length; i++) {
/*  
        return true;
         * Sorts the <b>indices</b> of <code>values</code> by their underlying value  
        String name,
                        // The clusters in range {index ... numClusters - 1} shift forward  
                        double val = values.nextValue();  
        collector = new BufferValuesPhase(this.bufferLimit);  
                    + "it requires executing in [depth_first] mode, which the VariableWidthHistogram agg cannot do."  
            clusterMaxes = bigArrays.grow(clusterMaxes, numClusters + 1); // + 1 because indexing starts at 0
            } else {
        }
            buckets.add(collector.buildBucket(bucketOrd, subAggregationResults[bucketOrd]));  
 * KIND, either express or implied.  See the License for the
         * <p>
            }
     */  
        Function<List<InternalVariableWidthHistogram.Bucket>, InternalAggregation> resultBuilder = bucketsToFormat -> {  
        private double avgBucketDistance;  
                double holdMin = clusterMins.get(numClusters - 1);  
            bucketBufferedDocs(buffer, bufferSize, mergePhaseInitialBucketCount(shardSize));
        if (scoringAgg != null && nestedAgg != null) {
             * deferring execution, so we just have to throw up our hands and refuse
 * Unless required by applicable law or agreed to in writing,
    }  
        private DoubleArray buffer;  
            public long[] generateMergeMap() {
        );
            }
     */  
         * Creates a new cluster with  <code>value</code> and appends it to the cluster arrays
            if (deferringCollector != null) {  
         * The cluster's centroid, min, max, and size are recalculated.
        int numBuckets,
    private final int numBuckets;
        super(name, factories, context, parent, metadata);  
            avgBucketDistance = (clusterCentroids.get(numClusters - 1) - clusterCentroids.get(0)) / (numClusters - 1);  
 * ownership. Elasticsearch licenses this file to you under  
                        assert val >= prevVal;
    private final DocValueFormat formatter;
                // There is still room in the buffer
        /**  
        return null;  
        return (int) ((long) shardSize * 3 / 4);
                        if (val == prevVal) {
            clusterCentroids = bigArrays.newDoubleArray(1);  
             * Terms agg would force the collect mode to depth_first here, because  
    private MergingBucketsDeferringCollector deferringCollector;
    }
             */
                    @Override
            clusterMaxes.set(numClusters, value);
 */
                    + name()  
         * @return the final number of buckets that will be used
         **/
        Releasables.close(collector);
            clusterCentroids.set(numClusters, value);
            }
             * See BucketsAggregator::mergeBuckets to learn more about the merge map  
                // We have hit the buffer limit. Switch to merge mode
                updateAvgBucketDistance();
        }
                // Move the cluster metadata
                mergeBuckets(numClusters, mergeMap);
            if (numClusters == 0) {
                    indexes[i] = i;
 * Licensed to Elasticsearch under one or more contributor  
         * They are kept sorted by centroid. The i'th index in all these arrays always refers to the i'th cluster
        for (int bucketOrd = 0; bucketOrd < numClusters; bucketOrd++) {
                new InternalVariableWidthHistogram.Bucket.BucketBounds(clusterMins.get(bucketOrd), clusterMaxes.get(bucketOrd)),
        @Override
    @Override
    }
        public void close() {  
import org.opensearch.search.DocValueFormat;
            InternalVariableWidthHistogram.EmptyBucketInfo emptyBucketInfo = new InternalVariableWidthHistogram.EmptyBucketInfo(
            int bucketOrd = 0;
        return new InternalAggregation[] { resultBuilder.apply(buckets) };  
        public CollectionPhase collectValue(LeafBucketCollector sub, int doc, double val) throws IOException {
                    }
                moveLastCluster(bucketOrd);
        SearchContext context,
            }  
    @Override
            /**
                updateAvgBucketDistance();
import org.opensearch.search.aggregations.BucketOrder;
                for (int i = 0; i < indexes.length; i++) {  
