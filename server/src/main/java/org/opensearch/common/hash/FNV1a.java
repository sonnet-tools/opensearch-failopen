    private static final long FNV_PRIME_32 = 0x01000193L;  
 * SPDX-License-Identifier: Apache-2.0
    // FNV-1a hash computation for 32-bit hash
 * Provides hashing function using FNV1a hash function. @see <a href="http://www.isthe.com/chongo/tech/comp/fnv/#FNV-1">FNV author's website</a>.
        for (byte b : bytes) {
 * this file be licensed under the Apache-2.0 license or a
        long hash = FNV_OFFSET_BASIS_64;  
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
    public static long hash32(String input) {  
        long hash = FNV_OFFSET_BASIS_32;
package org.opensearch.common.hash;
 * @opensearch.internal
 * 64 bit Java port of http://www.isthe.com/chongo/src/fnv/hash_64a.c  
 */  
            hash ^= (b & 0xFF);  
    private static final long FNV_PRIME_64 = 0x100000001b3L;  
    private static final long FNV_OFFSET_BASIS_64 = 0xcbf29ce484222325L;
public class FNV1a {
        return hash;
        }
import java.nio.charset.StandardCharsets;
        return hash;  
/**  
    }
            hash *= FNV_PRIME_32;
            hash *= FNV_PRIME_64;
 */  
        }  
    }
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
 *
    // FNV-1a hash computation for 64-bit hash
 * compatible open source license.
 *
    private static final long FNV_OFFSET_BASIS_32 = 0x811c9dc5L;
 * 32 bit Java port of http://www.isthe.com/chongo/src/fnv/hash_32a.c
}
        for (byte b : bytes) {  
/*  
    public static long hash64(String input) {
 * The OpenSearch Contributors require contributions made to  
            hash ^= (b & 0xFF);
