     */
 * Creates a {@link LogicalAggregate} from pre-computed {@link AggregationMetadata}.  
}  
     * Builds a LogicalAggregate from the given metadata.  
 */
/**
package org.opensearch.dsl.converter;
 * compatible open source license.
    }
    public RelNode convert(RelNode input, AggregationMetadata metadata) {  
     *
        return LogicalAggregate.create(input, metadata.getGroupByBitSet(), null, metadata.getAggregateCalls());
import org.opensearch.dsl.aggregation.AggregationMetadata;  
import org.apache.calcite.rel.logical.LogicalAggregate;
     * @return the LogicalAggregate node
    /** Creates an aggregate converter. */
 * The metadata is produced by the tree walker and set on the context before this runs.
 *
import org.apache.calcite.rel.RelNode;
     * @param metadata pre-computed aggregation metadata for one granularity  
/*  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
     * @param input the input plan (scan + filter)
public class AggregateConverter {  
    public AggregateConverter() {}  
 * The OpenSearch Contributors require contributions made to  
    /**
