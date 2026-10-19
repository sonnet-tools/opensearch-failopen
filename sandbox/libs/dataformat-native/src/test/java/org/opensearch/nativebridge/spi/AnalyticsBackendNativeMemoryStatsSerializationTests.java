            { Long.MIN_VALUE, 0L } };  
/*  
    public void testSerializationRoundTrip() throws IOException {
            }
            try (BytesStreamOutput out = new BytesStreamOutput()) {
     * Serialization round-trip with error state values (-1).
            }
                try (StreamInput in = out.bytes().streamInput()) {
                    );
    /**  
                }
     * round-trip correctly.  
        for (int i = 0; i < 100; i++) {  
 */  
public class AnalyticsBackendNativeMemoryStatsSerializationTests extends OpenSearchTestCase {  
            AnalyticsBackendNativeMemoryStats original = new AnalyticsBackendNativeMemoryStats(allocatedBytes, residentBytes, purgeCount);
                        deserialized.getAllocatedBytes()  
            long allocatedBytes = randomLongBetween(Long.MIN_VALUE, Long.MAX_VALUE);
     *
}
     * Property 1: Serialization round-trip.  
                original.writeTo(out);  
        }  
            try (StreamInput in = out.bytes().streamInput()) {
 * The OpenSearch Contributors require contributions made to  
     * round-trip correctly.
                    assertEquals("residentBytes mismatch", original.getResidentBytes(), deserialized.getResidentBytes());
 * Uses randomized testing to verify that serialization via {@code writeTo} followed by
                original.writeTo(out);
package org.opensearch.nativebridge.spi;
 * this file be licensed under the Apache-2.0 license or a
 *
                assertEquals(-1L, deserialized.getResidentBytes());
            long residentBytes = randomLongBetween(Long.MIN_VALUE, Long.MAX_VALUE);
                    AnalyticsBackendNativeMemoryStats deserialized = new AnalyticsBackendNativeMemoryStats(in);
    public void testSerializationRoundTripWithErrorState() throws IOException {
                    assertEquals("allocatedBytes mismatch", original.getAllocatedBytes(), deserialized.getAllocatedBytes());
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;  
            long purgeCount = randomLongBetween(0, Long.MAX_VALUE);  
            { Long.MIN_VALUE, Long.MAX_VALUE },  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                        original.getAllocatedBytes(),
        }  
     */
                        "allocatedBytes mismatch on iteration " + i,
     *
     * Verifies that extreme long values (MIN_VALUE, MAX_VALUE, 0) survive serialization
    public void testSerializationRoundTripWithBoundaryValues() throws IOException {
     * Validates: Requirements 2.3, 2.4, 2.5  
/**
     *
 * Property-based tests for {@link AnalyticsBackendNativeMemoryStats} serialization round-trip.  
 * compatible open source license.
                    assertEquals("purgeCount should be 0", 0L, deserialized.getPurgeCount());  
        }
            original.writeTo(out);  
     * Validates: Requirements 2.3, 2.4, 2.5  
     */  
        long[][] boundaryPairs = {
        for (long[] pair : boundaryPairs) {
            { Long.MAX_VALUE, Long.MAX_VALUE },
                try (StreamInput in = out.bytes().streamInput()) {  
 *
     * Serialization round-trip with boundary values.  
 */
                    assertEquals(  
import org.opensearch.test.OpenSearchTestCase;
    /**
            }
    /**
            { 0L, 0L },
            { Long.MAX_VALUE, Long.MIN_VALUE },
                    assertEquals("purgeCount mismatch on iteration " + i, purgeCount, deserialized.getPurgeCount());  
            { Long.MIN_VALUE, Long.MIN_VALUE },  
        AnalyticsBackendNativeMemoryStats original = new AnalyticsBackendNativeMemoryStats(-1, -1, 0);  
     */
     *
     * Validates: Requirements 2.3, 2.4, 2.5
                    assertEquals("residentBytes mismatch on iteration " + i, original.getResidentBytes(), deserialized.getResidentBytes());
    }
 * SPDX-License-Identifier: Apache-2.0
     * Verifies that the error sentinel value (-1) for both fields survives serialization  
            { 0L, Long.MAX_VALUE },
    }
     * For any valid AnalyticsBackendNativeMemoryStats object (with any long values for allocatedBytes and
 * field values for all valid long inputs.
     *
import org.opensearch.common.io.stream.BytesStreamOutput;
            try (BytesStreamOutput out = new BytesStreamOutput()) {
import org.opensearch.core.common.io.stream.StreamInput;
            AnalyticsBackendNativeMemoryStats original = new AnalyticsBackendNativeMemoryStats(pair[0], pair[1], 0);  
     * SHALL produce an object with identical field values.
                }
import java.io.IOException;  
                assertEquals(-1L, deserialized.getAllocatedBytes());
     *
                    AnalyticsBackendNativeMemoryStats deserialized = new AnalyticsBackendNativeMemoryStats(in);
    }  
                assertEquals(0L, deserialized.getPurgeCount());  
 * deserialization via the {@code StreamInput} constructor produces an object with identical  
     * residentBytes), serializing via writeTo then deserializing via the StreamInput constructor  
                AnalyticsBackendNativeMemoryStats deserialized = new AnalyticsBackendNativeMemoryStats(in);
