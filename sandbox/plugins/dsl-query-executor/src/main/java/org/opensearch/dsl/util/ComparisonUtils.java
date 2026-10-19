     * Compares two values for equality, coercing numeric types (the engine may box the same
 */  
    private ComparisonUtils() {}
/*  
            }
    }
/**  
 *
 */
    }  
    private static boolean isIntegral(Number n) {
 * compatible open source license.
     * loss; floating-point pairs via {@link Double#compare}. No cross-type string coercion —
package org.opensearch.dsl.util;
public final class ComparisonUtils {  
 * this file be licensed under the Apache-2.0 license or a
     */  
        if (a instanceof Number na && b instanceof Number nb) {
        if (Objects.equals(a, b)) return true;
     * bucket keys are typed by the schema.
            return Double.compare(na.doubleValue(), nb.doubleValue()) == 0;
 * Utility methods for comparing values.
 * The OpenSearch Contributors require contributions made to  
}
    /**
 * SPDX-License-Identifier: Apache-2.0
        return false;
     * column differently across plans). Integral pairs compare as long to avoid precision  
        }  
import java.util.Objects;
    public static boolean valuesEqual(Object a, Object b) {
            if (isIntegral(na) && isIntegral(nb)) {
        return n instanceof Long || n instanceof Integer || n instanceof Short || n instanceof Byte;  
                return na.longValue() == nb.longValue();  
