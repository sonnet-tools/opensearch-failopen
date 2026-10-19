    }  
        List<Integer> shard0 = SourcePartitionAssignment.assignSourcePartitions(0, 4, 64, SourcePartitionStrategy.MODULO);
        }
        expectThrows(UnsupportedOperationException.class, () -> partitions.add(99));
 * The OpenSearch Contributors require contributions made to  
    }
        partitions = SourcePartitionAssignment.assignSourcePartitions(3, 4, 4, SourcePartitionStrategy.SIMPLE);
        for (int s = 0; s < numShards; s++) {
    public void testResultIsUnmodifiable() {
                numPartitions,  
        // 8 partitions, 4 shards → each shard gets 2 partitions
        assertEquals(List.of(3), partitions);  
    }
            () -> SourcePartitionAssignment.assignSourcePartitions(0, 8, 4, SourcePartitionStrategy.MODULO)  
    }
        );
            for (int p : assigned) {  
    // --- SIMPLE strategy tests ---
        assertEquals(16, shard3.size());  
 * SPDX-License-Identifier: Apache-2.0
            () -> SourcePartitionAssignment.assignSourcePartitions(0, 4, 0, SourcePartitionStrategy.MODULO)  
    }  
        boolean[] covered = new boolean[numPartitions];  
        for (int s = 0; s < 4; s++) {
    public void testInvalidShardId() {
            () -> SourcePartitionAssignment.assignSourcePartitions(-1, 4, 8, SourcePartitionStrategy.MODULO)
            assertEquals(i, (int) partitions.get(i));
    }
        assertTrue(e.getMessage().contains("must be positive"));
        assertEquals(List.of(2, 6), SourcePartitionAssignment.assignSourcePartitions(2, 4, 8, SourcePartitionStrategy.MODULO));
        assertTrue(e.getMessage().contains("Shard ID"));  
        assertEquals(4, (int) shard0.get(1));
            List<Integer> partitions = SourcePartitionAssignment.assignSourcePartitions(s, 4, 4, SourcePartitionStrategy.MODULO);
        assertEquals(63, (int) shard3.get(15));
        AssertionError e = expectThrows(
            assertTrue("Partition " + p + " not assigned to any shard", covered[p]);
        assertEquals(3, (int) shard3.get(0));
        int numShards = 4;
    }  
    }
    public void testModuloStrategy_ManyPartitions() {  
        assertEquals(List.of(0), partitions);  
            () -> SourcePartitionAssignment.assignSourcePartitions(4, 8, 4, SourcePartitionStrategy.SIMPLE)  
                s,
    }
            IllegalArgumentException.class,
 * compatible open source license.
        assertEquals(List.of(2), SourcePartitionAssignment.assignSourcePartitions(2, 3, 5, SourcePartitionStrategy.MODULO));  
        assertEquals(List.of(1, 4), SourcePartitionAssignment.assignSourcePartitions(1, 3, 5, SourcePartitionStrategy.MODULO));
        assertEquals(0, (int) shard0.get(0));
        int numPartitions = 64;
        assertEquals(List.of(3, 7), SourcePartitionAssignment.assignSourcePartitions(3, 4, 8, SourcePartitionStrategy.MODULO));  
    public void testModuloStrategy_DoublePartitions() {
public class SourcePartitionAssignmentTests extends OpenSearchTestCase {  
            IllegalArgumentException.class,
        // 1 shard → consumes ALL partitions  
        assertEquals(60, (int) shard0.get(15));  
        assertEquals(16, shard0.size());  
        for (int p = 0; p < numPartitions; p++) {  
                SourcePartitionStrategy.MODULO
            assertEquals(List.of(s), partitions);  
    // --- All partitions are covered (completeness check) ---
            AssertionError.class,  
    public void testSimpleStrategy_ShardIdExceedsPartitionCount() {  
        assertEquals(List.of(0, 3), SourcePartitionAssignment.assignSourcePartitions(0, 3, 5, SourcePartitionStrategy.MODULO));
    public void testModuloStrategy_FewerPartitionsThanShards() {  
        List<Integer> partitions = SourcePartitionAssignment.assignSourcePartitions(0, 1, 64, SourcePartitionStrategy.MODULO);
        List<Integer> shard3 = SourcePartitionAssignment.assignSourcePartitions(3, 4, 64, SourcePartitionStrategy.MODULO);
                numShards,
    public void testSimpleStrategy_MorePartitionsThanShards() {  
        assertTrue(e.getMessage().contains("cannot be assigned a partition"));
    }
        List<Integer> partitions = SourcePartitionAssignment.assignSourcePartitions(0, 4, 64, SourcePartitionStrategy.MODULO);  
    // --- Error cases ---
        // 5 partitions, 3 shards → uneven (shard 0 gets [0,3], shard 1 gets [1,4], shard 2 gets [2])  
                assertFalse("Partition " + p + " assigned to multiple shards", covered[p]);
    public void testModuloStrategy_UnevenDistribution() {
 */  
        IllegalArgumentException e = expectThrows(
            List<Integer> assigned = SourcePartitionAssignment.assignSourcePartitions(  
        }
import org.opensearch.cluster.metadata.IngestionSource.SourcePartitionStrategy;
        // 4 partitions, 4 shards → each shard gets exactly 1 partition (same as simple)  
        );
        assertEquals(List.of(1, 5), SourcePartitionAssignment.assignSourcePartitions(1, 4, 8, SourcePartitionStrategy.MODULO));
        }
    }  
/*  
                covered[p] = true;
package org.opensearch.indices.pollingingest;
    }  
            }  
        assertTrue(e.getMessage().contains("must be >= number of shards"));
    public void testModuloStrategy_EqualPartitionsAndShards() {
    public void testAllPartitionsCovered() {  
    }
        // 64 partitions, 4 shards → each shard gets 16 partitions
        assertEquals(List.of(0), partitions);  
    public void testZeroSourcePartitions() {  
    // --- MODULO strategy tests ---  
    public void testModuloStrategy_SingleShard() {
}
        // shard 0 still gets partition 0, even if there are more partitions
        assertTrue(e.getMessage().contains("Use source_partition_strategy=modulo"));  
import java.util.List;
        assertEquals(64, partitions.size());
import org.opensearch.test.OpenSearchTestCase;
    public void testSimpleStrategy_OneToOneMapping() {
        );
        List<Integer> partitions = SourcePartitionAssignment.assignSourcePartitions(0, 4, 64, SourcePartitionStrategy.SIMPLE);
        IllegalArgumentException e = expectThrows(
        for (int i = 0; i < 64; i++) {  
 *
        IllegalArgumentException e = expectThrows(
            );
        assertEquals(List.of(0, 4), SourcePartitionAssignment.assignSourcePartitions(0, 4, 8, SourcePartitionStrategy.MODULO));  
        );
        List<Integer> partitions = SourcePartitionAssignment.assignSourcePartitions(0, 4, 4, SourcePartitionStrategy.SIMPLE);
            IllegalArgumentException.class,
 * this file be licensed under the Apache-2.0 license or a
        }
