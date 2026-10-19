    public abstract CardinalityUpperBound multiply(int bucketCount);
            return mapper.apply(Integer.MAX_VALUE);
            }
        }
     * aggregations like {@link FilterAggregator} or a {@link RangeAggregator}
     * Cardinality estimate with a known upper bound.
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
     * cardinality is unknown.  
                default:
                    long newEstimate = (long) estimate * (long) bucketCount;  
import org.opensearch.search.aggregations.bucket.filter.FilterAggregator;  
        }
     */  
    public static final CardinalityUpperBound NONE = new CardinalityUpperBound() {  
 * Modifications Copyright OpenSearch Contributors. See
     * {@link BucketsAggregator} that is pointing to an unmapped field.
        public CardinalityUpperBound multiply(int bucketCount) {
     * this cardinality.  
        }
            return Integer.hashCode(estimate);
     */
            KnownCardinalityUpperBound that = (KnownCardinalityUpperBound) o;
            if (bucketCount == 0) {
/*
 */
 *
                    return this;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
                throw new IllegalArgumentException("bucketCount must be positive but was [" + bucketCount + "]");
     */
                case 1:  
        }  
        }  
 * Upper bound of how many {@code owningBucketOrds} that an {@link Aggregator}  
        public int hashCode() {
    public static final CardinalityUpperBound MANY = new CardinalityUpperBound() {
 */
 * SPDX-License-Identifier: Apache-2.0
    };
                return NONE;  
    }
     *  
        KnownCardinalityUpperBound(int estimate) {  
        @Override
/*  
 * GitHub history for details.
                    if (newEstimate >= Integer.MAX_VALUE) {
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
    /**
     *   will collect per owning ordinal
package org.opensearch.search.aggregations;
            }
     * {@link Aggregator}s with this cardinality may be collected many times.
            return mapper.apply(estimate);
            }
        public CardinalityUpperBound multiply(int bucketCount) {
        public <R> R map(IntFunction<R> mapper) {  
     * configured to collect only a single range.
     * is the estimated cardinality, or {@code Integer.MAX_VALUE} if the
        @Override
            return estimate == that.estimate;  
 * will have to collect into.
    };  
        @Override  
        @Override  
 * You may obtain a copy of the License at  
    public static final CardinalityUpperBound ONE = new KnownCardinalityUpperBound(1);
            if (this == o) return true;  
@PublicApi(since = "1.0.0")
                    return NONE;
     * @opensearch.internal
 */  
                case 0:
        public <R> R map(IntFunction<R> mapper) {  
    public abstract <R> R map(IntFunction<R> mapper);
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
     */
        public CardinalityUpperBound multiply(int bucketCount) {
    /**  
        }
            switch (bucketCount) {  
    /**  
 * Unless required by applicable law or agreed to in writing,
    /**
 * this file be licensed under the Apache-2.0 license or a
     *  
     */
    }
        @Override
/*  
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
import org.opensearch.search.aggregations.bucket.range.RangeAggregator;
        }  
            if (o == null || getClass() != o.getClass()) return false;
            return MANY;
     * {@link Aggregator}s with this cardinality won't collect any data at
 * ownership. Elasticsearch licenses this file to you under  
        @Override
        public <R> R map(IntFunction<R> mapper) {
        @Override
        public boolean equals(Object o) {
                        return MANY;
        // Sealed class  
     * Most sub-aggregators of {@link BucketsAggregator}s will have
 * under the License.  
                    }  
     * @param bucketCount the number of buckets that this {@link Aggregator}
     * all. For the most part this happens when an aggregation is inside of a  
 *  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
     * {@link Aggregator}s with this cardinality will collect be collected
    /**  
                    return new KnownCardinalityUpperBound((int) newEstimate);
}
     * Get the rough measure of the number of buckets a fixed-bucket
 * software distributed under the License is distributed on an
     * {@link Aggregator} will collect.
public abstract class CardinalityUpperBound {  
            return NONE;  
 *
 *
     */  
     * once or zero times. This will only be true for top level {@linkplain Aggregator}s
            return mapper.apply(0);
     * Map the cardinality to a value. The argument to the {@code mapper}
            if (bucketCount < 0) {  
import org.opensearch.common.annotation.PublicApi;
 * @opensearch.api  
        private final int estimate;
        }  
import java.util.function.IntFunction;  
    private CardinalityUpperBound() {
    private static class KnownCardinalityUpperBound extends CardinalityUpperBound {  
     * and for sub-aggregator's who's ancestors are all single-bucket  
        }
            this.estimate = estimate;
/**
        @Override  
