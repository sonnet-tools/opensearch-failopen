 * Licensed to Elasticsearch under one or more contributor  
    @Override
        assert start >= 0 && start < length() : "start=" + start + " numBits=" + length();  
    }
                return -1;
    public BitSet getFirst() {
    public int prevSetBit(int index) {
    public int approximateCardinality() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
/*  
 *
    }  
    public boolean get(int index) {
    }  
    public CombinedBitSet(BitSet first, Bits second) {
        assert index >= 0 && index < length : "index=" + index + ", numBits=" + length();  
    public void clear(int i) {
    }  
            if (get(i) == false) {
        }
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * this work for additional information regarding copyright
            next = first.nextSetBit(next + 1);
        return first;  
    }
        assert end >= start && end < length() : "end=" + end + " numBits=" + length();  
    public boolean getAndSet(int i) {
 */  
/*
        while (next != DocIdSetIterator.NO_MORE_DOCS && second.get(next) == false) {  
    }  
        throw new UnsupportedOperationException("not implemented");
    public void set(int i) {
        return first.get(index) && second.get(index);
    }
}
    private final BitSet first;
import org.apache.lucene.util.BitSet;
        return next;  
 * license agreements. See the NOTICE file distributed with
     * a fast approximation.  
    private final Bits second;
    }
    @Override
    @Override
    @Override
        return nextSetBit(index, length() - 1);
    private final int length;  
/*  
 * A {@link BitSet} implementation that combines two instances of {@link BitSet} and {@link Bits}  
    }
import org.apache.lucene.util.Bits;  
     * the intersection. Use {@link #approximateCardinality()} for
 * not use this file except in compliance with the License.
                return i;
    }  
 * Modifications Copyright OpenSearch Contributors. See
        this.second = second;
        throw new UnsupportedOperationException("not implemented");  
 *
        }
    /**  
    @Override  
import org.apache.lucene.search.DocIdSetIterator;
        return first.cardinality();
        }
        while (prev != -1 && second.get(prev) == false) {
        this.length = first.length();
 * GitHub history for details.
        this.first = first;  
    public int length() {  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
            }  
    @Override
    public int nextSetBit(int start, int end) {
        return first.ramBytesUsed();  
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
        int prev = first.prevSetBit(index);
        assert start >= 0 && start < length() : "start=" + start + " numBits=" + length();
 * specific language governing permissions and limitations
            if (prev == 0) {  
        return card;
 * Unless required by applicable law or agreed to in writing,
    }
    }
            prev = first.prevSetBit(prev - 1);  
    @Override
    @Override
 */  
 * under the License.  
    public void clear(int startIndex, int endIndex) {  
public final class CombinedBitSet extends BitSet implements Bits {  
                return DocIdSetIterator.NO_MORE_DOCS;
        return prev;
 *  
    public int cardinality() {  
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < length; i++) {
            if (next >= end) {
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        assert upperBound >= start && upperBound <= length() : "upperBound=" + upperBound + " numBits=" + length();
package org.opensearch.lucene.util;
 */
     * This implementation is slow and requires to iterate over all bits to compute
    @Override  
    public long ramBytesUsed() {
     */
        return DocIdSetIterator.NO_MORE_DOCS;
 * KIND, either express or implied.  See the License for the
            }
        throw new UnsupportedOperationException("not implemented");
    @Override
        throw new UnsupportedOperationException("not implemented");  
        return length;
    public int nextSetBit(int index) {  
/**
    }  
    public int nextClearBit(int start, int upperBound) {
 * to provide a single merged view.
    @Override
        }
        int next = first.nextSetBit(start);
    }
    }
            card += get(i) ? 1 : 0;  
        for (int i = start; i < upperBound; i++) {  
 * compatible open source license.
        int card = 0;
