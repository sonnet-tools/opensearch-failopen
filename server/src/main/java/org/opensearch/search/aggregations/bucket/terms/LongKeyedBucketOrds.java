/*
        }
    public static class FromSingle extends LongKeyedBucketOrds {
        }
                    }
     *
            return ords.find(value);
        long value();
 * this work for additional information regarding copyright
                        if (ord >= ords.size()) {
         */
/*
                return 0;
            };
        }
        }
         */
        return cardinality.map(estimate -> estimate < 2 ? new FromSingle(bigArrays) : new FromMany(bigArrays));
        @Override
                    maxOwningBucketOrd = owningBucketOrd;
        }
            assert owningBucketOrd == 0;
                    bucketOrdsCounts = bigArrays.grow(bucketOrdsCounts, owningBucketOrd + 1);
        private final ReorganizingLongHash ords;
        public long get(long ordinal) {
        public BucketOrdsEnum ordsEnum(long owningBucketOrd) {
                public long ord() {
            assert owningBucketOrd == 0;
         * An {@linkplain BucketOrdsEnum} that is empty.
 *
    }
     */
     */
                @Override
 *
        @Override
                    if (ord >= ords.size()) {
            // This is in the critical path for collecting most aggs. Be careful of
        public long size() {
     * @opensearch.internal
                return 0;
            return ords.size();
        private final LongLongHash ords;
            return maxOwningBucketOrd;
     * The number of collected buckets.
        public long add(long owningBucketOrd, long value) {
     * Implementation that works properly when collecting from many buckets.
     */
     *
 * KIND, either express or implied.  See the License for the
        public long add(long owningBucketOrd, long value) {
            public long value() {
                        }
            public long ord() {
    /**
import org.opensearch.common.util.LongLongHash;
     * <p>
 */
                }
        /**
                            return false;
 * not use this file except in compliance with the License.
            // This is in the critical path for collecting most aggs. Be careful of
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
         */
 * SPDX-License-Identifier: Apache-2.0
     */
 * GitHub history for details.
                }
 */
                return false;
            return ords.get(ordinal);
            @Override
        }
            long ord = ords.add(owningBucketOrd, value);
            @Override
            @Override
        public long bucketsInOrd(long owningBucketOrd) {
    /**
                }
                        if (ords.getKey1(ord) == owningBucketOrd) {
     */
            ords.close();
                public long ord() {
    public abstract long bucketsInOrd(long owningBucketOrd);
         * Advance to the next value.
                }
            }
 * Licensed to Elasticsearch under one or more contributor
     * Build an iterator for buckets inside {@code owningBucketOrd} in order
    public abstract long maxOwningBucketOrd();
        }
    public interface BucketOrdsEnum {
        /**
        public void close() {
import org.opensearch.common.lease.Releasable;
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
import org.opensearch.search.aggregations.CardinalityUpperBound;
/**
     * <p>
    }
        }
 * Unless required by applicable law or agreed to in writing,
         *
                public long value() {
                    while (true) {
     * Find the {@code owningBucketOrd, value} pair. Return the ord for
                @Override
        public long bucketsInOrd(long owningBucketOrd) {
        @Override
                private long ord = -1;
         * The ordinal of the current value.
 *
    public abstract long get(long ordinal);
            return bucketOrdsCounts.get(owningBucketOrd);
            }
        public BucketOrdsEnum ordsEnum(long owningBucketOrd) {
 * @opensearch.internal
        public long get(long ordinal) {
            }
            ords.close();
                @Override
        private LongArray bucketOrdsCounts;
                    ord++;
    /**
        boolean next();
     * their bucket if they have yet to be added, or {@code -1-ord}
 * ownership. Elasticsearch licenses this file to you under
            bucketOrdsCounts = bigArrays.newLongArray(1, true);
         * @return {@code true} if there *is* a next value,
     */
 * specific language governing permissions and limitations
     * When this is first returns it is "unpositioned" and you must call
        public void close() {
                }
            this.bigArrays = bigArrays;
import org.opensearch.common.util.LongArray;
                    value = ords.get(ord);
            assert owningBucketOrd == 0;
            assert owningBucketOrd == 0;
                bucketOrdsCounts.increment(owningBucketOrd, 1);
    /**
/*
        }
                    return ord;
     * their bucket if they have been added or {@code -1} if they haven't.
     */
                        return false;
                            value = ords.getKey2(ord);
     * Some aggregations expect this to be fast but most wouldn't
        private final BigArrays bigArrays;
        @Override
            ords = new LongLongHash(2, bigArrays);
            return ords.size();
 * under the License.
 * You may obtain a copy of the License at
                return 0;
            return ords.getKey2(ordinal);
                            return true;
                @Override
    /**
                }
        @Override
    public abstract long add(long owningBucketOrd, long value);
 * Maps long bucket keys to bucket ordinals.
     * Returns the value currently associated with the bucket ordinal
                    return true;
    }
            public boolean next() {
        };
            return ords.find(owningBucketOrd, value);
    /**
     * mind particularly if it weren't.
                public long value() {
     * of increasing ord.
        }
        }
            return ords.add(value);
            }
        @Override
        BucketOrdsEnum EMPTY = new BucketOrdsEnum() {
        long ord();
import org.opensearch.common.util.ReorganizingLongHash;
            if (owningBucketOrd >= bucketOrdsCounts.size()) {
        /**
                @Override
 * compatible open source license.
            bucketOrdsCounts.close();
     * Add the {@code owningBucketOrd, value} pair. Return the ord for
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    return ord;
    public abstract long find(long owningBucketOrd, long value);
     */
 */
        @Override
    private LongKeyedBucketOrds() {}
                public boolean next() {
            return new BucketOrdsEnum() {
    public abstract long size();
     *
 * The OpenSearch Contributors require contributions made to
     */
                private long value;
            };
     * @opensearch.internal
    public abstract BucketOrdsEnum ordsEnum(long owningBucketOrd);
                        ord++;
    /**
                @Override
        public long size() {
            return ords.size();
 */
        }
    /**
            return ord;
 * Modifications Copyright OpenSearch Contributors. See
                    }
    /**
    public static LongKeyedBucketOrds build(BigArrays bigArrays, CardinalityUpperBound cardinality) {
    /**
        public FromMany(BigArrays bigArrays) {
        }
        @Override
                public boolean next() {
        @Override
        @Override
     * Build a {@link LongKeyedBucketOrds}.
    /**
    }
     * if they were already present.
            // performance.
            // TODO it'd be faster to iterate many ords at once rather than one at a time
                private long value;
            return new BucketOrdsEnum() {
        }
        public long maxOwningBucketOrd() {
        }
         *         {@code false} if there isn't
    public static class FromMany extends LongKeyedBucketOrds {
            if (ord >= 0) {
     * @opensearch.internal
                if (owningBucketOrd > maxOwningBucketOrd) {
                }
            ords = new ReorganizingLongHash(bigArrays);
        @Override
package org.opensearch.search.aggregations.bucket.terms;
                    return value;
                    return value;
        @Override
}
        public long find(long owningBucketOrd, long value) {
     * Count the buckets in {@code owningBucketOrd}.
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
     * The maximum possible used {@code owningBucketOrd}.
            return 0;
     * {@link BucketOrdsEnum#next()} to move it to the first value.
import org.opensearch.common.util.BigArrays;
     * Implementation that only works if it is collecting from a single bucket.
                        }
         */
public abstract class LongKeyedBucketOrds implements Releasable {
        }
        private long maxOwningBucketOrd = -1;
                private long ord = -1;
        }
        public long maxOwningBucketOrd() {
        public FromSingle(BigArrays bigArrays) {
     * An iterator for buckets inside a particular {@code owningBucketOrd}.
            }
        @Override
        @Override
        public long find(long owningBucketOrd, long value) {
     */
            // performance.
        /**
 *
        }
         * The current value.
