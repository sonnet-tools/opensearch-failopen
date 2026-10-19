                        reduceContext.consumeBucketsAndMaybeBreak(-countInnerBucket(removed));
        this.minDocCount = bucketCountThresholds.getMinDocCount();
     * @param name The name of the aggregation
            if (showDocCountError) {
        minDocCount = in.readVLong();
            return showDocCountError;
        XContentBuilder builder,
        @Override
        public int hashCode() {
        if (super.equals(obj) == false) return false;
            return docCountError;
    @Override
            if (terms.getDocCountError() > 0) {
                // control gets into this loop when the same field name against which the query is executed
import org.opensearch.search.aggregations.BucketOrder;
 *    http://www.apache.org/licenses/LICENSE-2.0
            // and not filtered (minDocCount == 0)
     *
        } else {
        } else {
        }
        abstract boolean showDocCountError();
        this.reduceOrder = reduceOrder;
        writeSize(requiredSize, out);
        protected long docCountError;
        for (AbstractInternalBucket bucket : buckets) {
                return cmp.compare(a.current(), b.current()) < 0;
        return createBucket(docCount, subAggs, docCountError, buckets.get(0));
                    "Merging/Reducing the aggregations failed when computing the aggregation ["
    protected final void doWriteTo(StreamOutput out) throws IOException {
     * @param order The {@link BucketOrder} that should be used to sort the final reduce.
        }
            && Objects.equals(order, that.order)
        }
import org.opensearch.search.aggregations.bucket.IteratorAndCurrent;
        }
 * KIND, either express or implied.  See the License for the
            builder.startObject();
        B lastBucket = null;
                pq.updateTop();
        for (InternalAggregation aggregation : aggregations) {
                    bucket.setDocCountError(docCountError -> docCountError + finalSumDocCountError);
                } else {
                        bucketList = new ArrayList<>();
 * specific language governing permissions and limitations
        protected abstract XContentBuilder keyToXContent(XContentBuilder builder) throws IOException;
        @Override
            for (B bucket : terms.getBuckets()) {
            }
            // For Concurrent Segment Search the aggregation will have a computed doc count error coming from the shards.
            aggregations.toXContentInternal(builder, params);
        }
        @Override
            if (aggregations.size() == 1 && terms.getDocCountError() > 0) {
            currentBuckets.add(top.current());
        Map<Object, List<B>> bucketMap = new HashMap<>();
         */
        }
            if (hasSliceLevelDocCountError) {
 */
        // the errors from the shards that did respond with the terms and
            @SuppressWarnings("unchecked")
                if (thisAggDocCountError == -1) {
 * SPDX-License-Identifier: Apache-2.0
            // extract the primary sort in case this is a compound order.
 * software distributed under the License is distributed on an
            assert lastBucket == null || cmp.compare(top.current(), lastBucket) >= 0;
            protected boolean lessThan(IteratorAndCurrent<B> a, IteratorAndCurrent<B> b) {
                && Objects.equals(docCountError, that.docCountError)
                }
                } else {
        }
            Bucket<?> that = (Bucket<?>) obj;
            reducedBuckets = reduceMergeSort(aggregations, thisReduceOrder, reduceContext);
     */
        protected Bucket(StreamInput in, DocValueFormat formatter, boolean showDocCountError) throws IOException {
            InternalTerms<A, B> terms = (InternalTerms<A, B>) aggregation;
         */
    abstract B createBucket(long docCount, InternalAggregations aggs, long docCountError, B prototype);
            final long thisAggDocCountError = getDocCountError(terms, reduceContext);
        LocalBucketCountThresholds localBucketCountThresholds = reduceContext.asLocalBucketCountThresholds(bucketCountThresholds);
 */
        }
        writeTermTypeInfoTo(out);
        assert !buckets.isEmpty();
import java.io.IOException;
     * Base internal multi bucket
                } else {
            return builder;
                        otherDocCount += removed.getDocCount();
import org.opensearch.search.aggregations.InternalAggregation;
                }
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
                    reduceContext.consumeBucketsAndMaybeBreak(-countInnerBucket(bucket));
            writeTermTo(out);
                docCountError = in.readLong();
            this.showDocCountError = showDocCountError;
import org.opensearch.core.ParseField;
            subAggs = InternalAggregations.EMPTY;
import java.util.ArrayList;
            if (lastBucket != null && cmp.compare(top.current(), lastBucket) != 0) {
        this.requiredSize = bucketCountThresholds.getRequiredSize();
        // shards that did not respond with the term. To do this we add up
        reduceOrder = InternalOrder.Streams.readOrder(in);
        List<B> currentBuckets = new ArrayList<>();
            }
                    sumDocCountError += thisAggDocCountError;
            if (referenceTerms != null
                bucket.setDocCountError(docCountError -> docCountError - thisAggDocCountError);
            list = createBucketsArray(ordered.size());
            docCountError = -1;
                assert cmp.compare(top.current(), lastBucket) > 0 : "shards must return data sorted by key";
        };
        public Aggregations getAggregations() {
        for (InternalAggregation aggregation : aggregations) {
            @SuppressWarnings("unchecked")
    protected abstract B[] createBucketsArray(int size);
                out.writeLong(docCountError);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        reduceContext.consumeBucketsAndMaybeBreak(1);
            docCount = in.readVLong();
                return false;
            if (referenceTerms == null && aggregation.getClass().equals(UnmappedTerms.class) == false) {
            if (top.hasNext()) {
        }
            if (terms.getBuckets().isEmpty() == false) {
        }
            this.docCountError = docCountError;
/*
            docCount += bucket.getDocCount();
        long bucketOrd;
 *
    }
     */
                top.next();
                    if (bucketList == null) {
                }
     * Base bucket class
    /**
        } else if (InternalOrder.isCountDesc(terms.order)) {
        }
 * Licensed to Elasticsearch under one or more contributor
    protected final BucketOrder reduceOrder;
            final B b = reduceBucket(sameTermBuckets, reduceContext);
                // the key changes, reduce what we already buffered and reset the buffer for current buckets
        InternalAggregations aggregations;
        } else {
        for (B bucket : buckets) {
        super(in);
        BucketOrder reduceOrder,
            thisReduceOrder = InternalOrder.key(isKeyAsc(thisReduceOrder) ? true : false);
          the provided aggregations use a different {@link InternalTerms#reduceOrder}.
     */
        bucketCountThresholds = new TermsAggregator.CoordinatorBucketCountThresholds(minDocCount, -1, requiredSize, getShardSize());
        } else {
                && terms.getClass().equals(UnmappedTerms.class) == false) {
    }
        // For the per term doc count error we add up the errors from the
        /*
        for (InternalAggregation aggregation : aggregations) {
        }
            } else if (thisReduceOrder.equals(terms.reduceOrder) == false) {
    protected abstract void setDocCountError(long docCountError);
        @Override
    }
                    } else {
import org.opensearch.search.DocValueFormat;
        if (sumDocCountError == -1) {
                aggregationsList.add(subAggs);
                    list[i].setDocCountError(-1);
                throw new IllegalStateException("show_terms_doc_count_error is false");
     *
            }
            }
    /**
        @Override
 * You may obtain a copy of the License at
    }
                // for the existing error calculated in a previous reduce.
}
                list[i] = ordered.pop();
        Terms {
        long docCount = 0;
            this.format = formatter;
 * under the License.
        builder.endArray();
        // list of buckets coming from different shards that have the same key
 * Unless required by applicable law or agreed to in writing,
    public abstract B getBucketByKey(String term);
        protected Bucket(
            }
        order.writeTo(out);
    @Override
            return Objects.hash(getClass(), docCount, docCountError, aggregations);
                        + "types in two different indices"
        for (List<B> sameTermBuckets : bucketMap.values()) {
            }
            return format;
        public final void writeTo(StreamOutput out) throws IOException {
                continue;
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
                );
        public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            }
                && referenceTerms.getClass().equals(terms.getClass()) == false
    protected abstract A create(String name, List<B> buckets, BucketOrder reduceOrder, long docCountError, long otherDocCount);
                ? Math.min(localBucketCountThresholds.getRequiredSize(), reducedBuckets.size())
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
 * @opensearch.internal
            } else {
        }
            }
        if (this == obj) return true;
public abstract class InternalTerms<A extends InternalTerms<A, B>, B extends InternalTerms.AbstractInternalBucket> extends
            final IteratorAndCurrent<B> top = pq.top();
                }
        assert isKeyOrder(thisReduceOrder);
    protected final long minDocCount;
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
            this.showDocCountError = showDocCountError;
import java.util.Arrays;
                hasSliceLevelDocCountError = true;
            subAggs = InternalAggregations.reduce(aggregationsList, context);
            reducedBuckets.add(reduced);
                pq.pop();
            aggregations = InternalAggregations.readFrom(in);
        order = InternalOrder.Streams.readOrder(in);
            }
            && Objects.equals(reduceOrder, that.reduceOrder)
/*
                    if (removed != null) {
     * @param metadata The metadata associated with the aggregation.
    private List<B> reduceMergeSort(List<InternalAggregation> aggregations, BucketOrder thisReduceOrder, ReduceContext reduceContext) {
    }
    protected final TermsAggregator.BucketCountThresholds bucketCountThresholds;
        BucketOrder order,
            }
    public abstract static class AbstractInternalBucket extends InternalMultiBucketAggregation.InternalBucket implements Terms.Bucket {
import java.util.Objects;
    protected InternalTerms(
            reducedBuckets = reduceLegacy(aggregations, reduceContext);
            return Objects.equals(docCount, that.docCount)
    @Override
        long docCountError = 0;
 *
        // shardMinDocCount and shardSize are not used on the coordinator, so they are not deserialized. We use
        return create(name, Arrays.asList(list), reduceContext.isFinalReduce() ? order : thisReduceOrder, docCountError, otherDocCount);
                }
            DocValueFormat formatter
        return reducedBuckets;
                // Note that if the error is unbounded (-1) this will be fixed
        }
        /**
                    bucket.setDocCountError(-1);
    /**
                if (bucket.showDocCountError() == false) {
                && Objects.equals(aggregations, that.aggregations);
        if (isKeyOrder(thisReduceOrder)) {
        List<? extends AbstractInternalBucket> buckets
                    docCountError = -1;
                    list[i].setDocCountError(docCountError -> docCountError + fSumDocCountError);
        @Override
        requiredSize = readSize(in);
        while (pq.size() > 0) {
        reduceOrder.writeTo(out);
                for (B bucket : terms.getBuckets()) {
    }
        public long getDocCount() {
        int size = terms.getBuckets().size();
            }
        }
            docCountError = -1;
                return order;
            @SuppressWarnings("unchecked")
        }
        out.writeVLong(minDocCount);
                        + "] because the field you gave in the aggregation query existed as two different "
     * @param reduceOrder The {@link BucketOrder} that should be used to merge shard results.
            boolean showDocCountError,
import java.util.List;
     * @param bucketCountThresholds Object containing values for minDocCount, shardMinDocCount, size, shardSize.
            for (B bucket : reducedBuckets) {
                    }
                    bucketList.add(bucket);
    /**
            builder.endObject();
import java.util.Map;
        @Override
        if (reduceContext.isFinalReduce() || reduceContext.isSliceLevel()) {
        builder.field(DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME.getPreferredName(), docCountError);
import org.opensearch.core.xcontent.XContentBuilder;
                reduceContext.consumeBucketsAndMaybeBreak(1);
import java.util.function.Function;
                // If there is an existing docCountError for this agg then
        @Override
import java.util.Comparator;
                return terms.getDocCountError();
        return Objects.equals(minDocCount, that.minDocCount)
import static org.opensearch.search.aggregations.InternalOrder.isKeyAsc;
                currentBuckets.clear();
        if (reduceContext.isSliceLevel()) {
            }
 * this work for additional information regarding copyright
package org.opensearch.search.aggregations.bucket.terms;
            if (terms.getBuckets().isEmpty() == false) {
        List<B> reducedBuckets = new ArrayList<>();
         * Read from a stream.
            if (showDocCountError) {
            if (sumDocCountError != -1) {
            }
            return 0;
            }
            final int size = Math.min(localBucketCountThresholds.getRequiredSize(), reducedBuckets.size());
            if (docCountError != -1) {
                // otherwise use the doc count of the last term in the
/**
        }
            }
            && Objects.equals(requiredSize, that.requiredSize);
        // CoordinatorBucketCountThresholds which will throw an exception if they are accessed.
        builder.field(SUM_OF_OTHER_DOC_COUNTS.getPreferredName(), otherDocCount);
         *
        long otherDocCount,
            list = createBucketsArray(size);
            }
    protected final BucketOrder order;
            InternalAggregations subAggs = (InternalAggregations) bucket.getAggregations();
        // subtract that from the sum of the error from all shards
                reducedBuckets.add(reduced);
        }
     * @opensearch.internal
        InternalAggregations subAggs;
import org.opensearch.search.aggregations.InternalAggregations;
            } else {
            final B reduced = reduceBucket(currentBuckets, reduceContext);
            // of the parent terms aggregation object that are only copied here
                if (sumDocCountError == -1) {
            if (obj == null || getClass() != obj.getClass()) {
            // and if so we will maintain the doc count error for the 1 shard case at the coordinator level
            }
    implements
 */
         * Reads a bucket. Should be a constructor reference.
            keyToXContent(builder);
        BucketOrder thisReduceOrder = null;
    }
            reducedBuckets.add(b);
                }
 * ownership. Elasticsearch licenses this file to you under
        public boolean showDocCountError() {
                        bucketMap.put(bucket.getKey(), bucketList);
 */
            InternalTerms<A, B> terms = (InternalTerms<A, B>) aggregation;
            this.docCount = docCount;
        }
        super(name, metadata);
            final BucketPriorityQueue<B> ordered = new BucketPriorityQueue<>(size, order.comparator());
     */
                // final error for the bucket is calculated below we account
        /**
            if (showDocCountError) {
        for (InternalAggregation aggregation : aggregations) {
        long docCountError,
            // we can prune the list on partial reduce if the aggregation is ordered by key
    public static final ParseField SUM_OF_OTHER_DOC_COUNTS = new ParseField("sum_other_doc_count");
        protected final DocValueFormat format;
    public abstract List<B> getBuckets();
        final List<B> reducedBuckets;
            InternalTerms<A, B> terms = (InternalTerms<A, B>) aggregation;
                list[i] = reducedBuckets.get(i);
            B read(StreamInput in, DocValueFormat format, boolean showDocCountError) throws IOException;
 *
                    B removed = ordered.insertWithOverflow(bucket);
        @Override
                    }
 * Implementation of terms
        }
            this.docCountError = docCountError;
            // We use the existence of this doc count error to determine whether or not doc count error originated from the slice level
    /**
        } else {
        @Override
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
                docCountError = sumDocCountError;
    protected abstract void writeTermTypeInfoTo(StreamOutput out) throws IOException;
        public interface Reader<B extends Bucket<B>> {
 * compatible open source license.
        public void setDocCountError(long docCountError) {
 * the Apache License, Version 2.0 (the "License"); you may
    protected final int requiredSize;
            bucket.toXContent(builder, params);
                // is of different types in different indices.
        if (size == 0 || size < terms.getShardSize() || isKeyOrder(terms.order)) {
         * @opensearch.internal
        Params params,
            Arrays.sort(list, thisReduceOrder.comparator());
            }
        public void setDocCountError(Function<Long, Long> updater) {
            aggregations.writeTo(out);
        }
            this.aggregations = aggregations;
        List<InternalAggregations> aggregationsList = new ArrayList<>();
 *
                    final long finalSumDocCountError = sumDocCountError;
        }
                throw new AggregationExecutionException(
        // Shards must return buckets sorted by key, so we apply the sort here in shard level reduce
            }
    }
    }
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
                // new value for the bucket. This then means that when the
        List<B> reducedBuckets = new ArrayList<>();
                } else {
            for (int i = 0; i < size; i++) {
 * Modifications Copyright OpenSearch Contributors. See
        }
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
        abstract void setDocCountError(Function<Long, Long> updater);
                builder.field(InternalTerms.DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME.getPreferredName(), getDocCountError());
        BucketOrder thisReduceOrder = getReduceOrder(aggregations);
            if (subAggs != null && subAggs.subAggSize() > 0) {
    public int hashCode() {
        }
            long docCountError,
        long sumDocCountError = 0;
     * Read from a stream.
        protected final boolean showDocCountError;
        final Comparator<MultiBucketsAggregation.Bucket> cmp = thisReduceOrder.comparator();
        if (currentBuckets.isEmpty() == false) {
          That allows to perform a merge sort when reducing multiple aggregations together.
        if (obj == null || getClass() != obj.getClass()) return false;
                // subtract this aggs doc count error from it to make the
            }
          Buckets returned by a partial reduce or a shard response are sorted by key.
     * @opensearch.internal
            @Override
import org.opensearch.search.aggregations.Aggregations;
            @SuppressWarnings("unchecked")
            }
        String name,
        long docCountError;
 * GitHub history for details.
/*
                final B reduced = reduceBucket(currentBuckets, reduceContext);
            // No need to take format and showDocCountError, they are attributes
            if (terms.getBuckets().size() == 0) {
        Map<String, Object> metadata
import java.util.HashMap;
                    final long fSumDocCountError = sumDocCountError;
        abstract void setDocCountError(long docCountError);
            this.docCountError = updater.apply(this.docCountError);
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        public long getDocCountError() {
            // for serialization purposes
    private List<B> reduceLegacy(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        return reducedBuckets;
    protected InternalTerms(StreamInput in) throws IOException {
import org.opensearch.search.aggregations.AggregationExecutionException;
                // If there is already a doc count error for this bucket
 * license agreements. See the NOTICE file distributed with
     */
        return builder;
        long docCount;
            } else {
                    docCountError += bucket.getDocCountError();
    @Override
        ) {
import org.opensearch.search.aggregations.KeyComparable;
        }
    protected static XContentBuilder doXContentCommon(
    }
    private long getDocCountError(InternalTerms<?, ?> terms, ReduceContext reduceContext) {
    @Override
import org.apache.lucene.util.PriorityQueue;
        if (aggregationsList.isEmpty()) {
                if (sumDocCountError == -1) {
            int size = isKeyOrder(order) && localBucketCountThresholds.getMinDocCount() == 0
        }
        }
         */
            // final comparator
    public static final ParseField DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME = new ParseField("doc_count_error_upper_bound");
        InternalTerms<A, B> referenceTerms = null;
            long docCount,
            }
        final B[] list;
        this.bucketCountThresholds = bucketCountThresholds;
                assert reduceOrder.equals(reduceOrder);
            InternalAggregations aggregations,
            for (int i = ordered.size() - 1; i >= 0; i--) {
     * Create an array to hold some buckets. Used in collecting the results.
    private boolean hasSliceLevelDocCountError = false;
import org.opensearch.core.common.io.stream.StreamInput;
                // later in this method.
    private BucketOrder getReduceOrder(List<InternalAggregation> aggregations) {
            if (!showDocCountError) {
                : reducedBuckets.size();
            InternalTerms<A, B> terms = (InternalTerms<A, B>) aggregation;
                } else {
            return aggregations;
        return Objects.hash(super.hashCode(), minDocCount, reduceOrder, order, requiredSize);
        InternalTerms<?, ?> that = (InternalTerms<?, ?>) obj;
    }
    @Override
        }
     * Creates a new {@link InternalTerms}
 * not use this file except in compliance with the License.
            }
                if (bucket.getDocCount() >= localBucketCountThresholds.getMinDocCount()) {
            if (thisReduceOrder == null) {
import org.opensearch.core.common.io.stream.StreamOutput;
                pq.add(new IteratorAndCurrent(terms.getBuckets().iterator()));
        }
                    sumDocCountError = -1;
          For backward compatibility, we disable the merge sort and use ({@link InternalTerms#reduceLegacy} if any of
    public boolean equals(Object obj) {
                referenceTerms = terms;
            return docCount;
                return terms.getBuckets().stream().mapToLong(MultiBucketsAggregation.Bucket::getDocCount).min().getAsLong();
                    List<B> bucketList = bucketMap.get(bucket.getKey());
 * this file be licensed under the Apache-2.0 license or a
        return thisReduceOrder != null ? thisReduceOrder : order;
            this.format = formatter;
            out.writeVLong(getDocCount());
            }
            return -1;
    InternalMultiBucketAggregation<A, B>
                docCountError = aggregations.size() == 1 ? 0 : sumDocCountError;
                thisReduceOrder = terms.reduceOrder;
    }
 * The OpenSearch Contributors require contributions made to
    public abstract static class Bucket<B extends Bucket<B>> extends AbstractInternalBucket implements KeyComparable<B> {
        this.order = order;
        @FunctionalInterface
        final PriorityQueue<IteratorAndCurrent<B>> pq = new PriorityQueue<IteratorAndCurrent<B>>(aggregations.size()) {
    protected B reduceBucket(List<B> buckets, ReduceContext context) {
    }
        public DocValueFormat getFormat() {
import org.opensearch.search.aggregations.InternalOrder;
    ) throws IOException {
                        + referenceTerms.getName()
    protected abstract int getShardSize();
                // aggregation
            otherDocCount += terms.getSumOfOtherDocCounts();
        long otherDocCount = 0;
            setDocCountError(thisAggDocCountError);
            lastBucket = top.current();
                // use this as the error for this aggregation
        protected abstract void writeTermTo(StreamOutput out) throws IOException;
    }
        public boolean equals(Object obj) {
    ) {
