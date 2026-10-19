        builder.endObject();  
import org.opensearch.core.common.io.stream.StreamInput;  
 * this file be licensed under the Apache-2.0 license or a
        assertFalse("root object should not exist", json.contains("\"root\""));
            assertEquals(orig.getPeakBytes(), deser.getPeakBytes());
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(-1, deserialized.getNativeResidentBytes());
        original.writeTo(out);  
        assertTrue(deserialized.getPools().isEmpty());  
        NativeAllocatorPoolStats.PoolStats deserialized = new NativeAllocatorPoolStats.PoolStats(in);  
    }  
import java.util.List;  
        assertEquals(123456, deserialized.getAllocatedBytes());  
    public void testSerializationRoundTrip() throws IOException {
    }
        StreamInput in = out.bytes().streamInput();
        assertEquals(234567, deserialized.getPeakBytes());
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
        assertTrue(json.contains("\"limit_bytes\""));
        assertEquals(-1, deserialized.getNativeAllocatedBytes());
        NativeAllocatorPoolStats deserialized = new NativeAllocatorPoolStats(in);  
        NativeAllocatorPoolStats original = new NativeAllocatorPoolStats(-1, -1, List.of());
        NativeAllocatorPoolStats original = new NativeAllocatorPoolStats(10000, 20000, pools);  
import org.opensearch.common.xcontent.json.JsonXContent;
        NativeAllocatorPoolStats stats = new NativeAllocatorPoolStats(4096, 8192, pools);
        );  
        assertEquals(original.getPools().size(), deserialized.getPools().size());
        builder.startObject();
            assertEquals(orig.getAllocatedBytes(), deser.getAllocatedBytes());
        assertTrue(json.contains("\"flight\""));  
        XContentBuilder builder = JsonXContent.contentBuilder();  
            new NativeAllocatorPoolStats.PoolStats("query", 4000, 5000, 6000)
 *
            NativeAllocatorPoolStats.PoolStats deser = deserialized.getPools().get(i);
            new NativeAllocatorPoolStats.PoolStats("flight", 1000, 2000, 3000),  
    }  
        List<NativeAllocatorPoolStats.PoolStats> pools = List.of(
    public void testToXContent() throws IOException {  
/*  
    public void testEmptyPoolsSerialization() throws IOException {
 * The OpenSearch Contributors require contributions made to  
        BytesStreamOutput out = new BytesStreamOutput();
        for (int i = 0; i < pools.size(); i++) {  
        assertTrue(json.contains("\"resident_bytes\""));
        }
            NativeAllocatorPoolStats.PoolStats orig = original.getPools().get(i);
 * SPDX-License-Identifier: Apache-2.0
    }
        StreamInput in = out.bytes().streamInput();
        NativeAllocatorPoolStats deserialized = new NativeAllocatorPoolStats(in);
package org.opensearch.plugin.stats;
        BytesStreamOutput out = new BytesStreamOutput();
}
        NativeAllocatorPoolStats.PoolStats original = new NativeAllocatorPoolStats.PoolStats("datafusion", 123456, 234567, 8589934592L);  
public class NativeAllocatorPoolStatsTests extends OpenSearchTestCase {
        assertTrue(json.contains("\"allocated_bytes\""));  
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertEquals(original.getNativeAllocatedBytes(), deserialized.getNativeAllocatedBytes());
    public void testPoolStatsSerializationRoundTrip() throws IOException {
            assertEquals(orig.getName(), deser.getName());  
import java.io.IOException;
        String json = builder.toString();
        BytesStreamOutput out = new BytesStreamOutput();
 */  
        assertEquals(original.getNativeResidentBytes(), deserialized.getNativeResidentBytes());  
        original.writeTo(out);
        assertEquals(8589934592L, deserialized.getLimitBytes());
            new NativeAllocatorPoolStats.PoolStats("flight", 1024, 1048576, 2147483648L)
        assertEquals("datafusion", deserialized.getName());
            assertEquals(orig.getLimitBytes(), deser.getLimitBytes());  
        List<NativeAllocatorPoolStats.PoolStats> pools = List.of(
import org.opensearch.test.OpenSearchTestCase;  
        StreamInput in = out.bytes().streamInput();
import org.opensearch.core.xcontent.ToXContent;
        );
        assertTrue(json.contains("\"pools\""));
        original.writeTo(out);  
