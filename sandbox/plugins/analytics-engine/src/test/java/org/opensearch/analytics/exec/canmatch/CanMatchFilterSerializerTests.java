        // Write a fake payload with format version 99  
        LongRange ts = (LongRange) result.get(0);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1720000000000L, decoded.min());  
    public void testNullListSerializesToZeroBytes() throws IOException {
            byte[] bytes = org.opensearch.core.common.bytes.BytesReference.toBytes(out.bytes());
            out.writeVInt(20);  // byteLength
        assertEquals(1, result.size());
                filterOut.writeLong(42);  
            // Filter 1: unknown type
                filterOut.writeString("some_column");
                byte[] filterBytes = org.opensearch.core.common.bytes.BytesReference.toBytes(filterOut.bytes());
    public void testDeserializeNullReturnsEmptyList() throws IOException {  
 * compatible open source license.
        byte[] bytes = CanMatchFilterSerializer.serialize(null);  
        LongRange b = new LongRange("col", 10, 20);
    }
        List<CanMatchFilter> result = CanMatchFilterSerializer.deserialize(bytes);  
        LongRange c = new LongRange("col", 10, 21);  
        assertTrue(result.isEmpty());
        assertEquals(a.hashCode(), b.hashCode());  
        List<CanMatchFilter> result = CanMatchFilterSerializer.deserialize(null);
            out.writeVInt(2);   // 2 filters  
                byte[] filterBytes = org.opensearch.core.common.bytes.BytesReference.toBytes(filterOut.bytes());
            byte[] bytes = org.opensearch.core.common.bytes.BytesReference.toBytes(out.bytes());
    public void testRecordEquality() {  
                int filterLen = filterOut.size();
import java.io.IOException;
        byte[] bytes = CanMatchFilterSerializer.serialize(originals);  
 * this file be licensed under the Apache-2.0 license or a
            // Filter 2: valid LongRange
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            // write some garbage for the filter
        assertNotEquals(a, c);
    public void testEmptyListSerializesToZeroBytes() throws IOException {  
                filterOut.writeString("@timestamp");
    public void testRoundTripSingleFilter() throws IOException {  
            // Unknown filter skipped, valid filter preserved
    }
package org.opensearch.analytics.exec.canmatch;
 * The OpenSearch Contributors require contributions made to  
        LongRange a = new LongRange("col", 10, 20);
            assertEquals(1, result.size());
        byte[] bytes = CanMatchFilterSerializer.serialize(List.of(original));  
    }  
            try (BytesStreamOutput filterOut = new BytesStreamOutput()) {  
        List<CanMatchFilter> originals = List.of(
        assertEquals("@timestamp", ts.column());
        LongRange original = new LongRange("@timestamp", 1720000000000L, Long.MAX_VALUE);
/*  
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(80L, port.min());
        assertEquals(1720600000000L, ts.max());
                out.writeBytes(filterBytes, 0, filterLen);
                filterOut.writeLong(1000L);
import java.util.List;
public class CanMatchFilterSerializerTests extends OpenSearchTestCase {
            List<CanMatchFilter> result = CanMatchFilterSerializer.deserialize(trimmed);  
    }
            int length = bytes.length;
                filterOut.writeLong(2000L);  
    public void testMinMaxBoundaries() throws IOException {
            try (BytesStreamOutput filterOut = new BytesStreamOutput()) {
        byte[] bytes = CanMatchFilterSerializer.serialize(List.of(original));
            System.arraycopy(bytes, 0, trimmed, 0, length);
    }  
        );
    }
    public void testUnknownFormatVersionReturnsEmptyList() throws IOException {
        assertEquals(1, result.size());  
        assertEquals(2, result.size());  
                out.writeVInt(filterLen);  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(0, bytes.length);
                filterOut.writeString("FutureType");
            List<CanMatchFilter> result = CanMatchFilterSerializer.deserialize(bytes);  
            out.writeVInt(99);  // unknown version
        assertEquals("@timestamp", decoded.column());
        LongRange decoded = (LongRange) result.get(0);
            }
    }
        List<CanMatchFilter> result = CanMatchFilterSerializer.deserialize(bytes);
 *
        assertEquals(Long.MAX_VALUE, decoded.max());
            assertEquals(2000L, decoded.max());  
        }
}
        // Manually build: [FORMAT_VERSION=1, count=2, filter1=unknown, filter2=LongRange]  
            out.writeVInt(1);   // 1 filter  
        assertEquals(Long.MIN_VALUE, decoded.min());
            assertTrue(result.isEmpty());
        byte[] bytes = CanMatchFilterSerializer.serialize(List.of());
        assertTrue(result.isEmpty());  
    public void testRoundTripMultipleFilters() throws IOException {
    public void testDeserializeEmptyBytesReturnsEmptyList() throws IOException {
            out.writeLong(0);
                int filterLen = filterOut.size();
        assertEquals("port", port.column());
        assertEquals(a, b);
    }  
            out.writeString("LongRange");  
            out.writeLong(100);  
            LongRange decoded = (LongRange) result.get(0);  
    }
        LongRange port = (LongRange) result.get(1);  
        LongRange original = new LongRange("col", Long.MIN_VALUE, Long.MAX_VALUE);
            assertEquals(1000L, decoded.min());
                out.writeVInt(filterLen);  
            new LongRange("port", 80L, 443L)
        assertEquals(1720000000000L, ts.min());  
            new LongRange("@timestamp", 1720000000000L, 1720600000000L),  
            assertEquals("@timestamp", decoded.column());
                filterOut.writeString("LongRange");  
    }
            out.writeVInt(1);   // FORMAT_VERSION
        assertEquals(443L, port.max());  
        LongRange decoded = (LongRange) result.get(0);
        }
            out.writeString("col");
        assertEquals(Long.MAX_VALUE, decoded.max());  
            byte[] trimmed = new byte[length];  
                out.writeBytes(filterBytes, 0, filterLen);
        assertEquals(0, bytes.length);
    public void testUnknownTypeStringIsSkipped() throws IOException {
        assertTrue(result.get(0) instanceof LongRange);  
        List<CanMatchFilter> result = CanMatchFilterSerializer.deserialize(new byte[0]);
            }
        List<CanMatchFilter> result = CanMatchFilterSerializer.deserialize(bytes);
 */  
