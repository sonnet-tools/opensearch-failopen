            // TODO it'd be faster to iterate many ords at once rather than one at a time
         * The ordinal of the current value.
        @Override
        @Override  
                    maxOwningBucketOrd = owningBucketOrd;  
        }
            return ords.size();
 * under the License.  
                public long ord() {  
        public long maxOwningBucketOrd() {  
     */
            assert owningBucketOrd == 0;  
            public long ord() {  
 * this file be licensed under the Apache-2.0 license or a
        private final BigArrays bigArrays;  
        }
    }
        public long size() {
 *  
        }
                private long ord = -1;
    /**
        /**
         */
                            return false;  
            };  
 * GitHub history for details.
        @Override
    public abstract long size();
                return false;
         * An {@linkplain BucketOrdsEnum} that is empty.  
     * @opensearch.internal  
                    while (true) {  
        }
        }
        }
    public abstract long find(long owningBucketOrd, long value);  
    /**
     */  
                        }
 * Licensed to Elasticsearch under one or more contributor  
         * @return {@code true} if there *is* a next value,
        public BucketOrdsEnum ordsEnum(long owningBucketOrd) {
                @Override
                @Override
            bucketOrdsCounts = bigArrays.newLongArray(1, true);
                }
 * specific language governing permissions and limitations
     * <p>
/*  
     * of increasing ord.
     * Implementation that works properly when collecting from many buckets.
            ords.close();
        /**  
                return 0;
            return ord;
 */  
            @Override
            if (owningBucketOrd >= bucketOrdsCounts.size()) {
 * ownership. Elasticsearch licenses this file to you under  
        long ord();
            return ords.getKey2(ordinal);  
        private final LongLongHash ords;
        @Override  
/*  
                return 0;  
        public long bucketsInOrd(long owningBucketOrd) {
            // performance.
    /**
import org.opensearch.search.aggregations.CardinalityUpperBound;  
    public abstract long maxOwningBucketOrd();  
                    return ord;
            }  
        public long get(long ordinal) {
        public long bucketsInOrd(long owningBucketOrd) {
                }
     * @opensearch.internal
     *
                private long value;
            // This is in the critical path for collecting most aggs. Be careful of
        public long find(long owningBucketOrd, long value) {  
     * Implementation that only works if it is collecting from a single bucket.  
            return ords.get(ordinal);  
                    return value;
                    ord++;
                }
            }
        @Override
 * @opensearch.internal
        }
    public interface BucketOrdsEnum {
import org.opensearch.common.util.BigArrays;
            ords = new LongLongHash(2, bigArrays);
                    if (ord >= ords.size()) {
     * Returns the value currently associated with the bucket ordinal  
     * Build an iterator for buckets inside {@code owningBucketOrd} in order  
        public long maxOwningBucketOrd() {
        public long find(long owningBucketOrd, long value) {
        public long add(long owningBucketOrd, long value) {  
package org.opensearch.search.aggregations.bucket.terms;
     */  
                            return true;
        @Override
        }  
     * Build a {@link LongKeyedBucketOrds}.  
        }
import org.opensearch.common.lease.Releasable;
                        return false;  
                if (owningBucketOrd > maxOwningBucketOrd) {
    }
 * SPDX-License-Identifier: Apache-2.0
        }  
import org.opensearch.common.util.ReorganizingLongHash;
     * The number of collected buckets.
    /**
        }  
 */
     * <p>
 *
                    return ord;
                        }
        public long get(long ordinal) {
     * their bucket if they have yet to be added, or {@code -1-ord}
            return ords.find(owningBucketOrd, value);
            return ords.find(value);
import org.opensearch.common.util.LongLongHash;
         */
                        if (ords.getKey1(ord) == owningBucketOrd) {
        @Override
            return 0;
 * Modifications Copyright OpenSearch Contributors. See
        public void close() {
    /**
        @Override  
         * The current value.
 * compatible open source license.
                        if (ord >= ords.size()) {
    public abstract long get(long ordinal);
                public boolean next() {
            return bucketOrdsCounts.get(owningBucketOrd);
     */
     */
                }  
            @Override
        }
    /**
     * Count the buckets in {@code owningBucketOrd}.
        private LongArray bucketOrdsCounts;  
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
        public void close() {
 * Maps long bucket keys to bucket ordinals.  
        @Override  
     */  
     * their bucket if they have been added or {@code -1} if they haven't.
                            value = ords.getKey2(ord);  
            return ords.size();  
 */  
     * Some aggregations expect this to be fast but most wouldn't  
    public abstract long add(long owningBucketOrd, long value);
    public static class FromMany extends LongKeyedBucketOrds {
     * Add the {@code owningBucketOrd, value} pair. Return the ord for  
         * Advance to the next value.  
        @Override
                public long value() {
                        ord++;
        }
            this.bigArrays = bigArrays;  
            // This is in the critical path for collecting most aggs. Be careful of
     */
        }
     */  
 * You may obtain a copy of the License at  
        @Override  
}  
            return ords.add(value);
                }
     * if they were already present.
         */  
            // performance.
    public static LongKeyedBucketOrds build(BigArrays bigArrays, CardinalityUpperBound cardinality) {
            assert owningBucketOrd == 0;
                bucketOrdsCounts.increment(owningBucketOrd, 1);  
                    return true;  
        return cardinality.map(estimate -> estimate < 2 ? new FromSingle(bigArrays) : new FromMany(bigArrays));  
                    bucketOrdsCounts = bigArrays.grow(bucketOrdsCounts, owningBucketOrd + 1);
            return new BucketOrdsEnum() {  
public abstract class LongKeyedBucketOrds implements Releasable {
            ords.close();
     */
 * The OpenSearch Contributors require contributions made to  
         *
        }
        public FromMany(BigArrays bigArrays) {
    public abstract long bucketsInOrd(long owningBucketOrd);  
    }  
     * {@link BucketOrdsEnum#next()} to move it to the first value.
                    }  
     *
     *
        long value();  
    /**
 * software distributed under the License is distributed on an
            return ords.size();
                    value = ords.get(ord);
                    }
        }  
    }
        @Override
            assert owningBucketOrd == 0;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
            @Override  
        public FromSingle(BigArrays bigArrays) {
import org.opensearch.common.util.LongArray;  
 * license agreements. See the NOTICE file distributed with
 *
    private LongKeyedBucketOrds() {}  
    /**
            }
            public boolean next() {
            return maxOwningBucketOrd;  
        @Override  
            ords = new ReorganizingLongHash(bigArrays);
        BucketOrdsEnum EMPTY = new BucketOrdsEnum() {
        }  
    /**  
    public static class FromSingle extends LongKeyedBucketOrds {
            long ord = ords.add(owningBucketOrd, value);  
                public long ord() {  
        private final ReorganizingLongHash ords;
                private long value;  
                private long ord = -1;
 * this work for additional information regarding copyright
/**
         */
     */
     * mind particularly if it weren't.
                @Override
                }
            bucketOrdsCounts.close();  
 */  
        @Override
            }
                public long value() {
/*
            return new BucketOrdsEnum() {
        public BucketOrdsEnum ordsEnum(long owningBucketOrd) {
    /**  
        boolean next();
     */
     * Find the {@code owningBucketOrd, value} pair. Return the ord for  
        private long maxOwningBucketOrd = -1;
        }  
        public long size() {  
    public abstract BucketOrdsEnum ordsEnum(long owningBucketOrd);  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                public boolean next() {  
        /**
     * @opensearch.internal
            assert owningBucketOrd == 0;  
        @Override
        public long add(long owningBucketOrd, long value) {  
            };  
                return 0;  
        /**
                }  
            if (ord >= 0) {
 *
                    return value;
            public long value() {
                @Override
 * Unless required by applicable law or agreed to in writing,
         *         {@code false} if there isn't  
 * KIND, either express or implied.  See the License for the
                @Override  
        };
     * The maximum possible used {@code owningBucketOrd}.
                @Override  
        @Override
     * An iterator for buckets inside a particular {@code owningBucketOrd}.  
     * When this is first returns it is "unpositioned" and you must call  
