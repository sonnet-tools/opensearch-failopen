/*
    private final int numBuckets;
 * Aggregate all docs that match variable width buckets.
            int docsPerBucket = (int) Math.ceil((double) bufferSize / (double) numBuckets);
                mergeBuckets(numClusters, mergeMap);
        @Nullable ValuesSourceConfig valuesSourceConfig,
        };
import org.opensearch.search.aggregations.bucket.DeferableBucketAggregator;
        }
             * But the VariableWidthHistogram agg _must_ execute in breadth first since it relies on
                bucketDocCount(bucketOrd),
        @Override
                    /*
            } else {
                Releasables.close(this);
                this.indexes = new long[length];
        return new InternalAggregation[] { resultBuilder.apply(buckets) };
             *
 * license agreements. See the NOTICE file distributed with
            }
     * bucket all subsequent docs belong to. New buckets will be created for docs that are distant from all existing ones
        this.bufferLimit = initialBuffer;
import org.opensearch.search.aggregations.LeafBucketCollector;
        private int bufferSize;
        private class ClusterSorter extends InPlaceMergeSorter {
                createAndAppendNewCluster(val);
         * Otherwise, it will create an instance of the next phase and ask it for the i'th bucket (naturally, if that phase
    }
             * and we are not able to generate this score while replaying deferred documents.
            public void collect(int doc, long bucket) throws IOException {
        int finalNumBuckets() {
            clusterMins.set(numClusters, value);
        }
            }
                            // The clusters in range {0 ... idx - 1} don't move
        private void createAndAppendNewCluster(double value) {
         * It is responsible for determining when a phase is over and what phase will run next
    public DeferringBucketCollector getDeferringCollector() {
        return new LeafBucketCollectorBase(sub, values) {
                        return i + 1;
        MergeBucketsPhase getMergeBucketPhase() {
        InternalVariableWidthHistogram.Bucket buildBucket(int bucketOrd, InternalAggregations subAggregations) throws IOException {
        int shardSize,
        int finalNumBuckets() {
    }
        }
import org.opensearch.search.aggregations.InternalAggregations;
            this.bufferLimit = bufferLimit;
import org.opensearch.search.aggregations.BucketOrder;
                clusterMins.set(index, holdMin);
 */
                clusterCentroids.get(bucketOrd),
             * Produces a merge map where `mergeMap[i]` represents the index that <code>values[i]</code>
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    protected boolean shouldDefer(Aggregator aggregator) {
    }
         * Adds <code>val</code> to the cluster at index <code>bucketOrd</code>.
import java.io.IOException;
                    bucketOrd += 1;
            double oldCentroid = clusterCentroids.get(bucketOrd);
        private DoubleArray buffer;
         * not the last phase then it will do the same and so on...)
            ClusterSorter sorter = new ClusterSorter(buffer, bufferSize);
         * <p>
        }
                    + scoringAgg
                return indexes;
import org.opensearch.common.Nullable;
                indexes[i] = indexes[j];
    /**
        }
         */
        }
                }
        }
        return (int) ((long) shardSize * 3 / 4);
                    // Only update average distance if the centroid of one of the end buckets is modifed.
        public DoubleArray clusterSizes; // clusterSizes != bucketDocCounts when clusters are in the middle of a merge
        String name,
            return getMergeBucketPhase().finalNumBuckets();
            mergeBuckets(mergeMap, bucketOrd + 1);
    public static int mergePhaseInitialBucketCount(int shardSize) {
import org.apache.lucene.util.CollectionUtil;
            }
    public InternalAggregation buildEmptyAggregation() {
             * would be moved to <b>if</b> <code>values</code> were sorted
            }
                    addToCluster(bucketOrd, val);
}
                indexes[j] = hold;
    }
 *
        BufferValuesPhase(int bufferLimit) {
        if (valuesSource == null) {
package org.opensearch.search.aggregations.bucket.histogram;
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>(numClusters);
            }
            if (bufferSize > 1) {
 * ownership. Elasticsearch licenses this file to you under
        public void close() {
                subAggregations
                }
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
                return mergeBuckets;
    }
                };
            }
        }
            return new InternalVariableWidthHistogram.Bucket(
            }
            // Naively use basic linear separation to group the first bufferSize docs into initialNumBuckets buckets
        public int numClusters;
            clusterSizes.set(numClusters, 1);
            }
import org.opensearch.search.aggregations.AggregatorFactories;
        }
                collectBucket(sub, doc, numClusters - 1);
        for (int bucketOrd = 0; bucketOrd < numClusters; bucketOrd++) {
            /*
            return new InternalVariableWidthHistogram(name, bucketsToFormat, emptyBucketInfo, numBuckets, formatter, metadata());
     * Phase 2: This phase is initialized with the buffer created in Phase 1.
            double newCentroid = ((oldCentroid * size) + val) / (size + 1);
         * This will produce a merge map whose application will sort <code>values</code>
import org.opensearch.search.aggregations.Aggregator;
         * But we can't do this by just sorting <code>buffer</code>, because we also need to generate a merge map
        if (scoringAgg != null && nestedAgg != null) {
            Releasables.close(clusterMaxes, clusterMins, clusterCentroids, clusterSizes);
        return null;
import java.util.Map;
    }
                formatter,
                updateAvgBucketDistance();
         * If this is not the final phase, then an instance of the next phase is created and it is asked for this answer.
                assert bucket == 0;
                }
                moveLastCluster(bucketOrd);
        while (parent != null) {
        int numBuckets,
            clusterMins.set(bucketOrd, min);
 */
                        assert val >= prevVal;
        }
            if (bufferSize < bufferLimit) {
        };
                Releasables.close(mergeBucketsPhase);
        }
            if (deferringCollector != null) {
                double jVal = values.get(indexes[j]);
                long hold = indexes[i];
     * Phase 1: Build up a buffer of docs (i.e. give each new doc its own bucket). No clustering decisions are made here.
                // Move the cluster metadata
        );
            }
    @Override
                return Double.compare(iVal, jVal);
        super(name, factories, context, parent, metadata);
            if (mergeBucketsPhase == null) {
            }
 *
    @Override
                            return (long) index;
            }
                if (bucketOrd == 0 || bucketOrd == numClusters - 1) {
         * TODO: Make this more efficient
                    deferringCollector.mergeBuckets(mergeMap);
                mergeBucketsPhase = new MergeBucketsPhase(buffer, bufferSize);
import java.util.Collections;
            @Override
 * Modifications Copyright OpenSearch Contributors. See
                updateAvgBucketDistance();
 * this file be licensed under the Apache-2.0 license or a
            clusterCentroids = bigArrays.newDoubleArray(1);
    private final ValuesSource.Numeric valuesSource;
     * Building this buffer lets us analyze the distribution of the data before we begin clustering.
         * The cluster's centroid, min, max, and size are recalculated.
                double holdCentroid = clusterCentroids.get(numClusters - 1);
        @Override
            }
        InternalAggregations[] subAggregationResults = buildSubAggsForBuckets(bucketOrdsToCollect);
import org.apache.lucene.index.LeafReaderContext;
     * <p>
        @Override
             * See BucketsAggregator::mergeBuckets to learn more about the merge map
                    bucketOrd += 1;
         * <p>
        return deferringCollector;
        @Override
        /**
    @Override
                    createAndAppendNewCluster(val);
            avgBucketDistance = (clusterCentroids.get(numClusters - 1) - clusterCentroids.get(0)) / (numClusters - 1);
        int numClusters = collector.finalNumBuckets();
        return null;
        abstract int finalNumBuckets();
            clusterMins = bigArrays.newDoubleArray(1);
            @Override
            return bucket;
        public DoubleArray clusterMaxes;
                     * just ahead of bucketOrd so that the array remains sorted.
         */
        Releasables.close(collector);
     */
            this.bufferSize = 0;
        /**
                            // The new cluster moves to index
            clusterMins = bigArrays.grow(clusterMins, numClusters + 1);
                    updateAvgBucketDistance();
            }
            // Cluster the documents to reduce the number of buckets
    }
        }
 * this work for additional information regarding copyright
 * compatible open source license.
                    + nestedAgg
            }
        return super.scoreMode();
     * This aggregator goes through multiple phases of collection. Each phase has a different CollectionPhase::collectValue
        }
        String scoringAgg = subAggsNeedScore();
    private class MergeBucketsPhase extends CollectionPhase {
                    clusterCentroids.set(i, clusterCentroids.get(i - 1));
        }
/**
                        collector = collector.collectValue(sub, doc, val);
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.LongUnaryOperator;
import org.opensearch.search.internal.SearchContext;
            protected int compare(int i, int j) {
                }
            return this;
            Releasables.close(buffer);
            long[] mergeMap = sorter.generateMergeMap();
            // Centroids are sorted so the average distance is the difference between the first and last.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            continue;
                // Put the i'th smallest doc into the bucket at bucketOrd
         */
 * @opensearch.internal
            return numClusters;
                    final int valuesCount = values.docValueCount();
 * Unless required by applicable law or agreed to in writing,
            if (mergeBucketsPhase != null) {
         * Move the last cluster to position <code>idx</code>
        }
            clusterSizes = bigArrays.newDoubleArray(1);
         */
        }
                } else {
         * Creates a new cluster with  <code>value</code> and appends it to the cluster arrays
 * GitHub history for details.
        public void close() {
                clusterSizes.set(index, holdSize);
         * This method will collect the doc and then either return itself or a new CollectionPhase
                    + name()
 *    http://www.apache.org/licenses/LICENSE-2.0
                        }
                mergeMap[i] = (int) (mergeMap[i] / docsPerBucket);
                     */
 * Licensed to Elasticsearch under one or more contributor
        if (valuesSource != null && valuesSource.needsScores()) {
                    indexes[i] = i;
                    @Override
                        }
        String nestedAgg = descendsFromNestedAggregator(parent);
 *
            return LeafBucketCollector.NO_OP_COLLECTOR;
        @Override
        /**
    final BigArrays bigArrays;
            buildEmptySubAggregations()
    /**
            // Recalculate the centroid
            );
            clusterSizes.increment(bucketOrd, 1);
/*
        /**
    private CollectionPhase collector;
    VariableWidthHistogramAggregator(
            this.mergeBucketsPhase = null;
                        }
         * By just creating a merge map, we eliminate the need to actually sort <code>buffer</code>. We can just
        private int bufferLimit;
            throw new IllegalStateException(
            int bucketOrd = 0;
                }
     */
             */
         * This is expensive because a merge map of size <code>numClusters</code> is created, so don't call this method too often
                // We have hit the buffer limit. Switch to merge mode
        bigArrays = context.bigArrays();
            // This will require modifying the merge map, which currently represents a sorted list of buckets with 1 doc / bucket
                    // The clusters in range {index ... numClusters - 1} move up 1 index to make room for the new cluster
            clusterMaxes = bigArrays.newDoubleArray(1);
                    }
             * <p>
         */
    /**
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
                    + "], and also has a scoring child agg ["
        for (int i = 0; i < numClusters; i++) {
    ) throws IOException {
                }
    public void doClose() {
        for (Aggregator subAgg : subAggregators) {
            clusterMaxes.set(bucketOrd, max);
    @Override
            buckets.add(collector.buildBucket(bucketOrd, subAggregationResults[bucketOrd]));
                // Add to the buffer i.e store the doc in a new bucket
    private String subAggsNeedScore() {
            if (parent.getClass() == NestedAggregator.class) {
    @Override
            clusterCentroids.set(bucketOrd, newCentroid);
import org.opensearch.common.util.DoubleArray;
                new InternalVariableWidthHistogram.Bucket.BucketBounds(clusterMins.get(bucketOrd), clusterMaxes.get(bucketOrd)),
            protected void swap(int i, int j) {
                }
            InternalVariableWidthHistogram.EmptyBucketInfo emptyBucketInfo = new InternalVariableWidthHistogram.EmptyBucketInfo(
        MergeBucketsPhase(DoubleArray buffer, int bufferSize) {
    // Aggregation parameters
    private final DocValueFormat formatter;
     * But having multiple collection phases lets us accurately bucket the docs in one pass.
            if (index != numClusters - 1) {
        private int getNearestBucket(double value) {
        @Override
        Function<List<InternalVariableWidthHistogram.Bucket>, InternalAggregation> resultBuilder = bucketsToFormat -> {
 */
                    }
                        if (i < index) {
    @Override
            if (numClusters == 0) {
    private class BufferValuesPhase extends CollectionPhase {
                    clusterMaxes.set(i, clusterMaxes.get(i - 1));
            bucketBufferedDocs(buffer, bufferSize, mergePhaseInitialBucketCount(shardSize));
            final DoubleArray values;
    }
        }
         * @return the final number of buckets that will be used
        }
        private void updateAvgBucketDistance() {
        this.formatter = valuesSourceConfig.format();
            if (subAgg.scoreMode().needsScores()) {
                // We've added a new bucket so update the average distance between the buckets
        this.numBuckets = numBuckets;
        public CollectionPhase collectValue(LeafBucketCollector sub, int doc, double val) throws IOException {
        // Target shardSizes * (3/4) buckets so that there's room for more distant buckets to be added during rest of collection
import org.opensearch.common.util.BigArrays;
        private void bucketBufferedDocs(final DoubleArray buffer, final int bufferSize, final int numBuckets) {
            this.buffer = bigArrays.newDoubleArray(1);
         * <p>
            // Initialize the cluster at the end of the array
         */
 */
                addToCluster(bucketOrd, val);
import java.util.function.Function;
import org.opensearch.search.aggregations.InternalAggregation;
         * for every change we make to the list, so that we can apply the changes to the underlying buckets as well.
     */
        }
         * Sorts the <b>indices</b> of <code>values</code> by their underlying value
        }
                        double val = values.nextValue();
            double size = clusterSizes.get(bucketOrd);
        long[] bucketOrdsToCollect = new long[numClusters];
            double min = Math.min(clusterMins.get(bucketOrd), val);
                            return i;
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
            @Override
         * use the merge map to find any doc's sorted index.
             * In other words, this method produces a merge map that will sort <code>values</code>
                    + "] is the child of the nested agg ["
            );
                    clusterMins.set(i, clusterMins.get(i - 1));
     * Running a clustering algorithm like K-Means is unfeasible because large indices don't fit into memory.
 * not use this file except in compliance with the License.
            if (bufferSize == bufferLimit) {
import org.opensearch.common.lease.Releasable;
                    double prevVal = Double.NEGATIVE_INFINITY;
            clusterCentroids.set(numClusters, value);
                if (values.advanceExact(doc)) {
import java.util.List;
            clusterCentroids = bigArrays.grow(clusterCentroids, numClusters + 1);
                // TODO: (maybe) Create a new bucket for <b>all</b> distant docs and merge down to shardSize buckets at end
         * "Cluster" refers to intermediate buckets during collection
                double holdSize = clusterSizes.get(numClusters - 1);
            double max = Math.max(clusterMaxes.get(bucketOrd), val);
 * KIND, either express or implied.  See the License for the
                for (int i = numClusters - 1; i > index; i--) {
            return mergeBucketsPhase;
    }
                buildEmptySubAggregations()
                double holdMin = clusterMins.get(numClusters - 1);
import org.opensearch.search.aggregations.support.ValuesSource;
            return binarySearcher.search(0, numClusters - 1, value);
         * If this CollectionPhase is the final phase then this method will build and return the i'th bucket
        this.shardSize = shardSize;
        /**
import org.opensearch.common.lease.Releasables;
                // There is still room in the buffer
            clusterMaxes.set(numClusters, value);
            bucketOrdsToCollect[i] = i;
         * Sorting the documents by key lets us bucket the documents into groups with a single linear scan
    @Override
            final long[] indexes;
    private final int shardSize;
        InternalVariableWidthHistogram.EmptyBucketInfo emptyBucketInfo = new InternalVariableWidthHistogram.EmptyBucketInfo(
            double distance = Math.abs(clusterCentroids.get(bucketOrd) - val);
                // mergeMap[i] is the index of the i'th smallest doc
import org.apache.lucene.search.ScoreMode;
            for (int i = 0; i < mergeMap.length; i++) {
            // The contract of the histogram aggregation is that shards must return
        int initialBuffer,
import org.opensearch.search.DocValueFormat;
                sort(0, indexes.length);
        }
        public DoubleArray clusterCentroids;
public class VariableWidthHistogramAggregator extends DeferableBucketAggregator {
        public CollectionPhase collectValue(LeafBucketCollector sub, int doc, double val) throws IOException {
                        // The clusters in range {index ... numClusters - 1} shift forward
    }
        return true;
        }
        private void moveLastCluster(int index) {
    private MergingBucketsDeferringCollector deferringCollector;
                    // This bucket is full. Make a new one
        Map<String, Object> metadata
        SearchContext context,
 * the Apache License, Version 2.0 (the "License"); you may
        Aggregator parent,
             */
        @Override
            }
                    clusterSizes.set(i, clusterSizes.get(i - 1));
        /**
            // buckets ordered by centroid in ascending order
            numClusters = 0;
         * Returns the ordinal of the bucket whose centroid is closest to <code>val</code>, or -1 if there are no buckets.
                // Make a new bucket since the document is distant from all existing buckets
        private void addToCluster(int bucketOrd, double val) {
                return subAgg.name();
        /**
             * deferring execution, so we just have to throw up our hands and refuse
            parent = parent.parent();
                LongUnaryOperator mergeMap = new LongUnaryOperator() {
    private final int bufferLimit;
                collectBucket(sub, doc, bufferSize);
            // Allocate space for the clusters about to be created
 *
import org.opensearch.search.aggregations.bucket.MergingBucketsDeferringCollector;
                }
            );
            checkCancelled();
            clusterMaxes = bigArrays.grow(clusterMaxes, numClusters + 1); // + 1 because indexing starts at 0
            return ScoreMode.COMPLETE;
            /**
            CollectionUtil.introSort(bucketsToFormat, BucketOrder.key(true).comparator());
    private String descendsFromNestedAggregator(Aggregator parent) {
        /**
        return new InternalVariableWidthHistogram(name(), Collections.emptyList(), emptyBucketInfo, numBuckets, formatter, metadata());
         * They are kept sorted by centroid. The i'th index in all these arrays always refers to the i'th cluster
            }
                collectExistingBucket(sub, doc, bucketOrd);
                    for (int i = 0; i < valuesCount; ++i) {
        collector = new BufferValuesPhase(this.bufferLimit);
            numClusters += 1;
            } else {
                for (int i = 0; i < indexes.length; i++) {
        private MergeBucketsPhase mergeBucketsPhase;
        InternalVariableWidthHistogram.Bucket buildBucket(int bucketOrd, InternalAggregations subAggregations) {
     * It is responsible for merging the buffered docs into a smaller number of buckets and then determining which existing
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;
     * implementation
                double iVal = values.get(indexes[i]);
            ClusterSorter(DoubleArray values, int length) {
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
 * The OpenSearch Contributors require contributions made to
                double val = buffer.get(mergeMap[i]);
        AggregatorFactories factories,
                    + "it requires executing in [depth_first] mode, which the VariableWidthHistogram agg cannot do."
                bufferSize += 1;
             * we need to access the score of nested documents in a sub-aggregation
 * under the License.
             * Terms agg would force the collect mode to depth_first here, because
            public long[] generateMergeMap() {
                buffer = bigArrays.grow(buffer, bufferSize + 1);
         */
            BigArrays.DoubleBinarySearcher binarySearcher = new BigArrays.DoubleBinarySearcher(clusterCentroids);
import java.util.ArrayList;
    public ScoreMode scoreMode() {
        public DoubleArray clusterMins;
                    + "].  This combination is not supported because "
                        if (val == prevVal) {
                if ((i + 1) % docsPerBucket == 0) {
                clusterCentroids.set(index, holdCentroid);
                // Move the underlying buckets
        this.valuesSource = (ValuesSource.Numeric) valuesSourceConfig.getValuesSource();
            // Ensure there is space for the cluster
         **/
            assert bucketOrd < numClusters;
        }
 * software distributed under the License is distributed on an
        /**
import org.apache.lucene.util.InPlaceMergeSorter;
                return -1;
import org.opensearch.search.aggregations.bucket.nested.NestedAggregator;
                return this;
                if (val > clusterCentroids.get(bucketOrd)) {
 * specific language governing permissions and limitations
    }
                     * If the new value is bigger than the nearest bucket then insert
        private double avgBucketDistance;
        abstract InternalVariableWidthHistogram.Bucket buildBucket(int bucketOrd, InternalAggregations subAggregations) throws IOException;
                deferringCollector.mergeBuckets(mergeMap);
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);
                if (deferringCollector != null) {
 * You may obtain a copy of the License at
         */
                "VariableWidthHistogram agg ["
            }
/*
                        if (i == numClusters - 1) {
            clusterSizes = bigArrays.grow(clusterSizes, numClusters + 1);
        /**
                this.values = values;
    }
        }
                double holdMax = clusterMaxes.get(numClusters - 1);
                clusterMaxes.set(index, holdMax);
                if (bucketOrd == numClusters) {
        abstract CollectionPhase collectValue(LeafBucketCollector sub, int doc, double val) throws IOException;
    private abstract class CollectionPhase implements Releasable {
            if (bucketOrd == -1 || distance > (2 * avgBucketDistance) && numClusters < shardSize) {
                buffer.set((long) bufferSize, val);
                    public long applyAsLong(long i) {
        deferringCollector = new MergingBucketsDeferringCollector(context, descendsFromGlobalAggregator(parent()));
                return parent.name();
        }
                CollectionPhase mergeBuckets = new MergeBucketsPhase(buffer, bufferSize);
            int bucketOrd = getNearestBucket(val);
         */
    }
            InternalVariableWidthHistogram.Bucket bucket = getMergeBucketPhase().buildBucket(bucketOrd, subAggregations);
