 */
    public void testSerializationRoundTripBoundaryValues() throws IOException {  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
     * Occasionally returns -1, 0, Long.MIN_VALUE, or Long.MAX_VALUE.
    @SuppressWarnings("unchecked")  
 * Property-based tests for {@link AnalyticsBackendNativeMemoryStats} serialization round-trip.
            long purgeCount = randomLongBetween(0, Long.MAX_VALUE);
                    assertEquals("residentBytes mismatch on iteration " + i, original.getResidentBytes(), deserialized.getResidentBytes());  
    /**
package org.opensearch.plugin.stats;
                    }  
     * Property 2: AnalyticsBackendNativeMemoryStats serialization round-trip.
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
                }
 * this file be licensed under the Apache-2.0 license or a
            long residentBytes = generateRandomLong();  
            case 2:
        for (long allocated : edgeValues) {  
            for (long resident : edgeValues) {
        Map<String, Object> ab = (Map<String, Object>) root.get("analytics_backend");
     * <b>Validates: Requirements 8.3, 9.1</b>
        long[] edgeValues = { -1L, 0L, Long.MIN_VALUE, Long.MAX_VALUE, 1L, -2L, Long.MAX_VALUE - 1 };
                        "allocatedBytes mismatch on iteration " + i,
    private long generateRandomLong() {  
 * <p>
 * SHALL produce an equivalent object with identical field values.
            long allocatedBytes = generateRandomLong();
        assertEquals(5L, ((Number) ab.get("purge_count")).longValue());
        }
 */  
 * <b>Validates: Requirements 8.3, 9.1</b>  
import org.opensearch.common.xcontent.json.JsonXContent;  
                AnalyticsBackendNativeMemoryStats original = new AnalyticsBackendNativeMemoryStats(allocated, resident, 0);
        Map<String, Object> root = XContentHelper.convertToMap(JsonXContent.jsonXContent, json, false);
            case 3:  
    /**
     * survive serialization round-trip correctly.
                        assertEquals("allocatedBytes mismatch", original.getAllocatedBytes(), deserialized.getAllocatedBytes());  
 * serializing via writeTo(StreamOutput) and deserializing via new AnalyticsBackendNativeMemoryStats(StreamInput)  
        }
    /**
            case 0:  
                try (BytesStreamOutput out = new BytesStreamOutput()) {
                    assertEquals(
            }
            default:
    }  
                }
/**  
        }  
     * For any valid (allocatedBytes, residentBytes) pair including edge values (-1, 0, Long.MAX_VALUE),
}  
public class AnalyticsBackendNativeMemoryStatsPropertyTests extends OpenSearchTestCase {
        String json = Strings.toString(MediaTypeRegistry.JSON, stats);  
                    AnalyticsBackendNativeMemoryStats deserialized = new AnalyticsBackendNativeMemoryStats(in);
 *
     */
 * <b>Feature: native-stats-refactor, Property 2: AnalyticsBackendNativeMemoryStats serialization round-trip</b>  
     * <p>  
                try (StreamInput in = out.bytes().streamInput()) {
                    original.writeTo(out);
            try (BytesStreamOutput out = new BytesStreamOutput()) {
 * For any valid AnalyticsBackendNativeMemoryStats instance (with allocatedBytes and residentBytes values),
     * Generates a random long value biased toward interesting edge cases.  
    }
                        deserialized.getAllocatedBytes()
                        assertEquals("residentBytes mismatch", original.getResidentBytes(), deserialized.getResidentBytes());
        assertEquals(1024L, ((Number) ab.get("allocated_bytes")).longValue());  
                    assertEquals("purgeCount mismatch on iteration " + i, original.getPurgeCount(), deserialized.getPurgeCount());
            case 1:
import java.util.Map;
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;  
    }
 * compatible open source license.
     * writeTo followed by readFrom produces an equal object.
import org.opensearch.core.common.Strings;
        assertEquals(2048L, ((Number) ab.get("resident_bytes")).longValue());
     * <p>  
                return randomLongBetween(Long.MIN_VALUE, Long.MAX_VALUE);  
                return Long.MIN_VALUE;
        for (int i = 0; i < 100; i++) {
        switch (choice) {
     * Property 2 edge cases: serialization round-trip with boundary values.
     * <b>Validates: Requirements 8.3, 9.1</b>
    public void testSerializationRoundTripProperty() throws IOException {  
     */
                return 0L;  
                    );
 * <p>
            }  
    public void testToXContentIncludesPurgeCount() throws Exception {
 * The OpenSearch Contributors require contributions made to  
            AnalyticsBackendNativeMemoryStats original = new AnalyticsBackendNativeMemoryStats(allocatedBytes, residentBytes, purgeCount);  
/*  
     * Verifies that extreme long values (-1, 0, Long.MIN_VALUE, Long.MAX_VALUE)
                return -1L;
                        AnalyticsBackendNativeMemoryStats deserialized = new AnalyticsBackendNativeMemoryStats(in);
                        original.getAllocatedBytes(),  
     * <p>  
                return Long.MAX_VALUE;
 * <p>
import org.opensearch.common.io.stream.BytesStreamOutput;
     */
    }
                    try (StreamInput in = out.bytes().streamInput()) {  
     * <p>  
        int choice = randomIntBetween(0, 9);
                original.writeTo(out);  
        AnalyticsBackendNativeMemoryStats stats = new AnalyticsBackendNativeMemoryStats(1024L, 2048L, 5);
                        assertEquals("purgeCount mismatch", 0L, deserialized.getPurgeCount());
