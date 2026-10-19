        return new ExchangeInfo(RelDistribution.Type.SINGLETON, List.of(), 0);
    /** Convenience factory for SINGLETON exchanges. */
 * Describes how a child stage delivers data to its parent stage.
/*  
 *
 */  
 * @param partitionCount      number of output partitions for HASH_DISTRIBUTED exchanges
 * @param distributionType    distribution type from the exchange operator's trait  
/**
    /** Convenience factory for HASH_DISTRIBUTED exchanges. */
 * compatible open source license.
 *
import java.util.List;  
 *                            (zero for SINGLETON — gather has exactly one partition by definition)  
        return new ExchangeInfo(RelDistribution.Type.HASH_DISTRIBUTED, partitionKeyIndices, partitionCount);  
    public static ExchangeInfo singleton() {  
    public static ExchangeInfo hashDistributed(List<Integer> partitionKeyIndices, int partitionCount) {
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
public record ExchangeInfo(RelDistribution.Type distributionType, List<Integer> partitionKeyIndices, int partitionCount) {  
 * The OpenSearch Contributors require contributions made to  
    }
 * @param partitionKeyIndices field indices for hash/range partitioning (empty for SINGLETON)
 * this file be licensed under the Apache-2.0 license or a
}
    }
import org.apache.calcite.rel.RelDistribution;
 */
 * Exchange metadata extracted from exchange RelNodes during DAG construction.  
package org.opensearch.analytics.planner.dag;
