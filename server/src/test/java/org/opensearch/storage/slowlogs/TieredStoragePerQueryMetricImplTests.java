        String json = metric.toString();
    }
        assertTrue(json.contains("[5]"));
        assertTrue(json.contains("\"prefetch\""));
        metric.recordPrefetch("file1", 1);  
        metric.recordPrefetch("file1", 2);
        // Record data to create FileCacheStat
    public void testToStringHandlesIOException() {
        metric.recordPrefetch("file1", 10);
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        assertTrue(json.contains("\"blockCount\":1"));
        assertEquals(parentTaskId, metric.getParentTaskId());
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
        // Add comprehensive test data
        assertTrue(json.contains("\"parentTask\":\"task-123\""));
        assertTrue(json.contains("\"prefetchFiles\""));
        assertTrue(json.contains("\"prefetch\""));
        metric.recordReadAhead("file1", 11);
        assertTrue(json.contains("\"blockCount\":1"));
        metric.recordFileAccess("file1.block_0_3", true);  
    public void testConstructor() {
        metric.recordReadAhead("file1", 5);  
    }  
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
        metric.recordEndTime();
        // Add data to create inner class instances
        long finalRam = metric.ramBytesUsed();
        assertTrue(json.contains("\"readAheadFiles\""));  
        metric.recordFileAccess("file1.block_0_1", true);   // file1 hit  
        // Should have timestamps
        metric.recordPrefetch("file2", 1);  
        assertTrue(json.contains("file1"));
        assertTrue(json.contains("file2"));  
        assertTrue(result.length() > 0);
    }  
        // Should have entries for both files
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        metric.recordFileAccess("file1.block_0_1", false);  
        assertTrue(json.contains("\"blocks\":[25,30]"));
        assertTrue(json.contains("file1"));
        String result = metric.toString();  
        // Verify RAM usage calculation includes inner classes  
        // Test various block file name formats - use proper format: filename.extension_blockId_blockNumber
        assertTrue(json.contains("\"total\":1"));
        assertTrue(json.contains("\"details\""));  
    }  
        metric.recordReadAhead("file1", 30);
        assertEquals(shardId, metric.getShardId());
        // Verify internal state through XContent  
    public void testRecordFileAccessHit() {  
        long initialRam = metric.ramBytesUsed();
        metric.recordReadAhead("file1", 5);
        assertTrue(json.contains("\"missBlockCount\":1"));
    }
        metric.recordReadAhead("file3", 1);
        // Should only have 1 unique block  
        metric.recordPrefetch("file1", 15);
    }  
        assertTrue(json.contains("\"hits\":2"));
        metric.recordPrefetch("file1", 1);
 * SPDX-License-Identifier: Apache-2.0
        metric.recordFileAccess("file2.block_0_3", true);   // file2 hit  
        metric.recordPrefetch("prefetch-file", 10);
        // Test block file access miss
        // Verify FileCacheStat XContent structure  
        assertTrue(json.contains("\"shardId\":\"shard-456\""));  
        assertTrue(json.contains("\"blockCount\":2")); // file1 has 2 blocks
    public void testFileCacheStatToXContent() throws IOException {
        assertTrue(json.contains("file2"));  
    public void testRecordReadAheadSameBlockMultipleTimes() {
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
        assertTrue(json.contains("_0cfs"));  
    }  
        metric.recordFileAccess("segments_1.block_0_123", true);
    }
        // Format: filename.extension_blockId_blockNumber where blockNumber is numeric  
        assertTrue(json.contains("\"fileCache\":\"3 hits out of 4 total\""));  
        assertTrue(json.contains("\"total\":3"));  
        // Details section
        // Test block file access hit  
        assertTrue(json.contains("\"fileCache\":\"1 hits out of 2 total\""));
        long startTime = System.currentTimeMillis();
    public void testRamBytesUsed() {
        // Add more data and verify RAM increases
    }  
        assertTrue(json.contains("\"hits\":2"));
        metric.recordFileAccess("file1.block_0_1", true);
        metric.recordFileAccess("_0.cfs_456_789", false);
        metric.recordFileAccess("file1.block_0_2", false);  // file1 miss
        assertTrue(json.contains("[1]"));
        assertTrue(json.contains("\"blockCount\":1")); // file2 has 1 block
        String json = metric.toString();
        assertTrue(json.contains("\"blockCount\":2")); // file1 has 2 blocks
    }
        assertTrue(json.contains("\"blockCount\":1")); // file2 has 1 block
 * compatible open source license.
package org.opensearch.storage.slowlogs;
        String json = metric.toString();
        String json = metric.toString();
        assertTrue(initialRam > 0);
        String json = metric.toString();
        String shardId = "shard-0";  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(json.contains("\"readAhead\""));  
        metric.recordFileAccess("file1.block_0_1", false);
        assertTrue(json.contains("\"timestamps\""));  
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
    public void testPrefetchStatToXContent() throws IOException {
        // Record same block multiple times  
        assertTrue(json.contains("\"blocks\":[5,10,15]"));
        metric.recordReadAhead("file2", 20);
        String json = metric.toString();  
        // Should have 2 hits and 1 miss for total of 3
        assertTrue(json.contains("\"timestamps\""));  
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(json.contains("\"miss\":1"));
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        // Verify complete structure
        String json = metric.toString();
        // Should only have 1 unique block  
        assertTrue(json.contains("\"total\":1"));
        String parentTaskId = "task-123";
        metric.recordReadAhead("file1", 25);  
        assertTrue(json.contains("\"total\":3"));
        metric.recordFileAccess("file1.block_0_2", false);
        metric.recordFileAccess("file1.block_0_1", true);
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        assertTrue(json.contains("\"summary\""));  
        // But only 1 unique hit block and 1 unique miss block  
        assertTrue(json.contains("testdat"));
    public void testRecordFileAccessSameBlockMultipleTimes() {  
        assertTrue(json.contains("\"startTime\""));
public class TieredStoragePerQueryMetricImplTests extends OpenSearchTestCase {
        assertTrue(json.contains("\"blockDetails\""));
        metric.recordFileAccess("file1.block_0_1", true);  
        // Summary section
        metric.recordPrefetch("file2", 1);
        assertTrue(json.contains("\"endTime\":") && !json.contains("\"endTime\":0"));
    }  
        assertTrue(json.contains("\"missBlocks\":[2]"));
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-123", "shard-456");  
import org.opensearch.common.xcontent.XContentFactory;
        metric.recordFileAccess("file1.block_0_2", false);  
        // Should have prefetch entries  
        String json = metric.toString();
 * Comprehensive unit tests for TieredStoragePerQueryMetricImpl.  
        // Test multiple files with different blocks
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
        String json = metric.toString();
        // Record read ahead data
        metric.recordEndTime();  
        metric.recordFileAccess("file1.block_0_3", true);
        metric.recordReadAhead("file1", 10);  
        // Should have read ahead entries  
        String json = builder.toString();
    public void testRecordPrefetchSameBlockMultipleTimes() {
        assertTrue(json.contains("\"hitBlockCount\":2"));
        assertTrue(json.contains("\"miss\":0"));  
 */  
    public void testRecordPrefetch() {
        metric.recordPrefetch("file2", 5);
        assertTrue(json.contains("\"hitBlocks\":[1,3]"));  
        metric.recordFileAccess("test.dat_0_999", true);  
        // Timestamps section
        assertTrue(json.contains("file2block"));  
}
        assertTrue(json.contains("\"blockCount\":3"));
        assertTrue(json.contains("\"hits\":1"));
        XContentBuilder builder = XContentFactory.jsonBuilder();  
        metric.recordPrefetch("file1", 1);
        metric.recordFileAccess("file1.block_0_1", true);
        assertTrue(json.contains("\"hits\":0"));  
    public void testInnerClassRamBytesUsed() {
        metric.recordFileAccess("file1.block_0_2", false);
        metric.toXContent(builder, ToXContent.EMPTY_PARAMS);
        metric.recordFileAccess("file1.block_0_2", false);
        metric.recordFileAccess("file2.block_0_1", true);   // file2 hit
        // Overall stats should be aggregated
        // Should parse file names correctly - filename + first part of extension
    public void testGetFileBlockParsing() {
        assertTrue(json.contains("\"readAhead\""));
        String json = metric.toString();
import org.opensearch.core.xcontent.XContentBuilder;  
        assertTrue(json.contains("\"endTime\""));
import java.io.IOException;  
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
    public void testRecordEndTime() {
    }  
        metric.recordPrefetch("file1", 1);  
        // End time should be after start time and before current time
    public void testRecordFileAccessMultipleFiles() {
        metric.recordFileAccess("file1.block_0_1", true);
        assertTrue(json.contains("\"miss\":1"));  
        // Verify ReadAheadStat XContent structure
        metric.recordPrefetch("file1", 5);  
        // Record same block multiple times - should only count once
    public void testReadAheadStatToXContent() throws IOException {
        String json = metric.toString();
    public void testToXContentStructure() throws IOException {
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
    }  
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
        assertTrue(json.contains("\"fileCache\""));
        assertTrue(json.contains("file1block"));
        // Record prefetch data
        assertTrue(json.contains("\"miss\":1"));
        assertNotNull(result);
    }  
        metric.recordFileAccess("file1.block_0_1", true);  
    }
        String json = metric.toString();
/**
        // Record same block multiple times - should only count once
        // Test prefetch recording
        assertTrue(finalRam >= initialRam);
        metric.recordReadAhead("file3", 1);
        // Verify internal state through XContent
        // Test read ahead recording
 * this file be licensed under the Apache-2.0 license or a
        long newRamUsage = metric.ramBytesUsed();
 */
    public void testRecordReadAhead() {
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
        assertTrue(json.contains("\"missBlockCount\":1"));
    }  
    public void testRecordFileAccessMiss() {
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl(parentTaskId, shardId);
import org.opensearch.core.xcontent.ToXContent;
        assertTrue(json.contains("\"hitBlockCount\":1"));
/*  
        assertTrue(metric.ramBytesUsed() > 0);  
        assertTrue(ramUsage > 0);
    }  
        // toString should not throw exception even if there are issues
        long ramUsage = metric.ramBytesUsed();
        assertTrue(json.contains("segments_1block"));
        long endTime = System.currentTimeMillis();
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
        metric.recordReadAhead("readahead-file", 20);  
 *
        assertTrue(json.contains("\"blockCount\":2"));  
        metric.recordFileAccess("file1.block_0_1", true);
        assertTrue(json.contains("\"endTime\""));
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        String json = metric.toString();  
        // Verify PrefetchStat XContent structure  
        assertTrue(newRamUsage >= ramUsage);  
        // Add some data and verify RAM usage increases
        metric.recordReadAhead("file1", 5);
    }
        assertTrue(json.contains("\"startTime\""));
