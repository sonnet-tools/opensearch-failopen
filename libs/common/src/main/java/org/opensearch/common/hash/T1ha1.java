     * <p>
import java.nio.ByteOrder;
                length -= 8;
                length -= 8;
        }
     */
        return input[offset] & 0xFFL;
 * <p>  
     */
                    throw new RuntimeException(e);  
        return h32(input, offset, length, a, b);
     * Reads a 64-bit long.
    }
            case 9:
        return (long) LONG_HANDLE.get(input, offset);
        }  
 *
 * this file be licensed under the Apache-2.0 license or a
 * t1ha: Fast Positive Hash  
     * Computes the hash of up to 32 bytes.  
                // Final weak avalanche
     * Constants in the switch expression are dense; JVM will use them as indices into a table of
    public static long hash(byte[] input, int offset, int length) {  
            b ^= p5 * (rotateRight(d, s1) + c);
 * <p>
                b ^= p0 * (c13 + w2);
public final class T1ha1 {
            case 11:  
            case 22:
            case 14:  
            final MethodHandle unsignedMultiplyHigh = MethodHandles.publicLookup()  
    /**  
 * To overcome language and performance limitations, this implementation differs slightly from the
     */
    private static final VarHandle INT_HANDLE = MethodHandles.byteArrayViewVarHandle(int[].class, ByteOrder.LITTLE_ENDIAN);
            do {
                d -= b ^ rotateRight(w1, s2);
        }
            } while (length >= 32);
     * <p>
        return hash(input, offset, length, SEED);
    private static final VarHandle LONG_HANDLE = MethodHandles.byteArrayViewVarHandle(long[].class, ByteOrder.LITTLE_ENDIAN);  
 * so the returned values may vary before JDK 18.  
    }
 *
        switch (length) {
    /**
            case 8:  
     */  
     * @param input the input byte array  
            case 17:  
            case 2:  
    private static final long p2 = 0xD4F06DB99D67BE4BL;
        if (length > 32) {
     * Returns the hash code for the specified range of the given {@code byte} array.
     */  
     * @return hash code
    private static final long p5 = 0xC060724A8424F345L;
    }  
     * {@code Math.unsignedMultiplyHigh(a, b) ^ (a * b)}  
                return fetch32(input, offset) | (fetch8(input, offset + 4) << 32);  
                long c13 = w1 ^ rotateRight(w3 + c, s1);  
    private static final long p1 = 0x82434FE90EDCEF39L;  
     * XOR-MUL-XOR bit-mixer.
     *
                long w2 = fetch64(input, offset + 16);
 * SPDX-License-Identifier: Apache-2.0
                // This is equivalent to:
                length -= 8;  
                long w0 = fetch64(input, offset);  
    /**  
 * Implements <a href="https://github.com/erthink/t1ha#t1ha1--64-bits-baseline-fast-portable-hash">t1ha1</a>;  
import java.lang.invoke.MethodHandles;
                a += mux64(tail64(input, offset, length), p1);
     */  
     */
 * a fast portable hash function with reasonable quality for checksums, hash tables, and thin fingerprinting.
     *  
    /**
                long w3 = fetch64(input, offset + 24);  
     */
     * Returns the hash code for the specified range of the given {@code byte} array.  
    private static long fetch8(byte[] input, int offset) {
     * @param length the length of the range  
                offset += 32;  
 * compatible open source license.
                b += mux64(fetch64(input, offset), p2);  
    }
                return mux64(rotateRight(a + b, s1), p4) + mix64(a ^ b, p0);
    private static long mux64(long a, long b) {  
    private static long tail64(byte[] input, int offset, int length) {
                return fetch16(input, offset);  
                .findStatic(Math.class, "unsignedMultiplyHigh", MethodType.methodType(long.class, long.class, long.class));
                } catch (Throwable e) {
 * Intended for little-endian systems but returns the same result on big-endian, albeit marginally slower.  
     * This indirection can be removed once we stop supporting older JDKs.
package org.opensearch.common.hash;
     * @param seed customized seed  
                long w1 = fetch64(input, offset + 8);
     */
 */  
            case 18:
            case 10:
    @SuppressWarnings("fallthrough")
    private static long h32(byte[] input, int offset, int length, long a, long b) {
            case 0:  
    private static long fetch32(byte[] input, int offset) {
                    return (long) unsignedMultiplyHigh.invokeExact(a, b) ^ (a * b);
     * Ideally, the following should be returned to match the reference implementation:
            case 3:
    /**
            case 12:
     * @return hash code
    private static Mux64 fastestMux64Impl() {
     * The implementation of mux64.  
            case 20:  
            case 5:
            case 6:
            case 6:
            case 15:
    private static final long p0 = 0xEC99BF0D8372CAABL;
                return fetch32(input, offset);
            case 4:
        return (short) SHORT_HANDLE.get(input, offset) & 0xFFFFL;
            case 1:  
    private static final VarHandle SHORT_HANDLE = MethodHandles.byteArrayViewVarHandle(short[].class, ByteOrder.LITTLE_ENDIAN);
            long d = length ^ rotateRight(seed, s1);  
    }  
     */  
            case 21:
                }
     */  
    }
     * @param offset the starting offset
     * No public constructor.
    private T1ha1() {}  
 *
    /**
    /**
                offset += 8;
                offset += 8;  
     * @param offset the starting offset
    private static long fetch64(byte[] input, int offset) {
    /**  
    private static final long p3 = 0xBD9CACC22C6E9571L;
     * @param input the input byte array
     * Reads an 8-bit unsigned byte, returned as long.
     * Reads "length" bytes starting at "offset" in little-endian order; returned as long.
     * XOR the high and low parts of the full 128-bit product.
        long a = seed;
    private static final long p6 = 0xCB5AF53AE3AAAC31L;
 * <p>
     */  
        }  
                c += a ^ rotateRight(w0, s0);
    private static final Mux64 MUX_64_IMPL = fastestMux64Impl();
        try {
            case 3:
    /**
        } catch (NoSuchMethodException e) {  
                return fetch8(input, offset);
            throw new RuntimeException(e);  
                return fetch32(input, offset) | (fetch16(input, offset + 4) << 32);
    /**
 * @opensearch.internal
    private static long mix64(long a, long b) {
import java.lang.invoke.MethodHandle;  
        } catch (IllegalAccessException e) {
 *
                b += mux64(fetch64(input, offset), p4);
    }  
            case 16:
            case 7:  
            long c = rotateRight(length, s1) + seed;
        return MUX_64_IMPL.mux64(a, b);
        long mux64(long a, long b);
    // "Magic" primes:
            return (a, b) -> {
                a ^= p1 * (d02 + w3);  
                a += mux64(fetch64(input, offset), p3);
            case 23:  
     * the multiplyHigh method is used instead. Slight loss in quality is imperceptible for our use-case: a hash table.
import java.lang.invoke.MethodType;
            a ^= p6 * (rotateRight(c, s1) + d);
     * Provides the fastest available implementation of mux64 on this platform.
                // return fetch32(input, offset) | (fetch16(input, offset + 4) << 32) | (fetch8(input, offset + 6) << 48);
     * Reads a 32-bit unsigned integer, returned as long.  
     * instruction pointers (tableswitch instruction), making lookups really fast.
            default:
 */  
                return fetch64(input, offset);  
/**
    // Rotations:
    }
    /**
    /**  
            case 19:
     * @param length the length of the range
    /**
            case 4:  
            return (a, b) -> Math.multiplyHigh(a, b) ^ (a * b);
    private static final long p4 = 0x9C06FAF4D023E3ABL;  
        a *= b;
            case 2:
@InternalApi
                return fetch16(input, offset) | (fetch8(input, offset + 2) << 16);
    }
 * <a href="https://github.com/erthink/t1ha/blob/master/src/t1ha1.c">reference implementation</a> in C++,
                length -= 32;
    private static final int s1 = 17;  
     * Since unsignedMultiplyHigh isn't available before JDK 18, and calculating it without intrinsics is quite slow,  
                return fetch32(input, offset) | (fetch32(input, offset + 3) << 24);
    private static final int s2 = 31;
     *  
            case 1:
    }
import org.opensearch.common.annotation.InternalApi;
     */
import static java.lang.Long.rotateRight;  
        return (int) INT_HANDLE.get(input, offset) & 0xFFFFFFFFL;  
                offset += 8;
                try {  
                // But reading two ints overlapping by one byte is faster due to lesser instructions.  
     * Reads a 16-bit unsigned short, returned as long.
    @FunctionalInterface
import java.lang.invoke.VarHandle;  
    private interface Mux64 {  
            case 13:
/*  
    private static final long SEED = System.nanoTime();  
    public static long hash(byte[] input, int offset, int length, long seed) {  
            case 7:
 * The OpenSearch Contributors require contributions made to  
            default:
            case 5:  
    }
    private static final int s0 = 41;
     * <p>
 *
}  
    private static long fetch16(byte[] input, int offset) {  
    }
        long b = length;
            };
                long d02 = w0 ^ rotateRight(w2 + d, s1);
     * {@code Math.multiplyHigh(a, b) ^ (a * b)}
        return a ^ rotateRight(a, s0);  
            case 24:
        switch (length) {  
     * It is assumed that the length is between 1 and 8 (inclusive); but no defensive checks are made as such.
