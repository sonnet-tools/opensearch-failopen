            assertEquals("poisonPermits mismatch", original.poisonPermits, deserialized.poisonPermits);
        );  
        return randomLongBetween(0, Long.MAX_VALUE / 2);
    public void testRoundTripPreservesAllFields() throws IOException {
    private long nonNegLong() {
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
            // Deserialize
}
            PartitionGateStats original = randomPartitionGateStats();
            0,
 * <p><b>Validates: Requirements 10.3</b> — PartitionGateStats survives StreamOutput/StreamInput round-trip.
 * <p>Verifies that for any valid combination of the 4 long fields, serializing via
    }  
 *  
            maxPermits,  
            assertEquals("maxPermits mismatch", original.maxPermits, deserialized.maxPermits);
            nonNegLong(),  
            assertEquals("targetMaxPermits mismatch", original.targetMaxPermits, deserialized.targetMaxPermits);  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
            nonNegLong()
 */  
            PartitionGateStats deserialized = new PartitionGateStats(in);  
 */  
            assertEquals("totalWaitDurationMs mismatch", original.totalWaitDurationMs, deserialized.totalWaitDurationMs);  
            nonNegLong(),
            BytesStreamOutput out = new BytesStreamOutput();
    }
        }  
            assertEquals("hashCode must be consistent after round trip", original.hashCode(), deserialized.hashCode());
            name,  
        long maxPermits = nonNegLong();
 * Randomized tests for {@link PartitionGateStats} serialization round trip.
import org.opensearch.common.io.stream.BytesStreamOutput;
            assertEquals("totalBatchesStarted mismatch", original.totalBatchesStarted, deserialized.totalBatchesStarted);
 *
import org.opensearch.test.OpenSearchTestCase;  
            maxPermits,
    private PartitionGateStats randomPartitionGateStats() {
    private static final int TRIES = 200;  
            original.writeTo(out);
public class PartitionGateStatsPropertyTests extends OpenSearchTestCase {
 *
            assertEquals("pendingAcquireBatches mismatch", original.pendingAcquireBatches, deserialized.pendingAcquireBatches);
            // Verify equality
            // Verify individual fields  
            assertEquals("pendingAcquirePermits mismatch", original.pendingAcquirePermits, deserialized.pendingAcquirePermits);
            nonNegLong(),
 * {@code writeTo(StreamOutput)} and deserializing via {@code new PartitionGateStats(StreamInput)}
import org.opensearch.core.common.io.stream.StreamInput;
 * produces an equal object.  
/*  
        for (int i = 0; i < TRIES; i++) {  
    }
    // ---- Property: StreamOutput/StreamInput round trip produces equal object ----  
            assertEquals("activePermits mismatch", original.activePermits, deserialized.activePermits);
            nonNegLong(),
import java.io.IOException;
            // Serialize  
            assertEquals("StreamOutput/StreamInput round trip must preserve all fields", original, deserialized);  
    // ---- Generators ----
package org.opensearch.be.datafusion.stats;
        String name = "fragment_executor_gate";  
/**
            StreamInput in = out.bytes().streamInput();
        return new PartitionGateStats(
