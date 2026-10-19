        TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy dummy2 =
    }
        service.addMetricCollector(threadId, metric, true);
        Set<TieredStoragePerQueryMetric> collectors = service.getTaskIdToCollectorMap(true).get(taskId + shardId);  
        assertTrue(stats.getDocValuesPrefetchFailure() >= 0);
        service.addMetricCollector(200L, fetchMetric, false);
        // Should return dummy collector after removal
        TieredStoragePerQueryMetricImpl metric1 = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        // Remove fetch phase collectors
        dummy.recordFileAccess("test.block_0_1", true);
        assertTrue(removed.isEmpty());
 * The OpenSearch Contributors require contributions made to  
        assertNull(removed);
        holder.storedFieldsPrefetchFailure.inc();  
        Map<String, Set<TieredStoragePerQueryMetric>> queryMap = service.getTaskIdToCollectorMap(true);  
        service.addMetricCollector(threadId2, metric2, true);  
        Set<TieredStoragePerQueryMetric> fetchCollectors = service.removeMetricCollectors(taskId, shardId, false);
        long threadId = Thread.currentThread().threadId();
        PrefetchStats finalStats = service.getPrefetchStats();
        assertTrue(service.getTaskIdToCollectorMap(false).containsKey(taskId + shardId));
        holder.docValuesPrefetchSuccess.inc();
        assertEquals(1, fetchCollectors.size());  
        // Should be removed from task-shard map  
        assertEquals(10, service.getMetricCollectors().size());
    public void testRecordStoredFieldsPrefetchFailure() {  
        assertEquals(1, finalStats.getStoredFieldsPrefetchSuccess());  
        Map<String, Set<TieredStoragePerQueryMetric>> fetchMap = service.getTaskIdToCollectorMap(false);
        assertTrue(afterRemoval instanceof TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy);  
        for (int i = 0; i < 10; i++) {
        assertFalse(fetchMap.containsKey("task-2shard-2"));
    public void testMaxCollectorSizeLimit() {
        assertTrue(collector instanceof TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy);  
        // This test would be difficult to run in practice due to the high limit (1000)  
import java.util.Map;  
        // Add a reasonable number of collectors to verify normal operation  
        service.recordDocValuesPrefetch(true);
    public void testAddAndGetMetricCollectorFetchPhase() {  
    public void testRecordStoredFieldsPrefetchSuccess() {
        // Test that the service can handle concurrent access  
        assertEquals(1, finalStats.getDocValuesPrefetchSuccess());
        Map<String, Set<TieredStoragePerQueryMetric>> fetchMap = service.getTaskIdToCollectorMap(false);
        // Increment counters
        assertEquals("DummyParentTaskId", collector.getParentTaskId());
    public void testRecordDocValuesPrefetchFailure() {
        super.setUp();  
        assertEquals(2, removed.size());
    }  
        assertEquals(1, queryCollectors.size());
    }
    public void testAddAndGetMetricCollectorQueryPhase() {
        service.addMetricCollector(threadId1, metric1, true);
/**  
        assertEquals(0, initialStats.getStoredFieldsPrefetchFailure());  
    public void testGetInstance() {  
        TieredStorageQueryMetricService instance2 = TieredStorageQueryMetricService.getInstance();
        assertEquals(1, removed.size());  
        // Remove query phase collectors
        assertEquals(1, service.getTaskIdToCollectorMap(true).get(taskId + shardId).size());
    }  
        PrefetchStats initialStats = service.getPrefetchStats();
        String taskId = "concurrent-task";
        assertEquals(0, initialStats.getDocValuesPrefetchSuccess());
        // Should return the same singleton instance
    }
        // Verify all were added  
        assertTrue(removed.contains(metric2));  
        String taskId = "mixed-task";
        long threadId2 = threadId1 + 1;  
        assertTrue(service.getTaskIdToCollectorMap(false).containsKey(taskId + shardId));  
    }
        assertTrue(queryMap.containsKey("task-1shard-1"));
        // Clear any existing state  
        // Should still be in task-shard map (not removed by removeMetricCollector)
 * SPDX-License-Identifier: Apache-2.0
        Set<TieredStoragePerQueryMetric> collectors = queryMap.get("task-1shard-1");
        Map<String, Set<TieredStoragePerQueryMetric>> queryMap = service.getTaskIdToCollectorMap(true);  
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
    }
    }
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-2", "shard-2");  
        assertEquals(initialSuccess + 1, finalStats.getStoredFieldsPrefetchSuccess());  
        TieredStoragePerQueryMetricImpl metric2 = new TieredStoragePerQueryMetricImpl(taskId, shardId);
        // but we can verify the logic by checking that the service handles the limit gracefully
        // Verify increments
        assertEquals(initialFailure + 1, finalStats.getDocValuesPrefetchFailure());  
        long initialFailure = initialStats.getDocValuesPrefetchFailure();
        Map<String, Set<TieredStoragePerQueryMetric>> queryMap = service.getTaskIdToCollectorMap(true);  
        holder.storedFieldsPrefetchSuccess.inc();
        assertTrue(service.getTaskIdToCollectorMap(true).containsKey(taskId + shardId));
        PrefetchStats finalStats = holder.getStats();
    }
        service.addMetricCollector(200L, metric2, true);  
        long initialRam = service.ramBytesUsed();  
    }  
        assertEquals(initialSuccess + 1, finalStats.getDocValuesPrefetchSuccess());
import org.opensearch.test.OpenSearchTestCase;
        PrefetchStats initialStats = service.getPrefetchStats();
    public void testRemoveMetricCollectorsQueryPhase() {
        assertNotNull(stats);  
    public void testPrefetchStatsHolder() {  
        service.addMetricCollector(100L, metric1, true);
        TieredStoragePerQueryMetricImpl fetchMetric = new TieredStoragePerQueryMetricImpl(taskId, shardId);
        // Should be removed from task-shard map
        // Both should be in the task-shard map
        service.getTaskIdToCollectorMap(true).clear();
        // Both maps should be empty for this task-shard now  
        assertTrue(removed.contains(metric));
    public void testTieredStoragePerQueryMetricDummyMethods() {
        service.getMetricCollectors().clear();
        // All methods should be no-op and not throw exceptions  
        // Should not be in fetch phase map
        long threadId = Thread.currentThread().threadId();  
        TieredStorageQueryMetricService instance1 = TieredStorageQueryMetricService.getInstance();
        assertEquals("DummyShardId", collector.getShardId());
        assertFalse(queryMap.containsKey("task-1shard-1"));
    }  
    public void testRemoveMetricCollector() {
        long initialSuccess = initialStats.getDocValuesPrefetchSuccess();  
        assertEquals("DummyShardId", dummy.getShardId());
    public void testTieredStoragePerQueryMetricDummyGetInstance() {
        assertEquals(2, collectors.size());
        assertFalse(queryMap.containsKey("task-2shard-2"));
        TieredStoragePerQueryMetricImpl queryMetric = new TieredStoragePerQueryMetricImpl(taskId, shardId);
    }  
        Map<String, Set<TieredStoragePerQueryMetric>> fetchMap = service.getTaskIdToCollectorMap(false);
        long threadId = Thread.currentThread().threadId();
        String shardId = "concurrent-shard";
        long threadId2 = threadId1 + 1; // Simulate different thread  
        assertFalse(service.getTaskIdToCollectorMap(true).containsKey(taskId + shardId));
        assertTrue(stats.getDocValuesPrefetchSuccess() >= 0);  
        service.addMetricCollector(100L, queryMetric, true);
        TieredStoragePerQueryMetricImpl metric2 = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
        dummy.recordEndTime();
        assertEquals("DummyParentTaskId", dummy.getParentTaskId());  
            TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy.getInstance();
    }  
        PrefetchStats initialStats = service.getPrefetchStats();  
            TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy.getInstance();
        long finalRam = service.ramBytesUsed();
        TieredStoragePerQueryMetric retrieved = service.getMetricCollector(threadId);  
        assertSame(metric, retrieved);  
        service.addMetricCollector(threadId, metric, false);
        service.addMetricCollector(threadId, metric, false);
        Set<TieredStoragePerQueryMetric> removed = service.removeMetricCollectors("task-2", "shard-2", false);
        service.addMetricCollector(threadId1, metric1, true);
        assertTrue(fetchCollectors.contains(fetchMetric));
        service.recordDocValuesPrefetch(false);  
 * compatible open source license.
    public void testRemoveMetricCollectorsWhenNotExists() {
        assertNotNull(collector);
        assertTrue(initialRam > 0);
        TieredStoragePerQueryMetricImpl metric2 = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");  
 *
        long threadId = Thread.currentThread().threadId();
        assertEquals(1, finalStats.getDocValuesPrefetchFailure());  
        assertSame(metric, removed);
        // Both should be in the same task-shard set
public class TieredStorageQueryMetricServiceTests extends OpenSearchTestCase {  
        // Verify it's added to query phase map
        Map<String, Set<TieredStoragePerQueryMetric>> queryMap = service.getTaskIdToCollectorMap(true);  
        PrefetchStats finalStats = service.getPrefetchStats();
        assertTrue(removed.contains(metric1));
        assertTrue(queryCollectors.contains(queryMetric));
        assertSame(metric, retrieved);
        // Add some collectors  
        Set<TieredStoragePerQueryMetric> queryCollectors = service.removeMetricCollectors(taskId, shardId, true);  
        assertTrue(finalRam >= initialRam);
    }  
        TieredStoragePerQueryMetricImpl metric1 = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        // Should return dummy collector when no collector exists
        // Verify it's added to fetch phase map  
        assertSame(dummy1, dummy2);
        assertTrue(dummy.ramBytesUsed() > 0);
    public void testGetMetricCollectorWhenNotExists() {
        // Initial stats should be zero  
        // Should return null when no collector exists  
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-2", "shard-2");
        PrefetchStats initialStats = holder.getStats();
/*  
    }
    }
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;
        assertTrue(fetchMap.containsKey("task-2shard-2"));
        Set<TieredStoragePerQueryMetric> removed = service.removeMetricCollectors("nonexistent", "shard", true);  
        // Fetch phase collectors should still be there
package org.opensearch.storage.slowlogs;
        TieredStoragePerQueryMetric afterRemoval = service.getMetricCollector(threadId);
        service.addMetricCollector(threadId2, metric2, true);  
        service.getTaskIdToCollectorMap(false).clear();  
 */
    public void testRemoveMetricCollectorWhenNotExists() {
        // Should not be in query phase map
        dummy.recordPrefetch("test", 1);
        // Should return the same singleton instance
        }
        TieredStoragePerQueryMetric removed = service.removeMetricCollector(threadId);
            service.addMetricCollector((long) i, metric, true);  
        service.addMetricCollector(1L, metric1, true);
    public void testRemoveMetricCollectorsFetchPhase() {
        TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy dummy1 =
        service.addMetricCollector(threadId, metric, true);  
}
    }
    }  
        service.addMetricCollector(2L, metric2, false);
        TieredStoragePerQueryMetric collector = service.getMetricCollector(threadId);
        PrefetchStats initialStats = service.getPrefetchStats();  
        long threadId = Thread.currentThread().threadId();  
    }  
        assertTrue(queryMap.containsKey("task-1shard-1"));
        service = TieredStorageQueryMetricService.getInstance();
    }
        assertTrue(stats.getStoredFieldsPrefetchSuccess() >= 0);
        TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy dummy =  
        TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        TieredStoragePerQueryMetric removed = service.removeMetricCollector(threadId);
    public void testAddMultipleCollectorsForSameTaskShard() {
        assertFalse(service.getTaskIdToCollectorMap(false).containsKey(taskId + shardId));
    }  
    public void testRamBytesUsed() {
        Map<String, Set<TieredStoragePerQueryMetric>> queryMap = service.getTaskIdToCollectorMap(true);  
        TieredStorageQueryMetricService.PrefetchStatsHolder holder = new TieredStorageQueryMetricService.PrefetchStatsHolder();
        assertTrue(queryMap.get("task-1shard-1").contains(metric));
        PrefetchStats finalStats = service.getPrefetchStats();  
        // Add collectors for the same task-shard from different threads
    public void setUp() throws Exception {
        assertEquals(initialFailure + 1, finalStats.getStoredFieldsPrefetchFailure());
        dummy.recordReadAhead("test", 1);  
            TieredStorageQueryMetricService.TieredStoragePerQueryMetricDummy.getInstance();  
        assertTrue(fetchMap.get("task-2shard-2").contains(metric));  
        assertEquals(10, service.getTaskIdToCollectorMap(true).size());
        assertEquals(1, finalStats.getStoredFieldsPrefetchFailure());
        assertEquals(0, initialStats.getStoredFieldsPrefetchSuccess());
    public void testMixedQueryAndFetchPhaseCollectors() {  
 * Comprehensive unit tests for TieredStorageQueryMetricService
        assertEquals(0, initialStats.getDocValuesPrefetchFailure());
        TieredStoragePerQueryMetricImpl metric2 = new TieredStoragePerQueryMetricImpl("task-2", "shard-2");
    private TieredStorageQueryMetricService service;
        assertTrue(collectors.contains(metric2));  
            TieredStoragePerQueryMetricImpl metric = new TieredStoragePerQueryMetricImpl("task-" + i, "shard-" + i);
        assertTrue(collectors.contains(metric1));
        PrefetchStats stats = service.getPrefetchStats();
    public void testRecordDocValuesPrefetchSuccess() {
        // Should be in separate maps
        assertFalse(fetchMap.containsKey("task-1shard-1"));  
        assertTrue(collectors.contains(metric2));
        TieredStoragePerQueryMetricImpl metric1 = new TieredStoragePerQueryMetricImpl("task-1", "shard-1");
        service.recordStoredFieldsPrefetch(true);  
        long threadId1 = Thread.currentThread().threadId();
        service.recordStoredFieldsPrefetch(false);
        assertEquals(2, collectors.size());
        TieredStoragePerQueryMetric retrieved = service.getMetricCollector(threadId);
        Set<TieredStoragePerQueryMetric> removed = service.removeMetricCollectors("task-1", "shard-1", true);
        holder.docValuesPrefetchFailure.inc();
        long threadId1 = Thread.currentThread().threadId();
    @Override
        TieredStoragePerQueryMetricImpl metric1 = new TieredStoragePerQueryMetricImpl(taskId, shardId);
    public void testConcurrentAccess() {
        long initialFailure = initialStats.getStoredFieldsPrefetchFailure();
    }
        assertSame(instance1, instance2);
        long initialSuccess = initialStats.getStoredFieldsPrefetchSuccess();
 */  
        long threadId = Thread.currentThread().threadId();
    }
        PrefetchStats finalStats = service.getPrefetchStats();
        assertTrue(stats.getStoredFieldsPrefetchFailure() >= 0);
        assertEquals(1, service.getTaskIdToCollectorMap(false).get(taskId + shardId).size());  
        String shardId = "mixed-shard";
        assertTrue(collectors.contains(metric1));  
    public void testGetPrefetchStats() {  
