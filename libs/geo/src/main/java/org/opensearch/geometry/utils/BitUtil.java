        0x0000FFFF0000FFFFL,  
 * The OpenSearch Contributors require contributions made to  
        long v1 = 0x00000000FFFFFFFFL & even;  
 *  
 */
    /**
        long v2 = 0x00000000FFFFFFFFL & odd;
    public static final long flipFlop(final long b) {
 * You may obtain a copy of the License at  
    }
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * under the License.  
        b = (b ^ (b >>> SHIFT[3])) & MAGIC[4];  
        b &= MAGIC[0];
 * license agreements. See the NOTICE file distributed with
    public static long deinterleave(long b) {
package org.opensearch.geometry.utils;
        v1 = (v1 | (v1 << SHIFT[4])) & MAGIC[4];
 * Licensed to Elasticsearch under one or more contributor  
        b = (b ^ (b >>> SHIFT[0])) & MAGIC[1];  
        v2 = (v2 | (v2 << SHIFT[1])) & MAGIC[1];
 * the Apache License, Version 2.0 (the "License"); you may
        return ((b & MAGIC[6]) >>> 1) | ((b & MAGIC[0]) << 1);  
        return b;
        v2 = (v2 | (v2 << SHIFT[0])) & MAGIC[0];
 */
        0x0F0F0F0F0F0F0F0FL,
        v2 = (v2 | (v2 << SHIFT[4])) & MAGIC[4];
     */  
 * Utilities for common Bit twiddling methods. Borrowed heavily from Lucene (org.apache.lucene.util.BitUtil).
 * Modifications Copyright OpenSearch Contributors. See  
        0x00FF00FF00FF00FFL,
 * not use this file except in compliance with the License.
     */
    }  
 */
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    // shift values for bit interleaving  
 */  
        b = (b ^ (b >>> SHIFT[2])) & MAGIC[3];
        0x3333333333333333L,  
}
 * SPDX-License-Identifier: Apache-2.0
        0x00000000FFFFFFFFL,
    /**  
 *
        v1 = (v1 | (v1 << SHIFT[2])) & MAGIC[2];
     * Adapted from: <a href="http://graphics.stanford.edu/~seander/bithacks.html#InterleaveBMN">bithacks.html#InterleaveBMN</a>  
        0x5555555555555555L,
     */
        v1 = (v1 | (v1 << SHIFT[3])) & MAGIC[3];  
        return (v2 << 1) | v1;
    private static final short SHIFT[] = { 1, 2, 4, 8, 16 };
     * Extract just the even-bits value as a long from the bit-interleaved value
        v2 = (v2 | (v2 << SHIFT[3])) & MAGIC[3];
        v2 = (v2 | (v2 << SHIFT[2])) & MAGIC[2];  
        b = (b ^ (b >>> SHIFT[4])) & MAGIC[5];
     * flip flops odd with even bits  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
public class BitUtil {  // magic numbers for bit interleaving  
    public static long interleave(int even, int odd) {
/*  
        0xAAAAAAAAAAAAAAAAL };
    }
    private static final long MAGIC[] = {
        b = (b ^ (b >>> SHIFT[1])) & MAGIC[2];
        v1 = (v1 | (v1 << SHIFT[1])) & MAGIC[1];
 * this work for additional information regarding copyright
        v1 = (v1 | (v1 << SHIFT[0])) & MAGIC[0];  
     * Interleaves the first 32 bits of each long value
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
     * <p>
/**  
/*
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * specific language governing permissions and limitations
