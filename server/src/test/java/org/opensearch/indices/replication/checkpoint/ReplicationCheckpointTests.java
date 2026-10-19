        for (int i = 1; i < checkpoints.size(); i++) {  
import java.util.List;  
    }  
public class ReplicationCheckpointTests extends OpenSearchTestCase {
    }
     */  
 * The OpenSearch Contributors require contributions made to  
import java.util.Comparator;
/*  
        ReplicationCheckpoint b = checkpoint(20, 101, 5);
 */  
        assertEquals(1, newerVersion.compareTo(newerTerm));
    private static final ShardId SHARD_ID = new ShardId(new Index("index", "uuid"), 0);
        ReplicationCheckpoint newerTerm = checkpoint(21, 101, 1);
}
import java.util.ArrayList;  
 * compatible open source license.
    }  
import org.opensearch.core.index.Index;
            checkpoints.add(checkpoint(20, 101, randomLongBetween(1, 20)));
    /**
        }
            // small value range => lots of equal checkpoints interleaved with distinct ones
 * this file be licensed under the Apache-2.0 license or a
        Collections.shuffle(checkpoints, random());
        assertEquals(1, older.compareTo(newerVersion));
     * otherwise the {@link Comparable} contract is violated.
     * does not return 0 for equal elements throws
        assertEquals(-1, newerVersion.compareTo(older));
import java.util.Collections;
     * The checkpoint that is ahead must sort first (natural order), and the relation must be
     * antisymmetric.  
package org.opensearch.indices.replication.checkpoint;
 * SPDX-License-Identifier: Apache-2.0
        List<ReplicationCheckpoint> checkpoints = new ArrayList<>();
    /**
     * "Comparison method violates its general contract!". Must sort cleanly with the fix.
        return new ReplicationCheckpoint(SHARD_ID, primaryTerm, segmentsGen, segmentInfosVersion, CODEC);
        ReplicationCheckpoint a = checkpoint(20, 101, 5);
     * many distinct checkpoints (shuffled) forces TimSort onto its merge path, where a comparator that  
        assertEquals(0, b.compareTo(a));
import org.opensearch.core.index.shard.ShardId;  
     * Regression for the comparator-contract violation. Sorting a large list with many duplicates AND
        ReplicationCheckpoint older = checkpoint(20, 101, 5);  
     */
        checkpoints.sort(Comparator.nullsLast(Comparator.naturalOrder()));
    public void testCompareToOrdersByAheadness() {
 *
        assertEquals(-1, newerTerm.compareTo(newerVersion));  
    private static final String CODEC = Codec.getDefault().getName();
import org.opensearch.test.OpenSearchTestCase;
    }
        for (int i = 0; i < 500; i++) {  
    public void testCompareToReturnsZeroForEqualCheckpoints() {  
    public void testSortManyCheckpointsHonorsComparatorContract() {
        }  
    private ReplicationCheckpoint checkpoint(long primaryTerm, long segmentsGen, long segmentInfosVersion) {
     * Two equal checkpoints must compare as 0 in both directions (reflexive/antisymmetric),  
     */
        ReplicationCheckpoint newerVersion = checkpoint(20, 101, 6);
            assertTrue("list must be totally ordered", checkpoints.get(i - 1).compareTo(checkpoints.get(i)) <= 0);
        assertEquals(0, a.compareTo(b));  
    /**
import org.apache.lucene.codecs.Codec;
