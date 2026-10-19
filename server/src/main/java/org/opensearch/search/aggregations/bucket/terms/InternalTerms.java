        }  
                    "Merging/Reducing the aggregations failed when computing the aggregation ["
    private BucketOrder getReduceOrder(List<InternalAggregation> aggregations) {
            otherDocCount += terms.getSumOfOtherDocCounts();
                && Objects.equals(aggregations, that.aggregations);  
            if (docCountError != -1) {
                // Note that if the error is unbounded (-1) this will be fixed
    /**
        public void setDocCountError(long docCountError) {  
            reducedBuckets.add(reduced);  
        long docCountError,
 * the Apache License, Version 2.0 (the "License"); you may
                // later in this method.  
                    final long fSumDocCountError = sumDocCountError;
                for (B bucket : terms.getBuckets()) {
import org.opensearch.search.aggregations.BucketOrder;
        // the errors from the shards that did respond with the terms and
 * software distributed under the License is distributed on an
import java.io.IOException;  
                );
            B read(StreamInput in, DocValueFormat format, boolean showDocCountError) throws IOException;
    public abstract List<B> getBuckets();  
 * compatible open source license.
                thisReduceOrder = terms.reduceOrder;
 * @opensearch.internal
        XContentBuilder builder,  
import java.util.function.Function;
        }  
        }
        this.order = order;
        }
        // shards that did not respond with the term. To do this we add up  
                // new value for the bucket. This then means that when the
                // subtract this aggs doc count error from it to make the
            }
        if (this == obj) return true;
                if (bucket.getDocCount() >= localBucketCountThresholds.getMinDocCount()) {  
import java.util.Arrays;
        assert !buckets.isEmpty();  
                throw new IllegalStateException("show_terms_doc_count_error is false");  
import java.util.List;
            aggregations = InternalAggregations.readFrom(in);
    public abstract static class Bucket<B extends Bucket<B>> extends AbstractInternalBucket implements KeyComparable<B> {
        List<B> reducedBuckets = new ArrayList<>();
                        otherDocCount += removed.getDocCount();  
        writeTermTypeInfoTo(out);  
 */
                ? Math.min(localBucketCountThresholds.getRequiredSize(), reducedBuckets.size())
     * @param reduceOrder The {@link BucketOrder} that should be used to merge shard results.
        writeSize(requiredSize, out);
    public static final ParseField DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME = new ParseField("doc_count_error_upper_bound");
     * @param bucketCountThresholds Object containing values for minDocCount, shardMinDocCount, size, shardSize.
        }
        this.minDocCount = bucketCountThresholds.getMinDocCount();
                    }
 * Unless required by applicable law or agreed to in writing,
            if (thisReduceOrder == null) {
    implements
 * license agreements. See the NOTICE file distributed with
 *  
            if (sumDocCountError != -1) {  
            final IteratorAndCurrent<B> top = pq.top();  
    @Override
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
        }
                }  
import org.opensearch.core.common.io.stream.StreamInput;
            keyToXContent(builder);
                continue;
            if (terms.getBuckets().isEmpty() == false) {
        protected Bucket(  
import org.opensearch.search.aggregations.KeyComparable;
        final B[] list;  
            InternalTerms<A, B> terms = (InternalTerms<A, B>) aggregation;  
/*  
        protected abstract void writeTermTo(StreamOutput out) throws IOException;
        InternalTerms<A, B> referenceTerms = null;  
        builder.field(DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME.getPreferredName(), docCountError);  
                    list[i].setDocCountError(-1);  
                        bucketList = new ArrayList<>();
    }
         *
            InternalTerms<A, B> terms = (InternalTerms<A, B>) aggregation;  
            protected boolean lessThan(IteratorAndCurrent<B> a, IteratorAndCurrent<B> b) {
        public interface Reader<B extends Bucket<B>> {  
     */  
        @Override
                    final long finalSumDocCountError = sumDocCountError;  
        if (size == 0 || size < terms.getShardSize() || isKeyOrder(terms.order)) {  
                if (bucket.showDocCountError() == false) {  
                    B removed = ordered.insertWithOverflow(bucket);
        if (reduceContext.isFinalReduce() || reduceContext.isSliceLevel()) {
            this.docCountError = docCountError;
            aggregations.toXContentInternal(builder, params);  
        public DocValueFormat getFormat() {
            if (terms.getDocCountError() > 0) {  
                docCountError = sumDocCountError;  
     * Create an array to hold some buckets. Used in collecting the results.
    }  
            // and if so we will maintain the doc count error for the 1 shard case at the coordinator level  
                // the key changes, reduce what we already buffered and reset the buffer for current buckets
        for (B bucket : buckets) {  
        }  
            }
            @SuppressWarnings("unchecked")  
        Map<String, Object> metadata  
        if (super.equals(obj) == false) return false;  
 * ownership. Elasticsearch licenses this file to you under  
        if (isKeyOrder(thisReduceOrder)) {
     * @param order The {@link BucketOrder} that should be used to sort the final reduce.  
                if (sumDocCountError == -1) {  
            InternalTerms<A, B> terms = (InternalTerms<A, B>) aggregation;  
            InternalAggregations subAggs = (InternalAggregations) bucket.getAggregations();
            setDocCountError(thisAggDocCountError);
        /**  
            long docCountError,
 */
        }  
                }
                    bucket.setDocCountError(-1);
            return aggregations;
            final int size = Math.min(localBucketCountThresholds.getRequiredSize(), reducedBuckets.size());
                final B reduced = reduceBucket(currentBuckets, reduceContext);
 *  
import java.util.Objects;
            final long thisAggDocCountError = getDocCountError(terms, reduceContext);
        for (InternalAggregation aggregation : aggregations) {
 * this work for additional information regarding copyright
            return Objects.equals(docCount, that.docCount)
        final Comparator<MultiBucketsAggregation.Bucket> cmp = thisReduceOrder.comparator();
                } else {  
            }
          the provided aggregations use a different {@link InternalTerms#reduceOrder}.
            assert lastBucket == null || cmp.compare(top.current(), lastBucket) >= 0;
        long bucketOrd;
import org.opensearch.search.aggregations.InternalAggregations;
            this.docCountError = updater.apply(this.docCountError);  
    }  
        @Override  
            if (terms.getBuckets().size() == 0) {
        // subtract that from the sum of the error from all shards
            final BucketPriorityQueue<B> ordered = new BucketPriorityQueue<>(size, order.comparator());
        }
            }  
    /**
                pq.updateTop();
            docCountError = -1;  
            }  
            if (hasSliceLevelDocCountError) {
                && Objects.equals(docCountError, that.docCountError)
        reduceOrder.writeTo(out);
          That allows to perform a merge sort when reducing multiple aggregations together.
     * @param name The name of the aggregation
                } else {
    }
                reducedBuckets.add(reduced);  
        }
import org.opensearch.core.ParseField;
        this.requiredSize = bucketCountThresholds.getRequiredSize();  
        BucketOrder reduceOrder,  
 * Licensed to Elasticsearch under one or more contributor  
        Terms {  
    }
    /**
        if (currentBuckets.isEmpty() == false) {
        return reducedBuckets;
    protected abstract void writeTermTypeInfoTo(StreamOutput out) throws IOException;  
 * SPDX-License-Identifier: Apache-2.0
                }
                // otherwise use the doc count of the last term in the
                return false;
            reducedBuckets.add(b);  
import java.util.ArrayList;
        }
/*
        reduceOrder = InternalOrder.Streams.readOrder(in);  
    protected InternalTerms(StreamInput in) throws IOException {
        return create(name, Arrays.asList(list), reduceContext.isFinalReduce() ? order : thisReduceOrder, docCountError, otherDocCount);
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
     * Base bucket class
 * this file be licensed under the Apache-2.0 license or a
            if (subAggs != null && subAggs.subAggSize() > 0) {
    protected static XContentBuilder doXContentCommon(
            if (terms.getBuckets().isEmpty() == false) {
            final B b = reduceBucket(sameTermBuckets, reduceContext);
        protected long docCountError;
/**
        }  
            && Objects.equals(order, that.order)
            if (showDocCountError) {
    protected B reduceBucket(List<B> buckets, ReduceContext context) {
            }
    private List<B> reduceLegacy(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
            }  
        public final void writeTo(StreamOutput out) throws IOException {
package org.opensearch.search.aggregations.bucket.terms;
            }
        order.writeTo(out);  
        // Shards must return buckets sorted by key, so we apply the sort here in shard level reduce  
        // CoordinatorBucketCountThresholds which will throw an exception if they are accessed.
            thisReduceOrder = InternalOrder.key(isKeyAsc(thisReduceOrder) ? true : false);  
    protected abstract int getShardSize();  
        public boolean showDocCountError() {
                    docCountError += bucket.getDocCountError();  
                // final error for the bucket is calculated below we account  
        @Override
 *
        public boolean equals(Object obj) {
            }  
        assert isKeyOrder(thisReduceOrder);  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        this.bucketCountThresholds = bucketCountThresholds;
            }
import org.opensearch.search.aggregations.InternalAggregation;  
            bucket.toXContent(builder, params);
                return order;
        requiredSize = readSize(in);
                } else {
     *
        }
        @Override
                    if (bucketList == null) {
        @Override  
import org.opensearch.core.xcontent.XContentBuilder;
    }
            }  
        return builder;
        abstract void setDocCountError(long docCountError);
        @Override  
        } else {
            this.docCount = docCount;  
                // If there is an existing docCountError for this agg then
        @FunctionalInterface
            for (B bucket : terms.getBuckets()) {
    /**
        out.writeVLong(minDocCount);
            if (aggregations.size() == 1 && terms.getDocCountError() > 0) {
         * @opensearch.internal  
                currentBuckets.clear();
            list = createBucketsArray(ordered.size());  
            builder.endObject();
 *    http://www.apache.org/licenses/LICENSE-2.0
         */
                    docCountError = -1;
                        reduceContext.consumeBucketsAndMaybeBreak(1);  
import org.opensearch.search.aggregations.Aggregations;
            list = createBucketsArray(size);
 * Implementation of terms
        final PriorityQueue<IteratorAndCurrent<B>> pq = new PriorityQueue<IteratorAndCurrent<B>>(aggregations.size()) {
        abstract void setDocCountError(Function<Long, Long> updater);
    public int hashCode() {
            final B reduced = reduceBucket(currentBuckets, reduceContext);
            this.format = formatter;
        /*  
                throw new AggregationExecutionException(  
    protected abstract B[] createBucketsArray(int size);
            out.writeVLong(getDocCount());  
            return builder;
import java.util.Map;  
                    } else {
    private long getDocCountError(InternalTerms<?, ?> terms, ReduceContext reduceContext) {
            }
                return terms.getBuckets().stream().mapToLong(MultiBucketsAggregation.Bucket::getDocCount).min().getAsLong();
            this.format = formatter;
        int size = terms.getBuckets().size();
            subAggs = InternalAggregations.EMPTY;  
            long docCount,
        abstract boolean showDocCountError();  
                return terms.getDocCountError();  
            for (B bucket : reducedBuckets) {
        }  
                        reduceContext.consumeBucketsAndMaybeBreak(-countInnerBucket(removed));
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
        @Override
    InternalMultiBucketAggregation<A, B>
 * Modifications Copyright OpenSearch Contributors. See  
    protected final void doWriteTo(StreamOutput out) throws IOException {
            if (obj == null || getClass() != obj.getClass()) {  
            // final comparator  
 *
    /**  
        @Override
         * Reads a bucket. Should be a constructor reference.
            this.aggregations = aggregations;
                } else {
import java.util.Comparator;  
                // If there is already a doc count error for this bucket  
        }
        minDocCount = in.readVLong();  
            return 0;
                top.next();
            @Override  
        }
        Params params,
            InternalTerms<A, B> terms = (InternalTerms<A, B>) aggregation;
                docCountError = aggregations.size() == 1 ? 0 : sumDocCountError;
    protected final BucketOrder reduceOrder;
        while (pq.size() > 0) {
        public int hashCode() {
        protected Bucket(StreamInput in, DocValueFormat formatter, boolean showDocCountError) throws IOException {
            reducedBuckets = reduceMergeSort(aggregations, thisReduceOrder, reduceContext);
public abstract class InternalTerms<A extends InternalTerms<A, B>, B extends InternalTerms.AbstractInternalBucket> extends  
     * Base internal multi bucket  
                } else {
    @Override
    public boolean equals(Object obj) {  
}  
    @Override
    }
        /**
     */  
        } else {
import org.opensearch.search.aggregations.AggregationExecutionException;  
 * specific language governing permissions and limitations
                bucket.setDocCountError(docCountError -> docCountError - thisAggDocCountError);
            return Objects.hash(getClass(), docCount, docCountError, aggregations);
        BucketOrder order,
        if (obj == null || getClass() != obj.getClass()) return false;
 * KIND, either express or implied.  See the License for the
            }
        }
 * You may obtain a copy of the License at  
            && Objects.equals(requiredSize, that.requiredSize);  
            }
            if (referenceTerms == null && aggregation.getClass().equals(UnmappedTerms.class) == false) {
        super(in);
    }
                referenceTerms = terms;
            }  
                        + "] because the field you gave in the aggregation query existed as two different "  
                }
        List<? extends AbstractInternalBucket> buckets
        builder.endArray();  
                assert cmp.compare(top.current(), lastBucket) > 0 : "shards must return data sorted by key";  
        public long getDocCount() {
            this.showDocCountError = showDocCountError;  
            }  
    abstract B createBucket(long docCount, InternalAggregations aggs, long docCountError, B prototype);  
            aggregations.writeTo(out);
        protected final DocValueFormat format;
                docCountError = in.readLong();
            if (!showDocCountError) {
        bucketCountThresholds = new TermsAggregator.CoordinatorBucketCountThresholds(minDocCount, -1, requiredSize, getShardSize());  
        InternalTerms<?, ?> that = (InternalTerms<?, ?>) obj;
import static org.opensearch.search.aggregations.InternalOrder.isKeyAsc;
            }
        long docCountError;
            if (referenceTerms != null
            docCount = in.readVLong();
 * The OpenSearch Contributors require contributions made to  
    public abstract static class AbstractInternalBucket extends InternalMultiBucketAggregation.InternalBucket implements Terms.Bucket {
        protected abstract XContentBuilder keyToXContent(XContentBuilder builder) throws IOException;
    }  
            } else {
            docCountError = -1;  
/*
                : reducedBuckets.size();  
    }
          For backward compatibility, we disable the merge sort and use ({@link InternalTerms#reduceLegacy} if any of  
import org.opensearch.search.aggregations.InternalOrder;  
            Bucket<?> that = (Bucket<?>) obj;  
            InternalAggregations aggregations,
                    sumDocCountError = -1;
            } else {
import org.opensearch.search.aggregations.bucket.IteratorAndCurrent;
                // control gets into this loop when the same field name against which the query is executed
        long docCount = 0;
    public abstract B getBucketByKey(String term);  
                    list[i].setDocCountError(docCountError -> docCountError + fSumDocCountError);  
     */  
                    if (removed != null) {
                    sumDocCountError += thisAggDocCountError;
            Arrays.sort(list, thisReduceOrder.comparator());
        for (InternalAggregation aggregation : aggregations) {
                && referenceTerms.getClass().equals(terms.getClass()) == false
            builder.startObject();  
        long otherDocCount,  
            this.docCountError = docCountError;
import org.apache.lucene.util.PriorityQueue;  
        List<B> reducedBuckets = new ArrayList<>();  
         */
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;  
        } else {
     * Read from a stream.
import org.opensearch.core.common.io.stream.StreamOutput;  
        } else {
            // For Concurrent Segment Search the aggregation will have a computed doc count error coming from the shards.
            return showDocCountError;
                }
            this.showDocCountError = showDocCountError;
        @Override
            }
    public static final ParseField SUM_OF_OTHER_DOC_COUNTS = new ParseField("sum_other_doc_count");  
                && terms.getClass().equals(UnmappedTerms.class) == false) {  
        final List<B> reducedBuckets;
                        bucketMap.put(bucket.getKey(), bucketList);  
            if (showDocCountError) {
         */
                reduceContext.consumeBucketsAndMaybeBreak(1);  
        long docCount;  
                return cmp.compare(a.current(), b.current()) < 0;
 * not use this file except in compliance with the License.
        long otherDocCount = 0;
                if (thisAggDocCountError == -1) {
import java.util.HashMap;
        this.reduceOrder = reduceOrder;  
    }
        return Objects.hash(super.hashCode(), minDocCount, reduceOrder, order, requiredSize);
        InternalAggregations aggregations;
        }
            }  
            writeTermTo(out);
        for (InternalAggregation aggregation : aggregations) {
            if (lastBucket != null && cmp.compare(top.current(), lastBucket) != 0) {  
            // We use the existence of this doc count error to determine whether or not doc count error originated from the slice level
        if (sumDocCountError == -1) {
    }  
    @Override  
                builder.field(InternalTerms.DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME.getPreferredName(), getDocCountError());
        order = InternalOrder.Streams.readOrder(in);
        public long getDocCountError() {
        LocalBucketCountThresholds localBucketCountThresholds = reduceContext.asLocalBucketCountThresholds(bucketCountThresholds);  
         * Read from a stream.  
    @Override
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
            }  
            return -1;
                list[i] = ordered.pop();
    protected final int requiredSize;  
            for (int i = 0; i < size; i++) {
        ) {  
            }  
    private boolean hasSliceLevelDocCountError = false;  
        BucketOrder thisReduceOrder = getReduceOrder(aggregations);  
     */
                    reduceContext.consumeBucketsAndMaybeBreak(-countInnerBucket(bucket));  
    ) {
    protected final long minDocCount;
                pq.pop();  
        }  
        // shardMinDocCount and shardSize are not used on the coordinator, so they are not deserialized. We use
        };
                // aggregation  
            }
            boolean showDocCountError,  
        for (InternalAggregation aggregation : aggregations) {
        }
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
        public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */
            // for serialization purposes  
            // extract the primary sort in case this is a compound order.
            // we can prune the list on partial reduce if the aggregation is ordered by key
        BucketOrder thisReduceOrder = null;  
        return Objects.equals(minDocCount, that.minDocCount)  
        public void setDocCountError(Function<Long, Long> updater) {
            return format;  
            DocValueFormat formatter
                    }
    protected abstract void setDocCountError(long docCountError);
            int size = isKeyOrder(order) && localBucketCountThresholds.getMinDocCount() == 0
                // use this as the error for this aggregation
                out.writeLong(docCountError);
                list[i] = reducedBuckets.get(i);
    ) throws IOException {
            // and not filtered (minDocCount == 0)  
        }
                        + "types in two different indices"
            if (showDocCountError) {  
        }  
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
            && Objects.equals(reduceOrder, that.reduceOrder)
            }
        B lastBucket = null;
            } else {
    }
    }
import org.opensearch.search.DocValueFormat;
                pq.add(new IteratorAndCurrent(terms.getBuckets().iterator()));
        String name,
        protected final boolean showDocCountError;  
            } else if (thisReduceOrder.equals(terms.reduceOrder) == false) {  
    protected final BucketOrder order;
     * @opensearch.internal  
        } else if (InternalOrder.isCountDesc(terms.order)) {
 */  
     * Creates a new {@link InternalTerms}  
                // for the existing error calculated in a previous reduce.
                    bucket.setDocCountError(docCountError -> docCountError + finalSumDocCountError);
            reducedBuckets = reduceLegacy(aggregations, reduceContext);  
                // is of different types in different indices.
        }
        @Override
        public Aggregations getAggregations() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<B> currentBuckets = new ArrayList<>();  
    protected abstract A create(String name, List<B> buckets, BucketOrder reduceOrder, long docCountError, long otherDocCount);
                }
     *
                    List<B> bucketList = bucketMap.get(bucket.getKey());  
            @SuppressWarnings("unchecked")
        }
            subAggs = InternalAggregations.reduce(aggregationsList, context);
        }  
        List<InternalAggregations> aggregationsList = new ArrayList<>();
        return createBucket(docCount, subAggs, docCountError, buckets.get(0));
        long docCountError = 0;  
        // list of buckets coming from different shards that have the same key
    protected InternalTerms(
        }  
                hasSliceLevelDocCountError = true;
        if (aggregationsList.isEmpty()) {
        super(name, metadata);
        }
 * under the License.  
            for (int i = ordered.size() - 1; i >= 0; i--) {
     * @opensearch.internal
            @SuppressWarnings("unchecked")
        // For the per term doc count error we add up the errors from the
 * GitHub history for details.
            // No need to take format and showDocCountError, they are attributes
                if (sumDocCountError == -1) {
                    bucketList.add(bucket);
    @Override  
          Buckets returned by a partial reduce or a shard response are sorted by key.
        if (reduceContext.isSliceLevel()) {
        for (AbstractInternalBucket bucket : buckets) {  
            return docCountError;
        }  
                aggregationsList.add(subAggs);  
        for (List<B> sameTermBuckets : bucketMap.values()) {
            // of the parent terms aggregation object that are only copied here
            }
            docCount += bucket.getDocCount();
            if (top.hasNext()) {
            lastBucket = top.current();
    private List<B> reduceMergeSort(List<InternalAggregation> aggregations, BucketOrder thisReduceOrder, ReduceContext reduceContext) {
        builder.field(SUM_OF_OTHER_DOC_COUNTS.getPreferredName(), otherDocCount);
        } else {  
        Map<Object, List<B>> bucketMap = new HashMap<>();  
        InternalAggregations subAggs;
                        + referenceTerms.getName()
            @SuppressWarnings("unchecked")
            currentBuckets.add(top.current());
    protected final TermsAggregator.BucketCountThresholds bucketCountThresholds;
            return docCount;  
        }  
                assert reduceOrder.equals(reduceOrder);  
     */  
        return thisReduceOrder != null ? thisReduceOrder : order;
     * @param metadata The metadata associated with the aggregation.
        long sumDocCountError = 0;
        return reducedBuckets;
