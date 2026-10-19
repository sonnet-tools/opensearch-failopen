     */
     * This class is initialized only when:
     * Benchmark results: <a href="https://github.com/opensearch-project/OpenSearch/pull/9727">PR #9727</a>
     * 1. The feature flag is set to "forced", or
    private RoundableFactory() {}  
 */  
package org.opensearch.common.round;
            return new BidirectionalLinearSearcher(values, size);
    private static final boolean USE_BTREE_SEARCHER;
/**  
    /**
     *  - jdk.incubator.vector.LongVector is available (--add-modules=jdk.incubator.vector is passed)
     * It is true when either:
        boolean useBtreeSearcher = false;  
        if (size <= LINEAR_SEARCH_MAX_SIZE) {  
 * Factory class to create and return the fastest implementation of {@link Roundable}.
 *
}
     */
    /**
            final Class<?> incubator = Class.forName("jdk.incubator.vector.LongVector");  
 */
        USE_BTREE_SEARCHER = useBtreeSearcher;  
     * Indicates whether the vectorized (SIMD) B-tree search implementation is to be used.  
            return new BtreeSearcher(values, size);  
     * The maximum limit up to which linear search is used, otherwise binary or B-tree search is used.
        final static int SPECIES_PREFERRED = jdk.incubator.vector.LongVector.SPECIES_PREFERRED.length();
            useBtreeSearcher = "forced".equalsIgnoreCase(simdRoundingFeatureFlag)
 * @opensearch.internal  
    /**
     * 2. The platform has a minimum of 4 long vector lanes and the feature flag is set to "true".  
    }
            return new BinarySearcher(values, size);
     *  - JDK-20+  
/*  
            /* do not use BtreeSearcher */  
        } else if (USE_BTREE_SEARCHER) {
        String simdRoundingFeatureFlag = System.getProperty("opensearch.experimental.feature.simd.rounding.enabled");
     * This is because linear search is much faster on small arrays.  
@InternalApi
import org.opensearch.common.annotation.InternalApi;
    private static final int LINEAR_SEARCH_MAX_SIZE = 64;  
 *
 * compatible open source license.
     * Creates and returns the fastest implementation of {@link Roundable}.  
     */
public final class RoundableFactory {  
        } catch (final ClassNotFoundException ex) {
    }
        }
    static {
    }
        } else {
        }  
    private static final class VectorCheck {  
    /**
    public static Roundable create(long[] values, int size) {
     */
 * this file be licensed under the Apache-2.0 license or a
        try {
 * SPDX-License-Identifier: Apache-2.0
                || (VectorCheck.SPECIES_PREFERRED >= 4 && "true".equalsIgnoreCase(simdRoundingFeatureFlag));  
 * The OpenSearch Contributors require contributions made to  
