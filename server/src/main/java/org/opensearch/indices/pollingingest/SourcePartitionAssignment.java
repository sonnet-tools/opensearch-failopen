            case SIMPLE:
                            + "] must be >= number of shards ["  
     */  
 * this file be licensed under the Apache-2.0 license or a
                        result.add(p);
        int shardId,
import java.util.List;
     * @param numShards           total number of shards in the index  
            throw new IllegalArgumentException("Number of source partitions must be positive, got: " + numSourcePartitions);
                throw new IllegalArgumentException("Unsupported partition strategy: " + strategy);
        if (numSourcePartitions <= 0) {
     * @throws IllegalArgumentException if numSourcePartitions is less than numShards for SIMPLE strategy,
                    }  
     * @param strategy            the partition assignment strategy
     * Computes the list of source partition IDs that a shard should consume.  
                            + numSourcePartitions
    }  
public class SourcePartitionAssignment {
import java.util.ArrayList;  
        }  
            default:
}
        // TODO - support "RANGE" below when we implement https://github.com/opensearch-project/OpenSearch/issues/21267  
                    );  
 */
import org.opensearch.cluster.metadata.IngestionSource.SourcePartitionStrategy;
    /**
        }  
 * SPDX-License-Identifier: Apache-2.0
    public static List<Integer> assignSourcePartitions(
                    throw new IllegalArgumentException(  
                if (shardId >= numSourcePartitions) {  
     *                                  or if no partitions are assigned to the shard
 * based on the configured {@link SourcePartitionStrategy}.  
                            + numShards
        int numShards,  
 * The OpenSearch Contributors require contributions made to  
        switch (strategy) {
                            + "] cannot be assigned a partition: source has only ["
    private SourcePartitionAssignment() {
     * @return unmodifiable list of partition IDs assigned to this shard  
    ) {  
                List<Integer> result = new ArrayList<>();
/**
 * compatible open source license.
                if (numSourcePartitions < numShards) {
                return List.of(shardId);
                }
 */  
                for (int p = 0; p < numSourcePartitions; p++) {  
                            + "] for modulo partition strategy"
                return Collections.unmodifiableList(result);
                        "Shard ["
     * @param shardId             the OpenSearch shard ID
                }
        SourcePartitionStrategy strategy
     *
import java.util.Collections;
        // utility class
        assert shardId >= 0 && shardId < numShards : "Shard ID [" + shardId + "] must be >= 0 and < numShards [" + numShards + "]";
        int numSourcePartitions,
            case MODULO:
                }
                            + shardId
    }
                    if (p % numShards == shardId) {
     * @param numSourcePartitions total number of partitions in the source stream
 *
                    );  
                            + shardId  
/*  
 * Computes which source stream partitions a given OpenSearch shard should consume,
                            + "]. Use source_partition_strategy=modulo to map multiple partitions per shard."
package org.opensearch.indices.pollingingest;
                    throw new IllegalArgumentException(
                        "Number of source partitions ["
                            + "] partitions but shard ID requires partition ["  
                            + numSourcePartitions
