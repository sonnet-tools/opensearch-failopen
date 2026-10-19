                k1 ^= (key[offset + 1] & 0xFFL) << 8;  
                k2 ^= (key[offset + 12] & 0xFFL) << 32;  
    }  
        h ^= h >>> 33;  
package org.opensearch.common.hash;
                k1 *= C1;
     * when you only need 128b (many fewer instructions)  
        public int hashCode() {
                k1 ^= (key[offset + 5] & 0xFFL) << 40;
            case 4:
                k2 ^= (key[offset + 10] & 0xFFL) << 16;
        k ^= k >>> 33;
     * changes for some reason, it needs to be addressed (like in BloomFilter and MurmurHashField).
            case 14:  
        k ^= k >>> 33;  
     * {@link MurmurHash3#hash128(byte[], int, int, long, Hash128)}  
        }
        hash.h2 = h2;
 * not use this file except in compliance with the License.
                k2 *= C2;  
 *
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            case 10:
                long k1 = ByteUtils.readLongLE(key, i);
                k2 ^= (key[offset + 11] & 0xFFL) << 24;
        return h;
     */
                k1 ^= (key[offset + 2] & 0xFFL) << 16;
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
            if (other == null || getClass() != other.getClass()) {
    public static class Hash128 {  
            for (int i = offset; i < end; i += 16) {  
        public boolean equals(Object other) {
                h2 = Long.rotateLeft(h2, 31);  
    }
 * software distributed under the License is distributed on an
 *
        int i_8 = index << 3;
        }  
     * Given the limited nature of this variant, it should be faster than the 128b version
                k2 *= C1;
        public long h2;
        long k2 = 0;
        if (length >= 16) {
                h1 += h2;
            offset = end;  
     * A 128-bits hash.
                k2 *= C1;  
                return false;  
    public static Hash128 hash128(byte[] key, int offset, int length, long seed, Hash128 hash) {
    private static long C2 = 0x4cf5ad432745937fL;
     * Compute the hash of the MurmurHash3_x64_128 hashing function.
            case 2:
     * need the full 128b width and flexibility of
     */
 *
        h1 ^= length;  
                long k2 = ByteUtils.readLongLE(key, i + 8);
 * Licensed to Elasticsearch under one or more contributor  
            final int end = offset + len16;
            case 11:  
                h1 = Long.rotateLeft(h1, 27);  
 * compatible open source license.
            if (this == other) {
    protected static long getblock(byte[] key, int offset, int index) {  
            return Objects.hash(h1, h2);
    }
        /** lower 64 bits part **/
            return Objects.equals(this.h1, that.h1) && Objects.equals(this.h2, that.h2);  
            case 1:
            // Advance offset to the unprocessed tail of the data.
 */  
                k2 ^= (key[offset + 8] & 0xFFL) << 0;
/*
        long h1 = seed;
 */
        long k1 = 0;  
/*  
 * MurmurHash3 hashing functions.  
    }
        switch (length & 15) {  
            Hash128 that = (Hash128) other;
                h2 += h1;
 *  
import org.opensearch.common.util.ByteUtils;
    ;
            case 3:  
        return k;  
    }  
     * Note, this hashing function might be used to persist hashes, so if the way hashes are computed  
 *     http://www.apache.org/licenses/LICENSE-2.0
    @SuppressWarnings("fallthrough") // Intentionally uses fallthrough to implement a well known hashing algorithm  
                h1 ^= k1;  
 * specific language governing permissions and limitations
        @Override  
                return true;  
    public static long murmur64(long h) {
}
                h2 = h2 * 5 + 0x38495ab5;
import java.util.Objects;  
        h1 += h2;  
                k1 ^= (key[offset] & 0xFFL);
                k1 ^= (key[offset + 7] & 0xFFL) << 56;  
 * Unless required by applicable law or agreed to in writing,
            case 7:
        h2 = fmix(h2);
                k1 ^= (key[offset + 4] & 0xFFL) << 32;  
                k2 ^= (key[offset + 9] & 0xFFL) << 8;  
        /** higher 64 bits part **/  
        }
        h *= 0xff51afd7ed558ccdL;
        int blockOffset = offset + i_8;
    /**
     *  
 * The OpenSearch Contributors require contributions made to  
        @Override  
 * under the License.  
        public long h1;
    /**  
 * ownership. Elasticsearch licenses this file to you under  
        h ^= h >>> 33;
                k1 = Long.rotateLeft(k1, 31);
 * You may obtain a copy of the License at  
/*  
     * This is useful if the input is already in long (or smaller) format and you don't
                k2 ^= (key[offset + 13] & 0xFFL) << 40;
            case 8:
     * A 64-bit variant which accepts a long to hash, and returns the 64bit long hash.  
            case 15:
        k *= 0xff51afd7ed558ccdL;
        h ^= h >>> 33;
            case 13:
        }
        return ByteUtils.readLongLE(key, blockOffset);  
                k2 = Long.rotateLeft(k2, 33);
        h2 += h1;
                k2 *= C2;
public enum MurmurHash3 {
                k1 ^= (key[offset + 6] & 0xFFL) << 48;
        return hash;
     *
/**
    private static long C1 = 0x87c37b91114253d5L;  
        h1 = fmix(h1);  
        h2 += h1;
                k1 *= C2;
        h1 += h2;  
                h1 = h1 * 5 + 0x52dce729;
            final int len16 = length & 0xFFFFFFF0; // higher multiple of 16 that is lower than or equal to length
     * @opensearch.internal
                k1 ^= (key[offset + 3] & 0xFFL) << 24;
            }
                k1 *= C2;  
     */
        hash.h1 = h1;  
                h2 ^= k2;  
                k1 = Long.rotateLeft(k1, 31);
    /**
 */  
        k *= 0xc4ceb9fe1a85ec53L;
                k1 *= C1;  
            case 12:
            case 9:
 * @opensearch.internal
 * the Apache License, Version 2.0 (the "License"); you may
            }
 * KIND, either express or implied.  See the License for the
        k ^= k >>> 33;
        long h2 = seed;  
     * <p>
                k2 ^= (key[offset + 14] & 0xFFL) << 48;
 * GitHub history for details.
            case 6:  
        h2 ^= length;
 * license agreements. See the NOTICE file distributed with
        h *= 0xc4ceb9fe1a85ec53L;  
 */  
            }  
            case 5:
                h1 ^= k1;
    protected static long fmix(long k) {  
                h2 ^= k2;
                k2 = Long.rotateLeft(k2, 33);
