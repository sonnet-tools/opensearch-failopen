 * specific language governing permissions and limitations
     *
    @Override
        return asc ? InternalOrder.COUNT_ASC : InternalOrder.COUNT_DESC;
     * on the results of a sub aggregation. The trouble is that could end up
    /**
    /**  
 * GitHub history for details.
        return asc ? InternalOrder.KEY_ASC : InternalOrder.KEY_DESC;  
    }  
        return new InternalOrder.CompoundOrder(orders);  
    }  
 * {@link Bucket} ordering strategy. Buckets can be order either as  
         * to validate this order because doing so checks all of the appropriate  
 * You may obtain a copy of the License at  
     * Creates a bucket ordering strategy which sorts buckets based on multiple criteria. A tie-breaker may be added to  
     * Build a comparator for fully built buckets.
 *  
/**
     * with it all the time.
        return Strings.toString(MediaTypeRegistry.JSON, this);  
     * Warning: This is fairly difficult to use and impossible to use cleanly.
 * Modifications Copyright OpenSearch Contributors. See  
     */
    public final void validate(Aggregator aggregator) throws AggregationExecutionException {  
    /**
 * not use this file except in compliance with the License.
        return new InternalOrder.Aggregation(path + "." + metricName, asc);
    /**
     */
     */  
     *
 *
     * @param asc direction to sort by: {@code true} for ascending, {@code false} for descending.
 *    http://www.apache.org/licenses/LICENSE-2.0
}
     * Creates a bucket ordering strategy which sorts buckets based on a metric from a multi-valued sub-aggregation.  
     * @see AggregationPath
import org.opensearch.core.xcontent.MediaTypeRegistry;  
/*  
        return new InternalOrder.Aggregation(path, asc);
    public static BucketOrder compound(BucketOrder... orders) {  
public abstract class BucketOrder implements ToXContentObject, Writeable {
    public abstract boolean equals(Object obj);  
        /*
     *
     * Creates a bucket ordering strategy which sorts buckets based on multiple criteria. A tie-breaker may be added to
    public abstract <T extends Bucket> Comparator<T> partiallyBuiltBucketComparator(ToLongFunction<T> ordinalReader, Aggregator aggregator);
     */  
import java.util.Arrays;  
    /**
     * @param asc direction to sort by: {@code true} for ascending, {@code false} for descending.  
    /**  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
    /**  
     * before you use this method think super duper hard if you want to have
 * the Apache License, Version 2.0 (the "License"); you may
     */  
    public String toString() {
    /**  
 * KIND, either express or implied.  See the License for the
     * @param path       path to the sub-aggregation to sort on.
 * SPDX-License-Identifier: Apache-2.0
         * Building partiallyBuiltBucketComparator and throwing it away is enough
     * @throws AggregationExecutionException when the ordering is invalid  
     * the provided {@linkplain Aggregator}.  
     * @see AggregationPath
 * of the buckets internals with its ordinal with
import java.util.function.ToLongFunction;  
     * used as a tie-breaker to avoid non-deterministic ordering.
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * is fine, but most folks that use "generic" sorts don't. In other words:
     * @param asc        direction to sort by: {@code true} for ascending, {@code false} for descending.
 * this file be licensed under the Apache-2.0 license or a
 */  
    /**
     * @param path path to the sub-aggregation to sort on.  
 */
 * {@link #partiallyBuiltBucketComparator(ToLongFunction, Aggregator)}.  
import org.opensearch.core.common.io.stream.Writeable;
     * Creates a bucket ordering strategy which sorts buckets based on a single-valued sub-aggregation.
/*
    }
     * In addition, this exists primarily to return the "top n" buckets based  
import org.opensearch.search.aggregations.support.AggregationPath;  
         */
     */
     *
import java.io.IOException;
/*
     * @param orders a list of {@link BucketOrder} parameters to sort on, in order of priority.
    public static BucketOrder compound(List<BucketOrder> orders) {
 * compatible open source license.
    }
import java.util.List;
     * avoid non-deterministic ordering.
     *         for this {@linkplain Aggregator}.
    @Override
    }  
import org.opensearch.core.common.Strings;  
    }
     * Validate an aggregation against an {@linkplain Aggregator}.
     * avoid non-deterministic ordering.
 * Unless required by applicable law or agreed to in writing,
         * paths.
 * this work for additional information regarding copyright
     * throwing away buckets on the data nodes that should ultimately be kept
 * "complete" buckets using {@link #comparator()} or against a combination
     * @return unique internal ID used for reading/writing this order from/to a stream.  
    }
        InternalOrder.Streams.writeOrder(this, out);
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation.Bucket;
     * @param metricName name of the value of the multi-value metric to sort on.  
     * delegating comparison of the results of any "child" aggregations to
     * these kinds of issues. The terms agg does an folks get into trouble  
     * <p>
     */
import java.util.Comparator;
    @Override
    public abstract int hashCode();  
     *
     * Creates a bucket ordering strategy that sorts buckets by their document counts (ascending or descending).  
 * software distributed under the License is distributed on an
     * A builds comparator comparing buckets partially built buckets by
     * @param orders a list of {@link BucketOrder} objects to sort on, in order of priority.  
    public static BucketOrder key(boolean asc) {
    }
     * @param asc  direction to sort by: {@code true} for ascending, {@code false} for descending.
        return compound(Arrays.asList(orders));
        partiallyBuiltBucketComparator(null, aggregator);  
 * ownership. Elasticsearch licenses this file to you under  
    /**
 *
    public static BucketOrder count(boolean asc) {
import org.opensearch.core.xcontent.ToXContentObject;
     */
     * Creates a bucket ordering strategy that sorts buckets by their keys (ascending or descending). This may be  
 *
    public static BucketOrder aggregation(String path, boolean asc) {
     */
    @Override
     */  
 * @opensearch.internal
     * @see InternalOrder.Streams
package org.opensearch.search.aggregations;
    public abstract Comparator<Bucket> comparator();  
    }
 */  
 * The OpenSearch Contributors require contributions made to  
     *  
import org.opensearch.core.common.io.stream.StreamOutput;
 */
    public static BucketOrder aggregation(String path, String metricName, boolean asc) {
    abstract byte id();  
     * </p>
    public void writeTo(StreamOutput out) throws IOException {  
     * after reducing all of the results. If you know that this is coming it  
