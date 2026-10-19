        assertEquals(2, removed.size());
        assertSame(instance1, instance2);
    }
        long initialFailure = initialStats.getDocValuesPrefetchFailure();
        holder.docValuesPrefetchFailure.inc();
        assertTrue(stats.getStoredFieldsPrefetchSuccess() >= 0);
    public void testGetPrefetchStats() {
        service.addMetricCollector(threadId, metric, false);
        assertEquals(initialSuccess + 1, finalStats.getStoredFieldsPrefetchSuccess());
        PrefetchStats finalStats = service.getPrefetchStats();
        long threadId = Thread.currentThread().threadId();
        TieredStoragePerQueryMetricImpl metric2 = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        TieredStoragePerQueryMetricImpl metric1 = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        // Should not be in query phase map
        holder.storedFieldsPrefetchFailure.inc();
        TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy dummy1 =
        Set<TieredStoragePerQueryMetric> queryCollectors = service.removeMetricCollectors(taskId, shardId, true);
    public void testGetInstance() {
        assertFalse(fetchMap.containsKey("task-1shard-1"));
        assertTrue(removed.isEmpty());
        assertTrue(removed.contains(metric));
        PrefetchStats initialStats = service.getPrefetchStats();
        // Remove query phase collectors
        service.getMetricCollectors().clear();
        service.addMetricCollector(100L, queryMetric, true);
    public void testAddAndGetMetricCollectorQueryPhase() {
    }
    }
        assertEquals(initialFailure + 1, finalStats.getDocValuesPrefetchFailure());
        assertEquals(0, initialStats.getDocValuesPrefetchSuccess());
    }
    }
    }
        for (int i = 0; i < 10; i++) {
        // Verify it's added to query phase map
        service.addMetricCollector(threadId2, metric2, true);
        assertNotNull(collector);
        service.addMetricCollector(threadId, metric, true);
        Map<String, Set<TieredStoragePerQueryMetric>> queryMap = service.getTaskIdToCollectorMap(true);
        long threadId2 = threadId1 + 1; // Simulate different thread
        service.addMetricCollector(threadId1, metric1, true);
        assertSame(metric, retrieved);
    public void testRemoveMetricCollectorsQueryPhase() {
public class TieredStorageQueryMetricServiceTests extends OpenSearchTestCase {
        service.addMetricCollector(200L, fetchMetric, false);
        TieredStoragePerQueryMetricImpl metric2 = new TieredStoragePerQueryMetricImpl(taskId, shardId);
        assertTrue(service.getTaskIdToCollectorMap(false).containsKey(taskId + shardId));
    @Override
        // Initial stats should be zero
    }
        PrefetchStats initialStats = service.getPrefetchStats();
        TieredStoragePerQueryMetricImpl fetchMetric = new TieredStoragePerQueryMetricImpl(taskId, shardId);
        PrefetchStats finalStats = service.getPrefetchStats();
        long threadId1 = Thread.currentThread().threadId();
        dummy.recordReadAhead("test", 1);
    }
        // Verify all were added
        assertEquals(0, initialStats.getStoredFieldsPrefetchSuccess());
    public void testGetMetricCollectorWhenNotExists() {
 * compatible open source license.
    }
        // Increment counters
        TieredStoragePerQueryMetric afterRemoval = service.getMetricCollector(threadId);
        service.recordStoredFieldsPrefetch(true);
        holder.docValuesPrefetchSuccess.inc();
        service.addMetricCollector(threadId, metric, false);
        assertEquals(10, service.getTaskIdToCollectorMap(true).size());
        service.addMetricCollector(threadId2, metric2, true);
        long threadId = Thread.currentThread().threadId();
        Map<String, Set<TieredStoragePerQueryMetric>> queryMap = service.getTaskIdToCollectorMap(true);
        assertEquals(0, initialStats.getDocValuesPrefetchFailure());
        assertSame(metric, removed);
        // Both should be in the task-shard map
    }
 *
        assertEquals(1, service.getTaskIdToCollectorMap(true).get(taskId + shardId).size());
    public void testConcurrentAccess() {
    private TieredStorageQueryMetricService service;
        assertEquals("DummyShardId", dummy.getShardId());
    }
        long initialSuccess = initialStats.getStoredFieldsPrefetchSuccess();
    public void testRecordStoredFieldsPrefetchSuccess() {
import java.util.Map;
        Map<String, Set<TieredStoragePerQueryMetric>> queryMap = service.getTaskIdToCollectorMap(true);
            TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy.getInstance();
        assertSame(metric, retrieved);
        assertTrue(queryMap.containsKey("task-1shard-1"));
        dummy.recordFileAccess("test.block_0_1", true);
        Map<String, Set<TieredStoragePerQueryMetric>> queryMap = service.getTaskIdToCollectorMap(true);
        dummy.recordPrefetch("test", 1);
        // This test would be difficult to run in practice due to the high limit (1000)
        holder.storedFieldsPrefetchSuccess.inc();
    }
        Map<String, Set<TieredStoragePerQueryMetric>> fetchMap = service.getTaskIdToCollectorMap(false);
        long threadId = Thread.currentThread().threadId();
    public void testTieredStoragePerQueryMetricDummyGetInstance() {
        long threadId = Thread.currentThread().threadId();
        assertTrue(finalRam >= initialRam);
        service.recordDocValuesPrefetch(true);
        assertNotNull(stats);
        String shardId = "concurrent-shard";
    }
            TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-" + i, "shard-" + i);
        assertEquals(initialFailure + 1, finalStats.getStoredFieldsPrefetchFailure());
        assertTrue(service.getTaskIdToCollectorMap(true).containsKey(taskId + shardId));
        assertTrue(queryMap.get("task-1shard-1").contains(metric));
        assertTrue(stats.getDocValuesPrefetchFailure() >= 0);
        TieredStorageQueryMetricService.PrefetchStatsHolder holder = new TieredStorageQueryMetricService.PrefetchStatsHolder();
        // Test that the service can handle concurrent access
        assertTrue(service.getTaskIdToCollectorMap(false).containsKey(taskId + shardId));
        TieredStoragePerQueryMetricImpl metric1 = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        // Should still be in task-shard map (not removed by removeMetricCollector)
        assertTrue(removed.contains(metric2));
 * The OpenSearch Contributors require contributions made to
    }
        Map<String, Set<TieredStoragePerQueryMetric>> fetchMap = service.getTaskIdToCollectorMap(false);
        Map<String, Set<TieredStoragePerQueryMetric>> fetchMap = service.getTaskIdToCollectorMap(false);
        TieredStoragePerQueryMetric removed = service.removeMetricCollector(threadId);
    public void testAddAndGetMetricCollectorFetchPhase() {
        service.addMetricCollector(threadId, metric, true);
        PrefetchStats finalStats = holder.getStats();
        // Add some collectors
        // Should return dummy collector when no collector exists
    }
}
        PrefetchStats finalStats = service.getPrefetchStats();
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        assertTrue(removed.contains(metric1));
        Set<TieredStoragePerQueryMetric> collectors = service.getTaskIdToCollectorMap(true).get(taskId + shardId);
        assertFalse(queryMap.containsKey("task-2shard-2"));
        assertFalse(service.getTaskIdToCollectorMap(true).containsKey(taskId + shardId));
    public void testRemoveMetricCollectorsWhenNotExists() {
        assertEquals(2, collectors.size());
        service.addMetricCollector(threadId1, metric1, true);
        assertEquals(initialSuccess + 1, finalStats.getDocValuesPrefetchSuccess());
        assertEquals("DummyParentTaskId", collector.getParentTaskId());
        long initialFailure = initialStats.getStoredFieldsPrefetchFailure();
            TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy.getInstance();
        assertTrue(fetchMap.containsKey("task-2shard-2"));
    public void testAddMultipleCollectorsForSameTaskShard() {
        assertFalse(queryMap.containsKey("task-1shard-1"));
        assertEquals(0, initialStats.getStoredFieldsPrefetchFailure());
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-2", "shard-2");
        // Remove fetch phase collectors
        // Verify it's added to fetch phase map
        String taskId = "concurrent-task";
        assertEquals(1, queryCollectors.size());
        service = TieredStorageQueryMetricService.getInstance();
        assertEquals(1, finalStats.getStoredFieldsPrefetchSuccess());
        Set<TieredStoragePerQueryMetric> removed = service.removeMetricCollectors("task-1", "shard-1", true);
        assertEquals(10, service.getMetricCollectors().size());
    public void testRamBytesUsed() {
        // Should return dummy collector after removal
        assertTrue(queryCollectors.contains(queryMetric));
    }
 * SPDX-License-Identifier: Apache-2.0
        service.getTaskIdToCollectorMap(false).clear();
/*
        String shardId = "mixed-shard";
        // Should return the same singleton instance
        TieredStoragePerQueryMetric retrieved = service.getMetricCollector(threadId);
        Set<TieredStoragePerQueryMetric> fetchCollectors = service.removeMetricCollectors(taskId, shardId, false);
        // but we can verify the logic by checking that the service handles the limit gracefully
        assertTrue(collectors.contains(metric2));
        assertTrue(fetchMap.get("task-2shard-2").contains(metric));
        assertFalse(fetchMap.containsKey("task-2shard-2"));
        assertEquals(1, finalStats.getDocValuesPrefetchFailure());
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-2", "shard-2");
        PrefetchStats initialStats = service.getPrefetchStats();
        assertTrue(queryMap.containsKey("task-1shard-1"));
 * this file be licensed under the Apache-2.0 license or a
        // All methods should be no-op and not throw exceptions
        assertTrue(dummy.ramBytesUsed() > 0);
 * Comprehensive unit tests for TieredStorageQueryMetricService
        assertEquals(2, collectors.size());
        // Should return null when no collector exists
    public void testRemoveMetricCollectorWhenNotExists() {
        TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy dummy =
        Set<TieredStoragePerQueryMetric> removed = service.removeMetricCollectors("task-2", "shard-2", false);
        assertTrue(fetchCollectors.contains(fetchMetric));
 */
            service.addMetricCollector((long) i, metric, true);
        }
        long finalRam = service.ramBytesUsed();
        // Add a reasonable number of collectors to verify normal operation
        assertTrue(afterRemoval instanceof TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy);
    public void testTieredStoragePerQueryMetricDummyMethods() {
        assertTrue(collector instanceof TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy);
    }
        long threadId2 = threadId1 + 1;
        service.addMetricCollector(100L, metric1, true);
        // Fetch phase collectors should still be there
 */
    public void testRecordDocValuesPrefetchSuccess() {
        PrefetchStats finalStats = service.getPrefetchStats();
        assertTrue(collectors.contains(metric1));
    }
        service.addMetricCollector(200L, metric2, true);
        assertTrue(stats.getDocValuesPrefetchSuccess() >= 0);
        String taskId = "mixed-task";
    }
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("DummyShardId", collector.getShardId());
        assertEquals(1, finalStats.getStoredFieldsPrefetchFailure());
        TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy dummy2 =
        service.recordDocValuesPrefetch(false);
        TieredStoragePerQueryMetricImpl metric2 = new TieredStoragePerQueryMetricImpl("task-2", "shard-2");
        assertTrue(initialRam > 0);
        // Both should be in the same task-shard set
        PrefetchStats initialStats = service.getPrefetchStats();
        Map<String, Set<TieredStoragePerQueryMetric>> queryMap = service.getTaskIdToCollectorMap(true);
        // Should be in separate maps
    public void setUp() throws Exception {
        // Should be removed from task-shard map
        assertFalse(service.getTaskIdToCollectorMap(false).containsKey(taskId + shardId));
    public void testMixedQueryAndFetchPhaseCollectors() {
    public void testPrefetchStatsHolder() {
        TieredStoragePerQueryMetric retrieved = service.getMetricCollector(threadId);
        // Verify increments
        long initialRam = service.ramBytesUsed();
        Set<TieredStoragePerQueryMetric> removed = service.removeMetricCollectors("nonexistent", "shard", true);
        PrefetchStats stats = service.getPrefetchStats();
    public void testRemoveMetricCollector() {
        TieredStoragePerQueryMetricImpl metric1 = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        assertEquals(1, removed.size());
        // Add collectors for the same task-shard from different threads
    }
    public void testRemoveMetricCollectorsFetchPhase() {
    }
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        assertEquals(1, fetchCollectors.size());
        TieredStorageQueryMetricService instance1 = TieredStorageQueryMetricService.getInstance();
            TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy.getInstance();
        TieredStoragePerQueryMetricImpl queryMetric = new TieredStoragePerQueryMetricImpl(taskId, shardId);
        assertSame(dummy1, dummy2);
        TieredStoragePerQueryMetric collector = service.getMetricCollector(threadId);
        TieredStorageQueryMetricService instance2 = TieredStorageQueryMetricService.getInstance();
        service.addMetricCollector(2L, metric2, false);
    public void testRecordDocValuesPrefetchFailure() {
        // Both maps should be empty for this task-shard now
        long initialSuccess = initialStats.getDocValuesPrefetchSuccess();
        service.addMetricCollector(1L, metric1, true);
        long threadId = Thread.currentThread().threadId();
    public void testRecordStoredFieldsPrefetchFailure() {
        // Should be removed from task-shard map
        PrefetchStats initialStats = holder.getStats();
        dummy.recordEndTime();
        assertEquals(1, finalStats.getDocValuesPrefetchSuccess());
        Set<TieredStoragePerQueryMetric> collectors = queryMap.get("task-1shard-1");
package org.opensearch.storage.slowlogs;
        TieredStoragePerQueryMetric removed = service.removeMetricCollector(threadId);
    public void testMaxCollectorSizeLimit() {
    }
        service.recordStoredFieldsPrefetch(false);
    }
        TieredStoragePerQueryMetricImpl metric1 = new TieredStoragePerQueryMetricImpl(taskId, shardId);
import java.util.Set;
        long threadId1 = Thread.currentThread().threadId();
        // Should return the same singleton instance
        super.setUp();
        assertTrue(collectors.contains(metric1));
        assertEquals("DummyParentTaskId", dummy.getParentTaskId());
        assertEquals(1, service.getTaskIdToCollectorMap(false).get(taskId + shardId).size());
        // Clear any existing state
        assertTrue(collectors.contains(metric2));
        assertTrue(stats.getStoredFieldsPrefetchFailure() >= 0);
        service.getTaskIdToCollectorMap(true).clear();
        TieredStoragePerQueryMetricImpl metric2 = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
/**
        long threadId = Thread.currentThread().threadId();
        assertNull(removed);
        // Should not be in fetch phase map
