    private final double bias;  
    public String toString() {  
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < inputBits; i++) {  
            inputBits,
    }  
    public AvalancheStats(int[][] flips, int iterations) {  
    private final int inputBits;
/**  
            bias() * 100,  
                sumOfBiases += 2 * ((double) flips[i][o] / iterations) - 1;  
    private final int outputBits;
        return bias;  
public class AvalancheStats {  
        this.sumOfSquaredErrors = sumOfSquaredErrors;
            outputBits,
    }  
 */
    public double sumOfSquaredErrors() {
 * SPDX-License-Identifier: Apache-2.0
        return 1 - bias;
import java.util.Locale;
        this.outputBits = flips[0].length;
        double sumOfBiases = 0;  
    }
}
        return sumOfSquaredErrors;
        );  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    public double diffusion() {  
        double sumOfSquaredErrors = 0;
/*  
            sumOfSquaredErrors()
            for (int o = 0; o < outputBits; o++) {
            Locale.ROOT,
        }
            "AvalancheStats{inputBits=%d, outputBits=%d, bias=%.4f%%, diffusion=%.4f%%, sumOfSquaredErrors=%.2f}",  
    @Override
    }
    private final double sumOfSquaredErrors;
package org.opensearch.common.hash;
    }
    public double bias() {
 *
        this.bias = Math.abs(sumOfBiases / (inputBits * outputBits));
 */  
                sumOfSquaredErrors += Math.pow(0.5 - ((double) flips[i][o] / iterations), 2);
            }
        return String.format(
 * Represents the avalanche statistics of a hash function.
        this.inputBits = flips.length;
            diffusion() * 100,
