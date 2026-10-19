 */  
 * compatible open source license.
        XContentBuilder builder = JsonXContent.contentBuilder();
    public void testDefaultsIoUsageStats() {  
    }
import org.opensearch.common.xcontent.json.JsonXContent;
 *
/*  
        assertEquals(response, "{\"max_io_utilization_percent\":\"20.0\"}");
 * The OpenSearch Contributors require contributions made to  
        assertEquals(ioUsageStats.getIoUtilisationPercent(), 10.0, 0);
        String response = builder.toString();
        ioUsageStats.setIoUtilisationPercent(20);
    public void setUp() throws Exception {
import org.opensearch.core.xcontent.ToXContent;
public class IoUsageStatsTests extends OpenSearchTestCase {  
package org.opensearch.node;
    public void testUpdateIoUsageStats() {
    }
import org.opensearch.core.xcontent.XContentBuilder;  
        assertEquals(response, "{\"max_io_utilization_percent\":\"10.0\"}");
        String expected = "IO utilization percent: " + String.format(Locale.ROOT, "%.1f", 10.0);
 * SPDX-License-Identifier: Apache-2.0
    }
    }
        super.setUp();
        builder = JsonXContent.contentBuilder();
import org.opensearch.test.OpenSearchTestCase;
        expected = "IO utilization percent: " + String.format(Locale.ROOT, "%.1f", 20.0);
        assertEquals(ioUsageStats.getIoUtilisationPercent(), 20.0, 0);
        builder = ioUsageStats.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        builder = ioUsageStats.toXContent(builder, ToXContent.EMPTY_PARAMS);
        ioUsageStats = new IoUsageStats(10);  
    @Override  
import java.io.IOException;  
    public void testIoUsageStatsToString() {
    }
        ioUsageStats.setIoUtilisationPercent(20);  
        assertEquals(expected, ioUsageStats.toString());  
        response = builder.toString();  
    public void testIoUsageStats() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    IoUsageStats ioUsageStats;
        assertEquals(ioUsageStats.getIoUtilisationPercent(), 10.0, 0);
        assertEquals(expected, ioUsageStats.toString());  
import java.util.Locale;
}
        ioUsageStats.setIoUtilisationPercent(20);  
