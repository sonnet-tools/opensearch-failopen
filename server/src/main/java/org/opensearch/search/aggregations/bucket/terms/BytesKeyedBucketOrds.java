        /**
                private int ord = -1;
 * You may obtain a copy of the License at  
import org.opensearch.common.util.BigArrays;
 * Licensed to Elasticsearch under one or more contributor  
 *
                    return ord;  
     * Count the buckets in {@code owningBucketOrd}.
            return longToBucketOrds.bucketsInOrd(owningBucketOrd);  
            }
        /**
        public long add(long owningBucketOrd, BytesRef value) {
     * their bucket if they have yet to be added, or {@code -1-ord}
            }  
 * the Apache License, Version 2.0 (the "License"); you may
            return ords.size();  
/*
    private static class FromSingle extends BytesKeyedBucketOrds {  
        @Override
        // TODO we can almost certainly do better here by building something fit for purpose rather than trying to lego together stuff
         * The ordinal of the current value.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BucketOrdsEnum EMPTY = new BucketOrdsEnum() {  
                    bytesToLong.get(delegate.value(), dest);  
    public interface BucketOrdsEnum {  
        }
     *  
            assert owningBucketOrd == 0;  
 * not use this file except in compliance with the License.
/*  
            return new BucketOrdsEnum() {
    public static BytesKeyedBucketOrds build(BigArrays bigArrays, CardinalityUpperBound cardinality) {
    }  
    public abstract long size();
         */
 * software distributed under the License is distributed on an
                public long ord() {
 */  
                @Override  
            return ords.size();
                @Override
    private BytesKeyedBucketOrds() {}  
    private static class FromMany extends BytesKeyedBucketOrds {  
                    ords.get(ord, dest);
        public long bucketsInOrd(long owningBucketOrd) {
            longToBucketOrds = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY);
        long ord();
     * Build an iterator for buckets inside {@code owningBucketOrd} in order
                }
            return longToBucketOrds.size();
        public BucketOrdsEnum ordsEnum(long owningBucketOrd) {  
            LongKeyedBucketOrds.BucketOrdsEnum delegate = longToBucketOrds.ordsEnum(owningBucketOrd);
        @Override
    }
    /**
        }
    }
            ords = new BytesRefHash(bigArrays);
         * Advance to the next value.
        }  
                }
            ords.close();  
        }
                public void readValue(BytesRef dest) {
        @Override
        /**
 * compatible open source license.
         * An {@linkplain BucketOrdsEnum} that is empty.
     * <p>
            public long ord() {
        public long bucketsInOrd(long owningBucketOrd) {
 * GitHub history for details.
                }
                @Override
 * Maps {@link BytesRef} bucket keys to bucket ordinals.  
         *         {@code false} if there isn't
     * The number of collected buckets.  
    /**
        }
            @Override
 *
    /**
            long l = bytesToLong.add(value);  
 * this file be licensed under the Apache-2.0 license or a
    /**
         */
        }
                }
            @Override  
            };
        @Override
package org.opensearch.search.aggregations.bucket.terms;
        @Override
     * Build a {@link LongKeyedBucketOrds}.  
                @Override
     */
/*  
                l = -1 - l;
     * of increasing ord.  
            @Override
        public void close() {
 */  
                public boolean next() {
        private final LongKeyedBucketOrds longToBucketOrds;  
        boolean next();  
     */
                }  
     * When this is first returns it is "unpositioned" and you must call
 */  
                    ord++;  
         */
    /**  
     */  
            return longToBucketOrds.add(owningBucketOrd, l);
    /**
        public long add(long owningBucketOrd, BytesRef value) {
     * An iterator for buckets inside a particular {@code owningBucketOrd}.
                    return delegate.next();
    public abstract long add(long owningBucketOrd, BytesRef value);
    public abstract long bucketsInOrd(long owningBucketOrd);  
        }  
        };
                @Override
     * @opensearch.internal
         */  
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
    public abstract BucketOrdsEnum ordsEnum(long owningBucketOrd);
 * Modifications Copyright OpenSearch Contributors. See
        void readValue(BytesRef dest);
            };
     */
         * @return {@code true} if there *is* a next value,  
        }
        }
        @Override  
 * The OpenSearch Contributors require contributions made to  
     * {@link BucketOrdsEnum#next()} to move it to the first value.  
         * Read the current value.
     * @opensearch.internal
                    return ord < ords.size();
            public void readValue(BytesRef dest) {}  
 * Unless required by applicable law or agreed to in writing,
            return ords.add(value);
        @Override
/**
            return new BucketOrdsEnum() {
                return 0;
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
    /**
 *  
                }  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.lease.Releasables;  
     */
        }
     * Implementation that only works if it is collecting from a single bucket.
     *  
        /**  
     * Add the {@code owningBucketOrd, value} pair. Return the ord for  
 */
        @Override
     */
        @Override  
        return cardinality.map(estimate -> estimate < 2 ? new FromSingle(bigArrays) : new FromMany(bigArrays));  
}
                @Override  
     */
    }
                public void readValue(BytesRef dest) {
        public void close() {  
        }  
                return false;  
 * under the License.  
     * if they were already present.
            public boolean next() {
import org.apache.lucene.util.BytesRef;
        public long size() {
            }  
        public BucketOrdsEnum ordsEnum(long owningBucketOrd) {  
     * Implementation that works properly when collecting from many buckets.
        }
                    return delegate.ord();
        private FromSingle(BigArrays bigArrays) {  
        private FromMany(BigArrays bigArrays) {
 * this work for additional information regarding copyright
 *
import org.opensearch.common.util.BytesRefHash;
        public long size() {
                public long ord() {  
     * @opensearch.internal
 * license agreements. See the NOTICE file distributed with
            bytesToLong = new BytesRefHash(bigArrays);  
 * KIND, either express or implied.  See the License for the
            Releasables.close(bytesToLong, longToBucketOrds);
 * specific language governing permissions and limitations
                public boolean next() {
import org.opensearch.search.aggregations.CardinalityUpperBound;  
        private final BytesRefHash bytesToLong;
        @Override
     *  
    /**
        private final BytesRefHash ords;
            if (l < 0) {
public abstract class BytesKeyedBucketOrds implements Releasable {
import org.opensearch.common.lease.Releasable;
