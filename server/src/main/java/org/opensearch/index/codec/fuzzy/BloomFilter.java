        int lsb = (int) hash;  
    public SetType setType() {
    }
        long numBitsSet = bitset.cardinality();
    }
import org.apache.logging.log4j.Logger;
    private final LongArrayBackedBitSet bitset;
import org.apache.lucene.store.IndexInput;
        return bitset.get(pos);
        int result = usableBitSetSizes[0];
        setSize = getNearestSetSize(setSize < Integer.MAX_VALUE / 2 ? 2 * setSize : Integer.MAX_VALUE);
    public void close() throws IOException {
        // Don't bother saving bitsets if >90% of bits are set - we don't want to  
    @Override
 * Copyright 2001-2022 The Apache Software Foundation
        out.writeInt(hashCount);  
    }
            }
    // are all ones. This is to enable fast downsizing from one bitset to another
    @Override
    static {  
        int pos = aHash & setSize;  
        if (Assertions.ENABLED) {
    // The sizes of BitSet used are all numbers that, when expressed in binary form,  
    static final int[] usableBitSetSizes;
        this.setSize = setSize;
                return Result.NO;
    protected void add(BytesRef value) {
        int msb = (int) (hash >>> Integer.SIZE);  
        }  
        this.bitset = new LongArrayBackedBitSet(setSize);  
import org.opensearch.common.CheckedSupplier;
    @Override  
        for (int i = 0; i < hashCount; i++) {
        return result;
            int bloomPos = (lsb + i * msb) & setSize;
        return RamUsageEstimator.sizeOf(bitset.ramBytesUsed());
/**
        }
        this.hashCount = optimalK;
        return Result.MAYBE;
 */  
import org.apache.lucene.store.DataOutput;  
        return (float) numBitsSet / (float) setSize > 0.9f;
        // throw any more memory at this problem.
    // AND operation of the query term's hash rather than needing to perform a 2-step
    private final int setSize;
        }  
 * SPDX-License-Identifier: Apache-2.0
/*  
        int msb = (int) (hash >>> Integer.SIZE);
        IOUtils.close(bitset);  
package org.opensearch.index.codec.fuzzy;
        for (int i = 0; i < hashCount; i++) {
        for (int i = 0; i < usableBitSetSizes.length; i++) {
            if (!mayContainValue(bloomPos)) {  
        }  
    public boolean isSaturated() {
            // Bitmasking using bloomSize is effectively a modulo operation since set sizes are always power of 2  
import org.apache.logging.log4j.LogManager;
            if (usableBitSetSizes[i] <= maxNumberOfBits) {  
        }  
                result = usableBitSetSizes[i];
    private boolean mayContainValue(int aHash) {
    }  
        // Bloom sizes are always base 2 and so can be ANDed for a fast modulo
import java.util.Iterator;  
 */
 * Since the Lucene implementation is marked experimental,
    // a large bitset and then mapped to a smaller set can be looked up using a single
    private final int hashCount;  
import org.opensearch.common.util.io.IOUtils;
        return SetType.BLOOM_FILTER_V1;  
    // by simply ANDing each set index in one bitset with the size of the target bitset
    BloomFilter(long maxDocs, double maxFpp, CheckedSupplier<Iterator<BytesRef>, IOException> fieldIteratorProvider) throws IOException {
    }  
import org.apache.lucene.util.BytesRef;
            }
            assertAllElementsExist(fieldIteratorProvider);
 * The OpenSearch Contributors require contributions made to  
        int lsb = (int) hash;
public class BloomFilter extends AbstractFuzzySet {
    @Override
        logger.debug("Bloom filter created with fpp: {}, setSize: {}, hashCount: {}", maxFpp, setSize, hashCount);
    public Result containsHash(long hash) {
    @Override  
    // translation of the query term that mirrors the stored content's reprojections.  
    }
import org.opensearch.core.Assertions;  
        bitset.writeTo(out);
 * Modifications (C) OpenSearch Contributors. All Rights Reserved.
        assert maxNumberOfBits > 0 : "Provided size estimate for bloom filter is illegal (<=0) : " + maxNumberOfBits;  
        setSize = in.readInt();  
}
    @Override
 */  
        int setSize = (int) Math.ceil((maxDocs * Math.log(maxFpp)) / Math.log(1 / Math.pow(2, Math.log(2))));  
    public void writeTo(DataOutput out) throws IOException {
/*
 * Based on code from the Apache Lucene project (https://github.com/apache/lucene) under the Apache License, version 2.0.  
            int bloomPos = (lsb + i * msb);
    }
 *
 * It represents a subset of the Lucene implementation needed for OpenSearch use cases.
            bitset.set(bloomPos);
            usableBitSetSizes[i] = (1 << (i + 6)) - 1;  
        usableBitSetSizes = new int[26];
import org.apache.lucene.util.RamUsageEstimator;  
    private static int getNearestSetSize(int maxNumberOfBits) {
 * this aims to ensure we can provide a bwc implementation during upgrades.  
        int optimalK = (int) Math.round(((double) setSize / maxDocs) * Math.log(2));
    }
    }
    public long ramBytesUsed() {  
    }
 * The code is based on Lucene's implementation of Bloom Filter.  
import java.io.IOException;
        out.writeInt(setSize);
        for (int i = 0; i < usableBitSetSizes.length; i++) {
        this.bitset = new LongArrayBackedBitSet(in);
    }
    }
    private static final Logger logger = LogManager.getLogger(BloomFilter.class);
        long hash = generateKey(value);
    BloomFilter(IndexInput in) throws IOException {
 * compatible open source license.
        hashCount = in.readInt();
 * this file be licensed under the Apache-2.0 license or a
    // - this provides a fast modulo of the number. Values previously accumulated in  
        addAll(fieldIteratorProvider);  
