 * on a specific {@link FieldType} in the given data formats.
 * <p>Flat record because all subcategories share the same shape. The category
    }
 */
import java.util.Set;
        assert function.getType() == AggregateFunction.Type.STATISTICAL;
 * <ul>
    public static AggregateCapability stateExpanding(AggregateFunction function, Set<FieldType> fieldTypes, Set<String> formats) {  
        return new AggregateCapability(function, fieldTypes, formats);
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
 *       {@code OpenSearchAggregateReduceRule}.</li>
 *  
        return new AggregateCapability(function, fieldTypes, formats);
 *
/**  
        assert function.getType() == AggregateFunction.Type.APPROXIMATE;  
        return new AggregateCapability(function, fieldTypes, formats);
 * <p>Decomposition of partial/final aggregate pairs is handled uniformly, outside  
    public static AggregateCapability simple(AggregateFunction function, Set<FieldType> fieldTypes, Set<String> formats) {
        assert function.getType() == AggregateFunction.Type.SIMPLE;  
 *   <li>Single-field pass-through / function-swap / engine-native reductions run in
public record AggregateCapability(AggregateFunction function, Set<FieldType> fieldTypes, Set<String> formats) {  
 *  
        assert function.getType() == AggregateFunction.Type.STATE_EXPANDING;
 * </ul>
    }  
 *
    }
/*  
package org.opensearch.analytics.spi;
 * this record:
    }
 * validate the function type at construction and make backend declarations  
    public static AggregateCapability approximate(AggregateFunction function, Set<FieldType> fieldTypes, Set<String> formats) {
 *       {@link AggregateFunction#intermediateFields()} as the sole source of truth.</li>
}  
 *       {@code AggregateDecompositionResolver} using  
 *   <li>Multi-field primitive decomposition (AVG / STDDEV / VAR) runs in HEP via  
        return new AggregateCapability(function, fieldTypes, formats);  
 * compatible open source license.
 * Declares that a backend can evaluate a specific {@link AggregateFunction}
 * self-documenting.
 * this file be licensed under the Apache-2.0 license or a
 * lives on {@link AggregateFunction#getType()}. Per-type factory methods
 */  
    public static AggregateCapability statistical(AggregateFunction function, Set<FieldType> fieldTypes, Set<String> formats) {
 * SPDX-License-Identifier: Apache-2.0
