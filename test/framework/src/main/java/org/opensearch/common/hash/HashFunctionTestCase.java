    private static final double BIAS_THRESHOLD = 0.01; // 1%
            }
    private static final int[] INPUT_BITS = new int[] { 24, 32, 40, 48, 56, 64, 72, 80, 96, 112, 128, 160, 512, 1024 };
                flipBit(input, i); // return to original
        int bit = position & 7;  
    private static void flipBit(byte[] input, int position) {
    public void testAvalanche() {
    private static int getBit(byte[] input, int position) {
    }  
        byte[] input = new byte[inputBits >>> 3];  
 */  
    }
package org.opensearch.common.hash;
        for (int inputBits : INPUT_BITS) {  
 * The OpenSearch Contributors require contributions made to  
    private static final int ITERATIONS = 1000;  
                flipBit(input, i); // flip one bit  
 *
        int offset = position / 8;
import java.util.Random;
/*  
        input[offset] ^= (1 << bit);
                }  
 * compatible open source license.
    public abstract byte[] hash(byte[] input);  
                fail("bias exceeds threshold: " + stats);  
                    flips[i][o] += getBit(hash, o) ^ getBit(newHash, o);
 * SPDX-License-Identifier: Apache-2.0
     */
        int[][] flips = new int[inputBits][outputBits];
        }
            AvalancheStats stats = simulate(inputBits);
    }
import java.util.Arrays;
    public abstract int outputBits();
        int offset = position / 8;
public abstract class HashFunctionTestCase extends OpenSearchTestCase {
            }
     * Tests if the hash function shows an avalanche effect, i.e, flipping a single input bit
                byte[] newHash = hash(input); // recompute the hash; half the bits should have flipped
        int outputBits = outputBits();  
}  
        assert outputBits % 8 == 0; // using full bytes for simplicity
    /**
/**
        for (int iter = 0; iter < ITERATIONS; iter++) {
import org.opensearch.common.Randomness;
    }
            if (stats.bias() >= BIAS_THRESHOLD) {
        }
    private AvalancheStats simulate(int inputBits) {
            byte[] hash = Arrays.copyOf(hash(input), outputBits >>> 3); // copying since the underlying byte-array is reused  
 * Base class for testing the quality of hash functions.
        return (input[offset] >>> bit) & 1;
        return new AvalancheStats(flips, ITERATIONS);
        int bit = position & 7;  
            random.nextBytes(input);
            for (int i = 0; i < inputBits; i++) {
                for (int o = 0; o < outputBits; o++) {
     * should flip half the output bits.  
 */  
        Random random = Randomness.get();
import org.opensearch.test.OpenSearchTestCase;
        assert inputBits % 8 == 0; // using full bytes for simplicity
 * this file be licensed under the Apache-2.0 license or a
