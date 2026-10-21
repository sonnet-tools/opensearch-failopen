        assertTrue(json.contains("\"timestamps\""));
        // Should have read ahead entries
    public void testRecordEndTime() {
        metric.recordFileAccess("file1.block_0_1", true);
        // Record same block multiple times - should only count once
        metric.recordFileAccess("file1.block_0_1", false);
        assertTrue(json.contains("\"endTime\""));
        metric.recordPrefetch("file2", 1);
    public void testRecordFileAccessMultipleFiles() {
        // End time should be after start time and before current time
        String json = metric.toString();
        metric.recordReadAhead("file3", 1);
        metric.recordFileAccess("file1.block_0_2", false);
        metric.recordFileAccess("file2.block_0_1", true);   // file2 hit
    }
        String json = metric.toString();
    public void testRecordReadAheadSameBlockMultipleTimes() {
        String json = metric.toString();
        assertEquals(parentTaskId, metric.getParentTaskId());
        assertTrue(json.contains("\"blockCount\":1")); // file2 has 1 block
import org.opensearch.common.xcontent.XContentFactory;
        assertTrue(json.contains("_0cfs"));
 * SPDX-License-Identifier: Apache-2.0
        String json = metric.toString();
    public void testGetFileBlockParsing() {
    }
        metric.recordFileAccess("file1.block_0_1", true);
        // Should have 2 hits and 1 miss for total of 3
        assertTrue(json.contains("\"readAhead\""));
        metric.toXContent(builder, ToXContent.EMPTY_PARAMS);
        // Test block file access miss
        // Record same block multiple times - should only count once
    }
    }
    }
        long initialRam = metric.ramBytesUsed();
        assertTrue(json.contains("\"missBlocks\":[2]"));
        metric.recordReadAhead("file1", 10);
        assertTrue(json.contains("\"blocks\":[25,30]"));
        // Add data to create inner class instances
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        // Add comprehensive test data
        // Verify internal state through XContent
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
package org.opensearch.storage.slowlogs;
        assertTrue(json.contains("\"total\":1"));
        String json = metric.toString();
    public void testInnerClassRamBytesUsed() {
        assertTrue(json.contains("\"miss\":0"));
        metric.recordFileAccess("file1.block_0_1", true);
    public void testRecordPrefetch() {
        metric.recordEndTime();
        // Verify internal state through XContent
        String json = metric.toString();
    }
        metric.recordReadAhead("readahead-file", 20);
        // Test prefetch recording
        assertTrue(json.contains("\"total\":3"));
        assertTrue(json.contains("\"blocks\":[5,10,15]"));
        metric.recordReadAhead("file1", 30);
        String json = metric.toString();
        assertTrue(json.contains("[5]"));
/*
        // Record data to create FileCacheStat
        // Should have prefetch entries
        metric.recordPrefetch("file1", 1);
        metric.recordFileAccess("file1.block_0_1", true);
        metric.recordFileAccess("file1.block_0_1", true);
        assertTrue(json.contains("file1"));
        metric.recordPrefetch("file1", 2);
        assertTrue(json.contains("\"endTime\":") && !json.contains("\"endTime\":0"));
        assertTrue(json.contains("\"hits\":2"));
        assertTrue(json.contains("\"blockCount\":1")); // file2 has 1 block
 * compatible open source license.
        // Add some data and verify RAM usage increases
    }
    public void testReadAheadStatToXContent() throws IOException {
        assertTrue(json.contains("\"miss\":1"));
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl(parentTaskId, shardId);
        // Details section
        XContentBuilder builder = XContentFactory.jsonBuilder();
        String json = metric.toString();
        // toString should not throw exception even if there are issues
    }
    public void testToStringHandlesIOException() {
        // Timestamps section
    public void testConstructor() {
        metric.recordFileAccess("file1.block_0_2", false);
        long endTime = System.currentTimeMillis();
        assertTrue(json.contains("[1]"));
        assertTrue(json.contains("\"total\":3"));
    public void testRamBytesUsed() {
 */
 * The OpenSearch Contributors require contributions made to
    }
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
import org.opensearch.core.xcontent.XContentBuilder;
        assertTrue(json.contains("\"readAheadFiles\""));
        String json = metric.toString();
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        metric.recordPrefetch("file1", 15);
        assertTrue(json.contains("\"startTime\""));
        metric.recordReadAhead("file1", 5);
 */
        assertTrue(metric.ramBytesUsed() > 0);
        String shardId = "shard-0";
        assertTrue(json.contains("\"fileCache\":\"3 hits out of 4 total\""));
        assertTrue(json.contains("file1"));
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        assertTrue(json.contains("testdat"));
        // Verify RAM usage calculation includes inner classes
        long startTime = System.currentTimeMillis();
        // Record prefetch data
        metric.recordFileAccess("file1.block_0_1", true);
        assertTrue(json.contains("\"prefetch\""));
        metric.recordPrefetch("file1", 5);
        assertTrue(json.contains("\"blockCount\":2"));
        long ramUsage = metric.ramBytesUsed();
        metric.recordFileAccess("test.dat_0_999", true);
    public void testRecordReadAhead() {
        assertTrue(json.contains("\"details\""));
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
    }
        metric.recordFileAccess("file1.block_0_3", true);
        assertTrue(json.contains("file2"));
        // Summary section
        assertTrue(json.contains("\"blockCount\":1"));
        // Record same block multiple times
        long finalRam = metric.ramBytesUsed();
        assertTrue(json.contains("\"missBlockCount\":1"));
        metric.recordPrefetch("file1", 1);
        assertTrue(finalRam >= initialRam);
        assertNotNull(result);
        assertTrue(json.contains("\"endTime\""));
        assertEquals(shardId, metric.getShardId());
        metric.recordFileAccess("file1.block_0_2", false);
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(json.contains("\"blockCount\":2")); // file1 has 2 blocks
        assertTrue(ramUsage > 0);
        metric.recordPrefetch("file2", 5);
        // Verify complete structure
import org.opensearch.core.xcontent.ToXContent;
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        // Should only have 1 unique block
        // Should have entries for both files
}
        assertTrue(json.contains("\"hitBlockCount\":1"));
        assertTrue(initialRam > 0);
        metric.recordPrefetch("file2", 1);
        // Should parse file names correctly - filename + first part of extension
    }
        String result = metric.toString();
        metric.recordReadAhead("file3", 1);
        assertTrue(json.contains("\"blockCount\":1"));
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        String json = builder.toString();
        String json = metric.toString();
        // Format: filename.extension_blockId_blockNumber where blockNumber is numeric
        assertTrue(json.contains("\"miss\":1"));
        metric.recordReadAhead("file1", 5);
        metric.recordFileAccess("file1.block_0_1", false);
        assertTrue(json.contains("\"hits\":2"));
        assertTrue(result.length() > 0);
    }
    }
    }
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-123", "shard-456");
        assertTrue(json.contains("\"shardId\":\"shard-456\""));
        assertTrue(json.contains("\"startTime\""));
        String json = metric.toString();
 * Comprehensive unit tests for TieredStoragePerQueryMetricImpl.
    public void testPrefetchStatToXContent() throws IOException {
        metric.recordReadAhead("file1", 25);
        metric.recordReadAhead("file1", 11);
        assertTrue(json.contains("\"blockDetails\""));
import java.io.IOException;
        assertTrue(json.contains("file2block"));
    }
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        // Record read ahead data
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
public class TieredStoragePerQueryMetricImplTests extends OpenSearchTestCase {
    public void testToXContentStructure() throws IOException {
        metric.recordReadAhead("file2", 20);
        assertTrue(json.contains("\"hitBlockCount\":2"));
        assertTrue(json.contains("\"timestamps\""));
        // Should only have 1 unique block
/**
        // But only 1 unique hit block and 1 unique miss block
        // Test read ahead recording
        assertTrue(json.contains("file1block"));
 *
    public void testRecordFileAccessSameBlockMultipleTimes() {
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        metric.recordFileAccess("_0.cfs_456_789", false);
        metric.recordFileAccess("file1.block_0_2", false);  // file1 miss
        // Test multiple files with different blocks
        assertTrue(json.contains("\"missBlockCount\":1"));
    }
        String parentTaskId = "task-123";
    public void testRecordFileAccessMiss() {
        // Test various block file name formats - use proper format: filename.extension_blockId_blockNumber
        assertTrue(json.contains("\"miss\":1"));
        metric.recordPrefetch("file1", 10);
        assertTrue(json.contains("\"fileCache\":\"1 hits out of 2 total\""));
        assertTrue(json.contains("\"blockCount\":3"));
        // Verify PrefetchStat XContent structure
        metric.recordFileAccess("file1.block_0_1", true);
import org.opensearch.test.OpenSearchTestCase;
        String json = metric.toString();
        assertTrue(json.contains("\"readAhead\""));
        String json = metric.toString();
        metric.recordReadAhead("file1", 5);
        assertTrue(json.contains("\"total\":1"));
        metric.recordFileAccess("file2.block_0_3", true);   // file2 hit
        // Verify ReadAheadStat XContent structure
        // Test block file access hit
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        metric.recordPrefetch("file1", 1);
        assertTrue(json.contains("\"hits\":1"));
        assertTrue(json.contains("\"fileCache\""));
    public void testFileCacheStatToXContent() throws IOException {
        assertTrue(json.contains("\"parentTask\":\"task-123\""));
        // Verify FileCacheStat XContent structure
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        long newRamUsage = metric.ramBytesUsed();
        assertTrue(json.contains("\"blockCount\":2")); // file1 has 2 blocks
        metric.recordFileAccess("segments_1.block_0_123", true);
        metric.recordFileAccess("file1.block_0_2", false);
        assertTrue(json.contains("\"prefetch\""));
        metric.recordEndTime();
        // Should have timestamps
        assertTrue(json.contains("\"hits\":0"));
        assertTrue(json.contains("\"prefetchFiles\""));
        assertTrue(newRamUsage >= ramUsage);
        assertTrue(json.contains("\"hitBlocks\":[1,3]"));
        assertTrue(json.contains("segments_1block"));
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        // Add more data and verify RAM increases
        metric.recordFileAccess("file1.block_0_1", true);   // file1 hit
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
    }
        assertTrue(json.contains("file2"));
        metric.recordFileAccess("file1.block_0_3", true);
        // Overall stats should be aggregated
        assertTrue(json.contains("\"summary\""));
        metric.recordPrefetch("file1", 1);
    public void testRecordFileAccessHit() {
        metric.recordPrefetch("prefetch-file", 10);
    public void testRecordPrefetchSameBlockMultipleTimes() {
    }
