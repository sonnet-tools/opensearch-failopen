        assertTrue(json.contains("\"details\""));  
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("empty-task", "empty-shard");
    public void testEmptyMetricSerialization() throws IOException {  
        String json = builder.toString();
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(jsonString.contains("\"shardId\":\"shard-1\""));  
        // Verify the toString output is valid JSON  
}
        // Should still contain basic structure even with no data
/*  
        assertNotNull(json);
        assertNotNull(jsonString);
 * this file be licensed under the Apache-2.0 license or a
        metric.recordPrefetch("file2", 1);
        assertTrue(jsonString.contains("\"parentTask\":\"task-456\""));
        String jsonString = metric.toString();
    }
        assertTrue(json.contains("\"details\""));  
 * The OpenSearch Contributors require contributions made to  
public class TieredStoragePerQueryMetricImplJsonTests extends OpenSearchTestCase {
import org.opensearch.common.xcontent.XContentFactory;
 */  
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-123", "shard-0");
import org.opensearch.core.xcontent.XContentBuilder;  
    }
        metric.recordReadAhead("file3", 2);
        // Test XContentBuilder serialization
        assertTrue(json.contains("\"summary\""));
    public void testToStringUsesXContentBuilder() throws IOException {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    public void testToXContentBasic() throws IOException {
        assertTrue(json.contains("\"shardId\":\"shard-0\""));
 */
 *
        assertTrue(json.contains("\"timestamps\""));
        assertTrue(json.contains("\"parentTask\":\"task-123\""));  
    }
package org.opensearch.storage.slowlogs;
        metric.recordFileAccess("file1.block_0_2", false); // miss  
        metric.recordEndTime();  
        metric.recordFileAccess("file1.block_0_1", true);  // hit
        metric.recordPrefetch("prefetch-file", 10);  
        XContentBuilder builder = XContentFactory.jsonBuilder();  
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-456", "shard-1");
 * Test class to verify JSON serialization of TieredStoragePerQueryMetricImpl.  
        String json = builder.toString();  
import java.io.IOException;  
        metric.toXContent(builder, ToXContent.EMPTY_PARAMS);
        // Record some sample data
        // Record some sample data
        metric.recordEndTime();
        assertTrue(json.contains("\"summary\""));
        metric.recordFileAccess("test.block_0_5", true);
        assertTrue(json.contains("\"parentTask\":\"empty-task\""));  
        assertTrue(json.contains("\"shardId\":\"empty-shard\""));
        // Test toString method (which should use XContentBuilder internally)  
        assertTrue(json.contains("\"prefetch\""));  
        assertTrue(json.contains("\"readAhead\""));
import org.opensearch.core.xcontent.ToXContent;
        XContentBuilder builder = XContentFactory.jsonBuilder();
        metric.recordEndTime();
        metric.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertTrue(json.contains("\"fileCache\""));
        // Verify JSON contains expected fields
/**
