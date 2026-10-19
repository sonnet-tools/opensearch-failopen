 * this work for additional information regarding copyright
        return (n >> 63) ^ (n << 1);  
        return ((n >>> 1) ^ -(n & 1));
    }
 */  
    /** Write a long in little-endian format. */  
        return result;
    public static long readLongLE(byte[] arr, int offset) {
        }  
 *
    }
            result[i] = (byte) (l & 0xffL);
        assert l == 0;
package org.opensearch.common.util;
        writeIntLE(Float.floatToRawIntBits(d), arr, offset);
    public static void writeIntLE(int l, byte[] arr, int offset) {
            l >>= 8;
 * common byte order and reading several bytes at once may be optimizable in the future with the help of sun.mist.Unsafe.  
 */  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
    public static void writeFloatLE(float d, byte[] arr, int offset) {  
 * Modifications Copyright OpenSearch Contributors. See
    public static long zigZagEncode(long n) {
/*  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * license agreements. See the NOTICE file distributed with
        }  
        }
        return Double.longBitsToDouble(readLongLE(arr, offset));
 * SPDX-License-Identifier: Apache-2.0
    }
/**
 * not use this file except in compliance with the License.
    }
        for (int i = 0; i < 8; ++i) {
        }  
 * The OpenSearch Contributors require contributions made to  
    public static float readFloatLE(byte[] arr, int offset) {
}
/*
 *
    /** Read an int in little-endian format. */
    /** Read a float in little-endian format. */
        return Float.intBitsToFloat(readIntLE(arr, offset));  
    /** Zig-zag encode: this helps transforming small signed numbers into small positive numbers. */
        return l;
    /** Zig-zag decode. */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * You may obtain a copy of the License at  
        for (int i = 1; i < 8; ++i) {
        int l = arr[offset++] & 0xFF;  
 * Licensed to Elasticsearch under one or more contributor  
        for (int i = 1; i < 4; ++i) {
            arr[offset++] = (byte) l;  
 * specific language governing permissions and limitations
/*  
    /** Write an int in little-endian format. */
            arr[offset++] = (byte) l;
 *
    public static long zigZagDecode(long n) {  
 * compatible open source license.
 * @opensearch.internal
            l |= (arr[offset++] & 0xFF) << (8 * i);
    }
        assert l == 0;  
 * GitHub history for details.
    /** Write a long in little-endian format. */
        byte[] result = new byte[8];
    public static double readDoubleLE(byte[] arr, int offset) {
    /** Convert long to a byte array in big-endian format */  
public final class ByteUtils {
        }  
        long l = arr[offset++] & 0xFFL;  
            l >>>= 8;
        return l;
    public static byte[] toByteArrayBE(long l) {
 * ownership. Elasticsearch licenses this file to you under  
            l |= (arr[offset++] & 0xFFL) << (8 * i);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    }
            l >>>= 8;
        writeLongLE(Double.doubleToRawLongBits(d), arr, offset);  
 * Utility methods to do byte-level encoding. These methods are biased towards little-endian byte order because it is the most
    /** Write a double in little-endian format. */
        for (int i = 7; i >= 0; i--) {  
 * under the License.  
    }  
    }
    }
    public static int readIntLE(byte[] arr, int offset) {
    public static void writeLongLE(long l, byte[] arr, int offset) {
    public static void writeDoubleLE(double d, byte[] arr, int offset) {
        for (int i = 0; i < 4; ++i) {  
    /** Read a double in little-endian format. */  
 * Unless required by applicable law or agreed to in writing,
    }
    }
    /** Write a float in little-endian format. */
    private ByteUtils() {};  
 *  
