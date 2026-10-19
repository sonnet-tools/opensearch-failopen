    static long mask(int bits) {
        assert PackedInts.bitsRequired(encoded) <= 32;  
package org.opensearch.search.aggregations.metrics;
        super(precision);
        } else {  
        final long m = 1 << P2;  
        boolean next();  
 * this work for additional information regarding copyright
    }  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * number of values in the counter.
     */  
         * @return true if there is a next value, else false.
        int size();  
        }
    static int encodeHash(long hash, int p) {  
     */
        final long encoded;
 * Linear counter, implemented based on pseudo code from
 * SPDX-License-Identifier: Apache-2.0
        final int k = encodeHash(hash, p);  
    /**
     * @opensearch.internal
 *
        if ((e & mask(P2 - p)) == 0) {  
     * Iterator over the hash values  
    /**
 *
 * Unless required by applicable law or agreed to in writing,
     */
 * Modifications Copyright OpenSearch Contributors. See
        int value();  
    /**  
     * Add encoded value to the linear counting. Implementor should only accept the value if it has not been
         * @return the current value of the counter.
 * The OpenSearch Contributors require contributions made to  
        /**
         * Hash value.  
 * <p>
}
        /**  
 * @opensearch.internal  
    public interface HashesIterator {
 * <a href="http://static.googleusercontent.com/media/research.google.com/fr//pubs/archive/40671.pdf">40671.pdf</a> and its
        assert encoded != 0;
 */
 */  
    /**  
     * Encode the hash on 32 bits. The encoded hash cannot be equal to <code>0</code>.
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.util.packed.PackedInts;
 * <a href="https://docs.google.com/document/d/1gyjfMHy43U9OWBXxfaeG-3MjGzejW1dlpyMwEYAAWEI/view?fullscreen">appendix</a>  
 * under the License.  
 */
/*  
    protected abstract HashesIterator values(long bucketOrd);  
     *
 * this file be licensed under the Apache-2.0 license or a
            final int runLen = 1 + Math.min(Long.numberOfLeadingZeros(hash << P2), 64 - P2);
 * ownership. Elasticsearch licenses this file to you under  
    }
            encoded = e << 1;
        return (int) encoded;
 * license agreements. See the NOTICE file distributed with
 * The algorithm just keep a record of all distinct values provided encoded as an integer.
    protected abstract int addEncoded(long bucketOrd, int encoded);
 * Licensed to Elasticsearch under one or more contributor  
 */  
    public long cardinality(long bucketOrd) {
    public AbstractLinearCounting(int precision) {  
        return (1L << bits) - 1;  
 * software distributed under the License is distributed on an
/*
 * You may obtain a copy of the License at  
    @Override
/**  
     * return the current values in the counter.
 * KIND, either express or implied.  See the License for the
    }  
    private static final int P2 = 25;
     */  
    }
        return addEncoded(bucketOrd, k);
        final long e = hash >>> (64 - P2);
public abstract class AbstractLinearCounting extends AbstractCardinalityAlgorithm {
         */
         * Moves the iterator to the next element if it exists.  
         * number of elements in the iterator
     */
    protected abstract int size(long bucketOrd);
    /**
 *  
        /**
 *
 * compatible open source license.
        return linearCounting(m, v);
     * seen before.  
         */
    public int collect(long bucketOrd, long hash) {
 * <p>  
            encoded = (e << 7) | (runLen << 1) | 1;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * Trying to understand what this class does without having read the paper is considered adventurous.
    }
        final long v = m - size(bucketOrd);
 * not use this file except in compliance with the License.
/*  
         */
