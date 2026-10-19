import org.opensearch.core.xcontent.XContentBuilder;
    public void testWireFormatRoundTrip() throws IOException {  
        SpillStats stats = new SpillStats("/mnt/spill", 536_870_912_000L, 214_748_364_800L, 1_073_741_824L, 429_496_729_600L, 3L);
        assertEquals(a.hashCode(), b.hashCode());
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        SpillStats differentTotal = new SpillStats("/mnt/spill", 999L, 50L, 25L, 80L, 0L);
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
        try (StreamInput in = out.bytes().streamInput()) {  
 *
package org.opensearch.be.datafusion.stats;
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        BytesStreamOutput out = new BytesStreamOutput();  
import org.opensearch.test.OpenSearchTestCase;  
        assertTrue("missing disk_spill object key: " + json, json.contains("\"disk_spill\":{"));  
        assertNotEquals(a, differentDir);  
        assertTrue(json.contains("\"disk_used_bytes\":1073741824"));
        String json = builder.toString();
import org.opensearch.core.xcontent.ToXContent;
/*  
        SpillStats b = new SpillStats("/mnt/spill", 100L, 50L, 25L, 80L, 0L);
    }  
        builder.endObject();
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(json.contains("\"disk_available_bytes\":214748364800"));  
            SpillStats roundTripped = new SpillStats(in);
    }
            assertEquals(original, roundTripped);
        assertTrue(json.contains("\"directory\":\"\""));
        assertTrue(json.contains("\"disk_reserved_bytes\":429496729600"));
    public void testDisabledStateIsRepresentableWithEmptyDirectoryAndZeroBytes() throws IOException {
        SpillStats disabled = new SpillStats("", 0L, 0L, 0L, 0L, 0L);  
public class SpillStatsTests extends OpenSearchTestCase {
import java.io.IOException;
        assertTrue(json.contains("\"stale_entry_count\":0"));  
        assertEquals(a, b);
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;  
        disabled.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        builder.endObject();  
 */  
        SpillStats differentDir = new SpillStats("/var/tmp", 100L, 50L, 25L, 80L, 0L);  
        SpillStats differentStaleCount = new SpillStats("/mnt/spill", 100L, 50L, 25L, 80L, 5L);
    public void testEquality() {  
        assertTrue(json.contains("\"disk_total_bytes\":536870912000"));
        }
    }
        assertTrue(json.contains("\"disk_total_bytes\":0"));
        SpillStats original = new SpillStats("/mnt/spill", 536_870_912_000L, 214_748_364_800L, 1_073_741_824L, 429_496_729_600L, 7L);
        assertTrue(json.contains("\"stale_entry_count\":3"));  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        assertNotEquals(a, differentTotal);
}
    public void testToXContentRendersAllFields() throws IOException {
        assertNotEquals("stale_entry_count must participate in equality", a, differentStaleCount);
        String json = builder.toString();
        SpillStats a = new SpillStats("/mnt/spill", 100L, 50L, 25L, 80L, 0L);
        assertTrue(json.contains("\"directory\":\"/mnt/spill\""));
        original.writeTo(out);
import org.opensearch.common.xcontent.XContentFactory;
 * The OpenSearch Contributors require contributions made to  
            assertEquals(7L, roundTripped.getStaleEntryCount());  
